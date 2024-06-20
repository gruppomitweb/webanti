function FillCombosValues() {
}
function FillInGridCombosValues(currentRow) {
var postfix = (Gt(currentRow,-1)?'_'+currentRow:'');
}
function SetControlsValue() {
var c;
if (Empty(m_cAltInterface) && (Eq(m_cFunction,'view') || Eq(m_cFunction,'query'))) {
if(c=Ctrl('HOLHIEEXOR')) selectCombo(c,w_TIPATT,'C')
if(c=Ctrl('RYMHYALKWD')) selectCombo(c,w_TIPOATTIV,'C')
SPBOUILib.SetInputValue('YVJSXFLERW',function(){return WtH(w_CODICEGLN,'C',13,0,'')},w_CODICEGLN);
SPBOUILib.SetInputValue('CXLASTSRKJ',function(){return WtH(w_CODCLICON,'C',20,0,'')},w_CODCLICON);
SPBOUILib.SetInputValue('IACBXHVCCO',function(){return WtH(w_ATECO_CON,'C',10,0,'')},w_ATECO_CON);
var tmp_JNJVIVLVGV = ToHTag(AsControlValue(w_xDESATECO));
if (Ne(e_JNJVIVLVGV,tmp_JNJVIVLVGV)) {
SPBOUILib.SetLabelValue('JNJVIVLVGV','innerHTML',tmp_JNJVIVLVGV);
e_JNJVIVLVGV=tmp_JNJVIVLVGV;
}
SPBOUILib.SetInputValue('JCXOTDXIKP',function(){return WtH(w_CODCOMCON,'C',6,0,'')},w_CODCOMCON);
var tmp_ZKEIQTRRZO = ToHTag(AsControlValue(w_xDESCITTA));
if (Ne(e_ZKEIQTRRZO,tmp_ZKEIQTRRZO)) {
SPBOUILib.SetLabelValue('ZKEIQTRRZO','innerHTML',tmp_ZKEIQTRRZO);
e_ZKEIQTRRZO=tmp_ZKEIQTRRZO;
}
SPBOUILib.SetInputValue('YXYPHIFKZT',function(){return WtH(w_ABIINTER,'C',5,0,'')},w_ABIINTER);
SPBOUILib.SetInputValue('GYFXWZOJEE',function(){return WtH(w_ABIPROPR,'C',5,0,'')},w_ABIPROPR);
SPBOUILib.SetInputValue('PJGQZBLXYX',function(){return WtH(w_GLNALTROSOG,'C',13,0,'')},w_GLNALTROSOG);
SPBOUILib.SetInputValue('JZUTNDTOOI',function(){return WtH(w_GLNALTRASC,'C',13,0,'')},w_GLNALTRASC);
SPBOUILib.SetInputValue('AHEQBLEXHM',function(){return WtH(w_BILLSRIT,'N',10,0,'9999999999')},w_BILLSRIT);
SPBOUILib.SetInputValue('VHTWYZSCLL',function(){return WtH(w_BILLSSOV,'N',10,0,'9999999999')},w_BILLSSOV);
} else {
if(c=Ctrl('HOLHIEEXOR')) selectCombo(c,w_TIPATT,'C')
if(c=Ctrl('RYMHYALKWD')) selectCombo(c,w_TIPOATTIV,'C')
SPBOUILib.SetInputValue('YVJSXFLERW',function(){return WtH(w_CODICEGLN,'C',13,0,'')},w_CODICEGLN);
SPBOUILib.SetInputValue('CXLASTSRKJ',function(){return WtH(w_CODCLICON,'C',20,0,'')},w_CODCLICON);
SPBOUILib.SetInputValue('IACBXHVCCO',function(){return WtH(w_ATECO_CON,'C',10,0,'')},w_ATECO_CON);
var tmp_JNJVIVLVGV = ToHTag(AsControlValue(w_xDESATECO));
if (Ne(e_JNJVIVLVGV,tmp_JNJVIVLVGV)) {
SPBOUILib.SetLabelValue('JNJVIVLVGV','innerHTML',tmp_JNJVIVLVGV);
e_JNJVIVLVGV=tmp_JNJVIVLVGV;
}
SPBOUILib.SetInputValue('JCXOTDXIKP',function(){return WtH(w_CODCOMCON,'C',6,0,'')},w_CODCOMCON);
var tmp_ZKEIQTRRZO = ToHTag(AsControlValue(w_xDESCITTA));
if (Ne(e_ZKEIQTRRZO,tmp_ZKEIQTRRZO)) {
SPBOUILib.SetLabelValue('ZKEIQTRRZO','innerHTML',tmp_ZKEIQTRRZO);
e_ZKEIQTRRZO=tmp_ZKEIQTRRZO;
}
SPBOUILib.SetInputValue('YXYPHIFKZT',function(){return WtH(w_ABIINTER,'C',5,0,'')},w_ABIINTER);
SPBOUILib.SetInputValue('GYFXWZOJEE',function(){return WtH(w_ABIPROPR,'C',5,0,'')},w_ABIPROPR);
SPBOUILib.SetInputValue('PJGQZBLXYX',function(){return WtH(w_GLNALTROSOG,'C',13,0,'')},w_GLNALTROSOG);
SPBOUILib.SetInputValue('JZUTNDTOOI',function(){return WtH(w_GLNALTRASC,'C',13,0,'')},w_GLNALTRASC);
SPBOUILib.SetInputValue('AHEQBLEXHM',function(){return WtH(w_BILLSRIT,'N',10,0,'9999999999')},w_BILLSRIT);
SPBOUILib.SetInputValue('VHTWYZSCLL',function(){return WtH(w_BILLSSOV,'N',10,0,'9999999999')},w_BILLSSOV);
SPBOUILib.SetInputValue('AZPAGSINXQ',function(){return WtH(w_TAGLIO,'N',7,2,'9999.99')},w_TAGLIO);
SPBOUILib.SetInputValue('JKWCLHNPVX',function(){return WtH(w_NBANCONOTE,'N',5,0,'99999')},w_NBANCONOTE);
}
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
HideUI.lblids["ABIINTER"]=['PXVVNLGRPN'];
HideUI.lblids["ABIPROPR"]=['MZHDAUCBJG'];
HideUI.lblids["ATECO_CON"]=['AVXKQBVCBP'];
HideUI.lblids["BILLSRIT"]=['QSINSNGGBJ'];
HideUI.lblids["BILLSSOV"]=['TGJJPNARVN'];
HideUI.lblids["CODCLICON"]=['YYVQXGLUYP'];
HideUI.lblids["CODCOMCON"]=['XNHIWZNVGO'];
HideUI.lblids["CODICEGLN"]=['WROBVGUGZC'];
HideUI.lblids["GLNALTRASC"]=['XYXHJIYIUX'];
HideUI.lblids["GLNALTROSOG"]=['ZPEGQETTAD'];
HideUI.lblids["NBANCONOTE"]=['XCZWTBHABY'];
HideUI.lblids["TAGLIO"]=['GWUNQLZLQS'];
HideUI.lblids["TIPATT"]=['WKJLXZWEOH'];
HideUI.lblids["TIPOATTIV"]=['BVBWDGDPNV'];
function HOLHIEEXOR_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('TIPATT','C',w_TIPATT,HtW(getComboValue(Ctrl('HOLHIEEXOR')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TIPATT(HtW(getComboValue(Ctrl('HOLHIEEXOR')),'C'),null,e);
return l_bSetResult;
}
}
function HOLHIEEXOR_OnFocus(e) {
SetActiveField(Ctrl('HOLHIEEXOR'),true);
}
function HOLHIEEXOR_OnBlur(e) {
SetActiveField(Ctrl('HOLHIEEXOR'),false);
}
function RYMHYALKWD_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('TIPOATTIV','C',w_TIPOATTIV,HtW(getComboValue(Ctrl('RYMHYALKWD')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TIPOATTIV(HtW(getComboValue(Ctrl('RYMHYALKWD')),'C'),null,e);
return l_bSetResult;
}
}
function RYMHYALKWD_OnFocus(e) {
SetActiveField(Ctrl('RYMHYALKWD'),true);
}
function RYMHYALKWD_OnBlur(e) {
SetActiveField(Ctrl('RYMHYALKWD'),false);
}
function YVJSXFLERW_Valid(e) {
SetActiveField(Ctrl('YVJSXFLERW'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CODICEGLN','C',w_CODICEGLN,HtW(Ctrl('YVJSXFLERW').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODICEGLN(HtW(Ctrl('YVJSXFLERW').value,'C'),null,e);
return l_bSetResult;
}
}
function YVJSXFLERW_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('YVJSXFLERW'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('YVJSXFLERW'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('YVJSXFLERW'),e);
}
function CXLASTSRKJ_Valid(e) {
SetActiveField(Ctrl('CXLASTSRKJ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CODCLICON','C',w_CODCLICON,HtW(Ctrl('CXLASTSRKJ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODCLICON(HtW(Ctrl('CXLASTSRKJ').value,'C'),null,e);
return l_bSetResult;
}
}
function CXLASTSRKJ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('CXLASTSRKJ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('CXLASTSRKJ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('CXLASTSRKJ'),e);
}
function IACBXHVCCO_Valid(e) {
SetActiveField(Ctrl('IACBXHVCCO'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('ATECO_CON','C',w_ATECO_CON,HtW(Ctrl('IACBXHVCCO').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ATECO_CON(HtW(Ctrl('IACBXHVCCO').value,'C'),null,e);
return l_bSetResult;
}
}
function IACBXHVCCO_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('IACBXHVCCO'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('IACBXHVCCO'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('IACBXHVCCO'),e);
}
function JCXOTDXIKP_Valid(e) {
SetActiveField(Ctrl('JCXOTDXIKP'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CODCOMCON','C',w_CODCOMCON,HtW(Ctrl('JCXOTDXIKP').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODCOMCON(HtW(Ctrl('JCXOTDXIKP').value,'C'),null,e);
return l_bSetResult;
}
}
function JCXOTDXIKP_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('JCXOTDXIKP'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('JCXOTDXIKP'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('JCXOTDXIKP'),e);
}
function YXYPHIFKZT_Valid(e) {
SetActiveField(Ctrl('YXYPHIFKZT'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('ABIINTER','C',w_ABIINTER,HtW(Ctrl('YXYPHIFKZT').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ABIINTER(HtW(Ctrl('YXYPHIFKZT').value,'C'),null,e);
return l_bSetResult;
}
}
function YXYPHIFKZT_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('YXYPHIFKZT'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('YXYPHIFKZT'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('YXYPHIFKZT'),e);
}
function GYFXWZOJEE_Valid(e) {
SetActiveField(Ctrl('GYFXWZOJEE'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('ABIPROPR','C',w_ABIPROPR,HtW(Ctrl('GYFXWZOJEE').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ABIPROPR(HtW(Ctrl('GYFXWZOJEE').value,'C'),null,e);
return l_bSetResult;
}
}
function GYFXWZOJEE_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('GYFXWZOJEE'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('GYFXWZOJEE'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('GYFXWZOJEE'),e);
}
function PJGQZBLXYX_Valid(e) {
SetActiveField(Ctrl('PJGQZBLXYX'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('GLNALTROSOG','C',w_GLNALTROSOG,HtW(Ctrl('PJGQZBLXYX').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_GLNALTROSOG(HtW(Ctrl('PJGQZBLXYX').value,'C'),null,e);
return l_bSetResult;
}
}
function PJGQZBLXYX_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('PJGQZBLXYX'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('PJGQZBLXYX'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('PJGQZBLXYX'),e);
}
function JZUTNDTOOI_Valid(e) {
SetActiveField(Ctrl('JZUTNDTOOI'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('GLNALTRASC','C',w_GLNALTRASC,HtW(Ctrl('JZUTNDTOOI').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_GLNALTRASC(HtW(Ctrl('JZUTNDTOOI').value,'C'),null,e);
return l_bSetResult;
}
}
function JZUTNDTOOI_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('JZUTNDTOOI'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('JZUTNDTOOI'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('JZUTNDTOOI'),e);
}
function AHEQBLEXHM_Valid(e) {
SetActiveField(Ctrl('AHEQBLEXHM'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('BILLSRIT','N',w_BILLSRIT,HtW(Ctrl('AHEQBLEXHM').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_BILLSRIT(HtW(Ctrl('AHEQBLEXHM').value,'N'),null,e);
return l_bSetResult;
}
}
function AHEQBLEXHM_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('AHEQBLEXHM'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('AHEQBLEXHM',w_BILLSRIT,'N',10,0,'9999999999');
SetActiveField(Ctrl('AHEQBLEXHM'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('AHEQBLEXHM'),e);
}
function AHEQBLEXHM_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("9999999999"));
}
function VHTWYZSCLL_Valid(e) {
SetActiveField(Ctrl('VHTWYZSCLL'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('BILLSSOV','N',w_BILLSSOV,HtW(Ctrl('VHTWYZSCLL').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_BILLSSOV(HtW(Ctrl('VHTWYZSCLL').value,'N'),null,e);
return l_bSetResult;
}
}
function VHTWYZSCLL_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('VHTWYZSCLL'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('VHTWYZSCLL',w_BILLSSOV,'N',10,0,'9999999999');
SetActiveField(Ctrl('VHTWYZSCLL'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('VHTWYZSCLL'),e);
}
function VHTWYZSCLL_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("9999999999"));
}
function AZPAGSINXQ_Valid(e) {
SetActiveField(Ctrl('AZPAGSINXQ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TAGLIO','N',w_TAGLIO,HtW(Ctrl('AZPAGSINXQ').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TAGLIO(HtW(Ctrl('AZPAGSINXQ').value,'N'),null,e);
return l_bSetResult;
}
}
function AZPAGSINXQ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('AZPAGSINXQ'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('AZPAGSINXQ',w_TAGLIO,'N',7,2,'9999.99');
SetActiveField(Ctrl('AZPAGSINXQ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('AZPAGSINXQ'),e);
}
function AZPAGSINXQ_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("9999.99"));
}
function JKWCLHNPVX_Valid(e) {
SetActiveField(Ctrl('JKWCLHNPVX'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('NBANCONOTE','N',w_NBANCONOTE,HtW(Ctrl('JKWCLHNPVX').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_NBANCONOTE(HtW(Ctrl('JKWCLHNPVX').value,'N'),null,e);
return l_bSetResult;
}
}
function JKWCLHNPVX_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('JKWCLHNPVX'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('JKWCLHNPVX',w_NBANCONOTE,'N',5,0,'99999');
SetActiveField(Ctrl('JKWCLHNPVX'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('JKWCLHNPVX'),e);
}
function JKWCLHNPVX_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("99999"));
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function HOLHIEEXOR_wrap_Valid(event) {
return HOLHIEEXOR_Valid(event);
}
SPBOUILib.SetComboChange('HOLHIEEXOR',HOLHIEEXOR_wrap_Valid);
function HOLHIEEXOR_wrap_OnFocus(event) {
return HOLHIEEXOR_OnFocus(event);
}
SPBOUILib.SetInputEnter('HOLHIEEXOR',HOLHIEEXOR_wrap_OnFocus);
function HOLHIEEXOR_wrap_Blur(event) {
return HOLHIEEXOR_OnBlur(event);
}
SPBOUILib.SetInputExit('HOLHIEEXOR',HOLHIEEXOR_wrap_Blur);
function RYMHYALKWD_wrap_Valid(event) {
return RYMHYALKWD_Valid(event);
}
SPBOUILib.SetComboChange('RYMHYALKWD',RYMHYALKWD_wrap_Valid);
function RYMHYALKWD_wrap_OnFocus(event) {
return RYMHYALKWD_OnFocus(event);
}
SPBOUILib.SetInputEnter('RYMHYALKWD',RYMHYALKWD_wrap_OnFocus);
function RYMHYALKWD_wrap_Blur(event) {
return RYMHYALKWD_OnBlur(event);
}
SPBOUILib.SetInputExit('RYMHYALKWD',RYMHYALKWD_wrap_Blur);
function YVJSXFLERW_wrap_Valid(event) {
return YVJSXFLERW_Valid(event);
}
SPBOUILib.SetInputExit('YVJSXFLERW',YVJSXFLERW_wrap_Valid);
function YVJSXFLERW_wrap_OnFocus(event) {
return YVJSXFLERW_OnFocus(event);
}
SPBOUILib.SetInputEnter('YVJSXFLERW',YVJSXFLERW_wrap_OnFocus);
function YVJSXFLERW_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('YVJSXFLERW',YVJSXFLERW_wrap_OnKeyDown);
function CXLASTSRKJ_wrap_Valid(event) {
return CXLASTSRKJ_Valid(event);
}
SPBOUILib.SetInputExit('CXLASTSRKJ',CXLASTSRKJ_wrap_Valid);
function CXLASTSRKJ_wrap_OnFocus(event) {
return CXLASTSRKJ_OnFocus(event);
}
SPBOUILib.SetInputEnter('CXLASTSRKJ',CXLASTSRKJ_wrap_OnFocus);
function CXLASTSRKJ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('CXLASTSRKJ',CXLASTSRKJ_wrap_OnKeyDown);
function IACBXHVCCO_wrap_Valid(event) {
return IACBXHVCCO_Valid(event);
}
SPBOUILib.SetInputExit('IACBXHVCCO',IACBXHVCCO_wrap_Valid);
function IACBXHVCCO_wrap_OnFocus(event) {
return IACBXHVCCO_OnFocus(event);
}
SPBOUILib.SetInputEnter('IACBXHVCCO',IACBXHVCCO_wrap_OnFocus);
function IACBXHVCCO_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('IACBXHVCCO',IACBXHVCCO_wrap_OnKeyDown);
function JCXOTDXIKP_wrap_Valid(event) {
return JCXOTDXIKP_Valid(event);
}
SPBOUILib.SetInputExit('JCXOTDXIKP',JCXOTDXIKP_wrap_Valid);
function JCXOTDXIKP_wrap_OnFocus(event) {
return JCXOTDXIKP_OnFocus(event);
}
SPBOUILib.SetInputEnter('JCXOTDXIKP',JCXOTDXIKP_wrap_OnFocus);
function JCXOTDXIKP_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('JCXOTDXIKP',JCXOTDXIKP_wrap_OnKeyDown);
function YXYPHIFKZT_wrap_Valid(event) {
return YXYPHIFKZT_Valid(event);
}
SPBOUILib.SetInputExit('YXYPHIFKZT',YXYPHIFKZT_wrap_Valid);
function YXYPHIFKZT_wrap_OnFocus(event) {
return YXYPHIFKZT_OnFocus(event);
}
SPBOUILib.SetInputEnter('YXYPHIFKZT',YXYPHIFKZT_wrap_OnFocus);
function YXYPHIFKZT_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('YXYPHIFKZT',YXYPHIFKZT_wrap_OnKeyDown);
function GYFXWZOJEE_wrap_Valid(event) {
return GYFXWZOJEE_Valid(event);
}
SPBOUILib.SetInputExit('GYFXWZOJEE',GYFXWZOJEE_wrap_Valid);
function GYFXWZOJEE_wrap_OnFocus(event) {
return GYFXWZOJEE_OnFocus(event);
}
SPBOUILib.SetInputEnter('GYFXWZOJEE',GYFXWZOJEE_wrap_OnFocus);
function GYFXWZOJEE_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('GYFXWZOJEE',GYFXWZOJEE_wrap_OnKeyDown);
function PJGQZBLXYX_wrap_Valid(event) {
return PJGQZBLXYX_Valid(event);
}
SPBOUILib.SetInputExit('PJGQZBLXYX',PJGQZBLXYX_wrap_Valid);
function PJGQZBLXYX_wrap_OnFocus(event) {
return PJGQZBLXYX_OnFocus(event);
}
SPBOUILib.SetInputEnter('PJGQZBLXYX',PJGQZBLXYX_wrap_OnFocus);
function PJGQZBLXYX_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('PJGQZBLXYX',PJGQZBLXYX_wrap_OnKeyDown);
function JZUTNDTOOI_wrap_Valid(event) {
return JZUTNDTOOI_Valid(event);
}
SPBOUILib.SetInputExit('JZUTNDTOOI',JZUTNDTOOI_wrap_Valid);
function JZUTNDTOOI_wrap_OnFocus(event) {
return JZUTNDTOOI_OnFocus(event);
}
SPBOUILib.SetInputEnter('JZUTNDTOOI',JZUTNDTOOI_wrap_OnFocus);
function JZUTNDTOOI_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('JZUTNDTOOI',JZUTNDTOOI_wrap_OnKeyDown);
function AHEQBLEXHM_wrap_Valid(event) {
return AHEQBLEXHM_Valid(event);
}
SPBOUILib.SetInputExit('AHEQBLEXHM',AHEQBLEXHM_wrap_Valid);
function AHEQBLEXHM_wrap_OnFocus(event) {
return AHEQBLEXHM_OnFocus(event);
}
SPBOUILib.SetInputEnter('AHEQBLEXHM',AHEQBLEXHM_wrap_OnFocus);
function AHEQBLEXHM_wrap_OnKeyPress(event) {
return AHEQBLEXHM_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('AHEQBLEXHM',AHEQBLEXHM_wrap_OnKeyPress);
function AHEQBLEXHM_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('AHEQBLEXHM',AHEQBLEXHM_wrap_OnKeyDown);
function VHTWYZSCLL_wrap_Valid(event) {
return VHTWYZSCLL_Valid(event);
}
SPBOUILib.SetInputExit('VHTWYZSCLL',VHTWYZSCLL_wrap_Valid);
function VHTWYZSCLL_wrap_OnFocus(event) {
return VHTWYZSCLL_OnFocus(event);
}
SPBOUILib.SetInputEnter('VHTWYZSCLL',VHTWYZSCLL_wrap_OnFocus);
function VHTWYZSCLL_wrap_OnKeyPress(event) {
return VHTWYZSCLL_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('VHTWYZSCLL',VHTWYZSCLL_wrap_OnKeyPress);
function VHTWYZSCLL_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('VHTWYZSCLL',VHTWYZSCLL_wrap_OnKeyDown);
function AZPAGSINXQ_wrap_Valid(event) {
return AZPAGSINXQ_Valid(event);
}
SPBOUILib.SetInputExit('AZPAGSINXQ',AZPAGSINXQ_wrap_Valid,SPBOUILib.Row.IN_GRID);
function AZPAGSINXQ_wrap_OnFocus(event) {
return AZPAGSINXQ_OnFocus(event);
}
SPBOUILib.SetInputEnter('AZPAGSINXQ',AZPAGSINXQ_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function AZPAGSINXQ_wrap_OnKeyPress(event) {
return AZPAGSINXQ_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('AZPAGSINXQ',AZPAGSINXQ_wrap_OnKeyPress,SPBOUILib.Row.IN_GRID);
function AZPAGSINXQ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('AZPAGSINXQ',AZPAGSINXQ_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function JKWCLHNPVX_wrap_Valid(event) {
return JKWCLHNPVX_Valid(event);
}
SPBOUILib.SetInputExit('JKWCLHNPVX',JKWCLHNPVX_wrap_Valid,SPBOUILib.Row.IN_GRID);
function JKWCLHNPVX_wrap_OnFocus(event) {
return JKWCLHNPVX_OnFocus(event);
}
SPBOUILib.SetInputEnter('JKWCLHNPVX',JKWCLHNPVX_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function JKWCLHNPVX_wrap_OnKeyPress(event) {
return JKWCLHNPVX_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('JKWCLHNPVX',JKWCLHNPVX_wrap_OnKeyPress,SPBOUILib.Row.IN_GRID);
function JKWCLHNPVX_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('JKWCLHNPVX',JKWCLHNPVX_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
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
m_oFather.i_last_focused_item='child_ardt_xpe_contante';
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
m_bStopChangeRow=true;
} else if (Ne('undefined',typeof(m_nLastError))) {
m_bStopChangeRow=Eq(m_nLastError,-2);
}
m_nLastError=0;
m_cLastMsgError='';
}
FocusFirstComponent.edit={"page_1":["HOLHIEEXOR"]};
FocusFirstComponent.query={"page_1":["HOLHIEEXOR"]};
FocusFirstComponent.otherwise={"page_1":["HOLHIEEXOR"]};
function Help() {
windowOpenForeground('../doc/ardt_xpe_contante_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_IDOPE=a[0];
w_TIPATT=a[1];
w_TIPOATTIV=a[2];
w_CODICEGLN=a[3];
w_CODCLICON=a[4];
w_ATECO_CON=a[5];
w_CODCOMCON=a[6];
w_ABIINTER=a[7];
w_ABIPROPR=a[8];
w_GLNALTROSOG=a[9];
w_GLNALTRASC=a[10];
w_BILLSRIT=a[11];
w_BILLSSOV=a[12];
w_TAGLIO=a[13];
w_NBANCONOTE=a[14];
w_xDESATECO=a[15];
w_xDESCITTA=a[16];
m_PrimaryKeys=['TAGLIO','IDOPE'];
}
function i_PrimaryKey() {
return 'xpe_contante'+'\\'+CPLib.ToCPStr(w_IDOPE);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('ardt_xpe_contante',m_cSelectedPage);
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
function FocusFirstDetailComponent() {
var candidatesToFocus = ["AZPAGSINXQ"];
SetControlFocus(candidatesToFocus);
}
IsRepeatedChild.child=[];
function GetFullRowMsgError() {
return 'MSG_FULLROW_NOT_SAT';
}
_Obli('CODCOMCON',0,'JCXOTDXIKP',false,"1867589130")
_Obli('TIPATT',0,'HOLHIEEXOR',false,"11155590227")
_Obli('TIPOATTIV',0,'RYMHYALKWD',false,"11189144659")
_Obli('CODICEGLN',0,'YVJSXFLERW',false,"11997494697")
_Obli('CODCLICON',0,'CXLASTSRKJ',false,"439997054")
_Obli('ATECO_CON',0,'IACBXHVCCO',false,"1099659240")
_Obli('ABIPROPR',0,'GYFXWZOJEE',false,"10688195229")
_Obli('GLNALTROSOG',0,'PJGQZBLXYX',false,"1189191642")
_Obli('NBANCONOTE',1,'JKWCLHNPVX',false,"1514933900")
_Obli('ABIINTER',0,'YXYPHIFKZT',false,"10743769582")
_Obli('GLNALTRASC',0,'JZUTNDTOOI',false,"11648440646")
_Obli('BILLSRIT',1,'AHEQBLEXHM',false,"1063292795")
_Obli('TAGLIO',1,'AZPAGSINXQ',false,"10758806619")
_Obli('BILLSSOV',1,'VHTWYZSCLL',false,"1876639681")
