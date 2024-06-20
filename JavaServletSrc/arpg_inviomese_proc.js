function SetControlsValue() {
var c;
var c;
var tmp_FGMOCXNBFY = ToHTag(AsControlValue('<iframe width=\'655\' height=\'170\' id=\'elaborazione\' name=\'elaborazione\' frameborder=\'1\'  border=\'1\' align=\'TOP\' marginwidth=\'1\' marginheight=\'1\'></iframe>'));
if (Ne(e_FGMOCXNBFY,tmp_FGMOCXNBFY)) {
if(c=Ctrl('FGMOCXNBFY')) c.innerHTML=tmp_FGMOCXNBFY;
e_FGMOCXNBFY=tmp_FGMOCXNBFY;
}
if(c=Ctrl('KKZCBLBTXS')) c.value = WtH(w_dadatag,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('VYZOCFOMVY')) c.value = WtH(w_a_datag,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('YBFXTFUIXK')) ChkboxCheckUncheck(c,'S',w_flgglob)
if(c=Ctrl('YBFXTFUIXK')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('LPTSLAVIAK')) ChkboxCheckUncheck(c,'S',w_iniz)
if(c=Ctrl('LPTSLAVIAK')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('KHPXTNGSFO')) ChkboxCheckUncheck(c,'S',w_seco)
if(c=Ctrl('KHPXTNGSFO')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('FSXHJAAZGG')) c.value = WtH(w_dadata,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('CLVVMIYSQG')) c.value = WtH(w_a_data,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
var tmp_JWPQTLBZNU = ToHTag(AsControlValue(w__errore));
if (Ne(e_JWPQTLBZNU,tmp_JWPQTLBZNU)) {
if(c=Ctrl('JWPQTLBZNU')) c.innerHTML=tmp_JWPQTLBZNU;
e_JWPQTLBZNU=tmp_JWPQTLBZNU;
}
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay(Ctrl('FGMOCXNBFY'),true);
SetDisplay(Ctrl('KKZCBLBTXS'),Eq(w_flgglob,'N') || IsHiddenByStateDriver('dadatag'));
SetDisplay(Ctrl('VYZOCFOMVY'),Eq(w_flgglob,'N') || IsHiddenByStateDriver('a_datag'));
SetDisplay(Ctrl('VYZOCFOMVY_ZOOM'),Eq(w_flgglob,'N'));
SetDisplay(Ctrl('HDISNPUSEX'),Eq(w_flgglob,'N'));
SetDisplay(Ctrl('GEDJGVMCKZ'),Eq(w_bloccaedit,'S'));
SetDisplay(Ctrl('AJXISNWTIP'),Eq(w_bloccaedit,'S'));
SetDisplay(Ctrl('VYDKACCZUQ'),Eq(w_flgglob,'N'));
SetDisplay(Ctrl('ZPTLZODLSY'),Eq(w_flgglob,'N'));
HideUI();
}
HideUI.lblids["a_data"]=['LFJQIXRRKM'];
HideUI.lblids["a_datag"]=['ZPTLZODLSY'];
function VYZOCFOMVY_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('VYZOCFOMVY'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('VYZOCFOMVY').value=ApplyPictureToDate(Ctrl('VYZOCFOMVY').value,TranslatePicture(datePattern),'VYZOCFOMVY');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('VYZOCFOMVY'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('VYZOCFOMVY');
}
}
}
SetActiveField(Ctrl('VYZOCFOMVY'),false);
e=(Ne(e,null)?e:window.event);
return Set_a_datag(HtW(Ctrl('VYZOCFOMVY').value,'D'),null,e) && dateisok;
}
function VYZOCFOMVY_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('VYZOCFOMVY'))) {
DisplayErrorMessage();
}
if (Ne(_tracker.ctrl,Ctrl('VYZOCFOMVY'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('VYZOCFOMVY').value=WtH(w_a_datag,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
}
m_oEnteredInDate=Ctrl('VYZOCFOMVY');
SetActiveField(Ctrl('VYZOCFOMVY'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('VYZOCFOMVY'),e);
}
function VYZOCFOMVY_ZOOM_Click() {
LaunchCalendar(Ctrl('VYZOCFOMVY'));
}
function href_HDISNPUSEX() {
SetLocationHref(null,'arrt_inviomese_globale'+'?m_cAction=start&m_cMode=hyperlink','elaborazione')
}
function YBFXTFUIXK_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_flgglob(ChkboxValueAssign(Ctrl('YBFXTFUIXK'),'S','N','C',1,0,''),null,e);
}
function YBFXTFUIXK_OnFocus(e) {
SetActiveField(Ctrl('YBFXTFUIXK'),true);
}
function YBFXTFUIXK_OnBlur(e) {
SetActiveField(Ctrl('YBFXTFUIXK'),false);
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
function href_GEDJGVMCKZ() {
Elabora()
}
function href_AJXISNWTIP() {
SetLocationHref(window.location,ToResource('jsp/start_page_logo_portlet.jsp'+'')+'')
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
if(c=Ctrl('VYZOCFOMVY')) c.onblur=VYZOCFOMVY_Valid;
if(c=Ctrl('VYZOCFOMVY')) c.onfocus=VYZOCFOMVY_OnFocus;
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
if(c=Ctrl('VYZOCFOMVY')) c.onkeypress=CheckDateChar;
}
if(c=Ctrl('YBFXTFUIXK')) c.onclick=YBFXTFUIXK_Valid;
if(c=Ctrl('YBFXTFUIXK')) c.onfocus=YBFXTFUIXK_OnFocus;
if(c=Ctrl('YBFXTFUIXK')) c.onblur=YBFXTFUIXK_OnBlur;
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
}
}
function NotifyEvent(p_cEvent) {
var old_c;
if (Ne(typeof(w_Messaggi),'undefined')) {
w_Messaggi.raiseEvent('arpg_inviomese_'+Strtran(p_cEvent,' ','_'));
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
FocusFirstComponent.otherwise={"page_1":["VYZOCFOMVY","YBFXTFUIXK"]};
function Help() {
windowOpenForeground('../doc/arpg_inviomese_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_dadatag=a[0];
w_a_datag=a[1];
w_flgglob=a[2];
w_iniz=a[3];
w_seco=a[4];
w_dadata=a[5];
w_a_data=a[6];
w_datpri=a[7];
w_datseci=a[8];
w_datsecf=a[9];
w_datprf=a[10];
w_bloccaedit=a[11];
w__errore=a[12];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_inviomese',m_cSelectedPage);
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
l_bEnabled= ! (Eq(w_bloccaedit,'N')) || IsDisabledByStateDriver('a_datag');
SetDisabled(Ctrl('VYZOCFOMVY'),l_bEnabled);
SetDisabled(Ctrl('VYZOCFOMVY_ZOOM'),l_bEnabled);
l_bEnabled= ! (Eq(w_bloccaedit,'N')) || IsDisabledByStateDriver('iniz');
SetDisabled(Ctrl('LPTSLAVIAK'),l_bEnabled);
l_bEnabled= ! (Eq(w_bloccaedit,'N')) || IsDisabledByStateDriver('seco');
SetDisabled(Ctrl('KHPXTNGSFO'),l_bEnabled);
l_bEnabled= ! (Eq(w_bloccaedit,'N')) || IsDisabledByStateDriver('dadata');
SetDisabled(Ctrl('FSXHJAAZGG'),l_bEnabled);
SetDisabled(Ctrl('FSXHJAAZGG_ZOOM'),l_bEnabled);
l_bEnabled= ! (Eq(w_bloccaedit,'N')) || IsDisabledByStateDriver('a_data');
SetDisabled(Ctrl('CLVVMIYSQG'),l_bEnabled);
SetDisabled(Ctrl('CLVVMIYSQG_ZOOM'),l_bEnabled);
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
function Set_a_datag(ctrlValue,kmode,e) {
if (Ne(w_a_datag,ctrlValue)) {
var ctl = _GetCtl(e,'VYZOCFOMVY');
if (_tracker.goon(ctl,ctrlValue)) {
w_a_datag=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VYZOCFOMVY',0);
if (l_bResult) {
l_bResult=Gt(w_a_datag,w_dadatag);
if ( ! (l_bResult)) {
m_nLastError=2;
m_cLastWorkVarErrorMsg='a_datag';
m_cLastMsgError=AlertErrorMessage('10119011931');
}
if ( ! (l_bResult)) {
w_a_datag=HtW('','D');
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
function Set_flgglob(ctrlValue,kmode,e) {
if (Ne(w_flgglob,ctrlValue)) {
var ctl = _GetCtl(e,'YBFXTFUIXK');
if (_tracker.goon(ctl,ctrlValue)) {
w_flgglob=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YBFXTFUIXK',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
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
function Calculate() {
var l_bTmpRes;
var l_bResult = true;
m_bCalculating=true;
w_dadatag=CharToDate('20050101');
w_datpri=(Eq(w_iniz,'S')?CharToDate('20061231'):NullDate());
w_datseci=(Eq(w_seco,'S')?CharToDate('20070101'):NullDate());
w_datsecf=(Eq(w_seco,'S')?CharToDate('20070430'):NullDate());
w_datprf=(Eq(w_iniz,'S')?CharToDate('20050101'):NullDate());
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
if ((Eq(w_bloccaedit,'N')) && (( ! (_ChkObl('VYZOCFOMVY',1))) || ( ! (Gt(w_a_datag,w_dadatag))))) {
_SignErr('VYZOCFOMVY','10119011931');
l_bResult=false;
w_a_datag=HtW('','D');
} else if ( ! (_ChkObl('YBFXTFUIXK',1))) {
_SignErr('YBFXTFUIXK');
m_cLastWorkVarErrorMsg='flgglob';
l_bResult=false;
w_flgglob='N';
} else if ((Eq(w_bloccaedit,'N')) && ( ! (_ChkObl('LPTSLAVIAK',1)))) {
_SignErr('LPTSLAVIAK');
m_cLastWorkVarErrorMsg='iniz';
l_bResult=false;
w_iniz='N';
} else if ((Eq(w_bloccaedit,'N')) && ( ! (_ChkObl('KHPXTNGSFO',1)))) {
_SignErr('KHPXTNGSFO');
m_cLastWorkVarErrorMsg='seco';
l_bResult=false;
w_seco='N';
} else if ((Eq(w_bloccaedit,'N')) && (( ! (_ChkObl('FSXHJAAZGG',1))) || ( ! (Gt(w_dadata,CharToDate('20070430')))))) {
_SignErr('FSXHJAAZGG','1345161769');
l_bResult=false;
w_dadata=HtW('','D');
} else if ((Eq(w_bloccaedit,'N')) && (( ! (_ChkObl('CLVVMIYSQG',1))) || ( ! (Gt(w_a_data,w_dadata))))) {
_SignErr('CLVVMIYSQG','10119011931');
l_bResult=false;
w_a_data=HtW('','D');
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('VYZOCFOMVY_ZOOM',lc)) {
return 0;
}
if (Eq('FSXHJAAZGG_ZOOM',lc)) {
return 0;
}
if (Eq('CLVVMIYSQG_ZOOM',lc)) {
return 0;
}
return -1;
}
function link_url(index) {
var l_oWv;
}
function FillWv() {
var l_oWv = InitWvApplet();
l_oWv.setValue('dadatag',WtA(w_dadatag,'D'));
l_oWv.setValue('a_datag',WtA(w_a_datag,'D'));
l_oWv.setValue('flgglob',WtA(w_flgglob,'C'));
l_oWv.setValue('iniz',WtA(w_iniz,'C'));
l_oWv.setValue('seco',WtA(w_seco,'C'));
l_oWv.setValue('dadata',WtA(w_dadata,'D'));
l_oWv.setValue('a_data',WtA(w_a_data,'D'));
l_oWv.setValue('datpri',WtA(w_datpri,'D'));
l_oWv.setValue('datseci',WtA(w_datseci,'D'));
l_oWv.setValue('datsecf',WtA(w_datsecf,'D'));
l_oWv.setValue('datprf',WtA(w_datprf,'D'));
l_oWv.setValue('bloccaedit',WtA(w_bloccaedit,'C'));
l_oWv.setValue('_errore',WtA(w__errore,'C'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["dadatag","a_datag","flgglob","iniz","seco","dadata","a_data","datpri","datseci","datsecf","datprf","bloccaedit","_errore"];
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
if (Eq(w_bloccaedit,'N') && Ne(opener.w_bloccaedit,null)) {
TransferBetweenWindows(opener,'w_bloccaedit','w_bloccaedit');
}
if (Eq(w__errore,'') && Ne(opener.w__errore,null)) {
TransferBetweenWindows(opener,'w__errore','w__errore');
}
}
}
m_bCalculating=true;
w_dadatag=CharToDate('20050101');
if (start && Eq(At(',flgglob,',pseq),0)) {
w_flgglob='N';
}
if (start && Eq(At(',iniz,',pseq),0)) {
w_iniz='N';
}
if (start && Eq(At(',seco,',pseq),0)) {
w_seco='N';
}
w_datpri=(Eq(w_iniz,'S')?CharToDate('20061231'):NullDate());
w_datseci=(Eq(w_seco,'S')?CharToDate('20070101'):NullDate());
w_datsecf=(Eq(w_seco,'S')?CharToDate('20070430'):NullDate());
w_datprf=(Eq(w_iniz,'S')?CharToDate('20050101'):NullDate());
if (start && Eq(At(',bloccaedit,',pseq),0)) {
w_bloccaedit='N';
}
if (start && Eq(At(',_errore,',pseq),0)) {
w__errore='';
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
_Obli('a_data',2,'CLVVMIYSQG',false)
_Obli('a_datag',2,'VYZOCFOMVY',false)
_Obli('flgglob',0,'YBFXTFUIXK',false)
_Obli('iniz',0,'LPTSLAVIAK',false)
_Obli('seco',0,'KHPXTNGSFO',false)
_Obli('dadata',2,'FSXHJAAZGG',false)
