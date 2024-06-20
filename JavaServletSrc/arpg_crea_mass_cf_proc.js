function SetControlsValue() {
var c;
var c;
if(c=Ctrl('CPBCFXOJEC')) selectCombo(c,w_tiposog,'C')
var tmp_FGMOCXNBFY = ToHTag(AsControlValue('<iframe width=\'655\' height=\'170\' id=\'elaborazione\'  name=\'elaborazione\' frameborder=\'1\'  border=\'1\' align=\'TOP\' marginwidth=\'1\' marginheight=\'1\'></iframe>'));
if (Ne(e_FGMOCXNBFY,tmp_FGMOCXNBFY)) {
if(c=Ctrl('FGMOCXNBFY')) c.innerHTML=tmp_FGMOCXNBFY;
e_FGMOCXNBFY=tmp_FGMOCXNBFY;
}
if(c=Ctrl('AKHAWZVTWL')) selectRadio(c,w_tipoinv,'C')
if(c=Ctrl('FSIGQXURNL')) c.value = WtH(w_maxinvii,'N',10,0,'')
if(c=Ctrl('KLUTVGESET')) ChkboxCheckUncheck(c,'S',w_a2011)
if(c=Ctrl('KLUTVGESET')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('WFROVCSJJF')) ChkboxCheckUncheck(c,'S',w_a2012)
if(c=Ctrl('WFROVCSJJF')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('VHNANTQLDO')) ChkboxCheckUncheck(c,'S',w_a2013)
if(c=Ctrl('VHNANTQLDO')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('NYQRDWPVQW')) ChkboxCheckUncheck(c,'S',w_a2014)
if(c=Ctrl('NYQRDWPVQW')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('EWRHUMIOJD')) ChkboxCheckUncheck(c,'S',w_a2015)
if(c=Ctrl('EWRHUMIOJD')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('YRRCXCTEWB')) ChkboxCheckUncheck(c,'S',w_a2016)
if(c=Ctrl('YRRCXCTEWB')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('SVHKBBCQHM')) ChkboxCheckUncheck(c,'S',w_a2017)
if(c=Ctrl('SVHKBBCQHM')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('NLIHHTTFII')) ChkboxCheckUncheck(c,'S',w_a2018)
if(c=Ctrl('NLIHHTTFII')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('EFUHYXQNOB')) ChkboxCheckUncheck(c,'S',w_a2019)
if(c=Ctrl('EFUHYXQNOB')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay(Ctrl('FGMOCXNBFY'),true);
SetDisplay(Ctrl('FSIGQXURNL'),Eq(w_tipoinv,'G') || IsHiddenByStateDriver('maxinvii'));
SetDisplay(Ctrl('VNUQKFZYEW'),Eq(w_tipoinv,'G'));
SetDisplay(Ctrl('OKFXLPIBJW'),Eq(w_tipoinv,'G'));
SetDisplay('KLUTVGESET_DIV',Eq(w_tipoinv,'G'));
SetDisplay(Ctrl('YXROKNYPVY'),Eq(w_tipoinv,'G'));
SetDisplay('WFROVCSJJF_DIV',Eq(w_tipoinv,'G'));
SetDisplay('VHNANTQLDO_DIV',Eq(w_tipoinv,'G'));
SetDisplay('NYQRDWPVQW_DIV',Eq(w_tipoinv,'G'));
SetDisplay('EWRHUMIOJD_DIV',Eq(w_tipoinv,'G'));
SetDisplay('YRRCXCTEWB_DIV',Eq(w_tipoinv,'G'));
SetDisplay('SVHKBBCQHM_DIV',Eq(w_tipoinv,'G'));
SetDisplay('NLIHHTTFII_DIV',Eq(w_tipoinv,'G'));
SetDisplay('EFUHYXQNOB_DIV',Eq(w_tipoinv,'G'));
SetDisplay(Ctrl('ZCHZGJTEXB'),true);
HideUI();
}
HideUI.lblids["a2014"]=['YXROKNYPVY'];
HideUI.lblids["maxinvii"]=['VNUQKFZYEW'];
function ALQVOOWZEV_Click() {
if (false || WindowConfirm(Translate('1162057163'))) {
Lancio()
}
}
function href_AJXISNWTIP() {
SetLocationHref(window.location,ToResource('jsp/start_page_logo_portlet.jsp'+'')+'')
}
function href_JBNBDKBIAJ() {
_modifyandopen(ToResource('jsp/list_filesid_portlet.jsp'+'')+'?m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes,height=600,width=800',null)
}
function CPBCFXOJEC_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_tiposog(HtW(getComboValue(Ctrl('CPBCFXOJEC')),'C'),null,e);
}
function CPBCFXOJEC_OnFocus(e) {
SetActiveField(Ctrl('CPBCFXOJEC'),true);
}
function CPBCFXOJEC_OnBlur(e) {
SetActiveField(Ctrl('CPBCFXOJEC'),false);
}
function AKHAWZVTWL_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_tipoinv(HtW(getRadioValue(Ctrl('AKHAWZVTWL')),'C'),null,e);
}
function OKFXLPIBJW_Click() {
if (false || WindowConfirm(Translate('11421805868'))) {
Calcola()
}
}
function KLUTVGESET_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_a2011(ChkboxValueAssign(Ctrl('KLUTVGESET'),'S','N','C',1,0,''),null,e);
}
function KLUTVGESET_OnFocus(e) {
SetActiveField(Ctrl('KLUTVGESET'),true);
}
function KLUTVGESET_OnBlur(e) {
SetActiveField(Ctrl('KLUTVGESET'),false);
}
function WFROVCSJJF_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_a2012(ChkboxValueAssign(Ctrl('WFROVCSJJF'),'S','N','C',1,0,''),null,e);
}
function WFROVCSJJF_OnFocus(e) {
SetActiveField(Ctrl('WFROVCSJJF'),true);
}
function WFROVCSJJF_OnBlur(e) {
SetActiveField(Ctrl('WFROVCSJJF'),false);
}
function VHNANTQLDO_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_a2013(ChkboxValueAssign(Ctrl('VHNANTQLDO'),'S','N','C',1,0,''),null,e);
}
function VHNANTQLDO_OnFocus(e) {
SetActiveField(Ctrl('VHNANTQLDO'),true);
}
function VHNANTQLDO_OnBlur(e) {
SetActiveField(Ctrl('VHNANTQLDO'),false);
}
function NYQRDWPVQW_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_a2014(ChkboxValueAssign(Ctrl('NYQRDWPVQW'),'S','N','C',1,0,''),null,e);
}
function NYQRDWPVQW_OnFocus(e) {
SetActiveField(Ctrl('NYQRDWPVQW'),true);
}
function NYQRDWPVQW_OnBlur(e) {
SetActiveField(Ctrl('NYQRDWPVQW'),false);
}
function EWRHUMIOJD_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_a2015(ChkboxValueAssign(Ctrl('EWRHUMIOJD'),'S','N','C',1,0,''),null,e);
}
function EWRHUMIOJD_OnFocus(e) {
SetActiveField(Ctrl('EWRHUMIOJD'),true);
}
function EWRHUMIOJD_OnBlur(e) {
SetActiveField(Ctrl('EWRHUMIOJD'),false);
}
function YRRCXCTEWB_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_a2016(ChkboxValueAssign(Ctrl('YRRCXCTEWB'),'S','N','C',1,0,''),null,e);
}
function YRRCXCTEWB_OnFocus(e) {
SetActiveField(Ctrl('YRRCXCTEWB'),true);
}
function YRRCXCTEWB_OnBlur(e) {
SetActiveField(Ctrl('YRRCXCTEWB'),false);
}
function SVHKBBCQHM_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_a2017(ChkboxValueAssign(Ctrl('SVHKBBCQHM'),'S','N','C',1,0,''),null,e);
}
function SVHKBBCQHM_OnFocus(e) {
SetActiveField(Ctrl('SVHKBBCQHM'),true);
}
function SVHKBBCQHM_OnBlur(e) {
SetActiveField(Ctrl('SVHKBBCQHM'),false);
}
function NLIHHTTFII_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_a2018(ChkboxValueAssign(Ctrl('NLIHHTTFII'),'S','N','C',1,0,''),null,e);
}
function NLIHHTTFII_OnFocus(e) {
SetActiveField(Ctrl('NLIHHTTFII'),true);
}
function NLIHHTTFII_OnBlur(e) {
SetActiveField(Ctrl('NLIHHTTFII'),false);
}
function EFUHYXQNOB_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_a2019(ChkboxValueAssign(Ctrl('EFUHYXQNOB'),'S','N','C',1,0,''),null,e);
}
function EFUHYXQNOB_OnFocus(e) {
SetActiveField(Ctrl('EFUHYXQNOB'),true);
}
function EFUHYXQNOB_OnBlur(e) {
SetActiveField(Ctrl('EFUHYXQNOB'),false);
}
function ZCHZGJTEXB_Click() {
SetLocationHref(null,'arrt_crea_mass_cf'+'?m_cAction=start&m_cMode=hyperlink','elaborazione')
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
if(c=Ctrl('CPBCFXOJEC')) c.onchange=CPBCFXOJEC_Valid;
if(c=Ctrl('CPBCFXOJEC')) c.onfocus=CPBCFXOJEC_OnFocus;
if(c=Ctrl('CPBCFXOJEC')) c.onblur=CPBCFXOJEC_OnBlur;
c=Ctrl('AKHAWZVTWL');
if ( ! (Empty(c))) {
c[0].onclick=AKHAWZVTWL_Valid;
c[1].onclick=AKHAWZVTWL_Valid;
c[2].onclick=AKHAWZVTWL_Valid;
}
if(c=Ctrl('KLUTVGESET')) c.onclick=KLUTVGESET_Valid;
if(c=Ctrl('KLUTVGESET')) c.onfocus=KLUTVGESET_OnFocus;
if(c=Ctrl('KLUTVGESET')) c.onblur=KLUTVGESET_OnBlur;
if(c=Ctrl('WFROVCSJJF')) c.onclick=WFROVCSJJF_Valid;
if(c=Ctrl('WFROVCSJJF')) c.onfocus=WFROVCSJJF_OnFocus;
if(c=Ctrl('WFROVCSJJF')) c.onblur=WFROVCSJJF_OnBlur;
if(c=Ctrl('VHNANTQLDO')) c.onclick=VHNANTQLDO_Valid;
if(c=Ctrl('VHNANTQLDO')) c.onfocus=VHNANTQLDO_OnFocus;
if(c=Ctrl('VHNANTQLDO')) c.onblur=VHNANTQLDO_OnBlur;
if(c=Ctrl('NYQRDWPVQW')) c.onclick=NYQRDWPVQW_Valid;
if(c=Ctrl('NYQRDWPVQW')) c.onfocus=NYQRDWPVQW_OnFocus;
if(c=Ctrl('NYQRDWPVQW')) c.onblur=NYQRDWPVQW_OnBlur;
if(c=Ctrl('EWRHUMIOJD')) c.onclick=EWRHUMIOJD_Valid;
if(c=Ctrl('EWRHUMIOJD')) c.onfocus=EWRHUMIOJD_OnFocus;
if(c=Ctrl('EWRHUMIOJD')) c.onblur=EWRHUMIOJD_OnBlur;
if(c=Ctrl('YRRCXCTEWB')) c.onclick=YRRCXCTEWB_Valid;
if(c=Ctrl('YRRCXCTEWB')) c.onfocus=YRRCXCTEWB_OnFocus;
if(c=Ctrl('YRRCXCTEWB')) c.onblur=YRRCXCTEWB_OnBlur;
if(c=Ctrl('SVHKBBCQHM')) c.onclick=SVHKBBCQHM_Valid;
if(c=Ctrl('SVHKBBCQHM')) c.onfocus=SVHKBBCQHM_OnFocus;
if(c=Ctrl('SVHKBBCQHM')) c.onblur=SVHKBBCQHM_OnBlur;
if(c=Ctrl('NLIHHTTFII')) c.onclick=NLIHHTTFII_Valid;
if(c=Ctrl('NLIHHTTFII')) c.onfocus=NLIHHTTFII_OnFocus;
if(c=Ctrl('NLIHHTTFII')) c.onblur=NLIHHTTFII_OnBlur;
if(c=Ctrl('EFUHYXQNOB')) c.onclick=EFUHYXQNOB_Valid;
if(c=Ctrl('EFUHYXQNOB')) c.onfocus=EFUHYXQNOB_OnFocus;
if(c=Ctrl('EFUHYXQNOB')) c.onblur=EFUHYXQNOB_OnBlur;
}
}
function NotifyEvent(p_cEvent) {
var old_c;
if (Ne(typeof(w_pMsg),'undefined')) {
w_pMsg.raiseEvent('arpg_crea_mass_cf_'+Strtran(p_cEvent,' ','_'));
}
if (Ne(typeof(w_pLog),'undefined')) {
w_pLog.raiseEvent('arpg_crea_mass_cf_'+Strtran(p_cEvent,' ','_'));
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
FocusFirstComponent.otherwise={"page_1":["ALQVOOWZEV"]};
function Help() {
windowOpenForeground('../doc/arpg_crea_mass_cf_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_gIntemediario=a[0];
w_gDescAzi=a[1];
w_gFlgWU=a[2];
w_tiposog=a[3];
w_tipoout=a[4];
w_tipoinv=a[5];
w_maxinvii=a[6];
w_a2011=a[7];
w_a2012=a[8];
w_a2013=a[9];
w_a2014=a[10];
w_a2015=a[11];
w_a2016=a[12];
w_a2017=a[13];
w_a2018=a[14];
w_a2019=a[15];
o_tipoinv=w_tipoinv[1];
w_tipoinv=w_tipoinv[0];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_crea_mass_cf',m_cSelectedPage);
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
function Set_a2011(ctrlValue,kmode,e) {
if (Ne(w_a2011,ctrlValue)) {
var ctl = _GetCtl(e,'KLUTVGESET');
if (_tracker.goon(ctl,ctrlValue)) {
w_a2011=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('KLUTVGESET',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_a2012(ctrlValue,kmode,e) {
if (Ne(w_a2012,ctrlValue)) {
var ctl = _GetCtl(e,'WFROVCSJJF');
if (_tracker.goon(ctl,ctrlValue)) {
w_a2012=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('WFROVCSJJF',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_a2019(ctrlValue,kmode,e) {
if (Ne(w_a2019,ctrlValue)) {
var ctl = _GetCtl(e,'EFUHYXQNOB');
if (_tracker.goon(ctl,ctrlValue)) {
w_a2019=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('EFUHYXQNOB',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_tiposog(ctrlValue,kmode,e) {
if (Ne(w_tiposog,ctrlValue)) {
var ctl = _GetCtl(e,'CPBCFXOJEC');
if (_tracker.goon(ctl,ctrlValue)) {
w_tiposog=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CPBCFXOJEC',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_a2013(ctrlValue,kmode,e) {
if (Ne(w_a2013,ctrlValue)) {
var ctl = _GetCtl(e,'VHNANTQLDO');
if (_tracker.goon(ctl,ctrlValue)) {
w_a2013=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VHNANTQLDO',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_tipoinv(ctrlValue,kmode,e) {
if (Ne(w_tipoinv,ctrlValue)) {
var ctl = _GetCtl(e,'AKHAWZVTWL');
if (_tracker.goon(ctl,ctrlValue)) {
w_tipoinv=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('AKHAWZVTWL',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_a2014(ctrlValue,kmode,e) {
if (Ne(w_a2014,ctrlValue)) {
var ctl = _GetCtl(e,'NYQRDWPVQW');
if (_tracker.goon(ctl,ctrlValue)) {
w_a2014=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NYQRDWPVQW',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_a2018(ctrlValue,kmode,e) {
if (Ne(w_a2018,ctrlValue)) {
var ctl = _GetCtl(e,'NLIHHTTFII');
if (_tracker.goon(ctl,ctrlValue)) {
w_a2018=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NLIHHTTFII',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_a2017(ctrlValue,kmode,e) {
if (Ne(w_a2017,ctrlValue)) {
var ctl = _GetCtl(e,'SVHKBBCQHM');
if (_tracker.goon(ctl,ctrlValue)) {
w_a2017=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SVHKBBCQHM',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_a2016(ctrlValue,kmode,e) {
if (Ne(w_a2016,ctrlValue)) {
var ctl = _GetCtl(e,'YRRCXCTEWB');
if (_tracker.goon(ctl,ctrlValue)) {
w_a2016=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YRRCXCTEWB',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_a2015(ctrlValue,kmode,e) {
if (Ne(w_a2015,ctrlValue)) {
var ctl = _GetCtl(e,'EWRHUMIOJD');
if (_tracker.goon(ctl,ctrlValue)) {
w_a2015=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('EWRHUMIOJD',0);
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
if ((Ne(o_tipoinv,w_tipoinv))) {
Calculation_OSQHWBQMCE();
}
// * --- Area Manuale = UI - Calculate
// * --- Fine Area Manuale
m_bCalculating=false;
}
function Calculation_OSQHWBQMCE() {
w_maxinvii=0;
}
function SaveDependsOn() {
o_tipoinv=w_tipoinv;
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
if ( ! (_ChkObl('CPBCFXOJEC',1))) {
_SignErr('CPBCFXOJEC');
m_cLastWorkVarErrorMsg='tiposog';
l_bResult=false;
w_tiposog=HtW('','C');
} else if ( ! (_ChkObl('AKHAWZVTWL',1))) {
_SignErr('AKHAWZVTWL');
m_cLastWorkVarErrorMsg='tipoinv';
l_bResult=false;
w_tipoinv=HtW('','C');
} else if ( ! (_ChkObl('KLUTVGESET',1))) {
_SignErr('KLUTVGESET');
m_cLastWorkVarErrorMsg='a2011';
l_bResult=false;
w_a2011='N';
} else if ( ! (_ChkObl('WFROVCSJJF',1))) {
_SignErr('WFROVCSJJF');
m_cLastWorkVarErrorMsg='a2012';
l_bResult=false;
w_a2012='N';
} else if ( ! (_ChkObl('VHNANTQLDO',1))) {
_SignErr('VHNANTQLDO');
m_cLastWorkVarErrorMsg='a2013';
l_bResult=false;
w_a2013='N';
} else if ( ! (_ChkObl('NYQRDWPVQW',1))) {
_SignErr('NYQRDWPVQW');
m_cLastWorkVarErrorMsg='a2014';
l_bResult=false;
w_a2014='N';
} else if ( ! (_ChkObl('EWRHUMIOJD',1))) {
_SignErr('EWRHUMIOJD');
m_cLastWorkVarErrorMsg='a2015';
l_bResult=false;
w_a2015='N';
} else if ( ! (_ChkObl('YRRCXCTEWB',1))) {
_SignErr('YRRCXCTEWB');
m_cLastWorkVarErrorMsg='a2016';
l_bResult=false;
w_a2016='N';
} else if ( ! (_ChkObl('SVHKBBCQHM',1))) {
_SignErr('SVHKBBCQHM');
m_cLastWorkVarErrorMsg='a2017';
l_bResult=false;
w_a2017='N';
} else if ( ! (_ChkObl('NLIHHTTFII',1))) {
_SignErr('NLIHHTTFII');
m_cLastWorkVarErrorMsg='a2018';
l_bResult=false;
w_a2018='N';
} else if ( ! (_ChkObl('EFUHYXQNOB',1))) {
_SignErr('EFUHYXQNOB');
m_cLastWorkVarErrorMsg='a2019';
l_bResult=false;
w_a2019='N';
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
return -1;
}
function link_url(index) {
var l_oWv;
}
function FillWv() {
var l_oWv = InitWvApplet();
l_oWv.setValue('gIntemediario',WtA(w_gIntemediario,'C'));
l_oWv.setValue('gDescAzi',WtA(w_gDescAzi,'C'));
l_oWv.setValue('gFlgWU',WtA(w_gFlgWU,'C'));
l_oWv.setValue('tiposog',WtA(w_tiposog,'C'));
l_oWv.setValue('tipoout',WtA(w_tipoout,'C'));
l_oWv.setValue('tipoinv',WtA(w_tipoinv,'C'));
l_oWv.setValue('maxinvii',WtA(w_maxinvii,'N'));
l_oWv.setValue('a2011',WtA(w_a2011,'C'));
l_oWv.setValue('a2012',WtA(w_a2012,'C'));
l_oWv.setValue('a2013',WtA(w_a2013,'C'));
l_oWv.setValue('a2014',WtA(w_a2014,'C'));
l_oWv.setValue('a2015',WtA(w_a2015,'C'));
l_oWv.setValue('a2016',WtA(w_a2016,'C'));
l_oWv.setValue('a2017',WtA(w_a2017,'C'));
l_oWv.setValue('a2018',WtA(w_a2018,'C'));
l_oWv.setValue('a2019',WtA(w_a2019,'C'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["gIntemediario","gDescAzi","gFlgWU","tiposog","tipoout","tipoinv","maxinvii","a2011","a2012","a2013","a2014","a2015","a2016","a2017","a2018","a2019"];
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
if (start && Eq(At(',tiposog,',pseq),0)) {
w_tiposog='T';
}
if (start && Eq(At(',tipoout,',pseq),0)) {
w_tipoout='P';
}
if (start && Eq(At(',tipoinv,',pseq),0)) {
w_tipoinv='P';
}
if (start && Eq(At(',a2011,',pseq),0)) {
w_a2011='S';
}
if (start && Eq(At(',a2012,',pseq),0)) {
w_a2012='S';
}
if (start && Eq(At(',a2013,',pseq),0)) {
w_a2013='S';
}
if (start && Eq(At(',a2014,',pseq),0)) {
w_a2014='S';
}
if (start && Eq(At(',a2015,',pseq),0)) {
w_a2015='S';
}
if (start && Eq(At(',a2016,',pseq),0)) {
w_a2016='S';
}
if (start && Eq(At(',a2017,',pseq),0)) {
w_a2017='S';
}
if (start && Eq(At(',a2018,',pseq),0)) {
w_a2018='N';
}
if (start && Eq(At(',a2019,',pseq),0)) {
w_a2019='N';
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
_Obli('a2011',0,'KLUTVGESET',false)
_Obli('a2012',0,'WFROVCSJJF',false)
_Obli('a2019',0,'EFUHYXQNOB',false)
_Obli('tiposog',0,'CPBCFXOJEC',false)
_Obli('a2013',0,'VHNANTQLDO',false)
_Obli('tipoinv',0,'AKHAWZVTWL',false)
_Obli('a2014',0,'NYQRDWPVQW',false)
_Obli('a2018',0,'NLIHHTTFII',false)
_Obli('a2017',0,'SVHKBBCQHM',false)
_Obli('a2016',0,'YRRCXCTEWB',false)
_Obli('a2015',0,'EWRHUMIOJD',false)
