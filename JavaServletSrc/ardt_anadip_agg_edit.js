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
function Set_SOSAGENZIA(ctrlValue,kmode,e) {
if (Ne(w_SOSAGENZIA,ctrlValue)) {
var ctl = _GetCtl(e,'NHORYNPKJE');
if (_tracker.goon(ctl,ctrlValue)) {
w_SOSAGENZIA=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NHORYNPKJE',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','N',3,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_ANNORIF(ctrlValue,kmode,e) {
if (Ne(w_ANNORIF,ctrlValue)) {
var ctl = _GetCtl(e,'VTKPZXOJNA');
if (_tracker.goon(ctl,ctrlValue)) {
w_ANNORIF=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VTKPZXOJNA',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('VTKPZXOJNA',function(){return WtH(w_ANNORIF,'N',4,0,'9999')},w_ANNORIF);
return l_bResult;
} else {
ctl.value=WtH('','N',4,0,'9999');
_ResetTracker();
return true;
}
}
return true;
}
function Set_MESERIF(ctrlValue,kmode,e) {
if (Ne(w_MESERIF,ctrlValue)) {
var ctl = _GetCtl(e,'BWTIUEDQGZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_MESERIF=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BWTIUEDQGZ',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('BWTIUEDQGZ',function(){return WtH(w_MESERIF,'N',2,0,'99')},w_MESERIF);
return l_bResult;
} else {
ctl.value=WtH('','N',2,0,'99');
_ResetTracker();
return true;
}
}
return true;
}
function Set_SOSCLIENTI(ctrlValue,kmode,e) {
if (Ne(w_SOSCLIENTI,ctrlValue)) {
var ctl = _GetCtl(e,'AOUYQGNXQU');
if (_tracker.goon(ctl,ctrlValue)) {
w_SOSCLIENTI=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('AOUYQGNXQU',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','N',3,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_ANOMAGE(ctrlValue,kmode,e) {
if (Ne(w_ANOMAGE,ctrlValue)) {
var ctl = _GetCtl(e,'KVHOYDAEWK');
if (_tracker.goon(ctl,ctrlValue)) {
w_ANOMAGE=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('KVHOYDAEWK',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('KVHOYDAEWK',function(){return WtH(w_ANOMAGE,'N',3,0,'999')},w_ANOMAGE);
return l_bResult;
} else {
ctl.value=WtH('','N',3,0,'999');
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
if ( ! (m_oFather.SaveContext_ardt_anadip_agg())) {
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
parent.ZtVWeb.raiseEventToEvalParms('ardt_anadip_agg_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('ardt_anadip_agg_dataNotSent',{'action':formaction});
}
}
}
}
}
CheckChild.child=[];
function Check() {
var l_bResult = true;
ResetErrorVars();
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
l_oWv.setValue('CODDIPE',WtA(w_CODDIPE,'C'));
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
FillWv.n=["CODDIPE"];
function CheckRow(w) {
var l_bResult = true;
ResetErrorVars();
if (Le(m_nCurrentRow,Rows())) {
if (( ! (_ChkObl('VTKPZXOJNA',1))) && FullRow()) {
_SignErr('VTKPZXOJNA');
m_cLastWorkVarErrorMsg='863017169';
l_bResult=false;
w_ANNORIF=HtW('','N');
} else if (( ! (_ChkObl('BWTIUEDQGZ',1))) && FullRow()) {
_SignErr('BWTIUEDQGZ');
m_cLastWorkVarErrorMsg='862977325';
l_bResult=false;
w_MESERIF=HtW('','N');
} else if (( ! (_ChkObl('KVHOYDAEWK',1))) && FullRow()) {
_SignErr('KVHOYDAEWK');
m_cLastWorkVarErrorMsg='1094517073';
l_bResult=false;
w_ANOMAGE=HtW('','N');
} else if (( ! (_ChkObl('AOUYQGNXQU',1))) && FullRow()) {
_SignErr('AOUYQGNXQU');
m_cLastWorkVarErrorMsg='11631654360';
l_bResult=false;
w_SOSCLIENTI=HtW('','N');
} else if (( ! (_ChkObl('NHORYNPKJE',1))) && FullRow()) {
_SignErr('NHORYNPKJE');
m_cLastWorkVarErrorMsg='11602603142';
l_bResult=false;
w_SOSAGENZIA=HtW('','N');
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
m_oFather.SetModified_ardt_anadip_agg();
}
}
SaveContext.child=[];
function BlankRow() {
w_ANNORIF=0;
w_MESERIF=0;
w_DATAINI=NullDate();
w_DATAFINE=NullDate();
w_ANOMAGE=0;
w_SOSCLIENTI=0;
w_SOSAGENZIA=0;
BlankRowChild();
if (m_bExtended) {
BlankRepeatedExtendedFields();
}
SaveDependsOn();
LoadContext(true);
}
function FullRow() {
return  ! (Empty(w_ANNORIF));
}
function GetRepeatedFields() {
var l_aRepeatedFields;
l_aRepeatedFields={};
l_aRepeatedFields.ANNORIF={"dec":0,"fixedpos":false,"id":"VTKPZXOJNA","len":4,"name":"ANNORIF","title":"Anno di riferimento","type":"N"};
l_aRepeatedFields.MESERIF={"dec":0,"fixedpos":false,"id":"BWTIUEDQGZ","len":2,"name":"MESERIF","title":"Mese di Riferimento","type":"N"};
l_aRepeatedFields.DATAINI={"dec":0,"fixedpos":true,"id":"YMUIFJRUNG","len":8,"name":"DATAINI","title":"Data Inizio Periodo","type":"D"};
l_aRepeatedFields.DATAFINE={"dec":0,"fixedpos":true,"id":"UFGJATFCDD","len":8,"name":"DATAFINE","title":"Data Fine Periodo","type":"D"};
l_aRepeatedFields.ANOMAGE={"dec":0,"fixedpos":false,"id":"KVHOYDAEWK","len":3,"name":"ANOMAGE","title":"Anomalie Agenzia","type":"N"};
l_aRepeatedFields.SOSCLIENTI={"dec":0,"fixedpos":false,"id":"AOUYQGNXQU","len":3,"name":"SOSCLIENTI","title":"Sos sui clienti dell'agenzia","type":"N"};
l_aRepeatedFields.SOSAGENZIA={"dec":0,"fixedpos":false,"id":"NHORYNPKJE","len":3,"name":"SOSAGENZIA","title":"Sos sull'agente","type":"N"};
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
SetQueryRow(Ctrl('GridTable'),false);
} else {
SetEditRow(Ctrl('GridTable'),false);
var c;
EnableControlsUnderCondition(false);
}
m_bChildDisabled=enable;
}
