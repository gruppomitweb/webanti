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
LibJavascript.forEachItem(m_FoundlingEditExpression,i_body_0)
function i_body_0(child){
child();
}
DisableUI();
if (Ne('undefined',typeof(DisableChainedLinks))) {
DisableChainedLinks(Ne(0,m_oTrs.length));
}
if (inherit && IsWndAccessible(m_oFather) &&  ! (m_oFather.m_bCalculating)) {
m_oFather.EnableControlsUnderCondition();
}
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
function SetDefaultFixedStyles() {
}
function Set_code(ctrlValue,kmode,e) {
if (Ne(w_code,ctrlValue)) {
var ctl = _GetCtl(e,'HSYXZWNPAJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_code=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HSYXZWNPAJ',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('HSYXZWNPAJ',function(){return WtH(w_code,'N',9,0,'9999999999')},w_code);
return l_bResult;
} else {
ctl.value=WtH('','N',9,0,'9999999999');
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
if (IsWndAccessible(m_oFather)) {
if (Eq(m_nChildStatus,2)) {
m_oFather.SendData(formaction,url,data);
} else if (Eq(m_nChildStatus,1)) {
if (Eq(formaction,'save')) {
if ( ! (SaveRow())) {
return;
}
if ( ! (Check())) {
DisplayErrorMessage();
return;
}
if ( ! (m_oFather.SaveContext_spadministration_historypwd())) {
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
NotifyEvent('Before Save Row');
bResult=bResult && SaveRow(true);
if (bResult) {
NotifyEvent('Before Save');
l_Checks();
}
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
parent.ZtVWeb.raiseEventToEvalParms('spadministration_historypwd_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('spadministration_historypwd_dataNotSent',{'action':formaction});
}
}
}
}
}
CheckChild.child=[];
function Check() {
var l_bResult = true;
ResetErrorVars();
if ( ! (_ChkObl('HSYXZWNPAJ',1))) {
_SignErr('HSYXZWNPAJ');
m_cLastWorkVarErrorMsg='1999024119';
l_bResult=false;
w_code=HtW('','N');
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
l_oWv.setValue('code',WtA(w_code,'N'));
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
if (Ne(m_cFunction,'view')) {
l_oWv.setValue('m_bHeaderUpdated',WtA(m_bHeaderUpdated,'L'));
l_oWv.setValue('m_oTrs',TrsApplet().asString());
}
}
_FillChildren.n=[];
FillWv.n=["code"];
function CheckRow(w) {
var l_bResult = true;
ResetErrorVars();
if (Le(m_nCurrentRow,Rows())) {
}
if (FullRow()) {
if (l_bResult) {
l_bResult=CheckChild(1);
}
}
DisableChainedLinks(true);
// * --- Area Manuale = UI - Check Row
// * --- Fine Area Manuale
return l_bResult;
}
function CheckDeleteRow() {
var l_bResult = true;
ResetErrorVars();
return l_bResult;
}
function SetModified(bRepeated) {
m_bUpdated=true;
if (bRepeated) {
if (Le(m_nCurrentRow,m_oTrs.length) && Eq(m_nRowStatus,0)) {
m_nRowStatus=1;
}
} else {
m_bHeaderUpdated=true;
}
if (IsWndAccessible(m_oFather)) {
m_oFather.SetModified_spadministration_historypwd();
}
}
SaveContext.child=[];
function BlankRow() {
w_pwpassword='';
w_pwdatcreate=NullDateTime();
w_pwdtrevoke=NullDate();
w_pwactive='';
BlankRowChild();
if (m_bExtended) {
BlankRepeatedExtendedFields();
}
SaveDependsOn();
LoadContext(true);
}
function FullRow() {
return  ! (Empty(w_pwpassword));
}
function GetRepeatedFields() {
var l_aRepeatedFields;
l_aRepeatedFields={};
l_aRepeatedFields.pwpassword={"type":"C","name":"pwpassword","id":"ISUBOHJXOM","fixedpos":false,"len":20,"dec":0,"title":"Password"};
l_aRepeatedFields.pwdatcreate={"type":"T","name":"pwdatcreate","id":"PPWFOHVLVZ","fixedpos":false,"len":14,"dec":0,"title":"Data creazione"};
l_aRepeatedFields.pwdtrevoke={"type":"D","name":"pwdtrevoke","id":"RPTHHSJSVB","fixedpos":true,"len":8,"dec":0,"title":"Data fine"};
l_aRepeatedFields.pwactive={"type":"C","name":"pwactive","id":"ELNEIJBFII","fixedpos":true,"len":1,"dec":0,"title":"Attiva"};
return l_aRepeatedFields;
}
function SubtractTotals() {
}
function hasDepOnTotals() {
}
function DisableChainedLinks(disable) {
}
function EnableEntityWhenReady(enable) {
if (enable) {
var c;
if(c=Ctrl('HSYXZWNPAJ')) SetDisabled(c,true);
SetQueryRow(Ctrl('GridTable'),false);
} else {
SetEditRow(Ctrl('GridTable'),false);
var c;
if(c=Ctrl('HSYXZWNPAJ')) SetDisabled(c,false);
EnableControlsUnderCondition(false);
}
m_bChildDisabled=enable;
}
