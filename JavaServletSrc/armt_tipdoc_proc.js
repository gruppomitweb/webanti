function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('UZYCBNGKAF',function(){return WtH(w_TIPDOC,'C',2,0,'')},w_TIPDOC);
SPBOUILib.SetInputValue('LQAMKFKRGQ',function(){return WtH(w_DESCRI,'C',30,0,'')},w_DESCRI);
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
HideUI.lblids["DESCRI"]=['PHRWRIONIJ'];
HideUI.lblids["TIPDOC"]=['WHIORQWGET'];
function UZYCBNGKAF_Valid(e) {
SetActiveField(Ctrl('UZYCBNGKAF'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('UZYCBNGKAF') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('TIPDOC','C',w_TIPDOC,HtW(Ctrl('UZYCBNGKAF').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TIPDOC(HtW(Ctrl('UZYCBNGKAF').value,'C'),null,e);
return l_bSetResult;
}
}
function UZYCBNGKAF_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('UZYCBNGKAF'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('UZYCBNGKAF'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('UZYCBNGKAF'),e);
}
function LQAMKFKRGQ_Valid(e) {
SetActiveField(Ctrl('LQAMKFKRGQ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DESCRI','C',w_DESCRI,HtW(Ctrl('LQAMKFKRGQ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DESCRI(HtW(Ctrl('LQAMKFKRGQ').value,'C'),null,e);
return l_bSetResult;
}
}
function LQAMKFKRGQ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('LQAMKFKRGQ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('LQAMKFKRGQ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('LQAMKFKRGQ'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function UZYCBNGKAF_wrap_Valid(event) {
return UZYCBNGKAF_Valid(event);
}
SPBOUILib.SetInputExit('UZYCBNGKAF',UZYCBNGKAF_wrap_Valid);
function UZYCBNGKAF_wrap_OnFocus(event) {
return UZYCBNGKAF_OnFocus(event);
}
SPBOUILib.SetInputEnter('UZYCBNGKAF',UZYCBNGKAF_wrap_OnFocus);
function UZYCBNGKAF_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('UZYCBNGKAF',UZYCBNGKAF_wrap_OnKeyDown);
function LQAMKFKRGQ_wrap_Valid(event) {
return LQAMKFKRGQ_Valid(event);
}
SPBOUILib.SetInputExit('LQAMKFKRGQ',LQAMKFKRGQ_wrap_Valid);
function LQAMKFKRGQ_wrap_OnFocus(event) {
return LQAMKFKRGQ_OnFocus(event);
}
SPBOUILib.SetInputEnter('LQAMKFKRGQ',LQAMKFKRGQ_wrap_OnFocus);
function LQAMKFKRGQ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('LQAMKFKRGQ',LQAMKFKRGQ_wrap_OnKeyDown);
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
FocusFirstComponent.edit={"page_1":["LQAMKFKRGQ"]};
FocusFirstComponent.query={"page_1":["UZYCBNGKAF"]};
FocusFirstComponent.otherwise={"page_1":["UZYCBNGKAF"]};
function Help() {
windowOpenForeground('../doc/armt_tipdoc_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_TIPDOC=a[0];
w_DESCRI=a[1];
m_PrimaryKeys=['TIPDOC'];
}
function i_PrimaryKey() {
return 'tbtipdoc'+'\\'+CPLib.ToCPStr(w_TIPDOC);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('armt_tipdoc',m_cSelectedPage);
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
_Obli('TIPDOC',0,'UZYCBNGKAF',false,"112851763")
_Obli('DESCRI',0,'LQAMKFKRGQ',false,"285808099")
