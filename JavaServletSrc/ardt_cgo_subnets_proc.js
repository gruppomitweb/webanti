function FillCombosValues() {
}
function FillInGridCombosValues(currentRow) {
var postfix = (Gt(currentRow,-1)?'_'+currentRow:'');
}
function SetControlsValue() {
var c;
if (Empty(m_cAltInterface) && (Eq(m_cFunction,'view') || Eq(m_cFunction,'query'))) {
} else {
SPBOUILib.SetInputValue('LXOGHRVGTK',function(){return WtH(w_SNSUBNET,'C',15,0,'')},w_SNSUBNET);
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
function LXOGHRVGTK_Valid(e) {
SetActiveField(Ctrl('LXOGHRVGTK'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('SNSUBNET','C',w_SNSUBNET,HtW(Ctrl('LXOGHRVGTK').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_SNSUBNET(HtW(Ctrl('LXOGHRVGTK').value,'C'),null,e);
return l_bSetResult;
}
}
function LXOGHRVGTK_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('LXOGHRVGTK'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('LXOGHRVGTK'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('LXOGHRVGTK'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function LXOGHRVGTK_wrap_Valid(event) {
return LXOGHRVGTK_Valid(event);
}
SPBOUILib.SetInputExit('LXOGHRVGTK',LXOGHRVGTK_wrap_Valid,SPBOUILib.Row.IN_GRID);
function LXOGHRVGTK_wrap_OnFocus(event) {
return LXOGHRVGTK_OnFocus(event);
}
SPBOUILib.SetInputEnter('LXOGHRVGTK',LXOGHRVGTK_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function LXOGHRVGTK_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('LXOGHRVGTK',LXOGHRVGTK_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
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
m_oFather.i_last_focused_item='child_ardt_cgo_subnets';
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
windowOpenForeground('../doc/ardt_cgo_subnets_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_SNCODINT=a[0];
w_SNSUBNET=a[1];
m_PrimaryKeys=['SNSUBNET','SNCODINT'];
}
function i_PrimaryKey() {
return 'cgo_subnet'+'\\'+CPLib.ToCPStr(w_SNCODINT);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('ardt_cgo_subnets',m_cSelectedPage);
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
var candidatesToFocus = ["LXOGHRVGTK"];
SetControlFocus(candidatesToFocus);
}
IsRepeatedChild.child=[];
function GetFullRowMsgError() {
return 'MSG_FULLROW_NOT_SAT';
}
_Obli('SNSUBNET',0,'LXOGHRVGTK',false)
