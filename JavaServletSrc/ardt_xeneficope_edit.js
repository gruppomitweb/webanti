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
if (IsDisabledByStateDriver('box_VRCVINYRJO')) {
DisableInputsInContainer(Ctrl('VRCVINYRJO'),true);
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
SetErrorField('JEGIRRECDX',false);
SetErrorField('VFKBUBHCEY',false);
SetErrorField('KMXMWIBKDJ',false);
SetErrorField('OFRQGKEFMW',false);
SetErrorField('KVYEJVZPZF',false);
SetErrorField('MBGCZJULKH',false);
}
function Set_C_CAB(ctrlValue,kmode,e) {
if (Ne(w_C_CAB,ctrlValue)) {
var ctl = _GetCtl(e,'VFKBUBHCEY');
if (_tracker.goon(ctl,ctrlValue)) {
w_C_CAB=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VFKBUBHCEY',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',6,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_CODSOG(ctrlValue,kmode,e) {
if (Ne(w_CODSOG,ctrlValue)) {
var ctl = _GetCtl(e,'TMTNRFTARW');
if (_tracker.goon(ctl,ctrlValue)) {
w_CODSOG=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('TMTNRFTARW',0);
if (l_bResult) {
l_bResult=Link_TMTNRFTARW(kmode);
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
function Set_C_PRV(ctrlValue,kmode,e) {
if (Ne(w_C_PRV,ctrlValue)) {
var ctl = _GetCtl(e,'KMXMWIBKDJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_C_PRV=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('KMXMWIBKDJ',0);
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
function Set_C_RAG(ctrlValue,kmode,e) {
if (Ne(w_C_RAG,ctrlValue)) {
var ctl = _GetCtl(e,'GAEWMPRBSY');
if (_tracker.goon(ctl,ctrlValue)) {
w_C_RAG=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('GAEWMPRBSY',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',70,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_C_CTA(ctrlValue,kmode,e) {
if (Ne(w_C_CTA,ctrlValue)) {
var ctl = _GetCtl(e,'JEGIRRECDX');
if (_tracker.goon(ctl,ctrlValue)) {
w_C_CTA=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('JEGIRRECDX',0);
if (l_bResult) {
l_bResult=Link_JEGIRRECDX(kmode);
if ( ! (l_bResult)) {
w_C_CTA=HtW('','C');
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
function Set_C_IND(ctrlValue,kmode,e) {
if (Ne(w_C_IND,ctrlValue)) {
var ctl = _GetCtl(e,'OFRQGKEFMW');
if (_tracker.goon(ctl,ctrlValue)) {
w_C_IND=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('OFRQGKEFMW',0);
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
function Set_C_STA(ctrlValue,kmode,e) {
if (Ne(w_C_STA,ctrlValue)) {
var ctl = _GetCtl(e,'KVYEJVZPZF');
if (_tracker.goon(ctl,ctrlValue)) {
w_C_STA=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('KVYEJVZPZF',0);
if (l_bResult) {
l_bResult=Link_KVYEJVZPZF(kmode);
if ( ! (l_bResult)) {
w_C_STA=HtW('','C');
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
function Set_C_CAP(ctrlValue,kmode,e) {
if (Ne(w_C_CAP,ctrlValue)) {
var ctl = _GetCtl(e,'MBGCZJULKH');
if (_tracker.goon(ctl,ctrlValue)) {
w_C_CAP=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MBGCZJULKH',0);
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
function Link_TMTNRFTARW(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CODSOG);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CONNES',w_CODSOG,16,0);
l_Appl.SetFields('CONNES,RAGSOC,DOMICILIO,DESCCIT,PROVINCIA,CAP');
l_Appl.SetTypes('C,C,C,C,C,C');
l_Appl.LinkTable('personbo');
l_Appl.SetID('TMTNRFTARW');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CODSOG=l_Appl.GetStringValue('CONNES',16,0);
w_C_RAG=l_Appl.GetStringValue('RAGSOC',70,0);
w_C_IND=l_Appl.GetStringValue('DOMICILIO',35,0);
w_C_CTA=l_Appl.GetStringValue('DESCCIT',30,0);
w_C_PRV=l_Appl.GetStringValue('PROVINCIA',2,0);
w_C_CAP=l_Appl.GetStringValue('CAP',5,0);
l_Appl.GetLinkHash(GetRepeatedCheckVars());
} else {
Link_TMTNRFTARW_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_TMTNRFTARW';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_TMTNRFTARW();
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
function Link_TMTNRFTARW_Blank() {
w_CODSOG='';
w_C_RAG='';
w_C_IND='';
w_C_CTA='';
w_C_PRV='';
w_C_CAP='';
}
function LOpt_TMTNRFTARW() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('personbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CONNES','C'));
l_oWv.setValue('LinkedField',WtA('CONNES','C'));
l_oWv.setValue('UID',WtA('TMTNRFTARW','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['TMTNRFTARW'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('195812931'),'C'));
return l_oWv;
}
function Link_JEGIRRECDX(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_C_CTA);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CITTA',w_C_CTA,30,0);
l_Appl.SetFields('CITTA,CAB,CAP,PROV,PKTBSTATI');
l_Appl.SetTypes('C,C,C,C,C');
l_Appl.LinkTable('tbcitta');
l_Appl.SetID('JEGIRRECDX');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_C_CTA=l_Appl.GetStringValue('CITTA',30,0);
w_C_CAB=l_Appl.GetStringValue('CAB',6,0);
w_C_CAP=l_Appl.GetStringValue('CAP',5,0);
w_C_PRV=l_Appl.GetStringValue('PROV',2,0);
w_C_STA=l_Appl.GetStringValue('PKTBSTATI',3,0);
l_Appl.GetLinkHash(GetRepeatedCheckVars());
} else {
Link_JEGIRRECDX_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_JEGIRRECDX';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_JEGIRRECDX();
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
function Link_JEGIRRECDX_Blank() {
w_C_CTA='';
w_C_CAB='';
w_C_CAP='';
w_C_PRV='';
w_C_STA='';
}
function LOpt_JEGIRRECDX() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcitta','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CITTA','C'));
l_oWv.setValue('LinkedField',WtA('CITTA','C'));
l_oWv.setValue('UID',WtA('JEGIRRECDX','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['JEGIRRECDX'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('15186643'),'C'));
return l_oWv;
}
function Link_KVYEJVZPZF(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_C_STA);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODSTA',w_C_STA,3,0);
l_Appl.SetFields('CODSTA,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbstati');
l_Appl.SetID('KVYEJVZPZF');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_C_STA=l_Appl.GetStringValue('CODSTA',3,0);
w_xdessta=l_Appl.GetStringValue('DESCRI',40,0);
l_Appl.GetLinkHash(GetRepeatedCheckVars());
} else {
Link_KVYEJVZPZF_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_KVYEJVZPZF';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_KVYEJVZPZF();
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
function Link_KVYEJVZPZF_Blank() {
w_C_STA='';
w_xdessta='';
}
function LOpt_KVYEJVZPZF() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstati','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODSTA','C'));
l_oWv.setValue('LinkedField',WtA('CODSTA','C'));
l_oWv.setValue('UID',WtA('KVYEJVZPZF','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['KVYEJVZPZF'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('7383187'),'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'TMTNRFTARW')) {
last_focused_comp=GetLastFocusedElementOfLink('TMTNRFTARW');
function SetMethod_TMTNRFTARW() {
Set_CODSOG(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_TMTNRFTARW();
} else {
setTimeout(SetMethod_TMTNRFTARW,1);
}
bResult=true;
}
if (Eq(varName,'JEGIRRECDX')) {
last_focused_comp=GetLastFocusedElementOfLink('JEGIRRECDX');
function SetMethod_JEGIRRECDX() {
Set_C_CTA(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_JEGIRRECDX();
} else {
setTimeout(SetMethod_JEGIRRECDX,1);
}
bResult=true;
}
if (Eq(varName,'KVYEJVZPZF')) {
last_focused_comp=GetLastFocusedElementOfLink('KVYEJVZPZF');
function SetMethod_KVYEJVZPZF() {
Set_C_STA(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_KVYEJVZPZF();
} else {
setTimeout(SetMethod_KVYEJVZPZF,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'TMTNRFTARW')) {
return [Ctrl('TMTNRFTARW')];
}
if (Eq(varName,'JEGIRRECDX')) {
return [Ctrl('JEGIRRECDX')];
}
if (Eq(varName,'KVYEJVZPZF')) {
return [Ctrl('KVYEJVZPZF')];
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
if ( ! (m_oFather.SaveContext_ardt_xeneficope())) {
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
parent.ZtVWeb.raiseEventToEvalParms('ardt_xeneficope_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('ardt_xeneficope_dataNotSent',{'action':formaction});
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
if (Eq('TMTNRFTARW_ZOOM',lc)) {
return 0;
}
if (Eq('TMTNRFTARW',lc)) {
return 0;
}
if (Eq('JEGIRRECDX_ZOOM',lc)) {
return 1;
}
if (Eq('JEGIRRECDX',lc)) {
return 1;
}
if (Eq('KVYEJVZPZF_ZOOM',lc)) {
return 2;
}
if (Eq('KVYEJVZPZF',lc)) {
return 2;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_TMTNRFTARW();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,1)) {
l_oWv=LOpt_JEGIRRECDX();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,2)) {
l_oWv=LOpt_KVYEJVZPZF();
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
if (( ! (_ChkObl('TMTNRFTARW',1))) && FullRow()) {
_SignErr('TMTNRFTARW');
m_cLastWorkVarErrorMsg='10847988462';
l_bResult=false;
w_CODSOG=HtW('','C');
} else if (( ! (_ChkObl('GAEWMPRBSY',1))) && FullRow()) {
_SignErr('GAEWMPRBSY');
m_cLastWorkVarErrorMsg='10662833211';
l_bResult=false;
w_C_RAG=HtW('','C');
} else if (( ! (_ChkObl('JEGIRRECDX',1))) && FullRow()) {
_SignErr('JEGIRRECDX');
m_cLastWorkVarErrorMsg='C_CTA';
l_bResult=false;
w_C_CTA=HtW('','C');
} else if (( ! (_ChkObl('VFKBUBHCEY',1))) && FullRow()) {
_SignErr('VFKBUBHCEY');
m_cLastWorkVarErrorMsg='C_CAB';
l_bResult=false;
w_C_CAB=HtW('','C');
} else if (( ! (_ChkObl('KMXMWIBKDJ',1))) && FullRow()) {
_SignErr('KMXMWIBKDJ');
m_cLastWorkVarErrorMsg='C_PRV';
l_bResult=false;
w_C_PRV=HtW('','C');
} else if (( ! (_ChkObl('OFRQGKEFMW',1))) && FullRow()) {
_SignErr('OFRQGKEFMW');
m_cLastWorkVarErrorMsg='C_IND';
l_bResult=false;
w_C_IND=HtW('','C');
} else if (( ! (_ChkObl('KVYEJVZPZF',1))) && FullRow()) {
_SignErr('KVYEJVZPZF');
m_cLastWorkVarErrorMsg='C_STA';
l_bResult=false;
w_C_STA=HtW('','C');
} else if (( ! (_ChkObl('MBGCZJULKH',1))) && FullRow()) {
_SignErr('MBGCZJULKH');
m_cLastWorkVarErrorMsg='C_CAP';
l_bResult=false;
w_C_CAP=HtW('','C');
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
m_oFather.SetModified_ardt_xeneficope();
}
}
SaveContext.child=[];
function BlankRow() {
w_CODSOG='';
w_IDBASE='';
w_C_RAG='';
w_C_CTA='';
w_C_CAB='';
w_C_PRV='';
w_C_IND='';
w_C_STA='';
w_xdessta='';
w_C_CAP='';
if ( ! (EmptyString(w_CODSOG))) {
Link_TMTNRFTARW(null);
}
if ( ! (EmptyString(w_C_CTA))) {
Link_JEGIRRECDX(null);
}
if ( ! (EmptyString(w_C_STA))) {
Link_KVYEJVZPZF(null);
}
BlankRowChild();
if (m_bExtended) {
BlankRepeatedExtendedFields();
}
SaveDependsOn();
LoadContext(true);
}
function FullRow() {
return  ! (Empty(w_C_RAG));
}
function GetRepeatedFields() {
var l_aRepeatedFields;
l_aRepeatedFields={};
l_aRepeatedFields.CODSOG={"dec":0,"fixedpos":false,"id":"TMTNRFTARW","len":16,"name":"CODSOG","title":"Codice Soggetto","type":"C"};
l_aRepeatedFields.IDBASE={"dec":0,"fixedpos":true,"id":"TULWYXDCDW","len":10,"name":"IDBASE","title":"Identificativo riga","type":"C"};
l_aRepeatedFields.C_RAG={"dec":0,"fixedpos":false,"id":"GAEWMPRBSY","len":70,"name":"C_RAG","title":"Ragione sociale","type":"C"};
l_aRepeatedFields.C_CTA={"dec":0,"fixedpos":true,"id":"JEGIRRECDX","len":30,"name":"C_CTA","title":"","type":"C"};
l_aRepeatedFields.C_CAB={"dec":0,"fixedpos":true,"id":"VFKBUBHCEY","len":6,"name":"C_CAB","title":"","type":"C"};
l_aRepeatedFields.C_PRV={"dec":0,"fixedpos":true,"id":"KMXMWIBKDJ","len":2,"name":"C_PRV","title":"","type":"C"};
l_aRepeatedFields.C_IND={"dec":0,"fixedpos":true,"id":"OFRQGKEFMW","len":35,"name":"C_IND","title":"","type":"C"};
l_aRepeatedFields.C_STA={"dec":0,"fixedpos":true,"id":"KVYEJVZPZF","len":3,"name":"C_STA","title":"","type":"C"};
l_aRepeatedFields.C_CAP={"dec":0,"fixedpos":true,"id":"MBGCZJULKH","len":5,"name":"C_CAP","title":"","type":"C"};
l_aRepeatedFields.xdessta={"dec":0,"fixedpos":false,"id":"JUMOPCMYWO","len":40,"name":"xdessta","title":"Descrizione","type":"C"};
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
if(c=Ctrl('JEGIRRECDX')) SetDisabled(c,true);
if(c=Ctrl('JEGIRRECDX_ZOOM')) SetDisabled(c,true);
if(c=Ctrl('VFKBUBHCEY')) SetDisabled(c,true);
if(c=Ctrl('KMXMWIBKDJ')) SetDisabled(c,true);
if(c=Ctrl('OFRQGKEFMW')) SetDisabled(c,true);
if(c=Ctrl('KVYEJVZPZF')) SetDisabled(c,true);
if(c=Ctrl('KVYEJVZPZF_ZOOM')) SetDisabled(c,true);
if(c=Ctrl('MBGCZJULKH')) SetDisabled(c,true);
SetQueryRow(Ctrl('GridTable'),false);
} else {
SetEditRow(Ctrl('GridTable'),false);
var c;
if(c=Ctrl('JEGIRRECDX')) SetDisabled(c,false);
if(c=Ctrl('JEGIRRECDX_ZOOM')) SetDisabled(c,false);
if(c=Ctrl('VFKBUBHCEY')) SetDisabled(c,false);
if(c=Ctrl('KMXMWIBKDJ')) SetDisabled(c,false);
if(c=Ctrl('OFRQGKEFMW')) SetDisabled(c,false);
if(c=Ctrl('KVYEJVZPZF')) SetDisabled(c,false);
if(c=Ctrl('KVYEJVZPZF_ZOOM')) SetDisabled(c,false);
if(c=Ctrl('MBGCZJULKH')) SetDisabled(c,false);
EnableControlsUnderCondition(false);
}
m_bChildDisabled=enable;
}
