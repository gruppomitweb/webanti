function SetControlsValue() {
var c;
var c;
if(c=Ctrl('ZFBIYQMSFL')) c.value = WtH(w_nomefile,'C',100,0,'')
var tmp_FGMOCXNBFY = ToHTag(AsControlValue('<iframe width=\'655\' height=\'170\' id=\'elaborazione\'  name=\'elaborazione\' frameborder=\'1\'  border=\'1\' align=\'TOP\' marginwidth=\'1\' marginheight=\'1\'></iframe>'));
if (Ne(e_FGMOCXNBFY,tmp_FGMOCXNBFY)) {
if(c=Ctrl('FGMOCXNBFY')) c.innerHTML=tmp_FGMOCXNBFY;
e_FGMOCXNBFY=tmp_FGMOCXNBFY;
}
if(c=Ctrl('PNMRAVFGJC')) selectCombo(c,w_tipoelab,'C')
if(c=Ctrl('QMVQRXGNVN')) selectCombo(c,w_tipodoc,'C')
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay(Ctrl('FGMOCXNBFY'),true);
SetDisplay(Ctrl('TIIMQHOLUY'),Eq(w_tipoelab,'A'));
SetDisplay(Ctrl('FYHACIIRHS'),Eq(w_tipoelab,'A'));
SetDisplay(Ctrl('PRCVTJSBUS'),Eq(w_tipoelab,'A'));
HideUI();
}
HideUI.lblids["tipodoc"]=['GPZCKGSSOH'];
HideUI.lblids["tipoelab"]=['HQMCOHXMLS'];
function DZUBEERBGN_Click() {
if (Eq(w_impzip,0)) {
UploadDoc()
}
}
function href_XWPYHZIJDE() {
SetLocationHref(null,'arrt_esito_rap'+'?m_cAction=start&m_cMode=hyperlink','elaborazione')
}
function href_TIIMQHOLUY() {
var l_oWv = InitWvApplet();
l_oWv.setValue('ReportName',AsAppletValue('arrp_esiti_rap'));
l_oWv.setValue('outputFormat',AsAppletValue('PDF'));
l_oWv.setValue('w_DescAzi',AsAppletValue(w_gDescAzi));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('ReportName,outputFormat,w_DescAzi'));
_modifyandopen('Report'+'?m_cWv='+URLenc(l_oWv.asString())+'&m_cAction=start&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null)
}
function PNMRAVFGJC_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_tipoelab(HtW(getComboValue(Ctrl('PNMRAVFGJC')),'C'),null,e);
}
function PNMRAVFGJC_OnFocus(e) {
SetActiveField(Ctrl('PNMRAVFGJC'),true);
}
function PNMRAVFGJC_OnBlur(e) {
SetActiveField(Ctrl('PNMRAVFGJC'),false);
}
function href_FYHACIIRHS() {
var l_oWv = InitWvApplet();
l_oWv.setValue('pOut',AsAppletValue('R'));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('pOut'));
_modifyandopen('arrt_esito_rap_report'+'?m_cWv='+URLenc(l_oWv.asString())+'&m_cAction=start&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null)
}
function href_PRCVTJSBUS() {
var l_oWv = InitWvApplet();
l_oWv.setValue('pOut',AsAppletValue('X'));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('pOut'));
SetLocationHref(null,'arrt_esito_rap_report'+'?m_cWv='+URLenc(l_oWv.asString())+'&m_cAction=start&m_cAtExit=close&m_cMode=hyperlink','elaborazione')
}
function href_FGZKGVNTIL() {
SetLocationHref(null,'arrt_esito_rap_cf'+'?m_cAction=start&m_cMode=hyperlink','elaborazione')
}
function QMVQRXGNVN_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_tipodoc(HtW(getComboValue(Ctrl('QMVQRXGNVN')),'C'),null,e);
}
function QMVQRXGNVN_OnFocus(e) {
SetActiveField(Ctrl('QMVQRXGNVN'),true);
}
function QMVQRXGNVN_OnBlur(e) {
SetActiveField(Ctrl('QMVQRXGNVN'),false);
}
function href_ZRMMCMURVJ() {
var l_oWv = InitWvApplet();
l_oWv.setValue('ReportName',AsAppletValue('arrp_esiti_rap_cf'));
l_oWv.setValue('outputFormat',AsAppletValue('PDF'));
l_oWv.setValue('w_DescAzi',AsAppletValue(w_gDescAzi));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('ReportName,outputFormat,w_DescAzi'));
_modifyandopen('Report'+'?m_cWv='+URLenc(l_oWv.asString())+'&m_cAction=start&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null)
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
if(c=Ctrl('PNMRAVFGJC')) c.onchange=PNMRAVFGJC_Valid;
if(c=Ctrl('PNMRAVFGJC')) c.onfocus=PNMRAVFGJC_OnFocus;
if(c=Ctrl('PNMRAVFGJC')) c.onblur=PNMRAVFGJC_OnBlur;
if(c=Ctrl('QMVQRXGNVN')) c.onchange=QMVQRXGNVN_Valid;
if(c=Ctrl('QMVQRXGNVN')) c.onfocus=QMVQRXGNVN_OnFocus;
if(c=Ctrl('QMVQRXGNVN')) c.onblur=QMVQRXGNVN_OnBlur;
}
}
function NotifyEvent(p_cEvent) {
var old_c;
if (Ne(typeof(w_Messaggi),'undefined')) {
w_Messaggi.raiseEvent('arpg_esito_rap_'+Strtran(p_cEvent,' ','_'));
}
if (Ne(typeof(w_Log),'undefined')) {
w_Log.raiseEvent('arpg_esito_rap_'+Strtran(p_cEvent,' ','_'));
}
if (Ne(typeof(w_ListaFile),'undefined')) {
w_ListaFile.raiseEvent('arpg_esito_rap_'+Strtran(p_cEvent,' ','_'));
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
FocusFirstComponent.otherwise={"page_1":["DZUBEERBGN","PNMRAVFGJC"]};
function Help() {
windowOpenForeground('../doc/arpg_esito_rap_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_gDescAzi=a[1];
w_tipoelab=a[2];
w_tipodoc=a[3];
w_impzip=a[4];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_esito_rap',m_cSelectedPage);
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
l_bEnabled= ! (Eq(w_impzip,0));
SetDisabled(Ctrl('DZUBEERBGN'),l_bEnabled);
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
function Set_tipoelab(ctrlValue,kmode,e) {
if (Ne(w_tipoelab,ctrlValue)) {
var ctl = _GetCtl(e,'PNMRAVFGJC');
if (_tracker.goon(ctl,ctrlValue)) {
w_tipoelab=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('PNMRAVFGJC',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_tipodoc(ctrlValue,kmode,e) {
if (Ne(w_tipodoc,ctrlValue)) {
var ctl = _GetCtl(e,'QMVQRXGNVN');
if (_tracker.goon(ctl,ctrlValue)) {
w_tipodoc=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QMVQRXGNVN',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',10,0,'');
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
if ( ! (_ChkObl('PNMRAVFGJC',1))) {
_SignErr('PNMRAVFGJC');
m_cLastWorkVarErrorMsg='80171447';
l_bResult=false;
w_tipoelab=HtW('','C');
} else if ( ! (_ChkObl('QMVQRXGNVN',1))) {
_SignErr('QMVQRXGNVN');
m_cLastWorkVarErrorMsg='tipodoc';
l_bResult=false;
w_tipodoc=HtW('','C');
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
l_oWv.setValue('gDescAzi',WtA(w_gDescAzi,'C'));
l_oWv.setValue('tipoelab',WtA(w_tipoelab,'C'));
l_oWv.setValue('tipodoc',WtA(w_tipodoc,'C'));
l_oWv.setValue('impzip',WtA(w_impzip,'N'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["nomefile","gDescAzi","tipoelab","tipodoc","impzip"];
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
}
}
m_bCalculating=true;
if (start && Eq(At(',tipoelab,',pseq),0)) {
w_tipoelab='T';
}
if (start && Eq(At(',impzip,',pseq),0)) {
w_impzip=0;
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
_Obli('tipoelab',0,'PNMRAVFGJC',false,"80171447")
_Obli('tipodoc',0,'QMVQRXGNVN',false)
