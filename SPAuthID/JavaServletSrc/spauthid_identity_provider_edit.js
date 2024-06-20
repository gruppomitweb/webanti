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
if (IsDisabledByStateDriver('oidc')) {
Z.Tabs.Get("tabs_1_protocol_details").SetDisable('UDDMFJXDQC',true);
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
function Set_client_secret(ctrlValue,kmode,e) {
if (Ne(w_client_secret,ctrlValue)) {
var ctl = _GetCtl(e,'QBZZBCTPGR');
if (_tracker.goon(ctl,ctrlValue)) {
w_client_secret=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QBZZBCTPGR',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('QBZZBCTPGR',function(){return WtH(w_client_secret,'C',300,0,'')},w_client_secret);
return l_bResult;
} else {
ctl.value=WtH('','C',300,0,'');
_ResetTracker();
return true;
}
} else {
SPBOUILib.SetInputValue('QBZZBCTPGR',function(){return WtH(w_client_secret,'C',300,0,'')},w_client_secret);
}
return true;
}
function Set_autologin(ctrlValue,kmode,e) {
if (Ne(w_autologin,ctrlValue)) {
var ctl = _GetCtl(e,'DMCIAQQTSV');
if (_tracker.goon(ctl,ctrlValue)) {
w_autologin=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('DMCIAQQTSV',0);
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
function Set_idp_name(ctrlValue,kmode,e) {
if (Ne(w_idp_name,ctrlValue)) {
var ctl = _GetCtl(e,'YVFVLNIHTZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_idp_name=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YVFVLNIHTZ',0);
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
function Set_protocol(ctrlValue,kmode,e) {
if (Ne(w_protocol,ctrlValue)) {
var ctl = _GetCtl(e,'REJVNADODM');
if (_tracker.goon(ctl,ctrlValue)) {
w_protocol=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('REJVNADODM',0);
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
function Set_client_id(ctrlValue,kmode,e) {
if (Ne(w_client_id,ctrlValue)) {
var ctl = _GetCtl(e,'ALVFXOFWZD');
if (_tracker.goon(ctl,ctrlValue)) {
w_client_id=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ALVFXOFWZD',0);
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
function Set_auth_uri(ctrlValue,kmode,e) {
if (Ne(w_auth_uri,ctrlValue)) {
var ctl = _GetCtl(e,'KMSNRRLAKF');
if (_tracker.goon(ctl,ctrlValue)) {
w_auth_uri=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('KMSNRRLAKF',0);
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
function Set_redirect_uri(ctrlValue,kmode,e) {
if (Ne(w_redirect_uri,ctrlValue)) {
var ctl = _GetCtl(e,'VKCMWSSTIV');
if (_tracker.goon(ctl,ctrlValue)) {
w_redirect_uri=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VKCMWSSTIV',0);
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
function Set_scope(ctrlValue,kmode,e) {
if (Ne(w_scope,ctrlValue)) {
var ctl = _GetCtl(e,'TGJZUBGGYK');
if (_tracker.goon(ctl,ctrlValue)) {
w_scope=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('TGJZUBGGYK',0);
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
function Set_token_uri(ctrlValue,kmode,e) {
if (Ne(w_token_uri,ctrlValue)) {
var ctl = _GetCtl(e,'MCHBYAADDU');
if (_tracker.goon(ctl,ctrlValue)) {
w_token_uri=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MCHBYAADDU',0);
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
function Set_jwks_uri(ctrlValue,kmode,e) {
if (Ne(w_jwks_uri,ctrlValue)) {
var ctl = _GetCtl(e,'QGIOZABHHB');
if (_tracker.goon(ctl,ctrlValue)) {
w_jwks_uri=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QGIOZABHHB',0);
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
function Set_mutual_jwks(ctrlValue,kmode,e) {
if (Ne(w_mutual_jwks,ctrlValue)) {
var ctl = _GetCtl(e,'UPNIOVOHTB');
if (_tracker.goon(ctl,ctrlValue)) {
w_mutual_jwks=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UPNIOVOHTB',0);
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
UpdateAutonumber('');
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
parent.ZtVWeb.raiseEventToEvalParms('spauthid_identity_provider_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('spauthid_identity_provider_dataNotSent',{'action':formaction});
}
}
}
}
CheckChild.child=[];
function Check() {
var l_bResult = true;
ResetErrorVars();
m_nLastError=0;
if ( ! (_ChkObl('DMCIAQQTSV',1))) {
_SignErr('DMCIAQQTSV');
m_cLastWorkVarErrorMsg='11775259103';
l_bResult=false;
w_autologin='N';
} else if ( ! (_ChkObl('YVFVLNIHTZ',1))) {
_SignErr('YVFVLNIHTZ');
m_cLastWorkVarErrorMsg='443454';
l_bResult=false;
w_idp_name=HtW('','C');
} else if ( ! (_ChkObl('REJVNADODM',1))) {
_SignErr('REJVNADODM');
m_cLastWorkVarErrorMsg='900120012';
l_bResult=false;
w_protocol=HtW('','C');
} else if ( ! (_ChkObl('ALVFXOFWZD',1))) {
_SignErr('ALVFXOFWZD');
m_cLastWorkVarErrorMsg='11212891065';
l_bResult=false;
w_client_id=HtW('','M');
} else if ( ! (_ChkObl('QBZZBCTPGR',1))) {
_SignErr('QBZZBCTPGR');
m_cLastWorkVarErrorMsg='128747939';
l_bResult=false;
w_client_secret=HtW('','C');
} else if ( ! (_ChkObl('VKCMWSSTIV',1))) {
_SignErr('VKCMWSSTIV');
m_cLastWorkVarErrorMsg='11446125038';
l_bResult=false;
w_redirect_uri=HtW('','M');
} else if ( ! (_ChkObl('TGJZUBGGYK',1))) {
_SignErr('TGJZUBGGYK');
m_cLastWorkVarErrorMsg='7107971';
l_bResult=false;
w_scope=HtW('','C');
} else if ( ! (_ChkObl('KMSNRRLAKF',1))) {
_SignErr('KMSNRRLAKF');
m_cLastWorkVarErrorMsg='12012521349';
l_bResult=false;
w_auth_uri=HtW('','M');
} else if ( ! (_ChkObl('MCHBYAADDU',1))) {
_SignErr('MCHBYAADDU');
m_cLastWorkVarErrorMsg='2004140685';
l_bResult=false;
w_token_uri=HtW('','M');
} else if ( ! (_ChkObl('QGIOZABHHB',1))) {
_SignErr('QGIOZABHHB');
m_cLastWorkVarErrorMsg='10411589958';
l_bResult=false;
w_jwks_uri=HtW('','M');
} else if ( ! (_ChkObl('UPNIOVOHTB',1))) {
_SignErr('UPNIOVOHTB');
m_cLastWorkVarErrorMsg='1441552043';
l_bResult=false;
w_mutual_jwks='N';
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
l_oWv.setValue('code',WtA(w_code,'C'));
l_oWv.setValue('op_code',WtA(op_code,'C'));
l_oWv.setValue('autologin',WtA(w_autologin,'C'));
l_oWv.setValue('idp_name',WtA(w_idp_name,'C'));
l_oWv.setValue('protocol',WtA(w_protocol,'C'));
l_oWv.setValue('client_id',WtA(w_client_id,'M'));
l_oWv.setValue('client_secret',WtA(w_client_secret,'C'));
l_oWv.setValue('redirect_uri',WtA(w_redirect_uri,'M'));
l_oWv.setValue('scope',WtA(w_scope,'C'));
l_oWv.setValue('auth_uri',WtA(w_auth_uri,'M'));
l_oWv.setValue('token_uri',WtA(w_token_uri,'M'));
l_oWv.setValue('jwks_uri',WtA(w_jwks_uri,'M'));
l_oWv.setValue('mutual_jwks',WtA(w_mutual_jwks,'C'));
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
FillWv.n=["code","autologin","idp_name","protocol","client_id","client_secret","redirect_uri","scope","auth_uri","token_uri","jwks_uri","mutual_jwks"];
function SetModified() {
m_bUpdated=true;
}
