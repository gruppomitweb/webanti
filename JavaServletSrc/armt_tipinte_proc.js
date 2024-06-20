function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('ATUKAEMOXS',function(){return WtH(w_TIPOINT,'C',2,0,'')},w_TIPOINT);
SPBOUILib.SetInputValue('AGFEVDQPRB',function(){return WtH(w_DESCRI,'C',80,0,'')},w_DESCRI);
if (m_bExtended) {
SetExtensions();
}
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay('YORQOIOBQN_DIV',IsHiddenByStateDriver('box_YORQOIOBQN'));
LibJavascript.forEachItem(m_FoundlingHideExpression,i_body_2)
function i_body_2(child){
child();
}
HideUI();
}
HideUI.lblids["DESCRI"]=['XMQJYACWNZ'];
HideUI.lblids["TIPOINT"]=['FRAEYCHYNB'];
function ATUKAEMOXS_Valid(e) {
SetActiveField(Ctrl('ATUKAEMOXS'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('ATUKAEMOXS') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('TIPOINT','C',w_TIPOINT,HtW(Ctrl('ATUKAEMOXS').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TIPOINT(HtW(Ctrl('ATUKAEMOXS').value,'C'),null,e);
return l_bSetResult;
}
}
function ATUKAEMOXS_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ATUKAEMOXS'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('ATUKAEMOXS'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ATUKAEMOXS'),e);
}
function AGFEVDQPRB_Valid(e) {
SetActiveField(Ctrl('AGFEVDQPRB'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DESCRI','C',w_DESCRI,HtW(Ctrl('AGFEVDQPRB').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DESCRI(HtW(Ctrl('AGFEVDQPRB').value,'C'),null,e);
return l_bSetResult;
}
}
function AGFEVDQPRB_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('AGFEVDQPRB'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('AGFEVDQPRB'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('AGFEVDQPRB'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function ATUKAEMOXS_wrap_Valid(event) {
return ATUKAEMOXS_Valid(event);
}
SPBOUILib.SetInputExit('ATUKAEMOXS',ATUKAEMOXS_wrap_Valid);
function ATUKAEMOXS_wrap_OnFocus(event) {
return ATUKAEMOXS_OnFocus(event);
}
SPBOUILib.SetInputEnter('ATUKAEMOXS',ATUKAEMOXS_wrap_OnFocus);
function ATUKAEMOXS_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('ATUKAEMOXS',ATUKAEMOXS_wrap_OnKeyDown);
function AGFEVDQPRB_wrap_Valid(event) {
return AGFEVDQPRB_Valid(event);
}
SPBOUILib.SetInputExit('AGFEVDQPRB',AGFEVDQPRB_wrap_Valid);
function AGFEVDQPRB_wrap_OnFocus(event) {
return AGFEVDQPRB_OnFocus(event);
}
SPBOUILib.SetInputEnter('AGFEVDQPRB',AGFEVDQPRB_wrap_OnFocus);
function AGFEVDQPRB_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('AGFEVDQPRB',AGFEVDQPRB_wrap_OnKeyDown);
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
FocusFirstComponent.edit={"page_1":["AGFEVDQPRB"]};
FocusFirstComponent.query={"page_1":["ATUKAEMOXS"]};
FocusFirstComponent.otherwise={"page_1":["ATUKAEMOXS"]};
function Help() {
windowOpenForeground('../doc/armt_tipinte_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_TIPOINT=a[0];
w_DESCRI=a[1];
m_PrimaryKeys=['TIPOINT'];
}
function i_PrimaryKey() {
return 'tbtipint'+'\\'+CPLib.ToCPStr(w_TIPOINT);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('armt_tipinte',m_cSelectedPage);
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
_Obli('TIPOINT',0,'ATUKAEMOXS',false,"112851763")
_Obli('DESCRI',0,'AGFEVDQPRB',false,"285808099")
