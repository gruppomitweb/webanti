function FillCombosValues() {
}
function FillInGridCombosValues(currentRow) {
var postfix = (Gt(currentRow,-1)?'_'+currentRow:'');
}
function SetControlsValue() {
var c;
if (Empty(m_cAltInterface) && (Eq(m_cFunction,'view') || Eq(m_cFunction,'query'))) {
} else {
SPBOUILib.SetInputValue('SSYFQFAQAO',function(){return WtH(w_DATIPDOC,'C',2,0,'')},w_DATIPDOC);
SPBOUILib.SetInputValue('PPFKYXMARY',function(){return WtH(w_xDESCRI,'C',30,0,'')},w_xDESCRI);
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
HideUI.lblids["DATIPDOC"]=['SZJVTKWOUU'];
function SSYFQFAQAO_Valid(e) {
SetActiveField(Ctrl('SSYFQFAQAO'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATIPDOC','C',w_DATIPDOC,HtW(Ctrl('SSYFQFAQAO').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATIPDOC(HtW(Ctrl('SSYFQFAQAO').value,'C'),null,e);
return l_bSetResult;
}
}
function SSYFQFAQAO_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('SSYFQFAQAO'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('SSYFQFAQAO'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('SSYFQFAQAO'),e);
}
function SSYFQFAQAO_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('SSYFQFAQAO')),'linkview_SSYFQFAQAO','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function SSYFQFAQAO_wrap_Valid(event) {
return SSYFQFAQAO_Valid(event);
}
SPBOUILib.SetInputExit('SSYFQFAQAO',SSYFQFAQAO_wrap_Valid,SPBOUILib.Row.IN_GRID);
function SSYFQFAQAO_wrap_OnFocus(event) {
return SSYFQFAQAO_OnFocus(event);
}
SPBOUILib.SetInputEnter('SSYFQFAQAO',SSYFQFAQAO_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function SSYFQFAQAO_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('SSYFQFAQAO',SSYFQFAQAO_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function SSYFQFAQAO_ZOOM_setHandlers() {
function SSYFQFAQAO_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?SSYFQFAQAO_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('SSYFQFAQAO_ZOOM',SSYFQFAQAO_ZOOM_wrap_OnClick,SPBOUILib.Row.IN_GRID);
}
SPBOUILib.SetPicker('SSYFQFAQAO',SSYFQFAQAO_ZOOM_setHandlers);
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
m_oFather.i_last_focused_item='child_ardt_docaut';
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
windowOpenForeground('../doc/ardt_docaut_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_DACODICE=a[0];
w_DATIPDOC=a[1];
w_xDESCRI=a[2];
m_PrimaryKeys=['DATIPDOC','DACODICE'];
}
function i_PrimaryKey() {
return 'cgo_docaut'+'\\'+CPLib.ToCPStr(w_DACODICE);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('ardt_docaut',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
function LinkZoomExtendedMenu() {
ExtendedMenu({"configName":WtA('','C'),"entityName":WtA('armt_cgo_tipdoc','C'),"fldValues":[{"expression":function() { return WtA(w_DATIPDOC,'C'); },"field":"TIPDOC","type":"C"},{"expression":function() { return WtA(w_xDESCRI,'C'); },"field":"DESCRI","type":"C"}],"itemRepeated":true,"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('cgo_tipdoc','C'),"uid":"SSYFQFAQAO"});
}
function FocusFirstDetailComponent() {
var candidatesToFocus = ["SSYFQFAQAO"];
SetControlFocus(candidatesToFocus);
}
IsRepeatedChild.child=[];
function GetFullRowMsgError() {
return 'MSG_FULLROW_NOT_SAT';
}
_Obli('DATIPDOC',0,'SSYFQFAQAO',false,"11429032151")
