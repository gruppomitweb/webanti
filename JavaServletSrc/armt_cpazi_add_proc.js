function FillCombosValues() {
}
function SetControlsValue() {
var c;
if(c=Ctrl('JSKCTWPJGM')) ChkboxCheckUncheck(c,'S',w_flgotp)
if(c=Ctrl('JSKCTWPJGM')) ChkboxValueAssign(c,'S','N','C',1,0,'')
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
function JSKCTWPJGM_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('flgotp','C',w_flgotp,ChkboxValueAssign(Ctrl('JSKCTWPJGM'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_flgotp(ChkboxValueAssign(Ctrl('JSKCTWPJGM'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function JSKCTWPJGM_OnFocus(e) {
SetActiveField(Ctrl('JSKCTWPJGM'),true);
}
function JSKCTWPJGM_OnBlur(e) {
SetActiveField(Ctrl('JSKCTWPJGM'),false);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function JSKCTWPJGM_wrap_Valid(event) {
return JSKCTWPJGM_Valid(event);
}
SPBOUILib.SetCheckboxClick('JSKCTWPJGM',JSKCTWPJGM_wrap_Valid);
function JSKCTWPJGM_wrap_OnFocus(event) {
return JSKCTWPJGM_OnFocus(event);
}
SPBOUILib.SetInputEnter('JSKCTWPJGM',JSKCTWPJGM_wrap_OnFocus);
function JSKCTWPJGM_wrap_Blur(event) {
return JSKCTWPJGM_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('JSKCTWPJGM',JSKCTWPJGM_wrap_Blur);
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
m_oFather.i_last_focused_item='child_armt_cpazi_add';
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
}
m_nLastError=0;
m_cLastMsgError='';
}
FocusFirstComponent.edit={"page_1":["JSKCTWPJGM"]};
FocusFirstComponent.query={"page_1":["JSKCTWPJGM"]};
FocusFirstComponent.otherwise={"page_1":["JSKCTWPJGM"]};
function Help() {
windowOpenForeground('../doc/armt_cpazi_add_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_codazi=a[0];
w_flgotp=a[1];
m_PrimaryKeys=['codazi'];
}
function i_PrimaryKey() {
return 'cpazi_add'+'\\'+CPLib.ToCPStr(w_codazi);
}
function CheckZone(me) {
if (IsWndAccessible(window['m_oFather'])) {
return m_oFather.CheckZone('child_armt_cpazi_add');
}
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('armt_cpazi_add',m_cSelectedPage);
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
_Obli('flgotp',0,'JSKCTWPJGM',false,"10983166297")
