function FillCombosValues() {
}
function FillInGridCombosValues(currentRow) {
var postfix = (Gt(currentRow,-1)?'_'+currentRow:'');
}
function SetControlsValue() {
var c;
if (Empty(m_cAltInterface) && (Eq(m_cFunction,'view') || Eq(m_cFunction,'query'))) {
} else {
SPBOUILib.SetInputValue('EEOVPULSYY',function(){return WtH(w_DWNOMINATIVO,'C',50,0,'')},w_DWNOMINATIVO);
SPBOUILib.SetInputValue('HEMRMYCSDF',function(){return WtH(w_DWEMAIL,'C',50,0,'')},w_DWEMAIL);
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
HideUI.lblids["DWEMAIL"]=['YDFAFGEYQN'];
HideUI.lblids["DWNOMINATIVO"]=['FKKOVAHNDF'];
function EEOVPULSYY_Valid(e) {
SetActiveField(Ctrl('EEOVPULSYY'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DWNOMINATIVO','C',w_DWNOMINATIVO,HtW(Ctrl('EEOVPULSYY').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DWNOMINATIVO(HtW(Ctrl('EEOVPULSYY').value,'C'),null,e);
return l_bSetResult;
}
}
function EEOVPULSYY_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('EEOVPULSYY'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('EEOVPULSYY'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('EEOVPULSYY'),e);
}
function HEMRMYCSDF_Valid(e) {
SetActiveField(Ctrl('HEMRMYCSDF'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DWEMAIL','C',w_DWEMAIL,HtW(Ctrl('HEMRMYCSDF').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DWEMAIL(HtW(Ctrl('HEMRMYCSDF').value,'C'),null,e);
return l_bSetResult;
}
}
function HEMRMYCSDF_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('HEMRMYCSDF'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('HEMRMYCSDF'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('HEMRMYCSDF'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function EEOVPULSYY_wrap_Valid(event) {
return EEOVPULSYY_Valid(event);
}
SPBOUILib.SetInputExit('EEOVPULSYY',EEOVPULSYY_wrap_Valid,SPBOUILib.Row.IN_GRID);
function EEOVPULSYY_wrap_OnFocus(event) {
return EEOVPULSYY_OnFocus(event);
}
SPBOUILib.SetInputEnter('EEOVPULSYY',EEOVPULSYY_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function EEOVPULSYY_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('EEOVPULSYY',EEOVPULSYY_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function HEMRMYCSDF_wrap_Valid(event) {
return HEMRMYCSDF_Valid(event);
}
SPBOUILib.SetInputExit('HEMRMYCSDF',HEMRMYCSDF_wrap_Valid,SPBOUILib.Row.IN_GRID);
function HEMRMYCSDF_wrap_OnFocus(event) {
return HEMRMYCSDF_OnFocus(event);
}
SPBOUILib.SetInputEnter('HEMRMYCSDF',HEMRMYCSDF_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function HEMRMYCSDF_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('HEMRMYCSDF',HEMRMYCSDF_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
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
m_oFather.i_last_focused_item='child_ardt_destwarn';
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
windowOpenForeground('../doc/ardt_destwarn_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_DWCODINT=a[0];
w_DWNOMINATIVO=a[1];
w_DWEMAIL=a[2];
w_CPROWNUM=a[3];
m_PrimaryKeys=['CPROWNUM','DWCODINT'];
}
function i_PrimaryKey() {
return 'destwarn'+'\\'+CPLib.ToCPStr(w_DWCODINT);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('ardt_destwarn',m_cSelectedPage);
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
var candidatesToFocus = ["EEOVPULSYY"];
SetControlFocus(candidatesToFocus);
}
IsRepeatedChild.child=[];
function GetFullRowMsgError() {
return 'MSG_FULLROW_NOT_SAT';
}
_Obli('DWNOMINATIVO',0,'EEOVPULSYY',false,"176491428")
_Obli('DWEMAIL',0,'HEMRMYCSDF',false,"521881905")
