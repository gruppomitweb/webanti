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
function Set_CICODICE(ctrlValue,kmode,e) {
if (Ne(w_CICODICE,ctrlValue)) {
var ctl = _GetCtl(e,'SGWBXGCVUI');
if (_tracker.goon(ctl,ctrlValue)) {
w_CICODICE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SGWBXGCVUI',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('SGWBXGCVUI',function(){return WtH(w_CICODICE,'N',5,0,'99999')},w_CICODICE);
return l_bResult;
} else {
ctl.value=WtH('','N',5,0,'99999');
_ResetTracker();
return true;
}
}
return true;
}
function Set_CICAUCOD(ctrlValue,kmode,e) {
if (Ne(w_CICAUCOD,ctrlValue)) {
var ctl = _GetCtl(e,'XBRPBVBUVX');
if (_tracker.goon(ctl,ctrlValue)) {
w_CICAUCOD=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XBRPBVBUVX',0);
if (l_bResult) {
l_bResult=Link_XBRPBVBUVX(kmode);
if ( ! (l_bResult)) {
w_CICAUCOD=HtW('','C');
}
}
l_bResult=l_bResult && _ChkObl('ADZLHSFLMZ',0);
if (l_bResult) {
if ( ! (l_bResult)) {
w_CICAUCOD=HtW('','C');
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
function Set_CIFINALIT(ctrlValue,kmode,e) {
if (Ne(w_CIFINALIT,ctrlValue)) {
var ctl = _GetCtl(e,'WEFPSBXRML');
if (_tracker.goon(ctl,ctrlValue)) {
w_CIFINALIT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('WEFPSBXRML',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',50,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_CIRISCHIO(ctrlValue,kmode,e) {
if (Ne(w_CIRISCHIO,ctrlValue)) {
var ctl = _GetCtl(e,'UEAGDUQRMM');
if (_tracker.goon(ctl,ctrlValue)) {
w_CIRISCHIO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UEAGDUQRMM',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('UEAGDUQRMM',function(){return WtH(w_CIRISCHIO,'N',3,0,'999')},w_CIRISCHIO);
return l_bResult;
} else {
ctl.value=WtH('','N',3,0,'999');
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
UpdateAutonumber('CICODICE');
if ((Ne(o_gIntemediario,w_gIntemediario))) {
l_bTmpRes=Link_SZCSPLDQNY(null);
}
if ((Ne(o_CICAUCOD,w_CICAUCOD))) {
l_bTmpRes=Link_ADZLHSFLMZ(null);
}
LibJavascript.forEachItem(m_FoundlingCopyWorkVar,i_body_1)
function i_body_1(child){
child();
}
// * --- Area Manuale = UI - Calculate
// * --- Fine Area Manuale
UpdateAutonumber('');
m_bCalculating=false;
}
function SaveDependsOn() {
o_gIntemediario=w_gIntemediario;
o_CICAUCOD=w_CICAUCOD;
}
function SaveLabelDependsOn() {
}
function Link_SZCSPLDQNY(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_gIntemediario);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODICE',w_gIntemediario,11,0);
l_Appl.SetFields('CODICE,TIPOOPER');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('intermbo');
l_Appl.SetLinkzoom('opemt_intermbo');
l_Appl.SetID('SZCSPLDQNY');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_gIntemediario=l_Appl.GetStringValue('CODICE',11,0);
w_TIPOOPER=l_Appl.GetStringValue('TIPOOPER',2,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_SZCSPLDQNY_Blank();
}
if ( ! (l_bResult)) {
m_nLastError=3;
m_cLastWorkVarErrorMsg='';
if (Lt(l_nRec,0)) {
m_cLastMsgError=Translate('MSG_CONNECT_SERVER');
}
}
return l_bResult;
}
function Link_SZCSPLDQNY_Blank() {
w_gIntemediario='';
w_TIPOOPER='';
}
function LOpt_SZCSPLDQNY() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('intermbo','C'));
l_oWv.setValue('Linkzoomprg',WtA('opemt_intermbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODICE','C'));
l_oWv.setValue('LinkedField',WtA('CODICE','C'));
l_oWv.setValue('UID',WtA('SZCSPLDQNY','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['SZCSPLDQNY'][1],'C'));
return l_oWv;
}
function Link_XBRPBVBUVX(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CICAUCOD);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('TIPLEG',w_TIPOOPER,2,0);
l_Appl.SetStringKey('TIPOPERAZ',w_CICAUCOD,4,0);
l_Appl.SetFields('TIPOPERAZ');
l_Appl.SetTypes('C');
l_Appl.LinkTable('tipilegbo');
l_Appl.SetLinkzoom('opemd_tiplegbo');
l_Appl.SetID('XBRPBVBUVX');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CICAUCOD=l_Appl.GetStringValue('TIPOPERAZ',4,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_XBRPBVBUVX_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_XBRPBVBUVX';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_XBRPBVBUVX();
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
function Link_XBRPBVBUVX_Blank() {
w_CICAUCOD='';
}
function LOpt_XBRPBVBUVX() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tipilegbo','C'));
l_oWv.setValue('Linkzoomprg',WtA('opemd_tiplegbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('TIPLEG,TIPOPERAZ','C'));
l_oWv.setValue('LinkedField',WtA('TIPOPERAZ','C'));
l_oWv.setValue('UID',WtA('XBRPBVBUVX','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['XBRPBVBUVX'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('1881733604'),'C'));
return l_oWv;
}
function Link_ADZLHSFLMZ(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CICAUCOD);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODICE',w_CICAUCOD,4,0);
l_Appl.SetFields('CODICE,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbattivita');
l_Appl.SetLinkzoom('opemt_attivita');
l_Appl.SetID('ADZLHSFLMZ');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CICAUCOD=l_Appl.GetStringValue('CODICE',4,0);
w_xdesccausale=l_Appl.GetStringValue('DESCRI',250,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_ADZLHSFLMZ_Blank();
}
if ( ! (l_bResult)) {
m_nLastError=3;
m_cLastWorkVarErrorMsg='';
if (Lt(l_nRec,0)) {
m_cLastMsgError=Translate('MSG_CONNECT_SERVER');
}
}
return l_bResult;
}
function Link_ADZLHSFLMZ_Blank() {
w_CICAUCOD='';
w_xdesccausale='';
}
function LOpt_ADZLHSFLMZ() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbattivita','C'));
l_oWv.setValue('Linkzoomprg',WtA('opemt_attivita','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODICE','C'));
l_oWv.setValue('LinkedField',WtA('CODICE','C'));
l_oWv.setValue('UID',WtA('ADZLHSFLMZ','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['ADZLHSFLMZ'][1],'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'XBRPBVBUVX')) {
last_focused_comp=GetLastFocusedElementOfLink('XBRPBVBUVX');
function SetMethod_XBRPBVBUVX() {
Set_CICAUCOD(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_XBRPBVBUVX();
} else {
setTimeout(SetMethod_XBRPBVBUVX,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'XBRPBVBUVX')) {
return [Ctrl('XBRPBVBUVX')];
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
parent.ZtVWeb.raiseEventToEvalParms('opemt_tbcauint_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('opemt_tbcauint_dataNotSent',{'action':formaction});
}
}
}
}
CheckChild.child=[];
function Check() {
var l_bResult = true;
ResetErrorVars();
m_nLastError=0;
if ( ! (_ChkObl('SGWBXGCVUI',1))) {
_SignErr('SGWBXGCVUI');
m_cLastWorkVarErrorMsg='112851763';
l_bResult=false;
w_CICODICE=HtW('','N');
} else if ( ! (_ChkObl('XBRPBVBUVX',1))) {
_SignErr('XBRPBVBUVX');
m_cLastWorkVarErrorMsg='1814604627';
l_bResult=false;
w_CICAUCOD=HtW('','C');
} else if ( ! (_ChkObl('WEFPSBXRML',1))) {
_SignErr('WEFPSBXRML');
m_cLastWorkVarErrorMsg='12106991307';
l_bResult=false;
w_CIFINALIT=HtW('','C');
} else if ( ! (_ChkObl('UEAGDUQRMM',1))) {
_SignErr('UEAGDUQRMM');
m_cLastWorkVarErrorMsg='1701044225';
l_bResult=false;
w_CIRISCHIO=HtW('','N');
}
if (l_bResult) {
l_bResult=CheckChild(0);
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('XBRPBVBUVX_ZOOM',lc)) {
return 0;
}
if (Eq('XBRPBVBUVX',lc)) {
return 0;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_XBRPBVBUVX();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
l_cFixedFilter=l_cFixedFilter+l_cAndOp+_flt_('TIPLEG',w_TIPOOPER,'C',true);
if ( ! (Empty(l_cFixedFilter))) {
l_cAndOp=' and ';
}
l_oWv.setValue('FixedFilter',l_cFixedFilter);
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
}
function FillWv() {
var l_oWv = InitWvApplet();
l_oWv.setValue('m_CheckVars',JSON.stringify(m_CheckVars));
l_oWv.setValue('CICODICE',WtA(w_CICODICE,'N'));
l_oWv.setValue('op_CICODICE',WtA(op_CICODICE,'N'));
l_oWv.setValue('CICAUCOD',WtA(w_CICAUCOD,'C'));
l_oWv.setValue('CIFINALIT',WtA(w_CIFINALIT,'C'));
l_oWv.setValue('CIRISCHIO',WtA(w_CIRISCHIO,'N'));
l_oWv.setValue('gIntemediario',WtA(w_gIntemediario,'C'));
l_oWv.setValue('TIPOOPER',WtA(w_TIPOOPER,'C'));
l_oWv.setValue('xdesccausale',WtA(w_xdesccausale,'C'));
l_oWv.setValue('op_codazi',WtA(op_codazi,'C'));
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
FillWv.n=["CICODICE","CICAUCOD","CIFINALIT","CIRISCHIO","gIntemediario","TIPOOPER","xdesccausale"];
function SetModified() {
m_bUpdated=true;
}
