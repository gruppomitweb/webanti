function FillCombosValues() {
}
function FillInGridCombosValues(currentRow) {
var postfix = (Gt(currentRow,-1)?'_'+currentRow:'');
}
function SetControlsValue() {
var c;
if (Empty(m_cAltInterface) && (Eq(m_cFunction,'view') || Eq(m_cFunction,'query'))) {
} else {
if(c=Ctrl('ODNAMZWXHO')) selectCombo(c,w_TATIPALL,'C')
SPBOUILib.SetInputValue('XMUSIQKUML',function(){return WtH(w_TAPESUNI,'N',5,2,'99.99')},w_TAPESUNI);
SPBOUILib.SetInputValue('JECRGTDJFG',function(){return WtH(w_TAPESSIN,'N',5,2,'99.99')},w_TAPESSIN);
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
LibJavascript.forEachItem(m_FoundlingHideExpression,i_body_2)
function i_body_2(child){
child();
}
HideUI();
}
HideUI.lblids["TAPESUNI"]=['YKMMEPCNJK','LYJITPDTQW'];
HideUI.lblids["TATIPALL"]=['HFSNDSYQKU'];
function ODNAMZWXHO_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('TATIPALL','C',w_TATIPALL,HtW(getComboValue(Ctrl('ODNAMZWXHO')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TATIPALL(HtW(getComboValue(Ctrl('ODNAMZWXHO')),'C'),null,e);
return l_bSetResult;
}
}
function ODNAMZWXHO_OnFocus(e) {
SetActiveField(Ctrl('ODNAMZWXHO'),true);
}
function ODNAMZWXHO_OnBlur(e) {
SetActiveField(Ctrl('ODNAMZWXHO'),false);
}
function XMUSIQKUML_Valid(e) {
SetActiveField(Ctrl('XMUSIQKUML'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TAPESUNI','N',w_TAPESUNI,HtW(Ctrl('XMUSIQKUML').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TAPESUNI(HtW(Ctrl('XMUSIQKUML').value,'N'),null,e);
return l_bSetResult;
}
}
function XMUSIQKUML_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('XMUSIQKUML'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('XMUSIQKUML',w_TAPESUNI,'N',5,2,'99.99');
SetActiveField(Ctrl('XMUSIQKUML'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('XMUSIQKUML'),e);
}
function XMUSIQKUML_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("99.99"));
}
function JECRGTDJFG_Valid(e) {
SetActiveField(Ctrl('JECRGTDJFG'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TAPESSIN','N',w_TAPESSIN,HtW(Ctrl('JECRGTDJFG').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TAPESSIN(HtW(Ctrl('JECRGTDJFG').value,'N'),null,e);
return l_bSetResult;
}
}
function JECRGTDJFG_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('JECRGTDJFG'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('JECRGTDJFG',w_TAPESSIN,'N',5,2,'99.99');
SetActiveField(Ctrl('JECRGTDJFG'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('JECRGTDJFG'),e);
}
function JECRGTDJFG_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("99.99"));
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function ODNAMZWXHO_wrap_Valid(event) {
return ODNAMZWXHO_Valid(event);
}
SPBOUILib.SetComboChange('ODNAMZWXHO',ODNAMZWXHO_wrap_Valid,SPBOUILib.Row.IN_GRID);
function ODNAMZWXHO_wrap_OnFocus(event) {
return ODNAMZWXHO_OnFocus(event);
}
SPBOUILib.SetInputEnter('ODNAMZWXHO',ODNAMZWXHO_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function ODNAMZWXHO_wrap_Blur(event) {
return ODNAMZWXHO_OnBlur(event);
}
SPBOUILib.SetInputExit('ODNAMZWXHO',ODNAMZWXHO_wrap_Blur,SPBOUILib.Row.IN_GRID);
function XMUSIQKUML_wrap_Valid(event) {
return XMUSIQKUML_Valid(event);
}
SPBOUILib.SetInputExit('XMUSIQKUML',XMUSIQKUML_wrap_Valid,SPBOUILib.Row.IN_GRID);
function XMUSIQKUML_wrap_OnFocus(event) {
return XMUSIQKUML_OnFocus(event);
}
SPBOUILib.SetInputEnter('XMUSIQKUML',XMUSIQKUML_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function XMUSIQKUML_wrap_OnKeyPress(event) {
return XMUSIQKUML_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('XMUSIQKUML',XMUSIQKUML_wrap_OnKeyPress,SPBOUILib.Row.IN_GRID);
function XMUSIQKUML_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('XMUSIQKUML',XMUSIQKUML_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function JECRGTDJFG_wrap_Valid(event) {
return JECRGTDJFG_Valid(event);
}
SPBOUILib.SetInputExit('JECRGTDJFG',JECRGTDJFG_wrap_Valid,SPBOUILib.Row.IN_GRID);
function JECRGTDJFG_wrap_OnFocus(event) {
return JECRGTDJFG_OnFocus(event);
}
SPBOUILib.SetInputEnter('JECRGTDJFG',JECRGTDJFG_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function JECRGTDJFG_wrap_OnKeyPress(event) {
return JECRGTDJFG_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('JECRGTDJFG',JECRGTDJFG_wrap_OnKeyPress,SPBOUILib.Row.IN_GRID);
function JECRGTDJFG_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('JECRGTDJFG',JECRGTDJFG_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
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
m_oFather.i_last_focused_item='child_ardt_cgo_tipall';
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
FocusFirstComponent.query={};
FocusFirstComponent.otherwise={};
function Help() {
windowOpenForeground('../doc/ardt_cgo_tipall_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_TACODINT=a[0];
w_TATIPALL=a[1];
w_TAPESUNI=a[2];
w_TAPESSIN=a[3];
m_PrimaryKeys=['TATIPALL','TACODINT'];
}
function i_PrimaryKey() {
return 'cgo_tipall'+'\\'+CPLib.ToCPStr(w_TACODINT);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('ardt_cgo_tipall',m_cSelectedPage);
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
var candidatesToFocus = ["ODNAMZWXHO"];
SetControlFocus(candidatesToFocus);
}
IsRepeatedChild.child=[];
function GetFullRowMsgError() {
return 'MSG_FULLROW_NOT_SAT';
}
_Obli('TATIPALL',0,'ODNAMZWXHO',false,"816713401")
_Obli('TAPESUNI',1,'XMUSIQKUML',false,"450498531")
_Obli('TAPESSIN',1,'JECRGTDJFG',false,"37098542")
