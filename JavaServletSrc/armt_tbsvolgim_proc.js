function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('QAYKOOSYVY',function(){return WtH(w_CODICE,'C',5,0,'')},w_CODICE);
SPBOUILib.SetInputValue('EHCXVAOPQZ',function(){return WtH(w_DESCRI,'C',200,0,'')},w_DESCRI);
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
HideUI.lblids["CODICE"]=['MOTSAXCFKX'];
HideUI.lblids["DESCRI"]=['SVRJFVKKIC'];
HideUI.lblids["RISCHIO"]=['TRTQZEAWPK'];
function QAYKOOSYVY_Valid(e) {
SetActiveField(Ctrl('QAYKOOSYVY'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('QAYKOOSYVY') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('CODICE','C',w_CODICE,HtW(Ctrl('QAYKOOSYVY').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODICE(HtW(Ctrl('QAYKOOSYVY').value,'C'),null,e);
return l_bSetResult;
}
}
function QAYKOOSYVY_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('QAYKOOSYVY'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('QAYKOOSYVY'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('QAYKOOSYVY'),e);
}
function EHCXVAOPQZ_Valid(e) {
SetActiveField(Ctrl('EHCXVAOPQZ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DESCRI','C',w_DESCRI,HtW(Ctrl('EHCXVAOPQZ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DESCRI(HtW(Ctrl('EHCXVAOPQZ').value,'C'),null,e);
return l_bSetResult;
}
}
function EHCXVAOPQZ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('EHCXVAOPQZ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('EHCXVAOPQZ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('EHCXVAOPQZ'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function QAYKOOSYVY_wrap_Valid(event) {
return QAYKOOSYVY_Valid(event);
}
SPBOUILib.SetInputExit('QAYKOOSYVY',QAYKOOSYVY_wrap_Valid);
function QAYKOOSYVY_wrap_OnFocus(event) {
return QAYKOOSYVY_OnFocus(event);
}
SPBOUILib.SetInputEnter('QAYKOOSYVY',QAYKOOSYVY_wrap_OnFocus);
function QAYKOOSYVY_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('QAYKOOSYVY',QAYKOOSYVY_wrap_OnKeyDown);
function EHCXVAOPQZ_wrap_Valid(event) {
return EHCXVAOPQZ_Valid(event);
}
SPBOUILib.SetInputExit('EHCXVAOPQZ',EHCXVAOPQZ_wrap_Valid);
function EHCXVAOPQZ_wrap_OnFocus(event) {
return EHCXVAOPQZ_OnFocus(event);
}
SPBOUILib.SetInputEnter('EHCXVAOPQZ',EHCXVAOPQZ_wrap_OnFocus);
function EHCXVAOPQZ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('EHCXVAOPQZ',EHCXVAOPQZ_wrap_OnKeyDown);
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
FocusFirstComponent.edit={"page_1":["EHCXVAOPQZ"]};
FocusFirstComponent.query={"page_1":["QAYKOOSYVY"]};
FocusFirstComponent.otherwise={"page_1":["QAYKOOSYVY"]};
function Help() {
windowOpenForeground('../doc/armt_tbsvolgim_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
return 'tbsvolgim'+'\\'+CPLib.ToCPStr(w_CODICE);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('armt_tbsvolgim',m_cSelectedPage);
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
_Obli('CODICE',0,'QAYKOOSYVY',false,"112851763")
_Obli('DESCRI',0,'EHCXVAOPQZ',false,"285808099")
