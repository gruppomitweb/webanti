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
if (IsDisabledByStateDriver('Gruppi')) {
DisableInputsInContainer(Ctrl('FUBVXBVEKS'),true);
}
if (IsDisabledByStateDriver('Sottoguppi')) {
DisableInputsInContainer(Ctrl('FMCUBWIEAJ'),true);
}
if (IsDisabledByStateDriver('ATECO')) {
DisableInputsInContainer(Ctrl('CLVYAMUSKV'),true);
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
function Set_SETSINT(ctrlValue,kmode,e) {
if (Ne(w_SETSINT,ctrlValue)) {
var ctl = _GetCtl(e,'VPSAQWGZDD');
if (_tracker.goon(ctl,ctrlValue)) {
w_SETSINT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VPSAQWGZDD',0);
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
function Set_DESCRI(ctrlValue,kmode,e) {
if (Ne(w_DESCRI,ctrlValue)) {
var ctl = _GetCtl(e,'QGQGKEQSTH');
if (_tracker.goon(ctl,ctrlValue)) {
w_DESCRI=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QGQGKEQSTH',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',200,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_ASOT8(ctrlValue,kmode,e) {
if (Ne(w_ASOT8,ctrlValue)) {
var ctl = _GetCtl(e,'FQHPMPIEFY');
if (_tracker.goon(ctl,ctrlValue)) {
w_ASOT8=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FQHPMPIEFY',0);
if (l_bResult) {
l_bResult=Link_FQHPMPIEFY(kmode);
if ( ! (l_bResult)) {
w_ASOT8=HtW('','C');
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
function Set_DASOT9(ctrlValue,kmode,e) {
if (Ne(w_DASOT9,ctrlValue)) {
var ctl = _GetCtl(e,'KGVPSOERYT');
if (_tracker.goon(ctl,ctrlValue)) {
w_DASOT9=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('KGVPSOERYT',0);
if (l_bResult) {
l_bResult=Link_KGVPSOERYT(kmode);
if ( ! (l_bResult)) {
w_DASOT9=HtW('','C');
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
function Set_ASOT9(ctrlValue,kmode,e) {
if (Ne(w_ASOT9,ctrlValue)) {
var ctl = _GetCtl(e,'GWWXIEOXZQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_ASOT9=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('GWWXIEOXZQ',0);
if (l_bResult) {
l_bResult=Link_GWWXIEOXZQ(kmode);
if ( ! (l_bResult)) {
w_ASOT9=HtW('','C');
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
function Set_AATE1(ctrlValue,kmode,e) {
if (Ne(w_AATE1,ctrlValue)) {
var ctl = _GetCtl(e,'EQZKMRBROG');
if (_tracker.goon(ctl,ctrlValue)) {
w_AATE1=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('EQZKMRBROG',0);
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
function Set_DAATE1(ctrlValue,kmode,e) {
if (Ne(w_DAATE1,ctrlValue)) {
var ctl = _GetCtl(e,'DEJMAVGSRU');
if (_tracker.goon(ctl,ctrlValue)) {
w_DAATE1=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('DEJMAVGSRU',0);
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
function Set_AATE6(ctrlValue,kmode,e) {
if (Ne(w_AATE6,ctrlValue)) {
var ctl = _GetCtl(e,'RZOSZBFTCK');
if (_tracker.goon(ctl,ctrlValue)) {
w_AATE6=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RZOSZBFTCK',0);
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
function Set_DAATE6(ctrlValue,kmode,e) {
if (Ne(w_DAATE6,ctrlValue)) {
var ctl = _GetCtl(e,'NNPAZLOCUA');
if (_tracker.goon(ctl,ctrlValue)) {
w_DAATE6=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NNPAZLOCUA',0);
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
function Set_AATE5(ctrlValue,kmode,e) {
if (Ne(w_AATE5,ctrlValue)) {
var ctl = _GetCtl(e,'EXYRSFXTUA');
if (_tracker.goon(ctl,ctrlValue)) {
w_AATE5=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('EXYRSFXTUA',0);
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
function Set_DAATE5(ctrlValue,kmode,e) {
if (Ne(w_DAATE5,ctrlValue)) {
var ctl = _GetCtl(e,'LVOQGHIOAR');
if (_tracker.goon(ctl,ctrlValue)) {
w_DAATE5=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('LVOQGHIOAR',0);
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
function Set_AATE4(ctrlValue,kmode,e) {
if (Ne(w_AATE4,ctrlValue)) {
var ctl = _GetCtl(e,'SWAVWWKXOJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_AATE4=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SWAVWWKXOJ',0);
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
function Set_DAATE4(ctrlValue,kmode,e) {
if (Ne(w_DAATE4,ctrlValue)) {
var ctl = _GetCtl(e,'JMLQTMPVIO');
if (_tracker.goon(ctl,ctrlValue)) {
w_DAATE4=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('JMLQTMPVIO',0);
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
function Set_AATE3(ctrlValue,kmode,e) {
if (Ne(w_AATE3,ctrlValue)) {
var ctl = _GetCtl(e,'YZSORAMVLG');
if (_tracker.goon(ctl,ctrlValue)) {
w_AATE3=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YZSORAMVLG',0);
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
function Set_DATAINI(ctrlValue,kmode,e) {
if (Ne(w_DATAINI,ctrlValue)) {
var ctl = _GetCtl(e,'KUAJNGTYUY');
if (_tracker.goon(ctl,ctrlValue)) {
w_DATAINI=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('KUAJNGTYUY',0);
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
function Set_DATAFINE(ctrlValue,kmode,e) {
if (Ne(w_DATAFINE,ctrlValue)) {
var ctl = _GetCtl(e,'WMKNBZMDVY');
if (_tracker.goon(ctl,ctrlValue)) {
w_DATAFINE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('WMKNBZMDVY',0);
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
function Set_DASOT10(ctrlValue,kmode,e) {
if (Ne(w_DASOT10,ctrlValue)) {
var ctl = _GetCtl(e,'TWZIVFFWLR');
if (_tracker.goon(ctl,ctrlValue)) {
w_DASOT10=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('TWZIVFFWLR',0);
if (l_bResult) {
l_bResult=Link_TWZIVFFWLR(kmode);
if ( ! (l_bResult)) {
w_DASOT10=HtW('','C');
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
function Set_DAGRU1(ctrlValue,kmode,e) {
if (Ne(w_DAGRU1,ctrlValue)) {
var ctl = _GetCtl(e,'BMLJXZOHDR');
if (_tracker.goon(ctl,ctrlValue)) {
w_DAGRU1=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BMLJXZOHDR',0);
if (l_bResult) {
l_bResult=Link_BMLJXZOHDR(kmode);
if ( ! (l_bResult)) {
w_DAGRU1=HtW('','C');
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
function Set_AGRU1(ctrlValue,kmode,e) {
if (Ne(w_AGRU1,ctrlValue)) {
var ctl = _GetCtl(e,'PIMPFADLTV');
if (_tracker.goon(ctl,ctrlValue)) {
w_AGRU1=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('PIMPFADLTV',0);
if (l_bResult) {
l_bResult=Link_PIMPFADLTV(kmode);
if ( ! (l_bResult)) {
w_AGRU1=HtW('','C');
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
function Set_DAGRU2(ctrlValue,kmode,e) {
if (Ne(w_DAGRU2,ctrlValue)) {
var ctl = _GetCtl(e,'NFMNJIJKQG');
if (_tracker.goon(ctl,ctrlValue)) {
w_DAGRU2=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NFMNJIJKQG',0);
if (l_bResult) {
l_bResult=Link_NFMNJIJKQG(kmode);
if ( ! (l_bResult)) {
w_DAGRU2=HtW('','C');
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
function Set_AGRU2(ctrlValue,kmode,e) {
if (Ne(w_AGRU2,ctrlValue)) {
var ctl = _GetCtl(e,'EGVTWLPYYK');
if (_tracker.goon(ctl,ctrlValue)) {
w_AGRU2=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('EGVTWLPYYK',0);
if (l_bResult) {
l_bResult=Link_EGVTWLPYYK(kmode);
if ( ! (l_bResult)) {
w_AGRU2=HtW('','C');
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
function Set_DAGRU3(ctrlValue,kmode,e) {
if (Ne(w_DAGRU3,ctrlValue)) {
var ctl = _GetCtl(e,'PBXUYJXCDV');
if (_tracker.goon(ctl,ctrlValue)) {
w_DAGRU3=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('PBXUYJXCDV',0);
if (l_bResult) {
l_bResult=Link_PBXUYJXCDV(kmode);
if ( ! (l_bResult)) {
w_DAGRU3=HtW('','C');
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
function Set_AGRU3(ctrlValue,kmode,e) {
if (Ne(w_AGRU3,ctrlValue)) {
var ctl = _GetCtl(e,'LKRRMRMXCU');
if (_tracker.goon(ctl,ctrlValue)) {
w_AGRU3=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('LKRRMRMXCU',0);
if (l_bResult) {
l_bResult=Link_LKRRMRMXCU(kmode);
if ( ! (l_bResult)) {
w_AGRU3=HtW('','C');
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
function Set_DAGRU4(ctrlValue,kmode,e) {
if (Ne(w_DAGRU4,ctrlValue)) {
var ctl = _GetCtl(e,'NQYJKRPMAY');
if (_tracker.goon(ctl,ctrlValue)) {
w_DAGRU4=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NQYJKRPMAY',0);
if (l_bResult) {
l_bResult=Link_NQYJKRPMAY(kmode);
if ( ! (l_bResult)) {
w_DAGRU4=HtW('','C');
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
function Set_AGRU4(ctrlValue,kmode,e) {
if (Ne(w_AGRU4,ctrlValue)) {
var ctl = _GetCtl(e,'XLQJSGTFOG');
if (_tracker.goon(ctl,ctrlValue)) {
w_AGRU4=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XLQJSGTFOG',0);
if (l_bResult) {
l_bResult=Link_XLQJSGTFOG(kmode);
if ( ! (l_bResult)) {
w_AGRU4=HtW('','C');
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
function Set_DAGRU5(ctrlValue,kmode,e) {
if (Ne(w_DAGRU5,ctrlValue)) {
var ctl = _GetCtl(e,'VVLLCWNYJU');
if (_tracker.goon(ctl,ctrlValue)) {
w_DAGRU5=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VVLLCWNYJU',0);
if (l_bResult) {
l_bResult=Link_VVLLCWNYJU(kmode);
if ( ! (l_bResult)) {
w_DAGRU5=HtW('','C');
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
function Set_AGRU5(ctrlValue,kmode,e) {
if (Ne(w_AGRU5,ctrlValue)) {
var ctl = _GetCtl(e,'GPJQCCUFYH');
if (_tracker.goon(ctl,ctrlValue)) {
w_AGRU5=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('GPJQCCUFYH',0);
if (l_bResult) {
l_bResult=Link_GPJQCCUFYH(kmode);
if ( ! (l_bResult)) {
w_AGRU5=HtW('','C');
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
function Set_DAGRU6(ctrlValue,kmode,e) {
if (Ne(w_DAGRU6,ctrlValue)) {
var ctl = _GetCtl(e,'OWCFHGKVPB');
if (_tracker.goon(ctl,ctrlValue)) {
w_DAGRU6=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('OWCFHGKVPB',0);
if (l_bResult) {
l_bResult=Link_OWCFHGKVPB(kmode);
if ( ! (l_bResult)) {
w_DAGRU6=HtW('','C');
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
function Set_AGRU6(ctrlValue,kmode,e) {
if (Ne(w_AGRU6,ctrlValue)) {
var ctl = _GetCtl(e,'ZDTAXGFPRF');
if (_tracker.goon(ctl,ctrlValue)) {
w_AGRU6=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ZDTAXGFPRF',0);
if (l_bResult) {
l_bResult=Link_ZDTAXGFPRF(kmode);
if ( ! (l_bResult)) {
w_AGRU6=HtW('','C');
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
function Set_DASOT1(ctrlValue,kmode,e) {
if (Ne(w_DASOT1,ctrlValue)) {
var ctl = _GetCtl(e,'QSAEKELBZF');
if (_tracker.goon(ctl,ctrlValue)) {
w_DASOT1=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QSAEKELBZF',0);
if (l_bResult) {
l_bResult=Link_QSAEKELBZF(kmode);
if ( ! (l_bResult)) {
w_DASOT1=HtW('','C');
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
function Set_ASOT1(ctrlValue,kmode,e) {
if (Ne(w_ASOT1,ctrlValue)) {
var ctl = _GetCtl(e,'TXKEYYFXPE');
if (_tracker.goon(ctl,ctrlValue)) {
w_ASOT1=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('TXKEYYFXPE',0);
if (l_bResult) {
l_bResult=Link_TXKEYYFXPE(kmode);
if ( ! (l_bResult)) {
w_ASOT1=HtW('','C');
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
function Set_DASOT2(ctrlValue,kmode,e) {
if (Ne(w_DASOT2,ctrlValue)) {
var ctl = _GetCtl(e,'XJEPLEAUZI');
if (_tracker.goon(ctl,ctrlValue)) {
w_DASOT2=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XJEPLEAUZI',0);
if (l_bResult) {
l_bResult=Link_XJEPLEAUZI(kmode);
if ( ! (l_bResult)) {
w_DASOT2=HtW('','C');
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
function Set_ASOT2(ctrlValue,kmode,e) {
if (Ne(w_ASOT2,ctrlValue)) {
var ctl = _GetCtl(e,'DSBUADQBZO');
if (_tracker.goon(ctl,ctrlValue)) {
w_ASOT2=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('DSBUADQBZO',0);
if (l_bResult) {
l_bResult=Link_DSBUADQBZO(kmode);
if ( ! (l_bResult)) {
w_ASOT2=HtW('','C');
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
function Set_DASOT3(ctrlValue,kmode,e) {
if (Ne(w_DASOT3,ctrlValue)) {
var ctl = _GetCtl(e,'YMUIBONOPY');
if (_tracker.goon(ctl,ctrlValue)) {
w_DASOT3=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YMUIBONOPY',0);
if (l_bResult) {
l_bResult=Link_YMUIBONOPY(kmode);
if ( ! (l_bResult)) {
w_DASOT3=HtW('','C');
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
function Set_ASOT3(ctrlValue,kmode,e) {
if (Ne(w_ASOT3,ctrlValue)) {
var ctl = _GetCtl(e,'YFLBURGYJF');
if (_tracker.goon(ctl,ctrlValue)) {
w_ASOT3=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YFLBURGYJF',0);
if (l_bResult) {
l_bResult=Link_YFLBURGYJF(kmode);
if ( ! (l_bResult)) {
w_ASOT3=HtW('','C');
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
function Set_DASOT4(ctrlValue,kmode,e) {
if (Ne(w_DASOT4,ctrlValue)) {
var ctl = _GetCtl(e,'CZWHSOLRJS');
if (_tracker.goon(ctl,ctrlValue)) {
w_DASOT4=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CZWHSOLRJS',0);
if (l_bResult) {
l_bResult=Link_CZWHSOLRJS(kmode);
if ( ! (l_bResult)) {
w_DASOT4=HtW('','C');
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
function Set_ASOT4(ctrlValue,kmode,e) {
if (Ne(w_ASOT4,ctrlValue)) {
var ctl = _GetCtl(e,'CQDPGDHEVA');
if (_tracker.goon(ctl,ctrlValue)) {
w_ASOT4=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CQDPGDHEVA',0);
if (l_bResult) {
l_bResult=Link_CQDPGDHEVA(kmode);
if ( ! (l_bResult)) {
w_ASOT4=HtW('','C');
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
function Set_DASOT5(ctrlValue,kmode,e) {
if (Ne(w_DASOT5,ctrlValue)) {
var ctl = _GetCtl(e,'EVMGYBVTME');
if (_tracker.goon(ctl,ctrlValue)) {
w_DASOT5=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('EVMGYBVTME',0);
if (l_bResult) {
l_bResult=Link_EVMGYBVTME(kmode);
if ( ! (l_bResult)) {
w_DASOT5=HtW('','C');
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
function Set_ASOT5(ctrlValue,kmode,e) {
if (Ne(w_ASOT5,ctrlValue)) {
var ctl = _GetCtl(e,'YCLLVDJDPC');
if (_tracker.goon(ctl,ctrlValue)) {
w_ASOT5=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YCLLVDJDPC',0);
if (l_bResult) {
l_bResult=Link_YCLLVDJDPC(kmode);
if ( ! (l_bResult)) {
w_ASOT5=HtW('','C');
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
function Set_DASOT6(ctrlValue,kmode,e) {
if (Ne(w_DASOT6,ctrlValue)) {
var ctl = _GetCtl(e,'MWJSVBWARF');
if (_tracker.goon(ctl,ctrlValue)) {
w_DASOT6=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MWJSVBWARF',0);
if (l_bResult) {
l_bResult=Link_MWJSVBWARF(kmode);
if ( ! (l_bResult)) {
w_DASOT6=HtW('','C');
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
function Set_ASOT6(ctrlValue,kmode,e) {
if (Ne(w_ASOT6,ctrlValue)) {
var ctl = _GetCtl(e,'AKTWQWJXMU');
if (_tracker.goon(ctl,ctrlValue)) {
w_ASOT6=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('AKTWQWJXMU',0);
if (l_bResult) {
l_bResult=Link_AKTWQWJXMU(kmode);
if ( ! (l_bResult)) {
w_ASOT6=HtW('','C');
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
function Set_DASOT7(ctrlValue,kmode,e) {
if (Ne(w_DASOT7,ctrlValue)) {
var ctl = _GetCtl(e,'HGBIEMZYHZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_DASOT7=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HGBIEMZYHZ',0);
if (l_bResult) {
l_bResult=Link_HGBIEMZYHZ(kmode);
if ( ! (l_bResult)) {
w_DASOT7=HtW('','C');
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
function Set_ASOT7(ctrlValue,kmode,e) {
if (Ne(w_ASOT7,ctrlValue)) {
var ctl = _GetCtl(e,'JIXSOXOUMP');
if (_tracker.goon(ctl,ctrlValue)) {
w_ASOT7=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('JIXSOXOUMP',0);
if (l_bResult) {
l_bResult=Link_JIXSOXOUMP(kmode);
if ( ! (l_bResult)) {
w_ASOT7=HtW('','C');
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
function Set_DASOT8(ctrlValue,kmode,e) {
if (Ne(w_DASOT8,ctrlValue)) {
var ctl = _GetCtl(e,'NHXQYOJWPY');
if (_tracker.goon(ctl,ctrlValue)) {
w_DASOT8=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NHXQYOJWPY',0);
if (l_bResult) {
l_bResult=Link_NHXQYOJWPY(kmode);
if ( ! (l_bResult)) {
w_DASOT8=HtW('','C');
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
function Set_DAATE3(ctrlValue,kmode,e) {
if (Ne(w_DAATE3,ctrlValue)) {
var ctl = _GetCtl(e,'EBJQOWGCVT');
if (_tracker.goon(ctl,ctrlValue)) {
w_DAATE3=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('EBJQOWGCVT',0);
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
function Set_AATE2(ctrlValue,kmode,e) {
if (Ne(w_AATE2,ctrlValue)) {
var ctl = _GetCtl(e,'HRVUSTIUAW');
if (_tracker.goon(ctl,ctrlValue)) {
w_AATE2=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HRVUSTIUAW',0);
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
function Set_DASOT11(ctrlValue,kmode,e) {
if (Ne(w_DASOT11,ctrlValue)) {
var ctl = _GetCtl(e,'LXNKGCWVDI');
if (_tracker.goon(ctl,ctrlValue)) {
w_DASOT11=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('LXNKGCWVDI',0);
if (l_bResult) {
l_bResult=Link_LXNKGCWVDI(kmode);
if ( ! (l_bResult)) {
w_DASOT11=HtW('','C');
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
function Set_ASOT11(ctrlValue,kmode,e) {
if (Ne(w_ASOT11,ctrlValue)) {
var ctl = _GetCtl(e,'QYOHOTJSEN');
if (_tracker.goon(ctl,ctrlValue)) {
w_ASOT11=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QYOHOTJSEN',0);
if (l_bResult) {
l_bResult=Link_QYOHOTJSEN(kmode);
if ( ! (l_bResult)) {
w_ASOT11=HtW('','C');
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
function Set_ASOT10(ctrlValue,kmode,e) {
if (Ne(w_ASOT10,ctrlValue)) {
var ctl = _GetCtl(e,'ESIHSDXQVO');
if (_tracker.goon(ctl,ctrlValue)) {
w_ASOT10=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ESIHSDXQVO',0);
if (l_bResult) {
l_bResult=Link_ESIHSDXQVO(kmode);
if ( ! (l_bResult)) {
w_ASOT10=HtW('','C');
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
function Set_DASOT12(ctrlValue,kmode,e) {
if (Ne(w_DASOT12,ctrlValue)) {
var ctl = _GetCtl(e,'AWBDLKZHRC');
if (_tracker.goon(ctl,ctrlValue)) {
w_DASOT12=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('AWBDLKZHRC',0);
if (l_bResult) {
l_bResult=Link_AWBDLKZHRC(kmode);
if ( ! (l_bResult)) {
w_DASOT12=HtW('','C');
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
function Set_DAATE2(ctrlValue,kmode,e) {
if (Ne(w_DAATE2,ctrlValue)) {
var ctl = _GetCtl(e,'YMLTCQOYQA');
if (_tracker.goon(ctl,ctrlValue)) {
w_DAATE2=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YMLTCQOYQA',0);
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
function Set_ASOT12(ctrlValue,kmode,e) {
if (Ne(w_ASOT12,ctrlValue)) {
var ctl = _GetCtl(e,'AZBXLFMDVT');
if (_tracker.goon(ctl,ctrlValue)) {
w_ASOT12=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('AZBXLFMDVT',0);
if (l_bResult) {
l_bResult=Link_AZBXLFMDVT(kmode);
if ( ! (l_bResult)) {
w_ASOT12=HtW('','C');
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
function Link_BMLJXZOHDR(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_DAGRU1);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('RAMGRU',w_DAGRU1,3,0);
l_Appl.SetFields('RAMGRU,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbramgru');
l_Appl.SetID('BMLJXZOHDR');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_DAGRU1=l_Appl.GetStringValue('RAMGRU',3,0);
w_descg1=l_Appl.GetStringValue('DESCRI',70,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_BMLJXZOHDR_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_BMLJXZOHDR';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_BMLJXZOHDR();
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
function Link_BMLJXZOHDR_Blank() {
w_DAGRU1='';
w_descg1='';
}
function LOpt_BMLJXZOHDR() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbramgru','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('RAMGRU','C'));
l_oWv.setValue('LinkedField',WtA('RAMGRU','C'));
l_oWv.setValue('UID',WtA('BMLJXZOHDR','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['BMLJXZOHDR'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('117931111'),'C'));
return l_oWv;
}
function Link_PIMPFADLTV(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_AGRU1);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('RAMGRU',w_AGRU1,3,0);
l_Appl.SetFields('RAMGRU,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbramgru');
l_Appl.SetID('PIMPFADLTV');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_AGRU1=l_Appl.GetStringValue('RAMGRU',3,0);
w_descg2=l_Appl.GetStringValue('DESCRI',70,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_PIMPFADLTV_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_PIMPFADLTV';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_PIMPFADLTV();
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
function Link_PIMPFADLTV_Blank() {
w_AGRU1='';
w_descg2='';
}
function LOpt_PIMPFADLTV() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbramgru','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('RAMGRU','C'));
l_oWv.setValue('LinkedField',WtA('RAMGRU','C'));
l_oWv.setValue('UID',WtA('PIMPFADLTV','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['PIMPFADLTV'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('117931111'),'C'));
return l_oWv;
}
function Link_NFMNJIJKQG(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_DAGRU2);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('RAMGRU',w_DAGRU2,3,0);
l_Appl.SetFields('RAMGRU,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbramgru');
l_Appl.SetID('NFMNJIJKQG');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_DAGRU2=l_Appl.GetStringValue('RAMGRU',3,0);
w_descg3=l_Appl.GetStringValue('DESCRI',70,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_NFMNJIJKQG_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_NFMNJIJKQG';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_NFMNJIJKQG();
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
function Link_NFMNJIJKQG_Blank() {
w_DAGRU2='';
w_descg3='';
}
function LOpt_NFMNJIJKQG() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbramgru','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('RAMGRU','C'));
l_oWv.setValue('LinkedField',WtA('RAMGRU','C'));
l_oWv.setValue('UID',WtA('NFMNJIJKQG','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['NFMNJIJKQG'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('117931111'),'C'));
return l_oWv;
}
function Link_EGVTWLPYYK(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_AGRU2);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('RAMGRU',w_AGRU2,3,0);
l_Appl.SetFields('RAMGRU,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbramgru');
l_Appl.SetID('EGVTWLPYYK');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_AGRU2=l_Appl.GetStringValue('RAMGRU',3,0);
w_descg4=l_Appl.GetStringValue('DESCRI',70,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_EGVTWLPYYK_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_EGVTWLPYYK';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_EGVTWLPYYK();
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
function Link_EGVTWLPYYK_Blank() {
w_AGRU2='';
w_descg4='';
}
function LOpt_EGVTWLPYYK() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbramgru','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('RAMGRU','C'));
l_oWv.setValue('LinkedField',WtA('RAMGRU','C'));
l_oWv.setValue('UID',WtA('EGVTWLPYYK','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['EGVTWLPYYK'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('117931111'),'C'));
return l_oWv;
}
function Link_PBXUYJXCDV(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_DAGRU3);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('RAMGRU',w_DAGRU3,3,0);
l_Appl.SetFields('RAMGRU,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbramgru');
l_Appl.SetID('PBXUYJXCDV');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_DAGRU3=l_Appl.GetStringValue('RAMGRU',3,0);
w_descg5=l_Appl.GetStringValue('DESCRI',70,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_PBXUYJXCDV_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_PBXUYJXCDV';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_PBXUYJXCDV();
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
function Link_PBXUYJXCDV_Blank() {
w_DAGRU3='';
w_descg5='';
}
function LOpt_PBXUYJXCDV() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbramgru','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('RAMGRU','C'));
l_oWv.setValue('LinkedField',WtA('RAMGRU','C'));
l_oWv.setValue('UID',WtA('PBXUYJXCDV','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['PBXUYJXCDV'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('117931111'),'C'));
return l_oWv;
}
function Link_LKRRMRMXCU(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_AGRU3);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('RAMGRU',w_AGRU3,3,0);
l_Appl.SetFields('RAMGRU,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbramgru');
l_Appl.SetID('LKRRMRMXCU');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_AGRU3=l_Appl.GetStringValue('RAMGRU',3,0);
w_descg6=l_Appl.GetStringValue('DESCRI',70,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_LKRRMRMXCU_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_LKRRMRMXCU';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_LKRRMRMXCU();
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
function Link_LKRRMRMXCU_Blank() {
w_AGRU3='';
w_descg6='';
}
function LOpt_LKRRMRMXCU() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbramgru','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('RAMGRU','C'));
l_oWv.setValue('LinkedField',WtA('RAMGRU','C'));
l_oWv.setValue('UID',WtA('LKRRMRMXCU','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['LKRRMRMXCU'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('117931111'),'C'));
return l_oWv;
}
function Link_NQYJKRPMAY(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_DAGRU4);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('RAMGRU',w_DAGRU4,3,0);
l_Appl.SetFields('RAMGRU,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbramgru');
l_Appl.SetID('NQYJKRPMAY');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_DAGRU4=l_Appl.GetStringValue('RAMGRU',3,0);
w_descg7=l_Appl.GetStringValue('DESCRI',70,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_NQYJKRPMAY_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_NQYJKRPMAY';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_NQYJKRPMAY();
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
function Link_NQYJKRPMAY_Blank() {
w_DAGRU4='';
w_descg7='';
}
function LOpt_NQYJKRPMAY() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbramgru','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('RAMGRU','C'));
l_oWv.setValue('LinkedField',WtA('RAMGRU','C'));
l_oWv.setValue('UID',WtA('NQYJKRPMAY','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['NQYJKRPMAY'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('117931111'),'C'));
return l_oWv;
}
function Link_XLQJSGTFOG(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_AGRU4);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('RAMGRU',w_AGRU4,3,0);
l_Appl.SetFields('RAMGRU,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbramgru');
l_Appl.SetID('XLQJSGTFOG');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_AGRU4=l_Appl.GetStringValue('RAMGRU',3,0);
w_descg8=l_Appl.GetStringValue('DESCRI',70,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_XLQJSGTFOG_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_XLQJSGTFOG';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_XLQJSGTFOG();
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
function Link_XLQJSGTFOG_Blank() {
w_AGRU4='';
w_descg8='';
}
function LOpt_XLQJSGTFOG() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbramgru','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('RAMGRU','C'));
l_oWv.setValue('LinkedField',WtA('RAMGRU','C'));
l_oWv.setValue('UID',WtA('XLQJSGTFOG','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['XLQJSGTFOG'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('117931111'),'C'));
return l_oWv;
}
function Link_VVLLCWNYJU(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_DAGRU5);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('RAMGRU',w_DAGRU5,3,0);
l_Appl.SetFields('RAMGRU,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbramgru');
l_Appl.SetID('VVLLCWNYJU');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_DAGRU5=l_Appl.GetStringValue('RAMGRU',3,0);
w_descg9=l_Appl.GetStringValue('DESCRI',70,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_VVLLCWNYJU_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_VVLLCWNYJU';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_VVLLCWNYJU();
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
function Link_VVLLCWNYJU_Blank() {
w_DAGRU5='';
w_descg9='';
}
function LOpt_VVLLCWNYJU() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbramgru','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('RAMGRU','C'));
l_oWv.setValue('LinkedField',WtA('RAMGRU','C'));
l_oWv.setValue('UID',WtA('VVLLCWNYJU','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['VVLLCWNYJU'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('117931111'),'C'));
return l_oWv;
}
function Link_GPJQCCUFYH(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_AGRU5);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('RAMGRU',w_AGRU5,3,0);
l_Appl.SetFields('RAMGRU,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbramgru');
l_Appl.SetID('GPJQCCUFYH');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_AGRU5=l_Appl.GetStringValue('RAMGRU',3,0);
w_descg10=l_Appl.GetStringValue('DESCRI',70,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_GPJQCCUFYH_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_GPJQCCUFYH';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_GPJQCCUFYH();
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
function Link_GPJQCCUFYH_Blank() {
w_AGRU5='';
w_descg10='';
}
function LOpt_GPJQCCUFYH() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbramgru','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('RAMGRU','C'));
l_oWv.setValue('LinkedField',WtA('RAMGRU','C'));
l_oWv.setValue('UID',WtA('GPJQCCUFYH','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['GPJQCCUFYH'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('117931111'),'C'));
return l_oWv;
}
function Link_OWCFHGKVPB(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_DAGRU6);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('RAMGRU',w_DAGRU6,3,0);
l_Appl.SetFields('RAMGRU,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbramgru');
l_Appl.SetID('OWCFHGKVPB');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_DAGRU6=l_Appl.GetStringValue('RAMGRU',3,0);
w_descg11=l_Appl.GetStringValue('DESCRI',70,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_OWCFHGKVPB_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_OWCFHGKVPB';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_OWCFHGKVPB();
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
function Link_OWCFHGKVPB_Blank() {
w_DAGRU6='';
w_descg11='';
}
function LOpt_OWCFHGKVPB() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbramgru','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('RAMGRU','C'));
l_oWv.setValue('LinkedField',WtA('RAMGRU','C'));
l_oWv.setValue('UID',WtA('OWCFHGKVPB','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['OWCFHGKVPB'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('117931111'),'C'));
return l_oWv;
}
function Link_ZDTAXGFPRF(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_AGRU6);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('RAMGRU',w_AGRU6,3,0);
l_Appl.SetFields('RAMGRU,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbramgru');
l_Appl.SetID('ZDTAXGFPRF');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_AGRU6=l_Appl.GetStringValue('RAMGRU',3,0);
w_descg12=l_Appl.GetStringValue('DESCRI',70,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_ZDTAXGFPRF_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_ZDTAXGFPRF';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_ZDTAXGFPRF();
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
function Link_ZDTAXGFPRF_Blank() {
w_AGRU6='';
w_descg12='';
}
function LOpt_ZDTAXGFPRF() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbramgru','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('RAMGRU','C'));
l_oWv.setValue('LinkedField',WtA('RAMGRU','C'));
l_oWv.setValue('UID',WtA('ZDTAXGFPRF','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['ZDTAXGFPRF'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('117931111'),'C'));
return l_oWv;
}
function Link_QSAEKELBZF(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_DASOT1);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('SOTGRU',w_DASOT1,3,0);
l_Appl.SetFields('SOTGRU,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbstgru');
l_Appl.SetID('QSAEKELBZF');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_DASOT1=l_Appl.GetStringValue('SOTGRU',3,0);
w_descsg1=l_Appl.GetStringValue('DESCRI',60,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_QSAEKELBZF_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_QSAEKELBZF';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_QSAEKELBZF();
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
function Link_QSAEKELBZF_Blank() {
w_DASOT1='';
w_descsg1='';
}
function LOpt_QSAEKELBZF() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstgru','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('SOTGRU','C'));
l_oWv.setValue('LinkedField',WtA('SOTGRU','C'));
l_oWv.setValue('UID',WtA('QSAEKELBZF','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['QSAEKELBZF'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('10924374093'),'C'));
return l_oWv;
}
function Link_TXKEYYFXPE(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_ASOT1);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('SOTGRU',w_ASOT1,3,0);
l_Appl.SetFields('SOTGRU,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbstgru');
l_Appl.SetID('TXKEYYFXPE');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_ASOT1=l_Appl.GetStringValue('SOTGRU',3,0);
w_descsg2=l_Appl.GetStringValue('DESCRI',60,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_TXKEYYFXPE_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_TXKEYYFXPE';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_TXKEYYFXPE();
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
function Link_TXKEYYFXPE_Blank() {
w_ASOT1='';
w_descsg2='';
}
function LOpt_TXKEYYFXPE() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstgru','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('SOTGRU','C'));
l_oWv.setValue('LinkedField',WtA('SOTGRU','C'));
l_oWv.setValue('UID',WtA('TXKEYYFXPE','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['TXKEYYFXPE'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('10924374093'),'C'));
return l_oWv;
}
function Link_XJEPLEAUZI(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_DASOT2);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('SOTGRU',w_DASOT2,3,0);
l_Appl.SetFields('SOTGRU,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbstgru');
l_Appl.SetID('XJEPLEAUZI');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_DASOT2=l_Appl.GetStringValue('SOTGRU',3,0);
w_descsg3=l_Appl.GetStringValue('DESCRI',60,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_XJEPLEAUZI_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_XJEPLEAUZI';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_XJEPLEAUZI();
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
function Link_XJEPLEAUZI_Blank() {
w_DASOT2='';
w_descsg3='';
}
function LOpt_XJEPLEAUZI() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstgru','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('SOTGRU','C'));
l_oWv.setValue('LinkedField',WtA('SOTGRU','C'));
l_oWv.setValue('UID',WtA('XJEPLEAUZI','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['XJEPLEAUZI'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('10924374093'),'C'));
return l_oWv;
}
function Link_DSBUADQBZO(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_ASOT2);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('SOTGRU',w_ASOT2,3,0);
l_Appl.SetFields('SOTGRU,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbstgru');
l_Appl.SetID('DSBUADQBZO');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_ASOT2=l_Appl.GetStringValue('SOTGRU',3,0);
w_descsg4=l_Appl.GetStringValue('DESCRI',60,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_DSBUADQBZO_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_DSBUADQBZO';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_DSBUADQBZO();
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
function Link_DSBUADQBZO_Blank() {
w_ASOT2='';
w_descsg4='';
}
function LOpt_DSBUADQBZO() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstgru','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('SOTGRU','C'));
l_oWv.setValue('LinkedField',WtA('SOTGRU','C'));
l_oWv.setValue('UID',WtA('DSBUADQBZO','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['DSBUADQBZO'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('10924374093'),'C'));
return l_oWv;
}
function Link_YMUIBONOPY(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_DASOT3);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('SOTGRU',w_DASOT3,3,0);
l_Appl.SetFields('SOTGRU,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbstgru');
l_Appl.SetID('YMUIBONOPY');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_DASOT3=l_Appl.GetStringValue('SOTGRU',3,0);
w_descsg5=l_Appl.GetStringValue('DESCRI',60,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_YMUIBONOPY_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_YMUIBONOPY';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_YMUIBONOPY();
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
function Link_YMUIBONOPY_Blank() {
w_DASOT3='';
w_descsg5='';
}
function LOpt_YMUIBONOPY() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstgru','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('SOTGRU','C'));
l_oWv.setValue('LinkedField',WtA('SOTGRU','C'));
l_oWv.setValue('UID',WtA('YMUIBONOPY','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['YMUIBONOPY'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('10924374093'),'C'));
return l_oWv;
}
function Link_YFLBURGYJF(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_ASOT3);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('SOTGRU',w_ASOT3,3,0);
l_Appl.SetFields('SOTGRU,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbstgru');
l_Appl.SetID('YFLBURGYJF');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_ASOT3=l_Appl.GetStringValue('SOTGRU',3,0);
w_descsg6=l_Appl.GetStringValue('DESCRI',60,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_YFLBURGYJF_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_YFLBURGYJF';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_YFLBURGYJF();
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
function Link_YFLBURGYJF_Blank() {
w_ASOT3='';
w_descsg6='';
}
function LOpt_YFLBURGYJF() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstgru','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('SOTGRU','C'));
l_oWv.setValue('LinkedField',WtA('SOTGRU','C'));
l_oWv.setValue('UID',WtA('YFLBURGYJF','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['YFLBURGYJF'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('10924374093'),'C'));
return l_oWv;
}
function Link_CZWHSOLRJS(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_DASOT4);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('SOTGRU',w_DASOT4,3,0);
l_Appl.SetFields('SOTGRU,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbstgru');
l_Appl.SetID('CZWHSOLRJS');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_DASOT4=l_Appl.GetStringValue('SOTGRU',3,0);
w_descsg7=l_Appl.GetStringValue('DESCRI',60,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_CZWHSOLRJS_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_CZWHSOLRJS';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_CZWHSOLRJS();
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
function Link_CZWHSOLRJS_Blank() {
w_DASOT4='';
w_descsg7='';
}
function LOpt_CZWHSOLRJS() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstgru','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('SOTGRU','C'));
l_oWv.setValue('LinkedField',WtA('SOTGRU','C'));
l_oWv.setValue('UID',WtA('CZWHSOLRJS','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['CZWHSOLRJS'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('10924374093'),'C'));
return l_oWv;
}
function Link_CQDPGDHEVA(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_ASOT4);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('SOTGRU',w_ASOT4,3,0);
l_Appl.SetFields('SOTGRU,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbstgru');
l_Appl.SetID('CQDPGDHEVA');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_ASOT4=l_Appl.GetStringValue('SOTGRU',3,0);
w_descsg8=l_Appl.GetStringValue('DESCRI',60,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_CQDPGDHEVA_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_CQDPGDHEVA';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_CQDPGDHEVA();
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
function Link_CQDPGDHEVA_Blank() {
w_ASOT4='';
w_descsg8='';
}
function LOpt_CQDPGDHEVA() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstgru','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('SOTGRU','C'));
l_oWv.setValue('LinkedField',WtA('SOTGRU','C'));
l_oWv.setValue('UID',WtA('CQDPGDHEVA','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['CQDPGDHEVA'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('10924374093'),'C'));
return l_oWv;
}
function Link_EVMGYBVTME(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_DASOT5);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('SOTGRU',w_DASOT5,3,0);
l_Appl.SetFields('SOTGRU,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbstgru');
l_Appl.SetID('EVMGYBVTME');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_DASOT5=l_Appl.GetStringValue('SOTGRU',3,0);
w_descsg9=l_Appl.GetStringValue('DESCRI',60,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_EVMGYBVTME_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_EVMGYBVTME';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_EVMGYBVTME();
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
function Link_EVMGYBVTME_Blank() {
w_DASOT5='';
w_descsg9='';
}
function LOpt_EVMGYBVTME() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstgru','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('SOTGRU','C'));
l_oWv.setValue('LinkedField',WtA('SOTGRU','C'));
l_oWv.setValue('UID',WtA('EVMGYBVTME','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['EVMGYBVTME'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('10924374093'),'C'));
return l_oWv;
}
function Link_YCLLVDJDPC(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_ASOT5);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('SOTGRU',w_ASOT5,3,0);
l_Appl.SetFields('SOTGRU,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbstgru');
l_Appl.SetID('YCLLVDJDPC');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_ASOT5=l_Appl.GetStringValue('SOTGRU',3,0);
w_descsg10=l_Appl.GetStringValue('DESCRI',60,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_YCLLVDJDPC_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_YCLLVDJDPC';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_YCLLVDJDPC();
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
function Link_YCLLVDJDPC_Blank() {
w_ASOT5='';
w_descsg10='';
}
function LOpt_YCLLVDJDPC() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstgru','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('SOTGRU','C'));
l_oWv.setValue('LinkedField',WtA('SOTGRU','C'));
l_oWv.setValue('UID',WtA('YCLLVDJDPC','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['YCLLVDJDPC'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('10924374093'),'C'));
return l_oWv;
}
function Link_MWJSVBWARF(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_DASOT6);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('SOTGRU',w_DASOT6,3,0);
l_Appl.SetFields('SOTGRU,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbstgru');
l_Appl.SetID('MWJSVBWARF');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_DASOT6=l_Appl.GetStringValue('SOTGRU',3,0);
w_descsg11=l_Appl.GetStringValue('DESCRI',60,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_MWJSVBWARF_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_MWJSVBWARF';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_MWJSVBWARF();
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
function Link_MWJSVBWARF_Blank() {
w_DASOT6='';
w_descsg11='';
}
function LOpt_MWJSVBWARF() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstgru','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('SOTGRU','C'));
l_oWv.setValue('LinkedField',WtA('SOTGRU','C'));
l_oWv.setValue('UID',WtA('MWJSVBWARF','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['MWJSVBWARF'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('10924374093'),'C'));
return l_oWv;
}
function Link_AKTWQWJXMU(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_ASOT6);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('SOTGRU',w_ASOT6,3,0);
l_Appl.SetFields('SOTGRU,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbstgru');
l_Appl.SetID('AKTWQWJXMU');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_ASOT6=l_Appl.GetStringValue('SOTGRU',3,0);
w_descsg12=l_Appl.GetStringValue('DESCRI',60,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_AKTWQWJXMU_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_AKTWQWJXMU';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_AKTWQWJXMU();
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
function Link_AKTWQWJXMU_Blank() {
w_ASOT6='';
w_descsg12='';
}
function LOpt_AKTWQWJXMU() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstgru','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('SOTGRU','C'));
l_oWv.setValue('LinkedField',WtA('SOTGRU','C'));
l_oWv.setValue('UID',WtA('AKTWQWJXMU','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['AKTWQWJXMU'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('10924374093'),'C'));
return l_oWv;
}
function Link_HGBIEMZYHZ(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_DASOT7);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('SOTGRU',w_DASOT7,3,0);
l_Appl.SetFields('SOTGRU,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbstgru');
l_Appl.SetID('HGBIEMZYHZ');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_DASOT7=l_Appl.GetStringValue('SOTGRU',3,0);
w_descsg13=l_Appl.GetStringValue('DESCRI',60,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_HGBIEMZYHZ_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_HGBIEMZYHZ';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_HGBIEMZYHZ();
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
function Link_HGBIEMZYHZ_Blank() {
w_DASOT7='';
w_descsg13='';
}
function LOpt_HGBIEMZYHZ() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstgru','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('SOTGRU','C'));
l_oWv.setValue('LinkedField',WtA('SOTGRU','C'));
l_oWv.setValue('UID',WtA('HGBIEMZYHZ','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['HGBIEMZYHZ'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('10924374093'),'C'));
return l_oWv;
}
function Link_JIXSOXOUMP(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_ASOT7);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('SOTGRU',w_ASOT7,3,0);
l_Appl.SetFields('SOTGRU,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbstgru');
l_Appl.SetID('JIXSOXOUMP');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_ASOT7=l_Appl.GetStringValue('SOTGRU',3,0);
w_descsg14=l_Appl.GetStringValue('DESCRI',60,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_JIXSOXOUMP_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_JIXSOXOUMP';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_JIXSOXOUMP();
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
function Link_JIXSOXOUMP_Blank() {
w_ASOT7='';
w_descsg14='';
}
function LOpt_JIXSOXOUMP() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstgru','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('SOTGRU','C'));
l_oWv.setValue('LinkedField',WtA('SOTGRU','C'));
l_oWv.setValue('UID',WtA('JIXSOXOUMP','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['JIXSOXOUMP'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('10924374093'),'C'));
return l_oWv;
}
function Link_NHXQYOJWPY(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_DASOT8);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('SOTGRU',w_DASOT8,3,0);
l_Appl.SetFields('SOTGRU,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbstgru');
l_Appl.SetID('NHXQYOJWPY');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_DASOT8=l_Appl.GetStringValue('SOTGRU',3,0);
w_descsg15=l_Appl.GetStringValue('DESCRI',60,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_NHXQYOJWPY_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_NHXQYOJWPY';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_NHXQYOJWPY();
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
function Link_NHXQYOJWPY_Blank() {
w_DASOT8='';
w_descsg15='';
}
function LOpt_NHXQYOJWPY() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstgru','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('SOTGRU','C'));
l_oWv.setValue('LinkedField',WtA('SOTGRU','C'));
l_oWv.setValue('UID',WtA('NHXQYOJWPY','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['NHXQYOJWPY'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('10924374093'),'C'));
return l_oWv;
}
function Link_FQHPMPIEFY(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_ASOT8);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('SOTGRU',w_ASOT8,3,0);
l_Appl.SetFields('SOTGRU,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbstgru');
l_Appl.SetID('FQHPMPIEFY');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_ASOT8=l_Appl.GetStringValue('SOTGRU',3,0);
w_descsg16=l_Appl.GetStringValue('DESCRI',60,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_FQHPMPIEFY_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_FQHPMPIEFY';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_FQHPMPIEFY();
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
function Link_FQHPMPIEFY_Blank() {
w_ASOT8='';
w_descsg16='';
}
function LOpt_FQHPMPIEFY() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstgru','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('SOTGRU','C'));
l_oWv.setValue('LinkedField',WtA('SOTGRU','C'));
l_oWv.setValue('UID',WtA('FQHPMPIEFY','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['FQHPMPIEFY'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('10924374093'),'C'));
return l_oWv;
}
function Link_KGVPSOERYT(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_DASOT9);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('SOTGRU',w_DASOT9,3,0);
l_Appl.SetFields('SOTGRU,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbstgru');
l_Appl.SetID('KGVPSOERYT');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_DASOT9=l_Appl.GetStringValue('SOTGRU',3,0);
w_descsg17=l_Appl.GetStringValue('DESCRI',60,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_KGVPSOERYT_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_KGVPSOERYT';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_KGVPSOERYT();
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
function Link_KGVPSOERYT_Blank() {
w_DASOT9='';
w_descsg17='';
}
function LOpt_KGVPSOERYT() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstgru','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('SOTGRU','C'));
l_oWv.setValue('LinkedField',WtA('SOTGRU','C'));
l_oWv.setValue('UID',WtA('KGVPSOERYT','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['KGVPSOERYT'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('10924374093'),'C'));
return l_oWv;
}
function Link_GWWXIEOXZQ(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_ASOT9);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('SOTGRU',w_ASOT9,3,0);
l_Appl.SetFields('SOTGRU,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbstgru');
l_Appl.SetID('GWWXIEOXZQ');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_ASOT9=l_Appl.GetStringValue('SOTGRU',3,0);
w_descsg18=l_Appl.GetStringValue('DESCRI',60,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_GWWXIEOXZQ_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_GWWXIEOXZQ';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_GWWXIEOXZQ();
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
function Link_GWWXIEOXZQ_Blank() {
w_ASOT9='';
w_descsg18='';
}
function LOpt_GWWXIEOXZQ() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstgru','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('SOTGRU','C'));
l_oWv.setValue('LinkedField',WtA('SOTGRU','C'));
l_oWv.setValue('UID',WtA('GWWXIEOXZQ','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['GWWXIEOXZQ'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('10924374093'),'C'));
return l_oWv;
}
function Link_TWZIVFFWLR(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_DASOT10);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('SOTGRU',w_DASOT10,3,0);
l_Appl.SetFields('SOTGRU,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbstgru');
l_Appl.SetID('TWZIVFFWLR');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_DASOT10=l_Appl.GetStringValue('SOTGRU',3,0);
w_descsg19=l_Appl.GetStringValue('DESCRI',60,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_TWZIVFFWLR_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_TWZIVFFWLR';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_TWZIVFFWLR();
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
function Link_TWZIVFFWLR_Blank() {
w_DASOT10='';
w_descsg19='';
}
function LOpt_TWZIVFFWLR() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstgru','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('SOTGRU','C'));
l_oWv.setValue('LinkedField',WtA('SOTGRU','C'));
l_oWv.setValue('UID',WtA('TWZIVFFWLR','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['TWZIVFFWLR'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('10924374093'),'C'));
return l_oWv;
}
function Link_ESIHSDXQVO(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_ASOT10);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('SOTGRU',w_ASOT10,3,0);
l_Appl.SetFields('SOTGRU,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbstgru');
l_Appl.SetID('ESIHSDXQVO');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_ASOT10=l_Appl.GetStringValue('SOTGRU',3,0);
w_descsg20=l_Appl.GetStringValue('DESCRI',60,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_ESIHSDXQVO_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_ESIHSDXQVO';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_ESIHSDXQVO();
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
function Link_ESIHSDXQVO_Blank() {
w_ASOT10='';
w_descsg20='';
}
function LOpt_ESIHSDXQVO() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstgru','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('SOTGRU','C'));
l_oWv.setValue('LinkedField',WtA('SOTGRU','C'));
l_oWv.setValue('UID',WtA('ESIHSDXQVO','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['ESIHSDXQVO'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('10924374093'),'C'));
return l_oWv;
}
function Link_LXNKGCWVDI(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_DASOT11);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('SOTGRU',w_DASOT11,3,0);
l_Appl.SetFields('SOTGRU,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbstgru');
l_Appl.SetID('LXNKGCWVDI');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_DASOT11=l_Appl.GetStringValue('SOTGRU',3,0);
w_descsg21=l_Appl.GetStringValue('DESCRI',60,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_LXNKGCWVDI_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_LXNKGCWVDI';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_LXNKGCWVDI();
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
function Link_LXNKGCWVDI_Blank() {
w_DASOT11='';
w_descsg21='';
}
function LOpt_LXNKGCWVDI() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstgru','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('SOTGRU','C'));
l_oWv.setValue('LinkedField',WtA('SOTGRU','C'));
l_oWv.setValue('UID',WtA('LXNKGCWVDI','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['LXNKGCWVDI'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('10924374093'),'C'));
return l_oWv;
}
function Link_QYOHOTJSEN(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_ASOT11);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('SOTGRU',w_ASOT11,3,0);
l_Appl.SetFields('SOTGRU,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbstgru');
l_Appl.SetID('QYOHOTJSEN');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_ASOT11=l_Appl.GetStringValue('SOTGRU',3,0);
w_descsg22=l_Appl.GetStringValue('DESCRI',60,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_QYOHOTJSEN_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_QYOHOTJSEN';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_QYOHOTJSEN();
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
function Link_QYOHOTJSEN_Blank() {
w_ASOT11='';
w_descsg22='';
}
function LOpt_QYOHOTJSEN() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstgru','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('SOTGRU','C'));
l_oWv.setValue('LinkedField',WtA('SOTGRU','C'));
l_oWv.setValue('UID',WtA('QYOHOTJSEN','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['QYOHOTJSEN'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('10924374093'),'C'));
return l_oWv;
}
function Link_AWBDLKZHRC(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_DASOT12);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('SOTGRU',w_DASOT12,3,0);
l_Appl.SetFields('SOTGRU,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbstgru');
l_Appl.SetID('AWBDLKZHRC');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_DASOT12=l_Appl.GetStringValue('SOTGRU',3,0);
w_descsg23=l_Appl.GetStringValue('DESCRI',60,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_AWBDLKZHRC_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_AWBDLKZHRC';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_AWBDLKZHRC();
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
function Link_AWBDLKZHRC_Blank() {
w_DASOT12='';
w_descsg23='';
}
function LOpt_AWBDLKZHRC() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstgru','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('SOTGRU','C'));
l_oWv.setValue('LinkedField',WtA('SOTGRU','C'));
l_oWv.setValue('UID',WtA('AWBDLKZHRC','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['AWBDLKZHRC'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('10924374093'),'C'));
return l_oWv;
}
function Link_AZBXLFMDVT(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_ASOT12);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('SOTGRU',w_ASOT12,3,0);
l_Appl.SetFields('SOTGRU,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbstgru');
l_Appl.SetID('AZBXLFMDVT');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_ASOT12=l_Appl.GetStringValue('SOTGRU',3,0);
w_descsg24=l_Appl.GetStringValue('DESCRI',60,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_AZBXLFMDVT_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_AZBXLFMDVT';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_AZBXLFMDVT();
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
function Link_AZBXLFMDVT_Blank() {
w_ASOT12='';
w_descsg24='';
}
function LOpt_AZBXLFMDVT() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstgru','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('SOTGRU','C'));
l_oWv.setValue('LinkedField',WtA('SOTGRU','C'));
l_oWv.setValue('UID',WtA('AZBXLFMDVT','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['AZBXLFMDVT'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('10924374093'),'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'BMLJXZOHDR')) {
last_focused_comp=GetLastFocusedElementOfLink('BMLJXZOHDR');
function SetMethod_BMLJXZOHDR() {
Set_DAGRU1(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_BMLJXZOHDR();
} else {
setTimeout(SetMethod_BMLJXZOHDR,1);
}
bResult=true;
}
if (Eq(varName,'PIMPFADLTV')) {
last_focused_comp=GetLastFocusedElementOfLink('PIMPFADLTV');
function SetMethod_PIMPFADLTV() {
Set_AGRU1(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_PIMPFADLTV();
} else {
setTimeout(SetMethod_PIMPFADLTV,1);
}
bResult=true;
}
if (Eq(varName,'NFMNJIJKQG')) {
last_focused_comp=GetLastFocusedElementOfLink('NFMNJIJKQG');
function SetMethod_NFMNJIJKQG() {
Set_DAGRU2(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_NFMNJIJKQG();
} else {
setTimeout(SetMethod_NFMNJIJKQG,1);
}
bResult=true;
}
if (Eq(varName,'EGVTWLPYYK')) {
last_focused_comp=GetLastFocusedElementOfLink('EGVTWLPYYK');
function SetMethod_EGVTWLPYYK() {
Set_AGRU2(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_EGVTWLPYYK();
} else {
setTimeout(SetMethod_EGVTWLPYYK,1);
}
bResult=true;
}
if (Eq(varName,'PBXUYJXCDV')) {
last_focused_comp=GetLastFocusedElementOfLink('PBXUYJXCDV');
function SetMethod_PBXUYJXCDV() {
Set_DAGRU3(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_PBXUYJXCDV();
} else {
setTimeout(SetMethod_PBXUYJXCDV,1);
}
bResult=true;
}
if (Eq(varName,'LKRRMRMXCU')) {
last_focused_comp=GetLastFocusedElementOfLink('LKRRMRMXCU');
function SetMethod_LKRRMRMXCU() {
Set_AGRU3(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_LKRRMRMXCU();
} else {
setTimeout(SetMethod_LKRRMRMXCU,1);
}
bResult=true;
}
if (Eq(varName,'NQYJKRPMAY')) {
last_focused_comp=GetLastFocusedElementOfLink('NQYJKRPMAY');
function SetMethod_NQYJKRPMAY() {
Set_DAGRU4(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_NQYJKRPMAY();
} else {
setTimeout(SetMethod_NQYJKRPMAY,1);
}
bResult=true;
}
if (Eq(varName,'XLQJSGTFOG')) {
last_focused_comp=GetLastFocusedElementOfLink('XLQJSGTFOG');
function SetMethod_XLQJSGTFOG() {
Set_AGRU4(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_XLQJSGTFOG();
} else {
setTimeout(SetMethod_XLQJSGTFOG,1);
}
bResult=true;
}
if (Eq(varName,'VVLLCWNYJU')) {
last_focused_comp=GetLastFocusedElementOfLink('VVLLCWNYJU');
function SetMethod_VVLLCWNYJU() {
Set_DAGRU5(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_VVLLCWNYJU();
} else {
setTimeout(SetMethod_VVLLCWNYJU,1);
}
bResult=true;
}
if (Eq(varName,'GPJQCCUFYH')) {
last_focused_comp=GetLastFocusedElementOfLink('GPJQCCUFYH');
function SetMethod_GPJQCCUFYH() {
Set_AGRU5(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_GPJQCCUFYH();
} else {
setTimeout(SetMethod_GPJQCCUFYH,1);
}
bResult=true;
}
if (Eq(varName,'OWCFHGKVPB')) {
last_focused_comp=GetLastFocusedElementOfLink('OWCFHGKVPB');
function SetMethod_OWCFHGKVPB() {
Set_DAGRU6(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_OWCFHGKVPB();
} else {
setTimeout(SetMethod_OWCFHGKVPB,1);
}
bResult=true;
}
if (Eq(varName,'ZDTAXGFPRF')) {
last_focused_comp=GetLastFocusedElementOfLink('ZDTAXGFPRF');
function SetMethod_ZDTAXGFPRF() {
Set_AGRU6(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_ZDTAXGFPRF();
} else {
setTimeout(SetMethod_ZDTAXGFPRF,1);
}
bResult=true;
}
if (Eq(varName,'QSAEKELBZF')) {
last_focused_comp=GetLastFocusedElementOfLink('QSAEKELBZF');
function SetMethod_QSAEKELBZF() {
Set_DASOT1(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_QSAEKELBZF();
} else {
setTimeout(SetMethod_QSAEKELBZF,1);
}
bResult=true;
}
if (Eq(varName,'TXKEYYFXPE')) {
last_focused_comp=GetLastFocusedElementOfLink('TXKEYYFXPE');
function SetMethod_TXKEYYFXPE() {
Set_ASOT1(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_TXKEYYFXPE();
} else {
setTimeout(SetMethod_TXKEYYFXPE,1);
}
bResult=true;
}
if (Eq(varName,'XJEPLEAUZI')) {
last_focused_comp=GetLastFocusedElementOfLink('XJEPLEAUZI');
function SetMethod_XJEPLEAUZI() {
Set_DASOT2(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_XJEPLEAUZI();
} else {
setTimeout(SetMethod_XJEPLEAUZI,1);
}
bResult=true;
}
if (Eq(varName,'DSBUADQBZO')) {
last_focused_comp=GetLastFocusedElementOfLink('DSBUADQBZO');
function SetMethod_DSBUADQBZO() {
Set_ASOT2(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_DSBUADQBZO();
} else {
setTimeout(SetMethod_DSBUADQBZO,1);
}
bResult=true;
}
if (Eq(varName,'YMUIBONOPY')) {
last_focused_comp=GetLastFocusedElementOfLink('YMUIBONOPY');
function SetMethod_YMUIBONOPY() {
Set_DASOT3(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_YMUIBONOPY();
} else {
setTimeout(SetMethod_YMUIBONOPY,1);
}
bResult=true;
}
if (Eq(varName,'YFLBURGYJF')) {
last_focused_comp=GetLastFocusedElementOfLink('YFLBURGYJF');
function SetMethod_YFLBURGYJF() {
Set_ASOT3(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_YFLBURGYJF();
} else {
setTimeout(SetMethod_YFLBURGYJF,1);
}
bResult=true;
}
if (Eq(varName,'CZWHSOLRJS')) {
last_focused_comp=GetLastFocusedElementOfLink('CZWHSOLRJS');
function SetMethod_CZWHSOLRJS() {
Set_DASOT4(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_CZWHSOLRJS();
} else {
setTimeout(SetMethod_CZWHSOLRJS,1);
}
bResult=true;
}
if (Eq(varName,'CQDPGDHEVA')) {
last_focused_comp=GetLastFocusedElementOfLink('CQDPGDHEVA');
function SetMethod_CQDPGDHEVA() {
Set_ASOT4(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_CQDPGDHEVA();
} else {
setTimeout(SetMethod_CQDPGDHEVA,1);
}
bResult=true;
}
if (Eq(varName,'EVMGYBVTME')) {
last_focused_comp=GetLastFocusedElementOfLink('EVMGYBVTME');
function SetMethod_EVMGYBVTME() {
Set_DASOT5(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_EVMGYBVTME();
} else {
setTimeout(SetMethod_EVMGYBVTME,1);
}
bResult=true;
}
if (Eq(varName,'YCLLVDJDPC')) {
last_focused_comp=GetLastFocusedElementOfLink('YCLLVDJDPC');
function SetMethod_YCLLVDJDPC() {
Set_ASOT5(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_YCLLVDJDPC();
} else {
setTimeout(SetMethod_YCLLVDJDPC,1);
}
bResult=true;
}
if (Eq(varName,'MWJSVBWARF')) {
last_focused_comp=GetLastFocusedElementOfLink('MWJSVBWARF');
function SetMethod_MWJSVBWARF() {
Set_DASOT6(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_MWJSVBWARF();
} else {
setTimeout(SetMethod_MWJSVBWARF,1);
}
bResult=true;
}
if (Eq(varName,'AKTWQWJXMU')) {
last_focused_comp=GetLastFocusedElementOfLink('AKTWQWJXMU');
function SetMethod_AKTWQWJXMU() {
Set_ASOT6(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_AKTWQWJXMU();
} else {
setTimeout(SetMethod_AKTWQWJXMU,1);
}
bResult=true;
}
if (Eq(varName,'HGBIEMZYHZ')) {
last_focused_comp=GetLastFocusedElementOfLink('HGBIEMZYHZ');
function SetMethod_HGBIEMZYHZ() {
Set_DASOT7(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_HGBIEMZYHZ();
} else {
setTimeout(SetMethod_HGBIEMZYHZ,1);
}
bResult=true;
}
if (Eq(varName,'JIXSOXOUMP')) {
last_focused_comp=GetLastFocusedElementOfLink('JIXSOXOUMP');
function SetMethod_JIXSOXOUMP() {
Set_ASOT7(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_JIXSOXOUMP();
} else {
setTimeout(SetMethod_JIXSOXOUMP,1);
}
bResult=true;
}
if (Eq(varName,'NHXQYOJWPY')) {
last_focused_comp=GetLastFocusedElementOfLink('NHXQYOJWPY');
function SetMethod_NHXQYOJWPY() {
Set_DASOT8(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_NHXQYOJWPY();
} else {
setTimeout(SetMethod_NHXQYOJWPY,1);
}
bResult=true;
}
if (Eq(varName,'FQHPMPIEFY')) {
last_focused_comp=GetLastFocusedElementOfLink('FQHPMPIEFY');
function SetMethod_FQHPMPIEFY() {
Set_ASOT8(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_FQHPMPIEFY();
} else {
setTimeout(SetMethod_FQHPMPIEFY,1);
}
bResult=true;
}
if (Eq(varName,'KGVPSOERYT')) {
last_focused_comp=GetLastFocusedElementOfLink('KGVPSOERYT');
function SetMethod_KGVPSOERYT() {
Set_DASOT9(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_KGVPSOERYT();
} else {
setTimeout(SetMethod_KGVPSOERYT,1);
}
bResult=true;
}
if (Eq(varName,'GWWXIEOXZQ')) {
last_focused_comp=GetLastFocusedElementOfLink('GWWXIEOXZQ');
function SetMethod_GWWXIEOXZQ() {
Set_ASOT9(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_GWWXIEOXZQ();
} else {
setTimeout(SetMethod_GWWXIEOXZQ,1);
}
bResult=true;
}
if (Eq(varName,'TWZIVFFWLR')) {
last_focused_comp=GetLastFocusedElementOfLink('TWZIVFFWLR');
function SetMethod_TWZIVFFWLR() {
Set_DASOT10(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_TWZIVFFWLR();
} else {
setTimeout(SetMethod_TWZIVFFWLR,1);
}
bResult=true;
}
if (Eq(varName,'ESIHSDXQVO')) {
last_focused_comp=GetLastFocusedElementOfLink('ESIHSDXQVO');
function SetMethod_ESIHSDXQVO() {
Set_ASOT10(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_ESIHSDXQVO();
} else {
setTimeout(SetMethod_ESIHSDXQVO,1);
}
bResult=true;
}
if (Eq(varName,'LXNKGCWVDI')) {
last_focused_comp=GetLastFocusedElementOfLink('LXNKGCWVDI');
function SetMethod_LXNKGCWVDI() {
Set_DASOT11(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_LXNKGCWVDI();
} else {
setTimeout(SetMethod_LXNKGCWVDI,1);
}
bResult=true;
}
if (Eq(varName,'QYOHOTJSEN')) {
last_focused_comp=GetLastFocusedElementOfLink('QYOHOTJSEN');
function SetMethod_QYOHOTJSEN() {
Set_ASOT11(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_QYOHOTJSEN();
} else {
setTimeout(SetMethod_QYOHOTJSEN,1);
}
bResult=true;
}
if (Eq(varName,'AWBDLKZHRC')) {
last_focused_comp=GetLastFocusedElementOfLink('AWBDLKZHRC');
function SetMethod_AWBDLKZHRC() {
Set_DASOT12(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_AWBDLKZHRC();
} else {
setTimeout(SetMethod_AWBDLKZHRC,1);
}
bResult=true;
}
if (Eq(varName,'AZBXLFMDVT')) {
last_focused_comp=GetLastFocusedElementOfLink('AZBXLFMDVT');
function SetMethod_AZBXLFMDVT() {
Set_ASOT12(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_AZBXLFMDVT();
} else {
setTimeout(SetMethod_AZBXLFMDVT,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'BMLJXZOHDR')) {
return [Ctrl('BMLJXZOHDR')];
}
if (Eq(varName,'PIMPFADLTV')) {
return [Ctrl('PIMPFADLTV')];
}
if (Eq(varName,'NFMNJIJKQG')) {
return [Ctrl('NFMNJIJKQG')];
}
if (Eq(varName,'EGVTWLPYYK')) {
return [Ctrl('EGVTWLPYYK')];
}
if (Eq(varName,'PBXUYJXCDV')) {
return [Ctrl('PBXUYJXCDV')];
}
if (Eq(varName,'LKRRMRMXCU')) {
return [Ctrl('LKRRMRMXCU')];
}
if (Eq(varName,'NQYJKRPMAY')) {
return [Ctrl('NQYJKRPMAY')];
}
if (Eq(varName,'XLQJSGTFOG')) {
return [Ctrl('XLQJSGTFOG')];
}
if (Eq(varName,'VVLLCWNYJU')) {
return [Ctrl('VVLLCWNYJU')];
}
if (Eq(varName,'GPJQCCUFYH')) {
return [Ctrl('GPJQCCUFYH')];
}
if (Eq(varName,'OWCFHGKVPB')) {
return [Ctrl('OWCFHGKVPB')];
}
if (Eq(varName,'ZDTAXGFPRF')) {
return [Ctrl('ZDTAXGFPRF')];
}
if (Eq(varName,'QSAEKELBZF')) {
return [Ctrl('QSAEKELBZF')];
}
if (Eq(varName,'TXKEYYFXPE')) {
return [Ctrl('TXKEYYFXPE')];
}
if (Eq(varName,'XJEPLEAUZI')) {
return [Ctrl('XJEPLEAUZI')];
}
if (Eq(varName,'DSBUADQBZO')) {
return [Ctrl('DSBUADQBZO')];
}
if (Eq(varName,'YMUIBONOPY')) {
return [Ctrl('YMUIBONOPY')];
}
if (Eq(varName,'YFLBURGYJF')) {
return [Ctrl('YFLBURGYJF')];
}
if (Eq(varName,'CZWHSOLRJS')) {
return [Ctrl('CZWHSOLRJS')];
}
if (Eq(varName,'CQDPGDHEVA')) {
return [Ctrl('CQDPGDHEVA')];
}
if (Eq(varName,'EVMGYBVTME')) {
return [Ctrl('EVMGYBVTME')];
}
if (Eq(varName,'YCLLVDJDPC')) {
return [Ctrl('YCLLVDJDPC')];
}
if (Eq(varName,'MWJSVBWARF')) {
return [Ctrl('MWJSVBWARF')];
}
if (Eq(varName,'AKTWQWJXMU')) {
return [Ctrl('AKTWQWJXMU')];
}
if (Eq(varName,'HGBIEMZYHZ')) {
return [Ctrl('HGBIEMZYHZ')];
}
if (Eq(varName,'JIXSOXOUMP')) {
return [Ctrl('JIXSOXOUMP')];
}
if (Eq(varName,'NHXQYOJWPY')) {
return [Ctrl('NHXQYOJWPY')];
}
if (Eq(varName,'FQHPMPIEFY')) {
return [Ctrl('FQHPMPIEFY')];
}
if (Eq(varName,'KGVPSOERYT')) {
return [Ctrl('KGVPSOERYT')];
}
if (Eq(varName,'GWWXIEOXZQ')) {
return [Ctrl('GWWXIEOXZQ')];
}
if (Eq(varName,'TWZIVFFWLR')) {
return [Ctrl('TWZIVFFWLR')];
}
if (Eq(varName,'ESIHSDXQVO')) {
return [Ctrl('ESIHSDXQVO')];
}
if (Eq(varName,'LXNKGCWVDI')) {
return [Ctrl('LXNKGCWVDI')];
}
if (Eq(varName,'QYOHOTJSEN')) {
return [Ctrl('QYOHOTJSEN')];
}
if (Eq(varName,'AWBDLKZHRC')) {
return [Ctrl('AWBDLKZHRC')];
}
if (Eq(varName,'AZBXLFMDVT')) {
return [Ctrl('AZBXLFMDVT')];
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
parent.ZtVWeb.raiseEventToEvalParms('armt_settoreuic_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('armt_settoreuic_dataNotSent',{'action':formaction});
}
}
}
}
CheckChild.child=[];
function Check() {
var l_bResult = true;
ResetErrorVars();
m_nLastError=0;
if ( ! (_ChkObl('VPSAQWGZDD',1))) {
_SignErr('VPSAQWGZDD');
m_cLastWorkVarErrorMsg='112851763';
l_bResult=false;
w_SETSINT=HtW('','C');
} else if ( ! (_ChkObl('QGQGKEQSTH',1))) {
_SignErr('QGQGKEQSTH');
m_cLastWorkVarErrorMsg='285808099';
l_bResult=false;
w_DESCRI=HtW('','C');
} else if ( ! (_ChkObl('KUAJNGTYUY',1))) {
_SignErr('KUAJNGTYUY');
m_cLastWorkVarErrorMsg='1863368778';
l_bResult=false;
w_DATAINI=HtW('','D');
} else if ( ! (_ChkObl('WMKNBZMDVY',1))) {
_SignErr('WMKNBZMDVY');
m_cLastWorkVarErrorMsg='1216938285';
l_bResult=false;
w_DATAFINE=HtW('','D');
} else if ( ! (_ChkObl('BMLJXZOHDR',1))) {
_SignErr('BMLJXZOHDR');
m_cLastWorkVarErrorMsg='2009503427';
l_bResult=false;
w_DAGRU1=HtW('','C');
} else if ( ! (_ChkObl('PIMPFADLTV',1))) {
_SignErr('PIMPFADLTV');
m_cLastWorkVarErrorMsg='1736206657';
l_bResult=false;
w_AGRU1=HtW('','C');
} else if ( ! (_ChkObl('NFMNJIJKQG',1))) {
_SignErr('NFMNJIJKQG');
m_cLastWorkVarErrorMsg='2009503427';
l_bResult=false;
w_DAGRU2=HtW('','C');
} else if ( ! (_ChkObl('EGVTWLPYYK',1))) {
_SignErr('EGVTWLPYYK');
m_cLastWorkVarErrorMsg='1736206657';
l_bResult=false;
w_AGRU2=HtW('','C');
} else if ( ! (_ChkObl('PBXUYJXCDV',1))) {
_SignErr('PBXUYJXCDV');
m_cLastWorkVarErrorMsg='2009503427';
l_bResult=false;
w_DAGRU3=HtW('','C');
} else if ( ! (_ChkObl('LKRRMRMXCU',1))) {
_SignErr('LKRRMRMXCU');
m_cLastWorkVarErrorMsg='1736206657';
l_bResult=false;
w_AGRU3=HtW('','C');
} else if ( ! (_ChkObl('NQYJKRPMAY',1))) {
_SignErr('NQYJKRPMAY');
m_cLastWorkVarErrorMsg='2009503427';
l_bResult=false;
w_DAGRU4=HtW('','C');
} else if ( ! (_ChkObl('XLQJSGTFOG',1))) {
_SignErr('XLQJSGTFOG');
m_cLastWorkVarErrorMsg='1736206657';
l_bResult=false;
w_AGRU4=HtW('','C');
} else if ( ! (_ChkObl('VVLLCWNYJU',1))) {
_SignErr('VVLLCWNYJU');
m_cLastWorkVarErrorMsg='2009503427';
l_bResult=false;
w_DAGRU5=HtW('','C');
} else if ( ! (_ChkObl('GPJQCCUFYH',1))) {
_SignErr('GPJQCCUFYH');
m_cLastWorkVarErrorMsg='1736206657';
l_bResult=false;
w_AGRU5=HtW('','C');
} else if ( ! (_ChkObl('OWCFHGKVPB',1))) {
_SignErr('OWCFHGKVPB');
m_cLastWorkVarErrorMsg='2009503427';
l_bResult=false;
w_DAGRU6=HtW('','C');
} else if ( ! (_ChkObl('ZDTAXGFPRF',1))) {
_SignErr('ZDTAXGFPRF');
m_cLastWorkVarErrorMsg='1736206657';
l_bResult=false;
w_AGRU6=HtW('','C');
} else if ( ! (_ChkObl('QSAEKELBZF',1))) {
_SignErr('QSAEKELBZF');
m_cLastWorkVarErrorMsg='1931203291';
l_bResult=false;
w_DASOT1=HtW('','C');
} else if ( ! (_ChkObl('TXKEYYFXPE',1))) {
_SignErr('TXKEYYFXPE');
m_cLastWorkVarErrorMsg='10416170749';
l_bResult=false;
w_ASOT1=HtW('','C');
} else if ( ! (_ChkObl('XJEPLEAUZI',1))) {
_SignErr('XJEPLEAUZI');
m_cLastWorkVarErrorMsg='1931203291';
l_bResult=false;
w_DASOT2=HtW('','C');
} else if ( ! (_ChkObl('DSBUADQBZO',1))) {
_SignErr('DSBUADQBZO');
m_cLastWorkVarErrorMsg='10416170749';
l_bResult=false;
w_ASOT2=HtW('','C');
} else if ( ! (_ChkObl('YMUIBONOPY',1))) {
_SignErr('YMUIBONOPY');
m_cLastWorkVarErrorMsg='1931203291';
l_bResult=false;
w_DASOT3=HtW('','C');
} else if ( ! (_ChkObl('YFLBURGYJF',1))) {
_SignErr('YFLBURGYJF');
m_cLastWorkVarErrorMsg='10416170749';
l_bResult=false;
w_ASOT3=HtW('','C');
} else if ( ! (_ChkObl('CZWHSOLRJS',1))) {
_SignErr('CZWHSOLRJS');
m_cLastWorkVarErrorMsg='1931203291';
l_bResult=false;
w_DASOT4=HtW('','C');
} else if ( ! (_ChkObl('CQDPGDHEVA',1))) {
_SignErr('CQDPGDHEVA');
m_cLastWorkVarErrorMsg='10416170749';
l_bResult=false;
w_ASOT4=HtW('','C');
} else if ( ! (_ChkObl('EVMGYBVTME',1))) {
_SignErr('EVMGYBVTME');
m_cLastWorkVarErrorMsg='1931203291';
l_bResult=false;
w_DASOT5=HtW('','C');
} else if ( ! (_ChkObl('YCLLVDJDPC',1))) {
_SignErr('YCLLVDJDPC');
m_cLastWorkVarErrorMsg='10416170749';
l_bResult=false;
w_ASOT5=HtW('','C');
} else if ( ! (_ChkObl('MWJSVBWARF',1))) {
_SignErr('MWJSVBWARF');
m_cLastWorkVarErrorMsg='1931203291';
l_bResult=false;
w_DASOT6=HtW('','C');
} else if ( ! (_ChkObl('AKTWQWJXMU',1))) {
_SignErr('AKTWQWJXMU');
m_cLastWorkVarErrorMsg='10416170749';
l_bResult=false;
w_ASOT6=HtW('','C');
} else if ( ! (_ChkObl('HGBIEMZYHZ',1))) {
_SignErr('HGBIEMZYHZ');
m_cLastWorkVarErrorMsg='1931203291';
l_bResult=false;
w_DASOT7=HtW('','C');
} else if ( ! (_ChkObl('JIXSOXOUMP',1))) {
_SignErr('JIXSOXOUMP');
m_cLastWorkVarErrorMsg='10416170749';
l_bResult=false;
w_ASOT7=HtW('','C');
} else if ( ! (_ChkObl('NHXQYOJWPY',1))) {
_SignErr('NHXQYOJWPY');
m_cLastWorkVarErrorMsg='1931203291';
l_bResult=false;
w_DASOT8=HtW('','C');
} else if ( ! (_ChkObl('FQHPMPIEFY',1))) {
_SignErr('FQHPMPIEFY');
m_cLastWorkVarErrorMsg='10416170749';
l_bResult=false;
w_ASOT8=HtW('','C');
} else if ( ! (_ChkObl('KGVPSOERYT',1))) {
_SignErr('KGVPSOERYT');
m_cLastWorkVarErrorMsg='1931203291';
l_bResult=false;
w_DASOT9=HtW('','C');
} else if ( ! (_ChkObl('GWWXIEOXZQ',1))) {
_SignErr('GWWXIEOXZQ');
m_cLastWorkVarErrorMsg='10416170749';
l_bResult=false;
w_ASOT9=HtW('','C');
} else if ( ! (_ChkObl('TWZIVFFWLR',1))) {
_SignErr('TWZIVFFWLR');
m_cLastWorkVarErrorMsg='1931203291';
l_bResult=false;
w_DASOT10=HtW('','C');
} else if ( ! (_ChkObl('ESIHSDXQVO',1))) {
_SignErr('ESIHSDXQVO');
m_cLastWorkVarErrorMsg='10416170749';
l_bResult=false;
w_ASOT10=HtW('','C');
} else if ( ! (_ChkObl('LXNKGCWVDI',1))) {
_SignErr('LXNKGCWVDI');
m_cLastWorkVarErrorMsg='1931203291';
l_bResult=false;
w_DASOT11=HtW('','C');
} else if ( ! (_ChkObl('QYOHOTJSEN',1))) {
_SignErr('QYOHOTJSEN');
m_cLastWorkVarErrorMsg='10416170749';
l_bResult=false;
w_ASOT11=HtW('','C');
} else if ( ! (_ChkObl('AWBDLKZHRC',1))) {
_SignErr('AWBDLKZHRC');
m_cLastWorkVarErrorMsg='1931203291';
l_bResult=false;
w_DASOT12=HtW('','C');
} else if ( ! (_ChkObl('AZBXLFMDVT',1))) {
_SignErr('AZBXLFMDVT');
m_cLastWorkVarErrorMsg='10416170749';
l_bResult=false;
w_ASOT12=HtW('','C');
} else if ( ! (_ChkObl('YMLTCQOYQA',1))) {
_SignErr('YMLTCQOYQA');
m_cLastWorkVarErrorMsg='1620';
l_bResult=false;
w_DAATE2=HtW('','C');
} else if ( ! (_ChkObl('HRVUSTIUAW',1))) {
_SignErr('HRVUSTIUAW');
m_cLastWorkVarErrorMsg='65';
l_bResult=false;
w_AATE2=HtW('','C');
} else if ( ! (_ChkObl('EBJQOWGCVT',1))) {
_SignErr('EBJQOWGCVT');
m_cLastWorkVarErrorMsg='1620';
l_bResult=false;
w_DAATE3=HtW('','C');
} else if ( ! (_ChkObl('YZSORAMVLG',1))) {
_SignErr('YZSORAMVLG');
m_cLastWorkVarErrorMsg='65';
l_bResult=false;
w_AATE3=HtW('','C');
} else if ( ! (_ChkObl('JMLQTMPVIO',1))) {
_SignErr('JMLQTMPVIO');
m_cLastWorkVarErrorMsg='1620';
l_bResult=false;
w_DAATE4=HtW('','C');
} else if ( ! (_ChkObl('SWAVWWKXOJ',1))) {
_SignErr('SWAVWWKXOJ');
m_cLastWorkVarErrorMsg='65';
l_bResult=false;
w_AATE4=HtW('','C');
} else if ( ! (_ChkObl('LVOQGHIOAR',1))) {
_SignErr('LVOQGHIOAR');
m_cLastWorkVarErrorMsg='1620';
l_bResult=false;
w_DAATE5=HtW('','C');
} else if ( ! (_ChkObl('EXYRSFXTUA',1))) {
_SignErr('EXYRSFXTUA');
m_cLastWorkVarErrorMsg='65';
l_bResult=false;
w_AATE5=HtW('','C');
} else if ( ! (_ChkObl('NNPAZLOCUA',1))) {
_SignErr('NNPAZLOCUA');
m_cLastWorkVarErrorMsg='1620';
l_bResult=false;
w_DAATE6=HtW('','C');
} else if ( ! (_ChkObl('RZOSZBFTCK',1))) {
_SignErr('RZOSZBFTCK');
m_cLastWorkVarErrorMsg='65';
l_bResult=false;
w_AATE6=HtW('','C');
} else if ( ! (_ChkObl('DEJMAVGSRU',1))) {
_SignErr('DEJMAVGSRU');
m_cLastWorkVarErrorMsg='1620';
l_bResult=false;
w_DAATE1=HtW('','C');
} else if ( ! (_ChkObl('EQZKMRBROG',1))) {
_SignErr('EQZKMRBROG');
m_cLastWorkVarErrorMsg='65';
l_bResult=false;
w_AATE1=HtW('','C');
}
if (l_bResult) {
l_bResult=CheckChild(0);
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('BMLJXZOHDR_ZOOM',lc)) {
return 0;
}
if (Eq('BMLJXZOHDR',lc)) {
return 0;
}
if (Eq('PIMPFADLTV_ZOOM',lc)) {
return 1;
}
if (Eq('PIMPFADLTV',lc)) {
return 1;
}
if (Eq('NFMNJIJKQG_ZOOM',lc)) {
return 2;
}
if (Eq('NFMNJIJKQG',lc)) {
return 2;
}
if (Eq('EGVTWLPYYK_ZOOM',lc)) {
return 3;
}
if (Eq('EGVTWLPYYK',lc)) {
return 3;
}
if (Eq('PBXUYJXCDV_ZOOM',lc)) {
return 4;
}
if (Eq('PBXUYJXCDV',lc)) {
return 4;
}
if (Eq('LKRRMRMXCU_ZOOM',lc)) {
return 5;
}
if (Eq('LKRRMRMXCU',lc)) {
return 5;
}
if (Eq('NQYJKRPMAY_ZOOM',lc)) {
return 6;
}
if (Eq('NQYJKRPMAY',lc)) {
return 6;
}
if (Eq('XLQJSGTFOG_ZOOM',lc)) {
return 7;
}
if (Eq('XLQJSGTFOG',lc)) {
return 7;
}
if (Eq('VVLLCWNYJU_ZOOM',lc)) {
return 8;
}
if (Eq('VVLLCWNYJU',lc)) {
return 8;
}
if (Eq('GPJQCCUFYH_ZOOM',lc)) {
return 9;
}
if (Eq('GPJQCCUFYH',lc)) {
return 9;
}
if (Eq('OWCFHGKVPB_ZOOM',lc)) {
return 10;
}
if (Eq('OWCFHGKVPB',lc)) {
return 10;
}
if (Eq('ZDTAXGFPRF_ZOOM',lc)) {
return 11;
}
if (Eq('ZDTAXGFPRF',lc)) {
return 11;
}
if (Eq('QSAEKELBZF_ZOOM',lc)) {
return 12;
}
if (Eq('QSAEKELBZF',lc)) {
return 12;
}
if (Eq('TXKEYYFXPE_ZOOM',lc)) {
return 13;
}
if (Eq('TXKEYYFXPE',lc)) {
return 13;
}
if (Eq('XJEPLEAUZI_ZOOM',lc)) {
return 14;
}
if (Eq('XJEPLEAUZI',lc)) {
return 14;
}
if (Eq('DSBUADQBZO_ZOOM',lc)) {
return 15;
}
if (Eq('DSBUADQBZO',lc)) {
return 15;
}
if (Eq('YMUIBONOPY_ZOOM',lc)) {
return 16;
}
if (Eq('YMUIBONOPY',lc)) {
return 16;
}
if (Eq('YFLBURGYJF_ZOOM',lc)) {
return 17;
}
if (Eq('YFLBURGYJF',lc)) {
return 17;
}
if (Eq('CZWHSOLRJS_ZOOM',lc)) {
return 18;
}
if (Eq('CZWHSOLRJS',lc)) {
return 18;
}
if (Eq('CQDPGDHEVA_ZOOM',lc)) {
return 19;
}
if (Eq('CQDPGDHEVA',lc)) {
return 19;
}
if (Eq('EVMGYBVTME_ZOOM',lc)) {
return 20;
}
if (Eq('EVMGYBVTME',lc)) {
return 20;
}
if (Eq('YCLLVDJDPC_ZOOM',lc)) {
return 21;
}
if (Eq('YCLLVDJDPC',lc)) {
return 21;
}
if (Eq('MWJSVBWARF_ZOOM',lc)) {
return 22;
}
if (Eq('MWJSVBWARF',lc)) {
return 22;
}
if (Eq('AKTWQWJXMU_ZOOM',lc)) {
return 23;
}
if (Eq('AKTWQWJXMU',lc)) {
return 23;
}
if (Eq('HGBIEMZYHZ_ZOOM',lc)) {
return 24;
}
if (Eq('HGBIEMZYHZ',lc)) {
return 24;
}
if (Eq('JIXSOXOUMP_ZOOM',lc)) {
return 25;
}
if (Eq('JIXSOXOUMP',lc)) {
return 25;
}
if (Eq('NHXQYOJWPY_ZOOM',lc)) {
return 26;
}
if (Eq('NHXQYOJWPY',lc)) {
return 26;
}
if (Eq('FQHPMPIEFY_ZOOM',lc)) {
return 27;
}
if (Eq('FQHPMPIEFY',lc)) {
return 27;
}
if (Eq('KGVPSOERYT_ZOOM',lc)) {
return 28;
}
if (Eq('KGVPSOERYT',lc)) {
return 28;
}
if (Eq('GWWXIEOXZQ_ZOOM',lc)) {
return 29;
}
if (Eq('GWWXIEOXZQ',lc)) {
return 29;
}
if (Eq('TWZIVFFWLR_ZOOM',lc)) {
return 30;
}
if (Eq('TWZIVFFWLR',lc)) {
return 30;
}
if (Eq('ESIHSDXQVO_ZOOM',lc)) {
return 31;
}
if (Eq('ESIHSDXQVO',lc)) {
return 31;
}
if (Eq('LXNKGCWVDI_ZOOM',lc)) {
return 32;
}
if (Eq('LXNKGCWVDI',lc)) {
return 32;
}
if (Eq('QYOHOTJSEN_ZOOM',lc)) {
return 33;
}
if (Eq('QYOHOTJSEN',lc)) {
return 33;
}
if (Eq('AWBDLKZHRC_ZOOM',lc)) {
return 34;
}
if (Eq('AWBDLKZHRC',lc)) {
return 34;
}
if (Eq('AZBXLFMDVT_ZOOM',lc)) {
return 35;
}
if (Eq('AZBXLFMDVT',lc)) {
return 35;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_BMLJXZOHDR();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,1)) {
l_oWv=LOpt_PIMPFADLTV();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,2)) {
l_oWv=LOpt_NFMNJIJKQG();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,3)) {
l_oWv=LOpt_EGVTWLPYYK();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,4)) {
l_oWv=LOpt_PBXUYJXCDV();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,5)) {
l_oWv=LOpt_LKRRMRMXCU();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,6)) {
l_oWv=LOpt_NQYJKRPMAY();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,7)) {
l_oWv=LOpt_XLQJSGTFOG();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,8)) {
l_oWv=LOpt_VVLLCWNYJU();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,9)) {
l_oWv=LOpt_GPJQCCUFYH();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,10)) {
l_oWv=LOpt_OWCFHGKVPB();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,11)) {
l_oWv=LOpt_ZDTAXGFPRF();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,12)) {
l_oWv=LOpt_QSAEKELBZF();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,13)) {
l_oWv=LOpt_TXKEYYFXPE();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,14)) {
l_oWv=LOpt_XJEPLEAUZI();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,15)) {
l_oWv=LOpt_DSBUADQBZO();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,16)) {
l_oWv=LOpt_YMUIBONOPY();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,17)) {
l_oWv=LOpt_YFLBURGYJF();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,18)) {
l_oWv=LOpt_CZWHSOLRJS();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,19)) {
l_oWv=LOpt_CQDPGDHEVA();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,20)) {
l_oWv=LOpt_EVMGYBVTME();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,21)) {
l_oWv=LOpt_YCLLVDJDPC();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,22)) {
l_oWv=LOpt_MWJSVBWARF();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,23)) {
l_oWv=LOpt_AKTWQWJXMU();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,24)) {
l_oWv=LOpt_HGBIEMZYHZ();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,25)) {
l_oWv=LOpt_JIXSOXOUMP();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,26)) {
l_oWv=LOpt_NHXQYOJWPY();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,27)) {
l_oWv=LOpt_FQHPMPIEFY();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,28)) {
l_oWv=LOpt_KGVPSOERYT();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,29)) {
l_oWv=LOpt_GWWXIEOXZQ();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,30)) {
l_oWv=LOpt_TWZIVFFWLR();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,31)) {
l_oWv=LOpt_ESIHSDXQVO();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,32)) {
l_oWv=LOpt_LXNKGCWVDI();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,33)) {
l_oWv=LOpt_QYOHOTJSEN();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,34)) {
l_oWv=LOpt_AWBDLKZHRC();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,35)) {
l_oWv=LOpt_AZBXLFMDVT();
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
l_oWv.setValue('SETSINT',WtA(w_SETSINT,'C'));
l_oWv.setValue('DESCRI',WtA(w_DESCRI,'C'));
l_oWv.setValue('DASOT1',WtA(w_DASOT1,'C'));
l_oWv.setValue('ASOT1',WtA(w_ASOT1,'C'));
l_oWv.setValue('DASOT2',WtA(w_DASOT2,'C'));
l_oWv.setValue('ASOT2',WtA(w_ASOT2,'C'));
l_oWv.setValue('DASOT3',WtA(w_DASOT3,'C'));
l_oWv.setValue('ASOT3',WtA(w_ASOT3,'C'));
l_oWv.setValue('DASOT4',WtA(w_DASOT4,'C'));
l_oWv.setValue('ASOT4',WtA(w_ASOT4,'C'));
l_oWv.setValue('DASOT5',WtA(w_DASOT5,'C'));
l_oWv.setValue('ASOT5',WtA(w_ASOT5,'C'));
l_oWv.setValue('DASOT6',WtA(w_DASOT6,'C'));
l_oWv.setValue('ASOT6',WtA(w_ASOT6,'C'));
l_oWv.setValue('DASOT7',WtA(w_DASOT7,'C'));
l_oWv.setValue('ASOT7',WtA(w_ASOT7,'C'));
l_oWv.setValue('DASOT8',WtA(w_DASOT8,'C'));
l_oWv.setValue('ASOT8',WtA(w_ASOT8,'C'));
l_oWv.setValue('DASOT9',WtA(w_DASOT9,'C'));
l_oWv.setValue('ASOT9',WtA(w_ASOT9,'C'));
l_oWv.setValue('DASOT10',WtA(w_DASOT10,'C'));
l_oWv.setValue('ASOT10',WtA(w_ASOT10,'C'));
l_oWv.setValue('DASOT11',WtA(w_DASOT11,'C'));
l_oWv.setValue('ASOT11',WtA(w_ASOT11,'C'));
l_oWv.setValue('DASOT12',WtA(w_DASOT12,'C'));
l_oWv.setValue('ASOT12',WtA(w_ASOT12,'C'));
l_oWv.setValue('DATAINI',WtA(w_DATAINI,'D'));
l_oWv.setValue('DATAFINE',WtA(w_DATAFINE,'D'));
l_oWv.setValue('IDSETSIN',WtA(w_IDSETSIN,'N'));
l_oWv.setValue('DAGRU1',WtA(w_DAGRU1,'C'));
l_oWv.setValue('AGRU1',WtA(w_AGRU1,'C'));
l_oWv.setValue('DAGRU2',WtA(w_DAGRU2,'C'));
l_oWv.setValue('AGRU2',WtA(w_AGRU2,'C'));
l_oWv.setValue('DAGRU3',WtA(w_DAGRU3,'C'));
l_oWv.setValue('AGRU3',WtA(w_AGRU3,'C'));
l_oWv.setValue('DAGRU4',WtA(w_DAGRU4,'C'));
l_oWv.setValue('AGRU4',WtA(w_AGRU4,'C'));
l_oWv.setValue('DAGRU5',WtA(w_DAGRU5,'C'));
l_oWv.setValue('AGRU5',WtA(w_AGRU5,'C'));
l_oWv.setValue('DAGRU6',WtA(w_DAGRU6,'C'));
l_oWv.setValue('AGRU6',WtA(w_AGRU6,'C'));
l_oWv.setValue('DAATE2',WtA(w_DAATE2,'C'));
l_oWv.setValue('AATE2',WtA(w_AATE2,'C'));
l_oWv.setValue('DAATE3',WtA(w_DAATE3,'C'));
l_oWv.setValue('AATE3',WtA(w_AATE3,'C'));
l_oWv.setValue('DAATE4',WtA(w_DAATE4,'C'));
l_oWv.setValue('AATE4',WtA(w_AATE4,'C'));
l_oWv.setValue('DAATE5',WtA(w_DAATE5,'C'));
l_oWv.setValue('AATE5',WtA(w_AATE5,'C'));
l_oWv.setValue('DAATE6',WtA(w_DAATE6,'C'));
l_oWv.setValue('AATE6',WtA(w_AATE6,'C'));
l_oWv.setValue('DAATE1',WtA(w_DAATE1,'C'));
l_oWv.setValue('AATE1',WtA(w_AATE1,'C'));
l_oWv.setValue('descg1',WtA(w_descg1,'C'));
l_oWv.setValue('descg2',WtA(w_descg2,'C'));
l_oWv.setValue('descg3',WtA(w_descg3,'C'));
l_oWv.setValue('descg4',WtA(w_descg4,'C'));
l_oWv.setValue('descg5',WtA(w_descg5,'C'));
l_oWv.setValue('descg6',WtA(w_descg6,'C'));
l_oWv.setValue('descg7',WtA(w_descg7,'C'));
l_oWv.setValue('descg8',WtA(w_descg8,'C'));
l_oWv.setValue('descg9',WtA(w_descg9,'C'));
l_oWv.setValue('descg10',WtA(w_descg10,'C'));
l_oWv.setValue('descsg1',WtA(w_descsg1,'C'));
l_oWv.setValue('descsg2',WtA(w_descsg2,'C'));
l_oWv.setValue('descsg3',WtA(w_descsg3,'C'));
l_oWv.setValue('descsg4',WtA(w_descsg4,'C'));
l_oWv.setValue('descsg5',WtA(w_descsg5,'C'));
l_oWv.setValue('descsg6',WtA(w_descsg6,'C'));
l_oWv.setValue('descsg7',WtA(w_descsg7,'C'));
l_oWv.setValue('descsg8',WtA(w_descsg8,'C'));
l_oWv.setValue('descsg9',WtA(w_descsg9,'C'));
l_oWv.setValue('descsg10',WtA(w_descsg10,'C'));
l_oWv.setValue('descsg11',WtA(w_descsg11,'C'));
l_oWv.setValue('descsg12',WtA(w_descsg12,'C'));
l_oWv.setValue('descg11',WtA(w_descg11,'C'));
l_oWv.setValue('descg12',WtA(w_descg12,'C'));
l_oWv.setValue('descsg13',WtA(w_descsg13,'C'));
l_oWv.setValue('descsg14',WtA(w_descsg14,'C'));
l_oWv.setValue('descsg15',WtA(w_descsg15,'C'));
l_oWv.setValue('descsg16',WtA(w_descsg16,'C'));
l_oWv.setValue('descsg17',WtA(w_descsg17,'C'));
l_oWv.setValue('descsg18',WtA(w_descsg18,'C'));
l_oWv.setValue('descsg19',WtA(w_descsg19,'C'));
l_oWv.setValue('descsg20',WtA(w_descsg20,'C'));
l_oWv.setValue('descsg21',WtA(w_descsg21,'C'));
l_oWv.setValue('descsg22',WtA(w_descsg22,'C'));
l_oWv.setValue('descsg23',WtA(w_descsg23,'C'));
l_oWv.setValue('descsg24',WtA(w_descsg24,'C'));
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
FillWv.n=["SETSINT","DESCRI","DASOT1","ASOT1","DASOT2","ASOT2","DASOT3","ASOT3","DASOT4","ASOT4","DASOT5","ASOT5","DASOT6","ASOT6","DASOT7","ASOT7","DASOT8","ASOT8","DASOT9","ASOT9","DASOT10","ASOT10","DASOT11","ASOT11","DASOT12","ASOT12","DATAINI","DATAFINE","IDSETSIN","DAGRU1","AGRU1","DAGRU2","AGRU2","DAGRU3","AGRU3","DAGRU4","AGRU4","DAGRU5","AGRU5","DAGRU6","AGRU6","DAATE2","AATE2","DAATE3","AATE3","DAATE4","AATE4","DAATE5","AATE5","DAATE6","AATE6","DAATE1","AATE1","descg1","descg2","descg3","descg4","descg5","descg6","descg7","descg8","descg9","descg10","descsg1","descsg2","descsg3","descsg4","descsg5","descsg6","descsg7","descsg8","descsg9","descsg10","descsg11","descsg12","descg11","descg12","descsg13","descsg14","descsg15","descsg16","descsg17","descsg18","descsg19","descsg20","descsg21","descsg22","descsg23","descsg24"];
function SetModified() {
m_bUpdated=true;
}
