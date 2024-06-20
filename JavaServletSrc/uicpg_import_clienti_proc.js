function SetControlsValue() {
var c;
var c;
if(c=Ctrl('ZFBIYQMSFL')) selectCombo(c,w_azienda,'C')
if(c=Ctrl('WIRRRKLEWO')) ChkboxCheckUncheck(c,'S',w_flagagg)
if(c=Ctrl('WIRRRKLEWO')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('SUFGYUGNJB')) c.value = WtH(w_errorlog,'M',10,0,'')
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
HideUI.lblids["azienda"]=['GRNCOSXGXB'];
function ZFBIYQMSFL_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_azienda(HtW(getComboValue(Ctrl('ZFBIYQMSFL')),'C'),null,e);
}
function ZFBIYQMSFL_OnFocus(e) {
SetActiveField(Ctrl('ZFBIYQMSFL'),true);
}
function ZFBIYQMSFL_OnBlur(e) {
SetActiveField(Ctrl('ZFBIYQMSFL'),false);
}
function WIRRRKLEWO_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_flagagg(ChkboxValueAssign(Ctrl('WIRRRKLEWO'),'S','N','C',1,0,''),null,e);
}
function WIRRRKLEWO_OnFocus(e) {
SetActiveField(Ctrl('WIRRRKLEWO'),true);
}
function WIRRRKLEWO_OnBlur(e) {
SetActiveField(Ctrl('WIRRRKLEWO'),false);
}
function SUFGYUGNJB_Valid(e) {
SetActiveField(Ctrl('SUFGYUGNJB'),false);
e=(Ne(e,null)?e:window.event);
return Set_errorlog(HtW(Ctrl('SUFGYUGNJB').value,'M'),null,e);
}
function SUFGYUGNJB_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('SUFGYUGNJB'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('SUFGYUGNJB'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('SUFGYUGNJB'),e);
}
function href_LQBOHZTKJM() {
SetLocationHref(null,ToResource('uicrt_import_clienti'+'')+'?m_cMode=hyperlink','elaborazione')
}
function href_KMEUIXTYQL() {
SetLocationHref(window.location,ToResource('jsp/start_page_logo_portlet.jsp'+'')+'')
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
if(c=Ctrl('ZFBIYQMSFL')) c.onchange=ZFBIYQMSFL_Valid;
if(c=Ctrl('ZFBIYQMSFL')) c.onfocus=ZFBIYQMSFL_OnFocus;
if(c=Ctrl('ZFBIYQMSFL')) c.onblur=ZFBIYQMSFL_OnBlur;
if(c=Ctrl('WIRRRKLEWO')) c.onclick=WIRRRKLEWO_Valid;
if(c=Ctrl('WIRRRKLEWO')) c.onfocus=WIRRRKLEWO_OnFocus;
if(c=Ctrl('WIRRRKLEWO')) c.onblur=WIRRRKLEWO_OnBlur;
if(c=Ctrl('SUFGYUGNJB')) c.onblur=SUFGYUGNJB_Valid;
if(c=Ctrl('SUFGYUGNJB')) c.onfocus=SUFGYUGNJB_OnFocus;
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
FocusFirstComponent.otherwise={"page_1":["ZFBIYQMSFL"]};
function Help() {
windowOpenForeground('../doc/uicpg_import_clienti_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_azienda=a[0];
w_flagagg=a[1];
w_errorlog=a[2];
w_gAzienda=a[3];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('uicpg_import_clienti',m_cSelectedPage);
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
l_bEnabled= ! (Ne(1,1)) || IsDisabledByStateDriver('errorlog');
SetDisabled(Ctrl('SUFGYUGNJB'),l_bEnabled);
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
function Set_azienda(ctrlValue,kmode,e) {
if (Ne(w_azienda,ctrlValue)) {
var ctl = _GetCtl(e,'ZFBIYQMSFL');
if (_tracker.goon(ctl,ctrlValue)) {
w_azienda=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ZFBIYQMSFL',0);
if (l_bResult) {
l_bResult=Ne(w_azienda,w_gAzienda);
if ( ! (l_bResult)) {
m_nLastError=2;
m_cLastWorkVarErrorMsg='azienda';
m_cLastMsgError=AlertErrorMessage('11655713852');
}
if ( ! (l_bResult)) {
w_azienda=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',10,0,''));
} else {
_ResetTracker();
}
return l_bResult;
} else {
ctl.value=WtH('','C',10,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_flagagg(ctrlValue,kmode,e) {
if (Ne(w_flagagg,ctrlValue)) {
var ctl = _GetCtl(e,'WIRRRKLEWO');
if (_tracker.goon(ctl,ctrlValue)) {
w_flagagg=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('WIRRRKLEWO',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_errorlog(ctrlValue,kmode,e) {
if (Ne(w_errorlog,ctrlValue)) {
var ctl = _GetCtl(e,'SUFGYUGNJB');
if (_tracker.goon(ctl,ctrlValue)) {
w_errorlog=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SUFGYUGNJB',0);
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
if (( ! (_ChkObl('ZFBIYQMSFL',1))) || ( ! (Ne(w_azienda,w_gAzienda)))) {
_SignErr('ZFBIYQMSFL','11655713852');
l_bResult=false;
w_azienda=HtW('','C');
} else if ( ! (_ChkObl('WIRRRKLEWO',1))) {
_SignErr('WIRRRKLEWO');
m_cLastWorkVarErrorMsg='flagagg';
l_bResult=false;
w_flagagg='N';
} else if ((Ne(1,1)) && ( ! (_ChkObl('SUFGYUGNJB',1)))) {
_SignErr('SUFGYUGNJB');
m_cLastWorkVarErrorMsg='errorlog';
l_bResult=false;
w_errorlog=HtW('','M');
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
l_oWv.setValue('azienda',WtA(w_azienda,'C'));
l_oWv.setValue('flagagg',WtA(w_flagagg,'C'));
l_oWv.setValue('errorlog',WtA(w_errorlog,'M'));
l_oWv.setValue('gAzienda',WtA(w_gAzienda,'C'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["azienda","flagagg","errorlog","gAzienda"];
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
if (Empty(w_azienda) && Ne(opener.w_azienda,null)) {
TransferBetweenWindows(opener,'w_azienda',null,'Set_azienda');
}
if (Eq(w_flagagg,'S') && Ne(opener.w_flagagg,null)) {
TransferBetweenWindows(opener,'w_flagagg',null,'Set_flagagg');
}
if (Empty(w_errorlog) && Ne(opener.w_errorlog,null)) {
TransferBetweenWindows(opener,'w_errorlog',null,'Set_errorlog');
}
}
}
m_bCalculating=true;
if (start && Eq(At(',flagagg,',pseq),0)) {
w_flagagg='S';
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
_Obli('azienda',0,'ZFBIYQMSFL',false)
_Obli('flagagg',0,'WIRRRKLEWO',false)
_Obli('errorlog',0,'SUFGYUGNJB',false)
