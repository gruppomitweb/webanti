function SetControlsValue() {
var c;
var c;
if(c=Ctrl('ZFBIYQMSFL')) c.value = WtH(w_nomefile,'C',100,0,'')
var tmp_FGMOCXNBFY = ToHTag(AsControlValue('<iframe width=\'655\' height=\'170\' id=\'elaborazione\'  name=\'elaborazione\'  frameborder=\'1\'  border=\'1\' align=\'TOP\' marginwidth=\'1\' marginheight=\'1\'></iframe>'));
if (Ne(e_FGMOCXNBFY,tmp_FGMOCXNBFY)) {
if(c=Ctrl('FGMOCXNBFY')) c.innerHTML=tmp_FGMOCXNBFY;
e_FGMOCXNBFY=tmp_FGMOCXNBFY;
}
if(c=Ctrl('BAZIEIGBBY')) c.value = WtH(w_dadata,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('LHRMJFERXU')) c.value = WtH(w_a_data,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay(Ctrl('FGMOCXNBFY'),true);
HideUI();
}
HideUI.lblids["a_data"]=['NEESTLYOSU'];
HideUI.lblids["dadata"]=['IBGNNZOUNR'];
function DZUBEERBGN_Click() {
if (Eq(w_impzip,0)) {
UploadDoc()
}
}
function PIRPTHHLHK_Click() {
SetLocationHref(null,'arrt_allinea_fileae'+'?m_cAction=start&m_cMode=hyperlink','elaborazione')
}
function BAZIEIGBBY_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('BAZIEIGBBY'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('BAZIEIGBBY').value=ApplyPictureToDate(Ctrl('BAZIEIGBBY').value,TranslatePicture(datePattern),'BAZIEIGBBY');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('BAZIEIGBBY'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('BAZIEIGBBY');
}
}
}
SetActiveField(Ctrl('BAZIEIGBBY'),false);
e=(Ne(e,null)?e:window.event);
return Set_dadata(HtW(Ctrl('BAZIEIGBBY').value,'D'),null,e) && dateisok;
}
function BAZIEIGBBY_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('BAZIEIGBBY'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('BAZIEIGBBY').value=WtH(w_dadata,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('BAZIEIGBBY');
SetActiveField(Ctrl('BAZIEIGBBY'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('BAZIEIGBBY'),e);
}
function BAZIEIGBBY_ZOOM_Click() {
LaunchCalendar(Ctrl('BAZIEIGBBY'));
}
function LHRMJFERXU_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('LHRMJFERXU'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('LHRMJFERXU').value=ApplyPictureToDate(Ctrl('LHRMJFERXU').value,TranslatePicture(datePattern),'LHRMJFERXU');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('LHRMJFERXU'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('LHRMJFERXU');
}
}
}
SetActiveField(Ctrl('LHRMJFERXU'),false);
e=(Ne(e,null)?e:window.event);
return Set_a_data(HtW(Ctrl('LHRMJFERXU').value,'D'),null,e) && dateisok;
}
function LHRMJFERXU_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('LHRMJFERXU'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('LHRMJFERXU').value=WtH(w_a_data,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('LHRMJFERXU');
SetActiveField(Ctrl('LHRMJFERXU'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('LHRMJFERXU'),e);
}
function LHRMJFERXU_ZOOM_Click() {
LaunchCalendar(Ctrl('LHRMJFERXU'));
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
if(c=Ctrl('BAZIEIGBBY')) c.onblur=BAZIEIGBBY_Valid;
if(c=Ctrl('BAZIEIGBBY')) c.onfocus=BAZIEIGBBY_OnFocus;
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
if(c=Ctrl('BAZIEIGBBY')) c.onkeypress=CheckDateChar;
}
if(c=Ctrl('LHRMJFERXU')) c.onblur=LHRMJFERXU_Valid;
if(c=Ctrl('LHRMJFERXU')) c.onfocus=LHRMJFERXU_OnFocus;
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
if(c=Ctrl('LHRMJFERXU')) c.onkeypress=CheckDateChar;
}
}
}
function NotifyEvent(p_cEvent) {
var old_c;
if (Ne(typeof(w_Messaggi),'undefined')) {
w_Messaggi.raiseEvent('arpg_allinea_fileae_'+Strtran(p_cEvent,' ','_'));
}
if (Ne(typeof(w_Log),'undefined')) {
w_Log.raiseEvent('arpg_allinea_fileae_'+Strtran(p_cEvent,' ','_'));
}
if (Ne(typeof(w_ListaFile),'undefined')) {
w_ListaFile.raiseEvent('arpg_allinea_fileae_'+Strtran(p_cEvent,' ','_'));
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
FocusFirstComponent.otherwise={"page_1":["DZUBEERBGN","PIRPTHHLHK"]};
function Help() {
windowOpenForeground('../doc/arpg_allinea_fileae_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_errchk=a[1];
w_xdesval=a[2];
w_impzip=a[3];
w_dadata=a[4];
w_a_data=a[5];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_allinea_fileae',m_cSelectedPage);
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
l_bEnabled= ! (Eq(w_impzip,0));
SetDisabled(Ctrl('DZUBEERBGN'),l_bEnabled);
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
function Set_a_data(ctrlValue,kmode,e) {
if (Ne(w_a_data,ctrlValue)) {
var ctl = _GetCtl(e,'LHRMJFERXU');
if (_tracker.goon(ctl,ctrlValue)) {
w_a_data=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('LHRMJFERXU',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH(NullDate(),'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
_ResetTracker();
return true;
}
}
return true;
}
function Set_dadata(ctrlValue,kmode,e) {
if (Ne(w_dadata,ctrlValue)) {
var ctl = _GetCtl(e,'BAZIEIGBBY');
if (_tracker.goon(ctl,ctrlValue)) {
w_dadata=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BAZIEIGBBY',0);
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
if ( ! (_ChkObl('BAZIEIGBBY',1))) {
_SignErr('BAZIEIGBBY');
m_cLastWorkVarErrorMsg='10911345311';
l_bResult=false;
w_dadata=HtW('','D');
} else if ( ! (_ChkObl('LHRMJFERXU',1))) {
_SignErr('LHRMJFERXU');
m_cLastWorkVarErrorMsg='10911345311';
l_bResult=false;
w_a_data=HtW('','D');
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('BAZIEIGBBY_ZOOM',lc)) {
return 0;
}
if (Eq('LHRMJFERXU_ZOOM',lc)) {
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
l_oWv.setValue('errchk',WtA(w_errchk,'N'));
l_oWv.setValue('xdesval',WtA(w_xdesval,'C'));
l_oWv.setValue('impzip',WtA(w_impzip,'N'));
l_oWv.setValue('dadata',WtA(w_dadata,'D'));
l_oWv.setValue('a_data',WtA(w_a_data,'D'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["nomefile","errchk","xdesval","impzip","dadata","a_data"];
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
TransferBetweenWindows(opener,'w_nomefile','w_nomefile');
}
}
}
m_bCalculating=true;
if (start && Eq(At(',errchk,',pseq),0)) {
w_errchk=1;
}
if (start && Eq(At(',impzip,',pseq),0)) {
w_impzip=0;
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
_Obli('a_data',2,'LHRMJFERXU',false,"10911345311")
_Obli('dadata',2,'BAZIEIGBBY',false,"10911345311")
