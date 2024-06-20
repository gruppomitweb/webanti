function FillCombosValues() {
}
function FillInGridCombosValues(currentRow) {
var postfix = (Gt(currentRow,-1)?'_'+currentRow:'');
}
function SetControlsValue() {
var c;
if (Empty(m_cAltInterface) && (Eq(m_cFunction,'view') || Eq(m_cFunction,'query'))) {
var tmp_HGVDZOSTRF = ToHTag(AsControlValue(w_xdescriz));
if (Ne(e_HGVDZOSTRF,tmp_HGVDZOSTRF)) {
SPBOUILib.SetLabelValue('HGVDZOSTRF','innerHTML',tmp_HGVDZOSTRF);
e_HGVDZOSTRF=tmp_HGVDZOSTRF;
}
} else {
var tmp_HGVDZOSTRF = ToHTag(AsControlValue(w_xdescriz));
if (Ne(e_HGVDZOSTRF,tmp_HGVDZOSTRF)) {
SPBOUILib.SetLabelValue('HGVDZOSTRF','innerHTML',tmp_HGVDZOSTRF);
e_HGVDZOSTRF=tmp_HGVDZOSTRF;
}
SPBOUILib.SetInputValue('VFWKOPPXKC',function(){return WtH(w_CODSOG,'C',16,0,'')},w_CODSOG);
SPBOUILib.SetInputValue('OSQIWZOZQN',function(){return WtH(w_LEGAME,'C',1,0,'')},w_LEGAME);
SPBOUILib.SetInputValue('SPPGKRITOT',function(){return WtH(w_xragsoc,'C',70,0,'')},w_xragsoc);
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
function VFWKOPPXKC_Valid(e) {
SetActiveField(Ctrl('VFWKOPPXKC'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CODSOG','C',w_CODSOG,HtW(Ctrl('VFWKOPPXKC').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODSOG(HtW(Ctrl('VFWKOPPXKC').value,'C'),null,e);
return l_bSetResult;
}
}
function VFWKOPPXKC_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('VFWKOPPXKC'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('VFWKOPPXKC'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('VFWKOPPXKC'),e);
}
function VFWKOPPXKC_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('VFWKOPPXKC')),'linkview_VFWKOPPXKC','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function OSQIWZOZQN_Valid(e) {
SetActiveField(Ctrl('OSQIWZOZQN'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('LEGAME','C',w_LEGAME,HtW(Ctrl('OSQIWZOZQN').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_LEGAME(HtW(Ctrl('OSQIWZOZQN').value,'C'),null,e);
return l_bSetResult;
}
}
function OSQIWZOZQN_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('OSQIWZOZQN'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('OSQIWZOZQN'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('OSQIWZOZQN'),e);
}
function OSQIWZOZQN_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('OSQIWZOZQN')),'linkview_OSQIWZOZQN','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function VFWKOPPXKC_wrap_Valid(event) {
return VFWKOPPXKC_Valid(event);
}
SPBOUILib.SetInputExit('VFWKOPPXKC',VFWKOPPXKC_wrap_Valid,SPBOUILib.Row.IN_GRID);
function VFWKOPPXKC_wrap_OnFocus(event) {
return VFWKOPPXKC_OnFocus(event);
}
SPBOUILib.SetInputEnter('VFWKOPPXKC',VFWKOPPXKC_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function VFWKOPPXKC_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('VFWKOPPXKC',VFWKOPPXKC_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function VFWKOPPXKC_ZOOM_setHandlers() {
function VFWKOPPXKC_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?VFWKOPPXKC_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('VFWKOPPXKC_ZOOM',VFWKOPPXKC_ZOOM_wrap_OnClick,SPBOUILib.Row.IN_GRID);
}
SPBOUILib.SetPicker('VFWKOPPXKC',VFWKOPPXKC_ZOOM_setHandlers);
function OSQIWZOZQN_wrap_Valid(event) {
return OSQIWZOZQN_Valid(event);
}
SPBOUILib.SetInputExit('OSQIWZOZQN',OSQIWZOZQN_wrap_Valid,SPBOUILib.Row.IN_GRID);
function OSQIWZOZQN_wrap_OnFocus(event) {
return OSQIWZOZQN_OnFocus(event);
}
SPBOUILib.SetInputEnter('OSQIWZOZQN',OSQIWZOZQN_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function OSQIWZOZQN_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('OSQIWZOZQN',OSQIWZOZQN_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function OSQIWZOZQN_ZOOM_setHandlers() {
function OSQIWZOZQN_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?OSQIWZOZQN_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('OSQIWZOZQN_ZOOM',OSQIWZOZQN_ZOOM_wrap_OnClick,SPBOUILib.Row.IN_GRID);
}
SPBOUILib.SetPicker('OSQIWZOZQN',OSQIWZOZQN_ZOOM_setHandlers);
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
m_oFather.i_last_focused_item='child_ardt_ae_sogopebo';
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
windowOpenForeground('../doc/ardt_ae_sogopebo_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_IDFILEBO=a[0];
w_CODSOG=a[1];
w_LEGAME=a[2];
w_xragsoc=a[3];
w_xdescriz=a[4];
m_PrimaryKeys=['IDFILEBO'];
}
function i_PrimaryKey() {
return 'jogopebo'+'\\'+CPLib.ToCPStr(w_IDFILEBO);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('ardt_ae_sogopebo',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
function LinkZoomExtendedMenu() {
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_CODSOG,'C'); },"field":"CONNES","type":"C"},{"expression":function() { return WtA(w_xragsoc,'C'); },"field":"RAGSOC","type":"C"}],"itemRepeated":true,"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('personbo','C'),"uid":"VFWKOPPXKC"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_LEGAME,'C'); },"field":"TIPLEG","type":"C"},{"expression":function() { return WtA(w_xdescriz,'C'); },"field":"DESCRIZ","type":"C"}],"itemRepeated":true,"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbtipleg','C'),"uid":"OSQIWZOZQN"});
}
function FocusFirstDetailComponent() {
var candidatesToFocus = ["VFWKOPPXKC"];
SetControlFocus(candidatesToFocus);
}
IsRepeatedChild.child=[];
function GetFullRowMsgError() {
return 'MSG_FULLROW_NOT_SAT';
}
_Obli('LEGAME',0,'OSQIWZOZQN',false,"10639118571")
_Obli('CODSOG',0,'VFWKOPPXKC',false,"10847988462")
