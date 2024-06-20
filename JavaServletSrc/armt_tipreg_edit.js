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
function EnableControlsUnderCondition_WhenReady() {
var l_bEnabled = true;
// * --- Area Manuale = UI - Enable Controls Init
// * --- Fine Area Manuale
if (window.Z && window.Z.Tabs) {
Z.Tabs.Get('tabs').CheckTabStrip();
}
if (IsDisabledByStateDriver('box_YORQOIOBQN')) {
DisableInputsInContainer(Ctrl('YORQOIOBQN'),true);
}
LibJavascript.forEachItem(m_FoundlingEditExpression,i_body_0)
function i_body_0(child){
child();
}
DisableUI();
HideControlsUnderCondition();
ObligatoryControlsUnderCondition();
// * --- Area Manuale = UI - Enable Controls End
// * --- Fine Area Manuale
}
function ObligatoryControlsUnderCondition() {
var l_bObligatory = true;
}
function SetDynamicClasses() {
var c;
}
function SetDynamicTooltip() {
var c;
}
function Set_CODICE(ctrlValue,kmode,e) {
if (Ne(w_CODICE,ctrlValue)) {
var ctl = _GetCtl(e,'XIEVRJLRDP');
if (_tracker.goon(ctl,ctrlValue)) {
w_CODICE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XIEVRJLRDP',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',2,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_DES1(ctrlValue,kmode,e) {
if (Ne(w_DES1,ctrlValue)) {
var ctl = _GetCtl(e,'BRISTCOXVE');
if (_tracker.goon(ctl,ctrlValue)) {
w_DES1=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BRISTCOXVE',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',90,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_DES2(ctrlValue,kmode,e) {
if (Ne(w_DES2,ctrlValue)) {
var ctl = _GetCtl(e,'PFCAAXIJSU');
if (_tracker.goon(ctl,ctrlValue)) {
w_DES2=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('PFCAAXIJSU',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',60,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_TIPREG(ctrlValue,kmode,e) {
if (Ne(w_TIPREG,ctrlValue)) {
var ctl = _GetCtl(e,'TAZCXRSOBO');
if (_tracker.goon(ctl,ctrlValue)) {
w_TIPREG=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('TAZCXRSOBO',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_OPERAZIO(ctrlValue,kmode,e) {
if (Ne(w_OPERAZIO,ctrlValue)) {
var ctl = _GetCtl(e,'HHIHNZHIBP');
if (_tracker.goon(ctl,ctrlValue)) {
w_OPERAZIO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HHIHNZHIBP',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_DATAINI(ctrlValue,kmode,e) {
if (Ne(w_DATAINI,ctrlValue)) {
var ctl = _GetCtl(e,'CFISKJBJKS');
if (_tracker.goon(ctl,ctrlValue)) {
w_DATAINI=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CFISKJBJKS',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH(NullDate(),'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
_ResetTracker();
return true;
}
}
return true;
}
function Set_DATAFINE(ctrlValue,kmode,e) {
if (Ne(w_DATAFINE,ctrlValue)) {
var ctl = _GetCtl(e,'FLWSSMJEER');
if (_tracker.goon(ctl,ctrlValue)) {
w_DATAFINE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FLWSSMJEER',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH(NullDate(),'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
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
LibJavascript.forEachItem(m_FoundlingCopyWorkVar,i_body_1)
function i_body_1(child){
child();
}
// * --- Area Manuale = UI - Calculate
// * --- Fine Area Manuale
m_bCalculating=false;
}
function SaveDependsOn() {
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
parent.ZtVWeb.raiseEventToEvalParms('armt_tipreg_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('armt_tipreg_dataNotSent',{'action':formaction});
}
}
}
}
CheckChild.child=[];
function Check() {
var l_bResult = true;
ResetErrorVars();
m_nLastError=0;
if ( ! (_ChkObl('XIEVRJLRDP',1))) {
_SignErr('XIEVRJLRDP');
m_cLastWorkVarErrorMsg='112851763';
l_bResult=false;
w_CODICE=HtW('','C');
} else if ( ! (_ChkObl('BRISTCOXVE',1))) {
_SignErr('BRISTCOXVE');
m_cLastWorkVarErrorMsg='285808099';
l_bResult=false;
w_DES1=HtW('','C');
} else if ( ! (_ChkObl('PFCAAXIJSU',1))) {
_SignErr('PFCAAXIJSU');
m_cLastWorkVarErrorMsg='289215971';
l_bResult=false;
w_DES2=HtW('','C');
} else if ( ! (_ChkObl('TAZCXRSOBO',1))) {
_SignErr('TAZCXRSOBO');
m_cLastWorkVarErrorMsg='995100987';
l_bResult=false;
w_TIPREG=HtW('','C');
} else if ( ! (_ChkObl('HHIHNZHIBP',1))) {
_SignErr('HHIHNZHIBP');
m_cLastWorkVarErrorMsg='10932226881';
l_bResult=false;
w_OPERAZIO=HtW('','C');
} else if ( ! (_ChkObl('CFISKJBJKS',1))) {
_SignErr('CFISKJBJKS');
m_cLastWorkVarErrorMsg='86866770';
l_bResult=false;
w_DATAINI=HtW('','D');
} else if ( ! (_ChkObl('FLWSSMJEER',1))) {
_SignErr('FLWSSMJEER');
m_cLastWorkVarErrorMsg='1216938285';
l_bResult=false;
w_DATAFINE=HtW('','D');
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
l_oWv.setValue('CODICE',WtA(w_CODICE,'C'));
l_oWv.setValue('DES1',WtA(w_DES1,'C'));
l_oWv.setValue('DES2',WtA(w_DES2,'C'));
l_oWv.setValue('TIPREG',WtA(w_TIPREG,'C'));
l_oWv.setValue('OPERAZIO',WtA(w_OPERAZIO,'C'));
l_oWv.setValue('DATAINI',WtA(w_DATAINI,'D'));
l_oWv.setValue('DATAFINE',WtA(w_DATAFINE,'D'));
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
FillWv.n=["CODICE","DES1","DES2","TIPREG","OPERAZIO","DATAINI","DATAFINE"];
function SetModified() {
m_bUpdated=true;
}
