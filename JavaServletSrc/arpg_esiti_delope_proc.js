function SetControlsValue() {
var c;
var c;
if(c=Ctrl('ZFBIYQMSFL')) c.value = WtH(w_nomefile,'C',100,0,'')
if(c=Ctrl('OUJUYXLCZS')) selectRadio(c,w_scelta,'N')
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
if (Eq(w_okstampe,0)) {
UploadDoc()
}
}
function PIRPTHHLHK_Click() {
if (Eq(w_okstampe,0)) {
SetLocationHref(null,'arrt_imp_esiti'+'?m_cAction=start&m_cMode=hyperlink','elaborazione')
}
}
function TSSKBHVZYW_Click() {
if (Eq(w_okstampe,1)) {
_modifyandopen('arrt_lancia_stpesito_semplice'+'?m_cAction=start&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes,height=600,width=800',null)
}
}
function OHDUQNORCW_Click() {
if (Eq(w_okstampe,1)) {
_modifyandopen('arrt_esito_dettagliato_report'+'?m_cAction=start&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes,height=600,width=800',null)
}
}
function UJRAAPSKEB_Click() {
if (Eq(w_okstampe,1)) {
DeleteAE()
}
}
function OUJUYXLCZS_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_scelta(HtW(getRadioValue(Ctrl('OUJUYXLCZS')),'N'),null,e);
}
function XWGVSPAUBF_Click() {
if (Eq(w_okstampe,1)) {
_modifyandopen('arrt_esitixls'+'?m_cAction=start&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes,height=600,width=800',null)
}
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
c=Ctrl('OUJUYXLCZS');
if ( ! (Empty(c))) {
c[0].onclick=OUJUYXLCZS_Valid;
c[1].onclick=OUJUYXLCZS_Valid;
}
}
}
function NotifyEvent(p_cEvent) {
var old_c;
if (Ne(typeof(w_Messaggi),'undefined')) {
w_Messaggi.raiseEvent('arpg_esiti_delope_'+Strtran(p_cEvent,' ','_'));
}
if (Ne(typeof(w_Log),'undefined')) {
w_Log.raiseEvent('arpg_esiti_delope_'+Strtran(p_cEvent,' ','_'));
}
if (Ne(typeof(w_ListaFile),'undefined')) {
w_ListaFile.raiseEvent('arpg_esiti_delope_'+Strtran(p_cEvent,' ','_'));
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
FocusFirstComponent.otherwise={"page_1":["DZUBEERBGN","PIRPTHHLHK","TSSKBHVZYW","OHDUQNORCW","UJRAAPSKEB","OUJUYXLCZS","XWGVSPAUBF"]};
function Help() {
windowOpenForeground('../doc/arpg_esiti_delope_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_scelta=a[1];
w_impzip=a[2];
w_gMsgImp=a[3];
w_okstampe=a[4];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_esiti_delope',m_cSelectedPage);
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
l_bEnabled= ! (Eq(w_okstampe,0));
SetDisabled(Ctrl('DZUBEERBGN'),l_bEnabled);
l_bEnabled= ! (Eq(w_okstampe,0));
SetDisabled(Ctrl('PIRPTHHLHK'),l_bEnabled);
l_bEnabled= ! (Eq(w_okstampe,1));
SetDisabled(Ctrl('TSSKBHVZYW'),l_bEnabled);
l_bEnabled= ! (Eq(w_okstampe,1));
SetDisabled(Ctrl('OHDUQNORCW'),l_bEnabled);
l_bEnabled= ! (Eq(w_okstampe,1));
SetDisabled(Ctrl('UJRAAPSKEB'),l_bEnabled);
l_bEnabled= ! (Eq(w_okstampe,0)) || IsDisabledByStateDriver('scelta');
SetDisabled('OUJUYXLCZS_DIV',l_bEnabled);
l_bEnabled= ! (Eq(w_okstampe,1));
SetDisabled(Ctrl('XWGVSPAUBF'),l_bEnabled);
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
function Set_scelta(ctrlValue,kmode,e) {
if (Ne(w_scelta,ctrlValue)) {
var ctl = _GetCtl(e,'OUJUYXLCZS');
if (_tracker.goon(ctl,ctrlValue)) {
w_scelta=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('OUJUYXLCZS',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','N',1,0,'');
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
w_okstampe=arfn_gokprintesiti();
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
if ((Eq(w_okstampe,0)) && ( ! (_ChkObl('OUJUYXLCZS',1)))) {
_SignErr('OUJUYXLCZS');
m_cLastWorkVarErrorMsg='1153821500';
l_bResult=false;
w_scelta=HtW('','N');
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
l_oWv.setValue('scelta',WtA(w_scelta,'N'));
l_oWv.setValue('impzip',WtA(w_impzip,'N'));
l_oWv.setValue('gMsgImp',WtA(w_gMsgImp,'C'));
l_oWv.setValue('okstampe',WtA(w_okstampe,'N'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["nomefile","scelta","impzip","gMsgImp","okstampe"];
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
if (start && Eq(At(',scelta,',pseq),0)) {
w_scelta=1;
}
if (start && Eq(At(',impzip,',pseq),0)) {
w_impzip=0;
}
w_okstampe=arfn_gokprintesiti();
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
_Obli('scelta',1,'OUJUYXLCZS',false,"1153821500")
