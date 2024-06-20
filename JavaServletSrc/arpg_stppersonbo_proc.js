function SetControlsValue() {
var c;
var c;
if(c=Ctrl('UYVYTEMEXX')) c.value = WtH(w_daCodCli,'C',16,0,'')
if(c=Ctrl('CJWUHWULAR')) c.value = WtH(w_aCodCli,'C',16,0,'')
if(c=Ctrl('LGLKGKWNEO')) ChkboxCheckUncheck(c,'S',w_tipstp)
if(c=Ctrl('LGLKGKWNEO')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('DPKVLWHCIG')) c.value = WtH(w_daData,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('MTJDZQTEIR')) c.value = WtH(w_aData,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('FSBLFOLVXF')) ChkboxCheckUncheck(c,'S',w_ChkSoloVar)
if(c=Ctrl('FSBLFOLVXF')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('NUMMEMNOIJ')) ChkboxCheckUncheck(c,'S',w_chktit)
if(c=Ctrl('NUMMEMNOIJ')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('MHGDPIVIPA')) ChkboxCheckUncheck(c,'S',w_chknotit)
if(c=Ctrl('MHGDPIVIPA')) ChkboxValueAssign(c,'S','N','C',1,0,'')
var tmp_VXJAZUGUIO = ToHTag(AsControlValue(w_RAGSOC1));
if (Ne(e_VXJAZUGUIO,tmp_VXJAZUGUIO)) {
if(c=Ctrl('VXJAZUGUIO')) c.innerHTML=tmp_VXJAZUGUIO;
e_VXJAZUGUIO=tmp_VXJAZUGUIO;
}
var tmp_XCBBNKIAUV = ToHTag(AsControlValue(w_RAGSOC2));
if (Ne(e_XCBBNKIAUV,tmp_XCBBNKIAUV)) {
if(c=Ctrl('XCBBNKIAUV')) c.innerHTML=tmp_XCBBNKIAUV;
e_XCBBNKIAUV=tmp_XCBBNKIAUV;
}
if(c=Ctrl('MKCIRYVYZH')) ChkboxCheckUncheck(c,'S',w_stpatt)
if(c=Ctrl('MKCIRYVYZH')) ChkboxValueAssign(c,'S','N','C',1,0,'')
var tmp_TYIWXFLLFY = ToHTag(AsControlValue('<iframe width=\'750\' height=\'400\' id=\'elaborazione\'  name=\'elaborazione\' frameborder=\'1\'  border=\'1\' align=\'TOP\' marginwidth=\'1\' marginheight=\'1\'></iframe>'));
if (Ne(e_TYIWXFLLFY,tmp_TYIWXFLLFY)) {
if(c=Ctrl('TYIWXFLLFY')) c.innerHTML=tmp_TYIWXFLLFY;
e_TYIWXFLLFY=tmp_TYIWXFLLFY;
}
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
HideUI();
}
HideUI.lblids["aCodCli"]=['JGQCNSZOCQ'];
HideUI.lblids["aData"]=['BGHAITOPMU'];
HideUI.lblids["daCodCli"]=['PCILMATBXL'];
HideUI.lblids["daData"]=['HPGJXQIVYG'];
function UYVYTEMEXX_Valid(e) {
SetActiveField(Ctrl('UYVYTEMEXX'),false);
e=(Ne(e,null)?e:window.event);
return Set_daCodCli(HtW(Ctrl('UYVYTEMEXX').value,'C'),null,e);
}
function UYVYTEMEXX_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('UYVYTEMEXX'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('UYVYTEMEXX'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('UYVYTEMEXX'),e);
}
function UYVYTEMEXX_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('UYVYTEMEXX')),'linkview_UYVYTEMEXX','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function CJWUHWULAR_Valid(e) {
SetActiveField(Ctrl('CJWUHWULAR'),false);
e=(Ne(e,null)?e:window.event);
return Set_aCodCli(HtW(Ctrl('CJWUHWULAR').value,'C'),null,e);
}
function CJWUHWULAR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('CJWUHWULAR'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('CJWUHWULAR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('CJWUHWULAR'),e);
}
function CJWUHWULAR_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('CJWUHWULAR')),'linkview_CJWUHWULAR','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function LGLKGKWNEO_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_tipstp(ChkboxValueAssign(Ctrl('LGLKGKWNEO'),'S','N','C',1,0,''),null,e);
}
function LGLKGKWNEO_OnFocus(e) {
SetActiveField(Ctrl('LGLKGKWNEO'),true);
}
function LGLKGKWNEO_OnBlur(e) {
SetActiveField(Ctrl('LGLKGKWNEO'),false);
}
function DPKVLWHCIG_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('DPKVLWHCIG'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('DPKVLWHCIG').value=ApplyPictureToDate(Ctrl('DPKVLWHCIG').value,TranslatePicture(datePattern),'DPKVLWHCIG');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('DPKVLWHCIG'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('DPKVLWHCIG');
}
}
}
SetActiveField(Ctrl('DPKVLWHCIG'),false);
e=(Ne(e,null)?e:window.event);
return Set_daData(HtW(Ctrl('DPKVLWHCIG').value,'D'),null,e) && dateisok;
}
function DPKVLWHCIG_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('DPKVLWHCIG'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('DPKVLWHCIG').value=WtH(w_daData,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('DPKVLWHCIG');
SetActiveField(Ctrl('DPKVLWHCIG'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('DPKVLWHCIG'),e);
}
function DPKVLWHCIG_ZOOM_Click() {
LaunchCalendar(Ctrl('DPKVLWHCIG'));
}
function MTJDZQTEIR_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('MTJDZQTEIR'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('MTJDZQTEIR').value=ApplyPictureToDate(Ctrl('MTJDZQTEIR').value,TranslatePicture(datePattern),'MTJDZQTEIR');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('MTJDZQTEIR'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('MTJDZQTEIR');
}
}
}
SetActiveField(Ctrl('MTJDZQTEIR'),false);
e=(Ne(e,null)?e:window.event);
return Set_aData(HtW(Ctrl('MTJDZQTEIR').value,'D'),null,e) && dateisok;
}
function MTJDZQTEIR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('MTJDZQTEIR'))) {
DisplayErrorMessage();
}
if (Ne(_tracker.ctrl,Ctrl('MTJDZQTEIR'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('MTJDZQTEIR').value=WtH(w_aData,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
}
m_oEnteredInDate=Ctrl('MTJDZQTEIR');
SetActiveField(Ctrl('MTJDZQTEIR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('MTJDZQTEIR'),e);
}
function MTJDZQTEIR_ZOOM_Click() {
LaunchCalendar(Ctrl('MTJDZQTEIR'));
}
function FSBLFOLVXF_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_ChkSoloVar(ChkboxValueAssign(Ctrl('FSBLFOLVXF'),'S','N','C',1,0,''),null,e);
}
function FSBLFOLVXF_OnFocus(e) {
SetActiveField(Ctrl('FSBLFOLVXF'),true);
}
function FSBLFOLVXF_OnBlur(e) {
SetActiveField(Ctrl('FSBLFOLVXF'),false);
}
function NUMMEMNOIJ_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_chktit(ChkboxValueAssign(Ctrl('NUMMEMNOIJ'),'S','N','C',1,0,''),null,e);
}
function NUMMEMNOIJ_OnFocus(e) {
SetActiveField(Ctrl('NUMMEMNOIJ'),true);
}
function NUMMEMNOIJ_OnBlur(e) {
SetActiveField(Ctrl('NUMMEMNOIJ'),false);
}
function MHGDPIVIPA_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_chknotit(ChkboxValueAssign(Ctrl('MHGDPIVIPA'),'S','N','C',1,0,''),null,e);
}
function MHGDPIVIPA_OnFocus(e) {
SetActiveField(Ctrl('MHGDPIVIPA'),true);
}
function MHGDPIVIPA_OnBlur(e) {
SetActiveField(Ctrl('MHGDPIVIPA'),false);
}
function href_XURLGQZZMU() {
SetLocationHref(null,'arrt_stpperson'+'?m_cAction=start&m_cMode=hyperlink','elaborazione')
}
function href_PTXYMSWBZO() {
SetLocationHref(window.location,ToResource('jsp/start_page_logo_portlet.jsp'+'')+'')
}
function MKCIRYVYZH_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_stpatt(ChkboxValueAssign(Ctrl('MKCIRYVYZH'),'S','N','C',1,0,''),null,e);
}
function MKCIRYVYZH_OnFocus(e) {
SetActiveField(Ctrl('MKCIRYVYZH'),true);
}
function MKCIRYVYZH_OnBlur(e) {
SetActiveField(Ctrl('MKCIRYVYZH'),false);
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
if(c=Ctrl('UYVYTEMEXX')) c.onblur=UYVYTEMEXX_Valid;
if(c=Ctrl('UYVYTEMEXX')) c.onfocus=UYVYTEMEXX_OnFocus;
if(c=Ctrl('CJWUHWULAR')) c.onblur=CJWUHWULAR_Valid;
if(c=Ctrl('CJWUHWULAR')) c.onfocus=CJWUHWULAR_OnFocus;
if(c=Ctrl('LGLKGKWNEO')) c.onclick=LGLKGKWNEO_Valid;
if(c=Ctrl('LGLKGKWNEO')) c.onfocus=LGLKGKWNEO_OnFocus;
if(c=Ctrl('LGLKGKWNEO')) c.onblur=LGLKGKWNEO_OnBlur;
if(c=Ctrl('DPKVLWHCIG')) c.onblur=DPKVLWHCIG_Valid;
if(c=Ctrl('DPKVLWHCIG')) c.onfocus=DPKVLWHCIG_OnFocus;
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
if(c=Ctrl('DPKVLWHCIG')) c.onkeypress=CheckDateChar;
}
if(c=Ctrl('MTJDZQTEIR')) c.onblur=MTJDZQTEIR_Valid;
if(c=Ctrl('MTJDZQTEIR')) c.onfocus=MTJDZQTEIR_OnFocus;
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
if(c=Ctrl('MTJDZQTEIR')) c.onkeypress=CheckDateChar;
}
if(c=Ctrl('FSBLFOLVXF')) c.onclick=FSBLFOLVXF_Valid;
if(c=Ctrl('FSBLFOLVXF')) c.onfocus=FSBLFOLVXF_OnFocus;
if(c=Ctrl('FSBLFOLVXF')) c.onblur=FSBLFOLVXF_OnBlur;
if(c=Ctrl('NUMMEMNOIJ')) c.onclick=NUMMEMNOIJ_Valid;
if(c=Ctrl('NUMMEMNOIJ')) c.onfocus=NUMMEMNOIJ_OnFocus;
if(c=Ctrl('NUMMEMNOIJ')) c.onblur=NUMMEMNOIJ_OnBlur;
if(c=Ctrl('MHGDPIVIPA')) c.onclick=MHGDPIVIPA_Valid;
if(c=Ctrl('MHGDPIVIPA')) c.onfocus=MHGDPIVIPA_OnFocus;
if(c=Ctrl('MHGDPIVIPA')) c.onblur=MHGDPIVIPA_OnBlur;
if(c=Ctrl('MKCIRYVYZH')) c.onclick=MKCIRYVYZH_Valid;
if(c=Ctrl('MKCIRYVYZH')) c.onfocus=MKCIRYVYZH_OnFocus;
if(c=Ctrl('MKCIRYVYZH')) c.onblur=MKCIRYVYZH_OnBlur;
}
}
function NotifyEvent(p_cEvent) {
var old_c;
if (Ne(typeof(w_Messaggi),'undefined')) {
w_Messaggi.raiseEvent('arpg_stppersonbo_'+Strtran(p_cEvent,' ','_'));
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
FocusFirstComponent.otherwise={"page_1":["UYVYTEMEXX"]};
function Help() {
windowOpenForeground('../doc/arpg_stppersonbo_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_daCodCli=a[0];
w_aCodCli=a[1];
w_tipstp=a[2];
w_daData=a[3];
w_aData=a[4];
w_ChkSoloVar=a[5];
w_chktit=a[6];
w_chknotit=a[7];
w_RAGSOC1=a[8];
w_RAGSOC2=a[9];
w_stpatt=a[10];
o_tipstp=w_tipstp[1];
w_tipstp=w_tipstp[0];
o_chknotit=w_chknotit[1];
w_chknotit=w_chknotit[0];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_stppersonbo',m_cSelectedPage);
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
l_bEnabled= ! (Eq(w_chknotit,'N')) || IsDisabledByStateDriver('tipstp');
SetDisabled(Ctrl('LGLKGKWNEO'),l_bEnabled);
l_bEnabled= ! (Eq(w_tipstp,'S')) || IsDisabledByStateDriver('daData');
SetDisabled(Ctrl('DPKVLWHCIG'),l_bEnabled);
SetDisabled(Ctrl('DPKVLWHCIG_ZOOM'),l_bEnabled);
l_bEnabled= ! (Eq(w_tipstp,'S')) || IsDisabledByStateDriver('aData');
SetDisabled(Ctrl('MTJDZQTEIR'),l_bEnabled);
SetDisabled(Ctrl('MTJDZQTEIR_ZOOM'),l_bEnabled);
l_bEnabled= ! (Eq(w_tipstp,'S') && Eq(w_chknotit,'N')) || IsDisabledByStateDriver('ChkSoloVar');
SetDisabled(Ctrl('FSBLFOLVXF'),l_bEnabled);
l_bEnabled= ! (Eq(w_chknotit,'N')) || IsDisabledByStateDriver('chktit');
SetDisabled(Ctrl('NUMMEMNOIJ'),l_bEnabled);
l_bEnabled= ! (Eq(w_chknotit,'N')) || IsDisabledByStateDriver('stpatt');
SetDisabled(Ctrl('MKCIRYVYZH'),l_bEnabled);
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
function Set_daCodCli(ctrlValue,kmode,e) {
if (Ne(w_daCodCli,ctrlValue)) {
var ctl = _GetCtl(e,'UYVYTEMEXX');
if (_tracker.goon(ctl,ctrlValue)) {
w_daCodCli=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UYVYTEMEXX',0);
if (l_bResult) {
l_bResult=Link_UYVYTEMEXX(kmode);
if ( ! (l_bResult)) {
w_daCodCli=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',16,0,''));
} else {
_ResetTracker();
}
return l_bResult;
} else {
ctl.value=WtH('','C',16,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_aCodCli(ctrlValue,kmode,e) {
if (Ne(w_aCodCli,ctrlValue)) {
var ctl = _GetCtl(e,'CJWUHWULAR');
if (_tracker.goon(ctl,ctrlValue)) {
w_aCodCli=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CJWUHWULAR',0);
if (l_bResult) {
l_bResult=Link_CJWUHWULAR(kmode);
if ( ! (l_bResult)) {
w_aCodCli=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',16,0,''));
} else {
_ResetTracker();
}
return l_bResult;
} else {
ctl.value=WtH('','C',16,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_tipstp(ctrlValue,kmode,e) {
if (Ne(w_tipstp,ctrlValue)) {
var ctl = _GetCtl(e,'LGLKGKWNEO');
if (_tracker.goon(ctl,ctrlValue)) {
w_tipstp=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('LGLKGKWNEO',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_daData(ctrlValue,kmode,e) {
if (Ne(w_daData,ctrlValue)) {
var ctl = _GetCtl(e,'DPKVLWHCIG');
if (_tracker.goon(ctl,ctrlValue)) {
w_daData=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('DPKVLWHCIG',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH(NullDate(),'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
_ResetTracker();
return true;
}
}
return true;
}
function Set_aData(ctrlValue,kmode,e) {
if (Ne(w_aData,ctrlValue)) {
var ctl = _GetCtl(e,'MTJDZQTEIR');
if (_tracker.goon(ctl,ctrlValue)) {
w_aData=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MTJDZQTEIR',0);
if (l_bResult) {
l_bResult=Ge(w_aData,w_daData);
if ( ! (l_bResult)) {
m_nLastError=2;
m_cLastWorkVarErrorMsg='aData';
m_cLastMsgError=AlertErrorMessage('10557974447');
}
if ( ! (l_bResult)) {
w_aData=HtW('','D');
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
function Set_ChkSoloVar(ctrlValue,kmode,e) {
if (Ne(w_ChkSoloVar,ctrlValue)) {
var ctl = _GetCtl(e,'FSBLFOLVXF');
if (_tracker.goon(ctl,ctrlValue)) {
w_ChkSoloVar=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FSBLFOLVXF',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_chktit(ctrlValue,kmode,e) {
if (Ne(w_chktit,ctrlValue)) {
var ctl = _GetCtl(e,'NUMMEMNOIJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_chktit=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NUMMEMNOIJ',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_chknotit(ctrlValue,kmode,e) {
if (Ne(w_chknotit,ctrlValue)) {
var ctl = _GetCtl(e,'MHGDPIVIPA');
if (_tracker.goon(ctl,ctrlValue)) {
w_chknotit=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MHGDPIVIPA',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_stpatt(ctrlValue,kmode,e) {
if (Ne(w_stpatt,ctrlValue)) {
var ctl = _GetCtl(e,'MKCIRYVYZH');
if (_tracker.goon(ctl,ctrlValue)) {
w_stpatt=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MKCIRYVYZH',0);
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
if ((Ne(o_chknotit,w_chknotit))) {
Calculation_NFCEZVMJDN();
}
if ((Ne(o_tipstp,w_tipstp))) {
Calculation_NVMRVSZASV();
}
// * --- Area Manuale = UI - Calculate
// * --- Fine Area Manuale
m_bCalculating=false;
}
function Calculation_NFCEZVMJDN() {
if (Eq(w_chknotit,'S')) {
w_tipstp='N';
w_stpatt='N';
w_chktit='N';
w_ChkSoloVar='N';
}
}
function Calculation_NVMRVSZASV() {
if (Eq(w_tipstp,'N')) {
w_ChkSoloVar='N';
}
}
function SaveDependsOn() {
o_tipstp=w_tipstp;
o_chknotit=w_chknotit;
}
function SaveLabelDependsOn() {
}
function Link_UYVYTEMEXX(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_daCodCli);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CONNES',w_daCodCli,16,0);
l_Appl.SetFields('CONNES,RAGSOC');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('personbo');
l_Appl.SetID('UYVYTEMEXX');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_daCodCli=l_Appl.GetStringValue('CONNES',16,0);
w_RAGSOC1=l_Appl.GetStringValue('RAGSOC',70,0);
} else {
Link_UYVYTEMEXX_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_UYVYTEMEXX';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_UYVYTEMEXX();
l_oWv.setValue('FieldFilter',l_cFieldFilter);
if ( ! (Empty(l_Appl.GetWhereAddedFixedFiltersUnencoded()))) {
if ( ! (Empty(l_cFixedFilter))) {
l_cFixedFilter=l_cFixedFilter+' and ';
}
l_cFixedFilter=l_cFixedFilter+l_Appl.GetWhereAddedFixedFiltersUnencoded();
}
l_oWv.setValue('FixedFilter',l_cFixedFilter);
var initEntityFields = '';
l_cLinkUrl='../servlet/SPVisualZoom'+'?m_cWv='+URLenc(l_oWv.asString());
layerOpenForeground(l_cLinkUrl,openername,'toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes');
m_nLastError=-2;
} else {
if ( ! (l_bResult)) {
m_nLastError=3;
m_cLastWorkVarErrorMsg='';
if (Lt(l_nRec,0)) {
m_cLastMsgError=Translate('MSG_CONNECT_SERVER');
}
}
}
return l_bResult;
}
function Link_UYVYTEMEXX_Blank() {
w_daCodCli='';
w_RAGSOC1='';
}
function LOpt_UYVYTEMEXX() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('personbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CONNES','C'));
l_oWv.setValue('LinkedField',WtA('CONNES','C'));
l_oWv.setValue('UID',WtA('UYVYTEMEXX','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['UYVYTEMEXX'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('10505367639'),'C'));
return l_oWv;
}
function Link_CJWUHWULAR(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_aCodCli);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CONNES',w_aCodCli,16,0);
l_Appl.SetFields('CONNES,RAGSOC');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('personbo');
l_Appl.SetID('CJWUHWULAR');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_aCodCli=l_Appl.GetStringValue('CONNES',16,0);
w_RAGSOC2=l_Appl.GetStringValue('RAGSOC',70,0);
} else {
Link_CJWUHWULAR_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_CJWUHWULAR';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_CJWUHWULAR();
l_oWv.setValue('FieldFilter',l_cFieldFilter);
if ( ! (Empty(l_Appl.GetWhereAddedFixedFiltersUnencoded()))) {
if ( ! (Empty(l_cFixedFilter))) {
l_cFixedFilter=l_cFixedFilter+' and ';
}
l_cFixedFilter=l_cFixedFilter+l_Appl.GetWhereAddedFixedFiltersUnencoded();
}
l_oWv.setValue('FixedFilter',l_cFixedFilter);
var initEntityFields = '';
l_cLinkUrl='../servlet/SPVisualZoom'+'?m_cWv='+URLenc(l_oWv.asString());
layerOpenForeground(l_cLinkUrl,openername,'toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes');
m_nLastError=-2;
} else {
if ( ! (l_bResult)) {
m_nLastError=3;
m_cLastWorkVarErrorMsg='';
if (Lt(l_nRec,0)) {
m_cLastMsgError=Translate('MSG_CONNECT_SERVER');
}
}
}
return l_bResult;
}
function Link_CJWUHWULAR_Blank() {
w_aCodCli='';
w_RAGSOC2='';
}
function LOpt_CJWUHWULAR() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('personbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CONNES','C'));
l_oWv.setValue('LinkedField',WtA('CONNES','C'));
l_oWv.setValue('UID',WtA('CJWUHWULAR','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['CJWUHWULAR'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('10505367639'),'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'UYVYTEMEXX')) {
last_focused_comp=GetLastFocusedElementOfLink('UYVYTEMEXX');
function SetMethod_UYVYTEMEXX() {
Set_daCodCli(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_UYVYTEMEXX();
} else {
setTimeout(SetMethod_UYVYTEMEXX,1);
}
bResult=true;
}
if (Eq(varName,'CJWUHWULAR')) {
last_focused_comp=GetLastFocusedElementOfLink('CJWUHWULAR');
function SetMethod_CJWUHWULAR() {
Set_aCodCli(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_CJWUHWULAR();
} else {
setTimeout(SetMethod_CJWUHWULAR,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'UYVYTEMEXX')) {
return [Ctrl('UYVYTEMEXX')];
}
if (Eq(varName,'CJWUHWULAR')) {
return [Ctrl('CJWUHWULAR')];
}
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
if ( ! (_ChkObl('UYVYTEMEXX',1))) {
_SignErr('UYVYTEMEXX');
m_cLastWorkVarErrorMsg='daCodCli';
l_bResult=false;
w_daCodCli=HtW('','C');
} else if ( ! (_ChkObl('CJWUHWULAR',1))) {
_SignErr('CJWUHWULAR');
m_cLastWorkVarErrorMsg='aCodCli';
l_bResult=false;
w_aCodCli=HtW('','C');
} else if ((Eq(w_chknotit,'N')) && ( ! (_ChkObl('LGLKGKWNEO',1)))) {
_SignErr('LGLKGKWNEO');
m_cLastWorkVarErrorMsg='871482081';
l_bResult=false;
w_tipstp='N';
} else if ((Eq(w_tipstp,'S')) && ( ! (_ChkObl('DPKVLWHCIG',1)))) {
_SignErr('DPKVLWHCIG');
m_cLastWorkVarErrorMsg='daData';
l_bResult=false;
w_daData=HtW('','D');
} else if ((Eq(w_tipstp,'S')) && (( ! (_ChkObl('MTJDZQTEIR',1))) || ( ! (Ge(w_aData,w_daData))))) {
_SignErr('MTJDZQTEIR','10557974447');
l_bResult=false;
w_aData=HtW('','D');
} else if ((Eq(w_tipstp,'S') && Eq(w_chknotit,'N')) && ( ! (_ChkObl('FSBLFOLVXF',1)))) {
_SignErr('FSBLFOLVXF');
m_cLastWorkVarErrorMsg='1138199489';
l_bResult=false;
w_ChkSoloVar='N';
} else if ((Eq(w_chknotit,'N')) && ( ! (_ChkObl('NUMMEMNOIJ',1)))) {
_SignErr('NUMMEMNOIJ');
m_cLastWorkVarErrorMsg='11423966324';
l_bResult=false;
w_chktit='N';
} else if ( ! (_ChkObl('MHGDPIVIPA',1))) {
_SignErr('MHGDPIVIPA');
m_cLastWorkVarErrorMsg='11613838093';
l_bResult=false;
w_chknotit='N';
} else if ((Eq(w_chknotit,'N')) && ( ! (_ChkObl('MKCIRYVYZH',1)))) {
_SignErr('MKCIRYVYZH');
m_cLastWorkVarErrorMsg='10318493904';
l_bResult=false;
w_stpatt='N';
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('UYVYTEMEXX_ZOOM',lc)) {
return 0;
}
if (Eq('UYVYTEMEXX',lc)) {
return 0;
}
if (Eq('CJWUHWULAR_ZOOM',lc)) {
return 1;
}
if (Eq('CJWUHWULAR',lc)) {
return 1;
}
if (Eq('DPKVLWHCIG_ZOOM',lc)) {
return 2;
}
if (Eq('MTJDZQTEIR_ZOOM',lc)) {
return 2;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_UYVYTEMEXX();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,1)) {
l_oWv=LOpt_CJWUHWULAR();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
}
function FillWv() {
var l_oWv = InitWvApplet();
l_oWv.setValue('daCodCli',WtA(w_daCodCli,'C'));
l_oWv.setValue('aCodCli',WtA(w_aCodCli,'C'));
l_oWv.setValue('tipstp',WtA(w_tipstp,'C'));
l_oWv.setValue('daData',WtA(w_daData,'D'));
l_oWv.setValue('aData',WtA(w_aData,'D'));
l_oWv.setValue('ChkSoloVar',WtA(w_ChkSoloVar,'C'));
l_oWv.setValue('chktit',WtA(w_chktit,'C'));
l_oWv.setValue('chknotit',WtA(w_chknotit,'C'));
l_oWv.setValue('RAGSOC1',WtA(w_RAGSOC1,'C'));
l_oWv.setValue('RAGSOC2',WtA(w_RAGSOC2,'C'));
l_oWv.setValue('stpatt',WtA(w_stpatt,'C'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["daCodCli","aCodCli","tipstp","daData","aData","ChkSoloVar","chktit","chknotit","RAGSOC1","RAGSOC2","stpatt"];
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
if (Empty(w_daCodCli) && Ne(opener.w_daCodCli,null)) {
TransferBetweenWindows(opener,'w_daCodCli',null,'Set_daCodCli');
}
if (Empty(w_aCodCli) && Ne(opener.w_aCodCli,null)) {
TransferBetweenWindows(opener,'w_aCodCli',null,'Set_aCodCli');
}
if (Eq(w_tipstp,'N') && Ne(opener.w_tipstp,null)) {
TransferBetweenWindows(opener,'w_tipstp',null,'Set_tipstp');
}
if (Empty(w_daData) && Ne(opener.w_daData,null)) {
TransferBetweenWindows(opener,'w_daData',null,'Set_daData');
}
if (Empty(w_aData) && Ne(opener.w_aData,null)) {
TransferBetweenWindows(opener,'w_aData',null,'Set_aData');
}
if (Eq(w_ChkSoloVar,'N') && Ne(opener.w_ChkSoloVar,null)) {
TransferBetweenWindows(opener,'w_ChkSoloVar',null,'Set_ChkSoloVar');
}
if (Eq(w_chktit,'N') && Ne(opener.w_chktit,null)) {
TransferBetweenWindows(opener,'w_chktit',null,'Set_chktit');
}
if (Eq(w_chknotit,'N') && Ne(opener.w_chknotit,null)) {
TransferBetweenWindows(opener,'w_chknotit',null,'Set_chknotit');
}
if (Eq(w_stpatt,'N') && Ne(opener.w_stpatt,null)) {
TransferBetweenWindows(opener,'w_stpatt',null,'Set_stpatt');
}
}
}
m_bCalculating=true;
Link_UYVYTEMEXX(null);
Link_CJWUHWULAR(null);
if (start && Eq(At(',tipstp,',pseq),0)) {
w_tipstp='N';
}
if (start && Eq(At(',ChkSoloVar,',pseq),0)) {
w_ChkSoloVar='N';
}
if (start && Eq(At(',chktit,',pseq),0)) {
w_chktit='N';
}
if (start && Eq(At(',chknotit,',pseq),0)) {
w_chknotit='N';
}
if (start && Eq(At(',stpatt,',pseq),0)) {
w_stpatt='N';
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
_Obli('daCodCli',0,'UYVYTEMEXX',false)
_Obli('aCodCli',0,'CJWUHWULAR',false)
_Obli('tipstp',0,'LGLKGKWNEO',false,"871482081")
_Obli('daData',2,'DPKVLWHCIG',false)
_Obli('aData',2,'MTJDZQTEIR',false)
_Obli('ChkSoloVar',0,'FSBLFOLVXF',false,"1138199489")
_Obli('chktit',0,'NUMMEMNOIJ',false,"11423966324")
_Obli('chknotit',0,'MHGDPIVIPA',false,"11613838093")
_Obli('stpatt',0,'MKCIRYVYZH',false,"10318493904")
