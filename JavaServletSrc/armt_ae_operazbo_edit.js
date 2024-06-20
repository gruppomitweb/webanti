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
function DisplayErrorMessage_ardt_sogopeprov() {
if ( ! (ChildToLoad(FrameRef('ardt_sogopeprov'))) && Ne(typeof(FrameRef('ardt_sogopeprov').DisplayErrorMessage),'undefined')) {
FrameRef('ardt_sogopeprov').DisplayErrorMessage();
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
l_bEnabled= ! (Eq(w_FLAGFRAZ,'2')) || IsDisabledByStateDriver('COLLEG');
SetDisabled('FBSFGXGZYT',l_bEnabled);
l_bEnabled= ! (Eq(w_FLAGCONT,'1')) || IsDisabledByStateDriver('xTOTCONT');
SetDisabled('IRQOQMDUXA',l_bEnabled);
l_bEnabled= ! ( ! (Empty(LRTrim(w_CONNESOPER)))) || IsDisabledByStateDriver('PAGASOGOP');
SetDisabled('KSFGUUJEFK',l_bEnabled);
l_bEnabled= ! (Empty(w_CODVOC)) || IsDisabledByStateDriver('SEGNO');
SetDisabled('VEGGMIUHSD',l_bEnabled);
if (IsDisabledByStateDriver('box_HGYWQIUORJ')) {
DisableInputsInContainer(Ctrl('HGYWQIUORJ'),true);
}
if (IsDisabledByStateDriver('box_OXJSQGZIYF')) {
DisableInputsInContainer(Ctrl('OXJSQGZIYF'),true);
}
if (IsDisabledByStateDriver('box_YDQEMCWVGS')) {
DisableInputsInContainer(Ctrl('YDQEMCWVGS'),true);
}
if (IsDisabledByStateDriver('box_YSUXVYPEKQ')) {
DisableInputsInContainer(Ctrl('YSUXVYPEKQ'),true);
}
if (IsDisabledByStateDriver('box_VNNYTOBGNA')) {
DisableInputsInContainer(Ctrl('VNNYTOBGNA'),true);
}
if (IsDisabledByStateDriver('box_ANGGVVFTIZ')) {
DisableInputsInContainer(Ctrl('ANGGVVFTIZ'),true);
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
if (IsDisabledByStateDriver('AGE')) {
DisableInputsInContainer(Ctrl('EOKCAXCLZO'),true);
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
SetObligatory(Ctrl('IRQOQMDUXA'),Eq(w_FLAGCONT,'1') || IsObligatoryByStateDriver('xTOTCONT'));
SetObligatory(Ctrl('GRXZUKZAYO'), ! (Empty(w_CONNESOPER)) || IsObligatoryByStateDriver('TIPOLEG'));
SetObligatory(Ctrl('AWPNTOJIRR'),Ne(At(w_CODVOC,'|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M'),0) || IsObligatoryByStateDriver('C_RAG'));
SetObligatory(Ctrl('YVIKEGPYPM'),Ne(At(w_CODVOC,'|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M'),0) || IsObligatoryByStateDriver('C_STA'));
SetObligatory(Ctrl('BUGJZOCZYH'),Ne(At(w_CODVOC,'|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M'),0) || IsObligatoryByStateDriver('TIPOINT2'));
SetObligatory(Ctrl('ABKVYRXWAV'),Ne(At(w_CODVOC,'|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M'),0) && Empty(w_CODINT2) || IsObligatoryByStateDriver('DESCINTER'));
SetObligatory(Ctrl('GYOQKYEVYP'),Ne(At(w_CODVOC,'|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M'),0) || IsObligatoryByStateDriver('PAESE'));
SetObligatory(Ctrl('LCQKOYRNRT'),Ne(At(w_CODVOC,'|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M'),0) && Eq(w_xFLGITAEST,'I') || IsObligatoryByStateDriver('CODCAB2'));
SetObligatory(Ctrl('QQJJGKCSOY'),Ne(At(w_CODVOC,'|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M'),0) && Eq(w_xFLGITAEST,'I') || IsObligatoryByStateDriver('PROV2'));
SetObligatory(Ctrl('WUSGSRXDMA'),Ne(At(w_CODVOC,'|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M'),0) && Eq(w_xFLGITAEST,'I') || IsObligatoryByStateDriver('DESC2'));
}
function SetDynamicClasses() {
var c;
}
function SetDynamicTooltip() {
var c;
if(c=Ctrl('QHEJZYDDEZ')) c.title=Strtran(AlertErrorMessage('11419545353',w_FLAGFRAZ),'\\n',"\n");
if(c=Ctrl('KGJJECFNIC')) c.title=Strtran(AlertErrorMessage('1148775685',w_TIPOOPRAP),'\\n',"\n");
if(c=Ctrl('XXKGUCJQWE')) c.title=Strtran(AlertErrorMessage('191062270',w_FLAGLIRE),'\\n',"\n");
if(c=Ctrl('YGFXODFVYI')) c.title=Strtran(AlertErrorMessage('11710831322',w_VALUTA),'\\n',"\n");
if(c=Ctrl('GHDJLBOEYX')) c.title=Strtran(AlertErrorMessage('2070114244',w_FLAGCONT),'\\n',"\n");
if(c=Ctrl('GRXZUKZAYO')) c.title=Strtran(AlertErrorMessage('340709450',w_TIPOLEG),'\\n',"\n");
if(c=Ctrl('BUGJZOCZYH')) c.title=Strtran(AlertErrorMessage('10464441821',w_TIPOINT2),'\\n',"\n");
if(c=Ctrl('KXEUVNBTBC')) c.title=Strtran(AlertErrorMessage('11446531735',w_xDescDipe),'\\n',"\n");
if(c=Ctrl('WHSKCSNYYO')) c.title=Strtran(AlertErrorMessage('11655443642',w_desccauana),'\\n',"\n");
if(c=Ctrl('NALNLPMPAE')) c.title=Strtran(AlertErrorMessage('10703819256',w_xdesccausin),'\\n',"\n");
}
function Set_DATAOPE(ctrlValue,kmode,e) {
if (Ne(w_DATAOPE,ctrlValue)) {
var ctl = _GetCtl(e,'DHPABFMAHC');
if (_tracker.goon(ctl,ctrlValue)) {
w_DATAOPE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
var l_bWarn = true;
l_bResult=_ChkObl('DHPABFMAHC',0);
if (l_bResult) {
l_bResult=Ge(w_DATAREG,w_DATAOPE);
if ( ! (l_bResult)) {
m_nLastError=2;
m_cLastWorkVarErrorMsg='829201110';
m_cLastMsgError=AlertErrorMessage('12128708791');
}
if (l_bResult && ( ! (Le(DateDiff(w_DATAOPE,w_DATAREG),30)) && Ne(m_nLastError,-2))) {
try {
_tracker.askwrn=true;
l_bWarn=WindowConfirm(AlertErrorMessage('11887010137'));
} finally {
_tracker.askwrn=false;
}
}
if ( ! (l_bResult) ||  ! (l_bWarn)) {
w_DATAOPE=HtW('','D');
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
function Set_FLAGFRAZ(ctrlValue,kmode,e) {
if (Ne(w_FLAGFRAZ,ctrlValue)) {
var ctl = _GetCtl(e,'QHEJZYDDEZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLAGFRAZ=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QHEJZYDDEZ',0);
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
function Set_COLLEG(ctrlValue,kmode,e) {
if (Ne(w_COLLEG,ctrlValue)) {
var ctl = _GetCtl(e,'FBSFGXGZYT');
if (_tracker.goon(ctl,ctrlValue)) {
w_COLLEG=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FBSFGXGZYT',0);
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
function Set_TIPOOPRAP(ctrlValue,kmode,e) {
if (Ne(w_TIPOOPRAP,ctrlValue)) {
var ctl = _GetCtl(e,'KGJJECFNIC');
if (_tracker.goon(ctl,ctrlValue)) {
w_TIPOOPRAP=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('KGJJECFNIC',0);
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
var ctl = _GetCtl(e,'UTKMIHOWMH');
if (_tracker.goon(ctl,ctrlValue)) {
w_CODANA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UTKMIHOWMH',0);
if (l_bResult) {
l_bResult=Link_UTKMIHOWMH(kmode);
if ( ! (Empty(w_CODVOC))) {
Link_JFTTTRWQFB(kmode);
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
var ctl = _GetCtl(e,'JFTTTRWQFB');
if (_tracker.goon(ctl,ctrlValue)) {
w_CODVOC=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('JFTTTRWQFB',0);
if (l_bResult) {
l_bResult=Link_JFTTTRWQFB(kmode);
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
function Set_appolire(ctrlValue,kmode,e) {
if (Ne(w_appolire,ctrlValue)) {
var ctl = _GetCtl(e,'XXKGUCJQWE');
if (_tracker.goon(ctl,ctrlValue)) {
w_appolire=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XXKGUCJQWE',0);
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
var ctl = _GetCtl(e,'YGFXODFVYI');
if (_tracker.goon(ctl,ctrlValue)) {
w_VALUTA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YGFXODFVYI',0);
if (l_bResult) {
l_bResult=Link_YGFXODFVYI(kmode);
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
var ctl = _GetCtl(e,'PIXUNJHQQK');
if (_tracker.goon(ctl,ctrlValue)) {
w_xTOTLIRE=ValidNum(ctrlValue,'999999999999.99');
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
var l_bWarn = true;
l_bResult=_ChkObl('PIXUNJHQQK',0);
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
SPBOUILib.SetInputValue('PIXUNJHQQK',function(){return WtH(w_xTOTLIRE,'N',15,2,'999,999,999,999.99')},w_xTOTLIRE);
}
return true;
}
function Set_FLAGCONT(ctrlValue,kmode,e) {
if (Ne(w_FLAGCONT,ctrlValue)) {
var ctl = _GetCtl(e,'GHDJLBOEYX');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLAGCONT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('GHDJLBOEYX',0);
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
var ctl = _GetCtl(e,'IRQOQMDUXA');
if (_tracker.goon(ctl,ctrlValue)) {
w_xTOTCONT=ValidNum(ctrlValue,'999999999999.99');
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
var l_bWarn = true;
l_bResult=_ChkObl('IRQOQMDUXA',0);
if (l_bResult) {
if (l_bResult && ( ! (arfn_chktotalelire_cont(w_DATAOPE,w_datpaseuro,w_xTOTCONT,w_xTOTLIRE)) && Ne(m_nLastError,-2))) {
try {
_tracker.askwrn=true;
l_bWarn=WindowConfirm(AlertErrorMessage('11525797640'));
} finally {
_tracker.askwrn=false;
}
}
if ( ! (l_bResult) ||  ! (l_bWarn)) {
w_xTOTCONT=HtW('','N');
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
SPBOUILib.SetInputValue('IRQOQMDUXA',function(){return WtH(w_xTOTCONT,'N',15,2,'999,999,999,999.99')},w_xTOTCONT);
}
return true;
}
function Set_CAMBIO(ctrlValue,kmode,e) {
if (Ne(w_CAMBIO,ctrlValue)) {
var ctl = _GetCtl(e,'AQSPNMQSXA');
if (_tracker.goon(ctl,ctrlValue)) {
w_CAMBIO=ValidNum(ctrlValue,'9999.9999');
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('AQSPNMQSXA',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('AQSPNMQSXA',function(){return WtH(w_CAMBIO,'N',9,4,'9999.9999')},w_CAMBIO);
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
var ctl = _GetCtl(e,'HLPFLQLILN');
if (_tracker.goon(ctl,ctrlValue)) {
w_RAPPORTO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HLPFLQLILN',0);
if (l_bResult) {
l_bResult=Link_HLPFLQLILN(kmode);
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
var ctl = _GetCtl(e,'MLQSWPUYXK');
if (_tracker.goon(ctl,ctrlValue)) {
w_CONNESCLI=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
var l_bWarn = true;
l_bResult=_ChkObl('MLQSWPUYXK',0);
if (l_bResult) {
l_bResult=Link_MLQSWPUYXK(kmode);
if (l_bResult && ( ! (arfn_chkdatdoc(w_CONNESCLI,SystemDate())) && Ne(m_nLastError,-2))) {
try {
_tracker.askwrn=true;
l_bWarn=WindowConfirm(AlertErrorMessage('11525797640'));
} finally {
_tracker.askwrn=false;
}
if ( ! (l_bWarn)) {
Link_MLQSWPUYXK_Blank();
}
}
if ( ! (l_bResult) ||  ! (l_bWarn)) {
w_CONNESCLI=HtW('','C');
}
}
if (l_bResult &&  ! (Check_FBYJKRFVBE(false))) {
m_cLastWorkVarError='FBYJKRFVBE';
if ( ! (Eq(m_nLastError,-3))) {
m_nLastError=2;
}
l_bResult=false;
}
DoUpdate(l_bResult);
if ( ! (l_bResult) ||  ! (l_bWarn)) {
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
function Set_CONNESOPER(ctrlValue,kmode,e) {
if (Ne(w_CONNESOPER,ctrlValue)) {
var ctl = _GetCtl(e,'JHLWBNTKPL');
if (_tracker.goon(ctl,ctrlValue)) {
w_CONNESOPER=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
var l_bWarn = true;
l_bResult=_ChkObl('JHLWBNTKPL',0);
if (l_bResult) {
l_bResult=Link_JHLWBNTKPL(kmode);
if (l_bResult && ( ! (arfn_chkdatdoc(w_CONNESOPER,SystemDate())) && Ne(m_nLastError,-2))) {
try {
_tracker.askwrn=true;
l_bWarn=WindowConfirm(AlertErrorMessage('11525797640'));
} finally {
_tracker.askwrn=false;
}
if ( ! (l_bWarn)) {
Link_JHLWBNTKPL_Blank();
}
}
if ( ! (l_bResult) ||  ! (l_bWarn)) {
w_CONNESOPER=HtW('','C');
}
}
if (l_bResult &&  ! (Check_DUNXKFRTPZ(false))) {
m_cLastWorkVarError='DUNXKFRTPZ';
if ( ! (Eq(m_nLastError,-3))) {
m_nLastError=2;
}
l_bResult=false;
}
DoUpdate(l_bResult);
if ( ! (l_bResult) ||  ! (l_bWarn)) {
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
var ctl = _GetCtl(e,'GRXZUKZAYO');
if (_tracker.goon(ctl,ctrlValue)) {
w_TIPOLEG=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('GRXZUKZAYO',0);
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
var ctl = _GetCtl(e,'KSFGUUJEFK');
if (_tracker.goon(ctl,ctrlValue)) {
w_PAGASOGOP=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('KSFGUUJEFK',0);
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
var ctl = _GetCtl(e,'SYIIMUFSEQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_CONNESBEN=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SYIIMUFSEQ',0);
if (l_bResult) {
l_bResult=Link_SYIIMUFSEQ(kmode);
if ( ! (l_bResult)) {
w_CONNESBEN=HtW('','C');
}
}
if (l_bResult &&  ! (Check_CSHBHPWJQE(false))) {
m_cLastWorkVarError='CSHBHPWJQE';
if ( ! (Eq(m_nLastError,-3))) {
m_nLastError=2;
}
l_bResult=false;
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
var ctl = _GetCtl(e,'JVSBAIMQUS');
if (_tracker.goon(ctl,ctrlValue)) {
w_CONNALTRO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
var l_bWarn = true;
l_bResult=_ChkObl('JVSBAIMQUS',0);
if (l_bResult) {
l_bResult=Link_JVSBAIMQUS(kmode);
if (l_bResult && ( ! (arfn_chkdatdoc(w_CONNALTRO,w_DATAOPE)) && Ne(m_nLastError,-2))) {
try {
_tracker.askwrn=true;
l_bWarn=WindowConfirm(AlertErrorMessage('11525797640'));
} finally {
_tracker.askwrn=false;
}
if ( ! (l_bWarn)) {
Link_JVSBAIMQUS_Blank();
}
}
if ( ! (l_bResult) ||  ! (l_bWarn)) {
w_CONNALTRO=HtW('','C');
}
}
if (l_bResult &&  ! (Check_ZZBVRHATAX(false))) {
m_cLastWorkVarError='ZZBVRHATAX';
if ( ! (Eq(m_nLastError,-3))) {
m_nLastError=2;
}
l_bResult=false;
}
DoUpdate(l_bResult);
if ( ! (l_bResult) ||  ! (l_bWarn)) {
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
var ctl = _GetCtl(e,'BUGJZOCZYH');
if (_tracker.goon(ctl,ctrlValue)) {
w_TIPOINT2=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BUGJZOCZYH',0);
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
var ctl = _GetCtl(e,'NUZRBZHLLM');
if (_tracker.goon(ctl,ctrlValue)) {
w_CODINT2=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NUZRBZHLLM',0);
if (l_bResult) {
l_bResult=Link_NUZRBZHLLM(kmode);
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
var ctl = _GetCtl(e,'ABKVYRXWAV');
if (_tracker.goon(ctl,ctrlValue)) {
w_DESCINTER=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ABKVYRXWAV',0);
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
var ctl = _GetCtl(e,'GYOQKYEVYP');
if (_tracker.goon(ctl,ctrlValue)) {
w_PAESE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('GYOQKYEVYP',0);
if (l_bResult) {
l_bResult=Link_GYOQKYEVYP(kmode);
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
var ctl = _GetCtl(e,'LCQKOYRNRT');
if (_tracker.goon(ctl,ctrlValue)) {
w_CODCAB2=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('LCQKOYRNRT',0);
if (l_bResult) {
l_bResult=Link_LCQKOYRNRT(kmode);
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
var ctl = _GetCtl(e,'QQJJGKCSOY');
if (_tracker.goon(ctl,ctrlValue)) {
w_PROV2=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QQJJGKCSOY',0);
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
var ctl = _GetCtl(e,'WUSGSRXDMA');
if (_tracker.goon(ctl,ctrlValue)) {
w_DESC2=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('WUSGSRXDMA',0);
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
var ctl = _GetCtl(e,'EPRSQUBPGF');
if (_tracker.goon(ctl,ctrlValue)) {
w_ZCPARTE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('EPRSQUBPGF',0);
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
var ctl = _GetCtl(e,'YPYBCLFHOV');
if (_tracker.goon(ctl,ctrlValue)) {
w_IDBASE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YPYBCLFHOV',0);
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
function Set_CODDIPE(ctrlValue,kmode,e) {
if (Ne(w_CODDIPE,ctrlValue)) {
var ctl = _GetCtl(e,'KXEUVNBTBC');
if (_tracker.goon(ctl,ctrlValue)) {
w_CODDIPE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('KXEUVNBTBC',0);
if (l_bResult) {
l_bResult=Link_KXEUVNBTBC(kmode);
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
function Set_SEGNO(ctrlValue,kmode,e) {
if (Ne(w_SEGNO,ctrlValue)) {
var ctl = _GetCtl(e,'VEGGMIUHSD');
if (_tracker.goon(ctl,ctrlValue)) {
w_SEGNO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VEGGMIUHSD',0);
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
function Set_DATARETT(ctrlValue,kmode,e) {
if (Ne(w_DATARETT,ctrlValue)) {
var ctl = _GetCtl(e,'IGFDIUZEOQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_DATARETT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('IGFDIUZEOQ',0);
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
function Set_INFORM(ctrlValue,kmode,e) {
if (Ne(w_INFORM,ctrlValue)) {
var ctl = _GetCtl(e,'KDWBJNGUTK');
if (_tracker.goon(ctl,ctrlValue)) {
w_INFORM=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('KDWBJNGUTK',0);
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
var ctl = _GetCtl(e,'VMRTFBBQHL');
if (_tracker.goon(ctl,ctrlValue)) {
w_RESPINS=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VMRTFBBQHL',0);
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
var ctl = _GetCtl(e,'LEHLEQRJPH');
if (_tracker.goon(ctl,ctrlValue)) {
w_NOPROT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('LEHLEQRJPH',0);
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
function Set_IMPOUT(ctrlValue,kmode,e) {
if (Ne(w_IMPOUT,ctrlValue)) {
var ctl = _GetCtl(e,'DPCGXWDECV');
if (_tracker.goon(ctl,ctrlValue)) {
w_IMPOUT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('DPCGXWDECV',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','N',15,2,'');
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
function Set_OPERAG(ctrlValue,kmode,e) {
if (Ne(w_OPERAG,ctrlValue)) {
var ctl = _GetCtl(e,'QEFXECTWSF');
if (_tracker.goon(ctl,ctrlValue)) {
w_OPERAG=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QEFXECTWSF',0);
if (l_bResult) {
l_bResult=Link_QEFXECTWSF(kmode);
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
function Set_IMPIN(ctrlValue,kmode,e) {
if (Ne(w_IMPIN,ctrlValue)) {
var ctl = _GetCtl(e,'YXAKYHSWPW');
if (_tracker.goon(ctl,ctrlValue)) {
w_IMPIN=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YXAKYHSWPW',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','N',15,2,'');
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
w_FLAGLIRE=arfn_calcflaglire(w_DATAOPE,w_appolire,w_datpaseuro);
if ((Ne(o_FLAGLIRE,w_FLAGLIRE))) {
w_appolire=(Eq(w_FLAGLIRE,'1') || Eq(w_FLAGLIRE,'7')?'L':(Eq(w_FLAGLIRE,'3') || Eq(w_FLAGLIRE,'5') || Empty(w_FLAGLIRE)?'E':'V'));
}
if ((Ne(o_CDATOPE,w_CDATOPE)) || (Ne(o_filtro,w_filtro))) {
RenderDynamicCombo('GRXZUKZAYO');
}
if ((Ne(o_C_CTA,w_C_CTA))) {
l_bTmpRes=Link_YVIKEGPYPM(null);
}
if ((Ne(o_CODINT2,w_CODINT2))) {
l_bTmpRes=Link_GYOQKYEVYP(null);
}
if ((Ne(o_CODINT2,w_CODINT2))) {
l_bTmpRes=Link_LCQKOYRNRT(null);
}
UpdateAutonumber('IDBASE');
UpdateAutonumber('NUMPROG');
w_CODINTER=w_gIntemediario;
l_bTmpRes=Link_ZUFPYFWAFU(null);
w_tipope='1';
w_TIPOINF='1';
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
w_CDATREG=DateToChar(w_DATAREG);
if ((Ne(o_CONNESBEN,w_CONNESBEN))) {
Calculation_LNKPNNFRDI();
}
w_ANNOOPE=Year(w_DATAOPE);
if ((Ne(o_DATAOPE,w_DATAOPE))) {
Calculation_ISMPZVVNVG();
}
if ((Ne(o_FLAGFRAZ,w_FLAGFRAZ))) {
Calculation_QVHNBGPIFC();
}
LibJavascript.forEachItem(m_FoundlingCopyWorkVar,i_body_1)
function i_body_1(child){
child();
}
// * --- Area Manuale = UI - Calculate
// * --- Fine Area Manuale
UpdateAutonumber('');
m_bCalculating=false;
if (l_bResult &&  ! (Check_CUIIXQPPLV(false)) && Ne(m_nLastError,-3)) {
setTimeout('WindowAlert('+LibJavascript.ToJSValue(AlertErrorMessage(m_cLastMsgError))+')',1);
l_bResult=false;
}
if (l_bResult &&  ! (Check_VTUPGRKHMU(false)) && Ne(m_nLastError,-3)) {
setTimeout('WindowAlert('+LibJavascript.ToJSValue(AlertErrorMessage(m_cLastMsgError))+')',1);
l_bResult=false;
}
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
function Calculation_ISMPZVVNVG() {
w_TIPOLEG=arfn_read_tipoleg(w_IDBASE,'OP');
}
function Calculation_QVHNBGPIFC() {
w_COLLEG=(Eq(w_FLAGFRAZ,'0')?'':w_COLLEG);
}
function Check_FBYJKRFVBE(p_bForce) {
var l_bResult = true;
if (p_bForce || Ne(o_CONNESCLI,w_CONNESCLI)) {
l_bResult=arfn_chksogg(w_CONNESCLI,'7');
if ( ! (l_bResult)) {
m_cLastMsgError=AlertErrorMessage('11525797640');
}
}
return l_bResult;
}
function Check_DUNXKFRTPZ(p_bForce) {
var l_bResult = true;
if (p_bForce || Ne(o_CONNESOPER,w_CONNESOPER)) {
l_bResult=arfn_chksogg(w_CONNESCLI,'8');
if ( ! (l_bResult) &&  ! (WindowConfirm(AlertErrorMessage('11525797640')))) {
m_nLastError=-3;
} else {
l_bResult=true;
}
}
return l_bResult;
}
function Check_CSHBHPWJQE(p_bForce) {
var l_bResult = true;
if (p_bForce || Ne(o_CONNESBEN,w_CONNESBEN)) {
l_bResult=arfn_chksogg(w_CONNESBEN,'5');
if ( ! (l_bResult) &&  ! (WindowConfirm(AlertErrorMessage('11525797640')))) {
m_nLastError=-3;
} else {
l_bResult=true;
}
}
return l_bResult;
}
function Check_ZZBVRHATAX(p_bForce) {
var l_bResult = true;
if (p_bForce || Ne(o_CONNALTRO,w_CONNALTRO)) {
l_bResult=arfn_chksogg(w_CONNALTRO,'9');
if ( ! (l_bResult) &&  ! (WindowConfirm(AlertErrorMessage('11525797640')))) {
m_nLastError=-3;
} else {
l_bResult=true;
}
}
return l_bResult;
}
function Check_CUIIXQPPLV(p_bForce) {
var l_bResult = true;
if (p_bForce || Ne(o_VALUTA,w_VALUTA) || Ne(o_appolire,w_appolire)) {
l_bResult=( ! (Empty(w_VALUTA)) &&  ! (Empty(w_appolire)) && Eq(w_appolire,'E')?Eq(w_VALUTA,'242'):true);
if ( ! (l_bResult) &&  ! (WindowConfirm(AlertErrorMessage('1729482089')))) {
m_nLastError=-3;
} else {
l_bResult=( ! (Empty(w_VALUTA)) &&  ! (Empty(w_appolire)) && Eq(w_appolire,'V')?Ne(w_VALUTA,'242'):true);
if ( ! (l_bResult) &&  ! (WindowConfirm(AlertErrorMessage('36480606')))) {
m_nLastError=-3;
} else {
l_bResult=true;
}
}
}
return l_bResult;
}
function Check_VTUPGRKHMU(p_bForce) {
var l_bResult = true;
if (p_bForce || Ne(o_SEGNO,w_SEGNO) || Ne(o_CODVOC,w_CODVOC) || Ne(o_TIPOOPRAP,w_TIPOOPRAP)) {
l_bResult=( ! (Empty(w_SEGNO)) &&  ! (Empty(w_TIPOOPRAP)) && (Eq(w_TIPOOPRAP,'12') || Eq(w_TIPOOPRAP,'18'))?Eq(w_SEGNO,'A'):true);
if ( ! (l_bResult) &&  ! (WindowConfirm(AlertErrorMessage('301347801')))) {
m_nLastError=-3;
} else {
l_bResult=( ! (Empty(w_SEGNO)) &&  ! (Empty(w_TIPOOPRAP)) && (Eq(w_TIPOOPRAP,'11') || Eq(w_TIPOOPRAP,'19'))?Eq(w_SEGNO,'D'):true);
if ( ! (l_bResult) &&  ! (WindowConfirm(AlertErrorMessage('11259116522')))) {
m_nLastError=-3;
} else {
l_bResult=true;
}
}
}
return l_bResult;
}
function SaveDependsOn() {
o_DATAOPE=w_DATAOPE;
o_CDATOPE=w_CDATOPE;
o_FLAGFRAZ=w_FLAGFRAZ;
o_TIPOOPRAP=w_TIPOOPRAP;
o_CODVOC=w_CODVOC;
o_FLAGLIRE=w_FLAGLIRE;
o_appolire=w_appolire;
o_VALUTA=w_VALUTA;
o_FLAGCONT=w_FLAGCONT;
o_RAPPORTO=w_RAPPORTO;
o_CONNESCLI=w_CONNESCLI;
o_filtro=w_filtro;
o_CONNESOPER=w_CONNESOPER;
o_CONNESBEN=w_CONNESBEN;
o_CONNALTRO=w_CONNALTRO;
o_C_CTA=w_C_CTA;
o_CODINT2=w_CODINT2;
o_CODINTER=w_CODINTER;
o_CODDIPE=w_CODDIPE;
o_SEGNO=w_SEGNO;
}
function SaveLabelDependsOn() {
}
function Link_UTKMIHOWMH(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CODANA);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODCAU',w_CODANA,4,0);
l_Appl.SetFields('CODCAU');
l_Appl.SetTypes('C');
l_Appl.LinkTable('tbcauana');
l_Appl.SetID('UTKMIHOWMH');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CODANA=l_Appl.GetStringValue('CODCAU',4,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_UTKMIHOWMH_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_UTKMIHOWMH';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_UTKMIHOWMH();
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
function Link_UTKMIHOWMH_Blank() {
w_CODANA='';
}
function LOpt_UTKMIHOWMH() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcauana','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODCAU','C'));
l_oWv.setValue('LinkedField',WtA('CODCAU','C'));
l_oWv.setValue('UID',WtA('UTKMIHOWMH','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['UTKMIHOWMH'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('282647084'),'C'));
l_oWv.setValue('ConfigName',WtA('cauinter','C'));
return l_oWv;
}
function Link_JFTTTRWQFB(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CODVOC);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODCAU',w_CODANA,4,0);
l_Appl.SetStringKey('CAUSINT',w_CODVOC,2,0);
l_Appl.SetFields('CAUSINT,SEGNO,DESCRI,FLGINTER');
l_Appl.SetTypes('C,C,C,C');
l_Appl.LinkTable('tbcauana');
l_Appl.SetID('JFTTTRWQFB');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CODVOC=l_Appl.GetStringValue('CAUSINT',2,0);
w_SEGNO=l_Appl.GetStringValue('SEGNO',1,0);
w_desccauana=l_Appl.GetStringValue('DESCRI',165,0);
w_xFLGITAEST=l_Appl.GetStringValue('FLGINTER',1,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_JFTTTRWQFB_Blank();
l_bResult=true;
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_JFTTTRWQFB';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_JFTTTRWQFB();
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
function Link_JFTTTRWQFB_Blank() {
w_SEGNO='';
w_desccauana='';
w_xFLGITAEST='';
}
function LOpt_JFTTTRWQFB() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcauana','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODCAU,CAUSINT','C'));
l_oWv.setValue('LinkedField',WtA('CAUSINT','C'));
l_oWv.setValue('UID',WtA('JFTTTRWQFB','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['JFTTTRWQFB'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('282420974'),'C'));
return l_oWv;
}
function Link_YGFXODFVYI(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_VALUTA);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODVAL',w_VALUTA,3,0);
l_Appl.SetFields('CODVAL,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbvalute');
l_Appl.SetID('YGFXODFVYI');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_VALUTA=l_Appl.GetStringValue('CODVAL',3,0);
w_descdiv=l_Appl.GetStringValue('DESCRI',30,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_YGFXODFVYI_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_YGFXODFVYI';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_YGFXODFVYI();
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
function Link_YGFXODFVYI_Blank() {
w_VALUTA='';
w_descdiv='';
}
function LOpt_YGFXODFVYI() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbvalute','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODVAL','C'));
l_oWv.setValue('LinkedField',WtA('CODVAL','C'));
l_oWv.setValue('UID',WtA('YGFXODFVYI','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['YGFXODFVYI'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('114016870'),'C'));
return l_oWv;
}
function Link_HLPFLQLILN(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_RAPPORTO);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('RAPPORTO',w_RAPPORTO,25,0);
l_Appl.SetFields('RAPPORTO,DESCRAP,TIPORAP');
l_Appl.SetTypes('C,C,C');
l_Appl.LinkTable('jnarapbo');
l_Appl.SetID('HLPFLQLILN');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_RAPPORTO=l_Appl.GetStringValue('RAPPORTO',25,0);
w_xdescrap=l_Appl.GetStringValue('DESCRAP',50,0);
w_FLAGRAP=l_Appl.GetStringValue('TIPORAP',1,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_HLPFLQLILN_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_HLPFLQLILN';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_HLPFLQLILN();
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
function Link_HLPFLQLILN_Blank() {
w_RAPPORTO='';
w_xdescrap='';
w_FLAGRAP='';
}
function LOpt_HLPFLQLILN() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('jnarapbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('RAPPORTO','C'));
l_oWv.setValue('LinkedField',WtA('RAPPORTO','C'));
l_oWv.setValue('UID',WtA('HLPFLQLILN','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['HLPFLQLILN'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('194410082'),'C'));
return l_oWv;
}
function Link_MLQSWPUYXK(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CONNESCLI);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CONNES',w_CONNESCLI,16,0);
l_Appl.SetFields('CONNES,RAGSOC,CODFISC,DATAVALI,DATARILASC');
l_Appl.SetTypes('C,C,C,D,D');
l_Appl.LinkTable('personbo');
l_Appl.SetID('MLQSWPUYXK');
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
Link_MLQSWPUYXK_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_MLQSWPUYXK';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_MLQSWPUYXK();
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
function Link_MLQSWPUYXK_Blank() {
w_CONNESCLI='';
w_xragsocper='';
w_xcodfisc='';
w_DATAVALI=NullDate();
w_DATARILASC=NullDate();
}
function LOpt_MLQSWPUYXK() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('personbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CONNES','C'));
l_oWv.setValue('LinkedField',WtA('CONNES','C'));
l_oWv.setValue('UID',WtA('MLQSWPUYXK','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['MLQSWPUYXK'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('1890893827'),'C'));
return l_oWv;
}
function Link_JHLWBNTKPL(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CONNESOPER);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CONNES',w_CONNESOPER,16,0);
l_Appl.SetFields('CONNES,RAGSOC');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('personbo');
l_Appl.SetID('JHLWBNTKPL');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CONNESOPER=l_Appl.GetStringValue('CONNES',16,0);
w_xragsocct=l_Appl.GetStringValue('RAGSOC',70,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_JHLWBNTKPL_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_JHLWBNTKPL';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_JHLWBNTKPL();
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
function Link_JHLWBNTKPL_Blank() {
w_CONNESOPER='';
w_xragsocct='';
}
function LOpt_JHLWBNTKPL() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('personbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CONNES','C'));
l_oWv.setValue('LinkedField',WtA('CONNES','C'));
l_oWv.setValue('UID',WtA('JHLWBNTKPL','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['JHLWBNTKPL'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('1890893827'),'C'));
return l_oWv;
}
function Link_SYIIMUFSEQ(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CONNESBEN);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CONNES',w_CONNESBEN,16,0);
l_Appl.SetFields('CONNES,RAGSOC');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('personbo');
l_Appl.SetID('SYIIMUFSEQ');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CONNESBEN=l_Appl.GetStringValue('CONNES',16,0);
w_xragsocben=l_Appl.GetStringValue('RAGSOC',70,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_SYIIMUFSEQ_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_SYIIMUFSEQ';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_SYIIMUFSEQ();
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
function Link_SYIIMUFSEQ_Blank() {
w_CONNESBEN='';
w_xragsocben='';
}
function LOpt_SYIIMUFSEQ() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('personbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CONNES','C'));
l_oWv.setValue('LinkedField',WtA('CONNES','C'));
l_oWv.setValue('UID',WtA('SYIIMUFSEQ','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['SYIIMUFSEQ'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('1890893827'),'C'));
return l_oWv;
}
function Link_JVSBAIMQUS(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CONNALTRO);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CONNES',w_CONNALTRO,16,0);
l_Appl.SetFields('CONNES,RAGSOC');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('personbo');
l_Appl.SetID('JVSBAIMQUS');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CONNALTRO=l_Appl.GetStringValue('CONNES',16,0);
w_xragsocalt=l_Appl.GetStringValue('RAGSOC',70,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_JVSBAIMQUS_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_JVSBAIMQUS';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_JVSBAIMQUS();
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
function Link_JVSBAIMQUS_Blank() {
w_CONNALTRO='';
w_xragsocalt='';
}
function LOpt_JVSBAIMQUS() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('personbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CONNES','C'));
l_oWv.setValue('LinkedField',WtA('CONNES','C'));
l_oWv.setValue('UID',WtA('JVSBAIMQUS','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['JVSBAIMQUS'][1],'C'));
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
function Link_NUZRBZHLLM(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CODINT2);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODINTER',w_CODINT2,11,0);
l_Appl.SetFields('CODINTER,RAGSOC,CODCAB,PROVINCIA,PAESE,TIPINTER');
l_Appl.SetTypes('C,C,C,C,C,C');
l_Appl.LinkTable('inter2bo');
l_Appl.SetID('NUZRBZHLLM');
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
Link_NUZRBZHLLM_Blank();
l_bResult=true;
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_NUZRBZHLLM';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_NUZRBZHLLM();
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
function Link_NUZRBZHLLM_Blank() {
w_DESCINTER='';
w_CODCAB2='';
w_PROV2='';
w_PAESE='';
w_TIPOINT2='';
}
function LOpt_NUZRBZHLLM() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('inter2bo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODINTER','C'));
l_oWv.setValue('LinkedField',WtA('CODINTER','C'));
l_oWv.setValue('UID',WtA('NUZRBZHLLM','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['NUZRBZHLLM'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('11424168249'),'C'));
return l_oWv;
}
function Link_GYOQKYEVYP(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_PAESE);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODSTA',w_PAESE,3,0);
l_Appl.SetFields('CODSTA,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbstati');
l_Appl.SetID('GYOQKYEVYP');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_PAESE=l_Appl.GetStringValue('CODSTA',3,0);
w_xdescpaese2=l_Appl.GetStringValue('DESCRI',30,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_GYOQKYEVYP_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_GYOQKYEVYP';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_GYOQKYEVYP();
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
function Link_GYOQKYEVYP_Blank() {
w_PAESE='';
w_xdescpaese2='';
}
function LOpt_GYOQKYEVYP() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstati','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODSTA','C'));
l_oWv.setValue('LinkedField',WtA('CODSTA','C'));
l_oWv.setValue('UID',WtA('GYOQKYEVYP','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['GYOQKYEVYP'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('7383187'),'C'));
return l_oWv;
}
function Link_LCQKOYRNRT(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CODCAB2);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CAB',w_CODCAB2,6,0);
l_Appl.SetFields('CAB,CITTA,PROV');
l_Appl.SetTypes('C,C,C');
l_Appl.LinkTable('tbcitta');
l_Appl.SetID('LCQKOYRNRT');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CODCAB2=l_Appl.GetStringValue('CAB',6,0);
w_DESC2=l_Appl.GetStringValue('CITTA',30,0);
w_PROV2=l_Appl.GetStringValue('PROV',2,0);
w_xdciticon=l_Appl.GetStringValue('CITTA',40,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_LCQKOYRNRT_Blank();
l_bResult=true;
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_LCQKOYRNRT';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_LCQKOYRNRT();
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
function Link_LCQKOYRNRT_Blank() {
w_DESC2='';
w_PROV2='';
w_xdciticon='';
}
function LOpt_LCQKOYRNRT() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcitta','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CAB','C'));
l_oWv.setValue('LinkedField',WtA('CAB','C'));
l_oWv.setValue('UID',WtA('LCQKOYRNRT','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['LCQKOYRNRT'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('15186643'),'C'));
return l_oWv;
}
function Link_ZUFPYFWAFU(kmode) {
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
l_Appl.SetID('ZUFPYFWAFU');
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
Link_ZUFPYFWAFU_Blank();
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
function Link_ZUFPYFWAFU_Blank() {
w_CODINTER='';
w_datpaseuro=NullDate();
w_CABINT='';
w_PROVINT='';
w_CITINT='';
}
function LOpt_ZUFPYFWAFU() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('intermbo','C'));
l_oWv.setValue('Linkzoomprg',WtA('armt_intermbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODINTER','C'));
l_oWv.setValue('LinkedField',WtA('CODINTER','C'));
l_oWv.setValue('UID',WtA('ZUFPYFWAFU','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['ZUFPYFWAFU'][1],'C'));
return l_oWv;
}
function Link_KXEUVNBTBC(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CODDIPE);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODDIP',w_CODDIPE,6,0);
l_Appl.SetFields('CODDIP,DESCRIZ,DESCCIT,PROVINCIA,CAB');
l_Appl.SetTypes('C,C,C,C,C');
l_Appl.LinkTable('anadip');
l_Appl.SetID('KXEUVNBTBC');
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
Link_KXEUVNBTBC_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_KXEUVNBTBC';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_KXEUVNBTBC();
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
function Link_KXEUVNBTBC_Blank() {
w_CODDIPE='';
w_xDescDipe='';
w_CITDIP='';
w_PROVDIP='';
w_CABDIP='';
}
function LOpt_KXEUVNBTBC() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('anadip','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODDIP','C'));
l_oWv.setValue('LinkedField',WtA('CODDIP','C'));
l_oWv.setValue('UID',WtA('KXEUVNBTBC','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['KXEUVNBTBC'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('1270140318'),'C'));
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
function Link_QEFXECTWSF(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_OPERAG);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODICE',w_OPERAG,3,0);
l_Appl.SetFields('CODICE,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbtipope');
l_Appl.SetID('QEFXECTWSF');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_OPERAG=l_Appl.GetStringValue('CODICE',3,0);
w_xdescopeage=l_Appl.GetStringValue('DESCRI',254,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_QEFXECTWSF_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_QEFXECTWSF';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_QEFXECTWSF();
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
function Link_QEFXECTWSF_Blank() {
w_OPERAG='';
w_xdescopeage='';
}
function LOpt_QEFXECTWSF() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbtipope','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODICE','C'));
l_oWv.setValue('LinkedField',WtA('CODICE','C'));
l_oWv.setValue('UID',WtA('QEFXECTWSF','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['QEFXECTWSF'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('103243324'),'C'));
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
l_Appl.SetStringKey('CODICE',w_TIPO,3,0);
l_Appl.SetFields('CODICE,DESCRI,RISCHIO');
l_Appl.SetTypes('C,C,N');
l_Appl.LinkTable('tbtiporisc');
l_Appl.SetID('DJOWYRMDDC');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_TIPO=l_Appl.GetStringValue('CODICE',3,0);
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
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'UTKMIHOWMH')) {
last_focused_comp=GetLastFocusedElementOfLink('UTKMIHOWMH');
function SetMethod_UTKMIHOWMH() {
Set_CODANA(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_UTKMIHOWMH();
} else {
setTimeout(SetMethod_UTKMIHOWMH,1);
}
bResult=true;
}
if (Eq(varName,'JFTTTRWQFB')) {
last_focused_comp=GetLastFocusedElementOfLink('JFTTTRWQFB');
function SetMethod_JFTTTRWQFB() {
Set_CODVOC(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_JFTTTRWQFB();
} else {
setTimeout(SetMethod_JFTTTRWQFB,1);
}
bResult=true;
}
if (Eq(varName,'YGFXODFVYI')) {
last_focused_comp=GetLastFocusedElementOfLink('YGFXODFVYI');
function SetMethod_YGFXODFVYI() {
Set_VALUTA(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_YGFXODFVYI();
} else {
setTimeout(SetMethod_YGFXODFVYI,1);
}
bResult=true;
}
if (Eq(varName,'HLPFLQLILN')) {
last_focused_comp=GetLastFocusedElementOfLink('HLPFLQLILN');
function SetMethod_HLPFLQLILN() {
Set_RAPPORTO(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_HLPFLQLILN();
} else {
setTimeout(SetMethod_HLPFLQLILN,1);
}
bResult=true;
}
if (Eq(varName,'MLQSWPUYXK')) {
last_focused_comp=GetLastFocusedElementOfLink('MLQSWPUYXK');
function SetMethod_MLQSWPUYXK() {
Set_CONNESCLI(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_MLQSWPUYXK();
} else {
setTimeout(SetMethod_MLQSWPUYXK,1);
}
bResult=true;
}
if (Eq(varName,'JHLWBNTKPL')) {
last_focused_comp=GetLastFocusedElementOfLink('JHLWBNTKPL');
function SetMethod_JHLWBNTKPL() {
Set_CONNESOPER(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_JHLWBNTKPL();
} else {
setTimeout(SetMethod_JHLWBNTKPL,1);
}
bResult=true;
}
if (Eq(varName,'SYIIMUFSEQ')) {
last_focused_comp=GetLastFocusedElementOfLink('SYIIMUFSEQ');
function SetMethod_SYIIMUFSEQ() {
Set_CONNESBEN(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_SYIIMUFSEQ();
} else {
setTimeout(SetMethod_SYIIMUFSEQ,1);
}
bResult=true;
}
if (Eq(varName,'JVSBAIMQUS')) {
last_focused_comp=GetLastFocusedElementOfLink('JVSBAIMQUS');
function SetMethod_JVSBAIMQUS() {
Set_CONNALTRO(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_JVSBAIMQUS();
} else {
setTimeout(SetMethod_JVSBAIMQUS,1);
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
if (Eq(varName,'NUZRBZHLLM')) {
last_focused_comp=GetLastFocusedElementOfLink('NUZRBZHLLM');
function SetMethod_NUZRBZHLLM() {
Set_CODINT2(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_NUZRBZHLLM();
} else {
setTimeout(SetMethod_NUZRBZHLLM,1);
}
bResult=true;
}
if (Eq(varName,'GYOQKYEVYP')) {
last_focused_comp=GetLastFocusedElementOfLink('GYOQKYEVYP');
function SetMethod_GYOQKYEVYP() {
Set_PAESE(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_GYOQKYEVYP();
} else {
setTimeout(SetMethod_GYOQKYEVYP,1);
}
bResult=true;
}
if (Eq(varName,'LCQKOYRNRT')) {
last_focused_comp=GetLastFocusedElementOfLink('LCQKOYRNRT');
function SetMethod_LCQKOYRNRT() {
Set_CODCAB2(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_LCQKOYRNRT();
} else {
setTimeout(SetMethod_LCQKOYRNRT,1);
}
bResult=true;
}
if (Eq(varName,'KXEUVNBTBC')) {
last_focused_comp=GetLastFocusedElementOfLink('KXEUVNBTBC');
function SetMethod_KXEUVNBTBC() {
Set_CODDIPE(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_KXEUVNBTBC();
} else {
setTimeout(SetMethod_KXEUVNBTBC,1);
}
bResult=true;
}
if (Eq(varName,'QEFXECTWSF')) {
last_focused_comp=GetLastFocusedElementOfLink('QEFXECTWSF');
function SetMethod_QEFXECTWSF() {
Set_OPERAG(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_QEFXECTWSF();
} else {
setTimeout(SetMethod_QEFXECTWSF,1);
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
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'UTKMIHOWMH')) {
return [Ctrl('UTKMIHOWMH')];
}
if (Eq(varName,'JFTTTRWQFB')) {
return [Ctrl('JFTTTRWQFB')];
}
if (Eq(varName,'YGFXODFVYI')) {
return [Ctrl('YGFXODFVYI')];
}
if (Eq(varName,'HLPFLQLILN')) {
return [Ctrl('HLPFLQLILN')];
}
if (Eq(varName,'MLQSWPUYXK')) {
return [Ctrl('MLQSWPUYXK')];
}
if (Eq(varName,'JHLWBNTKPL')) {
return [Ctrl('JHLWBNTKPL')];
}
if (Eq(varName,'SYIIMUFSEQ')) {
return [Ctrl('SYIIMUFSEQ')];
}
if (Eq(varName,'JVSBAIMQUS')) {
return [Ctrl('JVSBAIMQUS')];
}
if (Eq(varName,'ODAYKSRECA')) {
return [Ctrl('ODAYKSRECA')];
}
if (Eq(varName,'YVIKEGPYPM')) {
return [Ctrl('YVIKEGPYPM')];
}
if (Eq(varName,'NUZRBZHLLM')) {
return [Ctrl('NUZRBZHLLM')];
}
if (Eq(varName,'GYOQKYEVYP')) {
return [Ctrl('GYOQKYEVYP')];
}
if (Eq(varName,'LCQKOYRNRT')) {
return [Ctrl('LCQKOYRNRT')];
}
if (Eq(varName,'KXEUVNBTBC')) {
return [Ctrl('KXEUVNBTBC')];
}
if (Eq(varName,'QEFXECTWSF')) {
return [Ctrl('QEFXECTWSF')];
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
if (Eq(varName,'CKJQULDXKW')) {
return [Ctrl('CKJQULDXKW')];
}
if (Eq(varName,'SXTYCPHBIM')) {
return [Ctrl('SXTYCPHBIM')];
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
parent.ZtVWeb.raiseEventToEvalParms('armt_ae_operazbo_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('armt_ae_operazbo_dataNotSent',{'action':formaction});
}
}
}
}
CheckChild.child=[{'prg':"ardt_sogopeprov",'BOScId':function(){ return FrameRef('ardt_sogopeprov')},'repeated':0}];
function Check() {
var l_bResult = true;
var l_bChildCheck = true;
ResetErrorVars();
m_nLastError=0;
if (( ! (_ChkObl('DHPABFMAHC',1))) || ( ! (Ge(w_DATAREG,w_DATAOPE)))) {
_SignErr('DHPABFMAHC','12128708791');
l_bResult=false;
w_DATAOPE=HtW('','D');
} else if ( ! (_ChkObl('QHEJZYDDEZ',1))) {
_SignErr('QHEJZYDDEZ');
m_cLastWorkVarErrorMsg='1722199786';
l_bResult=false;
w_FLAGFRAZ=HtW('','C');
} else if ((Eq(w_FLAGFRAZ,'2')) && ( ! (_ChkObl('FBSFGXGZYT',1)))) {
_SignErr('FBSFGXGZYT');
m_cLastWorkVarErrorMsg='750412439';
l_bResult=false;
w_COLLEG=HtW('','C');
} else if ( ! (_ChkObl('KGJJECFNIC',1))) {
_SignErr('KGJJECFNIC');
m_cLastWorkVarErrorMsg='11137644647';
l_bResult=false;
w_TIPOOPRAP=HtW('','C');
} else if ( ! (_ChkObl('UTKMIHOWMH',1))) {
_SignErr('UTKMIHOWMH');
m_cLastWorkVarErrorMsg='215536597';
l_bResult=false;
w_CODANA=HtW('','C');
} else if ( ! (_ChkObl('JFTTTRWQFB',1))) {
_SignErr('JFTTTRWQFB');
m_cLastWorkVarErrorMsg='215310487';
l_bResult=false;
w_CODVOC=HtW('','C');
} else if ( ! (_ChkObl('XXKGUCJQWE',1))) {
_SignErr('XXKGUCJQWE');
m_cLastWorkVarErrorMsg='10126883135';
l_bResult=false;
w_appolire=HtW('','C');
} else if ( ! (_ChkObl('YGFXODFVYI',1))) {
_SignErr('YGFXODFVYI');
m_cLastWorkVarErrorMsg='10849117717';
l_bResult=false;
w_VALUTA=HtW('','C');
} else if ( ! (_ChkObl('PIXUNJHQQK',1))) {
_SignErr('PIXUNJHQQK');
m_cLastWorkVarErrorMsg='502956915';
l_bResult=false;
w_xTOTLIRE=HtW('','N');
} else if ( ! (_ChkObl('GHDJLBOEYX',1))) {
_SignErr('GHDJLBOEYX');
m_cLastWorkVarErrorMsg='237632211';
l_bResult=false;
w_FLAGCONT=HtW('','C');
} else if ((Eq(w_FLAGCONT,'1')) && ( ! (_ChkObl('IRQOQMDUXA',1)))) {
_SignErr('IRQOQMDUXA');
m_cLastWorkVarErrorMsg='616535110';
l_bResult=false;
w_xTOTCONT=HtW('','N');
} else if ( ! (_ChkObl('AQSPNMQSXA',1))) {
_SignErr('AQSPNMQSXA');
m_cLastWorkVarErrorMsg='123704147';
l_bResult=false;
w_CAMBIO=HtW('','N');
} else if ( ! (_ChkObl('HLPFLQLILN',1))) {
_SignErr('HLPFLQLILN');
m_cLastWorkVarErrorMsg='10379997930';
l_bResult=false;
w_RAPPORTO=HtW('','C');
} else if ( ! (_ChkObl('MLQSWPUYXK',1))) {
_SignErr('MLQSWPUYXK');
m_cLastWorkVarErrorMsg='10219814530';
l_bResult=false;
w_CONNESCLI=HtW('','C');
} else if ( ! (_ChkObl('JHLWBNTKPL',1))) {
_SignErr('JHLWBNTKPL');
m_cLastWorkVarErrorMsg='10219814530';
l_bResult=false;
w_CONNESOPER=HtW('','C');
} else if ( ! (_ChkObl('GRXZUKZAYO',1))) {
_SignErr('GRXZUKZAYO');
m_cLastWorkVarErrorMsg='10639118571';
l_bResult=false;
w_TIPOLEG=HtW('','C');
} else if (( ! (Empty(LRTrim(w_CONNESOPER)))) && ( ! (_ChkObl('KSFGUUJEFK',1)))) {
_SignErr('KSFGUUJEFK');
m_cLastWorkVarErrorMsg='PAGASOGOP';
l_bResult=false;
w_PAGASOGOP='N';
} else if ( ! (_ChkObl('SYIIMUFSEQ',1))) {
_SignErr('SYIIMUFSEQ');
m_cLastWorkVarErrorMsg='10219814530';
l_bResult=false;
w_CONNESBEN=HtW('','C');
} else if ( ! (_ChkObl('JVSBAIMQUS',1))) {
_SignErr('JVSBAIMQUS');
m_cLastWorkVarErrorMsg='CONNALTRO';
l_bResult=false;
w_CONNALTRO=HtW('','C');
} else if ( ! (_ChkObl('AWPNTOJIRR',1))) {
_SignErr('AWPNTOJIRR');
m_cLastWorkVarErrorMsg='1284129730';
l_bResult=false;
w_C_RAG=HtW('','C');
} else if ( ! (_ChkObl('ODAYKSRECA',1))) {
_SignErr('ODAYKSRECA');
m_cLastWorkVarErrorMsg='1410438055';
l_bResult=false;
w_C_CTA=HtW('','C');
} else if ( ! (_ChkObl('NOTZPDMYIA',1))) {
_SignErr('NOTZPDMYIA');
m_cLastWorkVarErrorMsg='1637276170';
l_bResult=false;
w_C_PRV=HtW('','C');
} else if ( ! (_ChkObl('RDAVOEETJG',1))) {
_SignErr('RDAVOEETJG');
m_cLastWorkVarErrorMsg='11141557209';
l_bResult=false;
w_C_CAP=HtW('','C');
} else if ( ! (_ChkObl('BOTAJBWHHY',1))) {
_SignErr('BOTAJBWHHY');
m_cLastWorkVarErrorMsg='11085000424';
l_bResult=false;
w_C_CAB=HtW('','C');
} else if ( ! (_ChkObl('VYLHWTRQNX',1))) {
_SignErr('VYLHWTRQNX');
m_cLastWorkVarErrorMsg='11835283726';
l_bResult=false;
w_C_IND=HtW('','C');
} else if ( ! (_ChkObl('YVIKEGPYPM',1))) {
_SignErr('YVIKEGPYPM');
m_cLastWorkVarErrorMsg='728888873';
l_bResult=false;
w_C_STA=HtW('','C');
} else if ( ! (_ChkObl('BUGJZOCZYH',1))) {
_SignErr('BUGJZOCZYH');
m_cLastWorkVarErrorMsg='11628231202';
l_bResult=false;
w_TIPOINT2=HtW('','C');
} else if ( ! (_ChkObl('NUZRBZHLLM',1))) {
_SignErr('NUZRBZHLLM');
m_cLastWorkVarErrorMsg='10455298077';
l_bResult=false;
w_CODINT2=HtW('','C');
} else if ( ! (_ChkObl('ABKVYRXWAV',1))) {
_SignErr('ABKVYRXWAV');
m_cLastWorkVarErrorMsg='1663847547';
l_bResult=false;
w_DESCINTER=HtW('','C');
} else if ( ! (_ChkObl('GYOQKYEVYP',1))) {
_SignErr('GYOQKYEVYP');
m_cLastWorkVarErrorMsg='1108605666';
l_bResult=false;
w_PAESE=HtW('','C');
} else if ( ! (_ChkObl('YBNJCVPDUM',1))) {
_SignErr('YBNJCVPDUM');
m_cLastWorkVarErrorMsg='C_RAPPORTO';
l_bResult=false;
w_C_RAPPORTO=HtW('','C');
} else if ( ! (_ChkObl('LCQKOYRNRT',1))) {
_SignErr('LCQKOYRNRT');
m_cLastWorkVarErrorMsg='12135010165';
l_bResult=false;
w_CODCAB2=HtW('','C');
} else if ( ! (_ChkObl('QQJJGKCSOY',1))) {
_SignErr('QQJJGKCSOY');
m_cLastWorkVarErrorMsg='11135066302';
l_bResult=false;
w_PROV2=HtW('','C');
} else if ( ! (_ChkObl('WUSGSRXDMA',1))) {
_SignErr('WUSGSRXDMA');
m_cLastWorkVarErrorMsg='10166248752';
l_bResult=false;
w_DESC2=HtW('','C');
} else if ( ! (_ChkObl('EPRSQUBPGF',1))) {
_SignErr('EPRSQUBPGF');
m_cLastWorkVarErrorMsg='ZCPARTE';
l_bResult=false;
w_ZCPARTE=HtW('','C');
} else if ( ! (_ChkObl('YPYBCLFHOV',1))) {
_SignErr('YPYBCLFHOV');
m_cLastWorkVarErrorMsg='113866889';
l_bResult=false;
w_IDBASE=HtW('','C');
} else if ( ! (_ChkObl('KXEUVNBTBC',1))) {
_SignErr('KXEUVNBTBC');
m_cLastWorkVarErrorMsg='2071283709';
l_bResult=false;
w_CODDIPE=HtW('','C');
} else if ((Empty(w_CODVOC)) && ( ! (_ChkObl('VEGGMIUHSD',1)))) {
_SignErr('VEGGMIUHSD');
m_cLastWorkVarErrorMsg='7753123';
l_bResult=false;
w_SEGNO=HtW('','C');
} else if ( ! (_ChkObl('IGFDIUZEOQ',1))) {
_SignErr('IGFDIUZEOQ');
m_cLastWorkVarErrorMsg='11329559720';
l_bResult=false;
w_DATARETT=HtW('','D');
} else if ( ! (_ChkObl('YXAKYHSWPW',1))) {
_SignErr('YXAKYHSWPW');
m_cLastWorkVarErrorMsg='7070950';
l_bResult=false;
w_IMPIN=HtW('','N');
} else if ( ! (_ChkObl('DPCGXWDECV',1))) {
_SignErr('DPCGXWDECV');
m_cLastWorkVarErrorMsg='643948227';
l_bResult=false;
w_IMPOUT=HtW('','N');
} else if ( ! (_ChkObl('QEFXECTWSF',1))) {
_SignErr('QEFXECTWSF');
m_cLastWorkVarErrorMsg='OPERAG';
l_bResult=false;
w_OPERAG=HtW('','C');
} else if ( ! (_ChkObl('LEHLEQRJPH',1))) {
_SignErr('LEHLEQRJPH');
m_cLastWorkVarErrorMsg='NOPROT';
l_bResult=false;
w_NOPROT=0;
} else if ( ! (_ChkObl('VMRTFBBQHL',1))) {
_SignErr('VMRTFBBQHL');
m_cLastWorkVarErrorMsg='RESPINS';
l_bResult=false;
w_RESPINS=HtW('','C');
} else if ( ! (_ChkObl('KDWBJNGUTK',1))) {
_SignErr('KDWBJNGUTK');
m_cLastWorkVarErrorMsg='INFORM';
l_bResult=false;
w_INFORM=HtW('','C');
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
} else if ( ! (_ChkObl('QJSTZIPOQB',1))) {
_SignErr('QJSTZIPOQB');
m_cLastWorkVarErrorMsg='AREAGEO';
l_bResult=false;
w_AREAGEO=HtW('','C');
} else if ( ! (_ChkObl('SFFFOYOWNH',1))) {
_SignErr('SFFFOYOWNH');
m_cLastWorkVarErrorMsg='MODSVOL';
l_bResult=false;
w_MODSVOL=HtW('','C');
} else if ( ! (_ChkObl('NOBMPHKVTX',1))) {
_SignErr('NOBMPHKVTX');
m_cLastWorkVarErrorMsg='RAGIO';
l_bResult=false;
w_RAGIO=HtW('','C');
} else if ( ! (_ChkObl('DJOWYRMDDC',1))) {
_SignErr('DJOWYRMDDC');
m_cLastWorkVarErrorMsg='TIPO';
l_bResult=false;
w_TIPO=HtW('','C');
} else if ( ! (_ChkObl('UDAYHICPVB',1))) {
_SignErr('UDAYHICPVB');
m_cLastWorkVarErrorMsg='RAREA';
l_bResult=false;
w_RAREA=HtW('','N');
} else if ( ! (_ChkObl('ETALZDRBSO',1))) {
_SignErr('ETALZDRBSO');
m_cLastWorkVarErrorMsg='RCOMP';
l_bResult=false;
w_RCOMP=HtW('','N');
} else if ( ! (_ChkObl('QBTVZDKLCO',1))) {
_SignErr('QBTVZDKLCO');
m_cLastWorkVarErrorMsg='RRAGIO';
l_bResult=false;
w_RRAGIO=HtW('','N');
} else if ( ! (_ChkObl('RUWEXWJASG',1))) {
_SignErr('RUWEXWJASG');
m_cLastWorkVarErrorMsg='RTIPO';
l_bResult=false;
w_RTIPO=HtW('','N');
} else if ( ! (_ChkObl('MXYTQLATHC',1))) {
_SignErr('MXYTQLATHC');
m_cLastWorkVarErrorMsg='RFREQ';
l_bResult=false;
w_RFREQ=HtW('','N');
} else if ( ! (_ChkObl('KBIUAXUDXA',1))) {
_SignErr('KBIUAXUDXA');
m_cLastWorkVarErrorMsg='RIMP';
l_bResult=false;
w_RIMP=HtW('','N');
} else if ( ! (_ChkObl('CKJQULDXKW',1))) {
_SignErr('CKJQULDXKW');
m_cLastWorkVarErrorMsg='DURAT';
l_bResult=false;
w_DURAT=HtW('','C');
} else if ( ! (_ChkObl('SXTYCPHBIM',1))) {
_SignErr('SXTYCPHBIM');
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
} else if ( ! (Check_FBYJKRFVBE(true))) {
l_bResult = false;
} else if ( ! (Check_DUNXKFRTPZ(true))) {
l_bResult = false;
} else if ( ! (Check_CSHBHPWJQE(true))) {
l_bResult = false;
} else if ( ! (Check_ZZBVRHATAX(true))) {
l_bResult = false;
} else if ( ! (Check_CUIIXQPPLV(true))) {
l_bResult = false;
} else if ( ! (Check_VTUPGRKHMU(true))) {
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
if (Eq('DHPABFMAHC_ZOOM',lc)) {
return 0;
}
if (Eq('UTKMIHOWMH_ZOOM',lc)) {
return 0;
}
if (Eq('UTKMIHOWMH',lc)) {
return 0;
}
if (Eq('JFTTTRWQFB_ZOOM',lc)) {
return 1;
}
if (Eq('JFTTTRWQFB',lc)) {
return 1;
}
if (Eq('HLPFLQLILN_ZOOM',lc)) {
return 2;
}
if (Eq('HLPFLQLILN',lc)) {
return 2;
}
if (Eq('MLQSWPUYXK_ZOOM',lc)) {
return 3;
}
if (Eq('MLQSWPUYXK',lc)) {
return 3;
}
if (Eq('JHLWBNTKPL_ZOOM',lc)) {
return 4;
}
if (Eq('JHLWBNTKPL',lc)) {
return 4;
}
if (Eq('SYIIMUFSEQ_ZOOM',lc)) {
return 5;
}
if (Eq('SYIIMUFSEQ',lc)) {
return 5;
}
if (Eq('JVSBAIMQUS_ZOOM',lc)) {
return 6;
}
if (Eq('JVSBAIMQUS',lc)) {
return 6;
}
if (Eq('ODAYKSRECA_ZOOM',lc)) {
return 7;
}
if (Eq('ODAYKSRECA',lc)) {
return 7;
}
if (Eq('YVIKEGPYPM_ZOOM',lc)) {
return 8;
}
if (Eq('YVIKEGPYPM',lc)) {
return 8;
}
if (Eq('NUZRBZHLLM_ZOOM',lc)) {
return 9;
}
if (Eq('NUZRBZHLLM',lc)) {
return 9;
}
if (Eq('GYOQKYEVYP_ZOOM',lc)) {
return 10;
}
if (Eq('GYOQKYEVYP',lc)) {
return 10;
}
if (Eq('LCQKOYRNRT_ZOOM',lc)) {
return 11;
}
if (Eq('LCQKOYRNRT',lc)) {
return 11;
}
if (Eq('KXEUVNBTBC_ZOOM',lc)) {
return 12;
}
if (Eq('KXEUVNBTBC',lc)) {
return 12;
}
if (Eq('QEFXECTWSF_ZOOM',lc)) {
return 13;
}
if (Eq('QEFXECTWSF',lc)) {
return 13;
}
if (Eq('QJSTZIPOQB_ZOOM',lc)) {
return 14;
}
if (Eq('QJSTZIPOQB',lc)) {
return 14;
}
if (Eq('SFFFOYOWNH_ZOOM',lc)) {
return 15;
}
if (Eq('SFFFOYOWNH',lc)) {
return 15;
}
if (Eq('NOBMPHKVTX_ZOOM',lc)) {
return 16;
}
if (Eq('NOBMPHKVTX',lc)) {
return 16;
}
if (Eq('DJOWYRMDDC_ZOOM',lc)) {
return 17;
}
if (Eq('DJOWYRMDDC',lc)) {
return 17;
}
if (Eq('CKJQULDXKW_ZOOM',lc)) {
return 18;
}
if (Eq('CKJQULDXKW',lc)) {
return 18;
}
if (Eq('SXTYCPHBIM_ZOOM',lc)) {
return 19;
}
if (Eq('SXTYCPHBIM',lc)) {
return 19;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_UTKMIHOWMH();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,1)) {
l_oWv=LOpt_JFTTTRWQFB();
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
l_oWv=LOpt_HLPFLQLILN();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,3)) {
l_oWv=LOpt_MLQSWPUYXK();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,4)) {
l_oWv=LOpt_JHLWBNTKPL();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,5)) {
l_oWv=LOpt_SYIIMUFSEQ();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,6)) {
l_oWv=LOpt_JVSBAIMQUS();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,7)) {
l_oWv=LOpt_ODAYKSRECA();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,8)) {
l_oWv=LOpt_YVIKEGPYPM();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,9)) {
l_oWv=LOpt_NUZRBZHLLM();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,10)) {
l_oWv=LOpt_GYOQKYEVYP();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,11)) {
l_oWv=LOpt_LCQKOYRNRT();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,12)) {
l_oWv=LOpt_KXEUVNBTBC();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,13)) {
l_oWv=LOpt_QEFXECTWSF();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,14)) {
l_oWv=LOpt_QJSTZIPOQB();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,15)) {
l_oWv=LOpt_SFFFOYOWNH();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,16)) {
l_oWv=LOpt_NOBMPHKVTX();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,17)) {
l_oWv=LOpt_DJOWYRMDDC();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,18)) {
l_oWv=LOpt_CKJQULDXKW();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,19)) {
l_oWv=LOpt_SXTYCPHBIM();
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
l_oWv.setValue('DATARETT',WtA(w_DATARETT,'D'));
l_oWv.setValue('PROVINCIA',WtA(w_PROVINCIA,'C'));
l_oWv.setValue('CODCAB',WtA(w_CODCAB,'C'));
l_oWv.setValue('TOTLIRE',WtA(w_TOTLIRE,'N'));
l_oWv.setValue('TOTCONT',WtA(w_TOTCONT,'N'));
l_oWv.setValue('TIPOINF',WtA(w_TIPOINF,'C'));
l_oWv.setValue('IDEREG',WtA(w_IDEREG,'C'));
l_oWv.setValue('FLAGRAP',WtA(w_FLAGRAP,'C'));
l_oWv.setValue('OPRAP',WtA(w_OPRAP,'C'));
l_oWv.setValue('OPERAZMOD',WtA(w_OPERAZMOD,'C'));
l_oWv.setValue('RAPPORTBEN',WtA(w_RAPPORTBEN,'C'));
l_oWv.setValue('OPERATORE',WtA(w_OPERATORE,'C'));
l_oWv.setValue('AUTOM',WtA(w_AUTOM,'C'));
l_oWv.setValue('FLAGRAP2',WtA(w_FLAGRAP2,'C'));
l_oWv.setValue('STATOREG',WtA(w_STATOREG,'C'));
l_oWv.setValue('PRGIMPOPE',WtA(w_PRGIMPOPE,'N'));
l_oWv.setValue('op_PRGIMPOPE',WtA(op_PRGIMPOPE,'N'));
l_oWv.setValue('CDATAOPE',WtA(w_CDATAOPE,'C'));
l_oWv.setValue('CONNESDOC',WtA(w_CONNESDOC,'C'));
l_oWv.setValue('CDATREG',WtA(w_CDATREG,'C'));
l_oWv.setValue('ANNOOPE',WtA(w_ANNOOPE,'N'));
l_oWv.setValue('IMPIN',WtA(w_IMPIN,'N'));
l_oWv.setValue('IMPOUT',WtA(w_IMPOUT,'N'));
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
l_oWv.setValue('MITIG',WtA(w_MITIG,'N'));
l_oWv.setValue('MITGDOC',WtA(w_MITGDOC,'C'));
l_oWv.setValue('xdescmodsvo',WtA(w_xdescmodsvo,'C'));
l_oWv.setValue('xdescareag',WtA(w_xdescareag,'C'));
l_oWv.setValue('xdescplauso',WtA(w_xdescplauso,'C'));
l_oWv.setValue('xdesctipor',WtA(w_xdesctipor,'C'));
l_oWv.setValue('xdescopeage',WtA(w_xdescopeage,'C'));
l_oWv.setValue('xdescfreq',WtA(w_xdescfreq,'C'));
l_oWv.setValue('xdescammo',WtA(w_xdescammo,'C'));
l_oWv.setValue('appolire',WtA(w_appolire,'C'));
l_oWv.setValue('xTOTLIRE',WtA(w_xTOTLIRE,'N'));
l_oWv.setValue('xTOTCONT',WtA(w_xTOTCONT,'N'));
l_oWv.setValue('filtro',WtA(w_filtro,'C'));
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
l_oWv.setValue('gSblocco',WtA(w_gSblocco,'C'));
l_oWv.setValue('xcodfisc',WtA(w_xcodfisc,'C'));
l_oWv.setValue('dataoggi',WtA(w_dataoggi,'D'));
l_oWv.setValue('stringaflagrap2',WtA(w_stringaflagrap2,'C'));
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
l_oWv.setValue('DATAVALI',WtA(w_DATAVALI,'D'));
l_oWv.setValue('DATARILASC',WtA(w_DATARILASC,'D'));
l_oWv.setValue('gFlgDTP',WtA(w_gFlgDTP,'N'));
l_oWv.setValue('xFLGITAEST',WtA(w_xFLGITAEST,'C'));
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
_FillChildren.n=['ardt_sogopeprov'];
FillWv.n=["DATAOPE","CDATOPE","DATAREG","FLAGFRAZ","COLLEG","TIPOOPRAP","CODANA","CODVOC","FLAGLIRE","VALUTA","FLAGCONT","CAMBIO","RAPPORTO","CONNESCLI","CONNESOPER","TIPOLEG","PAGASOGOP","CONNESBEN","CONNALTRO","C_RAG","C_CTA","C_PRV","C_CAP","C_CAB","C_IND","C_STA","TIPOINT2","CODINT2","DESCINTER","PAESE","C_RAPPORTO","CODCAB2","PROV2","DESC2","ZCPARTE","IDBASE","NUMPROG","CODINTER","CODDIPE","DESCCIT","SEGNO","DATARETT","PROVINCIA","CODCAB","TOTLIRE","TOTCONT","TIPOINF","IDEREG","FLAGRAP","OPRAP","OPERAZMOD","RAPPORTBEN","OPERATORE","AUTOM","FLAGRAP2","STATOREG","PRGIMPOPE","CDATAOPE","CONNESDOC","CDATREG","ANNOOPE","IMPIN","IMPOUT","OPERAG","NOPROT","RESPINS","INFORM","NATURA","SCOPO","AREAGEO","MODSVOL","RAGIO","TIPO","RAREA","RCOMP","RRAGIO","RTIPO","RFREQ","RIMP","DURAT","AMMONT","MITIG","MITGDOC","xdescmodsvo","xdescareag","xdescplauso","xdesctipor","xdescopeage","xdescfreq","xdescammo","appolire","xTOTLIRE","xTOTCONT","filtro","tipope","gIntemediario","xdes1","desccauana","xdesccausin","descdiv","xragsocper","xdescrap","xragsocct","xragsocben","xdestipleg","xragint2","xdescpaese2","datpaseuro","xDescDipe","sEdit","gChkDate","errmsg","test","valflg2","gTipInter","gSblocco","xcodfisc","dataoggi","stringaflagrap2","gDataVaria","gStatus","CITINT","CITDIP","PROVDIP","CABDIP","PROVINT","CABINT","gFlgDoc","xtiporap","dessta","xragsocalt","xdciticon","gFlgWU","DATAVALI","DATARILASC","gFlgDTP","xFLGITAEST"];
function SetModified() {
m_bUpdated=true;
}
function SetChildVariables_ardt_sogopeprov() {
}
function CtxLoad_ardt_sogopeprov() {
if (ChildToLoad(FrameRef('ardt_sogopeprov'))) {
return [LoadContext(0,'TQDGESLQVD'),'ardt_sogopeprov'];
}
}
