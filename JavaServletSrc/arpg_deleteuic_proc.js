function SetControlsValue() {
var c;
var c;
if(c=Ctrl('QHXVBCMDEB')) selectCombo(c,w_tipocr,'C')
if(c=Ctrl('KAGRBEILOC')) c.value = WtH(w_codcr,'C',11,0,'')
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
HideUI();
}
HideUI.lblids["codcr"]=['BBAELHURCV'];
HideUI.lblids["tipocr"]=['INZZSZTBRT'];
function QHXVBCMDEB_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_tipocr(HtW(getComboValue(Ctrl('QHXVBCMDEB')),'C'),null,e);
}
function QHXVBCMDEB_OnFocus(e) {
SetActiveField(Ctrl('QHXVBCMDEB'),true);
}
function QHXVBCMDEB_OnBlur(e) {
SetActiveField(Ctrl('QHXVBCMDEB'),false);
}
function KAGRBEILOC_Valid(e) {
SetActiveField(Ctrl('KAGRBEILOC'),false);
e=(Ne(e,null)?e:window.event);
return Set_codcr(HtW(Ctrl('KAGRBEILOC').value,'C'),null,e);
}
function KAGRBEILOC_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('KAGRBEILOC'))) {
DisplayErrorMessage();
}
if ( ! (GetDisabled('KAGRBEILOC'))) {
if (Eq(w_codcr,'') && Eq(_tracker.ctrl,null)) {
Ctrl('KAGRBEILOC').value=WtH(w_gIntemediario,'C',11,0,'');
} else {
}
}
SetActiveField(Ctrl('KAGRBEILOC'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('KAGRBEILOC'),e);
}
function href_ZQEKBHAOQV() {
var action = (Eq(Left('centrale'+''+'?',15),'arpg_deleteuic?')?'query':'start');
SetHypPar('m_cAction',AsAppletValue(action));
SetHypPar('m_cMode',AsAppletValue('hyperlink'));
SendData(action,'centrale'+'',HParApplet().asString());
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
if(c=Ctrl('QHXVBCMDEB')) c.onchange=QHXVBCMDEB_Valid;
if(c=Ctrl('QHXVBCMDEB')) c.onfocus=QHXVBCMDEB_OnFocus;
if(c=Ctrl('QHXVBCMDEB')) c.onblur=QHXVBCMDEB_OnBlur;
if(c=Ctrl('KAGRBEILOC')) c.onblur=KAGRBEILOC_Valid;
if(c=Ctrl('KAGRBEILOC')) c.onfocus=KAGRBEILOC_OnFocus;
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
FocusFirstComponent.otherwise={"page_1":["QHXVBCMDEB"]};
function Help() {
windowOpenForeground('../doc/arpg_deleteuic_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_tipocr=a[0];
w_codcr=a[1];
w_gIntemediario=a[2];
w_gTipInter=a[3];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_deleteuic',m_cSelectedPage);
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
function Set_tipocr(ctrlValue,kmode,e) {
if (Ne(w_tipocr,ctrlValue)) {
var ctl = _GetCtl(e,'QHXVBCMDEB');
if (_tracker.goon(ctl,ctrlValue)) {
w_tipocr=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QHXVBCMDEB',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',2,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_codcr(ctrlValue,kmode,e) {
if (Ne(w_codcr,ctrlValue)) {
var ctl = _GetCtl(e,'KAGRBEILOC');
if (_tracker.goon(ctl,ctrlValue)) {
w_codcr=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('KAGRBEILOC',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',11,0,'');
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
if ( ! (_ChkObl('QHXVBCMDEB',1))) {
_SignErr('QHXVBCMDEB');
m_cLastWorkVarErrorMsg='tipocr';
l_bResult=false;
w_tipocr=HtW('','C');
} else if ( ! (_ChkObl('KAGRBEILOC',1))) {
_SignErr('KAGRBEILOC');
m_cLastWorkVarErrorMsg='codcr';
l_bResult=false;
w_codcr=HtW('','C');
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
l_oWv.setValue('tipocr',WtA(w_tipocr,'C'));
l_oWv.setValue('codcr',WtA(w_codcr,'C'));
l_oWv.setValue('gIntemediario',WtA(w_gIntemediario,'C'));
l_oWv.setValue('gTipInter',WtA(w_gTipInter,'C'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["tipocr","codcr","gIntemediario","gTipInter"];
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
if (Empty(w_tipocr) && Ne(opener.w_tipocr,null)) {
TransferBetweenWindows(opener,'w_tipocr',null,'Set_tipocr');
}
if (Empty(w_codcr) && Ne(opener.w_codcr,null)) {
TransferBetweenWindows(opener,'w_codcr',null,'Set_codcr');
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
_Obli('tipocr',0,'QHXVBCMDEB',false)
_Obli('codcr',0,'KAGRBEILOC',false)
