function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('KQFYMJDVWR',function(){return WtH(w_CODSPE,'C',4,0,'')},w_CODSPE);
SPBOUILib.SetInputValue('KPVDYVYZMO',function(){return WtH(w_DESCRI,'C',60,0,'')},w_DESCRI);
SPBOUILib.SetInputValue('TNTTYJTZNV',function(){return WtH(w_RISCHIO,'N',3,0,'')},w_RISCHIO);
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
HideUI.lblids["CODSPE"]=['HQPNUAOYVP'];
HideUI.lblids["DESCRI"]=['EGVQMKPTJX'];
HideUI.lblids["RISCHIO"]=['WTMZIIKIBV'];
function KQFYMJDVWR_Valid(e) {
SetActiveField(Ctrl('KQFYMJDVWR'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('KQFYMJDVWR') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('CODSPE','C',w_CODSPE,HtW(Ctrl('KQFYMJDVWR').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODSPE(HtW(Ctrl('KQFYMJDVWR').value,'C'),null,e);
return l_bSetResult;
}
}
function KQFYMJDVWR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('KQFYMJDVWR'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('KQFYMJDVWR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('KQFYMJDVWR'),e);
}
function KPVDYVYZMO_Valid(e) {
SetActiveField(Ctrl('KPVDYVYZMO'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DESCRI','C',w_DESCRI,HtW(Ctrl('KPVDYVYZMO').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DESCRI(HtW(Ctrl('KPVDYVYZMO').value,'C'),null,e);
return l_bSetResult;
}
}
function KPVDYVYZMO_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('KPVDYVYZMO'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('KPVDYVYZMO'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('KPVDYVYZMO'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function KQFYMJDVWR_wrap_Valid(event) {
return KQFYMJDVWR_Valid(event);
}
SPBOUILib.SetInputExit('KQFYMJDVWR',KQFYMJDVWR_wrap_Valid);
function KQFYMJDVWR_wrap_OnFocus(event) {
return KQFYMJDVWR_OnFocus(event);
}
SPBOUILib.SetInputEnter('KQFYMJDVWR',KQFYMJDVWR_wrap_OnFocus);
function KQFYMJDVWR_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('KQFYMJDVWR',KQFYMJDVWR_wrap_OnKeyDown);
function KPVDYVYZMO_wrap_Valid(event) {
return KPVDYVYZMO_Valid(event);
}
SPBOUILib.SetInputExit('KPVDYVYZMO',KPVDYVYZMO_wrap_Valid);
function KPVDYVYZMO_wrap_OnFocus(event) {
return KPVDYVYZMO_OnFocus(event);
}
SPBOUILib.SetInputEnter('KPVDYVYZMO',KPVDYVYZMO_wrap_OnFocus);
function KPVDYVYZMO_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('KPVDYVYZMO',KPVDYVYZMO_wrap_OnKeyDown);
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
FocusFirstComponent.edit={"page_1":["KPVDYVYZMO"]};
FocusFirstComponent.query={"page_1":["KQFYMJDVWR"]};
FocusFirstComponent.otherwise={"page_1":["KQFYMJDVWR"]};
function Help() {
windowOpenForeground('../doc/armt_tbspecie_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_CODSPE=a[0];
w_DESCRI=a[1];
w_RISCHIO=a[2];
m_PrimaryKeys=['CODSPE'];
}
function i_PrimaryKey() {
return 'tbspecie'+'\\'+CPLib.ToCPStr(w_CODSPE);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('armt_tbspecie',m_cSelectedPage);
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
_Obli('CODSPE',0,'KQFYMJDVWR',false,"112851763")
_Obli('DESCRI',0,'KPVDYVYZMO',false,"285808099")
