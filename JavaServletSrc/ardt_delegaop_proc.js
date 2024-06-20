function FillCombosValues() {
}
function FillInGridCombosValues(currentRow) {
var postfix = (Gt(currentRow,-1)?'_'+currentRow:'');
}
function SetControlsValue() {
var c;
if (Empty(m_cAltInterface) && (Eq(m_cFunction,'view') || Eq(m_cFunction,'query'))) {
} else {
SPBOUILib.SetInputValue('QVNGTSMQDW',function(){return WtH(w_CODINTER,'C',16,0,'')},w_CODINTER);
SPBOUILib.SetInputValue('VWJRJLRPVH',function(){return WtH(w_DATAINI,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATAINI);
SPBOUILib.SetInputValue('ETHOBQMTKW',function(){return WtH(w_DATAFINE,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATAFINE);
SPBOUILib.SetInputValue('NZGGDYYKJT',function(){return WtH(w_xRAGSOC,'C',70,0,'')},w_xRAGSOC);
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
HideUI.lblids["CODINTER"]=['LRCBCCJPMM'];
HideUI.lblids["DATAFINE"]=['LPRANTQLEG'];
HideUI.lblids["DATAINI"]=['COQJLKUWGH'];
function QVNGTSMQDW_Valid(e) {
SetActiveField(Ctrl('QVNGTSMQDW'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CODINTER','C',w_CODINTER,HtW(Ctrl('QVNGTSMQDW').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODINTER(HtW(Ctrl('QVNGTSMQDW').value,'C'),null,e);
return l_bSetResult;
}
}
function QVNGTSMQDW_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('QVNGTSMQDW'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('QVNGTSMQDW'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('QVNGTSMQDW'),e);
}
function QVNGTSMQDW_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('QVNGTSMQDW')),'linkview_QVNGTSMQDW','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function VWJRJLRPVH_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('VWJRJLRPVH'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('VWJRJLRPVH').value=ApplyPictureToDate(Ctrl('VWJRJLRPVH').value,TranslatePicture(datePattern),'VWJRJLRPVH');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('VWJRJLRPVH'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('VWJRJLRPVH');
}
}
}
SetActiveField(Ctrl('VWJRJLRPVH'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATAINI','D',w_DATAINI,HtW(Ctrl('VWJRJLRPVH').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATAINI(HtW(Ctrl('VWJRJLRPVH').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function VWJRJLRPVH_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('VWJRJLRPVH'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('VWJRJLRPVH',w_DATAINI,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('VWJRJLRPVH');
SetActiveField(Ctrl('VWJRJLRPVH'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('VWJRJLRPVH'),e);
}
function VWJRJLRPVH_ZOOM_Click() {
LaunchCalendar(Ctrl('VWJRJLRPVH'));
}
function ETHOBQMTKW_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('ETHOBQMTKW'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('ETHOBQMTKW').value=ApplyPictureToDate(Ctrl('ETHOBQMTKW').value,TranslatePicture(datePattern),'ETHOBQMTKW');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('ETHOBQMTKW'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('ETHOBQMTKW');
}
}
}
SetActiveField(Ctrl('ETHOBQMTKW'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATAFINE','D',w_DATAFINE,HtW(Ctrl('ETHOBQMTKW').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATAFINE(HtW(Ctrl('ETHOBQMTKW').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function ETHOBQMTKW_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ETHOBQMTKW'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('ETHOBQMTKW',w_DATAFINE,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('ETHOBQMTKW');
SetActiveField(Ctrl('ETHOBQMTKW'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ETHOBQMTKW'),e);
}
function ETHOBQMTKW_ZOOM_Click() {
LaunchCalendar(Ctrl('ETHOBQMTKW'));
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function QVNGTSMQDW_wrap_Valid(event) {
return QVNGTSMQDW_Valid(event);
}
SPBOUILib.SetInputExit('QVNGTSMQDW',QVNGTSMQDW_wrap_Valid,SPBOUILib.Row.IN_GRID);
function QVNGTSMQDW_wrap_OnFocus(event) {
return QVNGTSMQDW_OnFocus(event);
}
SPBOUILib.SetInputEnter('QVNGTSMQDW',QVNGTSMQDW_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function QVNGTSMQDW_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('QVNGTSMQDW',QVNGTSMQDW_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function QVNGTSMQDW_ZOOM_setHandlers() {
function QVNGTSMQDW_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?QVNGTSMQDW_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('QVNGTSMQDW_ZOOM',QVNGTSMQDW_ZOOM_wrap_OnClick,SPBOUILib.Row.IN_GRID);
}
SPBOUILib.SetPicker('QVNGTSMQDW',QVNGTSMQDW_ZOOM_setHandlers);
function VWJRJLRPVH_wrap_Valid(event) {
return VWJRJLRPVH_Valid(event);
}
SPBOUILib.SetInputExit('VWJRJLRPVH',VWJRJLRPVH_wrap_Valid,SPBOUILib.Row.IN_GRID);
function VWJRJLRPVH_wrap_OnFocus(event) {
return VWJRJLRPVH_OnFocus(event);
}
SPBOUILib.SetInputEnter('VWJRJLRPVH',VWJRJLRPVH_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function VWJRJLRPVH_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('VWJRJLRPVH',VWJRJLRPVH_wrap_OnKeyPress,SPBOUILib.Row.IN_GRID);
function VWJRJLRPVH_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('VWJRJLRPVH',VWJRJLRPVH_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function VWJRJLRPVH_ZOOM_setHandlers() {
function VWJRJLRPVH_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?VWJRJLRPVH_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('VWJRJLRPVH_ZOOM',VWJRJLRPVH_ZOOM_wrap_OnClick,SPBOUILib.Row.IN_GRID);
}
SPBOUILib.SetPicker('VWJRJLRPVH',VWJRJLRPVH_ZOOM_setHandlers);
function ETHOBQMTKW_wrap_Valid(event) {
return ETHOBQMTKW_Valid(event);
}
SPBOUILib.SetInputExit('ETHOBQMTKW',ETHOBQMTKW_wrap_Valid,SPBOUILib.Row.IN_GRID);
function ETHOBQMTKW_wrap_OnFocus(event) {
return ETHOBQMTKW_OnFocus(event);
}
SPBOUILib.SetInputEnter('ETHOBQMTKW',ETHOBQMTKW_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function ETHOBQMTKW_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('ETHOBQMTKW',ETHOBQMTKW_wrap_OnKeyPress,SPBOUILib.Row.IN_GRID);
function ETHOBQMTKW_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('ETHOBQMTKW',ETHOBQMTKW_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function ETHOBQMTKW_ZOOM_setHandlers() {
function ETHOBQMTKW_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?ETHOBQMTKW_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('ETHOBQMTKW_ZOOM',ETHOBQMTKW_ZOOM_wrap_OnClick,SPBOUILib.Row.IN_GRID);
}
SPBOUILib.SetPicker('ETHOBQMTKW',ETHOBQMTKW_ZOOM_setHandlers);
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
m_oFather.i_last_focused_item='child_ardt_delegaop';
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
windowOpenForeground('../doc/ardt_delegaop_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_COLLEG=a[0];
w_ANNO=a[1];
w_CODINTER=a[2];
w_DATAINI=a[3];
w_DATAFINE=a[4];
w_xRAGSOC=a[5];
m_PrimaryKeys=['CODINTER','ANNO','COLLEG'];
}
function i_PrimaryKey() {
return 'delegaop'+'\\'+CPLib.ToCPStr(w_COLLEG)+'\\'+CPLib.ToCPStr(w_ANNO);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('ardt_delegaop',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
function LinkZoomExtendedMenu() {
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_CODINTER,'C'); },"field":"CONNES","type":"C"},{"expression":function() { return WtA(w_xRAGSOC,'C'); },"field":"RAGSOC","type":"C"}],"itemRepeated":true,"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('personbo','C'),"uid":"QVNGTSMQDW"});
}
function FocusFirstDetailComponent() {
var candidatesToFocus = ["QVNGTSMQDW"];
SetControlFocus(candidatesToFocus);
}
IsRepeatedChild.child=[];
function GetFullRowMsgError() {
return 'MSG_FULLROW_NOT_SAT';
}
_Obli('CODINTER',0,'QVNGTSMQDW',false,"1786626708")
_Obli('DATAINI',2,'VWJRJLRPVH',false,"45547614")
_Obli('DATAFINE',2,'ETHOBQMTKW',false,"1300662969")
