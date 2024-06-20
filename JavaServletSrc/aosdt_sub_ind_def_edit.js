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
l_bEnabled= ! (false) || Eq(m_cFunction,'edit') || IsDisabledByStateDriver('IDMOD');
SetDisabled('ZZCYHWIBYI',l_bEnabled);
l_bEnabled= ! (false) || Eq(m_cFunction,'edit') || IsDisabledByStateDriver('IDIND');
SetDisabled('VCVGRLKIYI',l_bEnabled);
l_bEnabled= ! (false) || IsDisabledByStateDriver('IDSUBIND');
SetDisabled('KQDZVNZECK',l_bEnabled);
l_bEnabled= ! ( ! (w_LOCKMIT)) || IsDisabledByStateDriver('PROGSUBIND');
SetDisabled('MXXMCLALYG',l_bEnabled);
l_bEnabled= ! (false) || IsDisabledByStateDriver('DESCRI');
SetDisabled('NGUCJOKSKM',l_bEnabled);
l_bEnabled= ! (false) || IsDisabledByStateDriver('LOCKMIT');
SetDisabled('OIJUVIXRQN',l_bEnabled);
l_bEnabled= ! (Eq(EntityStatus(),'N')) || IsDisabledByStateDriver('NOAPPLIC');
SetDisabled('ACJAWRNAVO',l_bEnabled);
l_bEnabled= ! ( ! (w_LOCKMIT) || w_write_layer) || IsDisabledByStateDriver('DESCRI_layer');
SetDisabled('ATCXZHNKXY',l_bEnabled);
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
SetErrorField('KQDZVNZECK',false);
SetErrorField('ATCXZHNKXY',false);
}
function Set_IDMOD(ctrlValue,kmode,e) {
if (Ne(w_IDMOD,ctrlValue)) {
var ctl = _GetCtl(e,'ZZCYHWIBYI');
if (_tracker.goon(ctl,ctrlValue)) {
w_IDMOD=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ZZCYHWIBYI',0);
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
var ctl = _GetCtl(e,'VCVGRLKIYI');
if (_tracker.goon(ctl,ctrlValue)) {
w_IDIND=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VCVGRLKIYI',0);
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
var ctl = _GetCtl(e,'KSVRAIFHEU');
if (_tracker.goon(ctl,ctrlValue)) {
w_show_noapplic=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('KSVRAIFHEU',0);
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
function Set_IDSUBIND(ctrlValue,kmode,e) {
if (Ne(w_IDSUBIND,ctrlValue)) {
var ctl = _GetCtl(e,'KQDZVNZECK');
if (_tracker.goon(ctl,ctrlValue)) {
w_IDSUBIND=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('KQDZVNZECK',0);
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
function Set_PROGSUBIND(ctrlValue,kmode,e) {
if (Ne(w_PROGSUBIND,ctrlValue)) {
var ctl = _GetCtl(e,'MXXMCLALYG');
if (_tracker.goon(ctl,ctrlValue)) {
w_PROGSUBIND=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MXXMCLALYG',0);
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
var ctl = _GetCtl(e,'NGUCJOKSKM');
if (_tracker.goon(ctl,ctrlValue)) {
w_DESCRI=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NGUCJOKSKM',0);
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
function Set_PESO(ctrlValue,kmode,e) {
if (Ne(w_PESO,ctrlValue)) {
var ctl = _GetCtl(e,'YPEGROOCHF');
if (_tracker.goon(ctl,ctrlValue)) {
w_PESO=ValidNum(ctrlValue,'999,999,999,999.99');
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YPEGROOCHF',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('YPEGROOCHF',function(){return WtH(w_PESO,'N',15,2,'999,999,999,999.99')},w_PESO);
return l_bResult;
} else {
ctl.value=WtH('','N',15,2,'999,999,999,999.99');
_ResetTracker();
return true;
}
}
return true;
}
function Set_INDRISCH(ctrlValue,kmode,e) {
if (Ne(w_INDRISCH,ctrlValue)) {
var ctl = _GetCtl(e,'VDSUAVUBNI');
if (_tracker.goon(ctl,ctrlValue)) {
w_INDRISCH=ValidNum(ctrlValue,'999.99');
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VDSUAVUBNI',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('VDSUAVUBNI',function(){return WtH(w_INDRISCH,'N',6,2,'999.99')},w_INDRISCH);
return l_bResult;
} else {
ctl.value=WtH('','N',6,2,'999.99');
_ResetTracker();
return true;
}
}
return true;
}
function Set_LOCKMIT(ctrlValue,kmode,e) {
if (Ne(w_LOCKMIT,ctrlValue)) {
var ctl = _GetCtl(e,'OIJUVIXRQN');
if (_tracker.goon(ctl,ctrlValue)) {
w_LOCKMIT=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('OIJUVIXRQN',0);
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
var ctl = _GetCtl(e,'ACJAWRNAVO');
if (_tracker.goon(ctl,ctrlValue)) {
w_NOAPPLIC=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ACJAWRNAVO',0);
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
if ( ! (m_oFather.SaveContext_aosdt_sub_ind_def())) {
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
parent.ZtVWeb.raiseEventToEvalParms('aosdt_sub_ind_def_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('aosdt_sub_ind_def_dataNotSent',{'action':formaction});
}
}
}
}
}
CheckChild.child=[];
function Check() {
var l_bResult = true;
ResetErrorVars();
if ((false) && ( ! (_ChkObl('ZZCYHWIBYI',1)))) {
_SignErr('ZZCYHWIBYI');
m_cLastWorkVarErrorMsg='10024211400';
l_bResult=false;
w_IDMOD=HtW('','C');
} else if ((false) && ( ! (_ChkObl('VCVGRLKIYI',1)))) {
_SignErr('VCVGRLKIYI');
m_cLastWorkVarErrorMsg='1305674908';
l_bResult=false;
w_IDIND=HtW('','C');
} else if ( ! (_ChkObl('KSVRAIFHEU',1))) {
_SignErr('KSVRAIFHEU');
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
l_oWv.setValue('IDIND',WtA(w_IDIND,'C'));
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
FillWv.n=["IDMOD","IDIND","show_noapplic"];
function CheckRow(w) {
var l_bResult = true;
ResetErrorVars();
if (Le(m_nCurrentRow,Rows())) {
if (((false) && ( ! (_ChkObl('KQDZVNZECK',1)))) && FullRow()) {
_SignErr('KQDZVNZECK');
m_cLastWorkVarErrorMsg='10785547902';
l_bResult=false;
w_IDSUBIND=HtW('','C');
} else if ((( ! (w_LOCKMIT)) && ( ! (_ChkObl('MXXMCLALYG',1)))) && FullRow()) {
_SignErr('MXXMCLALYG');
m_cLastWorkVarErrorMsg='976616780';
l_bResult=false;
w_PROGSUBIND=HtW('','C');
} else if (((false) && ( ! (_ChkObl('NGUCJOKSKM',1)))) && FullRow()) {
_SignErr('NGUCJOKSKM');
m_cLastWorkVarErrorMsg='601925191';
l_bResult=false;
w_DESCRI=HtW('','M');
} else if (( ! (_ChkObl('YPEGROOCHF',1))) && FullRow()) {
_SignErr('YPEGROOCHF');
m_cLastWorkVarErrorMsg='485792';
l_bResult=false;
w_PESO=HtW('','N');
} else if (( ! (_ChkObl('VDSUAVUBNI',1))) && FullRow()) {
_SignErr('VDSUAVUBNI');
m_cLastWorkVarErrorMsg='1701052417';
l_bResult=false;
w_INDRISCH=HtW('','N');
} else if (((false) && ( ! (_ChkObl('OIJUVIXRQN',1)))) && FullRow()) {
_SignErr('OIJUVIXRQN');
m_cLastWorkVarErrorMsg='11407848125';
l_bResult=false;
w_LOCKMIT=false;
} else if (((Eq(EntityStatus(),'N')) && ( ! (_ChkObl('ACJAWRNAVO',1)))) && FullRow()) {
_SignErr('ACJAWRNAVO');
m_cLastWorkVarErrorMsg='11597693133';
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
ResetErrorVars();
l_bResult=l_bResult && ( ! (w_LOCKMIT));
if ( ! (l_bResult)) {
m_cLastMsgError=AlertErrorMessage('1597949641');
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
m_oFather.SetModified_aosdt_sub_ind_def();
}
}
SaveContext.child=[];
function BlankRow() {
w_IDSUBIND='';
w_PROGSUBIND='';
w_DESCRI='';
w_PESO=0;
w_INDRISCH=0;
w_LOCKMIT=false;
w_NOAPPLIC=false;
w_DESCRI_layer='';
w_open_layer=false;
w_write_layer=false;
w_IDSUBIND=LibreriaMit.UniqueId();
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
return  ! (Empty(w_IDSUBIND));
}
function GetRepeatedFields() {
var l_aRepeatedFields;
l_aRepeatedFields={};
l_aRepeatedFields.IDSUBIND={"dec":0,"fixedpos":true,"id":"KQDZVNZECK","len":10,"name":"IDSUBIND","title":"ID del subindicatore","type":"C"};
l_aRepeatedFields.PROGSUBIND={"dec":0,"fixedpos":false,"id":"MXXMCLALYG","len":10,"name":"PROGSUBIND","title":"Progressivo subindicatore","type":"C"};
l_aRepeatedFields.DESCRI={"dec":0,"fixedpos":false,"id":"NGUCJOKSKM","len":10,"name":"DESCRI","title":"Descrizione del subindicatore","type":"M"};
l_aRepeatedFields.PESO={"dec":2,"fixedpos":false,"id":"YPEGROOCHF","len":15,"name":"PESO","title":"Peso","type":"N"};
l_aRepeatedFields.INDRISCH={"dec":2,"fixedpos":false,"id":"VDSUAVUBNI","len":6,"name":"INDRISCH","title":"Indice di rischio","type":"N"};
l_aRepeatedFields.LOCKMIT={"dec":0,"fixedpos":false,"id":"OIJUVIXRQN","len":1,"name":"LOCKMIT","title":"Subindicatore standard Immodificabile","type":"L"};
l_aRepeatedFields.NOAPPLIC={"dec":0,"fixedpos":false,"id":"ACJAWRNAVO","len":1,"name":"NOAPPLIC","title":"Subindicatore non applicabile","type":"L"};
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
if(c=Ctrl('ZZCYHWIBYI')) SetDisabled(c,true);
if(c=Ctrl('VCVGRLKIYI')) SetDisabled(c,true);
if(c=Ctrl('KSVRAIFHEU')) SetDisabled(c,true);
if(c=Ctrl('KQDZVNZECK')) SetDisabled(c,true);
if(c=Ctrl('ATCXZHNKXY')) SetDisabled(c,true);
SetQueryRow(Ctrl('GridTable'),false);
} else {
SetEditRow(Ctrl('GridTable'),false);
var c;
if(c=Ctrl('ZZCYHWIBYI')) SetDisabled(c,false);
if(c=Ctrl('VCVGRLKIYI')) SetDisabled(c,false);
if(c=Ctrl('KSVRAIFHEU')) SetDisabled(c,false);
if(c=Ctrl('KQDZVNZECK')) SetDisabled(c,false);
if(c=Ctrl('ATCXZHNKXY')) SetDisabled(c,false);
EnableControlsUnderCondition(false);
}
m_bChildDisabled=enable;
}
