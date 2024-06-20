function SetControlsValue() {
var c;
var c;
if(c=Ctrl('UYVYTEMEXX')) c.value = WtH(w_daRappo,'C',25,0,'')
if(c=Ctrl('CJWUHWULAR')) c.value = WtH(w_aRappo,'C',25,0,'')
var tmp_VXJAZUGUIO = ToHTag(AsControlValue(w_desrap1));
if (Ne(e_VXJAZUGUIO,tmp_VXJAZUGUIO)) {
if(c=Ctrl('VXJAZUGUIO')) c.innerHTML=tmp_VXJAZUGUIO;
e_VXJAZUGUIO=tmp_VXJAZUGUIO;
}
var tmp_XCBBNKIAUV = ToHTag(AsControlValue(w_desrap2));
if (Ne(e_XCBBNKIAUV,tmp_XCBBNKIAUV)) {
if(c=Ctrl('XCBBNKIAUV')) c.innerHTML=tmp_XCBBNKIAUV;
e_XCBBNKIAUV=tmp_XCBBNKIAUV;
}
if(c=Ctrl('AITVTFTATA')) c.value = WtH(w_DaDatIni,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('KGOPKMFAZV')) c.value = WtH(w_ADatIni,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('HOUDAUAIJN')) selectRadio(c,w_tipo,'C')
if(c=Ctrl('QXLZEAPPUS')) c.value = WtH(w_DaDatFin,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('FZWKNFCNEV')) c.value = WtH(w_ADatFin,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
HideUI();
}
HideUI.lblids["ADatFin"]=['RUTZMAZNEP'];
HideUI.lblids["ADatIni"]=['IAKDALUCLJ'];
HideUI.lblids["DaDatFin"]=['WJNEQXIEJK'];
HideUI.lblids["DaDatIni"]=['NGVOZRVMWR'];
HideUI.lblids["aRappo"]=['JGQCNSZOCQ'];
HideUI.lblids["daRappo"]=['PCILMATBXL'];
function UYVYTEMEXX_Valid(e) {
SetActiveField(Ctrl('UYVYTEMEXX'),false);
e=(Ne(e,null)?e:window.event);
return Set_daRappo(HtW(Ctrl('UYVYTEMEXX').value,'C'),null,e);
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
return Set_aRappo(HtW(Ctrl('CJWUHWULAR').value,'C'),null,e);
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
function href_XURLGQZZMU() {
_modifyandopen('arrt_stprappo_elenco_ae'+'?m_cAction=start&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes,height=500,width=700',null)
}
function href_RPFMUWVENA() {
SetLocationHref(window.location,ToResource('jsp/start_page_logo_portlet.jsp'+'')+'')
}
function AITVTFTATA_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('AITVTFTATA'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('AITVTFTATA').value=ApplyPictureToDate(Ctrl('AITVTFTATA').value,TranslatePicture(datePattern),'AITVTFTATA');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('AITVTFTATA'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('AITVTFTATA');
}
}
}
SetActiveField(Ctrl('AITVTFTATA'),false);
e=(Ne(e,null)?e:window.event);
return Set_DaDatIni(HtW(Ctrl('AITVTFTATA').value,'D'),null,e) && dateisok;
}
function AITVTFTATA_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('AITVTFTATA'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('AITVTFTATA').value=WtH(w_DaDatIni,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('AITVTFTATA');
SetActiveField(Ctrl('AITVTFTATA'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('AITVTFTATA'),e);
}
function AITVTFTATA_ZOOM_Click() {
LaunchCalendar(Ctrl('AITVTFTATA'));
}
function KGOPKMFAZV_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('KGOPKMFAZV'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('KGOPKMFAZV').value=ApplyPictureToDate(Ctrl('KGOPKMFAZV').value,TranslatePicture(datePattern),'KGOPKMFAZV');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('KGOPKMFAZV'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('KGOPKMFAZV');
}
}
}
SetActiveField(Ctrl('KGOPKMFAZV'),false);
e=(Ne(e,null)?e:window.event);
return Set_ADatIni(HtW(Ctrl('KGOPKMFAZV').value,'D'),null,e) && dateisok;
}
function KGOPKMFAZV_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('KGOPKMFAZV'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('KGOPKMFAZV').value=WtH(w_ADatIni,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('KGOPKMFAZV');
SetActiveField(Ctrl('KGOPKMFAZV'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('KGOPKMFAZV'),e);
}
function KGOPKMFAZV_ZOOM_Click() {
LaunchCalendar(Ctrl('KGOPKMFAZV'));
}
function HOUDAUAIJN_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_tipo(HtW(getRadioValue(Ctrl('HOUDAUAIJN')),'C'),null,e);
}
function QXLZEAPPUS_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('QXLZEAPPUS'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('QXLZEAPPUS').value=ApplyPictureToDate(Ctrl('QXLZEAPPUS').value,TranslatePicture(datePattern),'QXLZEAPPUS');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('QXLZEAPPUS'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('QXLZEAPPUS');
}
}
}
SetActiveField(Ctrl('QXLZEAPPUS'),false);
e=(Ne(e,null)?e:window.event);
return Set_DaDatFin(HtW(Ctrl('QXLZEAPPUS').value,'D'),null,e) && dateisok;
}
function QXLZEAPPUS_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('QXLZEAPPUS'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('QXLZEAPPUS').value=WtH(w_DaDatFin,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('QXLZEAPPUS');
SetActiveField(Ctrl('QXLZEAPPUS'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('QXLZEAPPUS'),e);
}
function QXLZEAPPUS_ZOOM_Click() {
LaunchCalendar(Ctrl('QXLZEAPPUS'));
}
function FZWKNFCNEV_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('FZWKNFCNEV'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('FZWKNFCNEV').value=ApplyPictureToDate(Ctrl('FZWKNFCNEV').value,TranslatePicture(datePattern),'FZWKNFCNEV');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('FZWKNFCNEV'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('FZWKNFCNEV');
}
}
}
SetActiveField(Ctrl('FZWKNFCNEV'),false);
e=(Ne(e,null)?e:window.event);
return Set_ADatFin(HtW(Ctrl('FZWKNFCNEV').value,'D'),null,e) && dateisok;
}
function FZWKNFCNEV_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('FZWKNFCNEV'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('FZWKNFCNEV').value=WtH(w_ADatFin,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('FZWKNFCNEV');
SetActiveField(Ctrl('FZWKNFCNEV'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('FZWKNFCNEV'),e);
}
function FZWKNFCNEV_ZOOM_Click() {
LaunchCalendar(Ctrl('FZWKNFCNEV'));
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
if(c=Ctrl('AITVTFTATA')) c.onblur=AITVTFTATA_Valid;
if(c=Ctrl('AITVTFTATA')) c.onfocus=AITVTFTATA_OnFocus;
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
if(c=Ctrl('AITVTFTATA')) c.onkeypress=CheckDateChar;
}
if(c=Ctrl('KGOPKMFAZV')) c.onblur=KGOPKMFAZV_Valid;
if(c=Ctrl('KGOPKMFAZV')) c.onfocus=KGOPKMFAZV_OnFocus;
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
if(c=Ctrl('KGOPKMFAZV')) c.onkeypress=CheckDateChar;
}
c=Ctrl('HOUDAUAIJN');
if ( ! (Empty(c))) {
c[0].onclick=HOUDAUAIJN_Valid;
c[1].onclick=HOUDAUAIJN_Valid;
c[2].onclick=HOUDAUAIJN_Valid;
}
if(c=Ctrl('QXLZEAPPUS')) c.onblur=QXLZEAPPUS_Valid;
if(c=Ctrl('QXLZEAPPUS')) c.onfocus=QXLZEAPPUS_OnFocus;
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
if(c=Ctrl('QXLZEAPPUS')) c.onkeypress=CheckDateChar;
}
if(c=Ctrl('FZWKNFCNEV')) c.onblur=FZWKNFCNEV_Valid;
if(c=Ctrl('FZWKNFCNEV')) c.onfocus=FZWKNFCNEV_OnFocus;
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
if(c=Ctrl('FZWKNFCNEV')) c.onkeypress=CheckDateChar;
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
FocusFirstComponent.otherwise={"page_1":["UYVYTEMEXX"]};
function Help() {
windowOpenForeground('../doc/arpg_stprappo_sint_ae_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_daRappo=a[0];
w_aRappo=a[1];
w_desrap1=a[2];
w_desrap2=a[3];
w_DaDatIni=a[4];
w_ADatIni=a[5];
w_tipo=a[6];
w_DaDatFin=a[7];
w_ADatFin=a[8];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_stprappo_sint_ae',m_cSelectedPage);
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
function Set_daRappo(ctrlValue,kmode,e) {
if (Ne(w_daRappo,ctrlValue)) {
var ctl = _GetCtl(e,'UYVYTEMEXX');
if (_tracker.goon(ctl,ctrlValue)) {
w_daRappo=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UYVYTEMEXX',0);
if (l_bResult) {
l_bResult=Link_UYVYTEMEXX(kmode);
if ( ! (l_bResult)) {
w_daRappo=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',25,0,''));
} else {
_ResetTracker();
}
return l_bResult;
} else {
ctl.value=WtH('','C',25,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_aRappo(ctrlValue,kmode,e) {
if (Ne(w_aRappo,ctrlValue)) {
var ctl = _GetCtl(e,'CJWUHWULAR');
if (_tracker.goon(ctl,ctrlValue)) {
w_aRappo=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CJWUHWULAR',0);
if (l_bResult) {
l_bResult=Link_CJWUHWULAR(kmode);
if ( ! (l_bResult)) {
w_aRappo=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',25,0,''));
} else {
_ResetTracker();
}
return l_bResult;
} else {
ctl.value=WtH('','C',25,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_DaDatIni(ctrlValue,kmode,e) {
if (Ne(w_DaDatIni,ctrlValue)) {
var ctl = _GetCtl(e,'AITVTFTATA');
if (_tracker.goon(ctl,ctrlValue)) {
w_DaDatIni=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('AITVTFTATA',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH(NullDate(),'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
_ResetTracker();
return true;
}
}
return true;
}
function Set_ADatIni(ctrlValue,kmode,e) {
if (Ne(w_ADatIni,ctrlValue)) {
var ctl = _GetCtl(e,'KGOPKMFAZV');
if (_tracker.goon(ctl,ctrlValue)) {
w_ADatIni=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('KGOPKMFAZV',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH(NullDate(),'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
_ResetTracker();
return true;
}
}
return true;
}
function Set_tipo(ctrlValue,kmode,e) {
if (Ne(w_tipo,ctrlValue)) {
var ctl = _GetCtl(e,'HOUDAUAIJN');
if (_tracker.goon(ctl,ctrlValue)) {
w_tipo=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HOUDAUAIJN',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_ADatFin(ctrlValue,kmode,e) {
if (Ne(w_ADatFin,ctrlValue)) {
var ctl = _GetCtl(e,'FZWKNFCNEV');
if (_tracker.goon(ctl,ctrlValue)) {
w_ADatFin=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FZWKNFCNEV',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH(NullDate(),'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
_ResetTracker();
return true;
}
}
return true;
}
function Set_DaDatFin(ctrlValue,kmode,e) {
if (Ne(w_DaDatFin,ctrlValue)) {
var ctl = _GetCtl(e,'QXLZEAPPUS');
if (_tracker.goon(ctl,ctrlValue)) {
w_DaDatFin=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QXLZEAPPUS',0);
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
function Link_UYVYTEMEXX(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_daRappo);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('RAPPORTO',w_daRappo,25,0);
l_Appl.SetFields('RAPPORTO,DESCRAP');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('jnarapbo');
l_Appl.SetID('UYVYTEMEXX');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_daRappo=l_Appl.GetStringValue('RAPPORTO',25,0);
w_desrap1=l_Appl.GetStringValue('DESCRAP',50,0);
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
w_daRappo='';
w_desrap1='';
}
function LOpt_UYVYTEMEXX() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('jnarapbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('RAPPORTO','C'));
l_oWv.setValue('LinkedField',WtA('RAPPORTO','C'));
l_oWv.setValue('UID',WtA('UYVYTEMEXX','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['UYVYTEMEXX'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('1678940755'),'C'));
return l_oWv;
}
function Link_CJWUHWULAR(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_aRappo);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('RAPPORTO',w_aRappo,25,0);
l_Appl.SetFields('RAPPORTO,DESCRAP');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('jnarapbo');
l_Appl.SetID('CJWUHWULAR');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_aRappo=l_Appl.GetStringValue('RAPPORTO',25,0);
w_desrap2=l_Appl.GetStringValue('DESCRAP',50,0);
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
if (l_bResult &&  ! (Empty(w_aRappo) && l_bEmp)) {
l_bResult=Ge(w_aRappo,w_daRappo);
if ( ! (l_bResult)) {
Link_CJWUHWULAR_Blank();
}
}
if ( ! (l_bResult)) {
m_nLastError=3;
m_cLastWorkVarErrorMsg='';
if (Lt(l_nRec,0)) {
m_cLastMsgError=Translate('MSG_CONNECT_SERVER');
} else {
m_cLastMsgError=AlertErrorMessage('10387154264');
}
}
}
return l_bResult;
}
function Link_CJWUHWULAR_Blank() {
w_aRappo='';
w_desrap2='';
}
function LOpt_CJWUHWULAR() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('jnarapbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('RAPPORTO','C'));
l_oWv.setValue('LinkedField',WtA('RAPPORTO','C'));
l_oWv.setValue('UID',WtA('CJWUHWULAR','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['CJWUHWULAR'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('1678940755'),'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'UYVYTEMEXX')) {
last_focused_comp=GetLastFocusedElementOfLink('UYVYTEMEXX');
function SetMethod_UYVYTEMEXX() {
Set_daRappo(HtW(value,'C'),0);
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
Set_aRappo(HtW(value,'C'),0);
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
m_cLastWorkVarErrorMsg='daRappo';
l_bResult=false;
w_daRappo=HtW('','C');
} else if (( ! (_ChkObl('CJWUHWULAR',1))) || ( ! (Empty(w_aRappo)) &&  ! (Ge(w_aRappo,w_daRappo)))) {
_SignErr('CJWUHWULAR','10387154264');
l_bResult=false;
w_aRappo=HtW('','C');
} else if ( ! (_ChkObl('AITVTFTATA',1))) {
_SignErr('AITVTFTATA');
m_cLastWorkVarErrorMsg='DaDatIni';
l_bResult=false;
w_DaDatIni=HtW('','D');
} else if ( ! (_ChkObl('KGOPKMFAZV',1))) {
_SignErr('KGOPKMFAZV');
m_cLastWorkVarErrorMsg='ADatIni';
l_bResult=false;
w_ADatIni=HtW('','D');
} else if ( ! (_ChkObl('HOUDAUAIJN',1))) {
_SignErr('HOUDAUAIJN');
m_cLastWorkVarErrorMsg='tipo';
l_bResult=false;
w_tipo=HtW('','C');
} else if ( ! (_ChkObl('QXLZEAPPUS',1))) {
_SignErr('QXLZEAPPUS');
m_cLastWorkVarErrorMsg='DaDatFin';
l_bResult=false;
w_DaDatFin=HtW('','D');
} else if ( ! (_ChkObl('FZWKNFCNEV',1))) {
_SignErr('FZWKNFCNEV');
m_cLastWorkVarErrorMsg='ADatFin';
l_bResult=false;
w_ADatFin=HtW('','D');
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
if (Eq('AITVTFTATA_ZOOM',lc)) {
return 2;
}
if (Eq('KGOPKMFAZV_ZOOM',lc)) {
return 2;
}
if (Eq('QXLZEAPPUS_ZOOM',lc)) {
return 2;
}
if (Eq('FZWKNFCNEV_ZOOM',lc)) {
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
l_oWv.setValue('daRappo',WtA(w_daRappo,'C'));
l_oWv.setValue('aRappo',WtA(w_aRappo,'C'));
l_oWv.setValue('desrap1',WtA(w_desrap1,'C'));
l_oWv.setValue('desrap2',WtA(w_desrap2,'C'));
l_oWv.setValue('DaDatIni',WtA(w_DaDatIni,'D'));
l_oWv.setValue('ADatIni',WtA(w_ADatIni,'D'));
l_oWv.setValue('tipo',WtA(w_tipo,'C'));
l_oWv.setValue('DaDatFin',WtA(w_DaDatFin,'D'));
l_oWv.setValue('ADatFin',WtA(w_ADatFin,'D'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["daRappo","aRappo","desrap1","desrap2","DaDatIni","ADatIni","tipo","DaDatFin","ADatFin"];
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
if (Eq(w_tipo,'T') && Ne(opener.w_tipo,null)) {
TransferBetweenWindows(opener,'w_tipo',null,'Set_tipo');
}
}
}
m_bCalculating=true;
Link_UYVYTEMEXX(null);
Link_CJWUHWULAR(null);
if (start && Eq(At(',tipo,',pseq),0)) {
w_tipo='T';
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
_Obli('daRappo',0,'UYVYTEMEXX',false)
_Obli('aRappo',0,'CJWUHWULAR',false)
_Obli('DaDatIni',2,'AITVTFTATA',false)
_Obli('ADatIni',2,'KGOPKMFAZV',false)
_Obli('tipo',0,'HOUDAUAIJN',false)
_Obli('ADatFin',2,'FZWKNFCNEV',false)
_Obli('DaDatFin',2,'QXLZEAPPUS',false)
