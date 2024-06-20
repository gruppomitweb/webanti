function SetControlsValue() {
var c;
var c;
if(c=Ctrl('UCCWMDWDFX')) c.value = WtH(w_password,'C',10,0,'')
if(c=Ctrl('BKGRSEWVYY')) c.value = WtH(w_logoperaz,'M',10,0,'')
var tmp_AWGWWPNBYO = ToHTag(AsControlValue(w_logoperaz));
if (Ne(e_AWGWWPNBYO,tmp_AWGWWPNBYO)) {
if(c=Ctrl('AWGWWPNBYO')) c.innerHTML=tmp_AWGWWPNBYO;
e_AWGWWPNBYO=tmp_AWGWWPNBYO;
}
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay(Ctrl('GEDJGVMCKZ'),Ne(Upper(w_password),'AZZAGE'));
SetDisplay(Ctrl('BKGRSEWVYY'),Eq(1,1) || IsHiddenByStateDriver('logoperaz'));
HideUI();
}
function UCCWMDWDFX_Valid(e) {
SetActiveField(Ctrl('UCCWMDWDFX'),false);
e=(Ne(e,null)?e:window.event);
return Set_password(HtW(Ctrl('UCCWMDWDFX').value,'C'),null,e);
}
function UCCWMDWDFX_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('UCCWMDWDFX'))) {
DisplayErrorMessage();
}
Ctrl('UCCWMDWDFX').value=WtH(w_password,'C',10,0,'');
SetActiveField(Ctrl('UCCWMDWDFX'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('UCCWMDWDFX'),e);
}
function UCCWMDWDFX_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("*"));
}
function href_GEDJGVMCKZ() {
DeleteFile()
}
function href_AJXISNWTIP() {
var action = (Eq(Left('centrale'+''+'?',17),'arpg_azzerainvii?')?'query':'start');
SetHypPar('m_cAction',AsAppletValue(action));
SetHypPar('m_cMode',AsAppletValue('hyperlink'));
SendData(action,'centrale'+'',HParApplet().asString());
}
function BKGRSEWVYY_Valid(e) {
SetActiveField(Ctrl('BKGRSEWVYY'),false);
e=(Ne(e,null)?e:window.event);
return Set_logoperaz(HtW(Ctrl('BKGRSEWVYY').value,'M'),null,e);
}
function BKGRSEWVYY_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('BKGRSEWVYY'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('BKGRSEWVYY'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('BKGRSEWVYY'),e);
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
if(c=Ctrl('UCCWMDWDFX')) c.onblur=UCCWMDWDFX_Valid;
if(c=Ctrl('UCCWMDWDFX')) c.onfocus=UCCWMDWDFX_OnFocus;
if(c=Ctrl('BKGRSEWVYY')) c.onblur=BKGRSEWVYY_Valid;
if(c=Ctrl('BKGRSEWVYY')) c.onfocus=BKGRSEWVYY_OnFocus;
}
}
function NotifyEvent(p_cEvent) {
var old_c;
}
function SetLastFocusedOnParent() {
// used only in child entities
}
function DoUpdate(p_bResult) {
Calculate();
SaveDependsOn();
SetControlsValue();
SetDynamicClasses();
SetDynamicTooltip();
EnableControlsUnderCondition();
SaveLabelDependsOn();
if ( ! (p_bResult)) {
DisplayErrorMessage();
}
m_nLastError=0;
m_cLastMsgError='';
}
FocusFirstComponent.otherwise={"page_1":["UCCWMDWDFX"]};
function Help() {
windowOpenForeground('../doc/arpg_azzerainvii_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_password=a[0];
w_logoperaz=a[1];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_azzerainvii',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
function DisplayErrorMessage() {
if (Le(m_nLastError,-1)) {
return;
}
if (Eq(typeof(m_cErrorInChild),'undefined') || Empty(m_cErrorInChild)) {
var l_cErrorMsg = m_cLastMsgError;
if (Eq(l_cErrorMsg,'')) {
if (Eq(m_nLastError,1)) {
l_cErrorMsg='MSG_OBBLI_FIELD';
} else if (Eq(m_nLastError,2)) {
l_cErrorMsg='MSG_VALUE_NOT_ALLOWED';
} else if (Eq(m_nLastError,3)) {
l_cErrorMsg='MSG_VALUE_NOT_ALLOWED';
} else {
l_cErrorMsg='MSG_UNSPEC_ERROR';
}
}
if (Eq(m_nLastError,1)) {
WindowAlert(Translate(m_cObblFieldName)+' : '+Translate(l_cErrorMsg));
} else {
if (Eq(l_cErrorMsg,'MSG_VALUE_NOT_ALLOWED') && Ne(m_cLastWorkVarErrorMsg,'')) {
WindowAlert(Translate(m_cLastWorkVarErrorMsg)+': '+Translate(l_cErrorMsg));
} else {
WindowAlert(Translate(l_cErrorMsg));
}
}
if (Ne(m_cLastWorkVarError,'')) {
SetControlFocus(m_cLastWorkVarError);
SetErrorField(m_cLastWorkVarError,true);
m_cLastWorkVarError='';
}
} else if (Ne(typeof('DisplayErrorMessage_'+m_cErrorInChild),'undefined')) {
DisplayErrorMessageOfChild(m_cErrorInChild);
}
}
function ResetErrorVars() {
m_nLastError=0;
m_cLastMsgError='';
m_cLastWorkVarError='';
m_cLastWorkVarErrorMsg='';
m_cErrorInChild='';
}
function EnableControlsUnderCondition() {
var l_bEnabled = true;
// * --- Area Manuale = UI - Enable Controls Init
// * --- Fine Area Manuale
if (Ne(typeof(tabs),'undefined')) {
tabs.CheckTabStrip();
}
DisableUI();
HideControlsUnderCondition();
ObligatoryControlsUnderCondition();
// * --- Area Manuale = UI - Enable Controls End
// * --- Fine Area Manuale
}
function ObligatoryControlsUnderCondition() {
var l_bObligatory = true;
}
function SetDynamicClasses() {
var c;
}
function SetDynamicTooltip() {
var c;
}
function SetSectionsHeight(id,m_nCurrentRow) {
}
function AdjustOnResize() {
var i = 0;
while (Lt(i,m_nRows)) {
i=i+1;
}
}
function InitVariables() {
}
function Set_password(ctrlValue,kmode,e) {
if (Ne(w_password,ctrlValue)) {
var ctl = _GetCtl(e,'UCCWMDWDFX');
if (_tracker.goon(ctl,ctrlValue)) {
w_password=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UCCWMDWDFX',0);
DoUpdate(l_bResult);
if(c=Ctrl('UCCWMDWDFX')) c.value = WtH(w_password,'C',10,0,'')
} else {
ctl.value=WtH('','C',10,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_logoperaz(ctrlValue,kmode,e) {
if (Ne(w_logoperaz,ctrlValue)) {
var ctl = _GetCtl(e,'BKGRSEWVYY');
if (_tracker.goon(ctl,ctrlValue)) {
w_logoperaz=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BKGRSEWVYY',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','M',10,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Calculate() {
var l_bTmpRes;
var l_bResult = true;
m_bCalculating=true;
// * --- Area Manuale = UI - Calculate
// * --- Fine Area Manuale
m_bCalculating=false;
}
function SaveDependsOn() {
}
function SaveLabelDependsOn() {
}
function SendData(formaction,url,data) {
if (Eq(m_bAlreadySubmitted,true)) {
WindowAlert(Translate('MSG_SERVER_DATA'));
return;
}
var Frm = document.FSender;
var bResult = true;
if (Eq(formaction,'discard')) {
return;
}
if ((Ne(formaction,'next') && Ne(formaction,'previous') && Ne(formaction,'save')) || CheckRow()) {
SubmitForm(formaction,url,data);
} else {
DoUpdate(false);
}
}
function Check() {
var l_bResult = true;
ResetErrorVars();
m_nLastError=0;
if ( ! (_ChkObl('UCCWMDWDFX',1))) {
_SignErr('UCCWMDWDFX');
m_cLastWorkVarErrorMsg='password';
l_bResult=false;
w_password=HtW('','C');
} else if ( ! (_ChkObl('BKGRSEWVYY',1))) {
_SignErr('BKGRSEWVYY');
m_cLastWorkVarErrorMsg='logoperaz';
l_bResult=false;
w_logoperaz=HtW('','M');
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
return -1;
}
function link_url(index) {
var l_oWv;
}
function FillWv() {
var l_oWv = InitWvApplet();
l_oWv.setValue('password',WtA(w_password,'C'));
l_oWv.setValue('logoperaz',WtA(w_logoperaz,'M'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["password","logoperaz"];
function SetModified(bRepeated) {
m_bUpdated=true;
if (bRepeated) {
if (Le(m_nCurrentRow,m_oTrsFW.length)) {
m_nRowStatus=1;
}
}
}
function initNoLocalVars(start,pseq) {
if (IsWndAccessible(opener)) {
if (start) {
if (Empty(w_password) && Ne(opener.w_password,null)) {
TransferBetweenWindows(opener,'w_password',null,'Set_password');
}
if (Empty(w_logoperaz) && Ne(opener.w_logoperaz,null)) {
TransferBetweenWindows(opener,'w_logoperaz',null,'Set_logoperaz');
}
}
}
m_bCalculating=true;
m_bCalculating=false;
SaveDependsOn();
SetControlsValue();
EnableControlsUnderCondition();
SaveLabelDependsOn();
DoUpdate(true);
var l_oCaller;
if (IsWndAccessible(l_oCaller)) {
var xAccessErr; try{l_oCaller.Ctrl;}catch(e){xAccessErr=1;} //IE security access error
if ( ! (xAccessErr) && Ne(typeof(l_oCaller.Ctrl),'undefined') && Ne(l_oCaller.Ctrl('FSender'),null) && Ne(typeof(l_oCaller.Ctrl('FSender').m_cOldCPCCCHK),'undefined')) {
m_cCPCCCHK=l_oCaller.Ctrl('FSender').m_cOldCPCCCHK.value;
}
}
}
function CheckRow() {
var l_bResult = true;
ResetErrorVars();
if (Lt(m_nCurrentRow,m_nRows)) {
}
return l_bResult;
}
_Obli('password',0,'UCCWMDWDFX',false)
_Obli('logoperaz',0,'BKGRSEWVYY',false)
