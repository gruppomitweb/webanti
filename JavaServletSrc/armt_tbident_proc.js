function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('JNWKSQPZVP',function(){return WtH(w_CODICE,'C',3,0,'')},w_CODICE);
SPBOUILib.SetInputValue('PHBOXAVQRA',function(){return WtH(w_DESCRI,'C',150,0,'')},w_DESCRI);
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
HideUI.lblids["CODICE"]=['FLMEFOQAZY'];
HideUI.lblids["DESCRI"]=['VTJQPWEBOO'];
function JNWKSQPZVP_Valid(e) {
SetActiveField(Ctrl('JNWKSQPZVP'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('JNWKSQPZVP') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('CODICE','C',w_CODICE,HtW(Ctrl('JNWKSQPZVP').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODICE(HtW(Ctrl('JNWKSQPZVP').value,'C'),null,e);
return l_bSetResult;
}
}
function JNWKSQPZVP_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('JNWKSQPZVP'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('JNWKSQPZVP'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('JNWKSQPZVP'),e);
}
function PHBOXAVQRA_Valid(e) {
SetActiveField(Ctrl('PHBOXAVQRA'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DESCRI','C',w_DESCRI,HtW(Ctrl('PHBOXAVQRA').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DESCRI(HtW(Ctrl('PHBOXAVQRA').value,'C'),null,e);
return l_bSetResult;
}
}
function PHBOXAVQRA_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('PHBOXAVQRA'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('PHBOXAVQRA'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('PHBOXAVQRA'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function JNWKSQPZVP_wrap_Valid(event) {
return JNWKSQPZVP_Valid(event);
}
SPBOUILib.SetInputExit('JNWKSQPZVP',JNWKSQPZVP_wrap_Valid);
function JNWKSQPZVP_wrap_OnFocus(event) {
return JNWKSQPZVP_OnFocus(event);
}
SPBOUILib.SetInputEnter('JNWKSQPZVP',JNWKSQPZVP_wrap_OnFocus);
function JNWKSQPZVP_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('JNWKSQPZVP',JNWKSQPZVP_wrap_OnKeyDown);
function PHBOXAVQRA_wrap_Valid(event) {
return PHBOXAVQRA_Valid(event);
}
SPBOUILib.SetInputExit('PHBOXAVQRA',PHBOXAVQRA_wrap_Valid);
function PHBOXAVQRA_wrap_OnFocus(event) {
return PHBOXAVQRA_OnFocus(event);
}
SPBOUILib.SetInputEnter('PHBOXAVQRA',PHBOXAVQRA_wrap_OnFocus);
function PHBOXAVQRA_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('PHBOXAVQRA',PHBOXAVQRA_wrap_OnKeyDown);
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
FocusFirstComponent.edit={"page_1":["PHBOXAVQRA"]};
FocusFirstComponent.query={"page_1":["JNWKSQPZVP"]};
FocusFirstComponent.otherwise={"page_1":["JNWKSQPZVP"]};
function Help() {
windowOpenForeground('../doc/armt_tbident_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_DESCRI=a[1];
m_PrimaryKeys=['CODICE'];
}
function i_PrimaryKey() {
return 'tbident'+'\\'+CPLib.ToCPStr(w_CODICE);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('armt_tbident',m_cSelectedPage);
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
_Obli('CODICE',0,'JNWKSQPZVP',false,"112851763")
_Obli('DESCRI',0,'PHBOXAVQRA',false,"285808099")
