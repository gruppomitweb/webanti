function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('IFJYIFRJJC',function(){return WtH(w_ECCODICE,'C',2,0,'')},w_ECCODICE);
SPBOUILib.SetInputValue('IOEFFWADWT',function(){return WtH(w_ECDESCRI,'C',40,0,'')},w_ECDESCRI);
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
HideUI.lblids["ECCODICE"]=['KZZEDCPHGI'];
HideUI.lblids["ECDESCRI"]=['EKMYUOKDUO'];
function IFJYIFRJJC_Valid(e) {
SetActiveField(Ctrl('IFJYIFRJJC'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('IFJYIFRJJC') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('ECCODICE','C',w_ECCODICE,HtW(Ctrl('IFJYIFRJJC').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ECCODICE(HtW(Ctrl('IFJYIFRJJC').value,'C'),null,e);
return l_bSetResult;
}
}
function IFJYIFRJJC_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('IFJYIFRJJC'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('IFJYIFRJJC'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('IFJYIFRJJC'),e);
}
function IOEFFWADWT_Valid(e) {
SetActiveField(Ctrl('IOEFFWADWT'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('ECDESCRI','C',w_ECDESCRI,HtW(Ctrl('IOEFFWADWT').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ECDESCRI(HtW(Ctrl('IOEFFWADWT').value,'C'),null,e);
return l_bSetResult;
}
}
function IOEFFWADWT_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('IOEFFWADWT'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('IOEFFWADWT'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('IOEFFWADWT'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function IFJYIFRJJC_wrap_Valid(event) {
return IFJYIFRJJC_Valid(event);
}
SPBOUILib.SetInputExit('IFJYIFRJJC',IFJYIFRJJC_wrap_Valid);
function IFJYIFRJJC_wrap_OnFocus(event) {
return IFJYIFRJJC_OnFocus(event);
}
SPBOUILib.SetInputEnter('IFJYIFRJJC',IFJYIFRJJC_wrap_OnFocus);
function IFJYIFRJJC_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('IFJYIFRJJC',IFJYIFRJJC_wrap_OnKeyDown);
function IOEFFWADWT_wrap_Valid(event) {
return IOEFFWADWT_Valid(event);
}
SPBOUILib.SetInputExit('IOEFFWADWT',IOEFFWADWT_wrap_Valid);
function IOEFFWADWT_wrap_OnFocus(event) {
return IOEFFWADWT_OnFocus(event);
}
SPBOUILib.SetInputEnter('IOEFFWADWT',IOEFFWADWT_wrap_OnFocus);
function IOEFFWADWT_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('IOEFFWADWT',IOEFFWADWT_wrap_OnKeyDown);
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
FocusFirstComponent.edit={"page_1":["IOEFFWADWT"]};
FocusFirstComponent.query={"page_1":["IFJYIFRJJC"]};
FocusFirstComponent.otherwise={"page_1":["IFJYIFRJJC"]};
function Help() {
windowOpenForeground('../doc/armt_cgo_esiticon_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_ECCODICE=a[0];
w_ECDESCRI=a[1];
m_PrimaryKeys=['ECCODICE'];
}
function i_PrimaryKey() {
return 'cgo_esiticon'+'\\'+CPLib.ToCPStr(w_ECCODICE);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('armt_cgo_esiticon',m_cSelectedPage);
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
_Obli('ECCODICE',0,'IFJYIFRJJC',false,"1992386102")
_Obli('ECDESCRI',0,'IOEFFWADWT',false,"285808099")
