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
function DisplayErrorMessage_ardt_ageresleg() {
if ( ! (ChildToLoad(FrameRef('ardt_ageresleg'))) && Ne(typeof(FrameRef('ardt_ageresleg').DisplayErrorMessage),'undefined')) {
FrameRef('ardt_ageresleg').DisplayErrorMessage();
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
if (IsDisabledByStateDriver('Base')) {
DisableInputsInContainer(Ctrl('UBUBESGOCL'),true);
}
if (IsDisabledByStateDriver('PF')) {
Z.Tabs.Get("tabs_1_DatiBase").SetDisable('FZFECYSHCA',true);
}
if (IsDisabledByStateDriver('PG')) {
Z.Tabs.Get("tabs_1_DatiBase").SetDisable('IQCHDVPIPM',true);
}
if (IsDisabledByStateDriver('WU')) {
Z.Tabs.Get("tabs_1_DatiBase").SetDisable('MGKJOJJOBA',true);
}
if (IsDisabledByStateDriver('Residenza')) {
DisableInputsInContainer(Ctrl('QLICUFUCES'),true);
}
if (IsDisabledByStateDriver('Domicilio')) {
DisableInputsInContainer(Ctrl('ESTMSWKOOS'),true);
}
if (IsDisabledByStateDriver('SedeLegale')) {
DisableInputsInContainer(Ctrl('JNAHHHKQCN'),true);
}
if (IsDisabledByStateDriver('RL')) {
Z.Tabs.Get("tabs_1_DatiBase").SetDisable('YULWJWXEXS',true);
}
if (IsDisabledByStateDriver('SO')) {
Z.Tabs.Get("tabs_1_DatiBase").SetDisable('CUUSKOLCJA',true);
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
SetObligatory(Ctrl('UYKWSCJLEB'),Eq(w_MAFLGCOMPL,1) || IsObligatoryByStateDriver('MADATFIN'));
}
function SetDynamicClasses() {
var c;
}
function SetDynamicTooltip() {
var c;
}
function Set_MACODFIS(ctrlValue,kmode,e) {
if (Ne(w_MACODFIS,ctrlValue)) {
var ctl = _GetCtl(e,'OPANBXIPXY');
if (_tracker.goon(ctl,ctrlValue)) {
w_MACODFIS=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('OPANBXIPXY',0);
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
function Set_MACODICE(ctrlValue,kmode,e) {
if (Ne(w_MACODICE,ctrlValue)) {
var ctl = _GetCtl(e,'LVIYDAHUQL');
if (_tracker.goon(ctl,ctrlValue)) {
w_MACODICE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('LVIYDAHUQL',0);
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
function Set_MADESCRI(ctrlValue,kmode,e) {
if (Ne(w_MADESCRI,ctrlValue)) {
var ctl = _GetCtl(e,'UJLZTFQRLR');
if (_tracker.goon(ctl,ctrlValue)) {
w_MADESCRI=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UJLZTFQRLR',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('UJLZTFQRLR',function(){return WtH(w_MADESCRI,'C',120,0,'@!')},w_MADESCRI);
return l_bResult;
} else {
ctl.value=WtH('','C',120,0,'@!');
_ResetTracker();
return true;
}
}
return true;
}
function Set_MAFLGRAP(ctrlValue,kmode,e) {
if (Ne(w_MAFLGRAP,ctrlValue)) {
var ctl = _GetCtl(e,'ASRUOVVPGY');
if (_tracker.goon(ctl,ctrlValue)) {
w_MAFLGRAP=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ASRUOVVPGY',0);
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
function Set_MAFLGOPE(ctrlValue,kmode,e) {
if (Ne(w_MAFLGOPE,ctrlValue)) {
var ctl = _GetCtl(e,'EIHHOYVEDW');
if (_tracker.goon(ctl,ctrlValue)) {
w_MAFLGOPE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('EIHHOYVEDW',0);
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
function Set_MAFLGBON(ctrlValue,kmode,e) {
if (Ne(w_MAFLGBON,ctrlValue)) {
var ctl = _GetCtl(e,'MHLKURBXQM');
if (_tracker.goon(ctl,ctrlValue)) {
w_MAFLGBON=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MHLKURBXQM',0);
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
function Set_MAFLGCKR(ctrlValue,kmode,e) {
if (Ne(w_MAFLGCKR,ctrlValue)) {
var ctl = _GetCtl(e,'KDDADCDNIG');
if (_tracker.goon(ctl,ctrlValue)) {
w_MAFLGCKR=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('KDDADCDNIG',0);
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
function Set_MAFLGASR(ctrlValue,kmode,e) {
if (Ne(w_MAFLGASR,ctrlValue)) {
var ctl = _GetCtl(e,'EJTKDNLUIZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_MAFLGASR=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('EJTKDNLUIZ',0);
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
function Set_MAFLGNOX(ctrlValue,kmode,e) {
if (Ne(w_MAFLGNOX,ctrlValue)) {
var ctl = _GetCtl(e,'FLWNMAVARU');
if (_tracker.goon(ctl,ctrlValue)) {
w_MAFLGNOX=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FLWNMAVARU',0);
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
function Set_MADIPSTD(ctrlValue,kmode,e) {
if (Ne(w_MADIPSTD,ctrlValue)) {
var ctl = _GetCtl(e,'LRWPVABXRO');
if (_tracker.goon(ctl,ctrlValue)) {
w_MADIPSTD=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('LRWPVABXRO',0);
if (l_bResult) {
l_bResult=Link_LRWPVABXRO(kmode);
if ( ! (l_bResult)) {
w_MADIPSTD=HtW('','C');
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
function Set_MARESCAP(ctrlValue,kmode,e) {
if (Ne(w_MARESCAP,ctrlValue)) {
var ctl = _GetCtl(e,'LWTLGAYOFY');
if (_tracker.goon(ctl,ctrlValue)) {
w_MARESCAP=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('LWTLGAYOFY',0);
l_bResult=l_bResult && _ChkObl('OBWMFCTJTG',0);
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
function Set_MANAIDWU(ctrlValue,kmode,e) {
if (Ne(w_MANAIDWU,ctrlValue)) {
var ctl = _GetCtl(e,'CNGYYMAOSD');
if (_tracker.goon(ctl,ctrlValue)) {
w_MANAIDWU=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CNGYYMAOSD',0);
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
function Set_MAFLGCHKDAT(ctrlValue,kmode,e) {
if (Ne(w_MAFLGCHKDAT,ctrlValue)) {
var ctl = _GetCtl(e,'PVYFXNLRHX');
if (_tracker.goon(ctl,ctrlValue)) {
w_MAFLGCHKDAT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('PVYFXNLRHX',0);
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
function Set_MAFLGACT(ctrlValue,kmode,e) {
if (Ne(w_MAFLGACT,ctrlValue)) {
var ctl = _GetCtl(e,'LFYBATBNHY');
if (_tracker.goon(ctl,ctrlValue)) {
w_MAFLGACT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('LFYBATBNHY',0);
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
function Set_MARESSDEF(ctrlValue,kmode,e) {
if (Ne(w_MARESSDEF,ctrlValue)) {
var ctl = _GetCtl(e,'XDJMLPLVUM');
if (_tracker.goon(ctl,ctrlValue)) {
w_MARESSDEF=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XDJMLPLVUM',0);
if (l_bResult) {
l_bResult=Link_XDJMLPLVUM(kmode);
if ( ! (l_bResult)) {
w_MARESSDEF=HtW('','C');
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
function Set_MARESIND(ctrlValue,kmode,e) {
if (Ne(w_MARESIND,ctrlValue)) {
var ctl = _GetCtl(e,'MURAEDMCDC');
if (_tracker.goon(ctl,ctrlValue)) {
w_MARESIND=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MURAEDMCDC',0);
l_bResult=l_bResult && _ChkObl('TGDACWRRAA',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('MURAEDMCDC',function(){return WtH(w_MARESIND,'C',50,0,'@!')},w_MARESIND);
return l_bResult;
} else {
ctl.value=WtH('','C',50,0,'@!');
_ResetTracker();
return true;
}
}
return true;
}
function Set_MAFLGAUA(ctrlValue,kmode,e) {
if (Ne(w_MAFLGAUA,ctrlValue)) {
var ctl = _GetCtl(e,'ZLKRYVPWEH');
if (_tracker.goon(ctl,ctrlValue)) {
w_MAFLGAUA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ZLKRYVPWEH',0);
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
function Set_MATIPAGE(ctrlValue,kmode,e) {
if (Ne(w_MATIPAGE,ctrlValue)) {
var ctl = _GetCtl(e,'HUKDVHFFUB');
if (_tracker.goon(ctl,ctrlValue)) {
w_MATIPAGE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HUKDVHFFUB',0);
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
function Set_MAFISGIU(ctrlValue,kmode,e) {
if (Ne(w_MAFISGIU,ctrlValue)) {
var ctl = _GetCtl(e,'TCJHVDJTUY');
if (_tracker.goon(ctl,ctrlValue)) {
w_MAFISGIU=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('TCJHVDJTUY',0);
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
function Set_MADATINI(ctrlValue,kmode,e) {
if (Ne(w_MADATINI,ctrlValue)) {
var ctl = _GetCtl(e,'RROACIQRKN');
if (_tracker.goon(ctl,ctrlValue)) {
w_MADATINI=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RROACIQRKN',0);
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
function Set_MADATFIN(ctrlValue,kmode,e) {
if (Ne(w_MADATFIN,ctrlValue)) {
var ctl = _GetCtl(e,'UYKWSCJLEB');
if (_tracker.goon(ctl,ctrlValue)) {
w_MADATFIN=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UYKWSCJLEB',0);
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
function Set_MADATMOD(ctrlValue,kmode,e) {
if (Ne(w_MADATMOD,ctrlValue)) {
var ctl = _GetCtl(e,'MGUFLYJWMR');
if (_tracker.goon(ctl,ctrlValue)) {
w_MADATMOD=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MGUFLYJWMR',0);
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
function Set_MADOMCITTA(ctrlValue,kmode,e) {
if (Ne(w_MADOMCITTA,ctrlValue)) {
var ctl = _GetCtl(e,'UUHMAJHIGT');
if (_tracker.goon(ctl,ctrlValue)) {
w_MADOMCITTA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UUHMAJHIGT',0);
if (l_bResult) {
l_bResult=Link_UUHMAJHIGT(kmode);
if ( ! (l_bResult)) {
w_MADOMCITTA=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',60,0,'@!'));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',60,0,'@!');
_ResetTracker();
return true;
}
}
return true;
}
function Set_MACOGNOME(ctrlValue,kmode,e) {
if (Ne(w_MACOGNOME,ctrlValue)) {
var ctl = _GetCtl(e,'ESOMNUPHTE');
if (_tracker.goon(ctl,ctrlValue)) {
w_MACOGNOME=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ESOMNUPHTE',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('ESOMNUPHTE',function(){return WtH(w_MACOGNOME,'C',50,0,'@!')},w_MACOGNOME);
return l_bResult;
} else {
ctl.value=WtH('','C',50,0,'@!');
_ResetTracker();
return true;
}
}
return true;
}
function Set_MANOME(ctrlValue,kmode,e) {
if (Ne(w_MANOME,ctrlValue)) {
var ctl = _GetCtl(e,'ZXBKIFGVGY');
if (_tracker.goon(ctl,ctrlValue)) {
w_MANOME=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ZXBKIFGVGY',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('ZXBKIFGVGY',function(){return WtH(w_MANOME,'C',50,0,'@!')},w_MANOME);
return l_bResult;
} else {
ctl.value=WtH('','C',50,0,'@!');
_ResetTracker();
return true;
}
}
return true;
}
function Set_MARESPAESE(ctrlValue,kmode,e) {
if (Ne(w_MARESPAESE,ctrlValue)) {
var ctl = _GetCtl(e,'BFMOWHWVBP');
if (_tracker.goon(ctl,ctrlValue)) {
w_MARESPAESE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BFMOWHWVBP',0);
if (l_bResult) {
l_bResult=Link_BFMOWHWVBP(kmode);
if ( ! (l_bResult)) {
w_MARESPAESE=HtW('','C');
}
}
l_bResult=l_bResult && _ChkObl('HSKILYGZSO',0);
if (l_bResult) {
l_bResult=Link_HSKILYGZSO(kmode);
if ( ! (l_bResult)) {
w_MARESPAESE=HtW('','C');
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
function Set_MARESCITTA(ctrlValue,kmode,e) {
if (Ne(w_MARESCITTA,ctrlValue)) {
var ctl = _GetCtl(e,'ODQOMCYUIH');
if (_tracker.goon(ctl,ctrlValue)) {
w_MARESCITTA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ODQOMCYUIH',0);
if (l_bResult) {
l_bResult=Link_ODQOMCYUIH(kmode);
if ( ! (l_bResult)) {
w_MARESCITTA=HtW('','C');
}
}
l_bResult=l_bResult && _ChkObl('NHXACJTYPN',0);
if (l_bResult) {
l_bResult=Link_NHXACJTYPN(kmode);
if ( ! (l_bResult)) {
w_MARESCITTA=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',60,0,'@!'));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',60,0,'@!');
_ResetTracker();
return true;
}
}
return true;
}
function Set_MADOMIND(ctrlValue,kmode,e) {
if (Ne(w_MADOMIND,ctrlValue)) {
var ctl = _GetCtl(e,'AZHKYECVLF');
if (_tracker.goon(ctl,ctrlValue)) {
w_MADOMIND=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('AZHKYECVLF',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('AZHKYECVLF',function(){return WtH(w_MADOMIND,'C',50,0,'@!')},w_MADOMIND);
return l_bResult;
} else {
ctl.value=WtH('','C',50,0,'@!');
_ResetTracker();
return true;
}
}
return true;
}
function Set_MARESPRV(ctrlValue,kmode,e) {
if (Ne(w_MARESPRV,ctrlValue)) {
var ctl = _GetCtl(e,'UHIQZUDMGI');
if (_tracker.goon(ctl,ctrlValue)) {
w_MARESPRV=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UHIQZUDMGI',0);
l_bResult=l_bResult && _ChkObl('NVHTOUGLDP',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('UHIQZUDMGI',function(){return WtH(w_MARESPRV,'C',2,0,'@!')},w_MARESPRV);
return l_bResult;
} else {
ctl.value=WtH('','C',2,0,'@!');
_ResetTracker();
return true;
}
}
return true;
}
function Set_MADOMNCIV(ctrlValue,kmode,e) {
if (Ne(w_MADOMNCIV,ctrlValue)) {
var ctl = _GetCtl(e,'DRNUGFPEBE');
if (_tracker.goon(ctl,ctrlValue)) {
w_MADOMNCIV=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('DRNUGFPEBE',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('DRNUGFPEBE',function(){return WtH(w_MADOMNCIV,'C',15,0,'@!')},w_MADOMNCIV);
return l_bResult;
} else {
ctl.value=WtH('','C',15,0,'@!');
_ResetTracker();
return true;
}
}
return true;
}
function Set_MAFLGCOMPL(ctrlValue,kmode,e) {
if (Ne(w_MAFLGCOMPL,ctrlValue)) {
var ctl = _GetCtl(e,'MGGEMJQGRJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_MAFLGCOMPL=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MGGEMJQGRJ',0);
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
function Set_MARESNCIV(ctrlValue,kmode,e) {
if (Ne(w_MARESNCIV,ctrlValue)) {
var ctl = _GetCtl(e,'FQYPBTRCED');
if (_tracker.goon(ctl,ctrlValue)) {
w_MARESNCIV=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FQYPBTRCED',0);
l_bResult=l_bResult && _ChkObl('TSPCNBOMFU',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('FQYPBTRCED',function(){return WtH(w_MARESNCIV,'C',15,0,'@!')},w_MARESNCIV);
return l_bResult;
} else {
ctl.value=WtH('','C',15,0,'@!');
_ResetTracker();
return true;
}
}
return true;
}
function Set_MADOMPAESE(ctrlValue,kmode,e) {
if (Ne(w_MADOMPAESE,ctrlValue)) {
var ctl = _GetCtl(e,'DJVPNMOUXM');
if (_tracker.goon(ctl,ctrlValue)) {
w_MADOMPAESE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('DJVPNMOUXM',0);
if (l_bResult) {
l_bResult=Link_DJVPNMOUXM(kmode);
if ( ! (l_bResult)) {
w_MADOMPAESE=HtW('','C');
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
function Set_MADOMCAP(ctrlValue,kmode,e) {
if (Ne(w_MADOMCAP,ctrlValue)) {
var ctl = _GetCtl(e,'WEAMCVVDVI');
if (_tracker.goon(ctl,ctrlValue)) {
w_MADOMCAP=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('WEAMCVVDVI',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('WEAMCVVDVI',function(){return WtH(w_MADOMCAP,'C',15,0,'@!')},w_MADOMCAP);
return l_bResult;
} else {
ctl.value=WtH('','C',15,0,'@!');
_ResetTracker();
return true;
}
}
return true;
}
function Set_MADOMPRV(ctrlValue,kmode,e) {
if (Ne(w_MADOMPRV,ctrlValue)) {
var ctl = _GetCtl(e,'ZQOYBAIYYW');
if (_tracker.goon(ctl,ctrlValue)) {
w_MADOMPRV=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ZQOYBAIYYW',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('ZQOYBAIYYW',function(){return WtH(w_MADOMPRV,'C',2,0,'@!')},w_MADOMPRV);
return l_bResult;
} else {
ctl.value=WtH('','C',2,0,'@!');
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
function Link_LRWPVABXRO(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_MADIPSTD);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODDIP',w_MADIPSTD,6,0);
l_Appl.SetFields('CODDIP,DESCRIZ');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('anadip');
l_Appl.SetID('LRWPVABXRO');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_MADIPSTD=l_Appl.GetStringValue('CODDIP',6,0);
w_xDESDIP=l_Appl.GetStringValue('DESCRIZ',30,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_LRWPVABXRO_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_LRWPVABXRO';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
l_cFieldFilter=l_cFieldFilter+l_cAndOpForField+_flt_('MACROAGENTE',w_MACODICE,null,true,'=');
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_LRWPVABXRO();
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
function Link_LRWPVABXRO_Blank() {
w_MADIPSTD='';
w_xDESDIP='';
}
function LOpt_LRWPVABXRO() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('anadip','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODDIP','C'));
l_oWv.setValue('LinkedField',WtA('CODDIP','C'));
l_oWv.setValue('UID',WtA('LRWPVABXRO','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['LRWPVABXRO'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('116301484'),'C'));
return l_oWv;
}
function Sugg_XDJMLPLVUM(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_Appl = LinkApplet();
var l_bEmp = Empty(HtW(Ctrl('XDJMLPLVUM').value,'C'));
l_Appl.SetStringKey('CODSTA',HtW(Ctrl('XDJMLPLVUM').value,'C'),3,0);
l_Appl.SetFields('CODSTA,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbstati');
l_Appl.SetID('XDJMLPLVUM');
l_Appl.SetMode('suggest');
l_Appl.SetRows('10');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
var res = l_Appl.GetJSONData();
SuggesterLib.render_suggest(res,'XDJMLPLVUM','XDJMLPLVUM',false,'MGKJOJJOBA_DIV','MGKJOJJOBA_HEADER',0);
return l_bResult;
}
SuggesterLib.select_suggest.XDJMLPLVUM=["MARESSDEF",[null,null],function(newval) { return HtW(newval,'C')}];
function Link_XDJMLPLVUM(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_MARESSDEF);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODSTA',w_MARESSDEF,3,0);
l_Appl.SetFields('CODSTA,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbstati');
l_Appl.SetID('XDJMLPLVUM');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_MARESSDEF=l_Appl.GetStringValue('CODSTA',3,0);
w_despaese=l_Appl.GetStringValue('DESCRI',40,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_XDJMLPLVUM_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_XDJMLPLVUM';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_XDJMLPLVUM();
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
function Link_XDJMLPLVUM_Blank() {
w_MARESSDEF='';
w_despaese='';
}
function LOpt_XDJMLPLVUM() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstati','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODSTA','C'));
l_oWv.setValue('LinkedField',WtA('CODSTA','C'));
l_oWv.setValue('UID',WtA('XDJMLPLVUM','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['XDJMLPLVUM'][1],'C'));
return l_oWv;
}
function Link_BFMOWHWVBP(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_MARESPAESE);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODSTA',w_MARESPAESE,3,0);
l_Appl.SetFields('CODSTA,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbstati');
l_Appl.SetLinkzoom('armt_stati');
l_Appl.SetID('BFMOWHWVBP');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_MARESPAESE=l_Appl.GetStringValue('CODSTA',3,0);
w_xDESSTARES=l_Appl.GetStringValue('DESCRI',40,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_BFMOWHWVBP_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_BFMOWHWVBP';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_BFMOWHWVBP();
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
function Link_BFMOWHWVBP_Blank() {
w_MARESPAESE='';
w_xDESSTARES='';
}
function LOpt_BFMOWHWVBP() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstati','C'));
l_oWv.setValue('Linkzoomprg',WtA('armt_stati','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODSTA','C'));
l_oWv.setValue('LinkedField',WtA('CODSTA','C'));
l_oWv.setValue('UID',WtA('BFMOWHWVBP','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['BFMOWHWVBP'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('7383187'),'C'));
return l_oWv;
}
function Link_ODQOMCYUIH(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_MARESCITTA);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CITTA',w_MARESCITTA,60,0);
l_Appl.SetFields('CITTA,CAP,PROV');
l_Appl.SetTypes('C,C,C');
l_Appl.LinkTable('tbcitta');
l_Appl.SetID('ODQOMCYUIH');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_MARESCITTA=l_Appl.GetStringValue('CITTA',60,0);
w_MARESCAP=l_Appl.GetStringValue('CAP',15,0);
w_MARESPRV=l_Appl.GetStringValue('PROV',2,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_ODQOMCYUIH_Blank();
l_bResult=true;
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_ODQOMCYUIH';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_ODQOMCYUIH();
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
function Link_ODQOMCYUIH_Blank() {
w_MARESCAP='';
w_MARESPRV='';
}
function LOpt_ODQOMCYUIH() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcitta','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CITTA','C'));
l_oWv.setValue('LinkedField',WtA('CITTA','C'));
l_oWv.setValue('UID',WtA('ODQOMCYUIH','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['ODQOMCYUIH'][1],'C'));
return l_oWv;
}
function Link_DJVPNMOUXM(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_MADOMPAESE);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODSTA',w_MADOMPAESE,3,0);
l_Appl.SetFields('CODSTA,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbstati');
l_Appl.SetLinkzoom('armt_stati');
l_Appl.SetID('DJVPNMOUXM');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_MADOMPAESE=l_Appl.GetStringValue('CODSTA',3,0);
w_xDESSTADOM=l_Appl.GetStringValue('DESCRI',40,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_DJVPNMOUXM_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_DJVPNMOUXM';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_DJVPNMOUXM();
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
function Link_DJVPNMOUXM_Blank() {
w_MADOMPAESE='';
w_xDESSTADOM='';
}
function LOpt_DJVPNMOUXM() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstati','C'));
l_oWv.setValue('Linkzoomprg',WtA('armt_stati','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODSTA','C'));
l_oWv.setValue('LinkedField',WtA('CODSTA','C'));
l_oWv.setValue('UID',WtA('DJVPNMOUXM','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['DJVPNMOUXM'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('7383187'),'C'));
return l_oWv;
}
function Link_UUHMAJHIGT(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_MADOMCITTA);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CITTA',w_MADOMCITTA,60,0);
l_Appl.SetFields('CITTA,CAP,PROV');
l_Appl.SetTypes('C,C,C');
l_Appl.LinkTable('tbcitta');
l_Appl.SetID('UUHMAJHIGT');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_MADOMCITTA=l_Appl.GetStringValue('CITTA',60,0);
w_MADOMCAP=l_Appl.GetStringValue('CAP',15,0);
w_MADOMPRV=l_Appl.GetStringValue('PROV',2,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_UUHMAJHIGT_Blank();
l_bResult=true;
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_UUHMAJHIGT';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_UUHMAJHIGT();
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
function Link_UUHMAJHIGT_Blank() {
w_MADOMCAP='';
w_MADOMPRV='';
}
function LOpt_UUHMAJHIGT() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcitta','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CITTA','C'));
l_oWv.setValue('LinkedField',WtA('CITTA','C'));
l_oWv.setValue('UID',WtA('UUHMAJHIGT','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['UUHMAJHIGT'][1],'C'));
return l_oWv;
}
function Link_HSKILYGZSO(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_MARESPAESE);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODSTA',w_MARESPAESE,3,0);
l_Appl.SetFields('CODSTA,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbstati');
l_Appl.SetLinkzoom('armt_stati');
l_Appl.SetID('HSKILYGZSO');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_MARESPAESE=l_Appl.GetStringValue('CODSTA',3,0);
w_xDESSTARES=l_Appl.GetStringValue('DESCRI',40,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_HSKILYGZSO_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_HSKILYGZSO';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_HSKILYGZSO();
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
function Link_HSKILYGZSO_Blank() {
w_MARESPAESE='';
w_xDESSTARES='';
}
function LOpt_HSKILYGZSO() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstati','C'));
l_oWv.setValue('Linkzoomprg',WtA('armt_stati','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODSTA','C'));
l_oWv.setValue('LinkedField',WtA('CODSTA','C'));
l_oWv.setValue('UID',WtA('HSKILYGZSO','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['HSKILYGZSO'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('7383187'),'C'));
return l_oWv;
}
function Link_NHXACJTYPN(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_MARESCITTA);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CITTA',w_MARESCITTA,60,0);
l_Appl.SetFields('CITTA,CAP,PROV');
l_Appl.SetTypes('C,C,C');
l_Appl.LinkTable('tbcitta');
l_Appl.SetID('NHXACJTYPN');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_MARESCITTA=l_Appl.GetStringValue('CITTA',60,0);
w_MARESCAP=l_Appl.GetStringValue('CAP',15,0);
w_MARESPRV=l_Appl.GetStringValue('PROV',2,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_NHXACJTYPN_Blank();
l_bResult=true;
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_NHXACJTYPN';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_NHXACJTYPN();
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
function Link_NHXACJTYPN_Blank() {
w_MARESCAP='';
w_MARESPRV='';
}
function LOpt_NHXACJTYPN() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcitta','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CITTA','C'));
l_oWv.setValue('LinkedField',WtA('CITTA','C'));
l_oWv.setValue('UID',WtA('NHXACJTYPN','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['NHXACJTYPN'][1],'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'LRWPVABXRO')) {
last_focused_comp=GetLastFocusedElementOfLink('LRWPVABXRO');
function SetMethod_LRWPVABXRO() {
Set_MADIPSTD(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_LRWPVABXRO();
} else {
setTimeout(SetMethod_LRWPVABXRO,1);
}
bResult=true;
}
if (Eq(varName,'XDJMLPLVUM')) {
last_focused_comp=GetLastFocusedElementOfLink('XDJMLPLVUM');
function SetMethod_XDJMLPLVUM() {
Set_MARESSDEF(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_XDJMLPLVUM();
} else {
setTimeout(SetMethod_XDJMLPLVUM,1);
}
bResult=true;
}
if (Eq(varName,'BFMOWHWVBP')) {
last_focused_comp=GetLastFocusedElementOfLink('BFMOWHWVBP');
function SetMethod_BFMOWHWVBP() {
Set_MARESPAESE(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_BFMOWHWVBP();
} else {
setTimeout(SetMethod_BFMOWHWVBP,1);
}
bResult=true;
}
if (Eq(varName,'ODQOMCYUIH')) {
last_focused_comp=GetLastFocusedElementOfLink('ODQOMCYUIH');
function SetMethod_ODQOMCYUIH() {
Set_MARESCITTA(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_ODQOMCYUIH();
} else {
setTimeout(SetMethod_ODQOMCYUIH,1);
}
bResult=true;
}
if (Eq(varName,'DJVPNMOUXM')) {
last_focused_comp=GetLastFocusedElementOfLink('DJVPNMOUXM');
function SetMethod_DJVPNMOUXM() {
Set_MADOMPAESE(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_DJVPNMOUXM();
} else {
setTimeout(SetMethod_DJVPNMOUXM,1);
}
bResult=true;
}
if (Eq(varName,'UUHMAJHIGT')) {
last_focused_comp=GetLastFocusedElementOfLink('UUHMAJHIGT');
function SetMethod_UUHMAJHIGT() {
Set_MADOMCITTA(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_UUHMAJHIGT();
} else {
setTimeout(SetMethod_UUHMAJHIGT,1);
}
bResult=true;
}
if (Eq(varName,'HSKILYGZSO')) {
last_focused_comp=GetLastFocusedElementOfLink('HSKILYGZSO');
function SetMethod_HSKILYGZSO() {
Set_MARESPAESE(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_HSKILYGZSO();
} else {
setTimeout(SetMethod_HSKILYGZSO,1);
}
bResult=true;
}
if (Eq(varName,'NHXACJTYPN')) {
last_focused_comp=GetLastFocusedElementOfLink('NHXACJTYPN');
function SetMethod_NHXACJTYPN() {
Set_MARESCITTA(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_NHXACJTYPN();
} else {
setTimeout(SetMethod_NHXACJTYPN,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'LRWPVABXRO')) {
return [Ctrl('LRWPVABXRO')];
}
if (Eq(varName,'XDJMLPLVUM')) {
return [Ctrl('XDJMLPLVUM')];
}
if (Eq(varName,'BFMOWHWVBP')) {
return [Ctrl('BFMOWHWVBP')];
}
if (Eq(varName,'ODQOMCYUIH')) {
return [Ctrl('ODQOMCYUIH')];
}
if (Eq(varName,'DJVPNMOUXM')) {
return [Ctrl('DJVPNMOUXM')];
}
if (Eq(varName,'UUHMAJHIGT')) {
return [Ctrl('UUHMAJHIGT')];
}
if (Eq(varName,'HSKILYGZSO')) {
return [Ctrl('HSKILYGZSO')];
}
if (Eq(varName,'NHXACJTYPN')) {
return [Ctrl('NHXACJTYPN')];
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
parent.ZtVWeb.raiseEventToEvalParms('armt_tbmacage_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('armt_tbmacage_dataNotSent',{'action':formaction});
}
}
}
}
CheckChild.child=[{'prg':"ardt_ageresleg",'BOScId':function(){ return FrameRef('ardt_ageresleg')},'repeated':0}];
function Check() {
var l_bResult = true;
var l_bChildCheck = true;
ResetErrorVars();
m_nLastError=0;
if ( ! (_ChkObl('LVIYDAHUQL',1))) {
_SignErr('LVIYDAHUQL');
m_cLastWorkVarErrorMsg='112851763';
l_bResult=false;
w_MACODICE=HtW('','C');
} else if ( ! (_ChkObl('UJLZTFQRLR',1))) {
_SignErr('UJLZTFQRLR');
m_cLastWorkVarErrorMsg='12056209762';
l_bResult=false;
w_MADESCRI=HtW('','C');
} else if ( ! (_ChkObl('ASRUOVVPGY',1))) {
_SignErr('ASRUOVVPGY');
m_cLastWorkVarErrorMsg='1331482594';
l_bResult=false;
w_MAFLGRAP='N';
} else if ( ! (_ChkObl('EIHHOYVEDW',1))) {
_SignErr('EIHHOYVEDW');
m_cLastWorkVarErrorMsg='11895403464';
l_bResult=false;
w_MAFLGOPE=HtW('','C');
} else if ( ! (_ChkObl('MHLKURBXQM',1))) {
_SignErr('MHLKURBXQM');
m_cLastWorkVarErrorMsg='1331668514';
l_bResult=false;
w_MAFLGBON='N';
} else if ( ! (_ChkObl('KDDADCDNIG',1))) {
_SignErr('KDDADCDNIG');
m_cLastWorkVarErrorMsg='1970676031';
l_bResult=false;
w_MAFLGCKR='N';
} else if ( ! (_ChkObl('EJTKDNLUIZ',1))) {
_SignErr('EJTKDNLUIZ');
m_cLastWorkVarErrorMsg='801105630';
l_bResult=false;
w_MAFLGASR='N';
} else if ( ! (_ChkObl('FLWNMAVARU',1))) {
_SignErr('FLWNMAVARU');
m_cLastWorkVarErrorMsg='940604062';
l_bResult=false;
w_MAFLGNOX='N';
} else if ( ! (_ChkObl('LRWPVABXRO',1))) {
_SignErr('LRWPVABXRO');
m_cLastWorkVarErrorMsg='4098271';
l_bResult=false;
w_MADIPSTD=HtW('','C');
} else if ( ! (_ChkObl('CNGYYMAOSD',1))) {
_SignErr('CNGYYMAOSD');
m_cLastWorkVarErrorMsg='298334';
l_bResult=false;
w_MANAIDWU=HtW('','C');
} else if ( ! (_ChkObl('PVYFXNLRHX',1))) {
_SignErr('PVYFXNLRHX');
m_cLastWorkVarErrorMsg='1402859319';
l_bResult=false;
w_MAFLGCHKDAT='N';
} else if ( ! (_ChkObl('LFYBATBNHY',1))) {
_SignErr('LFYBATBNHY');
m_cLastWorkVarErrorMsg='1267648172';
l_bResult=false;
w_MAFLGACT='N';
} else if ( ! (_ChkObl('XDJMLPLVUM',1))) {
_SignErr('XDJMLPLVUM');
m_cLastWorkVarErrorMsg='1547044447';
l_bResult=false;
w_MARESSDEF=HtW('','C');
} else if ( ! (_ChkObl('ZLKRYVPWEH',1))) {
_SignErr('ZLKRYVPWEH');
m_cLastWorkVarErrorMsg='11553173743';
l_bResult=false;
w_MAFLGAUA='N';
} else if ( ! (_ChkObl('HUKDVHFFUB',1))) {
_SignErr('HUKDVHFFUB');
m_cLastWorkVarErrorMsg='11153969262';
l_bResult=false;
w_MATIPAGE=HtW('','C');
} else if ( ! (_ChkObl('TCJHVDJTUY',1))) {
_SignErr('TCJHVDJTUY');
m_cLastWorkVarErrorMsg='280667660';
l_bResult=false;
w_MAFISGIU=HtW('','C');
} else if ( ! (_ChkObl('RROACIQRKN',1))) {
_SignErr('RROACIQRKN');
m_cLastWorkVarErrorMsg='2032298989';
l_bResult=false;
w_MADATINI=HtW('','D');
} else if ( ! (_ChkObl('UYKWSCJLEB',1))) {
_SignErr('UYKWSCJLEB','1325233457');
l_bResult=false;
w_MADATFIN=HtW('','D');
} else if ( ! (_ChkObl('MGUFLYJWMR',1))) {
_SignErr('MGUFLYJWMR');
m_cLastWorkVarErrorMsg='1676510859';
l_bResult=false;
w_MADATMOD=HtW('','D');
} else if ( ! (_ChkObl('OPANBXIPXY',1))) {
_SignErr('OPANBXIPXY');
m_cLastWorkVarErrorMsg='11132404598';
l_bResult=false;
w_MACODFIS=HtW('','C');
} else if ( ! (_ChkObl('ESOMNUPHTE',1))) {
_SignErr('ESOMNUPHTE');
m_cLastWorkVarErrorMsg='1816546867';
l_bResult=false;
w_MACOGNOME=HtW('','C');
} else if ( ! (_ChkObl('ZXBKIFGVGY',1))) {
_SignErr('ZXBKIFGVGY');
m_cLastWorkVarErrorMsg='443454';
l_bResult=false;
w_MANOME=HtW('','C');
} else if ( ! (_ChkObl('BFMOWHWVBP',1))) {
_SignErr('BFMOWHWVBP');
m_cLastWorkVarErrorMsg='226580067';
l_bResult=false;
w_MARESPAESE=HtW('','C');
} else if ( ! (_ChkObl('ODQOMCYUIH',1))) {
_SignErr('ODQOMCYUIH');
m_cLastWorkVarErrorMsg='15186643';
l_bResult=false;
w_MARESCITTA=HtW('','C');
} else if ( ! (_ChkObl('LWTLGAYOFY',1))) {
_SignErr('LWTLGAYOFY');
m_cLastWorkVarErrorMsg='21587';
l_bResult=false;
w_MARESCAP=HtW('','C');
} else if ( ! (_ChkObl('UHIQZUDMGI',1))) {
_SignErr('UHIQZUDMGI');
m_cLastWorkVarErrorMsg='10095365423';
l_bResult=false;
w_MARESPRV=HtW('','C');
} else if ( ! (_ChkObl('MURAEDMCDC',1))) {
_SignErr('MURAEDMCDC');
m_cLastWorkVarErrorMsg='554236824';
l_bResult=false;
w_MARESIND=HtW('','C');
} else if ( ! (_ChkObl('FQYPBTRCED',1))) {
_SignErr('FQYPBTRCED');
m_cLastWorkVarErrorMsg='11597156451';
l_bResult=false;
w_MARESNCIV=HtW('','C');
} else if ( ! (_ChkObl('DJVPNMOUXM',1))) {
_SignErr('DJVPNMOUXM');
m_cLastWorkVarErrorMsg='226580067';
l_bResult=false;
w_MADOMPAESE=HtW('','C');
} else if ( ! (_ChkObl('UUHMAJHIGT',1))) {
_SignErr('UUHMAJHIGT');
m_cLastWorkVarErrorMsg='15186643';
l_bResult=false;
w_MADOMCITTA=HtW('','C');
} else if ( ! (_ChkObl('WEAMCVVDVI',1))) {
_SignErr('WEAMCVVDVI');
m_cLastWorkVarErrorMsg='21587';
l_bResult=false;
w_MADOMCAP=HtW('','C');
} else if ( ! (_ChkObl('ZQOYBAIYYW',1))) {
_SignErr('ZQOYBAIYYW');
m_cLastWorkVarErrorMsg='10095365423';
l_bResult=false;
w_MADOMPRV=HtW('','C');
} else if ( ! (_ChkObl('AZHKYECVLF',1))) {
_SignErr('AZHKYECVLF');
m_cLastWorkVarErrorMsg='554236824';
l_bResult=false;
w_MADOMIND=HtW('','C');
} else if ( ! (_ChkObl('DRNUGFPEBE',1))) {
_SignErr('DRNUGFPEBE');
m_cLastWorkVarErrorMsg='11597156451';
l_bResult=false;
w_MADOMNCIV=HtW('','C');
} else if ( ! (_ChkObl('HSKILYGZSO',1))) {
_SignErr('HSKILYGZSO');
m_cLastWorkVarErrorMsg='226580067';
l_bResult=false;
w_MARESPAESE=HtW('','C');
} else if ( ! (_ChkObl('NHXACJTYPN',1))) {
_SignErr('NHXACJTYPN');
m_cLastWorkVarErrorMsg='15186643';
l_bResult=false;
w_MARESCITTA=HtW('','C');
} else if ( ! (_ChkObl('TGDACWRRAA',1))) {
_SignErr('TGDACWRRAA');
m_cLastWorkVarErrorMsg='554236824';
l_bResult=false;
w_MARESIND=HtW('','C');
} else if ( ! (_ChkObl('TSPCNBOMFU',1))) {
_SignErr('TSPCNBOMFU');
m_cLastWorkVarErrorMsg='11597156451';
l_bResult=false;
w_MARESNCIV=HtW('','C');
} else if ( ! (_ChkObl('OBWMFCTJTG',1))) {
_SignErr('OBWMFCTJTG');
m_cLastWorkVarErrorMsg='21587';
l_bResult=false;
w_MARESCAP=HtW('','C');
} else if ( ! (_ChkObl('NVHTOUGLDP',1))) {
_SignErr('NVHTOUGLDP');
m_cLastWorkVarErrorMsg='10095365423';
l_bResult=false;
w_MARESPRV=HtW('','C');
} else if ( ! (_ChkObl('MGGEMJQGRJ',1))) {
_SignErr('MGGEMJQGRJ');
m_cLastWorkVarErrorMsg='986106899';
l_bResult=false;
w_MAFLGCOMPL=0;
}
if (l_bResult) {
l_bResult=CheckChild(0);
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('LRWPVABXRO_ZOOM',lc)) {
return 0;
}
if (Eq('LRWPVABXRO',lc)) {
return 0;
}
if (Eq('XDJMLPLVUM_ZOOM',lc)) {
return 1;
}
if (Eq('XDJMLPLVUM',lc)) {
return 1;
}
if (Eq('RROACIQRKN_ZOOM',lc)) {
return 2;
}
if (Eq('UYKWSCJLEB_ZOOM',lc)) {
return 2;
}
if (Eq('MGUFLYJWMR_ZOOM',lc)) {
return 2;
}
if (Eq('BFMOWHWVBP_ZOOM',lc)) {
return 2;
}
if (Eq('BFMOWHWVBP',lc)) {
return 2;
}
if (Eq('ODQOMCYUIH_ZOOM',lc)) {
return 3;
}
if (Eq('ODQOMCYUIH',lc)) {
return 3;
}
if (Eq('DJVPNMOUXM_ZOOM',lc)) {
return 4;
}
if (Eq('DJVPNMOUXM',lc)) {
return 4;
}
if (Eq('UUHMAJHIGT_ZOOM',lc)) {
return 5;
}
if (Eq('UUHMAJHIGT',lc)) {
return 5;
}
if (Eq('HSKILYGZSO_ZOOM',lc)) {
return 6;
}
if (Eq('HSKILYGZSO',lc)) {
return 6;
}
if (Eq('NHXACJTYPN_ZOOM',lc)) {
return 7;
}
if (Eq('NHXACJTYPN',lc)) {
return 7;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_LRWPVABXRO();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
l_cFieldFilter=l_cFieldFilter+l_cAndOpForField+_flt_('MACROAGENTE',w_MACODICE,null,true,'=');
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
l_oWv.setValue('FieldFilter',l_cFieldFilter);
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,1)) {
l_oWv=LOpt_XDJMLPLVUM();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,2)) {
l_oWv=LOpt_BFMOWHWVBP();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,3)) {
l_oWv=LOpt_ODQOMCYUIH();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,4)) {
l_oWv=LOpt_DJVPNMOUXM();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,5)) {
l_oWv=LOpt_UUHMAJHIGT();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,6)) {
l_oWv=LOpt_HSKILYGZSO();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,7)) {
l_oWv=LOpt_NHXACJTYPN();
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
l_oWv.setValue('MACODICE',WtA(w_MACODICE,'C'));
l_oWv.setValue('MADESCRI',WtA(w_MADESCRI,'C'));
l_oWv.setValue('MAFLGRAP',WtA(w_MAFLGRAP,'C'));
l_oWv.setValue('MAFLGOPE',WtA(w_MAFLGOPE,'C'));
l_oWv.setValue('MAFLGBON',WtA(w_MAFLGBON,'C'));
l_oWv.setValue('MAFLGCKR',WtA(w_MAFLGCKR,'C'));
l_oWv.setValue('MAFLGASR',WtA(w_MAFLGASR,'C'));
l_oWv.setValue('MAFLGNOX',WtA(w_MAFLGNOX,'C'));
l_oWv.setValue('MADIPSTD',WtA(w_MADIPSTD,'C'));
l_oWv.setValue('MANAIDWU',WtA(w_MANAIDWU,'C'));
l_oWv.setValue('MAFLGCHKDAT',WtA(w_MAFLGCHKDAT,'C'));
l_oWv.setValue('MAFLGACT',WtA(w_MAFLGACT,'C'));
l_oWv.setValue('MARESSDEF',WtA(w_MARESSDEF,'C'));
l_oWv.setValue('MAFLGAUA',WtA(w_MAFLGAUA,'C'));
l_oWv.setValue('MATIPAGE',WtA(w_MATIPAGE,'C'));
l_oWv.setValue('MAFISGIU',WtA(w_MAFISGIU,'C'));
l_oWv.setValue('MADATINI',WtA(w_MADATINI,'D'));
l_oWv.setValue('MADATFIN',WtA(w_MADATFIN,'D'));
l_oWv.setValue('MADATMOD',WtA(w_MADATMOD,'D'));
l_oWv.setValue('MACODFIS',WtA(w_MACODFIS,'C'));
l_oWv.setValue('MACOGNOME',WtA(w_MACOGNOME,'C'));
l_oWv.setValue('MANOME',WtA(w_MANOME,'C'));
l_oWv.setValue('MARESPAESE',WtA(w_MARESPAESE,'C'));
l_oWv.setValue('MARESCITTA',WtA(w_MARESCITTA,'C'));
l_oWv.setValue('MARESCAP',WtA(w_MARESCAP,'C'));
l_oWv.setValue('MARESPRV',WtA(w_MARESPRV,'C'));
l_oWv.setValue('MARESIND',WtA(w_MARESIND,'C'));
l_oWv.setValue('MARESNCIV',WtA(w_MARESNCIV,'C'));
l_oWv.setValue('MADOMPAESE',WtA(w_MADOMPAESE,'C'));
l_oWv.setValue('MADOMCITTA',WtA(w_MADOMCITTA,'C'));
l_oWv.setValue('MADOMCAP',WtA(w_MADOMCAP,'C'));
l_oWv.setValue('MADOMPRV',WtA(w_MADOMPRV,'C'));
l_oWv.setValue('MADOMIND',WtA(w_MADOMIND,'C'));
l_oWv.setValue('MADOMNCIV',WtA(w_MADOMNCIV,'C'));
l_oWv.setValue('MAFLGCOMPL',WtA(w_MAFLGCOMPL,'N'));
l_oWv.setValue('gFlgWU',WtA(w_gFlgWU,'C'));
l_oWv.setValue('xDESDIP',WtA(w_xDESDIP,'C'));
l_oWv.setValue('despaese',WtA(w_despaese,'C'));
l_oWv.setValue('xDESSTARES',WtA(w_xDESSTARES,'C'));
l_oWv.setValue('xDESSTADOM',WtA(w_xDESSTADOM,'C'));
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
_FillChildren.n=['ardt_ageresleg'];
FillWv.n=["MACODICE","MADESCRI","MAFLGRAP","MAFLGOPE","MAFLGBON","MAFLGCKR","MAFLGASR","MAFLGNOX","MADIPSTD","MANAIDWU","MAFLGCHKDAT","MAFLGACT","MARESSDEF","MAFLGAUA","MATIPAGE","MAFISGIU","MADATINI","MADATFIN","MADATMOD","MACODFIS","MACOGNOME","MANOME","MARESPAESE","MARESCITTA","MARESCAP","MARESPRV","MARESIND","MARESNCIV","MADOMPAESE","MADOMCITTA","MADOMCAP","MADOMPRV","MADOMIND","MADOMNCIV","MAFLGCOMPL","gFlgWU","xDESDIP","despaese","xDESSTARES","xDESSTADOM"];
function SetModified() {
m_bUpdated=true;
}
function SetChildVariables_ardt_ageresleg() {
}
function CtxLoad_ardt_ageresleg() {
if (ChildToLoad(FrameRef('ardt_ageresleg'))) {
return [LoadContext(0,'LBQEONIOQI'),'ardt_ageresleg'];
}
}
