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
function Set_CACODICE(ctrlValue,kmode,e) {
if (Ne(w_CACODICE,ctrlValue)) {
var ctl = _GetCtl(e,'HYBRJINCEX');
if (_tracker.goon(ctl,ctrlValue)) {
w_CACODICE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HYBRJINCEX',0);
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
function Set_CADESCRI(ctrlValue,kmode,e) {
if (Ne(w_CADESCRI,ctrlValue)) {
var ctl = _GetCtl(e,'CHXZERJJZJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_CADESCRI=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CHXZERJJZJ',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',90,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_CACODANA(ctrlValue,kmode,e) {
if (Ne(w_CACODANA,ctrlValue)) {
var ctl = _GetCtl(e,'VDOLZFWZIW');
if (_tracker.goon(ctl,ctrlValue)) {
w_CACODANA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VDOLZFWZIW',0);
if (l_bResult) {
l_bResult=Link_VDOLZFWZIW(kmode);
if ( ! (l_bResult)) {
w_CACODANA=HtW('','C');
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
function Set_CACODSIN(ctrlValue,kmode,e) {
if (Ne(w_CACODSIN,ctrlValue)) {
var ctl = _GetCtl(e,'DMYIBOGLPB');
if (_tracker.goon(ctl,ctrlValue)) {
w_CACODSIN=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('DMYIBOGLPB',0);
if (l_bResult) {
l_bResult=Link_DMYIBOGLPB(kmode);
if ( ! (l_bResult)) {
w_CACODSIN=HtW('','C');
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
function Set_CAFLGOPE(ctrlValue,kmode,e) {
if (Ne(w_CAFLGOPE,ctrlValue)) {
var ctl = _GetCtl(e,'CAZXFCMTRO');
if (_tracker.goon(ctl,ctrlValue)) {
w_CAFLGOPE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CAZXFCMTRO',0);
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
function Set_CAFLGAUI(ctrlValue,kmode,e) {
if (Ne(w_CAFLGAUI,ctrlValue)) {
var ctl = _GetCtl(e,'VDGKIUDVJY');
if (_tracker.goon(ctl,ctrlValue)) {
w_CAFLGAUI=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VDGKIUDVJY',0);
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
function Set_CASEGNO(ctrlValue,kmode,e) {
if (Ne(w_CASEGNO,ctrlValue)) {
var ctl = _GetCtl(e,'CRBMFUASKW');
if (_tracker.goon(ctl,ctrlValue)) {
w_CASEGNO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CRBMFUASKW',0);
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
function Set_CATIPOPE(ctrlValue,kmode,e) {
if (Ne(w_CATIPOPE,ctrlValue)) {
var ctl = _GetCtl(e,'RIBSWSIRGO');
if (_tracker.goon(ctl,ctrlValue)) {
w_CATIPOPE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RIBSWSIRGO',0);
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
function Set_CAFLGDIP(ctrlValue,kmode,e) {
if (Ne(w_CAFLGDIP,ctrlValue)) {
var ctl = _GetCtl(e,'BISHTFICXQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_CAFLGDIP=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BISHTFICXQ',0);
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
function Link_VDOLZFWZIW(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CACODANA);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODCAU',w_CACODANA,4,0);
l_Appl.SetFields('CODCAU,DESCRI,CAUSINT,SEGNO');
l_Appl.SetTypes('C,C,C,C');
l_Appl.LinkTable('tbcauana');
l_Appl.SetID('VDOLZFWZIW');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CACODANA=l_Appl.GetStringValue('CODCAU',4,0);
w_xdescauana=l_Appl.GetStringValue('DESCRI',165,0);
w_CACODSIN=l_Appl.GetStringValue('CAUSINT',2,0);
w_CASEGNO=l_Appl.GetStringValue('SEGNO',1,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_VDOLZFWZIW_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_VDOLZFWZIW';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_VDOLZFWZIW();
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
function Link_VDOLZFWZIW_Blank() {
w_CACODANA='';
w_xdescauana='';
w_CACODSIN='';
w_CASEGNO='';
}
function LOpt_VDOLZFWZIW() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcauana','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODCAU','C'));
l_oWv.setValue('LinkedField',WtA('CODCAU','C'));
l_oWv.setValue('UID',WtA('VDOLZFWZIW','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['VDOLZFWZIW'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('282647084'),'C'));
return l_oWv;
}
function Link_DMYIBOGLPB(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CACODSIN);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODVOC',w_CACODSIN,2,0);
l_Appl.SetFields('CODVOC,DESCRIZ');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbcausin');
l_Appl.SetID('DMYIBOGLPB');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CACODSIN=l_Appl.GetStringValue('CODVOC',2,0);
w_xdescausin=l_Appl.GetStringValue('DESCRIZ',165,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_DMYIBOGLPB_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_DMYIBOGLPB';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_DMYIBOGLPB();
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
function Link_DMYIBOGLPB_Blank() {
w_CACODSIN='';
w_xdescausin='';
}
function LOpt_DMYIBOGLPB() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcausin','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODVOC','C'));
l_oWv.setValue('LinkedField',WtA('CODVOC','C'));
l_oWv.setValue('UID',WtA('DMYIBOGLPB','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['DMYIBOGLPB'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('282420974'),'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'VDOLZFWZIW')) {
last_focused_comp=GetLastFocusedElementOfLink('VDOLZFWZIW');
function SetMethod_VDOLZFWZIW() {
Set_CACODANA(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_VDOLZFWZIW();
} else {
setTimeout(SetMethod_VDOLZFWZIW,1);
}
bResult=true;
}
if (Eq(varName,'DMYIBOGLPB')) {
last_focused_comp=GetLastFocusedElementOfLink('DMYIBOGLPB');
function SetMethod_DMYIBOGLPB() {
Set_CACODSIN(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_DMYIBOGLPB();
} else {
setTimeout(SetMethod_DMYIBOGLPB,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'VDOLZFWZIW')) {
return [Ctrl('VDOLZFWZIW')];
}
if (Eq(varName,'DMYIBOGLPB')) {
return [Ctrl('DMYIBOGLPB')];
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
parent.ZtVWeb.raiseEventToEvalParms('armt_cgo_causali_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('armt_cgo_causali_dataNotSent',{'action':formaction});
}
}
}
}
CheckChild.child=[];
function Check() {
var l_bResult = true;
ResetErrorVars();
m_nLastError=0;
if ( ! (_ChkObl('HYBRJINCEX',1))) {
_SignErr('HYBRJINCEX');
m_cLastWorkVarErrorMsg='1568441828';
l_bResult=false;
w_CACODICE=HtW('','C');
} else if ( ! (_ChkObl('CHXZERJJZJ',1))) {
_SignErr('CHXZERJJZJ');
m_cLastWorkVarErrorMsg='285808099';
l_bResult=false;
w_CADESCRI=HtW('','C');
} else if ( ! (_ChkObl('VDOLZFWZIW',1))) {
_SignErr('VDOLZFWZIW');
m_cLastWorkVarErrorMsg='215537109';
l_bResult=false;
w_CACODANA=HtW('','C');
} else if ( ! (_ChkObl('DMYIBOGLPB',1))) {
_SignErr('DMYIBOGLPB');
m_cLastWorkVarErrorMsg='215310487';
l_bResult=false;
w_CACODSIN=HtW('','C');
} else if ( ! (_ChkObl('CRBMFUASKW',1))) {
_SignErr('CRBMFUASKW');
m_cLastWorkVarErrorMsg='7753123';
l_bResult=false;
w_CASEGNO=HtW('','C');
} else if ( ! (_ChkObl('RIBSWSIRGO',1))) {
_SignErr('RIBSWSIRGO');
m_cLastWorkVarErrorMsg='829257574';
l_bResult=false;
w_CATIPOPE=HtW('','C');
} else if ( ! (_ChkObl('BISHTFICXQ',1))) {
_SignErr('BISHTFICXQ');
m_cLastWorkVarErrorMsg='1821093580';
l_bResult=false;
w_CAFLGDIP='N';
} else if ( ! (_ChkObl('CAZXFCMTRO',1))) {
_SignErr('CAZXFCMTRO');
m_cLastWorkVarErrorMsg='655285418';
l_bResult=false;
w_CAFLGOPE=HtW('','C');
} else if ( ! (_ChkObl('VDGKIUDVJY',1))) {
_SignErr('VDGKIUDVJY');
m_cLastWorkVarErrorMsg='1814624740';
l_bResult=false;
w_CAFLGAUI='N';
}
if (l_bResult) {
l_bResult=CheckChild(0);
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('HYBRJINCEX_ZOOM',lc)) {
return 0;
}
if (Eq('CHXZERJJZJ_ZOOM',lc)) {
return 0;
}
if (Eq('VDOLZFWZIW_ZOOM',lc)) {
return 0;
}
if (Eq('VDOLZFWZIW',lc)) {
return 0;
}
if (Eq('DMYIBOGLPB_ZOOM',lc)) {
return 1;
}
if (Eq('DMYIBOGLPB',lc)) {
return 1;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_VDOLZFWZIW();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,1)) {
l_oWv=LOpt_DMYIBOGLPB();
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
l_oWv.setValue('CACODICE',WtA(w_CACODICE,'C'));
l_oWv.setValue('CADESCRI',WtA(w_CADESCRI,'C'));
l_oWv.setValue('CACODANA',WtA(w_CACODANA,'C'));
l_oWv.setValue('CACODSIN',WtA(w_CACODSIN,'C'));
l_oWv.setValue('CASEGNO',WtA(w_CASEGNO,'C'));
l_oWv.setValue('CATIPOPE',WtA(w_CATIPOPE,'C'));
l_oWv.setValue('CAFLGDIP',WtA(w_CAFLGDIP,'C'));
l_oWv.setValue('CAFLGOPE',WtA(w_CAFLGOPE,'C'));
l_oWv.setValue('CAFLGAUI',WtA(w_CAFLGAUI,'C'));
l_oWv.setValue('xdescauana',WtA(w_xdescauana,'C'));
l_oWv.setValue('xdescausin',WtA(w_xdescausin,'C'));
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
FillWv.n=["CACODICE","CADESCRI","CACODANA","CACODSIN","CASEGNO","CATIPOPE","CAFLGDIP","CAFLGOPE","CAFLGAUI","xdescauana","xdescausin"];
function SetModified() {
m_bUpdated=true;
}
