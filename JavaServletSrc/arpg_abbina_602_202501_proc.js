function SetControlsValue() {
var c;
var c;
var tmp_FGMOCXNBFY = ToHTag(AsControlValue('<iframe width=\'655\' height=\'170\' id=\'elaborazione\'  name=\'elaborazione\' frameborder=\'1\'  border=\'1\' align=\'TOP\' marginwidth=\'1\' marginheight=\'1\'></iframe>'));
if (Ne(e_FGMOCXNBFY,tmp_FGMOCXNBFY)) {
if(c=Ctrl('FGMOCXNBFY')) c.innerHTML=tmp_FGMOCXNBFY;
e_FGMOCXNBFY=tmp_FGMOCXNBFY;
}
if(c=Ctrl('OWQQKKVWKQ')) selectCombo(c,w_accuratezza,'C')
if(c=Ctrl('HSVLJUVEVY')) c.value = WtH(w_passwd,'C',10,0,'')
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay(Ctrl('FGMOCXNBFY'),true);
HideUI();
}
HideUI.lblids["accuratezza"]=['SESGYYXWKQ'];
HideUI.lblids["passwd"]=['DZPWKQWMKD'];
function href_XWPYHZIJDE() {
LanciaImport()
}
function href_JSKZJOHJOM() {
SetLocationHref(window.location,ToResource('jsp/start_page_logo_portlet.jsp'+'')+'')
}
function OWQQKKVWKQ_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_accuratezza(HtW(getComboValue(Ctrl('OWQQKKVWKQ')),'C'),null,e);
}
function OWQQKKVWKQ_OnFocus(e) {
SetActiveField(Ctrl('OWQQKKVWKQ'),true);
}
function OWQQKKVWKQ_OnBlur(e) {
SetActiveField(Ctrl('OWQQKKVWKQ'),false);
}
function CALYSHTISV_Click() {
if (Eq(CriptoLibrary.MD5(Upper(LRTrim(w_passwd))),'60383834212f741dc6bdc0e21f067b26')) {
Recupera()
}
}
function HSVLJUVEVY_Valid(e) {
SetActiveField(Ctrl('HSVLJUVEVY'),false);
e=(Ne(e,null)?e:window.event);
return Set_passwd(HtW(Ctrl('HSVLJUVEVY').value,'C'),null,e);
}
function HSVLJUVEVY_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('HSVLJUVEVY'))) {
DisplayErrorMessage();
}
Ctrl('HSVLJUVEVY').value=WtH(w_passwd,'C',10,0,'');
SetActiveField(Ctrl('HSVLJUVEVY'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('HSVLJUVEVY'),e);
}
function HSVLJUVEVY_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("*"));
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
if(c=Ctrl('OWQQKKVWKQ')) c.onchange=OWQQKKVWKQ_Valid;
if(c=Ctrl('OWQQKKVWKQ')) c.onfocus=OWQQKKVWKQ_OnFocus;
if(c=Ctrl('OWQQKKVWKQ')) c.onblur=OWQQKKVWKQ_OnBlur;
if(c=Ctrl('HSVLJUVEVY')) c.onblur=HSVLJUVEVY_Valid;
if(c=Ctrl('HSVLJUVEVY')) c.onfocus=HSVLJUVEVY_OnFocus;
}
}
function NotifyEvent(p_cEvent) {
var old_c;
if (Ne(typeof(w_Log),'undefined')) {
w_Log.raiseEvent('arpg_abbina_602_202501_'+Strtran(p_cEvent,' ','_'));
}
if (Ne(typeof(w_AUI),'undefined')) {
w_AUI.raiseEvent('arpg_abbina_602_202501_'+Strtran(p_cEvent,' ','_'));
}
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
FocusFirstComponent.otherwise={"page_1":["OWQQKKVWKQ"]};
function Help() {
windowOpenForeground('../doc/arpg_abbina_602_202501_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_impzip=a[0];
w_errchk=a[1];
w_gTelepass=a[2];
w_gFlgCMod=a[3];
w_xMADESCRI=a[4];
w_xMAFLGRAP=a[5];
w_xMAFLGBON=a[6];
w_xMAFLGCKR=a[7];
w_xMAFLGASR=a[8];
w_accuratezza=a[9];
w_passwd=a[10];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_abbina_602_202501',m_cSelectedPage);
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
l_bEnabled= ! (Eq(CriptoLibrary.MD5(Upper(LRTrim(w_passwd))),'60383834212f741dc6bdc0e21f067b26'));
SetDisabled(Ctrl('CALYSHTISV'),l_bEnabled);
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
function Set_passwd(ctrlValue,kmode,e) {
if (Ne(w_passwd,ctrlValue)) {
var ctl = _GetCtl(e,'HSVLJUVEVY');
if (_tracker.goon(ctl,ctrlValue)) {
w_passwd=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HSVLJUVEVY',0);
DoUpdate(l_bResult);
if(c=Ctrl('HSVLJUVEVY')) c.value = WtH(w_passwd,'C',10,0,'')
} else {
ctl.value=WtH('','C',10,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_accuratezza(ctrlValue,kmode,e) {
if (Ne(w_accuratezza,ctrlValue)) {
var ctl = _GetCtl(e,'OWQQKKVWKQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_accuratezza=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('OWQQKKVWKQ',0);
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
if ( ! (_ChkObl('OWQQKKVWKQ',1))) {
_SignErr('OWQQKKVWKQ');
m_cLastWorkVarErrorMsg='10896916853';
l_bResult=false;
w_accuratezza=HtW('','C');
} else if ( ! (_ChkObl('HSVLJUVEVY',1))) {
_SignErr('HSVLJUVEVY');
m_cLastWorkVarErrorMsg='11183930016';
l_bResult=false;
w_passwd=HtW('','C');
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
l_oWv.setValue('impzip',WtA(w_impzip,'N'));
l_oWv.setValue('errchk',WtA(w_errchk,'N'));
l_oWv.setValue('gTelepass',WtA(w_gTelepass,'C'));
l_oWv.setValue('gFlgCMod',WtA(w_gFlgCMod,'C'));
l_oWv.setValue('xMADESCRI',WtA(w_xMADESCRI,'C'));
l_oWv.setValue('xMAFLGRAP',WtA(w_xMAFLGRAP,'C'));
l_oWv.setValue('xMAFLGBON',WtA(w_xMAFLGBON,'C'));
l_oWv.setValue('xMAFLGCKR',WtA(w_xMAFLGCKR,'C'));
l_oWv.setValue('xMAFLGASR',WtA(w_xMAFLGASR,'C'));
l_oWv.setValue('accuratezza',WtA(w_accuratezza,'C'));
l_oWv.setValue('passwd',WtA(w_passwd,'C'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["impzip","errchk","gTelepass","gFlgCMod","xMADESCRI","xMAFLGRAP","xMAFLGBON","xMAFLGCKR","xMAFLGASR","accuratezza","passwd"];
function SetModified(bRepeated) {
m_bUpdated=true;
if (bRepeated) {
if (Le(m_nCurrentRow,m_oTrsFW.length)) {
m_nRowStatus=1;
}
}
}
function initNoLocalVars(start,pseq) {
m_bCalculating=true;
if (start && Eq(At(',impzip,',pseq),0)) {
w_impzip=0;
}
if (start && Eq(At(',errchk,',pseq),0)) {
w_errchk=0;
}
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
_Obli('passwd',0,'HSVLJUVEVY',false,"11183930016")
_Obli('accuratezza',0,'OWQQKKVWKQ',false,"10896916853")
