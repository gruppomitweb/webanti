function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('YNMIZJQYRY',function(){return WtH(w_utcodice,'C',10,0,'')},w_utcodice);
SPBOUILib.SetInputValue('JQQLMQKNBX',function(){return WtH(w_utnomine,'C',40,0,'')},w_utnomine);
SPBOUILib.SetInputValue('UEJQOTYNAX',function(){return WtH(w_utpasswd,'C',20,0,'')},w_utpasswd);
SPBOUILib.SetInputValue('NMZFYXYKDM',function(){return WtH(w_utcod_cp,'N',4,0,'9999')},w_utcod_cp);
SPBOUILib.SetInputValue('HQCVHXWENH',function(){return WtH(w_ut_email,'C',40,0,'')},w_ut_email);
SPBOUILib.SetInputValue('ZKRXYNLUTO',function(){return WtH(w_utdatacc,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_utdatacc);
var tmp_PORSATWCDE = ToHTag(AsControlValue(w_xdesute));
if (Ne(e_PORSATWCDE,tmp_PORSATWCDE)) {
SPBOUILib.SetLabelValue('PORSATWCDE','innerHTML',tmp_PORSATWCDE);
e_PORSATWCDE=tmp_PORSATWCDE;
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
SetDisplay('YORQOIOBQN_DIV',IsHiddenByStateDriver('box_YORQOIOBQN'));
LibJavascript.forEachItem(m_FoundlingHideExpression,i_body_2)
function i_body_2(child){
child();
}
HideUI();
}
HideUI.lblids["ut_email"]=['XLVVNNGBCK'];
HideUI.lblids["utcod_cp"]=['CJIZEIKIXB'];
HideUI.lblids["utcodice"]=['CUYIVZIFCZ'];
HideUI.lblids["utdatacc"]=['KSFJQWICZL'];
HideUI.lblids["utnomine"]=['RAQEBEKWCP'];
HideUI.lblids["utpasswd"]=['QMJTAQOVVF'];
function YNMIZJQYRY_Valid(e) {
SetActiveField(Ctrl('YNMIZJQYRY'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('YNMIZJQYRY') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('utcodice','C',w_utcodice,HtW(Ctrl('YNMIZJQYRY').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_utcodice(HtW(Ctrl('YNMIZJQYRY').value,'C'),null,e);
return l_bSetResult;
}
}
function YNMIZJQYRY_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('YNMIZJQYRY'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('YNMIZJQYRY'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('YNMIZJQYRY'),e);
}
function JQQLMQKNBX_Valid(e) {
SetActiveField(Ctrl('JQQLMQKNBX'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('utnomine','C',w_utnomine,HtW(Ctrl('JQQLMQKNBX').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_utnomine(HtW(Ctrl('JQQLMQKNBX').value,'C'),null,e);
return l_bSetResult;
}
}
function JQQLMQKNBX_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('JQQLMQKNBX'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('JQQLMQKNBX'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('JQQLMQKNBX'),e);
}
function UEJQOTYNAX_Valid(e) {
SetActiveField(Ctrl('UEJQOTYNAX'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('utpasswd','C',w_utpasswd,HtW(Ctrl('UEJQOTYNAX').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_utpasswd(HtW(Ctrl('UEJQOTYNAX').value,'C'),null,e);
return l_bSetResult;
}
}
function UEJQOTYNAX_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('UEJQOTYNAX'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('UEJQOTYNAX'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('UEJQOTYNAX'),e);
}
function NMZFYXYKDM_Valid(e) {
SetActiveField(Ctrl('NMZFYXYKDM'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('utcod_cp','N',w_utcod_cp,HtW(Ctrl('NMZFYXYKDM').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_utcod_cp(HtW(Ctrl('NMZFYXYKDM').value,'N'),null,e);
return l_bSetResult;
}
}
function NMZFYXYKDM_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('NMZFYXYKDM'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('NMZFYXYKDM',w_utcod_cp,'N',4,0,'9999');
SetActiveField(Ctrl('NMZFYXYKDM'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('NMZFYXYKDM'),e);
}
function NMZFYXYKDM_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("9999"));
}
function NMZFYXYKDM_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('NMZFYXYKDM')),'linkview_NMZFYXYKDM','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function HQCVHXWENH_Valid(e) {
SetActiveField(Ctrl('HQCVHXWENH'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('ut_email','C',w_ut_email,HtW(Ctrl('HQCVHXWENH').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ut_email(HtW(Ctrl('HQCVHXWENH').value,'C'),null,e);
return l_bSetResult;
}
}
function HQCVHXWENH_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('HQCVHXWENH'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('HQCVHXWENH'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('HQCVHXWENH'),e);
}
function ZKRXYNLUTO_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('ZKRXYNLUTO'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('ZKRXYNLUTO').value=ApplyPictureToDate(Ctrl('ZKRXYNLUTO').value,TranslatePicture(datePattern),'ZKRXYNLUTO');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('ZKRXYNLUTO'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('ZKRXYNLUTO');
}
}
}
SetActiveField(Ctrl('ZKRXYNLUTO'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('utdatacc','D',w_utdatacc,HtW(Ctrl('ZKRXYNLUTO').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_utdatacc(HtW(Ctrl('ZKRXYNLUTO').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function ZKRXYNLUTO_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ZKRXYNLUTO'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('ZKRXYNLUTO',w_utdatacc,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('ZKRXYNLUTO');
SetActiveField(Ctrl('ZKRXYNLUTO'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ZKRXYNLUTO'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function YNMIZJQYRY_wrap_Valid(event) {
return YNMIZJQYRY_Valid(event);
}
SPBOUILib.SetInputExit('YNMIZJQYRY',YNMIZJQYRY_wrap_Valid);
function YNMIZJQYRY_wrap_OnFocus(event) {
return YNMIZJQYRY_OnFocus(event);
}
SPBOUILib.SetInputEnter('YNMIZJQYRY',YNMIZJQYRY_wrap_OnFocus);
function YNMIZJQYRY_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('YNMIZJQYRY',YNMIZJQYRY_wrap_OnKeyDown);
function JQQLMQKNBX_wrap_Valid(event) {
return JQQLMQKNBX_Valid(event);
}
SPBOUILib.SetInputExit('JQQLMQKNBX',JQQLMQKNBX_wrap_Valid);
function JQQLMQKNBX_wrap_OnFocus(event) {
return JQQLMQKNBX_OnFocus(event);
}
SPBOUILib.SetInputEnter('JQQLMQKNBX',JQQLMQKNBX_wrap_OnFocus);
function JQQLMQKNBX_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('JQQLMQKNBX',JQQLMQKNBX_wrap_OnKeyDown);
function UEJQOTYNAX_wrap_Valid(event) {
return UEJQOTYNAX_Valid(event);
}
SPBOUILib.SetInputExit('UEJQOTYNAX',UEJQOTYNAX_wrap_Valid);
function UEJQOTYNAX_wrap_OnFocus(event) {
return UEJQOTYNAX_OnFocus(event);
}
SPBOUILib.SetInputEnter('UEJQOTYNAX',UEJQOTYNAX_wrap_OnFocus);
function UEJQOTYNAX_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('UEJQOTYNAX',UEJQOTYNAX_wrap_OnKeyDown);
function NMZFYXYKDM_wrap_Valid(event) {
return NMZFYXYKDM_Valid(event);
}
SPBOUILib.SetInputExit('NMZFYXYKDM',NMZFYXYKDM_wrap_Valid);
function NMZFYXYKDM_wrap_OnFocus(event) {
return NMZFYXYKDM_OnFocus(event);
}
SPBOUILib.SetInputEnter('NMZFYXYKDM',NMZFYXYKDM_wrap_OnFocus);
function NMZFYXYKDM_wrap_OnKeyPress(event) {
return NMZFYXYKDM_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('NMZFYXYKDM',NMZFYXYKDM_wrap_OnKeyPress);
function NMZFYXYKDM_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('NMZFYXYKDM',NMZFYXYKDM_wrap_OnKeyDown);
function NMZFYXYKDM_ZOOM_setHandlers() {
function NMZFYXYKDM_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?NMZFYXYKDM_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('NMZFYXYKDM_ZOOM',NMZFYXYKDM_ZOOM_wrap_OnClick);
function NMZFYXYKDM_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('NMZFYXYKDM_ZOOM',NMZFYXYKDM_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('NMZFYXYKDM',NMZFYXYKDM_ZOOM_setHandlers);
function HQCVHXWENH_wrap_Valid(event) {
return HQCVHXWENH_Valid(event);
}
SPBOUILib.SetInputExit('HQCVHXWENH',HQCVHXWENH_wrap_Valid);
function HQCVHXWENH_wrap_OnFocus(event) {
return HQCVHXWENH_OnFocus(event);
}
SPBOUILib.SetInputEnter('HQCVHXWENH',HQCVHXWENH_wrap_OnFocus);
function HQCVHXWENH_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('HQCVHXWENH',HQCVHXWENH_wrap_OnKeyDown);
function ZKRXYNLUTO_wrap_Valid(event) {
return ZKRXYNLUTO_Valid(event);
}
SPBOUILib.SetInputExit('ZKRXYNLUTO',ZKRXYNLUTO_wrap_Valid);
function ZKRXYNLUTO_wrap_OnFocus(event) {
return ZKRXYNLUTO_OnFocus(event);
}
SPBOUILib.SetInputEnter('ZKRXYNLUTO',ZKRXYNLUTO_wrap_OnFocus);
function ZKRXYNLUTO_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('ZKRXYNLUTO',ZKRXYNLUTO_wrap_OnKeyPress);
function ZKRXYNLUTO_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('ZKRXYNLUTO',ZKRXYNLUTO_wrap_OnKeyDown);
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
FocusFirstComponent.edit={"page_1":["JQQLMQKNBX"]};
FocusFirstComponent.query={"page_1":["YNMIZJQYRY"]};
FocusFirstComponent.otherwise={"page_1":["YNMIZJQYRY"]};
function Help() {
windowOpenForeground('../doc/armt_utenti_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_utcodice=a[0];
w_utnomine=a[1];
w_utpasswd=a[2];
w_utcod_cp=a[3];
w_ut_email=a[4];
w_utdatacc=a[5];
w_xdesute=a[6];
m_PrimaryKeys=['utcodice'];
}
function i_PrimaryKey() {
return 'utenti'+'\\'+CPLib.ToCPStr(w_utcodice);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('armt_utenti',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
function LinkZoomExtendedMenu() {
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_utcod_cp,'N'); },"field":"code","type":"N"},{"expression":function() { return WtA(w_xdesute,'C'); },"field":"name","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('cpusers','C'),"uid":"NMZFYXYKDM"});
}
_Obli('utcodice',0,'YNMIZJQYRY',false,"1999024119")
_Obli('utnomine',0,'JQQLMQKNBX',false,"176491428")
_Obli('utpasswd',0,'UEJQOTYNAX',false,"11183929984")
_Obli('utcod_cp',1,'NMZFYXYKDM',false,"197247171")
_Obli('ut_email',0,'HQCVHXWENH',false,"7534645")
_Obli('utdatacc',2,'ZKRXYNLUTO',false,"538438265")
