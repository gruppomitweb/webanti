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
function Set_CODSTA(ctrlValue,kmode,e) {
if (Ne(w_CODSTA,ctrlValue)) {
var ctl = _GetCtl(e,'LEUKOZNIUN');
if (_tracker.goon(ctl,ctrlValue)) {
w_CODSTA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('LEUKOZNIUN',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',3,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_DESCRI(ctrlValue,kmode,e) {
if (Ne(w_DESCRI,ctrlValue)) {
var ctl = _GetCtl(e,'FREJQSVVRY');
if (_tracker.goon(ctl,ctrlValue)) {
ow_DESCRI=w_DESCRI;
w_DESCRI=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FREJQSVVRY',0);
if (l_bResult) {
DoUpdate(l_bResult);
Set_mlt_DESCRI(Generate_mlt_DESCRI());
}
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',30,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Generate_mlt_DESCRI() {
return GenerateMltObjectSerialized('DESCRI');
}
function Set_mlt_DESCRI(ctrlValue,kmode,e) {
if (Ne(mlt_DESCRI,ctrlValue)) {
mlt_DESCRI=ctrlValue;
SetModified();
}
}
function Set_SIGLA(ctrlValue,kmode,e) {
if (Ne(w_SIGLA,ctrlValue)) {
var ctl = _GetCtl(e,'HQOQQTARBM');
if (_tracker.goon(ctl,ctrlValue)) {
w_SIGLA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HQOQQTARBM',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',4,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_ISO(ctrlValue,kmode,e) {
if (Ne(w_ISO,ctrlValue)) {
var ctl = _GetCtl(e,'GPSKHVYSHP');
if (_tracker.goon(ctl,ctrlValue)) {
w_ISO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('GPSKHVYSHP',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',3,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_ISO2(ctrlValue,kmode,e) {
if (Ne(w_ISO2,ctrlValue)) {
var ctl = _GetCtl(e,'UXSTIMUVDG');
if (_tracker.goon(ctl,ctrlValue)) {
w_ISO2=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UXSTIMUVDG',0);
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
parent.ZtVWeb.raiseEventToEvalParms('armt_stati_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('armt_stati_dataNotSent',{'action':formaction});
}
}
}
}
CheckChild.child=[];
function Check() {
var l_bResult = true;
ResetErrorVars();
m_nLastError=0;
if ( ! (_ChkObl('LEUKOZNIUN',1))) {
_SignErr('LEUKOZNIUN');
m_cLastWorkVarErrorMsg='112851763';
l_bResult=false;
w_CODSTA=HtW('','C');
} else if ( ! (_ChkObl('FREJQSVVRY',1))) {
_SignErr('FREJQSVVRY');
m_cLastWorkVarErrorMsg='285808099';
l_bResult=false;
w_DESCRI=HtW('','C');
} else if ( ! (_ChkObl('HQOQQTARBM',1))) {
_SignErr('HQOQQTARBM');
m_cLastWorkVarErrorMsg='6827491';
l_bResult=false;
w_SIGLA=HtW('','C');
} else if ( ! (_ChkObl('GPSKHVYSHP',1))) {
_SignErr('GPSKHVYSHP');
m_cLastWorkVarErrorMsg='ISO';
l_bResult=false;
w_ISO=HtW('','C');
} else if ( ! (_ChkObl('UXSTIMUVDG',1))) {
_SignErr('UXSTIMUVDG');
m_cLastWorkVarErrorMsg='ISO2';
l_bResult=false;
w_ISO2=HtW('','C');
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
l_oWv.setValue('CODSTA',WtA(w_CODSTA,'C'));
l_oWv.setValue('DESCRI',WtA(w_DESCRI,'C'));
l_oWv.setValue('ow_DESCRI',WtA(ow_DESCRI,'C'));
l_oWv.setValue('mlt_DESCRI',WtA(mlt_DESCRI,'C'));
l_oWv.setValue('SIGLA',WtA(w_SIGLA,'C'));
l_oWv.setValue('ISO',WtA(w_ISO,'C'));
l_oWv.setValue('ISO2',WtA(w_ISO2,'C'));
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
FillWv.n=["CODSTA","DESCRI","SIGLA","ISO","ISO2"];
function SetModified() {
m_bUpdated=true;
}
