function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('FETUPRQQAZ',function(){return WtH(w_codazi,'C',10,0,'')},w_codazi);
SPBOUILib.SetInputValue('CSZNONIHWO',function(){return WtH(w_desazi,'C',70,0,'')},w_desazi);
if(c=Ctrl('KXQZZAOVGI')) ChkboxCheckUncheck(c,true,w_admin_database)
if(c=Ctrl('KXQZZAOVGI')) ChkboxValueAssign(c,true,false,'L',1,0,'')
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
HideUI.lblids["codazi"]=['TMQXCKCZQK'];
HideUI.lblids["desazi"]=['MVQRZAUKCD'];
function FETUPRQQAZ_Valid(e) {
SetActiveField(Ctrl('FETUPRQQAZ'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('FETUPRQQAZ') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('codazi','C',w_codazi,HtW(Ctrl('FETUPRQQAZ').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_codazi(HtW(Ctrl('FETUPRQQAZ').value,'C'),null,e);
return l_bSetResult;
}
}
function FETUPRQQAZ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('FETUPRQQAZ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('FETUPRQQAZ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('FETUPRQQAZ'),e);
}
function CSZNONIHWO_Valid(e) {
SetActiveField(Ctrl('CSZNONIHWO'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('desazi','C',w_desazi,HtW(Ctrl('CSZNONIHWO').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_desazi(HtW(Ctrl('CSZNONIHWO').value,'C'),null,e);
return l_bSetResult;
}
}
function CSZNONIHWO_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('CSZNONIHWO'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('CSZNONIHWO'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('CSZNONIHWO'),e);
}
function KXQZZAOVGI_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('admin_database','L',w_admin_database,ChkboxValueAssign(Ctrl('KXQZZAOVGI'),true,false,'L',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_admin_database(ChkboxValueAssign(Ctrl('KXQZZAOVGI'),true,false,'L',1,0,''),null,e);
return l_bSetResult;
}
}
function KXQZZAOVGI_OnFocus(e) {
SetActiveField(Ctrl('KXQZZAOVGI'),true);
}
function KXQZZAOVGI_OnBlur(e) {
SetActiveField(Ctrl('KXQZZAOVGI'),false);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function FETUPRQQAZ_wrap_Valid(event) {
return FETUPRQQAZ_Valid(event);
}
SPBOUILib.SetInputExit('FETUPRQQAZ',FETUPRQQAZ_wrap_Valid);
function FETUPRQQAZ_wrap_OnFocus(event) {
return FETUPRQQAZ_OnFocus(event);
}
SPBOUILib.SetInputEnter('FETUPRQQAZ',FETUPRQQAZ_wrap_OnFocus);
function FETUPRQQAZ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('FETUPRQQAZ',FETUPRQQAZ_wrap_OnKeyDown);
function CSZNONIHWO_wrap_Valid(event) {
return CSZNONIHWO_Valid(event);
}
SPBOUILib.SetInputExit('CSZNONIHWO',CSZNONIHWO_wrap_Valid);
function CSZNONIHWO_wrap_OnFocus(event) {
return CSZNONIHWO_OnFocus(event);
}
SPBOUILib.SetInputEnter('CSZNONIHWO',CSZNONIHWO_wrap_OnFocus);
function CSZNONIHWO_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('CSZNONIHWO',CSZNONIHWO_wrap_OnKeyDown);
function KXQZZAOVGI_wrap_Valid(event) {
return KXQZZAOVGI_Valid(event);
}
SPBOUILib.SetCheckboxClick('KXQZZAOVGI',KXQZZAOVGI_wrap_Valid);
function KXQZZAOVGI_wrap_OnFocus(event) {
return KXQZZAOVGI_OnFocus(event);
}
SPBOUILib.SetInputEnter('KXQZZAOVGI',KXQZZAOVGI_wrap_OnFocus);
function KXQZZAOVGI_wrap_Blur(event) {
return KXQZZAOVGI_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('KXQZZAOVGI',KXQZZAOVGI_wrap_Blur);
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
FocusFirstComponent.edit={"page_1":["CSZNONIHWO"]};
FocusFirstComponent.query={"page_1":["FETUPRQQAZ"]};
FocusFirstComponent.otherwise={"page_1":["FETUPRQQAZ"]};
function Help() {
windowOpenForeground('../doc/spadministration_companies_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_codazi=a[0];
w_desazi=a[1];
w_database_updated=a[2];
w_sudb_mode=a[3];
w_admin_database=a[4];
m_PrimaryKeys=['codazi'];
}
function i_PrimaryKey() {
return 'cpazi'+'\\'+CPLib.ToCPStr(w_codazi);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('spadministration_companies',m_cSelectedPage);
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
_Obli('codazi',0,'FETUPRQQAZ',false,"960685589")
_Obli('desazi',0,'CSZNONIHWO',false,"10656947118")
_Obli('admin_database',4,'KXQZZAOVGI',false)
