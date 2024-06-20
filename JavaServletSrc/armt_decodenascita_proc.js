function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('LBGSJKIAGZ',function(){return WtH(w_account,'C',100,0,'')},w_account);
SPBOUILib.SetInputValue('TJYKSZAWUH',function(){return WtH(w_SIGLA,'C',4,0,'')},w_SIGLA);
SPBOUILib.SetInputValue('DDQIAUNLGA',function(){return WtH(w_DESCRI,'C',60,0,'')},w_DESCRI);
if (m_bExtended) {
SetExtensions();
}
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay('YORQOIOBQN_DIV',IsHiddenByStateDriver('box_YORQOIOBQN'));
LibJavascript.forEachItem(m_FoundlingHideExpression,i_body_2)
function i_body_2(child){
child();
}
HideUI();
}
HideUI.lblids["SIGLA"]=['NRZLUCVMIH'];
HideUI.lblids["account"]=['QOCVJWZJGH'];
function LBGSJKIAGZ_Valid(e) {
SetActiveField(Ctrl('LBGSJKIAGZ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('account','C',w_account,HtW(Ctrl('LBGSJKIAGZ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_account(HtW(Ctrl('LBGSJKIAGZ').value,'C'),null,e);
return l_bSetResult;
}
}
function LBGSJKIAGZ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('LBGSJKIAGZ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('LBGSJKIAGZ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('LBGSJKIAGZ'),e);
}
function TJYKSZAWUH_Valid(e) {
SetActiveField(Ctrl('TJYKSZAWUH'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('SIGLA','C',w_SIGLA,HtW(Ctrl('TJYKSZAWUH').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_SIGLA(HtW(Ctrl('TJYKSZAWUH').value,'C'),null,e);
return l_bSetResult;
}
}
function TJYKSZAWUH_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('TJYKSZAWUH'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('TJYKSZAWUH'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('TJYKSZAWUH'),e);
}
function TJYKSZAWUH_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('TJYKSZAWUH')),'linkview_TJYKSZAWUH','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function LBGSJKIAGZ_wrap_Valid(event) {
return LBGSJKIAGZ_Valid(event);
}
SPBOUILib.SetInputExit('LBGSJKIAGZ',LBGSJKIAGZ_wrap_Valid);
function LBGSJKIAGZ_wrap_OnFocus(event) {
return LBGSJKIAGZ_OnFocus(event);
}
SPBOUILib.SetInputEnter('LBGSJKIAGZ',LBGSJKIAGZ_wrap_OnFocus);
function LBGSJKIAGZ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('LBGSJKIAGZ',LBGSJKIAGZ_wrap_OnKeyDown);
function TJYKSZAWUH_wrap_Valid(event) {
return TJYKSZAWUH_Valid(event);
}
SPBOUILib.SetInputExit('TJYKSZAWUH',TJYKSZAWUH_wrap_Valid);
function TJYKSZAWUH_wrap_OnFocus(event) {
return TJYKSZAWUH_OnFocus(event);
}
SPBOUILib.SetInputEnter('TJYKSZAWUH',TJYKSZAWUH_wrap_OnFocus);
function TJYKSZAWUH_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('TJYKSZAWUH',TJYKSZAWUH_wrap_OnKeyDown);
function TJYKSZAWUH_ZOOM_setHandlers() {
function TJYKSZAWUH_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?TJYKSZAWUH_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('TJYKSZAWUH_ZOOM',TJYKSZAWUH_ZOOM_wrap_OnClick);
function TJYKSZAWUH_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('TJYKSZAWUH_ZOOM',TJYKSZAWUH_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('TJYKSZAWUH',TJYKSZAWUH_ZOOM_setHandlers);
if (m_bExtended) {
SetEventsAndStylesToExtendedFields();
}
}
if (Eq(m_cFunction,'query') && Ne(document.FrmToolbar,null)) {
document.FrmToolbar.pos.onkeypress=RecPositionInput;
document.FrmToolbar.pos.onblur=SelectRecord;
}
}
function NotifyEvent(p_cEvent) {
var old_c;
}
function SetLastFocusedOnParent() {
// used only in child entities
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
}
m_nLastError=0;
m_cLastMsgError='';
}
FocusFirstComponent.edit={"page_1":["LBGSJKIAGZ"]};
FocusFirstComponent.query={"page_1":["LBGSJKIAGZ"]};
FocusFirstComponent.otherwise={"page_1":["LBGSJKIAGZ"]};
function Help() {
windowOpenForeground('../doc/armt_decodenascita_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_id=a[0];
w_account=a[1];
w_SIGLA=a[2];
w_DESCRI=a[3];
w_DATINI=a[4];
w_DATFIN=a[5];
w_PROVINCIA=a[6];
m_PrimaryKeys=['id'];
}
function i_PrimaryKey() {
return 'DecodeNascita'+'\\'+CPLib.ToCPStr(w_id);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('armt_decodenascita',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
function LinkZoomExtendedMenu() {
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_SIGLA,'C'); },"field":"SIGLA","type":"C"},{"expression":function() { return WtA(w_DESCRI,'C'); },"field":"DESCRI","type":"C"},{"expression":function() { return WtA(w_DATINI,'D'); },"field":"DATINI","type":"D"},{"expression":function() { return WtA(w_DATFIN,'D'); },"field":"DATFIN","type":"D"},{"expression":function() { return WtA(w_PROVINCIA,'C'); },"field":"PROVINCIA","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbluonas','C'),"uid":"TJYKSZAWUH"});
}
_Obli('account',0,'LBGSJKIAGZ',false,"101550487")
_Obli('SIGLA',0,'TJYKSZAWUH',false,"6827491")
