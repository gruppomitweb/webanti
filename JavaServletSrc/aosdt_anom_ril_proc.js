function FillCombosValues() {
}
function FillInGridCombosValues(currentRow) {
var postfix = (Gt(currentRow,-1)?'_'+currentRow:'');
}
function SetControlsValue() {
var c;
if (Empty(m_cAltInterface) && (Eq(m_cFunction,'view') || Eq(m_cFunction,'query'))) {
SPBOUILib.SetInputValue('NBMHJRJGQX',function(){return WtH(w_IDMOD,'C',10,0,'')},w_IDMOD);
SPBOUILib.SetInputValue('KHBDKLNADV',function(){return WtH(w_ROWRIL,'N',4,0,'9999')},w_ROWRIL);
} else {
SPBOUILib.SetInputValue('NBMHJRJGQX',function(){return WtH(w_IDMOD,'C',10,0,'')},w_IDMOD);
SPBOUILib.SetInputValue('KHBDKLNADV',function(){return WtH(w_ROWRIL,'N',4,0,'9999')},w_ROWRIL);
SPBOUILib.SetInputValue('PWBPXBGJRH',function(){return WtH(w_IDIND,'C',10,0,'')},w_IDIND);
SPBOUILib.SetInputValue('OSQTGJONIV',function(){return WtH(w_IDSUBIND,'C',10,0,'')},w_IDSUBIND);
SPBOUILib.SetInputValue('GIWDXVTDUW',function(){return WtH(w_NOTA,'M',10,0,'')},w_NOTA);
SPBOUILib.SetInputValue('GOHQRSLEQN',function(){return WtH(w_PROGIND,'C',10,0,'')},w_PROGIND);
SPBOUILib.SetInputValue('AOKURBYNFX',function(){return WtH(w_DESCRI_IND,'M',10,0,'')},w_DESCRI_IND);
SPBOUILib.SetInputValue('NXPQVKMXKS',function(){return WtH(w_PROGSUBIND,'C',10,0,'')},w_PROGSUBIND);
SPBOUILib.SetInputValue('PSHCVHVAPS',function(){return WtH(w_DESCRI_SUBIND,'M',10,0,'')},w_DESCRI_SUBIND);
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
HideUI.lblids["IDIND"]=['UALKXPJWBM'];
HideUI.lblids["IDSUBIND"]=['OKVVWUCLCV'];
HideUI.lblids["NOTA"]=['RMCEGUPVLI'];
function ExpandCollapseBoxesUnderCondition() {
var cond;
}
function NBMHJRJGQX_Valid(e) {
SuggesterLib.resetSuggest('NBMHJRJGQX','NBMHJRJGQX');
SetActiveField(Ctrl('NBMHJRJGQX'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('NBMHJRJGQX') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('IDMOD','C',w_IDMOD,HtW(Ctrl('NBMHJRJGQX').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IDMOD(HtW(Ctrl('NBMHJRJGQX').value,'C'),null,e);
return l_bSetResult;
}
}
function NBMHJRJGQX_OnFocus(e) {
NBMHJRJGQX_OnKeyUp.oldValue=HtW(Ctrl('NBMHJRJGQX').value,'C');
if (Ne(m_cFunction,'query') &&  ! (CheckZone('NBMHJRJGQX'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('NBMHJRJGQX'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('NBMHJRJGQX'),e);
}
function NBMHJRJGQX_OnKeyUp(e) {
var evt = (window.event?window.event:e);
var newValue = HtW(Ctrl('NBMHJRJGQX').value,'C');
if (Eq(newValue,NBMHJRJGQX_OnKeyUp.oldValue)) {
return;
}
NBMHJRJGQX_OnKeyUp.oldValue=newValue;
if ( ! (GetDisabled(Ctrl('NBMHJRJGQX')) || IsMobile())) {
if (Gt(newValue.length,2)) {
SuggesterLib.callSuggest(Sugg_NBMHJRJGQX,3);
} else {
SuggesterLib.resetSuggest('NBMHJRJGQX','NBMHJRJGQX');
}
}
}
function NBMHJRJGQX_ValidSuggest(e) {
e=(window.event?window.event:e);
if (e) {
return SuggesterLib.select_suggest('NBMHJRJGQX','NBMHJRJGQX',-1,e);
}
}
function KHBDKLNADV_Valid(e) {
SetActiveField(Ctrl('KHBDKLNADV'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('KHBDKLNADV') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('ROWRIL','N',w_ROWRIL,HtW(Ctrl('KHBDKLNADV').value,'N'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ROWRIL(HtW(Ctrl('KHBDKLNADV').value,'N'),null,e);
return l_bSetResult;
}
}
function KHBDKLNADV_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('KHBDKLNADV'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('KHBDKLNADV',w_ROWRIL,'N',4,0,'9999');
SetActiveField(Ctrl('KHBDKLNADV'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('KHBDKLNADV'),e);
}
function KHBDKLNADV_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("9999"));
}
function PWBPXBGJRH_Valid(e) {
SuggesterLib.resetSuggest('PWBPXBGJRH','PWBPXBGJRH');
SetActiveField(Ctrl('PWBPXBGJRH'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('IDIND','C',w_IDIND,HtW(Ctrl('PWBPXBGJRH').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IDIND(HtW(Ctrl('PWBPXBGJRH').value,'C'),null,e);
return l_bSetResult;
}
}
function PWBPXBGJRH_OnFocus(e) {
PWBPXBGJRH_OnKeyUp.oldValue=HtW(Ctrl('PWBPXBGJRH').value,'C');
if (Ne(m_cFunction,'query') &&  ! (CheckZone('PWBPXBGJRH'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('PWBPXBGJRH'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('PWBPXBGJRH'),e);
}
function PWBPXBGJRH_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('PWBPXBGJRH')),'linkview_PWBPXBGJRH','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function PWBPXBGJRH_OnKeyUp(e) {
var evt = (window.event?window.event:e);
var newValue = HtW(Ctrl('PWBPXBGJRH').value,'C');
if (Eq(newValue,PWBPXBGJRH_OnKeyUp.oldValue)) {
return;
}
PWBPXBGJRH_OnKeyUp.oldValue=newValue;
if ( ! (GetDisabled(Ctrl('PWBPXBGJRH')) || IsMobile())) {
if (Gt(newValue.length,2)) {
SuggesterLib.callSuggest(Sugg_PWBPXBGJRH,3);
} else {
SuggesterLib.resetSuggest('PWBPXBGJRH','PWBPXBGJRH');
}
}
}
function PWBPXBGJRH_ValidSuggest(e) {
e=(window.event?window.event:e);
if (e) {
return SuggesterLib.select_suggest('PWBPXBGJRH','PWBPXBGJRH',-1,e);
}
}
function OSQTGJONIV_Valid(e) {
SuggesterLib.resetSuggest('OSQTGJONIV','OSQTGJONIV');
SetActiveField(Ctrl('OSQTGJONIV'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('IDSUBIND','C',w_IDSUBIND,HtW(Ctrl('OSQTGJONIV').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IDSUBIND(HtW(Ctrl('OSQTGJONIV').value,'C'),null,e);
return l_bSetResult;
}
}
function OSQTGJONIV_OnFocus(e) {
OSQTGJONIV_OnKeyUp.oldValue=HtW(Ctrl('OSQTGJONIV').value,'C');
if (Ne(m_cFunction,'query') &&  ! (CheckZone('OSQTGJONIV'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('OSQTGJONIV'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('OSQTGJONIV'),e);
}
function OSQTGJONIV_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('OSQTGJONIV')),'linkview_OSQTGJONIV','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function OSQTGJONIV_OnKeyUp(e) {
var evt = (window.event?window.event:e);
var newValue = HtW(Ctrl('OSQTGJONIV').value,'C');
if (Eq(newValue,OSQTGJONIV_OnKeyUp.oldValue)) {
return;
}
OSQTGJONIV_OnKeyUp.oldValue=newValue;
if ( ! (GetDisabled(Ctrl('OSQTGJONIV')) || IsMobile())) {
if (Gt(newValue.length,2)) {
SuggesterLib.callSuggest(Sugg_OSQTGJONIV,3);
} else {
SuggesterLib.resetSuggest('OSQTGJONIV','OSQTGJONIV');
}
}
}
function OSQTGJONIV_ValidSuggest(e) {
e=(window.event?window.event:e);
if (e) {
return SuggesterLib.select_suggest('OSQTGJONIV','OSQTGJONIV',-1,e);
}
}
function GIWDXVTDUW_Valid(e) {
SetActiveField(Ctrl('GIWDXVTDUW'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('NOTA','M',w_NOTA,HtW(Ctrl('GIWDXVTDUW').value,'M'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_NOTA(HtW(Ctrl('GIWDXVTDUW').value,'M'),null,e);
return l_bSetResult;
}
}
function GIWDXVTDUW_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('GIWDXVTDUW'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('GIWDXVTDUW'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('GIWDXVTDUW'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function NBMHJRJGQX_wrap_Valid(event) {
return NBMHJRJGQX_Valid(event);
}
SPBOUILib.SetInputExit('NBMHJRJGQX',NBMHJRJGQX_wrap_Valid);
function NBMHJRJGQX_wrap_OnFocus(event) {
return NBMHJRJGQX_OnFocus(event);
}
SPBOUILib.SetInputEnter('NBMHJRJGQX',NBMHJRJGQX_wrap_OnFocus);
function NBMHJRJGQX_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('NBMHJRJGQX',NBMHJRJGQX_wrap_OnKeyDown);
SPBOUILib.SetInputKeyUp('NBMHJRJGQX',function(event) {
  return (Eq(m_cFunction,'edit') || Eq(m_cFunction,'new')?NBMHJRJGQX_OnKeyUp(event):void(0));
});
function KHBDKLNADV_wrap_Valid(event) {
return KHBDKLNADV_Valid(event);
}
SPBOUILib.SetInputExit('KHBDKLNADV',KHBDKLNADV_wrap_Valid);
function KHBDKLNADV_wrap_OnFocus(event) {
return KHBDKLNADV_OnFocus(event);
}
SPBOUILib.SetInputEnter('KHBDKLNADV',KHBDKLNADV_wrap_OnFocus);
function KHBDKLNADV_wrap_OnKeyPress(event) {
return KHBDKLNADV_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('KHBDKLNADV',KHBDKLNADV_wrap_OnKeyPress);
function KHBDKLNADV_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('KHBDKLNADV',KHBDKLNADV_wrap_OnKeyDown);
function PWBPXBGJRH_wrap_Valid(event) {
return PWBPXBGJRH_Valid(event);
}
SPBOUILib.SetInputExit('PWBPXBGJRH',PWBPXBGJRH_wrap_Valid,SPBOUILib.Row.IN_GRID);
function PWBPXBGJRH_wrap_OnFocus(event) {
return PWBPXBGJRH_OnFocus(event);
}
SPBOUILib.SetInputEnter('PWBPXBGJRH',PWBPXBGJRH_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function PWBPXBGJRH_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('PWBPXBGJRH',PWBPXBGJRH_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function PWBPXBGJRH_ZOOM_setHandlers() {
function PWBPXBGJRH_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?PWBPXBGJRH_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('PWBPXBGJRH_ZOOM',PWBPXBGJRH_ZOOM_wrap_OnClick,SPBOUILib.Row.IN_GRID);
}
SPBOUILib.SetPicker('PWBPXBGJRH',PWBPXBGJRH_ZOOM_setHandlers);
SPBOUILib.SetInputKeyUp('PWBPXBGJRH',function(event) {
  return (Eq(m_cFunction,'edit') || Eq(m_cFunction,'new')?PWBPXBGJRH_OnKeyUp(event):void(0));
},SPBOUILib.Row.IN_GRID);
function OSQTGJONIV_wrap_Valid(event) {
return OSQTGJONIV_Valid(event);
}
SPBOUILib.SetInputExit('OSQTGJONIV',OSQTGJONIV_wrap_Valid,SPBOUILib.Row.IN_GRID);
function OSQTGJONIV_wrap_OnFocus(event) {
return OSQTGJONIV_OnFocus(event);
}
SPBOUILib.SetInputEnter('OSQTGJONIV',OSQTGJONIV_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function OSQTGJONIV_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('OSQTGJONIV',OSQTGJONIV_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function OSQTGJONIV_ZOOM_setHandlers() {
function OSQTGJONIV_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?OSQTGJONIV_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('OSQTGJONIV_ZOOM',OSQTGJONIV_ZOOM_wrap_OnClick,SPBOUILib.Row.IN_GRID);
}
SPBOUILib.SetPicker('OSQTGJONIV',OSQTGJONIV_ZOOM_setHandlers);
SPBOUILib.SetInputKeyUp('OSQTGJONIV',function(event) {
  return (Eq(m_cFunction,'edit') || Eq(m_cFunction,'new')?OSQTGJONIV_OnKeyUp(event):void(0));
},SPBOUILib.Row.IN_GRID);
function GIWDXVTDUW_wrap_Valid(event) {
return GIWDXVTDUW_Valid(event);
}
SPBOUILib.SetInputExit('GIWDXVTDUW',GIWDXVTDUW_wrap_Valid,SPBOUILib.Row.IN_GRID);
function GIWDXVTDUW_wrap_OnFocus(event) {
return GIWDXVTDUW_OnFocus(event);
}
SPBOUILib.SetInputEnter('GIWDXVTDUW',GIWDXVTDUW_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
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
m_oFather.i_last_focused_item='child_aosdt_anom_ril';
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
FocusFirstComponent.query={"page_1":["NBMHJRJGQX","KHBDKLNADV"]};
FocusFirstComponent.otherwise={};
function Help() {
windowOpenForeground('../doc/aosdt_anom_ril_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_IDMOD=a[0];
w_ROWRIL=a[1];
w_IDIND=a[2];
w_IDSUBIND=a[3];
w_NOTA=a[4];
w_CONNES=a[5];
w_PROGIND=a[6];
w_DESCRI_IND=a[7];
w_PROGSUBIND=a[8];
w_DESCRI_SUBIND=a[9];
m_PrimaryKeys=['CONNES','IDSUBIND','IDIND','ROWRIL','IDMOD'];
}
function i_PrimaryKey() {
return 'anom_ril'+'\\'+CPLib.ToCPStr(w_IDMOD)+'\\'+CPLib.ToCPStr(w_ROWRIL)+'\\'+CPLib.ToCPStr(w_CONNES);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('aosdt_anom_ril',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
function LinkZoomExtendedMenu() {
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_IDIND,'C'); },"field":"IDIND","type":"C"},{"expression":function() { return WtA(w_PROGIND,'C'); },"field":"PROGIND","type":"C"},{"expression":function() { return WtA(w_DESCRI_IND,'M'); },"field":"DESCRI","type":"M"}],"itemRepeated":true,"keyValues":[{"expression":function() { return WtA(w_IDMOD,'C'); },"field":"IDMOD","type":"C"}],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('ind_def','C'),"uid":"PWBPXBGJRH"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_IDSUBIND,'C'); },"field":"IDSUBIND","type":"C"},{"expression":function() { return WtA(w_PROGSUBIND,'C'); },"field":"PROGSUBIND","type":"C"},{"expression":function() { return WtA(w_DESCRI_SUBIND,'M'); },"field":"DESCRI","type":"M"}],"itemRepeated":true,"keyValues":[{"expression":function() { return WtA(w_IDMOD,'C'); },"field":"IDMOD","type":"C"},{"expression":function() { return WtA(w_IDIND,'C'); },"field":"IDIND","type":"C"}],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('sub_ind_def','C'),"uid":"OSQTGJONIV"});
}
function FocusFirstDetailComponent() {
var candidatesToFocus = ["PWBPXBGJRH"];
SetControlFocus(candidatesToFocus);
}
IsRepeatedChild.child=[];
function GetFullRowMsgError() {
return '2113886253';
}
_Obli('IDMOD',0,'NBMHJRJGQX',false,"10024211400")
_Obli('ROWRIL',1,'KHBDKLNADV',false,"10651989569")
_Obli('IDSUBIND',0,'OSQTGJONIV',false,"10783450750")
_Obli('IDIND',0,'PWBPXBGJRH',false,"1305674908")
_Obli('NOTA',0,'GIWDXVTDUW',false,"10027512133")
