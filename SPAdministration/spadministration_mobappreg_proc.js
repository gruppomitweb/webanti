function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('QOFJORHBZQ',function(){return WtH(w_ar__code,'C',10,0,'')},w_ar__code);
SPBOUILib.SetInputValue('FYLJLUVLGL',function(){return WtH(w_ar__mail,'C',80,0,'')},w_ar__mail);
SPBOUILib.SetInputValue('PQFPIILDIC',function(){return WtH(w_arfullname,'C',80,0,'')},w_arfullname);
SPBOUILib.SetInputValue('QCCDLLTLVF',function(){return WtH(w_arcompany,'C',80,0,'')},w_arcompany);
SPBOUILib.SetInputValue('NRVROHJQLK',function(){return WtH(w_ar__note,'M',10,0,'')},w_ar__note);
SPBOUILib.SetInputValue('VIVHVXHTPW',function(){return WtH(w_ar_dtreg,'T',14,0,TranslatePicture(GetDatePicture(true,'T'),'T'))},w_ar_dtreg);
SPBOUILib.SetInputValue('AWNRNTYQVV',function(){return WtH(w_arappurl,'C',120,0,'')},w_arappurl);
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
HideUI.lblids["ar__code"]=['MYGEGBENKK'];
HideUI.lblids["ar__mail"]=['AJSHJURITC'];
HideUI.lblids["ar__note"]=['OQPKUKEZLY'];
HideUI.lblids["ar_dtreg"]=['XMWWOEOPJF'];
HideUI.lblids["arappurl"]=['FMTGBBPLPF'];
HideUI.lblids["arcompany"]=['REYAZEAJFD'];
HideUI.lblids["arfullname"]=['ZMNZCBRQSN'];
function QOFJORHBZQ_Valid(e) {
if (Ne(Ctrl('QOFJORHBZQ').value,'')) {
Ctrl('QOFJORHBZQ').value=zeroFill(Ctrl('QOFJORHBZQ').value,10);
}
SetActiveField(Ctrl('QOFJORHBZQ'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('QOFJORHBZQ') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('ar__code','C',w_ar__code,HtW(Ctrl('QOFJORHBZQ').value,'C'),m_bQueryOnLatestKeyOnly);
}
}
}
function QOFJORHBZQ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('QOFJORHBZQ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('QOFJORHBZQ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('QOFJORHBZQ'),e);
}
function FYLJLUVLGL_Valid(e) {
SetActiveField(Ctrl('FYLJLUVLGL'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('ar__mail','C',w_ar__mail,HtW(Ctrl('FYLJLUVLGL').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ar__mail(HtW(Ctrl('FYLJLUVLGL').value,'C'),null,e);
return l_bSetResult;
}
}
function FYLJLUVLGL_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('FYLJLUVLGL'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('FYLJLUVLGL'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('FYLJLUVLGL'),e);
}
function PQFPIILDIC_Valid(e) {
SetActiveField(Ctrl('PQFPIILDIC'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('arfullname','C',w_arfullname,HtW(Ctrl('PQFPIILDIC').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_arfullname(HtW(Ctrl('PQFPIILDIC').value,'C'),null,e);
return l_bSetResult;
}
}
function PQFPIILDIC_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('PQFPIILDIC'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('PQFPIILDIC'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('PQFPIILDIC'),e);
}
function QCCDLLTLVF_Valid(e) {
SetActiveField(Ctrl('QCCDLLTLVF'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('arcompany','C',w_arcompany,HtW(Ctrl('QCCDLLTLVF').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_arcompany(HtW(Ctrl('QCCDLLTLVF').value,'C'),null,e);
return l_bSetResult;
}
}
function QCCDLLTLVF_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('QCCDLLTLVF'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('QCCDLLTLVF'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('QCCDLLTLVF'),e);
}
function NRVROHJQLK_Valid(e) {
SetActiveField(Ctrl('NRVROHJQLK'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('ar__note','M',w_ar__note,HtW(Ctrl('NRVROHJQLK').value,'M'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ar__note(HtW(Ctrl('NRVROHJQLK').value,'M'),null,e);
return l_bSetResult;
}
}
function NRVROHJQLK_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('NRVROHJQLK'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('NRVROHJQLK'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('NRVROHJQLK'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function QOFJORHBZQ_wrap_Valid(event) {
return QOFJORHBZQ_Valid(event);
}
SPBOUILib.SetInputExit('QOFJORHBZQ',QOFJORHBZQ_wrap_Valid);
function QOFJORHBZQ_wrap_OnFocus(event) {
return QOFJORHBZQ_OnFocus(event);
}
SPBOUILib.SetInputEnter('QOFJORHBZQ',QOFJORHBZQ_wrap_OnFocus);
function QOFJORHBZQ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('QOFJORHBZQ',QOFJORHBZQ_wrap_OnKeyDown);
function FYLJLUVLGL_wrap_Valid(event) {
return FYLJLUVLGL_Valid(event);
}
SPBOUILib.SetInputExit('FYLJLUVLGL',FYLJLUVLGL_wrap_Valid);
function FYLJLUVLGL_wrap_OnFocus(event) {
return FYLJLUVLGL_OnFocus(event);
}
SPBOUILib.SetInputEnter('FYLJLUVLGL',FYLJLUVLGL_wrap_OnFocus);
function FYLJLUVLGL_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('FYLJLUVLGL',FYLJLUVLGL_wrap_OnKeyDown);
function PQFPIILDIC_wrap_Valid(event) {
return PQFPIILDIC_Valid(event);
}
SPBOUILib.SetInputExit('PQFPIILDIC',PQFPIILDIC_wrap_Valid);
function PQFPIILDIC_wrap_OnFocus(event) {
return PQFPIILDIC_OnFocus(event);
}
SPBOUILib.SetInputEnter('PQFPIILDIC',PQFPIILDIC_wrap_OnFocus);
function PQFPIILDIC_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('PQFPIILDIC',PQFPIILDIC_wrap_OnKeyDown);
function QCCDLLTLVF_wrap_Valid(event) {
return QCCDLLTLVF_Valid(event);
}
SPBOUILib.SetInputExit('QCCDLLTLVF',QCCDLLTLVF_wrap_Valid);
function QCCDLLTLVF_wrap_OnFocus(event) {
return QCCDLLTLVF_OnFocus(event);
}
SPBOUILib.SetInputEnter('QCCDLLTLVF',QCCDLLTLVF_wrap_OnFocus);
function QCCDLLTLVF_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('QCCDLLTLVF',QCCDLLTLVF_wrap_OnKeyDown);
function NRVROHJQLK_wrap_Valid(event) {
return NRVROHJQLK_Valid(event);
}
SPBOUILib.SetInputExit('NRVROHJQLK',NRVROHJQLK_wrap_Valid);
function NRVROHJQLK_wrap_OnFocus(event) {
return NRVROHJQLK_OnFocus(event);
}
SPBOUILib.SetInputEnter('NRVROHJQLK',NRVROHJQLK_wrap_OnFocus);
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
FocusFirstComponent.edit={"page_1":["FYLJLUVLGL"]};
FocusFirstComponent.query={"page_1":["QOFJORHBZQ","FYLJLUVLGL"]};
FocusFirstComponent.otherwise={"page_1":["FYLJLUVLGL"]};
function Help() {
windowOpenForeground('../doc/spadministration_mobappreg_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_ar__code=a[0];
op_ar__code=a[1];
w_ar__mail=a[2];
w_arfullname=a[3];
w_arcompany=a[4];
w_ar__note=a[5];
w_ar_dtreg=a[6];
w_arappurl=a[7];
m_PrimaryKeys=['ar__code'];
}
function i_PrimaryKey() {
return 'cpappreg'+'\\'+CPLib.ToCPStr(w_ar__code);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('spadministration_mobappreg',m_cSelectedPage);
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
_Obli('arcompany',0,'QCCDLLTLVF',false,"10844721971")
_Obli('ar__mail',0,'FYLJLUVLGL',false,"11402881420")
_Obli('arfullname',0,'PQFPIILDIC',false,"11037212503")
_Obli('ar__note',0,'NRVROHJQLK',false,"11409442956")
