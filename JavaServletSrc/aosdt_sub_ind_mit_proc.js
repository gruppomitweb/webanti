function FillCombosValues() {
}
function FillInGridCombosValues(currentRow) {
var postfix = (Gt(currentRow,-1)?'_'+currentRow:'');
}
function SetControlsValue() {
var c;
if (Empty(m_cAltInterface) && (Eq(m_cFunction,'view') || Eq(m_cFunction,'query'))) {
SPBOUILib.SetInputValue('LNSBOLUCRM',function(){return WtH(w_IDMOD,'C',10,0,'')},w_IDMOD);
SPBOUILib.SetInputValue('ILPNZWVGRZ',function(){return WtH(w_IDIND,'C',10,0,'')},w_IDIND);
SPBOUILib.SetInputValue('ATCXZHNKXY',function(){return WtH(w_DESCRI_layer,'M',10,0,'')},w_DESCRI_layer);
} else {
SPBOUILib.SetInputValue('LNSBOLUCRM',function(){return WtH(w_IDMOD,'C',10,0,'')},w_IDMOD);
SPBOUILib.SetInputValue('ILPNZWVGRZ',function(){return WtH(w_IDIND,'C',10,0,'')},w_IDIND);
SPBOUILib.SetInputValue('BBCHCNQIRI',function(){return WtH(w_IDSUBIND,'C',10,0,'')},w_IDSUBIND);
SPBOUILib.SetInputValue('HLHLHCXGMT',function(){return WtH(w_PROGSUBIND,'C',10,0,'')},w_PROGSUBIND);
SPBOUILib.SetInputValue('BBEEHSSDFM',function(){return WtH(w_DESCRI,'M',10,0,'')},w_DESCRI);
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
SetDisplay(Ctrl('LNSBOLUCRM'),true || IsHiddenByStateDriver('IDMOD'));
SetDisplay(Ctrl('ILPNZWVGRZ'),true || IsHiddenByStateDriver('IDIND'));
LibJavascript.forEachItem(m_FoundlingHideExpression,i_body_2)
function i_body_2(child){
child();
}
HideUI();
}
HideUI.lblids["DESCRI"]=['DGTNNOYUNI'];
HideUI.lblids["IDSUBIND"]=['STIWBITFVZ'];
HideUI.lblids["PROGSUBIND"]=['SCYMKSACPR'];
function ExpandCollapseBoxesUnderCondition() {
var cond;
}
function LNSBOLUCRM_Valid(e) {
SetActiveField(Ctrl('LNSBOLUCRM'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('LNSBOLUCRM') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('IDMOD','C',w_IDMOD,HtW(Ctrl('LNSBOLUCRM').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IDMOD(HtW(Ctrl('LNSBOLUCRM').value,'C'),null,e);
return l_bSetResult;
}
}
function LNSBOLUCRM_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('LNSBOLUCRM'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('LNSBOLUCRM'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('LNSBOLUCRM'),e);
}
function ILPNZWVGRZ_Valid(e) {
SetActiveField(Ctrl('ILPNZWVGRZ'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('ILPNZWVGRZ') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('IDIND','C',w_IDIND,HtW(Ctrl('ILPNZWVGRZ').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IDIND(HtW(Ctrl('ILPNZWVGRZ').value,'C'),null,e);
return l_bSetResult;
}
}
function ILPNZWVGRZ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ILPNZWVGRZ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('ILPNZWVGRZ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ILPNZWVGRZ'),e);
}
function BBCHCNQIRI_Valid(e) {
SetActiveField(Ctrl('BBCHCNQIRI'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('IDSUBIND','C',w_IDSUBIND,HtW(Ctrl('BBCHCNQIRI').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IDSUBIND(HtW(Ctrl('BBCHCNQIRI').value,'C'),null,e);
return l_bSetResult;
}
}
function BBCHCNQIRI_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('BBCHCNQIRI'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('BBCHCNQIRI'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('BBCHCNQIRI'),e);
}
function HLHLHCXGMT_Valid(e) {
SetActiveField(Ctrl('HLHLHCXGMT'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('PROGSUBIND','C',w_PROGSUBIND,HtW(Ctrl('HLHLHCXGMT').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PROGSUBIND(HtW(Ctrl('HLHLHCXGMT').value,'C'),null,e);
return l_bSetResult;
}
}
function HLHLHCXGMT_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('HLHLHCXGMT'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('HLHLHCXGMT'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('HLHLHCXGMT'),e);
}
function href_KWRCVYJSPV(el) {
ToggleLayerBox(arguments.length>0 && arguments[0].isConnected?arguments[0]:'KWRCVYJSPV',GetLayerID("Descrizione"),'20',true,'GridTable_Band_DIV','GridTable_Band_HEADER',false)
}
function BBEEHSSDFM_Valid(e) {
SetActiveField(Ctrl('BBEEHSSDFM'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DESCRI','M',w_DESCRI,HtW(Ctrl('BBEEHSSDFM').value,'M'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DESCRI(HtW(Ctrl('BBEEHSSDFM').value,'M'),null,e);
return l_bSetResult;
}
}
function BBEEHSSDFM_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('BBEEHSSDFM'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('BBEEHSSDFM'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('BBEEHSSDFM'),e);
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
function LNSBOLUCRM_wrap_Valid(event) {
return LNSBOLUCRM_Valid(event);
}
SPBOUILib.SetInputExit('LNSBOLUCRM',LNSBOLUCRM_wrap_Valid);
function LNSBOLUCRM_wrap_OnFocus(event) {
return LNSBOLUCRM_OnFocus(event);
}
SPBOUILib.SetInputEnter('LNSBOLUCRM',LNSBOLUCRM_wrap_OnFocus);
function LNSBOLUCRM_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('LNSBOLUCRM',LNSBOLUCRM_wrap_OnKeyDown);
function ILPNZWVGRZ_wrap_Valid(event) {
return ILPNZWVGRZ_Valid(event);
}
SPBOUILib.SetInputExit('ILPNZWVGRZ',ILPNZWVGRZ_wrap_Valid);
function ILPNZWVGRZ_wrap_OnFocus(event) {
return ILPNZWVGRZ_OnFocus(event);
}
SPBOUILib.SetInputEnter('ILPNZWVGRZ',ILPNZWVGRZ_wrap_OnFocus);
function ILPNZWVGRZ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('ILPNZWVGRZ',ILPNZWVGRZ_wrap_OnKeyDown);
function BBCHCNQIRI_wrap_Valid(event) {
return BBCHCNQIRI_Valid(event);
}
SPBOUILib.SetInputExit('BBCHCNQIRI',BBCHCNQIRI_wrap_Valid,SPBOUILib.Row.IN_GRID);
function BBCHCNQIRI_wrap_OnFocus(event) {
return BBCHCNQIRI_OnFocus(event);
}
SPBOUILib.SetInputEnter('BBCHCNQIRI',BBCHCNQIRI_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function BBCHCNQIRI_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('BBCHCNQIRI',BBCHCNQIRI_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function HLHLHCXGMT_wrap_Valid(event) {
return HLHLHCXGMT_Valid(event);
}
SPBOUILib.SetInputExit('HLHLHCXGMT',HLHLHCXGMT_wrap_Valid,SPBOUILib.Row.IN_GRID);
function HLHLHCXGMT_wrap_OnFocus(event) {
return HLHLHCXGMT_OnFocus(event);
}
SPBOUILib.SetInputEnter('HLHLHCXGMT',HLHLHCXGMT_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function HLHLHCXGMT_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('HLHLHCXGMT',HLHLHCXGMT_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function BBEEHSSDFM_wrap_Valid(event) {
return BBEEHSSDFM_Valid(event);
}
SPBOUILib.SetInputExit('BBEEHSSDFM',BBEEHSSDFM_wrap_Valid,SPBOUILib.Row.IN_GRID);
function BBEEHSSDFM_wrap_OnFocus(event) {
return BBEEHSSDFM_OnFocus(event);
}
SPBOUILib.SetInputEnter('BBEEHSSDFM',BBEEHSSDFM_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
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
m_oFather.i_last_focused_item='child_aosdt_sub_ind_mit';
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
windowOpenForeground('../doc/aosdt_sub_ind_mit_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
}
function CalledBatchEnd() {
if ( ! (m_bCalculating)) {
DoUpdate(true);
}
}
function LoadChildrenInPage(page,lazy) {
}
GetLayerID.Layers.push({"id":"VGASZRXNOJ_DIV","name":"Descrizione"});
GetLayerID.CheckEditRow=true;
function DeclareWVs() {
var a = arguments;
w_IDMOD=a[0];
w_IDIND=a[1];
w_IDSUBIND=a[2];
w_PROGSUBIND=a[3];
w_DESCRI=a[4];
w_DESCRI_layer=a[5];
m_PrimaryKeys=['IDSUBIND','IDIND','IDMOD'];
}
function i_PrimaryKey() {
return 'sub_ind_mit'+'\\'+CPLib.ToCPStr(w_IDMOD)+'\\'+CPLib.ToCPStr(w_IDIND);
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
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('aosdt_sub_ind_mit',m_cSelectedPage);
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
var candidatesToFocus = ["HLHLHCXGMT"];
SetControlFocus(candidatesToFocus);
}
IsRepeatedChild.child=[];
function GetFullRowMsgError() {
return '75659037';
}
_Obli('IDMOD',0,'LNSBOLUCRM',false,"10024211400")
_Obli('IDIND',0,'ILPNZWVGRZ',false,"1305674908")
_Obli('IDSUBIND',0,'BBCHCNQIRI',false,"10785547902")
_Obli('PROGSUBIND',0,'HLHLHCXGMT',false,"976616780")
_Obli('DESCRI',0,'BBEEHSSDFM',false,"601925191")
_Obli('DESCRI_layer',0,'ATCXZHNKXY',false,"285808099")
