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
l_bEnabled= ! (false) || Eq(m_cFunction,'edit') || IsDisabledByStateDriver('PRGRAP');
SetDisabled('IKBJDXURXZ',l_bEnabled);
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
function Set_RAPPORTO(ctrlValue,kmode,e) {
if (Ne(w_RAPPORTO,ctrlValue)) {
var ctl = _GetCtl(e,'VULKXBOZMY');
if (_tracker.goon(ctl,ctrlValue)) {
w_RAPPORTO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VULKXBOZMY',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',25,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_DESCRAP(ctrlValue,kmode,e) {
if (Ne(w_DESCRAP,ctrlValue)) {
var ctl = _GetCtl(e,'TVVYAPQCUU');
if (_tracker.goon(ctl,ctrlValue)) {
w_DESCRAP=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('TVVYAPQCUU',0);
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
function Set_TIPOMOV(ctrlValue,kmode,e) {
if (Ne(w_TIPOMOV,ctrlValue)) {
var ctl = _GetCtl(e,'XONZUZFGJE');
if (_tracker.goon(ctl,ctrlValue)) {
w_TIPOMOV=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XONZUZFGJE',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_DATAOPE(ctrlValue,kmode,e) {
if (Ne(w_DATAOPE,ctrlValue)) {
var ctl = _GetCtl(e,'FIYLJWMFNJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_DATAOPE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FIYLJWMFNJ',0);
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
function Set_CODINTEST(ctrlValue,kmode,e) {
if (Ne(w_CODINTEST,ctrlValue)) {
var ctl = _GetCtl(e,'UZGJEPKANK');
if (_tracker.goon(ctl,ctrlValue)) {
w_CODINTEST=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UZGJEPKANK',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',16,0,'');
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
function Set_PRGRAP(ctrlValue,kmode,e) {
if (Ne(w_PRGRAP,ctrlValue)) {
var ctl = _GetCtl(e,'IKBJDXURXZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_PRGRAP=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('IKBJDXURXZ',0);
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
function Set_CASTATOM(ctrlValue,kmode,e) {
if (Ne(w_CASTATOM,ctrlValue)) {
var ctl = _GetCtl(e,'YQXXQDWDUP');
if (_tracker.goon(ctl,ctrlValue)) {
w_CASTATOM=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YQXXQDWDUP',0);
if (l_bResult) {
l_bResult=Link_YQXXQDWDUP(kmode);
if ( ! (l_bResult)) {
w_CASTATOM=HtW('','N');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'N',3,0,''));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','N',3,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_CASTATOC(ctrlValue,kmode,e) {
if (Ne(w_CASTATOC,ctrlValue)) {
var ctl = _GetCtl(e,'VLNPAMWOBU');
if (_tracker.goon(ctl,ctrlValue)) {
w_CASTATOC=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VLNPAMWOBU',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','N',3,0,'');
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
function Link_YQXXQDWDUP(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CASTATOM);
var l_Appl = LinkApplet();
l_Appl.SetDoubleKey('SCCODICE',w_CASTATOM,3,0);
l_Appl.SetFields('SCCODICE,SCDESCRI');
l_Appl.SetTypes('N,C');
l_Appl.LinkTable('cgo_statocard');
l_Appl.SetID('YQXXQDWDUP');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CASTATOM=l_Appl.GetDoubleValue('SCCODICE',3,0);
w_xSCDESCRI=l_Appl.GetStringValue('SCDESCRI',80,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_YQXXQDWDUP_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_YQXXQDWDUP';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_YQXXQDWDUP();
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
function Link_YQXXQDWDUP_Blank() {
w_CASTATOM=0;
w_xSCDESCRI='';
}
function LOpt_YQXXQDWDUP() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('cgo_statocard','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('SCCODICE','C'));
l_oWv.setValue('LinkedField',WtA('SCCODICE','C'));
l_oWv.setValue('UID',WtA('YQXXQDWDUP','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['YQXXQDWDUP'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('10623903910'),'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'YQXXQDWDUP')) {
last_focused_comp=GetLastFocusedElementOfLink('YQXXQDWDUP');
function SetMethod_YQXXQDWDUP() {
Set_CASTATOM(HtW(value,'N'),0);
}
if (IsDeviceMobile()) {
SetMethod_YQXXQDWDUP();
} else {
setTimeout(SetMethod_YQXXQDWDUP,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'YQXXQDWDUP')) {
return [Ctrl('YQXXQDWDUP')];
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
parent.ZtVWeb.raiseEventToEvalParms('armt_cgo_rapporti_err_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('armt_cgo_rapporti_err_dataNotSent',{'action':formaction});
}
}
}
}
CheckChild.child=[];
function Check() {
var l_bResult = true;
ResetErrorVars();
m_nLastError=0;
if ( ! (_ChkObl('VULKXBOZMY',1))) {
_SignErr('VULKXBOZMY');
m_cLastWorkVarErrorMsg='11116511596';
l_bResult=false;
w_RAPPORTO=HtW('','C');
} else if ( ! (_ChkObl('TVVYAPQCUU',1))) {
_SignErr('TVVYAPQCUU');
m_cLastWorkVarErrorMsg='285808099';
l_bResult=false;
w_DESCRAP=HtW('','C');
} else if ( ! (_ChkObl('XONZUZFGJE',1))) {
_SignErr('XONZUZFGJE');
m_cLastWorkVarErrorMsg='11787042165';
l_bResult=false;
w_TIPOMOV=HtW('','C');
} else if ( ! (_ChkObl('FIYLJWMFNJ',1))) {
_SignErr('FIYLJWMFNJ');
m_cLastWorkVarErrorMsg='829201110';
l_bResult=false;
w_DATAOPE=HtW('','D');
} else if ( ! (_ChkObl('UZGJEPKANK',1))) {
_SignErr('UZGJEPKANK');
m_cLastWorkVarErrorMsg='11636076131';
l_bResult=false;
w_CODINTEST=HtW('','C');
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
} else if ((false) && ( ! (_ChkObl('IKBJDXURXZ',1)))) {
_SignErr('IKBJDXURXZ');
m_cLastWorkVarErrorMsg='321938427';
l_bResult=false;
w_PRGRAP=HtW('','C');
} else if ( ! (_ChkObl('YQXXQDWDUP',1))) {
_SignErr('YQXXQDWDUP');
m_cLastWorkVarErrorMsg='1467250113';
l_bResult=false;
w_CASTATOM=HtW('','N');
} else if ( ! (_ChkObl('VLNPAMWOBU',1))) {
_SignErr('VLNPAMWOBU');
m_cLastWorkVarErrorMsg='973931140';
l_bResult=false;
w_CASTATOC=HtW('','N');
}
if (l_bResult) {
l_bResult=CheckChild(0);
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('VULKXBOZMY_ZOOM',lc)) {
return 0;
}
if (Eq('TVVYAPQCUU_ZOOM',lc)) {
return 0;
}
if (Eq('FIYLJWMFNJ_ZOOM',lc)) {
return 0;
}
if (Eq('UZGJEPKANK_ZOOM',lc)) {
return 0;
}
if (Eq('YQXXQDWDUP_ZOOM',lc)) {
return 0;
}
if (Eq('YQXXQDWDUP',lc)) {
return 0;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_YQXXQDWDUP();
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
l_oWv.setValue('RAPPORTO',WtA(w_RAPPORTO,'C'));
l_oWv.setValue('DESCRAP',WtA(w_DESCRAP,'C'));
l_oWv.setValue('TIPOMOV',WtA(w_TIPOMOV,'C'));
l_oWv.setValue('DATAOPE',WtA(w_DATAOPE,'D'));
l_oWv.setValue('CODINTEST',WtA(w_CODINTEST,'C'));
l_oWv.setValue('TXTERR',WtA(w_TXTERR,'M'));
l_oWv.setValue('FLGFULL',WtA(w_FLGFULL,'C'));
l_oWv.setValue('PRGRAP',WtA(w_PRGRAP,'C'));
l_oWv.setValue('CASTATOM',WtA(w_CASTATOM,'N'));
l_oWv.setValue('CASTATOC',WtA(w_CASTATOC,'N'));
l_oWv.setValue('xSCDESCRI',WtA(w_xSCDESCRI,'C'));
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
FillWv.n=["RAPPORTO","DESCRAP","TIPOMOV","DATAOPE","CODINTEST","TXTERR","FLGFULL","PRGRAP","CASTATOM","CASTATOC","xSCDESCRI"];
function SetModified() {
m_bUpdated=true;
}
