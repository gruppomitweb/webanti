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
if(c=Ctrl('QSCZHDCMTE')) selectCombo(c,w_tipofile,'N')
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
HideUI.lblids["tipofile"]=['HZEUQGYLEE'];
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
if ( ! (Empty(w_dadata)) &&  ! (Empty(w_a_data))) {
if (false || WindowConfirm(Translate('1312852873'))) {
SetLocationHref(null,'arrt_oam_invio'+'?m_cAction=start&m_cMode=hyperlink','elaborazione')
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
function QSCZHDCMTE_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_tipofile(HtW(getComboValue(Ctrl('QSCZHDCMTE')),'N'),null,e);
}
function QSCZHDCMTE_OnFocus(e) {
SetActiveField(Ctrl('QSCZHDCMTE'),true);
}
function QSCZHDCMTE_OnBlur(e) {
SetActiveField(Ctrl('QSCZHDCMTE'),false);
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
if(c=Ctrl('QSCZHDCMTE')) c.onchange=QSCZHDCMTE_Valid;
if(c=Ctrl('QSCZHDCMTE')) c.onfocus=QSCZHDCMTE_OnFocus;
if(c=Ctrl('QSCZHDCMTE')) c.onblur=QSCZHDCMTE_OnBlur;
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
FocusFirstComponent.otherwise={"page_1":["GTMJENMCMN","TCZMCNHUFI","NMNMXABGKO","QSCZHDCMTE"]};
function Help() {
windowOpenForeground('../doc/arpg_oam_invio_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_bloccaedit=a[4];
w_files=a[5];
w_gIntemediario=a[6];
w_gDescAzi=a[7];
w_tipofile=a[8];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_oam_invio',m_cSelectedPage);
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
l_bEnabled= ! ( ! (Empty(w_dadata)) &&  ! (Empty(w_a_data)));
SetDisabled(Ctrl('NMNMXABGKO'),l_bEnabled);
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
function Set_tipofile(ctrlValue,kmode,e) {
if (Ne(w_tipofile,ctrlValue)) {
var ctl = _GetCtl(e,'QSCZHDCMTE');
if (_tracker.goon(ctl,ctrlValue)) {
w_tipofile=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QSCZHDCMTE',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','N',1,0,'');
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
if ((Eq(w_bloccaedit,'N')) && (( ! (_ChkObl('GTMJENMCMN',1))) || ( ! (Ge(w_anno,2007))))) {
_SignErr('GTMJENMCMN','1966663129');
l_bResult=false;
w_anno=HtW('','N');
} else if ((Eq(w_bloccaedit,'N')) && (( ! (_ChkObl('TCZMCNHUFI',1))) || ( ! (((Eq(w_anno,2007) && Ge(w_mese,'05')) || Gt(w_anno,2007)?true:false))))) {
_SignErr('TCZMCNHUFI','11240429377');
l_bResult=false;
w_mese=HtW('','C');
} else if ( ! (_ChkObl('QSCZHDCMTE',1))) {
_SignErr('QSCZHDCMTE');
m_cLastWorkVarErrorMsg='10759730627';
l_bResult=false;
w_tipofile=HtW('','N');
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
l_oWv.setValue('bloccaedit',WtA(w_bloccaedit,'C'));
l_oWv.setValue('files',WtA(w_files,'N'));
l_oWv.setValue('gIntemediario',WtA(w_gIntemediario,'C'));
l_oWv.setValue('gDescAzi',WtA(w_gDescAzi,'C'));
l_oWv.setValue('tipofile',WtA(w_tipofile,'N'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["anno","mese","dadata","a_data","bloccaedit","files","gIntemediario","gDescAzi","tipofile"];
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
if (start && Eq(At(',tipofile,',pseq),0)) {
w_tipofile=0;
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
_Obli('tipofile',1,'QSCZHDCMTE',false,"10759730627")
