function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('BGJKUPJQFN',function(){return WtH(w_DACODICE,'C',2,0,'')},w_DACODICE);
SPBOUILib.SetInputValue('SGUSJBDARF',function(){return WtH(w_DARAGSOC,'C',80,0,'')},w_DARAGSOC);
SPBOUILib.SetInputValue('NOTVYDLHTH',function(){return WtH(w_DAEMAIL,'C',50,0,'')},w_DAEMAIL);
if(c=Ctrl('TOEBWZTIES')) selectCombo(c,w_DATIPALT,'C')
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
HideUI.lblids["DACODICE"]=['LSCGRXFWUF'];
HideUI.lblids["DAEMAIL"]=['FAUPYSFJLS'];
HideUI.lblids["DARAGSOC"]=['PYTFVSYVCD'];
HideUI.lblids["DATIPALT"]=['REDEBWFGQU'];
function BGJKUPJQFN_Valid(e) {
SetActiveField(Ctrl('BGJKUPJQFN'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('BGJKUPJQFN') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('DACODICE','C',w_DACODICE,HtW(Ctrl('BGJKUPJQFN').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DACODICE(HtW(Ctrl('BGJKUPJQFN').value,'C'),null,e);
return l_bSetResult;
}
}
function BGJKUPJQFN_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('BGJKUPJQFN'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('BGJKUPJQFN'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('BGJKUPJQFN'),e);
}
function SGUSJBDARF_Valid(e) {
SetActiveField(Ctrl('SGUSJBDARF'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DARAGSOC','C',w_DARAGSOC,HtW(Ctrl('SGUSJBDARF').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DARAGSOC(HtW(Ctrl('SGUSJBDARF').value,'C'),null,e);
return l_bSetResult;
}
}
function SGUSJBDARF_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('SGUSJBDARF'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('SGUSJBDARF'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('SGUSJBDARF'),e);
}
function NOTVYDLHTH_Valid(e) {
SetActiveField(Ctrl('NOTVYDLHTH'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DAEMAIL','C',w_DAEMAIL,HtW(Ctrl('NOTVYDLHTH').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DAEMAIL(HtW(Ctrl('NOTVYDLHTH').value,'C'),null,e);
return l_bSetResult;
}
}
function NOTVYDLHTH_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('NOTVYDLHTH'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('NOTVYDLHTH'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('NOTVYDLHTH'),e);
}
function TOEBWZTIES_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('DATIPALT','C',w_DATIPALT,HtW(getComboValue(Ctrl('TOEBWZTIES')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATIPALT(HtW(getComboValue(Ctrl('TOEBWZTIES')),'C'),null,e);
return l_bSetResult;
}
}
function TOEBWZTIES_OnFocus(e) {
SetActiveField(Ctrl('TOEBWZTIES'),true);
}
function TOEBWZTIES_OnBlur(e) {
SetActiveField(Ctrl('TOEBWZTIES'),false);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function BGJKUPJQFN_wrap_Valid(event) {
return BGJKUPJQFN_Valid(event);
}
SPBOUILib.SetInputExit('BGJKUPJQFN',BGJKUPJQFN_wrap_Valid);
function BGJKUPJQFN_wrap_OnFocus(event) {
return BGJKUPJQFN_OnFocus(event);
}
SPBOUILib.SetInputEnter('BGJKUPJQFN',BGJKUPJQFN_wrap_OnFocus);
function BGJKUPJQFN_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('BGJKUPJQFN',BGJKUPJQFN_wrap_OnKeyDown);
function SGUSJBDARF_wrap_Valid(event) {
return SGUSJBDARF_Valid(event);
}
SPBOUILib.SetInputExit('SGUSJBDARF',SGUSJBDARF_wrap_Valid);
function SGUSJBDARF_wrap_OnFocus(event) {
return SGUSJBDARF_OnFocus(event);
}
SPBOUILib.SetInputEnter('SGUSJBDARF',SGUSJBDARF_wrap_OnFocus);
function SGUSJBDARF_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('SGUSJBDARF',SGUSJBDARF_wrap_OnKeyDown);
function NOTVYDLHTH_wrap_Valid(event) {
return NOTVYDLHTH_Valid(event);
}
SPBOUILib.SetInputExit('NOTVYDLHTH',NOTVYDLHTH_wrap_Valid);
function NOTVYDLHTH_wrap_OnFocus(event) {
return NOTVYDLHTH_OnFocus(event);
}
SPBOUILib.SetInputEnter('NOTVYDLHTH',NOTVYDLHTH_wrap_OnFocus);
function NOTVYDLHTH_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('NOTVYDLHTH',NOTVYDLHTH_wrap_OnKeyDown);
function TOEBWZTIES_wrap_Valid(event) {
return TOEBWZTIES_Valid(event);
}
SPBOUILib.SetComboChange('TOEBWZTIES',TOEBWZTIES_wrap_Valid);
function TOEBWZTIES_wrap_OnFocus(event) {
return TOEBWZTIES_OnFocus(event);
}
SPBOUILib.SetInputEnter('TOEBWZTIES',TOEBWZTIES_wrap_OnFocus);
function TOEBWZTIES_wrap_Blur(event) {
return TOEBWZTIES_OnBlur(event);
}
SPBOUILib.SetInputExit('TOEBWZTIES',TOEBWZTIES_wrap_Blur);
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
FocusFirstComponent.edit={"page_1":["SGUSJBDARF"]};
FocusFirstComponent.query={"page_1":["BGJKUPJQFN"]};
FocusFirstComponent.otherwise={"page_1":["BGJKUPJQFN"]};
function Help() {
windowOpenForeground('../doc/armt_cgo_dest_alert_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_DACODICE=a[0];
w_DARAGSOC=a[1];
w_DAEMAIL=a[2];
w_DATIPALT=a[3];
m_PrimaryKeys=['DACODICE'];
}
function i_PrimaryKey() {
return 'cgo_dest_alert'+'\\'+CPLib.ToCPStr(w_DACODICE);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('armt_cgo_dest_alert',m_cSelectedPage);
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
_Obli('DACODICE',0,'BGJKUPJQFN',false,"1992386102")
_Obli('DARAGSOC',0,'SGUSJBDARF',false,"176491428")
_Obli('DAEMAIL',0,'NOTVYDLHTH',true,"7534101")
_Obli('DATIPALT',0,'TOEBWZTIES',false,"11070109034")
