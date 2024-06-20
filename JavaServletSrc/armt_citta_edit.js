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
function Set_IDBASE(ctrlValue,kmode,e) {
if (Ne(w_IDBASE,ctrlValue)) {
var ctl = _GetCtl(e,'FFTGLGUVGJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_IDBASE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FFTGLGUVGJ',0);
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
function Set_CITTA(ctrlValue,kmode,e) {
if (Ne(w_CITTA,ctrlValue)) {
var ctl = _GetCtl(e,'BLYSPBZZDM');
if (_tracker.goon(ctl,ctrlValue)) {
w_CITTA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BLYSPBZZDM',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',60,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_CAB(ctrlValue,kmode,e) {
if (Ne(w_CAB,ctrlValue)) {
var ctl = _GetCtl(e,'SJMGCCLAYZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_CAB=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SJMGCCLAYZ',0);
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
function Set_PROV(ctrlValue,kmode,e) {
if (Ne(w_PROV,ctrlValue)) {
var ctl = _GetCtl(e,'TWBJLTWWLG');
if (_tracker.goon(ctl,ctrlValue)) {
w_PROV=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('TWBJLTWWLG',0);
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
var ctl = _GetCtl(e,'PQBULAVLOC');
if (_tracker.goon(ctl,ctrlValue)) {
w_CAP=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('PQBULAVLOC',0);
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
function Set_PKTBSTATI(ctrlValue,kmode,e) {
if (Ne(w_PKTBSTATI,ctrlValue)) {
var ctl = _GetCtl(e,'ILAKLAWXVC');
if (_tracker.goon(ctl,ctrlValue)) {
w_PKTBSTATI=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ILAKLAWXVC',0);
if (l_bResult) {
l_bResult=Link_ILAKLAWXVC(kmode);
if ( ! (l_bResult)) {
w_PKTBSTATI=HtW('','C');
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
function Set_SIGLA(ctrlValue,kmode,e) {
if (Ne(w_SIGLA,ctrlValue)) {
var ctl = _GetCtl(e,'ZRZJZIUNUE');
if (_tracker.goon(ctl,ctrlValue)) {
w_SIGLA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ZRZJZIUNUE',0);
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
function Set_PREF(ctrlValue,kmode,e) {
if (Ne(w_PREF,ctrlValue)) {
var ctl = _GetCtl(e,'GKAEUHPNIS');
if (_tracker.goon(ctl,ctrlValue)) {
w_PREF=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('GKAEUHPNIS',0);
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
function Set_IDREGIO(ctrlValue,kmode,e) {
if (Ne(w_IDREGIO,ctrlValue)) {
var ctl = _GetCtl(e,'QEXCLHUJUO');
if (_tracker.goon(ctl,ctrlValue)) {
w_IDREGIO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QEXCLHUJUO',0);
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
function Set_IDISTAT(ctrlValue,kmode,e) {
if (Ne(w_IDISTAT,ctrlValue)) {
var ctl = _GetCtl(e,'UUHPGKPAGJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_IDISTAT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UUHPGKPAGJ',0);
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
UpdateAutonumber('');
m_bCalculating=false;
}
function SaveDependsOn() {
}
function SaveLabelDependsOn() {
}
function Link_ILAKLAWXVC(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_PKTBSTATI);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODSTA',w_PKTBSTATI,3,0);
l_Appl.SetFields('CODSTA,DESCRI,SIGLA');
l_Appl.SetTypes('C,C,C');
l_Appl.LinkTable('tbstati');
l_Appl.SetLinkzoom('armt_stati');
l_Appl.SetID('ILAKLAWXVC');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_PKTBSTATI=l_Appl.GetStringValue('CODSTA',3,0);
w_dessta=l_Appl.GetStringValue('DESCRI',30,0);
w_SIGLA=l_Appl.GetStringValue('SIGLA',4,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_ILAKLAWXVC_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_ILAKLAWXVC';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_ILAKLAWXVC();
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
function Link_ILAKLAWXVC_Blank() {
w_PKTBSTATI='';
w_dessta='';
w_SIGLA='';
}
function LOpt_ILAKLAWXVC() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstati','C'));
l_oWv.setValue('Linkzoomprg',WtA('armt_stati','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODSTA','C'));
l_oWv.setValue('LinkedField',WtA('CODSTA','C'));
l_oWv.setValue('UID',WtA('ILAKLAWXVC','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['ILAKLAWXVC'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('7383187'),'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'ILAKLAWXVC')) {
last_focused_comp=GetLastFocusedElementOfLink('ILAKLAWXVC');
function SetMethod_ILAKLAWXVC() {
Set_PKTBSTATI(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_ILAKLAWXVC();
} else {
setTimeout(SetMethod_ILAKLAWXVC,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'ILAKLAWXVC')) {
return [Ctrl('ILAKLAWXVC')];
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
parent.ZtVWeb.raiseEventToEvalParms('armt_citta_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('armt_citta_dataNotSent',{'action':formaction});
}
}
}
}
CheckChild.child=[];
function Check() {
var l_bResult = true;
ResetErrorVars();
m_nLastError=0;
if ( ! (_ChkObl('FFTGLGUVGJ',1))) {
_SignErr('FFTGLGUVGJ');
m_cLastWorkVarErrorMsg='112851763';
l_bResult=false;
w_IDBASE=HtW('','C');
} else if ( ! (_ChkObl('BLYSPBZZDM',1))) {
_SignErr('BLYSPBZZDM');
m_cLastWorkVarErrorMsg='2063759932';
l_bResult=false;
w_CITTA=HtW('','C');
} else if ( ! (_ChkObl('SJMGCCLAYZ',1))) {
_SignErr('SJMGCCLAYZ');
m_cLastWorkVarErrorMsg='18003';
l_bResult=false;
w_CAB=HtW('','C');
} else if ( ! (_ChkObl('TWBJLTWWLG',1))) {
_SignErr('TWBJLTWWLG');
m_cLastWorkVarErrorMsg='10095365423';
l_bResult=false;
w_PROV=HtW('','C');
} else if ( ! (_ChkObl('PQBULAVLOC',1))) {
_SignErr('PQBULAVLOC');
m_cLastWorkVarErrorMsg='21587';
l_bResult=false;
w_CAP=HtW('','C');
} else if ( ! (_ChkObl('ILAKLAWXVC',1))) {
_SignErr('ILAKLAWXVC');
m_cLastWorkVarErrorMsg='7776403';
l_bResult=false;
w_PKTBSTATI=HtW('','C');
} else if ( ! (_ChkObl('ZRZJZIUNUE',1))) {
_SignErr('ZRZJZIUNUE');
m_cLastWorkVarErrorMsg='6827491';
l_bResult=false;
w_SIGLA=HtW('','C');
} else if ( ! (_ChkObl('GKAEUHPNIS',1))) {
_SignErr('GKAEUHPNIS');
m_cLastWorkVarErrorMsg='11066636183';
l_bResult=false;
w_PREF=HtW('','C');
} else if ( ! (_ChkObl('UUHPGKPAGJ',1))) {
_SignErr('UUHPGKPAGJ');
m_cLastWorkVarErrorMsg='11228963386';
l_bResult=false;
w_IDISTAT=HtW('','C');
} else if ( ! (_ChkObl('QEXCLHUJUO',1))) {
_SignErr('QEXCLHUJUO');
m_cLastWorkVarErrorMsg='1817574818';
l_bResult=false;
w_IDREGIO=HtW('','C');
}
if (l_bResult) {
l_bResult=CheckChild(0);
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('ILAKLAWXVC_ZOOM',lc)) {
return 0;
}
if (Eq('ILAKLAWXVC',lc)) {
return 0;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_ILAKLAWXVC();
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
l_oWv.setValue('IDBASE',WtA(w_IDBASE,'C'));
l_oWv.setValue('op_IDBASE',WtA(op_IDBASE,'C'));
l_oWv.setValue('CITTA',WtA(w_CITTA,'C'));
l_oWv.setValue('CAB',WtA(w_CAB,'C'));
l_oWv.setValue('PROV',WtA(w_PROV,'C'));
l_oWv.setValue('CAP',WtA(w_CAP,'C'));
l_oWv.setValue('PKTBSTATI',WtA(w_PKTBSTATI,'C'));
l_oWv.setValue('SIGLA',WtA(w_SIGLA,'C'));
l_oWv.setValue('PREF',WtA(w_PREF,'C'));
l_oWv.setValue('IDISTAT',WtA(w_IDISTAT,'C'));
l_oWv.setValue('IDREGIO',WtA(w_IDREGIO,'C'));
l_oWv.setValue('dessta',WtA(w_dessta,'C'));
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
FillWv.n=["IDBASE","CITTA","CAB","PROV","CAP","PKTBSTATI","SIGLA","PREF","IDISTAT","IDREGIO","dessta"];
function SetModified() {
m_bUpdated=true;
}