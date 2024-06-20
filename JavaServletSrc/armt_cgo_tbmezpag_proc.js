function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('FJTSUZOYFI',function(){return WtH(w_MPCODICE,'C',1,0,'')},w_MPCODICE);
SPBOUILib.SetInputValue('UMLYGDEFOD',function(){return WtH(w_MPDESCRI,'C',25,0,'')},w_MPDESCRI);
if(c=Ctrl('RGKYQGJKOC')) selectRadio(c,w_MPFLGVAL,'C')
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
HideUI.lblids["MPCODICE"]=['VLEKQWLLCN'];
HideUI.lblids["MPDESCRI"]=['KELRXMAXBO'];
HideUI.lblids["MPFLGVAL"]=['QLVIFBDQCO'];
function FJTSUZOYFI_Valid(e) {
SetActiveField(Ctrl('FJTSUZOYFI'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('FJTSUZOYFI') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('MPCODICE','C',w_MPCODICE,HtW(Ctrl('FJTSUZOYFI').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_MPCODICE(HtW(Ctrl('FJTSUZOYFI').value,'C'),null,e);
return l_bSetResult;
}
}
function FJTSUZOYFI_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('FJTSUZOYFI'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('FJTSUZOYFI'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('FJTSUZOYFI'),e);
}
function UMLYGDEFOD_Valid(e) {
SetActiveField(Ctrl('UMLYGDEFOD'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('MPDESCRI','C',w_MPDESCRI,HtW(Ctrl('UMLYGDEFOD').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_MPDESCRI(HtW(Ctrl('UMLYGDEFOD').value,'C'),null,e);
return l_bSetResult;
}
}
function UMLYGDEFOD_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('UMLYGDEFOD'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('UMLYGDEFOD'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('UMLYGDEFOD'),e);
}
function RGKYQGJKOC_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('MPFLGVAL','C',w_MPFLGVAL,HtW(getRadioValue(Ctrl('RGKYQGJKOC')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_MPFLGVAL(HtW(getRadioValue(Ctrl('RGKYQGJKOC')),'C'),null,e);
return l_bSetResult;
}
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function FJTSUZOYFI_wrap_Valid(event) {
return FJTSUZOYFI_Valid(event);
}
SPBOUILib.SetInputExit('FJTSUZOYFI',FJTSUZOYFI_wrap_Valid);
function FJTSUZOYFI_wrap_OnFocus(event) {
return FJTSUZOYFI_OnFocus(event);
}
SPBOUILib.SetInputEnter('FJTSUZOYFI',FJTSUZOYFI_wrap_OnFocus);
function FJTSUZOYFI_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('FJTSUZOYFI',FJTSUZOYFI_wrap_OnKeyDown);
function UMLYGDEFOD_wrap_Valid(event) {
return UMLYGDEFOD_Valid(event);
}
SPBOUILib.SetInputExit('UMLYGDEFOD',UMLYGDEFOD_wrap_Valid);
function UMLYGDEFOD_wrap_OnFocus(event) {
return UMLYGDEFOD_OnFocus(event);
}
SPBOUILib.SetInputEnter('UMLYGDEFOD',UMLYGDEFOD_wrap_OnFocus);
function UMLYGDEFOD_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('UMLYGDEFOD',UMLYGDEFOD_wrap_OnKeyDown);
function RGKYQGJKOC_wrap_Valid(event) {
return RGKYQGJKOC_Valid(event);
}
SPBOUILib.SetRadioClick('RGKYQGJKOC',RGKYQGJKOC_wrap_Valid);
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
}
m_nLastError=0;
m_cLastMsgError='';
}
FocusFirstComponent.edit={"page_1":["UMLYGDEFOD"]};
FocusFirstComponent.query={"page_1":["FJTSUZOYFI"]};
FocusFirstComponent.otherwise={"page_1":["FJTSUZOYFI"]};
function Help() {
windowOpenForeground('../doc/armt_cgo_tbmezpag_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_MPCODICE=a[0];
w_MPDESCRI=a[1];
w_MPFLGVAL=a[2];
m_PrimaryKeys=['MPCODICE'];
}
function i_PrimaryKey() {
return 'cgo_tbmezpag'+'\\'+CPLib.ToCPStr(w_MPCODICE);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('armt_cgo_tbmezpag',m_cSelectedPage);
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
_Obli('MPCODICE',0,'FJTSUZOYFI',false,"112851763")
_Obli('MPDESCRI',0,'UMLYGDEFOD',false,"285808099")
_Obli('MPFLGVAL',0,'RGKYQGJKOC',false,"660277739")
