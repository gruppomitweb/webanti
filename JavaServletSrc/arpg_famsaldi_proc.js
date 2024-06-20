function SetControlsValue() {
var c;
var c;
if(c=Ctrl('PDFSWXZOJQ')) selectCombo(c,w_anno,'C')
var tmp_TYIWXFLLFY = ToHTag(AsControlValue('<iframe width=\'750\' height=\'400\' id=\'elaborazione\'  name=\'elaborazione\' frameborder=\'1\'  border=\'1\' align=\'TOP\' marginwidth=\'1\' marginheight=\'1\'></iframe>'));
if (Ne(e_TYIWXFLLFY,tmp_TYIWXFLLFY)) {
if(c=Ctrl('TYIWXFLLFY')) c.innerHTML=tmp_TYIWXFLLFY;
e_TYIWXFLLFY=tmp_TYIWXFLLFY;
}
if(c=Ctrl('AOHGKXZIJG')) ChkboxCheckUncheck(c,'S',w_flgstp)
if(c=Ctrl('AOHGKXZIJG')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('BEACFIZSVH')) selectRadio(c,w_flginvio,'C')
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
HideUI();
}
HideUI.lblids["anno"]=['BSCMMKXBND'];
function ALQVOOWZEV_Click() {
var l_oWv = InitWvApplet();
l_oWv.setValue('w_anno',AsAppletValue(w_anno));
l_oWv.setValue('w_flgstp',AsAppletValue(w_flgstp));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('w_anno,w_flgstp'));
if ( ! (Empty(w_anno))) {
if (false || WindowConfirm(Translate('11721178482'))) {
SetLocationHref(null,'arrt_famsaldi'+'?m_cWv='+URLenc(l_oWv.asString())+'&m_cAction=start&m_cMode=hyperlink','elaborazione')
}
}
}
function href_AJXISNWTIP() {
SetLocationHref(window.location,ToResource('jsp/start_page_logo_portlet.jsp'+'')+'')
}
function PDFSWXZOJQ_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_anno(HtW(getComboValue(Ctrl('PDFSWXZOJQ')),'C'),null,e);
}
function PDFSWXZOJQ_OnFocus(e) {
SetActiveField(Ctrl('PDFSWXZOJQ'),true);
}
function PDFSWXZOJQ_OnBlur(e) {
SetActiveField(Ctrl('PDFSWXZOJQ'),false);
}
function href_MPCMAMHQST() {
SetLocationHref(null,'arrt_famsaldi_stp'+'?m_cAction=start&m_cAtExit=close&m_cMode=hyperlink','elaborazione')
}
function AOHGKXZIJG_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_flgstp(ChkboxValueAssign(Ctrl('AOHGKXZIJG'),'S','N','C',1,0,''),null,e);
}
function AOHGKXZIJG_OnFocus(e) {
SetActiveField(Ctrl('AOHGKXZIJG'),true);
}
function AOHGKXZIJG_OnBlur(e) {
SetActiveField(Ctrl('AOHGKXZIJG'),false);
}
function href_JBNBDKBIAJ() {
_modifyandopen(ToResource('jsp/list_filesid_portlet.jsp'+'')+'?m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes,height=600,width=800',null)
}
function BEACFIZSVH_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_flginvio(HtW(getRadioValue(Ctrl('BEACFIZSVH')),'C'),null,e);
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
if(c=Ctrl('PDFSWXZOJQ')) c.onchange=PDFSWXZOJQ_Valid;
if(c=Ctrl('PDFSWXZOJQ')) c.onfocus=PDFSWXZOJQ_OnFocus;
if(c=Ctrl('PDFSWXZOJQ')) c.onblur=PDFSWXZOJQ_OnBlur;
if(c=Ctrl('AOHGKXZIJG')) c.onclick=AOHGKXZIJG_Valid;
if(c=Ctrl('AOHGKXZIJG')) c.onfocus=AOHGKXZIJG_OnFocus;
if(c=Ctrl('AOHGKXZIJG')) c.onblur=AOHGKXZIJG_OnBlur;
c=Ctrl('BEACFIZSVH');
if ( ! (Empty(c))) {
c[0].onclick=BEACFIZSVH_Valid;
c[1].onclick=BEACFIZSVH_Valid;
}
}
}
function NotifyEvent(p_cEvent) {
var old_c;
if (Ne(typeof(w_Messaggi),'undefined')) {
w_Messaggi.raiseEvent('arpg_famsaldi_'+Strtran(p_cEvent,' ','_'));
}
if (Ne(typeof(w_Log),'undefined')) {
w_Log.raiseEvent('arpg_famsaldi_'+Strtran(p_cEvent,' ','_'));
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
FocusFirstComponent.otherwise={"page_1":["ALQVOOWZEV","PDFSWXZOJQ"]};
function Help() {
windowOpenForeground('../doc/arpg_famsaldi_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_anno=a[2];
w_flgstp=a[3];
w_flginvio=a[4];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_famsaldi',m_cSelectedPage);
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
l_bEnabled= ! ( ! (Empty(w_anno)));
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
var ctl = _GetCtl(e,'PDFSWXZOJQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_anno=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('PDFSWXZOJQ',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',4,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_flginvio(ctrlValue,kmode,e) {
if (Ne(w_flginvio,ctrlValue)) {
var ctl = _GetCtl(e,'BEACFIZSVH');
if (_tracker.goon(ctl,ctrlValue)) {
w_flginvio=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BEACFIZSVH',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_flgstp(ctrlValue,kmode,e) {
if (Ne(w_flgstp,ctrlValue)) {
var ctl = _GetCtl(e,'AOHGKXZIJG');
if (_tracker.goon(ctl,ctrlValue)) {
w_flgstp=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('AOHGKXZIJG',0);
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
w_anno=HtW('','C');
} else if ( ! (_ChkObl('AOHGKXZIJG',1))) {
_SignErr('AOHGKXZIJG');
m_cLastWorkVarErrorMsg='flgstp';
l_bResult=false;
w_flgstp='N';
} else if ( ! (_ChkObl('BEACFIZSVH',1))) {
_SignErr('BEACFIZSVH');
m_cLastWorkVarErrorMsg='flginvio';
l_bResult=false;
w_flginvio=HtW('','C');
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
l_oWv.setValue('anno',WtA(w_anno,'C'));
l_oWv.setValue('flgstp',WtA(w_flgstp,'C'));
l_oWv.setValue('flginvio',WtA(w_flginvio,'C'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["gIntemediario","gDescAzi","anno","flgstp","flginvio"];
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
w_anno=Str(Year(SystemDate())-1,4,0);
}
if (start && Eq(At(',flgstp,',pseq),0)) {
w_flgstp='N';
}
if (start && Eq(At(',flginvio,',pseq),0)) {
w_flginvio='N';
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
_Obli('anno',0,'PDFSWXZOJQ',false,"863017169")
_Obli('flginvio',0,'BEACFIZSVH',false)
_Obli('flgstp',0,'AOHGKXZIJG',false)
