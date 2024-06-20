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
l_bEnabled= ! (false) || IsDisabledByStateDriver('SOSCODDIP');
SetDisabled('DHBRXDCHIH',l_bEnabled);
l_bEnabled= ! (Gt(At(w_SOSMEZPAG,'|I|P|E'),0)) || IsDisabledByStateDriver('SOSNUMBON');
SetDisabled('AYIZLJVVCP',l_bEnabled);
l_bEnabled= ! (Gt(At(w_SOSMEZPAG,'|C|B'),0)) || IsDisabledByStateDriver('SOSBANASS');
SetDisabled('SYZBUNLLHR',l_bEnabled);
l_bEnabled= ! (Gt(At(w_SOSMEZPAG,'|C|B'),0)) || IsDisabledByStateDriver('SOSNUMASS');
SetDisabled('SBVSTUFZNJ',l_bEnabled);
l_bEnabled= ! ( ! (Empty(w_SOSCLIETD))) || IsDisabledByStateDriver('SOSCLIEND');
SetDisabled('RGTEMJRSBB',l_bEnabled);
l_bEnabled= ! ( ! (Empty(w_SOSCLIETD))) || IsDisabledByStateDriver('SOSCLIEDRD');
SetDisabled('MDMENXCYFS',l_bEnabled);
SetDisabled(Ctrl('MDMENXCYFS_ZOOM'),l_bEnabled);
l_bEnabled= ! ( ! (Empty(w_SOSCLIETD))) || IsDisabledByStateDriver('SOSCLIEDSD');
SetDisabled('SMDOEMVCES',l_bEnabled);
SetDisabled(Ctrl('SMDOEMVCES_ZOOM'),l_bEnabled);
l_bEnabled= ! ( ! (Empty(w_SOSCLIETD))) || IsDisabledByStateDriver('SOSCLIEAUD');
SetDisabled('LVYUCXICCL',l_bEnabled);
if (IsDisabledByStateDriver('Operazione')) {
DisableInputsInContainer(Ctrl('THCSTTAUJY'),true);
}
if (IsDisabledByStateDriver('Segnalante')) {
DisableInputsInContainer(Ctrl('DIAEKSWWEM'),true);
}
if (IsDisabledByStateDriver('Persona')) {
DisableInputsInContainer(Ctrl('ALUYEPUVLF'),true);
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
function Set_SOSMOTSOS(ctrlValue,kmode,e) {
if (Ne(w_SOSMOTSOS,ctrlValue)) {
var ctl = _GetCtl(e,'YBPKXABHYP');
if (_tracker.goon(ctl,ctrlValue)) {
w_SOSMOTSOS=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YBPKXABHYP',0);
if (l_bResult &&  ! (Check_GORGNKWJSO(false))) {
m_cLastWorkVarError='GORGNKWJSO';
if ( ! (Eq(m_nLastError,-3))) {
m_nLastError=2;
}
l_bResult=false;
}
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
function Set_SOSCLIECOG(ctrlValue,kmode,e) {
if (Ne(w_SOSCLIECOG,ctrlValue)) {
var ctl = _GetCtl(e,'IAAFYFVCOO');
if (_tracker.goon(ctl,ctrlValue)) {
w_SOSCLIECOG=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('IAAFYFVCOO',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('IAAFYFVCOO',function(){return WtH(w_SOSCLIECOG,'C',30,0,'@!')},w_SOSCLIECOG);
return l_bResult;
} else {
ctl.value=WtH('','C',30,0,'@!');
_ResetTracker();
return true;
}
}
return true;
}
function Set_SOSCODDIP(ctrlValue,kmode,e) {
if (Ne(w_SOSCODDIP,ctrlValue)) {
var ctl = _GetCtl(e,'DHBRXDCHIH');
if (_tracker.goon(ctl,ctrlValue)) {
w_SOSCODDIP=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('DHBRXDCHIH',0);
if (l_bResult) {
l_bResult=Link_DHBRXDCHIH(kmode);
if ( ! (l_bResult)) {
w_SOSCODDIP=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',6,0,''));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',6,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_SOSSEGNANT(ctrlValue,kmode,e) {
if (Ne(w_SOSSEGNANT,ctrlValue)) {
var ctl = _GetCtl(e,'NHTTQSKNCE');
if (_tracker.goon(ctl,ctrlValue)) {
w_SOSSEGNANT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NHTTQSKNCE',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',15,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_SOSSEGNAFAX(ctrlValue,kmode,e) {
if (Ne(w_SOSSEGNAFAX,ctrlValue)) {
var ctl = _GetCtl(e,'IRAARTIBBY');
if (_tracker.goon(ctl,ctrlValue)) {
w_SOSSEGNAFAX=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('IRAARTIBBY',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',15,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_SOSSEGNAEM(ctrlValue,kmode,e) {
if (Ne(w_SOSSEGNAEM,ctrlValue)) {
var ctl = _GetCtl(e,'CGKCUTXIQV');
if (_tracker.goon(ctl,ctrlValue)) {
w_SOSSEGNAEM=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CGKCUTXIQV',0);
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
function Set_SOSSEGNACF(ctrlValue,kmode,e) {
if (Ne(w_SOSSEGNACF,ctrlValue)) {
var ctl = _GetCtl(e,'UVDPOGERZK');
if (_tracker.goon(ctl,ctrlValue)) {
w_SOSSEGNACF=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UVDPOGERZK',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('UVDPOGERZK',function(){return WtH(w_SOSSEGNACF,'C',16,0,'@!')},w_SOSSEGNACF);
return l_bResult;
} else {
ctl.value=WtH('','C',16,0,'@!');
_ResetTracker();
return true;
}
}
return true;
}
function Set_SOSSEGNACOG(ctrlValue,kmode,e) {
if (Ne(w_SOSSEGNACOG,ctrlValue)) {
var ctl = _GetCtl(e,'HNLUXWZZSG');
if (_tracker.goon(ctl,ctrlValue)) {
w_SOSSEGNACOG=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HNLUXWZZSG',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('HNLUXWZZSG',function(){return WtH(w_SOSSEGNACOG,'C',30,0,'@!')},w_SOSSEGNACOG);
return l_bResult;
} else {
ctl.value=WtH('','C',30,0,'@!');
_ResetTracker();
return true;
}
}
return true;
}
function Set_SOSSEGNANOM(ctrlValue,kmode,e) {
if (Ne(w_SOSSEGNANOM,ctrlValue)) {
var ctl = _GetCtl(e,'NPOZCOOROF');
if (_tracker.goon(ctl,ctrlValue)) {
w_SOSSEGNANOM=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NPOZCOOROF',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('NPOZCOOROF',function(){return WtH(w_SOSSEGNANOM,'C',30,0,'@!')},w_SOSSEGNANOM);
return l_bResult;
} else {
ctl.value=WtH('','C',30,0,'@!');
_ResetTracker();
return true;
}
}
return true;
}
function Set_SOSSEGNALN(ctrlValue,kmode,e) {
if (Ne(w_SOSSEGNALN,ctrlValue)) {
var ctl = _GetCtl(e,'NMTFLCHLGD');
if (_tracker.goon(ctl,ctrlValue)) {
w_SOSSEGNALN=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NMTFLCHLGD',0);
if (l_bResult) {
l_bResult=Link_NMTFLCHLGD(kmode);
if ( ! (l_bResult)) {
w_SOSSEGNALN=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',50,0,'@!'));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',50,0,'@!');
_ResetTracker();
return true;
}
}
return true;
}
function Set_SOSSEGNADN(ctrlValue,kmode,e) {
if (Ne(w_SOSSEGNADN,ctrlValue)) {
var ctl = _GetCtl(e,'BLOPGSOJRJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_SOSSEGNADN=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BLOPGSOJRJ',0);
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
function Set_SOSSEGNASX(ctrlValue,kmode,e) {
if (Ne(w_SOSSEGNASX,ctrlValue)) {
var ctl = _GetCtl(e,'EABOOAYYWK');
if (_tracker.goon(ctl,ctrlValue)) {
w_SOSSEGNASX=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('EABOOAYYWK',0);
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
function Set_SOSSTATOOP(ctrlValue,kmode,e) {
if (Ne(w_SOSSTATOOP,ctrlValue)) {
var ctl = _GetCtl(e,'MHDGPLPBBN');
if (_tracker.goon(ctl,ctrlValue)) {
w_SOSSTATOOP=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MHDGPLPBBN',0);
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
function Set_IDBIGLIETTO(ctrlValue,kmode,e) {
if (Ne(w_IDBIGLIETTO,ctrlValue)) {
var ctl = _GetCtl(e,'UXJUHWBCMH');
if (_tracker.goon(ctl,ctrlValue)) {
w_IDBIGLIETTO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UXJUHWBCMH',0);
if (l_bResult) {
l_bResult=Link_UXJUHWBCMH(kmode);
if ( ! (l_bResult)) {
w_IDBIGLIETTO=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',28,0,''));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',28,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_SOSDATAOP(ctrlValue,kmode,e) {
if (Ne(w_SOSDATAOP,ctrlValue)) {
var ctl = _GetCtl(e,'CCDNZZPUCA');
if (_tracker.goon(ctl,ctrlValue)) {
w_SOSDATAOP=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CCDNZZPUCA',0);
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
function Set_SOSTIPOOP(ctrlValue,kmode,e) {
if (Ne(w_SOSTIPOOP,ctrlValue)) {
var ctl = _GetCtl(e,'AMJZYMJHYP');
if (_tracker.goon(ctl,ctrlValue)) {
w_SOSTIPOOP=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('AMJZYMJHYP',0);
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
function Set_SOSIMPOPE(ctrlValue,kmode,e) {
if (Ne(w_SOSIMPOPE,ctrlValue)) {
var ctl = _GetCtl(e,'DXDTFLVDRK');
if (_tracker.goon(ctl,ctrlValue)) {
w_SOSIMPOPE=ValidNum(ctrlValue,'999999999999.99');
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('DXDTFLVDRK',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('DXDTFLVDRK',function(){return WtH(w_SOSIMPOPE,'N',15,2,'999,999,999,999.99')},w_SOSIMPOPE);
return l_bResult;
} else {
ctl.value=WtH('','N',15,2,'999999999999.99');
_ResetTracker();
return true;
}
} else {
SPBOUILib.SetInputValue('DXDTFLVDRK',function(){return WtH(w_SOSIMPOPE,'N',15,2,'999,999,999,999.99')},w_SOSIMPOPE);
}
return true;
}
function Set_SOSMEZPAG(ctrlValue,kmode,e) {
if (Ne(w_SOSMEZPAG,ctrlValue)) {
var ctl = _GetCtl(e,'CUWGJLKVOE');
if (_tracker.goon(ctl,ctrlValue)) {
w_SOSMEZPAG=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CUWGJLKVOE',0);
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
function Set_SOSNUMBON(ctrlValue,kmode,e) {
if (Ne(w_SOSNUMBON,ctrlValue)) {
var ctl = _GetCtl(e,'AYIZLJVVCP');
if (_tracker.goon(ctl,ctrlValue)) {
w_SOSNUMBON=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('AYIZLJVVCP',0);
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
function Set_SOSBANASS(ctrlValue,kmode,e) {
if (Ne(w_SOSBANASS,ctrlValue)) {
var ctl = _GetCtl(e,'SYZBUNLLHR');
if (_tracker.goon(ctl,ctrlValue)) {
w_SOSBANASS=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SYZBUNLLHR',0);
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
function Set_SOSNUMASS(ctrlValue,kmode,e) {
if (Ne(w_SOSNUMASS,ctrlValue)) {
var ctl = _GetCtl(e,'SBVSTUFZNJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_SOSNUMASS=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SBVSTUFZNJ',0);
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
function Set_SOSDESOPE(ctrlValue,kmode,e) {
if (Ne(w_SOSDESOPE,ctrlValue)) {
var ctl = _GetCtl(e,'ABTEUVWFFQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_SOSDESOPE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ABTEUVWFFQ',0);
if (l_bResult &&  ! (Check_OHCORUHEID(false))) {
m_cLastWorkVarError='OHCORUHEID';
if ( ! (Eq(m_nLastError,-3))) {
m_nLastError=2;
}
l_bResult=false;
}
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
function Set_SOSCLIETD(ctrlValue,kmode,e) {
if (Ne(w_SOSCLIETD,ctrlValue)) {
var ctl = _GetCtl(e,'YSEWNSQRQV');
if (_tracker.goon(ctl,ctrlValue)) {
w_SOSCLIETD=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YSEWNSQRQV',0);
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
function Set_SOSCLIEND(ctrlValue,kmode,e) {
if (Ne(w_SOSCLIEND,ctrlValue)) {
var ctl = _GetCtl(e,'RGTEMJRSBB');
if (_tracker.goon(ctl,ctrlValue)) {
w_SOSCLIEND=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RGTEMJRSBB',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',15,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_SOSCLIENOM(ctrlValue,kmode,e) {
if (Ne(w_SOSCLIENOM,ctrlValue)) {
var ctl = _GetCtl(e,'YZCTAZEUHT');
if (_tracker.goon(ctl,ctrlValue)) {
w_SOSCLIENOM=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YZCTAZEUHT',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('YZCTAZEUHT',function(){return WtH(w_SOSCLIENOM,'C',30,0,'@!')},w_SOSCLIENOM);
return l_bResult;
} else {
ctl.value=WtH('','C',30,0,'@!');
_ResetTracker();
return true;
}
}
return true;
}
function Set_SOSCLIELN(ctrlValue,kmode,e) {
if (Ne(w_SOSCLIELN,ctrlValue)) {
var ctl = _GetCtl(e,'EKWIYNRJCN');
if (_tracker.goon(ctl,ctrlValue)) {
w_SOSCLIELN=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('EKWIYNRJCN',0);
if (l_bResult) {
l_bResult=Link_EKWIYNRJCN(kmode);
if ( ! (l_bResult)) {
w_SOSCLIELN=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',50,0,'@!'));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',50,0,'@!');
_ResetTracker();
return true;
}
}
return true;
}
function Set_SOSCLIEDN(ctrlValue,kmode,e) {
if (Ne(w_SOSCLIEDN,ctrlValue)) {
var ctl = _GetCtl(e,'ESIPESUKFU');
if (_tracker.goon(ctl,ctrlValue)) {
w_SOSCLIEDN=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ESIPESUKFU',0);
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
function Set_SOSCLIESX(ctrlValue,kmode,e) {
if (Ne(w_SOSCLIESX,ctrlValue)) {
var ctl = _GetCtl(e,'ZAUFIWBFWS');
if (_tracker.goon(ctl,ctrlValue)) {
w_SOSCLIESX=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ZAUFIWBFWS',0);
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
function Set_SOSCLIECF(ctrlValue,kmode,e) {
if (Ne(w_SOSCLIECF,ctrlValue)) {
var ctl = _GetCtl(e,'YAUYCDEFNH');
if (_tracker.goon(ctl,ctrlValue)) {
w_SOSCLIECF=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YAUYCDEFNH',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('YAUYCDEFNH',function(){return WtH(w_SOSCLIECF,'C',16,0,'@!')},w_SOSCLIECF);
return l_bResult;
} else {
ctl.value=WtH('','C',16,0,'@!');
_ResetTracker();
return true;
}
}
return true;
}
function Set_SOSCLIEPAE(ctrlValue,kmode,e) {
if (Ne(w_SOSCLIEPAE,ctrlValue)) {
var ctl = _GetCtl(e,'CQREEAUGJZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_SOSCLIEPAE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CQREEAUGJZ',0);
if (l_bResult) {
l_bResult=Link_CQREEAUGJZ(kmode);
if ( ! (l_bResult)) {
w_SOSCLIEPAE=HtW('','C');
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
function Set_SOSCLIECR(ctrlValue,kmode,e) {
if (Ne(w_SOSCLIECR,ctrlValue)) {
var ctl = _GetCtl(e,'RNXXROADTV');
if (_tracker.goon(ctl,ctrlValue)) {
w_SOSCLIECR=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RNXXROADTV',0);
if (l_bResult) {
l_bResult=Link_RNXXROADTV(kmode);
if ( ! (l_bResult)) {
w_SOSCLIECR=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',50,0,'@!'));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',50,0,'@!');
_ResetTracker();
return true;
}
}
return true;
}
function Set_SOSCLIEIND(ctrlValue,kmode,e) {
if (Ne(w_SOSCLIEIND,ctrlValue)) {
var ctl = _GetCtl(e,'HRARTBAAAD');
if (_tracker.goon(ctl,ctrlValue)) {
w_SOSCLIEIND=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HRARTBAAAD',0);
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
function Set_SOSCLIECAR(ctrlValue,kmode,e) {
if (Ne(w_SOSCLIECAR,ctrlValue)) {
var ctl = _GetCtl(e,'XZMROSWRMH');
if (_tracker.goon(ctl,ctrlValue)) {
w_SOSCLIECAR=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XZMROSWRMH',0);
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
function Set_SOSCLIEPN(ctrlValue,kmode,e) {
if (Ne(w_SOSCLIEPN,ctrlValue)) {
var ctl = _GetCtl(e,'GWPOQYXVMH');
if (_tracker.goon(ctl,ctrlValue)) {
w_SOSCLIEPN=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('GWPOQYXVMH',0);
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
function Set_SOSCLIEDSD(ctrlValue,kmode,e) {
if (Ne(w_SOSCLIEDSD,ctrlValue)) {
var ctl = _GetCtl(e,'SMDOEMVCES');
if (_tracker.goon(ctl,ctrlValue)) {
w_SOSCLIEDSD=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SMDOEMVCES',0);
if (l_bResult) {
l_bResult=arfn_cgo_chkdata(w_SOSCLIEDSD,w_SOSCLIETD,'S',w_SOSDATAOP);
if ( ! (l_bResult)) {
m_nLastError=2;
m_cLastWorkVarErrorMsg='2025824008';
m_cLastMsgError=AlertErrorMessage('11525797640');
}
if ( ! (l_bResult)) {
w_SOSCLIEDSD=HtW('','D');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D')));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH(NullDate(),'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
_ResetTracker();
return true;
}
}
return true;
}
function Set_SOSCLIEDRD(ctrlValue,kmode,e) {
if (Ne(w_SOSCLIEDRD,ctrlValue)) {
var ctl = _GetCtl(e,'MDMENXCYFS');
if (_tracker.goon(ctl,ctrlValue)) {
w_SOSCLIEDRD=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MDMENXCYFS',0);
if (l_bResult) {
l_bResult=arfn_cgo_chkdata(w_SOSCLIEDRD,w_SOSCLIETD,'R',w_SOSDATAOP);
if ( ! (l_bResult)) {
m_nLastError=2;
m_cLastWorkVarErrorMsg='784106725';
m_cLastMsgError=AlertErrorMessage('11525797640');
}
if ( ! (l_bResult)) {
w_SOSCLIEDRD=HtW('','D');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D')));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH(NullDate(),'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
_ResetTracker();
return true;
}
}
return true;
}
function Set_SOSCLIEAUD(ctrlValue,kmode,e) {
if (Ne(w_SOSCLIEAUD,ctrlValue)) {
var ctl = _GetCtl(e,'LVYUCXICCL');
if (_tracker.goon(ctl,ctrlValue)) {
w_SOSCLIEAUD=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('LVYUCXICCL',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('LVYUCXICCL',function(){return WtH(w_SOSCLIEAUD,'C',50,0,'@!')},w_SOSCLIEAUD);
return l_bResult;
} else {
ctl.value=WtH('','C',50,0,'@!');
_ResetTracker();
return true;
}
}
return true;
}
function Set_SOSCLIEPR(ctrlValue,kmode,e) {
if (Ne(w_SOSCLIEPR,ctrlValue)) {
var ctl = _GetCtl(e,'EOTGCHITKP');
if (_tracker.goon(ctl,ctrlValue)) {
w_SOSCLIEPR=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('EOTGCHITKP',0);
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
function Calculate() {
var l_bTmpRes;
var l_bResult = true;
m_bCalculating=true;
UpdateAutonumber('SOSCODICE');
if ((Ne(o_SOSCODICE,w_SOSCODICE))) {
w_SOSCODDIP=w_gCodDip;
l_bTmpRes=Link_DHBRXDCHIH(null);
}
w_SOSUTENTE=w_gUserCode;
w_SOSDATSEG=SystemDate();
if ((Ne(o_IDBIGLIETTO,w_IDBIGLIETTO))) {
Calculation_WENWSAYLVY();
}
LibJavascript.forEachItem(m_FoundlingCopyWorkVar,i_body_1)
function i_body_1(child){
child();
}
// * --- Area Manuale = UI - Calculate
// * --- Fine Area Manuale
UpdateAutonumber('');
m_bCalculating=false;
if (l_bResult &&  ! (Check_QNEKQYKSHZ(false)) && Ne(m_nLastError,-3)) {
setTimeout('WindowAlert('+LibJavascript.ToJSValue(AlertErrorMessage(m_cLastMsgError))+')',1);
l_bResult=false;
}
if (l_bResult &&  ! (Check_YHNSLBLWFP(false)) && Ne(m_nLastError,-3)) {
setTimeout('WindowAlert('+LibJavascript.ToJSValue(AlertErrorMessage(m_cLastMsgError))+')',1);
l_bResult=false;
}
if (l_bResult &&  ! (Check_NXWIUCGNDI(false)) && Ne(m_nLastError,-3)) {
setTimeout('WindowAlert('+LibJavascript.ToJSValue(AlertErrorMessage(m_cLastMsgError))+')',1);
l_bResult=false;
}
}
function Calculation_WENWSAYLVY() {
arrt_cgo_sos_biglietto([["pObj",this]])
}
function Check_QNEKQYKSHZ(p_bForce) {
var l_bResult = true;
if (p_bForce || Ne(o_SOSCLIEDRD,w_SOSCLIEDRD) || Ne(o_SOSCLIEDSD,w_SOSCLIEDSD)) {
l_bResult=( ! (Empty(w_SOSCLIEDSD)) &&  ! (Empty(w_SOSCLIEDRD))?Le(w_SOSCLIEDRD,w_SOSCLIEDSD):true);
if ( ! (l_bResult)) {
m_cLastMsgError=AlertErrorMessage('176282827');
}
}
return l_bResult;
}
function Check_YHNSLBLWFP(p_bForce) {
var l_bResult = true;
if (p_bForce || Ne(o_SOSCLIEDSD,w_SOSCLIEDSD) || Ne(o_SOSDATAOP,w_SOSDATAOP)) {
l_bResult=( ! (Empty(w_SOSDATAOP)) &&  ! (Empty(w_SOSCLIEDSD))?Le(w_SOSDATAOP,w_SOSCLIEDSD):true);
if ( ! (l_bResult)) {
m_cLastMsgError=AlertErrorMessage('187973133');
}
}
return l_bResult;
}
function Check_NXWIUCGNDI(p_bForce) {
var l_bResult = true;
if (p_bForce || Ne(o_SOSCLIEDRD,w_SOSCLIEDRD) || Ne(o_SOSDATAOP,w_SOSDATAOP)) {
l_bResult=( ! (Empty(w_SOSDATAOP)) &&  ! (Empty(w_SOSCLIEDRD))?Ge(w_SOSDATAOP,w_SOSCLIEDRD):true);
if ( ! (l_bResult)) {
m_cLastMsgError=AlertErrorMessage('819587209');
}
}
return l_bResult;
}
function Check_OHCORUHEID(p_bForce) {
var l_bResult = true;
if (p_bForce || Ne(o_SOSDESOPE,w_SOSDESOPE)) {
l_bResult=Le(Len(LRTrim(w_SOSDESOPE)),350);
if ( ! (l_bResult)) {
m_cLastMsgError=AlertErrorMessage('11842673987');
}
}
return l_bResult;
}
function Check_GORGNKWJSO(p_bForce) {
var l_bResult = true;
if (p_bForce || Ne(o_SOSMOTSOS,w_SOSMOTSOS)) {
l_bResult=Le(Len(LRTrim(w_SOSMOTSOS)),350);
if ( ! (l_bResult)) {
m_cLastMsgError=AlertErrorMessage('1801622885');
}
}
return l_bResult;
}
function SaveDependsOn() {
o_SOSCODICE=w_SOSCODICE;
o_IDBIGLIETTO=w_IDBIGLIETTO;
o_SOSDATAOP=w_SOSDATAOP;
o_SOSDESOPE=w_SOSDESOPE;
o_SOSMOTSOS=w_SOSMOTSOS;
o_SOSCLIEDRD=w_SOSCLIEDRD;
o_SOSCLIEDSD=w_SOSCLIEDSD;
}
function SaveLabelDependsOn() {
}
function Link_DHBRXDCHIH(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_SOSCODDIP);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODDIP',w_SOSCODDIP,6,0);
l_Appl.SetFields('CODDIP,DESCRIZ');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('anadip');
l_Appl.SetLinkzoom('armt_anadip');
l_Appl.SetID('DHBRXDCHIH');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_SOSCODDIP=l_Appl.GetStringValue('CODDIP',6,0);
w_xdesdip=l_Appl.GetStringValue('DESCRIZ',30,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_DHBRXDCHIH_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_DHBRXDCHIH';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_DHBRXDCHIH();
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
function Link_DHBRXDCHIH_Blank() {
w_SOSCODDIP='';
w_xdesdip='';
}
function LOpt_DHBRXDCHIH() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('anadip','C'));
l_oWv.setValue('Linkzoomprg',WtA('armt_anadip','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODDIP','C'));
l_oWv.setValue('LinkedField',WtA('CODDIP','C'));
l_oWv.setValue('UID',WtA('DHBRXDCHIH','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['DHBRXDCHIH'][1],'C'));
return l_oWv;
}
function Link_NMTFLCHLGD(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_SOSSEGNALN);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('DESCRI',w_SOSSEGNALN,50,0);
l_Appl.SetFields('DESCRI,PROVINCIA');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbluonas');
l_Appl.SetID('NMTFLCHLGD');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_SOSSEGNALN=l_Appl.GetStringValue('DESCRI',50,0);
w_SOSSEGNAPN=l_Appl.GetStringValue('PROVINCIA',2,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_NMTFLCHLGD_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_NMTFLCHLGD';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_NMTFLCHLGD();
l_oWv.setValue('FieldFilter',l_cFieldFilter);
if ( ! (Empty(l_Appl.GetWhereAddedFixedFiltersUnencoded()))) {
if ( ! (Empty(l_cFixedFilter))) {
l_cFixedFilter=l_cFixedFilter+' and ';
}
l_cFixedFilter=l_cFixedFilter+l_Appl.GetWhereAddedFixedFiltersUnencoded();
}
l_oWv.setValue('FixedFilter',l_cFixedFilter);
var initEntityFields = '';
l_cLinkUrl='../servlet/SPVisualZoom'+'?m_cWv='+URLenc(l_oWv.asString());
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
function Link_NMTFLCHLGD_Blank() {
w_SOSSEGNALN='';
w_SOSSEGNAPN='';
}
function LOpt_NMTFLCHLGD() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbluonas','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('DESCRI','C'));
l_oWv.setValue('LinkedField',WtA('DESCRI','C'));
l_oWv.setValue('UID',WtA('NMTFLCHLGD','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['NMTFLCHLGD'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('227139885'),'C'));
return l_oWv;
}
function Link_UXJUHWBCMH(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_IDBIGLIETTO);
var l_Appl = LinkApplet();
l_Appl.AppendFilterValue(w_gCodDip);
l_Appl.SetStringKey('CAIDBIGLIETTO',w_IDBIGLIETTO,28,0);
l_Appl.SetFields('CAIDBIGLIETTO');
l_Appl.SetTypes('C');
l_Appl.LinkTable('cgo_operazioni_storico');
l_Appl.SetID('UXJUHWBCMH');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_IDBIGLIETTO=l_Appl.GetStringValue('CAIDBIGLIETTO',28,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_UXJUHWBCMH_Blank();
l_bResult=true;
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_UXJUHWBCMH';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_UXJUHWBCMH();
l_oWv.setValue('FieldFilter',l_cFieldFilter);
if ( ! (Empty(l_Appl.GetWhereAddedFixedFiltersUnencoded()))) {
if ( ! (Empty(l_cFixedFilter))) {
l_cFixedFilter=l_cFixedFilter+' and ';
}
l_cFixedFilter=l_cFixedFilter+l_Appl.GetWhereAddedFixedFiltersUnencoded();
}
l_oWv.setValue('FixedFilter',l_cFixedFilter);
var initEntityFields = '';
l_cLinkUrl='../servlet/SPVisualZoom'+'?m_cWv='+URLenc(l_oWv.asString());
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
function Link_UXJUHWBCMH_Blank() {
}
function LOpt_UXJUHWBCMH() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('cgo_operazioni_storico','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CAIDBIGLIETTO','C'));
l_oWv.setValue('LinkedField',WtA('CAIDBIGLIETTO','C'));
l_oWv.setValue('UID',WtA('UXJUHWBCMH','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['UXJUHWBCMH'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('10003478977'),'C'));
return l_oWv;
}
function Link_EKWIYNRJCN(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_SOSCLIELN);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('DESCRI',w_SOSCLIELN,50,0);
l_Appl.SetFields('DESCRI,PROVINCIA');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbluonas');
l_Appl.SetID('EKWIYNRJCN');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_SOSCLIELN=l_Appl.GetStringValue('DESCRI',50,0);
w_SOSCLIEPN=l_Appl.GetStringValue('PROVINCIA',2,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_EKWIYNRJCN_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_EKWIYNRJCN';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_EKWIYNRJCN();
l_oWv.setValue('FieldFilter',l_cFieldFilter);
if ( ! (Empty(l_Appl.GetWhereAddedFixedFiltersUnencoded()))) {
if ( ! (Empty(l_cFixedFilter))) {
l_cFixedFilter=l_cFixedFilter+' and ';
}
l_cFixedFilter=l_cFixedFilter+l_Appl.GetWhereAddedFixedFiltersUnencoded();
}
l_oWv.setValue('FixedFilter',l_cFixedFilter);
var initEntityFields = '';
l_cLinkUrl='../servlet/SPVisualZoom'+'?m_cWv='+URLenc(l_oWv.asString());
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
function Link_EKWIYNRJCN_Blank() {
w_SOSCLIELN='';
w_SOSCLIEPN='';
}
function LOpt_EKWIYNRJCN() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbluonas','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('DESCRI','C'));
l_oWv.setValue('LinkedField',WtA('DESCRI','C'));
l_oWv.setValue('UID',WtA('EKWIYNRJCN','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['EKWIYNRJCN'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('1625200191'),'C'));
return l_oWv;
}
function Sugg_CQREEAUGJZ(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_Appl = LinkApplet();
var l_bEmp = Empty(HtW(Ctrl('CQREEAUGJZ').value,'C'));
l_Appl.SetStringKey('CODSTA',HtW(Ctrl('CQREEAUGJZ').value,'C'),3,0);
l_Appl.SetFields('CODSTA,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbstati');
l_Appl.SetID('CQREEAUGJZ');
l_Appl.SetMode('suggest');
l_Appl.SetRows('10');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
var res = l_Appl.GetJSONData();
SuggesterLib.render_suggest(res,'CQREEAUGJZ','CQREEAUGJZ',false,'ALUYEPUVLF_DIV','ALUYEPUVLF_HEADER',0);
return l_bResult;
}
SuggesterLib.select_suggest.CQREEAUGJZ=["SOSCLIEPAE",[null,null],function(newval) { return HtW(newval,'C')}];
function Link_CQREEAUGJZ(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_SOSCLIEPAE);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODSTA',w_SOSCLIEPAE,3,0);
l_Appl.SetFields('CODSTA,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbstati');
l_Appl.SetID('CQREEAUGJZ');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_SOSCLIEPAE=l_Appl.GetStringValue('CODSTA',3,0);
w_xDESSTATO=l_Appl.GetStringValue('DESCRI',40,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_CQREEAUGJZ_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_CQREEAUGJZ';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_CQREEAUGJZ();
l_oWv.setValue('FieldFilter',l_cFieldFilter);
if ( ! (Empty(l_Appl.GetWhereAddedFixedFiltersUnencoded()))) {
if ( ! (Empty(l_cFixedFilter))) {
l_cFixedFilter=l_cFixedFilter+' and ';
}
l_cFixedFilter=l_cFixedFilter+l_Appl.GetWhereAddedFixedFiltersUnencoded();
}
l_oWv.setValue('FixedFilter',l_cFixedFilter);
var initEntityFields = '';
l_cLinkUrl='../servlet/SPVisualZoom'+'?m_cWv='+URLenc(l_oWv.asString());
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
function Link_CQREEAUGJZ_Blank() {
w_SOSCLIEPAE='';
w_xDESSTATO='';
}
function LOpt_CQREEAUGJZ() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstati','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODSTA','C'));
l_oWv.setValue('LinkedField',WtA('CODSTA','C'));
l_oWv.setValue('UID',WtA('CQREEAUGJZ','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['CQREEAUGJZ'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('1884688478'),'C'));
return l_oWv;
}
function Sugg_RNXXROADTV(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_Appl = LinkApplet();
var l_bEmp = Empty(HtW(Ctrl('RNXXROADTV').value,'C'));
l_Appl.SetStringKey('CITTA',HtW(Ctrl('RNXXROADTV').value,'C'),50,0);
l_Appl.SetFields('CITTA,PROV');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbcitta');
l_Appl.SetID('RNXXROADTV');
l_Appl.SetMode('suggest');
l_Appl.SetRows('10');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
var res = l_Appl.GetJSONData();
SuggesterLib.render_suggest(res,'RNXXROADTV','RNXXROADTV',false,'ALUYEPUVLF_DIV','ALUYEPUVLF_HEADER',0);
return l_bResult;
}
SuggesterLib.select_suggest.RNXXROADTV=["SOSCLIECR",[null,null],function(newval) { return HtW(newval,'C')}];
function Link_RNXXROADTV(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_SOSCLIECR);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CITTA',w_SOSCLIECR,50,0);
l_Appl.SetFields('CITTA,PROV');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbcitta');
l_Appl.SetID('RNXXROADTV');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_SOSCLIECR=l_Appl.GetStringValue('CITTA',50,0);
w_SOSCLIEPR=l_Appl.GetStringValue('PROV',2,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_RNXXROADTV_Blank();
l_bResult=true;
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_RNXXROADTV';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_RNXXROADTV();
l_oWv.setValue('FieldFilter',l_cFieldFilter);
if ( ! (Empty(l_Appl.GetWhereAddedFixedFiltersUnencoded()))) {
if ( ! (Empty(l_cFixedFilter))) {
l_cFixedFilter=l_cFixedFilter+' and ';
}
l_cFixedFilter=l_cFixedFilter+l_Appl.GetWhereAddedFixedFiltersUnencoded();
}
l_oWv.setValue('FixedFilter',l_cFixedFilter);
var initEntityFields = '';
l_cLinkUrl='../servlet/SPVisualZoom'+'?m_cWv='+URLenc(l_oWv.asString());
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
function Link_RNXXROADTV_Blank() {
w_SOSCLIEPR='';
}
function LOpt_RNXXROADTV() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcitta','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CITTA','C'));
l_oWv.setValue('LinkedField',WtA('CITTA','C'));
l_oWv.setValue('UID',WtA('RNXXROADTV','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['RNXXROADTV'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('15186643'),'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'DHBRXDCHIH')) {
last_focused_comp=GetLastFocusedElementOfLink('DHBRXDCHIH');
function SetMethod_DHBRXDCHIH() {
Set_SOSCODDIP(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_DHBRXDCHIH();
} else {
setTimeout(SetMethod_DHBRXDCHIH,1);
}
bResult=true;
}
if (Eq(varName,'NMTFLCHLGD')) {
last_focused_comp=GetLastFocusedElementOfLink('NMTFLCHLGD');
function SetMethod_NMTFLCHLGD() {
Set_SOSSEGNALN(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_NMTFLCHLGD();
} else {
setTimeout(SetMethod_NMTFLCHLGD,1);
}
bResult=true;
}
if (Eq(varName,'UXJUHWBCMH')) {
last_focused_comp=GetLastFocusedElementOfLink('UXJUHWBCMH');
function SetMethod_UXJUHWBCMH() {
Set_IDBIGLIETTO(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_UXJUHWBCMH();
} else {
setTimeout(SetMethod_UXJUHWBCMH,1);
}
bResult=true;
}
if (Eq(varName,'EKWIYNRJCN')) {
last_focused_comp=GetLastFocusedElementOfLink('EKWIYNRJCN');
function SetMethod_EKWIYNRJCN() {
Set_SOSCLIELN(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_EKWIYNRJCN();
} else {
setTimeout(SetMethod_EKWIYNRJCN,1);
}
bResult=true;
}
if (Eq(varName,'CQREEAUGJZ')) {
last_focused_comp=GetLastFocusedElementOfLink('CQREEAUGJZ');
function SetMethod_CQREEAUGJZ() {
Set_SOSCLIEPAE(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_CQREEAUGJZ();
} else {
setTimeout(SetMethod_CQREEAUGJZ,1);
}
bResult=true;
}
if (Eq(varName,'RNXXROADTV')) {
last_focused_comp=GetLastFocusedElementOfLink('RNXXROADTV');
function SetMethod_RNXXROADTV() {
Set_SOSCLIECR(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_RNXXROADTV();
} else {
setTimeout(SetMethod_RNXXROADTV,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'DHBRXDCHIH')) {
return [Ctrl('DHBRXDCHIH')];
}
if (Eq(varName,'NMTFLCHLGD')) {
return [Ctrl('NMTFLCHLGD')];
}
if (Eq(varName,'UXJUHWBCMH')) {
return [Ctrl('UXJUHWBCMH')];
}
if (Eq(varName,'EKWIYNRJCN')) {
return [Ctrl('EKWIYNRJCN')];
}
if (Eq(varName,'CQREEAUGJZ')) {
return [Ctrl('CQREEAUGJZ')];
}
if (Eq(varName,'RNXXROADTV')) {
return [Ctrl('RNXXROADTV')];
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
parent.ZtVWeb.raiseEventToEvalParms('armt_cgo_sos_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('armt_cgo_sos_dataNotSent',{'action':formaction});
}
}
}
}
CheckChild.child=[];
function Check() {
var l_bResult = true;
ResetErrorVars();
m_nLastError=0;
if ((false) && ( ! (_ChkObl('DHBRXDCHIH',1)))) {
_SignErr('DHBRXDCHIH');
m_cLastWorkVarErrorMsg='10078979362';
l_bResult=false;
w_SOSCODDIP=HtW('','C');
} else if ( ! (_ChkObl('NHTTQSKNCE',1))) {
_SignErr('NHTTQSKNCE');
m_cLastWorkVarErrorMsg='10869604963';
l_bResult=false;
w_SOSSEGNANT=HtW('','C');
} else if ( ! (_ChkObl('IRAARTIBBY',1))) {
_SignErr('IRAARTIBBY');
m_cLastWorkVarErrorMsg='132483918';
l_bResult=false;
w_SOSSEGNAFAX=HtW('','C');
} else if ( ! (_ChkObl('CGKCUTXIQV',1))) {
_SignErr('CGKCUTXIQV');
m_cLastWorkVarErrorMsg='7534101';
l_bResult=false;
w_SOSSEGNAEM=HtW('','C');
} else if ( ! (_ChkObl('UVDPOGERZK',1))) {
_SignErr('UVDPOGERZK');
m_cLastWorkVarErrorMsg='11845560570';
l_bResult=false;
w_SOSSEGNACF=HtW('','C');
} else if ( ! (_ChkObl('HNLUXWZZSG',1))) {
_SignErr('HNLUXWZZSG');
m_cLastWorkVarErrorMsg='1816546867';
l_bResult=false;
w_SOSSEGNACOG=HtW('','C');
} else if ( ! (_ChkObl('NPOZCOOROF',1))) {
_SignErr('NPOZCOOROF');
m_cLastWorkVarErrorMsg='443454';
l_bResult=false;
w_SOSSEGNANOM=HtW('','C');
} else if ( ! (_ChkObl('NMTFLCHLGD',1))) {
_SignErr('NMTFLCHLGD');
m_cLastWorkVarErrorMsg='1625200191';
l_bResult=false;
w_SOSSEGNALN=HtW('','C');
} else if ( ! (_ChkObl('BLOPGSOJRJ',1))) {
_SignErr('BLOPGSOJRJ');
m_cLastWorkVarErrorMsg='10669633614';
l_bResult=false;
w_SOSSEGNADN=HtW('','D');
} else if ( ! (_ChkObl('EABOOAYYWK',1))) {
_SignErr('EABOOAYYWK');
m_cLastWorkVarErrorMsg='7776675';
l_bResult=false;
w_SOSSEGNASX=HtW('','C');
} else if ( ! (_ChkObl('MHDGPLPBBN',1))) {
_SignErr('MHDGPLPBBN');
m_cLastWorkVarErrorMsg='383234328';
l_bResult=false;
w_SOSSTATOOP=HtW('','C');
} else if ( ! (_ChkObl('UXJUHWBCMH',1))) {
_SignErr('UXJUHWBCMH');
m_cLastWorkVarErrorMsg='48541742';
l_bResult=false;
w_IDBIGLIETTO=HtW('','C');
} else if ( ! (_ChkObl('CCDNZZPUCA',1))) {
_SignErr('CCDNZZPUCA');
m_cLastWorkVarErrorMsg='829201110';
l_bResult=false;
w_SOSDATAOP=HtW('','D');
} else if ( ! (_ChkObl('AMJZYMJHYP',1))) {
_SignErr('AMJZYMJHYP');
m_cLastWorkVarErrorMsg='829257574';
l_bResult=false;
w_SOSTIPOOP=HtW('','C');
} else if ( ! (_ChkObl('DXDTFLVDRK',1))) {
_SignErr('DXDTFLVDRK');
m_cLastWorkVarErrorMsg='10675153370';
l_bResult=false;
w_SOSIMPOPE=HtW('','N');
} else if ( ! (_ChkObl('CUWGJLKVOE',1))) {
_SignErr('CUWGJLKVOE');
m_cLastWorkVarErrorMsg='10651434988';
l_bResult=false;
w_SOSMEZPAG=HtW('','C');
} else if ((Gt(At(w_SOSMEZPAG,'|I|P|E'),0)) && ( ! (_ChkObl('AYIZLJVVCP',1)))) {
_SignErr('AYIZLJVVCP');
m_cLastWorkVarErrorMsg='10799817497';
l_bResult=false;
w_SOSNUMBON=HtW('','C');
} else if ((Gt(At(w_SOSMEZPAG,'|C|B'),0)) && ( ! (_ChkObl('SYZBUNLLHR',1)))) {
_SignErr('SYZBUNLLHR');
m_cLastWorkVarErrorMsg='1943925269';
l_bResult=false;
w_SOSBANASS=HtW('','C');
} else if ((Gt(At(w_SOSMEZPAG,'|C|B'),0)) && ( ! (_ChkObl('SBVSTUFZNJ',1)))) {
_SignErr('SBVSTUFZNJ');
m_cLastWorkVarErrorMsg='1053663553';
l_bResult=false;
w_SOSNUMASS=HtW('','C');
} else if ( ! (_ChkObl('ABTEUVWFFQ',1))) {
_SignErr('ABTEUVWFFQ');
m_cLastWorkVarErrorMsg='1414023497';
l_bResult=false;
w_SOSDESOPE=HtW('','M');
} else if ( ! (_ChkObl('YBPKXABHYP',1))) {
_SignErr('YBPKXABHYP','10066897585');
l_bResult=false;
w_SOSMOTSOS=HtW('','M');
} else if ( ! (_ChkObl('IAAFYFVCOO',1))) {
_SignErr('IAAFYFVCOO');
m_cLastWorkVarErrorMsg='10654635466';
l_bResult=false;
w_SOSCLIECOG=HtW('','C');
} else if ( ! (_ChkObl('YZCTAZEUHT',1))) {
_SignErr('YZCTAZEUHT');
m_cLastWorkVarErrorMsg='6131587';
l_bResult=false;
w_SOSCLIENOM=HtW('','C');
} else if ( ! (_ChkObl('EKWIYNRJCN',1))) {
_SignErr('EKWIYNRJCN');
m_cLastWorkVarErrorMsg='1287421676';
l_bResult=false;
w_SOSCLIELN=HtW('','C');
} else if ( ! (_ChkObl('ESIPESUKFU',1))) {
_SignErr('ESIPESUKFU');
m_cLastWorkVarErrorMsg='10669633614';
l_bResult=false;
w_SOSCLIEDN=HtW('','D');
} else if ( ! (_ChkObl('ZAUFIWBFWS',1))) {
_SignErr('ZAUFIWBFWS');
m_cLastWorkVarErrorMsg='7776675';
l_bResult=false;
w_SOSCLIESX=HtW('','C');
} else if ( ! (_ChkObl('YAUYCDEFNH',1))) {
_SignErr('YAUYCDEFNH');
m_cLastWorkVarErrorMsg='10465059384';
l_bResult=false;
w_SOSCLIECF=HtW('','C');
} else if ( ! (_ChkObl('CQREEAUGJZ',1))) {
_SignErr('CQREEAUGJZ');
m_cLastWorkVarErrorMsg='11910664466';
l_bResult=false;
w_SOSCLIEPAE=HtW('','C');
} else if ( ! (_ChkObl('RNXXROADTV',1))) {
_SignErr('RNXXROADTV');
m_cLastWorkVarErrorMsg='113624115';
l_bResult=false;
w_SOSCLIECR=HtW('','C');
} else if ( ! (_ChkObl('HRARTBAAAD',1))) {
_SignErr('HRARTBAAAD');
m_cLastWorkVarErrorMsg='554236824';
l_bResult=false;
w_SOSCLIEIND=HtW('','C');
} else if ( ! (_ChkObl('XZMROSWRMH',1))) {
_SignErr('XZMROSWRMH');
m_cLastWorkVarErrorMsg='259661248';
l_bResult=false;
w_SOSCLIECAR=HtW('','C');
} else if ( ! (_ChkObl('YSEWNSQRQV',1))) {
_SignErr('YSEWNSQRQV');
m_cLastWorkVarErrorMsg='27131685';
l_bResult=false;
w_SOSCLIETD=HtW('','C');
} else if (( ! (Empty(w_SOSCLIETD))) && ( ! (_ChkObl('RGTEMJRSBB',1)))) {
_SignErr('RGTEMJRSBB');
m_cLastWorkVarErrorMsg='1275175384';
l_bResult=false;
w_SOSCLIEND=HtW('','C');
} else if (( ! (Empty(w_SOSCLIETD))) && (( ! (_ChkObl('MDMENXCYFS',1))) || ( ! (arfn_cgo_chkdata(w_SOSCLIEDRD,w_SOSCLIETD,'R',w_SOSDATAOP))))) {
_SignErr('MDMENXCYFS','11525797640');
l_bResult=false;
w_SOSCLIEDRD=HtW('','D');
} else if (( ! (Empty(w_SOSCLIETD))) && (( ! (_ChkObl('SMDOEMVCES',1))) || ( ! (arfn_cgo_chkdata(w_SOSCLIEDSD,w_SOSCLIETD,'S',w_SOSDATAOP))))) {
_SignErr('SMDOEMVCES','11525797640');
l_bResult=false;
w_SOSCLIEDSD=HtW('','D');
} else if (( ! (Empty(w_SOSCLIETD))) && ( ! (_ChkObl('LVYUCXICCL',1)))) {
_SignErr('LVYUCXICCL');
m_cLastWorkVarErrorMsg='10737443664';
l_bResult=false;
w_SOSCLIEAUD=HtW('','C');
} else if ( ! (_ChkObl('GWPOQYXVMH',1))) {
_SignErr('GWPOQYXVMH');
m_cLastWorkVarErrorMsg='11694162167';
l_bResult=false;
w_SOSCLIEPN=HtW('','C');
} else if ( ! (_ChkObl('EOTGCHITKP',1))) {
_SignErr('EOTGCHITKP');
m_cLastWorkVarErrorMsg='1969246349';
l_bResult=false;
w_SOSCLIEPR=HtW('','C');
} else if ( ! (Check_QNEKQYKSHZ(true))) {
l_bResult = false;
} else if ( ! (Check_YHNSLBLWFP(true))) {
l_bResult = false;
} else if ( ! (Check_NXWIUCGNDI(true))) {
l_bResult = false;
} else if ( ! (Check_OHCORUHEID(true))) {
l_bResult = false;
} else if ( ! (Check_GORGNKWJSO(true))) {
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
if (Eq('NMTFLCHLGD_ZOOM',lc)) {
return 0;
}
if (Eq('NMTFLCHLGD',lc)) {
return 0;
}
if (Eq('BLOPGSOJRJ_ZOOM',lc)) {
return 1;
}
if (Eq('UXJUHWBCMH_ZOOM',lc)) {
return 1;
}
if (Eq('UXJUHWBCMH',lc)) {
return 1;
}
if (Eq('CCDNZZPUCA_ZOOM',lc)) {
return 2;
}
if (Eq('EKWIYNRJCN_ZOOM',lc)) {
return 2;
}
if (Eq('EKWIYNRJCN',lc)) {
return 2;
}
if (Eq('ESIPESUKFU_ZOOM',lc)) {
return 3;
}
if (Eq('CQREEAUGJZ_ZOOM',lc)) {
return 3;
}
if (Eq('CQREEAUGJZ',lc)) {
return 3;
}
if (Eq('RNXXROADTV_ZOOM',lc)) {
return 4;
}
if (Eq('RNXXROADTV',lc)) {
return 4;
}
if (Eq('MDMENXCYFS_ZOOM',lc)) {
return 5;
}
if (Eq('SMDOEMVCES_ZOOM',lc)) {
return 5;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_NMTFLCHLGD();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,1)) {
l_oWv=LOpt_UXJUHWBCMH();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
l_cFixedFilter=l_cFixedFilter+l_cAndOp+_flt_('CODDIPE',w_gCodDip,null,true,'=');
if ( ! (Empty(l_cFixedFilter))) {
l_cAndOp=' and ';
}
l_oWv.setValue('FixedFilter',l_cFixedFilter);
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,2)) {
l_oWv=LOpt_EKWIYNRJCN();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,3)) {
l_oWv=LOpt_CQREEAUGJZ();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,4)) {
l_oWv=LOpt_RNXXROADTV();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
}
function FillWv() {
var l_oWv = InitWvApplet();
l_oWv.setValue('m_CheckVars',JSON.stringify(m_CheckVars));
l_oWv.setValue('SOSCODICE',WtA(w_SOSCODICE,'N'));
l_oWv.setValue('op_SOSCODICE',WtA(op_SOSCODICE,'N'));
l_oWv.setValue('SOSCODDIP',WtA(w_SOSCODDIP,'C'));
l_oWv.setValue('SOSSEGNANT',WtA(w_SOSSEGNANT,'C'));
l_oWv.setValue('SOSSEGNAFAX',WtA(w_SOSSEGNAFAX,'C'));
l_oWv.setValue('SOSSEGNAEM',WtA(w_SOSSEGNAEM,'C'));
l_oWv.setValue('SOSSEGNACF',WtA(w_SOSSEGNACF,'C'));
l_oWv.setValue('SOSSEGNACOG',WtA(w_SOSSEGNACOG,'C'));
l_oWv.setValue('SOSSEGNANOM',WtA(w_SOSSEGNANOM,'C'));
l_oWv.setValue('SOSSEGNALN',WtA(w_SOSSEGNALN,'C'));
l_oWv.setValue('SOSSEGNADN',WtA(w_SOSSEGNADN,'D'));
l_oWv.setValue('SOSSEGNASX',WtA(w_SOSSEGNASX,'C'));
l_oWv.setValue('SOSSTATOOP',WtA(w_SOSSTATOOP,'C'));
l_oWv.setValue('SOSDATAOP',WtA(w_SOSDATAOP,'D'));
l_oWv.setValue('SOSTIPOOP',WtA(w_SOSTIPOOP,'C'));
l_oWv.setValue('SOSIMPOPE',WtA(w_SOSIMPOPE,'N'));
l_oWv.setValue('SOSMEZPAG',WtA(w_SOSMEZPAG,'C'));
l_oWv.setValue('SOSNUMBON',WtA(w_SOSNUMBON,'C'));
l_oWv.setValue('SOSBANASS',WtA(w_SOSBANASS,'C'));
l_oWv.setValue('SOSNUMASS',WtA(w_SOSNUMASS,'C'));
l_oWv.setValue('SOSDESOPE',WtA(w_SOSDESOPE,'M'));
l_oWv.setValue('SOSMOTSOS',WtA(w_SOSMOTSOS,'M'));
l_oWv.setValue('SOSCLIECOG',WtA(w_SOSCLIECOG,'C'));
l_oWv.setValue('SOSCLIENOM',WtA(w_SOSCLIENOM,'C'));
l_oWv.setValue('SOSCLIELN',WtA(w_SOSCLIELN,'C'));
l_oWv.setValue('SOSCLIEDN',WtA(w_SOSCLIEDN,'D'));
l_oWv.setValue('SOSCLIESX',WtA(w_SOSCLIESX,'C'));
l_oWv.setValue('SOSCLIECF',WtA(w_SOSCLIECF,'C'));
l_oWv.setValue('SOSCLIEPAE',WtA(w_SOSCLIEPAE,'C'));
l_oWv.setValue('SOSCLIECR',WtA(w_SOSCLIECR,'C'));
l_oWv.setValue('SOSCLIEIND',WtA(w_SOSCLIEIND,'C'));
l_oWv.setValue('SOSCLIECAR',WtA(w_SOSCLIECAR,'C'));
l_oWv.setValue('SOSCLIETD',WtA(w_SOSCLIETD,'C'));
l_oWv.setValue('SOSCLIEND',WtA(w_SOSCLIEND,'C'));
l_oWv.setValue('SOSCLIEDRD',WtA(w_SOSCLIEDRD,'D'));
l_oWv.setValue('SOSCLIEDSD',WtA(w_SOSCLIEDSD,'D'));
l_oWv.setValue('SOSCLIEAUD',WtA(w_SOSCLIEAUD,'C'));
l_oWv.setValue('SOSSEGNAPN',WtA(w_SOSSEGNAPN,'C'));
l_oWv.setValue('SOSCLIEPN',WtA(w_SOSCLIEPN,'C'));
l_oWv.setValue('SOSCLIEPR',WtA(w_SOSCLIEPR,'C'));
l_oWv.setValue('SOSUTENTE',WtA(w_SOSUTENTE,'N'));
l_oWv.setValue('SOSDATSEG',WtA(w_SOSDATSEG,'D'));
l_oWv.setValue('gCodDip',WtA(w_gCodDip,'C'));
l_oWv.setValue('IDBIGLIETTO',WtA(w_IDBIGLIETTO,'C'));
l_oWv.setValue('xdesdip',WtA(w_xdesdip,'C'));
l_oWv.setValue('gUserCode',WtA(w_gUserCode,'N'));
l_oWv.setValue('xDESSTATO',WtA(w_xDESSTATO,'C'));
l_oWv.setValue('op_codazi',WtA(op_codazi,'C'));
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
FillWv.n=["SOSCODICE","SOSCODDIP","SOSSEGNANT","SOSSEGNAFAX","SOSSEGNAEM","SOSSEGNACF","SOSSEGNACOG","SOSSEGNANOM","SOSSEGNALN","SOSSEGNADN","SOSSEGNASX","SOSSTATOOP","SOSDATAOP","SOSTIPOOP","SOSIMPOPE","SOSMEZPAG","SOSNUMBON","SOSBANASS","SOSNUMASS","SOSDESOPE","SOSMOTSOS","SOSCLIECOG","SOSCLIENOM","SOSCLIELN","SOSCLIEDN","SOSCLIESX","SOSCLIECF","SOSCLIEPAE","SOSCLIECR","SOSCLIEIND","SOSCLIECAR","SOSCLIETD","SOSCLIEND","SOSCLIEDRD","SOSCLIEDSD","SOSCLIEAUD","SOSSEGNAPN","SOSCLIEPN","SOSCLIEPR","SOSUTENTE","SOSDATSEG","gCodDip","IDBIGLIETTO","xdesdip","gUserCode","xDESSTATO"];
function SetModified() {
m_bUpdated=true;
}
