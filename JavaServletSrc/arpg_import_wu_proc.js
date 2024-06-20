function SetControlsValue() {
var c;
var c;
if(c=Ctrl('ZFBIYQMSFL')) c.value = WtH(w_nomefile,'C',100,0,'')
if(c=Ctrl('WIRRRKLEWO')) selectRadio(c,w_tipodest,'C')
var tmp_FGMOCXNBFY = ToHTag(AsControlValue('<iframe width=\'655\' height=\'170\' id=\'elaborazione\'  name=\'elaborazione\' frameborder=\'1\'  border=\'1\' align=\'TOP\' marginwidth=\'1\' marginheight=\'1\'></iframe>'));
if (Ne(e_FGMOCXNBFY,tmp_FGMOCXNBFY)) {
if(c=Ctrl('FGMOCXNBFY')) c.innerHTML=tmp_FGMOCXNBFY;
e_FGMOCXNBFY=tmp_FGMOCXNBFY;
}
if(c=Ctrl('RQAECCWOBF')) selectRadio(c,w_destfin,'C')
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay(Ctrl('FGMOCXNBFY'),true);
HideUI();
}
HideUI.lblids["tipodest"]=['NJQSNRJAXM'];
function DZUBEERBGN_Click() {
UploadDoc()
}
function WIRRRKLEWO_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_tipodest(HtW(getRadioValue(Ctrl('WIRRRKLEWO')),'C'),null,e);
}
function href_XWPYHZIJDE() {
if (false || WindowConfirm(Translate('292774027'))) {
SetLocationHref(null,'arrt_imp_dati_wursi'+'?m_cAction=start&m_cMode=hyperlink','elaborazione')
}
}
function RQAECCWOBF_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_destfin(HtW(getRadioValue(Ctrl('RQAECCWOBF')),'C'),null,e);
}
function href_JSKZJOHJOM() {
SetLocationHref(window.location,ToResource('jsp/start_page_logo_portlet.jsp'+'')+'')
}
function href_JBNBDKBIAJ() {
_modifyandopen(ToResource('jsp/list_filesid_portlet.jsp'+'')+'?m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes,height=600,width=800',null)
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
c=Ctrl('WIRRRKLEWO');
if ( ! (Empty(c))) {
c[0].onclick=WIRRRKLEWO_Valid;
c[1].onclick=WIRRRKLEWO_Valid;
}
c=Ctrl('RQAECCWOBF');
if ( ! (Empty(c))) {
c[0].onclick=RQAECCWOBF_Valid;
c[1].onclick=RQAECCWOBF_Valid;
}
}
}
function NotifyEvent(p_cEvent) {
var old_c;
if (Ne(typeof(w_Messaggi),'undefined')) {
w_Messaggi.raiseEvent('arpg_import_wu_'+Strtran(p_cEvent,' ','_'));
}
if (Ne(typeof(w_Log),'undefined')) {
w_Log.raiseEvent('arpg_import_wu_'+Strtran(p_cEvent,' ','_'));
}
if (Ne(typeof(w_ListaFile),'undefined')) {
w_ListaFile.raiseEvent('arpg_import_wu_'+Strtran(p_cEvent,' ','_'));
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
windowOpenForeground('../doc/arpg_import_wu_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_tipodest=a[1];
w_impzip=a[2];
w_errchk=a[3];
w_gFlgCMod=a[4];
w_destfin=a[5];
w_gAzienda=a[6];
w_gPathApp=a[7];
w_fscarti=a[8];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_import_wu',m_cSelectedPage);
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
function Set_tipodest(ctrlValue,kmode,e) {
if (Ne(w_tipodest,ctrlValue)) {
var ctl = _GetCtl(e,'WIRRRKLEWO');
if (_tracker.goon(ctl,ctrlValue)) {
w_tipodest=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('WIRRRKLEWO',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_destfin(ctrlValue,kmode,e) {
if (Ne(w_destfin,ctrlValue)) {
var ctl = _GetCtl(e,'RQAECCWOBF');
if (_tracker.goon(ctl,ctrlValue)) {
w_destfin=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RQAECCWOBF',0);
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
if ( ! (_ChkObl('WIRRRKLEWO',1))) {
_SignErr('WIRRRKLEWO');
m_cLastWorkVarErrorMsg='tipodest';
l_bResult=false;
w_tipodest=HtW('','C');
} else if ( ! (_ChkObl('RQAECCWOBF',1))) {
_SignErr('RQAECCWOBF');
m_cLastWorkVarErrorMsg='destfin';
l_bResult=false;
w_destfin=HtW('','C');
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
l_oWv.setValue('nomefile',WtA(w_nomefile,'C'));
l_oWv.setValue('tipodest',WtA(w_tipodest,'C'));
l_oWv.setValue('impzip',WtA(w_impzip,'N'));
l_oWv.setValue('errchk',WtA(w_errchk,'N'));
l_oWv.setValue('gFlgCMod',WtA(w_gFlgCMod,'C'));
l_oWv.setValue('destfin',WtA(w_destfin,'C'));
l_oWv.setValue('gAzienda',WtA(w_gAzienda,'C'));
l_oWv.setValue('gPathApp',WtA(w_gPathApp,'C'));
l_oWv.setValue('fscarti',WtA(w_fscarti,'N'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["nomefile","tipodest","impzip","errchk","gFlgCMod","destfin","gAzienda","gPathApp","fscarti"];
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
TransferBetweenWindows(opener,'w_nomefile','w_nomefile');
}
if (Empty(w_fscarti) && Ne(opener.w_fscarti,null)) {
TransferBetweenWindows(opener,'w_fscarti','w_fscarti');
}
}
}
m_bCalculating=true;
if (start && Eq(At(',tipodest,',pseq),0)) {
w_tipodest='P';
}
if (start && Eq(At(',impzip,',pseq),0)) {
w_impzip=0;
}
if (start && Eq(At(',errchk,',pseq),0)) {
w_errchk=0;
}
if (start && Eq(At(',destfin,',pseq),0)) {
w_destfin='O';
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
_Obli('tipodest',0,'WIRRRKLEWO',false)
_Obli('destfin',0,'RQAECCWOBF',false)
