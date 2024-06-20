function SetControlsValue() {
var c;
var c;
var tmp_FGMOCXNBFY = ToHTag(AsControlValue('<iframe width=\'655\' height=\'170\' id=\'elaborazione\'  name=\'elaborazione\' frameborder=\'1\'  border=\'1\' align=\'TOP\' marginwidth=\'1\' marginheight=\'1\'></iframe>'));
if (Ne(e_FGMOCXNBFY,tmp_FGMOCXNBFY)) {
if(c=Ctrl('FGMOCXNBFY')) c.innerHTML=tmp_FGMOCXNBFY;
e_FGMOCXNBFY=tmp_FGMOCXNBFY;
}
if(c=Ctrl('FSXHJAAZGG')) c.value = WtH(w_dadata,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('CLVVMIYSQG')) c.value = WtH(w_a_data,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('CFLYSPTTDU')) c.value = WtH(w_darett,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('DIUBYKKRGY')) c.value = WtH(w_a_rett,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('GTMJENMCMN')) c.value = WtH(w_anno,'N',4,0,'')
if(c=Ctrl('TCZMCNHUFI')) selectCombo(c,w_mese,'C')
var tmp_SSRCOAMDBL = ToHTag(AsControlValue('<iframe width=\'755\' height=\'150\' id =\'messaggi\' src=\'arpg_msg_import\' frameborder=\'1\'  border=\'1\' align=\'TOP\' marginwidth=\'1\' marginheight=\'1\'></iframe>'));
if (Ne(e_SSRCOAMDBL,tmp_SSRCOAMDBL)) {
if(c=Ctrl('SSRCOAMDBL')) c.innerHTML=tmp_SSRCOAMDBL;
e_SSRCOAMDBL=tmp_SSRCOAMDBL;
}
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay(Ctrl('FGMOCXNBFY'),true);
SetDisplay(Ctrl('JBNBDKBIAJ'),Eq(w_files,0));
HideUI();
}
HideUI.lblids["a_data"]=['LFJQIXRRKM'];
HideUI.lblids["anno"]=['YIXZTOKOBR'];
HideUI.lblids["dadata"]=['NOYEUIKFXN'];
HideUI.lblids["mese"]=['TTKGEZTDBH'];
function href_AJXISNWTIP() {
var action = (Eq(Left('centrale'+''+'?',20),'arpg_ricreafile_age?')?'query':'start');
SetHypPar('m_cAction',AsAppletValue(action));
SetHypPar('m_cMode',AsAppletValue('hyperlink'));
SendData(action,'centrale'+'',HParApplet().asString());
}
function NMNMXABGKO_Click() {
if ( ! (Empty(w_dadata)) &&  ! (Empty(w_a_data)) && Eq(w_bloccaedit,'N')) {
Elabora()
}
}
function ALQVOOWZEV_Click() {
if ( ! (Empty(w_darett)) &&  ! (Empty(w_a_rett)) && Eq(w_bloccaedit,'N')) {
Elabora2
}
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
function TCZMCNHUFI_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_mese(HtW(getComboValue(Ctrl('TCZMCNHUFI')),'C'),null,e);
}
function TCZMCNHUFI_OnFocus(e) {
SetActiveField(Ctrl('TCZMCNHUFI'),true);
}
function TCZMCNHUFI_OnBlur(e) {
SetActiveField(Ctrl('TCZMCNHUFI'),false);
}
function href_JBNBDKBIAJ() {
_modifyandopen('arpg_filesage'+'?m_cAction=start&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes,height=600,width=800',null)
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
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
if(c=Ctrl('GTMJENMCMN')) c.onblur=GTMJENMCMN_Valid;
if(c=Ctrl('GTMJENMCMN')) c.onfocus=GTMJENMCMN_OnFocus;
if(c=Ctrl('GTMJENMCMN')) c.onkeypress=CheckNum;
if(c=Ctrl('TCZMCNHUFI')) c.onchange=TCZMCNHUFI_Valid;
if(c=Ctrl('TCZMCNHUFI')) c.onfocus=TCZMCNHUFI_OnFocus;
if(c=Ctrl('TCZMCNHUFI')) c.onblur=TCZMCNHUFI_OnBlur;
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
FocusFirstComponent.otherwise={"page_1":["NMNMXABGKO","ALQVOOWZEV","CFLYSPTTDU","DIUBYKKRGY","GTMJENMCMN","TCZMCNHUFI"]};
function Help() {
windowOpenForeground('../doc/arpg_ricreafile_age_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_dadata=a[0];
w_a_data=a[1];
w_darett=a[2];
w_a_rett=a[3];
w_anno=a[4];
w_mese=a[5];
w_bloccaedit=a[6];
w_files=a[7];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_ricreafile_age',m_cSelectedPage);
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
l_bEnabled= ! ( ! (Empty(w_dadata)) &&  ! (Empty(w_a_data)) && Eq(w_bloccaedit,'N'));
SetDisabled(Ctrl('NMNMXABGKO'),l_bEnabled);
l_bEnabled= ! ( ! (Empty(w_darett)) &&  ! (Empty(w_a_rett)) && Eq(w_bloccaedit,'N'));
SetDisabled(Ctrl('ALQVOOWZEV'),l_bEnabled);
l_bEnabled= ! (Eq(w_bloccaedit,'N')) || IsDisabledByStateDriver('darett');
SetDisabled(Ctrl('CFLYSPTTDU'),l_bEnabled);
SetDisabled(Ctrl('CFLYSPTTDU_ZOOM'),l_bEnabled);
l_bEnabled= ! (Eq(w_bloccaedit,'N')) || IsDisabledByStateDriver('a_rett');
SetDisabled(Ctrl('DIUBYKKRGY'),l_bEnabled);
SetDisabled(Ctrl('DIUBYKKRGY_ZOOM'),l_bEnabled);
l_bEnabled= ! (Eq(w_bloccaedit,'N')) || IsDisabledByStateDriver('anno');
SetDisabled(Ctrl('GTMJENMCMN'),l_bEnabled);
l_bEnabled= ! (Eq(w_bloccaedit,'N')) || IsDisabledByStateDriver('mese');
SetDisabled(Ctrl('TCZMCNHUFI'),l_bEnabled);
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
l_bResult=Ge(w_anno,2008);
if ( ! (l_bResult)) {
m_nLastError=2;
m_cLastWorkVarErrorMsg='anno';
m_cLastMsgError=AlertErrorMessage('369093584');
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
function Set_mese(ctrlValue,kmode,e) {
if (Ne(w_mese,ctrlValue)) {
var ctl = _GetCtl(e,'TCZMCNHUFI');
if (_tracker.goon(ctl,ctrlValue)) {
w_mese=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('TCZMCNHUFI',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',2,0,'');
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
w_dadata=( ! (Empty(w_anno)) &&  ! (Empty(w_mese))?CharToDate(Str(w_anno,4,0)+w_mese+'01'):NullDate());
w_a_data=arfn_finemese(w_dadata);
w_files=arfn_filesage();
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
if ((Eq(w_bloccaedit,'N')) && (( ! (_ChkObl('CFLYSPTTDU',1))) || ( ! (Gt(w_darett,CharToDate('20070430')))))) {
_SignErr('CFLYSPTTDU','1345161769');
l_bResult=false;
w_darett=HtW('','D');
} else if ((Eq(w_bloccaedit,'N')) && (( ! (_ChkObl('DIUBYKKRGY',1))) || ( ! (Gt(w_a_rett,w_darett))))) {
_SignErr('DIUBYKKRGY','10119011931');
l_bResult=false;
w_a_rett=HtW('','D');
} else if ((Eq(w_bloccaedit,'N')) && (( ! (_ChkObl('GTMJENMCMN',1))) || ( ! (Ge(w_anno,2008))))) {
_SignErr('GTMJENMCMN','369093584');
l_bResult=false;
w_anno=HtW('','N');
} else if ((Eq(w_bloccaedit,'N')) && ( ! (_ChkObl('TCZMCNHUFI',1)))) {
_SignErr('TCZMCNHUFI');
m_cLastWorkVarErrorMsg='mese';
l_bResult=false;
w_mese=HtW('','C');
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
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
l_oWv.setValue('dadata',WtA(w_dadata,'D'));
l_oWv.setValue('a_data',WtA(w_a_data,'D'));
l_oWv.setValue('darett',WtA(w_darett,'D'));
l_oWv.setValue('a_rett',WtA(w_a_rett,'D'));
l_oWv.setValue('anno',WtA(w_anno,'N'));
l_oWv.setValue('mese',WtA(w_mese,'C'));
l_oWv.setValue('bloccaedit',WtA(w_bloccaedit,'C'));
l_oWv.setValue('files',WtA(w_files,'N'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["dadata","a_data","darett","a_rett","anno","mese","bloccaedit","files"];
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
}
}
m_bCalculating=true;
w_dadata=( ! (Empty(w_anno)) &&  ! (Empty(w_mese))?CharToDate(Str(w_anno,4,0)+w_mese+'01'):NullDate());
w_a_data=arfn_finemese(w_dadata);
if (start && Eq(At(',anno,',pseq),0)) {
w_anno=Year(SystemDate());
}
if (start && Eq(At(',bloccaedit,',pseq),0)) {
w_bloccaedit='N';
}
w_files=arfn_filesage();
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
_Obli('a_rett',2,'DIUBYKKRGY',false)
_Obli('anno',1,'GTMJENMCMN',false)
_Obli('darett',2,'CFLYSPTTDU',false)
_Obli('mese',0,'TCZMCNHUFI',true)
