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
function DisplayErrorMessage_armt_cgo_qadv_operazioni() {
if ( ! (ChildToLoad(FrameRef('armt_cgo_qadv_operazioni'))) && Ne(typeof(FrameRef('armt_cgo_qadv_operazioni').DisplayErrorMessage),'undefined')) {
FrameRef('armt_cgo_qadv_operazioni').DisplayErrorMessage();
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
l_bEnabled= ! (Eq(w_FLAGCONT,'1') &&  ! (Empty(w_DATAOPE))) || IsDisabledByStateDriver('TOTCONT');
SetDisabled('HUDOCMLKKT',l_bEnabled);
l_bEnabled= ! (Eq(w_FLAGWALLET,'1') &&  ! (Empty(w_DATAOPE))) || IsDisabledByStateDriver('IMPWALLET');
SetDisabled('BELMGUMGMW',l_bEnabled);
l_bEnabled= ! (Eq(w_FLAGWALLET,'1') &&  ! (Empty(w_DATAOPE))) || IsDisabledByStateDriver('CODWALLET');
SetDisabled('LQVQUGYYJF',l_bEnabled);
l_bEnabled= ! (Eq(w_FLAGWALLET,'1') &&  ! (Empty(w_DATAOPE))) || IsDisabledByStateDriver('CODTRANSZ');
SetDisabled('YYELCZIDWS',l_bEnabled);
l_bEnabled= ! ((Eq(w_xEDTTPGIO,'S') && Ge(w_TOTLIRE,w_xSOGTPGIO)) || (Eq(w_xEDTSPGIO,'S') && Lt(w_TOTLIRE,w_xSOGTPGIO))) || IsDisabledByStateDriver('CGOFLGVLT');
SetDisabled('SFKJNKYLJO_DIV',l_bEnabled);
l_bEnabled= ! (Gt(w_TOTLIRE-(w_TOTCONT+w_IMPWALLET),0)) || IsDisabledByStateDriver('MEZPAGAM');
SetDisabled('EOSKLIUGBC',l_bEnabled);
l_bEnabled= ! ( ! (Empty(w_CODFISC)));
SetDisabled('DERAHXASAL',l_bEnabled);
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
l_bEnabled= ! (false) || IsDisabledByStateDriver('CAIDBIGLIETTO');
SetDisabled('BMTLGIUQTH',l_bEnabled);
l_bEnabled= ! ( ! (Empty(w_COGNOME)) &&  ! (Empty(w_NOME)) &&  ! (Empty(LRTrim(w_NASCOMUN)+LRTrim(w_NASSTATO))) &&  ! (Empty(w_SESSO)) &&  ! (Empty(w_DATANASC)));
SetDisabled('RQVPEKINIU',l_bEnabled);
l_bEnabled= ! (Eq(w_PEP,'S')) || IsDisabledByStateDriver('PEPDESCRI');
SetDisabled('DAEHHCRYAM',l_bEnabled);
l_bEnabled= ! (Eq(w_FLGDOM,'S')) || IsDisabledByStateDriver('PAESE2');
SetDisabled('UOOQYQWWNG',l_bEnabled);
SetDisabled(Ctrl('UOOQYQWWNG_ZOOM'),l_bEnabled);
l_bEnabled= ! (Eq(w_PAESE2,'086') && Eq(w_FLGDOM,'S')) || IsDisabledByStateDriver('DESCCIT2');
SetDisabled('BVEIQEJCLQ',l_bEnabled);
SetDisabled(Ctrl('BVEIQEJCLQ_ZOOM'),l_bEnabled);
l_bEnabled= ! (Eq(w_PAESE,'086') && Eq(w_FLGDOM,'S')) || IsDisabledByStateDriver('PROVINCIA2');
SetDisabled('NKJDWBKDWM',l_bEnabled);
l_bEnabled= ! (Eq(w_PAESE2,'086') && Eq(w_FLGDOM,'S')) || IsDisabledByStateDriver('CAP2');
SetDisabled('MDTHUZMSSI',l_bEnabled);
l_bEnabled= ! (Eq(w_PAESE2,'086') && Eq(w_FLGDOM,'S')) || IsDisabledByStateDriver('DOMICILIO2');
SetDisabled('CWOLOHZAQW',l_bEnabled);
l_bEnabled= ! (false) || IsDisabledByStateDriver('FLGQADVFULL');
SetDisabled('XMHFFKJFDF',l_bEnabled);
l_bEnabled= ! (false) || IsDisabledByStateDriver('CODDIPE');
SetDisabled('AVHTGZTOSZ',l_bEnabled);
l_bEnabled= ! (false) || IsDisabledByStateDriver('CGONOTCON');
SetDisabled('MVSSLZXHUW',l_bEnabled);
if (IsDisabledByStateDriver('Base')) {
DisableInputsInContainer(Ctrl('CCUOYXMBZC'),true);
}
if (IsDisabledByStateDriver('Operazione')) {
DisableInputsInContainer(Ctrl('YORQOIOBQN'),true);
}
if (IsDisabledByStateDriver('Soggetto')) {
DisableInputsInContainer(Ctrl('AQSQVBKXAL'),true);
}
if (IsDisabledByStateDriver('Documenti')) {
DisableInputsInContainer(Ctrl('XWJLXLYKJC'),true);
}
if (IsDisabledByStateDriver('Contatto')) {
DisableInputsInContainer(Ctrl('NYSCBMMEEX'),true);
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
SetObligatory(Ctrl('BELMGUMGMW'),Eq(w_FLAGWALLET,'1') || IsObligatoryByStateDriver('IMPWALLET'));
SetObligatory(Ctrl('LQVQUGYYJF'),Eq(w_FLAGWALLET,'1') || IsObligatoryByStateDriver('CODWALLET'));
SetObligatory(Ctrl('YYELCZIDWS'),Eq(w_FLAGWALLET,'1') || IsObligatoryByStateDriver('CODTRANSZ'));
SetObligatory(Ctrl('EOSKLIUGBC'),Gt(w_TOTLIRE-(w_TOTCONT+w_IMPWALLET),0) || IsObligatoryByStateDriver('MEZPAGAM'));
SetObligatory(Ctrl('FKEAKFSYVU'),Eq(w_MEZPAGAM,'V') || IsObligatoryByStateDriver('CC4CIFRE'));
SetObligatory(Ctrl('MFCMVHMGSB'),Eq(w_MEZPAGAM,'V') || IsObligatoryByStateDriver('CCMESSCA'));
SetObligatory(Ctrl('YZHCHEDWZM'),Eq(w_MEZPAGAM,'V') || IsObligatoryByStateDriver('CCANNSCA'));
SetObligatory(Ctrl('UTUCDPQJKK'),Eq(w_MEZPAGAM,'I') || Eq(w_MEZPAGAM,'E') || Eq(w_MEZPAGAM,'P') || IsObligatoryByStateDriver('IBAN'));
SetObligatory(Ctrl('KZWBLPQNHU'),(Eq(w_MEZPAGAM,'C') || Eq(w_MEZPAGAM,'B')) && (Ne(w_CGOFLGVLT,'S')) || IsObligatoryByStateDriver('ASSEGNO'));
SetObligatory(Ctrl('OJJHIUDPFY'),Eq(w_CFESTERO,0) || IsObligatoryByStateDriver('CODFISC'));
SetObligatory(Ctrl('NEUBQNUEOJ'),Empty(w_NASSTATO) || IsObligatoryByStateDriver('NASCOMUN'));
SetObligatory(Ctrl('HODZKKOSYW'),Empty(w_NASCOMUN) || IsObligatoryByStateDriver('NASSTATO'));
SetObligatory(Ctrl('ODAYKSRECA'),Eq(w_PAESE,'086') || IsObligatoryByStateDriver('DESCCIT'));
SetObligatory(Ctrl('NOTZPDMYIA'),Eq(w_PAESE,'086') || IsObligatoryByStateDriver('PROVINCIA'));
SetObligatory(Ctrl('RDAVOEETJG'),Eq(w_PAESE,'086') || IsObligatoryByStateDriver('CAP'));
SetObligatory(Ctrl('VYLHWTRQNX'),Eq(w_PAESE,'086') || IsObligatoryByStateDriver('DOMICILIO'));
SetObligatory(Ctrl('DAEHHCRYAM'),Eq(w_PEP,'S') || IsObligatoryByStateDriver('PEPDESCRI'));
SetObligatory(Ctrl('UOOQYQWWNG'),Eq(w_FLGDOM,'S') || IsObligatoryByStateDriver('PAESE2'));
SetObligatory(Ctrl('BVEIQEJCLQ'),Eq(w_PAESE2,'086') && Eq(w_FLGDOM,'S') || IsObligatoryByStateDriver('DESCCIT2'));
SetObligatory(Ctrl('NKJDWBKDWM'),Eq(w_PAESE,'086') && Eq(w_FLGDOM,'S') || IsObligatoryByStateDriver('PROVINCIA2'));
SetObligatory(Ctrl('MDTHUZMSSI'),Eq(w_PAESE2,'086') && Eq(w_FLGDOM,'S') || IsObligatoryByStateDriver('CAP2'));
SetObligatory(Ctrl('CWOLOHZAQW'),Eq(w_PAESE2,'086') && Eq(w_FLGDOM,'S') || IsObligatoryByStateDriver('DOMICILIO2'));
SetObligatory(Ctrl('XFPPPEOSWP'),Eq(w_xCGOFLGPROF,'S') || IsObligatoryByStateDriver('PROFESSIONE'));
}
function SetDynamicClasses() {
var c;
}
function SetDynamicTooltip() {
var c;
}
function Set_ANA_FOUND(ctrlValue,kmode,e) {
if (Ne(w_ANA_FOUND,ctrlValue)) {
var ctl = _GetCtl(e,'NWDPKKZGVO');
if (_tracker.goon(ctl,ctrlValue)) {
w_ANA_FOUND=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NWDPKKZGVO',0);
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
function Set_DOMICILIO2(ctrlValue,kmode,e) {
if (Ne(w_DOMICILIO2,ctrlValue)) {
var ctl = _GetCtl(e,'CWOLOHZAQW');
if (_tracker.goon(ctl,ctrlValue)) {
w_DOMICILIO2=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CWOLOHZAQW',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('CWOLOHZAQW',function(){return WtH(w_DOMICILIO2,'C',35,0,'!')},w_DOMICILIO2);
return l_bResult;
} else {
ctl.value=WtH('','C',35,0,'!');
_ResetTracker();
return true;
}
}
return true;
}
function Set_CAP2(ctrlValue,kmode,e) {
if (Ne(w_CAP2,ctrlValue)) {
var ctl = _GetCtl(e,'MDTHUZMSSI');
if (_tracker.goon(ctl,ctrlValue)) {
w_CAP2=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MDTHUZMSSI',0);
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
function Set_DESCCIT2(ctrlValue,kmode,e) {
if (Ne(w_DESCCIT2,ctrlValue)) {
var ctl = _GetCtl(e,'BVEIQEJCLQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_DESCCIT2=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BVEIQEJCLQ',0);
if (l_bResult) {
l_bResult=Link_BVEIQEJCLQ(kmode);
if ( ! (l_bResult)) {
w_DESCCIT2=HtW('','C');
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
function Set_PAESE2(ctrlValue,kmode,e) {
if (Ne(w_PAESE2,ctrlValue)) {
var ctl = _GetCtl(e,'UOOQYQWWNG');
if (_tracker.goon(ctl,ctrlValue)) {
w_PAESE2=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UOOQYQWWNG',0);
if (l_bResult) {
l_bResult=Link_UOOQYQWWNG(kmode);
if ( ! (l_bResult)) {
w_PAESE2=HtW('','C');
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
function Set_CONNESCLI(ctrlValue,kmode,e) {
if (Ne(w_CONNESCLI,ctrlValue)) {
var ctl = _GetCtl(e,'QBLXDBODXR');
if (_tracker.goon(ctl,ctrlValue)) {
w_CONNESCLI=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QBLXDBODXR',0);
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
function Set_PEPDESCRI(ctrlValue,kmode,e) {
if (Ne(w_PEPDESCRI,ctrlValue)) {
var ctl = _GetCtl(e,'DAEHHCRYAM');
if (_tracker.goon(ctl,ctrlValue)) {
w_PEPDESCRI=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('DAEHHCRYAM',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',80,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_RDLOCAUT(ctrlValue,kmode,e) {
if (Ne(w_RDLOCAUT,ctrlValue)) {
var ctl = _GetCtl(e,'MPRHMTBSXX');
if (_tracker.goon(ctl,ctrlValue)) {
w_RDLOCAUT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MPRHMTBSXX',0);
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
function Set_RDCODAUT(ctrlValue,kmode,e) {
if (Ne(w_RDCODAUT,ctrlValue)) {
var ctl = _GetCtl(e,'YDUQCBNYFV');
if (_tracker.goon(ctl,ctrlValue)) {
w_RDCODAUT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YDUQCBNYFV',0);
if (l_bResult) {
l_bResult=Link_YDUQCBNYFV(kmode);
if ( ! (l_bResult)) {
w_RDCODAUT=HtW('','C');
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
function Set_DATAVALI(ctrlValue,kmode,e) {
if (Ne(w_DATAVALI,ctrlValue)) {
var ctl = _GetCtl(e,'BNWXBPSIDG');
if (_tracker.goon(ctl,ctrlValue)) {
w_DATAVALI=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BNWXBPSIDG',0);
if (l_bResult) {
l_bResult=arfn_cgo_chkdata(w_DATAVALI,w_TIPODOC,'S',w_DATAOPE);
if ( ! (l_bResult)) {
m_nLastError=2;
m_cLastWorkVarErrorMsg='1216938285';
m_cLastMsgError=AlertErrorMessage('11525797640');
}
if ( ! (l_bResult)) {
w_DATAVALI=HtW('','D');
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
function Set_TOTCONT(ctrlValue,kmode,e) {
if (Ne(w_TOTCONT,ctrlValue)) {
var ctl = _GetCtl(e,'HUDOCMLKKT');
if (_tracker.goon(ctl,ctrlValue)) {
w_TOTCONT=ValidNum(ctrlValue,'999999999999.99');
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HUDOCMLKKT',0);
if (l_bResult) {
l_bResult=arfn_chktotalelire_cont(w_DATAOPE,w_datpaseuro,w_TOTCONT,w_TOTLIRE);
if ( ! (l_bResult)) {
m_nLastError=2;
m_cLastWorkVarErrorMsg='10943726013';
m_cLastMsgError=AlertErrorMessage('11525797640');
}
if ( ! (l_bResult)) {
w_TOTCONT=HtW('','N');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'N',15,2,'999999999999.99'));
} else {
_ResetTracker();
}
return l_bResult;
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
function Set_IMPWALLET(ctrlValue,kmode,e) {
if (Ne(w_IMPWALLET,ctrlValue)) {
var ctl = _GetCtl(e,'BELMGUMGMW');
if (_tracker.goon(ctl,ctrlValue)) {
w_IMPWALLET=ValidNum(ctrlValue,'999999999999.99');
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BELMGUMGMW',0);
if (l_bResult) {
l_bResult=Le(w_IMPWALLET,(w_TOTLIRE-w_TOTCONT));
if ( ! (l_bResult)) {
m_nLastError=2;
m_cLastWorkVarErrorMsg='1991861529';
m_cLastMsgError=AlertErrorMessage('1314928579');
}
if ( ! (l_bResult)) {
w_IMPWALLET=HtW('','N');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'N',12,2,'999999999999.99'));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','N',12,2,'999999999999.99');
_ResetTracker();
return true;
}
} else {
SPBOUILib.SetInputValue('BELMGUMGMW',function(){return WtH(w_IMPWALLET,'N',12,2,'999,999,999,999.99')},w_IMPWALLET);
}
return true;
}
function Set_CODWALLET(ctrlValue,kmode,e) {
if (Ne(w_CODWALLET,ctrlValue)) {
var ctl = _GetCtl(e,'LQVQUGYYJF');
if (_tracker.goon(ctl,ctrlValue)) {
w_CODWALLET=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('LQVQUGYYJF',0);
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
function Set_CODTRANSZ(ctrlValue,kmode,e) {
if (Ne(w_CODTRANSZ,ctrlValue)) {
var ctl = _GetCtl(e,'YYELCZIDWS');
if (_tracker.goon(ctl,ctrlValue)) {
w_CODTRANSZ=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YYELCZIDWS',0);
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
function Set_FLGPAGAM(ctrlValue,kmode,e) {
if (Ne(w_FLGPAGAM,ctrlValue)) {
var ctl = _GetCtl(e,'GRJCRZXDIK');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLGPAGAM=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('GRJCRZXDIK',0);
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
function Set_FILTROMP(ctrlValue,kmode,e) {
if (Ne(w_FILTROMP,ctrlValue)) {
var ctl = _GetCtl(e,'EKBMRGBOJG');
if (_tracker.goon(ctl,ctrlValue)) {
w_FILTROMP=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('EKBMRGBOJG',0);
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
function Set_CC4CIFRE(ctrlValue,kmode,e) {
if (Ne(w_CC4CIFRE,ctrlValue)) {
var ctl = _GetCtl(e,'FKEAKFSYVU');
if (_tracker.goon(ctl,ctrlValue)) {
w_CC4CIFRE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FKEAKFSYVU',0);
if (l_bResult) {
l_bResult=arfn_cgo_chkcc(w_CC4CIFRE,w_DATAOPE,w_CCMESSCA,w_CCANNSCA,1,w_MEZPAGAM);
if ( ! (l_bResult)) {
m_nLastError=2;
m_cLastWorkVarErrorMsg='11642408298';
m_cLastMsgError=AlertErrorMessage('11525797640');
}
if ( ! (l_bResult)) {
w_CC4CIFRE=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',4,0,''));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',4,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_CCMESSCA(ctrlValue,kmode,e) {
if (Ne(w_CCMESSCA,ctrlValue)) {
var ctl = _GetCtl(e,'MFCMVHMGSB');
if (_tracker.goon(ctl,ctrlValue)) {
w_CCMESSCA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MFCMVHMGSB',0);
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
function Set_CCANNSCA(ctrlValue,kmode,e) {
if (Ne(w_CCANNSCA,ctrlValue)) {
var ctl = _GetCtl(e,'YZHCHEDWZM');
if (_tracker.goon(ctl,ctrlValue)) {
w_CCANNSCA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YZHCHEDWZM',0);
if (l_bResult) {
l_bResult=arfn_cgo_chkcc(w_CC4CIFRE,w_DATAOPE,w_CCMESSCA,w_CCANNSCA,2,w_MEZPAGAM);
if ( ! (l_bResult)) {
m_nLastError=2;
m_cLastWorkVarErrorMsg='1444804436';
m_cLastMsgError=AlertErrorMessage('11525797640');
}
if ( ! (l_bResult)) {
w_CCANNSCA=HtW('','N');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'N',4,0,''));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','N',4,0,'');
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
if (l_bResult) {
l_bResult=arfn_chkiban(Upper(w_IBAN),w_MEZPAGAM);
if ( ! (l_bResult)) {
m_nLastError=2;
m_cLastWorkVarErrorMsg='737507602';
m_cLastMsgError=AlertErrorMessage('11525797640');
}
if ( ! (l_bResult)) {
w_IBAN=HtW('','C');
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
if (l_bResult) {
l_bResult=arfn_maggiorenne(w_DATANASC,w_DATAOPE);
if ( ! (l_bResult)) {
m_nLastError=2;
m_cLastWorkVarErrorMsg='11777527481';
m_cLastMsgError=AlertErrorMessage('11525797640');
}
if ( ! (l_bResult)) {
w_DATANASC=HtW('','D');
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
if ( ! (Empty(w_DESCCIT2))) {
Link_BVEIQEJCLQ(kmode);
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
function Set_DATARILASC(ctrlValue,kmode,e) {
if (Ne(w_DATARILASC,ctrlValue)) {
var ctl = _GetCtl(e,'XHWYGOPPUN');
if (_tracker.goon(ctl,ctrlValue)) {
w_DATARILASC=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XHWYGOPPUN',0);
if (l_bResult) {
l_bResult=arfn_cgo_chkdata(w_DATARILASC,w_TIPODOC,'R',w_DATAOPE);
if ( ! (l_bResult)) {
m_nLastError=2;
m_cLastWorkVarErrorMsg='1608394306';
m_cLastMsgError=AlertErrorMessage('11525797640');
}
if ( ! (l_bResult)) {
w_DATARILASC=HtW('','D');
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
var ctl = _GetCtl(e,'VFKGHJLVGB');
if (_tracker.goon(ctl,ctrlValue)) {
w_NUMTEL=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VFKGHJLVGB',0);
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
function Set_DOC04(ctrlValue,kmode,e) {
if (Ne(w_DOC04,ctrlValue)) {
var ctl = _GetCtl(e,'SIRTAMVPQN');
if (_tracker.goon(ctl,ctrlValue)) {
w_DOC04=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SIRTAMVPQN',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',80,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_PROFESSIONE(ctrlValue,kmode,e) {
if (Ne(w_PROFESSIONE,ctrlValue)) {
var ctl = _GetCtl(e,'XFPPPEOSWP');
if (_tracker.goon(ctl,ctrlValue)) {
w_PROFESSIONE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XFPPPEOSWP',0);
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
function Set_NUMOPEDL(ctrlValue,kmode,e) {
if (Ne(w_NUMOPEDL,ctrlValue)) {
var ctl = _GetCtl(e,'HILLZZMRNQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_NUMOPEDL=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HILLZZMRNQ',0);
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
function Set_FLGDOM(ctrlValue,kmode,e) {
if (Ne(w_FLGDOM,ctrlValue)) {
var ctl = _GetCtl(e,'ZJPDUNZSZL');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLGDOM=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ZJPDUNZSZL',0);
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
function Set_FLGQADVFULL(ctrlValue,kmode,e) {
if (Ne(w_FLGQADVFULL,ctrlValue)) {
var ctl = _GetCtl(e,'XMHFFKJFDF');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLGQADVFULL=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XMHFFKJFDF',0);
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
function Set_tipop(ctrlValue,kmode,e) {
if (Ne(w_tipop,ctrlValue)) {
var ctl = _GetCtl(e,'OZGWRQKOZF');
if (_tracker.goon(ctl,ctrlValue)) {
w_tipop=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('OZGWRQKOZF',0);
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
function Set_DOC03(ctrlValue,kmode,e) {
if (Ne(w_DOC03,ctrlValue)) {
var ctl = _GetCtl(e,'PAADFVDPUD');
if (_tracker.goon(ctl,ctrlValue)) {
w_DOC03=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('PAADFVDPUD',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',80,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_FLAGWALLET(ctrlValue,kmode,e) {
if (Ne(w_FLAGWALLET,ctrlValue)) {
var ctl = _GetCtl(e,'DWJVPXTRND');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLAGWALLET=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('DWJVPXTRND',0);
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
function Set_CODDIPE(ctrlValue,kmode,e) {
if (Ne(w_CODDIPE,ctrlValue)) {
var ctl = _GetCtl(e,'AVHTGZTOSZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_CODDIPE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('AVHTGZTOSZ',0);
if (l_bResult) {
l_bResult=Link_AVHTGZTOSZ(kmode);
if ( ! (l_bResult)) {
w_CODDIPE=HtW('','C');
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
function Set_CAIDBIGLIETTO(ctrlValue,kmode,e) {
if (Ne(w_CAIDBIGLIETTO,ctrlValue)) {
var ctl = _GetCtl(e,'BMTLGIUQTH');
if (_tracker.goon(ctl,ctrlValue)) {
w_CAIDBIGLIETTO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BMTLGIUQTH',0);
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
function Set_saveddoc(ctrlValue,kmode,e) {
if (Ne(w_saveddoc,ctrlValue)) {
var ctl = _GetCtl(e,'NVJDAQQRWF');
if (_tracker.goon(ctl,ctrlValue)) {
w_saveddoc=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NVJDAQQRWF',0);
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
function Set_FLGDOCALL(ctrlValue,kmode,e) {
if (Ne(w_FLGDOCALL,ctrlValue)) {
var ctl = _GetCtl(e,'ZUVVNOUSIQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLGDOCALL=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ZUVVNOUSIQ',0);
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
function Set_CGONOTCON(ctrlValue,kmode,e) {
if (Ne(w_CGONOTCON,ctrlValue)) {
var ctl = _GetCtl(e,'MVSSLZXHUW');
if (_tracker.goon(ctl,ctrlValue)) {
w_CGONOTCON=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MVSSLZXHUW',0);
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
function Set_PROVINCIA2(ctrlValue,kmode,e) {
if (Ne(w_PROVINCIA2,ctrlValue)) {
var ctl = _GetCtl(e,'NKJDWBKDWM');
if (_tracker.goon(ctl,ctrlValue)) {
w_PROVINCIA2=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NKJDWBKDWM',0);
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
function Set_verifica(ctrlValue,kmode,e) {
if (Ne(w_verifica,ctrlValue)) {
var ctl = _GetCtl(e,'PUBAAWPVMH');
if (_tracker.goon(ctl,ctrlValue)) {
w_verifica=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('PUBAAWPVMH',0);
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
if ((Ne(o_TIPOGIOCO,w_TIPOGIOCO))) {
l_bTmpRes=Link_QZTTRBWAQL(null);
}
w_TIPOPERS='P';
if ((Ne(o_TOTLIRE,w_TOTLIRE)) || (Ne(o_TOTCONT,w_TOTCONT)) || (Ne(o_FILTROMP,w_FILTROMP)) || (Ne(o_CGOFLGVLT,w_CGOFLGVLT)) || (Ne(o_IMPWALLET,w_IMPWALLET)) || (Ne(o_FILTROMP,w_FILTROMP)) || (Ne(o_FLGPAGAM,w_FLGPAGAM))) {
RenderDynamicCombo('EOSKLIUGBC');
}
if ((Ne(o_CGOFLGVLT,w_CGOFLGVLT)) || (Ne(o_TOTLIRE,w_TOTLIRE)) || (Ne(o_TOTCONT,w_TOTCONT))) {
w_FLGPAGAM=w_CGOFLGVLT;
}
if ((Ne(o_TOTLIRE,w_TOTLIRE)) || (Ne(o_TOTCONT,w_TOTCONT))) {
w_FILTROMP=(Ne((w_TOTCONT+w_IMPWALLET),w_TOTLIRE)?'\'I\',\'E\',\'P\',\'B\',\'C\',\'V\'':'\'I\',\'E\',\'P\',\'B\',\'C\',\'V\',\'S\',\'W\'');
}
if ((Ne(o_idcitta,w_idcitta))) {
l_bTmpRes=Link_XPSJTIMTNR(null);
}
if ((Ne(o_ATTIV,w_ATTIV))) {
l_bTmpRes=Link_SAQTIHOALW(null);
}
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
w_CONNESBEN=w_CODFISC;
l_bTmpRes=Link_ULVCBLFVEU(null);
if ((Ne(o_CONNESBEN,w_CONNESBEN)) || (Ne(o_C_CTA,w_C_CTA))) {
l_bTmpRes=Link_KUPRRTVLKH(null);
}
w_CODINTER=w_gIntemediario;
l_bTmpRes=Link_WJSVGWKSFC(null);
if ((Ne(o_COLLEG,w_COLLEG))) {
l_bTmpRes=Link_MSGBKOOAOY(null);
}
if ((Ne(o_CODINTER,w_CODINTER)) || (Ne(o_CODDIPE,w_CODDIPE))) {
Calculation_WKUMXNRIRT();
}
if ((Ne(o_CODVOC,w_CODVOC))) {
l_bTmpRes=Link_LKEDJRUQJU(null);
}
if ((Ne(o_NASCOMUN,w_NASCOMUN)) || (Ne(o_TIPINTER,w_TIPINTER))) {
Calculation_QQIFZZEGJS();
}
if ((Ne(o_CACODICE,w_CACODICE))) {
l_bTmpRes=Link_WJQFIEBCQV(null);
}
if ((Ne(o_PAESE,w_PAESE))) {
Calculation_BUOAEINKPC();
}
if ((Ne(o_MEZPAGAM,w_MEZPAGAM))) {
Calculation_YQDKHNZKNZ();
}
if ((Ne(o_FLAGCONT,w_FLAGCONT)) || (Ne(o_FLAGWALLET,w_FLAGWALLET))) {
Calculation_JVLUWJLOKL();
}
if ((Ne(o_CODFISC,w_CODFISC))) {
Calculation_CMDOBQAJRA();
}
if ((Ne(o_TOTLIRE,w_TOTLIRE)) || (Ne(o_TOTCONT,w_TOTCONT)) || (Ne(o_IMPWALLET,w_IMPWALLET))) {
Calculation_OCENIGMBXJ();
}
w_edtdoc=Empty(w_IDDOCALL) || Empty(w_TIPOGIOCO) || Le(w_TOTLIRE,0) || (Eq(w_FLAGCONT,'1') && Le(w_TOTCONT,0)) || (Eq(w_FLAGWALLET,'1') && Le(w_IMPWALLET,0));
w_AUTRILASC=Upper(LRTrim(w_xARDESCRI)+' '+LRTrim(w_RDLOCAUT));
if ((Ne(o_idcitta2,w_idcitta2))) {
l_bTmpRes=Link_HNAYMCHXMY(null);
}
if ((Ne(o_PAESE2,w_PAESE2))) {
Calculation_JOFLKSCHRI();
}
if ((Ne(o_PAESE,w_PAESE))) {
Calculation_GAIJOLNWVG();
}
if ((Ne(o_PAESE2,w_PAESE2))) {
Calculation_GHVEEQUKJN();
}
w_PrtDocAll.Calculate(w_IDDOCALL,w_TIPOGIOCO,w_TOTLIRE,w_TOTCONT,w_FLGDOCALL,w_DOC03,w_DOC04,w_CAIDBIGLIETTO);
LibJavascript.forEachItem(m_FoundlingCopyWorkVar,i_body_1)
function i_body_1(child){
child();
}
// * --- Area Manuale = UI - Calculate
// * --- Fine Area Manuale
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
function Calculation_YQDKHNZKNZ() {
w_IBAN=((Eq(w_MEZPAGAM,'I') || Eq(w_MEZPAGAM,'E') || Eq(w_MEZPAGAM,'P'))?w_IBAN:Space(27));
}
function Calculation_JVLUWJLOKL() {
w_TOTCONT=(Eq(w_FLAGCONT,'0')?0:w_TOTCONT);
w_IMPWALLET=(Eq(w_FLAGWALLET,'0')?0:w_IMPWALLET);
}
function Calculation_CMDOBQAJRA() {
arrt_cgo_read_flgope([])
}
function Calculation_OCENIGMBXJ() {
w_MEZPAGAM=(Eq(w_TOTLIRE,w_TOTCONT)?'S':(Eq(w_TOTLIRE,w_IMPWALLET)?'W':''));
}
function Calculation_DIXETYMKJA() {
arrt_cgo_setpagatore_c([["pObj",this]])
}
function Calculation_JOFLKSCHRI() {
w_PROVINCIA2=( ! (Empty(w_PROVINCIA2))?w_PROVINCIA2:(Ne(w_PAESE2,'086')?'EE':''));
}
function Calculation_GAIJOLNWVG() {
w_DESCCIT=( ! (Empty(w_PAESE)) && Ne(w_PAESE,'086')?'':w_DESCCIT);
w_CAP=( ! (Empty(w_PAESE)) && Ne(w_PAESE,'086')?'':w_CAP);
w_DOMICILIO=( ! (Empty(w_PAESE)) && Ne(w_PAESE,'086')?'':w_DOMICILIO);
w_CODCAB=( ! (Empty(w_PAESE)) && Ne(w_PAESE,'086')?'':w_CODCAB);
w_PROVINCIA=( ! (Empty(w_PAESE)) && Ne(w_PAESE,'086')?'':w_PROVINCIA);
}
function Calculation_GHVEEQUKJN() {
w_DESCCIT2=( ! (Empty(w_PAESE2)) && Ne(w_PAESE2,'086')?'':w_DESCCIT2);
w_CAP2=( ! (Empty(w_PAESE2)) && Ne(w_PAESE2,'086')?'':w_CAP2);
w_DOMICILIO2=( ! (Empty(w_PAESE2)) && Ne(w_PAESE2,'086')?'':w_DOMICILIO2);
w_PROVINCIA2=( ! (Empty(w_PAESE2)) && Ne(w_PAESE2,'086')?'':w_PROVINCIA2);
}
function Check_NXWIUCGNDI(p_bForce) {
var l_bResult = true;
if (p_bForce || Ne(o_DATARILASC,w_DATARILASC) || Ne(o_DATAOPE,w_DATAOPE)) {
l_bResult=( ! (Empty(w_DATARILASC)) &&  ! (Empty(w_DATAOPE))?Ge(w_DATAOPE,w_DATARILASC):true);
if ( ! (l_bResult)) {
m_cLastMsgError=AlertErrorMessage('819587209');
}
}
return l_bResult;
}
function Check_YHNSLBLWFP(p_bForce) {
var l_bResult = true;
if (p_bForce || Ne(o_DATAVALI,w_DATAVALI) || Ne(o_DATAOPE,w_DATAOPE)) {
l_bResult=( ! (Empty(w_DATAVALI)) &&  ! (Empty(w_DATAOPE))?Le(w_DATAOPE,w_DATAVALI):true);
if ( ! (l_bResult)) {
m_cLastMsgError=AlertErrorMessage('187973133');
}
}
return l_bResult;
}
function Check_QNEKQYKSHZ(p_bForce) {
var l_bResult = true;
if (p_bForce || Ne(o_DATARILASC,w_DATARILASC) || Ne(o_DATAVALI,w_DATAVALI)) {
l_bResult=( ! (Empty(w_DATAVALI)) &&  ! (Empty(w_DATARILASC))?Le(w_DATARILASC,w_DATAVALI):true);
if ( ! (l_bResult)) {
m_cLastMsgError=AlertErrorMessage('1518802369');
}
}
return l_bResult;
}
function SaveDependsOn() {
o_TIPOGIOCO=w_TIPOGIOCO;
o_TOTLIRE=w_TOTLIRE;
o_TOTCONT=w_TOTCONT;
o_IMPWALLET=w_IMPWALLET;
o_CGOFLGVLT=w_CGOFLGVLT;
o_MEZPAGAM=w_MEZPAGAM;
o_FLGPAGAM=w_FLGPAGAM;
o_FILTROMP=w_FILTROMP;
o_CODFISC=w_CODFISC;
o_COGNOME=w_COGNOME;
o_NOME=w_NOME;
o_NASCOMUN=w_NASCOMUN;
o_TIPINTER=w_TIPINTER;
o_NASSTATO=w_NASSTATO;
o_PAESE=w_PAESE;
o_idcitta=w_idcitta;
o_ATTIV=w_ATTIV;
o_SOTGRUP=w_SOTGRUP;
o_DATAOPE=w_DATAOPE;
o_FLAGCONT=w_FLAGCONT;
o_FLAGWALLET=w_FLAGWALLET;
o_TIPOOPRAP=w_TIPOOPRAP;
o_CODANA=w_CODANA;
o_CODVOC=w_CODVOC;
o_CONNESBEN=w_CONNESBEN;
o_C_CTA=w_C_CTA;
o_CODINTER=w_CODINTER;
o_COLLEG=w_COLLEG;
o_CACODICE=w_CACODICE;
o_DATARILASC=w_DATARILASC;
o_DATAVALI=w_DATAVALI;
o_RDCODAUT=w_RDCODAUT;
o_RDLOCAUT=w_RDLOCAUT;
o_PAESE2=w_PAESE2;
o_idcitta2=w_idcitta2;
o_CODDIPE=w_CODDIPE;
}
function SaveLabelDependsOn() {
}
function Link_QZTTRBWAQL(kmode) {
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
l_Appl.SetID('QZTTRBWAQL');
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
Link_QZTTRBWAQL_Blank();
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
function Link_QZTTRBWAQL_Blank() {
w_TIPOGIOCO='';
w_xSOGTPGIO=0;
w_xDEFTPGIO='';
w_xEDTTPGIO='';
w_xEDTSPGIO='';
w_xDEFSPGIO='';
w_xFLGPLGIO='';
}
function LOpt_QZTTRBWAQL() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('cgo_tbtipgio','C'));
l_oWv.setValue('Linkzoomprg',WtA('armt_cgo_tbtipgio','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODTPGIO','C'));
l_oWv.setValue('LinkedField',WtA('CODTPGIO','C'));
l_oWv.setValue('UID',WtA('QZTTRBWAQL','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['QZTTRBWAQL'][1],'C'));
return l_oWv;
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
if (l_bResult &&  ! (Empty(w_PAESE) && l_bEmp)) {
l_bResult=(Eq(w_CFESTERO,1) && Eq(w_PAESE,'086')?false:(Eq(w_CFESTERO,0) && Ne(w_PAESE,'086')?false:true));
if ( ! (l_bResult)) {
Link_YVIKEGPYPM_Blank();
}
}
if ( ! (l_bResult)) {
m_nLastError=3;
m_cLastWorkVarErrorMsg='';
if (Lt(l_nRec,0)) {
m_cLastMsgError=Translate('MSG_CONNECT_SERVER');
} else {
m_cLastMsgError=AlertErrorMessage('11529669945');
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
l_Appl.SetFields('CODINTER,DATANASC,CODCAB,PROVINCIA,DESCCIT,CGOFLGPROF');
l_Appl.SetTypes('C,D,C,C,C,C');
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
w_xCGOFLGPROF=l_Appl.GetStringValue('CGOFLGPROF',1,0);
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
w_xCGOFLGPROF='';
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
function Link_WJQFIEBCQV(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CACODICE);
var l_Appl = LinkApplet();
l_Appl.SetDoubleKey('CACODICE',w_CACODICE,5,0);
l_Appl.SetFields('CACODICE,CAFLGOPE');
l_Appl.SetTypes('N,C');
l_Appl.LinkTable('cgo_causali');
l_Appl.SetLinkzoom('armt_cgo_causali');
l_Appl.SetID('WJQFIEBCQV');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CACODICE=l_Appl.GetDoubleValue('CACODICE',5,0);
w_CAFLGOPE=l_Appl.GetStringValue('CAFLGOPE',1,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_WJQFIEBCQV_Blank();
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
function Link_WJQFIEBCQV_Blank() {
w_CACODICE=0;
w_CAFLGOPE='';
}
function LOpt_WJQFIEBCQV() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('cgo_causali','C'));
l_oWv.setValue('Linkzoomprg',WtA('armt_cgo_causali','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CACODICE','C'));
l_oWv.setValue('LinkedField',WtA('CACODICE','C'));
l_oWv.setValue('UID',WtA('WJQFIEBCQV','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['WJQFIEBCQV'][1],'C'));
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
l_oWv.setValue('Caption',WtA(Translate('11429032151'),'C'));
return l_oWv;
}
function Link_YDUQCBNYFV(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_RDCODAUT);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('ARCODICE',w_RDCODAUT,2,0);
l_Appl.SetFields('ARCODICE,ARDESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('cgo_autorita');
l_Appl.SetLinkzoom('armt_cgo_autorita');
l_Appl.SetID('YDUQCBNYFV');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_RDCODAUT=l_Appl.GetStringValue('ARCODICE',2,0);
w_xARDESCRI=l_Appl.GetStringValue('ARDESCRI',15,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_YDUQCBNYFV_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_YDUQCBNYFV';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_YDUQCBNYFV();
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
if (l_bResult &&  ! (Empty(w_RDCODAUT) && l_bEmp)) {
l_bResult=arfn_chk_docaut(w_RDCODAUT,w_TIPODOC);
if ( ! (l_bResult)) {
Link_YDUQCBNYFV_Blank();
}
}
if ( ! (l_bResult)) {
m_nLastError=3;
m_cLastWorkVarErrorMsg='';
if (Lt(l_nRec,0)) {
m_cLastMsgError=Translate('MSG_CONNECT_SERVER');
} else {
m_cLastMsgError=AlertErrorMessage('1489090677');
}
}
}
return l_bResult;
}
function Link_YDUQCBNYFV_Blank() {
w_RDCODAUT='';
w_xARDESCRI='';
}
function LOpt_YDUQCBNYFV() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('cgo_autorita','C'));
l_oWv.setValue('Linkzoomprg',WtA('armt_cgo_autorita','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('ARCODICE','C'));
l_oWv.setValue('LinkedField',WtA('ARCODICE','C'));
l_oWv.setValue('UID',WtA('YDUQCBNYFV','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['YDUQCBNYFV'][1],'C'));
return l_oWv;
}
function Sugg_UOOQYQWWNG(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_Appl = LinkApplet();
var l_bEmp = Empty(HtW(Ctrl('UOOQYQWWNG').value,'C'));
l_Appl.SetStringKey('CODSTA',HtW(Ctrl('UOOQYQWWNG').value,'C'),3,0);
l_Appl.SetFields('CODSTA,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbstati');
l_Appl.SetID('UOOQYQWWNG');
l_Appl.SetMode('suggest');
l_Appl.SetRows('15');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
var res = l_Appl.GetJSONData();
SuggesterLib.render_suggest(res,'UOOQYQWWNG','UOOQYQWWNG',false,'AQSQVBKXAL_DIV','AQSQVBKXAL_HEADER',0);
return l_bResult;
}
SuggesterLib.select_suggest.UOOQYQWWNG=["PAESE2",[null,null],function(newval) { return HtW(newval,'C')}];
function Link_UOOQYQWWNG(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_PAESE2);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODSTA',w_PAESE2,3,0);
l_Appl.SetFields('CODSTA,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbstati');
l_Appl.SetID('UOOQYQWWNG');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_PAESE2=l_Appl.GetStringValue('CODSTA',3,0);
w_dessta2=l_Appl.GetStringValue('DESCRI',40,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_UOOQYQWWNG_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_UOOQYQWWNG';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_UOOQYQWWNG();
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
function Link_UOOQYQWWNG_Blank() {
w_PAESE2='';
w_dessta2='';
}
function LOpt_UOOQYQWWNG() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstati','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODSTA','C'));
l_oWv.setValue('LinkedField',WtA('CODSTA','C'));
l_oWv.setValue('UID',WtA('UOOQYQWWNG','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['UOOQYQWWNG'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('7383187'),'C'));
return l_oWv;
}
function Sugg_BVEIQEJCLQ(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_Appl = LinkApplet();
var l_bEmp = Empty(HtW(Ctrl('BVEIQEJCLQ').value,'C'));
l_Appl.SetStringKey('PKTBSTATI',w_PAESE,3,0);
l_Appl.SetStringKey('CITTA',HtW(Ctrl('BVEIQEJCLQ').value,'C'),40,0);
l_Appl.SetFields('CITTA,IDBASE');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbcitta');
l_Appl.SetID('BVEIQEJCLQ');
l_Appl.SetMode('suggest');
l_Appl.SetRows('15');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
var res = l_Appl.GetJSONData();
SuggesterLib.render_suggest(res,'BVEIQEJCLQ','BVEIQEJCLQ',false,'AQSQVBKXAL_DIV','AQSQVBKXAL_HEADER',0);
return l_bResult;
}
SuggesterLib.select_suggest.BVEIQEJCLQ=["DESCCIT2",[null,null],function(newval) { return HtW(newval,'C')}];
function Link_BVEIQEJCLQ(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_DESCCIT2);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('PKTBSTATI',w_PAESE,3,0);
l_Appl.SetStringKey('CITTA',w_DESCCIT2,40,0);
l_Appl.SetFields('CITTA,IDBASE');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbcitta');
l_Appl.SetID('BVEIQEJCLQ');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_DESCCIT2=l_Appl.GetStringValue('CITTA',40,0);
w_idcitta2=l_Appl.GetStringValue('IDBASE',10,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_BVEIQEJCLQ_Blank();
l_bResult=true;
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_BVEIQEJCLQ';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_BVEIQEJCLQ();
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
function Link_BVEIQEJCLQ_Blank() {
w_idcitta2='';
}
function LOpt_BVEIQEJCLQ() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcitta','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('PKTBSTATI,CITTA','C'));
l_oWv.setValue('LinkedField',WtA('CITTA','C'));
l_oWv.setValue('UID',WtA('BVEIQEJCLQ','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['BVEIQEJCLQ'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('15186643'),'C'));
return l_oWv;
}
function Link_HNAYMCHXMY(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_idcitta2);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('IDBASE',w_idcitta2,10,0);
l_Appl.SetFields('IDBASE,PROV,CAP');
l_Appl.SetTypes('C,C,C');
l_Appl.LinkTable('tbcitta');
l_Appl.SetID('HNAYMCHXMY');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_idcitta2=l_Appl.GetStringValue('IDBASE',10,0);
w_PROVINCIA2=l_Appl.GetStringValue('PROV',2,0);
w_CAP2=l_Appl.GetStringValue('CAP',9,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_HNAYMCHXMY_Blank();
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
function Link_HNAYMCHXMY_Blank() {
w_idcitta2='';
w_PROVINCIA2='';
w_CAP2='';
}
function LOpt_HNAYMCHXMY() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcitta','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('IDBASE','C'));
l_oWv.setValue('LinkedField',WtA('IDBASE','C'));
l_oWv.setValue('UID',WtA('HNAYMCHXMY','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['HNAYMCHXMY'][1],'C'));
return l_oWv;
}
function Link_AVHTGZTOSZ(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CODDIPE);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODDIP',w_CODDIPE,6,0);
l_Appl.SetFields('CODDIP,DESCRIZ,DESCCIT,PROVINCIA,CAB,TELEFONO,CODLOC');
l_Appl.SetTypes('C,C,C,C,C,C,C');
l_Appl.LinkTable('anadip');
l_Appl.SetID('AVHTGZTOSZ');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CODDIPE=l_Appl.GetStringValue('CODDIP',6,0);
w_xDescDipe=l_Appl.GetStringValue('DESCRIZ',30,0);
w_CITDIP=l_Appl.GetStringValue('DESCCIT',30,0);
w_PROVDIP=l_Appl.GetStringValue('PROVINCIA',2,0);
w_CABDIP=l_Appl.GetStringValue('CAB',6,0);
w_TELDIP=l_Appl.GetStringValue('TELEFONO',15,0);
w_CODLOC=l_Appl.GetStringValue('CODLOC',25,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_AVHTGZTOSZ_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_AVHTGZTOSZ';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_AVHTGZTOSZ();
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
function Link_AVHTGZTOSZ_Blank() {
w_CODDIPE='';
w_xDescDipe='';
w_CITDIP='';
w_PROVDIP='';
w_CABDIP='';
w_TELDIP='';
w_CODLOC='';
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
if (Eq(varName,'YDUQCBNYFV')) {
last_focused_comp=GetLastFocusedElementOfLink('YDUQCBNYFV');
function SetMethod_YDUQCBNYFV() {
Set_RDCODAUT(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_YDUQCBNYFV();
} else {
setTimeout(SetMethod_YDUQCBNYFV,1);
}
bResult=true;
}
if (Eq(varName,'UOOQYQWWNG')) {
last_focused_comp=GetLastFocusedElementOfLink('UOOQYQWWNG');
function SetMethod_UOOQYQWWNG() {
Set_PAESE2(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_UOOQYQWWNG();
} else {
setTimeout(SetMethod_UOOQYQWWNG,1);
}
bResult=true;
}
if (Eq(varName,'BVEIQEJCLQ')) {
last_focused_comp=GetLastFocusedElementOfLink('BVEIQEJCLQ');
function SetMethod_BVEIQEJCLQ() {
Set_DESCCIT2(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_BVEIQEJCLQ();
} else {
setTimeout(SetMethod_BVEIQEJCLQ,1);
}
bResult=true;
}
if (Eq(varName,'AVHTGZTOSZ')) {
last_focused_comp=GetLastFocusedElementOfLink('AVHTGZTOSZ');
function SetMethod_AVHTGZTOSZ() {
Set_CODDIPE(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_AVHTGZTOSZ();
} else {
setTimeout(SetMethod_AVHTGZTOSZ,1);
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
if (Eq(varName,'YDUQCBNYFV')) {
return [Ctrl('YDUQCBNYFV')];
}
if (Eq(varName,'UOOQYQWWNG')) {
return [Ctrl('UOOQYQWWNG')];
}
if (Eq(varName,'BVEIQEJCLQ')) {
return [Ctrl('BVEIQEJCLQ')];
}
if (Eq(varName,'AVHTGZTOSZ')) {
return [Ctrl('AVHTGZTOSZ')];
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
bResult=arfn_form_cf(w_CODFISC,w_COGNOME,w_NOME,w_DATANASC,w_NASCOMUN,w_NASSTATO,w_SESSO,w_CFESTERO,w_TIPINTER) && arfn_cgo_chkcap(w_CAP,'R') && arfn_cgo_chkcap(w_CAP2,'D');
if ( ! (bResult)) {
m_cLastMsgError=AlertErrorMessage('11525797640');
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
parent.ZtVWeb.raiseEventToEvalParms('armt_snai_oper_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('armt_snai_oper_dataNotSent',{'action':formaction});
}
}
}
}
CheckChild.child=[{'prg':"armt_cgo_qadv_operazioni",'BOScId':function(){ return FrameRef('armt_cgo_qadv_operazioni')},'repeated':0}];
function Check() {
var l_bResult = true;
var l_bChildCheck = true;
ResetErrorVars();
m_nLastError=0;
if ((Eq(w_FLAGCONT,'1') &&  ! (Empty(w_DATAOPE))) && (( ! (_ChkObl('HUDOCMLKKT',1))) || ( ! (arfn_chktotalelire_cont(w_DATAOPE,w_datpaseuro,w_TOTCONT,w_TOTLIRE))))) {
_SignErr('HUDOCMLKKT','11525797640');
l_bResult=false;
w_TOTCONT=HtW('','N');
} else if ((Eq(w_FLAGWALLET,'1') &&  ! (Empty(w_DATAOPE))) && (( ! (_ChkObl('BELMGUMGMW',1))) || ( ! (Le(w_IMPWALLET,(w_TOTLIRE-w_TOTCONT)))))) {
_SignErr('BELMGUMGMW','1314928579');
l_bResult=false;
w_IMPWALLET=HtW('','N');
} else if ((Eq(w_FLAGWALLET,'1') &&  ! (Empty(w_DATAOPE))) && ( ! (_ChkObl('LQVQUGYYJF',1)))) {
_SignErr('LQVQUGYYJF');
m_cLastWorkVarErrorMsg='92934247';
l_bResult=false;
w_CODWALLET=HtW('','C');
} else if ((Eq(w_FLAGWALLET,'1') &&  ! (Empty(w_DATAOPE))) && ( ! (_ChkObl('YYELCZIDWS',1)))) {
_SignErr('YYELCZIDWS');
m_cLastWorkVarErrorMsg='11517258780';
l_bResult=false;
w_CODTRANSZ=HtW('','C');
} else if (((Eq(w_xEDTTPGIO,'S') && Ge(w_TOTLIRE,w_xSOGTPGIO)) || (Eq(w_xEDTSPGIO,'S') && Lt(w_TOTLIRE,w_xSOGTPGIO))) && ( ! (_ChkObl('SFKJNKYLJO',1)))) {
_SignErr('SFKJNKYLJO');
m_cLastWorkVarErrorMsg='11262256689';
l_bResult=false;
w_CGOFLGVLT=HtW('','C');
} else if ((Gt(w_TOTLIRE-(w_TOTCONT+w_IMPWALLET),0)) && ( ! (_ChkObl('EOSKLIUGBC',1)))) {
_SignErr('EOSKLIUGBC');
m_cLastWorkVarErrorMsg='10651434988';
l_bResult=false;
w_MEZPAGAM=HtW('','C');
} else if ( ! (_ChkObl('GRJCRZXDIK',1))) {
_SignErr('GRJCRZXDIK');
m_cLastWorkVarErrorMsg='FLGPAGAM';
l_bResult=false;
w_FLGPAGAM=HtW('','C');
} else if ( ! (_ChkObl('EKBMRGBOJG',1))) {
_SignErr('EKBMRGBOJG');
m_cLastWorkVarErrorMsg='FILTROMP';
l_bResult=false;
w_FILTROMP=HtW('','C');
} else if (( ! (_ChkObl('FKEAKFSYVU',1))) || ( ! (arfn_cgo_chkcc(w_CC4CIFRE,w_DATAOPE,w_CCMESSCA,w_CCANNSCA,1,w_MEZPAGAM)))) {
_SignErr('FKEAKFSYVU','11525797640');
l_bResult=false;
w_CC4CIFRE=HtW('','C');
} else if ( ! (_ChkObl('MFCMVHMGSB',1))) {
_SignErr('MFCMVHMGSB');
m_cLastWorkVarErrorMsg='2025840209';
l_bResult=false;
w_CCMESSCA=HtW('','N');
} else if (( ! (_ChkObl('YZHCHEDWZM',1))) || ( ! (arfn_cgo_chkcc(w_CC4CIFRE,w_DATAOPE,w_CCMESSCA,w_CCANNSCA,2,w_MEZPAGAM)))) {
_SignErr('YZHCHEDWZM','11525797640');
l_bResult=false;
w_CCANNSCA=HtW('','N');
} else if (( ! (_ChkObl('UTUCDPQJKK',1))) || ( ! (arfn_chkiban(Upper(w_IBAN),w_MEZPAGAM)))) {
_SignErr('UTUCDPQJKK','11525797640');
l_bResult=false;
w_IBAN=HtW('','C');
} else if ( ! (_ChkObl('KZWBLPQNHU',1))) {
_SignErr('KZWBLPQNHU');
m_cLastWorkVarErrorMsg='1984809585';
l_bResult=false;
w_ASSEGNO=HtW('','C');
} else if ( ! (_ChkObl('CZTHKEDVCO',1))) {
_SignErr('CZTHKEDVCO');
m_cLastWorkVarErrorMsg='10034405761';
l_bResult=false;
w_CFESTERO=0;
} else if ( ! (_ChkObl('XFKXBQYUIU',1))) {
_SignErr('XFKXBQYUIU');
m_cLastWorkVarErrorMsg='1513560829';
l_bResult=false;
w_PEP='N';
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
} else if (( ! (_ChkObl('XMGRWGFSFV',1))) || ( ! (arfn_maggiorenne(w_DATANASC,w_DATAOPE)))) {
_SignErr('XMGRWGFSFV','11525797640');
l_bResult=false;
w_DATANASC=HtW('','D');
} else if (( ! (_ChkObl('YVIKEGPYPM',1))) || ( ! (Empty(w_PAESE)) &&  ! ((Eq(w_CFESTERO,1) && Eq(w_PAESE,'086')?false:(Eq(w_CFESTERO,0) && Ne(w_PAESE,'086')?false:true))))) {
_SignErr('YVIKEGPYPM','11529669945');
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
} else if ( ! (_ChkObl('VFKGHJLVGB',1))) {
_SignErr('VFKGHJLVGB');
m_cLastWorkVarErrorMsg='10574713661';
l_bResult=false;
w_NUMTEL=HtW('','C');
} else if ((false) && ( ! (_ChkObl('XFUOZLSACP',1)))) {
_SignErr('XFUOZLSACP');
m_cLastWorkVarErrorMsg='11993248424';
l_bResult=false;
w_SNAINUMOPE=HtW('','C');
} else if ( ! (_ChkObl('PURPSXEVAI',1))) {
_SignErr('PURPSXEVAI');
m_cLastWorkVarErrorMsg='237632211';
l_bResult=false;
w_FLAGCONT=HtW('','C');
} else if ( ! (_ChkObl('DWJVPXTRND',1))) {
_SignErr('DWJVPXTRND');
m_cLastWorkVarErrorMsg='647451330';
l_bResult=false;
w_FLAGWALLET=HtW('','C');
} else if ( ! (_ChkObl('QBLXDBODXR',1))) {
_SignErr('QBLXDBODXR');
m_cLastWorkVarErrorMsg='10219814530';
l_bResult=false;
w_CONNESCLI=HtW('','C');
} else if ((false) && ( ! (_ChkObl('BMTLGIUQTH',1)))) {
_SignErr('BMTLGIUQTH');
m_cLastWorkVarErrorMsg='10524120562';
l_bResult=false;
w_CAIDBIGLIETTO=HtW('','C');
} else if ( ! (_ChkObl('PUBAAWPVMH',1))) {
_SignErr('PUBAAWPVMH');
m_cLastWorkVarErrorMsg='verifica';
l_bResult=false;
w_verifica=HtW('','C');
} else if ( ! (_ChkObl('HILLZZMRNQ',1))) {
_SignErr('HILLZZMRNQ');
m_cLastWorkVarErrorMsg='11628234069';
l_bResult=false;
w_NUMOPEDL=HtW('','C');
} else if ( ! (_ChkObl('ZUVVNOUSIQ',1))) {
_SignErr('ZUVVNOUSIQ');
m_cLastWorkVarErrorMsg='674110294';
l_bResult=false;
w_FLGDOCALL=HtW('','C');
} else if ( ! (_ChkObl('PAADFVDPUD',1))) {
_SignErr('PAADFVDPUD');
m_cLastWorkVarErrorMsg='DOC03';
l_bResult=false;
w_DOC03=HtW('','C');
} else if ( ! (_ChkObl('SIRTAMVPQN',1))) {
_SignErr('SIRTAMVPQN');
m_cLastWorkVarErrorMsg='DOC04';
l_bResult=false;
w_DOC04=HtW('','C');
} else if ( ! (_ChkObl('OZGWRQKOZF',1))) {
_SignErr('OZGWRQKOZF');
m_cLastWorkVarErrorMsg='tipop';
l_bResult=false;
w_tipop=HtW('','C');
} else if ( ! (_ChkObl('NVJDAQQRWF',1))) {
_SignErr('NVJDAQQRWF');
m_cLastWorkVarErrorMsg='saveddoc';
l_bResult=false;
w_saveddoc=HtW('','C');
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
} else if (( ! (_ChkObl('XHWYGOPPUN',1))) || ( ! (arfn_cgo_chkdata(w_DATARILASC,w_TIPODOC,'R',w_DATAOPE)))) {
_SignErr('XHWYGOPPUN','11525797640');
l_bResult=false;
w_DATARILASC=HtW('','D');
} else if (( ! (_ChkObl('BNWXBPSIDG',1))) || ( ! (arfn_cgo_chkdata(w_DATAVALI,w_TIPODOC,'S',w_DATAOPE)))) {
_SignErr('BNWXBPSIDG','11525797640');
l_bResult=false;
w_DATAVALI=HtW('','D');
} else if (( ! (_ChkObl('YDUQCBNYFV',1))) || ( ! (Empty(w_RDCODAUT)) &&  ! (arfn_chk_docaut(w_RDCODAUT,w_TIPODOC)))) {
_SignErr('YDUQCBNYFV','1489090677');
l_bResult=false;
w_RDCODAUT=HtW('','C');
} else if ( ! (_ChkObl('MPRHMTBSXX',1))) {
_SignErr('MPRHMTBSXX');
m_cLastWorkVarErrorMsg='1475053609';
l_bResult=false;
w_RDLOCAUT=HtW('','C');
} else if ((Eq(w_PEP,'S')) && ( ! (_ChkObl('DAEHHCRYAM',1)))) {
_SignErr('DAEHHCRYAM');
m_cLastWorkVarErrorMsg='1705711075';
l_bResult=false;
w_PEPDESCRI=HtW('','C');
} else if ((Eq(w_FLGDOM,'S')) && ( ! (_ChkObl('UOOQYQWWNG',1)))) {
_SignErr('UOOQYQWWNG');
m_cLastWorkVarErrorMsg='11401314672';
l_bResult=false;
w_PAESE2=HtW('','C');
} else if ((Eq(w_PAESE2,'086') && Eq(w_FLGDOM,'S')) && ( ! (_ChkObl('BVEIQEJCLQ',1)))) {
_SignErr('BVEIQEJCLQ');
m_cLastWorkVarErrorMsg='11393904432';
l_bResult=false;
w_DESCCIT2=HtW('','C');
} else if ((Eq(w_PAESE,'086') && Eq(w_FLGDOM,'S')) && ( ! (_ChkObl('NKJDWBKDWM',1)))) {
_SignErr('NKJDWBKDWM');
m_cLastWorkVarErrorMsg='10095365423';
l_bResult=false;
w_PROVINCIA2=HtW('','C');
} else if ((Eq(w_PAESE2,'086') && Eq(w_FLGDOM,'S')) && ( ! (_ChkObl('MDTHUZMSSI',1)))) {
_SignErr('MDTHUZMSSI');
m_cLastWorkVarErrorMsg='21587';
l_bResult=false;
w_CAP2=HtW('','C');
} else if ((Eq(w_PAESE2,'086') && Eq(w_FLGDOM,'S')) && ( ! (_ChkObl('CWOLOHZAQW',1)))) {
_SignErr('CWOLOHZAQW');
m_cLastWorkVarErrorMsg='453879700';
l_bResult=false;
w_DOMICILIO2=HtW('','C');
} else if ( ! (_ChkObl('ZJPDUNZSZL',1))) {
_SignErr('ZJPDUNZSZL');
m_cLastWorkVarErrorMsg='1319025851';
l_bResult=false;
w_FLGDOM='N';
} else if ((false) && ( ! (_ChkObl('XMHFFKJFDF',1)))) {
_SignErr('XMHFFKJFDF');
m_cLastWorkVarErrorMsg='FLGQADVFULL';
l_bResult=false;
w_FLGQADVFULL='N';
} else if ( ! (_ChkObl('XFPPPEOSWP',1))) {
_SignErr('XFPPPEOSWP');
m_cLastWorkVarErrorMsg='178012863';
l_bResult=false;
w_PROFESSIONE=HtW('','C');
} else if ((false) && ( ! (_ChkObl('AVHTGZTOSZ',1)))) {
_SignErr('AVHTGZTOSZ');
m_cLastWorkVarErrorMsg='2071283709';
l_bResult=false;
w_CODDIPE=HtW('','C');
} else if ( ! (_ChkObl('NWDPKKZGVO',1))) {
_SignErr('NWDPKKZGVO');
m_cLastWorkVarErrorMsg='ANA_FOUND';
l_bResult=false;
w_ANA_FOUND=HtW('','C');
} else if ((false) && ( ! (_ChkObl('MVSSLZXHUW',1)))) {
_SignErr('MVSSLZXHUW');
m_cLastWorkVarErrorMsg='1405978050';
l_bResult=false;
w_CGONOTCON=HtW('','M');
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
// * --- armt_snai_oper
if (l_bResult) {
  if (w_CGOFLGVLT=='S') {
    if (w_MEZPAGAM != 'E' && w_MEZPAGAM != 'I' && w_MEZPAGAM != 'C') {
      m_cLastMsgError='Obbligatorio Bonifico o Assegno Circolare se pagamento effettuato dal Concessionario'
      l_bResult=false
    }
  }  
}

if (l_bResult) {
  if (Empty(w_ASSEGNO) && ((w_MEZPAGAM == 'C' || w_MEZPAGAM == 'B') && (w_CGOFLGVLT!='S'))) {
    if (confirm('Manca il numero assegno. Vuoi proseguire comunque ?')) {
    } else {
      l_bResult=false
    }
  }
} 

if (l_bResult) {
  if (w_gQADV=='S') {
    if (w_TIPOGIOCO=='V' && w_FLGQADVFULL=='N') {
      m_cLastMsgError='Obbligatorio completare il questoinario ADV prima di procedere'
      l_bResult=false
    }
  }
}

if (l_bResult) {
  l_bReport=true;
}
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
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
if (Eq('UOOQYQWWNG_ZOOM',lc)) {
return 4;
}
if (Eq('UOOQYQWWNG',lc)) {
return 4;
}
if (Eq('BVEIQEJCLQ_ZOOM',lc)) {
return 5;
}
if (Eq('BVEIQEJCLQ',lc)) {
return 5;
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
if (Eq(index,4)) {
l_oWv=LOpt_UOOQYQWWNG();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,5)) {
l_oWv=LOpt_BVEIQEJCLQ();
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
l_oWv.setValue('TIPOGIOCO',WtA(w_TIPOGIOCO,'C'));
l_oWv.setValue('TIPOPERS',WtA(w_TIPOPERS,'C'));
l_oWv.setValue('CGOFLGVNP',WtA(w_CGOFLGVNP,'C'));
l_oWv.setValue('TOTLIRE',WtA(w_TOTLIRE,'N'));
l_oWv.setValue('TOTCONT',WtA(w_TOTCONT,'N'));
l_oWv.setValue('IMPWALLET',WtA(w_IMPWALLET,'N'));
l_oWv.setValue('CODWALLET',WtA(w_CODWALLET,'C'));
l_oWv.setValue('CODTRANSZ',WtA(w_CODTRANSZ,'C'));
l_oWv.setValue('CGOFLGVLT',WtA(w_CGOFLGVLT,'C'));
l_oWv.setValue('MEZPAGAM',WtA(w_MEZPAGAM,'C'));
l_oWv.setValue('CC4CIFRE',WtA(w_CC4CIFRE,'C'));
l_oWv.setValue('CCMESSCA',WtA(w_CCMESSCA,'N'));
l_oWv.setValue('CCANNSCA',WtA(w_CCANNSCA,'N'));
l_oWv.setValue('IBAN',WtA(w_IBAN,'C'));
l_oWv.setValue('ASSEGNO',WtA(w_ASSEGNO,'C'));
l_oWv.setValue('CFESTERO',WtA(w_CFESTERO,'N'));
l_oWv.setValue('PEP',WtA(w_PEP,'C'));
l_oWv.setValue('CODFISC',WtA(w_CODFISC,'C'));
l_oWv.setValue('COGNOME',WtA(w_COGNOME,'C'));
l_oWv.setValue('NOME',WtA(w_NOME,'C'));
l_oWv.setValue('NASCOMUN',WtA(w_NASCOMUN,'C'));
l_oWv.setValue('TIPINTER',WtA(w_TIPINTER,'C'));
l_oWv.setValue('SESSO',WtA(w_SESSO,'C'));
l_oWv.setValue('NASSTATO',WtA(w_NASSTATO,'C'));
l_oWv.setValue('DATANASC',WtA(w_DATANASC,'D'));
l_oWv.setValue('PAESE',WtA(w_PAESE,'C'));
l_oWv.setValue('RAGSOC',WtA(w_RAGSOC,'C'));
l_oWv.setValue('DESCCIT',WtA(w_DESCCIT,'C'));
l_oWv.setValue('PROVINCIA',WtA(w_PROVINCIA,'C'));
l_oWv.setValue('CAP',WtA(w_CAP,'C'));
l_oWv.setValue('CODCAB',WtA(w_CODCAB,'C'));
l_oWv.setValue('DOMICILIO',WtA(w_DOMICILIO,'C'));
l_oWv.setValue('NUMTEL',WtA(w_NUMTEL,'C'));
l_oWv.setValue('ATTIV',WtA(w_ATTIV,'C'));
l_oWv.setValue('SOTGRUP',WtA(w_SOTGRUP,'C'));
l_oWv.setValue('RAMOGRUP',WtA(w_RAMOGRUP,'C'));
l_oWv.setValue('SETTSINT',WtA(w_SETTSINT,'C'));
l_oWv.setValue('SNAINUMOPE',WtA(w_SNAINUMOPE,'C'));
l_oWv.setValue('DATAOPE',WtA(w_DATAOPE,'D'));
l_oWv.setValue('DATAREG',WtA(w_DATAREG,'D'));
l_oWv.setValue('FLAGCONT',WtA(w_FLAGCONT,'C'));
l_oWv.setValue('FLAGWALLET',WtA(w_FLAGWALLET,'C'));
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
l_oWv.setValue('SEGNO',WtA(w_SEGNO,'C'));
l_oWv.setValue('FLAGFRAZ',WtA(w_FLAGFRAZ,'C'));
l_oWv.setValue('COLLEG',WtA(w_COLLEG,'C'));
l_oWv.setValue('CACODICE',WtA(w_CACODICE,'N'));
l_oWv.setValue('CAIDBIGLIETTO',WtA(w_CAIDBIGLIETTO,'C'));
l_oWv.setValue('CGOTIPOPE',WtA(w_CGOTIPOPE,'C'));
l_oWv.setValue('NUMOPEDL',WtA(w_NUMOPEDL,'C'));
l_oWv.setValue('CAFLGOPE',WtA(w_CAFLGOPE,'C'));
l_oWv.setValue('CGODATCON',WtA(w_CGODATCON,'D'));
l_oWv.setValue('CGOESICON',WtA(w_CGOESICON,'C'));
l_oWv.setValue('CGONOTCON',WtA(w_CGONOTCON,'M'));
l_oWv.setValue('IDDOCALL',WtA(w_IDDOCALL,'C'));
l_oWv.setValue('FLGDOCALL',WtA(w_FLGDOCALL,'C'));
l_oWv.setValue('VLTPLAT',WtA(w_VLTPLAT,'C'));
l_oWv.setValue('CCDATSCA',WtA(w_CCDATSCA,'C'));
l_oWv.setValue('TIPODOC',WtA(w_TIPODOC,'C'));
l_oWv.setValue('NUMDOCUM',WtA(w_NUMDOCUM,'C'));
l_oWv.setValue('DATARILASC',WtA(w_DATARILASC,'D'));
l_oWv.setValue('DATAVALI',WtA(w_DATAVALI,'D'));
l_oWv.setValue('RDCODAUT',WtA(w_RDCODAUT,'C'));
l_oWv.setValue('RDLOCAUT',WtA(w_RDLOCAUT,'C'));
l_oWv.setValue('AUTRILASC',WtA(w_AUTRILASC,'C'));
l_oWv.setValue('PEPDESCRI',WtA(w_PEPDESCRI,'C'));
l_oWv.setValue('PAESE2',WtA(w_PAESE2,'C'));
l_oWv.setValue('DESCCIT2',WtA(w_DESCCIT2,'C'));
l_oWv.setValue('PROVINCIA2',WtA(w_PROVINCIA2,'C'));
l_oWv.setValue('CAP2',WtA(w_CAP2,'C'));
l_oWv.setValue('DOMICILIO2',WtA(w_DOMICILIO2,'C'));
l_oWv.setValue('FLGDOM',WtA(w_FLGDOM,'C'));
l_oWv.setValue('PROFESSIONE',WtA(w_PROFESSIONE,'C'));
l_oWv.setValue('CODCABDIP',WtA(w_CODCABDIP,'C'));
l_oWv.setValue('PROVINCIADIP',WtA(w_PROVINCIADIP,'C'));
l_oWv.setValue('DESCCITDIP',WtA(w_DESCCITDIP,'C'));
l_oWv.setValue('CODDIPE',WtA(w_CODDIPE,'C'));
l_oWv.setValue('gIntemediario',WtA(w_gIntemediario,'C'));
l_oWv.setValue('xSOGTPGIO',WtA(w_xSOGTPGIO,'N'));
l_oWv.setValue('xDEFTPGIO',WtA(w_xDEFTPGIO,'C'));
l_oWv.setValue('xEDTTPGIO',WtA(w_xEDTTPGIO,'C'));
l_oWv.setValue('xEDTSPGIO',WtA(w_xEDTSPGIO,'C'));
l_oWv.setValue('xDEFSPGIO',WtA(w_xDEFSPGIO,'C'));
l_oWv.setValue('FLGPAGAM',WtA(w_FLGPAGAM,'C'));
l_oWv.setValue('FILTROMP',WtA(w_FILTROMP,'C'));
l_oWv.setValue('idcitta',WtA(w_idcitta,'C'));
l_oWv.setValue('xARDESCRI',WtA(w_xARDESCRI,'C'));
l_oWv.setValue('dessta',WtA(w_dessta,'C'));
l_oWv.setValue('tipsot',WtA(w_tipsot,'C'));
l_oWv.setValue('STATOREG',WtA(w_STATOREG,'C'));
l_oWv.setValue('IDBASE',WtA(w_IDBASE,'C'));
l_oWv.setValue('NUMPROG',WtA(w_NUMPROG,'C'));
l_oWv.setValue('DESCRI',WtA(w_DESCRI,'C'));
l_oWv.setValue('gSeekAos',WtA(w_gSeekAos,'C'));
l_oWv.setValue('gDataVaria',WtA(w_gDataVaria,'D'));
l_oWv.setValue('gFlgDoc',WtA(w_gFlgDoc,'C'));
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
l_oWv.setValue('xdesctipatt',WtA(w_xdesctipatt,'C'));
l_oWv.setValue('gVLT',WtA(w_gVLT,'N'));
l_oWv.setValue('gVNP',WtA(w_gVNP,'N'));
l_oWv.setValue('gCodDip',WtA(w_gCodDip,'C'));
l_oWv.setValue('verifica',WtA(w_verifica,'C'));
l_oWv.setValue('gStpDwn',WtA(w_gStpDwn,'C'));
l_oWv.setValue('MIDBIGLIETTO',WtA(w_MIDBIGLIETTO,'M'));
l_oWv.setValue('MIDBIGLIETTO1',WtA(w_MIDBIGLIETTO1,'M'));
l_oWv.setValue('MIDBIGLIETTO2',WtA(w_MIDBIGLIETTO2,'M'));
l_oWv.setValue('MIDBIGLIETTO3',WtA(w_MIDBIGLIETTO3,'M'));
l_oWv.setValue('MIDBIGLIETTO4',WtA(w_MIDBIGLIETTO4,'M'));
l_oWv.setValue('TELDIP',WtA(w_TELDIP,'C'));
l_oWv.setValue('CODLOC',WtA(w_CODLOC,'C'));
l_oWv.setValue('xFLGPLGIO',WtA(w_xFLGPLGIO,'C'));
l_oWv.setValue('xVPFLGATT',WtA(w_xVPFLGATT,'C'));
l_oWv.setValue('DOC03',WtA(w_DOC03,'C'));
l_oWv.setValue('DOC04',WtA(w_DOC04,'C'));
l_oWv.setValue('tipop',WtA(w_tipop,'C'));
l_oWv.setValue('gGesDoc',WtA(w_gGesDoc,'C'));
l_oWv.setValue('edtdoc',WtA(w_edtdoc,'L'));
l_oWv.setValue('saveddoc',WtA(w_saveddoc,'C'));
l_oWv.setValue('idcitta2',WtA(w_idcitta2,'C'));
l_oWv.setValue('dessta2',WtA(w_dessta2,'C'));
l_oWv.setValue('FLGQADVFULL',WtA(w_FLGQADVFULL,'C'));
l_oWv.setValue('gQADV',WtA(w_gQADV,'C'));
l_oWv.setValue('xCGOFLGPROF',WtA(w_xCGOFLGPROF,'C'));
l_oWv.setValue('ANA_FOUND',WtA(w_ANA_FOUND,'C'));
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
_FillChildren.n=['armt_cgo_qadv_operazioni'];
FillWv.n=["TIPOGIOCO","TIPOPERS","CGOFLGVNP","TOTLIRE","TOTCONT","IMPWALLET","CODWALLET","CODTRANSZ","CGOFLGVLT","MEZPAGAM","CC4CIFRE","CCMESSCA","CCANNSCA","IBAN","ASSEGNO","CFESTERO","PEP","CODFISC","COGNOME","NOME","NASCOMUN","TIPINTER","SESSO","NASSTATO","DATANASC","PAESE","RAGSOC","DESCCIT","PROVINCIA","CAP","CODCAB","DOMICILIO","NUMTEL","ATTIV","SOTGRUP","RAMOGRUP","SETTSINT","SNAINUMOPE","DATAOPE","DATAREG","FLAGCONT","FLAGWALLET","TIPOOPRAP","CODANA","CODVOC","VALUTA","CAMBIO","CONNESCLI","CONNESBEN","C_RAG","C_CTA","C_PRV","C_CAP","C_CAB","C_IND","C_STA","CODINTER","SEGNO","FLAGFRAZ","COLLEG","CACODICE","CAIDBIGLIETTO","CGOTIPOPE","NUMOPEDL","CAFLGOPE","CGODATCON","CGOESICON","CGONOTCON","IDDOCALL","FLGDOCALL","VLTPLAT","CCDATSCA","TIPODOC","NUMDOCUM","DATARILASC","DATAVALI","RDCODAUT","RDLOCAUT","AUTRILASC","PEPDESCRI","PAESE2","DESCCIT2","PROVINCIA2","CAP2","DOMICILIO2","FLGDOM","PROFESSIONE","CODCABDIP","PROVINCIADIP","DESCCITDIP","CODDIPE","gIntemediario","xSOGTPGIO","xDEFTPGIO","xEDTTPGIO","xEDTSPGIO","xDEFSPGIO","FLGPAGAM","FILTROMP","idcitta","xARDESCRI","dessta","tipsot","STATOREG","IDBASE","NUMPROG","DESCRI","gSeekAos","gDataVaria","gFlgDoc","xDescDipe","datpaseuro","xdes1","desccauana","CITINT","CITDIP","PROVDIP","CABDIP","PROVINT","CABINT","xdesccausin","gChkDate","xdesctipatt","gVLT","gVNP","gCodDip","verifica","gStpDwn","MIDBIGLIETTO","MIDBIGLIETTO1","MIDBIGLIETTO2","MIDBIGLIETTO3","MIDBIGLIETTO4","TELDIP","CODLOC","xFLGPLGIO","xVPFLGATT","DOC03","DOC04","tipop","gGesDoc","edtdoc","saveddoc","idcitta2","dessta2","FLGQADVFULL","gQADV","xCGOFLGPROF","ANA_FOUND"];
function SetModified() {
m_bUpdated=true;
}
function SetChildVariables_armt_cgo_qadv_operazioni() {
}
function CtxLoad_armt_cgo_qadv_operazioni() {
if (ChildToLoad(FrameRef('armt_cgo_qadv_operazioni'))) {
return [LoadContext(0,'BZRUFRMVDO'),'armt_cgo_qadv_operazioni'];
}
}
