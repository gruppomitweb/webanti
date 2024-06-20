function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('BKNNIQVWMR',function(){return WtH(w_autonum,'N',15,0,'9999999999')},w_autonum);
SPBOUILib.SetInputValue('WCYGSFGYKH',function(){return WtH(w_autonum_name,'C',60,0,'')},w_autonum_name);
if (m_bExtended) {
SetExtensions();
}
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay(Ctrl('WWBIIEYXAF'),true);
SetDisplay(Ctrl('HRVYPVSWPC'),true);
LibJavascript.forEachItem(m_FoundlingHideExpression,i_body_2)
function i_body_2(child){
child();
}
HideUI();
}
HideUI.lblids["autonum"]=['DXYOJIRSOV'];
HideUI.lblids["autonum_name"]=['ALEDLKZNJJ'];
HideUI.lblids["tablecode"]=['WWBIIEYXAF'];
HideUI.lblids["warncode"]=['HRVYPVSWPC'];
function BKNNIQVWMR_Valid(e) {
SetActiveField(Ctrl('BKNNIQVWMR'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('autonum','N',w_autonum,HtW(Ctrl('BKNNIQVWMR').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_autonum(HtW(Ctrl('BKNNIQVWMR').value,'N'),null,e);
return l_bSetResult;
}
}
function BKNNIQVWMR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('BKNNIQVWMR'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('BKNNIQVWMR',w_autonum,'N',15,0,'9999999999');
SetActiveField(Ctrl('BKNNIQVWMR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('BKNNIQVWMR'),e);
}
function BKNNIQVWMR_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("9999999999"));
}
function WCYGSFGYKH_Valid(e) {
SetActiveField(Ctrl('WCYGSFGYKH'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('autonum_name','C',w_autonum_name,HtW(Ctrl('WCYGSFGYKH').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_autonum_name(HtW(Ctrl('WCYGSFGYKH').value,'C'),null,e);
return l_bSetResult;
}
}
function WCYGSFGYKH_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('WCYGSFGYKH'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('WCYGSFGYKH'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('WCYGSFGYKH'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function BKNNIQVWMR_wrap_Valid(event) {
return BKNNIQVWMR_Valid(event);
}
SPBOUILib.SetInputExit('BKNNIQVWMR',BKNNIQVWMR_wrap_Valid);
function BKNNIQVWMR_wrap_OnFocus(event) {
return BKNNIQVWMR_OnFocus(event);
}
SPBOUILib.SetInputEnter('BKNNIQVWMR',BKNNIQVWMR_wrap_OnFocus);
function BKNNIQVWMR_wrap_OnKeyPress(event) {
return BKNNIQVWMR_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('BKNNIQVWMR',BKNNIQVWMR_wrap_OnKeyPress);
function BKNNIQVWMR_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('BKNNIQVWMR',BKNNIQVWMR_wrap_OnKeyDown);
function WCYGSFGYKH_wrap_Valid(event) {
return WCYGSFGYKH_Valid(event);
}
SPBOUILib.SetInputExit('WCYGSFGYKH',WCYGSFGYKH_wrap_Valid);
function WCYGSFGYKH_wrap_OnFocus(event) {
return WCYGSFGYKH_OnFocus(event);
}
SPBOUILib.SetInputEnter('WCYGSFGYKH',WCYGSFGYKH_wrap_OnFocus);
function WCYGSFGYKH_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('WCYGSFGYKH',WCYGSFGYKH_wrap_OnKeyDown);
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
FocusFirstComponent.edit={"page_1":["BKNNIQVWMR"]};
FocusFirstComponent.query={"page_1":["BKNNIQVWMR"]};
FocusFirstComponent.otherwise={"page_1":["BKNNIQVWMR"]};
function Help() {
windowOpenForeground('../doc/spadministration_autonum_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_tablecode=a[0];
w_warncode=a[1];
w_autonum=a[2];
w_autonum_name=a[3];
m_PrimaryKeys=['warncode','tablecode'];
}
function i_PrimaryKey() {
return 'cpwarn'+'\\'+CPLib.ToCPStr(w_tablecode)+'\\'+CPLib.ToCPStr(w_warncode);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('spadministration_autonum',m_cSelectedPage);
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
_Obli('autonum_name',0,'WCYGSFGYKH',false,"10075134622")
_Obli('autonum',1,'BKNNIQVWMR',false,"11751808827")
