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
l_bEnabled= ! (Eq(w_TIPOPERS,'P')) || IsDisabledByStateDriver('COGNOME');
SetDisabled('TWTTDWKCRG',l_bEnabled);
l_bEnabled= ! (Eq(w_TIPOPERS,'P')) || IsDisabledByStateDriver('NOME');
SetDisabled('WWGIVGNUDW',l_bEnabled);
l_bEnabled= ! (Eq(w_TIPOPERS,'P')) || IsDisabledByStateDriver('NASCOMUN');
SetDisabled('NEUBQNUEOJ',l_bEnabled);
SetDisabled(Ctrl('NEUBQNUEOJ_ZOOM'),l_bEnabled);
l_bEnabled= ! (Eq(w_TIPOPERS,'P')) || IsDisabledByStateDriver('TIPINTER');
SetDisabled('KPSCOABZLB',l_bEnabled);
l_bEnabled= ! (Eq(w_TIPOPERS,'P')) || IsDisabledByStateDriver('SESSO');
SetDisabled('QPALJZMFCL',l_bEnabled);
l_bEnabled= ! (Eq(w_TIPOPERS,'P')) || IsDisabledByStateDriver('NASSTATO');
SetDisabled('HODZKKOSYW',l_bEnabled);
SetDisabled(Ctrl('HODZKKOSYW_ZOOM'),l_bEnabled);
l_bEnabled= ! (Eq(w_TIPOPERS,'P')) || IsDisabledByStateDriver('DATANASC');
SetDisabled('XMGRWGFSFV',l_bEnabled);
SetDisabled(Ctrl('XMGRWGFSFV_ZOOM'),l_bEnabled);
l_bEnabled= ! (Eq(w_TIPOPERS,'P')) || IsDisabledByStateDriver('TIPODOC');
SetDisabled('MBGANUUHRA',l_bEnabled);
l_bEnabled= ! (Eq(w_TIPOPERS,'P')) || IsDisabledByStateDriver('NUMDOCUM');
SetDisabled('HVEEMUJUUY',l_bEnabled);
l_bEnabled= ! (Eq(w_TIPOPERS,'P')) || IsDisabledByStateDriver('DATARILASC');
SetDisabled('XHWYGOPPUN',l_bEnabled);
SetDisabled(Ctrl('XHWYGOPPUN_ZOOM'),l_bEnabled);
l_bEnabled= ! (Eq(w_TIPOPERS,'P')) || IsDisabledByStateDriver('DATAVALI');
SetDisabled('BNWXBPSIDG',l_bEnabled);
SetDisabled(Ctrl('BNWXBPSIDG_ZOOM'),l_bEnabled);
l_bEnabled= ! (Eq(w_TIPOPERS,'P')) || IsDisabledByStateDriver('AUTRILASC');
SetDisabled('HRNCPADUFU',l_bEnabled);
l_bEnabled= ! (Eq(w_TIPOPERS,'G')) || IsDisabledByStateDriver('PARTIVA');
SetDisabled('FHXWUTBNKI',l_bEnabled);
l_bEnabled= ! (Ne(w_tipsot,'0') && Ne(w_tipsot,'2')) || IsDisabledByStateDriver('RAMOGRUP');
SetDisabled('RVNHQCXNEM',l_bEnabled);
SetDisabled(Ctrl('RVNHQCXNEM_ZOOM'),l_bEnabled);
if (IsDisabledByStateDriver('box_AQSQVBKXAL')) {
DisableInputsInContainer(Ctrl('AQSQVBKXAL'),true);
}
if (IsDisabledByStateDriver('PF')) {
DisableInputsInContainer(Ctrl('EWPTTWSBMT'),true);
}
if (IsDisabledByStateDriver('box_OQFTKYDCIW')) {
DisableInputsInContainer(Ctrl('OQFTKYDCIW'),true);
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
function Set_TIPOPERS(ctrlValue,kmode,e) {
if (Ne(w_TIPOPERS,ctrlValue)) {
var ctl = _GetCtl(e,'UYWIEUHCAL');
if (_tracker.goon(ctl,ctrlValue)) {
w_TIPOPERS=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UYWIEUHCAL',0);
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
function Set_COGNOME(ctrlValue,kmode,e) {
if (Ne(w_COGNOME,ctrlValue)) {
var ctl = _GetCtl(e,'TWTTDWKCRG');
if (_tracker.goon(ctl,ctrlValue)) {
w_COGNOME=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('TWTTDWKCRG',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('TWTTDWKCRG',function(){return WtH(w_COGNOME,'C',26,0,'@!')},w_COGNOME);
return l_bResult;
} else {
ctl.value=WtH('','C',26,0,'@!');
_ResetTracker();
return true;
}
}
return true;
}
function Set_NOME(ctrlValue,kmode,e) {
if (Ne(w_NOME,ctrlValue)) {
var ctl = _GetCtl(e,'WWGIVGNUDW');
if (_tracker.goon(ctl,ctrlValue)) {
w_NOME=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('WWGIVGNUDW',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('WWGIVGNUDW',function(){return WtH(w_NOME,'C',25,0,'@!')},w_NOME);
return l_bResult;
} else {
ctl.value=WtH('','C',25,0,'@!');
_ResetTracker();
return true;
}
}
return true;
}
function Set_CFESTERO(ctrlValue,kmode,e) {
if (Ne(w_CFESTERO,ctrlValue)) {
var ctl = _GetCtl(e,'CZTHKEDVCO');
if (_tracker.goon(ctl,ctrlValue)) {
w_CFESTERO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CZTHKEDVCO',0);
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
function Set_RAGSOC(ctrlValue,kmode,e) {
if (Ne(w_RAGSOC,ctrlValue)) {
var ctl = _GetCtl(e,'AWPNTOJIRR');
if (_tracker.goon(ctl,ctrlValue)) {
w_RAGSOC=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('AWPNTOJIRR',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('AWPNTOJIRR',function(){return WtH(w_RAGSOC,'C',70,0,'@!')},w_RAGSOC);
return l_bResult;
} else {
ctl.value=WtH('','C',70,0,'@!');
_ResetTracker();
return true;
}
}
return true;
}
function Set_PAESE(ctrlValue,kmode,e) {
if (Ne(w_PAESE,ctrlValue)) {
var ctl = _GetCtl(e,'YVIKEGPYPM');
if (_tracker.goon(ctl,ctrlValue)) {
w_PAESE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YVIKEGPYPM',0);
if (l_bResult) {
l_bResult=Link_YVIKEGPYPM(kmode);
if ( ! (Empty(w_DESCCIT))) {
Link_ODAYKSRECA(kmode);
}
if ( ! (l_bResult)) {
w_PAESE=HtW('','C');
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
function Set_DESCCIT(ctrlValue,kmode,e) {
if (Ne(w_DESCCIT,ctrlValue)) {
var ctl = _GetCtl(e,'ODAYKSRECA');
if (_tracker.goon(ctl,ctrlValue)) {
w_DESCCIT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ODAYKSRECA',0);
if (l_bResult) {
l_bResult=Link_ODAYKSRECA(kmode);
if ( ! (l_bResult)) {
w_DESCCIT=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',40,0,'@!'));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',40,0,'@!');
_ResetTracker();
return true;
}
}
return true;
}
function Set_PROVINCIA(ctrlValue,kmode,e) {
if (Ne(w_PROVINCIA,ctrlValue)) {
var ctl = _GetCtl(e,'NOTZPDMYIA');
if (_tracker.goon(ctl,ctrlValue)) {
w_PROVINCIA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NOTZPDMYIA',0);
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
function Set_DATAVALI(ctrlValue,kmode,e) {
if (Ne(w_DATAVALI,ctrlValue)) {
var ctl = _GetCtl(e,'BNWXBPSIDG');
if (_tracker.goon(ctl,ctrlValue)) {
w_DATAVALI=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BNWXBPSIDG',0);
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
function Set_CAP(ctrlValue,kmode,e) {
if (Ne(w_CAP,ctrlValue)) {
var ctl = _GetCtl(e,'RDAVOEETJG');
if (_tracker.goon(ctl,ctrlValue)) {
w_CAP=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RDAVOEETJG',0);
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
function Set_CODCAB(ctrlValue,kmode,e) {
if (Ne(w_CODCAB,ctrlValue)) {
var ctl = _GetCtl(e,'BOTAJBWHHY');
if (_tracker.goon(ctl,ctrlValue)) {
w_CODCAB=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BOTAJBWHHY',0);
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
function Set_DOMICILIO(ctrlValue,kmode,e) {
if (Ne(w_DOMICILIO,ctrlValue)) {
var ctl = _GetCtl(e,'VYLHWTRQNX');
if (_tracker.goon(ctl,ctrlValue)) {
w_DOMICILIO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VYLHWTRQNX',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',35,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_NASCOMUN(ctrlValue,kmode,e) {
if (Ne(w_NASCOMUN,ctrlValue)) {
var ctl = _GetCtl(e,'NEUBQNUEOJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_NASCOMUN=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NEUBQNUEOJ',0);
if (l_bResult) {
l_bResult=Link_NEUBQNUEOJ(kmode);
if ( ! (l_bResult)) {
w_NASCOMUN=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',30,0,'@!'));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',30,0,'@!');
_ResetTracker();
return true;
}
}
return true;
}
function Set_TIPINTER(ctrlValue,kmode,e) {
if (Ne(w_TIPINTER,ctrlValue)) {
var ctl = _GetCtl(e,'KPSCOABZLB');
if (_tracker.goon(ctl,ctrlValue)) {
w_TIPINTER=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('KPSCOABZLB',0);
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
function Set_SESSO(ctrlValue,kmode,e) {
if (Ne(w_SESSO,ctrlValue)) {
var ctl = _GetCtl(e,'QPALJZMFCL');
if (_tracker.goon(ctl,ctrlValue)) {
w_SESSO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QPALJZMFCL',0);
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
function Set_NASSTATO(ctrlValue,kmode,e) {
if (Ne(w_NASSTATO,ctrlValue)) {
var ctl = _GetCtl(e,'HODZKKOSYW');
if (_tracker.goon(ctl,ctrlValue)) {
w_NASSTATO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HODZKKOSYW',0);
if (l_bResult) {
l_bResult=Link_HODZKKOSYW(kmode);
if ( ! (l_bResult)) {
w_NASSTATO=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',30,0,'@!'));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',30,0,'@!');
_ResetTracker();
return true;
}
}
return true;
}
function Set_DATANASC(ctrlValue,kmode,e) {
if (Ne(w_DATANASC,ctrlValue)) {
var ctl = _GetCtl(e,'XMGRWGFSFV');
if (_tracker.goon(ctl,ctrlValue)) {
w_DATANASC=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
var l_bWarn = true;
l_bResult=_ChkObl('XMGRWGFSFV',0);
if (l_bResult) {
if (l_bResult && ( ! (Lt(w_DATANASC,SystemDate())) && Ne(m_nLastError,-2))) {
try {
_tracker.askwrn=true;
l_bWarn=WindowConfirm(AlertErrorMessage('1986602634'));
} finally {
_tracker.askwrn=false;
}
}
if ( ! (l_bResult) ||  ! (l_bWarn)) {
w_DATANASC=HtW('','D');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult) ||  ! (l_bWarn)) {
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
function Set_TIPODOC(ctrlValue,kmode,e) {
if (Ne(w_TIPODOC,ctrlValue)) {
var ctl = _GetCtl(e,'MBGANUUHRA');
if (_tracker.goon(ctl,ctrlValue)) {
w_TIPODOC=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MBGANUUHRA',0);
if (l_bResult) {
l_bResult=Link_MBGANUUHRA(kmode);
if ( ! (l_bResult)) {
w_TIPODOC=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',2,0,''));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',2,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_NUMDOCUM(ctrlValue,kmode,e) {
if (Ne(w_NUMDOCUM,ctrlValue)) {
var ctl = _GetCtl(e,'HVEEMUJUUY');
if (_tracker.goon(ctl,ctrlValue)) {
w_NUMDOCUM=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HVEEMUJUUY',0);
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
function Set_DATARILASC(ctrlValue,kmode,e) {
if (Ne(w_DATARILASC,ctrlValue)) {
var ctl = _GetCtl(e,'XHWYGOPPUN');
if (_tracker.goon(ctl,ctrlValue)) {
w_DATARILASC=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
var l_bWarn = true;
l_bResult=_ChkObl('XHWYGOPPUN',0);
if (l_bResult) {
if (l_bResult && ( ! (Lt(w_DATAVALI,SystemDate())) && Ne(m_nLastError,-2))) {
try {
_tracker.askwrn=true;
l_bWarn=WindowConfirm(AlertErrorMessage('10099240010'));
} finally {
_tracker.askwrn=false;
}
}
if ( ! (l_bResult) ||  ! (l_bWarn)) {
w_DATARILASC=HtW('','D');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult) ||  ! (l_bWarn)) {
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
function Set_RAMOGRUP(ctrlValue,kmode,e) {
if (Ne(w_RAMOGRUP,ctrlValue)) {
var ctl = _GetCtl(e,'RVNHQCXNEM');
if (_tracker.goon(ctl,ctrlValue)) {
w_RAMOGRUP=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RVNHQCXNEM',0);
if (l_bResult) {
l_bResult=Link_RVNHQCXNEM(kmode);
if ( ! (l_bResult)) {
w_RAMOGRUP=HtW('','C');
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
function Set_AUTRILASC(ctrlValue,kmode,e) {
if (Ne(w_AUTRILASC,ctrlValue)) {
var ctl = _GetCtl(e,'HRNCPADUFU');
if (_tracker.goon(ctl,ctrlValue)) {
w_AUTRILASC=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HRNCPADUFU',0);
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
function Set_CODFISC(ctrlValue,kmode,e) {
if (Ne(w_CODFISC,ctrlValue)) {
var ctl = _GetCtl(e,'OJJHIUDPFY');
if (_tracker.goon(ctl,ctrlValue)) {
w_CODFISC=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('OJJHIUDPFY',0);
if (l_bResult) {
l_bResult=arfn_chkcodfis(w_CODFISC,w_PAESE,w_CFESTERO);
if ( ! (l_bResult)) {
m_nLastError=2;
m_cLastWorkVarErrorMsg='11921223220';
m_cLastMsgError=AlertErrorMessage('10034398626');
}
if ( ! (l_bResult)) {
w_CODFISC=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',16,0,''));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',16,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_PARTIVA(ctrlValue,kmode,e) {
if (Ne(w_PARTIVA,ctrlValue)) {
var ctl = _GetCtl(e,'FHXWUTBNKI');
if (_tracker.goon(ctl,ctrlValue)) {
w_PARTIVA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FHXWUTBNKI',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',14,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_SOTGRUP(ctrlValue,kmode,e) {
if (Ne(w_SOTGRUP,ctrlValue)) {
var ctl = _GetCtl(e,'LLYIGAMXRH');
if (_tracker.goon(ctl,ctrlValue)) {
w_SOTGRUP=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('LLYIGAMXRH',0);
if (l_bResult) {
l_bResult=Link_LLYIGAMXRH(kmode);
if ( ! (l_bResult)) {
w_SOTGRUP=HtW('','C');
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
function Set_CONNES(ctrlValue,kmode,e) {
if (Ne(w_CONNES,ctrlValue)) {
var ctl = _GetCtl(e,'YTPWDRMFUS');
if (_tracker.goon(ctl,ctrlValue)) {
w_CONNES=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YTPWDRMFUS',0);
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
function Set_SETTSINT(ctrlValue,kmode,e) {
if (Ne(w_SETTSINT,ctrlValue)) {
var ctl = _GetCtl(e,'ZGNLLSFQHC');
if (_tracker.goon(ctl,ctrlValue)) {
w_SETTSINT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ZGNLLSFQHC',0);
if (l_bResult) {
l_bResult=Link_ZGNLLSFQHC(kmode);
if ( ! (l_bResult)) {
w_SETTSINT=HtW('','C');
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
function Set_ATTIV(ctrlValue,kmode,e) {
if (Ne(w_ATTIV,ctrlValue)) {
var ctl = _GetCtl(e,'SAQTIHOALW');
if (_tracker.goon(ctl,ctrlValue)) {
w_ATTIV=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NOBMPHKVTX',0);
if (l_bResult) {
if ( ! (l_bResult)) {
w_ATTIV=HtW('','C');
}
}
l_bResult=l_bResult && _ChkObl('SAQTIHOALW',0);
if (l_bResult) {
l_bResult=Link_SAQTIHOALW(kmode);
if ( ! (l_bResult)) {
w_ATTIV=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',10,0,''));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',10,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_PEP(ctrlValue,kmode,e) {
if (Ne(w_PEP,ctrlValue)) {
var ctl = _GetCtl(e,'XFKXBQYUIU');
if (_tracker.goon(ctl,ctrlValue)) {
w_PEP=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XFKXBQYUIU',0);
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
if ((Ne(o_DESCCIT,w_DESCCIT)) || (Ne(o_idcitta,w_idcitta))) {
l_bTmpRes=Link_YVIKEGPYPM(null);
}
if ((Ne(o_idcitta,w_idcitta))) {
l_bTmpRes=Link_TYEDHRZCMA(null);
}
if ((Ne(o_SOTGRUP,w_SOTGRUP))) {
l_bTmpRes=Link_ZGNLLSFQHC(null);
}
UpdateAutonumber('PROGIMPORT');
if ((Ne(o_AREAGEO,w_AREAGEO))) {
l_bTmpRes=Link_QJSTZIPOQB(null);
}
if ((Ne(o_PKTBSPECIE,w_PKTBSPECIE))) {
l_bTmpRes=Link_SFFFOYOWNH(null);
}
if ((Ne(o_ATTIV,w_ATTIV))) {
l_bTmpRes=Link_NOBMPHKVTX(null);
}
if ((Ne(o_COMPORT,w_COMPORT))) {
l_bTmpRes=Link_DJOWYRMDDC(null);
}
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
o_DESCCIT=w_DESCCIT;
o_idcitta=w_idcitta;
o_SOTGRUP=w_SOTGRUP;
o_AREAGEO=w_AREAGEO;
o_PKTBSPECIE=w_PKTBSPECIE;
o_ATTIV=w_ATTIV;
o_COMPORT=w_COMPORT;
}
function SaveLabelDependsOn() {
}
function Link_YVIKEGPYPM(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_PAESE);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODSTA',w_PAESE,3,0);
l_Appl.SetFields('CODSTA,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbstati');
l_Appl.SetID('YVIKEGPYPM');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_PAESE=l_Appl.GetStringValue('CODSTA',3,0);
w_dessta=l_Appl.GetStringValue('DESCRI',30,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_YVIKEGPYPM_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_YVIKEGPYPM';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_YVIKEGPYPM();
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
function Link_YVIKEGPYPM_Blank() {
w_PAESE='';
w_dessta='';
}
function LOpt_YVIKEGPYPM() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstati','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODSTA','C'));
l_oWv.setValue('LinkedField',WtA('CODSTA','C'));
l_oWv.setValue('UID',WtA('YVIKEGPYPM','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['YVIKEGPYPM'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('7383187'),'C'));
return l_oWv;
}
function Link_ODAYKSRECA(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_DESCCIT);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('PKTBSTATI',w_PAESE,3,0);
l_Appl.SetStringKey('CITTA',w_DESCCIT,40,0);
l_Appl.SetFields('CITTA,IDBASE');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbcitta');
l_Appl.SetID('ODAYKSRECA');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_DESCCIT=l_Appl.GetStringValue('CITTA',40,0);
w_idcitta=l_Appl.GetStringValue('IDBASE',10,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_ODAYKSRECA_Blank();
l_bResult=true;
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_ODAYKSRECA';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_ODAYKSRECA();
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
function Link_ODAYKSRECA_Blank() {
w_idcitta='';
}
function LOpt_ODAYKSRECA() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcitta','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('PKTBSTATI,CITTA','C'));
l_oWv.setValue('LinkedField',WtA('CITTA','C'));
l_oWv.setValue('UID',WtA('ODAYKSRECA','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['ODAYKSRECA'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('15186643'),'C'));
return l_oWv;
}
function Link_TYEDHRZCMA(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_idcitta);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('IDBASE',w_idcitta,10,0);
l_Appl.SetFields('IDBASE,CAB,PROV,CAP');
l_Appl.SetTypes('C,C,C,C');
l_Appl.LinkTable('tbcitta');
l_Appl.SetID('TYEDHRZCMA');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_idcitta=l_Appl.GetStringValue('IDBASE',10,0);
w_CODCAB=l_Appl.GetStringValue('CAB',6,0);
w_PROVINCIA=l_Appl.GetStringValue('PROV',2,0);
w_CAP=l_Appl.GetStringValue('CAP',9,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_TYEDHRZCMA_Blank();
}
if ( ! (l_bResult)) {
m_nLastError=3;
m_cLastWorkVarErrorMsg='';
if (Lt(l_nRec,0)) {
m_cLastMsgError=Translate('MSG_CONNECT_SERVER');
}
}
return l_bResult;
}
function Link_TYEDHRZCMA_Blank() {
w_idcitta='';
w_CODCAB='';
w_PROVINCIA='';
w_CAP='';
}
function LOpt_TYEDHRZCMA() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcitta','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('IDBASE','C'));
l_oWv.setValue('LinkedField',WtA('IDBASE','C'));
l_oWv.setValue('UID',WtA('TYEDHRZCMA','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['TYEDHRZCMA'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('117818419'),'C'));
return l_oWv;
}
function Link_NEUBQNUEOJ(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_NASCOMUN);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CITTA',w_NASCOMUN,30,0);
l_Appl.SetFields('CITTA,PROV');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbcitta');
l_Appl.SetID('NEUBQNUEOJ');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_NASCOMUN=l_Appl.GetStringValue('CITTA',30,0);
w_TIPINTER=l_Appl.GetStringValue('PROV',2,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_NEUBQNUEOJ_Blank();
l_bResult=true;
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_NEUBQNUEOJ';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_NEUBQNUEOJ();
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
function Link_NEUBQNUEOJ_Blank() {
w_TIPINTER='';
}
function LOpt_NEUBQNUEOJ() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcitta','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CITTA','C'));
l_oWv.setValue('LinkedField',WtA('CITTA','C'));
l_oWv.setValue('UID',WtA('NEUBQNUEOJ','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['NEUBQNUEOJ'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('15186643'),'C'));
return l_oWv;
}
function Link_HODZKKOSYW(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_NASSTATO);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('DESCRI',w_NASSTATO,30,0);
l_Appl.SetFields('DESCRI');
l_Appl.SetTypes('C');
l_Appl.LinkTable('tbstati');
l_Appl.SetID('HODZKKOSYW');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_NASSTATO=l_Appl.GetStringValue('DESCRI',30,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_HODZKKOSYW_Blank();
l_bResult=true;
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_HODZKKOSYW';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_HODZKKOSYW();
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
function Link_HODZKKOSYW_Blank() {
}
function LOpt_HODZKKOSYW() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstati','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('DESCRI','C'));
l_oWv.setValue('LinkedField',WtA('DESCRI','C'));
l_oWv.setValue('UID',WtA('HODZKKOSYW','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['HODZKKOSYW'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('7383187'),'C'));
return l_oWv;
}
function Link_MBGANUUHRA(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_TIPODOC);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('TIPDOC',w_TIPODOC,2,0);
l_Appl.SetFields('TIPDOC,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbtipdoc');
l_Appl.SetID('MBGANUUHRA');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_TIPODOC=l_Appl.GetStringValue('TIPDOC',2,0);
w_DESCRI=l_Appl.GetStringValue('DESCRI',30,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_MBGANUUHRA_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_MBGANUUHRA';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_MBGANUUHRA();
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
function Link_MBGANUUHRA_Blank() {
w_TIPODOC='';
w_DESCRI='';
}
function LOpt_MBGANUUHRA() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbtipdoc','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('TIPDOC','C'));
l_oWv.setValue('LinkedField',WtA('TIPDOC','C'));
l_oWv.setValue('UID',WtA('MBGANUUHRA','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['MBGANUUHRA'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('11429032151'),'C'));
return l_oWv;
}
function Link_LLYIGAMXRH(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_SOTGRUP);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('SOTGRU',w_SOTGRUP,3,0);
l_Appl.SetFields('SOTGRU,DESCRI,TIPOSOT');
l_Appl.SetTypes('C,C,C');
l_Appl.LinkTable('tbstgru');
l_Appl.SetID('LLYIGAMXRH');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_SOTGRUP=l_Appl.GetStringValue('SOTGRU',3,0);
w_DESCSGRU=l_Appl.GetStringValue('DESCRI',60,0);
w_tipsot=l_Appl.GetStringValue('TIPOSOT',1,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_LLYIGAMXRH_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_LLYIGAMXRH';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_LLYIGAMXRH();
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
function Link_LLYIGAMXRH_Blank() {
w_SOTGRUP='';
w_DESCSGRU='';
w_tipsot='';
}
function LOpt_LLYIGAMXRH() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstgru','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('SOTGRU','C'));
l_oWv.setValue('LinkedField',WtA('SOTGRU','C'));
l_oWv.setValue('UID',WtA('LLYIGAMXRH','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['LLYIGAMXRH'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('684715782'),'C'));
return l_oWv;
}
function Link_RVNHQCXNEM(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_RAMOGRUP);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('RAMGRU',w_RAMOGRUP,3,0);
l_Appl.SetFields('RAMGRU,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbramgru');
l_Appl.SetID('RVNHQCXNEM');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_RAMOGRUP=l_Appl.GetStringValue('RAMGRU',3,0);
w_DESCRAMGRU=l_Appl.GetStringValue('DESCRI',70,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_RVNHQCXNEM_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_RVNHQCXNEM';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_RVNHQCXNEM();
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
function Link_RVNHQCXNEM_Blank() {
w_RAMOGRUP='';
w_DESCRAMGRU='';
}
function LOpt_RVNHQCXNEM() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbramgru','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('RAMGRU','C'));
l_oWv.setValue('LinkedField',WtA('RAMGRU','C'));
l_oWv.setValue('UID',WtA('RVNHQCXNEM','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['RVNHQCXNEM'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('130605954'),'C'));
return l_oWv;
}
function Link_ZGNLLSFQHC(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_SETTSINT);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('SETSINT',w_SETTSINT,3,0);
l_Appl.SetFields('SETSINT,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbsetsin');
l_Appl.SetID('ZGNLLSFQHC');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_SETTSINT=l_Appl.GetStringValue('SETSINT',3,0);
w_DESCUIC=l_Appl.GetStringValue('DESCRI',60,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_ZGNLLSFQHC_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_ZGNLLSFQHC';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_ZGNLLSFQHC();
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
function Link_ZGNLLSFQHC_Blank() {
w_SETTSINT='';
w_DESCUIC='';
}
function LOpt_ZGNLLSFQHC() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbsetsin','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('SETSINT','C'));
l_oWv.setValue('LinkedField',WtA('SETSINT','C'));
l_oWv.setValue('UID',WtA('ZGNLLSFQHC','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['ZGNLLSFQHC'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('1293397814'),'C'));
return l_oWv;
}
function Link_QJSTZIPOQB(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_AREAGEO);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODICE',w_AREAGEO,5,0);
l_Appl.SetFields('CODICE,DESCRI,RISCHIO');
l_Appl.SetTypes('C,C,N');
l_Appl.LinkTable('tbareegeog');
l_Appl.SetID('QJSTZIPOQB');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_AREAGEO=l_Appl.GetStringValue('CODICE',5,0);
w_xdescareag=l_Appl.GetStringValue('DESCRI',50,0);
w_RAREA=l_Appl.GetDoubleValue('RISCHIO',3,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_QJSTZIPOQB_Blank();
}
if ( ! (l_bResult)) {
m_nLastError=3;
m_cLastWorkVarErrorMsg='';
if (Lt(l_nRec,0)) {
m_cLastMsgError=Translate('MSG_CONNECT_SERVER');
}
}
return l_bResult;
}
function Link_QJSTZIPOQB_Blank() {
w_AREAGEO='';
w_xdescareag='';
w_RAREA=0;
}
function LOpt_QJSTZIPOQB() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbareegeog','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODICE','C'));
l_oWv.setValue('LinkedField',WtA('CODICE','C'));
l_oWv.setValue('UID',WtA('QJSTZIPOQB','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['QJSTZIPOQB'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('11053408024'),'C'));
return l_oWv;
}
function Link_SFFFOYOWNH(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_PKTBSPECIE);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODSPE',w_PKTBSPECIE,4,0);
l_Appl.SetFields('CODSPE,DESCRI,RISCHIO');
l_Appl.SetTypes('C,C,N');
l_Appl.LinkTable('tbspecie');
l_Appl.SetLinkzoom('armt_tbspecie');
l_Appl.SetID('SFFFOYOWNH');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_PKTBSPECIE=l_Appl.GetStringValue('CODSPE',4,0);
w_xdescnatgiu=l_Appl.GetStringValue('DESCRI',60,0);
w_RNATGIU=l_Appl.GetDoubleValue('RISCHIO',3,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_SFFFOYOWNH_Blank();
}
if ( ! (l_bResult)) {
m_nLastError=3;
m_cLastWorkVarErrorMsg='';
if (Lt(l_nRec,0)) {
m_cLastMsgError=Translate('MSG_CONNECT_SERVER');
}
}
return l_bResult;
}
function Link_SFFFOYOWNH_Blank() {
w_PKTBSPECIE='';
w_xdescnatgiu='';
w_RNATGIU=0;
}
function LOpt_SFFFOYOWNH() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbspecie','C'));
l_oWv.setValue('Linkzoomprg',WtA('armt_tbspecie','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODSPE','C'));
l_oWv.setValue('LinkedField',WtA('CODSPE','C'));
l_oWv.setValue('UID',WtA('SFFFOYOWNH','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['SFFFOYOWNH'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('11158852142'),'C'));
return l_oWv;
}
function Link_NOBMPHKVTX(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_ATTIV);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODICE',w_ATTIV,10,0);
l_Appl.SetFields('CODICE,DESCRI,RISCHIO');
l_Appl.SetTypes('C,C,N');
l_Appl.LinkTable('tbtipatt');
l_Appl.SetLinkzoom('armt_tbtipatt');
l_Appl.SetID('NOBMPHKVTX');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_ATTIV=l_Appl.GetStringValue('CODICE',10,0);
w_xdesctipatt=l_Appl.GetStringValue('DESCRI',250,0);
w_RATTIV=l_Appl.GetDoubleValue('RISCHIO',3,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_NOBMPHKVTX_Blank();
}
if ( ! (l_bResult)) {
m_nLastError=3;
m_cLastWorkVarErrorMsg='';
if (Lt(l_nRec,0)) {
m_cLastMsgError=Translate('MSG_CONNECT_SERVER');
}
}
return l_bResult;
}
function Link_NOBMPHKVTX_Blank() {
w_ATTIV='';
w_xdesctipatt='';
w_RATTIV=0;
}
function LOpt_NOBMPHKVTX() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbtipatt','C'));
l_oWv.setValue('Linkzoomprg',WtA('armt_tbtipatt','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODICE','C'));
l_oWv.setValue('LinkedField',WtA('CODICE','C'));
l_oWv.setValue('UID',WtA('NOBMPHKVTX','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['NOBMPHKVTX'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('484567773'),'C'));
return l_oWv;
}
function Link_DJOWYRMDDC(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_COMPORT);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODICE',w_COMPORT,5,0);
l_Appl.SetFields('CODICE,DESCRI,RISCHIO');
l_Appl.SetTypes('C,C,N');
l_Appl.LinkTable('tbcondotta');
l_Appl.SetLinkzoom('armt_tbcondotta');
l_Appl.SetID('DJOWYRMDDC');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_COMPORT=l_Appl.GetStringValue('CODICE',5,0);
w_xdesccomp=l_Appl.GetStringValue('DESCRI',200,0);
w_RCOMP=l_Appl.GetDoubleValue('RISCHIO',3,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_DJOWYRMDDC_Blank();
}
if ( ! (l_bResult)) {
m_nLastError=3;
m_cLastWorkVarErrorMsg='';
if (Lt(l_nRec,0)) {
m_cLastMsgError=Translate('MSG_CONNECT_SERVER');
}
}
return l_bResult;
}
function Link_DJOWYRMDDC_Blank() {
w_COMPORT='';
w_xdesccomp='';
w_RCOMP=0;
}
function LOpt_DJOWYRMDDC() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcondotta','C'));
l_oWv.setValue('Linkzoomprg',WtA('armt_tbcondotta','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODICE','C'));
l_oWv.setValue('LinkedField',WtA('CODICE','C'));
l_oWv.setValue('UID',WtA('DJOWYRMDDC','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['DJOWYRMDDC'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('10049460300'),'C'));
return l_oWv;
}
function Link_SAQTIHOALW(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_ATTIV);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODICE',w_ATTIV,10,0);
l_Appl.SetFields('CODICE,DESCRI,RISCHIO');
l_Appl.SetTypes('C,C,N');
l_Appl.LinkTable('tbtipatt');
l_Appl.SetLinkzoom('armt_tbtipatt');
l_Appl.SetID('SAQTIHOALW');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_ATTIV=l_Appl.GetStringValue('CODICE',10,0);
w_xdesctipatt=l_Appl.GetStringValue('DESCRI',250,0);
w_RATTIV=l_Appl.GetDoubleValue('RISCHIO',3,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_SAQTIHOALW_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_SAQTIHOALW';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_SAQTIHOALW();
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
function Link_SAQTIHOALW_Blank() {
w_ATTIV='';
w_xdesctipatt='';
w_RATTIV=0;
}
function LOpt_SAQTIHOALW() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbtipatt','C'));
l_oWv.setValue('Linkzoomprg',WtA('armt_tbtipatt','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODICE','C'));
l_oWv.setValue('LinkedField',WtA('CODICE','C'));
l_oWv.setValue('UID',WtA('SAQTIHOALW','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['SAQTIHOALW'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('484567773'),'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'YVIKEGPYPM')) {
last_focused_comp=GetLastFocusedElementOfLink('YVIKEGPYPM');
function SetMethod_YVIKEGPYPM() {
Set_PAESE(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_YVIKEGPYPM();
} else {
setTimeout(SetMethod_YVIKEGPYPM,1);
}
bResult=true;
}
if (Eq(varName,'ODAYKSRECA')) {
last_focused_comp=GetLastFocusedElementOfLink('ODAYKSRECA');
function SetMethod_ODAYKSRECA() {
Set_DESCCIT(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_ODAYKSRECA();
} else {
setTimeout(SetMethod_ODAYKSRECA,1);
}
bResult=true;
}
if (Eq(varName,'NEUBQNUEOJ')) {
last_focused_comp=GetLastFocusedElementOfLink('NEUBQNUEOJ');
function SetMethod_NEUBQNUEOJ() {
Set_NASCOMUN(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_NEUBQNUEOJ();
} else {
setTimeout(SetMethod_NEUBQNUEOJ,1);
}
bResult=true;
}
if (Eq(varName,'HODZKKOSYW')) {
last_focused_comp=GetLastFocusedElementOfLink('HODZKKOSYW');
function SetMethod_HODZKKOSYW() {
Set_NASSTATO(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_HODZKKOSYW();
} else {
setTimeout(SetMethod_HODZKKOSYW,1);
}
bResult=true;
}
if (Eq(varName,'MBGANUUHRA')) {
last_focused_comp=GetLastFocusedElementOfLink('MBGANUUHRA');
function SetMethod_MBGANUUHRA() {
Set_TIPODOC(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_MBGANUUHRA();
} else {
setTimeout(SetMethod_MBGANUUHRA,1);
}
bResult=true;
}
if (Eq(varName,'LLYIGAMXRH')) {
last_focused_comp=GetLastFocusedElementOfLink('LLYIGAMXRH');
function SetMethod_LLYIGAMXRH() {
Set_SOTGRUP(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_LLYIGAMXRH();
} else {
setTimeout(SetMethod_LLYIGAMXRH,1);
}
bResult=true;
}
if (Eq(varName,'RVNHQCXNEM')) {
last_focused_comp=GetLastFocusedElementOfLink('RVNHQCXNEM');
function SetMethod_RVNHQCXNEM() {
Set_RAMOGRUP(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_RVNHQCXNEM();
} else {
setTimeout(SetMethod_RVNHQCXNEM,1);
}
bResult=true;
}
if (Eq(varName,'ZGNLLSFQHC')) {
last_focused_comp=GetLastFocusedElementOfLink('ZGNLLSFQHC');
function SetMethod_ZGNLLSFQHC() {
Set_SETTSINT(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_ZGNLLSFQHC();
} else {
setTimeout(SetMethod_ZGNLLSFQHC,1);
}
bResult=true;
}
if (Eq(varName,'SAQTIHOALW')) {
last_focused_comp=GetLastFocusedElementOfLink('SAQTIHOALW');
function SetMethod_SAQTIHOALW() {
Set_ATTIV(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_SAQTIHOALW();
} else {
setTimeout(SetMethod_SAQTIHOALW,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'YVIKEGPYPM')) {
return [Ctrl('YVIKEGPYPM')];
}
if (Eq(varName,'ODAYKSRECA')) {
return [Ctrl('ODAYKSRECA')];
}
if (Eq(varName,'NEUBQNUEOJ')) {
return [Ctrl('NEUBQNUEOJ')];
}
if (Eq(varName,'HODZKKOSYW')) {
return [Ctrl('HODZKKOSYW')];
}
if (Eq(varName,'MBGANUUHRA')) {
return [Ctrl('MBGANUUHRA')];
}
if (Eq(varName,'LLYIGAMXRH')) {
return [Ctrl('LLYIGAMXRH')];
}
if (Eq(varName,'RVNHQCXNEM')) {
return [Ctrl('RVNHQCXNEM')];
}
if (Eq(varName,'ZGNLLSFQHC')) {
return [Ctrl('ZGNLLSFQHC')];
}
if (Eq(varName,'SAQTIHOALW')) {
return [Ctrl('SAQTIHOALW')];
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
parent.ZtVWeb.raiseEventToEvalParms('armt_kersonbo_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('armt_kersonbo_dataNotSent',{'action':formaction});
}
}
}
}
CheckChild.child=[];
function Check() {
var l_bResult = true;
ResetErrorVars();
m_nLastError=0;
if ( ! (_ChkObl('UYWIEUHCAL',1))) {
_SignErr('UYWIEUHCAL');
m_cLastWorkVarErrorMsg='TIPOPERS';
l_bResult=false;
w_TIPOPERS=HtW('','C');
} else if ((Eq(w_TIPOPERS,'P')) && ( ! (_ChkObl('TWTTDWKCRG',1)))) {
_SignErr('TWTTDWKCRG');
m_cLastWorkVarErrorMsg='1816546867';
l_bResult=false;
w_COGNOME=HtW('','C');
} else if ((Eq(w_TIPOPERS,'P')) && ( ! (_ChkObl('WWGIVGNUDW',1)))) {
_SignErr('WWGIVGNUDW');
m_cLastWorkVarErrorMsg='443454';
l_bResult=false;
w_NOME=HtW('','C');
} else if ( ! (_ChkObl('CZTHKEDVCO',1))) {
_SignErr('CZTHKEDVCO');
m_cLastWorkVarErrorMsg='10034405761';
l_bResult=false;
w_CFESTERO=0;
} else if ( ! (_ChkObl('AWPNTOJIRR',1))) {
_SignErr('AWPNTOJIRR');
m_cLastWorkVarErrorMsg='10662833243';
l_bResult=false;
w_RAGSOC=HtW('','C');
} else if ( ! (_ChkObl('YVIKEGPYPM',1))) {
_SignErr('YVIKEGPYPM');
m_cLastWorkVarErrorMsg='7776403';
l_bResult=false;
w_PAESE=HtW('','C');
} else if ( ! (_ChkObl('ODAYKSRECA',1))) {
_SignErr('ODAYKSRECA');
m_cLastWorkVarErrorMsg='15186643';
l_bResult=false;
w_DESCCIT=HtW('','C');
} else if ( ! (_ChkObl('NOTZPDMYIA',1))) {
_SignErr('NOTZPDMYIA');
m_cLastWorkVarErrorMsg='10095365423';
l_bResult=false;
w_PROVINCIA=HtW('','C');
} else if ( ! (_ChkObl('RDAVOEETJG',1))) {
_SignErr('RDAVOEETJG');
m_cLastWorkVarErrorMsg='21587';
l_bResult=false;
w_CAP=HtW('','C');
} else if ( ! (_ChkObl('BOTAJBWHHY',1))) {
_SignErr('BOTAJBWHHY');
m_cLastWorkVarErrorMsg='18003';
l_bResult=false;
w_CODCAB=HtW('','C');
} else if ( ! (_ChkObl('VYLHWTRQNX',1))) {
_SignErr('VYLHWTRQNX');
m_cLastWorkVarErrorMsg='554236824';
l_bResult=false;
w_DOMICILIO=HtW('','C');
} else if ((Eq(w_TIPOPERS,'P')) && ( ! (_ChkObl('NEUBQNUEOJ',1)))) {
_SignErr('NEUBQNUEOJ');
m_cLastWorkVarErrorMsg='12123334500';
l_bResult=false;
w_NASCOMUN=HtW('','C');
} else if ((Eq(w_TIPOPERS,'P')) && ( ! (_ChkObl('KPSCOABZLB',1)))) {
_SignErr('KPSCOABZLB');
m_cLastWorkVarErrorMsg='3528304';
l_bResult=false;
w_TIPINTER=HtW('','C');
} else if ((Eq(w_TIPOPERS,'P')) && ( ! (_ChkObl('QPALJZMFCL',1)))) {
_SignErr('QPALJZMFCL');
m_cLastWorkVarErrorMsg='7776675';
l_bResult=false;
w_SESSO=HtW('','C');
} else if ((Eq(w_TIPOPERS,'P')) && ( ! (_ChkObl('HODZKKOSYW',1)))) {
_SignErr('HODZKKOSYW');
m_cLastWorkVarErrorMsg='12123284333';
l_bResult=false;
w_NASSTATO=HtW('','C');
} else if ((Eq(w_TIPOPERS,'P')) && ( ! (_ChkObl('XMGRWGFSFV',1)))) {
_SignErr('XMGRWGFSFV');
m_cLastWorkVarErrorMsg='11777527481';
l_bResult=false;
w_DATANASC=HtW('','D');
} else if ((Eq(w_TIPOPERS,'P')) && ( ! (_ChkObl('MBGANUUHRA',1)))) {
_SignErr('MBGANUUHRA');
m_cLastWorkVarErrorMsg='11429032151';
l_bResult=false;
w_TIPODOC=HtW('','C');
} else if ((Eq(w_TIPOPERS,'P')) && ( ! (_ChkObl('HVEEMUJUUY',1)))) {
_SignErr('HVEEMUJUUY');
m_cLastWorkVarErrorMsg='1734932797';
l_bResult=false;
w_NUMDOCUM=HtW('','C');
} else if ((Eq(w_TIPOPERS,'P')) && ( ! (_ChkObl('XHWYGOPPUN',1)))) {
_SignErr('XHWYGOPPUN');
m_cLastWorkVarErrorMsg='1690077224';
l_bResult=false;
w_DATARILASC=HtW('','D');
} else if ((Eq(w_TIPOPERS,'P')) && ( ! (_ChkObl('BNWXBPSIDG',1)))) {
_SignErr('BNWXBPSIDG');
m_cLastWorkVarErrorMsg='DATAVALI';
l_bResult=false;
w_DATAVALI=HtW('','D');
} else if ((Eq(w_TIPOPERS,'P')) && ( ! (_ChkObl('HRNCPADUFU',1)))) {
_SignErr('HRNCPADUFU');
m_cLastWorkVarErrorMsg='10032163180';
l_bResult=false;
w_AUTRILASC=HtW('','C');
} else if (( ! (_ChkObl('OJJHIUDPFY',1))) || ( ! (arfn_chkcodfis(w_CODFISC,w_PAESE,w_CFESTERO)))) {
_SignErr('OJJHIUDPFY','10034398626');
l_bResult=false;
w_CODFISC=HtW('','C');
} else if ((Eq(w_TIPOPERS,'G')) && ( ! (_ChkObl('FHXWUTBNKI',1)))) {
_SignErr('FHXWUTBNKI');
m_cLastWorkVarErrorMsg='1756430089';
l_bResult=false;
w_PARTIVA=HtW('','C');
} else if ( ! (_ChkObl('LLYIGAMXRH',1))) {
_SignErr('LLYIGAMXRH');
m_cLastWorkVarErrorMsg='611154211';
l_bResult=false;
w_SOTGRUP=HtW('','C');
} else if ((Ne(w_tipsot,'0') && Ne(w_tipsot,'2')) && ( ! (_ChkObl('RVNHQCXNEM',1)))) {
_SignErr('RVNHQCXNEM');
m_cLastWorkVarErrorMsg='572399938';
l_bResult=false;
w_RAMOGRUP=HtW('','C');
} else if ( ! (_ChkObl('ZGNLLSFQHC',1))) {
_SignErr('ZGNLLSFQHC');
m_cLastWorkVarErrorMsg='2095911698';
l_bResult=false;
w_SETTSINT=HtW('','C');
} else if ( ! (_ChkObl('YTPWDRMFUS',1))) {
_SignErr('YTPWDRMFUS');
m_cLastWorkVarErrorMsg='439891216';
l_bResult=false;
w_CONNES=HtW('','C');
} else if ( ! (_ChkObl('XFKXBQYUIU',1))) {
_SignErr('XFKXBQYUIU');
m_cLastWorkVarErrorMsg='1513560829';
l_bResult=false;
w_PEP='N';
} else if ( ! (_ChkObl('SAQTIHOALW',1))) {
_SignErr('SAQTIHOALW');
m_cLastWorkVarErrorMsg='ATTIV';
l_bResult=false;
w_ATTIV=HtW('','C');
}
if (l_bResult) {
l_bResult=CheckChild(0);
}
// * --- Area Manuale = UI - Check Form
// * --- armt_kersonbo
if (w_CFESTERO==0 && Empty(LRTrim(w_CODFISC))) {
  alert('Attenzione. Non \xe8 stato inserito il codice fiscale del soggetto !')
}
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('YVIKEGPYPM_ZOOM',lc)) {
return 0;
}
if (Eq('YVIKEGPYPM',lc)) {
return 0;
}
if (Eq('ODAYKSRECA_ZOOM',lc)) {
return 1;
}
if (Eq('ODAYKSRECA',lc)) {
return 1;
}
if (Eq('NEUBQNUEOJ_ZOOM',lc)) {
return 2;
}
if (Eq('NEUBQNUEOJ',lc)) {
return 2;
}
if (Eq('HODZKKOSYW_ZOOM',lc)) {
return 3;
}
if (Eq('HODZKKOSYW',lc)) {
return 3;
}
if (Eq('XMGRWGFSFV_ZOOM',lc)) {
return 4;
}
if (Eq('XHWYGOPPUN_ZOOM',lc)) {
return 4;
}
if (Eq('BNWXBPSIDG_ZOOM',lc)) {
return 4;
}
if (Eq('LLYIGAMXRH_ZOOM',lc)) {
return 4;
}
if (Eq('LLYIGAMXRH',lc)) {
return 4;
}
if (Eq('RVNHQCXNEM_ZOOM',lc)) {
return 5;
}
if (Eq('RVNHQCXNEM',lc)) {
return 5;
}
if (Eq('ZGNLLSFQHC_ZOOM',lc)) {
return 6;
}
if (Eq('ZGNLLSFQHC',lc)) {
return 6;
}
if (Eq('SAQTIHOALW_ZOOM',lc)) {
return 7;
}
if (Eq('SAQTIHOALW',lc)) {
return 7;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_YVIKEGPYPM();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,1)) {
l_oWv=LOpt_ODAYKSRECA();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
l_cFixedFilter=l_cFixedFilter+l_cAndOp+_flt_('PKTBSTATI',w_PAESE,'C',true);
if ( ! (Empty(l_cFixedFilter))) {
l_cAndOp=' and ';
}
l_oWv.setValue('FixedFilter',l_cFixedFilter);
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,2)) {
l_oWv=LOpt_NEUBQNUEOJ();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,3)) {
l_oWv=LOpt_HODZKKOSYW();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,4)) {
l_oWv=LOpt_LLYIGAMXRH();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,5)) {
l_oWv=LOpt_RVNHQCXNEM();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,6)) {
l_oWv=LOpt_ZGNLLSFQHC();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,7)) {
l_oWv=LOpt_SAQTIHOALW();
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
l_oWv.setValue('TIPOPERS',WtA(w_TIPOPERS,'C'));
l_oWv.setValue('COGNOME',WtA(w_COGNOME,'C'));
l_oWv.setValue('NOME',WtA(w_NOME,'C'));
l_oWv.setValue('CFESTERO',WtA(w_CFESTERO,'N'));
l_oWv.setValue('RAGSOC',WtA(w_RAGSOC,'C'));
l_oWv.setValue('PAESE',WtA(w_PAESE,'C'));
l_oWv.setValue('DESCCIT',WtA(w_DESCCIT,'C'));
l_oWv.setValue('PROVINCIA',WtA(w_PROVINCIA,'C'));
l_oWv.setValue('idcitta',WtA(w_idcitta,'C'));
l_oWv.setValue('CAP',WtA(w_CAP,'C'));
l_oWv.setValue('CODCAB',WtA(w_CODCAB,'C'));
l_oWv.setValue('DOMICILIO',WtA(w_DOMICILIO,'C'));
l_oWv.setValue('NASCOMUN',WtA(w_NASCOMUN,'C'));
l_oWv.setValue('TIPINTER',WtA(w_TIPINTER,'C'));
l_oWv.setValue('SESSO',WtA(w_SESSO,'C'));
l_oWv.setValue('NASSTATO',WtA(w_NASSTATO,'C'));
l_oWv.setValue('DATANASC',WtA(w_DATANASC,'D'));
l_oWv.setValue('TIPODOC',WtA(w_TIPODOC,'C'));
l_oWv.setValue('NUMDOCUM',WtA(w_NUMDOCUM,'C'));
l_oWv.setValue('DATARILASC',WtA(w_DATARILASC,'D'));
l_oWv.setValue('DATAVALI',WtA(w_DATAVALI,'D'));
l_oWv.setValue('AUTRILASC',WtA(w_AUTRILASC,'C'));
l_oWv.setValue('CODFISC',WtA(w_CODFISC,'C'));
l_oWv.setValue('PARTIVA',WtA(w_PARTIVA,'C'));
l_oWv.setValue('SOTGRUP',WtA(w_SOTGRUP,'C'));
l_oWv.setValue('RAMOGRUP',WtA(w_RAMOGRUP,'C'));
l_oWv.setValue('SETTSINT',WtA(w_SETTSINT,'C'));
l_oWv.setValue('CONNES',WtA(w_CONNES,'C'));
l_oWv.setValue('PROGIMPORT',WtA(w_PROGIMPORT,'N'));
l_oWv.setValue('op_PROGIMPORT',WtA(op_PROGIMPORT,'N'));
l_oWv.setValue('PEP',WtA(w_PEP,'C'));
l_oWv.setValue('AREAGEO',WtA(w_AREAGEO,'C'));
l_oWv.setValue('PKTBSPECIE',WtA(w_PKTBSPECIE,'C'));
l_oWv.setValue('ATTIV',WtA(w_ATTIV,'C'));
l_oWv.setValue('COMPORT',WtA(w_COMPORT,'C'));
l_oWv.setValue('RAREA',WtA(w_RAREA,'N'));
l_oWv.setValue('RNATGIU',WtA(w_RNATGIU,'N'));
l_oWv.setValue('RATTIV',WtA(w_RATTIV,'N'));
l_oWv.setValue('RCOMP',WtA(w_RCOMP,'N'));
l_oWv.setValue('datamodi',WtA(w_datamodi,'D'));
l_oWv.setValue('DESCSGRU',WtA(w_DESCSGRU,'C'));
l_oWv.setValue('DESCRAMGRU',WtA(w_DESCRAMGRU,'C'));
l_oWv.setValue('DESCUIC',WtA(w_DESCUIC,'C'));
l_oWv.setValue('dessta',WtA(w_dessta,'C'));
l_oWv.setValue('tipsot',WtA(w_tipsot,'C'));
l_oWv.setValue('STATOREG',WtA(w_STATOREG,'C'));
l_oWv.setValue('IDBASE',WtA(w_IDBASE,'C'));
l_oWv.setValue('NUMPROG',WtA(w_NUMPROG,'C'));
l_oWv.setValue('DESCRI',WtA(w_DESCRI,'C'));
l_oWv.setValue('gSeekAos',WtA(w_gSeekAos,'C'));
l_oWv.setValue('gDataVaria',WtA(w_gDataVaria,'D'));
l_oWv.setValue('gFlgDoc',WtA(w_gFlgDoc,'C'));
l_oWv.setValue('gFlgWU',WtA(w_gFlgWU,'C'));
l_oWv.setValue('xdescareag',WtA(w_xdescareag,'C'));
l_oWv.setValue('xdescnatgiu',WtA(w_xdescnatgiu,'C'));
l_oWv.setValue('xdesctipatt',WtA(w_xdesctipatt,'C'));
l_oWv.setValue('xdesccomp',WtA(w_xdesccomp,'C'));
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
FillWv.n=["TIPOPERS","COGNOME","NOME","CFESTERO","RAGSOC","PAESE","DESCCIT","PROVINCIA","idcitta","CAP","CODCAB","DOMICILIO","NASCOMUN","TIPINTER","SESSO","NASSTATO","DATANASC","TIPODOC","NUMDOCUM","DATARILASC","DATAVALI","AUTRILASC","CODFISC","PARTIVA","SOTGRUP","RAMOGRUP","SETTSINT","CONNES","PROGIMPORT","PEP","AREAGEO","PKTBSPECIE","ATTIV","COMPORT","RAREA","RNATGIU","RATTIV","RCOMP","datamodi","DESCSGRU","DESCRAMGRU","DESCUIC","dessta","tipsot","STATOREG","IDBASE","NUMPROG","DESCRI","gSeekAos","gDataVaria","gFlgDoc","gFlgWU","xdescareag","xdescnatgiu","xdesctipatt","xdesccomp"];
function SetModified() {
m_bUpdated=true;
}
