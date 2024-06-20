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
function DisplayErrorMessage_ardt_categris() {
if ( ! (ChildToLoad(FrameRef('ardt_categris'))) && Ne(typeof(FrameRef('ardt_categris').DisplayErrorMessage),'undefined')) {
FrameRef('ardt_categris').DisplayErrorMessage();
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
function Set_C2CODTAB(ctrlValue,kmode,e) {
if (Ne(w_C2CODTAB,ctrlValue)) {
var ctl = _GetCtl(e,'SEJWRQHUSP');
if (_tracker.goon(ctl,ctrlValue)) {
w_C2CODTAB=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SEJWRQHUSP',0);
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
function Set_C2CODICE(ctrlValue,kmode,e) {
if (Ne(w_C2CODICE,ctrlValue)) {
var ctl = _GetCtl(e,'XREVNLNKCY');
if (_tracker.goon(ctl,ctrlValue)) {
w_C2CODICE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XREVNLNKCY',0);
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
function Set_C2DESCRI(ctrlValue,kmode,e) {
if (Ne(w_C2DESCRI,ctrlValue)) {
var ctl = _GetCtl(e,'RJDJPGMTCC');
if (_tracker.goon(ctl,ctrlValue)) {
w_C2DESCRI=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RJDJPGMTCC',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',80,0,'');
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
w_IDBASE=LibreriaMit.UniqueId();
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
parent.ZtVWeb.raiseEventToEvalParms('armt_tbcateg02_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('armt_tbcateg02_dataNotSent',{'action':formaction});
}
}
}
}
CheckChild.child=[{'prg':"ardt_categris",'BOScId':function(){ return FrameRef('ardt_categris')},'repeated':0}];
function Check() {
var l_bResult = true;
var l_bChildCheck = true;
ResetErrorVars();
m_nLastError=0;
if ( ! (_ChkObl('SEJWRQHUSP',1))) {
_SignErr('SEJWRQHUSP');
m_cLastWorkVarErrorMsg='10376019890';
l_bResult=false;
w_C2CODTAB=HtW('','C');
} else if ( ! (_ChkObl('XREVNLNKCY',1))) {
_SignErr('XREVNLNKCY');
m_cLastWorkVarErrorMsg='112851763';
l_bResult=false;
w_C2CODICE=HtW('','C');
} else if ( ! (_ChkObl('RJDJPGMTCC',1))) {
_SignErr('RJDJPGMTCC');
m_cLastWorkVarErrorMsg='285808099';
l_bResult=false;
w_C2DESCRI=HtW('','C');
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
l_oWv.setValue('C2CODTAB',WtA(w_C2CODTAB,'C'));
l_oWv.setValue('C2CODICE',WtA(w_C2CODICE,'C'));
l_oWv.setValue('C2DESCRI',WtA(w_C2DESCRI,'C'));
l_oWv.setValue('IDBASE',WtA(w_IDBASE,'C'));
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
_FillChildren.n=['ardt_categris'];
FillWv.n=["C2CODTAB","C2CODICE","C2DESCRI","IDBASE"];
function SetModified() {
m_bUpdated=true;
}
function SetChildVariables_ardt_categris() {
}
function CtxLoad_ardt_categris() {
if (ChildToLoad(FrameRef('ardt_categris'))) {
return [LoadContext(0,'HUIWOOPCDH'),'ardt_categris'];
}
}
