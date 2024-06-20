function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('FTQDGTJKVC',function(){return WtH(w_CODLINBUS,'C',3,0,'')},w_CODLINBUS);
SPBOUILib.SetInputValue('NUNXOFFWEU',function(){return WtH(w_DESLINBUS,'C',50,0,'')},w_DESLINBUS);
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
HideUI.lblids["CODLINBUS"]=['WPHUKTKUJH'];
HideUI.lblids["DESLINBUS"]=['ODDMRVPOPW'];
function FTQDGTJKVC_Valid(e) {
SetActiveField(Ctrl('FTQDGTJKVC'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('FTQDGTJKVC') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('CODLINBUS','C',w_CODLINBUS,HtW(Ctrl('FTQDGTJKVC').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODLINBUS(HtW(Ctrl('FTQDGTJKVC').value,'C'),null,e);
return l_bSetResult;
}
}
function FTQDGTJKVC_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('FTQDGTJKVC'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('FTQDGTJKVC'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('FTQDGTJKVC'),e);
}
function NUNXOFFWEU_Valid(e) {
SetActiveField(Ctrl('NUNXOFFWEU'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DESLINBUS','C',w_DESLINBUS,HtW(Ctrl('NUNXOFFWEU').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DESLINBUS(HtW(Ctrl('NUNXOFFWEU').value,'C'),null,e);
return l_bSetResult;
}
}
function NUNXOFFWEU_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('NUNXOFFWEU'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('NUNXOFFWEU'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('NUNXOFFWEU'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function FTQDGTJKVC_wrap_Valid(event) {
return FTQDGTJKVC_Valid(event);
}
SPBOUILib.SetInputExit('FTQDGTJKVC',FTQDGTJKVC_wrap_Valid);
function FTQDGTJKVC_wrap_OnFocus(event) {
return FTQDGTJKVC_OnFocus(event);
}
SPBOUILib.SetInputEnter('FTQDGTJKVC',FTQDGTJKVC_wrap_OnFocus);
function FTQDGTJKVC_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('FTQDGTJKVC',FTQDGTJKVC_wrap_OnKeyDown);
function NUNXOFFWEU_wrap_Valid(event) {
return NUNXOFFWEU_Valid(event);
}
SPBOUILib.SetInputExit('NUNXOFFWEU',NUNXOFFWEU_wrap_Valid);
function NUNXOFFWEU_wrap_OnFocus(event) {
return NUNXOFFWEU_OnFocus(event);
}
SPBOUILib.SetInputEnter('NUNXOFFWEU',NUNXOFFWEU_wrap_OnFocus);
function NUNXOFFWEU_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('NUNXOFFWEU',NUNXOFFWEU_wrap_OnKeyDown);
if (m_bExtended) {
SetEventsAndStylesToExtendedFields();
}
}
if (Eq(m_cFunction,'query') && Ne(document.FrmToolbar,null)) {
document.FrmToolbar.pos.onkeypress=RecPositionInput;
document.FrmToolbar.pos.onblur=SelectRecord;
}
}
function NotifyEvent(p_cEvent) {
var old_c;
}
function SetLastFocusedOnParent() {
// used only in child entities
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
}
m_nLastError=0;
m_cLastMsgError='';
}
FocusFirstComponent.edit={"page_1":["NUNXOFFWEU"]};
FocusFirstComponent.query={"page_1":["FTQDGTJKVC"]};
FocusFirstComponent.otherwise={"page_1":["FTQDGTJKVC"]};
function Help() {
windowOpenForeground('../doc/armt_cgo_tblinbus_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_CODLINBUS=a[0];
w_DESLINBUS=a[1];
m_PrimaryKeys=['CODLINBUS'];
}
function i_PrimaryKey() {
return 'cgo_tblinbus'+'\\'+CPLib.ToCPStr(w_CODLINBUS);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('armt_cgo_tblinbus',m_cSelectedPage);
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
_Obli('CODLINBUS',0,'FTQDGTJKVC',false,"112851763")
_Obli('DESLINBUS',0,'NUNXOFFWEU',false,"285808099")
