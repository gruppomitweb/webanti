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
function Set_TIPLEG(ctrlValue,kmode,e) {
if (Ne(w_TIPLEG,ctrlValue)) {
var ctl = _GetCtl(e,'KYSFYTLMNO');
if (_tracker.goon(ctl,ctrlValue)) {
w_TIPLEG=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('KYSFYTLMNO',0);
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
function Set_DESCRIZ(ctrlValue,kmode,e) {
if (Ne(w_DESCRIZ,ctrlValue)) {
var ctl = _GetCtl(e,'JHHFBCVDFM');
if (_tracker.goon(ctl,ctrlValue)) {
w_DESCRIZ=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('JHHFBCVDFM',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',95,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_DATAINI(ctrlValue,kmode,e) {
if (Ne(w_DATAINI,ctrlValue)) {
var ctl = _GetCtl(e,'UGMIJICNYC');
if (_tracker.goon(ctl,ctrlValue)) {
w_DATAINI=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UGMIJICNYC',0);
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
var ctl = _GetCtl(e,'RFAYNTMUSW');
if (_tracker.goon(ctl,ctrlValue)) {
w_DATAFINE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RFAYNTMUSW',0);
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
function Set_FILTRO(ctrlValue,kmode,e) {
if (Ne(w_FILTRO,ctrlValue)) {
var ctl = _GetCtl(e,'AGUMDTGLPU');
if (_tracker.goon(ctl,ctrlValue)) {
w_FILTRO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('AGUMDTGLPU',0);
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
function Set_DESCRIZ2(ctrlValue,kmode,e) {
if (Ne(w_DESCRIZ2,ctrlValue)) {
var ctl = _GetCtl(e,'QQTLOBKJYW');
if (_tracker.goon(ctl,ctrlValue)) {
w_DESCRIZ2=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QQTLOBKJYW',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',95,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_DATAINID2(ctrlValue,kmode,e) {
if (Ne(w_DATAINID2,ctrlValue)) {
var ctl = _GetCtl(e,'UAGKCIWRAE');
if (_tracker.goon(ctl,ctrlValue)) {
w_DATAINID2=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UAGKCIWRAE',0);
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
function Set_DATAFIND2(ctrlValue,kmode,e) {
if (Ne(w_DATAFIND2,ctrlValue)) {
var ctl = _GetCtl(e,'RLLSZMIXEQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_DATAFIND2=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RLLSZMIXEQ',0);
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
parent.ZtVWeb.raiseEventToEvalParms('armt_tipileg_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('armt_tipileg_dataNotSent',{'action':formaction});
}
}
}
}
CheckChild.child=[];
function Check() {
var l_bResult = true;
ResetErrorVars();
m_nLastError=0;
if ( ! (_ChkObl('KYSFYTLMNO',1))) {
_SignErr('KYSFYTLMNO');
m_cLastWorkVarErrorMsg='112851763';
l_bResult=false;
w_TIPLEG=HtW('','C');
} else if ( ! (_ChkObl('JHHFBCVDFM',1))) {
_SignErr('JHHFBCVDFM');
m_cLastWorkVarErrorMsg='285808099';
l_bResult=false;
w_DESCRIZ=HtW('','C');
} else if ( ! (_ChkObl('UGMIJICNYC',1))) {
_SignErr('UGMIJICNYC');
m_cLastWorkVarErrorMsg='86866770';
l_bResult=false;
w_DATAINI=HtW('','D');
} else if ( ! (_ChkObl('RFAYNTMUSW',1))) {
_SignErr('RFAYNTMUSW');
m_cLastWorkVarErrorMsg='1216938285';
l_bResult=false;
w_DATAFINE=HtW('','D');
} else if ( ! (_ChkObl('AGUMDTGLPU',1))) {
_SignErr('AGUMDTGLPU');
m_cLastWorkVarErrorMsg='124367574';
l_bResult=false;
w_FILTRO=HtW('','C');
} else if ( ! (_ChkObl('QQTLOBKJYW',1))) {
_SignErr('QQTLOBKJYW');
m_cLastWorkVarErrorMsg='1443945977';
l_bResult=false;
w_DESCRIZ2=HtW('','C');
} else if ( ! (_ChkObl('UAGKCIWRAE',1))) {
_SignErr('UAGKCIWRAE');
m_cLastWorkVarErrorMsg='86866770';
l_bResult=false;
w_DATAINID2=HtW('','D');
} else if ( ! (_ChkObl('RLLSZMIXEQ',1))) {
_SignErr('RLLSZMIXEQ');
m_cLastWorkVarErrorMsg='1216938285';
l_bResult=false;
w_DATAFIND2=HtW('','D');
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
l_oWv.setValue('TIPLEG',WtA(w_TIPLEG,'C'));
l_oWv.setValue('DESCRIZ',WtA(w_DESCRIZ,'C'));
l_oWv.setValue('DATAINI',WtA(w_DATAINI,'D'));
l_oWv.setValue('DATAFINE',WtA(w_DATAFINE,'D'));
l_oWv.setValue('FILTRO',WtA(w_FILTRO,'C'));
l_oWv.setValue('DESCRIZ2',WtA(w_DESCRIZ2,'C'));
l_oWv.setValue('DATAINID2',WtA(w_DATAINID2,'D'));
l_oWv.setValue('DATAFIND2',WtA(w_DATAFIND2,'D'));
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
FillWv.n=["TIPLEG","DESCRIZ","DATAINI","DATAFINE","FILTRO","DESCRIZ2","DATAINID2","DATAFIND2"];
function SetModified() {
m_bUpdated=true;
}
