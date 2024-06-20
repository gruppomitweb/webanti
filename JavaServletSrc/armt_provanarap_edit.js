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
function DisplayErrorMessage_ardt_xarantbo() {
if ( ! (ChildToLoad(FrameRef('ardt_xarantbo'))) && Ne(typeof(FrameRef('ardt_xarantbo').DisplayErrorMessage),'undefined')) {
FrameRef('ardt_xarantbo').DisplayErrorMessage();
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
if (IsDisabledByStateDriver('DatiBase')) {
DisableInputsInContainer(Ctrl('YORQOIOBQN'),true);
}
if (IsDisabledByStateDriver('Categorie')) {
DisableInputsInContainer(Ctrl('RFAIYHSGII'),true);
}
if (IsDisabledByStateDriver('DatiBase')) {
DisableInputsInContainer(Ctrl('GJZISGEBVV'),true);
}
if (IsDisabledByStateDriver('Rapporto')) {
DisableInputsInContainer(Ctrl('LZCEHELAXJ'),true);
}
if (IsDisabledByStateDriver('Deleghe')) {
DisableInputsInContainer(Ctrl('EHSQLOIDHO'),true);
}
if (IsDisabledByStateDriver('AltriDati')) {
DisableInputsInContainer(Ctrl('LOWQUGWHYA'),true);
}
if (IsDisabledByStateDriver('Garantiti')) {
DisableInputsInContainer(Ctrl('LWDMGLAEON'),true);
}
if (IsDisabledByStateDriver('box_TUIMYVJMXF')) {
DisableInputsInContainer(Ctrl('TUIMYVJMXF'),true);
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
SetObligatory(Ctrl('QBUCLWUNFT'),Eq(w_TIPOAG,'96') || Eq(w_TIPOAG,'97') || IsObligatoryByStateDriver('ISOAGE'));
}
function SetDynamicClasses() {
var c;
}
function SetDynamicTooltip() {
var c;
if(c=Ctrl('ZFOHYLVPYN')) c.title=Strtran(AlertErrorMessage('1951322326',w_TIPORAP),'\\n',"\n");
if(c=Ctrl('BCLYMGMBLK')) c.title=Strtran(AlertErrorMessage('191062270',w_FLAGLIRE),'\\n',"\n");
if(c=Ctrl('BHAVHLFPAC')) c.title=Strtran(AlertErrorMessage('1682876716',w_TIPOAG),'\\n',"\n");
}
function Set_RAPPORTO(ctrlValue,kmode,e) {
if (Ne(w_RAPPORTO,ctrlValue)) {
var ctl = _GetCtl(e,'LXORWVRYJJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_RAPPORTO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('LXORWVRYJJ',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('LXORWVRYJJ',function(){return WtH(w_RAPPORTO,'C',25,0,'@!')},w_RAPPORTO);
return l_bResult;
} else {
ctl.value=WtH('','C',25,0,'@!');
_ResetTracker();
return true;
}
}
return true;
}
function Set_DESCRAP(ctrlValue,kmode,e) {
if (Ne(w_DESCRAP,ctrlValue)) {
var ctl = _GetCtl(e,'AQAARAIPOR');
if (_tracker.goon(ctl,ctrlValue)) {
w_DESCRAP=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('AQAARAIPOR',0);
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
function Set_TIPORAP(ctrlValue,kmode,e) {
if (Ne(w_TIPORAP,ctrlValue)) {
var ctl = _GetCtl(e,'ZFOHYLVPYN');
if (_tracker.goon(ctl,ctrlValue)) {
w_TIPORAP=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ZFOHYLVPYN',0);
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
function Set_FLAGLIRE(ctrlValue,kmode,e) {
if (Ne(w_FLAGLIRE,ctrlValue)) {
var ctl = _GetCtl(e,'BCLYMGMBLK');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLAGLIRE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BCLYMGMBLK',0);
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
var ctl = _GetCtl(e,'RUMXLFCOKA');
if (_tracker.goon(ctl,ctrlValue)) {
w_VALUTA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RUMXLFCOKA',0);
if (l_bResult) {
l_bResult=Link_RUMXLFCOKA(kmode);
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
function Set_MACODICE(ctrlValue,kmode,e) {
if (Ne(w_MACODICE,ctrlValue)) {
var ctl = _GetCtl(e,'SSYXHQXJLD');
if (_tracker.goon(ctl,ctrlValue)) {
w_MACODICE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SSYXHQXJLD',0);
if (l_bResult) {
l_bResult=Link_SSYXHQXJLD(kmode);
if ( ! (l_bResult)) {
w_MACODICE=HtW('','C');
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
function Set_TIPOAG(ctrlValue,kmode,e) {
if (Ne(w_TIPOAG,ctrlValue)) {
var ctl = _GetCtl(e,'BHAVHLFPAC');
if (_tracker.goon(ctl,ctrlValue)) {
w_TIPOAG=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BHAVHLFPAC',0);
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
function Set_CODICELR(ctrlValue,kmode,e) {
if (Ne(w_CODICELR,ctrlValue)) {
var ctl = _GetCtl(e,'UYHOJSIFEU');
if (_tracker.goon(ctl,ctrlValue)) {
w_CODICELR=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UYHOJSIFEU',0);
if (l_bResult) {
l_bResult=Link_UYHOJSIFEU(kmode);
if ( ! (l_bResult)) {
w_CODICELR=HtW('','C');
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
function Set_NOPROT(ctrlValue,kmode,e) {
if (Ne(w_NOPROT,ctrlValue)) {
var ctl = _GetCtl(e,'AABRTCZWUY');
if (_tracker.goon(ctl,ctrlValue)) {
w_NOPROT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('AABRTCZWUY',0);
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
function Set_SPLITCODE(ctrlValue,kmode,e) {
if (Ne(w_SPLITCODE,ctrlValue)) {
var ctl = _GetCtl(e,'YSBAKLZECK');
if (_tracker.goon(ctl,ctrlValue)) {
w_SPLITCODE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YSBAKLZECK',0);
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
function Set_ISOAGE(ctrlValue,kmode,e) {
if (Ne(w_ISOAGE,ctrlValue)) {
var ctl = _GetCtl(e,'QBUCLWUNFT');
if (_tracker.goon(ctl,ctrlValue)) {
w_ISOAGE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QBUCLWUNFT',0);
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
function Set_NOCANC(ctrlValue,kmode,e) {
if (Ne(w_NOCANC,ctrlValue)) {
var ctl = _GetCtl(e,'GIJHAKTZAN');
if (_tracker.goon(ctl,ctrlValue)) {
w_NOCANC=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('GIJHAKTZAN',0);
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
function Set_DURAT(ctrlValue,kmode,e) {
if (Ne(w_DURAT,ctrlValue)) {
var ctl = _GetCtl(e,'CKJQULDXKW');
if (_tracker.goon(ctl,ctrlValue)) {
w_DURAT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CKJQULDXKW',0);
if (l_bResult) {
l_bResult=Link_CKJQULDXKW(kmode);
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
function Set_RFREQ(ctrlValue,kmode,e) {
if (Ne(w_RFREQ,ctrlValue)) {
var ctl = _GetCtl(e,'MXYTQLATHC');
if (_tracker.goon(ctl,ctrlValue)) {
w_RFREQ=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MXYTQLATHC',0);
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
function Set_AMMONT(ctrlValue,kmode,e) {
if (Ne(w_AMMONT,ctrlValue)) {
var ctl = _GetCtl(e,'SXTYCPHBIM');
if (_tracker.goon(ctl,ctrlValue)) {
w_AMMONT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SXTYCPHBIM',0);
if (l_bResult) {
l_bResult=Link_SXTYCPHBIM(kmode);
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
function Set_RIMP(ctrlValue,kmode,e) {
if (Ne(w_RIMP,ctrlValue)) {
var ctl = _GetCtl(e,'KBIUAXUDXA');
if (_tracker.goon(ctl,ctrlValue)) {
w_RIMP=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('KBIUAXUDXA',0);
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
function Set_AREAGEO(ctrlValue,kmode,e) {
if (Ne(w_AREAGEO,ctrlValue)) {
var ctl = _GetCtl(e,'QJSTZIPOQB');
if (_tracker.goon(ctl,ctrlValue)) {
w_AREAGEO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QJSTZIPOQB',0);
if (l_bResult) {
l_bResult=Link_QJSTZIPOQB(kmode);
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
function Set_RAREA(ctrlValue,kmode,e) {
if (Ne(w_RAREA,ctrlValue)) {
var ctl = _GetCtl(e,'UDAYHICPVB');
if (_tracker.goon(ctl,ctrlValue)) {
w_RAREA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UDAYHICPVB',0);
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
function Set_MODSVOL(ctrlValue,kmode,e) {
if (Ne(w_MODSVOL,ctrlValue)) {
var ctl = _GetCtl(e,'SFFFOYOWNH');
if (_tracker.goon(ctl,ctrlValue)) {
w_MODSVOL=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SFFFOYOWNH',0);
if (l_bResult) {
l_bResult=Link_SFFFOYOWNH(kmode);
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
function Set_RCOMP(ctrlValue,kmode,e) {
if (Ne(w_RCOMP,ctrlValue)) {
var ctl = _GetCtl(e,'ETALZDRBSO');
if (_tracker.goon(ctl,ctrlValue)) {
w_RCOMP=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ETALZDRBSO',0);
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
function Set_RAGIO(ctrlValue,kmode,e) {
if (Ne(w_RAGIO,ctrlValue)) {
var ctl = _GetCtl(e,'NOBMPHKVTX');
if (_tracker.goon(ctl,ctrlValue)) {
w_RAGIO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NOBMPHKVTX',0);
if (l_bResult) {
l_bResult=Link_NOBMPHKVTX(kmode);
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
function Set_RRAGIO(ctrlValue,kmode,e) {
if (Ne(w_RRAGIO,ctrlValue)) {
var ctl = _GetCtl(e,'QBTVZDKLCO');
if (_tracker.goon(ctl,ctrlValue)) {
w_RRAGIO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QBTVZDKLCO',0);
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
var ctl = _GetCtl(e,'DJOWYRMDDC');
if (_tracker.goon(ctl,ctrlValue)) {
w_TIPO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('DJOWYRMDDC',0);
if (l_bResult) {
l_bResult=Link_DJOWYRMDDC(kmode);
if ( ! (l_bResult)) {
w_TIPO=HtW('','C');
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
function Set_RTIPO(ctrlValue,kmode,e) {
if (Ne(w_RTIPO,ctrlValue)) {
var ctl = _GetCtl(e,'RUWEXWJASG');
if (_tracker.goon(ctl,ctrlValue)) {
w_RTIPO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RUWEXWJASG',0);
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
function Set_IBAN(ctrlValue,kmode,e) {
if (Ne(w_IBAN,ctrlValue)) {
var ctl = _GetCtl(e,'WRZZQXZUXK');
if (_tracker.goon(ctl,ctrlValue)) {
w_IBAN=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('WRZZQXZUXK',0);
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
function Set_CODOGG(ctrlValue,kmode,e) {
if (Ne(w_CODOGG,ctrlValue)) {
var ctl = _GetCtl(e,'LSSRJEUOJW');
if (_tracker.goon(ctl,ctrlValue)) {
w_CODOGG=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('LSSRJEUOJW',0);
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
function Set_DATAPROF(ctrlValue,kmode,e) {
if (Ne(w_DATAPROF,ctrlValue)) {
var ctl = _GetCtl(e,'MXITFMGTNB');
if (_tracker.goon(ctl,ctrlValue)) {
w_DATAPROF=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MXITFMGTNB',0);
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
function Set_DATAREVPROF(ctrlValue,kmode,e) {
if (Ne(w_DATAREVPROF,ctrlValue)) {
var ctl = _GetCtl(e,'QLLLNEUVYW');
if (_tracker.goon(ctl,ctrlValue)) {
w_DATAREVPROF=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QLLLNEUVYW',0);
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
function Set_RISGLOB(ctrlValue,kmode,e) {
if (Ne(w_RISGLOB,ctrlValue)) {
var ctl = _GetCtl(e,'SMVVFHCEHA');
if (_tracker.goon(ctl,ctrlValue)) {
w_RISGLOB=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SMVVFHCEHA',0);
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
function Set_SCOPO(ctrlValue,kmode,e) {
if (Ne(w_SCOPO,ctrlValue)) {
var ctl = _GetCtl(e,'VASVGQZJGP');
if (_tracker.goon(ctl,ctrlValue)) {
w_SCOPO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VASVGQZJGP',0);
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
function Set_CATEG02(ctrlValue,kmode,e) {
if (Ne(w_CATEG02,ctrlValue)) {
var ctl = _GetCtl(e,'IXGRJLAKIQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_CATEG02=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('IXGRJLAKIQ',0);
if (l_bResult) {
l_bResult=Link_IXGRJLAKIQ(kmode);
if ( ! (l_bResult)) {
w_CATEG02=HtW('','C');
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
function Set_CATEG03(ctrlValue,kmode,e) {
if (Ne(w_CATEG03,ctrlValue)) {
var ctl = _GetCtl(e,'NKIXCWZJHO');
if (_tracker.goon(ctl,ctrlValue)) {
w_CATEG03=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NKIXCWZJHO',0);
if (l_bResult) {
l_bResult=Link_NKIXCWZJHO(kmode);
if ( ! (l_bResult)) {
w_CATEG03=HtW('','C');
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
function Set_CATEG01(ctrlValue,kmode,e) {
if (Ne(w_CATEG01,ctrlValue)) {
var ctl = _GetCtl(e,'CANUTVNGFD');
if (_tracker.goon(ctl,ctrlValue)) {
w_CATEG01=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CANUTVNGFD',0);
if (l_bResult) {
l_bResult=Link_CANUTVNGFD(kmode);
if ( ! (l_bResult)) {
w_CATEG01=HtW('','C');
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
function Set_CATEG04(ctrlValue,kmode,e) {
if (Ne(w_CATEG04,ctrlValue)) {
var ctl = _GetCtl(e,'JQLGHMLOKO');
if (_tracker.goon(ctl,ctrlValue)) {
w_CATEG04=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('JQLGHMLOKO',0);
if (l_bResult) {
l_bResult=Link_JQLGHMLOKO(kmode);
if ( ! (l_bResult)) {
w_CATEG04=HtW('','C');
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
function Set_NATURA(ctrlValue,kmode,e) {
if (Ne(w_NATURA,ctrlValue)) {
var ctl = _GetCtl(e,'VSHUPFYWOC');
if (_tracker.goon(ctl,ctrlValue)) {
w_NATURA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VSHUPFYWOC',0);
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
function Set_CATEG05(ctrlValue,kmode,e) {
if (Ne(w_CATEG05,ctrlValue)) {
var ctl = _GetCtl(e,'QVBZSFMTVP');
if (_tracker.goon(ctl,ctrlValue)) {
w_CATEG05=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QVBZSFMTVP',0);
if (l_bResult) {
l_bResult=Link_QVBZSFMTVP(kmode);
if ( ! (l_bResult)) {
w_CATEG05=HtW('','C');
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
function Calculate() {
var l_bTmpRes;
var l_bResult = true;
m_bCalculating=true;
if ((Ne(o_FLAGLIRE,w_FLAGLIRE))) {
Calculation_LKVAOXNBCA();
}
if ((Ne(o_FLAGLIRE,w_FLAGLIRE)) || (Ne(o_VALUTA,w_VALUTA))) {
l_bTmpRes=Link_RUMXLFCOKA(null);
}
UpdateAutonumber('PRGIMPRAP');
if ((Ne(o_CATEG01,w_CATEG01)) || (Ne(o_CATEG02,w_CATEG02)) || (Ne(o_CATEG03,w_CATEG03)) || (Ne(o_CATEG04,w_CATEG04)) || (Ne(o_CATEG05,w_CATEG05))) {
w_CATEGORIA=fwfn_calc_categoria(w_CATEG01,w_CATEG02,w_CATEG03,w_CATEG04,w_CATEG05);
}
w_titolo=(Eq(w_gTipInter,'14')?'Relazione d\'Affari':'Rapporti Continuativi');
w_CODDIPE=w_gCodDip;
l_bTmpRes=Link_HBPZQIPSZE(null);
LibJavascript.forEachItem(m_FoundlingCopyWorkVar,i_body_1)
function i_body_1(child){
child();
}
// * --- Area Manuale = UI - Calculate
// * --- Fine Area Manuale
UpdateAutonumber('');
m_bCalculating=false;
}
function Calculation_LKVAOXNBCA() {
w_VALUTA=(Eq(w_FLAGLIRE,'L')?'018':(Eq(w_FLAGLIRE,'E')?'242':''));
}
function SaveDependsOn() {
o_FLAGLIRE=w_FLAGLIRE;
o_VALUTA=w_VALUTA;
o_CATEG01=w_CATEG01;
o_CATEG02=w_CATEG02;
o_CATEG03=w_CATEG03;
o_CATEG04=w_CATEG04;
o_CATEG05=w_CATEG05;
}
function SaveLabelDependsOn() {
}
function Link_RUMXLFCOKA(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_VALUTA);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODVAL',w_VALUTA,3,0);
l_Appl.SetFields('CODVAL,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbvalute');
l_Appl.SetLinkzoom('armt_divise');
l_Appl.SetID('RUMXLFCOKA');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_VALUTA=l_Appl.GetStringValue('CODVAL',3,0);
w_descval=l_Appl.GetStringValue('DESCRI',30,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_RUMXLFCOKA_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_RUMXLFCOKA';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_RUMXLFCOKA();
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
function Link_RUMXLFCOKA_Blank() {
w_VALUTA='';
w_descval='';
}
function LOpt_RUMXLFCOKA() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbvalute','C'));
l_oWv.setValue('Linkzoomprg',WtA('armt_divise','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODVAL','C'));
l_oWv.setValue('LinkedField',WtA('CODVAL','C'));
l_oWv.setValue('UID',WtA('RUMXLFCOKA','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['RUMXLFCOKA'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('114016870'),'C'));
return l_oWv;
}
function Link_CKJQULDXKW(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_DURAT);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODICE',w_DURAT,5,0);
l_Appl.SetFields('CODICE,DESCRI,RISCHIO');
l_Appl.SetTypes('C,C,N');
l_Appl.LinkTable('tbdurata');
l_Appl.SetLinkzoom('ammt_tbdurata');
l_Appl.SetID('CKJQULDXKW');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_DURAT=l_Appl.GetStringValue('CODICE',5,0);
w_xdescfreq=l_Appl.GetStringValue('DESCRI',200,0);
w_RFREQ=l_Appl.GetDoubleValue('RISCHIO',3,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_CKJQULDXKW_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_CKJQULDXKW';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_CKJQULDXKW();
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
function Link_CKJQULDXKW_Blank() {
w_DURAT='';
w_xdescfreq='';
w_RFREQ=0;
}
function LOpt_CKJQULDXKW() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbdurata','C'));
l_oWv.setValue('Linkzoomprg',WtA('ammt_tbdurata','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODICE','C'));
l_oWv.setValue('LinkedField',WtA('CODICE','C'));
l_oWv.setValue('UID',WtA('CKJQULDXKW','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['CKJQULDXKW'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('492802848'),'C'));
return l_oWv;
}
function Link_SXTYCPHBIM(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_AMMONT);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODICE',w_AMMONT,5,0);
l_Appl.SetFields('CODICE,DESCRI,RISCHIO');
l_Appl.SetTypes('C,C,N');
l_Appl.LinkTable('tbimporto');
l_Appl.SetID('SXTYCPHBIM');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_AMMONT=l_Appl.GetStringValue('CODICE',5,0);
w_xdescammo=l_Appl.GetStringValue('DESCRI',200,0);
w_RIMP=l_Appl.GetDoubleValue('RISCHIO',3,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_SXTYCPHBIM_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_SXTYCPHBIM';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_SXTYCPHBIM();
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
function Link_SXTYCPHBIM_Blank() {
w_AMMONT='';
w_xdescammo='';
w_RIMP=0;
}
function LOpt_SXTYCPHBIM() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbimporto','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODICE','C'));
l_oWv.setValue('LinkedField',WtA('CODICE','C'));
l_oWv.setValue('UID',WtA('SXTYCPHBIM','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['SXTYCPHBIM'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('11857520945'),'C'));
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
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_AREAGEO=l_Appl.GetStringValue('CODICE',5,0);
w_xdescareag=l_Appl.GetStringValue('DESCRI',50,0);
w_RAREA=l_Appl.GetDoubleValue('RISCHIO',3,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_QJSTZIPOQB_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_QJSTZIPOQB';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_QJSTZIPOQB();
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
var l_bEmp = Empty(w_MODSVOL);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODICE',w_MODSVOL,5,0);
l_Appl.SetFields('CODICE,DESCRI,RISCHIO');
l_Appl.SetTypes('C,C,N');
l_Appl.LinkTable('tbsvolgim');
l_Appl.SetID('SFFFOYOWNH');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_MODSVOL=l_Appl.GetStringValue('CODICE',5,0);
w_xdescmodsvo=l_Appl.GetStringValue('DESCRI',200,0);
w_RCOMP=l_Appl.GetDoubleValue('RISCHIO',3,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_SFFFOYOWNH_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_SFFFOYOWNH';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_SFFFOYOWNH();
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
function Link_SFFFOYOWNH_Blank() {
w_MODSVOL='';
w_xdescmodsvo='';
w_RCOMP=0;
}
function LOpt_SFFFOYOWNH() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbsvolgim','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODICE','C'));
l_oWv.setValue('LinkedField',WtA('CODICE','C'));
l_oWv.setValue('UID',WtA('SFFFOYOWNH','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['SFFFOYOWNH'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('11158852142'),'C'));
return l_oWv;
}
function Link_NOBMPHKVTX(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_RAGIO);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODICE',w_RAGIO,5,0);
l_Appl.SetFields('CODICE,DESCRI,RISCHIO');
l_Appl.SetTypes('C,C,N');
l_Appl.LinkTable('tbplauso');
l_Appl.SetID('NOBMPHKVTX');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_RAGIO=l_Appl.GetStringValue('CODICE',5,0);
w_xdescplauso=l_Appl.GetStringValue('DESCRI',200,0);
w_RRAGIO=l_Appl.GetDoubleValue('RISCHIO',3,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_NOBMPHKVTX_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_NOBMPHKVTX';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_NOBMPHKVTX();
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
function Link_NOBMPHKVTX_Blank() {
w_RAGIO='';
w_xdescplauso='';
w_RRAGIO=0;
}
function LOpt_NOBMPHKVTX() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbplauso','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODICE','C'));
l_oWv.setValue('LinkedField',WtA('CODICE','C'));
l_oWv.setValue('UID',WtA('NOBMPHKVTX','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['NOBMPHKVTX'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('955814582'),'C'));
return l_oWv;
}
function Link_DJOWYRMDDC(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_TIPO);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODICE',w_TIPO,5,0);
l_Appl.SetFields('CODICE,DESCRI,RISCHIO');
l_Appl.SetTypes('C,C,N');
l_Appl.LinkTable('tbtiporisc');
l_Appl.SetID('DJOWYRMDDC');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_TIPO=l_Appl.GetStringValue('CODICE',5,0);
w_xdesctipor=l_Appl.GetStringValue('DESCRI',100,0);
w_RTIPO=l_Appl.GetDoubleValue('RISCHIO',3,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_DJOWYRMDDC_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_DJOWYRMDDC';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_DJOWYRMDDC();
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
function Link_DJOWYRMDDC_Blank() {
w_TIPO='';
w_xdesctipor='';
w_RTIPO=0;
}
function LOpt_DJOWYRMDDC() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbtiporisc','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODICE','C'));
l_oWv.setValue('LinkedField',WtA('CODICE','C'));
l_oWv.setValue('UID',WtA('DJOWYRMDDC','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['DJOWYRMDDC'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('10049460300'),'C'));
return l_oWv;
}
function Link_CANUTVNGFD(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CATEG01);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('C1CODICE',w_CATEG01,2,0);
l_Appl.SetFields('C1CODICE,C1DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbcateg01');
l_Appl.SetLinkzoom('opemt_tbcateg01');
l_Appl.SetID('CANUTVNGFD');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CATEG01=l_Appl.GetStringValue('C1CODICE',2,0);
w_xC1DESCRI=l_Appl.GetStringValue('C1DESCRI',80,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_CANUTVNGFD_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_CANUTVNGFD';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
l_cFieldFilter=l_cFieldFilter+l_cAndOpForField+_flt_('C1CODTAB','R',null,true,'=');
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_CANUTVNGFD();
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
function Link_CANUTVNGFD_Blank() {
w_CATEG01='';
w_xC1DESCRI='';
}
function LOpt_CANUTVNGFD() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcateg01','C'));
l_oWv.setValue('Linkzoomprg',WtA('opemt_tbcateg01','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('C1CODICE','C'));
l_oWv.setValue('LinkedField',WtA('C1CODICE','C'));
l_oWv.setValue('UID',WtA('CANUTVNGFD','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['CANUTVNGFD'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('157154740'),'C'));
return l_oWv;
}
function Link_IXGRJLAKIQ(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CATEG02);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('C2CODICE',w_CATEG02,2,0);
l_Appl.SetFields('C2CODICE,C2DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbcateg02');
l_Appl.SetLinkzoom('opemt_tbcateg02');
l_Appl.SetID('IXGRJLAKIQ');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CATEG02=l_Appl.GetStringValue('C2CODICE',2,0);
w_xC2DESCRI=l_Appl.GetStringValue('C2DESCRI',80,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_IXGRJLAKIQ_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_IXGRJLAKIQ';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
l_cFieldFilter=l_cFieldFilter+l_cAndOpForField+_flt_('C2CODTAB','R',null,true,'=');
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_IXGRJLAKIQ();
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
function Link_IXGRJLAKIQ_Blank() {
w_CATEG02='';
w_xC2DESCRI='';
}
function LOpt_IXGRJLAKIQ() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcateg02','C'));
l_oWv.setValue('Linkzoomprg',WtA('opemt_tbcateg02','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('C2CODICE','C'));
l_oWv.setValue('LinkedField',WtA('C2CODICE','C'));
l_oWv.setValue('UID',WtA('IXGRJLAKIQ','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['IXGRJLAKIQ'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('157154996'),'C'));
return l_oWv;
}
function Link_NKIXCWZJHO(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CATEG03);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('C3CODICE',w_CATEG03,2,0);
l_Appl.SetFields('C3CODICE,C3DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbcateg03');
l_Appl.SetLinkzoom('opemt_tbcateg03');
l_Appl.SetID('NKIXCWZJHO');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CATEG03=l_Appl.GetStringValue('C3CODICE',2,0);
w_xC3DESCRI=l_Appl.GetStringValue('C3DESCRI',80,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_NKIXCWZJHO_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_NKIXCWZJHO';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
l_cFieldFilter=l_cFieldFilter+l_cAndOpForField+_flt_('C3CODTAB','R',null,true,'=');
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_NKIXCWZJHO();
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
function Link_NKIXCWZJHO_Blank() {
w_CATEG03='';
w_xC3DESCRI='';
}
function LOpt_NKIXCWZJHO() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcateg03','C'));
l_oWv.setValue('Linkzoomprg',WtA('opemt_tbcateg03','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('C3CODICE','C'));
l_oWv.setValue('LinkedField',WtA('C3CODICE','C'));
l_oWv.setValue('UID',WtA('NKIXCWZJHO','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['NKIXCWZJHO'][1],'C'));
return l_oWv;
}
function Link_JQLGHMLOKO(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CATEG04);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('C4CODICE',w_CATEG04,2,0);
l_Appl.SetFields('C4CODICE,C4DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbcateg04');
l_Appl.SetLinkzoom('opemt_tbcateg04');
l_Appl.SetID('JQLGHMLOKO');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CATEG04=l_Appl.GetStringValue('C4CODICE',2,0);
w_xC4DESCRI=l_Appl.GetStringValue('C4DESCRI',80,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_JQLGHMLOKO_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_JQLGHMLOKO';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
l_cFieldFilter=l_cFieldFilter+l_cAndOpForField+_flt_('C4CODTAB','R',null,true,'=');
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_JQLGHMLOKO();
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
function Link_JQLGHMLOKO_Blank() {
w_CATEG04='';
w_xC4DESCRI='';
}
function LOpt_JQLGHMLOKO() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcateg04','C'));
l_oWv.setValue('Linkzoomprg',WtA('opemt_tbcateg04','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('C4CODICE','C'));
l_oWv.setValue('LinkedField',WtA('C4CODICE','C'));
l_oWv.setValue('UID',WtA('JQLGHMLOKO','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['JQLGHMLOKO'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('157155508'),'C'));
return l_oWv;
}
function Link_QVBZSFMTVP(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CATEG05);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('C5CODICE',w_CATEG05,2,0);
l_Appl.SetFields('C5CODICE,C5DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbcateg05');
l_Appl.SetLinkzoom('opemt_tbcateg05');
l_Appl.SetID('QVBZSFMTVP');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CATEG05=l_Appl.GetStringValue('C5CODICE',2,0);
w_xC5DESCRI=l_Appl.GetStringValue('C5DESCRI',80,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_QVBZSFMTVP_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_QVBZSFMTVP';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
l_cFieldFilter=l_cFieldFilter+l_cAndOpForField+_flt_('C5CODTAB','R',null,true,'=');
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_QVBZSFMTVP();
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
function Link_QVBZSFMTVP_Blank() {
w_CATEG05='';
w_xC5DESCRI='';
}
function LOpt_QVBZSFMTVP() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcateg05','C'));
l_oWv.setValue('Linkzoomprg',WtA('opemt_tbcateg05','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('C5CODICE','C'));
l_oWv.setValue('LinkedField',WtA('C5CODICE','C'));
l_oWv.setValue('UID',WtA('QVBZSFMTVP','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['QVBZSFMTVP'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('157155764'),'C'));
return l_oWv;
}
function Link_SSYXHQXJLD(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_MACODICE);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('MACODICE',w_MACODICE,5,0);
l_Appl.SetFields('MACODICE,MADESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbmacage');
l_Appl.SetID('SSYXHQXJLD');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_MACODICE=l_Appl.GetStringValue('MACODICE',5,0);
w_xMADESCRI=l_Appl.GetStringValue('MADESCRI',60,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_SSYXHQXJLD_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_SSYXHQXJLD';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_SSYXHQXJLD();
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
function Link_SSYXHQXJLD_Blank() {
w_MACODICE='';
w_xMADESCRI='';
}
function LOpt_SSYXHQXJLD() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbmacage','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('MACODICE','C'));
l_oWv.setValue('LinkedField',WtA('MACODICE','C'));
l_oWv.setValue('UID',WtA('SSYXHQXJLD','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['SSYXHQXJLD'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('11283673182'),'C'));
return l_oWv;
}
function Link_UYHOJSIFEU(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CODICELR);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CONNES',w_CODICELR,16,0);
l_Appl.SetFields('CONNES,RAGSOC');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('personbo');
l_Appl.SetID('UYHOJSIFEU');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CODICELR=l_Appl.GetStringValue('CONNES',16,0);
w_xRAGLEG=l_Appl.GetStringValue('RAGSOC',70,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_UYHOJSIFEU_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_UYHOJSIFEU';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_UYHOJSIFEU();
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
function Link_UYHOJSIFEU_Blank() {
w_CODICELR='';
w_xRAGLEG='';
}
function LOpt_UYHOJSIFEU() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('personbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CONNES','C'));
l_oWv.setValue('LinkedField',WtA('CONNES','C'));
l_oWv.setValue('UID',WtA('UYHOJSIFEU','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['UYHOJSIFEU'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('195812931'),'C'));
return l_oWv;
}
function Link_HBPZQIPSZE(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CODDIPE);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODDIP',w_CODDIPE,6,0);
l_Appl.SetFields('CODDIP,DESCRIZ');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('anadip');
l_Appl.SetLinkzoom('armt_anadip');
l_Appl.SetID('HBPZQIPSZE');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CODDIPE=l_Appl.GetStringValue('CODDIP',6,0);
w_xDESDIPE=l_Appl.GetStringValue('DESCRIZ',30,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_HBPZQIPSZE_Blank();
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
function Link_HBPZQIPSZE_Blank() {
w_CODDIPE='';
w_xDESDIPE='';
}
function LOpt_HBPZQIPSZE() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('anadip','C'));
l_oWv.setValue('Linkzoomprg',WtA('armt_anadip','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODDIP','C'));
l_oWv.setValue('LinkedField',WtA('CODDIP','C'));
l_oWv.setValue('UID',WtA('HBPZQIPSZE','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['HBPZQIPSZE'][1],'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'RUMXLFCOKA')) {
last_focused_comp=GetLastFocusedElementOfLink('RUMXLFCOKA');
function SetMethod_RUMXLFCOKA() {
Set_VALUTA(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_RUMXLFCOKA();
} else {
setTimeout(SetMethod_RUMXLFCOKA,1);
}
bResult=true;
}
if (Eq(varName,'CKJQULDXKW')) {
last_focused_comp=GetLastFocusedElementOfLink('CKJQULDXKW');
function SetMethod_CKJQULDXKW() {
Set_DURAT(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_CKJQULDXKW();
} else {
setTimeout(SetMethod_CKJQULDXKW,1);
}
bResult=true;
}
if (Eq(varName,'SXTYCPHBIM')) {
last_focused_comp=GetLastFocusedElementOfLink('SXTYCPHBIM');
function SetMethod_SXTYCPHBIM() {
Set_AMMONT(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_SXTYCPHBIM();
} else {
setTimeout(SetMethod_SXTYCPHBIM,1);
}
bResult=true;
}
if (Eq(varName,'QJSTZIPOQB')) {
last_focused_comp=GetLastFocusedElementOfLink('QJSTZIPOQB');
function SetMethod_QJSTZIPOQB() {
Set_AREAGEO(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_QJSTZIPOQB();
} else {
setTimeout(SetMethod_QJSTZIPOQB,1);
}
bResult=true;
}
if (Eq(varName,'SFFFOYOWNH')) {
last_focused_comp=GetLastFocusedElementOfLink('SFFFOYOWNH');
function SetMethod_SFFFOYOWNH() {
Set_MODSVOL(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_SFFFOYOWNH();
} else {
setTimeout(SetMethod_SFFFOYOWNH,1);
}
bResult=true;
}
if (Eq(varName,'NOBMPHKVTX')) {
last_focused_comp=GetLastFocusedElementOfLink('NOBMPHKVTX');
function SetMethod_NOBMPHKVTX() {
Set_RAGIO(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_NOBMPHKVTX();
} else {
setTimeout(SetMethod_NOBMPHKVTX,1);
}
bResult=true;
}
if (Eq(varName,'DJOWYRMDDC')) {
last_focused_comp=GetLastFocusedElementOfLink('DJOWYRMDDC');
function SetMethod_DJOWYRMDDC() {
Set_TIPO(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_DJOWYRMDDC();
} else {
setTimeout(SetMethod_DJOWYRMDDC,1);
}
bResult=true;
}
if (Eq(varName,'CANUTVNGFD')) {
last_focused_comp=GetLastFocusedElementOfLink('CANUTVNGFD');
function SetMethod_CANUTVNGFD() {
Set_CATEG01(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_CANUTVNGFD();
} else {
setTimeout(SetMethod_CANUTVNGFD,1);
}
bResult=true;
}
if (Eq(varName,'IXGRJLAKIQ')) {
last_focused_comp=GetLastFocusedElementOfLink('IXGRJLAKIQ');
function SetMethod_IXGRJLAKIQ() {
Set_CATEG02(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_IXGRJLAKIQ();
} else {
setTimeout(SetMethod_IXGRJLAKIQ,1);
}
bResult=true;
}
if (Eq(varName,'NKIXCWZJHO')) {
last_focused_comp=GetLastFocusedElementOfLink('NKIXCWZJHO');
function SetMethod_NKIXCWZJHO() {
Set_CATEG03(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_NKIXCWZJHO();
} else {
setTimeout(SetMethod_NKIXCWZJHO,1);
}
bResult=true;
}
if (Eq(varName,'JQLGHMLOKO')) {
last_focused_comp=GetLastFocusedElementOfLink('JQLGHMLOKO');
function SetMethod_JQLGHMLOKO() {
Set_CATEG04(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_JQLGHMLOKO();
} else {
setTimeout(SetMethod_JQLGHMLOKO,1);
}
bResult=true;
}
if (Eq(varName,'QVBZSFMTVP')) {
last_focused_comp=GetLastFocusedElementOfLink('QVBZSFMTVP');
function SetMethod_QVBZSFMTVP() {
Set_CATEG05(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_QVBZSFMTVP();
} else {
setTimeout(SetMethod_QVBZSFMTVP,1);
}
bResult=true;
}
if (Eq(varName,'SSYXHQXJLD')) {
last_focused_comp=GetLastFocusedElementOfLink('SSYXHQXJLD');
function SetMethod_SSYXHQXJLD() {
Set_MACODICE(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_SSYXHQXJLD();
} else {
setTimeout(SetMethod_SSYXHQXJLD,1);
}
bResult=true;
}
if (Eq(varName,'UYHOJSIFEU')) {
last_focused_comp=GetLastFocusedElementOfLink('UYHOJSIFEU');
function SetMethod_UYHOJSIFEU() {
Set_CODICELR(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_UYHOJSIFEU();
} else {
setTimeout(SetMethod_UYHOJSIFEU,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'RUMXLFCOKA')) {
return [Ctrl('RUMXLFCOKA')];
}
if (Eq(varName,'CKJQULDXKW')) {
return [Ctrl('CKJQULDXKW')];
}
if (Eq(varName,'SXTYCPHBIM')) {
return [Ctrl('SXTYCPHBIM')];
}
if (Eq(varName,'QJSTZIPOQB')) {
return [Ctrl('QJSTZIPOQB')];
}
if (Eq(varName,'SFFFOYOWNH')) {
return [Ctrl('SFFFOYOWNH')];
}
if (Eq(varName,'NOBMPHKVTX')) {
return [Ctrl('NOBMPHKVTX')];
}
if (Eq(varName,'DJOWYRMDDC')) {
return [Ctrl('DJOWYRMDDC')];
}
if (Eq(varName,'CANUTVNGFD')) {
return [Ctrl('CANUTVNGFD')];
}
if (Eq(varName,'IXGRJLAKIQ')) {
return [Ctrl('IXGRJLAKIQ')];
}
if (Eq(varName,'NKIXCWZJHO')) {
return [Ctrl('NKIXCWZJHO')];
}
if (Eq(varName,'JQLGHMLOKO')) {
return [Ctrl('JQLGHMLOKO')];
}
if (Eq(varName,'QVBZSFMTVP')) {
return [Ctrl('QVBZSFMTVP')];
}
if (Eq(varName,'SSYXHQXJLD')) {
return [Ctrl('SSYXHQXJLD')];
}
if (Eq(varName,'UYHOJSIFEU')) {
return [Ctrl('UYHOJSIFEU')];
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
parent.ZtVWeb.raiseEventToEvalParms('armt_provanarap_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('armt_provanarap_dataNotSent',{'action':formaction});
}
}
}
}
CheckChild.child=[{'prg':"ardt_xarantbo",'BOScId':function(){ return FrameRef('ardt_xarantbo')},'repeated':0}];
function Check() {
var l_bResult = true;
var l_bChildCheck = true;
ResetErrorVars();
m_nLastError=0;
if ( ! (_ChkObl('LXORWVRYJJ',1))) {
_SignErr('LXORWVRYJJ');
m_cLastWorkVarErrorMsg='11116511596';
l_bResult=false;
w_RAPPORTO=HtW('','C');
} else if ( ! (_ChkObl('AQAARAIPOR',1))) {
_SignErr('AQAARAIPOR');
m_cLastWorkVarErrorMsg='285808099';
l_bResult=false;
w_DESCRAP=HtW('','C');
} else if ( ! (_ChkObl('ZFOHYLVPYN',1))) {
_SignErr('ZFOHYLVPYN');
m_cLastWorkVarErrorMsg='1723736132';
l_bResult=false;
w_TIPORAP=HtW('','C');
} else if ( ! (_ChkObl('BCLYMGMBLK',1))) {
_SignErr('BCLYMGMBLK');
m_cLastWorkVarErrorMsg='109710548';
l_bResult=false;
w_FLAGLIRE=HtW('','C');
} else if ( ! (_ChkObl('RUMXLFCOKA',1))) {
_SignErr('RUMXLFCOKA');
m_cLastWorkVarErrorMsg='1730321404';
l_bResult=false;
w_VALUTA=HtW('','C');
} else if ( ! (_ChkObl('BHAVHLFPAC',1))) {
_SignErr('BHAVHLFPAC');
m_cLastWorkVarErrorMsg='TIPOAG';
l_bResult=false;
w_TIPOAG=HtW('','C');
} else if ( ! (_ChkObl('AABRTCZWUY',1))) {
_SignErr('AABRTCZWUY');
m_cLastWorkVarErrorMsg='10194595222';
l_bResult=false;
w_NOPROT=0;
} else if ( ! (_ChkObl('CKJQULDXKW',1))) {
_SignErr('CKJQULDXKW');
m_cLastWorkVarErrorMsg='DURAT';
l_bResult=false;
w_DURAT=HtW('','C');
} else if ( ! (_ChkObl('MXYTQLATHC',1))) {
_SignErr('MXYTQLATHC');
m_cLastWorkVarErrorMsg='RFREQ';
l_bResult=false;
w_RFREQ=HtW('','N');
} else if ( ! (_ChkObl('SXTYCPHBIM',1))) {
_SignErr('SXTYCPHBIM');
m_cLastWorkVarErrorMsg='AMMONT';
l_bResult=false;
w_AMMONT=HtW('','C');
} else if ( ! (_ChkObl('KBIUAXUDXA',1))) {
_SignErr('KBIUAXUDXA');
m_cLastWorkVarErrorMsg='RIMP';
l_bResult=false;
w_RIMP=HtW('','N');
} else if ( ! (_ChkObl('QJSTZIPOQB',1))) {
_SignErr('QJSTZIPOQB');
m_cLastWorkVarErrorMsg='AREAGEO';
l_bResult=false;
w_AREAGEO=HtW('','C');
} else if ( ! (_ChkObl('UDAYHICPVB',1))) {
_SignErr('UDAYHICPVB');
m_cLastWorkVarErrorMsg='RAREA';
l_bResult=false;
w_RAREA=HtW('','N');
} else if ( ! (_ChkObl('SFFFOYOWNH',1))) {
_SignErr('SFFFOYOWNH');
m_cLastWorkVarErrorMsg='MODSVOL';
l_bResult=false;
w_MODSVOL=HtW('','C');
} else if ( ! (_ChkObl('ETALZDRBSO',1))) {
_SignErr('ETALZDRBSO');
m_cLastWorkVarErrorMsg='RCOMP';
l_bResult=false;
w_RCOMP=HtW('','N');
} else if ( ! (_ChkObl('NOBMPHKVTX',1))) {
_SignErr('NOBMPHKVTX');
m_cLastWorkVarErrorMsg='RAGIO';
l_bResult=false;
w_RAGIO=HtW('','C');
} else if ( ! (_ChkObl('QBTVZDKLCO',1))) {
_SignErr('QBTVZDKLCO');
m_cLastWorkVarErrorMsg='RRAGIO';
l_bResult=false;
w_RRAGIO=HtW('','N');
} else if ( ! (_ChkObl('DJOWYRMDDC',1))) {
_SignErr('DJOWYRMDDC');
m_cLastWorkVarErrorMsg='TIPO';
l_bResult=false;
w_TIPO=HtW('','C');
} else if ( ! (_ChkObl('RUWEXWJASG',1))) {
_SignErr('RUWEXWJASG');
m_cLastWorkVarErrorMsg='RTIPO';
l_bResult=false;
w_RTIPO=HtW('','N');
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
} else if ( ! (_ChkObl('CANUTVNGFD',1))) {
_SignErr('CANUTVNGFD');
m_cLastWorkVarErrorMsg='157154740';
l_bResult=false;
w_CATEG01=HtW('','C');
} else if ( ! (_ChkObl('IXGRJLAKIQ',1))) {
_SignErr('IXGRJLAKIQ');
m_cLastWorkVarErrorMsg='157154996';
l_bResult=false;
w_CATEG02=HtW('','C');
} else if ( ! (_ChkObl('NKIXCWZJHO',1))) {
_SignErr('NKIXCWZJHO');
m_cLastWorkVarErrorMsg='157155252';
l_bResult=false;
w_CATEG03=HtW('','C');
} else if ( ! (_ChkObl('JQLGHMLOKO',1))) {
_SignErr('JQLGHMLOKO');
m_cLastWorkVarErrorMsg='157154740';
l_bResult=false;
w_CATEG04=HtW('','C');
} else if ( ! (_ChkObl('QVBZSFMTVP',1))) {
_SignErr('QVBZSFMTVP');
m_cLastWorkVarErrorMsg='157154740';
l_bResult=false;
w_CATEG05=HtW('','C');
} else if ( ! (_ChkObl('VSHUPFYWOC',1))) {
_SignErr('VSHUPFYWOC');
m_cLastWorkVarErrorMsg='NATURA';
l_bResult=false;
w_NATURA=HtW('','C');
} else if ( ! (_ChkObl('VASVGQZJGP',1))) {
_SignErr('VASVGQZJGP');
m_cLastWorkVarErrorMsg='SCOPO';
l_bResult=false;
w_SCOPO=HtW('','C');
} else if ( ! (_ChkObl('SMVVFHCEHA',1))) {
_SignErr('SMVVFHCEHA');
m_cLastWorkVarErrorMsg='10500809751';
l_bResult=false;
w_RISGLOB=HtW('','C');
} else if ( ! (_ChkObl('QLLLNEUVYW',1))) {
_SignErr('QLLLNEUVYW');
m_cLastWorkVarErrorMsg='11148260655';
l_bResult=false;
w_DATAREVPROF=HtW('','D');
} else if ( ! (_ChkObl('MXITFMGTNB',1))) {
_SignErr('MXITFMGTNB');
m_cLastWorkVarErrorMsg='10252637878';
l_bResult=false;
w_DATAPROF=HtW('','D');
} else if ( ! (_ChkObl('LSSRJEUOJW',1))) {
_SignErr('LSSRJEUOJW');
m_cLastWorkVarErrorMsg='11635074230';
l_bResult=false;
w_CODOGG=HtW('','C');
} else if ( ! (_ChkObl('WRZZQXZUXK',1))) {
_SignErr('WRZZQXZUXK');
m_cLastWorkVarErrorMsg='337257';
l_bResult=false;
w_IBAN=HtW('','C');
} else if ( ! (_ChkObl('GIJHAKTZAN',1))) {
_SignErr('GIJHAKTZAN');
m_cLastWorkVarErrorMsg='10138432524';
l_bResult=false;
w_NOCANC=0;
} else if ( ! (_ChkObl('QBUCLWUNFT',1))) {
_SignErr('QBUCLWUNFT');
m_cLastWorkVarErrorMsg='1529904207';
l_bResult=false;
w_ISOAGE=HtW('','C');
} else if ( ! (_ChkObl('YSBAKLZECK',1))) {
_SignErr('YSBAKLZECK');
m_cLastWorkVarErrorMsg='115410470';
l_bResult=false;
w_SPLITCODE=HtW('','C');
} else if ( ! (_ChkObl('SSYXHQXJLD',1))) {
_SignErr('SSYXHQXJLD');
m_cLastWorkVarErrorMsg='11283631966';
l_bResult=false;
w_MACODICE=HtW('','C');
} else if ( ! (_ChkObl('UYHOJSIFEU',1))) {
_SignErr('UYHOJSIFEU');
m_cLastWorkVarErrorMsg='11815361151';
l_bResult=false;
w_CODICELR=HtW('','C');
}
if (l_bResult) {
l_bResult=CheckChild(0);
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('RUMXLFCOKA_ZOOM',lc)) {
return 0;
}
if (Eq('RUMXLFCOKA',lc)) {
return 0;
}
if (Eq('CKJQULDXKW_ZOOM',lc)) {
return 1;
}
if (Eq('CKJQULDXKW',lc)) {
return 1;
}
if (Eq('SXTYCPHBIM_ZOOM',lc)) {
return 2;
}
if (Eq('SXTYCPHBIM',lc)) {
return 2;
}
if (Eq('QJSTZIPOQB_ZOOM',lc)) {
return 3;
}
if (Eq('QJSTZIPOQB',lc)) {
return 3;
}
if (Eq('SFFFOYOWNH_ZOOM',lc)) {
return 4;
}
if (Eq('SFFFOYOWNH',lc)) {
return 4;
}
if (Eq('NOBMPHKVTX_ZOOM',lc)) {
return 5;
}
if (Eq('NOBMPHKVTX',lc)) {
return 5;
}
if (Eq('DJOWYRMDDC_ZOOM',lc)) {
return 6;
}
if (Eq('DJOWYRMDDC',lc)) {
return 6;
}
if (Eq('CANUTVNGFD_ZOOM',lc)) {
return 7;
}
if (Eq('CANUTVNGFD',lc)) {
return 7;
}
if (Eq('IXGRJLAKIQ_ZOOM',lc)) {
return 8;
}
if (Eq('IXGRJLAKIQ',lc)) {
return 8;
}
if (Eq('NKIXCWZJHO_ZOOM',lc)) {
return 9;
}
if (Eq('NKIXCWZJHO',lc)) {
return 9;
}
if (Eq('JQLGHMLOKO_ZOOM',lc)) {
return 10;
}
if (Eq('JQLGHMLOKO',lc)) {
return 10;
}
if (Eq('QVBZSFMTVP_ZOOM',lc)) {
return 11;
}
if (Eq('QVBZSFMTVP',lc)) {
return 11;
}
if (Eq('QLLLNEUVYW_ZOOM',lc)) {
return 12;
}
if (Eq('MXITFMGTNB_ZOOM',lc)) {
return 12;
}
if (Eq('SSYXHQXJLD_ZOOM',lc)) {
return 12;
}
if (Eq('SSYXHQXJLD',lc)) {
return 12;
}
if (Eq('UYHOJSIFEU_ZOOM',lc)) {
return 13;
}
if (Eq('UYHOJSIFEU',lc)) {
return 13;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_RUMXLFCOKA();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,1)) {
l_oWv=LOpt_CKJQULDXKW();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,2)) {
l_oWv=LOpt_SXTYCPHBIM();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,3)) {
l_oWv=LOpt_QJSTZIPOQB();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,4)) {
l_oWv=LOpt_SFFFOYOWNH();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,5)) {
l_oWv=LOpt_NOBMPHKVTX();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,6)) {
l_oWv=LOpt_DJOWYRMDDC();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,7)) {
l_oWv=LOpt_CANUTVNGFD();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
l_cFieldFilter=l_cFieldFilter+l_cAndOpForField+_flt_('C1CODTAB','R',null,true,'=');
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
l_oWv.setValue('FieldFilter',l_cFieldFilter);
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,8)) {
l_oWv=LOpt_IXGRJLAKIQ();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
l_cFieldFilter=l_cFieldFilter+l_cAndOpForField+_flt_('C2CODTAB','R',null,true,'=');
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
l_oWv.setValue('FieldFilter',l_cFieldFilter);
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,9)) {
l_oWv=LOpt_NKIXCWZJHO();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
l_cFieldFilter=l_cFieldFilter+l_cAndOpForField+_flt_('C3CODTAB','R',null,true,'=');
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
l_oWv.setValue('FieldFilter',l_cFieldFilter);
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,10)) {
l_oWv=LOpt_JQLGHMLOKO();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
l_cFieldFilter=l_cFieldFilter+l_cAndOpForField+_flt_('C4CODTAB','R',null,true,'=');
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
l_oWv.setValue('FieldFilter',l_cFieldFilter);
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,11)) {
l_oWv=LOpt_QVBZSFMTVP();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
l_cFieldFilter=l_cFieldFilter+l_cAndOpForField+_flt_('C5CODTAB','R',null,true,'=');
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
l_oWv.setValue('FieldFilter',l_cFieldFilter);
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,12)) {
l_oWv=LOpt_SSYXHQXJLD();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,13)) {
l_oWv=LOpt_UYHOJSIFEU();
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
l_oWv.setValue('RAPPORTO',WtA(w_RAPPORTO,'C'));
l_oWv.setValue('DESCRAP',WtA(w_DESCRAP,'C'));
l_oWv.setValue('TIPORAP',WtA(w_TIPORAP,'C'));
l_oWv.setValue('FLAGLIRE',WtA(w_FLAGLIRE,'C'));
l_oWv.setValue('VALUTA',WtA(w_VALUTA,'C'));
l_oWv.setValue('TIPOAG',WtA(w_TIPOAG,'C'));
l_oWv.setValue('NOPROT',WtA(w_NOPROT,'N'));
l_oWv.setValue('PRGIMPRAP',WtA(w_PRGIMPRAP,'N'));
l_oWv.setValue('op_PRGIMPRAP',WtA(op_PRGIMPRAP,'N'));
l_oWv.setValue('DURAT',WtA(w_DURAT,'C'));
l_oWv.setValue('RFREQ',WtA(w_RFREQ,'N'));
l_oWv.setValue('AMMONT',WtA(w_AMMONT,'C'));
l_oWv.setValue('RIMP',WtA(w_RIMP,'N'));
l_oWv.setValue('AREAGEO',WtA(w_AREAGEO,'C'));
l_oWv.setValue('RAREA',WtA(w_RAREA,'N'));
l_oWv.setValue('MODSVOL',WtA(w_MODSVOL,'C'));
l_oWv.setValue('RCOMP',WtA(w_RCOMP,'N'));
l_oWv.setValue('RAGIO',WtA(w_RAGIO,'C'));
l_oWv.setValue('RRAGIO',WtA(w_RRAGIO,'N'));
l_oWv.setValue('TIPO',WtA(w_TIPO,'C'));
l_oWv.setValue('RTIPO',WtA(w_RTIPO,'N'));
l_oWv.setValue('CODDIP',WtA(w_CODDIP,'C'));
l_oWv.setValue('CODDIPE',WtA(w_CODDIPE,'C'));
l_oWv.setValue('SPLITCODE',WtA(w_SPLITCODE,'C'));
l_oWv.setValue('MACODICE',WtA(w_MACODICE,'C'));
l_oWv.setValue('CODICELR',WtA(w_CODICELR,'C'));
l_oWv.setValue('MITIG',WtA(w_MITIG,'N'));
l_oWv.setValue('MITGDOC',WtA(w_MITGDOC,'C'));
l_oWv.setValue('CATEG01',WtA(w_CATEG01,'C'));
l_oWv.setValue('CATEG02',WtA(w_CATEG02,'C'));
l_oWv.setValue('CATEG03',WtA(w_CATEG03,'C'));
l_oWv.setValue('CATEG04',WtA(w_CATEG04,'C'));
l_oWv.setValue('CATEG05',WtA(w_CATEG05,'C'));
l_oWv.setValue('CATEGORIA',WtA(w_CATEGORIA,'C'));
l_oWv.setValue('NATURA',WtA(w_NATURA,'C'));
l_oWv.setValue('SCOPO',WtA(w_SCOPO,'C'));
l_oWv.setValue('RISGLOB',WtA(w_RISGLOB,'C'));
l_oWv.setValue('DATAREVPROF',WtA(w_DATAREVPROF,'D'));
l_oWv.setValue('DATAPROF',WtA(w_DATAPROF,'D'));
l_oWv.setValue('CODOGG',WtA(w_CODOGG,'C'));
l_oWv.setValue('IBAN',WtA(w_IBAN,'C'));
l_oWv.setValue('NOCANC',WtA(w_NOCANC,'N'));
l_oWv.setValue('ISOAGE',WtA(w_ISOAGE,'C'));
l_oWv.setValue('descval',WtA(w_descval,'C'));
l_oWv.setValue('daticoll',WtA(w_daticoll,'N'));
l_oWv.setValue('xdescmodsvo',WtA(w_xdescmodsvo,'C'));
l_oWv.setValue('xdescareag',WtA(w_xdescareag,'C'));
l_oWv.setValue('xdescplauso',WtA(w_xdescplauso,'C'));
l_oWv.setValue('xdesctipor',WtA(w_xdesctipor,'C'));
l_oWv.setValue('xdescfreq',WtA(w_xdescfreq,'C'));
l_oWv.setValue('xdescammo',WtA(w_xdescammo,'C'));
l_oWv.setValue('gTelepass',WtA(w_gTelepass,'C'));
l_oWv.setValue('gBrowser',WtA(w_gBrowser,'C'));
l_oWv.setValue('gCodDip',WtA(w_gCodDip,'C'));
l_oWv.setValue('xDESDIPE',WtA(w_xDESDIPE,'C'));
l_oWv.setValue('xMADESCRI',WtA(w_xMADESCRI,'C'));
l_oWv.setValue('xRAGLEG',WtA(w_xRAGLEG,'C'));
l_oWv.setValue('xC5DESCRI',WtA(w_xC5DESCRI,'C'));
l_oWv.setValue('xC4DESCRI',WtA(w_xC4DESCRI,'C'));
l_oWv.setValue('xC3DESCRI',WtA(w_xC3DESCRI,'C'));
l_oWv.setValue('xC2DESCRI',WtA(w_xC2DESCRI,'C'));
l_oWv.setValue('xC1DESCRI',WtA(w_xC1DESCRI,'C'));
l_oWv.setValue('gTipInter',WtA(w_gTipInter,'C'));
l_oWv.setValue('titolo',WtA(w_titolo,'C'));
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
_FillChildren.n=['ardt_xarantbo'];
FillWv.n=["RAPPORTO","DESCRAP","TIPORAP","FLAGLIRE","VALUTA","TIPOAG","NOPROT","PRGIMPRAP","DURAT","RFREQ","AMMONT","RIMP","AREAGEO","RAREA","MODSVOL","RCOMP","RAGIO","RRAGIO","TIPO","RTIPO","CODDIP","CODDIPE","SPLITCODE","MACODICE","CODICELR","MITIG","MITGDOC","CATEG01","CATEG02","CATEG03","CATEG04","CATEG05","CATEGORIA","NATURA","SCOPO","RISGLOB","DATAREVPROF","DATAPROF","CODOGG","IBAN","NOCANC","ISOAGE","descval","daticoll","xdescmodsvo","xdescareag","xdescplauso","xdesctipor","xdescfreq","xdescammo","gTelepass","gBrowser","gCodDip","xDESDIPE","xMADESCRI","xRAGLEG","xC5DESCRI","xC4DESCRI","xC3DESCRI","xC2DESCRI","xC1DESCRI","gTipInter","titolo"];
function SetModified() {
m_bUpdated=true;
}
function SetChildVariables_ardt_xarantbo() {
}
function CtxLoad_ardt_xarantbo() {
if (ChildToLoad(FrameRef('ardt_xarantbo'))) {
return [LoadContext(0,'ZSYGOPYXSA'),'ardt_xarantbo'];
}
}
