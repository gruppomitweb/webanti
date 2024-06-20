function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('JWFUQHQPUG',function(){return WtH(w_ServerName,'C',10,0,'')},w_ServerName);
SPBOUILib.SetInputValue('YGIZDTNCWH',function(){return WtH(w_ServerDesc,'C',30,0,'')},w_ServerDesc);
SPBOUILib.SetInputValue('JZYFFSWJOU',function(){return WtH(w_ODBCDataSource,'C',500,0,'')},w_ODBCDataSource);
var tmp_JHGFVWNVYJ = ToHTag(AsControlValue((Empty(w_DatabaseType_Var) || Ne(w_DatabaseType_Var,'SPINSTANCE')?FormatMsg('ADMIN_DATA_SOURCE'):FormatMsg('MSG_INSTANCE'))));
if (Ne(e_JHGFVWNVYJ,tmp_JHGFVWNVYJ)) {
SPBOUILib.SetLabelValue('JHGFVWNVYJ','innerHTML',tmp_JHGFVWNVYJ);
e_JHGFVWNVYJ=tmp_JHGFVWNVYJ;
}
SPBOUILib.SetInputValue('CTNCYJEQGE',function(){return WtH(w_DatabaseType_Other,'C',60,0,'')},w_DatabaseType_Other);
if(c=Ctrl('OJYDANVTYQ')) selectCombo(c,w_DatabaseType_Var,'C')
if(c=Ctrl('FTWSNQIXUU')) ChkboxCheckUncheck(c,'S',w_PostIt)
if(c=Ctrl('FTWSNQIXUU')) ChkboxValueAssign(c,'S','','C',1,0,'')
if (m_bExtended) {
SetExtensions();
}
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay(Ctrl('CTNCYJEQGE'), ! (Empty(w_DatabaseType_Var)) || IsHiddenByStateDriver('DatabaseType_Other'));
SetDisplay(Ctrl('FHRQYPOHRN'), ! (Empty(w_DatabaseType_Var)));
LibJavascript.forEachItem(m_FoundlingHideExpression,i_body_2)
function i_body_2(child){
child();
}
HideUI();
}
HideUI.lblids["DatabaseType_Other"]=['FHRQYPOHRN'];
HideUI.lblids["DatabaseType_Var"]=['RVFUZEGWSR'];
HideUI.lblids["ODBCDataSource"]=['JHGFVWNVYJ'];
HideUI.lblids["ServerDesc"]=['CKZXZDDNCH'];
HideUI.lblids["ServerName"]=['AHFHUBKHBW'];
function JWFUQHQPUG_Valid(e) {
SetActiveField(Ctrl('JWFUQHQPUG'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('JWFUQHQPUG') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('ServerName','C',w_ServerName,HtW(Ctrl('JWFUQHQPUG').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ServerName(HtW(Ctrl('JWFUQHQPUG').value,'C'),null,e);
return l_bSetResult;
}
}
function JWFUQHQPUG_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('JWFUQHQPUG'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('JWFUQHQPUG'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('JWFUQHQPUG'),e);
}
function YGIZDTNCWH_Valid(e) {
SetActiveField(Ctrl('YGIZDTNCWH'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('ServerDesc','C',w_ServerDesc,HtW(Ctrl('YGIZDTNCWH').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ServerDesc(HtW(Ctrl('YGIZDTNCWH').value,'C'),null,e);
return l_bSetResult;
}
}
function YGIZDTNCWH_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('YGIZDTNCWH'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('YGIZDTNCWH'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('YGIZDTNCWH'),e);
}
function JZYFFSWJOU_Valid(e) {
SetActiveField(Ctrl('JZYFFSWJOU'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('ODBCDataSource','C',w_ODBCDataSource,HtW(Ctrl('JZYFFSWJOU').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ODBCDataSource(HtW(Ctrl('JZYFFSWJOU').value,'C'),null,e);
return l_bSetResult;
}
}
function JZYFFSWJOU_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('JZYFFSWJOU'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('JZYFFSWJOU'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('JZYFFSWJOU'),e);
}
function QENAHXGKZP_Click() {
var l_oWv = InitWvApplet();
l_oWv.setValue('ODBCDataSource',AsAppletValue(w_ODBCDataSource));
l_oWv.setValue('DatabaseTypeString',AsAppletValue((Empty(w_DatabaseType)?w_DatabaseType_Other:w_DatabaseType)));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('ODBCDataSource,DatabaseTypeString'));
if ( ! (Empty(w_ODBCDataSource))) {
_modifyandopen('SPServerTestConnection'+'?m_cWv='+URLenc(l_oWv.asString())+'&m_cAction=start&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',false)
}
}
function CTNCYJEQGE_Valid(e) {
SetActiveField(Ctrl('CTNCYJEQGE'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DatabaseType_Other','C',w_DatabaseType_Other,HtW(Ctrl('CTNCYJEQGE').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DatabaseType_Other(HtW(Ctrl('CTNCYJEQGE').value,'C'),null,e);
return l_bSetResult;
}
}
function CTNCYJEQGE_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('CTNCYJEQGE'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('CTNCYJEQGE'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('CTNCYJEQGE'),e);
}
function OJYDANVTYQ_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('DatabaseType_Var','C',w_DatabaseType_Var,HtW(getComboValue(Ctrl('OJYDANVTYQ')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DatabaseType_Var(HtW(getComboValue(Ctrl('OJYDANVTYQ')),'C'),null,e);
return l_bSetResult;
}
}
function OJYDANVTYQ_OnFocus(e) {
SetActiveField(Ctrl('OJYDANVTYQ'),true);
}
function OJYDANVTYQ_OnBlur(e) {
SetActiveField(Ctrl('OJYDANVTYQ'),false);
}
function FTWSNQIXUU_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('PostIt','C',w_PostIt,ChkboxValueAssign(Ctrl('FTWSNQIXUU'),'S','','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PostIt(ChkboxValueAssign(Ctrl('FTWSNQIXUU'),'S','','C',1,0,''),null,e);
return l_bSetResult;
}
}
function FTWSNQIXUU_OnFocus(e) {
SetActiveField(Ctrl('FTWSNQIXUU'),true);
}
function FTWSNQIXUU_OnBlur(e) {
SetActiveField(Ctrl('FTWSNQIXUU'),false);
}
_ResetTracker();
function setEventHandlers() {
var c;
function QENAHXGKZP_wrap_OnClick(event) {
return QENAHXGKZP_Click();
}
SPBOUILib.SetButtonClick('QENAHXGKZP',QENAHXGKZP_wrap_OnClick);
if (Ne(m_cFunction,'view')) {
function JWFUQHQPUG_wrap_Valid(event) {
return JWFUQHQPUG_Valid(event);
}
SPBOUILib.SetInputExit('JWFUQHQPUG',JWFUQHQPUG_wrap_Valid);
function JWFUQHQPUG_wrap_OnFocus(event) {
return JWFUQHQPUG_OnFocus(event);
}
SPBOUILib.SetInputEnter('JWFUQHQPUG',JWFUQHQPUG_wrap_OnFocus);
function JWFUQHQPUG_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('JWFUQHQPUG',JWFUQHQPUG_wrap_OnKeyDown);
function YGIZDTNCWH_wrap_Valid(event) {
return YGIZDTNCWH_Valid(event);
}
SPBOUILib.SetInputExit('YGIZDTNCWH',YGIZDTNCWH_wrap_Valid);
function YGIZDTNCWH_wrap_OnFocus(event) {
return YGIZDTNCWH_OnFocus(event);
}
SPBOUILib.SetInputEnter('YGIZDTNCWH',YGIZDTNCWH_wrap_OnFocus);
function YGIZDTNCWH_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('YGIZDTNCWH',YGIZDTNCWH_wrap_OnKeyDown);
function JZYFFSWJOU_wrap_Valid(event) {
return JZYFFSWJOU_Valid(event);
}
SPBOUILib.SetInputExit('JZYFFSWJOU',JZYFFSWJOU_wrap_Valid);
function JZYFFSWJOU_wrap_OnFocus(event) {
return JZYFFSWJOU_OnFocus(event);
}
SPBOUILib.SetInputEnter('JZYFFSWJOU',JZYFFSWJOU_wrap_OnFocus);
function JZYFFSWJOU_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('JZYFFSWJOU',JZYFFSWJOU_wrap_OnKeyDown);
function QENAHXGKZP_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('QENAHXGKZP',QENAHXGKZP_wrap_OnKeyDown);
function CTNCYJEQGE_wrap_Valid(event) {
return CTNCYJEQGE_Valid(event);
}
SPBOUILib.SetInputExit('CTNCYJEQGE',CTNCYJEQGE_wrap_Valid);
function CTNCYJEQGE_wrap_OnFocus(event) {
return CTNCYJEQGE_OnFocus(event);
}
SPBOUILib.SetInputEnter('CTNCYJEQGE',CTNCYJEQGE_wrap_OnFocus);
function CTNCYJEQGE_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('CTNCYJEQGE',CTNCYJEQGE_wrap_OnKeyDown);
function OJYDANVTYQ_wrap_Valid(event) {
return OJYDANVTYQ_Valid(event);
}
SPBOUILib.SetComboChange('OJYDANVTYQ',OJYDANVTYQ_wrap_Valid);
function OJYDANVTYQ_wrap_OnFocus(event) {
return OJYDANVTYQ_OnFocus(event);
}
SPBOUILib.SetInputEnter('OJYDANVTYQ',OJYDANVTYQ_wrap_OnFocus);
function OJYDANVTYQ_wrap_Blur(event) {
return OJYDANVTYQ_OnBlur(event);
}
SPBOUILib.SetInputExit('OJYDANVTYQ',OJYDANVTYQ_wrap_Blur);
function FTWSNQIXUU_wrap_Valid(event) {
return FTWSNQIXUU_Valid(event);
}
SPBOUILib.SetCheckboxClick('FTWSNQIXUU',FTWSNQIXUU_wrap_Valid);
function FTWSNQIXUU_wrap_OnFocus(event) {
return FTWSNQIXUU_OnFocus(event);
}
SPBOUILib.SetInputEnter('FTWSNQIXUU',FTWSNQIXUU_wrap_OnFocus);
function FTWSNQIXUU_wrap_Blur(event) {
return FTWSNQIXUU_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('FTWSNQIXUU',FTWSNQIXUU_wrap_Blur);
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
FocusFirstComponent.edit={"page_1":["YGIZDTNCWH"]};
FocusFirstComponent.query={"page_1":["JWFUQHQPUG"]};
FocusFirstComponent.otherwise={"page_1":["JWFUQHQPUG"]};
function Help() {
windowOpenForeground('../doc/spadministration_servers_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_ServerName=a[0];
w_ServerDesc=a[1];
w_ODBCDataSource=a[2];
w_DatabaseType=a[3];
w_PostIt=a[4];
w_DatabaseType_SupportedDatabases=a[5];
w_DatabaseType_Other=a[6];
w_DatabaseType_Var=a[7];
if (Gt(a.length,8)) {
o_DatabaseType=w_DatabaseType;
o_DatabaseType_Other=w_DatabaseType_Other;
o_DatabaseType_Var=w_DatabaseType_Var;
}
m_PrimaryKeys=['ServerName'];
}
function i_PrimaryKey() {
return 'cptsrvr'+'\\'+CPLib.ToCPStr(w_ServerName);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('spadministration_servers',m_cSelectedPage);
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
_Obli('ServerName',0,'JWFUQHQPUG',true,"11081652104")
_Obli('ServerDesc',0,'YGIZDTNCWH',false,"1456511638")
_Obli('ODBCDataSource',0,'JZYFFSWJOU',false,"250921820")
_Obli('PostIt',0,'FTWSNQIXUU',false,"126925376")
_Obli('DatabaseType_Other',0,'CTNCYJEQGE',false,"10029302073")
_Obli('DatabaseType_Var',0,'OJYDANVTYQ',false)
