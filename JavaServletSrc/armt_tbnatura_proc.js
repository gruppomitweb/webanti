function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('JLVPSZIHBQ',function(){return WtH(w_CODICE,'N',5,0,'99999')},w_CODICE);
SPBOUILib.SetInputValue('WIYCIIQYSC',function(){return WtH(w_DESCRI,'C',100,0,'')},w_DESCRI);
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
HideUI.lblids["CODICE"]=['YNGCOCDSCP'];
HideUI.lblids["DESCRI"]=['VMTMRGWNGE'];
function JLVPSZIHBQ_Valid(e) {
SetActiveField(Ctrl('JLVPSZIHBQ'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('JLVPSZIHBQ') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('CODICE','N',w_CODICE,HtW(Ctrl('JLVPSZIHBQ').value,'N'),m_bQueryOnLatestKeyOnly);
}
}
}
function JLVPSZIHBQ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('JLVPSZIHBQ'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('JLVPSZIHBQ',w_CODICE,'N',5,0,'99999');
SetActiveField(Ctrl('JLVPSZIHBQ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('JLVPSZIHBQ'),e);
}
function JLVPSZIHBQ_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("99999"));
}
function WIYCIIQYSC_Valid(e) {
SetActiveField(Ctrl('WIYCIIQYSC'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DESCRI','C',w_DESCRI,HtW(Ctrl('WIYCIIQYSC').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DESCRI(HtW(Ctrl('WIYCIIQYSC').value,'C'),null,e);
return l_bSetResult;
}
}
function WIYCIIQYSC_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('WIYCIIQYSC'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('WIYCIIQYSC'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('WIYCIIQYSC'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function JLVPSZIHBQ_wrap_Valid(event) {
return JLVPSZIHBQ_Valid(event);
}
SPBOUILib.SetInputExit('JLVPSZIHBQ',JLVPSZIHBQ_wrap_Valid);
function JLVPSZIHBQ_wrap_OnFocus(event) {
return JLVPSZIHBQ_OnFocus(event);
}
SPBOUILib.SetInputEnter('JLVPSZIHBQ',JLVPSZIHBQ_wrap_OnFocus);
function JLVPSZIHBQ_wrap_OnKeyPress(event) {
return JLVPSZIHBQ_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('JLVPSZIHBQ',JLVPSZIHBQ_wrap_OnKeyPress);
function JLVPSZIHBQ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('JLVPSZIHBQ',JLVPSZIHBQ_wrap_OnKeyDown);
function WIYCIIQYSC_wrap_Valid(event) {
return WIYCIIQYSC_Valid(event);
}
SPBOUILib.SetInputExit('WIYCIIQYSC',WIYCIIQYSC_wrap_Valid);
function WIYCIIQYSC_wrap_OnFocus(event) {
return WIYCIIQYSC_OnFocus(event);
}
SPBOUILib.SetInputEnter('WIYCIIQYSC',WIYCIIQYSC_wrap_OnFocus);
function WIYCIIQYSC_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('WIYCIIQYSC',WIYCIIQYSC_wrap_OnKeyDown);
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
FocusFirstComponent.edit={"page_1":["WIYCIIQYSC"]};
FocusFirstComponent.query={"page_1":["JLVPSZIHBQ","WIYCIIQYSC"]};
FocusFirstComponent.otherwise={"page_1":["WIYCIIQYSC"]};
function Help() {
windowOpenForeground('../doc/armt_tbnatura_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_CODICE=a[0];
op_CODICE=a[1];
w_DESCRI=a[2];
m_PrimaryKeys=['CODICE'];
}
function i_PrimaryKey() {
return 'tbnatura'+'\\'+CPLib.ToCPStr(w_CODICE);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('armt_tbnatura',m_cSelectedPage);
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
_Obli('DESCRI',0,'WIYCIIQYSC',false,"285808099")
