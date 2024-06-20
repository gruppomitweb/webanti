function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('TNOGQPIWSU',function(){return WtH(w_CODICE,'C',3,0,'')},w_CODICE);
SPBOUILib.SetInputValue('BGMMOQKKPH',function(){return WtH(w_DESCRI,'C',100,0,'')},w_DESCRI);
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
HideUI.lblids["CODICE"]=['OTJOMZNBJG'];
HideUI.lblids["DESCRI"]=['QKTFSMGQWL'];
HideUI.lblids["RISCHIO"]=['TRTQZEAWPK'];
function TNOGQPIWSU_Valid(e) {
SetActiveField(Ctrl('TNOGQPIWSU'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('TNOGQPIWSU') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('CODICE','C',w_CODICE,HtW(Ctrl('TNOGQPIWSU').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODICE(HtW(Ctrl('TNOGQPIWSU').value,'C'),null,e);
return l_bSetResult;
}
}
function TNOGQPIWSU_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('TNOGQPIWSU'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('TNOGQPIWSU'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('TNOGQPIWSU'),e);
}
function BGMMOQKKPH_Valid(e) {
SetActiveField(Ctrl('BGMMOQKKPH'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DESCRI','C',w_DESCRI,HtW(Ctrl('BGMMOQKKPH').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DESCRI(HtW(Ctrl('BGMMOQKKPH').value,'C'),null,e);
return l_bSetResult;
}
}
function BGMMOQKKPH_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('BGMMOQKKPH'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('BGMMOQKKPH'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('BGMMOQKKPH'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function TNOGQPIWSU_wrap_Valid(event) {
return TNOGQPIWSU_Valid(event);
}
SPBOUILib.SetInputExit('TNOGQPIWSU',TNOGQPIWSU_wrap_Valid);
function TNOGQPIWSU_wrap_OnFocus(event) {
return TNOGQPIWSU_OnFocus(event);
}
SPBOUILib.SetInputEnter('TNOGQPIWSU',TNOGQPIWSU_wrap_OnFocus);
function TNOGQPIWSU_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('TNOGQPIWSU',TNOGQPIWSU_wrap_OnKeyDown);
function BGMMOQKKPH_wrap_Valid(event) {
return BGMMOQKKPH_Valid(event);
}
SPBOUILib.SetInputExit('BGMMOQKKPH',BGMMOQKKPH_wrap_Valid);
function BGMMOQKKPH_wrap_OnFocus(event) {
return BGMMOQKKPH_OnFocus(event);
}
SPBOUILib.SetInputEnter('BGMMOQKKPH',BGMMOQKKPH_wrap_OnFocus);
function BGMMOQKKPH_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('BGMMOQKKPH',BGMMOQKKPH_wrap_OnKeyDown);
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
FocusFirstComponent.edit={"page_1":["BGMMOQKKPH"]};
FocusFirstComponent.query={"page_1":["TNOGQPIWSU"]};
FocusFirstComponent.otherwise={"page_1":["TNOGQPIWSU"]};
function Help() {
windowOpenForeground('../doc/armt_tbtiporisc_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
return 'tbtiporisc'+'\\'+CPLib.ToCPStr(w_CODICE);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('armt_tbtiporisc',m_cSelectedPage);
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
_Obli('CODICE',0,'TNOGQPIWSU',false,"112851763")
_Obli('DESCRI',0,'BGMMOQKKPH',false,"285808099")
