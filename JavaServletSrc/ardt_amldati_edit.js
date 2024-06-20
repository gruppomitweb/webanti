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
if (Ne('undefined',typeof(DisableChainedLinks))) {
DisableChainedLinks(Ne(0,m_oTrs.length));
}
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
function SetDefaultFixedStyles() {
}
function Set_IDAMLANNO(ctrlValue,kmode,e) {
if (Ne(w_IDAMLANNO,ctrlValue)) {
var ctl = _GetCtl(e,'NSUYYWAOJV');
if (_tracker.goon(ctl,ctrlValue)) {
w_IDAMLANNO=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NSUYYWAOJV',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',4,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_IDBASE(ctrlValue,kmode,e) {
if (Ne(w_IDBASE,ctrlValue)) {
var ctl = _GetCtl(e,'UASFCHXLRC');
if (_tracker.goon(ctl,ctrlValue)) {
w_IDBASE=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UASFCHXLRC',0);
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
function Set_LIV1(ctrlValue,kmode,e) {
if (Ne(w_LIV1,ctrlValue)) {
var ctl = _GetCtl(e,'AFSDOMRNZC');
if (_tracker.goon(ctl,ctrlValue)) {
w_LIV1=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('AFSDOMRNZC',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',3,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_LIV2(ctrlValue,kmode,e) {
if (Ne(w_LIV2,ctrlValue)) {
var ctl = _GetCtl(e,'LMBDWDWYOJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_LIV2=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('LMBDWDWYOJ',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',3,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_LIV3(ctrlValue,kmode,e) {
if (Ne(w_LIV3,ctrlValue)) {
var ctl = _GetCtl(e,'OUCAYORICR');
if (_tracker.goon(ctl,ctrlValue)) {
w_LIV3=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('OUCAYORICR',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',3,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_N1(ctrlValue,kmode,e) {
if (Ne(w_N1,ctrlValue)) {
var ctl = _GetCtl(e,'WFEQRDUEHK');
if (_tracker.goon(ctl,ctrlValue)) {
w_N1=ValidNum(ctrlValue,'999999999999.99');
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('WFEQRDUEHK',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('WFEQRDUEHK',function(){return WtH(w_N1,'N',15,2,'999999999999.99')},w_N1);
return l_bResult;
} else {
ctl.value=WtH('','N',15,2,'999999999999.99');
_ResetTracker();
return true;
}
}
return true;
}
function Set_N2(ctrlValue,kmode,e) {
if (Ne(w_N2,ctrlValue)) {
var ctl = _GetCtl(e,'AXLQDUTMKE');
if (_tracker.goon(ctl,ctrlValue)) {
w_N2=ValidNum(ctrlValue,'999999999999.99');
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('AXLQDUTMKE',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('AXLQDUTMKE',function(){return WtH(w_N2,'N',15,2,'999999999999.99')},w_N2);
return l_bResult;
} else {
ctl.value=WtH('','N',15,2,'999999999999.99');
_ResetTracker();
return true;
}
}
return true;
}
function Set_N3(ctrlValue,kmode,e) {
if (Ne(w_N3,ctrlValue)) {
var ctl = _GetCtl(e,'UQEGOTONHO');
if (_tracker.goon(ctl,ctrlValue)) {
w_N3=ValidNum(ctrlValue,'999999999999.99');
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UQEGOTONHO',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('UQEGOTONHO',function(){return WtH(w_N3,'N',15,2,'999999999999.99')},w_N3);
return l_bResult;
} else {
ctl.value=WtH('','N',15,2,'999999999999.99');
_ResetTracker();
return true;
}
}
return true;
}
function Set_N4(ctrlValue,kmode,e) {
if (Ne(w_N4,ctrlValue)) {
var ctl = _GetCtl(e,'VLPHUFHRWG');
if (_tracker.goon(ctl,ctrlValue)) {
w_N4=ValidNum(ctrlValue,'999999999999.99');
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VLPHUFHRWG',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('VLPHUFHRWG',function(){return WtH(w_N4,'N',15,2,'999999999999.99')},w_N4);
return l_bResult;
} else {
ctl.value=WtH('','N',15,2,'999999999999.99');
_ResetTracker();
return true;
}
}
return true;
}
function Set_N5(ctrlValue,kmode,e) {
if (Ne(w_N5,ctrlValue)) {
var ctl = _GetCtl(e,'RNANYATLJA');
if (_tracker.goon(ctl,ctrlValue)) {
w_N5=ValidNum(ctrlValue,'999999999999.99');
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RNANYATLJA',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('RNANYATLJA',function(){return WtH(w_N5,'N',15,2,'999999999999.99')},w_N5);
return l_bResult;
} else {
ctl.value=WtH('','N',15,2,'999999999999.99');
_ResetTracker();
return true;
}
}
return true;
}
function Set_N6(ctrlValue,kmode,e) {
if (Ne(w_N6,ctrlValue)) {
var ctl = _GetCtl(e,'FGZMGIETJK');
if (_tracker.goon(ctl,ctrlValue)) {
w_N6=ValidNum(ctrlValue,'999999999999.99');
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FGZMGIETJK',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('FGZMGIETJK',function(){return WtH(w_N6,'N',15,2,'999999999999.99')},w_N6);
return l_bResult;
} else {
ctl.value=WtH('','N',15,2,'999999999999.99');
_ResetTracker();
return true;
}
}
return true;
}
function Set_N7(ctrlValue,kmode,e) {
if (Ne(w_N7,ctrlValue)) {
var ctl = _GetCtl(e,'TTSVMTXSHK');
if (_tracker.goon(ctl,ctrlValue)) {
w_N7=ValidNum(ctrlValue,'999999999999.99');
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('TTSVMTXSHK',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('TTSVMTXSHK',function(){return WtH(w_N7,'N',15,2,'999999999999.99')},w_N7);
return l_bResult;
} else {
ctl.value=WtH('','N',15,2,'999999999999.99');
_ResetTracker();
return true;
}
}
return true;
}
function Set_C1(ctrlValue,kmode,e) {
if (Ne(w_C1,ctrlValue)) {
var ctl = _GetCtl(e,'BCQNNDGTFP');
if (_tracker.goon(ctl,ctrlValue)) {
w_C1=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BCQNNDGTFP',0);
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
function Set_C2(ctrlValue,kmode,e) {
if (Ne(w_C2,ctrlValue)) {
var ctl = _GetCtl(e,'YQPUAGHCIC');
if (_tracker.goon(ctl,ctrlValue)) {
w_C2=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YQPUAGHCIC',0);
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
function Set_C3(ctrlValue,kmode,e) {
if (Ne(w_C3,ctrlValue)) {
var ctl = _GetCtl(e,'VBELTUYZHN');
if (_tracker.goon(ctl,ctrlValue)) {
w_C3=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VBELTUYZHN',0);
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
function Set_C4(ctrlValue,kmode,e) {
if (Ne(w_C4,ctrlValue)) {
var ctl = _GetCtl(e,'BYRSYJQNCL');
if (_tracker.goon(ctl,ctrlValue)) {
w_C4=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BYRSYJQNCL',0);
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
function Set_C5(ctrlValue,kmode,e) {
if (Ne(w_C5,ctrlValue)) {
var ctl = _GetCtl(e,'PCMHVKTTLL');
if (_tracker.goon(ctl,ctrlValue)) {
w_C5=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('PCMHVKTTLL',0);
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
function Set_C6(ctrlValue,kmode,e) {
if (Ne(w_C6,ctrlValue)) {
var ctl = _GetCtl(e,'RTBHNLUHZE');
if (_tracker.goon(ctl,ctrlValue)) {
w_C6=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RTBHNLUHZE',0);
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
function Set_C7(ctrlValue,kmode,e) {
if (Ne(w_C7,ctrlValue)) {
var ctl = _GetCtl(e,'SWIJFJKKLJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_C7=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SWIJFJKKLJ',0);
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
function Set_BOX(ctrlValue,kmode,e) {
if (Ne(w_BOX,ctrlValue)) {
var ctl = _GetCtl(e,'OIVQOXTGIZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_BOX=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('OIVQOXTGIZ',0);
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
if ( ! (SaveRow())) {
return;
}
if ( ! (Check())) {
DisplayErrorMessage();
return;
}
if ( ! (m_oFather.SaveContext_ardt_amldati())) {
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
NotifyEvent('Before Save Row');
bResult=bResult && SaveRow(true);
if (bResult) {
NotifyEvent('Before Save');
l_Checks();
}
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
parent.ZtVWeb.raiseEventToEvalParms('ardt_amldati_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('ardt_amldati_dataNotSent',{'action':formaction});
}
}
}
}
}
CheckChild.child=[];
function Check() {
var l_bResult = true;
ResetErrorVars();
if ( ! (_ChkObl('NSUYYWAOJV',1))) {
_SignErr('NSUYYWAOJV');
m_cLastWorkVarErrorMsg='999531942';
l_bResult=false;
w_IDAMLANNO=HtW('','C');
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
l_oWv.setValue('IDAMLANNO',WtA(w_IDAMLANNO,'C'));
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
if (Ne(m_cFunction,'view')) {
l_oWv.setValue('m_bHeaderUpdated',WtA(m_bHeaderUpdated,'L'));
l_oWv.setValue('m_oTrs',TrsApplet().asString());
}
}
_FillChildren.n=[];
FillWv.n=["IDAMLANNO"];
function CheckRow(w) {
var l_bResult = true;
ResetErrorVars();
if (Le(m_nCurrentRow,Rows())) {
if (( ! (_ChkObl('UASFCHXLRC',1))) && FullRow()) {
_SignErr('UASFCHXLRC');
m_cLastWorkVarErrorMsg='IDBASE';
l_bResult=false;
w_IDBASE=HtW('','C');
} else if (( ! (_ChkObl('AFSDOMRNZC',1))) && FullRow()) {
_SignErr('AFSDOMRNZC');
m_cLastWorkVarErrorMsg='LIV1';
l_bResult=false;
w_LIV1=HtW('','C');
} else if (( ! (_ChkObl('LMBDWDWYOJ',1))) && FullRow()) {
_SignErr('LMBDWDWYOJ');
m_cLastWorkVarErrorMsg='LIV2';
l_bResult=false;
w_LIV2=HtW('','C');
} else if (( ! (_ChkObl('OUCAYORICR',1))) && FullRow()) {
_SignErr('OUCAYORICR');
m_cLastWorkVarErrorMsg='LIV3';
l_bResult=false;
w_LIV3=HtW('','C');
} else if (( ! (_ChkObl('WFEQRDUEHK',1))) && FullRow()) {
_SignErr('WFEQRDUEHK');
m_cLastWorkVarErrorMsg='N1';
l_bResult=false;
w_N1=HtW('','N');
} else if (( ! (_ChkObl('AXLQDUTMKE',1))) && FullRow()) {
_SignErr('AXLQDUTMKE');
m_cLastWorkVarErrorMsg='N2';
l_bResult=false;
w_N2=HtW('','N');
} else if (( ! (_ChkObl('UQEGOTONHO',1))) && FullRow()) {
_SignErr('UQEGOTONHO');
m_cLastWorkVarErrorMsg='N3';
l_bResult=false;
w_N3=HtW('','N');
} else if (( ! (_ChkObl('VLPHUFHRWG',1))) && FullRow()) {
_SignErr('VLPHUFHRWG');
m_cLastWorkVarErrorMsg='N4';
l_bResult=false;
w_N4=HtW('','N');
} else if (( ! (_ChkObl('RNANYATLJA',1))) && FullRow()) {
_SignErr('RNANYATLJA');
m_cLastWorkVarErrorMsg='N5';
l_bResult=false;
w_N5=HtW('','N');
} else if (( ! (_ChkObl('FGZMGIETJK',1))) && FullRow()) {
_SignErr('FGZMGIETJK');
m_cLastWorkVarErrorMsg='N6';
l_bResult=false;
w_N6=HtW('','N');
} else if (( ! (_ChkObl('TTSVMTXSHK',1))) && FullRow()) {
_SignErr('TTSVMTXSHK');
m_cLastWorkVarErrorMsg='N7';
l_bResult=false;
w_N7=HtW('','N');
} else if (( ! (_ChkObl('BCQNNDGTFP',1))) && FullRow()) {
_SignErr('BCQNNDGTFP');
m_cLastWorkVarErrorMsg='C1';
l_bResult=false;
w_C1=HtW('','C');
} else if (( ! (_ChkObl('YQPUAGHCIC',1))) && FullRow()) {
_SignErr('YQPUAGHCIC');
m_cLastWorkVarErrorMsg='C2';
l_bResult=false;
w_C2=HtW('','C');
} else if (( ! (_ChkObl('VBELTUYZHN',1))) && FullRow()) {
_SignErr('VBELTUYZHN');
m_cLastWorkVarErrorMsg='C3';
l_bResult=false;
w_C3=HtW('','C');
} else if (( ! (_ChkObl('BYRSYJQNCL',1))) && FullRow()) {
_SignErr('BYRSYJQNCL');
m_cLastWorkVarErrorMsg='C4';
l_bResult=false;
w_C4=HtW('','C');
} else if (( ! (_ChkObl('PCMHVKTTLL',1))) && FullRow()) {
_SignErr('PCMHVKTTLL');
m_cLastWorkVarErrorMsg='C5';
l_bResult=false;
w_C5=HtW('','C');
} else if (( ! (_ChkObl('RTBHNLUHZE',1))) && FullRow()) {
_SignErr('RTBHNLUHZE');
m_cLastWorkVarErrorMsg='C6';
l_bResult=false;
w_C6=HtW('','C');
} else if (( ! (_ChkObl('SWIJFJKKLJ',1))) && FullRow()) {
_SignErr('SWIJFJKKLJ');
m_cLastWorkVarErrorMsg='C7';
l_bResult=false;
w_C7=HtW('','C');
} else if (( ! (_ChkObl('OIVQOXTGIZ',1))) && FullRow()) {
_SignErr('OIVQOXTGIZ');
m_cLastWorkVarErrorMsg='BOX';
l_bResult=false;
w_BOX=HtW('','M');
}
}
if (FullRow()) {
if (l_bResult) {
l_bResult=CheckChild(1);
}
}
DisableChainedLinks(true);
// * --- Area Manuale = UI - Check Row
// * --- Fine Area Manuale
return l_bResult;
}
function CheckDeleteRow() {
var l_bResult = true;
ResetErrorVars();
return l_bResult;
}
function SetModified(bRepeated) {
m_bUpdated=true;
if (bRepeated) {
if (Le(m_nCurrentRow,m_oTrs.length) && Eq(m_nRowStatus,0)) {
m_nRowStatus=1;
}
} else {
m_bHeaderUpdated=true;
}
if (IsWndAccessible(m_oFather)) {
m_oFather.SetModified_ardt_amldati();
}
}
SaveContext.child=[];
function BlankRow() {
w_IDBASE='';
w_LIV1='';
w_LIV2='';
w_LIV3='';
w_N1=0;
w_N2=0;
w_N3=0;
w_N4=0;
w_N5=0;
w_N6=0;
w_N7=0;
w_C1='';
w_C2='';
w_C3='';
w_C4='';
w_C5='';
w_C6='';
w_C7='';
w_BOX='';
BlankRowChild();
if (m_bExtended) {
BlankRepeatedExtendedFields();
}
SaveDependsOn();
LoadContext(true);
}
function FullRow() {
return  ! (Empty(w_IDBASE));
}
function GetRepeatedFields() {
var l_aRepeatedFields;
l_aRepeatedFields={};
l_aRepeatedFields.IDBASE={"dec":0,"fixedpos":false,"id":"UASFCHXLRC","len":10,"name":"IDBASE","title":"","type":"C"};
l_aRepeatedFields.LIV1={"dec":0,"fixedpos":false,"id":"AFSDOMRNZC","len":3,"name":"LIV1","title":"","type":"C"};
l_aRepeatedFields.LIV2={"dec":0,"fixedpos":false,"id":"LMBDWDWYOJ","len":3,"name":"LIV2","title":"","type":"C"};
l_aRepeatedFields.LIV3={"dec":0,"fixedpos":false,"id":"OUCAYORICR","len":3,"name":"LIV3","title":"","type":"C"};
l_aRepeatedFields.N1={"dec":2,"fixedpos":false,"id":"WFEQRDUEHK","len":15,"name":"N1","title":"","type":"N"};
l_aRepeatedFields.N2={"dec":2,"fixedpos":false,"id":"AXLQDUTMKE","len":15,"name":"N2","title":"","type":"N"};
l_aRepeatedFields.N3={"dec":2,"fixedpos":false,"id":"UQEGOTONHO","len":15,"name":"N3","title":"","type":"N"};
l_aRepeatedFields.N4={"dec":2,"fixedpos":false,"id":"VLPHUFHRWG","len":15,"name":"N4","title":"","type":"N"};
l_aRepeatedFields.N5={"dec":2,"fixedpos":false,"id":"RNANYATLJA","len":15,"name":"N5","title":"","type":"N"};
l_aRepeatedFields.N6={"dec":2,"fixedpos":false,"id":"FGZMGIETJK","len":15,"name":"N6","title":"","type":"N"};
l_aRepeatedFields.N7={"dec":2,"fixedpos":false,"id":"TTSVMTXSHK","len":15,"name":"N7","title":"","type":"N"};
l_aRepeatedFields.C1={"dec":0,"fixedpos":false,"id":"BCQNNDGTFP","len":100,"name":"C1","title":"","type":"C"};
l_aRepeatedFields.C2={"dec":0,"fixedpos":false,"id":"YQPUAGHCIC","len":100,"name":"C2","title":"","type":"C"};
l_aRepeatedFields.C3={"dec":0,"fixedpos":false,"id":"VBELTUYZHN","len":100,"name":"C3","title":"","type":"C"};
l_aRepeatedFields.C4={"dec":0,"fixedpos":false,"id":"BYRSYJQNCL","len":100,"name":"C4","title":"","type":"C"};
l_aRepeatedFields.C5={"dec":0,"fixedpos":false,"id":"PCMHVKTTLL","len":100,"name":"C5","title":"","type":"C"};
l_aRepeatedFields.C6={"dec":0,"fixedpos":false,"id":"RTBHNLUHZE","len":100,"name":"C6","title":"","type":"C"};
l_aRepeatedFields.C7={"dec":0,"fixedpos":false,"id":"SWIJFJKKLJ","len":100,"name":"C7","title":"","type":"C"};
l_aRepeatedFields.BOX={"dec":0,"fixedpos":false,"id":"OIVQOXTGIZ","len":10,"name":"BOX","title":"","type":"M"};
return l_aRepeatedFields;
}
function SubtractTotals() {
}
function hasDepOnTotals() {
}
function DisableChainedLinks(disable) {
}
function EnableEntityWhenReady(enable) {
if (enable) {
var c;
if(c=Ctrl('NSUYYWAOJV')) SetDisabled(c,true);
SetQueryRow(Ctrl('GridTable'),false);
} else {
SetEditRow(Ctrl('GridTable'),false);
var c;
if(c=Ctrl('NSUYYWAOJV')) SetDisabled(c,false);
EnableControlsUnderCondition(false);
}
m_bChildDisabled=enable;
}
