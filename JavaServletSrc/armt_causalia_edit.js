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
function Set_CODCAU(ctrlValue,kmode,e) {
if (Ne(w_CODCAU,ctrlValue)) {
var ctl = _GetCtl(e,'SUTANCBZLS');
if (_tracker.goon(ctl,ctrlValue)) {
w_CODCAU=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SUTANCBZLS',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',4,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_DESCRI(ctrlValue,kmode,e) {
if (Ne(w_DESCRI,ctrlValue)) {
var ctl = _GetCtl(e,'AXRQOHDDBP');
if (_tracker.goon(ctl,ctrlValue)) {
w_DESCRI=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('AXRQOHDDBP',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',165,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_SEGNO(ctrlValue,kmode,e) {
if (Ne(w_SEGNO,ctrlValue)) {
var ctl = _GetCtl(e,'WGIESSCOWN');
if (_tracker.goon(ctl,ctrlValue)) {
w_SEGNO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('WGIESSCOWN',0);
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
function Set_CAUSINT(ctrlValue,kmode,e) {
if (Ne(w_CAUSINT,ctrlValue)) {
var ctl = _GetCtl(e,'NONDJYDRPI');
if (_tracker.goon(ctl,ctrlValue)) {
w_CAUSINT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NONDJYDRPI',0);
if (l_bResult) {
l_bResult=Link_NONDJYDRPI(kmode);
if ( ! (l_bResult)) {
w_CAUSINT=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',2,0,''));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',2,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_idbase(ctrlValue,kmode,e) {
if (Ne(w_idbase,ctrlValue)) {
var ctl = _GetCtl(e,'LSVJKMLQUN');
if (_tracker.goon(ctl,ctrlValue)) {
w_idbase=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('LSVJKMLQUN',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',4,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_DATINI(ctrlValue,kmode,e) {
if (Ne(w_DATINI,ctrlValue)) {
var ctl = _GetCtl(e,'ZTKHOWJTQW');
if (_tracker.goon(ctl,ctrlValue)) {
w_DATINI=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ZTKHOWJTQW',0);
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
function Set_VALPERINT(ctrlValue,kmode,e) {
if (Ne(w_VALPERINT,ctrlValue)) {
var ctl = _GetCtl(e,'CDBUTKZYKR');
if (_tracker.goon(ctl,ctrlValue)) {
w_VALPERINT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CDBUTKZYKR',0);
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
function Set_DATAVALI(ctrlValue,kmode,e) {
if (Ne(w_DATAVALI,ctrlValue)) {
var ctl = _GetCtl(e,'JEGTRWGMTW');
if (_tracker.goon(ctl,ctrlValue)) {
w_DATAVALI=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('JEGTRWGMTW',0);
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
function Set_FLGINTER(ctrlValue,kmode,e) {
if (Ne(w_FLGINTER,ctrlValue)) {
var ctl = _GetCtl(e,'QYLDDSFFZI');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLGINTER=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QYLDDSFFZI',0);
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
function Set_NOSARA(ctrlValue,kmode,e) {
if (Ne(w_NOSARA,ctrlValue)) {
var ctl = _GetCtl(e,'HVCDFAMPAB');
if (_tracker.goon(ctl,ctrlValue)) {
w_NOSARA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HVCDFAMPAB',0);
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
function Link_NONDJYDRPI(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CAUSINT);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODVOC',w_CAUSINT,2,0);
l_Appl.SetFields('CODVOC,DESCRIZ');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbcausin');
l_Appl.SetLinkzoom('armt_causalis');
l_Appl.SetID('NONDJYDRPI');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CAUSINT=l_Appl.GetStringValue('CODVOC',2,0);
w_descau=l_Appl.GetStringValue('DESCRIZ',165,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_NONDJYDRPI_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_NONDJYDRPI';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_NONDJYDRPI();
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
function Link_NONDJYDRPI_Blank() {
w_CAUSINT='';
w_descau='';
}
function LOpt_NONDJYDRPI() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcausin','C'));
l_oWv.setValue('Linkzoomprg',WtA('armt_causalis','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODVOC','C'));
l_oWv.setValue('LinkedField',WtA('CODVOC','C'));
l_oWv.setValue('UID',WtA('NONDJYDRPI','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['NONDJYDRPI'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('2071317529'),'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'NONDJYDRPI')) {
last_focused_comp=GetLastFocusedElementOfLink('NONDJYDRPI');
function SetMethod_NONDJYDRPI() {
Set_CAUSINT(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_NONDJYDRPI();
} else {
setTimeout(SetMethod_NONDJYDRPI,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'NONDJYDRPI')) {
return [Ctrl('NONDJYDRPI')];
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
parent.ZtVWeb.raiseEventToEvalParms('armt_causalia_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('armt_causalia_dataNotSent',{'action':formaction});
}
}
}
}
CheckChild.child=[];
function Check() {
var l_bResult = true;
ResetErrorVars();
m_nLastError=0;
if ( ! (_ChkObl('SUTANCBZLS',1))) {
_SignErr('SUTANCBZLS');
m_cLastWorkVarErrorMsg='112851763';
l_bResult=false;
w_CODCAU=HtW('','C');
} else if ( ! (_ChkObl('AXRQOHDDBP',1))) {
_SignErr('AXRQOHDDBP');
m_cLastWorkVarErrorMsg='285808099';
l_bResult=false;
w_DESCRI=HtW('','C');
} else if ( ! (_ChkObl('WGIESSCOWN',1))) {
_SignErr('WGIESSCOWN');
m_cLastWorkVarErrorMsg='7753123';
l_bResult=false;
w_SEGNO=HtW('','C');
} else if ( ! (_ChkObl('NONDJYDRPI',1))) {
_SignErr('NONDJYDRPI');
m_cLastWorkVarErrorMsg='215310487';
l_bResult=false;
w_CAUSINT=HtW('','C');
} else if ( ! (_ChkObl('LSVJKMLQUN',1))) {
_SignErr('LSVJKMLQUN');
m_cLastWorkVarErrorMsg='1249199241';
l_bResult=false;
w_idbase=HtW('','C');
} else if ( ! (_ChkObl('CDBUTKZYKR',1))) {
_SignErr('CDBUTKZYKR');
m_cLastWorkVarErrorMsg='345486504';
l_bResult=false;
w_VALPERINT=HtW('','C');
} else if ( ! (_ChkObl('ZTKHOWJTQW',1))) {
_SignErr('ZTKHOWJTQW');
m_cLastWorkVarErrorMsg='86866770';
l_bResult=false;
w_DATINI=HtW('','D');
} else if ( ! (_ChkObl('JEGTRWGMTW',1))) {
_SignErr('JEGTRWGMTW');
m_cLastWorkVarErrorMsg='1216938285';
l_bResult=false;
w_DATAVALI=HtW('','D');
} else if ( ! (_ChkObl('QYLDDSFFZI',1))) {
_SignErr('QYLDDSFFZI');
m_cLastWorkVarErrorMsg='1404896941';
l_bResult=false;
w_FLGINTER=HtW('','C');
} else if ( ! (_ChkObl('HVCDFAMPAB',1))) {
_SignErr('HVCDFAMPAB');
m_cLastWorkVarErrorMsg='1866071435';
l_bResult=false;
w_NOSARA='N';
}
if (l_bResult) {
l_bResult=CheckChild(0);
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('NONDJYDRPI_ZOOM',lc)) {
return 0;
}
if (Eq('NONDJYDRPI',lc)) {
return 0;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_NONDJYDRPI();
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
l_oWv.setValue('CODCAU',WtA(w_CODCAU,'C'));
l_oWv.setValue('DESCRI',WtA(w_DESCRI,'C'));
l_oWv.setValue('SEGNO',WtA(w_SEGNO,'C'));
l_oWv.setValue('CAUSINT',WtA(w_CAUSINT,'C'));
l_oWv.setValue('idbase',WtA(w_idbase,'C'));
l_oWv.setValue('VALPERINT',WtA(w_VALPERINT,'C'));
l_oWv.setValue('DATINI',WtA(w_DATINI,'D'));
l_oWv.setValue('DATAVALI',WtA(w_DATAVALI,'D'));
l_oWv.setValue('FLGINTER',WtA(w_FLGINTER,'C'));
l_oWv.setValue('NOSARA',WtA(w_NOSARA,'C'));
l_oWv.setValue('descau',WtA(w_descau,'C'));
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
FillWv.n=["CODCAU","DESCRI","SEGNO","CAUSINT","idbase","VALPERINT","DATINI","DATAVALI","FLGINTER","NOSARA","descau"];
function SetModified() {
m_bUpdated=true;
}
