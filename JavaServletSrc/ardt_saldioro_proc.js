function FillCombosValues() {
}
function FillInGridCombosValues(currentRow) {
var postfix = (Gt(currentRow,-1)?'_'+currentRow:'');
}
function SetControlsValue() {
var c;
if (Empty(m_cAltInterface) && (Eq(m_cFunction,'view') || Eq(m_cFunction,'query'))) {
} else {
SPBOUILib.SetInputValue('CLJEMHHSFZ',function(){return WtH(w_ANNO,'C',4,0,'')},w_ANNO);
SPBOUILib.SetInputValue('YHQQKXIFCH',function(){return WtH(w_IMPORTO3,'N',17,0,'99999999999999999')},w_IMPORTO3);
SPBOUILib.SetInputValue('PYSZKYPYUM',function(){return WtH(w_IMPORTO4,'N',17,0,'99999999999999999')},w_IMPORTO4);
SPBOUILib.SetInputValue('AVZSTYZUKM',function(){return WtH(w_IMPORTO5,'N',6,0,'999999')},w_IMPORTO5);
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
HideUI.lblids["ANNO"]=['UZOMVFGOWF'];
HideUI.lblids["IMPORTO3"]=['JHFGQEEDLK'];
HideUI.lblids["IMPORTO5"]=['ZLYKYZJBZM','BORCCLEQDE'];
function CLJEMHHSFZ_Valid(e) {
SetActiveField(Ctrl('CLJEMHHSFZ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('ANNO','C',w_ANNO,HtW(Ctrl('CLJEMHHSFZ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ANNO(HtW(Ctrl('CLJEMHHSFZ').value,'C'),null,e);
return l_bSetResult;
}
}
function CLJEMHHSFZ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('CLJEMHHSFZ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('CLJEMHHSFZ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('CLJEMHHSFZ'),e);
}
function YHQQKXIFCH_Valid(e) {
SetActiveField(Ctrl('YHQQKXIFCH'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('IMPORTO3','N',w_IMPORTO3,HtW(Ctrl('YHQQKXIFCH').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IMPORTO3(HtW(Ctrl('YHQQKXIFCH').value,'N'),null,e);
return l_bSetResult;
}
}
function YHQQKXIFCH_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('YHQQKXIFCH'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('YHQQKXIFCH',w_IMPORTO3,'N',17,0,'99999999999999999');
SetActiveField(Ctrl('YHQQKXIFCH'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('YHQQKXIFCH'),e);
}
function YHQQKXIFCH_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("99999999999999999"));
}
function PYSZKYPYUM_Valid(e) {
SetActiveField(Ctrl('PYSZKYPYUM'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('IMPORTO4','N',w_IMPORTO4,HtW(Ctrl('PYSZKYPYUM').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IMPORTO4(HtW(Ctrl('PYSZKYPYUM').value,'N'),null,e);
return l_bSetResult;
}
}
function PYSZKYPYUM_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('PYSZKYPYUM'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('PYSZKYPYUM',w_IMPORTO4,'N',17,0,'99999999999999999');
SetActiveField(Ctrl('PYSZKYPYUM'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('PYSZKYPYUM'),e);
}
function PYSZKYPYUM_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("99999999999999999"));
}
function AVZSTYZUKM_Valid(e) {
SetActiveField(Ctrl('AVZSTYZUKM'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('IMPORTO5','N',w_IMPORTO5,HtW(Ctrl('AVZSTYZUKM').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IMPORTO5(HtW(Ctrl('AVZSTYZUKM').value,'N'),null,e);
return l_bSetResult;
}
}
function AVZSTYZUKM_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('AVZSTYZUKM'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('AVZSTYZUKM',w_IMPORTO5,'N',6,0,'999999');
SetActiveField(Ctrl('AVZSTYZUKM'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('AVZSTYZUKM'),e);
}
function AVZSTYZUKM_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("999999"));
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function CLJEMHHSFZ_wrap_Valid(event) {
return CLJEMHHSFZ_Valid(event);
}
SPBOUILib.SetInputExit('CLJEMHHSFZ',CLJEMHHSFZ_wrap_Valid,SPBOUILib.Row.IN_GRID);
function CLJEMHHSFZ_wrap_OnFocus(event) {
return CLJEMHHSFZ_OnFocus(event);
}
SPBOUILib.SetInputEnter('CLJEMHHSFZ',CLJEMHHSFZ_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function CLJEMHHSFZ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('CLJEMHHSFZ',CLJEMHHSFZ_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function YHQQKXIFCH_wrap_Valid(event) {
return YHQQKXIFCH_Valid(event);
}
SPBOUILib.SetInputExit('YHQQKXIFCH',YHQQKXIFCH_wrap_Valid,SPBOUILib.Row.IN_GRID);
function YHQQKXIFCH_wrap_OnFocus(event) {
return YHQQKXIFCH_OnFocus(event);
}
SPBOUILib.SetInputEnter('YHQQKXIFCH',YHQQKXIFCH_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function YHQQKXIFCH_wrap_OnKeyPress(event) {
return YHQQKXIFCH_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('YHQQKXIFCH',YHQQKXIFCH_wrap_OnKeyPress,SPBOUILib.Row.IN_GRID);
function YHQQKXIFCH_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('YHQQKXIFCH',YHQQKXIFCH_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function PYSZKYPYUM_wrap_Valid(event) {
return PYSZKYPYUM_Valid(event);
}
SPBOUILib.SetInputExit('PYSZKYPYUM',PYSZKYPYUM_wrap_Valid,SPBOUILib.Row.IN_GRID);
function PYSZKYPYUM_wrap_OnFocus(event) {
return PYSZKYPYUM_OnFocus(event);
}
SPBOUILib.SetInputEnter('PYSZKYPYUM',PYSZKYPYUM_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function PYSZKYPYUM_wrap_OnKeyPress(event) {
return PYSZKYPYUM_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('PYSZKYPYUM',PYSZKYPYUM_wrap_OnKeyPress,SPBOUILib.Row.IN_GRID);
function PYSZKYPYUM_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('PYSZKYPYUM',PYSZKYPYUM_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function AVZSTYZUKM_wrap_Valid(event) {
return AVZSTYZUKM_Valid(event);
}
SPBOUILib.SetInputExit('AVZSTYZUKM',AVZSTYZUKM_wrap_Valid,SPBOUILib.Row.IN_GRID);
function AVZSTYZUKM_wrap_OnFocus(event) {
return AVZSTYZUKM_OnFocus(event);
}
SPBOUILib.SetInputEnter('AVZSTYZUKM',AVZSTYZUKM_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function AVZSTYZUKM_wrap_OnKeyPress(event) {
return AVZSTYZUKM_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('AVZSTYZUKM',AVZSTYZUKM_wrap_OnKeyPress,SPBOUILib.Row.IN_GRID);
function AVZSTYZUKM_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('AVZSTYZUKM',AVZSTYZUKM_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
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
m_oFather.i_last_focused_item='child_ardt_saldioro';
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
windowOpenForeground('../doc/ardt_saldioro_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_IDBASE=a[2];
w_IMPORTO3=a[3];
w_IMPORTO4=a[4];
w_IMPORTO5=a[5];
m_PrimaryKeys=['ANNO','RAPPORTO'];
}
function i_PrimaryKey() {
return 'saldioro'+'\\'+CPLib.ToCPStr(w_RAPPORTO);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('ardt_saldioro',m_cSelectedPage);
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
var candidatesToFocus = ["CLJEMHHSFZ"];
SetControlFocus(candidatesToFocus);
}
IsRepeatedChild.child=[];
function GetFullRowMsgError() {
return 'MSG_FULLROW_NOT_SAT';
}
_Obli('IMPORTO5',1,'AVZSTYZUKM',false,"1991862094")
_Obli('ANNO',0,'CLJEMHHSFZ',false,"965977510")
_Obli('IMPORTO3',1,'YHQQKXIFCH',false,"1991862092")
_Obli('IMPORTO4',1,'PYSZKYPYUM',false,"1991862093")
