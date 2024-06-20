function FillCombosValues() {
}
function FillInGridCombosValues(currentRow) {
var postfix = (Gt(currentRow,-1)?'_'+currentRow:'');
}
function SetControlsValue() {
var c;
if (Empty(m_cAltInterface) && (Eq(m_cFunction,'view') || Eq(m_cFunction,'query'))) {
} else {
SPBOUILib.SetInputValue('JSWFSTAHBP',function(){return WtH(w_CODDIPE,'C',6,0,'')},w_CODDIPE);
SPBOUILib.SetInputValue('KUPRLIFZIR',function(){return WtH(w_xDESCRIZ,'C',30,0,'')},w_xDESCRIZ);
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
HideUI.lblids["CODDIPE"]=['SGUFYBEXOJ'];
function JSWFSTAHBP_Valid(e) {
SetActiveField(Ctrl('JSWFSTAHBP'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CODDIPE','C',w_CODDIPE,HtW(Ctrl('JSWFSTAHBP').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODDIPE(HtW(Ctrl('JSWFSTAHBP').value,'C'),null,e);
return l_bSetResult;
}
}
function JSWFSTAHBP_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('JSWFSTAHBP'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('JSWFSTAHBP'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('JSWFSTAHBP'),e);
}
function JSWFSTAHBP_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('JSWFSTAHBP')),'linkview_JSWFSTAHBP','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function JSWFSTAHBP_wrap_Valid(event) {
return JSWFSTAHBP_Valid(event);
}
SPBOUILib.SetInputExit('JSWFSTAHBP',JSWFSTAHBP_wrap_Valid,SPBOUILib.Row.IN_GRID);
function JSWFSTAHBP_wrap_OnFocus(event) {
return JSWFSTAHBP_OnFocus(event);
}
SPBOUILib.SetInputEnter('JSWFSTAHBP',JSWFSTAHBP_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function JSWFSTAHBP_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('JSWFSTAHBP',JSWFSTAHBP_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function JSWFSTAHBP_ZOOM_setHandlers() {
function JSWFSTAHBP_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?JSWFSTAHBP_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('JSWFSTAHBP_ZOOM',JSWFSTAHBP_ZOOM_wrap_OnClick,SPBOUILib.Row.IN_GRID);
}
SPBOUILib.SetPicker('JSWFSTAHBP',JSWFSTAHBP_ZOOM_setHandlers);
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
m_oFather.i_last_focused_item='child_ardt_personbo_dip';
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
windowOpenForeground('../doc/ardt_personbo_dip_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_CONNES=a[0];
w_CODDIPE=a[1];
w_xDESCRIZ=a[2];
m_PrimaryKeys=['CODDIPE','CONNES'];
}
function i_PrimaryKey() {
return 'personbo_dip'+'\\'+CPLib.ToCPStr(w_CONNES);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('ardt_personbo_dip',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
function LinkZoomExtendedMenu() {
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_CODDIPE,'C'); },"field":"CODDIP","type":"C"},{"expression":function() { return WtA(w_xDESCRIZ,'C'); },"field":"DESCRIZ","type":"C"}],"itemRepeated":true,"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('anadip','C'),"uid":"JSWFSTAHBP"});
}
function FocusFirstDetailComponent() {
var candidatesToFocus = ["JSWFSTAHBP"];
SetControlFocus(candidatesToFocus);
}
IsRepeatedChild.child=[];
function GetFullRowMsgError() {
return 'MSG_FULLROW_NOT_SAT';
}
_Obli('CODDIPE',0,'JSWFSTAHBP',false,"2071283709")
