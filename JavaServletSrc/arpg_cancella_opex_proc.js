function SetControlsValue() {
var c;
var c;
if(c=Ctrl('ZFBIYQMSFL')) c.value = WtH(w_nomefile,'C',100,0,'')
var tmp_FGMOCXNBFY = ToHTag(AsControlValue('<iframe width=\'655\' height=\'170\' id=\'elaborazione\'  name=\'elaborazione\' frameborder=\'1\'  border=\'1\' align=\'TOP\' marginwidth=\'1\' marginheight=\'1\'></iframe>'));
if (Ne(e_FGMOCXNBFY,tmp_FGMOCXNBFY)) {
if(c=Ctrl('FGMOCXNBFY')) c.innerHTML=tmp_FGMOCXNBFY;
e_FGMOCXNBFY=tmp_FGMOCXNBFY;
}
if(c=Ctrl('GTMJENMCMN')) c.value = WtH(w_anno,'N',4,0,'')
if(c=Ctrl('JIYGZCDTPQ')) c.value = WtH(w_datarett,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay(Ctrl('FGMOCXNBFY'),true);
HideUI();
}
HideUI.lblids["datarett"]=['XQSJGZVMDV'];
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
_modifyandopen(ToResource('servlet/sp_huploadfile'+'?pDirectory='+URLenc('appo/'+LRTrim(w_gAzienda))+'&pAtExit='+URLenc('Return')+'&pVarReturn='+URLenc('nomefile')+'&m_cParameterSequence=pDirectory,pAtExit,pVarReturn')+'&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null)
}
function href_XWPYHZIJDE() {
if (false || WindowConfirm(Translate('839107543'))) {
SetLocationHref(null,'arrt_cancella_opex'+'?m_cAction=start&m_cMode=hyperlink','elaborazione')
}
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
function JIYGZCDTPQ_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('JIYGZCDTPQ'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('JIYGZCDTPQ').value=ApplyPictureToDate(Ctrl('JIYGZCDTPQ').value,TranslatePicture(datePattern),'JIYGZCDTPQ');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('JIYGZCDTPQ'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('JIYGZCDTPQ');
}
}
}
SetActiveField(Ctrl('JIYGZCDTPQ'),false);
e=(Ne(e,null)?e:window.event);
return Set_datarett(HtW(Ctrl('JIYGZCDTPQ').value,'D'),null,e) && dateisok;
}
function JIYGZCDTPQ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('JIYGZCDTPQ'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('JIYGZCDTPQ').value=WtH(w_datarett,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('JIYGZCDTPQ');
SetActiveField(Ctrl('JIYGZCDTPQ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('JIYGZCDTPQ'),e);
}
function JIYGZCDTPQ_ZOOM_Click() {
LaunchCalendar(Ctrl('JIYGZCDTPQ'));
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
if(c=Ctrl('ZFBIYQMSFL')) c.onblur=ZFBIYQMSFL_Valid;
if(c=Ctrl('ZFBIYQMSFL')) c.onfocus=ZFBIYQMSFL_OnFocus;
if(c=Ctrl('GTMJENMCMN')) c.onblur=GTMJENMCMN_Valid;
if(c=Ctrl('GTMJENMCMN')) c.onfocus=GTMJENMCMN_OnFocus;
if(c=Ctrl('GTMJENMCMN')) c.onkeypress=CheckNum;
if(c=Ctrl('JIYGZCDTPQ')) c.onblur=JIYGZCDTPQ_Valid;
if(c=Ctrl('JIYGZCDTPQ')) c.onfocus=JIYGZCDTPQ_OnFocus;
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
if(c=Ctrl('JIYGZCDTPQ')) c.onkeypress=CheckDateChar;
}
}
}
function NotifyEvent(p_cEvent) {
var old_c;
if (Ne(typeof(w_Messaggi),'undefined')) {
w_Messaggi.raiseEvent('arpg_cancella_opex_'+Strtran(p_cEvent,' ','_'));
}
if (Ne(typeof(w_Log),'undefined')) {
w_Log.raiseEvent('arpg_cancella_opex_'+Strtran(p_cEvent,' ','_'));
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
windowOpenForeground('../doc/arpg_cancella_opex_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_anno=a[1];
w_gAzienda=a[2];
w_gDescAzi=a[3];
w_datarett=a[4];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_cancella_opex',m_cSelectedPage);
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
l_bResult=Ge(w_anno,2011);
if ( ! (l_bResult)) {
m_nLastError=2;
m_cLastWorkVarErrorMsg='anno';
m_cLastMsgError=AlertErrorMessage('369065168');
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
function Set_datarett(ctrlValue,kmode,e) {
if (Ne(w_datarett,ctrlValue)) {
var ctl = _GetCtl(e,'JIYGZCDTPQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_datarett=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('JIYGZCDTPQ',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH(NullDate(),'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
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
} else if (( ! (_ChkObl('GTMJENMCMN',1))) || ( ! (Ge(w_anno,2011)))) {
_SignErr('GTMJENMCMN','369065168');
l_bResult=false;
w_anno=HtW('','N');
} else if ( ! (_ChkObl('JIYGZCDTPQ',1))) {
_SignErr('JIYGZCDTPQ');
m_cLastWorkVarErrorMsg='datarett';
l_bResult=false;
w_datarett=HtW('','D');
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('JIYGZCDTPQ_ZOOM',lc)) {
return 0;
}
return -1;
}
function link_url(index) {
var l_oWv;
}
function FillWv() {
var l_oWv = InitWvApplet();
l_oWv.setValue('nomefile',WtA(w_nomefile,'C'));
l_oWv.setValue('anno',WtA(w_anno,'N'));
l_oWv.setValue('gAzienda',WtA(w_gAzienda,'C'));
l_oWv.setValue('gDescAzi',WtA(w_gDescAzi,'C'));
l_oWv.setValue('datarett',WtA(w_datarett,'D'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["nomefile","anno","gAzienda","gDescAzi","datarett"];
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
if (Empty(w_nomefile) && Ne(opener.w_nomefile,null)) {
TransferBetweenWindows(opener,'w_nomefile',null,'Set_nomefile');
}
if (Eq(w_datarett,SystemDate()) && Ne(opener.w_datarett,null)) {
TransferBetweenWindows(opener,'w_datarett',null,'Set_datarett');
}
}
}
m_bCalculating=true;
if (start && Eq(At(',anno,',pseq),0)) {
w_anno=Year(SystemDate())-1;
}
if (start && Eq(At(',datarett,',pseq),0)) {
w_datarett=SystemDate();
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
_Obli('anno',1,'GTMJENMCMN',false)
_Obli('datarett',2,'JIYGZCDTPQ',false)
