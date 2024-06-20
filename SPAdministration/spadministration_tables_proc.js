function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('LAGKMWCQMG',function(){return WtH(w_FileName,'C',30,0,'')},w_FileName);
SPBOUILib.SetInputValue('PJWHAZGJKP',function(){return WtH(w_PhName,'C',50,0,'')},w_PhName);
SPBOUILib.SetInputValue('OJERXEZSWH',function(){return WtH(w_ServerName,'C',10,0,'')},w_ServerName);
SPBOUILib.SetInputValue('KDEUPENAMD',function(){return WtH(w_DateMod,'C',14,0,'')},w_DateMod);
SPBOUILib.SetInputValue('FGUDUNQBGP',function(){return WtH(w_descserver,'C',30,0,'')},w_descserver);
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
HideUI.lblids["DateMod"]=['AABHINDDSS'];
HideUI.lblids["FileName"]=['MYDKBZFNNC'];
HideUI.lblids["PhName"]=['EGCZHELFTL'];
HideUI.lblids["ServerName"]=['JVNAUHUFGQ'];
function LAGKMWCQMG_Valid(e) {
SetActiveField(Ctrl('LAGKMWCQMG'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('LAGKMWCQMG') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('FileName','C',w_FileName,HtW(Ctrl('LAGKMWCQMG').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FileName(HtW(Ctrl('LAGKMWCQMG').value,'C'),null,e);
return l_bSetResult;
}
}
function LAGKMWCQMG_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('LAGKMWCQMG'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('LAGKMWCQMG'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('LAGKMWCQMG'),e);
}
function OJERXEZSWH_Valid(e) {
SetActiveField(Ctrl('OJERXEZSWH'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('ServerName','C',w_ServerName,HtW(Ctrl('OJERXEZSWH').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ServerName(HtW(Ctrl('OJERXEZSWH').value,'C'),null,e);
return l_bSetResult;
}
}
function OJERXEZSWH_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('OJERXEZSWH'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('OJERXEZSWH'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('OJERXEZSWH'),e);
}
function OJERXEZSWH_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('OJERXEZSWH')),'linkview_OJERXEZSWH','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function LAGKMWCQMG_wrap_Valid(event) {
return LAGKMWCQMG_Valid(event);
}
SPBOUILib.SetInputExit('LAGKMWCQMG',LAGKMWCQMG_wrap_Valid);
function LAGKMWCQMG_wrap_OnFocus(event) {
return LAGKMWCQMG_OnFocus(event);
}
SPBOUILib.SetInputEnter('LAGKMWCQMG',LAGKMWCQMG_wrap_OnFocus);
function LAGKMWCQMG_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('LAGKMWCQMG',LAGKMWCQMG_wrap_OnKeyDown);
function OJERXEZSWH_wrap_Valid(event) {
return OJERXEZSWH_Valid(event);
}
SPBOUILib.SetInputExit('OJERXEZSWH',OJERXEZSWH_wrap_Valid);
function OJERXEZSWH_wrap_OnFocus(event) {
return OJERXEZSWH_OnFocus(event);
}
SPBOUILib.SetInputEnter('OJERXEZSWH',OJERXEZSWH_wrap_OnFocus);
function OJERXEZSWH_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('OJERXEZSWH',OJERXEZSWH_wrap_OnKeyDown);
function OJERXEZSWH_ZOOM_setHandlers() {
function OJERXEZSWH_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?OJERXEZSWH_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('OJERXEZSWH_ZOOM',OJERXEZSWH_ZOOM_wrap_OnClick);
function OJERXEZSWH_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('OJERXEZSWH_ZOOM',OJERXEZSWH_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('OJERXEZSWH',OJERXEZSWH_ZOOM_setHandlers);
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
FocusFirstComponent.edit={"page_1":["OJERXEZSWH"]};
FocusFirstComponent.query={"page_1":["LAGKMWCQMG"]};
FocusFirstComponent.otherwise={"page_1":["LAGKMWCQMG"]};
function Help() {
windowOpenForeground('../doc/spadministration_tables_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_FileName=a[0];
w_PhName=a[1];
w_ServerName=a[2];
w_DateMod=a[3];
w_descserver=a[4];
m_PrimaryKeys=['FileName'];
}
function i_PrimaryKey() {
return 'cpttbls'+'\\'+CPLib.ToCPStr(w_FileName);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('spadministration_tables',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
function LinkZoomExtendedMenu() {
ExtendedMenu({"configName":WtA('','C'),"entityName":WtA('spadministration_servers','C'),"fldValues":[{"expression":function() { return WtA(w_ServerName,'C'); },"field":"ServerName","type":"C"},{"expression":function() { return WtA(w_descserver,'C'); },"field":"ServerDesc","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('cptsrvr','C'),"uid":"OJERXEZSWH"});
}
_Obli('FileName',0,'LAGKMWCQMG',false,"11016806698")
_Obli('ServerName',0,'OJERXEZSWH',false,"1703731040")
