function FillCombosValues() {
}
function FillInGridCombosValues(currentRow) {
var postfix = (Gt(currentRow,-1)?'_'+currentRow:'');
}
function SetControlsValue() {
var c;
if (Empty(m_cAltInterface) && (Eq(m_cFunction,'view') || Eq(m_cFunction,'query'))) {
} else {
SPBOUILib.SetInputValue('XSIJFYBHVF',function(){return WtH(w_CODATECO,'C',3,0,'')},w_CODATECO);
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
HideUI.lblids["CODATECO"]=['WCRORVELYH'];
function XSIJFYBHVF_Valid(e) {
SetActiveField(Ctrl('XSIJFYBHVF'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CODATECO','C',w_CODATECO,HtW(Ctrl('XSIJFYBHVF').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODATECO(HtW(Ctrl('XSIJFYBHVF').value,'C'),null,e);
return l_bSetResult;
}
}
function XSIJFYBHVF_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('XSIJFYBHVF'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('XSIJFYBHVF'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('XSIJFYBHVF'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function XSIJFYBHVF_wrap_Valid(event) {
return XSIJFYBHVF_Valid(event);
}
SPBOUILib.SetInputExit('XSIJFYBHVF',XSIJFYBHVF_wrap_Valid,SPBOUILib.Row.IN_GRID);
function XSIJFYBHVF_wrap_OnFocus(event) {
return XSIJFYBHVF_OnFocus(event);
}
SPBOUILib.SetInputEnter('XSIJFYBHVF',XSIJFYBHVF_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function XSIJFYBHVF_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('XSIJFYBHVF',XSIJFYBHVF_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
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
m_oFather.i_last_focused_item='child_ardt_settoreuic';
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
windowOpenForeground('../doc/ardt_settoreuic_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_SETSINT=a[0];
w_CODATECO=a[1];
w_IDSETSIN=a[2];
m_PrimaryKeys=['IDSETSIN','CODATECO','SETSINT'];
}
function i_PrimaryKey() {
return 'tbsetsina'+'\\'+CPLib.ToCPStr(w_SETSINT)+'\\'+CPLib.ToCPStr(w_IDSETSIN);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('ardt_settoreuic',m_cSelectedPage);
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
var candidatesToFocus = ["XSIJFYBHVF"];
SetControlFocus(candidatesToFocus);
}
IsRepeatedChild.child=[];
function GetFullRowMsgError() {
return 'MSG_FULLROW_NOT_SAT';
}
_Obli('CODATECO',0,'XSIJFYBHVF',false,"11512725744")
