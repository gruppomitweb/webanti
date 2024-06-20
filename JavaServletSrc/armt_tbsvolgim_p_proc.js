function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('RSWDMOYYIT',function(){return WtH(w_RISCHIO,'N',3,0,'999')},w_RISCHIO);
SPBOUILib.SetInputValue('UIYMSMXTZJ',function(){return WtH(w_oldris,'N',5,0,'')},w_oldris);
if(c=Ctrl('BHHZOGMZKI')) ChkboxCheckUncheck(c,'S',w_FLGPERS)
if(c=Ctrl('BHHZOGMZKI')) ChkboxValueAssign(c,'S','N','C',1,0,'')
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
HideUI.lblids["RISCHIO"]=['MPNVECJGIF'];
function RSWDMOYYIT_Valid(e) {
SetActiveField(Ctrl('RSWDMOYYIT'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('RISCHIO','N',w_RISCHIO,HtW(Ctrl('RSWDMOYYIT').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_RISCHIO(HtW(Ctrl('RSWDMOYYIT').value,'N'),null,e);
return l_bSetResult;
}
}
function RSWDMOYYIT_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('RSWDMOYYIT'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('RSWDMOYYIT',w_RISCHIO,'N',3,0,'999');
SetActiveField(Ctrl('RSWDMOYYIT'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('RSWDMOYYIT'),e);
}
function RSWDMOYYIT_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("999"));
}
function UIYMSMXTZJ_Valid(e) {
SetActiveField(Ctrl('UIYMSMXTZJ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('oldris','N',w_oldris,HtW(Ctrl('UIYMSMXTZJ').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_oldris(HtW(Ctrl('UIYMSMXTZJ').value,'N'),null,e);
return l_bSetResult;
}
}
function UIYMSMXTZJ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('UIYMSMXTZJ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('UIYMSMXTZJ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('UIYMSMXTZJ'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function RSWDMOYYIT_wrap_Valid(event) {
return RSWDMOYYIT_Valid(event);
}
SPBOUILib.SetInputExit('RSWDMOYYIT',RSWDMOYYIT_wrap_Valid);
function RSWDMOYYIT_wrap_OnFocus(event) {
return RSWDMOYYIT_OnFocus(event);
}
SPBOUILib.SetInputEnter('RSWDMOYYIT',RSWDMOYYIT_wrap_OnFocus);
function RSWDMOYYIT_wrap_OnKeyPress(event) {
return RSWDMOYYIT_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('RSWDMOYYIT',RSWDMOYYIT_wrap_OnKeyPress);
function RSWDMOYYIT_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('RSWDMOYYIT',RSWDMOYYIT_wrap_OnKeyDown);
function UIYMSMXTZJ_wrap_Valid(event) {
return UIYMSMXTZJ_Valid(event);
}
SPBOUILib.SetInputExit('UIYMSMXTZJ',UIYMSMXTZJ_wrap_Valid);
function UIYMSMXTZJ_wrap_OnFocus(event) {
return UIYMSMXTZJ_OnFocus(event);
}
SPBOUILib.SetInputEnter('UIYMSMXTZJ',UIYMSMXTZJ_wrap_OnFocus);
function UIYMSMXTZJ_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('UIYMSMXTZJ',UIYMSMXTZJ_wrap_OnKeyPress);
function UIYMSMXTZJ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('UIYMSMXTZJ',UIYMSMXTZJ_wrap_OnKeyDown);
if (m_bExtended) {
SetEventsAndStylesToExtendedFields();
}
}
if (Eq(m_nChildStatus,0)) {
if (Eq(m_cFunction,'query') && Ne(document.FrmToolbar,null)) {
document.FrmToolbar.pos.onkeypress=RecPositionInput;
document.FrmToolbar.pos.onblur=SelectRecord;
}
}
}
function NotifyEvent(p_cEvent) {
var old_c;
}
function SetLastFocusedOnParent() {
if (IsWndAccessible(window['m_oFather'])) {
m_oFather.i_last_focused_item='child_armt_tbsvolgim_p';
m_oFather.last_focused_comp=null;
m_oFather.SetLastFocusedOnParent();
}
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
FocusFirstComponent.edit={"page_1":["RSWDMOYYIT"]};
FocusFirstComponent.query={"page_1":["RSWDMOYYIT"]};
FocusFirstComponent.otherwise={"page_1":["RSWDMOYYIT"]};
function Help() {
windowOpenForeground('../doc/armt_tbsvolgim_p_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_RISCHIO=a[1];
w_FLGPERS=a[2];
w_oldris=a[3];
m_PrimaryKeys=['CODICE'];
}
function i_PrimaryKey() {
return 'tbsvolgim_p'+'\\'+CPLib.ToCPStr(w_CODICE);
}
function CheckZone(me) {
if (IsWndAccessible(window['m_oFather'])) {
return m_oFather.CheckZone('child_armt_tbsvolgim_p');
}
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('armt_tbsvolgim_p',m_cSelectedPage);
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
_Obli('RISCHIO',1,'RSWDMOYYIT',false,"1701052417")
_Obli('oldris',1,'UIYMSMXTZJ',false)
