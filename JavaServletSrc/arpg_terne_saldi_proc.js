function SetControlsValue() {
var c;
var c;
if(c=Ctrl('ZFBIYQMSFL')) c.value = WtH(w_nomefile,'C',100,0,'')
var tmp_FGMOCXNBFY = ToHTag(AsControlValue('<iframe width=\'655\' height=\'170\' id=\'elaborazione\'  name=\'elaborazione\' frameborder=\'1\'  border=\'1\' align=\'TOP\' marginwidth=\'1\' marginheight=\'1\'></iframe>'));
if (Ne(e_FGMOCXNBFY,tmp_FGMOCXNBFY)) {
if(c=Ctrl('FGMOCXNBFY')) c.innerHTML=tmp_FGMOCXNBFY;
e_FGMOCXNBFY=tmp_FGMOCXNBFY;
}
if(c=Ctrl('PDFSWXZOJQ')) selectCombo(c,w_anno,'N')
if(c=Ctrl('BJVSCFFVJE')) c.value = WtH(w_a_data,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('LGAAGLDJXT')) ChkboxCheckUncheck(c,'S',w_stpoff)
if(c=Ctrl('LGAAGLDJXT')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay(Ctrl('FGMOCXNBFY'),true);
HideUI();
}
HideUI.lblids["a_data"]=['JDOFYKUEBB'];
HideUI.lblids["anno"]=['BSCMMKXBND'];
function DZUBEERBGN_Click() {
UploadDoc()
}
function href_XWPYHZIJDE() {
SetLocationHref(null,'arrt_terne_saldi'+'?m_cAction=start&m_cMode=hyperlink','elaborazione')
}
function href_FYHACIIRHS() {
var l_oWv = InitWvApplet();
l_oWv.setValue('rotation',AsAppletValue('LANDSCAPE'));
l_oWv.setValue('w_anno',AsAppletValue(w_anno));
l_oWv.setValue('w_DescAzi',AsAppletValue(w_gDescAzi));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('rotation,w_anno,w_DescAzi'));
_modifyandopen('Report?ReportName='+'arrp_imp_terne_err'+'&m_cWv='+URLenc(l_oWv.asString())+'&m_cAtExit=close&m_cMode=hyperlink','scrollbars=1,toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null)
}
function PDFSWXZOJQ_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_anno(HtW(getComboValue(Ctrl('PDFSWXZOJQ')),'N'),null,e);
}
function PDFSWXZOJQ_OnFocus(e) {
SetActiveField(Ctrl('PDFSWXZOJQ'),true);
}
function PDFSWXZOJQ_OnBlur(e) {
SetActiveField(Ctrl('PDFSWXZOJQ'),false);
}
function href_KKWIERNZCT() {
var l_oWv = InitWvApplet();
l_oWv.setValue('rotation',AsAppletValue('LANDSCAPE'));
l_oWv.setValue('w_anno',AsAppletValue(w_anno));
l_oWv.setValue('w_DescAzi',AsAppletValue(w_gDescAzi));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('rotation,w_anno,w_DescAzi'));
_modifyandopen('Report?ReportName='+'arrp_imp_terne_ok'+'&m_cWv='+URLenc(l_oWv.asString())+'&m_cAtExit=close&m_cMode=hyperlink','scrollbars=1,toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null)
}
function LGAAGLDJXT_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_stpoff(ChkboxValueAssign(Ctrl('LGAAGLDJXT'),'S','N','C',1,0,''),null,e);
}
function LGAAGLDJXT_OnFocus(e) {
SetActiveField(Ctrl('LGAAGLDJXT'),true);
}
function LGAAGLDJXT_OnBlur(e) {
SetActiveField(Ctrl('LGAAGLDJXT'),false);
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
if(c=Ctrl('PDFSWXZOJQ')) c.onchange=PDFSWXZOJQ_Valid;
if(c=Ctrl('PDFSWXZOJQ')) c.onfocus=PDFSWXZOJQ_OnFocus;
if(c=Ctrl('PDFSWXZOJQ')) c.onblur=PDFSWXZOJQ_OnBlur;
if(c=Ctrl('LGAAGLDJXT')) c.onclick=LGAAGLDJXT_Valid;
if(c=Ctrl('LGAAGLDJXT')) c.onfocus=LGAAGLDJXT_OnFocus;
if(c=Ctrl('LGAAGLDJXT')) c.onblur=LGAAGLDJXT_OnBlur;
}
}
function NotifyEvent(p_cEvent) {
var old_c;
if (Ne(typeof(w_Messaggi),'undefined')) {
w_Messaggi.raiseEvent('arpg_terne_saldi_'+Strtran(p_cEvent,' ','_'));
}
if (Ne(typeof(w_Log),'undefined')) {
w_Log.raiseEvent('arpg_terne_saldi_'+Strtran(p_cEvent,' ','_'));
}
if (Ne(typeof(w_ListaFile),'undefined')) {
w_ListaFile.raiseEvent('arpg_terne_saldi_'+Strtran(p_cEvent,' ','_'));
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
windowOpenForeground('../doc/arpg_terne_saldi_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_anno=a[2];
w_a_data=a[3];
w_stpoff=a[4];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_terne_saldi',m_cSelectedPage);
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
function Set_anno(ctrlValue,kmode,e) {
if (Ne(w_anno,ctrlValue)) {
var ctl = _GetCtl(e,'PDFSWXZOJQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_anno=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('PDFSWXZOJQ',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','N',4,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_stpoff(ctrlValue,kmode,e) {
if (Ne(w_stpoff,ctrlValue)) {
var ctl = _GetCtl(e,'LGAAGLDJXT');
if (_tracker.goon(ctl,ctrlValue)) {
w_stpoff=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('LGAAGLDJXT',0);
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
w_a_data=(Eq(w_anno,0)?NullDate():(Lt(w_anno,2013)?CharToDate('20131130'):NullDate()));
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
if ( ! (_ChkObl('PDFSWXZOJQ',1))) {
_SignErr('PDFSWXZOJQ');
m_cLastWorkVarErrorMsg='863017169';
l_bResult=false;
w_anno=HtW('','N');
} else if ( ! (_ChkObl('LGAAGLDJXT',1))) {
_SignErr('LGAAGLDJXT');
m_cLastWorkVarErrorMsg='stpoff';
l_bResult=false;
w_stpoff='N';
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
l_oWv.setValue('anno',WtA(w_anno,'N'));
l_oWv.setValue('a_data',WtA(w_a_data,'D'));
l_oWv.setValue('stpoff',WtA(w_stpoff,'C'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["nomefile","gDescAzi","anno","a_data","stpoff"];
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
w_a_data=(Eq(w_anno,0)?NullDate():(Lt(w_anno,2013)?CharToDate('20131130'):NullDate()));
if (start && Eq(At(',stpoff,',pseq),0)) {
w_stpoff='N';
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
_Obli('anno',1,'PDFSWXZOJQ',false,"863017169")
_Obli('stpoff',0,'LGAAGLDJXT',false)
