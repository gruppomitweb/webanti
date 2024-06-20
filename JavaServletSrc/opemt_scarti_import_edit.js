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
LibJavascript.forEachItem(m_FoundlingEditExpression,i_body_0)
function i_body_0(child){
child();
}
DisableUI();
HideControlsUnderCondition();
ObligatoryControlsUnderCondition();
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
function Set_IMPPROG(ctrlValue,kmode,e) {
if (Ne(w_IMPPROG,ctrlValue)) {
var ctl = _GetCtl(e,'QXNYFHJEGV');
if (_tracker.goon(ctl,ctrlValue)) {
w_IMPPROG=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QXNYFHJEGV',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('QXNYFHJEGV',function(){return WtH(w_IMPPROG,'N',10,0,'9999999999')},w_IMPPROG);
return l_bResult;
} else {
ctl.value=WtH('','N',10,0,'9999999999');
_ResetTracker();
return true;
}
}
return true;
}
function Set_CODSTUDIO(ctrlValue,kmode,e) {
if (Ne(w_CODSTUDIO,ctrlValue)) {
var ctl = _GetCtl(e,'UKBKMVGOYH');
if (_tracker.goon(ctl,ctrlValue)) {
w_CODSTUDIO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UKBKMVGOYH',0);
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
function Set_CODDIPE(ctrlValue,kmode,e) {
if (Ne(w_CODDIPE,ctrlValue)) {
var ctl = _GetCtl(e,'EJPBJRCBZC');
if (_tracker.goon(ctl,ctrlValue)) {
w_CODDIPE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('EJPBJRCBZC',0);
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
function Set_NUMPROG(ctrlValue,kmode,e) {
if (Ne(w_NUMPROG,ctrlValue)) {
var ctl = _GetCtl(e,'WZJKEUSING');
if (_tracker.goon(ctl,ctrlValue)) {
w_NUMPROG=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('WZJKEUSING',0);
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
function Set_DATAOPE(ctrlValue,kmode,e) {
if (Ne(w_DATAOPE,ctrlValue)) {
var ctl = _GetCtl(e,'KWDTDYVYAB');
if (_tracker.goon(ctl,ctrlValue)) {
w_DATAOPE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('KWDTDYVYAB',0);
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
function Set_FLAGFRAZ(ctrlValue,kmode,e) {
if (Ne(w_FLAGFRAZ,ctrlValue)) {
var ctl = _GetCtl(e,'IBXSOHICPZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLAGFRAZ=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('IBXSOHICPZ',0);
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
function Set_CAUOPER(ctrlValue,kmode,e) {
if (Ne(w_CAUOPER,ctrlValue)) {
var ctl = _GetCtl(e,'SKOBLXEJHQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_CAUOPER=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SKOBLXEJHQ',0);
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
function Set_CONNESREAL(ctrlValue,kmode,e) {
if (Ne(w_CONNESREAL,ctrlValue)) {
var ctl = _GetCtl(e,'TRIYBQSKCQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_CONNESREAL=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('TRIYBQSKCQ',0);
if (l_bResult) {
l_bResult=Link_TRIYBQSKCQ(kmode);
if ( ! (l_bResult)) {
w_CONNESREAL=HtW('','C');
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
function Set_CONNESCLI(ctrlValue,kmode,e) {
if (Ne(w_CONNESCLI,ctrlValue)) {
var ctl = _GetCtl(e,'DHRGEXYQZL');
if (_tracker.goon(ctl,ctrlValue)) {
w_CONNESCLI=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('DHRGEXYQZL',0);
if (l_bResult) {
l_bResult=Link_DHRGEXYQZL(kmode);
if ( ! (l_bResult)) {
w_CONNESCLI=HtW('','C');
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
function Set_CONNESBEN(ctrlValue,kmode,e) {
if (Ne(w_CONNESBEN,ctrlValue)) {
var ctl = _GetCtl(e,'SQWOYVEXHD');
if (_tracker.goon(ctl,ctrlValue)) {
w_CONNESBEN=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SQWOYVEXHD',0);
if (l_bResult) {
l_bResult=Link_SQWOYVEXHD(kmode);
if ( ! (l_bResult)) {
w_CONNESBEN=HtW('','C');
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
function Set_CONNALTRO(ctrlValue,kmode,e) {
if (Ne(w_CONNALTRO,ctrlValue)) {
var ctl = _GetCtl(e,'SFOARTDXXG');
if (_tracker.goon(ctl,ctrlValue)) {
w_CONNALTRO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SFOARTDXXG',0);
if (l_bResult) {
l_bResult=Link_SFOARTDXXG(kmode);
if ( ! (l_bResult)) {
w_CONNALTRO=HtW('','C');
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
function Set_DATAREG(ctrlValue,kmode,e) {
if (Ne(w_DATAREG,ctrlValue)) {
var ctl = _GetCtl(e,'DEETZAJZGP');
if (_tracker.goon(ctl,ctrlValue)) {
w_DATAREG=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('DEETZAJZGP',0);
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
function Set_STATOREG(ctrlValue,kmode,e) {
if (Ne(w_STATOREG,ctrlValue)) {
var ctl = _GetCtl(e,'VQGDODMLDL');
if (_tracker.goon(ctl,ctrlValue)) {
w_STATOREG=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VQGDODMLDL',0);
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
var ctl = _GetCtl(e,'DXGRIVXEWI');
if (_tracker.goon(ctl,ctrlValue)) {
w_DATARETT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('DXGRIVXEWI',0);
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
function Set_VALUTA(ctrlValue,kmode,e) {
if (Ne(w_VALUTA,ctrlValue)) {
var ctl = _GetCtl(e,'AQBMLZYCWZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_VALUTA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('AQBMLZYCWZ',0);
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
function Set_IMPORTO(ctrlValue,kmode,e) {
if (Ne(w_IMPORTO,ctrlValue)) {
var ctl = _GetCtl(e,'JXJXTMAQOR');
if (_tracker.goon(ctl,ctrlValue)) {
w_IMPORTO=ValidNum(ctrlValue,'999999999999.99');
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('JXJXTMAQOR',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('JXJXTMAQOR',function(){return WtH(w_IMPORTO,'N',15,2,'999999999999.99')},w_IMPORTO);
return l_bResult;
} else {
ctl.value=WtH('','N',15,2,'999999999999.99');
_ResetTracker();
return true;
}
}
return true;
}
function Set_CONTANTI(ctrlValue,kmode,e) {
if (Ne(w_CONTANTI,ctrlValue)) {
var ctl = _GetCtl(e,'ZQKFPJRGCM');
if (_tracker.goon(ctl,ctrlValue)) {
w_CONTANTI=ValidNum(ctrlValue,'999999999999.99');
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ZQKFPJRGCM',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('ZQKFPJRGCM',function(){return WtH(w_CONTANTI,'N',15,2,'999999999999.99')},w_CONTANTI);
return l_bResult;
} else {
ctl.value=WtH('','N',15,2,'999999999999.99');
_ResetTracker();
return true;
}
}
return true;
}
function Set_MEZPAG(ctrlValue,kmode,e) {
if (Ne(w_MEZPAG,ctrlValue)) {
var ctl = _GetCtl(e,'AVIHKNTROH');
if (_tracker.goon(ctl,ctrlValue)) {
w_MEZPAG=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('AVIHKNTROH',0);
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
function Set_PRESTAZ(ctrlValue,kmode,e) {
if (Ne(w_PRESTAZ,ctrlValue)) {
var ctl = _GetCtl(e,'YZXCIDVOSB');
if (_tracker.goon(ctl,ctrlValue)) {
w_PRESTAZ=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YZXCIDVOSB',0);
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
function Set_RAGIO(ctrlValue,kmode,e) {
if (Ne(w_RAGIO,ctrlValue)) {
var ctl = _GetCtl(e,'DLWFDSLQHV');
if (_tracker.goon(ctl,ctrlValue)) {
w_RAGIO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('DLWFDSLQHV',0);
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
function Set_MODSVOL(ctrlValue,kmode,e) {
if (Ne(w_MODSVOL,ctrlValue)) {
var ctl = _GetCtl(e,'PJPSCKBXWX');
if (_tracker.goon(ctl,ctrlValue)) {
w_MODSVOL=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('PJPSCKBXWX',0);
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
function Set_AREAGEO(ctrlValue,kmode,e) {
if (Ne(w_AREAGEO,ctrlValue)) {
var ctl = _GetCtl(e,'BDJNXHSZPD');
if (_tracker.goon(ctl,ctrlValue)) {
w_AREAGEO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BDJNXHSZPD',0);
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
function Set_TIPO(ctrlValue,kmode,e) {
if (Ne(w_TIPO,ctrlValue)) {
var ctl = _GetCtl(e,'VQAMGIPHEI');
if (_tracker.goon(ctl,ctrlValue)) {
w_TIPO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VQAMGIPHEI',0);
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
function Set_AMMONT(ctrlValue,kmode,e) {
if (Ne(w_AMMONT,ctrlValue)) {
var ctl = _GetCtl(e,'UJWCIKSUAD');
if (_tracker.goon(ctl,ctrlValue)) {
w_AMMONT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UJWCIKSUAD',0);
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
function Set_DURAT(ctrlValue,kmode,e) {
if (Ne(w_DURAT,ctrlValue)) {
var ctl = _GetCtl(e,'XBMIQPAWVL');
if (_tracker.goon(ctl,ctrlValue)) {
w_DURAT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XBMIQPAWVL',0);
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
function Set_RAREA(ctrlValue,kmode,e) {
if (Ne(w_RAREA,ctrlValue)) {
var ctl = _GetCtl(e,'WELAXIKLEX');
if (_tracker.goon(ctl,ctrlValue)) {
w_RAREA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('WELAXIKLEX',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('WELAXIKLEX',function(){return WtH(w_RAREA,'N',3,0,'999')},w_RAREA);
return l_bResult;
} else {
ctl.value=WtH('','N',3,0,'999');
_ResetTracker();
return true;
}
}
return true;
}
function Set_RRAGIO(ctrlValue,kmode,e) {
if (Ne(w_RRAGIO,ctrlValue)) {
var ctl = _GetCtl(e,'ZIQAINPMOT');
if (_tracker.goon(ctl,ctrlValue)) {
w_RRAGIO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ZIQAINPMOT',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('ZIQAINPMOT',function(){return WtH(w_RRAGIO,'N',3,0,'999')},w_RRAGIO);
return l_bResult;
} else {
ctl.value=WtH('','N',3,0,'999');
_ResetTracker();
return true;
}
}
return true;
}
function Set_RCOMP(ctrlValue,kmode,e) {
if (Ne(w_RCOMP,ctrlValue)) {
var ctl = _GetCtl(e,'ORMMYKQBOD');
if (_tracker.goon(ctl,ctrlValue)) {
w_RCOMP=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ORMMYKQBOD',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('ORMMYKQBOD',function(){return WtH(w_RCOMP,'N',3,0,'999')},w_RCOMP);
return l_bResult;
} else {
ctl.value=WtH('','N',3,0,'999');
_ResetTracker();
return true;
}
}
return true;
}
function Set_RTIPO(ctrlValue,kmode,e) {
if (Ne(w_RTIPO,ctrlValue)) {
var ctl = _GetCtl(e,'CGNQJBONMH');
if (_tracker.goon(ctl,ctrlValue)) {
w_RTIPO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CGNQJBONMH',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('CGNQJBONMH',function(){return WtH(w_RTIPO,'N',3,0,'999')},w_RTIPO);
return l_bResult;
} else {
ctl.value=WtH('','N',3,0,'999');
_ResetTracker();
return true;
}
}
return true;
}
function Set_RFREQ(ctrlValue,kmode,e) {
if (Ne(w_RFREQ,ctrlValue)) {
var ctl = _GetCtl(e,'MDWPLKDGMG');
if (_tracker.goon(ctl,ctrlValue)) {
w_RFREQ=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MDWPLKDGMG',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('MDWPLKDGMG',function(){return WtH(w_RFREQ,'N',3,0,'999')},w_RFREQ);
return l_bResult;
} else {
ctl.value=WtH('','N',3,0,'999');
_ResetTracker();
return true;
}
}
return true;
}
function Set_RIMP(ctrlValue,kmode,e) {
if (Ne(w_RIMP,ctrlValue)) {
var ctl = _GetCtl(e,'UAFEGMLADT');
if (_tracker.goon(ctl,ctrlValue)) {
w_RIMP=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UAFEGMLADT',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('UAFEGMLADT',function(){return WtH(w_RIMP,'N',3,0,'999')},w_RIMP);
return l_bResult;
} else {
ctl.value=WtH('','N',3,0,'999');
_ResetTracker();
return true;
}
}
return true;
}
function Set_IMPPROG13(ctrlValue,kmode,e) {
if (Ne(w_IMPPROG13,ctrlValue)) {
var ctl = _GetCtl(e,'EUHPECGOVY');
if (_tracker.goon(ctl,ctrlValue)) {
w_IMPPROG13=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('EUHPECGOVY',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',13,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_TIPOOPER(ctrlValue,kmode,e) {
if (Ne(w_TIPOOPER,ctrlValue)) {
var ctl = _GetCtl(e,'KYUSCDSEVM');
if (_tracker.goon(ctl,ctrlValue)) {
w_TIPOOPER=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('KYUSCDSEVM',0);
if (l_bResult) {
l_bResult=Link_KYUSCDSEVM(kmode);
if ( ! (l_bResult)) {
w_TIPOOPER=HtW('','C');
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
function Set_DESPUNTO(ctrlValue,kmode,e) {
if (Ne(w_DESPUNTO,ctrlValue)) {
var ctl = _GetCtl(e,'WNUERUZGDR');
if (_tracker.goon(ctl,ctrlValue)) {
w_DESPUNTO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('WNUERUZGDR',0);
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
function Set_TXTERR(ctrlValue,kmode,e) {
if (Ne(w_TXTERR,ctrlValue)) {
var ctl = _GetCtl(e,'ENRXTREYWX');
if (_tracker.goon(ctl,ctrlValue)) {
w_TXTERR=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ENRXTREYWX',0);
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
function Calculate() {
var l_bTmpRes;
var l_bResult = true;
m_bCalculating=true;
LibJavascript.forEachItem(m_FoundlingCopyWorkVar,i_body_1)
function i_body_1(child){
child();
}
// * --- Area Manuale = UI - Calculate
// * --- Fine Area Manuale
m_bCalculating=false;
}
function SaveDependsOn() {
}
function SaveLabelDependsOn() {
}
function Link_TRIYBQSKCQ(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CONNESREAL);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('PARTIVA',w_CONNESREAL,11,0);
l_Appl.SetFields('PARTIVA,RAGSOC');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('personbo');
l_Appl.SetLinkzoom('opemt_personbo');
l_Appl.SetID('TRIYBQSKCQ');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CONNESREAL=l_Appl.GetStringValue('PARTIVA',11,0);
w_RAGSOCreal=l_Appl.GetStringValue('RAGSOC',70,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_TRIYBQSKCQ_Blank();
l_bResult=true;
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_TRIYBQSKCQ';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_TRIYBQSKCQ();
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
function Link_TRIYBQSKCQ_Blank() {
w_RAGSOCreal='';
}
function LOpt_TRIYBQSKCQ() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('personbo','C'));
l_oWv.setValue('Linkzoomprg',WtA('opemt_personbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('PARTIVA','C'));
l_oWv.setValue('LinkedField',WtA('PARTIVA','C'));
l_oWv.setValue('UID',WtA('TRIYBQSKCQ','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['TRIYBQSKCQ'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('195812931'),'C'));
return l_oWv;
}
function Link_DHRGEXYQZL(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CONNESCLI);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('PARTIVA',w_CONNESCLI,11,0);
l_Appl.SetFields('PARTIVA,RAGSOC');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('personbo');
l_Appl.SetID('DHRGEXYQZL');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CONNESCLI=l_Appl.GetStringValue('PARTIVA',11,0);
w_RAGSOCexec=l_Appl.GetStringValue('RAGSOC',70,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_DHRGEXYQZL_Blank();
l_bResult=true;
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_DHRGEXYQZL';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_DHRGEXYQZL();
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
function Link_DHRGEXYQZL_Blank() {
w_RAGSOCexec='';
}
function LOpt_DHRGEXYQZL() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('personbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('PARTIVA','C'));
l_oWv.setValue('LinkedField',WtA('PARTIVA','C'));
l_oWv.setValue('UID',WtA('DHRGEXYQZL','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['DHRGEXYQZL'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('195812931'),'C'));
l_oWv.setValue('ConfigName',WtA('scarti','C'));
return l_oWv;
}
function Link_SQWOYVEXHD(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CONNESBEN);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('PARTIVA',w_CONNESBEN,11,0);
l_Appl.SetFields('PARTIVA,RAGSOC');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('personbo');
l_Appl.SetLinkzoom('opemt_personbo');
l_Appl.SetID('SQWOYVEXHD');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CONNESBEN=l_Appl.GetStringValue('PARTIVA',11,0);
w_RAGSOCben=l_Appl.GetStringValue('RAGSOC',70,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_SQWOYVEXHD_Blank();
l_bResult=true;
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_SQWOYVEXHD';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_SQWOYVEXHD();
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
function Link_SQWOYVEXHD_Blank() {
w_RAGSOCben='';
}
function LOpt_SQWOYVEXHD() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('personbo','C'));
l_oWv.setValue('Linkzoomprg',WtA('opemt_personbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('PARTIVA','C'));
l_oWv.setValue('LinkedField',WtA('PARTIVA','C'));
l_oWv.setValue('UID',WtA('SQWOYVEXHD','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['SQWOYVEXHD'][1],'C'));
l_oWv.setValue('ConfigName',WtA('scarti','C'));
return l_oWv;
}
function Link_SFOARTDXXG(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CONNALTRO);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('PARTIVA',w_CONNALTRO,11,0);
l_Appl.SetFields('PARTIVA,RAGSOC');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('personbo');
l_Appl.SetLinkzoom('opemt_personbo');
l_Appl.SetID('SFOARTDXXG');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CONNALTRO=l_Appl.GetStringValue('PARTIVA',11,0);
w_RAGSOCaltro=l_Appl.GetStringValue('RAGSOC',70,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_SFOARTDXXG_Blank();
l_bResult=true;
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_SFOARTDXXG';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_SFOARTDXXG();
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
function Link_SFOARTDXXG_Blank() {
w_RAGSOCaltro='';
}
function LOpt_SFOARTDXXG() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('personbo','C'));
l_oWv.setValue('Linkzoomprg',WtA('opemt_personbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('PARTIVA','C'));
l_oWv.setValue('LinkedField',WtA('PARTIVA','C'));
l_oWv.setValue('UID',WtA('SFOARTDXXG','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['SFOARTDXXG'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('195812931'),'C'));
l_oWv.setValue('ConfigName',WtA('scarti','C'));
return l_oWv;
}
function Link_KYUSCDSEVM(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_TIPOOPER);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('TIPLEG',w_TIPOOPER,2,0);
l_Appl.SetFields('TIPLEG,DESCRIZ');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tipilegbo_m');
l_Appl.SetID('KYUSCDSEVM');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_TIPOOPER=l_Appl.GetStringValue('TIPLEG',2,0);
w_xdestipope=l_Appl.GetStringValue('DESCRIZ',254,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_KYUSCDSEVM_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_KYUSCDSEVM';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_KYUSCDSEVM();
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
function Link_KYUSCDSEVM_Blank() {
w_TIPOOPER='';
w_xdestipope='';
}
function LOpt_KYUSCDSEVM() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tipilegbo_m','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('TIPLEG','C'));
l_oWv.setValue('LinkedField',WtA('TIPLEG','C'));
l_oWv.setValue('UID',WtA('KYUSCDSEVM','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['KYUSCDSEVM'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('10874458778'),'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'TRIYBQSKCQ')) {
last_focused_comp=GetLastFocusedElementOfLink('TRIYBQSKCQ');
function SetMethod_TRIYBQSKCQ() {
Set_CONNESREAL(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_TRIYBQSKCQ();
} else {
setTimeout(SetMethod_TRIYBQSKCQ,1);
}
bResult=true;
}
if (Eq(varName,'DHRGEXYQZL')) {
last_focused_comp=GetLastFocusedElementOfLink('DHRGEXYQZL');
function SetMethod_DHRGEXYQZL() {
Set_CONNESCLI(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_DHRGEXYQZL();
} else {
setTimeout(SetMethod_DHRGEXYQZL,1);
}
bResult=true;
}
if (Eq(varName,'SQWOYVEXHD')) {
last_focused_comp=GetLastFocusedElementOfLink('SQWOYVEXHD');
function SetMethod_SQWOYVEXHD() {
Set_CONNESBEN(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_SQWOYVEXHD();
} else {
setTimeout(SetMethod_SQWOYVEXHD,1);
}
bResult=true;
}
if (Eq(varName,'SFOARTDXXG')) {
last_focused_comp=GetLastFocusedElementOfLink('SFOARTDXXG');
function SetMethod_SFOARTDXXG() {
Set_CONNALTRO(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_SFOARTDXXG();
} else {
setTimeout(SetMethod_SFOARTDXXG,1);
}
bResult=true;
}
if (Eq(varName,'KYUSCDSEVM')) {
last_focused_comp=GetLastFocusedElementOfLink('KYUSCDSEVM');
function SetMethod_KYUSCDSEVM() {
Set_TIPOOPER(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_KYUSCDSEVM();
} else {
setTimeout(SetMethod_KYUSCDSEVM,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'TRIYBQSKCQ')) {
return [Ctrl('TRIYBQSKCQ')];
}
if (Eq(varName,'DHRGEXYQZL')) {
return [Ctrl('DHRGEXYQZL')];
}
if (Eq(varName,'SQWOYVEXHD')) {
return [Ctrl('SQWOYVEXHD')];
}
if (Eq(varName,'SFOARTDXXG')) {
return [Ctrl('SFOARTDXXG')];
}
if (Eq(varName,'KYUSCDSEVM')) {
return [Ctrl('KYUSCDSEVM')];
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
parent.ZtVWeb.raiseEventToEvalParms('opemt_scarti_import_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('opemt_scarti_import_dataNotSent',{'action':formaction});
}
}
}
}
CheckChild.child=[];
function Check() {
var l_bResult = true;
ResetErrorVars();
m_nLastError=0;
if ( ! (_ChkObl('QXNYFHJEGV',1))) {
_SignErr('QXNYFHJEGV');
m_cLastWorkVarErrorMsg='11202170632';
l_bResult=false;
w_IMPPROG=HtW('','N');
} else if ( ! (_ChkObl('UKBKMVGOYH',1))) {
_SignErr('UKBKMVGOYH');
m_cLastWorkVarErrorMsg='11316624286';
l_bResult=false;
w_CODSTUDIO=HtW('','C');
} else if ( ! (_ChkObl('EJPBJRCBZC',1))) {
_SignErr('EJPBJRCBZC');
m_cLastWorkVarErrorMsg='2071283709';
l_bResult=false;
w_CODDIPE=HtW('','C');
} else if ( ! (_ChkObl('WZJKEUSING',1))) {
_SignErr('WZJKEUSING');
m_cLastWorkVarErrorMsg='11993250157';
l_bResult=false;
w_NUMPROG=HtW('','C');
} else if ( ! (_ChkObl('KWDTDYVYAB',1))) {
_SignErr('KWDTDYVYAB');
m_cLastWorkVarErrorMsg='829201110';
l_bResult=false;
w_DATAOPE=HtW('','C');
} else if ( ! (_ChkObl('IBXSOHICPZ',1))) {
_SignErr('IBXSOHICPZ');
m_cLastWorkVarErrorMsg='2069633825';
l_bResult=false;
w_FLAGFRAZ=HtW('','C');
} else if ( ! (_ChkObl('SKOBLXEJHQ',1))) {
_SignErr('SKOBLXEJHQ');
m_cLastWorkVarErrorMsg='10852410784';
l_bResult=false;
w_CAUOPER=HtW('','C');
} else if ( ! (_ChkObl('TRIYBQSKCQ',1))) {
_SignErr('TRIYBQSKCQ');
m_cLastWorkVarErrorMsg='1823784963';
l_bResult=false;
w_CONNESREAL=HtW('','C');
} else if ( ! (_ChkObl('DHRGEXYQZL',1))) {
_SignErr('DHRGEXYQZL');
m_cLastWorkVarErrorMsg='10915686795';
l_bResult=false;
w_CONNESCLI=HtW('','C');
} else if ( ! (_ChkObl('SQWOYVEXHD',1))) {
_SignErr('SQWOYVEXHD');
m_cLastWorkVarErrorMsg='10692492141';
l_bResult=false;
w_CONNESBEN=HtW('','C');
} else if ( ! (_ChkObl('SFOARTDXXG',1))) {
_SignErr('SFOARTDXXG');
m_cLastWorkVarErrorMsg='12023087643';
l_bResult=false;
w_CONNALTRO=HtW('','C');
} else if ( ! (_ChkObl('DEETZAJZGP',1))) {
_SignErr('DEETZAJZGP');
m_cLastWorkVarErrorMsg='995044523';
l_bResult=false;
w_DATAREG=HtW('','C');
} else if ( ! (_ChkObl('VQGDODMLDL',1))) {
_SignErr('VQGDODMLDL');
m_cLastWorkVarErrorMsg='11258238247';
l_bResult=false;
w_STATOREG=HtW('','C');
} else if ( ! (_ChkObl('DXGRIVXEWI',1))) {
_SignErr('DXGRIVXEWI');
m_cLastWorkVarErrorMsg='11329559720';
l_bResult=false;
w_DATARETT=HtW('','C');
} else if ( ! (_ChkObl('AQBMLZYCWZ',1))) {
_SignErr('AQBMLZYCWZ');
m_cLastWorkVarErrorMsg='109822566';
l_bResult=false;
w_VALUTA=HtW('','C');
} else if ( ! (_ChkObl('JXJXTMAQOR',1))) {
_SignErr('JXJXTMAQOR');
m_cLastWorkVarErrorMsg='1991862041';
l_bResult=false;
w_IMPORTO=HtW('','N');
} else if ( ! (_ChkObl('ZQKFPJRGCM',1))) {
_SignErr('ZQKFPJRGCM');
m_cLastWorkVarErrorMsg='189314355';
l_bResult=false;
w_CONTANTI=HtW('','N');
} else if ( ! (_ChkObl('AVIHKNTROH',1))) {
_SignErr('AVIHKNTROH');
m_cLastWorkVarErrorMsg='688674216';
l_bResult=false;
w_MEZPAG=HtW('','C');
} else if ( ! (_ChkObl('YZXCIDVOSB',1))) {
_SignErr('YZXCIDVOSB');
m_cLastWorkVarErrorMsg='277612735';
l_bResult=false;
w_PRESTAZ=HtW('','C');
} else if ( ! (_ChkObl('DLWFDSLQHV',1))) {
_SignErr('DLWFDSLQHV');
m_cLastWorkVarErrorMsg='10756545135';
l_bResult=false;
w_RAGIO=HtW('','C');
} else if ( ! (_ChkObl('PJPSCKBXWX',1))) {
_SignErr('PJPSCKBXWX');
m_cLastWorkVarErrorMsg='11158852142';
l_bResult=false;
w_MODSVOL=HtW('','C');
} else if ( ! (_ChkObl('BDJNXHSZPD',1))) {
_SignErr('BDJNXHSZPD');
m_cLastWorkVarErrorMsg='11053408024';
l_bResult=false;
w_AREAGEO=HtW('','C');
} else if ( ! (_ChkObl('VQAMGIPHEI',1))) {
_SignErr('VQAMGIPHEI');
m_cLastWorkVarErrorMsg='11639004473';
l_bResult=false;
w_TIPO=HtW('','C');
} else if ( ! (_ChkObl('UJWCIKSUAD',1))) {
_SignErr('UJWCIKSUAD');
m_cLastWorkVarErrorMsg='11255940388';
l_bResult=false;
w_AMMONT=HtW('','C');
} else if ( ! (_ChkObl('XBMIQPAWVL',1))) {
_SignErr('XBMIQPAWVL');
m_cLastWorkVarErrorMsg='11400294538';
l_bResult=false;
w_DURAT=HtW('','C');
} else if ( ! (_ChkObl('WELAXIKLEX',1))) {
_SignErr('WELAXIKLEX');
m_cLastWorkVarErrorMsg='1980048963';
l_bResult=false;
w_RAREA=HtW('','N');
} else if ( ! (_ChkObl('ZIQAINPMOT',1))) {
_SignErr('ZIQAINPMOT');
m_cLastWorkVarErrorMsg='1223078771';
l_bResult=false;
w_RRAGIO=HtW('','N');
} else if ( ! (_ChkObl('ORMMYKQBOD',1))) {
_SignErr('ORMMYKQBOD');
m_cLastWorkVarErrorMsg='34329298';
l_bResult=false;
w_RCOMP=HtW('','N');
} else if ( ! (_ChkObl('CGNQJBONMH',1))) {
_SignErr('CGNQJBONMH');
m_cLastWorkVarErrorMsg='1952583975';
l_bResult=false;
w_RTIPO=HtW('','N');
} else if ( ! (_ChkObl('MDWPLKDGMG',1))) {
_SignErr('MDWPLKDGMG');
m_cLastWorkVarErrorMsg='11966397783';
l_bResult=false;
w_RFREQ=HtW('','N');
} else if ( ! (_ChkObl('UAFEGMLADT',1))) {
_SignErr('UAFEGMLADT');
m_cLastWorkVarErrorMsg='10323481349';
l_bResult=false;
w_RIMP=HtW('','N');
} else if ( ! (_ChkObl('KYUSCDSEVM',1))) {
_SignErr('KYUSCDSEVM');
m_cLastWorkVarErrorMsg='10874458778';
l_bResult=false;
w_TIPOOPER=HtW('','C');
} else if ( ! (_ChkObl('ENRXTREYWX',1))) {
_SignErr('ENRXTREYWX');
m_cLastWorkVarErrorMsg='11213057650';
l_bResult=false;
w_TXTERR=HtW('','M');
} else if ( ! (_ChkObl('WNUERUZGDR',1))) {
_SignErr('WNUERUZGDR');
m_cLastWorkVarErrorMsg='10961866158';
l_bResult=false;
w_DESPUNTO=HtW('','C');
} else if ( ! (_ChkObl('EUHPECGOVY',1))) {
_SignErr('EUHPECGOVY');
m_cLastWorkVarErrorMsg='1211771705';
l_bResult=false;
w_IMPPROG13=HtW('','C');
}
if (l_bResult) {
l_bResult=CheckChild(0);
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('TRIYBQSKCQ_ZOOM',lc)) {
return 0;
}
if (Eq('TRIYBQSKCQ',lc)) {
return 0;
}
if (Eq('DHRGEXYQZL_ZOOM',lc)) {
return 1;
}
if (Eq('DHRGEXYQZL',lc)) {
return 1;
}
if (Eq('SQWOYVEXHD_ZOOM',lc)) {
return 2;
}
if (Eq('SQWOYVEXHD',lc)) {
return 2;
}
if (Eq('SFOARTDXXG_ZOOM',lc)) {
return 3;
}
if (Eq('SFOARTDXXG',lc)) {
return 3;
}
if (Eq('KYUSCDSEVM_ZOOM',lc)) {
return 4;
}
if (Eq('KYUSCDSEVM',lc)) {
return 4;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_TRIYBQSKCQ();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,1)) {
l_oWv=LOpt_DHRGEXYQZL();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,2)) {
l_oWv=LOpt_SQWOYVEXHD();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,3)) {
l_oWv=LOpt_SFOARTDXXG();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,4)) {
l_oWv=LOpt_KYUSCDSEVM();
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
l_oWv.setValue('IMPPROG',WtA(w_IMPPROG,'N'));
l_oWv.setValue('CODSTUDIO',WtA(w_CODSTUDIO,'C'));
l_oWv.setValue('CODDIPE',WtA(w_CODDIPE,'C'));
l_oWv.setValue('NUMPROG',WtA(w_NUMPROG,'C'));
l_oWv.setValue('DATAOPE',WtA(w_DATAOPE,'C'));
l_oWv.setValue('FLAGFRAZ',WtA(w_FLAGFRAZ,'C'));
l_oWv.setValue('CAUOPER',WtA(w_CAUOPER,'C'));
l_oWv.setValue('CONNESREAL',WtA(w_CONNESREAL,'C'));
l_oWv.setValue('CONNESCLI',WtA(w_CONNESCLI,'C'));
l_oWv.setValue('CONNESBEN',WtA(w_CONNESBEN,'C'));
l_oWv.setValue('CONNALTRO',WtA(w_CONNALTRO,'C'));
l_oWv.setValue('DATAREG',WtA(w_DATAREG,'C'));
l_oWv.setValue('STATOREG',WtA(w_STATOREG,'C'));
l_oWv.setValue('DATARETT',WtA(w_DATARETT,'C'));
l_oWv.setValue('VALUTA',WtA(w_VALUTA,'C'));
l_oWv.setValue('IMPORTO',WtA(w_IMPORTO,'N'));
l_oWv.setValue('CONTANTI',WtA(w_CONTANTI,'N'));
l_oWv.setValue('MEZPAG',WtA(w_MEZPAG,'C'));
l_oWv.setValue('PRESTAZ',WtA(w_PRESTAZ,'C'));
l_oWv.setValue('RAGIO',WtA(w_RAGIO,'C'));
l_oWv.setValue('MODSVOL',WtA(w_MODSVOL,'C'));
l_oWv.setValue('AREAGEO',WtA(w_AREAGEO,'C'));
l_oWv.setValue('TIPO',WtA(w_TIPO,'C'));
l_oWv.setValue('AMMONT',WtA(w_AMMONT,'C'));
l_oWv.setValue('DURAT',WtA(w_DURAT,'C'));
l_oWv.setValue('RAREA',WtA(w_RAREA,'N'));
l_oWv.setValue('RRAGIO',WtA(w_RRAGIO,'N'));
l_oWv.setValue('RCOMP',WtA(w_RCOMP,'N'));
l_oWv.setValue('RTIPO',WtA(w_RTIPO,'N'));
l_oWv.setValue('RFREQ',WtA(w_RFREQ,'N'));
l_oWv.setValue('RIMP',WtA(w_RIMP,'N'));
l_oWv.setValue('TIPOOPER',WtA(w_TIPOOPER,'C'));
l_oWv.setValue('TXTERR',WtA(w_TXTERR,'M'));
l_oWv.setValue('DESPUNTO',WtA(w_DESPUNTO,'C'));
l_oWv.setValue('IMPPROG13',WtA(w_IMPPROG13,'C'));
l_oWv.setValue('xdestipope',WtA(w_xdestipope,'C'));
l_oWv.setValue('RAGSOCexec',WtA(w_RAGSOCexec,'C'));
l_oWv.setValue('RAGSOCreal',WtA(w_RAGSOCreal,'C'));
l_oWv.setValue('RAGSOCben',WtA(w_RAGSOCben,'C'));
l_oWv.setValue('RAGSOCaltro',WtA(w_RAGSOCaltro,'C'));
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
FillWv.n=["IMPPROG","CODSTUDIO","CODDIPE","NUMPROG","DATAOPE","FLAGFRAZ","CAUOPER","CONNESREAL","CONNESCLI","CONNESBEN","CONNALTRO","DATAREG","STATOREG","DATARETT","VALUTA","IMPORTO","CONTANTI","MEZPAG","PRESTAZ","RAGIO","MODSVOL","AREAGEO","TIPO","AMMONT","DURAT","RAREA","RRAGIO","RCOMP","RTIPO","RFREQ","RIMP","TIPOOPER","TXTERR","DESPUNTO","IMPPROG13","xdestipope","RAGSOCexec","RAGSOCreal","RAGSOCben","RAGSOCaltro"];
function SetModified() {
m_bUpdated=true;
}
