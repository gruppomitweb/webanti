function SetControlsValue() {
var c;
var c;
if(c=Ctrl('ZFBIYQMSFL')) c.value = WtH(w_nomefile,'C',100,0,'')
var tmp_FGMOCXNBFY = ToHTag(AsControlValue('<iframe width=\'655\' height=\'170\' id=\'elaborazione\'  name=\'elaborazione\' frameborder=\'1\'  border=\'1\' align=\'TOP\' marginwidth=\'1\' marginheight=\'1\'></iframe>'));
if (Ne(e_FGMOCXNBFY,tmp_FGMOCXNBFY)) {
if(c=Ctrl('FGMOCXNBFY')) c.innerHTML=tmp_FGMOCXNBFY;
e_FGMOCXNBFY=tmp_FGMOCXNBFY;
}
if(c=Ctrl('ZFXYWOBFTT')) selectCombo(c,w_tipoall,'C')
if(c=Ctrl('IFYJZJENZX')) c.value = WtH(w_anno,'N',4,0,'')
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay(Ctrl('FGMOCXNBFY'),true);
HideUI();
}
HideUI.lblids["anno"]=['BFFWNIWXGG'];
HideUI.lblids["tipoall"]=['CBQEJYFUKN'];
function ZFBIYQMSFL_Valid(e) {
SetActiveField(Ctrl('ZFBIYQMSFL'),false);
e=(Ne(e,null)?e:window.event);
return Set_nomefile(HtW(Ctrl('ZFBIYQMSFL').value,'C'),null,e);
}
function ZFBIYQMSFL_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ZFBIYQMSFL'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('ZFBIYQMSFL'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ZFBIYQMSFL'),e);
}
function DZUBEERBGN_Click() {
_modifyandopen(ToResource('servlet/sp_huploadfile'+'?pDirectory='+URLenc('appo')+'&pAtExit='+URLenc('Return')+'&pVarReturn='+URLenc('nomefile')+'&m_cParameterSequence=pDirectory,pAtExit,pVarReturn')+'&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null)
}
function PIRPTHHLHK_Click() {
var l_oWv = InitWvApplet();
l_oWv.setValue('w_anno',AsAppletValue(w_anno));
l_oWv.setValue('w_nomefile',AsAppletValue(w_nomefile));
l_oWv.setValue('w_tipoall',AsAppletValue(w_tipoall));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('w_anno,w_nomefile,w_tipoall'));
SetLocationHref(null,'arrt_allinea_sog_ope_opex'+'?m_cWv='+URLenc(l_oWv.asString())+'&m_cAction=start&m_cMode=hyperlink','elaborazione')
}
function ZFXYWOBFTT_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_tipoall(HtW(getComboValue(Ctrl('ZFXYWOBFTT')),'C'),null,e);
}
function ZFXYWOBFTT_OnFocus(e) {
SetActiveField(Ctrl('ZFXYWOBFTT'),true);
}
function ZFXYWOBFTT_OnBlur(e) {
SetActiveField(Ctrl('ZFXYWOBFTT'),false);
}
function IFYJZJENZX_Valid(e) {
SetActiveField(Ctrl('IFYJZJENZX'),false);
e=(Ne(e,null)?e:window.event);
return Set_anno(HtW(Ctrl('IFYJZJENZX').value,'N'),null,e);
}
function IFYJZJENZX_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('IFYJZJENZX'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('IFYJZJENZX'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('IFYJZJENZX'),e);
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
if(c=Ctrl('ZFBIYQMSFL')) c.onblur=ZFBIYQMSFL_Valid;
if(c=Ctrl('ZFBIYQMSFL')) c.onfocus=ZFBIYQMSFL_OnFocus;
if(c=Ctrl('ZFXYWOBFTT')) c.onchange=ZFXYWOBFTT_Valid;
if(c=Ctrl('ZFXYWOBFTT')) c.onfocus=ZFXYWOBFTT_OnFocus;
if(c=Ctrl('ZFXYWOBFTT')) c.onblur=ZFXYWOBFTT_OnBlur;
if(c=Ctrl('IFYJZJENZX')) c.onblur=IFYJZJENZX_Valid;
if(c=Ctrl('IFYJZJENZX')) c.onfocus=IFYJZJENZX_OnFocus;
if(c=Ctrl('IFYJZJENZX')) c.onkeypress=CheckNum;
}
}
function NotifyEvent(p_cEvent) {
var old_c;
if (Ne(typeof(w_Messaggi),'undefined')) {
w_Messaggi.raiseEvent('arpg_allinea_sog_ope_opex_'+Strtran(p_cEvent,' ','_'));
}
if (Ne(typeof(w_Log),'undefined')) {
w_Log.raiseEvent('arpg_allinea_sog_ope_opex_'+Strtran(p_cEvent,' ','_'));
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
FocusFirstComponent.otherwise={"page_1":["DZUBEERBGN"]};
function Help() {
windowOpenForeground('../doc/arpg_allinea_sog_ope_opex_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_tipoall=a[1];
w_anno=a[2];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_allinea_sog_ope_opex',m_cSelectedPage);
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
l_bEnabled= ! (false) || IsDisabledByStateDriver('nomefile');
SetDisabled(Ctrl('ZFBIYQMSFL'),l_bEnabled);
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
function Set_nomefile(ctrlValue,kmode,e) {
if (Ne(w_nomefile,ctrlValue)) {
var ctl = _GetCtl(e,'ZFBIYQMSFL');
if (_tracker.goon(ctl,ctrlValue)) {
w_nomefile=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ZFBIYQMSFL',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',100,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_tipoall(ctrlValue,kmode,e) {
if (Ne(w_tipoall,ctrlValue)) {
var ctl = _GetCtl(e,'ZFXYWOBFTT');
if (_tracker.goon(ctl,ctrlValue)) {
w_tipoall=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ZFXYWOBFTT',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_anno(ctrlValue,kmode,e) {
if (Ne(w_anno,ctrlValue)) {
var ctl = _GetCtl(e,'IFYJZJENZX');
if (_tracker.goon(ctl,ctrlValue)) {
w_anno=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('IFYJZJENZX',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','N',4,0,'');
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
if ((false) && ( ! (_ChkObl('ZFBIYQMSFL',1)))) {
_SignErr('ZFBIYQMSFL');
m_cLastWorkVarErrorMsg='nomefile';
l_bResult=false;
w_nomefile=HtW('','C');
} else if ( ! (_ChkObl('ZFXYWOBFTT',1))) {
_SignErr('ZFXYWOBFTT');
m_cLastWorkVarErrorMsg='485092';
l_bResult=false;
w_tipoall=HtW('','C');
} else if ( ! (_ChkObl('IFYJZJENZX',1))) {
_SignErr('IFYJZJENZX');
m_cLastWorkVarErrorMsg='484641';
l_bResult=false;
w_anno=HtW('','N');
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
l_oWv.setValue('tipoall',WtA(w_tipoall,'C'));
l_oWv.setValue('anno',WtA(w_anno,'N'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["nomefile","tipoall","anno"];
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
if (start && Eq(At(',tipoall,',pseq),0)) {
w_tipoall='S';
}
if (start && Eq(At(',anno,',pseq),0)) {
w_anno=Year(SystemDate());
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
_Obli('nomefile',0,'ZFBIYQMSFL',false)
_Obli('tipoall',0,'ZFXYWOBFTT',false,"485092")
_Obli('anno',1,'IFYJZJENZX',false,"484641")
