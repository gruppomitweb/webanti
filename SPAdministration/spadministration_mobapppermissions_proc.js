function FillCombosValues() {
}
function FillInGridCombosValues(currentRow) {
var postfix = (Gt(currentRow,-1)?'_'+currentRow:'');
}
function SetControlsValue() {
var c;
if (Empty(m_cAltInterface) && (Eq(m_cFunction,'view') || Eq(m_cFunction,'query'))) {
SPBOUILib.SetInputValue('NIIFDUHRBQ',function(){return WtH(w_pecodice,'C',10,0,'')},w_pecodice);
} else {
SPBOUILib.SetInputValue('NIIFDUHRBQ',function(){return WtH(w_pecodice,'C',10,0,'')},w_pecodice);
if(c=Ctrl('FPUPHODRZY')) selectCombo(c,w_pe__tipo,'N')
SPBOUILib.SetInputValue('ROTQXTGDQV',function(){return WtH(w_pecodute,'N',6,0,'999999')},w_pecodute);
SPBOUILib.SetInputValue('XHHDJCAPOZ',function(){return WtH(w_pecodgrp,'N',6,0,'999999')},w_pecodgrp);
SPBOUILib.SetInputValue('WWAXDSWHMO',function(){return WtH(w_descrizione,'C',50,0,'')},w_descrizione);
SPBOUILib.SetInputValue('NHPLJCHIJC',function(){return WtH(w_descriGruppo,'C',50,0,'')},w_descriGruppo);
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
SetDisplay(Ctrl('NIIFDUHRBQ'),true || IsHiddenByStateDriver('pecodice'));
if (Ne(m_cFunction,'view')) {
SetDisplay(Ctrl('ROTQXTGDQV'),Eq(w_pe__tipo,0) || IsHiddenByStateDriver('pecodute'));
SetDisplay(Ctrl('ROTQXTGDQV_ZOOM'),Eq(w_pe__tipo,0));
}
if (Ne(m_cFunction,'view')) {
SetDisplay(Ctrl('XHHDJCAPOZ'),Eq(w_pe__tipo,1) || IsHiddenByStateDriver('pecodgrp'));
SetDisplay(Ctrl('XHHDJCAPOZ_ZOOM'),Eq(w_pe__tipo,1));
}
if (Ne(m_cFunction,'view')) {
SetDisplay(Ctrl('WWAXDSWHMO'),Eq(w_pe__tipo,0) || IsHiddenByStateDriver('descrizione'));
}
if (Ne(m_cFunction,'view')) {
SetDisplay(Ctrl('NHPLJCHIJC'),Eq(w_pe__tipo,1) || IsHiddenByStateDriver('descriGruppo'));
}
LibJavascript.forEachItem(m_FoundlingHideExpression,i_body_2)
function i_body_2(child){
child();
}
HideUI();
}
HideUI.lblids["pe__tipo"]=['DEWPHIPEBI'];
HideUI.lblids["pecodgrp"]=['LYDVWZOYTB'];
function NIIFDUHRBQ_Valid(e) {
SetActiveField(Ctrl('NIIFDUHRBQ'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('NIIFDUHRBQ') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('pecodice','C',w_pecodice,HtW(Ctrl('NIIFDUHRBQ').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_pecodice(HtW(Ctrl('NIIFDUHRBQ').value,'C'),null,e);
return l_bSetResult;
}
}
function NIIFDUHRBQ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('NIIFDUHRBQ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('NIIFDUHRBQ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('NIIFDUHRBQ'),e);
}
function FPUPHODRZY_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('pe__tipo','N',w_pe__tipo,HtW(getComboValue(Ctrl('FPUPHODRZY')),'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_pe__tipo(HtW(getComboValue(Ctrl('FPUPHODRZY')),'N'),null,e);
return l_bSetResult;
}
}
function FPUPHODRZY_OnFocus(e) {
SetActiveField(Ctrl('FPUPHODRZY'),true);
}
function FPUPHODRZY_OnBlur(e) {
SetActiveField(Ctrl('FPUPHODRZY'),false);
}
function ROTQXTGDQV_Valid(e) {
SetActiveField(Ctrl('ROTQXTGDQV'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('pecodute','N',w_pecodute,HtW(Ctrl('ROTQXTGDQV').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_pecodute(HtW(Ctrl('ROTQXTGDQV').value,'N'),null,e);
return l_bSetResult;
}
}
function ROTQXTGDQV_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ROTQXTGDQV'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('ROTQXTGDQV',w_pecodute,'N',6,0,'999999');
SetActiveField(Ctrl('ROTQXTGDQV'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ROTQXTGDQV'),e);
}
function ROTQXTGDQV_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("999999"));
}
function ROTQXTGDQV_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('ROTQXTGDQV')),'linkview_ROTQXTGDQV','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function XHHDJCAPOZ_Valid(e) {
SetActiveField(Ctrl('XHHDJCAPOZ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('pecodgrp','N',w_pecodgrp,HtW(Ctrl('XHHDJCAPOZ').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_pecodgrp(HtW(Ctrl('XHHDJCAPOZ').value,'N'),null,e);
return l_bSetResult;
}
}
function XHHDJCAPOZ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('XHHDJCAPOZ'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('XHHDJCAPOZ',w_pecodgrp,'N',6,0,'999999');
SetActiveField(Ctrl('XHHDJCAPOZ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('XHHDJCAPOZ'),e);
}
function XHHDJCAPOZ_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("999999"));
}
function XHHDJCAPOZ_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
windowOpenForeground(link_url(link_index('XHHDJCAPOZ')),'','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,null,null,'-d-g');
}
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function NIIFDUHRBQ_wrap_Valid(event) {
return NIIFDUHRBQ_Valid(event);
}
SPBOUILib.SetInputExit('NIIFDUHRBQ',NIIFDUHRBQ_wrap_Valid);
function NIIFDUHRBQ_wrap_OnFocus(event) {
return NIIFDUHRBQ_OnFocus(event);
}
SPBOUILib.SetInputEnter('NIIFDUHRBQ',NIIFDUHRBQ_wrap_OnFocus);
function NIIFDUHRBQ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('NIIFDUHRBQ',NIIFDUHRBQ_wrap_OnKeyDown);
function FPUPHODRZY_wrap_Valid(event) {
return FPUPHODRZY_Valid(event);
}
SPBOUILib.SetComboChange('FPUPHODRZY',FPUPHODRZY_wrap_Valid,SPBOUILib.Row.IN_GRID);
function FPUPHODRZY_wrap_OnFocus(event) {
return FPUPHODRZY_OnFocus(event);
}
SPBOUILib.SetInputEnter('FPUPHODRZY',FPUPHODRZY_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function FPUPHODRZY_wrap_Blur(event) {
return FPUPHODRZY_OnBlur(event);
}
SPBOUILib.SetInputExit('FPUPHODRZY',FPUPHODRZY_wrap_Blur,SPBOUILib.Row.IN_GRID);
function ROTQXTGDQV_wrap_Valid(event) {
return ROTQXTGDQV_Valid(event);
}
SPBOUILib.SetInputExit('ROTQXTGDQV',ROTQXTGDQV_wrap_Valid,SPBOUILib.Row.IN_GRID);
function ROTQXTGDQV_wrap_OnFocus(event) {
return ROTQXTGDQV_OnFocus(event);
}
SPBOUILib.SetInputEnter('ROTQXTGDQV',ROTQXTGDQV_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function ROTQXTGDQV_wrap_OnKeyPress(event) {
return ROTQXTGDQV_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('ROTQXTGDQV',ROTQXTGDQV_wrap_OnKeyPress,SPBOUILib.Row.IN_GRID);
function ROTQXTGDQV_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('ROTQXTGDQV',ROTQXTGDQV_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function ROTQXTGDQV_ZOOM_setHandlers() {
function ROTQXTGDQV_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?ROTQXTGDQV_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('ROTQXTGDQV_ZOOM',ROTQXTGDQV_ZOOM_wrap_OnClick,SPBOUILib.Row.IN_GRID);
}
SPBOUILib.SetPicker('ROTQXTGDQV',ROTQXTGDQV_ZOOM_setHandlers);
function XHHDJCAPOZ_wrap_Valid(event) {
return XHHDJCAPOZ_Valid(event);
}
SPBOUILib.SetInputExit('XHHDJCAPOZ',XHHDJCAPOZ_wrap_Valid,SPBOUILib.Row.IN_GRID);
function XHHDJCAPOZ_wrap_OnFocus(event) {
return XHHDJCAPOZ_OnFocus(event);
}
SPBOUILib.SetInputEnter('XHHDJCAPOZ',XHHDJCAPOZ_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function XHHDJCAPOZ_wrap_OnKeyPress(event) {
return XHHDJCAPOZ_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('XHHDJCAPOZ',XHHDJCAPOZ_wrap_OnKeyPress,SPBOUILib.Row.IN_GRID);
function XHHDJCAPOZ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('XHHDJCAPOZ',XHHDJCAPOZ_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function XHHDJCAPOZ_ZOOM_setHandlers() {
function XHHDJCAPOZ_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?XHHDJCAPOZ_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('XHHDJCAPOZ_ZOOM',XHHDJCAPOZ_ZOOM_wrap_OnClick,SPBOUILib.Row.IN_GRID);
}
SPBOUILib.SetPicker('XHHDJCAPOZ',XHHDJCAPOZ_ZOOM_setHandlers);
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
m_oFather.i_last_focused_item='child_spadministration_mobapppermissions';
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
windowOpenForeground('../doc/spadministration_mobapppermissions_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_pecodice=a[0];
w_pe__tipo=a[1];
w_pecodute=a[2];
w_pecodgrp=a[3];
w_CPROWNUM=a[4];
w_descrizione=a[5];
w_descriGruppo=a[6];
m_PrimaryKeys=['CPROWNUM','pecodice'];
}
function i_PrimaryKey() {
return 'cppermappstore'+'\\'+CPLib.ToCPStr(w_pecodice);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('spadministration_mobapppermissions',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
function LinkZoomExtendedMenu() {
ExtendedMenu({"configName":WtA('spadministration_zuser','C'),"entityName":WtA('spadministration_users','C'),"fldValues":[{"expression":function() { return WtA(w_pecodute,'N'); },"field":"code","type":"N"},{"expression":function() { return WtA(w_descrizione,'C'); },"field":"name","type":"C"}],"itemRepeated":true,"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('cpusers','C'),"uid":"ROTQXTGDQV"});
}
function FocusFirstDetailComponent() {
var candidatesToFocus = ["FPUPHODRZY"];
SetControlFocus(candidatesToFocus);
}
IsRepeatedChild.child=[];
function GetFullRowMsgError() {
return 'MSG_FULLROW_NOT_SAT';
}
_Obli('pecodice',0,'NIIFDUHRBQ',false,"112851763")
_Obli('pe__tipo',1,'FPUPHODRZY',false,"1044287916")
_Obli('pecodute',1,'ROTQXTGDQV',false,"1999024119")
_Obli('pecodgrp',1,'XHHDJCAPOZ',false,"11758432523")
