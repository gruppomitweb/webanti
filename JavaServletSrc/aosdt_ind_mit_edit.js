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
function DisplayErrorMessage_aosdt_sub_ind_mit() {
if ( ! (ChildToLoad(FrameRef('aosdt_sub_ind_mit'))) && Ne(typeof(FrameRef('aosdt_sub_ind_mit').DisplayErrorMessage),'undefined')) {
FrameRef('aosdt_sub_ind_mit').DisplayErrorMessage();
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
l_bEnabled= ! (false) || Eq(m_cFunction,'edit') || IsDisabledByStateDriver('IDMOD');
SetDisabled('ACPSBOFDKQ',l_bEnabled);
l_bEnabled= ! (false) || IsDisabledByStateDriver('IDIND');
SetDisabled('UZHWXXEKCO',l_bEnabled);
if (IsDisabledByStateDriver('Indicatore')) {
Z.Tabs.Get("tabs_1_Indicatori").SetDisable('ROSLSYYTGJ',true);
}
if (IsDisabledByStateDriver('Subindicatori')) {
Z.Tabs.Get("tabs_1_Indicatori").SetDisable('ZURPIOBYMT',true);
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
if(c=Ctrl('YMZFJACJWK')) c.title=Strtran(AlertErrorMessage('11999868303',w_DESCRI),'\\n',"\n");
}
function SetDefaultFixedStyles() {
SetErrorField('ATCXZHNKXY',false);
}
function Set_IDMOD(ctrlValue,kmode,e) {
if (Ne(w_IDMOD,ctrlValue)) {
var ctl = _GetCtl(e,'ACPSBOFDKQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_IDMOD=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ACPSBOFDKQ',0);
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
function Set_IDIND(ctrlValue,kmode,e) {
if (Ne(w_IDIND,ctrlValue)) {
var ctl = _GetCtl(e,'UZHWXXEKCO');
if (_tracker.goon(ctl,ctrlValue)) {
w_IDIND=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UZHWXXEKCO',0);
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
function Set_PROGIND(ctrlValue,kmode,e) {
if (Ne(w_PROGIND,ctrlValue)) {
var ctl = _GetCtl(e,'EALKDPXAET');
if (_tracker.goon(ctl,ctrlValue)) {
w_PROGIND=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('EALKDPXAET',0);
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
function Set_DESCRI(ctrlValue,kmode,e) {
if (Ne(w_DESCRI,ctrlValue)) {
var ctl = _GetCtl(e,'YMZFJACJWK');
if (_tracker.goon(ctl,ctrlValue)) {
w_DESCRI=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YMZFJACJWK',0);
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
function Set_DESCRI_layer(ctrlValue,kmode,e) {
if (Ne(w_DESCRI_layer,ctrlValue)) {
var ctl = _GetCtl(e,'ATCXZHNKXY');
if (_tracker.goon(ctl,ctrlValue)) {
w_DESCRI_layer=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ATCXZHNKXY',0);
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
function Calculation_TQCPNMUFSK() {
w_DESCRI_layer=w_DESCRI;
}
function Calculation_LCRFZTFQSM() {
w_DESCRI=w_DESCRI_layer;
}
function Check_VGASZRXNOJ(p_bForce,p_bNotifyEvent) {
var l_bResult = true;
if (p_bForce) {
}
if (p_bNotifyEvent) {
var l_LastErrorMessage = m_cLastMsgError;
NotifyEvent('Descrizione exit');
m_cLastMsgError=l_LastErrorMessage;
}
return l_bResult;
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
if ( ! (m_oFather.SaveContext_aosdt_ind_mit())) {
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
parent.ZtVWeb.raiseEventToEvalParms('aosdt_ind_mit_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('aosdt_ind_mit_dataNotSent',{'action':formaction});
}
}
}
}
}
CheckChild.child=[{'prg':"aosdt_sub_ind_mit",'BOScId':function(){return FrameRef('aosdt_sub_ind_mit')},'repeated':1}];
function Check() {
var l_bResult = true;
var l_bChildCheck = true;
ResetErrorVars();
if ((false) && ( ! (_ChkObl('ACPSBOFDKQ',1)))) {
_SignErr('ACPSBOFDKQ');
m_cLastWorkVarErrorMsg='10024211400';
l_bResult=false;
w_IDMOD=HtW('','C');
} else if (( ! (Check_VGASZRXNOJ(true))) && FullRow()) {
l_bResult = false;
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
l_oWv.setValue('IDMOD',WtA(w_IDMOD,'C'));
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
FillWv.n=["IDMOD"];
function CheckRow(w) {
var l_bResult = true;
var l_bChildCheck = true;
ResetErrorVars();
if (Le(m_nCurrentRow,Rows())) {
if (((false) && ( ! (_ChkObl('UZHWXXEKCO',1)))) && FullRow()) {
_SignErr('UZHWXXEKCO');
m_cLastWorkVarErrorMsg='1305674908';
l_bResult=false;
w_IDIND=HtW('','C');
} else if (( ! (_ChkObl('EALKDPXAET',1))) && FullRow()) {
_SignErr('EALKDPXAET');
m_cLastWorkVarErrorMsg='11411528788';
l_bResult=false;
w_PROGIND=HtW('','C');
} else if (( ! (_ChkObl('YMZFJACJWK',1))) && FullRow()) {
_SignErr('YMZFJACJWK');
m_cLastWorkVarErrorMsg='10298248210';
l_bResult=false;
w_DESCRI=HtW('','M');
} else if (( ! (_ChkObl('ATCXZHNKXY',1))) && FullRow()) {
_SignErr('ATCXZHNKXY');
m_cLastWorkVarErrorMsg='285808099';
l_bResult=false;
w_DESCRI_layer=HtW('','M');
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
var l_bChildCheck = true;
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
m_oFather.SetModified_aosdt_ind_mit();
}
}
function SetChildVariables_aosdt_sub_ind_mit() {
}
function CtxLoad_aosdt_sub_ind_mit() {
if (ChildToLoad(FrameRef('aosdt_sub_ind_mit'))) {
return [LoadContext(1,'ABXVVUNOEJ'),'aosdt_sub_ind_mit'];
}
}
SaveContext.child=[{'prg':"aosdt_sub_ind_mit",'BOScId':function(){return FrameRef('aosdt_sub_ind_mit')}}];
function BlankRow() {
w_IDIND='';
w_PROGIND='';
w_DESCRI='';
w_DESCRI_layer='';
w_IDIND=LibreriaMit.UniqueId();
w_DESCRI_layer=w_DESCRI;
BlankRowChild();
if (m_bExtended) {
BlankRepeatedExtendedFields();
}
SaveDependsOn();
LoadContext(true);
}
function FullRow() {
return  ! (Empty(w_IDIND));
}
function GetRepeatedFields() {
var l_aRepeatedFields;
l_aRepeatedFields={};
l_aRepeatedFields.IDIND={"dec":0,"fixedpos":false,"id":"UZHWXXEKCO","len":10,"name":"IDIND","title":"ID del indicatore","type":"C"};
l_aRepeatedFields.PROGIND={"dec":0,"fixedpos":false,"id":"EALKDPXAET","len":10,"name":"PROGIND","title":"Progressivo indicatore","type":"C"};
l_aRepeatedFields.DESCRI={"dec":0,"fixedpos":false,"id":"YMZFJACJWK","len":10,"name":"DESCRI","title":"Descrizione del indicatore","type":"M"};
l_aRepeatedFields.DESCRI_layer={"dec":0,"fixedpos":true,"id":"ATCXZHNKXY","len":10,"name":"DESCRI_layer","title":"Descrizione","type":"M"};
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
if(c=Ctrl('ACPSBOFDKQ')) SetDisabled(c,true);
if(c=Ctrl('ATCXZHNKXY')) SetDisabled(c,true);
if ( ! (ChildToLoad(FrameRef('aosdt_sub_ind_mit'))) && Ne(typeof(FrameRef('aosdt_sub_ind_mit').EnableEntity),'undefined')) {
FrameRef('aosdt_sub_ind_mit').EnableEntity(true);
}
SetQueryRow(Ctrl('GridTable'),false);
} else {
SetEditRow(Ctrl('GridTable'),false);
var c;
if(c=Ctrl('ACPSBOFDKQ')) SetDisabled(c,false);
if(c=Ctrl('ATCXZHNKXY')) SetDisabled(c,false);
if ( ! (ChildToLoad(FrameRef('aosdt_sub_ind_mit'))) && Ne(typeof(FrameRef('aosdt_sub_ind_mit').EnableEntity),'undefined')) {
FrameRef('aosdt_sub_ind_mit').EnableEntity(false);
}
EnableControlsUnderCondition(false);
}
m_bChildDisabled=enable;
}
