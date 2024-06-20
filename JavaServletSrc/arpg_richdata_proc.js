function SetControlsValue() {
var c;
var c;
if(c=Ctrl('NTUZLPWVAD')) c.value = WtH(w_datavaria,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
HideUI();
}
HideUI.lblids["datavaria"]=['QAXNTYELMN'];
function NTUZLPWVAD_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('NTUZLPWVAD'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('NTUZLPWVAD').value=ApplyPictureToDate(Ctrl('NTUZLPWVAD').value,TranslatePicture(datePattern),'NTUZLPWVAD');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('NTUZLPWVAD'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('NTUZLPWVAD');
}
}
}
SetActiveField(Ctrl('NTUZLPWVAD'),false);
e=(Ne(e,null)?e:window.event);
return Set_datavaria(HtW(Ctrl('NTUZLPWVAD').value,'D'),null,e) && dateisok;
}
function NTUZLPWVAD_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('NTUZLPWVAD'))) {
DisplayErrorMessage();
}
if ( ! (GetDisabled('NTUZLPWVAD'))) {
if (Eq(w_datavaria,NullDate()) && Eq(_tracker.ctrl,null)) {
Ctrl('NTUZLPWVAD').value=WtH(SystemDate(),'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
} else {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('NTUZLPWVAD').value=WtH(w_datavaria,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
}
}
m_oEnteredInDate=Ctrl('NTUZLPWVAD');
SetActiveField(Ctrl('NTUZLPWVAD'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('NTUZLPWVAD'),e);
}
function NTUZLPWVAD_ZOOM_Click() {
LaunchCalendar(Ctrl('NTUZLPWVAD'));
}
function href_LILXKKBRTV() {
SetHypPar('m_cAction',AsAppletValue('start'));
SetHypPar('m_cMode',AsAppletValue('hyperlink'));
SetHypPar('w_IDBASE',AsAppletValue(w_IDBASE));
SetHypPar('w_CONNES',AsAppletValue(w_CONNES));
SetHypPar('w_tipooper',AsAppletValue(w_tipooper));
SetHypPar('w_datavaria',AsAppletValue(w_datavaria));
SetHypPar('w_DATARETT',AsAppletValue(w_DATARETT));
SetHypPar('w_NUMPROG',AsAppletValue(w_NUMPROG));
SetHypPar('w_FLAGFRAZ',AsAppletValue(w_FLAGFRAZ));
SetHypPar('m_cParameterSequence',AsAppletValue('w_IDBASE,w_CONNES,w_tipooper,w_datavaria,w_DATARETT,w_NUMPROG,w_FLAGFRAZ'));
SendData('start',LRTrim(w_nomeprg)+''+'',HParApplet().asString());
}
function href_FBELDGNLIX() {
CloseAll()
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
if(c=Ctrl('NTUZLPWVAD')) c.onblur=NTUZLPWVAD_Valid;
if(c=Ctrl('NTUZLPWVAD')) c.onfocus=NTUZLPWVAD_OnFocus;
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
if(c=Ctrl('NTUZLPWVAD')) c.onkeypress=CheckDateChar;
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
FocusFirstComponent.otherwise={"page_1":["NTUZLPWVAD"]};
function Help() {
windowOpenForeground('../doc/arpg_richdata_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_datavaria=a[0];
w_CONNES=a[1];
w_IDBASE=a[2];
w_nomeprg=a[3];
w_tipooper=a[4];
w_DATARETT=a[5];
w_NUMPROG=a[6];
w_FLAGFRAZ=a[7];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_richdata',m_cSelectedPage);
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
function Set_datavaria(ctrlValue,kmode,e) {
if (Ne(w_datavaria,ctrlValue)) {
var ctl = _GetCtl(e,'NTUZLPWVAD');
if (_tracker.goon(ctl,ctrlValue)) {
w_datavaria=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NTUZLPWVAD',0);
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
if ( ! (_ChkObl('NTUZLPWVAD',1))) {
_SignErr('NTUZLPWVAD');
m_cLastWorkVarErrorMsg='datavaria';
l_bResult=false;
w_datavaria=HtW('','D');
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('NTUZLPWVAD_ZOOM',lc)) {
return 0;
}
return -1;
}
function link_url(index) {
var l_oWv;
}
function FillWv() {
var l_oWv = InitWvApplet();
l_oWv.setValue('datavaria',WtA(w_datavaria,'D'));
l_oWv.setValue('CONNES',WtA(w_CONNES,'C'));
l_oWv.setValue('IDBASE',WtA(w_IDBASE,'C'));
l_oWv.setValue('nomeprg',WtA(w_nomeprg,'C'));
l_oWv.setValue('tipooper',WtA(w_tipooper,'C'));
l_oWv.setValue('DATARETT',WtA(w_DATARETT,'D'));
l_oWv.setValue('NUMPROG',WtA(w_NUMPROG,'C'));
l_oWv.setValue('FLAGFRAZ',WtA(w_FLAGFRAZ,'C'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["datavaria","CONNES","IDBASE","nomeprg","tipooper","DATARETT","NUMPROG","FLAGFRAZ"];
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
if (Empty(w_CONNES) && Ne(opener.w_CONNES,null)) {
TransferBetweenWindows(opener,'w_CONNES','w_CONNES');
}
if (Empty(w_IDBASE) && Ne(opener.w_IDBASE,null)) {
TransferBetweenWindows(opener,'w_IDBASE','w_IDBASE');
}
if (Empty(w_nomeprg) && Ne(opener.w_nomeprg,null)) {
TransferBetweenWindows(opener,'w_nomeprg','w_nomeprg');
}
if (Empty(w_tipooper) && Ne(opener.w_tipooper,null)) {
TransferBetweenWindows(opener,'w_tipooper','w_tipooper');
}
if (Empty(w_DATARETT) && Ne(opener.w_DATARETT,null)) {
TransferBetweenWindows(opener,'w_DATARETT','w_DATARETT');
}
if (Empty(w_NUMPROG) && Ne(opener.w_NUMPROG,null)) {
TransferBetweenWindows(opener,'w_NUMPROG','w_NUMPROG');
}
if (Empty(w_FLAGFRAZ) && Ne(opener.w_FLAGFRAZ,null)) {
TransferBetweenWindows(opener,'w_FLAGFRAZ','w_FLAGFRAZ');
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
_Obli('datavaria',2,'NTUZLPWVAD',false)
