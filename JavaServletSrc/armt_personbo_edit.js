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
function DisplayErrorMessage_ardt_personbo_dip() {
if ( ! (ChildToLoad(FrameRef('ardt_personbo_dip'))) && Ne(typeof(FrameRef('ardt_personbo_dip').DisplayErrorMessage),'undefined')) {
FrameRef('ardt_personbo_dip').DisplayErrorMessage();
}
}
function DisplayErrorMessage_armt_personbo_agg() {
if ( ! (ChildToLoad(FrameRef('armt_personbo_agg'))) && Ne(typeof(FrameRef('armt_personbo_agg').DisplayErrorMessage),'undefined')) {
FrameRef('armt_personbo_agg').DisplayErrorMessage();
}
}
function DisplayErrorMessage_ardt_soggope() {
if ( ! (ChildToLoad(FrameRef('ardt_soggope'))) && Ne(typeof(FrameRef('ardt_soggope').DisplayErrorMessage),'undefined')) {
FrameRef('ardt_soggope').DisplayErrorMessage();
}
}
function DisplayErrorMessage_ardt_fatca_ind() {
if ( ! (ChildToLoad(FrameRef('ardt_fatca_ind'))) && Ne(typeof(FrameRef('ardt_fatca_ind').DisplayErrorMessage),'undefined')) {
FrameRef('ardt_fatca_ind').DisplayErrorMessage();
}
}
function DisplayErrorMessage_ardt_patrimonio() {
if ( ! (ChildToLoad(FrameRef('ardt_patrimonio'))) && Ne(typeof(FrameRef('ardt_patrimonio').DisplayErrorMessage),'undefined')) {
FrameRef('ardt_patrimonio').DisplayErrorMessage();
}
}
function DisplayErrorMessage_ardt_reddito() {
if ( ! (ChildToLoad(FrameRef('ardt_reddito'))) && Ne(typeof(FrameRef('ardt_reddito').DisplayErrorMessage),'undefined')) {
FrameRef('ardt_reddito').DisplayErrorMessage();
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
l_bEnabled= ! ( ! (Utilities.Make(window).IsInGroup(3))) || IsDisabledByStateDriver('LinkPC');
if ( ! (ChildToLoad(FrameRef('ardt_personbo_dip'))) && Ne(typeof(FrameRef('ardt_personbo_dip').EnableEntity),'undefined')) {
FrameRef('ardt_personbo_dip').EnableEntity(l_bEnabled);
}
l_bEnabled= ! (Eq(m_cFunction,'view'));
SetDisabled('CYHJRUWRUL',l_bEnabled);
l_bEnabled= ! (Eq(w_FLGALTO,0)) || IsDisabledByStateDriver('RATTIV');
SetDisabled('BOECHNDAXS',l_bEnabled);
l_bEnabled= ! (false) || IsDisabledByStateDriver('status');
SetDisabled('YFBFKZZRWO',l_bEnabled);
if (IsDisabledByStateDriver('DatiBase')) {
DisableInputsInContainer(Ctrl('AQSQVBKXAL'),true);
}
if (IsDisabledByStateDriver('PF')) {
DisableInputsInContainer(Ctrl('EWPTTWSBMT'),true);
}
if (IsDisabledByStateDriver('AD')) {
DisableInputsInContainer(Ctrl('OQFTKYDCIW'),true);
}
if (IsDisabledByStateDriver('GestoriContante')) {
DisableInputsInContainer(Ctrl('PUKLGLJKBW'),true);
}
if (IsDisabledByStateDriver('Operazioni')) {
Z.Tabs.Get("tabs_3_AUI").SetDisable('VECIWQFMOB',true);
}
if (IsDisabledByStateDriver('Frazionate')) {
Z.Tabs.Get("tabs_3_AUI").SetDisable('WXIRJORZUM',true);
}
if (IsDisabledByStateDriver('Rapporti')) {
Z.Tabs.Get("tabs_3_AUI").SetDisable('XDVUUVRZLV',true);
}
if (IsDisabledByStateDriver('Rapporti')) {
Z.Tabs.Get("tabs_5_Provvisorie").SetDisable('YVPVOYKMZA',true);
}
if (IsDisabledByStateDriver('Operazioni')) {
Z.Tabs.Get("tabs_5_Provvisorie").SetDisable('MTHMFUOOBG',true);
}
if (IsDisabledByStateDriver('Frazionate')) {
Z.Tabs.Get("tabs_5_Provvisorie").SetDisable('WVUNPTQGCF',true);
}
if (IsDisabledByStateDriver('LegRap')) {
DisableInputsInContainer(Ctrl('HPGCEWAWGV'),true);
}
if (IsDisabledByStateDriver('DatiAgg')) {
Z.Tabs.Get("tabs_8_Altri").SetDisable('AYKUXGKLPO',true);
}
if (IsDisabledByStateDriver('Dipendenza')) {
Z.Tabs.Get("tabs_8_Altri").SetDisable('ZETZWJBOFM',true);
}
if (IsDisabledByStateDriver('SogCollegati')) {
Z.Tabs.Get("tabs_8_Altri").SetDisable('XDDGTPJDHN',true);
}
if (IsDisabledByStateDriver('Fatc')) {
DisableInputsInContainer(Ctrl('FIXFSIUKKN'),true);
}
if (IsDisabledByStateDriver('CittaDiv')) {
DisableInputsInContainer(Ctrl('WEJOYIAYYL'),true);
}
if (IsDisabledByStateDriver('ValRisk')) {
Z.Tabs.Get("tabs_10_Rischio").SetDisable('WJVOGIFRCK',true);
}
if (IsDisabledByStateDriver('MitRisk')) {
Z.Tabs.Get("tabs_10_Rischio").SetDisable('XTDFJTMZAQ',true);
}
if (IsDisabledByStateDriver('Patrimonio')) {
Z.Tabs.Get("tabs_10_Rischio").SetDisable('TKKVDEVHBF',true);
}
if (IsDisabledByStateDriver('Reddito')) {
Z.Tabs.Get("tabs_10_Rischio").SetDisable('STJESIOURE',true);
}
if (IsDisabledByStateDriver('RilAnom')) {
Z.Tabs.Get("tabs_11_Rischio").SetDisable('SSIHDIOVZQ',true);
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
// * --- armt_personbo
w_status=m_cFunction;
// * --- Fine Area Manuale
}
function ObligatoryControlsUnderCondition() {
var l_bObligatory = true;
SetObligatory(Ctrl('ODAYKSRECA'),(Eq(w_PAESE,'086') || Eq(w_PAESE,'139')) && Eq(w_gVerSim,'N') || IsObligatoryByStateDriver('DESCCIT'));
SetObligatory(Ctrl('NOTZPDMYIA'),(Eq(w_PAESE,'086') || Eq(w_PAESE,'139')) && Eq(w_gVerSim,'N') || IsObligatoryByStateDriver('PROVINCIA'));
SetObligatory(Ctrl('RDAVOEETJG'),(Eq(w_PAESE,'086') || Eq(w_PAESE,'139')) && Eq(w_gVerSim,'N') || IsObligatoryByStateDriver('CAP'));
SetObligatory(Ctrl('BOTAJBWHHY'),(w_COMPLETA?(Eq(w_PAESE,'086') || Eq(w_PAESE,'139')):false) || IsObligatoryByStateDriver('CODCAB'));
SetObligatory(Ctrl('VYLHWTRQNX'),(Eq(w_PAESE,'086') || Eq(w_PAESE,'139')) && Eq(w_gVerSim,'N') || IsObligatoryByStateDriver('DOMICILIO'));
SetObligatory(Ctrl('SAQTIHOALW'),(w_COMPLETA?Eq(w_tipsot,'1'):false) || IsObligatoryByStateDriver('ATTIV'));
SetObligatory(Ctrl('JFJPGOWVYJ'), ! (Empty(w_TIPOSOGGETTO)) || IsObligatoryByStateDriver('RAPSEGNA'));
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
function Set_CAUSALE(ctrlValue,kmode,e) {
if (Ne(w_CAUSALE,ctrlValue)) {
var ctl = _GetCtl(e,'EMSGWJAYYK');
if (_tracker.goon(ctl,ctrlValue)) {
w_CAUSALE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('EMSGWJAYYK',0);
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
function Set_status(ctrlValue,kmode,e) {
if (Ne(w_status,ctrlValue)) {
var ctl = _GetCtl(e,'YFBFKZZRWO');
if (_tracker.goon(ctl,ctrlValue)) {
w_status=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YFBFKZZRWO',0);
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
function Set_SOGAFFIDATARIO(ctrlValue,kmode,e) {
if (Ne(w_SOGAFFIDATARIO,ctrlValue)) {
var ctl = _GetCtl(e,'HKQDVAPIOQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_SOGAFFIDATARIO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HKQDVAPIOQ',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('HKQDVAPIOQ',function(){return WtH(w_SOGAFFIDATARIO,'C',80,0,'@!')},w_SOGAFFIDATARIO);
return l_bResult;
} else {
ctl.value=WtH('','C',80,0,'@!');
_ResetTracker();
return true;
}
}
return true;
}
function Set_NOTERIS(ctrlValue,kmode,e) {
if (Ne(w_NOTERIS,ctrlValue)) {
var ctl = _GetCtl(e,'FTYWOEFIPD');
if (_tracker.goon(ctl,ctrlValue)) {
w_NOTERIS=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FTYWOEFIPD',0);
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
function Set_VERIFICA(ctrlValue,kmode,e) {
if (Ne(w_VERIFICA,ctrlValue)) {
var ctl = _GetCtl(e,'OXWRJNTXVJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_VERIFICA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('OXWRJNTXVJ',0);
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
function Set_DATAIDENT(ctrlValue,kmode,e) {
if (Ne(w_DATAIDENT,ctrlValue)) {
var ctl = _GetCtl(e,'EVYVDDYVDZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_DATAIDENT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('EVYVDDYVDZ',0);
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
ctl.value=WtH('','C',3,0,'');
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
l_bResult=(w_COMPLETA?arfn_chkcodfis(w_CODFISC,w_PAESE,w_CFESTERO):true);
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
function Set_ATTIVR(ctrlValue,kmode,e) {
if (Ne(w_ATTIVR,ctrlValue)) {
var ctl = _GetCtl(e,'UQYOQYIUNM');
if (_tracker.goon(ctl,ctrlValue)) {
w_ATTIVR=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UQYOQYIUNM',0);
if (l_bResult) {
l_bResult=Link_UQYOQYIUNM(kmode);
if ( ! (l_bResult)) {
w_ATTIVR=HtW('','C');
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
l_bResult=l_bResult && _ChkObl('QFJRACGINU',0);
if (l_bResult) {
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
function Set_CONNES(ctrlValue,kmode,e) {
if (Ne(w_CONNES,ctrlValue)) {
var ctl = _GetCtl(e,'YTPWDRMFUS');
if (_tracker.goon(ctl,ctrlValue)) {
w_CONNES=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YTPWDRMFUS',0);
l_bResult=l_bResult && _ChkObl('MQYKJYJENJ',0);
if (l_bResult) {
if ( ! (l_bResult)) {
w_CONNES=HtW('','C');
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
function Set_COMPORT(ctrlValue,kmode,e) {
if (Ne(w_COMPORT,ctrlValue)) {
var ctl = _GetCtl(e,'HLXRSSMBIW');
if (_tracker.goon(ctl,ctrlValue)) {
w_COMPORT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HLXRSSMBIW',0);
if (l_bResult) {
l_bResult=Link_HLXRSSMBIW(kmode);
if ( ! (l_bResult)) {
w_COMPORT=HtW('','C');
}
}
l_bResult=l_bResult && _ChkObl('KYTSUTYBUR',0);
if (l_bResult) {
if ( ! (l_bResult)) {
w_COMPORT=HtW('','C');
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
function Set_PKTBSPECIE(ctrlValue,kmode,e) {
if (Ne(w_PKTBSPECIE,ctrlValue)) {
var ctl = _GetCtl(e,'VHXDWWHVXF');
if (_tracker.goon(ctl,ctrlValue)) {
w_PKTBSPECIE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VHXDWWHVXF',0);
if (l_bResult) {
l_bResult=Link_VHXDWWHVXF(kmode);
if ( ! (l_bResult)) {
w_PKTBSPECIE=HtW('','C');
}
}
l_bResult=l_bResult && _ChkObl('DRJTSDRPVN',0);
if (l_bResult) {
if ( ! (l_bResult)) {
w_PKTBSPECIE=HtW('','C');
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
function Set_RESFISC(ctrlValue,kmode,e) {
if (Ne(w_RESFISC,ctrlValue)) {
var ctl = _GetCtl(e,'OSLBLDODHQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_RESFISC=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('OSLBLDODHQ',0);
if (l_bResult) {
l_bResult=Link_OSLBLDODHQ(kmode);
if ( ! (l_bResult)) {
w_RESFISC=HtW('','C');
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
function Set_CITTADIN2(ctrlValue,kmode,e) {
if (Ne(w_CITTADIN2,ctrlValue)) {
var ctl = _GetCtl(e,'UNRQNVVFTK');
if (_tracker.goon(ctl,ctrlValue)) {
w_CITTADIN2=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UNRQNVVFTK',0);
if (l_bResult) {
l_bResult=Link_UNRQNVVFTK(kmode);
if ( ! (l_bResult)) {
w_CITTADIN2=HtW('','C');
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
function Set_CITTADIN1(ctrlValue,kmode,e) {
if (Ne(w_CITTADIN1,ctrlValue)) {
var ctl = _GetCtl(e,'CJBEXKJOQO');
if (_tracker.goon(ctl,ctrlValue)) {
w_CITTADIN1=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CJBEXKJOQO',0);
if (l_bResult) {
l_bResult=Link_CJBEXKJOQO(kmode);
if ( ! (l_bResult)) {
w_CITTADIN1=HtW('','C');
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
function Set_ODB(ctrlValue,kmode,e) {
if (Ne(w_ODB,ctrlValue)) {
var ctl = _GetCtl(e,'EOYNWRHHMY');
if (_tracker.goon(ctl,ctrlValue)) {
w_ODB=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('EOYNWRHHMY',0);
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
function Set_FATCA(ctrlValue,kmode,e) {
if (Ne(w_FATCA,ctrlValue)) {
var ctl = _GetCtl(e,'RKHMYOIJDM');
if (_tracker.goon(ctl,ctrlValue)) {
w_FATCA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RKHMYOIJDM',0);
if (l_bResult) {
l_bResult=Link_RKHMYOIJDM(kmode);
if ( ! (l_bResult)) {
w_FATCA=HtW('','C');
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
function Set_DATARAUT(ctrlValue,kmode,e) {
if (Ne(w_DATARAUT,ctrlValue)) {
var ctl = _GetCtl(e,'UNPDFRUOXO');
if (_tracker.goon(ctl,ctrlValue)) {
w_DATARAUT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UNPDFRUOXO',0);
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
function Set_DATASEGN(ctrlValue,kmode,e) {
if (Ne(w_DATASEGN,ctrlValue)) {
var ctl = _GetCtl(e,'ESODTMPIYO');
if (_tracker.goon(ctl,ctrlValue)) {
w_DATASEGN=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ESODTMPIYO',0);
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
function Set_TIPOSOGGETTO(ctrlValue,kmode,e) {
if (Ne(w_TIPOSOGGETTO,ctrlValue)) {
var ctl = _GetCtl(e,'JJETXTUKNC');
if (_tracker.goon(ctl,ctrlValue)) {
w_TIPOSOGGETTO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('JJETXTUKNC',0);
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
function Set_RAPSEGNA(ctrlValue,kmode,e) {
if (Ne(w_RAPSEGNA,ctrlValue)) {
var ctl = _GetCtl(e,'JFJPGOWVYJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_RAPSEGNA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('JFJPGOWVYJ',0);
if (l_bResult) {
l_bResult=arfn_chk_tiporapporto(w_TIPOSOGGETTO,w_RAPSEGNA);
if ( ! (l_bResult)) {
m_nLastError=2;
m_cLastWorkVarErrorMsg='1723736132';
m_cLastMsgError=AlertErrorMessage('10358848056');
}
if ( ! (l_bResult)) {
w_RAPSEGNA=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',1,0,''));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_RNATGIU(ctrlValue,kmode,e) {
if (Ne(w_RNATGIU,ctrlValue)) {
var ctl = _GetCtl(e,'AAQYBAEHUR');
if (_tracker.goon(ctl,ctrlValue)) {
w_RNATGIU=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('AAQYBAEHUR',0);
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
var ctl = _GetCtl(e,'PGYFWWGOTN');
if (_tracker.goon(ctl,ctrlValue)) {
w_RAREA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('PGYFWWGOTN',0);
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
var ctl = _GetCtl(e,'NXVXQSLAGM');
if (_tracker.goon(ctl,ctrlValue)) {
w_AREAGEO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NXVXQSLAGM',0);
if (l_bResult) {
l_bResult=Link_NXVXQSLAGM(kmode);
if ( ! (l_bResult)) {
w_AREAGEO=HtW('','C');
}
}
l_bResult=l_bResult && _ChkObl('JHEJMIHGSH',0);
if (l_bResult) {
if ( ! (l_bResult)) {
w_AREAGEO=HtW('','C');
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
function Set_RATTIV(ctrlValue,kmode,e) {
if (Ne(w_RATTIV,ctrlValue)) {
var ctl = _GetCtl(e,'BOECHNDAXS');
if (_tracker.goon(ctl,ctrlValue)) {
w_RATTIV=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BOECHNDAXS',0);
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
function Set_TIN(ctrlValue,kmode,e) {
if (Ne(w_TIN,ctrlValue)) {
var ctl = _GetCtl(e,'HBSPPQBOJN');
if (_tracker.goon(ctl,ctrlValue)) {
w_TIN=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HBSPPQBOJN',0);
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
function Set_CODLEGRAP(ctrlValue,kmode,e) {
if (Ne(w_CODLEGRAP,ctrlValue)) {
var ctl = _GetCtl(e,'CKHRNQSKKQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_CODLEGRAP=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CKHRNQSKKQ',0);
if (l_bResult) {
l_bResult=Link_CKHRNQSKKQ(kmode);
if ( ! (l_bResult)) {
w_CODLEGRAP=HtW('','C');
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
function Set_DISATTIVO(ctrlValue,kmode,e) {
if (Ne(w_DISATTIVO,ctrlValue)) {
var ctl = _GetCtl(e,'ODWJZUZDBK');
if (_tracker.goon(ctl,ctrlValue)) {
w_DISATTIVO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ODWJZUZDBK',0);
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
function Set_DATAINI(ctrlValue,kmode,e) {
if (Ne(w_DATAINI,ctrlValue)) {
var ctl = _GetCtl(e,'REJDXHTDMV');
if (_tracker.goon(ctl,ctrlValue)) {
w_DATAINI=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('REJDXHTDMV',0);
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
function Set_FLGNOTRIM(ctrlValue,kmode,e) {
if (Ne(w_FLGNOTRIM,ctrlValue)) {
var ctl = _GetCtl(e,'XERWNYQDBZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLGNOTRIM=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XERWNYQDBZ',0);
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
function Set_FATTURATO(ctrlValue,kmode,e) {
if (Ne(w_FATTURATO,ctrlValue)) {
var ctl = _GetCtl(e,'XOROAVXTCD');
if (_tracker.goon(ctl,ctrlValue)) {
w_FATTURATO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XOROAVXTCD',0);
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
function Set_BANCABEN(ctrlValue,kmode,e) {
if (Ne(w_BANCABEN,ctrlValue)) {
var ctl = _GetCtl(e,'DQZNJUSTLN');
if (_tracker.goon(ctl,ctrlValue)) {
w_BANCABEN=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('DQZNJUSTLN',0);
if (l_bResult) {
l_bResult=Link_DQZNJUSTLN(kmode);
if ( ! (l_bResult)) {
w_BANCABEN=HtW('','C');
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
function Set_DATAFINE(ctrlValue,kmode,e) {
if (Ne(w_DATAFINE,ctrlValue)) {
var ctl = _GetCtl(e,'YZOYIYAUUO');
if (_tracker.goon(ctl,ctrlValue)) {
w_DATAFINE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YZOYIYAUUO',0);
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
function Set_RCOMP(ctrlValue,kmode,e) {
if (Ne(w_RCOMP,ctrlValue)) {
var ctl = _GetCtl(e,'ISJKSRTDAC');
if (_tracker.goon(ctl,ctrlValue)) {
w_RCOMP=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ISJKSRTDAC',0);
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
function Calculate() {
var l_bTmpRes;
var l_bResult = true;
m_bCalculating=true;
if ((Ne(o_gIntemediario,w_gIntemediario))) {
l_bTmpRes=Link_LDTVEYLAXJ(null);
}
w_dataoggi=SystemDate();
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
if ((Ne(o_RAMOGRUP,w_RAMOGRUP))) {
l_bTmpRes=Link_RVNHQCXNEM(null);
}
if ((Ne(o_SOTGRUP,w_SOTGRUP)) || (Ne(o_ATTIVR,w_ATTIVR)) || (Ne(o_tipsot,w_tipsot))) {
l_bTmpRes=Link_SAQTIHOALW(null);
}
UpdateAutonumber('PROGIMPORT');
if ((Ne(o_SOTGRUP,w_SOTGRUP))) {
Calculation_DRKQLYFONU();
}
if ((Ne(o_SOTGRUP,w_SOTGRUP)) || (Ne(o_ATTIVR,w_ATTIVR))) {
Calculation_OIDLDZGYTQ();
}
if ((Ne(o_DATANASC,w_DATANASC))) {
Calculation_KCPGJNDBIS();
}
if ((Ne(o_COGNOME,w_COGNOME)) || (Ne(o_NOME,w_NOME))) {
Calculation_UEZIABOGNW();
}
if ((Ne(o_NASSTATO,w_NASSTATO)) || (Ne(o_IDNASSTATO,w_IDNASSTATO))) {
Calculation_DWHWPBJTAT();
}
if ((Ne(o_DESCCIT,w_DESCCIT)) || (Ne(o_PAESE,w_PAESE))) {
Calculation_VAVYJKHLRY();
}
if ((Ne(o_CONNES,w_CONNES))) {
l_bTmpRes=Link_MQYKJYJENJ(null);
}
if ((Ne(o_AREAGEO,w_AREAGEO))) {
l_bTmpRes=Link_JHEJMIHGSH(null);
}
if ((Ne(o_PKTBSPECIE,w_PKTBSPECIE))) {
l_bTmpRes=Link_DRJTSDRPVN(null);
}
if ((Ne(o_ATTIV,w_ATTIV))) {
l_bTmpRes=Link_QFJRACGINU(null);
}
if ((Ne(o_COMPORT,w_COMPORT))) {
l_bTmpRes=Link_KYTSUTYBUR(null);
}
w_Rilevazioni.Calculate(w_CONNES,w_status);
LibJavascript.forEachItem(m_FoundlingCopyWorkVar,i_body_1)
function i_body_1(child){
child();
}
// * --- Area Manuale = UI - Calculate
// * --- armt_personbo
Set_status(m_cFunction);
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
function Calculation_DRKQLYFONU() {
w_ATTIV=(Eq(w_tipsot,'1')?w_ATTIV:Space(10));
Link_SAQTIHOALW(null);
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
function Check_HBWSCTWHSU(p_bForce) {
var l_bResult = true;
if (p_bForce) {
l_bResult=(w_COMPLETA?((Eq(w_PAESE,'086') || Eq(w_PAESE,'139')) && Empty(w_CODFISC)?false:true):true);
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
l_bResult=(w_COMPLETA?arfn_chklundoc(w_TIPODOC,w_PAESE,w_NUMDOCUM,w_DATARILASC):true);
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
l_bResult=(w_COMPLETA?((Eq(w_PAESE,'086') || Eq(w_PAESE,'139')) && Ge(Left(w_SOTGRUP,1),'7')?false:true):true);
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
l_bResult=(w_COMPLETA?((Ne(w_PAESE,'086') && Ne(w_PAESE,'139')) && Lt(Left(w_SOTGRUP,1),'7')?false:true):true);
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
l_bResult=(w_COMPLETA?( ! (Empty(w_DATARILASC)) &&  ! (Empty(w_DATANASC)) && Gt(w_DATANASC,w_DATARILASC)?false:true):true);
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
o_CONNES=w_CONNES;
o_tipsot=w_tipsot;
o_AREAGEO=w_AREAGEO;
o_PKTBSPECIE=w_PKTBSPECIE;
o_ATTIVR=w_ATTIVR;
o_COMPORT=w_COMPORT;
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
l_oWv.setValue('PKFields',WtA('CITTA','C'));
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
l_Appl.SetStringKey('IDBASE',w_nascomunid,40,0);
l_Appl.SetFields('IDBASE,CITTA,PROV');
l_Appl.SetTypes('C,C,C');
l_Appl.LinkTable('tbcittna');
l_Appl.SetID('ZRIWLTGERM');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_nascomunid=l_Appl.GetStringValue('IDBASE',40,0);
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
w_ATTIVR=l_Appl.GetStringValue('CODICE',10,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_SAQTIHOALW_Blank();
l_bResult=true;
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
l_bResult=(w_COMPLETA?arfn_chkateco(w_SOTGRUP,w_ATTIV) || Ne(w_tipsot,'1'):true);
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
w_xdesctipatt='';
w_ATTIVR='';
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
function Link_MQYKJYJENJ(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CONNES);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CONNES',w_CONNES,16,0);
l_Appl.SetFields('CONNES,FLGVALIDO,FLGANAVAL');
l_Appl.SetTypes('C,C,C');
l_Appl.LinkTable('personbo_agg');
l_Appl.SetID('MQYKJYJENJ');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CONNES=l_Appl.GetStringValue('CONNES',16,0);
w_xFLGVALIDO=l_Appl.GetStringValue('FLGVALIDO',1,0);
w_xFLGANAVAL=l_Appl.GetStringValue('FLGANAVAL',1,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_MQYKJYJENJ_Blank();
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
function Link_MQYKJYJENJ_Blank() {
w_xFLGVALIDO='';
w_xFLGANAVAL='';
}
function LOpt_MQYKJYJENJ() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('personbo_agg','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CONNES','C'));
l_oWv.setValue('LinkedField',WtA('CONNES','C'));
l_oWv.setValue('UID',WtA('MQYKJYJENJ','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['MQYKJYJENJ'][1],'C'));
return l_oWv;
}
function Link_CKHRNQSKKQ(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CODLEGRAP);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CONNES',w_CODLEGRAP,16,0);
l_Appl.SetFields('CONNES,RAGSOC,IDBASE');
l_Appl.SetTypes('C,C,C');
l_Appl.LinkTable('personbo');
l_Appl.SetLinkzoom('opemt_personbo');
l_Appl.SetID('CKHRNQSKKQ');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?3:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CODLEGRAP=l_Appl.GetStringValue('CONNES',16,0);
w_xRAGLEGRAP=l_Appl.GetStringValue('RAGSOC',70,0);
w_xIDLEGRAP=l_Appl.GetStringValue('IDBASE',10,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_CKHRNQSKKQ_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_CKHRNQSKKQ';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_CKHRNQSKKQ();
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
function Link_CKHRNQSKKQ_Blank() {
w_CODLEGRAP='';
w_xRAGLEGRAP='';
w_xIDLEGRAP='';
}
function LOpt_CKHRNQSKKQ() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('personbo','C'));
l_oWv.setValue('Linkzoomprg',WtA('opemt_personbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CONNES','C'));
l_oWv.setValue('LinkedField',WtA('CONNES','C'));
l_oWv.setValue('UID',WtA('CKHRNQSKKQ','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['CKHRNQSKKQ'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('10938145308'),'C'));
return l_oWv;
}
function Link_DQZNJUSTLN(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_BANCABEN);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODINTER',w_BANCABEN,11,0);
l_Appl.SetFields('CODINTER,RAGSOC');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('inter2bo');
l_Appl.SetID('DQZNJUSTLN');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_BANCABEN=l_Appl.GetStringValue('CODINTER',11,0);
w_ragbanben=l_Appl.GetStringValue('RAGSOC',70,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_DQZNJUSTLN_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_DQZNJUSTLN';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_DQZNJUSTLN();
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
function Link_DQZNJUSTLN_Blank() {
w_BANCABEN='';
w_ragbanben='';
}
function LOpt_DQZNJUSTLN() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('inter2bo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODINTER','C'));
l_oWv.setValue('LinkedField',WtA('CODINTER','C'));
l_oWv.setValue('UID',WtA('DQZNJUSTLN','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['DQZNJUSTLN'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('10574890250'),'C'));
return l_oWv;
}
function Link_RKHMYOIJDM(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_FATCA);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODSTA',w_FATCA,3,0);
l_Appl.SetFields('CODSTA,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbstati');
l_Appl.SetID('RKHMYOIJDM');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_FATCA=l_Appl.GetStringValue('CODSTA',3,0);
w_xdesfatca=l_Appl.GetStringValue('DESCRI',40,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_RKHMYOIJDM_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_RKHMYOIJDM';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_RKHMYOIJDM();
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
function Link_RKHMYOIJDM_Blank() {
w_FATCA='';
w_xdesfatca='';
}
function LOpt_RKHMYOIJDM() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstati','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODSTA','C'));
l_oWv.setValue('LinkedField',WtA('CODSTA','C'));
l_oWv.setValue('UID',WtA('RKHMYOIJDM','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['RKHMYOIJDM'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('7383187'),'C'));
return l_oWv;
}
function Link_CJBEXKJOQO(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CITTADIN1);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODSTA',w_CITTADIN1,3,0);
l_Appl.SetFields('CODSTA,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbstati');
l_Appl.SetID('CJBEXKJOQO');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CITTADIN1=l_Appl.GetStringValue('CODSTA',3,0);
w_xDesCit1=l_Appl.GetStringValue('DESCRI',40,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_CJBEXKJOQO_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_CJBEXKJOQO';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_CJBEXKJOQO();
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
function Link_CJBEXKJOQO_Blank() {
w_CITTADIN1='';
w_xDesCit1='';
}
function LOpt_CJBEXKJOQO() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstati','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODSTA','C'));
l_oWv.setValue('LinkedField',WtA('CODSTA','C'));
l_oWv.setValue('UID',WtA('CJBEXKJOQO','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['CJBEXKJOQO'][1],'C'));
return l_oWv;
}
function Link_UNRQNVVFTK(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CITTADIN2);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODSTA',w_CITTADIN2,3,0);
l_Appl.SetFields('CODSTA,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbstati');
l_Appl.SetID('UNRQNVVFTK');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CITTADIN2=l_Appl.GetStringValue('CODSTA',3,0);
w_xDesCit2=l_Appl.GetStringValue('DESCRI',40,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_UNRQNVVFTK_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_UNRQNVVFTK';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_UNRQNVVFTK();
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
function Link_UNRQNVVFTK_Blank() {
w_CITTADIN2='';
w_xDesCit2='';
}
function LOpt_UNRQNVVFTK() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstati','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODSTA','C'));
l_oWv.setValue('LinkedField',WtA('CODSTA','C'));
l_oWv.setValue('UID',WtA('UNRQNVVFTK','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['UNRQNVVFTK'][1],'C'));
return l_oWv;
}
function Link_OSLBLDODHQ(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_RESFISC);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODSTA',w_RESFISC,3,0);
l_Appl.SetFields('CODSTA,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbstati');
l_Appl.SetID('OSLBLDODHQ');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_RESFISC=l_Appl.GetStringValue('CODSTA',3,0);
w_xResFis=l_Appl.GetStringValue('DESCRI',40,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_OSLBLDODHQ_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_OSLBLDODHQ';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_OSLBLDODHQ();
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
function Link_OSLBLDODHQ_Blank() {
w_RESFISC='';
w_xResFis='';
}
function LOpt_OSLBLDODHQ() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstati','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODSTA','C'));
l_oWv.setValue('LinkedField',WtA('CODSTA','C'));
l_oWv.setValue('UID',WtA('OSLBLDODHQ','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['OSLBLDODHQ'][1],'C'));
return l_oWv;
}
function Link_NXVXQSLAGM(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_AREAGEO);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODICE',w_AREAGEO,3,0);
l_Appl.SetFields('CODICE,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbareegeog');
l_Appl.SetID('NXVXQSLAGM');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_AREAGEO=l_Appl.GetStringValue('CODICE',3,0);
w_xdescareag=l_Appl.GetStringValue('DESCRI',50,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_NXVXQSLAGM_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_NXVXQSLAGM';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_NXVXQSLAGM();
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
function Link_NXVXQSLAGM_Blank() {
w_AREAGEO='';
w_xdescareag='';
}
function LOpt_NXVXQSLAGM() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbareegeog','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODICE','C'));
l_oWv.setValue('LinkedField',WtA('CODICE','C'));
l_oWv.setValue('UID',WtA('NXVXQSLAGM','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['NXVXQSLAGM'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('11053408024'),'C'));
return l_oWv;
}
function Link_JHEJMIHGSH(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_AREAGEO);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODICE',w_AREAGEO,3,0);
l_Appl.SetFields('CODICE,RISCHIO');
l_Appl.SetTypes('C,N');
l_Appl.LinkTable('tbareegeog_p');
l_Appl.SetID('JHEJMIHGSH');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_AREAGEO=l_Appl.GetStringValue('CODICE',3,0);
w_RAREA=l_Appl.GetDoubleValue('RISCHIO',3,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_JHEJMIHGSH_Blank();
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
function Link_JHEJMIHGSH_Blank() {
w_AREAGEO='';
w_RAREA=0;
}
function LOpt_JHEJMIHGSH() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbareegeog_p','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODICE','C'));
l_oWv.setValue('LinkedField',WtA('CODICE','C'));
l_oWv.setValue('UID',WtA('JHEJMIHGSH','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['JHEJMIHGSH'][1],'C'));
return l_oWv;
}
function Link_VHXDWWHVXF(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_PKTBSPECIE);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODSPE',w_PKTBSPECIE,4,0);
l_Appl.SetFields('CODSPE,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbspecie');
l_Appl.SetLinkzoom('armt_tbspecie');
l_Appl.SetID('VHXDWWHVXF');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_PKTBSPECIE=l_Appl.GetStringValue('CODSPE',4,0);
w_xdescnatgiu=l_Appl.GetStringValue('DESCRI',60,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_VHXDWWHVXF_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_VHXDWWHVXF';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_VHXDWWHVXF();
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
function Link_VHXDWWHVXF_Blank() {
w_PKTBSPECIE='';
w_xdescnatgiu='';
}
function LOpt_VHXDWWHVXF() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbspecie','C'));
l_oWv.setValue('Linkzoomprg',WtA('armt_tbspecie','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODSPE','C'));
l_oWv.setValue('LinkedField',WtA('CODSPE','C'));
l_oWv.setValue('UID',WtA('VHXDWWHVXF','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['VHXDWWHVXF'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('11158852142'),'C'));
return l_oWv;
}
function Link_DRJTSDRPVN(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_PKTBSPECIE);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODSPE',w_PKTBSPECIE,4,0);
l_Appl.SetFields('CODSPE,RISCHIO');
l_Appl.SetTypes('C,N');
l_Appl.LinkTable('tbspecie_p');
l_Appl.SetID('DRJTSDRPVN');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_PKTBSPECIE=l_Appl.GetStringValue('CODSPE',4,0);
w_RNATGIU=l_Appl.GetDoubleValue('RISCHIO',3,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_DRJTSDRPVN_Blank();
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
function Link_DRJTSDRPVN_Blank() {
w_PKTBSPECIE='';
w_RNATGIU=0;
}
function LOpt_DRJTSDRPVN() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbspecie_p','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODSPE','C'));
l_oWv.setValue('LinkedField',WtA('CODSPE','C'));
l_oWv.setValue('UID',WtA('DRJTSDRPVN','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['DRJTSDRPVN'][1],'C'));
return l_oWv;
}
function Link_UQYOQYIUNM(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_ATTIVR);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODICE',w_ATTIVR,10,0);
l_Appl.SetFields('CODICE');
l_Appl.SetTypes('C');
l_Appl.LinkTable('tbtipatt');
l_Appl.SetID('UQYOQYIUNM');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_ATTIVR=l_Appl.GetStringValue('CODICE',10,0);
w_ATTIV=l_Appl.GetStringValue('CODICE',10,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_UQYOQYIUNM_Blank();
l_bResult=true;
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_UQYOQYIUNM';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_UQYOQYIUNM();
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
function Link_UQYOQYIUNM_Blank() {
w_ATTIV='';
}
function LOpt_UQYOQYIUNM() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbtipatt','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODICE','C'));
l_oWv.setValue('LinkedField',WtA('CODICE','C'));
l_oWv.setValue('UID',WtA('UQYOQYIUNM','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['UQYOQYIUNM'][1],'C'));
return l_oWv;
}
function Link_QFJRACGINU(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_ATTIV);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODICE',w_ATTIV,10,0);
l_Appl.SetFields('CODICE,RISCHIO,FLGALTO');
l_Appl.SetTypes('C,N,N');
l_Appl.LinkTable('tbtipatt_p');
l_Appl.SetID('QFJRACGINU');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_ATTIV=l_Appl.GetStringValue('CODICE',10,0);
w_RATTIV=l_Appl.GetDoubleValue('RISCHIO',3,0);
w_FLGALTO=l_Appl.GetDoubleValue('FLGALTO',1,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_QFJRACGINU_Blank();
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
function Link_QFJRACGINU_Blank() {
w_RATTIV=0;
w_FLGALTO=0;
}
function LOpt_QFJRACGINU() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbtipatt_p','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODICE','C'));
l_oWv.setValue('LinkedField',WtA('CODICE','C'));
l_oWv.setValue('UID',WtA('QFJRACGINU','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['QFJRACGINU'][1],'C'));
return l_oWv;
}
function Link_HLXRSSMBIW(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_COMPORT);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODICE',w_COMPORT,5,0);
l_Appl.SetFields('CODICE,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbcondotta');
l_Appl.SetLinkzoom('armt_tbcondotta');
l_Appl.SetID('HLXRSSMBIW');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_COMPORT=l_Appl.GetStringValue('CODICE',5,0);
w_xdesccomp=l_Appl.GetStringValue('DESCRI',200,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_HLXRSSMBIW_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_HLXRSSMBIW';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_HLXRSSMBIW();
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
function Link_HLXRSSMBIW_Blank() {
w_COMPORT='';
w_xdesccomp='';
}
function LOpt_HLXRSSMBIW() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcondotta','C'));
l_oWv.setValue('Linkzoomprg',WtA('armt_tbcondotta','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODICE','C'));
l_oWv.setValue('LinkedField',WtA('CODICE','C'));
l_oWv.setValue('UID',WtA('HLXRSSMBIW','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['HLXRSSMBIW'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('10049460300'),'C'));
return l_oWv;
}
function Link_KYTSUTYBUR(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_COMPORT);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODICE',w_COMPORT,5,0);
l_Appl.SetFields('CODICE,RISCHIO');
l_Appl.SetTypes('C,N');
l_Appl.LinkTable('tbcondotta_p');
l_Appl.SetID('KYTSUTYBUR');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_COMPORT=l_Appl.GetStringValue('CODICE',5,0);
w_RCOMP=l_Appl.GetDoubleValue('RISCHIO',3,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_KYTSUTYBUR_Blank();
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
function Link_KYTSUTYBUR_Blank() {
w_COMPORT='';
w_RCOMP=0;
}
function LOpt_KYTSUTYBUR() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcondotta_p','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODICE','C'));
l_oWv.setValue('LinkedField',WtA('CODICE','C'));
l_oWv.setValue('UID',WtA('KYTSUTYBUR','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['KYTSUTYBUR'][1],'C'));
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
if (Eq(varName,'CKHRNQSKKQ')) {
last_focused_comp=GetLastFocusedElementOfLink('CKHRNQSKKQ');
function SetMethod_CKHRNQSKKQ() {
Set_CODLEGRAP(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_CKHRNQSKKQ();
} else {
setTimeout(SetMethod_CKHRNQSKKQ,1);
}
bResult=true;
}
if (Eq(varName,'DQZNJUSTLN')) {
last_focused_comp=GetLastFocusedElementOfLink('DQZNJUSTLN');
function SetMethod_DQZNJUSTLN() {
Set_BANCABEN(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_DQZNJUSTLN();
} else {
setTimeout(SetMethod_DQZNJUSTLN,1);
}
bResult=true;
}
if (Eq(varName,'RKHMYOIJDM')) {
last_focused_comp=GetLastFocusedElementOfLink('RKHMYOIJDM');
function SetMethod_RKHMYOIJDM() {
Set_FATCA(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_RKHMYOIJDM();
} else {
setTimeout(SetMethod_RKHMYOIJDM,1);
}
bResult=true;
}
if (Eq(varName,'CJBEXKJOQO')) {
last_focused_comp=GetLastFocusedElementOfLink('CJBEXKJOQO');
function SetMethod_CJBEXKJOQO() {
Set_CITTADIN1(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_CJBEXKJOQO();
} else {
setTimeout(SetMethod_CJBEXKJOQO,1);
}
bResult=true;
}
if (Eq(varName,'UNRQNVVFTK')) {
last_focused_comp=GetLastFocusedElementOfLink('UNRQNVVFTK');
function SetMethod_UNRQNVVFTK() {
Set_CITTADIN2(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_UNRQNVVFTK();
} else {
setTimeout(SetMethod_UNRQNVVFTK,1);
}
bResult=true;
}
if (Eq(varName,'OSLBLDODHQ')) {
last_focused_comp=GetLastFocusedElementOfLink('OSLBLDODHQ');
function SetMethod_OSLBLDODHQ() {
Set_RESFISC(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_OSLBLDODHQ();
} else {
setTimeout(SetMethod_OSLBLDODHQ,1);
}
bResult=true;
}
if (Eq(varName,'NXVXQSLAGM')) {
last_focused_comp=GetLastFocusedElementOfLink('NXVXQSLAGM');
function SetMethod_NXVXQSLAGM() {
Set_AREAGEO(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_NXVXQSLAGM();
} else {
setTimeout(SetMethod_NXVXQSLAGM,1);
}
bResult=true;
}
if (Eq(varName,'VHXDWWHVXF')) {
last_focused_comp=GetLastFocusedElementOfLink('VHXDWWHVXF');
function SetMethod_VHXDWWHVXF() {
Set_PKTBSPECIE(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_VHXDWWHVXF();
} else {
setTimeout(SetMethod_VHXDWWHVXF,1);
}
bResult=true;
}
if (Eq(varName,'UQYOQYIUNM')) {
last_focused_comp=GetLastFocusedElementOfLink('UQYOQYIUNM');
function SetMethod_UQYOQYIUNM() {
Set_ATTIVR(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_UQYOQYIUNM();
} else {
setTimeout(SetMethod_UQYOQYIUNM,1);
}
bResult=true;
}
if (Eq(varName,'HLXRSSMBIW')) {
last_focused_comp=GetLastFocusedElementOfLink('HLXRSSMBIW');
function SetMethod_HLXRSSMBIW() {
Set_COMPORT(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_HLXRSSMBIW();
} else {
setTimeout(SetMethod_HLXRSSMBIW,1);
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
if (Eq(varName,'CKHRNQSKKQ')) {
return [Ctrl('CKHRNQSKKQ')];
}
if (Eq(varName,'DQZNJUSTLN')) {
return [Ctrl('DQZNJUSTLN')];
}
if (Eq(varName,'RKHMYOIJDM')) {
return [Ctrl('RKHMYOIJDM')];
}
if (Eq(varName,'CJBEXKJOQO')) {
return [Ctrl('CJBEXKJOQO')];
}
if (Eq(varName,'UNRQNVVFTK')) {
return [Ctrl('UNRQNVVFTK')];
}
if (Eq(varName,'OSLBLDODHQ')) {
return [Ctrl('OSLBLDODHQ')];
}
if (Eq(varName,'NXVXQSLAGM')) {
return [Ctrl('NXVXQSLAGM')];
}
if (Eq(varName,'VHXDWWHVXF')) {
return [Ctrl('VHXDWWHVXF')];
}
if (Eq(varName,'UQYOQYIUNM')) {
return [Ctrl('UQYOQYIUNM')];
}
if (Eq(varName,'HLXRSSMBIW')) {
return [Ctrl('HLXRSSMBIW')];
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
parent.ZtVWeb.raiseEventToEvalParms('armt_personbo_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('armt_personbo_dataNotSent',{'action':formaction});
}
}
}
}
CheckChild.child=[{'prg':"ardt_personbo_dip",'BOScId':function(){ return FrameRef('ardt_personbo_dip')},'repeated':0},{'prg':"armt_personbo_agg",'BOScId':function(){ return FrameRef('armt_personbo_agg')},'repeated':0},{'prg':"ardt_soggope",'BOScId':function(){ return FrameRef('ardt_soggope')},'repeated':0},{'prg':"ardt_fatca_ind",'BOScId':function(){ return FrameRef('ardt_fatca_ind')},'repeated':0},{'prg':"ardt_patrimonio",'BOScId':function(){ return FrameRef('ardt_patrimonio')},'repeated':0},{'prg':"ardt_reddito",'BOScId':function(){ return FrameRef('ardt_reddito')},'repeated':0}];
function Check() {
var l_bResult = true;
var l_bChildCheck = true;
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
} else if ((Ne(w_xFLGVALIDO,'S')) && (( ! (_ChkObl('OJJHIUDPFY',1))) || ( ! ((w_COMPLETA?arfn_chkcodfis(w_CODFISC,w_PAESE,w_CFESTERO):true))))) {
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
} else if (( ! (_ChkObl('SAQTIHOALW',1))) || ( ! (Empty(w_ATTIV)) &&  ! ((w_COMPLETA?arfn_chkateco(w_SOTGRUP,w_ATTIV) || Ne(w_tipsot,'1'):true)))) {
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
} else if ( ! (_ChkObl('XCYZDRXAMJ',1))) {
_SignErr('XCYZDRXAMJ');
m_cLastWorkVarErrorMsg='10450770185';
l_bResult=false;
w_NOSARA='N';
} else if ( ! (_ChkObl('RARXYHBSLM',1))) {
_SignErr('RARXYHBSLM');
m_cLastWorkVarErrorMsg='327723579';
l_bResult=false;
w_NOTIT=0;
} else if ( ! (_ChkObl('DFNZBCOVFH',1))) {
_SignErr('DFNZBCOVFH');
m_cLastWorkVarErrorMsg='flgaggfam';
l_bResult=false;
w_flgaggfam='N';
} else if ( ! (_ChkObl('FROMUIZATY',1))) {
_SignErr('FROMUIZATY');
m_cLastWorkVarErrorMsg='DATARETT';
l_bResult=false;
w_DATARETT=HtW('','D');
} else if ( ! (_ChkObl('YZOYIYAUUO',1))) {
_SignErr('YZOYIYAUUO');
m_cLastWorkVarErrorMsg='1823975349';
l_bResult=false;
w_DATAFINE=HtW('','D');
} else if ( ! (_ChkObl('REJDXHTDMV',1))) {
_SignErr('REJDXHTDMV');
m_cLastWorkVarErrorMsg='1823814263';
l_bResult=false;
w_DATAINI=HtW('','D');
} else if ( ! (_ChkObl('ODWJZUZDBK',1))) {
_SignErr('ODWJZUZDBK');
m_cLastWorkVarErrorMsg='1735362560';
l_bResult=false;
w_DISATTIVO=HtW('','D');
} else if ( ! (_ChkObl('JJETXTUKNC',1))) {
_SignErr('JJETXTUKNC');
m_cLastWorkVarErrorMsg='10456253029';
l_bResult=false;
w_TIPOSOGGETTO=HtW('','C');
} else if (( ! (_ChkObl('JFJPGOWVYJ',1))) || ( ! (arfn_chk_tiporapporto(w_TIPOSOGGETTO,w_RAPSEGNA)))) {
_SignErr('JFJPGOWVYJ','10358848056');
l_bResult=false;
w_RAPSEGNA=HtW('','C');
} else if ( ! (_ChkObl('HKQDVAPIOQ',1))) {
_SignErr('HKQDVAPIOQ');
m_cLastWorkVarErrorMsg='78498981';
l_bResult=false;
w_SOGAFFIDATARIO=HtW('','C');
} else if ( ! (_ChkObl('EMSGWJAYYK',1))) {
_SignErr('EMSGWJAYYK');
m_cLastWorkVarErrorMsg='10412866585';
l_bResult=false;
w_CAUSALE=HtW('','N');
} else if ( ! (_ChkObl('XOROAVXTCD',1))) {
_SignErr('XOROAVXTCD');
m_cLastWorkVarErrorMsg='11466123579';
l_bResult=false;
w_FATTURATO=HtW('','N');
} else if ( ! (_ChkObl('XERWNYQDBZ',1))) {
_SignErr('XERWNYQDBZ');
m_cLastWorkVarErrorMsg='FLGNOTRIM';
l_bResult=false;
w_FLGNOTRIM='N';
} else if ( ! (_ChkObl('EVYVDDYVDZ',1))) {
_SignErr('EVYVDDYVDZ');
m_cLastWorkVarErrorMsg='11067638693';
l_bResult=false;
w_DATAIDENT=HtW('','D');
} else if ( ! (_ChkObl('BOHBZOSBVJ',1))) {
_SignErr('BOHBZOSBVJ');
m_cLastWorkVarErrorMsg='COMPLETA';
l_bResult=false;
w_COMPLETA=HtW('','L');
} else if ( ! (_ChkObl('UMKFMWBVUO',1))) {
_SignErr('UMKFMWBVUO');
m_cLastWorkVarErrorMsg='445246';
l_bResult=false;
w_NOTE=HtW('','M');
} else if ( ! (_ChkObl('CKHRNQSKKQ',1))) {
_SignErr('CKHRNQSKKQ');
m_cLastWorkVarErrorMsg='11815361151';
l_bResult=false;
w_CODLEGRAP=HtW('','C');
} else if ( ! (_ChkObl('DQZNJUSTLN',1))) {
_SignErr('DQZNJUSTLN');
m_cLastWorkVarErrorMsg='11391158649';
l_bResult=false;
w_BANCABEN=HtW('','C');
} else if ( ! (_ChkObl('ESODTMPIYO',1))) {
_SignErr('ESODTMPIYO');
m_cLastWorkVarErrorMsg='1893635209';
l_bResult=false;
w_DATASEGN=HtW('','D');
} else if ( ! (_ChkObl('UNPDFRUOXO',1))) {
_SignErr('UNPDFRUOXO');
m_cLastWorkVarErrorMsg='11132282623';
l_bResult=false;
w_DATARAUT=HtW('','D');
} else if ( ! (_ChkObl('RKHMYOIJDM',1))) {
_SignErr('RKHMYOIJDM');
m_cLastWorkVarErrorMsg='299426891';
l_bResult=false;
w_FATCA=HtW('','C');
} else if ( ! (_ChkObl('HBSPPQBOJN',1))) {
_SignErr('HBSPPQBOJN');
m_cLastWorkVarErrorMsg='12034347084';
l_bResult=false;
w_TIN=HtW('','C');
} else if ( ! (_ChkObl('EOYNWRHHMY',1))) {
_SignErr('EOYNWRHHMY');
m_cLastWorkVarErrorMsg='10390001687';
l_bResult=false;
w_ODB=0;
} else if ( ! (_ChkObl('CJBEXKJOQO',1))) {
_SignErr('CJBEXKJOQO');
m_cLastWorkVarErrorMsg='1390365716';
l_bResult=false;
w_CITTADIN1=HtW('','C');
} else if ( ! (_ChkObl('UNRQNVVFTK',1))) {
_SignErr('UNRQNVVFTK');
m_cLastWorkVarErrorMsg='CITTADIN2';
l_bResult=false;
w_CITTADIN2=HtW('','C');
} else if ( ! (_ChkObl('OSLBLDODHQ',1))) {
_SignErr('OSLBLDODHQ');
m_cLastWorkVarErrorMsg='RESFISC';
l_bResult=false;
w_RESFISC=HtW('','C');
} else if ( ! (_ChkObl('NXVXQSLAGM',1))) {
_SignErr('NXVXQSLAGM');
m_cLastWorkVarErrorMsg='AREAGEO';
l_bResult=false;
w_AREAGEO=HtW('','C');
} else if ( ! (_ChkObl('PGYFWWGOTN',1))) {
_SignErr('PGYFWWGOTN');
m_cLastWorkVarErrorMsg='RAREA';
l_bResult=false;
w_RAREA=HtW('','N');
} else if ( ! (_ChkObl('VHXDWWHVXF',1))) {
_SignErr('VHXDWWHVXF');
m_cLastWorkVarErrorMsg='PKTBSPECIE';
l_bResult=false;
w_PKTBSPECIE=HtW('','C');
} else if ( ! (_ChkObl('AAQYBAEHUR',1))) {
_SignErr('AAQYBAEHUR');
m_cLastWorkVarErrorMsg='RNATGIU';
l_bResult=false;
w_RNATGIU=HtW('','N');
} else if ( ! (_ChkObl('UQYOQYIUNM',1))) {
_SignErr('UQYOQYIUNM');
m_cLastWorkVarErrorMsg='2134156131';
l_bResult=false;
w_ATTIVR=HtW('','C');
} else if ((Eq(w_FLGALTO,0)) && ( ! (_ChkObl('BOECHNDAXS',1)))) {
_SignErr('BOECHNDAXS');
m_cLastWorkVarErrorMsg='RATTIV';
l_bResult=false;
w_RATTIV=HtW('','N');
} else if ( ! (_ChkObl('HLXRSSMBIW',1))) {
_SignErr('HLXRSSMBIW');
m_cLastWorkVarErrorMsg='COMPORT';
l_bResult=false;
w_COMPORT=HtW('','C');
} else if ( ! (_ChkObl('ISJKSRTDAC',1))) {
_SignErr('ISJKSRTDAC');
m_cLastWorkVarErrorMsg='RCOMP';
l_bResult=false;
w_RCOMP=HtW('','N');
} else if ( ! (_ChkObl('SMVVFHCEHA',1))) {
_SignErr('SMVVFHCEHA');
m_cLastWorkVarErrorMsg='10500809751';
l_bResult=false;
w_RISGLOB=HtW('','C');
} else if ( ! (_ChkObl('MXITFMGTNB',1))) {
_SignErr('MXITFMGTNB');
m_cLastWorkVarErrorMsg='10252637878';
l_bResult=false;
w_DATAPROF=HtW('','D');
} else if ( ! (_ChkObl('XFKXBQYUIU',1))) {
_SignErr('XFKXBQYUIU');
m_cLastWorkVarErrorMsg='1513560829';
l_bResult=false;
w_PEP='N';
} else if ( ! (_ChkObl('RHCYCLTWOT',1))) {
_SignErr('RHCYCLTWOT');
m_cLastWorkVarErrorMsg='10242518395';
l_bResult=false;
w_CRIME='N';
} else if ( ! (_ChkObl('DOXBACRWUU',1))) {
_SignErr('DOXBACRWUU');
m_cLastWorkVarErrorMsg='307787605';
l_bResult=false;
w_MITIG=HtW('','N');
} else if ( ! (_ChkObl('OXGBDTWKSX',1))) {
_SignErr('OXGBDTWKSX');
m_cLastWorkVarErrorMsg='210895516';
l_bResult=false;
w_MITIGDOC=HtW('','C');
} else if ( ! (_ChkObl('OXWRJNTXVJ',1))) {
_SignErr('OXWRJNTXVJ');
m_cLastWorkVarErrorMsg='1729760413';
l_bResult=false;
w_VERIFICA=HtW('','C');
} else if ( ! (_ChkObl('FTYWOEFIPD',1))) {
_SignErr('FTYWOEFIPD');
m_cLastWorkVarErrorMsg='11639044319';
l_bResult=false;
w_NOTERIS=HtW('','M');
} else if ((false) && ( ! (_ChkObl('YFBFKZZRWO',1)))) {
_SignErr('YFBFKZZRWO');
m_cLastWorkVarErrorMsg='status';
l_bResult=false;
w_status=HtW('','C');
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
// * --- armt_personbo
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
if (Eq('YZOYIYAUUO_ZOOM',lc)) {
return 5;
}
if (Eq('REJDXHTDMV_ZOOM',lc)) {
return 5;
}
if (Eq('ODWJZUZDBK_ZOOM',lc)) {
return 5;
}
if (Eq('EVYVDDYVDZ_ZOOM',lc)) {
return 5;
}
if (Eq('CKHRNQSKKQ_ZOOM',lc)) {
return 5;
}
if (Eq('CKHRNQSKKQ',lc)) {
return 5;
}
if (Eq('DQZNJUSTLN_ZOOM',lc)) {
return 6;
}
if (Eq('DQZNJUSTLN',lc)) {
return 6;
}
if (Eq('ESODTMPIYO_ZOOM',lc)) {
return 7;
}
if (Eq('UNPDFRUOXO_ZOOM',lc)) {
return 7;
}
if (Eq('RKHMYOIJDM_ZOOM',lc)) {
return 7;
}
if (Eq('RKHMYOIJDM',lc)) {
return 7;
}
if (Eq('CJBEXKJOQO_ZOOM',lc)) {
return 8;
}
if (Eq('CJBEXKJOQO',lc)) {
return 8;
}
if (Eq('UNRQNVVFTK_ZOOM',lc)) {
return 9;
}
if (Eq('UNRQNVVFTK',lc)) {
return 9;
}
if (Eq('OSLBLDODHQ_ZOOM',lc)) {
return 10;
}
if (Eq('OSLBLDODHQ',lc)) {
return 10;
}
if (Eq('NXVXQSLAGM_ZOOM',lc)) {
return 11;
}
if (Eq('NXVXQSLAGM',lc)) {
return 11;
}
if (Eq('VHXDWWHVXF_ZOOM',lc)) {
return 12;
}
if (Eq('VHXDWWHVXF',lc)) {
return 12;
}
if (Eq('UQYOQYIUNM_ZOOM',lc)) {
return 13;
}
if (Eq('UQYOQYIUNM',lc)) {
return 13;
}
if (Eq('HLXRSSMBIW_ZOOM',lc)) {
return 14;
}
if (Eq('HLXRSSMBIW',lc)) {
return 14;
}
if (Eq('MXITFMGTNB_ZOOM',lc)) {
return 15;
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
if (Eq(index,5)) {
l_oWv=LOpt_CKHRNQSKKQ();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,6)) {
l_oWv=LOpt_DQZNJUSTLN();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,7)) {
l_oWv=LOpt_RKHMYOIJDM();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,8)) {
l_oWv=LOpt_CJBEXKJOQO();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,9)) {
l_oWv=LOpt_UNRQNVVFTK();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,10)) {
l_oWv=LOpt_OSLBLDODHQ();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,11)) {
l_oWv=LOpt_NXVXQSLAGM();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,12)) {
l_oWv=LOpt_VHXDWWHVXF();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,13)) {
l_oWv=LOpt_UQYOQYIUNM();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,14)) {
l_oWv=LOpt_HLXRSSMBIW();
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
l_oWv.setValue('idcitta',WtA(w_idcitta,'C'));
l_oWv.setValue('PROVINCIA',WtA(w_PROVINCIA,'C'));
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
l_oWv.setValue('NOSARA',WtA(w_NOSARA,'C'));
l_oWv.setValue('NOTIT',WtA(w_NOTIT,'N'));
l_oWv.setValue('PROGIMPORT',WtA(w_PROGIMPORT,'N'));
l_oWv.setValue('op_PROGIMPORT',WtA(op_PROGIMPORT,'N'));
l_oWv.setValue('OLDSETSIN',WtA(w_OLDSETSIN,'C'));
l_oWv.setValue('CRIMEDATE',WtA(w_CRIMEDATE,'D'));
l_oWv.setValue('PEPDATE',WtA(w_PEPDATE,'D'));
l_oWv.setValue('NOTE',WtA(w_NOTE,'M'));
l_oWv.setValue('CODLEGRAP',WtA(w_CODLEGRAP,'C'));
l_oWv.setValue('FATCA',WtA(w_FATCA,'C'));
l_oWv.setValue('TIN',WtA(w_TIN,'C'));
l_oWv.setValue('ODB',WtA(w_ODB,'N'));
l_oWv.setValue('AREAGEO',WtA(w_AREAGEO,'C'));
l_oWv.setValue('RAREA',WtA(w_RAREA,'N'));
l_oWv.setValue('PKTBSPECIE',WtA(w_PKTBSPECIE,'C'));
l_oWv.setValue('RNATGIU',WtA(w_RNATGIU,'N'));
l_oWv.setValue('RATTIV',WtA(w_RATTIV,'N'));
l_oWv.setValue('COMPORT',WtA(w_COMPORT,'C'));
l_oWv.setValue('RCOMP',WtA(w_RCOMP,'N'));
l_oWv.setValue('DOCFILE',WtA(w_DOCFILE,'C'));
l_oWv.setValue('RISGLOB',WtA(w_RISGLOB,'C'));
l_oWv.setValue('DATAPROF',WtA(w_DATAPROF,'D'));
l_oWv.setValue('DATAREVPROF',WtA(w_DATAREVPROF,'D'));
l_oWv.setValue('PEP',WtA(w_PEP,'C'));
l_oWv.setValue('CRIME',WtA(w_CRIME,'C'));
l_oWv.setValue('MITIG',WtA(w_MITIG,'N'));
l_oWv.setValue('MITIGDOC',WtA(w_MITIGDOC,'C'));
l_oWv.setValue('DATAFINE',WtA(w_DATAFINE,'D'));
l_oWv.setValue('DATAINI',WtA(w_DATAINI,'D'));
l_oWv.setValue('DISATTIVO',WtA(w_DISATTIVO,'D'));
l_oWv.setValue('TIPOSOGGETTO',WtA(w_TIPOSOGGETTO,'C'));
l_oWv.setValue('RAPSEGNA',WtA(w_RAPSEGNA,'C'));
l_oWv.setValue('SOGAFFIDATARIO',WtA(w_SOGAFFIDATARIO,'C'));
l_oWv.setValue('CAUSALE',WtA(w_CAUSALE,'N'));
l_oWv.setValue('FATTURATO',WtA(w_FATTURATO,'N'));
l_oWv.setValue('FLGNOTRIM',WtA(w_FLGNOTRIM,'C'));
l_oWv.setValue('DATAIDENT',WtA(w_DATAIDENT,'D'));
l_oWv.setValue('CITTADIN1',WtA(w_CITTADIN1,'C'));
l_oWv.setValue('CITTADIN2',WtA(w_CITTADIN2,'C'));
l_oWv.setValue('RESFISC',WtA(w_RESFISC,'C'));
l_oWv.setValue('BANCABEN',WtA(w_BANCABEN,'C'));
l_oWv.setValue('DATASEGN',WtA(w_DATASEGN,'D'));
l_oWv.setValue('DATARAUT',WtA(w_DATARAUT,'D'));
l_oWv.setValue('VERIFICA',WtA(w_VERIFICA,'C'));
l_oWv.setValue('CODINTER',WtA(w_CODINTER,'C'));
l_oWv.setValue('NUMIMP',WtA(w_NUMIMP,'T'));
l_oWv.setValue('CODDIPE',WtA(w_CODDIPE,'C'));
l_oWv.setValue('SOSPMAF',WtA(w_SOSPMAF,'C'));
l_oWv.setValue('OLDCONNES',WtA(w_OLDCONNES,'C'));
l_oWv.setValue('DATEXTRA',WtA(w_DATEXTRA,'D'));
l_oWv.setValue('ALLINEATO',WtA(w_ALLINEATO,'N'));
l_oWv.setValue('ALLINEATONOMECNOME',WtA(w_ALLINEATONOMECNOME,'N'));
l_oWv.setValue('RAGSOCOLD',WtA(w_RAGSOCOLD,'C'));
l_oWv.setValue('PROGIMP_C',WtA(w_PROGIMP_C,'C'));
l_oWv.setValue('IDFILE',WtA(w_IDFILE,'C'));
l_oWv.setValue('OLDCODFISC',WtA(w_OLDCODFISC,'C'));
l_oWv.setValue('MACROAGENTE',WtA(w_MACROAGENTE,'C'));
l_oWv.setValue('SPOTID',WtA(w_SPOTID,'C'));
l_oWv.setValue('DATAVARAGE',WtA(w_DATAVARAGE,'D'));
l_oWv.setValue('SETTSINT2',WtA(w_SETTSINT2,'C'));
l_oWv.setValue('TELEF',WtA(w_TELEF,'C'));
l_oWv.setValue('TIPOORO',WtA(w_TIPOORO,'C'));
l_oWv.setValue('CODORO',WtA(w_CODORO,'C'));
l_oWv.setValue('FLGVALIDO',WtA(w_FLGVALIDO,'C'));
l_oWv.setValue('DAC6',WtA(w_DAC6,'C'));
l_oWv.setValue('ALTRODOM',WtA(w_ALTRODOM,'C'));
l_oWv.setValue('ALTROCAP',WtA(w_ALTROCAP,'C'));
l_oWv.setValue('IMPORTOMAX',WtA(w_IMPORTOMAX,'N'));
l_oWv.setValue('FREQUENZA',WtA(w_FREQUENZA,'C'));
l_oWv.setValue('NUMOPERAZ',WtA(w_NUMOPERAZ,'N'));
l_oWv.setValue('DATASIGN',WtA(w_DATASIGN,'D'));
l_oWv.setValue('IDBASE',WtA(w_IDBASE,'C'));
l_oWv.setValue('FLAGDAC6',WtA(w_FLAGDAC6,'N'));
l_oWv.setValue('NOTERIS',WtA(w_NOTERIS,'M'));
l_oWv.setValue('gIntemediario',WtA(w_gIntemediario,'C'));
l_oWv.setValue('gFlgWU',WtA(w_gFlgWU,'C'));
l_oWv.setValue('gSeekAos',WtA(w_gSeekAos,'C'));
l_oWv.setValue('gDataVaria',WtA(w_gDataVaria,'D'));
l_oWv.setValue('gFlgDoc',WtA(w_gFlgDoc,'C'));
l_oWv.setValue('gTipInter',WtA(w_gTipInter,'C'));
l_oWv.setValue('gVerSim',WtA(w_gVerSim,'C'));
l_oWv.setValue('gCodDip',WtA(w_gCodDip,'C'));
l_oWv.setValue('dataoggi',WtA(w_dataoggi,'D'));
l_oWv.setValue('nascomunid',WtA(w_nascomunid,'C'));
l_oWv.setValue('nasstatoid',WtA(w_nasstatoid,'C'));
l_oWv.setValue('flgaggfam',WtA(w_flgaggfam,'C'));
l_oWv.setValue('DATARETT',WtA(w_DATARETT,'D'));
l_oWv.setValue('STATOREG',WtA(w_STATOREG,'C'));
l_oWv.setValue('NUMPROG',WtA(w_NUMPROG,'C'));
l_oWv.setValue('tipsot',WtA(w_tipsot,'C'));
l_oWv.setValue('DESCSGRU',WtA(w_DESCSGRU,'C'));
l_oWv.setValue('DESCRAMGRU',WtA(w_DESCRAMGRU,'C'));
l_oWv.setValue('DESCUIC',WtA(w_DESCUIC,'C'));
l_oWv.setValue('dessta',WtA(w_dessta,'C'));
l_oWv.setValue('DESCRI',WtA(w_DESCRI,'C'));
l_oWv.setValue('xstatonas',WtA(w_xstatonas,'C'));
l_oWv.setValue('finesae',WtA(w_finesae,'D'));
l_oWv.setValue('finesint',WtA(w_finesint,'D'));
l_oWv.setValue('xFLGVALIDO',WtA(w_xFLGVALIDO,'C'));
l_oWv.setValue('xFLGANAVAL',WtA(w_xFLGANAVAL,'C'));
l_oWv.setValue('ragbanben',WtA(w_ragbanben,'C'));
l_oWv.setValue('xdesfatca',WtA(w_xdesfatca,'C'));
l_oWv.setValue('ATTIVR',WtA(w_ATTIVR,'C'));
l_oWv.setValue('xDESDIPE',WtA(w_xDESDIPE,'C'));
l_oWv.setValue('xDSETSIN',WtA(w_xDSETSIN,'C'));
l_oWv.setValue('xdesctipatt',WtA(w_xdesctipatt,'C'));
l_oWv.setValue('xdescareag',WtA(w_xdescareag,'C'));
l_oWv.setValue('xdescnatgiu',WtA(w_xdescnatgiu,'C'));
l_oWv.setValue('xdesccomp',WtA(w_xdesccomp,'C'));
l_oWv.setValue('xITFLGPEP',WtA(w_xITFLGPEP,'C'));
l_oWv.setValue('xDesCit1',WtA(w_xDesCit1,'C'));
l_oWv.setValue('xDesCit2',WtA(w_xDesCit2,'C'));
l_oWv.setValue('xResFis',WtA(w_xResFis,'C'));
l_oWv.setValue('xRAGLEGRAP',WtA(w_xRAGLEGRAP,'C'));
l_oWv.setValue('xIDLEGRAP',WtA(w_xIDLEGRAP,'C'));
l_oWv.setValue('FLGALTO',WtA(w_FLGALTO,'N'));
l_oWv.setValue('COMPLETA',WtA(w_COMPLETA,'L'));
l_oWv.setValue('status',WtA(w_status,'C'));
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
_FillChildren.n=['ardt_personbo_dip','armt_personbo_agg','ardt_soggope','ardt_fatca_ind','ardt_patrimonio','ardt_reddito'];
FillWv.n=["TIPOPERS","COGNOME","NOME","CFESTERO","RAGSOC","PAESE","DESCCIT","idcitta","PROVINCIA","CAP","CODCAB","DOMICILIO","IDENT","IDNASCOMUN","NASCOMUN","TIPINTER","IDNASSTATO","NASSTATO","SESSO","DATANASC","TIPODOC","NUMDOCUM","DATARILASC","DATAVALI","AUTRILASC","CODFISC","PARTIVA","CONTO","SOTGRUP","RAMOGRUP","ATTIV","SETTSINT","CONNES","NOSARA","NOTIT","PROGIMPORT","OLDSETSIN","CRIMEDATE","PEPDATE","NOTE","CODLEGRAP","FATCA","TIN","ODB","AREAGEO","RAREA","PKTBSPECIE","RNATGIU","RATTIV","COMPORT","RCOMP","DOCFILE","RISGLOB","DATAPROF","DATAREVPROF","PEP","CRIME","MITIG","MITIGDOC","DATAFINE","DATAINI","DISATTIVO","TIPOSOGGETTO","RAPSEGNA","SOGAFFIDATARIO","CAUSALE","FATTURATO","FLGNOTRIM","DATAIDENT","CITTADIN1","CITTADIN2","RESFISC","BANCABEN","DATASEGN","DATARAUT","VERIFICA","CODINTER","NUMIMP","CODDIPE","SOSPMAF","OLDCONNES","DATEXTRA","ALLINEATO","ALLINEATONOMECNOME","RAGSOCOLD","PROGIMP_C","IDFILE","OLDCODFISC","MACROAGENTE","SPOTID","DATAVARAGE","SETTSINT2","TELEF","TIPOORO","CODORO","FLGVALIDO","DAC6","ALTRODOM","ALTROCAP","IMPORTOMAX","FREQUENZA","NUMOPERAZ","DATASIGN","IDBASE","FLAGDAC6","NOTERIS","gIntemediario","gFlgWU","gSeekAos","gDataVaria","gFlgDoc","gTipInter","gVerSim","gCodDip","dataoggi","nascomunid","nasstatoid","flgaggfam","DATARETT","STATOREG","NUMPROG","tipsot","DESCSGRU","DESCRAMGRU","DESCUIC","dessta","DESCRI","xstatonas","finesae","finesint","xFLGVALIDO","xFLGANAVAL","ragbanben","xdesfatca","ATTIVR","xDESDIPE","xDSETSIN","xdesctipatt","xdescareag","xdescnatgiu","xdesccomp","xITFLGPEP","xDesCit1","xDesCit2","xResFis","xRAGLEGRAP","xIDLEGRAP","FLGALTO","COMPLETA","status"];
function SetModified() {
m_bUpdated=true;
}
function SetChildVariables_ardt_personbo_dip() {
}
function CtxLoad_ardt_personbo_dip() {
if (ChildToLoad(FrameRef('ardt_personbo_dip'))) {
return [LoadContext(0,'BKKASVQSWO'),'ardt_personbo_dip'];
}
}
function SetChildVariables_armt_personbo_agg() {
}
function CtxLoad_armt_personbo_agg() {
if (ChildToLoad(FrameRef('armt_personbo_agg'))) {
return [LoadContext(0,'OIREAEXNKZ'),'armt_personbo_agg'];
}
}
function SetChildVariables_ardt_soggope() {
}
function CtxLoad_ardt_soggope() {
if (ChildToLoad(FrameRef('ardt_soggope'))) {
return [LoadContext(0,'RYYOFFRITV'),'ardt_soggope'];
}
}
function SetChildVariables_ardt_fatca_ind() {
}
function CtxLoad_ardt_fatca_ind() {
if (ChildToLoad(FrameRef('ardt_fatca_ind'))) {
return [LoadContext(0,'FBAHOFZNEF'),'ardt_fatca_ind'];
}
}
function SetChildVariables_ardt_patrimonio() {
}
function CtxLoad_ardt_patrimonio() {
if (ChildToLoad(FrameRef('ardt_patrimonio'))) {
return [LoadContext(0,'FFIYUAKUTX'),'ardt_patrimonio'];
}
}
function SetChildVariables_ardt_reddito() {
}
function CtxLoad_ardt_reddito() {
if (ChildToLoad(FrameRef('ardt_reddito'))) {
return [LoadContext(0,'COWMRLCMMU'),'ardt_reddito'];
}
}
