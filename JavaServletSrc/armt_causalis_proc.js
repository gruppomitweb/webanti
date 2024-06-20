function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('CDCDVNOEKS',function(){return WtH(w_CODVOC,'C',2,0,'')},w_CODVOC);
SPBOUILib.SetInputValue('SBAKLFGRFP',function(){return WtH(w_DESCRIZ,'C',165,0,'')},w_DESCRIZ);
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
HideUI.lblids["CODVOC"]=['PJLRPBVPOY'];
HideUI.lblids["DESCRIZ"]=['ARFDESCSGN'];
function CDCDVNOEKS_Valid(e) {
SetActiveField(Ctrl('CDCDVNOEKS'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('CDCDVNOEKS') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('CODVOC','C',w_CODVOC,HtW(Ctrl('CDCDVNOEKS').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODVOC(HtW(Ctrl('CDCDVNOEKS').value,'C'),null,e);
return l_bSetResult;
}
}
function CDCDVNOEKS_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('CDCDVNOEKS'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('CDCDVNOEKS'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('CDCDVNOEKS'),e);
}
function SBAKLFGRFP_Valid(e) {
SetActiveField(Ctrl('SBAKLFGRFP'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DESCRIZ','C',w_DESCRIZ,HtW(Ctrl('SBAKLFGRFP').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DESCRIZ(HtW(Ctrl('SBAKLFGRFP').value,'C'),null,e);
return l_bSetResult;
}
}
function SBAKLFGRFP_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('SBAKLFGRFP'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('SBAKLFGRFP'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('SBAKLFGRFP'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function CDCDVNOEKS_wrap_Valid(event) {
return CDCDVNOEKS_Valid(event);
}
SPBOUILib.SetInputExit('CDCDVNOEKS',CDCDVNOEKS_wrap_Valid);
function CDCDVNOEKS_wrap_OnFocus(event) {
return CDCDVNOEKS_OnFocus(event);
}
SPBOUILib.SetInputEnter('CDCDVNOEKS',CDCDVNOEKS_wrap_OnFocus);
function CDCDVNOEKS_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('CDCDVNOEKS',CDCDVNOEKS_wrap_OnKeyDown);
function SBAKLFGRFP_wrap_Valid(event) {
return SBAKLFGRFP_Valid(event);
}
SPBOUILib.SetInputExit('SBAKLFGRFP',SBAKLFGRFP_wrap_Valid);
function SBAKLFGRFP_wrap_OnFocus(event) {
return SBAKLFGRFP_OnFocus(event);
}
SPBOUILib.SetInputEnter('SBAKLFGRFP',SBAKLFGRFP_wrap_OnFocus);
function SBAKLFGRFP_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('SBAKLFGRFP',SBAKLFGRFP_wrap_OnKeyDown);
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
FocusFirstComponent.edit={"page_1":["SBAKLFGRFP"]};
FocusFirstComponent.query={"page_1":["CDCDVNOEKS"]};
FocusFirstComponent.otherwise={"page_1":["CDCDVNOEKS"]};
function Help() {
windowOpenForeground('../doc/armt_causalis_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_CODVOC=a[0];
w_DESCRIZ=a[1];
m_PrimaryKeys=['CODVOC'];
}
function i_PrimaryKey() {
return 'tbcausin'+'\\'+CPLib.ToCPStr(w_CODVOC);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('armt_causalis',m_cSelectedPage);
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
_Obli('CODVOC',0,'CDCDVNOEKS',false,"112851763")
_Obli('DESCRIZ',0,'SBAKLFGRFP',false,"285808099")
