function SetControlsValue() {
var c;
var c;
var tmp_FGMOCXNBFY = ToHTag(AsControlValue('<iframe width=\'655\' height=\'170\' id=\'elaborazione\'  name=\'elaborazione\' frameborder=\'1\'  border=\'1\' align=\'TOP\' marginwidth=\'1\' marginheight=\'1\'></iframe>'));
if (Ne(e_FGMOCXNBFY,tmp_FGMOCXNBFY)) {
if(c=Ctrl('FGMOCXNBFY')) c.innerHTML=tmp_FGMOCXNBFY;
e_FGMOCXNBFY=tmp_FGMOCXNBFY;
}
if(c=Ctrl('GTMJENMCMN')) c.value = WtH(w_anno,'N',4,0,'')
if(c=Ctrl('TCZMCNHUFI')) selectCombo(c,w_mese,'C')
if(c=Ctrl('FSXHJAAZGG')) c.value = WtH(w_dadata,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('CLVVMIYSQG')) c.value = WtH(w_a_data,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay('XLVFHSOSYH_DIV',IsHiddenByStateDriver('FB'));
SetDisplay(Ctrl('FGMOCXNBFY'),true);
HideUI();
}
HideUI.lblids["a_data"]=['LFJQIXRRKM'];
HideUI.lblids["anno"]=['YIXZTOKOBR'];
HideUI.lblids["dadata"]=['NOYEUIKFXN'];
function ExpandCollapseBoxesUnderCondition() {
var cond;
}
function href_PTXYMSWBZO() {
SetLocationHref(window.location,ToResource('jsp/start_page_logo_portlet.jsp'+'')+'')
}
function href_RXPIEFSABT() {
SetLocationHref(null,'arrt_azzera_invii_opex'+'?m_cAction=start&m_cMode=hyperlink','elaborazione')
}
function GTMJENMCMN_Valid(e) {
SetActiveField(Ctrl('GTMJENMCMN'),false);
e=(Ne(e,null)?e:window.event);
return Set_anno(HtW(Ctrl('GTMJENMCMN').value,'N'),null,e);
}
function GTMJENMCMN_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('GTMJENMCMN'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('GTMJENMCMN'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('GTMJENMCMN'),e);
}
function TCZMCNHUFI_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_mese(HtW(getComboValue(Ctrl('TCZMCNHUFI')),'C'),null,e);
}
function TCZMCNHUFI_OnFocus(e) {
SetActiveField(Ctrl('TCZMCNHUFI'),true);
}
function TCZMCNHUFI_OnBlur(e) {
SetActiveField(Ctrl('TCZMCNHUFI'),false);
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
if(c=Ctrl('GTMJENMCMN')) c.onblur=GTMJENMCMN_Valid;
if(c=Ctrl('GTMJENMCMN')) c.onfocus=GTMJENMCMN_OnFocus;
if(c=Ctrl('GTMJENMCMN')) c.onkeypress=CheckNum;
if(c=Ctrl('TCZMCNHUFI')) c.onchange=TCZMCNHUFI_Valid;
if(c=Ctrl('TCZMCNHUFI')) c.onfocus=TCZMCNHUFI_OnFocus;
if(c=Ctrl('TCZMCNHUFI')) c.onblur=TCZMCNHUFI_OnBlur;
}
}
function NotifyEvent(p_cEvent) {
var old_c;
if (Ne(typeof(w_Messaggi),'undefined')) {
w_Messaggi.raiseEvent('arpg_azzera_invii_opex_'+Strtran(p_cEvent,' ','_'));
}
if (Ne(typeof(w_Log),'undefined')) {
w_Log.raiseEvent('arpg_azzera_invii_opex_'+Strtran(p_cEvent,' ','_'));
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
FocusFirstComponent.otherwise={"page_1":["GTMJENMCMN"]};
function Help() {
windowOpenForeground('../doc/arpg_azzera_invii_opex_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
}
function CalledBatchEnd() {
if ( ! (m_bCalculating)) {
DoUpdate(true);
}
}
function LoadChildrenInPage(page,lazy) {
}
GetLayerID.Layers.push({"id":"XLVFHSOSYH","name":"FB"});
function DeclareWVs() {
var a = arguments;
w_anno=a[0];
w_mese=a[1];
w_dadata=a[2];
w_a_data=a[3];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_azzera_invii_opex',m_cSelectedPage);
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
if (IsDisabledByStateDriver('FB')) {
DisableInputsInContainer(Ctrl('XLVFHSOSYH'),true);
}
DisableUI();
HideControlsUnderCondition();
ObligatoryControlsUnderCondition();
ExpandCollapseBoxesUnderCondition();
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
function Set_anno(ctrlValue,kmode,e) {
if (Ne(w_anno,ctrlValue)) {
var ctl = _GetCtl(e,'GTMJENMCMN');
if (_tracker.goon(ctl,ctrlValue)) {
w_anno=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('GTMJENMCMN',0);
if (l_bResult) {
l_bResult=Ge(w_anno,2008);
if ( ! (l_bResult)) {
m_nLastError=2;
m_cLastWorkVarErrorMsg='anno';
m_cLastMsgError=AlertErrorMessage('369093584');
}
if ( ! (l_bResult)) {
w_anno=HtW('','N');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'N',4,0,''));
} else {
_ResetTracker();
}
return l_bResult;
} else {
ctl.value=WtH('','N',4,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_mese(ctrlValue,kmode,e) {
if (Ne(w_mese,ctrlValue)) {
var ctl = _GetCtl(e,'TCZMCNHUFI');
if (_tracker.goon(ctl,ctrlValue)) {
w_mese=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('TCZMCNHUFI',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',2,0,'');
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
w_dadata=( ! (Empty(w_anno)) &&  ! (Empty(w_mese))?CharToDate(Str(w_anno,4,0)+w_mese+'01'):NullDate());
w_a_data=arfn_finemese(w_dadata);
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
if (( ! (_ChkObl('GTMJENMCMN',1))) || ( ! (Ge(w_anno,2008)))) {
_SignErr('GTMJENMCMN','369093584');
l_bResult=false;
w_anno=HtW('','N');
} else if ( ! (_ChkObl('TCZMCNHUFI',1))) {
_SignErr('TCZMCNHUFI');
m_cLastWorkVarErrorMsg='mese';
l_bResult=false;
w_mese=HtW('','C');
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
l_oWv.setValue('anno',WtA(w_anno,'N'));
l_oWv.setValue('mese',WtA(w_mese,'C'));
l_oWv.setValue('dadata',WtA(w_dadata,'D'));
l_oWv.setValue('a_data',WtA(w_a_data,'D'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["anno","mese","dadata","a_data"];
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
if (start && Eq(At(',anno,',pseq),0)) {
w_anno=Year(SystemDate());
}
w_dadata=( ! (Empty(w_anno)) &&  ! (Empty(w_mese))?CharToDate(Str(w_anno,4,0)+w_mese+'01'):NullDate());
w_a_data=arfn_finemese(w_dadata);
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
_Obli('anno',1,'GTMJENMCMN',false)
_Obli('mese',0,'TCZMCNHUFI',true)
