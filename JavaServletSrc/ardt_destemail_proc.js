function FillCombosValues() {
}
function FillInGridCombosValues(currentRow) {
var postfix = (Gt(currentRow,-1)?'_'+currentRow:'');
}
function SetControlsValue() {
var c;
if (Empty(m_cAltInterface) && (Eq(m_cFunction,'view') || Eq(m_cFunction,'query'))) {
} else {
SPBOUILib.SetInputValue('EEOVPULSYY',function(){return WtH(w_DWNOMINATIVO,'C',50,0,'')},w_DWNOMINATIVO);
SPBOUILib.SetInputValue('HEMRMYCSDF',function(){return WtH(w_DWEMAIL,'C',50,0,'')},w_DWEMAIL);
if(c=Ctrl('UWSMVMXADD')) ChkboxCheckUncheck(c,'S',w_DWFLG380)
if(c=Ctrl('UWSMVMXADD')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('XINJTBPEIF')) ChkboxCheckUncheck(c,'S',w_DWFLGVLT)
if(c=Ctrl('XINJTBPEIF')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('NSWYEBUSXD')) ChkboxCheckUncheck(c,'S',w_DWFLGQADV)
if(c=Ctrl('NSWYEBUSXD')) ChkboxValueAssign(c,'S','N','C',1,0,'')
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
HideUI.lblids["DWEMAIL"]=['YDFAFGEYQN'];
HideUI.lblids["DWNOMINATIVO"]=['FKKOVAHNDF'];
function EEOVPULSYY_Valid(e) {
SetActiveField(Ctrl('EEOVPULSYY'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DWNOMINATIVO','C',w_DWNOMINATIVO,HtW(Ctrl('EEOVPULSYY').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DWNOMINATIVO(HtW(Ctrl('EEOVPULSYY').value,'C'),null,e);
return l_bSetResult;
}
}
function EEOVPULSYY_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('EEOVPULSYY'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('EEOVPULSYY'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('EEOVPULSYY'),e);
}
function HEMRMYCSDF_Valid(e) {
SetActiveField(Ctrl('HEMRMYCSDF'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DWEMAIL','C',w_DWEMAIL,HtW(Ctrl('HEMRMYCSDF').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DWEMAIL(HtW(Ctrl('HEMRMYCSDF').value,'C'),null,e);
return l_bSetResult;
}
}
function HEMRMYCSDF_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('HEMRMYCSDF'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('HEMRMYCSDF'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('HEMRMYCSDF'),e);
}
function UWSMVMXADD_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('DWFLG380','C',w_DWFLG380,ChkboxValueAssign(Ctrl('UWSMVMXADD'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DWFLG380(ChkboxValueAssign(Ctrl('UWSMVMXADD'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function UWSMVMXADD_OnFocus(e) {
SetActiveField(Ctrl('UWSMVMXADD'),true);
}
function UWSMVMXADD_OnBlur(e) {
SetActiveField(Ctrl('UWSMVMXADD'),false);
}
function XINJTBPEIF_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('DWFLGVLT','C',w_DWFLGVLT,ChkboxValueAssign(Ctrl('XINJTBPEIF'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DWFLGVLT(ChkboxValueAssign(Ctrl('XINJTBPEIF'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function XINJTBPEIF_OnFocus(e) {
SetActiveField(Ctrl('XINJTBPEIF'),true);
}
function XINJTBPEIF_OnBlur(e) {
SetActiveField(Ctrl('XINJTBPEIF'),false);
}
function NSWYEBUSXD_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('DWFLGQADV','C',w_DWFLGQADV,ChkboxValueAssign(Ctrl('NSWYEBUSXD'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DWFLGQADV(ChkboxValueAssign(Ctrl('NSWYEBUSXD'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function NSWYEBUSXD_OnFocus(e) {
SetActiveField(Ctrl('NSWYEBUSXD'),true);
}
function NSWYEBUSXD_OnBlur(e) {
SetActiveField(Ctrl('NSWYEBUSXD'),false);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function EEOVPULSYY_wrap_Valid(event) {
return EEOVPULSYY_Valid(event);
}
SPBOUILib.SetInputExit('EEOVPULSYY',EEOVPULSYY_wrap_Valid,SPBOUILib.Row.IN_GRID);
function EEOVPULSYY_wrap_OnFocus(event) {
return EEOVPULSYY_OnFocus(event);
}
SPBOUILib.SetInputEnter('EEOVPULSYY',EEOVPULSYY_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function EEOVPULSYY_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('EEOVPULSYY',EEOVPULSYY_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function HEMRMYCSDF_wrap_Valid(event) {
return HEMRMYCSDF_Valid(event);
}
SPBOUILib.SetInputExit('HEMRMYCSDF',HEMRMYCSDF_wrap_Valid,SPBOUILib.Row.IN_GRID);
function HEMRMYCSDF_wrap_OnFocus(event) {
return HEMRMYCSDF_OnFocus(event);
}
SPBOUILib.SetInputEnter('HEMRMYCSDF',HEMRMYCSDF_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function HEMRMYCSDF_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('HEMRMYCSDF',HEMRMYCSDF_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function UWSMVMXADD_wrap_Valid(event) {
return UWSMVMXADD_Valid(event);
}
SPBOUILib.SetCheckboxClick('UWSMVMXADD',UWSMVMXADD_wrap_Valid,SPBOUILib.Row.IN_GRID);
function UWSMVMXADD_wrap_OnFocus(event) {
return UWSMVMXADD_OnFocus(event);
}
SPBOUILib.SetInputEnter('UWSMVMXADD',UWSMVMXADD_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function UWSMVMXADD_wrap_Blur(event) {
return UWSMVMXADD_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('UWSMVMXADD',UWSMVMXADD_wrap_Blur,SPBOUILib.Row.IN_GRID);
function XINJTBPEIF_wrap_Valid(event) {
return XINJTBPEIF_Valid(event);
}
SPBOUILib.SetCheckboxClick('XINJTBPEIF',XINJTBPEIF_wrap_Valid,SPBOUILib.Row.IN_GRID);
function XINJTBPEIF_wrap_OnFocus(event) {
return XINJTBPEIF_OnFocus(event);
}
SPBOUILib.SetInputEnter('XINJTBPEIF',XINJTBPEIF_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function XINJTBPEIF_wrap_Blur(event) {
return XINJTBPEIF_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('XINJTBPEIF',XINJTBPEIF_wrap_Blur,SPBOUILib.Row.IN_GRID);
function NSWYEBUSXD_wrap_Valid(event) {
return NSWYEBUSXD_Valid(event);
}
SPBOUILib.SetCheckboxClick('NSWYEBUSXD',NSWYEBUSXD_wrap_Valid,SPBOUILib.Row.IN_GRID);
function NSWYEBUSXD_wrap_OnFocus(event) {
return NSWYEBUSXD_OnFocus(event);
}
SPBOUILib.SetInputEnter('NSWYEBUSXD',NSWYEBUSXD_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function NSWYEBUSXD_wrap_Blur(event) {
return NSWYEBUSXD_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('NSWYEBUSXD',NSWYEBUSXD_wrap_Blur,SPBOUILib.Row.IN_GRID);
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
m_oFather.i_last_focused_item='child_ardt_destemail';
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
windowOpenForeground('../doc/ardt_destemail_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_DWCODINT=a[0];
w_DWNOMINATIVO=a[1];
w_DWEMAIL=a[2];
w_CPROWNUM=a[3];
w_DWFLG380=a[4];
w_DWFLGVLT=a[5];
w_DWFLGQADV=a[6];
m_PrimaryKeys=['CPROWNUM','DWCODINT'];
}
function i_PrimaryKey() {
return 'destwarn'+'\\'+CPLib.ToCPStr(w_DWCODINT);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('ardt_destemail',m_cSelectedPage);
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
var candidatesToFocus = ["EEOVPULSYY"];
SetControlFocus(candidatesToFocus);
}
IsRepeatedChild.child=[];
function GetFullRowMsgError() {
return 'MSG_FULLROW_NOT_SAT';
}
_Obli('DWEMAIL',0,'HEMRMYCSDF',false,"521881905")
_Obli('DWNOMINATIVO',0,'EEOVPULSYY',false,"176491428")
_Obli('DWFLGQADV',0,'NSWYEBUSXD',false,"12043203661")
_Obli('DWFLG380',0,'UWSMVMXADD',false,"995569501")
_Obli('DWFLGVLT',0,'XINJTBPEIF',false,"11853411491")
