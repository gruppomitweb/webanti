function SetControlsValue() {
var c;
if (Empty(m_cAltInterface) && (Eq(m_cFunction,'view') || Eq(m_cFunction,'query'))) {
if(c=Ctrl('NBMHJRJGQX')) c.value = WtH(w_IDMOD,'C',10,0,'')
if(c=Ctrl('KHBDKLNADV')) c.value = WtH(w_ROWRIL,'N',4,0,'9999')
} else {
if(c=Ctrl('NBMHJRJGQX')) c.value = WtH(w_IDMOD,'C',10,0,'')
if(c=Ctrl('KHBDKLNADV')) c.value = WtH(w_ROWRIL,'N',4,0,'9999')
if(c=Ctrl('PWBPXBGJRH')) c.value = WtH(w_IDIND,'C',10,0,'')
if(c=Ctrl('OSQTGJONIV')) c.value = WtH(w_IDSUBIND,'C',10,0,'')
if(c=Ctrl('GIWDXVTDUW')) c.value = WtH(w_NOTA,'M',10,0,'')
if(c=Ctrl('GOHQRSLEQN')) c.value = WtH(w_PROGIND,'C',10,0,'')
if(c=Ctrl('AOKURBYNFX')) c.value = WtH(w_DESCRI_IND,'M',10,0,'')
if(c=Ctrl('NXPQVKMXKS')) c.value = WtH(w_PROGSUBIND,'C',10,0,'')
if(c=Ctrl('PSHCVHVAPS')) c.value = WtH(w_DESCRI_SUBIND,'M',10,0,'')
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
SetDisplay(Ctrl('NBMHJRJGQX'),true || IsHiddenByStateDriver('IDMOD'));
SetDisplay(Ctrl('KHBDKLNADV'),true || IsHiddenByStateDriver('ROWRIL'));
LibJavascript.forEachItem(m_FoundlingHideExpression,i_body_2)
function i_body_2(child){
child();
}
HideUI();
}
HideUI.lblids["IDIND"]=['UALKXPJWBM'];
HideUI.lblids["IDSUBIND"]=['OKVVWUCLCV'];
HideUI.lblids["NOTA"]=['RMCEGUPVLI'];
function ExpandCollapseBoxesUnderCondition() {
var cond;
}
function NBMHJRJGQX_Valid(e) {
resetSuggest('NBMHJRJGQX','NBMHJRJGQX');
SetActiveField(Ctrl('NBMHJRJGQX'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('NBMHJRJGQX') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('IDMOD','C',w_IDMOD,HtW(Ctrl('NBMHJRJGQX').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IDMOD(HtW(Ctrl('NBMHJRJGQX').value,'C'),null,e);
return l_bSetResult;
}
}
function NBMHJRJGQX_OnFocus(e) {
NBMHJRJGQX_OnKeyUp.oldValue=HtW(Ctrl('NBMHJRJGQX').value,'C');
if (Ne(m_cFunction,'query') &&  ! (CheckZone('NBMHJRJGQX'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('NBMHJRJGQX'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('NBMHJRJGQX'),e);
}
function NBMHJRJGQX_OnKeyUp(e) {
var evt = (window.event?window.event:e);
var newValue = HtW(Ctrl('NBMHJRJGQX').value,'C');
if (Eq(newValue,NBMHJRJGQX_OnKeyUp.oldValue)) {
return;
}
NBMHJRJGQX_OnKeyUp.oldValue=newValue;
if ( ! (GetDisabled(Ctrl('NBMHJRJGQX')) || IsMobile())) {
if (Gt(newValue.length,2)) {
callSuggest(Sugg_NBMHJRJGQX,3);
} else {
resetSuggest('NBMHJRJGQX','NBMHJRJGQX');
}
}
}
function NBMHJRJGQX_ValidSuggest(e) {
e=(window.event?window.event:e);
if (e) {
return select_suggest('NBMHJRJGQX','NBMHJRJGQX',-1,e);
}
}
function NBMHJRJGQX_Sugg_OnKeyDown(e) {
var evt = (window.event?window.event:e);
OnKeyDown_suggest('NBMHJRJGQX','NBMHJRJGQX',GetKeyCode(evt));
}
function KHBDKLNADV_Valid(e) {
SetActiveField(Ctrl('KHBDKLNADV'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('KHBDKLNADV') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('ROWRIL','N',w_ROWRIL,HtW(Ctrl('KHBDKLNADV').value,'N'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ROWRIL(HtW(Ctrl('KHBDKLNADV').value,'N'),null,e);
return l_bSetResult;
}
}
function KHBDKLNADV_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('KHBDKLNADV'))) {
DisplayErrorMessage();
}
Ctrl('KHBDKLNADV').value=WtH(w_ROWRIL,'N',4,0,'9999');
SetActiveField(Ctrl('KHBDKLNADV'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('KHBDKLNADV'),e);
}
function KHBDKLNADV_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("9999"));
}
function PWBPXBGJRH_Valid(e) {
resetSuggest('PWBPXBGJRH','PWBPXBGJRH');
SetActiveField(Ctrl('PWBPXBGJRH'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('IDIND','C',w_IDIND,HtW(Ctrl('PWBPXBGJRH').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IDIND(HtW(Ctrl('PWBPXBGJRH').value,'C'),null,e);
return l_bSetResult;
}
}
function PWBPXBGJRH_OnFocus(e) {
PWBPXBGJRH_OnKeyUp.oldValue=HtW(Ctrl('PWBPXBGJRH').value,'C');
if (Ne(m_cFunction,'query') &&  ! (CheckZone('PWBPXBGJRH'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('PWBPXBGJRH'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('PWBPXBGJRH'),e);
}
function PWBPXBGJRH_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('PWBPXBGJRH')),'linkview_PWBPXBGJRH','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function PWBPXBGJRH_OnKeyUp(e) {
var evt = (window.event?window.event:e);
var newValue = HtW(Ctrl('PWBPXBGJRH').value,'C');
if (Eq(newValue,PWBPXBGJRH_OnKeyUp.oldValue)) {
return;
}
PWBPXBGJRH_OnKeyUp.oldValue=newValue;
if ( ! (GetDisabled(Ctrl('PWBPXBGJRH')) || IsMobile())) {
if (Gt(newValue.length,2)) {
callSuggest(Sugg_PWBPXBGJRH,3);
} else {
resetSuggest('PWBPXBGJRH','PWBPXBGJRH');
}
}
}
function PWBPXBGJRH_ValidSuggest(e) {
e=(window.event?window.event:e);
if (e) {
return select_suggest('PWBPXBGJRH','PWBPXBGJRH',-1,e);
}
}
function PWBPXBGJRH_Sugg_OnKeyDown(e) {
var evt = (window.event?window.event:e);
OnKeyDown_suggest('PWBPXBGJRH','PWBPXBGJRH',GetKeyCode(evt));
}
function OSQTGJONIV_Valid(e) {
resetSuggest('OSQTGJONIV','OSQTGJONIV');
SetActiveField(Ctrl('OSQTGJONIV'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('IDSUBIND','C',w_IDSUBIND,HtW(Ctrl('OSQTGJONIV').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IDSUBIND(HtW(Ctrl('OSQTGJONIV').value,'C'),null,e);
return l_bSetResult;
}
}
function OSQTGJONIV_OnFocus(e) {
OSQTGJONIV_OnKeyUp.oldValue=HtW(Ctrl('OSQTGJONIV').value,'C');
if (Ne(m_cFunction,'query') &&  ! (CheckZone('OSQTGJONIV'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('OSQTGJONIV'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('OSQTGJONIV'),e);
}
function OSQTGJONIV_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('OSQTGJONIV')),'linkview_OSQTGJONIV','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function OSQTGJONIV_OnKeyUp(e) {
var evt = (window.event?window.event:e);
var newValue = HtW(Ctrl('OSQTGJONIV').value,'C');
if (Eq(newValue,OSQTGJONIV_OnKeyUp.oldValue)) {
return;
}
OSQTGJONIV_OnKeyUp.oldValue=newValue;
if ( ! (GetDisabled(Ctrl('OSQTGJONIV')) || IsMobile())) {
if (Gt(newValue.length,2)) {
callSuggest(Sugg_OSQTGJONIV,3);
} else {
resetSuggest('OSQTGJONIV','OSQTGJONIV');
}
}
}
function OSQTGJONIV_ValidSuggest(e) {
e=(window.event?window.event:e);
if (e) {
return select_suggest('OSQTGJONIV','OSQTGJONIV',-1,e);
}
}
function OSQTGJONIV_Sugg_OnKeyDown(e) {
var evt = (window.event?window.event:e);
OnKeyDown_suggest('OSQTGJONIV','OSQTGJONIV',GetKeyCode(evt));
}
function GIWDXVTDUW_Valid(e) {
SetActiveField(Ctrl('GIWDXVTDUW'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('NOTA','M',w_NOTA,HtW(Ctrl('GIWDXVTDUW').value,'M'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_NOTA(HtW(Ctrl('GIWDXVTDUW').value,'M'),null,e);
return l_bSetResult;
}
}
function GIWDXVTDUW_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('GIWDXVTDUW'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('GIWDXVTDUW'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('GIWDXVTDUW'),e);
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
if(c=Ctrl('NBMHJRJGQX')) c.onblur=NBMHJRJGQX_Valid;
if(c=Ctrl('NBMHJRJGQX')) c.onfocus=NBMHJRJGQX_OnFocus;
if (Eq(m_cFunction,'edit') || Eq(m_cFunction,'new')) {
if(c=Ctrl('NBMHJRJGQX')) c.onkeyup=NBMHJRJGQX_OnKeyUp;
}
if(c=Ctrl('KHBDKLNADV')) c.onblur=KHBDKLNADV_Valid;
if(c=Ctrl('KHBDKLNADV')) c.onfocus=KHBDKLNADV_OnFocus;
if(c=Ctrl('KHBDKLNADV')) c.onkeypress=KHBDKLNADV_CheckNumWithPict;
if (Ne(m_cFunction,'query') && detail) {
if(c=Ctrl('PWBPXBGJRH')) c.onblur=PWBPXBGJRH_Valid;
if(c=Ctrl('PWBPXBGJRH')) c.onfocus=PWBPXBGJRH_OnFocus;
if (Eq(m_cFunction,'edit') || Eq(m_cFunction,'new')) {
if(c=Ctrl('PWBPXBGJRH')) c.onkeyup=PWBPXBGJRH_OnKeyUp;
}
if(c=Ctrl('PWBPXBGJRH')) c.onkeydown=ManageKeys;
}
if (Ne(m_cFunction,'query') && detail) {
if(c=Ctrl('OSQTGJONIV')) c.onblur=OSQTGJONIV_Valid;
if(c=Ctrl('OSQTGJONIV')) c.onfocus=OSQTGJONIV_OnFocus;
if (Eq(m_cFunction,'edit') || Eq(m_cFunction,'new')) {
if(c=Ctrl('OSQTGJONIV')) c.onkeyup=OSQTGJONIV_OnKeyUp;
}
if(c=Ctrl('OSQTGJONIV')) c.onkeydown=ManageKeys;
}
if (Ne(m_cFunction,'query') && detail) {
if(c=Ctrl('GIWDXVTDUW')) c.onblur=GIWDXVTDUW_Valid;
if(c=Ctrl('GIWDXVTDUW')) c.onfocus=GIWDXVTDUW_OnFocus;
}
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
m_oFather.i_last_focused_item='child_aosdt_ano_ril';
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
windowOpenForeground('../doc/aosdt_ano_ril_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_IDMOD=a[0];
w_ROWRIL=a[1];
w_IDIND=a[2];
w_IDSUBIND=a[3];
w_NOTA=a[4];
w_PROGIND=a[5];
w_DESCRI_IND=a[6];
w_PROGSUBIND=a[7];
w_DESCRI_SUBIND=a[8];
m_PrimaryKeys=['IDSUBIND','IDIND','ROWRIL','IDMOD'];
}
function i_PrimaryKey() {
return 'ano_ril'+'\\'+CPLib.ToCPStr(w_IDMOD)+'\\'+CPLib.ToCPStr(w_ROWRIL);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('aosdt_ano_ril',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
function FocusFirstDetailComponent() {
var candidatesToFocus = ["PWBPXBGJRH"];
SetControlFocus(candidatesToFocus);
}
IsRepeatedChild.child=[];
function GetFullRowMsgError() {
return '11354184884';
}
_Obli('IDMOD',0,'NBMHJRJGQX',false,"10024211400")
_Obli('ROWRIL',1,'KHBDKLNADV',false,"10651989569")
_Obli('IDIND',0,'PWBPXBGJRH',false,"1305674908")
_Obli('IDSUBIND',0,'OSQTGJONIV',false,"10783450750")
_Obli('NOTA',0,'GIWDXVTDUW',false,"10027512133")
