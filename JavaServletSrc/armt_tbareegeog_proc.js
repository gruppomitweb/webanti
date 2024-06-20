function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('ZMSHEZWRBV',function(){return WtH(w_CODICE,'C',5,0,'')},w_CODICE);
SPBOUILib.SetInputValue('KXHZQTKZSE',function(){return WtH(w_DESCRI,'C',50,0,'')},w_DESCRI);
SPBOUILib.SetInputValue('WPNPIZPKPB',function(){return WtH(w_RISCHIO,'N',3,0,'')},w_RISCHIO);
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
HideUI.lblids["CODICE"]=['QXIZLBHILH'];
HideUI.lblids["DESCRI"]=['OXUPGSDKLA'];
HideUI.lblids["RISCHIO"]=['TRTQZEAWPK'];
function ZMSHEZWRBV_Valid(e) {
SetActiveField(Ctrl('ZMSHEZWRBV'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('ZMSHEZWRBV') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('CODICE','C',w_CODICE,HtW(Ctrl('ZMSHEZWRBV').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODICE(HtW(Ctrl('ZMSHEZWRBV').value,'C'),null,e);
return l_bSetResult;
}
}
function ZMSHEZWRBV_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ZMSHEZWRBV'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('ZMSHEZWRBV'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ZMSHEZWRBV'),e);
}
function KXHZQTKZSE_Valid(e) {
SetActiveField(Ctrl('KXHZQTKZSE'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DESCRI','C',w_DESCRI,HtW(Ctrl('KXHZQTKZSE').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DESCRI(HtW(Ctrl('KXHZQTKZSE').value,'C'),null,e);
return l_bSetResult;
}
}
function KXHZQTKZSE_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('KXHZQTKZSE'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('KXHZQTKZSE'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('KXHZQTKZSE'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function ZMSHEZWRBV_wrap_Valid(event) {
return ZMSHEZWRBV_Valid(event);
}
SPBOUILib.SetInputExit('ZMSHEZWRBV',ZMSHEZWRBV_wrap_Valid);
function ZMSHEZWRBV_wrap_OnFocus(event) {
return ZMSHEZWRBV_OnFocus(event);
}
SPBOUILib.SetInputEnter('ZMSHEZWRBV',ZMSHEZWRBV_wrap_OnFocus);
function ZMSHEZWRBV_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('ZMSHEZWRBV',ZMSHEZWRBV_wrap_OnKeyDown);
function KXHZQTKZSE_wrap_Valid(event) {
return KXHZQTKZSE_Valid(event);
}
SPBOUILib.SetInputExit('KXHZQTKZSE',KXHZQTKZSE_wrap_Valid);
function KXHZQTKZSE_wrap_OnFocus(event) {
return KXHZQTKZSE_OnFocus(event);
}
SPBOUILib.SetInputEnter('KXHZQTKZSE',KXHZQTKZSE_wrap_OnFocus);
function KXHZQTKZSE_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('KXHZQTKZSE',KXHZQTKZSE_wrap_OnKeyDown);
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
FocusFirstComponent.edit={"page_1":["KXHZQTKZSE"]};
FocusFirstComponent.query={"page_1":["ZMSHEZWRBV"]};
FocusFirstComponent.otherwise={"page_1":["ZMSHEZWRBV"]};
function Help() {
windowOpenForeground('../doc/armt_tbareegeog_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_RISCHIO=a[2];
m_PrimaryKeys=['CODICE'];
}
function i_PrimaryKey() {
return 'tbareegeog'+'\\'+CPLib.ToCPStr(w_CODICE);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('armt_tbareegeog',m_cSelectedPage);
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
_Obli('CODICE',0,'ZMSHEZWRBV',false,"112851763")
_Obli('DESCRI',0,'KXHZQTKZSE',false,"285808099")
