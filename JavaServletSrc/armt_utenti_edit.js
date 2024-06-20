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
}
function EnableControlsUnderCondition_WhenReady() {
var l_bEnabled = true;
// * --- Area Manuale = UI - Enable Controls Init
// * --- Fine Area Manuale
if (window.Z && window.Z.Tabs) {
Z.Tabs.Get('tabs').CheckTabStrip();
}
if (IsDisabledByStateDriver('box_YORQOIOBQN')) {
DisableInputsInContainer(Ctrl('YORQOIOBQN'),true);
}
LibJavascript.forEachItem(m_FoundlingEditExpression,i_body_0)
function i_body_0(child){
child();
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
function Set_utcodice(ctrlValue,kmode,e) {
if (Ne(w_utcodice,ctrlValue)) {
var ctl = _GetCtl(e,'YNMIZJQYRY');
if (_tracker.goon(ctl,ctrlValue)) {
w_utcodice=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YNMIZJQYRY',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',10,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_utnomine(ctrlValue,kmode,e) {
if (Ne(w_utnomine,ctrlValue)) {
var ctl = _GetCtl(e,'JQQLMQKNBX');
if (_tracker.goon(ctl,ctrlValue)) {
w_utnomine=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('JQQLMQKNBX',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',40,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_utpasswd(ctrlValue,kmode,e) {
if (Ne(w_utpasswd,ctrlValue)) {
var ctl = _GetCtl(e,'UEJQOTYNAX');
if (_tracker.goon(ctl,ctrlValue)) {
w_utpasswd=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UEJQOTYNAX',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',20,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_utcod_cp(ctrlValue,kmode,e) {
if (Ne(w_utcod_cp,ctrlValue)) {
var ctl = _GetCtl(e,'NMZFYXYKDM');
if (_tracker.goon(ctl,ctrlValue)) {
w_utcod_cp=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NMZFYXYKDM',0);
if (l_bResult) {
l_bResult=Link_NMZFYXYKDM(kmode);
if ( ! (l_bResult)) {
w_utcod_cp=HtW('','N');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'N',4,0,'9999'));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','N',4,0,'9999');
_ResetTracker();
return true;
}
}
return true;
}
function Set_ut_email(ctrlValue,kmode,e) {
if (Ne(w_ut_email,ctrlValue)) {
var ctl = _GetCtl(e,'HQCVHXWENH');
if (_tracker.goon(ctl,ctrlValue)) {
w_ut_email=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HQCVHXWENH',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',40,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_utdatacc(ctrlValue,kmode,e) {
if (Ne(w_utdatacc,ctrlValue)) {
var ctl = _GetCtl(e,'ZKRXYNLUTO');
if (_tracker.goon(ctl,ctrlValue)) {
w_utdatacc=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ZKRXYNLUTO',0);
DoUpdate(l_bResult);
return l_bResult;
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
LibJavascript.forEachItem(m_FoundlingCopyWorkVar,i_body_1)
function i_body_1(child){
child();
}
// * --- Area Manuale = UI - Calculate
// * --- Fine Area Manuale
m_bCalculating=false;
}
function SaveDependsOn() {
}
function SaveLabelDependsOn() {
}
function Link_NMZFYXYKDM(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_utcod_cp);
var l_Appl = LinkApplet();
l_Appl.SetDoubleKey('code',w_utcod_cp,4,0);
l_Appl.SetFields('code,name');
l_Appl.SetTypes('N,C');
l_Appl.LinkTable('cpusers');
l_Appl.SetID('NMZFYXYKDM');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_utcod_cp=l_Appl.GetDoubleValue('code',4,0);
w_xdesute=l_Appl.GetStringValue('name',30,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_NMZFYXYKDM_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_NMZFYXYKDM';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_NMZFYXYKDM();
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
function Link_NMZFYXYKDM_Blank() {
w_utcod_cp=0;
w_xdesute='';
}
function LOpt_NMZFYXYKDM() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('cpusers','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('code','C'));
l_oWv.setValue('LinkedField',WtA('code','C'));
l_oWv.setValue('UID',WtA('NMZFYXYKDM','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['NMZFYXYKDM'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('162528837'),'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'NMZFYXYKDM')) {
last_focused_comp=GetLastFocusedElementOfLink('NMZFYXYKDM');
function SetMethod_NMZFYXYKDM() {
Set_utcod_cp(HtW(value,'N'),0);
}
if (IsDeviceMobile()) {
SetMethod_NMZFYXYKDM();
} else {
setTimeout(SetMethod_NMZFYXYKDM,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'NMZFYXYKDM')) {
return [Ctrl('NMZFYXYKDM')];
}
}
function SendData(formaction,url,data) {
if (Eq(m_bAlreadySubmitted,true)) {
WindowAlert(Translate('MSG_SERVER_DATA'));
return;
}
var Frm = document.FSender;
var bResult = true;
function l_Checks() {
bResult=bResult && Check() && CheckPwdOTP();
}
if (Eq(formaction,'moveto') && m_bUpdated) {
bResult=WindowConfirm(Translate('MSG_LEAVE_MOD'));
}
if (bResult) {
if (Eq(formaction,'moveto') || (Eq(m_cFunction,'edit') &&  ! (m_bUpdated))) {
formaction='discard';
}
if (Eq(formaction,'save')) {
NotifyEvent('Before Save');
l_Checks();
}
if (bResult) {
Frm.m_cSelectedPage.value=GetSelectedPage(InitWvApplet()).asString();
SubmitForm.SetAction(formaction);
SubmitForm.SetPwdAndOTP();
Frm.m_cAltInterface.value=m_cAltInterface;
Frm.m_cLayerInterface.value=m_cLayerInterface;
FillWv();
Frm.m_cWv.value=WvApplet().asString(1);
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('armt_utenti_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('armt_utenti_dataNotSent',{'action':formaction});
}
}
}
}
CheckChild.child=[];
function Check() {
var l_bResult = true;
ResetErrorVars();
m_nLastError=0;
if ( ! (_ChkObl('YNMIZJQYRY',1))) {
_SignErr('YNMIZJQYRY');
m_cLastWorkVarErrorMsg='1999024119';
l_bResult=false;
w_utcodice=HtW('','C');
} else if ( ! (_ChkObl('JQQLMQKNBX',1))) {
_SignErr('JQQLMQKNBX');
m_cLastWorkVarErrorMsg='176491428';
l_bResult=false;
w_utnomine=HtW('','C');
} else if ( ! (_ChkObl('UEJQOTYNAX',1))) {
_SignErr('UEJQOTYNAX');
m_cLastWorkVarErrorMsg='11183929984';
l_bResult=false;
w_utpasswd=HtW('','C');
} else if ( ! (_ChkObl('NMZFYXYKDM',1))) {
_SignErr('NMZFYXYKDM');
m_cLastWorkVarErrorMsg='197247171';
l_bResult=false;
w_utcod_cp=HtW('','N');
} else if ( ! (_ChkObl('HQCVHXWENH',1))) {
_SignErr('HQCVHXWENH');
m_cLastWorkVarErrorMsg='7534645';
l_bResult=false;
w_ut_email=HtW('','C');
} else if ( ! (_ChkObl('ZKRXYNLUTO',1))) {
_SignErr('ZKRXYNLUTO');
m_cLastWorkVarErrorMsg='538438265';
l_bResult=false;
w_utdatacc=HtW('','D');
}
if (l_bResult) {
l_bResult=CheckChild(0);
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('NMZFYXYKDM_ZOOM',lc)) {
return 0;
}
if (Eq('NMZFYXYKDM',lc)) {
return 0;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_NMZFYXYKDM();
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
l_oWv.setValue('m_CheckVars',JSON.stringify(m_CheckVars));
l_oWv.setValue('utcodice',WtA(w_utcodice,'C'));
l_oWv.setValue('utnomine',WtA(w_utnomine,'C'));
l_oWv.setValue('utpasswd',WtA(w_utpasswd,'C'));
l_oWv.setValue('utcod_cp',WtA(w_utcod_cp,'N'));
l_oWv.setValue('ut_email',WtA(w_ut_email,'C'));
l_oWv.setValue('utdatacc',WtA(w_utdatacc,'D'));
l_oWv.setValue('xdesute',WtA(w_xdesute,'C'));
_FillChildren(l_oWv);
if (m_bExtended) {
ExtendWv(l_oWv);
}
if (Ne(m_cFunction,'view')) {
l_oWv.setValue('m_bUpdated',WtA(m_bUpdated,'L'));
l_oWv.setValue('m_cPrvsStt',WtA(m_cPrvsStt,'C'));
}
l_oWv.setValue('m_bLoaded',WtA(m_bLoaded,'L'));
l_oWv.setValue('m_cOldCPCCCHK',WtA(m_cOldCPCCCHK,'C'));
}
_FillChildren.n=[];
FillWv.n=["utcodice","utnomine","utpasswd","utcod_cp","ut_email","utdatacc","xdesute"];
function SetModified() {
m_bUpdated=true;
}
