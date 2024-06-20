function DisplayErrorMessage() {
if (Le(m_nLastError,-1)) {
return;
}
if (Eq(typeof(m_cErrorInChild),'undefined') || Empty(m_cErrorInChild)) {
var l_cErrorMsg = m_cLastMsgError;
if (Eq(l_cErrorMsg,'')) {
if (Eq(m_nLastError,1)) {
l_cErrorMsg='MSG_OBBLI_FIELD';
} else if (Eq(m_nLastError,2)) {
l_cErrorMsg='MSG_VALUE_NOT_ALLOWED';
} else if (Eq(m_nLastError,3)) {
l_cErrorMsg='MSG_VALUE_NOT_ALLOWED';
} else {
l_cErrorMsg='MSG_UNSPEC_ERROR';
}
}
if (Eq(m_nLastError,1)) {
WindowAlert(Translate(m_cObblFieldName)+' : '+Translate(l_cErrorMsg));
} else {
if (Eq(l_cErrorMsg,'MSG_VALUE_NOT_ALLOWED') && Ne(m_cLastWorkVarErrorMsg,'')) {
WindowAlert(Translate(m_cLastWorkVarErrorMsg)+': '+Translate(l_cErrorMsg));
} else {
WindowAlert(Translate(l_cErrorMsg));
}
}
if (Ne(m_cLastWorkVarError,'')) {
SetControlFocus(m_cLastWorkVarError);
SetErrorField(m_cLastWorkVarError,true);
m_cLastWorkVarError='';
}
} else if (Ne(typeof('DisplayErrorMessage_'+m_cErrorInChild),'undefined')) {
DisplayErrorMessageOfChild(m_cErrorInChild);
}
}
function ResetErrorVars() {
m_nLastError=0;
m_cLastMsgError='';
m_cLastWorkVarError='';
m_cLastWorkVarErrorMsg='';
m_cErrorInChild='';
}
function EnableControlsUnderCondition() {
}
function EnableControlsUnderCondition_WhenReady(inherit) {
if (Eq(inherit,null)) {
inherit=true;
}
var l_bEnabled = true;
// * --- Area Manuale = UI - Enable Controls Init
// * --- Fine Area Manuale
if (window.Z && window.Z.Tabs) {
Z.Tabs.Get('tabs').CheckTabStrip();
}
l_bEnabled= ! (Eq(w_QADV_DOMANDA07,6)) || IsDisabledByStateDriver('QADV_DOMANDA08');
SetDisabled('OUKEHIZPFY',l_bEnabled);
l_bEnabled= ! (false) || IsDisabledByStateDriver('QADV_FLGCOMPLETO');
SetDisabled('RVNBZEITUY',l_bEnabled);
if (IsDisabledByStateDriver('Questionario')) {
DisableInputsInContainer(Ctrl('CJTHKOMYJE'),true);
}
LibJavascript.forEachItem(m_FoundlingEditExpression,i_body_0)
function i_body_0(child){
child();
}
DisableUI();
if (inherit && IsWndAccessible(m_oFather) &&  ! (m_oFather.m_bCalculating)) {
m_oFather.EnableControlsUnderCondition();
}
HideControlsUnderCondition();
ObligatoryControlsUnderCondition();
ExpandCollapseBoxesUnderCondition();
// * --- Area Manuale = UI - Enable Controls End
// * --- Fine Area Manuale
}
function ObligatoryControlsUnderCondition() {
var l_bObligatory = true;
SetObligatory(Ctrl('HOWAZKTGQK'),Eq(w_QADV_DOMANDA03_3,'S') || IsObligatoryByStateDriver('QADV_MOTIVO03'));
SetObligatory(Ctrl('NAOHLRJFKW'),Eq(w_QADV_DOMANDA05,6) || IsObligatoryByStateDriver('QADV_MOTIVO05'));
SetObligatory(Ctrl('IPNCGLSXHQ'),Eq(w_QADV_DOMANDA04_4,'S') || IsObligatoryByStateDriver('QADV_MOTIVO04'));
}
function SetDynamicClasses() {
var c;
}
function SetDynamicTooltip() {
var c;
}
function Set_QADV_DOMANDA01(ctrlValue,kmode,e) {
if (Ne(w_QADV_DOMANDA01,ctrlValue)) {
var ctl = _GetCtl(e,'QISCOZIXKK');
if (_tracker.goon(ctl,ctrlValue)) {
w_QADV_DOMANDA01=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QISCOZIXKK',0);
DoUpdate(l_bResult);
if(c=Ctrl('QISCOZIXKK')) selectCombo(c,w_QADV_DOMANDA01,'N')
return l_bResult;
} else {
ctl.value=WtH('','N',2,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_QADV_DOMANDA02(ctrlValue,kmode,e) {
if (Ne(w_QADV_DOMANDA02,ctrlValue)) {
var ctl = _GetCtl(e,'WBZKOKXYXU');
if (_tracker.goon(ctl,ctrlValue)) {
w_QADV_DOMANDA02=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('WBZKOKXYXU',0);
DoUpdate(l_bResult);
if(c=Ctrl('WBZKOKXYXU')) selectCombo(c,w_QADV_DOMANDA02,'N')
return l_bResult;
} else {
ctl.value=WtH('','N',2,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_QADV_DOMANDA03(ctrlValue,kmode,e) {
if (Ne(w_QADV_DOMANDA03,ctrlValue)) {
var ctl = _GetCtl(e,'FQNOXMHNDA');
if (_tracker.goon(ctl,ctrlValue)) {
w_QADV_DOMANDA03=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FQNOXMHNDA',0);
DoUpdate(l_bResult);
if(c=Ctrl('FQNOXMHNDA')) selectCombo(c,w_QADV_DOMANDA03,'N')
return l_bResult;
} else {
ctl.value=WtH('','N',2,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_QADV_DOMANDA03_1(ctrlValue,kmode,e) {
if (Ne(w_QADV_DOMANDA03_1,ctrlValue)) {
var ctl = _GetCtl(e,'ZZAXIZEFKI');
if (_tracker.goon(ctl,ctrlValue)) {
w_QADV_DOMANDA03_1=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ZZAXIZEFKI',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_QADV_DOMANDA03_2(ctrlValue,kmode,e) {
if (Ne(w_QADV_DOMANDA03_2,ctrlValue)) {
var ctl = _GetCtl(e,'YMMKALGQQM');
if (_tracker.goon(ctl,ctrlValue)) {
w_QADV_DOMANDA03_2=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YMMKALGQQM',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_QADV_DOMANDA03_3(ctrlValue,kmode,e) {
if (Ne(w_QADV_DOMANDA03_3,ctrlValue)) {
var ctl = _GetCtl(e,'TIXQDCBYJJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_QADV_DOMANDA03_3=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('TIXQDCBYJJ',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_QADV_MOTIVO03(ctrlValue,kmode,e) {
if (Ne(w_QADV_MOTIVO03,ctrlValue)) {
var ctl = _GetCtl(e,'HOWAZKTGQK');
if (_tracker.goon(ctl,ctrlValue)) {
w_QADV_MOTIVO03=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HOWAZKTGQK',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','M',10,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_QADV_DOMANDA04(ctrlValue,kmode,e) {
if (Ne(w_QADV_DOMANDA04,ctrlValue)) {
var ctl = _GetCtl(e,'ATNBYAZJII');
if (_tracker.goon(ctl,ctrlValue)) {
w_QADV_DOMANDA04=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ATNBYAZJII',0);
DoUpdate(l_bResult);
if(c=Ctrl('ATNBYAZJII')) selectCombo(c,w_QADV_DOMANDA04,'N')
return l_bResult;
} else {
ctl.value=WtH('','N',2,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_QADV_DOMANDA04_1(ctrlValue,kmode,e) {
if (Ne(w_QADV_DOMANDA04_1,ctrlValue)) {
var ctl = _GetCtl(e,'KBUHMXAJEA');
if (_tracker.goon(ctl,ctrlValue)) {
w_QADV_DOMANDA04_1=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('KBUHMXAJEA',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_QADV_DOMANDA04_2(ctrlValue,kmode,e) {
if (Ne(w_QADV_DOMANDA04_2,ctrlValue)) {
var ctl = _GetCtl(e,'TJQKPGPGYX');
if (_tracker.goon(ctl,ctrlValue)) {
w_QADV_DOMANDA04_2=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('TJQKPGPGYX',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_QADV_DOMANDA04_3(ctrlValue,kmode,e) {
if (Ne(w_QADV_DOMANDA04_3,ctrlValue)) {
var ctl = _GetCtl(e,'SAFBZXXNOG');
if (_tracker.goon(ctl,ctrlValue)) {
w_QADV_DOMANDA04_3=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SAFBZXXNOG',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_QADV_DOMANDA04_4(ctrlValue,kmode,e) {
if (Ne(w_QADV_DOMANDA04_4,ctrlValue)) {
var ctl = _GetCtl(e,'AJOULWEBQJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_QADV_DOMANDA04_4=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('AJOULWEBQJ',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_QADV_DOMANDA05(ctrlValue,kmode,e) {
if (Ne(w_QADV_DOMANDA05,ctrlValue)) {
var ctl = _GetCtl(e,'GQFWKUDIZX');
if (_tracker.goon(ctl,ctrlValue)) {
w_QADV_DOMANDA05=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('GQFWKUDIZX',0);
DoUpdate(l_bResult);
if(c=Ctrl('GQFWKUDIZX')) selectCombo(c,w_QADV_DOMANDA05,'N')
return l_bResult;
} else {
ctl.value=WtH('','N',2,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_QADV_MOTIVO05(ctrlValue,kmode,e) {
if (Ne(w_QADV_MOTIVO05,ctrlValue)) {
var ctl = _GetCtl(e,'NAOHLRJFKW');
if (_tracker.goon(ctl,ctrlValue)) {
w_QADV_MOTIVO05=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NAOHLRJFKW',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','M',10,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_QADV_DOMANDA06(ctrlValue,kmode,e) {
if (Ne(w_QADV_DOMANDA06,ctrlValue)) {
var ctl = _GetCtl(e,'NXAIQESKYE');
if (_tracker.goon(ctl,ctrlValue)) {
w_QADV_DOMANDA06=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NXAIQESKYE',0);
DoUpdate(l_bResult);
if(c=Ctrl('NXAIQESKYE')) selectCombo(c,w_QADV_DOMANDA06,'N')
return l_bResult;
} else {
ctl.value=WtH('','N',2,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_QADV_DOMANDA07(ctrlValue,kmode,e) {
if (Ne(w_QADV_DOMANDA07,ctrlValue)) {
var ctl = _GetCtl(e,'TANVFQSZEQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_QADV_DOMANDA07=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('TANVFQSZEQ',0);
DoUpdate(l_bResult);
if(c=Ctrl('TANVFQSZEQ')) selectCombo(c,w_QADV_DOMANDA07,'N')
return l_bResult;
} else {
ctl.value=WtH('','N',2,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_QADV_DOMANDA08(ctrlValue,kmode,e) {
if (Ne(w_QADV_DOMANDA08,ctrlValue)) {
var ctl = _GetCtl(e,'OUKEHIZPFY');
if (_tracker.goon(ctl,ctrlValue)) {
w_QADV_DOMANDA08=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('OUKEHIZPFY',0);
DoUpdate(l_bResult);
if(c=Ctrl('OUKEHIZPFY')) selectCombo(c,w_QADV_DOMANDA08,'N')
return l_bResult;
} else {
ctl.value=WtH('','N',2,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_QADV_DOMANDA09(ctrlValue,kmode,e) {
if (Ne(w_QADV_DOMANDA09,ctrlValue)) {
var ctl = _GetCtl(e,'CTLRUBZHIS');
if (_tracker.goon(ctl,ctrlValue)) {
w_QADV_DOMANDA09=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CTLRUBZHIS',0);
DoUpdate(l_bResult);
if(c=Ctrl('CTLRUBZHIS')) selectCombo(c,w_QADV_DOMANDA09,'N')
return l_bResult;
} else {
ctl.value=WtH('','N',2,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_QADV_DOMANDA10(ctrlValue,kmode,e) {
if (Ne(w_QADV_DOMANDA10,ctrlValue)) {
var ctl = _GetCtl(e,'BJMTLOURHC');
if (_tracker.goon(ctl,ctrlValue)) {
w_QADV_DOMANDA10=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BJMTLOURHC',0);
DoUpdate(l_bResult);
if(c=Ctrl('BJMTLOURHC')) selectCombo(c,w_QADV_DOMANDA10,'N')
return l_bResult;
} else {
ctl.value=WtH('','N',2,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_QADV_DOMANDA11(ctrlValue,kmode,e) {
if (Ne(w_QADV_DOMANDA11,ctrlValue)) {
var ctl = _GetCtl(e,'YOEMCDHBCJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_QADV_DOMANDA11=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YOEMCDHBCJ',0);
DoUpdate(l_bResult);
if(c=Ctrl('YOEMCDHBCJ')) selectCombo(c,w_QADV_DOMANDA11,'N')
return l_bResult;
} else {
ctl.value=WtH('','N',2,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_QADV_DOMANDA12(ctrlValue,kmode,e) {
if (Ne(w_QADV_DOMANDA12,ctrlValue)) {
var ctl = _GetCtl(e,'RGKOIXTSHJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_QADV_DOMANDA12=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RGKOIXTSHJ',0);
DoUpdate(l_bResult);
if(c=Ctrl('RGKOIXTSHJ')) selectCombo(c,w_QADV_DOMANDA12,'N')
return l_bResult;
} else {
ctl.value=WtH('','N',2,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_QADV_FLGCOMPLETO(ctrlValue,kmode,e) {
if (Ne(w_QADV_FLGCOMPLETO,ctrlValue)) {
var ctl = _GetCtl(e,'RVNBZEITUY');
if (_tracker.goon(ctl,ctrlValue)) {
w_QADV_FLGCOMPLETO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RVNBZEITUY',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_QADV_MOTIVO04(ctrlValue,kmode,e) {
if (Ne(w_QADV_MOTIVO04,ctrlValue)) {
var ctl = _GetCtl(e,'IPNCGLSXHQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_QADV_MOTIVO04=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('IPNCGLSXHQ',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','M',10,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Calculate() {
var l_bTmpRes;
var l_bResult = true;
m_bCalculating=true;
if ((Ne(o_QADV_DOMANDA01,w_QADV_DOMANDA01)) || (Ne(o_QADV_DOMANDA02,w_QADV_DOMANDA02)) || (Ne(o_QADV_DOMANDA03,w_QADV_DOMANDA03)) || (Ne(o_QADV_DOMANDA04,w_QADV_DOMANDA04)) || (Ne(o_QADV_DOMANDA05,w_QADV_DOMANDA05)) || (Ne(o_QADV_DOMANDA06,w_QADV_DOMANDA06)) || (Ne(o_QADV_DOMANDA07,w_QADV_DOMANDA07)) || (Ne(o_QADV_DOMANDA08,w_QADV_DOMANDA08)) || (Ne(o_QADV_DOMANDA09,w_QADV_DOMANDA09)) || (Ne(o_QADV_DOMANDA10,w_QADV_DOMANDA10)) || (Ne(o_QADV_DOMANDA11,w_QADV_DOMANDA11)) || (Ne(o_QADV_DOMANDA12,w_QADV_DOMANDA12)) || (Ne(o_QADV_DOMANDA03_1,w_QADV_DOMANDA03_1)) || (Ne(o_QADV_DOMANDA03_2,w_QADV_DOMANDA03_2)) || (Ne(o_QADV_DOMANDA03_3,w_QADV_DOMANDA03_3)) || (Ne(o_QADV_DOMANDA04_1,w_QADV_DOMANDA04_1)) || (Ne(o_QADV_DOMANDA04_2,w_QADV_DOMANDA04_2)) || (Ne(o_QADV_DOMANDA04_3,w_QADV_DOMANDA04_3)) || (Ne(o_QADV_DOMANDA04_4,w_QADV_DOMANDA04_4))) {
Calculation_WOOQKMYMKN();
}
w_QADV_TOTALE=w_QADV_PUNTEGGIO01+w_QADV_PUNTEGGIO02+w_QADV_PUNTEGGIO03+w_QADV_PUNTEGGIO04+w_QADV_PUNTEGGIO05+w_QADV_PUNTEGGIO06+w_QADV_PUNTEGGIO07+w_QADV_PUNTEGGIO08+w_QADV_PUNTEGGIO09+w_QADV_PUNTEGGIO10+w_QADV_PUNTEGGIO11+w_QADV_PUNTEGGIO12;
LibJavascript.forEachItem(m_FoundlingCopyWorkVar,i_body_1)
function i_body_1(child){
child();
}
// * --- Area Manuale = UI - Calculate
// * --- armt_cgo_qadv_operazioni
parent.Set_FLGQADVFULL(w_QADV_FLGCOMPLETO)
// * --- Fine Area Manuale
m_bCalculating=false;
}
function Calculation_WOOQKMYMKN() {
arrt_cgo_punteggio_adv([["pObj",this]])
}
function SaveDependsOn() {
o_QADV_DOMANDA01=w_QADV_DOMANDA01;
o_QADV_DOMANDA02=w_QADV_DOMANDA02;
o_QADV_DOMANDA03=w_QADV_DOMANDA03;
o_QADV_DOMANDA03_1=w_QADV_DOMANDA03_1;
o_QADV_DOMANDA03_2=w_QADV_DOMANDA03_2;
o_QADV_DOMANDA03_3=w_QADV_DOMANDA03_3;
o_QADV_DOMANDA04=w_QADV_DOMANDA04;
o_QADV_DOMANDA04_1=w_QADV_DOMANDA04_1;
o_QADV_DOMANDA04_2=w_QADV_DOMANDA04_2;
o_QADV_DOMANDA04_3=w_QADV_DOMANDA04_3;
o_QADV_DOMANDA04_4=w_QADV_DOMANDA04_4;
o_QADV_DOMANDA05=w_QADV_DOMANDA05;
o_QADV_DOMANDA06=w_QADV_DOMANDA06;
o_QADV_DOMANDA07=w_QADV_DOMANDA07;
o_QADV_DOMANDA08=w_QADV_DOMANDA08;
o_QADV_DOMANDA09=w_QADV_DOMANDA09;
o_QADV_DOMANDA10=w_QADV_DOMANDA10;
o_QADV_DOMANDA11=w_QADV_DOMANDA11;
o_QADV_DOMANDA12=w_QADV_DOMANDA12;
}
function SaveLabelDependsOn() {
}
function SendData(formaction,url,data) {
if (Eq(m_bAlreadySubmitted,true)) {
WindowAlert(Translate('MSG_SERVER_DATA'));
return;
}
var Frm = document.FSender;
var bResult = true;
function l_Checks() {
bResult=bResult && Check() && CheckPwdOTP();
}
if (IsWndAccessible(m_oFather)) {
if (Eq(m_nChildStatus,2)) {
m_oFather.SendData(formaction,url,data);
} else if (Eq(m_nChildStatus,1)) {
if (Eq(formaction,'save')) {
if ( ! (Check())) {
DisplayErrorMessage();
return;
}
if ( ! (m_oFather.SaveContext_armt_cgo_qadv_operazioni())) {
WindowAlert(Translate('MSG_CANNOT_UPDATE_CALLERVAR'));
return;
}
InnerChildSendData(bResult);
} else if (Eq(formaction,'moveto') && m_bUpdated) {
WindowConfirm(Translate('MSG_LEAVE_MOD'),InnerChildSendData);
} else {
InnerChildSendData(bResult);
}
function InnerChildSendData(bResult) {
if (bResult) {
if (Eq(m_cFunction,'view') || Eq(m_cFunction,'query') || Ne(m_nLastError,1)) {
m_oFather.focus();
WindowClose();
}
if (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')) {
ResetErrorVars();
}
}
}
}
} else {
if (Eq(formaction,'moveto') && m_bUpdated) {
bResult=WindowConfirm(Translate('MSG_LEAVE_MOD'));
}
if (bResult) {
if (Eq(formaction,'moveto') || (Eq(m_cFunction,'edit') &&  ! (m_bUpdated))) {
formaction='discard';
}
if (Eq(formaction,'save')) {
NotifyEvent('Before Save');
l_Checks();
}
if (bResult) {
Frm.m_cSelectedPage.value=GetSelectedPage(InitWvApplet()).asString();
SubmitForm.SetAction(formaction);
SubmitForm.SetPwdAndOTP();
Frm.m_cAltInterface.value=m_cAltInterface;
Frm.m_cLayerInterface.value=m_cLayerInterface;
FillWv();
Frm.m_cWv.value=WvApplet().asString(1);
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('armt_cgo_qadv_operazioni_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('armt_cgo_qadv_operazioni_dataNotSent',{'action':formaction});
}
}
}
}
}
CheckChild.child=[];
function Check() {
var l_bResult = true;
ResetErrorVars();
m_nLastError=0;
if ( ! (_ChkObl('QISCOZIXKK',1))) {
_SignErr('QISCOZIXKK');
m_cLastWorkVarErrorMsg='1739883621';
l_bResult=false;
w_QADV_DOMANDA01=HtW('','N');
} else if ( ! (_ChkObl('WBZKOKXYXU',1))) {
_SignErr('WBZKOKXYXU');
m_cLastWorkVarErrorMsg='1739883622';
l_bResult=false;
w_QADV_DOMANDA02=HtW('','N');
} else if ( ! (_ChkObl('FQNOXMHNDA',1))) {
_SignErr('FQNOXMHNDA');
m_cLastWorkVarErrorMsg='1739883623';
l_bResult=false;
w_QADV_DOMANDA03=HtW('','N');
} else if ( ! (_ChkObl('ZZAXIZEFKI',1))) {
_SignErr('ZZAXIZEFKI');
m_cLastWorkVarErrorMsg='124599980';
l_bResult=false;
w_QADV_DOMANDA03_1='N';
} else if ( ! (_ChkObl('YMMKALGQQM',1))) {
_SignErr('YMMKALGQQM');
m_cLastWorkVarErrorMsg='124600236';
l_bResult=false;
w_QADV_DOMANDA03_2='N';
} else if ( ! (_ChkObl('TIXQDCBYJJ',1))) {
_SignErr('TIXQDCBYJJ');
m_cLastWorkVarErrorMsg='124600492';
l_bResult=false;
w_QADV_DOMANDA03_3='N';
} else if ( ! (_ChkObl('HOWAZKTGQK',1))) {
_SignErr('HOWAZKTGQK');
m_cLastWorkVarErrorMsg='11339591927';
l_bResult=false;
w_QADV_MOTIVO03=HtW('','M');
} else if ( ! (_ChkObl('ATNBYAZJII',1))) {
_SignErr('ATNBYAZJII');
m_cLastWorkVarErrorMsg='1739883624';
l_bResult=false;
w_QADV_DOMANDA04=HtW('','N');
} else if ( ! (_ChkObl('KBUHMXAJEA',1))) {
_SignErr('KBUHMXAJEA');
m_cLastWorkVarErrorMsg='124599980';
l_bResult=false;
w_QADV_DOMANDA04_1='N';
} else if ( ! (_ChkObl('TJQKPGPGYX',1))) {
_SignErr('TJQKPGPGYX');
m_cLastWorkVarErrorMsg='124587724';
l_bResult=false;
w_QADV_DOMANDA04_2='N';
} else if ( ! (_ChkObl('SAFBZXXNOG',1))) {
_SignErr('SAFBZXXNOG');
m_cLastWorkVarErrorMsg='124600492';
l_bResult=false;
w_QADV_DOMANDA04_3='N';
} else if ( ! (_ChkObl('AJOULWEBQJ',1))) {
_SignErr('AJOULWEBQJ');
m_cLastWorkVarErrorMsg='124600748';
l_bResult=false;
w_QADV_DOMANDA04_4='N';
} else if ( ! (_ChkObl('GQFWKUDIZX',1))) {
_SignErr('GQFWKUDIZX');
m_cLastWorkVarErrorMsg='1739883625';
l_bResult=false;
w_QADV_DOMANDA05=HtW('','N');
} else if ( ! (_ChkObl('NAOHLRJFKW',1))) {
_SignErr('NAOHLRJFKW');
m_cLastWorkVarErrorMsg='11339591926';
l_bResult=false;
w_QADV_MOTIVO05=HtW('','M');
} else if ( ! (_ChkObl('NXAIQESKYE',1))) {
_SignErr('NXAIQESKYE');
m_cLastWorkVarErrorMsg='1739883626';
l_bResult=false;
w_QADV_DOMANDA06=HtW('','N');
} else if ( ! (_ChkObl('TANVFQSZEQ',1))) {
_SignErr('TANVFQSZEQ');
m_cLastWorkVarErrorMsg='1739883627';
l_bResult=false;
w_QADV_DOMANDA07=HtW('','N');
} else if ((Eq(w_QADV_DOMANDA07,6)) && ( ! (_ChkObl('OUKEHIZPFY',1)))) {
_SignErr('OUKEHIZPFY');
m_cLastWorkVarErrorMsg='1739883628';
l_bResult=false;
w_QADV_DOMANDA08=HtW('','N');
} else if ( ! (_ChkObl('CTLRUBZHIS',1))) {
_SignErr('CTLRUBZHIS');
m_cLastWorkVarErrorMsg='1739883629';
l_bResult=false;
w_QADV_DOMANDA09=HtW('','N');
} else if ( ! (_ChkObl('BJMTLOURHC',1))) {
_SignErr('BJMTLOURHC');
m_cLastWorkVarErrorMsg='1739884389';
l_bResult=false;
w_QADV_DOMANDA10=HtW('','N');
} else if ( ! (_ChkObl('YOEMCDHBCJ',1))) {
_SignErr('YOEMCDHBCJ');
m_cLastWorkVarErrorMsg='1739884405';
l_bResult=false;
w_QADV_DOMANDA11=HtW('','N');
} else if ( ! (_ChkObl('RGKOIXTSHJ',1))) {
_SignErr('RGKOIXTSHJ');
m_cLastWorkVarErrorMsg='1739884421';
l_bResult=false;
w_QADV_DOMANDA12=HtW('','N');
} else if ( ! (_ChkObl('IPNCGLSXHQ',1))) {
_SignErr('IPNCGLSXHQ');
m_cLastWorkVarErrorMsg='11339591926';
l_bResult=false;
w_QADV_MOTIVO04=HtW('','M');
} else if ((false) && ( ! (_ChkObl('RVNBZEITUY',1)))) {
_SignErr('RVNBZEITUY');
m_cLastWorkVarErrorMsg='11713788590';
l_bResult=false;
w_QADV_FLGCOMPLETO='N';
}
if (l_bResult) {
l_bResult=CheckChild(0);
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
return -1;
}
function link_url(index) {
var l_oWv;
}
function FillWv() {
var l_oWv = InitWvApplet();
l_oWv.setValue('m_CheckVars',JSON.stringify(m_CheckVars));
l_oWv.setValue('QADV_DOMANDA01',WtA(w_QADV_DOMANDA01,'N'));
l_oWv.setValue('QADV_DOMANDA02',WtA(w_QADV_DOMANDA02,'N'));
l_oWv.setValue('QADV_DOMANDA03',WtA(w_QADV_DOMANDA03,'N'));
l_oWv.setValue('QADV_DOMANDA03_1',WtA(w_QADV_DOMANDA03_1,'C'));
l_oWv.setValue('QADV_DOMANDA03_2',WtA(w_QADV_DOMANDA03_2,'C'));
l_oWv.setValue('QADV_DOMANDA03_3',WtA(w_QADV_DOMANDA03_3,'C'));
l_oWv.setValue('QADV_MOTIVO03',WtA(w_QADV_MOTIVO03,'M'));
l_oWv.setValue('QADV_DOMANDA04',WtA(w_QADV_DOMANDA04,'N'));
l_oWv.setValue('QADV_DOMANDA04_1',WtA(w_QADV_DOMANDA04_1,'C'));
l_oWv.setValue('QADV_DOMANDA04_2',WtA(w_QADV_DOMANDA04_2,'C'));
l_oWv.setValue('QADV_DOMANDA04_3',WtA(w_QADV_DOMANDA04_3,'C'));
l_oWv.setValue('QADV_DOMANDA04_4',WtA(w_QADV_DOMANDA04_4,'C'));
l_oWv.setValue('QADV_DOMANDA05',WtA(w_QADV_DOMANDA05,'N'));
l_oWv.setValue('QADV_MOTIVO05',WtA(w_QADV_MOTIVO05,'M'));
l_oWv.setValue('QADV_DOMANDA06',WtA(w_QADV_DOMANDA06,'N'));
l_oWv.setValue('QADV_DOMANDA07',WtA(w_QADV_DOMANDA07,'N'));
l_oWv.setValue('QADV_DOMANDA08',WtA(w_QADV_DOMANDA08,'N'));
l_oWv.setValue('QADV_DOMANDA09',WtA(w_QADV_DOMANDA09,'N'));
l_oWv.setValue('QADV_DOMANDA10',WtA(w_QADV_DOMANDA10,'N'));
l_oWv.setValue('QADV_DOMANDA11',WtA(w_QADV_DOMANDA11,'N'));
l_oWv.setValue('QADV_DOMANDA12',WtA(w_QADV_DOMANDA12,'N'));
l_oWv.setValue('SNAINUMOPE',WtA(w_SNAINUMOPE,'C'));
l_oWv.setValue('QADV_PUNTEGGIO01',WtA(w_QADV_PUNTEGGIO01,'N'));
l_oWv.setValue('QADV_PUNTEGGIO02',WtA(w_QADV_PUNTEGGIO02,'N'));
l_oWv.setValue('QADV_PUNTEGGIO03',WtA(w_QADV_PUNTEGGIO03,'N'));
l_oWv.setValue('QADV_PUNTEGGIO04',WtA(w_QADV_PUNTEGGIO04,'N'));
l_oWv.setValue('QADV_MOTIVO04',WtA(w_QADV_MOTIVO04,'M'));
l_oWv.setValue('QADV_PUNTEGGIO05',WtA(w_QADV_PUNTEGGIO05,'N'));
l_oWv.setValue('QADV_PUNTEGGIO06',WtA(w_QADV_PUNTEGGIO06,'N'));
l_oWv.setValue('QADV_PUNTEGGIO07',WtA(w_QADV_PUNTEGGIO07,'N'));
l_oWv.setValue('QADV_PUNTEGGIO08',WtA(w_QADV_PUNTEGGIO08,'N'));
l_oWv.setValue('QADV_PUNTEGGIO09',WtA(w_QADV_PUNTEGGIO09,'N'));
l_oWv.setValue('QADV_PUNTEGGIO10',WtA(w_QADV_PUNTEGGIO10,'N'));
l_oWv.setValue('QADV_PUNTEGGIO11',WtA(w_QADV_PUNTEGGIO11,'N'));
l_oWv.setValue('QADV_PUNTEGGIO12',WtA(w_QADV_PUNTEGGIO12,'N'));
l_oWv.setValue('QADV_FLGCOMPLETO',WtA(w_QADV_FLGCOMPLETO,'C'));
l_oWv.setValue('QADV_TOTALE',WtA(w_QADV_TOTALE,'N'));
_FillChildren(l_oWv);
if (m_bExtended) {
ExtendWv(l_oWv);
}
if (Ne(m_cFunction,'view')) {
l_oWv.setValue('m_bUpdated',WtA(m_bUpdated,'L'));
l_oWv.setValue('m_cPrvsStt',WtA(m_cPrvsStt,'C'));
}
l_oWv.setValue('m_bLoaded',WtA(m_bLoaded,'L'));
l_oWv.setValue('m_cOldCPCCCHK',WtA(m_cOldCPCCCHK,'C'));
}
_FillChildren.n=[];
FillWv.n=["QADV_DOMANDA01","QADV_DOMANDA02","QADV_DOMANDA03","QADV_DOMANDA03_1","QADV_DOMANDA03_2","QADV_DOMANDA03_3","QADV_MOTIVO03","QADV_DOMANDA04","QADV_DOMANDA04_1","QADV_DOMANDA04_2","QADV_DOMANDA04_3","QADV_DOMANDA04_4","QADV_DOMANDA05","QADV_MOTIVO05","QADV_DOMANDA06","QADV_DOMANDA07","QADV_DOMANDA08","QADV_DOMANDA09","QADV_DOMANDA10","QADV_DOMANDA11","QADV_DOMANDA12","SNAINUMOPE","QADV_PUNTEGGIO01","QADV_PUNTEGGIO02","QADV_PUNTEGGIO03","QADV_PUNTEGGIO04","QADV_MOTIVO04","QADV_PUNTEGGIO05","QADV_PUNTEGGIO06","QADV_PUNTEGGIO07","QADV_PUNTEGGIO08","QADV_PUNTEGGIO09","QADV_PUNTEGGIO10","QADV_PUNTEGGIO11","QADV_PUNTEGGIO12","QADV_FLGCOMPLETO","QADV_TOTALE"];
function SetModified() {
m_bUpdated=true;
if (IsWndAccessible(m_oFather)) {
m_oFather.SetModified_armt_cgo_qadv_operazioni();
}
}
function EnableEntityWhenReady(enable) {
if (enable) {
var c;
if(c=Ctrl('QISCOZIXKK')) SetDisabled(c,true);
if(c=Ctrl('WBZKOKXYXU')) SetDisabled(c,true);
if(c=Ctrl('FQNOXMHNDA')) SetDisabled(c,true);
if(c=Ctrl('ZZAXIZEFKI')) SetDisabled(c,true);
if(c=Ctrl('YMMKALGQQM')) SetDisabled(c,true);
if(c=Ctrl('TIXQDCBYJJ')) SetDisabled(c,true);
if(c=Ctrl('HOWAZKTGQK')) SetDisabled(c,true);
if(c=Ctrl('ATNBYAZJII')) SetDisabled(c,true);
if(c=Ctrl('KBUHMXAJEA')) SetDisabled(c,true);
if(c=Ctrl('TJQKPGPGYX')) SetDisabled(c,true);
if(c=Ctrl('SAFBZXXNOG')) SetDisabled(c,true);
if(c=Ctrl('AJOULWEBQJ')) SetDisabled(c,true);
if(c=Ctrl('GQFWKUDIZX')) SetDisabled(c,true);
if(c=Ctrl('NAOHLRJFKW')) SetDisabled(c,true);
if(c=Ctrl('NXAIQESKYE')) SetDisabled(c,true);
if(c=Ctrl('TANVFQSZEQ')) SetDisabled(c,true);
if(c=Ctrl('OUKEHIZPFY')) SetDisabled(c,true);
if(c=Ctrl('CTLRUBZHIS')) SetDisabled(c,true);
if(c=Ctrl('BJMTLOURHC')) SetDisabled(c,true);
if(c=Ctrl('YOEMCDHBCJ')) SetDisabled(c,true);
if(c=Ctrl('RGKOIXTSHJ')) SetDisabled(c,true);
if(c=Ctrl('IPNCGLSXHQ')) SetDisabled(c,true);
if(c=Ctrl('RVNBZEITUY')) SetDisabled(c,true);
} else {
var c;
if(c=Ctrl('QISCOZIXKK')) SetDisabled(c,false);
if(c=Ctrl('WBZKOKXYXU')) SetDisabled(c,false);
if(c=Ctrl('FQNOXMHNDA')) SetDisabled(c,false);
if(c=Ctrl('ZZAXIZEFKI')) SetDisabled(c,false);
if(c=Ctrl('YMMKALGQQM')) SetDisabled(c,false);
if(c=Ctrl('TIXQDCBYJJ')) SetDisabled(c,false);
if(c=Ctrl('HOWAZKTGQK')) SetDisabled(c,false);
if(c=Ctrl('ATNBYAZJII')) SetDisabled(c,false);
if(c=Ctrl('KBUHMXAJEA')) SetDisabled(c,false);
if(c=Ctrl('TJQKPGPGYX')) SetDisabled(c,false);
if(c=Ctrl('SAFBZXXNOG')) SetDisabled(c,false);
if(c=Ctrl('AJOULWEBQJ')) SetDisabled(c,false);
if(c=Ctrl('GQFWKUDIZX')) SetDisabled(c,false);
if(c=Ctrl('NAOHLRJFKW')) SetDisabled(c,false);
if(c=Ctrl('NXAIQESKYE')) SetDisabled(c,false);
if(c=Ctrl('TANVFQSZEQ')) SetDisabled(c,false);
if(c=Ctrl('OUKEHIZPFY')) SetDisabled(c,false);
if(c=Ctrl('CTLRUBZHIS')) SetDisabled(c,false);
if(c=Ctrl('BJMTLOURHC')) SetDisabled(c,false);
if(c=Ctrl('YOEMCDHBCJ')) SetDisabled(c,false);
if(c=Ctrl('RGKOIXTSHJ')) SetDisabled(c,false);
if(c=Ctrl('IPNCGLSXHQ')) SetDisabled(c,false);
if(c=Ctrl('RVNBZEITUY')) SetDisabled(c,false);
EnableControlsUnderCondition(false);
}
m_bChildDisabled=enable;
}
