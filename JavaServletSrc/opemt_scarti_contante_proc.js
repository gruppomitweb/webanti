function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('VEWEVUUXXI',function(){return WtH(w_NUMPROG,'C',11,0,'')},w_NUMPROG);
SPBOUILib.SetInputValue('UXBCLLCOFQ',function(){return WtH(w_TIPATT,'C',3,0,'')},w_TIPATT);
SPBOUILib.SetInputValue('FHWRILAIPO',function(){return WtH(w_TIPOATTIV,'C',2,0,'')},w_TIPOATTIV);
SPBOUILib.SetInputValue('AXUMKZOKCH',function(){return WtH(w_CODICEGLN,'C',13,0,'')},w_CODICEGLN);
SPBOUILib.SetInputValue('YMYGTNKGKH',function(){return WtH(w_TOTBANKNOTE,'N',10,0,'9999999999')},w_TOTBANKNOTE);
SPBOUILib.SetInputValue('EGZMGNMCXT',function(){return WtH(w_TAGLIO,'N',4,0,'9999')},w_TAGLIO);
SPBOUILib.SetInputValue('CEDXAOEKBO',function(){return WtH(w_NBANCONOTE,'N',10,0,'9999999999')},w_NBANCONOTE);
SPBOUILib.SetInputValue('WICMVXKWNU',function(){return WtH(w_ABIINTER,'C',5,0,'')},w_ABIINTER);
SPBOUILib.SetInputValue('QJYYWZREMR',function(){return WtH(w_ABIPROPR,'C',5,0,'')},w_ABIPROPR);
SPBOUILib.SetInputValue('WATBQSRCOH',function(){return WtH(w_GLNALTROSOG,'C',13,0,'')},w_GLNALTROSOG);
SPBOUILib.SetInputValue('SBRRHXIECX',function(){return WtH(w_GLNALTRASC,'C',13,0,'')},w_GLNALTRASC);
SPBOUILib.SetInputValue('LQMKDFHHGB',function(){return WtH(w_CODCLICON,'C',20,0,'')},w_CODCLICON);
SPBOUILib.SetInputValue('GRWUSBIQAB',function(){return WtH(w_CODCOMCON,'C',6,0,'')},w_CODCOMCON);
SPBOUILib.SetInputValue('KHSAIRWIFT',function(){return WtH(w_ATECO_CON,'C',10,0,'')},w_ATECO_CON);
SPBOUILib.SetInputValue('TSDHDXKEKJ',function(){return WtH(w_CODDIPE,'C',6,0,'')},w_CODDIPE);
SPBOUILib.SetInputValue('HOPNJWOADW',function(){return WtH(w_IMPPROG,'C',13,0,'')},w_IMPPROG);
if (m_bExtended) {
SetExtensions();
}
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
LibJavascript.forEachItem(m_FoundlingHideExpression,i_body_2)
function i_body_2(child){
child();
}
HideUI();
}
HideUI.lblids["ABIINTER"]=['GEPFKOASEB'];
HideUI.lblids["ABIPROPR"]=['YYJPBEIVLG'];
HideUI.lblids["ATECO_CON"]=['FVZLXRBZDM'];
HideUI.lblids["CODCLICON"]=['HVKUYPTVKH'];
HideUI.lblids["CODCOMCON"]=['AQMHSVMQTR'];
HideUI.lblids["CODDIPE"]=['WIVXVAXZPK'];
HideUI.lblids["CODICEGLN"]=['AQTWKMCUEZ'];
HideUI.lblids["GLNALTRASC"]=['IIMSCYBKMD'];
HideUI.lblids["GLNALTROSOG"]=['ARRQAZRCWF'];
HideUI.lblids["NBANCONOTE"]=['ALKQYEJUNO'];
HideUI.lblids["NUMPROG"]=['LKCMHPRAVK'];
HideUI.lblids["TAGLIO"]=['DZSURDPGFS'];
HideUI.lblids["TIPATT"]=['SMZOFXDFWF'];
HideUI.lblids["TIPOATTIV"]=['VXLOWBQMKO'];
HideUI.lblids["TOTBANKNOTE"]=['DLSTIRTQED'];
function VEWEVUUXXI_Valid(e) {
SetActiveField(Ctrl('VEWEVUUXXI'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('VEWEVUUXXI') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('NUMPROG','C',w_NUMPROG,HtW(Ctrl('VEWEVUUXXI').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_NUMPROG(HtW(Ctrl('VEWEVUUXXI').value,'C'),null,e);
return l_bSetResult;
}
}
function VEWEVUUXXI_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('VEWEVUUXXI'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('VEWEVUUXXI'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('VEWEVUUXXI'),e);
}
function UXBCLLCOFQ_Valid(e) {
SetActiveField(Ctrl('UXBCLLCOFQ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TIPATT','C',w_TIPATT,HtW(Ctrl('UXBCLLCOFQ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TIPATT(HtW(Ctrl('UXBCLLCOFQ').value,'C'),null,e);
return l_bSetResult;
}
}
function UXBCLLCOFQ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('UXBCLLCOFQ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('UXBCLLCOFQ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('UXBCLLCOFQ'),e);
}
function FHWRILAIPO_Valid(e) {
SetActiveField(Ctrl('FHWRILAIPO'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TIPOATTIV','C',w_TIPOATTIV,HtW(Ctrl('FHWRILAIPO').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TIPOATTIV(HtW(Ctrl('FHWRILAIPO').value,'C'),null,e);
return l_bSetResult;
}
}
function FHWRILAIPO_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('FHWRILAIPO'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('FHWRILAIPO'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('FHWRILAIPO'),e);
}
function AXUMKZOKCH_Valid(e) {
SetActiveField(Ctrl('AXUMKZOKCH'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CODICEGLN','C',w_CODICEGLN,HtW(Ctrl('AXUMKZOKCH').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODICEGLN(HtW(Ctrl('AXUMKZOKCH').value,'C'),null,e);
return l_bSetResult;
}
}
function AXUMKZOKCH_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('AXUMKZOKCH'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('AXUMKZOKCH'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('AXUMKZOKCH'),e);
}
function YMYGTNKGKH_Valid(e) {
SetActiveField(Ctrl('YMYGTNKGKH'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TOTBANKNOTE','N',w_TOTBANKNOTE,HtW(Ctrl('YMYGTNKGKH').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TOTBANKNOTE(HtW(Ctrl('YMYGTNKGKH').value,'N'),null,e);
return l_bSetResult;
}
}
function YMYGTNKGKH_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('YMYGTNKGKH'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('YMYGTNKGKH',w_TOTBANKNOTE,'N',10,0,'9999999999');
SetActiveField(Ctrl('YMYGTNKGKH'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('YMYGTNKGKH'),e);
}
function YMYGTNKGKH_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("9999999999"));
}
function EGZMGNMCXT_Valid(e) {
SetActiveField(Ctrl('EGZMGNMCXT'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TAGLIO','N',w_TAGLIO,HtW(Ctrl('EGZMGNMCXT').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TAGLIO(HtW(Ctrl('EGZMGNMCXT').value,'N'),null,e);
return l_bSetResult;
}
}
function EGZMGNMCXT_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('EGZMGNMCXT'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('EGZMGNMCXT',w_TAGLIO,'N',4,0,'9999');
SetActiveField(Ctrl('EGZMGNMCXT'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('EGZMGNMCXT'),e);
}
function EGZMGNMCXT_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("9999"));
}
function CEDXAOEKBO_Valid(e) {
SetActiveField(Ctrl('CEDXAOEKBO'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('NBANCONOTE','N',w_NBANCONOTE,HtW(Ctrl('CEDXAOEKBO').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_NBANCONOTE(HtW(Ctrl('CEDXAOEKBO').value,'N'),null,e);
return l_bSetResult;
}
}
function CEDXAOEKBO_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('CEDXAOEKBO'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('CEDXAOEKBO',w_NBANCONOTE,'N',10,0,'9999999999');
SetActiveField(Ctrl('CEDXAOEKBO'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('CEDXAOEKBO'),e);
}
function CEDXAOEKBO_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("9999999999"));
}
function WICMVXKWNU_Valid(e) {
SetActiveField(Ctrl('WICMVXKWNU'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('ABIINTER','C',w_ABIINTER,HtW(Ctrl('WICMVXKWNU').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ABIINTER(HtW(Ctrl('WICMVXKWNU').value,'C'),null,e);
return l_bSetResult;
}
}
function WICMVXKWNU_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('WICMVXKWNU'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('WICMVXKWNU'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('WICMVXKWNU'),e);
}
function QJYYWZREMR_Valid(e) {
SetActiveField(Ctrl('QJYYWZREMR'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('ABIPROPR','C',w_ABIPROPR,HtW(Ctrl('QJYYWZREMR').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ABIPROPR(HtW(Ctrl('QJYYWZREMR').value,'C'),null,e);
return l_bSetResult;
}
}
function QJYYWZREMR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('QJYYWZREMR'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('QJYYWZREMR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('QJYYWZREMR'),e);
}
function WATBQSRCOH_Valid(e) {
SetActiveField(Ctrl('WATBQSRCOH'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('GLNALTROSOG','C',w_GLNALTROSOG,HtW(Ctrl('WATBQSRCOH').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_GLNALTROSOG(HtW(Ctrl('WATBQSRCOH').value,'C'),null,e);
return l_bSetResult;
}
}
function WATBQSRCOH_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('WATBQSRCOH'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('WATBQSRCOH'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('WATBQSRCOH'),e);
}
function SBRRHXIECX_Valid(e) {
SetActiveField(Ctrl('SBRRHXIECX'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('GLNALTRASC','C',w_GLNALTRASC,HtW(Ctrl('SBRRHXIECX').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_GLNALTRASC(HtW(Ctrl('SBRRHXIECX').value,'C'),null,e);
return l_bSetResult;
}
}
function SBRRHXIECX_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('SBRRHXIECX'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('SBRRHXIECX'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('SBRRHXIECX'),e);
}
function LQMKDFHHGB_Valid(e) {
SetActiveField(Ctrl('LQMKDFHHGB'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CODCLICON','C',w_CODCLICON,HtW(Ctrl('LQMKDFHHGB').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODCLICON(HtW(Ctrl('LQMKDFHHGB').value,'C'),null,e);
return l_bSetResult;
}
}
function LQMKDFHHGB_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('LQMKDFHHGB'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('LQMKDFHHGB'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('LQMKDFHHGB'),e);
}
function GRWUSBIQAB_Valid(e) {
SetActiveField(Ctrl('GRWUSBIQAB'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CODCOMCON','C',w_CODCOMCON,HtW(Ctrl('GRWUSBIQAB').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODCOMCON(HtW(Ctrl('GRWUSBIQAB').value,'C'),null,e);
return l_bSetResult;
}
}
function GRWUSBIQAB_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('GRWUSBIQAB'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('GRWUSBIQAB'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('GRWUSBIQAB'),e);
}
function KHSAIRWIFT_Valid(e) {
SetActiveField(Ctrl('KHSAIRWIFT'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('ATECO_CON','C',w_ATECO_CON,HtW(Ctrl('KHSAIRWIFT').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ATECO_CON(HtW(Ctrl('KHSAIRWIFT').value,'C'),null,e);
return l_bSetResult;
}
}
function KHSAIRWIFT_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('KHSAIRWIFT'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('KHSAIRWIFT'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('KHSAIRWIFT'),e);
}
function TSDHDXKEKJ_Valid(e) {
SetActiveField(Ctrl('TSDHDXKEKJ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CODDIPE','C',w_CODDIPE,HtW(Ctrl('TSDHDXKEKJ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODDIPE(HtW(Ctrl('TSDHDXKEKJ').value,'C'),null,e);
return l_bSetResult;
}
}
function TSDHDXKEKJ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('TSDHDXKEKJ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('TSDHDXKEKJ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('TSDHDXKEKJ'),e);
}
function HOPNJWOADW_Valid(e) {
SetActiveField(Ctrl('HOPNJWOADW'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('IMPPROG','C',w_IMPPROG,HtW(Ctrl('HOPNJWOADW').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IMPPROG(HtW(Ctrl('HOPNJWOADW').value,'C'),null,e);
return l_bSetResult;
}
}
function HOPNJWOADW_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('HOPNJWOADW'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('HOPNJWOADW'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('HOPNJWOADW'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function VEWEVUUXXI_wrap_Valid(event) {
return VEWEVUUXXI_Valid(event);
}
SPBOUILib.SetInputExit('VEWEVUUXXI',VEWEVUUXXI_wrap_Valid);
function VEWEVUUXXI_wrap_OnFocus(event) {
return VEWEVUUXXI_OnFocus(event);
}
SPBOUILib.SetInputEnter('VEWEVUUXXI',VEWEVUUXXI_wrap_OnFocus);
function VEWEVUUXXI_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('VEWEVUUXXI',VEWEVUUXXI_wrap_OnKeyDown);
function UXBCLLCOFQ_wrap_Valid(event) {
return UXBCLLCOFQ_Valid(event);
}
SPBOUILib.SetInputExit('UXBCLLCOFQ',UXBCLLCOFQ_wrap_Valid);
function UXBCLLCOFQ_wrap_OnFocus(event) {
return UXBCLLCOFQ_OnFocus(event);
}
SPBOUILib.SetInputEnter('UXBCLLCOFQ',UXBCLLCOFQ_wrap_OnFocus);
function UXBCLLCOFQ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('UXBCLLCOFQ',UXBCLLCOFQ_wrap_OnKeyDown);
function FHWRILAIPO_wrap_Valid(event) {
return FHWRILAIPO_Valid(event);
}
SPBOUILib.SetInputExit('FHWRILAIPO',FHWRILAIPO_wrap_Valid);
function FHWRILAIPO_wrap_OnFocus(event) {
return FHWRILAIPO_OnFocus(event);
}
SPBOUILib.SetInputEnter('FHWRILAIPO',FHWRILAIPO_wrap_OnFocus);
function FHWRILAIPO_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('FHWRILAIPO',FHWRILAIPO_wrap_OnKeyDown);
function AXUMKZOKCH_wrap_Valid(event) {
return AXUMKZOKCH_Valid(event);
}
SPBOUILib.SetInputExit('AXUMKZOKCH',AXUMKZOKCH_wrap_Valid);
function AXUMKZOKCH_wrap_OnFocus(event) {
return AXUMKZOKCH_OnFocus(event);
}
SPBOUILib.SetInputEnter('AXUMKZOKCH',AXUMKZOKCH_wrap_OnFocus);
function AXUMKZOKCH_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('AXUMKZOKCH',AXUMKZOKCH_wrap_OnKeyDown);
function YMYGTNKGKH_wrap_Valid(event) {
return YMYGTNKGKH_Valid(event);
}
SPBOUILib.SetInputExit('YMYGTNKGKH',YMYGTNKGKH_wrap_Valid);
function YMYGTNKGKH_wrap_OnFocus(event) {
return YMYGTNKGKH_OnFocus(event);
}
SPBOUILib.SetInputEnter('YMYGTNKGKH',YMYGTNKGKH_wrap_OnFocus);
function YMYGTNKGKH_wrap_OnKeyPress(event) {
return YMYGTNKGKH_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('YMYGTNKGKH',YMYGTNKGKH_wrap_OnKeyPress);
function YMYGTNKGKH_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('YMYGTNKGKH',YMYGTNKGKH_wrap_OnKeyDown);
function EGZMGNMCXT_wrap_Valid(event) {
return EGZMGNMCXT_Valid(event);
}
SPBOUILib.SetInputExit('EGZMGNMCXT',EGZMGNMCXT_wrap_Valid);
function EGZMGNMCXT_wrap_OnFocus(event) {
return EGZMGNMCXT_OnFocus(event);
}
SPBOUILib.SetInputEnter('EGZMGNMCXT',EGZMGNMCXT_wrap_OnFocus);
function EGZMGNMCXT_wrap_OnKeyPress(event) {
return EGZMGNMCXT_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('EGZMGNMCXT',EGZMGNMCXT_wrap_OnKeyPress);
function EGZMGNMCXT_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('EGZMGNMCXT',EGZMGNMCXT_wrap_OnKeyDown);
function CEDXAOEKBO_wrap_Valid(event) {
return CEDXAOEKBO_Valid(event);
}
SPBOUILib.SetInputExit('CEDXAOEKBO',CEDXAOEKBO_wrap_Valid);
function CEDXAOEKBO_wrap_OnFocus(event) {
return CEDXAOEKBO_OnFocus(event);
}
SPBOUILib.SetInputEnter('CEDXAOEKBO',CEDXAOEKBO_wrap_OnFocus);
function CEDXAOEKBO_wrap_OnKeyPress(event) {
return CEDXAOEKBO_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('CEDXAOEKBO',CEDXAOEKBO_wrap_OnKeyPress);
function CEDXAOEKBO_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('CEDXAOEKBO',CEDXAOEKBO_wrap_OnKeyDown);
function WICMVXKWNU_wrap_Valid(event) {
return WICMVXKWNU_Valid(event);
}
SPBOUILib.SetInputExit('WICMVXKWNU',WICMVXKWNU_wrap_Valid);
function WICMVXKWNU_wrap_OnFocus(event) {
return WICMVXKWNU_OnFocus(event);
}
SPBOUILib.SetInputEnter('WICMVXKWNU',WICMVXKWNU_wrap_OnFocus);
function WICMVXKWNU_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('WICMVXKWNU',WICMVXKWNU_wrap_OnKeyDown);
function QJYYWZREMR_wrap_Valid(event) {
return QJYYWZREMR_Valid(event);
}
SPBOUILib.SetInputExit('QJYYWZREMR',QJYYWZREMR_wrap_Valid);
function QJYYWZREMR_wrap_OnFocus(event) {
return QJYYWZREMR_OnFocus(event);
}
SPBOUILib.SetInputEnter('QJYYWZREMR',QJYYWZREMR_wrap_OnFocus);
function QJYYWZREMR_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('QJYYWZREMR',QJYYWZREMR_wrap_OnKeyDown);
function WATBQSRCOH_wrap_Valid(event) {
return WATBQSRCOH_Valid(event);
}
SPBOUILib.SetInputExit('WATBQSRCOH',WATBQSRCOH_wrap_Valid);
function WATBQSRCOH_wrap_OnFocus(event) {
return WATBQSRCOH_OnFocus(event);
}
SPBOUILib.SetInputEnter('WATBQSRCOH',WATBQSRCOH_wrap_OnFocus);
function WATBQSRCOH_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('WATBQSRCOH',WATBQSRCOH_wrap_OnKeyDown);
function SBRRHXIECX_wrap_Valid(event) {
return SBRRHXIECX_Valid(event);
}
SPBOUILib.SetInputExit('SBRRHXIECX',SBRRHXIECX_wrap_Valid);
function SBRRHXIECX_wrap_OnFocus(event) {
return SBRRHXIECX_OnFocus(event);
}
SPBOUILib.SetInputEnter('SBRRHXIECX',SBRRHXIECX_wrap_OnFocus);
function SBRRHXIECX_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('SBRRHXIECX',SBRRHXIECX_wrap_OnKeyDown);
function LQMKDFHHGB_wrap_Valid(event) {
return LQMKDFHHGB_Valid(event);
}
SPBOUILib.SetInputExit('LQMKDFHHGB',LQMKDFHHGB_wrap_Valid);
function LQMKDFHHGB_wrap_OnFocus(event) {
return LQMKDFHHGB_OnFocus(event);
}
SPBOUILib.SetInputEnter('LQMKDFHHGB',LQMKDFHHGB_wrap_OnFocus);
function LQMKDFHHGB_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('LQMKDFHHGB',LQMKDFHHGB_wrap_OnKeyDown);
function GRWUSBIQAB_wrap_Valid(event) {
return GRWUSBIQAB_Valid(event);
}
SPBOUILib.SetInputExit('GRWUSBIQAB',GRWUSBIQAB_wrap_Valid);
function GRWUSBIQAB_wrap_OnFocus(event) {
return GRWUSBIQAB_OnFocus(event);
}
SPBOUILib.SetInputEnter('GRWUSBIQAB',GRWUSBIQAB_wrap_OnFocus);
function GRWUSBIQAB_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('GRWUSBIQAB',GRWUSBIQAB_wrap_OnKeyDown);
function KHSAIRWIFT_wrap_Valid(event) {
return KHSAIRWIFT_Valid(event);
}
SPBOUILib.SetInputExit('KHSAIRWIFT',KHSAIRWIFT_wrap_Valid);
function KHSAIRWIFT_wrap_OnFocus(event) {
return KHSAIRWIFT_OnFocus(event);
}
SPBOUILib.SetInputEnter('KHSAIRWIFT',KHSAIRWIFT_wrap_OnFocus);
function KHSAIRWIFT_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('KHSAIRWIFT',KHSAIRWIFT_wrap_OnKeyDown);
function TSDHDXKEKJ_wrap_Valid(event) {
return TSDHDXKEKJ_Valid(event);
}
SPBOUILib.SetInputExit('TSDHDXKEKJ',TSDHDXKEKJ_wrap_Valid);
function TSDHDXKEKJ_wrap_OnFocus(event) {
return TSDHDXKEKJ_OnFocus(event);
}
SPBOUILib.SetInputEnter('TSDHDXKEKJ',TSDHDXKEKJ_wrap_OnFocus);
function TSDHDXKEKJ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('TSDHDXKEKJ',TSDHDXKEKJ_wrap_OnKeyDown);
function HOPNJWOADW_wrap_Valid(event) {
return HOPNJWOADW_Valid(event);
}
SPBOUILib.SetInputExit('HOPNJWOADW',HOPNJWOADW_wrap_Valid);
function HOPNJWOADW_wrap_OnFocus(event) {
return HOPNJWOADW_OnFocus(event);
}
SPBOUILib.SetInputEnter('HOPNJWOADW',HOPNJWOADW_wrap_OnFocus);
function HOPNJWOADW_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('HOPNJWOADW',HOPNJWOADW_wrap_OnKeyDown);
if (m_bExtended) {
SetEventsAndStylesToExtendedFields();
}
}
if (Eq(m_nChildStatus,0)) {
if (Eq(m_cFunction,'query') && Ne(document.FrmToolbar,null)) {
document.FrmToolbar.pos.onkeypress=RecPositionInput;
document.FrmToolbar.pos.onblur=SelectRecord;
}
}
}
function NotifyEvent(p_cEvent) {
var old_c;
}
function SetLastFocusedOnParent() {
if (IsWndAccessible(window['m_oFather'])) {
m_oFather.i_last_focused_item='child_opemt_scarti_contante';
m_oFather.last_focused_comp=null;
m_oFather.SetLastFocusedOnParent();
}
}
function DoUpdate(p_bResult) {
if (Ne(m_cFunction,'query') && Ne(m_cFunction,'view')) {
Calculate();
SaveDependsOn();
SetControlsValue();
SetDynamicClasses();
SetDynamicTooltip();
EnableControlsUnderCondition();
SaveLabelDependsOn();
}
if ( ! (p_bResult)) {
DisplayErrorMessage();
}
m_nLastError=0;
m_cLastMsgError='';
}
FocusFirstComponent.edit={"page_1":["UXBCLLCOFQ"]};
FocusFirstComponent.query={"page_1":["VEWEVUUXXI"]};
FocusFirstComponent.otherwise={"page_1":["VEWEVUUXXI"]};
function Help() {
windowOpenForeground('../doc/opemt_scarti_contante_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
}
function CalledBatchEnd() {
if ( ! (m_bCalculating)) {
DoUpdate(true);
}
}
function LoadChildrenInPage(page,lazy) {
}
function DeclareWVs() {
var a = arguments;
w_NUMPROG=a[0];
w_TIPATT=a[1];
w_TIPOATTIV=a[2];
w_CODICEGLN=a[3];
w_TOTBANKNOTE=a[4];
w_TAGLIO=a[5];
w_NBANCONOTE=a[6];
w_ABIINTER=a[7];
w_ABIPROPR=a[8];
w_GLNALTROSOG=a[9];
w_GLNALTRASC=a[10];
w_CODCLICON=a[11];
w_CODCOMCON=a[12];
w_ATECO_CON=a[13];
w_CODDIPE=a[14];
w_IMPPROG=a[15];
m_PrimaryKeys=['NUMPROG'];
}
function i_PrimaryKey() {
return 'scarto_contante'+'\\'+CPLib.ToCPStr(w_NUMPROG);
}
function CheckZone(me) {
if (IsWndAccessible(window['m_oFather'])) {
return m_oFather.CheckZone('child_opemt_scarti_contante');
}
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('opemt_scarti_contante',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
function LinkZoomExtendedMenu() {
}
_Obli('NUMPROG',0,'VEWEVUUXXI',false,"11383164399")
_Obli('TIPATT',0,'UXBCLLCOFQ',false,"11155590227")
_Obli('TIPOATTIV',0,'FHWRILAIPO',false,"12037434587")
_Obli('CODICEGLN',0,'AXUMKZOKCH',false,"11997494697")
_Obli('TOTBANKNOTE',1,'YMYGTNKGKH',false,"1063292795")
_Obli('TAGLIO',1,'EGZMGNMCXT',false,"10758806619")
_Obli('NBANCONOTE',1,'CEDXAOEKBO',false,"1514933900")
_Obli('ABIINTER',0,'WICMVXKWNU',false,"10743769582")
_Obli('ABIPROPR',0,'QJYYWZREMR',false,"10688195229")
_Obli('GLNALTROSOG',0,'WATBQSRCOH',false,"1189191642")
_Obli('GLNALTRASC',0,'SBRRHXIECX',false,"11648440646")
_Obli('CODCLICON',0,'LQMKDFHHGB',false,"439997054")
_Obli('CODCOMCON',0,'GRWUSBIQAB',false,"1867589130")
_Obli('ATECO_CON',0,'KHSAIRWIFT',false,"11965763392")
_Obli('CODDIPE',0,'TSDHDXKEKJ',false,"2071283709")
_Obli('IMPPROG',0,'HOPNJWOADW',false,"283403499")
