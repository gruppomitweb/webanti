function FillCombosValues() {
}
function FillInGridCombosValues(currentRow) {
var postfix = (Gt(currentRow,-1)?'_'+currentRow:'');
}
function SetControlsValue() {
var c;
if (Empty(m_cAltInterface) && (Eq(m_cFunction,'view') || Eq(m_cFunction,'query'))) {
} else {
SPBOUILib.SetInputValue('NZYBVMRJHR',function(){return WtH(w_company,'C',10,0,'')},w_company);
SPBOUILib.SetInputValue('QPGPPFLICI',function(){return WtH(w_datestart,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_datestart);
SPBOUILib.SetInputValue('QSOCWOMGGI',function(){return WtH(w_datestop,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_datestop);
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
function NZYBVMRJHR_Valid(e) {
SetActiveField(Ctrl('NZYBVMRJHR'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('company','C',w_company,HtW(Ctrl('NZYBVMRJHR').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_company(HtW(Ctrl('NZYBVMRJHR').value,'C'),null,e);
return l_bSetResult;
}
}
function NZYBVMRJHR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('NZYBVMRJHR'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('NZYBVMRJHR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('NZYBVMRJHR'),e);
}
function QPGPPFLICI_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('QPGPPFLICI'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('QPGPPFLICI').value=ApplyPictureToDate(Ctrl('QPGPPFLICI').value,TranslatePicture(datePattern),'QPGPPFLICI');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('QPGPPFLICI'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('QPGPPFLICI');
}
}
}
SetActiveField(Ctrl('QPGPPFLICI'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('datestart','D',w_datestart,HtW(Ctrl('QPGPPFLICI').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_datestart(HtW(Ctrl('QPGPPFLICI').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function QPGPPFLICI_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('QPGPPFLICI'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('QPGPPFLICI',w_datestart,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('QPGPPFLICI');
SetActiveField(Ctrl('QPGPPFLICI'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('QPGPPFLICI'),e);
}
function QPGPPFLICI_ZOOM_Click() {
LaunchCalendar(Ctrl('QPGPPFLICI'));
}
function QSOCWOMGGI_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('QSOCWOMGGI'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('QSOCWOMGGI').value=ApplyPictureToDate(Ctrl('QSOCWOMGGI').value,TranslatePicture(datePattern),'QSOCWOMGGI');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('QSOCWOMGGI'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('QSOCWOMGGI');
}
}
}
SetActiveField(Ctrl('QSOCWOMGGI'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('datestop','D',w_datestop,HtW(Ctrl('QSOCWOMGGI').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_datestop(HtW(Ctrl('QSOCWOMGGI').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function QSOCWOMGGI_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('QSOCWOMGGI'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('QSOCWOMGGI',w_datestop,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('QSOCWOMGGI');
SetActiveField(Ctrl('QSOCWOMGGI'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('QSOCWOMGGI'),e);
}
function QSOCWOMGGI_ZOOM_Click() {
LaunchCalendar(Ctrl('QSOCWOMGGI'));
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function NZYBVMRJHR_wrap_Valid(event) {
return NZYBVMRJHR_Valid(event);
}
SPBOUILib.SetInputExit('NZYBVMRJHR',NZYBVMRJHR_wrap_Valid,SPBOUILib.Row.IN_GRID);
function NZYBVMRJHR_wrap_OnFocus(event) {
return NZYBVMRJHR_OnFocus(event);
}
SPBOUILib.SetInputEnter('NZYBVMRJHR',NZYBVMRJHR_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function NZYBVMRJHR_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('NZYBVMRJHR',NZYBVMRJHR_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function QPGPPFLICI_wrap_Valid(event) {
return QPGPPFLICI_Valid(event);
}
SPBOUILib.SetInputExit('QPGPPFLICI',QPGPPFLICI_wrap_Valid,SPBOUILib.Row.IN_GRID);
function QPGPPFLICI_wrap_OnFocus(event) {
return QPGPPFLICI_OnFocus(event);
}
SPBOUILib.SetInputEnter('QPGPPFLICI',QPGPPFLICI_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function QPGPPFLICI_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('QPGPPFLICI',QPGPPFLICI_wrap_OnKeyPress,SPBOUILib.Row.IN_GRID);
function QPGPPFLICI_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('QPGPPFLICI',QPGPPFLICI_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function QPGPPFLICI_ZOOM_setHandlers() {
function QPGPPFLICI_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?QPGPPFLICI_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('QPGPPFLICI_ZOOM',QPGPPFLICI_ZOOM_wrap_OnClick,SPBOUILib.Row.IN_GRID);
}
SPBOUILib.SetPicker('QPGPPFLICI',QPGPPFLICI_ZOOM_setHandlers);
function QSOCWOMGGI_wrap_Valid(event) {
return QSOCWOMGGI_Valid(event);
}
SPBOUILib.SetInputExit('QSOCWOMGGI',QSOCWOMGGI_wrap_Valid,SPBOUILib.Row.IN_GRID);
function QSOCWOMGGI_wrap_OnFocus(event) {
return QSOCWOMGGI_OnFocus(event);
}
SPBOUILib.SetInputEnter('QSOCWOMGGI',QSOCWOMGGI_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function QSOCWOMGGI_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('QSOCWOMGGI',QSOCWOMGGI_wrap_OnKeyPress,SPBOUILib.Row.IN_GRID);
function QSOCWOMGGI_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('QSOCWOMGGI',QSOCWOMGGI_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function QSOCWOMGGI_ZOOM_setHandlers() {
function QSOCWOMGGI_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?QSOCWOMGGI_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('QSOCWOMGGI_ZOOM',QSOCWOMGGI_ZOOM_wrap_OnClick,SPBOUILib.Row.IN_GRID);
}
SPBOUILib.SetPicker('QSOCWOMGGI',QSOCWOMGGI_ZOOM_setHandlers);
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
m_oFather.i_last_focused_item='child_spadministration_usercompanies';
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
windowOpenForeground('../doc/spadministration_usercompanies_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_usercode=a[0];
w_company=a[1];
w_datestart=a[2];
w_datestop=a[3];
m_PrimaryKeys=['usercode'];
}
function i_PrimaryKey() {
return 'cpusrazi'+'\\'+CPLib.ToCPStr(w_usercode);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('spadministration_usercompanies',m_cSelectedPage);
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
function FocusFirstDetailComponent() {
var candidatesToFocus = ["NZYBVMRJHR"];
SetControlFocus(candidatesToFocus);
}
IsRepeatedChild.child=[];
function GetFullRowMsgError() {
return 'MSG_FULLROW_NOT_SAT';
}
_Obli('company',0,'NZYBVMRJHR',false,"966854606")
_Obli('datestart',2,'QPGPPFLICI',false,"20009153")
_Obli('datestop',2,'QSOCWOMGGI',false,"556515051")
