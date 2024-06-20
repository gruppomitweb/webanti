function FillCombosValues() {
}
function SetControlsValue() {
var c;
if(c=Ctrl('SEJWRQHUSP')) selectCombo(c,w_C1CODTAB,'C')
SPBOUILib.SetInputValue('XREVNLNKCY',function(){return WtH(w_C1CODICE,'C',2,0,'')},w_C1CODICE);
SPBOUILib.SetInputValue('RJDJPGMTCC',function(){return WtH(w_C1DESCRI,'C',80,0,'')},w_C1DESCRI);
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
HideUI.lblids["C1CODICE"]=['EHORPFDFFQ'];
HideUI.lblids["C1CODTAB"]=['RGYCBVWYTV'];
HideUI.lblids["C1DESCRI"]=['UKQEHGTCZD'];
function SEJWRQHUSP_Valid(e) {
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('SEJWRQHUSP') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('C1CODTAB','C',w_C1CODTAB,HtW(getComboValue(Ctrl('SEJWRQHUSP')),'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_C1CODTAB(HtW(getComboValue(Ctrl('SEJWRQHUSP')),'C'),null,e);
return l_bSetResult;
}
}
function SEJWRQHUSP_OnFocus(e) {
SetActiveField(Ctrl('SEJWRQHUSP'),true);
}
function SEJWRQHUSP_OnBlur(e) {
SetActiveField(Ctrl('SEJWRQHUSP'),false);
}
function XREVNLNKCY_Valid(e) {
SetActiveField(Ctrl('XREVNLNKCY'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('XREVNLNKCY') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('C1CODICE','C',w_C1CODICE,HtW(Ctrl('XREVNLNKCY').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_C1CODICE(HtW(Ctrl('XREVNLNKCY').value,'C'),null,e);
return l_bSetResult;
}
}
function XREVNLNKCY_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('XREVNLNKCY'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('XREVNLNKCY'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('XREVNLNKCY'),e);
}
function RJDJPGMTCC_Valid(e) {
SetActiveField(Ctrl('RJDJPGMTCC'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('C1DESCRI','C',w_C1DESCRI,HtW(Ctrl('RJDJPGMTCC').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_C1DESCRI(HtW(Ctrl('RJDJPGMTCC').value,'C'),null,e);
return l_bSetResult;
}
}
function RJDJPGMTCC_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('RJDJPGMTCC'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('RJDJPGMTCC'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('RJDJPGMTCC'),e);
}
linkpc_url.u('HUIWOOPCDH',function(){return 'ardt_categris?m_bInnerChild=true'+GetLinkPCKeys('ardt_categris')+'&m_bRowsChild='+EnableChild('ardt_categris')})
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function SEJWRQHUSP_wrap_Valid(event) {
return SEJWRQHUSP_Valid(event);
}
SPBOUILib.SetComboChange('SEJWRQHUSP',SEJWRQHUSP_wrap_Valid);
function SEJWRQHUSP_wrap_OnFocus(event) {
return SEJWRQHUSP_OnFocus(event);
}
SPBOUILib.SetInputEnter('SEJWRQHUSP',SEJWRQHUSP_wrap_OnFocus);
function SEJWRQHUSP_wrap_Blur(event) {
return SEJWRQHUSP_OnBlur(event);
}
SPBOUILib.SetInputExit('SEJWRQHUSP',SEJWRQHUSP_wrap_Blur);
function XREVNLNKCY_wrap_Valid(event) {
return XREVNLNKCY_Valid(event);
}
SPBOUILib.SetInputExit('XREVNLNKCY',XREVNLNKCY_wrap_Valid);
function XREVNLNKCY_wrap_OnFocus(event) {
return XREVNLNKCY_OnFocus(event);
}
SPBOUILib.SetInputEnter('XREVNLNKCY',XREVNLNKCY_wrap_OnFocus);
function XREVNLNKCY_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('XREVNLNKCY',XREVNLNKCY_wrap_OnKeyDown);
function RJDJPGMTCC_wrap_Valid(event) {
return RJDJPGMTCC_Valid(event);
}
SPBOUILib.SetInputExit('RJDJPGMTCC',RJDJPGMTCC_wrap_Valid);
function RJDJPGMTCC_wrap_OnFocus(event) {
return RJDJPGMTCC_OnFocus(event);
}
SPBOUILib.SetInputEnter('RJDJPGMTCC',RJDJPGMTCC_wrap_OnFocus);
function RJDJPGMTCC_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('RJDJPGMTCC',RJDJPGMTCC_wrap_OnKeyDown);
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
FocusFirstComponent.edit={"page_1":["RJDJPGMTCC"]};
FocusFirstComponent.query={"page_1":["SEJWRQHUSP"]};
FocusFirstComponent.otherwise={"page_1":["SEJWRQHUSP"]};
function Help() {
windowOpenForeground('../doc/armt_tbcateg01_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
}
function CalledBatchEnd() {
if ( ! (m_bCalculating)) {
DoUpdate(true);
}
}
function SetModified_ardt_categris() {
SetModified();
}
function LoadChildrenInPage(page,lazy) {
if (Eq(page,'page_1')) {
if (ChildToLoad('HUIWOOPCDH')) {
LoadContext.lc(1,'HUIWOOPCDH');
} else {
LibJavascript.RefreshChildGrid('HUIWOOPCDH');
}
}
}
function DeclareWVs() {
var a = arguments;
w_C1CODTAB=a[0];
w_C1CODICE=a[1];
w_C1DESCRI=a[2];
w_IDBASE=a[3];
m_cWv_ardt_categris=a[4];
if (Gt(a.length,5)) {
m_cErrorInChild='';
}
m_PrimaryKeys=['C1CODICE','C1CODTAB'];
}
function i_PrimaryKey() {
return 'tbcateg01'+'\\'+CPLib.ToCPStr(w_C1CODTAB)+'\\'+CPLib.ToCPStr(w_C1CODICE);
}
GetLinkPCKeys.set_o('ardt_categris',false);
GetLinkPCKeys.o['ardt_categris']['IDCATEG']=function(t){
if (Ne(m_cFunction,'new')) {
return t(w_IDBASE,'C');
}
}
function EnableChild(name) {
var l_bRes = false;
return l_bRes;
}
function CheckZone(me) {
return true;
}
LoadContext.f('HUIWOOPCDH',function(){return FrameRef('ardt_categris')},1,'ardt_categris',1,1)
GetSelectedChildPage.child={'ardt_categris': function(){return FrameRef('ardt_categris')}}
function GetSelectedPage(p_d) {
p_d.setValue('armt_tbcateg01',m_cSelectedPage);
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
_Obli('C1CODTAB',0,'SEJWRQHUSP',false,"10376019890")
_Obli('C1CODICE',0,'XREVNLNKCY',false,"112851763")
_Obli('C1DESCRI',0,'RJDJPGMTCC',false,"285808099")
