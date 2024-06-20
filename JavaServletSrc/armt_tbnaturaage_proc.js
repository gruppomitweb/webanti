function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('NJXTDVWJFG',function(){return WtH(w_CODICE,'C',2,0,'')},w_CODICE);
SPBOUILib.SetInputValue('BSZSUVSKNS',function(){return WtH(w_DESCRI,'C',100,0,'')},w_DESCRI);
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
HideUI.lblids["CODICE"]=['QRMXWDHUWA'];
HideUI.lblids["DESCRI"]=['ECMZYXKEML'];
function NJXTDVWJFG_Valid(e) {
SetActiveField(Ctrl('NJXTDVWJFG'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('NJXTDVWJFG') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('CODICE','C',w_CODICE,HtW(Ctrl('NJXTDVWJFG').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODICE(HtW(Ctrl('NJXTDVWJFG').value,'C'),null,e);
return l_bSetResult;
}
}
function NJXTDVWJFG_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('NJXTDVWJFG'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('NJXTDVWJFG'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('NJXTDVWJFG'),e);
}
function BSZSUVSKNS_Valid(e) {
SetActiveField(Ctrl('BSZSUVSKNS'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DESCRI','C',w_DESCRI,HtW(Ctrl('BSZSUVSKNS').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DESCRI(HtW(Ctrl('BSZSUVSKNS').value,'C'),null,e);
return l_bSetResult;
}
}
function BSZSUVSKNS_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('BSZSUVSKNS'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('BSZSUVSKNS'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('BSZSUVSKNS'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function NJXTDVWJFG_wrap_Valid(event) {
return NJXTDVWJFG_Valid(event);
}
SPBOUILib.SetInputExit('NJXTDVWJFG',NJXTDVWJFG_wrap_Valid);
function NJXTDVWJFG_wrap_OnFocus(event) {
return NJXTDVWJFG_OnFocus(event);
}
SPBOUILib.SetInputEnter('NJXTDVWJFG',NJXTDVWJFG_wrap_OnFocus);
function NJXTDVWJFG_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('NJXTDVWJFG',NJXTDVWJFG_wrap_OnKeyDown);
function BSZSUVSKNS_wrap_Valid(event) {
return BSZSUVSKNS_Valid(event);
}
SPBOUILib.SetInputExit('BSZSUVSKNS',BSZSUVSKNS_wrap_Valid);
function BSZSUVSKNS_wrap_OnFocus(event) {
return BSZSUVSKNS_OnFocus(event);
}
SPBOUILib.SetInputEnter('BSZSUVSKNS',BSZSUVSKNS_wrap_OnFocus);
function BSZSUVSKNS_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('BSZSUVSKNS',BSZSUVSKNS_wrap_OnKeyDown);
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
FocusFirstComponent.edit={"page_1":["BSZSUVSKNS"]};
FocusFirstComponent.query={"page_1":["NJXTDVWJFG"]};
FocusFirstComponent.otherwise={"page_1":["NJXTDVWJFG"]};
function Help() {
windowOpenForeground('../doc/armt_tbnaturaage_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
return 'tbnaturaage'+'\\'+CPLib.ToCPStr(w_CODICE);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('armt_tbnaturaage',m_cSelectedPage);
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
_Obli('CODICE',0,'NJXTDVWJFG',false,"112851763")
_Obli('DESCRI',0,'BSZSUVSKNS',false,"285808099")
