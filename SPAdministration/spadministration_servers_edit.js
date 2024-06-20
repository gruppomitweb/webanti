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
l_bEnabled= ! ( ! (Empty(w_ODBCDataSource)));
SetDisabled('QENAHXGKZP',l_bEnabled);
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
function Set_ServerName(ctrlValue,kmode,e) {
if (Ne(w_ServerName,ctrlValue)) {
var ctl = _GetCtl(e,'JWFUQHQPUG');
if (_tracker.goon(ctl,ctrlValue)) {
w_ServerName=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('JWFUQHQPUG',0);
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
function Set_ServerDesc(ctrlValue,kmode,e) {
if (Ne(w_ServerDesc,ctrlValue)) {
var ctl = _GetCtl(e,'YGIZDTNCWH');
if (_tracker.goon(ctl,ctrlValue)) {
w_ServerDesc=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YGIZDTNCWH',0);
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
function Set_ODBCDataSource(ctrlValue,kmode,e) {
if (Ne(w_ODBCDataSource,ctrlValue)) {
var ctl = _GetCtl(e,'JZYFFSWJOU');
if (_tracker.goon(ctl,ctrlValue)) {
w_ODBCDataSource=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('JZYFFSWJOU',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',500,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_PostIt(ctrlValue,kmode,e) {
if (Ne(w_PostIt,ctrlValue)) {
var ctl = _GetCtl(e,'FTWSNQIXUU');
if (_tracker.goon(ctl,ctrlValue)) {
w_PostIt=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FTWSNQIXUU',0);
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
function Set_DatabaseType_Other(ctrlValue,kmode,e) {
if (Ne(w_DatabaseType_Other,ctrlValue)) {
var ctl = _GetCtl(e,'CTNCYJEQGE');
if (_tracker.goon(ctl,ctrlValue)) {
w_DatabaseType_Other=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CTNCYJEQGE',0);
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
function Set_DatabaseType_Var(ctrlValue,kmode,e) {
if (Ne(w_DatabaseType_Var,ctrlValue)) {
var ctl = _GetCtl(e,'OJYDANVTYQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_DatabaseType_Var=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('OJYDANVTYQ',0);
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
function Calculate() {
var l_bTmpRes;
var l_bResult = true;
m_bCalculating=true;
if ((Ne(o_DatabaseType,w_DatabaseType))) {
w_DatabaseType_Other=(Eq(EntityStatus(),'N') || Gt(At(','+w_DatabaseType+',',w_DatabaseType_SupportedDatabases),0)?'':w_DatabaseType);
}
if ((Ne(o_DatabaseType,w_DatabaseType))) {
w_DatabaseType_Var=(Eq(EntityStatus(),'N') || Gt(At(','+w_DatabaseType+',',w_DatabaseType_SupportedDatabases),0)?w_DatabaseType:'');
}
if ((Ne(o_DatabaseType_Var,w_DatabaseType_Var)) || (Ne(o_DatabaseType_Other,w_DatabaseType_Other))) {
Calculation_OANHAMSHFO();
}
LibJavascript.forEachItem(m_FoundlingCopyWorkVar,i_body_1)
function i_body_1(child){
child();
}
// * --- Area Manuale = UI - Calculate
// * --- Fine Area Manuale
m_bCalculating=false;
}
function Calculation_OANHAMSHFO() {
w_DatabaseType=(Empty(w_DatabaseType_Var)?w_DatabaseType_Other:w_DatabaseType_Var);
}
function SaveDependsOn() {
o_DatabaseType=w_DatabaseType;
o_DatabaseType_Other=w_DatabaseType_Other;
o_DatabaseType_Var=w_DatabaseType_Var;
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
parent.ZtVWeb.raiseEventToEvalParms('spadministration_servers_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('spadministration_servers_dataNotSent',{'action':formaction});
}
}
}
}
CheckChild.child=[];
function Check() {
var l_bResult = true;
ResetErrorVars();
m_nLastError=0;
if ( ! (_ChkObl('JWFUQHQPUG',1))) {
_SignErr('JWFUQHQPUG');
m_cLastWorkVarErrorMsg='11081652104';
l_bResult=false;
w_ServerName=HtW('','C');
} else if ( ! (_ChkObl('YGIZDTNCWH',1))) {
_SignErr('YGIZDTNCWH');
m_cLastWorkVarErrorMsg='1456511638';
l_bResult=false;
w_ServerDesc=HtW('','C');
} else if ( ! (_ChkObl('JZYFFSWJOU',1))) {
_SignErr('JZYFFSWJOU');
m_cLastWorkVarErrorMsg='250921820';
l_bResult=false;
w_ODBCDataSource=HtW('','C');
} else if ( ! (_ChkObl('CTNCYJEQGE',1))) {
_SignErr('CTNCYJEQGE');
m_cLastWorkVarErrorMsg='10029302073';
l_bResult=false;
w_DatabaseType_Other=HtW('','C');
} else if ( ! (_ChkObl('OJYDANVTYQ',1))) {
_SignErr('OJYDANVTYQ');
m_cLastWorkVarErrorMsg='DatabaseType_Var';
l_bResult=false;
w_DatabaseType_Var=HtW('','C');
} else if ( ! (_ChkObl('FTWSNQIXUU',1))) {
_SignErr('FTWSNQIXUU');
m_cLastWorkVarErrorMsg='126925376';
l_bResult=false;
w_PostIt='';
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
l_oWv.setValue('ServerName',WtA(w_ServerName,'C'));
l_oWv.setValue('ServerDesc',WtA(w_ServerDesc,'C'));
l_oWv.setValue('ODBCDataSource',WtA(w_ODBCDataSource,'C'));
l_oWv.setValue('DatabaseType',WtA(w_DatabaseType,'C'));
l_oWv.setValue('PostIt',WtA(w_PostIt,'C'));
l_oWv.setValue('DatabaseType_SupportedDatabases',WtA(w_DatabaseType_SupportedDatabases,'M'));
l_oWv.setValue('DatabaseType_Other',WtA(w_DatabaseType_Other,'C'));
l_oWv.setValue('DatabaseType_Var',WtA(w_DatabaseType_Var,'C'));
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
FillWv.n=["ServerName","ServerDesc","ODBCDataSource","DatabaseType","PostIt","DatabaseType_SupportedDatabases","DatabaseType_Other","DatabaseType_Var"];
function SetModified() {
m_bUpdated=true;
}
