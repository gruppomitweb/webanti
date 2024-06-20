function FillCombosValues() {
}
function FillInGridCombosValues(currentRow) {
var postfix = (Gt(currentRow,-1)?'_'+currentRow:'');
}
function SetControlsValue() {
var c;
if (Empty(m_cAltInterface) && (Eq(m_cFunction,'view') || Eq(m_cFunction,'query'))) {
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
SPBOUILib.SetInputValue('IHXPLCYXNH',function(){return WtH(w_RAPCOL,'C',25,0,'')},w_RAPCOL);
SPBOUILib.SetInputValue('LPKMVNCKBI',function(){return WtH(w_xdescleg,'C',50,0,'')},w_xdescleg);
} else {
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
SPBOUILib.SetInputValue('IHXPLCYXNH',function(){return WtH(w_RAPCOL,'C',25,0,'')},w_RAPCOL);
SPBOUILib.SetInputValue('FVKNSPNHTX',function(){return WtH(w_CODSOG,'C',16,0,'')},w_CODSOG);
SPBOUILib.SetInputValue('KQROMFNGNZ',function(){return WtH(w_LEGAME,'C',1,0,'')},w_LEGAME);
SPBOUILib.SetInputValue('LRZLVXCRIO',function(){return WtH(w_xragsoc,'C',70,0,'')},w_xragsoc);
SPBOUILib.SetInputValue('LPKMVNCKBI',function(){return WtH(w_xdescleg,'C',50,0,'')},w_xdescleg);
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
SetDisplay(Ctrl('PQGSBATIPW'),arfn_view_soct(Utilities.Make(window).GetCallerDate('DATAOPE'),Utilities.Make(window).GetCallerString('TIPOOPRAP'),'T'));
SetDisplay('VRCVINYRJO_DIV',IsHiddenByStateDriver('box_VRCVINYRJO'));
SetDisplay(Ctrl('IHXPLCYXNH'),Eq(1,1) || IsHiddenByStateDriver('RAPCOL'));
SetDisplay('JUPHOBFSPW_DIV',IsHiddenByStateDriver('box_JUPHOBFSPW'));
if (Ne(m_cFunction,'view')) {
SetDisplay(Ctrl('KQROMFNGNZ'),arfn_view_soct(Utilities.Make(window).GetCallerDate('DATAOPE'),Utilities.Make(window).GetCallerString('TIPOOPRAP'),'T') || IsHiddenByStateDriver('LEGAME'));
SetDisplay(Ctrl('KQROMFNGNZ_ZOOM'),arfn_view_soct(Utilities.Make(window).GetCallerDate('DATAOPE'),Utilities.Make(window).GetCallerString('TIPOOPRAP'),'T'));
}
SetDisplay(Ctrl('LPKMVNCKBI'),arfn_view_soct(Utilities.Make(window).GetCallerDate('DATAOPE'),Utilities.Make(window).GetCallerString('TIPOOPRAP'),'T') || IsHiddenByStateDriver('xdescleg'));
SetDisplay(Ctrl('SRGXXZYNNI'),arfn_view_soct(Utilities.Make(window).GetCallerDate('DATAOPE'),Utilities.Make(window).GetCallerString('TIPOOPRAP'),'T'));
LibJavascript.forEachItem(m_FoundlingHideExpression,i_body_2)
function i_body_2(child){
child();
}
HideUI();
}
function ExpandCollapseBoxesUnderCondition() {
var cond;
}
function IHXPLCYXNH_Valid(e) {
SetActiveField(Ctrl('IHXPLCYXNH'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('IHXPLCYXNH') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('RAPCOL','C',w_RAPCOL,HtW(Ctrl('IHXPLCYXNH').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_RAPCOL(HtW(Ctrl('IHXPLCYXNH').value,'C'),null,e);
return l_bSetResult;
}
}
function IHXPLCYXNH_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('IHXPLCYXNH'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('IHXPLCYXNH'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('IHXPLCYXNH'),e);
}
function FVKNSPNHTX_Valid(e) {
SetActiveField(Ctrl('FVKNSPNHTX'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CODSOG','C',w_CODSOG,HtW(Ctrl('FVKNSPNHTX').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODSOG(HtW(Ctrl('FVKNSPNHTX').value,'C'),null,e);
return l_bSetResult;
}
}
function FVKNSPNHTX_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('FVKNSPNHTX'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('FVKNSPNHTX'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('FVKNSPNHTX'),e);
}
function FVKNSPNHTX_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('FVKNSPNHTX')),'linkview_FVKNSPNHTX','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function KQROMFNGNZ_Valid(e) {
SetActiveField(Ctrl('KQROMFNGNZ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('LEGAME','C',w_LEGAME,HtW(Ctrl('KQROMFNGNZ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_LEGAME(HtW(Ctrl('KQROMFNGNZ').value,'C'),null,e);
return l_bSetResult;
}
}
function KQROMFNGNZ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('KQROMFNGNZ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('KQROMFNGNZ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('KQROMFNGNZ'),e);
}
function KQROMFNGNZ_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('KQROMFNGNZ')),'linkview_KQROMFNGNZ','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function IHXPLCYXNH_wrap_Valid(event) {
return IHXPLCYXNH_Valid(event);
}
SPBOUILib.SetInputExit('IHXPLCYXNH',IHXPLCYXNH_wrap_Valid);
function IHXPLCYXNH_wrap_OnFocus(event) {
return IHXPLCYXNH_OnFocus(event);
}
SPBOUILib.SetInputEnter('IHXPLCYXNH',IHXPLCYXNH_wrap_OnFocus);
function IHXPLCYXNH_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('IHXPLCYXNH',IHXPLCYXNH_wrap_OnKeyDown);
function FVKNSPNHTX_wrap_Valid(event) {
return FVKNSPNHTX_Valid(event);
}
SPBOUILib.SetInputExit('FVKNSPNHTX',FVKNSPNHTX_wrap_Valid,SPBOUILib.Row.IN_GRID);
function FVKNSPNHTX_wrap_OnFocus(event) {
return FVKNSPNHTX_OnFocus(event);
}
SPBOUILib.SetInputEnter('FVKNSPNHTX',FVKNSPNHTX_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function FVKNSPNHTX_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('FVKNSPNHTX',FVKNSPNHTX_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function FVKNSPNHTX_ZOOM_setHandlers() {
function FVKNSPNHTX_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?FVKNSPNHTX_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('FVKNSPNHTX_ZOOM',FVKNSPNHTX_ZOOM_wrap_OnClick,SPBOUILib.Row.IN_GRID);
}
SPBOUILib.SetPicker('FVKNSPNHTX',FVKNSPNHTX_ZOOM_setHandlers);
function KQROMFNGNZ_wrap_Valid(event) {
return KQROMFNGNZ_Valid(event);
}
SPBOUILib.SetInputExit('KQROMFNGNZ',KQROMFNGNZ_wrap_Valid,SPBOUILib.Row.IN_GRID);
function KQROMFNGNZ_wrap_OnFocus(event) {
return KQROMFNGNZ_OnFocus(event);
}
SPBOUILib.SetInputEnter('KQROMFNGNZ',KQROMFNGNZ_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function KQROMFNGNZ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('KQROMFNGNZ',KQROMFNGNZ_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function KQROMFNGNZ_ZOOM_setHandlers() {
function KQROMFNGNZ_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?KQROMFNGNZ_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('KQROMFNGNZ_ZOOM',KQROMFNGNZ_ZOOM_wrap_OnClick,SPBOUILib.Row.IN_GRID);
}
SPBOUILib.SetPicker('KQROMFNGNZ',KQROMFNGNZ_ZOOM_setHandlers);
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
m_oFather.i_last_focused_item='child_ardt_provsoginfo';
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
windowOpenForeground('../doc/ardt_provsoginfo_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_CODSOG=a[1];
w_LEGAME=a[2];
w_RAPCOL=a[3];
w_xragsoc=a[4];
w_xdescleg=a[5];
w_DOMICILIO=a[6];
w_DESCCIT=a[7];
w_PROVINCIA=a[8];
w_CAP=a[9];
m_PrimaryKeys=['RAPCOL'];
}
function i_PrimaryKey() {
return 'xoginfo'+'\\'+CPLib.ToCPStr(w_RAPCOL);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('ardt_provsoginfo',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
function LinkZoomExtendedMenu() {
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_CODSOG,'C'); },"field":"CONNES","type":"C"},{"expression":function() { return WtA(w_xragsoc,'C'); },"field":"RAGSOC","type":"C"},{"expression":function() { return WtA(w_DOMICILIO,'C'); },"field":"DOMICILIO","type":"C"},{"expression":function() { return WtA(w_DESCCIT,'C'); },"field":"DESCCIT","type":"C"},{"expression":function() { return WtA(w_PROVINCIA,'C'); },"field":"PROVINCIA","type":"C"},{"expression":function() { return WtA(w_CAP,'C'); },"field":"CAP","type":"C"}],"itemRepeated":true,"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('personbo','C'),"uid":"FVKNSPNHTX"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_LEGAME,'C'); },"field":"TIPLEG","type":"C"},{"expression":function() { return WtA(w_xdescleg,'C'); },"field":"DESCRIZ","type":"C"}],"itemRepeated":true,"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbtipleg','C'),"uid":"KQROMFNGNZ"});
}
function FocusFirstDetailComponent() {
var candidatesToFocus = ["FVKNSPNHTX"];
SetControlFocus(candidatesToFocus);
}
IsRepeatedChild.child=[];
function GetFullRowMsgError() {
return 'MSG_FULLROW_NOT_SAT';
}
_Obli('RAPCOL',0,'IHXPLCYXNH',false)
_Obli('CODSOG',0,'FVKNSPNHTX',false,"10847988462")
_Obli('LEGAME',0,'KQROMFNGNZ',false,"10639118571")
