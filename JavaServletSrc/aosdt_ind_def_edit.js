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
function DisplayErrorMessage_aosdt_sub_ind_def() {
if ( ! (ChildToLoad(FrameRef('aosdt_sub_ind_def'))) && Ne(typeof(FrameRef('aosdt_sub_ind_def').DisplayErrorMessage),'undefined')) {
FrameRef('aosdt_sub_ind_def').DisplayErrorMessage();
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
SetDisabled('UUNKNVCACF',l_bEnabled);
l_bEnabled= ! (false) || IsDisabledByStateDriver('IDIND');
SetDisabled('ATQBDCKYMD',l_bEnabled);
l_bEnabled= ! ( ! (w_LOCKMIT)) || IsDisabledByStateDriver('PROGIND');
SetDisabled('CFHSVGUQQV',l_bEnabled);
l_bEnabled= ! (false) || IsDisabledByStateDriver('DESCRI');
SetDisabled('NMPXBKDZYD',l_bEnabled);
l_bEnabled= ! (false) || IsDisabledByStateDriver('LOCKMIT');
SetDisabled('QILTYWPQKG',l_bEnabled);
l_bEnabled= ! (Eq(EntityStatus(),'N')) || IsDisabledByStateDriver('NOAPPLIC');
SetDisabled('TAGTIKFOAX',l_bEnabled);
l_bEnabled= ! ( ! (w_LOCKMIT) || w_write_layer) || IsDisabledByStateDriver('DESCRI_layer');
SetDisabled('ATCXZHNKXY',l_bEnabled);
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
}
function SetDefaultFixedStyles() {
SetErrorField('ATQBDCKYMD',false);
SetErrorField('ATCXZHNKXY',false);
}
function Set_IDMOD(ctrlValue,kmode,e) {
if (Ne(w_IDMOD,ctrlValue)) {
var ctl = _GetCtl(e,'UUNKNVCACF');
if (_tracker.goon(ctl,ctrlValue)) {
w_IDMOD=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UUNKNVCACF',0);
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
function Set_show_noapplic(ctrlValue,kmode,e) {
if (Ne(w_show_noapplic,ctrlValue)) {
var ctl = _GetCtl(e,'QOEOGAAKRA');
if (_tracker.goon(ctl,ctrlValue)) {
w_show_noapplic=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QOEOGAAKRA',0);
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
function Set_IDIND(ctrlValue,kmode,e) {
if (Ne(w_IDIND,ctrlValue)) {
var ctl = _GetCtl(e,'ATQBDCKYMD');
if (_tracker.goon(ctl,ctrlValue)) {
w_IDIND=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ATQBDCKYMD',0);
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
var ctl = _GetCtl(e,'CFHSVGUQQV');
if (_tracker.goon(ctl,ctrlValue)) {
w_PROGIND=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CFHSVGUQQV',0);
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
var ctl = _GetCtl(e,'NMPXBKDZYD');
if (_tracker.goon(ctl,ctrlValue)) {
w_DESCRI=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NMPXBKDZYD',0);
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
function Set_LOCKMIT(ctrlValue,kmode,e) {
if (Ne(w_LOCKMIT,ctrlValue)) {
var ctl = _GetCtl(e,'QILTYWPQKG');
if (_tracker.goon(ctl,ctrlValue)) {
w_LOCKMIT=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QILTYWPQKG',0);
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
function Set_NOAPPLIC(ctrlValue,kmode,e) {
if (Ne(w_NOAPPLIC,ctrlValue)) {
var ctl = _GetCtl(e,'TAGTIKFOAX');
if (_tracker.goon(ctl,ctrlValue)) {
w_NOAPPLIC=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('TAGTIKFOAX',0);
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
if ( ! (ChildToLoad(FrameRef('aosdt_sub_ind_def'))) && Ne(typeof(FrameRef('aosdt_sub_ind_def').DoUpdate),'undefined')) {
CopyWorkVar(FrameRef('aosdt_sub_ind_def'),['show_noapplic'],['show_noapplic'],true)
}
LibJavascript.forEachItem(m_FoundlingCopyWorkVar,i_body_1)
function i_body_1(child){
child();
}
// * --- Area Manuale = UI - Calculate
// * --- Fine Area Manuale
m_bCalculating=false;
}
function Calculation_TQCPNMUFSK() {
w_write_layer=true;
w_DESCRI_layer=w_DESCRI;
w_write_layer=false;
w_open_layer=true;
}
function Calculation_LCRFZTFQSM() {
if ( ! (w_LOCKMIT) ||  ! (Empty(w_DESCRI_layer))) {
w_DESCRI=w_DESCRI_layer;
}
w_open_layer=false;
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
o_show_noapplic=w_show_noapplic;
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
if ( ! (m_oFather.SaveContext_aosdt_ind_def())) {
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
parent.ZtVWeb.raiseEventToEvalParms('aosdt_ind_def_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('aosdt_ind_def_dataNotSent',{'action':formaction});
}
}
}
}
}
CheckChild.child=[{'prg':"aosdt_sub_ind_def",'BOScId':function(){return FrameRef('aosdt_sub_ind_def')},'repeated':1}];
function Check() {
var l_bResult = true;
var l_bChildCheck = true;
ResetErrorVars();
if ((false) && ( ! (_ChkObl('UUNKNVCACF',1)))) {
_SignErr('UUNKNVCACF');
m_cLastWorkVarErrorMsg='10024211400';
l_bResult=false;
w_IDMOD=HtW('','C');
} else if ( ! (_ChkObl('QOEOGAAKRA',1))) {
_SignErr('QOEOGAAKRA');
m_cLastWorkVarErrorMsg='10273053127';
l_bResult=false;
w_show_noapplic=false;
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
l_oWv.setValue('show_noapplic',WtA(w_show_noapplic,'L'));
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
FillWv.n=["IDMOD","show_noapplic"];
function CheckRow(w) {
var l_bResult = true;
var l_bChildCheck = true;
ResetErrorVars();
if (Le(m_nCurrentRow,Rows())) {
if (((false) && ( ! (_ChkObl('ATQBDCKYMD',1)))) && FullRow()) {
_SignErr('ATQBDCKYMD');
m_cLastWorkVarErrorMsg='1305674908';
l_bResult=false;
w_IDIND=HtW('','C');
} else if ((( ! (w_LOCKMIT)) && ( ! (_ChkObl('CFHSVGUQQV',1)))) && FullRow()) {
_SignErr('CFHSVGUQQV');
m_cLastWorkVarErrorMsg='11411528788';
l_bResult=false;
w_PROGIND=HtW('','C');
} else if (((false) && ( ! (_ChkObl('NMPXBKDZYD',1)))) && FullRow()) {
_SignErr('NMPXBKDZYD');
m_cLastWorkVarErrorMsg='10298248210';
l_bResult=false;
w_DESCRI=HtW('','M');
} else if (((false) && ( ! (_ChkObl('QILTYWPQKG',1)))) && FullRow()) {
_SignErr('QILTYWPQKG');
m_cLastWorkVarErrorMsg='2073739548';
l_bResult=false;
w_LOCKMIT=false;
} else if (((Eq(EntityStatus(),'N')) && ( ! (_ChkObl('TAGTIKFOAX',1)))) && FullRow()) {
_SignErr('TAGTIKFOAX');
m_cLastWorkVarErrorMsg='11706423273';
l_bResult=false;
w_NOAPPLIC=false;
} else if ((( ! (w_LOCKMIT) || w_write_layer) && ( ! (_ChkObl('ATCXZHNKXY',1)))) && FullRow()) {
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
l_bResult=l_bResult && ( ! (w_LOCKMIT));
if ( ! (l_bResult)) {
m_cLastMsgError=AlertErrorMessage('1096626323');
}
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
m_oFather.SetModified_aosdt_ind_def();
}
}
function SetChildVariables_aosdt_sub_ind_def() {
if ( ! (ChildToLoad(FrameRef('aosdt_sub_ind_def'))) && Ne(typeof(FrameRef('aosdt_sub_ind_def').DoUpdate),'undefined')) {
CopyWorkVar(FrameRef('aosdt_sub_ind_def'),['show_noapplic'],['show_noapplic'],false)
}
}
function CtxLoad_aosdt_sub_ind_def() {
if (ChildToLoad(FrameRef('aosdt_sub_ind_def'))) {
return [LoadContext(1,'FBWHLTIFYQ'),'aosdt_sub_ind_def'];
}
}
SaveContext.child=[{'prg':"aosdt_sub_ind_def",'BOScId':function(){return FrameRef('aosdt_sub_ind_def')}}];
function BlankRow() {
w_IDIND='';
w_PROGIND='';
w_DESCRI='';
w_LOCKMIT=false;
w_NOAPPLIC=false;
w_DESCRI_layer='';
w_open_layer=false;
w_write_layer=false;
w_IDIND=LibreriaMit.UniqueId();
w_NOAPPLIC=false;
w_DESCRI_layer=w_DESCRI;
w_open_layer=false;
w_write_layer=true;
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
l_aRepeatedFields.IDIND={"dec":0,"fixedpos":true,"id":"ATQBDCKYMD","len":10,"name":"IDIND","title":"ID del indicatore","type":"C"};
l_aRepeatedFields.PROGIND={"dec":0,"fixedpos":false,"id":"CFHSVGUQQV","len":10,"name":"PROGIND","title":"Progressivo indicatore","type":"C"};
l_aRepeatedFields.DESCRI={"dec":0,"fixedpos":false,"id":"NMPXBKDZYD","len":10,"name":"DESCRI","title":"Descrizione del indicatore","type":"M"};
l_aRepeatedFields.LOCKMIT={"dec":0,"fixedpos":false,"id":"QILTYWPQKG","len":1,"name":"LOCKMIT","title":"Indicatore standard Immodificabile","type":"L"};
l_aRepeatedFields.NOAPPLIC={"dec":0,"fixedpos":false,"id":"TAGTIKFOAX","len":1,"name":"NOAPPLIC","title":"Indicatore non applicabile","type":"L"};
l_aRepeatedFields.DESCRI_layer={"dec":0,"fixedpos":true,"id":"ATCXZHNKXY","len":10,"name":"DESCRI_layer","title":"Descrizione","type":"M"};
l_aRepeatedFields.open_layer={"dec":0,"fixedpos":true,"id":"MQLCSGEBDK","len":1,"name":"open_layer","title":"","type":"L"};
l_aRepeatedFields.write_layer={"dec":0,"fixedpos":true,"id":"KFVMWJOLOG","len":1,"name":"write_layer","title":"","type":"L"};
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
if(c=Ctrl('UUNKNVCACF')) SetDisabled(c,true);
if(c=Ctrl('QOEOGAAKRA')) SetDisabled(c,true);
if(c=Ctrl('ATQBDCKYMD')) SetDisabled(c,true);
if(c=Ctrl('ATCXZHNKXY')) SetDisabled(c,true);
if ( ! (ChildToLoad(FrameRef('aosdt_sub_ind_def'))) && Ne(typeof(FrameRef('aosdt_sub_ind_def').EnableEntity),'undefined')) {
FrameRef('aosdt_sub_ind_def').EnableEntity(true);
}
SetQueryRow(Ctrl('GridTable'),false);
} else {
SetEditRow(Ctrl('GridTable'),false);
var c;
if(c=Ctrl('UUNKNVCACF')) SetDisabled(c,false);
if(c=Ctrl('QOEOGAAKRA')) SetDisabled(c,false);
if(c=Ctrl('ATQBDCKYMD')) SetDisabled(c,false);
if(c=Ctrl('ATCXZHNKXY')) SetDisabled(c,false);
if ( ! (ChildToLoad(FrameRef('aosdt_sub_ind_def'))) && Ne(typeof(FrameRef('aosdt_sub_ind_def').EnableEntity),'undefined')) {
FrameRef('aosdt_sub_ind_def').EnableEntity(false);
}
EnableControlsUnderCondition(false);
}
m_bChildDisabled=enable;
}
