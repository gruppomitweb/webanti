function SetControlsValue() {
var c;
var c;
var tmp_TYIWXFLLFY = ToHTag(AsControlValue('<iframe width=\'800\' height=\'400\' id=\'elaborazione\'  name=\'elaborazione\' frameborder=\'1\'  border=\'1\' align=\'TOP\' marginwidth=\'1\' marginheight=\'1\'></iframe>'));
if (Ne(e_TYIWXFLLFY,tmp_TYIWXFLLFY)) {
if(c=Ctrl('TYIWXFLLFY')) c.innerHTML=tmp_TYIWXFLLFY;
e_TYIWXFLLFY=tmp_TYIWXFLLFY;
}
if(c=Ctrl('IXWESXTUQB')) ChkboxCheckUncheck(c,'S',w_flgagg)
if(c=Ctrl('IXWESXTUQB')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('YPNISOYHTS')) ChkboxCheckUncheck(c,'S',w_flgdel)
if(c=Ctrl('YPNISOYHTS')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('GTMJENMCMN')) c.value = WtH(w_anno,'N',4,0,'')
if(c=Ctrl('TCZMCNHUFI')) selectCombo(c,w_mese,'C')
if(c=Ctrl('FSXHJAAZGG')) c.value = WtH(w_dadata,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('CLVVMIYSQG')) c.value = WtH(w_a_data,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('AOHGKXZIJG')) ChkboxCheckUncheck(c,'S',w_flgstp)
if(c=Ctrl('AOHGKXZIJG')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('OSIUJJNLKT')) ChkboxCheckUncheck(c,'S',w_flgdett)
if(c=Ctrl('OSIUJJNLKT')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('LEQQQPGBLM')) ChkboxCheckUncheck(c,'S',w_flgnew)
if(c=Ctrl('LEQQQPGBLM')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay(Ctrl('KOFGMECQQN'),Ne(w_gFlgWU,'S'));
SetDisplay('OSIUJJNLKT_DIV',true);
HideUI();
}
HideUI.lblids["a_data"]=['LFJQIXRRKM'];
HideUI.lblids["anno"]=['YIXZTOKOBR'];
HideUI.lblids["dadata"]=['NOYEUIKFXN'];
HideUI.lblids["mese"]=['TTKGEZTDBH'];
function ALQVOOWZEV_Click() {
var l_oWv = InitWvApplet();
l_oWv.setValue('w_a_data',AsAppletValue(w_a_data));
l_oWv.setValue('w_anno',AsAppletValue(w_anno));
l_oWv.setValue('w_dadata',AsAppletValue(w_dadata));
l_oWv.setValue('w_flgagg',AsAppletValue(w_flgagg));
l_oWv.setValue('w_flgdel',AsAppletValue(w_flgdel));
l_oWv.setValue('w_flgnew',AsAppletValue(w_flgnew));
l_oWv.setValue('w_mese',AsAppletValue(w_mese));
l_oWv.setValue('w_flgstp',AsAppletValue(w_flgstp));
l_oWv.setValue('w_flgdett',AsAppletValue(w_flgdett));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('w_a_data,w_anno,w_dadata,w_flgagg,w_flgdel,w_flgnew,w_mese,w_flgstp,w_flgdett'));
if (false || WindowConfirm(Translate('1162057163'))) {
SetLocationHref(null,'arrt_faminvio_rettifiche'+'?m_cWv='+URLenc(l_oWv.asString())+'&m_cAction=start&m_cMode=hyperlink','elaborazione')
}
}
function href_AJXISNWTIP() {
SetLocationHref(window.location,ToResource('jsp/start_page_logo_portlet.jsp'+'')+'')
}
function href_JBNBDKBIAJ() {
_modifyandopen(ToResource('jsp/list_filesid_portlet.jsp'+'')+'?m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes,height=600,width=800',null)
}
function IXWESXTUQB_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_flgagg(ChkboxValueAssign(Ctrl('IXWESXTUQB'),'S','N','C',1,0,''),null,e);
}
function IXWESXTUQB_OnFocus(e) {
SetActiveField(Ctrl('IXWESXTUQB'),true);
}
function IXWESXTUQB_OnBlur(e) {
SetActiveField(Ctrl('IXWESXTUQB'),false);
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
function href_KOFGMECQQN() {
SetLocationHref(null,'arrt_famgetdgn'+'?m_cAction=start&m_cAtExit=close&m_cMode=hyperlink','elaborazione')
}
function OSIUJJNLKT_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_flgdett(ChkboxValueAssign(Ctrl('OSIUJJNLKT'),'S','N','C',1,0,''),null,e);
}
function OSIUJJNLKT_OnFocus(e) {
SetActiveField(Ctrl('OSIUJJNLKT'),true);
}
function OSIUJJNLKT_OnBlur(e) {
SetActiveField(Ctrl('OSIUJJNLKT'),false);
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
if(c=Ctrl('IXWESXTUQB')) c.onclick=IXWESXTUQB_Valid;
if(c=Ctrl('IXWESXTUQB')) c.onfocus=IXWESXTUQB_OnFocus;
if(c=Ctrl('IXWESXTUQB')) c.onblur=IXWESXTUQB_OnBlur;
if(c=Ctrl('GTMJENMCMN')) c.onblur=GTMJENMCMN_Valid;
if(c=Ctrl('GTMJENMCMN')) c.onfocus=GTMJENMCMN_OnFocus;
if(c=Ctrl('GTMJENMCMN')) c.onkeypress=CheckNum;
if(c=Ctrl('TCZMCNHUFI')) c.onchange=TCZMCNHUFI_Valid;
if(c=Ctrl('TCZMCNHUFI')) c.onfocus=TCZMCNHUFI_OnFocus;
if(c=Ctrl('TCZMCNHUFI')) c.onblur=TCZMCNHUFI_OnBlur;
if(c=Ctrl('OSIUJJNLKT')) c.onclick=OSIUJJNLKT_Valid;
if(c=Ctrl('OSIUJJNLKT')) c.onfocus=OSIUJJNLKT_OnFocus;
if(c=Ctrl('OSIUJJNLKT')) c.onblur=OSIUJJNLKT_OnBlur;
}
}
function NotifyEvent(p_cEvent) {
var old_c;
if (Ne(typeof(w_Messaggi),'undefined')) {
w_Messaggi.raiseEvent('arpg_faminvio_rettifiche_'+Strtran(p_cEvent,' ','_'));
}
if (Ne(typeof(w_Log),'undefined')) {
w_Log.raiseEvent('arpg_faminvio_rettifiche_'+Strtran(p_cEvent,' ','_'));
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
windowOpenForeground('../doc/arpg_faminvio_rettifiche_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_flgagg=a[2];
w_flgdel=a[3];
w_anno=a[4];
w_mese=a[5];
w_dadata=a[6];
w_a_data=a[7];
w_flgstp=a[8];
w_gFlgWU=a[9];
w_flgdett=a[10];
w_flgnew=a[11];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_faminvio_rettifiche',m_cSelectedPage);
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
function Set_flgagg(ctrlValue,kmode,e) {
if (Ne(w_flgagg,ctrlValue)) {
var ctl = _GetCtl(e,'IXWESXTUQB');
if (_tracker.goon(ctl,ctrlValue)) {
w_flgagg=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('IXWESXTUQB',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_flgdett(ctrlValue,kmode,e) {
if (Ne(w_flgdett,ctrlValue)) {
var ctl = _GetCtl(e,'OSIUJJNLKT');
if (_tracker.goon(ctl,ctrlValue)) {
w_flgdett=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('OSIUJJNLKT',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
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
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','N',4,0,'');
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
if ( ! (_ChkObl('IXWESXTUQB',1))) {
_SignErr('IXWESXTUQB');
m_cLastWorkVarErrorMsg='flgagg';
l_bResult=false;
w_flgagg='N';
} else if ( ! (_ChkObl('GTMJENMCMN',1))) {
_SignErr('GTMJENMCMN');
m_cLastWorkVarErrorMsg='anno';
l_bResult=false;
w_anno=HtW('','N');
} else if ( ! (_ChkObl('TCZMCNHUFI',1))) {
_SignErr('TCZMCNHUFI');
m_cLastWorkVarErrorMsg='mese';
l_bResult=false;
w_mese=HtW('','C');
} else if ( ! (_ChkObl('OSIUJJNLKT',1))) {
_SignErr('OSIUJJNLKT');
m_cLastWorkVarErrorMsg='flgdett';
l_bResult=false;
w_flgdett='N';
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
l_oWv.setValue('flgagg',WtA(w_flgagg,'C'));
l_oWv.setValue('flgdel',WtA(w_flgdel,'C'));
l_oWv.setValue('anno',WtA(w_anno,'N'));
l_oWv.setValue('mese',WtA(w_mese,'C'));
l_oWv.setValue('dadata',WtA(w_dadata,'D'));
l_oWv.setValue('a_data',WtA(w_a_data,'D'));
l_oWv.setValue('flgstp',WtA(w_flgstp,'C'));
l_oWv.setValue('gFlgWU',WtA(w_gFlgWU,'C'));
l_oWv.setValue('flgdett',WtA(w_flgdett,'C'));
l_oWv.setValue('flgnew',WtA(w_flgnew,'C'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["gIntemediario","gDescAzi","flgagg","flgdel","anno","mese","dadata","a_data","flgstp","gFlgWU","flgdett","flgnew"];
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
if (start && Eq(At(',flgagg,',pseq),0)) {
w_flgagg='S';
}
if (start && Eq(At(',flgdel,',pseq),0)) {
w_flgdel='N';
}
if (start && Eq(At(',anno,',pseq),0)) {
w_anno=Year(SystemDate());
}
w_dadata=( ! (Empty(w_anno)) &&  ! (Empty(w_mese))?CharToDate(Str(w_anno,4,0)+w_mese+'01'):NullDate());
w_a_data=arfn_finemese(w_dadata);
if (start && Eq(At(',flgstp,',pseq),0)) {
w_flgstp='S';
}
if (start && Eq(At(',flgdett,',pseq),0)) {
w_flgdett='N';
}
if (start && Eq(At(',flgnew,',pseq),0)) {
w_flgnew='N';
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
_Obli('mese',0,'TCZMCNHUFI',true)
_Obli('flgagg',0,'IXWESXTUQB',false)
_Obli('flgdett',0,'OSIUJJNLKT',false)
_Obli('anno',1,'GTMJENMCMN',false)
