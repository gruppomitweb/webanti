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
function Set_RISCHIO(ctrlValue,kmode,e) {
if (Ne(w_RISCHIO,ctrlValue)) {
var ctl = _GetCtl(e,'KDPPHIXGCO');
if (_tracker.goon(ctl,ctrlValue)) {
w_RISCHIO=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('KDPPHIXGCO',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('KDPPHIXGCO',function(){return WtH(w_RISCHIO,'N',3,0,'999')},w_RISCHIO);
return l_bResult;
} else {
ctl.value=WtH('','N',3,0,'999');
_ResetTracker();
return true;
}
}
return true;
}
function Set_CODICE(ctrlValue,kmode,e) {
if (Ne(w_CODICE,ctrlValue)) {
var ctl = _GetCtl(e,'MDAZAECEFB');
if (_tracker.goon(ctl,ctrlValue)) {
w_CODICE=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MDAZAECEFB',0);
if (l_bResult) {
l_bResult=Link_MDAZAECEFB(kmode);
if ( ! (l_bResult)) {
w_CODICE=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',10,0,''));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',10,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_IMPEFF(ctrlValue,kmode,e) {
if (Ne(w_IMPEFF,ctrlValue)) {
var ctl = _GetCtl(e,'BQZNEAYMQQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_IMPEFF=ValidNum(ctrlValue,'999999999999.99');
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BQZNEAYMQQ',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('BQZNEAYMQQ',function(){return WtH(w_IMPEFF,'N',19,2,'999,999,999,999.99')},w_IMPEFF);
return l_bResult;
} else {
ctl.value=WtH('','N',19,2,'999999999999.99');
_ResetTracker();
return true;
}
} else {
SPBOUILib.SetInputValue('BQZNEAYMQQ',function(){return WtH(w_IMPEFF,'N',19,2,'999,999,999,999.99')},w_IMPEFF);
}
return true;
}
function Set_ANNO(ctrlValue,kmode,e) {
if (Ne(w_ANNO,ctrlValue)) {
var ctl = _GetCtl(e,'EQFEXBKZWY');
if (_tracker.goon(ctl,ctrlValue)) {
w_ANNO=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('EQFEXBKZWY',0);
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
function Calculation_JPLJTSXCMQ() {
w_IDBASE=LibreriaMit.UniqueId();
}
function SaveDependsOn() {
}
function SaveLabelDependsOn() {
}
function Link_MDAZAECEFB(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CODICE);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODICE',w_CODICE,10,0);
l_Appl.SetFields('CODICE,DESCRI,RISCHIO');
l_Appl.SetTypes('C,C,N');
l_Appl.LinkTable('tbfascepr');
l_Appl.SetID('MDAZAECEFB');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CODICE=l_Appl.GetStringValue('CODICE',10,0);
w_xDESCRI=l_Appl.GetStringValue('DESCRI',150,0);
w_RISCHIO=l_Appl.GetDoubleValue('RISCHIO',3,0);
l_Appl.GetLinkHash(GetRepeatedCheckVars());
} else {
Link_MDAZAECEFB_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_MDAZAECEFB';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
l_cFieldFilter=l_cFieldFilter+l_cAndOpForField+_flt_('TIPO',1,null,true,'=');
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_MDAZAECEFB();
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
function Link_MDAZAECEFB_Blank() {
w_CODICE='';
w_xDESCRI='';
w_RISCHIO=0;
}
function LOpt_MDAZAECEFB() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbfascepr','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODICE','C'));
l_oWv.setValue('LinkedField',WtA('CODICE','C'));
l_oWv.setValue('UID',WtA('MDAZAECEFB','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['MDAZAECEFB'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('1747491214'),'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'MDAZAECEFB')) {
last_focused_comp=GetLastFocusedElementOfLink('MDAZAECEFB');
function SetMethod_MDAZAECEFB() {
Set_CODICE(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_MDAZAECEFB();
} else {
setTimeout(SetMethod_MDAZAECEFB,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'MDAZAECEFB')) {
return [Ctrl('MDAZAECEFB')];
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
if ( ! (m_oFather.SaveContext_ardt_patrimonio())) {
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
parent.ZtVWeb.raiseEventToEvalParms('ardt_patrimonio_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('ardt_patrimonio_dataNotSent',{'action':formaction});
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
if (Eq('MDAZAECEFB_ZOOM',lc)) {
return 0;
}
if (Eq('MDAZAECEFB',lc)) {
return 0;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_MDAZAECEFB();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
l_cFieldFilter=l_cFieldFilter+l_cAndOpForField+_flt_('TIPO',1,null,true,'=');
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
l_oWv.setValue('FieldFilter',l_cFieldFilter);
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
}
function FillWv() {
var l_oWv = InitWvApplet();
l_oWv.setValue('m_CheckVars',JSON.stringify(m_CheckVars));
l_oWv.setValue('CONNES',WtA(w_CONNES,'C'));
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
FillWv.n=["CONNES"];
function CheckRow(w) {
var l_bResult = true;
ResetErrorVars();
if (Le(m_nCurrentRow,Rows())) {
if (( ! (_ChkObl('MDAZAECEFB',1))) && FullRow()) {
_SignErr('MDAZAECEFB');
m_cLastWorkVarErrorMsg='112851763';
l_bResult=false;
w_CODICE=HtW('','C');
} else if (( ! (_ChkObl('BQZNEAYMQQ',1))) && FullRow()) {
_SignErr('BQZNEAYMQQ');
m_cLastWorkVarErrorMsg='1991862041';
l_bResult=false;
w_IMPEFF=HtW('','N');
} else if (( ! (_ChkObl('KDPPHIXGCO',1))) && FullRow()) {
_SignErr('KDPPHIXGCO');
m_cLastWorkVarErrorMsg='1979623906';
l_bResult=false;
w_RISCHIO=HtW('','N');
} else if (( ! (_ChkObl('EQFEXBKZWY',1))) && FullRow()) {
_SignErr('EQFEXBKZWY');
m_cLastWorkVarErrorMsg='965977510';
l_bResult=false;
w_ANNO=HtW('','N');
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
m_oFather.SetModified_ardt_patrimonio();
}
}
SaveContext.child=[];
function BlankRow() {
w_CODICE='';
w_IMPEFF=0;
w_RISCHIO=0;
w_ANNO=0;
w_xDESCRI='';
w_IDBASE='';
if ( ! (EmptyString(w_CODICE))) {
Link_MDAZAECEFB(null);
}
BlankRowChild();
if (m_bExtended) {
BlankRepeatedExtendedFields();
}
SaveDependsOn();
LoadContext(true);
}
function FullRow() {
return  ! (Empty(w_CODICE));
}
function GetRepeatedFields() {
var l_aRepeatedFields;
l_aRepeatedFields={};
l_aRepeatedFields.CODICE={"dec":0,"fixedpos":false,"id":"MDAZAECEFB","len":10,"name":"CODICE","title":"Codice","type":"C"};
l_aRepeatedFields.IMPEFF={"dec":2,"fixedpos":false,"id":"BQZNEAYMQQ","len":19,"name":"IMPEFF","title":"Importo","type":"N"};
l_aRepeatedFields.RISCHIO={"dec":0,"fixedpos":false,"id":"KDPPHIXGCO","len":3,"name":"RISCHIO","title":"Rischio","type":"N"};
l_aRepeatedFields.ANNO={"dec":0,"fixedpos":false,"id":"EQFEXBKZWY","len":4,"name":"ANNO","title":"Anno Riferimento","type":"N"};
l_aRepeatedFields.IDBASE={"dec":0,"fixedpos":true,"id":"OCVJDUSSKV","len":10,"name":"IDBASE","title":"IDBase","type":"C"};
l_aRepeatedFields.xDESCRI={"dec":0,"fixedpos":false,"id":"XIPADAGXBM","len":150,"name":"xDESCRI","title":"Descrizione","type":"C"};
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
