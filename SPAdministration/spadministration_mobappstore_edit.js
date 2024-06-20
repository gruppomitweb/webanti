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
function DisplayErrorMessage_spadministration_dmobapp_qkm() {
if ( ! (ChildToLoad(FrameRef('spadministration_dmobapp_qkm'))) && Ne(typeof(FrameRef('spadministration_dmobapp_qkm').DisplayErrorMessage),'undefined')) {
FrameRef('spadministration_dmobapp_qkm').DisplayErrorMessage();
}
}
function DisplayErrorMessage_spadministration_mobapppermissions() {
if ( ! (ChildToLoad(FrameRef('spadministration_mobapppermissions'))) && Ne(typeof(FrameRef('spadministration_mobapppermissions').DisplayErrorMessage),'undefined')) {
FrameRef('spadministration_mobapppermissions').DisplayErrorMessage();
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
l_bEnabled= ! (Eq(EntityStatus(),'N')) || IsDisabledByStateDriver('oaappmenu');
SetDisabled('HGEWTTQPUR',l_bEnabled);
l_bEnabled= ! (w_changeSkin) || IsDisabledByStateDriver('oaskinname');
SetDisabled('UZJHJSBNKL',l_bEnabled);
l_bEnabled= ! (false) || IsDisabledByStateDriver('oaappchecksum');
SetDisabled('GJRUFNPOQO',l_bEnabled);
l_bEnabled= ! (false) || IsDisabledByStateDriver('OAAPPACCESSMODE');
SetDisabled('ZMJJCHDRPF',l_bEnabled);
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
function Set_oa__code(ctrlValue,kmode,e) {
if (Ne(w_oa__code,ctrlValue)) {
var ctl = _GetCtl(e,'BXPAETNPNW');
if (_tracker.goon(ctl,ctrlValue)) {
w_oa__code=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BXPAETNPNW',0);
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
function Set_oaapppublished(ctrlValue,kmode,e) {
if (Ne(w_oaapppublished,ctrlValue)) {
var ctl = _GetCtl(e,'SNIXYTTVQQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_oaapppublished=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SNIXYTTVQQ',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH(0,'N',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_oareserved(ctrlValue,kmode,e) {
if (Ne(w_oareserved,ctrlValue)) {
var ctl = _GetCtl(e,'ZLZSHHUAAO');
if (_tracker.goon(ctl,ctrlValue)) {
w_oareserved=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ZLZSHHUAAO',0);
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
function Set_oaappmenu(ctrlValue,kmode,e) {
if (Ne(w_oaappmenu,ctrlValue)) {
var ctl = _GetCtl(e,'HGEWTTQPUR');
if (_tracker.goon(ctl,ctrlValue)) {
w_oaappmenu=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HGEWTTQPUR',0);
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
function Set_oaapptitle(ctrlValue,kmode,e) {
if (Ne(w_oaapptitle,ctrlValue)) {
var ctl = _GetCtl(e,'DIVZDHWPRQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_oaapptitle=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('DIVZDHWPRQ',0);
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
function Set_oadescri(ctrlValue,kmode,e) {
if (Ne(w_oadescri,ctrlValue)) {
var ctl = _GetCtl(e,'XGINRSLGED');
if (_tracker.goon(ctl,ctrlValue)) {
w_oadescri=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XGINRSLGED',0);
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
function Set_oaapplogo(ctrlValue,kmode,e) {
if (Ne(w_oaapplogo,ctrlValue)) {
var ctl = _GetCtl(e,'THXHMWDAPZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_oaapplogo=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('THXHMWDAPZ',0);
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
function Set_oaappfavico(ctrlValue,kmode,e) {
if (Ne(w_oaappfavico,ctrlValue)) {
var ctl = _GetCtl(e,'QYLTLWYYSH');
if (_tracker.goon(ctl,ctrlValue)) {
w_oaappfavico=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QYLTLWYYSH',0);
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
function Set_oaapplanding(ctrlValue,kmode,e) {
if (Ne(w_oaapplanding,ctrlValue)) {
var ctl = _GetCtl(e,'LHWJXXROEN');
if (_tracker.goon(ctl,ctrlValue)) {
w_oaapplanding=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('LHWJXXROEN',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',255,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_oaskinname(ctrlValue,kmode,e) {
if (Ne(w_oaskinname,ctrlValue)) {
var ctl = _GetCtl(e,'UZJHJSBNKL');
if (_tracker.goon(ctl,ctrlValue)) {
w_oaskinname=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UZJHJSBNKL',0);
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
function Set_changeSkin(ctrlValue,kmode,e) {
if (Ne(w_changeSkin,ctrlValue)) {
var ctl = _GetCtl(e,'JKORHAZIKU');
if (_tracker.goon(ctl,ctrlValue)) {
w_changeSkin=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('JKORHAZIKU',0);
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
function Set_oaappvariantname(ctrlValue,kmode,e) {
if (Ne(w_oaappvariantname,ctrlValue)) {
var ctl = _GetCtl(e,'LRTLIAYQMN');
if (_tracker.goon(ctl,ctrlValue)) {
w_oaappvariantname=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('LRTLIAYQMN',0);
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
function Set_oaappheader(ctrlValue,kmode,e) {
if (Ne(w_oaappheader,ctrlValue)) {
var ctl = _GetCtl(e,'MRNRGZRDQJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_oaappheader=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MRNRGZRDQJ',0);
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
function Set_oaappdescrheader(ctrlValue,kmode,e) {
if (Ne(w_oaappdescrheader,ctrlValue)) {
var ctl = _GetCtl(e,'CUOPMOHONZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_oaappdescrheader=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CUOPMOHONZ',0);
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
function Set_oaapphideutilitygroup(ctrlValue,kmode,e) {
if (Ne(w_oaapphideutilitygroup,ctrlValue)) {
var ctl = _GetCtl(e,'DAMSKDIPPB');
if (_tracker.goon(ctl,ctrlValue)) {
w_oaapphideutilitygroup=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('DAMSKDIPPB',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH(0,'N',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_oaapphomelink(ctrlValue,kmode,e) {
if (Ne(w_oaapphomelink,ctrlValue)) {
var ctl = _GetCtl(e,'EYZZDYMIDO');
if (_tracker.goon(ctl,ctrlValue)) {
w_oaapphomelink=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('EYZZDYMIDO',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',255,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_combo_homelink(ctrlValue,kmode,e) {
if (Ne(w_combo_homelink,ctrlValue)) {
var ctl = _GetCtl(e,'LMGRJMFNAF');
if (_tracker.goon(ctl,ctrlValue)) {
w_combo_homelink=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('LMGRJMFNAF',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','N',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_custom_homelink(ctrlValue,kmode,e) {
if (Ne(w_custom_homelink,ctrlValue)) {
var ctl = _GetCtl(e,'ZOTPWYUMVB');
if (_tracker.goon(ctl,ctrlValue)) {
w_custom_homelink=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ZOTPWYUMVB',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',255,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_oaappchecksum(ctrlValue,kmode,e) {
if (Ne(w_oaappchecksum,ctrlValue)) {
var ctl = _GetCtl(e,'GJRUFNPOQO');
if (_tracker.goon(ctl,ctrlValue)) {
w_oaappchecksum=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('GJRUFNPOQO',0);
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
function Set_OAAPPACCESSMODE(ctrlValue,kmode,e) {
if (Ne(w_OAAPPACCESSMODE,ctrlValue)) {
var ctl = _GetCtl(e,'ZMJJCHDRPF');
if (_tracker.goon(ctl,ctrlValue)) {
w_OAAPPACCESSMODE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ZMJJCHDRPF',0);
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
function Set_oaappdevtyp(ctrlValue,kmode,e) {
if (Ne(w_oaappdevtyp,ctrlValue)) {
var ctl = _GetCtl(e,'FBEIHIJGFG');
if (_tracker.goon(ctl,ctrlValue)) {
w_oaappdevtyp=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FBEIHIJGFG',0);
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
function Set_oaappreqreg(ctrlValue,kmode,e) {
if (Ne(w_oaappreqreg,ctrlValue)) {
var ctl = _GetCtl(e,'HRCRJRTGHT');
if (_tracker.goon(ctl,ctrlValue)) {
w_oaappreqreg=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HRCRJRTGHT',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH(0,'N',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_oaappurlreg(ctrlValue,kmode,e) {
if (Ne(w_oaappurlreg,ctrlValue)) {
var ctl = _GetCtl(e,'LDPQVCCVLI');
if (_tracker.goon(ctl,ctrlValue)) {
w_oaappurlreg=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('LDPQVCCVLI',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',255,0,'');
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
if ((Ne(o_oaappreqreg,w_oaappreqreg))) {
w_oaappurlreg=(Ne(w_oaappreqreg,1)?'':(Empty(w_oaappurlreg)?calc_url()+'/jsp-system/spadministration_mobappreg.jsp':w_oaappurlreg));
}
LibJavascript.forEachItem(m_FoundlingCopyWorkVar,i_body_1)
function i_body_1(child){
child();
}
// * --- Area Manuale = UI - Calculate
// * --- Fine Area Manuale
UpdateAutonumber('');
m_bCalculating=false;
}
function Calculation_BDPZYTDKPT() {
w_oaapphomelink=(Eq(w_combo_homelink,1)?'index':(Eq(w_combo_homelink,2)?'default':w_custom_homelink));
}
function SaveDependsOn() {
o_oaappreqreg=w_oaappreqreg;
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
parent.ZtVWeb.raiseEventToEvalParms('spadministration_mobappstore_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('spadministration_mobappstore_dataNotSent',{'action':formaction});
}
}
}
}
CheckChild.child=[{'prg':"spadministration_dmobapp_qkm",'BOScId':function(){ return FrameRef('spadministration_dmobapp_qkm')},'repeated':0},{'prg':"spadministration_mobapppermissions",'BOScId':function(){ return FrameRef('spadministration_mobapppermissions')},'repeated':0}];
function Check() {
var l_bResult = true;
var l_bChildCheck = true;
ResetErrorVars();
m_nLastError=0;
if ( ! (_ChkObl('BXPAETNPNW',1))) {
_SignErr('BXPAETNPNW');
m_cLastWorkVarErrorMsg='831361452';
l_bResult=false;
w_oa__code=HtW('','C');
} else if ( ! (_ChkObl('SNIXYTTVQQ',1))) {
_SignErr('SNIXYTTVQQ');
m_cLastWorkVarErrorMsg='11080022524';
l_bResult=false;
w_oaapppublished=0;
} else if ( ! (_ChkObl('ZLZSHHUAAO',1))) {
_SignErr('ZLZSHHUAAO');
m_cLastWorkVarErrorMsg='11473259823';
l_bResult=false;
w_oareserved='N';
} else if ((Eq(EntityStatus(),'N')) && ( ! (_ChkObl('HGEWTTQPUR',1)))) {
_SignErr('HGEWTTQPUR');
m_cLastWorkVarErrorMsg='994633243';
l_bResult=false;
w_oaappmenu=HtW('','C');
} else if ( ! (_ChkObl('DIVZDHWPRQ',1))) {
_SignErr('DIVZDHWPRQ');
m_cLastWorkVarErrorMsg='11321299471';
l_bResult=false;
w_oaapptitle=HtW('','C');
} else if ( ! (_ChkObl('XGINRSLGED',1))) {
_SignErr('XGINRSLGED');
m_cLastWorkVarErrorMsg='1932338830';
l_bResult=false;
w_oadescri=HtW('','M');
} else if ( ! (_ChkObl('THXHMWDAPZ',1))) {
_SignErr('THXHMWDAPZ');
m_cLastWorkVarErrorMsg='10728329812';
l_bResult=false;
w_oaapplogo=HtW('','C');
} else if ( ! (_ChkObl('QYLTLWYYSH',1))) {
_SignErr('QYLTLWYYSH');
m_cLastWorkVarErrorMsg='10875327060';
l_bResult=false;
w_oaappfavico=HtW('','C');
} else if ( ! (_ChkObl('LHWJXXROEN',1))) {
_SignErr('LHWJXXROEN');
m_cLastWorkVarErrorMsg='1851159004';
l_bResult=false;
w_oaapplanding=HtW('','C');
} else if ((w_changeSkin) && ( ! (_ChkObl('UZJHJSBNKL',1)))) {
_SignErr('UZJHJSBNKL');
m_cLastWorkVarErrorMsg='5686444';
l_bResult=false;
w_oaskinname=HtW('','C');
} else if ( ! (_ChkObl('JKORHAZIKU',1))) {
_SignErr('JKORHAZIKU');
m_cLastWorkVarErrorMsg='changeSkin';
l_bResult=false;
w_changeSkin=false;
} else if ( ! (_ChkObl('LRTLIAYQMN',1))) {
_SignErr('LRTLIAYQMN');
m_cLastWorkVarErrorMsg='2068761572';
l_bResult=false;
w_oaappvariantname=HtW('','C');
} else if ( ! (_ChkObl('MRNRGZRDQJ',1))) {
_SignErr('MRNRGZRDQJ');
m_cLastWorkVarErrorMsg='11215142635';
l_bResult=false;
w_oaappheader=HtW('','C');
} else if ( ! (_ChkObl('CUOPMOHONZ',1))) {
_SignErr('CUOPMOHONZ');
m_cLastWorkVarErrorMsg='1589847666';
l_bResult=false;
w_oaappdescrheader=HtW('','C');
} else if ( ! (_ChkObl('DAMSKDIPPB',1))) {
_SignErr('DAMSKDIPPB');
m_cLastWorkVarErrorMsg='527286826';
l_bResult=false;
w_oaapphideutilitygroup=0;
} else if ( ! (_ChkObl('EYZZDYMIDO',1))) {
_SignErr('EYZZDYMIDO');
m_cLastWorkVarErrorMsg='10330741240';
l_bResult=false;
w_oaapphomelink=HtW('','C');
} else if ( ! (_ChkObl('LMGRJMFNAF',1))) {
_SignErr('LMGRJMFNAF');
m_cLastWorkVarErrorMsg='2111909383';
l_bResult=false;
w_combo_homelink=HtW('','N');
} else if ( ! (_ChkObl('ZOTPWYUMVB',1))) {
_SignErr('ZOTPWYUMVB');
m_cLastWorkVarErrorMsg='custom_homelink';
l_bResult=false;
w_custom_homelink=HtW('','C');
} else if ((false) && ( ! (_ChkObl('GJRUFNPOQO',1)))) {
_SignErr('GJRUFNPOQO');
m_cLastWorkVarErrorMsg='1959402435';
l_bResult=false;
w_oaappchecksum=HtW('','C');
} else if ((false) && ( ! (_ChkObl('ZMJJCHDRPF',1)))) {
_SignErr('ZMJJCHDRPF');
m_cLastWorkVarErrorMsg='10139844320';
l_bResult=false;
w_OAAPPACCESSMODE=HtW('','C');
} else if ( ! (_ChkObl('FBEIHIJGFG',1))) {
_SignErr('FBEIHIJGFG');
m_cLastWorkVarErrorMsg='11403674860';
l_bResult=false;
w_oaappdevtyp=HtW('','C');
} else if ( ! (_ChkObl('HRCRJRTGHT',1))) {
_SignErr('HRCRJRTGHT');
m_cLastWorkVarErrorMsg='1301099432';
l_bResult=false;
w_oaappreqreg=0;
} else if ( ! (_ChkObl('LDPQVCCVLI',1))) {
_SignErr('LDPQVCCVLI');
m_cLastWorkVarErrorMsg='1097638194';
l_bResult=false;
w_oaappurlreg=HtW('','C');
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
l_oWv.setValue('oa__code',WtA(w_oa__code,'C'));
l_oWv.setValue('op_oa__code',WtA(op_oa__code,'C'));
l_oWv.setValue('oaapppublished',WtA(w_oaapppublished,'N'));
l_oWv.setValue('oareserved',WtA(w_oareserved,'C'));
l_oWv.setValue('oaappmenu',WtA(w_oaappmenu,'C'));
l_oWv.setValue('oaapptitle',WtA(w_oaapptitle,'C'));
l_oWv.setValue('oadescri',WtA(w_oadescri,'M'));
l_oWv.setValue('oaapplogo',WtA(w_oaapplogo,'C'));
l_oWv.setValue('oaappfavico',WtA(w_oaappfavico,'C'));
l_oWv.setValue('oaapplanding',WtA(w_oaapplanding,'C'));
l_oWv.setValue('oaskinname',WtA(w_oaskinname,'C'));
l_oWv.setValue('oaappvariantname',WtA(w_oaappvariantname,'C'));
l_oWv.setValue('oaappheader',WtA(w_oaappheader,'C'));
l_oWv.setValue('oaappdescrheader',WtA(w_oaappdescrheader,'C'));
l_oWv.setValue('oaapphideutilitygroup',WtA(w_oaapphideutilitygroup,'N'));
l_oWv.setValue('oaapphomelink',WtA(w_oaapphomelink,'C'));
l_oWv.setValue('oaappchecksum',WtA(w_oaappchecksum,'C'));
l_oWv.setValue('OAAPPACCESSMODE',WtA(w_OAAPPACCESSMODE,'C'));
l_oWv.setValue('oaappdevtyp',WtA(w_oaappdevtyp,'C'));
l_oWv.setValue('oaappreqreg',WtA(w_oaappreqreg,'N'));
l_oWv.setValue('oaappurlreg',WtA(w_oaappurlreg,'C'));
l_oWv.setValue('changeSkin',WtA(w_changeSkin,'L'));
l_oWv.setValue('combo_homelink',WtA(w_combo_homelink,'N'));
l_oWv.setValue('custom_homelink',WtA(w_custom_homelink,'C'));
l_oWv.setValue('forceCreateFile',WtA(w_forceCreateFile,'L'));
l_oWv.setValue('ignoreFile',WtA(w_ignoreFile,'L'));
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
_FillChildren.n=['spadministration_dmobapp_qkm','spadministration_mobapppermissions'];
FillWv.n=["oa__code","oaapppublished","oareserved","oaappmenu","oaapptitle","oadescri","oaapplogo","oaappfavico","oaapplanding","oaskinname","oaappvariantname","oaappheader","oaappdescrheader","oaapphideutilitygroup","oaapphomelink","oaappchecksum","OAAPPACCESSMODE","oaappdevtyp","oaappreqreg","oaappurlreg","changeSkin","combo_homelink","custom_homelink","forceCreateFile","ignoreFile"];
function SetModified() {
m_bUpdated=true;
}
function SetChildVariables_spadministration_dmobapp_qkm() {
}
function CtxLoad_spadministration_dmobapp_qkm() {
if (ChildToLoad(FrameRef('spadministration_dmobapp_qkm'))) {
return [LoadContext(0,'OIOVQVCCYP'),'spadministration_dmobapp_qkm'];
}
}
function SetChildVariables_spadministration_mobapppermissions() {
}
function CtxLoad_spadministration_mobapppermissions() {
if (ChildToLoad(FrameRef('spadministration_mobapppermissions'))) {
return [LoadContext(0,'XNQZSXVGTN'),'spadministration_mobapppermissions'];
}
}
