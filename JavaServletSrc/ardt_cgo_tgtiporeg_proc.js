function FillCombosValues() {
}
function FillInGridCombosValues(currentRow) {
var postfix = (Gt(currentRow,-1)?'_'+currentRow:'');
}
function SetControlsValue() {
var c;
if (Empty(m_cAltInterface) && (Eq(m_cFunction,'view') || Eq(m_cFunction,'query'))) {
} else {
if(c=Ctrl('KUVQXAZDHJ')) selectCombo(c,w_TRTIPREG,'C')
SPBOUILib.SetInputValue('JGDIWWMKFV',function(){return WtH(w_TRDESREG,'C',30,0,'')},w_TRDESREG);
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
HideUI.lblids["TRDESREG"]=['LISBMXOQHK'];
HideUI.lblids["TRTIPREG"]=['RQMVFIREGT'];
function KUVQXAZDHJ_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('TRTIPREG','C',w_TRTIPREG,HtW(getComboValue(Ctrl('KUVQXAZDHJ')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRTIPREG(HtW(getComboValue(Ctrl('KUVQXAZDHJ')),'C'),null,e);
return l_bSetResult;
}
}
function KUVQXAZDHJ_OnFocus(e) {
SetActiveField(Ctrl('KUVQXAZDHJ'),true);
}
function KUVQXAZDHJ_OnBlur(e) {
SetActiveField(Ctrl('KUVQXAZDHJ'),false);
}
function JGDIWWMKFV_Valid(e) {
SetActiveField(Ctrl('JGDIWWMKFV'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TRDESREG','C',w_TRDESREG,HtW(Ctrl('JGDIWWMKFV').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRDESREG(HtW(Ctrl('JGDIWWMKFV').value,'C'),null,e);
return l_bSetResult;
}
}
function JGDIWWMKFV_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('JGDIWWMKFV'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('JGDIWWMKFV'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('JGDIWWMKFV'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function KUVQXAZDHJ_wrap_Valid(event) {
return KUVQXAZDHJ_Valid(event);
}
SPBOUILib.SetComboChange('KUVQXAZDHJ',KUVQXAZDHJ_wrap_Valid,SPBOUILib.Row.IN_GRID);
function KUVQXAZDHJ_wrap_OnFocus(event) {
return KUVQXAZDHJ_OnFocus(event);
}
SPBOUILib.SetInputEnter('KUVQXAZDHJ',KUVQXAZDHJ_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function KUVQXAZDHJ_wrap_Blur(event) {
return KUVQXAZDHJ_OnBlur(event);
}
SPBOUILib.SetInputExit('KUVQXAZDHJ',KUVQXAZDHJ_wrap_Blur,SPBOUILib.Row.IN_GRID);
function JGDIWWMKFV_wrap_Valid(event) {
return JGDIWWMKFV_Valid(event);
}
SPBOUILib.SetInputExit('JGDIWWMKFV',JGDIWWMKFV_wrap_Valid,SPBOUILib.Row.IN_GRID);
function JGDIWWMKFV_wrap_OnFocus(event) {
return JGDIWWMKFV_OnFocus(event);
}
SPBOUILib.SetInputEnter('JGDIWWMKFV',JGDIWWMKFV_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function JGDIWWMKFV_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('JGDIWWMKFV',JGDIWWMKFV_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
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
m_oFather.i_last_focused_item='child_ardt_cgo_tgtiporeg';
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
windowOpenForeground('../doc/ardt_cgo_tgtiporeg_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_TRCODGIO=a[0];
w_TRTIPREG=a[1];
w_TRDESREG=a[2];
m_PrimaryKeys=['TRTIPREG','TRCODGIO'];
}
function i_PrimaryKey() {
return 'cgo_tgtiporeg'+'\\'+CPLib.ToCPStr(w_TRCODGIO);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('ardt_cgo_tgtiporeg',m_cSelectedPage);
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
var candidatesToFocus = ["KUVQXAZDHJ"];
SetControlFocus(candidatesToFocus);
}
IsRepeatedChild.child=[];
function GetFullRowMsgError() {
return 'MSG_FULLROW_NOT_SAT';
}
_Obli('TRTIPREG',0,'KUVQXAZDHJ',false,"995100987")
_Obli('TRDESREG',0,'JGDIWWMKFV',false,"285808099")
