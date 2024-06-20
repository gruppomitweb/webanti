function FillCombosValues() {
}
function FillInGridCombosValues(currentRow) {
var postfix = (Gt(currentRow,-1)?'_'+currentRow:'');
}
function SetControlsValue() {
var c;
if (Empty(m_cAltInterface) && (Eq(m_cFunction,'view') || Eq(m_cFunction,'query'))) {
} else {
SPBOUILib.SetInputValue('BIBFBTHHAY',function(){return WtH(w_PPDESCRI,'C',50,0,'')},w_PPDESCRI);
if(c=Ctrl('CBRNDMRBGB')) selectCombo(c,w_PPTIPPAR,'C')
SPBOUILib.SetInputValue('JGOKTHOLYL',function(){return WtH(w_PPVALPAR,'C',20,0,'')},w_PPVALPAR);
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
HideUI.lblids["PPDESCRI"]=['YCACPAJEFT'];
HideUI.lblids["PPTIPPAR"]=['TNIQJFHIMN'];
HideUI.lblids["PPVALPAR"]=['CBIWSEGHFE'];
function BIBFBTHHAY_Valid(e) {
SetActiveField(Ctrl('BIBFBTHHAY'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('PPDESCRI','C',w_PPDESCRI,HtW(Ctrl('BIBFBTHHAY').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PPDESCRI(HtW(Ctrl('BIBFBTHHAY').value,'C'),null,e);
return l_bSetResult;
}
}
function BIBFBTHHAY_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('BIBFBTHHAY'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('BIBFBTHHAY'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('BIBFBTHHAY'),e);
}
function CBRNDMRBGB_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('PPTIPPAR','C',w_PPTIPPAR,HtW(getComboValue(Ctrl('CBRNDMRBGB')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PPTIPPAR(HtW(getComboValue(Ctrl('CBRNDMRBGB')),'C'),null,e);
return l_bSetResult;
}
}
function CBRNDMRBGB_OnFocus(e) {
SetActiveField(Ctrl('CBRNDMRBGB'),true);
}
function CBRNDMRBGB_OnBlur(e) {
SetActiveField(Ctrl('CBRNDMRBGB'),false);
}
function JGOKTHOLYL_Valid(e) {
SetActiveField(Ctrl('JGOKTHOLYL'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('PPVALPAR','C',w_PPVALPAR,HtW(Ctrl('JGOKTHOLYL').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PPVALPAR(HtW(Ctrl('JGOKTHOLYL').value,'C'),null,e);
return l_bSetResult;
}
}
function JGOKTHOLYL_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('JGOKTHOLYL'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('JGOKTHOLYL'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('JGOKTHOLYL'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function BIBFBTHHAY_wrap_Valid(event) {
return BIBFBTHHAY_Valid(event);
}
SPBOUILib.SetInputExit('BIBFBTHHAY',BIBFBTHHAY_wrap_Valid,SPBOUILib.Row.IN_GRID);
function BIBFBTHHAY_wrap_OnFocus(event) {
return BIBFBTHHAY_OnFocus(event);
}
SPBOUILib.SetInputEnter('BIBFBTHHAY',BIBFBTHHAY_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function BIBFBTHHAY_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('BIBFBTHHAY',BIBFBTHHAY_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function CBRNDMRBGB_wrap_Valid(event) {
return CBRNDMRBGB_Valid(event);
}
SPBOUILib.SetComboChange('CBRNDMRBGB',CBRNDMRBGB_wrap_Valid,SPBOUILib.Row.IN_GRID);
function CBRNDMRBGB_wrap_OnFocus(event) {
return CBRNDMRBGB_OnFocus(event);
}
SPBOUILib.SetInputEnter('CBRNDMRBGB',CBRNDMRBGB_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function CBRNDMRBGB_wrap_Blur(event) {
return CBRNDMRBGB_OnBlur(event);
}
SPBOUILib.SetInputExit('CBRNDMRBGB',CBRNDMRBGB_wrap_Blur,SPBOUILib.Row.IN_GRID);
function JGOKTHOLYL_wrap_Valid(event) {
return JGOKTHOLYL_Valid(event);
}
SPBOUILib.SetInputExit('JGOKTHOLYL',JGOKTHOLYL_wrap_Valid,SPBOUILib.Row.IN_GRID);
function JGOKTHOLYL_wrap_OnFocus(event) {
return JGOKTHOLYL_OnFocus(event);
}
SPBOUILib.SetInputEnter('JGOKTHOLYL',JGOKTHOLYL_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function JGOKTHOLYL_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('JGOKTHOLYL',JGOKTHOLYL_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
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
m_oFather.i_last_focused_item='child_dt_tbprcbck_param';
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
windowOpenForeground('../doc/dt_tbprcbck_param_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_PPCODICE=a[0];
w_PPDESCRI=a[1];
w_PPTIPPAR=a[2];
w_PPVALPAR=a[3];
w_CPROWNUM=a[4];
m_PrimaryKeys=['CPROWNUM','PPCODICE'];
}
function i_PrimaryKey() {
return 'tbprcbck_param'+'\\'+CPLib.ToCPStr(w_PPCODICE);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('dt_tbprcbck_param',m_cSelectedPage);
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
var candidatesToFocus = ["BIBFBTHHAY"];
SetControlFocus(candidatesToFocus);
}
IsRepeatedChild.child=[];
function GetFullRowMsgError() {
return 'MSG_FULLROW_NOT_SAT';
}
_Obli('PPTIPPAR',0,'CBRNDMRBGB',false,"2140278436")
_Obli('PPDESCRI',0,'BIBFBTHHAY',false,"285808099")
_Obli('PPVALPAR',0,'JGOKTHOLYL',false,"113861222")
