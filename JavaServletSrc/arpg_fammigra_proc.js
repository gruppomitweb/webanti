function SetControlsValue() {
var c;
var c;
if(c=Ctrl('ZFBIYQMSFL')) c.value = WtH(w_nomefile,'C',100,0,'')
var tmp_TYIWXFLLFY = ToHTag(AsControlValue('<iframe width=\'750\' height=\'400\' id=\'elaborazione\'  name=\'elaborazione\' frameborder=\'1\'  border=\'1\' align=\'TOP\' marginwidth=\'1\' marginheight=\'1\'></iframe>'));
if (Ne(e_TYIWXFLLFY,tmp_TYIWXFLLFY)) {
if(c=Ctrl('TYIWXFLLFY')) c.innerHTML=tmp_TYIWXFLLFY;
e_TYIWXFLLFY=tmp_TYIWXFLLFY;
}
if(c=Ctrl('AQXZVBGZJZ')) c.value = WtH(w_dadata,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('IDCDUOALWU')) c.value = WtH(w_a_data,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('WBSZETAJRJ')) selectCombo(c,w_flgwrt,'C')
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay(Ctrl('XWPYHZIJDE'),true);
SetDisplay(Ctrl('ZBTTWAQZVY'),true);
SetDisplay(Ctrl('XURLGQZZMU'),true);
SetDisplay(Ctrl('AQXZVBGZJZ'),Eq(w_gFlgIPMT,'N') || IsHiddenByStateDriver('dadata'));
SetDisplay(Ctrl('AQXZVBGZJZ_ZOOM'),Eq(w_gFlgIPMT,'N'));
SetDisplay(Ctrl('GYZXKDQZMS'),Eq(w_gFlgIPMT,'N'));
SetDisplay(Ctrl('IDCDUOALWU'),Eq(w_gFlgIPMT,'N') || IsHiddenByStateDriver('a_data'));
SetDisplay(Ctrl('IDCDUOALWU_ZOOM'),Eq(w_gFlgIPMT,'N'));
SetDisplay(Ctrl('TGAUAWDVTR'),Eq(w_gFlgIPMT,'N'));
SetDisplay(Ctrl('UPTBMRNDAF'),Eq(w_gFlgIPMT,'N'));
HideUI();
}
HideUI.lblids["a_data"]=['TGAUAWDVTR'];
HideUI.lblids["dadata"]=['GYZXKDQZMS'];
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
_modifyandopen(ToResource('servlet/sp_huploadfile'+'?pDirectory='+URLenc('SID/MIGRA/ELB/'+LRTrim(w_gAzienda))+'&pAtExit='+URLenc('Return')+'&pVarReturn='+URLenc('nomefile')+'&m_cParameterSequence=pDirectory,pAtExit,pVarReturn')+'&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null)
}
function href_XWPYHZIJDE() {
SetLocationHref(null,'arrt_fammigra'+'?m_cAction=start&m_cMode=hyperlink','elaborazione')
}
function href_ZBTTWAQZVY() {
SetLocationHref(null,'arrt_fammigra_stp'+'?m_cAction=start&m_cMode=hyperlink','elaborazione')
}
function href_XURLGQZZMU() {
SetLocationHref(null,'arrt_fam_xls_esiti_sid'+'?m_cAction=start&m_cMode=hyperlink','elaborazione')
}
function AQXZVBGZJZ_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('AQXZVBGZJZ'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('AQXZVBGZJZ').value=ApplyPictureToDate(Ctrl('AQXZVBGZJZ').value,TranslatePicture(datePattern),'AQXZVBGZJZ');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('AQXZVBGZJZ'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('AQXZVBGZJZ');
}
}
}
SetActiveField(Ctrl('AQXZVBGZJZ'),false);
e=(Ne(e,null)?e:window.event);
return Set_dadata(HtW(Ctrl('AQXZVBGZJZ').value,'D'),null,e) && dateisok;
}
function AQXZVBGZJZ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('AQXZVBGZJZ'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('AQXZVBGZJZ').value=WtH(w_dadata,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('AQXZVBGZJZ');
SetActiveField(Ctrl('AQXZVBGZJZ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('AQXZVBGZJZ'),e);
}
function AQXZVBGZJZ_ZOOM_Click() {
LaunchCalendar(Ctrl('AQXZVBGZJZ'));
}
function IDCDUOALWU_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('IDCDUOALWU'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('IDCDUOALWU').value=ApplyPictureToDate(Ctrl('IDCDUOALWU').value,TranslatePicture(datePattern),'IDCDUOALWU');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('IDCDUOALWU'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('IDCDUOALWU');
}
}
}
SetActiveField(Ctrl('IDCDUOALWU'),false);
e=(Ne(e,null)?e:window.event);
return Set_a_data(HtW(Ctrl('IDCDUOALWU').value,'D'),null,e) && dateisok;
}
function IDCDUOALWU_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('IDCDUOALWU'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('IDCDUOALWU').value=WtH(w_a_data,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('IDCDUOALWU');
SetActiveField(Ctrl('IDCDUOALWU'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('IDCDUOALWU'),e);
}
function IDCDUOALWU_ZOOM_Click() {
LaunchCalendar(Ctrl('IDCDUOALWU'));
}
function WBSZETAJRJ_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_flgwrt(HtW(getComboValue(Ctrl('WBSZETAJRJ')),'C'),null,e);
}
function WBSZETAJRJ_OnFocus(e) {
SetActiveField(Ctrl('WBSZETAJRJ'),true);
}
function WBSZETAJRJ_OnBlur(e) {
SetActiveField(Ctrl('WBSZETAJRJ'),false);
}
function href_UPTBMRNDAF() {
Excel()
}
function href_GRHWBUMYYP() {
Stampa()
}
function href_AACUKDQANQ() {
Lancio()
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
if(c=Ctrl('ZFBIYQMSFL')) c.onblur=ZFBIYQMSFL_Valid;
if(c=Ctrl('ZFBIYQMSFL')) c.onfocus=ZFBIYQMSFL_OnFocus;
if(c=Ctrl('AQXZVBGZJZ')) c.onblur=AQXZVBGZJZ_Valid;
if(c=Ctrl('AQXZVBGZJZ')) c.onfocus=AQXZVBGZJZ_OnFocus;
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
if(c=Ctrl('AQXZVBGZJZ')) c.onkeypress=CheckDateChar;
}
if(c=Ctrl('IDCDUOALWU')) c.onblur=IDCDUOALWU_Valid;
if(c=Ctrl('IDCDUOALWU')) c.onfocus=IDCDUOALWU_OnFocus;
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
if(c=Ctrl('IDCDUOALWU')) c.onkeypress=CheckDateChar;
}
if(c=Ctrl('WBSZETAJRJ')) c.onchange=WBSZETAJRJ_Valid;
if(c=Ctrl('WBSZETAJRJ')) c.onfocus=WBSZETAJRJ_OnFocus;
if(c=Ctrl('WBSZETAJRJ')) c.onblur=WBSZETAJRJ_OnBlur;
}
}
function NotifyEvent(p_cEvent) {
var old_c;
if (Ne(typeof(w_pMsg),'undefined')) {
w_pMsg.raiseEvent('arpg_fammigra_'+Strtran(p_cEvent,' ','_'));
}
if (Ne(typeof(w_pLog),'undefined')) {
w_pLog.raiseEvent('arpg_fammigra_'+Strtran(p_cEvent,' ','_'));
}
if (Ne(typeof(w_ListaFile),'undefined')) {
w_ListaFile.raiseEvent('arpg_fammigra_'+Strtran(p_cEvent,' ','_'));
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
windowOpenForeground('../doc/arpg_fammigra_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_gAzienda=a[1];
w_gDescAzi=a[2];
w_dadata=a[3];
w_a_data=a[4];
w_gFlgIPMT=a[5];
w_flgwrt=a[6];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_fammigra',m_cSelectedPage);
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
function Set_dadata(ctrlValue,kmode,e) {
if (Ne(w_dadata,ctrlValue)) {
var ctl = _GetCtl(e,'AQXZVBGZJZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_dadata=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('AQXZVBGZJZ',0);
DoUpdate(l_bResult);
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
var ctl = _GetCtl(e,'IDCDUOALWU');
if (_tracker.goon(ctl,ctrlValue)) {
w_a_data=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('IDCDUOALWU',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH(NullDate(),'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
_ResetTracker();
return true;
}
}
return true;
}
function Set_flgwrt(ctrlValue,kmode,e) {
if (Ne(w_flgwrt,ctrlValue)) {
var ctl = _GetCtl(e,'WBSZETAJRJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_flgwrt=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('WBSZETAJRJ',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',1,0,'');
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
} else if ( ! (_ChkObl('AQXZVBGZJZ',1))) {
_SignErr('AQXZVBGZJZ');
m_cLastWorkVarErrorMsg='10911214207';
l_bResult=false;
w_dadata=HtW('','D');
} else if ( ! (_ChkObl('IDCDUOALWU',1))) {
_SignErr('IDCDUOALWU');
m_cLastWorkVarErrorMsg='10911214207';
l_bResult=false;
w_a_data=HtW('','D');
} else if ( ! (_ChkObl('WBSZETAJRJ',1))) {
_SignErr('WBSZETAJRJ');
m_cLastWorkVarErrorMsg='flgwrt';
l_bResult=false;
w_flgwrt=HtW('','C');
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('AQXZVBGZJZ_ZOOM',lc)) {
return 0;
}
if (Eq('IDCDUOALWU_ZOOM',lc)) {
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
l_oWv.setValue('gAzienda',WtA(w_gAzienda,'C'));
l_oWv.setValue('gDescAzi',WtA(w_gDescAzi,'C'));
l_oWv.setValue('dadata',WtA(w_dadata,'D'));
l_oWv.setValue('a_data',WtA(w_a_data,'D'));
l_oWv.setValue('gFlgIPMT',WtA(w_gFlgIPMT,'C'));
l_oWv.setValue('flgwrt',WtA(w_flgwrt,'C'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["nomefile","gAzienda","gDescAzi","dadata","a_data","gFlgIPMT","flgwrt"];
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
}
}
m_bCalculating=true;
if (start && Eq(At(',flgwrt,',pseq),0)) {
w_flgwrt='M';
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
_Obli('dadata',2,'AQXZVBGZJZ',false,"10911214207")
_Obli('a_data',2,'IDCDUOALWU',false,"10911214207")
_Obli('flgwrt',0,'WBSZETAJRJ',false)
