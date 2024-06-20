function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('VBSBVXAQLN',function(){return WtH(w_IDBASE,'C',10,0,'')},w_IDBASE);
SPBOUILib.SetInputValue('RYTTPEIMOU',function(){return WtH(w_ANNO,'C',4,0,'')},w_ANNO);
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
HideUI.lblids["ANNO"]=['XMAAHZONAV'];
HideUI.lblids["IDBASE"]=['UTETGYAROG'];
function VBSBVXAQLN_Valid(e) {
SetActiveField(Ctrl('VBSBVXAQLN'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('VBSBVXAQLN') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('IDBASE','C',w_IDBASE,HtW(Ctrl('VBSBVXAQLN').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IDBASE(HtW(Ctrl('VBSBVXAQLN').value,'C'),null,e);
return l_bSetResult;
}
}
function VBSBVXAQLN_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('VBSBVXAQLN'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('VBSBVXAQLN'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('VBSBVXAQLN'),e);
}
function RYTTPEIMOU_Valid(e) {
SetActiveField(Ctrl('RYTTPEIMOU'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('ANNO','C',w_ANNO,HtW(Ctrl('RYTTPEIMOU').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ANNO(HtW(Ctrl('RYTTPEIMOU').value,'C'),null,e);
return l_bSetResult;
}
}
function RYTTPEIMOU_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('RYTTPEIMOU'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('RYTTPEIMOU'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('RYTTPEIMOU'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function VBSBVXAQLN_wrap_Valid(event) {
return VBSBVXAQLN_Valid(event);
}
SPBOUILib.SetInputExit('VBSBVXAQLN',VBSBVXAQLN_wrap_Valid);
function VBSBVXAQLN_wrap_OnFocus(event) {
return VBSBVXAQLN_OnFocus(event);
}
SPBOUILib.SetInputEnter('VBSBVXAQLN',VBSBVXAQLN_wrap_OnFocus);
function VBSBVXAQLN_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('VBSBVXAQLN',VBSBVXAQLN_wrap_OnKeyDown);
function RYTTPEIMOU_wrap_Valid(event) {
return RYTTPEIMOU_Valid(event);
}
SPBOUILib.SetInputExit('RYTTPEIMOU',RYTTPEIMOU_wrap_Valid);
function RYTTPEIMOU_wrap_OnFocus(event) {
return RYTTPEIMOU_OnFocus(event);
}
SPBOUILib.SetInputEnter('RYTTPEIMOU',RYTTPEIMOU_wrap_OnFocus);
function RYTTPEIMOU_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('RYTTPEIMOU',RYTTPEIMOU_wrap_OnKeyDown);
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
FocusFirstComponent.edit={"page_1":["RYTTPEIMOU"]};
FocusFirstComponent.query={"page_1":["VBSBVXAQLN"]};
FocusFirstComponent.otherwise={"page_1":["VBSBVXAQLN"]};
function Help() {
windowOpenForeground('../doc/armt_amlanno_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_IDBASE=a[0];
w_ANNO=a[1];
m_PrimaryKeys=['IDBASE'];
}
function i_PrimaryKey() {
return 'amlanno'+'\\'+CPLib.ToCPStr(w_IDBASE);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('armt_amlanno',m_cSelectedPage);
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
_Obli('IDBASE',0,'VBSBVXAQLN',false,"78075529")
_Obli('ANNO',0,'RYTTPEIMOU',false,"863017137")
