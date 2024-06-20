function SetControlsValue() {
var c;
var c;
if(c=Ctrl('NTUZLPWVAD')) c.value = WtH(w_datavaria,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('ZVSDSSCUMM')) c.value = WtH(w_CONNES,'C',16,0,'')
if(c=Ctrl('MVYVCPDYUF')) c.value = WtH(w_TIPO,'C',1,0,'')
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay(Ctrl('MNNQRQRGPV'),Empty(w_datavaria));
SetDisplay(Ctrl('ZVSDSSCUMM'),Eq(1,1) || IsHiddenByStateDriver('CONNES'));
SetDisplay(Ctrl('MVYVCPDYUF'),Eq(1,1) || IsHiddenByStateDriver('TIPO'));
HideUI();
}
HideUI.lblids["datavaria"]=['QAXNTYELMN'];
function href_MNNQRQRGPV() {
SetHypPar('m_cAction',AsAppletValue('start'));
SetHypPar('m_cMode',AsAppletValue('hyperlink'));
SetHypPar('m_cID',AsAppletValue(m_IDS['arrt_edt_personbo']));
SendData('start','arrt_edt_personbo'+'',HParApplet().asString());
}
function href_MQMNEIMSBN() {
window.close()
}
function ZVSDSSCUMM_Valid(e) {
SetActiveField(Ctrl('ZVSDSSCUMM'),false);
e=(Ne(e,null)?e:window.event);
return Set_CONNES(HtW(Ctrl('ZVSDSSCUMM').value,'C'),null,e);
}
function ZVSDSSCUMM_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ZVSDSSCUMM'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('ZVSDSSCUMM'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ZVSDSSCUMM'),e);
}
function MVYVCPDYUF_Valid(e) {
SetActiveField(Ctrl('MVYVCPDYUF'),false);
e=(Ne(e,null)?e:window.event);
return Set_TIPO(HtW(Ctrl('MVYVCPDYUF').value,'C'),null,e);
}
function MVYVCPDYUF_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('MVYVCPDYUF'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('MVYVCPDYUF'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('MVYVCPDYUF'),e);
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
if(c=Ctrl('ZVSDSSCUMM')) c.onblur=ZVSDSSCUMM_Valid;
if(c=Ctrl('ZVSDSSCUMM')) c.onfocus=ZVSDSSCUMM_OnFocus;
if(c=Ctrl('MVYVCPDYUF')) c.onblur=MVYVCPDYUF_Valid;
if(c=Ctrl('MVYVCPDYUF')) c.onfocus=MVYVCPDYUF_OnFocus;
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
windowOpenForeground('../doc/arpg_edt_personbo_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_CONNES=a[1];
w_TIPO=a[2];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_edt_personbo',m_cSelectedPage);
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
function Set_CONNES(ctrlValue,kmode,e) {
if (Ne(w_CONNES,ctrlValue)) {
var ctl = _GetCtl(e,'ZVSDSSCUMM');
if (_tracker.goon(ctl,ctrlValue)) {
w_CONNES=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ZVSDSSCUMM',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',16,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_TIPO(ctrlValue,kmode,e) {
if (Ne(w_TIPO,ctrlValue)) {
var ctl = _GetCtl(e,'MVYVCPDYUF');
if (_tracker.goon(ctl,ctrlValue)) {
w_TIPO=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MVYVCPDYUF',0);
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
m_cLastWorkVarErrorMsg='CONNES';
l_bResult=false;
w_CONNES=HtW('','C');
} else if ( ! (_ChkObl('MVYVCPDYUF',1))) {
_SignErr('MVYVCPDYUF');
m_cLastWorkVarErrorMsg='TIPO';
l_bResult=false;
w_TIPO=HtW('','C');
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
l_oWv.setValue('CONNES',WtA(w_CONNES,'C'));
l_oWv.setValue('TIPO',WtA(w_TIPO,'C'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["datavaria","CONNES","TIPO"];
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
if (Empty(w_CONNES) && Ne(opener.w_CONNES,null)) {
TransferBetweenWindows(opener,'w_CONNES',null,'Set_CONNES');
}
if (Empty(w_TIPO) && Ne(opener.w_TIPO,null)) {
TransferBetweenWindows(opener,'w_TIPO',null,'Set_TIPO');
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
_Obli('CONNES',0,'ZVSDSSCUMM',false)
_Obli('TIPO',0,'MVYVCPDYUF',false)
