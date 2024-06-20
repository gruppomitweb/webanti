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
l_bEnabled= ! (Eq(EntityStatus(),'N') && w_sudb_mode) || IsDisabledByStateDriver('admin_database');
SetDisabled('KXQZZAOVGI',l_bEnabled);
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
function Set_codazi(ctrlValue,kmode,e) {
if (Ne(w_codazi,ctrlValue)) {
var ctl = _GetCtl(e,'FETUPRQQAZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_codazi=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FETUPRQQAZ',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',10,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_desazi(ctrlValue,kmode,e) {
if (Ne(w_desazi,ctrlValue)) {
var ctl = _GetCtl(e,'CSZNONIHWO');
if (_tracker.goon(ctl,ctrlValue)) {
w_desazi=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CSZNONIHWO',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',70,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_admin_database(ctrlValue,kmode,e) {
if (Ne(w_admin_database,ctrlValue)) {
var ctl = _GetCtl(e,'KXQZZAOVGI');
if (_tracker.goon(ctl,ctrlValue)) {
w_admin_database=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('KXQZZAOVGI',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH(false,'L',1,0,'');
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
if (bResult) {
bResult= ! (Empty(w_codazi));
if ( ! (bResult)) {
m_cLastMsgError=AlertErrorMessage('MSG_CANNOT_SAVE');
}
}
if (bResult &&  ! ( ! (w_admin_database))) {
try {
_tracker.askwrn=true;
bResult=WindowConfirm(AlertErrorMessage('1050624774'));
m_nLastError=-1;
} finally {
_tracker.askwrn=false;
}
}
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
parent.ZtVWeb.raiseEventToEvalParms('spadministration_companies_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('spadministration_companies_dataNotSent',{'action':formaction});
}
}
}
}
CheckChild.child=[];
function Check() {
var l_bResult = true;
ResetErrorVars();
m_nLastError=0;
if ( ! (_ChkObl('FETUPRQQAZ',1))) {
_SignErr('FETUPRQQAZ');
m_cLastWorkVarErrorMsg='960685589';
l_bResult=false;
w_codazi=HtW('','C');
} else if ( ! (_ChkObl('CSZNONIHWO',1))) {
_SignErr('CSZNONIHWO');
m_cLastWorkVarErrorMsg='10656947118';
l_bResult=false;
w_desazi=HtW('','C');
} else if ((Eq(EntityStatus(),'N') && w_sudb_mode) && ( ! (_ChkObl('KXQZZAOVGI',1)))) {
_SignErr('KXQZZAOVGI');
m_cLastWorkVarErrorMsg='admin_database';
l_bResult=false;
w_admin_database=false;
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
l_oWv.setValue('codazi',WtA(w_codazi,'C'));
l_oWv.setValue('desazi',WtA(w_desazi,'C'));
l_oWv.setValue('database_updated',WtA(w_database_updated,'L'));
l_oWv.setValue('sudb_mode',WtA(w_sudb_mode,'L'));
l_oWv.setValue('admin_database',WtA(w_admin_database,'L'));
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
FillWv.n=["codazi","desazi","database_updated","sudb_mode","admin_database"];
function SetModified() {
m_bUpdated=true;
}
