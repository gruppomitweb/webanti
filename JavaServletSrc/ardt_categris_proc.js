function FillCombosValues() {
}
function FillInGridCombosValues(currentRow) {
var postfix = (Gt(currentRow,-1)?'_'+currentRow:'');
}
function SetControlsValue() {
var c;
if (Empty(m_cAltInterface) && (Eq(m_cFunction,'view') || Eq(m_cFunction,'query'))) {
} else {
SPBOUILib.SetInputValue('EQQSGWXFEN',function(){return WtH(w_CODICE,'C',3,0,'')},w_CODICE);
SPBOUILib.SetInputValue('DMQNJHYOOO',function(){return WtH(w_GIORNI,'N',5,0,'99999')},w_GIORNI);
SPBOUILib.SetInputValue('CNUURRFRMI',function(){return WtH(w_xDESCRI,'C',150,0,'')},w_xDESCRI);
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
function href_FHZSFWPOHS() {
arrt_recupera_tbrisglob([["pObj",this]])
}
function EQQSGWXFEN_Valid(e) {
SetActiveField(Ctrl('EQQSGWXFEN'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CODICE','C',w_CODICE,HtW(Ctrl('EQQSGWXFEN').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODICE(HtW(Ctrl('EQQSGWXFEN').value,'C'),null,e);
return l_bSetResult;
}
}
function EQQSGWXFEN_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('EQQSGWXFEN'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('EQQSGWXFEN'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('EQQSGWXFEN'),e);
}
function EQQSGWXFEN_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('EQQSGWXFEN')),'linkview_EQQSGWXFEN','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function DMQNJHYOOO_Valid(e) {
SetActiveField(Ctrl('DMQNJHYOOO'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('GIORNI','N',w_GIORNI,HtW(Ctrl('DMQNJHYOOO').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_GIORNI(HtW(Ctrl('DMQNJHYOOO').value,'N'),null,e);
return l_bSetResult;
}
}
function DMQNJHYOOO_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('DMQNJHYOOO'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('DMQNJHYOOO',w_GIORNI,'N',5,0,'99999');
SetActiveField(Ctrl('DMQNJHYOOO'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('DMQNJHYOOO'),e);
}
function DMQNJHYOOO_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("99999"));
}
function CNUURRFRMI_Valid(e) {
SetActiveField(Ctrl('CNUURRFRMI'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('xDESCRI','C',w_xDESCRI,HtW(Ctrl('CNUURRFRMI').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_xDESCRI(HtW(Ctrl('CNUURRFRMI').value,'C'),null,e);
return l_bSetResult;
}
}
function CNUURRFRMI_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('CNUURRFRMI'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('CNUURRFRMI'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('CNUURRFRMI'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
function FHZSFWPOHS_wrap_OnClick(event) {
return href_FHZSFWPOHS();
}
SPBOUILib.SetLabelClick('FHZSFWPOHS',FHZSFWPOHS_wrap_OnClick);
function FHZSFWPOHS_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetLabelKeyDown('FHZSFWPOHS',FHZSFWPOHS_wrap_OnKeyDown);
if (Ne(m_cFunction,'view')) {
function EQQSGWXFEN_wrap_Valid(event) {
return EQQSGWXFEN_Valid(event);
}
SPBOUILib.SetInputExit('EQQSGWXFEN',EQQSGWXFEN_wrap_Valid,SPBOUILib.Row.IN_GRID);
function EQQSGWXFEN_wrap_OnFocus(event) {
return EQQSGWXFEN_OnFocus(event);
}
SPBOUILib.SetInputEnter('EQQSGWXFEN',EQQSGWXFEN_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function EQQSGWXFEN_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('EQQSGWXFEN',EQQSGWXFEN_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function EQQSGWXFEN_ZOOM_setHandlers() {
function EQQSGWXFEN_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?EQQSGWXFEN_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('EQQSGWXFEN_ZOOM',EQQSGWXFEN_ZOOM_wrap_OnClick,SPBOUILib.Row.IN_GRID);
}
SPBOUILib.SetPicker('EQQSGWXFEN',EQQSGWXFEN_ZOOM_setHandlers);
function DMQNJHYOOO_wrap_Valid(event) {
return DMQNJHYOOO_Valid(event);
}
SPBOUILib.SetInputExit('DMQNJHYOOO',DMQNJHYOOO_wrap_Valid,SPBOUILib.Row.IN_GRID);
function DMQNJHYOOO_wrap_OnFocus(event) {
return DMQNJHYOOO_OnFocus(event);
}
SPBOUILib.SetInputEnter('DMQNJHYOOO',DMQNJHYOOO_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function DMQNJHYOOO_wrap_OnKeyPress(event) {
return DMQNJHYOOO_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('DMQNJHYOOO',DMQNJHYOOO_wrap_OnKeyPress,SPBOUILib.Row.IN_GRID);
function DMQNJHYOOO_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('DMQNJHYOOO',DMQNJHYOOO_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function CNUURRFRMI_wrap_Valid(event) {
return CNUURRFRMI_Valid(event);
}
SPBOUILib.SetInputExit('CNUURRFRMI',CNUURRFRMI_wrap_Valid,SPBOUILib.Row.IN_GRID);
function CNUURRFRMI_wrap_OnFocus(event) {
return CNUURRFRMI_OnFocus(event);
}
SPBOUILib.SetInputEnter('CNUURRFRMI',CNUURRFRMI_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function CNUURRFRMI_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('CNUURRFRMI',CNUURRFRMI_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
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
m_oFather.i_last_focused_item='child_ardt_categris';
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
windowOpenForeground('../doc/ardt_categris_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_IDCATEG=a[0];
w_CODICE=a[1];
w_GIORNI=a[2];
w_IDBASE=a[3];
w_xDESCRI=a[4];
m_PrimaryKeys=['CODICE','IDCATEG'];
}
function i_PrimaryKey() {
return 'categris'+'\\'+CPLib.ToCPStr(w_IDCATEG);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('ardt_categris',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
function LinkZoomExtendedMenu() {
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_CODICE,'C'); },"field":"CODICE","type":"C"},{"expression":function() { return WtA(w_xDESCRI,'C'); },"field":"DESCRI","type":"C"},{"expression":function() { return WtA(w_GIORNI,'N'); },"field":"GIORNI","type":"N"}],"itemRepeated":true,"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbrisglob','C'),"uid":"EQQSGWXFEN"});
}
function FocusFirstDetailComponent() {
var candidatesToFocus = ["EQQSGWXFEN"];
SetControlFocus(candidatesToFocus);
}
IsRepeatedChild.child=[];
function GetFullRowMsgError() {
return 'MSG_FULLROW_NOT_SAT';
}
_Obli('GIORNI',1,'DMQNJHYOOO',false)
_Obli('CODICE',0,'EQQSGWXFEN',false)
_Obli('xDESCRI',0,'CNUURRFRMI',false,"285808099")
