function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('SNXLTYYRQT',function(){return WtH(w_CODICE,'C',5,0,'')},w_CODICE);
SPBOUILib.SetInputValue('SLPDHEMOXG',function(){return WtH(w_DESCRI,'C',200,0,'')},w_DESCRI);
SPBOUILib.SetInputValue('GBWGKMLTSQ',function(){return WtH(w_RISCHIO,'N',3,0,'999')},w_RISCHIO);
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
HideUI.lblids["CODICE"]=['BIGFPZAOKD'];
HideUI.lblids["DESCRI"]=['UNQYOVIAYR'];
HideUI.lblids["RISCHIO"]=['MZUNIMCJQC'];
function SNXLTYYRQT_Valid(e) {
SetActiveField(Ctrl('SNXLTYYRQT'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('SNXLTYYRQT') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('CODICE','C',w_CODICE,HtW(Ctrl('SNXLTYYRQT').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODICE(HtW(Ctrl('SNXLTYYRQT').value,'C'),null,e);
return l_bSetResult;
}
}
function SNXLTYYRQT_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('SNXLTYYRQT'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('SNXLTYYRQT'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('SNXLTYYRQT'),e);
}
function SLPDHEMOXG_Valid(e) {
SetActiveField(Ctrl('SLPDHEMOXG'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DESCRI','C',w_DESCRI,HtW(Ctrl('SLPDHEMOXG').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DESCRI(HtW(Ctrl('SLPDHEMOXG').value,'C'),null,e);
return l_bSetResult;
}
}
function SLPDHEMOXG_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('SLPDHEMOXG'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('SLPDHEMOXG'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('SLPDHEMOXG'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function SNXLTYYRQT_wrap_Valid(event) {
return SNXLTYYRQT_Valid(event);
}
SPBOUILib.SetInputExit('SNXLTYYRQT',SNXLTYYRQT_wrap_Valid);
function SNXLTYYRQT_wrap_OnFocus(event) {
return SNXLTYYRQT_OnFocus(event);
}
SPBOUILib.SetInputEnter('SNXLTYYRQT',SNXLTYYRQT_wrap_OnFocus);
function SNXLTYYRQT_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('SNXLTYYRQT',SNXLTYYRQT_wrap_OnKeyDown);
function SLPDHEMOXG_wrap_Valid(event) {
return SLPDHEMOXG_Valid(event);
}
SPBOUILib.SetInputExit('SLPDHEMOXG',SLPDHEMOXG_wrap_Valid);
function SLPDHEMOXG_wrap_OnFocus(event) {
return SLPDHEMOXG_OnFocus(event);
}
SPBOUILib.SetInputEnter('SLPDHEMOXG',SLPDHEMOXG_wrap_OnFocus);
function SLPDHEMOXG_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('SLPDHEMOXG',SLPDHEMOXG_wrap_OnKeyDown);
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
FocusFirstComponent.edit={"page_1":["SLPDHEMOXG"]};
FocusFirstComponent.query={"page_1":["SNXLTYYRQT"]};
FocusFirstComponent.otherwise={"page_1":["SNXLTYYRQT"]};
function Help() {
windowOpenForeground('../doc/ammt_tbimporto_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
m_PrimaryKeys=['CODICE'];
}
function i_PrimaryKey() {
return 'tbimporto'+'\\'+CPLib.ToCPStr(w_CODICE);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('ammt_tbimporto',m_cSelectedPage);
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
_Obli('CODICE',0,'SNXLTYYRQT',false,"112851763")
_Obli('DESCRI',0,'SLPDHEMOXG',false,"285808099")
