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
l_bEnabled= ! (Eq(w_TIPATT,'RIT')) || IsDisabledByStateDriver('BILLSRIT');
SetDisabled('AHEQBLEXHM',l_bEnabled);
l_bEnabled= ! (Eq(w_TIPATT,'SOV')) || IsDisabledByStateDriver('BILLSSOV');
SetDisabled('VHTWYZSCLL',l_bEnabled);
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
function Set_CODCOMCON(ctrlValue,kmode,e) {
if (Ne(w_CODCOMCON,ctrlValue)) {
var ctl = _GetCtl(e,'JCXOTDXIKP');
if (_tracker.goon(ctl,ctrlValue)) {
w_CODCOMCON=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('JCXOTDXIKP',0);
if (l_bResult) {
l_bResult=Link_JCXOTDXIKP(kmode);
if ( ! (l_bResult)) {
w_CODCOMCON=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',6,0,''));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',6,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_TIPATT(ctrlValue,kmode,e) {
if (Ne(w_TIPATT,ctrlValue)) {
var ctl = _GetCtl(e,'HOLHIEEXOR');
if (_tracker.goon(ctl,ctrlValue)) {
w_TIPATT=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HOLHIEEXOR',0);
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
function Set_TIPOATTIV(ctrlValue,kmode,e) {
if (Ne(w_TIPOATTIV,ctrlValue)) {
var ctl = _GetCtl(e,'RYMHYALKWD');
if (_tracker.goon(ctl,ctrlValue)) {
w_TIPOATTIV=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RYMHYALKWD',0);
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
function Set_CODICEGLN(ctrlValue,kmode,e) {
if (Ne(w_CODICEGLN,ctrlValue)) {
var ctl = _GetCtl(e,'YVJSXFLERW');
if (_tracker.goon(ctl,ctrlValue)) {
w_CODICEGLN=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YVJSXFLERW',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',13,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_CODCLICON(ctrlValue,kmode,e) {
if (Ne(w_CODCLICON,ctrlValue)) {
var ctl = _GetCtl(e,'CXLASTSRKJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_CODCLICON=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CXLASTSRKJ',0);
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
function Set_ATECO_CON(ctrlValue,kmode,e) {
if (Ne(w_ATECO_CON,ctrlValue)) {
var ctl = _GetCtl(e,'IACBXHVCCO');
if (_tracker.goon(ctl,ctrlValue)) {
w_ATECO_CON=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('IACBXHVCCO',0);
if (l_bResult) {
l_bResult=Link_IACBXHVCCO(kmode);
if ( ! (l_bResult)) {
w_ATECO_CON=HtW('','C');
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
function Set_ABIPROPR(ctrlValue,kmode,e) {
if (Ne(w_ABIPROPR,ctrlValue)) {
var ctl = _GetCtl(e,'GYFXWZOJEE');
if (_tracker.goon(ctl,ctrlValue)) {
w_ABIPROPR=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('GYFXWZOJEE',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',5,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_GLNALTROSOG(ctrlValue,kmode,e) {
if (Ne(w_GLNALTROSOG,ctrlValue)) {
var ctl = _GetCtl(e,'PJGQZBLXYX');
if (_tracker.goon(ctl,ctrlValue)) {
w_GLNALTROSOG=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('PJGQZBLXYX',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',13,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_NBANCONOTE(ctrlValue,kmode,e) {
if (Ne(w_NBANCONOTE,ctrlValue)) {
var ctl = _GetCtl(e,'JKWCLHNPVX');
if (_tracker.goon(ctl,ctrlValue)) {
w_NBANCONOTE=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('JKWCLHNPVX',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('JKWCLHNPVX',function(){return WtH(w_NBANCONOTE,'N',5,0,'99999')},w_NBANCONOTE);
return l_bResult;
} else {
ctl.value=WtH('','N',5,0,'99999');
_ResetTracker();
return true;
}
}
return true;
}
function Set_ABIINTER(ctrlValue,kmode,e) {
if (Ne(w_ABIINTER,ctrlValue)) {
var ctl = _GetCtl(e,'YXYPHIFKZT');
if (_tracker.goon(ctl,ctrlValue)) {
w_ABIINTER=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YXYPHIFKZT',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',5,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_GLNALTRASC(ctrlValue,kmode,e) {
if (Ne(w_GLNALTRASC,ctrlValue)) {
var ctl = _GetCtl(e,'JZUTNDTOOI');
if (_tracker.goon(ctl,ctrlValue)) {
w_GLNALTRASC=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('JZUTNDTOOI',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',13,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_BILLSRIT(ctrlValue,kmode,e) {
if (Ne(w_BILLSRIT,ctrlValue)) {
var ctl = _GetCtl(e,'AHEQBLEXHM');
if (_tracker.goon(ctl,ctrlValue)) {
w_BILLSRIT=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('AHEQBLEXHM',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('AHEQBLEXHM',function(){return WtH(w_BILLSRIT,'N',10,0,'9999999999')},w_BILLSRIT);
return l_bResult;
} else {
ctl.value=WtH('','N',10,0,'9999999999');
_ResetTracker();
return true;
}
}
return true;
}
function Set_TAGLIO(ctrlValue,kmode,e) {
if (Ne(w_TAGLIO,ctrlValue)) {
var ctl = _GetCtl(e,'AZPAGSINXQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_TAGLIO=ValidNum(ctrlValue,'9999.99');
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('AZPAGSINXQ',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('AZPAGSINXQ',function(){return WtH(w_TAGLIO,'N',7,2,'9999.99')},w_TAGLIO);
return l_bResult;
} else {
ctl.value=WtH('','N',7,2,'9999.99');
_ResetTracker();
return true;
}
}
return true;
}
function Set_BILLSSOV(ctrlValue,kmode,e) {
if (Ne(w_BILLSSOV,ctrlValue)) {
var ctl = _GetCtl(e,'VHTWYZSCLL');
if (_tracker.goon(ctl,ctrlValue)) {
w_BILLSSOV=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VHTWYZSCLL',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('VHTWYZSCLL',function(){return WtH(w_BILLSSOV,'N',10,0,'9999999999')},w_BILLSSOV);
return l_bResult;
} else {
ctl.value=WtH('','N',10,0,'9999999999');
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
function Link_IACBXHVCCO(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_ATECO_CON);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODICE',w_ATECO_CON,10,0);
l_Appl.SetFields('CODICE,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbtipatt');
l_Appl.SetID('IACBXHVCCO');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_ATECO_CON=l_Appl.GetStringValue('CODICE',10,0);
w_xDESATECO=l_Appl.GetStringValue('DESCRI',250,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_IACBXHVCCO_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_IACBXHVCCO';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_IACBXHVCCO();
l_oWv.setValue('FieldFilter',l_cFieldFilter);
if ( ! (Empty(l_Appl.GetWhereAddedFixedFiltersUnencoded()))) {
if ( ! (Empty(l_cFixedFilter))) {
l_cFixedFilter=l_cFixedFilter+' and ';
}
l_cFixedFilter=l_cFixedFilter+l_Appl.GetWhereAddedFixedFiltersUnencoded();
}
l_oWv.setValue('FixedFilter',l_cFixedFilter);
var initEntityFields = '';
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
function Link_IACBXHVCCO_Blank() {
w_ATECO_CON='';
w_xDESATECO='';
}
function LOpt_IACBXHVCCO() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbtipatt','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODICE','C'));
l_oWv.setValue('LinkedField',WtA('CODICE','C'));
l_oWv.setValue('UID',WtA('IACBXHVCCO','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['IACBXHVCCO'][1],'C'));
return l_oWv;
}
function Link_JCXOTDXIKP(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CODCOMCON);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('IDISTAT',w_CODCOMCON,6,0);
l_Appl.SetFields('IDISTAT,CITTA');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbcitta');
l_Appl.SetID('JCXOTDXIKP');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CODCOMCON=l_Appl.GetStringValue('IDISTAT',6,0);
w_xDESCITTA=l_Appl.GetStringValue('CITTA',60,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_JCXOTDXIKP_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_JCXOTDXIKP';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_JCXOTDXIKP();
l_oWv.setValue('FieldFilter',l_cFieldFilter);
if ( ! (Empty(l_Appl.GetWhereAddedFixedFiltersUnencoded()))) {
if ( ! (Empty(l_cFixedFilter))) {
l_cFixedFilter=l_cFixedFilter+' and ';
}
l_cFixedFilter=l_cFixedFilter+l_Appl.GetWhereAddedFixedFiltersUnencoded();
}
l_oWv.setValue('FixedFilter',l_cFixedFilter);
var initEntityFields = '';
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
function Link_JCXOTDXIKP_Blank() {
w_CODCOMCON='';
w_xDESCITTA='';
}
function LOpt_JCXOTDXIKP() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcitta','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('IDISTAT','C'));
l_oWv.setValue('LinkedField',WtA('IDISTAT','C'));
l_oWv.setValue('UID',WtA('JCXOTDXIKP','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['JCXOTDXIKP'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('15186643'),'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'IACBXHVCCO')) {
last_focused_comp=GetLastFocusedElementOfLink('IACBXHVCCO');
function SetMethod_IACBXHVCCO() {
Set_ATECO_CON(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_IACBXHVCCO();
} else {
setTimeout(SetMethod_IACBXHVCCO,1);
}
m_bHeaderUpdated=true;
bResult=true;
}
if (Eq(varName,'JCXOTDXIKP')) {
last_focused_comp=GetLastFocusedElementOfLink('JCXOTDXIKP');
function SetMethod_JCXOTDXIKP() {
Set_CODCOMCON(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_JCXOTDXIKP();
} else {
setTimeout(SetMethod_JCXOTDXIKP,1);
}
m_bHeaderUpdated=true;
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'IACBXHVCCO')) {
return [Ctrl('IACBXHVCCO')];
}
if (Eq(varName,'JCXOTDXIKP')) {
return [Ctrl('JCXOTDXIKP')];
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
if ( ! (m_oFather.SaveContext_ardt_frz_contante())) {
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
parent.ZtVWeb.raiseEventToEvalParms('ardt_frz_contante_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('ardt_frz_contante_dataNotSent',{'action':formaction});
}
}
}
}
}
CheckChild.child=[];
function Check() {
var l_bResult = true;
ResetErrorVars();
if ( ! (_ChkObl('HOLHIEEXOR',1))) {
_SignErr('HOLHIEEXOR');
m_cLastWorkVarErrorMsg='11155590227';
l_bResult=false;
w_TIPATT=HtW('','C');
} else if ( ! (_ChkObl('RYMHYALKWD',1))) {
_SignErr('RYMHYALKWD');
m_cLastWorkVarErrorMsg='11189144659';
l_bResult=false;
w_TIPOATTIV=HtW('','C');
} else if ( ! (_ChkObl('YVJSXFLERW',1))) {
_SignErr('YVJSXFLERW');
m_cLastWorkVarErrorMsg='11997494697';
l_bResult=false;
w_CODICEGLN=HtW('','C');
} else if ( ! (_ChkObl('CXLASTSRKJ',1))) {
_SignErr('CXLASTSRKJ');
m_cLastWorkVarErrorMsg='439997054';
l_bResult=false;
w_CODCLICON=HtW('','C');
} else if ( ! (_ChkObl('IACBXHVCCO',1))) {
_SignErr('IACBXHVCCO');
m_cLastWorkVarErrorMsg='1099659240';
l_bResult=false;
w_ATECO_CON=HtW('','C');
} else if ( ! (_ChkObl('JCXOTDXIKP',1))) {
_SignErr('JCXOTDXIKP');
m_cLastWorkVarErrorMsg='1867589130';
l_bResult=false;
w_CODCOMCON=HtW('','C');
} else if ( ! (_ChkObl('YXYPHIFKZT',1))) {
_SignErr('YXYPHIFKZT');
m_cLastWorkVarErrorMsg='10743769582';
l_bResult=false;
w_ABIINTER=HtW('','C');
} else if ( ! (_ChkObl('GYFXWZOJEE',1))) {
_SignErr('GYFXWZOJEE');
m_cLastWorkVarErrorMsg='10688195229';
l_bResult=false;
w_ABIPROPR=HtW('','C');
} else if ( ! (_ChkObl('PJGQZBLXYX',1))) {
_SignErr('PJGQZBLXYX');
m_cLastWorkVarErrorMsg='1189191642';
l_bResult=false;
w_GLNALTROSOG=HtW('','C');
} else if ( ! (_ChkObl('JZUTNDTOOI',1))) {
_SignErr('JZUTNDTOOI');
m_cLastWorkVarErrorMsg='11648440646';
l_bResult=false;
w_GLNALTRASC=HtW('','C');
} else if ((Eq(w_TIPATT,'RIT')) && ( ! (_ChkObl('AHEQBLEXHM',1)))) {
_SignErr('AHEQBLEXHM');
m_cLastWorkVarErrorMsg='1063292795';
l_bResult=false;
w_BILLSRIT=HtW('','N');
} else if ((Eq(w_TIPATT,'SOV')) && ( ! (_ChkObl('VHTWYZSCLL',1)))) {
_SignErr('VHTWYZSCLL');
m_cLastWorkVarErrorMsg='1876639681';
l_bResult=false;
w_BILLSSOV=HtW('','N');
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
l_oWv.setValue('IDOPE',WtA(w_IDOPE,'C'));
l_oWv.setValue('TIPATT',WtA(w_TIPATT,'C'));
l_oWv.setValue('TIPOATTIV',WtA(w_TIPOATTIV,'C'));
l_oWv.setValue('CODICEGLN',WtA(w_CODICEGLN,'C'));
l_oWv.setValue('CODCLICON',WtA(w_CODCLICON,'C'));
l_oWv.setValue('ATECO_CON',WtA(w_ATECO_CON,'C'));
l_oWv.setValue('CODCOMCON',WtA(w_CODCOMCON,'C'));
l_oWv.setValue('ABIINTER',WtA(w_ABIINTER,'C'));
l_oWv.setValue('ABIPROPR',WtA(w_ABIPROPR,'C'));
l_oWv.setValue('GLNALTROSOG',WtA(w_GLNALTROSOG,'C'));
l_oWv.setValue('GLNALTRASC',WtA(w_GLNALTRASC,'C'));
l_oWv.setValue('BILLSRIT',WtA(w_BILLSRIT,'N'));
l_oWv.setValue('BILLSSOV',WtA(w_BILLSSOV,'N'));
l_oWv.setValue('xDESATECO',WtA(w_xDESATECO,'C'));
l_oWv.setValue('xDESCITTA',WtA(w_xDESCITTA,'C'));
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
FillWv.n=["IDOPE","TIPATT","TIPOATTIV","CODICEGLN","CODCLICON","ATECO_CON","CODCOMCON","ABIINTER","ABIPROPR","GLNALTROSOG","GLNALTRASC","BILLSRIT","BILLSSOV","xDESATECO","xDESCITTA"];
function CheckRow(w) {
var l_bResult = true;
ResetErrorVars();
if (Le(m_nCurrentRow,Rows())) {
if (( ! (_ChkObl('AZPAGSINXQ',1))) && FullRow()) {
_SignErr('AZPAGSINXQ');
m_cLastWorkVarErrorMsg='10758806619';
l_bResult=false;
w_TAGLIO=HtW('','N');
} else if (( ! (_ChkObl('JKWCLHNPVX',1))) && FullRow()) {
_SignErr('JKWCLHNPVX');
m_cLastWorkVarErrorMsg='1514933900';
l_bResult=false;
w_NBANCONOTE=HtW('','N');
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
m_oFather.SetModified_ardt_frz_contante();
}
}
SaveContext.child=[];
function BlankRow() {
w_TAGLIO=0;
w_NBANCONOTE=0;
BlankRowChild();
if (m_bExtended) {
BlankRepeatedExtendedFields();
}
SaveDependsOn();
LoadContext(true);
}
function FullRow() {
return  ! (Empty(w_TAGLIO));
}
function GetRepeatedFields() {
var l_aRepeatedFields;
l_aRepeatedFields={};
l_aRepeatedFields.TAGLIO={"dec":2,"fixedpos":false,"id":"AZPAGSINXQ","len":7,"name":"TAGLIO","title":"Taglio Banconota","type":"N"};
l_aRepeatedFields.NBANCONOTE={"dec":0,"fixedpos":false,"id":"JKWCLHNPVX","len":5,"name":"NBANCONOTE","title":"N. Banconote","type":"N"};
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
if(c=Ctrl('HOLHIEEXOR')) SetDisabled(c,true);
if(c=Ctrl('RYMHYALKWD')) SetDisabled(c,true);
if(c=Ctrl('YVJSXFLERW')) SetDisabled(c,true);
if(c=Ctrl('CXLASTSRKJ')) SetDisabled(c,true);
if(c=Ctrl('IACBXHVCCO')) SetDisabled(c,true);
if(c=Ctrl('JCXOTDXIKP')) SetDisabled(c,true);
if(c=Ctrl('YXYPHIFKZT')) SetDisabled(c,true);
if(c=Ctrl('GYFXWZOJEE')) SetDisabled(c,true);
if(c=Ctrl('PJGQZBLXYX')) SetDisabled(c,true);
if(c=Ctrl('JZUTNDTOOI')) SetDisabled(c,true);
if(c=Ctrl('AHEQBLEXHM')) SetDisabled(c,true);
if(c=Ctrl('VHTWYZSCLL')) SetDisabled(c,true);
SetQueryRow(Ctrl('GridTable'),false);
} else {
SetEditRow(Ctrl('GridTable'),false);
var c;
if(c=Ctrl('HOLHIEEXOR')) SetDisabled(c,false);
if(c=Ctrl('RYMHYALKWD')) SetDisabled(c,false);
if(c=Ctrl('YVJSXFLERW')) SetDisabled(c,false);
if(c=Ctrl('CXLASTSRKJ')) SetDisabled(c,false);
if(c=Ctrl('IACBXHVCCO')) SetDisabled(c,false);
if(c=Ctrl('JCXOTDXIKP')) SetDisabled(c,false);
if(c=Ctrl('YXYPHIFKZT')) SetDisabled(c,false);
if(c=Ctrl('GYFXWZOJEE')) SetDisabled(c,false);
if(c=Ctrl('PJGQZBLXYX')) SetDisabled(c,false);
if(c=Ctrl('JZUTNDTOOI')) SetDisabled(c,false);
if(c=Ctrl('AHEQBLEXHM')) SetDisabled(c,false);
if(c=Ctrl('VHTWYZSCLL')) SetDisabled(c,false);
EnableControlsUnderCondition(false);
}
m_bChildDisabled=enable;
}
