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
function DisplayErrorMessage_ardt_sogope() {
if ( ! (ChildToLoad(FrameRef('ardt_sogope'))) && Ne(typeof(FrameRef('ardt_sogope').DisplayErrorMessage),'undefined')) {
FrameRef('ardt_sogope').DisplayErrorMessage();
}
}
function DisplayErrorMessage_ardt_clientiope() {
if ( ! (ChildToLoad(FrameRef('ardt_clientiope'))) && Ne(typeof(FrameRef('ardt_clientiope').DisplayErrorMessage),'undefined')) {
FrameRef('ardt_clientiope').DisplayErrorMessage();
}
}
function DisplayErrorMessage_ardt_mlientiope() {
if ( ! (ChildToLoad(FrameRef('ardt_mlientiope'))) && Ne(typeof(FrameRef('ardt_mlientiope').DisplayErrorMessage),'undefined')) {
FrameRef('ardt_mlientiope').DisplayErrorMessage();
}
}
function DisplayErrorMessage_ardt_mogopebo() {
if ( ! (ChildToLoad(FrameRef('ardt_mogopebo'))) && Ne(typeof(FrameRef('ardt_mogopebo').DisplayErrorMessage),'undefined')) {
FrameRef('ardt_mogopebo').DisplayErrorMessage();
}
}
function DisplayErrorMessage_ardt_beneficope() {
if ( ! (ChildToLoad(FrameRef('ardt_beneficope'))) && Ne(typeof(FrameRef('ardt_beneficope').DisplayErrorMessage),'undefined')) {
FrameRef('ardt_beneficope').DisplayErrorMessage();
}
}
function DisplayErrorMessage_ardt_meneficope() {
if ( ! (ChildToLoad(FrameRef('ardt_meneficope'))) && Ne(typeof(FrameRef('ardt_meneficope').DisplayErrorMessage),'undefined')) {
FrameRef('ardt_meneficope').DisplayErrorMessage();
}
}
function DisplayErrorMessage_ardt_terzistiope() {
if ( ! (ChildToLoad(FrameRef('ardt_terzistiope'))) && Ne(typeof(FrameRef('ardt_terzistiope').DisplayErrorMessage),'undefined')) {
FrameRef('ardt_terzistiope').DisplayErrorMessage();
}
}
function DisplayErrorMessage_ardt_merzistiope() {
if ( ! (ChildToLoad(FrameRef('ardt_merzistiope'))) && Ne(typeof(FrameRef('ardt_merzistiope').DisplayErrorMessage),'undefined')) {
FrameRef('ardt_merzistiope').DisplayErrorMessage();
}
}
function DisplayErrorMessage_ardt_rapcoll() {
if ( ! (ChildToLoad(FrameRef('ardt_rapcoll'))) && Ne(typeof(FrameRef('ardt_rapcoll').DisplayErrorMessage),'undefined')) {
FrameRef('ardt_rapcoll').DisplayErrorMessage();
}
}
function DisplayErrorMessage_ardt_docopebo() {
if ( ! (ChildToLoad(FrameRef('ardt_docopebo'))) && Ne(typeof(FrameRef('ardt_docopebo').DisplayErrorMessage),'undefined')) {
FrameRef('ardt_docopebo').DisplayErrorMessage();
}
}
function DisplayErrorMessage_armt_operazbo_agg() {
if ( ! (ChildToLoad(FrameRef('armt_operazbo_agg'))) && Ne(typeof(FrameRef('armt_operazbo_agg').DisplayErrorMessage),'undefined')) {
FrameRef('armt_operazbo_agg').DisplayErrorMessage();
}
}
function DisplayErrorMessage_ardt_ope_contante() {
if ( ! (ChildToLoad(FrameRef('ardt_ope_contante'))) && Ne(typeof(FrameRef('ardt_ope_contante').DisplayErrorMessage),'undefined')) {
FrameRef('ardt_ope_contante').DisplayErrorMessage();
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
SetDisabled('OEIKQOZMYJ',l_bEnabled);
l_bEnabled= ! (Eq(w_FLAGCONT,'1')) || IsDisabledByStateDriver('xTOTCONT');
SetDisabled('CTORYEJVDR',l_bEnabled);
l_bEnabled= ! ( ! (Empty(LRTrim(w_CONNESOPER)))) || IsDisabledByStateDriver('PAGASOGOP');
SetDisabled('JGKMKQMAHS',l_bEnabled);
l_bEnabled= ! (false) || IsDisabledByStateDriver('STATOREG');
SetDisabled('OJXGBVSJHY',l_bEnabled);
l_bEnabled= ! (false) || IsDisabledByStateDriver('DATARETT');
SetDisabled('VYBZEWHKFF',l_bEnabled);
if (IsDisabledByStateDriver('DatiOperazione')) {
DisableInputsInContainer(Ctrl('YORQOIOBQN'),true);
}
if (IsDisabledByStateDriver('DatiCambiaSV')) {
DisableInputsInContainer(Ctrl('ANGGVVFTIZ'),true);
}
if (IsDisabledByStateDriver('DatiSoggetti')) {
DisableInputsInContainer(Ctrl('XLSSDAVPDH'),true);
}
if (IsDisabledByStateDriver('DatiControparte')) {
DisableInputsInContainer(Ctrl('ZPEPXLSZFA'),true);
}
if (IsDisabledByStateDriver('DatiIntermediarioControparte')) {
DisableInputsInContainer(Ctrl('YIVWPEZXIF'),true);
}
if (IsDisabledByStateDriver('DatiRettifiche')) {
DisableInputsInContainer(Ctrl('KURTXQHCYE'),true);
}
if (IsDisabledByStateDriver('Intermediario')) {
DisableInputsInContainer(Ctrl('BOYWPGJEEZ'),true);
}
if (IsDisabledByStateDriver('Intermediario2')) {
DisableInputsInContainer(Ctrl('HNGGJVVCNB'),true);
}
if (IsDisabledByStateDriver('AltriIntestatari')) {
DisableInputsInContainer(Ctrl('BDZUATYPMW'),true);
}
if (IsDisabledByStateDriver('Intestatari Operazioni diverso da statoreg 3')) {
DisableInputsInContainer(Ctrl('KYBHVGCEJO'),true);
}
if (IsDisabledByStateDriver('Intestatari Operazioni uguale a statoreg 3')) {
DisableInputsInContainer(Ctrl('XVSFEWJZNA'),true);
}
if (IsDisabledByStateDriver('AltriEsecutori')) {
DisableInputsInContainer(Ctrl('ZYUUSRMPQG'),true);
}
if (IsDisabledByStateDriver('Soggetti Agenti per Conto Oper. diverso da statoreg 3')) {
DisableInputsInContainer(Ctrl('XJNRVUSEVC'),true);
}
if (IsDisabledByStateDriver('Soggetti Agenti per Conto Oper. uguale a statoreg 3')) {
DisableInputsInContainer(Ctrl('UZFRPBBNAH'),true);
}
if (IsDisabledByStateDriver('Intermediario3')) {
DisableInputsInContainer(Ctrl('OGJVIBRWWZ'),true);
}
if (IsDisabledByStateDriver('AltriControparti')) {
DisableInputsInContainer(Ctrl('GTSBULOFTD'),true);
}
if (IsDisabledByStateDriver('AltriSogTerzi diverso da statoreg 3')) {
DisableInputsInContainer(Ctrl('DOUBCEKLZK'),true);
}
if (IsDisabledByStateDriver('AltriSogTerzi uguale da statoreg 3')) {
DisableInputsInContainer(Ctrl('HTFNVDSDLI'),true);
}
if (IsDisabledByStateDriver('AltriSogTerzi')) {
DisableInputsInContainer(Ctrl('BHLGNNSXQY'),true);
}
if (IsDisabledByStateDriver('AltriSogTerzi diverso da statoreg 3')) {
DisableInputsInContainer(Ctrl('QNQPIPOVDE'),true);
}
if (IsDisabledByStateDriver('AltriSogTerzi uguale da statoreg 3')) {
DisableInputsInContainer(Ctrl('WNXNBDZSBN'),true);
}
if (IsDisabledByStateDriver('Rapporto')) {
DisableInputsInContainer(Ctrl('CNRNAIMNZQ'),true);
}
if (IsDisabledByStateDriver('Intermediario4')) {
DisableInputsInContainer(Ctrl('QVDUCHDNOK'),true);
}
if (IsDisabledByStateDriver('Internet')) {
DisableInputsInContainer(Ctrl('JTWNGHDSFX'),true);
}
if (IsDisabledByStateDriver('AGE')) {
DisableInputsInContainer(Ctrl('EOKCAXCLZO'),true);
}
if (IsDisabledByStateDriver('SV')) {
DisableInputsInContainer(Ctrl('VVOVGLWTVP'),true);
}
if (IsDisabledByStateDriver('AltriDati')) {
DisableInputsInContainer(Ctrl('SNFGHIZMTZ'),true);
}
if (IsDisabledByStateDriver('Contante_Gen')) {
DisableInputsInContainer(Ctrl('LLZCQSNQZL'),true);
}
if (IsDisabledByStateDriver('OAM')) {
DisableInputsInContainer(Ctrl('OXFXXISYUL'),true);
}
if (IsDisabledByStateDriver('Intermediario5')) {
DisableInputsInContainer(Ctrl('DGEGXTAAOU'),true);
}
if (IsDisabledByStateDriver('Documenti')) {
DisableInputsInContainer(Ctrl('JELGAQOYWT'),true);
}
if (IsDisabledByStateDriver('IIIDirettiva')) {
DisableInputsInContainer(Ctrl('GMMLWYVNPO'),true);
}
if (IsDisabledByStateDriver('Mitigazione')) {
DisableInputsInContainer(Ctrl('UFFFOVKFCE'),true);
}
if (IsDisabledByStateDriver('Categorie')) {
DisableInputsInContainer(Ctrl('YUNLBUHYXD'),true);
}
if (IsDisabledByStateDriver('Intermediario6')) {
DisableInputsInContainer(Ctrl('LTVRVTUQAX'),true);
}
if (IsDisabledByStateDriver('Intermediario7')) {
DisableInputsInContainer(Ctrl('ZNJDPRVLQK'),true);
}
if (IsDisabledByStateDriver('Contante')) {
DisableInputsInContainer(Ctrl('SBYZBTFYWZ'),true);
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
SetObligatory(Ctrl('CTORYEJVDR'),Eq(w_FLAGCONT,'1') || IsObligatoryByStateDriver('xTOTCONT'));
SetObligatory(Ctrl('AQSAREJVST'), ! (Empty(w_CONNESOPER)) || IsObligatoryByStateDriver('TIPOLEG'));
SetObligatory(Ctrl('AWPNTOJIRR'),(w_COMPLETA?Ne(At(w_CODVOC,'|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R'),0):false) || IsObligatoryByStateDriver('C_RAG'));
SetObligatory(Ctrl('YVIKEGPYPM'),(w_COMPLETA?Ne(At(w_CODVOC,'|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R'),0):false) || IsObligatoryByStateDriver('C_STA'));
SetObligatory(Ctrl('HNMYJPHSQN'),Ne(At(w_CODVOC,'|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R'),0) && w_CALCOLI || IsObligatoryByStateDriver('TIPOINT2'));
SetObligatory(Ctrl('VYDRMHACRY'),Ne(At(w_CODVOC,'|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R'),0) && Empty(w_CODINT2) && Eq(w_gVerSim,'N') && w_CALCOLI || IsObligatoryByStateDriver('DESCINTER'));
SetObligatory(Ctrl('NYRJHOZOON'),Ne(At(w_CODVOC,'|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R'),0) && w_CALCOLI || IsObligatoryByStateDriver('PAESE'));
SetObligatory(Ctrl('YQINIDXZSL'),Ne(At(w_CODVOC,'|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R'),0) && Eq(w_xFLGITAEST,'I') && w_CALCOLI || IsObligatoryByStateDriver('CODCAB2'));
SetObligatory(Ctrl('FFCAGQAZHK'),Ne(At(w_CODVOC,'|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R'),0) && Eq(w_xFLGITAEST,'I') && w_CALCOLI || IsObligatoryByStateDriver('DESC2'));
SetObligatory(Ctrl('ACAPFGYRVI'),Ne(At(w_CODVOC,'|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R'),0) && Eq(w_xFLGITAEST,'I') && w_CALCOLI || IsObligatoryByStateDriver('PROV2'));
}
function SetDynamicClasses() {
var c;
}
function SetDynamicTooltip() {
var c;
if(c=Ctrl('AVHTGZTOSZ')) c.title=Strtran(AlertErrorMessage('11446531735',w_xDescDipe),'\\n',"\n");
if(c=Ctrl('QSRYXQJCBZ')) c.title=Strtran(AlertErrorMessage('11419545353',w_FLAGFRAZ),'\\n',"\n");
if(c=Ctrl('UJRFWINIVQ')) c.title=Strtran(AlertErrorMessage('1148775685',w_TIPOOPRAP),'\\n',"\n");
if(c=Ctrl('LJBMCCABSS')) c.title=Strtran(AlertErrorMessage('191062270',w_FLAGLIRE),'\\n',"\n");
if(c=Ctrl('MKCXJZEKIG')) c.title=Strtran(AlertErrorMessage('11710831322',w_VALUTA),'\\n',"\n");
if(c=Ctrl('AQSAREJVST')) c.title=Strtran(AlertErrorMessage('340709450',w_TIPOLEG),'\\n',"\n");
if(c=Ctrl('HNMYJPHSQN')) c.title=Strtran(AlertErrorMessage('10464441821',w_TIPOINT2),'\\n',"\n");
if(c=Ctrl('WDLBZTAAWH')) c.title=Strtran(AlertErrorMessage('11655443642',w_desccauana),'\\n',"\n");
if(c=Ctrl('BPBCTQXMMG')) c.title=Strtran(AlertErrorMessage('10703819256',w_xdesccausin),'\\n',"\n");
}
function Set_MITIGDOC(ctrlValue,kmode,e) {
if (Ne(w_MITIGDOC,ctrlValue)) {
var ctl = _GetCtl(e,'OXGBDTWKSX');
if (_tracker.goon(ctl,ctrlValue)) {
w_MITIGDOC=ctrlValue;
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
function Set_TIPO(ctrlValue,kmode,e) {
if (Ne(w_TIPO,ctrlValue)) {
var ctl = _GetCtl(e,'DJOWYRMDDC');
if (_tracker.goon(ctl,ctrlValue)) {
w_TIPO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XSVOIKCEKR',0);
if (l_bResult) {
if ( ! (l_bResult)) {
w_TIPO=HtW('','C');
}
}
l_bResult=l_bResult && _ChkObl('DJOWYRMDDC',0);
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
function Set_RAGIO(ctrlValue,kmode,e) {
if (Ne(w_RAGIO,ctrlValue)) {
var ctl = _GetCtl(e,'NOBMPHKVTX');
if (_tracker.goon(ctl,ctrlValue)) {
w_RAGIO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NVHOMNEASH',0);
if (l_bResult) {
if ( ! (l_bResult)) {
w_RAGIO=HtW('','C');
}
}
l_bResult=l_bResult && _ChkObl('NOBMPHKVTX',0);
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
function Set_MODSVOL(ctrlValue,kmode,e) {
if (Ne(w_MODSVOL,ctrlValue)) {
var ctl = _GetCtl(e,'SFFFOYOWNH');
if (_tracker.goon(ctl,ctrlValue)) {
w_MODSVOL=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VZKBEOYRRK',0);
if (l_bResult) {
if ( ! (l_bResult)) {
w_MODSVOL=HtW('','C');
}
}
l_bResult=l_bResult && _ChkObl('SFFFOYOWNH',0);
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
function Set_AREAGEO(ctrlValue,kmode,e) {
if (Ne(w_AREAGEO,ctrlValue)) {
var ctl = _GetCtl(e,'QJSTZIPOQB');
if (_tracker.goon(ctl,ctrlValue)) {
w_AREAGEO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UXDPSYOTRU',0);
if (l_bResult) {
if ( ! (l_bResult)) {
w_AREAGEO=HtW('','C');
}
}
l_bResult=l_bResult && _ChkObl('QJSTZIPOQB',0);
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
function Set_AMMONT(ctrlValue,kmode,e) {
if (Ne(w_AMMONT,ctrlValue)) {
var ctl = _GetCtl(e,'SXTYCPHBIM');
if (_tracker.goon(ctl,ctrlValue)) {
w_AMMONT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ASETEUZIOS',0);
if (l_bResult) {
if ( ! (l_bResult)) {
w_AMMONT=HtW('','C');
}
}
l_bResult=l_bResult && _ChkObl('SXTYCPHBIM',0);
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
function Set_DURAT(ctrlValue,kmode,e) {
if (Ne(w_DURAT,ctrlValue)) {
var ctl = _GetCtl(e,'CKJQULDXKW');
if (_tracker.goon(ctl,ctrlValue)) {
w_DURAT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VMVNJQLPEN',0);
if (l_bResult) {
if ( ! (l_bResult)) {
w_DURAT=HtW('','C');
}
}
l_bResult=l_bResult && _ChkObl('CKJQULDXKW',0);
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
function Set_SV58550MA(ctrlValue,kmode,e) {
if (Ne(w_SV58550MA,ctrlValue)) {
var ctl = _GetCtl(e,'MDVEMSKFNR');
if (_tracker.goon(ctl,ctrlValue)) {
w_SV58550MA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MDVEMSKFNR',0);
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
function Set_SV58550(ctrlValue,kmode,e) {
if (Ne(w_SV58550,ctrlValue)) {
var ctl = _GetCtl(e,'SMZCOQAIDC');
if (_tracker.goon(ctl,ctrlValue)) {
w_SV58550=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SMZCOQAIDC',0);
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
function Set_DATAOPE(ctrlValue,kmode,e) {
if (Ne(w_DATAOPE,ctrlValue)) {
var ctl = _GetCtl(e,'YLIKFVPZJA');
if (_tracker.goon(ctl,ctrlValue)) {
w_DATAOPE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
var l_bWarn = true;
l_bResult=_ChkObl('YLIKFVPZJA',0);
if (l_bResult) {
l_bResult=(w_COMPLETA?Ge(w_DATAREG,w_DATAOPE):true);
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
function Set_STATOREG(ctrlValue,kmode,e) {
if (Ne(w_STATOREG,ctrlValue)) {
var ctl = _GetCtl(e,'OJXGBVSJHY');
if (_tracker.goon(ctl,ctrlValue)) {
w_STATOREG=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('OJXGBVSJHY',0);
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
function Set_CALCOLI(ctrlValue,kmode,e) {
if (Ne(w_CALCOLI,ctrlValue)) {
var ctl = _GetCtl(e,'IBYMLBZKJR');
if (_tracker.goon(ctl,ctrlValue)) {
w_CALCOLI=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('IBYMLBZKJR',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH(false,'L',1,0,'');
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
l_bResult=(w_COMPLETA?Ge(w_DATAREG,w_DATAOPE):true);
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
function Set_TIPOOPRAP(ctrlValue,kmode,e) {
if (Ne(w_TIPOOPRAP,ctrlValue)) {
var ctl = _GetCtl(e,'UJRFWINIVQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_TIPOOPRAP=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UJRFWINIVQ',0);
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
function Set_idcauana(ctrlValue,kmode,e) {
if (Ne(w_idcauana,ctrlValue)) {
var ctl = _GetCtl(e,'XDPPAEWQFR');
if (_tracker.goon(ctl,ctrlValue)) {
w_idcauana=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XDPPAEWQFR',0);
if (l_bResult) {
l_bResult=Link_XDPPAEWQFR(kmode);
if ( ! (l_bResult)) {
w_idcauana=HtW('','C');
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
function Set_CONNESDOC(ctrlValue,kmode,e) {
if (Ne(w_CONNESDOC,ctrlValue)) {
var ctl = _GetCtl(e,'WNMMMNSARU');
if (_tracker.goon(ctl,ctrlValue)) {
w_CONNESDOC=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('WNMMMNSARU',0);
if (l_bResult) {
l_bResult=Link_WNMMMNSARU(kmode);
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
function Set_xTOTCONT(ctrlValue,kmode,e) {
if (Ne(w_xTOTCONT,ctrlValue)) {
var ctl = _GetCtl(e,'CTORYEJVDR');
if (_tracker.goon(ctl,ctrlValue)) {
w_xTOTCONT=ValidNum(ctrlValue,'999999999999.99');
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
var l_bWarn = true;
l_bResult=_ChkObl('CTORYEJVDR',0);
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
SPBOUILib.SetInputValue('CTORYEJVDR',function(){return WtH(w_xTOTCONT,'N',15,2,'999,999,999,999.99')},w_xTOTCONT);
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
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',25,0,'@!'));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',25,0,'@!');
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
var l_bWarn = true;
l_bResult=_ChkObl('QBLXDBODXR',0);
if (l_bResult) {
l_bResult=Link_QBLXDBODXR(kmode);
if (l_bResult && ( ! (arfn_chkdatdoc(w_CONNESCLI,w_DATAREG)) && Ne(m_nLastError,-2))) {
try {
_tracker.askwrn=true;
l_bWarn=WindowConfirm(AlertErrorMessage('11525797640'));
} finally {
_tracker.askwrn=false;
}
if ( ! (l_bWarn)) {
Link_QBLXDBODXR_Blank();
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
function Set_PROQUOTA(ctrlValue,kmode,e) {
if (Ne(w_PROQUOTA,ctrlValue)) {
var ctl = _GetCtl(e,'ADUIDSWRJW');
if (_tracker.goon(ctl,ctrlValue)) {
w_PROQUOTA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ADUIDSWRJW',0);
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
function Set_IMPSARA(ctrlValue,kmode,e) {
if (Ne(w_IMPSARA,ctrlValue)) {
var ctl = _GetCtl(e,'LLXFEZDLPK');
if (_tracker.goon(ctl,ctrlValue)) {
w_IMPSARA=ValidNum(ctrlValue,'9999999999999999.99');
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('LLXFEZDLPK',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('LLXFEZDLPK',function(){return WtH(w_IMPSARA,'N',19,2,'99,999,999,999,999.99')},w_IMPSARA);
return l_bResult;
} else {
ctl.value=WtH('','N',19,2,'9999999999999999.99');
_ResetTracker();
return true;
}
} else {
SPBOUILib.SetInputValue('LLXFEZDLPK',function(){return WtH(w_IMPSARA,'N',19,2,'99,999,999,999,999.99')},w_IMPSARA);
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
var l_bWarn = true;
l_bResult=_ChkObl('TCOTJNZLGM',0);
if (l_bResult) {
l_bResult=Link_TCOTJNZLGM(kmode);
if (l_bResult && ( ! (arfn_chkdatdoc(w_CONNESOPER,w_DATAREG)) && Ne(m_nLastError,-2))) {
try {
_tracker.askwrn=true;
l_bWarn=WindowConfirm(AlertErrorMessage('11525797640'));
} finally {
_tracker.askwrn=false;
}
if ( ! (l_bWarn)) {
Link_TCOTJNZLGM_Blank();
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
var ctl = _GetCtl(e,'HWFHDWYMIU');
if (_tracker.goon(ctl,ctrlValue)) {
w_CONNALTRO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
var l_bWarn = true;
l_bResult=_ChkObl('HWFHDWYMIU',0);
if (l_bResult) {
l_bResult=Link_HWFHDWYMIU(kmode);
if (l_bResult && ( ! (arfn_chkdatdoc(w_CONNALTRO,w_DATAOPE)) && Ne(m_nLastError,-2))) {
try {
_tracker.askwrn=true;
l_bWarn=WindowConfirm(AlertErrorMessage('11525797640'));
} finally {
_tracker.askwrn=false;
}
if ( ! (l_bWarn)) {
Link_HWFHDWYMIU_Blank();
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
function Set_VASP(ctrlValue,kmode,e) {
if (Ne(w_VASP,ctrlValue)) {
var ctl = _GetCtl(e,'YMKLIGEOKH');
if (_tracker.goon(ctl,ctrlValue)) {
w_VASP=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YMKLIGEOKH',0);
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
function Set_PRESTAZ(ctrlValue,kmode,e) {
if (Ne(w_PRESTAZ,ctrlValue)) {
var ctl = _GetCtl(e,'RQKHNRJEDR');
if (_tracker.goon(ctl,ctrlValue)) {
w_PRESTAZ=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RQKHNRJEDR',0);
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
function Set_MEZPAG(ctrlValue,kmode,e) {
if (Ne(w_MEZPAG,ctrlValue)) {
var ctl = _GetCtl(e,'JEKLOGLRAN');
if (_tracker.goon(ctl,ctrlValue)) {
w_MEZPAG=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('JEKLOGLRAN',0);
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
function Set_NOSARA(ctrlValue,kmode,e) {
if (Ne(w_NOSARA,ctrlValue)) {
var ctl = _GetCtl(e,'XCYZDRXAMJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_NOSARA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XCYZDRXAMJ',0);
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
function Set_COMPLETA(ctrlValue,kmode,e) {
if (Ne(w_COMPLETA,ctrlValue)) {
var ctl = _GetCtl(e,'BOHBZOSBVJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_COMPLETA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BOHBZOSBVJ',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH(false,'L',1,0,'');
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
w_dataoggi=SystemDate();
w_filtro='O';
w_tipope='1';
UpdateAutonumber('IDBASE');
w_CODINTER=w_gIntemediario;
l_bTmpRes=Link_WJSVGWKSFC(null);
UpdateAutonumber('NUMPROG');
w_CDATOPE=DateToChar(w_DATAOPE);
if ((Ne(o_CDATOPE,w_CDATOPE))) {
w_CDATAOPE=w_CDATOPE;
}
w_ANNOOPE=Year(w_DATAOPE);
w_CDATREG=DateToChar(w_DATAREG);
if ((Ne(o_CODANA,w_CODANA))) {
l_bTmpRes=Link_SQVJLYRFKQ(null);
}
if ((Ne(o_CODVOC,w_CODVOC))) {
l_bTmpRes=Link_SRWWPHPCUB(null);
}
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
if ((Ne(o_CODINT2,w_CODINT2))) {
l_bTmpRes=Link_YQINIDXZSL(null);
}
if ((Ne(o_DATAREG,w_DATAREG))) {
w_apporeg=DateToChar(w_DATAREG);
}
w_TIPOINF='1';
w_OPRAP='1';
UpdateAutonumber('PRGIMPOPE');
if ((Ne(o_DATAOPE,w_DATAOPE))) {
Calculation_ISMPZVVNVG();
}
if ((Ne(o_FLAGFRAZ,w_FLAGFRAZ))) {
Calculation_QVHNBGPIFC();
}
if ((Ne(o_CONNESCLI,w_CONNESCLI)) || (Ne(o_RAPPORTO,w_RAPPORTO))) {
Calculation_QCJQRCFUFB();
}
if ((Ne(o_CONNESBEN,w_CONNESBEN))) {
Calculation_LNKPNNFRDI();
}
if ((Ne(o_RAPPORTO,w_RAPPORTO))) {
Calculation_DIWSVSDVMG();
}
if ((Ne(o_appolire,w_appolire))) {
Calculation_TBLTXFHXJY();
}
if ((Ne(o_FLAGCONT,w_FLAGCONT))) {
Calculation_EBRTUDXQTQ();
}
if ((Ne(o_CODINTER,w_CODINTER)) || (Ne(o_CODDIPE,w_CODDIPE))) {
Calculation_WKUMXNRIRT();
}
if ((Ne(o_DURAT,w_DURAT))) {
l_bTmpRes=Link_VMVNJQLPEN(null);
}
if ((Ne(o_AMMONT,w_AMMONT))) {
l_bTmpRes=Link_ASETEUZIOS(null);
}
if ((Ne(o_AREAGEO,w_AREAGEO))) {
l_bTmpRes=Link_UXDPSYOTRU(null);
}
if ((Ne(o_MODSVOL,w_MODSVOL))) {
l_bTmpRes=Link_VZKBEOYRRK(null);
}
if ((Ne(o_RAGIO,w_RAGIO))) {
l_bTmpRes=Link_NVHOMNEASH(null);
}
if ((Ne(o_TIPO,w_TIPO))) {
l_bTmpRes=Link_XSVOIKCEKR(null);
}
if ( ! (ChildToLoad(FrameRef('armt_operazbo_agg'))) && Ne(typeof(FrameRef('armt_operazbo_agg').DoUpdate),'undefined')) {
CopyWorkVar(FrameRef('armt_operazbo_agg'),['SEGNO'],['SEGNO'],true)
}
LibJavascript.forEachItem(m_FoundlingCopyWorkVar,i_body_1)
function i_body_1(child){
child();
}
// * --- Area Manuale = UI - Calculate
// * --- armt_operazioni
if ((Ne(o_DATAOPE,w_DATAOPE)) || (Ne(o_DATAREG,w_DATAREG))) {
  if(w_gChkDate=='B' && m_cFunction=='new') {
    Ctrl('OEIKQOZMYJ').value=WtH(SystemDate(),'D',8,0,TranslatePicture('DDMMYYYY'));    
  }
}

if (Ne(o_CONNESCLI,w_CONNESCLI)) {
  _soggetti=arfn_calc_soggope(w_CONNESCLI,DateToChar(w_DATAOPE),'O')
  if(Gt(_soggetti,0)) {
    if(confirm("Esistono soggetti operanti collegati. Vuoi importali?")) {
      arrt_soggope_opeaui([['pObj',this]])  
    }  
  }  
}  
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
function Calculation_ISMPZVVNVG() {
w_TIPOLEG=arfn_read_tipoleg(w_IDBASE,'OD');
}
function Calculation_QVHNBGPIFC() {
w_COLLEG=(Eq(w_FLAGFRAZ,'0')?'':w_COLLEG);
}
function Calculation_QCJQRCFUFB() {
arrt_imp_frischio([["pTipo",'B']])
}
function Calculation_LNKPNNFRDI() {
arrt_val_benefic([])
}
function Calculation_DIWSVSDVMG() {
if (w_CALCOLI) {
arrt_li_operazbo([["pObj",this]])
}
}
function Calculation_TBLTXFHXJY() {
w_VALUTA=(Eq(w_appolire,'L')?'018':(Eq(w_appolire,'E')?'242':w_VALUTA));
}
function Calculation_EBRTUDXQTQ() {
w_xTOTCONT=(Eq(w_FLAGCONT,'1')?w_xTOTCONT:0);
}
function Calculation_WKUMXNRIRT() {
w_DESCCIT=(Empty(w_CODDIPE)?w_CITINT:w_CITDIP);
w_PROVINCIA=(Empty(w_CODDIPE)?w_PROVINT:w_PROVDIP);
w_CODCAB=(Empty(w_CODDIPE)?w_CABINT:w_CABDIP);
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
l_bResult=(w_COMPLETA?arfn_chksogg(w_CONNESBEN,'5'):true);
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
function SaveDependsOn() {
o_filtro=w_filtro;
o_CODINTER=w_CODINTER;
o_CODDIPE=w_CODDIPE;
o_DATAOPE=w_DATAOPE;
o_CDATOPE=w_CDATOPE;
o_DATAREG=w_DATAREG;
o_FLAGFRAZ=w_FLAGFRAZ;
o_TIPOOPRAP=w_TIPOOPRAP;
o_CODANA=w_CODANA;
o_CODVOC=w_CODVOC;
o_FLAGLIRE=w_FLAGLIRE;
o_appolire=w_appolire;
o_VALUTA=w_VALUTA;
o_FLAGCONT=w_FLAGCONT;
o_RAPPORTO=w_RAPPORTO;
o_CONNESCLI=w_CONNESCLI;
o_CONNESOPER=w_CONNESOPER;
o_CONNESBEN=w_CONNESBEN;
o_CONNALTRO=w_CONNALTRO;
o_C_CTA=w_C_CTA;
o_CODINT2=w_CODINT2;
o_SEGNO=w_SEGNO;
o_DURAT=w_DURAT;
o_AMMONT=w_AMMONT;
o_AREAGEO=w_AREAGEO;
o_MODSVOL=w_MODSVOL;
o_RAGIO=w_RAGIO;
o_TIPO=w_TIPO;
}
function SaveLabelDependsOn() {
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
function Link_XDPPAEWQFR(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_idcauana);
var l_Appl = LinkApplet();
l_Appl.AppendFilterValue('%'+w_gTipInter+'%');
l_Appl.SetStringKey('idbase',w_idcauana,4,0);
l_Appl.SetFields('idbase,CODCAU,CAUSINT,SEGNO,NOSARA,FLGINTER,DESCRI');
l_Appl.SetTypes('C,C,C,C,C,C,C');
l_Appl.LinkTable('tbcauana');
l_Appl.SetID('XDPPAEWQFR');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_idcauana=l_Appl.GetStringValue('idbase',4,0);
w_CODANA=l_Appl.GetStringValue('CODCAU',4,0);
w_CODVOC=l_Appl.GetStringValue('CAUSINT',2,0);
w_SEGNO=l_Appl.GetStringValue('SEGNO',1,0);
w_NOSARA=l_Appl.GetStringValue('NOSARA',1,0);
w_xFLGITAEST=l_Appl.GetStringValue('FLGINTER',1,0);
w_desccauana=l_Appl.GetStringValue('DESCRI',165,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_XDPPAEWQFR_Blank();
l_bResult=true;
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_XDPPAEWQFR';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_XDPPAEWQFR();
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
function Link_XDPPAEWQFR_Blank() {
w_CODANA='';
w_CODVOC='';
w_SEGNO='';
w_NOSARA='';
w_xFLGITAEST='';
w_desccauana='';
}
function LOpt_XDPPAEWQFR() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcauana','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('idbase','C'));
l_oWv.setValue('LinkedField',WtA('idbase','C'));
l_oWv.setValue('UID',WtA('XDPPAEWQFR','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['XDPPAEWQFR'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('282647084'),'C'));
return l_oWv;
}
function Link_SQVJLYRFKQ(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CODANA);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODCAU',w_CODANA,4,0);
l_Appl.SetFields('CODCAU,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbcauana');
l_Appl.SetLinkzoom('armt_causalia');
l_Appl.SetID('SQVJLYRFKQ');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CODANA=l_Appl.GetStringValue('CODCAU',4,0);
w_desccauana=l_Appl.GetStringValue('DESCRI',165,0);
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
w_desccauana='';
}
function LOpt_SQVJLYRFKQ() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcauana','C'));
l_oWv.setValue('Linkzoomprg',WtA('armt_causalia','C'));
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
l_Appl.SetStringKey('CODVOC',w_CODVOC,2,0);
l_Appl.SetFields('CODVOC,DESCRIZ');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbcausin');
l_Appl.SetLinkzoom('armt_causalis');
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
l_oWv.setValue('Linkzoomprg',WtA('armt_causalis','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODVOC','C'));
l_oWv.setValue('LinkedField',WtA('CODVOC','C'));
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
l_Appl.SetFields('CONNES,RAGSOC,CONTO');
l_Appl.SetTypes('C,C,C');
l_Appl.LinkTable('personbo');
l_Appl.SetID('ULVCBLFVEU');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CONNESBEN=l_Appl.GetStringValue('CONNES',16,0);
w_xragsocben=l_Appl.GetStringValue('RAGSOC',70,0);
w_C_RAPPORTO=l_Appl.GetStringValue('CONTO',25,0);
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
w_C_RAPPORTO='';
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
w_xragsocalt=l_Appl.GetStringValue('RAGSOC',70,0);
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
w_xragsocalt='';
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
l_bResult=true;
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
l_bResult=true;
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
w_DESC2=l_Appl.GetStringValue('CITTA',30,0);
w_PROV2=l_Appl.GetStringValue('PROV',2,0);
w_xdciticon=l_Appl.GetStringValue('CITTA',40,0);
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
w_DESC2='';
w_PROV2='';
w_xdciticon='';
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
function Link_VMVNJQLPEN(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_DURAT);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODICE',w_DURAT,5,0);
l_Appl.SetFields('CODICE,RISCHIO');
l_Appl.SetTypes('C,N');
l_Appl.LinkTable('tbdurata_p');
l_Appl.SetID('VMVNJQLPEN');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_DURAT=l_Appl.GetStringValue('CODICE',5,0);
w_RFREQ=l_Appl.GetDoubleValue('RISCHIO',3,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_VMVNJQLPEN_Blank();
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
function Link_VMVNJQLPEN_Blank() {
w_DURAT='';
w_RFREQ=0;
}
function LOpt_VMVNJQLPEN() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbdurata_p','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODICE','C'));
l_oWv.setValue('LinkedField',WtA('CODICE','C'));
l_oWv.setValue('UID',WtA('VMVNJQLPEN','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['VMVNJQLPEN'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('492802848'),'C'));
return l_oWv;
}
function Link_ASETEUZIOS(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_AMMONT);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODICE',w_AMMONT,5,0);
l_Appl.SetFields('CODICE,RISCHIO');
l_Appl.SetTypes('C,N');
l_Appl.LinkTable('tbimporto_p');
l_Appl.SetID('ASETEUZIOS');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_AMMONT=l_Appl.GetStringValue('CODICE',5,0);
w_RIMP=l_Appl.GetDoubleValue('RISCHIO',3,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_ASETEUZIOS_Blank();
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
function Link_ASETEUZIOS_Blank() {
w_AMMONT='';
w_RIMP=0;
}
function LOpt_ASETEUZIOS() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbimporto_p','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODICE','C'));
l_oWv.setValue('LinkedField',WtA('CODICE','C'));
l_oWv.setValue('UID',WtA('ASETEUZIOS','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['ASETEUZIOS'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('11857520945'),'C'));
return l_oWv;
}
function Link_UXDPSYOTRU(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_AREAGEO);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODICE',w_AREAGEO,5,0);
l_Appl.SetFields('CODICE,RISCHIO');
l_Appl.SetTypes('C,N');
l_Appl.LinkTable('tbareegeog_p');
l_Appl.SetID('UXDPSYOTRU');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_AREAGEO=l_Appl.GetStringValue('CODICE',5,0);
w_RAREA=l_Appl.GetDoubleValue('RISCHIO',3,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_UXDPSYOTRU_Blank();
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
function Link_UXDPSYOTRU_Blank() {
w_AREAGEO='';
w_RAREA=0;
}
function LOpt_UXDPSYOTRU() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbareegeog_p','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODICE','C'));
l_oWv.setValue('LinkedField',WtA('CODICE','C'));
l_oWv.setValue('UID',WtA('UXDPSYOTRU','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['UXDPSYOTRU'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('11053408024'),'C'));
return l_oWv;
}
function Link_VZKBEOYRRK(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_MODSVOL);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODICE',w_MODSVOL,5,0);
l_Appl.SetFields('CODICE,RISCHIO');
l_Appl.SetTypes('C,N');
l_Appl.LinkTable('tbsvolgim_p');
l_Appl.SetID('VZKBEOYRRK');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_MODSVOL=l_Appl.GetStringValue('CODICE',5,0);
w_RCOMP=l_Appl.GetDoubleValue('RISCHIO',3,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_VZKBEOYRRK_Blank();
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
function Link_VZKBEOYRRK_Blank() {
w_MODSVOL='';
w_RCOMP=0;
}
function LOpt_VZKBEOYRRK() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbsvolgim_p','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODICE','C'));
l_oWv.setValue('LinkedField',WtA('CODICE','C'));
l_oWv.setValue('UID',WtA('VZKBEOYRRK','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['VZKBEOYRRK'][1],'C'));
return l_oWv;
}
function Link_NVHOMNEASH(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_RAGIO);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODICE',w_RAGIO,5,0);
l_Appl.SetFields('CODICE,RISCHIO');
l_Appl.SetTypes('C,N');
l_Appl.LinkTable('tbplauso_p');
l_Appl.SetID('NVHOMNEASH');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_RAGIO=l_Appl.GetStringValue('CODICE',5,0);
w_RRAGIO=l_Appl.GetDoubleValue('RISCHIO',3,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_NVHOMNEASH_Blank();
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
function Link_NVHOMNEASH_Blank() {
w_RAGIO='';
w_RRAGIO=0;
}
function LOpt_NVHOMNEASH() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbplauso_p','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODICE','C'));
l_oWv.setValue('LinkedField',WtA('CODICE','C'));
l_oWv.setValue('UID',WtA('NVHOMNEASH','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['NVHOMNEASH'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('955814582'),'C'));
return l_oWv;
}
function Link_XSVOIKCEKR(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_TIPO);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODICE',w_TIPO,3,0);
l_Appl.SetFields('CODICE,RISCHIO');
l_Appl.SetTypes('C,N');
l_Appl.LinkTable('tbtiporisc_p');
l_Appl.SetID('XSVOIKCEKR');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_TIPO=l_Appl.GetStringValue('CODICE',3,0);
w_RTIPO=l_Appl.GetDoubleValue('RISCHIO',3,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_XSVOIKCEKR_Blank();
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
function Link_XSVOIKCEKR_Blank() {
w_TIPO='';
w_RTIPO=0;
}
function LOpt_XSVOIKCEKR() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbtiporisc_p','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODICE','C'));
l_oWv.setValue('LinkedField',WtA('CODICE','C'));
l_oWv.setValue('UID',WtA('XSVOIKCEKR','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['XSVOIKCEKR'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('10049460300'),'C'));
return l_oWv;
}
function Link_WNMMMNSARU(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CONNESDOC);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CONNES',w_CONNESDOC,50,0);
l_Appl.SetFields('CONNES,RAGSOC');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('kersonbo');
l_Appl.SetID('WNMMMNSARU');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CONNESDOC=l_Appl.GetStringValue('CONNES',50,0);
w_xRAGSOCDOC=l_Appl.GetStringValue('RAGSOC',70,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_WNMMMNSARU_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_WNMMMNSARU';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_WNMMMNSARU();
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
function Link_WNMMMNSARU_Blank() {
w_CONNESDOC='';
w_xRAGSOCDOC='';
}
function LOpt_WNMMMNSARU() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('kersonbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CONNES','C'));
l_oWv.setValue('LinkedField',WtA('CONNES','C'));
l_oWv.setValue('UID',WtA('WNMMMNSARU','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['WNMMMNSARU'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('11262175587'),'C'));
return l_oWv;
}
function Link_CKJQULDXKW(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_DURAT);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODICE',w_DURAT,5,0);
l_Appl.SetFields('CODICE,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbdurata');
l_Appl.SetID('CKJQULDXKW');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_DURAT=l_Appl.GetStringValue('CODICE',5,0);
w_xdescfreq=l_Appl.GetStringValue('DESCRI',200,0);
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
l_Appl.SetFields('CODICE,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbimporto');
l_Appl.SetID('SXTYCPHBIM');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_AMMONT=l_Appl.GetStringValue('CODICE',5,0);
w_xdescammo=l_Appl.GetStringValue('DESCRI',200,0);
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
l_Appl.SetFields('CODICE,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbareegeog');
l_Appl.SetID('QJSTZIPOQB');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_AREAGEO=l_Appl.GetStringValue('CODICE',5,0);
w_xdescareag=l_Appl.GetStringValue('DESCRI',50,0);
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
l_Appl.SetFields('CODICE,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbsvolgim');
l_Appl.SetID('SFFFOYOWNH');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_MODSVOL=l_Appl.GetStringValue('CODICE',5,0);
w_xdescmodsvo=l_Appl.GetStringValue('DESCRI',200,0);
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
l_Appl.SetFields('CODICE,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbplauso');
l_Appl.SetID('NOBMPHKVTX');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_RAGIO=l_Appl.GetStringValue('CODICE',5,0);
w_xdescplauso=l_Appl.GetStringValue('DESCRI',200,0);
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
l_Appl.SetFields('CODICE,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbtiporisc');
l_Appl.SetID('DJOWYRMDDC');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_TIPO=l_Appl.GetStringValue('CODICE',3,0);
w_xdesctipor=l_Appl.GetStringValue('DESCRI',100,0);
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
function ReportLinkValue(varName,value) {
var bResult = false;
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
if (Eq(varName,'XDPPAEWQFR')) {
last_focused_comp=GetLastFocusedElementOfLink('XDPPAEWQFR');
function SetMethod_XDPPAEWQFR() {
Set_idcauana(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_XDPPAEWQFR();
} else {
setTimeout(SetMethod_XDPPAEWQFR,1);
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
if (Eq(varName,'WNMMMNSARU')) {
last_focused_comp=GetLastFocusedElementOfLink('WNMMMNSARU');
function SetMethod_WNMMMNSARU() {
Set_CONNESDOC(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_WNMMMNSARU();
} else {
setTimeout(SetMethod_WNMMMNSARU,1);
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
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'AVHTGZTOSZ')) {
return [Ctrl('AVHTGZTOSZ')];
}
if (Eq(varName,'XDPPAEWQFR')) {
return [Ctrl('XDPPAEWQFR')];
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
if (Eq(varName,'QEFXECTWSF')) {
return [Ctrl('QEFXECTWSF')];
}
if (Eq(varName,'WNMMMNSARU')) {
return [Ctrl('WNMMMNSARU')];
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
bResult=(w_COMPLETA?arfn_chkdatreg(w_DATAOPE,w_DATAREG,w_gChkDate,EntityStatus()):true);
if ( ! (bResult)) {
m_cLastMsgError=AlertErrorMessage('11058877460');
}
}
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
parent.ZtVWeb.raiseEventToEvalParms('armt_operazioni_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('armt_operazioni_dataNotSent',{'action':formaction});
}
}
}
}
CheckChild.child=[{'prg':"ardt_sogope",'BOScId':function(){ return FrameRef('ardt_sogope')},'repeated':0},{'prg':"ardt_clientiope",'BOScId':function(){ return FrameRef('ardt_clientiope')},'repeated':0},{'prg':"ardt_mlientiope",'BOScId':function(){ return FrameRef('ardt_mlientiope')},'repeated':0},{'prg':"ardt_mogopebo",'BOScId':function(){ return FrameRef('ardt_mogopebo')},'repeated':0},{'prg':"ardt_beneficope",'BOScId':function(){ return FrameRef('ardt_beneficope')},'repeated':0},{'prg':"ardt_meneficope",'BOScId':function(){ return FrameRef('ardt_meneficope')},'repeated':0},{'prg':"ardt_terzistiope",'BOScId':function(){ return FrameRef('ardt_terzistiope')},'repeated':0},{'prg':"ardt_merzistiope",'BOScId':function(){ return FrameRef('ardt_merzistiope')},'repeated':0},{'prg':"ardt_rapcoll",'BOScId':function(){ return FrameRef('ardt_rapcoll')},'repeated':0},{'prg':"ardt_docopebo",'BOScId':function(){ return FrameRef('ardt_docopebo')},'repeated':0},{'prg':"armt_operazbo_agg",'BOScId':function(){ return FrameRef('armt_operazbo_agg')},'repeated':0},{'prg':"ardt_ope_contante",'BOScId':function(){ return FrameRef('ardt_ope_contante')},'repeated':0}];
function Check() {
var l_bResult = true;
var l_bChildCheck = true;
ResetErrorVars();
m_nLastError=0;
if ( ! (_ChkObl('NHERHRZTFP',1))) {
_SignErr('NHERHRZTFP');
m_cLastWorkVarErrorMsg='113866889';
l_bResult=false;
w_IDBASE=HtW('','C');
} else if ( ! (_ChkObl('AVHTGZTOSZ',1))) {
_SignErr('AVHTGZTOSZ');
m_cLastWorkVarErrorMsg='2071283709';
l_bResult=false;
w_CODDIPE=HtW('','C');
} else if (( ! (_ChkObl('YLIKFVPZJA',1))) || ( ! ((w_COMPLETA?Ge(w_DATAREG,w_DATAOPE):true)))) {
_SignErr('YLIKFVPZJA','12128708791');
l_bResult=false;
w_DATAOPE=HtW('','D');
} else if ((Ne(w_gChkDate,'U') && Ne(w_gChkDate,'B') && Eq(w_gFlgDTP,0)) && (( ! (_ChkObl('OEIKQOZMYJ',1))) || ( ! ((w_COMPLETA?Ge(w_DATAREG,w_DATAOPE):true))))) {
_SignErr('OEIKQOZMYJ','12128708791');
l_bResult=false;
w_DATAREG=HtW('','D');
} else if ( ! (_ChkObl('QSRYXQJCBZ',1))) {
_SignErr('QSRYXQJCBZ');
m_cLastWorkVarErrorMsg='1722199786';
l_bResult=false;
w_FLAGFRAZ=HtW('','C');
} else if ( ! (_ChkObl('UJRFWINIVQ',1))) {
_SignErr('UJRFWINIVQ');
m_cLastWorkVarErrorMsg='11137644647';
l_bResult=false;
w_TIPOOPRAP=HtW('','C');
} else if ( ! (_ChkObl('XDPPAEWQFR',1))) {
_SignErr('XDPPAEWQFR');
m_cLastWorkVarErrorMsg='1814604627';
l_bResult=false;
w_idcauana=HtW('','C');
} else if ( ! (_ChkObl('LJBMCCABSS',1))) {
_SignErr('LJBMCCABSS');
m_cLastWorkVarErrorMsg='10126883135';
l_bResult=false;
w_appolire=HtW('','C');
} else if ( ! (_ChkObl('MKCXJZEKIG',1))) {
_SignErr('MKCXJZEKIG');
m_cLastWorkVarErrorMsg='10849117717';
l_bResult=false;
w_VALUTA=HtW('','C');
} else if ( ! (_ChkObl('EDIXWZNSIC',1))) {
_SignErr('EDIXWZNSIC');
m_cLastWorkVarErrorMsg='11144213888';
l_bResult=false;
w_xTOTLIRE=HtW('','N');
} else if ( ! (_ChkObl('PURPSXEVAI',1))) {
_SignErr('PURPSXEVAI');
m_cLastWorkVarErrorMsg='237632211';
l_bResult=false;
w_FLAGCONT=HtW('','C');
} else if ((Eq(w_FLAGCONT,'1')) && ( ! (_ChkObl('CTORYEJVDR',1)))) {
_SignErr('CTORYEJVDR');
m_cLastWorkVarErrorMsg='616535110';
l_bResult=false;
w_xTOTCONT=HtW('','N');
} else if ( ! (_ChkObl('YTCDGCPEDJ',1))) {
_SignErr('YTCDGCPEDJ');
m_cLastWorkVarErrorMsg='123704147';
l_bResult=false;
w_CAMBIO=HtW('','N');
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
} else if ( ! (_ChkObl('ADUIDSWRJW',1))) {
_SignErr('ADUIDSWRJW');
m_cLastWorkVarErrorMsg='11552491820';
l_bResult=false;
w_PROQUOTA=HtW('','N');
} else if ( ! (_ChkObl('LLXFEZDLPK',1))) {
_SignErr('LLXFEZDLPK');
m_cLastWorkVarErrorMsg='1992150396';
l_bResult=false;
w_IMPSARA=HtW('','N');
} else if ( ! (_ChkObl('TCOTJNZLGM',1))) {
_SignErr('TCOTJNZLGM');
m_cLastWorkVarErrorMsg='10219814530';
l_bResult=false;
w_CONNESOPER=HtW('','C');
} else if ( ! (_ChkObl('AQSAREJVST',1))) {
_SignErr('AQSAREJVST');
m_cLastWorkVarErrorMsg='10639118571';
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
} else if ( ! (_ChkObl('HNMYJPHSQN',1))) {
_SignErr('HNMYJPHSQN');
m_cLastWorkVarErrorMsg='11628231202';
l_bResult=false;
w_TIPOINT2=HtW('','C');
} else if ( ! (_ChkObl('CDJFSCCGNX',1))) {
_SignErr('CDJFSCCGNX');
m_cLastWorkVarErrorMsg='10166252281';
l_bResult=false;
w_CODINT2=HtW('','C');
} else if ( ! (_ChkObl('VYDRMHACRY',1))) {
_SignErr('VYDRMHACRY');
m_cLastWorkVarErrorMsg='1663847547';
l_bResult=false;
w_DESCINTER=HtW('','C');
} else if ( ! (_ChkObl('NYRJHOZOON',1))) {
_SignErr('NYRJHOZOON');
m_cLastWorkVarErrorMsg='1108605666';
l_bResult=false;
w_PAESE=HtW('','C');
} else if ( ! (_ChkObl('YBNJCVPDUM',1))) {
_SignErr('YBNJCVPDUM');
m_cLastWorkVarErrorMsg='C_RAPPORTO';
l_bResult=false;
w_C_RAPPORTO=HtW('','C');
} else if ( ! (_ChkObl('YQINIDXZSL',1))) {
_SignErr('YQINIDXZSL');
m_cLastWorkVarErrorMsg='12135010165';
l_bResult=false;
w_CODCAB2=HtW('','C');
} else if ( ! (_ChkObl('FFCAGQAZHK',1))) {
_SignErr('FFCAGQAZHK');
m_cLastWorkVarErrorMsg='10166248752';
l_bResult=false;
w_DESC2=HtW('','C');
} else if ( ! (_ChkObl('ACAPFGYRVI',1))) {
_SignErr('ACAPFGYRVI');
m_cLastWorkVarErrorMsg='635233449';
l_bResult=false;
w_PROV2=HtW('','C');
} else if ( ! (_ChkObl('GXMZZZHVBR',1))) {
_SignErr('GXMZZZHVBR');
m_cLastWorkVarErrorMsg='ZCPARTE';
l_bResult=false;
w_ZCPARTE=HtW('','C');
} else if ((false) && ( ! (_ChkObl('OJXGBVSJHY',1)))) {
_SignErr('OJXGBVSJHY');
m_cLastWorkVarErrorMsg='7776403';
l_bResult=false;
w_STATOREG=HtW('','C');
} else if ((false) && ( ! (_ChkObl('VYBZEWHKFF',1)))) {
_SignErr('VYBZEWHKFF');
m_cLastWorkVarErrorMsg='11329559720';
l_bResult=false;
w_DATARETT=HtW('','D');
} else if ( ! (_ChkObl('XCYZDRXAMJ',1))) {
_SignErr('XCYZDRXAMJ');
m_cLastWorkVarErrorMsg='10450770185';
l_bResult=false;
w_NOSARA='N';
} else if ( ! (_ChkObl('IBYMLBZKJR',1))) {
_SignErr('IBYMLBZKJR');
m_cLastWorkVarErrorMsg='CALCOLI';
l_bResult=false;
w_CALCOLI=HtW('','L');
} else if ( ! (_ChkObl('BOHBZOSBVJ',1))) {
_SignErr('BOHBZOSBVJ');
m_cLastWorkVarErrorMsg='COMPLETA';
l_bResult=false;
w_COMPLETA=HtW('','L');
} else if ( ! (_ChkObl('LEHLEQRJPH',1))) {
_SignErr('LEHLEQRJPH');
m_cLastWorkVarErrorMsg='NOPROT';
l_bResult=false;
w_NOPROT=0;
} else if ( ! (_ChkObl('QEFXECTWSF',1))) {
_SignErr('QEFXECTWSF');
m_cLastWorkVarErrorMsg='OPERAG';
l_bResult=false;
w_OPERAG=HtW('','C');
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
} else if ( ! (_ChkObl('SMZCOQAIDC',1))) {
_SignErr('SMZCOQAIDC');
m_cLastWorkVarErrorMsg='10984972139';
l_bResult=false;
w_SV58550=HtW('','C');
} else if ( ! (_ChkObl('MDVEMSKFNR',1))) {
_SignErr('MDVEMSKFNR');
m_cLastWorkVarErrorMsg='12000295156';
l_bResult=false;
w_SV58550MA=HtW('','C');
} else if ( ! (_ChkObl('JEKLOGLRAN',1))) {
_SignErr('JEKLOGLRAN');
m_cLastWorkVarErrorMsg='10114564076';
l_bResult=false;
w_MEZPAG=HtW('','C');
} else if ( ! (_ChkObl('RQKHNRJEDR',1))) {
_SignErr('RQKHNRJEDR');
m_cLastWorkVarErrorMsg='2135167160';
l_bResult=false;
w_PRESTAZ=HtW('','C');
} else if ( ! (_ChkObl('YMKLIGEOKH',1))) {
_SignErr('YMKLIGEOKH');
m_cLastWorkVarErrorMsg='1988585268';
l_bResult=false;
w_VASP=HtW('','C');
} else if ( ! (_ChkObl('WNMMMNSARU',1))) {
_SignErr('WNMMMNSARU');
m_cLastWorkVarErrorMsg='711282992';
l_bResult=false;
w_CONNESDOC=HtW('','C');
} else if ( ! (_ChkObl('JDTKGSGMAF',1))) {
_SignErr('JDTKGSGMAF');
m_cLastWorkVarErrorMsg='338061';
l_bResult=false;
w_MTCN=HtW('','C');
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
} else if ( ! (_ChkObl('SMVVFHCEHA',1))) {
_SignErr('SMVVFHCEHA');
m_cLastWorkVarErrorMsg='10500809751';
l_bResult=false;
w_RISGLOB=HtW('','C');
} else if ( ! (_ChkObl('DOXBACRWUU',1))) {
_SignErr('DOXBACRWUU');
m_cLastWorkVarErrorMsg='307787605';
l_bResult=false;
w_MITIG=HtW('','N');
} else if ( ! (_ChkObl('OXGBDTWKSX',1))) {
_SignErr('OXGBDTWKSX');
m_cLastWorkVarErrorMsg='724026219';
l_bResult=false;
w_MITIGDOC=HtW('','C');
} else if ( ! (Check_CUIIXQPPLV(true))) {
l_bResult = false;
} else if ( ! (Check_VTUPGRKHMU(true))) {
l_bResult = false;
} else if ( ! (Check_FBYJKRFVBE(true))) {
l_bResult = false;
} else if ( ! (Check_DUNXKFRTPZ(true))) {
l_bResult = false;
} else if ( ! (Check_CSHBHPWJQE(true))) {
l_bResult = false;
} else if ( ! (Check_ZZBVRHATAX(true))) {
l_bResult = false;
}
if (l_bResult) {
l_bResult=CheckChild(0);
}
// * --- Area Manuale = UI - Check Form
// * --- armt_operazioni
if (w_gChkDate == 'S') {
  if (Lt(w_DATAREG,w_dataoggi)) {
    alert('Data Registrazione inferiore alla Data di Sistema')
  }
}
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('AVHTGZTOSZ_ZOOM',lc)) {
return 0;
}
if (Eq('AVHTGZTOSZ',lc)) {
return 0;
}
if (Eq('YLIKFVPZJA_ZOOM',lc)) {
return 1;
}
if (Eq('XDPPAEWQFR_ZOOM',lc)) {
return 1;
}
if (Eq('XDPPAEWQFR',lc)) {
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
if (Eq('HWFHDWYMIU_ZOOM',lc)) {
return 6;
}
if (Eq('HWFHDWYMIU',lc)) {
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
if (Eq('CDJFSCCGNX_ZOOM',lc)) {
return 9;
}
if (Eq('CDJFSCCGNX',lc)) {
return 9;
}
if (Eq('NYRJHOZOON_ZOOM',lc)) {
return 10;
}
if (Eq('NYRJHOZOON',lc)) {
return 10;
}
if (Eq('YQINIDXZSL_ZOOM',lc)) {
return 11;
}
if (Eq('YQINIDXZSL',lc)) {
return 11;
}
if (Eq('QEFXECTWSF_ZOOM',lc)) {
return 12;
}
if (Eq('QEFXECTWSF',lc)) {
return 12;
}
if (Eq('WNMMMNSARU_ZOOM',lc)) {
return 13;
}
if (Eq('WNMMMNSARU',lc)) {
return 13;
}
if (Eq('CKJQULDXKW_ZOOM',lc)) {
return 14;
}
if (Eq('CKJQULDXKW',lc)) {
return 14;
}
if (Eq('SXTYCPHBIM_ZOOM',lc)) {
return 15;
}
if (Eq('SXTYCPHBIM',lc)) {
return 15;
}
if (Eq('QJSTZIPOQB_ZOOM',lc)) {
return 16;
}
if (Eq('QJSTZIPOQB',lc)) {
return 16;
}
if (Eq('SFFFOYOWNH_ZOOM',lc)) {
return 17;
}
if (Eq('SFFFOYOWNH',lc)) {
return 17;
}
if (Eq('NOBMPHKVTX_ZOOM',lc)) {
return 18;
}
if (Eq('NOBMPHKVTX',lc)) {
return 18;
}
if (Eq('DJOWYRMDDC_ZOOM',lc)) {
return 19;
}
if (Eq('DJOWYRMDDC',lc)) {
return 19;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_AVHTGZTOSZ();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,1)) {
l_oWv=LOpt_XDPPAEWQFR();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
l_cFixedFilter=l_cFixedFilter+l_cAndOp+_flt_('VALPERINT','%'+w_gTipInter+'%',null,false,'like');
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
l_oWv=LOpt_HWFHDWYMIU();
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
l_oWv=LOpt_CDJFSCCGNX();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,10)) {
l_oWv=LOpt_NYRJHOZOON();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,11)) {
l_oWv=LOpt_YQINIDXZSL();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,12)) {
l_oWv=LOpt_QEFXECTWSF();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,13)) {
l_oWv=LOpt_WNMMMNSARU();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,14)) {
l_oWv=LOpt_CKJQULDXKW();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,15)) {
l_oWv=LOpt_SXTYCPHBIM();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,16)) {
l_oWv=LOpt_QJSTZIPOQB();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,17)) {
l_oWv=LOpt_SFFFOYOWNH();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,18)) {
l_oWv=LOpt_NOBMPHKVTX();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,19)) {
l_oWv=LOpt_DJOWYRMDDC();
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
l_oWv.setValue('IDBASE',WtA(w_IDBASE,'C'));
l_oWv.setValue('op_IDBASE',WtA(op_IDBASE,'C'));
l_oWv.setValue('CODINTER',WtA(w_CODINTER,'C'));
l_oWv.setValue('CODDIPE',WtA(w_CODDIPE,'C'));
l_oWv.setValue('DESCCIT',WtA(w_DESCCIT,'C'));
l_oWv.setValue('PROVINCIA',WtA(w_PROVINCIA,'C'));
l_oWv.setValue('CODCAB',WtA(w_CODCAB,'C'));
l_oWv.setValue('DATAOPE',WtA(w_DATAOPE,'D'));
l_oWv.setValue('NUMPROG',WtA(w_NUMPROG,'C'));
l_oWv.setValue('op_NUMPROG',WtA(op_NUMPROG,'C'));
l_oWv.setValue('CDATOPE',WtA(w_CDATOPE,'C'));
l_oWv.setValue('CDATAOPE',WtA(w_CDATAOPE,'C'));
l_oWv.setValue('ANNOOPE',WtA(w_ANNOOPE,'N'));
l_oWv.setValue('IDEREG',WtA(w_IDEREG,'C'));
l_oWv.setValue('DATAREG',WtA(w_DATAREG,'D'));
l_oWv.setValue('CDATREG',WtA(w_CDATREG,'C'));
l_oWv.setValue('FLAGFRAZ',WtA(w_FLAGFRAZ,'C'));
l_oWv.setValue('COLLEG',WtA(w_COLLEG,'C'));
l_oWv.setValue('TIPOOPRAP',WtA(w_TIPOOPRAP,'C'));
l_oWv.setValue('idcauana',WtA(w_idcauana,'C'));
l_oWv.setValue('CODANA',WtA(w_CODANA,'C'));
l_oWv.setValue('CODVOC',WtA(w_CODVOC,'C'));
l_oWv.setValue('FLAGLIRE',WtA(w_FLAGLIRE,'C'));
l_oWv.setValue('VALUTA',WtA(w_VALUTA,'C'));
l_oWv.setValue('FLAGCONT',WtA(w_FLAGCONT,'C'));
l_oWv.setValue('CAMBIO',WtA(w_CAMBIO,'N'));
l_oWv.setValue('IMPIN',WtA(w_IMPIN,'N'));
l_oWv.setValue('IMPOUT',WtA(w_IMPOUT,'N'));
l_oWv.setValue('RAPPORTO',WtA(w_RAPPORTO,'C'));
l_oWv.setValue('CONNESCLI',WtA(w_CONNESCLI,'C'));
l_oWv.setValue('PROQUOTA',WtA(w_PROQUOTA,'N'));
l_oWv.setValue('IMPSARA',WtA(w_IMPSARA,'N'));
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
l_oWv.setValue('DESC2',WtA(w_DESC2,'C'));
l_oWv.setValue('PROV2',WtA(w_PROV2,'C'));
l_oWv.setValue('ZCPARTE',WtA(w_ZCPARTE,'C'));
l_oWv.setValue('STATOREG',WtA(w_STATOREG,'C'));
l_oWv.setValue('DATARETT',WtA(w_DATARETT,'D'));
l_oWv.setValue('OPERAZMOD',WtA(w_OPERAZMOD,'C'));
l_oWv.setValue('TIPOINF',WtA(w_TIPOINF,'C'));
l_oWv.setValue('SEGNO',WtA(w_SEGNO,'C'));
l_oWv.setValue('IPCOLLEG',WtA(w_IPCOLLEG,'C'));
l_oWv.setValue('ORACOLLEG',WtA(w_ORACOLLEG,'T'));
l_oWv.setValue('DUCOLLEG',WtA(w_DUCOLLEG,'N'));
l_oWv.setValue('NOPROT',WtA(w_NOPROT,'N'));
l_oWv.setValue('OPERAG',WtA(w_OPERAG,'C'));
l_oWv.setValue('RESPINS',WtA(w_RESPINS,'C'));
l_oWv.setValue('INFORM',WtA(w_INFORM,'C'));
l_oWv.setValue('NATURA',WtA(w_NATURA,'C'));
l_oWv.setValue('SCOPO',WtA(w_SCOPO,'C'));
l_oWv.setValue('SV58550',WtA(w_SV58550,'C'));
l_oWv.setValue('SV58550MA',WtA(w_SV58550MA,'C'));
l_oWv.setValue('DURAT',WtA(w_DURAT,'C'));
l_oWv.setValue('AMMONT',WtA(w_AMMONT,'C'));
l_oWv.setValue('AREAGEO',WtA(w_AREAGEO,'C'));
l_oWv.setValue('MODSVOL',WtA(w_MODSVOL,'C'));
l_oWv.setValue('RAGIO',WtA(w_RAGIO,'C'));
l_oWv.setValue('TIPO',WtA(w_TIPO,'C'));
l_oWv.setValue('CONNESDOC',WtA(w_CONNESDOC,'C'));
l_oWv.setValue('IDFILE',WtA(w_IDFILE,'C'));
l_oWv.setValue('MTCN',WtA(w_MTCN,'C'));
l_oWv.setValue('TOTLIRE',WtA(w_TOTLIRE,'N'));
l_oWv.setValue('TOTCONT',WtA(w_TOTCONT,'N'));
l_oWv.setValue('FLAGRAP',WtA(w_FLAGRAP,'C'));
l_oWv.setValue('OPRAP',WtA(w_OPRAP,'C'));
l_oWv.setValue('RAPPORTBEN',WtA(w_RAPPORTBEN,'C'));
l_oWv.setValue('OPERATORE',WtA(w_OPERATORE,'C'));
l_oWv.setValue('AUTOM',WtA(w_AUTOM,'C'));
l_oWv.setValue('FLAGRAP2',WtA(w_FLAGRAP2,'C'));
l_oWv.setValue('PRGIMPOPE',WtA(w_PRGIMPOPE,'N'));
l_oWv.setValue('op_PRGIMPOPE',WtA(op_PRGIMPOPE,'N'));
l_oWv.setValue('IDBASE2',WtA(w_IDBASE2,'C'));
l_oWv.setValue('RFREQ',WtA(w_RFREQ,'N'));
l_oWv.setValue('RIMP',WtA(w_RIMP,'N'));
l_oWv.setValue('RAREA',WtA(w_RAREA,'N'));
l_oWv.setValue('RCOMP',WtA(w_RCOMP,'N'));
l_oWv.setValue('RRAGIO',WtA(w_RRAGIO,'N'));
l_oWv.setValue('RTIPO',WtA(w_RTIPO,'N'));
l_oWv.setValue('RISGLOB',WtA(w_RISGLOB,'C'));
l_oWv.setValue('MITIG',WtA(w_MITIG,'N'));
l_oWv.setValue('MITIGDOC',WtA(w_MITIGDOC,'C'));
l_oWv.setValue('MEZPAG',WtA(w_MEZPAG,'C'));
l_oWv.setValue('PRESTAZ',WtA(w_PRESTAZ,'C'));
l_oWv.setValue('NOSARA',WtA(w_NOSARA,'C'));
l_oWv.setValue('DESPUNTO',WtA(w_DESPUNTO,'C'));
l_oWv.setValue('CODCLICON',WtA(w_CODCLICON,'C'));
l_oWv.setValue('TIPATT',WtA(w_TIPATT,'C'));
l_oWv.setValue('VASP',WtA(w_VASP,'C'));
l_oWv.setValue('RIFIMP',WtA(w_RIFIMP,'C'));
l_oWv.setValue('gIntemediario',WtA(w_gIntemediario,'C'));
l_oWv.setValue('gChkDate',WtA(w_gChkDate,'C'));
l_oWv.setValue('gTipInter',WtA(w_gTipInter,'C'));
l_oWv.setValue('gSblocco',WtA(w_gSblocco,'C'));
l_oWv.setValue('gDataVaria',WtA(w_gDataVaria,'D'));
l_oWv.setValue('gStatus',WtA(w_gStatus,'C'));
l_oWv.setValue('gFlgDoc',WtA(w_gFlgDoc,'C'));
l_oWv.setValue('gFlgWU',WtA(w_gFlgWU,'C'));
l_oWv.setValue('gFlgDTP',WtA(w_gFlgDTP,'N'));
l_oWv.setValue('gSeekAos',WtA(w_gSeekAos,'C'));
l_oWv.setValue('gVerSim',WtA(w_gVerSim,'C'));
l_oWv.setValue('dataoggi',WtA(w_dataoggi,'D'));
l_oWv.setValue('filtro',WtA(w_filtro,'C'));
l_oWv.setValue('sEdit',WtA(w_sEdit,'N'));
l_oWv.setValue('test',WtA(w_test,'C'));
l_oWv.setValue('datpaseuro',WtA(w_datpaseuro,'D'));
l_oWv.setValue('tipope',WtA(w_tipope,'C'));
l_oWv.setValue('stringaflagrap2',WtA(w_stringaflagrap2,'C'));
l_oWv.setValue('appolire',WtA(w_appolire,'C'));
l_oWv.setValue('xTOTLIRE',WtA(w_xTOTLIRE,'N'));
l_oWv.setValue('xTOTCONT',WtA(w_xTOTCONT,'N'));
l_oWv.setValue('apporeg',WtA(w_apporeg,'C'));
l_oWv.setValue('xdestipleg',WtA(w_xdestipleg,'C'));
l_oWv.setValue('xragsocct',WtA(w_xragsocct,'C'));
l_oWv.setValue('xDescDipe',WtA(w_xDescDipe,'C'));
l_oWv.setValue('descdiv',WtA(w_descdiv,'C'));
l_oWv.setValue('valflg2',WtA(w_valflg2,'C'));
l_oWv.setValue('xragint2',WtA(w_xragint2,'C'));
l_oWv.setValue('errmsg',WtA(w_errmsg,'C'));
l_oWv.setValue('xragsocper',WtA(w_xragsocper,'C'));
l_oWv.setValue('desccauana',WtA(w_desccauana,'C'));
l_oWv.setValue('xragsocben',WtA(w_xragsocben,'C'));
l_oWv.setValue('xdesccausin',WtA(w_xdesccausin,'C'));
l_oWv.setValue('xdescpaese2',WtA(w_xdescpaese2,'C'));
l_oWv.setValue('xdescrap',WtA(w_xdescrap,'C'));
l_oWv.setValue('xdes1',WtA(w_xdes1,'C'));
l_oWv.setValue('xcodfisc',WtA(w_xcodfisc,'C'));
l_oWv.setValue('xdciticon',WtA(w_xdciticon,'C'));
l_oWv.setValue('dessta',WtA(w_dessta,'C'));
l_oWv.setValue('xragsocalt',WtA(w_xragsocalt,'C'));
l_oWv.setValue('xFLGITAEST',WtA(w_xFLGITAEST,'C'));
l_oWv.setValue('xdescopeage',WtA(w_xdescopeage,'C'));
l_oWv.setValue('xdescfreq',WtA(w_xdescfreq,'C'));
l_oWv.setValue('xdescammo',WtA(w_xdescammo,'C'));
l_oWv.setValue('xdescareag',WtA(w_xdescareag,'C'));
l_oWv.setValue('xdescmodsvo',WtA(w_xdescmodsvo,'C'));
l_oWv.setValue('xdescplauso',WtA(w_xdescplauso,'C'));
l_oWv.setValue('xdesctipor',WtA(w_xdesctipor,'C'));
l_oWv.setValue('xRAGSOCDOC',WtA(w_xRAGSOCDOC,'C'));
l_oWv.setValue('CITINT',WtA(w_CITINT,'C'));
l_oWv.setValue('CITDIP',WtA(w_CITDIP,'C'));
l_oWv.setValue('PROVDIP',WtA(w_PROVDIP,'C'));
l_oWv.setValue('CABDIP',WtA(w_CABDIP,'C'));
l_oWv.setValue('PROVINT',WtA(w_PROVINT,'C'));
l_oWv.setValue('CABINT',WtA(w_CABINT,'C'));
l_oWv.setValue('DATAVALI',WtA(w_DATAVALI,'D'));
l_oWv.setValue('DATARILASC',WtA(w_DATARILASC,'D'));
l_oWv.setValue('CALCOLI',WtA(w_CALCOLI,'L'));
l_oWv.setValue('COMPLETA',WtA(w_COMPLETA,'L'));
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
_FillChildren.n=['ardt_sogope','ardt_clientiope','ardt_mlientiope','ardt_mogopebo','ardt_beneficope','ardt_meneficope','ardt_terzistiope','ardt_merzistiope','ardt_rapcoll','ardt_docopebo','armt_operazbo_agg','ardt_ope_contante'];
FillWv.n=["IDBASE","CODINTER","CODDIPE","DESCCIT","PROVINCIA","CODCAB","DATAOPE","NUMPROG","CDATOPE","CDATAOPE","ANNOOPE","IDEREG","DATAREG","CDATREG","FLAGFRAZ","COLLEG","TIPOOPRAP","idcauana","CODANA","CODVOC","FLAGLIRE","VALUTA","FLAGCONT","CAMBIO","IMPIN","IMPOUT","RAPPORTO","CONNESCLI","PROQUOTA","IMPSARA","CONNESOPER","TIPOLEG","PAGASOGOP","CONNESBEN","CONNALTRO","C_RAG","C_CTA","C_PRV","C_CAP","C_CAB","C_IND","C_STA","TIPOINT2","CODINT2","DESCINTER","PAESE","C_RAPPORTO","CODCAB2","DESC2","PROV2","ZCPARTE","STATOREG","DATARETT","OPERAZMOD","TIPOINF","SEGNO","IPCOLLEG","ORACOLLEG","DUCOLLEG","NOPROT","OPERAG","RESPINS","INFORM","NATURA","SCOPO","SV58550","SV58550MA","DURAT","AMMONT","AREAGEO","MODSVOL","RAGIO","TIPO","CONNESDOC","IDFILE","MTCN","TOTLIRE","TOTCONT","FLAGRAP","OPRAP","RAPPORTBEN","OPERATORE","AUTOM","FLAGRAP2","PRGIMPOPE","IDBASE2","RFREQ","RIMP","RAREA","RCOMP","RRAGIO","RTIPO","RISGLOB","MITIG","MITIGDOC","MEZPAG","PRESTAZ","NOSARA","DESPUNTO","CODCLICON","TIPATT","VASP","RIFIMP","gIntemediario","gChkDate","gTipInter","gSblocco","gDataVaria","gStatus","gFlgDoc","gFlgWU","gFlgDTP","gSeekAos","gVerSim","dataoggi","filtro","sEdit","test","datpaseuro","tipope","stringaflagrap2","appolire","xTOTLIRE","xTOTCONT","apporeg","xdestipleg","xragsocct","xDescDipe","descdiv","valflg2","xragint2","errmsg","xragsocper","desccauana","xragsocben","xdesccausin","xdescpaese2","xdescrap","xdes1","xcodfisc","xdciticon","dessta","xragsocalt","xFLGITAEST","xdescopeage","xdescfreq","xdescammo","xdescareag","xdescmodsvo","xdescplauso","xdesctipor","xRAGSOCDOC","CITINT","CITDIP","PROVDIP","CABDIP","PROVINT","CABINT","DATAVALI","DATARILASC","CALCOLI","COMPLETA"];
function SetModified() {
m_bUpdated=true;
}
function SetChildVariables_ardt_sogope() {
}
function CtxLoad_ardt_sogope() {
if (ChildToLoad(FrameRef('ardt_sogope'))) {
return [LoadContext(0,'TQDGESLQVD'),'ardt_sogope'];
}
}
function SetChildVariables_ardt_clientiope() {
}
function CtxLoad_ardt_clientiope() {
if (ChildToLoad(FrameRef('ardt_clientiope'))) {
return [LoadContext(0,'BOAFVDQFRN'),'ardt_clientiope'];
}
}
function SetChildVariables_ardt_mlientiope() {
}
function CtxLoad_ardt_mlientiope() {
if (ChildToLoad(FrameRef('ardt_mlientiope'))) {
return [LoadContext(0,'UVVKMCCJDD'),'ardt_mlientiope'];
}
}
function SetChildVariables_ardt_mogopebo() {
}
function CtxLoad_ardt_mogopebo() {
if (ChildToLoad(FrameRef('ardt_mogopebo'))) {
return [LoadContext(0,'JADNQZQMPX'),'ardt_mogopebo'];
}
}
function SetChildVariables_ardt_beneficope() {
}
function CtxLoad_ardt_beneficope() {
if (ChildToLoad(FrameRef('ardt_beneficope'))) {
return [LoadContext(0,'OCTDIOXFMI'),'ardt_beneficope'];
}
}
function SetChildVariables_ardt_meneficope() {
}
function CtxLoad_ardt_meneficope() {
if (ChildToLoad(FrameRef('ardt_meneficope'))) {
return [LoadContext(0,'ZTIUOLEFIW'),'ardt_meneficope'];
}
}
function SetChildVariables_ardt_terzistiope() {
}
function CtxLoad_ardt_terzistiope() {
if (ChildToLoad(FrameRef('ardt_terzistiope'))) {
return [LoadContext(0,'NOKYMTFBFL'),'ardt_terzistiope'];
}
}
function SetChildVariables_ardt_merzistiope() {
}
function CtxLoad_ardt_merzistiope() {
if (ChildToLoad(FrameRef('ardt_merzistiope'))) {
return [LoadContext(0,'PJIGCWZVYE'),'ardt_merzistiope'];
}
}
function SetChildVariables_ardt_rapcoll() {
}
function CtxLoad_ardt_rapcoll() {
if (ChildToLoad(FrameRef('ardt_rapcoll'))) {
return [LoadContext(0,'QLURQBXKEV'),'ardt_rapcoll'];
}
}
function SetChildVariables_ardt_docopebo() {
}
function CtxLoad_ardt_docopebo() {
if (ChildToLoad(FrameRef('ardt_docopebo'))) {
return [LoadContext(0,'OZMPVCAYQN'),'ardt_docopebo'];
}
}
function SetChildVariables_armt_operazbo_agg() {
if ( ! (ChildToLoad(FrameRef('armt_operazbo_agg'))) && Ne(typeof(FrameRef('armt_operazbo_agg').DoUpdate),'undefined')) {
CopyWorkVar(FrameRef('armt_operazbo_agg'),['SEGNO'],['SEGNO'],false)
}
}
function CtxLoad_armt_operazbo_agg() {
if (ChildToLoad(FrameRef('armt_operazbo_agg'))) {
return [LoadContext(0,'RZOXJTRIYP'),'armt_operazbo_agg'];
}
}
function SetChildVariables_ardt_ope_contante() {
}
function CtxLoad_ardt_ope_contante() {
if (ChildToLoad(FrameRef('ardt_ope_contante'))) {
return [LoadContext(0,'HPXRKUBEED'),'ardt_ope_contante'];
}
}
