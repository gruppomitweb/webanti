function FillCombosValues() {
}
function FillInGridCombosValues(currentRow) {
var postfix = (Gt(currentRow,-1)?'_'+currentRow:'');
}
function SetControlsValue() {
var c;
if (Empty(m_cAltInterface) && (Eq(m_cFunction,'view') || Eq(m_cFunction,'query'))) {
} else {
SPBOUILib.SetInputValue('MJILVOVIBU',function(){return WtH(w_groupbase,'N',6,0,'999999')},w_groupbase);
SPBOUILib.SetInputValue('ATYQNYKGKZ',function(){return WtH(w_group_name,'C',50,0,'')},w_group_name);
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
function ExpandCollapseBoxesUnderCondition() {
var cond;
}
function MJILVOVIBU_Valid(e) {
SetActiveField(Ctrl('MJILVOVIBU'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('groupbase','N',w_groupbase,HtW(Ctrl('MJILVOVIBU').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_groupbase(HtW(Ctrl('MJILVOVIBU').value,'N'),null,e);
return l_bSetResult;
}
}
function MJILVOVIBU_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('MJILVOVIBU'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('MJILVOVIBU',w_groupbase,'N',6,0,'999999');
SetActiveField(Ctrl('MJILVOVIBU'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('MJILVOVIBU'),e);
}
function MJILVOVIBU_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("999999"));
}
function MJILVOVIBU_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('MJILVOVIBU')),'linkview_MJILVOVIBU','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function MJILVOVIBU_wrap_Valid(event) {
return MJILVOVIBU_Valid(event);
}
SPBOUILib.SetInputExit('MJILVOVIBU',MJILVOVIBU_wrap_Valid,SPBOUILib.Row.IN_GRID);
function MJILVOVIBU_wrap_OnFocus(event) {
return MJILVOVIBU_OnFocus(event);
}
SPBOUILib.SetInputEnter('MJILVOVIBU',MJILVOVIBU_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function MJILVOVIBU_wrap_OnKeyPress(event) {
return MJILVOVIBU_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('MJILVOVIBU',MJILVOVIBU_wrap_OnKeyPress,SPBOUILib.Row.IN_GRID);
function MJILVOVIBU_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('MJILVOVIBU',MJILVOVIBU_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function MJILVOVIBU_ZOOM_setHandlers() {
function MJILVOVIBU_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?MJILVOVIBU_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('MJILVOVIBU_ZOOM',MJILVOVIBU_ZOOM_wrap_OnClick,SPBOUILib.Row.IN_GRID);
}
SPBOUILib.SetPicker('MJILVOVIBU',MJILVOVIBU_ZOOM_setHandlers);
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
m_oFather.i_last_focused_item='child_spadministration_subgroups';
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
windowOpenForeground('../doc/spadministration_subgroups_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_groupcode=a[0];
w_groupbase=a[1];
w_group_name=a[2];
m_PrimaryKeys=['groupbase','groupcode'];
}
function i_PrimaryKey() {
return 'cpgrpgrp'+'\\'+CPLib.ToCPStr(w_groupcode);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('spadministration_subgroups',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
function LinkZoomExtendedMenu() {
ExtendedMenu({"configName":WtA('','C'),"entityName":WtA('spadministration_groups','C'),"fldValues":[{"expression":function() { return WtA(w_groupbase,'N'); },"field":"code","type":"N"},{"expression":function() { return WtA(w_group_name,'C'); },"field":"name","type":"C"}],"itemRepeated":true,"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('cpgroups','C'),"uid":"MJILVOVIBU"});
}
function FocusFirstDetailComponent() {
var candidatesToFocus = ["MJILVOVIBU"];
SetControlFocus(candidatesToFocus);
}
IsRepeatedChild.child=[];
function GetFullRowMsgError() {
return 'MSG_FULLROW_NOT_SAT';
}
_Obli('groupbase',1,'MJILVOVIBU',false,"1954008362")
