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
if(c=Ctrl('FSXHJAAZGG')) c.value = WtH(w_dadata,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('CLVVMIYSQG')) c.value = WtH(w_a_data,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('HXKWFJUKYF')) ChkboxCheckUncheck(c,'S',w_flgnac)
if(c=Ctrl('HXKWFJUKYF')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('FPCAMDEOBC')) ChkboxCheckUncheck(c,'S',w_flgagr)
if(c=Ctrl('FPCAMDEOBC')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('ZIYTFHOZPJ')) ChkboxCheckUncheck(c,'S',w_flgadl)
if(c=Ctrl('ZIYTFHOZPJ')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay(Ctrl('FGMOCXNBFY'),true);
HideUI();
}
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
function ALQVOOWZEV_Click() {
if ( ! (Empty(w_anno)) &&  ! (Empty(w_mese))) {
if (false || WindowConfirm(Translate('11908105198'))) {
SetLocationHref(null,'arrt_ae_inviomese'+'?m_cAction=start&m_cMode=hyperlink','elaborazione')
}
}
}
function href_AJXISNWTIP() {
SetLocationHref(window.location,ToResource('jsp/start_page_logo_portlet.jsp'+'')+'')
}
function href_JBNBDKBIAJ() {
_modifyandopen('arpg_filesage'+'?m_cAction=start&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes,height=600,width=800',null)
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
function HXKWFJUKYF_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_flgnac(ChkboxValueAssign(Ctrl('HXKWFJUKYF'),'S','N','C',1,0,''),null,e);
}
function HXKWFJUKYF_OnFocus(e) {
SetActiveField(Ctrl('HXKWFJUKYF'),true);
}
function HXKWFJUKYF_OnBlur(e) {
SetActiveField(Ctrl('HXKWFJUKYF'),false);
}
function FPCAMDEOBC_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_flgagr(ChkboxValueAssign(Ctrl('FPCAMDEOBC'),'S','N','C',1,0,''),null,e);
}
function FPCAMDEOBC_OnFocus(e) {
SetActiveField(Ctrl('FPCAMDEOBC'),true);
}
function FPCAMDEOBC_OnBlur(e) {
SetActiveField(Ctrl('FPCAMDEOBC'),false);
}
function ZIYTFHOZPJ_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_flgadl(ChkboxValueAssign(Ctrl('ZIYTFHOZPJ'),'S','N','C',1,0,''),null,e);
}
function ZIYTFHOZPJ_OnFocus(e) {
SetActiveField(Ctrl('ZIYTFHOZPJ'),true);
}
function ZIYTFHOZPJ_OnBlur(e) {
SetActiveField(Ctrl('ZIYTFHOZPJ'),false);
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
if(c=Ctrl('HXKWFJUKYF')) c.onclick=HXKWFJUKYF_Valid;
if(c=Ctrl('HXKWFJUKYF')) c.onfocus=HXKWFJUKYF_OnFocus;
if(c=Ctrl('HXKWFJUKYF')) c.onblur=HXKWFJUKYF_OnBlur;
if(c=Ctrl('FPCAMDEOBC')) c.onclick=FPCAMDEOBC_Valid;
if(c=Ctrl('FPCAMDEOBC')) c.onfocus=FPCAMDEOBC_OnFocus;
if(c=Ctrl('FPCAMDEOBC')) c.onblur=FPCAMDEOBC_OnBlur;
if(c=Ctrl('ZIYTFHOZPJ')) c.onclick=ZIYTFHOZPJ_Valid;
if(c=Ctrl('ZIYTFHOZPJ')) c.onfocus=ZIYTFHOZPJ_OnFocus;
if(c=Ctrl('ZIYTFHOZPJ')) c.onblur=ZIYTFHOZPJ_OnBlur;
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
FocusFirstComponent.otherwise={"page_1":["GTMJENMCMN"]};
function Help() {
windowOpenForeground('../doc/arpg_ae_inviomese_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_dadata=a[2];
w_a_data=a[3];
w_gIntemediario=a[4];
w_gDescAzi=a[5];
w_flgnac=a[6];
w_flgagr=a[7];
w_flgadl=a[8];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_ae_inviomese',m_cSelectedPage);
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
l_bEnabled= ! ( ! (Empty(w_anno)) &&  ! (Empty(w_mese)));
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
l_bResult=Ge(w_anno,2011);
if ( ! (l_bResult)) {
m_nLastError=2;
m_cLastWorkVarErrorMsg='anno';
m_cLastMsgError=AlertErrorMessage('10389526674');
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
function Set_flgagr(ctrlValue,kmode,e) {
if (Ne(w_flgagr,ctrlValue)) {
var ctl = _GetCtl(e,'FPCAMDEOBC');
if (_tracker.goon(ctl,ctrlValue)) {
w_flgagr=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FPCAMDEOBC',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_flgadl(ctrlValue,kmode,e) {
if (Ne(w_flgadl,ctrlValue)) {
var ctl = _GetCtl(e,'ZIYTFHOZPJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_flgadl=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ZIYTFHOZPJ',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_flgnac(ctrlValue,kmode,e) {
if (Ne(w_flgnac,ctrlValue)) {
var ctl = _GetCtl(e,'HXKWFJUKYF');
if (_tracker.goon(ctl,ctrlValue)) {
w_flgnac=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HXKWFJUKYF',0);
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
if (( ! (_ChkObl('GTMJENMCMN',1))) || ( ! (Ge(w_anno,2011)))) {
_SignErr('GTMJENMCMN','10389526674');
l_bResult=false;
w_anno=HtW('','N');
} else if (( ! (_ChkObl('TCZMCNHUFI',1))) || ( ! (((Eq(w_anno,2007) && Ge(w_mese,'05')) || Gt(w_anno,2007)?true:false)))) {
_SignErr('TCZMCNHUFI','11240429377');
l_bResult=false;
w_mese=HtW('','C');
} else if ( ! (_ChkObl('HXKWFJUKYF',1))) {
_SignErr('HXKWFJUKYF');
m_cLastWorkVarErrorMsg='flgnac';
l_bResult=false;
w_flgnac='N';
} else if ( ! (_ChkObl('FPCAMDEOBC',1))) {
_SignErr('FPCAMDEOBC');
m_cLastWorkVarErrorMsg='flgagr';
l_bResult=false;
w_flgagr='N';
} else if ( ! (_ChkObl('ZIYTFHOZPJ',1))) {
_SignErr('ZIYTFHOZPJ');
m_cLastWorkVarErrorMsg='flgadl';
l_bResult=false;
w_flgadl='N';
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
l_oWv.setValue('anno',WtA(w_anno,'N'));
l_oWv.setValue('mese',WtA(w_mese,'C'));
l_oWv.setValue('dadata',WtA(w_dadata,'D'));
l_oWv.setValue('a_data',WtA(w_a_data,'D'));
l_oWv.setValue('gIntemediario',WtA(w_gIntemediario,'C'));
l_oWv.setValue('gDescAzi',WtA(w_gDescAzi,'C'));
l_oWv.setValue('flgnac',WtA(w_flgnac,'C'));
l_oWv.setValue('flgagr',WtA(w_flgagr,'C'));
l_oWv.setValue('flgadl',WtA(w_flgadl,'C'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["anno","mese","dadata","a_data","gIntemediario","gDescAzi","flgnac","flgagr","flgadl"];
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
if (start && Eq(At(',anno,',pseq),0)) {
w_anno=Year(SystemDate());
}
w_dadata=( ! (Empty(w_anno)) &&  ! (Empty(w_mese))?CharToDate(Str(w_anno,4,0)+w_mese+'01'):NullDate());
w_a_data=arfn_finemese(w_dadata);
if (start && Eq(At(',flgnac,',pseq),0)) {
w_flgnac='S';
}
if (start && Eq(At(',flgagr,',pseq),0)) {
w_flgagr='S';
}
if (start && Eq(At(',flgadl,',pseq),0)) {
w_flgadl='S';
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
_Obli('flgagr',0,'FPCAMDEOBC',false)
_Obli('flgadl',0,'ZIYTFHOZPJ',false)
_Obli('flgnac',0,'HXKWFJUKYF',false)
