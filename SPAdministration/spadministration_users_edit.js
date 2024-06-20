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
function DisplayErrorMessage_spadministration_usersgroups() {
if ( ! (ChildToLoad(FrameRef('spadministration_usersgroups'))) && Ne(typeof(FrameRef('spadministration_usersgroups').DisplayErrorMessage),'undefined')) {
FrameRef('spadministration_usersgroups').DisplayErrorMessage();
}
}
function DisplayErrorMessage_spadministration_ssomap_child() {
if ( ! (ChildToLoad(FrameRef('spadministration_ssomap_child'))) && Ne(typeof(FrameRef('spadministration_ssomap_child').DisplayErrorMessage),'undefined')) {
FrameRef('spadministration_ssomap_child').DisplayErrorMessage();
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
l_bEnabled= ! (Ne(EntityStatus(),'E') || Eq(w_modifyPassword,1)) || IsDisabledByStateDriver('pwd1');
SetDisabled('GMYTSOEEXH',l_bEnabled);
l_bEnabled= ! (Eq(EntityStatus(),'N') || Eq(w_modifyPassword,1));
SetDisabled('ZZKRWOJQTG',l_bEnabled);
l_bEnabled= ! (Ne(EntityStatus(),'E') || Eq(w_modifyPassword,1)) || IsDisabledByStateDriver('pwd2');
SetDisabled('KIBLXEYDCR',l_bEnabled);
l_bEnabled= ! (Eq(EntityStatus(),'N') || Eq(w_modifyPassword,1));
SetDisabled('OTBBXDQDET',l_bEnabled);
l_bEnabled= ! (false) || IsDisabledByStateDriver('pwdcomplexity_group');
SetDisabled('TBXREXYXIU',l_bEnabled);
l_bEnabled= ! (w_IAR_LICENSE_VALID) || IsDisabledByStateDriver('usesiarlicense');
SetDisabled('ZOICKBMQFQ',l_bEnabled);
l_bEnabled= ! (Ne(w_g_OTPisActive,'N'));
SetDisabled('DUYHIUNXPN',l_bEnabled);
l_bEnabled= ! (false) || IsDisabledByStateDriver('companies');
SetDisabled('UYGLGETTUT',l_bEnabled);
l_bEnabled= ! (Eq(EntityStatus(),'N') || Eq(w_modifyPassword,1));
SetDisabled('OSVFPWEFJH',l_bEnabled);
l_bEnabled= ! (Eq(EntityStatus(),'N') || Eq(w_modifyPassword,1));
SetDisabled('XEGRJMWYIW',l_bEnabled);
if (IsDisabledByStateDriver('box_BGMYNICMON')) {
Z.Tabs.Get("tabs_1_configurazioni").SetDisable('BGMYNICMON',true);
}
if (IsDisabledByStateDriver('box_access')) {
DisableInputsInContainer(Ctrl('KVIFRCSRUG'),true);
}
if (IsDisabledByStateDriver('box_WUIVVJMUJT')) {
DisableInputsInContainer(Ctrl('WUIVVJMUJT'),true);
}
if (IsDisabledByStateDriver('pwd_layer')) {
Z.Tabs.Get("tabs_1_configurazioni").SetDisable('ZVNKOIBZTJ',true);
}
if (IsDisabledByStateDriver('language_formatting')) {
Z.Tabs.Get("tabs_1_configurazioni").SetDisable('QZSVKXVUQD',true);
}
if (IsDisabledByStateDriver('box_AXCUQKTKCI')) {
Z.Tabs.Get("tabs_1_configurazioni").SetDisable('AXCUQKTKCI',true);
}
if (IsDisabledByStateDriver('gruppi_appartenenza')) {
Z.Tabs.Get("tabs_1_configurazioni").SetDisable('FLMCUOBXBF',true);
}
if (IsDisabledByStateDriver('companies_hsect')) {
DisableInputsInContainer(Ctrl('GWZDNNWFFM'),true);
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
function Set_code(ctrlValue,kmode,e) {
if (Ne(w_code,ctrlValue)) {
var ctl = _GetCtl(e,'CIUGDDXJMR');
if (_tracker.goon(ctl,ctrlValue)) {
w_code=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CIUGDDXJMR',0);
if (l_bResult) {
l_bResult=Link_CIUGDDXJMR(kmode);
if ( ! (l_bResult)) {
w_code=HtW('','N');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'N',9,0,'999999999'));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','N',9,0,'999999999');
_ResetTracker();
return true;
}
}
return true;
}
function Set_fullname(ctrlValue,kmode,e) {
if (Ne(w_fullname,ctrlValue)) {
var ctl = _GetCtl(e,'YOMCOSHNCV');
if (_tracker.goon(ctl,ctrlValue)) {
w_fullname=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YOMCOSHNCV',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',2048,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_name(ctrlValue,kmode,e) {
if (Ne(w_name,ctrlValue)) {
var ctl = _GetCtl(e,'ZOLPGDGKUC');
if (_tracker.goon(ctl,ctrlValue)) {
w_name=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ZOLPGDGKUC',0);
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
function Set_accesstype_human(ctrlValue,kmode,e) {
if (Ne(w_accesstype_human,ctrlValue)) {
var ctl = _GetCtl(e,'RGNPWADGHN');
if (_tracker.goon(ctl,ctrlValue)) {
w_accesstype_human=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RGNPWADGHN',0);
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
function Set_accesstype_service(ctrlValue,kmode,e) {
if (Ne(w_accesstype_service,ctrlValue)) {
var ctl = _GetCtl(e,'GZOGXZQGVV');
if (_tracker.goon(ctl,ctrlValue)) {
w_accesstype_service=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('GZOGXZQGVV',0);
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
function Set_accesstype_machine(ctrlValue,kmode,e) {
if (Ne(w_accesstype_machine,ctrlValue)) {
var ctl = _GetCtl(e,'GSXRFLFMJR');
if (_tracker.goon(ctl,ctrlValue)) {
w_accesstype_machine=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('GSXRFLFMJR',0);
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
function Set_modifyPassword(ctrlValue,kmode,e) {
if (Ne(w_modifyPassword,ctrlValue)) {
var ctl = _GetCtl(e,'FTIRRMMSXK');
if (_tracker.goon(ctl,ctrlValue)) {
w_modifyPassword=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FTIRRMMSXK',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH(0,'N',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_pwd1(ctrlValue,kmode,e) {
if (Ne(w_pwd1,ctrlValue)) {
var ctl = _GetCtl(e,'GMYTSOEEXH');
if (_tracker.goon(ctl,ctrlValue)) {
w_pwd1=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('GMYTSOEEXH',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',20,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_companies(ctrlValue,kmode,e) {
if (Ne(w_companies,ctrlValue)) {
var ctl = _GetCtl(e,'UYGLGETTUT');
if (_tracker.goon(ctl,ctrlValue)) {
w_companies=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UYGLGETTUT',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',2000,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_datestart(ctrlValue,kmode,e) {
if (Ne(w_datestart,ctrlValue)) {
var ctl = _GetCtl(e,'DWGQEAJBOS');
if (_tracker.goon(ctl,ctrlValue)) {
w_datestart=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('DWGQEAJBOS',0);
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
function Set_pwd2(ctrlValue,kmode,e) {
if (Ne(w_pwd2,ctrlValue)) {
var ctl = _GetCtl(e,'KIBLXEYDCR');
if (_tracker.goon(ctl,ctrlValue)) {
w_pwd2=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
var l_bWarn = true;
l_bResult=_ChkObl('KIBLXEYDCR',0);
if (l_bResult) {
if (l_bResult && ( ! (Eq(w_pwd1,w_pwd2)) && Ne(m_nLastError,-2))) {
try {
_tracker.askwrn=true;
l_bWarn=WindowConfirm(AlertErrorMessage('1848680752'));
} finally {
_tracker.askwrn=false;
}
}
if ( ! (l_bResult) ||  ! (l_bWarn)) {
w_pwd2=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult) ||  ! (l_bWarn)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',20,0,''));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',20,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_pwdcomplexity_group(ctrlValue,kmode,e) {
if (Ne(w_pwdcomplexity_group,ctrlValue)) {
var ctl = _GetCtl(e,'TBXREXYXIU');
if (_tracker.goon(ctl,ctrlValue)) {
w_pwdcomplexity_group=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('TBXREXYXIU',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','N',3,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_pwdcomplexity(ctrlValue,kmode,e) {
if (Ne(w_pwdcomplexity,ctrlValue)) {
var ctl = _GetCtl(e,'YDSHUIXYEH');
if (_tracker.goon(ctl,ctrlValue)) {
w_pwdcomplexity=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YDSHUIXYEH',0);
if (l_bResult) {
l_bResult=Ge(w_pwdcomplexity,0) && Le(w_pwdcomplexity,UserAdmin.GetPasswordRatingMaxReachable());
if ( ! (l_bResult)) {
m_nLastError=2;
m_cLastWorkVarErrorMsg='11873255554';
m_cLastMsgError=AlertErrorMessage('10892072166');
}
if ( ! (l_bResult)) {
w_pwdcomplexity=HtW('','N');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'N',3,0,''));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','N',3,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_datestop(ctrlValue,kmode,e) {
if (Ne(w_datestop,ctrlValue)) {
var ctl = _GetCtl(e,'AFHAPKTVTZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_datestop=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('AFHAPKTVTZ',0);
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
function Set_forcepwdchange(ctrlValue,kmode,e) {
if (Ne(w_forcepwdchange,ctrlValue)) {
var ctl = _GetCtl(e,'RRBOVTXUAU');
if (_tracker.goon(ctl,ctrlValue)) {
w_forcepwdchange=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RRBOVTXUAU',0);
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
function Set_enabled(ctrlValue,kmode,e) {
if (Ne(w_enabled,ctrlValue)) {
var ctl = _GetCtl(e,'GNSADWOGKM');
if (_tracker.goon(ctl,ctrlValue)) {
w_enabled=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('GNSADWOGKM',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('E','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_language(ctrlValue,kmode,e) {
if (Ne(w_language,ctrlValue)) {
var ctl = _GetCtl(e,'XFCGDYJJAR');
if (_tracker.goon(ctl,ctrlValue)) {
w_language=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XFCGDYJJAR',0);
if (l_bResult) {
l_bResult=Link_XFCGDYJJAR(kmode);
if ( ! (l_bResult)) {
w_language=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',3,0,''));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',3,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_captchalevel(ctrlValue,kmode,e) {
if (Ne(w_captchalevel,ctrlValue)) {
var ctl = _GetCtl(e,'WLRWPELGIS');
if (_tracker.goon(ctl,ctrlValue)) {
w_captchalevel=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('WLRWPELGIS',0);
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
function Set_decimalseparator(ctrlValue,kmode,e) {
if (Ne(w_decimalseparator,ctrlValue)) {
var ctl = _GetCtl(e,'IZJFQHGQUB');
if (_tracker.goon(ctl,ctrlValue)) {
w_decimalseparator=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('IZJFQHGQUB',0);
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
function Set_thousandseparator(ctrlValue,kmode,e) {
if (Ne(w_thousandseparator,ctrlValue)) {
var ctl = _GetCtl(e,'ACYLERWDKK');
if (_tracker.goon(ctl,ctrlValue)) {
w_thousandseparator=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ACYLERWDKK',0);
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
function Set_datepattern(ctrlValue,kmode,e) {
if (Ne(w_datepattern,ctrlValue)) {
var ctl = _GetCtl(e,'EVNGTHPGLR');
if (_tracker.goon(ctl,ctrlValue)) {
w_datepattern=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('EVNGTHPGLR',0);
if (l_bResult) {
l_bResult=Empty(w_datepattern) || (Gt(At('YYYY',w_datepattern),0) && Gt(At('MM',w_datepattern),0) && Gt(At('DD',w_datepattern),0));
if ( ! (l_bResult)) {
m_nLastError=2;
m_cLastWorkVarErrorMsg='10992262541';
m_cLastMsgError=AlertErrorMessage('495629605');
}
if ( ! (l_bResult)) {
w_datepattern=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',12,0,''));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',12,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_datetimepattern(ctrlValue,kmode,e) {
if (Ne(w_datetimepattern,ctrlValue)) {
var ctl = _GetCtl(e,'BOLWRICGIA');
if (_tracker.goon(ctl,ctrlValue)) {
w_datetimepattern=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BOLWRICGIA',0);
if (l_bResult) {
l_bResult=Empty(w_datetimepattern) || (Gt(At('YYYY',w_datetimepattern),0) && Gt(At('MM',w_datetimepattern),0) && Gt(At('DD',w_datetimepattern),0) && Gt(At('hh',w_datetimepattern),0) && Gt(At('mm',w_datetimepattern),0) && Gt(At('ss',w_datetimepattern),0));
if ( ! (l_bResult)) {
m_nLastError=2;
m_cLastWorkVarErrorMsg='11086835527';
m_cLastMsgError=AlertErrorMessage('770280807');
}
if ( ! (l_bResult)) {
w_datetimepattern=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',25,0,''));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',25,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_usesiarlicense(ctrlValue,kmode,e) {
if (Ne(w_usesiarlicense,ctrlValue)) {
var ctl = _GetCtl(e,'ZOICKBMQFQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_usesiarlicense=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ZOICKBMQFQ',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('F','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_pwddaysduration(ctrlValue,kmode,e) {
if (Ne(w_pwddaysduration,ctrlValue)) {
var ctl = _GetCtl(e,'NTAYXBDPVY');
if (_tracker.goon(ctl,ctrlValue)) {
w_pwddaysduration=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NTAYXBDPVY',0);
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
function Set_otp(ctrlValue,kmode,e) {
if (Ne(w_otp,ctrlValue)) {
var ctl = _GetCtl(e,'UOJLIHOZBH');
if (_tracker.goon(ctl,ctrlValue)) {
w_otp=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UOJLIHOZBH',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',100,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_pwdciclicity(ctrlValue,kmode,e) {
if (Ne(w_pwdciclicity,ctrlValue)) {
var ctl = _GetCtl(e,'CLZCOSTIAC');
if (_tracker.goon(ctl,ctrlValue)) {
w_pwdciclicity=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CLZCOSTIAC',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','N',2,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_UFENABLEAZI(ctrlValue,kmode,e) {
if (Ne(w_UFENABLEAZI,ctrlValue)) {
var ctl = _GetCtl(e,'VRCQKXWFPX');
if (_tracker.goon(ctl,ctrlValue)) {
w_UFENABLEAZI=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VRCQKXWFPX',0);
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
function Set_printserver(ctrlValue,kmode,e) {
if (Ne(w_printserver,ctrlValue)) {
var ctl = _GetCtl(e,'BLGCNCYQRJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_printserver=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BLGCNCYQRJ',0);
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
function Set_selected_group(ctrlValue,kmode,e) {
if (Ne(w_selected_group,ctrlValue)) {
var ctl = _GetCtl(e,'XNDAWTQDZS');
if (_tracker.goon(ctl,ctrlValue)) {
w_selected_group=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XNDAWTQDZS',0);
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
if ( ! (ChildToLoad(FrameRef('spadministration_usersgroups'))) && Ne(typeof(FrameRef('spadministration_usersgroups').DoUpdate),'undefined')) {
CopyWorkVar(FrameRef('spadministration_usersgroups'),['selected_group'],['selected_group'],true)
}
if ((Ne(o_modifyPassword,w_modifyPassword))) {
Calculation_YULXNUPOWY();
}
if ((Ne(o_pwd1,w_pwd1)) || (Ne(o_modifyPassword,w_modifyPassword))) {
w_calcomplex=UserAdmin.GetPasswordRating(w_pwd1);
}
if ((Ne(o_pwd1,w_pwd1))) {
w_pwdratecause=UserAdmin.GetPasswordRatingExplaination(w_pwd1);
}
if ((Ne(o_code,w_code))) {
w_pwdcomplexity_group=spadministration_getpwdcomplexity_group(w_code);
}
w_pwdcomplexity_reqired=Max(w_pwdcomplexity,w_pwdcomplexity_group);
if ((Ne(o_code,w_code))) {
w_pwddaysduration_group=spadministration_getpwdduration_group(w_code);
}
if ((Ne(o_code,w_code))) {
w_pwdciclicity_groups=spadministration_getpwdciclicity_group(w_code);
}
if ((Ne(o_code,w_code))) {
w_pwdcaptchalevel_group=spadministration_getcaptchalevel_group(w_code);
}
if ((Ne(o_pwddaysduration,w_pwddaysduration)) || (Ne(o_pwddaysduration_group,w_pwddaysduration_group))) {
w_pwddaysduration_applied=(Gt(w_pwddaysduration,0) && Gt(w_pwddaysduration_group,0)?Min(w_pwddaysduration,w_pwddaysduration_group):Max(w_pwddaysduration,w_pwddaysduration_group));
}
if ((Ne(o_pwdciclicity,w_pwdciclicity)) || (Ne(o_pwdciclicity_groups,w_pwdciclicity_groups))) {
w_pwdciclicity_applied=Max(w_pwdciclicity,w_pwdciclicity_groups);
}
if ((Ne(o_captchalevel,w_captchalevel)) || (Ne(o_pwdcaptchalevel_group,w_pwdcaptchalevel_group))) {
w_pwdcaptchalevel_applied=(Gt(w_captchalevel,0) && Gt(w_pwdcaptchalevel_group,0)?Min(w_captchalevel,w_pwdcaptchalevel_group):Max(w_captchalevel,w_pwdcaptchalevel_group));
}
if ((Ne(o_pwd1,w_pwd1)) || (Ne(o_pwd2,w_pwd2))) {
w_pwd_modified=true;
}
if ((Ne(o_UFENABLEAZI,w_UFENABLEAZI))) {
w_grdcompanies.Calculate(Eq(w_UFENABLEAZI,'s'));
}
w_IAR_AVAILABLE=w_IAR_LICENSES-w_IAR_USED;
if ((Ne(o_UFENABLEAZI,w_UFENABLEAZI))) {
w_companies=(Eq(w_UFENABLEAZI,'n')?'':w_companies);
}
if ((Ne(o_companies,w_companies))) {
w_UFENABLEAZI=(Empty(w_companies)?'n':'s');
}
LibJavascript.forEachItem(m_FoundlingCopyWorkVar,i_body_1)
function i_body_1(child){
child();
}
// * --- Area Manuale = UI - Calculate
// * --- spadministration_users
//Vario l'abilitazione delle aziende
//if(w_UFENABLEAZI=='n') {
  //Svuoto le companies
  //Set_companies('');
//}

if (w_modifyPassword == 0) {
  setPasswordType();
}
// * --- Fine Area Manuale
m_bCalculating=false;
}
function Calculation_YULXNUPOWY() {
if (Eq(w_modifyPassword,1)) {
w_pwd1='';
}
if (Eq(w_modifyPassword,1)) {
w_pwd2='';
}
if (Eq(w_modifyPassword,0)) {
w_pwd1='cambia la password';
}
if (Eq(w_modifyPassword,0)) {
w_pwd2='cambia la password';
}
}
function Check_DPHWQTPSFC(p_bForce) {
var l_bResult = true;
if (p_bForce) {
l_bResult= ! (w_pwd_modified) || UserAdmin.CheckPasswordStrength(w_pwd1,w_pwdcomplexity_reqired);
if ( ! (l_bResult)) {
m_cLastMsgError=AlertErrorMessage('1110746968');
} else {
l_bResult=Eq(w_pwd1,w_pwd2);
if ( ! (l_bResult)) {
m_cLastMsgError=AlertErrorMessage('1848680752');
}
}
}
return l_bResult;
}
function Check_BLWKYYPKAQ(p_bForce) {
var l_bResult = true;
if (p_bForce) {
l_bResult=Gt(w_code,0);
if ( ! (l_bResult)) {
m_cLastMsgError=AlertErrorMessage('766901589');
}
}
return l_bResult;
}
function SaveDependsOn() {
o_code=w_code;
o_modifyPassword=w_modifyPassword;
o_pwd1=w_pwd1;
o_pwd2=w_pwd2;
o_pwddaysduration_group=w_pwddaysduration_group;
o_pwddaysduration=w_pwddaysduration;
o_pwdciclicity_groups=w_pwdciclicity_groups;
o_pwdciclicity=w_pwdciclicity;
o_pwdcaptchalevel_group=w_pwdcaptchalevel_group;
o_captchalevel=w_captchalevel;
o_selected_group=w_selected_group;
o_companies=w_companies;
o_UFENABLEAZI=w_UFENABLEAZI;
}
function SaveLabelDependsOn() {
}
function Link_CIUGDDXJMR(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_code);
var l_Appl = LinkApplet();
l_Appl.SetDoubleKey('code',w_code,9,0);
l_Appl.SetFields('code,cpotp');
l_Appl.SetTypes('N,C');
l_Appl.LinkTable('cpusers');
l_Appl.SetID('CIUGDDXJMR');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_code=l_Appl.GetDoubleValue('code',9,0);
w_otp=l_Appl.GetStringValue('cpotp',100,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_CIUGDDXJMR_Blank();
l_bResult=true;
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_CIUGDDXJMR';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_CIUGDDXJMR();
l_oWv.setValue('FieldFilter',l_cFieldFilter);
if ( ! (Empty(l_Appl.GetWhereAddedFixedFiltersUnencoded()))) {
if ( ! (Empty(l_cFixedFilter))) {
l_cFixedFilter=l_cFixedFilter+' and ';
}
l_cFixedFilter=l_cFixedFilter+l_Appl.GetWhereAddedFixedFiltersUnencoded();
}
l_oWv.setValue('FixedFilter',l_cFixedFilter);
var initEntityFields = '';
layerOpenForeground(l_cLinkUrl,openername,'toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes');
m_nLastError=-2;
} else {
if ( ! (l_bResult)) {
m_nLastError=3;
m_cLastWorkVarErrorMsg='';
if (Lt(l_nRec,0)) {
m_cLastMsgError=Translate('MSG_CONNECT_SERVER');
}
}
}
return l_bResult;
}
function Link_CIUGDDXJMR_Blank() {
w_otp='';
}
function LOpt_CIUGDDXJMR() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('cpusers','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('code','C'));
l_oWv.setValue('LinkedField',WtA('code','C'));
l_oWv.setValue('UID',WtA('CIUGDDXJMR','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['CIUGDDXJMR'][1],'C'));
return l_oWv;
}
function Link_XFCGDYJJAR(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_language);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('code',w_language,3,0);
l_Appl.SetFields('code,name');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('cplangs');
l_Appl.SetLinkzoom('spadministration_langs');
l_Appl.SetID('XFCGDYJJAR');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_language=l_Appl.GetStringValue('code',3,0);
w_language_name=l_Appl.GetStringValue('name',25,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_XFCGDYJJAR_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_XFCGDYJJAR';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_XFCGDYJJAR();
l_oWv.setValue('FieldFilter',l_cFieldFilter);
if ( ! (Empty(l_Appl.GetWhereAddedFixedFiltersUnencoded()))) {
if ( ! (Empty(l_cFixedFilter))) {
l_cFixedFilter=l_cFixedFilter+' and ';
}
l_cFixedFilter=l_cFixedFilter+l_Appl.GetWhereAddedFixedFiltersUnencoded();
}
l_oWv.setValue('FixedFilter',l_cFixedFilter);
var initEntityFields = '';
layerOpenForeground(l_cLinkUrl,openername,'toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes');
m_nLastError=-2;
} else {
if ( ! (l_bResult)) {
m_nLastError=3;
m_cLastWorkVarErrorMsg='';
if (Lt(l_nRec,0)) {
m_cLastMsgError=Translate('MSG_CONNECT_SERVER');
}
}
}
return l_bResult;
}
function Link_XFCGDYJJAR_Blank() {
w_language='';
w_language_name='';
}
function LOpt_XFCGDYJJAR() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('cplangs','C'));
l_oWv.setValue('Linkzoomprg',WtA('spadministration_langs','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('code','C'));
l_oWv.setValue('LinkedField',WtA('code','C'));
l_oWv.setValue('UID',WtA('XFCGDYJJAR','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['XFCGDYJJAR'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('10810475596'),'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'CIUGDDXJMR')) {
last_focused_comp=GetLastFocusedElementOfLink('CIUGDDXJMR');
function SetMethod_CIUGDDXJMR() {
Set_code(HtW(value,'N'),0);
}
if (IsDeviceMobile()) {
SetMethod_CIUGDDXJMR();
} else {
setTimeout(SetMethod_CIUGDDXJMR,1);
}
bResult=true;
}
if (Eq(varName,'XFCGDYJJAR')) {
last_focused_comp=GetLastFocusedElementOfLink('XFCGDYJJAR');
function SetMethod_XFCGDYJJAR() {
Set_language(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_XFCGDYJJAR();
} else {
setTimeout(SetMethod_XFCGDYJJAR,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'CIUGDDXJMR')) {
return [Ctrl('CIUGDDXJMR')];
}
if (Eq(varName,'XFCGDYJJAR')) {
return [Ctrl('XFCGDYJJAR')];
}
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
bResult=(Empty(w_decimalseparator) && Empty(w_thousandseparator) && Empty(w_datepattern) && Empty(w_datetimepattern)) || ( ! (Empty(w_decimalseparator)) &&  ! (Empty(w_thousandseparator)) &&  ! (Empty(w_datepattern)) &&  ! (Empty(w_datetimepattern)) && Ne(w_decimalseparator,w_thousandseparator) && Ne(w_datepattern,w_datetimepattern));
if ( ! (bResult)) {
m_cLastMsgError=AlertErrorMessage('12136232393');
}
}
if (bResult &&  ! ( ! (spadministration_check_username(w_code,w_name)))) {
try {
_tracker.askwrn=true;
bResult=WindowConfirm(AlertErrorMessage('1060953294'));
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
parent.ZtVWeb.raiseEventToEvalParms('spadministration_users_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('spadministration_users_dataNotSent',{'action':formaction});
}
}
}
}
CheckChild.child=[{'prg':"spadministration_usersgroups",'BOScId':function(){ return FrameRef('spadministration_usersgroups')},'repeated':0},{'prg':"spadministration_ssomap_child",'BOScId':function(){ return FrameRef('spadministration_ssomap_child')},'repeated':0}];
function Check() {
var l_bResult = true;
var l_bChildCheck = true;
ResetErrorVars();
m_nLastError=0;
if ( ! (_ChkObl('CIUGDDXJMR',1))) {
_SignErr('CIUGDDXJMR');
m_cLastWorkVarErrorMsg='960685589';
l_bResult=false;
w_code=HtW('','N');
} else if ( ! (_ChkObl('YOMCOSHNCV',1))) {
_SignErr('YOMCOSHNCV');
m_cLastWorkVarErrorMsg='11595652979';
l_bResult=false;
w_fullname=HtW('','C');
} else if ( ! (_ChkObl('ZOLPGDGKUC',1))) {
_SignErr('ZOLPGDGKUC');
m_cLastWorkVarErrorMsg='1682105886';
l_bResult=false;
w_name=HtW('','C');
} else if ( ! (_ChkObl('RGNPWADGHN',1))) {
_SignErr('RGNPWADGHN');
m_cLastWorkVarErrorMsg='122177958';
l_bResult=false;
w_accesstype_human=false;
} else if ( ! (_ChkObl('GZOGXZQGVV',1))) {
_SignErr('GZOGXZQGVV');
m_cLastWorkVarErrorMsg='11173517738';
l_bResult=false;
w_accesstype_service=false;
} else if ( ! (_ChkObl('GSXRFLFMJR',1))) {
_SignErr('GSXRFLFMJR');
m_cLastWorkVarErrorMsg='10989948426';
l_bResult=false;
w_accesstype_machine=false;
} else if ( ! (_ChkObl('FTIRRMMSXK',1))) {
_SignErr('FTIRRMMSXK');
m_cLastWorkVarErrorMsg='modifyPassword';
l_bResult=false;
w_modifyPassword=0;
} else if ((Ne(EntityStatus(),'E') || Eq(w_modifyPassword,1)) && ( ! (_ChkObl('GMYTSOEEXH',1)))) {
_SignErr('GMYTSOEEXH','1110746968');
l_bResult=false;
w_pwd1=HtW('','C');
} else if ((Ne(EntityStatus(),'E') || Eq(w_modifyPassword,1)) && ( ! (_ChkObl('KIBLXEYDCR',1)))) {
_SignErr('KIBLXEYDCR');
m_cLastWorkVarErrorMsg='983832109';
l_bResult=false;
w_pwd2=HtW('','C');
} else if ((false) && ( ! (_ChkObl('TBXREXYXIU',1)))) {
_SignErr('TBXREXYXIU');
m_cLastWorkVarErrorMsg='11873255554';
l_bResult=false;
w_pwdcomplexity_group=HtW('','N');
} else if (( ! (_ChkObl('YDSHUIXYEH',1))) || ( ! (Ge(w_pwdcomplexity,0) && Le(w_pwdcomplexity,UserAdmin.GetPasswordRatingMaxReachable())))) {
_SignErr('YDSHUIXYEH','10892072166');
l_bResult=false;
w_pwdcomplexity=HtW('','N');
} else if ( ! (_ChkObl('RRBOVTXUAU',1))) {
_SignErr('RRBOVTXUAU');
m_cLastWorkVarErrorMsg='65259300';
l_bResult=false;
w_forcepwdchange=false;
} else if ( ! (_ChkObl('GNSADWOGKM',1))) {
_SignErr('GNSADWOGKM');
m_cLastWorkVarErrorMsg='10556996636';
l_bResult=false;
w_enabled='E';
} else if ( ! (_ChkObl('XFCGDYJJAR',1))) {
_SignErr('XFCGDYJJAR');
m_cLastWorkVarErrorMsg='1725844287';
l_bResult=false;
w_language=HtW('','C');
} else if ( ! (_ChkObl('IZJFQHGQUB',1))) {
_SignErr('IZJFQHGQUB');
m_cLastWorkVarErrorMsg='decimalseparator';
l_bResult=false;
w_decimalseparator=HtW('','C');
} else if ( ! (_ChkObl('ACYLERWDKK',1))) {
_SignErr('ACYLERWDKK');
m_cLastWorkVarErrorMsg='thousandseparator';
l_bResult=false;
w_thousandseparator=HtW('','C');
} else if (( ! (_ChkObl('EVNGTHPGLR',1))) || ( ! (Empty(w_datepattern) || (Gt(At('YYYY',w_datepattern),0) && Gt(At('MM',w_datepattern),0) && Gt(At('DD',w_datepattern),0))))) {
_SignErr('EVNGTHPGLR','495629605');
l_bResult=false;
w_datepattern=HtW('','C');
} else if (( ! (_ChkObl('BOLWRICGIA',1))) || ( ! (Empty(w_datetimepattern) || (Gt(At('YYYY',w_datetimepattern),0) && Gt(At('MM',w_datetimepattern),0) && Gt(At('DD',w_datetimepattern),0) && Gt(At('hh',w_datetimepattern),0) && Gt(At('mm',w_datetimepattern),0) && Gt(At('ss',w_datetimepattern),0))))) {
_SignErr('BOLWRICGIA','770280807');
l_bResult=false;
w_datetimepattern=HtW('','C');
} else if ( ! (_ChkObl('NTAYXBDPVY',1))) {
_SignErr('NTAYXBDPVY');
m_cLastWorkVarErrorMsg='1076819334';
l_bResult=false;
w_pwddaysduration=HtW('','N');
} else if ( ! (_ChkObl('CLZCOSTIAC',1))) {
_SignErr('CLZCOSTIAC');
m_cLastWorkVarErrorMsg='11641847591';
l_bResult=false;
w_pwdciclicity=HtW('','N');
} else if ( ! (_ChkObl('WLRWPELGIS',1))) {
_SignErr('WLRWPELGIS');
m_cLastWorkVarErrorMsg='10075957577';
l_bResult=false;
w_captchalevel=HtW('','N');
} else if ( ! (_ChkObl('DWGQEAJBOS',1))) {
_SignErr('DWGQEAJBOS');
m_cLastWorkVarErrorMsg='20009153';
l_bResult=false;
w_datestart=HtW('','D');
} else if ( ! (_ChkObl('AFHAPKTVTZ',1))) {
_SignErr('AFHAPKTVTZ');
m_cLastWorkVarErrorMsg='556515051';
l_bResult=false;
w_datestop=HtW('','D');
} else if ( ! (_ChkObl('BLGCNCYQRJ',1))) {
_SignErr('BLGCNCYQRJ');
m_cLastWorkVarErrorMsg='753676303';
l_bResult=false;
w_printserver=HtW('','C');
} else if ((w_IAR_LICENSE_VALID) && ( ! (_ChkObl('ZOICKBMQFQ',1)))) {
_SignErr('ZOICKBMQFQ');
m_cLastWorkVarErrorMsg='11958389719';
l_bResult=false;
w_usesiarlicense='F';
} else if ( ! (_ChkObl('XNDAWTQDZS',1))) {
_SignErr('XNDAWTQDZS');
m_cLastWorkVarErrorMsg='selected_group';
l_bResult=false;
w_selected_group=HtW('','N');
} else if ( ! (_ChkObl('UOJLIHOZBH',1))) {
_SignErr('UOJLIHOZBH');
m_cLastWorkVarErrorMsg='otp';
l_bResult=false;
w_otp=HtW('','C');
} else if ((false) && ( ! (_ChkObl('UYGLGETTUT',1)))) {
_SignErr('UYGLGETTUT');
m_cLastWorkVarErrorMsg='11068993370';
l_bResult=false;
w_companies=HtW('','C');
} else if ( ! (_ChkObl('VRCQKXWFPX',1))) {
_SignErr('VRCQKXWFPX');
m_cLastWorkVarErrorMsg='11586272425';
l_bResult=false;
w_UFENABLEAZI=HtW('','C');
} else if ( ! (Check_DPHWQTPSFC(true))) {
l_bResult = false;
} else if ( ! (Check_BLWKYYPKAQ(true))) {
l_bResult = false;
}
if (l_bResult) {
l_bResult=CheckChild(0);
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('DWGQEAJBOS_ZOOM',lc)) {
return 0;
}
if (Eq('AFHAPKTVTZ_ZOOM',lc)) {
return 0;
}
return -1;
}
function link_url(index) {
var l_oWv;
}
function FillWv() {
var l_oWv = InitWvApplet();
l_oWv.setValue('m_CheckVars',JSON.stringify(m_CheckVars));
l_oWv.setValue('code',WtA(w_code,'N'));
l_oWv.setValue('fullname',WtA(w_fullname,'C'));
l_oWv.setValue('name',WtA(w_name,'C'));
l_oWv.setValue('accesstype_human',WtA(w_accesstype_human,'L'));
l_oWv.setValue('accesstype_service',WtA(w_accesstype_service,'L'));
l_oWv.setValue('accesstype_machine',WtA(w_accesstype_machine,'L'));
l_oWv.setValue('pwdcomplexity',WtA(w_pwdcomplexity,'N'));
l_oWv.setValue('forcepwdchange',WtA(w_forcepwdchange,'L'));
l_oWv.setValue('enabled',WtA(w_enabled,'C'));
l_oWv.setValue('language',WtA(w_language,'C'));
l_oWv.setValue('decimalseparator',WtA(w_decimalseparator,'C'));
l_oWv.setValue('thousandseparator',WtA(w_thousandseparator,'C'));
l_oWv.setValue('datepattern',WtA(w_datepattern,'C'));
l_oWv.setValue('datetimepattern',WtA(w_datetimepattern,'C'));
l_oWv.setValue('pwddaysduration',WtA(w_pwddaysduration,'N'));
l_oWv.setValue('pwdciclicity',WtA(w_pwdciclicity,'N'));
l_oWv.setValue('captchalevel',WtA(w_captchalevel,'N'));
l_oWv.setValue('datestart',WtA(w_datestart,'D'));
l_oWv.setValue('datestop',WtA(w_datestop,'D'));
l_oWv.setValue('failedlogins',WtA(w_failedlogins,'N'));
l_oWv.setValue('lastfailedlogin',WtA(w_lastfailedlogin,'T'));
l_oWv.setValue('lastsuccessfullogin',WtA(w_lastsuccessfullogin,'T'));
l_oWv.setValue('pwdcreate',WtA(w_pwdcreate,'T'));
l_oWv.setValue('printserver',WtA(w_printserver,'C'));
l_oWv.setValue('createdwhen',WtA(w_createdwhen,'T'));
l_oWv.setValue('usesiarlicense',WtA(w_usesiarlicense,'C'));
l_oWv.setValue('companies',WtA(w_companies,'C'));
l_oWv.setValue('modifyPassword',WtA(w_modifyPassword,'N'));
l_oWv.setValue('pwd1',WtA(w_pwd1,'C'));
l_oWv.setValue('calcomplex',WtA(w_calcomplex,'N'));
l_oWv.setValue('pwdratecause',WtA(w_pwdratecause,'M'));
l_oWv.setValue('pwd2',WtA(w_pwd2,'C'));
l_oWv.setValue('pwdcomplexity_group',WtA(w_pwdcomplexity_group,'N'));
l_oWv.setValue('pwdcomplexity_reqired',WtA(w_pwdcomplexity_reqired,'N'));
l_oWv.setValue('language_name',WtA(w_language_name,'C'));
l_oWv.setValue('pwddaysduration_group',WtA(w_pwddaysduration_group,'N'));
l_oWv.setValue('pwdciclicity_groups',WtA(w_pwdciclicity_groups,'N'));
l_oWv.setValue('pwdcaptchalevel_group',WtA(w_pwdcaptchalevel_group,'N'));
l_oWv.setValue('pwddaysduration_applied',WtA(w_pwddaysduration_applied,'N'));
l_oWv.setValue('pwdciclicity_applied',WtA(w_pwdciclicity_applied,'N'));
l_oWv.setValue('pwdcaptchalevel_applied',WtA(w_pwdcaptchalevel_applied,'N'));
l_oWv.setValue('init_code',WtA(w_init_code,'N'));
l_oWv.setValue('pwd_modified',WtA(w_pwd_modified,'L'));
l_oWv.setValue('IAR_LICENSE_VALID',WtA(w_IAR_LICENSE_VALID,'L'));
l_oWv.setValue('IAR_LICENSES',WtA(w_IAR_LICENSES,'N'));
l_oWv.setValue('IAR_USED',WtA(w_IAR_USED,'N'));
l_oWv.setValue('IAR_AVAILABLE',WtA(w_IAR_AVAILABLE,'N'));
l_oWv.setValue('selected_group',WtA(w_selected_group,'N'));
l_oWv.setValue('g_OTPisActive',WtA(w_g_OTPisActive,'C'));
l_oWv.setValue('otp',WtA(w_otp,'C'));
l_oWv.setValue('UFENABLEAZI',WtA(w_UFENABLEAZI,'C'));
l_oWv.setValue('pwd1_view',WtA(w_pwd1_view,'L'));
l_oWv.setValue('pwd2_view',WtA(w_pwd2_view,'L'));
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
_FillChildren.n=['spadministration_usersgroups','spadministration_ssomap_child','spadministration_historypwd','spadministration_usercompanies'];
FillWv.n=["code","fullname","name","accesstype_human","accesstype_service","accesstype_machine","pwdcomplexity","forcepwdchange","enabled","language","decimalseparator","thousandseparator","datepattern","datetimepattern","pwddaysduration","pwdciclicity","captchalevel","datestart","datestop","failedlogins","lastfailedlogin","lastsuccessfullogin","pwdcreate","printserver","createdwhen","usesiarlicense","companies","modifyPassword","pwd1","calcomplex","pwdratecause","pwd2","pwdcomplexity_group","pwdcomplexity_reqired","language_name","pwddaysduration_group","pwdciclicity_groups","pwdcaptchalevel_group","pwddaysduration_applied","pwdciclicity_applied","pwdcaptchalevel_applied","init_code","pwd_modified","IAR_LICENSE_VALID","IAR_LICENSES","IAR_USED","IAR_AVAILABLE","selected_group","g_OTPisActive","otp","UFENABLEAZI","pwd1_view","pwd2_view"];
function SetModified() {
m_bUpdated=true;
}
function SetChildVariables_spadministration_usersgroups() {
if ( ! (ChildToLoad(FrameRef('spadministration_usersgroups'))) && Ne(typeof(FrameRef('spadministration_usersgroups').DoUpdate),'undefined')) {
CopyWorkVar(FrameRef('spadministration_usersgroups'),['selected_group'],['selected_group'],false)
}
}
function CtxLoad_spadministration_usersgroups() {
if (ChildToLoad(FrameRef('spadministration_usersgroups'))) {
return [LoadContext(0,'QGNMFELDBT'),'spadministration_usersgroups'];
}
}
function SetChildVariables_spadministration_ssomap_child() {
}
function CtxLoad_spadministration_ssomap_child() {
if (ChildToLoad(FrameRef('spadministration_ssomap_child'))) {
return [LoadContext(0,'VMCLEJEYGM'),'spadministration_ssomap_child'];
}
}
function SetChildVariables_spadministration_historypwd() {
}
function CtxLoad_spadministration_historypwd() {
if (ChildToLoad(m_ospadministration_historypwd) && ChildToLoad('spadministration_historypwd')) {
return [LoadContext(0,'IWKJQPAIJO'),'spadministration_historypwd'];
}
}
function SetChildVariables_spadministration_usercompanies() {
}
function CtxLoad_spadministration_usercompanies() {
if (ChildToLoad(m_ospadministration_usercompanies) && ChildToLoad('spadministration_usercompanies')) {
return [LoadContext(0,'BGAFXUFRUO'),'spadministration_usercompanies'];
}
}
