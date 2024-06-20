function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('SQTPJSDVUJ',function(){return WtH(w_PSPROCESSO,'C',60,0,'')},w_PSPROCESSO);
SPBOUILib.SetInputValue('STCWFBIBRL',function(){return WtH(w_PSDESCRIZ,'C',80,0,'')},w_PSDESCRIZ);
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
HideUI.lblids["PSDESCRIZ"]=['FNDTXLYPTK'];
HideUI.lblids["PSPROCESSO"]=['HEKZKSOODJ'];
function SQTPJSDVUJ_Valid(e) {
SetActiveField(Ctrl('SQTPJSDVUJ'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('SQTPJSDVUJ') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('PSPROCESSO','C',w_PSPROCESSO,HtW(Ctrl('SQTPJSDVUJ').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PSPROCESSO(HtW(Ctrl('SQTPJSDVUJ').value,'C'),null,e);
return l_bSetResult;
}
}
function SQTPJSDVUJ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('SQTPJSDVUJ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('SQTPJSDVUJ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('SQTPJSDVUJ'),e);
}
function STCWFBIBRL_Valid(e) {
SetActiveField(Ctrl('STCWFBIBRL'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('PSDESCRIZ','C',w_PSDESCRIZ,HtW(Ctrl('STCWFBIBRL').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PSDESCRIZ(HtW(Ctrl('STCWFBIBRL').value,'C'),null,e);
return l_bSetResult;
}
}
function STCWFBIBRL_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('STCWFBIBRL'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('STCWFBIBRL'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('STCWFBIBRL'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function SQTPJSDVUJ_wrap_Valid(event) {
return SQTPJSDVUJ_Valid(event);
}
SPBOUILib.SetInputExit('SQTPJSDVUJ',SQTPJSDVUJ_wrap_Valid);
function SQTPJSDVUJ_wrap_OnFocus(event) {
return SQTPJSDVUJ_OnFocus(event);
}
SPBOUILib.SetInputEnter('SQTPJSDVUJ',SQTPJSDVUJ_wrap_OnFocus);
function SQTPJSDVUJ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('SQTPJSDVUJ',SQTPJSDVUJ_wrap_OnKeyDown);
function STCWFBIBRL_wrap_Valid(event) {
return STCWFBIBRL_Valid(event);
}
SPBOUILib.SetInputExit('STCWFBIBRL',STCWFBIBRL_wrap_Valid);
function STCWFBIBRL_wrap_OnFocus(event) {
return STCWFBIBRL_OnFocus(event);
}
SPBOUILib.SetInputEnter('STCWFBIBRL',STCWFBIBRL_wrap_OnFocus);
function STCWFBIBRL_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('STCWFBIBRL',STCWFBIBRL_wrap_OnKeyDown);
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
FocusFirstComponent.edit={"page_1":["STCWFBIBRL"]};
FocusFirstComponent.query={"page_1":["SQTPJSDVUJ"]};
FocusFirstComponent.otherwise={"page_1":["SQTPJSDVUJ"]};
function Help() {
windowOpenForeground('../doc/mt_tbprcsched_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_PSPROCESSO=a[0];
w_PSDESCRIZ=a[1];
m_PrimaryKeys=['PSPROCESSO'];
}
function i_PrimaryKey() {
return 'tbprcsched'+'\\'+CPLib.ToCPStr(w_PSPROCESSO);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('mt_tbprcsched',m_cSelectedPage);
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
_Obli('PSPROCESSO',0,'SQTPJSDVUJ',false,"1788585584")
_Obli('PSDESCRIZ',0,'STCWFBIBRL',false,"285808099")
