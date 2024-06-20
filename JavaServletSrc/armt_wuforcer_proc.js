function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('FURCXEJBAK',function(){return WtH(w_FRCODICE,'C',3,0,'')},w_FRCODICE);
SPBOUILib.SetInputValue('NJXKLQSDAQ',function(){return WtH(w_FRDESCRI,'C',70,0,'')},w_FRDESCRI);
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
HideUI.lblids["FRCODICE"]=['AGMNHVUTIN'];
HideUI.lblids["FRDESCRI"]=['GWSEHHVYON'];
function FURCXEJBAK_Valid(e) {
SetActiveField(Ctrl('FURCXEJBAK'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('FURCXEJBAK') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('FRCODICE','C',w_FRCODICE,HtW(Ctrl('FURCXEJBAK').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FRCODICE(HtW(Ctrl('FURCXEJBAK').value,'C'),null,e);
return l_bSetResult;
}
}
function FURCXEJBAK_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('FURCXEJBAK'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('FURCXEJBAK'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('FURCXEJBAK'),e);
}
function NJXKLQSDAQ_Valid(e) {
SetActiveField(Ctrl('NJXKLQSDAQ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('FRDESCRI','C',w_FRDESCRI,HtW(Ctrl('NJXKLQSDAQ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FRDESCRI(HtW(Ctrl('NJXKLQSDAQ').value,'C'),null,e);
return l_bSetResult;
}
}
function NJXKLQSDAQ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('NJXKLQSDAQ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('NJXKLQSDAQ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('NJXKLQSDAQ'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function FURCXEJBAK_wrap_Valid(event) {
return FURCXEJBAK_Valid(event);
}
SPBOUILib.SetInputExit('FURCXEJBAK',FURCXEJBAK_wrap_Valid);
function FURCXEJBAK_wrap_OnFocus(event) {
return FURCXEJBAK_OnFocus(event);
}
SPBOUILib.SetInputEnter('FURCXEJBAK',FURCXEJBAK_wrap_OnFocus);
function FURCXEJBAK_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('FURCXEJBAK',FURCXEJBAK_wrap_OnKeyDown);
function NJXKLQSDAQ_wrap_Valid(event) {
return NJXKLQSDAQ_Valid(event);
}
SPBOUILib.SetInputExit('NJXKLQSDAQ',NJXKLQSDAQ_wrap_Valid);
function NJXKLQSDAQ_wrap_OnFocus(event) {
return NJXKLQSDAQ_OnFocus(event);
}
SPBOUILib.SetInputEnter('NJXKLQSDAQ',NJXKLQSDAQ_wrap_OnFocus);
function NJXKLQSDAQ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('NJXKLQSDAQ',NJXKLQSDAQ_wrap_OnKeyDown);
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
FocusFirstComponent.edit={"page_1":["NJXKLQSDAQ"]};
FocusFirstComponent.query={"page_1":["FURCXEJBAK"]};
FocusFirstComponent.otherwise={"page_1":["FURCXEJBAK"]};
function Help() {
windowOpenForeground('../doc/armt_wuforcer_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_FRCODICE=a[0];
w_FRDESCRI=a[1];
m_PrimaryKeys=['FRCODICE'];
}
function i_PrimaryKey() {
return 'wuforcer'+'\\'+CPLib.ToCPStr(w_FRCODICE);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('armt_wuforcer',m_cSelectedPage);
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
_Obli('FRCODICE',0,'FURCXEJBAK',false,"112851763")
_Obli('FRDESCRI',0,'NJXKLQSDAQ',false,"277706636")
