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
function EnableControlsUnderCondition_WhenReady() {
var l_bEnabled = true;
// * --- Area Manuale = UI - Enable Controls Init
// * --- Fine Area Manuale
if (window.Z && window.Z.Tabs) {
Z.Tabs.Get('tabs').CheckTabStrip();
}
if (IsDisabledByStateDriver('box_YORQOIOBQN')) {
DisableInputsInContainer(Ctrl('YORQOIOBQN'),true);
}
LibJavascript.forEachItem(m_FoundlingEditExpression,i_body_0)
function i_body_0(child){
child();
}
DisableUI();
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
function Set_account(ctrlValue,kmode,e) {
if (Ne(w_account,ctrlValue)) {
var ctl = _GetCtl(e,'LBGSJKIAGZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_account=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('LBGSJKIAGZ',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',100,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_SIGLA(ctrlValue,kmode,e) {
if (Ne(w_SIGLA,ctrlValue)) {
var ctl = _GetCtl(e,'TJYKSZAWUH');
if (_tracker.goon(ctl,ctrlValue)) {
w_SIGLA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('TJYKSZAWUH',0);
if (l_bResult) {
l_bResult=Link_TJYKSZAWUH(kmode);
if ( ! (l_bResult)) {
w_SIGLA=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',4,0,''));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',4,0,'');
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
function Link_TJYKSZAWUH(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_SIGLA);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('SIGLA',w_SIGLA,4,0);
l_Appl.SetFields('SIGLA,DESCRI,DATINI,DATFIN,PROVINCIA');
l_Appl.SetTypes('C,C,D,D,C');
l_Appl.LinkTable('tbluonas');
l_Appl.SetID('TJYKSZAWUH');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_SIGLA=l_Appl.GetStringValue('SIGLA',4,0);
w_DESCRI=l_Appl.GetStringValue('DESCRI',60,0);
w_DATINI=l_Appl.GetDateValue('DATINI',8,0);
w_DATINI=DateFromApplet(w_DATINI);
w_DATFIN=l_Appl.GetDateValue('DATFIN',8,0);
w_DATFIN=DateFromApplet(w_DATFIN);
w_PROVINCIA=l_Appl.GetStringValue('PROVINCIA',2,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_TJYKSZAWUH_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_TJYKSZAWUH';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_TJYKSZAWUH();
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
function Link_TJYKSZAWUH_Blank() {
w_SIGLA='';
w_DESCRI='';
w_DATINI=NullDate();
w_DATFIN=NullDate();
w_PROVINCIA='';
}
function LOpt_TJYKSZAWUH() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbluonas','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('SIGLA','C'));
l_oWv.setValue('LinkedField',WtA('SIGLA','C'));
l_oWv.setValue('UID',WtA('TJYKSZAWUH','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['TJYKSZAWUH'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('380127078'),'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'TJYKSZAWUH')) {
last_focused_comp=GetLastFocusedElementOfLink('TJYKSZAWUH');
function SetMethod_TJYKSZAWUH() {
Set_SIGLA(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_TJYKSZAWUH();
} else {
setTimeout(SetMethod_TJYKSZAWUH,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'TJYKSZAWUH')) {
return [Ctrl('TJYKSZAWUH')];
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
if (Eq(formaction,'moveto') && m_bUpdated) {
bResult=WindowConfirm(Translate('MSG_LEAVE_MOD'));
}
if (bResult) {
if (Eq(formaction,'moveto') || (Eq(m_cFunction,'edit') &&  ! (m_bUpdated))) {
formaction='discard';
}
if (Eq(formaction,'save')) {
NotifyEvent('Before Save');
l_Checks();
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
parent.ZtVWeb.raiseEventToEvalParms('armt_decodenascita_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('armt_decodenascita_dataNotSent',{'action':formaction});
}
}
}
}
CheckChild.child=[];
function Check() {
var l_bResult = true;
ResetErrorVars();
m_nLastError=0;
if ( ! (_ChkObl('LBGSJKIAGZ',1))) {
_SignErr('LBGSJKIAGZ');
m_cLastWorkVarErrorMsg='101550487';
l_bResult=false;
w_account=HtW('','C');
} else if ( ! (_ChkObl('TJYKSZAWUH',1))) {
_SignErr('TJYKSZAWUH');
m_cLastWorkVarErrorMsg='6827491';
l_bResult=false;
w_SIGLA=HtW('','C');
}
if (l_bResult) {
l_bResult=CheckChild(0);
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('TJYKSZAWUH_ZOOM',lc)) {
return 0;
}
if (Eq('TJYKSZAWUH',lc)) {
return 0;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_TJYKSZAWUH();
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
l_oWv.setValue('id',WtA(w_id,'N'));
l_oWv.setValue('account',WtA(w_account,'C'));
l_oWv.setValue('SIGLA',WtA(w_SIGLA,'C'));
l_oWv.setValue('DESCRI',WtA(w_DESCRI,'C'));
l_oWv.setValue('DATINI',WtA(w_DATINI,'D'));
l_oWv.setValue('DATFIN',WtA(w_DATFIN,'D'));
l_oWv.setValue('PROVINCIA',WtA(w_PROVINCIA,'C'));
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
}
_FillChildren.n=[];
FillWv.n=["id","account","SIGLA","DESCRI","DATINI","DATFIN","PROVINCIA"];
function SetModified() {
m_bUpdated=true;
}
