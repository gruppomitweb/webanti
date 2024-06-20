function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('EHBBFZYKCC',function(){return WtH(w_TCCODICE,'C',3,0,'')},w_TCCODICE);
SPBOUILib.SetInputValue('KADYEPRECD',function(){return WtH(w_TCDESCRI,'C',80,0,'')},w_TCDESCRI);
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
HideUI.lblids["TCCODICE"]=['HUWSTBOMPU'];
HideUI.lblids["TCDESCRI"]=['WQMXIYJEWN'];
function EHBBFZYKCC_Valid(e) {
SetActiveField(Ctrl('EHBBFZYKCC'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('EHBBFZYKCC') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('TCCODICE','C',w_TCCODICE,HtW(Ctrl('EHBBFZYKCC').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TCCODICE(HtW(Ctrl('EHBBFZYKCC').value,'C'),null,e);
return l_bSetResult;
}
}
function EHBBFZYKCC_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('EHBBFZYKCC'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('EHBBFZYKCC'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('EHBBFZYKCC'),e);
}
function KADYEPRECD_Valid(e) {
SetActiveField(Ctrl('KADYEPRECD'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TCDESCRI','C',w_TCDESCRI,HtW(Ctrl('KADYEPRECD').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TCDESCRI(HtW(Ctrl('KADYEPRECD').value,'C'),null,e);
return l_bSetResult;
}
}
function KADYEPRECD_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('KADYEPRECD'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('KADYEPRECD'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('KADYEPRECD'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function EHBBFZYKCC_wrap_Valid(event) {
return EHBBFZYKCC_Valid(event);
}
SPBOUILib.SetInputExit('EHBBFZYKCC',EHBBFZYKCC_wrap_Valid);
function EHBBFZYKCC_wrap_OnFocus(event) {
return EHBBFZYKCC_OnFocus(event);
}
SPBOUILib.SetInputEnter('EHBBFZYKCC',EHBBFZYKCC_wrap_OnFocus);
function EHBBFZYKCC_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('EHBBFZYKCC',EHBBFZYKCC_wrap_OnKeyDown);
function KADYEPRECD_wrap_Valid(event) {
return KADYEPRECD_Valid(event);
}
SPBOUILib.SetInputExit('KADYEPRECD',KADYEPRECD_wrap_Valid);
function KADYEPRECD_wrap_OnFocus(event) {
return KADYEPRECD_OnFocus(event);
}
SPBOUILib.SetInputEnter('KADYEPRECD',KADYEPRECD_wrap_OnFocus);
function KADYEPRECD_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('KADYEPRECD',KADYEPRECD_wrap_OnKeyDown);
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
FocusFirstComponent.edit={"page_1":["KADYEPRECD"]};
FocusFirstComponent.query={"page_1":["EHBBFZYKCC"]};
FocusFirstComponent.otherwise={"page_1":["EHBBFZYKCC"]};
function Help() {
windowOpenForeground('../doc/armt_tbtipconcessioni_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_TCCODICE=a[0];
w_TCDESCRI=a[1];
m_PrimaryKeys=['TCCODICE'];
}
function i_PrimaryKey() {
return 'tbtipconcessioni'+'\\'+CPLib.ToCPStr(w_TCCODICE);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('armt_tbtipconcessioni',m_cSelectedPage);
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
_Obli('TCCODICE',0,'EHBBFZYKCC',false,"112851763")
_Obli('TCDESCRI',0,'KADYEPRECD',false,"285808099")
