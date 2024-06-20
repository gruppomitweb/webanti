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
function DisplayErrorMessage_ardt_cgo_infbacheca_doc() {
if ( ! (ChildToLoad(FrameRef('ardt_cgo_infbacheca_doc'))) && Ne(typeof(FrameRef('ardt_cgo_infbacheca_doc').DisplayErrorMessage),'undefined')) {
FrameRef('ardt_cgo_infbacheca_doc').DisplayErrorMessage();
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
if (IsDisabledByStateDriver('Documenti')) {
DisableInputsInContainer(Ctrl('IQTXUVONAM'),true);
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
function Set_IBCODICE(ctrlValue,kmode,e) {
if (Ne(w_IBCODICE,ctrlValue)) {
var ctl = _GetCtl(e,'SWIXXXOOHL');
if (_tracker.goon(ctl,ctrlValue)) {
w_IBCODICE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SWIXXXOOHL',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('SWIXXXOOHL',function(){return WtH(w_IBCODICE,'N',10,0,'9999999999')},w_IBCODICE);
return l_bResult;
} else {
ctl.value=WtH('','N',10,0,'9999999999');
_ResetTracker();
return true;
}
}
return true;
}
function Set_IBCODCAT(ctrlValue,kmode,e) {
if (Ne(w_IBCODCAT,ctrlValue)) {
var ctl = _GetCtl(e,'JJGGLREGPJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_IBCODCAT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('JJGGLREGPJ',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',5,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_IBINFATT(ctrlValue,kmode,e) {
if (Ne(w_IBINFATT,ctrlValue)) {
var ctl = _GetCtl(e,'UJTOVLNUSR');
if (_tracker.goon(ctl,ctrlValue)) {
w_IBINFATT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UJTOVLNUSR',0);
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
function Set_IBTITOLO(ctrlValue,kmode,e) {
if (Ne(w_IBTITOLO,ctrlValue)) {
var ctl = _GetCtl(e,'HBQLZAGMVV');
if (_tracker.goon(ctl,ctrlValue)) {
w_IBTITOLO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HBQLZAGMVV',0);
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
function Set_IBDESCRI(ctrlValue,kmode,e) {
if (Ne(w_IBDESCRI,ctrlValue)) {
var ctl = _GetCtl(e,'DXXWPHEGDY');
if (_tracker.goon(ctl,ctrlValue)) {
w_IBDESCRI=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('DXXWPHEGDY',0);
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
function Set_IBDATSCA(ctrlValue,kmode,e) {
if (Ne(w_IBDATSCA,ctrlValue)) {
var ctl = _GetCtl(e,'CUJWZRIREL');
if (_tracker.goon(ctl,ctrlValue)) {
w_IBDATSCA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CUJWZRIREL',0);
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
UpdateAutonumber('IBCODICE');
w_IBDATINS=SystemDate();
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
parent.ZtVWeb.raiseEventToEvalParms('armt_cgo_infbacheca_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('armt_cgo_infbacheca_dataNotSent',{'action':formaction});
}
}
}
}
CheckChild.child=[{'prg':"ardt_cgo_infbacheca_doc",'BOScId':function(){ return FrameRef('ardt_cgo_infbacheca_doc')},'repeated':0}];
function Check() {
var l_bResult = true;
var l_bChildCheck = true;
ResetErrorVars();
m_nLastError=0;
if ( ! (_ChkObl('SWIXXXOOHL',1))) {
_SignErr('SWIXXXOOHL');
m_cLastWorkVarErrorMsg='112851763';
l_bResult=false;
w_IBCODICE=HtW('','N');
} else if ( ! (_ChkObl('JJGGLREGPJ',1))) {
_SignErr('JJGGLREGPJ');
m_cLastWorkVarErrorMsg='157141684';
l_bResult=false;
w_IBCODCAT=HtW('','C');
} else if ( ! (_ChkObl('UJTOVLNUSR',1))) {
_SignErr('UJTOVLNUSR');
m_cLastWorkVarErrorMsg='11065317557';
l_bResult=false;
w_IBINFATT='N';
} else if ( ! (_ChkObl('HBQLZAGMVV',1))) {
_SignErr('HBQLZAGMVV');
m_cLastWorkVarErrorMsg='123955940';
l_bResult=false;
w_IBTITOLO=HtW('','C');
} else if ( ! (_ChkObl('DXXWPHEGDY',1))) {
_SignErr('DXXWPHEGDY');
m_cLastWorkVarErrorMsg='285808099';
l_bResult=false;
w_IBDESCRI=HtW('','M');
} else if ( ! (_ChkObl('CUJWZRIREL',1))) {
_SignErr('CUJWZRIREL');
m_cLastWorkVarErrorMsg='2025824008';
l_bResult=false;
w_IBDATSCA=HtW('','D');
}
if (l_bResult) {
l_bResult=CheckChild(0);
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('CUJWZRIREL_ZOOM',lc)) {
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
l_oWv.setValue('IBCODICE',WtA(w_IBCODICE,'N'));
l_oWv.setValue('op_IBCODICE',WtA(op_IBCODICE,'N'));
l_oWv.setValue('IBCODCAT',WtA(w_IBCODCAT,'C'));
l_oWv.setValue('IBINFATT',WtA(w_IBINFATT,'C'));
l_oWv.setValue('IBTITOLO',WtA(w_IBTITOLO,'C'));
l_oWv.setValue('IBDESCRI',WtA(w_IBDESCRI,'M'));
l_oWv.setValue('IBDATSCA',WtA(w_IBDATSCA,'D'));
l_oWv.setValue('IBDATINS',WtA(w_IBDATINS,'D'));
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
_FillChildren.n=['ardt_cgo_infbacheca_doc'];
FillWv.n=["IBCODICE","IBCODCAT","IBINFATT","IBTITOLO","IBDESCRI","IBDATSCA","IBDATINS"];
function SetModified() {
m_bUpdated=true;
}
function SetChildVariables_ardt_cgo_infbacheca_doc() {
}
function CtxLoad_ardt_cgo_infbacheca_doc() {
if (ChildToLoad(FrameRef('ardt_cgo_infbacheca_doc'))) {
return [LoadContext(0,'DLDDEEJTBX'),'ardt_cgo_infbacheca_doc'];
}
}
