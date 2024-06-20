function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('PJHHWQGBUG',function(){return WtH(w_WCCODICE,'N',3,0,'999')},w_WCCODICE);
SPBOUILib.SetInputValue('SCCDXTUURS',function(){return WtH(w_WCNOMCAS,'C',60,0,'')},w_WCNOMCAS);
SPBOUILib.SetInputValue('XGRDYFUCPE',function(){return WtH(w_WCDESCRI,'M',10,0,'')},w_WCDESCRI);
SPBOUILib.SetInputValue('YNYVYIMRFE',function(){return WtH(w_WCBEHAVIOR,'M',10,0,'')},w_WCBEHAVIOR);
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
HideUI.lblids["WCBEHAVIOR"]=['ZWVRZCQWEK'];
HideUI.lblids["WCCODICE"]=['FZZCREAXJM'];
HideUI.lblids["WCDESCRI"]=['CHWTJHXRFH'];
HideUI.lblids["WCNOMCAS"]=['SKUVMDZATP'];
function PJHHWQGBUG_Valid(e) {
SetActiveField(Ctrl('PJHHWQGBUG'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('PJHHWQGBUG') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('WCCODICE','N',w_WCCODICE,HtW(Ctrl('PJHHWQGBUG').value,'N'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_WCCODICE(HtW(Ctrl('PJHHWQGBUG').value,'N'),null,e);
return l_bSetResult;
}
}
function PJHHWQGBUG_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('PJHHWQGBUG'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('PJHHWQGBUG',w_WCCODICE,'N',3,0,'999');
SetActiveField(Ctrl('PJHHWQGBUG'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('PJHHWQGBUG'),e);
}
function PJHHWQGBUG_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("999"));
}
function SCCDXTUURS_Valid(e) {
SetActiveField(Ctrl('SCCDXTUURS'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('WCNOMCAS','C',w_WCNOMCAS,HtW(Ctrl('SCCDXTUURS').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_WCNOMCAS(HtW(Ctrl('SCCDXTUURS').value,'C'),null,e);
return l_bSetResult;
}
}
function SCCDXTUURS_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('SCCDXTUURS'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('SCCDXTUURS'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('SCCDXTUURS'),e);
}
function XGRDYFUCPE_Valid(e) {
SetActiveField(Ctrl('XGRDYFUCPE'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('WCDESCRI','M',w_WCDESCRI,HtW(Ctrl('XGRDYFUCPE').value,'M'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_WCDESCRI(HtW(Ctrl('XGRDYFUCPE').value,'M'),null,e);
return l_bSetResult;
}
}
function XGRDYFUCPE_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('XGRDYFUCPE'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('XGRDYFUCPE'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('XGRDYFUCPE'),e);
}
function YNYVYIMRFE_Valid(e) {
SetActiveField(Ctrl('YNYVYIMRFE'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('WCBEHAVIOR','M',w_WCBEHAVIOR,HtW(Ctrl('YNYVYIMRFE').value,'M'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_WCBEHAVIOR(HtW(Ctrl('YNYVYIMRFE').value,'M'),null,e);
return l_bSetResult;
}
}
function YNYVYIMRFE_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('YNYVYIMRFE'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('YNYVYIMRFE'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('YNYVYIMRFE'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function PJHHWQGBUG_wrap_Valid(event) {
return PJHHWQGBUG_Valid(event);
}
SPBOUILib.SetInputExit('PJHHWQGBUG',PJHHWQGBUG_wrap_Valid);
function PJHHWQGBUG_wrap_OnFocus(event) {
return PJHHWQGBUG_OnFocus(event);
}
SPBOUILib.SetInputEnter('PJHHWQGBUG',PJHHWQGBUG_wrap_OnFocus);
function PJHHWQGBUG_wrap_OnKeyPress(event) {
return PJHHWQGBUG_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('PJHHWQGBUG',PJHHWQGBUG_wrap_OnKeyPress);
function PJHHWQGBUG_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('PJHHWQGBUG',PJHHWQGBUG_wrap_OnKeyDown);
function SCCDXTUURS_wrap_Valid(event) {
return SCCDXTUURS_Valid(event);
}
SPBOUILib.SetInputExit('SCCDXTUURS',SCCDXTUURS_wrap_Valid);
function SCCDXTUURS_wrap_OnFocus(event) {
return SCCDXTUURS_OnFocus(event);
}
SPBOUILib.SetInputEnter('SCCDXTUURS',SCCDXTUURS_wrap_OnFocus);
function SCCDXTUURS_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('SCCDXTUURS',SCCDXTUURS_wrap_OnKeyDown);
function XGRDYFUCPE_wrap_Valid(event) {
return XGRDYFUCPE_Valid(event);
}
SPBOUILib.SetInputExit('XGRDYFUCPE',XGRDYFUCPE_wrap_Valid);
function XGRDYFUCPE_wrap_OnFocus(event) {
return XGRDYFUCPE_OnFocus(event);
}
SPBOUILib.SetInputEnter('XGRDYFUCPE',XGRDYFUCPE_wrap_OnFocus);
function YNYVYIMRFE_wrap_Valid(event) {
return YNYVYIMRFE_Valid(event);
}
SPBOUILib.SetInputExit('YNYVYIMRFE',YNYVYIMRFE_wrap_Valid);
function YNYVYIMRFE_wrap_OnFocus(event) {
return YNYVYIMRFE_OnFocus(event);
}
SPBOUILib.SetInputEnter('YNYVYIMRFE',YNYVYIMRFE_wrap_OnFocus);
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
FocusFirstComponent.edit={"page_1":["SCCDXTUURS"]};
FocusFirstComponent.query={"page_1":["PJHHWQGBUG"]};
FocusFirstComponent.otherwise={"page_1":["PJHHWQGBUG"]};
function Help() {
windowOpenForeground('../doc/armt_wu_cases_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_WCCODICE=a[0];
w_WCNOMCAS=a[1];
w_WCDESCRI=a[2];
w_WCBEHAVIOR=a[3];
m_PrimaryKeys=['WCCODICE'];
}
function i_PrimaryKey() {
return 'wu_cases'+'\\'+CPLib.ToCPStr(w_WCCODICE);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('armt_wu_cases',m_cSelectedPage);
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
_Obli('WCCODICE',1,'PJHHWQGBUG',false,"112851763")
_Obli('WCNOMCAS',0,'SCCDXTUURS',false,"11789475667")
_Obli('WCDESCRI',0,'XGRDYFUCPE',false,"2054167717")
_Obli('WCBEHAVIOR',0,'YNYVYIMRFE',false,"10887553216")
