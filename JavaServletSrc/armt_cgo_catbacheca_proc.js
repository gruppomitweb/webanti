function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('MCINQDZYTJ',function(){return WtH(w_CBCODICE,'C',5,0,'')},w_CBCODICE);
SPBOUILib.SetInputValue('HELQXUVJME',function(){return WtH(w_CBDESCRI,'C',60,0,'')},w_CBDESCRI);
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
HideUI.lblids["CBCODICE"]=['WRXHUBYZJJ'];
HideUI.lblids["CBDESCRI"]=['TIVPFAXBTH'];
function MCINQDZYTJ_Valid(e) {
SetActiveField(Ctrl('MCINQDZYTJ'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('MCINQDZYTJ') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('CBCODICE','C',w_CBCODICE,HtW(Ctrl('MCINQDZYTJ').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CBCODICE(HtW(Ctrl('MCINQDZYTJ').value,'C'),null,e);
return l_bSetResult;
}
}
function MCINQDZYTJ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('MCINQDZYTJ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('MCINQDZYTJ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('MCINQDZYTJ'),e);
}
function HELQXUVJME_Valid(e) {
SetActiveField(Ctrl('HELQXUVJME'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CBDESCRI','C',w_CBDESCRI,HtW(Ctrl('HELQXUVJME').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CBDESCRI(HtW(Ctrl('HELQXUVJME').value,'C'),null,e);
return l_bSetResult;
}
}
function HELQXUVJME_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('HELQXUVJME'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('HELQXUVJME'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('HELQXUVJME'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function MCINQDZYTJ_wrap_Valid(event) {
return MCINQDZYTJ_Valid(event);
}
SPBOUILib.SetInputExit('MCINQDZYTJ',MCINQDZYTJ_wrap_Valid);
function MCINQDZYTJ_wrap_OnFocus(event) {
return MCINQDZYTJ_OnFocus(event);
}
SPBOUILib.SetInputEnter('MCINQDZYTJ',MCINQDZYTJ_wrap_OnFocus);
function MCINQDZYTJ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('MCINQDZYTJ',MCINQDZYTJ_wrap_OnKeyDown);
function HELQXUVJME_wrap_Valid(event) {
return HELQXUVJME_Valid(event);
}
SPBOUILib.SetInputExit('HELQXUVJME',HELQXUVJME_wrap_Valid);
function HELQXUVJME_wrap_OnFocus(event) {
return HELQXUVJME_OnFocus(event);
}
SPBOUILib.SetInputEnter('HELQXUVJME',HELQXUVJME_wrap_OnFocus);
function HELQXUVJME_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('HELQXUVJME',HELQXUVJME_wrap_OnKeyDown);
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
FocusFirstComponent.edit={"page_1":["HELQXUVJME"]};
FocusFirstComponent.query={"page_1":["MCINQDZYTJ"]};
FocusFirstComponent.otherwise={"page_1":["MCINQDZYTJ"]};
function Help() {
windowOpenForeground('../doc/armt_cgo_catbacheca_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_CBCODICE=a[0];
w_CBDESCRI=a[1];
m_PrimaryKeys=['CBCODICE'];
}
function i_PrimaryKey() {
return 'cgo_catbacheca'+'\\'+CPLib.ToCPStr(w_CBCODICE);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('armt_cgo_catbacheca',m_cSelectedPage);
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
_Obli('CBCODICE',0,'MCINQDZYTJ',false,"112851763")
_Obli('CBDESCRI',0,'HELQXUVJME',false,"285808099")
