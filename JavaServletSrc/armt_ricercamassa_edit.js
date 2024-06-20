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
if (IsDisabledByStateDriver('box_XLKFOZPJVO')) {
DisableInputsInContainer(Ctrl('XLKFOZPJVO'),true);
}
if (IsDisabledByStateDriver('box_KVGFUZUMZV')) {
DisableInputsInContainer(Ctrl('KVGFUZUMZV'),true);
}
if (IsDisabledByStateDriver('box_ZRLFCCXZUM')) {
DisableInputsInContainer(Ctrl('ZRLFCCXZUM'),true);
}
if (IsDisabledByStateDriver('box_YOZVQCHKHW')) {
DisableInputsInContainer(Ctrl('YOZVQCHKHW'),true);
}
if (IsDisabledByStateDriver('box_CSGINFLFWZ')) {
DisableInputsInContainer(Ctrl('CSGINFLFWZ'),true);
}
if (IsDisabledByStateDriver('box_KRHDYFEJWS')) {
DisableInputsInContainer(Ctrl('KRHDYFEJWS'),true);
}
if (IsDisabledByStateDriver('box_IAWYMLKEQC')) {
DisableInputsInContainer(Ctrl('IAWYMLKEQC'),true);
}
if (IsDisabledByStateDriver('box_EVPFVSEQYP')) {
DisableInputsInContainer(Ctrl('EVPFVSEQYP'),true);
}
if (IsDisabledByStateDriver('box_RWWUWNLOQE')) {
DisableInputsInContainer(Ctrl('RWWUWNLOQE'),true);
}
if (IsDisabledByStateDriver('box_HKEAENLPXY')) {
DisableInputsInContainer(Ctrl('HKEAENLPXY'),true);
}
if (IsDisabledByStateDriver('box_RKEDQZABYX')) {
DisableInputsInContainer(Ctrl('RKEDQZABYX'),true);
}
if (IsDisabledByStateDriver('box_JLTUCUTXFV')) {
DisableInputsInContainer(Ctrl('JLTUCUTXFV'),true);
}
if (IsDisabledByStateDriver('box_EITSLGXPKQ')) {
DisableInputsInContainer(Ctrl('EITSLGXPKQ'),true);
}
if (IsDisabledByStateDriver('box_UOKHMLIEUR')) {
DisableInputsInContainer(Ctrl('UOKHMLIEUR'),true);
}
if (IsDisabledByStateDriver('box_ZGRJNQPUNM')) {
DisableInputsInContainer(Ctrl('ZGRJNQPUNM'),true);
}
if (IsDisabledByStateDriver('box_OFWGQIZSXD')) {
DisableInputsInContainer(Ctrl('OFWGQIZSXD'),true);
}
if (IsDisabledByStateDriver('box_XECCYIEIAP')) {
DisableInputsInContainer(Ctrl('XECCYIEIAP'),true);
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
function Set_archivio(ctrlValue,kmode,e) {
if (Ne(w_archivio,ctrlValue)) {
var ctl = _GetCtl(e,'WBNIEXDKHU');
if (_tracker.goon(ctl,ctrlValue)) {
w_archivio=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('WBNIEXDKHU',0);
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
function Set_H45(ctrlValue,kmode,e) {
if (Ne(w_H45,ctrlValue)) {
var ctl = _GetCtl(e,'CCGDGWYZHO');
if (_tracker.goon(ctl,ctrlValue)) {
w_H45=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CCGDGWYZHO',0);
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
function Set_D22(ctrlValue,kmode,e) {
if (Ne(w_D22,ctrlValue)) {
var ctl = _GetCtl(e,'QZTKKLVNJB');
if (_tracker.goon(ctl,ctrlValue)) {
w_D22=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QZTKKLVNJB',0);
if (l_bResult) {
l_bResult=Link_QZTKKLVNJB(kmode);
if ( ! (l_bResult)) {
w_D22=HtW('','C');
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
function Set_A01A(ctrlValue,kmode,e) {
if (Ne(w_A01A,ctrlValue)) {
var ctl = _GetCtl(e,'TESHVPIZQD');
if (_tracker.goon(ctl,ctrlValue)) {
w_A01A=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('TESHVPIZQD',0);
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
function Set_A01B(ctrlValue,kmode,e) {
if (Ne(w_A01B,ctrlValue)) {
var ctl = _GetCtl(e,'TIPXBDXITE');
if (_tracker.goon(ctl,ctrlValue)) {
w_A01B=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('TIPXBDXITE',0);
if (l_bResult) {
l_bResult=Link_TIPXBDXITE(kmode);
if ( ! (l_bResult)) {
w_A01B=HtW('','C');
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
function Set_H44(ctrlValue,kmode,e) {
if (Ne(w_H44,ctrlValue)) {
var ctl = _GetCtl(e,'PBYCEMAFOR');
if (_tracker.goon(ctl,ctrlValue)) {
w_H44=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('PBYCEMAFOR',0);
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
function Set_A03(ctrlValue,kmode,e) {
if (Ne(w_A03,ctrlValue)) {
var ctl = _GetCtl(e,'MXWTPQUTBB');
if (_tracker.goon(ctl,ctrlValue)) {
w_A03=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MXWTPQUTBB',0);
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
function Set_A11(ctrlValue,kmode,e) {
if (Ne(w_A11,ctrlValue)) {
var ctl = _GetCtl(e,'BQNMQAOIPA');
if (_tracker.goon(ctl,ctrlValue)) {
w_A11=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BQNMQAOIPA',0);
if (l_bResult) {
l_bResult=Link_BQNMQAOIPA(kmode);
if ( ! (l_bResult)) {
w_A11=HtW('','C');
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
function Set_D23(ctrlValue,kmode,e) {
if (Ne(w_D23,ctrlValue)) {
var ctl = _GetCtl(e,'RIPVAPFZCO');
if (_tracker.goon(ctl,ctrlValue)) {
w_D23=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RIPVAPFZCO',0);
if (l_bResult) {
l_bResult=Link_RIPVAPFZCO(kmode);
if ( ! (l_bResult)) {
w_D23=HtW('','C');
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
function Set_A12A(ctrlValue,kmode,e) {
if (Ne(w_A12A,ctrlValue)) {
var ctl = _GetCtl(e,'XHIBDWLIOD');
if (_tracker.goon(ctl,ctrlValue)) {
w_A12A=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XHIBDWLIOD',0);
if (l_bResult) {
l_bResult=Link_XHIBDWLIOD(kmode);
if ( ! (l_bResult)) {
w_A12A=HtW('','C');
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
function Set_A12B(ctrlValue,kmode,e) {
if (Ne(w_A12B,ctrlValue)) {
var ctl = _GetCtl(e,'IFYLHOXPRS');
if (_tracker.goon(ctl,ctrlValue)) {
w_A12B=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('IFYLHOXPRS',0);
if (l_bResult) {
l_bResult=Link_IFYLHOXPRS(kmode);
if ( ! (l_bResult)) {
w_A12B=HtW('','C');
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
function Set_A12C(ctrlValue,kmode,e) {
if (Ne(w_A12C,ctrlValue)) {
var ctl = _GetCtl(e,'WZNDKFWJMU');
if (_tracker.goon(ctl,ctrlValue)) {
w_A12C=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('WZNDKFWJMU',0);
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
function Set_A21(ctrlValue,kmode,e) {
if (Ne(w_A21,ctrlValue)) {
var ctl = _GetCtl(e,'OOVOWNWMZK');
if (_tracker.goon(ctl,ctrlValue)) {
w_A21=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('OOVOWNWMZK',0);
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
function Set_A22(ctrlValue,kmode,e) {
if (Ne(w_A22,ctrlValue)) {
var ctl = _GetCtl(e,'TPGCMCINSD');
if (_tracker.goon(ctl,ctrlValue)) {
w_A22=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('TPGCMCINSD',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','N',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_A23(ctrlValue,kmode,e) {
if (Ne(w_A23,ctrlValue)) {
var ctl = _GetCtl(e,'NPNITFAIKW');
if (_tracker.goon(ctl,ctrlValue)) {
w_A23=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NPNITFAIKW',0);
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
function Set_A24(ctrlValue,kmode,e) {
if (Ne(w_A24,ctrlValue)) {
var ctl = _GetCtl(e,'CKACALWZOL');
if (_tracker.goon(ctl,ctrlValue)) {
w_A24=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CKACALWZOL',0);
if (l_bResult) {
l_bResult=Link_CKACALWZOL(kmode);
if ( ! (l_bResult)) {
w_A24=HtW('','C');
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
function Set_A25(ctrlValue,kmode,e) {
if (Ne(w_A25,ctrlValue)) {
var ctl = _GetCtl(e,'ZIMEUPPLZY');
if (_tracker.goon(ctl,ctrlValue)) {
w_A25=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ZIMEUPPLZY',0);
if (l_bResult) {
l_bResult=Link_ZIMEUPPLZY(kmode);
if ( ! (l_bResult)) {
w_A25=HtW('','C');
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
function Set_A31A(ctrlValue,kmode,e) {
if (Ne(w_A31A,ctrlValue)) {
var ctl = _GetCtl(e,'EHNAPBXMAR');
if (_tracker.goon(ctl,ctrlValue)) {
w_A31A=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('EHNAPBXMAR',0);
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
function Set_A31B(ctrlValue,kmode,e) {
if (Ne(w_A31B,ctrlValue)) {
var ctl = _GetCtl(e,'ZZQPEDWGCO');
if (_tracker.goon(ctl,ctrlValue)) {
w_A31B=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ZZQPEDWGCO',0);
if (l_bResult) {
l_bResult=Link_ZZQPEDWGCO(kmode);
if ( ! (l_bResult)) {
w_A31B=HtW('','C');
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
function Set_A32(ctrlValue,kmode,e) {
if (Ne(w_A32,ctrlValue)) {
var ctl = _GetCtl(e,'LTUCQORMSA');
if (_tracker.goon(ctl,ctrlValue)) {
w_A32=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('LTUCQORMSA',0);
if (l_bResult) {
l_bResult=Link_LTUCQORMSA(kmode);
if ( ! (l_bResult)) {
w_A32=HtW('','C');
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
function Set_A33A(ctrlValue,kmode,e) {
if (Ne(w_A33A,ctrlValue)) {
var ctl = _GetCtl(e,'VDWEKDDBOW');
if (_tracker.goon(ctl,ctrlValue)) {
w_A33A=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VDWEKDDBOW',0);
if (l_bResult) {
l_bResult=Link_VDWEKDDBOW(kmode);
if ( ! (l_bResult)) {
w_A33A=HtW('','C');
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
function Set_A33B(ctrlValue,kmode,e) {
if (Ne(w_A33B,ctrlValue)) {
var ctl = _GetCtl(e,'BICDANUWZD');
if (_tracker.goon(ctl,ctrlValue)) {
w_A33B=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BICDANUWZD',0);
if (l_bResult) {
l_bResult=Link_BICDANUWZD(kmode);
if ( ! (l_bResult)) {
w_A33B=HtW('','C');
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
function Set_D45(ctrlValue,kmode,e) {
if (Ne(w_D45,ctrlValue)) {
var ctl = _GetCtl(e,'GEXJBDRMDF');
if (_tracker.goon(ctl,ctrlValue)) {
w_D45=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('GEXJBDRMDF',0);
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
function Set_A33C(ctrlValue,kmode,e) {
if (Ne(w_A33C,ctrlValue)) {
var ctl = _GetCtl(e,'OCRIGUNQVR');
if (_tracker.goon(ctl,ctrlValue)) {
w_A33C=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('OCRIGUNQVR',0);
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
function Set_A34(ctrlValue,kmode,e) {
if (Ne(w_A34,ctrlValue)) {
var ctl = _GetCtl(e,'PGJPWEXBVK');
if (_tracker.goon(ctl,ctrlValue)) {
w_A34=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('PGJPWEXBVK',0);
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
function Set_A41(ctrlValue,kmode,e) {
if (Ne(w_A41,ctrlValue)) {
var ctl = _GetCtl(e,'HDIAJDVNVI');
if (_tracker.goon(ctl,ctrlValue)) {
w_A41=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HDIAJDVNVI',0);
if (l_bResult) {
l_bResult=Link_HDIAJDVNVI(kmode);
if ( ! (l_bResult)) {
w_A41=HtW('','C');
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
function Set_A42(ctrlValue,kmode,e) {
if (Ne(w_A42,ctrlValue)) {
var ctl = _GetCtl(e,'RQJLOLNIHM');
if (_tracker.goon(ctl,ctrlValue)) {
w_A42=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RQJLOLNIHM',0);
if (l_bResult) {
l_bResult=Link_RQJLOLNIHM(kmode);
if ( ! (l_bResult)) {
w_A42=HtW('','C');
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
function Set_A43(ctrlValue,kmode,e) {
if (Ne(w_A43,ctrlValue)) {
var ctl = _GetCtl(e,'CHJJABTJCS');
if (_tracker.goon(ctl,ctrlValue)) {
w_A43=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CHJJABTJCS',0);
if (l_bResult) {
l_bResult=Link_CHJJABTJCS(kmode);
if ( ! (l_bResult)) {
w_A43=HtW('','C');
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
function Set_E11(ctrlValue,kmode,e) {
if (Ne(w_E11,ctrlValue)) {
var ctl = _GetCtl(e,'UMGRLGMHMY');
if (_tracker.goon(ctl,ctrlValue)) {
w_E11=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UMGRLGMHMY',0);
if (l_bResult) {
l_bResult=Link_UMGRLGMHMY(kmode);
if ( ! (l_bResult)) {
w_E11=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',70,0,''));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',70,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_E13(ctrlValue,kmode,e) {
if (Ne(w_E13,ctrlValue)) {
var ctl = _GetCtl(e,'GXOOZRXYFU');
if (_tracker.goon(ctl,ctrlValue)) {
w_E13=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('GXOOZRXYFU',0);
if (l_bResult) {
l_bResult=Link_GXOOZRXYFU(kmode);
if ( ! (l_bResult)) {
w_E13=HtW('','C');
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
function Set_A51(ctrlValue,kmode,e) {
if (Ne(w_A51,ctrlValue)) {
var ctl = _GetCtl(e,'KFDSCJBSLJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_A51=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('KFDSCJBSLJ',0);
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
function Set_A52B(ctrlValue,kmode,e) {
if (Ne(w_A52B,ctrlValue)) {
var ctl = _GetCtl(e,'DFFBWGMKTL');
if (_tracker.goon(ctl,ctrlValue)) {
w_A52B=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('DFFBWGMKTL',0);
if (l_bResult) {
l_bResult=Link_DFFBWGMKTL(kmode);
if ( ! (l_bResult)) {
w_A52B=HtW('','C');
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
function Set_A53(ctrlValue,kmode,e) {
if (Ne(w_A53,ctrlValue)) {
var ctl = _GetCtl(e,'JPOXBHVIYE');
if (_tracker.goon(ctl,ctrlValue)) {
w_A53=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('JPOXBHVIYE',0);
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
function Set_A54A(ctrlValue,kmode,e) {
if (Ne(w_A54A,ctrlValue)) {
var ctl = _GetCtl(e,'VJIDPHKDWI');
if (_tracker.goon(ctl,ctrlValue)) {
w_A54A=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VJIDPHKDWI',0);
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
function Set_A54B(ctrlValue,kmode,e) {
if (Ne(w_A54B,ctrlValue)) {
var ctl = _GetCtl(e,'XYVBVXLTXA');
if (_tracker.goon(ctl,ctrlValue)) {
w_A54B=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XYVBVXLTXA',0);
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
function Set_A54C(ctrlValue,kmode,e) {
if (Ne(w_A54C,ctrlValue)) {
var ctl = _GetCtl(e,'MSZJBMMVGZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_A54C=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MSZJBMMVGZ',0);
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
function Set_E14C(ctrlValue,kmode,e) {
if (Ne(w_E14C,ctrlValue)) {
var ctl = _GetCtl(e,'SHRVLATCSU');
if (_tracker.goon(ctl,ctrlValue)) {
w_E14C=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SHRVLATCSU',0);
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
function Set_E15(ctrlValue,kmode,e) {
if (Ne(w_E15,ctrlValue)) {
var ctl = _GetCtl(e,'VOGKTTTAQY');
if (_tracker.goon(ctl,ctrlValue)) {
w_E15=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VOGKTTTAQY',0);
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
function Set_H43(ctrlValue,kmode,e) {
if (Ne(w_H43,ctrlValue)) {
var ctl = _GetCtl(e,'AAPLEODVNN');
if (_tracker.goon(ctl,ctrlValue)) {
w_H43=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('AAPLEODVNN',0);
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
function Set_H41(ctrlValue,kmode,e) {
if (Ne(w_H41,ctrlValue)) {
var ctl = _GetCtl(e,'OAWXXEHPRA');
if (_tracker.goon(ctl,ctrlValue)) {
w_H41=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('OAWXXEHPRA',0);
if (l_bResult) {
l_bResult=Link_OAWXXEHPRA(kmode);
if ( ! (l_bResult)) {
w_H41=HtW('','C');
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
function Set_B11(ctrlValue,kmode,e) {
if (Ne(w_B11,ctrlValue)) {
var ctl = _GetCtl(e,'EPMUHBJYIP');
if (_tracker.goon(ctl,ctrlValue)) {
w_B11=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('EPMUHBJYIP',0);
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
function Set_B12(ctrlValue,kmode,e) {
if (Ne(w_B12,ctrlValue)) {
var ctl = _GetCtl(e,'CDFYKKBMYS');
if (_tracker.goon(ctl,ctrlValue)) {
w_B12=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CDFYKKBMYS',0);
if (l_bResult) {
l_bResult=Link_CDFYKKBMYS(kmode);
if ( ! (l_bResult)) {
w_B12=HtW('','C');
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
function Set_B13(ctrlValue,kmode,e) {
if (Ne(w_B13,ctrlValue)) {
var ctl = _GetCtl(e,'AREEANYKOU');
if (_tracker.goon(ctl,ctrlValue)) {
w_B13=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('AREEANYKOU',0);
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
function Set_B14(ctrlValue,kmode,e) {
if (Ne(w_B14,ctrlValue)) {
var ctl = _GetCtl(e,'SOZNPELALO');
if (_tracker.goon(ctl,ctrlValue)) {
w_B14=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SOZNPELALO',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('SOZNPELALO',function(){return WtH(w_B14,'N',19,0,'9,999,999,999,999,999,999')},w_B14);
return l_bResult;
} else {
ctl.value=WtH('','N',19,0,'9999999999999999999');
_ResetTracker();
return true;
}
} else {
SPBOUILib.SetInputValue('SOZNPELALO',function(){return WtH(w_B14,'N',19,0,'9,999,999,999,999,999,999')},w_B14);
}
return true;
}
function Set_B15(ctrlValue,kmode,e) {
if (Ne(w_B15,ctrlValue)) {
var ctl = _GetCtl(e,'DNCCUIFECE');
if (_tracker.goon(ctl,ctrlValue)) {
w_B15=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('DNCCUIFECE',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('DNCCUIFECE',function(){return WtH(w_B15,'N',19,0,'9,999,999,999,999,999,999')},w_B15);
return l_bResult;
} else {
ctl.value=WtH('','N',19,0,'9999999999999999999');
_ResetTracker();
return true;
}
} else {
SPBOUILib.SetInputValue('DNCCUIFECE',function(){return WtH(w_B15,'N',19,0,'9,999,999,999,999,999,999')},w_B15);
}
return true;
}
function Set_E17(ctrlValue,kmode,e) {
if (Ne(w_E17,ctrlValue)) {
var ctl = _GetCtl(e,'HZXHSFBWVP');
if (_tracker.goon(ctl,ctrlValue)) {
w_E17=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HZXHSFBWVP',0);
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
function Set_H19B(ctrlValue,kmode,e) {
if (Ne(w_H19B,ctrlValue)) {
var ctl = _GetCtl(e,'RQOFXUOOWZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_H19B=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RQOFXUOOWZ',0);
if (l_bResult) {
l_bResult=Link_RQOFXUOOWZ(kmode);
if ( ! (l_bResult)) {
w_H19B=HtW('','C');
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
function Set_H19A(ctrlValue,kmode,e) {
if (Ne(w_H19A,ctrlValue)) {
var ctl = _GetCtl(e,'KCGLCUJYUP');
if (_tracker.goon(ctl,ctrlValue)) {
w_H19A=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('KCGLCUJYUP',0);
if (l_bResult) {
l_bResult=Link_KCGLCUJYUP(kmode);
if ( ! (l_bResult)) {
w_H19A=HtW('','C');
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
function Set_X_B14_OP(ctrlValue,kmode,e) {
if (Ne(w_X_B14_OP,ctrlValue)) {
var ctl = _GetCtl(e,'CFQDRXVJLE');
if (_tracker.goon(ctl,ctrlValue)) {
w_X_B14_OP=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CFQDRXVJLE',0);
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
function Set_X_B15_OP(ctrlValue,kmode,e) {
if (Ne(w_X_B15_OP,ctrlValue)) {
var ctl = _GetCtl(e,'JNSSKKSFRO');
if (_tracker.goon(ctl,ctrlValue)) {
w_X_B15_OP=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('JNSSKKSFRO',0);
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
function Set_E18(ctrlValue,kmode,e) {
if (Ne(w_E18,ctrlValue)) {
var ctl = _GetCtl(e,'STLDMRXUQZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_E18=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('STLDMRXUQZ',0);
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
function Set_E19A(ctrlValue,kmode,e) {
if (Ne(w_E19A,ctrlValue)) {
var ctl = _GetCtl(e,'OZDICWDQRW');
if (_tracker.goon(ctl,ctrlValue)) {
w_E19A=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('OZDICWDQRW',0);
if (l_bResult) {
l_bResult=Link_OZDICWDQRW(kmode);
if ( ! (l_bResult)) {
w_E19A=HtW('','C');
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
function Set_C11(ctrlValue,kmode,e) {
if (Ne(w_C11,ctrlValue)) {
var ctl = _GetCtl(e,'BZRDFHBMPM');
if (_tracker.goon(ctl,ctrlValue)) {
w_C11=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BZRDFHBMPM',0);
if (l_bResult) {
l_bResult=Link_BZRDFHBMPM(kmode);
if ( ! (l_bResult)) {
w_C11=HtW('','C');
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
function Set_E19B(ctrlValue,kmode,e) {
if (Ne(w_E19B,ctrlValue)) {
var ctl = _GetCtl(e,'YSNADFXEBL');
if (_tracker.goon(ctl,ctrlValue)) {
w_E19B=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YSNADFXEBL',0);
if (l_bResult) {
l_bResult=Link_YSNADFXEBL(kmode);
if ( ! (l_bResult)) {
w_E19B=HtW('','C');
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
function Set_C21(ctrlValue,kmode,e) {
if (Ne(w_C21,ctrlValue)) {
var ctl = _GetCtl(e,'UYRQHSBRRT');
if (_tracker.goon(ctl,ctrlValue)) {
w_C21=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UYRQHSBRRT',0);
if (l_bResult) {
l_bResult=Link_UYRQHSBRRT(kmode);
if ( ! (l_bResult)) {
w_C21=HtW('','C');
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
function Set_C31(ctrlValue,kmode,e) {
if (Ne(w_C31,ctrlValue)) {
var ctl = _GetCtl(e,'PMFBITPOAZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_C31=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('PMFBITPOAZ',0);
if (l_bResult) {
l_bResult=Link_PMFBITPOAZ(kmode);
if ( ! (l_bResult)) {
w_C31=HtW('','C');
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
function Set_E41(ctrlValue,kmode,e) {
if (Ne(w_E41,ctrlValue)) {
var ctl = _GetCtl(e,'SZZONHIXUX');
if (_tracker.goon(ctl,ctrlValue)) {
w_E41=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SZZONHIXUX',0);
if (l_bResult) {
l_bResult=Link_SZZONHIXUX(kmode);
if ( ! (l_bResult)) {
w_E41=HtW('','C');
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
function Set_H17(ctrlValue,kmode,e) {
if (Ne(w_H17,ctrlValue)) {
var ctl = _GetCtl(e,'MYCAJZEAYR');
if (_tracker.goon(ctl,ctrlValue)) {
w_H17=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MYCAJZEAYR',0);
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
function Set_C41(ctrlValue,kmode,e) {
if (Ne(w_C41,ctrlValue)) {
var ctl = _GetCtl(e,'LZSKLOQPNQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_C41=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('LZSKLOQPNQ',0);
if (l_bResult) {
l_bResult=Link_LZSKLOQPNQ(kmode);
if ( ! (l_bResult)) {
w_C41=HtW('','C');
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
function Set_H18(ctrlValue,kmode,e) {
if (Ne(w_H18,ctrlValue)) {
var ctl = _GetCtl(e,'MJSLFJOSLC');
if (_tracker.goon(ctl,ctrlValue)) {
w_H18=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MJSLFJOSLC',0);
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
function Set_C51(ctrlValue,kmode,e) {
if (Ne(w_C51,ctrlValue)) {
var ctl = _GetCtl(e,'RHMPOMWSNG');
if (_tracker.goon(ctl,ctrlValue)) {
w_C51=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RHMPOMWSNG',0);
if (l_bResult) {
l_bResult=Link_RHMPOMWSNG(kmode);
if ( ! (l_bResult)) {
w_C51=HtW('','C');
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
function Set_E42(ctrlValue,kmode,e) {
if (Ne(w_E42,ctrlValue)) {
var ctl = _GetCtl(e,'GVZBHBTNIN');
if (_tracker.goon(ctl,ctrlValue)) {
w_E42=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('GVZBHBTNIN',0);
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
function Set_H16(ctrlValue,kmode,e) {
if (Ne(w_H16,ctrlValue)) {
var ctl = _GetCtl(e,'SDOQENNYTS');
if (_tracker.goon(ctl,ctrlValue)) {
w_H16=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SDOQENNYTS',0);
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
function Set_H15(ctrlValue,kmode,e) {
if (Ne(w_H15,ctrlValue)) {
var ctl = _GetCtl(e,'QCIYKOSBAC');
if (_tracker.goon(ctl,ctrlValue)) {
w_H15=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QCIYKOSBAC',0);
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
function Set_D11(ctrlValue,kmode,e) {
if (Ne(w_D11,ctrlValue)) {
var ctl = _GetCtl(e,'OQJHGGFCNJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_D11=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('OQJHGGFCNJ',0);
if (l_bResult) {
l_bResult=Link_OQJHGGFCNJ(kmode);
if ( ! (l_bResult)) {
w_D11=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',70,0,''));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',70,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_D13(ctrlValue,kmode,e) {
if (Ne(w_D13,ctrlValue)) {
var ctl = _GetCtl(e,'GMCYYELLWW');
if (_tracker.goon(ctl,ctrlValue)) {
w_D13=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('GMCYYELLWW',0);
if (l_bResult) {
l_bResult=Link_GMCYYELLWW(kmode);
if ( ! (l_bResult)) {
w_D13=HtW('','C');
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
function Set_D14A(ctrlValue,kmode,e) {
if (Ne(w_D14A,ctrlValue)) {
var ctl = _GetCtl(e,'VZGLYXBMQI');
if (_tracker.goon(ctl,ctrlValue)) {
w_D14A=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VZGLYXBMQI',0);
if (l_bResult) {
l_bResult=Link_VZGLYXBMQI(kmode);
if ( ! (l_bResult)) {
w_D14A=HtW('','C');
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
function Set_D14B(ctrlValue,kmode,e) {
if (Ne(w_D14B,ctrlValue)) {
var ctl = _GetCtl(e,'YRFNYFRQSY');
if (_tracker.goon(ctl,ctrlValue)) {
w_D14B=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YRFNYFRQSY',0);
if (l_bResult) {
l_bResult=Link_YRFNYFRQSY(kmode);
if ( ! (l_bResult)) {
w_D14B=HtW('','C');
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
function Set_D14C(ctrlValue,kmode,e) {
if (Ne(w_D14C,ctrlValue)) {
var ctl = _GetCtl(e,'RLWWENBDDD');
if (_tracker.goon(ctl,ctrlValue)) {
w_D14C=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RLWWENBDDD',0);
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
function Set_D15(ctrlValue,kmode,e) {
if (Ne(w_D15,ctrlValue)) {
var ctl = _GetCtl(e,'YCLKMEZUZX');
if (_tracker.goon(ctl,ctrlValue)) {
w_D15=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YCLKMEZUZX',0);
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
function Set_D16(ctrlValue,kmode,e) {
if (Ne(w_D16,ctrlValue)) {
var ctl = _GetCtl(e,'ZIKKMNZCHI');
if (_tracker.goon(ctl,ctrlValue)) {
w_D16=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ZIKKMNZCHI',0);
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
function Set_D17(ctrlValue,kmode,e) {
if (Ne(w_D17,ctrlValue)) {
var ctl = _GetCtl(e,'UEISEWDTOW');
if (_tracker.goon(ctl,ctrlValue)) {
w_D17=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UEISEWDTOW',0);
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
function Set_D18(ctrlValue,kmode,e) {
if (Ne(w_D18,ctrlValue)) {
var ctl = _GetCtl(e,'AZIQXZISZO');
if (_tracker.goon(ctl,ctrlValue)) {
w_D18=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('AZIQXZISZO',0);
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
function Set_D19A(ctrlValue,kmode,e) {
if (Ne(w_D19A,ctrlValue)) {
var ctl = _GetCtl(e,'ZGFXMEVTVH');
if (_tracker.goon(ctl,ctrlValue)) {
w_D19A=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ZGFXMEVTVH',0);
if (l_bResult) {
l_bResult=Link_ZGFXMEVTVH(kmode);
if ( ! (l_bResult)) {
w_D19A=HtW('','C');
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
function Set_D19B(ctrlValue,kmode,e) {
if (Ne(w_D19B,ctrlValue)) {
var ctl = _GetCtl(e,'RVQNZAINRJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_D19B=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RVQNZAINRJ',0);
if (l_bResult) {
l_bResult=Link_RVQNZAINRJ(kmode);
if ( ! (l_bResult)) {
w_D19B=HtW('','C');
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
function Set_D21(ctrlValue,kmode,e) {
if (Ne(w_D21,ctrlValue)) {
var ctl = _GetCtl(e,'DXFRERNUEZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_D21=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('DXFRERNUEZ',0);
if (l_bResult) {
l_bResult=Link_DXFRERNUEZ(kmode);
if ( ! (l_bResult)) {
w_D21=HtW('','C');
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
function Set_F11(ctrlValue,kmode,e) {
if (Ne(w_F11,ctrlValue)) {
var ctl = _GetCtl(e,'XUTATNAFCN');
if (_tracker.goon(ctl,ctrlValue)) {
w_F11=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XUTATNAFCN',0);
if (l_bResult) {
l_bResult=Link_XUTATNAFCN(kmode);
if ( ! (l_bResult)) {
w_F11=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',70,0,''));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',70,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_F13(ctrlValue,kmode,e) {
if (Ne(w_F13,ctrlValue)) {
var ctl = _GetCtl(e,'GSQDROOXIH');
if (_tracker.goon(ctl,ctrlValue)) {
w_F13=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('GSQDROOXIH',0);
if (l_bResult) {
l_bResult=Link_GSQDROOXIH(kmode);
if ( ! (l_bResult)) {
w_F13=HtW('','C');
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
function Set_H14C(ctrlValue,kmode,e) {
if (Ne(w_H14C,ctrlValue)) {
var ctl = _GetCtl(e,'ERDRBGAWFM');
if (_tracker.goon(ctl,ctrlValue)) {
w_H14C=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ERDRBGAWFM',0);
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
function Set_H14B(ctrlValue,kmode,e) {
if (Ne(w_H14B,ctrlValue)) {
var ctl = _GetCtl(e,'UVHIQLABPT');
if (_tracker.goon(ctl,ctrlValue)) {
w_H14B=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UVHIQLABPT',0);
if (l_bResult) {
l_bResult=Link_UVHIQLABPT(kmode);
if ( ! (l_bResult)) {
w_H14B=HtW('','C');
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
function Set_H14A(ctrlValue,kmode,e) {
if (Ne(w_H14A,ctrlValue)) {
var ctl = _GetCtl(e,'EVWGKCMMJY');
if (_tracker.goon(ctl,ctrlValue)) {
w_H14A=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('EVWGKCMMJY',0);
if (l_bResult) {
l_bResult=Link_EVWGKCMMJY(kmode);
if ( ! (l_bResult)) {
w_H14A=HtW('','C');
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
function Set_D41(ctrlValue,kmode,e) {
if (Ne(w_D41,ctrlValue)) {
var ctl = _GetCtl(e,'QDVHTXVAEJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_D41=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QDVHTXVAEJ',0);
if (l_bResult) {
l_bResult=Link_QDVHTXVAEJ(kmode);
if ( ! (l_bResult)) {
w_D41=HtW('','C');
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
function Set_F14A(ctrlValue,kmode,e) {
if (Ne(w_F14A,ctrlValue)) {
var ctl = _GetCtl(e,'AYOYZWWHED');
if (_tracker.goon(ctl,ctrlValue)) {
w_F14A=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('AYOYZWWHED',0);
if (l_bResult) {
l_bResult=Link_AYOYZWWHED(kmode);
if ( ! (l_bResult)) {
w_F14A=HtW('','C');
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
function Set_D42(ctrlValue,kmode,e) {
if (Ne(w_D42,ctrlValue)) {
var ctl = _GetCtl(e,'ZZPDVGQXEP');
if (_tracker.goon(ctl,ctrlValue)) {
w_D42=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ZZPDVGQXEP',0);
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
function Set_D43(ctrlValue,kmode,e) {
if (Ne(w_D43,ctrlValue)) {
var ctl = _GetCtl(e,'TCBOHGKRMJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_D43=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('TCBOHGKRMJ',0);
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
function Set_D44(ctrlValue,kmode,e) {
if (Ne(w_D44,ctrlValue)) {
var ctl = _GetCtl(e,'YSHERQEZOZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_D44=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YSHERQEZOZ',0);
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
function Set_F14C(ctrlValue,kmode,e) {
if (Ne(w_F14C,ctrlValue)) {
var ctl = _GetCtl(e,'SBSUVGTSQF');
if (_tracker.goon(ctl,ctrlValue)) {
w_F14C=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SBSUVGTSQF',0);
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
function Set_H13(ctrlValue,kmode,e) {
if (Ne(w_H13,ctrlValue)) {
var ctl = _GetCtl(e,'LMFVWUIXUQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_H13=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('LMFVWUIXUQ',0);
if (l_bResult) {
l_bResult=Link_LMFVWUIXUQ(kmode);
if ( ! (l_bResult)) {
w_H13=HtW('','C');
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
function Set_F14B(ctrlValue,kmode,e) {
if (Ne(w_F14B,ctrlValue)) {
var ctl = _GetCtl(e,'ZKDTAIVYNT');
if (_tracker.goon(ctl,ctrlValue)) {
w_F14B=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ZKDTAIVYNT',0);
if (l_bResult) {
l_bResult=Link_ZKDTAIVYNT(kmode);
if ( ! (l_bResult)) {
w_F14B=HtW('','C');
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
function Set_G45(ctrlValue,kmode,e) {
if (Ne(w_G45,ctrlValue)) {
var ctl = _GetCtl(e,'HCXFFYRBOR');
if (_tracker.goon(ctl,ctrlValue)) {
w_G45=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HCXFFYRBOR',0);
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
function Set_G44(ctrlValue,kmode,e) {
if (Ne(w_G44,ctrlValue)) {
var ctl = _GetCtl(e,'JRWWNQSHYE');
if (_tracker.goon(ctl,ctrlValue)) {
w_G44=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('JRWWNQSHYE',0);
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
function Set_E14A(ctrlValue,kmode,e) {
if (Ne(w_E14A,ctrlValue)) {
var ctl = _GetCtl(e,'IMIPLTLEAA');
if (_tracker.goon(ctl,ctrlValue)) {
w_E14A=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('IMIPLTLEAA',0);
if (l_bResult) {
l_bResult=Link_IMIPLTLEAA(kmode);
if ( ! (l_bResult)) {
w_E14A=HtW('','C');
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
function Set_E14B(ctrlValue,kmode,e) {
if (Ne(w_E14B,ctrlValue)) {
var ctl = _GetCtl(e,'JMWSEEISWG');
if (_tracker.goon(ctl,ctrlValue)) {
w_E14B=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('JMWSEEISWG',0);
if (l_bResult) {
l_bResult=Link_JMWSEEISWG(kmode);
if ( ! (l_bResult)) {
w_E14B=HtW('','C');
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
function Set_H11(ctrlValue,kmode,e) {
if (Ne(w_H11,ctrlValue)) {
var ctl = _GetCtl(e,'LWFUPEVCFF');
if (_tracker.goon(ctl,ctrlValue)) {
w_H11=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('LWFUPEVCFF',0);
if (l_bResult) {
l_bResult=Link_LWFUPEVCFF(kmode);
if ( ! (l_bResult)) {
w_H11=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',70,0,''));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',70,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_H42(ctrlValue,kmode,e) {
if (Ne(w_H42,ctrlValue)) {
var ctl = _GetCtl(e,'EVIOJXHHYZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_H42=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('EVIOJXHHYZ',0);
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
function Set_E16(ctrlValue,kmode,e) {
if (Ne(w_E16,ctrlValue)) {
var ctl = _GetCtl(e,'CSJKLGPLSD');
if (_tracker.goon(ctl,ctrlValue)) {
w_E16=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CSJKLGPLSD',0);
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
function Set_F16(ctrlValue,kmode,e) {
if (Ne(w_F16,ctrlValue)) {
var ctl = _GetCtl(e,'CSKIGUYWKA');
if (_tracker.goon(ctl,ctrlValue)) {
w_F16=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CSKIGUYWKA',0);
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
function Set_G43(ctrlValue,kmode,e) {
if (Ne(w_G43,ctrlValue)) {
var ctl = _GetCtl(e,'NVUUMCKUPB');
if (_tracker.goon(ctl,ctrlValue)) {
w_G43=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NVUUMCKUPB',0);
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
function Set_F15(ctrlValue,kmode,e) {
if (Ne(w_F15,ctrlValue)) {
var ctl = _GetCtl(e,'TFVSJQEFKN');
if (_tracker.goon(ctl,ctrlValue)) {
w_F15=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('TFVSJQEFKN',0);
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
function Set_G42(ctrlValue,kmode,e) {
if (Ne(w_G42,ctrlValue)) {
var ctl = _GetCtl(e,'KTOZCJXWSV');
if (_tracker.goon(ctl,ctrlValue)) {
w_G42=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('KTOZCJXWSV',0);
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
function Set_G41(ctrlValue,kmode,e) {
if (Ne(w_G41,ctrlValue)) {
var ctl = _GetCtl(e,'BCOSCDETUR');
if (_tracker.goon(ctl,ctrlValue)) {
w_G41=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BCOSCDETUR',0);
if (l_bResult) {
l_bResult=Link_BCOSCDETUR(kmode);
if ( ! (l_bResult)) {
w_G41=HtW('','C');
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
function Set_G19B(ctrlValue,kmode,e) {
if (Ne(w_G19B,ctrlValue)) {
var ctl = _GetCtl(e,'HKGGYHAADA');
if (_tracker.goon(ctl,ctrlValue)) {
w_G19B=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HKGGYHAADA',0);
if (l_bResult) {
l_bResult=Link_HKGGYHAADA(kmode);
if ( ! (l_bResult)) {
w_G19B=HtW('','C');
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
function Set_G19A(ctrlValue,kmode,e) {
if (Ne(w_G19A,ctrlValue)) {
var ctl = _GetCtl(e,'GSZGYDPMMI');
if (_tracker.goon(ctl,ctrlValue)) {
w_G19A=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('GSZGYDPMMI',0);
if (l_bResult) {
l_bResult=Link_GSZGYDPMMI(kmode);
if ( ! (l_bResult)) {
w_G19A=HtW('','C');
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
function Set_E43(ctrlValue,kmode,e) {
if (Ne(w_E43,ctrlValue)) {
var ctl = _GetCtl(e,'YTZBMCKQSI');
if (_tracker.goon(ctl,ctrlValue)) {
w_E43=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YTZBMCKQSI',0);
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
function Set_E44(ctrlValue,kmode,e) {
if (Ne(w_E44,ctrlValue)) {
var ctl = _GetCtl(e,'YQCFUVRDIB');
if (_tracker.goon(ctl,ctrlValue)) {
w_E44=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YQCFUVRDIB',0);
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
function Set_E45(ctrlValue,kmode,e) {
if (Ne(w_E45,ctrlValue)) {
var ctl = _GetCtl(e,'RZGRAAMFRQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_E45=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RZGRAAMFRQ',0);
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
function Set_F17(ctrlValue,kmode,e) {
if (Ne(w_F17,ctrlValue)) {
var ctl = _GetCtl(e,'EWALMUXONU');
if (_tracker.goon(ctl,ctrlValue)) {
w_F17=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('EWALMUXONU',0);
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
function Set_G18(ctrlValue,kmode,e) {
if (Ne(w_G18,ctrlValue)) {
var ctl = _GetCtl(e,'HICXAQROVP');
if (_tracker.goon(ctl,ctrlValue)) {
w_G18=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HICXAQROVP',0);
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
function Set_G17(ctrlValue,kmode,e) {
if (Ne(w_G17,ctrlValue)) {
var ctl = _GetCtl(e,'IMPXVWAVVG');
if (_tracker.goon(ctl,ctrlValue)) {
w_G17=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('IMPXVWAVVG',0);
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
function Set_G16(ctrlValue,kmode,e) {
if (Ne(w_G16,ctrlValue)) {
var ctl = _GetCtl(e,'ALVPQNRJEQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_G16=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ALVPQNRJEQ',0);
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
function Set_G15(ctrlValue,kmode,e) {
if (Ne(w_G15,ctrlValue)) {
var ctl = _GetCtl(e,'YPHNWWQBAM');
if (_tracker.goon(ctl,ctrlValue)) {
w_G15=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YPHNWWQBAM',0);
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
function Set_G14C(ctrlValue,kmode,e) {
if (Ne(w_G14C,ctrlValue)) {
var ctl = _GetCtl(e,'YZZZVPGQXU');
if (_tracker.goon(ctl,ctrlValue)) {
w_G14C=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YZZZVPGQXU',0);
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
function Set_G14B(ctrlValue,kmode,e) {
if (Ne(w_G14B,ctrlValue)) {
var ctl = _GetCtl(e,'RZOPLJQQOD');
if (_tracker.goon(ctl,ctrlValue)) {
w_G14B=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RZOPLJQQOD',0);
if (l_bResult) {
l_bResult=Link_RZOPLJQQOD(kmode);
if ( ! (l_bResult)) {
w_G14B=HtW('','C');
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
function Set_G14A(ctrlValue,kmode,e) {
if (Ne(w_G14A,ctrlValue)) {
var ctl = _GetCtl(e,'IZFSEEEELX');
if (_tracker.goon(ctl,ctrlValue)) {
w_G14A=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('IZFSEEEELX',0);
if (l_bResult) {
l_bResult=Link_IZFSEEEELX(kmode);
if ( ! (l_bResult)) {
w_G14A=HtW('','C');
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
function Set_G13(ctrlValue,kmode,e) {
if (Ne(w_G13,ctrlValue)) {
var ctl = _GetCtl(e,'NMVYSCDEYI');
if (_tracker.goon(ctl,ctrlValue)) {
w_G13=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NMVYSCDEYI',0);
if (l_bResult) {
l_bResult=Link_NMVYSCDEYI(kmode);
if ( ! (l_bResult)) {
w_G13=HtW('','C');
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
function Set_G11(ctrlValue,kmode,e) {
if (Ne(w_G11,ctrlValue)) {
var ctl = _GetCtl(e,'PGAPCLKWDU');
if (_tracker.goon(ctl,ctrlValue)) {
w_G11=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('PGAPCLKWDU',0);
if (l_bResult) {
l_bResult=Link_PGAPCLKWDU(kmode);
if ( ! (l_bResult)) {
w_G11=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',70,0,''));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',70,0,'');
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
w_richieste=arfn_calcrichieste();
w_richieste=arfn_calcrichieste();
if ((Ne(o_A01A,w_A01A)) || (Ne(o_A01B,w_A01B)) || (Ne(o_A03,w_A03)) || (Ne(o_A11,w_A11)) || (Ne(o_A12A,w_A12A)) || (Ne(o_A12B,w_A12B)) || (Ne(o_A12C,w_A12C)) || (Ne(o_A21,w_A21)) || (Ne(o_A22,w_A22)) || (Ne(o_A23,w_A23)) || (Ne(o_A24,w_A24)) || (Ne(o_A25,w_A25)) || (Ne(o_A31A,w_A31A)) || (Ne(o_A31B,w_A31B)) || (Ne(o_A32,w_A32)) || (Ne(o_A33A,w_A33A)) || (Ne(o_A33B,w_A33B)) || (Ne(o_A33C,w_A33C)) || (Ne(o_A34,w_A34)) || (Ne(o_A41,w_A41)) || (Ne(o_A42,w_A42)) || (Ne(o_A43,w_A43)) || (Ne(o_A51,w_A51)) || (Ne(o_A52B,w_A52B)) || (Ne(o_A53,w_A53)) || (Ne(o_A54A,w_A54A)) || (Ne(o_A54B,w_A54B)) || (Ne(o_A54C,w_A54C))) {
Calculation_GVCWPKTNNX();
}
if ((Ne(o_B11,w_B11)) || (Ne(o_B12,w_B12)) || (Ne(o_B13,w_B13)) || (Ne(o_B14,w_B14)) || (Ne(o_B15,w_B15))) {
Calculation_EESAJLEDWN();
}
if ((Ne(o_C11,w_C11)) || (Ne(o_C21,w_C21)) || (Ne(o_C31,w_C31))) {
Calculation_FJFTKXLIZC();
}
if ((Ne(o_D11,w_D11)) || (Ne(o_D13,w_D13)) || (Ne(o_D14A,w_D14A)) || (Ne(o_D14B,w_D14B)) || (Ne(o_D14C,w_D14C)) || (Ne(o_D15,w_D15)) || (Ne(o_D16,w_D16)) || (Ne(o_D17,w_D17)) || (Ne(o_D18,w_D18)) || (Ne(o_D19A,w_D19A)) || (Ne(o_D19B,w_D19B)) || (Ne(o_D21,w_D21)) || (Ne(o_D22,w_D22)) || (Ne(o_D23,w_D23)) || (Ne(o_D41,w_D41)) || (Ne(o_D42,w_D42)) || (Ne(o_D43,w_D43)) || (Ne(o_D44,w_D44)) || (Ne(o_D45,w_D45))) {
Calculation_EYYAIMKLHZ();
}
if ((Ne(o_E11,w_E11)) || (Ne(o_E13,w_E13)) || (Ne(o_E14A,w_E14A)) || (Ne(o_E14B,w_E14B)) || (Ne(o_E14C,w_E14C)) || (Ne(o_E15,w_E15)) || (Ne(o_E16,w_E16)) || (Ne(o_E17,w_E17)) || (Ne(o_E18,w_E18)) || (Ne(o_E19A,w_E19A)) || (Ne(o_E19B,w_E19B)) || (Ne(o_E41,w_E41)) || (Ne(o_E42,w_E42)) || (Ne(o_E43,w_E43)) || (Ne(o_E44,w_E44)) || (Ne(o_E45,w_E45))) {
Calculation_ZEWSTZRNRJ();
}
if ((Ne(o_F11,w_F11)) || (Ne(o_F13,w_F13)) || (Ne(o_F14A,w_F14A)) || (Ne(o_F14B,w_F14B)) || (Ne(o_F14C,w_F14C)) || (Ne(o_F15,w_F15)) || (Ne(o_F16,w_F16)) || (Ne(o_F17,w_F17))) {
Calculation_USMDNVRTKQ();
}
if ((Ne(o_G11,w_G11)) || (Ne(o_G13,w_G13)) || (Ne(o_G14A,w_G14A)) || (Ne(o_G14B,w_G14B)) || (Ne(o_G14C,w_G14C)) || (Ne(o_G15,w_G15)) || (Ne(o_G16,w_G16)) || (Ne(o_G17,w_G17)) || (Ne(o_G18,w_G18)) || (Ne(o_G19A,w_G19A)) || (Ne(o_G19B,w_G19B)) || (Ne(o_G41,w_G41)) || (Ne(o_G42,w_G42)) || (Ne(o_G43,w_G43)) || (Ne(o_G44,w_G44)) || (Ne(o_G45,w_G45))) {
Calculation_NBJTNIKNNE();
}
if ((Ne(o_H11,w_H11)) || (Ne(o_H13,w_H13)) || (Ne(o_H14A,w_H14A)) || (Ne(o_H14B,w_H14B)) || (Ne(o_H14C,w_H14C)) || (Ne(o_H15,w_H15)) || (Ne(o_H16,w_H16)) || (Ne(o_H17,w_H17)) || (Ne(o_H18,w_H18)) || (Ne(o_H19A,w_H19A)) || (Ne(o_H19B,w_H19B)) || (Ne(o_H41,w_H41)) || (Ne(o_H42,w_H42)) || (Ne(o_H43,w_H43)) || (Ne(o_H44,w_H44)) || (Ne(o_H45,w_H45))) {
Calculation_VTXVTSADBW();
}
LibJavascript.forEachItem(m_FoundlingCopyWorkVar,i_body_1)
function i_body_1(child){
child();
}
// * --- Area Manuale = UI - Calculate
// * --- armt_ricercamassa
// Calcola il numero di condizioni inserite
if ((Ne(o_A01A,w_A01A)) || (Ne(o_A01B,w_A01B)) || (Ne(o_A03,w_A03)) || (Ne(o_A11,w_A11)) || (Ne(o_A12A,w_A12A)) || (Ne(o_A12B,w_A12B)) || (Ne(o_A12C,w_A12C)) || (Ne(o_A21,w_A21)) || (Ne(o_A22,w_A22)) || (Ne(o_A23,w_A23)) || (Ne(o_A24,w_A24)) || (Ne(o_A25,w_A25)) || (Ne(o_A31A,w_A31A)) || (Ne(o_A31B,w_A31B)) || (Ne(o_A32,w_A32)) || (Ne(o_A33A,w_A33A)) || (Ne(o_A33B,w_A33B)) || (Ne(o_A33C,w_A33C)) || (Ne(o_A34,w_A34)) || (Ne(o_A41,w_A41)) || (Ne(o_A42,w_A42)) || (Ne(o_A43,w_A43)) || (Ne(o_A51,w_A51)) || (Ne(o_A52B,w_A52B)) || (Ne(o_A54A,w_A54A)) || (Ne(o_A54B,w_A54B)) || (Ne(o_A54C,w_A54C))) {
  LibreriaMit.CalcCond(o_A01A,w_A01A)
  LibreriaMit.CalcCond(o_A01B,w_A01B)
  LibreriaMit.CalcCond(o_A03,w_A03)
  LibreriaMit.CalcCond(o_A11,w_A11)
  LibreriaMit.CalcCond(o_A12A,w_A12A)
  LibreriaMit.CalcCond(o_A12B,w_A12B)
  LibreriaMit.CalcCond(o_A12C,w_A12C)
  LibreriaMit.CalcCond(o_A21,w_A21)
  LibreriaMit.CalcCond(o_A22,w_A22)
  LibreriaMit.CalcCond(o_A23,w_A23)
  LibreriaMit.CalcCond(o_A24,w_A24)
  LibreriaMit.CalcCond(o_A25,w_A25)
  LibreriaMit.CalcCond(o_A31A,w_A31A)
  LibreriaMit.CalcCond(o_A31B,w_A31B)
  LibreriaMit.CalcCond(o_A32,w_A32)
  LibreriaMit.CalcCond(o_A33A,w_A33A)
  LibreriaMit.CalcCond(o_A33B,w_A33B)
  LibreriaMit.CalcCond(o_A33C,w_A33C)
  LibreriaMit.CalcCond(o_A34,w_A34)
  LibreriaMit.CalcCond(o_A41,w_A41)
  LibreriaMit.CalcCond(o_A42,w_A42)
  LibreriaMit.CalcCond(o_A43,w_A43)
  LibreriaMit.CalcCond(o_A51,w_A51)
  LibreriaMit.CalcCond(o_A52B,w_A52B)
  LibreriaMit.CalcCond(o_A53,w_A53)
  LibreriaMit.CalcCond(o_A54A,w_A54A)
  LibreriaMit.CalcCond(o_A54B,w_A54B)
  LibreriaMit.CalcCond(o_A54C,w_A54C)
}
if ((Ne(o_B11,w_B11)) || (Ne(o_B12,w_B12)) || (Ne(o_B13,w_B13)) || (Ne(o_B14,w_B14)) || (Ne(o_B15,w_B15))) {
  LibreriaMit.CalcCond(o_B11,w_B11)
  LibreriaMit.CalcCond(o_B12,w_B12)
  LibreriaMit.CalcCond(o_B13,w_B13)
  LibreriaMit.CalcCond(o_B14,w_B14)
  LibreriaMit.CalcCond(o_B15,w_B15)
}
if ((Ne(o_C11,w_C11)) || (Ne(o_C21,w_C21)) || (Ne(o_C31,w_C31)) || (Ne(o_C41,w_C41)) || (Ne(o_C51,w_C51))) {
  LibreriaMit.CalcCond(o_C11,w_C11)
  LibreriaMit.CalcCond(o_C21,w_C21)
  LibreriaMit.CalcCond(o_C31,w_C31)
  LibreriaMit.CalcCond(o_C41,w_C41)  
  LibreriaMit.CalcCond(o_C51,w_C51)  
}
if ((Ne(o_D11,w_D11)) || (Ne(o_D13,w_D13)) || (Ne(o_D14A,w_D14A)) || (Ne(o_D14B,w_D14B)) || (Ne(o_D14C,w_D14C)) || (Ne(o_D15,w_D15)) || (Ne(o_D16,w_D16)) || (Ne(o_D17,w_D17)) || (Ne(o_D18,w_D18)) || (Ne(o_D19A,w_D19A)) || (Ne(o_D19B,w_D19B)) || (Ne(o_D21,w_D21)) || (Ne(o_D22,w_D22)) || (Ne(o_D23,w_D23)) || (Ne(o_D41,w_D41)) || (Ne(o_D42,w_D42)) || (Ne(o_D43,w_D43)) || (Ne(o_D44,w_D44)) || (Ne(o_D45,w_D45))) {
  LibreriaMit.CalcCond(o_D11,w_D11)
  LibreriaMit.CalcCond(o_D13,w_D13)
  LibreriaMit.CalcCond(o_D14A,w_D14A)
  LibreriaMit.CalcCond(o_D14B,w_D14B)
  LibreriaMit.CalcCond(o_D14C,w_D14C)
  LibreriaMit.CalcCond(o_D15,w_D15)
  LibreriaMit.CalcCond(o_D16,w_D16)
  LibreriaMit.CalcCond(o_D17,w_D17)
  LibreriaMit.CalcCond(o_D18,w_D18)
  LibreriaMit.CalcCond(o_D19A,w_D19B)
  LibreriaMit.CalcCond(o_D19B,w_D19B)
  LibreriaMit.CalcCond(o_D21,w_D21)
  LibreriaMit.CalcCond(o_D22,w_D22)
  LibreriaMit.CalcCond(o_D23,w_D23)
  LibreriaMit.CalcCond(o_D41,w_D41)
  LibreriaMit.CalcCond(o_D42,w_D42)
  LibreriaMit.CalcCond(o_D43,w_D43)
  LibreriaMit.CalcCond(o_D44,w_D44)
  LibreriaMit.CalcCond(o_D45,w_D45)  
}
if ((Ne(o_E11,w_E11)) || (Ne(o_E13,w_E13)) || (Ne(o_E14A,w_E14A)) || (Ne(o_E14B,w_E14B)) || (Ne(o_E14C,w_E14C)) || (Ne(o_E15,w_E15)) || (Ne(o_E16,w_E16)) || (Ne(o_E17,w_E17)) || (Ne(o_E18,w_E18)) || (Ne(o_E19A,w_E19A)) || (Ne(o_E19B,w_E19B)) || (Ne(o_E41,w_E41)) || (Ne(o_E42,w_E42)) || (Ne(o_E43,w_E43)) || (Ne(o_E44,w_E44)) || (Ne(o_E45,w_E45))) {
  LibreriaMit.CalcCond(o_E11,w_E11)
  LibreriaMit.CalcCond(o_E13,w_E13)
  LibreriaMit.CalcCond(o_E14A,w_E14A)
  LibreriaMit.CalcCond(o_E14B,w_E14B)
  LibreriaMit.CalcCond(o_E14C,w_E14C)
  LibreriaMit.CalcCond(o_E15,w_E15)
  LibreriaMit.CalcCond(o_E16,w_E16)
  LibreriaMit.CalcCond(o_E17,w_E17)
  LibreriaMit.CalcCond(o_E18,w_E18)
  LibreriaMit.CalcCond(o_E19A,w_E19A)
  LibreriaMit.CalcCond(o_E19B,w_E19B)  
  LibreriaMit.CalcCond(o_E41,w_E41)
  LibreriaMit.CalcCond(o_E42,w_E42)
  LibreriaMit.CalcCond(o_E43,w_E43)
  LibreriaMit.CalcCond(o_E44,w_E44)
  LibreriaMit.CalcCond(o_E45,w_E45)
}
if ((Ne(o_F11,w_F11)) || (Ne(o_F13,w_F13)) || (Ne(o_F14A,w_F14A)) || (Ne(o_F14B,w_F14B)) || (Ne(o_F14C,w_F14C)) || (Ne(o_F15,w_F15)) || (Ne(o_F16,w_F16)) || (Ne(o_F17,w_F17))) {
  LibreriaMit.CalcCond(o_F11,w_F11)
  LibreriaMit.CalcCond(o_F13,w_F13)
  LibreriaMit.CalcCond(o_F14A,w_F14A)
  LibreriaMit.CalcCond(o_F14B,w_F14B)
  LibreriaMit.CalcCond(o_F14C,w_F14C)
  LibreriaMit.CalcCond(o_F15,w_F15)
  LibreriaMit.CalcCond(o_F16,w_F16)
  LibreriaMit.CalcCond(o_F17,w_F17)
}
if ((Ne(o_G11,w_G11)) || (Ne(o_G13,w_G13)) || (Ne(o_G14A,w_G14A)) || (Ne(o_G14B,w_G14B)) || (Ne(o_G14C,w_G14C)) || (Ne(o_G15,w_G15)) || (Ne(o_G16,w_G16)) || (Ne(o_G17,w_G17)) || (Ne(o_G18,w_G18)) || (Ne(o_G19A,w_G19A)) || (Ne(o_G19B,w_G19B)) || (Ne(o_G41,w_G41)) || (Ne(o_G42,w_G42)) || (Ne(o_G43,w_G43)) || (Ne(o_G44,w_G44)) || (Ne(o_G45,w_G45))) {
  LibreriaMit.CalcCond(o_G11,w_G11)
  LibreriaMit.CalcCond(o_G13,w_G13)
  LibreriaMit.CalcCond(o_G14A,w_G14A)
  LibreriaMit.CalcCond(o_G14B,w_G14B)
  LibreriaMit.CalcCond(o_G14C,w_G14C)
  LibreriaMit.CalcCond(o_G15,w_G15)
  LibreriaMit.CalcCond(o_G16,w_G16)
  LibreriaMit.CalcCond(o_G17,w_G17)
  LibreriaMit.CalcCond(o_G18,w_G18)
  LibreriaMit.CalcCond(o_G19A,w_G19A)
  LibreriaMit.CalcCond(o_G19B,w_G19B)  
  LibreriaMit.CalcCond(o_G41,w_G41)
  LibreriaMit.CalcCond(o_G42,w_G42)
  LibreriaMit.CalcCond(o_G43,w_G43)
  LibreriaMit.CalcCond(o_G44,w_G44)
  LibreriaMit.CalcCond(o_G45,w_G45)  
}

if ((Ne(o_H11,w_H11)) || (Ne(o_H13,w_H13)) || (Ne(o_H14A,w_H14A)) || (Ne(o_H14B,w_H14B)) || (Ne(o_H14C,w_H14C)) || (Ne(o_H15,w_H15)) || (Ne(o_H16,w_H16)) || (Ne(o_H17,w_H17)) || (Ne(o_H18,w_H18)) || (Ne(o_H19A,w_H19A)) || (Ne(o_H19B,w_H19B)) || (Ne(o_H41,w_H41)) || (Ne(o_H42,w_H42)) || (Ne(o_H43,w_H43)) || (Ne(o_H44,w_H44)) || (Ne(o_H45,w_H45))) {
  LibreriaMit.CalcCond(o_H11,w_H11)
  LibreriaMit.CalcCond(o_H13,w_H13)
  LibreriaMit.CalcCond(o_H14A,w_H14A)
  LibreriaMit.CalcCond(o_H14B,w_H14B)
  LibreriaMit.CalcCond(o_H14C,w_H14C)
  LibreriaMit.CalcCond(o_H15,w_H15)
  LibreriaMit.CalcCond(o_H16,w_H16)
  LibreriaMit.CalcCond(o_H17,w_H17)
  LibreriaMit.CalcCond(o_H18,w_H18)
  LibreriaMit.CalcCond(o_H19A,w_H19A)
  LibreriaMit.CalcCond(o_H19B,w_H19B)  
  LibreriaMit.CalcCond(o_H41,w_H41)
  LibreriaMit.CalcCond(o_H42,w_H42)
  LibreriaMit.CalcCond(o_H43,w_H43)
  LibreriaMit.CalcCond(o_H44,w_H44)
  LibreriaMit.CalcCond(o_H45,w_H45)  
}
// * --- Fine Area Manuale
UpdateAutonumber('');
m_bCalculating=false;
}
function Calculation_NBJTNIKNNE() {
w_oldval='S';
}
function Calculation_USMDNVRTKQ() {
w_oldval='S';
}
function Calculation_ZEWSTZRNRJ() {
w_oldval='S';
}
function Calculation_EYYAIMKLHZ() {
w_oldval='S';
}
function Calculation_FJFTKXLIZC() {
w_oldval='S';
}
function Calculation_EESAJLEDWN() {
w_oldval='S';
}
function Calculation_GVCWPKTNNX() {
w_oldval='S';
}
function Calculation_VTXVTSADBW() {
w_oldval='S';
}
function SaveDependsOn() {
o_A01A=w_A01A;
o_A01B=w_A01B;
o_A03=w_A03;
o_A11=w_A11;
o_A12A=w_A12A;
o_A12B=w_A12B;
o_A12C=w_A12C;
o_A21=w_A21;
o_A22=w_A22;
o_A23=w_A23;
o_A24=w_A24;
o_A25=w_A25;
o_A31A=w_A31A;
o_A31B=w_A31B;
o_A32=w_A32;
o_A33A=w_A33A;
o_A33B=w_A33B;
o_A33C=w_A33C;
o_A34=w_A34;
o_A41=w_A41;
o_A42=w_A42;
o_A43=w_A43;
o_A51=w_A51;
o_A52B=w_A52B;
o_A53=w_A53;
o_A54A=w_A54A;
o_A54B=w_A54B;
o_A54C=w_A54C;
o_B11=w_B11;
o_B12=w_B12;
o_B13=w_B13;
o_B14=w_B14;
o_B15=w_B15;
o_C11=w_C11;
o_C21=w_C21;
o_C31=w_C31;
o_D11=w_D11;
o_D13=w_D13;
o_D14A=w_D14A;
o_D14B=w_D14B;
o_D14C=w_D14C;
o_D15=w_D15;
o_D16=w_D16;
o_D17=w_D17;
o_D18=w_D18;
o_D19A=w_D19A;
o_D19B=w_D19B;
o_D21=w_D21;
o_D22=w_D22;
o_D23=w_D23;
o_D41=w_D41;
o_D42=w_D42;
o_D43=w_D43;
o_D44=w_D44;
o_D45=w_D45;
o_E11=w_E11;
o_E13=w_E13;
o_E14A=w_E14A;
o_E14B=w_E14B;
o_E14C=w_E14C;
o_E15=w_E15;
o_E16=w_E16;
o_E17=w_E17;
o_E18=w_E18;
o_E19A=w_E19A;
o_E19B=w_E19B;
o_E41=w_E41;
o_E42=w_E42;
o_E43=w_E43;
o_E44=w_E44;
o_E45=w_E45;
o_F11=w_F11;
o_F13=w_F13;
o_F14A=w_F14A;
o_F14B=w_F14B;
o_F14C=w_F14C;
o_F15=w_F15;
o_F16=w_F16;
o_F17=w_F17;
o_G11=w_G11;
o_G13=w_G13;
o_G14A=w_G14A;
o_G14B=w_G14B;
o_G14C=w_G14C;
o_G15=w_G15;
o_G16=w_G16;
o_G17=w_G17;
o_G18=w_G18;
o_G19A=w_G19A;
o_G19B=w_G19B;
o_G41=w_G41;
o_G42=w_G42;
o_G43=w_G43;
o_G44=w_G44;
o_G45=w_G45;
o_H11=w_H11;
o_H13=w_H13;
o_H14A=w_H14A;
o_H14B=w_H14B;
o_H14C=w_H14C;
o_H15=w_H15;
o_H16=w_H16;
o_H17=w_H17;
o_H18=w_H18;
o_H19A=w_H19A;
o_H19B=w_H19B;
o_H41=w_H41;
o_H42=w_H42;
o_H43=w_H43;
o_H44=w_H44;
o_H45=w_H45;
}
function SaveLabelDependsOn() {
}
function Link_TIPXBDXITE(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_A01B);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODINTER',w_A01B,11,0);
l_Appl.SetFields('CODINTER,RAGSOC');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('intermbo');
l_Appl.SetID('TIPXBDXITE');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_A01B=l_Appl.GetStringValue('CODINTER',11,0);
w_xraginter=l_Appl.GetStringValue('RAGSOC',70,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_TIPXBDXITE_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_TIPXBDXITE';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_TIPXBDXITE();
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
function Link_TIPXBDXITE_Blank() {
w_A01B='';
w_xraginter='';
}
function LOpt_TIPXBDXITE() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('intermbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODINTER','C'));
l_oWv.setValue('LinkedField',WtA('CODINTER','C'));
l_oWv.setValue('UID',WtA('TIPXBDXITE','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['TIPXBDXITE'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('11404054622'),'C'));
return l_oWv;
}
function Link_BQNMQAOIPA(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_A11);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODDIP',w_A11,6,0);
l_Appl.SetFields('CODDIP,DESCRIZ');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('anadip');
l_Appl.SetID('BQNMQAOIPA');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_A11=l_Appl.GetStringValue('CODDIP',6,0);
w_xdesdip=l_Appl.GetStringValue('DESCRIZ',30,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_BQNMQAOIPA_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_BQNMQAOIPA';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_BQNMQAOIPA();
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
function Link_BQNMQAOIPA_Blank() {
w_A11='';
w_xdesdip='';
}
function LOpt_BQNMQAOIPA() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('anadip','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODDIP','C'));
l_oWv.setValue('LinkedField',WtA('CODDIP','C'));
l_oWv.setValue('UID',WtA('BQNMQAOIPA','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['BQNMQAOIPA'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('1270140318'),'C'));
return l_oWv;
}
function Link_XHIBDWLIOD(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_A12A);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CAB',w_A12A,6,0);
l_Appl.SetFields('CAB');
l_Appl.SetTypes('C');
l_Appl.LinkTable('tbcitta');
l_Appl.SetID('XHIBDWLIOD');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_A12A=l_Appl.GetStringValue('CAB',6,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_XHIBDWLIOD_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_XHIBDWLIOD';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_XHIBDWLIOD();
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
function Link_XHIBDWLIOD_Blank() {
w_A12A='';
}
function LOpt_XHIBDWLIOD() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcitta','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CAB','C'));
l_oWv.setValue('LinkedField',WtA('CAB','C'));
l_oWv.setValue('UID',WtA('XHIBDWLIOD','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['XHIBDWLIOD'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('6863571'),'C'));
return l_oWv;
}
function Link_IFYLHOXPRS(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_A12B);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CITTA',w_A12B,30,0);
l_Appl.SetFields('CITTA');
l_Appl.SetTypes('C');
l_Appl.LinkTable('tbcitta');
l_Appl.SetID('IFYLHOXPRS');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_A12B=l_Appl.GetStringValue('CITTA',30,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_IFYLHOXPRS_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_IFYLHOXPRS';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_IFYLHOXPRS();
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
function Link_IFYLHOXPRS_Blank() {
w_A12B='';
}
function LOpt_IFYLHOXPRS() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcitta','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CITTA','C'));
l_oWv.setValue('LinkedField',WtA('CITTA','C'));
l_oWv.setValue('UID',WtA('IFYLHOXPRS','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['IFYLHOXPRS'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('15186643'),'C'));
return l_oWv;
}
function Link_CKACALWZOL(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_A24);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODCAU',w_A24,4,0);
l_Appl.SetFields('CODCAU');
l_Appl.SetTypes('C');
l_Appl.LinkTable('tbcauana');
l_Appl.SetID('CKACALWZOL');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_A24=l_Appl.GetStringValue('CODCAU',4,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_CKACALWZOL_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_CKACALWZOL';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_CKACALWZOL();
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
function Link_CKACALWZOL_Blank() {
w_A24='';
}
function LOpt_CKACALWZOL() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcauana','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODCAU','C'));
l_oWv.setValue('LinkedField',WtA('CODCAU','C'));
l_oWv.setValue('UID',WtA('CKACALWZOL','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['CKACALWZOL'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('215536597'),'C'));
return l_oWv;
}
function Link_ZIMEUPPLZY(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_A25);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODVOC',w_A25,2,0);
l_Appl.SetFields('CODVOC');
l_Appl.SetTypes('C');
l_Appl.LinkTable('tbcausin');
l_Appl.SetID('ZIMEUPPLZY');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_A25=l_Appl.GetStringValue('CODVOC',2,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_ZIMEUPPLZY_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_ZIMEUPPLZY';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_ZIMEUPPLZY();
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
function Link_ZIMEUPPLZY_Blank() {
w_A25='';
}
function LOpt_ZIMEUPPLZY() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcausin','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODVOC','C'));
l_oWv.setValue('LinkedField',WtA('CODVOC','C'));
l_oWv.setValue('UID',WtA('ZIMEUPPLZY','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['ZIMEUPPLZY'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('215310487'),'C'));
return l_oWv;
}
function Link_ZZQPEDWGCO(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_A31B);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODINTER',w_A31B,10,0);
l_Appl.SetFields('CODINTER');
l_Appl.SetTypes('C');
l_Appl.LinkTable('inter2bo');
l_Appl.SetID('ZZQPEDWGCO');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_A31B=l_Appl.GetStringValue('CODINTER',10,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_ZZQPEDWGCO_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_ZZQPEDWGCO';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_ZZQPEDWGCO();
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
function Link_ZZQPEDWGCO_Blank() {
w_A31B='';
}
function LOpt_ZZQPEDWGCO() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('inter2bo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODINTER','C'));
l_oWv.setValue('LinkedField',WtA('CODINTER','C'));
l_oWv.setValue('UID',WtA('ZZQPEDWGCO','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['ZZQPEDWGCO'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('10886683082'),'C'));
return l_oWv;
}
function Link_LTUCQORMSA(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_A32);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODSTA',w_A32,3,0);
l_Appl.SetFields('CODSTA');
l_Appl.SetTypes('C');
l_Appl.LinkTable('tbstati');
l_Appl.SetID('LTUCQORMSA');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_A32=l_Appl.GetStringValue('CODSTA',3,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_LTUCQORMSA_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_LTUCQORMSA';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_LTUCQORMSA();
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
function Link_LTUCQORMSA_Blank() {
w_A32='';
}
function LOpt_LTUCQORMSA() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstati','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODSTA','C'));
l_oWv.setValue('LinkedField',WtA('CODSTA','C'));
l_oWv.setValue('UID',WtA('LTUCQORMSA','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['LTUCQORMSA'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('7383187'),'C'));
return l_oWv;
}
function Link_VDWEKDDBOW(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_A33A);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CAB',w_A33A,6,0);
l_Appl.SetFields('CAB');
l_Appl.SetTypes('C');
l_Appl.LinkTable('tbcitta');
l_Appl.SetID('VDWEKDDBOW');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_A33A=l_Appl.GetStringValue('CAB',6,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_VDWEKDDBOW_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_VDWEKDDBOW';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_VDWEKDDBOW();
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
function Link_VDWEKDDBOW_Blank() {
w_A33A='';
}
function LOpt_VDWEKDDBOW() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcitta','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CAB','C'));
l_oWv.setValue('LinkedField',WtA('CAB','C'));
l_oWv.setValue('UID',WtA('VDWEKDDBOW','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['VDWEKDDBOW'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('6863571'),'C'));
return l_oWv;
}
function Link_BICDANUWZD(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_A33B);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CITTA',w_A33B,30,0);
l_Appl.SetFields('CITTA');
l_Appl.SetTypes('C');
l_Appl.LinkTable('tbcitta');
l_Appl.SetID('BICDANUWZD');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_A33B=l_Appl.GetStringValue('CITTA',30,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_BICDANUWZD_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_BICDANUWZD';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_BICDANUWZD();
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
function Link_BICDANUWZD_Blank() {
w_A33B='';
}
function LOpt_BICDANUWZD() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcitta','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CITTA','C'));
l_oWv.setValue('LinkedField',WtA('CITTA','C'));
l_oWv.setValue('UID',WtA('BICDANUWZD','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['BICDANUWZD'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('15186643'),'C'));
return l_oWv;
}
function Link_HDIAJDVNVI(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_A41);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('RAPPORTO',w_A41,25,0);
l_Appl.SetFields('RAPPORTO,DESCRAP');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('anarapbo');
l_Appl.SetID('HDIAJDVNVI');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_A41=l_Appl.GetStringValue('RAPPORTO',25,0);
w_xdesrap=l_Appl.GetStringValue('DESCRAP',50,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_HDIAJDVNVI_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_HDIAJDVNVI';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_HDIAJDVNVI();
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
function Link_HDIAJDVNVI_Blank() {
w_A41='';
w_xdesrap='';
}
function LOpt_HDIAJDVNVI() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('anarapbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('RAPPORTO','C'));
l_oWv.setValue('LinkedField',WtA('RAPPORTO','C'));
l_oWv.setValue('UID',WtA('HDIAJDVNVI','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['HDIAJDVNVI'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('10787309997'),'C'));
return l_oWv;
}
function Link_RQJLOLNIHM(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_A42);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('TIPONAT',w_A42,1,0);
l_Appl.SetFields('TIPONAT');
l_Appl.SetTypes('C');
l_Appl.LinkTable('tbtipnat');
l_Appl.SetID('RQJLOLNIHM');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_A42=l_Appl.GetStringValue('TIPONAT',1,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_RQJLOLNIHM_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_RQJLOLNIHM';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_RQJLOLNIHM();
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
function Link_RQJLOLNIHM_Blank() {
w_A42='';
}
function LOpt_RQJLOLNIHM() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbtipnat','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('TIPONAT','C'));
l_oWv.setValue('LinkedField',WtA('TIPONAT','C'));
l_oWv.setValue('UID',WtA('RQJLOLNIHM','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['RQJLOLNIHM'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('1723736132'),'C'));
return l_oWv;
}
function Link_CHJJABTJCS(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_A43);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('TIPLEG',w_A43,1,0);
l_Appl.SetFields('TIPLEG,DESCRIZ');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbtipleg');
l_Appl.SetID('CHJJABTJCS');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_A43=l_Appl.GetStringValue('TIPLEG',1,0);
w_xtipleg=l_Appl.GetStringValue('DESCRIZ',50,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_CHJJABTJCS_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_CHJJABTJCS';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_CHJJABTJCS();
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
function Link_CHJJABTJCS_Blank() {
w_A43='';
w_xtipleg='';
}
function LOpt_CHJJABTJCS() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbtipleg','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('TIPLEG','C'));
l_oWv.setValue('LinkedField',WtA('TIPLEG','C'));
l_oWv.setValue('UID',WtA('CHJJABTJCS','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['CHJJABTJCS'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('711862875'),'C'));
return l_oWv;
}
function Link_DFFBWGMKTL(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_A52B);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODICE',w_A52B,2,0);
l_Appl.SetFields('CODICE');
l_Appl.SetTypes('C');
l_Appl.LinkTable('tbtipreg');
l_Appl.SetID('DFFBWGMKTL');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_A52B=l_Appl.GetStringValue('CODICE',2,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_DFFBWGMKTL_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_DFFBWGMKTL';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_DFFBWGMKTL();
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
function Link_DFFBWGMKTL_Blank() {
w_A52B='';
}
function LOpt_DFFBWGMKTL() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbtipreg','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODICE','C'));
l_oWv.setValue('LinkedField',WtA('CODICE','C'));
l_oWv.setValue('UID',WtA('DFFBWGMKTL','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['DFFBWGMKTL'][1],'C'));
return l_oWv;
}
function Link_CDFYKKBMYS(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_B12);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODVAL',w_B12,3,0);
l_Appl.SetFields('CODVAL,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbvalute');
l_Appl.SetID('CDFYKKBMYS');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_B12=l_Appl.GetStringValue('CODVAL',3,0);
w_xdesval=l_Appl.GetStringValue('DESCRI',30,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_CDFYKKBMYS_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_CDFYKKBMYS';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_CDFYKKBMYS();
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
function Link_CDFYKKBMYS_Blank() {
w_B12='';
w_xdesval='';
}
function LOpt_CDFYKKBMYS() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbvalute','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODVAL','C'));
l_oWv.setValue('LinkedField',WtA('CODVAL','C'));
l_oWv.setValue('UID',WtA('CDFYKKBMYS','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['CDFYKKBMYS'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('12090037306'),'C'));
return l_oWv;
}
function Link_BZRDFHBMPM(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_C11);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CONNES',w_C11,16,0);
l_Appl.SetFields('CONNES,RAGSOC');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('personbo');
l_Appl.SetID('BZRDFHBMPM');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_C11=l_Appl.GetStringValue('CONNES',16,0);
w_xragintes=l_Appl.GetStringValue('RAGSOC',70,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_BZRDFHBMPM_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_BZRDFHBMPM';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_BZRDFHBMPM();
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
function Link_BZRDFHBMPM_Blank() {
w_C11='';
w_xragintes='';
}
function LOpt_BZRDFHBMPM() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('personbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CONNES','C'));
l_oWv.setValue('LinkedField',WtA('CONNES','C'));
l_oWv.setValue('UID',WtA('BZRDFHBMPM','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['BZRDFHBMPM'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('11464190038'),'C'));
return l_oWv;
}
function Link_UYRQHSBRRT(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_C21);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CONNES',w_C21,16,0);
l_Appl.SetFields('CONNES,RAGSOC');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('personbo');
l_Appl.SetID('UYRQHSBRRT');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_C21=l_Appl.GetStringValue('CONNES',16,0);
w_xragsogope=l_Appl.GetStringValue('RAGSOC',70,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_UYRQHSBRRT_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_UYRQHSBRRT';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_UYRQHSBRRT();
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
function Link_UYRQHSBRRT_Blank() {
w_C21='';
w_xragsogope='';
}
function LOpt_UYRQHSBRRT() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('personbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CONNES','C'));
l_oWv.setValue('LinkedField',WtA('CONNES','C'));
l_oWv.setValue('UID',WtA('UYRQHSBRRT','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['UYRQHSBRRT'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('11070292036'),'C'));
return l_oWv;
}
function Link_PMFBITPOAZ(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_C31);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CONNES',w_C31,16,0);
l_Appl.SetFields('CONNES,RAGSOC');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('personbo');
l_Appl.SetID('PMFBITPOAZ');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_C31=l_Appl.GetStringValue('CONNES',16,0);
w_xragbenef=l_Appl.GetStringValue('RAGSOC',70,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_PMFBITPOAZ_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_PMFBITPOAZ';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_PMFBITPOAZ();
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
function Link_PMFBITPOAZ_Blank() {
w_C31='';
w_xragbenef='';
}
function LOpt_PMFBITPOAZ() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('personbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CONNES','C'));
l_oWv.setValue('LinkedField',WtA('CONNES','C'));
l_oWv.setValue('UID',WtA('PMFBITPOAZ','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['PMFBITPOAZ'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('10100846317'),'C'));
return l_oWv;
}
function Link_LZSKLOQPNQ(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_C41);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CONNES',w_C41,16,0);
l_Appl.SetFields('CONNES,RAGSOC');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('personbo');
l_Appl.SetID('LZSKLOQPNQ');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_C41=l_Appl.GetStringValue('CONNES',16,0);
w_xragsecond=l_Appl.GetStringValue('RAGSOC',70,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_LZSKLOQPNQ_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_LZSKLOQPNQ';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_LZSKLOQPNQ();
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
function Link_LZSKLOQPNQ_Blank() {
w_C41='';
w_xragsecond='';
}
function LOpt_LZSKLOQPNQ() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('personbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CONNES','C'));
l_oWv.setValue('LinkedField',WtA('CONNES','C'));
l_oWv.setValue('UID',WtA('LZSKLOQPNQ','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['LZSKLOQPNQ'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('10100846317'),'C'));
return l_oWv;
}
function Link_RHMPOMWSNG(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_C51);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CONNES',w_C51,16,0);
l_Appl.SetFields('CONNES,RAGSOC');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('personbo');
l_Appl.SetID('RHMPOMWSNG');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_C51=l_Appl.GetStringValue('CONNES',16,0);
w_xragterzo=l_Appl.GetStringValue('RAGSOC',70,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_RHMPOMWSNG_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_RHMPOMWSNG';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_RHMPOMWSNG();
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
function Link_RHMPOMWSNG_Blank() {
w_C51='';
w_xragterzo='';
}
function LOpt_RHMPOMWSNG() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('personbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CONNES','C'));
l_oWv.setValue('LinkedField',WtA('CONNES','C'));
l_oWv.setValue('UID',WtA('RHMPOMWSNG','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['RHMPOMWSNG'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('11456106420'),'C'));
return l_oWv;
}
function Link_OQJHGGFCNJ(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_D11);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('RAGSOC',w_D11,70,0);
l_Appl.SetFields('RAGSOC');
l_Appl.SetTypes('C');
l_Appl.LinkTable('personbo');
l_Appl.SetID('OQJHGGFCNJ');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_D11=l_Appl.GetStringValue('RAGSOC',70,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_OQJHGGFCNJ_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_OQJHGGFCNJ';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_OQJHGGFCNJ();
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
function Link_OQJHGGFCNJ_Blank() {
w_D11='';
}
function LOpt_OQJHGGFCNJ() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('personbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('RAGSOC','C'));
l_oWv.setValue('LinkedField',WtA('RAGSOC','C'));
l_oWv.setValue('UID',WtA('OQJHGGFCNJ','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['OQJHGGFCNJ'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('11464190038'),'C'));
return l_oWv;
}
function Link_GMCYYELLWW(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_D13);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODSTA',w_D13,3,0);
l_Appl.SetFields('CODSTA');
l_Appl.SetTypes('C');
l_Appl.LinkTable('tbstati');
l_Appl.SetID('GMCYYELLWW');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_D13=l_Appl.GetStringValue('CODSTA',3,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_GMCYYELLWW_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_GMCYYELLWW';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_GMCYYELLWW();
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
function Link_GMCYYELLWW_Blank() {
w_D13='';
}
function LOpt_GMCYYELLWW() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstati','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODSTA','C'));
l_oWv.setValue('LinkedField',WtA('CODSTA','C'));
l_oWv.setValue('UID',WtA('GMCYYELLWW','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['GMCYYELLWW'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('7383187'),'C'));
return l_oWv;
}
function Link_VZGLYXBMQI(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_D14A);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CAB',w_D14A,6,0);
l_Appl.SetFields('CAB');
l_Appl.SetTypes('C');
l_Appl.LinkTable('tbcitta');
l_Appl.SetID('VZGLYXBMQI');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_D14A=l_Appl.GetStringValue('CAB',6,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_VZGLYXBMQI_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_VZGLYXBMQI';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_VZGLYXBMQI();
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
function Link_VZGLYXBMQI_Blank() {
w_D14A='';
}
function LOpt_VZGLYXBMQI() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcitta','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CAB','C'));
l_oWv.setValue('LinkedField',WtA('CAB','C'));
l_oWv.setValue('UID',WtA('VZGLYXBMQI','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['VZGLYXBMQI'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('6863571'),'C'));
return l_oWv;
}
function Link_YRFNYFRQSY(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_D14B);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CITTA',w_D14B,30,0);
l_Appl.SetFields('CITTA');
l_Appl.SetTypes('C');
l_Appl.LinkTable('tbcitta');
l_Appl.SetID('YRFNYFRQSY');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_D14B=l_Appl.GetStringValue('CITTA',30,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_YRFNYFRQSY_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_YRFNYFRQSY';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_YRFNYFRQSY();
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
function Link_YRFNYFRQSY_Blank() {
w_D14B='';
}
function LOpt_YRFNYFRQSY() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcitta','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CITTA','C'));
l_oWv.setValue('LinkedField',WtA('CITTA','C'));
l_oWv.setValue('UID',WtA('YRFNYFRQSY','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['YRFNYFRQSY'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('15186643'),'C'));
return l_oWv;
}
function Link_ZGFXMEVTVH(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_D19A);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CITTA',w_D19A,30,0);
l_Appl.SetFields('CITTA');
l_Appl.SetTypes('C');
l_Appl.LinkTable('tbcitta');
l_Appl.SetID('ZGFXMEVTVH');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_D19A=l_Appl.GetStringValue('CITTA',30,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_ZGFXMEVTVH_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_ZGFXMEVTVH';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_ZGFXMEVTVH();
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
function Link_ZGFXMEVTVH_Blank() {
w_D19A='';
}
function LOpt_ZGFXMEVTVH() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcitta','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CITTA','C'));
l_oWv.setValue('LinkedField',WtA('CITTA','C'));
l_oWv.setValue('UID',WtA('ZGFXMEVTVH','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['ZGFXMEVTVH'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('15186643'),'C'));
return l_oWv;
}
function Link_RVQNZAINRJ(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_D19B);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('DESCRI',w_D19B,30,0);
l_Appl.SetFields('DESCRI');
l_Appl.SetTypes('C');
l_Appl.LinkTable('tbstati');
l_Appl.SetID('RVQNZAINRJ');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_D19B=l_Appl.GetStringValue('DESCRI',30,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_RVQNZAINRJ_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_RVQNZAINRJ';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_RVQNZAINRJ();
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
function Link_RVQNZAINRJ_Blank() {
w_D19B='';
}
function LOpt_RVQNZAINRJ() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstati','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('DESCRI','C'));
l_oWv.setValue('LinkedField',WtA('DESCRI','C'));
l_oWv.setValue('UID',WtA('RVQNZAINRJ','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['RVQNZAINRJ'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('15186643'),'C'));
return l_oWv;
}
function Link_DXFRERNUEZ(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_D21);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('SOTGRU',w_D21,3,0);
l_Appl.SetFields('SOTGRU,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbstgru');
l_Appl.SetID('DXFRERNUEZ');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_D21=l_Appl.GetStringValue('SOTGRU',3,0);
w_xdessoteco=l_Appl.GetStringValue('DESCRI',60,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_DXFRERNUEZ_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_DXFRERNUEZ';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_DXFRERNUEZ();
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
function Link_DXFRERNUEZ_Blank() {
w_D21='';
w_xdessoteco='';
}
function LOpt_DXFRERNUEZ() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstgru','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('SOTGRU','C'));
l_oWv.setValue('LinkedField',WtA('SOTGRU','C'));
l_oWv.setValue('UID',WtA('DXFRERNUEZ','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['DXFRERNUEZ'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('845327127'),'C'));
return l_oWv;
}
function Link_QZTKKLVNJB(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_D22);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('RAMGRU',w_D22,3,0);
l_Appl.SetFields('RAMGRU,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbramgru');
l_Appl.SetID('QZTKKLVNJB');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_D22=l_Appl.GetStringValue('RAMGRU',3,0);
w_xdesramgrp=l_Appl.GetStringValue('DESCRI',70,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_QZTKKLVNJB_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_QZTKKLVNJB';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_QZTKKLVNJB();
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
function Link_QZTKKLVNJB_Blank() {
w_D22='';
w_xdesramgrp='';
}
function LOpt_QZTKKLVNJB() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbramgru','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('RAMGRU','C'));
l_oWv.setValue('LinkedField',WtA('RAMGRU','C'));
l_oWv.setValue('UID',WtA('QZTKKLVNJB','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['QZTKKLVNJB'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('807557430'),'C'));
return l_oWv;
}
function Link_RIPVAPFZCO(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_D23);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('SETSINT',w_D23,3,0);
l_Appl.SetFields('SETSINT,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbsetsin');
l_Appl.SetID('RIPVAPFZCO');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_D23=l_Appl.GetStringValue('SETSINT',3,0);
w_xdessetsin=l_Appl.GetStringValue('DESCRI',60,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_RIPVAPFZCO_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_RIPVAPFZCO';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_RIPVAPFZCO();
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
function Link_RIPVAPFZCO_Blank() {
w_D23='';
w_xdessetsin='';
}
function LOpt_RIPVAPFZCO() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbsetsin','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('SETSINT','C'));
l_oWv.setValue('LinkedField',WtA('SETSINT','C'));
l_oWv.setValue('UID',WtA('RIPVAPFZCO','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['RIPVAPFZCO'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('496599153'),'C'));
return l_oWv;
}
function Link_QDVHTXVAEJ(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_D41);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('TIPDOC',w_D41,2,0);
l_Appl.SetFields('TIPDOC,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbtipdoc');
l_Appl.SetID('QDVHTXVAEJ');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_D41=l_Appl.GetStringValue('TIPDOC',2,0);
w_xdestipdoc=l_Appl.GetStringValue('DESCRI',30,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_QDVHTXVAEJ_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_QDVHTXVAEJ';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_QDVHTXVAEJ();
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
function Link_QDVHTXVAEJ_Blank() {
w_D41='';
w_xdestipdoc='';
}
function LOpt_QDVHTXVAEJ() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbtipdoc','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('TIPDOC','C'));
l_oWv.setValue('LinkedField',WtA('TIPDOC','C'));
l_oWv.setValue('UID',WtA('QDVHTXVAEJ','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['QDVHTXVAEJ'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('11429056727'),'C'));
return l_oWv;
}
function Link_UMGRLGMHMY(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_E11);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('RAGSOC',w_E11,70,0);
l_Appl.SetFields('RAGSOC');
l_Appl.SetTypes('C');
l_Appl.LinkTable('personbo');
l_Appl.SetID('UMGRLGMHMY');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_E11=l_Appl.GetStringValue('RAGSOC',70,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_UMGRLGMHMY_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_UMGRLGMHMY';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_UMGRLGMHMY();
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
function Link_UMGRLGMHMY_Blank() {
w_E11='';
}
function LOpt_UMGRLGMHMY() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('personbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('RAGSOC','C'));
l_oWv.setValue('LinkedField',WtA('RAGSOC','C'));
l_oWv.setValue('UID',WtA('UMGRLGMHMY','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['UMGRLGMHMY'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('11464190038'),'C'));
return l_oWv;
}
function Link_GXOOZRXYFU(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_E13);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODSTA',w_E13,3,0);
l_Appl.SetFields('CODSTA');
l_Appl.SetTypes('C');
l_Appl.LinkTable('tbstati');
l_Appl.SetID('GXOOZRXYFU');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_E13=l_Appl.GetStringValue('CODSTA',3,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_GXOOZRXYFU_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_GXOOZRXYFU';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_GXOOZRXYFU();
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
function Link_GXOOZRXYFU_Blank() {
w_E13='';
}
function LOpt_GXOOZRXYFU() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstati','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODSTA','C'));
l_oWv.setValue('LinkedField',WtA('CODSTA','C'));
l_oWv.setValue('UID',WtA('GXOOZRXYFU','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['GXOOZRXYFU'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('7383187'),'C'));
return l_oWv;
}
function Link_IMIPLTLEAA(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_E14A);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CAB',w_E14A,6,0);
l_Appl.SetFields('CAB');
l_Appl.SetTypes('C');
l_Appl.LinkTable('tbcitta');
l_Appl.SetID('IMIPLTLEAA');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_E14A=l_Appl.GetStringValue('CAB',6,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_IMIPLTLEAA_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_IMIPLTLEAA';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_IMIPLTLEAA();
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
function Link_IMIPLTLEAA_Blank() {
w_E14A='';
}
function LOpt_IMIPLTLEAA() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcitta','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CAB','C'));
l_oWv.setValue('LinkedField',WtA('CAB','C'));
l_oWv.setValue('UID',WtA('IMIPLTLEAA','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['IMIPLTLEAA'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('6863571'),'C'));
return l_oWv;
}
function Link_JMWSEEISWG(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_E14B);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CITTA',w_E14B,30,0);
l_Appl.SetFields('CITTA');
l_Appl.SetTypes('C');
l_Appl.LinkTable('tbcitta');
l_Appl.SetID('JMWSEEISWG');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_E14B=l_Appl.GetStringValue('CITTA',30,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_JMWSEEISWG_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_JMWSEEISWG';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_JMWSEEISWG();
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
function Link_JMWSEEISWG_Blank() {
w_E14B='';
}
function LOpt_JMWSEEISWG() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcitta','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CITTA','C'));
l_oWv.setValue('LinkedField',WtA('CITTA','C'));
l_oWv.setValue('UID',WtA('JMWSEEISWG','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['JMWSEEISWG'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('15186643'),'C'));
return l_oWv;
}
function Link_OZDICWDQRW(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_E19A);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CITTA',w_E19A,30,0);
l_Appl.SetFields('CITTA');
l_Appl.SetTypes('C');
l_Appl.LinkTable('tbcitta');
l_Appl.SetID('OZDICWDQRW');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_E19A=l_Appl.GetStringValue('CITTA',30,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_OZDICWDQRW_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_OZDICWDQRW';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_OZDICWDQRW();
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
function Link_OZDICWDQRW_Blank() {
w_E19A='';
}
function LOpt_OZDICWDQRW() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcitta','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CITTA','C'));
l_oWv.setValue('LinkedField',WtA('CITTA','C'));
l_oWv.setValue('UID',WtA('OZDICWDQRW','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['OZDICWDQRW'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('15186643'),'C'));
return l_oWv;
}
function Link_YSNADFXEBL(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_E19B);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('DESCRI',w_E19B,30,0);
l_Appl.SetFields('DESCRI');
l_Appl.SetTypes('C');
l_Appl.LinkTable('tbstati');
l_Appl.SetID('YSNADFXEBL');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_E19B=l_Appl.GetStringValue('DESCRI',30,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_YSNADFXEBL_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_YSNADFXEBL';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_YSNADFXEBL();
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
function Link_YSNADFXEBL_Blank() {
w_E19B='';
}
function LOpt_YSNADFXEBL() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstati','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('DESCRI','C'));
l_oWv.setValue('LinkedField',WtA('DESCRI','C'));
l_oWv.setValue('UID',WtA('YSNADFXEBL','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['YSNADFXEBL'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('15186643'),'C'));
return l_oWv;
}
function Link_SZZONHIXUX(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_E41);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('TIPDOC',w_E41,2,0);
l_Appl.SetFields('TIPDOC,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbtipdoc');
l_Appl.SetID('SZZONHIXUX');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_E41=l_Appl.GetStringValue('TIPDOC',2,0);
w_xdestipdocsg=l_Appl.GetStringValue('DESCRI',30,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_SZZONHIXUX_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_SZZONHIXUX';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_SZZONHIXUX();
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
function Link_SZZONHIXUX_Blank() {
w_E41='';
w_xdestipdocsg='';
}
function LOpt_SZZONHIXUX() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbtipdoc','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('TIPDOC','C'));
l_oWv.setValue('LinkedField',WtA('TIPDOC','C'));
l_oWv.setValue('UID',WtA('SZZONHIXUX','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['SZZONHIXUX'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('11429056727'),'C'));
return l_oWv;
}
function Link_XUTATNAFCN(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_F11);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('RAGSOC',w_F11,70,0);
l_Appl.SetFields('RAGSOC');
l_Appl.SetTypes('C');
l_Appl.LinkTable('personbo');
l_Appl.SetID('XUTATNAFCN');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_F11=l_Appl.GetStringValue('RAGSOC',70,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_XUTATNAFCN_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_XUTATNAFCN';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_XUTATNAFCN();
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
function Link_XUTATNAFCN_Blank() {
w_F11='';
}
function LOpt_XUTATNAFCN() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('personbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('RAGSOC','C'));
l_oWv.setValue('LinkedField',WtA('RAGSOC','C'));
l_oWv.setValue('UID',WtA('XUTATNAFCN','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['XUTATNAFCN'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('11464190038'),'C'));
return l_oWv;
}
function Link_GSQDROOXIH(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_F13);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODSTA',w_F13,3,0);
l_Appl.SetFields('CODSTA');
l_Appl.SetTypes('C');
l_Appl.LinkTable('tbstati');
l_Appl.SetID('GSQDROOXIH');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_F13=l_Appl.GetStringValue('CODSTA',3,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_GSQDROOXIH_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_GSQDROOXIH';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_GSQDROOXIH();
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
function Link_GSQDROOXIH_Blank() {
w_F13='';
}
function LOpt_GSQDROOXIH() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstati','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODSTA','C'));
l_oWv.setValue('LinkedField',WtA('CODSTA','C'));
l_oWv.setValue('UID',WtA('GSQDROOXIH','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['GSQDROOXIH'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('7383187'),'C'));
return l_oWv;
}
function Link_AYOYZWWHED(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_F14A);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CAB',w_F14A,6,0);
l_Appl.SetFields('CAB');
l_Appl.SetTypes('C');
l_Appl.LinkTable('tbcitta');
l_Appl.SetID('AYOYZWWHED');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_F14A=l_Appl.GetStringValue('CAB',6,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_AYOYZWWHED_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_AYOYZWWHED';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_AYOYZWWHED();
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
function Link_AYOYZWWHED_Blank() {
w_F14A='';
}
function LOpt_AYOYZWWHED() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcitta','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CAB','C'));
l_oWv.setValue('LinkedField',WtA('CAB','C'));
l_oWv.setValue('UID',WtA('AYOYZWWHED','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['AYOYZWWHED'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('6863571'),'C'));
return l_oWv;
}
function Link_ZKDTAIVYNT(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_F14B);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CITTA',w_F14B,30,0);
l_Appl.SetFields('CITTA');
l_Appl.SetTypes('C');
l_Appl.LinkTable('tbcitta');
l_Appl.SetID('ZKDTAIVYNT');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_F14B=l_Appl.GetStringValue('CITTA',30,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_ZKDTAIVYNT_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_ZKDTAIVYNT';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_ZKDTAIVYNT();
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
function Link_ZKDTAIVYNT_Blank() {
w_F14B='';
}
function LOpt_ZKDTAIVYNT() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcitta','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CITTA','C'));
l_oWv.setValue('LinkedField',WtA('CITTA','C'));
l_oWv.setValue('UID',WtA('ZKDTAIVYNT','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['ZKDTAIVYNT'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('15186643'),'C'));
return l_oWv;
}
function Link_PGAPCLKWDU(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_G11);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('RAGSOC',w_G11,70,0);
l_Appl.SetFields('RAGSOC');
l_Appl.SetTypes('C');
l_Appl.LinkTable('personbo');
l_Appl.SetID('PGAPCLKWDU');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_G11=l_Appl.GetStringValue('RAGSOC',70,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_PGAPCLKWDU_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_PGAPCLKWDU';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_PGAPCLKWDU();
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
function Link_PGAPCLKWDU_Blank() {
w_G11='';
}
function LOpt_PGAPCLKWDU() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('personbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('RAGSOC','C'));
l_oWv.setValue('LinkedField',WtA('RAGSOC','C'));
l_oWv.setValue('UID',WtA('PGAPCLKWDU','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['PGAPCLKWDU'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('11464190038'),'C'));
return l_oWv;
}
function Link_NMVYSCDEYI(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_G13);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODSTA',w_G13,3,0);
l_Appl.SetFields('CODSTA');
l_Appl.SetTypes('C');
l_Appl.LinkTable('tbstati');
l_Appl.SetID('NMVYSCDEYI');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_G13=l_Appl.GetStringValue('CODSTA',3,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_NMVYSCDEYI_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_NMVYSCDEYI';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_NMVYSCDEYI();
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
function Link_NMVYSCDEYI_Blank() {
w_G13='';
}
function LOpt_NMVYSCDEYI() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstati','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODSTA','C'));
l_oWv.setValue('LinkedField',WtA('CODSTA','C'));
l_oWv.setValue('UID',WtA('NMVYSCDEYI','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['NMVYSCDEYI'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('7383187'),'C'));
return l_oWv;
}
function Link_IZFSEEEELX(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_G14A);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CAB',w_G14A,6,0);
l_Appl.SetFields('CAB');
l_Appl.SetTypes('C');
l_Appl.LinkTable('tbcitta');
l_Appl.SetID('IZFSEEEELX');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_G14A=l_Appl.GetStringValue('CAB',6,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_IZFSEEEELX_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_IZFSEEEELX';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_IZFSEEEELX();
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
function Link_IZFSEEEELX_Blank() {
w_G14A='';
}
function LOpt_IZFSEEEELX() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcitta','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CAB','C'));
l_oWv.setValue('LinkedField',WtA('CAB','C'));
l_oWv.setValue('UID',WtA('IZFSEEEELX','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['IZFSEEEELX'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('6863571'),'C'));
return l_oWv;
}
function Link_RZOPLJQQOD(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_G14B);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CITTA',w_G14B,30,0);
l_Appl.SetFields('CITTA');
l_Appl.SetTypes('C');
l_Appl.LinkTable('tbcitta');
l_Appl.SetID('RZOPLJQQOD');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_G14B=l_Appl.GetStringValue('CITTA',30,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_RZOPLJQQOD_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_RZOPLJQQOD';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_RZOPLJQQOD();
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
function Link_RZOPLJQQOD_Blank() {
w_G14B='';
}
function LOpt_RZOPLJQQOD() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcitta','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CITTA','C'));
l_oWv.setValue('LinkedField',WtA('CITTA','C'));
l_oWv.setValue('UID',WtA('RZOPLJQQOD','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['RZOPLJQQOD'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('15186643'),'C'));
return l_oWv;
}
function Link_GSZGYDPMMI(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_G19A);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CITTA',w_G19A,30,0);
l_Appl.SetFields('CITTA');
l_Appl.SetTypes('C');
l_Appl.LinkTable('tbcitta');
l_Appl.SetID('GSZGYDPMMI');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_G19A=l_Appl.GetStringValue('CITTA',30,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_GSZGYDPMMI_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_GSZGYDPMMI';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_GSZGYDPMMI();
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
function Link_GSZGYDPMMI_Blank() {
w_G19A='';
}
function LOpt_GSZGYDPMMI() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcitta','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CITTA','C'));
l_oWv.setValue('LinkedField',WtA('CITTA','C'));
l_oWv.setValue('UID',WtA('GSZGYDPMMI','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['GSZGYDPMMI'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('15186643'),'C'));
return l_oWv;
}
function Link_HKGGYHAADA(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_G19B);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('DESCRI',w_G19B,30,0);
l_Appl.SetFields('DESCRI');
l_Appl.SetTypes('C');
l_Appl.LinkTable('tbstati');
l_Appl.SetID('HKGGYHAADA');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_G19B=l_Appl.GetStringValue('DESCRI',30,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_HKGGYHAADA_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_HKGGYHAADA';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_HKGGYHAADA();
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
function Link_HKGGYHAADA_Blank() {
w_G19B='';
}
function LOpt_HKGGYHAADA() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstati','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('DESCRI','C'));
l_oWv.setValue('LinkedField',WtA('DESCRI','C'));
l_oWv.setValue('UID',WtA('HKGGYHAADA','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['HKGGYHAADA'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('15186643'),'C'));
return l_oWv;
}
function Link_BCOSCDETUR(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_G41);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('TIPDOC',w_G41,2,0);
l_Appl.SetFields('TIPDOC,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbtipdoc');
l_Appl.SetID('BCOSCDETUR');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_G41=l_Appl.GetStringValue('TIPDOC',2,0);
w_xdestipdoct=l_Appl.GetStringValue('DESCRI',30,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_BCOSCDETUR_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_BCOSCDETUR';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_BCOSCDETUR();
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
function Link_BCOSCDETUR_Blank() {
w_G41='';
w_xdestipdoct='';
}
function LOpt_BCOSCDETUR() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbtipdoc','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('TIPDOC','C'));
l_oWv.setValue('LinkedField',WtA('TIPDOC','C'));
l_oWv.setValue('UID',WtA('BCOSCDETUR','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['BCOSCDETUR'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('11429056727'),'C'));
return l_oWv;
}
function Link_LWFUPEVCFF(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_H11);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('RAGSOC',w_H11,70,0);
l_Appl.SetFields('RAGSOC');
l_Appl.SetTypes('C');
l_Appl.LinkTable('personbo');
l_Appl.SetID('LWFUPEVCFF');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_H11=l_Appl.GetStringValue('RAGSOC',70,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_LWFUPEVCFF_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_LWFUPEVCFF';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_LWFUPEVCFF();
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
function Link_LWFUPEVCFF_Blank() {
w_H11='';
}
function LOpt_LWFUPEVCFF() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('personbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('RAGSOC','C'));
l_oWv.setValue('LinkedField',WtA('RAGSOC','C'));
l_oWv.setValue('UID',WtA('LWFUPEVCFF','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['LWFUPEVCFF'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('11464190038'),'C'));
return l_oWv;
}
function Link_LMFVWUIXUQ(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_H13);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODSTA',w_H13,3,0);
l_Appl.SetFields('CODSTA');
l_Appl.SetTypes('C');
l_Appl.LinkTable('tbstati');
l_Appl.SetID('LMFVWUIXUQ');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_H13=l_Appl.GetStringValue('CODSTA',3,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_LMFVWUIXUQ_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_LMFVWUIXUQ';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_LMFVWUIXUQ();
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
function Link_LMFVWUIXUQ_Blank() {
w_H13='';
}
function LOpt_LMFVWUIXUQ() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstati','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODSTA','C'));
l_oWv.setValue('LinkedField',WtA('CODSTA','C'));
l_oWv.setValue('UID',WtA('LMFVWUIXUQ','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['LMFVWUIXUQ'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('7383187'),'C'));
return l_oWv;
}
function Link_EVWGKCMMJY(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_H14A);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CAB',w_H14A,6,0);
l_Appl.SetFields('CAB');
l_Appl.SetTypes('C');
l_Appl.LinkTable('tbcitta');
l_Appl.SetID('EVWGKCMMJY');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_H14A=l_Appl.GetStringValue('CAB',6,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_EVWGKCMMJY_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_EVWGKCMMJY';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_EVWGKCMMJY();
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
function Link_EVWGKCMMJY_Blank() {
w_H14A='';
}
function LOpt_EVWGKCMMJY() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcitta','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CAB','C'));
l_oWv.setValue('LinkedField',WtA('CAB','C'));
l_oWv.setValue('UID',WtA('EVWGKCMMJY','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['EVWGKCMMJY'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('6863571'),'C'));
return l_oWv;
}
function Link_UVHIQLABPT(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_H14B);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CITTA',w_H14B,30,0);
l_Appl.SetFields('CITTA');
l_Appl.SetTypes('C');
l_Appl.LinkTable('tbcitta');
l_Appl.SetID('UVHIQLABPT');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_H14B=l_Appl.GetStringValue('CITTA',30,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_UVHIQLABPT_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_UVHIQLABPT';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_UVHIQLABPT();
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
function Link_UVHIQLABPT_Blank() {
w_H14B='';
}
function LOpt_UVHIQLABPT() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcitta','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CITTA','C'));
l_oWv.setValue('LinkedField',WtA('CITTA','C'));
l_oWv.setValue('UID',WtA('UVHIQLABPT','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['UVHIQLABPT'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('15186643'),'C'));
return l_oWv;
}
function Link_KCGLCUJYUP(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_H19A);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CITTA',w_H19A,30,0);
l_Appl.SetFields('CITTA');
l_Appl.SetTypes('C');
l_Appl.LinkTable('tbcitta');
l_Appl.SetID('KCGLCUJYUP');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_H19A=l_Appl.GetStringValue('CITTA',30,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_KCGLCUJYUP_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_KCGLCUJYUP';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_KCGLCUJYUP();
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
function Link_KCGLCUJYUP_Blank() {
w_H19A='';
}
function LOpt_KCGLCUJYUP() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcitta','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CITTA','C'));
l_oWv.setValue('LinkedField',WtA('CITTA','C'));
l_oWv.setValue('UID',WtA('KCGLCUJYUP','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['KCGLCUJYUP'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('15186643'),'C'));
return l_oWv;
}
function Link_RQOFXUOOWZ(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_H19B);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('DESCRI',w_H19B,30,0);
l_Appl.SetFields('DESCRI');
l_Appl.SetTypes('C');
l_Appl.LinkTable('tbstati');
l_Appl.SetID('RQOFXUOOWZ');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_H19B=l_Appl.GetStringValue('DESCRI',30,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_RQOFXUOOWZ_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_RQOFXUOOWZ';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_RQOFXUOOWZ();
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
function Link_RQOFXUOOWZ_Blank() {
w_H19B='';
}
function LOpt_RQOFXUOOWZ() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstati','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('DESCRI','C'));
l_oWv.setValue('LinkedField',WtA('DESCRI','C'));
l_oWv.setValue('UID',WtA('RQOFXUOOWZ','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['RQOFXUOOWZ'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('15186643'),'C'));
return l_oWv;
}
function Link_OAWXXEHPRA(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_H41);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('TIPDOC',w_H41,2,0);
l_Appl.SetFields('TIPDOC,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbtipdoc');
l_Appl.SetID('OAWXXEHPRA');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_H41=l_Appl.GetStringValue('TIPDOC',2,0);
w_xdestipdoct1=l_Appl.GetStringValue('DESCRI',30,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_OAWXXEHPRA_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_OAWXXEHPRA';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_OAWXXEHPRA();
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
function Link_OAWXXEHPRA_Blank() {
w_H41='';
w_xdestipdoct1='';
}
function LOpt_OAWXXEHPRA() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbtipdoc','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('TIPDOC','C'));
l_oWv.setValue('LinkedField',WtA('TIPDOC','C'));
l_oWv.setValue('UID',WtA('OAWXXEHPRA','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['OAWXXEHPRA'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('11429056727'),'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'TIPXBDXITE')) {
last_focused_comp=GetLastFocusedElementOfLink('TIPXBDXITE');
function SetMethod_TIPXBDXITE() {
Set_A01B(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_TIPXBDXITE();
} else {
setTimeout(SetMethod_TIPXBDXITE,1);
}
bResult=true;
}
if (Eq(varName,'BQNMQAOIPA')) {
last_focused_comp=GetLastFocusedElementOfLink('BQNMQAOIPA');
function SetMethod_BQNMQAOIPA() {
Set_A11(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_BQNMQAOIPA();
} else {
setTimeout(SetMethod_BQNMQAOIPA,1);
}
bResult=true;
}
if (Eq(varName,'XHIBDWLIOD')) {
last_focused_comp=GetLastFocusedElementOfLink('XHIBDWLIOD');
function SetMethod_XHIBDWLIOD() {
Set_A12A(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_XHIBDWLIOD();
} else {
setTimeout(SetMethod_XHIBDWLIOD,1);
}
bResult=true;
}
if (Eq(varName,'IFYLHOXPRS')) {
last_focused_comp=GetLastFocusedElementOfLink('IFYLHOXPRS');
function SetMethod_IFYLHOXPRS() {
Set_A12B(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_IFYLHOXPRS();
} else {
setTimeout(SetMethod_IFYLHOXPRS,1);
}
bResult=true;
}
if (Eq(varName,'CKACALWZOL')) {
last_focused_comp=GetLastFocusedElementOfLink('CKACALWZOL');
function SetMethod_CKACALWZOL() {
Set_A24(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_CKACALWZOL();
} else {
setTimeout(SetMethod_CKACALWZOL,1);
}
bResult=true;
}
if (Eq(varName,'ZIMEUPPLZY')) {
last_focused_comp=GetLastFocusedElementOfLink('ZIMEUPPLZY');
function SetMethod_ZIMEUPPLZY() {
Set_A25(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_ZIMEUPPLZY();
} else {
setTimeout(SetMethod_ZIMEUPPLZY,1);
}
bResult=true;
}
if (Eq(varName,'ZZQPEDWGCO')) {
last_focused_comp=GetLastFocusedElementOfLink('ZZQPEDWGCO');
function SetMethod_ZZQPEDWGCO() {
Set_A31B(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_ZZQPEDWGCO();
} else {
setTimeout(SetMethod_ZZQPEDWGCO,1);
}
bResult=true;
}
if (Eq(varName,'LTUCQORMSA')) {
last_focused_comp=GetLastFocusedElementOfLink('LTUCQORMSA');
function SetMethod_LTUCQORMSA() {
Set_A32(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_LTUCQORMSA();
} else {
setTimeout(SetMethod_LTUCQORMSA,1);
}
bResult=true;
}
if (Eq(varName,'VDWEKDDBOW')) {
last_focused_comp=GetLastFocusedElementOfLink('VDWEKDDBOW');
function SetMethod_VDWEKDDBOW() {
Set_A33A(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_VDWEKDDBOW();
} else {
setTimeout(SetMethod_VDWEKDDBOW,1);
}
bResult=true;
}
if (Eq(varName,'BICDANUWZD')) {
last_focused_comp=GetLastFocusedElementOfLink('BICDANUWZD');
function SetMethod_BICDANUWZD() {
Set_A33B(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_BICDANUWZD();
} else {
setTimeout(SetMethod_BICDANUWZD,1);
}
bResult=true;
}
if (Eq(varName,'HDIAJDVNVI')) {
last_focused_comp=GetLastFocusedElementOfLink('HDIAJDVNVI');
function SetMethod_HDIAJDVNVI() {
Set_A41(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_HDIAJDVNVI();
} else {
setTimeout(SetMethod_HDIAJDVNVI,1);
}
bResult=true;
}
if (Eq(varName,'RQJLOLNIHM')) {
last_focused_comp=GetLastFocusedElementOfLink('RQJLOLNIHM');
function SetMethod_RQJLOLNIHM() {
Set_A42(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_RQJLOLNIHM();
} else {
setTimeout(SetMethod_RQJLOLNIHM,1);
}
bResult=true;
}
if (Eq(varName,'CHJJABTJCS')) {
last_focused_comp=GetLastFocusedElementOfLink('CHJJABTJCS');
function SetMethod_CHJJABTJCS() {
Set_A43(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_CHJJABTJCS();
} else {
setTimeout(SetMethod_CHJJABTJCS,1);
}
bResult=true;
}
if (Eq(varName,'DFFBWGMKTL')) {
last_focused_comp=GetLastFocusedElementOfLink('DFFBWGMKTL');
function SetMethod_DFFBWGMKTL() {
Set_A52B(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_DFFBWGMKTL();
} else {
setTimeout(SetMethod_DFFBWGMKTL,1);
}
bResult=true;
}
if (Eq(varName,'CDFYKKBMYS')) {
last_focused_comp=GetLastFocusedElementOfLink('CDFYKKBMYS');
function SetMethod_CDFYKKBMYS() {
Set_B12(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_CDFYKKBMYS();
} else {
setTimeout(SetMethod_CDFYKKBMYS,1);
}
bResult=true;
}
if (Eq(varName,'BZRDFHBMPM')) {
last_focused_comp=GetLastFocusedElementOfLink('BZRDFHBMPM');
function SetMethod_BZRDFHBMPM() {
Set_C11(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_BZRDFHBMPM();
} else {
setTimeout(SetMethod_BZRDFHBMPM,1);
}
bResult=true;
}
if (Eq(varName,'UYRQHSBRRT')) {
last_focused_comp=GetLastFocusedElementOfLink('UYRQHSBRRT');
function SetMethod_UYRQHSBRRT() {
Set_C21(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_UYRQHSBRRT();
} else {
setTimeout(SetMethod_UYRQHSBRRT,1);
}
bResult=true;
}
if (Eq(varName,'PMFBITPOAZ')) {
last_focused_comp=GetLastFocusedElementOfLink('PMFBITPOAZ');
function SetMethod_PMFBITPOAZ() {
Set_C31(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_PMFBITPOAZ();
} else {
setTimeout(SetMethod_PMFBITPOAZ,1);
}
bResult=true;
}
if (Eq(varName,'LZSKLOQPNQ')) {
last_focused_comp=GetLastFocusedElementOfLink('LZSKLOQPNQ');
function SetMethod_LZSKLOQPNQ() {
Set_C41(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_LZSKLOQPNQ();
} else {
setTimeout(SetMethod_LZSKLOQPNQ,1);
}
bResult=true;
}
if (Eq(varName,'RHMPOMWSNG')) {
last_focused_comp=GetLastFocusedElementOfLink('RHMPOMWSNG');
function SetMethod_RHMPOMWSNG() {
Set_C51(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_RHMPOMWSNG();
} else {
setTimeout(SetMethod_RHMPOMWSNG,1);
}
bResult=true;
}
if (Eq(varName,'OQJHGGFCNJ')) {
last_focused_comp=GetLastFocusedElementOfLink('OQJHGGFCNJ');
function SetMethod_OQJHGGFCNJ() {
Set_D11(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_OQJHGGFCNJ();
} else {
setTimeout(SetMethod_OQJHGGFCNJ,1);
}
bResult=true;
}
if (Eq(varName,'GMCYYELLWW')) {
last_focused_comp=GetLastFocusedElementOfLink('GMCYYELLWW');
function SetMethod_GMCYYELLWW() {
Set_D13(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_GMCYYELLWW();
} else {
setTimeout(SetMethod_GMCYYELLWW,1);
}
bResult=true;
}
if (Eq(varName,'VZGLYXBMQI')) {
last_focused_comp=GetLastFocusedElementOfLink('VZGLYXBMQI');
function SetMethod_VZGLYXBMQI() {
Set_D14A(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_VZGLYXBMQI();
} else {
setTimeout(SetMethod_VZGLYXBMQI,1);
}
bResult=true;
}
if (Eq(varName,'YRFNYFRQSY')) {
last_focused_comp=GetLastFocusedElementOfLink('YRFNYFRQSY');
function SetMethod_YRFNYFRQSY() {
Set_D14B(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_YRFNYFRQSY();
} else {
setTimeout(SetMethod_YRFNYFRQSY,1);
}
bResult=true;
}
if (Eq(varName,'ZGFXMEVTVH')) {
last_focused_comp=GetLastFocusedElementOfLink('ZGFXMEVTVH');
function SetMethod_ZGFXMEVTVH() {
Set_D19A(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_ZGFXMEVTVH();
} else {
setTimeout(SetMethod_ZGFXMEVTVH,1);
}
bResult=true;
}
if (Eq(varName,'RVQNZAINRJ')) {
last_focused_comp=GetLastFocusedElementOfLink('RVQNZAINRJ');
function SetMethod_RVQNZAINRJ() {
Set_D19B(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_RVQNZAINRJ();
} else {
setTimeout(SetMethod_RVQNZAINRJ,1);
}
bResult=true;
}
if (Eq(varName,'DXFRERNUEZ')) {
last_focused_comp=GetLastFocusedElementOfLink('DXFRERNUEZ');
function SetMethod_DXFRERNUEZ() {
Set_D21(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_DXFRERNUEZ();
} else {
setTimeout(SetMethod_DXFRERNUEZ,1);
}
bResult=true;
}
if (Eq(varName,'QZTKKLVNJB')) {
last_focused_comp=GetLastFocusedElementOfLink('QZTKKLVNJB');
function SetMethod_QZTKKLVNJB() {
Set_D22(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_QZTKKLVNJB();
} else {
setTimeout(SetMethod_QZTKKLVNJB,1);
}
bResult=true;
}
if (Eq(varName,'RIPVAPFZCO')) {
last_focused_comp=GetLastFocusedElementOfLink('RIPVAPFZCO');
function SetMethod_RIPVAPFZCO() {
Set_D23(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_RIPVAPFZCO();
} else {
setTimeout(SetMethod_RIPVAPFZCO,1);
}
bResult=true;
}
if (Eq(varName,'QDVHTXVAEJ')) {
last_focused_comp=GetLastFocusedElementOfLink('QDVHTXVAEJ');
function SetMethod_QDVHTXVAEJ() {
Set_D41(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_QDVHTXVAEJ();
} else {
setTimeout(SetMethod_QDVHTXVAEJ,1);
}
bResult=true;
}
if (Eq(varName,'UMGRLGMHMY')) {
last_focused_comp=GetLastFocusedElementOfLink('UMGRLGMHMY');
function SetMethod_UMGRLGMHMY() {
Set_E11(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_UMGRLGMHMY();
} else {
setTimeout(SetMethod_UMGRLGMHMY,1);
}
bResult=true;
}
if (Eq(varName,'GXOOZRXYFU')) {
last_focused_comp=GetLastFocusedElementOfLink('GXOOZRXYFU');
function SetMethod_GXOOZRXYFU() {
Set_E13(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_GXOOZRXYFU();
} else {
setTimeout(SetMethod_GXOOZRXYFU,1);
}
bResult=true;
}
if (Eq(varName,'IMIPLTLEAA')) {
last_focused_comp=GetLastFocusedElementOfLink('IMIPLTLEAA');
function SetMethod_IMIPLTLEAA() {
Set_E14A(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_IMIPLTLEAA();
} else {
setTimeout(SetMethod_IMIPLTLEAA,1);
}
bResult=true;
}
if (Eq(varName,'JMWSEEISWG')) {
last_focused_comp=GetLastFocusedElementOfLink('JMWSEEISWG');
function SetMethod_JMWSEEISWG() {
Set_E14B(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_JMWSEEISWG();
} else {
setTimeout(SetMethod_JMWSEEISWG,1);
}
bResult=true;
}
if (Eq(varName,'OZDICWDQRW')) {
last_focused_comp=GetLastFocusedElementOfLink('OZDICWDQRW');
function SetMethod_OZDICWDQRW() {
Set_E19A(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_OZDICWDQRW();
} else {
setTimeout(SetMethod_OZDICWDQRW,1);
}
bResult=true;
}
if (Eq(varName,'YSNADFXEBL')) {
last_focused_comp=GetLastFocusedElementOfLink('YSNADFXEBL');
function SetMethod_YSNADFXEBL() {
Set_E19B(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_YSNADFXEBL();
} else {
setTimeout(SetMethod_YSNADFXEBL,1);
}
bResult=true;
}
if (Eq(varName,'SZZONHIXUX')) {
last_focused_comp=GetLastFocusedElementOfLink('SZZONHIXUX');
function SetMethod_SZZONHIXUX() {
Set_E41(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_SZZONHIXUX();
} else {
setTimeout(SetMethod_SZZONHIXUX,1);
}
bResult=true;
}
if (Eq(varName,'XUTATNAFCN')) {
last_focused_comp=GetLastFocusedElementOfLink('XUTATNAFCN');
function SetMethod_XUTATNAFCN() {
Set_F11(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_XUTATNAFCN();
} else {
setTimeout(SetMethod_XUTATNAFCN,1);
}
bResult=true;
}
if (Eq(varName,'GSQDROOXIH')) {
last_focused_comp=GetLastFocusedElementOfLink('GSQDROOXIH');
function SetMethod_GSQDROOXIH() {
Set_F13(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_GSQDROOXIH();
} else {
setTimeout(SetMethod_GSQDROOXIH,1);
}
bResult=true;
}
if (Eq(varName,'AYOYZWWHED')) {
last_focused_comp=GetLastFocusedElementOfLink('AYOYZWWHED');
function SetMethod_AYOYZWWHED() {
Set_F14A(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_AYOYZWWHED();
} else {
setTimeout(SetMethod_AYOYZWWHED,1);
}
bResult=true;
}
if (Eq(varName,'ZKDTAIVYNT')) {
last_focused_comp=GetLastFocusedElementOfLink('ZKDTAIVYNT');
function SetMethod_ZKDTAIVYNT() {
Set_F14B(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_ZKDTAIVYNT();
} else {
setTimeout(SetMethod_ZKDTAIVYNT,1);
}
bResult=true;
}
if (Eq(varName,'PGAPCLKWDU')) {
last_focused_comp=GetLastFocusedElementOfLink('PGAPCLKWDU');
function SetMethod_PGAPCLKWDU() {
Set_G11(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_PGAPCLKWDU();
} else {
setTimeout(SetMethod_PGAPCLKWDU,1);
}
bResult=true;
}
if (Eq(varName,'NMVYSCDEYI')) {
last_focused_comp=GetLastFocusedElementOfLink('NMVYSCDEYI');
function SetMethod_NMVYSCDEYI() {
Set_G13(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_NMVYSCDEYI();
} else {
setTimeout(SetMethod_NMVYSCDEYI,1);
}
bResult=true;
}
if (Eq(varName,'IZFSEEEELX')) {
last_focused_comp=GetLastFocusedElementOfLink('IZFSEEEELX');
function SetMethod_IZFSEEEELX() {
Set_G14A(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_IZFSEEEELX();
} else {
setTimeout(SetMethod_IZFSEEEELX,1);
}
bResult=true;
}
if (Eq(varName,'RZOPLJQQOD')) {
last_focused_comp=GetLastFocusedElementOfLink('RZOPLJQQOD');
function SetMethod_RZOPLJQQOD() {
Set_G14B(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_RZOPLJQQOD();
} else {
setTimeout(SetMethod_RZOPLJQQOD,1);
}
bResult=true;
}
if (Eq(varName,'GSZGYDPMMI')) {
last_focused_comp=GetLastFocusedElementOfLink('GSZGYDPMMI');
function SetMethod_GSZGYDPMMI() {
Set_G19A(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_GSZGYDPMMI();
} else {
setTimeout(SetMethod_GSZGYDPMMI,1);
}
bResult=true;
}
if (Eq(varName,'HKGGYHAADA')) {
last_focused_comp=GetLastFocusedElementOfLink('HKGGYHAADA');
function SetMethod_HKGGYHAADA() {
Set_G19B(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_HKGGYHAADA();
} else {
setTimeout(SetMethod_HKGGYHAADA,1);
}
bResult=true;
}
if (Eq(varName,'BCOSCDETUR')) {
last_focused_comp=GetLastFocusedElementOfLink('BCOSCDETUR');
function SetMethod_BCOSCDETUR() {
Set_G41(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_BCOSCDETUR();
} else {
setTimeout(SetMethod_BCOSCDETUR,1);
}
bResult=true;
}
if (Eq(varName,'LWFUPEVCFF')) {
last_focused_comp=GetLastFocusedElementOfLink('LWFUPEVCFF');
function SetMethod_LWFUPEVCFF() {
Set_H11(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_LWFUPEVCFF();
} else {
setTimeout(SetMethod_LWFUPEVCFF,1);
}
bResult=true;
}
if (Eq(varName,'LMFVWUIXUQ')) {
last_focused_comp=GetLastFocusedElementOfLink('LMFVWUIXUQ');
function SetMethod_LMFVWUIXUQ() {
Set_H13(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_LMFVWUIXUQ();
} else {
setTimeout(SetMethod_LMFVWUIXUQ,1);
}
bResult=true;
}
if (Eq(varName,'EVWGKCMMJY')) {
last_focused_comp=GetLastFocusedElementOfLink('EVWGKCMMJY');
function SetMethod_EVWGKCMMJY() {
Set_H14A(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_EVWGKCMMJY();
} else {
setTimeout(SetMethod_EVWGKCMMJY,1);
}
bResult=true;
}
if (Eq(varName,'UVHIQLABPT')) {
last_focused_comp=GetLastFocusedElementOfLink('UVHIQLABPT');
function SetMethod_UVHIQLABPT() {
Set_H14B(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_UVHIQLABPT();
} else {
setTimeout(SetMethod_UVHIQLABPT,1);
}
bResult=true;
}
if (Eq(varName,'KCGLCUJYUP')) {
last_focused_comp=GetLastFocusedElementOfLink('KCGLCUJYUP');
function SetMethod_KCGLCUJYUP() {
Set_H19A(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_KCGLCUJYUP();
} else {
setTimeout(SetMethod_KCGLCUJYUP,1);
}
bResult=true;
}
if (Eq(varName,'RQOFXUOOWZ')) {
last_focused_comp=GetLastFocusedElementOfLink('RQOFXUOOWZ');
function SetMethod_RQOFXUOOWZ() {
Set_H19B(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_RQOFXUOOWZ();
} else {
setTimeout(SetMethod_RQOFXUOOWZ,1);
}
bResult=true;
}
if (Eq(varName,'OAWXXEHPRA')) {
last_focused_comp=GetLastFocusedElementOfLink('OAWXXEHPRA');
function SetMethod_OAWXXEHPRA() {
Set_H41(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_OAWXXEHPRA();
} else {
setTimeout(SetMethod_OAWXXEHPRA,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'TIPXBDXITE')) {
return [Ctrl('TIPXBDXITE')];
}
if (Eq(varName,'BQNMQAOIPA')) {
return [Ctrl('BQNMQAOIPA')];
}
if (Eq(varName,'XHIBDWLIOD')) {
return [Ctrl('XHIBDWLIOD')];
}
if (Eq(varName,'IFYLHOXPRS')) {
return [Ctrl('IFYLHOXPRS')];
}
if (Eq(varName,'CKACALWZOL')) {
return [Ctrl('CKACALWZOL')];
}
if (Eq(varName,'ZIMEUPPLZY')) {
return [Ctrl('ZIMEUPPLZY')];
}
if (Eq(varName,'ZZQPEDWGCO')) {
return [Ctrl('ZZQPEDWGCO')];
}
if (Eq(varName,'LTUCQORMSA')) {
return [Ctrl('LTUCQORMSA')];
}
if (Eq(varName,'VDWEKDDBOW')) {
return [Ctrl('VDWEKDDBOW')];
}
if (Eq(varName,'BICDANUWZD')) {
return [Ctrl('BICDANUWZD')];
}
if (Eq(varName,'HDIAJDVNVI')) {
return [Ctrl('HDIAJDVNVI')];
}
if (Eq(varName,'RQJLOLNIHM')) {
return [Ctrl('RQJLOLNIHM')];
}
if (Eq(varName,'CHJJABTJCS')) {
return [Ctrl('CHJJABTJCS')];
}
if (Eq(varName,'DFFBWGMKTL')) {
return [Ctrl('DFFBWGMKTL')];
}
if (Eq(varName,'CDFYKKBMYS')) {
return [Ctrl('CDFYKKBMYS')];
}
if (Eq(varName,'BZRDFHBMPM')) {
return [Ctrl('BZRDFHBMPM')];
}
if (Eq(varName,'UYRQHSBRRT')) {
return [Ctrl('UYRQHSBRRT')];
}
if (Eq(varName,'PMFBITPOAZ')) {
return [Ctrl('PMFBITPOAZ')];
}
if (Eq(varName,'LZSKLOQPNQ')) {
return [Ctrl('LZSKLOQPNQ')];
}
if (Eq(varName,'RHMPOMWSNG')) {
return [Ctrl('RHMPOMWSNG')];
}
if (Eq(varName,'OQJHGGFCNJ')) {
return [Ctrl('OQJHGGFCNJ')];
}
if (Eq(varName,'GMCYYELLWW')) {
return [Ctrl('GMCYYELLWW')];
}
if (Eq(varName,'VZGLYXBMQI')) {
return [Ctrl('VZGLYXBMQI')];
}
if (Eq(varName,'YRFNYFRQSY')) {
return [Ctrl('YRFNYFRQSY')];
}
if (Eq(varName,'ZGFXMEVTVH')) {
return [Ctrl('ZGFXMEVTVH')];
}
if (Eq(varName,'RVQNZAINRJ')) {
return [Ctrl('RVQNZAINRJ')];
}
if (Eq(varName,'DXFRERNUEZ')) {
return [Ctrl('DXFRERNUEZ')];
}
if (Eq(varName,'QZTKKLVNJB')) {
return [Ctrl('QZTKKLVNJB')];
}
if (Eq(varName,'RIPVAPFZCO')) {
return [Ctrl('RIPVAPFZCO')];
}
if (Eq(varName,'QDVHTXVAEJ')) {
return [Ctrl('QDVHTXVAEJ')];
}
if (Eq(varName,'UMGRLGMHMY')) {
return [Ctrl('UMGRLGMHMY')];
}
if (Eq(varName,'GXOOZRXYFU')) {
return [Ctrl('GXOOZRXYFU')];
}
if (Eq(varName,'IMIPLTLEAA')) {
return [Ctrl('IMIPLTLEAA')];
}
if (Eq(varName,'JMWSEEISWG')) {
return [Ctrl('JMWSEEISWG')];
}
if (Eq(varName,'OZDICWDQRW')) {
return [Ctrl('OZDICWDQRW')];
}
if (Eq(varName,'YSNADFXEBL')) {
return [Ctrl('YSNADFXEBL')];
}
if (Eq(varName,'SZZONHIXUX')) {
return [Ctrl('SZZONHIXUX')];
}
if (Eq(varName,'XUTATNAFCN')) {
return [Ctrl('XUTATNAFCN')];
}
if (Eq(varName,'GSQDROOXIH')) {
return [Ctrl('GSQDROOXIH')];
}
if (Eq(varName,'AYOYZWWHED')) {
return [Ctrl('AYOYZWWHED')];
}
if (Eq(varName,'ZKDTAIVYNT')) {
return [Ctrl('ZKDTAIVYNT')];
}
if (Eq(varName,'PGAPCLKWDU')) {
return [Ctrl('PGAPCLKWDU')];
}
if (Eq(varName,'NMVYSCDEYI')) {
return [Ctrl('NMVYSCDEYI')];
}
if (Eq(varName,'IZFSEEEELX')) {
return [Ctrl('IZFSEEEELX')];
}
if (Eq(varName,'RZOPLJQQOD')) {
return [Ctrl('RZOPLJQQOD')];
}
if (Eq(varName,'GSZGYDPMMI')) {
return [Ctrl('GSZGYDPMMI')];
}
if (Eq(varName,'HKGGYHAADA')) {
return [Ctrl('HKGGYHAADA')];
}
if (Eq(varName,'BCOSCDETUR')) {
return [Ctrl('BCOSCDETUR')];
}
if (Eq(varName,'LWFUPEVCFF')) {
return [Ctrl('LWFUPEVCFF')];
}
if (Eq(varName,'LMFVWUIXUQ')) {
return [Ctrl('LMFVWUIXUQ')];
}
if (Eq(varName,'EVWGKCMMJY')) {
return [Ctrl('EVWGKCMMJY')];
}
if (Eq(varName,'UVHIQLABPT')) {
return [Ctrl('UVHIQLABPT')];
}
if (Eq(varName,'KCGLCUJYUP')) {
return [Ctrl('KCGLCUJYUP')];
}
if (Eq(varName,'RQOFXUOOWZ')) {
return [Ctrl('RQOFXUOOWZ')];
}
if (Eq(varName,'OAWXXEHPRA')) {
return [Ctrl('OAWXXEHPRA')];
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
bResult=Le(w_attsel,15);
if ( ! (bResult)) {
m_cLastMsgError=AlertErrorMessage('10523305189');
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
parent.ZtVWeb.raiseEventToEvalParms('armt_ricercamassa_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('armt_ricercamassa_dataNotSent',{'action':formaction});
}
}
}
}
CheckChild.child=[];
function Check() {
var l_bResult = true;
ResetErrorVars();
m_nLastError=0;
if ( ! (_ChkObl('WBNIEXDKHU',1))) {
_SignErr('WBNIEXDKHU');
m_cLastWorkVarErrorMsg='archivio';
l_bResult=false;
w_archivio=HtW('','C');
} else if ( ! (_ChkObl('TESHVPIZQD',1))) {
_SignErr('TESHVPIZQD');
m_cLastWorkVarErrorMsg='1018311362';
l_bResult=false;
w_A01A=HtW('','C');
} else if ( ! (_ChkObl('TIPXBDXITE',1))) {
_SignErr('TIPXBDXITE');
m_cLastWorkVarErrorMsg='A01B';
l_bResult=false;
w_A01B=HtW('','C');
} else if ( ! (_ChkObl('MXWTPQUTBB',1))) {
_SignErr('MXWTPQUTBB');
m_cLastWorkVarErrorMsg='A03';
l_bResult=false;
w_A03=HtW('','C');
} else if ( ! (_ChkObl('BQNMQAOIPA',1))) {
_SignErr('BQNMQAOIPA');
m_cLastWorkVarErrorMsg='A11';
l_bResult=false;
w_A11=HtW('','C');
} else if ( ! (_ChkObl('XHIBDWLIOD',1))) {
_SignErr('XHIBDWLIOD');
m_cLastWorkVarErrorMsg='A12A';
l_bResult=false;
w_A12A=HtW('','C');
} else if ( ! (_ChkObl('IFYLHOXPRS',1))) {
_SignErr('IFYLHOXPRS');
m_cLastWorkVarErrorMsg='A12B';
l_bResult=false;
w_A12B=HtW('','C');
} else if ( ! (_ChkObl('WZNDKFWJMU',1))) {
_SignErr('WZNDKFWJMU');
m_cLastWorkVarErrorMsg='A12C';
l_bResult=false;
w_A12C=HtW('','C');
} else if ( ! (_ChkObl('OOVOWNWMZK',1))) {
_SignErr('OOVOWNWMZK');
m_cLastWorkVarErrorMsg='A21';
l_bResult=false;
w_A21=HtW('','D');
} else if ( ! (_ChkObl('TPGCMCINSD',1))) {
_SignErr('TPGCMCINSD');
m_cLastWorkVarErrorMsg='A22';
l_bResult=false;
w_A22=HtW('','N');
} else if ( ! (_ChkObl('NPNITFAIKW',1))) {
_SignErr('NPNITFAIKW');
m_cLastWorkVarErrorMsg='A23';
l_bResult=false;
w_A23=HtW('','C');
} else if ( ! (_ChkObl('CKACALWZOL',1))) {
_SignErr('CKACALWZOL');
m_cLastWorkVarErrorMsg='A24';
l_bResult=false;
w_A24=HtW('','C');
} else if ( ! (_ChkObl('ZIMEUPPLZY',1))) {
_SignErr('ZIMEUPPLZY');
m_cLastWorkVarErrorMsg='A25';
l_bResult=false;
w_A25=HtW('','C');
} else if ( ! (_ChkObl('EHNAPBXMAR',1))) {
_SignErr('EHNAPBXMAR');
m_cLastWorkVarErrorMsg='A31A';
l_bResult=false;
w_A31A=HtW('','C');
} else if ( ! (_ChkObl('ZZQPEDWGCO',1))) {
_SignErr('ZZQPEDWGCO');
m_cLastWorkVarErrorMsg='A31B';
l_bResult=false;
w_A31B=HtW('','C');
} else if ( ! (_ChkObl('LTUCQORMSA',1))) {
_SignErr('LTUCQORMSA');
m_cLastWorkVarErrorMsg='A32';
l_bResult=false;
w_A32=HtW('','C');
} else if ( ! (_ChkObl('VDWEKDDBOW',1))) {
_SignErr('VDWEKDDBOW');
m_cLastWorkVarErrorMsg='A33A';
l_bResult=false;
w_A33A=HtW('','C');
} else if ( ! (_ChkObl('BICDANUWZD',1))) {
_SignErr('BICDANUWZD');
m_cLastWorkVarErrorMsg='A33B';
l_bResult=false;
w_A33B=HtW('','C');
} else if ( ! (_ChkObl('OCRIGUNQVR',1))) {
_SignErr('OCRIGUNQVR');
m_cLastWorkVarErrorMsg='A33C';
l_bResult=false;
w_A33C=HtW('','C');
} else if ( ! (_ChkObl('PGJPWEXBVK',1))) {
_SignErr('PGJPWEXBVK');
m_cLastWorkVarErrorMsg='A34';
l_bResult=false;
w_A34=HtW('','C');
} else if ( ! (_ChkObl('HDIAJDVNVI',1))) {
_SignErr('HDIAJDVNVI');
m_cLastWorkVarErrorMsg='A41';
l_bResult=false;
w_A41=HtW('','C');
} else if ( ! (_ChkObl('RQJLOLNIHM',1))) {
_SignErr('RQJLOLNIHM');
m_cLastWorkVarErrorMsg='A42';
l_bResult=false;
w_A42=HtW('','C');
} else if ( ! (_ChkObl('CHJJABTJCS',1))) {
_SignErr('CHJJABTJCS');
m_cLastWorkVarErrorMsg='A43';
l_bResult=false;
w_A43=HtW('','C');
} else if ( ! (_ChkObl('KFDSCJBSLJ',1))) {
_SignErr('KFDSCJBSLJ');
m_cLastWorkVarErrorMsg='A51';
l_bResult=false;
w_A51=HtW('','D');
} else if ( ! (_ChkObl('DFFBWGMKTL',1))) {
_SignErr('DFFBWGMKTL');
m_cLastWorkVarErrorMsg='A52B';
l_bResult=false;
w_A52B=HtW('','C');
} else if ( ! (_ChkObl('JPOXBHVIYE',1))) {
_SignErr('JPOXBHVIYE');
m_cLastWorkVarErrorMsg='A53';
l_bResult=false;
w_A53=HtW('','C');
} else if ( ! (_ChkObl('VJIDPHKDWI',1))) {
_SignErr('VJIDPHKDWI');
m_cLastWorkVarErrorMsg='A54A';
l_bResult=false;
w_A54A=HtW('','C');
} else if ( ! (_ChkObl('XYVBVXLTXA',1))) {
_SignErr('XYVBVXLTXA');
m_cLastWorkVarErrorMsg='A54B';
l_bResult=false;
w_A54B=HtW('','D');
} else if ( ! (_ChkObl('MSZJBMMVGZ',1))) {
_SignErr('MSZJBMMVGZ');
m_cLastWorkVarErrorMsg='A54C';
l_bResult=false;
w_A54C=HtW('','C');
} else if ( ! (_ChkObl('EPMUHBJYIP',1))) {
_SignErr('EPMUHBJYIP');
m_cLastWorkVarErrorMsg='B11';
l_bResult=false;
w_B11=HtW('','C');
} else if ( ! (_ChkObl('CDFYKKBMYS',1))) {
_SignErr('CDFYKKBMYS');
m_cLastWorkVarErrorMsg='12027767980';
l_bResult=false;
w_B12=HtW('','C');
} else if ( ! (_ChkObl('AREEANYKOU',1))) {
_SignErr('AREEANYKOU');
m_cLastWorkVarErrorMsg='B13';
l_bResult=false;
w_B13=HtW('','C');
} else if ( ! (_ChkObl('SOZNPELALO',1))) {
_SignErr('SOZNPELALO');
m_cLastWorkVarErrorMsg='B14';
l_bResult=false;
w_B14=HtW('','N');
} else if ( ! (_ChkObl('DNCCUIFECE',1))) {
_SignErr('DNCCUIFECE');
m_cLastWorkVarErrorMsg='B15';
l_bResult=false;
w_B15=HtW('','N');
} else if ( ! (_ChkObl('CFQDRXVJLE',1))) {
_SignErr('CFQDRXVJLE');
m_cLastWorkVarErrorMsg='X_B14_OP';
l_bResult=false;
w_X_B14_OP=HtW('','C');
} else if ( ! (_ChkObl('JNSSKKSFRO',1))) {
_SignErr('JNSSKKSFRO');
m_cLastWorkVarErrorMsg='X_B15_OP';
l_bResult=false;
w_X_B15_OP=HtW('','C');
} else if ( ! (_ChkObl('BZRDFHBMPM',1))) {
_SignErr('BZRDFHBMPM');
m_cLastWorkVarErrorMsg='1018311362';
l_bResult=false;
w_C11=HtW('','C');
} else if ( ! (_ChkObl('UYRQHSBRRT',1))) {
_SignErr('UYRQHSBRRT');
m_cLastWorkVarErrorMsg='C21';
l_bResult=false;
w_C21=HtW('','C');
} else if ( ! (_ChkObl('PMFBITPOAZ',1))) {
_SignErr('PMFBITPOAZ');
m_cLastWorkVarErrorMsg='1018311362';
l_bResult=false;
w_C31=HtW('','C');
} else if ( ! (_ChkObl('LZSKLOQPNQ',1))) {
_SignErr('LZSKLOQPNQ');
m_cLastWorkVarErrorMsg='1018311362';
l_bResult=false;
w_C41=HtW('','C');
} else if ( ! (_ChkObl('RHMPOMWSNG',1))) {
_SignErr('RHMPOMWSNG');
m_cLastWorkVarErrorMsg='1018311362';
l_bResult=false;
w_C51=HtW('','C');
} else if ( ! (_ChkObl('OQJHGGFCNJ',1))) {
_SignErr('OQJHGGFCNJ');
m_cLastWorkVarErrorMsg='1018311362';
l_bResult=false;
w_D11=HtW('','C');
} else if ( ! (_ChkObl('GMCYYELLWW',1))) {
_SignErr('GMCYYELLWW');
m_cLastWorkVarErrorMsg='D13';
l_bResult=false;
w_D13=HtW('','C');
} else if ( ! (_ChkObl('VZGLYXBMQI',1))) {
_SignErr('VZGLYXBMQI');
m_cLastWorkVarErrorMsg='D14A';
l_bResult=false;
w_D14A=HtW('','C');
} else if ( ! (_ChkObl('YRFNYFRQSY',1))) {
_SignErr('YRFNYFRQSY');
m_cLastWorkVarErrorMsg='D14B';
l_bResult=false;
w_D14B=HtW('','C');
} else if ( ! (_ChkObl('RLWWENBDDD',1))) {
_SignErr('RLWWENBDDD');
m_cLastWorkVarErrorMsg='D14C';
l_bResult=false;
w_D14C=HtW('','C');
} else if ( ! (_ChkObl('YCLKMEZUZX',1))) {
_SignErr('YCLKMEZUZX');
m_cLastWorkVarErrorMsg='D15';
l_bResult=false;
w_D15=HtW('','C');
} else if ( ! (_ChkObl('ZIKKMNZCHI',1))) {
_SignErr('ZIKKMNZCHI');
m_cLastWorkVarErrorMsg='D16';
l_bResult=false;
w_D16=HtW('','C');
} else if ( ! (_ChkObl('UEISEWDTOW',1))) {
_SignErr('UEISEWDTOW');
m_cLastWorkVarErrorMsg='D17';
l_bResult=false;
w_D17=HtW('','C');
} else if ( ! (_ChkObl('AZIQXZISZO',1))) {
_SignErr('AZIQXZISZO');
m_cLastWorkVarErrorMsg='D18';
l_bResult=false;
w_D18=HtW('','D');
} else if ( ! (_ChkObl('ZGFXMEVTVH',1))) {
_SignErr('ZGFXMEVTVH');
m_cLastWorkVarErrorMsg='D19A';
l_bResult=false;
w_D19A=HtW('','C');
} else if ( ! (_ChkObl('RVQNZAINRJ',1))) {
_SignErr('RVQNZAINRJ');
m_cLastWorkVarErrorMsg='D19B';
l_bResult=false;
w_D19B=HtW('','C');
} else if ( ! (_ChkObl('DXFRERNUEZ',1))) {
_SignErr('DXFRERNUEZ');
m_cLastWorkVarErrorMsg='D21';
l_bResult=false;
w_D21=HtW('','C');
} else if ( ! (_ChkObl('QZTKKLVNJB',1))) {
_SignErr('QZTKKLVNJB');
m_cLastWorkVarErrorMsg='D22';
l_bResult=false;
w_D22=HtW('','C');
} else if ( ! (_ChkObl('RIPVAPFZCO',1))) {
_SignErr('RIPVAPFZCO');
m_cLastWorkVarErrorMsg='D23';
l_bResult=false;
w_D23=HtW('','C');
} else if ( ! (_ChkObl('QDVHTXVAEJ',1))) {
_SignErr('QDVHTXVAEJ');
m_cLastWorkVarErrorMsg='D41';
l_bResult=false;
w_D41=HtW('','C');
} else if ( ! (_ChkObl('ZZPDVGQXEP',1))) {
_SignErr('ZZPDVGQXEP');
m_cLastWorkVarErrorMsg='D42';
l_bResult=false;
w_D42=HtW('','C');
} else if ( ! (_ChkObl('TCBOHGKRMJ',1))) {
_SignErr('TCBOHGKRMJ');
m_cLastWorkVarErrorMsg='D43';
l_bResult=false;
w_D43=HtW('','D');
} else if ( ! (_ChkObl('YSHERQEZOZ',1))) {
_SignErr('YSHERQEZOZ');
m_cLastWorkVarErrorMsg='D44';
l_bResult=false;
w_D44=HtW('','C');
} else if ( ! (_ChkObl('GEXJBDRMDF',1))) {
_SignErr('GEXJBDRMDF');
m_cLastWorkVarErrorMsg='D45';
l_bResult=false;
w_D45=HtW('','C');
} else if ( ! (_ChkObl('UMGRLGMHMY',1))) {
_SignErr('UMGRLGMHMY');
m_cLastWorkVarErrorMsg='1018311362';
l_bResult=false;
w_E11=HtW('','C');
} else if ( ! (_ChkObl('GXOOZRXYFU',1))) {
_SignErr('GXOOZRXYFU');
m_cLastWorkVarErrorMsg='E13';
l_bResult=false;
w_E13=HtW('','C');
} else if ( ! (_ChkObl('IMIPLTLEAA',1))) {
_SignErr('IMIPLTLEAA');
m_cLastWorkVarErrorMsg='E14A';
l_bResult=false;
w_E14A=HtW('','C');
} else if ( ! (_ChkObl('JMWSEEISWG',1))) {
_SignErr('JMWSEEISWG');
m_cLastWorkVarErrorMsg='E14B';
l_bResult=false;
w_E14B=HtW('','C');
} else if ( ! (_ChkObl('SHRVLATCSU',1))) {
_SignErr('SHRVLATCSU');
m_cLastWorkVarErrorMsg='E14C';
l_bResult=false;
w_E14C=HtW('','C');
} else if ( ! (_ChkObl('VOGKTTTAQY',1))) {
_SignErr('VOGKTTTAQY');
m_cLastWorkVarErrorMsg='E15';
l_bResult=false;
w_E15=HtW('','C');
} else if ( ! (_ChkObl('CSJKLGPLSD',1))) {
_SignErr('CSJKLGPLSD');
m_cLastWorkVarErrorMsg='E16';
l_bResult=false;
w_E16=HtW('','C');
} else if ( ! (_ChkObl('HZXHSFBWVP',1))) {
_SignErr('HZXHSFBWVP');
m_cLastWorkVarErrorMsg='E17';
l_bResult=false;
w_E17=HtW('','C');
} else if ( ! (_ChkObl('STLDMRXUQZ',1))) {
_SignErr('STLDMRXUQZ');
m_cLastWorkVarErrorMsg='E18';
l_bResult=false;
w_E18=HtW('','D');
} else if ( ! (_ChkObl('OZDICWDQRW',1))) {
_SignErr('OZDICWDQRW');
m_cLastWorkVarErrorMsg='E19A';
l_bResult=false;
w_E19A=HtW('','C');
} else if ( ! (_ChkObl('YSNADFXEBL',1))) {
_SignErr('YSNADFXEBL');
m_cLastWorkVarErrorMsg='E19B';
l_bResult=false;
w_E19B=HtW('','C');
} else if ( ! (_ChkObl('SZZONHIXUX',1))) {
_SignErr('SZZONHIXUX');
m_cLastWorkVarErrorMsg='E41';
l_bResult=false;
w_E41=HtW('','C');
} else if ( ! (_ChkObl('GVZBHBTNIN',1))) {
_SignErr('GVZBHBTNIN');
m_cLastWorkVarErrorMsg='E42';
l_bResult=false;
w_E42=HtW('','C');
} else if ( ! (_ChkObl('YTZBMCKQSI',1))) {
_SignErr('YTZBMCKQSI');
m_cLastWorkVarErrorMsg='E43';
l_bResult=false;
w_E43=HtW('','D');
} else if ( ! (_ChkObl('YQCFUVRDIB',1))) {
_SignErr('YQCFUVRDIB');
m_cLastWorkVarErrorMsg='E44';
l_bResult=false;
w_E44=HtW('','C');
} else if ( ! (_ChkObl('RZGRAAMFRQ',1))) {
_SignErr('RZGRAAMFRQ');
m_cLastWorkVarErrorMsg='E45';
l_bResult=false;
w_E45=HtW('','C');
} else if ( ! (_ChkObl('XUTATNAFCN',1))) {
_SignErr('XUTATNAFCN');
m_cLastWorkVarErrorMsg='1018311362';
l_bResult=false;
w_F11=HtW('','C');
} else if ( ! (_ChkObl('GSQDROOXIH',1))) {
_SignErr('GSQDROOXIH');
m_cLastWorkVarErrorMsg='F13';
l_bResult=false;
w_F13=HtW('','C');
} else if ( ! (_ChkObl('AYOYZWWHED',1))) {
_SignErr('AYOYZWWHED');
m_cLastWorkVarErrorMsg='F14A';
l_bResult=false;
w_F14A=HtW('','C');
} else if ( ! (_ChkObl('ZKDTAIVYNT',1))) {
_SignErr('ZKDTAIVYNT');
m_cLastWorkVarErrorMsg='F14B';
l_bResult=false;
w_F14B=HtW('','C');
} else if ( ! (_ChkObl('SBSUVGTSQF',1))) {
_SignErr('SBSUVGTSQF');
m_cLastWorkVarErrorMsg='F14C';
l_bResult=false;
w_F14C=HtW('','C');
} else if ( ! (_ChkObl('TFVSJQEFKN',1))) {
_SignErr('TFVSJQEFKN');
m_cLastWorkVarErrorMsg='F15';
l_bResult=false;
w_F15=HtW('','C');
} else if ( ! (_ChkObl('CSKIGUYWKA',1))) {
_SignErr('CSKIGUYWKA');
m_cLastWorkVarErrorMsg='F16';
l_bResult=false;
w_F16=HtW('','C');
} else if ( ! (_ChkObl('EWALMUXONU',1))) {
_SignErr('EWALMUXONU');
m_cLastWorkVarErrorMsg='F17';
l_bResult=false;
w_F17=HtW('','C');
} else if ( ! (_ChkObl('PGAPCLKWDU',1))) {
_SignErr('PGAPCLKWDU');
m_cLastWorkVarErrorMsg='1018311362';
l_bResult=false;
w_G11=HtW('','C');
} else if ( ! (_ChkObl('NMVYSCDEYI',1))) {
_SignErr('NMVYSCDEYI');
m_cLastWorkVarErrorMsg='G13';
l_bResult=false;
w_G13=HtW('','C');
} else if ( ! (_ChkObl('IZFSEEEELX',1))) {
_SignErr('IZFSEEEELX');
m_cLastWorkVarErrorMsg='G14A';
l_bResult=false;
w_G14A=HtW('','C');
} else if ( ! (_ChkObl('RZOPLJQQOD',1))) {
_SignErr('RZOPLJQQOD');
m_cLastWorkVarErrorMsg='G14B';
l_bResult=false;
w_G14B=HtW('','C');
} else if ( ! (_ChkObl('YZZZVPGQXU',1))) {
_SignErr('YZZZVPGQXU');
m_cLastWorkVarErrorMsg='G14C';
l_bResult=false;
w_G14C=HtW('','C');
} else if ( ! (_ChkObl('YPHNWWQBAM',1))) {
_SignErr('YPHNWWQBAM');
m_cLastWorkVarErrorMsg='G15';
l_bResult=false;
w_G15=HtW('','C');
} else if ( ! (_ChkObl('ALVPQNRJEQ',1))) {
_SignErr('ALVPQNRJEQ');
m_cLastWorkVarErrorMsg='G16';
l_bResult=false;
w_G16=HtW('','C');
} else if ( ! (_ChkObl('IMPXVWAVVG',1))) {
_SignErr('IMPXVWAVVG');
m_cLastWorkVarErrorMsg='G17';
l_bResult=false;
w_G17=HtW('','C');
} else if ( ! (_ChkObl('HICXAQROVP',1))) {
_SignErr('HICXAQROVP');
m_cLastWorkVarErrorMsg='G18';
l_bResult=false;
w_G18=HtW('','D');
} else if ( ! (_ChkObl('GSZGYDPMMI',1))) {
_SignErr('GSZGYDPMMI');
m_cLastWorkVarErrorMsg='G19A';
l_bResult=false;
w_G19A=HtW('','C');
} else if ( ! (_ChkObl('HKGGYHAADA',1))) {
_SignErr('HKGGYHAADA');
m_cLastWorkVarErrorMsg='G19B';
l_bResult=false;
w_G19B=HtW('','C');
} else if ( ! (_ChkObl('BCOSCDETUR',1))) {
_SignErr('BCOSCDETUR');
m_cLastWorkVarErrorMsg='G41';
l_bResult=false;
w_G41=HtW('','C');
} else if ( ! (_ChkObl('KTOZCJXWSV',1))) {
_SignErr('KTOZCJXWSV');
m_cLastWorkVarErrorMsg='G42';
l_bResult=false;
w_G42=HtW('','C');
} else if ( ! (_ChkObl('NVUUMCKUPB',1))) {
_SignErr('NVUUMCKUPB');
m_cLastWorkVarErrorMsg='G43';
l_bResult=false;
w_G43=HtW('','D');
} else if ( ! (_ChkObl('JRWWNQSHYE',1))) {
_SignErr('JRWWNQSHYE');
m_cLastWorkVarErrorMsg='G44';
l_bResult=false;
w_G44=HtW('','C');
} else if ( ! (_ChkObl('HCXFFYRBOR',1))) {
_SignErr('HCXFFYRBOR');
m_cLastWorkVarErrorMsg='G45';
l_bResult=false;
w_G45=HtW('','C');
} else if ( ! (_ChkObl('LWFUPEVCFF',1))) {
_SignErr('LWFUPEVCFF');
m_cLastWorkVarErrorMsg='1018311362';
l_bResult=false;
w_H11=HtW('','C');
} else if ( ! (_ChkObl('LMFVWUIXUQ',1))) {
_SignErr('LMFVWUIXUQ');
m_cLastWorkVarErrorMsg='H13';
l_bResult=false;
w_H13=HtW('','C');
} else if ( ! (_ChkObl('EVWGKCMMJY',1))) {
_SignErr('EVWGKCMMJY');
m_cLastWorkVarErrorMsg='H14A';
l_bResult=false;
w_H14A=HtW('','C');
} else if ( ! (_ChkObl('UVHIQLABPT',1))) {
_SignErr('UVHIQLABPT');
m_cLastWorkVarErrorMsg='H14B';
l_bResult=false;
w_H14B=HtW('','C');
} else if ( ! (_ChkObl('ERDRBGAWFM',1))) {
_SignErr('ERDRBGAWFM');
m_cLastWorkVarErrorMsg='H14C';
l_bResult=false;
w_H14C=HtW('','C');
} else if ( ! (_ChkObl('QCIYKOSBAC',1))) {
_SignErr('QCIYKOSBAC');
m_cLastWorkVarErrorMsg='H15';
l_bResult=false;
w_H15=HtW('','C');
} else if ( ! (_ChkObl('SDOQENNYTS',1))) {
_SignErr('SDOQENNYTS');
m_cLastWorkVarErrorMsg='H16';
l_bResult=false;
w_H16=HtW('','C');
} else if ( ! (_ChkObl('MYCAJZEAYR',1))) {
_SignErr('MYCAJZEAYR');
m_cLastWorkVarErrorMsg='H17';
l_bResult=false;
w_H17=HtW('','C');
} else if ( ! (_ChkObl('MJSLFJOSLC',1))) {
_SignErr('MJSLFJOSLC');
m_cLastWorkVarErrorMsg='H18';
l_bResult=false;
w_H18=HtW('','D');
} else if ( ! (_ChkObl('KCGLCUJYUP',1))) {
_SignErr('KCGLCUJYUP');
m_cLastWorkVarErrorMsg='H19A';
l_bResult=false;
w_H19A=HtW('','C');
} else if ( ! (_ChkObl('RQOFXUOOWZ',1))) {
_SignErr('RQOFXUOOWZ');
m_cLastWorkVarErrorMsg='H19B';
l_bResult=false;
w_H19B=HtW('','C');
} else if ( ! (_ChkObl('OAWXXEHPRA',1))) {
_SignErr('OAWXXEHPRA');
m_cLastWorkVarErrorMsg='H41';
l_bResult=false;
w_H41=HtW('','C');
} else if ( ! (_ChkObl('EVIOJXHHYZ',1))) {
_SignErr('EVIOJXHHYZ');
m_cLastWorkVarErrorMsg='H42';
l_bResult=false;
w_H42=HtW('','C');
} else if ( ! (_ChkObl('AAPLEODVNN',1))) {
_SignErr('AAPLEODVNN');
m_cLastWorkVarErrorMsg='H43';
l_bResult=false;
w_H43=HtW('','D');
} else if ( ! (_ChkObl('PBYCEMAFOR',1))) {
_SignErr('PBYCEMAFOR');
m_cLastWorkVarErrorMsg='H44';
l_bResult=false;
w_H44=HtW('','C');
} else if ( ! (_ChkObl('CCGDGWYZHO',1))) {
_SignErr('CCGDGWYZHO');
m_cLastWorkVarErrorMsg='H45';
l_bResult=false;
w_H45=HtW('','C');
}
if (l_bResult) {
l_bResult=CheckChild(0);
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('TIPXBDXITE_ZOOM',lc)) {
return 0;
}
if (Eq('TIPXBDXITE',lc)) {
return 0;
}
if (Eq('BQNMQAOIPA_ZOOM',lc)) {
return 1;
}
if (Eq('BQNMQAOIPA',lc)) {
return 1;
}
if (Eq('XHIBDWLIOD_ZOOM',lc)) {
return 2;
}
if (Eq('XHIBDWLIOD',lc)) {
return 2;
}
if (Eq('IFYLHOXPRS_ZOOM',lc)) {
return 3;
}
if (Eq('IFYLHOXPRS',lc)) {
return 3;
}
if (Eq('CKACALWZOL_ZOOM',lc)) {
return 4;
}
if (Eq('CKACALWZOL',lc)) {
return 4;
}
if (Eq('ZIMEUPPLZY_ZOOM',lc)) {
return 5;
}
if (Eq('ZIMEUPPLZY',lc)) {
return 5;
}
if (Eq('ZZQPEDWGCO_ZOOM',lc)) {
return 6;
}
if (Eq('ZZQPEDWGCO',lc)) {
return 6;
}
if (Eq('LTUCQORMSA_ZOOM',lc)) {
return 7;
}
if (Eq('LTUCQORMSA',lc)) {
return 7;
}
if (Eq('VDWEKDDBOW_ZOOM',lc)) {
return 8;
}
if (Eq('VDWEKDDBOW',lc)) {
return 8;
}
if (Eq('BICDANUWZD_ZOOM',lc)) {
return 9;
}
if (Eq('BICDANUWZD',lc)) {
return 9;
}
if (Eq('HDIAJDVNVI_ZOOM',lc)) {
return 10;
}
if (Eq('HDIAJDVNVI',lc)) {
return 10;
}
if (Eq('RQJLOLNIHM_ZOOM',lc)) {
return 11;
}
if (Eq('RQJLOLNIHM',lc)) {
return 11;
}
if (Eq('CHJJABTJCS_ZOOM',lc)) {
return 12;
}
if (Eq('CHJJABTJCS',lc)) {
return 12;
}
if (Eq('CDFYKKBMYS_ZOOM',lc)) {
return 13;
}
if (Eq('CDFYKKBMYS',lc)) {
return 13;
}
if (Eq('BZRDFHBMPM_ZOOM',lc)) {
return 14;
}
if (Eq('BZRDFHBMPM',lc)) {
return 14;
}
if (Eq('UYRQHSBRRT_ZOOM',lc)) {
return 15;
}
if (Eq('UYRQHSBRRT',lc)) {
return 15;
}
if (Eq('PMFBITPOAZ_ZOOM',lc)) {
return 16;
}
if (Eq('PMFBITPOAZ',lc)) {
return 16;
}
if (Eq('LZSKLOQPNQ_ZOOM',lc)) {
return 17;
}
if (Eq('LZSKLOQPNQ',lc)) {
return 17;
}
if (Eq('RHMPOMWSNG_ZOOM',lc)) {
return 18;
}
if (Eq('RHMPOMWSNG',lc)) {
return 18;
}
if (Eq('OQJHGGFCNJ_ZOOM',lc)) {
return 19;
}
if (Eq('OQJHGGFCNJ',lc)) {
return 19;
}
if (Eq('GMCYYELLWW_ZOOM',lc)) {
return 20;
}
if (Eq('GMCYYELLWW',lc)) {
return 20;
}
if (Eq('VZGLYXBMQI_ZOOM',lc)) {
return 21;
}
if (Eq('VZGLYXBMQI',lc)) {
return 21;
}
if (Eq('YRFNYFRQSY_ZOOM',lc)) {
return 22;
}
if (Eq('YRFNYFRQSY',lc)) {
return 22;
}
if (Eq('ZGFXMEVTVH_ZOOM',lc)) {
return 23;
}
if (Eq('ZGFXMEVTVH',lc)) {
return 23;
}
if (Eq('RVQNZAINRJ_ZOOM',lc)) {
return 24;
}
if (Eq('RVQNZAINRJ',lc)) {
return 24;
}
if (Eq('DXFRERNUEZ_ZOOM',lc)) {
return 25;
}
if (Eq('DXFRERNUEZ',lc)) {
return 25;
}
if (Eq('QZTKKLVNJB_ZOOM',lc)) {
return 26;
}
if (Eq('QZTKKLVNJB',lc)) {
return 26;
}
if (Eq('RIPVAPFZCO_ZOOM',lc)) {
return 27;
}
if (Eq('RIPVAPFZCO',lc)) {
return 27;
}
if (Eq('QDVHTXVAEJ_ZOOM',lc)) {
return 28;
}
if (Eq('QDVHTXVAEJ',lc)) {
return 28;
}
if (Eq('UMGRLGMHMY_ZOOM',lc)) {
return 29;
}
if (Eq('UMGRLGMHMY',lc)) {
return 29;
}
if (Eq('GXOOZRXYFU_ZOOM',lc)) {
return 30;
}
if (Eq('GXOOZRXYFU',lc)) {
return 30;
}
if (Eq('IMIPLTLEAA_ZOOM',lc)) {
return 31;
}
if (Eq('IMIPLTLEAA',lc)) {
return 31;
}
if (Eq('JMWSEEISWG_ZOOM',lc)) {
return 32;
}
if (Eq('JMWSEEISWG',lc)) {
return 32;
}
if (Eq('OZDICWDQRW_ZOOM',lc)) {
return 33;
}
if (Eq('OZDICWDQRW',lc)) {
return 33;
}
if (Eq('YSNADFXEBL_ZOOM',lc)) {
return 34;
}
if (Eq('YSNADFXEBL',lc)) {
return 34;
}
if (Eq('SZZONHIXUX_ZOOM',lc)) {
return 35;
}
if (Eq('SZZONHIXUX',lc)) {
return 35;
}
if (Eq('XUTATNAFCN_ZOOM',lc)) {
return 36;
}
if (Eq('XUTATNAFCN',lc)) {
return 36;
}
if (Eq('GSQDROOXIH_ZOOM',lc)) {
return 37;
}
if (Eq('GSQDROOXIH',lc)) {
return 37;
}
if (Eq('AYOYZWWHED_ZOOM',lc)) {
return 38;
}
if (Eq('AYOYZWWHED',lc)) {
return 38;
}
if (Eq('ZKDTAIVYNT_ZOOM',lc)) {
return 39;
}
if (Eq('ZKDTAIVYNT',lc)) {
return 39;
}
if (Eq('PGAPCLKWDU_ZOOM',lc)) {
return 40;
}
if (Eq('PGAPCLKWDU',lc)) {
return 40;
}
if (Eq('NMVYSCDEYI_ZOOM',lc)) {
return 41;
}
if (Eq('NMVYSCDEYI',lc)) {
return 41;
}
if (Eq('IZFSEEEELX_ZOOM',lc)) {
return 42;
}
if (Eq('IZFSEEEELX',lc)) {
return 42;
}
if (Eq('RZOPLJQQOD_ZOOM',lc)) {
return 43;
}
if (Eq('RZOPLJQQOD',lc)) {
return 43;
}
if (Eq('GSZGYDPMMI_ZOOM',lc)) {
return 44;
}
if (Eq('GSZGYDPMMI',lc)) {
return 44;
}
if (Eq('HKGGYHAADA_ZOOM',lc)) {
return 45;
}
if (Eq('HKGGYHAADA',lc)) {
return 45;
}
if (Eq('BCOSCDETUR_ZOOM',lc)) {
return 46;
}
if (Eq('BCOSCDETUR',lc)) {
return 46;
}
if (Eq('LWFUPEVCFF_ZOOM',lc)) {
return 47;
}
if (Eq('LWFUPEVCFF',lc)) {
return 47;
}
if (Eq('LMFVWUIXUQ_ZOOM',lc)) {
return 48;
}
if (Eq('LMFVWUIXUQ',lc)) {
return 48;
}
if (Eq('EVWGKCMMJY_ZOOM',lc)) {
return 49;
}
if (Eq('EVWGKCMMJY',lc)) {
return 49;
}
if (Eq('UVHIQLABPT_ZOOM',lc)) {
return 50;
}
if (Eq('UVHIQLABPT',lc)) {
return 50;
}
if (Eq('KCGLCUJYUP_ZOOM',lc)) {
return 51;
}
if (Eq('KCGLCUJYUP',lc)) {
return 51;
}
if (Eq('RQOFXUOOWZ_ZOOM',lc)) {
return 52;
}
if (Eq('RQOFXUOOWZ',lc)) {
return 52;
}
if (Eq('OAWXXEHPRA_ZOOM',lc)) {
return 53;
}
if (Eq('OAWXXEHPRA',lc)) {
return 53;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_TIPXBDXITE();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,1)) {
l_oWv=LOpt_BQNMQAOIPA();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,2)) {
l_oWv=LOpt_XHIBDWLIOD();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,3)) {
l_oWv=LOpt_IFYLHOXPRS();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,4)) {
l_oWv=LOpt_CKACALWZOL();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,5)) {
l_oWv=LOpt_ZIMEUPPLZY();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,6)) {
l_oWv=LOpt_ZZQPEDWGCO();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,7)) {
l_oWv=LOpt_LTUCQORMSA();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,8)) {
l_oWv=LOpt_VDWEKDDBOW();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,9)) {
l_oWv=LOpt_BICDANUWZD();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,10)) {
l_oWv=LOpt_HDIAJDVNVI();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,11)) {
l_oWv=LOpt_RQJLOLNIHM();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,12)) {
l_oWv=LOpt_CHJJABTJCS();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,13)) {
l_oWv=LOpt_CDFYKKBMYS();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,14)) {
l_oWv=LOpt_BZRDFHBMPM();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,15)) {
l_oWv=LOpt_UYRQHSBRRT();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,16)) {
l_oWv=LOpt_PMFBITPOAZ();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,17)) {
l_oWv=LOpt_LZSKLOQPNQ();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,18)) {
l_oWv=LOpt_RHMPOMWSNG();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,19)) {
l_oWv=LOpt_OQJHGGFCNJ();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,20)) {
l_oWv=LOpt_GMCYYELLWW();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,21)) {
l_oWv=LOpt_VZGLYXBMQI();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,22)) {
l_oWv=LOpt_YRFNYFRQSY();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,23)) {
l_oWv=LOpt_ZGFXMEVTVH();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,24)) {
l_oWv=LOpt_RVQNZAINRJ();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,25)) {
l_oWv=LOpt_DXFRERNUEZ();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,26)) {
l_oWv=LOpt_QZTKKLVNJB();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,27)) {
l_oWv=LOpt_RIPVAPFZCO();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,28)) {
l_oWv=LOpt_QDVHTXVAEJ();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,29)) {
l_oWv=LOpt_UMGRLGMHMY();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,30)) {
l_oWv=LOpt_GXOOZRXYFU();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,31)) {
l_oWv=LOpt_IMIPLTLEAA();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,32)) {
l_oWv=LOpt_JMWSEEISWG();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,33)) {
l_oWv=LOpt_OZDICWDQRW();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,34)) {
l_oWv=LOpt_YSNADFXEBL();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,35)) {
l_oWv=LOpt_SZZONHIXUX();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,36)) {
l_oWv=LOpt_XUTATNAFCN();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,37)) {
l_oWv=LOpt_GSQDROOXIH();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,38)) {
l_oWv=LOpt_AYOYZWWHED();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,39)) {
l_oWv=LOpt_ZKDTAIVYNT();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,40)) {
l_oWv=LOpt_PGAPCLKWDU();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,41)) {
l_oWv=LOpt_NMVYSCDEYI();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,42)) {
l_oWv=LOpt_IZFSEEEELX();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,43)) {
l_oWv=LOpt_RZOPLJQQOD();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,44)) {
l_oWv=LOpt_GSZGYDPMMI();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,45)) {
l_oWv=LOpt_HKGGYHAADA();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,46)) {
l_oWv=LOpt_BCOSCDETUR();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,47)) {
l_oWv=LOpt_LWFUPEVCFF();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,48)) {
l_oWv=LOpt_LMFVWUIXUQ();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,49)) {
l_oWv=LOpt_EVWGKCMMJY();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,50)) {
l_oWv=LOpt_UVHIQLABPT();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,51)) {
l_oWv=LOpt_KCGLCUJYUP();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,52)) {
l_oWv=LOpt_RQOFXUOOWZ();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,53)) {
l_oWv=LOpt_OAWXXEHPRA();
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
l_oWv.setValue('attsel',WtA(w_attsel,'N'));
l_oWv.setValue('G11',WtA(w_G11,'C'));
l_oWv.setValue('G13',WtA(w_G13,'C'));
l_oWv.setValue('G14A',WtA(w_G14A,'C'));
l_oWv.setValue('G14B',WtA(w_G14B,'C'));
l_oWv.setValue('G14C',WtA(w_G14C,'C'));
l_oWv.setValue('G15',WtA(w_G15,'C'));
l_oWv.setValue('G16',WtA(w_G16,'C'));
l_oWv.setValue('G17',WtA(w_G17,'C'));
l_oWv.setValue('G18',WtA(w_G18,'D'));
l_oWv.setValue('G19A',WtA(w_G19A,'C'));
l_oWv.setValue('G19B',WtA(w_G19B,'C'));
l_oWv.setValue('G41',WtA(w_G41,'C'));
l_oWv.setValue('G42',WtA(w_G42,'C'));
l_oWv.setValue('G43',WtA(w_G43,'D'));
l_oWv.setValue('G44',WtA(w_G44,'C'));
l_oWv.setValue('F11',WtA(w_F11,'C'));
l_oWv.setValue('F13',WtA(w_F13,'C'));
l_oWv.setValue('F14A',WtA(w_F14A,'C'));
l_oWv.setValue('F14B',WtA(w_F14B,'C'));
l_oWv.setValue('F14C',WtA(w_F14C,'C'));
l_oWv.setValue('F15',WtA(w_F15,'C'));
l_oWv.setValue('F16',WtA(w_F16,'C'));
l_oWv.setValue('F17',WtA(w_F17,'C'));
l_oWv.setValue('E11',WtA(w_E11,'C'));
l_oWv.setValue('E13',WtA(w_E13,'C'));
l_oWv.setValue('E14A',WtA(w_E14A,'C'));
l_oWv.setValue('E14B',WtA(w_E14B,'C'));
l_oWv.setValue('E14C',WtA(w_E14C,'C'));
l_oWv.setValue('E15',WtA(w_E15,'C'));
l_oWv.setValue('E16',WtA(w_E16,'C'));
l_oWv.setValue('E17',WtA(w_E17,'C'));
l_oWv.setValue('E18',WtA(w_E18,'D'));
l_oWv.setValue('E19A',WtA(w_E19A,'C'));
l_oWv.setValue('E19B',WtA(w_E19B,'C'));
l_oWv.setValue('E41',WtA(w_E41,'C'));
l_oWv.setValue('E42',WtA(w_E42,'C'));
l_oWv.setValue('E43',WtA(w_E43,'D'));
l_oWv.setValue('E44',WtA(w_E44,'C'));
l_oWv.setValue('D11',WtA(w_D11,'C'));
l_oWv.setValue('D13',WtA(w_D13,'C'));
l_oWv.setValue('D14A',WtA(w_D14A,'C'));
l_oWv.setValue('D14B',WtA(w_D14B,'C'));
l_oWv.setValue('D14C',WtA(w_D14C,'C'));
l_oWv.setValue('D15',WtA(w_D15,'C'));
l_oWv.setValue('D16',WtA(w_D16,'C'));
l_oWv.setValue('D17',WtA(w_D17,'C'));
l_oWv.setValue('D18',WtA(w_D18,'D'));
l_oWv.setValue('D19A',WtA(w_D19A,'C'));
l_oWv.setValue('D19B',WtA(w_D19B,'C'));
l_oWv.setValue('D21',WtA(w_D21,'C'));
l_oWv.setValue('D22',WtA(w_D22,'C'));
l_oWv.setValue('D23',WtA(w_D23,'C'));
l_oWv.setValue('D41',WtA(w_D41,'C'));
l_oWv.setValue('D42',WtA(w_D42,'C'));
l_oWv.setValue('D43',WtA(w_D43,'D'));
l_oWv.setValue('D44',WtA(w_D44,'C'));
l_oWv.setValue('C11',WtA(w_C11,'C'));
l_oWv.setValue('C21',WtA(w_C21,'C'));
l_oWv.setValue('C31',WtA(w_C31,'C'));
l_oWv.setValue('B11',WtA(w_B11,'C'));
l_oWv.setValue('B12',WtA(w_B12,'C'));
l_oWv.setValue('B13',WtA(w_B13,'C'));
l_oWv.setValue('B14',WtA(w_B14,'N'));
l_oWv.setValue('B15',WtA(w_B15,'N'));
l_oWv.setValue('X_B14_OP',WtA(w_X_B14_OP,'C'));
l_oWv.setValue('X_B15_OP',WtA(w_X_B15_OP,'C'));
l_oWv.setValue('A01A',WtA(w_A01A,'C'));
l_oWv.setValue('A01B',WtA(w_A01B,'C'));
l_oWv.setValue('A03',WtA(w_A03,'C'));
l_oWv.setValue('A11',WtA(w_A11,'C'));
l_oWv.setValue('A12A',WtA(w_A12A,'C'));
l_oWv.setValue('A12B',WtA(w_A12B,'C'));
l_oWv.setValue('A12C',WtA(w_A12C,'C'));
l_oWv.setValue('A21',WtA(w_A21,'D'));
l_oWv.setValue('A22',WtA(w_A22,'N'));
l_oWv.setValue('A23',WtA(w_A23,'C'));
l_oWv.setValue('A24',WtA(w_A24,'C'));
l_oWv.setValue('A25',WtA(w_A25,'C'));
l_oWv.setValue('A31A',WtA(w_A31A,'C'));
l_oWv.setValue('A31B',WtA(w_A31B,'C'));
l_oWv.setValue('A32',WtA(w_A32,'C'));
l_oWv.setValue('A33A',WtA(w_A33A,'C'));
l_oWv.setValue('A33B',WtA(w_A33B,'C'));
l_oWv.setValue('A33C',WtA(w_A33C,'C'));
l_oWv.setValue('A34',WtA(w_A34,'C'));
l_oWv.setValue('A41',WtA(w_A41,'C'));
l_oWv.setValue('A42',WtA(w_A42,'C'));
l_oWv.setValue('A43',WtA(w_A43,'C'));
l_oWv.setValue('A51',WtA(w_A51,'D'));
l_oWv.setValue('A52B',WtA(w_A52B,'C'));
l_oWv.setValue('A53',WtA(w_A53,'C'));
l_oWv.setValue('A54A',WtA(w_A54A,'C'));
l_oWv.setValue('A54B',WtA(w_A54B,'D'));
l_oWv.setValue('A54C',WtA(w_A54C,'C'));
l_oWv.setValue('IDBASE',WtA(w_IDBASE,'C'));
l_oWv.setValue('op_IDBASE',WtA(op_IDBASE,'C'));
l_oWv.setValue('archivio',WtA(w_archivio,'C'));
l_oWv.setValue('C41',WtA(w_C41,'C'));
l_oWv.setValue('C51',WtA(w_C51,'C'));
l_oWv.setValue('H11',WtA(w_H11,'C'));
l_oWv.setValue('H13',WtA(w_H13,'C'));
l_oWv.setValue('H14A',WtA(w_H14A,'C'));
l_oWv.setValue('H14B',WtA(w_H14B,'C'));
l_oWv.setValue('H14C',WtA(w_H14C,'C'));
l_oWv.setValue('H15',WtA(w_H15,'C'));
l_oWv.setValue('H16',WtA(w_H16,'C'));
l_oWv.setValue('H17',WtA(w_H17,'C'));
l_oWv.setValue('H18',WtA(w_H18,'D'));
l_oWv.setValue('H19A',WtA(w_H19A,'C'));
l_oWv.setValue('H19B',WtA(w_H19B,'C'));
l_oWv.setValue('H41',WtA(w_H41,'C'));
l_oWv.setValue('H42',WtA(w_H42,'C'));
l_oWv.setValue('H43',WtA(w_H43,'D'));
l_oWv.setValue('H44',WtA(w_H44,'C'));
l_oWv.setValue('D45',WtA(w_D45,'C'));
l_oWv.setValue('E45',WtA(w_E45,'C'));
l_oWv.setValue('G45',WtA(w_G45,'C'));
l_oWv.setValue('H45',WtA(w_H45,'C'));
l_oWv.setValue('richieste',WtA(w_richieste,'N'));
l_oWv.setValue('xdestipdoct',WtA(w_xdestipdoct,'C'));
l_oWv.setValue('xdestipdocsg',WtA(w_xdestipdocsg,'C'));
l_oWv.setValue('xdessoteco',WtA(w_xdessoteco,'C'));
l_oWv.setValue('xdesramgrp',WtA(w_xdesramgrp,'C'));
l_oWv.setValue('xdessetsin',WtA(w_xdessetsin,'C'));
l_oWv.setValue('xdestipdoc',WtA(w_xdestipdoc,'C'));
l_oWv.setValue('xragintes',WtA(w_xragintes,'C'));
l_oWv.setValue('xragsogope',WtA(w_xragsogope,'C'));
l_oWv.setValue('xragbenef',WtA(w_xragbenef,'C'));
l_oWv.setValue('xdesval',WtA(w_xdesval,'C'));
l_oWv.setValue('xraginter',WtA(w_xraginter,'C'));
l_oWv.setValue('xdesdip',WtA(w_xdesdip,'C'));
l_oWv.setValue('xdescittab',WtA(w_xdescittab,'C'));
l_oWv.setValue('xtipleg',WtA(w_xtipleg,'C'));
l_oWv.setValue('xdesrap',WtA(w_xdesrap,'C'));
l_oWv.setValue('oldval',WtA(w_oldval,'C'));
l_oWv.setValue('xragsecond',WtA(w_xragsecond,'C'));
l_oWv.setValue('xragterzo',WtA(w_xragterzo,'C'));
l_oWv.setValue('xdestipdoct1',WtA(w_xdestipdoct1,'C'));
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
FillWv.n=["attsel","G11","G13","G14A","G14B","G14C","G15","G16","G17","G18","G19A","G19B","G41","G42","G43","G44","F11","F13","F14A","F14B","F14C","F15","F16","F17","E11","E13","E14A","E14B","E14C","E15","E16","E17","E18","E19A","E19B","E41","E42","E43","E44","D11","D13","D14A","D14B","D14C","D15","D16","D17","D18","D19A","D19B","D21","D22","D23","D41","D42","D43","D44","C11","C21","C31","B11","B12","B13","B14","B15","X_B14_OP","X_B15_OP","A01A","A01B","A03","A11","A12A","A12B","A12C","A21","A22","A23","A24","A25","A31A","A31B","A32","A33A","A33B","A33C","A34","A41","A42","A43","A51","A52B","A53","A54A","A54B","A54C","IDBASE","archivio","C41","C51","H11","H13","H14A","H14B","H14C","H15","H16","H17","H18","H19A","H19B","H41","H42","H43","H44","D45","E45","G45","H45","richieste","xdestipdoct","xdestipdocsg","xdessoteco","xdesramgrp","xdessetsin","xdestipdoc","xragintes","xragsogope","xragbenef","xdesval","xraginter","xdesdip","xdescittab","xtipleg","xdesrap","oldval","xragsecond","xragterzo","xdestipdoct1"];
function SetModified() {
m_bUpdated=true;
}
