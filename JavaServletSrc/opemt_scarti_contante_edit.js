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
function Set_NUMPROG(ctrlValue,kmode,e) {
if (Ne(w_NUMPROG,ctrlValue)) {
var ctl = _GetCtl(e,'VEWEVUUXXI');
if (_tracker.goon(ctl,ctrlValue)) {
w_NUMPROG=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VEWEVUUXXI',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',11,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_TIPATT(ctrlValue,kmode,e) {
if (Ne(w_TIPATT,ctrlValue)) {
var ctl = _GetCtl(e,'UXBCLLCOFQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_TIPATT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UXBCLLCOFQ',0);
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
function Set_TIPOATTIV(ctrlValue,kmode,e) {
if (Ne(w_TIPOATTIV,ctrlValue)) {
var ctl = _GetCtl(e,'FHWRILAIPO');
if (_tracker.goon(ctl,ctrlValue)) {
w_TIPOATTIV=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FHWRILAIPO',0);
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
function Set_CODICEGLN(ctrlValue,kmode,e) {
if (Ne(w_CODICEGLN,ctrlValue)) {
var ctl = _GetCtl(e,'AXUMKZOKCH');
if (_tracker.goon(ctl,ctrlValue)) {
w_CODICEGLN=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('AXUMKZOKCH',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',13,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_TOTBANKNOTE(ctrlValue,kmode,e) {
if (Ne(w_TOTBANKNOTE,ctrlValue)) {
var ctl = _GetCtl(e,'YMYGTNKGKH');
if (_tracker.goon(ctl,ctrlValue)) {
w_TOTBANKNOTE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YMYGTNKGKH',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('YMYGTNKGKH',function(){return WtH(w_TOTBANKNOTE,'N',10,0,'9999999999')},w_TOTBANKNOTE);
return l_bResult;
} else {
ctl.value=WtH('','N',10,0,'9999999999');
_ResetTracker();
return true;
}
}
return true;
}
function Set_TAGLIO(ctrlValue,kmode,e) {
if (Ne(w_TAGLIO,ctrlValue)) {
var ctl = _GetCtl(e,'EGZMGNMCXT');
if (_tracker.goon(ctl,ctrlValue)) {
w_TAGLIO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('EGZMGNMCXT',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('EGZMGNMCXT',function(){return WtH(w_TAGLIO,'N',4,0,'9999')},w_TAGLIO);
return l_bResult;
} else {
ctl.value=WtH('','N',4,0,'9999');
_ResetTracker();
return true;
}
}
return true;
}
function Set_NBANCONOTE(ctrlValue,kmode,e) {
if (Ne(w_NBANCONOTE,ctrlValue)) {
var ctl = _GetCtl(e,'CEDXAOEKBO');
if (_tracker.goon(ctl,ctrlValue)) {
w_NBANCONOTE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CEDXAOEKBO',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('CEDXAOEKBO',function(){return WtH(w_NBANCONOTE,'N',10,0,'9999999999')},w_NBANCONOTE);
return l_bResult;
} else {
ctl.value=WtH('','N',10,0,'9999999999');
_ResetTracker();
return true;
}
}
return true;
}
function Set_ABIINTER(ctrlValue,kmode,e) {
if (Ne(w_ABIINTER,ctrlValue)) {
var ctl = _GetCtl(e,'WICMVXKWNU');
if (_tracker.goon(ctl,ctrlValue)) {
w_ABIINTER=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('WICMVXKWNU',0);
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
function Set_ABIPROPR(ctrlValue,kmode,e) {
if (Ne(w_ABIPROPR,ctrlValue)) {
var ctl = _GetCtl(e,'QJYYWZREMR');
if (_tracker.goon(ctl,ctrlValue)) {
w_ABIPROPR=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QJYYWZREMR',0);
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
function Set_GLNALTROSOG(ctrlValue,kmode,e) {
if (Ne(w_GLNALTROSOG,ctrlValue)) {
var ctl = _GetCtl(e,'WATBQSRCOH');
if (_tracker.goon(ctl,ctrlValue)) {
w_GLNALTROSOG=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('WATBQSRCOH',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',13,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_GLNALTRASC(ctrlValue,kmode,e) {
if (Ne(w_GLNALTRASC,ctrlValue)) {
var ctl = _GetCtl(e,'SBRRHXIECX');
if (_tracker.goon(ctl,ctrlValue)) {
w_GLNALTRASC=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SBRRHXIECX',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',13,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_CODCLICON(ctrlValue,kmode,e) {
if (Ne(w_CODCLICON,ctrlValue)) {
var ctl = _GetCtl(e,'LQMKDFHHGB');
if (_tracker.goon(ctl,ctrlValue)) {
w_CODCLICON=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('LQMKDFHHGB',0);
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
function Set_CODCOMCON(ctrlValue,kmode,e) {
if (Ne(w_CODCOMCON,ctrlValue)) {
var ctl = _GetCtl(e,'GRWUSBIQAB');
if (_tracker.goon(ctl,ctrlValue)) {
w_CODCOMCON=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('GRWUSBIQAB',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',6,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_ATECO_CON(ctrlValue,kmode,e) {
if (Ne(w_ATECO_CON,ctrlValue)) {
var ctl = _GetCtl(e,'KHSAIRWIFT');
if (_tracker.goon(ctl,ctrlValue)) {
w_ATECO_CON=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('KHSAIRWIFT',0);
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
function Set_CODDIPE(ctrlValue,kmode,e) {
if (Ne(w_CODDIPE,ctrlValue)) {
var ctl = _GetCtl(e,'TSDHDXKEKJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_CODDIPE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('TSDHDXKEKJ',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',6,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_IMPPROG(ctrlValue,kmode,e) {
if (Ne(w_IMPPROG,ctrlValue)) {
var ctl = _GetCtl(e,'HOPNJWOADW');
if (_tracker.goon(ctl,ctrlValue)) {
w_IMPPROG=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HOPNJWOADW',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',13,0,'');
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
if ( ! (Check())) {
DisplayErrorMessage();
return;
}
if ( ! (m_oFather.SaveContext_opemt_scarti_contante())) {
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
parent.ZtVWeb.raiseEventToEvalParms('opemt_scarti_contante_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('opemt_scarti_contante_dataNotSent',{'action':formaction});
}
}
}
}
}
CheckChild.child=[];
function Check() {
var l_bResult = true;
ResetErrorVars();
m_nLastError=0;
if ( ! (_ChkObl('VEWEVUUXXI',1))) {
_SignErr('VEWEVUUXXI');
m_cLastWorkVarErrorMsg='11383164399';
l_bResult=false;
w_NUMPROG=HtW('','C');
} else if ( ! (_ChkObl('UXBCLLCOFQ',1))) {
_SignErr('UXBCLLCOFQ');
m_cLastWorkVarErrorMsg='11155590227';
l_bResult=false;
w_TIPATT=HtW('','C');
} else if ( ! (_ChkObl('FHWRILAIPO',1))) {
_SignErr('FHWRILAIPO');
m_cLastWorkVarErrorMsg='12037434587';
l_bResult=false;
w_TIPOATTIV=HtW('','C');
} else if ( ! (_ChkObl('AXUMKZOKCH',1))) {
_SignErr('AXUMKZOKCH');
m_cLastWorkVarErrorMsg='11997494697';
l_bResult=false;
w_CODICEGLN=HtW('','C');
} else if ( ! (_ChkObl('YMYGTNKGKH',1))) {
_SignErr('YMYGTNKGKH');
m_cLastWorkVarErrorMsg='1063292795';
l_bResult=false;
w_TOTBANKNOTE=HtW('','N');
} else if ( ! (_ChkObl('EGZMGNMCXT',1))) {
_SignErr('EGZMGNMCXT');
m_cLastWorkVarErrorMsg='10758806619';
l_bResult=false;
w_TAGLIO=HtW('','N');
} else if ( ! (_ChkObl('CEDXAOEKBO',1))) {
_SignErr('CEDXAOEKBO');
m_cLastWorkVarErrorMsg='1514933900';
l_bResult=false;
w_NBANCONOTE=HtW('','N');
} else if ( ! (_ChkObl('WICMVXKWNU',1))) {
_SignErr('WICMVXKWNU');
m_cLastWorkVarErrorMsg='10743769582';
l_bResult=false;
w_ABIINTER=HtW('','C');
} else if ( ! (_ChkObl('QJYYWZREMR',1))) {
_SignErr('QJYYWZREMR');
m_cLastWorkVarErrorMsg='10688195229';
l_bResult=false;
w_ABIPROPR=HtW('','C');
} else if ( ! (_ChkObl('WATBQSRCOH',1))) {
_SignErr('WATBQSRCOH');
m_cLastWorkVarErrorMsg='1189191642';
l_bResult=false;
w_GLNALTROSOG=HtW('','C');
} else if ( ! (_ChkObl('SBRRHXIECX',1))) {
_SignErr('SBRRHXIECX');
m_cLastWorkVarErrorMsg='11648440646';
l_bResult=false;
w_GLNALTRASC=HtW('','C');
} else if ( ! (_ChkObl('LQMKDFHHGB',1))) {
_SignErr('LQMKDFHHGB');
m_cLastWorkVarErrorMsg='439997054';
l_bResult=false;
w_CODCLICON=HtW('','C');
} else if ( ! (_ChkObl('GRWUSBIQAB',1))) {
_SignErr('GRWUSBIQAB');
m_cLastWorkVarErrorMsg='1867589130';
l_bResult=false;
w_CODCOMCON=HtW('','C');
} else if ( ! (_ChkObl('KHSAIRWIFT',1))) {
_SignErr('KHSAIRWIFT');
m_cLastWorkVarErrorMsg='11965763392';
l_bResult=false;
w_ATECO_CON=HtW('','C');
} else if ( ! (_ChkObl('TSDHDXKEKJ',1))) {
_SignErr('TSDHDXKEKJ');
m_cLastWorkVarErrorMsg='2071283709';
l_bResult=false;
w_CODDIPE=HtW('','C');
} else if ( ! (_ChkObl('HOPNJWOADW',1))) {
_SignErr('HOPNJWOADW');
m_cLastWorkVarErrorMsg='283403499';
l_bResult=false;
w_IMPPROG=HtW('','C');
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
l_oWv.setValue('NUMPROG',WtA(w_NUMPROG,'C'));
l_oWv.setValue('TIPATT',WtA(w_TIPATT,'C'));
l_oWv.setValue('TIPOATTIV',WtA(w_TIPOATTIV,'C'));
l_oWv.setValue('CODICEGLN',WtA(w_CODICEGLN,'C'));
l_oWv.setValue('TOTBANKNOTE',WtA(w_TOTBANKNOTE,'N'));
l_oWv.setValue('TAGLIO',WtA(w_TAGLIO,'N'));
l_oWv.setValue('NBANCONOTE',WtA(w_NBANCONOTE,'N'));
l_oWv.setValue('ABIINTER',WtA(w_ABIINTER,'C'));
l_oWv.setValue('ABIPROPR',WtA(w_ABIPROPR,'C'));
l_oWv.setValue('GLNALTROSOG',WtA(w_GLNALTROSOG,'C'));
l_oWv.setValue('GLNALTRASC',WtA(w_GLNALTRASC,'C'));
l_oWv.setValue('CODCLICON',WtA(w_CODCLICON,'C'));
l_oWv.setValue('CODCOMCON',WtA(w_CODCOMCON,'C'));
l_oWv.setValue('ATECO_CON',WtA(w_ATECO_CON,'C'));
l_oWv.setValue('CODDIPE',WtA(w_CODDIPE,'C'));
l_oWv.setValue('IMPPROG',WtA(w_IMPPROG,'C'));
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
FillWv.n=["NUMPROG","TIPATT","TIPOATTIV","CODICEGLN","TOTBANKNOTE","TAGLIO","NBANCONOTE","ABIINTER","ABIPROPR","GLNALTROSOG","GLNALTRASC","CODCLICON","CODCOMCON","ATECO_CON","CODDIPE","IMPPROG"];
function SetModified() {
m_bUpdated=true;
if (IsWndAccessible(m_oFather)) {
m_oFather.SetModified_opemt_scarti_contante();
}
}
function EnableEntityWhenReady(enable) {
if (enable) {
var c;
if(c=Ctrl('VEWEVUUXXI')) SetDisabled(c,true);
if(c=Ctrl('UXBCLLCOFQ')) SetDisabled(c,true);
if(c=Ctrl('FHWRILAIPO')) SetDisabled(c,true);
if(c=Ctrl('AXUMKZOKCH')) SetDisabled(c,true);
if(c=Ctrl('YMYGTNKGKH')) SetDisabled(c,true);
if(c=Ctrl('EGZMGNMCXT')) SetDisabled(c,true);
if(c=Ctrl('CEDXAOEKBO')) SetDisabled(c,true);
if(c=Ctrl('WICMVXKWNU')) SetDisabled(c,true);
if(c=Ctrl('QJYYWZREMR')) SetDisabled(c,true);
if(c=Ctrl('WATBQSRCOH')) SetDisabled(c,true);
if(c=Ctrl('SBRRHXIECX')) SetDisabled(c,true);
if(c=Ctrl('LQMKDFHHGB')) SetDisabled(c,true);
if(c=Ctrl('GRWUSBIQAB')) SetDisabled(c,true);
if(c=Ctrl('KHSAIRWIFT')) SetDisabled(c,true);
if(c=Ctrl('TSDHDXKEKJ')) SetDisabled(c,true);
if(c=Ctrl('HOPNJWOADW')) SetDisabled(c,true);
} else {
var c;
if(c=Ctrl('VEWEVUUXXI')) SetDisabled(c,false);
if(c=Ctrl('UXBCLLCOFQ')) SetDisabled(c,false);
if(c=Ctrl('FHWRILAIPO')) SetDisabled(c,false);
if(c=Ctrl('AXUMKZOKCH')) SetDisabled(c,false);
if(c=Ctrl('YMYGTNKGKH')) SetDisabled(c,false);
if(c=Ctrl('EGZMGNMCXT')) SetDisabled(c,false);
if(c=Ctrl('CEDXAOEKBO')) SetDisabled(c,false);
if(c=Ctrl('WICMVXKWNU')) SetDisabled(c,false);
if(c=Ctrl('QJYYWZREMR')) SetDisabled(c,false);
if(c=Ctrl('WATBQSRCOH')) SetDisabled(c,false);
if(c=Ctrl('SBRRHXIECX')) SetDisabled(c,false);
if(c=Ctrl('LQMKDFHHGB')) SetDisabled(c,false);
if(c=Ctrl('GRWUSBIQAB')) SetDisabled(c,false);
if(c=Ctrl('KHSAIRWIFT')) SetDisabled(c,false);
if(c=Ctrl('TSDHDXKEKJ')) SetDisabled(c,false);
if(c=Ctrl('HOPNJWOADW')) SetDisabled(c,false);
EnableControlsUnderCondition(false);
}
m_bChildDisabled=enable;
}
