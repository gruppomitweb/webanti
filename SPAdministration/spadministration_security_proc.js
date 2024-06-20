function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('ROXNXYYWEU',function(){return WtH(w_progname,'C',50,0,'')},w_progname);
SPBOUILib.SetInputValue('SIZORIYAFY',function(){return WtH(w_grpcode,'N',6,0,'')},w_grpcode);
SPBOUILib.SetInputValue('TNPTJUMOGJ',function(){return WtH(w_usrcode,'N',9,0,'')},w_usrcode);
SPBOUILib.SetInputValue('GDZEAZSMVW',function(){return WtH(w_sec1,'N',4,0,'')},w_sec1);
SPBOUILib.SetInputValue('LQMKHTCCSC',function(){return WtH(w_sec2,'N',4,0,'')},w_sec2);
SPBOUILib.SetInputValue('XWWVHCAXZB',function(){return WtH(w_sec3,'N',4,0,'')},w_sec3);
SPBOUILib.SetInputValue('KFAWPTNVWL',function(){return WtH(w_sec4,'N',4,0,'')},w_sec4);
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
HideUI.lblids["grpcode"]=['EBQPGLGRSK'];
HideUI.lblids["progname"]=['IIFQTVQRME'];
HideUI.lblids["sec1"]=['ZNRGKRXGNT'];
HideUI.lblids["sec2"]=['WBCURQFMJW'];
HideUI.lblids["sec3"]=['AKREJEBGRV'];
HideUI.lblids["sec4"]=['ZMSTDSCBON'];
HideUI.lblids["usrcode"]=['DSSDFIPKBY'];
function ROXNXYYWEU_Valid(e) {
SetActiveField(Ctrl('ROXNXYYWEU'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('ROXNXYYWEU') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('progname','C',w_progname,HtW(Ctrl('ROXNXYYWEU').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_progname(HtW(Ctrl('ROXNXYYWEU').value,'C'),null,e);
return l_bSetResult;
}
}
function ROXNXYYWEU_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ROXNXYYWEU'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('ROXNXYYWEU'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ROXNXYYWEU'),e);
}
function SIZORIYAFY_Valid(e) {
SetActiveField(Ctrl('SIZORIYAFY'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('SIZORIYAFY') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('grpcode','N',w_grpcode,HtW(Ctrl('SIZORIYAFY').value,'N'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_grpcode(HtW(Ctrl('SIZORIYAFY').value,'N'),null,e);
return l_bSetResult;
}
}
function SIZORIYAFY_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('SIZORIYAFY'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('SIZORIYAFY'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('SIZORIYAFY'),e);
}
function TNPTJUMOGJ_Valid(e) {
SetActiveField(Ctrl('TNPTJUMOGJ'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('TNPTJUMOGJ') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('usrcode','N',w_usrcode,HtW(Ctrl('TNPTJUMOGJ').value,'N'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_usrcode(HtW(Ctrl('TNPTJUMOGJ').value,'N'),null,e);
return l_bSetResult;
}
}
function TNPTJUMOGJ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('TNPTJUMOGJ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('TNPTJUMOGJ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('TNPTJUMOGJ'),e);
}
function GDZEAZSMVW_Valid(e) {
SetActiveField(Ctrl('GDZEAZSMVW'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('sec1','N',w_sec1,HtW(Ctrl('GDZEAZSMVW').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_sec1(HtW(Ctrl('GDZEAZSMVW').value,'N'),null,e);
return l_bSetResult;
}
}
function GDZEAZSMVW_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('GDZEAZSMVW'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('GDZEAZSMVW'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('GDZEAZSMVW'),e);
}
function LQMKHTCCSC_Valid(e) {
SetActiveField(Ctrl('LQMKHTCCSC'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('sec2','N',w_sec2,HtW(Ctrl('LQMKHTCCSC').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_sec2(HtW(Ctrl('LQMKHTCCSC').value,'N'),null,e);
return l_bSetResult;
}
}
function LQMKHTCCSC_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('LQMKHTCCSC'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('LQMKHTCCSC'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('LQMKHTCCSC'),e);
}
function XWWVHCAXZB_Valid(e) {
SetActiveField(Ctrl('XWWVHCAXZB'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('sec3','N',w_sec3,HtW(Ctrl('XWWVHCAXZB').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_sec3(HtW(Ctrl('XWWVHCAXZB').value,'N'),null,e);
return l_bSetResult;
}
}
function XWWVHCAXZB_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('XWWVHCAXZB'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('XWWVHCAXZB'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('XWWVHCAXZB'),e);
}
function KFAWPTNVWL_Valid(e) {
SetActiveField(Ctrl('KFAWPTNVWL'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('sec4','N',w_sec4,HtW(Ctrl('KFAWPTNVWL').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_sec4(HtW(Ctrl('KFAWPTNVWL').value,'N'),null,e);
return l_bSetResult;
}
}
function KFAWPTNVWL_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('KFAWPTNVWL'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('KFAWPTNVWL'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('KFAWPTNVWL'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function ROXNXYYWEU_wrap_Valid(event) {
return ROXNXYYWEU_Valid(event);
}
SPBOUILib.SetInputExit('ROXNXYYWEU',ROXNXYYWEU_wrap_Valid);
function ROXNXYYWEU_wrap_OnFocus(event) {
return ROXNXYYWEU_OnFocus(event);
}
SPBOUILib.SetInputEnter('ROXNXYYWEU',ROXNXYYWEU_wrap_OnFocus);
function ROXNXYYWEU_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('ROXNXYYWEU',ROXNXYYWEU_wrap_OnKeyDown);
function SIZORIYAFY_wrap_Valid(event) {
return SIZORIYAFY_Valid(event);
}
SPBOUILib.SetInputExit('SIZORIYAFY',SIZORIYAFY_wrap_Valid);
function SIZORIYAFY_wrap_OnFocus(event) {
return SIZORIYAFY_OnFocus(event);
}
SPBOUILib.SetInputEnter('SIZORIYAFY',SIZORIYAFY_wrap_OnFocus);
function SIZORIYAFY_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('SIZORIYAFY',SIZORIYAFY_wrap_OnKeyPress);
function SIZORIYAFY_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('SIZORIYAFY',SIZORIYAFY_wrap_OnKeyDown);
function TNPTJUMOGJ_wrap_Valid(event) {
return TNPTJUMOGJ_Valid(event);
}
SPBOUILib.SetInputExit('TNPTJUMOGJ',TNPTJUMOGJ_wrap_Valid);
function TNPTJUMOGJ_wrap_OnFocus(event) {
return TNPTJUMOGJ_OnFocus(event);
}
SPBOUILib.SetInputEnter('TNPTJUMOGJ',TNPTJUMOGJ_wrap_OnFocus);
function TNPTJUMOGJ_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('TNPTJUMOGJ',TNPTJUMOGJ_wrap_OnKeyPress);
function TNPTJUMOGJ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('TNPTJUMOGJ',TNPTJUMOGJ_wrap_OnKeyDown);
function GDZEAZSMVW_wrap_Valid(event) {
return GDZEAZSMVW_Valid(event);
}
SPBOUILib.SetInputExit('GDZEAZSMVW',GDZEAZSMVW_wrap_Valid);
function GDZEAZSMVW_wrap_OnFocus(event) {
return GDZEAZSMVW_OnFocus(event);
}
SPBOUILib.SetInputEnter('GDZEAZSMVW',GDZEAZSMVW_wrap_OnFocus);
function GDZEAZSMVW_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('GDZEAZSMVW',GDZEAZSMVW_wrap_OnKeyPress);
function GDZEAZSMVW_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('GDZEAZSMVW',GDZEAZSMVW_wrap_OnKeyDown);
function LQMKHTCCSC_wrap_Valid(event) {
return LQMKHTCCSC_Valid(event);
}
SPBOUILib.SetInputExit('LQMKHTCCSC',LQMKHTCCSC_wrap_Valid);
function LQMKHTCCSC_wrap_OnFocus(event) {
return LQMKHTCCSC_OnFocus(event);
}
SPBOUILib.SetInputEnter('LQMKHTCCSC',LQMKHTCCSC_wrap_OnFocus);
function LQMKHTCCSC_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('LQMKHTCCSC',LQMKHTCCSC_wrap_OnKeyPress);
function LQMKHTCCSC_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('LQMKHTCCSC',LQMKHTCCSC_wrap_OnKeyDown);
function XWWVHCAXZB_wrap_Valid(event) {
return XWWVHCAXZB_Valid(event);
}
SPBOUILib.SetInputExit('XWWVHCAXZB',XWWVHCAXZB_wrap_Valid);
function XWWVHCAXZB_wrap_OnFocus(event) {
return XWWVHCAXZB_OnFocus(event);
}
SPBOUILib.SetInputEnter('XWWVHCAXZB',XWWVHCAXZB_wrap_OnFocus);
function XWWVHCAXZB_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('XWWVHCAXZB',XWWVHCAXZB_wrap_OnKeyPress);
function XWWVHCAXZB_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('XWWVHCAXZB',XWWVHCAXZB_wrap_OnKeyDown);
function KFAWPTNVWL_wrap_Valid(event) {
return KFAWPTNVWL_Valid(event);
}
SPBOUILib.SetInputExit('KFAWPTNVWL',KFAWPTNVWL_wrap_Valid);
function KFAWPTNVWL_wrap_OnFocus(event) {
return KFAWPTNVWL_OnFocus(event);
}
SPBOUILib.SetInputEnter('KFAWPTNVWL',KFAWPTNVWL_wrap_OnFocus);
function KFAWPTNVWL_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('KFAWPTNVWL',KFAWPTNVWL_wrap_OnKeyPress);
function KFAWPTNVWL_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('KFAWPTNVWL',KFAWPTNVWL_wrap_OnKeyDown);
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
FocusFirstComponent.edit={"page_1":["GDZEAZSMVW"]};
FocusFirstComponent.query={"page_1":["ROXNXYYWEU"]};
FocusFirstComponent.otherwise={"page_1":["ROXNXYYWEU"]};
function Help() {
windowOpenForeground('../doc/spadministration_security_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_progname=a[0];
w_grpcode=a[1];
w_usrcode=a[2];
w_sec1=a[3];
w_sec2=a[4];
w_sec3=a[5];
w_sec4=a[6];
m_PrimaryKeys=['usrcode','grpcode','progname'];
}
function i_PrimaryKey() {
return 'cpprgsec'+'\\'+CPLib.ToCPStr(w_progname)+'\\'+CPLib.ToCPStr(w_grpcode)+'\\'+CPLib.ToCPStr(w_usrcode);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('spadministration_security',m_cSelectedPage);
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
_Obli('progname',0,'ROXNXYYWEU',false,"134969174")
_Obli('grpcode',1,'SIZORIYAFY',false,"897043739")
_Obli('usrcode',1,'TNPTJUMOGJ',false,"11286107926")
_Obli('sec1',1,'GDZEAZSMVW',false,"128563569")
_Obli('sec2',1,'LQMKHTCCSC',false,"129550889")
_Obli('sec3',1,'XWWVHCAXZB',false,"134019901")
_Obli('sec4',1,'KFAWPTNVWL',false,"113951380")
