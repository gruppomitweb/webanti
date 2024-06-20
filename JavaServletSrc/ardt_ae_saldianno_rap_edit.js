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
SetErrorField('AXNGRMGWKA',false);
SetErrorField('IHYVMMXNYB',false);
SetErrorField('FOMIWSJIXX',false);
SetErrorField('BTCAUOXWJV',false);
SetErrorField('JNHTVKJIVX',false);
SetErrorField('WGRHFFESJM',false);
SetErrorField('GIHQXNRYNI',false);
}
function Set_IMPORTO3(ctrlValue,kmode,e) {
if (Ne(w_IMPORTO3,ctrlValue)) {
var ctl = _GetCtl(e,'FOMIWSJIXX');
if (_tracker.goon(ctl,ctrlValue)) {
w_IMPORTO3=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FOMIWSJIXX',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('FOMIWSJIXX',function(){return WtH(w_IMPORTO3,'N',17,0,'99,999,999,999,999,999')},w_IMPORTO3);
return l_bResult;
} else {
ctl.value=WtH('','N',17,0,'99999999999999999');
_ResetTracker();
return true;
}
} else {
SPBOUILib.SetInputValue('FOMIWSJIXX',function(){return WtH(w_IMPORTO3,'N',17,0,'99,999,999,999,999,999')},w_IMPORTO3);
}
return true;
}
function Set_TIPRAP(ctrlValue,kmode,e) {
if (Ne(w_TIPRAP,ctrlValue)) {
var ctl = _GetCtl(e,'FMWOOHLKTT');
if (_tracker.goon(ctl,ctrlValue)) {
w_TIPRAP=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FMWOOHLKTT',0);
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
function Set_ANNO(ctrlValue,kmode,e) {
if (Ne(w_ANNO,ctrlValue)) {
var ctl = _GetCtl(e,'GTDLGPZWRR');
if (_tracker.goon(ctl,ctrlValue)) {
w_ANNO=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('GTDLGPZWRR',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('GTDLGPZWRR',function(){return WtH(w_ANNO,'N',4,0,'9999')},w_ANNO);
return l_bResult;
} else {
ctl.value=WtH('','N',4,0,'9999');
_ResetTracker();
return true;
}
}
return true;
}
function Set_IMPORTO4(ctrlValue,kmode,e) {
if (Ne(w_IMPORTO4,ctrlValue)) {
var ctl = _GetCtl(e,'BTCAUOXWJV');
if (_tracker.goon(ctl,ctrlValue)) {
w_IMPORTO4=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BTCAUOXWJV',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('BTCAUOXWJV',function(){return WtH(w_IMPORTO4,'N',17,0,'99,999,999,999,999,999')},w_IMPORTO4);
return l_bResult;
} else {
ctl.value=WtH('','N',17,0,'99999999999999999');
_ResetTracker();
return true;
}
} else {
SPBOUILib.SetInputValue('BTCAUOXWJV',function(){return WtH(w_IMPORTO4,'N',17,0,'99,999,999,999,999,999')},w_IMPORTO4);
}
return true;
}
function Set_IMPORTO1(ctrlValue,kmode,e) {
if (Ne(w_IMPORTO1,ctrlValue)) {
var ctl = _GetCtl(e,'AXNGRMGWKA');
if (_tracker.goon(ctl,ctrlValue)) {
w_IMPORTO1=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('AXNGRMGWKA',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('AXNGRMGWKA',function(){return WtH(w_IMPORTO1,'N',17,0,'99,999,999,999,999,999')},w_IMPORTO1);
return l_bResult;
} else {
ctl.value=WtH('','N',17,0,'99999999999999999');
_ResetTracker();
return true;
}
} else {
SPBOUILib.SetInputValue('AXNGRMGWKA',function(){return WtH(w_IMPORTO1,'N',17,0,'99,999,999,999,999,999')},w_IMPORTO1);
}
return true;
}
function Set_IMPORTO2(ctrlValue,kmode,e) {
if (Ne(w_IMPORTO2,ctrlValue)) {
var ctl = _GetCtl(e,'IHYVMMXNYB');
if (_tracker.goon(ctl,ctrlValue)) {
w_IMPORTO2=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('IHYVMMXNYB',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('IHYVMMXNYB',function(){return WtH(w_IMPORTO2,'N',17,0,'99,999,999,999,999,999')},w_IMPORTO2);
return l_bResult;
} else {
ctl.value=WtH('','N',17,0,'99999999999999999');
_ResetTracker();
return true;
}
} else {
SPBOUILib.SetInputValue('IHYVMMXNYB',function(){return WtH(w_IMPORTO2,'N',17,0,'99,999,999,999,999,999')},w_IMPORTO2);
}
return true;
}
function Set_IMPORTO5(ctrlValue,kmode,e) {
if (Ne(w_IMPORTO5,ctrlValue)) {
var ctl = _GetCtl(e,'JNHTVKJIVX');
if (_tracker.goon(ctl,ctrlValue)) {
w_IMPORTO5=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('JNHTVKJIVX',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('JNHTVKJIVX',function(){return WtH(w_IMPORTO5,'N',6,0,'999,999')},w_IMPORTO5);
return l_bResult;
} else {
ctl.value=WtH('','N',6,0,'999999');
_ResetTracker();
return true;
}
} else {
SPBOUILib.SetInputValue('JNHTVKJIVX',function(){return WtH(w_IMPORTO5,'N',6,0,'999,999')},w_IMPORTO5);
}
return true;
}
function Set_NATURA(ctrlValue,kmode,e) {
if (Ne(w_NATURA,ctrlValue)) {
var ctl = _GetCtl(e,'GIHQXNRYNI');
if (_tracker.goon(ctl,ctrlValue)) {
w_NATURA=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('GIHQXNRYNI',0);
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
function Set_IMPORTO6(ctrlValue,kmode,e) {
if (Ne(w_IMPORTO6,ctrlValue)) {
var ctl = _GetCtl(e,'WGRHFFESJM');
if (_tracker.goon(ctl,ctrlValue)) {
w_IMPORTO6=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('WGRHFFESJM',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('WGRHFFESJM',function(){return WtH(w_IMPORTO6,'N',17,0,'99,999,999,999,999,999')},w_IMPORTO6);
return l_bResult;
} else {
ctl.value=WtH('','N',17,0,'99999999999999999');
_ResetTracker();
return true;
}
} else {
SPBOUILib.SetInputValue('WGRHFFESJM',function(){return WtH(w_IMPORTO6,'N',17,0,'99,999,999,999,999,999')},w_IMPORTO6);
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
if ( ! (m_oFather.SaveContext_ardt_ae_saldianno_rap())) {
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
parent.ZtVWeb.raiseEventToEvalParms('ardt_ae_saldianno_rap_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('ardt_ae_saldianno_rap_dataNotSent',{'action':formaction});
}
}
}
}
}
CheckChild.child=[];
function Check() {
var l_bResult = true;
ResetErrorVars();
if ( ! (_ChkObl('FMWOOHLKTT',1))) {
_SignErr('FMWOOHLKTT');
m_cLastWorkVarErrorMsg='1723736132';
l_bResult=false;
w_TIPRAP=HtW('','C');
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
l_oWv.setValue('RAPPORTO',WtA(w_RAPPORTO,'C'));
l_oWv.setValue('TIPRAP',WtA(w_TIPRAP,'C'));
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
FillWv.n=["RAPPORTO","TIPRAP"];
function CheckRow(w) {
var l_bResult = true;
ResetErrorVars();
if (Le(m_nCurrentRow,Rows())) {
if (( ! (_ChkObl('GTDLGPZWRR',1))) && FullRow()) {
_SignErr('GTDLGPZWRR');
m_cLastWorkVarErrorMsg='965977510';
l_bResult=false;
w_ANNO=HtW('','N');
} else if (( ! (_ChkObl('AXNGRMGWKA',1))) && FullRow()) {
_SignErr('AXNGRMGWKA');
m_cLastWorkVarErrorMsg='1991862090';
l_bResult=false;
w_IMPORTO1=HtW('','N');
} else if (( ! (_ChkObl('IHYVMMXNYB',1))) && FullRow()) {
_SignErr('IHYVMMXNYB');
m_cLastWorkVarErrorMsg='1991862091';
l_bResult=false;
w_IMPORTO2=HtW('','N');
} else if (( ! (_ChkObl('FOMIWSJIXX',1))) && FullRow()) {
_SignErr('FOMIWSJIXX');
m_cLastWorkVarErrorMsg='1991862092';
l_bResult=false;
w_IMPORTO3=HtW('','N');
} else if (( ! (_ChkObl('BTCAUOXWJV',1))) && FullRow()) {
_SignErr('BTCAUOXWJV');
m_cLastWorkVarErrorMsg='1991862093';
l_bResult=false;
w_IMPORTO4=HtW('','N');
} else if (( ! (_ChkObl('JNHTVKJIVX',1))) && FullRow()) {
_SignErr('JNHTVKJIVX');
m_cLastWorkVarErrorMsg='1991862094';
l_bResult=false;
w_IMPORTO5=HtW('','N');
} else if (( ! (_ChkObl('WGRHFFESJM',1))) && FullRow()) {
_SignErr('WGRHFFESJM');
m_cLastWorkVarErrorMsg='11748287033';
l_bResult=false;
w_IMPORTO6=HtW('','N');
} else if (( ! (_ChkObl('GIHQXNRYNI',1))) && FullRow()) {
_SignErr('GIHQXNRYNI');
m_cLastWorkVarErrorMsg='12030926209';
l_bResult=false;
w_NATURA=HtW('','C');
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
m_oFather.SetModified_ardt_ae_saldianno_rap();
}
}
SaveContext.child=[];
function BlankRow() {
w_ANNO=0;
w_IDBASE='';
w_IMPORTO1=0;
w_IMPORTO2=0;
w_IMPORTO3=0;
w_IMPORTO4=0;
w_IMPORTO5=0;
w_FILEANNO='';
w_PROG1='';
w_IMPORTO6=0;
w_NATURA='';
BlankRowChild();
if (m_bExtended) {
BlankRepeatedExtendedFields();
}
SaveDependsOn();
LoadContext(true);
}
function FullRow() {
return  ! (Empty(w_ANNO));
}
function GetRepeatedFields() {
var l_aRepeatedFields;
l_aRepeatedFields={};
l_aRepeatedFields.ANNO={"dec":0,"fixedpos":false,"id":"GTDLGPZWRR","len":4,"name":"ANNO","title":"Anno Riferimento","type":"N"};
l_aRepeatedFields.IDBASE={"dec":0,"fixedpos":true,"id":"JHWLAPLUKL","len":10,"name":"IDBASE","title":"Chiave Univoca Riga","type":"C"};
l_aRepeatedFields.IMPORTO1={"dec":0,"fixedpos":true,"id":"AXNGRMGWKA","len":17,"name":"IMPORTO1","title":"Importo 1","type":"N"};
l_aRepeatedFields.IMPORTO2={"dec":0,"fixedpos":true,"id":"IHYVMMXNYB","len":17,"name":"IMPORTO2","title":"Importo 2","type":"N"};
l_aRepeatedFields.IMPORTO3={"dec":0,"fixedpos":true,"id":"FOMIWSJIXX","len":17,"name":"IMPORTO3","title":"Importo 3","type":"N"};
l_aRepeatedFields.IMPORTO4={"dec":0,"fixedpos":true,"id":"BTCAUOXWJV","len":17,"name":"IMPORTO4","title":"Importo 4","type":"N"};
l_aRepeatedFields.IMPORTO5={"dec":0,"fixedpos":true,"id":"JNHTVKJIVX","len":6,"name":"IMPORTO5","title":"Importo 5","type":"N"};
l_aRepeatedFields.FILEANNO={"dec":0,"fixedpos":false,"id":"DDMKMEQQED","len":50,"name":"FILEANNO","title":"Nome File","type":"C"};
l_aRepeatedFields.PROG1={"dec":0,"fixedpos":false,"id":"BHMBCJGALB","len":10,"name":"PROG1","title":"Area 1","type":"C"};
l_aRepeatedFields.IMPORTO6={"dec":0,"fixedpos":true,"id":"WGRHFFESJM","len":17,"name":"IMPORTO6","title":"Giacenza Media","type":"N"};
l_aRepeatedFields.NATURA={"dec":0,"fixedpos":true,"id":"GIHQXNRYNI","len":2,"name":"NATURA","title":"Natura Valuta","type":"C"};
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
if(c=Ctrl('FMWOOHLKTT')) SetDisabled(c,true);
if(c=Ctrl('AXNGRMGWKA')) SetDisabled(c,true);
if(c=Ctrl('IHYVMMXNYB')) SetDisabled(c,true);
if(c=Ctrl('FOMIWSJIXX')) SetDisabled(c,true);
if(c=Ctrl('BTCAUOXWJV')) SetDisabled(c,true);
if(c=Ctrl('JNHTVKJIVX')) SetDisabled(c,true);
if(c=Ctrl('WGRHFFESJM')) SetDisabled(c,true);
if(c=Ctrl('GIHQXNRYNI')) SetDisabled(c,true);
SetQueryRow(Ctrl('GridTable'),false);
} else {
SetEditRow(Ctrl('GridTable'),false);
var c;
if(c=Ctrl('FMWOOHLKTT')) SetDisabled(c,false);
if(c=Ctrl('AXNGRMGWKA')) SetDisabled(c,false);
if(c=Ctrl('IHYVMMXNYB')) SetDisabled(c,false);
if(c=Ctrl('FOMIWSJIXX')) SetDisabled(c,false);
if(c=Ctrl('BTCAUOXWJV')) SetDisabled(c,false);
if(c=Ctrl('JNHTVKJIVX')) SetDisabled(c,false);
if(c=Ctrl('WGRHFFESJM')) SetDisabled(c,false);
if(c=Ctrl('GIHQXNRYNI')) SetDisabled(c,false);
EnableControlsUnderCondition(false);
}
m_bChildDisabled=enable;
}
