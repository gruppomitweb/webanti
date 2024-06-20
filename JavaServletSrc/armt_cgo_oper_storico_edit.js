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
function DisplayErrorMessage_ardt_cgo_oper_storico_multi() {
if ( ! (ChildToLoad(FrameRef('ardt_cgo_oper_storico_multi'))) && Ne(typeof(FrameRef('ardt_cgo_oper_storico_multi').DisplayErrorMessage),'undefined')) {
FrameRef('ardt_cgo_oper_storico_multi').DisplayErrorMessage();
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
l_bEnabled= ! (false) || IsDisabledByStateDriver('TOTLIRE');
SetDisabled('HUAGBHPUNH',l_bEnabled);
l_bEnabled= ! (Eq(w_FLAGCONT,'1')) || IsDisabledByStateDriver('TOTCONT');
SetDisabled('HUDOCMLKKT',l_bEnabled);
l_bEnabled= ! (Eq(w_xEDTTPGIO,'S')) || IsDisabledByStateDriver('CGOFLGVLT');
SetDisabled('SFKJNKYLJO_DIV',l_bEnabled);
l_bEnabled= ! (Ne(w_TOTLIRE,w_TOTCONT)) || IsDisabledByStateDriver('MEZPAGAM');
SetDisabled('EOSKLIUGBC',l_bEnabled);
l_bEnabled= ! (Eq(w_PAESE,'086')) || IsDisabledByStateDriver('DESCCIT');
SetDisabled('ODAYKSRECA',l_bEnabled);
SetDisabled(Ctrl('ODAYKSRECA_ZOOM'),l_bEnabled);
l_bEnabled= ! (Eq(w_PAESE,'086')) || IsDisabledByStateDriver('PROVINCIA');
SetDisabled('NOTZPDMYIA',l_bEnabled);
l_bEnabled= ! (Eq(w_PAESE,'086')) || IsDisabledByStateDriver('CAP');
SetDisabled('RDAVOEETJG',l_bEnabled);
l_bEnabled= ! (Eq(w_PAESE,'086')) || IsDisabledByStateDriver('DOMICILIO');
SetDisabled('VYLHWTRQNX',l_bEnabled);
l_bEnabled= ! (false) || Eq(m_cFunction,'edit') || IsDisabledByStateDriver('SNAINUMOPE');
SetDisabled('XFUOZLSACP',l_bEnabled);
l_bEnabled= ! ( ! (Empty(w_CODFISC)));
SetDisabled('DERAHXASAL',l_bEnabled);
l_bEnabled= ! ( ! (Empty(w_COGNOME)) &&  ! (Empty(w_NOME)) &&  ! (Empty(LRTrim(w_NASCOMUN)+LRTrim(w_NASSTATO))) &&  ! (Empty(w_SESSO)) &&  ! (Empty(w_DATANASC)));
SetDisabled('RQVPEKINIU',l_bEnabled);
if (IsDisabledByStateDriver('box_CCUOYXMBZC')) {
DisableInputsInContainer(Ctrl('CCUOYXMBZC'),true);
}
if (IsDisabledByStateDriver('Operazione')) {
DisableInputsInContainer(Ctrl('YORQOIOBQN'),true);
}
if (IsDisabledByStateDriver('Soggetto')) {
DisableInputsInContainer(Ctrl('AQSQVBKXAL'),true);
}
if (IsDisabledByStateDriver('box_XWJLXLYKJC')) {
DisableInputsInContainer(Ctrl('XWJLXLYKJC'),true);
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
SetObligatory(Ctrl('HUDOCMLKKT'),Eq(w_FLAGCONT,'1') || IsObligatoryByStateDriver('TOTCONT'));
SetObligatory(Ctrl('OJJHIUDPFY'),Eq(w_CFESTERO,0) || IsObligatoryByStateDriver('CODFISC'));
SetObligatory(Ctrl('NEUBQNUEOJ'),Empty(w_NASSTATO) || IsObligatoryByStateDriver('NASCOMUN'));
SetObligatory(Ctrl('HODZKKOSYW'),Empty(w_NASCOMUN) || IsObligatoryByStateDriver('NASSTATO'));
SetObligatory(Ctrl('ODAYKSRECA'),Eq(w_PAESE,'086') || IsObligatoryByStateDriver('DESCCIT'));
SetObligatory(Ctrl('NOTZPDMYIA'),Eq(w_PAESE,'086') || IsObligatoryByStateDriver('PROVINCIA'));
SetObligatory(Ctrl('RDAVOEETJG'),Eq(w_PAESE,'086') || IsObligatoryByStateDriver('CAP'));
SetObligatory(Ctrl('VYLHWTRQNX'),Eq(w_PAESE,'086') || IsObligatoryByStateDriver('DOMICILIO'));
SetObligatory(Ctrl('KZWBLPQNHU'),Eq(w_MEZPAGAM,'C') || Eq(w_MEZPAGAM,'B') || IsObligatoryByStateDriver('ASSEGNO'));
SetObligatory(Ctrl('UTUCDPQJKK'),Eq(w_MEZPAGAM,'I') || Eq(w_MEZPAGAM,'E') || Eq(w_MEZPAGAM,'P') || IsObligatoryByStateDriver('IBAN'));
SetObligatory(Ctrl('FKEAKFSYVU'),Eq(w_MEZPAGAM,'V') || IsObligatoryByStateDriver('CC4CIFRE'));
SetObligatory(Ctrl('OXFYJQLTDL'),Eq(w_MEZPAGAM,'V') || IsObligatoryByStateDriver('CCDATSCA'));
}
function SetDynamicClasses() {
var c;
}
function SetDynamicTooltip() {
var c;
}
function Set_CC4CIFRE(ctrlValue,kmode,e) {
if (Ne(w_CC4CIFRE,ctrlValue)) {
var ctl = _GetCtl(e,'FKEAKFSYVU');
if (_tracker.goon(ctl,ctrlValue)) {
w_CC4CIFRE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FKEAKFSYVU',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',4,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_IBAN(ctrlValue,kmode,e) {
if (Ne(w_IBAN,ctrlValue)) {
var ctl = _GetCtl(e,'UTUCDPQJKK');
if (_tracker.goon(ctl,ctrlValue)) {
w_IBAN=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UTUCDPQJKK',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('UTUCDPQJKK',function(){return WtH(w_IBAN,'C',27,0,'!')},w_IBAN);
return l_bResult;
} else {
ctl.value=WtH('','C',27,0,'!');
_ResetTracker();
return true;
}
}
return true;
}
function Set_SNAINUMOPE(ctrlValue,kmode,e) {
if (Ne(w_SNAINUMOPE,ctrlValue)) {
var ctl = _GetCtl(e,'XFUOZLSACP');
if (_tracker.goon(ctl,ctrlValue)) {
w_SNAINUMOPE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XFUOZLSACP',0);
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
SPBOUILib.SetInputValue('HVEEMUJUUY',function(){return WtH(w_NUMDOCUM,'C',15,0,'!')},w_NUMDOCUM);
return l_bResult;
} else {
ctl.value=WtH('','C',15,0,'!');
_ResetTracker();
return true;
}
}
return true;
}
function Set_DATAOPE(ctrlValue,kmode,e) {
if (Ne(w_DATAOPE,ctrlValue)) {
var ctl = _GetCtl(e,'YLIKFVPZJA');
if (_tracker.goon(ctl,ctrlValue)) {
w_DATAOPE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YLIKFVPZJA',0);
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
function Set_FLAGCONT(ctrlValue,kmode,e) {
if (Ne(w_FLAGCONT,ctrlValue)) {
var ctl = _GetCtl(e,'PURPSXEVAI');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLAGCONT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('PURPSXEVAI',0);
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
function Set_CACODICE(ctrlValue,kmode,e) {
if (Ne(w_CACODICE,ctrlValue)) {
var ctl = _GetCtl(e,'WJQFIEBCQV');
if (_tracker.goon(ctl,ctrlValue)) {
w_CACODICE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('WJQFIEBCQV',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','N',5,0,'');
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
function Set_TOTLIRE(ctrlValue,kmode,e) {
if (Ne(w_TOTLIRE,ctrlValue)) {
var ctl = _GetCtl(e,'HUAGBHPUNH');
if (_tracker.goon(ctl,ctrlValue)) {
w_TOTLIRE=ValidNum(ctrlValue,'999999999999.99');
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HUAGBHPUNH',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('HUAGBHPUNH',function(){return WtH(w_TOTLIRE,'N',15,2,'999,999,999,999.99')},w_TOTLIRE);
return l_bResult;
} else {
ctl.value=WtH('','N',15,2,'999999999999.99');
_ResetTracker();
return true;
}
} else {
SPBOUILib.SetInputValue('HUAGBHPUNH',function(){return WtH(w_TOTLIRE,'N',15,2,'999,999,999,999.99')},w_TOTLIRE);
}
return true;
}
function Set_TOTCONT(ctrlValue,kmode,e) {
if (Ne(w_TOTCONT,ctrlValue)) {
var ctl = _GetCtl(e,'HUDOCMLKKT');
if (_tracker.goon(ctl,ctrlValue)) {
w_TOTCONT=ValidNum(ctrlValue,'999999999999.99');
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HUDOCMLKKT',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('HUDOCMLKKT',function(){return WtH(w_TOTCONT,'N',15,2,'999,999,999,999.99')},w_TOTCONT);
return l_bResult;
} else {
ctl.value=WtH('','N',15,2,'999999999999.99');
_ResetTracker();
return true;
}
} else {
SPBOUILib.SetInputValue('HUDOCMLKKT',function(){return WtH(w_TOTCONT,'N',15,2,'999,999,999,999.99')},w_TOTCONT);
}
return true;
}
function Set_CGOFLGVLT(ctrlValue,kmode,e) {
if (Ne(w_CGOFLGVLT,ctrlValue)) {
var ctl = _GetCtl(e,'SFKJNKYLJO');
if (_tracker.goon(ctl,ctrlValue)) {
w_CGOFLGVLT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SFKJNKYLJO',0);
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
SPBOUILib.SetInputValue('HRNCPADUFU',function(){return WtH(w_AUTRILASC,'C',30,0,'!')},w_AUTRILASC);
return l_bResult;
} else {
ctl.value=WtH('','C',30,0,'!');
_ResetTracker();
return true;
}
}
return true;
}
function Set_MEZPAGAM(ctrlValue,kmode,e) {
if (Ne(w_MEZPAGAM,ctrlValue)) {
var ctl = _GetCtl(e,'EOSKLIUGBC');
if (_tracker.goon(ctl,ctrlValue)) {
w_MEZPAGAM=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('EOSKLIUGBC',0);
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
l_bResult=arfn_chkcodfis(w_CODFISC,'086',w_CFESTERO);
if ( ! (l_bResult)) {
m_nLastError=2;
m_cLastWorkVarErrorMsg='11921223220';
m_cLastMsgError=AlertErrorMessage('1715238713');
}
if ( ! (l_bResult)) {
w_CODFISC=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',16,0,'!'));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',16,0,'!');
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
SPBOUILib.SetInputValue('TWTTDWKCRG',function(){return WtH(w_COGNOME,'C',26,0,'!')},w_COGNOME);
return l_bResult;
} else {
ctl.value=WtH('','C',26,0,'!');
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
SPBOUILib.SetInputValue('WWGIVGNUDW',function(){return WtH(w_NOME,'C',25,0,'!')},w_NOME);
return l_bResult;
} else {
ctl.value=WtH('','C',25,0,'!');
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
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',30,0,'!'));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',30,0,'!');
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
SPBOUILib.SetInputValue('KPSCOABZLB',function(){return WtH(w_TIPINTER,'C',2,0,'!')},w_TIPINTER);
return l_bResult;
} else {
ctl.value=WtH('','C',2,0,'!');
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
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',30,0,'!'));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',30,0,'!');
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
l_bResult=_ChkObl('XMGRWGFSFV',0);
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
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',40,0,'!'));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',40,0,'!');
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
SPBOUILib.SetInputValue('VYLHWTRQNX',function(){return WtH(w_DOMICILIO,'C',35,0,'!')},w_DOMICILIO);
return l_bResult;
} else {
ctl.value=WtH('','C',35,0,'!');
_ResetTracker();
return true;
}
}
return true;
}
function Set_NUMTEL(ctrlValue,kmode,e) {
if (Ne(w_NUMTEL,ctrlValue)) {
var ctl = _GetCtl(e,'KSZEHVQAGY');
if (_tracker.goon(ctl,ctrlValue)) {
w_NUMTEL=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('KSZEHVQAGY',0);
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
function Set_CCDATSCA(ctrlValue,kmode,e) {
if (Ne(w_CCDATSCA,ctrlValue)) {
var ctl = _GetCtl(e,'OXFYJQLTDL');
if (_tracker.goon(ctl,ctrlValue)) {
w_CCDATSCA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('OXFYJQLTDL',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',7,0,'');
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
l_bResult=_ChkObl('XHWYGOPPUN',0);
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
function Set_MIDBIGLIETTO(ctrlValue,kmode,e) {
if (Ne(w_MIDBIGLIETTO,ctrlValue)) {
var ctl = _GetCtl(e,'BSSRUASCBR');
if (_tracker.goon(ctl,ctrlValue)) {
w_MIDBIGLIETTO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BSSRUASCBR',0);
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
function Set_ASSEGNO(ctrlValue,kmode,e) {
if (Ne(w_ASSEGNO,ctrlValue)) {
var ctl = _GetCtl(e,'KZWBLPQNHU');
if (_tracker.goon(ctl,ctrlValue)) {
w_ASSEGNO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('KZWBLPQNHU',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',25,0,'');
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
if ( ! (ChildToLoad(FrameRef('ardt_cgo_oper_storico_multi'))) && Ne(typeof(FrameRef('ardt_cgo_oper_storico_multi').DoUpdate),'undefined')) {
CopyWorkVar(FrameRef('ardt_cgo_oper_storico_multi'),['CGOTIPOPE'],['CGOTIPOPE'],true)
}
if ((Ne(o_ATTIV,w_ATTIV))) {
l_bTmpRes=Link_SAQTIHOALW(null);
}
w_TIPOPERS='P';
w_SOTGRUP='600';
if ((Ne(o_SOTGRUP,w_SOTGRUP))) {
w_SETTSINT='600';
}
if ((Ne(o_COGNOME,w_COGNOME)) || (Ne(o_NOME,w_NOME))) {
Calculation_UEZIABOGNW();
}
if ((Ne(o_NASSTATO,w_NASSTATO))) {
Calculation_DWHWPBJTAT();
}
UpdateAutonumber('SNAINUMOPE');
if ((Ne(o_DATAOPE,w_DATAOPE))) {
w_DATAREG=SystemDate();
}
if ((Ne(o_TIPOOPRAP,w_TIPOOPRAP))) {
l_bTmpRes=Link_UJRFWINIVQ(null);
}
if ((Ne(o_CODANA,w_CODANA))) {
l_bTmpRes=Link_SQVJLYRFKQ(null);
}
if ((Ne(o_CODANA,w_CODANA)) || (Ne(o_CODVOC,w_CODVOC))) {
l_bTmpRes=Link_SRWWPHPCUB(null);
}
w_VALUTA='242';
w_CAMBIO=1;
w_CONNESCLI=w_CODFISC;
w_CONNESBEN=w_CODFISC;
l_bTmpRes=Link_ULVCBLFVEU(null);
if ((Ne(o_CONNESBEN,w_CONNESBEN)) || (Ne(o_C_CTA,w_C_CTA))) {
l_bTmpRes=Link_KUPRRTVLKH(null);
}
w_CODINTER=w_gIntemediario;
l_bTmpRes=Link_WJSVGWKSFC(null);
w_CODDIPE=w_gCodDip;
l_bTmpRes=Link_AVHTGZTOSZ(null);
if ((Ne(o_COLLEG,w_COLLEG))) {
l_bTmpRes=Link_MSGBKOOAOY(null);
}
if ((Ne(o_CODINTER,w_CODINTER)) || (Ne(o_CODDIPE,w_CODDIPE))) {
Calculation_WKUMXNRIRT();
}
if ((Ne(o_CODVOC,w_CODVOC))) {
l_bTmpRes=Link_LKEDJRUQJU(null);
}
if ((Ne(o_idcitta,w_idcitta))) {
l_bTmpRes=Link_XPSJTIMTNR(null);
}
if ((Ne(o_NASCOMUN,w_NASCOMUN)) || (Ne(o_TIPINTER,w_TIPINTER))) {
Calculation_QQIFZZEGJS();
}
if ((Ne(o_PAESE,w_PAESE))) {
Calculation_BUOAEINKPC();
}
if ((Ne(o_CACODICE,w_CACODICE))) {
Calculation_CMDOBQAJRA();
}
if ((Ne(o_VLTPLAT,w_VLTPLAT))) {
l_bTmpRes=Link_LVYFMQXNZH(null);
}
if ((Ne(o_TIPOGIOCO,w_TIPOGIOCO))) {
l_bTmpRes=Link_DKNVEJCFAA(null);
}
w_PrtDocAll.Calculate(w_IDDOCALL,w_TIPOGIOCO,w_TOTLIRE,w_TOTCONT,w_FLGDOCALL);
LibJavascript.forEachItem(m_FoundlingCopyWorkVar,i_body_1)
function i_body_1(child){
child();
}
// * --- Area Manuale = UI - Calculate
// * --- Fine Area Manuale
UpdateAutonumber('');
m_bCalculating=false;
if (l_bResult &&  ! (Check_NXWIUCGNDI(false)) && Ne(m_nLastError,-3)) {
setTimeout('WindowAlert('+LibJavascript.ToJSValue(AlertErrorMessage(m_cLastMsgError))+')',1);
l_bResult=false;
}
if (l_bResult &&  ! (Check_YHNSLBLWFP(false)) && Ne(m_nLastError,-3)) {
setTimeout('WindowAlert('+LibJavascript.ToJSValue(AlertErrorMessage(m_cLastMsgError))+')',1);
l_bResult=false;
}
if (l_bResult &&  ! (Check_QNEKQYKSHZ(false)) && Ne(m_nLastError,-3)) {
setTimeout('WindowAlert('+LibJavascript.ToJSValue(AlertErrorMessage(m_cLastMsgError))+')',1);
l_bResult=false;
}
}
function Calculation_UEZIABOGNW() {
w_COGNOME=arfn_agechar(w_COGNOME,' ');
w_NOME=arfn_agechar(w_NOME,' ');
w_RAGSOC=arfn_agechar(LRTrim(w_COGNOME)+' '+LRTrim(w_NOME),' ');
}
function Calculation_DWHWPBJTAT() {
w_TIPINTER=( ! (Empty(w_TIPINTER))?w_TIPINTER:( ! (Empty(w_NASSTATO))?'EE':''));
}
function Calculation_WKUMXNRIRT() {
w_DESCCITDIP=(Empty(w_CODDIPE)?w_CITINT:w_CITDIP);
w_PROVINCIADIP=(Empty(w_CODDIPE)?w_PROVINT:w_PROVDIP);
w_CODCABDIP=(Empty(w_CODDIPE)?w_CABINT:w_CABDIP);
}
function Calculation_QQIFZZEGJS() {
w_NASSTATO=(Eq(w_TIPINTER,'EE')?w_NASSTATO:'ITALIA');
}
function Calculation_BUOAEINKPC() {
w_PROVINCIA=( ! (Empty(w_PROVINCIA))?w_PROVINCIA:(Ne(w_PAESE,'086')?'EE':''));
}
function Calculation_CMDOBQAJRA() {
arrt_cgo_read_flgope([])
}
function Check_NXWIUCGNDI(p_bForce) {
var l_bResult = true;
if (p_bForce || Ne(o_DATARILASC,w_DATARILASC) || Ne(o_DATAOPE,w_DATAOPE)) {
l_bResult=( ! (Empty(w_DATAOPE)) &&  ! (Empty(w_DATARILASC))?Ge(w_DATAOPE,w_DATARILASC):true);
if ( ! (l_bResult)) {
m_cLastMsgError=AlertErrorMessage('819587209');
}
}
return l_bResult;
}
function Check_YHNSLBLWFP(p_bForce) {
var l_bResult = true;
if (p_bForce || Ne(o_DATAVALI,w_DATAVALI) || Ne(o_DATAOPE,w_DATAOPE)) {
l_bResult=( ! (Empty(w_DATAOPE)) &&  ! (Empty(w_DATAVALI))?Le(w_DATAOPE,w_DATAVALI):true);
if ( ! (l_bResult)) {
m_cLastMsgError=AlertErrorMessage('187973133');
}
}
return l_bResult;
}
function Check_QNEKQYKSHZ(p_bForce) {
var l_bResult = true;
if (p_bForce || Ne(o_DATARILASC,w_DATARILASC) || Ne(o_DATAVALI,w_DATAVALI)) {
l_bResult=( ! (Empty(w_DATAVALI))?Le(w_DATARILASC,w_DATAVALI):true);
if ( ! (l_bResult)) {
m_cLastMsgError=AlertErrorMessage('11293478463');
}
}
return l_bResult;
}
function SaveDependsOn() {
o_CGOTIPOPE=w_CGOTIPOPE;
o_DATAOPE=w_DATAOPE;
o_CACODICE=w_CACODICE;
o_COGNOME=w_COGNOME;
o_NOME=w_NOME;
o_NASCOMUN=w_NASCOMUN;
o_TIPINTER=w_TIPINTER;
o_NASSTATO=w_NASSTATO;
o_PAESE=w_PAESE;
o_DATARILASC=w_DATARILASC;
o_DATAVALI=w_DATAVALI;
o_ATTIV=w_ATTIV;
o_SOTGRUP=w_SOTGRUP;
o_TIPOOPRAP=w_TIPOOPRAP;
o_CODANA=w_CODANA;
o_CODVOC=w_CODVOC;
o_CONNESBEN=w_CONNESBEN;
o_C_CTA=w_C_CTA;
o_CODINTER=w_CODINTER;
o_CODDIPE=w_CODDIPE;
o_COLLEG=w_COLLEG;
o_idcitta=w_idcitta;
o_VLTPLAT=w_VLTPLAT;
o_TIPOGIOCO=w_TIPOGIOCO;
}
function SaveLabelDependsOn() {
}
function Sugg_NEUBQNUEOJ(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_Appl = LinkApplet();
var l_bEmp = Empty(HtW(Ctrl('NEUBQNUEOJ').value,'C'));
l_Appl.SetStringKey('CITTA',HtW(Ctrl('NEUBQNUEOJ').value,'C'),30,0);
l_Appl.SetFields('CITTA,PROV');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbcitta');
l_Appl.SetID('NEUBQNUEOJ');
l_Appl.SetMode('suggest');
l_Appl.SetRows('15');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
var res = l_Appl.GetJSONData();
SuggesterLib.render_suggest(res,'NEUBQNUEOJ','NEUBQNUEOJ',false,'AQSQVBKXAL_DIV','AQSQVBKXAL_HEADER',0);
return l_bResult;
}
SuggesterLib.select_suggest.NEUBQNUEOJ=["NASCOMUN",[null],function(newval) { return HtW(newval,'C')}];
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
function Sugg_HODZKKOSYW(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_Appl = LinkApplet();
var l_bEmp = Empty(HtW(Ctrl('HODZKKOSYW').value,'C'));
l_Appl.SetStringKey('DESCRI',HtW(Ctrl('HODZKKOSYW').value,'C'),30,0);
l_Appl.SetFields('DESCRI');
l_Appl.SetTypes('C');
l_Appl.LinkTable('tbstati');
l_Appl.SetID('HODZKKOSYW');
l_Appl.SetMode('suggest');
l_Appl.SetRows('15');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
var res = l_Appl.GetJSONData();
SuggesterLib.render_suggest(res,'HODZKKOSYW','HODZKKOSYW',false,'AQSQVBKXAL_DIV','AQSQVBKXAL_HEADER',0);
return l_bResult;
}
SuggesterLib.select_suggest.HODZKKOSYW=["NASSTATO",[null],function(newval) { return HtW(newval,'C')}];
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
function Sugg_YVIKEGPYPM(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_Appl = LinkApplet();
var l_bEmp = Empty(HtW(Ctrl('YVIKEGPYPM').value,'C'));
l_Appl.SetStringKey('CODSTA',HtW(Ctrl('YVIKEGPYPM').value,'C'),3,0);
l_Appl.SetFields('CODSTA,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbstati');
l_Appl.SetID('YVIKEGPYPM');
l_Appl.SetMode('suggest');
l_Appl.SetRows('15');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
var res = l_Appl.GetJSONData();
SuggesterLib.render_suggest(res,'YVIKEGPYPM','YVIKEGPYPM',false,'AQSQVBKXAL_DIV','AQSQVBKXAL_HEADER',0);
return l_bResult;
}
SuggesterLib.select_suggest.YVIKEGPYPM=["PAESE",[null,null],function(newval) { return HtW(newval,'C')}];
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
function Sugg_ODAYKSRECA(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_Appl = LinkApplet();
var l_bEmp = Empty(HtW(Ctrl('ODAYKSRECA').value,'C'));
l_Appl.SetStringKey('PKTBSTATI',w_PAESE,3,0);
l_Appl.SetStringKey('CITTA',HtW(Ctrl('ODAYKSRECA').value,'C'),40,0);
l_Appl.SetFields('CITTA,IDBASE');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbcitta');
l_Appl.SetID('ODAYKSRECA');
l_Appl.SetMode('suggest');
l_Appl.SetRows('15');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
var res = l_Appl.GetJSONData();
SuggesterLib.render_suggest(res,'ODAYKSRECA','ODAYKSRECA',false,'AQSQVBKXAL_DIV','AQSQVBKXAL_HEADER',0);
return l_bResult;
}
SuggesterLib.select_suggest.ODAYKSRECA=["DESCCIT",[null,null],function(newval) { return HtW(newval,'C')}];
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
function Link_MBGANUUHRA(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_TIPODOC);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('TIPDOC',w_TIPODOC,2,0);
l_Appl.SetFields('TIPDOC,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('cgo_tipdoc');
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
l_oWv.setValue('Table',WtA('cgo_tipdoc','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('TIPDOC','C'));
l_oWv.setValue('LinkedField',WtA('TIPDOC','C'));
l_oWv.setValue('UID',WtA('MBGANUUHRA','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['MBGANUUHRA'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('1255511772'),'C'));
return l_oWv;
}
function Link_SAQTIHOALW(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_ATTIV);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODICE',w_ATTIV,10,0);
l_Appl.SetFields('CODICE,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbtipatt');
l_Appl.SetID('SAQTIHOALW');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_ATTIV=l_Appl.GetStringValue('CODICE',10,0);
w_xdesctipatt=l_Appl.GetStringValue('DESCRI',250,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_SAQTIHOALW_Blank();
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
function Link_SAQTIHOALW_Blank() {
w_ATTIV='';
w_xdesctipatt='';
}
function LOpt_SAQTIHOALW() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbtipatt','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODICE','C'));
l_oWv.setValue('LinkedField',WtA('CODICE','C'));
l_oWv.setValue('UID',WtA('SAQTIHOALW','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['SAQTIHOALW'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('484567773'),'C'));
return l_oWv;
}
function Link_UJRFWINIVQ(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_TIPOOPRAP);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODICE',w_TIPOOPRAP,2,0);
l_Appl.SetFields('CODICE,DES1');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbtipreg');
l_Appl.SetID('UJRFWINIVQ');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_TIPOOPRAP=l_Appl.GetStringValue('CODICE',2,0);
w_xdes1=l_Appl.GetStringValue('DES1',90,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_UJRFWINIVQ_Blank();
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
function Link_UJRFWINIVQ_Blank() {
w_TIPOOPRAP='';
w_xdes1='';
}
function LOpt_UJRFWINIVQ() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbtipreg','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODICE','C'));
l_oWv.setValue('LinkedField',WtA('CODICE','C'));
l_oWv.setValue('UID',WtA('UJRFWINIVQ','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['UJRFWINIVQ'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('995100987'),'C'));
return l_oWv;
}
function Link_SQVJLYRFKQ(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CODANA);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODCAU',w_CODANA,4,0);
l_Appl.SetFields('CODCAU');
l_Appl.SetTypes('C');
l_Appl.LinkTable('tbcauana');
l_Appl.SetID('SQVJLYRFKQ');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CODANA=l_Appl.GetStringValue('CODCAU',4,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_SQVJLYRFKQ_Blank();
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
function Link_SQVJLYRFKQ_Blank() {
w_CODANA='';
}
function LOpt_SQVJLYRFKQ() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcauana','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODCAU','C'));
l_oWv.setValue('LinkedField',WtA('CODCAU','C'));
l_oWv.setValue('UID',WtA('SQVJLYRFKQ','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['SQVJLYRFKQ'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('282647084'),'C'));
return l_oWv;
}
function Link_SRWWPHPCUB(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CODVOC);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODCAU',w_CODANA,4,0);
l_Appl.SetStringKey('CAUSINT',w_CODVOC,2,0);
l_Appl.SetFields('CAUSINT,SEGNO,DESCRI');
l_Appl.SetTypes('C,C,C');
l_Appl.LinkTable('tbcauana');
l_Appl.SetID('SRWWPHPCUB');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CODVOC=l_Appl.GetStringValue('CAUSINT',2,0);
w_SEGNO=l_Appl.GetStringValue('SEGNO',1,0);
w_desccauana=l_Appl.GetStringValue('DESCRI',165,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_SRWWPHPCUB_Blank();
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
function Link_SRWWPHPCUB_Blank() {
w_CODVOC='';
w_SEGNO='';
w_desccauana='';
}
function LOpt_SRWWPHPCUB() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcauana','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODCAU,CAUSINT','C'));
l_oWv.setValue('LinkedField',WtA('CAUSINT','C'));
l_oWv.setValue('UID',WtA('SRWWPHPCUB','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['SRWWPHPCUB'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('282420974'),'C'));
return l_oWv;
}
function Link_ULVCBLFVEU(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CONNESBEN);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CONNES',w_CONNESBEN,16,0);
l_Appl.SetFields('CONNES,RAGSOC,DOMICILIO,DESCCIT,PROVINCIA,PAESE,CAP');
l_Appl.SetTypes('C,C,C,C,C,C,C');
l_Appl.LinkTable('personbo');
l_Appl.SetID('ULVCBLFVEU');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CONNESBEN=l_Appl.GetStringValue('CONNES',16,0);
w_C_RAG=l_Appl.GetStringValue('RAGSOC',70,0);
w_C_IND=l_Appl.GetStringValue('DOMICILIO',35,0);
w_C_CTA=l_Appl.GetStringValue('DESCCIT',30,0);
w_C_PRV=l_Appl.GetStringValue('PROVINCIA',2,0);
w_C_STA=l_Appl.GetStringValue('PAESE',3,0);
w_C_CAP=l_Appl.GetStringValue('CAP',5,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_ULVCBLFVEU_Blank();
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
function Link_ULVCBLFVEU_Blank() {
w_CONNESBEN='';
w_C_RAG='';
w_C_IND='';
w_C_CTA='';
w_C_PRV='';
w_C_STA='';
w_C_CAP='';
}
function LOpt_ULVCBLFVEU() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('personbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CONNES','C'));
l_oWv.setValue('LinkedField',WtA('CONNES','C'));
l_oWv.setValue('UID',WtA('ULVCBLFVEU','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['ULVCBLFVEU'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('1890893827'),'C'));
return l_oWv;
}
function Link_KUPRRTVLKH(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_C_CTA);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CITTA',w_C_CTA,30,0);
l_Appl.SetFields('CITTA,CAB,PROV,PKTBSTATI,CAP');
l_Appl.SetTypes('C,C,C,C,C');
l_Appl.LinkTable('tbcitta');
l_Appl.SetID('KUPRRTVLKH');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_C_CTA=l_Appl.GetStringValue('CITTA',30,0);
w_C_CAB=l_Appl.GetStringValue('CAB',6,0);
w_C_PRV=l_Appl.GetStringValue('PROV',2,0);
w_C_STA=l_Appl.GetStringValue('PKTBSTATI',3,0);
w_C_CAP=l_Appl.GetStringValue('CAP',5,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_KUPRRTVLKH_Blank();
l_bResult=true;
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
function Link_KUPRRTVLKH_Blank() {
w_C_CAB='';
w_C_PRV='';
w_C_STA='';
w_C_CAP='';
}
function LOpt_KUPRRTVLKH() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcitta','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CITTA','C'));
l_oWv.setValue('LinkedField',WtA('CITTA','C'));
l_oWv.setValue('UID',WtA('KUPRRTVLKH','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['KUPRRTVLKH'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('15186643'),'C'));
return l_oWv;
}
function Link_WJSVGWKSFC(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CODINTER);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODINTER',w_CODINTER,11,0);
l_Appl.SetFields('CODINTER,DATANASC,CODCAB,PROVINCIA,DESCCIT');
l_Appl.SetTypes('C,D,C,C,C');
l_Appl.LinkTable('intermbo');
l_Appl.SetID('WJSVGWKSFC');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CODINTER=l_Appl.GetStringValue('CODINTER',11,0);
w_datpaseuro=l_Appl.GetDateValue('DATANASC',8,0);
w_datpaseuro=DateFromApplet(w_datpaseuro);
w_CABINT=l_Appl.GetStringValue('CODCAB',6,0);
w_PROVINT=l_Appl.GetStringValue('PROVINCIA',2,0);
w_CITINT=l_Appl.GetStringValue('DESCCIT',30,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_WJSVGWKSFC_Blank();
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
function Link_WJSVGWKSFC_Blank() {
w_CODINTER='';
w_datpaseuro=NullDate();
w_CABINT='';
w_PROVINT='';
w_CITINT='';
}
function LOpt_WJSVGWKSFC() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('intermbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODINTER','C'));
l_oWv.setValue('LinkedField',WtA('CODINTER','C'));
l_oWv.setValue('UID',WtA('WJSVGWKSFC','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['WJSVGWKSFC'][1],'C'));
return l_oWv;
}
function Link_AVHTGZTOSZ(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CODDIPE);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODDIP',w_CODDIPE,6,0);
l_Appl.SetFields('CODDIP,DESCRIZ,DESCCIT,PROVINCIA,CAB');
l_Appl.SetTypes('C,C,C,C,C');
l_Appl.LinkTable('anadip');
l_Appl.SetID('AVHTGZTOSZ');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CODDIPE=l_Appl.GetStringValue('CODDIP',6,0);
w_xDescDipe=l_Appl.GetStringValue('DESCRIZ',30,0);
w_CITDIP=l_Appl.GetStringValue('DESCCIT',30,0);
w_PROVDIP=l_Appl.GetStringValue('PROVINCIA',2,0);
w_CABDIP=l_Appl.GetStringValue('CAB',6,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_AVHTGZTOSZ_Blank();
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
function Link_AVHTGZTOSZ_Blank() {
w_CODDIPE='';
w_xDescDipe='';
w_CITDIP='';
w_PROVDIP='';
w_CABDIP='';
}
function LOpt_AVHTGZTOSZ() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('anadip','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODDIP','C'));
l_oWv.setValue('LinkedField',WtA('CODDIP','C'));
l_oWv.setValue('UID',WtA('AVHTGZTOSZ','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['AVHTGZTOSZ'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('1270140318'),'C'));
return l_oWv;
}
function Link_MSGBKOOAOY(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_COLLEG);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('NUMPROG',w_COLLEG,11,0);
l_Appl.SetFields('NUMPROG');
l_Appl.SetTypes('C');
l_Appl.LinkTable('operazbo');
l_Appl.SetLinkzoom('armt_operazioni');
l_Appl.SetID('MSGBKOOAOY');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_COLLEG=l_Appl.GetStringValue('NUMPROG',11,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_MSGBKOOAOY_Blank();
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
function Link_MSGBKOOAOY_Blank() {
w_COLLEG='';
}
function LOpt_MSGBKOOAOY() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('operazbo','C'));
l_oWv.setValue('Linkzoomprg',WtA('armt_operazioni','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('NUMPROG','C'));
l_oWv.setValue('LinkedField',WtA('NUMPROG','C'));
l_oWv.setValue('UID',WtA('MSGBKOOAOY','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['MSGBKOOAOY'][1],'C'));
return l_oWv;
}
function Link_LKEDJRUQJU(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CODVOC);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODVOC',w_CODVOC,2,0);
l_Appl.SetFields('CODVOC,DESCRIZ');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbcausin');
l_Appl.SetID('LKEDJRUQJU');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CODVOC=l_Appl.GetStringValue('CODVOC',2,0);
w_xdesccausin=l_Appl.GetStringValue('DESCRIZ',165,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_LKEDJRUQJU_Blank();
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
function Link_LKEDJRUQJU_Blank() {
w_CODVOC='';
w_xdesccausin='';
}
function LOpt_LKEDJRUQJU() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcausin','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODVOC','C'));
l_oWv.setValue('LinkedField',WtA('CODVOC','C'));
l_oWv.setValue('UID',WtA('LKEDJRUQJU','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['LKEDJRUQJU'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('282420974'),'C'));
return l_oWv;
}
function Link_XPSJTIMTNR(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_idcitta);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('IDBASE',w_idcitta,10,0);
l_Appl.SetFields('IDBASE,CAB,PROV,CAP');
l_Appl.SetTypes('C,C,C,C');
l_Appl.LinkTable('tbcitta');
l_Appl.SetID('XPSJTIMTNR');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_idcitta=l_Appl.GetStringValue('IDBASE',10,0);
w_CODCAB=l_Appl.GetStringValue('CAB',6,0);
w_PROVINCIA=l_Appl.GetStringValue('PROV',2,0);
w_CAP=l_Appl.GetStringValue('CAP',9,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_XPSJTIMTNR_Blank();
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
function Link_XPSJTIMTNR_Blank() {
w_idcitta='';
w_CODCAB='';
w_PROVINCIA='';
w_CAP='';
}
function LOpt_XPSJTIMTNR() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcitta','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('IDBASE','C'));
l_oWv.setValue('LinkedField',WtA('IDBASE','C'));
l_oWv.setValue('UID',WtA('XPSJTIMTNR','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['XPSJTIMTNR'][1],'C'));
return l_oWv;
}
function Link_LVYFMQXNZH(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_VLTPLAT);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('VPCODICE',w_VLTPLAT,2,0);
l_Appl.SetFields('VPCODICE');
l_Appl.SetTypes('C');
l_Appl.LinkTable('cgo_vltplat');
l_Appl.SetLinkzoom('armt_cgo_vltplat');
l_Appl.SetID('LVYFMQXNZH');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_VLTPLAT=l_Appl.GetStringValue('VPCODICE',2,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_LVYFMQXNZH_Blank();
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
function Link_LVYFMQXNZH_Blank() {
w_VLTPLAT='';
}
function LOpt_LVYFMQXNZH() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('cgo_vltplat','C'));
l_oWv.setValue('Linkzoomprg',WtA('armt_cgo_vltplat','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('VPCODICE','C'));
l_oWv.setValue('LinkedField',WtA('VPCODICE','C'));
l_oWv.setValue('UID',WtA('LVYFMQXNZH','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['LVYFMQXNZH'][1],'C'));
return l_oWv;
}
function Link_DKNVEJCFAA(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_TIPOGIOCO);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODTPGIO',w_TIPOGIOCO,3,0);
l_Appl.SetFields('CODTPGIO,SOGTPGIO,DEFTPGIO,EDTTPGIO,EDTSPGIO,DEFSPGIO,FLGPLGIO');
l_Appl.SetTypes('C,N,C,C,C,C,C');
l_Appl.LinkTable('cgo_tbtipgio');
l_Appl.SetLinkzoom('armt_cgo_tbtipgio');
l_Appl.SetID('DKNVEJCFAA');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_TIPOGIOCO=l_Appl.GetStringValue('CODTPGIO',3,0);
w_xSOGTPGIO=l_Appl.GetDoubleValue('SOGTPGIO',12,2);
w_xDEFTPGIO=l_Appl.GetStringValue('DEFTPGIO',1,0);
w_xEDTTPGIO=l_Appl.GetStringValue('EDTTPGIO',1,0);
w_xEDTSPGIO=l_Appl.GetStringValue('EDTSPGIO',1,0);
w_xDEFSPGIO=l_Appl.GetStringValue('DEFSPGIO',1,0);
w_xFLGPLGIO=l_Appl.GetStringValue('FLGPLGIO',1,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_DKNVEJCFAA_Blank();
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
function Link_DKNVEJCFAA_Blank() {
w_TIPOGIOCO='';
w_xSOGTPGIO=0;
w_xDEFTPGIO='';
w_xEDTTPGIO='';
w_xEDTSPGIO='';
w_xDEFSPGIO='';
w_xFLGPLGIO='';
}
function LOpt_DKNVEJCFAA() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('cgo_tbtipgio','C'));
l_oWv.setValue('Linkzoomprg',WtA('armt_cgo_tbtipgio','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODTPGIO','C'));
l_oWv.setValue('LinkedField',WtA('CODTPGIO','C'));
l_oWv.setValue('UID',WtA('DKNVEJCFAA','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['DKNVEJCFAA'][1],'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
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
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'NEUBQNUEOJ')) {
return [Ctrl('NEUBQNUEOJ')];
}
if (Eq(varName,'HODZKKOSYW')) {
return [Ctrl('HODZKKOSYW')];
}
if (Eq(varName,'YVIKEGPYPM')) {
return [Ctrl('YVIKEGPYPM')];
}
if (Eq(varName,'ODAYKSRECA')) {
return [Ctrl('ODAYKSRECA')];
}
if (Eq(varName,'MBGANUUHRA')) {
return [Ctrl('MBGANUUHRA')];
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
bResult=arfn_form_cf(w_CODFISC,w_COGNOME,w_NOME,w_DATANASC,w_NASCOMUN,w_NASSTATO,w_SESSO,w_CFESTERO,w_TIPINTER);
if ( ! (bResult)) {
m_cLastMsgError=AlertErrorMessage('1209108021');
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
parent.ZtVWeb.raiseEventToEvalParms('armt_cgo_oper_storico_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('armt_cgo_oper_storico_dataNotSent',{'action':formaction});
}
}
}
}
CheckChild.child=[{'prg':"ardt_cgo_oper_storico_multi",'BOScId':function(){ return FrameRef('ardt_cgo_oper_storico_multi')},'repeated':0}];
function Check() {
var l_bResult = true;
var l_bChildCheck = true;
ResetErrorVars();
m_nLastError=0;
if ( ! (_ChkObl('YLIKFVPZJA',1))) {
_SignErr('YLIKFVPZJA');
m_cLastWorkVarErrorMsg='829201110';
l_bResult=false;
w_DATAOPE=HtW('','D');
} else if ( ! (_ChkObl('PURPSXEVAI',1))) {
_SignErr('PURPSXEVAI');
m_cLastWorkVarErrorMsg='237632211';
l_bResult=false;
w_FLAGCONT=HtW('','C');
} else if ( ! (_ChkObl('WJQFIEBCQV',1))) {
_SignErr('WJQFIEBCQV');
m_cLastWorkVarErrorMsg='1814604627';
l_bResult=false;
w_CACODICE=HtW('','N');
} else if ((false) && ( ! (_ChkObl('HUAGBHPUNH',1)))) {
_SignErr('HUAGBHPUNH','11419822357');
l_bResult=false;
w_TOTLIRE=HtW('','N');
} else if ((Eq(w_FLAGCONT,'1')) && ( ! (_ChkObl('HUDOCMLKKT',1)))) {
_SignErr('HUDOCMLKKT');
m_cLastWorkVarErrorMsg='10943726013';
l_bResult=false;
w_TOTCONT=HtW('','N');
} else if ((Eq(w_xEDTTPGIO,'S')) && ( ! (_ChkObl('SFKJNKYLJO',1)))) {
_SignErr('SFKJNKYLJO');
m_cLastWorkVarErrorMsg='11256417841';
l_bResult=false;
w_CGOFLGVLT=HtW('','C');
} else if ((Ne(w_TOTLIRE,w_TOTCONT)) && ( ! (_ChkObl('EOSKLIUGBC',1)))) {
_SignErr('EOSKLIUGBC');
m_cLastWorkVarErrorMsg='10651434988';
l_bResult=false;
w_MEZPAGAM=HtW('','C');
} else if ( ! (_ChkObl('CZTHKEDVCO',1))) {
_SignErr('CZTHKEDVCO');
m_cLastWorkVarErrorMsg='10034405761';
l_bResult=false;
w_CFESTERO=0;
} else if (( ! (_ChkObl('OJJHIUDPFY',1))) || ( ! (arfn_chkcodfis(w_CODFISC,'086',w_CFESTERO)))) {
_SignErr('OJJHIUDPFY','1715238713');
l_bResult=false;
w_CODFISC=HtW('','C');
} else if ( ! (_ChkObl('TWTTDWKCRG',1))) {
_SignErr('TWTTDWKCRG');
m_cLastWorkVarErrorMsg='1816546867';
l_bResult=false;
w_COGNOME=HtW('','C');
} else if ( ! (_ChkObl('WWGIVGNUDW',1))) {
_SignErr('WWGIVGNUDW');
m_cLastWorkVarErrorMsg='443454';
l_bResult=false;
w_NOME=HtW('','C');
} else if ( ! (_ChkObl('NEUBQNUEOJ',1))) {
_SignErr('NEUBQNUEOJ');
m_cLastWorkVarErrorMsg='12123334500';
l_bResult=false;
w_NASCOMUN=HtW('','C');
} else if ( ! (_ChkObl('KPSCOABZLB',1))) {
_SignErr('KPSCOABZLB');
m_cLastWorkVarErrorMsg='3528304';
l_bResult=false;
w_TIPINTER=HtW('','C');
} else if ( ! (_ChkObl('QPALJZMFCL',1))) {
_SignErr('QPALJZMFCL');
m_cLastWorkVarErrorMsg='7776675';
l_bResult=false;
w_SESSO=HtW('','C');
} else if ( ! (_ChkObl('HODZKKOSYW',1))) {
_SignErr('HODZKKOSYW');
m_cLastWorkVarErrorMsg='12123284333';
l_bResult=false;
w_NASSTATO=HtW('','C');
} else if ( ! (_ChkObl('XMGRWGFSFV',1))) {
_SignErr('XMGRWGFSFV');
m_cLastWorkVarErrorMsg='11777527481';
l_bResult=false;
w_DATANASC=HtW('','D');
} else if ( ! (_ChkObl('YVIKEGPYPM',1))) {
_SignErr('YVIKEGPYPM');
m_cLastWorkVarErrorMsg='7776403';
l_bResult=false;
w_PAESE=HtW('','C');
} else if ((Eq(w_PAESE,'086')) && ( ! (_ChkObl('ODAYKSRECA',1)))) {
_SignErr('ODAYKSRECA');
m_cLastWorkVarErrorMsg='15186643';
l_bResult=false;
w_DESCCIT=HtW('','C');
} else if ((Eq(w_PAESE,'086')) && ( ! (_ChkObl('NOTZPDMYIA',1)))) {
_SignErr('NOTZPDMYIA');
m_cLastWorkVarErrorMsg='10095365423';
l_bResult=false;
w_PROVINCIA=HtW('','C');
} else if ((Eq(w_PAESE,'086')) && ( ! (_ChkObl('RDAVOEETJG',1)))) {
_SignErr('RDAVOEETJG');
m_cLastWorkVarErrorMsg='21587';
l_bResult=false;
w_CAP=HtW('','C');
} else if ((Eq(w_PAESE,'086')) && ( ! (_ChkObl('VYLHWTRQNX',1)))) {
_SignErr('VYLHWTRQNX');
m_cLastWorkVarErrorMsg='554236824';
l_bResult=false;
w_DOMICILIO=HtW('','C');
} else if ( ! (_ChkObl('MBGANUUHRA',1))) {
_SignErr('MBGANUUHRA');
m_cLastWorkVarErrorMsg='11429032151';
l_bResult=false;
w_TIPODOC=HtW('','C');
} else if ( ! (_ChkObl('HVEEMUJUUY',1))) {
_SignErr('HVEEMUJUUY');
m_cLastWorkVarErrorMsg='1734932797';
l_bResult=false;
w_NUMDOCUM=HtW('','C');
} else if ( ! (_ChkObl('XHWYGOPPUN',1))) {
_SignErr('XHWYGOPPUN');
m_cLastWorkVarErrorMsg='1608394306';
l_bResult=false;
w_DATARILASC=HtW('','D');
} else if ( ! (_ChkObl('BNWXBPSIDG',1))) {
_SignErr('BNWXBPSIDG');
m_cLastWorkVarErrorMsg='1216938285';
l_bResult=false;
w_DATAVALI=HtW('','D');
} else if ( ! (_ChkObl('HRNCPADUFU',1))) {
_SignErr('HRNCPADUFU');
m_cLastWorkVarErrorMsg='10032163180';
l_bResult=false;
w_AUTRILASC=HtW('','C');
} else if ((false) && ( ! (_ChkObl('XFUOZLSACP',1)))) {
_SignErr('XFUOZLSACP');
m_cLastWorkVarErrorMsg='11993248424';
l_bResult=false;
w_SNAINUMOPE=HtW('','C');
} else if ( ! (_ChkObl('BSSRUASCBR',1))) {
_SignErr('BSSRUASCBR');
m_cLastWorkVarErrorMsg='MIDBIGLIETTO';
l_bResult=false;
w_MIDBIGLIETTO=HtW('','M');
} else if ( ! (_ChkObl('KZWBLPQNHU',1))) {
_SignErr('KZWBLPQNHU');
m_cLastWorkVarErrorMsg='1984809585';
l_bResult=false;
w_ASSEGNO=HtW('','C');
} else if ( ! (_ChkObl('UTUCDPQJKK',1))) {
_SignErr('UTUCDPQJKK','11525797640');
l_bResult=false;
w_IBAN=HtW('','C');
} else if ( ! (_ChkObl('FKEAKFSYVU',1))) {
_SignErr('FKEAKFSYVU');
m_cLastWorkVarErrorMsg='11642408994';
l_bResult=false;
w_CC4CIFRE=HtW('','C');
} else if ( ! (_ChkObl('OXFYJQLTDL',1))) {
_SignErr('OXFYJQLTDL');
m_cLastWorkVarErrorMsg='11857312893';
l_bResult=false;
w_CCDATSCA=HtW('','C');
} else if ( ! (_ChkObl('KSZEHVQAGY',1))) {
_SignErr('KSZEHVQAGY');
m_cLastWorkVarErrorMsg='10574713661';
l_bResult=false;
w_NUMTEL=HtW('','C');
} else if ( ! (Check_NXWIUCGNDI(true))) {
l_bResult = false;
} else if ( ! (Check_YHNSLBLWFP(true))) {
l_bResult = false;
} else if ( ! (Check_QNEKQYKSHZ(true))) {
l_bResult = false;
}
if (l_bResult) {
l_bResult=CheckChild(0);
}
// * --- Area Manuale = UI - Check Form
// * --- armt_cgo_oper_storico
if (l_bResult) {
  if (w_CGOFLGVLT=='S' || w_CGOFLGVNP=='S') {
    if (w_MEZPAGAM != 'E' && w_MEZPAGAM != 'I' && w_MEZPAGAM != 'C') {
      m_cLastMsgError='Obbligatorio Bonifico o Assegno Circolare se pagamento effettuato dal Concessionario'
      l_bResult=false
    }
  }  
}

if (l_bResult) {
  if (w_TOTLIRE <= 1000) {
      m_cLastMsgError='Importo totale deve essere uguale o superiore a \u20ac 1.000,00'
      l_bResult=false
  }
}

if (l_bResult) {
  if (Empty(w_ASSEGNO) && (w_MEZPAGAM == 'C' || w_MEZPAGAM == 'B')) {
    alert('E\' obbligatorio inserire il numero dell\'assegno')
  }
}  

if (l_bResult) {
  arrt_cgo_calc_multiid([['pObj',this]]);
  l_bReport=true;
}
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('YLIKFVPZJA_ZOOM',lc)) {
return 0;
}
if (Eq('NEUBQNUEOJ_ZOOM',lc)) {
return 0;
}
if (Eq('NEUBQNUEOJ',lc)) {
return 0;
}
if (Eq('HODZKKOSYW_ZOOM',lc)) {
return 1;
}
if (Eq('HODZKKOSYW',lc)) {
return 1;
}
if (Eq('XMGRWGFSFV_ZOOM',lc)) {
return 2;
}
if (Eq('YVIKEGPYPM_ZOOM',lc)) {
return 2;
}
if (Eq('YVIKEGPYPM',lc)) {
return 2;
}
if (Eq('ODAYKSRECA_ZOOM',lc)) {
return 3;
}
if (Eq('ODAYKSRECA',lc)) {
return 3;
}
if (Eq('XHWYGOPPUN_ZOOM',lc)) {
return 4;
}
if (Eq('BNWXBPSIDG_ZOOM',lc)) {
return 4;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_NEUBQNUEOJ();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,1)) {
l_oWv=LOpt_HODZKKOSYW();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,2)) {
l_oWv=LOpt_YVIKEGPYPM();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,3)) {
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
}
function FillWv() {
var l_oWv = InitWvApplet();
l_oWv.setValue('m_CheckVars',JSON.stringify(m_CheckVars));
l_oWv.setValue('CGOTIPOPE',WtA(w_CGOTIPOPE,'C'));
l_oWv.setValue('CAIDBIGLIETTO',WtA(w_CAIDBIGLIETTO,'C'));
l_oWv.setValue('DATAOPE',WtA(w_DATAOPE,'D'));
l_oWv.setValue('FLAGCONT',WtA(w_FLAGCONT,'C'));
l_oWv.setValue('CACODICE',WtA(w_CACODICE,'N'));
l_oWv.setValue('CAFLGOPE',WtA(w_CAFLGOPE,'C'));
l_oWv.setValue('TOTLIRE',WtA(w_TOTLIRE,'N'));
l_oWv.setValue('TOTCONT',WtA(w_TOTCONT,'N'));
l_oWv.setValue('CGOFLGVLT',WtA(w_CGOFLGVLT,'C'));
l_oWv.setValue('CGOFLGVNP',WtA(w_CGOFLGVNP,'C'));
l_oWv.setValue('MEZPAGAM',WtA(w_MEZPAGAM,'C'));
l_oWv.setValue('CFESTERO',WtA(w_CFESTERO,'N'));
l_oWv.setValue('CODFISC',WtA(w_CODFISC,'C'));
l_oWv.setValue('COGNOME',WtA(w_COGNOME,'C'));
l_oWv.setValue('NOME',WtA(w_NOME,'C'));
l_oWv.setValue('NASCOMUN',WtA(w_NASCOMUN,'C'));
l_oWv.setValue('TIPINTER',WtA(w_TIPINTER,'C'));
l_oWv.setValue('SESSO',WtA(w_SESSO,'C'));
l_oWv.setValue('NASSTATO',WtA(w_NASSTATO,'C'));
l_oWv.setValue('DATANASC',WtA(w_DATANASC,'D'));
l_oWv.setValue('PAESE',WtA(w_PAESE,'C'));
l_oWv.setValue('DESCCIT',WtA(w_DESCCIT,'C'));
l_oWv.setValue('PROVINCIA',WtA(w_PROVINCIA,'C'));
l_oWv.setValue('CAP',WtA(w_CAP,'C'));
l_oWv.setValue('DOMICILIO',WtA(w_DOMICILIO,'C'));
l_oWv.setValue('TIPODOC',WtA(w_TIPODOC,'C'));
l_oWv.setValue('NUMDOCUM',WtA(w_NUMDOCUM,'C'));
l_oWv.setValue('DATARILASC',WtA(w_DATARILASC,'D'));
l_oWv.setValue('DATAVALI',WtA(w_DATAVALI,'D'));
l_oWv.setValue('AUTRILASC',WtA(w_AUTRILASC,'C'));
l_oWv.setValue('ATTIV',WtA(w_ATTIV,'C'));
l_oWv.setValue('TIPOPERS',WtA(w_TIPOPERS,'C'));
l_oWv.setValue('RAGSOC',WtA(w_RAGSOC,'C'));
l_oWv.setValue('SOTGRUP',WtA(w_SOTGRUP,'C'));
l_oWv.setValue('RAMOGRUP',WtA(w_RAMOGRUP,'C'));
l_oWv.setValue('SETTSINT',WtA(w_SETTSINT,'C'));
l_oWv.setValue('SNAINUMOPE',WtA(w_SNAINUMOPE,'C'));
l_oWv.setValue('op_SNAINUMOPE',WtA(op_SNAINUMOPE,'C'));
l_oWv.setValue('DATAREG',WtA(w_DATAREG,'D'));
l_oWv.setValue('TIPOOPRAP',WtA(w_TIPOOPRAP,'C'));
l_oWv.setValue('CODANA',WtA(w_CODANA,'C'));
l_oWv.setValue('CODVOC',WtA(w_CODVOC,'C'));
l_oWv.setValue('VALUTA',WtA(w_VALUTA,'C'));
l_oWv.setValue('CAMBIO',WtA(w_CAMBIO,'N'));
l_oWv.setValue('CONNESCLI',WtA(w_CONNESCLI,'C'));
l_oWv.setValue('CONNESBEN',WtA(w_CONNESBEN,'C'));
l_oWv.setValue('C_RAG',WtA(w_C_RAG,'C'));
l_oWv.setValue('C_CTA',WtA(w_C_CTA,'C'));
l_oWv.setValue('C_PRV',WtA(w_C_PRV,'C'));
l_oWv.setValue('C_CAP',WtA(w_C_CAP,'C'));
l_oWv.setValue('C_CAB',WtA(w_C_CAB,'C'));
l_oWv.setValue('C_IND',WtA(w_C_IND,'C'));
l_oWv.setValue('C_STA',WtA(w_C_STA,'C'));
l_oWv.setValue('CODINTER',WtA(w_CODINTER,'C'));
l_oWv.setValue('CODDIPE',WtA(w_CODDIPE,'C'));
l_oWv.setValue('DESCCITDIP',WtA(w_DESCCITDIP,'C'));
l_oWv.setValue('SEGNO',WtA(w_SEGNO,'C'));
l_oWv.setValue('FLAGFRAZ',WtA(w_FLAGFRAZ,'C'));
l_oWv.setValue('COLLEG',WtA(w_COLLEG,'C'));
l_oWv.setValue('PROVINCIADIP',WtA(w_PROVINCIADIP,'C'));
l_oWv.setValue('CODCABDIP',WtA(w_CODCABDIP,'C'));
l_oWv.setValue('CODCAB',WtA(w_CODCAB,'C'));
l_oWv.setValue('PEP',WtA(w_PEP,'C'));
l_oWv.setValue('VLTPLAT',WtA(w_VLTPLAT,'C'));
l_oWv.setValue('TIPOGIOCO',WtA(w_TIPOGIOCO,'C'));
l_oWv.setValue('ASSEGNO',WtA(w_ASSEGNO,'C'));
l_oWv.setValue('IBAN',WtA(w_IBAN,'C'));
l_oWv.setValue('CC4CIFRE',WtA(w_CC4CIFRE,'C'));
l_oWv.setValue('CCDATSCA',WtA(w_CCDATSCA,'C'));
l_oWv.setValue('NUMTEL',WtA(w_NUMTEL,'C'));
l_oWv.setValue('IDDOCALL',WtA(w_IDDOCALL,'C'));
l_oWv.setValue('FLGDOCALL',WtA(w_FLGDOCALL,'C'));
l_oWv.setValue('xSOGTPGIO',WtA(w_xSOGTPGIO,'N'));
l_oWv.setValue('xDEFTPGIO',WtA(w_xDEFTPGIO,'C'));
l_oWv.setValue('xEDTTPGIO',WtA(w_xEDTTPGIO,'C'));
l_oWv.setValue('dessta',WtA(w_dessta,'C'));
l_oWv.setValue('tipsot',WtA(w_tipsot,'C'));
l_oWv.setValue('STATOREG',WtA(w_STATOREG,'C'));
l_oWv.setValue('IDBASE',WtA(w_IDBASE,'C'));
l_oWv.setValue('NUMPROG',WtA(w_NUMPROG,'C'));
l_oWv.setValue('DESCRI',WtA(w_DESCRI,'C'));
l_oWv.setValue('gSeekAos',WtA(w_gSeekAos,'C'));
l_oWv.setValue('gDataVaria',WtA(w_gDataVaria,'D'));
l_oWv.setValue('gFlgDoc',WtA(w_gFlgDoc,'C'));
l_oWv.setValue('gIntemediario',WtA(w_gIntemediario,'C'));
l_oWv.setValue('xDescDipe',WtA(w_xDescDipe,'C'));
l_oWv.setValue('datpaseuro',WtA(w_datpaseuro,'D'));
l_oWv.setValue('xdes1',WtA(w_xdes1,'C'));
l_oWv.setValue('desccauana',WtA(w_desccauana,'C'));
l_oWv.setValue('CITINT',WtA(w_CITINT,'C'));
l_oWv.setValue('CITDIP',WtA(w_CITDIP,'C'));
l_oWv.setValue('PROVDIP',WtA(w_PROVDIP,'C'));
l_oWv.setValue('CABDIP',WtA(w_CABDIP,'C'));
l_oWv.setValue('PROVINT',WtA(w_PROVINT,'C'));
l_oWv.setValue('CABINT',WtA(w_CABINT,'C'));
l_oWv.setValue('xdesccausin',WtA(w_xdesccausin,'C'));
l_oWv.setValue('gChkDate',WtA(w_gChkDate,'C'));
l_oWv.setValue('idcitta',WtA(w_idcitta,'C'));
l_oWv.setValue('xdesctipatt',WtA(w_xdesctipatt,'C'));
l_oWv.setValue('gVLT',WtA(w_gVLT,'N'));
l_oWv.setValue('gVNP',WtA(w_gVNP,'N'));
l_oWv.setValue('gCodDip',WtA(w_gCodDip,'C'));
l_oWv.setValue('gStpDwn',WtA(w_gStpDwn,'C'));
l_oWv.setValue('MIDBIGLIETTO',WtA(w_MIDBIGLIETTO,'M'));
l_oWv.setValue('xFLGPLGIO',WtA(w_xFLGPLGIO,'C'));
l_oWv.setValue('xDEFSPGIO',WtA(w_xDEFSPGIO,'C'));
l_oWv.setValue('xEDTSPGIO',WtA(w_xEDTSPGIO,'C'));
l_oWv.setValue('gGesDoc',WtA(w_gGesDoc,'C'));
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
_FillChildren.n=['ardt_cgo_oper_storico_multi'];
FillWv.n=["CGOTIPOPE","CAIDBIGLIETTO","DATAOPE","FLAGCONT","CACODICE","CAFLGOPE","TOTLIRE","TOTCONT","CGOFLGVLT","CGOFLGVNP","MEZPAGAM","CFESTERO","CODFISC","COGNOME","NOME","NASCOMUN","TIPINTER","SESSO","NASSTATO","DATANASC","PAESE","DESCCIT","PROVINCIA","CAP","DOMICILIO","TIPODOC","NUMDOCUM","DATARILASC","DATAVALI","AUTRILASC","ATTIV","TIPOPERS","RAGSOC","SOTGRUP","RAMOGRUP","SETTSINT","SNAINUMOPE","DATAREG","TIPOOPRAP","CODANA","CODVOC","VALUTA","CAMBIO","CONNESCLI","CONNESBEN","C_RAG","C_CTA","C_PRV","C_CAP","C_CAB","C_IND","C_STA","CODINTER","CODDIPE","DESCCITDIP","SEGNO","FLAGFRAZ","COLLEG","PROVINCIADIP","CODCABDIP","CODCAB","PEP","VLTPLAT","TIPOGIOCO","ASSEGNO","IBAN","CC4CIFRE","CCDATSCA","NUMTEL","IDDOCALL","FLGDOCALL","xSOGTPGIO","xDEFTPGIO","xEDTTPGIO","dessta","tipsot","STATOREG","IDBASE","NUMPROG","DESCRI","gSeekAos","gDataVaria","gFlgDoc","gIntemediario","xDescDipe","datpaseuro","xdes1","desccauana","CITINT","CITDIP","PROVDIP","CABDIP","PROVINT","CABINT","xdesccausin","gChkDate","idcitta","xdesctipatt","gVLT","gVNP","gCodDip","gStpDwn","MIDBIGLIETTO","xFLGPLGIO","xDEFSPGIO","xEDTSPGIO","gGesDoc"];
function SetModified() {
m_bUpdated=true;
}
function SetChildVariables_ardt_cgo_oper_storico_multi() {
if ( ! (ChildToLoad(FrameRef('ardt_cgo_oper_storico_multi'))) && Ne(typeof(FrameRef('ardt_cgo_oper_storico_multi').DoUpdate),'undefined')) {
CopyWorkVar(FrameRef('ardt_cgo_oper_storico_multi'),['CGOTIPOPE'],['CGOTIPOPE'],false)
}
}
function CtxLoad_ardt_cgo_oper_storico_multi() {
if (ChildToLoad(FrameRef('ardt_cgo_oper_storico_multi'))) {
return [LoadContext(0,'AAHJPBZVGL'),'ardt_cgo_oper_storico_multi'];
}
}
