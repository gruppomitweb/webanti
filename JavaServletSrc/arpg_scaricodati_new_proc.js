function SetControlsValue() {
var c;
var c;
var tmp_FGMOCXNBFY = ToHTag(AsControlValue('<iframe width=\'655\' height=\'170\' id=\'elaborazione\' name=\'elaborazione\' frameborder=\'1\'  border=\'1\' align=\'TOP\' marginwidth=\'1\' marginheight=\'1\'></iframe>'));
if (Ne(e_FGMOCXNBFY,tmp_FGMOCXNBFY)) {
if(c=Ctrl('FGMOCXNBFY')) c.innerHTML=tmp_FGMOCXNBFY;
e_FGMOCXNBFY=tmp_FGMOCXNBFY;
}
if(c=Ctrl('GTMJENMCMN')) c.value = WtH(w_anno,'N',4,0,'')
if(c=Ctrl('TCZMCNHUFI')) selectCombo(c,w_mese,'C')
if(c=Ctrl('CFLYSPTTDU')) c.value = WtH(w_darett,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('DIUBYKKRGY')) c.value = WtH(w_a_rett,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('FSXHJAAZGG')) c.value = WtH(w_dadata,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('CLVVMIYSQG')) c.value = WtH(w_a_data,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('MPIOZQPPPI')) c.value = WtH(w_CFINVIO,'C',16,0,'')
if(c=Ctrl('YFPMFPWESC')) c.value = WtH(w_CAFINVIO,'C',5,0,'')
if(c=Ctrl('HMYRBXBREF')) selectCombo(c,w_FILEINVIO,'C')
if(c=Ctrl('CQATNPZMEC')) c.value = WtH(w_DATAINVIO,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('XCZYKCMMXR')) ChkboxCheckUncheck(c,'S',w_sogest)
if(c=Ctrl('XCZYKCMMXR')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('MOHZUWAWZD')) ChkboxCheckUncheck(c,'S',w_mespre)
if(c=Ctrl('MOHZUWAWZD')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay(Ctrl('FGMOCXNBFY'),true);
HideUI();
}
HideUI.lblids["CAFINVIO"]=['LASRRWOCQH'];
HideUI.lblids["CFINVIO"]=['CTFPYTZIIH'];
HideUI.lblids["DATAINVIO"]=['FHSMWCMRII'];
HideUI.lblids["FILEINVIO"]=['HAINTPIJUS'];
HideUI.lblids["a_data"]=['LFJQIXRRKM'];
HideUI.lblids["anno"]=['YIXZTOKOBR'];
HideUI.lblids["dadata"]=['NOYEUIKFXN'];
HideUI.lblids["mese"]=['TTKGEZTDBH'];
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
function NMNMXABGKO_Click() {
if ( ! (Empty(w_dadata)) &&  ! (Empty(w_a_data)) && Eq(w_bloccaedit,'N')) {
Elabora()
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
function ALQVOOWZEV_Click() {
if ( ! (Empty(w_darett)) &&  ! (Empty(w_a_rett)) && Eq(w_bloccaedit,'N')) {
Elabora2()
}
}
function href_AJXISNWTIP() {
SetLocationHref(window.location,ToResource('jsp/start_page_logo_portlet.jsp'+'')+'')
}
function href_JBNBDKBIAJ() {
_modifyandopen('arpg_filesage'+'?m_cAction=start&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes,height=600,width=800',null)
}
function MPIOZQPPPI_Valid(e) {
SetActiveField(Ctrl('MPIOZQPPPI'),false);
e=(Ne(e,null)?e:window.event);
return Set_CFINVIO(HtW(Ctrl('MPIOZQPPPI').value,'C'),null,e);
}
function MPIOZQPPPI_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('MPIOZQPPPI'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('MPIOZQPPPI'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('MPIOZQPPPI'),e);
}
function YFPMFPWESC_Valid(e) {
SetActiveField(Ctrl('YFPMFPWESC'),false);
e=(Ne(e,null)?e:window.event);
return Set_CAFINVIO(HtW(Ctrl('YFPMFPWESC').value,'C'),null,e);
}
function YFPMFPWESC_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('YFPMFPWESC'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('YFPMFPWESC'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('YFPMFPWESC'),e);
}
function HMYRBXBREF_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_FILEINVIO(HtW(getComboValue(Ctrl('HMYRBXBREF')),'C'),null,e);
}
function HMYRBXBREF_OnFocus(e) {
SetActiveField(Ctrl('HMYRBXBREF'),true);
}
function HMYRBXBREF_OnBlur(e) {
SetActiveField(Ctrl('HMYRBXBREF'),false);
}
function CQATNPZMEC_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('CQATNPZMEC'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('CQATNPZMEC').value=ApplyPictureToDate(Ctrl('CQATNPZMEC').value,TranslatePicture(datePattern),'CQATNPZMEC');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('CQATNPZMEC'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('CQATNPZMEC');
}
}
}
SetActiveField(Ctrl('CQATNPZMEC'),false);
e=(Ne(e,null)?e:window.event);
return Set_DATAINVIO(HtW(Ctrl('CQATNPZMEC').value,'D'),null,e) && dateisok;
}
function CQATNPZMEC_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('CQATNPZMEC'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('CQATNPZMEC').value=WtH(w_DATAINVIO,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('CQATNPZMEC');
SetActiveField(Ctrl('CQATNPZMEC'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('CQATNPZMEC'),e);
}
function href_MPCMAMHQST() {
var l_oWv = InitWvApplet();
l_oWv.setValue('ReportName',AsAppletValue('arrp_stp_fileage'));
l_oWv.setValue('outputFormat',AsAppletValue('PDF'));
l_oWv.setValue('rotation',AsAppletValue('LANDSCAPE'));
l_oWv.setValue('DescAzi',AsAppletValue(w_gDescAzi));
l_oWv.setValue('cfinvio',AsAppletValue(w_CFINVIO));
l_oWv.setValue('cafinvio',AsAppletValue(w_CAFINVIO));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('ReportName,outputFormat,rotation,DescAzi,cfinvio,cafinvio'));
_modifyandopen('Report'+'?m_cWv='+URLenc(l_oWv.asString())+'&m_cAction=start&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes,height=600,width=800',null)
}
function XCZYKCMMXR_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_sogest(ChkboxValueAssign(Ctrl('XCZYKCMMXR'),'S','N','C',1,0,''),null,e);
}
function XCZYKCMMXR_OnFocus(e) {
SetActiveField(Ctrl('XCZYKCMMXR'),true);
}
function XCZYKCMMXR_OnBlur(e) {
SetActiveField(Ctrl('XCZYKCMMXR'),false);
}
function MOHZUWAWZD_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_mespre(ChkboxValueAssign(Ctrl('MOHZUWAWZD'),'S','N','C',1,0,''),null,e);
}
function MOHZUWAWZD_OnFocus(e) {
SetActiveField(Ctrl('MOHZUWAWZD'),true);
}
function MOHZUWAWZD_OnBlur(e) {
SetActiveField(Ctrl('MOHZUWAWZD'),false);
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
if(c=Ctrl('GTMJENMCMN')) c.onblur=GTMJENMCMN_Valid;
if(c=Ctrl('GTMJENMCMN')) c.onfocus=GTMJENMCMN_OnFocus;
if(c=Ctrl('GTMJENMCMN')) c.onkeypress=CheckNum;
if(c=Ctrl('TCZMCNHUFI')) c.onchange=TCZMCNHUFI_Valid;
if(c=Ctrl('TCZMCNHUFI')) c.onfocus=TCZMCNHUFI_OnFocus;
if(c=Ctrl('TCZMCNHUFI')) c.onblur=TCZMCNHUFI_OnBlur;
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
if(c=Ctrl('MPIOZQPPPI')) c.onblur=MPIOZQPPPI_Valid;
if(c=Ctrl('MPIOZQPPPI')) c.onfocus=MPIOZQPPPI_OnFocus;
if(c=Ctrl('YFPMFPWESC')) c.onblur=YFPMFPWESC_Valid;
if(c=Ctrl('YFPMFPWESC')) c.onfocus=YFPMFPWESC_OnFocus;
if(c=Ctrl('HMYRBXBREF')) c.onchange=HMYRBXBREF_Valid;
if(c=Ctrl('HMYRBXBREF')) c.onfocus=HMYRBXBREF_OnFocus;
if(c=Ctrl('HMYRBXBREF')) c.onblur=HMYRBXBREF_OnBlur;
if(c=Ctrl('CQATNPZMEC')) c.onblur=CQATNPZMEC_Valid;
if(c=Ctrl('CQATNPZMEC')) c.onfocus=CQATNPZMEC_OnFocus;
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
if(c=Ctrl('CQATNPZMEC')) c.onkeypress=CheckDateChar;
}
if(c=Ctrl('XCZYKCMMXR')) c.onclick=XCZYKCMMXR_Valid;
if(c=Ctrl('XCZYKCMMXR')) c.onfocus=XCZYKCMMXR_OnFocus;
if(c=Ctrl('XCZYKCMMXR')) c.onblur=XCZYKCMMXR_OnBlur;
if(c=Ctrl('MOHZUWAWZD')) c.onclick=MOHZUWAWZD_Valid;
if(c=Ctrl('MOHZUWAWZD')) c.onfocus=MOHZUWAWZD_OnFocus;
if(c=Ctrl('MOHZUWAWZD')) c.onblur=MOHZUWAWZD_OnBlur;
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
FocusFirstComponent.otherwise={"page_1":["GTMJENMCMN","TCZMCNHUFI","NMNMXABGKO","CFLYSPTTDU","DIUBYKKRGY","ALQVOOWZEV","MPIOZQPPPI"]};
function Help() {
windowOpenForeground('../doc/arpg_scaricodati_new_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_anno=a[0];
w_mese=a[1];
w_darett=a[2];
w_a_rett=a[3];
w_dadata=a[4];
w_a_data=a[5];
w_bloccaedit=a[6];
w_files=a[7];
w_gIntemediario=a[8];
w_CFINVIO=a[9];
w_CAFINVIO=a[10];
w_FILEINVIO=a[11];
w_DATAINVIO=a[12];
w_gDescAzi=a[13];
w_sogest=a[14];
w_mespre=a[15];
o_gIntemediario=w_gIntemediario[1];
w_gIntemediario=w_gIntemediario[0];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_scaricodati_new',m_cSelectedPage);
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
l_bEnabled= ! (Eq(w_bloccaedit,'N')) || IsDisabledByStateDriver('anno');
SetDisabled(Ctrl('GTMJENMCMN'),l_bEnabled);
l_bEnabled= ! (Eq(w_bloccaedit,'N')) || IsDisabledByStateDriver('mese');
SetDisabled(Ctrl('TCZMCNHUFI'),l_bEnabled);
l_bEnabled= ! ( ! (Empty(w_dadata)) &&  ! (Empty(w_a_data)) && Eq(w_bloccaedit,'N'));
SetDisabled(Ctrl('NMNMXABGKO'),l_bEnabled);
l_bEnabled= ! (Eq(w_bloccaedit,'N')) || IsDisabledByStateDriver('darett');
SetDisabled(Ctrl('CFLYSPTTDU'),l_bEnabled);
SetDisabled(Ctrl('CFLYSPTTDU_ZOOM'),l_bEnabled);
l_bEnabled= ! (Eq(w_bloccaedit,'N')) || IsDisabledByStateDriver('a_rett');
SetDisabled(Ctrl('DIUBYKKRGY'),l_bEnabled);
SetDisabled(Ctrl('DIUBYKKRGY_ZOOM'),l_bEnabled);
l_bEnabled= ! ( ! (Empty(w_darett)) &&  ! (Empty(w_a_rett)) && Eq(w_bloccaedit,'N'));
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
l_bResult=Ge(w_anno,2007);
if ( ! (l_bResult)) {
m_nLastError=2;
m_cLastWorkVarErrorMsg='anno';
m_cLastMsgError=AlertErrorMessage('1966663129');
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
function Set_mese(ctrlValue,kmode,e) {
if (Ne(w_mese,ctrlValue)) {
var ctl = _GetCtl(e,'TCZMCNHUFI');
if (_tracker.goon(ctl,ctrlValue)) {
w_mese=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('TCZMCNHUFI',0);
if (l_bResult) {
l_bResult=((Eq(w_anno,2007) && Ge(w_mese,'05')) || Gt(w_anno,2007)?true:false);
if ( ! (l_bResult)) {
m_nLastError=2;
m_cLastWorkVarErrorMsg='mese';
m_cLastMsgError=AlertErrorMessage('11240429377');
}
if ( ! (l_bResult)) {
w_mese=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',2,0,''));
} else {
_ResetTracker();
}
return l_bResult;
} else {
ctl.value=WtH('','C',2,0,'');
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
m_cLastMsgError=AlertErrorMessage('799342670');
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
function Set_mespre(ctrlValue,kmode,e) {
if (Ne(w_mespre,ctrlValue)) {
var ctl = _GetCtl(e,'MOHZUWAWZD');
if (_tracker.goon(ctl,ctrlValue)) {
w_mespre=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MOHZUWAWZD',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_CFINVIO(ctrlValue,kmode,e) {
if (Ne(w_CFINVIO,ctrlValue)) {
var ctl = _GetCtl(e,'MPIOZQPPPI');
if (_tracker.goon(ctl,ctrlValue)) {
w_CFINVIO=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MPIOZQPPPI',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',16,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_CAFINVIO(ctrlValue,kmode,e) {
if (Ne(w_CAFINVIO,ctrlValue)) {
var ctl = _GetCtl(e,'YFPMFPWESC');
if (_tracker.goon(ctl,ctrlValue)) {
w_CAFINVIO=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YFPMFPWESC',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',5,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_DATAINVIO(ctrlValue,kmode,e) {
if (Ne(w_DATAINVIO,ctrlValue)) {
var ctl = _GetCtl(e,'CQATNPZMEC');
if (_tracker.goon(ctl,ctrlValue)) {
w_DATAINVIO=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CQATNPZMEC',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH(NullDate(),'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
_ResetTracker();
return true;
}
}
return true;
}
function Set_FILEINVIO(ctrlValue,kmode,e) {
if (Ne(w_FILEINVIO,ctrlValue)) {
var ctl = _GetCtl(e,'HMYRBXBREF');
if (_tracker.goon(ctl,ctrlValue)) {
w_FILEINVIO=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HMYRBXBREF',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_sogest(ctrlValue,kmode,e) {
if (Ne(w_sogest,ctrlValue)) {
var ctl = _GetCtl(e,'XCZYKCMMXR');
if (_tracker.goon(ctl,ctrlValue)) {
w_sogest=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XCZYKCMMXR',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
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
if ((Ne(o_gIntemediario,w_gIntemediario))) {
l_bTmpRes=Link_AHMXEPADOR(null);
}
// * --- Area Manuale = UI - Calculate
// * --- Fine Area Manuale
m_bCalculating=false;
}
function SaveDependsOn() {
o_gIntemediario=w_gIntemediario;
}
function SaveLabelDependsOn() {
}
function Link_AHMXEPADOR(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_gIntemediario);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODINTER',w_gIntemediario,11,0);
l_Appl.SetFields('CODINTER,CFINVIO,CAFINVIO,FILEINVIO,DATAINVIO');
l_Appl.SetTypes('C,C,C,C,D');
l_Appl.LinkTable('intermbo');
l_Appl.SetLinkzoom('armt_intermbo');
l_Appl.SetID('AHMXEPADOR');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_gIntemediario=l_Appl.GetStringValue('CODINTER',11,0);
w_CFINVIO=l_Appl.GetStringValue('CFINVIO',16,0);
w_CAFINVIO=l_Appl.GetStringValue('CAFINVIO',5,0);
w_FILEINVIO=l_Appl.GetStringValue('FILEINVIO',1,0);
w_DATAINVIO=l_Appl.GetDateValue('DATAINVIO',8,0);
w_DATAINVIO=DateFromApplet(w_DATAINVIO);
} else {
Link_AHMXEPADOR_Blank();
}
if ( ! (l_bResult)) {
m_nLastError=3;
m_cLastWorkVarErrorMsg='';
if (Lt(l_nRec,0)) {
m_cLastMsgError=Translate('MSG_CONNECT_SERVER');
}
}
return l_bResult;
}
function Link_AHMXEPADOR_Blank() {
w_gIntemediario='';
w_CFINVIO='';
w_CAFINVIO='';
w_FILEINVIO='';
w_DATAINVIO=NullDate();
}
function LOpt_AHMXEPADOR() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('intermbo','C'));
l_oWv.setValue('Linkzoomprg',WtA('armt_intermbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODINTER','C'));
l_oWv.setValue('LinkedField',WtA('CODINTER','C'));
l_oWv.setValue('UID',WtA('AHMXEPADOR','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['AHMXEPADOR'][1],'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
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
if ((Eq(w_bloccaedit,'N')) && (( ! (_ChkObl('GTMJENMCMN',1))) || ( ! (Ge(w_anno,2007))))) {
_SignErr('GTMJENMCMN','1966663129');
l_bResult=false;
w_anno=HtW('','N');
} else if ((Eq(w_bloccaedit,'N')) && (( ! (_ChkObl('TCZMCNHUFI',1))) || ( ! (((Eq(w_anno,2007) && Ge(w_mese,'05')) || Gt(w_anno,2007)?true:false))))) {
_SignErr('TCZMCNHUFI','11240429377');
l_bResult=false;
w_mese=HtW('','C');
} else if ((Eq(w_bloccaedit,'N')) && (( ! (_ChkObl('CFLYSPTTDU',1))) || ( ! (Gt(w_darett,CharToDate('20070430')))))) {
_SignErr('CFLYSPTTDU','1345161769');
l_bResult=false;
w_darett=HtW('','D');
} else if ((Eq(w_bloccaedit,'N')) && (( ! (_ChkObl('DIUBYKKRGY',1))) || ( ! (Gt(w_a_rett,w_darett))))) {
_SignErr('DIUBYKKRGY','799342670');
l_bResult=false;
w_a_rett=HtW('','D');
} else if ( ! (_ChkObl('MPIOZQPPPI',1))) {
_SignErr('MPIOZQPPPI');
m_cLastWorkVarErrorMsg='11949617228';
l_bResult=false;
w_CFINVIO=HtW('','C');
} else if ( ! (_ChkObl('YFPMFPWESC',1))) {
_SignErr('YFPMFPWESC');
m_cLastWorkVarErrorMsg='346962755';
l_bResult=false;
w_CAFINVIO=HtW('','C');
} else if ( ! (_ChkObl('HMYRBXBREF',1))) {
_SignErr('HMYRBXBREF');
m_cLastWorkVarErrorMsg='603506633';
l_bResult=false;
w_FILEINVIO=HtW('','C');
} else if ( ! (_ChkObl('CQATNPZMEC',1))) {
_SignErr('CQATNPZMEC');
m_cLastWorkVarErrorMsg='1710843353';
l_bResult=false;
w_DATAINVIO=HtW('','D');
} else if ( ! (_ChkObl('XCZYKCMMXR',1))) {
_SignErr('XCZYKCMMXR');
m_cLastWorkVarErrorMsg='sogest';
l_bResult=false;
w_sogest='N';
} else if ( ! (_ChkObl('MOHZUWAWZD',1))) {
_SignErr('MOHZUWAWZD');
m_cLastWorkVarErrorMsg='mespre';
l_bResult=false;
w_mespre='N';
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
l_oWv.setValue('anno',WtA(w_anno,'N'));
l_oWv.setValue('mese',WtA(w_mese,'C'));
l_oWv.setValue('darett',WtA(w_darett,'D'));
l_oWv.setValue('a_rett',WtA(w_a_rett,'D'));
l_oWv.setValue('dadata',WtA(w_dadata,'D'));
l_oWv.setValue('a_data',WtA(w_a_data,'D'));
l_oWv.setValue('bloccaedit',WtA(w_bloccaedit,'C'));
l_oWv.setValue('files',WtA(w_files,'N'));
l_oWv.setValue('gIntemediario',WtA(w_gIntemediario,'C'));
l_oWv.setValue('CFINVIO',WtA(w_CFINVIO,'C'));
l_oWv.setValue('CAFINVIO',WtA(w_CAFINVIO,'C'));
l_oWv.setValue('FILEINVIO',WtA(w_FILEINVIO,'C'));
l_oWv.setValue('DATAINVIO',WtA(w_DATAINVIO,'D'));
l_oWv.setValue('gDescAzi',WtA(w_gDescAzi,'C'));
l_oWv.setValue('sogest',WtA(w_sogest,'C'));
l_oWv.setValue('mespre',WtA(w_mespre,'C'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["anno","mese","darett","a_rett","dadata","a_data","bloccaedit","files","gIntemediario","CFINVIO","CAFINVIO","FILEINVIO","DATAINVIO","gDescAzi","sogest","mespre"];
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
if (start && Eq(At(',anno,',pseq),0)) {
w_anno=Year(SystemDate());
}
w_dadata=( ! (Empty(w_anno)) &&  ! (Empty(w_mese))?CharToDate(Str(w_anno,4,0)+w_mese+'01'):NullDate());
w_a_data=arfn_finemese(w_dadata);
if (start && Eq(At(',bloccaedit,',pseq),0)) {
w_bloccaedit='N';
}
w_files=arfn_filesage();
Link_AHMXEPADOR(null);
if (start && Eq(At(',sogest,',pseq),0)) {
w_sogest='N';
}
if (start && Eq(At(',mespre,',pseq),0)) {
w_mespre='S';
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
_Obli('anno',1,'GTMJENMCMN',false)
_Obli('mese',0,'TCZMCNHUFI',true,null,null,"11240429377")
_Obli('darett',2,'CFLYSPTTDU',false)
_Obli('a_rett',2,'DIUBYKKRGY',false)
_Obli('mespre',0,'MOHZUWAWZD',false)
_Obli('CFINVIO',0,'MPIOZQPPPI',false,"11949617228")
_Obli('CAFINVIO',0,'YFPMFPWESC',false,"346962755")
_Obli('DATAINVIO',2,'CQATNPZMEC',false,"1710843353")
_Obli('FILEINVIO',0,'HMYRBXBREF',false,"603506633")
_Obli('sogest',0,'XCZYKCMMXR',false)
