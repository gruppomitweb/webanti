function FillCombosValues() {
FillCombo('GIHQXNRYNI','GIHQXNRYNI');
}
function FillInGridCombosValues(currentRow) {
var postfix = (Gt(currentRow,-1)?'_'+currentRow:'');
}
function SetControlsValue() {
var c;
if (Empty(m_cAltInterface) && (Eq(m_cFunction,'view') || Eq(m_cFunction,'query'))) {
var tmp_ARIWMHFIOV = ToHTag(AsControlValue(arfn_desc_saldi(w_TIPRAP,w_ANNO,1)));
if (Ne(e_ARIWMHFIOV,tmp_ARIWMHFIOV)) {
SPBOUILib.SetLabelValue('ARIWMHFIOV','innerHTML',tmp_ARIWMHFIOV);
e_ARIWMHFIOV=tmp_ARIWMHFIOV;
}
var tmp_CPZZTQOQEL = ToHTag(AsControlValue(arfn_desc_saldi(w_TIPRAP,w_ANNO,2)));
if (Ne(e_CPZZTQOQEL,tmp_CPZZTQOQEL)) {
SPBOUILib.SetLabelValue('CPZZTQOQEL','innerHTML',tmp_CPZZTQOQEL);
e_CPZZTQOQEL=tmp_CPZZTQOQEL;
}
var tmp_LVVLDDYTMP = ToHTag(AsControlValue(arfn_desc_saldi(w_TIPRAP,w_ANNO,3)));
if (Ne(e_LVVLDDYTMP,tmp_LVVLDDYTMP)) {
SPBOUILib.SetLabelValue('LVVLDDYTMP','innerHTML',tmp_LVVLDDYTMP);
e_LVVLDDYTMP=tmp_LVVLDDYTMP;
}
var tmp_FYSCRZZKZI = ToHTag(AsControlValue(arfn_desc_saldi(w_TIPRAP,w_ANNO,4)));
if (Ne(e_FYSCRZZKZI,tmp_FYSCRZZKZI)) {
SPBOUILib.SetLabelValue('FYSCRZZKZI','innerHTML',tmp_FYSCRZZKZI);
e_FYSCRZZKZI=tmp_FYSCRZZKZI;
}
var tmp_XMDAOYVNNA = ToHTag(AsControlValue(arfn_desc_saldi(w_TIPRAP,w_ANNO,5)));
if (Ne(e_XMDAOYVNNA,tmp_XMDAOYVNNA)) {
SPBOUILib.SetLabelValue('XMDAOYVNNA','innerHTML',tmp_XMDAOYVNNA);
e_XMDAOYVNNA=tmp_XMDAOYVNNA;
}
SPBOUILib.SetInputValue('FMWOOHLKTT',function(){return WtH(w_TIPRAP,'C',2,0,'')},w_TIPRAP);
var tmp_MTPCPCMIIQ = ToHTag(AsControlValue(arfn_desc_saldi(w_TIPRAP,w_ANNO,6)));
if (Ne(e_MTPCPCMIIQ,tmp_MTPCPCMIIQ)) {
SPBOUILib.SetLabelValue('MTPCPCMIIQ','innerHTML',tmp_MTPCPCMIIQ);
e_MTPCPCMIIQ=tmp_MTPCPCMIIQ;
}
SPBOUILib.SetInputValue('AXNGRMGWKA',function(){return WtH(w_IMPORTO1,'N',17,0,'99,999,999,999,999,999')},w_IMPORTO1);
SPBOUILib.SetInputValue('IHYVMMXNYB',function(){return WtH(w_IMPORTO2,'N',17,0,'99,999,999,999,999,999')},w_IMPORTO2);
SPBOUILib.SetInputValue('FOMIWSJIXX',function(){return WtH(w_IMPORTO3,'N',17,0,'99,999,999,999,999,999')},w_IMPORTO3);
SPBOUILib.SetInputValue('BTCAUOXWJV',function(){return WtH(w_IMPORTO4,'N',17,0,'99,999,999,999,999,999')},w_IMPORTO4);
SPBOUILib.SetInputValue('JNHTVKJIVX',function(){return WtH(w_IMPORTO5,'N',6,0,'999,999')},w_IMPORTO5);
SPBOUILib.SetInputValue('WGRHFFESJM',function(){return WtH(w_IMPORTO6,'N',17,0,'99,999,999,999,999,999')},w_IMPORTO6);
if(c=Ctrl('GIHQXNRYNI')) selectCombo(c,w_NATURA,'C')
} else {
var tmp_ARIWMHFIOV = ToHTag(AsControlValue(arfn_desc_saldi(w_TIPRAP,w_ANNO,1)));
if (Ne(e_ARIWMHFIOV,tmp_ARIWMHFIOV)) {
SPBOUILib.SetLabelValue('ARIWMHFIOV','innerHTML',tmp_ARIWMHFIOV);
e_ARIWMHFIOV=tmp_ARIWMHFIOV;
}
var tmp_CPZZTQOQEL = ToHTag(AsControlValue(arfn_desc_saldi(w_TIPRAP,w_ANNO,2)));
if (Ne(e_CPZZTQOQEL,tmp_CPZZTQOQEL)) {
SPBOUILib.SetLabelValue('CPZZTQOQEL','innerHTML',tmp_CPZZTQOQEL);
e_CPZZTQOQEL=tmp_CPZZTQOQEL;
}
var tmp_LVVLDDYTMP = ToHTag(AsControlValue(arfn_desc_saldi(w_TIPRAP,w_ANNO,3)));
if (Ne(e_LVVLDDYTMP,tmp_LVVLDDYTMP)) {
SPBOUILib.SetLabelValue('LVVLDDYTMP','innerHTML',tmp_LVVLDDYTMP);
e_LVVLDDYTMP=tmp_LVVLDDYTMP;
}
var tmp_FYSCRZZKZI = ToHTag(AsControlValue(arfn_desc_saldi(w_TIPRAP,w_ANNO,4)));
if (Ne(e_FYSCRZZKZI,tmp_FYSCRZZKZI)) {
SPBOUILib.SetLabelValue('FYSCRZZKZI','innerHTML',tmp_FYSCRZZKZI);
e_FYSCRZZKZI=tmp_FYSCRZZKZI;
}
var tmp_XMDAOYVNNA = ToHTag(AsControlValue(arfn_desc_saldi(w_TIPRAP,w_ANNO,5)));
if (Ne(e_XMDAOYVNNA,tmp_XMDAOYVNNA)) {
SPBOUILib.SetLabelValue('XMDAOYVNNA','innerHTML',tmp_XMDAOYVNNA);
e_XMDAOYVNNA=tmp_XMDAOYVNNA;
}
SPBOUILib.SetInputValue('FMWOOHLKTT',function(){return WtH(w_TIPRAP,'C',2,0,'')},w_TIPRAP);
var tmp_MTPCPCMIIQ = ToHTag(AsControlValue(arfn_desc_saldi(w_TIPRAP,w_ANNO,6)));
if (Ne(e_MTPCPCMIIQ,tmp_MTPCPCMIIQ)) {
SPBOUILib.SetLabelValue('MTPCPCMIIQ','innerHTML',tmp_MTPCPCMIIQ);
e_MTPCPCMIIQ=tmp_MTPCPCMIIQ;
}
SPBOUILib.SetInputValue('GTDLGPZWRR',function(){return WtH(w_ANNO,'N',4,0,'9999')},w_ANNO);
SPBOUILib.SetInputValue('AXNGRMGWKA',function(){return WtH(w_IMPORTO1,'N',17,0,'99,999,999,999,999,999')},w_IMPORTO1);
SPBOUILib.SetInputValue('IHYVMMXNYB',function(){return WtH(w_IMPORTO2,'N',17,0,'99,999,999,999,999,999')},w_IMPORTO2);
SPBOUILib.SetInputValue('FOMIWSJIXX',function(){return WtH(w_IMPORTO3,'N',17,0,'99,999,999,999,999,999')},w_IMPORTO3);
SPBOUILib.SetInputValue('BTCAUOXWJV',function(){return WtH(w_IMPORTO4,'N',17,0,'99,999,999,999,999,999')},w_IMPORTO4);
SPBOUILib.SetInputValue('JNHTVKJIVX',function(){return WtH(w_IMPORTO5,'N',6,0,'999,999')},w_IMPORTO5);
SPBOUILib.SetInputValue('WGRHFFESJM',function(){return WtH(w_IMPORTO6,'N',17,0,'99,999,999,999,999,999')},w_IMPORTO6);
if(c=Ctrl('GIHQXNRYNI')) selectCombo(c,w_NATURA,'C')
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
SetDisplay(Ctrl('FMWOOHLKTT'),true || IsHiddenByStateDriver('TIPRAP'));
LibJavascript.forEachItem(m_FoundlingHideExpression,i_body_2)
function i_body_2(child){
child();
}
HideUI();
}
HideUI.lblids["ANNO"]=['VPEBFYUACG'];
HideUI.lblids["IMPORTO1"]=['ARIWMHFIOV','CPZZTQOQEL','LVVLDDYTMP','FYSCRZZKZI','XMDAOYVNNA','MTPCPCMIIQ'];
HideUI.lblids["NATURA"]=['FQUOPUKVTM'];
function FMWOOHLKTT_Valid(e) {
SetActiveField(Ctrl('FMWOOHLKTT'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TIPRAP','C',w_TIPRAP,HtW(Ctrl('FMWOOHLKTT').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TIPRAP(HtW(Ctrl('FMWOOHLKTT').value,'C'),null,e);
return l_bSetResult;
}
}
function FMWOOHLKTT_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('FMWOOHLKTT'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('FMWOOHLKTT'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('FMWOOHLKTT'),e);
}
function GTDLGPZWRR_Valid(e) {
SetActiveField(Ctrl('GTDLGPZWRR'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('ANNO','N',w_ANNO,HtW(Ctrl('GTDLGPZWRR').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ANNO(HtW(Ctrl('GTDLGPZWRR').value,'N'),null,e);
return l_bSetResult;
}
}
function GTDLGPZWRR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('GTDLGPZWRR'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('GTDLGPZWRR',w_ANNO,'N',4,0,'9999');
SetActiveField(Ctrl('GTDLGPZWRR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('GTDLGPZWRR'),e);
}
function GTDLGPZWRR_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("9999"));
}
function AXNGRMGWKA_Valid(e) {
SetActiveField(Ctrl('AXNGRMGWKA'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('IMPORTO1','N',w_IMPORTO1,HtW(Ctrl('AXNGRMGWKA').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IMPORTO1(HtW(Ctrl('AXNGRMGWKA').value,'N'),null,e);
return l_bSetResult;
}
}
function AXNGRMGWKA_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('AXNGRMGWKA'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('AXNGRMGWKA',w_IMPORTO1,'N',17,0,'99999999999999999');
SetActiveField(Ctrl('AXNGRMGWKA'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('AXNGRMGWKA'),e);
}
function AXNGRMGWKA_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("99999999999999999"));
}
function IHYVMMXNYB_Valid(e) {
SetActiveField(Ctrl('IHYVMMXNYB'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('IMPORTO2','N',w_IMPORTO2,HtW(Ctrl('IHYVMMXNYB').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IMPORTO2(HtW(Ctrl('IHYVMMXNYB').value,'N'),null,e);
return l_bSetResult;
}
}
function IHYVMMXNYB_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('IHYVMMXNYB'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('IHYVMMXNYB',w_IMPORTO2,'N',17,0,'99999999999999999');
SetActiveField(Ctrl('IHYVMMXNYB'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('IHYVMMXNYB'),e);
}
function IHYVMMXNYB_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("99999999999999999"));
}
function FOMIWSJIXX_Valid(e) {
SetActiveField(Ctrl('FOMIWSJIXX'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('IMPORTO3','N',w_IMPORTO3,HtW(Ctrl('FOMIWSJIXX').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IMPORTO3(HtW(Ctrl('FOMIWSJIXX').value,'N'),null,e);
return l_bSetResult;
}
}
function FOMIWSJIXX_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('FOMIWSJIXX'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('FOMIWSJIXX',w_IMPORTO3,'N',17,0,'99999999999999999');
SetActiveField(Ctrl('FOMIWSJIXX'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('FOMIWSJIXX'),e);
}
function FOMIWSJIXX_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("99999999999999999"));
}
function BTCAUOXWJV_Valid(e) {
SetActiveField(Ctrl('BTCAUOXWJV'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('IMPORTO4','N',w_IMPORTO4,HtW(Ctrl('BTCAUOXWJV').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IMPORTO4(HtW(Ctrl('BTCAUOXWJV').value,'N'),null,e);
return l_bSetResult;
}
}
function BTCAUOXWJV_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('BTCAUOXWJV'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('BTCAUOXWJV',w_IMPORTO4,'N',17,0,'99999999999999999');
SetActiveField(Ctrl('BTCAUOXWJV'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('BTCAUOXWJV'),e);
}
function BTCAUOXWJV_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("99999999999999999"));
}
function JNHTVKJIVX_Valid(e) {
SetActiveField(Ctrl('JNHTVKJIVX'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('IMPORTO5','N',w_IMPORTO5,HtW(Ctrl('JNHTVKJIVX').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IMPORTO5(HtW(Ctrl('JNHTVKJIVX').value,'N'),null,e);
return l_bSetResult;
}
}
function JNHTVKJIVX_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('JNHTVKJIVX'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('JNHTVKJIVX',w_IMPORTO5,'N',6,0,'999999');
SetActiveField(Ctrl('JNHTVKJIVX'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('JNHTVKJIVX'),e);
}
function JNHTVKJIVX_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("999999"));
}
function WGRHFFESJM_Valid(e) {
SetActiveField(Ctrl('WGRHFFESJM'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('IMPORTO6','N',w_IMPORTO6,HtW(Ctrl('WGRHFFESJM').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IMPORTO6(HtW(Ctrl('WGRHFFESJM').value,'N'),null,e);
return l_bSetResult;
}
}
function WGRHFFESJM_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('WGRHFFESJM'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('WGRHFFESJM',w_IMPORTO6,'N',17,0,'99999999999999999');
SetActiveField(Ctrl('WGRHFFESJM'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('WGRHFFESJM'),e);
}
function WGRHFFESJM_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("99999999999999999"));
}
function GIHQXNRYNI_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('NATURA','C',w_NATURA,HtW(getComboValue(Ctrl('GIHQXNRYNI')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_NATURA(HtW(getComboValue(Ctrl('GIHQXNRYNI')),'C'),null,e);
return l_bSetResult;
}
}
function GIHQXNRYNI_OnFocus(e) {
SetActiveField(Ctrl('GIHQXNRYNI'),true);
}
function GIHQXNRYNI_OnBlur(e) {
SetActiveField(Ctrl('GIHQXNRYNI'),false);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function FMWOOHLKTT_wrap_Valid(event) {
return FMWOOHLKTT_Valid(event);
}
SPBOUILib.SetInputExit('FMWOOHLKTT',FMWOOHLKTT_wrap_Valid);
function FMWOOHLKTT_wrap_OnFocus(event) {
return FMWOOHLKTT_OnFocus(event);
}
SPBOUILib.SetInputEnter('FMWOOHLKTT',FMWOOHLKTT_wrap_OnFocus);
function FMWOOHLKTT_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('FMWOOHLKTT',FMWOOHLKTT_wrap_OnKeyDown);
function GTDLGPZWRR_wrap_Valid(event) {
return GTDLGPZWRR_Valid(event);
}
SPBOUILib.SetInputExit('GTDLGPZWRR',GTDLGPZWRR_wrap_Valid,SPBOUILib.Row.IN_GRID);
function GTDLGPZWRR_wrap_OnFocus(event) {
return GTDLGPZWRR_OnFocus(event);
}
SPBOUILib.SetInputEnter('GTDLGPZWRR',GTDLGPZWRR_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function GTDLGPZWRR_wrap_OnKeyPress(event) {
return GTDLGPZWRR_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('GTDLGPZWRR',GTDLGPZWRR_wrap_OnKeyPress,SPBOUILib.Row.IN_GRID);
function GTDLGPZWRR_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('GTDLGPZWRR',GTDLGPZWRR_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function AXNGRMGWKA_wrap_Valid(event) {
return AXNGRMGWKA_Valid(event);
}
SPBOUILib.SetInputExit('AXNGRMGWKA',AXNGRMGWKA_wrap_Valid);
function AXNGRMGWKA_wrap_OnFocus(event) {
return AXNGRMGWKA_OnFocus(event);
}
SPBOUILib.SetInputEnter('AXNGRMGWKA',AXNGRMGWKA_wrap_OnFocus);
function AXNGRMGWKA_wrap_OnKeyPress(event) {
return AXNGRMGWKA_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('AXNGRMGWKA',AXNGRMGWKA_wrap_OnKeyPress);
function AXNGRMGWKA_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('AXNGRMGWKA',AXNGRMGWKA_wrap_OnKeyDown);
function IHYVMMXNYB_wrap_Valid(event) {
return IHYVMMXNYB_Valid(event);
}
SPBOUILib.SetInputExit('IHYVMMXNYB',IHYVMMXNYB_wrap_Valid);
function IHYVMMXNYB_wrap_OnFocus(event) {
return IHYVMMXNYB_OnFocus(event);
}
SPBOUILib.SetInputEnter('IHYVMMXNYB',IHYVMMXNYB_wrap_OnFocus);
function IHYVMMXNYB_wrap_OnKeyPress(event) {
return IHYVMMXNYB_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('IHYVMMXNYB',IHYVMMXNYB_wrap_OnKeyPress);
function IHYVMMXNYB_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('IHYVMMXNYB',IHYVMMXNYB_wrap_OnKeyDown);
function FOMIWSJIXX_wrap_Valid(event) {
return FOMIWSJIXX_Valid(event);
}
SPBOUILib.SetInputExit('FOMIWSJIXX',FOMIWSJIXX_wrap_Valid);
function FOMIWSJIXX_wrap_OnFocus(event) {
return FOMIWSJIXX_OnFocus(event);
}
SPBOUILib.SetInputEnter('FOMIWSJIXX',FOMIWSJIXX_wrap_OnFocus);
function FOMIWSJIXX_wrap_OnKeyPress(event) {
return FOMIWSJIXX_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('FOMIWSJIXX',FOMIWSJIXX_wrap_OnKeyPress);
function FOMIWSJIXX_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('FOMIWSJIXX',FOMIWSJIXX_wrap_OnKeyDown);
function BTCAUOXWJV_wrap_Valid(event) {
return BTCAUOXWJV_Valid(event);
}
SPBOUILib.SetInputExit('BTCAUOXWJV',BTCAUOXWJV_wrap_Valid);
function BTCAUOXWJV_wrap_OnFocus(event) {
return BTCAUOXWJV_OnFocus(event);
}
SPBOUILib.SetInputEnter('BTCAUOXWJV',BTCAUOXWJV_wrap_OnFocus);
function BTCAUOXWJV_wrap_OnKeyPress(event) {
return BTCAUOXWJV_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('BTCAUOXWJV',BTCAUOXWJV_wrap_OnKeyPress);
function BTCAUOXWJV_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('BTCAUOXWJV',BTCAUOXWJV_wrap_OnKeyDown);
function JNHTVKJIVX_wrap_Valid(event) {
return JNHTVKJIVX_Valid(event);
}
SPBOUILib.SetInputExit('JNHTVKJIVX',JNHTVKJIVX_wrap_Valid);
function JNHTVKJIVX_wrap_OnFocus(event) {
return JNHTVKJIVX_OnFocus(event);
}
SPBOUILib.SetInputEnter('JNHTVKJIVX',JNHTVKJIVX_wrap_OnFocus);
function JNHTVKJIVX_wrap_OnKeyPress(event) {
return JNHTVKJIVX_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('JNHTVKJIVX',JNHTVKJIVX_wrap_OnKeyPress);
function JNHTVKJIVX_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('JNHTVKJIVX',JNHTVKJIVX_wrap_OnKeyDown);
function WGRHFFESJM_wrap_Valid(event) {
return WGRHFFESJM_Valid(event);
}
SPBOUILib.SetInputExit('WGRHFFESJM',WGRHFFESJM_wrap_Valid);
function WGRHFFESJM_wrap_OnFocus(event) {
return WGRHFFESJM_OnFocus(event);
}
SPBOUILib.SetInputEnter('WGRHFFESJM',WGRHFFESJM_wrap_OnFocus);
function WGRHFFESJM_wrap_OnKeyPress(event) {
return WGRHFFESJM_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('WGRHFFESJM',WGRHFFESJM_wrap_OnKeyPress);
function WGRHFFESJM_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('WGRHFFESJM',WGRHFFESJM_wrap_OnKeyDown);
function GIHQXNRYNI_wrap_Valid(event) {
return GIHQXNRYNI_Valid(event);
}
SPBOUILib.SetComboChange('GIHQXNRYNI',GIHQXNRYNI_wrap_Valid);
function GIHQXNRYNI_wrap_OnFocus(event) {
return GIHQXNRYNI_OnFocus(event);
}
SPBOUILib.SetInputEnter('GIHQXNRYNI',GIHQXNRYNI_wrap_OnFocus);
function GIHQXNRYNI_wrap_Blur(event) {
return GIHQXNRYNI_OnBlur(event);
}
SPBOUILib.SetInputExit('GIHQXNRYNI',GIHQXNRYNI_wrap_Blur);
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
m_oFather.i_last_focused_item='child_ardt_ae_saldianno_rap';
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
FocusFirstComponent.edit={};
FocusFirstComponent.query={};
FocusFirstComponent.otherwise={};
function Help() {
windowOpenForeground('../doc/ardt_ae_saldianno_rap_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_RAPPORTO=a[0];
w_ANNO=a[1];
w_IDBASE=a[2];
w_IMPORTO1=a[3];
w_IMPORTO2=a[4];
w_IMPORTO3=a[5];
w_IMPORTO4=a[6];
w_IMPORTO5=a[7];
w_FILEANNO=a[8];
w_PROG1=a[9];
w_TIPRAP=a[10];
w_IMPORTO6=a[11];
w_NATURA=a[12];
m_PrimaryKeys=['ANNO','RAPPORTO'];
}
function i_PrimaryKey() {
return 'aeannora'+'\\'+CPLib.ToCPStr(w_RAPPORTO);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('ardt_ae_saldianno_rap',m_cSelectedPage);
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
var candidatesToFocus = ["GTDLGPZWRR"];
SetControlFocus(candidatesToFocus);
}
IsRepeatedChild.child=[];
function GetFullRowMsgError() {
return 'MSG_FULLROW_NOT_SAT';
}
_Obli('IMPORTO3',1,'FOMIWSJIXX',false,"1991862092")
_Obli('TIPRAP',0,'FMWOOHLKTT',false,"1723736132")
_Obli('ANNO',1,'GTDLGPZWRR',false,"965977510")
_Obli('IMPORTO4',1,'BTCAUOXWJV',false,"1991862093")
_Obli('IMPORTO1',1,'AXNGRMGWKA',false,"1991862090")
_Obli('IMPORTO2',1,'IHYVMMXNYB',false,"1991862091")
_Obli('IMPORTO5',1,'JNHTVKJIVX',false,"1991862094")
_Obli('NATURA',0,'GIHQXNRYNI',false,"12030926209")
_Obli('IMPORTO6',1,'WGRHFFESJM',false,"11748287033")
