function FillCombosValues() {
}
function FillInGridCombosValues(currentRow) {
var postfix = (Gt(currentRow,-1)?'_'+currentRow:'');
}
function SetControlsValue() {
var c;
if (Empty(m_cAltInterface) && (Eq(m_cFunction,'view') || Eq(m_cFunction,'query'))) {
} else {
SPBOUILib.SetInputValue('DSHVJUCLQJ',function(){return WtH(w_scope_name,'C',50,0,'')},w_scope_name);
SPBOUILib.SetInputValue('KQQGEXBFDX',function(){return WtH(w_scope_description,'C',50,0,'')},w_scope_description);
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
HideUI.lblids["scope_name"]=['QICQJZPSSW'];
function ExpandCollapseBoxesUnderCondition() {
var cond;
}
function DSHVJUCLQJ_Valid(e) {
SetActiveField(Ctrl('DSHVJUCLQJ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('scope_name','C',w_scope_name,HtW(Ctrl('DSHVJUCLQJ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_scope_name(HtW(Ctrl('DSHVJUCLQJ').value,'C'),null,e);
return l_bSetResult;
}
}
function DSHVJUCLQJ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('DSHVJUCLQJ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('DSHVJUCLQJ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('DSHVJUCLQJ'),e);
}
function DSHVJUCLQJ_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('DSHVJUCLQJ')),'linkview_DSHVJUCLQJ','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function DSHVJUCLQJ_wrap_Valid(event) {
return DSHVJUCLQJ_Valid(event);
}
SPBOUILib.SetInputExit('DSHVJUCLQJ',DSHVJUCLQJ_wrap_Valid,SPBOUILib.Row.IN_GRID);
function DSHVJUCLQJ_wrap_OnFocus(event) {
return DSHVJUCLQJ_OnFocus(event);
}
SPBOUILib.SetInputEnter('DSHVJUCLQJ',DSHVJUCLQJ_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function DSHVJUCLQJ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('DSHVJUCLQJ',DSHVJUCLQJ_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function DSHVJUCLQJ_ZOOM_setHandlers() {
function DSHVJUCLQJ_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?DSHVJUCLQJ_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('DSHVJUCLQJ_ZOOM',DSHVJUCLQJ_ZOOM_wrap_OnClick,SPBOUILib.Row.IN_GRID);
}
SPBOUILib.SetPicker('DSHVJUCLQJ',DSHVJUCLQJ_ZOOM_setHandlers);
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
m_oFather.i_last_focused_item='child_spauthid_client_scope_mapping';
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
windowOpenForeground('../doc/spauthid_client_scope_mapping_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_client_code=a[0];
w_scope_name=a[1];
w_scope_description=a[2];
m_PrimaryKeys=['scope_name','client_code'];
}
function i_PrimaryKey() {
return 'spauthid_client_scope_mapping'+'\\'+CPLib.ToCPStr(w_client_code);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('spauthid_client_scope_mapping',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
function LinkZoomExtendedMenu() {
ExtendedMenu({"configName":WtA('','C'),"entityName":WtA('spauthid_scope','C'),"fldValues":[{"expression":function() { return WtA(w_scope_name,'C'); },"field":"name","type":"C"},{"expression":function() { return WtA(w_scope_description,'C'); },"field":"description","type":"C"}],"itemRepeated":true,"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('spauthid_scope','C'),"uid":"DSHVJUCLQJ"});
}
function FocusFirstDetailComponent() {
var candidatesToFocus = ["DSHVJUCLQJ"];
SetControlFocus(candidatesToFocus);
}
IsRepeatedChild.child=[];
function GetFullRowMsgError() {
return 'MSG_FULLROW_NOT_SAT';
}
_Obli('scope_name',0,'DSHVJUCLQJ',false)
