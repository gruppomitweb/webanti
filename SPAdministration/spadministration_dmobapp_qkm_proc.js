function FillCombosValues() {
}
function FillInGridCombosValues(currentRow) {
var postfix = (Gt(currentRow,-1)?'_'+currentRow:'');
}
function SetControlsValue() {
var c;
if (Empty(m_cAltInterface) && (Eq(m_cFunction,'view') || Eq(m_cFunction,'query'))) {
} else {
SPBOUILib.SetInputValue('HHFNNOVMZJ',function(){return WtH(w_QA_LABEL,'C',30,0,'')},w_QA_LABEL);
SPBOUILib.SetInputValue('FBSHOPZFKH',function(){return WtH(w_QA_URL,'C',255,0,'')},w_QA_URL);
SPBOUILib.SetInputValue('RGQJMWXDDN',function(){return WtH(w_QA_ICON,'C',255,0,'')},w_QA_ICON);
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
HideUI.lblids["QA_ICON"]=['NXGYZIVYKL'];
HideUI.lblids["QA_LABEL"]=['HDCCQNLTKB'];
HideUI.lblids["QA_URL"]=['IWFKEOWOMG'];
function HHFNNOVMZJ_Valid(e) {
SetActiveField(Ctrl('HHFNNOVMZJ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('QA_LABEL','C',w_QA_LABEL,HtW(Ctrl('HHFNNOVMZJ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_QA_LABEL(HtW(Ctrl('HHFNNOVMZJ').value,'C'),null,e);
return l_bSetResult;
}
}
function HHFNNOVMZJ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('HHFNNOVMZJ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('HHFNNOVMZJ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('HHFNNOVMZJ'),e);
}
function FBSHOPZFKH_Valid(e) {
SetActiveField(Ctrl('FBSHOPZFKH'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('QA_URL','C',w_QA_URL,HtW(Ctrl('FBSHOPZFKH').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_QA_URL(HtW(Ctrl('FBSHOPZFKH').value,'C'),null,e);
return l_bSetResult;
}
}
function FBSHOPZFKH_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('FBSHOPZFKH'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('FBSHOPZFKH'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('FBSHOPZFKH'),e);
}
function RGQJMWXDDN_Valid(e) {
SetActiveField(Ctrl('RGQJMWXDDN'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('QA_ICON','C',w_QA_ICON,HtW(Ctrl('RGQJMWXDDN').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_QA_ICON(HtW(Ctrl('RGQJMWXDDN').value,'C'),null,e);
return l_bSetResult;
}
}
function RGQJMWXDDN_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('RGQJMWXDDN'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('RGQJMWXDDN'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('RGQJMWXDDN'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function HHFNNOVMZJ_wrap_Valid(event) {
return HHFNNOVMZJ_Valid(event);
}
SPBOUILib.SetInputExit('HHFNNOVMZJ',HHFNNOVMZJ_wrap_Valid,SPBOUILib.Row.IN_GRID);
function HHFNNOVMZJ_wrap_OnFocus(event) {
return HHFNNOVMZJ_OnFocus(event);
}
SPBOUILib.SetInputEnter('HHFNNOVMZJ',HHFNNOVMZJ_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function HHFNNOVMZJ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('HHFNNOVMZJ',HHFNNOVMZJ_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function FBSHOPZFKH_wrap_Valid(event) {
return FBSHOPZFKH_Valid(event);
}
SPBOUILib.SetInputExit('FBSHOPZFKH',FBSHOPZFKH_wrap_Valid,SPBOUILib.Row.IN_GRID);
function FBSHOPZFKH_wrap_OnFocus(event) {
return FBSHOPZFKH_OnFocus(event);
}
SPBOUILib.SetInputEnter('FBSHOPZFKH',FBSHOPZFKH_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function FBSHOPZFKH_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('FBSHOPZFKH',FBSHOPZFKH_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function RGQJMWXDDN_wrap_Valid(event) {
return RGQJMWXDDN_Valid(event);
}
SPBOUILib.SetInputExit('RGQJMWXDDN',RGQJMWXDDN_wrap_Valid,SPBOUILib.Row.IN_GRID);
function RGQJMWXDDN_wrap_OnFocus(event) {
return RGQJMWXDDN_OnFocus(event);
}
SPBOUILib.SetInputEnter('RGQJMWXDDN',RGQJMWXDDN_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function RGQJMWXDDN_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('RGQJMWXDDN',RGQJMWXDDN_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
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
m_oFather.i_last_focused_item='child_spadministration_dmobapp_qkm';
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
windowOpenForeground('../doc/spadministration_dmobapp_qkm_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_CPROWNUM=a[0];
w_QA_CODE=a[1];
w_QA_LABEL=a[2];
w_QA_URL=a[3];
w_QA_ICON=a[4];
m_PrimaryKeys=['QA_CODE','CPROWNUM'];
}
function i_PrimaryKey() {
return 'cpqkmappstore'+'\\'+CPLib.ToCPStr(w_QA_CODE);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('spadministration_dmobapp_qkm',m_cSelectedPage);
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
var candidatesToFocus = ["HHFNNOVMZJ"];
SetControlFocus(candidatesToFocus);
}
IsRepeatedChild.child=[];
function GetFullRowMsgError() {
return 'MSG_FULLROW_NOT_SAT';
}
_Obli('QA_LABEL',0,'HHFNNOVMZJ',false,"10873002357")
_Obli('QA_URL',0,'FBSHOPZFKH',false,"20853")
_Obli('QA_ICON',0,'RGQJMWXDDN',false,"10804140837")
