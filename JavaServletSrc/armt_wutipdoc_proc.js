function FillCombosValues() {
FillCombo('JTAXYVCMKR','JTAXYVCMKR');
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('CSRZTJZJBA',function(){return WtH(w_WUTDCODICE,'C',2,0,'')},w_WUTDCODICE);
SPBOUILib.SetInputValue('CQWAJFLZHH',function(){return WtH(w_WUTDDESCRI,'C',60,0,'')},w_WUTDDESCRI);
if(c=Ctrl('JTAXYVCMKR')) selectCombo(c,w_WUTDTIPDOC,'C')
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
HideUI.lblids["WUTDCODICE"]=['TXAUSAHYWA'];
HideUI.lblids["WUTDDESCRI"]=['HFRKJUCCKD'];
HideUI.lblids["WUTDTIPDOC"]=['EDLHXNSZHA'];
function CSRZTJZJBA_Valid(e) {
SetActiveField(Ctrl('CSRZTJZJBA'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('CSRZTJZJBA') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('WUTDCODICE','C',w_WUTDCODICE,HtW(Ctrl('CSRZTJZJBA').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_WUTDCODICE(HtW(Ctrl('CSRZTJZJBA').value,'C'),null,e);
return l_bSetResult;
}
}
function CSRZTJZJBA_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('CSRZTJZJBA'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('CSRZTJZJBA'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('CSRZTJZJBA'),e);
}
function CQWAJFLZHH_Valid(e) {
SetActiveField(Ctrl('CQWAJFLZHH'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('WUTDDESCRI','C',w_WUTDDESCRI,HtW(Ctrl('CQWAJFLZHH').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_WUTDDESCRI(HtW(Ctrl('CQWAJFLZHH').value,'C'),null,e);
return l_bSetResult;
}
}
function CQWAJFLZHH_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('CQWAJFLZHH'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('CQWAJFLZHH'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('CQWAJFLZHH'),e);
}
function JTAXYVCMKR_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('WUTDTIPDOC','C',w_WUTDTIPDOC,HtW(getComboValue(Ctrl('JTAXYVCMKR')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_WUTDTIPDOC(HtW(getComboValue(Ctrl('JTAXYVCMKR')),'C'),null,e);
return l_bSetResult;
}
}
function JTAXYVCMKR_OnFocus(e) {
SetActiveField(Ctrl('JTAXYVCMKR'),true);
}
function JTAXYVCMKR_OnBlur(e) {
SetActiveField(Ctrl('JTAXYVCMKR'),false);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function CSRZTJZJBA_wrap_Valid(event) {
return CSRZTJZJBA_Valid(event);
}
SPBOUILib.SetInputExit('CSRZTJZJBA',CSRZTJZJBA_wrap_Valid);
function CSRZTJZJBA_wrap_OnFocus(event) {
return CSRZTJZJBA_OnFocus(event);
}
SPBOUILib.SetInputEnter('CSRZTJZJBA',CSRZTJZJBA_wrap_OnFocus);
function CSRZTJZJBA_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('CSRZTJZJBA',CSRZTJZJBA_wrap_OnKeyDown);
function CQWAJFLZHH_wrap_Valid(event) {
return CQWAJFLZHH_Valid(event);
}
SPBOUILib.SetInputExit('CQWAJFLZHH',CQWAJFLZHH_wrap_Valid);
function CQWAJFLZHH_wrap_OnFocus(event) {
return CQWAJFLZHH_OnFocus(event);
}
SPBOUILib.SetInputEnter('CQWAJFLZHH',CQWAJFLZHH_wrap_OnFocus);
function CQWAJFLZHH_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('CQWAJFLZHH',CQWAJFLZHH_wrap_OnKeyDown);
function JTAXYVCMKR_wrap_Valid(event) {
return JTAXYVCMKR_Valid(event);
}
SPBOUILib.SetComboChange('JTAXYVCMKR',JTAXYVCMKR_wrap_Valid);
function JTAXYVCMKR_wrap_OnFocus(event) {
return JTAXYVCMKR_OnFocus(event);
}
SPBOUILib.SetInputEnter('JTAXYVCMKR',JTAXYVCMKR_wrap_OnFocus);
function JTAXYVCMKR_wrap_Blur(event) {
return JTAXYVCMKR_OnBlur(event);
}
SPBOUILib.SetInputExit('JTAXYVCMKR',JTAXYVCMKR_wrap_Blur);
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
FocusFirstComponent.edit={"page_1":["CQWAJFLZHH"]};
FocusFirstComponent.query={"page_1":["CSRZTJZJBA"]};
FocusFirstComponent.otherwise={"page_1":["CSRZTJZJBA"]};
function Help() {
windowOpenForeground('../doc/armt_wutipdoc_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_WUTDCODICE=a[0];
w_WUTDDESCRI=a[1];
w_WUTDTIPDOC=a[2];
m_PrimaryKeys=['WUTDCODICE'];
}
function i_PrimaryKey() {
return 'wutipdoc'+'\\'+CPLib.ToCPStr(w_WUTDCODICE);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('armt_wutipdoc',m_cSelectedPage);
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
_Obli('WUTDCODICE',0,'CSRZTJZJBA',false,"986887038")
_Obli('WUTDDESCRI',0,'CQWAJFLZHH',false,"285808099")
_Obli('WUTDTIPDOC',0,'JTAXYVCMKR',false,"10623724530")
