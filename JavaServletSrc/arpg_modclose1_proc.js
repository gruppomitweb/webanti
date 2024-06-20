function SetControlsValue() {
var c;
var c;
if(c=Ctrl('JIYGZCDTPQ')) c.value = WtH(w_datarett,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('QLKRKJTVJT')) c.value = WtH(w_olddata,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('WYJHXYCTSP')) c.value = WtH(w_newdate,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
HideUI();
}
HideUI.lblids["datarett"]=['XQSJGZVMDV'];
HideUI.lblids["newdate"]=['OLVLBDQTYW'];
HideUI.lblids["olddata"]=['NRLLUEOMLT'];
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
function QLKRKJTVJT_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('QLKRKJTVJT'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('QLKRKJTVJT').value=ApplyPictureToDate(Ctrl('QLKRKJTVJT').value,TranslatePicture(datePattern),'QLKRKJTVJT');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('QLKRKJTVJT'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('QLKRKJTVJT');
}
}
}
SetActiveField(Ctrl('QLKRKJTVJT'),false);
e=(Ne(e,null)?e:window.event);
return Set_olddata(HtW(Ctrl('QLKRKJTVJT').value,'D'),null,e) && dateisok;
}
function QLKRKJTVJT_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('QLKRKJTVJT'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('QLKRKJTVJT').value=WtH(w_olddata,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('QLKRKJTVJT');
SetActiveField(Ctrl('QLKRKJTVJT'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('QLKRKJTVJT'),e);
}
function WYJHXYCTSP_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('WYJHXYCTSP'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('WYJHXYCTSP').value=ApplyPictureToDate(Ctrl('WYJHXYCTSP').value,TranslatePicture(datePattern),'WYJHXYCTSP');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('WYJHXYCTSP'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('WYJHXYCTSP');
}
}
}
SetActiveField(Ctrl('WYJHXYCTSP'),false);
e=(Ne(e,null)?e:window.event);
return Set_newdate(HtW(Ctrl('WYJHXYCTSP').value,'D'),null,e) && dateisok;
}
function WYJHXYCTSP_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('WYJHXYCTSP'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('WYJHXYCTSP').value=WtH(w_newdate,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('WYJHXYCTSP');
SetActiveField(Ctrl('WYJHXYCTSP'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('WYJHXYCTSP'),e);
}
function WYJHXYCTSP_ZOOM_Click() {
LaunchCalendar(Ctrl('WYJHXYCTSP'));
}
function href_YBBLCLWLHJ() {
window.close()
}
function href_MDWFLPZWFN() {
SetHypPar('m_cAction',AsAppletValue('start'));
SetHypPar('m_cMode',AsAppletValue('hyperlink'));
SetHypPar('m_cID',AsAppletValue(m_IDS['arrt_modclose1']));
SendData('start','arrt_modclose1'+'',HParApplet().asString());
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
if(c=Ctrl('JIYGZCDTPQ')) c.onblur=JIYGZCDTPQ_Valid;
if(c=Ctrl('JIYGZCDTPQ')) c.onfocus=JIYGZCDTPQ_OnFocus;
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
if(c=Ctrl('JIYGZCDTPQ')) c.onkeypress=CheckDateChar;
}
if(c=Ctrl('QLKRKJTVJT')) c.onblur=QLKRKJTVJT_Valid;
if(c=Ctrl('QLKRKJTVJT')) c.onfocus=QLKRKJTVJT_OnFocus;
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
if(c=Ctrl('QLKRKJTVJT')) c.onkeypress=CheckDateChar;
}
if(c=Ctrl('WYJHXYCTSP')) c.onblur=WYJHXYCTSP_Valid;
if(c=Ctrl('WYJHXYCTSP')) c.onfocus=WYJHXYCTSP_OnFocus;
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
if(c=Ctrl('WYJHXYCTSP')) c.onkeypress=CheckDateChar;
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
FocusFirstComponent.otherwise={"page_1":["JIYGZCDTPQ"]};
function Help() {
windowOpenForeground('../doc/arpg_modclose1_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_datarett=a[0];
w_olddata=a[1];
w_newdate=a[2];
w_oldprog=a[3];
w_oldidbase=a[4];
w_oldrappo=a[5];
w_oldrnumrig=a[6];
w_oldfile=a[7];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_modclose1',m_cSelectedPage);
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
l_bEnabled= ! (Ne(1,1)) || IsDisabledByStateDriver('olddata');
SetDisabled(Ctrl('QLKRKJTVJT'),l_bEnabled);
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
function Set_olddata(ctrlValue,kmode,e) {
if (Ne(w_olddata,ctrlValue)) {
var ctl = _GetCtl(e,'QLKRKJTVJT');
if (_tracker.goon(ctl,ctrlValue)) {
w_olddata=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QLKRKJTVJT',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH(NullDate(),'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
_ResetTracker();
return true;
}
}
return true;
}
function Set_newdate(ctrlValue,kmode,e) {
if (Ne(w_newdate,ctrlValue)) {
var ctl = _GetCtl(e,'WYJHXYCTSP');
if (_tracker.goon(ctl,ctrlValue)) {
w_newdate=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('WYJHXYCTSP',0);
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
if ( ! (_ChkObl('JIYGZCDTPQ',1))) {
_SignErr('JIYGZCDTPQ');
m_cLastWorkVarErrorMsg='datarett';
l_bResult=false;
w_datarett=HtW('','D');
} else if ((Ne(1,1)) && ( ! (_ChkObl('QLKRKJTVJT',1)))) {
_SignErr('QLKRKJTVJT');
m_cLastWorkVarErrorMsg='olddata';
l_bResult=false;
w_olddata=HtW('','D');
} else if ( ! (_ChkObl('WYJHXYCTSP',1))) {
_SignErr('WYJHXYCTSP');
m_cLastWorkVarErrorMsg='newdate';
l_bResult=false;
w_newdate=HtW('','D');
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('JIYGZCDTPQ_ZOOM',lc)) {
return 0;
}
if (Eq('WYJHXYCTSP_ZOOM',lc)) {
return 0;
}
return -1;
}
function link_url(index) {
var l_oWv;
}
function FillWv() {
var l_oWv = InitWvApplet();
l_oWv.setValue('datarett',WtA(w_datarett,'D'));
l_oWv.setValue('olddata',WtA(w_olddata,'D'));
l_oWv.setValue('newdate',WtA(w_newdate,'D'));
l_oWv.setValue('oldprog',WtA(w_oldprog,'C'));
l_oWv.setValue('oldidbase',WtA(w_oldidbase,'C'));
l_oWv.setValue('oldrappo',WtA(w_oldrappo,'C'));
l_oWv.setValue('oldrnumrig',WtA(w_oldrnumrig,'N'));
l_oWv.setValue('oldfile',WtA(w_oldfile,'C'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["datarett","olddata","newdate","oldprog","oldidbase","oldrappo","oldrnumrig","oldfile"];
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
if (Eq(w_datarett,SystemDate()) && Ne(opener.w_datarett,null)) {
TransferBetweenWindows(opener,'w_datarett',null,'Set_datarett');
}
if (Empty(w_olddata) && Ne(opener.w_olddata,null)) {
TransferBetweenWindows(opener,'w_olddata',null,'Set_olddata');
}
if (Empty(w_newdate) && Ne(opener.w_newdate,null)) {
TransferBetweenWindows(opener,'w_newdate',null,'Set_newdate');
}
if (Empty(w_oldprog) && Ne(opener.w_oldprog,null)) {
TransferBetweenWindows(opener,'w_oldprog','w_oldprog');
}
if (Empty(w_oldidbase) && Ne(opener.w_oldidbase,null)) {
TransferBetweenWindows(opener,'w_oldidbase','w_oldidbase');
}
if (Empty(w_oldrappo) && Ne(opener.w_oldrappo,null)) {
TransferBetweenWindows(opener,'w_oldrappo','w_oldrappo');
}
if (Empty(w_oldrnumrig) && Ne(opener.w_oldrnumrig,null)) {
TransferBetweenWindows(opener,'w_oldrnumrig','w_oldrnumrig');
}
if (Empty(w_oldfile) && Ne(opener.w_oldfile,null)) {
TransferBetweenWindows(opener,'w_oldfile','w_oldfile');
}
}
}
m_bCalculating=true;
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
_Obli('datarett',2,'JIYGZCDTPQ',false)
_Obli('olddata',2,'QLKRKJTVJT',false)
_Obli('newdate',2,'WYJHXYCTSP',false)
