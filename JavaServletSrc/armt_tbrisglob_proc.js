function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('BOFICLPSRO',function(){return WtH(w_CODICE,'C',3,0,'')},w_CODICE);
SPBOUILib.SetInputValue('KYHMFWLTSY',function(){return WtH(w_DESCRI,'C',60,0,'')},w_DESCRI);
SPBOUILib.SetInputValue('JUHBENCLLM',function(){return WtH(w_GIORNI,'N',5,0,'')},w_GIORNI);
if (m_bExtended) {
SetExtensions();
}
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay(Ctrl('BQIFOLPPXO'),Eq(w_MIT,0));
LibJavascript.forEachItem(m_FoundlingHideExpression,i_body_2)
function i_body_2(child){
child();
}
HideUI();
}
HideUI.lblids["CODICE"]=['JWFBEIXVST'];
HideUI.lblids["DESCRI"]=['ZGWOJEUKLO'];
HideUI.lblids["GIORNI"]=['BRYHFNPWKP'];
function BOFICLPSRO_Valid(e) {
if (Ne(Ctrl('BOFICLPSRO').value,'')) {
Ctrl('BOFICLPSRO').value=zeroFill(Ctrl('BOFICLPSRO').value,3);
}
SetActiveField(Ctrl('BOFICLPSRO'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('BOFICLPSRO') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('CODICE','C',w_CODICE,HtW(Ctrl('BOFICLPSRO').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODICE(HtW(Ctrl('BOFICLPSRO').value,'C'),null,e);
return l_bSetResult;
}
}
function BOFICLPSRO_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('BOFICLPSRO'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('BOFICLPSRO'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('BOFICLPSRO'),e);
}
function KYHMFWLTSY_Valid(e) {
SetActiveField(Ctrl('KYHMFWLTSY'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DESCRI','C',w_DESCRI,HtW(Ctrl('KYHMFWLTSY').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DESCRI(HtW(Ctrl('KYHMFWLTSY').value,'C'),null,e);
return l_bSetResult;
}
}
function KYHMFWLTSY_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('KYHMFWLTSY'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('KYHMFWLTSY'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('KYHMFWLTSY'),e);
}
function JUHBENCLLM_Valid(e) {
SetActiveField(Ctrl('JUHBENCLLM'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('GIORNI','N',w_GIORNI,HtW(Ctrl('JUHBENCLLM').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_GIORNI(HtW(Ctrl('JUHBENCLLM').value,'N'),null,e);
return l_bSetResult;
}
}
function JUHBENCLLM_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('JUHBENCLLM'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('JUHBENCLLM'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('JUHBENCLLM'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function BOFICLPSRO_wrap_Valid(event) {
return BOFICLPSRO_Valid(event);
}
SPBOUILib.SetInputExit('BOFICLPSRO',BOFICLPSRO_wrap_Valid);
function BOFICLPSRO_wrap_OnFocus(event) {
return BOFICLPSRO_OnFocus(event);
}
SPBOUILib.SetInputEnter('BOFICLPSRO',BOFICLPSRO_wrap_OnFocus);
function BOFICLPSRO_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('BOFICLPSRO',BOFICLPSRO_wrap_OnKeyDown);
function KYHMFWLTSY_wrap_Valid(event) {
return KYHMFWLTSY_Valid(event);
}
SPBOUILib.SetInputExit('KYHMFWLTSY',KYHMFWLTSY_wrap_Valid);
function KYHMFWLTSY_wrap_OnFocus(event) {
return KYHMFWLTSY_OnFocus(event);
}
SPBOUILib.SetInputEnter('KYHMFWLTSY',KYHMFWLTSY_wrap_OnFocus);
function KYHMFWLTSY_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('KYHMFWLTSY',KYHMFWLTSY_wrap_OnKeyDown);
function JUHBENCLLM_wrap_Valid(event) {
return JUHBENCLLM_Valid(event);
}
SPBOUILib.SetInputExit('JUHBENCLLM',JUHBENCLLM_wrap_Valid);
function JUHBENCLLM_wrap_OnFocus(event) {
return JUHBENCLLM_OnFocus(event);
}
SPBOUILib.SetInputEnter('JUHBENCLLM',JUHBENCLLM_wrap_OnFocus);
function JUHBENCLLM_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('JUHBENCLLM',JUHBENCLLM_wrap_OnKeyPress);
function JUHBENCLLM_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('JUHBENCLLM',JUHBENCLLM_wrap_OnKeyDown);
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
FocusFirstComponent.edit={"page_1":["KYHMFWLTSY"]};
FocusFirstComponent.query={"page_1":["BOFICLPSRO","KYHMFWLTSY"]};
FocusFirstComponent.otherwise={"page_1":["BOFICLPSRO","KYHMFWLTSY"]};
function Help() {
windowOpenForeground('../doc/armt_tbrisglob_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_IDBASE=a[2];
w_GIORNI=a[3];
w_MIT=a[4];
m_PrimaryKeys=['CODICE'];
}
function i_PrimaryKey() {
return 'tbrisglob'+'\\'+CPLib.ToCPStr(w_CODICE);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('armt_tbrisglob',m_cSelectedPage);
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
_Obli('CODICE',0,'BOFICLPSRO',false,"112851763")
_Obli('DESCRI',0,'KYHMFWLTSY',false,"285808099")
_Obli('GIORNI',1,'JUHBENCLLM',false,"117806551")
