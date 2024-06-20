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
l_bEnabled= ! (false) || Eq(m_cFunction,'edit') || IsDisabledByStateDriver('PRGDIP');
SetDisabled('QAIJWTCCHF',l_bEnabled);
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
function Set_CODDIP(ctrlValue,kmode,e) {
if (Ne(w_CODDIP,ctrlValue)) {
var ctl = _GetCtl(e,'HAMGFXNOBZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_CODDIP=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HAMGFXNOBZ',0);
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
function Set_DESCRIZ(ctrlValue,kmode,e) {
if (Ne(w_DESCRIZ,ctrlValue)) {
var ctl = _GetCtl(e,'FBTVENHVSF');
if (_tracker.goon(ctl,ctrlValue)) {
w_DESCRIZ=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FBTVENHVSF',0);
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
function Set_DESCCIT(ctrlValue,kmode,e) {
if (Ne(w_DESCCIT,ctrlValue)) {
var ctl = _GetCtl(e,'QGLRMYVVYR');
if (_tracker.goon(ctl,ctrlValue)) {
w_DESCCIT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QGLRMYVVYR',0);
if (l_bResult) {
l_bResult=Link_QGLRMYVVYR(kmode);
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
var ctl = _GetCtl(e,'HEWLMIJUMK');
if (_tracker.goon(ctl,ctrlValue)) {
w_PROVINCIA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HEWLMIJUMK',0);
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
function Set_CAB(ctrlValue,kmode,e) {
if (Ne(w_CAB,ctrlValue)) {
var ctl = _GetCtl(e,'THQKFWRDKA');
if (_tracker.goon(ctl,ctrlValue)) {
w_CAB=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('THQKFWRDKA',0);
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
function Set_IDBASE(ctrlValue,kmode,e) {
if (Ne(w_IDBASE,ctrlValue)) {
var ctl = _GetCtl(e,'JVFMFSMZFE');
if (_tracker.goon(ctl,ctrlValue)) {
w_IDBASE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('JVFMFSMZFE',0);
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
function Set_DOMICILIO(ctrlValue,kmode,e) {
if (Ne(w_DOMICILIO,ctrlValue)) {
var ctl = _GetCtl(e,'OJVLLPYCBU');
if (_tracker.goon(ctl,ctrlValue)) {
w_DOMICILIO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('OJVLLPYCBU',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',40,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_TELEFONO(ctrlValue,kmode,e) {
if (Ne(w_TELEFONO,ctrlValue)) {
var ctl = _GetCtl(e,'TGHRJMBUBA');
if (_tracker.goon(ctl,ctrlValue)) {
w_TELEFONO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('TGHRJMBUBA',0);
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
function Set_TXTERR(ctrlValue,kmode,e) {
if (Ne(w_TXTERR,ctrlValue)) {
var ctl = _GetCtl(e,'TVQKRQXOUS');
if (_tracker.goon(ctl,ctrlValue)) {
w_TXTERR=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('TVQKRQXOUS',0);
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
function Set_FLGFULL(ctrlValue,kmode,e) {
if (Ne(w_FLGFULL,ctrlValue)) {
var ctl = _GetCtl(e,'AYCRVWSEMG');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLGFULL=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('AYCRVWSEMG',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_PRGDIP(ctrlValue,kmode,e) {
if (Ne(w_PRGDIP,ctrlValue)) {
var ctl = _GetCtl(e,'QAIJWTCCHF');
if (_tracker.goon(ctl,ctrlValue)) {
w_PRGDIP=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QAIJWTCCHF',0);
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
function Set_CODICEAAMS(ctrlValue,kmode,e) {
if (Ne(w_CODICEAAMS,ctrlValue)) {
var ctl = _GetCtl(e,'CKIITMJYDK');
if (_tracker.goon(ctl,ctrlValue)) {
w_CODICEAAMS=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CKIITMJYDK',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',12,0,'');
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
function Link_QGLRMYVVYR(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_DESCCIT);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CITTA',w_DESCCIT,30,0);
l_Appl.SetFields('CITTA,CAB,PROV');
l_Appl.SetTypes('C,C,C');
l_Appl.LinkTable('tbcitta');
l_Appl.SetID('QGLRMYVVYR');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_DESCCIT=l_Appl.GetStringValue('CITTA',30,0);
w_CAB=l_Appl.GetStringValue('CAB',6,0);
w_PROVINCIA=l_Appl.GetStringValue('PROV',2,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_QGLRMYVVYR_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_QGLRMYVVYR';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_QGLRMYVVYR();
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
function Link_QGLRMYVVYR_Blank() {
w_DESCCIT='';
w_CAB='';
w_PROVINCIA='';
}
function LOpt_QGLRMYVVYR() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcitta','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CITTA','C'));
l_oWv.setValue('LinkedField',WtA('CITTA','C'));
l_oWv.setValue('UID',WtA('QGLRMYVVYR','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['QGLRMYVVYR'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('15186643'),'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'QGLRMYVVYR')) {
last_focused_comp=GetLastFocusedElementOfLink('QGLRMYVVYR');
function SetMethod_QGLRMYVVYR() {
Set_DESCCIT(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_QGLRMYVVYR();
} else {
setTimeout(SetMethod_QGLRMYVVYR,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'QGLRMYVVYR')) {
return [Ctrl('QGLRMYVVYR')];
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
parent.ZtVWeb.raiseEventToEvalParms('armt_cgo_anadip_err_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('armt_cgo_anadip_err_dataNotSent',{'action':formaction});
}
}
}
}
CheckChild.child=[];
function Check() {
var l_bResult = true;
ResetErrorVars();
m_nLastError=0;
if ( ! (_ChkObl('HAMGFXNOBZ',1))) {
_SignErr('HAMGFXNOBZ');
m_cLastWorkVarErrorMsg='2071283709';
l_bResult=false;
w_CODDIP=HtW('','C');
} else if ( ! (_ChkObl('FBTVENHVSF',1))) {
_SignErr('FBTVENHVSF');
m_cLastWorkVarErrorMsg='285808099';
l_bResult=false;
w_DESCRIZ=HtW('','C');
} else if ( ! (_ChkObl('QGLRMYVVYR',1))) {
_SignErr('QGLRMYVVYR');
m_cLastWorkVarErrorMsg='15186643';
l_bResult=false;
w_DESCCIT=HtW('','C');
} else if ( ! (_ChkObl('HEWLMIJUMK',1))) {
_SignErr('HEWLMIJUMK');
m_cLastWorkVarErrorMsg='10095365423';
l_bResult=false;
w_PROVINCIA=HtW('','C');
} else if ( ! (_ChkObl('THQKFWRDKA',1))) {
_SignErr('THQKFWRDKA');
m_cLastWorkVarErrorMsg='18003';
l_bResult=false;
w_CAB=HtW('','C');
} else if ( ! (_ChkObl('JVFMFSMZFE',1))) {
_SignErr('JVFMFSMZFE');
m_cLastWorkVarErrorMsg='11105229855';
l_bResult=false;
w_IDBASE=HtW('','C');
} else if ( ! (_ChkObl('OJVLLPYCBU',1))) {
_SignErr('OJVLLPYCBU');
m_cLastWorkVarErrorMsg='554236824';
l_bResult=false;
w_DOMICILIO=HtW('','C');
} else if ( ! (_ChkObl('TGHRJMBUBA',1))) {
_SignErr('TGHRJMBUBA');
m_cLastWorkVarErrorMsg='1700577956';
l_bResult=false;
w_TELEFONO=HtW('','C');
} else if ( ! (_ChkObl('TVQKRQXOUS',1))) {
_SignErr('TVQKRQXOUS');
m_cLastWorkVarErrorMsg='118057317';
l_bResult=false;
w_TXTERR=HtW('','M');
} else if ( ! (_ChkObl('AYCRVWSEMG',1))) {
_SignErr('AYCRVWSEMG');
m_cLastWorkVarErrorMsg='1791194163';
l_bResult=false;
w_FLGFULL='N';
} else if ((false) && ( ! (_ChkObl('QAIJWTCCHF',1)))) {
_SignErr('QAIJWTCCHF');
m_cLastWorkVarErrorMsg='321938427';
l_bResult=false;
w_PRGDIP=HtW('','C');
} else if ( ! (_ChkObl('CKIITMJYDK',1))) {
_SignErr('CKIITMJYDK');
m_cLastWorkVarErrorMsg='918180676';
l_bResult=false;
w_CODICEAAMS=HtW('','C');
}
if (l_bResult) {
l_bResult=CheckChild(0);
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('HAMGFXNOBZ_ZOOM',lc)) {
return 0;
}
if (Eq('FBTVENHVSF_ZOOM',lc)) {
return 0;
}
if (Eq('QGLRMYVVYR_ZOOM',lc)) {
return 0;
}
if (Eq('QGLRMYVVYR',lc)) {
return 0;
}
if (Eq('HEWLMIJUMK_ZOOM',lc)) {
return 1;
}
if (Eq('THQKFWRDKA_ZOOM',lc)) {
return 1;
}
if (Eq('JVFMFSMZFE_ZOOM',lc)) {
return 1;
}
if (Eq('OJVLLPYCBU_ZOOM',lc)) {
return 1;
}
if (Eq('TGHRJMBUBA_ZOOM',lc)) {
return 1;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_QGLRMYVVYR();
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
l_oWv.setValue('CODDIP',WtA(w_CODDIP,'C'));
l_oWv.setValue('DESCRIZ',WtA(w_DESCRIZ,'C'));
l_oWv.setValue('DESCCIT',WtA(w_DESCCIT,'C'));
l_oWv.setValue('PROVINCIA',WtA(w_PROVINCIA,'C'));
l_oWv.setValue('CAB',WtA(w_CAB,'C'));
l_oWv.setValue('IDBASE',WtA(w_IDBASE,'C'));
l_oWv.setValue('DOMICILIO',WtA(w_DOMICILIO,'C'));
l_oWv.setValue('TELEFONO',WtA(w_TELEFONO,'C'));
l_oWv.setValue('TXTERR',WtA(w_TXTERR,'M'));
l_oWv.setValue('FLGFULL',WtA(w_FLGFULL,'C'));
l_oWv.setValue('PRGDIP',WtA(w_PRGDIP,'C'));
l_oWv.setValue('CODICEAAMS',WtA(w_CODICEAAMS,'C'));
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
FillWv.n=["CODDIP","DESCRIZ","DESCCIT","PROVINCIA","CAB","IDBASE","DOMICILIO","TELEFONO","TXTERR","FLGFULL","PRGDIP","CODICEAAMS"];
function SetModified() {
m_bUpdated=true;
}
