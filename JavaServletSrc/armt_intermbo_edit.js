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
function DisplayErrorMessage_ardt_destwarn() {
if ( ! (ChildToLoad(FrameRef('ardt_destwarn'))) && Ne(typeof(FrameRef('ardt_destwarn').DisplayErrorMessage),'undefined')) {
FrameRef('ardt_destwarn').DisplayErrorMessage();
}
}
function DisplayErrorMessage_ardt_cgo_tipall() {
if ( ! (ChildToLoad(FrameRef('ardt_cgo_tipall'))) && Ne(typeof(FrameRef('ardt_cgo_tipall').DisplayErrorMessage),'undefined')) {
FrameRef('ardt_cgo_tipall').DisplayErrorMessage();
}
}
function DisplayErrorMessage_ardt_cgo_subnets() {
if ( ! (ChildToLoad(FrameRef('ardt_cgo_subnets'))) && Ne(typeof(FrameRef('ardt_cgo_subnets').DisplayErrorMessage),'undefined')) {
FrameRef('ardt_cgo_subnets').DisplayErrorMessage();
}
}
function DisplayErrorMessage_ardt_destemail() {
if ( ! (ChildToLoad(FrameRef('ardt_destemail'))) && Ne(typeof(FrameRef('ardt_destemail').DisplayErrorMessage),'undefined')) {
FrameRef('ardt_destemail').DisplayErrorMessage();
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
l_bEnabled= ! (Ne(w_tipsot,'0') && Ne(w_tipsot,'2')) || IsDisabledByStateDriver('RAMOGRUP');
SetDisabled('RVNHQCXNEM',l_bEnabled);
SetDisabled(Ctrl('RVNHQCXNEM_ZOOM'),l_bEnabled);
l_bEnabled= ! (Eq(w_ITFLGPEP,'S')) || IsDisabledByStateDriver('ITPWDPEP');
SetDisabled('VDJMSNZEEV',l_bEnabled);
l_bEnabled= ! (Eq(w_ITFLGPEP,'S')) || IsDisabledByStateDriver('ITUSRPEP');
SetDisabled('LNADTKDHIZ',l_bEnabled);
l_bEnabled= ! (Eq(w_FLGSCDFRZ,'S')) || IsDisabledByStateDriver('GIORNIFRZ');
SetDisabled('BMMUPRLVUU',l_bEnabled);
l_bEnabled= ! (false) || IsDisabledByStateDriver('PATHSID');
SetDisabled('EMDHDDRUPP',l_bEnabled);
if (IsDisabledByStateDriver('DatiBase')) {
DisableInputsInContainer(Ctrl('YORQOIOBQN'),true);
}
if (IsDisabledByStateDriver('box_BWMEEFCWMJ')) {
DisableInputsInContainer(Ctrl('BWMEEFCWMJ'),true);
}
if (IsDisabledByStateDriver('box_FJJCZFOQTA')) {
DisableInputsInContainer(Ctrl('FJJCZFOQTA'),true);
}
if (IsDisabledByStateDriver('box_PRFPRMFSTZ')) {
DisableInputsInContainer(Ctrl('PRFPRMFSTZ'),true);
}
if (IsDisabledByStateDriver('ParamBase')) {
DisableInputsInContainer(Ctrl('POUNPHSDYV'),true);
}
if (IsDisabledByStateDriver('PEP')) {
DisableInputsInContainer(Ctrl('CCPBATRTRJ'),true);
}
if (IsDisabledByStateDriver('CGOEmail')) {
DisableInputsInContainer(Ctrl('DQBIMZLTTE'),true);
}
if (IsDisabledByStateDriver('Import')) {
DisableInputsInContainer(Ctrl('XFBWYNZQZN'),true);
}
if (IsDisabledByStateDriver('Cambiavalute')) {
DisableInputsInContainer(Ctrl('CESCBNVXDE'),true);
}
if (IsDisabledByStateDriver('Base9Cambia')) {
DisableInputsInContainer(Ctrl('XEDASKHZOQ'),true);
}
if (IsDisabledByStateDriver('DestWarn')) {
DisableInputsInContainer(Ctrl('HDNWLIPNPD'),true);
}
if (IsDisabledByStateDriver('OAM')) {
DisableInputsInContainer(Ctrl('TQULLVKAWF'),true);
}
if (IsDisabledByStateDriver('CGO')) {
DisableInputsInContainer(Ctrl('VSXUXPIOIH'),true);
}
if (IsDisabledByStateDriver('Socket')) {
DisableInputsInContainer(Ctrl('NGHUXVAVYG'),true);
}
if (IsDisabledByStateDriver('RespAnti')) {
DisableInputsInContainer(Ctrl('ENNTXFKBDB'),true);
}
if (IsDisabledByStateDriver('CGOEmail')) {
DisableInputsInContainer(Ctrl('AMSHYBLKWR'),true);
}
if (IsDisabledByStateDriver('GesDOC')) {
DisableInputsInContainer(Ctrl('KNXWNOJPJB'),true);
}
if (IsDisabledByStateDriver('box_EOMKPJOLGE')) {
DisableInputsInContainer(Ctrl('EOMKPJOLGE'),true);
}
if (IsDisabledByStateDriver('E-Learning')) {
DisableInputsInContainer(Ctrl('MFFCPIVYZD'),true);
}
if (IsDisabledByStateDriver('Multiple')) {
DisableInputsInContainer(Ctrl('UYDQCWOOEO'),true);
}
if (IsDisabledByStateDriver('ExtSO')) {
DisableInputsInContainer(Ctrl('QSIBTTRMLJ'),true);
}
if (IsDisabledByStateDriver('DestEmail')) {
DisableInputsInContainer(Ctrl('YAITYOPUEH'),true);
}
if (IsDisabledByStateDriver('ImportVLT')) {
DisableInputsInContainer(Ctrl('MKILJOCTZW'),true);
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
SetObligatory(Ctrl('ATYYTAXDZW'), ! (Empty(LRTrim(w_SOSHELLCMD))) || IsObligatoryByStateDriver('SOAMBIENTE'));
}
function SetDynamicClasses() {
var c;
}
function SetDynamicTooltip() {
var c;
}
function Set_TIPINTER(ctrlValue,kmode,e) {
if (Ne(w_TIPINTER,ctrlValue)) {
var ctl = _GetCtl(e,'JXOBOAXKRQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_TIPINTER=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('JXOBOAXKRQ',0);
if (l_bResult) {
l_bResult=Link_JXOBOAXKRQ(kmode);
if ( ! (l_bResult)) {
w_TIPINTER=HtW('','C');
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
function Set_RAGSOC(ctrlValue,kmode,e) {
if (Ne(w_RAGSOC,ctrlValue)) {
var ctl = _GetCtl(e,'HVIUTGJWGE');
if (_tracker.goon(ctl,ctrlValue)) {
w_RAGSOC=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HVIUTGJWGE',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('HVIUTGJWGE',function(){return WtH(w_RAGSOC,'C',70,0,'@!')},w_RAGSOC);
return l_bResult;
} else {
ctl.value=WtH('','C',70,0,'@!');
_ResetTracker();
return true;
}
}
return true;
}
function Set_DESCCIT(ctrlValue,kmode,e) {
if (Ne(w_DESCCIT,ctrlValue)) {
var ctl = _GetCtl(e,'JCGROGAZTR');
if (_tracker.goon(ctl,ctrlValue)) {
w_DESCCIT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('JCGROGAZTR',0);
if (l_bResult) {
l_bResult=Link_JCGROGAZTR(kmode);
if ( ! (l_bResult)) {
w_DESCCIT=HtW('','C');
}
}
l_bResult=l_bResult && _ChkObl('PZGXGIZQWY',0);
if (l_bResult) {
l_bResult=Link_PZGXGIZQWY(kmode);
if ( ! (l_bResult)) {
w_DESCCIT=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',30,0,''));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',30,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_PROVINCIA(ctrlValue,kmode,e) {
if (Ne(w_PROVINCIA,ctrlValue)) {
var ctl = _GetCtl(e,'UQKLCBCTLH');
if (_tracker.goon(ctl,ctrlValue)) {
w_PROVINCIA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UQKLCBCTLH',0);
l_bResult=l_bResult && _ChkObl('MUWSLBTIOI',0);
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
var ctl = _GetCtl(e,'BQSGHFQUHM');
if (_tracker.goon(ctl,ctrlValue)) {
w_CAP=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BQSGHFQUHM',0);
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
var ctl = _GetCtl(e,'IXWLDAOCFD');
if (_tracker.goon(ctl,ctrlValue)) {
w_CODCAB=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('IXWLDAOCFD',0);
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
var ctl = _GetCtl(e,'SJHNBZJAKA');
if (_tracker.goon(ctl,ctrlValue)) {
w_DOMICILIO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SJHNBZJAKA',0);
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
function Set_PAESE(ctrlValue,kmode,e) {
if (Ne(w_PAESE,ctrlValue)) {
var ctl = _GetCtl(e,'IIXRREUEAM');
if (_tracker.goon(ctl,ctrlValue)) {
w_PAESE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('IIXRREUEAM',0);
if (l_bResult) {
l_bResult=Link_IIXRREUEAM(kmode);
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
function Set_CODFISC(ctrlValue,kmode,e) {
if (Ne(w_CODFISC,ctrlValue)) {
var ctl = _GetCtl(e,'SZWCLLEIQY');
if (_tracker.goon(ctl,ctrlValue)) {
w_CODFISC=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SZWCLLEIQY',0);
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
function Set_PARTIVA(ctrlValue,kmode,e) {
if (Ne(w_PARTIVA,ctrlValue)) {
var ctl = _GetCtl(e,'OIWIANSIOG');
if (_tracker.goon(ctl,ctrlValue)) {
w_PARTIVA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('OIWIANSIOG',0);
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
function Set_DATANASC(ctrlValue,kmode,e) {
if (Ne(w_DATANASC,ctrlValue)) {
var ctl = _GetCtl(e,'TNUQTSSGFZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_DATANASC=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('TNUQTSSGFZ',0);
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
function Set_TIPODOC(ctrlValue,kmode,e) {
if (Ne(w_TIPODOC,ctrlValue)) {
var ctl = _GetCtl(e,'AYYXYNLAUC');
if (_tracker.goon(ctl,ctrlValue)) {
w_TIPODOC=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('AYYXYNLAUC',0);
if (l_bResult) {
l_bResult=Link_AYYXYNLAUC(kmode);
if ( ! (l_bResult)) {
w_TIPODOC=HtW('','C');
}
}
l_bResult=l_bResult && _ChkObl('KYNLIGXUVC',0);
if (l_bResult) {
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
function Set_SESSO(ctrlValue,kmode,e) {
if (Ne(w_SESSO,ctrlValue)) {
var ctl = _GetCtl(e,'OREVCZVNVS');
if (_tracker.goon(ctl,ctrlValue)) {
w_SESSO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('OREVCZVNVS',0);
l_bResult=l_bResult && _ChkObl('SIJUUSKFLV',0);
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
function Set_NUMDOCUM(ctrlValue,kmode,e) {
if (Ne(w_NUMDOCUM,ctrlValue)) {
var ctl = _GetCtl(e,'XCNHFVDZMT');
if (_tracker.goon(ctl,ctrlValue)) {
w_NUMDOCUM=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XCNHFVDZMT',0);
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
var ctl = _GetCtl(e,'ZYURNYDRPU');
if (_tracker.goon(ctl,ctrlValue)) {
w_DATARILASC=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ZYURNYDRPU',0);
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
function Set_AUTRILASC(ctrlValue,kmode,e) {
if (Ne(w_AUTRILASC,ctrlValue)) {
var ctl = _GetCtl(e,'YYONLOLCBB');
if (_tracker.goon(ctl,ctrlValue)) {
w_AUTRILASC=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YYONLOLCBB',0);
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
function Set_CODDIPE(ctrlValue,kmode,e) {
if (Ne(w_CODDIPE,ctrlValue)) {
var ctl = _GetCtl(e,'PSZTLCSMPB');
if (_tracker.goon(ctl,ctrlValue)) {
w_CODDIPE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('PSZTLCSMPB',0);
if (l_bResult) {
l_bResult=Link_PSZTLCSMPB(kmode);
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
function Set_CGOTGDEFMUL(ctrlValue,kmode,e) {
if (Ne(w_CGOTGDEFMUL,ctrlValue)) {
var ctl = _GetCtl(e,'PDLIXDKBWK');
if (_tracker.goon(ctl,ctrlValue)) {
w_CGOTGDEFMUL=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('GORKFABVFF',0);
l_bResult=l_bResult && _ChkObl('PDLIXDKBWK',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('N','C',3,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_NOTE(ctrlValue,kmode,e) {
if (Ne(w_NOTE,ctrlValue)) {
var ctl = _GetCtl(e,'COVTIKSDDS');
if (_tracker.goon(ctl,ctrlValue)) {
w_NOTE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('COVTIKSDDS',0);
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
function Set_CODORO(ctrlValue,kmode,e) {
if (Ne(w_CODORO,ctrlValue)) {
var ctl = _GetCtl(e,'WSAOVXNTFO');
if (_tracker.goon(ctl,ctrlValue)) {
w_CODORO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('WSAOVXNTFO',0);
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
function Set_CODINTER(ctrlValue,kmode,e) {
if (Ne(w_CODINTER,ctrlValue)) {
var ctl = _GetCtl(e,'YPYQJILEQY');
if (_tracker.goon(ctl,ctrlValue)) {
w_CODINTER=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YPYQJILEQY',0);
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
function Set_ALTPWDMAIL(ctrlValue,kmode,e) {
if (Ne(w_ALTPWDMAIL,ctrlValue)) {
var ctl = _GetCtl(e,'LGVTLPSUGS');
if (_tracker.goon(ctl,ctrlValue)) {
w_ALTPWDMAIL=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('IIVBDSFKCC',0);
l_bResult=l_bResult && _ChkObl('LGVTLPSUGS',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('LGVTLPSUGS',function(){return WtH(w_ALTPWDMAIL,'C',80,0,'')},w_ALTPWDMAIL);
return l_bResult;
} else {
ctl.value=WtH('','C',80,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_ALTSSLEMAIL(ctrlValue,kmode,e) {
if (Ne(w_ALTSSLEMAIL,ctrlValue)) {
var ctl = _GetCtl(e,'KPSLGRAIIO');
if (_tracker.goon(ctl,ctrlValue)) {
w_ALTSSLEMAIL=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('KPSLGRAIIO',0);
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
function Set_SOORAIMPORT(ctrlValue,kmode,e) {
if (Ne(w_SOORAIMPORT,ctrlValue)) {
var ctl = _GetCtl(e,'APTIWOKBUI');
if (_tracker.goon(ctl,ctrlValue)) {
w_SOORAIMPORT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('APTIWOKBUI',0);
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
function Set_SOPATHIMPORT(ctrlValue,kmode,e) {
if (Ne(w_SOPATHIMPORT,ctrlValue)) {
var ctl = _GetCtl(e,'GHUASLAKBC');
if (_tracker.goon(ctl,ctrlValue)) {
w_SOPATHIMPORT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('GHUASLAKBC',0);
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
function Set_SOAMBIENTE(ctrlValue,kmode,e) {
if (Ne(w_SOAMBIENTE,ctrlValue)) {
var ctl = _GetCtl(e,'ATYYTAXDZW');
if (_tracker.goon(ctl,ctrlValue)) {
w_SOAMBIENTE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ATYYTAXDZW',0);
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
function Set_SOSHELLCMD(ctrlValue,kmode,e) {
if (Ne(w_SOSHELLCMD,ctrlValue)) {
var ctl = _GetCtl(e,'IDOPVICMXL');
if (_tracker.goon(ctl,ctrlValue)) {
w_SOSHELLCMD=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('IDOPVICMXL',0);
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
function Set_SOMESIBACK(ctrlValue,kmode,e) {
if (Ne(w_SOMESIBACK,ctrlValue)) {
var ctl = _GetCtl(e,'OAAOYRQPRR');
if (_tracker.goon(ctl,ctrlValue)) {
w_SOMESIBACK=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('OAAOYRQPRR',0);
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
function Set_SONUMMESI(ctrlValue,kmode,e) {
if (Ne(w_SONUMMESI,ctrlValue)) {
var ctl = _GetCtl(e,'HAPCMCIYJW');
if (_tracker.goon(ctl,ctrlValue)) {
w_SONUMMESI=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HAPCMCIYJW',0);
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
function Set_IMPPATH(ctrlValue,kmode,e) {
if (Ne(w_IMPPATH,ctrlValue)) {
var ctl = _GetCtl(e,'ABFCWFBDMW');
if (_tracker.goon(ctl,ctrlValue)) {
w_IMPPATH=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ABFCWFBDMW',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',240,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_DATAVALI(ctrlValue,kmode,e) {
if (Ne(w_DATAVALI,ctrlValue)) {
var ctl = _GetCtl(e,'MXHAWWCAZX');
if (_tracker.goon(ctl,ctrlValue)) {
w_DATAVALI=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MXHAWWCAZX',0);
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
function Set_PATHIMPORT(ctrlValue,kmode,e) {
if (Ne(w_PATHIMPORT,ctrlValue)) {
var ctl = _GetCtl(e,'YRAEGOUXRJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_PATHIMPORT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YRAEGOUXRJ',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',128,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_PATHDOCBAC(ctrlValue,kmode,e) {
if (Ne(w_PATHDOCBAC,ctrlValue)) {
var ctl = _GetCtl(e,'MRRDOEHYLX');
if (_tracker.goon(ctl,ctrlValue)) {
w_PATHDOCBAC=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MRRDOEHYLX',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',128,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_DATADOC(ctrlValue,kmode,e) {
if (Ne(w_DATADOC,ctrlValue)) {
var ctl = _GetCtl(e,'VOONRSAKSU');
if (_tracker.goon(ctl,ctrlValue)) {
w_DATADOC=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VOONRSAKSU',0);
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
function Set_CFINVIO(ctrlValue,kmode,e) {
if (Ne(w_CFINVIO,ctrlValue)) {
var ctl = _GetCtl(e,'TFMCRMSOGY');
if (_tracker.goon(ctl,ctrlValue)) {
w_CFINVIO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('TFMCRMSOGY',0);
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
function Set_CAFINVIO(ctrlValue,kmode,e) {
if (Ne(w_CAFINVIO,ctrlValue)) {
var ctl = _GetCtl(e,'YUCSUDKWNH');
if (_tracker.goon(ctl,ctrlValue)) {
w_CAFINVIO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YUCSUDKWNH',0);
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
function Set_FILEINVIO(ctrlValue,kmode,e) {
if (Ne(w_FILEINVIO,ctrlValue)) {
var ctl = _GetCtl(e,'JSTXCUBOUH');
if (_tracker.goon(ctl,ctrlValue)) {
w_FILEINVIO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('JSTXCUBOUH',0);
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
function Set_DATAINVIO(ctrlValue,kmode,e) {
if (Ne(w_DATAINVIO,ctrlValue)) {
var ctl = _GetCtl(e,'YOVFWZCOBN');
if (_tracker.goon(ctl,ctrlValue)) {
w_DATAINVIO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YOVFWZCOBN',0);
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
function Set_IDSID(ctrlValue,kmode,e) {
if (Ne(w_IDSID,ctrlValue)) {
var ctl = _GetCtl(e,'QPIRUTKOVH');
if (_tracker.goon(ctl,ctrlValue)) {
w_IDSID=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QPIRUTKOVH',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',8,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_SIDPASS(ctrlValue,kmode,e) {
if (Ne(w_SIDPASS,ctrlValue)) {
var ctl = _GetCtl(e,'ULCBOSJURF');
if (_tracker.goon(ctl,ctrlValue)) {
w_SIDPASS=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ULCBOSJURF',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('ULCBOSJURF',function(){return WtH(w_SIDPASS,'C',30,0,'')},w_SIDPASS);
return l_bResult;
} else {
ctl.value=WtH('','C',30,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_PATHJAVA(ctrlValue,kmode,e) {
if (Ne(w_PATHJAVA,ctrlValue)) {
var ctl = _GetCtl(e,'KHHILRUMHZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_PATHJAVA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('KHHILRUMHZ',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',250,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_TIPOINST(ctrlValue,kmode,e) {
if (Ne(w_TIPOINST,ctrlValue)) {
var ctl = _GetCtl(e,'ELBURHNYTV');
if (_tracker.goon(ctl,ctrlValue)) {
w_TIPOINST=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ELBURHNYTV',0);
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
function Set_FLGSIDAUTO(ctrlValue,kmode,e) {
if (Ne(w_FLGSIDAUTO,ctrlValue)) {
var ctl = _GetCtl(e,'JYYHNLJDWT');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLGSIDAUTO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('JYYHNLJDWT',0);
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
function Set_DNASC(ctrlValue,kmode,e) {
if (Ne(w_DNASC,ctrlValue)) {
var ctl = _GetCtl(e,'XCZARGUGTG');
if (_tracker.goon(ctl,ctrlValue)) {
w_DNASC=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XCZARGUGTG',0);
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
function Set_EMAILDOC(ctrlValue,kmode,e) {
if (Ne(w_EMAILDOC,ctrlValue)) {
var ctl = _GetCtl(e,'LZEBZLGWCH');
if (_tracker.goon(ctl,ctrlValue)) {
w_EMAILDOC=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('LZEBZLGWCH',0);
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
function Set_appocert(ctrlValue,kmode,e) {
if (Ne(w_appocert,ctrlValue)) {
var ctl = _GetCtl(e,'FLPFDBFHXV');
if (_tracker.goon(ctl,ctrlValue)) {
w_appocert=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FLPFDBFHXV',0);
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
function Set_TIPOSV(ctrlValue,kmode,e) {
if (Ne(w_TIPOSV,ctrlValue)) {
var ctl = _GetCtl(e,'LYZAJWZGAM');
if (_tracker.goon(ctl,ctrlValue)) {
w_TIPOSV=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('LYZAJWZGAM',0);
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
function Set_LIMITE20(ctrlValue,kmode,e) {
if (Ne(w_LIMITE20,ctrlValue)) {
var ctl = _GetCtl(e,'LAQADJFMRL');
if (_tracker.goon(ctl,ctrlValue)) {
w_LIMITE20=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('LAQADJFMRL',0);
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
function Set_CODVASP(ctrlValue,kmode,e) {
if (Ne(w_CODVASP,ctrlValue)) {
var ctl = _GetCtl(e,'FTETLDBHIY');
if (_tracker.goon(ctl,ctrlValue)) {
w_CODVASP=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FTETLDBHIY',0);
l_bResult=l_bResult && _ChkObl('CMBYXKAJCS',0);
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
function Set_ART1(ctrlValue,kmode,e) {
if (Ne(w_ART1,ctrlValue)) {
var ctl = _GetCtl(e,'CWVJUDEVCT');
if (_tracker.goon(ctl,ctrlValue)) {
w_ART1=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CWVJUDEVCT',0);
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
function Set_URLAPPL(ctrlValue,kmode,e) {
if (Ne(w_URLAPPL,ctrlValue)) {
var ctl = _GetCtl(e,'FPFLFCPHAL');
if (_tracker.goon(ctl,ctrlValue)) {
w_URLAPPL=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
var l_bWarn = true;
l_bResult=_ChkObl('FPFLFCPHAL',0);
if (l_bResult) {
if (l_bResult && ( ! (Empty(w_URLAPPL)) && Ne(m_nLastError,-2))) {
try {
_tracker.askwrn=true;
l_bWarn=WindowConfirm(AlertErrorMessage('393905681'));
} finally {
_tracker.askwrn=false;
}
}
if ( ! (l_bResult) ||  ! (l_bWarn)) {
w_URLAPPL=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult) ||  ! (l_bWarn)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',80,0,''));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',80,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_FLGLOG(ctrlValue,kmode,e) {
if (Ne(w_FLGLOG,ctrlValue)) {
var ctl = _GetCtl(e,'EOQVPQLKOP');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLGLOG=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('EOQVPQLKOP',0);
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
function Set_FLGAOS(ctrlValue,kmode,e) {
if (Ne(w_FLGAOS,ctrlValue)) {
var ctl = _GetCtl(e,'BLWLPTWCFV');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLGAOS=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BLWLPTWCFV',0);
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
function Set_FLGEAOS(ctrlValue,kmode,e) {
if (Ne(w_FLGEAOS,ctrlValue)) {
var ctl = _GetCtl(e,'REBGPUSIPL');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLGEAOS=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('REBGPUSIPL',0);
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
function Set_FLGCDOC(ctrlValue,kmode,e) {
if (Ne(w_FLGCDOC,ctrlValue)) {
var ctl = _GetCtl(e,'HKDCUQQHSU');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLGCDOC=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HKDCUQQHSU',0);
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
function Set_FLGFRAZ(ctrlValue,kmode,e) {
if (Ne(w_FLGFRAZ,ctrlValue)) {
var ctl = _GetCtl(e,'CCBVEBVMNW');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLGFRAZ=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CCBVEBVMNW',0);
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
function Set_FLGAPERS(ctrlValue,kmode,e) {
if (Ne(w_FLGAPERS,ctrlValue)) {
var ctl = _GetCtl(e,'IDROHZZWYH');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLGAPERS=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('IDROHZZWYH',0);
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
function Set_DTINIATT(ctrlValue,kmode,e) {
if (Ne(w_DTINIATT,ctrlValue)) {
var ctl = _GetCtl(e,'IQOQQQRZAK');
if (_tracker.goon(ctl,ctrlValue)) {
w_DTINIATT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('IQOQQQRZAK',0);
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
function Set_FLGTIPIMP(ctrlValue,kmode,e) {
if (Ne(w_FLGTIPIMP,ctrlValue)) {
var ctl = _GetCtl(e,'ZPSOMDIBXB');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLGTIPIMP=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ZPSOMDIBXB',0);
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
function Set_FLGSTPCON(ctrlValue,kmode,e) {
if (Ne(w_FLGSTPCON,ctrlValue)) {
var ctl = _GetCtl(e,'PIGFPYZMIR');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLGSTPCON=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('PIGFPYZMIR',0);
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
function Set_FLGIMPAGE(ctrlValue,kmode,e) {
if (Ne(w_FLGIMPAGE,ctrlValue)) {
var ctl = _GetCtl(e,'DUFIQNBDKW');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLGIMPAGE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('DUFIQNBDKW',0);
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
function Set_FLGWU(ctrlValue,kmode,e) {
if (Ne(w_FLGWU,ctrlValue)) {
var ctl = _GetCtl(e,'LOYILZBSVI');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLGWU=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('LOYILZBSVI',0);
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
function Set_IMPINTOPE(ctrlValue,kmode,e) {
if (Ne(w_IMPINTOPE,ctrlValue)) {
var ctl = _GetCtl(e,'YJCSSLPJKG');
if (_tracker.goon(ctl,ctrlValue)) {
w_IMPINTOPE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YJCSSLPJKG',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','N',12,2,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_FLGOPEXTR(ctrlValue,kmode,e) {
if (Ne(w_FLGOPEXTR,ctrlValue)) {
var ctl = _GetCtl(e,'PXNLADGGBR');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLGOPEXTR=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('PXNLADGGBR',0);
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
function Set_FLGRAPCLI(ctrlValue,kmode,e) {
if (Ne(w_FLGRAPCLI,ctrlValue)) {
var ctl = _GetCtl(e,'OSHAMNPXFT');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLGRAPCLI=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('OSHAMNPXFT',0);
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
function Set_BPENTSEG(ctrlValue,kmode,e) {
if (Ne(w_BPENTSEG,ctrlValue)) {
var ctl = _GetCtl(e,'PBQXUDZUOZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_BPENTSEG=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('PBQXUDZUOZ',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',12,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_BPCOGSEG(ctrlValue,kmode,e) {
if (Ne(w_BPCOGSEG,ctrlValue)) {
var ctl = _GetCtl(e,'UBNVJIYFWU');
if (_tracker.goon(ctl,ctrlValue)) {
w_BPCOGSEG=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UBNVJIYFWU',0);
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
function Set_NOCODFISC(ctrlValue,kmode,e) {
if (Ne(w_NOCODFISC,ctrlValue)) {
var ctl = _GetCtl(e,'UETNARUDOE');
if (_tracker.goon(ctl,ctrlValue)) {
w_NOCODFISC=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UETNARUDOE',0);
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
function Set_FLGCHK(ctrlValue,kmode,e) {
if (Ne(w_FLGCHK,ctrlValue)) {
var ctl = _GetCtl(e,'UHGVOKNSVL');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLGCHK=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UHGVOKNSVL',0);
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
function Set_BPNOMSEG(ctrlValue,kmode,e) {
if (Ne(w_BPNOMSEG,ctrlValue)) {
var ctl = _GetCtl(e,'PELELICXZD');
if (_tracker.goon(ctl,ctrlValue)) {
w_BPNOMSEG=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('PELELICXZD',0);
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
function Set_PWDSER(ctrlValue,kmode,e) {
if (Ne(w_PWDSER,ctrlValue)) {
var ctl = _GetCtl(e,'NLUIAOSQKM');
if (_tracker.goon(ctl,ctrlValue)) {
w_PWDSER=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NLUIAOSQKM',0);
if (l_bResult) {
l_bResult=(Empty(w_PWDSER)?true:Eq(w_PWDSER,'MIT'+Substr(DateToChar(SystemDate()),3,6)));
if ( ! (l_bResult)) {
m_nLastError=2;
m_cLastWorkVarErrorMsg='PWDSER';
m_cLastMsgError='';
}
if ( ! (l_bResult)) {
w_PWDSER=HtW('','C');
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
function Set_SOSPMAF(ctrlValue,kmode,e) {
if (Ne(w_SOSPMAF,ctrlValue)) {
var ctl = _GetCtl(e,'XDDITMPJIZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_SOSPMAF=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XDDITMPJIZ',0);
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
function Set_FLGRITORNO(ctrlValue,kmode,e) {
if (Ne(w_FLGRITORNO,ctrlValue)) {
var ctl = _GetCtl(e,'LUPNVRRLHF');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLGRITORNO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('LUPNVRRLHF',0);
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
function Set_FLGCREAAGE(ctrlValue,kmode,e) {
if (Ne(w_FLGCREAAGE,ctrlValue)) {
var ctl = _GetCtl(e,'HFADCPKPNB');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLGCREAAGE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HFADCPKPNB',0);
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
function Set_DTTITAGE(ctrlValue,kmode,e) {
if (Ne(w_DTTITAGE,ctrlValue)) {
var ctl = _GetCtl(e,'ASIWFAENLM');
if (_tracker.goon(ctl,ctrlValue)) {
w_DTTITAGE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ASIWFAENLM',0);
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
function Set_SCADSALDI(ctrlValue,kmode,e) {
if (Ne(w_SCADSALDI,ctrlValue)) {
var ctl = _GetCtl(e,'IOYUNQJDKZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_SCADSALDI=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('IOYUNQJDKZ',0);
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
function Set_FLGIPMT(ctrlValue,kmode,e) {
if (Ne(w_FLGIPMT,ctrlValue)) {
var ctl = _GetCtl(e,'LSBZHECNKO');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLGIPMT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('LSBZHECNKO',0);
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
function Set_LIMITEFRZ(ctrlValue,kmode,e) {
if (Ne(w_LIMITEFRZ,ctrlValue)) {
var ctl = _GetCtl(e,'FKIIMPSJSB');
if (_tracker.goon(ctl,ctrlValue)) {
w_LIMITEFRZ=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FKIIMPSJSB',0);
l_bResult=l_bResult && _ChkObl('QNBTKVPOCY',0);
l_bResult=l_bResult && _ChkObl('UCTCKTKEZC',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','N',10,2,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_GGWARNPRV(ctrlValue,kmode,e) {
if (Ne(w_GGWARNPRV,ctrlValue)) {
var ctl = _GetCtl(e,'PUFIBBLEMQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_GGWARNPRV=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('PUFIBBLEMQ',0);
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
function Set_DBPROT(ctrlValue,kmode,e) {
if (Ne(w_DBPROT,ctrlValue)) {
var ctl = _GetCtl(e,'EQCSRKQZVC');
if (_tracker.goon(ctl,ctrlValue)) {
w_DBPROT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('EQCSRKQZVC',0);
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
function Set_OAMTPDOC(ctrlValue,kmode,e) {
if (Ne(w_OAMTPDOC,ctrlValue)) {
var ctl = _GetCtl(e,'KFQWZVCJIW');
if (_tracker.goon(ctl,ctrlValue)) {
w_OAMTPDOC=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('KFQWZVCJIW',0);
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
function Set_DAYSIMPORT(ctrlValue,kmode,e) {
if (Ne(w_DAYSIMPORT,ctrlValue)) {
var ctl = _GetCtl(e,'LGZDRUUSXZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_DAYSIMPORT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('LGZDRUUSXZ',0);
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
function Set_DAYSIMPCMB(ctrlValue,kmode,e) {
if (Ne(w_DAYSIMPCMB,ctrlValue)) {
var ctl = _GetCtl(e,'FQKHRITNGP');
if (_tracker.goon(ctl,ctrlValue)) {
w_DAYSIMPCMB=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FQKHRITNGP',0);
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
function Set_FLGAWUPOS(ctrlValue,kmode,e) {
if (Ne(w_FLGAWUPOS,ctrlValue)) {
var ctl = _GetCtl(e,'SIZHWNZUOT');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLGAWUPOS=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SIZHWNZUOT',0);
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
function Set_WUGIOSCA(ctrlValue,kmode,e) {
if (Ne(w_WUGIOSCA,ctrlValue)) {
var ctl = _GetCtl(e,'QBHBPWJMOW');
if (_tracker.goon(ctl,ctrlValue)) {
w_WUGIOSCA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QBHBPWJMOW',0);
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
function Set_WUGGALERT(ctrlValue,kmode,e) {
if (Ne(w_WUGGALERT,ctrlValue)) {
var ctl = _GetCtl(e,'HXPRRNXNJO');
if (_tracker.goon(ctl,ctrlValue)) {
w_WUGGALERT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HXPRRNXNJO',0);
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
function Set_RICEVUTE(ctrlValue,kmode,e) {
if (Ne(w_RICEVUTE,ctrlValue)) {
var ctl = _GetCtl(e,'AAIARGXIIW');
if (_tracker.goon(ctl,ctrlValue)) {
w_RICEVUTE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
var l_bWarn = true;
l_bResult=_ChkObl('AAIARGXIIW',0);
if (l_bResult) {
if (l_bResult && ( ! (Empty(w_RICEVUTE)) && Ne(m_nLastError,-2))) {
try {
_tracker.askwrn=true;
l_bWarn=WindowConfirm(AlertErrorMessage('1629549292'));
} finally {
_tracker.askwrn=false;
}
}
if ( ! (l_bResult) ||  ! (l_bWarn)) {
w_RICEVUTE=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult) ||  ! (l_bWarn)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',250,0,''));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',250,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_OGGI3I4(ctrlValue,kmode,e) {
if (Ne(w_OGGI3I4,ctrlValue)) {
var ctl = _GetCtl(e,'PLWDFUBDIP');
if (_tracker.goon(ctl,ctrlValue)) {
w_OGGI3I4=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('PLWDFUBDIP',0);
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
function Set_IDOAMR(ctrlValue,kmode,e) {
if (Ne(w_IDOAMR,ctrlValue)) {
var ctl = _GetCtl(e,'PUYJXGBDJI');
if (_tracker.goon(ctl,ctrlValue)) {
w_IDOAMR=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('PUYJXGBDJI',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',8,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_QADV_SOGLIA(ctrlValue,kmode,e) {
if (Ne(w_QADV_SOGLIA,ctrlValue)) {
var ctl = _GetCtl(e,'HRSWOWLUUE');
if (_tracker.goon(ctl,ctrlValue)) {
w_QADV_SOGLIA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HRSWOWLUUE',0);
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
function Set_AUTOSARA(ctrlValue,kmode,e) {
if (Ne(w_AUTOSARA,ctrlValue)) {
var ctl = _GetCtl(e,'PVOEPQLJPS');
if (_tracker.goon(ctl,ctrlValue)) {
w_AUTOSARA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('PVOEPQLJPS',0);
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
function Set_FLGCGOOTP(ctrlValue,kmode,e) {
if (Ne(w_FLGCGOOTP,ctrlValue)) {
var ctl = _GetCtl(e,'FCXDRDCINI');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLGCGOOTP=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MHHQTFPDEN',0);
l_bResult=l_bResult && _ChkObl('FCXDRDCINI',0);
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
function Set_ITFLGPEP(ctrlValue,kmode,e) {
if (Ne(w_ITFLGPEP,ctrlValue)) {
var ctl = _GetCtl(e,'RBAZEQPPJI');
if (_tracker.goon(ctl,ctrlValue)) {
w_ITFLGPEP=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RBAZEQPPJI',0);
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
function Set_ITPWDPEP(ctrlValue,kmode,e) {
if (Ne(w_ITPWDPEP,ctrlValue)) {
var ctl = _GetCtl(e,'VDJMSNZEEV');
if (_tracker.goon(ctl,ctrlValue)) {
w_ITPWDPEP=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VDJMSNZEEV',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('VDJMSNZEEV',function(){return WtH(w_ITPWDPEP,'C',50,0,'')},w_ITPWDPEP);
return l_bResult;
} else {
ctl.value=WtH('','C',50,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_ITUSRPEP(ctrlValue,kmode,e) {
if (Ne(w_ITUSRPEP,ctrlValue)) {
var ctl = _GetCtl(e,'LNADTKDHIZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_ITUSRPEP=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('LNADTKDHIZ',0);
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
function Set_FLGAGGFAM(ctrlValue,kmode,e) {
if (Ne(w_FLGAGGFAM,ctrlValue)) {
var ctl = _GetCtl(e,'XMAVZMPWRZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLGAGGFAM=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XMAVZMPWRZ',0);
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
function Set_ALTSRVMAIL(ctrlValue,kmode,e) {
if (Ne(w_ALTSRVMAIL,ctrlValue)) {
var ctl = _GetCtl(e,'BZARULYZUH');
if (_tracker.goon(ctl,ctrlValue)) {
w_ALTSRVMAIL=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MLYQUOWFHN',0);
l_bResult=l_bResult && _ChkObl('BZARULYZUH',0);
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
function Set_ALTPRTMAIL(ctrlValue,kmode,e) {
if (Ne(w_ALTPRTMAIL,ctrlValue)) {
var ctl = _GetCtl(e,'CWFIJJMSTR');
if (_tracker.goon(ctl,ctrlValue)) {
w_ALTPRTMAIL=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VRYHAZPGSR',0);
l_bResult=l_bResult && _ChkObl('CWFIJJMSTR',0);
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
function Set_ALTEMLMAIL(ctrlValue,kmode,e) {
if (Ne(w_ALTEMLMAIL,ctrlValue)) {
var ctl = _GetCtl(e,'YPHGLIUDNW');
if (_tracker.goon(ctl,ctrlValue)) {
w_ALTEMLMAIL=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('TYOXRXGXKJ',0);
l_bResult=l_bResult && _ChkObl('YPHGLIUDNW',0);
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
function Set_ALTUSRMAIL(ctrlValue,kmode,e) {
if (Ne(w_ALTUSRMAIL,ctrlValue)) {
var ctl = _GetCtl(e,'HSAOKMBAUY');
if (_tracker.goon(ctl,ctrlValue)) {
w_ALTUSRMAIL=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('OKEJPCYNVH',0);
l_bResult=l_bResult && _ChkObl('HSAOKMBAUY',0);
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
function Set_RESPAUI(ctrlValue,kmode,e) {
if (Ne(w_RESPAUI,ctrlValue)) {
var ctl = _GetCtl(e,'WHJVJHBKYI');
if (_tracker.goon(ctl,ctrlValue)) {
w_RESPAUI=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('WHJVJHBKYI',0);
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
function Set_URLDESDOC(ctrlValue,kmode,e) {
if (Ne(w_URLDESDOC,ctrlValue)) {
var ctl = _GetCtl(e,'RNIWEERJDP');
if (_tracker.goon(ctl,ctrlValue)) {
w_URLDESDOC=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RNIWEERJDP',0);
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
function Set_PWDGESDOC(ctrlValue,kmode,e) {
if (Ne(w_PWDGESDOC,ctrlValue)) {
var ctl = _GetCtl(e,'HFVZAFILCA');
if (_tracker.goon(ctl,ctrlValue)) {
w_PWDGESDOC=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HFVZAFILCA',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('HFVZAFILCA',function(){return WtH(w_PWDGESDOC,'C',30,0,'')},w_PWDGESDOC);
return l_bResult;
} else {
ctl.value=WtH('','C',30,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_DESTEMAIL(ctrlValue,kmode,e) {
if (Ne(w_DESTEMAIL,ctrlValue)) {
var ctl = _GetCtl(e,'OHRBGBCDVG');
if (_tracker.goon(ctl,ctrlValue)) {
w_DESTEMAIL=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('OHRBGBCDVG',0);
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
function Set_COGNOME(ctrlValue,kmode,e) {
if (Ne(w_COGNOME,ctrlValue)) {
var ctl = _GetCtl(e,'KDJLQEMEDV');
if (_tracker.goon(ctl,ctrlValue)) {
w_COGNOME=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('KDJLQEMEDV',0);
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
function Set_NOME(ctrlValue,kmode,e) {
if (Ne(w_NOME,ctrlValue)) {
var ctl = _GetCtl(e,'VTFLIHXHLG');
if (_tracker.goon(ctl,ctrlValue)) {
w_NOME=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VTFLIHXHLG',0);
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
function Set_MINFRZSNAI(ctrlValue,kmode,e) {
if (Ne(w_MINFRZSNAI,ctrlValue)) {
var ctl = _GetCtl(e,'XRGIDJXVCB');
if (_tracker.goon(ctl,ctrlValue)) {
w_MINFRZSNAI=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XRGIDJXVCB',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','N',12,2,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_FLGSCDFRZ(ctrlValue,kmode,e) {
if (Ne(w_FLGSCDFRZ,ctrlValue)) {
var ctl = _GetCtl(e,'CZINOLQOUB');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLGSCDFRZ=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CZINOLQOUB',0);
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
function Set_CITTADINA(ctrlValue,kmode,e) {
if (Ne(w_CITTADINA,ctrlValue)) {
var ctl = _GetCtl(e,'WQWXGOLVXC');
if (_tracker.goon(ctl,ctrlValue)) {
w_CITTADINA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('WQWXGOLVXC',0);
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
function Set_NASCOMUN(ctrlValue,kmode,e) {
if (Ne(w_NASCOMUN,ctrlValue)) {
var ctl = _GetCtl(e,'DUROREWBNG');
if (_tracker.goon(ctl,ctrlValue)) {
w_NASCOMUN=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('DUROREWBNG',0);
if (l_bResult) {
l_bResult=Link_DUROREWBNG(kmode);
if ( ! (l_bResult)) {
w_NASCOMUN=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',30,0,''));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',30,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_NASSTATO(ctrlValue,kmode,e) {
if (Ne(w_NASSTATO,ctrlValue)) {
var ctl = _GetCtl(e,'ZTUIXEONYI');
if (_tracker.goon(ctl,ctrlValue)) {
w_NASSTATO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ZTUIXEONYI',0);
if (l_bResult) {
l_bResult=Link_ZTUIXEONYI(kmode);
if ( ! (l_bResult)) {
w_NASSTATO=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',30,0,''));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',30,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_PRNASC(ctrlValue,kmode,e) {
if (Ne(w_PRNASC,ctrlValue)) {
var ctl = _GetCtl(e,'KSRCRPEMFT');
if (_tracker.goon(ctl,ctrlValue)) {
w_PRNASC=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('KSRCRPEMFT',0);
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
function Set_SOGCOM(ctrlValue,kmode,e) {
if (Ne(w_SOGCOM,ctrlValue)) {
var ctl = _GetCtl(e,'IYKMLTUWXM');
if (_tracker.goon(ctl,ctrlValue)) {
w_SOGCOM=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('IYKMLTUWXM',0);
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
function Set_BPCODPAT(ctrlValue,kmode,e) {
if (Ne(w_BPCODPAT,ctrlValue)) {
var ctl = _GetCtl(e,'IAXBQWHGLM');
if (_tracker.goon(ctl,ctrlValue)) {
w_BPCODPAT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('IAXBQWHGLM',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',12,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_FLGSTPDIR(ctrlValue,kmode,e) {
if (Ne(w_FLGSTPDIR,ctrlValue)) {
var ctl = _GetCtl(e,'OOAVIAADZS');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLGSTPDIR=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('OOAVIAADZS',0);
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
function Set_FLGNODOC(ctrlValue,kmode,e) {
if (Ne(w_FLGNODOC,ctrlValue)) {
var ctl = _GetCtl(e,'MRWHAAPELH');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLGNODOC=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MRWHAAPELH',0);
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
function Set_USRGESDOC(ctrlValue,kmode,e) {
if (Ne(w_USRGESDOC,ctrlValue)) {
var ctl = _GetCtl(e,'MUANKUGIIK');
if (_tracker.goon(ctl,ctrlValue)) {
w_USRGESDOC=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MUANKUGIIK',0);
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
function Set_BPTELSEG(ctrlValue,kmode,e) {
if (Ne(w_BPTELSEG,ctrlValue)) {
var ctl = _GetCtl(e,'DZVDAZOPWP');
if (_tracker.goon(ctl,ctrlValue)) {
w_BPTELSEG=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('DZVDAZOPWP',0);
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
function Set_BPEMLSEG(ctrlValue,kmode,e) {
if (Ne(w_BPEMLSEG,ctrlValue)) {
var ctl = _GetCtl(e,'HRZVDXDSOJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_BPEMLSEG=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HRZVDXDSOJ',0);
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
function Set_ABI(ctrlValue,kmode,e) {
if (Ne(w_ABI,ctrlValue)) {
var ctl = _GetCtl(e,'TFDNMJLIWF');
if (_tracker.goon(ctl,ctrlValue)) {
w_ABI=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('TFDNMJLIWF',0);
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
function Set_CAB(ctrlValue,kmode,e) {
if (Ne(w_CAB,ctrlValue)) {
var ctl = _GetCtl(e,'WRRSZRBPCI');
if (_tracker.goon(ctl,ctrlValue)) {
w_CAB=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('WRRSZRBPCI',0);
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
function Set_FLGGESDOC(ctrlValue,kmode,e) {
if (Ne(w_FLGGESDOC,ctrlValue)) {
var ctl = _GetCtl(e,'FYAHSLEGLP');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLGGESDOC=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FYAHSLEGLP',0);
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
function Set_GGWARNAUI(ctrlValue,kmode,e) {
if (Ne(w_GGWARNAUI,ctrlValue)) {
var ctl = _GetCtl(e,'MBMIGFSBXO');
if (_tracker.goon(ctl,ctrlValue)) {
w_GGWARNAUI=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MBMIGFSBXO',0);
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
function Set_SOGLIAMAX(ctrlValue,kmode,e) {
if (Ne(w_SOGLIAMAX,ctrlValue)) {
var ctl = _GetCtl(e,'XUNVKFSSZL');
if (_tracker.goon(ctl,ctrlValue)) {
w_SOGLIAMAX=ValidNum(ctrlValue,'999999999.99');
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XUNVKFSSZL',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('XUNVKFSSZL',function(){return WtH(w_SOGLIAMAX,'N',12,2,'999,999,999.99')},w_SOGLIAMAX);
return l_bResult;
} else {
ctl.value=WtH('','N',12,2,'999999999.99');
_ResetTracker();
return true;
}
} else {
SPBOUILib.SetInputValue('XUNVKFSSZL',function(){return WtH(w_SOGLIAMAX,'N',12,2,'999,999,999.99')},w_SOGLIAMAX);
}
return true;
}
function Set_IDOAM(ctrlValue,kmode,e) {
if (Ne(w_IDOAM,ctrlValue)) {
var ctl = _GetCtl(e,'CNQFAHXNUY');
if (_tracker.goon(ctl,ctrlValue)) {
w_IDOAM=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CNQFAHXNUY',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',8,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_PATHAPP(ctrlValue,kmode,e) {
if (Ne(w_PATHAPP,ctrlValue)) {
var ctl = _GetCtl(e,'FOTKWJQFAL');
if (_tracker.goon(ctl,ctrlValue)) {
w_PATHAPP=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FOTKWJQFAL',0);
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
function Set_SKT_SERVER(ctrlValue,kmode,e) {
if (Ne(w_SKT_SERVER,ctrlValue)) {
var ctl = _GetCtl(e,'DNCMAAILTV');
if (_tracker.goon(ctl,ctrlValue)) {
w_SKT_SERVER=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('DNCMAAILTV',0);
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
function Set_SKT_PORT(ctrlValue,kmode,e) {
if (Ne(w_SKT_PORT,ctrlValue)) {
var ctl = _GetCtl(e,'UMEMYFCVBI');
if (_tracker.goon(ctl,ctrlValue)) {
w_SKT_PORT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UMEMYFCVBI',0);
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
function Set_SKT_PATHS(ctrlValue,kmode,e) {
if (Ne(w_SKT_PATHS,ctrlValue)) {
var ctl = _GetCtl(e,'ZFUOSYKTGZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_SKT_PATHS=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ZFUOSYKTGZ',0);
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
function Set_SKT_MODET(ctrlValue,kmode,e) {
if (Ne(w_SKT_MODET,ctrlValue)) {
var ctl = _GetCtl(e,'ECARBEFMBC');
if (_tracker.goon(ctl,ctrlValue)) {
w_SKT_MODET=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ECARBEFMBC',0);
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
function Set_RASPAUI(ctrlValue,kmode,e) {
if (Ne(w_RASPAUI,ctrlValue)) {
var ctl = _GetCtl(e,'DNNGPDMXQI');
if (_tracker.goon(ctl,ctrlValue)) {
w_RASPAUI=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('DNNGPDMXQI',0);
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
function Set_pathmanuale(ctrlValue,kmode,e) {
if (Ne(w_pathmanuale,ctrlValue)) {
var ctl = _GetCtl(e,'JPABVPZDBZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_pathmanuale=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('JPABVPZDBZ',0);
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
function Set_TESTIP(ctrlValue,kmode,e) {
if (Ne(w_TESTIP,ctrlValue)) {
var ctl = _GetCtl(e,'ZZSBUTEXWS');
if (_tracker.goon(ctl,ctrlValue)) {
w_TESTIP=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ZZSBUTEXWS',0);
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
function Set_FLGCGOPWD(ctrlValue,kmode,e) {
if (Ne(w_FLGCGOPWD,ctrlValue)) {
var ctl = _GetCtl(e,'VJPULIZVKG');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLGCGOPWD=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VJPULIZVKG',0);
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
function Set_PATHSID(ctrlValue,kmode,e) {
if (Ne(w_PATHSID,ctrlValue)) {
var ctl = _GetCtl(e,'EMDHDDRUPP');
if (_tracker.goon(ctl,ctrlValue)) {
w_PATHSID=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('EMDHDDRUPP',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',250,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_GIORNIFRZ(ctrlValue,kmode,e) {
if (Ne(w_GIORNIFRZ,ctrlValue)) {
var ctl = _GetCtl(e,'BMMUPRLVUU');
if (_tracker.goon(ctl,ctrlValue)) {
w_GIORNIFRZ=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BMMUPRLVUU',0);
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
function Set_LIMITVLT(ctrlValue,kmode,e) {
if (Ne(w_LIMITVLT,ctrlValue)) {
var ctl = _GetCtl(e,'JFMMDZQFJC');
if (_tracker.goon(ctl,ctrlValue)) {
w_LIMITVLT=ValidNum(ctrlValue,'9999999.99');
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('JFMMDZQFJC',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('JFMMDZQFJC',function(){return WtH(w_LIMITVLT,'N',10,2,'9,999,999.99')},w_LIMITVLT);
return l_bResult;
} else {
ctl.value=WtH('','N',10,2,'9999999.99');
_ResetTracker();
return true;
}
} else {
SPBOUILib.SetInputValue('JFMMDZQFJC',function(){return WtH(w_LIMITVLT,'N',10,2,'9,999,999.99')},w_LIMITVLT);
}
return true;
}
function Set_LIMITVNP(ctrlValue,kmode,e) {
if (Ne(w_LIMITVNP,ctrlValue)) {
var ctl = _GetCtl(e,'OHKFECVWFV');
if (_tracker.goon(ctl,ctrlValue)) {
w_LIMITVNP=ValidNum(ctrlValue,'9999999.99');
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('OHKFECVWFV',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('OHKFECVWFV',function(){return WtH(w_LIMITVNP,'N',10,2,'9,999,999.99')},w_LIMITVNP);
return l_bResult;
} else {
ctl.value=WtH('','N',10,2,'9999999.99');
_ResetTracker();
return true;
}
} else {
SPBOUILib.SetInputValue('OHKFECVWFV',function(){return WtH(w_LIMITVNP,'N',10,2,'9,999,999.99')},w_LIMITVNP);
}
return true;
}
function Set_PATHFTP(ctrlValue,kmode,e) {
if (Ne(w_PATHFTP,ctrlValue)) {
var ctl = _GetCtl(e,'WPPFTLWEWX');
if (_tracker.goon(ctl,ctrlValue)) {
w_PATHFTP=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('WPPFTLWEWX',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',128,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_FRAZDEL(ctrlValue,kmode,e) {
if (Ne(w_FRAZDEL,ctrlValue)) {
var ctl = _GetCtl(e,'HBTCFEMATT');
if (_tracker.goon(ctl,ctrlValue)) {
w_FRAZDEL=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HBTCFEMATT',0);
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
function Set_FLGUTEAGE(ctrlValue,kmode,e) {
if (Ne(w_FLGUTEAGE,ctrlValue)) {
var ctl = _GetCtl(e,'KZJBLRRDWP');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLGUTEAGE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('KZJBLRRDWP',0);
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
function Set_FLGLIGHT(ctrlValue,kmode,e) {
if (Ne(w_FLGLIGHT,ctrlValue)) {
var ctl = _GetCtl(e,'QMOTVZANBJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLGLIGHT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QMOTVZANBJ',0);
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
function Set_PRGAEPATH(ctrlValue,kmode,e) {
if (Ne(w_PRGAEPATH,ctrlValue)) {
var ctl = _GetCtl(e,'PUWCGJFLDF');
if (_tracker.goon(ctl,ctrlValue)) {
w_PRGAEPATH=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('PUWCGJFLDF',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',250,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_CGOFLGPROF(ctrlValue,kmode,e) {
if (Ne(w_CGOFLGPROF,ctrlValue)) {
var ctl = _GetCtl(e,'ABGLJLFEYQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_CGOFLGPROF=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ABGLJLFEYQ',0);
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
function Set_PATHCERT(ctrlValue,kmode,e) {
if (Ne(w_PATHCERT,ctrlValue)) {
var ctl = _GetCtl(e,'WXRSSFBXYH');
if (_tracker.goon(ctl,ctrlValue)) {
w_PATHCERT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('WXRSSFBXYH',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',250,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_NUMGIORN(ctrlValue,kmode,e) {
if (Ne(w_NUMGIORN,ctrlValue)) {
var ctl = _GetCtl(e,'NVZYOQAKDU');
if (_tracker.goon(ctl,ctrlValue)) {
w_NUMGIORN=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NVZYOQAKDU',0);
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
function Set_BLOCCOUSER(ctrlValue,kmode,e) {
if (Ne(w_BLOCCOUSER,ctrlValue)) {
var ctl = _GetCtl(e,'XVGAGFPMXP');
if (_tracker.goon(ctl,ctrlValue)) {
w_BLOCCOUSER=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XVGAGFPMXP',0);
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
function Set_FLGCGOQADV(ctrlValue,kmode,e) {
if (Ne(w_FLGCGOQADV,ctrlValue)) {
var ctl = _GetCtl(e,'SSXDYZLCUX');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLGCGOQADV=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SSXDYZLCUX',0);
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
if ((Ne(o_DESCCIT,w_DESCCIT))) {
l_bTmpRes=Link_IIXRREUEAM(null);
}
if ((Ne(o_RAMOGRUP,w_RAMOGRUP)) || (Ne(o_SOTGRUP,w_SOTGRUP))) {
Calculation_OIDLDZGYTQ();
}
LibJavascript.forEachItem(m_FoundlingCopyWorkVar,i_body_1)
function i_body_1(child){
child();
}
// * --- Area Manuale = UI - Calculate
// * --- Fine Area Manuale
if (Ne(typeof(Calculation_BBBKIFYTJJ),'undefined')) {
Calculation_BBBKIFYTJJ();
}
m_bCalculating=false;
}
function Calculation_OIDLDZGYTQ() {
arrt_calcolasett([])
}
function Calculation_BBBKIFYTJJ() {
w_CODINTER=(Empty(w_CODINTER)?LRTrim(w_CODFISC):w_CODINTER);
}
function SaveDependsOn() {
o_DESCCIT=w_DESCCIT;
o_SOTGRUP=w_SOTGRUP;
o_RAMOGRUP=w_RAMOGRUP;
}
function SaveLabelDependsOn() {
}
function Link_JXOBOAXKRQ(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_TIPINTER);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('TIPOINT',w_TIPINTER,2,0);
l_Appl.SetFields('TIPOINT');
l_Appl.SetTypes('C');
l_Appl.LinkTable('tbtipint');
l_Appl.SetLinkzoom('armt_tipinte');
l_Appl.SetID('JXOBOAXKRQ');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_TIPINTER=l_Appl.GetStringValue('TIPOINT',2,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_JXOBOAXKRQ_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_JXOBOAXKRQ';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_JXOBOAXKRQ();
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
function Link_JXOBOAXKRQ_Blank() {
w_TIPINTER='';
}
function LOpt_JXOBOAXKRQ() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbtipint','C'));
l_oWv.setValue('Linkzoomprg',WtA('armt_tipinte','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('TIPOINT','C'));
l_oWv.setValue('LinkedField',WtA('TIPOINT','C'));
l_oWv.setValue('UID',WtA('JXOBOAXKRQ','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['JXOBOAXKRQ'][1],'C'));
return l_oWv;
}
function Link_JCGROGAZTR(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_DESCCIT);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CITTA',w_DESCCIT,30,0);
l_Appl.SetFields('CITTA,CAB,PROV,CAP,PKTBSTATI,IDBASE');
l_Appl.SetTypes('C,C,C,C,C,C');
l_Appl.LinkTable('tbcitta');
l_Appl.SetID('JCGROGAZTR');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_DESCCIT=l_Appl.GetStringValue('CITTA',30,0);
w_CODCAB=l_Appl.GetStringValue('CAB',6,0);
w_PROVINCIA=l_Appl.GetStringValue('PROV',2,0);
w_CAP=l_Appl.GetStringValue('CAP',9,0);
w_PAESE=l_Appl.GetStringValue('PKTBSTATI',3,0);
w_IDCITTA=l_Appl.GetStringValue('IDBASE',10,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_JCGROGAZTR_Blank();
l_bResult=true;
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_JCGROGAZTR';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_JCGROGAZTR();
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
function Link_JCGROGAZTR_Blank() {
w_CODCAB='';
w_PROVINCIA='';
w_CAP='';
w_PAESE='';
w_IDCITTA='';
}
function LOpt_JCGROGAZTR() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcitta','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CITTA','C'));
l_oWv.setValue('LinkedField',WtA('CITTA','C'));
l_oWv.setValue('UID',WtA('JCGROGAZTR','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['JCGROGAZTR'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('6863571'),'C'));
return l_oWv;
}
function Link_IIXRREUEAM(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_PAESE);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODSTA',w_PAESE,3,0);
l_Appl.SetFields('CODSTA,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbstati');
l_Appl.SetID('IIXRREUEAM');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_PAESE=l_Appl.GetStringValue('CODSTA',3,0);
w_DESCRIsta=l_Appl.GetStringValue('DESCRI',30,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_IIXRREUEAM_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_IIXRREUEAM';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_IIXRREUEAM();
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
function Link_IIXRREUEAM_Blank() {
w_PAESE='';
w_DESCRIsta='';
}
function LOpt_IIXRREUEAM() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstati','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODSTA','C'));
l_oWv.setValue('LinkedField',WtA('CODSTA','C'));
l_oWv.setValue('UID',WtA('IIXRREUEAM','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['IIXRREUEAM'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('7383187'),'C'));
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
function Link_AYYXYNLAUC(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_TIPODOC);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('TIPDOC',w_TIPODOC,2,0);
l_Appl.SetFields('TIPDOC');
l_Appl.SetTypes('C');
l_Appl.LinkTable('tbtipdoc');
l_Appl.SetLinkzoom('armt_tipdoc');
l_Appl.SetID('AYYXYNLAUC');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_TIPODOC=l_Appl.GetStringValue('TIPDOC',2,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_AYYXYNLAUC_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_AYYXYNLAUC';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_AYYXYNLAUC();
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
function Link_AYYXYNLAUC_Blank() {
w_TIPODOC='';
}
function LOpt_AYYXYNLAUC() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbtipdoc','C'));
l_oWv.setValue('Linkzoomprg',WtA('armt_tipdoc','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('TIPDOC','C'));
l_oWv.setValue('LinkedField',WtA('TIPDOC','C'));
l_oWv.setValue('UID',WtA('AYYXYNLAUC','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['AYYXYNLAUC'][1],'C'));
return l_oWv;
}
function Link_PSZTLCSMPB(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CODDIPE);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODDIP',w_CODDIPE,6,0);
l_Appl.SetFields('CODDIP,DESCRIZ,DESCCIT,CAB');
l_Appl.SetTypes('C,C,C,C');
l_Appl.LinkTable('anadip');
l_Appl.SetID('PSZTLCSMPB');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CODDIPE=l_Appl.GetStringValue('CODDIP',6,0);
w_descdip=l_Appl.GetStringValue('DESCRIZ',30,0);
w_xdescitdip=l_Appl.GetStringValue('DESCCIT',30,0);
w_xcabdip=l_Appl.GetStringValue('CAB',6,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_PSZTLCSMPB_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_PSZTLCSMPB';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_PSZTLCSMPB();
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
function Link_PSZTLCSMPB_Blank() {
w_CODDIPE='';
w_descdip='';
w_xdescitdip='';
w_xcabdip='';
}
function LOpt_PSZTLCSMPB() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('anadip','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODDIP','C'));
l_oWv.setValue('LinkedField',WtA('CODDIP','C'));
l_oWv.setValue('UID',WtA('PSZTLCSMPB','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['PSZTLCSMPB'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('1270140318'),'C'));
return l_oWv;
}
function Link_PZGXGIZQWY(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_DESCCIT);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CITTA',w_DESCCIT,30,0);
l_Appl.SetFields('CITTA');
l_Appl.SetTypes('C');
l_Appl.LinkTable('tbcitta');
l_Appl.SetLinkzoom('armt_citta');
l_Appl.SetID('PZGXGIZQWY');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_DESCCIT=l_Appl.GetStringValue('CITTA',30,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_PZGXGIZQWY_Blank();
l_bResult=true;
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_PZGXGIZQWY';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_PZGXGIZQWY();
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
function Link_PZGXGIZQWY_Blank() {
}
function LOpt_PZGXGIZQWY() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcitta','C'));
l_oWv.setValue('Linkzoomprg',WtA('armt_citta','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CITTA','C'));
l_oWv.setValue('LinkedField',WtA('CITTA','C'));
l_oWv.setValue('UID',WtA('PZGXGIZQWY','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['PZGXGIZQWY'][1],'C'));
return l_oWv;
}
function Link_DUROREWBNG(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_NASCOMUN);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CITTA',w_NASCOMUN,30,0);
l_Appl.SetFields('CITTA,PROV');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbcitta');
l_Appl.SetLinkzoom('armt_citta');
l_Appl.SetID('DUROREWBNG');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_NASCOMUN=l_Appl.GetStringValue('CITTA',30,0);
w_PRNASC=l_Appl.GetStringValue('PROV',2,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_DUROREWBNG_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_DUROREWBNG';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_DUROREWBNG();
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
function Link_DUROREWBNG_Blank() {
w_NASCOMUN='';
w_PRNASC='';
}
function LOpt_DUROREWBNG() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcitta','C'));
l_oWv.setValue('Linkzoomprg',WtA('armt_citta','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CITTA','C'));
l_oWv.setValue('LinkedField',WtA('CITTA','C'));
l_oWv.setValue('UID',WtA('DUROREWBNG','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['DUROREWBNG'][1],'C'));
return l_oWv;
}
function Link_ZTUIXEONYI(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_NASSTATO);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('DESCRI',w_NASSTATO,30,0);
l_Appl.SetFields('DESCRI');
l_Appl.SetTypes('C');
l_Appl.LinkTable('tbstati');
l_Appl.SetID('ZTUIXEONYI');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_NASSTATO=l_Appl.GetStringValue('DESCRI',30,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_ZTUIXEONYI_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_ZTUIXEONYI';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_ZTUIXEONYI();
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
function Link_ZTUIXEONYI_Blank() {
w_NASSTATO='';
}
function LOpt_ZTUIXEONYI() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstati','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('DESCRI','C'));
l_oWv.setValue('LinkedField',WtA('DESCRI','C'));
l_oWv.setValue('UID',WtA('ZTUIXEONYI','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['ZTUIXEONYI'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('7383187'),'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'JXOBOAXKRQ')) {
last_focused_comp=GetLastFocusedElementOfLink('JXOBOAXKRQ');
function SetMethod_JXOBOAXKRQ() {
Set_TIPINTER(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_JXOBOAXKRQ();
} else {
setTimeout(SetMethod_JXOBOAXKRQ,1);
}
bResult=true;
}
if (Eq(varName,'JCGROGAZTR')) {
last_focused_comp=GetLastFocusedElementOfLink('JCGROGAZTR');
function SetMethod_JCGROGAZTR() {
Set_DESCCIT(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_JCGROGAZTR();
} else {
setTimeout(SetMethod_JCGROGAZTR,1);
}
bResult=true;
}
if (Eq(varName,'IIXRREUEAM')) {
last_focused_comp=GetLastFocusedElementOfLink('IIXRREUEAM');
function SetMethod_IIXRREUEAM() {
Set_PAESE(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_IIXRREUEAM();
} else {
setTimeout(SetMethod_IIXRREUEAM,1);
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
if (Eq(varName,'AYYXYNLAUC')) {
last_focused_comp=GetLastFocusedElementOfLink('AYYXYNLAUC');
function SetMethod_AYYXYNLAUC() {
Set_TIPODOC(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_AYYXYNLAUC();
} else {
setTimeout(SetMethod_AYYXYNLAUC,1);
}
bResult=true;
}
if (Eq(varName,'PSZTLCSMPB')) {
last_focused_comp=GetLastFocusedElementOfLink('PSZTLCSMPB');
function SetMethod_PSZTLCSMPB() {
Set_CODDIPE(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_PSZTLCSMPB();
} else {
setTimeout(SetMethod_PSZTLCSMPB,1);
}
bResult=true;
}
if (Eq(varName,'PZGXGIZQWY')) {
last_focused_comp=GetLastFocusedElementOfLink('PZGXGIZQWY');
function SetMethod_PZGXGIZQWY() {
Set_DESCCIT(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_PZGXGIZQWY();
} else {
setTimeout(SetMethod_PZGXGIZQWY,1);
}
bResult=true;
}
if (Eq(varName,'DUROREWBNG')) {
last_focused_comp=GetLastFocusedElementOfLink('DUROREWBNG');
function SetMethod_DUROREWBNG() {
Set_NASCOMUN(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_DUROREWBNG();
} else {
setTimeout(SetMethod_DUROREWBNG,1);
}
bResult=true;
}
if (Eq(varName,'ZTUIXEONYI')) {
last_focused_comp=GetLastFocusedElementOfLink('ZTUIXEONYI');
function SetMethod_ZTUIXEONYI() {
Set_NASSTATO(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_ZTUIXEONYI();
} else {
setTimeout(SetMethod_ZTUIXEONYI,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'JXOBOAXKRQ')) {
return [Ctrl('JXOBOAXKRQ')];
}
if (Eq(varName,'JCGROGAZTR')) {
return [Ctrl('JCGROGAZTR')];
}
if (Eq(varName,'IIXRREUEAM')) {
return [Ctrl('IIXRREUEAM')];
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
if (Eq(varName,'AYYXYNLAUC')) {
return [Ctrl('AYYXYNLAUC')];
}
if (Eq(varName,'PSZTLCSMPB')) {
return [Ctrl('PSZTLCSMPB')];
}
if (Eq(varName,'PZGXGIZQWY')) {
return [Ctrl('PZGXGIZQWY')];
}
if (Eq(varName,'DUROREWBNG')) {
return [Ctrl('DUROREWBNG')];
}
if (Eq(varName,'ZTUIXEONYI')) {
return [Ctrl('ZTUIXEONYI')];
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
parent.ZtVWeb.raiseEventToEvalParms('armt_intermbo_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('armt_intermbo_dataNotSent',{'action':formaction});
}
}
}
}
CheckChild.child=[{'prg':"ardt_destwarn",'BOScId':function(){ return FrameRef('ardt_destwarn')},'repeated':0},{'prg':"ardt_cgo_tipall",'BOScId':function(){ return FrameRef('ardt_cgo_tipall')},'repeated':0},{'prg':"ardt_cgo_subnets",'BOScId':function(){ return FrameRef('ardt_cgo_subnets')},'repeated':0},{'prg':"ardt_destemail",'BOScId':function(){ return FrameRef('ardt_destemail')},'repeated':0}];
function Check() {
var l_bResult = true;
var l_bChildCheck = true;
ResetErrorVars();
m_nLastError=0;
if ( ! (_ChkObl('JXOBOAXKRQ',1))) {
_SignErr('JXOBOAXKRQ');
m_cLastWorkVarErrorMsg='984756930';
l_bResult=false;
w_TIPINTER=HtW('','C');
} else if ( ! (_ChkObl('HVIUTGJWGE',1))) {
_SignErr('HVIUTGJWGE');
m_cLastWorkVarErrorMsg='10662833243';
l_bResult=false;
w_RAGSOC=HtW('','C');
} else if ( ! (_ChkObl('JCGROGAZTR',1))) {
_SignErr('JCGROGAZTR');
m_cLastWorkVarErrorMsg='15186643';
l_bResult=false;
w_DESCCIT=HtW('','C');
} else if ( ! (_ChkObl('UQKLCBCTLH',1))) {
_SignErr('UQKLCBCTLH');
m_cLastWorkVarErrorMsg='10095365423';
l_bResult=false;
w_PROVINCIA=HtW('','C');
} else if ( ! (_ChkObl('BQSGHFQUHM',1))) {
_SignErr('BQSGHFQUHM');
m_cLastWorkVarErrorMsg='21587';
l_bResult=false;
w_CAP=HtW('','C');
} else if ( ! (_ChkObl('IXWLDAOCFD',1))) {
_SignErr('IXWLDAOCFD');
m_cLastWorkVarErrorMsg='18003';
l_bResult=false;
w_CODCAB=HtW('','C');
} else if ( ! (_ChkObl('SJHNBZJAKA',1))) {
_SignErr('SJHNBZJAKA');
m_cLastWorkVarErrorMsg='554236824';
l_bResult=false;
w_DOMICILIO=HtW('','C');
} else if ( ! (_ChkObl('IIXRREUEAM',1))) {
_SignErr('IIXRREUEAM');
m_cLastWorkVarErrorMsg='7776403';
l_bResult=false;
w_PAESE=HtW('','C');
} else if ( ! (_ChkObl('SZWCLLEIQY',1))) {
_SignErr('SZWCLLEIQY');
m_cLastWorkVarErrorMsg='11921223220';
l_bResult=false;
w_CODFISC=HtW('','C');
} else if ( ! (_ChkObl('OIWIANSIOG',1))) {
_SignErr('OIWIANSIOG');
m_cLastWorkVarErrorMsg='1756430089';
l_bResult=false;
w_PARTIVA=HtW('','C');
} else if ( ! (_ChkObl('TNUQTSSGFZ',1))) {
_SignErr('TNUQTSSGFZ');
m_cLastWorkVarErrorMsg='226933836';
l_bResult=false;
w_DATANASC=HtW('','D');
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
} else if ( ! (_ChkObl('AYYXYNLAUC',1))) {
_SignErr('AYYXYNLAUC');
m_cLastWorkVarErrorMsg='11429032151';
l_bResult=false;
w_TIPODOC=HtW('','C');
} else if ( ! (_ChkObl('OREVCZVNVS',1))) {
_SignErr('OREVCZVNVS');
m_cLastWorkVarErrorMsg='7776675';
l_bResult=false;
w_SESSO=HtW('','C');
} else if ( ! (_ChkObl('XCNHFVDZMT',1))) {
_SignErr('XCNHFVDZMT');
m_cLastWorkVarErrorMsg='10759885763';
l_bResult=false;
w_NUMDOCUM=HtW('','C');
} else if ( ! (_ChkObl('ZYURNYDRPU',1))) {
_SignErr('ZYURNYDRPU');
m_cLastWorkVarErrorMsg='784106725';
l_bResult=false;
w_DATARILASC=HtW('','D');
} else if ( ! (_ChkObl('YYONLOLCBB',1))) {
_SignErr('YYONLOLCBB');
m_cLastWorkVarErrorMsg='1171331983';
l_bResult=false;
w_AUTRILASC=HtW('','C');
} else if ( ! (_ChkObl('PSZTLCSMPB',1))) {
_SignErr('PSZTLCSMPB');
m_cLastWorkVarErrorMsg='2071283709';
l_bResult=false;
w_CODDIPE=HtW('','C');
} else if ( ! (_ChkObl('COVTIKSDDS',1))) {
_SignErr('COVTIKSDDS');
m_cLastWorkVarErrorMsg='277599600';
l_bResult=false;
w_NOTE=HtW('','M');
} else if ( ! (_ChkObl('WSAOVXNTFO',1))) {
_SignErr('WSAOVXNTFO');
m_cLastWorkVarErrorMsg='1191715360';
l_bResult=false;
w_CODORO=HtW('','C');
} else if ( ! (_ChkObl('YPYQJILEQY',1))) {
_SignErr('YPYQJILEQY');
m_cLastWorkVarErrorMsg='112851763';
l_bResult=false;
w_CODINTER=HtW('','C');
} else if ( ! (_ChkObl('MXHAWWCAZX',1))) {
_SignErr('MXHAWWCAZX');
m_cLastWorkVarErrorMsg='784106725';
l_bResult=false;
w_DATAVALI=HtW('','D');
} else if ( ! (_ChkObl('TFMCRMSOGY',1))) {
_SignErr('TFMCRMSOGY');
m_cLastWorkVarErrorMsg='11949617228';
l_bResult=false;
w_CFINVIO=HtW('','C');
} else if ( ! (_ChkObl('YUCSUDKWNH',1))) {
_SignErr('YUCSUDKWNH');
m_cLastWorkVarErrorMsg='346962755';
l_bResult=false;
w_CAFINVIO=HtW('','C');
} else if ( ! (_ChkObl('JSTXCUBOUH',1))) {
_SignErr('JSTXCUBOUH');
m_cLastWorkVarErrorMsg='603506633';
l_bResult=false;
w_FILEINVIO=HtW('','C');
} else if ( ! (_ChkObl('YOVFWZCOBN',1))) {
_SignErr('YOVFWZCOBN');
m_cLastWorkVarErrorMsg='1908272937';
l_bResult=false;
w_DATAINVIO=HtW('','D');
} else if ( ! (_ChkObl('QPIRUTKOVH',1))) {
_SignErr('QPIRUTKOVH');
m_cLastWorkVarErrorMsg='1417173637';
l_bResult=false;
w_IDSID=HtW('','C');
} else if ( ! (_ChkObl('ULCBOSJURF',1))) {
_SignErr('ULCBOSJURF');
m_cLastWorkVarErrorMsg='11183930016';
l_bResult=false;
w_SIDPASS=HtW('','C');
} else if ( ! (_ChkObl('KHHILRUMHZ',1))) {
_SignErr('KHHILRUMHZ');
m_cLastWorkVarErrorMsg='11780950272';
l_bResult=false;
w_PATHJAVA=HtW('','C');
} else if ( ! (_ChkObl('ELBURHNYTV',1))) {
_SignErr('ELBURHNYTV');
m_cLastWorkVarErrorMsg='62890022';
l_bResult=false;
w_TIPOINST=HtW('','C');
} else if ( ! (_ChkObl('JYYHNLJDWT',1))) {
_SignErr('JYYHNLJDWT');
m_cLastWorkVarErrorMsg='FLGSIDAUTO';
l_bResult=false;
w_FLGSIDAUTO=0;
} else if ( ! (_ChkObl('FLPFDBFHXV',1))) {
_SignErr('FLPFDBFHXV');
m_cLastWorkVarErrorMsg='appocert';
l_bResult=false;
w_appocert=HtW('','C');
} else if ( ! (_ChkObl('LYZAJWZGAM',1))) {
_SignErr('LYZAJWZGAM');
m_cLastWorkVarErrorMsg='229480117';
l_bResult=false;
w_TIPOSV=HtW('','C');
} else if ( ! (_ChkObl('LAQADJFMRL',1))) {
_SignErr('LAQADJFMRL');
m_cLastWorkVarErrorMsg='898056191';
l_bResult=false;
w_LIMITE20=HtW('','D');
} else if ( ! (_ChkObl('FTETLDBHIY',1))) {
_SignErr('FTETLDBHIY');
m_cLastWorkVarErrorMsg='10964521107';
l_bResult=false;
w_CODVASP=HtW('','C');
} else if ( ! (_ChkObl('CWVJUDEVCT',1))) {
_SignErr('CWVJUDEVCT');
m_cLastWorkVarErrorMsg='11386753202';
l_bResult=false;
w_ART1=0;
} else if ( ! (_ChkObl('FPFLFCPHAL',1))) {
_SignErr('FPFLFCPHAL');
m_cLastWorkVarErrorMsg='10056338162';
l_bResult=false;
w_URLAPPL=HtW('','C');
} else if ( ! (_ChkObl('EOQVPQLKOP',1))) {
_SignErr('EOQVPQLKOP');
m_cLastWorkVarErrorMsg='444014241';
l_bResult=false;
w_FLGLOG='N';
} else if ( ! (_ChkObl('BLWLPTWCFV',1))) {
_SignErr('BLWLPTWCFV');
m_cLastWorkVarErrorMsg='11925635672';
l_bResult=false;
w_FLGAOS='N';
} else if ( ! (_ChkObl('REBGPUSIPL',1))) {
_SignErr('REBGPUSIPL');
m_cLastWorkVarErrorMsg='10863203227';
l_bResult=false;
w_FLGEAOS='N';
} else if ( ! (_ChkObl('HKDCUQQHSU',1))) {
_SignErr('HKDCUQQHSU');
m_cLastWorkVarErrorMsg='10663215684';
l_bResult=false;
w_FLGCDOC='N';
} else if ( ! (_ChkObl('CCBVEBVMNW',1))) {
_SignErr('CCBVEBVMNW');
m_cLastWorkVarErrorMsg='10792439550';
l_bResult=false;
w_FLGFRAZ='N';
} else if ( ! (_ChkObl('IDROHZZWYH',1))) {
_SignErr('IDROHZZWYH');
m_cLastWorkVarErrorMsg='10387266406';
l_bResult=false;
w_FLGAPERS=HtW('','C');
} else if ( ! (_ChkObl('IQOQQQRZAK',1))) {
_SignErr('IQOQQQRZAK');
m_cLastWorkVarErrorMsg='239631204';
l_bResult=false;
w_DTINIATT=HtW('','D');
} else if ( ! (_ChkObl('ZPSOMDIBXB',1))) {
_SignErr('ZPSOMDIBXB');
m_cLastWorkVarErrorMsg='11372282520';
l_bResult=false;
w_FLGTIPIMP=HtW('','C');
} else if ( ! (_ChkObl('PIGFPYZMIR',1))) {
_SignErr('PIGFPYZMIR');
m_cLastWorkVarErrorMsg='1057101874';
l_bResult=false;
w_FLGSTPCON='N';
} else if ( ! (_ChkObl('DUFIQNBDKW',1))) {
_SignErr('DUFIQNBDKW');
m_cLastWorkVarErrorMsg='10580197773';
l_bResult=false;
w_FLGIMPAGE=HtW('','C');
} else if ( ! (_ChkObl('LOYILZBSVI',1))) {
_SignErr('LOYILZBSVI');
m_cLastWorkVarErrorMsg='629299095';
l_bResult=false;
w_FLGWU='N';
} else if ( ! (_ChkObl('YJCSSLPJKG',1))) {
_SignErr('YJCSSLPJKG');
m_cLastWorkVarErrorMsg='11318353074';
l_bResult=false;
w_IMPINTOPE=HtW('','N');
} else if ( ! (_ChkObl('PXNLADGGBR',1))) {
_SignErr('PXNLADGGBR');
m_cLastWorkVarErrorMsg='2069243517';
l_bResult=false;
w_FLGOPEXTR='N';
} else if ( ! (_ChkObl('OSHAMNPXFT',1))) {
_SignErr('OSHAMNPXFT');
m_cLastWorkVarErrorMsg='11899629160';
l_bResult=false;
w_FLGRAPCLI='N';
} else if ( ! (_ChkObl('UETNARUDOE',1))) {
_SignErr('UETNARUDOE');
m_cLastWorkVarErrorMsg='1838445422';
l_bResult=false;
w_NOCODFISC=0;
} else if ( ! (_ChkObl('UHGVOKNSVL',1))) {
_SignErr('UHGVOKNSVL');
m_cLastWorkVarErrorMsg='10832346659';
l_bResult=false;
w_FLGCHK='N';
} else if (( ! (_ChkObl('NLUIAOSQKM',1))) || ( ! ((Empty(w_PWDSER)?true:Eq(w_PWDSER,'MIT'+Substr(DateToChar(SystemDate()),3,6)))))) {
_SignErr('NLUIAOSQKM');
m_cLastWorkVarErrorMsg='PWDSER';
l_bResult=false;
w_PWDSER=HtW('','C');
} else if ( ! (_ChkObl('XDDITMPJIZ',1))) {
_SignErr('XDDITMPJIZ');
m_cLastWorkVarErrorMsg='1991110901';
l_bResult=false;
w_SOSPMAF=HtW('','C');
} else if ( ! (_ChkObl('LUPNVRRLHF',1))) {
_SignErr('LUPNVRRLHF');
m_cLastWorkVarErrorMsg='12119982584';
l_bResult=false;
w_FLGRITORNO='N';
} else if ( ! (_ChkObl('HFADCPKPNB',1))) {
_SignErr('HFADCPKPNB');
m_cLastWorkVarErrorMsg='129191708';
l_bResult=false;
w_FLGCREAAGE='N';
} else if ( ! (_ChkObl('ASIWFAENLM',1))) {
_SignErr('ASIWFAENLM');
m_cLastWorkVarErrorMsg='10013527374';
l_bResult=false;
w_DTTITAGE=HtW('','D');
} else if ( ! (_ChkObl('IOYUNQJDKZ',1))) {
_SignErr('IOYUNQJDKZ');
m_cLastWorkVarErrorMsg='1445270903';
l_bResult=false;
w_SCADSALDI=HtW('','D');
} else if ( ! (_ChkObl('LSBZHECNKO',1))) {
_SignErr('LSBZHECNKO');
m_cLastWorkVarErrorMsg='12098996044';
l_bResult=false;
w_FLGIPMT='N';
} else if ( ! (_ChkObl('FKIIMPSJSB',1))) {
_SignErr('FKIIMPSJSB');
m_cLastWorkVarErrorMsg='11107614036';
l_bResult=false;
w_LIMITEFRZ=HtW('','N');
} else if ( ! (_ChkObl('EQCSRKQZVC',1))) {
_SignErr('EQCSRKQZVC');
m_cLastWorkVarErrorMsg='2128701876';
l_bResult=false;
w_DBPROT=HtW('','C');
} else if ( ! (_ChkObl('KFQWZVCJIW',1))) {
_SignErr('KFQWZVCJIW');
m_cLastWorkVarErrorMsg='691571468';
l_bResult=false;
w_OAMTPDOC=0;
} else if ( ! (_ChkObl('LGZDRUUSXZ',1))) {
_SignErr('LGZDRUUSXZ');
m_cLastWorkVarErrorMsg='892694017';
l_bResult=false;
w_DAYSIMPORT=HtW('','N');
} else if ( ! (_ChkObl('FQKHRITNGP',1))) {
_SignErr('FQKHRITNGP');
m_cLastWorkVarErrorMsg='10821185899';
l_bResult=false;
w_DAYSIMPCMB=HtW('','N');
} else if ( ! (_ChkObl('SIZHWNZUOT',1))) {
_SignErr('SIZHWNZUOT');
m_cLastWorkVarErrorMsg='54222013';
l_bResult=false;
w_FLGAWUPOS='N';
} else if ( ! (_ChkObl('QBHBPWJMOW',1))) {
_SignErr('QBHBPWJMOW');
m_cLastWorkVarErrorMsg='11212325724';
l_bResult=false;
w_WUGIOSCA=HtW('','N');
} else if ( ! (_ChkObl('HXPRRNXNJO',1))) {
_SignErr('HXPRRNXNJO');
m_cLastWorkVarErrorMsg='11345952953';
l_bResult=false;
w_WUGGALERT=HtW('','N');
} else if ( ! (_ChkObl('AAIARGXIIW',1))) {
_SignErr('AAIARGXIIW');
m_cLastWorkVarErrorMsg='11435351387';
l_bResult=false;
w_RICEVUTE=HtW('','C');
} else if ( ! (_ChkObl('PLWDFUBDIP',1))) {
_SignErr('PLWDFUBDIP');
m_cLastWorkVarErrorMsg='11215522148';
l_bResult=false;
w_OGGI3I4='N';
} else if ( ! (_ChkObl('PDLIXDKBWK',1))) {
_SignErr('PDLIXDKBWK');
m_cLastWorkVarErrorMsg='547041811';
l_bResult=false;
w_CGOTGDEFMUL='N';
} else if ( ! (_ChkObl('PVOEPQLJPS',1))) {
_SignErr('PVOEPQLJPS');
m_cLastWorkVarErrorMsg='10708787386';
l_bResult=false;
w_AUTOSARA='N';
} else if ( ! (_ChkObl('FCXDRDCINI',1))) {
_SignErr('FCXDRDCINI');
m_cLastWorkVarErrorMsg='48458917';
l_bResult=false;
w_FLGCGOOTP='N';
} else if ( ! (_ChkObl('RBAZEQPPJI',1))) {
_SignErr('RBAZEQPPJI');
m_cLastWorkVarErrorMsg='10619854532';
l_bResult=false;
w_ITFLGPEP='N';
} else if ((Eq(w_ITFLGPEP,'S')) && ( ! (_ChkObl('VDJMSNZEEV',1)))) {
_SignErr('VDJMSNZEEV');
m_cLastWorkVarErrorMsg='298733899';
l_bResult=false;
w_ITPWDPEP=HtW('','C');
} else if ((Eq(w_ITFLGPEP,'S')) && ( ! (_ChkObl('LNADTKDHIZ',1)))) {
_SignErr('LNADTKDHIZ');
m_cLastWorkVarErrorMsg='791817119';
l_bResult=false;
w_ITUSRPEP=HtW('','C');
} else if ( ! (_ChkObl('XMAVZMPWRZ',1))) {
_SignErr('XMAVZMPWRZ');
m_cLastWorkVarErrorMsg='10539278829';
l_bResult=false;
w_FLGAGGFAM='N';
} else if ( ! (_ChkObl('BZARULYZUH',1))) {
_SignErr('BZARULYZUH');
m_cLastWorkVarErrorMsg='1538539509';
l_bResult=false;
w_ALTSRVMAIL=HtW('','C');
} else if ( ! (_ChkObl('CWFIJJMSTR',1))) {
_SignErr('CWFIJJMSTR');
m_cLastWorkVarErrorMsg='6863168';
l_bResult=false;
w_ALTPRTMAIL=HtW('','C');
} else if ( ! (_ChkObl('YPHGLIUDNW',1))) {
_SignErr('YPHGLIUDNW');
m_cLastWorkVarErrorMsg='10759744842';
l_bResult=false;
w_ALTEMLMAIL=HtW('','C');
} else if ( ! (_ChkObl('HSAOKMBAUY',1))) {
_SignErr('HSAOKMBAUY');
m_cLastWorkVarErrorMsg='11227707037';
l_bResult=false;
w_ALTUSRMAIL=HtW('','C');
} else if ( ! (_ChkObl('LGVTLPSUGS',1))) {
_SignErr('LGVTLPSUGS');
m_cLastWorkVarErrorMsg='11183930016';
l_bResult=false;
w_ALTPWDMAIL=HtW('','C');
} else if ( ! (_ChkObl('KPSLGRAIIO',1))) {
_SignErr('KPSLGRAIIO');
m_cLastWorkVarErrorMsg='1367697541';
l_bResult=false;
w_ALTSSLEMAIL='N';
} else if ( ! (_ChkObl('YRAEGOUXRJ',1))) {
_SignErr('YRAEGOUXRJ');
m_cLastWorkVarErrorMsg='10420604475';
l_bResult=false;
w_PATHIMPORT=HtW('','C');
} else if ( ! (_ChkObl('OHRBGBCDVG',1))) {
_SignErr('OHRBGBCDVG');
m_cLastWorkVarErrorMsg='11069952590';
l_bResult=false;
w_DESTEMAIL=HtW('','C');
} else if ( ! (_ChkObl('KDJLQEMEDV',1))) {
_SignErr('KDJLQEMEDV');
m_cLastWorkVarErrorMsg='1816546867';
l_bResult=false;
w_COGNOME=HtW('','C');
} else if ( ! (_ChkObl('VTFLIHXHLG',1))) {
_SignErr('VTFLIHXHLG');
m_cLastWorkVarErrorMsg='443454';
l_bResult=false;
w_NOME=HtW('','C');
} else if ( ! (_ChkObl('SIJUUSKFLV',1))) {
_SignErr('SIJUUSKFLV');
m_cLastWorkVarErrorMsg='7776675';
l_bResult=false;
w_SESSO=HtW('','C');
} else if ( ! (_ChkObl('XCZARGUGTG',1))) {
_SignErr('XCZARGUGTG');
m_cLastWorkVarErrorMsg='1924622942';
l_bResult=false;
w_DNASC=HtW('','D');
} else if ( ! (_ChkObl('PZGXGIZQWY',1))) {
_SignErr('PZGXGIZQWY');
m_cLastWorkVarErrorMsg='49939619';
l_bResult=false;
w_DESCCIT=HtW('','C');
} else if ( ! (_ChkObl('WQWXGOLVXC',1))) {
_SignErr('WQWXGOLVXC');
m_cLastWorkVarErrorMsg='1336888340';
l_bResult=false;
w_CITTADINA=HtW('','C');
} else if ( ! (_ChkObl('DUROREWBNG',1))) {
_SignErr('DUROREWBNG');
m_cLastWorkVarErrorMsg='376382717';
l_bResult=false;
w_NASCOMUN=HtW('','C');
} else if ( ! (_ChkObl('ZTUIXEONYI',1))) {
_SignErr('ZTUIXEONYI');
m_cLastWorkVarErrorMsg='NASSTATO';
l_bResult=false;
w_NASSTATO=HtW('','C');
} else if ( ! (_ChkObl('KSRCRPEMFT',1))) {
_SignErr('KSRCRPEMFT');
m_cLastWorkVarErrorMsg='1614154515';
l_bResult=false;
w_PRNASC=HtW('','C');
} else if ( ! (_ChkObl('IYKMLTUWXM',1))) {
_SignErr('IYKMLTUWXM');
m_cLastWorkVarErrorMsg='11536826979';
l_bResult=false;
w_SOGCOM=HtW('','C');
} else if ( ! (_ChkObl('KYNLIGXUVC',1))) {
_SignErr('KYNLIGXUVC');
m_cLastWorkVarErrorMsg='61024920';
l_bResult=false;
w_TIPODOC=HtW('','C');
} else if ( ! (_ChkObl('IAXBQWHGLM',1))) {
_SignErr('IAXBQWHGLM');
m_cLastWorkVarErrorMsg='776361652';
l_bResult=false;
w_BPCODPAT=HtW('','C');
} else if ( ! (_ChkObl('PBQXUDZUOZ',1))) {
_SignErr('PBQXUDZUOZ');
m_cLastWorkVarErrorMsg='821432322';
l_bResult=false;
w_BPENTSEG=HtW('','C');
} else if ( ! (_ChkObl('UBNVJIYFWU',1))) {
_SignErr('UBNVJIYFWU');
m_cLastWorkVarErrorMsg='342820965';
l_bResult=false;
w_BPCOGSEG=HtW('','C');
} else if ( ! (_ChkObl('PELELICXZD',1))) {
_SignErr('PELELICXZD');
m_cLastWorkVarErrorMsg='443454';
l_bResult=false;
w_BPNOMSEG=HtW('','C');
} else if ( ! (_ChkObl('DZVDAZOPWP',1))) {
_SignErr('DZVDAZOPWP');
m_cLastWorkVarErrorMsg='10404199848';
l_bResult=false;
w_BPTELSEG=HtW('','C');
} else if ( ! (_ChkObl('HRZVDXDSOJ',1))) {
_SignErr('HRZVDXDSOJ');
m_cLastWorkVarErrorMsg='7534101';
l_bResult=false;
w_BPEMLSEG=HtW('','C');
} else if ( ! (_ChkObl('TFDNMJLIWF',1))) {
_SignErr('TFDNMJLIWF');
m_cLastWorkVarErrorMsg='19809';
l_bResult=false;
w_ABI=HtW('','C');
} else if ( ! (_ChkObl('WRRSZRBPCI',1))) {
_SignErr('WRRSZRBPCI');
m_cLastWorkVarErrorMsg='18003';
l_bResult=false;
w_CAB=HtW('','C');
} else if ( ! (_ChkObl('PUFIBBLEMQ',1))) {
_SignErr('PUFIBBLEMQ');
m_cLastWorkVarErrorMsg='1418436627';
l_bResult=false;
w_GGWARNPRV=HtW('','N');
} else if ( ! (_ChkObl('MBMIGFSBXO',1))) {
_SignErr('MBMIGFSBXO');
m_cLastWorkVarErrorMsg='10840261571';
l_bResult=false;
w_GGWARNAUI=HtW('','N');
} else if ( ! (_ChkObl('XUNVKFSSZL',1))) {
_SignErr('XUNVKFSSZL');
m_cLastWorkVarErrorMsg='513536497';
l_bResult=false;
w_SOGLIAMAX=HtW('','N');
} else if ( ! (_ChkObl('CMBYXKAJCS',1))) {
_SignErr('CMBYXKAJCS');
m_cLastWorkVarErrorMsg='10964521107';
l_bResult=false;
w_CODVASP=HtW('','C');
} else if ( ! (_ChkObl('CNQFAHXNUY',1))) {
_SignErr('CNQFAHXNUY');
m_cLastWorkVarErrorMsg='343431949';
l_bResult=false;
w_IDOAM=HtW('','C');
} else if ( ! (_ChkObl('PUYJXGBDJI',1))) {
_SignErr('PUYJXGBDJI');
m_cLastWorkVarErrorMsg='10585263250';
l_bResult=false;
w_IDOAMR=HtW('','C');
} else if ( ! (_ChkObl('DNCMAAILTV',1))) {
_SignErr('DNCMAAILTV');
m_cLastWorkVarErrorMsg='1478813640';
l_bResult=false;
w_SKT_SERVER=HtW('','C');
} else if ( ! (_ChkObl('UMEMYFCVBI',1))) {
_SignErr('UMEMYFCVBI');
m_cLastWorkVarErrorMsg='1164993875';
l_bResult=false;
w_SKT_PORT=HtW('','N');
} else if ( ! (_ChkObl('ZFUOSYKTGZ',1))) {
_SignErr('ZFUOSYKTGZ');
m_cLastWorkVarErrorMsg='11171811910';
l_bResult=false;
w_SKT_PATHS=HtW('','C');
} else if ( ! (_ChkObl('ECARBEFMBC',1))) {
_SignErr('ECARBEFMBC');
m_cLastWorkVarErrorMsg='2063760189';
l_bResult=false;
w_SKT_MODET=HtW('','C');
} else if ( ! (_ChkObl('DNNGPDMXQI',1))) {
_SignErr('DNNGPDMXQI');
m_cLastWorkVarErrorMsg='11087095564';
l_bResult=false;
w_RASPAUI=HtW('','C');
} else if ( ! (_ChkObl('WHJVJHBKYI',1))) {
_SignErr('WHJVJHBKYI');
m_cLastWorkVarErrorMsg='11973601132';
l_bResult=false;
w_RESPAUI=HtW('','C');
} else if ( ! (_ChkObl('ZZSBUTEXWS',1))) {
_SignErr('ZZSBUTEXWS');
m_cLastWorkVarErrorMsg='321149674';
l_bResult=false;
w_TESTIP=HtW('','C');
} else if ( ! (_ChkObl('XRGIDJXVCB',1))) {
_SignErr('XRGIDJXVCB');
m_cLastWorkVarErrorMsg='11688003470';
l_bResult=false;
w_MINFRZSNAI=HtW('','N');
} else if ( ! (_ChkObl('CZINOLQOUB',1))) {
_SignErr('CZINOLQOUB');
m_cLastWorkVarErrorMsg='2088685076';
l_bResult=false;
w_FLGSCDFRZ='N';
} else if ((Eq(w_FLGSCDFRZ,'S')) && ( ! (_ChkObl('BMMUPRLVUU',1)))) {
_SignErr('BMMUPRLVUU');
m_cLastWorkVarErrorMsg='11490314427';
l_bResult=false;
w_GIORNIFRZ=HtW('','N');
} else if ( ! (_ChkObl('JFMMDZQFJC',1))) {
_SignErr('JFMMDZQFJC');
m_cLastWorkVarErrorMsg='11843606227';
l_bResult=false;
w_LIMITVLT=HtW('','N');
} else if ( ! (_ChkObl('OHKFECVWFV',1))) {
_SignErr('OHKFECVWFV');
m_cLastWorkVarErrorMsg='2015453927';
l_bResult=false;
w_LIMITVNP=HtW('','N');
} else if ( ! (_ChkObl('OOAVIAADZS',1))) {
_SignErr('OOAVIAADZS');
m_cLastWorkVarErrorMsg='282519940';
l_bResult=false;
w_FLGSTPDIR='N';
} else if ( ! (_ChkObl('MRWHAAPELH',1))) {
_SignErr('MRWHAAPELH');
m_cLastWorkVarErrorMsg='1193776028';
l_bResult=false;
w_FLGNODOC='N';
} else if ( ! (_ChkObl('HBTCFEMATT',1))) {
_SignErr('HBTCFEMATT');
m_cLastWorkVarErrorMsg='10969052023';
l_bResult=false;
w_FRAZDEL='N';
} else if ( ! (_ChkObl('FOTKWJQFAL',1))) {
_SignErr('FOTKWJQFAL');
m_cLastWorkVarErrorMsg='10862260321';
l_bResult=false;
w_PATHAPP=HtW('','C');
} else if ( ! (_ChkObl('QMOTVZANBJ',1))) {
_SignErr('QMOTVZANBJ');
m_cLastWorkVarErrorMsg='10471602801';
l_bResult=false;
w_FLGLIGHT='N';
} else if ( ! (_ChkObl('JPABVPZDBZ',1))) {
_SignErr('JPABVPZDBZ');
m_cLastWorkVarErrorMsg='pathmanuale';
l_bResult=false;
w_pathmanuale=HtW('','C');
} else if ( ! (_ChkObl('VJPULIZVKG',1))) {
_SignErr('VJPULIZVKG');
m_cLastWorkVarErrorMsg='11829318249';
l_bResult=false;
w_FLGCGOPWD='N';
} else if ((false) && ( ! (_ChkObl('EMDHDDRUPP',1)))) {
_SignErr('EMDHDDRUPP');
m_cLastWorkVarErrorMsg='1594022391';
l_bResult=false;
w_PATHSID=HtW('','C');
} else if ( ! (_ChkObl('WXRSSFBXYH',1))) {
_SignErr('WXRSSFBXYH');
m_cLastWorkVarErrorMsg='10895800895';
l_bResult=false;
w_PATHCERT=HtW('','C');
} else if ( ! (_ChkObl('WPPFTLWEWX',1))) {
_SignErr('WPPFTLWEWX');
m_cLastWorkVarErrorMsg='10901840369';
l_bResult=false;
w_PATHFTP=HtW('','C');
} else if ( ! (_ChkObl('KZJBLRRDWP',1))) {
_SignErr('KZJBLRRDWP');
m_cLastWorkVarErrorMsg='10119643152';
l_bResult=false;
w_FLGUTEAGE='N';
} else if ( ! (_ChkObl('PUWCGJFLDF',1))) {
_SignErr('PUWCGJFLDF');
m_cLastWorkVarErrorMsg='614440993';
l_bResult=false;
w_PRGAEPATH=HtW('','C');
} else if ( ! (_ChkObl('NVZYOQAKDU',1))) {
_SignErr('NVZYOQAKDU');
m_cLastWorkVarErrorMsg='1199608503';
l_bResult=false;
w_NUMGIORN=HtW('','N');
} else if ( ! (_ChkObl('MHHQTFPDEN',1))) {
_SignErr('MHHQTFPDEN');
m_cLastWorkVarErrorMsg='48458917';
l_bResult=false;
w_FLGCGOOTP='N';
} else if ( ! (_ChkObl('SSXDYZLCUX',1))) {
_SignErr('SSXDYZLCUX');
m_cLastWorkVarErrorMsg='915236354';
l_bResult=false;
w_FLGCGOQADV='N';
} else if ( ! (_ChkObl('XVGAGFPMXP',1))) {
_SignErr('XVGAGFPMXP');
m_cLastWorkVarErrorMsg='535087343';
l_bResult=false;
w_BLOCCOUSER=HtW('','N');
} else if ( ! (_ChkObl('ABGLJLFEYQ',1))) {
_SignErr('ABGLJLFEYQ');
m_cLastWorkVarErrorMsg='628897822';
l_bResult=false;
w_CGOFLGPROF='N';
} else if ( ! (_ChkObl('MLYQUOWFHN',1))) {
_SignErr('MLYQUOWFHN');
m_cLastWorkVarErrorMsg='1538539509';
l_bResult=false;
w_ALTSRVMAIL=HtW('','C');
} else if ( ! (_ChkObl('VRYHAZPGSR',1))) {
_SignErr('VRYHAZPGSR');
m_cLastWorkVarErrorMsg='6863168';
l_bResult=false;
w_ALTPRTMAIL=HtW('','C');
} else if ( ! (_ChkObl('TYOXRXGXKJ',1))) {
_SignErr('TYOXRXGXKJ');
m_cLastWorkVarErrorMsg='10759744842';
l_bResult=false;
w_ALTEMLMAIL=HtW('','C');
} else if ( ! (_ChkObl('OKEJPCYNVH',1))) {
_SignErr('OKEJPCYNVH');
m_cLastWorkVarErrorMsg='11227707037';
l_bResult=false;
w_ALTUSRMAIL=HtW('','C');
} else if ( ! (_ChkObl('IIVBDSFKCC',1))) {
_SignErr('IIVBDSFKCC');
m_cLastWorkVarErrorMsg='11183930016';
l_bResult=false;
w_ALTPWDMAIL=HtW('','C');
} else if ( ! (_ChkObl('FYAHSLEGLP',1))) {
_SignErr('FYAHSLEGLP');
m_cLastWorkVarErrorMsg='296951675';
l_bResult=false;
w_FLGGESDOC='N';
} else if ( ! (_ChkObl('MUANKUGIIK',1))) {
_SignErr('MUANKUGIIK');
m_cLastWorkVarErrorMsg='10519994838';
l_bResult=false;
w_USRGESDOC=HtW('','C');
} else if ( ! (_ChkObl('HFVZAFILCA',1))) {
_SignErr('HFVZAFILCA');
m_cLastWorkVarErrorMsg='10274446797';
l_bResult=false;
w_PWDGESDOC=HtW('','C');
} else if ( ! (_ChkObl('RNIWEERJDP',1))) {
_SignErr('RNIWEERJDP');
m_cLastWorkVarErrorMsg='1506669781';
l_bResult=false;
w_URLDESDOC=HtW('','C');
} else if ( ! (_ChkObl('LZEBZLGWCH',1))) {
_SignErr('LZEBZLGWCH');
m_cLastWorkVarErrorMsg='1173187617';
l_bResult=false;
w_EMAILDOC=HtW('','C');
} else if ( ! (_ChkObl('VOONRSAKSU',1))) {
_SignErr('VOONRSAKSU');
m_cLastWorkVarErrorMsg='10300990862';
l_bResult=false;
w_DATADOC=HtW('','D');
} else if ( ! (_ChkObl('MRRDOEHYLX',1))) {
_SignErr('MRRDOEHYLX');
m_cLastWorkVarErrorMsg='10252967626';
l_bResult=false;
w_PATHDOCBAC=HtW('','C');
} else if ( ! (_ChkObl('ABFCWFBDMW',1))) {
_SignErr('ABFCWFBDMW');
m_cLastWorkVarErrorMsg='11017138898';
l_bResult=false;
w_IMPPATH=HtW('','C');
} else if ( ! (_ChkObl('GORKFABVFF',1))) {
_SignErr('GORKFABVFF');
m_cLastWorkVarErrorMsg='547041811';
l_bResult=false;
w_CGOTGDEFMUL=HtW('','C');
} else if ( ! (_ChkObl('HAPCMCIYJW',1))) {
_SignErr('HAPCMCIYJW');
m_cLastWorkVarErrorMsg='10629686554';
l_bResult=false;
w_SONUMMESI=HtW('','N');
} else if ( ! (_ChkObl('OAAOYRQPRR',1))) {
_SignErr('OAAOYRQPRR');
m_cLastWorkVarErrorMsg='10222585128';
l_bResult=false;
w_SOMESIBACK=HtW('','N');
} else if ( ! (_ChkObl('IDOPVICMXL',1))) {
_SignErr('IDOPVICMXL');
m_cLastWorkVarErrorMsg='156458968';
l_bResult=false;
w_SOSHELLCMD=HtW('','M');
} else if ( ! (_ChkObl('ATYYTAXDZW',1))) {
_SignErr('ATYYTAXDZW');
m_cLastWorkVarErrorMsg='11928289558';
l_bResult=false;
w_SOAMBIENTE=HtW('','C');
} else if ( ! (_ChkObl('GHUASLAKBC',1))) {
_SignErr('GHUASLAKBC');
m_cLastWorkVarErrorMsg='11556190124';
l_bResult=false;
w_SOPATHIMPORT=HtW('','M');
} else if ( ! (_ChkObl('APTIWOKBUI',1))) {
_SignErr('APTIWOKBUI');
m_cLastWorkVarErrorMsg='102290740';
l_bResult=false;
w_SOORAIMPORT=HtW('','N');
} else if ( ! (_ChkObl('HRSWOWLUUE',1))) {
_SignErr('HRSWOWLUUE');
m_cLastWorkVarErrorMsg='11128798379';
l_bResult=false;
w_QADV_SOGLIA=HtW('','N');
}
if (l_bResult) {
l_bResult=CheckChild(0);
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('JCGROGAZTR_ZOOM',lc)) {
return 0;
}
if (Eq('JCGROGAZTR',lc)) {
return 0;
}
if (Eq('IIXRREUEAM_ZOOM',lc)) {
return 1;
}
if (Eq('IIXRREUEAM',lc)) {
return 1;
}
if (Eq('LLYIGAMXRH_ZOOM',lc)) {
return 2;
}
if (Eq('LLYIGAMXRH',lc)) {
return 2;
}
if (Eq('RVNHQCXNEM_ZOOM',lc)) {
return 3;
}
if (Eq('RVNHQCXNEM',lc)) {
return 3;
}
if (Eq('ZGNLLSFQHC_ZOOM',lc)) {
return 4;
}
if (Eq('ZGNLLSFQHC',lc)) {
return 4;
}
if (Eq('PSZTLCSMPB_ZOOM',lc)) {
return 5;
}
if (Eq('PSZTLCSMPB',lc)) {
return 5;
}
if (Eq('LAQADJFMRL_ZOOM',lc)) {
return 6;
}
if (Eq('IQOQQQRZAK_ZOOM',lc)) {
return 6;
}
if (Eq('ASIWFAENLM_ZOOM',lc)) {
return 6;
}
if (Eq('IOYUNQJDKZ_ZOOM',lc)) {
return 6;
}
if (Eq('XCZARGUGTG_ZOOM',lc)) {
return 6;
}
if (Eq('PZGXGIZQWY_ZOOM',lc)) {
return 6;
}
if (Eq('PZGXGIZQWY',lc)) {
return 6;
}
if (Eq('DUROREWBNG_ZOOM',lc)) {
return 7;
}
if (Eq('DUROREWBNG',lc)) {
return 7;
}
if (Eq('ZTUIXEONYI_ZOOM',lc)) {
return 8;
}
if (Eq('ZTUIXEONYI',lc)) {
return 8;
}
if (Eq('VOONRSAKSU_ZOOM',lc)) {
return 9;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_JCGROGAZTR();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,1)) {
l_oWv=LOpt_IIXRREUEAM();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,2)) {
l_oWv=LOpt_LLYIGAMXRH();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,3)) {
l_oWv=LOpt_RVNHQCXNEM();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,4)) {
l_oWv=LOpt_ZGNLLSFQHC();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,5)) {
l_oWv=LOpt_PSZTLCSMPB();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,6)) {
l_oWv=LOpt_PZGXGIZQWY();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,7)) {
l_oWv=LOpt_DUROREWBNG();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,8)) {
l_oWv=LOpt_ZTUIXEONYI();
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
l_oWv.setValue('TIPINTER',WtA(w_TIPINTER,'C'));
l_oWv.setValue('RAGSOC',WtA(w_RAGSOC,'C'));
l_oWv.setValue('DESCCIT',WtA(w_DESCCIT,'C'));
l_oWv.setValue('PROVINCIA',WtA(w_PROVINCIA,'C'));
l_oWv.setValue('CAP',WtA(w_CAP,'C'));
l_oWv.setValue('CODCAB',WtA(w_CODCAB,'C'));
l_oWv.setValue('DOMICILIO',WtA(w_DOMICILIO,'C'));
l_oWv.setValue('PAESE',WtA(w_PAESE,'C'));
l_oWv.setValue('CODFISC',WtA(w_CODFISC,'C'));
l_oWv.setValue('PARTIVA',WtA(w_PARTIVA,'C'));
l_oWv.setValue('DATANASC',WtA(w_DATANASC,'D'));
l_oWv.setValue('SOTGRUP',WtA(w_SOTGRUP,'C'));
l_oWv.setValue('RAMOGRUP',WtA(w_RAMOGRUP,'C'));
l_oWv.setValue('SETTSINT',WtA(w_SETTSINT,'C'));
l_oWv.setValue('TIPODOC',WtA(w_TIPODOC,'C'));
l_oWv.setValue('SESSO',WtA(w_SESSO,'C'));
l_oWv.setValue('NUMDOCUM',WtA(w_NUMDOCUM,'C'));
l_oWv.setValue('DATARILASC',WtA(w_DATARILASC,'D'));
l_oWv.setValue('AUTRILASC',WtA(w_AUTRILASC,'C'));
l_oWv.setValue('CODDIPE',WtA(w_CODDIPE,'C'));
l_oWv.setValue('CONNES',WtA(w_CONNES,'C'));
l_oWv.setValue('NOTE',WtA(w_NOTE,'M'));
l_oWv.setValue('CODORO',WtA(w_CODORO,'C'));
l_oWv.setValue('CODINTER',WtA(w_CODINTER,'C'));
l_oWv.setValue('TIPOPERS',WtA(w_TIPOPERS,'C'));
l_oWv.setValue('IDCITTA',WtA(w_IDCITTA,'C'));
l_oWv.setValue('DATAVALI',WtA(w_DATAVALI,'D'));
l_oWv.setValue('CONTATORE',WtA(w_CONTATORE,'N'));
l_oWv.setValue('CFINVIO',WtA(w_CFINVIO,'C'));
l_oWv.setValue('CAFINVIO',WtA(w_CAFINVIO,'C'));
l_oWv.setValue('FILEINVIO',WtA(w_FILEINVIO,'C'));
l_oWv.setValue('URLAPPL',WtA(w_URLAPPL,'C'));
l_oWv.setValue('FLGLOG',WtA(w_FLGLOG,'C'));
l_oWv.setValue('FLGAOS',WtA(w_FLGAOS,'C'));
l_oWv.setValue('FLGEAOS',WtA(w_FLGEAOS,'C'));
l_oWv.setValue('FLGCDOC',WtA(w_FLGCDOC,'C'));
l_oWv.setValue('FLGFRAZ',WtA(w_FLGFRAZ,'C'));
l_oWv.setValue('FLGAPERS',WtA(w_FLGAPERS,'C'));
l_oWv.setValue('DTINIATT',WtA(w_DTINIATT,'D'));
l_oWv.setValue('FLGTIPIMP',WtA(w_FLGTIPIMP,'C'));
l_oWv.setValue('FLGSTPCON',WtA(w_FLGSTPCON,'C'));
l_oWv.setValue('FLGIMPAGE',WtA(w_FLGIMPAGE,'C'));
l_oWv.setValue('FLGWU',WtA(w_FLGWU,'C'));
l_oWv.setValue('DATAINVIO',WtA(w_DATAINVIO,'D'));
l_oWv.setValue('IMPINTOPE',WtA(w_IMPINTOPE,'N'));
l_oWv.setValue('FLGOPEXTR',WtA(w_FLGOPEXTR,'C'));
l_oWv.setValue('FLGRAPCLI',WtA(w_FLGRAPCLI,'C'));
l_oWv.setValue('FLGDATAIM',WtA(w_FLGDATAIM,'N'));
l_oWv.setValue('FLGDATATP',WtA(w_FLGDATATP,'N'));
l_oWv.setValue('NOCODFISC',WtA(w_NOCODFISC,'N'));
l_oWv.setValue('FLGCHK',WtA(w_FLGCHK,'C'));
l_oWv.setValue('CODAGE',WtA(w_CODAGE,'C'));
l_oWv.setValue('IDSID',WtA(w_IDSID,'C'));
l_oWv.setValue('SIDPASS',WtA(w_SIDPASS,'C'));
l_oWv.setValue('PATHJAVA',WtA(w_PATHJAVA,'C'));
l_oWv.setValue('TIPOINST',WtA(w_TIPOINST,'C'));
l_oWv.setValue('FLGSIDAUTO',WtA(w_FLGSIDAUTO,'N'));
l_oWv.setValue('SOSPMAF',WtA(w_SOSPMAF,'C'));
l_oWv.setValue('FLGRITORNO',WtA(w_FLGRITORNO,'C'));
l_oWv.setValue('FLGCREAAGE',WtA(w_FLGCREAAGE,'C'));
l_oWv.setValue('DTTITAGE',WtA(w_DTTITAGE,'D'));
l_oWv.setValue('SCADSALDI',WtA(w_SCADSALDI,'D'));
l_oWv.setValue('FLGIPMT',WtA(w_FLGIPMT,'C'));
l_oWv.setValue('LIMITEFRZ',WtA(w_LIMITEFRZ,'N'));
l_oWv.setValue('DBPROT',WtA(w_DBPROT,'C'));
l_oWv.setValue('OAMTPDOC',WtA(w_OAMTPDOC,'N'));
l_oWv.setValue('DAYSIMPORT',WtA(w_DAYSIMPORT,'N'));
l_oWv.setValue('DAYSIMPCMB',WtA(w_DAYSIMPCMB,'N'));
l_oWv.setValue('TIPOSV',WtA(w_TIPOSV,'C'));
l_oWv.setValue('FLGAWUPOS',WtA(w_FLGAWUPOS,'C'));
l_oWv.setValue('WUGIOSCA',WtA(w_WUGIOSCA,'N'));
l_oWv.setValue('WUGGALERT',WtA(w_WUGGALERT,'N'));
l_oWv.setValue('SKT_SERVER',WtA(w_SKT_SERVER,'C'));
l_oWv.setValue('SKT_PORT',WtA(w_SKT_PORT,'N'));
l_oWv.setValue('SKT_PATHS',WtA(w_SKT_PATHS,'C'));
l_oWv.setValue('SKT_MODET',WtA(w_SKT_MODET,'C'));
l_oWv.setValue('RASPAUI',WtA(w_RASPAUI,'C'));
l_oWv.setValue('RESPAUI',WtA(w_RESPAUI,'C'));
l_oWv.setValue('TESTIP',WtA(w_TESTIP,'C'));
l_oWv.setValue('MINFRZSNAI',WtA(w_MINFRZSNAI,'N'));
l_oWv.setValue('FLGSCDFRZ',WtA(w_FLGSCDFRZ,'C'));
l_oWv.setValue('GIORNIFRZ',WtA(w_GIORNIFRZ,'N'));
l_oWv.setValue('LIMITVLT',WtA(w_LIMITVLT,'N'));
l_oWv.setValue('LIMITVNP',WtA(w_LIMITVNP,'N'));
l_oWv.setValue('FLGSTPDIR',WtA(w_FLGSTPDIR,'C'));
l_oWv.setValue('FLGNODOC',WtA(w_FLGNODOC,'C'));
l_oWv.setValue('SNAISTOR',WtA(w_SNAISTOR,'C'));
l_oWv.setValue('FRAZDEL',WtA(w_FRAZDEL,'C'));
l_oWv.setValue('PATHAPP',WtA(w_PATHAPP,'C'));
l_oWv.setValue('FLGDDOC',WtA(w_FLGDDOC,'C'));
l_oWv.setValue('FLGLIGHT',WtA(w_FLGLIGHT,'C'));
l_oWv.setValue('FLGCGOPWD',WtA(w_FLGCGOPWD,'C'));
l_oWv.setValue('PATHSID',WtA(w_PATHSID,'C'));
l_oWv.setValue('PATHCERT',WtA(w_PATHCERT,'C'));
l_oWv.setValue('PATHFTP',WtA(w_PATHFTP,'C'));
l_oWv.setValue('FLGUTEAGE',WtA(w_FLGUTEAGE,'C'));
l_oWv.setValue('PRGAEPATH',WtA(w_PRGAEPATH,'C'));
l_oWv.setValue('NUMGIORN',WtA(w_NUMGIORN,'N'));
l_oWv.setValue('COGNOME',WtA(w_COGNOME,'C'));
l_oWv.setValue('NOME',WtA(w_NOME,'C'));
l_oWv.setValue('DNASC',WtA(w_DNASC,'D'));
l_oWv.setValue('CITTADINA',WtA(w_CITTADINA,'C'));
l_oWv.setValue('NASCOMUN',WtA(w_NASCOMUN,'C'));
l_oWv.setValue('NASSTATO',WtA(w_NASSTATO,'C'));
l_oWv.setValue('PRNASC',WtA(w_PRNASC,'C'));
l_oWv.setValue('SOGCOM',WtA(w_SOGCOM,'C'));
l_oWv.setValue('ALTSRVMAIL',WtA(w_ALTSRVMAIL,'C'));
l_oWv.setValue('ALTPRTMAIL',WtA(w_ALTPRTMAIL,'C'));
l_oWv.setValue('ALTEMLMAIL',WtA(w_ALTEMLMAIL,'C'));
l_oWv.setValue('ALTUSRMAIL',WtA(w_ALTUSRMAIL,'C'));
l_oWv.setValue('ALTPWDMAIL',WtA(w_ALTPWDMAIL,'C'));
l_oWv.setValue('FLGGESDOC',WtA(w_FLGGESDOC,'C'));
l_oWv.setValue('USRGESDOC',WtA(w_USRGESDOC,'C'));
l_oWv.setValue('PWDGESDOC',WtA(w_PWDGESDOC,'C'));
l_oWv.setValue('URLDESDOC',WtA(w_URLDESDOC,'C'));
l_oWv.setValue('EMAILDOC',WtA(w_EMAILDOC,'C'));
l_oWv.setValue('DATADOC',WtA(w_DATADOC,'D'));
l_oWv.setValue('PATHDOCBAC',WtA(w_PATHDOCBAC,'C'));
l_oWv.setValue('IMPPATH',WtA(w_IMPPATH,'C'));
l_oWv.setValue('BPCODPAT',WtA(w_BPCODPAT,'C'));
l_oWv.setValue('BPENTSEG',WtA(w_BPENTSEG,'C'));
l_oWv.setValue('BPCOGSEG',WtA(w_BPCOGSEG,'C'));
l_oWv.setValue('BPNOMSEG',WtA(w_BPNOMSEG,'C'));
l_oWv.setValue('BPTELSEG',WtA(w_BPTELSEG,'C'));
l_oWv.setValue('BPEMLSEG',WtA(w_BPEMLSEG,'C'));
l_oWv.setValue('RICEVUTE',WtA(w_RICEVUTE,'C'));
l_oWv.setValue('ABI',WtA(w_ABI,'C'));
l_oWv.setValue('CAB',WtA(w_CAB,'C'));
l_oWv.setValue('OGGI3I4',WtA(w_OGGI3I4,'C'));
l_oWv.setValue('CGOTGDEFMUL',WtA(w_CGOTGDEFMUL,'C'));
l_oWv.setValue('AUTOSARA',WtA(w_AUTOSARA,'C'));
l_oWv.setValue('GGWARNPRV',WtA(w_GGWARNPRV,'N'));
l_oWv.setValue('GGWARNAUI',WtA(w_GGWARNAUI,'N'));
l_oWv.setValue('SOGLIAMAX',WtA(w_SOGLIAMAX,'N'));
l_oWv.setValue('LIMITE20',WtA(w_LIMITE20,'D'));
l_oWv.setValue('SONUMMESI',WtA(w_SONUMMESI,'N'));
l_oWv.setValue('SOMESIBACK',WtA(w_SOMESIBACK,'N'));
l_oWv.setValue('SOSHELLCMD',WtA(w_SOSHELLCMD,'M'));
l_oWv.setValue('SOAMBIENTE',WtA(w_SOAMBIENTE,'C'));
l_oWv.setValue('SOPATHIMPORT',WtA(w_SOPATHIMPORT,'M'));
l_oWv.setValue('SOORAIMPORT',WtA(w_SOORAIMPORT,'N'));
l_oWv.setValue('QADV_SOGLIA',WtA(w_QADV_SOGLIA,'N'));
l_oWv.setValue('FLGCGOOTP',WtA(w_FLGCGOOTP,'C'));
l_oWv.setValue('FLGCGOQADV',WtA(w_FLGCGOQADV,'C'));
l_oWv.setValue('ITFLGPEP',WtA(w_ITFLGPEP,'C'));
l_oWv.setValue('ITPWDPEP',WtA(w_ITPWDPEP,'C'));
l_oWv.setValue('ITUSRPEP',WtA(w_ITUSRPEP,'C'));
l_oWv.setValue('BLOCCOUSER',WtA(w_BLOCCOUSER,'N'));
l_oWv.setValue('CGOFLGPROF',WtA(w_CGOFLGPROF,'C'));
l_oWv.setValue('FLGAGGFAM',WtA(w_FLGAGGFAM,'C'));
l_oWv.setValue('ALTSSLEMAIL',WtA(w_ALTSSLEMAIL,'C'));
l_oWv.setValue('PATHIMPORT',WtA(w_PATHIMPORT,'C'));
l_oWv.setValue('DESTEMAIL',WtA(w_DESTEMAIL,'C'));
l_oWv.setValue('CODVASP',WtA(w_CODVASP,'C'));
l_oWv.setValue('IDOAM',WtA(w_IDOAM,'C'));
l_oWv.setValue('IDOAMR',WtA(w_IDOAMR,'C'));
l_oWv.setValue('ART1',WtA(w_ART1,'N'));
l_oWv.setValue('DESCRIsta',WtA(w_DESCRIsta,'C'));
l_oWv.setValue('DESCSGRU',WtA(w_DESCSGRU,'C'));
l_oWv.setValue('DESCRAMGRU',WtA(w_DESCRAMGRU,'C'));
l_oWv.setValue('DESCUIC',WtA(w_DESCUIC,'C'));
l_oWv.setValue('descdip',WtA(w_descdip,'C'));
l_oWv.setValue('tipsot',WtA(w_tipsot,'C'));
l_oWv.setValue('xdescitdip',WtA(w_xdescitdip,'C'));
l_oWv.setValue('xcabdip',WtA(w_xcabdip,'C'));
l_oWv.setValue('gUserCode',WtA(w_gUserCode,'N'));
l_oWv.setValue('ATTIV',WtA(w_ATTIV,'C'));
l_oWv.setValue('gUrlApp',WtA(w_gUrlApp,'C'));
l_oWv.setValue('gAzienda',WtA(w_gAzienda,'C'));
l_oWv.setValue('PWDSER',WtA(w_PWDSER,'C'));
l_oWv.setValue('appocert',WtA(w_appocert,'C'));
l_oWv.setValue('pathmanuale',WtA(w_pathmanuale,'C'));
l_oWv.setValue('xDESCAN',WtA(w_xDESCAN,'C'));
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
_FillChildren.n=['ardt_destwarn','ardt_cgo_tipall','ardt_cgo_subnets','ardt_destemail'];
FillWv.n=["TIPINTER","RAGSOC","DESCCIT","PROVINCIA","CAP","CODCAB","DOMICILIO","PAESE","CODFISC","PARTIVA","DATANASC","SOTGRUP","RAMOGRUP","SETTSINT","TIPODOC","SESSO","NUMDOCUM","DATARILASC","AUTRILASC","CODDIPE","CONNES","NOTE","CODORO","CODINTER","TIPOPERS","IDCITTA","DATAVALI","CONTATORE","CFINVIO","CAFINVIO","FILEINVIO","URLAPPL","FLGLOG","FLGAOS","FLGEAOS","FLGCDOC","FLGFRAZ","FLGAPERS","DTINIATT","FLGTIPIMP","FLGSTPCON","FLGIMPAGE","FLGWU","DATAINVIO","IMPINTOPE","FLGOPEXTR","FLGRAPCLI","FLGDATAIM","FLGDATATP","NOCODFISC","FLGCHK","CODAGE","IDSID","SIDPASS","PATHJAVA","TIPOINST","FLGSIDAUTO","SOSPMAF","FLGRITORNO","FLGCREAAGE","DTTITAGE","SCADSALDI","FLGIPMT","LIMITEFRZ","DBPROT","OAMTPDOC","DAYSIMPORT","DAYSIMPCMB","TIPOSV","FLGAWUPOS","WUGIOSCA","WUGGALERT","SKT_SERVER","SKT_PORT","SKT_PATHS","SKT_MODET","RASPAUI","RESPAUI","TESTIP","MINFRZSNAI","FLGSCDFRZ","GIORNIFRZ","LIMITVLT","LIMITVNP","FLGSTPDIR","FLGNODOC","SNAISTOR","FRAZDEL","PATHAPP","FLGDDOC","FLGLIGHT","FLGCGOPWD","PATHSID","PATHCERT","PATHFTP","FLGUTEAGE","PRGAEPATH","NUMGIORN","COGNOME","NOME","DNASC","CITTADINA","NASCOMUN","NASSTATO","PRNASC","SOGCOM","ALTSRVMAIL","ALTPRTMAIL","ALTEMLMAIL","ALTUSRMAIL","ALTPWDMAIL","FLGGESDOC","USRGESDOC","PWDGESDOC","URLDESDOC","EMAILDOC","DATADOC","PATHDOCBAC","IMPPATH","BPCODPAT","BPENTSEG","BPCOGSEG","BPNOMSEG","BPTELSEG","BPEMLSEG","RICEVUTE","ABI","CAB","OGGI3I4","CGOTGDEFMUL","AUTOSARA","GGWARNPRV","GGWARNAUI","SOGLIAMAX","LIMITE20","SONUMMESI","SOMESIBACK","SOSHELLCMD","SOAMBIENTE","SOPATHIMPORT","SOORAIMPORT","QADV_SOGLIA","FLGCGOOTP","FLGCGOQADV","ITFLGPEP","ITPWDPEP","ITUSRPEP","BLOCCOUSER","CGOFLGPROF","FLGAGGFAM","ALTSSLEMAIL","PATHIMPORT","DESTEMAIL","CODVASP","IDOAM","IDOAMR","ART1","DESCRIsta","DESCSGRU","DESCRAMGRU","DESCUIC","descdip","tipsot","xdescitdip","xcabdip","gUserCode","ATTIV","gUrlApp","gAzienda","PWDSER","appocert","pathmanuale","xDESCAN"];
function SetModified() {
m_bUpdated=true;
}
function SetChildVariables_ardt_destwarn() {
}
function CtxLoad_ardt_destwarn() {
if (ChildToLoad(FrameRef('ardt_destwarn'))) {
return [LoadContext(0,'JBFAVRHYDR'),'ardt_destwarn'];
}
}
function SetChildVariables_ardt_cgo_tipall() {
}
function CtxLoad_ardt_cgo_tipall() {
if (ChildToLoad(FrameRef('ardt_cgo_tipall'))) {
return [LoadContext(0,'TOSEVHXRVF'),'ardt_cgo_tipall'];
}
}
function SetChildVariables_ardt_cgo_subnets() {
}
function CtxLoad_ardt_cgo_subnets() {
if (ChildToLoad(FrameRef('ardt_cgo_subnets'))) {
return [LoadContext(0,'KDWFCOUSQZ'),'ardt_cgo_subnets'];
}
}
function SetChildVariables_ardt_destemail() {
}
function CtxLoad_ardt_destemail() {
if (ChildToLoad(FrameRef('ardt_destemail'))) {
return [LoadContext(0,'JWJORCKLGL'),'ardt_destemail'];
}
}
