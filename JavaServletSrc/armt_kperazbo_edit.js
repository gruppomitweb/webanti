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
function DisplayErrorMessage_ardt_clientisara() {
if ( ! (ChildToLoad(FrameRef('ardt_clientisara'))) && Ne(typeof(FrameRef('ardt_clientisara').DisplayErrorMessage),'undefined')) {
FrameRef('ardt_clientisara').DisplayErrorMessage();
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
l_bEnabled= ! (Eq(w_FLAGCONT,'1')) || IsDisabledByStateDriver('xTOTCONT');
SetDisabled('CTORYEJVDR',l_bEnabled);
l_bEnabled= ! ( ! (Empty(LRTrim(w_CONNESOPER)))) || IsDisabledByStateDriver('PAGASOGOP');
SetDisabled('JGKMKQMAHS',l_bEnabled);
l_bEnabled= ! (Eq(w_FLAGFRAZ,'2')) || IsDisabledByStateDriver('COLLEG');
SetDisabled('MSGBKOOAOY',l_bEnabled);
SetDisabled(Ctrl('MSGBKOOAOY_ZOOM'),l_bEnabled);
if (IsDisabledByStateDriver('box_YORQOIOBQN')) {
DisableInputsInContainer(Ctrl('YORQOIOBQN'),true);
}
if (IsDisabledByStateDriver('box_BOYWPGJEEZ')) {
DisableInputsInContainer(Ctrl('BOYWPGJEEZ'),true);
}
if (IsDisabledByStateDriver('box_XLSSDAVPDH')) {
DisableInputsInContainer(Ctrl('XLSSDAVPDH'),true);
}
if (IsDisabledByStateDriver('box_ZPEPXLSZFA')) {
DisableInputsInContainer(Ctrl('ZPEPXLSZFA'),true);
}
if (IsDisabledByStateDriver('box_YIVWPEZXIF')) {
DisableInputsInContainer(Ctrl('YIVWPEZXIF'),true);
}
if (IsDisabledByStateDriver('box_BDZUATYPMW')) {
DisableInputsInContainer(Ctrl('BDZUATYPMW'),true);
}
if (IsDisabledByStateDriver('box_EBQBWEDRVH')) {
DisableInputsInContainer(Ctrl('EBQBWEDRVH'),true);
}
if (IsDisabledByStateDriver('box_GPZQGPPLEB')) {
DisableInputsInContainer(Ctrl('GPZQGPPLEB'),true);
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
function Set_PROV2(ctrlValue,kmode,e) {
if (Ne(w_PROV2,ctrlValue)) {
var ctl = _GetCtl(e,'ACAPFGYRVI');
if (_tracker.goon(ctl,ctrlValue)) {
w_PROV2=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ACAPFGYRVI',0);
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
function Set_DESC2(ctrlValue,kmode,e) {
if (Ne(w_DESC2,ctrlValue)) {
var ctl = _GetCtl(e,'FFCAGQAZHK');
if (_tracker.goon(ctl,ctrlValue)) {
w_DESC2=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FFCAGQAZHK',0);
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
function Set_DATAREG(ctrlValue,kmode,e) {
if (Ne(w_DATAREG,ctrlValue)) {
var ctl = _GetCtl(e,'OEIKQOZMYJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_DATAREG=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
var l_bWarn = true;
l_bResult=_ChkObl('OEIKQOZMYJ',0);
if (l_bResult) {
l_bResult=Ge(w_DATAREG,w_DATAOPE);
if ( ! (l_bResult)) {
m_nLastError=2;
m_cLastWorkVarErrorMsg='1028598955';
m_cLastMsgError=AlertErrorMessage('12128708791');
}
if (l_bResult && ( ! (Le(DateDiff(w_DATAOPE,w_DATAREG),30)) && Ne(m_nLastError,-2))) {
try {
_tracker.askwrn=true;
l_bWarn=WindowConfirm(AlertErrorMessage('10082410841'));
} finally {
_tracker.askwrn=false;
}
}
if ( ! (l_bResult) ||  ! (l_bWarn)) {
w_DATAREG=HtW('','D');
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
function Set_ZCPARTE(ctrlValue,kmode,e) {
if (Ne(w_ZCPARTE,ctrlValue)) {
var ctl = _GetCtl(e,'GXMZZZHVBR');
if (_tracker.goon(ctl,ctrlValue)) {
w_ZCPARTE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('GXMZZZHVBR',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',69,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_TIPOOPRAP(ctrlValue,kmode,e) {
if (Ne(w_TIPOOPRAP,ctrlValue)) {
var ctl = _GetCtl(e,'UJRFWINIVQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_TIPOOPRAP=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UJRFWINIVQ',0);
if (l_bResult) {
l_bResult=Link_UJRFWINIVQ(kmode);
if ( ! (l_bResult)) {
w_TIPOOPRAP=HtW('','C');
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
function Set_CODANA(ctrlValue,kmode,e) {
if (Ne(w_CODANA,ctrlValue)) {
var ctl = _GetCtl(e,'SQVJLYRFKQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_CODANA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SQVJLYRFKQ',0);
if (l_bResult) {
l_bResult=Link_SQVJLYRFKQ(kmode);
if ( ! (Empty(w_CODVOC))) {
Link_SRWWPHPCUB(kmode);
}
if ( ! (l_bResult)) {
w_CODANA=HtW('','C');
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
function Set_CODVOC(ctrlValue,kmode,e) {
if (Ne(w_CODVOC,ctrlValue)) {
var ctl = _GetCtl(e,'SRWWPHPCUB');
if (_tracker.goon(ctl,ctrlValue)) {
w_CODVOC=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SRWWPHPCUB',0);
if (l_bResult) {
l_bResult=Link_SRWWPHPCUB(kmode);
if ( ! (l_bResult)) {
w_CODVOC=HtW('','C');
}
}
l_bResult=l_bResult && _ChkObl('KHRUYMSPDK',0);
if (l_bResult) {
if ( ! (l_bResult)) {
w_CODVOC=HtW('','C');
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
function Set_COLLEG(ctrlValue,kmode,e) {
if (Ne(w_COLLEG,ctrlValue)) {
var ctl = _GetCtl(e,'MSGBKOOAOY');
if (_tracker.goon(ctl,ctrlValue)) {
w_COLLEG=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MSGBKOOAOY',0);
if (l_bResult) {
l_bResult=Link_MSGBKOOAOY(kmode);
if ( ! (l_bResult)) {
w_COLLEG=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',11,0,''));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',11,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_DATARETT(ctrlValue,kmode,e) {
if (Ne(w_DATARETT,ctrlValue)) {
var ctl = _GetCtl(e,'VYBZEWHKFF');
if (_tracker.goon(ctl,ctrlValue)) {
w_DATARETT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VYBZEWHKFF',0);
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
function Set_appolire(ctrlValue,kmode,e) {
if (Ne(w_appolire,ctrlValue)) {
var ctl = _GetCtl(e,'LJBMCCABSS');
if (_tracker.goon(ctl,ctrlValue)) {
w_appolire=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('LJBMCCABSS',0);
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
function Set_VALUTA(ctrlValue,kmode,e) {
if (Ne(w_VALUTA,ctrlValue)) {
var ctl = _GetCtl(e,'MKCXJZEKIG');
if (_tracker.goon(ctl,ctrlValue)) {
w_VALUTA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MKCXJZEKIG',0);
if (l_bResult) {
l_bResult=Link_MKCXJZEKIG(kmode);
if ( ! (l_bResult)) {
w_VALUTA=HtW('','C');
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
function Set_CAMBIO(ctrlValue,kmode,e) {
if (Ne(w_CAMBIO,ctrlValue)) {
var ctl = _GetCtl(e,'YTCDGCPEDJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_CAMBIO=ValidNum(ctrlValue,'9999.9999');
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YTCDGCPEDJ',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('YTCDGCPEDJ',function(){return WtH(w_CAMBIO,'N',9,4,'9999.9999')},w_CAMBIO);
return l_bResult;
} else {
ctl.value=WtH('','N',9,4,'9999.9999');
_ResetTracker();
return true;
}
}
return true;
}
function Set_xTOTLIRE(ctrlValue,kmode,e) {
if (Ne(w_xTOTLIRE,ctrlValue)) {
var ctl = _GetCtl(e,'EDIXWZNSIC');
if (_tracker.goon(ctl,ctrlValue)) {
w_xTOTLIRE=ValidNum(ctrlValue,'999999999999.99');
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
var l_bWarn = true;
l_bResult=_ChkObl('EDIXWZNSIC',0);
if (l_bResult) {
if (l_bResult && ( ! (arfn_chktotalelire(w_DATAOPE,w_datpaseuro,w_xTOTLIRE,w_FLAGFRAZ)) && Ne(m_nLastError,-2))) {
try {
_tracker.askwrn=true;
l_bWarn=WindowConfirm(AlertErrorMessage('11525797640'));
} finally {
_tracker.askwrn=false;
}
}
if ( ! (l_bResult) ||  ! (l_bWarn)) {
w_xTOTLIRE=HtW('','N');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult) ||  ! (l_bWarn)) {
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
SPBOUILib.SetInputValue('EDIXWZNSIC',function(){return WtH(w_xTOTLIRE,'N',15,2,'999,999,999,999.99')},w_xTOTLIRE);
}
return true;
}
function Set_xTOTCONT(ctrlValue,kmode,e) {
if (Ne(w_xTOTCONT,ctrlValue)) {
var ctl = _GetCtl(e,'CTORYEJVDR');
if (_tracker.goon(ctl,ctrlValue)) {
w_xTOTCONT=ValidNum(ctrlValue,'999999999999.99');
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CTORYEJVDR',0);
if (l_bResult) {
l_bResult=arfn_chktotalelire_cont(w_DATAOPE,w_datpaseuro,w_xTOTCONT,w_xTOTLIRE);
if ( ! (l_bResult)) {
m_nLastError=2;
m_cLastWorkVarErrorMsg='xTOTCONT';
m_cLastMsgError=AlertErrorMessage('11525797640');
}
if ( ! (l_bResult)) {
w_xTOTCONT=HtW('','N');
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
SPBOUILib.SetInputValue('CTORYEJVDR',function(){return WtH(w_xTOTCONT,'N',15,2,'999,999,999,999.99')},w_xTOTCONT);
}
return true;
}
function Set_CODCAB2(ctrlValue,kmode,e) {
if (Ne(w_CODCAB2,ctrlValue)) {
var ctl = _GetCtl(e,'YQINIDXZSL');
if (_tracker.goon(ctl,ctrlValue)) {
w_CODCAB2=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YQINIDXZSL',0);
if (l_bResult) {
l_bResult=Link_YQINIDXZSL(kmode);
if ( ! (l_bResult)) {
w_CODCAB2=HtW('','C');
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
function Set_DESCINTER(ctrlValue,kmode,e) {
if (Ne(w_DESCINTER,ctrlValue)) {
var ctl = _GetCtl(e,'VYDRMHACRY');
if (_tracker.goon(ctl,ctrlValue)) {
w_DESCINTER=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VYDRMHACRY',0);
l_bResult=l_bResult && _ChkObl('MXCRVGEBAO',0);
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
function Set_RAPPORTO(ctrlValue,kmode,e) {
if (Ne(w_RAPPORTO,ctrlValue)) {
var ctl = _GetCtl(e,'RZIQZFKPUE');
if (_tracker.goon(ctl,ctrlValue)) {
w_RAPPORTO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RZIQZFKPUE',0);
if (l_bResult) {
l_bResult=Link_RZIQZFKPUE(kmode);
if ( ! (l_bResult)) {
w_RAPPORTO=HtW('','C');
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
function Set_CONNESCLI(ctrlValue,kmode,e) {
if (Ne(w_CONNESCLI,ctrlValue)) {
var ctl = _GetCtl(e,'QBLXDBODXR');
if (_tracker.goon(ctl,ctrlValue)) {
w_CONNESCLI=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QBLXDBODXR',0);
if (l_bResult) {
l_bResult=Link_QBLXDBODXR(kmode);
if ( ! (l_bResult)) {
w_CONNESCLI=HtW('','C');
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
function Set_CONNESOPER(ctrlValue,kmode,e) {
if (Ne(w_CONNESOPER,ctrlValue)) {
var ctl = _GetCtl(e,'TCOTJNZLGM');
if (_tracker.goon(ctl,ctrlValue)) {
w_CONNESOPER=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('TCOTJNZLGM',0);
if (l_bResult) {
l_bResult=Link_TCOTJNZLGM(kmode);
if ( ! (l_bResult)) {
w_CONNESOPER=HtW('','C');
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
function Set_TIPOLEG(ctrlValue,kmode,e) {
if (Ne(w_TIPOLEG,ctrlValue)) {
var ctl = _GetCtl(e,'AQSAREJVST');
if (_tracker.goon(ctl,ctrlValue)) {
w_TIPOLEG=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('AQSAREJVST',0);
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
function Set_PAGASOGOP(ctrlValue,kmode,e) {
if (Ne(w_PAGASOGOP,ctrlValue)) {
var ctl = _GetCtl(e,'JGKMKQMAHS');
if (_tracker.goon(ctl,ctrlValue)) {
w_PAGASOGOP=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('JGKMKQMAHS',0);
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
function Set_CONNESBEN(ctrlValue,kmode,e) {
if (Ne(w_CONNESBEN,ctrlValue)) {
var ctl = _GetCtl(e,'ULVCBLFVEU');
if (_tracker.goon(ctl,ctrlValue)) {
w_CONNESBEN=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ULVCBLFVEU',0);
if (l_bResult) {
l_bResult=Link_ULVCBLFVEU(kmode);
if ( ! (l_bResult)) {
w_CONNESBEN=HtW('','C');
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
function Set_CONNALTRO(ctrlValue,kmode,e) {
if (Ne(w_CONNALTRO,ctrlValue)) {
var ctl = _GetCtl(e,'HWFHDWYMIU');
if (_tracker.goon(ctl,ctrlValue)) {
w_CONNALTRO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HWFHDWYMIU',0);
if (l_bResult) {
l_bResult=Link_HWFHDWYMIU(kmode);
if ( ! (l_bResult)) {
w_CONNALTRO=HtW('','C');
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
function Set_C_RAG(ctrlValue,kmode,e) {
if (Ne(w_C_RAG,ctrlValue)) {
var ctl = _GetCtl(e,'AWPNTOJIRR');
if (_tracker.goon(ctl,ctrlValue)) {
w_C_RAG=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('AWPNTOJIRR',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('AWPNTOJIRR',function(){return WtH(w_C_RAG,'C',70,0,'@!')},w_C_RAG);
return l_bResult;
} else {
ctl.value=WtH('','C',70,0,'@!');
_ResetTracker();
return true;
}
}
return true;
}
function Set_C_CTA(ctrlValue,kmode,e) {
if (Ne(w_C_CTA,ctrlValue)) {
var ctl = _GetCtl(e,'ODAYKSRECA');
if (_tracker.goon(ctl,ctrlValue)) {
w_C_CTA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ODAYKSRECA',0);
if (l_bResult) {
l_bResult=Link_ODAYKSRECA(kmode);
if ( ! (l_bResult)) {
w_C_CTA=HtW('','C');
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
function Set_C_PRV(ctrlValue,kmode,e) {
if (Ne(w_C_PRV,ctrlValue)) {
var ctl = _GetCtl(e,'NOTZPDMYIA');
if (_tracker.goon(ctl,ctrlValue)) {
w_C_PRV=ctrlValue;
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
function Set_C_CAP(ctrlValue,kmode,e) {
if (Ne(w_C_CAP,ctrlValue)) {
var ctl = _GetCtl(e,'RDAVOEETJG');
if (_tracker.goon(ctl,ctrlValue)) {
w_C_CAP=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RDAVOEETJG',0);
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
function Set_C_CAB(ctrlValue,kmode,e) {
if (Ne(w_C_CAB,ctrlValue)) {
var ctl = _GetCtl(e,'BOTAJBWHHY');
if (_tracker.goon(ctl,ctrlValue)) {
w_C_CAB=ctrlValue;
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
function Set_C_IND(ctrlValue,kmode,e) {
if (Ne(w_C_IND,ctrlValue)) {
var ctl = _GetCtl(e,'VYLHWTRQNX');
if (_tracker.goon(ctl,ctrlValue)) {
w_C_IND=ctrlValue;
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
function Set_C_STA(ctrlValue,kmode,e) {
if (Ne(w_C_STA,ctrlValue)) {
var ctl = _GetCtl(e,'YVIKEGPYPM');
if (_tracker.goon(ctl,ctrlValue)) {
w_C_STA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YVIKEGPYPM',0);
if (l_bResult) {
l_bResult=Link_YVIKEGPYPM(kmode);
if ( ! (l_bResult)) {
w_C_STA=HtW('','C');
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
function Set_TIPOINT2(ctrlValue,kmode,e) {
if (Ne(w_TIPOINT2,ctrlValue)) {
var ctl = _GetCtl(e,'HNMYJPHSQN');
if (_tracker.goon(ctl,ctrlValue)) {
w_TIPOINT2=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HNMYJPHSQN',0);
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
function Set_CODINT2(ctrlValue,kmode,e) {
if (Ne(w_CODINT2,ctrlValue)) {
var ctl = _GetCtl(e,'CDJFSCCGNX');
if (_tracker.goon(ctl,ctrlValue)) {
w_CODINT2=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CDJFSCCGNX',0);
if (l_bResult) {
l_bResult=Link_CDJFSCCGNX(kmode);
if ( ! (l_bResult)) {
w_CODINT2=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',11,0,''));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',11,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_CODDIPE(ctrlValue,kmode,e) {
if (Ne(w_CODDIPE,ctrlValue)) {
var ctl = _GetCtl(e,'VFSCXTRPBT');
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
l_bResult=l_bResult && _ChkObl('VFSCXTRPBT',0);
if (l_bResult) {
l_bResult=Link_VFSCXTRPBT(kmode);
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
function Set_PAESE(ctrlValue,kmode,e) {
if (Ne(w_PAESE,ctrlValue)) {
var ctl = _GetCtl(e,'NYRJHOZOON');
if (_tracker.goon(ctl,ctrlValue)) {
w_PAESE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NYRJHOZOON',0);
if (l_bResult) {
l_bResult=Link_NYRJHOZOON(kmode);
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
function Set_C_RAPPORTO(ctrlValue,kmode,e) {
if (Ne(w_C_RAPPORTO,ctrlValue)) {
var ctl = _GetCtl(e,'NZZUAIJFDU');
if (_tracker.goon(ctl,ctrlValue)) {
w_C_RAPPORTO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NZZUAIJFDU',0);
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
function Set_FLAGFRAZ(ctrlValue,kmode,e) {
if (Ne(w_FLAGFRAZ,ctrlValue)) {
var ctl = _GetCtl(e,'QSRYXQJCBZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLAGFRAZ=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('OSJVPCICRI',0);
l_bResult=l_bResult && _ChkObl('QSRYXQJCBZ',0);
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
function Set_MTCN(ctrlValue,kmode,e) {
if (Ne(w_MTCN,ctrlValue)) {
var ctl = _GetCtl(e,'JDTKGSGMAF');
if (_tracker.goon(ctl,ctrlValue)) {
w_MTCN=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('JDTKGSGMAF',0);
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
function Set_IDBASE(ctrlValue,kmode,e) {
if (Ne(w_IDBASE,ctrlValue)) {
var ctl = _GetCtl(e,'NHERHRZTFP');
if (_tracker.goon(ctl,ctrlValue)) {
w_IDBASE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NHERHRZTFP',0);
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
function Calculate() {
var l_bTmpRes;
var l_bResult = true;
m_bCalculating=true;
w_CDATOPE=DateToChar(w_DATAOPE);
w_tipope='1';
w_FLAGLIRE=arfn_calcflaglire(w_DATAOPE,w_appolire,w_datpaseuro);
if ((Ne(o_FLAGLIRE,w_FLAGLIRE))) {
w_appolire=(Eq(w_FLAGLIRE,'1') || Eq(w_FLAGLIRE,'7')?'L':(Eq(w_FLAGLIRE,'3') || Eq(w_FLAGLIRE,'5') || Empty(w_FLAGLIRE)?'E':'V'));
}
if ((Ne(o_CDATOPE,w_CDATOPE)) || (Ne(o_filtro,w_filtro))) {
RenderDynamicCombo('AQSAREJVST');
}
if ((Ne(o_C_CTA,w_C_CTA))) {
l_bTmpRes=Link_YVIKEGPYPM(null);
}
if ((Ne(o_CODINT2,w_CODINT2))) {
l_bTmpRes=Link_NYRJHOZOON(null);
}
UpdateAutonumber('IDBASE');
UpdateAutonumber('NUMPROG');
w_CODINTER=w_gIntemediario;
l_bTmpRes=Link_WJSVGWKSFC(null);
w_TIPOINF='1';
w_IDEREG=DateToChar(w_DATAOPE)+w_NUMPROG+LibreriaMit.StatoReg('OPERAZBO',w_STATOREG);
w_OPRAP='1';
w_STATOREG='0';
UpdateAutonumber('PRGIMPOPE');
w_dataoggi=SystemDate();
w_CDATAOPE=DateToChar(w_DATAOPE);
if ((Ne(o_FLAGCONT,w_FLAGCONT))) {
Calculation_EBRTUDXQTQ();
}
if ((Ne(o_appolire,w_appolire))) {
Calculation_TBLTXFHXJY();
}
if ((Ne(o_CONNESCLI,w_CONNESCLI)) || (Ne(o_RAPPORTO,w_RAPPORTO))) {
Calculation_QCJQRCFUFB();
}
if ((Ne(o_CODINTER,w_CODINTER)) || (Ne(o_CODDIPE,w_CODDIPE))) {
Calculation_WKUMXNRIRT();
}
if ((Ne(o_CODVOC,w_CODVOC))) {
l_bTmpRes=Link_KHRUYMSPDK(null);
}
w_prova=DateDiff(w_DATAOPE,w_DATAREG);
w_CDATREG=DateToChar(w_DATAREG);
if ((Ne(o_RAPPORTO,w_RAPPORTO))) {
Calculation_DIWSVSDVMG();
}
w_CODINTER=w_gIntemediario;
l_bTmpRes=Link_AKAVLTKFQJ(null);
LibJavascript.forEachItem(m_FoundlingCopyWorkVar,i_body_1)
function i_body_1(child){
child();
}
// * --- Area Manuale = UI - Calculate
// * --- Fine Area Manuale
UpdateAutonumber('');
m_bCalculating=false;
}
function Calculation_EBRTUDXQTQ() {
w_xTOTCONT=(Eq(w_FLAGCONT,'1')?w_xTOTCONT:0);
}
function Calculation_TBLTXFHXJY() {
w_VALUTA=(Eq(w_appolire,'L')?'018':(Eq(w_appolire,'E')?'242':w_VALUTA));
}
function Calculation_QCJQRCFUFB() {
arrt_imp_frischio([["pTipo",'B']])
}
function Calculation_WKUMXNRIRT() {
w_DESCCIT=(Empty(w_CODDIPE)?w_CITINT:w_CITDIP);
w_PROVINCIA=(Empty(w_CODDIPE)?w_PROVINT:w_PROVDIP);
w_CODCAB=(Empty(w_CODDIPE)?w_CABINT:w_CABDIP);
}
function Calculation_DIWSVSDVMG() {
arrt_li_kperazbo([["pObj",this]])
}
function SaveDependsOn() {
o_filtro=w_filtro;
o_DATAOPE=w_DATAOPE;
o_CDATOPE=w_CDATOPE;
o_FLAGCONT=w_FLAGCONT;
o_CODVOC=w_CODVOC;
o_FLAGLIRE=w_FLAGLIRE;
o_appolire=w_appolire;
o_RAPPORTO=w_RAPPORTO;
o_CONNESCLI=w_CONNESCLI;
o_C_CTA=w_C_CTA;
o_CODINT2=w_CODINT2;
o_CODINTER=w_CODINTER;
o_CODDIPE=w_CODDIPE;
}
function SaveLabelDependsOn() {
}
function Link_UJRFWINIVQ(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_TIPOOPRAP);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('OPERAZIO',w_tipope,1,0);
l_Appl.SetStringKey('CODICE',w_TIPOOPRAP,2,0);
l_Appl.SetFields('CODICE,DES1');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbtipreg');
l_Appl.SetID('UJRFWINIVQ');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_TIPOOPRAP=l_Appl.GetStringValue('CODICE',2,0);
w_xdes1=l_Appl.GetStringValue('DES1',90,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_UJRFWINIVQ_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_UJRFWINIVQ';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_UJRFWINIVQ();
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
function Link_UJRFWINIVQ_Blank() {
w_TIPOOPRAP='';
w_xdes1='';
}
function LOpt_UJRFWINIVQ() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbtipreg','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('OPERAZIO,CODICE','C'));
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
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CODANA=l_Appl.GetStringValue('CODCAU',4,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_SQVJLYRFKQ_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_SQVJLYRFKQ';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_SQVJLYRFKQ();
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
l_oWv.setValue('ConfigName',WtA('cauinter','C'));
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
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CODVOC=l_Appl.GetStringValue('CAUSINT',2,0);
w_SEGNO=l_Appl.GetStringValue('SEGNO',1,0);
w_desccauana=l_Appl.GetStringValue('DESCRI',165,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_SRWWPHPCUB_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_SRWWPHPCUB';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_SRWWPHPCUB();
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
function Link_MKCXJZEKIG(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_VALUTA);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODVAL',w_VALUTA,3,0);
l_Appl.SetFields('CODVAL,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbvalute');
l_Appl.SetID('MKCXJZEKIG');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_VALUTA=l_Appl.GetStringValue('CODVAL',3,0);
w_descdiv=l_Appl.GetStringValue('DESCRI',30,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_MKCXJZEKIG_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_MKCXJZEKIG';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_MKCXJZEKIG();
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
function Link_MKCXJZEKIG_Blank() {
w_VALUTA='';
w_descdiv='';
}
function LOpt_MKCXJZEKIG() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbvalute','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODVAL','C'));
l_oWv.setValue('LinkedField',WtA('CODVAL','C'));
l_oWv.setValue('UID',WtA('MKCXJZEKIG','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['MKCXJZEKIG'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('114016870'),'C'));
return l_oWv;
}
function Link_RZIQZFKPUE(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_RAPPORTO);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('RAPPORTO',w_RAPPORTO,25,0);
l_Appl.SetFields('RAPPORTO,DESCRAP,TIPORAP');
l_Appl.SetTypes('C,C,C');
l_Appl.LinkTable('knarapbo');
l_Appl.SetID('RZIQZFKPUE');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_RAPPORTO=l_Appl.GetStringValue('RAPPORTO',25,0);
w_xdescrap=l_Appl.GetStringValue('DESCRAP',50,0);
w_FLAGRAP=l_Appl.GetStringValue('TIPORAP',1,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_RZIQZFKPUE_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_RZIQZFKPUE';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_RZIQZFKPUE();
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
function Link_RZIQZFKPUE_Blank() {
w_RAPPORTO='';
w_xdescrap='';
w_FLAGRAP='';
}
function LOpt_RZIQZFKPUE() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('knarapbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('RAPPORTO','C'));
l_oWv.setValue('LinkedField',WtA('RAPPORTO','C'));
l_oWv.setValue('UID',WtA('RZIQZFKPUE','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['RZIQZFKPUE'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('194410082'),'C'));
return l_oWv;
}
function Link_QBLXDBODXR(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CONNESCLI);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CONNES',w_CONNESCLI,16,0);
l_Appl.SetFields('CONNES,RAGSOC,CODFISC');
l_Appl.SetTypes('C,C,C');
l_Appl.LinkTable('personbo');
l_Appl.SetID('QBLXDBODXR');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CONNESCLI=l_Appl.GetStringValue('CONNES',16,0);
w_xragsocper=l_Appl.GetStringValue('RAGSOC',70,0);
w_xcodfisc=l_Appl.GetStringValue('CODFISC',16,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_QBLXDBODXR_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_QBLXDBODXR';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_QBLXDBODXR();
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
function Link_QBLXDBODXR_Blank() {
w_CONNESCLI='';
w_xragsocper='';
w_xcodfisc='';
}
function LOpt_QBLXDBODXR() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('personbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CONNES','C'));
l_oWv.setValue('LinkedField',WtA('CONNES','C'));
l_oWv.setValue('UID',WtA('QBLXDBODXR','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['QBLXDBODXR'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('1890893827'),'C'));
return l_oWv;
}
function Link_TCOTJNZLGM(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CONNESOPER);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CONNES',w_CONNESOPER,16,0);
l_Appl.SetFields('CONNES,RAGSOC');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('personbo');
l_Appl.SetID('TCOTJNZLGM');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CONNESOPER=l_Appl.GetStringValue('CONNES',16,0);
w_xragsocct=l_Appl.GetStringValue('RAGSOC',70,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_TCOTJNZLGM_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_TCOTJNZLGM';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_TCOTJNZLGM();
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
function Link_TCOTJNZLGM_Blank() {
w_CONNESOPER='';
w_xragsocct='';
}
function LOpt_TCOTJNZLGM() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('personbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CONNES','C'));
l_oWv.setValue('LinkedField',WtA('CONNES','C'));
l_oWv.setValue('UID',WtA('TCOTJNZLGM','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['TCOTJNZLGM'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('1890893827'),'C'));
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
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CONNESBEN=l_Appl.GetStringValue('CONNES',16,0);
w_xragsocben=l_Appl.GetStringValue('RAGSOC',70,0);
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
if (Eq(l_nRec,2)) {
var openername = 'linkview_ULVCBLFVEU';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_ULVCBLFVEU();
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
function Link_ULVCBLFVEU_Blank() {
w_CONNESBEN='';
w_xragsocben='';
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
function Link_HWFHDWYMIU(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CONNALTRO);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CONNES',w_CONNALTRO,16,0);
l_Appl.SetFields('CONNES,RAGSOC');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('personbo');
l_Appl.SetID('HWFHDWYMIU');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CONNALTRO=l_Appl.GetStringValue('CONNES',16,0);
w_xragsocben=l_Appl.GetStringValue('RAGSOC',70,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_HWFHDWYMIU_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_HWFHDWYMIU';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_HWFHDWYMIU();
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
function Link_HWFHDWYMIU_Blank() {
w_CONNALTRO='';
w_xragsocben='';
}
function LOpt_HWFHDWYMIU() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('personbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CONNES','C'));
l_oWv.setValue('LinkedField',WtA('CONNES','C'));
l_oWv.setValue('UID',WtA('HWFHDWYMIU','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['HWFHDWYMIU'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('1890893827'),'C'));
return l_oWv;
}
function Link_ODAYKSRECA(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_C_CTA);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CITTA',w_C_CTA,30,0);
l_Appl.SetFields('CITTA,CAB,PROV,PKTBSTATI,CAP');
l_Appl.SetTypes('C,C,C,C,C');
l_Appl.LinkTable('tbcitta');
l_Appl.SetID('ODAYKSRECA');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_C_CTA=l_Appl.GetStringValue('CITTA',30,0);
w_C_CAB=l_Appl.GetStringValue('CAB',6,0);
w_C_PRV=l_Appl.GetStringValue('PROV',2,0);
w_C_STA=l_Appl.GetStringValue('PKTBSTATI',3,0);
w_C_CAP=l_Appl.GetStringValue('CAP',5,0);
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
w_C_CAB='';
w_C_PRV='';
w_C_STA='';
w_C_CAP='';
}
function LOpt_ODAYKSRECA() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcitta','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CITTA','C'));
l_oWv.setValue('LinkedField',WtA('CITTA','C'));
l_oWv.setValue('UID',WtA('ODAYKSRECA','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['ODAYKSRECA'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('15186643'),'C'));
return l_oWv;
}
function Link_YVIKEGPYPM(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_C_STA);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODSTA',w_C_STA,3,0);
l_Appl.SetFields('CODSTA,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbstati');
l_Appl.SetID('YVIKEGPYPM');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_C_STA=l_Appl.GetStringValue('CODSTA',3,0);
w_dessta=l_Appl.GetStringValue('DESCRI',40,0);
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
w_C_STA='';
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
function Link_CDJFSCCGNX(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CODINT2);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODINTER',w_CODINT2,11,0);
l_Appl.SetFields('CODINTER,RAGSOC,CODCAB,PROVINCIA,PAESE,TIPINTER');
l_Appl.SetTypes('C,C,C,C,C,C');
l_Appl.LinkTable('inter2bo');
l_Appl.SetID('CDJFSCCGNX');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CODINT2=l_Appl.GetStringValue('CODINTER',11,0);
w_DESCINTER=l_Appl.GetStringValue('RAGSOC',50,0);
w_CODCAB2=l_Appl.GetStringValue('CODCAB',6,0);
w_PROV2=l_Appl.GetStringValue('PROVINCIA',2,0);
w_PAESE=l_Appl.GetStringValue('PAESE',3,0);
w_TIPOINT2=l_Appl.GetStringValue('TIPINTER',2,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_CDJFSCCGNX_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_CDJFSCCGNX';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_CDJFSCCGNX();
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
function Link_CDJFSCCGNX_Blank() {
w_CODINT2='';
w_DESCINTER='';
w_CODCAB2='';
w_PROV2='';
w_PAESE='';
w_TIPOINT2='';
}
function LOpt_CDJFSCCGNX() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('inter2bo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODINTER','C'));
l_oWv.setValue('LinkedField',WtA('CODINTER','C'));
l_oWv.setValue('UID',WtA('CDJFSCCGNX','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['CDJFSCCGNX'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('11424168249'),'C'));
return l_oWv;
}
function Link_NYRJHOZOON(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_PAESE);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODSTA',w_PAESE,3,0);
l_Appl.SetFields('CODSTA,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbstati');
l_Appl.SetID('NYRJHOZOON');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_PAESE=l_Appl.GetStringValue('CODSTA',3,0);
w_xdescpaese2=l_Appl.GetStringValue('DESCRI',30,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_NYRJHOZOON_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_NYRJHOZOON';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_NYRJHOZOON();
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
function Link_NYRJHOZOON_Blank() {
w_PAESE='';
w_xdescpaese2='';
}
function LOpt_NYRJHOZOON() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstati','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODSTA','C'));
l_oWv.setValue('LinkedField',WtA('CODSTA','C'));
l_oWv.setValue('UID',WtA('NYRJHOZOON','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['NYRJHOZOON'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('7383187'),'C'));
return l_oWv;
}
function Link_YQINIDXZSL(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CODCAB2);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CAB',w_CODCAB2,6,0);
l_Appl.SetFields('CAB,CITTA,PROV');
l_Appl.SetTypes('C,C,C');
l_Appl.LinkTable('tbcitta');
l_Appl.SetID('YQINIDXZSL');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CODCAB2=l_Appl.GetStringValue('CAB',6,0);
w_xdciticon=l_Appl.GetStringValue('CITTA',40,0);
w_PROV2=l_Appl.GetStringValue('PROV',2,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_YQINIDXZSL_Blank();
l_bResult=true;
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_YQINIDXZSL';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_YQINIDXZSL();
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
function Link_YQINIDXZSL_Blank() {
w_xdciticon='';
w_PROV2='';
}
function LOpt_YQINIDXZSL() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcitta','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CAB','C'));
l_oWv.setValue('LinkedField',WtA('CAB','C'));
l_oWv.setValue('UID',WtA('YQINIDXZSL','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['YQINIDXZSL'][1],'C'));
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
l_Appl.SetLinkzoom('armt_intermbo');
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
l_oWv.setValue('Linkzoomprg',WtA('armt_intermbo','C'));
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
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
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
l_Appl.LinkTable('kperazbo');
l_Appl.SetLinkzoom('armt_operazioni');
l_Appl.SetID('MSGBKOOAOY');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_COLLEG=l_Appl.GetStringValue('NUMPROG',11,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_MSGBKOOAOY_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_MSGBKOOAOY';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_MSGBKOOAOY();
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
function Link_MSGBKOOAOY_Blank() {
w_COLLEG='';
}
function LOpt_MSGBKOOAOY() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('kperazbo','C'));
l_oWv.setValue('Linkzoomprg',WtA('armt_operazioni','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('NUMPROG','C'));
l_oWv.setValue('LinkedField',WtA('NUMPROG','C'));
l_oWv.setValue('UID',WtA('MSGBKOOAOY','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['MSGBKOOAOY'][1],'C'));
return l_oWv;
}
function Link_KHRUYMSPDK(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CODVOC);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODVOC',w_CODVOC,2,0);
l_Appl.SetFields('CODVOC,DESCRIZ');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbcausin');
l_Appl.SetID('KHRUYMSPDK');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CODVOC=l_Appl.GetStringValue('CODVOC',2,0);
w_xdesccausin=l_Appl.GetStringValue('DESCRIZ',165,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_KHRUYMSPDK_Blank();
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
function Link_KHRUYMSPDK_Blank() {
w_CODVOC='';
w_xdesccausin='';
}
function LOpt_KHRUYMSPDK() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcausin','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODVOC','C'));
l_oWv.setValue('LinkedField',WtA('CODVOC','C'));
l_oWv.setValue('UID',WtA('KHRUYMSPDK','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['KHRUYMSPDK'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('282420974'),'C'));
return l_oWv;
}
function Link_AKAVLTKFQJ(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CODINTER);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODINTER',w_CODINTER,11,0);
l_Appl.SetFields('CODINTER,DATANASC,CODCAB,PROVINCIA,DESCCIT');
l_Appl.SetTypes('C,D,C,C,C');
l_Appl.LinkTable('intermbo');
l_Appl.SetLinkzoom('armt_intermbo');
l_Appl.SetID('AKAVLTKFQJ');
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
Link_AKAVLTKFQJ_Blank();
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
function Link_AKAVLTKFQJ_Blank() {
w_CODINTER='';
w_datpaseuro=NullDate();
w_CABINT='';
w_PROVINT='';
w_CITINT='';
}
function LOpt_AKAVLTKFQJ() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('intermbo','C'));
l_oWv.setValue('Linkzoomprg',WtA('armt_intermbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODINTER','C'));
l_oWv.setValue('LinkedField',WtA('CODINTER','C'));
l_oWv.setValue('UID',WtA('AKAVLTKFQJ','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['AKAVLTKFQJ'][1],'C'));
return l_oWv;
}
function Link_VFSCXTRPBT(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CODDIPE);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODDIP',w_CODDIPE,6,0);
l_Appl.SetFields('CODDIP,DESCRIZ,DESCCIT,PROVINCIA,CAB');
l_Appl.SetTypes('C,C,C,C,C');
l_Appl.LinkTable('anadip');
l_Appl.SetID('VFSCXTRPBT');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CODDIPE=l_Appl.GetStringValue('CODDIP',6,0);
w_xDescDipe=l_Appl.GetStringValue('DESCRIZ',30,0);
w_CITDIP=l_Appl.GetStringValue('DESCCIT',30,0);
w_PROVDIP=l_Appl.GetStringValue('PROVINCIA',2,0);
w_CABDIP=l_Appl.GetStringValue('CAB',6,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_VFSCXTRPBT_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_VFSCXTRPBT';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_VFSCXTRPBT();
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
function Link_VFSCXTRPBT_Blank() {
w_CODDIPE='';
w_xDescDipe='';
w_CITDIP='';
w_PROVDIP='';
w_CABDIP='';
}
function LOpt_VFSCXTRPBT() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('anadip','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODDIP','C'));
l_oWv.setValue('LinkedField',WtA('CODDIP','C'));
l_oWv.setValue('UID',WtA('VFSCXTRPBT','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['VFSCXTRPBT'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('1270140318'),'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'UJRFWINIVQ')) {
last_focused_comp=GetLastFocusedElementOfLink('UJRFWINIVQ');
function SetMethod_UJRFWINIVQ() {
Set_TIPOOPRAP(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_UJRFWINIVQ();
} else {
setTimeout(SetMethod_UJRFWINIVQ,1);
}
bResult=true;
}
if (Eq(varName,'SQVJLYRFKQ')) {
last_focused_comp=GetLastFocusedElementOfLink('SQVJLYRFKQ');
function SetMethod_SQVJLYRFKQ() {
Set_CODANA(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_SQVJLYRFKQ();
} else {
setTimeout(SetMethod_SQVJLYRFKQ,1);
}
bResult=true;
}
if (Eq(varName,'SRWWPHPCUB')) {
last_focused_comp=GetLastFocusedElementOfLink('SRWWPHPCUB');
function SetMethod_SRWWPHPCUB() {
Set_CODVOC(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_SRWWPHPCUB();
} else {
setTimeout(SetMethod_SRWWPHPCUB,1);
}
bResult=true;
}
if (Eq(varName,'MKCXJZEKIG')) {
last_focused_comp=GetLastFocusedElementOfLink('MKCXJZEKIG');
function SetMethod_MKCXJZEKIG() {
Set_VALUTA(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_MKCXJZEKIG();
} else {
setTimeout(SetMethod_MKCXJZEKIG,1);
}
bResult=true;
}
if (Eq(varName,'RZIQZFKPUE')) {
last_focused_comp=GetLastFocusedElementOfLink('RZIQZFKPUE');
function SetMethod_RZIQZFKPUE() {
Set_RAPPORTO(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_RZIQZFKPUE();
} else {
setTimeout(SetMethod_RZIQZFKPUE,1);
}
bResult=true;
}
if (Eq(varName,'QBLXDBODXR')) {
last_focused_comp=GetLastFocusedElementOfLink('QBLXDBODXR');
function SetMethod_QBLXDBODXR() {
Set_CONNESCLI(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_QBLXDBODXR();
} else {
setTimeout(SetMethod_QBLXDBODXR,1);
}
bResult=true;
}
if (Eq(varName,'TCOTJNZLGM')) {
last_focused_comp=GetLastFocusedElementOfLink('TCOTJNZLGM');
function SetMethod_TCOTJNZLGM() {
Set_CONNESOPER(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_TCOTJNZLGM();
} else {
setTimeout(SetMethod_TCOTJNZLGM,1);
}
bResult=true;
}
if (Eq(varName,'ULVCBLFVEU')) {
last_focused_comp=GetLastFocusedElementOfLink('ULVCBLFVEU');
function SetMethod_ULVCBLFVEU() {
Set_CONNESBEN(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_ULVCBLFVEU();
} else {
setTimeout(SetMethod_ULVCBLFVEU,1);
}
bResult=true;
}
if (Eq(varName,'HWFHDWYMIU')) {
last_focused_comp=GetLastFocusedElementOfLink('HWFHDWYMIU');
function SetMethod_HWFHDWYMIU() {
Set_CONNALTRO(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_HWFHDWYMIU();
} else {
setTimeout(SetMethod_HWFHDWYMIU,1);
}
bResult=true;
}
if (Eq(varName,'ODAYKSRECA')) {
last_focused_comp=GetLastFocusedElementOfLink('ODAYKSRECA');
function SetMethod_ODAYKSRECA() {
Set_C_CTA(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_ODAYKSRECA();
} else {
setTimeout(SetMethod_ODAYKSRECA,1);
}
bResult=true;
}
if (Eq(varName,'YVIKEGPYPM')) {
last_focused_comp=GetLastFocusedElementOfLink('YVIKEGPYPM');
function SetMethod_YVIKEGPYPM() {
Set_C_STA(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_YVIKEGPYPM();
} else {
setTimeout(SetMethod_YVIKEGPYPM,1);
}
bResult=true;
}
if (Eq(varName,'CDJFSCCGNX')) {
last_focused_comp=GetLastFocusedElementOfLink('CDJFSCCGNX');
function SetMethod_CDJFSCCGNX() {
Set_CODINT2(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_CDJFSCCGNX();
} else {
setTimeout(SetMethod_CDJFSCCGNX,1);
}
bResult=true;
}
if (Eq(varName,'NYRJHOZOON')) {
last_focused_comp=GetLastFocusedElementOfLink('NYRJHOZOON');
function SetMethod_NYRJHOZOON() {
Set_PAESE(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_NYRJHOZOON();
} else {
setTimeout(SetMethod_NYRJHOZOON,1);
}
bResult=true;
}
if (Eq(varName,'YQINIDXZSL')) {
last_focused_comp=GetLastFocusedElementOfLink('YQINIDXZSL');
function SetMethod_YQINIDXZSL() {
Set_CODCAB2(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_YQINIDXZSL();
} else {
setTimeout(SetMethod_YQINIDXZSL,1);
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
if (Eq(varName,'MSGBKOOAOY')) {
last_focused_comp=GetLastFocusedElementOfLink('MSGBKOOAOY');
function SetMethod_MSGBKOOAOY() {
Set_COLLEG(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_MSGBKOOAOY();
} else {
setTimeout(SetMethod_MSGBKOOAOY,1);
}
bResult=true;
}
if (Eq(varName,'VFSCXTRPBT')) {
last_focused_comp=GetLastFocusedElementOfLink('VFSCXTRPBT');
function SetMethod_VFSCXTRPBT() {
Set_CODDIPE(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_VFSCXTRPBT();
} else {
setTimeout(SetMethod_VFSCXTRPBT,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'UJRFWINIVQ')) {
return [Ctrl('UJRFWINIVQ')];
}
if (Eq(varName,'SQVJLYRFKQ')) {
return [Ctrl('SQVJLYRFKQ')];
}
if (Eq(varName,'SRWWPHPCUB')) {
return [Ctrl('SRWWPHPCUB')];
}
if (Eq(varName,'MKCXJZEKIG')) {
return [Ctrl('MKCXJZEKIG')];
}
if (Eq(varName,'RZIQZFKPUE')) {
return [Ctrl('RZIQZFKPUE')];
}
if (Eq(varName,'QBLXDBODXR')) {
return [Ctrl('QBLXDBODXR')];
}
if (Eq(varName,'TCOTJNZLGM')) {
return [Ctrl('TCOTJNZLGM')];
}
if (Eq(varName,'ULVCBLFVEU')) {
return [Ctrl('ULVCBLFVEU')];
}
if (Eq(varName,'HWFHDWYMIU')) {
return [Ctrl('HWFHDWYMIU')];
}
if (Eq(varName,'ODAYKSRECA')) {
return [Ctrl('ODAYKSRECA')];
}
if (Eq(varName,'YVIKEGPYPM')) {
return [Ctrl('YVIKEGPYPM')];
}
if (Eq(varName,'CDJFSCCGNX')) {
return [Ctrl('CDJFSCCGNX')];
}
if (Eq(varName,'NYRJHOZOON')) {
return [Ctrl('NYRJHOZOON')];
}
if (Eq(varName,'YQINIDXZSL')) {
return [Ctrl('YQINIDXZSL')];
}
if (Eq(varName,'AVHTGZTOSZ')) {
return [Ctrl('AVHTGZTOSZ')];
}
if (Eq(varName,'MSGBKOOAOY')) {
return [Ctrl('MSGBKOOAOY')];
}
if (Eq(varName,'VFSCXTRPBT')) {
return [Ctrl('VFSCXTRPBT')];
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
parent.ZtVWeb.raiseEventToEvalParms('armt_kperazbo_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('armt_kperazbo_dataNotSent',{'action':formaction});
}
}
}
}
CheckChild.child=[{'prg':"ardt_clientisara",'BOScId':function(){ return FrameRef('ardt_clientisara')},'repeated':0}];
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
} else if (( ! (_ChkObl('OEIKQOZMYJ',1))) || ( ! (Ge(w_DATAREG,w_DATAOPE)))) {
_SignErr('OEIKQOZMYJ','12128708791');
l_bResult=false;
w_DATAREG=HtW('','D');
} else if ( ! (_ChkObl('PURPSXEVAI',1))) {
_SignErr('PURPSXEVAI');
m_cLastWorkVarErrorMsg='237632211';
l_bResult=false;
w_FLAGCONT=HtW('','C');
} else if ( ! (_ChkObl('UJRFWINIVQ',1))) {
_SignErr('UJRFWINIVQ');
m_cLastWorkVarErrorMsg='11137644647';
l_bResult=false;
w_TIPOOPRAP=HtW('','C');
} else if ( ! (_ChkObl('SQVJLYRFKQ',1))) {
_SignErr('SQVJLYRFKQ');
m_cLastWorkVarErrorMsg='215536597';
l_bResult=false;
w_CODANA=HtW('','C');
} else if ( ! (_ChkObl('SRWWPHPCUB',1))) {
_SignErr('SRWWPHPCUB');
m_cLastWorkVarErrorMsg='215310487';
l_bResult=false;
w_CODVOC=HtW('','C');
} else if ( ! (_ChkObl('LJBMCCABSS',1))) {
_SignErr('LJBMCCABSS');
m_cLastWorkVarErrorMsg='appolire';
l_bResult=false;
w_appolire=HtW('','C');
} else if ( ! (_ChkObl('MKCXJZEKIG',1))) {
_SignErr('MKCXJZEKIG');
m_cLastWorkVarErrorMsg='109710548';
l_bResult=false;
w_VALUTA=HtW('','C');
} else if ( ! (_ChkObl('YTCDGCPEDJ',1))) {
_SignErr('YTCDGCPEDJ');
m_cLastWorkVarErrorMsg='123704147';
l_bResult=false;
w_CAMBIO=HtW('','N');
} else if ( ! (_ChkObl('EDIXWZNSIC',1))) {
_SignErr('EDIXWZNSIC');
m_cLastWorkVarErrorMsg='xTOTLIRE';
l_bResult=false;
w_xTOTLIRE=HtW('','N');
} else if ((Eq(w_FLAGCONT,'1')) && (( ! (_ChkObl('CTORYEJVDR',1))) || ( ! (arfn_chktotalelire_cont(w_DATAOPE,w_datpaseuro,w_xTOTCONT,w_xTOTLIRE))))) {
_SignErr('CTORYEJVDR','11525797640');
l_bResult=false;
w_xTOTCONT=HtW('','N');
} else if ( ! (_ChkObl('RZIQZFKPUE',1))) {
_SignErr('RZIQZFKPUE');
m_cLastWorkVarErrorMsg='10379997930';
l_bResult=false;
w_RAPPORTO=HtW('','C');
} else if ( ! (_ChkObl('QBLXDBODXR',1))) {
_SignErr('QBLXDBODXR');
m_cLastWorkVarErrorMsg='10219814530';
l_bResult=false;
w_CONNESCLI=HtW('','C');
} else if ( ! (_ChkObl('TCOTJNZLGM',1))) {
_SignErr('TCOTJNZLGM');
m_cLastWorkVarErrorMsg='10219814530';
l_bResult=false;
w_CONNESOPER=HtW('','C');
} else if ( ! (_ChkObl('AQSAREJVST',1))) {
_SignErr('AQSAREJVST');
m_cLastWorkVarErrorMsg='14232327';
l_bResult=false;
w_TIPOLEG=HtW('','C');
} else if (( ! (Empty(LRTrim(w_CONNESOPER)))) && ( ! (_ChkObl('JGKMKQMAHS',1)))) {
_SignErr('JGKMKQMAHS');
m_cLastWorkVarErrorMsg='PAGASOGOP';
l_bResult=false;
w_PAGASOGOP='N';
} else if ( ! (_ChkObl('ULVCBLFVEU',1))) {
_SignErr('ULVCBLFVEU');
m_cLastWorkVarErrorMsg='10219814530';
l_bResult=false;
w_CONNESBEN=HtW('','C');
} else if ( ! (_ChkObl('HWFHDWYMIU',1))) {
_SignErr('HWFHDWYMIU');
m_cLastWorkVarErrorMsg='CONNALTRO';
l_bResult=false;
w_CONNALTRO=HtW('','C');
} else if ( ! (_ChkObl('AWPNTOJIRR',1))) {
_SignErr('AWPNTOJIRR');
m_cLastWorkVarErrorMsg='C_RAG';
l_bResult=false;
w_C_RAG=HtW('','C');
} else if ( ! (_ChkObl('ODAYKSRECA',1))) {
_SignErr('ODAYKSRECA');
m_cLastWorkVarErrorMsg='C_CTA';
l_bResult=false;
w_C_CTA=HtW('','C');
} else if ( ! (_ChkObl('NOTZPDMYIA',1))) {
_SignErr('NOTZPDMYIA');
m_cLastWorkVarErrorMsg='C_PRV';
l_bResult=false;
w_C_PRV=HtW('','C');
} else if ( ! (_ChkObl('RDAVOEETJG',1))) {
_SignErr('RDAVOEETJG');
m_cLastWorkVarErrorMsg='C_CAP';
l_bResult=false;
w_C_CAP=HtW('','C');
} else if ( ! (_ChkObl('BOTAJBWHHY',1))) {
_SignErr('BOTAJBWHHY');
m_cLastWorkVarErrorMsg='C_CAB';
l_bResult=false;
w_C_CAB=HtW('','C');
} else if ( ! (_ChkObl('VYLHWTRQNX',1))) {
_SignErr('VYLHWTRQNX');
m_cLastWorkVarErrorMsg='C_IND';
l_bResult=false;
w_C_IND=HtW('','C');
} else if ( ! (_ChkObl('YVIKEGPYPM',1))) {
_SignErr('YVIKEGPYPM');
m_cLastWorkVarErrorMsg='C_STA';
l_bResult=false;
w_C_STA=HtW('','C');
} else if ( ! (_ChkObl('HNMYJPHSQN',1))) {
_SignErr('HNMYJPHSQN');
m_cLastWorkVarErrorMsg='11058698874';
l_bResult=false;
w_TIPOINT2=HtW('','C');
} else if ( ! (_ChkObl('CDJFSCCGNX',1))) {
_SignErr('CDJFSCCGNX');
m_cLastWorkVarErrorMsg='10455298077';
l_bResult=false;
w_CODINT2=HtW('','C');
} else if ( ! (_ChkObl('VYDRMHACRY',1))) {
_SignErr('VYDRMHACRY');
m_cLastWorkVarErrorMsg='DESCINTER';
l_bResult=false;
w_DESCINTER=HtW('','C');
} else if ( ! (_ChkObl('NYRJHOZOON',1))) {
_SignErr('NYRJHOZOON');
m_cLastWorkVarErrorMsg='240702475';
l_bResult=false;
w_PAESE=HtW('','C');
} else if ( ! (_ChkObl('NZZUAIJFDU',1))) {
_SignErr('NZZUAIJFDU');
m_cLastWorkVarErrorMsg='C_RAPPORTO';
l_bResult=false;
w_C_RAPPORTO=HtW('','C');
} else if ( ! (_ChkObl('YQINIDXZSL',1))) {
_SignErr('YQINIDXZSL');
m_cLastWorkVarErrorMsg='11945229207';
l_bResult=false;
w_CODCAB2=HtW('','C');
} else if ( ! (_ChkObl('ACAPFGYRVI',1))) {
_SignErr('ACAPFGYRVI');
m_cLastWorkVarErrorMsg='635233449';
l_bResult=false;
w_PROV2=HtW('','C');
} else if ( ! (_ChkObl('FFCAGQAZHK',1))) {
_SignErr('FFCAGQAZHK');
m_cLastWorkVarErrorMsg='11823283690';
l_bResult=false;
w_DESC2=HtW('','C');
} else if ( ! (_ChkObl('GXMZZZHVBR',1))) {
_SignErr('GXMZZZHVBR');
m_cLastWorkVarErrorMsg='ZCPARTE';
l_bResult=false;
w_ZCPARTE=HtW('','C');
} else if ( ! (_ChkObl('NHERHRZTFP',1))) {
_SignErr('NHERHRZTFP');
m_cLastWorkVarErrorMsg='113866889';
l_bResult=false;
w_IDBASE=HtW('','C');
} else if ( ! (_ChkObl('AVHTGZTOSZ',1))) {
_SignErr('AVHTGZTOSZ');
m_cLastWorkVarErrorMsg='2071283709';
l_bResult=false;
w_CODDIPE=HtW('','C');
} else if ( ! (_ChkObl('QSRYXQJCBZ',1))) {
_SignErr('QSRYXQJCBZ');
m_cLastWorkVarErrorMsg='1722199786';
l_bResult=false;
w_FLAGFRAZ=HtW('','C');
} else if ( ! (_ChkObl('VYBZEWHKFF',1))) {
_SignErr('VYBZEWHKFF');
m_cLastWorkVarErrorMsg='11329559720';
l_bResult=false;
w_DATARETT=HtW('','D');
} else if ((Eq(w_FLAGFRAZ,'2')) && ( ! (_ChkObl('MSGBKOOAOY',1)))) {
_SignErr('MSGBKOOAOY');
m_cLastWorkVarErrorMsg='750412439';
l_bResult=false;
w_COLLEG=HtW('','C');
} else if ( ! (_ChkObl('JDTKGSGMAF',1))) {
_SignErr('JDTKGSGMAF');
m_cLastWorkVarErrorMsg='338061';
l_bResult=false;
w_MTCN=HtW('','C');
} else if ( ! (_ChkObl('VFSCXTRPBT',1))) {
_SignErr('VFSCXTRPBT');
m_cLastWorkVarErrorMsg='2071283709';
l_bResult=false;
w_CODDIPE=HtW('','C');
}
if (l_bResult) {
l_bResult=CheckChild(0);
}
// * --- Area Manuale = UI - Check Form
// * --- armt_kperazbo

if (DateDiff(w_DATAOPE,w_DATAREG) > 30) {
  alert('La differenza tra Data Operazione e Data Registrazione non deve superare i 30gg')
}
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('UJRFWINIVQ_ZOOM',lc)) {
return 0;
}
if (Eq('UJRFWINIVQ',lc)) {
return 0;
}
if (Eq('SQVJLYRFKQ_ZOOM',lc)) {
return 1;
}
if (Eq('SQVJLYRFKQ',lc)) {
return 1;
}
if (Eq('SRWWPHPCUB_ZOOM',lc)) {
return 2;
}
if (Eq('SRWWPHPCUB',lc)) {
return 2;
}
if (Eq('MKCXJZEKIG_ZOOM',lc)) {
return 3;
}
if (Eq('MKCXJZEKIG',lc)) {
return 3;
}
if (Eq('RZIQZFKPUE_ZOOM',lc)) {
return 4;
}
if (Eq('RZIQZFKPUE',lc)) {
return 4;
}
if (Eq('QBLXDBODXR_ZOOM',lc)) {
return 5;
}
if (Eq('QBLXDBODXR',lc)) {
return 5;
}
if (Eq('TCOTJNZLGM_ZOOM',lc)) {
return 6;
}
if (Eq('TCOTJNZLGM',lc)) {
return 6;
}
if (Eq('ULVCBLFVEU_ZOOM',lc)) {
return 7;
}
if (Eq('ULVCBLFVEU',lc)) {
return 7;
}
if (Eq('HWFHDWYMIU_ZOOM',lc)) {
return 8;
}
if (Eq('HWFHDWYMIU',lc)) {
return 8;
}
if (Eq('ODAYKSRECA_ZOOM',lc)) {
return 9;
}
if (Eq('ODAYKSRECA',lc)) {
return 9;
}
if (Eq('YVIKEGPYPM_ZOOM',lc)) {
return 10;
}
if (Eq('YVIKEGPYPM',lc)) {
return 10;
}
if (Eq('CDJFSCCGNX_ZOOM',lc)) {
return 11;
}
if (Eq('CDJFSCCGNX',lc)) {
return 11;
}
if (Eq('NYRJHOZOON_ZOOM',lc)) {
return 12;
}
if (Eq('NYRJHOZOON',lc)) {
return 12;
}
if (Eq('YQINIDXZSL_ZOOM',lc)) {
return 13;
}
if (Eq('YQINIDXZSL',lc)) {
return 13;
}
if (Eq('AVHTGZTOSZ_ZOOM',lc)) {
return 14;
}
if (Eq('AVHTGZTOSZ',lc)) {
return 14;
}
if (Eq('MSGBKOOAOY_ZOOM',lc)) {
return 15;
}
if (Eq('MSGBKOOAOY',lc)) {
return 15;
}
if (Eq('VFSCXTRPBT_ZOOM',lc)) {
return 16;
}
if (Eq('VFSCXTRPBT',lc)) {
return 16;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_UJRFWINIVQ();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
l_cFixedFilter=l_cFixedFilter+l_cAndOp+_flt_('OPERAZIO',w_tipope,'C',true);
if ( ! (Empty(l_cFixedFilter))) {
l_cAndOp=' and ';
}
l_oWv.setValue('FixedFilter',l_cFixedFilter);
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,1)) {
l_oWv=LOpt_SQVJLYRFKQ();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,2)) {
l_oWv=LOpt_SRWWPHPCUB();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
l_cFixedFilter=l_cFixedFilter+l_cAndOp+_flt_('CODCAU',w_CODANA,'C',true);
if ( ! (Empty(l_cFixedFilter))) {
l_cAndOp=' and ';
}
l_oWv.setValue('FixedFilter',l_cFixedFilter);
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,3)) {
l_oWv=LOpt_MKCXJZEKIG();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,4)) {
l_oWv=LOpt_RZIQZFKPUE();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,5)) {
l_oWv=LOpt_QBLXDBODXR();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,6)) {
l_oWv=LOpt_TCOTJNZLGM();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,7)) {
l_oWv=LOpt_ULVCBLFVEU();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,8)) {
l_oWv=LOpt_HWFHDWYMIU();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,9)) {
l_oWv=LOpt_ODAYKSRECA();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,10)) {
l_oWv=LOpt_YVIKEGPYPM();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,11)) {
l_oWv=LOpt_CDJFSCCGNX();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,12)) {
l_oWv=LOpt_NYRJHOZOON();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,13)) {
l_oWv=LOpt_YQINIDXZSL();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,14)) {
l_oWv=LOpt_AVHTGZTOSZ();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,15)) {
l_oWv=LOpt_MSGBKOOAOY();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,16)) {
l_oWv=LOpt_VFSCXTRPBT();
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
l_oWv.setValue('DATAOPE',WtA(w_DATAOPE,'D'));
l_oWv.setValue('CDATOPE',WtA(w_CDATOPE,'C'));
l_oWv.setValue('DATAREG',WtA(w_DATAREG,'D'));
l_oWv.setValue('FLAGCONT',WtA(w_FLAGCONT,'C'));
l_oWv.setValue('TIPOOPRAP',WtA(w_TIPOOPRAP,'C'));
l_oWv.setValue('CODANA',WtA(w_CODANA,'C'));
l_oWv.setValue('CODVOC',WtA(w_CODVOC,'C'));
l_oWv.setValue('FLAGFRAZ',WtA(w_FLAGFRAZ,'C'));
l_oWv.setValue('FLAGLIRE',WtA(w_FLAGLIRE,'C'));
l_oWv.setValue('VALUTA',WtA(w_VALUTA,'C'));
l_oWv.setValue('CAMBIO',WtA(w_CAMBIO,'N'));
l_oWv.setValue('TOTLIRE',WtA(w_TOTLIRE,'N'));
l_oWv.setValue('TOTCONT',WtA(w_TOTCONT,'N'));
l_oWv.setValue('RAPPORTO',WtA(w_RAPPORTO,'C'));
l_oWv.setValue('CONNESCLI',WtA(w_CONNESCLI,'C'));
l_oWv.setValue('CONNESOPER',WtA(w_CONNESOPER,'C'));
l_oWv.setValue('TIPOLEG',WtA(w_TIPOLEG,'C'));
l_oWv.setValue('PAGASOGOP',WtA(w_PAGASOGOP,'C'));
l_oWv.setValue('CONNESBEN',WtA(w_CONNESBEN,'C'));
l_oWv.setValue('CONNALTRO',WtA(w_CONNALTRO,'C'));
l_oWv.setValue('C_RAG',WtA(w_C_RAG,'C'));
l_oWv.setValue('C_CTA',WtA(w_C_CTA,'C'));
l_oWv.setValue('C_PRV',WtA(w_C_PRV,'C'));
l_oWv.setValue('C_CAP',WtA(w_C_CAP,'C'));
l_oWv.setValue('C_CAB',WtA(w_C_CAB,'C'));
l_oWv.setValue('C_IND',WtA(w_C_IND,'C'));
l_oWv.setValue('C_STA',WtA(w_C_STA,'C'));
l_oWv.setValue('TIPOINT2',WtA(w_TIPOINT2,'C'));
l_oWv.setValue('CODINT2',WtA(w_CODINT2,'C'));
l_oWv.setValue('DESCINTER',WtA(w_DESCINTER,'C'));
l_oWv.setValue('PAESE',WtA(w_PAESE,'C'));
l_oWv.setValue('C_RAPPORTO',WtA(w_C_RAPPORTO,'C'));
l_oWv.setValue('CODCAB2',WtA(w_CODCAB2,'C'));
l_oWv.setValue('PROV2',WtA(w_PROV2,'C'));
l_oWv.setValue('DESC2',WtA(w_DESC2,'C'));
l_oWv.setValue('ZCPARTE',WtA(w_ZCPARTE,'C'));
l_oWv.setValue('IDBASE',WtA(w_IDBASE,'C'));
l_oWv.setValue('op_IDBASE',WtA(op_IDBASE,'C'));
l_oWv.setValue('NUMPROG',WtA(w_NUMPROG,'C'));
l_oWv.setValue('op_NUMPROG',WtA(op_NUMPROG,'C'));
l_oWv.setValue('CODINTER',WtA(w_CODINTER,'C'));
l_oWv.setValue('TIPOINF',WtA(w_TIPOINF,'C'));
l_oWv.setValue('IDEREG',WtA(w_IDEREG,'C'));
l_oWv.setValue('CODDIPE',WtA(w_CODDIPE,'C'));
l_oWv.setValue('DESCCIT',WtA(w_DESCCIT,'C'));
l_oWv.setValue('FLAGRAP',WtA(w_FLAGRAP,'C'));
l_oWv.setValue('OPRAP',WtA(w_OPRAP,'C'));
l_oWv.setValue('SEGNO',WtA(w_SEGNO,'C'));
l_oWv.setValue('OPERAZMOD',WtA(w_OPERAZMOD,'C'));
l_oWv.setValue('RAPPORTBEN',WtA(w_RAPPORTBEN,'C'));
l_oWv.setValue('OPERATORE',WtA(w_OPERATORE,'C'));
l_oWv.setValue('AUTOM',WtA(w_AUTOM,'C'));
l_oWv.setValue('DATARETT',WtA(w_DATARETT,'D'));
l_oWv.setValue('COLLEG',WtA(w_COLLEG,'C'));
l_oWv.setValue('FLAGRAP2',WtA(w_FLAGRAP2,'C'));
l_oWv.setValue('STATOREG',WtA(w_STATOREG,'C'));
l_oWv.setValue('PROVINCIA',WtA(w_PROVINCIA,'C'));
l_oWv.setValue('CODCAB',WtA(w_CODCAB,'C'));
l_oWv.setValue('PRGIMPOPE',WtA(w_PRGIMPOPE,'N'));
l_oWv.setValue('op_PRGIMPOPE',WtA(op_PRGIMPOPE,'N'));
l_oWv.setValue('CDATAOPE',WtA(w_CDATAOPE,'C'));
l_oWv.setValue('CONNESDOC',WtA(w_CONNESDOC,'C'));
l_oWv.setValue('MTCN',WtA(w_MTCN,'C'));
l_oWv.setValue('CDATREG',WtA(w_CDATREG,'C'));
l_oWv.setValue('filtro',WtA(w_filtro,'C'));
l_oWv.setValue('tipope',WtA(w_tipope,'C'));
l_oWv.setValue('appolire',WtA(w_appolire,'C'));
l_oWv.setValue('xTOTLIRE',WtA(w_xTOTLIRE,'N'));
l_oWv.setValue('xTOTCONT',WtA(w_xTOTCONT,'N'));
l_oWv.setValue('gIntemediario',WtA(w_gIntemediario,'C'));
l_oWv.setValue('xdes1',WtA(w_xdes1,'C'));
l_oWv.setValue('desccauana',WtA(w_desccauana,'C'));
l_oWv.setValue('xdesccausin',WtA(w_xdesccausin,'C'));
l_oWv.setValue('descdiv',WtA(w_descdiv,'C'));
l_oWv.setValue('xragsocper',WtA(w_xragsocper,'C'));
l_oWv.setValue('xdescrap',WtA(w_xdescrap,'C'));
l_oWv.setValue('xragsocct',WtA(w_xragsocct,'C'));
l_oWv.setValue('xragsocben',WtA(w_xragsocben,'C'));
l_oWv.setValue('xdestipleg',WtA(w_xdestipleg,'C'));
l_oWv.setValue('xragint2',WtA(w_xragint2,'C'));
l_oWv.setValue('xdescpaese2',WtA(w_xdescpaese2,'C'));
l_oWv.setValue('datpaseuro',WtA(w_datpaseuro,'D'));
l_oWv.setValue('xDescDipe',WtA(w_xDescDipe,'C'));
l_oWv.setValue('sEdit',WtA(w_sEdit,'N'));
l_oWv.setValue('gChkDate',WtA(w_gChkDate,'C'));
l_oWv.setValue('errmsg',WtA(w_errmsg,'C'));
l_oWv.setValue('test',WtA(w_test,'C'));
l_oWv.setValue('valflg2',WtA(w_valflg2,'C'));
l_oWv.setValue('gTipInter',WtA(w_gTipInter,'C'));
l_oWv.setValue('gSblocco',WtA(w_gSblocco,'C'));
l_oWv.setValue('xdescmodsvo',WtA(w_xdescmodsvo,'C'));
l_oWv.setValue('xdescareag',WtA(w_xdescareag,'C'));
l_oWv.setValue('xdescplauso',WtA(w_xdescplauso,'C'));
l_oWv.setValue('xdesctipor',WtA(w_xdesctipor,'C'));
l_oWv.setValue('xdescopeage',WtA(w_xdescopeage,'C'));
l_oWv.setValue('xcodfisc',WtA(w_xcodfisc,'C'));
l_oWv.setValue('dataoggi',WtA(w_dataoggi,'D'));
l_oWv.setValue('stringaflagrap2',WtA(w_stringaflagrap2,'C'));
l_oWv.setValue('xdescfreq',WtA(w_xdescfreq,'C'));
l_oWv.setValue('xdescammo',WtA(w_xdescammo,'C'));
l_oWv.setValue('gDataVaria',WtA(w_gDataVaria,'D'));
l_oWv.setValue('gStatus',WtA(w_gStatus,'C'));
l_oWv.setValue('CITINT',WtA(w_CITINT,'C'));
l_oWv.setValue('CITDIP',WtA(w_CITDIP,'C'));
l_oWv.setValue('PROVDIP',WtA(w_PROVDIP,'C'));
l_oWv.setValue('CABDIP',WtA(w_CABDIP,'C'));
l_oWv.setValue('PROVINT',WtA(w_PROVINT,'C'));
l_oWv.setValue('CABINT',WtA(w_CABINT,'C'));
l_oWv.setValue('gFlgDoc',WtA(w_gFlgDoc,'C'));
l_oWv.setValue('xtiporap',WtA(w_xtiporap,'C'));
l_oWv.setValue('dessta',WtA(w_dessta,'C'));
l_oWv.setValue('xragsocalt',WtA(w_xragsocalt,'C'));
l_oWv.setValue('xdciticon',WtA(w_xdciticon,'C'));
l_oWv.setValue('gFlgWU',WtA(w_gFlgWU,'C'));
l_oWv.setValue('prova',WtA(w_prova,'N'));
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
_FillChildren.n=['ardt_clientisara'];
FillWv.n=["DATAOPE","CDATOPE","DATAREG","FLAGCONT","TIPOOPRAP","CODANA","CODVOC","FLAGFRAZ","FLAGLIRE","VALUTA","CAMBIO","TOTLIRE","TOTCONT","RAPPORTO","CONNESCLI","CONNESOPER","TIPOLEG","PAGASOGOP","CONNESBEN","CONNALTRO","C_RAG","C_CTA","C_PRV","C_CAP","C_CAB","C_IND","C_STA","TIPOINT2","CODINT2","DESCINTER","PAESE","C_RAPPORTO","CODCAB2","PROV2","DESC2","ZCPARTE","IDBASE","NUMPROG","CODINTER","TIPOINF","IDEREG","CODDIPE","DESCCIT","FLAGRAP","OPRAP","SEGNO","OPERAZMOD","RAPPORTBEN","OPERATORE","AUTOM","DATARETT","COLLEG","FLAGRAP2","STATOREG","PROVINCIA","CODCAB","PRGIMPOPE","CDATAOPE","CONNESDOC","MTCN","CDATREG","filtro","tipope","appolire","xTOTLIRE","xTOTCONT","gIntemediario","xdes1","desccauana","xdesccausin","descdiv","xragsocper","xdescrap","xragsocct","xragsocben","xdestipleg","xragint2","xdescpaese2","datpaseuro","xDescDipe","sEdit","gChkDate","errmsg","test","valflg2","gTipInter","gSblocco","xdescmodsvo","xdescareag","xdescplauso","xdesctipor","xdescopeage","xcodfisc","dataoggi","stringaflagrap2","xdescfreq","xdescammo","gDataVaria","gStatus","CITINT","CITDIP","PROVDIP","CABDIP","PROVINT","CABINT","gFlgDoc","xtiporap","dessta","xragsocalt","xdciticon","gFlgWU","prova"];
function SetModified() {
m_bUpdated=true;
}
function SetChildVariables_ardt_clientisara() {
}
function CtxLoad_ardt_clientisara() {
if (ChildToLoad(FrameRef('ardt_clientisara'))) {
return [LoadContext(0,'BOAFVDQFRN'),'ardt_clientisara'];
}
}
