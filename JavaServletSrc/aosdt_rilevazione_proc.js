function FillCombosValues() {
}
function FillInGridCombosValues(currentRow) {
var postfix = (Gt(currentRow,-1)?'_'+currentRow:'');
}
function SetControlsValue() {
var c;
if (Empty(m_cAltInterface) && (Eq(m_cFunction,'view') || Eq(m_cFunction,'query'))) {
SPBOUILib.SetInputValue('SZHUMIRICR',function(){return WtH(w_IDMOD,'C',10,0,'')},w_IDMOD);
SPBOUILib.SetInputValue('DYVTZPSSRP',function(){return WtH(w_DESCRI,'C',200,0,'')},w_DESCRI);
} else {
SPBOUILib.SetInputValue('SZHUMIRICR',function(){return WtH(w_IDMOD,'C',10,0,'')},w_IDMOD);
SPBOUILib.SetInputValue('DYVTZPSSRP',function(){return WtH(w_DESCRI,'C',200,0,'')},w_DESCRI);
SPBOUILib.SetInputValue('TRQBYTHAVX',function(){return WtH(w_CONNES,'C',16,0,'')},w_CONNES);
SPBOUILib.SetInputValue('SOAYACQNFI',function(){return WtH(w_DTRIL,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DTRIL);
SPBOUILib.SetInputValue('AQPVNJGWDF',function(){return WtH(w_PROVENIENZA,'C',100,0,'')},w_PROVENIENZA);
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
Z.Tabs.Get("tabs_1_Rilevazione").Hide('VWBPGQDWQK',IsHiddenByStateDriver('Dati Base Rilevazione'));
Z.Tabs.Get("tabs_1_Rilevazione").Hide('GEDEJOLMRB',IsHiddenByStateDriver('Indicatori della Rilevazione'));
LibJavascript.forEachItem(m_FoundlingHideExpression,i_body_2)
function i_body_2(child){
child();
}
HideUI();
}
HideUI.lblids["CONNES"]=['RKOALHIEPO'];
HideUI.lblids["DTRIL"]=['SNDESTNZNX'];
HideUI.lblids["IDMOD"]=['BBHSFPEDRQ'];
HideUI.lblids["PROVENIENZA"]=['PPPOYREQRK'];
function ExpandCollapseBoxesUnderCondition() {
var cond;
}
function SZHUMIRICR_Valid(e) {
SuggesterLib.resetSuggest('SZHUMIRICR','SZHUMIRICR');
SetActiveField(Ctrl('SZHUMIRICR'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('SZHUMIRICR') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('IDMOD','C',w_IDMOD,HtW(Ctrl('SZHUMIRICR').value,'C'),m_bQueryOnLatestKeyOnly);
}
}
}
function SZHUMIRICR_OnFocus(e) {
SZHUMIRICR_OnKeyUp.oldValue=HtW(Ctrl('SZHUMIRICR').value,'C');
if (Ne(m_cFunction,'query') &&  ! (CheckZone('SZHUMIRICR'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('SZHUMIRICR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('SZHUMIRICR'),e);
}
function SZHUMIRICR_OnKeyUp(e) {
var evt = (window.event?window.event:e);
var newValue = HtW(Ctrl('SZHUMIRICR').value,'C');
if (Eq(newValue,SZHUMIRICR_OnKeyUp.oldValue)) {
return;
}
SZHUMIRICR_OnKeyUp.oldValue=newValue;
if ( ! (GetDisabled(Ctrl('SZHUMIRICR')) || IsMobile())) {
if (Gt(newValue.length,2)) {
SuggesterLib.callSuggest(Sugg_SZHUMIRICR,2);
} else {
SuggesterLib.resetSuggest('SZHUMIRICR','SZHUMIRICR');
}
}
}
function SZHUMIRICR_ValidSuggest(e) {
e=(window.event?window.event:e);
if (e) {
return SuggesterLib.select_suggest('SZHUMIRICR','SZHUMIRICR',-1,e);
}
}
function TRQBYTHAVX_Valid(e) {
SetActiveField(Ctrl('TRQBYTHAVX'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CONNES','C',w_CONNES,HtW(Ctrl('TRQBYTHAVX').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CONNES(HtW(Ctrl('TRQBYTHAVX').value,'C'),null,e);
return l_bSetResult;
}
}
function TRQBYTHAVX_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('TRQBYTHAVX'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('TRQBYTHAVX'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('TRQBYTHAVX'),e);
}
function SOAYACQNFI_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('SOAYACQNFI'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('SOAYACQNFI').value=ApplyPictureToDate(Ctrl('SOAYACQNFI').value,TranslatePicture(datePattern),'SOAYACQNFI');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('SOAYACQNFI'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('SOAYACQNFI');
}
}
}
SetActiveField(Ctrl('SOAYACQNFI'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DTRIL','D',w_DTRIL,HtW(Ctrl('SOAYACQNFI').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DTRIL(HtW(Ctrl('SOAYACQNFI').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function SOAYACQNFI_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('SOAYACQNFI'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('SOAYACQNFI',w_DTRIL,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('SOAYACQNFI');
SetActiveField(Ctrl('SOAYACQNFI'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('SOAYACQNFI'),e);
}
function SOAYACQNFI_ZOOM_Click() {
LaunchCalendar(Ctrl('SOAYACQNFI'));
}
function AQPVNJGWDF_Valid(e) {
SetActiveField(Ctrl('AQPVNJGWDF'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('PROVENIENZA','C',w_PROVENIENZA,HtW(Ctrl('AQPVNJGWDF').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PROVENIENZA(HtW(Ctrl('AQPVNJGWDF').value,'C'),null,e);
return l_bSetResult;
}
}
function AQPVNJGWDF_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('AQPVNJGWDF'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('AQPVNJGWDF'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('AQPVNJGWDF'),e);
}
linkpc_url.u('IXXAERLMUY',function(){return 'aosdt_anom_ril?m_bInnerChild=true'+GetLinkPCKeys('aosdt_anom_ril')+'&m_bRowsChild='+EnableChild('aosdt_anom_ril')})
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function SZHUMIRICR_wrap_Valid(event) {
return SZHUMIRICR_Valid(event);
}
SPBOUILib.SetInputExit('SZHUMIRICR',SZHUMIRICR_wrap_Valid);
function SZHUMIRICR_wrap_OnFocus(event) {
return SZHUMIRICR_OnFocus(event);
}
SPBOUILib.SetInputEnter('SZHUMIRICR',SZHUMIRICR_wrap_OnFocus);
function SZHUMIRICR_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('SZHUMIRICR',SZHUMIRICR_wrap_OnKeyDown);
SPBOUILib.SetInputKeyUp('SZHUMIRICR',function(event) {
  return (Eq(m_cFunction,'edit') || Eq(m_cFunction,'new')?SZHUMIRICR_OnKeyUp(event):void(0));
});
function TRQBYTHAVX_wrap_Valid(event) {
return TRQBYTHAVX_Valid(event);
}
SPBOUILib.SetInputExit('TRQBYTHAVX',TRQBYTHAVX_wrap_Valid,SPBOUILib.Row.IN_GRID);
function TRQBYTHAVX_wrap_OnFocus(event) {
return TRQBYTHAVX_OnFocus(event);
}
SPBOUILib.SetInputEnter('TRQBYTHAVX',TRQBYTHAVX_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function TRQBYTHAVX_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('TRQBYTHAVX',TRQBYTHAVX_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function SOAYACQNFI_wrap_Valid(event) {
return SOAYACQNFI_Valid(event);
}
SPBOUILib.SetInputExit('SOAYACQNFI',SOAYACQNFI_wrap_Valid,SPBOUILib.Row.IN_GRID);
function SOAYACQNFI_wrap_OnFocus(event) {
return SOAYACQNFI_OnFocus(event);
}
SPBOUILib.SetInputEnter('SOAYACQNFI',SOAYACQNFI_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function SOAYACQNFI_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('SOAYACQNFI',SOAYACQNFI_wrap_OnKeyPress,SPBOUILib.Row.IN_GRID);
function SOAYACQNFI_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('SOAYACQNFI',SOAYACQNFI_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function SOAYACQNFI_ZOOM_setHandlers() {
function SOAYACQNFI_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?SOAYACQNFI_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('SOAYACQNFI_ZOOM',SOAYACQNFI_ZOOM_wrap_OnClick,SPBOUILib.Row.IN_GRID);
}
SPBOUILib.SetPicker('SOAYACQNFI',SOAYACQNFI_ZOOM_setHandlers);
function AQPVNJGWDF_wrap_Valid(event) {
return AQPVNJGWDF_Valid(event);
}
SPBOUILib.SetInputExit('AQPVNJGWDF',AQPVNJGWDF_wrap_Valid,SPBOUILib.Row.IN_GRID);
function AQPVNJGWDF_wrap_OnFocus(event) {
return AQPVNJGWDF_OnFocus(event);
}
SPBOUILib.SetInputEnter('AQPVNJGWDF',AQPVNJGWDF_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function AQPVNJGWDF_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('AQPVNJGWDF',AQPVNJGWDF_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
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
m_bStopChangeRow=true;
} else if (Ne('undefined',typeof(m_nLastError))) {
m_bStopChangeRow=Eq(m_nLastError,-2);
}
m_nLastError=0;
m_cLastMsgError='';
}
FocusFirstComponent.edit={};
FocusFirstComponent.query={"page_1":["SZHUMIRICR"]};
FocusFirstComponent.otherwise={};
function Help() {
windowOpenForeground('../doc/aosdt_rilevazione_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
}
function CalledBatchEnd() {
if ( ! (m_bCalculating)) {
DoUpdate(true);
}
}
function SetModified_aosdt_anom_ril() {
SetModified(true);
}
function LoadChildrenInPage(page,lazy) {
if (Eq(page,'page_1')) {
if (ChildToLoad('IXXAERLMUY')) {
LoadContext.lc(1,'IXXAERLMUY');
} else {
LibJavascript.RefreshChildGrid('IXXAERLMUY');
}
}
}
GetLayerID.Layers.push({"id":"VWBPGQDWQK","name":"Dati Base Rilevazione"});
GetLayerID.Layers.push({"id":"GEDEJOLMRB","name":"Indicatori della Rilevazione"});
GetLayerID.CheckEditRow=true;
function DeclareWVs() {
var a = arguments;
w_IDMOD=a[0];
w_CONNES=a[1];
w_DTRIL=a[2];
w_PROVENIENZA=a[3];
w_CPROWNUM=a[4];
w_DESCRI=a[5];
m_cWv_aosdt_anom_ril=a[6];
if (Gt(a.length,7)) {
m_cErrorInChild='';
}
if (Gt(a.length,7)) {
o_IDMOD=w_IDMOD;
o_CPROWNUM=w_CPROWNUM;
}
m_PrimaryKeys=['CPROWNUM','IDMOD'];
}
function i_PrimaryKey() {
return 'rilevazione'+'\\'+CPLib.ToCPStr(w_IDMOD);
}
GetLinkPCKeys.set_o('aosdt_anom_ril',true);
GetLinkPCKeys.o['aosdt_anom_ril']['IDMOD']=function(t){
if (Ne(m_cFunction,'new')) {
return t(w_IDMOD,'C');
}
}
GetLinkPCKeys.o['aosdt_anom_ril']['ROWRIL']=function(t){
if (Ne(m_cFunction,'new')) {
return t(w_CPROWNUM,'N');
}
}
resizeChildIframe.children['aosdt_anom_ril']=true;
function EnableChild(name) {
var l_bRes = false;
return l_bRes;
}
function CheckZone(me) {
return true;
}
LoadContext.f('IXXAERLMUY',function(){return FrameRef('aosdt_anom_ril')},1,'aosdt_anom_ril',1,2)
GetSelectedChildPage.child={'aosdt_anom_ril': function(){return FrameRef('aosdt_anom_ril')}}
function GetSelectedPage(p_d) {
p_d.setValue('aosdt_rilevazione',m_cSelectedPage);
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
var candidatesToFocus = ["TRQBYTHAVX"];
SetControlFocus(candidatesToFocus);
}
IsRepeatedChild.child=['IXXAERLMUY'];
function GetFullRowMsgError() {
return '1454413650';
}
_Obli('CONNES',0,'TRQBYTHAVX',false,"1748986534")
_Obli('DTRIL',2,'SOAYACQNFI',false,"10173567207")
_Obli('PROVENIENZA',0,'AQPVNJGWDF',false,"856336882")
