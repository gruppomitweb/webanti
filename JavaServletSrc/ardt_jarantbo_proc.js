function FillCombosValues() {
}
function FillInGridCombosValues(currentRow) {
var postfix = (Gt(currentRow,-1)?'_'+currentRow:'');
}
function SetControlsValue() {
var c;
if (Empty(m_cAltInterface) && (Eq(m_cFunction,'view') || Eq(m_cFunction,'query'))) {
} else {
SPBOUILib.SetInputValue('FPBSSVXDQL',function(){return WtH(w_CODINTER,'C',16,0,'')},w_CODINTER);
SPBOUILib.SetInputValue('GGAHROABXW',function(){return WtH(w_DATAINI,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATAINI);
SPBOUILib.SetInputValue('JIUFPHLRLR',function(){return WtH(w_DATAFINE,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATAFINE);
SPBOUILib.SetInputValue('NXUMLWOVGN',function(){return WtH(w_xRagSoc,'C',70,0,'')},w_xRagSoc);
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
HideUI.lblids["CODINTER"]=['RNYYQBFCOW'];
HideUI.lblids["DATAFINE"]=['ITWFLEYCHC'];
HideUI.lblids["DATAINI"]=['QDMWRRAUML'];
function FPBSSVXDQL_Valid(e) {
SetActiveField(Ctrl('FPBSSVXDQL'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CODINTER','C',w_CODINTER,HtW(Ctrl('FPBSSVXDQL').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODINTER(HtW(Ctrl('FPBSSVXDQL').value,'C'),null,e);
return l_bSetResult;
}
}
function FPBSSVXDQL_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('FPBSSVXDQL'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('FPBSSVXDQL'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('FPBSSVXDQL'),e);
}
function FPBSSVXDQL_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('FPBSSVXDQL')),'linkview_FPBSSVXDQL','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function GGAHROABXW_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('GGAHROABXW'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('GGAHROABXW').value=ApplyPictureToDate(Ctrl('GGAHROABXW').value,TranslatePicture(datePattern),'GGAHROABXW');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('GGAHROABXW'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('GGAHROABXW');
}
}
}
SetActiveField(Ctrl('GGAHROABXW'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATAINI','D',w_DATAINI,HtW(Ctrl('GGAHROABXW').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATAINI(HtW(Ctrl('GGAHROABXW').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function GGAHROABXW_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('GGAHROABXW'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('GGAHROABXW',w_DATAINI,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('GGAHROABXW');
SetActiveField(Ctrl('GGAHROABXW'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('GGAHROABXW'),e);
}
function GGAHROABXW_ZOOM_Click() {
LaunchCalendar(Ctrl('GGAHROABXW'));
}
function JIUFPHLRLR_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('JIUFPHLRLR'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('JIUFPHLRLR').value=ApplyPictureToDate(Ctrl('JIUFPHLRLR').value,TranslatePicture(datePattern),'JIUFPHLRLR');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('JIUFPHLRLR'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('JIUFPHLRLR');
}
}
}
SetActiveField(Ctrl('JIUFPHLRLR'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATAFINE','D',w_DATAFINE,HtW(Ctrl('JIUFPHLRLR').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATAFINE(HtW(Ctrl('JIUFPHLRLR').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function JIUFPHLRLR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('JIUFPHLRLR'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('JIUFPHLRLR',w_DATAFINE,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('JIUFPHLRLR');
SetActiveField(Ctrl('JIUFPHLRLR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('JIUFPHLRLR'),e);
}
function JIUFPHLRLR_ZOOM_Click() {
LaunchCalendar(Ctrl('JIUFPHLRLR'));
}
function NXUMLWOVGN_Valid(e) {
SetActiveField(Ctrl('NXUMLWOVGN'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('xRagSoc','C',w_xRagSoc,HtW(Ctrl('NXUMLWOVGN').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_xRagSoc(HtW(Ctrl('NXUMLWOVGN').value,'C'),null,e);
return l_bSetResult;
}
}
function NXUMLWOVGN_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('NXUMLWOVGN'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('NXUMLWOVGN'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('NXUMLWOVGN'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function FPBSSVXDQL_wrap_Valid(event) {
return FPBSSVXDQL_Valid(event);
}
SPBOUILib.SetInputExit('FPBSSVXDQL',FPBSSVXDQL_wrap_Valid,SPBOUILib.Row.IN_GRID);
function FPBSSVXDQL_wrap_OnFocus(event) {
return FPBSSVXDQL_OnFocus(event);
}
SPBOUILib.SetInputEnter('FPBSSVXDQL',FPBSSVXDQL_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function FPBSSVXDQL_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('FPBSSVXDQL',FPBSSVXDQL_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function FPBSSVXDQL_ZOOM_setHandlers() {
function FPBSSVXDQL_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?FPBSSVXDQL_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('FPBSSVXDQL_ZOOM',FPBSSVXDQL_ZOOM_wrap_OnClick,SPBOUILib.Row.IN_GRID);
}
SPBOUILib.SetPicker('FPBSSVXDQL',FPBSSVXDQL_ZOOM_setHandlers);
function GGAHROABXW_wrap_Valid(event) {
return GGAHROABXW_Valid(event);
}
SPBOUILib.SetInputExit('GGAHROABXW',GGAHROABXW_wrap_Valid,SPBOUILib.Row.IN_GRID);
function GGAHROABXW_wrap_OnFocus(event) {
return GGAHROABXW_OnFocus(event);
}
SPBOUILib.SetInputEnter('GGAHROABXW',GGAHROABXW_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function GGAHROABXW_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('GGAHROABXW',GGAHROABXW_wrap_OnKeyPress,SPBOUILib.Row.IN_GRID);
function GGAHROABXW_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('GGAHROABXW',GGAHROABXW_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function GGAHROABXW_ZOOM_setHandlers() {
function GGAHROABXW_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?GGAHROABXW_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('GGAHROABXW_ZOOM',GGAHROABXW_ZOOM_wrap_OnClick,SPBOUILib.Row.IN_GRID);
}
SPBOUILib.SetPicker('GGAHROABXW',GGAHROABXW_ZOOM_setHandlers);
function JIUFPHLRLR_wrap_Valid(event) {
return JIUFPHLRLR_Valid(event);
}
SPBOUILib.SetInputExit('JIUFPHLRLR',JIUFPHLRLR_wrap_Valid,SPBOUILib.Row.IN_GRID);
function JIUFPHLRLR_wrap_OnFocus(event) {
return JIUFPHLRLR_OnFocus(event);
}
SPBOUILib.SetInputEnter('JIUFPHLRLR',JIUFPHLRLR_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function JIUFPHLRLR_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('JIUFPHLRLR',JIUFPHLRLR_wrap_OnKeyPress,SPBOUILib.Row.IN_GRID);
function JIUFPHLRLR_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('JIUFPHLRLR',JIUFPHLRLR_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function JIUFPHLRLR_ZOOM_setHandlers() {
function JIUFPHLRLR_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?JIUFPHLRLR_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('JIUFPHLRLR_ZOOM',JIUFPHLRLR_ZOOM_wrap_OnClick,SPBOUILib.Row.IN_GRID);
}
SPBOUILib.SetPicker('JIUFPHLRLR',JIUFPHLRLR_ZOOM_setHandlers);
function NXUMLWOVGN_wrap_Valid(event) {
return NXUMLWOVGN_Valid(event);
}
SPBOUILib.SetInputExit('NXUMLWOVGN',NXUMLWOVGN_wrap_Valid,SPBOUILib.Row.IN_GRID);
function NXUMLWOVGN_wrap_OnFocus(event) {
return NXUMLWOVGN_OnFocus(event);
}
SPBOUILib.SetInputEnter('NXUMLWOVGN',NXUMLWOVGN_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function NXUMLWOVGN_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('NXUMLWOVGN',NXUMLWOVGN_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
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
if (Eq(p_cEvent,'Init Row')) {
if (Ne(typeof(Calculation_UWBQFYRDAL),'undefined')) {
old_c=m_bCalculating;
m_bCalculating=true;
Calculation_UWBQFYRDAL();
m_bCalculating=old_c;
if ( ! (old_c)) {
DoUpdate(true);
}
}
}
}
function SetLastFocusedOnParent() {
if (IsWndAccessible(window['m_oFather'])) {
m_oFather.i_last_focused_item='child_ardt_jarantbo';
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
windowOpenForeground('../doc/ardt_jarantbo_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_RAPPORTO=a[0];
w_CODINTER=a[1];
w_DATAINI=a[2];
w_DATAFINE=a[3];
w_IDBASE=a[4];
w_xRagSoc=a[5];
m_PrimaryKeys=['CODINTER','RAPPORTO'];
}
function i_PrimaryKey() {
return 'jarantbo'+'\\'+CPLib.ToCPStr(w_RAPPORTO);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('ardt_jarantbo',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
function LinkZoomExtendedMenu() {
ExtendedMenu({"configName":WtA('','C'),"entityName":WtA('armt_personbo_age','C'),"fldValues":[{"expression":function() { return WtA(w_CODINTER,'C'); },"field":"CONNES","type":"C"},{"expression":function() { return WtA(w_xRagSoc,'C'); },"field":"RAGSOC","type":"C"}],"itemRepeated":true,"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('personbo','C'),"uid":"FPBSSVXDQL"});
}
function FocusFirstDetailComponent() {
var candidatesToFocus = ["FPBSSVXDQL"];
SetControlFocus(candidatesToFocus);
}
IsRepeatedChild.child=[];
function GetFullRowMsgError() {
return 'MSG_FULLROW_NOT_SAT';
}
_Obli('DATAINI',2,'GGAHROABXW',false,"45547614")
_Obli('CODINTER',0,'FPBSSVXDQL',false,"11330345786")
_Obli('DATAFINE',2,'JIUFPHLRLR',false,"1300662969")
_Obli('xRagSoc',0,'NXUMLWOVGN',false,"10662833243")
