function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('YFROOTFHWU',function(){return WtH(w_CODICE,'C',5,0,'')},w_CODICE);
SPBOUILib.SetInputValue('NVPGGTHHZJ',function(){return WtH(w_DESCRI,'C',60,0,'')},w_DESCRI);
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
HideUI.lblids["CODICE"]=['TIYDKIFTFE'];
HideUI.lblids["DESCRI"]=['TDBTLASCCU'];
HideUI.lblids["RISCHIO"]=['TRTQZEAWPK'];
function YFROOTFHWU_Valid(e) {
SetActiveField(Ctrl('YFROOTFHWU'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('YFROOTFHWU') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('CODICE','C',w_CODICE,HtW(Ctrl('YFROOTFHWU').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODICE(HtW(Ctrl('YFROOTFHWU').value,'C'),null,e);
return l_bSetResult;
}
}
function YFROOTFHWU_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('YFROOTFHWU'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('YFROOTFHWU'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('YFROOTFHWU'),e);
}
function NVPGGTHHZJ_Valid(e) {
SetActiveField(Ctrl('NVPGGTHHZJ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DESCRI','C',w_DESCRI,HtW(Ctrl('NVPGGTHHZJ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DESCRI(HtW(Ctrl('NVPGGTHHZJ').value,'C'),null,e);
return l_bSetResult;
}
}
function NVPGGTHHZJ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('NVPGGTHHZJ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('NVPGGTHHZJ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('NVPGGTHHZJ'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function YFROOTFHWU_wrap_Valid(event) {
return YFROOTFHWU_Valid(event);
}
SPBOUILib.SetInputExit('YFROOTFHWU',YFROOTFHWU_wrap_Valid);
function YFROOTFHWU_wrap_OnFocus(event) {
return YFROOTFHWU_OnFocus(event);
}
SPBOUILib.SetInputEnter('YFROOTFHWU',YFROOTFHWU_wrap_OnFocus);
function YFROOTFHWU_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('YFROOTFHWU',YFROOTFHWU_wrap_OnKeyDown);
function NVPGGTHHZJ_wrap_Valid(event) {
return NVPGGTHHZJ_Valid(event);
}
SPBOUILib.SetInputExit('NVPGGTHHZJ',NVPGGTHHZJ_wrap_Valid);
function NVPGGTHHZJ_wrap_OnFocus(event) {
return NVPGGTHHZJ_OnFocus(event);
}
SPBOUILib.SetInputEnter('NVPGGTHHZJ',NVPGGTHHZJ_wrap_OnFocus);
function NVPGGTHHZJ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('NVPGGTHHZJ',NVPGGTHHZJ_wrap_OnKeyDown);
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
FocusFirstComponent.edit={"page_1":["NVPGGTHHZJ"]};
FocusFirstComponent.query={"page_1":["YFROOTFHWU"]};
FocusFirstComponent.otherwise={"page_1":["YFROOTFHWU"]};
function Help() {
windowOpenForeground('../doc/armt_tbcondotta_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
return 'tbcondotta'+'\\'+CPLib.ToCPStr(w_CODICE);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('armt_tbcondotta',m_cSelectedPage);
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
_Obli('CODICE',0,'YFROOTFHWU',false,"112851763")
_Obli('DESCRI',0,'NVPGGTHHZJ',false,"285808099")
