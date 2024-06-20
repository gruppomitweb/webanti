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
l_bEnabled= ! (Ne(w_TIPOPERS,'G') && Ne(w_xFLGANAVAL,'S')) || IsDisabledByStateDriver('COGNOME');
SetDisabled('TWTTDWKCRG',l_bEnabled);
l_bEnabled= ! (Ne(w_TIPOPERS,'G') && Ne(w_xFLGANAVAL,'S')) || IsDisabledByStateDriver('NOME');
SetDisabled('WWGIVGNUDW',l_bEnabled);
l_bEnabled= ! (Ne(w_xFLGANAVAL,'S')) || IsDisabledByStateDriver('RAGSOC');
SetDisabled('AWPNTOJIRR',l_bEnabled);
l_bEnabled= ! (Ne(w_TIPOPERS,'G') && Ne(w_xFLGANAVAL,'S')) || IsDisabledByStateDriver('IDNASCOMUN');
SetDisabled('BYPEBFEOAJ',l_bEnabled);
SetDisabled(Ctrl('BYPEBFEOAJ_ZOOM'),l_bEnabled);
l_bEnabled= ! (Ne(w_TIPOPERS,'G') && Empty(LRTrim(w_IDNASCOMUN)) && Ne(w_xFLGANAVAL,'S')) || IsDisabledByStateDriver('NASCOMUN');
SetDisabled('NEUBQNUEOJ',l_bEnabled);
l_bEnabled= ! (Ne(w_TIPOPERS,'G') && Empty(LRTrim(w_IDNASCOMUN)) && Ne(w_xFLGANAVAL,'S')) || IsDisabledByStateDriver('TIPINTER');
SetDisabled('KPSCOABZLB',l_bEnabled);
l_bEnabled= ! (Ne(w_TIPOPERS,'G') && Ne(w_xFLGANAVAL,'S')) || IsDisabledByStateDriver('IDNASSTATO');
SetDisabled('IOAMSFCCVV',l_bEnabled);
SetDisabled(Ctrl('IOAMSFCCVV_ZOOM'),l_bEnabled);
l_bEnabled= ! (Ne(w_TIPOPERS,'G') && Empty(LRTrim(w_IDNASSTATO)) && Ne(w_xFLGANAVAL,'S')) || IsDisabledByStateDriver('NASSTATO');
SetDisabled('HODZKKOSYW',l_bEnabled);
l_bEnabled= ! (Ne(w_TIPOPERS,'G') && Ne(w_xFLGANAVAL,'S')) || IsDisabledByStateDriver('SESSO');
SetDisabled('QPALJZMFCL',l_bEnabled);
l_bEnabled= ! (Ne(w_TIPOPERS,'G') && Ne(w_xFLGANAVAL,'S')) || IsDisabledByStateDriver('DATANASC');
SetDisabled('XMGRWGFSFV',l_bEnabled);
SetDisabled(Ctrl('XMGRWGFSFV_ZOOM'),l_bEnabled);
l_bEnabled= ! (Ne(w_TIPOPERS,'G')) || IsDisabledByStateDriver('TIPODOC');
SetDisabled('MBGANUUHRA',l_bEnabled);
l_bEnabled= ! (Ne(w_TIPOPERS,'G')) || IsDisabledByStateDriver('NUMDOCUM');
SetDisabled('HVEEMUJUUY',l_bEnabled);
l_bEnabled= ! (Ne(w_TIPOPERS,'G')) || IsDisabledByStateDriver('DATARILASC');
SetDisabled('XHWYGOPPUN',l_bEnabled);
SetDisabled(Ctrl('XHWYGOPPUN_ZOOM'),l_bEnabled);
l_bEnabled= ! (Ne(w_TIPOPERS,'G')) || IsDisabledByStateDriver('DATAVALI');
SetDisabled('BNWXBPSIDG',l_bEnabled);
SetDisabled(Ctrl('BNWXBPSIDG_ZOOM'),l_bEnabled);
l_bEnabled= ! (Ne(w_TIPOPERS,'G')) || IsDisabledByStateDriver('AUTRILASC');
SetDisabled('HRNCPADUFU',l_bEnabled);
l_bEnabled= ! (Ne(w_xFLGVALIDO,'S')) || IsDisabledByStateDriver('CODFISC');
SetDisabled('OJJHIUDPFY',l_bEnabled);
l_bEnabled= ! (Ne(w_TIPOPERS,'P')) || IsDisabledByStateDriver('PARTIVA');
SetDisabled('FHXWUTBNKI',l_bEnabled);
if (IsDisabledByStateDriver('DatiBase')) {
DisableInputsInContainer(Ctrl('AQSQVBKXAL'),true);
}
if (IsDisabledByStateDriver('PF')) {
DisableInputsInContainer(Ctrl('EWPTTWSBMT'),true);
}
if (IsDisabledByStateDriver('AD')) {
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
SetObligatory(Ctrl('ODAYKSRECA'),(Eq(w_PAESE,'086') || Eq(w_PAESE,'139')) && Eq(w_gVerSim,'N') || IsObligatoryByStateDriver('DESCCIT'));
SetObligatory(Ctrl('NOTZPDMYIA'),(Eq(w_PAESE,'086') || Eq(w_PAESE,'139')) && Eq(w_gVerSim,'N') || IsObligatoryByStateDriver('PROVINCIA'));
SetObligatory(Ctrl('RDAVOEETJG'),(Eq(w_PAESE,'086') || Eq(w_PAESE,'139')) && Eq(w_gVerSim,'N') || IsObligatoryByStateDriver('CAP'));
SetObligatory(Ctrl('BOTAJBWHHY'),Eq(w_PAESE,'086') || Eq(w_PAESE,'139') || IsObligatoryByStateDriver('CODCAB'));
SetObligatory(Ctrl('VYLHWTRQNX'),(Eq(w_PAESE,'086') || Eq(w_PAESE,'139')) && Eq(w_gVerSim,'N') || IsObligatoryByStateDriver('DOMICILIO'));
SetObligatory(Ctrl('SAQTIHOALW'),Eq(w_tipsot,'1') || IsObligatoryByStateDriver('ATTIV'));
}
function SetDynamicClasses() {
var c;
}
function SetDynamicTooltip() {
var c;
if(c=Ctrl('QPALJZMFCL')) c.title=Strtran(AlertErrorMessage('1215993530',w_SESSO),'\\n',"\n");
if(c=Ctrl('MBGANUUHRA')) c.title=Strtran(AlertErrorMessage('11806774252',w_TIPODOC),'\\n',"\n");
if(c=Ctrl('LLYIGAMXRH')) c.title=Strtran(AlertErrorMessage('11114044065',w_SOTGRUP,w_DESCSGRU),'\\n',"\n");
if(c=Ctrl('ZGNLLSFQHC')) c.title=Strtran(AlertErrorMessage('563275675',w_SETTSINT,w_xDSETSIN),'\\n',"\n");
}
function Set_CONTO(ctrlValue,kmode,e) {
if (Ne(w_CONTO,ctrlValue)) {
var ctl = _GetCtl(e,'JLTVZXPMKM');
if (_tracker.goon(ctl,ctrlValue)) {
w_CONTO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('JLTVZXPMKM',0);
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
function Set_NASSTATO(ctrlValue,kmode,e) {
if (Ne(w_NASSTATO,ctrlValue)) {
var ctl = _GetCtl(e,'HODZKKOSYW');
if (_tracker.goon(ctl,ctrlValue)) {
w_NASSTATO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HODZKKOSYW',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('HODZKKOSYW',function(){return WtH(w_NASSTATO,'C',30,0,'@!')},w_NASSTATO);
return l_bResult;
} else {
ctl.value=WtH('','C',30,0,'@!');
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
function Set_IDNASSTATO(ctrlValue,kmode,e) {
if (Ne(w_IDNASSTATO,ctrlValue)) {
var ctl = _GetCtl(e,'IOAMSFCCVV');
if (_tracker.goon(ctl,ctrlValue)) {
w_IDNASSTATO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('IOAMSFCCVV',0);
if (l_bResult) {
l_bResult=Link_IOAMSFCCVV(kmode);
if ( ! (l_bResult)) {
w_IDNASSTATO=HtW('','C');
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
function Set_CRIME(ctrlValue,kmode,e) {
if (Ne(w_CRIME,ctrlValue)) {
var ctl = _GetCtl(e,'RHCYCLTWOT');
if (_tracker.goon(ctl,ctrlValue)) {
w_CRIME=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RHCYCLTWOT',0);
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
function Set_flgaggfam(ctrlValue,kmode,e) {
if (Ne(w_flgaggfam,ctrlValue)) {
var ctl = _GetCtl(e,'DFNZBCOVFH');
if (_tracker.goon(ctl,ctrlValue)) {
w_flgaggfam=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('DFNZBCOVFH',0);
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
function Set_IDENT(ctrlValue,kmode,e) {
if (Ne(w_IDENT,ctrlValue)) {
var ctl = _GetCtl(e,'IRLEJAUHCB');
if (_tracker.goon(ctl,ctrlValue)) {
w_IDENT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('IRLEJAUHCB',0);
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
function Set_IDNASCOMUN(ctrlValue,kmode,e) {
if (Ne(w_IDNASCOMUN,ctrlValue)) {
var ctl = _GetCtl(e,'BYPEBFEOAJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_IDNASCOMUN=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BYPEBFEOAJ',0);
if (l_bResult) {
l_bResult=Link_BYPEBFEOAJ(kmode);
if ( ! (l_bResult)) {
w_IDNASCOMUN=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',40,0,''));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',40,0,'');
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
function Set_NASCOMUN(ctrlValue,kmode,e) {
if (Ne(w_NASCOMUN,ctrlValue)) {
var ctl = _GetCtl(e,'NEUBQNUEOJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_NASCOMUN=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NEUBQNUEOJ',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('NEUBQNUEOJ',function(){return WtH(w_NASCOMUN,'C',30,0,'@!')},w_NASCOMUN);
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
function Set_NOTIT(ctrlValue,kmode,e) {
if (Ne(w_NOTIT,ctrlValue)) {
var ctl = _GetCtl(e,'RARXYHBSLM');
if (_tracker.goon(ctl,ctrlValue)) {
w_NOTIT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RARXYHBSLM',0);
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
ctl.value=WtH('','C',16,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_DATARETT(ctrlValue,kmode,e) {
if (Ne(w_DATARETT,ctrlValue)) {
var ctl = _GetCtl(e,'FROMUIZATY');
if (_tracker.goon(ctl,ctrlValue)) {
w_DATARETT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FROMUIZATY',0);
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
if (l_bResult && ( ! (Lt(w_DATANASC,SystemDate()) && Gt(Year(w_DATANASC),1900)) && Ne(m_nLastError,-2))) {
try {
_tracker.askwrn=true;
l_bWarn=WindowConfirm(AlertErrorMessage('10610113941'));
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
if (l_bResult && ( ! (Le(w_DATAVALI,SystemDate()) && Gt(Year(w_DATANASC),1900)) && Ne(m_nLastError,-2))) {
try {
_tracker.askwrn=true;
l_bWarn=WindowConfirm(AlertErrorMessage('2029454149'));
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
function Set_NOTE(ctrlValue,kmode,e) {
if (Ne(w_NOTE,ctrlValue)) {
var ctl = _GetCtl(e,'UMKFMWBVUO');
if (_tracker.goon(ctl,ctrlValue)) {
w_NOTE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UMKFMWBVUO',0);
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
if (l_bResult &&  ! (Check_JMNVEFUDOC(false))) {
m_cLastWorkVarError='JMNVEFUDOC';
if ( ! (Eq(m_nLastError,-3))) {
m_nLastError=2;
}
l_bResult=false;
}
if (l_bResult &&  ! (Check_AJUVKUBCCO(false))) {
m_cLastWorkVarError='AJUVKUBCCO';
if ( ! (Eq(m_nLastError,-3))) {
m_nLastError=2;
}
l_bResult=false;
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
function Set_ATTIV(ctrlValue,kmode,e) {
if (Ne(w_ATTIV,ctrlValue)) {
var ctl = _GetCtl(e,'SAQTIHOALW');
if (_tracker.goon(ctl,ctrlValue)) {
w_ATTIV=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SAQTIHOALW',0);
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
function Calculate() {
var l_bTmpRes;
var l_bResult = true;
m_bCalculating=true;
if ((Ne(o_gIntemediario,w_gIntemediario))) {
l_bTmpRes=Link_LDTVEYLAXJ(null);
}
if ((Ne(o_DESCCIT,w_DESCCIT)) || (Ne(o_idcitta,w_idcitta))) {
l_bTmpRes=Link_YVIKEGPYPM(null);
}
if ((Ne(o_idcitta,w_idcitta))) {
l_bTmpRes=Link_TYEDHRZCMA(null);
}
if ((Ne(o_IDNASCOMUN,w_IDNASCOMUN))) {
w_nascomunid=w_IDNASCOMUN;
l_bTmpRes=Link_ZRIWLTGERM(null);
}
if ((Ne(o_IDNASSTATO,w_IDNASSTATO))) {
w_nasstatoid=w_IDNASSTATO;
l_bTmpRes=Link_AHFPACGVOQ(null);
}
w_dataoggi=SystemDate();
if ((Ne(o_RAMOGRUP,w_RAMOGRUP))) {
l_bTmpRes=Link_RVNHQCXNEM(null);
}
if ((Ne(o_SOTGRUP,w_SOTGRUP)) || (Ne(o_ATTIV,w_ATTIV))) {
Calculation_OIDLDZGYTQ();
}
if ((Ne(o_DATANASC,w_DATANASC))) {
Calculation_KCPGJNDBIS();
}
if ((Ne(o_COGNOME,w_COGNOME)) || (Ne(o_NOME,w_NOME))) {
Calculation_UEZIABOGNW();
}
UpdateAutonumber('PROGIMPORT');
if ((Ne(o_NASSTATO,w_NASSTATO)) || (Ne(o_IDNASSTATO,w_IDNASSTATO))) {
Calculation_DWHWPBJTAT();
}
if ((Ne(o_DESCCIT,w_DESCCIT)) || (Ne(o_PAESE,w_PAESE))) {
Calculation_VAVYJKHLRY();
}
if ((Ne(o_SOTGRUP,w_SOTGRUP))) {
Calculation_DRKQLYFONU();
}
w_CONADD=w_CONNES;
l_bTmpRes=Link_QHGWFLNQMV(null);
LibJavascript.forEachItem(m_FoundlingCopyWorkVar,i_body_1)
function i_body_1(child){
child();
}
// * --- Area Manuale = UI - Calculate
// * --- Fine Area Manuale
UpdateAutonumber('');
m_bCalculating=false;
if (l_bResult &&  ! (Check_IYNZUZHVVV(false)) && Ne(m_nLastError,-3)) {
setTimeout('WindowAlert('+LibJavascript.ToJSValue(AlertErrorMessage(m_cLastMsgError))+')',1);
l_bResult=false;
}
if (l_bResult &&  ! (Check_QKZODDNCJT(false)) && Ne(m_nLastError,-3)) {
setTimeout('WindowAlert('+LibJavascript.ToJSValue(AlertErrorMessage(m_cLastMsgError))+')',1);
l_bResult=false;
}
if (l_bResult &&  ! (Check_CGDEUUVXSN(false)) && Ne(m_nLastError,-3)) {
setTimeout('WindowAlert('+LibJavascript.ToJSValue(AlertErrorMessage(m_cLastMsgError))+')',1);
l_bResult=false;
}
}
function Calculation_OIDLDZGYTQ() {
arrt_calcolasett([])
}
function Calculation_KCPGJNDBIS() {
arrt_calccodfis([])
}
function Calculation_UEZIABOGNW() {
w_COGNOME=arfn_agechar(w_COGNOME,' ');
w_NOME=arfn_agechar(w_NOME,' ');
w_RAGSOC=arfn_agechar(LRTrim(w_COGNOME)+' '+LRTrim(w_NOME),' ');
}
function Calculation_AFKBPWDUSP() {
if ( ! (Empty(w_IDNASCOMUN))) {
w_nascomunid=w_IDNASCOMUN;
Link_ZRIWLTGERM(null);
}
if ( ! (Empty(w_IDNASSTATO))) {
w_nasstatoid=w_IDNASSTATO;
Link_AHFPACGVOQ(null);
}
}
function Calculation_DWHWPBJTAT() {
w_TIPINTER=( ! (Empty(w_TIPINTER))?w_TIPINTER:( ! (Empty(w_NASSTATO))?'EE':''));
}
function Calculation_VAVYJKHLRY() {
w_PROVINCIA=(Eq(w_PAESE,'086')?w_PROVINCIA:'EE');
}
function Calculation_DRKQLYFONU() {
w_ATTIV=(Eq(w_tipsot,'1')?w_ATTIV:Space(10));
Link_SAQTIHOALW(null);
}
function Check_HBWSCTWHSU(p_bForce) {
var l_bResult = true;
if (p_bForce) {
l_bResult=((Eq(w_PAESE,'086') || Eq(w_PAESE,'139')) && Empty(w_CODFISC)?false:true);
if ( ! (l_bResult) &&  ! (WindowConfirm(AlertErrorMessage('1296018956')))) {
m_nLastError=-3;
} else {
l_bResult=true;
}
}
return l_bResult;
}
function Check_IYNZUZHVVV(p_bForce) {
var l_bResult = true;
if (p_bForce || Ne(o_TIPODOC,w_TIPODOC) || Ne(o_PAESE,w_PAESE) || Ne(o_NUMDOCUM,w_NUMDOCUM) || Ne(o_DATARILASC,w_DATARILASC)) {
l_bResult=arfn_chklundoc(w_TIPODOC,w_PAESE,w_NUMDOCUM,w_DATARILASC);
if ( ! (l_bResult) &&  ! (WindowConfirm(AlertErrorMessage('11525797640')))) {
m_nLastError=-3;
} else {
l_bResult=true;
}
}
return l_bResult;
}
function Check_JMNVEFUDOC(p_bForce) {
var l_bResult = true;
if (p_bForce || Ne(o_SOTGRUP,w_SOTGRUP)) {
l_bResult=((Eq(w_PAESE,'086') || Eq(w_PAESE,'139')) && Eq(Left(w_SOTGRUP,1),'7')?false:true);
if ( ! (l_bResult) &&  ! (WindowConfirm(AlertErrorMessage('399857542')))) {
m_nLastError=-3;
} else {
l_bResult=true;
}
}
return l_bResult;
}
function Check_AJUVKUBCCO(p_bForce) {
var l_bResult = true;
if (p_bForce || Ne(o_SOTGRUP,w_SOTGRUP)) {
l_bResult=((Ne(w_PAESE,'086') && Ne(w_PAESE,'139')) && Ne(Left(w_SOTGRUP,1),'7')?false:true);
if ( ! (l_bResult) &&  ! (WindowConfirm(AlertErrorMessage('225761093')))) {
m_nLastError=-3;
} else {
l_bResult=true;
}
}
return l_bResult;
}
function Check_QKZODDNCJT(p_bForce) {
var l_bResult = true;
if (p_bForce || Ne(o_DATARILASC,w_DATARILASC) || Ne(o_DATAVALI,w_DATAVALI)) {
l_bResult=( ! (Empty(w_DATAVALI)) &&  ! (Empty(w_DATARILASC)) && Lt(w_DATAVALI,w_DATARILASC)?false:true);
if ( ! (l_bResult)) {
m_cLastMsgError=AlertErrorMessage('1225931194');
}
}
return l_bResult;
}
function Check_CGDEUUVXSN(p_bForce) {
var l_bResult = true;
if (p_bForce || Ne(o_DATARILASC,w_DATARILASC) || Ne(o_DATANASC,w_DATANASC)) {
l_bResult=( ! (Empty(w_DATARILASC)) &&  ! (Empty(w_DATANASC)) && Gt(w_DATANASC,w_DATARILASC)?false:true);
if ( ! (l_bResult)) {
m_cLastMsgError=AlertErrorMessage('278277598');
}
}
return l_bResult;
}
function SaveDependsOn() {
o_gIntemediario=w_gIntemediario;
o_COGNOME=w_COGNOME;
o_NOME=w_NOME;
o_PAESE=w_PAESE;
o_DESCCIT=w_DESCCIT;
o_idcitta=w_idcitta;
o_IDNASCOMUN=w_IDNASCOMUN;
o_IDNASSTATO=w_IDNASSTATO;
o_NASSTATO=w_NASSTATO;
o_DATANASC=w_DATANASC;
o_TIPODOC=w_TIPODOC;
o_NUMDOCUM=w_NUMDOCUM;
o_DATARILASC=w_DATARILASC;
o_DATAVALI=w_DATAVALI;
o_SOTGRUP=w_SOTGRUP;
o_RAMOGRUP=w_RAMOGRUP;
o_ATTIV=w_ATTIV;
}
function SaveLabelDependsOn() {
}
function Link_LDTVEYLAXJ(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_gIntemediario);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODINTER',w_gIntemediario,11,0);
l_Appl.SetFields('CODINTER,ITFLGPEP,FLGAGGFAM');
l_Appl.SetTypes('C,C,C');
l_Appl.LinkTable('intermbo');
l_Appl.SetID('LDTVEYLAXJ');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_gIntemediario=l_Appl.GetStringValue('CODINTER',11,0);
w_xITFLGPEP=l_Appl.GetStringValue('ITFLGPEP',1,0);
w_flgaggfam=l_Appl.GetStringValue('FLGAGGFAM',1,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_LDTVEYLAXJ_Blank();
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
function Link_LDTVEYLAXJ_Blank() {
w_gIntemediario='';
w_xITFLGPEP='';
w_flgaggfam='';
}
function LOpt_LDTVEYLAXJ() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('intermbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODINTER','C'));
l_oWv.setValue('LinkedField',WtA('CODINTER','C'));
l_oWv.setValue('UID',WtA('LDTVEYLAXJ','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['LDTVEYLAXJ'][1],'C'));
return l_oWv;
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
l_bResult=true;
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
l_Appl.SetStringKey('CITTA',w_DESCCIT,30,0);
l_Appl.SetFields('CITTA,IDBASE');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbcitta');
l_Appl.SetID('ODAYKSRECA');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_DESCCIT=l_Appl.GetStringValue('CITTA',30,0);
w_idcitta=l_Appl.GetStringValue('IDBASE',40,0);
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
l_Appl.SetStringKey('IDBASE',w_idcitta,40,0);
l_Appl.SetFields('IDBASE,CAB,PROV,CAP');
l_Appl.SetTypes('C,C,C,C');
l_Appl.LinkTable('tbcitta');
l_Appl.SetID('TYEDHRZCMA');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_idcitta=l_Appl.GetStringValue('IDBASE',40,0);
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
function Link_BYPEBFEOAJ(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_IDNASCOMUN);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('IDBASE',w_IDNASCOMUN,40,0);
l_Appl.SetFields('IDBASE');
l_Appl.SetTypes('C');
l_Appl.LinkTable('tbcittna');
l_Appl.SetID('BYPEBFEOAJ');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_IDNASCOMUN=l_Appl.GetStringValue('IDBASE',40,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_BYPEBFEOAJ_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_BYPEBFEOAJ';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_BYPEBFEOAJ();
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
function Link_BYPEBFEOAJ_Blank() {
w_IDNASCOMUN='';
}
function LOpt_BYPEBFEOAJ() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcittna','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('IDBASE','C'));
l_oWv.setValue('LinkedField',WtA('IDBASE','C'));
l_oWv.setValue('UID',WtA('BYPEBFEOAJ','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['BYPEBFEOAJ'][1],'C'));
return l_oWv;
}
function Link_ZRIWLTGERM(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_nascomunid);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('IDBASE',w_nascomunid,10,0);
l_Appl.SetFields('IDBASE,CITTA,PROV');
l_Appl.SetTypes('C,C,C');
l_Appl.LinkTable('tbcittna');
l_Appl.SetID('ZRIWLTGERM');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_nascomunid=l_Appl.GetStringValue('IDBASE',10,0);
w_NASCOMUN=l_Appl.GetStringValue('CITTA',30,0);
w_TIPINTER=l_Appl.GetStringValue('PROV',2,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_ZRIWLTGERM_Blank();
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
function Link_ZRIWLTGERM_Blank() {
w_nascomunid='';
w_NASCOMUN='';
w_TIPINTER='';
}
function LOpt_ZRIWLTGERM() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcittna','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('IDBASE','C'));
l_oWv.setValue('LinkedField',WtA('IDBASE','C'));
l_oWv.setValue('UID',WtA('ZRIWLTGERM','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['ZRIWLTGERM'][1],'C'));
return l_oWv;
}
function Link_IOAMSFCCVV(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_IDNASSTATO);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('IDBASE',w_IDNASSTATO,10,0);
l_Appl.SetFields('IDBASE,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbstatna');
l_Appl.SetID('IOAMSFCCVV');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_IDNASSTATO=l_Appl.GetStringValue('IDBASE',10,0);
w_xstatonas=l_Appl.GetStringValue('DESCRI',50,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_IOAMSFCCVV_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_IOAMSFCCVV';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_IOAMSFCCVV();
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
function Link_IOAMSFCCVV_Blank() {
w_IDNASSTATO='';
w_xstatonas='';
}
function LOpt_IOAMSFCCVV() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstatna','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('IDBASE','C'));
l_oWv.setValue('LinkedField',WtA('IDBASE','C'));
l_oWv.setValue('UID',WtA('IOAMSFCCVV','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['IOAMSFCCVV'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('12123678061'),'C'));
return l_oWv;
}
function Link_AHFPACGVOQ(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_nasstatoid);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('IDBASE',w_nasstatoid,10,0);
l_Appl.SetFields('IDBASE,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbstatna');
l_Appl.SetID('AHFPACGVOQ');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_nasstatoid=l_Appl.GetStringValue('IDBASE',10,0);
w_NASSTATO=l_Appl.GetStringValue('DESCRI',30,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_AHFPACGVOQ_Blank();
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
function Link_AHFPACGVOQ_Blank() {
w_nasstatoid='';
w_NASSTATO='';
}
function LOpt_AHFPACGVOQ() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstatna','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('IDBASE','C'));
l_oWv.setValue('LinkedField',WtA('IDBASE','C'));
l_oWv.setValue('UID',WtA('AHFPACGVOQ','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['AHFPACGVOQ'][1],'C'));
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
l_Appl.SetFields('SOTGRU,DESCRI,TIPOSOT,DATAFINE');
l_Appl.SetTypes('C,C,C,D');
l_Appl.LinkTable('tbstgru');
l_Appl.SetID('LLYIGAMXRH');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_SOTGRUP=l_Appl.GetStringValue('SOTGRU',3,0);
w_DESCSGRU=l_Appl.GetStringValue('DESCRI',60,0);
w_tipsot=l_Appl.GetStringValue('TIPOSOT',1,0);
w_finesae=l_Appl.GetDateValue('DATAFINE',8,0);
w_finesae=DateFromApplet(w_finesae);
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
layerOpenForeground(l_cLinkUrl,openername,'toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes');
m_nLastError=-2;
} else {
if (l_bResult &&  ! (Empty(w_SOTGRUP) && l_bEmp)) {
l_bResult=Ge(w_finesae,SystemDate()) || Empty(w_finesae);
if ( ! (l_bResult)) {
Link_LLYIGAMXRH_Blank();
}
}
if ( ! (l_bResult)) {
m_nLastError=3;
m_cLastWorkVarErrorMsg='';
if (Lt(l_nRec,0)) {
m_cLastMsgError=Translate('MSG_CONNECT_SERVER');
} else {
m_cLastMsgError=AlertErrorMessage('989022526');
}
}
}
return l_bResult;
}
function Link_LLYIGAMXRH_Blank() {
w_SOTGRUP='';
w_DESCSGRU='';
w_tipsot='';
w_finesae=NullDate();
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
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_RAMOGRUP=l_Appl.GetStringValue('RAMGRU',3,0);
w_DESCRAMGRU=l_Appl.GetStringValue('DESCRI',70,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_RVNHQCXNEM_Blank();
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
l_Appl.SetLinkzoom('armt_tbtipatt');
l_Appl.SetID('SAQTIHOALW');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_ATTIV=l_Appl.GetStringValue('CODICE',10,0);
w_xdesctipatt=l_Appl.GetStringValue('DESCRI',250,0);
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
if (l_bResult &&  ! (Empty(w_ATTIV) && l_bEmp)) {
l_bResult=arfn_chkateco(w_SOTGRUP,w_ATTIV) || Ne(w_tipsot,'1');
if ( ! (l_bResult)) {
Link_SAQTIHOALW_Blank();
}
}
if ( ! (l_bResult)) {
m_nLastError=3;
m_cLastWorkVarErrorMsg='';
if (Lt(l_nRec,0)) {
m_cLastMsgError=Translate('MSG_CONNECT_SERVER');
} else {
m_cLastMsgError=AlertErrorMessage('11909346815');
}
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
l_oWv.setValue('Linkzoomprg',WtA('armt_tbtipatt','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODICE','C'));
l_oWv.setValue('LinkedField',WtA('CODICE','C'));
l_oWv.setValue('UID',WtA('SAQTIHOALW','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['SAQTIHOALW'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('484567773'),'C'));
return l_oWv;
}
function Link_ZGNLLSFQHC(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_SETTSINT);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('SETSINT',w_SETTSINT,3,0);
l_Appl.SetFields('SETSINT,DATAFINE,DESCRI');
l_Appl.SetTypes('C,D,C');
l_Appl.LinkTable('tbsetsin');
l_Appl.SetID('ZGNLLSFQHC');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_SETTSINT=l_Appl.GetStringValue('SETSINT',3,0);
w_finesint=l_Appl.GetDateValue('DATAFINE',8,0);
w_finesint=DateFromApplet(w_finesint);
w_xDSETSIN=l_Appl.GetStringValue('DESCRI',200,0);
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
layerOpenForeground(l_cLinkUrl,openername,'toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes');
m_nLastError=-2;
} else {
if (l_bResult &&  ! (Empty(w_SETTSINT) && l_bEmp)) {
l_bResult=arfn_chksint(w_SETTSINT);
if ( ! (l_bResult)) {
Link_ZGNLLSFQHC_Blank();
}
}
if ( ! (l_bResult)) {
m_nLastError=3;
m_cLastWorkVarErrorMsg='';
if (Lt(l_nRec,0)) {
m_cLastMsgError=Translate('MSG_CONNECT_SERVER');
} else {
m_cLastMsgError=AlertErrorMessage('1298954911');
}
}
}
return l_bResult;
}
function Link_ZGNLLSFQHC_Blank() {
w_SETTSINT='';
w_finesint=NullDate();
w_xDSETSIN='';
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
function Link_QHGWFLNQMV(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CONADD);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CONNES',w_CONADD,16,0);
l_Appl.SetFields('CONNES,FLGVALIDO,FLGANAVAL');
l_Appl.SetTypes('C,C,C');
l_Appl.LinkTable('personbo_agg');
l_Appl.SetID('QHGWFLNQMV');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CONADD=l_Appl.GetStringValue('CONNES',16,0);
w_xFLGVALIDO=l_Appl.GetStringValue('FLGVALIDO',1,0);
w_xFLGANAVAL=l_Appl.GetStringValue('FLGANAVAL',1,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_QHGWFLNQMV_Blank();
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
function Link_QHGWFLNQMV_Blank() {
w_xFLGVALIDO='';
w_xFLGANAVAL='';
}
function LOpt_QHGWFLNQMV() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('personbo_agg','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CONNES','C'));
l_oWv.setValue('LinkedField',WtA('CONNES','C'));
l_oWv.setValue('UID',WtA('QHGWFLNQMV','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['QHGWFLNQMV'][1],'C'));
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
if (Eq(varName,'BYPEBFEOAJ')) {
last_focused_comp=GetLastFocusedElementOfLink('BYPEBFEOAJ');
function SetMethod_BYPEBFEOAJ() {
Set_IDNASCOMUN(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_BYPEBFEOAJ();
} else {
setTimeout(SetMethod_BYPEBFEOAJ,1);
}
bResult=true;
}
if (Eq(varName,'IOAMSFCCVV')) {
last_focused_comp=GetLastFocusedElementOfLink('IOAMSFCCVV');
function SetMethod_IOAMSFCCVV() {
Set_IDNASSTATO(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_IOAMSFCCVV();
} else {
setTimeout(SetMethod_IOAMSFCCVV,1);
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
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'YVIKEGPYPM')) {
return [Ctrl('YVIKEGPYPM')];
}
if (Eq(varName,'ODAYKSRECA')) {
return [Ctrl('ODAYKSRECA')];
}
if (Eq(varName,'BYPEBFEOAJ')) {
return [Ctrl('BYPEBFEOAJ')];
}
if (Eq(varName,'IOAMSFCCVV')) {
return [Ctrl('IOAMSFCCVV')];
}
if (Eq(varName,'MBGANUUHRA')) {
return [Ctrl('MBGANUUHRA')];
}
if (Eq(varName,'LLYIGAMXRH')) {
return [Ctrl('LLYIGAMXRH')];
}
if (Eq(varName,'SAQTIHOALW')) {
return [Ctrl('SAQTIHOALW')];
}
if (Eq(varName,'ZGNLLSFQHC')) {
return [Ctrl('ZGNLLSFQHC')];
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
bResult= ! (Empty(w_CONNES));
if ( ! (bResult)) {
m_cLastMsgError=AlertErrorMessage('11275255566');
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
parent.ZtVWeb.raiseEventToEvalParms('armt_personbo_age_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('armt_personbo_age_dataNotSent',{'action':formaction});
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
m_cLastWorkVarErrorMsg='10456253029';
l_bResult=false;
w_TIPOPERS=HtW('','C');
} else if ((Ne(w_TIPOPERS,'G') && Ne(w_xFLGANAVAL,'S')) && ( ! (_ChkObl('TWTTDWKCRG',1)))) {
_SignErr('TWTTDWKCRG');
m_cLastWorkVarErrorMsg='1816546867';
l_bResult=false;
w_COGNOME=HtW('','C');
} else if ((Ne(w_TIPOPERS,'G') && Ne(w_xFLGANAVAL,'S')) && ( ! (_ChkObl('WWGIVGNUDW',1)))) {
_SignErr('WWGIVGNUDW');
m_cLastWorkVarErrorMsg='443454';
l_bResult=false;
w_NOME=HtW('','C');
} else if ( ! (_ChkObl('CZTHKEDVCO',1))) {
_SignErr('CZTHKEDVCO');
m_cLastWorkVarErrorMsg='10034405761';
l_bResult=false;
w_CFESTERO=0;
} else if ((Ne(w_xFLGANAVAL,'S')) && ( ! (_ChkObl('AWPNTOJIRR',1)))) {
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
} else if ( ! (_ChkObl('IRLEJAUHCB',1))) {
_SignErr('IRLEJAUHCB');
m_cLastWorkVarErrorMsg='1767988220';
l_bResult=false;
w_IDENT=HtW('','C');
} else if ((Ne(w_TIPOPERS,'G') && Ne(w_xFLGANAVAL,'S')) && ( ! (_ChkObl('BYPEBFEOAJ',1)))) {
_SignErr('BYPEBFEOAJ');
m_cLastWorkVarErrorMsg='200062287';
l_bResult=false;
w_IDNASCOMUN=HtW('','C');
} else if ((Ne(w_TIPOPERS,'G') && Empty(LRTrim(w_IDNASCOMUN)) && Ne(w_xFLGANAVAL,'S')) && ( ! (_ChkObl('NEUBQNUEOJ',1)))) {
_SignErr('NEUBQNUEOJ');
m_cLastWorkVarErrorMsg='12123334500';
l_bResult=false;
w_NASCOMUN=HtW('','C');
} else if ((Ne(w_TIPOPERS,'G') && Empty(LRTrim(w_IDNASCOMUN)) && Ne(w_xFLGANAVAL,'S')) && ( ! (_ChkObl('KPSCOABZLB',1)))) {
_SignErr('KPSCOABZLB');
m_cLastWorkVarErrorMsg='3528304';
l_bResult=false;
w_TIPINTER=HtW('','C');
} else if ((Ne(w_TIPOPERS,'G') && Ne(w_xFLGANAVAL,'S')) && ( ! (_ChkObl('IOAMSFCCVV',1)))) {
_SignErr('IOAMSFCCVV');
m_cLastWorkVarErrorMsg='10175904119';
l_bResult=false;
w_IDNASSTATO=HtW('','C');
} else if ((Ne(w_TIPOPERS,'G') && Empty(LRTrim(w_IDNASSTATO)) && Ne(w_xFLGANAVAL,'S')) && ( ! (_ChkObl('HODZKKOSYW',1)))) {
_SignErr('HODZKKOSYW');
m_cLastWorkVarErrorMsg='12123284333';
l_bResult=false;
w_NASSTATO=HtW('','C');
} else if ((Ne(w_TIPOPERS,'G') && Ne(w_xFLGANAVAL,'S')) && ( ! (_ChkObl('QPALJZMFCL',1)))) {
_SignErr('QPALJZMFCL');
m_cLastWorkVarErrorMsg='7776675';
l_bResult=false;
w_SESSO=HtW('','C');
} else if ((Ne(w_TIPOPERS,'G') && Ne(w_xFLGANAVAL,'S')) && ( ! (_ChkObl('XMGRWGFSFV',1)))) {
_SignErr('XMGRWGFSFV');
m_cLastWorkVarErrorMsg='11777527481';
l_bResult=false;
w_DATANASC=HtW('','D');
} else if ((Ne(w_TIPOPERS,'G')) && ( ! (_ChkObl('MBGANUUHRA',1)))) {
_SignErr('MBGANUUHRA');
m_cLastWorkVarErrorMsg='11429032151';
l_bResult=false;
w_TIPODOC=HtW('','C');
} else if ((Ne(w_TIPOPERS,'G')) && ( ! (_ChkObl('HVEEMUJUUY',1)))) {
_SignErr('HVEEMUJUUY');
m_cLastWorkVarErrorMsg='1734932797';
l_bResult=false;
w_NUMDOCUM=HtW('','C');
} else if ((Ne(w_TIPOPERS,'G')) && ( ! (_ChkObl('XHWYGOPPUN',1)))) {
_SignErr('XHWYGOPPUN');
m_cLastWorkVarErrorMsg='1690077224';
l_bResult=false;
w_DATARILASC=HtW('','D');
} else if ((Ne(w_TIPOPERS,'G')) && ( ! (_ChkObl('BNWXBPSIDG',1)))) {
_SignErr('BNWXBPSIDG');
m_cLastWorkVarErrorMsg='DATAVALI';
l_bResult=false;
w_DATAVALI=HtW('','D');
} else if ((Ne(w_TIPOPERS,'G')) && ( ! (_ChkObl('HRNCPADUFU',1)))) {
_SignErr('HRNCPADUFU');
m_cLastWorkVarErrorMsg='10032163180';
l_bResult=false;
w_AUTRILASC=HtW('','C');
} else if ((Ne(w_xFLGVALIDO,'S')) && (( ! (_ChkObl('OJJHIUDPFY',1))) || ( ! (arfn_chkcodfis(w_CODFISC,w_PAESE,w_CFESTERO))))) {
_SignErr('OJJHIUDPFY','10034398626');
l_bResult=false;
w_CODFISC=HtW('','C');
} else if ((Ne(w_TIPOPERS,'P')) && ( ! (_ChkObl('FHXWUTBNKI',1)))) {
_SignErr('FHXWUTBNKI');
m_cLastWorkVarErrorMsg='1756430089';
l_bResult=false;
w_PARTIVA=HtW('','C');
} else if ( ! (_ChkObl('JLTVZXPMKM',1))) {
_SignErr('JLTVZXPMKM');
m_cLastWorkVarErrorMsg='1715428852';
l_bResult=false;
w_CONTO=HtW('','C');
} else if (( ! (_ChkObl('LLYIGAMXRH',1))) || ( ! (Empty(w_SOTGRUP)) &&  ! (Ge(w_finesae,SystemDate()) || Empty(w_finesae)))) {
_SignErr('LLYIGAMXRH','989022526');
l_bResult=false;
w_SOTGRUP=HtW('','C');
} else if (( ! (_ChkObl('SAQTIHOALW',1))) || ( ! (Empty(w_ATTIV)) &&  ! (arfn_chkateco(w_SOTGRUP,w_ATTIV) || Ne(w_tipsot,'1')))) {
_SignErr('SAQTIHOALW','11909346815');
l_bResult=false;
w_ATTIV=HtW('','C');
} else if (( ! (_ChkObl('ZGNLLSFQHC',1))) || ( ! (Empty(w_SETTSINT)) &&  ! (arfn_chksint(w_SETTSINT)))) {
_SignErr('ZGNLLSFQHC','1298954911');
l_bResult=false;
w_SETTSINT=HtW('','C');
} else if ( ! (_ChkObl('YTPWDRMFUS',1))) {
_SignErr('YTPWDRMFUS');
m_cLastWorkVarErrorMsg='439891216';
l_bResult=false;
w_CONNES=HtW('','C');
} else if ( ! (_ChkObl('RARXYHBSLM',1))) {
_SignErr('RARXYHBSLM');
m_cLastWorkVarErrorMsg='327723579';
l_bResult=false;
w_NOTIT=0;
} else if ( ! (_ChkObl('XFKXBQYUIU',1))) {
_SignErr('XFKXBQYUIU');
m_cLastWorkVarErrorMsg='1513560829';
l_bResult=false;
w_PEP='N';
} else if ( ! (_ChkObl('DFNZBCOVFH',1))) {
_SignErr('DFNZBCOVFH');
m_cLastWorkVarErrorMsg='flgaggfam';
l_bResult=false;
w_flgaggfam='N';
} else if ( ! (_ChkObl('RHCYCLTWOT',1))) {
_SignErr('RHCYCLTWOT');
m_cLastWorkVarErrorMsg='10242518395';
l_bResult=false;
w_CRIME='N';
} else if ( ! (_ChkObl('FROMUIZATY',1))) {
_SignErr('FROMUIZATY');
m_cLastWorkVarErrorMsg='DATARETT';
l_bResult=false;
w_DATARETT=HtW('','D');
} else if ( ! (_ChkObl('UMKFMWBVUO',1))) {
_SignErr('UMKFMWBVUO');
m_cLastWorkVarErrorMsg='445246';
l_bResult=false;
w_NOTE=HtW('','M');
} else if ( ! (Check_HBWSCTWHSU(true))) {
l_bResult = false;
} else if ( ! (Check_IYNZUZHVVV(true))) {
l_bResult = false;
} else if ( ! (Check_JMNVEFUDOC(true))) {
l_bResult = false;
} else if ( ! (Check_AJUVKUBCCO(true))) {
l_bResult = false;
} else if ( ! (Check_QKZODDNCJT(true))) {
l_bResult = false;
} else if ( ! (Check_CGDEUUVXSN(true))) {
l_bResult = false;
}
if (l_bResult) {
l_bResult=CheckChild(0);
}
// * --- Area Manuale = UI - Check Form
// * --- armt_personbo_age
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
if (Eq('BYPEBFEOAJ_ZOOM',lc)) {
return 2;
}
if (Eq('BYPEBFEOAJ',lc)) {
return 2;
}
if (Eq('IOAMSFCCVV_ZOOM',lc)) {
return 3;
}
if (Eq('IOAMSFCCVV',lc)) {
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
if (Eq('SAQTIHOALW_ZOOM',lc)) {
return 4;
}
if (Eq('SAQTIHOALW',lc)) {
return 4;
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
l_oWv=LOpt_BYPEBFEOAJ();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,3)) {
l_oWv=LOpt_IOAMSFCCVV();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,4)) {
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
l_oWv.setValue('IDENT',WtA(w_IDENT,'C'));
l_oWv.setValue('IDNASCOMUN',WtA(w_IDNASCOMUN,'C'));
l_oWv.setValue('NASCOMUN',WtA(w_NASCOMUN,'C'));
l_oWv.setValue('TIPINTER',WtA(w_TIPINTER,'C'));
l_oWv.setValue('IDNASSTATO',WtA(w_IDNASSTATO,'C'));
l_oWv.setValue('NASSTATO',WtA(w_NASSTATO,'C'));
l_oWv.setValue('SESSO',WtA(w_SESSO,'C'));
l_oWv.setValue('DATANASC',WtA(w_DATANASC,'D'));
l_oWv.setValue('TIPODOC',WtA(w_TIPODOC,'C'));
l_oWv.setValue('NUMDOCUM',WtA(w_NUMDOCUM,'C'));
l_oWv.setValue('DATARILASC',WtA(w_DATARILASC,'D'));
l_oWv.setValue('DATAVALI',WtA(w_DATAVALI,'D'));
l_oWv.setValue('AUTRILASC',WtA(w_AUTRILASC,'C'));
l_oWv.setValue('CODFISC',WtA(w_CODFISC,'C'));
l_oWv.setValue('PARTIVA',WtA(w_PARTIVA,'C'));
l_oWv.setValue('CONTO',WtA(w_CONTO,'C'));
l_oWv.setValue('SOTGRUP',WtA(w_SOTGRUP,'C'));
l_oWv.setValue('RAMOGRUP',WtA(w_RAMOGRUP,'C'));
l_oWv.setValue('ATTIV',WtA(w_ATTIV,'C'));
l_oWv.setValue('SETTSINT',WtA(w_SETTSINT,'C'));
l_oWv.setValue('CONNES',WtA(w_CONNES,'C'));
l_oWv.setValue('NOTIT',WtA(w_NOTIT,'N'));
l_oWv.setValue('PEP',WtA(w_PEP,'C'));
l_oWv.setValue('CRIME',WtA(w_CRIME,'C'));
l_oWv.setValue('PROGIMPORT',WtA(w_PROGIMPORT,'N'));
l_oWv.setValue('op_PROGIMPORT',WtA(op_PROGIMPORT,'N'));
l_oWv.setValue('NOTE',WtA(w_NOTE,'M'));
l_oWv.setValue('OLDSETSIN',WtA(w_OLDSETSIN,'C'));
l_oWv.setValue('NOSARA',WtA(w_NOSARA,'C'));
l_oWv.setValue('CRIMEDATE',WtA(w_CRIMEDATE,'D'));
l_oWv.setValue('PEPDATE',WtA(w_PEPDATE,'D'));
l_oWv.setValue('gSeekAos',WtA(w_gSeekAos,'C'));
l_oWv.setValue('gDataVaria',WtA(w_gDataVaria,'D'));
l_oWv.setValue('gFlgDoc',WtA(w_gFlgDoc,'C'));
l_oWv.setValue('gTipInter',WtA(w_gTipInter,'C'));
l_oWv.setValue('gIntemediario',WtA(w_gIntemediario,'C'));
l_oWv.setValue('gVerSim',WtA(w_gVerSim,'C'));
l_oWv.setValue('gFlgWU',WtA(w_gFlgWU,'C'));
l_oWv.setValue('nascomunid',WtA(w_nascomunid,'C'));
l_oWv.setValue('nasstatoid',WtA(w_nasstatoid,'C'));
l_oWv.setValue('dataoggi',WtA(w_dataoggi,'D'));
l_oWv.setValue('tipsot',WtA(w_tipsot,'C'));
l_oWv.setValue('flgaggfam',WtA(w_flgaggfam,'C'));
l_oWv.setValue('DESCSGRU',WtA(w_DESCSGRU,'C'));
l_oWv.setValue('DESCRAMGRU',WtA(w_DESCRAMGRU,'C'));
l_oWv.setValue('DESCUIC',WtA(w_DESCUIC,'C'));
l_oWv.setValue('dessta',WtA(w_dessta,'C'));
l_oWv.setValue('DATARETT',WtA(w_DATARETT,'D'));
l_oWv.setValue('STATOREG',WtA(w_STATOREG,'C'));
l_oWv.setValue('NUMPROG',WtA(w_NUMPROG,'C'));
l_oWv.setValue('DESCRI',WtA(w_DESCRI,'C'));
l_oWv.setValue('xdescareag',WtA(w_xdescareag,'C'));
l_oWv.setValue('xdescnatgiu',WtA(w_xdescnatgiu,'C'));
l_oWv.setValue('xdesctipatt',WtA(w_xdesctipatt,'C'));
l_oWv.setValue('xdesccomp',WtA(w_xdesccomp,'C'));
l_oWv.setValue('xstatonas',WtA(w_xstatonas,'C'));
l_oWv.setValue('finesae',WtA(w_finesae,'D'));
l_oWv.setValue('finesint',WtA(w_finesint,'D'));
l_oWv.setValue('xFLGVALIDO',WtA(w_xFLGVALIDO,'C'));
l_oWv.setValue('xFLGANAVAL',WtA(w_xFLGANAVAL,'C'));
l_oWv.setValue('CONADD',WtA(w_CONADD,'C'));
l_oWv.setValue('xDSETSIN',WtA(w_xDSETSIN,'C'));
l_oWv.setValue('xITFLGPEP',WtA(w_xITFLGPEP,'C'));
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
FillWv.n=["TIPOPERS","COGNOME","NOME","CFESTERO","RAGSOC","PAESE","DESCCIT","PROVINCIA","idcitta","CAP","CODCAB","DOMICILIO","IDENT","IDNASCOMUN","NASCOMUN","TIPINTER","IDNASSTATO","NASSTATO","SESSO","DATANASC","TIPODOC","NUMDOCUM","DATARILASC","DATAVALI","AUTRILASC","CODFISC","PARTIVA","CONTO","SOTGRUP","RAMOGRUP","ATTIV","SETTSINT","CONNES","NOTIT","PEP","CRIME","PROGIMPORT","NOTE","OLDSETSIN","NOSARA","CRIMEDATE","PEPDATE","gSeekAos","gDataVaria","gFlgDoc","gTipInter","gIntemediario","gVerSim","gFlgWU","nascomunid","nasstatoid","dataoggi","tipsot","flgaggfam","DESCSGRU","DESCRAMGRU","DESCUIC","dessta","DATARETT","STATOREG","NUMPROG","DESCRI","xdescareag","xdescnatgiu","xdesctipatt","xdesccomp","xstatonas","finesae","finesint","xFLGVALIDO","xFLGANAVAL","CONADD","xDSETSIN","xITFLGPEP"];
function SetModified() {
m_bUpdated=true;
}
