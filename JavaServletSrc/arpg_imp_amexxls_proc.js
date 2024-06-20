function SetControlsValue() {
var c;
var c;
if(c=Ctrl('ZFBIYQMSFL')) c.value = WtH(w_nomefile,'C',100,0,'')
if(c=Ctrl('BESVSXEZBJ')) c.value = WtH(w_msgproc,'M',10,0,'')
var tmp_GORGDGDNGD = ToHTag(AsControlValue('<iframe width=\'655\' height=\'310\' id =\'informazioni\' name=\'informazioni\' src=\'../servlet/arpg_list_imprich?nomefile='+w_nomefile+'\''+' frameborder=\'1\'  border=\'1\' align=\'TOP\' marginwidth=\'1\' marginheight=\'1\'></iframe>'));
if (Ne(e_GORGDGDNGD,tmp_GORGDGDNGD)) {
if(c=Ctrl('GORGDGDNGD')) c.innerHTML=tmp_GORGDGDNGD;
e_GORGDGDNGD=tmp_GORGDGDNGD;
}
var tmp_SSRCOAMDBL = ToHTag(AsControlValue('<iframe width=\'776\' height=\'155\' id =\'messaggi\' src=\'arpg_msg_import\' frameborder=\'1\'  border=\'1\' align=\'TOP\' marginwidth=\'1\' marginheight=\'1\'></iframe>'));
if (Ne(e_SSRCOAMDBL,tmp_SSRCOAMDBL)) {
if(c=Ctrl('SSRCOAMDBL')) c.innerHTML=tmp_SSRCOAMDBL;
e_SSRCOAMDBL=tmp_SSRCOAMDBL;
}
var tmp_FGMOCXNBFY = ToHTag(AsControlValue('<iframe width=\'655\' height=\'170\' id=\'elaborazione\'  name=\'elaborazione\' frameborder=\'1\'  border=\'1\' align=\'TOP\' marginwidth=\'1\' marginheight=\'1\'></iframe>'));
if (Ne(e_FGMOCXNBFY,tmp_FGMOCXNBFY)) {
if(c=Ctrl('FGMOCXNBFY')) c.innerHTML=tmp_FGMOCXNBFY;
e_FGMOCXNBFY=tmp_FGMOCXNBFY;
}
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay(Ctrl('FGMOCXNBFY'),true);
HideUI();
}
function DZUBEERBGN_Click() {
UploadDoc()
}
function PIRPTHHLHK_Click() {
SetLocationHref(null,'arrt_imp_amexxls'+'?m_cAction=start&m_cMode=hyperlink','elaborazione')
}
function BESVSXEZBJ_Valid(e) {
SetActiveField(Ctrl('BESVSXEZBJ'),false);
e=(Ne(e,null)?e:window.event);
return Set_msgproc(HtW(Ctrl('BESVSXEZBJ').value,'M'),null,e);
}
function BESVSXEZBJ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('BESVSXEZBJ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('BESVSXEZBJ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('BESVSXEZBJ'),e);
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
if(c=Ctrl('BESVSXEZBJ')) c.onblur=BESVSXEZBJ_Valid;
if(c=Ctrl('BESVSXEZBJ')) c.onfocus=BESVSXEZBJ_OnFocus;
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
FocusFirstComponent.otherwise={"page_1":["DZUBEERBGN"]};
function Help() {
windowOpenForeground('../doc/arpg_imp_amexxls_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_nomefile=a[0];
w_msgproc=a[1];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_imp_amexxls',m_cSelectedPage);
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
l_bEnabled= ! (Ne(1,1)) || IsDisabledByStateDriver('msgproc');
SetDisabled(Ctrl('BESVSXEZBJ'),l_bEnabled);
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
function Set_msgproc(ctrlValue,kmode,e) {
if (Ne(w_msgproc,ctrlValue)) {
var ctl = _GetCtl(e,'BESVSXEZBJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_msgproc=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BESVSXEZBJ',0);
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
if ((Ne(1,1)) && ( ! (_ChkObl('BESVSXEZBJ',1)))) {
_SignErr('BESVSXEZBJ');
m_cLastWorkVarErrorMsg='msgproc';
l_bResult=false;
w_msgproc=HtW('','M');
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
l_oWv.setValue('nomefile',WtA(w_nomefile,'C'));
l_oWv.setValue('msgproc',WtA(w_msgproc,'M'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["nomefile","msgproc"];
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
_Obli('msgproc',0,'BESVSXEZBJ',false)
