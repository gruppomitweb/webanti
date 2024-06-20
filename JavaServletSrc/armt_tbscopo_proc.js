function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('LSJDHZTUBA',function(){return WtH(w_CODICE,'N',5,0,'99999')},w_CODICE);
SPBOUILib.SetInputValue('UYAZKPIGCA',function(){return WtH(w_DESCRI,'C',100,0,'')},w_DESCRI);
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
HideUI.lblids["CODICE"]=['JSSSYUZZGI'];
function LSJDHZTUBA_Valid(e) {
SetActiveField(Ctrl('LSJDHZTUBA'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('LSJDHZTUBA') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('CODICE','N',w_CODICE,HtW(Ctrl('LSJDHZTUBA').value,'N'),m_bQueryOnLatestKeyOnly);
}
}
}
function LSJDHZTUBA_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('LSJDHZTUBA'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('LSJDHZTUBA',w_CODICE,'N',5,0,'99999');
SetActiveField(Ctrl('LSJDHZTUBA'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('LSJDHZTUBA'),e);
}
function LSJDHZTUBA_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("99999"));
}
function UYAZKPIGCA_Valid(e) {
SetActiveField(Ctrl('UYAZKPIGCA'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DESCRI','C',w_DESCRI,HtW(Ctrl('UYAZKPIGCA').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DESCRI(HtW(Ctrl('UYAZKPIGCA').value,'C'),null,e);
return l_bSetResult;
}
}
function UYAZKPIGCA_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('UYAZKPIGCA'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('UYAZKPIGCA'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('UYAZKPIGCA'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function LSJDHZTUBA_wrap_Valid(event) {
return LSJDHZTUBA_Valid(event);
}
SPBOUILib.SetInputExit('LSJDHZTUBA',LSJDHZTUBA_wrap_Valid);
function LSJDHZTUBA_wrap_OnFocus(event) {
return LSJDHZTUBA_OnFocus(event);
}
SPBOUILib.SetInputEnter('LSJDHZTUBA',LSJDHZTUBA_wrap_OnFocus);
function LSJDHZTUBA_wrap_OnKeyPress(event) {
return LSJDHZTUBA_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('LSJDHZTUBA',LSJDHZTUBA_wrap_OnKeyPress);
function LSJDHZTUBA_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('LSJDHZTUBA',LSJDHZTUBA_wrap_OnKeyDown);
function UYAZKPIGCA_wrap_Valid(event) {
return UYAZKPIGCA_Valid(event);
}
SPBOUILib.SetInputExit('UYAZKPIGCA',UYAZKPIGCA_wrap_Valid);
function UYAZKPIGCA_wrap_OnFocus(event) {
return UYAZKPIGCA_OnFocus(event);
}
SPBOUILib.SetInputEnter('UYAZKPIGCA',UYAZKPIGCA_wrap_OnFocus);
function UYAZKPIGCA_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('UYAZKPIGCA',UYAZKPIGCA_wrap_OnKeyDown);
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
FocusFirstComponent.edit={"page_1":["UYAZKPIGCA"]};
FocusFirstComponent.query={"page_1":["LSJDHZTUBA","UYAZKPIGCA"]};
FocusFirstComponent.otherwise={"page_1":["UYAZKPIGCA"]};
function Help() {
windowOpenForeground('../doc/armt_tbscopo_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
return 'tbscopo'+'\\'+CPLib.ToCPStr(w_CODICE);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('armt_tbscopo',m_cSelectedPage);
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
_Obli('DESCRI',0,'UYAZKPIGCA',false)
