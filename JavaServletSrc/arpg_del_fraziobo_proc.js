function SetControlsValue() {
var c;
var c;
if(c=Ctrl('NTUZLPWVAD')) c.value = WtH(w_datavaria,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('ZVSDSSCUMM')) c.value = WtH(w_IDBASE,'C',10,0,'')
if(c=Ctrl('VFJTCKYERF')) c.value = WtH(w_STATO,'C',1,0,'')
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay(Ctrl('MNNQRQRGPV'),Eq(w_STATO,'2') || Eq(w_STATO,'3') || Empty(w_datavaria));
SetDisplay(Ctrl('ZVSDSSCUMM'),true || IsHiddenByStateDriver('IDBASE'));
SetDisplay(Ctrl('VFJTCKYERF'),true || IsHiddenByStateDriver('STATO'));
HideUI();
}
HideUI.lblids["datavaria"]=['QAXNTYELMN'];
function href_MNNQRQRGPV() {
if (false || WindowConfirm(Translate('10324430425'))) {
SetHypPar('m_cAction',AsAppletValue('start'));
SetHypPar('m_cMode',AsAppletValue('hyperlink'));
SetHypPar('w_IDBASE',AsAppletValue(w_IDBASE));
SetHypPar('w_datavaria',AsAppletValue(w_datavaria));
SetHypPar('m_cParameterSequence',AsAppletValue('w_IDBASE,w_datavaria'));
SetHypPar('m_cID',AsAppletValue(m_IDS['arrt_del_fraziobo']));
SendData('start','arrt_del_fraziobo'+'',HParApplet().asString());
}
}
function href_MQMNEIMSBN() {
window.close()
}
function ZVSDSSCUMM_Valid(e) {
SetActiveField(Ctrl('ZVSDSSCUMM'),false);
e=(Ne(e,null)?e:window.event);
return Set_IDBASE(HtW(Ctrl('ZVSDSSCUMM').value,'C'),null,e);
}
function ZVSDSSCUMM_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ZVSDSSCUMM'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('ZVSDSSCUMM'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ZVSDSSCUMM'),e);
}
function VFJTCKYERF_Valid(e) {
SetActiveField(Ctrl('VFJTCKYERF'),false);
e=(Ne(e,null)?e:window.event);
return Set_STATO(HtW(Ctrl('VFJTCKYERF').value,'C'),null,e);
}
function VFJTCKYERF_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('VFJTCKYERF'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('VFJTCKYERF'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('VFJTCKYERF'),e);
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
if(c=Ctrl('ZVSDSSCUMM')) c.onblur=ZVSDSSCUMM_Valid;
if(c=Ctrl('ZVSDSSCUMM')) c.onfocus=ZVSDSSCUMM_OnFocus;
if(c=Ctrl('VFJTCKYERF')) c.onblur=VFJTCKYERF_Valid;
if(c=Ctrl('VFJTCKYERF')) c.onfocus=VFJTCKYERF_OnFocus;
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
FocusFirstComponent.otherwise={};
function Help() {
windowOpenForeground('../doc/arpg_del_fraziobo_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_datavaria=a[0];
w_IDBASE=a[1];
w_STATO=a[2];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_del_fraziobo',m_cSelectedPage);
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
function Set_IDBASE(ctrlValue,kmode,e) {
if (Ne(w_IDBASE,ctrlValue)) {
var ctl = _GetCtl(e,'ZVSDSSCUMM');
if (_tracker.goon(ctl,ctrlValue)) {
w_IDBASE=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ZVSDSSCUMM',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',10,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_STATO(ctrlValue,kmode,e) {
if (Ne(w_STATO,ctrlValue)) {
var ctl = _GetCtl(e,'VFJTCKYERF');
if (_tracker.goon(ctl,ctrlValue)) {
w_STATO=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VFJTCKYERF',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',1,0,'');
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
w_datavaria=SystemDate();
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
if ( ! (_ChkObl('ZVSDSSCUMM',1))) {
_SignErr('ZVSDSSCUMM');
m_cLastWorkVarErrorMsg='IDBASE';
l_bResult=false;
w_IDBASE=HtW('','C');
} else if ( ! (_ChkObl('VFJTCKYERF',1))) {
_SignErr('VFJTCKYERF');
m_cLastWorkVarErrorMsg='STATO';
l_bResult=false;
w_STATO=HtW('','C');
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
l_oWv.setValue('datavaria',WtA(w_datavaria,'D'));
l_oWv.setValue('IDBASE',WtA(w_IDBASE,'C'));
l_oWv.setValue('STATO',WtA(w_STATO,'C'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["datavaria","IDBASE","STATO"];
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
if (Empty(w_IDBASE) && Ne(opener.w_IDBASE,null)) {
TransferBetweenWindows(opener,'w_IDBASE',null,'Set_IDBASE');
}
if (Empty(w_STATO) && Ne(opener.w_STATO,null)) {
TransferBetweenWindows(opener,'w_STATO',null,'Set_STATO');
}
}
}
m_bCalculating=true;
w_datavaria=SystemDate();
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
_Obli('IDBASE',0,'ZVSDSSCUMM',false)
_Obli('STATO',0,'VFJTCKYERF',false)
