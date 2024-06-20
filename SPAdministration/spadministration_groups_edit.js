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
function DisplayErrorMessage_spadministration_subgroups() {
if ( ! (ChildToLoad(FrameRef('spadministration_subgroups'))) && Ne(typeof(FrameRef('spadministration_subgroups').DisplayErrorMessage),'undefined')) {
FrameRef('spadministration_subgroups').DisplayErrorMessage();
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
if (IsDisabledByStateDriver('box_EDWZXXHLLG')) {
DisableInputsInContainer(Ctrl('EDWZXXHLLG'),true);
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
function Set_idfolder(ctrlValue,kmode,e) {
if (Ne(w_idfolder,ctrlValue)) {
var ctl = _GetCtl(e,'GQMQADKZER');
if (_tracker.goon(ctl,ctrlValue)) {
w_idfolder=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('GQMQADKZER',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','N',6,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_code(ctrlValue,kmode,e) {
if (Ne(w_code,ctrlValue)) {
var ctl = _GetCtl(e,'SLTEEWARRT');
if (_tracker.goon(ctl,ctrlValue)) {
w_code=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SLTEEWARRT',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('SLTEEWARRT',function(){return WtH(w_code,'N',6,0,'999999')},w_code);
return l_bResult;
} else {
ctl.value=WtH('','N',6,0,'999999');
_ResetTracker();
return true;
}
}
return true;
}
function Set_name(ctrlValue,kmode,e) {
if (Ne(w_name,ctrlValue)) {
var ctl = _GetCtl(e,'IGYAELXEXR');
if (_tracker.goon(ctl,ctrlValue)) {
w_name=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('IGYAELXEXR',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',50,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_grptype(ctrlValue,kmode,e) {
if (Ne(w_grptype,ctrlValue)) {
var ctl = _GetCtl(e,'AWEWRIIVNS');
if (_tracker.goon(ctl,ctrlValue)) {
w_grptype=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('AWEWRIIVNS',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_datestart(ctrlValue,kmode,e) {
if (Ne(w_datestart,ctrlValue)) {
var ctl = _GetCtl(e,'XMHFZMIAMS');
if (_tracker.goon(ctl,ctrlValue)) {
w_datestart=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XMHFZMIAMS',0);
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
function Set_datestop(ctrlValue,kmode,e) {
if (Ne(w_datestop,ctrlValue)) {
var ctl = _GetCtl(e,'KNAKRRMCNW');
if (_tracker.goon(ctl,ctrlValue)) {
w_datestop=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('KNAKRRMCNW',0);
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
function Set_grpdescription(ctrlValue,kmode,e) {
if (Ne(w_grpdescription,ctrlValue)) {
var ctl = _GetCtl(e,'HFWINMHKPE');
if (_tracker.goon(ctl,ctrlValue)) {
w_grpdescription=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HFWINMHKPE',0);
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
function Set_pwdcomplexity(ctrlValue,kmode,e) {
if (Ne(w_pwdcomplexity,ctrlValue)) {
var ctl = _GetCtl(e,'VJQMUEKTSX');
if (_tracker.goon(ctl,ctrlValue)) {
w_pwdcomplexity=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VJQMUEKTSX',0);
if (l_bResult) {
l_bResult=Ge(w_pwdcomplexity,0) && Le(w_pwdcomplexity,UserAdmin.GetPasswordRatingMaxReachable());
if ( ! (l_bResult)) {
m_nLastError=2;
m_cLastWorkVarErrorMsg='11873255554';
m_cLastMsgError=AlertErrorMessage('10892072166');
}
if ( ! (l_bResult)) {
w_pwdcomplexity=HtW('','N');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'N',3,0,''));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','N',3,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_pwddaysduration(ctrlValue,kmode,e) {
if (Ne(w_pwddaysduration,ctrlValue)) {
var ctl = _GetCtl(e,'BBOWMTSSOW');
if (_tracker.goon(ctl,ctrlValue)) {
w_pwddaysduration=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BBOWMTSSOW',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','N',4,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_pwdciclicity(ctrlValue,kmode,e) {
if (Ne(w_pwdciclicity,ctrlValue)) {
var ctl = _GetCtl(e,'AKJBCTEQJP');
if (_tracker.goon(ctl,ctrlValue)) {
w_pwdciclicity=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('AKJBCTEQJP',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','N',4,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_captchalevel(ctrlValue,kmode,e) {
if (Ne(w_captchalevel,ctrlValue)) {
var ctl = _GetCtl(e,'SOASGKKWLW');
if (_tracker.goon(ctl,ctrlValue)) {
w_captchalevel=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SOASGKKWLW',0);
DoUpdate(l_bResult);
return l_bResult;
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
parent.ZtVWeb.raiseEventToEvalParms('spadministration_groups_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('spadministration_groups_dataNotSent',{'action':formaction});
}
}
}
}
CheckChild.child=[{'prg':"spadministration_subgroups",'BOScId':function(){ return FrameRef('spadministration_subgroups')},'repeated':0}];
function Check() {
var l_bResult = true;
var l_bChildCheck = true;
ResetErrorVars();
m_nLastError=0;
if ( ! (_ChkObl('GQMQADKZER',1))) {
_SignErr('GQMQADKZER');
m_cLastWorkVarErrorMsg='idfolder';
l_bResult=false;
w_idfolder=HtW('','N');
} else if ( ! (_ChkObl('SLTEEWARRT',1))) {
_SignErr('SLTEEWARRT');
m_cLastWorkVarErrorMsg='960685589';
l_bResult=false;
w_code=HtW('','N');
} else if ( ! (_ChkObl('IGYAELXEXR',1))) {
_SignErr('IGYAELXEXR');
m_cLastWorkVarErrorMsg='1682105886';
l_bResult=false;
w_name=HtW('','C');
} else if ( ! (_ChkObl('AWEWRIIVNS',1))) {
_SignErr('AWEWRIIVNS');
m_cLastWorkVarErrorMsg='10364714463';
l_bResult=false;
w_grptype=HtW('','C');
} else if ( ! (_ChkObl('XMHFZMIAMS',1))) {
_SignErr('XMHFZMIAMS');
m_cLastWorkVarErrorMsg='20009153';
l_bResult=false;
w_datestart=HtW('','D');
} else if ( ! (_ChkObl('KNAKRRMCNW',1))) {
_SignErr('KNAKRRMCNW');
m_cLastWorkVarErrorMsg='556515051';
l_bResult=false;
w_datestop=HtW('','D');
} else if (( ! (_ChkObl('VJQMUEKTSX',1))) || ( ! (Ge(w_pwdcomplexity,0) && Le(w_pwdcomplexity,UserAdmin.GetPasswordRatingMaxReachable())))) {
_SignErr('VJQMUEKTSX','10892072166');
l_bResult=false;
w_pwdcomplexity=HtW('','N');
} else if ( ! (_ChkObl('BBOWMTSSOW',1))) {
_SignErr('BBOWMTSSOW');
m_cLastWorkVarErrorMsg='1076819334';
l_bResult=false;
w_pwddaysduration=HtW('','N');
} else if ( ! (_ChkObl('AKJBCTEQJP',1))) {
_SignErr('AKJBCTEQJP');
m_cLastWorkVarErrorMsg='11641847591';
l_bResult=false;
w_pwdciclicity=HtW('','N');
} else if ( ! (_ChkObl('SOASGKKWLW',1))) {
_SignErr('SOASGKKWLW');
m_cLastWorkVarErrorMsg='10075957577';
l_bResult=false;
w_captchalevel=HtW('','N');
} else if ( ! (_ChkObl('HFWINMHKPE',1))) {
_SignErr('HFWINMHKPE');
m_cLastWorkVarErrorMsg='1209777154';
l_bResult=false;
w_grpdescription=HtW('','M');
}
if (l_bResult) {
l_bResult=CheckChild(0);
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('XMHFZMIAMS_ZOOM',lc)) {
return 0;
}
if (Eq('KNAKRRMCNW_ZOOM',lc)) {
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
l_oWv.setValue('code',WtA(w_code,'N'));
l_oWv.setValue('name',WtA(w_name,'C'));
l_oWv.setValue('grptype',WtA(w_grptype,'C'));
l_oWv.setValue('datestart',WtA(w_datestart,'D'));
l_oWv.setValue('datestop',WtA(w_datestop,'D'));
l_oWv.setValue('company',WtA(w_company,'C'));
l_oWv.setValue('pwdcomplexity',WtA(w_pwdcomplexity,'N'));
l_oWv.setValue('pwddaysduration',WtA(w_pwddaysduration,'N'));
l_oWv.setValue('pwdciclicity',WtA(w_pwdciclicity,'N'));
l_oWv.setValue('captchalevel',WtA(w_captchalevel,'N'));
l_oWv.setValue('grpdescription',WtA(w_grpdescription,'M'));
l_oWv.setValue('idfolder',WtA(w_idfolder,'N'));
l_oWv.setValue('init_code',WtA(w_init_code,'N'));
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
_FillChildren.n=['spadministration_subgroups'];
FillWv.n=["code","name","grptype","datestart","datestop","company","pwdcomplexity","pwddaysduration","pwdciclicity","captchalevel","grpdescription","idfolder","init_code"];
function SetModified() {
m_bUpdated=true;
}
function SetChildVariables_spadministration_subgroups() {
}
function CtxLoad_spadministration_subgroups() {
if (ChildToLoad(FrameRef('spadministration_subgroups'))) {
return [LoadContext(0,'CRFACLOJKX'),'spadministration_subgroups'];
}
}
