function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('IQAQZDNBKW',function(){return WtH(w_ARCODICE,'C',2,0,'')},w_ARCODICE);
SPBOUILib.SetInputValue('JVJULEWPVM',function(){return WtH(w_ARDESCRI,'C',15,0,'')},w_ARDESCRI);
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
HideUI.lblids["ARCODICE"]=['SYVBCHLOPY'];
HideUI.lblids["ARDESCRI"]=['VYAYOGVEUZ'];
function IQAQZDNBKW_Valid(e) {
SetActiveField(Ctrl('IQAQZDNBKW'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('IQAQZDNBKW') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('ARCODICE','C',w_ARCODICE,HtW(Ctrl('IQAQZDNBKW').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ARCODICE(HtW(Ctrl('IQAQZDNBKW').value,'C'),null,e);
return l_bSetResult;
}
}
function IQAQZDNBKW_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('IQAQZDNBKW'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('IQAQZDNBKW'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('IQAQZDNBKW'),e);
}
function JVJULEWPVM_Valid(e) {
SetActiveField(Ctrl('JVJULEWPVM'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('ARDESCRI','C',w_ARDESCRI,HtW(Ctrl('JVJULEWPVM').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ARDESCRI(HtW(Ctrl('JVJULEWPVM').value,'C'),null,e);
return l_bSetResult;
}
}
function JVJULEWPVM_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('JVJULEWPVM'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('JVJULEWPVM'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('JVJULEWPVM'),e);
}
linkpc_url.u('UNOBNPHHEV',function(){return 'ardt_docaut?m_bInnerChild=true'+GetLinkPCKeys('ardt_docaut')+'&m_bRowsChild='+EnableChild('ardt_docaut')})
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function IQAQZDNBKW_wrap_Valid(event) {
return IQAQZDNBKW_Valid(event);
}
SPBOUILib.SetInputExit('IQAQZDNBKW',IQAQZDNBKW_wrap_Valid);
function IQAQZDNBKW_wrap_OnFocus(event) {
return IQAQZDNBKW_OnFocus(event);
}
SPBOUILib.SetInputEnter('IQAQZDNBKW',IQAQZDNBKW_wrap_OnFocus);
function IQAQZDNBKW_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('IQAQZDNBKW',IQAQZDNBKW_wrap_OnKeyDown);
function JVJULEWPVM_wrap_Valid(event) {
return JVJULEWPVM_Valid(event);
}
SPBOUILib.SetInputExit('JVJULEWPVM',JVJULEWPVM_wrap_Valid);
function JVJULEWPVM_wrap_OnFocus(event) {
return JVJULEWPVM_OnFocus(event);
}
SPBOUILib.SetInputEnter('JVJULEWPVM',JVJULEWPVM_wrap_OnFocus);
function JVJULEWPVM_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('JVJULEWPVM',JVJULEWPVM_wrap_OnKeyDown);
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
FocusFirstComponent.edit={"page_1":["JVJULEWPVM"]};
FocusFirstComponent.query={"page_1":["IQAQZDNBKW"]};
FocusFirstComponent.otherwise={"page_1":["IQAQZDNBKW"]};
function Help() {
windowOpenForeground('../doc/armt_cgo_autorita_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
}
function CalledBatchEnd() {
if ( ! (m_bCalculating)) {
DoUpdate(true);
}
}
function SetModified_ardt_docaut() {
SetModified();
}
function LoadChildrenInPage(page,lazy) {
if (Eq(page,'page_1')) {
if (ChildToLoad('UNOBNPHHEV')) {
LoadContext.lc(1,'UNOBNPHHEV');
} else {
LibJavascript.RefreshChildGrid('UNOBNPHHEV');
}
}
}
function DeclareWVs() {
var a = arguments;
w_ARCODICE=a[0];
w_ARDESCRI=a[1];
m_cWv_ardt_docaut=a[2];
if (Gt(a.length,3)) {
m_cErrorInChild='';
}
m_PrimaryKeys=['ARCODICE'];
}
function i_PrimaryKey() {
return 'cgo_autorita'+'\\'+CPLib.ToCPStr(w_ARCODICE);
}
GetLinkPCKeys.set_o('ardt_docaut',false);
GetLinkPCKeys.o['ardt_docaut']['DACODICE']=function(t){
if (Ne(m_cFunction,'new')) {
return t(w_ARCODICE,'C');
}
}
function EnableChild(name) {
var l_bRes = false;
return l_bRes;
}
function CheckZone(me) {
return true;
}
LoadContext.f('UNOBNPHHEV',function(){return FrameRef('ardt_docaut')},1,'ardt_docaut',1,1)
GetSelectedChildPage.child={'ardt_docaut': function(){return FrameRef('ardt_docaut')}}
function GetSelectedPage(p_d) {
p_d.setValue('armt_cgo_autorita',m_cSelectedPage);
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
_Obli('ARCODICE',0,'IQAQZDNBKW',false,"112851763")
_Obli('ARDESCRI',0,'JVJULEWPVM',false,"285808099")
