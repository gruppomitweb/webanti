function FillCombosValues() {
}
function FillInGridCombosValues(currentRow) {
var postfix = (Gt(currentRow,-1)?'_'+currentRow:'');
}
function SetControlsValue() {
var c;
if (Empty(m_cAltInterface) && (Eq(m_cFunction,'view') || Eq(m_cFunction,'query'))) {
} else {
SPBOUILib.SetInputValue('ADJOKPLCJT',function(){return WtH(w_RAPPORTO,'C',25,0,'')},w_RAPPORTO);
SPBOUILib.SetInputValue('FYWFMVGIZB',function(){return WtH(w_DESCRAP,'C',50,0,'')},w_DESCRAP);
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
HideUI.lblids["RAPPORTO"]=['DFYCPPPKFL'];
function ADJOKPLCJT_Valid(e) {
SetActiveField(Ctrl('ADJOKPLCJT'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('RAPPORTO','C',w_RAPPORTO,HtW(Ctrl('ADJOKPLCJT').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_RAPPORTO(HtW(Ctrl('ADJOKPLCJT').value,'C'),null,e);
return l_bSetResult;
}
}
function ADJOKPLCJT_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ADJOKPLCJT'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('ADJOKPLCJT'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ADJOKPLCJT'),e);
}
function ADJOKPLCJT_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('ADJOKPLCJT')),'linkview_ADJOKPLCJT','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function ADJOKPLCJT_wrap_Valid(event) {
return ADJOKPLCJT_Valid(event);
}
SPBOUILib.SetInputExit('ADJOKPLCJT',ADJOKPLCJT_wrap_Valid,SPBOUILib.Row.IN_GRID);
function ADJOKPLCJT_wrap_OnFocus(event) {
return ADJOKPLCJT_OnFocus(event);
}
SPBOUILib.SetInputEnter('ADJOKPLCJT',ADJOKPLCJT_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function ADJOKPLCJT_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('ADJOKPLCJT',ADJOKPLCJT_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function ADJOKPLCJT_ZOOM_setHandlers() {
function ADJOKPLCJT_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?ADJOKPLCJT_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('ADJOKPLCJT_ZOOM',ADJOKPLCJT_ZOOM_wrap_OnClick,SPBOUILib.Row.IN_GRID);
}
SPBOUILib.SetPicker('ADJOKPLCJT',ADJOKPLCJT_ZOOM_setHandlers);
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
m_oFather.i_last_focused_item='child_ardt_rapcoll';
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
windowOpenForeground('../doc/ardt_rapcoll_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_IDFILEBO=a[0];
w_RAPPORTO=a[1];
w_IDBASE=a[2];
w_DESCRAP=a[3];
m_PrimaryKeys=['RAPPORTO','IDFILEBO'];
}
function i_PrimaryKey() {
return 'rapcoll'+'\\'+CPLib.ToCPStr(w_IDFILEBO);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('ardt_rapcoll',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
function LinkZoomExtendedMenu() {
ExtendedMenu({"configName":WtA('','C'),"entityName":WtA('armt_anarap','C'),"fldValues":[{"expression":function() { return WtA(w_RAPPORTO,'C'); },"field":"RAPPORTO","type":"C"},{"expression":function() { return WtA(w_DESCRAP,'C'); },"field":"DESCRAP","type":"C"}],"itemRepeated":true,"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('anarapbo','C'),"uid":"ADJOKPLCJT"});
}
function FocusFirstDetailComponent() {
var candidatesToFocus = ["ADJOKPLCJT"];
SetControlFocus(candidatesToFocus);
}
IsRepeatedChild.child=[];
function GetFullRowMsgError() {
return 'MSG_FULLROW_NOT_SAT';
}
_Obli('RAPPORTO',0,'ADJOKPLCJT',false,"1805022818")
