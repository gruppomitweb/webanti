function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('EPZTAICZCA',function(){return WtH(w_TIPONAT,'C',1,0,'')},w_TIPONAT);
SPBOUILib.SetInputValue('RVGYODTXZT',function(){return WtH(w_DESCRI,'C',60,0,'')},w_DESCRI);
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
HideUI.lblids["DESCRI"]=['UAUEZQKXHT'];
HideUI.lblids["TIPONAT"]=['ZPLFQTPURE'];
function EPZTAICZCA_Valid(e) {
SetActiveField(Ctrl('EPZTAICZCA'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('EPZTAICZCA') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('TIPONAT','C',w_TIPONAT,HtW(Ctrl('EPZTAICZCA').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TIPONAT(HtW(Ctrl('EPZTAICZCA').value,'C'),null,e);
return l_bSetResult;
}
}
function EPZTAICZCA_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('EPZTAICZCA'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('EPZTAICZCA'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('EPZTAICZCA'),e);
}
function RVGYODTXZT_Valid(e) {
SetActiveField(Ctrl('RVGYODTXZT'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DESCRI','C',w_DESCRI,HtW(Ctrl('RVGYODTXZT').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DESCRI(HtW(Ctrl('RVGYODTXZT').value,'C'),null,e);
return l_bSetResult;
}
}
function RVGYODTXZT_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('RVGYODTXZT'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('RVGYODTXZT'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('RVGYODTXZT'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function EPZTAICZCA_wrap_Valid(event) {
return EPZTAICZCA_Valid(event);
}
SPBOUILib.SetInputExit('EPZTAICZCA',EPZTAICZCA_wrap_Valid);
function EPZTAICZCA_wrap_OnFocus(event) {
return EPZTAICZCA_OnFocus(event);
}
SPBOUILib.SetInputEnter('EPZTAICZCA',EPZTAICZCA_wrap_OnFocus);
function EPZTAICZCA_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('EPZTAICZCA',EPZTAICZCA_wrap_OnKeyDown);
function RVGYODTXZT_wrap_Valid(event) {
return RVGYODTXZT_Valid(event);
}
SPBOUILib.SetInputExit('RVGYODTXZT',RVGYODTXZT_wrap_Valid);
function RVGYODTXZT_wrap_OnFocus(event) {
return RVGYODTXZT_OnFocus(event);
}
SPBOUILib.SetInputEnter('RVGYODTXZT',RVGYODTXZT_wrap_OnFocus);
function RVGYODTXZT_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('RVGYODTXZT',RVGYODTXZT_wrap_OnKeyDown);
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
FocusFirstComponent.edit={"page_1":["RVGYODTXZT"]};
FocusFirstComponent.query={"page_1":["EPZTAICZCA"]};
FocusFirstComponent.otherwise={"page_1":["EPZTAICZCA"]};
function Help() {
windowOpenForeground('../doc/armt_natcon_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_TIPONAT=a[0];
w_DESCRI=a[1];
m_PrimaryKeys=['TIPONAT'];
}
function i_PrimaryKey() {
return 'tbtipnat'+'\\'+CPLib.ToCPStr(w_TIPONAT);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('armt_natcon',m_cSelectedPage);
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
_Obli('TIPONAT',0,'EPZTAICZCA',false,"112851763")
_Obli('DESCRI',0,'RVGYODTXZT',false,"285808099")
