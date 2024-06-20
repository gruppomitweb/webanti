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
SetErrorField('NLQNUCEFAF',false);
SetErrorField('ZWNTMRMLZT',false);
SetErrorField('IWFQNNZEIO',false);
SetErrorField('DPXJJYNKQD',false);
SetErrorField('TFTPGRBHXL',false);
SetErrorField('XWVSEMUYKF',false);
SetErrorField('TNGAQJNMOX',false);
SetErrorField('OVPWCHXBKI',false);
SetErrorField('FVRVSFXLIG',false);
SetErrorField('BZUPXAPSJB',false);
}
function Set_AUTRILASC(ctrlValue,kmode,e) {
if (Ne(w_AUTRILASC,ctrlValue)) {
var ctl = _GetCtl(e,'DPXJJYNKQD');
if (_tracker.goon(ctl,ctrlValue)) {
w_AUTRILASC=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('DPXJJYNKQD',0);
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
function Set_CONNESCLI(ctrlValue,kmode,e) {
if (Ne(w_CONNESCLI,ctrlValue)) {
var ctl = _GetCtl(e,'XCOFZIDOBL');
if (_tracker.goon(ctl,ctrlValue)) {
w_CONNESCLI=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XCOFZIDOBL',0);
if (l_bResult) {
l_bResult=Link_XCOFZIDOBL(kmode);
if ( ! (l_bResult)) {
w_CONNESCLI=HtW('','C');
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
function Set_TIPODOC(ctrlValue,kmode,e) {
if (Ne(w_TIPODOC,ctrlValue)) {
var ctl = _GetCtl(e,'NLQNUCEFAF');
if (_tracker.goon(ctl,ctrlValue)) {
w_TIPODOC=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NLQNUCEFAF',0);
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
function Set_NUMDOCUM(ctrlValue,kmode,e) {
if (Ne(w_NUMDOCUM,ctrlValue)) {
var ctl = _GetCtl(e,'ZWNTMRMLZT');
if (_tracker.goon(ctl,ctrlValue)) {
w_NUMDOCUM=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ZWNTMRMLZT',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',15,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_DATARILASC(ctrlValue,kmode,e) {
if (Ne(w_DATARILASC,ctrlValue)) {
var ctl = _GetCtl(e,'IWFQNNZEIO');
if (_tracker.goon(ctl,ctrlValue)) {
w_DATARILASC=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('IWFQNNZEIO',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH(NullDate(),'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
_ResetTracker();
return true;
}
}
return true;
}
function Set_DOMICILIO(ctrlValue,kmode,e) {
if (Ne(w_DOMICILIO,ctrlValue)) {
var ctl = _GetCtl(e,'XWVSEMUYKF');
if (_tracker.goon(ctl,ctrlValue)) {
w_DOMICILIO=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XWVSEMUYKF',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',35,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_PAESE(ctrlValue,kmode,e) {
if (Ne(w_PAESE,ctrlValue)) {
var ctl = _GetCtl(e,'BZUPXAPSJB');
if (_tracker.goon(ctl,ctrlValue)) {
w_PAESE=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BZUPXAPSJB',0);
if (l_bResult) {
l_bResult=Link_BZUPXAPSJB(kmode);
if ( ! (l_bResult)) {
w_PAESE=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',3,0,''));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',3,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_DATAVALI(ctrlValue,kmode,e) {
if (Ne(w_DATAVALI,ctrlValue)) {
var ctl = _GetCtl(e,'TFTPGRBHXL');
if (_tracker.goon(ctl,ctrlValue)) {
w_DATAVALI=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('TFTPGRBHXL',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH(NullDate(),'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
_ResetTracker();
return true;
}
}
return true;
}
function Set_DESCCIT(ctrlValue,kmode,e) {
if (Ne(w_DESCCIT,ctrlValue)) {
var ctl = _GetCtl(e,'TNGAQJNMOX');
if (_tracker.goon(ctl,ctrlValue)) {
w_DESCCIT=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('TNGAQJNMOX',0);
if (l_bResult) {
l_bResult=Link_TNGAQJNMOX(kmode);
if ( ! (l_bResult)) {
w_DESCCIT=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',30,0,''));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',30,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_PROVINCIA(ctrlValue,kmode,e) {
if (Ne(w_PROVINCIA,ctrlValue)) {
var ctl = _GetCtl(e,'OVPWCHXBKI');
if (_tracker.goon(ctl,ctrlValue)) {
w_PROVINCIA=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('OVPWCHXBKI',0);
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
function Set_CAP(ctrlValue,kmode,e) {
if (Ne(w_CAP,ctrlValue)) {
var ctl = _GetCtl(e,'FVRVSFXLIG');
if (_tracker.goon(ctl,ctrlValue)) {
w_CAP=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FVRVSFXLIG',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',9,0,'');
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
function Link_XCOFZIDOBL(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CONNESCLI);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CONNES',w_CONNESCLI,16,0);
l_Appl.SetFields('CONNES,RAGSOC');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('personbo');
l_Appl.SetID('XCOFZIDOBL');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CONNESCLI=l_Appl.GetStringValue('CONNES',16,0);
w_xRagSocDoc=l_Appl.GetStringValue('RAGSOC',70,0);
l_Appl.GetLinkHash(GetRepeatedCheckVars());
} else {
Link_XCOFZIDOBL_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_XCOFZIDOBL';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_XCOFZIDOBL();
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
function Link_XCOFZIDOBL_Blank() {
w_CONNESCLI='';
w_xRagSocDoc='';
}
function LOpt_XCOFZIDOBL() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('personbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CONNES','C'));
l_oWv.setValue('LinkedField',WtA('CONNES','C'));
l_oWv.setValue('UID',WtA('XCOFZIDOBL','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['XCOFZIDOBL'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('195812931'),'C'));
return l_oWv;
}
function Link_TNGAQJNMOX(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_DESCCIT);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CITTA',w_DESCCIT,30,0);
l_Appl.SetFields('CITTA,PROV,CAP,PKTBSTATI');
l_Appl.SetTypes('C,C,C,C');
l_Appl.LinkTable('tbcitta');
l_Appl.SetID('TNGAQJNMOX');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_DESCCIT=l_Appl.GetStringValue('CITTA',30,0);
w_PROVINCIA=l_Appl.GetStringValue('PROV',2,0);
w_CAP=l_Appl.GetStringValue('CAP',9,0);
w_PAESE=l_Appl.GetStringValue('PKTBSTATI',3,0);
l_Appl.GetLinkHash(GetRepeatedCheckVars());
} else {
Link_TNGAQJNMOX_Blank();
l_bResult=true;
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_TNGAQJNMOX';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_TNGAQJNMOX();
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
function Link_TNGAQJNMOX_Blank() {
w_PROVINCIA='';
w_CAP='';
w_PAESE='';
}
function LOpt_TNGAQJNMOX() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcitta','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CITTA','C'));
l_oWv.setValue('LinkedField',WtA('CITTA','C'));
l_oWv.setValue('UID',WtA('TNGAQJNMOX','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['TNGAQJNMOX'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('11217542473'),'C'));
return l_oWv;
}
function Link_BZUPXAPSJB(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_PAESE);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODSTA',w_PAESE,3,0);
l_Appl.SetFields('CODSTA,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbstati');
l_Appl.SetID('BZUPXAPSJB');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_PAESE=l_Appl.GetStringValue('CODSTA',3,0);
w_dessta=l_Appl.GetStringValue('DESCRI',40,0);
l_Appl.GetLinkHash(GetRepeatedCheckVars());
} else {
Link_BZUPXAPSJB_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_BZUPXAPSJB';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_BZUPXAPSJB();
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
function Link_BZUPXAPSJB_Blank() {
w_PAESE='';
w_dessta='';
}
function LOpt_BZUPXAPSJB() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstati','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODSTA','C'));
l_oWv.setValue('LinkedField',WtA('CODSTA','C'));
l_oWv.setValue('UID',WtA('BZUPXAPSJB','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['BZUPXAPSJB'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('7383187'),'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'XCOFZIDOBL')) {
last_focused_comp=GetLastFocusedElementOfLink('XCOFZIDOBL');
function SetMethod_XCOFZIDOBL() {
Set_CONNESCLI(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_XCOFZIDOBL();
} else {
setTimeout(SetMethod_XCOFZIDOBL,1);
}
bResult=true;
}
if (Eq(varName,'TNGAQJNMOX')) {
last_focused_comp=GetLastFocusedElementOfLink('TNGAQJNMOX');
function SetMethod_TNGAQJNMOX() {
Set_DESCCIT(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_TNGAQJNMOX();
} else {
setTimeout(SetMethod_TNGAQJNMOX,1);
}
bResult=true;
}
if (Eq(varName,'BZUPXAPSJB')) {
last_focused_comp=GetLastFocusedElementOfLink('BZUPXAPSJB');
function SetMethod_BZUPXAPSJB() {
Set_PAESE(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_BZUPXAPSJB();
} else {
setTimeout(SetMethod_BZUPXAPSJB,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'XCOFZIDOBL')) {
return [Ctrl('XCOFZIDOBL')];
}
if (Eq(varName,'TNGAQJNMOX')) {
return [Ctrl('TNGAQJNMOX')];
}
if (Eq(varName,'BZUPXAPSJB')) {
return [Ctrl('BZUPXAPSJB')];
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
if ( ! (m_oFather.SaveContext_ardt_xocopebo())) {
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
parent.ZtVWeb.raiseEventToEvalParms('ardt_xocopebo_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('ardt_xocopebo_dataNotSent',{'action':formaction});
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
if (Eq('XCOFZIDOBL_ZOOM',lc)) {
return 0;
}
if (Eq('XCOFZIDOBL',lc)) {
return 0;
}
if (Eq('TNGAQJNMOX_ZOOM',lc)) {
return 1;
}
if (Eq('TNGAQJNMOX',lc)) {
return 1;
}
if (Eq('BZUPXAPSJB_ZOOM',lc)) {
return 2;
}
if (Eq('BZUPXAPSJB',lc)) {
return 2;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_XCOFZIDOBL();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,1)) {
l_oWv=LOpt_TNGAQJNMOX();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,2)) {
l_oWv=LOpt_BZUPXAPSJB();
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
l_oWv.setValue('NUMPROG',WtA(w_NUMPROG,'C'));
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
FillWv.n=["NUMPROG"];
function CheckRow(w) {
var l_bResult = true;
ResetErrorVars();
if (Le(m_nCurrentRow,Rows())) {
if (( ! (_ChkObl('XCOFZIDOBL',1))) && FullRow()) {
_SignErr('XCOFZIDOBL');
m_cLastWorkVarErrorMsg='10534477837';
l_bResult=false;
w_CONNESCLI=HtW('','C');
} else if (( ! (_ChkObl('NLQNUCEFAF',1))) && FullRow()) {
_SignErr('NLQNUCEFAF');
m_cLastWorkVarErrorMsg='11429032151';
l_bResult=false;
w_TIPODOC=HtW('','C');
} else if (( ! (_ChkObl('ZWNTMRMLZT',1))) && FullRow()) {
_SignErr('ZWNTMRMLZT');
m_cLastWorkVarErrorMsg='1734932797';
l_bResult=false;
w_NUMDOCUM=HtW('','C');
} else if (( ! (_ChkObl('IWFQNNZEIO',1))) && FullRow()) {
_SignErr('IWFQNNZEIO');
m_cLastWorkVarErrorMsg='1690077224';
l_bResult=false;
w_DATARILASC=HtW('','D');
} else if (( ! (_ChkObl('DPXJJYNKQD',1))) && FullRow()) {
_SignErr('DPXJJYNKQD');
m_cLastWorkVarErrorMsg='10032163180';
l_bResult=false;
w_AUTRILASC=HtW('','C');
} else if (( ! (_ChkObl('TFTPGRBHXL',1))) && FullRow()) {
_SignErr('TFTPGRBHXL');
m_cLastWorkVarErrorMsg='1216938285';
l_bResult=false;
w_DATAVALI=HtW('','D');
} else if (( ! (_ChkObl('XWVSEMUYKF',1))) && FullRow()) {
_SignErr('XWVSEMUYKF');
m_cLastWorkVarErrorMsg='554236824';
l_bResult=false;
w_DOMICILIO=HtW('','C');
} else if (( ! (_ChkObl('TNGAQJNMOX',1))) && FullRow()) {
_SignErr('TNGAQJNMOX');
m_cLastWorkVarErrorMsg='15186643';
l_bResult=false;
w_DESCCIT=HtW('','C');
} else if (( ! (_ChkObl('OVPWCHXBKI',1))) && FullRow()) {
_SignErr('OVPWCHXBKI');
m_cLastWorkVarErrorMsg='10095365423';
l_bResult=false;
w_PROVINCIA=HtW('','C');
} else if (( ! (_ChkObl('FVRVSFXLIG',1))) && FullRow()) {
_SignErr('FVRVSFXLIG');
m_cLastWorkVarErrorMsg='21587';
l_bResult=false;
w_CAP=HtW('','C');
} else if (( ! (_ChkObl('BZUPXAPSJB',1))) && FullRow()) {
_SignErr('BZUPXAPSJB');
m_cLastWorkVarErrorMsg='7776403';
l_bResult=false;
w_PAESE=HtW('','C');
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
m_oFather.SetModified_ardt_xocopebo();
}
}
SaveContext.child=[];
function BlankRow() {
w_CONNESCLI='';
w_TIPODOC='';
w_NUMDOCUM='';
w_DATARILASC=NullDate();
w_AUTRILASC='';
w_xRagSocDoc='';
w_DATAVALI=NullDate();
w_DOMICILIO='';
w_DESCCIT='';
w_PROVINCIA='';
w_CAP='';
w_PAESE='';
w_dessta='';
if ( ! (EmptyString(w_CONNESCLI))) {
Link_XCOFZIDOBL(null);
}
if ( ! (EmptyString(w_DESCCIT))) {
Link_TNGAQJNMOX(null);
}
if ( ! (EmptyString(w_PAESE))) {
Link_BZUPXAPSJB(null);
}
BlankRowChild();
if (m_bExtended) {
BlankRepeatedExtendedFields();
}
SaveDependsOn();
LoadContext(true);
}
function FullRow() {
return  ! (Empty(w_CONNESCLI));
}
function GetRepeatedFields() {
var l_aRepeatedFields;
l_aRepeatedFields={};
l_aRepeatedFields.CONNESCLI={"dec":0,"fixedpos":false,"id":"XCOFZIDOBL","len":16,"name":"CONNESCLI","title":"Codice Operatore","type":"C"};
l_aRepeatedFields.TIPODOC={"dec":0,"fixedpos":true,"id":"NLQNUCEFAF","len":2,"name":"TIPODOC","title":"Tipo Documento","type":"C"};
l_aRepeatedFields.NUMDOCUM={"dec":0,"fixedpos":true,"id":"ZWNTMRMLZT","len":15,"name":"NUMDOCUM","title":"Numero Doc.","type":"C"};
l_aRepeatedFields.DATARILASC={"dec":0,"fixedpos":true,"id":"IWFQNNZEIO","len":8,"name":"DATARILASC","title":"Data Rilascio Doc.","type":"D"};
l_aRepeatedFields.AUTRILASC={"dec":0,"fixedpos":true,"id":"DPXJJYNKQD","len":30,"name":"AUTRILASC","title":"Autorit\u00E0 di rilascio","type":"C"};
l_aRepeatedFields.DATAVALI={"dec":0,"fixedpos":true,"id":"TFTPGRBHXL","len":8,"name":"DATAVALI","title":"Data Fine Validit\u00E0","type":"D"};
l_aRepeatedFields.DOMICILIO={"dec":0,"fixedpos":true,"id":"XWVSEMUYKF","len":35,"name":"DOMICILIO","title":"Indirizzo","type":"C"};
l_aRepeatedFields.DESCCIT={"dec":0,"fixedpos":true,"id":"TNGAQJNMOX","len":30,"name":"DESCCIT","title":"Citt\u00E0","type":"C"};
l_aRepeatedFields.PROVINCIA={"dec":0,"fixedpos":true,"id":"OVPWCHXBKI","len":2,"name":"PROVINCIA","title":"Provincia","type":"C"};
l_aRepeatedFields.CAP={"dec":0,"fixedpos":true,"id":"FVRVSFXLIG","len":9,"name":"CAP","title":"CAP","type":"C"};
l_aRepeatedFields.PAESE={"dec":0,"fixedpos":true,"id":"BZUPXAPSJB","len":3,"name":"PAESE","title":"Stato","type":"C"};
l_aRepeatedFields.xRagSocDoc={"dec":0,"fixedpos":false,"id":"RNNLFXBYNE","len":70,"name":"xRagSocDoc","title":"Ragione Sociale","type":"C"};
l_aRepeatedFields.dessta={"dec":0,"fixedpos":false,"id":"MKDWHCGQWE","len":40,"name":"dessta","title":"Descrizione","type":"C"};
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
if(c=Ctrl('NLQNUCEFAF')) SetDisabled(c,true);
if(c=Ctrl('ZWNTMRMLZT')) SetDisabled(c,true);
if(c=Ctrl('IWFQNNZEIO')) SetDisabled(c,true);
if(c=Ctrl('DPXJJYNKQD')) SetDisabled(c,true);
if(c=Ctrl('TFTPGRBHXL')) SetDisabled(c,true);
if(c=Ctrl('XWVSEMUYKF')) SetDisabled(c,true);
if(c=Ctrl('TNGAQJNMOX')) SetDisabled(c,true);
if(c=Ctrl('TNGAQJNMOX_ZOOM')) SetDisabled(c,true);
if(c=Ctrl('OVPWCHXBKI')) SetDisabled(c,true);
if(c=Ctrl('FVRVSFXLIG')) SetDisabled(c,true);
if(c=Ctrl('BZUPXAPSJB')) SetDisabled(c,true);
if(c=Ctrl('BZUPXAPSJB_ZOOM')) SetDisabled(c,true);
SetQueryRow(Ctrl('GridTable'),false);
} else {
SetEditRow(Ctrl('GridTable'),false);
var c;
if(c=Ctrl('NLQNUCEFAF')) SetDisabled(c,false);
if(c=Ctrl('ZWNTMRMLZT')) SetDisabled(c,false);
if(c=Ctrl('IWFQNNZEIO')) SetDisabled(c,false);
if(c=Ctrl('DPXJJYNKQD')) SetDisabled(c,false);
if(c=Ctrl('TFTPGRBHXL')) SetDisabled(c,false);
if(c=Ctrl('XWVSEMUYKF')) SetDisabled(c,false);
if(c=Ctrl('TNGAQJNMOX')) SetDisabled(c,false);
if(c=Ctrl('TNGAQJNMOX_ZOOM')) SetDisabled(c,false);
if(c=Ctrl('OVPWCHXBKI')) SetDisabled(c,false);
if(c=Ctrl('FVRVSFXLIG')) SetDisabled(c,false);
if(c=Ctrl('BZUPXAPSJB')) SetDisabled(c,false);
if(c=Ctrl('BZUPXAPSJB_ZOOM')) SetDisabled(c,false);
EnableControlsUnderCondition(false);
}
m_bChildDisabled=enable;
}
