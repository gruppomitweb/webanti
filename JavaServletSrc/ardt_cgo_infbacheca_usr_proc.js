function FillCombosValues() {
}
function FillInGridCombosValues(currentRow) {
var postfix = (Gt(currentRow,-1)?'_'+currentRow:'');
}
function SetControlsValue() {
var c;
if (Empty(m_cAltInterface) && (Eq(m_cFunction,'view') || Eq(m_cFunction,'query'))) {
} else {
SPBOUILib.SetInputValue('BRCAXXLEPY',function(){return WtH(w_IBUCODUSR,'N',10,0,'9999999999')},w_IBUCODUSR);
SPBOUILib.SetInputValue('QIQDQNNLFN',function(){return WtH(w_nome,'C',50,0,'')},w_nome);
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
HideUI.lblids["IBUCODUSR"]=['GKNXQUOFFS'];
function BRCAXXLEPY_Valid(e) {
SetActiveField(Ctrl('BRCAXXLEPY'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('IBUCODUSR','N',w_IBUCODUSR,HtW(Ctrl('BRCAXXLEPY').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IBUCODUSR(HtW(Ctrl('BRCAXXLEPY').value,'N'),null,e);
return l_bSetResult;
}
}
function BRCAXXLEPY_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('BRCAXXLEPY'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('BRCAXXLEPY',w_IBUCODUSR,'N',10,0,'9999999999');
SetActiveField(Ctrl('BRCAXXLEPY'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('BRCAXXLEPY'),e);
}
function BRCAXXLEPY_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("9999999999"));
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function BRCAXXLEPY_wrap_Valid(event) {
return BRCAXXLEPY_Valid(event);
}
SPBOUILib.SetInputExit('BRCAXXLEPY',BRCAXXLEPY_wrap_Valid,SPBOUILib.Row.IN_GRID);
function BRCAXXLEPY_wrap_OnFocus(event) {
return BRCAXXLEPY_OnFocus(event);
}
SPBOUILib.SetInputEnter('BRCAXXLEPY',BRCAXXLEPY_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function BRCAXXLEPY_wrap_OnKeyPress(event) {
return BRCAXXLEPY_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('BRCAXXLEPY',BRCAXXLEPY_wrap_OnKeyPress,SPBOUILib.Row.IN_GRID);
function BRCAXXLEPY_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('BRCAXXLEPY',BRCAXXLEPY_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
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
m_oFather.i_last_focused_item='child_ardt_cgo_infbacheca_usr';
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
windowOpenForeground('../doc/ardt_cgo_infbacheca_usr_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_IBUCODICE=a[0];
w_IBUCODUSR=a[1];
w_nome=a[2];
m_PrimaryKeys=['IBUCODUSR','IBUCODICE'];
}
function i_PrimaryKey() {
return 'cgo_infbacheca_usr'+'\\'+CPLib.ToCPStr(w_IBUCODICE);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('ardt_cgo_infbacheca_usr',m_cSelectedPage);
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
var candidatesToFocus = ["BRCAXXLEPY"];
SetControlFocus(candidatesToFocus);
}
IsRepeatedChild.child=[];
function GetFullRowMsgError() {
return 'MSG_FULLROW_NOT_SAT';
}
_Obli('IBUCODUSR',1,'BRCAXXLEPY',false,"1999024119")
