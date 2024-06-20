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
if (IsDisabledByStateDriver('File')) {
DisableInputsInContainer(Ctrl('UPMDALZWNE'),true);
}
if (IsDisabledByStateDriver('File1')) {
DisableInputsInContainer(Ctrl('XWPAALVUKU'),true);
}
if (IsDisabledByStateDriver('File2')) {
DisableInputsInContainer(Ctrl('BVXXKEJNHQ'),true);
}
if (IsDisabledByStateDriver('File3')) {
DisableInputsInContainer(Ctrl('PIFTFGCGKH'),true);
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
function Set_VPCODICE(ctrlValue,kmode,e) {
if (Ne(w_VPCODICE,ctrlValue)) {
var ctl = _GetCtl(e,'ZGGIFYYPOE');
if (_tracker.goon(ctl,ctrlValue)) {
w_VPCODICE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ZGGIFYYPOE',0);
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
function Set_VPDESCRI(ctrlValue,kmode,e) {
if (Ne(w_VPDESCRI,ctrlValue)) {
var ctl = _GetCtl(e,'OSLIHZCQKI');
if (_tracker.goon(ctl,ctrlValue)) {
w_VPDESCRI=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('OSLIHZCQKI',0);
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
function Set_VPFLGATT(ctrlValue,kmode,e) {
if (Ne(w_VPFLGATT,ctrlValue)) {
var ctl = _GetCtl(e,'CZVGGKXVIZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_VPFLGATT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CZVGGKXVIZ',0);
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
function Set_VPIDAAMS(ctrlValue,kmode,e) {
if (Ne(w_VPIDAAMS,ctrlValue)) {
var ctl = _GetCtl(e,'OFJLXZEHFJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_VPIDAAMS=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('OFJLXZEHFJ',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',16,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_VPCODPIAT(ctrlValue,kmode,e) {
if (Ne(w_VPCODPIAT,ctrlValue)) {
var ctl = _GetCtl(e,'PVLHZPDZCG');
if (_tracker.goon(ctl,ctrlValue)) {
w_VPCODPIAT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('PVLHZPDZCG',0);
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
function Set_VPSIGLAPIAT(ctrlValue,kmode,e) {
if (Ne(w_VPSIGLAPIAT,ctrlValue)) {
var ctl = _GetCtl(e,'SBCJPJIQKL');
if (_tracker.goon(ctl,ctrlValue)) {
w_VPSIGLAPIAT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SBCJPJIQKL',0);
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
function Set_VPPROVENIENZA(ctrlValue,kmode,e) {
if (Ne(w_VPPROVENIENZA,ctrlValue)) {
var ctl = _GetCtl(e,'MWISDJAVFU');
if (_tracker.goon(ctl,ctrlValue)) {
w_VPPROVENIENZA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MWISDJAVFU',0);
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
function Set_VPVLTCODPLAT(ctrlValue,kmode,e) {
if (Ne(w_VPVLTCODPLAT,ctrlValue)) {
var ctl = _GetCtl(e,'EPIRSSFGUY');
if (_tracker.goon(ctl,ctrlValue)) {
w_VPVLTCODPLAT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('EPIRSSFGUY',0);
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
function Set_VPFLGCRYPTO(ctrlValue,kmode,e) {
if (Ne(w_VPFLGCRYPTO,ctrlValue)) {
var ctl = _GetCtl(e,'IOXCKXSDQO');
if (_tracker.goon(ctl,ctrlValue)) {
w_VPFLGCRYPTO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('IOXCKXSDQO',0);
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
function Set_VFPKAYCRYPTO(ctrlValue,kmode,e) {
if (Ne(w_VFPKAYCRYPTO,ctrlValue)) {
var ctl = _GetCtl(e,'OWDBUVHDZF');
if (_tracker.goon(ctl,ctrlValue)) {
w_VFPKAYCRYPTO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('OWDBUVHDZF',0);
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
function Set_VPDIRFILE(ctrlValue,kmode,e) {
if (Ne(w_VPDIRFILE,ctrlValue)) {
var ctl = _GetCtl(e,'CRNCQKHAZD');
if (_tracker.goon(ctl,ctrlValue)) {
w_VPDIRFILE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CRNCQKHAZD',0);
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
function Set_VPFILEINTESTA1(ctrlValue,kmode,e) {
if (Ne(w_VPFILEINTESTA1,ctrlValue)) {
var ctl = _GetCtl(e,'YRIBZBIKSQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_VPFILEINTESTA1=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YRIBZBIKSQ',0);
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
function Set_VPFFILESPERATOR1(ctrlValue,kmode,e) {
if (Ne(w_VPFFILESPERATOR1,ctrlValue)) {
var ctl = _GetCtl(e,'HSUYGDBUTJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_VPFFILESPERATOR1=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HSUYGDBUTJ',0);
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
function Set_VPFILEFORDATA1(ctrlValue,kmode,e) {
if (Ne(w_VPFILEFORDATA1,ctrlValue)) {
var ctl = _GetCtl(e,'WWIDCEPGYS');
if (_tracker.goon(ctl,ctrlValue)) {
w_VPFILEFORDATA1=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('WWIDCEPGYS',0);
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
function Set_VPPREFFILE1(ctrlValue,kmode,e) {
if (Ne(w_VPPREFFILE1,ctrlValue)) {
var ctl = _GetCtl(e,'WIFZHMQFSC');
if (_tracker.goon(ctl,ctrlValue)) {
w_VPPREFFILE1=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('WIFZHMQFSC',0);
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
function Set_VPFILEINTESTA2(ctrlValue,kmode,e) {
if (Ne(w_VPFILEINTESTA2,ctrlValue)) {
var ctl = _GetCtl(e,'JSTNURAHAS');
if (_tracker.goon(ctl,ctrlValue)) {
w_VPFILEINTESTA2=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('JSTNURAHAS',0);
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
function Set_VPFFILESPERATOR2(ctrlValue,kmode,e) {
if (Ne(w_VPFFILESPERATOR2,ctrlValue)) {
var ctl = _GetCtl(e,'RMKWOZTKVK');
if (_tracker.goon(ctl,ctrlValue)) {
w_VPFFILESPERATOR2=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RMKWOZTKVK',0);
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
function Set_VPFILEFORDATA2(ctrlValue,kmode,e) {
if (Ne(w_VPFILEFORDATA2,ctrlValue)) {
var ctl = _GetCtl(e,'WSOZNFILVU');
if (_tracker.goon(ctl,ctrlValue)) {
w_VPFILEFORDATA2=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('WSOZNFILVU',0);
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
function Set_VPPREFFILE2(ctrlValue,kmode,e) {
if (Ne(w_VPPREFFILE2,ctrlValue)) {
var ctl = _GetCtl(e,'KMMYWUIZJE');
if (_tracker.goon(ctl,ctrlValue)) {
w_VPPREFFILE2=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('KMMYWUIZJE',0);
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
function Set_VPFILEINTESTA3(ctrlValue,kmode,e) {
if (Ne(w_VPFILEINTESTA3,ctrlValue)) {
var ctl = _GetCtl(e,'LGHPNQFTEZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_VPFILEINTESTA3=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('LGHPNQFTEZ',0);
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
function Set_VPFFILESPERATOR3(ctrlValue,kmode,e) {
if (Ne(w_VPFFILESPERATOR3,ctrlValue)) {
var ctl = _GetCtl(e,'DRTQWCMRII');
if (_tracker.goon(ctl,ctrlValue)) {
w_VPFFILESPERATOR3=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('DRTQWCMRII',0);
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
function Set_VPFILEFORDATA3(ctrlValue,kmode,e) {
if (Ne(w_VPFILEFORDATA3,ctrlValue)) {
var ctl = _GetCtl(e,'WIOMSFLLSU');
if (_tracker.goon(ctl,ctrlValue)) {
w_VPFILEFORDATA3=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('WIOMSFLLSU',0);
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
function Set_VPPREFFILE3(ctrlValue,kmode,e) {
if (Ne(w_VPPREFFILE3,ctrlValue)) {
var ctl = _GetCtl(e,'HYYEMIXZZH');
if (_tracker.goon(ctl,ctrlValue)) {
w_VPPREFFILE3=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HYYEMIXZZH',0);
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
function Set_VPFLGPRESUF1(ctrlValue,kmode,e) {
if (Ne(w_VPFLGPRESUF1,ctrlValue)) {
var ctl = _GetCtl(e,'IWAAKTWPEO');
if (_tracker.goon(ctl,ctrlValue)) {
w_VPFLGPRESUF1=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('IWAAKTWPEO',0);
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
function Set_VPFLGPRESUF2(ctrlValue,kmode,e) {
if (Ne(w_VPFLGPRESUF2,ctrlValue)) {
var ctl = _GetCtl(e,'JNTTHSGKEW');
if (_tracker.goon(ctl,ctrlValue)) {
w_VPFLGPRESUF2=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('JNTTHSGKEW',0);
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
function Set_VPFLGPRESUF3(ctrlValue,kmode,e) {
if (Ne(w_VPFLGPRESUF3,ctrlValue)) {
var ctl = _GetCtl(e,'TMKKDOYZLM');
if (_tracker.goon(ctl,ctrlValue)) {
w_VPFLGPRESUF3=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('TMKKDOYZLM',0);
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
function Set_VFPFLAGIMPORT(ctrlValue,kmode,e) {
if (Ne(w_VFPFLAGIMPORT,ctrlValue)) {
var ctl = _GetCtl(e,'TAWZTFESRW');
if (_tracker.goon(ctl,ctrlValue)) {
w_VFPFLAGIMPORT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('TAWZTFESRW',0);
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
function Set_VFPTIPOFILE1(ctrlValue,kmode,e) {
if (Ne(w_VFPTIPOFILE1,ctrlValue)) {
var ctl = _GetCtl(e,'UJQXAYYQOQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_VFPTIPOFILE1=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UJQXAYYQOQ',0);
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
function Set_VFPTIPOFILE2(ctrlValue,kmode,e) {
if (Ne(w_VFPTIPOFILE2,ctrlValue)) {
var ctl = _GetCtl(e,'XKZJHMFBOP');
if (_tracker.goon(ctl,ctrlValue)) {
w_VFPTIPOFILE2=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XKZJHMFBOP',0);
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
function Set_VFPTIPOFILE3(ctrlValue,kmode,e) {
if (Ne(w_VFPTIPOFILE3,ctrlValue)) {
var ctl = _GetCtl(e,'ADHTWRZDJL');
if (_tracker.goon(ctl,ctrlValue)) {
w_VFPTIPOFILE3=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ADHTWRZDJL',0);
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
parent.ZtVWeb.raiseEventToEvalParms('armt_cgo_vltplat_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('armt_cgo_vltplat_dataNotSent',{'action':formaction});
}
}
}
}
CheckChild.child=[];
function Check() {
var l_bResult = true;
ResetErrorVars();
m_nLastError=0;
if ( ! (_ChkObl('ZGGIFYYPOE',1))) {
_SignErr('ZGGIFYYPOE');
m_cLastWorkVarErrorMsg='112851763';
l_bResult=false;
w_VPCODICE=HtW('','C');
} else if ( ! (_ChkObl('OSLIHZCQKI',1))) {
_SignErr('OSLIHZCQKI');
m_cLastWorkVarErrorMsg='285808099';
l_bResult=false;
w_VPDESCRI=HtW('','C');
} else if ( ! (_ChkObl('CZVGGKXVIZ',1))) {
_SignErr('CZVGGKXVIZ');
m_cLastWorkVarErrorMsg='1745819304';
l_bResult=false;
w_VPFLGATT='N';
} else if ( ! (_ChkObl('OFJLXZEHFJ',1))) {
_SignErr('OFJLXZEHFJ');
m_cLastWorkVarErrorMsg='1477784713';
l_bResult=false;
w_VPIDAAMS=HtW('','C');
} else if ( ! (_ChkObl('PVLHZPDZCG',1))) {
_SignErr('PVLHZPDZCG');
m_cLastWorkVarErrorMsg='10357365663';
l_bResult=false;
w_VPCODPIAT=HtW('','N');
} else if ( ! (_ChkObl('SBCJPJIQKL',1))) {
_SignErr('SBCJPJIQKL');
m_cLastWorkVarErrorMsg='734312933';
l_bResult=false;
w_VPSIGLAPIAT=HtW('','C');
} else if ( ! (_ChkObl('MWISDJAVFU',1))) {
_SignErr('MWISDJAVFU');
m_cLastWorkVarErrorMsg='11068679298';
l_bResult=false;
w_VPPROVENIENZA=HtW('','C');
} else if ( ! (_ChkObl('EPIRSSFGUY',1))) {
_SignErr('EPIRSSFGUY');
m_cLastWorkVarErrorMsg='11038861271';
l_bResult=false;
w_VPVLTCODPLAT=HtW('','N');
} else if ( ! (_ChkObl('IOXCKXSDQO',1))) {
_SignErr('IOXCKXSDQO');
m_cLastWorkVarErrorMsg='12056152049';
l_bResult=false;
w_VPFLGCRYPTO='N';
} else if ( ! (_ChkObl('OWDBUVHDZF',1))) {
_SignErr('OWDBUVHDZF');
m_cLastWorkVarErrorMsg='1275677499';
l_bResult=false;
w_VFPKAYCRYPTO=HtW('','M');
} else if ( ! (_ChkObl('CRNCQKHAZD',1))) {
_SignErr('CRNCQKHAZD');
m_cLastWorkVarErrorMsg='11633640653';
l_bResult=false;
w_VPDIRFILE=HtW('','C');
} else if ( ! (_ChkObl('YRIBZBIKSQ',1))) {
_SignErr('YRIBZBIKSQ');
m_cLastWorkVarErrorMsg='1035812210';
l_bResult=false;
w_VPFILEINTESTA1='N';
} else if ( ! (_ChkObl('HSUYGDBUTJ',1))) {
_SignErr('HSUYGDBUTJ');
m_cLastWorkVarErrorMsg='1908399461';
l_bResult=false;
w_VPFFILESPERATOR1=HtW('','C');
} else if ( ! (_ChkObl('WWIDCEPGYS',1))) {
_SignErr('WWIDCEPGYS');
m_cLastWorkVarErrorMsg='1991168906';
l_bResult=false;
w_VPFILEFORDATA1=HtW('','C');
} else if ( ! (_ChkObl('WIFZHMQFSC',1))) {
_SignErr('WIFZHMQFSC');
m_cLastWorkVarErrorMsg='1795947504';
l_bResult=false;
w_VPPREFFILE1=HtW('','C');
} else if ( ! (_ChkObl('JSTNURAHAS',1))) {
_SignErr('JSTNURAHAS');
m_cLastWorkVarErrorMsg='1035812210';
l_bResult=false;
w_VPFILEINTESTA2='N';
} else if ( ! (_ChkObl('RMKWOZTKVK',1))) {
_SignErr('RMKWOZTKVK');
m_cLastWorkVarErrorMsg='1908399461';
l_bResult=false;
w_VPFFILESPERATOR2=HtW('','C');
} else if ( ! (_ChkObl('WSOZNFILVU',1))) {
_SignErr('WSOZNFILVU');
m_cLastWorkVarErrorMsg='1991168906';
l_bResult=false;
w_VPFILEFORDATA2=HtW('','C');
} else if ( ! (_ChkObl('KMMYWUIZJE',1))) {
_SignErr('KMMYWUIZJE');
m_cLastWorkVarErrorMsg='1795947504';
l_bResult=false;
w_VPPREFFILE2=HtW('','C');
} else if ( ! (_ChkObl('LGHPNQFTEZ',1))) {
_SignErr('LGHPNQFTEZ');
m_cLastWorkVarErrorMsg='1035812210';
l_bResult=false;
w_VPFILEINTESTA3='N';
} else if ( ! (_ChkObl('DRTQWCMRII',1))) {
_SignErr('DRTQWCMRII');
m_cLastWorkVarErrorMsg='1908399461';
l_bResult=false;
w_VPFFILESPERATOR3=HtW('','C');
} else if ( ! (_ChkObl('WIOMSFLLSU',1))) {
_SignErr('WIOMSFLLSU');
m_cLastWorkVarErrorMsg='1991168906';
l_bResult=false;
w_VPFILEFORDATA3=HtW('','C');
} else if ( ! (_ChkObl('HYYEMIXZZH',1))) {
_SignErr('HYYEMIXZZH');
m_cLastWorkVarErrorMsg='1795947504';
l_bResult=false;
w_VPPREFFILE3=HtW('','C');
} else if ( ! (_ChkObl('IWAAKTWPEO',1))) {
_SignErr('IWAAKTWPEO');
m_cLastWorkVarErrorMsg='1736088099';
l_bResult=false;
w_VPFLGPRESUF1=HtW('','C');
} else if ( ! (_ChkObl('JNTTHSGKEW',1))) {
_SignErr('JNTTHSGKEW');
m_cLastWorkVarErrorMsg='1736088099';
l_bResult=false;
w_VPFLGPRESUF2=HtW('','C');
} else if ( ! (_ChkObl('TMKKDOYZLM',1))) {
_SignErr('TMKKDOYZLM');
m_cLastWorkVarErrorMsg='1736088099';
l_bResult=false;
w_VPFLGPRESUF3=HtW('','C');
} else if ( ! (_ChkObl('TAWZTFESRW',1))) {
_SignErr('TAWZTFESRW');
m_cLastWorkVarErrorMsg='10586713253';
l_bResult=false;
w_VFPFLAGIMPORT='N';
} else if ( ! (_ChkObl('UJQXAYYQOQ',1))) {
_SignErr('UJQXAYYQOQ');
m_cLastWorkVarErrorMsg='10160733698';
l_bResult=false;
w_VFPTIPOFILE1=HtW('','C');
} else if ( ! (_ChkObl('XKZJHMFBOP',1))) {
_SignErr('XKZJHMFBOP');
m_cLastWorkVarErrorMsg='10160733442';
l_bResult=false;
w_VFPTIPOFILE2=HtW('','C');
} else if ( ! (_ChkObl('ADHTWRZDJL',1))) {
_SignErr('ADHTWRZDJL');
m_cLastWorkVarErrorMsg='10160733186';
l_bResult=false;
w_VFPTIPOFILE3=HtW('','C');
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
l_oWv.setValue('VPCODICE',WtA(w_VPCODICE,'C'));
l_oWv.setValue('VPDESCRI',WtA(w_VPDESCRI,'C'));
l_oWv.setValue('VPFLGATT',WtA(w_VPFLGATT,'C'));
l_oWv.setValue('VPIDAAMS',WtA(w_VPIDAAMS,'C'));
l_oWv.setValue('VPCODPIAT',WtA(w_VPCODPIAT,'N'));
l_oWv.setValue('VPSIGLAPIAT',WtA(w_VPSIGLAPIAT,'C'));
l_oWv.setValue('VPPROVENIENZA',WtA(w_VPPROVENIENZA,'C'));
l_oWv.setValue('VPVLTCODPLAT',WtA(w_VPVLTCODPLAT,'N'));
l_oWv.setValue('VPFLGCRYPTO',WtA(w_VPFLGCRYPTO,'C'));
l_oWv.setValue('VFPKAYCRYPTO',WtA(w_VFPKAYCRYPTO,'M'));
l_oWv.setValue('VPDIRFILE',WtA(w_VPDIRFILE,'C'));
l_oWv.setValue('VPFILEINTESTA1',WtA(w_VPFILEINTESTA1,'C'));
l_oWv.setValue('VPFFILESPERATOR1',WtA(w_VPFFILESPERATOR1,'C'));
l_oWv.setValue('VPFILEFORDATA1',WtA(w_VPFILEFORDATA1,'C'));
l_oWv.setValue('VPPREFFILE1',WtA(w_VPPREFFILE1,'C'));
l_oWv.setValue('VPFILEINTESTA2',WtA(w_VPFILEINTESTA2,'C'));
l_oWv.setValue('VPFFILESPERATOR2',WtA(w_VPFFILESPERATOR2,'C'));
l_oWv.setValue('VPFILEFORDATA2',WtA(w_VPFILEFORDATA2,'C'));
l_oWv.setValue('VPPREFFILE2',WtA(w_VPPREFFILE2,'C'));
l_oWv.setValue('VPFILEINTESTA3',WtA(w_VPFILEINTESTA3,'C'));
l_oWv.setValue('VPFFILESPERATOR3',WtA(w_VPFFILESPERATOR3,'C'));
l_oWv.setValue('VPFILEFORDATA3',WtA(w_VPFILEFORDATA3,'C'));
l_oWv.setValue('VPPREFFILE3',WtA(w_VPPREFFILE3,'C'));
l_oWv.setValue('VPFLGPRESUF1',WtA(w_VPFLGPRESUF1,'C'));
l_oWv.setValue('VPFLGPRESUF2',WtA(w_VPFLGPRESUF2,'C'));
l_oWv.setValue('VPFLGPRESUF3',WtA(w_VPFLGPRESUF3,'C'));
l_oWv.setValue('VFPFLAGIMPORT',WtA(w_VFPFLAGIMPORT,'C'));
l_oWv.setValue('VFPTIPOFILE1',WtA(w_VFPTIPOFILE1,'C'));
l_oWv.setValue('VFPTIPOFILE2',WtA(w_VFPTIPOFILE2,'C'));
l_oWv.setValue('VFPTIPOFILE3',WtA(w_VFPTIPOFILE3,'C'));
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
FillWv.n=["VPCODICE","VPDESCRI","VPFLGATT","VPIDAAMS","VPCODPIAT","VPSIGLAPIAT","VPPROVENIENZA","VPVLTCODPLAT","VPFLGCRYPTO","VFPKAYCRYPTO","VPDIRFILE","VPFILEINTESTA1","VPFFILESPERATOR1","VPFILEFORDATA1","VPPREFFILE1","VPFILEINTESTA2","VPFFILESPERATOR2","VPFILEFORDATA2","VPPREFFILE2","VPFILEINTESTA3","VPFFILESPERATOR3","VPFILEFORDATA3","VPPREFFILE3","VPFLGPRESUF1","VPFLGPRESUF2","VPFLGPRESUF3","VFPFLAGIMPORT","VFPTIPOFILE1","VFPTIPOFILE2","VFPTIPOFILE3"];
function SetModified() {
m_bUpdated=true;
}
