function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('AGYUYJEUTN',function(){return WtH(w_code,'C',3,0,'M')},w_code);
SPBOUILib.SetInputValue('SDVBSZNZRJ',function(){return WtH(w_name,'C',25,0,'')},w_name);
if(c=Ctrl('GQOYGTJJUD')) ChkboxCheckUncheck(c,'S',w_datalanguage)
if(c=Ctrl('GQOYGTJJUD')) ChkboxValueAssign(c,'S','','C',1,0,'')
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
HideUI.lblids["code"]=['ODXEWVVOHX'];
HideUI.lblids["name"]=['XCAVHOMIJB'];
function AGYUYJEUTN_Valid(e) {
SetActiveField(Ctrl('AGYUYJEUTN'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('AGYUYJEUTN') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('code','C',w_code,HtW(Ctrl('AGYUYJEUTN').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_code(HtW(Ctrl('AGYUYJEUTN').value,'C'),null,e);
return l_bSetResult;
}
}
function AGYUYJEUTN_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('AGYUYJEUTN'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('AGYUYJEUTN',w_code,'C',3,0,'M');
SetActiveField(Ctrl('AGYUYJEUTN'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('AGYUYJEUTN'),e);
}
function AGYUYJEUTN_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("M"));
}
function SDVBSZNZRJ_Valid(e) {
SetActiveField(Ctrl('SDVBSZNZRJ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('name','C',w_name,HtW(Ctrl('SDVBSZNZRJ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_name(HtW(Ctrl('SDVBSZNZRJ').value,'C'),null,e);
return l_bSetResult;
}
}
function SDVBSZNZRJ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('SDVBSZNZRJ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('SDVBSZNZRJ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('SDVBSZNZRJ'),e);
}
function GQOYGTJJUD_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('datalanguage','C',w_datalanguage,ChkboxValueAssign(Ctrl('GQOYGTJJUD'),'S','','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_datalanguage(ChkboxValueAssign(Ctrl('GQOYGTJJUD'),'S','','C',1,0,''),null,e);
return l_bSetResult;
}
}
function GQOYGTJJUD_OnFocus(e) {
SetActiveField(Ctrl('GQOYGTJJUD'),true);
}
function GQOYGTJJUD_OnBlur(e) {
SetActiveField(Ctrl('GQOYGTJJUD'),false);
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
function AGYUYJEUTN_wrap_Valid(event) {
return AGYUYJEUTN_Valid(event);
}
SPBOUILib.SetInputExit('AGYUYJEUTN',AGYUYJEUTN_wrap_Valid);
function AGYUYJEUTN_wrap_OnFocus(event) {
return AGYUYJEUTN_OnFocus(event);
}
SPBOUILib.SetInputEnter('AGYUYJEUTN',AGYUYJEUTN_wrap_OnFocus);
function AGYUYJEUTN_wrap_OnKeyPress(event) {
return CheckUpper(event);
}
SPBOUILib.SetInputKeyPress('AGYUYJEUTN',AGYUYJEUTN_wrap_OnKeyPress);
function AGYUYJEUTN_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('AGYUYJEUTN',AGYUYJEUTN_wrap_OnKeyDown);
function SDVBSZNZRJ_wrap_Valid(event) {
return SDVBSZNZRJ_Valid(event);
}
SPBOUILib.SetInputExit('SDVBSZNZRJ',SDVBSZNZRJ_wrap_Valid);
function SDVBSZNZRJ_wrap_OnFocus(event) {
return SDVBSZNZRJ_OnFocus(event);
}
SPBOUILib.SetInputEnter('SDVBSZNZRJ',SDVBSZNZRJ_wrap_OnFocus);
function SDVBSZNZRJ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('SDVBSZNZRJ',SDVBSZNZRJ_wrap_OnKeyDown);
function GQOYGTJJUD_wrap_Valid(event) {
return GQOYGTJJUD_Valid(event);
}
SPBOUILib.SetCheckboxClick('GQOYGTJJUD',GQOYGTJJUD_wrap_Valid);
function GQOYGTJJUD_wrap_OnFocus(event) {
return GQOYGTJJUD_OnFocus(event);
}
SPBOUILib.SetInputEnter('GQOYGTJJUD',GQOYGTJJUD_wrap_OnFocus);
function GQOYGTJJUD_wrap_Blur(event) {
return GQOYGTJJUD_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('GQOYGTJJUD',GQOYGTJJUD_wrap_Blur);
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
FocusFirstComponent.edit={"page_1":["SDVBSZNZRJ"]};
FocusFirstComponent.query={"page_1":["AGYUYJEUTN"]};
FocusFirstComponent.otherwise={"page_1":["AGYUYJEUTN"]};
function Help() {
windowOpenForeground('../doc/spadministration_langs_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_code=a[0];
w_name=a[1];
w_datalanguage=a[2];
w_admin_database=a[3];
w_database_updated=a[4];
w_refreshlanguage=a[5];
w_sudb_mode=a[6];
m_PrimaryKeys=['code'];
}
function i_PrimaryKey() {
return 'cplangs'+'\\'+CPLib.ToCPStr(w_code);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('spadministration_langs',m_cSelectedPage);
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
_Obli('code',0,'AGYUYJEUTN',false,"960685589")
_Obli('name',0,'SDVBSZNZRJ',false,"1682105886")
_Obli('datalanguage',0,'GQOYGTJJUD',false,"1130485569")
_Obli('admin_database',4,'KXQZZAOVGI',false,"141583885")
