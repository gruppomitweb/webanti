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
if (IsDisabledByStateDriver('D2022')) {
DisableInputsInContainer(Ctrl('TFQVKXQXHO'),true);
}
if (IsDisabledByStateDriver('DBase')) {
DisableInputsInContainer(Ctrl('PBZPZCASCW'),true);
}
LibJavascript.forEachItem(m_FoundlingEditExpression,i_body_0)
function i_body_0(child){
child();
}
DisableUI();
HideControlsUnderCondition();
ObligatoryControlsUnderCondition();
ExpandCollapseBoxesUnderCondition();
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
function Set_IMP12022(ctrlValue,kmode,e) {
if (Ne(w_IMP12022,ctrlValue)) {
var ctl = _GetCtl(e,'QPKQOSKHNE');
if (_tracker.goon(ctl,ctrlValue)) {
w_IMP12022=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QPKQOSKHNE',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',250,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_IMP22022(ctrlValue,kmode,e) {
if (Ne(w_IMP22022,ctrlValue)) {
var ctl = _GetCtl(e,'UXHOBDXZYD');
if (_tracker.goon(ctl,ctrlValue)) {
w_IMP22022=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UXHOBDXZYD',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',250,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_IMP32022(ctrlValue,kmode,e) {
if (Ne(w_IMP32022,ctrlValue)) {
var ctl = _GetCtl(e,'SGYPEZIWSO');
if (_tracker.goon(ctl,ctrlValue)) {
w_IMP32022=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SGYPEZIWSO',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',250,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_IMP42022(ctrlValue,kmode,e) {
if (Ne(w_IMP42022,ctrlValue)) {
var ctl = _GetCtl(e,'PWLMWGXLJT');
if (_tracker.goon(ctl,ctrlValue)) {
w_IMP42022=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('PWLMWGXLJT',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',250,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_IMP52022(ctrlValue,kmode,e) {
if (Ne(w_IMP52022,ctrlValue)) {
var ctl = _GetCtl(e,'RRLCWIMLZS');
if (_tracker.goon(ctl,ctrlValue)) {
w_IMP52022=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RRLCWIMLZS',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',250,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_IMP62022(ctrlValue,kmode,e) {
if (Ne(w_IMP62022,ctrlValue)) {
var ctl = _GetCtl(e,'MFEVNPBTPC');
if (_tracker.goon(ctl,ctrlValue)) {
w_IMP62022=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MFEVNPBTPC',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',250,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_CODICE(ctrlValue,kmode,e) {
if (Ne(w_CODICE,ctrlValue)) {
var ctl = _GetCtl(e,'ADJOBBEXVH');
if (_tracker.goon(ctl,ctrlValue)) {
w_CODICE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ADJOBBEXVH',0);
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
function Set_IMP2(ctrlValue,kmode,e) {
if (Ne(w_IMP2,ctrlValue)) {
var ctl = _GetCtl(e,'CJNBNYNUXU');
if (_tracker.goon(ctl,ctrlValue)) {
w_IMP2=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CJNBNYNUXU',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',250,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_DESCRI(ctrlValue,kmode,e) {
if (Ne(w_DESCRI,ctrlValue)) {
var ctl = _GetCtl(e,'ZERUEFFPAN');
if (_tracker.goon(ctl,ctrlValue)) {
w_DESCRI=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ZERUEFFPAN',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',150,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_NOTE(ctrlValue,kmode,e) {
if (Ne(w_NOTE,ctrlValue)) {
var ctl = _GetCtl(e,'NHIBLOVEPP');
if (_tracker.goon(ctl,ctrlValue)) {
w_NOTE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NHIBLOVEPP',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',254,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_IMP1(ctrlValue,kmode,e) {
if (Ne(w_IMP1,ctrlValue)) {
var ctl = _GetCtl(e,'ISRIBATOWG');
if (_tracker.goon(ctl,ctrlValue)) {
w_IMP1=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ISRIBATOWG',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',250,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_IMP4(ctrlValue,kmode,e) {
if (Ne(w_IMP4,ctrlValue)) {
var ctl = _GetCtl(e,'QVCQRBWCAT');
if (_tracker.goon(ctl,ctrlValue)) {
w_IMP4=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QVCQRBWCAT',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',250,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_IMP3(ctrlValue,kmode,e) {
if (Ne(w_IMP3,ctrlValue)) {
var ctl = _GetCtl(e,'GHRZZISGXZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_IMP3=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('GHRZZISGXZ',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',250,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_IMP5(ctrlValue,kmode,e) {
if (Ne(w_IMP5,ctrlValue)) {
var ctl = _GetCtl(e,'VWCEDYCYHE');
if (_tracker.goon(ctl,ctrlValue)) {
w_IMP5=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VWCEDYCYHE',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',250,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_IMP6(ctrlValue,kmode,e) {
if (Ne(w_IMP6,ctrlValue)) {
var ctl = _GetCtl(e,'JZHAQSZZBZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_IMP6=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('JZHAQSZZBZ',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',250,0,'');
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
parent.ZtVWeb.raiseEventToEvalParms('armt_tbrapp_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('armt_tbrapp_dataNotSent',{'action':formaction});
}
}
}
}
CheckChild.child=[];
function Check() {
var l_bResult = true;
ResetErrorVars();
m_nLastError=0;
if ( ! (_ChkObl('QPKQOSKHNE',1))) {
_SignErr('QPKQOSKHNE');
m_cLastWorkVarErrorMsg='1991862090';
l_bResult=false;
w_IMP12022=HtW('','C');
} else if ( ! (_ChkObl('UXHOBDXZYD',1))) {
_SignErr('UXHOBDXZYD');
m_cLastWorkVarErrorMsg='1991862091';
l_bResult=false;
w_IMP22022=HtW('','C');
} else if ( ! (_ChkObl('SGYPEZIWSO',1))) {
_SignErr('SGYPEZIWSO');
m_cLastWorkVarErrorMsg='1991862092';
l_bResult=false;
w_IMP32022=HtW('','C');
} else if ( ! (_ChkObl('PWLMWGXLJT',1))) {
_SignErr('PWLMWGXLJT');
m_cLastWorkVarErrorMsg='1991862093';
l_bResult=false;
w_IMP42022=HtW('','C');
} else if ( ! (_ChkObl('RRLCWIMLZS',1))) {
_SignErr('RRLCWIMLZS');
m_cLastWorkVarErrorMsg='728551511';
l_bResult=false;
w_IMP52022=HtW('','C');
} else if ( ! (_ChkObl('MFEVNPBTPC',1))) {
_SignErr('MFEVNPBTPC');
m_cLastWorkVarErrorMsg='11748287033';
l_bResult=false;
w_IMP62022=HtW('','C');
} else if ( ! (_ChkObl('ADJOBBEXVH',1))) {
_SignErr('ADJOBBEXVH');
m_cLastWorkVarErrorMsg='112851763';
l_bResult=false;
w_CODICE=HtW('','C');
} else if ( ! (_ChkObl('ZERUEFFPAN',1))) {
_SignErr('ZERUEFFPAN');
m_cLastWorkVarErrorMsg='285808099';
l_bResult=false;
w_DESCRI=HtW('','C');
} else if ( ! (_ChkObl('NHIBLOVEPP',1))) {
_SignErr('NHIBLOVEPP');
m_cLastWorkVarErrorMsg='10593486746';
l_bResult=false;
w_NOTE=HtW('','C');
} else if ( ! (_ChkObl('ISRIBATOWG',1))) {
_SignErr('ISRIBATOWG');
m_cLastWorkVarErrorMsg='1991862090';
l_bResult=false;
w_IMP1=HtW('','C');
} else if ( ! (_ChkObl('CJNBNYNUXU',1))) {
_SignErr('CJNBNYNUXU');
m_cLastWorkVarErrorMsg='1991862090';
l_bResult=false;
w_IMP2=HtW('','C');
} else if ( ! (_ChkObl('GHRZZISGXZ',1))) {
_SignErr('GHRZZISGXZ');
m_cLastWorkVarErrorMsg='1991862092';
l_bResult=false;
w_IMP3=HtW('','C');
} else if ( ! (_ChkObl('QVCQRBWCAT',1))) {
_SignErr('QVCQRBWCAT');
m_cLastWorkVarErrorMsg='1991862093';
l_bResult=false;
w_IMP4=HtW('','C');
} else if ( ! (_ChkObl('VWCEDYCYHE',1))) {
_SignErr('VWCEDYCYHE');
m_cLastWorkVarErrorMsg='728551511';
l_bResult=false;
w_IMP5=HtW('','C');
} else if ( ! (_ChkObl('JZHAQSZZBZ',1))) {
_SignErr('JZHAQSZZBZ');
m_cLastWorkVarErrorMsg='11748287033';
l_bResult=false;
w_IMP6=HtW('','C');
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
l_oWv.setValue('IMP12022',WtA(w_IMP12022,'C'));
l_oWv.setValue('IMP22022',WtA(w_IMP22022,'C'));
l_oWv.setValue('IMP32022',WtA(w_IMP32022,'C'));
l_oWv.setValue('IMP42022',WtA(w_IMP42022,'C'));
l_oWv.setValue('IMP52022',WtA(w_IMP52022,'C'));
l_oWv.setValue('IMP62022',WtA(w_IMP62022,'C'));
l_oWv.setValue('IDBASE',WtA(w_IDBASE,'C'));
l_oWv.setValue('CODICE',WtA(w_CODICE,'C'));
l_oWv.setValue('DESCRI',WtA(w_DESCRI,'C'));
l_oWv.setValue('NOTE',WtA(w_NOTE,'C'));
l_oWv.setValue('IMP1',WtA(w_IMP1,'C'));
l_oWv.setValue('IMP2',WtA(w_IMP2,'C'));
l_oWv.setValue('IMP3',WtA(w_IMP3,'C'));
l_oWv.setValue('IMP4',WtA(w_IMP4,'C'));
l_oWv.setValue('IMP5',WtA(w_IMP5,'C'));
l_oWv.setValue('IMP6',WtA(w_IMP6,'C'));
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
FillWv.n=["IMP12022","IMP22022","IMP32022","IMP42022","IMP52022","IMP62022","IDBASE","CODICE","DESCRI","NOTE","IMP1","IMP2","IMP3","IMP4","IMP5","IMP6"];
function SetModified() {
m_bUpdated=true;
}
