function FillCombosValues() {
}
function FillInGridCombosValues(currentRow) {
var postfix = (Gt(currentRow,-1)?'_'+currentRow:'');
}
function SetControlsValue() {
var c;
if (Empty(m_cAltInterface) && (Eq(m_cFunction,'view') || Eq(m_cFunction,'query'))) {
SPBOUILib.SetInputValue('UUNKNVCACF',function(){return WtH(w_IDMOD,'C',10,0,'')},w_IDMOD);
if(c=Ctrl('QOEOGAAKRA')) ChkboxCheckUncheck(c,true,w_show_noapplic)
if(c=Ctrl('QOEOGAAKRA')) ChkboxValueAssign(c,true,false,'L',1,0,'')
SPBOUILib.SetInputValue('ATQBDCKYMD',function(){return WtH(w_IDIND,'C',10,0,'')},w_IDIND);
SPBOUILib.SetInputValue('ATCXZHNKXY',function(){return WtH(w_DESCRI_layer,'M',10,0,'')},w_DESCRI_layer);
} else {
SPBOUILib.SetInputValue('UUNKNVCACF',function(){return WtH(w_IDMOD,'C',10,0,'')},w_IDMOD);
if(c=Ctrl('QOEOGAAKRA')) ChkboxCheckUncheck(c,true,w_show_noapplic)
if(c=Ctrl('QOEOGAAKRA')) ChkboxValueAssign(c,true,false,'L',1,0,'')
SPBOUILib.SetInputValue('ATQBDCKYMD',function(){return WtH(w_IDIND,'C',10,0,'')},w_IDIND);
SPBOUILib.SetInputValue('CFHSVGUQQV',function(){return WtH(w_PROGIND,'C',10,0,'')},w_PROGIND);
SPBOUILib.SetInputValue('NMPXBKDZYD',function(){return WtH(w_DESCRI,'M',10,0,'')},w_DESCRI);
if(c=Ctrl('QILTYWPQKG')) ChkboxCheckUncheck(c,true,w_LOCKMIT)
if(c=Ctrl('QILTYWPQKG')) ChkboxValueAssign(c,true,false,'L',1,0,'')
if(c=Ctrl('TAGTIKFOAX')) ChkboxCheckUncheck(c,true,w_NOAPPLIC)
if(c=Ctrl('TAGTIKFOAX')) ChkboxValueAssign(c,true,false,'L',1,0,'')
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
SetDisplay(Ctrl('UUNKNVCACF'),true || IsHiddenByStateDriver('IDMOD'));
SetDisplay('QOEOGAAKRA_DIV',true);
Z.Tabs.Get("tabs_1_Indicatori").Hide('ROSLSYYTGJ',IsHiddenByStateDriver('Indicatore'));
Z.Tabs.Get("tabs_1_Indicatori").Hide('ZURPIOBYMT',IsHiddenByStateDriver('Subindicatori'));
SetDisplay(Ctrl('ATQBDCKYMD'),true || IsHiddenByStateDriver('IDIND'));
SetDisplay(Ctrl('TVQHCLXOGQ'),w_LOCKMIT &&  ! (Eq(EntityStatus(),'E') || Eq(EntityStatus(),'N')) || IsHiddenByStateDriver('Riporta Descrizione'));
LibJavascript.forEachItem(m_FoundlingHideExpression,i_body_2)
function i_body_2(child){
child();
}
HideUI();
}
HideUI.lblids["DESCRI"]=['RNELIZWMMU'];
HideUI.lblids["LOCKMIT"]=['ADJQSVHTLQ'];
HideUI.lblids["NOAPPLIC"]=['ZOQIOKZNYK'];
HideUI.lblids["PROGIND"]=['SJKZCMGATM'];
function ExpandCollapseBoxesUnderCondition() {
var cond;
}
function UUNKNVCACF_Valid(e) {
SetActiveField(Ctrl('UUNKNVCACF'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('UUNKNVCACF') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('IDMOD','C',w_IDMOD,HtW(Ctrl('UUNKNVCACF').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IDMOD(HtW(Ctrl('UUNKNVCACF').value,'C'),null,e);
return l_bSetResult;
}
}
function UUNKNVCACF_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('UUNKNVCACF'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('UUNKNVCACF'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('UUNKNVCACF'),e);
}
function QOEOGAAKRA_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('show_noapplic','L',w_show_noapplic,ChkboxValueAssign(Ctrl('QOEOGAAKRA'),true,false,'L',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_show_noapplic(ChkboxValueAssign(Ctrl('QOEOGAAKRA'),true,false,'L',1,0,''),null,e);
return l_bSetResult;
}
}
function QOEOGAAKRA_OnFocus(e) {
SetActiveField(Ctrl('QOEOGAAKRA'),true);
}
function QOEOGAAKRA_OnBlur(e) {
SetActiveField(Ctrl('QOEOGAAKRA'),false);
}
function ATQBDCKYMD_Valid(e) {
SetActiveField(Ctrl('ATQBDCKYMD'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('IDIND','C',w_IDIND,HtW(Ctrl('ATQBDCKYMD').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IDIND(HtW(Ctrl('ATQBDCKYMD').value,'C'),null,e);
return l_bSetResult;
}
}
function ATQBDCKYMD_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ATQBDCKYMD'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('ATQBDCKYMD'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ATQBDCKYMD'),e);
}
function CFHSVGUQQV_Valid(e) {
SetActiveField(Ctrl('CFHSVGUQQV'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('PROGIND','C',w_PROGIND,HtW(Ctrl('CFHSVGUQQV').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PROGIND(HtW(Ctrl('CFHSVGUQQV').value,'C'),null,e);
return l_bSetResult;
}
}
function CFHSVGUQQV_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('CFHSVGUQQV'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('CFHSVGUQQV'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('CFHSVGUQQV'),e);
}
function href_UKGCIDRELX(el) {
ToggleLayerBox(arguments.length>0 && arguments[0].isConnected?arguments[0]:'UKGCIDRELX',GetLayerID("Descrizione"),'20',true,'GridTable_Band_DIV','GridTable_Band_HEADER',false)
}
function NMPXBKDZYD_Valid(e) {
SetActiveField(Ctrl('NMPXBKDZYD'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DESCRI','M',w_DESCRI,HtW(Ctrl('NMPXBKDZYD').value,'M'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DESCRI(HtW(Ctrl('NMPXBKDZYD').value,'M'),null,e);
return l_bSetResult;
}
}
function NMPXBKDZYD_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('NMPXBKDZYD'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('NMPXBKDZYD'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('NMPXBKDZYD'),e);
}
function QILTYWPQKG_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('LOCKMIT','L',w_LOCKMIT,ChkboxValueAssign(Ctrl('QILTYWPQKG'),true,false,'L',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_LOCKMIT(ChkboxValueAssign(Ctrl('QILTYWPQKG'),true,false,'L',1,0,''),null,e);
return l_bSetResult;
}
}
function QILTYWPQKG_OnFocus(e) {
SetActiveField(Ctrl('QILTYWPQKG'),true);
}
function QILTYWPQKG_OnBlur(e) {
SetActiveField(Ctrl('QILTYWPQKG'),false);
}
function TAGTIKFOAX_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('NOAPPLIC','L',w_NOAPPLIC,ChkboxValueAssign(Ctrl('TAGTIKFOAX'),true,false,'L',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_NOAPPLIC(ChkboxValueAssign(Ctrl('TAGTIKFOAX'),true,false,'L',1,0,''),null,e);
return l_bSetResult;
}
}
function TAGTIKFOAX_OnFocus(e) {
SetActiveField(Ctrl('TAGTIKFOAX'),true);
}
function TAGTIKFOAX_OnBlur(e) {
SetActiveField(Ctrl('TAGTIKFOAX'),false);
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
function href_TVQHCLXOGQ(el) {
ToggleLayerBox(arguments.length>0 && arguments[0].isConnected?arguments[0]:'TVQHCLXOGQ',GetLayerID("Descrizione"),'00',false,'VGASZRXNOJ_DIV','',true)
}
linkpc_url.u('FBWHLTIFYQ',function(){return 'aosdt_sub_ind_def?m_bInnerChild=true'+GetLinkPCKeys('aosdt_sub_ind_def')+'&m_bRowsChild='+EnableChild('aosdt_sub_ind_def')})
_ResetTracker();
function setEventHandlers() {
var c;
function UKGCIDRELX_wrap_OnClick(event) {
return href_UKGCIDRELX(event.srcElement);
}
SPBOUILib.SetImageClick('UKGCIDRELX',UKGCIDRELX_wrap_OnClick,SPBOUILib.Row.ALWAYS_ENABLED);
function UKGCIDRELX_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetKeyDown('UKGCIDRELX',UKGCIDRELX_wrap_OnKeyDown,SPBOUILib.Row.ALWAYS_ENABLED);
function TVQHCLXOGQ_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?href_TVQHCLXOGQ(event.srcElement):void(0));
}
SPBOUILib.SetImageClick('TVQHCLXOGQ',TVQHCLXOGQ_wrap_OnClick);
function TVQHCLXOGQ_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetKeyDown('TVQHCLXOGQ',TVQHCLXOGQ_wrap_OnKeyDown);
if (Ne(m_cFunction,'view')) {
function UUNKNVCACF_wrap_Valid(event) {
return UUNKNVCACF_Valid(event);
}
SPBOUILib.SetInputExit('UUNKNVCACF',UUNKNVCACF_wrap_Valid);
function UUNKNVCACF_wrap_OnFocus(event) {
return UUNKNVCACF_OnFocus(event);
}
SPBOUILib.SetInputEnter('UUNKNVCACF',UUNKNVCACF_wrap_OnFocus);
function UUNKNVCACF_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('UUNKNVCACF',UUNKNVCACF_wrap_OnKeyDown);
function QOEOGAAKRA_wrap_Valid(event) {
return QOEOGAAKRA_Valid(event);
}
SPBOUILib.SetCheckboxClick('QOEOGAAKRA',QOEOGAAKRA_wrap_Valid);
function QOEOGAAKRA_wrap_OnFocus(event) {
return QOEOGAAKRA_OnFocus(event);
}
SPBOUILib.SetInputEnter('QOEOGAAKRA',QOEOGAAKRA_wrap_OnFocus);
function QOEOGAAKRA_wrap_Blur(event) {
return QOEOGAAKRA_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('QOEOGAAKRA',QOEOGAAKRA_wrap_Blur);
function ATQBDCKYMD_wrap_Valid(event) {
return ATQBDCKYMD_Valid(event);
}
SPBOUILib.SetInputExit('ATQBDCKYMD',ATQBDCKYMD_wrap_Valid);
function ATQBDCKYMD_wrap_OnFocus(event) {
return ATQBDCKYMD_OnFocus(event);
}
SPBOUILib.SetInputEnter('ATQBDCKYMD',ATQBDCKYMD_wrap_OnFocus);
function ATQBDCKYMD_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('ATQBDCKYMD',ATQBDCKYMD_wrap_OnKeyDown);
function CFHSVGUQQV_wrap_Valid(event) {
return CFHSVGUQQV_Valid(event);
}
SPBOUILib.SetInputExit('CFHSVGUQQV',CFHSVGUQQV_wrap_Valid,SPBOUILib.Row.IN_GRID);
function CFHSVGUQQV_wrap_OnFocus(event) {
return CFHSVGUQQV_OnFocus(event);
}
SPBOUILib.SetInputEnter('CFHSVGUQQV',CFHSVGUQQV_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function CFHSVGUQQV_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('CFHSVGUQQV',CFHSVGUQQV_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function NMPXBKDZYD_wrap_Valid(event) {
return NMPXBKDZYD_Valid(event);
}
SPBOUILib.SetInputExit('NMPXBKDZYD',NMPXBKDZYD_wrap_Valid,SPBOUILib.Row.IN_GRID);
function NMPXBKDZYD_wrap_OnFocus(event) {
return NMPXBKDZYD_OnFocus(event);
}
SPBOUILib.SetInputEnter('NMPXBKDZYD',NMPXBKDZYD_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function QILTYWPQKG_wrap_Valid(event) {
return QILTYWPQKG_Valid(event);
}
SPBOUILib.SetCheckboxClick('QILTYWPQKG',QILTYWPQKG_wrap_Valid,SPBOUILib.Row.IN_GRID);
function QILTYWPQKG_wrap_OnFocus(event) {
return QILTYWPQKG_OnFocus(event);
}
SPBOUILib.SetInputEnter('QILTYWPQKG',QILTYWPQKG_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function QILTYWPQKG_wrap_Blur(event) {
return QILTYWPQKG_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('QILTYWPQKG',QILTYWPQKG_wrap_Blur,SPBOUILib.Row.IN_GRID);
function TAGTIKFOAX_wrap_Valid(event) {
return TAGTIKFOAX_Valid(event);
}
SPBOUILib.SetCheckboxClick('TAGTIKFOAX',TAGTIKFOAX_wrap_Valid,SPBOUILib.Row.IN_GRID);
function TAGTIKFOAX_wrap_OnFocus(event) {
return TAGTIKFOAX_OnFocus(event);
}
SPBOUILib.SetInputEnter('TAGTIKFOAX',TAGTIKFOAX_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function TAGTIKFOAX_wrap_Blur(event) {
return TAGTIKFOAX_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('TAGTIKFOAX',TAGTIKFOAX_wrap_Blur,SPBOUILib.Row.IN_GRID);
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
if (Eq(p_cEvent,'After Row Selected')) {
if (Ne(typeof(Calculation_TQCPNMUFSK),'undefined')) {
old_c=m_bCalculating;
m_bCalculating=true;
Calculation_TQCPNMUFSK();
m_bCalculating=old_c;
if ( ! (old_c)) {
DoUpdate(true);
}
}
} else if (Eq(p_cEvent,'Descrizione enter')) {
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
m_oFather.i_last_focused_item='child_aosdt_ind_def';
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
windowOpenForeground('../doc/aosdt_ind_def_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
}
function CalledBatchEnd() {
if ( ! (m_bCalculating)) {
DoUpdate(true);
}
}
function SetModified_aosdt_sub_ind_def() {
SetModified(true);
}
function LoadChildrenInPage(page,lazy) {
if (Eq(page,'page_1')) {
if (ChildToLoad('FBWHLTIFYQ')) {
LoadContext.lc(1,'FBWHLTIFYQ');
} else {
LibJavascript.RefreshChildGrid('FBWHLTIFYQ');
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
w_LOCKMIT=a[4];
w_NOAPPLIC=a[5];
w_show_noapplic=a[6];
w_DESCRI_layer=a[7];
w_open_layer=a[8];
w_write_layer=a[9];
m_cWv_aosdt_sub_ind_def=a[10];
if (Gt(a.length,11)) {
m_cErrorInChild='';
}
if (Gt(a.length,11)) {
o_show_noapplic=w_show_noapplic;
}
m_PrimaryKeys=['IDIND','IDMOD'];
}
function i_PrimaryKey() {
return 'ind_def'+'\\'+CPLib.ToCPStr(w_IDMOD);
}
GetLinkPCKeys.set_o('aosdt_sub_ind_def',true);
GetLinkPCKeys.o['aosdt_sub_ind_def']['IDMOD']=function(t){
if (Ne(m_cFunction,'new')) {
return t(w_IDMOD,'C');
}
}
GetLinkPCKeys.o['aosdt_sub_ind_def']['IDIND']=function(t){
if (Ne(m_cFunction,'new')) {
return t(w_IDIND,'C');
}
}
resizeChildIframe.children['aosdt_sub_ind_def']=true;
function EnableChild(name) {
var l_bRes = m_bRowsChild;
switch (name) {
case 'aosdt_sub_ind_def':
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
LoadContext.f('FBWHLTIFYQ',function(){return FrameRef('aosdt_sub_ind_def')},1,'aosdt_sub_ind_def',1,2)
GetSelectedChildPage.child={'aosdt_sub_ind_def': function(){return FrameRef('aosdt_sub_ind_def')}}
function GetSelectedPage(p_d) {
p_d.setValue('aosdt_ind_def',m_cSelectedPage);
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
var candidatesToFocus = ["CFHSVGUQQV","UKGCIDRELX"];
SetControlFocus(candidatesToFocus);
}
IsRepeatedChild.child=['FBWHLTIFYQ'];
function IsRowHidden(rowObj) {
var w_IDIND = GetRepeatedValue(rowObj,'IDIND');
var w_PROGIND = GetRepeatedValue(rowObj,'PROGIND');
var w_DESCRI = GetRepeatedValue(rowObj,'DESCRI');
var w_LOCKMIT = GetRepeatedValue(rowObj,'LOCKMIT');
var w_NOAPPLIC = GetRepeatedValue(rowObj,'NOAPPLIC');
var w_DESCRI_layer = GetRepeatedValue(rowObj,'DESCRI_layer');
var w_open_layer = GetRepeatedValue(rowObj,'open_layer');
var w_write_layer = GetRepeatedValue(rowObj,'write_layer');
return  ! (w_show_noapplic) && w_NOAPPLIC;
}
function GetFullRowMsgError() {
return '10648001559';
}
_Obli('IDMOD',0,'UUNKNVCACF',false,"10024211400")
_Obli('show_noapplic',4,'QOEOGAAKRA',false,"10273053127")
_Obli('IDIND',0,'ATQBDCKYMD',false,"1305674908")
_Obli('PROGIND',0,'CFHSVGUQQV',false,"11411528788")
_Obli('DESCRI',0,'NMPXBKDZYD',false,"10298248210")
_Obli('LOCKMIT',4,'QILTYWPQKG',false,"2073739548")
_Obli('NOAPPLIC',4,'TAGTIKFOAX',false,"11706423273")
_Obli('DESCRI_layer',0,'ATCXZHNKXY',false,"285808099")
