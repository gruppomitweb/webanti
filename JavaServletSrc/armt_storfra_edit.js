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
function DisplayErrorMessage_ardt_wlientifrz() {
if ( ! (ChildToLoad(FrameRef('ardt_wlientifrz'))) && Ne(typeof(FrameRef('ardt_wlientifrz').DisplayErrorMessage),'undefined')) {
FrameRef('ardt_wlientifrz').DisplayErrorMessage();
}
}
function DisplayErrorMessage_ardt_storsogfraz() {
if ( ! (ChildToLoad(FrameRef('ardt_storsogfraz'))) && Ne(typeof(FrameRef('ardt_storsogfraz').DisplayErrorMessage),'undefined')) {
FrameRef('ardt_storsogfraz').DisplayErrorMessage();
}
}
function DisplayErrorMessage_ardt_weneficfrz() {
if ( ! (ChildToLoad(FrameRef('ardt_weneficfrz'))) && Ne(typeof(FrameRef('ardt_weneficfrz').DisplayErrorMessage),'undefined')) {
FrameRef('ardt_weneficfrz').DisplayErrorMessage();
}
}
function DisplayErrorMessage_ardt_werzistifrz() {
if ( ! (ChildToLoad(FrameRef('ardt_werzistifrz'))) && Ne(typeof(FrameRef('ardt_werzistifrz').DisplayErrorMessage),'undefined')) {
FrameRef('ardt_werzistifrz').DisplayErrorMessage();
}
}
function DisplayErrorMessage_ardt_docfrabo() {
if ( ! (ChildToLoad(FrameRef('ardt_docfrabo'))) && Ne(typeof(FrameRef('ardt_docfrabo').DisplayErrorMessage),'undefined')) {
FrameRef('ardt_docfrabo').DisplayErrorMessage();
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
l_bEnabled= ! (Ne(w_gChkDate,'U') && Ne(w_gChkDate,'B') && Eq(w_gFlgDTP,0)) || IsDisabledByStateDriver('DATAREG');
SetDisabled('NXYGHZZLCG',l_bEnabled);
l_bEnabled= ! (Eq(w_FLAGCONT,'1')) || IsDisabledByStateDriver('xTOTCONT');
SetDisabled('KUMAEYPETV',l_bEnabled);
l_bEnabled= ! ( ! (Empty(LRTrim(w_CONNESOPER)))) || IsDisabledByStateDriver('PAGASOGOP');
SetDisabled('TMYVGJFCXV',l_bEnabled);
l_bEnabled= ! (false) || IsDisabledByStateDriver('DATARETT');
SetDisabled('VYBZEWHKFF',l_bEnabled);
if (IsDisabledByStateDriver('box_HZHFVWKGKP')) {
DisableInputsInContainer(Ctrl('HZHFVWKGKP'),true);
}
if (IsDisabledByStateDriver('box_JOFBXTNMTP')) {
DisableInputsInContainer(Ctrl('JOFBXTNMTP'),true);
}
if (IsDisabledByStateDriver('box_XLSSDAVPDH')) {
DisableInputsInContainer(Ctrl('XLSSDAVPDH'),true);
}
if (IsDisabledByStateDriver('box_HGCXMHOHLD')) {
DisableInputsInContainer(Ctrl('HGCXMHOHLD'),true);
}
if (IsDisabledByStateDriver('box_HXTNEUCQUZ')) {
DisableInputsInContainer(Ctrl('HXTNEUCQUZ'),true);
}
if (IsDisabledByStateDriver('box_KURTXQHCYE')) {
DisableInputsInContainer(Ctrl('KURTXQHCYE'),true);
}
if (IsDisabledByStateDriver('Intestatari')) {
DisableInputsInContainer(Ctrl('BDZUATYPMW'),true);
}
if (IsDisabledByStateDriver('Esecutori')) {
DisableInputsInContainer(Ctrl('ZYUUSRMPQG'),true);
}
if (IsDisabledByStateDriver('box_HNGGJVVCNB')) {
DisableInputsInContainer(Ctrl('HNGGJVVCNB'),true);
}
if (IsDisabledByStateDriver('box_EUBBNRKXRL')) {
DisableInputsInContainer(Ctrl('EUBBNRKXRL'),true);
}
if (IsDisabledByStateDriver('Controparti')) {
DisableInputsInContainer(Ctrl('GTSBULOFTD'),true);
}
if (IsDisabledByStateDriver('SoggTerzi')) {
DisableInputsInContainer(Ctrl('BHLGNNSXQY'),true);
}
if (IsDisabledByStateDriver('box_MDLVFVTHTI')) {
DisableInputsInContainer(Ctrl('MDLVFVTHTI'),true);
}
if (IsDisabledByStateDriver('box_XBHGNJLLKW')) {
DisableInputsInContainer(Ctrl('XBHGNJLLKW'),true);
}
if (IsDisabledByStateDriver('AGE')) {
DisableInputsInContainer(Ctrl('HWXHLCWYTW'),true);
}
if (IsDisabledByStateDriver('box_EPMKMXEEOS')) {
DisableInputsInContainer(Ctrl('EPMKMXEEOS'),true);
}
if (IsDisabledByStateDriver('box_BAZZCBWNET')) {
DisableInputsInContainer(Ctrl('BAZZCBWNET'),true);
}
if (IsDisabledByStateDriver('Internet')) {
DisableInputsInContainer(Ctrl('JTWNGHDSFX'),true);
}
if (IsDisabledByStateDriver('box_WDZXXUSHOC')) {
DisableInputsInContainer(Ctrl('WDZXXUSHOC'),true);
}
if (IsDisabledByStateDriver('box_UMWUWBXDQZ')) {
DisableInputsInContainer(Ctrl('UMWUWBXDQZ'),true);
}
if (IsDisabledByStateDriver('box_UUQVMJFNZY')) {
DisableInputsInContainer(Ctrl('UUQVMJFNZY'),true);
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
SetObligatory(Ctrl('HWGWORUQJF'), ! (Empty(w_CODINT2)) || IsObligatoryByStateDriver('PROV2'));
}
function SetDynamicClasses() {
var c;
}
function SetDynamicTooltip() {
var c;
if(c=Ctrl('QSRYXQJCBZ')) c.title=Strtran(AlertErrorMessage('11419545353',w_FLAGFRAZ),'\\n',"\n");
if(c=Ctrl('XVLCUXTZXI')) c.title=Strtran(AlertErrorMessage('1148775685',w_TIPOOPRAP),'\\n',"\n");
if(c=Ctrl('MFRSDQPPEY')) c.title=Strtran(AlertErrorMessage('191062270',w_FLAGLIRE),'\\n',"\n");
if(c=Ctrl('JCKYJRZABA')) c.title=Strtran(AlertErrorMessage('11710831322',w_VALUTA),'\\n',"\n");
if(c=Ctrl('RPHQMPGGQR')) c.title=Strtran(AlertErrorMessage('2070114244',w_FLAGCONT),'\\n',"\n");
if(c=Ctrl('WBHSORBZAV')) c.title=Strtran(AlertErrorMessage('340709450',w_TIPOLEG),'\\n',"\n");
if(c=Ctrl('OBBUSHLGFO')) c.title=Strtran(AlertErrorMessage('10464441821',w_TIPOINT2),'\\n',"\n");
if(c=Ctrl('OJVAARLZEQ')) c.title=Strtran(AlertErrorMessage('11655443642',w_desccauana),'\\n',"\n");
if(c=Ctrl('CKDWHDTZAO')) c.title=Strtran(AlertErrorMessage('10703819256',w_xdesccausin),'\\n',"\n");
}
function Set_DATAOPE(ctrlValue,kmode,e) {
if (Ne(w_DATAOPE,ctrlValue)) {
var ctl = _GetCtl(e,'WAAXEDMKXA');
if (_tracker.goon(ctl,ctrlValue)) {
w_DATAOPE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('WAAXEDMKXA',0);
if (l_bResult) {
l_bResult=Ge(w_DATAREG,w_DATAOPE);
if ( ! (l_bResult)) {
m_nLastError=2;
m_cLastWorkVarErrorMsg='829201110';
m_cLastMsgError=AlertErrorMessage('12128708791');
}
if ( ! (l_bResult)) {
w_DATAOPE=HtW('','D');
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
function Set_MITGDOC(ctrlValue,kmode,e) {
if (Ne(w_MITGDOC,ctrlValue)) {
var ctl = _GetCtl(e,'OXGBDTWKSX');
if (_tracker.goon(ctl,ctrlValue)) {
w_MITGDOC=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('OXGBDTWKSX',0);
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
function Set_CONNESDOC(ctrlValue,kmode,e) {
if (Ne(w_CONNESDOC,ctrlValue)) {
var ctl = _GetCtl(e,'EOXCZYYEBY');
if (_tracker.goon(ctl,ctrlValue)) {
w_CONNESDOC=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('EOXCZYYEBY',0);
if (l_bResult) {
l_bResult=Link_EOXCZYYEBY(kmode);
if ( ! (l_bResult)) {
w_CONNESDOC=HtW('','C');
}
}
l_bResult=l_bResult && _ChkObl('NWEMAAVMTA',0);
if (l_bResult) {
if ( ! (l_bResult)) {
w_CONNESDOC=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',50,0,''));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',50,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_DATAREG(ctrlValue,kmode,e) {
if (Ne(w_DATAREG,ctrlValue)) {
var ctl = _GetCtl(e,'NXYGHZZLCG');
if (_tracker.goon(ctl,ctrlValue)) {
w_DATAREG=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
var l_bWarn = true;
l_bResult=_ChkObl('NXYGHZZLCG',0);
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
function Set_FLAGFRAZ(ctrlValue,kmode,e) {
if (Ne(w_FLAGFRAZ,ctrlValue)) {
var ctl = _GetCtl(e,'QSRYXQJCBZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLAGFRAZ=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QSRYXQJCBZ',0);
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
function Set_TIPOOPRAP(ctrlValue,kmode,e) {
if (Ne(w_TIPOOPRAP,ctrlValue)) {
var ctl = _GetCtl(e,'XVLCUXTZXI');
if (_tracker.goon(ctl,ctrlValue)) {
w_TIPOOPRAP=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XVLCUXTZXI',0);
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
function Set_CODANA(ctrlValue,kmode,e) {
if (Ne(w_CODANA,ctrlValue)) {
var ctl = _GetCtl(e,'EZPCGCABUD');
if (_tracker.goon(ctl,ctrlValue)) {
w_CODANA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('EZPCGCABUD',0);
if (l_bResult) {
l_bResult=Link_EZPCGCABUD(kmode);
if ( ! (Empty(w_CODVOC))) {
Link_BHDZAMJILO(kmode);
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
var ctl = _GetCtl(e,'BHDZAMJILO');
if (_tracker.goon(ctl,ctrlValue)) {
w_CODVOC=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BHDZAMJILO',0);
if (l_bResult) {
l_bResult=Link_BHDZAMJILO(kmode);
if ( ! (l_bResult)) {
w_CODVOC=HtW('','C');
}
}
l_bResult=l_bResult && _ChkObl('SRWWPHPCUB',0);
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
function Set_AMMONT(ctrlValue,kmode,e) {
if (Ne(w_AMMONT,ctrlValue)) {
var ctl = _GetCtl(e,'QTLAIWJTIK');
if (_tracker.goon(ctl,ctrlValue)) {
w_AMMONT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QTLAIWJTIK',0);
if (l_bResult) {
l_bResult=Link_QTLAIWJTIK(kmode);
if ( ! (l_bResult)) {
w_AMMONT=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',5,0,''));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',5,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_appolire(ctrlValue,kmode,e) {
if (Ne(w_appolire,ctrlValue)) {
var ctl = _GetCtl(e,'MFRSDQPPEY');
if (_tracker.goon(ctl,ctrlValue)) {
w_appolire=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MFRSDQPPEY',0);
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
var ctl = _GetCtl(e,'JCKYJRZABA');
if (_tracker.goon(ctl,ctrlValue)) {
w_VALUTA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('JCKYJRZABA',0);
if (l_bResult) {
l_bResult=Link_JCKYJRZABA(kmode);
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
function Set_xTOTLIRE(ctrlValue,kmode,e) {
if (Ne(w_xTOTLIRE,ctrlValue)) {
var ctl = _GetCtl(e,'QOALLRLDKY');
if (_tracker.goon(ctl,ctrlValue)) {
w_xTOTLIRE=ValidNum(ctrlValue,'999999999999.99');
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
var l_bWarn = true;
l_bResult=_ChkObl('QOALLRLDKY',0);
if (l_bResult) {
if (l_bResult && ( ! (arfn_chktotalelire_fraz(w_DATAOPE,w_datpaseuro,w_xTOTLIRE)) && Ne(m_nLastError,-2))) {
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
SPBOUILib.SetInputValue('QOALLRLDKY',function(){return WtH(w_xTOTLIRE,'N',15,2,'999,999,999,999.99')},w_xTOTLIRE);
}
return true;
}
function Set_FLAGCONT(ctrlValue,kmode,e) {
if (Ne(w_FLAGCONT,ctrlValue)) {
var ctl = _GetCtl(e,'RPHQMPGGQR');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLAGCONT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RPHQMPGGQR',0);
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
function Set_xTOTCONT(ctrlValue,kmode,e) {
if (Ne(w_xTOTCONT,ctrlValue)) {
var ctl = _GetCtl(e,'KUMAEYPETV');
if (_tracker.goon(ctl,ctrlValue)) {
w_xTOTCONT=ValidNum(ctrlValue,'999999999999.99');
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('KUMAEYPETV',0);
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
SPBOUILib.SetInputValue('KUMAEYPETV',function(){return WtH(w_xTOTCONT,'N',15,2,'999,999,999,999.99')},w_xTOTCONT);
}
return true;
}
function Set_CAMBIO(ctrlValue,kmode,e) {
if (Ne(w_CAMBIO,ctrlValue)) {
var ctl = _GetCtl(e,'FADDNUEJZJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_CAMBIO=ValidNum(ctrlValue,'9999.9999');
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FADDNUEJZJ',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('FADDNUEJZJ',function(){return WtH(w_CAMBIO,'N',9,4,'9999.9999')},w_CAMBIO);
return l_bResult;
} else {
ctl.value=WtH('','N',9,4,'9999.9999');
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
var ctl = _GetCtl(e,'WBHSORBZAV');
if (_tracker.goon(ctl,ctrlValue)) {
w_TIPOLEG=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('WBHSORBZAV',0);
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
var ctl = _GetCtl(e,'TMYVGJFCXV');
if (_tracker.goon(ctl,ctrlValue)) {
w_PAGASOGOP=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('TMYVGJFCXV',0);
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
var ctl = _GetCtl(e,'TRNDHQYOXC');
if (_tracker.goon(ctl,ctrlValue)) {
w_CONNALTRO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('TRNDHQYOXC',0);
if (l_bResult) {
l_bResult=Link_TRNDHQYOXC(kmode);
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
var ctl = _GetCtl(e,'KZXSBEEORE');
if (_tracker.goon(ctl,ctrlValue)) {
w_C_RAG=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('KZXSBEEORE',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('KZXSBEEORE',function(){return WtH(w_C_RAG,'C',70,0,'@!')},w_C_RAG);
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
var ctl = _GetCtl(e,'SDKWKBVOVR');
if (_tracker.goon(ctl,ctrlValue)) {
w_C_CTA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SDKWKBVOVR',0);
if (l_bResult) {
l_bResult=Link_SDKWKBVOVR(kmode);
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
var ctl = _GetCtl(e,'UBEYBTICRP');
if (_tracker.goon(ctl,ctrlValue)) {
w_C_PRV=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UBEYBTICRP',0);
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
var ctl = _GetCtl(e,'KWJVJHCAHT');
if (_tracker.goon(ctl,ctrlValue)) {
w_C_CAP=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('KWJVJHCAHT',0);
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
var ctl = _GetCtl(e,'IXODLSKCSA');
if (_tracker.goon(ctl,ctrlValue)) {
w_C_CAB=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('IXODLSKCSA',0);
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
var ctl = _GetCtl(e,'LVMUPCVGIQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_C_IND=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('LVMUPCVGIQ',0);
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
var ctl = _GetCtl(e,'QASGTWMXYC');
if (_tracker.goon(ctl,ctrlValue)) {
w_C_STA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QASGTWMXYC',0);
if (l_bResult) {
l_bResult=Link_QASGTWMXYC(kmode);
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
var ctl = _GetCtl(e,'OBBUSHLGFO');
if (_tracker.goon(ctl,ctrlValue)) {
w_TIPOINT2=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('OBBUSHLGFO',0);
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
var ctl = _GetCtl(e,'OGZBJVOVLN');
if (_tracker.goon(ctl,ctrlValue)) {
w_CODINT2=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('OGZBJVOVLN',0);
if (l_bResult) {
l_bResult=Link_OGZBJVOVLN(kmode);
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
function Set_DESCINTER(ctrlValue,kmode,e) {
if (Ne(w_DESCINTER,ctrlValue)) {
var ctl = _GetCtl(e,'TYCTKKPTQQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_DESCINTER=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('TYCTKKPTQQ',0);
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
function Set_PAESE(ctrlValue,kmode,e) {
if (Ne(w_PAESE,ctrlValue)) {
var ctl = _GetCtl(e,'MUTRCJYNJT');
if (_tracker.goon(ctl,ctrlValue)) {
w_PAESE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MUTRCJYNJT',0);
if (l_bResult) {
l_bResult=Link_MUTRCJYNJT(kmode);
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
var ctl = _GetCtl(e,'YBNJCVPDUM');
if (_tracker.goon(ctl,ctrlValue)) {
w_C_RAPPORTO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YBNJCVPDUM',0);
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
function Set_CODCAB2(ctrlValue,kmode,e) {
if (Ne(w_CODCAB2,ctrlValue)) {
var ctl = _GetCtl(e,'CRVLITCYRD');
if (_tracker.goon(ctl,ctrlValue)) {
w_CODCAB2=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CRVLITCYRD',0);
if (l_bResult) {
l_bResult=Link_CRVLITCYRD(kmode);
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
function Set_PROV2(ctrlValue,kmode,e) {
if (Ne(w_PROV2,ctrlValue)) {
var ctl = _GetCtl(e,'HWGWORUQJF');
if (_tracker.goon(ctl,ctrlValue)) {
w_PROV2=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HWGWORUQJF',0);
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
function Set_DESC2(ctrlValue,kmode,e) {
if (Ne(w_DESC2,ctrlValue)) {
var ctl = _GetCtl(e,'KDONRVZYMP');
if (_tracker.goon(ctl,ctrlValue)) {
w_DESC2=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('KDONRVZYMP',0);
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
function Set_ZCPARTE(ctrlValue,kmode,e) {
if (Ne(w_ZCPARTE,ctrlValue)) {
var ctl = _GetCtl(e,'RGKPHWRBRT');
if (_tracker.goon(ctl,ctrlValue)) {
w_ZCPARTE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RGKPHWRBRT',0);
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
function Set_IDBASE(ctrlValue,kmode,e) {
if (Ne(w_IDBASE,ctrlValue)) {
var ctl = _GetCtl(e,'NJDOYSOENB');
if (_tracker.goon(ctl,ctrlValue)) {
w_IDBASE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NJDOYSOENB',0);
l_bResult=l_bResult && _ChkObl('NHERHRZTFP',0);
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
function Set_DURAT(ctrlValue,kmode,e) {
if (Ne(w_DURAT,ctrlValue)) {
var ctl = _GetCtl(e,'RIGLNJERGO');
if (_tracker.goon(ctl,ctrlValue)) {
w_DURAT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RIGLNJERGO',0);
if (l_bResult) {
l_bResult=Link_RIGLNJERGO(kmode);
if ( ! (l_bResult)) {
w_DURAT=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',5,0,''));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',5,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_RIMP(ctrlValue,kmode,e) {
if (Ne(w_RIMP,ctrlValue)) {
var ctl = _GetCtl(e,'IAFRSBROAJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_RIMP=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('IAFRSBROAJ',0);
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
function Set_CODDIPE(ctrlValue,kmode,e) {
if (Ne(w_CODDIPE,ctrlValue)) {
var ctl = _GetCtl(e,'SDNFDOJDLP');
if (_tracker.goon(ctl,ctrlValue)) {
w_CODDIPE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SDNFDOJDLP',0);
if (l_bResult) {
l_bResult=Link_SDNFDOJDLP(kmode);
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
function Set_RTIPO(ctrlValue,kmode,e) {
if (Ne(w_RTIPO,ctrlValue)) {
var ctl = _GetCtl(e,'NKOMZBCBBR');
if (_tracker.goon(ctl,ctrlValue)) {
w_RTIPO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NKOMZBCBBR',0);
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
function Set_RRAGIO(ctrlValue,kmode,e) {
if (Ne(w_RRAGIO,ctrlValue)) {
var ctl = _GetCtl(e,'DPWFRQJRKQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_RRAGIO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('DPWFRQJRKQ',0);
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
function Set_RCOMP(ctrlValue,kmode,e) {
if (Ne(w_RCOMP,ctrlValue)) {
var ctl = _GetCtl(e,'SSXPWXCJEG');
if (_tracker.goon(ctl,ctrlValue)) {
w_RCOMP=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SSXPWXCJEG',0);
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
function Set_RAREA(ctrlValue,kmode,e) {
if (Ne(w_RAREA,ctrlValue)) {
var ctl = _GetCtl(e,'OVLHZLTRLW');
if (_tracker.goon(ctl,ctrlValue)) {
w_RAREA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('OVLHZLTRLW',0);
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
function Set_TIPO(ctrlValue,kmode,e) {
if (Ne(w_TIPO,ctrlValue)) {
var ctl = _GetCtl(e,'NQCYKQCVPJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_TIPO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NQCYKQCVPJ',0);
if (l_bResult) {
l_bResult=Link_NQCYKQCVPJ(kmode);
if ( ! (l_bResult)) {
w_TIPO=HtW('','C');
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
function Set_RAGIO(ctrlValue,kmode,e) {
if (Ne(w_RAGIO,ctrlValue)) {
var ctl = _GetCtl(e,'MTCGTVJYAU');
if (_tracker.goon(ctl,ctrlValue)) {
w_RAGIO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MTCGTVJYAU',0);
if (l_bResult) {
l_bResult=Link_MTCGTVJYAU(kmode);
if ( ! (l_bResult)) {
w_RAGIO=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',5,0,''));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',5,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_MODSVOL(ctrlValue,kmode,e) {
if (Ne(w_MODSVOL,ctrlValue)) {
var ctl = _GetCtl(e,'WZGVCTOIUK');
if (_tracker.goon(ctl,ctrlValue)) {
w_MODSVOL=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('WZGVCTOIUK',0);
if (l_bResult) {
l_bResult=Link_WZGVCTOIUK(kmode);
if ( ! (l_bResult)) {
w_MODSVOL=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',5,0,''));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',5,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_AREAGEO(ctrlValue,kmode,e) {
if (Ne(w_AREAGEO,ctrlValue)) {
var ctl = _GetCtl(e,'RTGTOVGSAH');
if (_tracker.goon(ctl,ctrlValue)) {
w_AREAGEO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RTGTOVGSAH',0);
if (l_bResult) {
l_bResult=Link_RTGTOVGSAH(kmode);
if ( ! (l_bResult)) {
w_AREAGEO=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',5,0,''));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',5,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_SCOPO(ctrlValue,kmode,e) {
if (Ne(w_SCOPO,ctrlValue)) {
var ctl = _GetCtl(e,'GPFTVWCTPC');
if (_tracker.goon(ctl,ctrlValue)) {
w_SCOPO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('GPFTVWCTPC',0);
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
function Set_NATURA(ctrlValue,kmode,e) {
if (Ne(w_NATURA,ctrlValue)) {
var ctl = _GetCtl(e,'YOYXXFWJYJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_NATURA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YOYXXFWJYJ',0);
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
function Set_INFORM(ctrlValue,kmode,e) {
if (Ne(w_INFORM,ctrlValue)) {
var ctl = _GetCtl(e,'MWCNUZJZYJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_INFORM=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MWCNUZJZYJ',0);
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
function Set_RESPINS(ctrlValue,kmode,e) {
if (Ne(w_RESPINS,ctrlValue)) {
var ctl = _GetCtl(e,'ZSJIVPTGDO');
if (_tracker.goon(ctl,ctrlValue)) {
w_RESPINS=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ZSJIVPTGDO',0);
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
function Set_NOPROT(ctrlValue,kmode,e) {
if (Ne(w_NOPROT,ctrlValue)) {
var ctl = _GetCtl(e,'BOISLVXVWN');
if (_tracker.goon(ctl,ctrlValue)) {
w_NOPROT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BOISLVXVWN',0);
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
function Set_RFREQ(ctrlValue,kmode,e) {
if (Ne(w_RFREQ,ctrlValue)) {
var ctl = _GetCtl(e,'HJYPHRYRFX');
if (_tracker.goon(ctl,ctrlValue)) {
w_RFREQ=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HJYPHRYRFX',0);
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
function Set_OPERAG(ctrlValue,kmode,e) {
if (Ne(w_OPERAG,ctrlValue)) {
var ctl = _GetCtl(e,'KZPPWSIAXL');
if (_tracker.goon(ctl,ctrlValue)) {
w_OPERAG=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('KZPPWSIAXL',0);
if (l_bResult) {
l_bResult=Link_KZPPWSIAXL(kmode);
if ( ! (l_bResult)) {
w_OPERAG=HtW('','C');
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
function Set_MITIG(ctrlValue,kmode,e) {
if (Ne(w_MITIG,ctrlValue)) {
var ctl = _GetCtl(e,'DOXBACRWUU');
if (_tracker.goon(ctl,ctrlValue)) {
w_MITIG=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('DOXBACRWUU',0);
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
function Calculate() {
var l_bTmpRes;
var l_bResult = true;
m_bCalculating=true;
w_CDATOPE=DateToChar(w_DATAOPE);
if ((Ne(o_COLLEG,w_COLLEG))) {
l_bTmpRes=Link_FCUPIYMFZB(null);
}
w_FLAGLIRE=arfn_calcflaglire(w_DATAOPE,w_appolire,w_datpaseuro);
if ((Ne(o_FLAGLIRE,w_FLAGLIRE))) {
w_appolire=(Eq(w_FLAGLIRE,'1') || Eq(w_FLAGLIRE,'7')?'L':(Eq(w_FLAGLIRE,'3') || Eq(w_FLAGLIRE,'5') || Empty(w_FLAGLIRE)?'E':'V'));
}
if ((Ne(o_CDATOPE,w_CDATOPE)) || (Ne(o_filtro,w_filtro))) {
RenderDynamicCombo('WBHSORBZAV');
}
if ((Ne(o_C_CTA,w_C_CTA))) {
l_bTmpRes=Link_QASGTWMXYC(null);
}
if ((Ne(o_CODINT2,w_CODINT2))) {
l_bTmpRes=Link_MUTRCJYNJT(null);
}
if ((Ne(o_CODINT2,w_CODINT2))) {
l_bTmpRes=Link_CRVLITCYRD(null);
}
UpdateAutonumber('IDBASE');
UpdateAutonumber('NUMPROG');
w_CODINTER=w_gIntemediario;
l_bTmpRes=Link_NNOUMHTLXJ(null);
w_tipope='1';
if ((Ne(o_CODVOC,w_CODVOC))) {
l_bTmpRes=Link_SRWWPHPCUB(null);
}
UpdateAutonumber('IDBASE');
w_TIPOINF='1';
w_IDEREG=DateToChar(w_DATAOPE)+w_NUMPROG+LibreriaMit.StatoReg('FRAZIOBO',w_STATOREG);
w_OPRAP='1';
if ((Ne(o_appolire,w_appolire)) || (Ne(o_DATAOPE,w_DATAOPE))) {
Calculation_NAKGPBRIRV();
}
if ((Ne(o_FLAGCONT,w_FLAGCONT))) {
Calculation_EBRTUDXQTQ();
}
UpdateAutonumber('PRGIMPFRZ');
w_dataoggi=SystemDate();
if ((Ne(o_appolire,w_appolire))) {
Calculation_TBLTXFHXJY();
}
if ((Ne(o_CONNESCLI,w_CONNESCLI)) || (Ne(o_RAPPORTO,w_RAPPORTO))) {
Calculation_QCJQRCFUFB();
}
w_CDATAOPE=DateToChar(w_DATAOPE);
if ((Ne(o_CODINTER,w_CODINTER)) || (Ne(o_CODDIPE,w_CODDIPE))) {
Calculation_WKUMXNRIRT();
}
w_CDATREG=DateToChar(w_DATAREG);
if ((Ne(o_CONNESBEN,w_CONNESBEN))) {
Calculation_LNKPNNFRDI();
}
if ((Ne(o_DATAREG,w_DATAREG))) {
w_apporeg=DateToChar(w_DATAREG);
}
w_ANNOOPE=Year(w_DATAOPE);
w_IDEREG=DateToChar(w_DATAOPE)+w_NUMPROG+LibreriaMit.StatoReg('OPERAZBO',w_STATOREG);
w_STATOREG='0';
LibJavascript.forEachItem(m_FoundlingCopyWorkVar,i_body_1)
function i_body_1(child){
child();
}
// * --- Area Manuale = UI - Calculate
// * --- armt_storfra
if ((Ne(o_DATAOPE,w_DATAOPE)) || (Ne(o_DATAREG,w_DATAREG))) {
  if(w_gChkDate=='B' && m_cFunction=='new') {
    Ctrl('NXYGHZZLCG').value=WtH(SystemDate(),'D',8,0,TranslatePicture('DDMMYYYY'));    
  }
}
// * --- Fine Area Manuale
UpdateAutonumber('');
m_bCalculating=false;
}
function Calculation_NAKGPBRIRV() {
w_xTOTLIRE=(Ge(w_DATAOPE,CharToDate('20020101')) || Le(w_datpaseuro,w_DATAOPE)?w_TOTLIRE/100:w_TOTLIRE);
w_xTOTCONT=(Ge(w_DATAOPE,CharToDate('20020101')) || Le(w_datpaseuro,w_DATAOPE)?w_TOTCONT/100:w_TOTCONT);
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
function Calculation_LNKPNNFRDI() {
arrt_val_benefic([])
}
function SaveDependsOn() {
o_DATAOPE=w_DATAOPE;
o_CDATOPE=w_CDATOPE;
o_filtro=w_filtro;
o_DATAREG=w_DATAREG;
o_COLLEG=w_COLLEG;
o_CODVOC=w_CODVOC;
o_FLAGLIRE=w_FLAGLIRE;
o_appolire=w_appolire;
o_FLAGCONT=w_FLAGCONT;
o_RAPPORTO=w_RAPPORTO;
o_CONNESCLI=w_CONNESCLI;
o_CONNESBEN=w_CONNESBEN;
o_C_CTA=w_C_CTA;
o_CODINT2=w_CODINT2;
o_CODINTER=w_CODINTER;
o_CODDIPE=w_CODDIPE;
}
function SaveLabelDependsOn() {
}
function Link_FCUPIYMFZB(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_COLLEG);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('NUMPROG',w_COLLEG,11,0);
l_Appl.SetFields('NUMPROG');
l_Appl.SetTypes('C');
l_Appl.LinkTable('wraziobo');
l_Appl.SetID('FCUPIYMFZB');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_COLLEG=l_Appl.GetStringValue('NUMPROG',11,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_FCUPIYMFZB_Blank();
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
function Link_FCUPIYMFZB_Blank() {
w_COLLEG='';
}
function LOpt_FCUPIYMFZB() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('wraziobo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('NUMPROG','C'));
l_oWv.setValue('LinkedField',WtA('NUMPROG','C'));
l_oWv.setValue('UID',WtA('FCUPIYMFZB','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['FCUPIYMFZB'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('12057236694'),'C'));
return l_oWv;
}
function Link_EZPCGCABUD(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CODANA);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODCAU',w_CODANA,4,0);
l_Appl.SetFields('CODCAU');
l_Appl.SetTypes('C');
l_Appl.LinkTable('tbcauana');
l_Appl.SetID('EZPCGCABUD');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CODANA=l_Appl.GetStringValue('CODCAU',4,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_EZPCGCABUD_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_EZPCGCABUD';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_EZPCGCABUD();
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
function Link_EZPCGCABUD_Blank() {
w_CODANA='';
}
function LOpt_EZPCGCABUD() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcauana','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODCAU','C'));
l_oWv.setValue('LinkedField',WtA('CODCAU','C'));
l_oWv.setValue('UID',WtA('EZPCGCABUD','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['EZPCGCABUD'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('282647084'),'C'));
l_oWv.setValue('ConfigName',WtA('cauinter','C'));
return l_oWv;
}
function Link_BHDZAMJILO(kmode) {
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
l_Appl.SetID('BHDZAMJILO');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CODVOC=l_Appl.GetStringValue('CAUSINT',2,0);
w_SEGNO=l_Appl.GetStringValue('SEGNO',1,0);
w_desccauana=l_Appl.GetStringValue('DESCRI',165,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_BHDZAMJILO_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_BHDZAMJILO';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_BHDZAMJILO();
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
function Link_BHDZAMJILO_Blank() {
w_CODVOC='';
w_SEGNO='';
w_desccauana='';
}
function LOpt_BHDZAMJILO() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcauana','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODCAU,CAUSINT','C'));
l_oWv.setValue('LinkedField',WtA('CAUSINT','C'));
l_oWv.setValue('UID',WtA('BHDZAMJILO','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['BHDZAMJILO'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('282420974'),'C'));
return l_oWv;
}
function Link_JCKYJRZABA(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_VALUTA);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODVAL',w_VALUTA,3,0);
l_Appl.SetFields('CODVAL,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbvalute');
l_Appl.SetID('JCKYJRZABA');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_VALUTA=l_Appl.GetStringValue('CODVAL',3,0);
w_descdiv=l_Appl.GetStringValue('DESCRI',30,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_JCKYJRZABA_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_JCKYJRZABA';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_JCKYJRZABA();
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
function Link_JCKYJRZABA_Blank() {
w_VALUTA='';
w_descdiv='';
}
function LOpt_JCKYJRZABA() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbvalute','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODVAL','C'));
l_oWv.setValue('LinkedField',WtA('CODVAL','C'));
l_oWv.setValue('UID',WtA('JCKYJRZABA','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['JCKYJRZABA'][1],'C'));
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
l_Appl.LinkTable('anarapbo');
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
l_oWv.setValue('Table',WtA('anarapbo','C'));
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
l_Appl.SetFields('CONNES,RAGSOC,CODFISC,DATAVALI,DATARILASC');
l_Appl.SetTypes('C,C,C,D,D');
l_Appl.LinkTable('personbo');
l_Appl.SetID('QBLXDBODXR');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CONNESCLI=l_Appl.GetStringValue('CONNES',16,0);
w_xragsocper=l_Appl.GetStringValue('RAGSOC',70,0);
w_xcodfisc=l_Appl.GetStringValue('CODFISC',16,0);
w_DATAVALI=l_Appl.GetDateValue('DATAVALI',8,0);
w_DATAVALI=DateFromApplet(w_DATAVALI);
w_DATARILASC=l_Appl.GetDateValue('DATARILASC',8,0);
w_DATARILASC=DateFromApplet(w_DATARILASC);
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
if (l_bResult &&  ! (Empty(w_CONNESCLI) && l_bEmp)) {
l_bResult=arfn_chkdatdoc(w_CONNESCLI,w_DATAOPE);
if ( ! (l_bResult)) {
Link_QBLXDBODXR_Blank();
}
}
if ( ! (l_bResult)) {
m_nLastError=3;
m_cLastWorkVarErrorMsg='';
if (Lt(l_nRec,0)) {
m_cLastMsgError=Translate('MSG_CONNECT_SERVER');
} else {
m_cLastMsgError=AlertErrorMessage('11525797640');
}
}
}
return l_bResult;
}
function Link_QBLXDBODXR_Blank() {
w_CONNESCLI='';
w_xragsocper='';
w_xcodfisc='';
w_DATAVALI=NullDate();
w_DATARILASC=NullDate();
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
if (l_bResult &&  ! (Empty(w_CONNESOPER) && l_bEmp)) {
l_bResult=arfn_chkdatdoc(w_CONNESOPER,w_DATAOPE);
if ( ! (l_bResult)) {
Link_TCOTJNZLGM_Blank();
}
}
if ( ! (l_bResult)) {
m_nLastError=3;
m_cLastWorkVarErrorMsg='';
if (Lt(l_nRec,0)) {
m_cLastMsgError=Translate('MSG_CONNECT_SERVER');
} else {
m_cLastMsgError=AlertErrorMessage('11525797640');
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
l_Appl.SetFields('CONNES,RAGSOC');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('personbo');
l_Appl.SetID('ULVCBLFVEU');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CONNESBEN=l_Appl.GetStringValue('CONNES',16,0);
w_xragsocben=l_Appl.GetStringValue('RAGSOC',70,0);
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
function Link_TRNDHQYOXC(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CONNALTRO);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CONNES',w_CONNALTRO,16,0);
l_Appl.SetFields('CONNES,RAGSOC');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('personbo');
l_Appl.SetID('TRNDHQYOXC');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CONNALTRO=l_Appl.GetStringValue('CONNES',16,0);
w_xragsocalt=l_Appl.GetStringValue('RAGSOC',70,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_TRNDHQYOXC_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_TRNDHQYOXC';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_TRNDHQYOXC();
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
if (l_bResult &&  ! (Empty(w_CONNALTRO) && l_bEmp)) {
l_bResult=arfn_chkdatdoc(w_CONNALTRO,w_DATAOPE);
if ( ! (l_bResult)) {
Link_TRNDHQYOXC_Blank();
}
}
if ( ! (l_bResult)) {
m_nLastError=3;
m_cLastWorkVarErrorMsg='';
if (Lt(l_nRec,0)) {
m_cLastMsgError=Translate('MSG_CONNECT_SERVER');
} else {
m_cLastMsgError=AlertErrorMessage('11525797640');
}
}
}
return l_bResult;
}
function Link_TRNDHQYOXC_Blank() {
w_CONNALTRO='';
w_xragsocalt='';
}
function LOpt_TRNDHQYOXC() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('personbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CONNES','C'));
l_oWv.setValue('LinkedField',WtA('CONNES','C'));
l_oWv.setValue('UID',WtA('TRNDHQYOXC','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['TRNDHQYOXC'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('1890893827'),'C'));
return l_oWv;
}
function Link_SDKWKBVOVR(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_C_CTA);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CITTA',w_C_CTA,30,0);
l_Appl.SetFields('CITTA,CAB,PROV,PKTBSTATI,CAP');
l_Appl.SetTypes('C,C,C,C,C');
l_Appl.LinkTable('tbcitta');
l_Appl.SetID('SDKWKBVOVR');
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
Link_SDKWKBVOVR_Blank();
l_bResult=true;
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_SDKWKBVOVR';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_SDKWKBVOVR();
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
function Link_SDKWKBVOVR_Blank() {
w_C_CAB='';
w_C_PRV='';
w_C_STA='';
w_C_CAP='';
}
function LOpt_SDKWKBVOVR() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcitta','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CITTA','C'));
l_oWv.setValue('LinkedField',WtA('CITTA','C'));
l_oWv.setValue('UID',WtA('SDKWKBVOVR','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['SDKWKBVOVR'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('15186643'),'C'));
return l_oWv;
}
function Link_QASGTWMXYC(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_C_STA);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODSTA',w_C_STA,3,0);
l_Appl.SetFields('CODSTA,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbstati');
l_Appl.SetID('QASGTWMXYC');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_C_STA=l_Appl.GetStringValue('CODSTA',3,0);
w_dessta=l_Appl.GetStringValue('DESCRI',40,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_QASGTWMXYC_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_QASGTWMXYC';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_QASGTWMXYC();
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
function Link_QASGTWMXYC_Blank() {
w_C_STA='';
w_dessta='';
}
function LOpt_QASGTWMXYC() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstati','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODSTA','C'));
l_oWv.setValue('LinkedField',WtA('CODSTA','C'));
l_oWv.setValue('UID',WtA('QASGTWMXYC','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['QASGTWMXYC'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('7383187'),'C'));
return l_oWv;
}
function Link_OGZBJVOVLN(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CODINT2);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODINTER',w_CODINT2,11,0);
l_Appl.SetFields('CODINTER,RAGSOC,CODCAB,PROVINCIA,PAESE,TIPINTER');
l_Appl.SetTypes('C,C,C,C,C,C');
l_Appl.LinkTable('inter2bo');
l_Appl.SetID('OGZBJVOVLN');
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
Link_OGZBJVOVLN_Blank();
l_bResult=true;
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_OGZBJVOVLN';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_OGZBJVOVLN();
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
function Link_OGZBJVOVLN_Blank() {
w_DESCINTER='';
w_CODCAB2='';
w_PROV2='';
w_PAESE='';
w_TIPOINT2='';
}
function LOpt_OGZBJVOVLN() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('inter2bo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODINTER','C'));
l_oWv.setValue('LinkedField',WtA('CODINTER','C'));
l_oWv.setValue('UID',WtA('OGZBJVOVLN','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['OGZBJVOVLN'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('11424168249'),'C'));
return l_oWv;
}
function Link_MUTRCJYNJT(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_PAESE);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODSTA',w_PAESE,3,0);
l_Appl.SetFields('CODSTA,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbstati');
l_Appl.SetID('MUTRCJYNJT');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_PAESE=l_Appl.GetStringValue('CODSTA',3,0);
w_xdescpaese2=l_Appl.GetStringValue('DESCRI',30,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_MUTRCJYNJT_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_MUTRCJYNJT';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_MUTRCJYNJT();
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
function Link_MUTRCJYNJT_Blank() {
w_PAESE='';
w_xdescpaese2='';
}
function LOpt_MUTRCJYNJT() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstati','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODSTA','C'));
l_oWv.setValue('LinkedField',WtA('CODSTA','C'));
l_oWv.setValue('UID',WtA('MUTRCJYNJT','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['MUTRCJYNJT'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('7383187'),'C'));
return l_oWv;
}
function Link_CRVLITCYRD(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CODCAB2);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CAB',w_CODCAB2,6,0);
l_Appl.SetFields('CAB,CITTA,PROV');
l_Appl.SetTypes('C,C,C');
l_Appl.LinkTable('tbcitta');
l_Appl.SetID('CRVLITCYRD');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CODCAB2=l_Appl.GetStringValue('CAB',6,0);
w_DESC2=l_Appl.GetStringValue('CITTA',30,0);
w_PROV2=l_Appl.GetStringValue('PROV',2,0);
w_xdciticon=l_Appl.GetStringValue('CITTA',40,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_CRVLITCYRD_Blank();
l_bResult=true;
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_CRVLITCYRD';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_CRVLITCYRD();
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
function Link_CRVLITCYRD_Blank() {
w_DESC2='';
w_PROV2='';
w_xdciticon='';
}
function LOpt_CRVLITCYRD() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcitta','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CAB','C'));
l_oWv.setValue('LinkedField',WtA('CAB','C'));
l_oWv.setValue('UID',WtA('CRVLITCYRD','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['CRVLITCYRD'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('15186643'),'C'));
return l_oWv;
}
function Link_NNOUMHTLXJ(kmode) {
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
l_Appl.SetID('NNOUMHTLXJ');
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
Link_NNOUMHTLXJ_Blank();
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
function Link_NNOUMHTLXJ_Blank() {
w_CODINTER='';
w_datpaseuro=NullDate();
w_CABINT='';
w_PROVINT='';
w_CITINT='';
}
function LOpt_NNOUMHTLXJ() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('intermbo','C'));
l_oWv.setValue('Linkzoomprg',WtA('armt_intermbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODINTER','C'));
l_oWv.setValue('LinkedField',WtA('CODINTER','C'));
l_oWv.setValue('UID',WtA('NNOUMHTLXJ','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['NNOUMHTLXJ'][1],'C'));
return l_oWv;
}
function Link_SDNFDOJDLP(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CODDIPE);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODDIP',w_CODDIPE,6,0);
l_Appl.SetFields('CODDIP,DESCRIZ,DESCCIT,PROVINCIA,CAB');
l_Appl.SetTypes('C,C,C,C,C');
l_Appl.LinkTable('anadip');
l_Appl.SetID('SDNFDOJDLP');
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
Link_SDNFDOJDLP_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_SDNFDOJDLP';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_SDNFDOJDLP();
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
function Link_SDNFDOJDLP_Blank() {
w_CODDIPE='';
w_xDescDipe='';
w_CITDIP='';
w_PROVDIP='';
w_CABDIP='';
}
function LOpt_SDNFDOJDLP() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('anadip','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODDIP','C'));
l_oWv.setValue('LinkedField',WtA('CODDIP','C'));
l_oWv.setValue('UID',WtA('SDNFDOJDLP','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['SDNFDOJDLP'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('1270140318'),'C'));
return l_oWv;
}
function Link_SRWWPHPCUB(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CODVOC);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODVOC',w_CODVOC,2,0);
l_Appl.SetFields('CODVOC,DESCRIZ');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbcausin');
l_Appl.SetID('SRWWPHPCUB');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CODVOC=l_Appl.GetStringValue('CODVOC',2,0);
w_xdesccausin=l_Appl.GetStringValue('DESCRIZ',165,0);
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
w_xdesccausin='';
}
function LOpt_SRWWPHPCUB() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcausin','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODVOC','C'));
l_oWv.setValue('LinkedField',WtA('CODVOC','C'));
l_oWv.setValue('UID',WtA('SRWWPHPCUB','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['SRWWPHPCUB'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('282420974'),'C'));
return l_oWv;
}
function Link_KZPPWSIAXL(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_OPERAG);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODICE',w_OPERAG,3,0);
l_Appl.SetFields('CODICE,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbtipope');
l_Appl.SetID('KZPPWSIAXL');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_OPERAG=l_Appl.GetStringValue('CODICE',3,0);
w_xdescopeage=l_Appl.GetStringValue('DESCRI',254,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_KZPPWSIAXL_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_KZPPWSIAXL';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_KZPPWSIAXL();
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
function Link_KZPPWSIAXL_Blank() {
w_OPERAG='';
w_xdescopeage='';
}
function LOpt_KZPPWSIAXL() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbtipope','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODICE','C'));
l_oWv.setValue('LinkedField',WtA('CODICE','C'));
l_oWv.setValue('UID',WtA('KZPPWSIAXL','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['KZPPWSIAXL'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('103243324'),'C'));
return l_oWv;
}
function Link_RTGTOVGSAH(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_AREAGEO);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODICE',w_AREAGEO,5,0);
l_Appl.SetFields('CODICE,DESCRI,RISCHIO');
l_Appl.SetTypes('C,C,N');
l_Appl.LinkTable('tbareegeog');
l_Appl.SetID('RTGTOVGSAH');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_AREAGEO=l_Appl.GetStringValue('CODICE',5,0);
w_xdescareag=l_Appl.GetStringValue('DESCRI',50,0);
w_RAREA=l_Appl.GetDoubleValue('RISCHIO',3,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_RTGTOVGSAH_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_RTGTOVGSAH';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_RTGTOVGSAH();
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
function Link_RTGTOVGSAH_Blank() {
w_AREAGEO='';
w_xdescareag='';
w_RAREA=0;
}
function LOpt_RTGTOVGSAH() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbareegeog','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODICE','C'));
l_oWv.setValue('LinkedField',WtA('CODICE','C'));
l_oWv.setValue('UID',WtA('RTGTOVGSAH','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['RTGTOVGSAH'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('11053408024'),'C'));
return l_oWv;
}
function Link_WZGVCTOIUK(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_MODSVOL);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODICE',w_MODSVOL,5,0);
l_Appl.SetFields('CODICE,DESCRI,RISCHIO');
l_Appl.SetTypes('C,C,N');
l_Appl.LinkTable('tbsvolgim');
l_Appl.SetID('WZGVCTOIUK');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_MODSVOL=l_Appl.GetStringValue('CODICE',5,0);
w_xdescmodsvo=l_Appl.GetStringValue('DESCRI',200,0);
w_RCOMP=l_Appl.GetDoubleValue('RISCHIO',3,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_WZGVCTOIUK_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_WZGVCTOIUK';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_WZGVCTOIUK();
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
function Link_WZGVCTOIUK_Blank() {
w_MODSVOL='';
w_xdescmodsvo='';
w_RCOMP=0;
}
function LOpt_WZGVCTOIUK() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbsvolgim','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODICE','C'));
l_oWv.setValue('LinkedField',WtA('CODICE','C'));
l_oWv.setValue('UID',WtA('WZGVCTOIUK','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['WZGVCTOIUK'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('11158852142'),'C'));
return l_oWv;
}
function Link_MTCGTVJYAU(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_RAGIO);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODICE',w_RAGIO,5,0);
l_Appl.SetFields('CODICE,DESCRI,RISCHIO');
l_Appl.SetTypes('C,C,N');
l_Appl.LinkTable('tbplauso');
l_Appl.SetID('MTCGTVJYAU');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_RAGIO=l_Appl.GetStringValue('CODICE',5,0);
w_xdescplauso=l_Appl.GetStringValue('DESCRI',200,0);
w_RRAGIO=l_Appl.GetDoubleValue('RISCHIO',3,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_MTCGTVJYAU_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_MTCGTVJYAU';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_MTCGTVJYAU();
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
function Link_MTCGTVJYAU_Blank() {
w_RAGIO='';
w_xdescplauso='';
w_RRAGIO=0;
}
function LOpt_MTCGTVJYAU() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbplauso','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODICE','C'));
l_oWv.setValue('LinkedField',WtA('CODICE','C'));
l_oWv.setValue('UID',WtA('MTCGTVJYAU','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['MTCGTVJYAU'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('955814582'),'C'));
return l_oWv;
}
function Link_NQCYKQCVPJ(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_TIPO);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODICE',w_TIPO,3,0);
l_Appl.SetFields('CODICE,DESCRI,RISCHIO');
l_Appl.SetTypes('C,C,N');
l_Appl.LinkTable('tbtiporisc');
l_Appl.SetID('NQCYKQCVPJ');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_TIPO=l_Appl.GetStringValue('CODICE',3,0);
w_xdesctipor=l_Appl.GetStringValue('DESCRI',100,0);
w_RTIPO=l_Appl.GetDoubleValue('RISCHIO',3,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_NQCYKQCVPJ_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_NQCYKQCVPJ';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_NQCYKQCVPJ();
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
function Link_NQCYKQCVPJ_Blank() {
w_TIPO='';
w_xdesctipor='';
w_RTIPO=0;
}
function LOpt_NQCYKQCVPJ() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbtiporisc','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODICE','C'));
l_oWv.setValue('LinkedField',WtA('CODICE','C'));
l_oWv.setValue('UID',WtA('NQCYKQCVPJ','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['NQCYKQCVPJ'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('10049460300'),'C'));
return l_oWv;
}
function Link_RIGLNJERGO(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_DURAT);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODICE',w_DURAT,5,0);
l_Appl.SetFields('CODICE,DESCRI,RISCHIO');
l_Appl.SetTypes('C,C,N');
l_Appl.LinkTable('tbdurata');
l_Appl.SetID('RIGLNJERGO');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_DURAT=l_Appl.GetStringValue('CODICE',5,0);
w_xdescfreq=l_Appl.GetStringValue('DESCRI',200,0);
w_RFREQ=l_Appl.GetDoubleValue('RISCHIO',3,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_RIGLNJERGO_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_RIGLNJERGO';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_RIGLNJERGO();
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
function Link_RIGLNJERGO_Blank() {
w_DURAT='';
w_xdescfreq='';
w_RFREQ=0;
}
function LOpt_RIGLNJERGO() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbdurata','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODICE','C'));
l_oWv.setValue('LinkedField',WtA('CODICE','C'));
l_oWv.setValue('UID',WtA('RIGLNJERGO','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['RIGLNJERGO'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('492802848'),'C'));
return l_oWv;
}
function Link_QTLAIWJTIK(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_AMMONT);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODICE',w_AMMONT,5,0);
l_Appl.SetFields('CODICE,DESCRI,RISCHIO');
l_Appl.SetTypes('C,C,N');
l_Appl.LinkTable('tbimporto');
l_Appl.SetID('QTLAIWJTIK');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_AMMONT=l_Appl.GetStringValue('CODICE',5,0);
w_xdescammo=l_Appl.GetStringValue('DESCRI',200,0);
w_RIMP=l_Appl.GetDoubleValue('RISCHIO',3,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_QTLAIWJTIK_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_QTLAIWJTIK';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_QTLAIWJTIK();
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
function Link_QTLAIWJTIK_Blank() {
w_AMMONT='';
w_xdescammo='';
w_RIMP=0;
}
function LOpt_QTLAIWJTIK() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbimporto','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODICE','C'));
l_oWv.setValue('LinkedField',WtA('CODICE','C'));
l_oWv.setValue('UID',WtA('QTLAIWJTIK','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['QTLAIWJTIK'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('11857520945'),'C'));
return l_oWv;
}
function Link_EOXCZYYEBY(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CONNESDOC);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CONNES',w_CONNESDOC,50,0);
l_Appl.SetFields('CONNES,RAGSOC');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('kersonbo');
l_Appl.SetID('EOXCZYYEBY');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CONNESDOC=l_Appl.GetStringValue('CONNES',50,0);
w_xRAGSOCDOC=l_Appl.GetStringValue('RAGSOC',70,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_EOXCZYYEBY_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_EOXCZYYEBY';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_EOXCZYYEBY();
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
function Link_EOXCZYYEBY_Blank() {
w_CONNESDOC='';
w_xRAGSOCDOC='';
}
function LOpt_EOXCZYYEBY() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('kersonbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CONNES','C'));
l_oWv.setValue('LinkedField',WtA('CONNES','C'));
l_oWv.setValue('UID',WtA('EOXCZYYEBY','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['EOXCZYYEBY'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('11262175587'),'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'EZPCGCABUD')) {
last_focused_comp=GetLastFocusedElementOfLink('EZPCGCABUD');
function SetMethod_EZPCGCABUD() {
Set_CODANA(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_EZPCGCABUD();
} else {
setTimeout(SetMethod_EZPCGCABUD,1);
}
bResult=true;
}
if (Eq(varName,'BHDZAMJILO')) {
last_focused_comp=GetLastFocusedElementOfLink('BHDZAMJILO');
function SetMethod_BHDZAMJILO() {
Set_CODVOC(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_BHDZAMJILO();
} else {
setTimeout(SetMethod_BHDZAMJILO,1);
}
bResult=true;
}
if (Eq(varName,'JCKYJRZABA')) {
last_focused_comp=GetLastFocusedElementOfLink('JCKYJRZABA');
function SetMethod_JCKYJRZABA() {
Set_VALUTA(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_JCKYJRZABA();
} else {
setTimeout(SetMethod_JCKYJRZABA,1);
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
if (Eq(varName,'TRNDHQYOXC')) {
last_focused_comp=GetLastFocusedElementOfLink('TRNDHQYOXC');
function SetMethod_TRNDHQYOXC() {
Set_CONNALTRO(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_TRNDHQYOXC();
} else {
setTimeout(SetMethod_TRNDHQYOXC,1);
}
bResult=true;
}
if (Eq(varName,'SDKWKBVOVR')) {
last_focused_comp=GetLastFocusedElementOfLink('SDKWKBVOVR');
function SetMethod_SDKWKBVOVR() {
Set_C_CTA(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_SDKWKBVOVR();
} else {
setTimeout(SetMethod_SDKWKBVOVR,1);
}
bResult=true;
}
if (Eq(varName,'QASGTWMXYC')) {
last_focused_comp=GetLastFocusedElementOfLink('QASGTWMXYC');
function SetMethod_QASGTWMXYC() {
Set_C_STA(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_QASGTWMXYC();
} else {
setTimeout(SetMethod_QASGTWMXYC,1);
}
bResult=true;
}
if (Eq(varName,'OGZBJVOVLN')) {
last_focused_comp=GetLastFocusedElementOfLink('OGZBJVOVLN');
function SetMethod_OGZBJVOVLN() {
Set_CODINT2(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_OGZBJVOVLN();
} else {
setTimeout(SetMethod_OGZBJVOVLN,1);
}
bResult=true;
}
if (Eq(varName,'MUTRCJYNJT')) {
last_focused_comp=GetLastFocusedElementOfLink('MUTRCJYNJT');
function SetMethod_MUTRCJYNJT() {
Set_PAESE(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_MUTRCJYNJT();
} else {
setTimeout(SetMethod_MUTRCJYNJT,1);
}
bResult=true;
}
if (Eq(varName,'CRVLITCYRD')) {
last_focused_comp=GetLastFocusedElementOfLink('CRVLITCYRD');
function SetMethod_CRVLITCYRD() {
Set_CODCAB2(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_CRVLITCYRD();
} else {
setTimeout(SetMethod_CRVLITCYRD,1);
}
bResult=true;
}
if (Eq(varName,'SDNFDOJDLP')) {
last_focused_comp=GetLastFocusedElementOfLink('SDNFDOJDLP');
function SetMethod_SDNFDOJDLP() {
Set_CODDIPE(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_SDNFDOJDLP();
} else {
setTimeout(SetMethod_SDNFDOJDLP,1);
}
bResult=true;
}
if (Eq(varName,'KZPPWSIAXL')) {
last_focused_comp=GetLastFocusedElementOfLink('KZPPWSIAXL');
function SetMethod_KZPPWSIAXL() {
Set_OPERAG(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_KZPPWSIAXL();
} else {
setTimeout(SetMethod_KZPPWSIAXL,1);
}
bResult=true;
}
if (Eq(varName,'RTGTOVGSAH')) {
last_focused_comp=GetLastFocusedElementOfLink('RTGTOVGSAH');
function SetMethod_RTGTOVGSAH() {
Set_AREAGEO(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_RTGTOVGSAH();
} else {
setTimeout(SetMethod_RTGTOVGSAH,1);
}
bResult=true;
}
if (Eq(varName,'WZGVCTOIUK')) {
last_focused_comp=GetLastFocusedElementOfLink('WZGVCTOIUK');
function SetMethod_WZGVCTOIUK() {
Set_MODSVOL(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_WZGVCTOIUK();
} else {
setTimeout(SetMethod_WZGVCTOIUK,1);
}
bResult=true;
}
if (Eq(varName,'MTCGTVJYAU')) {
last_focused_comp=GetLastFocusedElementOfLink('MTCGTVJYAU');
function SetMethod_MTCGTVJYAU() {
Set_RAGIO(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_MTCGTVJYAU();
} else {
setTimeout(SetMethod_MTCGTVJYAU,1);
}
bResult=true;
}
if (Eq(varName,'NQCYKQCVPJ')) {
last_focused_comp=GetLastFocusedElementOfLink('NQCYKQCVPJ');
function SetMethod_NQCYKQCVPJ() {
Set_TIPO(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_NQCYKQCVPJ();
} else {
setTimeout(SetMethod_NQCYKQCVPJ,1);
}
bResult=true;
}
if (Eq(varName,'RIGLNJERGO')) {
last_focused_comp=GetLastFocusedElementOfLink('RIGLNJERGO');
function SetMethod_RIGLNJERGO() {
Set_DURAT(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_RIGLNJERGO();
} else {
setTimeout(SetMethod_RIGLNJERGO,1);
}
bResult=true;
}
if (Eq(varName,'QTLAIWJTIK')) {
last_focused_comp=GetLastFocusedElementOfLink('QTLAIWJTIK');
function SetMethod_QTLAIWJTIK() {
Set_AMMONT(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_QTLAIWJTIK();
} else {
setTimeout(SetMethod_QTLAIWJTIK,1);
}
bResult=true;
}
if (Eq(varName,'EOXCZYYEBY')) {
last_focused_comp=GetLastFocusedElementOfLink('EOXCZYYEBY');
function SetMethod_EOXCZYYEBY() {
Set_CONNESDOC(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_EOXCZYYEBY();
} else {
setTimeout(SetMethod_EOXCZYYEBY,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'EZPCGCABUD')) {
return [Ctrl('EZPCGCABUD')];
}
if (Eq(varName,'BHDZAMJILO')) {
return [Ctrl('BHDZAMJILO')];
}
if (Eq(varName,'JCKYJRZABA')) {
return [Ctrl('JCKYJRZABA')];
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
if (Eq(varName,'TRNDHQYOXC')) {
return [Ctrl('TRNDHQYOXC')];
}
if (Eq(varName,'SDKWKBVOVR')) {
return [Ctrl('SDKWKBVOVR')];
}
if (Eq(varName,'QASGTWMXYC')) {
return [Ctrl('QASGTWMXYC')];
}
if (Eq(varName,'OGZBJVOVLN')) {
return [Ctrl('OGZBJVOVLN')];
}
if (Eq(varName,'MUTRCJYNJT')) {
return [Ctrl('MUTRCJYNJT')];
}
if (Eq(varName,'CRVLITCYRD')) {
return [Ctrl('CRVLITCYRD')];
}
if (Eq(varName,'SDNFDOJDLP')) {
return [Ctrl('SDNFDOJDLP')];
}
if (Eq(varName,'KZPPWSIAXL')) {
return [Ctrl('KZPPWSIAXL')];
}
if (Eq(varName,'RTGTOVGSAH')) {
return [Ctrl('RTGTOVGSAH')];
}
if (Eq(varName,'WZGVCTOIUK')) {
return [Ctrl('WZGVCTOIUK')];
}
if (Eq(varName,'MTCGTVJYAU')) {
return [Ctrl('MTCGTVJYAU')];
}
if (Eq(varName,'NQCYKQCVPJ')) {
return [Ctrl('NQCYKQCVPJ')];
}
if (Eq(varName,'RIGLNJERGO')) {
return [Ctrl('RIGLNJERGO')];
}
if (Eq(varName,'QTLAIWJTIK')) {
return [Ctrl('QTLAIWJTIK')];
}
if (Eq(varName,'EOXCZYYEBY')) {
return [Ctrl('EOXCZYYEBY')];
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
if (bResult &&  ! (arfn_chkdatdoc(w_CONNESCLI,w_DATAOPE))) {
try {
_tracker.askwrn=true;
bResult=WindowConfirm(AlertErrorMessage('11525797640'));
m_nLastError=-1;
} finally {
_tracker.askwrn=false;
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
parent.ZtVWeb.raiseEventToEvalParms('armt_storfra_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('armt_storfra_dataNotSent',{'action':formaction});
}
}
}
}
CheckChild.child=[{'prg':"ardt_wlientifrz",'BOScId':function(){ return FrameRef('ardt_wlientifrz')},'repeated':0},{'prg':"ardt_storsogfraz",'BOScId':function(){ return FrameRef('ardt_storsogfraz')},'repeated':0},{'prg':"ardt_weneficfrz",'BOScId':function(){ return FrameRef('ardt_weneficfrz')},'repeated':0},{'prg':"ardt_werzistifrz",'BOScId':function(){ return FrameRef('ardt_werzistifrz')},'repeated':0},{'prg':"ardt_docfrabo",'BOScId':function(){ return FrameRef('ardt_docfrabo')},'repeated':0}];
function Check() {
var l_bResult = true;
var l_bChildCheck = true;
ResetErrorVars();
m_nLastError=0;
if (( ! (_ChkObl('WAAXEDMKXA',1))) || ( ! (Ge(w_DATAREG,w_DATAOPE)))) {
_SignErr('WAAXEDMKXA','12128708791');
l_bResult=false;
w_DATAOPE=HtW('','D');
} else if ((Ne(w_gChkDate,'U') && Ne(w_gChkDate,'B') && Eq(w_gFlgDTP,0)) && (( ! (_ChkObl('NXYGHZZLCG',1))) || ( ! (Ge(w_DATAREG,w_DATAOPE))))) {
_SignErr('NXYGHZZLCG','12128708791');
l_bResult=false;
w_DATAREG=HtW('','D');
} else if ( ! (_ChkObl('QSRYXQJCBZ',1))) {
_SignErr('QSRYXQJCBZ');
m_cLastWorkVarErrorMsg='1722199786';
l_bResult=false;
w_FLAGFRAZ=HtW('','C');
} else if ( ! (_ChkObl('XVLCUXTZXI',1))) {
_SignErr('XVLCUXTZXI');
m_cLastWorkVarErrorMsg='11137644647';
l_bResult=false;
w_TIPOOPRAP=HtW('','C');
} else if ( ! (_ChkObl('EZPCGCABUD',1))) {
_SignErr('EZPCGCABUD');
m_cLastWorkVarErrorMsg='215536597';
l_bResult=false;
w_CODANA=HtW('','C');
} else if ( ! (_ChkObl('BHDZAMJILO',1))) {
_SignErr('BHDZAMJILO');
m_cLastWorkVarErrorMsg='215310487';
l_bResult=false;
w_CODVOC=HtW('','C');
} else if ( ! (_ChkObl('MFRSDQPPEY',1))) {
_SignErr('MFRSDQPPEY');
m_cLastWorkVarErrorMsg='appolire';
l_bResult=false;
w_appolire=HtW('','C');
} else if ( ! (_ChkObl('JCKYJRZABA',1))) {
_SignErr('JCKYJRZABA');
m_cLastWorkVarErrorMsg='109710548';
l_bResult=false;
w_VALUTA=HtW('','C');
} else if ( ! (_ChkObl('QOALLRLDKY',1))) {
_SignErr('QOALLRLDKY');
m_cLastWorkVarErrorMsg='xTOTLIRE';
l_bResult=false;
w_xTOTLIRE=HtW('','N');
} else if ( ! (_ChkObl('RPHQMPGGQR',1))) {
_SignErr('RPHQMPGGQR');
m_cLastWorkVarErrorMsg='237632211';
l_bResult=false;
w_FLAGCONT=HtW('','C');
} else if ((Eq(w_FLAGCONT,'1')) && (( ! (_ChkObl('KUMAEYPETV',1))) || ( ! (arfn_chktotalelire_cont(w_DATAOPE,w_datpaseuro,w_xTOTCONT,w_xTOTLIRE))))) {
_SignErr('KUMAEYPETV','11525797640');
l_bResult=false;
w_xTOTCONT=HtW('','N');
} else if ( ! (_ChkObl('FADDNUEJZJ',1))) {
_SignErr('FADDNUEJZJ');
m_cLastWorkVarErrorMsg='123704147';
l_bResult=false;
w_CAMBIO=HtW('','N');
} else if ( ! (_ChkObl('RZIQZFKPUE',1))) {
_SignErr('RZIQZFKPUE');
m_cLastWorkVarErrorMsg='10379997930';
l_bResult=false;
w_RAPPORTO=HtW('','C');
} else if (( ! (_ChkObl('QBLXDBODXR',1))) || ( ! (Empty(w_CONNESCLI)) &&  ! (arfn_chkdatdoc(w_CONNESCLI,w_DATAOPE)))) {
_SignErr('QBLXDBODXR','11525797640');
l_bResult=false;
w_CONNESCLI=HtW('','C');
} else if (( ! (_ChkObl('TCOTJNZLGM',1))) || ( ! (Empty(w_CONNESOPER)) &&  ! (arfn_chkdatdoc(w_CONNESOPER,w_DATAOPE)))) {
_SignErr('TCOTJNZLGM','11525797640');
l_bResult=false;
w_CONNESOPER=HtW('','C');
} else if ( ! (_ChkObl('WBHSORBZAV',1))) {
_SignErr('WBHSORBZAV');
m_cLastWorkVarErrorMsg='10639118571';
l_bResult=false;
w_TIPOLEG=HtW('','C');
} else if (( ! (Empty(LRTrim(w_CONNESOPER)))) && ( ! (_ChkObl('TMYVGJFCXV',1)))) {
_SignErr('TMYVGJFCXV');
m_cLastWorkVarErrorMsg='PAGASOGOP';
l_bResult=false;
w_PAGASOGOP='N';
} else if ( ! (_ChkObl('ULVCBLFVEU',1))) {
_SignErr('ULVCBLFVEU');
m_cLastWorkVarErrorMsg='10219814530';
l_bResult=false;
w_CONNESBEN=HtW('','C');
} else if (( ! (_ChkObl('TRNDHQYOXC',1))) || ( ! (Empty(w_CONNALTRO)) &&  ! (arfn_chkdatdoc(w_CONNALTRO,w_DATAOPE)))) {
_SignErr('TRNDHQYOXC','11525797640');
l_bResult=false;
w_CONNALTRO=HtW('','C');
} else if ( ! (_ChkObl('KZXSBEEORE',1))) {
_SignErr('KZXSBEEORE');
m_cLastWorkVarErrorMsg='C_RAG';
l_bResult=false;
w_C_RAG=HtW('','C');
} else if ( ! (_ChkObl('SDKWKBVOVR',1))) {
_SignErr('SDKWKBVOVR');
m_cLastWorkVarErrorMsg='C_CTA';
l_bResult=false;
w_C_CTA=HtW('','C');
} else if ( ! (_ChkObl('UBEYBTICRP',1))) {
_SignErr('UBEYBTICRP');
m_cLastWorkVarErrorMsg='C_PRV';
l_bResult=false;
w_C_PRV=HtW('','C');
} else if ( ! (_ChkObl('KWJVJHCAHT',1))) {
_SignErr('KWJVJHCAHT');
m_cLastWorkVarErrorMsg='C_CAP';
l_bResult=false;
w_C_CAP=HtW('','C');
} else if ( ! (_ChkObl('IXODLSKCSA',1))) {
_SignErr('IXODLSKCSA');
m_cLastWorkVarErrorMsg='C_CAB';
l_bResult=false;
w_C_CAB=HtW('','C');
} else if ( ! (_ChkObl('LVMUPCVGIQ',1))) {
_SignErr('LVMUPCVGIQ');
m_cLastWorkVarErrorMsg='C_IND';
l_bResult=false;
w_C_IND=HtW('','C');
} else if ( ! (_ChkObl('QASGTWMXYC',1))) {
_SignErr('QASGTWMXYC');
m_cLastWorkVarErrorMsg='C_STA';
l_bResult=false;
w_C_STA=HtW('','C');
} else if ( ! (_ChkObl('OBBUSHLGFO',1))) {
_SignErr('OBBUSHLGFO');
m_cLastWorkVarErrorMsg='11058698874';
l_bResult=false;
w_TIPOINT2=HtW('','C');
} else if ( ! (_ChkObl('OGZBJVOVLN',1))) {
_SignErr('OGZBJVOVLN');
m_cLastWorkVarErrorMsg='10455298077';
l_bResult=false;
w_CODINT2=HtW('','C');
} else if ( ! (_ChkObl('TYCTKKPTQQ',1))) {
_SignErr('TYCTKKPTQQ');
m_cLastWorkVarErrorMsg='DESCINTER';
l_bResult=false;
w_DESCINTER=HtW('','C');
} else if ( ! (_ChkObl('MUTRCJYNJT',1))) {
_SignErr('MUTRCJYNJT');
m_cLastWorkVarErrorMsg='240702475';
l_bResult=false;
w_PAESE=HtW('','C');
} else if ( ! (_ChkObl('YBNJCVPDUM',1))) {
_SignErr('YBNJCVPDUM');
m_cLastWorkVarErrorMsg='C_RAPPORTO';
l_bResult=false;
w_C_RAPPORTO=HtW('','C');
} else if ( ! (_ChkObl('CRVLITCYRD',1))) {
_SignErr('CRVLITCYRD');
m_cLastWorkVarErrorMsg='11945229207';
l_bResult=false;
w_CODCAB2=HtW('','C');
} else if ( ! (_ChkObl('HWGWORUQJF',1))) {
_SignErr('HWGWORUQJF');
m_cLastWorkVarErrorMsg='635233449';
l_bResult=false;
w_PROV2=HtW('','C');
} else if ( ! (_ChkObl('KDONRVZYMP',1))) {
_SignErr('KDONRVZYMP');
m_cLastWorkVarErrorMsg='11823283690';
l_bResult=false;
w_DESC2=HtW('','C');
} else if ( ! (_ChkObl('RGKPHWRBRT',1))) {
_SignErr('RGKPHWRBRT');
m_cLastWorkVarErrorMsg='ZCPARTE';
l_bResult=false;
w_ZCPARTE=HtW('','C');
} else if ( ! (_ChkObl('NJDOYSOENB',1))) {
_SignErr('NJDOYSOENB');
m_cLastWorkVarErrorMsg='113866889';
l_bResult=false;
w_IDBASE=HtW('','C');
} else if ( ! (_ChkObl('SDNFDOJDLP',1))) {
_SignErr('SDNFDOJDLP');
m_cLastWorkVarErrorMsg='2071283709';
l_bResult=false;
w_CODDIPE=HtW('','C');
} else if ((false) && ( ! (_ChkObl('VYBZEWHKFF',1)))) {
_SignErr('VYBZEWHKFF');
m_cLastWorkVarErrorMsg='11329559720';
l_bResult=false;
w_DATARETT=HtW('','D');
} else if ( ! (_ChkObl('KZPPWSIAXL',1))) {
_SignErr('KZPPWSIAXL');
m_cLastWorkVarErrorMsg='OPERAG';
l_bResult=false;
w_OPERAG=HtW('','C');
} else if ( ! (_ChkObl('BOISLVXVWN',1))) {
_SignErr('BOISLVXVWN');
m_cLastWorkVarErrorMsg='NOPROT';
l_bResult=false;
w_NOPROT=0;
} else if ( ! (_ChkObl('ZSJIVPTGDO',1))) {
_SignErr('ZSJIVPTGDO');
m_cLastWorkVarErrorMsg='RESPINS';
l_bResult=false;
w_RESPINS=HtW('','C');
} else if ( ! (_ChkObl('MWCNUZJZYJ',1))) {
_SignErr('MWCNUZJZYJ');
m_cLastWorkVarErrorMsg='INFORM';
l_bResult=false;
w_INFORM=HtW('','C');
} else if ( ! (_ChkObl('YOYXXFWJYJ',1))) {
_SignErr('YOYXXFWJYJ');
m_cLastWorkVarErrorMsg='NATURA';
l_bResult=false;
w_NATURA=HtW('','C');
} else if ( ! (_ChkObl('GPFTVWCTPC',1))) {
_SignErr('GPFTVWCTPC');
m_cLastWorkVarErrorMsg='SCOPO';
l_bResult=false;
w_SCOPO=HtW('','C');
} else if ( ! (_ChkObl('RTGTOVGSAH',1))) {
_SignErr('RTGTOVGSAH');
m_cLastWorkVarErrorMsg='AREAGEO';
l_bResult=false;
w_AREAGEO=HtW('','C');
} else if ( ! (_ChkObl('WZGVCTOIUK',1))) {
_SignErr('WZGVCTOIUK');
m_cLastWorkVarErrorMsg='MODSVOL';
l_bResult=false;
w_MODSVOL=HtW('','C');
} else if ( ! (_ChkObl('MTCGTVJYAU',1))) {
_SignErr('MTCGTVJYAU');
m_cLastWorkVarErrorMsg='RAGIO';
l_bResult=false;
w_RAGIO=HtW('','C');
} else if ( ! (_ChkObl('NQCYKQCVPJ',1))) {
_SignErr('NQCYKQCVPJ');
m_cLastWorkVarErrorMsg='TIPO';
l_bResult=false;
w_TIPO=HtW('','C');
} else if ( ! (_ChkObl('OVLHZLTRLW',1))) {
_SignErr('OVLHZLTRLW');
m_cLastWorkVarErrorMsg='RAREA';
l_bResult=false;
w_RAREA=HtW('','N');
} else if ( ! (_ChkObl('SSXPWXCJEG',1))) {
_SignErr('SSXPWXCJEG');
m_cLastWorkVarErrorMsg='RCOMP';
l_bResult=false;
w_RCOMP=HtW('','N');
} else if ( ! (_ChkObl('DPWFRQJRKQ',1))) {
_SignErr('DPWFRQJRKQ');
m_cLastWorkVarErrorMsg='RRAGIO';
l_bResult=false;
w_RRAGIO=HtW('','N');
} else if ( ! (_ChkObl('NKOMZBCBBR',1))) {
_SignErr('NKOMZBCBBR');
m_cLastWorkVarErrorMsg='RTIPO';
l_bResult=false;
w_RTIPO=HtW('','N');
} else if ( ! (_ChkObl('HJYPHRYRFX',1))) {
_SignErr('HJYPHRYRFX');
m_cLastWorkVarErrorMsg='RFREQ';
l_bResult=false;
w_RFREQ=HtW('','N');
} else if ( ! (_ChkObl('IAFRSBROAJ',1))) {
_SignErr('IAFRSBROAJ');
m_cLastWorkVarErrorMsg='RIMP';
l_bResult=false;
w_RIMP=HtW('','N');
} else if ( ! (_ChkObl('RIGLNJERGO',1))) {
_SignErr('RIGLNJERGO');
m_cLastWorkVarErrorMsg='DURAT';
l_bResult=false;
w_DURAT=HtW('','C');
} else if ( ! (_ChkObl('QTLAIWJTIK',1))) {
_SignErr('QTLAIWJTIK');
m_cLastWorkVarErrorMsg='AMMONT';
l_bResult=false;
w_AMMONT=HtW('','C');
} else if ( ! (_ChkObl('DOXBACRWUU',1))) {
_SignErr('DOXBACRWUU');
m_cLastWorkVarErrorMsg='307787605';
l_bResult=false;
w_MITIG=HtW('','N');
} else if ( ! (_ChkObl('OXGBDTWKSX',1))) {
_SignErr('OXGBDTWKSX');
m_cLastWorkVarErrorMsg='210895516';
l_bResult=false;
w_MITGDOC=HtW('','C');
} else if ( ! (_ChkObl('EOXCZYYEBY',1))) {
_SignErr('EOXCZYYEBY');
m_cLastWorkVarErrorMsg='711282992';
l_bResult=false;
w_CONNESDOC=HtW('','C');
} else if ( ! (_ChkObl('JDTKGSGMAF',1))) {
_SignErr('JDTKGSGMAF');
m_cLastWorkVarErrorMsg='338061';
l_bResult=false;
w_MTCN=HtW('','C');
}
if (l_bResult) {
l_bResult=CheckChild(0);
}
// * --- Area Manuale = UI - Check Form
// * --- armt_storfra
if (w_gChkDate == 'S') {
  if (Lt(w_DATAREG,w_dataoggi)) {
    alert('Data Registrazione inferiore alla Data di Sistema')
  }
}
if (DateDiff(w_DATAOPE,w_DATAREG) > 30) {
  alert('La differenza tra Data Operazione e Data Registrazione non deve superare i 30gg')
}
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('WAAXEDMKXA_ZOOM',lc)) {
return 0;
}
if (Eq('EZPCGCABUD_ZOOM',lc)) {
return 0;
}
if (Eq('EZPCGCABUD',lc)) {
return 0;
}
if (Eq('BHDZAMJILO_ZOOM',lc)) {
return 1;
}
if (Eq('BHDZAMJILO',lc)) {
return 1;
}
if (Eq('RZIQZFKPUE_ZOOM',lc)) {
return 2;
}
if (Eq('RZIQZFKPUE',lc)) {
return 2;
}
if (Eq('QBLXDBODXR_ZOOM',lc)) {
return 3;
}
if (Eq('QBLXDBODXR',lc)) {
return 3;
}
if (Eq('TCOTJNZLGM_ZOOM',lc)) {
return 4;
}
if (Eq('TCOTJNZLGM',lc)) {
return 4;
}
if (Eq('ULVCBLFVEU_ZOOM',lc)) {
return 5;
}
if (Eq('ULVCBLFVEU',lc)) {
return 5;
}
if (Eq('TRNDHQYOXC_ZOOM',lc)) {
return 6;
}
if (Eq('TRNDHQYOXC',lc)) {
return 6;
}
if (Eq('SDKWKBVOVR_ZOOM',lc)) {
return 7;
}
if (Eq('SDKWKBVOVR',lc)) {
return 7;
}
if (Eq('QASGTWMXYC_ZOOM',lc)) {
return 8;
}
if (Eq('QASGTWMXYC',lc)) {
return 8;
}
if (Eq('OGZBJVOVLN_ZOOM',lc)) {
return 9;
}
if (Eq('OGZBJVOVLN',lc)) {
return 9;
}
if (Eq('MUTRCJYNJT_ZOOM',lc)) {
return 10;
}
if (Eq('MUTRCJYNJT',lc)) {
return 10;
}
if (Eq('CRVLITCYRD_ZOOM',lc)) {
return 11;
}
if (Eq('CRVLITCYRD',lc)) {
return 11;
}
if (Eq('SDNFDOJDLP_ZOOM',lc)) {
return 12;
}
if (Eq('SDNFDOJDLP',lc)) {
return 12;
}
if (Eq('KZPPWSIAXL_ZOOM',lc)) {
return 13;
}
if (Eq('KZPPWSIAXL',lc)) {
return 13;
}
if (Eq('RTGTOVGSAH_ZOOM',lc)) {
return 14;
}
if (Eq('RTGTOVGSAH',lc)) {
return 14;
}
if (Eq('WZGVCTOIUK_ZOOM',lc)) {
return 15;
}
if (Eq('WZGVCTOIUK',lc)) {
return 15;
}
if (Eq('MTCGTVJYAU_ZOOM',lc)) {
return 16;
}
if (Eq('MTCGTVJYAU',lc)) {
return 16;
}
if (Eq('NQCYKQCVPJ_ZOOM',lc)) {
return 17;
}
if (Eq('NQCYKQCVPJ',lc)) {
return 17;
}
if (Eq('RIGLNJERGO_ZOOM',lc)) {
return 18;
}
if (Eq('RIGLNJERGO',lc)) {
return 18;
}
if (Eq('QTLAIWJTIK_ZOOM',lc)) {
return 19;
}
if (Eq('QTLAIWJTIK',lc)) {
return 19;
}
if (Eq('EOXCZYYEBY_ZOOM',lc)) {
return 20;
}
if (Eq('EOXCZYYEBY',lc)) {
return 20;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_EZPCGCABUD();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,1)) {
l_oWv=LOpt_BHDZAMJILO();
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
if (Eq(index,2)) {
l_oWv=LOpt_RZIQZFKPUE();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,3)) {
l_oWv=LOpt_QBLXDBODXR();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,4)) {
l_oWv=LOpt_TCOTJNZLGM();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,5)) {
l_oWv=LOpt_ULVCBLFVEU();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,6)) {
l_oWv=LOpt_TRNDHQYOXC();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,7)) {
l_oWv=LOpt_SDKWKBVOVR();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,8)) {
l_oWv=LOpt_QASGTWMXYC();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,9)) {
l_oWv=LOpt_OGZBJVOVLN();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,10)) {
l_oWv=LOpt_MUTRCJYNJT();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,11)) {
l_oWv=LOpt_CRVLITCYRD();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,12)) {
l_oWv=LOpt_SDNFDOJDLP();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,13)) {
l_oWv=LOpt_KZPPWSIAXL();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,14)) {
l_oWv=LOpt_RTGTOVGSAH();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,15)) {
l_oWv=LOpt_WZGVCTOIUK();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,16)) {
l_oWv=LOpt_MTCGTVJYAU();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,17)) {
l_oWv=LOpt_NQCYKQCVPJ();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,18)) {
l_oWv=LOpt_RIGLNJERGO();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,19)) {
l_oWv=LOpt_QTLAIWJTIK();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,20)) {
l_oWv=LOpt_EOXCZYYEBY();
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
l_oWv.setValue('OPERAG',WtA(w_OPERAG,'C'));
l_oWv.setValue('NOPROT',WtA(w_NOPROT,'N'));
l_oWv.setValue('RESPINS',WtA(w_RESPINS,'C'));
l_oWv.setValue('INFORM',WtA(w_INFORM,'C'));
l_oWv.setValue('NATURA',WtA(w_NATURA,'C'));
l_oWv.setValue('SCOPO',WtA(w_SCOPO,'C'));
l_oWv.setValue('AREAGEO',WtA(w_AREAGEO,'C'));
l_oWv.setValue('MODSVOL',WtA(w_MODSVOL,'C'));
l_oWv.setValue('RAGIO',WtA(w_RAGIO,'C'));
l_oWv.setValue('TIPO',WtA(w_TIPO,'C'));
l_oWv.setValue('RAREA',WtA(w_RAREA,'N'));
l_oWv.setValue('RCOMP',WtA(w_RCOMP,'N'));
l_oWv.setValue('RRAGIO',WtA(w_RRAGIO,'N'));
l_oWv.setValue('RTIPO',WtA(w_RTIPO,'N'));
l_oWv.setValue('RFREQ',WtA(w_RFREQ,'N'));
l_oWv.setValue('RIMP',WtA(w_RIMP,'N'));
l_oWv.setValue('DURAT',WtA(w_DURAT,'C'));
l_oWv.setValue('AMMONT',WtA(w_AMMONT,'C'));
l_oWv.setValue('CONNESDOC',WtA(w_CONNESDOC,'C'));
l_oWv.setValue('DATAOPE',WtA(w_DATAOPE,'D'));
l_oWv.setValue('CDATOPE',WtA(w_CDATOPE,'C'));
l_oWv.setValue('DATAREG',WtA(w_DATAREG,'D'));
l_oWv.setValue('FLAGFRAZ',WtA(w_FLAGFRAZ,'C'));
l_oWv.setValue('COLLEG',WtA(w_COLLEG,'C'));
l_oWv.setValue('TIPOOPRAP',WtA(w_TIPOOPRAP,'C'));
l_oWv.setValue('CODANA',WtA(w_CODANA,'C'));
l_oWv.setValue('CODVOC',WtA(w_CODVOC,'C'));
l_oWv.setValue('FLAGLIRE',WtA(w_FLAGLIRE,'C'));
l_oWv.setValue('VALUTA',WtA(w_VALUTA,'C'));
l_oWv.setValue('FLAGCONT',WtA(w_FLAGCONT,'C'));
l_oWv.setValue('CAMBIO',WtA(w_CAMBIO,'N'));
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
l_oWv.setValue('CODDIPE',WtA(w_CODDIPE,'C'));
l_oWv.setValue('DESCCIT',WtA(w_DESCCIT,'C'));
l_oWv.setValue('SEGNO',WtA(w_SEGNO,'C'));
l_oWv.setValue('PROVINCIA',WtA(w_PROVINCIA,'C'));
l_oWv.setValue('CODCAB',WtA(w_CODCAB,'C'));
l_oWv.setValue('IDFILE',WtA(w_IDFILE,'C'));
l_oWv.setValue('MTCN',WtA(w_MTCN,'C'));
l_oWv.setValue('TOTLIRE',WtA(w_TOTLIRE,'N'));
l_oWv.setValue('TOTCONT',WtA(w_TOTCONT,'N'));
l_oWv.setValue('TIPOINF',WtA(w_TIPOINF,'C'));
l_oWv.setValue('IDEREG',WtA(w_IDEREG,'C'));
l_oWv.setValue('FLAGRAP',WtA(w_FLAGRAP,'C'));
l_oWv.setValue('OPRAP',WtA(w_OPRAP,'C'));
l_oWv.setValue('RAPPORTBEN',WtA(w_RAPPORTBEN,'C'));
l_oWv.setValue('OPERATORE',WtA(w_OPERATORE,'C'));
l_oWv.setValue('AUTOM',WtA(w_AUTOM,'C'));
l_oWv.setValue('FLAGRAP2',WtA(w_FLAGRAP2,'C'));
l_oWv.setValue('PRGIMPFRZ',WtA(w_PRGIMPFRZ,'N'));
l_oWv.setValue('op_PRGIMPFRZ',WtA(op_PRGIMPFRZ,'N'));
l_oWv.setValue('CDATAOPE',WtA(w_CDATAOPE,'C'));
l_oWv.setValue('CDATREG',WtA(w_CDATREG,'C'));
l_oWv.setValue('IPCOLLEG',WtA(w_IPCOLLEG,'C'));
l_oWv.setValue('ORACOLLEG',WtA(w_ORACOLLEG,'T'));
l_oWv.setValue('DUCOLLEG',WtA(w_DUCOLLEG,'N'));
l_oWv.setValue('ANNOOPE',WtA(w_ANNOOPE,'N'));
l_oWv.setValue('DATARETT',WtA(w_DATARETT,'D'));
l_oWv.setValue('STATOREG',WtA(w_STATOREG,'C'));
l_oWv.setValue('MITIG',WtA(w_MITIG,'N'));
l_oWv.setValue('MITGDOC',WtA(w_MITGDOC,'C'));
l_oWv.setValue('xdescmodsvo',WtA(w_xdescmodsvo,'C'));
l_oWv.setValue('xdescareag',WtA(w_xdescareag,'C'));
l_oWv.setValue('xdescplauso',WtA(w_xdescplauso,'C'));
l_oWv.setValue('xdesctipor',WtA(w_xdesctipor,'C'));
l_oWv.setValue('xdescopeage',WtA(w_xdescopeage,'C'));
l_oWv.setValue('xdescfreq',WtA(w_xdescfreq,'C'));
l_oWv.setValue('xdescammo',WtA(w_xdescammo,'C'));
l_oWv.setValue('xRAGSOCDOC',WtA(w_xRAGSOCDOC,'C'));
l_oWv.setValue('filtro',WtA(w_filtro,'C'));
l_oWv.setValue('appolire',WtA(w_appolire,'C'));
l_oWv.setValue('xTOTLIRE',WtA(w_xTOTLIRE,'N'));
l_oWv.setValue('xTOTCONT',WtA(w_xTOTCONT,'N'));
l_oWv.setValue('tipope',WtA(w_tipope,'C'));
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
l_oWv.setValue('PROVDIP',WtA(w_PROVDIP,'C'));
l_oWv.setValue('CABDIP',WtA(w_CABDIP,'C'));
l_oWv.setValue('PROVINT',WtA(w_PROVINT,'C'));
l_oWv.setValue('CABINT',WtA(w_CABINT,'C'));
l_oWv.setValue('dataoggi',WtA(w_dataoggi,'D'));
l_oWv.setValue('stringaflagrap2',WtA(w_stringaflagrap2,'C'));
l_oWv.setValue('gSblocco',WtA(w_gSblocco,'C'));
l_oWv.setValue('gStatus',WtA(w_gStatus,'C'));
l_oWv.setValue('gDataVaria',WtA(w_gDataVaria,'D'));
l_oWv.setValue('CITINT',WtA(w_CITINT,'C'));
l_oWv.setValue('CITDIP',WtA(w_CITDIP,'C'));
l_oWv.setValue('gFlgDoc',WtA(w_gFlgDoc,'C'));
l_oWv.setValue('xcodfisc',WtA(w_xcodfisc,'C'));
l_oWv.setValue('dessta',WtA(w_dessta,'C'));
l_oWv.setValue('xragsocalt',WtA(w_xragsocalt,'C'));
l_oWv.setValue('xdciticon',WtA(w_xdciticon,'C'));
l_oWv.setValue('gFlgWU',WtA(w_gFlgWU,'C'));
l_oWv.setValue('DATAVALI',WtA(w_DATAVALI,'D'));
l_oWv.setValue('DATARILASC',WtA(w_DATARILASC,'D'));
l_oWv.setValue('apporeg',WtA(w_apporeg,'C'));
l_oWv.setValue('gFlgDTP',WtA(w_gFlgDTP,'N'));
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
_FillChildren.n=['ardt_wlientifrz','ardt_storsogfraz','ardt_weneficfrz','ardt_werzistifrz','ardt_docfrabo'];
FillWv.n=["OPERAG","NOPROT","RESPINS","INFORM","NATURA","SCOPO","AREAGEO","MODSVOL","RAGIO","TIPO","RAREA","RCOMP","RRAGIO","RTIPO","RFREQ","RIMP","DURAT","AMMONT","CONNESDOC","DATAOPE","CDATOPE","DATAREG","FLAGFRAZ","COLLEG","TIPOOPRAP","CODANA","CODVOC","FLAGLIRE","VALUTA","FLAGCONT","CAMBIO","RAPPORTO","CONNESCLI","CONNESOPER","TIPOLEG","PAGASOGOP","CONNESBEN","CONNALTRO","C_RAG","C_CTA","C_PRV","C_CAP","C_CAB","C_IND","C_STA","TIPOINT2","CODINT2","DESCINTER","PAESE","C_RAPPORTO","CODCAB2","PROV2","DESC2","ZCPARTE","IDBASE","NUMPROG","CODINTER","CODDIPE","DESCCIT","SEGNO","PROVINCIA","CODCAB","IDFILE","MTCN","TOTLIRE","TOTCONT","TIPOINF","IDEREG","FLAGRAP","OPRAP","RAPPORTBEN","OPERATORE","AUTOM","FLAGRAP2","PRGIMPFRZ","CDATAOPE","CDATREG","IPCOLLEG","ORACOLLEG","DUCOLLEG","ANNOOPE","DATARETT","STATOREG","MITIG","MITGDOC","xdescmodsvo","xdescareag","xdescplauso","xdesctipor","xdescopeage","xdescfreq","xdescammo","xRAGSOCDOC","filtro","appolire","xTOTLIRE","xTOTCONT","tipope","gIntemediario","xdes1","desccauana","xdesccausin","descdiv","xragsocper","xdescrap","xragsocct","xragsocben","xdestipleg","xragint2","xdescpaese2","datpaseuro","xDescDipe","sEdit","gChkDate","errmsg","test","valflg2","gTipInter","PROVDIP","CABDIP","PROVINT","CABINT","dataoggi","stringaflagrap2","gSblocco","gStatus","gDataVaria","CITINT","CITDIP","gFlgDoc","xcodfisc","dessta","xragsocalt","xdciticon","gFlgWU","DATAVALI","DATARILASC","apporeg","gFlgDTP"];
function SetModified() {
m_bUpdated=true;
}
function SetChildVariables_ardt_wlientifrz() {
}
function CtxLoad_ardt_wlientifrz() {
if (ChildToLoad(FrameRef('ardt_wlientifrz'))) {
return [LoadContext(0,'BOAFVDQFRN'),'ardt_wlientifrz'];
}
}
function SetChildVariables_ardt_storsogfraz() {
}
function CtxLoad_ardt_storsogfraz() {
if (ChildToLoad(FrameRef('ardt_storsogfraz'))) {
return [LoadContext(0,'TQDGESLQVD'),'ardt_storsogfraz'];
}
}
function SetChildVariables_ardt_weneficfrz() {
}
function CtxLoad_ardt_weneficfrz() {
if (ChildToLoad(FrameRef('ardt_weneficfrz'))) {
return [LoadContext(0,'OCTDIOXFMI'),'ardt_weneficfrz'];
}
}
function SetChildVariables_ardt_werzistifrz() {
}
function CtxLoad_ardt_werzistifrz() {
if (ChildToLoad(FrameRef('ardt_werzistifrz'))) {
return [LoadContext(0,'NOKYMTFBFL'),'ardt_werzistifrz'];
}
}
function SetChildVariables_ardt_docfrabo() {
}
function CtxLoad_ardt_docfrabo() {
if (ChildToLoad(FrameRef('ardt_docfrabo'))) {
return [LoadContext(0,'OQWMEPQQNM'),'ardt_docfrabo'];
}
}
