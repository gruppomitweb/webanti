function FillCombosValues() {
}
function FillInGridCombosValues(currentRow) {
var postfix = (Gt(currentRow,-1)?'_'+currentRow:'');
}
function SetControlsValue() {
var c;
if (Empty(m_cAltInterface) && (Eq(m_cFunction,'view') || Eq(m_cFunction,'query'))) {
} else {
SPBOUILib.SetInputValue('JYXMPQWGBF',function(){return WtH(w_ANNO,'C',4,0,'')},w_ANNO);
if(c=Ctrl('GCTHIIEEAW')) selectCombo(c,w_TRIMESTRE,'C')
SPBOUILib.SetInputValue('NGEQBBYMQU',function(){return WtH(w_IMPORTO,'N',15,2,'999,999,999,999.99')},w_IMPORTO);
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
HideUI.lblids["ANNO"]=['AWTZSRWNJW'];
HideUI.lblids["IMPORTO"]=['SQQUPXUJZT'];
HideUI.lblids["TRIMESTRE"]=['UVCMUNVZES'];
function JYXMPQWGBF_Valid(e) {
SetActiveField(Ctrl('JYXMPQWGBF'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('ANNO','C',w_ANNO,HtW(Ctrl('JYXMPQWGBF').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ANNO(HtW(Ctrl('JYXMPQWGBF').value,'C'),null,e);
return l_bSetResult;
}
}
function JYXMPQWGBF_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('JYXMPQWGBF'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('JYXMPQWGBF'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('JYXMPQWGBF'),e);
}
function GCTHIIEEAW_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('TRIMESTRE','C',w_TRIMESTRE,HtW(getComboValue(Ctrl('GCTHIIEEAW')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRIMESTRE(HtW(getComboValue(Ctrl('GCTHIIEEAW')),'C'),null,e);
return l_bSetResult;
}
}
function GCTHIIEEAW_OnFocus(e) {
SetActiveField(Ctrl('GCTHIIEEAW'),true);
}
function GCTHIIEEAW_OnBlur(e) {
SetActiveField(Ctrl('GCTHIIEEAW'),false);
}
function NGEQBBYMQU_Valid(e) {
SetActiveField(Ctrl('NGEQBBYMQU'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('IMPORTO','N',w_IMPORTO,HtW(Ctrl('NGEQBBYMQU').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IMPORTO(HtW(Ctrl('NGEQBBYMQU').value,'N'),null,e);
return l_bSetResult;
}
}
function NGEQBBYMQU_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('NGEQBBYMQU'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('NGEQBBYMQU',w_IMPORTO,'N',15,2,'999999999999.99');
SetActiveField(Ctrl('NGEQBBYMQU'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('NGEQBBYMQU'),e);
}
function NGEQBBYMQU_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("999999999999.99"));
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function JYXMPQWGBF_wrap_Valid(event) {
return JYXMPQWGBF_Valid(event);
}
SPBOUILib.SetInputExit('JYXMPQWGBF',JYXMPQWGBF_wrap_Valid,SPBOUILib.Row.IN_GRID);
function JYXMPQWGBF_wrap_OnFocus(event) {
return JYXMPQWGBF_OnFocus(event);
}
SPBOUILib.SetInputEnter('JYXMPQWGBF',JYXMPQWGBF_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function JYXMPQWGBF_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('JYXMPQWGBF',JYXMPQWGBF_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function GCTHIIEEAW_wrap_Valid(event) {
return GCTHIIEEAW_Valid(event);
}
SPBOUILib.SetComboChange('GCTHIIEEAW',GCTHIIEEAW_wrap_Valid,SPBOUILib.Row.IN_GRID);
function GCTHIIEEAW_wrap_OnFocus(event) {
return GCTHIIEEAW_OnFocus(event);
}
SPBOUILib.SetInputEnter('GCTHIIEEAW',GCTHIIEEAW_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function GCTHIIEEAW_wrap_Blur(event) {
return GCTHIIEEAW_OnBlur(event);
}
SPBOUILib.SetInputExit('GCTHIIEEAW',GCTHIIEEAW_wrap_Blur,SPBOUILib.Row.IN_GRID);
function NGEQBBYMQU_wrap_Valid(event) {
return NGEQBBYMQU_Valid(event);
}
SPBOUILib.SetInputExit('NGEQBBYMQU',NGEQBBYMQU_wrap_Valid,SPBOUILib.Row.IN_GRID);
function NGEQBBYMQU_wrap_OnFocus(event) {
return NGEQBBYMQU_OnFocus(event);
}
SPBOUILib.SetInputEnter('NGEQBBYMQU',NGEQBBYMQU_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function NGEQBBYMQU_wrap_OnKeyPress(event) {
return NGEQBBYMQU_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('NGEQBBYMQU',NGEQBBYMQU_wrap_OnKeyPress,SPBOUILib.Row.IN_GRID);
function NGEQBBYMQU_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('NGEQBBYMQU',NGEQBBYMQU_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
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
m_oFather.i_last_focused_item='child_ardt_saldi_idp';
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
windowOpenForeground('../doc/ardt_saldi_idp_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_ANNO=a[1];
w_TRIMESTRE=a[2];
w_IMPORTO=a[3];
w_IDBASE=a[4];
m_PrimaryKeys=['TRIMESTRE','ANNO','RAPPORTO'];
}
function i_PrimaryKey() {
return 'saldi_idp'+'\\'+CPLib.ToCPStr(w_RAPPORTO);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('ardt_saldi_idp',m_cSelectedPage);
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
var candidatesToFocus = ["JYXMPQWGBF"];
SetControlFocus(candidatesToFocus);
}
IsRepeatedChild.child=[];
function GetFullRowMsgError() {
return 'MSG_FULLROW_NOT_SAT';
}
_Obli('TRIMESTRE',0,'GCTHIIEEAW',false,"11684258599")
_Obli('ANNO',0,'JYXMPQWGBF',false,"484641")
_Obli('IMPORTO',1,'NGEQBBYMQU',false,"1991862041")
