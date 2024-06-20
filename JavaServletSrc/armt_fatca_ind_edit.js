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
function EnableControlsUnderCondition_WhenReady(inherit) {
if (Eq(inherit,null)) {
inherit=true;
}
var l_bEnabled = true;
// * --- Area Manuale = UI - Enable Controls Init
// * --- Fine Area Manuale
if (window.Z && window.Z.Tabs) {
Z.Tabs.Get('tabs').CheckTabStrip();
}
LibJavascript.forEachItem(m_FoundlingEditExpression,i_body_0)
function i_body_0(child){
child();
}
DisableUI();
if (inherit && IsWndAccessible(m_oFather) &&  ! (m_oFather.m_bCalculating)) {
m_oFather.EnableControlsUnderCondition();
}
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
function Set_CONNES(ctrlValue,kmode,e) {
if (Ne(w_CONNES,ctrlValue)) {
var ctl = _GetCtl(e,'NSYKFFGVCJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_CONNES=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NSYKFFGVCJ',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',16,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_IDBASE(ctrlValue,kmode,e) {
if (Ne(w_IDBASE,ctrlValue)) {
var ctl = _GetCtl(e,'YZWHCBENDD');
if (_tracker.goon(ctl,ctrlValue)) {
w_IDBASE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YZWHCBENDD',0);
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
function Set_COUNTRYCOD(ctrlValue,kmode,e) {
if (Ne(w_COUNTRYCOD,ctrlValue)) {
var ctl = _GetCtl(e,'NMIXZFCBVE');
if (_tracker.goon(ctl,ctrlValue)) {
w_COUNTRYCOD=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NMIXZFCBVE',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',2,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_ADDRESSTYP(ctrlValue,kmode,e) {
if (Ne(w_ADDRESSTYP,ctrlValue)) {
var ctl = _GetCtl(e,'KBVBICTKSZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_ADDRESSTYP=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('KBVBICTKSZ',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',7,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_STREET(ctrlValue,kmode,e) {
if (Ne(w_STREET,ctrlValue)) {
var ctl = _GetCtl(e,'JNGCPOLBGY');
if (_tracker.goon(ctl,ctrlValue)) {
w_STREET=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('JNGCPOLBGY',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',100,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_BUILDINGID(ctrlValue,kmode,e) {
if (Ne(w_BUILDINGID,ctrlValue)) {
var ctl = _GetCtl(e,'WBPDQKOVOJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_BUILDINGID=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('WBPDQKOVOJ',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',30,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_SUITEIDENT(ctrlValue,kmode,e) {
if (Ne(w_SUITEIDENT,ctrlValue)) {
var ctl = _GetCtl(e,'UOIIIFCGSL');
if (_tracker.goon(ctl,ctrlValue)) {
w_SUITEIDENT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UOIIIFCGSL',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',30,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_FLOORIDENT(ctrlValue,kmode,e) {
if (Ne(w_FLOORIDENT,ctrlValue)) {
var ctl = _GetCtl(e,'IIONPQRDRP');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLOORIDENT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('IIONPQRDRP',0);
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
function Set_DISTRICTNA(ctrlValue,kmode,e) {
if (Ne(w_DISTRICTNA,ctrlValue)) {
var ctl = _GetCtl(e,'FVAYUICDDF');
if (_tracker.goon(ctl,ctrlValue)) {
w_DISTRICTNA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FVAYUICDDF',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',30,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_POB(ctrlValue,kmode,e) {
if (Ne(w_POB,ctrlValue)) {
var ctl = _GetCtl(e,'XKZMDIETYG');
if (_tracker.goon(ctl,ctrlValue)) {
w_POB=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XKZMDIETYG',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',30,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_POSTCODE(ctrlValue,kmode,e) {
if (Ne(w_POSTCODE,ctrlValue)) {
var ctl = _GetCtl(e,'FBHQWXLZDC');
if (_tracker.goon(ctl,ctrlValue)) {
w_POSTCODE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FBHQWXLZDC',0);
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
function Set_CITY(ctrlValue,kmode,e) {
if (Ne(w_CITY,ctrlValue)) {
var ctl = _GetCtl(e,'IDSOGPRKYJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_CITY=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('IDSOGPRKYJ',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',100,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_COUNTRYSUB(ctrlValue,kmode,e) {
if (Ne(w_COUNTRYSUB,ctrlValue)) {
var ctl = _GetCtl(e,'DUDFYTNMSV');
if (_tracker.goon(ctl,ctrlValue)) {
w_COUNTRYSUB=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('DUDFYTNMSV',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',30,0,'');
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
if (IsWndAccessible(m_oFather)) {
if (Eq(m_nChildStatus,2)) {
m_oFather.SendData(formaction,url,data);
} else if (Eq(m_nChildStatus,1)) {
if (Eq(formaction,'save')) {
if ( ! (Check())) {
DisplayErrorMessage();
return;
}
if ( ! (m_oFather.SaveContext_armt_fatca_ind())) {
WindowAlert(Translate('MSG_CANNOT_UPDATE_CALLERVAR'));
return;
}
InnerChildSendData(bResult);
} else if (Eq(formaction,'moveto') && m_bUpdated) {
WindowConfirm(Translate('MSG_LEAVE_MOD'),InnerChildSendData);
} else {
InnerChildSendData(bResult);
}
function InnerChildSendData(bResult) {
if (bResult) {
if (Eq(m_cFunction,'view') || Eq(m_cFunction,'query') || Ne(m_nLastError,1)) {
m_oFather.focus();
WindowClose();
}
if (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')) {
ResetErrorVars();
}
}
}
}
} else {
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
parent.ZtVWeb.raiseEventToEvalParms('armt_fatca_ind_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('armt_fatca_ind_dataNotSent',{'action':formaction});
}
}
}
}
}
CheckChild.child=[];
function Check() {
var l_bResult = true;
ResetErrorVars();
m_nLastError=0;
if ( ! (_ChkObl('NSYKFFGVCJ',1))) {
_SignErr('NSYKFFGVCJ');
m_cLastWorkVarErrorMsg='10847988462';
l_bResult=false;
w_CONNES=HtW('','C');
} else if ( ! (_ChkObl('YZWHCBENDD',1))) {
_SignErr('YZWHCBENDD');
m_cLastWorkVarErrorMsg='78075529';
l_bResult=false;
w_IDBASE=HtW('','C');
} else if ( ! (_ChkObl('NMIXZFCBVE',1))) {
_SignErr('NMIXZFCBVE');
m_cLastWorkVarErrorMsg='11381248851';
l_bResult=false;
w_COUNTRYCOD=HtW('','C');
} else if ( ! (_ChkObl('KBVBICTKSZ',1))) {
_SignErr('KBVBICTKSZ');
m_cLastWorkVarErrorMsg='11171687571';
l_bResult=false;
w_ADDRESSTYP=HtW('','C');
} else if ( ! (_ChkObl('JNGCPOLBGY',1))) {
_SignErr('JNGCPOLBGY');
m_cLastWorkVarErrorMsg='554236824';
l_bResult=false;
w_STREET=HtW('','C');
} else if ( ! (_ChkObl('WBPDQKOVOJ',1))) {
_SignErr('WBPDQKOVOJ');
m_cLastWorkVarErrorMsg='10361606416';
l_bResult=false;
w_BUILDINGID=HtW('','C');
} else if ( ! (_ChkObl('UOIIIFCGSL',1))) {
_SignErr('UOIIIFCGSL');
m_cLastWorkVarErrorMsg='10133933798';
l_bResult=false;
w_SUITEIDENT=HtW('','C');
} else if ( ! (_ChkObl('IIONPQRDRP',1))) {
_SignErr('IIONPQRDRP');
m_cLastWorkVarErrorMsg='612350581';
l_bResult=false;
w_FLOORIDENT=HtW('','C');
} else if ( ! (_ChkObl('FVAYUICDDF',1))) {
_SignErr('FVAYUICDDF');
m_cLastWorkVarErrorMsg='12123334500';
l_bResult=false;
w_DISTRICTNA=HtW('','C');
} else if ( ! (_ChkObl('XKZMDIETYG',1))) {
_SignErr('XKZMDIETYG');
m_cLastWorkVarErrorMsg='POB';
l_bResult=false;
w_POB=HtW('','C');
} else if ( ! (_ChkObl('FBHQWXLZDC',1))) {
_SignErr('FBHQWXLZDC');
m_cLastWorkVarErrorMsg='763135698';
l_bResult=false;
w_POSTCODE=HtW('','C');
} else if ( ! (_ChkObl('IDSOGPRKYJ',1))) {
_SignErr('IDSOGPRKYJ');
m_cLastWorkVarErrorMsg='15186643';
l_bResult=false;
w_CITY=HtW('','C');
} else if ( ! (_ChkObl('DUDFYTNMSV',1))) {
_SignErr('DUDFYTNMSV');
m_cLastWorkVarErrorMsg='COUNTRYSUB';
l_bResult=false;
w_COUNTRYSUB=HtW('','C');
}
if (l_bResult) {
l_bResult=CheckChild(0);
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
l_oWv.setValue('m_CheckVars',JSON.stringify(m_CheckVars));
l_oWv.setValue('CONNES',WtA(w_CONNES,'C'));
l_oWv.setValue('IDBASE',WtA(w_IDBASE,'C'));
l_oWv.setValue('COUNTRYCOD',WtA(w_COUNTRYCOD,'C'));
l_oWv.setValue('ADDRESSTYP',WtA(w_ADDRESSTYP,'C'));
l_oWv.setValue('STREET',WtA(w_STREET,'C'));
l_oWv.setValue('BUILDINGID',WtA(w_BUILDINGID,'C'));
l_oWv.setValue('SUITEIDENT',WtA(w_SUITEIDENT,'C'));
l_oWv.setValue('FLOORIDENT',WtA(w_FLOORIDENT,'C'));
l_oWv.setValue('DISTRICTNA',WtA(w_DISTRICTNA,'C'));
l_oWv.setValue('POB',WtA(w_POB,'C'));
l_oWv.setValue('POSTCODE',WtA(w_POSTCODE,'C'));
l_oWv.setValue('CITY',WtA(w_CITY,'C'));
l_oWv.setValue('COUNTRYSUB',WtA(w_COUNTRYSUB,'C'));
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
FillWv.n=["CONNES","IDBASE","COUNTRYCOD","ADDRESSTYP","STREET","BUILDINGID","SUITEIDENT","FLOORIDENT","DISTRICTNA","POB","POSTCODE","CITY","COUNTRYSUB"];
function SetModified() {
m_bUpdated=true;
if (IsWndAccessible(m_oFather)) {
m_oFather.SetModified_armt_fatca_ind();
}
}
function EnableEntityWhenReady(enable) {
if (enable) {
var c;
if(c=Ctrl('NSYKFFGVCJ')) SetDisabled(c,true);
if(c=Ctrl('YZWHCBENDD')) SetDisabled(c,true);
if(c=Ctrl('NMIXZFCBVE')) SetDisabled(c,true);
if(c=Ctrl('KBVBICTKSZ')) SetDisabled(c,true);
if(c=Ctrl('JNGCPOLBGY')) SetDisabled(c,true);
if(c=Ctrl('WBPDQKOVOJ')) SetDisabled(c,true);
if(c=Ctrl('UOIIIFCGSL')) SetDisabled(c,true);
if(c=Ctrl('IIONPQRDRP')) SetDisabled(c,true);
if(c=Ctrl('FVAYUICDDF')) SetDisabled(c,true);
if(c=Ctrl('XKZMDIETYG')) SetDisabled(c,true);
if(c=Ctrl('FBHQWXLZDC')) SetDisabled(c,true);
if(c=Ctrl('IDSOGPRKYJ')) SetDisabled(c,true);
if(c=Ctrl('DUDFYTNMSV')) SetDisabled(c,true);
} else {
var c;
if(c=Ctrl('NSYKFFGVCJ')) SetDisabled(c,false);
if(c=Ctrl('YZWHCBENDD')) SetDisabled(c,false);
if(c=Ctrl('NMIXZFCBVE')) SetDisabled(c,false);
if(c=Ctrl('KBVBICTKSZ')) SetDisabled(c,false);
if(c=Ctrl('JNGCPOLBGY')) SetDisabled(c,false);
if(c=Ctrl('WBPDQKOVOJ')) SetDisabled(c,false);
if(c=Ctrl('UOIIIFCGSL')) SetDisabled(c,false);
if(c=Ctrl('IIONPQRDRP')) SetDisabled(c,false);
if(c=Ctrl('FVAYUICDDF')) SetDisabled(c,false);
if(c=Ctrl('XKZMDIETYG')) SetDisabled(c,false);
if(c=Ctrl('FBHQWXLZDC')) SetDisabled(c,false);
if(c=Ctrl('IDSOGPRKYJ')) SetDisabled(c,false);
if(c=Ctrl('DUDFYTNMSV')) SetDisabled(c,false);
EnableControlsUnderCondition(false);
}
m_bChildDisabled=enable;
}
