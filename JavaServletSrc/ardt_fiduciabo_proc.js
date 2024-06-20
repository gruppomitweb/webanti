function FillCombosValues() {
}
function FillInGridCombosValues(currentRow) {
var postfix = (Gt(currentRow,-1)?'_'+currentRow:'');
}
function SetControlsValue() {
var c;
if (Empty(m_cAltInterface) && (Eq(m_cFunction,'view') || Eq(m_cFunction,'query'))) {
SPBOUILib.SetInputValue('ZXGAEXNNNE',function(){return WtH(w_RAPCOL,'C',25,0,'')},w_RAPCOL);
var tmp_NAKGRMOUXS = ToHTag(AsControlValue(w_DOMICILIO));
if (Ne(e_NAKGRMOUXS,tmp_NAKGRMOUXS)) {
SPBOUILib.SetLabelValue('NAKGRMOUXS','innerHTML',tmp_NAKGRMOUXS);
e_NAKGRMOUXS=tmp_NAKGRMOUXS;
}
var tmp_HMPQLYVATL = ToHTag(AsControlValue(LRTrim(w_CAP)+' '+LRTrim(w_DESCCIT)+' ('+LRTrim(w_PROVINCIA)+')'));
if (Ne(e_HMPQLYVATL,tmp_HMPQLYVATL)) {
SPBOUILib.SetLabelValue('HMPQLYVATL','innerHTML',tmp_HMPQLYVATL);
e_HMPQLYVATL=tmp_HMPQLYVATL;
}
} else {
SPBOUILib.SetInputValue('ZXGAEXNNNE',function(){return WtH(w_RAPCOL,'C',25,0,'')},w_RAPCOL);
SPBOUILib.SetInputValue('MPDPVTSMAO',function(){return WtH(w_CODSOG,'C',16,0,'')},w_CODSOG);
SPBOUILib.SetInputValue('KBRBGGSVYB',function(){return WtH(w_xragsoc,'C',70,0,'')},w_xragsoc);
var tmp_NAKGRMOUXS = ToHTag(AsControlValue(w_DOMICILIO));
if (Ne(e_NAKGRMOUXS,tmp_NAKGRMOUXS)) {
SPBOUILib.SetLabelValue('NAKGRMOUXS','innerHTML',tmp_NAKGRMOUXS);
e_NAKGRMOUXS=tmp_NAKGRMOUXS;
}
var tmp_HMPQLYVATL = ToHTag(AsControlValue(LRTrim(w_CAP)+' '+LRTrim(w_DESCCIT)+' ('+LRTrim(w_PROVINCIA)+')'));
if (Ne(e_HMPQLYVATL,tmp_HMPQLYVATL)) {
SPBOUILib.SetLabelValue('HMPQLYVATL','innerHTML',tmp_HMPQLYVATL);
e_HMPQLYVATL=tmp_HMPQLYVATL;
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
SetDisplay(Ctrl('ZXGAEXNNNE'),true || IsHiddenByStateDriver('RAPCOL'));
SetDisplay('VRCVINYRJO_DIV',IsHiddenByStateDriver('box_VRCVINYRJO'));
SetDisplay('JUPHOBFSPW_DIV',IsHiddenByStateDriver('box_JUPHOBFSPW'));
LibJavascript.forEachItem(m_FoundlingHideExpression,i_body_2)
function i_body_2(child){
child();
}
HideUI();
}
HideUI.lblids["CODSOG"]=['RNFAUKYRCS'];
function ExpandCollapseBoxesUnderCondition() {
var cond;
}
function ZXGAEXNNNE_Valid(e) {
SetActiveField(Ctrl('ZXGAEXNNNE'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('ZXGAEXNNNE') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('RAPCOL','C',w_RAPCOL,HtW(Ctrl('ZXGAEXNNNE').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_RAPCOL(HtW(Ctrl('ZXGAEXNNNE').value,'C'),null,e);
return l_bSetResult;
}
}
function ZXGAEXNNNE_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ZXGAEXNNNE'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('ZXGAEXNNNE'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ZXGAEXNNNE'),e);
}
function MPDPVTSMAO_Valid(e) {
SetActiveField(Ctrl('MPDPVTSMAO'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CODSOG','C',w_CODSOG,HtW(Ctrl('MPDPVTSMAO').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODSOG(HtW(Ctrl('MPDPVTSMAO').value,'C'),null,e);
return l_bSetResult;
}
}
function MPDPVTSMAO_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('MPDPVTSMAO'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('MPDPVTSMAO'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('MPDPVTSMAO'),e);
}
function MPDPVTSMAO_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('MPDPVTSMAO')),'linkview_MPDPVTSMAO','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function ZXGAEXNNNE_wrap_Valid(event) {
return ZXGAEXNNNE_Valid(event);
}
SPBOUILib.SetInputExit('ZXGAEXNNNE',ZXGAEXNNNE_wrap_Valid);
function ZXGAEXNNNE_wrap_OnFocus(event) {
return ZXGAEXNNNE_OnFocus(event);
}
SPBOUILib.SetInputEnter('ZXGAEXNNNE',ZXGAEXNNNE_wrap_OnFocus);
function ZXGAEXNNNE_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('ZXGAEXNNNE',ZXGAEXNNNE_wrap_OnKeyDown);
function MPDPVTSMAO_wrap_Valid(event) {
return MPDPVTSMAO_Valid(event);
}
SPBOUILib.SetInputExit('MPDPVTSMAO',MPDPVTSMAO_wrap_Valid,SPBOUILib.Row.IN_GRID);
function MPDPVTSMAO_wrap_OnFocus(event) {
return MPDPVTSMAO_OnFocus(event);
}
SPBOUILib.SetInputEnter('MPDPVTSMAO',MPDPVTSMAO_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function MPDPVTSMAO_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('MPDPVTSMAO',MPDPVTSMAO_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function MPDPVTSMAO_ZOOM_setHandlers() {
function MPDPVTSMAO_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?MPDPVTSMAO_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('MPDPVTSMAO_ZOOM',MPDPVTSMAO_ZOOM_wrap_OnClick,SPBOUILib.Row.IN_GRID);
}
SPBOUILib.SetPicker('MPDPVTSMAO',MPDPVTSMAO_ZOOM_setHandlers);
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
m_oFather.i_last_focused_item='child_ardt_fiduciabo';
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
windowOpenForeground('../doc/ardt_fiduciabo_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
}
function CalledBatchEnd() {
if ( ! (m_bCalculating)) {
DoUpdate(true);
}
}
function LoadChildrenInPage(page,lazy) {
}
GetLayerID.Layers.push({"id":"VRCVINYRJO","name":"box_VRCVINYRJO"});
GetLayerID.Layers.push({"id":"JUPHOBFSPW","name":"box_JUPHOBFSPW"});
GetLayerID.CheckEditRow=true;
function DeclareWVs() {
var a = arguments;
w_IDFILEBO=a[0];
w_RAPCOL=a[1];
w_NUMCOL=a[2];
w_CODSOG=a[3];
w_TIPOFILE=a[4];
w_LEGAME=a[5];
w_UCODE=a[6];
w_IDBASE=a[7];
w_NUMIMP=a[8];
w_xragsoc=a[9];
w_PROVINCIA=a[10];
w_CAP=a[11];
w_DESCCIT=a[12];
w_DOMICILIO=a[13];
m_PrimaryKeys=['CODSOG','RAPCOL'];
}
function i_PrimaryKey() {
return 'fiduciabo'+'\\'+CPLib.ToCPStr(w_RAPCOL);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('ardt_fiduciabo',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
function LinkZoomExtendedMenu() {
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_CODSOG,'C'); },"field":"CONNES","type":"C"},{"expression":function() { return WtA(w_xragsoc,'C'); },"field":"RAGSOC","type":"C"},{"expression":function() { return WtA(w_DOMICILIO,'C'); },"field":"DOMICILIO","type":"C"},{"expression":function() { return WtA(w_DESCCIT,'C'); },"field":"DESCCIT","type":"C"},{"expression":function() { return WtA(w_PROVINCIA,'C'); },"field":"PROVINCIA","type":"C"},{"expression":function() { return WtA(w_CAP,'C'); },"field":"CAP","type":"C"}],"itemRepeated":true,"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('personbo','C'),"uid":"MPDPVTSMAO"});
}
function FocusFirstDetailComponent() {
var candidatesToFocus = ["MPDPVTSMAO"];
SetControlFocus(candidatesToFocus);
}
IsRepeatedChild.child=[];
function GetFullRowMsgError() {
return 'MSG_FULLROW_NOT_SAT';
}
_Obli('RAPCOL',0,'ZXGAEXNNNE',false,"1699714614")
_Obli('CODSOG',0,'MPDPVTSMAO',false,"10847988462")
