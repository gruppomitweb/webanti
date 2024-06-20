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
function Set_progname(ctrlValue,kmode,e) {
if (Ne(w_progname,ctrlValue)) {
var ctl = _GetCtl(e,'ROXNXYYWEU');
if (_tracker.goon(ctl,ctrlValue)) {
w_progname=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ROXNXYYWEU',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',50,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_grpcode(ctrlValue,kmode,e) {
if (Ne(w_grpcode,ctrlValue)) {
var ctl = _GetCtl(e,'SIZORIYAFY');
if (_tracker.goon(ctl,ctrlValue)) {
w_grpcode=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SIZORIYAFY',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','N',6,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_usrcode(ctrlValue,kmode,e) {
if (Ne(w_usrcode,ctrlValue)) {
var ctl = _GetCtl(e,'TNPTJUMOGJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_usrcode=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('TNPTJUMOGJ',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','N',9,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_sec1(ctrlValue,kmode,e) {
if (Ne(w_sec1,ctrlValue)) {
var ctl = _GetCtl(e,'GDZEAZSMVW');
if (_tracker.goon(ctl,ctrlValue)) {
w_sec1=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('GDZEAZSMVW',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','N',4,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_sec2(ctrlValue,kmode,e) {
if (Ne(w_sec2,ctrlValue)) {
var ctl = _GetCtl(e,'LQMKHTCCSC');
if (_tracker.goon(ctl,ctrlValue)) {
w_sec2=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('LQMKHTCCSC',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','N',4,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_sec3(ctrlValue,kmode,e) {
if (Ne(w_sec3,ctrlValue)) {
var ctl = _GetCtl(e,'XWWVHCAXZB');
if (_tracker.goon(ctl,ctrlValue)) {
w_sec3=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XWWVHCAXZB',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','N',4,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_sec4(ctrlValue,kmode,e) {
if (Ne(w_sec4,ctrlValue)) {
var ctl = _GetCtl(e,'KFAWPTNVWL');
if (_tracker.goon(ctl,ctrlValue)) {
w_sec4=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('KFAWPTNVWL',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','N',4,0,'');
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
parent.ZtVWeb.raiseEventToEvalParms('spadministration_security_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('spadministration_security_dataNotSent',{'action':formaction});
}
}
}
}
CheckChild.child=[];
function Check() {
var l_bResult = true;
ResetErrorVars();
m_nLastError=0;
if ( ! (_ChkObl('ROXNXYYWEU',1))) {
_SignErr('ROXNXYYWEU');
m_cLastWorkVarErrorMsg='134969174';
l_bResult=false;
w_progname=HtW('','C');
} else if ( ! (_ChkObl('SIZORIYAFY',1))) {
_SignErr('SIZORIYAFY');
m_cLastWorkVarErrorMsg='897043739';
l_bResult=false;
w_grpcode=HtW('','N');
} else if ( ! (_ChkObl('TNPTJUMOGJ',1))) {
_SignErr('TNPTJUMOGJ');
m_cLastWorkVarErrorMsg='11286107926';
l_bResult=false;
w_usrcode=HtW('','N');
} else if ( ! (_ChkObl('GDZEAZSMVW',1))) {
_SignErr('GDZEAZSMVW');
m_cLastWorkVarErrorMsg='128563569';
l_bResult=false;
w_sec1=HtW('','N');
} else if ( ! (_ChkObl('LQMKHTCCSC',1))) {
_SignErr('LQMKHTCCSC');
m_cLastWorkVarErrorMsg='129550889';
l_bResult=false;
w_sec2=HtW('','N');
} else if ( ! (_ChkObl('XWWVHCAXZB',1))) {
_SignErr('XWWVHCAXZB');
m_cLastWorkVarErrorMsg='134019901';
l_bResult=false;
w_sec3=HtW('','N');
} else if ( ! (_ChkObl('KFAWPTNVWL',1))) {
_SignErr('KFAWPTNVWL');
m_cLastWorkVarErrorMsg='113951380';
l_bResult=false;
w_sec4=HtW('','N');
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
l_oWv.setValue('progname',WtA(w_progname,'C'));
l_oWv.setValue('grpcode',WtA(w_grpcode,'N'));
l_oWv.setValue('usrcode',WtA(w_usrcode,'N'));
l_oWv.setValue('sec1',WtA(w_sec1,'N'));
l_oWv.setValue('sec2',WtA(w_sec2,'N'));
l_oWv.setValue('sec3',WtA(w_sec3,'N'));
l_oWv.setValue('sec4',WtA(w_sec4,'N'));
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
FillWv.n=["progname","grpcode","usrcode","sec1","sec2","sec3","sec4"];
function SetModified() {
m_bUpdated=true;
}
