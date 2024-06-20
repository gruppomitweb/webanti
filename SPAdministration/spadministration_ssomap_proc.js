function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('KETCZPSXKD',function(){return WtH(w_ssoid,'C',100,0,'')},w_ssoid);
SPBOUILib.SetInputValue('ZPLLDHVTOQ',function(){return WtH(w_userid,'N',9,0,'999999')},w_userid);
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
HideUI.lblids["ssoid"]=['EQCGQLVPJU'];
HideUI.lblids["userid"]=['YEBKADFXLA'];
function KETCZPSXKD_Valid(e) {
SetActiveField(Ctrl('KETCZPSXKD'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('KETCZPSXKD') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('ssoid','C',w_ssoid,HtW(Ctrl('KETCZPSXKD').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ssoid(HtW(Ctrl('KETCZPSXKD').value,'C'),null,e);
return l_bSetResult;
}
}
function KETCZPSXKD_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('KETCZPSXKD'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('KETCZPSXKD'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('KETCZPSXKD'),e);
}
function ZPLLDHVTOQ_Valid(e) {
SetActiveField(Ctrl('ZPLLDHVTOQ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('userid','N',w_userid,HtW(Ctrl('ZPLLDHVTOQ').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_userid(HtW(Ctrl('ZPLLDHVTOQ').value,'N'),null,e);
return l_bSetResult;
}
}
function ZPLLDHVTOQ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ZPLLDHVTOQ'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('ZPLLDHVTOQ',w_userid,'N',9,0,'999999');
SetActiveField(Ctrl('ZPLLDHVTOQ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ZPLLDHVTOQ'),e);
}
function ZPLLDHVTOQ_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("999999"));
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function KETCZPSXKD_wrap_Valid(event) {
return KETCZPSXKD_Valid(event);
}
SPBOUILib.SetInputExit('KETCZPSXKD',KETCZPSXKD_wrap_Valid);
function KETCZPSXKD_wrap_OnFocus(event) {
return KETCZPSXKD_OnFocus(event);
}
SPBOUILib.SetInputEnter('KETCZPSXKD',KETCZPSXKD_wrap_OnFocus);
function KETCZPSXKD_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('KETCZPSXKD',KETCZPSXKD_wrap_OnKeyDown);
function ZPLLDHVTOQ_wrap_Valid(event) {
return ZPLLDHVTOQ_Valid(event);
}
SPBOUILib.SetInputExit('ZPLLDHVTOQ',ZPLLDHVTOQ_wrap_Valid);
function ZPLLDHVTOQ_wrap_OnFocus(event) {
return ZPLLDHVTOQ_OnFocus(event);
}
SPBOUILib.SetInputEnter('ZPLLDHVTOQ',ZPLLDHVTOQ_wrap_OnFocus);
function ZPLLDHVTOQ_wrap_OnKeyPress(event) {
return ZPLLDHVTOQ_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('ZPLLDHVTOQ',ZPLLDHVTOQ_wrap_OnKeyPress);
function ZPLLDHVTOQ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('ZPLLDHVTOQ',ZPLLDHVTOQ_wrap_OnKeyDown);
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
FocusFirstComponent.edit={"page_1":["ZPLLDHVTOQ"]};
FocusFirstComponent.query={"page_1":["KETCZPSXKD"]};
FocusFirstComponent.otherwise={"page_1":["KETCZPSXKD"]};
function Help() {
windowOpenForeground('../doc/spadministration_ssomap_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_ssoid=a[0];
w_userid=a[1];
m_PrimaryKeys=['ssoid'];
}
function i_PrimaryKey() {
return 'cpssomap'+'\\'+CPLib.ToCPStr(w_ssoid);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('spadministration_ssomap',m_cSelectedPage);
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
_Obli('ssoid',0,'KETCZPSXKD',false,"7014051")
_Obli('userid',1,'ZPLLDHVTOQ',false,"112233637")
