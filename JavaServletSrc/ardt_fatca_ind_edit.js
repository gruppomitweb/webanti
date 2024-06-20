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
SetErrorField('IFBCBPALEW',false);
SetErrorField('UEPBJLELZW',false);
SetErrorField('ZMPPOYZHNV',false);
SetErrorField('FTFJYPXWVP',false);
SetErrorField('KVIVWRVRKO',false);
SetErrorField('OVMPQUGMRG',false);
SetErrorField('LFXQHONWYG',false);
SetErrorField('OFHLLCOTUR',false);
SetErrorField('RATJAZVXAR',false);
SetErrorField('NDGHNAKVLA',false);
SetErrorField('VRPGIQEPBU',false);
}
function Set_DISTRICTNA(ctrlValue,kmode,e) {
if (Ne(w_DISTRICTNA,ctrlValue)) {
var ctl = _GetCtl(e,'FTFJYPXWVP');
if (_tracker.goon(ctl,ctrlValue)) {
w_DISTRICTNA=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FTFJYPXWVP',0);
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
function Set_CAREOF(ctrlValue,kmode,e) {
if (Ne(w_CAREOF,ctrlValue)) {
var ctl = _GetCtl(e,'ZMPPOYZHNV');
if (_tracker.goon(ctl,ctrlValue)) {
w_CAREOF=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ZMPPOYZHNV',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',80,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_COUNTRYCOD(ctrlValue,kmode,e) {
if (Ne(w_COUNTRYCOD,ctrlValue)) {
var ctl = _GetCtl(e,'QXOWROTOBD');
if (_tracker.goon(ctl,ctrlValue)) {
w_COUNTRYCOD=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QXOWROTOBD',0);
if (l_bResult) {
l_bResult=Link_QXOWROTOBD(kmode);
if ( ! (l_bResult)) {
w_COUNTRYCOD=HtW('','C');
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
function Set_COUNTRYSUB(ctrlValue,kmode,e) {
if (Ne(w_COUNTRYSUB,ctrlValue)) {
var ctl = _GetCtl(e,'YEXJRJTWPN');
if (_tracker.goon(ctl,ctrlValue)) {
w_COUNTRYSUB=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YEXJRJTWPN',0);
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
function Set_ADDRESSTYP(ctrlValue,kmode,e) {
if (Ne(w_ADDRESSTYP,ctrlValue)) {
var ctl = _GetCtl(e,'WAXZSYSKZJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_ADDRESSTYP=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('WAXZSYSKZJ',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',7,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_TEL(ctrlValue,kmode,e) {
if (Ne(w_TEL,ctrlValue)) {
var ctl = _GetCtl(e,'IFBCBPALEW');
if (_tracker.goon(ctl,ctrlValue)) {
w_TEL=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('IFBCBPALEW',0);
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
function Set_EMAIL(ctrlValue,kmode,e) {
if (Ne(w_EMAIL,ctrlValue)) {
var ctl = _GetCtl(e,'UEPBJLELZW');
if (_tracker.goon(ctl,ctrlValue)) {
w_EMAIL=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UEPBJLELZW',0);
if (l_bResult) {
l_bResult=arfn_emailok(w_EMAIL);
if ( ! (l_bResult)) {
m_nLastError=2;
m_cLastWorkVarErrorMsg='EMAIL';
m_cLastMsgError=AlertErrorMessage('11525797640');
}
if ( ! (l_bResult)) {
w_EMAIL=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',50,0,''));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',50,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_CITY(ctrlValue,kmode,e) {
if (Ne(w_CITY,ctrlValue)) {
var ctl = _GetCtl(e,'OVMPQUGMRG');
if (_tracker.goon(ctl,ctrlValue)) {
w_CITY=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('OVMPQUGMRG',0);
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
function Set_SUITEIDENT(ctrlValue,kmode,e) {
if (Ne(w_SUITEIDENT,ctrlValue)) {
var ctl = _GetCtl(e,'NDGHNAKVLA');
if (_tracker.goon(ctl,ctrlValue)) {
w_SUITEIDENT=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NDGHNAKVLA',0);
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
function Set_POB(ctrlValue,kmode,e) {
if (Ne(w_POB,ctrlValue)) {
var ctl = _GetCtl(e,'VRPGIQEPBU');
if (_tracker.goon(ctl,ctrlValue)) {
w_POB=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VRPGIQEPBU',0);
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
function Set_POSTCODE(ctrlValue,kmode,e) {
if (Ne(w_POSTCODE,ctrlValue)) {
var ctl = _GetCtl(e,'KVIVWRVRKO');
if (_tracker.goon(ctl,ctrlValue)) {
w_POSTCODE=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('KVIVWRVRKO',0);
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
function Set_STREET(ctrlValue,kmode,e) {
if (Ne(w_STREET,ctrlValue)) {
var ctl = _GetCtl(e,'LFXQHONWYG');
if (_tracker.goon(ctl,ctrlValue)) {
w_STREET=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('LFXQHONWYG',0);
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
function Set_BUILDINGID(ctrlValue,kmode,e) {
if (Ne(w_BUILDINGID,ctrlValue)) {
var ctl = _GetCtl(e,'OFHLLCOTUR');
if (_tracker.goon(ctl,ctrlValue)) {
w_BUILDINGID=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('OFHLLCOTUR',0);
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
function Set_FLOORIDENT(ctrlValue,kmode,e) {
if (Ne(w_FLOORIDENT,ctrlValue)) {
var ctl = _GetCtl(e,'RATJAZVXAR');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLOORIDENT=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RATJAZVXAR',0);
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
function Check_ACAOQGBTKF(p_bForce) {
var l_bResult = true;
if (p_bForce) {
l_bResult=arfn_chk_sl_fatca(w_CPROWNUM,w_ADDRESSTYP,w_tipoIND);
if ( ! (l_bResult) &&  ! (WindowConfirm(AlertErrorMessage('1491819048')))) {
m_nLastError=-3;
} else {
l_bResult=true;
}
}
return l_bResult;
}
function SaveDependsOn() {
}
function SaveLabelDependsOn() {
}
function Sugg_QXOWROTOBD(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_Appl = LinkApplet();
var l_bEmp = Empty(HtW(Ctrl('QXOWROTOBD').value,'C'));
l_Appl.SetStringKey('ISO2',HtW(Ctrl('QXOWROTOBD').value,'C'),2,0);
l_Appl.SetFields('ISO2,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbstati');
l_Appl.SetID('QXOWROTOBD');
l_Appl.SetMode('suggest');
l_Appl.SetRows('10');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
var res = l_Appl.GetJSONData();
SuggesterLib.render_suggest(res,'QXOWROTOBD','QXOWROTOBD',true,'','',0);
return l_bResult;
}
SuggesterLib.select_suggest.QXOWROTOBD=["COUNTRYCOD",[null,null],function(newval) { return HtW(newval,'C')}];
function Link_QXOWROTOBD(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_COUNTRYCOD);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('ISO2',w_COUNTRYCOD,2,0);
l_Appl.SetFields('ISO2,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbstati');
l_Appl.SetID('QXOWROTOBD');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_COUNTRYCOD=l_Appl.GetStringValue('ISO2',2,0);
w_xdescpaese=l_Appl.GetStringValue('DESCRI',40,0);
l_Appl.GetLinkHash(GetRepeatedCheckVars());
} else {
Link_QXOWROTOBD_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_QXOWROTOBD';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_QXOWROTOBD();
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
function Link_QXOWROTOBD_Blank() {
w_COUNTRYCOD='';
w_xdescpaese='';
}
function LOpt_QXOWROTOBD() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstati','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('ISO2','C'));
l_oWv.setValue('LinkedField',WtA('ISO2','C'));
l_oWv.setValue('UID',WtA('QXOWROTOBD','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['QXOWROTOBD'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('11167010090'),'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'QXOWROTOBD')) {
last_focused_comp=GetLastFocusedElementOfLink('QXOWROTOBD');
function SetMethod_QXOWROTOBD() {
Set_COUNTRYCOD(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_QXOWROTOBD();
} else {
setTimeout(SetMethod_QXOWROTOBD,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'QXOWROTOBD')) {
return [Ctrl('QXOWROTOBD')];
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
if ( ! (m_oFather.SaveContext_ardt_fatca_ind())) {
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
parent.ZtVWeb.raiseEventToEvalParms('ardt_fatca_ind_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('ardt_fatca_ind_dataNotSent',{'action':formaction});
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
if (Eq('QXOWROTOBD_ZOOM',lc)) {
return 0;
}
if (Eq('QXOWROTOBD',lc)) {
return 0;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_QXOWROTOBD();
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
l_oWv.setValue('CONNES',WtA(w_CONNES,'C'));
l_oWv.setValue('tipoIND',WtA(w_tipoIND,'M'));
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
FillWv.n=["CONNES","tipoIND"];
function CheckRow(w) {
var l_bResult = true;
ResetErrorVars();
if (Le(m_nCurrentRow,Rows())) {
if (( ! (_ChkObl('QXOWROTOBD',1))) && FullRow()) {
_SignErr('QXOWROTOBD');
m_cLastWorkVarErrorMsg='COUNTRYCOD';
l_bResult=false;
w_COUNTRYCOD=HtW('','C');
} else if (( ! (_ChkObl('YEXJRJTWPN',1))) && FullRow()) {
_SignErr('YEXJRJTWPN');
m_cLastWorkVarErrorMsg='COUNTRYSUB';
l_bResult=false;
w_COUNTRYSUB=HtW('','C');
} else if (( ! (_ChkObl('WAXZSYSKZJ',1))) && FullRow()) {
_SignErr('WAXZSYSKZJ');
m_cLastWorkVarErrorMsg='132341360';
l_bResult=false;
w_ADDRESSTYP=HtW('','C');
} else if (( ! (_ChkObl('IFBCBPALEW',1))) && FullRow()) {
_SignErr('IFBCBPALEW');
m_cLastWorkVarErrorMsg='TEL';
l_bResult=false;
w_TEL=HtW('','C');
} else if ((( ! (_ChkObl('UEPBJLELZW',1))) || ( ! (arfn_emailok(w_EMAIL)))) && FullRow()) {
_SignErr('UEPBJLELZW','11525797640');
l_bResult=false;
w_EMAIL=HtW('','C');
} else if (( ! (_ChkObl('ZMPPOYZHNV',1))) && FullRow()) {
_SignErr('ZMPPOYZHNV');
m_cLastWorkVarErrorMsg='CAREOF';
l_bResult=false;
w_CAREOF=HtW('','C');
} else if (( ! (_ChkObl('FTFJYPXWVP',1))) && FullRow()) {
_SignErr('FTFJYPXWVP');
m_cLastWorkVarErrorMsg='DISTRICTNA';
l_bResult=false;
w_DISTRICTNA=HtW('','C');
} else if (( ! (_ChkObl('KVIVWRVRKO',1))) && FullRow()) {
_SignErr('KVIVWRVRKO');
m_cLastWorkVarErrorMsg='POSTCODE';
l_bResult=false;
w_POSTCODE=HtW('','C');
} else if (( ! (_ChkObl('OVMPQUGMRG',1))) && FullRow()) {
_SignErr('OVMPQUGMRG');
m_cLastWorkVarErrorMsg='CITY';
l_bResult=false;
w_CITY=HtW('','C');
} else if (( ! (_ChkObl('LFXQHONWYG',1))) && FullRow()) {
_SignErr('LFXQHONWYG');
m_cLastWorkVarErrorMsg='STREET';
l_bResult=false;
w_STREET=HtW('','C');
} else if (( ! (_ChkObl('OFHLLCOTUR',1))) && FullRow()) {
_SignErr('OFHLLCOTUR');
m_cLastWorkVarErrorMsg='BUILDINGID';
l_bResult=false;
w_BUILDINGID=HtW('','C');
} else if (( ! (_ChkObl('RATJAZVXAR',1))) && FullRow()) {
_SignErr('RATJAZVXAR');
m_cLastWorkVarErrorMsg='FLOORIDENT';
l_bResult=false;
w_FLOORIDENT=HtW('','C');
} else if (( ! (_ChkObl('NDGHNAKVLA',1))) && FullRow()) {
_SignErr('NDGHNAKVLA');
m_cLastWorkVarErrorMsg='SUITEIDENT';
l_bResult=false;
w_SUITEIDENT=HtW('','C');
} else if (( ! (_ChkObl('VRPGIQEPBU',1))) && FullRow()) {
_SignErr('VRPGIQEPBU');
m_cLastWorkVarErrorMsg='POB';
l_bResult=false;
w_POB=HtW('','C');
} else if (( ! (Check_ACAOQGBTKF(true))) && FullRow()) {
l_bResult = false;
}
}
if (FullRow()) {
if (l_bResult) {
l_bResult=CheckChild(1);
}
}
DisableChainedLinks(true);
// * --- Area Manuale = UI - Check Row
// * --- ardt_fatca_ind
w_tipoIND = w_tipoIND + "-"+LRTrim(Str(w_CPROWNUM,4,0))+"."+w_ADDRESSTYP
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
m_oFather.SetModified_ardt_fatca_ind();
}
}
SaveContext.child=[];
function BlankRow() {
w_COUNTRYCOD='';
w_COUNTRYSUB='';
w_ADDRESSTYP='';
w_TEL='';
w_EMAIL='';
w_IDBASE='';
w_CAREOF='';
w_DISTRICTNA='';
w_POSTCODE='';
w_CITY='';
w_STREET='';
w_BUILDINGID='';
w_FLOORIDENT='';
w_SUITEIDENT='';
w_POB='';
w_xdescpaese='';
if ( ! (EmptyString(w_COUNTRYCOD))) {
Link_QXOWROTOBD(null);
}
BlankRowChild();
if (m_bExtended) {
BlankRepeatedExtendedFields();
}
SaveDependsOn();
LoadContext(true);
}
function FullRow() {
return  ! (Empty(w_COUNTRYCOD));
}
function GetRepeatedFields() {
var l_aRepeatedFields;
l_aRepeatedFields={};
l_aRepeatedFields.COUNTRYCOD={"dec":0,"fixedpos":false,"id":"QXOWROTOBD","len":2,"name":"COUNTRYCOD","title":"","type":"C"};
l_aRepeatedFields.COUNTRYSUB={"dec":0,"fixedpos":false,"id":"YEXJRJTWPN","len":30,"name":"COUNTRYSUB","title":"","type":"C"};
l_aRepeatedFields.ADDRESSTYP={"dec":0,"fixedpos":false,"id":"WAXZSYSKZJ","len":7,"name":"ADDRESSTYP","title":"Via\/Piazza","type":"C"};
l_aRepeatedFields.TEL={"dec":0,"fixedpos":true,"id":"IFBCBPALEW","len":40,"name":"TEL","title":"","type":"C"};
l_aRepeatedFields.EMAIL={"dec":0,"fixedpos":true,"id":"UEPBJLELZW","len":50,"name":"EMAIL","title":"","type":"C"};
l_aRepeatedFields.IDBASE={"dec":0,"fixedpos":false,"id":"GXFSMRKMPW","len":10,"name":"IDBASE","title":"IDRIGA","type":"C"};
l_aRepeatedFields.CAREOF={"dec":0,"fixedpos":true,"id":"ZMPPOYZHNV","len":80,"name":"CAREOF","title":"","type":"C"};
l_aRepeatedFields.DISTRICTNA={"dec":0,"fixedpos":true,"id":"FTFJYPXWVP","len":30,"name":"DISTRICTNA","title":"","type":"C"};
l_aRepeatedFields.POSTCODE={"dec":0,"fixedpos":true,"id":"KVIVWRVRKO","len":20,"name":"POSTCODE","title":"","type":"C"};
l_aRepeatedFields.CITY={"dec":0,"fixedpos":true,"id":"OVMPQUGMRG","len":40,"name":"CITY","title":"","type":"C"};
l_aRepeatedFields.STREET={"dec":0,"fixedpos":true,"id":"LFXQHONWYG","len":60,"name":"STREET","title":"","type":"C"};
l_aRepeatedFields.BUILDINGID={"dec":0,"fixedpos":true,"id":"OFHLLCOTUR","len":20,"name":"BUILDINGID","title":"","type":"C"};
l_aRepeatedFields.FLOORIDENT={"dec":0,"fixedpos":true,"id":"RATJAZVXAR","len":20,"name":"FLOORIDENT","title":"","type":"C"};
l_aRepeatedFields.SUITEIDENT={"dec":0,"fixedpos":true,"id":"NDGHNAKVLA","len":20,"name":"SUITEIDENT","title":"","type":"C"};
l_aRepeatedFields.POB={"dec":0,"fixedpos":true,"id":"VRPGIQEPBU","len":20,"name":"POB","title":"","type":"C"};
l_aRepeatedFields.xdescpaese={"dec":0,"fixedpos":false,"id":"DQKSNSLDIM","len":40,"name":"xdescpaese","title":"Descrizione","type":"C"};
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
if(c=Ctrl('IFBCBPALEW')) SetDisabled(c,true);
if(c=Ctrl('UEPBJLELZW')) SetDisabled(c,true);
if(c=Ctrl('ZMPPOYZHNV')) SetDisabled(c,true);
if(c=Ctrl('FTFJYPXWVP')) SetDisabled(c,true);
if(c=Ctrl('KVIVWRVRKO')) SetDisabled(c,true);
if(c=Ctrl('OVMPQUGMRG')) SetDisabled(c,true);
if(c=Ctrl('LFXQHONWYG')) SetDisabled(c,true);
if(c=Ctrl('OFHLLCOTUR')) SetDisabled(c,true);
if(c=Ctrl('RATJAZVXAR')) SetDisabled(c,true);
if(c=Ctrl('NDGHNAKVLA')) SetDisabled(c,true);
if(c=Ctrl('VRPGIQEPBU')) SetDisabled(c,true);
SetQueryRow(Ctrl('GridTable'),false);
} else {
SetEditRow(Ctrl('GridTable'),false);
var c;
if(c=Ctrl('IFBCBPALEW')) SetDisabled(c,false);
if(c=Ctrl('UEPBJLELZW')) SetDisabled(c,false);
if(c=Ctrl('ZMPPOYZHNV')) SetDisabled(c,false);
if(c=Ctrl('FTFJYPXWVP')) SetDisabled(c,false);
if(c=Ctrl('KVIVWRVRKO')) SetDisabled(c,false);
if(c=Ctrl('OVMPQUGMRG')) SetDisabled(c,false);
if(c=Ctrl('LFXQHONWYG')) SetDisabled(c,false);
if(c=Ctrl('OFHLLCOTUR')) SetDisabled(c,false);
if(c=Ctrl('RATJAZVXAR')) SetDisabled(c,false);
if(c=Ctrl('NDGHNAKVLA')) SetDisabled(c,false);
if(c=Ctrl('VRPGIQEPBU')) SetDisabled(c,false);
EnableControlsUnderCondition(false);
}
m_bChildDisabled=enable;
}
