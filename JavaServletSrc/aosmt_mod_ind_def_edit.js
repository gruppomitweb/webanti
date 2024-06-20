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
function DisplayErrorMessage_aosdt_ind_def() {
if ( ! (ChildToLoad(FrameRef('aosdt_ind_def'))) && Ne(typeof(FrameRef('aosdt_ind_def').DisplayErrorMessage),'undefined')) {
FrameRef('aosdt_ind_def').DisplayErrorMessage();
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
l_bEnabled= ! (Ne(EntityStatus(),'N')) || IsDisabledByStateDriver('show_noapplic');
SetDisabled('ETQZOSKLPW',l_bEnabled);
LibJavascript.forEachItem(m_FoundlingEditExpression,i_body_0)
function i_body_0(child){
child();
}
DisableUI();
HideControlsUnderCondition();
ObligatoryControlsUnderCondition();
ExpandCollapseBoxesUnderCondition();
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
function Set_IDMOD(ctrlValue,kmode,e) {
if (Ne(w_IDMOD,ctrlValue)) {
var ctl = _GetCtl(e,'NCOATMFFKT');
if (_tracker.goon(ctl,ctrlValue)) {
w_IDMOD=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NCOATMFFKT',0);
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
function Set_IDMODMIT(ctrlValue,kmode,e) {
if (Ne(w_IDMODMIT,ctrlValue)) {
var ctl = _GetCtl(e,'HKGLDDMZGV');
if (_tracker.goon(ctl,ctrlValue)) {
w_IDMODMIT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HKGLDDMZGV',0);
if (l_bResult) {
l_bResult=Link_HKGLDDMZGV(kmode);
if ( ! (l_bResult)) {
w_IDMODMIT=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',10,0,''));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',10,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_DESCRI(ctrlValue,kmode,e) {
if (Ne(w_DESCRI,ctrlValue)) {
var ctl = _GetCtl(e,'YZXQRACPYA');
if (_tracker.goon(ctl,ctrlValue)) {
w_DESCRI=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YZXQRACPYA',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',200,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_DTFINVAL(ctrlValue,kmode,e) {
if (Ne(w_DTFINVAL,ctrlValue)) {
var ctl = _GetCtl(e,'CGQOPHKKPM');
if (_tracker.goon(ctl,ctrlValue)) {
w_DTFINVAL=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CGQOPHKKPM',0);
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
function Set_show_noapplic(ctrlValue,kmode,e) {
if (Ne(w_show_noapplic,ctrlValue)) {
var ctl = _GetCtl(e,'ETQZOSKLPW');
if (_tracker.goon(ctl,ctrlValue)) {
w_show_noapplic=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ETQZOSKLPW',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH(false,'L',1,0,'');
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
if ( ! (ChildToLoad(FrameRef('aosdt_ind_def'))) && Ne(typeof(FrameRef('aosdt_ind_def').DoUpdate),'undefined')) {
CopyWorkVar(FrameRef('aosdt_ind_def'),['show_noapplic'],['show_noapplic'],true)
}
if ((Ne(o_show_noapplic,w_show_noapplic))) {
Calculation_EGNRDHPCPU();
}
LibJavascript.forEachItem(m_FoundlingCopyWorkVar,i_body_1)
function i_body_1(child){
child();
}
// * --- Area Manuale = UI - Calculate
// * --- aosmt_mod_ind_def
if ((Ne(o_show_noapplic,w_show_noapplic))){
   Ctrl('SGBDWLUNZC').src='aosdt_ind_def?m_bInnerChild=true&m_cAction=editload&IDMOD='+LRTrim(w_IDMOD)+'&m_bRowsChild=true';
}
// * --- Fine Area Manuale
m_bCalculating=false;
}
function Calculation_EGNRDHPCPU() {
w_pippo=1;
}
function SaveDependsOn() {
o_show_noapplic=w_show_noapplic;
}
function SaveLabelDependsOn() {
}
function Link_HKGLDDMZGV(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_IDMODMIT);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('IDMOD',w_IDMODMIT,10,0);
l_Appl.SetFields('IDMOD');
l_Appl.SetTypes('C');
l_Appl.LinkTable('mod_ind_mit');
l_Appl.SetLinkzoom('aosmt_mod_ind_mit');
l_Appl.SetID('HKGLDDMZGV');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_IDMODMIT=l_Appl.GetStringValue('IDMOD',10,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_HKGLDDMZGV_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_HKGLDDMZGV';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_HKGLDDMZGV();
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
function Link_HKGLDDMZGV_Blank() {
w_IDMODMIT='';
}
function LOpt_HKGLDDMZGV() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('mod_ind_mit','C'));
l_oWv.setValue('Linkzoomprg',WtA('aosmt_mod_ind_mit','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('IDMOD','C'));
l_oWv.setValue('LinkedField',WtA('IDMOD','C'));
l_oWv.setValue('UID',WtA('HKGLDDMZGV','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['HKGLDDMZGV'][1],'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'HKGLDDMZGV')) {
last_focused_comp=GetLastFocusedElementOfLink('HKGLDDMZGV');
function SetMethod_HKGLDDMZGV() {
Set_IDMODMIT(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_HKGLDDMZGV();
} else {
setTimeout(SetMethod_HKGLDDMZGV,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'HKGLDDMZGV')) {
return [Ctrl('HKGLDDMZGV')];
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
parent.ZtVWeb.raiseEventToEvalParms('aosmt_mod_ind_def_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('aosmt_mod_ind_def_dataNotSent',{'action':formaction});
}
}
}
}
CheckChild.child=[{'prg':"aosdt_ind_def",'BOScId':function(){ return FrameRef('aosdt_ind_def')},'repeated':0}];
function Check() {
var l_bResult = true;
var l_bChildCheck = true;
ResetErrorVars();
m_nLastError=0;
if ( ! (_ChkObl('NCOATMFFKT',1))) {
_SignErr('NCOATMFFKT');
m_cLastWorkVarErrorMsg='10024211400';
l_bResult=false;
w_IDMOD=HtW('','C');
} else if ( ! (_ChkObl('HKGLDDMZGV',1))) {
_SignErr('HKGLDDMZGV');
m_cLastWorkVarErrorMsg='10292644895';
l_bResult=false;
w_IDMODMIT=HtW('','C');
} else if ( ! (_ChkObl('YZXQRACPYA',1))) {
_SignErr('YZXQRACPYA');
m_cLastWorkVarErrorMsg='285808099';
l_bResult=false;
w_DESCRI=HtW('','C');
} else if ( ! (_ChkObl('CGQOPHKKPM',1))) {
_SignErr('CGQOPHKKPM');
m_cLastWorkVarErrorMsg='12121244978';
l_bResult=false;
w_DTFINVAL=HtW('','D');
} else if ((Ne(EntityStatus(),'N')) && ( ! (_ChkObl('ETQZOSKLPW',1)))) {
_SignErr('ETQZOSKLPW');
m_cLastWorkVarErrorMsg='10273053127';
l_bResult=false;
w_show_noapplic=false;
}
if (l_bResult) {
l_bResult=CheckChild(0);
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('HKGLDDMZGV_ZOOM',lc)) {
return 0;
}
if (Eq('HKGLDDMZGV',lc)) {
return 0;
}
if (Eq('CGQOPHKKPM_ZOOM',lc)) {
return 1;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_HKGLDDMZGV();
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
l_oWv.setValue('IDMOD',WtA(w_IDMOD,'C'));
l_oWv.setValue('IDMODMIT',WtA(w_IDMODMIT,'C'));
l_oWv.setValue('DESCRI',WtA(w_DESCRI,'C'));
l_oWv.setValue('DTFINVAL',WtA(w_DTFINVAL,'D'));
l_oWv.setValue('show_noapplic',WtA(w_show_noapplic,'L'));
l_oWv.setValue('pippo',WtA(w_pippo,'N'));
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
_FillChildren.n=['aosdt_ind_def'];
FillWv.n=["IDMOD","IDMODMIT","DESCRI","DTFINVAL","show_noapplic","pippo"];
function SetModified() {
m_bUpdated=true;
}
function SetChildVariables_aosdt_ind_def() {
if ( ! (ChildToLoad(FrameRef('aosdt_ind_def'))) && Ne(typeof(FrameRef('aosdt_ind_def').DoUpdate),'undefined')) {
CopyWorkVar(FrameRef('aosdt_ind_def'),['show_noapplic'],['show_noapplic'],false)
}
}
function CtxLoad_aosdt_ind_def() {
if (ChildToLoad(FrameRef('aosdt_ind_def'))) {
return [LoadContext(0,'SGBDWLUNZC'),'aosdt_ind_def'];
}
}
