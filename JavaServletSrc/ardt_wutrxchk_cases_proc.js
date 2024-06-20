function FillCombosValues() {
}
function FillInGridCombosValues(currentRow) {
var postfix = (Gt(currentRow,-1)?'_'+currentRow:'');
}
function SetControlsValue() {
var c;
if (Empty(m_cAltInterface) && (Eq(m_cFunction,'view') || Eq(m_cFunction,'query'))) {
SPBOUILib.SetInputValue('HSPDGFOCDU',function(){return WtH(w_WCDESCRI,'M',10,0,'')},w_WCDESCRI);
SPBOUILib.SetInputValue('DIXOZNRGCQ',function(){return WtH(w_WCBEHAVIOR,'M',10,0,'')},w_WCBEHAVIOR);
} else {
SPBOUILib.SetInputValue('KFGZLKSNHG',function(){return WtH(w_TRXCODCASE,'N',3,0,'999')},w_TRXCODCASE);
SPBOUILib.SetInputValue('NFWHJKGSUI',function(){return WtH(w_WCNOMCAS,'C',60,0,'')},w_WCNOMCAS);
SPBOUILib.SetInputValue('HSPDGFOCDU',function(){return WtH(w_WCDESCRI,'M',10,0,'')},w_WCDESCRI);
SPBOUILib.SetInputValue('DIXOZNRGCQ',function(){return WtH(w_WCBEHAVIOR,'M',10,0,'')},w_WCBEHAVIOR);
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
HideUI.lblids["TRXCODCASE"]=['ARPJBATHKQ'];
function KFGZLKSNHG_Valid(e) {
SetActiveField(Ctrl('KFGZLKSNHG'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TRXCODCASE','N',w_TRXCODCASE,HtW(Ctrl('KFGZLKSNHG').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRXCODCASE(HtW(Ctrl('KFGZLKSNHG').value,'N'),null,e);
return l_bSetResult;
}
}
function KFGZLKSNHG_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('KFGZLKSNHG'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('KFGZLKSNHG',w_TRXCODCASE,'N',3,0,'999');
SetActiveField(Ctrl('KFGZLKSNHG'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('KFGZLKSNHG'),e);
}
function KFGZLKSNHG_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("999"));
}
function KFGZLKSNHG_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('KFGZLKSNHG')),'linkview_KFGZLKSNHG','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function KFGZLKSNHG_wrap_Valid(event) {
return KFGZLKSNHG_Valid(event);
}
SPBOUILib.SetInputExit('KFGZLKSNHG',KFGZLKSNHG_wrap_Valid,SPBOUILib.Row.IN_GRID);
function KFGZLKSNHG_wrap_OnFocus(event) {
return KFGZLKSNHG_OnFocus(event);
}
SPBOUILib.SetInputEnter('KFGZLKSNHG',KFGZLKSNHG_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function KFGZLKSNHG_wrap_OnKeyPress(event) {
return KFGZLKSNHG_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('KFGZLKSNHG',KFGZLKSNHG_wrap_OnKeyPress,SPBOUILib.Row.IN_GRID);
function KFGZLKSNHG_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('KFGZLKSNHG',KFGZLKSNHG_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function KFGZLKSNHG_ZOOM_setHandlers() {
function KFGZLKSNHG_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?KFGZLKSNHG_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('KFGZLKSNHG_ZOOM',KFGZLKSNHG_ZOOM_wrap_OnClick,SPBOUILib.Row.IN_GRID);
}
SPBOUILib.SetPicker('KFGZLKSNHG',KFGZLKSNHG_ZOOM_setHandlers);
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
m_oFather.i_last_focused_item='child_ardt_wutrxchk_cases';
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
windowOpenForeground('../doc/ardt_wutrxchk_cases_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_TRXCODICE=a[0];
w_TRXCODCASE=a[1];
w_WCNOMCAS=a[2];
w_WCDESCRI=a[3];
w_WCBEHAVIOR=a[4];
m_PrimaryKeys=['TRXCODCASE','TRXCODICE'];
}
function i_PrimaryKey() {
return 'wutrxchk_cases'+'\\'+CPLib.ToCPStr(w_TRXCODICE);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('ardt_wutrxchk_cases',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
function LinkZoomExtendedMenu() {
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_TRXCODCASE,'N'); },"field":"WCCODICE","type":"N"},{"expression":function() { return WtA(w_WCNOMCAS,'C'); },"field":"WCNOMCAS","type":"C"},{"expression":function() { return WtA(w_WCDESCRI,'M'); },"field":"WCDESCRI","type":"M"},{"expression":function() { return WtA(w_WCBEHAVIOR,'M'); },"field":"WCBEHAVIOR","type":"M"}],"itemRepeated":true,"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('wu_cases','C'),"uid":"KFGZLKSNHG"});
}
function FocusFirstDetailComponent() {
var candidatesToFocus = ["KFGZLKSNHG"];
SetControlFocus(candidatesToFocus);
}
IsRepeatedChild.child=[];
function GetFullRowMsgError() {
return 'MSG_FULLROW_NOT_SAT';
}
_Obli('TRXCODCASE',1,'KFGZLKSNHG',false,"485715")
