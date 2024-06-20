function FillCombosValues() {
}
function FillInGridCombosValues(currentRow) {
var postfix = (Gt(currentRow,-1)?'_'+currentRow:'');
}
function SetControlsValue() {
var c;
if (Empty(m_cAltInterface) && (Eq(m_cFunction,'view') || Eq(m_cFunction,'query'))) {
} else {
SPBOUILib.SetInputValue('MDAZAECEFB',function(){return WtH(w_CODICE,'C',10,0,'')},w_CODICE);
SPBOUILib.SetInputValue('BQZNEAYMQQ',function(){return WtH(w_IMPEFF,'N',19,2,'999,999,999,999.99')},w_IMPEFF);
SPBOUILib.SetInputValue('KDPPHIXGCO',function(){return WtH(w_RISCHIO,'N',3,0,'999')},w_RISCHIO);
SPBOUILib.SetInputValue('EQFEXBKZWY',function(){return WtH(w_ANNO,'N',4,0,'')},w_ANNO);
SPBOUILib.SetInputValue('XIPADAGXBM',function(){return WtH(w_xDESCRI,'C',150,0,'')},w_xDESCRI);
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
HideUI.lblids["CODICE"]=['ROOLXCXTTR','GIFUGCXACS'];
HideUI.lblids["IMPEFF"]=['JYAEIBNTCH'];
HideUI.lblids["RISCHIO"]=['NIAWCWJCRY'];
function MDAZAECEFB_Valid(e) {
SetActiveField(Ctrl('MDAZAECEFB'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CODICE','C',w_CODICE,HtW(Ctrl('MDAZAECEFB').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODICE(HtW(Ctrl('MDAZAECEFB').value,'C'),null,e);
return l_bSetResult;
}
}
function MDAZAECEFB_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('MDAZAECEFB'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('MDAZAECEFB'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('MDAZAECEFB'),e);
}
function MDAZAECEFB_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('MDAZAECEFB')),'linkview_MDAZAECEFB','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function BQZNEAYMQQ_Valid(e) {
SetActiveField(Ctrl('BQZNEAYMQQ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('IMPEFF','N',w_IMPEFF,HtW(Ctrl('BQZNEAYMQQ').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IMPEFF(HtW(Ctrl('BQZNEAYMQQ').value,'N'),null,e);
return l_bSetResult;
}
}
function BQZNEAYMQQ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('BQZNEAYMQQ'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('BQZNEAYMQQ',w_IMPEFF,'N',19,2,'999999999999.99');
SetActiveField(Ctrl('BQZNEAYMQQ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('BQZNEAYMQQ'),e);
}
function BQZNEAYMQQ_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("999999999999.99"));
}
function KDPPHIXGCO_Valid(e) {
SetActiveField(Ctrl('KDPPHIXGCO'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('RISCHIO','N',w_RISCHIO,HtW(Ctrl('KDPPHIXGCO').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_RISCHIO(HtW(Ctrl('KDPPHIXGCO').value,'N'),null,e);
return l_bSetResult;
}
}
function KDPPHIXGCO_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('KDPPHIXGCO'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('KDPPHIXGCO',w_RISCHIO,'N',3,0,'999');
SetActiveField(Ctrl('KDPPHIXGCO'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('KDPPHIXGCO'),e);
}
function KDPPHIXGCO_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("999"));
}
function EQFEXBKZWY_Valid(e) {
SetActiveField(Ctrl('EQFEXBKZWY'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('ANNO','N',w_ANNO,HtW(Ctrl('EQFEXBKZWY').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ANNO(HtW(Ctrl('EQFEXBKZWY').value,'N'),null,e);
return l_bSetResult;
}
}
function EQFEXBKZWY_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('EQFEXBKZWY'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('EQFEXBKZWY'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('EQFEXBKZWY'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function MDAZAECEFB_wrap_Valid(event) {
return MDAZAECEFB_Valid(event);
}
SPBOUILib.SetInputExit('MDAZAECEFB',MDAZAECEFB_wrap_Valid,SPBOUILib.Row.IN_GRID);
function MDAZAECEFB_wrap_OnFocus(event) {
return MDAZAECEFB_OnFocus(event);
}
SPBOUILib.SetInputEnter('MDAZAECEFB',MDAZAECEFB_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function MDAZAECEFB_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('MDAZAECEFB',MDAZAECEFB_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function MDAZAECEFB_ZOOM_setHandlers() {
function MDAZAECEFB_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?MDAZAECEFB_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('MDAZAECEFB_ZOOM',MDAZAECEFB_ZOOM_wrap_OnClick,SPBOUILib.Row.IN_GRID);
}
SPBOUILib.SetPicker('MDAZAECEFB',MDAZAECEFB_ZOOM_setHandlers);
function BQZNEAYMQQ_wrap_Valid(event) {
return BQZNEAYMQQ_Valid(event);
}
SPBOUILib.SetInputExit('BQZNEAYMQQ',BQZNEAYMQQ_wrap_Valid,SPBOUILib.Row.IN_GRID);
function BQZNEAYMQQ_wrap_OnFocus(event) {
return BQZNEAYMQQ_OnFocus(event);
}
SPBOUILib.SetInputEnter('BQZNEAYMQQ',BQZNEAYMQQ_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function BQZNEAYMQQ_wrap_OnKeyPress(event) {
return BQZNEAYMQQ_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('BQZNEAYMQQ',BQZNEAYMQQ_wrap_OnKeyPress,SPBOUILib.Row.IN_GRID);
function BQZNEAYMQQ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('BQZNEAYMQQ',BQZNEAYMQQ_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function KDPPHIXGCO_wrap_Valid(event) {
return KDPPHIXGCO_Valid(event);
}
SPBOUILib.SetInputExit('KDPPHIXGCO',KDPPHIXGCO_wrap_Valid,SPBOUILib.Row.IN_GRID);
function KDPPHIXGCO_wrap_OnFocus(event) {
return KDPPHIXGCO_OnFocus(event);
}
SPBOUILib.SetInputEnter('KDPPHIXGCO',KDPPHIXGCO_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function KDPPHIXGCO_wrap_OnKeyPress(event) {
return KDPPHIXGCO_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('KDPPHIXGCO',KDPPHIXGCO_wrap_OnKeyPress,SPBOUILib.Row.IN_GRID);
function KDPPHIXGCO_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('KDPPHIXGCO',KDPPHIXGCO_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function EQFEXBKZWY_wrap_Valid(event) {
return EQFEXBKZWY_Valid(event);
}
SPBOUILib.SetInputExit('EQFEXBKZWY',EQFEXBKZWY_wrap_Valid,SPBOUILib.Row.IN_GRID);
function EQFEXBKZWY_wrap_OnFocus(event) {
return EQFEXBKZWY_OnFocus(event);
}
SPBOUILib.SetInputEnter('EQFEXBKZWY',EQFEXBKZWY_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function EQFEXBKZWY_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('EQFEXBKZWY',EQFEXBKZWY_wrap_OnKeyPress,SPBOUILib.Row.IN_GRID);
function EQFEXBKZWY_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('EQFEXBKZWY',EQFEXBKZWY_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
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
if (Ne(typeof(Calculation_JPLJTSXCMQ),'undefined')) {
old_c=m_bCalculating;
m_bCalculating=true;
Calculation_JPLJTSXCMQ();
m_bCalculating=old_c;
if ( ! (old_c)) {
DoUpdate(true);
}
}
}
}
function SetLastFocusedOnParent() {
if (IsWndAccessible(window['m_oFather'])) {
m_oFather.i_last_focused_item='child_ardt_patrimonio';
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
windowOpenForeground('../doc/ardt_patrimonio_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_CODICE=a[1];
w_IMPEFF=a[2];
w_RISCHIO=a[3];
w_ANNO=a[4];
w_IDBASE=a[5];
w_xDESCRI=a[6];
m_PrimaryKeys=['ANNO','CONNES'];
}
function i_PrimaryKey() {
return 'patrimonio'+'\\'+CPLib.ToCPStr(w_CONNES);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('ardt_patrimonio',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
function LinkZoomExtendedMenu() {
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_CODICE,'C'); },"field":"CODICE","type":"C"},{"expression":function() { return WtA(w_xDESCRI,'C'); },"field":"DESCRI","type":"C"},{"expression":function() { return WtA(w_RISCHIO,'N'); },"field":"RISCHIO","type":"N"}],"itemRepeated":true,"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbfascepr','C'),"uid":"MDAZAECEFB"});
}
function FocusFirstDetailComponent() {
var candidatesToFocus = ["MDAZAECEFB"];
SetControlFocus(candidatesToFocus);
}
IsRepeatedChild.child=[];
function GetFullRowMsgError() {
return 'MSG_FULLROW_NOT_SAT';
}
_Obli('RISCHIO',1,'KDPPHIXGCO',false,"1979623906")
_Obli('CODICE',0,'MDAZAECEFB',false,"112851763")
_Obli('IMPEFF',1,'BQZNEAYMQQ',false,"1991862041")
_Obli('ANNO',1,'EQFEXBKZWY',false,"965977510")
