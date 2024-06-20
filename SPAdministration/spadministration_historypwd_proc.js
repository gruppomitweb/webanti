function FillCombosValues() {
}
function FillInGridCombosValues(currentRow) {
var postfix = (Gt(currentRow,-1)?'_'+currentRow:'');
}
function SetControlsValue() {
var c;
if (Empty(m_cAltInterface) && (Eq(m_cFunction,'view') || Eq(m_cFunction,'query'))) {
SPBOUILib.SetInputValue('HSYXZWNPAJ',function(){return WtH(w_code,'N',9,0,'9999999999')},w_code);
} else {
SPBOUILib.SetInputValue('HSYXZWNPAJ',function(){return WtH(w_code,'N',9,0,'9999999999')},w_code);
SPBOUILib.SetInputValue('ISUBOHJXOM',function(){return WtH(w_pwpassword,'C',20,0,'')},w_pwpassword);
SPBOUILib.SetInputValue('PPWFOHVLVZ',function(){return WtH(w_pwdatcreate,'T',14,0,TranslatePicture(GetDatePicture(true,'T'),'T'))},w_pwdatcreate);
}
if (m_bExtended) {
SetExtensions();
}
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay(Ctrl('JWCXHEBTUS'),true);
SetDisplay(Ctrl('FPGDZKLSYL'),true);
LibJavascript.forEachItem(m_FoundlingHideExpression,i_body_2)
function i_body_2(child){
child();
}
HideUI();
}
HideUI.lblids["code"]=['PAPPYKQEFX'];
function HSYXZWNPAJ_Valid(e) {
SetActiveField(Ctrl('HSYXZWNPAJ'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('HSYXZWNPAJ') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('code','N',w_code,HtW(Ctrl('HSYXZWNPAJ').value,'N'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_code(HtW(Ctrl('HSYXZWNPAJ').value,'N'),null,e);
return l_bSetResult;
}
}
function HSYXZWNPAJ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('HSYXZWNPAJ'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('HSYXZWNPAJ',w_code,'N',9,0,'9999999999');
SetActiveField(Ctrl('HSYXZWNPAJ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('HSYXZWNPAJ'),e);
}
function HSYXZWNPAJ_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("9999999999"));
}
function ISUBOHJXOM_Valid(e) {
SetActiveField(Ctrl('ISUBOHJXOM'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('pwpassword','C',w_pwpassword,HtW(Ctrl('ISUBOHJXOM').value,'C'));
}
}
function ISUBOHJXOM_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ISUBOHJXOM'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('ISUBOHJXOM'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ISUBOHJXOM'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function HSYXZWNPAJ_wrap_Valid(event) {
return HSYXZWNPAJ_Valid(event);
}
SPBOUILib.SetInputExit('HSYXZWNPAJ',HSYXZWNPAJ_wrap_Valid);
function HSYXZWNPAJ_wrap_OnFocus(event) {
return HSYXZWNPAJ_OnFocus(event);
}
SPBOUILib.SetInputEnter('HSYXZWNPAJ',HSYXZWNPAJ_wrap_OnFocus);
function HSYXZWNPAJ_wrap_OnKeyPress(event) {
return HSYXZWNPAJ_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('HSYXZWNPAJ',HSYXZWNPAJ_wrap_OnKeyPress);
function HSYXZWNPAJ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('HSYXZWNPAJ',HSYXZWNPAJ_wrap_OnKeyDown);
function ISUBOHJXOM_wrap_Valid(event) {
return ISUBOHJXOM_Valid(event);
}
SPBOUILib.SetInputExit('ISUBOHJXOM',ISUBOHJXOM_wrap_Valid,SPBOUILib.Row.IN_GRID);
function ISUBOHJXOM_wrap_OnFocus(event) {
return ISUBOHJXOM_OnFocus(event);
}
SPBOUILib.SetInputEnter('ISUBOHJXOM',ISUBOHJXOM_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function ISUBOHJXOM_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('ISUBOHJXOM',ISUBOHJXOM_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
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
m_oFather.i_last_focused_item='child_spadministration_historypwd';
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
m_bStopChangeRow=true;
} else if (Ne('undefined',typeof(m_nLastError))) {
m_bStopChangeRow=Eq(m_nLastError,-2);
}
m_nLastError=0;
m_cLastMsgError='';
}
FocusFirstComponent.edit={};
FocusFirstComponent.query={"page_1":["HSYXZWNPAJ"]};
FocusFirstComponent.otherwise={"page_1":["HSYXZWNPAJ"]};
function Help() {
windowOpenForeground('../doc/spadministration_historypwd_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_code=a[0];
w_pwpassword=a[1];
w_pwdatcreate=a[2];
w_pwdtrevoke=a[3];
w_pwactive=a[4];
m_PrimaryKeys=['pwpassword','code'];
}
function i_PrimaryKey() {
return 'cphistorypwd'+'\\'+CPLib.ToCPStr(w_code);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('spadministration_historypwd',m_cSelectedPage);
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
function FocusFirstDetailComponent() {
var candidatesToFocus = [];
SetControlFocus(candidatesToFocus);
}
IsRepeatedChild.child=[];
function GetFullRowMsgError() {
return 'MSG_FULLROW_NOT_SAT';
}
_Obli('code',1,'HSYXZWNPAJ',false,"1999024119")
