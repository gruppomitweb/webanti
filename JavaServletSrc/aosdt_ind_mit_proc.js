function FillCombosValues() {
}
function FillInGridCombosValues(currentRow) {
var postfix = (Gt(currentRow,-1)?'_'+currentRow:'');
}
function SetControlsValue() {
var c;
if (Empty(m_cAltInterface) && (Eq(m_cFunction,'view') || Eq(m_cFunction,'query'))) {
SPBOUILib.SetInputValue('ACPSBOFDKQ',function(){return WtH(w_IDMOD,'C',10,0,'')},w_IDMOD);
SPBOUILib.SetInputValue('ATCXZHNKXY',function(){return WtH(w_DESCRI_layer,'M',10,0,'')},w_DESCRI_layer);
} else {
SPBOUILib.SetInputValue('ACPSBOFDKQ',function(){return WtH(w_IDMOD,'C',10,0,'')},w_IDMOD);
SPBOUILib.SetInputValue('UZHWXXEKCO',function(){return WtH(w_IDIND,'C',10,0,'')},w_IDIND);
SPBOUILib.SetInputValue('EALKDPXAET',function(){return WtH(w_PROGIND,'C',10,0,'')},w_PROGIND);
SPBOUILib.SetInputValue('YMZFJACJWK',function(){return WtH(w_DESCRI,'M',10,0,'')},w_DESCRI);
SPBOUILib.SetInputValue('ATCXZHNKXY',function(){return WtH(w_DESCRI_layer,'M',10,0,'')},w_DESCRI_layer);
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
SetDisplay(Ctrl('ACPSBOFDKQ'),true || IsHiddenByStateDriver('IDMOD'));
Z.Tabs.Get("tabs_1_Indicatori").Hide('ROSLSYYTGJ',IsHiddenByStateDriver('Indicatore'));
Z.Tabs.Get("tabs_1_Indicatori").Hide('ZURPIOBYMT',IsHiddenByStateDriver('Subindicatori'));
LibJavascript.forEachItem(m_FoundlingHideExpression,i_body_2)
function i_body_2(child){
child();
}
HideUI();
}
HideUI.lblids["DESCRI"]=['TMVRTXYLAV'];
HideUI.lblids["IDIND"]=['BJEPNVQTTI'];
HideUI.lblids["PROGIND"]=['EHNCCRAZSJ'];
function ExpandCollapseBoxesUnderCondition() {
var cond;
}
function ACPSBOFDKQ_Valid(e) {
SetActiveField(Ctrl('ACPSBOFDKQ'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('ACPSBOFDKQ') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('IDMOD','C',w_IDMOD,HtW(Ctrl('ACPSBOFDKQ').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IDMOD(HtW(Ctrl('ACPSBOFDKQ').value,'C'),null,e);
return l_bSetResult;
}
}
function ACPSBOFDKQ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ACPSBOFDKQ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('ACPSBOFDKQ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ACPSBOFDKQ'),e);
}
function UZHWXXEKCO_Valid(e) {
SetActiveField(Ctrl('UZHWXXEKCO'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('IDIND','C',w_IDIND,HtW(Ctrl('UZHWXXEKCO').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IDIND(HtW(Ctrl('UZHWXXEKCO').value,'C'),null,e);
return l_bSetResult;
}
}
function UZHWXXEKCO_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('UZHWXXEKCO'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('UZHWXXEKCO'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('UZHWXXEKCO'),e);
}
function EALKDPXAET_Valid(e) {
SetActiveField(Ctrl('EALKDPXAET'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('PROGIND','C',w_PROGIND,HtW(Ctrl('EALKDPXAET').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PROGIND(HtW(Ctrl('EALKDPXAET').value,'C'),null,e);
return l_bSetResult;
}
}
function EALKDPXAET_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('EALKDPXAET'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('EALKDPXAET'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('EALKDPXAET'),e);
}
function href_KWRCVYJSPV(el) {
ToggleLayerBox(arguments.length>0 && arguments[0].isConnected?arguments[0]:'KWRCVYJSPV',GetLayerID("Descrizione"),'00',true,'GridTable_Band_DIV','GridTable_Band_HEADER',false)
}
function YMZFJACJWK_Valid(e) {
SetActiveField(Ctrl('YMZFJACJWK'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DESCRI','M',w_DESCRI,HtW(Ctrl('YMZFJACJWK').value,'M'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DESCRI(HtW(Ctrl('YMZFJACJWK').value,'M'),null,e);
return l_bSetResult;
}
}
function YMZFJACJWK_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('YMZFJACJWK'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('YMZFJACJWK'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('YMZFJACJWK'),e);
}
function ATCXZHNKXY_Valid(e) {
SetActiveField(Ctrl('ATCXZHNKXY'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DESCRI_layer','M',w_DESCRI_layer,HtW(Ctrl('ATCXZHNKXY').value,'M'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DESCRI_layer(HtW(Ctrl('ATCXZHNKXY').value,'M'),null,e);
return l_bSetResult;
}
}
function ATCXZHNKXY_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ATCXZHNKXY'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('ATCXZHNKXY'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ATCXZHNKXY'),e);
}
linkpc_url.u('ABXVVUNOEJ',function(){return 'aosdt_sub_ind_mit?m_bInnerChild=true'+GetLinkPCKeys('aosdt_sub_ind_mit')+'&m_bRowsChild='+EnableChild('aosdt_sub_ind_mit')})
_ResetTracker();
function setEventHandlers() {
var c;
function KWRCVYJSPV_wrap_OnClick(event) {
return href_KWRCVYJSPV(event.srcElement);
}
SPBOUILib.SetImageClick('KWRCVYJSPV',KWRCVYJSPV_wrap_OnClick,SPBOUILib.Row.ALWAYS_ENABLED);
function KWRCVYJSPV_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetKeyDown('KWRCVYJSPV',KWRCVYJSPV_wrap_OnKeyDown,SPBOUILib.Row.ALWAYS_ENABLED);
if (Ne(m_cFunction,'view')) {
function ACPSBOFDKQ_wrap_Valid(event) {
return ACPSBOFDKQ_Valid(event);
}
SPBOUILib.SetInputExit('ACPSBOFDKQ',ACPSBOFDKQ_wrap_Valid);
function ACPSBOFDKQ_wrap_OnFocus(event) {
return ACPSBOFDKQ_OnFocus(event);
}
SPBOUILib.SetInputEnter('ACPSBOFDKQ',ACPSBOFDKQ_wrap_OnFocus);
function ACPSBOFDKQ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('ACPSBOFDKQ',ACPSBOFDKQ_wrap_OnKeyDown);
function UZHWXXEKCO_wrap_Valid(event) {
return UZHWXXEKCO_Valid(event);
}
SPBOUILib.SetInputExit('UZHWXXEKCO',UZHWXXEKCO_wrap_Valid,SPBOUILib.Row.IN_GRID);
function UZHWXXEKCO_wrap_OnFocus(event) {
return UZHWXXEKCO_OnFocus(event);
}
SPBOUILib.SetInputEnter('UZHWXXEKCO',UZHWXXEKCO_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function UZHWXXEKCO_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('UZHWXXEKCO',UZHWXXEKCO_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function EALKDPXAET_wrap_Valid(event) {
return EALKDPXAET_Valid(event);
}
SPBOUILib.SetInputExit('EALKDPXAET',EALKDPXAET_wrap_Valid,SPBOUILib.Row.IN_GRID);
function EALKDPXAET_wrap_OnFocus(event) {
return EALKDPXAET_OnFocus(event);
}
SPBOUILib.SetInputEnter('EALKDPXAET',EALKDPXAET_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function EALKDPXAET_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('EALKDPXAET',EALKDPXAET_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function YMZFJACJWK_wrap_Valid(event) {
return YMZFJACJWK_Valid(event);
}
SPBOUILib.SetInputExit('YMZFJACJWK',YMZFJACJWK_wrap_Valid,SPBOUILib.Row.IN_GRID);
function YMZFJACJWK_wrap_OnFocus(event) {
return YMZFJACJWK_OnFocus(event);
}
SPBOUILib.SetInputEnter('YMZFJACJWK',YMZFJACJWK_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function ATCXZHNKXY_wrap_Valid(event) {
return ATCXZHNKXY_Valid(event);
}
SPBOUILib.SetInputExit('ATCXZHNKXY',ATCXZHNKXY_wrap_Valid);
function ATCXZHNKXY_wrap_OnFocus(event) {
return ATCXZHNKXY_OnFocus(event);
}
SPBOUILib.SetInputEnter('ATCXZHNKXY',ATCXZHNKXY_wrap_OnFocus);
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
if (Eq(p_cEvent,'Descrizione enter')) {
if (Ne(typeof(Calculation_TQCPNMUFSK),'undefined')) {
old_c=m_bCalculating;
m_bCalculating=true;
Calculation_TQCPNMUFSK();
m_bCalculating=old_c;
if ( ! (old_c)) {
DoUpdate(true);
}
}
} else if (Eq(p_cEvent,'Descrizione exit')) {
if (Ne(typeof(Calculation_LCRFZTFQSM),'undefined')) {
old_c=m_bCalculating;
m_bCalculating=true;
Calculation_LCRFZTFQSM();
m_bCalculating=old_c;
if ( ! (old_c)) {
DoUpdate(true);
}
}
}
}
function SetLastFocusedOnParent() {
if (IsWndAccessible(window['m_oFather'])) {
m_oFather.i_last_focused_item='child_aosdt_ind_mit';
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
FocusLayerFirstComponent.Layers['VGASZRXNOJ_DIV']='ATCXZHNKXY';
function closeContextMenu_VGASZRXNOJ() {
}
function Help() {
windowOpenForeground('../doc/aosdt_ind_mit_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
}
function CalledBatchEnd() {
if ( ! (m_bCalculating)) {
DoUpdate(true);
}
}
function SetModified_aosdt_sub_ind_mit() {
SetModified(true);
}
function LoadChildrenInPage(page,lazy) {
if (Eq(page,'page_1')) {
if (ChildToLoad('ABXVVUNOEJ')) {
LoadContext.lc(1,'ABXVVUNOEJ');
} else {
LibJavascript.RefreshChildGrid('ABXVVUNOEJ');
}
}
}
GetLayerID.Layers.push({"id":"ROSLSYYTGJ","name":"Indicatore"});
GetLayerID.Layers.push({"id":"ZURPIOBYMT","name":"Subindicatori"});
GetLayerID.Layers.push({"id":"VGASZRXNOJ_DIV","name":"Descrizione"});
GetLayerID.CheckEditRow=true;
function DeclareWVs() {
var a = arguments;
w_IDMOD=a[0];
w_IDIND=a[1];
w_PROGIND=a[2];
w_DESCRI=a[3];
w_DESCRI_layer=a[4];
m_cWv_aosdt_sub_ind_mit=a[5];
if (Gt(a.length,6)) {
m_cErrorInChild='';
}
m_PrimaryKeys=['IDIND','IDMOD'];
}
function i_PrimaryKey() {
return 'ind_mit'+'\\'+CPLib.ToCPStr(w_IDMOD);
}
GetLinkPCKeys.set_o('aosdt_sub_ind_mit',true);
GetLinkPCKeys.o['aosdt_sub_ind_mit']['IDMOD']=function(t){
if (Ne(m_cFunction,'new')) {
return t(w_IDMOD,'C');
}
}
GetLinkPCKeys.o['aosdt_sub_ind_mit']['IDIND']=function(t){
if (Ne(m_cFunction,'new')) {
return t(w_IDIND,'C');
}
}
resizeChildIframe.children['aosdt_sub_ind_mit']=true;
function EnableChild(name) {
var l_bRes = m_bRowsChild;
switch (name) {
case 'aosdt_sub_ind_mit':
l_bRes=l_bRes || true;
break;
}
return l_bRes;
}
function CheckZone(me) {
var totals = {"ATCXZHNKXY":["VGASZRXNOJ"]};
var oldZones = totals[i_last_focused_item];
var differences = GetZoneArrayDifference(totals[me]||[],oldZones||[]);
try {
if (Ne(LibJavascript.Array.indexOf(differences,'VGASZRXNOJ'),-1) &&  ! (Check_VGASZRXNOJ(true,true))) {
return false;
}
} finally {
var newZones = totals[me]||[];
if (Ne(LibJavascript.Array.indexOf(newZones,'VGASZRXNOJ'),-1)) {
NotifyEvent('Descrizione enter');
}
}
return true;
}
LoadContext.f('ABXVVUNOEJ',function(){return FrameRef('aosdt_sub_ind_mit')},1,'aosdt_sub_ind_mit',1,2)
GetSelectedChildPage.child={'aosdt_sub_ind_mit': function(){return FrameRef('aosdt_sub_ind_mit')}}
function GetSelectedPage(p_d) {
p_d.setValue('aosdt_ind_mit',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
function LinkZoomExtendedMenu() {
}
function FocusFirstDetailComponent() {
var candidatesToFocus = ["EALKDPXAET"];
SetControlFocus(candidatesToFocus);
}
IsRepeatedChild.child=['ABXVVUNOEJ'];
function GetFullRowMsgError() {
return '10648001559';
}
_Obli('IDMOD',0,'ACPSBOFDKQ',false,"10024211400")
_Obli('IDIND',0,'UZHWXXEKCO',false,"1305674908")
_Obli('PROGIND',0,'EALKDPXAET',false,"11411528788")
_Obli('DESCRI',0,'YMZFJACJWK',false,"10298248210")
_Obli('DESCRI_layer',0,'ATCXZHNKXY',false,"285808099")
