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
SPBOUILib.SetInputValue('QPLXZEEVEI',function(){return WtH(w_RAPPORTO,'C',25,0,'')},w_RAPPORTO);
SPBOUILib.SetInputValue('KQHTAXPURL',function(){return WtH(w_TIPORAP,'C',1,0,'')},w_TIPORAP);
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
SPBOUILib.SetInputValue('QPLXZEEVEI',function(){return WtH(w_RAPPORTO,'C',25,0,'')},w_RAPPORTO);
SPBOUILib.SetInputValue('XTDHYWJPZL',function(){return WtH(w_CODINTER,'C',16,0,'')},w_CODINTER);
SPBOUILib.SetInputValue('HKZAUFLHMG',function(){return WtH(w_DATAINI,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATAINI);
SPBOUILib.SetInputValue('NATIUIQLJX',function(){return WtH(w_DATAFINE,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATAFINE);
SPBOUILib.SetInputValue('ZUSOGKEVZC',function(){return WtH(w_xragsoci,'C',40,0,'')},w_xragsoci);
SPBOUILib.SetInputValue('KQHTAXPURL',function(){return WtH(w_TIPORAP,'C',1,0,'')},w_TIPORAP);
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
SetDisplay(Ctrl('QPLXZEEVEI'),Eq(1,1) || IsHiddenByStateDriver('RAPPORTO'));
SetDisplay(Ctrl('KQHTAXPURL'),true || IsHiddenByStateDriver('TIPORAP'));
LibJavascript.forEachItem(m_FoundlingHideExpression,i_body_2)
function i_body_2(child){
child();
}
HideUI();
}
function QPLXZEEVEI_Valid(e) {
SetActiveField(Ctrl('QPLXZEEVEI'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('QPLXZEEVEI') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('RAPPORTO','C',w_RAPPORTO,HtW(Ctrl('QPLXZEEVEI').value,'C'),m_bQueryOnLatestKeyOnly);
}
}
}
function QPLXZEEVEI_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('QPLXZEEVEI'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('QPLXZEEVEI'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('QPLXZEEVEI'),e);
}
function XTDHYWJPZL_Valid(e) {
SetActiveField(Ctrl('XTDHYWJPZL'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CODINTER','C',w_CODINTER,HtW(Ctrl('XTDHYWJPZL').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODINTER(HtW(Ctrl('XTDHYWJPZL').value,'C'),null,e);
return l_bSetResult;
}
}
function XTDHYWJPZL_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('XTDHYWJPZL'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('XTDHYWJPZL'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('XTDHYWJPZL'),e);
}
function XTDHYWJPZL_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('XTDHYWJPZL')),'linkview_XTDHYWJPZL','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function HKZAUFLHMG_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('HKZAUFLHMG'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('HKZAUFLHMG').value=ApplyPictureToDate(Ctrl('HKZAUFLHMG').value,TranslatePicture(datePattern),'HKZAUFLHMG');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('HKZAUFLHMG'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('HKZAUFLHMG');
}
}
}
SetActiveField(Ctrl('HKZAUFLHMG'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATAINI','D',w_DATAINI,HtW(Ctrl('HKZAUFLHMG').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATAINI(HtW(Ctrl('HKZAUFLHMG').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function HKZAUFLHMG_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('HKZAUFLHMG'))) {
DisplayErrorMessage();
}
if ( ! (GetDisabled('HKZAUFLHMG'))) {
if (Eq(w_DATAINI,NullDate()) && Eq(_tracker.ctrl,null)) {
Ctrl('HKZAUFLHMG').value=WtH(Utilities.Make(window).GetCallerDate('DATAOPE'),'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
} else {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('HKZAUFLHMG',w_DATAINI,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
}
}
m_oEnteredInDate=Ctrl('HKZAUFLHMG');
SetActiveField(Ctrl('HKZAUFLHMG'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('HKZAUFLHMG'),e);
}
function NATIUIQLJX_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('NATIUIQLJX'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('NATIUIQLJX').value=ApplyPictureToDate(Ctrl('NATIUIQLJX').value,TranslatePicture(datePattern),'NATIUIQLJX');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('NATIUIQLJX'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('NATIUIQLJX');
}
}
}
SetActiveField(Ctrl('NATIUIQLJX'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATAFINE','D',w_DATAFINE,HtW(Ctrl('NATIUIQLJX').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATAFINE(HtW(Ctrl('NATIUIQLJX').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function NATIUIQLJX_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('NATIUIQLJX'))) {
DisplayErrorMessage();
}
if ( ! (GetDisabled('NATIUIQLJX'))) {
if (Eq(w_DATAFINE,NullDate()) && Eq(_tracker.ctrl,null)) {
Ctrl('NATIUIQLJX').value=WtH(Utilities.Make(window).GetCallerDate('DATAOPE'),'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
} else {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('NATIUIQLJX',w_DATAFINE,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
}
}
m_oEnteredInDate=Ctrl('NATIUIQLJX');
SetActiveField(Ctrl('NATIUIQLJX'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('NATIUIQLJX'),e);
}
function KQHTAXPURL_Valid(e) {
SetActiveField(Ctrl('KQHTAXPURL'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TIPORAP','C',w_TIPORAP,HtW(Ctrl('KQHTAXPURL').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TIPORAP(HtW(Ctrl('KQHTAXPURL').value,'C'),null,e);
return l_bSetResult;
}
}
function KQHTAXPURL_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('KQHTAXPURL'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('KQHTAXPURL'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('KQHTAXPURL'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function QPLXZEEVEI_wrap_Valid(event) {
return QPLXZEEVEI_Valid(event);
}
SPBOUILib.SetInputExit('QPLXZEEVEI',QPLXZEEVEI_wrap_Valid);
function QPLXZEEVEI_wrap_OnFocus(event) {
return QPLXZEEVEI_OnFocus(event);
}
SPBOUILib.SetInputEnter('QPLXZEEVEI',QPLXZEEVEI_wrap_OnFocus);
function QPLXZEEVEI_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('QPLXZEEVEI',QPLXZEEVEI_wrap_OnKeyDown);
function XTDHYWJPZL_wrap_Valid(event) {
return XTDHYWJPZL_Valid(event);
}
SPBOUILib.SetInputExit('XTDHYWJPZL',XTDHYWJPZL_wrap_Valid,SPBOUILib.Row.IN_GRID);
function XTDHYWJPZL_wrap_OnFocus(event) {
return XTDHYWJPZL_OnFocus(event);
}
SPBOUILib.SetInputEnter('XTDHYWJPZL',XTDHYWJPZL_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function XTDHYWJPZL_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('XTDHYWJPZL',XTDHYWJPZL_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function XTDHYWJPZL_ZOOM_setHandlers() {
function XTDHYWJPZL_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?XTDHYWJPZL_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('XTDHYWJPZL_ZOOM',XTDHYWJPZL_ZOOM_wrap_OnClick,SPBOUILib.Row.IN_GRID);
}
SPBOUILib.SetPicker('XTDHYWJPZL',XTDHYWJPZL_ZOOM_setHandlers);
function HKZAUFLHMG_wrap_Valid(event) {
return HKZAUFLHMG_Valid(event);
}
SPBOUILib.SetInputExit('HKZAUFLHMG',HKZAUFLHMG_wrap_Valid,SPBOUILib.Row.IN_GRID);
function HKZAUFLHMG_wrap_OnFocus(event) {
return HKZAUFLHMG_OnFocus(event);
}
SPBOUILib.SetInputEnter('HKZAUFLHMG',HKZAUFLHMG_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function HKZAUFLHMG_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('HKZAUFLHMG',HKZAUFLHMG_wrap_OnKeyPress,SPBOUILib.Row.IN_GRID);
function HKZAUFLHMG_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('HKZAUFLHMG',HKZAUFLHMG_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function NATIUIQLJX_wrap_Valid(event) {
return NATIUIQLJX_Valid(event);
}
SPBOUILib.SetInputExit('NATIUIQLJX',NATIUIQLJX_wrap_Valid,SPBOUILib.Row.IN_GRID);
function NATIUIQLJX_wrap_OnFocus(event) {
return NATIUIQLJX_OnFocus(event);
}
SPBOUILib.SetInputEnter('NATIUIQLJX',NATIUIQLJX_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function NATIUIQLJX_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('NATIUIQLJX',NATIUIQLJX_wrap_OnKeyPress,SPBOUILib.Row.IN_GRID);
function NATIUIQLJX_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('NATIUIQLJX',NATIUIQLJX_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function KQHTAXPURL_wrap_Valid(event) {
return KQHTAXPURL_Valid(event);
}
SPBOUILib.SetInputExit('KQHTAXPURL',KQHTAXPURL_wrap_Valid);
function KQHTAXPURL_wrap_OnFocus(event) {
return KQHTAXPURL_OnFocus(event);
}
SPBOUILib.SetInputEnter('KQHTAXPURL',KQHTAXPURL_wrap_OnFocus);
function KQHTAXPURL_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('KQHTAXPURL',KQHTAXPURL_wrap_OnKeyDown);
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
m_oFather.i_last_focused_item='child_ardt_storinformazioni';
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
windowOpenForeground('../doc/ardt_storinformazioni_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_IDBASE=a[0];
w_CODINTER=a[1];
w_DATAINI=a[2];
w_DATAFINE=a[3];
w_TIPOPERS=a[4];
w_NUMPROG1=a[5];
w_NUMPROG2=a[6];
w_RAPPORTO=a[7];
w_PRGIMPSOG=a[8];
w_STATOREG=a[9];
w_IDEREG=a[10];
w_TIPORAP=a[11];
w_xragsoci=a[12];
w_tipreg=a[13];
w_appoggio=a[14];
w_tiporegr=a[15];
w_DOMICILIO=a[16];
w_DESCCIT=a[17];
w_PROVINCIA=a[18];
w_CAP=a[19];
w_gAzienda=a[20];
m_PrimaryKeys=['RAPPORTO'];
}
function i_PrimaryKey() {
return 'wntestbo'+'\\'+CPLib.ToCPStr(w_RAPPORTO);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('ardt_storinformazioni',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
function LinkZoomExtendedMenu() {
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_CODINTER,'C'); },"field":"CONNES","type":"C"},{"expression":function() { return WtA(w_xragsoci,'C'); },"field":"RAGSOC","type":"C"},{"expression":function() { return WtA(w_DOMICILIO,'C'); },"field":"DOMICILIO","type":"C"},{"expression":function() { return WtA(w_DESCCIT,'C'); },"field":"DESCCIT","type":"C"},{"expression":function() { return WtA(w_PROVINCIA,'C'); },"field":"PROVINCIA","type":"C"},{"expression":function() { return WtA(w_CAP,'C'); },"field":"CAP","type":"C"}],"itemRepeated":true,"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('personbo','C'),"uid":"XTDHYWJPZL"});
}
function FocusFirstDetailComponent() {
var candidatesToFocus = ["XTDHYWJPZL"];
SetControlFocus(candidatesToFocus);
}
IsRepeatedChild.child=[];
function GetFullRowMsgError() {
return 'MSG_FULLROW_NOT_SAT';
}
_Obli('CODINTER',0,'XTDHYWJPZL',false,"942986941")
_Obli('DATAINI',2,'HKZAUFLHMG',false,"45547614")
_Obli('TIPORAP',0,'KQHTAXPURL',false,"1723736132")
_Obli('DATAFINE',2,'NATIUIQLJX',false,"1300662969")
