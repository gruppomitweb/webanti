function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('FTBJRJWXQF',function(){return WtH(w_CODICE,'C',3,0,'')},w_CODICE);
SPBOUILib.SetInputValue('GIWBRWPRYB',function(){return WtH(w_DESCRI,'C',254,0,'')},w_DESCRI);
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
HideUI.lblids["CODICE"]=['CRAUSKMDKG'];
HideUI.lblids["DESCRI"]=['TBMUKTULNS'];
function FTBJRJWXQF_Valid(e) {
SetActiveField(Ctrl('FTBJRJWXQF'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('FTBJRJWXQF') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('CODICE','C',w_CODICE,HtW(Ctrl('FTBJRJWXQF').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODICE(HtW(Ctrl('FTBJRJWXQF').value,'C'),null,e);
return l_bSetResult;
}
}
function FTBJRJWXQF_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('FTBJRJWXQF'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('FTBJRJWXQF'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('FTBJRJWXQF'),e);
}
function GIWBRWPRYB_Valid(e) {
SetActiveField(Ctrl('GIWBRWPRYB'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DESCRI','C',w_DESCRI,HtW(Ctrl('GIWBRWPRYB').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DESCRI(HtW(Ctrl('GIWBRWPRYB').value,'C'),null,e);
return l_bSetResult;
}
}
function GIWBRWPRYB_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('GIWBRWPRYB'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('GIWBRWPRYB'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('GIWBRWPRYB'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function FTBJRJWXQF_wrap_Valid(event) {
return FTBJRJWXQF_Valid(event);
}
SPBOUILib.SetInputExit('FTBJRJWXQF',FTBJRJWXQF_wrap_Valid);
function FTBJRJWXQF_wrap_OnFocus(event) {
return FTBJRJWXQF_OnFocus(event);
}
SPBOUILib.SetInputEnter('FTBJRJWXQF',FTBJRJWXQF_wrap_OnFocus);
function FTBJRJWXQF_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('FTBJRJWXQF',FTBJRJWXQF_wrap_OnKeyDown);
function GIWBRWPRYB_wrap_Valid(event) {
return GIWBRWPRYB_Valid(event);
}
SPBOUILib.SetInputExit('GIWBRWPRYB',GIWBRWPRYB_wrap_Valid);
function GIWBRWPRYB_wrap_OnFocus(event) {
return GIWBRWPRYB_OnFocus(event);
}
SPBOUILib.SetInputEnter('GIWBRWPRYB',GIWBRWPRYB_wrap_OnFocus);
function GIWBRWPRYB_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('GIWBRWPRYB',GIWBRWPRYB_wrap_OnKeyDown);
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
FocusFirstComponent.edit={"page_1":["GIWBRWPRYB"]};
FocusFirstComponent.query={"page_1":["FTBJRJWXQF"]};
FocusFirstComponent.otherwise={"page_1":["FTBJRJWXQF"]};
function Help() {
windowOpenForeground('../doc/armt_tbtipope_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
return 'tbtipope'+'\\'+CPLib.ToCPStr(w_CODICE);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('armt_tbtipope',m_cSelectedPage);
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
_Obli('CODICE',0,'FTBJRJWXQF',false,"112851763")
_Obli('DESCRI',0,'GIWBRWPRYB',false,"285808099")
