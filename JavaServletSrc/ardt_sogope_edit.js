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
function Set_LEGAME(ctrlValue,kmode,e) {
if (Ne(w_LEGAME,ctrlValue)) {
var ctl = _GetCtl(e,'OSQIWZOZQN');
if (_tracker.goon(ctl,ctrlValue)) {
w_LEGAME=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('OSQIWZOZQN',0);
if (l_bResult) {
l_bResult=Link_OSQIWZOZQN(kmode);
if ( ! (l_bResult)) {
w_LEGAME=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',1,0,''));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_CODSOG(ctrlValue,kmode,e) {
if (Ne(w_CODSOG,ctrlValue)) {
var ctl = _GetCtl(e,'VFWKOPPXKC');
if (_tracker.goon(ctl,ctrlValue)) {
w_CODSOG=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VFWKOPPXKC',0);
if (l_bResult) {
l_bResult=Link_VFWKOPPXKC(kmode);
if ( ! (l_bResult)) {
w_CODSOG=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',16,0,''));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',16,0,'');
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
function Link_VFWKOPPXKC(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CODSOG);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CONNES',w_CODSOG,16,0);
l_Appl.SetFields('CONNES,RAGSOC');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('personbo');
l_Appl.SetID('VFWKOPPXKC');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CODSOG=l_Appl.GetStringValue('CONNES',16,0);
w_xragsoc=l_Appl.GetStringValue('RAGSOC',70,0);
l_Appl.GetLinkHash(GetRepeatedCheckVars());
} else {
Link_VFWKOPPXKC_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_VFWKOPPXKC';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_VFWKOPPXKC();
l_oWv.setValue('FieldFilter',l_cFieldFilter);
if ( ! (Empty(l_Appl.GetWhereAddedFixedFiltersUnencoded()))) {
if ( ! (Empty(l_cFixedFilter))) {
l_cFixedFilter=l_cFixedFilter+' and ';
}
l_cFixedFilter=l_cFixedFilter+l_Appl.GetWhereAddedFixedFiltersUnencoded();
}
l_oWv.setValue('FixedFilter',l_cFixedFilter);
var initEntityFields = '';
l_cLinkUrl='../servlet/SPVisualZoom'+'?m_cWv='+URLenc(l_oWv.asString());
layerOpenForeground(l_cLinkUrl,openername,'toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes');
m_nLastError=-2;
} else {
if ( ! (l_bResult)) {
m_nLastError=3;
m_cLastWorkVarErrorMsg='';
if (Lt(l_nRec,0)) {
m_cLastMsgError=Translate('MSG_CONNECT_SERVER');
}
}
}
return l_bResult;
}
function Link_VFWKOPPXKC_Blank() {
w_CODSOG='';
w_xragsoc='';
}
function LOpt_VFWKOPPXKC() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('personbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CONNES','C'));
l_oWv.setValue('LinkedField',WtA('CONNES','C'));
l_oWv.setValue('UID',WtA('VFWKOPPXKC','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['VFWKOPPXKC'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('195812931'),'C'));
return l_oWv;
}
function Link_OSQIWZOZQN(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_LEGAME);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('TIPLEG',w_LEGAME,1,0);
l_Appl.SetFields('TIPLEG,DESCRIZ');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbtipleg');
l_Appl.SetID('OSQIWZOZQN');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_LEGAME=l_Appl.GetStringValue('TIPLEG',1,0);
w_xdescriz=l_Appl.GetStringValue('DESCRIZ',50,0);
l_Appl.GetLinkHash(GetRepeatedCheckVars());
} else {
Link_OSQIWZOZQN_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_OSQIWZOZQN';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_OSQIWZOZQN();
l_oWv.setValue('FieldFilter',l_cFieldFilter);
if ( ! (Empty(l_Appl.GetWhereAddedFixedFiltersUnencoded()))) {
if ( ! (Empty(l_cFixedFilter))) {
l_cFixedFilter=l_cFixedFilter+' and ';
}
l_cFixedFilter=l_cFixedFilter+l_Appl.GetWhereAddedFixedFiltersUnencoded();
}
l_oWv.setValue('FixedFilter',l_cFixedFilter);
var initEntityFields = '';
l_cLinkUrl='../servlet/SPVisualZoom'+'?m_cWv='+URLenc(l_oWv.asString());
layerOpenForeground(l_cLinkUrl,openername,'toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes');
m_nLastError=-2;
} else {
if ( ! (l_bResult)) {
m_nLastError=3;
m_cLastWorkVarErrorMsg='';
if (Lt(l_nRec,0)) {
m_cLastMsgError=Translate('MSG_CONNECT_SERVER');
}
}
}
return l_bResult;
}
function Link_OSQIWZOZQN_Blank() {
w_LEGAME='';
w_xdescriz='';
}
function LOpt_OSQIWZOZQN() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbtipleg','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('TIPLEG','C'));
l_oWv.setValue('LinkedField',WtA('TIPLEG','C'));
l_oWv.setValue('UID',WtA('OSQIWZOZQN','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['OSQIWZOZQN'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('10639118571'),'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'VFWKOPPXKC')) {
last_focused_comp=GetLastFocusedElementOfLink('VFWKOPPXKC');
function SetMethod_VFWKOPPXKC() {
Set_CODSOG(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_VFWKOPPXKC();
} else {
setTimeout(SetMethod_VFWKOPPXKC,1);
}
bResult=true;
}
if (Eq(varName,'OSQIWZOZQN')) {
last_focused_comp=GetLastFocusedElementOfLink('OSQIWZOZQN');
function SetMethod_OSQIWZOZQN() {
Set_LEGAME(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_OSQIWZOZQN();
} else {
setTimeout(SetMethod_OSQIWZOZQN,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'VFWKOPPXKC')) {
return [Ctrl('VFWKOPPXKC')];
}
if (Eq(varName,'OSQIWZOZQN')) {
return [Ctrl('OSQIWZOZQN')];
}
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
if ( ! (m_oFather.SaveContext_ardt_sogope())) {
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
parent.ZtVWeb.raiseEventToEvalParms('ardt_sogope_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('ardt_sogope_dataNotSent',{'action':formaction});
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
if (Eq('VFWKOPPXKC_ZOOM',lc)) {
return 0;
}
if (Eq('VFWKOPPXKC',lc)) {
return 0;
}
if (Eq('OSQIWZOZQN_ZOOM',lc)) {
return 1;
}
if (Eq('OSQIWZOZQN',lc)) {
return 1;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_VFWKOPPXKC();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,1)) {
l_oWv=LOpt_OSQIWZOZQN();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
}
function FillWv() {
var l_oWv = InitWvApplet();
l_oWv.setValue('m_CheckVars',JSON.stringify(m_CheckVars));
l_oWv.setValue('IDFILEBO',WtA(w_IDFILEBO,'C'));
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
FillWv.n=["IDFILEBO"];
function CheckRow(w) {
var l_bResult = true;
ResetErrorVars();
if (Le(m_nCurrentRow,Rows())) {
if (( ! (_ChkObl('VFWKOPPXKC',1))) && FullRow()) {
_SignErr('VFWKOPPXKC');
m_cLastWorkVarErrorMsg='10847988462';
l_bResult=false;
w_CODSOG=HtW('','C');
} else if (( ! (_ChkObl('OSQIWZOZQN',1))) && FullRow()) {
_SignErr('OSQIWZOZQN');
m_cLastWorkVarErrorMsg='10639118571';
l_bResult=false;
w_LEGAME=HtW('','C');
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
m_oFather.SetModified_ardt_sogope();
}
}
SaveContext.child=[];
function BlankRow() {
w_CODSOG='';
w_LEGAME='';
w_xragsoc='';
w_xdescriz='';
if ( ! (EmptyString(w_CODSOG))) {
Link_VFWKOPPXKC(null);
}
if ( ! (EmptyString(w_LEGAME))) {
Link_OSQIWZOZQN(null);
}
BlankRowChild();
if (m_bExtended) {
BlankRepeatedExtendedFields();
}
SaveDependsOn();
LoadContext(true);
}
function FullRow() {
return  ! (Empty(w_CODSOG));
}
function GetRepeatedFields() {
var l_aRepeatedFields;
l_aRepeatedFields={};
l_aRepeatedFields.CODSOG={"dec":0,"fixedpos":false,"id":"VFWKOPPXKC","len":16,"name":"CODSOG","title":"Codice Soggetto","type":"C"};
l_aRepeatedFields.LEGAME={"dec":0,"fixedpos":false,"id":"OSQIWZOZQN","len":1,"name":"LEGAME","title":"Tipo Legame","type":"C"};
l_aRepeatedFields.xragsoc={"dec":0,"fixedpos":false,"id":"SPPGKRITOT","len":70,"name":"xragsoc","title":"Ragione Sociale","type":"C"};
l_aRepeatedFields.xdescriz={"dec":0,"fixedpos":true,"id":"SERHLOYRYY","len":50,"name":"xdescriz","title":"Descrizione","type":"C"};
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
