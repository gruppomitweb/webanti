function FillCombosValues() {
}
function FillInGridCombosValues(currentRow) {
var postfix = (Gt(currentRow,-1)?'_'+currentRow:'');
}
function SetControlsValue() {
var c;
if (Empty(m_cAltInterface) && (Eq(m_cFunction,'view') || Eq(m_cFunction,'query'))) {
var tmp_NAKGRMOUXS = ToHTag(AsControlValue(w_DOMICILIO));
if (Ne(e_NAKGRMOUXS,tmp_NAKGRMOUXS)) {
SPBOUILib.SetLabelValue('NAKGRMOUXS','innerHTML',tmp_NAKGRMOUXS);
e_NAKGRMOUXS=tmp_NAKGRMOUXS;
}
var tmp_HMPQLYVATL = ToHTag(AsControlValue(LRTrim(w_CAP)+' '+LRTrim(w_DESCCIT)+' ('+LRTrim(w_PROVINCIA)+')'));
if (Ne(e_HMPQLYVATL,tmp_HMPQLYVATL)) {
SPBOUILib.SetLabelValue('HMPQLYVATL','innerHTML',tmp_HMPQLYVATL);
e_HMPQLYVATL=tmp_HMPQLYVATL;
}
} else {
var tmp_NAKGRMOUXS = ToHTag(AsControlValue(w_DOMICILIO));
if (Ne(e_NAKGRMOUXS,tmp_NAKGRMOUXS)) {
SPBOUILib.SetLabelValue('NAKGRMOUXS','innerHTML',tmp_NAKGRMOUXS);
e_NAKGRMOUXS=tmp_NAKGRMOUXS;
}
var tmp_HMPQLYVATL = ToHTag(AsControlValue(LRTrim(w_CAP)+' '+LRTrim(w_DESCCIT)+' ('+LRTrim(w_PROVINCIA)+')'));
if (Ne(e_HMPQLYVATL,tmp_HMPQLYVATL)) {
SPBOUILib.SetLabelValue('HMPQLYVATL','innerHTML',tmp_HMPQLYVATL);
e_HMPQLYVATL=tmp_HMPQLYVATL;
}
SPBOUILib.SetInputValue('TMTNRFTARW',function(){return WtH(w_CODSOG,'C',16,0,'')},w_CODSOG);
SPBOUILib.SetInputValue('DTVWWZNCNW',function(){return WtH(w_xragsoc,'C',70,0,'')},w_xragsoc);
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
SetDisplay('VRCVINYRJO_DIV',IsHiddenByStateDriver('box_VRCVINYRJO'));
LibJavascript.forEachItem(m_FoundlingHideExpression,i_body_2)
function i_body_2(child){
child();
}
HideUI();
}
function TMTNRFTARW_Valid(e) {
SetActiveField(Ctrl('TMTNRFTARW'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CODSOG','C',w_CODSOG,HtW(Ctrl('TMTNRFTARW').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODSOG(HtW(Ctrl('TMTNRFTARW').value,'C'),null,e);
return l_bSetResult;
}
}
function TMTNRFTARW_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('TMTNRFTARW'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('TMTNRFTARW'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('TMTNRFTARW'),e);
}
function TMTNRFTARW_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('TMTNRFTARW')),'linkview_TMTNRFTARW','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function TMTNRFTARW_wrap_Valid(event) {
return TMTNRFTARW_Valid(event);
}
SPBOUILib.SetInputExit('TMTNRFTARW',TMTNRFTARW_wrap_Valid,SPBOUILib.Row.IN_GRID);
function TMTNRFTARW_wrap_OnFocus(event) {
return TMTNRFTARW_OnFocus(event);
}
SPBOUILib.SetInputEnter('TMTNRFTARW',TMTNRFTARW_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function TMTNRFTARW_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('TMTNRFTARW',TMTNRFTARW_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function TMTNRFTARW_ZOOM_setHandlers() {
function TMTNRFTARW_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?TMTNRFTARW_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('TMTNRFTARW_ZOOM',TMTNRFTARW_ZOOM_wrap_OnClick,SPBOUILib.Row.IN_GRID);
}
SPBOUILib.SetPicker('TMTNRFTARW',TMTNRFTARW_ZOOM_setHandlers);
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
m_oFather.i_last_focused_item='child_ardt_werzistifrz';
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
windowOpenForeground('../doc/ardt_werzistifrz_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_IDBASE=a[2];
w_xragsoc=a[3];
w_DOMICILIO=a[4];
w_DESCCIT=a[5];
w_PROVINCIA=a[6];
w_CAP=a[7];
m_PrimaryKeys=['CODSOG','IDFILEBO'];
}
function i_PrimaryKey() {
return 'werzistifrz'+'\\'+CPLib.ToCPStr(w_IDFILEBO);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('ardt_werzistifrz',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
function LinkZoomExtendedMenu() {
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_CODSOG,'C'); },"field":"CONNES","type":"C"},{"expression":function() { return WtA(w_xragsoc,'C'); },"field":"RAGSOC","type":"C"},{"expression":function() { return WtA(w_DOMICILIO,'C'); },"field":"DOMICILIO","type":"C"},{"expression":function() { return WtA(w_DESCCIT,'C'); },"field":"DESCCIT","type":"C"},{"expression":function() { return WtA(w_PROVINCIA,'C'); },"field":"PROVINCIA","type":"C"},{"expression":function() { return WtA(w_CAP,'C'); },"field":"CAP","type":"C"}],"itemRepeated":true,"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('personbo','C'),"uid":"TMTNRFTARW"});
}
function FocusFirstDetailComponent() {
var candidatesToFocus = ["TMTNRFTARW"];
SetControlFocus(candidatesToFocus);
}
IsRepeatedChild.child=[];
function GetFullRowMsgError() {
return 'MSG_FULLROW_NOT_SAT';
}
_Obli('CODSOG',0,'TMTNRFTARW',false,"10847988462")
