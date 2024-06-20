function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('HGAXRLVKSP',function(){return WtH(w_RAMGRU,'C',3,0,'')},w_RAMGRU);
SPBOUILib.SetInputValue('IGZNNVTZCL',function(){return WtH(w_DESCRI,'C',70,0,'')},w_DESCRI);
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
HideUI.lblids["DESCRI"]=['XURVANIYSD'];
HideUI.lblids["RAMGRU"]=['SSCFLXWIVE'];
function HGAXRLVKSP_Valid(e) {
SetActiveField(Ctrl('HGAXRLVKSP'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('HGAXRLVKSP') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('RAMGRU','C',w_RAMGRU,HtW(Ctrl('HGAXRLVKSP').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_RAMGRU(HtW(Ctrl('HGAXRLVKSP').value,'C'),null,e);
return l_bSetResult;
}
}
function HGAXRLVKSP_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('HGAXRLVKSP'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('HGAXRLVKSP'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('HGAXRLVKSP'),e);
}
function IGZNNVTZCL_Valid(e) {
SetActiveField(Ctrl('IGZNNVTZCL'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DESCRI','C',w_DESCRI,HtW(Ctrl('IGZNNVTZCL').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DESCRI(HtW(Ctrl('IGZNNVTZCL').value,'C'),null,e);
return l_bSetResult;
}
}
function IGZNNVTZCL_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('IGZNNVTZCL'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('IGZNNVTZCL'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('IGZNNVTZCL'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function HGAXRLVKSP_wrap_Valid(event) {
return HGAXRLVKSP_Valid(event);
}
SPBOUILib.SetInputExit('HGAXRLVKSP',HGAXRLVKSP_wrap_Valid);
function HGAXRLVKSP_wrap_OnFocus(event) {
return HGAXRLVKSP_OnFocus(event);
}
SPBOUILib.SetInputEnter('HGAXRLVKSP',HGAXRLVKSP_wrap_OnFocus);
function HGAXRLVKSP_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('HGAXRLVKSP',HGAXRLVKSP_wrap_OnKeyDown);
function IGZNNVTZCL_wrap_Valid(event) {
return IGZNNVTZCL_Valid(event);
}
SPBOUILib.SetInputExit('IGZNNVTZCL',IGZNNVTZCL_wrap_Valid);
function IGZNNVTZCL_wrap_OnFocus(event) {
return IGZNNVTZCL_OnFocus(event);
}
SPBOUILib.SetInputEnter('IGZNNVTZCL',IGZNNVTZCL_wrap_OnFocus);
function IGZNNVTZCL_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('IGZNNVTZCL',IGZNNVTZCL_wrap_OnKeyDown);
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
FocusFirstComponent.edit={"page_1":["IGZNNVTZCL"]};
FocusFirstComponent.query={"page_1":["HGAXRLVKSP"]};
FocusFirstComponent.otherwise={"page_1":["HGAXRLVKSP"]};
function Help() {
windowOpenForeground('../doc/armt_ramogruppo_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_RAMGRU=a[0];
w_DESCRI=a[1];
m_PrimaryKeys=['RAMGRU'];
}
function i_PrimaryKey() {
return 'tbramgru'+'\\'+CPLib.ToCPStr(w_RAMGRU);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('armt_ramogruppo',m_cSelectedPage);
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
_Obli('RAMGRU',0,'HGAXRLVKSP',false,"112851763")
_Obli('DESCRI',0,'IGZNNVTZCL',false,"285808099")
