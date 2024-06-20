function FillCombosValues() {
}
function FillInGridCombosValues(currentRow) {
var postfix = (Gt(currentRow,-1)?'_'+currentRow:'');
}
function SetControlsValue() {
var c;
if (Empty(m_cAltInterface) && (Eq(m_cFunction,'view') || Eq(m_cFunction,'query'))) {
var tmp_CTWDLNXXXD = ToHTag(AsControlValue(w_xdessta));
if (Ne(e_CTWDLNXXXD,tmp_CTWDLNXXXD)) {
SPBOUILib.SetLabelValue('CTWDLNXXXD','innerHTML',tmp_CTWDLNXXXD);
e_CTWDLNXXXD=tmp_CTWDLNXXXD;
}
SPBOUILib.SetInputValue('JEGIRRECDX',function(){return WtH(w_C_CTA,'C',30,0,'')},w_C_CTA);
SPBOUILib.SetInputValue('VFKBUBHCEY',function(){return WtH(w_C_CAB,'C',6,0,'')},w_C_CAB);
SPBOUILib.SetInputValue('KMXMWIBKDJ',function(){return WtH(w_C_PRV,'C',2,0,'')},w_C_PRV);
SPBOUILib.SetInputValue('OFRQGKEFMW',function(){return WtH(w_C_IND,'C',35,0,'')},w_C_IND);
SPBOUILib.SetInputValue('KVYEJVZPZF',function(){return WtH(w_C_STA,'C',3,0,'')},w_C_STA);
SPBOUILib.SetInputValue('MBGCZJULKH',function(){return WtH(w_C_CAP,'C',5,0,'')},w_C_CAP);
} else {
SPBOUILib.SetInputValue('TMTNRFTARW',function(){return WtH(w_CODSOG,'C',16,0,'')},w_CODSOG);
SPBOUILib.SetInputValue('GAEWMPRBSY',function(){return WtH(w_C_RAG,'C',70,0,'')},w_C_RAG);
SPBOUILib.SetInputValue('JEGIRRECDX',function(){return WtH(w_C_CTA,'C',30,0,'')},w_C_CTA);
SPBOUILib.SetInputValue('VFKBUBHCEY',function(){return WtH(w_C_CAB,'C',6,0,'')},w_C_CAB);
SPBOUILib.SetInputValue('KMXMWIBKDJ',function(){return WtH(w_C_PRV,'C',2,0,'')},w_C_PRV);
SPBOUILib.SetInputValue('OFRQGKEFMW',function(){return WtH(w_C_IND,'C',35,0,'')},w_C_IND);
SPBOUILib.SetInputValue('KVYEJVZPZF',function(){return WtH(w_C_STA,'C',3,0,'')},w_C_STA);
SPBOUILib.SetInputValue('MBGCZJULKH',function(){return WtH(w_C_CAP,'C',5,0,'')},w_C_CAP);
var tmp_CTWDLNXXXD = ToHTag(AsControlValue(w_xdessta));
if (Ne(e_CTWDLNXXXD,tmp_CTWDLNXXXD)) {
SPBOUILib.SetLabelValue('CTWDLNXXXD','innerHTML',tmp_CTWDLNXXXD);
e_CTWDLNXXXD=tmp_CTWDLNXXXD;
}
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
SetDisplay('VRCVINYRJO_DIV',IsHiddenByStateDriver('box_VRCVINYRJO'));
LibJavascript.forEachItem(m_FoundlingHideExpression,i_body_2)
function i_body_2(child){
child();
}
HideUI();
}
function TMTNRFTARW_Valid(e) {
SetActiveField(Ctrl('TMTNRFTARW'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CODSOG','C',w_CODSOG,HtW(Ctrl('TMTNRFTARW').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODSOG(HtW(Ctrl('TMTNRFTARW').value,'C'),null,e);
return l_bSetResult;
}
}
function TMTNRFTARW_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('TMTNRFTARW'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('TMTNRFTARW'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('TMTNRFTARW'),e);
}
function TMTNRFTARW_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('TMTNRFTARW')),'linkview_TMTNRFTARW','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function GAEWMPRBSY_Valid(e) {
SetActiveField(Ctrl('GAEWMPRBSY'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('C_RAG','C',w_C_RAG,HtW(Ctrl('GAEWMPRBSY').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_C_RAG(HtW(Ctrl('GAEWMPRBSY').value,'C'),null,e);
return l_bSetResult;
}
}
function GAEWMPRBSY_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('GAEWMPRBSY'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('GAEWMPRBSY'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('GAEWMPRBSY'),e);
}
function JEGIRRECDX_Valid(e) {
SetActiveField(Ctrl('JEGIRRECDX'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('C_CTA','C',w_C_CTA,HtW(Ctrl('JEGIRRECDX').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_C_CTA(HtW(Ctrl('JEGIRRECDX').value,'C'),null,e);
return l_bSetResult;
}
}
function JEGIRRECDX_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('JEGIRRECDX'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('JEGIRRECDX'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('JEGIRRECDX'),e);
}
function JEGIRRECDX_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('JEGIRRECDX')),'linkview_JEGIRRECDX','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function VFKBUBHCEY_Valid(e) {
SetActiveField(Ctrl('VFKBUBHCEY'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('C_CAB','C',w_C_CAB,HtW(Ctrl('VFKBUBHCEY').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_C_CAB(HtW(Ctrl('VFKBUBHCEY').value,'C'),null,e);
return l_bSetResult;
}
}
function VFKBUBHCEY_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('VFKBUBHCEY'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('VFKBUBHCEY'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('VFKBUBHCEY'),e);
}
function KMXMWIBKDJ_Valid(e) {
SetActiveField(Ctrl('KMXMWIBKDJ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('C_PRV','C',w_C_PRV,HtW(Ctrl('KMXMWIBKDJ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_C_PRV(HtW(Ctrl('KMXMWIBKDJ').value,'C'),null,e);
return l_bSetResult;
}
}
function KMXMWIBKDJ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('KMXMWIBKDJ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('KMXMWIBKDJ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('KMXMWIBKDJ'),e);
}
function OFRQGKEFMW_Valid(e) {
SetActiveField(Ctrl('OFRQGKEFMW'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('C_IND','C',w_C_IND,HtW(Ctrl('OFRQGKEFMW').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_C_IND(HtW(Ctrl('OFRQGKEFMW').value,'C'),null,e);
return l_bSetResult;
}
}
function OFRQGKEFMW_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('OFRQGKEFMW'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('OFRQGKEFMW'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('OFRQGKEFMW'),e);
}
function KVYEJVZPZF_Valid(e) {
SetActiveField(Ctrl('KVYEJVZPZF'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('C_STA','C',w_C_STA,HtW(Ctrl('KVYEJVZPZF').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_C_STA(HtW(Ctrl('KVYEJVZPZF').value,'C'),null,e);
return l_bSetResult;
}
}
function KVYEJVZPZF_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('KVYEJVZPZF'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('KVYEJVZPZF'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('KVYEJVZPZF'),e);
}
function KVYEJVZPZF_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('KVYEJVZPZF')),'linkview_KVYEJVZPZF','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function MBGCZJULKH_Valid(e) {
SetActiveField(Ctrl('MBGCZJULKH'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('C_CAP','C',w_C_CAP,HtW(Ctrl('MBGCZJULKH').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_C_CAP(HtW(Ctrl('MBGCZJULKH').value,'C'),null,e);
return l_bSetResult;
}
}
function MBGCZJULKH_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('MBGCZJULKH'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('MBGCZJULKH'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('MBGCZJULKH'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function TMTNRFTARW_wrap_Valid(event) {
return TMTNRFTARW_Valid(event);
}
SPBOUILib.SetInputExit('TMTNRFTARW',TMTNRFTARW_wrap_Valid,SPBOUILib.Row.IN_GRID);
function TMTNRFTARW_wrap_OnFocus(event) {
return TMTNRFTARW_OnFocus(event);
}
SPBOUILib.SetInputEnter('TMTNRFTARW',TMTNRFTARW_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function TMTNRFTARW_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('TMTNRFTARW',TMTNRFTARW_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function TMTNRFTARW_ZOOM_setHandlers() {
function TMTNRFTARW_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?TMTNRFTARW_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('TMTNRFTARW_ZOOM',TMTNRFTARW_ZOOM_wrap_OnClick,SPBOUILib.Row.IN_GRID);
}
SPBOUILib.SetPicker('TMTNRFTARW',TMTNRFTARW_ZOOM_setHandlers);
function GAEWMPRBSY_wrap_Valid(event) {
return GAEWMPRBSY_Valid(event);
}
SPBOUILib.SetInputExit('GAEWMPRBSY',GAEWMPRBSY_wrap_Valid,SPBOUILib.Row.IN_GRID);
function GAEWMPRBSY_wrap_OnFocus(event) {
return GAEWMPRBSY_OnFocus(event);
}
SPBOUILib.SetInputEnter('GAEWMPRBSY',GAEWMPRBSY_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function GAEWMPRBSY_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('GAEWMPRBSY',GAEWMPRBSY_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function JEGIRRECDX_wrap_Valid(event) {
return JEGIRRECDX_Valid(event);
}
SPBOUILib.SetInputExit('JEGIRRECDX',JEGIRRECDX_wrap_Valid);
function JEGIRRECDX_wrap_OnFocus(event) {
return JEGIRRECDX_OnFocus(event);
}
SPBOUILib.SetInputEnter('JEGIRRECDX',JEGIRRECDX_wrap_OnFocus);
function JEGIRRECDX_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('JEGIRRECDX',JEGIRRECDX_wrap_OnKeyDown);
function JEGIRRECDX_ZOOM_setHandlers() {
function JEGIRRECDX_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?JEGIRRECDX_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('JEGIRRECDX_ZOOM',JEGIRRECDX_ZOOM_wrap_OnClick);
}
SPBOUILib.SetPicker('JEGIRRECDX',JEGIRRECDX_ZOOM_setHandlers);
function VFKBUBHCEY_wrap_Valid(event) {
return VFKBUBHCEY_Valid(event);
}
SPBOUILib.SetInputExit('VFKBUBHCEY',VFKBUBHCEY_wrap_Valid);
function VFKBUBHCEY_wrap_OnFocus(event) {
return VFKBUBHCEY_OnFocus(event);
}
SPBOUILib.SetInputEnter('VFKBUBHCEY',VFKBUBHCEY_wrap_OnFocus);
function VFKBUBHCEY_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('VFKBUBHCEY',VFKBUBHCEY_wrap_OnKeyDown);
function KMXMWIBKDJ_wrap_Valid(event) {
return KMXMWIBKDJ_Valid(event);
}
SPBOUILib.SetInputExit('KMXMWIBKDJ',KMXMWIBKDJ_wrap_Valid);
function KMXMWIBKDJ_wrap_OnFocus(event) {
return KMXMWIBKDJ_OnFocus(event);
}
SPBOUILib.SetInputEnter('KMXMWIBKDJ',KMXMWIBKDJ_wrap_OnFocus);
function KMXMWIBKDJ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('KMXMWIBKDJ',KMXMWIBKDJ_wrap_OnKeyDown);
function OFRQGKEFMW_wrap_Valid(event) {
return OFRQGKEFMW_Valid(event);
}
SPBOUILib.SetInputExit('OFRQGKEFMW',OFRQGKEFMW_wrap_Valid);
function OFRQGKEFMW_wrap_OnFocus(event) {
return OFRQGKEFMW_OnFocus(event);
}
SPBOUILib.SetInputEnter('OFRQGKEFMW',OFRQGKEFMW_wrap_OnFocus);
function OFRQGKEFMW_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('OFRQGKEFMW',OFRQGKEFMW_wrap_OnKeyDown);
function KVYEJVZPZF_wrap_Valid(event) {
return KVYEJVZPZF_Valid(event);
}
SPBOUILib.SetInputExit('KVYEJVZPZF',KVYEJVZPZF_wrap_Valid);
function KVYEJVZPZF_wrap_OnFocus(event) {
return KVYEJVZPZF_OnFocus(event);
}
SPBOUILib.SetInputEnter('KVYEJVZPZF',KVYEJVZPZF_wrap_OnFocus);
function KVYEJVZPZF_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('KVYEJVZPZF',KVYEJVZPZF_wrap_OnKeyDown);
function KVYEJVZPZF_ZOOM_setHandlers() {
function KVYEJVZPZF_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?KVYEJVZPZF_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('KVYEJVZPZF_ZOOM',KVYEJVZPZF_ZOOM_wrap_OnClick);
}
SPBOUILib.SetPicker('KVYEJVZPZF',KVYEJVZPZF_ZOOM_setHandlers);
function MBGCZJULKH_wrap_Valid(event) {
return MBGCZJULKH_Valid(event);
}
SPBOUILib.SetInputExit('MBGCZJULKH',MBGCZJULKH_wrap_Valid);
function MBGCZJULKH_wrap_OnFocus(event) {
return MBGCZJULKH_OnFocus(event);
}
SPBOUILib.SetInputEnter('MBGCZJULKH',MBGCZJULKH_wrap_OnFocus);
function MBGCZJULKH_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('MBGCZJULKH',MBGCZJULKH_wrap_OnKeyDown);
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
m_oFather.i_last_focused_item='child_ardt_meneficfrz';
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
windowOpenForeground('../doc/ardt_meneficfrz_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_IDFILEBO=a[0];
w_CODSOG=a[1];
w_IDBASE=a[2];
w_C_RAG=a[3];
w_C_CTA=a[4];
w_C_CAB=a[5];
w_C_PRV=a[6];
w_C_IND=a[7];
w_C_STA=a[8];
w_C_CAP=a[9];
w_xdessta=a[10];
m_PrimaryKeys=['CODSOG','IDFILEBO'];
}
function i_PrimaryKey() {
return 'meneficfrz'+'\\'+CPLib.ToCPStr(w_IDFILEBO);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('ardt_meneficfrz',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
function LinkZoomExtendedMenu() {
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_CODSOG,'C'); },"field":"CONNES","type":"C"},{"expression":function() { return WtA(w_C_RAG,'C'); },"field":"RAGSOC","type":"C"},{"expression":function() { return WtA(w_C_IND,'C'); },"field":"DOMICILIO","type":"C"},{"expression":function() { return WtA(w_C_CTA,'C'); },"field":"DESCCIT","type":"C"},{"expression":function() { return WtA(w_C_PRV,'C'); },"field":"PROVINCIA","type":"C"},{"expression":function() { return WtA(w_C_CAP,'C'); },"field":"CAP","type":"C"}],"itemRepeated":true,"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('personbo','C'),"uid":"TMTNRFTARW"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_C_CTA,'C'); },"field":"CITTA","type":"C"},{"expression":function() { return WtA(w_C_CAB,'C'); },"field":"CAB","type":"C"},{"expression":function() { return WtA(w_C_CAP,'C'); },"field":"CAP","type":"C"},{"expression":function() { return WtA(w_C_PRV,'C'); },"field":"PROV","type":"C"},{"expression":function() { return WtA(w_C_STA,'C'); },"field":"PKTBSTATI","type":"C"}],"itemRepeated":true,"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbcitta','C'),"uid":"JEGIRRECDX"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_C_STA,'C'); },"field":"CODSTA","type":"C"},{"expression":function() { return WtA(w_xdessta,'C'); },"field":"DESCRI","type":"C"}],"itemRepeated":true,"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbstati','C'),"uid":"KVYEJVZPZF"});
}
function FocusFirstDetailComponent() {
var candidatesToFocus = ["TMTNRFTARW"];
SetControlFocus(candidatesToFocus);
}
IsRepeatedChild.child=[];
function GetFullRowMsgError() {
return 'MSG_FULLROW_NOT_SAT';
}
_Obli('C_CAB',0,'VFKBUBHCEY',false)
_Obli('CODSOG',0,'TMTNRFTARW',false,"10847988462")
_Obli('C_PRV',0,'KMXMWIBKDJ',false)
_Obli('C_RAG',0,'GAEWMPRBSY',false)
_Obli('C_CTA',0,'JEGIRRECDX',false)
_Obli('C_IND',0,'OFRQGKEFMW',false)
_Obli('C_STA',0,'KVYEJVZPZF',false)
_Obli('C_CAP',0,'MBGCZJULKH',false)
