function SetControlsValue() {
var c;
var c;
if(c=Ctrl('LPTSLAVIAK')) ChkboxCheckUncheck(c,'S',w_iniz)
if(c=Ctrl('LPTSLAVIAK')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('KHPXTNGSFO')) ChkboxCheckUncheck(c,'S',w_seco)
if(c=Ctrl('KHPXTNGSFO')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('FSXHJAAZGG')) c.value = WtH(w_dadata,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('CLVVMIYSQG')) c.value = WtH(w_a_data,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('CFLYSPTTDU')) c.value = WtH(w_darett,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('DIUBYKKRGY')) c.value = WtH(w_a_rett,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
HideUI();
}
function LPTSLAVIAK_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_iniz(ChkboxValueAssign(Ctrl('LPTSLAVIAK'),'S','N','C',1,0,''),null,e);
}
function LPTSLAVIAK_OnFocus(e) {
SetActiveField(Ctrl('LPTSLAVIAK'),true);
}
function LPTSLAVIAK_OnBlur(e) {
SetActiveField(Ctrl('LPTSLAVIAK'),false);
}
function KHPXTNGSFO_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_seco(ChkboxValueAssign(Ctrl('KHPXTNGSFO'),'S','N','C',1,0,''),null,e);
}
function KHPXTNGSFO_OnFocus(e) {
SetActiveField(Ctrl('KHPXTNGSFO'),true);
}
function KHPXTNGSFO_OnBlur(e) {
SetActiveField(Ctrl('KHPXTNGSFO'),false);
}
function FSXHJAAZGG_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('FSXHJAAZGG'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('FSXHJAAZGG').value=ApplyPictureToDate(Ctrl('FSXHJAAZGG').value,TranslatePicture(datePattern),'FSXHJAAZGG');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('FSXHJAAZGG'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('FSXHJAAZGG');
}
}
}
SetActiveField(Ctrl('FSXHJAAZGG'),false);
e=(Ne(e,null)?e:window.event);
return Set_dadata(HtW(Ctrl('FSXHJAAZGG').value,'D'),null,e) && dateisok;
}
function FSXHJAAZGG_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('FSXHJAAZGG'))) {
DisplayErrorMessage();
}
if (Ne(_tracker.ctrl,Ctrl('FSXHJAAZGG'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('FSXHJAAZGG').value=WtH(w_dadata,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
}
m_oEnteredInDate=Ctrl('FSXHJAAZGG');
SetActiveField(Ctrl('FSXHJAAZGG'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('FSXHJAAZGG'),e);
}
function FSXHJAAZGG_ZOOM_Click() {
LaunchCalendar(Ctrl('FSXHJAAZGG'));
}
function CLVVMIYSQG_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('CLVVMIYSQG'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('CLVVMIYSQG').value=ApplyPictureToDate(Ctrl('CLVVMIYSQG').value,TranslatePicture(datePattern),'CLVVMIYSQG');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('CLVVMIYSQG'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('CLVVMIYSQG');
}
}
}
SetActiveField(Ctrl('CLVVMIYSQG'),false);
e=(Ne(e,null)?e:window.event);
return Set_a_data(HtW(Ctrl('CLVVMIYSQG').value,'D'),null,e) && dateisok;
}
function CLVVMIYSQG_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('CLVVMIYSQG'))) {
DisplayErrorMessage();
}
if (Ne(_tracker.ctrl,Ctrl('CLVVMIYSQG'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('CLVVMIYSQG').value=WtH(w_a_data,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
}
m_oEnteredInDate=Ctrl('CLVVMIYSQG');
SetActiveField(Ctrl('CLVVMIYSQG'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('CLVVMIYSQG'),e);
}
function CLVVMIYSQG_ZOOM_Click() {
LaunchCalendar(Ctrl('CLVVMIYSQG'));
}
function href_AJXISNWTIP() {
var action = (Eq(Left('centrale'+''+'?',24),'arpg_scaricodati_delope?')?'query':'start');
SetHypPar('m_cAction',AsAppletValue(action));
SetHypPar('m_cMode',AsAppletValue('hyperlink'));
SendData(action,'centrale'+'',HParApplet().asString());
}
function NMNMXABGKO_Click() {
_modifyandopen('arrt_sd_aperture_delope'+'?m_cAction=start&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null)
}
function PSAHIDGTWE_Click() {
if (Ne(w_iniz,'S')) {
_modifyandopen('arrt_sd_chiusure_delope'+'?m_cAction=start&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null)
}
}
function HVQERBROTD_Click() {
_modifyandopen('arrt_sd_comunega_delope'+'?m_cAction=start&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes,height=600,width=800',null)
}
function CFLYSPTTDU_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('CFLYSPTTDU'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('CFLYSPTTDU').value=ApplyPictureToDate(Ctrl('CFLYSPTTDU').value,TranslatePicture(datePattern),'CFLYSPTTDU');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('CFLYSPTTDU'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('CFLYSPTTDU');
}
}
}
SetActiveField(Ctrl('CFLYSPTTDU'),false);
e=(Ne(e,null)?e:window.event);
return Set_darett(HtW(Ctrl('CFLYSPTTDU').value,'D'),null,e) && dateisok;
}
function CFLYSPTTDU_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('CFLYSPTTDU'))) {
DisplayErrorMessage();
}
if (Ne(_tracker.ctrl,Ctrl('CFLYSPTTDU'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('CFLYSPTTDU').value=WtH(w_darett,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
}
m_oEnteredInDate=Ctrl('CFLYSPTTDU');
SetActiveField(Ctrl('CFLYSPTTDU'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('CFLYSPTTDU'),e);
}
function CFLYSPTTDU_ZOOM_Click() {
LaunchCalendar(Ctrl('CFLYSPTTDU'));
}
function DIUBYKKRGY_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('DIUBYKKRGY'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('DIUBYKKRGY').value=ApplyPictureToDate(Ctrl('DIUBYKKRGY').value,TranslatePicture(datePattern),'DIUBYKKRGY');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('DIUBYKKRGY'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('DIUBYKKRGY');
}
}
}
SetActiveField(Ctrl('DIUBYKKRGY'),false);
e=(Ne(e,null)?e:window.event);
return Set_a_rett(HtW(Ctrl('DIUBYKKRGY').value,'D'),null,e) && dateisok;
}
function DIUBYKKRGY_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('DIUBYKKRGY'))) {
DisplayErrorMessage();
}
if (Ne(_tracker.ctrl,Ctrl('DIUBYKKRGY'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('DIUBYKKRGY').value=WtH(w_a_rett,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
}
m_oEnteredInDate=Ctrl('DIUBYKKRGY');
SetActiveField(Ctrl('DIUBYKKRGY'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('DIUBYKKRGY'),e);
}
function DIUBYKKRGY_ZOOM_Click() {
LaunchCalendar(Ctrl('DIUBYKKRGY'));
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
if(c=Ctrl('LPTSLAVIAK')) c.onclick=LPTSLAVIAK_Valid;
if(c=Ctrl('LPTSLAVIAK')) c.onfocus=LPTSLAVIAK_OnFocus;
if(c=Ctrl('LPTSLAVIAK')) c.onblur=LPTSLAVIAK_OnBlur;
if(c=Ctrl('KHPXTNGSFO')) c.onclick=KHPXTNGSFO_Valid;
if(c=Ctrl('KHPXTNGSFO')) c.onfocus=KHPXTNGSFO_OnFocus;
if(c=Ctrl('KHPXTNGSFO')) c.onblur=KHPXTNGSFO_OnBlur;
if(c=Ctrl('FSXHJAAZGG')) c.onblur=FSXHJAAZGG_Valid;
if(c=Ctrl('FSXHJAAZGG')) c.onfocus=FSXHJAAZGG_OnFocus;
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
if(c=Ctrl('FSXHJAAZGG')) c.onkeypress=CheckDateChar;
}
if(c=Ctrl('CLVVMIYSQG')) c.onblur=CLVVMIYSQG_Valid;
if(c=Ctrl('CLVVMIYSQG')) c.onfocus=CLVVMIYSQG_OnFocus;
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
if(c=Ctrl('CLVVMIYSQG')) c.onkeypress=CheckDateChar;
}
if(c=Ctrl('CFLYSPTTDU')) c.onblur=CFLYSPTTDU_Valid;
if(c=Ctrl('CFLYSPTTDU')) c.onfocus=CFLYSPTTDU_OnFocus;
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
if(c=Ctrl('CFLYSPTTDU')) c.onkeypress=CheckDateChar;
}
if(c=Ctrl('DIUBYKKRGY')) c.onblur=DIUBYKKRGY_Valid;
if(c=Ctrl('DIUBYKKRGY')) c.onfocus=DIUBYKKRGY_OnFocus;
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
if(c=Ctrl('DIUBYKKRGY')) c.onkeypress=CheckDateChar;
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
FocusFirstComponent.otherwise={"page_1":["LPTSLAVIAK"]};
function Help() {
windowOpenForeground('../doc/arpg_scaricodati_delope_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_iniz=a[0];
w_seco=a[1];
w_dadata=a[2];
w_a_data=a[3];
w_datpri=a[4];
w_datseci=a[5];
w_datsecf=a[6];
w_darett=a[7];
w_a_rett=a[8];
w_datprf=a[9];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_scaricodati_delope',m_cSelectedPage);
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
l_bEnabled= ! (Ne(w_iniz,'S'));
SetDisabled(Ctrl('PSAHIDGTWE'),l_bEnabled);
l_bEnabled= ! (Ne(w_iniz,'S'));
SetDisabled(Ctrl('ALQVOOWZEV'),l_bEnabled);
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
function Set_iniz(ctrlValue,kmode,e) {
if (Ne(w_iniz,ctrlValue)) {
var ctl = _GetCtl(e,'LPTSLAVIAK');
if (_tracker.goon(ctl,ctrlValue)) {
w_iniz=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('LPTSLAVIAK',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_seco(ctrlValue,kmode,e) {
if (Ne(w_seco,ctrlValue)) {
var ctl = _GetCtl(e,'KHPXTNGSFO');
if (_tracker.goon(ctl,ctrlValue)) {
w_seco=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('KHPXTNGSFO',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_dadata(ctrlValue,kmode,e) {
if (Ne(w_dadata,ctrlValue)) {
var ctl = _GetCtl(e,'FSXHJAAZGG');
if (_tracker.goon(ctl,ctrlValue)) {
w_dadata=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FSXHJAAZGG',0);
if (l_bResult) {
l_bResult=Gt(w_dadata,CharToDate('20070430'));
if ( ! (l_bResult)) {
m_nLastError=2;
m_cLastWorkVarErrorMsg='dadata';
m_cLastMsgError=AlertErrorMessage('1345161769');
}
if ( ! (l_bResult)) {
w_dadata=HtW('','D');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D')));
} else {
_ResetTracker();
}
return l_bResult;
} else {
ctl.value=WtH(NullDate(),'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
_ResetTracker();
return true;
}
}
return true;
}
function Set_a_data(ctrlValue,kmode,e) {
if (Ne(w_a_data,ctrlValue)) {
var ctl = _GetCtl(e,'CLVVMIYSQG');
if (_tracker.goon(ctl,ctrlValue)) {
w_a_data=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CLVVMIYSQG',0);
if (l_bResult) {
l_bResult=Gt(w_a_data,w_dadata);
if ( ! (l_bResult)) {
m_nLastError=2;
m_cLastWorkVarErrorMsg='a_data';
m_cLastMsgError=AlertErrorMessage('10119011931');
}
if ( ! (l_bResult)) {
w_a_data=HtW('','D');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D')));
} else {
_ResetTracker();
}
return l_bResult;
} else {
ctl.value=WtH(NullDate(),'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
_ResetTracker();
return true;
}
}
return true;
}
function Set_a_rett(ctrlValue,kmode,e) {
if (Ne(w_a_rett,ctrlValue)) {
var ctl = _GetCtl(e,'DIUBYKKRGY');
if (_tracker.goon(ctl,ctrlValue)) {
w_a_rett=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('DIUBYKKRGY',0);
if (l_bResult) {
l_bResult=Gt(w_a_rett,w_darett);
if ( ! (l_bResult)) {
m_nLastError=2;
m_cLastWorkVarErrorMsg='a_rett';
m_cLastMsgError=AlertErrorMessage('10119011931');
}
if ( ! (l_bResult)) {
w_a_rett=HtW('','D');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D')));
} else {
_ResetTracker();
}
return l_bResult;
} else {
ctl.value=WtH(NullDate(),'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
_ResetTracker();
return true;
}
}
return true;
}
function Set_darett(ctrlValue,kmode,e) {
if (Ne(w_darett,ctrlValue)) {
var ctl = _GetCtl(e,'CFLYSPTTDU');
if (_tracker.goon(ctl,ctrlValue)) {
w_darett=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CFLYSPTTDU',0);
if (l_bResult) {
l_bResult=Gt(w_darett,CharToDate('20070430'));
if ( ! (l_bResult)) {
m_nLastError=2;
m_cLastWorkVarErrorMsg='darett';
m_cLastMsgError=AlertErrorMessage('1345161769');
}
if ( ! (l_bResult)) {
w_darett=HtW('','D');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D')));
} else {
_ResetTracker();
}
return l_bResult;
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
w_datpri=(Eq(w_iniz,'S')?CharToDate('20050101'):NullDate());
w_datseci=(Eq(w_seco,'S')?CharToDate('20080101'):NullDate());
w_datsecf=(Eq(w_seco,'S')?CharToDate('20080630'):NullDate());
w_datprf=(Eq(w_iniz,'S')?CharToDate('20071231'):NullDate());
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
if ( ! (_ChkObl('LPTSLAVIAK',1))) {
_SignErr('LPTSLAVIAK');
m_cLastWorkVarErrorMsg='iniz';
l_bResult=false;
w_iniz='N';
} else if ( ! (_ChkObl('KHPXTNGSFO',1))) {
_SignErr('KHPXTNGSFO');
m_cLastWorkVarErrorMsg='seco';
l_bResult=false;
w_seco='N';
} else if (( ! (_ChkObl('FSXHJAAZGG',1))) || ( ! (Gt(w_dadata,CharToDate('20070430'))))) {
_SignErr('FSXHJAAZGG','1345161769');
l_bResult=false;
w_dadata=HtW('','D');
} else if (( ! (_ChkObl('CLVVMIYSQG',1))) || ( ! (Gt(w_a_data,w_dadata)))) {
_SignErr('CLVVMIYSQG','10119011931');
l_bResult=false;
w_a_data=HtW('','D');
} else if (( ! (_ChkObl('CFLYSPTTDU',1))) || ( ! (Gt(w_darett,CharToDate('20070430'))))) {
_SignErr('CFLYSPTTDU','1345161769');
l_bResult=false;
w_darett=HtW('','D');
} else if (( ! (_ChkObl('DIUBYKKRGY',1))) || ( ! (Gt(w_a_rett,w_darett)))) {
_SignErr('DIUBYKKRGY','10119011931');
l_bResult=false;
w_a_rett=HtW('','D');
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('FSXHJAAZGG_ZOOM',lc)) {
return 0;
}
if (Eq('CLVVMIYSQG_ZOOM',lc)) {
return 0;
}
if (Eq('CFLYSPTTDU_ZOOM',lc)) {
return 0;
}
if (Eq('DIUBYKKRGY_ZOOM',lc)) {
return 0;
}
return -1;
}
function link_url(index) {
var l_oWv;
}
function FillWv() {
var l_oWv = InitWvApplet();
l_oWv.setValue('iniz',WtA(w_iniz,'C'));
l_oWv.setValue('seco',WtA(w_seco,'C'));
l_oWv.setValue('dadata',WtA(w_dadata,'D'));
l_oWv.setValue('a_data',WtA(w_a_data,'D'));
l_oWv.setValue('datpri',WtA(w_datpri,'D'));
l_oWv.setValue('datseci',WtA(w_datseci,'D'));
l_oWv.setValue('datsecf',WtA(w_datsecf,'D'));
l_oWv.setValue('darett',WtA(w_darett,'D'));
l_oWv.setValue('a_rett',WtA(w_a_rett,'D'));
l_oWv.setValue('datprf',WtA(w_datprf,'D'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["iniz","seco","dadata","a_data","datpri","datseci","datsecf","darett","a_rett","datprf"];
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
if (start && Eq(At(',iniz,',pseq),0)) {
w_iniz='N';
}
if (start && Eq(At(',seco,',pseq),0)) {
w_seco='N';
}
w_datpri=(Eq(w_iniz,'S')?CharToDate('20050101'):NullDate());
w_datseci=(Eq(w_seco,'S')?CharToDate('20080101'):NullDate());
w_datsecf=(Eq(w_seco,'S')?CharToDate('20080630'):NullDate());
w_datprf=(Eq(w_iniz,'S')?CharToDate('20071231'):NullDate());
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
_Obli('iniz',0,'LPTSLAVIAK',false)
_Obli('seco',0,'KHPXTNGSFO',false)
_Obli('dadata',2,'FSXHJAAZGG',false)
_Obli('a_data',2,'CLVVMIYSQG',false)
_Obli('a_rett',2,'DIUBYKKRGY',false)
_Obli('darett',2,'CFLYSPTTDU',false)
