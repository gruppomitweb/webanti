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
l_bEnabled= ! (false) || Eq(m_cFunction,'edit') || IsDisabledByStateDriver('CONNES');
SetDisabled('QOPKWXJPKL',l_bEnabled);
LibJavascript.forEachItem(m_FoundlingEditExpression,i_body_0)
function i_body_0(child){
child();
}
DisableUI();
if (Ne('undefined',typeof(DisableChainedLinks))) {
DisableChainedLinks(Ne(0,m_oTrs.length));
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
SetErrorField('ZRXVZSLZII',false);
}
function Set_CONNES(ctrlValue,kmode,e) {
if (Ne(w_CONNES,ctrlValue)) {
var ctl = _GetCtl(e,'QOPKWXJPKL');
if (_tracker.goon(ctl,ctrlValue)) {
w_CONNES=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QOPKWXJPKL',0);
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
function Set_DTRIL(ctrlValue,kmode,e) {
if (Ne(w_DTRIL,ctrlValue)) {
var ctl = _GetCtl(e,'INHXXZSCAR');
if (_tracker.goon(ctl,ctrlValue)) {
w_DTRIL=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('INHXXZSCAR',0);
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
function Set_IDMOD(ctrlValue,kmode,e) {
if (Ne(w_IDMOD,ctrlValue)) {
var ctl = _GetCtl(e,'GOROYGEXRL');
if (_tracker.goon(ctl,ctrlValue)) {
w_IDMOD=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('GOROYGEXRL',0);
if (l_bResult) {
l_bResult=Link_GOROYGEXRL(kmode);
if ( ! (Empty(w_IDIND))) {
Link_YTRSZBFLPF(kmode);
}
if ( ! (Empty(w_IDSUBIND))) {
Link_AIIXUOGHMQ(kmode);
}
if ( ! (l_bResult)) {
w_IDMOD=HtW('','C');
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
function Set_IDSUBIND(ctrlValue,kmode,e) {
if (Ne(w_IDSUBIND,ctrlValue)) {
var ctl = _GetCtl(e,'AIIXUOGHMQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_IDSUBIND=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('AIIXUOGHMQ',0);
if (l_bResult) {
l_bResult=Link_AIIXUOGHMQ(kmode);
if ( ! (l_bResult)) {
w_IDSUBIND=HtW('','C');
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
function Set_IDIND(ctrlValue,kmode,e) {
if (Ne(w_IDIND,ctrlValue)) {
var ctl = _GetCtl(e,'YTRSZBFLPF');
if (_tracker.goon(ctl,ctrlValue)) {
w_IDIND=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YTRSZBFLPF',0);
if (l_bResult) {
l_bResult=Link_YTRSZBFLPF(kmode);
if ( ! (Empty(w_IDSUBIND))) {
Link_AIIXUOGHMQ(kmode);
}
if ( ! (l_bResult)) {
w_IDIND=HtW('','C');
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
function Set_NOTA(ctrlValue,kmode,e) {
if (Ne(w_NOTA,ctrlValue)) {
var ctl = _GetCtl(e,'ZRXVZSLZII');
if (_tracker.goon(ctl,ctrlValue)) {
w_NOTA=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ZRXVZSLZII',0);
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
function Set_DESCIND(ctrlValue,kmode,e) {
if (Ne(w_DESCIND,ctrlValue)) {
var ctl = _GetCtl(e,'MRVGSJSKMR');
if (_tracker.goon(ctl,ctrlValue)) {
w_DESCIND=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MRVGSJSKMR',0);
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
function Link_GOROYGEXRL(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_IDMOD);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('IDMOD',w_IDMOD,10,0);
l_Appl.SetFields('IDMOD,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('mod_ind_def');
l_Appl.SetLinkzoom('aosmt_mod_ind_def');
l_Appl.SetID('GOROYGEXRL');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_IDMOD=l_Appl.GetStringValue('IDMOD',10,0);
w_DESMODEL=l_Appl.GetStringValue('DESCRI',200,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_GOROYGEXRL_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_GOROYGEXRL';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_GOROYGEXRL();
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
function Link_GOROYGEXRL_Blank() {
w_IDMOD='';
w_DESMODEL='';
}
function LOpt_GOROYGEXRL() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('mod_ind_def','C'));
l_oWv.setValue('Linkzoomprg',WtA('aosmt_mod_ind_def','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('IDMOD','C'));
l_oWv.setValue('LinkedField',WtA('IDMOD','C'));
l_oWv.setValue('UID',WtA('GOROYGEXRL','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['GOROYGEXRL'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('1882372925'),'C'));
return l_oWv;
}
function Link_YTRSZBFLPF(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_IDIND);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('IDMOD',w_IDMOD,10,0);
l_Appl.SetStringKey('IDIND',w_IDIND,10,0);
l_Appl.SetFields('IDIND,PROGIND,DESCRI');
l_Appl.SetTypes('C,C,M');
l_Appl.LinkTable('ind_def');
l_Appl.SetID('YTRSZBFLPF');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_IDIND=l_Appl.GetStringValue('IDIND',10,0);
w_PROGIND=l_Appl.GetStringValue('PROGIND',10,0);
w_DESCIND=l_Appl.GetStringValue('DESCRI',10,0);
l_Appl.GetLinkHash(GetRepeatedCheckVars());
} else {
Link_YTRSZBFLPF_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_YTRSZBFLPF';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_YTRSZBFLPF();
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
function Link_YTRSZBFLPF_Blank() {
w_IDIND='';
w_PROGIND='';
w_DESCIND='';
}
function LOpt_YTRSZBFLPF() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('ind_def','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('IDMOD,IDIND','C'));
l_oWv.setValue('LinkedField',WtA('IDIND','C'));
l_oWv.setValue('UID',WtA('YTRSZBFLPF','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['YTRSZBFLPF'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('1786380843'),'C'));
return l_oWv;
}
function Link_AIIXUOGHMQ(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_IDSUBIND);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('IDMOD',w_IDMOD,10,0);
l_Appl.SetStringKey('IDIND',w_IDIND,10,0);
l_Appl.SetStringKey('IDSUBIND',w_IDSUBIND,10,0);
l_Appl.SetFields('IDSUBIND,PROGSUBIND,DESCRI');
l_Appl.SetTypes('C,C,M');
l_Appl.LinkTable('sub_ind_def');
l_Appl.SetLinkzoom('aosdt_sub_ind_def');
l_Appl.SetID('AIIXUOGHMQ');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_IDSUBIND=l_Appl.GetStringValue('IDSUBIND',10,0);
w_PROGSUBIND=l_Appl.GetStringValue('PROGSUBIND',10,0);
w_DESCSUB=l_Appl.GetStringValue('DESCRI',10,0);
l_Appl.GetLinkHash(GetRepeatedCheckVars());
} else {
Link_AIIXUOGHMQ_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_AIIXUOGHMQ';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_AIIXUOGHMQ();
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
function Link_AIIXUOGHMQ_Blank() {
w_IDSUBIND='';
w_PROGSUBIND='';
w_DESCSUB='';
}
function LOpt_AIIXUOGHMQ() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('sub_ind_def','C'));
l_oWv.setValue('Linkzoomprg',WtA('aosdt_sub_ind_def','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('IDMOD,IDIND,IDSUBIND','C'));
l_oWv.setValue('LinkedField',WtA('IDSUBIND','C'));
l_oWv.setValue('UID',WtA('AIIXUOGHMQ','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['AIIXUOGHMQ'][1],'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'GOROYGEXRL')) {
last_focused_comp=GetLastFocusedElementOfLink('GOROYGEXRL');
function SetMethod_GOROYGEXRL() {
Set_IDMOD(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_GOROYGEXRL();
} else {
setTimeout(SetMethod_GOROYGEXRL,1);
}
m_bHeaderUpdated=true;
bResult=true;
}
if (Eq(varName,'YTRSZBFLPF')) {
last_focused_comp=GetLastFocusedElementOfLink('YTRSZBFLPF');
function SetMethod_YTRSZBFLPF() {
Set_IDIND(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_YTRSZBFLPF();
} else {
setTimeout(SetMethod_YTRSZBFLPF,1);
}
bResult=true;
}
if (Eq(varName,'AIIXUOGHMQ')) {
last_focused_comp=GetLastFocusedElementOfLink('AIIXUOGHMQ');
function SetMethod_AIIXUOGHMQ() {
Set_IDSUBIND(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_AIIXUOGHMQ();
} else {
setTimeout(SetMethod_AIIXUOGHMQ,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'GOROYGEXRL')) {
return [Ctrl('GOROYGEXRL')];
}
if (Eq(varName,'YTRSZBFLPF')) {
return [Ctrl('YTRSZBFLPF')];
}
if (Eq(varName,'AIIXUOGHMQ')) {
return [Ctrl('AIIXUOGHMQ')];
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
parent.ZtVWeb.raiseEventToEvalParms('aosdt_rilevazioni_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('aosdt_rilevazioni_dataNotSent',{'action':formaction});
}
}
}
}
CheckChild.child=[];
function Check() {
var l_bResult = true;
ResetErrorVars();
if ((false) && ( ! (_ChkObl('QOPKWXJPKL',1)))) {
_SignErr('QOPKWXJPKL');
m_cLastWorkVarErrorMsg='10565397709';
l_bResult=false;
w_CONNES=HtW('','C');
} else if ( ! (_ChkObl('INHXXZSCAR',1))) {
_SignErr('INHXXZSCAR');
m_cLastWorkVarErrorMsg='10173567207';
l_bResult=false;
w_DTRIL=HtW('','D');
} else if ( ! (_ChkObl('GOROYGEXRL',1))) {
_SignErr('GOROYGEXRL');
m_cLastWorkVarErrorMsg='10024211400';
l_bResult=false;
w_IDMOD=HtW('','C');
}
if (l_bResult) {
l_bResult=CheckChild(0);
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('INHXXZSCAR_ZOOM',lc)) {
return 0;
}
if (Eq('GOROYGEXRL_ZOOM',lc)) {
return 0;
}
if (Eq('GOROYGEXRL',lc)) {
return 0;
}
if (Eq('YTRSZBFLPF_ZOOM',lc)) {
return 1;
}
if (Eq('YTRSZBFLPF',lc)) {
return 1;
}
if (Eq('AIIXUOGHMQ_ZOOM',lc)) {
return 2;
}
if (Eq('AIIXUOGHMQ',lc)) {
return 2;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_GOROYGEXRL();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,1)) {
l_oWv=LOpt_YTRSZBFLPF();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
l_cFixedFilter=l_cFixedFilter+l_cAndOp+_flt_('IDMOD',w_IDMOD,'C',true);
if ( ! (Empty(l_cFixedFilter))) {
l_cAndOp=' and ';
}
l_oWv.setValue('FixedFilter',l_cFixedFilter);
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,2)) {
l_oWv=LOpt_AIIXUOGHMQ();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
l_cFixedFilter=l_cFixedFilter+l_cAndOp+_flt_('IDMOD',w_IDMOD,'C',true);
if ( ! (Empty(l_cFixedFilter))) {
l_cAndOp=' and ';
}
l_cFixedFilter=l_cFixedFilter+l_cAndOp+_flt_('IDIND',w_IDIND,'C',true);
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
l_oWv.setValue('CONNES',WtA(w_CONNES,'C'));
l_oWv.setValue('DTRIL',WtA(w_DTRIL,'D'));
l_oWv.setValue('IDMOD',WtA(w_IDMOD,'C'));
l_oWv.setValue('DESMODEL',WtA(w_DESMODEL,'C'));
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
FillWv.n=["CONNES","DTRIL","IDMOD","DESMODEL"];
function CheckRow(w) {
var l_bResult = true;
ResetErrorVars();
if (Le(m_nCurrentRow,Rows())) {
if (( ! (_ChkObl('YTRSZBFLPF',1))) && FullRow()) {
_SignErr('YTRSZBFLPF');
m_cLastWorkVarErrorMsg='1305674908';
l_bResult=false;
w_IDIND=HtW('','C');
} else if (( ! (_ChkObl('AIIXUOGHMQ',1))) && FullRow()) {
_SignErr('AIIXUOGHMQ');
m_cLastWorkVarErrorMsg='10783450750';
l_bResult=false;
w_IDSUBIND=HtW('','C');
} else if (( ! (_ChkObl('ZRXVZSLZII',1))) && FullRow()) {
_SignErr('ZRXVZSLZII');
m_cLastWorkVarErrorMsg='1654558139';
l_bResult=false;
w_NOTA=HtW('','M');
} else if (( ! (_ChkObl('MRVGSJSKMR',1))) && FullRow()) {
_SignErr('MRVGSJSKMR');
m_cLastWorkVarErrorMsg='10298248210';
l_bResult=false;
w_DESCIND=HtW('','M');
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
}
SaveContext.child=[];
function BlankRow() {
w_IDIND='';
w_IDSUBIND='';
w_NOTA='';
w_PROGIND='';
w_DESCIND='';
w_PROGSUBIND='';
w_DESCSUB='';
if ( ! (EmptyString(w_IDIND))) {
Link_YTRSZBFLPF(null);
}
if ( ! (EmptyString(w_IDSUBIND))) {
Link_AIIXUOGHMQ(null);
}
BlankRowChild();
if (m_bExtended) {
BlankRepeatedExtendedFields();
}
SaveDependsOn();
LoadContext(true);
}
function FullRow() {
return  ! (Empty(w_IDIND));
}
function GetRepeatedFields() {
var l_aRepeatedFields;
l_aRepeatedFields={};
l_aRepeatedFields.IDIND={"dec":0,"fixedpos":false,"id":"YTRSZBFLPF","len":10,"name":"IDIND","title":"ID del indicatore","type":"C"};
l_aRepeatedFields.IDSUBIND={"dec":0,"fixedpos":false,"id":"AIIXUOGHMQ","len":10,"name":"IDSUBIND","title":"ID del subindicatore ","type":"C"};
l_aRepeatedFields.NOTA={"dec":0,"fixedpos":true,"id":"ZRXVZSLZII","len":10,"name":"NOTA","title":"Nota Anomalia","type":"M"};
l_aRepeatedFields.PROGIND={"dec":0,"fixedpos":false,"id":"GAQLFVLCMG","len":10,"name":"PROGIND","title":"Progressivo indicatore","type":"C"};
l_aRepeatedFields.DESCIND={"dec":0,"fixedpos":false,"id":"MRVGSJSKMR","len":10,"name":"DESCIND","title":"Descrizione del indicatore","type":"M"};
l_aRepeatedFields.PROGSUBIND={"dec":0,"fixedpos":false,"id":"IDTVCEOZJZ","len":10,"name":"PROGSUBIND","title":"Progressivo subindicatore","type":"C"};
l_aRepeatedFields.DESCSUB={"dec":0,"fixedpos":false,"id":"TKUWOKAOHM","len":10,"name":"DESCSUB","title":"Descrizione del subindicatore","type":"M"};
return l_aRepeatedFields;
}
function SubtractTotals() {
}
function hasDepOnTotals() {
}
function DisableChainedLinks(disable) {
var cc = DisableChainedLinks.chainedCtrls;
var id;
for (var i = 0; Lt(i,cc.length); i = i + (1)) {
id=cc[i];
SetDisabled(Ctrl(id),disable || eval(DisableChainedLinks.chainedCtrlsCond[i]));
}
}
DisableChainedLinks.chainedCtrls=["GOROYGEXRL","GOROYGEXRL"];
DisableChainedLinks.chainedCtrlsCond=["false","false"];
