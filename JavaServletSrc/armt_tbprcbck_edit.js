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
function DisplayErrorMessage_dt_tbprcbck_param() {
if ( ! (ChildToLoad(FrameRef('dt_tbprcbck_param'))) && Ne(typeof(FrameRef('dt_tbprcbck_param').DisplayErrorMessage),'undefined')) {
FrameRef('dt_tbprcbck_param').DisplayErrorMessage();
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
if (IsDisabledByStateDriver('Esempi Espressione di tempo')) {
DisableInputsInContainer(Ctrl('OHEWQINDHE'),true);
}
LibJavascript.forEachItem(m_FoundlingEditExpression,i_body_0)
function i_body_0(child){
child();
}
DisableUI();
HideControlsUnderCondition();
ObligatoryControlsUnderCondition();
ExpandCollapseBoxesUnderCondition();
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
function Set_PBLASTEND(ctrlValue,kmode,e) {
if (Ne(w_PBLASTEND,ctrlValue)) {
var ctl = _GetCtl(e,'CXUCPFUHPI');
if (_tracker.goon(ctl,ctrlValue)) {
w_PBLASTEND=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CXUCPFUHPI',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH(NullDateTime(),'T',14,0,TranslatePicture(GetDatePicture(false,'T'),'T'));
_ResetTracker();
return true;
}
}
return true;
}
function Set_PBDESCRI(ctrlValue,kmode,e) {
if (Ne(w_PBDESCRI,ctrlValue)) {
var ctl = _GetCtl(e,'PSYBDTLXBB');
if (_tracker.goon(ctl,ctrlValue)) {
w_PBDESCRI=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('PSYBDTLXBB',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',60,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_PBNOTE(ctrlValue,kmode,e) {
if (Ne(w_PBNOTE,ctrlValue)) {
var ctl = _GetCtl(e,'XLHKEFVDJB');
if (_tracker.goon(ctl,ctrlValue)) {
w_PBNOTE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XLHKEFVDJB',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','M',10,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_PBATTIVO(ctrlValue,kmode,e) {
if (Ne(w_PBATTIVO,ctrlValue)) {
var ctl = _GetCtl(e,'CLFPQIXXGN');
if (_tracker.goon(ctl,ctrlValue)) {
w_PBATTIVO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CLFPQIXXGN',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_PBTIMEXP(ctrlValue,kmode,e) {
if (Ne(w_PBTIMEXP,ctrlValue)) {
var ctl = _GetCtl(e,'YCLKFFWYHB');
if (_tracker.goon(ctl,ctrlValue)) {
w_PBTIMEXP=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YCLKFFWYHB',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',70,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_PBROUTINE(ctrlValue,kmode,e) {
if (Ne(w_PBROUTINE,ctrlValue)) {
var ctl = _GetCtl(e,'RBGNGVNHKX');
if (_tracker.goon(ctl,ctrlValue)) {
w_PBROUTINE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RBGNGVNHKX',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',60,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_PBFORZAESEC(ctrlValue,kmode,e) {
if (Ne(w_PBFORZAESEC,ctrlValue)) {
var ctl = _GetCtl(e,'MJZIHCRMOJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_PBFORZAESEC=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MJZIHCRMOJ',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH(false,'L',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_PBLASTSTART(ctrlValue,kmode,e) {
if (Ne(w_PBLASTSTART,ctrlValue)) {
var ctl = _GetCtl(e,'KUVWADTGLC');
if (_tracker.goon(ctl,ctrlValue)) {
w_PBLASTSTART=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('KUVWADTGLC',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH(NullDateTime(),'T',14,0,TranslatePicture(GetDatePicture(false,'T'),'T'));
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
UpdateAutonumber('PBCODICE');
LibJavascript.forEachItem(m_FoundlingCopyWorkVar,i_body_1)
function i_body_1(child){
child();
}
// * --- Area Manuale = UI - Calculate
// * --- Fine Area Manuale
UpdateAutonumber('');
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
parent.ZtVWeb.raiseEventToEvalParms('armt_tbprcbck_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('armt_tbprcbck_dataNotSent',{'action':formaction});
}
}
}
}
CheckChild.child=[{'prg':"dt_tbprcbck_param",'BOScId':function(){ return FrameRef('dt_tbprcbck_param')},'repeated':0}];
function Check() {
var l_bResult = true;
var l_bChildCheck = true;
ResetErrorVars();
m_nLastError=0;
if ( ! (_ChkObl('PSYBDTLXBB',1))) {
_SignErr('PSYBDTLXBB');
m_cLastWorkVarErrorMsg='285808099';
l_bResult=false;
w_PBDESCRI=HtW('','C');
} else if ( ! (_ChkObl('XLHKEFVDJB',1))) {
_SignErr('XLHKEFVDJB');
m_cLastWorkVarErrorMsg='10595583898';
l_bResult=false;
w_PBNOTE=HtW('','M');
} else if ( ! (_ChkObl('CLFPQIXXGN',1))) {
_SignErr('CLFPQIXXGN');
m_cLastWorkVarErrorMsg='10509971720';
l_bResult=false;
w_PBATTIVO='N';
} else if ( ! (_ChkObl('RBGNGVNHKX',1))) {
_SignErr('RBGNGVNHKX');
m_cLastWorkVarErrorMsg='10198365762';
l_bResult=false;
w_PBROUTINE=HtW('','C');
} else if ( ! (_ChkObl('YCLKFFWYHB',1))) {
_SignErr('YCLKFFWYHB');
m_cLastWorkVarErrorMsg='1905945337';
l_bResult=false;
w_PBTIMEXP=HtW('','C');
} else if ( ! (_ChkObl('MJZIHCRMOJ',1))) {
_SignErr('MJZIHCRMOJ');
m_cLastWorkVarErrorMsg='10581314837';
l_bResult=false;
w_PBFORZAESEC=false;
} else if ( ! (_ChkObl('KUVWADTGLC',1))) {
_SignErr('KUVWADTGLC');
m_cLastWorkVarErrorMsg='10735417238';
l_bResult=false;
w_PBLASTSTART=HtW('','T');
} else if ( ! (_ChkObl('CXUCPFUHPI',1))) {
_SignErr('CXUCPFUHPI');
m_cLastWorkVarErrorMsg='1456705060';
l_bResult=false;
w_PBLASTEND=HtW('','T');
}
if (l_bResult) {
l_bResult=CheckChild(0);
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('KUVWADTGLC_ZOOM',lc)) {
return 0;
}
if (Eq('CXUCPFUHPI_ZOOM',lc)) {
return 0;
}
return -1;
}
function link_url(index) {
var l_oWv;
}
function FillWv() {
var l_oWv = InitWvApplet();
l_oWv.setValue('m_CheckVars',JSON.stringify(m_CheckVars));
l_oWv.setValue('PBCODICE',WtA(w_PBCODICE,'N'));
l_oWv.setValue('op_PBCODICE',WtA(op_PBCODICE,'N'));
l_oWv.setValue('PBDESCRI',WtA(w_PBDESCRI,'C'));
l_oWv.setValue('PBNOTE',WtA(w_PBNOTE,'M'));
l_oWv.setValue('PBATTIVO',WtA(w_PBATTIVO,'C'));
l_oWv.setValue('PBNOMPRC',WtA(w_PBNOMPRC,'C'));
l_oWv.setValue('PBROUTINE',WtA(w_PBROUTINE,'C'));
l_oWv.setValue('PBTIMEXP',WtA(w_PBTIMEXP,'C'));
l_oWv.setValue('PBFORZAESEC',WtA(w_PBFORZAESEC,'L'));
l_oWv.setValue('PBLASTSTART',WtA(w_PBLASTSTART,'T'));
l_oWv.setValue('PBLASTEND',WtA(w_PBLASTEND,'T'));
l_oWv.setValue('op_codazi',WtA(op_codazi,'C'));
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
_FillChildren.n=['dt_tbprcbck_param'];
FillWv.n=["PBCODICE","PBDESCRI","PBNOTE","PBATTIVO","PBNOMPRC","PBROUTINE","PBTIMEXP","PBFORZAESEC","PBLASTSTART","PBLASTEND"];
function SetModified() {
m_bUpdated=true;
}
function SetChildVariables_dt_tbprcbck_param() {
}
function CtxLoad_dt_tbprcbck_param() {
if (ChildToLoad(FrameRef('dt_tbprcbck_param'))) {
return [LoadContext(0,'ERKDOYUXFB'),'dt_tbprcbck_param'];
}
}
