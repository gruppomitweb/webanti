function FillCombosValues() {
}
function FillInGridCombosValues(currentRow) {
var postfix = (Gt(currentRow,-1)?'_'+currentRow:'');
}
function SetControlsValue() {
var c;
if (Empty(m_cAltInterface) && (Eq(m_cFunction,'view') || Eq(m_cFunction,'query'))) {
} else {
SPBOUILib.SetInputValue('MEQMXATREH',function(){return WtH(w_property_key,'C',20,0,'')},w_property_key);
SPBOUILib.SetInputValue('XKZVGMONMN',function(){return WtH(w_property_value,'M',10,0,'')},w_property_value);
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
HideUI.lblids["property_key"]=['BCJNPFFFMT'];
HideUI.lblids["property_value"]=['MNZUGXIXLE'];
function ExpandCollapseBoxesUnderCondition() {
var cond;
}
function MEQMXATREH_Valid(e) {
SetActiveField(Ctrl('MEQMXATREH'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('property_key','C',w_property_key,HtW(Ctrl('MEQMXATREH').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_property_key(HtW(Ctrl('MEQMXATREH').value,'C'),null,e);
return l_bSetResult;
}
}
function MEQMXATREH_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('MEQMXATREH'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('MEQMXATREH'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('MEQMXATREH'),e);
}
function XKZVGMONMN_Valid(e) {
SetActiveField(Ctrl('XKZVGMONMN'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('property_value','M',w_property_value,HtW(Ctrl('XKZVGMONMN').value,'M'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_property_value(HtW(Ctrl('XKZVGMONMN').value,'M'),null,e);
return l_bSetResult;
}
}
function XKZVGMONMN_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('XKZVGMONMN'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('XKZVGMONMN'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('XKZVGMONMN'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function MEQMXATREH_wrap_Valid(event) {
return MEQMXATREH_Valid(event);
}
SPBOUILib.SetInputExit('MEQMXATREH',MEQMXATREH_wrap_Valid,SPBOUILib.Row.IN_GRID);
function MEQMXATREH_wrap_OnFocus(event) {
return MEQMXATREH_OnFocus(event);
}
SPBOUILib.SetInputEnter('MEQMXATREH',MEQMXATREH_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function MEQMXATREH_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('MEQMXATREH',MEQMXATREH_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function XKZVGMONMN_wrap_Valid(event) {
return XKZVGMONMN_Valid(event);
}
SPBOUILib.SetInputExit('XKZVGMONMN',XKZVGMONMN_wrap_Valid,SPBOUILib.Row.IN_GRID);
function XKZVGMONMN_wrap_OnFocus(event) {
return XKZVGMONMN_OnFocus(event);
}
SPBOUILib.SetInputEnter('XKZVGMONMN',XKZVGMONMN_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
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
m_oFather.i_last_focused_item='child_spauthid_scope_mapper';
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
windowOpenForeground('../doc/spauthid_scope_mapper_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_scope_name=a[0];
w_property_key=a[1];
w_property_value=a[2];
m_PrimaryKeys=['scope_name'];
}
function i_PrimaryKey() {
return 'spauthid_scope_mapper'+'\\'+CPLib.ToCPStr(w_scope_name);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('spauthid_scope_mapper',m_cSelectedPage);
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
var candidatesToFocus = ["MEQMXATREH"];
SetControlFocus(candidatesToFocus);
}
IsRepeatedChild.child=[];
function GetFullRowMsgError() {
return 'MSG_FULLROW_NOT_SAT';
}
_Obli('property_key',0,'MEQMXATREH',false)
_Obli('property_value',0,'XKZVGMONMN',false)
