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
function Set_CPCODMAG(ctrlValue,kmode,e) {
if (Ne(w_CPCODMAG,ctrlValue)) {
var ctl = _GetCtl(e,'BUQHTQZEWF');
if (_tracker.goon(ctl,ctrlValue)) {
w_CPCODMAG=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BUQHTQZEWF',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',5,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_CPCODAJW(ctrlValue,kmode,e) {
if (Ne(w_CPCODAJW,ctrlValue)) {
var ctl = _GetCtl(e,'PUGRYTGEHQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_CPCODAJW=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('PUGRYTGEHQ',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',9,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_CPRAGSOC(ctrlValue,kmode,e) {
if (Ne(w_CPRAGSOC,ctrlValue)) {
var ctl = _GetCtl(e,'FFNWZCKHDB');
if (_tracker.goon(ctl,ctrlValue)) {
w_CPRAGSOC=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FFNWZCKHDB',0);
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
function Set_CPDOMICI(ctrlValue,kmode,e) {
if (Ne(w_CPDOMICI,ctrlValue)) {
var ctl = _GetCtl(e,'VAFIDWPHCA');
if (_tracker.goon(ctl,ctrlValue)) {
w_CPDOMICI=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VAFIDWPHCA',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',40,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_CP_CITTA(ctrlValue,kmode,e) {
if (Ne(w_CP_CITTA,ctrlValue)) {
var ctl = _GetCtl(e,'PHXZPOWUHE');
if (_tracker.goon(ctl,ctrlValue)) {
w_CP_CITTA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('PHXZPOWUHE',0);
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
function Set_CPERR_01(ctrlValue,kmode,e) {
if (Ne(w_CPERR_01,ctrlValue)) {
var ctl = _GetCtl(e,'XPYTVNWCHO');
if (_tracker.goon(ctl,ctrlValue)) {
w_CPERR_01=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XPYTVNWCHO',0);
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
function Set_CPERR_02(ctrlValue,kmode,e) {
if (Ne(w_CPERR_02,ctrlValue)) {
var ctl = _GetCtl(e,'VFFCZHRBSV');
if (_tracker.goon(ctl,ctrlValue)) {
w_CPERR_02=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VFFCZHRBSV',0);
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
function Set_CPERR_03(ctrlValue,kmode,e) {
if (Ne(w_CPERR_03,ctrlValue)) {
var ctl = _GetCtl(e,'YFVSZTUKFJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_CPERR_03=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YFVSZTUKFJ',0);
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
function Set_CPERR_04(ctrlValue,kmode,e) {
if (Ne(w_CPERR_04,ctrlValue)) {
var ctl = _GetCtl(e,'FBLLPINCSQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_CPERR_04=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FBLLPINCSQ',0);
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
function Set_CPERR_05(ctrlValue,kmode,e) {
if (Ne(w_CPERR_05,ctrlValue)) {
var ctl = _GetCtl(e,'NREHZLHXUK');
if (_tracker.goon(ctl,ctrlValue)) {
w_CPERR_05=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NREHZLHXUK',0);
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
function Set_CPERR_06(ctrlValue,kmode,e) {
if (Ne(w_CPERR_06,ctrlValue)) {
var ctl = _GetCtl(e,'WMBIMGHLXA');
if (_tracker.goon(ctl,ctrlValue)) {
w_CPERR_06=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('WMBIMGHLXA',0);
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
function Set_CPERR_07(ctrlValue,kmode,e) {
if (Ne(w_CPERR_07,ctrlValue)) {
var ctl = _GetCtl(e,'MUIQATNACU');
if (_tracker.goon(ctl,ctrlValue)) {
w_CPERR_07=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MUIQATNACU',0);
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
function Set_CPERR_08(ctrlValue,kmode,e) {
if (Ne(w_CPERR_08,ctrlValue)) {
var ctl = _GetCtl(e,'MCFYJRFQLY');
if (_tracker.goon(ctl,ctrlValue)) {
w_CPERR_08=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MCFYJRFQLY',0);
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
function Set_CPERR_09(ctrlValue,kmode,e) {
if (Ne(w_CPERR_09,ctrlValue)) {
var ctl = _GetCtl(e,'FVWFZMVAXM');
if (_tracker.goon(ctl,ctrlValue)) {
w_CPERR_09=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FVWFZMVAXM',0);
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
function Set_CPERR_10(ctrlValue,kmode,e) {
if (Ne(w_CPERR_10,ctrlValue)) {
var ctl = _GetCtl(e,'FBNHYNDMJM');
if (_tracker.goon(ctl,ctrlValue)) {
w_CPERR_10=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FBNHYNDMJM',0);
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
function Set_CPFLGCOR(ctrlValue,kmode,e) {
if (Ne(w_CPFLGCOR,ctrlValue)) {
var ctl = _GetCtl(e,'UPIBHMCFWQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_CPFLGCOR=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UPIBHMCFWQ',0);
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
function Set_CPFLGFOR(ctrlValue,kmode,e) {
if (Ne(w_CPFLGFOR,ctrlValue)) {
var ctl = _GetCtl(e,'VQBNKYNPCH');
if (_tracker.goon(ctl,ctrlValue)) {
w_CPFLGFOR=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VQBNKYNPCH',0);
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
parent.ZtVWeb.raiseEventToEvalParms('armt_wu_poschk_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('armt_wu_poschk_dataNotSent',{'action':formaction});
}
}
}
}
CheckChild.child=[];
function Check() {
var l_bResult = true;
ResetErrorVars();
m_nLastError=0;
if ( ! (_ChkObl('BUQHTQZEWF',1))) {
_SignErr('BUQHTQZEWF');
m_cLastWorkVarErrorMsg='11309552526';
l_bResult=false;
w_CPCODMAG=HtW('','C');
} else if ( ! (_ChkObl('PUGRYTGEHQ',1))) {
_SignErr('PUGRYTGEHQ');
m_cLastWorkVarErrorMsg='1270072299';
l_bResult=false;
w_CPCODAJW=HtW('','C');
} else if ( ! (_ChkObl('FFNWZCKHDB',1))) {
_SignErr('FFNWZCKHDB');
m_cLastWorkVarErrorMsg='10662833243';
l_bResult=false;
w_CPRAGSOC=HtW('','C');
} else if ( ! (_ChkObl('VAFIDWPHCA',1))) {
_SignErr('VAFIDWPHCA');
m_cLastWorkVarErrorMsg='49939619';
l_bResult=false;
w_CPDOMICI=HtW('','C');
} else if ( ! (_ChkObl('PHXZPOWUHE',1))) {
_SignErr('PHXZPOWUHE');
m_cLastWorkVarErrorMsg='15186643';
l_bResult=false;
w_CP_CITTA=HtW('','C');
} else if ( ! (_ChkObl('XPYTVNWCHO',1))) {
_SignErr('XPYTVNWCHO');
m_cLastWorkVarErrorMsg='919169381';
l_bResult=false;
w_CPERR_01=HtW('','C');
} else if ( ! (_ChkObl('VFFCZHRBSV',1))) {
_SignErr('VFFCZHRBSV');
m_cLastWorkVarErrorMsg='1187604837';
l_bResult=false;
w_CPERR_02=HtW('','C');
} else if ( ! (_ChkObl('YFVSZTUKFJ',1))) {
_SignErr('YFVSZTUKFJ');
m_cLastWorkVarErrorMsg='1456040293';
l_bResult=false;
w_CPERR_03=HtW('','C');
} else if ( ! (_ChkObl('FBLLPINCSQ',1))) {
_SignErr('FBLLPINCSQ');
m_cLastWorkVarErrorMsg='1724475749';
l_bResult=false;
w_CPERR_04=HtW('','C');
} else if ( ! (_ChkObl('NREHZLHXUK',1))) {
_SignErr('NREHZLHXUK');
m_cLastWorkVarErrorMsg='1992911205';
l_bResult=false;
w_CPERR_05=HtW('','C');
} else if ( ! (_ChkObl('WMBIMGHLXA',1))) {
_SignErr('WMBIMGHLXA');
m_cLastWorkVarErrorMsg='12033620635';
l_bResult=false;
w_CPERR_06=HtW('','C');
} else if ( ! (_ChkObl('MUIQATNACU',1))) {
_SignErr('MUIQATNACU');
m_cLastWorkVarErrorMsg='11765185179';
l_bResult=false;
w_CPERR_07=HtW('','C');
} else if ( ! (_ChkObl('MCFYJRFQLY',1))) {
_SignErr('MCFYJRFQLY');
m_cLastWorkVarErrorMsg='11496749723';
l_bResult=false;
w_CPERR_08=HtW('','C');
} else if ( ! (_ChkObl('FVWFZMVAXM',1))) {
_SignErr('FVWFZMVAXM');
m_cLastWorkVarErrorMsg='11228314267';
l_bResult=false;
w_CPERR_09=HtW('','C');
} else if ( ! (_ChkObl('FBNHYNDMJM',1))) {
_SignErr('FBNHYNDMJM');
m_cLastWorkVarErrorMsg='919169429';
l_bResult=false;
w_CPERR_10=HtW('','C');
} else if ( ! (_ChkObl('UPIBHMCFWQ',1))) {
_SignErr('UPIBHMCFWQ');
m_cLastWorkVarErrorMsg='11816161592';
l_bResult=false;
w_CPFLGCOR=HtW('','C');
} else if ( ! (_ChkObl('VQBNKYNPCH',1))) {
_SignErr('VQBNKYNPCH');
m_cLastWorkVarErrorMsg='11710185840';
l_bResult=false;
w_CPFLGFOR=HtW('','C');
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
l_oWv.setValue('CPCODMAG',WtA(w_CPCODMAG,'C'));
l_oWv.setValue('CPCODAJW',WtA(w_CPCODAJW,'C'));
l_oWv.setValue('CPRAGSOC',WtA(w_CPRAGSOC,'C'));
l_oWv.setValue('CPDOMICI',WtA(w_CPDOMICI,'C'));
l_oWv.setValue('CP_CITTA',WtA(w_CP_CITTA,'C'));
l_oWv.setValue('CPERR_01',WtA(w_CPERR_01,'C'));
l_oWv.setValue('CPERR_02',WtA(w_CPERR_02,'C'));
l_oWv.setValue('CPERR_03',WtA(w_CPERR_03,'C'));
l_oWv.setValue('CPERR_04',WtA(w_CPERR_04,'C'));
l_oWv.setValue('CPERR_05',WtA(w_CPERR_05,'C'));
l_oWv.setValue('CPERR_06',WtA(w_CPERR_06,'C'));
l_oWv.setValue('CPERR_07',WtA(w_CPERR_07,'C'));
l_oWv.setValue('CPERR_08',WtA(w_CPERR_08,'C'));
l_oWv.setValue('CPERR_09',WtA(w_CPERR_09,'C'));
l_oWv.setValue('CPERR_10',WtA(w_CPERR_10,'C'));
l_oWv.setValue('CPFLGCOR',WtA(w_CPFLGCOR,'C'));
l_oWv.setValue('CPFLGFOR',WtA(w_CPFLGFOR,'C'));
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
FillWv.n=["CPCODMAG","CPCODAJW","CPRAGSOC","CPDOMICI","CP_CITTA","CPERR_01","CPERR_02","CPERR_03","CPERR_04","CPERR_05","CPERR_06","CPERR_07","CPERR_08","CPERR_09","CPERR_10","CPFLGCOR","CPFLGFOR"];
function SetModified() {
m_bUpdated=true;
}
