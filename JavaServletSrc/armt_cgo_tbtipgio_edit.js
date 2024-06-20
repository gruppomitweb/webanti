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
function DisplayErrorMessage_ardt_cgo_tgtiporeg() {
if ( ! (ChildToLoad(FrameRef('ardt_cgo_tgtiporeg'))) && Ne(typeof(FrameRef('ardt_cgo_tgtiporeg').DisplayErrorMessage),'undefined')) {
FrameRef('ardt_cgo_tgtiporeg').DisplayErrorMessage();
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
l_bEnabled= ! (Eq(w_FLGMLGIO,'S')) || IsDisabledByStateDriver('IMPMINGIO');
SetDisabled('UFVFYVMNVG',l_bEnabled);
l_bEnabled= ! (Eq(w_FLGMLGIO,'S')) || IsDisabledByStateDriver('IMPMINTOT');
SetDisabled('UVKSMYBGBT',l_bEnabled);
if (IsDisabledByStateDriver('Base')) {
DisableInputsInContainer(Ctrl('YORQOIOBQN'),true);
}
if (IsDisabledByStateDriver('box_GIMNJEFKNF')) {
DisableInputsInContainer(Ctrl('GIMNJEFKNF'),true);
}
if (IsDisabledByStateDriver('box_MFCHEDYPZM')) {
DisableInputsInContainer(Ctrl('MFCHEDYPZM'),true);
}
if (IsDisabledByStateDriver('box_OERGIOTKFK')) {
DisableInputsInContainer(Ctrl('OERGIOTKFK'),true);
}
if (IsDisabledByStateDriver('TipReg')) {
DisableInputsInContainer(Ctrl('PBPNWREDVO'),true);
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
function Set_CODTPGIO(ctrlValue,kmode,e) {
if (Ne(w_CODTPGIO,ctrlValue)) {
var ctl = _GetCtl(e,'RCAIOHOYCN');
if (_tracker.goon(ctl,ctrlValue)) {
w_CODTPGIO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RCAIOHOYCN',0);
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
function Set_DESTPGIO(ctrlValue,kmode,e) {
if (Ne(w_DESTPGIO,ctrlValue)) {
var ctl = _GetCtl(e,'PLTDFOMPMX');
if (_tracker.goon(ctl,ctrlValue)) {
w_DESTPGIO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('PLTDFOMPMX',0);
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
function Set_SOGTPGIO(ctrlValue,kmode,e) {
if (Ne(w_SOGTPGIO,ctrlValue)) {
var ctl = _GetCtl(e,'DLCJAPAHNK');
if (_tracker.goon(ctl,ctrlValue)) {
w_SOGTPGIO=ValidNum(ctrlValue,'999999999.99');
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('DLCJAPAHNK',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('DLCJAPAHNK',function(){return WtH(w_SOGTPGIO,'N',12,2,'999,999,999.99')},w_SOGTPGIO);
return l_bResult;
} else {
ctl.value=WtH('','N',12,2,'999999999.99');
_ResetTracker();
return true;
}
} else {
SPBOUILib.SetInputValue('DLCJAPAHNK',function(){return WtH(w_SOGTPGIO,'N',12,2,'999,999,999.99')},w_SOGTPGIO);
}
return true;
}
function Set_EDTTPGIO(ctrlValue,kmode,e) {
if (Ne(w_EDTTPGIO,ctrlValue)) {
var ctl = _GetCtl(e,'PPZWLBHZXY');
if (_tracker.goon(ctl,ctrlValue)) {
w_EDTTPGIO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('PPZWLBHZXY',0);
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
function Set_DEFTPGIO(ctrlValue,kmode,e) {
if (Ne(w_DEFTPGIO,ctrlValue)) {
var ctl = _GetCtl(e,'SOFGJQQNFS');
if (_tracker.goon(ctl,ctrlValue)) {
w_DEFTPGIO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SOFGJQQNFS',0);
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
function Set_EDTSPGIO(ctrlValue,kmode,e) {
if (Ne(w_EDTSPGIO,ctrlValue)) {
var ctl = _GetCtl(e,'GOFVHZECXL');
if (_tracker.goon(ctl,ctrlValue)) {
w_EDTSPGIO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('GOFVHZECXL',0);
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
function Set_DEFSPGIO(ctrlValue,kmode,e) {
if (Ne(w_DEFSPGIO,ctrlValue)) {
var ctl = _GetCtl(e,'NZZQBPTZYU');
if (_tracker.goon(ctl,ctrlValue)) {
w_DEFSPGIO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NZZQBPTZYU',0);
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
function Set_FLGPLGIO(ctrlValue,kmode,e) {
if (Ne(w_FLGPLGIO,ctrlValue)) {
var ctl = _GetCtl(e,'MRDEGXONBG');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLGPLGIO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MRDEGXONBG',0);
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
function Set_FLGMLGIO(ctrlValue,kmode,e) {
if (Ne(w_FLGMLGIO,ctrlValue)) {
var ctl = _GetCtl(e,'FMLKVYWRZP');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLGMLGIO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FMLKVYWRZP',0);
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
function Set_MAGPAGGIO(ctrlValue,kmode,e) {
if (Ne(w_MAGPAGGIO,ctrlValue)) {
var ctl = _GetCtl(e,'RNGJQLKVFO');
if (_tracker.goon(ctl,ctrlValue)) {
w_MAGPAGGIO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RNGJQLKVFO',0);
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
function Set_MINPAGGIO(ctrlValue,kmode,e) {
if (Ne(w_MINPAGGIO,ctrlValue)) {
var ctl = _GetCtl(e,'UFVJWZLULG');
if (_tracker.goon(ctl,ctrlValue)) {
w_MINPAGGIO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UFVJWZLULG',0);
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
function Set_FDC1OSGIO(ctrlValue,kmode,e) {
if (Ne(w_FDC1OSGIO,ctrlValue)) {
var ctl = _GetCtl(e,'CAUFCTBRNM');
if (_tracker.goon(ctl,ctrlValue)) {
w_FDC1OSGIO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CAUFCTBRNM',0);
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
function Set_FDC2OSGIO(ctrlValue,kmode,e) {
if (Ne(w_FDC2OSGIO,ctrlValue)) {
var ctl = _GetCtl(e,'UGCFKKQJNN');
if (_tracker.goon(ctl,ctrlValue)) {
w_FDC2OSGIO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UGCFKKQJNN',0);
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
function Set_FDC3OSGIO(ctrlValue,kmode,e) {
if (Ne(w_FDC3OSGIO,ctrlValue)) {
var ctl = _GetCtl(e,'XNNAMCGSXP');
if (_tracker.goon(ctl,ctrlValue)) {
w_FDC3OSGIO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XNNAMCGSXP',0);
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
function Set_FDC4OSGIO(ctrlValue,kmode,e) {
if (Ne(w_FDC4OSGIO,ctrlValue)) {
var ctl = _GetCtl(e,'MYUZABATXZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_FDC4OSGIO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MYUZABATXZ',0);
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
function Set_FDC5OSGIO(ctrlValue,kmode,e) {
if (Ne(w_FDC5OSGIO,ctrlValue)) {
var ctl = _GetCtl(e,'RSGIDFYOLS');
if (_tracker.goon(ctl,ctrlValue)) {
w_FDC5OSGIO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RSGIDFYOLS',0);
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
function Set_FDC6OSGIO(ctrlValue,kmode,e) {
if (Ne(w_FDC6OSGIO,ctrlValue)) {
var ctl = _GetCtl(e,'YPMOMULORE');
if (_tracker.goon(ctl,ctrlValue)) {
w_FDC6OSGIO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YPMOMULORE',0);
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
function Set_FDC1SSGIO(ctrlValue,kmode,e) {
if (Ne(w_FDC1SSGIO,ctrlValue)) {
var ctl = _GetCtl(e,'QEKBNPGOBS');
if (_tracker.goon(ctl,ctrlValue)) {
w_FDC1SSGIO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QEKBNPGOBS',0);
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
function Set_FDC2SSGIO(ctrlValue,kmode,e) {
if (Ne(w_FDC2SSGIO,ctrlValue)) {
var ctl = _GetCtl(e,'NFHGTEJQNE');
if (_tracker.goon(ctl,ctrlValue)) {
w_FDC2SSGIO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NFHGTEJQNE',0);
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
function Set_FDC3SSGIO(ctrlValue,kmode,e) {
if (Ne(w_FDC3SSGIO,ctrlValue)) {
var ctl = _GetCtl(e,'GJLCDJIDAY');
if (_tracker.goon(ctl,ctrlValue)) {
w_FDC3SSGIO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('GJLCDJIDAY',0);
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
function Set_FDC4SSGIO(ctrlValue,kmode,e) {
if (Ne(w_FDC4SSGIO,ctrlValue)) {
var ctl = _GetCtl(e,'RBOWBOPVOA');
if (_tracker.goon(ctl,ctrlValue)) {
w_FDC4SSGIO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RBOWBOPVOA',0);
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
function Set_FDC5SSGIO(ctrlValue,kmode,e) {
if (Ne(w_FDC5SSGIO,ctrlValue)) {
var ctl = _GetCtl(e,'DHNVKQKTHK');
if (_tracker.goon(ctl,ctrlValue)) {
w_FDC5SSGIO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('DHNVKQKTHK',0);
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
function Set_FDC6SSGIO(ctrlValue,kmode,e) {
if (Ne(w_FDC6SSGIO,ctrlValue)) {
var ctl = _GetCtl(e,'CBJEEAJCGS');
if (_tracker.goon(ctl,ctrlValue)) {
w_FDC6SSGIO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CBJEEAJCGS',0);
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
function Set_FDC1ACGIO(ctrlValue,kmode,e) {
if (Ne(w_FDC1ACGIO,ctrlValue)) {
var ctl = _GetCtl(e,'UXGJFWIPXB');
if (_tracker.goon(ctl,ctrlValue)) {
w_FDC1ACGIO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UXGJFWIPXB',0);
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
function Set_FDC2ACGIO(ctrlValue,kmode,e) {
if (Ne(w_FDC2ACGIO,ctrlValue)) {
var ctl = _GetCtl(e,'TKEHQQFQUC');
if (_tracker.goon(ctl,ctrlValue)) {
w_FDC2ACGIO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('TKEHQQFQUC',0);
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
function Set_FDC3ACGIO(ctrlValue,kmode,e) {
if (Ne(w_FDC3ACGIO,ctrlValue)) {
var ctl = _GetCtl(e,'XBPDZFAWFR');
if (_tracker.goon(ctl,ctrlValue)) {
w_FDC3ACGIO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XBPDZFAWFR',0);
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
function Set_FDC4ACGIO(ctrlValue,kmode,e) {
if (Ne(w_FDC4ACGIO,ctrlValue)) {
var ctl = _GetCtl(e,'ZJMEDHEECW');
if (_tracker.goon(ctl,ctrlValue)) {
w_FDC4ACGIO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ZJMEDHEECW',0);
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
function Set_FDC5ACGIO(ctrlValue,kmode,e) {
if (Ne(w_FDC5ACGIO,ctrlValue)) {
var ctl = _GetCtl(e,'TOJFZPDKWJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_FDC5ACGIO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('TOJFZPDKWJ',0);
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
function Set_FDC6ACGIO(ctrlValue,kmode,e) {
if (Ne(w_FDC6ACGIO,ctrlValue)) {
var ctl = _GetCtl(e,'UXAYRLQXMN');
if (_tracker.goon(ctl,ctrlValue)) {
w_FDC6ACGIO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UXAYRLQXMN',0);
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
function Set_NCOPAGGIO(ctrlValue,kmode,e) {
if (Ne(w_NCOPAGGIO,ctrlValue)) {
var ctl = _GetCtl(e,'MXUUACEBJE');
if (_tracker.goon(ctl,ctrlValue)) {
w_NCOPAGGIO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MXUUACEBJE',0);
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
function Set_FLTIPGIO(ctrlValue,kmode,e) {
if (Ne(w_FLTIPGIO,ctrlValue)) {
var ctl = _GetCtl(e,'LTMWIPFDRU');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLTIPGIO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('LTMWIPFDRU',0);
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
function Set_FLGATTIVO(ctrlValue,kmode,e) {
if (Ne(w_FLGATTIVO,ctrlValue)) {
var ctl = _GetCtl(e,'RVLRRQTSCQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLGATTIVO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RVLRRQTSCQ',0);
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
function Set_IMPMINGIO(ctrlValue,kmode,e) {
if (Ne(w_IMPMINGIO,ctrlValue)) {
var ctl = _GetCtl(e,'UFVFYVMNVG');
if (_tracker.goon(ctl,ctrlValue)) {
w_IMPMINGIO=ValidNum(ctrlValue,'9999999.99');
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UFVFYVMNVG',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('UFVFYVMNVG',function(){return WtH(w_IMPMINGIO,'N',10,2,'9,999,999.99')},w_IMPMINGIO);
return l_bResult;
} else {
ctl.value=WtH('','N',10,2,'9999999.99');
_ResetTracker();
return true;
}
} else {
SPBOUILib.SetInputValue('UFVFYVMNVG',function(){return WtH(w_IMPMINGIO,'N',10,2,'9,999,999.99')},w_IMPMINGIO);
}
return true;
}
function Set_IMPMINTOT(ctrlValue,kmode,e) {
if (Ne(w_IMPMINTOT,ctrlValue)) {
var ctl = _GetCtl(e,'UVKSMYBGBT');
if (_tracker.goon(ctl,ctrlValue)) {
w_IMPMINTOT=ValidNum(ctrlValue,'9999999.99');
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UVKSMYBGBT',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('UVKSMYBGBT',function(){return WtH(w_IMPMINTOT,'N',12,2,'9,999,999.99')},w_IMPMINTOT);
return l_bResult;
} else {
ctl.value=WtH('','N',12,2,'9999999.99');
_ResetTracker();
return true;
}
} else {
SPBOUILib.SetInputValue('UVKSMYBGBT',function(){return WtH(w_IMPMINTOT,'N',12,2,'9,999,999.99')},w_IMPMINTOT);
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
parent.ZtVWeb.raiseEventToEvalParms('armt_cgo_tbtipgio_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('armt_cgo_tbtipgio_dataNotSent',{'action':formaction});
}
}
}
}
CheckChild.child=[{'prg':"ardt_cgo_tgtiporeg",'BOScId':function(){ return FrameRef('ardt_cgo_tgtiporeg')},'repeated':0}];
function Check() {
var l_bResult = true;
var l_bChildCheck = true;
ResetErrorVars();
m_nLastError=0;
if ( ! (_ChkObl('RCAIOHOYCN',1))) {
_SignErr('RCAIOHOYCN');
m_cLastWorkVarErrorMsg='1570205239';
l_bResult=false;
w_CODTPGIO=HtW('','C');
} else if ( ! (_ChkObl('PLTDFOMPMX',1))) {
_SignErr('PLTDFOMPMX');
m_cLastWorkVarErrorMsg='285808099';
l_bResult=false;
w_DESTPGIO=HtW('','C');
} else if ( ! (_ChkObl('DLCJAPAHNK',1))) {
_SignErr('DLCJAPAHNK');
m_cLastWorkVarErrorMsg='11848875500';
l_bResult=false;
w_SOGTPGIO=HtW('','N');
} else if ( ! (_ChkObl('PPZWLBHZXY',1))) {
_SignErr('PPZWLBHZXY');
m_cLastWorkVarErrorMsg='1264575246';
l_bResult=false;
w_EDTTPGIO='N';
} else if ( ! (_ChkObl('SOFGJQQNFS',1))) {
_SignErr('SOFGJQQNFS');
m_cLastWorkVarErrorMsg='805239427';
l_bResult=false;
w_DEFTPGIO=HtW('','C');
} else if ( ! (_ChkObl('GOFVHZECXL',1))) {
_SignErr('GOFVHZECXL');
m_cLastWorkVarErrorMsg='981524941';
l_bResult=false;
w_EDTSPGIO='N';
} else if ( ! (_ChkObl('NZZQBPTZYU',1))) {
_SignErr('NZZQBPTZYU');
m_cLastWorkVarErrorMsg='11061636098';
l_bResult=false;
w_DEFSPGIO=HtW('','C');
} else if ( ! (_ChkObl('MRDEGXONBG',1))) {
_SignErr('MRDEGXONBG');
m_cLastWorkVarErrorMsg='1255218623';
l_bResult=false;
w_FLGPLGIO='N';
} else if ( ! (_ChkObl('FMLKVYWRZP',1))) {
_SignErr('FMLKVYWRZP');
m_cLastWorkVarErrorMsg='11281970931';
l_bResult=false;
w_FLGMLGIO='N';
} else if ( ! (_ChkObl('RNGJQLKVFO',1))) {
_SignErr('RNGJQLKVFO');
m_cLastWorkVarErrorMsg='106476627';
l_bResult=false;
w_MAGPAGGIO=HtW('','N');
} else if ( ! (_ChkObl('UFVJWZLULG',1))) {
_SignErr('UFVJWZLULG');
m_cLastWorkVarErrorMsg='721888449';
l_bResult=false;
w_MINPAGGIO=HtW('','N');
} else if ( ! (_ChkObl('CAUFCTBRNM',1))) {
_SignErr('CAUFCTBRNM');
m_cLastWorkVarErrorMsg='11720460891';
l_bResult=false;
w_FDC1OSGIO='N';
} else if ( ! (_ChkObl('UGCFKKQJNN',1))) {
_SignErr('UGCFKKQJNN');
m_cLastWorkVarErrorMsg='1260570458';
l_bResult=false;
w_FDC2OSGIO='N';
} else if ( ! (_ChkObl('XNNAMCGSXP',1))) {
_SignErr('XNNAMCGSXP');
m_cLastWorkVarErrorMsg='11921223220';
l_bResult=false;
w_FDC3OSGIO='N';
} else if ( ! (_ChkObl('MYUZABATXZ',1))) {
_SignErr('MYUZABATXZ');
m_cLastWorkVarErrorMsg='11921223220';
l_bResult=false;
w_FDC4OSGIO='N';
} else if ( ! (_ChkObl('RSGIDFYOLS',1))) {
_SignErr('RSGIDFYOLS');
m_cLastWorkVarErrorMsg='11921223220';
l_bResult=false;
w_FDC5OSGIO='N';
} else if ( ! (_ChkObl('YPMOMULORE',1))) {
_SignErr('YPMOMULORE');
m_cLastWorkVarErrorMsg='11921223220';
l_bResult=false;
w_FDC6OSGIO='N';
} else if ( ! (_ChkObl('QEKBNPGOBS',1))) {
_SignErr('QEKBNPGOBS');
m_cLastWorkVarErrorMsg='11720460891';
l_bResult=false;
w_FDC1SSGIO='N';
} else if ( ! (_ChkObl('NFHGTEJQNE',1))) {
_SignErr('NFHGTEJQNE');
m_cLastWorkVarErrorMsg='1260570458';
l_bResult=false;
w_FDC2SSGIO='N';
} else if ( ! (_ChkObl('GJLCDJIDAY',1))) {
_SignErr('GJLCDJIDAY');
m_cLastWorkVarErrorMsg='11921223220';
l_bResult=false;
w_FDC3SSGIO='N';
} else if ( ! (_ChkObl('RBOWBOPVOA',1))) {
_SignErr('RBOWBOPVOA');
m_cLastWorkVarErrorMsg='11921223220';
l_bResult=false;
w_FDC4SSGIO='N';
} else if ( ! (_ChkObl('DHNVKQKTHK',1))) {
_SignErr('DHNVKQKTHK');
m_cLastWorkVarErrorMsg='11921223220';
l_bResult=false;
w_FDC5SSGIO='N';
} else if ( ! (_ChkObl('CBJEEAJCGS',1))) {
_SignErr('CBJEEAJCGS');
m_cLastWorkVarErrorMsg='11921223220';
l_bResult=false;
w_FDC6SSGIO='N';
} else if ( ! (_ChkObl('UXGJFWIPXB',1))) {
_SignErr('UXGJFWIPXB');
m_cLastWorkVarErrorMsg='11720460891';
l_bResult=false;
w_FDC1ACGIO='N';
} else if ( ! (_ChkObl('TKEHQQFQUC',1))) {
_SignErr('TKEHQQFQUC');
m_cLastWorkVarErrorMsg='1260570458';
l_bResult=false;
w_FDC2ACGIO='N';
} else if ( ! (_ChkObl('XBPDZFAWFR',1))) {
_SignErr('XBPDZFAWFR');
m_cLastWorkVarErrorMsg='11921223220';
l_bResult=false;
w_FDC3ACGIO='N';
} else if ( ! (_ChkObl('ZJMEDHEECW',1))) {
_SignErr('ZJMEDHEECW');
m_cLastWorkVarErrorMsg='11921223220';
l_bResult=false;
w_FDC4ACGIO='N';
} else if ( ! (_ChkObl('TOJFZPDKWJ',1))) {
_SignErr('TOJFZPDKWJ');
m_cLastWorkVarErrorMsg='11921223220';
l_bResult=false;
w_FDC5ACGIO='N';
} else if ( ! (_ChkObl('UXAYRLQXMN',1))) {
_SignErr('UXAYRLQXMN');
m_cLastWorkVarErrorMsg='11921223220';
l_bResult=false;
w_FDC6ACGIO='N';
} else if ( ! (_ChkObl('MXUUACEBJE',1))) {
_SignErr('MXUUACEBJE');
m_cLastWorkVarErrorMsg='10615149648';
l_bResult=false;
w_NCOPAGGIO=HtW('','N');
} else if ( ! (_ChkObl('LTMWIPFDRU',1))) {
_SignErr('LTMWIPFDRU');
m_cLastWorkVarErrorMsg='10027039931';
l_bResult=false;
w_FLTIPGIO=HtW('','C');
} else if ( ! (_ChkObl('RVLRRQTSCQ',1))) {
_SignErr('RVLRRQTSCQ');
m_cLastWorkVarErrorMsg='776969894';
l_bResult=false;
w_FLGATTIVO='N';
} else if ((Eq(w_FLGMLGIO,'S')) && ( ! (_ChkObl('UFVFYVMNVG',1)))) {
_SignErr('UFVFYVMNVG');
m_cLastWorkVarErrorMsg='11052594431';
l_bResult=false;
w_IMPMINGIO=HtW('','N');
} else if ((Eq(w_FLGMLGIO,'S')) && ( ! (_ChkObl('UVKSMYBGBT',1)))) {
_SignErr('UVKSMYBGBT');
m_cLastWorkVarErrorMsg='12075327151';
l_bResult=false;
w_IMPMINTOT=HtW('','N');
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
l_oWv.setValue('CODTPGIO',WtA(w_CODTPGIO,'C'));
l_oWv.setValue('DESTPGIO',WtA(w_DESTPGIO,'C'));
l_oWv.setValue('SOGTPGIO',WtA(w_SOGTPGIO,'N'));
l_oWv.setValue('EDTTPGIO',WtA(w_EDTTPGIO,'C'));
l_oWv.setValue('DEFTPGIO',WtA(w_DEFTPGIO,'C'));
l_oWv.setValue('EDTSPGIO',WtA(w_EDTSPGIO,'C'));
l_oWv.setValue('DEFSPGIO',WtA(w_DEFSPGIO,'C'));
l_oWv.setValue('FLGPLGIO',WtA(w_FLGPLGIO,'C'));
l_oWv.setValue('FLGMLGIO',WtA(w_FLGMLGIO,'C'));
l_oWv.setValue('MAGPAGGIO',WtA(w_MAGPAGGIO,'N'));
l_oWv.setValue('MINPAGGIO',WtA(w_MINPAGGIO,'N'));
l_oWv.setValue('FDC1OSGIO',WtA(w_FDC1OSGIO,'C'));
l_oWv.setValue('FDC2OSGIO',WtA(w_FDC2OSGIO,'C'));
l_oWv.setValue('FDC3OSGIO',WtA(w_FDC3OSGIO,'C'));
l_oWv.setValue('FDC4OSGIO',WtA(w_FDC4OSGIO,'C'));
l_oWv.setValue('FDC5OSGIO',WtA(w_FDC5OSGIO,'C'));
l_oWv.setValue('FDC6OSGIO',WtA(w_FDC6OSGIO,'C'));
l_oWv.setValue('FDC1SSGIO',WtA(w_FDC1SSGIO,'C'));
l_oWv.setValue('FDC2SSGIO',WtA(w_FDC2SSGIO,'C'));
l_oWv.setValue('FDC3SSGIO',WtA(w_FDC3SSGIO,'C'));
l_oWv.setValue('FDC4SSGIO',WtA(w_FDC4SSGIO,'C'));
l_oWv.setValue('FDC5SSGIO',WtA(w_FDC5SSGIO,'C'));
l_oWv.setValue('FDC6SSGIO',WtA(w_FDC6SSGIO,'C'));
l_oWv.setValue('FDC1ACGIO',WtA(w_FDC1ACGIO,'C'));
l_oWv.setValue('FDC2ACGIO',WtA(w_FDC2ACGIO,'C'));
l_oWv.setValue('FDC3ACGIO',WtA(w_FDC3ACGIO,'C'));
l_oWv.setValue('FDC4ACGIO',WtA(w_FDC4ACGIO,'C'));
l_oWv.setValue('FDC5ACGIO',WtA(w_FDC5ACGIO,'C'));
l_oWv.setValue('FDC6ACGIO',WtA(w_FDC6ACGIO,'C'));
l_oWv.setValue('NCOPAGGIO',WtA(w_NCOPAGGIO,'N'));
l_oWv.setValue('FLTIPGIO',WtA(w_FLTIPGIO,'C'));
l_oWv.setValue('FLGATTIVO',WtA(w_FLGATTIVO,'C'));
l_oWv.setValue('IMPMINGIO',WtA(w_IMPMINGIO,'N'));
l_oWv.setValue('IMPMINTOT',WtA(w_IMPMINTOT,'N'));
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
_FillChildren.n=['ardt_cgo_tgtiporeg'];
FillWv.n=["CODTPGIO","DESTPGIO","SOGTPGIO","EDTTPGIO","DEFTPGIO","EDTSPGIO","DEFSPGIO","FLGPLGIO","FLGMLGIO","MAGPAGGIO","MINPAGGIO","FDC1OSGIO","FDC2OSGIO","FDC3OSGIO","FDC4OSGIO","FDC5OSGIO","FDC6OSGIO","FDC1SSGIO","FDC2SSGIO","FDC3SSGIO","FDC4SSGIO","FDC5SSGIO","FDC6SSGIO","FDC1ACGIO","FDC2ACGIO","FDC3ACGIO","FDC4ACGIO","FDC5ACGIO","FDC6ACGIO","NCOPAGGIO","FLTIPGIO","FLGATTIVO","IMPMINGIO","IMPMINTOT"];
function SetModified() {
m_bUpdated=true;
}
function SetChildVariables_ardt_cgo_tgtiporeg() {
}
function CtxLoad_ardt_cgo_tgtiporeg() {
if (ChildToLoad(FrameRef('ardt_cgo_tgtiporeg'))) {
return [LoadContext(0,'EKQWOMODBX'),'ardt_cgo_tgtiporeg'];
}
}
