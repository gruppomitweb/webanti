function FillCombosValues() {
}
function FillInGridCombosValues(currentRow) {
var postfix = (Gt(currentRow,-1)?'_'+currentRow:'');
}
function SetControlsValue() {
var c;
if (Empty(m_cAltInterface) && (Eq(m_cFunction,'view') || Eq(m_cFunction,'query'))) {
SPBOUILib.SetInputValue('ODWFKNKZRQ',function(){return WtH(w_IDBNOMFILE,'C',80,0,'')},w_IDBNOMFILE);
} else {
SPBOUILib.SetInputValue('ODWFKNKZRQ',function(){return WtH(w_IDBNOMFILE,'C',80,0,'')},w_IDBNOMFILE);
SPBOUILib.SetInputValue('LYWFRZTWYR',function(){return WtH(w_IBDDESFILE,'C',70,0,'')},w_IBDDESFILE);
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
LibJavascript.forEachItem(m_FoundlingHideExpression,i_body_2)
function i_body_2(child){
child();
}
HideUI();
}
HideUI.lblids["IBDDESFILE"]=['BZKKLAXIZS'];
HideUI.lblids["IDBNOMFILE"]=['MFTIBJLOVM'];
function href_TRYATOHLLN(el) {
ToggleLayerBox(arguments.length>0 && arguments[0].isConnected?arguments[0]:'TRYATOHLLN',GetLayerID("Download"),'11',false,'','',false)
}
function onmouseover_TRYATOHLLN(e,ctrl) {
if (IsMobile()) {
ToggleLayerBox(arguments.length>0 && arguments[0].isConnected?arguments[0]:'TRYATOHLLN',GetLayerID("Download"),'11',false,'','',false)
} else {
ShowLayerBoxWithDelay((Eq(ctrl,null)?'TRYATOHLLN':ctrl),GetLayerID('Download'),'11',false,'','',false,'mouseover',300);
}
}
function onmouseout_TRYATOHLLN() {
HideLayerBoxWithDelay(GetLayerID('Download'),1500);
}
function ODWFKNKZRQ_Valid(e) {
SetActiveField(Ctrl('ODWFKNKZRQ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('IDBNOMFILE','C',w_IDBNOMFILE,HtW(Ctrl('ODWFKNKZRQ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IDBNOMFILE(HtW(Ctrl('ODWFKNKZRQ').value,'C'),null,e);
return l_bSetResult;
}
}
function ODWFKNKZRQ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ODWFKNKZRQ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('ODWFKNKZRQ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ODWFKNKZRQ'),e);
}
function LYWFRZTWYR_Valid(e) {
SetActiveField(Ctrl('LYWFRZTWYR'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('IBDDESFILE','C',w_IBDDESFILE,HtW(Ctrl('LYWFRZTWYR').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IBDDESFILE(HtW(Ctrl('LYWFRZTWYR').value,'C'),null,e);
return l_bSetResult;
}
}
function LYWFRZTWYR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('LYWFRZTWYR'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('LYWFRZTWYR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('LYWFRZTWYR'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
function TRYATOHLLN_wrap_OnClick(event) {
return href_TRYATOHLLN(event.srcElement);
}
SPBOUILib.SetImageClick('TRYATOHLLN',TRYATOHLLN_wrap_OnClick);
function TRYATOHLLN_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetKeyDown('TRYATOHLLN',TRYATOHLLN_wrap_OnKeyDown);
if (Ne(m_cFunction,'view')) {
SPBOUILib.SetImageEventShowLayer('TRYATOHLLN',onmouseover_TRYATOHLLN);
SPBOUILib.SetImageEventHideLayer('TRYATOHLLN',onmouseout_TRYATOHLLN);
function ODWFKNKZRQ_wrap_Valid(event) {
return ODWFKNKZRQ_Valid(event);
}
SPBOUILib.SetInputExit('ODWFKNKZRQ',ODWFKNKZRQ_wrap_Valid);
function ODWFKNKZRQ_wrap_OnFocus(event) {
return ODWFKNKZRQ_OnFocus(event);
}
SPBOUILib.SetInputEnter('ODWFKNKZRQ',ODWFKNKZRQ_wrap_OnFocus);
function ODWFKNKZRQ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('ODWFKNKZRQ',ODWFKNKZRQ_wrap_OnKeyDown);
function LYWFRZTWYR_wrap_Valid(event) {
return LYWFRZTWYR_Valid(event);
}
SPBOUILib.SetInputExit('LYWFRZTWYR',LYWFRZTWYR_wrap_Valid,SPBOUILib.Row.IN_GRID);
function LYWFRZTWYR_wrap_OnFocus(event) {
return LYWFRZTWYR_OnFocus(event);
}
SPBOUILib.SetInputEnter('LYWFRZTWYR',LYWFRZTWYR_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function LYWFRZTWYR_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('LYWFRZTWYR',LYWFRZTWYR_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
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
if (Ne(typeof(w_pDownload),'undefined')) {
w_pDownload.raiseEvent('ardt_cgo_infbacheca_doc_'+Strtran(p_cEvent,' ','_'));
}
}
function SetLastFocusedOnParent() {
if (IsWndAccessible(window['m_oFather'])) {
m_oFather.i_last_focused_item='child_ardt_cgo_infbacheca_doc';
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
function closeContextMenu_CUXQOCWWKI() {
}
function Help() {
windowOpenForeground('../doc/ardt_cgo_infbacheca_doc_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
}
function CalledBatchEnd() {
if ( ! (m_bCalculating)) {
DoUpdate(true);
}
}
function LoadChildrenInPage(page,lazy) {
}
GetLayerID.Layers.push({"id":"CUXQOCWWKI_DIV","name":"Download"});
GetLayerID.CheckEditRow=true;
function DeclareWVs() {
var a = arguments;
w_IBDCODICE=a[0];
w_IDBNOMFILE=a[1];
w_IBDDESFILE=a[2];
w_CPROWNUM=a[3];
w_gAzienda=a[4];
m_PrimaryKeys=['CPROWNUM','IBDCODICE'];
}
function i_PrimaryKey() {
return 'cgo_infbacheca_doc'+'\\'+CPLib.ToCPStr(w_IBDCODICE);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('ardt_cgo_infbacheca_doc',m_cSelectedPage);
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
var candidatesToFocus = ["LYWFRZTWYR"];
SetControlFocus(candidatesToFocus);
}
IsRepeatedChild.child=[];
function GetFullRowMsgError() {
return 'MSG_FULLROW_NOT_SAT';
}
_Obli('IDBNOMFILE',0,'ODWFKNKZRQ',false,"763806883")
_Obli('IBDDESFILE',0,'LYWFRZTWYR',false,"10740223517")
