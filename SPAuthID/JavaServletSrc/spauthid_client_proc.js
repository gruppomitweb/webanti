function FillCombosValues() {
}
function FillInGridCombosValues(currentRow) {
var postfix = (Gt(currentRow,-1)?'_'+currentRow:'');
}
function SetControlsValue() {
var c;
if (Empty(m_cAltInterface) && (Eq(m_cFunction,'view') || Eq(m_cFunction,'query'))) {
SPBOUILib.SetInputValue('GOURUFIPIA',function(){return WtH(w_publickey,'M',10,0,'')},w_publickey);
} else {
SPBOUILib.SetInputValue('GOURUFIPIA',function(){return WtH(w_publickey,'M',10,0,'')},w_publickey);
SPBOUILib.SetInputValue('CSWXYHZCME',function(){return WtH(w_callbackuri,'C',5096,0,'')},w_callbackuri);
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
HideUI.lblids["callbackuri"]=['CBYVQSGURW'];
HideUI.lblids["publickey"]=['AHIBPPLPFU'];
function ExpandCollapseBoxesUnderCondition() {
var cond;
}
function GOURUFIPIA_Valid(e) {
SetActiveField(Ctrl('GOURUFIPIA'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('publickey','M',w_publickey,HtW(Ctrl('GOURUFIPIA').value,'M'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_publickey(HtW(Ctrl('GOURUFIPIA').value,'M'),null,e);
return l_bSetResult;
}
}
function GOURUFIPIA_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('GOURUFIPIA'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('GOURUFIPIA'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('GOURUFIPIA'),e);
}
function CSWXYHZCME_Valid(e) {
SetActiveField(Ctrl('CSWXYHZCME'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('callbackuri','C',w_callbackuri,HtW(Ctrl('CSWXYHZCME').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_callbackuri(HtW(Ctrl('CSWXYHZCME').value,'C'),null,e);
return l_bSetResult;
}
}
function CSWXYHZCME_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('CSWXYHZCME'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('CSWXYHZCME'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('CSWXYHZCME'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function GOURUFIPIA_wrap_Valid(event) {
return GOURUFIPIA_Valid(event);
}
SPBOUILib.SetInputExit('GOURUFIPIA',GOURUFIPIA_wrap_Valid);
function GOURUFIPIA_wrap_OnFocus(event) {
return GOURUFIPIA_OnFocus(event);
}
SPBOUILib.SetInputEnter('GOURUFIPIA',GOURUFIPIA_wrap_OnFocus);
function CSWXYHZCME_wrap_Valid(event) {
return CSWXYHZCME_Valid(event);
}
SPBOUILib.SetInputExit('CSWXYHZCME',CSWXYHZCME_wrap_Valid,SPBOUILib.Row.IN_GRID);
function CSWXYHZCME_wrap_OnFocus(event) {
return CSWXYHZCME_OnFocus(event);
}
SPBOUILib.SetInputEnter('CSWXYHZCME',CSWXYHZCME_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function CSWXYHZCME_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('CSWXYHZCME',CSWXYHZCME_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
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
m_oFather.i_last_focused_item='child_spauthid_client';
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
FocusFirstComponent.edit={"page_1":["GOURUFIPIA"]};
FocusFirstComponent.query={"page_1":["GOURUFIPIA"]};
FocusFirstComponent.otherwise={"page_1":["GOURUFIPIA"]};
function Help() {
windowOpenForeground('../doc/spauthid_client_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_usercode=a[0];
w_publickey=a[1];
w_callbackuri=a[2];
w_CPROWNUM=a[3];
m_PrimaryKeys=['CPROWNUM','usercode'];
}
function i_PrimaryKey() {
return 'spauthid_client_m'+'\\'+CPLib.ToCPStr(w_usercode);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('spauthid_client',m_cSelectedPage);
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
var candidatesToFocus = ["CSWXYHZCME"];
SetControlFocus(candidatesToFocus);
}
IsRepeatedChild.child=[];
function GetFullRowMsgError() {
return 'MSG_FULLROW_NOT_SAT';
}
_Obli('publickey',0,'GOURUFIPIA',false,"846681157")
_Obli('callbackuri',0,'CSWXYHZCME',false,"435231171")
