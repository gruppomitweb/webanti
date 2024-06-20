function SetControlsValue() {
var c;
var c;
var tmp_FGMOCXNBFY = ToHTag(AsControlValue('<iframe width=\'655\' height=\'170\' id=\'elaborazione\'  name=\'elaborazione\' frameborder=\'1\'  border=\'1\' align=\'TOP\' marginwidth=\'1\' marginheight=\'1\'></iframe>'));
if (Ne(e_FGMOCXNBFY,tmp_FGMOCXNBFY)) {
if(c=Ctrl('FGMOCXNBFY')) c.innerHTML=tmp_FGMOCXNBFY;
e_FGMOCXNBFY=tmp_FGMOCXNBFY;
}
var tmp_SSRCOAMDBL = ToHTag(AsControlValue('<iframe width=\'610\' height=\'155\' id =\'messaggi\' src=\'arpg_msg_import\' frameborder=\'1\'  border=\'1\' align=\'TOP\' marginwidth=\'1\' marginheight=\'1\'></iframe>'));
if (Ne(e_SSRCOAMDBL,tmp_SSRCOAMDBL)) {
if(c=Ctrl('SSRCOAMDBL')) c.innerHTML=tmp_SSRCOAMDBL;
e_SSRCOAMDBL=tmp_SSRCOAMDBL;
}
if(c=Ctrl('VFNQNKHTLJ')) ChkboxCheckUncheck(c,'S',w_flgoef)
if(c=Ctrl('VFNQNKHTLJ')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('SBCHFGLAIB')) ChkboxCheckUncheck(c,'S',w_flgoag)
if(c=Ctrl('SBCHFGLAIB')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('IHBYEERYKY')) ChkboxCheckUncheck(c,'S',w_flgdel)
if(c=Ctrl('IHBYEERYKY')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay(Ctrl('FGMOCXNBFY'),true);
HideUI();
}
function href_XURLGQZZMU() {
SetLocationHref(null,'arrt_opex_massa'+'?m_cAction=start&m_cMode=hyperlink','elaborazione')
}
function href_PTXYMSWBZO() {
SetLocationHref(window.location,ToResource('jsp/start_page_logo_portlet.jsp'+'')+'')
}
function VFNQNKHTLJ_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_flgoef(ChkboxValueAssign(Ctrl('VFNQNKHTLJ'),'S','N','C',1,0,''),null,e);
}
function VFNQNKHTLJ_OnFocus(e) {
SetActiveField(Ctrl('VFNQNKHTLJ'),true);
}
function VFNQNKHTLJ_OnBlur(e) {
SetActiveField(Ctrl('VFNQNKHTLJ'),false);
}
function SBCHFGLAIB_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_flgoag(ChkboxValueAssign(Ctrl('SBCHFGLAIB'),'S','N','C',1,0,''),null,e);
}
function SBCHFGLAIB_OnFocus(e) {
SetActiveField(Ctrl('SBCHFGLAIB'),true);
}
function SBCHFGLAIB_OnBlur(e) {
SetActiveField(Ctrl('SBCHFGLAIB'),false);
}
function IHBYEERYKY_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_flgdel(ChkboxValueAssign(Ctrl('IHBYEERYKY'),'S','N','C',1,0,''),null,e);
}
function IHBYEERYKY_OnFocus(e) {
SetActiveField(Ctrl('IHBYEERYKY'),true);
}
function IHBYEERYKY_OnBlur(e) {
SetActiveField(Ctrl('IHBYEERYKY'),false);
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
if(c=Ctrl('VFNQNKHTLJ')) c.onclick=VFNQNKHTLJ_Valid;
if(c=Ctrl('VFNQNKHTLJ')) c.onfocus=VFNQNKHTLJ_OnFocus;
if(c=Ctrl('VFNQNKHTLJ')) c.onblur=VFNQNKHTLJ_OnBlur;
if(c=Ctrl('SBCHFGLAIB')) c.onclick=SBCHFGLAIB_Valid;
if(c=Ctrl('SBCHFGLAIB')) c.onfocus=SBCHFGLAIB_OnFocus;
if(c=Ctrl('SBCHFGLAIB')) c.onblur=SBCHFGLAIB_OnBlur;
if(c=Ctrl('IHBYEERYKY')) c.onclick=IHBYEERYKY_Valid;
if(c=Ctrl('IHBYEERYKY')) c.onfocus=IHBYEERYKY_OnFocus;
if(c=Ctrl('IHBYEERYKY')) c.onblur=IHBYEERYKY_OnBlur;
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
FocusFirstComponent.otherwise={"page_1":["VFNQNKHTLJ"]};
function Help() {
windowOpenForeground('../doc/arpg_opex_massa_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_flgoef=a[0];
w_flgoag=a[1];
w_flgdel=a[2];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_opex_massa',m_cSelectedPage);
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
function Set_flgoef(ctrlValue,kmode,e) {
if (Ne(w_flgoef,ctrlValue)) {
var ctl = _GetCtl(e,'VFNQNKHTLJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_flgoef=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VFNQNKHTLJ',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_flgoag(ctrlValue,kmode,e) {
if (Ne(w_flgoag,ctrlValue)) {
var ctl = _GetCtl(e,'SBCHFGLAIB');
if (_tracker.goon(ctl,ctrlValue)) {
w_flgoag=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SBCHFGLAIB',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_flgdel(ctrlValue,kmode,e) {
if (Ne(w_flgdel,ctrlValue)) {
var ctl = _GetCtl(e,'IHBYEERYKY');
if (_tracker.goon(ctl,ctrlValue)) {
w_flgdel=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('IHBYEERYKY',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
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
if ( ! (_ChkObl('VFNQNKHTLJ',1))) {
_SignErr('VFNQNKHTLJ');
m_cLastWorkVarErrorMsg='flgoef';
l_bResult=false;
w_flgoef='N';
} else if ( ! (_ChkObl('SBCHFGLAIB',1))) {
_SignErr('SBCHFGLAIB');
m_cLastWorkVarErrorMsg='flgoag';
l_bResult=false;
w_flgoag='N';
} else if ( ! (_ChkObl('IHBYEERYKY',1))) {
_SignErr('IHBYEERYKY');
m_cLastWorkVarErrorMsg='flgdel';
l_bResult=false;
w_flgdel='N';
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
l_oWv.setValue('flgoef',WtA(w_flgoef,'C'));
l_oWv.setValue('flgoag',WtA(w_flgoag,'C'));
l_oWv.setValue('flgdel',WtA(w_flgdel,'C'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["flgoef","flgoag","flgdel"];
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
if (start && Eq(At(',flgoef,',pseq),0)) {
w_flgoef='S';
}
if (start && Eq(At(',flgoag,',pseq),0)) {
w_flgoag='S';
}
if (start && Eq(At(',flgdel,',pseq),0)) {
w_flgdel='N';
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
_Obli('flgoef',0,'VFNQNKHTLJ',false)
_Obli('flgoag',0,'SBCHFGLAIB',false)
_Obli('flgdel',0,'IHBYEERYKY',false)
