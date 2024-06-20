function SetControlsValue() {
var c;
var c;
var tmp_FGMOCXNBFY = ToHTag(AsControlValue('<iframe width=\'655\' height=\'170\' id=\'elaborazione\'  name=\'elaborazione\' frameborder=\'1\'  border=\'1\' align=\'TOP\' marginwidth=\'1\' marginheight=\'1\'></iframe>'));
if (Ne(e_FGMOCXNBFY,tmp_FGMOCXNBFY)) {
if(c=Ctrl('FGMOCXNBFY')) c.innerHTML=tmp_FGMOCXNBFY;
e_FGMOCXNBFY=tmp_FGMOCXNBFY;
}
if(c=Ctrl('NPEVPSEORB')) c.value = WtH(w_datchi,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay(Ctrl('FGMOCXNBFY'),true);
HideUI();
}
HideUI.lblids["datchi"]=['QDZKSWCHXH'];
function NPEVPSEORB_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('NPEVPSEORB'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('NPEVPSEORB').value=ApplyPictureToDate(Ctrl('NPEVPSEORB').value,TranslatePicture(datePattern),'NPEVPSEORB');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('NPEVPSEORB'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('NPEVPSEORB');
}
}
}
SetActiveField(Ctrl('NPEVPSEORB'),false);
e=(Ne(e,null)?e:window.event);
return Set_datchi(HtW(Ctrl('NPEVPSEORB').value,'D'),null,e) && dateisok;
}
function NPEVPSEORB_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('NPEVPSEORB'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('NPEVPSEORB').value=WtH(w_datchi,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('NPEVPSEORB');
SetActiveField(Ctrl('NPEVPSEORB'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('NPEVPSEORB'),e);
}
function NPEVPSEORB_ZOOM_Click() {
LaunchCalendar(Ctrl('NPEVPSEORB'));
}
function XIFZDMHWTB_Click() {
if (false || WindowConfirm(Translate('10545141903'))) {
SetLocationHref(null,'arrt_cancella_ae'+'?m_cAction=start&m_cMode=hyperlink','elaborazione')
}
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
if(c=Ctrl('NPEVPSEORB')) c.onblur=NPEVPSEORB_Valid;
if(c=Ctrl('NPEVPSEORB')) c.onfocus=NPEVPSEORB_OnFocus;
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
if(c=Ctrl('NPEVPSEORB')) c.onkeypress=CheckDateChar;
}
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
FocusFirstComponent.otherwise={"page_1":["NPEVPSEORB"]};
function Help() {
windowOpenForeground('../doc/arpg_cancella_ae_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_datchi=a[0];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_cancella_ae',m_cSelectedPage);
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
function Set_datchi(ctrlValue,kmode,e) {
if (Ne(w_datchi,ctrlValue)) {
var ctl = _GetCtl(e,'NPEVPSEORB');
if (_tracker.goon(ctl,ctrlValue)) {
w_datchi=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NPEVPSEORB',0);
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
if ( ! (_ChkObl('NPEVPSEORB',1))) {
_SignErr('NPEVPSEORB');
m_cLastWorkVarErrorMsg='datchi';
l_bResult=false;
w_datchi=HtW('','D');
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('NPEVPSEORB_ZOOM',lc)) {
return 0;
}
return -1;
}
function link_url(index) {
var l_oWv;
}
function FillWv() {
var l_oWv = InitWvApplet();
l_oWv.setValue('datchi',WtA(w_datchi,'D'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["datchi"];
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
if (start && Eq(At(',datchi,',pseq),0)) {
w_datchi=SystemDate();
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
_Obli('datchi',2,'NPEVPSEORB',false)
