function FillCombosValues() {
}
function FillInGridCombosValues(currentRow) {
var postfix = (Gt(currentRow,-1)?'_'+currentRow:'');
}
function SetControlsValue() {
var c;
if (Empty(m_cAltInterface) && (Eq(m_cFunction,'view') || Eq(m_cFunction,'query'))) {
} else {
SPBOUILib.SetInputValue('GCFQVRXGQC',function(){return WtH(w_tipinter,'C',2,0,'')},w_tipinter);
SPBOUILib.SetInputValue('IZLSVDYFRS',function(){return WtH(w_xdescinter,'C',80,0,'')},w_xdescinter);
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
function GCFQVRXGQC_Valid(e) {
SetActiveField(Ctrl('GCFQVRXGQC'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('tipinter','C',w_tipinter,HtW(Ctrl('GCFQVRXGQC').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_tipinter(HtW(Ctrl('GCFQVRXGQC').value,'C'),null,e);
return l_bSetResult;
}
}
function GCFQVRXGQC_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('GCFQVRXGQC'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('GCFQVRXGQC'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('GCFQVRXGQC'),e);
}
function GCFQVRXGQC_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('GCFQVRXGQC')),'linkview_GCFQVRXGQC','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function GCFQVRXGQC_wrap_Valid(event) {
return GCFQVRXGQC_Valid(event);
}
SPBOUILib.SetInputExit('GCFQVRXGQC',GCFQVRXGQC_wrap_Valid,SPBOUILib.Row.IN_GRID);
function GCFQVRXGQC_wrap_OnFocus(event) {
return GCFQVRXGQC_OnFocus(event);
}
SPBOUILib.SetInputEnter('GCFQVRXGQC',GCFQVRXGQC_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function GCFQVRXGQC_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('GCFQVRXGQC',GCFQVRXGQC_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function GCFQVRXGQC_ZOOM_setHandlers() {
function GCFQVRXGQC_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?GCFQVRXGQC_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('GCFQVRXGQC_ZOOM',GCFQVRXGQC_ZOOM_wrap_OnClick,SPBOUILib.Row.IN_GRID);
}
SPBOUILib.SetPicker('GCFQVRXGQC',GCFQVRXGQC_ZOOM_setHandlers);
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
m_oFather.i_last_focused_item='child_ardt_tipointer';
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
windowOpenForeground('../doc/ardt_tipointer_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_codcau=a[0];
w_tipinter=a[1];
w_xdescinter=a[2];
m_PrimaryKeys=['tipinter','codcau'];
}
function i_PrimaryKey() {
return 'cauanainter'+'\\'+CPLib.ToCPStr(w_codcau);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('ardt_tipointer',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
function LinkZoomExtendedMenu() {
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_tipinter,'C'); },"field":"TIPOINT","type":"C"},{"expression":function() { return WtA(w_xdescinter,'C'); },"field":"DESCRI","type":"C"}],"itemRepeated":true,"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbtipint','C'),"uid":"GCFQVRXGQC"});
}
function FocusFirstDetailComponent() {
var candidatesToFocus = ["GCFQVRXGQC"];
SetControlFocus(candidatesToFocus);
}
IsRepeatedChild.child=[];
function GetFullRowMsgError() {
return 'MSG_FULLROW_NOT_SAT';
}
_Obli('tipinter',0,'GCFQVRXGQC',false,"1250573741")
