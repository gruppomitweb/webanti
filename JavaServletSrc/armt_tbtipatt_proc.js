function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('REKDAESDBY',function(){return WtH(w_CODICE,'C',10,0,'')},w_CODICE);
SPBOUILib.SetInputValue('EEFLSIIJFF',function(){return WtH(w_DESCRI,'C',250,0,'')},w_DESCRI);
SPBOUILib.SetInputValue('WPNPIZPKPB',function(){return WtH(w_RISCHIO,'N',3,0,'')},w_RISCHIO);
if(c=Ctrl('WNFWMYSQZX')) ChkboxCheckUncheck(c,1,w_FLGALTO)
if(c=Ctrl('WNFWMYSQZX')) ChkboxValueAssign(c,1,0,'N',1,0,'')
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
HideUI.lblids["CODICE"]=['YMRBHLKOYY'];
HideUI.lblids["DESCRI"]=['BODTKQAFMT'];
HideUI.lblids["RISCHIO"]=['TRTQZEAWPK'];
function REKDAESDBY_Valid(e) {
SetActiveField(Ctrl('REKDAESDBY'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('REKDAESDBY') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('CODICE','C',w_CODICE,HtW(Ctrl('REKDAESDBY').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODICE(HtW(Ctrl('REKDAESDBY').value,'C'),null,e);
return l_bSetResult;
}
}
function REKDAESDBY_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('REKDAESDBY'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('REKDAESDBY'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('REKDAESDBY'),e);
}
function EEFLSIIJFF_Valid(e) {
SetActiveField(Ctrl('EEFLSIIJFF'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DESCRI','C',w_DESCRI,HtW(Ctrl('EEFLSIIJFF').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DESCRI(HtW(Ctrl('EEFLSIIJFF').value,'C'),null,e);
return l_bSetResult;
}
}
function EEFLSIIJFF_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('EEFLSIIJFF'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('EEFLSIIJFF'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('EEFLSIIJFF'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function REKDAESDBY_wrap_Valid(event) {
return REKDAESDBY_Valid(event);
}
SPBOUILib.SetInputExit('REKDAESDBY',REKDAESDBY_wrap_Valid);
function REKDAESDBY_wrap_OnFocus(event) {
return REKDAESDBY_OnFocus(event);
}
SPBOUILib.SetInputEnter('REKDAESDBY',REKDAESDBY_wrap_OnFocus);
function REKDAESDBY_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('REKDAESDBY',REKDAESDBY_wrap_OnKeyDown);
function EEFLSIIJFF_wrap_Valid(event) {
return EEFLSIIJFF_Valid(event);
}
SPBOUILib.SetInputExit('EEFLSIIJFF',EEFLSIIJFF_wrap_Valid);
function EEFLSIIJFF_wrap_OnFocus(event) {
return EEFLSIIJFF_OnFocus(event);
}
SPBOUILib.SetInputEnter('EEFLSIIJFF',EEFLSIIJFF_wrap_OnFocus);
function EEFLSIIJFF_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('EEFLSIIJFF',EEFLSIIJFF_wrap_OnKeyDown);
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
FocusFirstComponent.edit={"page_1":["EEFLSIIJFF"]};
FocusFirstComponent.query={"page_1":["REKDAESDBY"]};
FocusFirstComponent.otherwise={"page_1":["REKDAESDBY"]};
function Help() {
windowOpenForeground('../doc/armt_tbtipatt_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_CODICE=a[0];
w_DESCRI=a[1];
w_RISCHIO=a[2];
w_FLGALTO=a[3];
m_PrimaryKeys=['CODICE'];
}
function i_PrimaryKey() {
return 'tbtipatt'+'\\'+CPLib.ToCPStr(w_CODICE);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('armt_tbtipatt',m_cSelectedPage);
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
_Obli('CODICE',0,'REKDAESDBY',false,"112851763")
_Obli('DESCRI',0,'EEFLSIIJFF',false,"285808099")
