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
l_bEnabled= ! ( ! (Empty(w_RAPPORTO)) && Eq(w_ASPEDITO,1) && (Eq(m_cFunction,'view') || Eq(m_cFunction,'edit')));
SetDisabled('RZXJJIHWRO',l_bEnabled);
l_bEnabled= ! ( ! (Empty(w_RAPPORTO)) && Eq(w_ASPEDITO,1) && (Eq(m_cFunction,'view') || Eq(m_cFunction,'edit')));
SetDisabled('LBDAXRYAIV',l_bEnabled);
l_bEnabled= ! (Eq(m_cFunction,'view'));
SetDisabled('URZTYMSMYS',l_bEnabled);
if (IsDisabledByStateDriver('box_YORQOIOBQN')) {
DisableInputsInContainer(Ctrl('YORQOIOBQN'),true);
}
if (IsDisabledByStateDriver('box_RGYIJRGRVR')) {
DisableInputsInContainer(Ctrl('RGYIJRGRVR'),true);
}
if (IsDisabledByStateDriver('box_SWHJSXDMQR')) {
DisableInputsInContainer(Ctrl('SWHJSXDMQR'),true);
}
if (IsDisabledByStateDriver('box_HDQLRPYTAN')) {
DisableInputsInContainer(Ctrl('HDQLRPYTAN'),true);
}
if (IsDisabledByStateDriver('box_ZUHLCKITMM')) {
DisableInputsInContainer(Ctrl('ZUHLCKITMM'),true);
}
if (IsDisabledByStateDriver('box_TNLEGEGWAQ')) {
DisableInputsInContainer(Ctrl('TNLEGEGWAQ'),true);
}
if (IsDisabledByStateDriver('box_NNCELEXRKP')) {
DisableInputsInContainer(Ctrl('NNCELEXRKP'),true);
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
function Set_RAPPORTO(ctrlValue,kmode,e) {
if (Ne(w_RAPPORTO,ctrlValue)) {
var ctl = _GetCtl(e,'LXORWVRYJJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_RAPPORTO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('LXORWVRYJJ',0);
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
function Set_COINT(ctrlValue,kmode,e) {
if (Ne(w_COINT,ctrlValue)) {
var ctl = _GetCtl(e,'JHOQNVHZXH');
if (_tracker.goon(ctl,ctrlValue)) {
w_COINT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('JHOQNVHZXH',0);
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
function Set_TIPOAG(ctrlValue,kmode,e) {
if (Ne(w_TIPOAG,ctrlValue)) {
var ctl = _GetCtl(e,'BHAVHLFPAC');
if (_tracker.goon(ctl,ctrlValue)) {
w_TIPOAG=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BHAVHLFPAC',0);
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
function Set_CPROG(ctrlValue,kmode,e) {
if (Ne(w_CPROG,ctrlValue)) {
var ctl = _GetCtl(e,'YFRSEVUKNF');
if (_tracker.goon(ctl,ctrlValue)) {
w_CPROG=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YFRSEVUKNF',0);
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
function Set_CONNESINT(ctrlValue,kmode,e) {
if (Ne(w_CONNESINT,ctrlValue)) {
var ctl = _GetCtl(e,'DZWSXMBIHR');
if (_tracker.goon(ctl,ctrlValue)) {
w_CONNESINT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('DZWSXMBIHR',0);
if (l_bResult) {
l_bResult=Link_DZWSXMBIHR(kmode);
if ( ! (l_bResult)) {
w_CONNESINT=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',16,0,''));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',16,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_CFILE(ctrlValue,kmode,e) {
if (Ne(w_CFILE,ctrlValue)) {
var ctl = _GetCtl(e,'HBCZFDMLIW');
if (_tracker.goon(ctl,ctrlValue)) {
w_CFILE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HBCZFDMLIW',0);
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
function Set_ADATA(ctrlValue,kmode,e) {
if (Ne(w_ADATA,ctrlValue)) {
var ctl = _GetCtl(e,'HUMSCLHVTQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_ADATA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HUMSCLHVTQ',0);
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
function Set_ASPEDITO(ctrlValue,kmode,e) {
if (Ne(w_ASPEDITO,ctrlValue)) {
var ctl = _GetCtl(e,'OYBCLSBWWU');
if (_tracker.goon(ctl,ctrlValue)) {
w_ASPEDITO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('OYBCLSBWWU',0);
DoUpdate(l_bResult);
if(c=Ctrl('OYBCLSBWWU')) ChkboxCheckUncheck(c,1,w_ASPEDITO)
if(c=Ctrl('OYBCLSBWWU')) ChkboxValueAssign(c,1,0,'N',1,0,'')
return l_bResult;
} else {
ctl.value=WtH(0,'N',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_AFILE(ctrlValue,kmode,e) {
if (Ne(w_AFILE,ctrlValue)) {
var ctl = _GetCtl(e,'EDCVGCRZZZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_AFILE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('EDCVGCRZZZ',0);
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
function Set_APROG(ctrlValue,kmode,e) {
if (Ne(w_APROG,ctrlValue)) {
var ctl = _GetCtl(e,'JINDLZUJGB');
if (_tracker.goon(ctl,ctrlValue)) {
w_APROG=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('JINDLZUJGB',0);
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
function Set_DATESITO(ctrlValue,kmode,e) {
if (Ne(w_DATESITO,ctrlValue)) {
var ctl = _GetCtl(e,'UCLGIPKHHK');
if (_tracker.goon(ctl,ctrlValue)) {
w_DATESITO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UCLGIPKHHK',0);
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
function Set_RSPEDITO(ctrlValue,kmode,e) {
if (Ne(w_RSPEDITO,ctrlValue)) {
var ctl = _GetCtl(e,'JDNKWMLZTI');
if (_tracker.goon(ctl,ctrlValue)) {
w_RSPEDITO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('JDNKWMLZTI',0);
DoUpdate(l_bResult);
if(c=Ctrl('JDNKWMLZTI')) ChkboxCheckUncheck(c,1,w_RSPEDITO)
if(c=Ctrl('JDNKWMLZTI')) ChkboxValueAssign(c,1,0,'N',1,0,'')
return l_bResult;
} else {
ctl.value=WtH(0,'N',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_CSPEDITO(ctrlValue,kmode,e) {
if (Ne(w_CSPEDITO,ctrlValue)) {
var ctl = _GetCtl(e,'LLONFBQGWC');
if (_tracker.goon(ctl,ctrlValue)) {
w_CSPEDITO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('LLONFBQGWC',0);
DoUpdate(l_bResult);
if(c=Ctrl('LLONFBQGWC')) ChkboxCheckUncheck(c,1,w_CSPEDITO)
if(c=Ctrl('LLONFBQGWC')) ChkboxValueAssign(c,1,0,'N',1,0,'')
return l_bResult;
} else {
ctl.value=WtH(0,'N',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_COLDFILE(ctrlValue,kmode,e) {
if (Ne(w_COLDFILE,ctrlValue)) {
var ctl = _GetCtl(e,'JWUIHKTDYH');
if (_tracker.goon(ctl,ctrlValue)) {
w_COLDFILE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('AGVEMIAUQV',0);
l_bResult=l_bResult && _ChkObl('JWUIHKTDYH',0);
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
function Set_COLDPROG(ctrlValue,kmode,e) {
if (Ne(w_COLDPROG,ctrlValue)) {
var ctl = _GetCtl(e,'JCJVALRBTS');
if (_tracker.goon(ctl,ctrlValue)) {
w_COLDPROG=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NAJNVPLZYU',0);
l_bResult=l_bResult && _ChkObl('JCJVALRBTS',0);
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
function Set_CDATA(ctrlValue,kmode,e) {
if (Ne(w_CDATA,ctrlValue)) {
var ctl = _GetCtl(e,'EYLNNWDCKZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_CDATA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('EYLNNWDCKZ',0);
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
function Set_ADATARET(ctrlValue,kmode,e) {
if (Ne(w_ADATARET,ctrlValue)) {
var ctl = _GetCtl(e,'GVMNAQQJWY');
if (_tracker.goon(ctl,ctrlValue)) {
w_ADATARET=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('GVMNAQQJWY',0);
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
function Set_IDESITO(ctrlValue,kmode,e) {
if (Ne(w_IDESITO,ctrlValue)) {
var ctl = _GetCtl(e,'ZDQIQPDLMA');
if (_tracker.goon(ctl,ctrlValue)) {
w_IDESITO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ZDQIQPDLMA',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',8,0,'');
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
UpdateAutonumber('IDBASE');
w_NOCODFISC=(Eq(w_xcfestero,0)?'N':'S');
UpdateAutonumber('PROGDLG');
if ((Ne(o_IDBASE,w_IDBASE))) {
l_bTmpRes=Link_VQOCGQDTYC(null);
}
UpdateAutonumber('IDBASE');
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
o_IDBASE=w_IDBASE;
}
function SaveLabelDependsOn() {
}
function Link_DZWSXMBIHR(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CONNESINT);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CONNES',w_CONNESINT,16,0);
l_Appl.SetFields('CONNES,RAGSOC,CFESTERO');
l_Appl.SetTypes('C,C,N');
l_Appl.LinkTable('personbo');
l_Appl.SetID('DZWSXMBIHR');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CONNESINT=l_Appl.GetStringValue('CONNES',16,0);
w_xragsoc=l_Appl.GetStringValue('RAGSOC',70,0);
w_xcfestero=l_Appl.GetDoubleValue('CFESTERO',1,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_DZWSXMBIHR_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_DZWSXMBIHR';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
l_cFieldFilter=l_cFieldFilter+l_cAndOpForField+_flt_('TIPOPERS','P',null,true,'=');
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_DZWSXMBIHR();
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
function Link_DZWSXMBIHR_Blank() {
w_CONNESINT='';
w_xragsoc='';
w_xcfestero=0;
}
function LOpt_DZWSXMBIHR() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('personbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CONNES','C'));
l_oWv.setValue('LinkedField',WtA('CONNES','C'));
l_oWv.setValue('UID',WtA('DZWSXMBIHR','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['DZWSXMBIHR'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('195812931'),'C'));
return l_oWv;
}
function Link_VQOCGQDTYC(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_IDBASE);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('IDBASE',w_IDBASE,10,0);
l_Appl.SetFields('IDBASE,IDFILE,IDPROG,SPEDITO,DATARIF');
l_Appl.SetTypes('C,C,C,N,D');
l_Appl.LinkTable('aedecanc');
l_Appl.SetID('VQOCGQDTYC');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_IDBASE=l_Appl.GetStringValue('IDBASE',10,0);
w_filecanc=l_Appl.GetStringValue('IDFILE',15,0);
w_idcanc=l_Appl.GetStringValue('IDPROG',25,0);
w_spcanc=l_Appl.GetDoubleValue('SPEDITO',1,0);
w_dtcanc=l_Appl.GetDateValue('DATARIF',8,0);
w_dtcanc=DateFromApplet(w_dtcanc);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_VQOCGQDTYC_Blank();
l_bResult=true;
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
function Link_VQOCGQDTYC_Blank() {
w_filecanc='';
w_idcanc='';
w_spcanc=0;
w_dtcanc=NullDate();
}
function LOpt_VQOCGQDTYC() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('aedecanc','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('IDBASE','C'));
l_oWv.setValue('LinkedField',WtA('IDBASE','C'));
l_oWv.setValue('UID',WtA('VQOCGQDTYC','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['VQOCGQDTYC'][1],'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'DZWSXMBIHR')) {
last_focused_comp=GetLastFocusedElementOfLink('DZWSXMBIHR');
function SetMethod_DZWSXMBIHR() {
Set_CONNESINT(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_DZWSXMBIHR();
} else {
setTimeout(SetMethod_DZWSXMBIHR,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'DZWSXMBIHR')) {
return [Ctrl('DZWSXMBIHR')];
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
parent.ZtVWeb.raiseEventToEvalParms('armt_ae_aedelrig_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('armt_ae_aedelrig_dataNotSent',{'action':formaction});
}
}
}
}
CheckChild.child=[];
function Check() {
var l_bResult = true;
ResetErrorVars();
m_nLastError=0;
if ( ! (_ChkObl('LXORWVRYJJ',1))) {
_SignErr('LXORWVRYJJ');
m_cLastWorkVarErrorMsg='11116511596';
l_bResult=false;
w_RAPPORTO=HtW('','C');
} else if ( ! (_ChkObl('JHOQNVHZXH',1))) {
_SignErr('JHOQNVHZXH');
m_cLastWorkVarErrorMsg='1723736132';
l_bResult=false;
w_COINT=HtW('','C');
} else if ( ! (_ChkObl('BHAVHLFPAC',1))) {
_SignErr('BHAVHLFPAC');
m_cLastWorkVarErrorMsg='TIPOAG';
l_bResult=false;
w_TIPOAG=HtW('','C');
} else if ( ! (_ChkObl('DZWSXMBIHR',1))) {
_SignErr('DZWSXMBIHR');
m_cLastWorkVarErrorMsg='10580790440';
l_bResult=false;
w_CONNESINT=HtW('','C');
} else if ( ! (_ChkObl('HUMSCLHVTQ',1))) {
_SignErr('HUMSCLHVTQ');
m_cLastWorkVarErrorMsg='45547646';
l_bResult=false;
w_ADATA=HtW('','D');
} else if ( ! (_ChkObl('OYBCLSBWWU',1))) {
_SignErr('OYBCLSBWWU');
m_cLastWorkVarErrorMsg='1265210153';
l_bResult=false;
w_ASPEDITO=0;
} else if ( ! (_ChkObl('EDCVGCRZZZ',1))) {
_SignErr('EDCVGCRZZZ');
m_cLastWorkVarErrorMsg='1027202812';
l_bResult=false;
w_AFILE=HtW('','C');
} else if ( ! (_ChkObl('JINDLZUJGB',1))) {
_SignErr('JINDLZUJGB');
m_cLastWorkVarErrorMsg='11446421191';
l_bResult=false;
w_APROG=HtW('','C');
} else if ( ! (_ChkObl('LLONFBQGWC',1))) {
_SignErr('LLONFBQGWC');
m_cLastWorkVarErrorMsg='218917798';
l_bResult=false;
w_CSPEDITO=0;
} else if ( ! (_ChkObl('YFRSEVUKNF',1))) {
_SignErr('YFRSEVUKNF');
m_cLastWorkVarErrorMsg='910975989';
l_bResult=false;
w_CPROG=HtW('','C');
} else if ( ! (_ChkObl('HBCZFDMLIW',1))) {
_SignErr('HBCZFDMLIW');
m_cLastWorkVarErrorMsg='1039309729';
l_bResult=false;
w_CFILE=HtW('','C');
} else if ( ! (_ChkObl('EYLNNWDCKZ',1))) {
_SignErr('EYLNNWDCKZ');
m_cLastWorkVarErrorMsg='45547646';
l_bResult=false;
w_CDATA=HtW('','D');
} else if ( ! (_ChkObl('ZDQIQPDLMA',1))) {
_SignErr('ZDQIQPDLMA');
m_cLastWorkVarErrorMsg='11284067142';
l_bResult=false;
w_IDESITO=HtW('','C');
} else if ( ! (_ChkObl('GVMNAQQJWY',1))) {
_SignErr('GVMNAQQJWY');
m_cLastWorkVarErrorMsg='11329559720';
l_bResult=false;
w_ADATARET=HtW('','D');
} else if ( ! (_ChkObl('JDNKWMLZTI',1))) {
_SignErr('JDNKWMLZTI');
m_cLastWorkVarErrorMsg='RSPEDITO';
l_bResult=false;
w_RSPEDITO=0;
} else if ( ! (_ChkObl('JWUIHKTDYH',1))) {
_SignErr('JWUIHKTDYH');
m_cLastWorkVarErrorMsg='863382899';
l_bResult=false;
w_COLDFILE=HtW('','C');
} else if ( ! (_ChkObl('JCJVALRBTS',1))) {
_SignErr('JCJVALRBTS');
m_cLastWorkVarErrorMsg='533198559';
l_bResult=false;
w_COLDPROG=HtW('','C');
} else if ( ! (_ChkObl('UCLGIPKHHK',1))) {
_SignErr('UCLGIPKHHK');
m_cLastWorkVarErrorMsg='1025726040';
l_bResult=false;
w_DATESITO=HtW('','D');
}
if (l_bResult) {
l_bResult=CheckChild(0);
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('DZWSXMBIHR_ZOOM',lc)) {
return 0;
}
if (Eq('DZWSXMBIHR',lc)) {
return 0;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_DZWSXMBIHR();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
l_cFieldFilter=l_cFieldFilter+l_cAndOpForField+_flt_('TIPOPERS','P',null,true,'=');
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
l_oWv.setValue('FieldFilter',l_cFieldFilter);
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
}
function FillWv() {
var l_oWv = InitWvApplet();
l_oWv.setValue('m_CheckVars',JSON.stringify(m_CheckVars));
l_oWv.setValue('RAPPORTO',WtA(w_RAPPORTO,'C'));
l_oWv.setValue('COINT',WtA(w_COINT,'C'));
l_oWv.setValue('TIPOAG',WtA(w_TIPOAG,'C'));
l_oWv.setValue('IDBASE',WtA(w_IDBASE,'C'));
l_oWv.setValue('op_IDBASE',WtA(op_IDBASE,'C'));
l_oWv.setValue('CONNESINT',WtA(w_CONNESINT,'C'));
l_oWv.setValue('ADATA',WtA(w_ADATA,'D'));
l_oWv.setValue('ASPEDITO',WtA(w_ASPEDITO,'N'));
l_oWv.setValue('AFILE',WtA(w_AFILE,'C'));
l_oWv.setValue('APROG',WtA(w_APROG,'C'));
l_oWv.setValue('AOLDPROG',WtA(w_AOLDPROG,'C'));
l_oWv.setValue('AOLDFILE',WtA(w_AOLDFILE,'C'));
l_oWv.setValue('CSPEDITO',WtA(w_CSPEDITO,'N'));
l_oWv.setValue('CPROG',WtA(w_CPROG,'C'));
l_oWv.setValue('COLDPROG',WtA(w_COLDPROG,'C'));
l_oWv.setValue('CFILE',WtA(w_CFILE,'C'));
l_oWv.setValue('COLDFILE',WtA(w_COLDFILE,'C'));
l_oWv.setValue('IDRIF',WtA(w_IDRIF,'C'));
l_oWv.setValue('NOCODFISC',WtA(w_NOCODFISC,'C'));
l_oWv.setValue('ADTPRE',WtA(w_ADTPRE,'D'));
l_oWv.setValue('CDTPRE',WtA(w_CDTPRE,'D'));
l_oWv.setValue('CDATA',WtA(w_CDATA,'D'));
l_oWv.setValue('IDESITO',WtA(w_IDESITO,'C'));
l_oWv.setValue('PROGDLG',WtA(w_PROGDLG,'N'));
l_oWv.setValue('op_PROGDLG',WtA(op_PROGDLG,'N'));
l_oWv.setValue('ADATARET',WtA(w_ADATARET,'D'));
l_oWv.setValue('RSPEDITO',WtA(w_RSPEDITO,'N'));
l_oWv.setValue('DATESITO',WtA(w_DATESITO,'D'));
l_oWv.setValue('xcfestero',WtA(w_xcfestero,'N'));
l_oWv.setValue('xragsoc',WtA(w_xragsoc,'C'));
l_oWv.setValue('desctrap',WtA(w_desctrap,'C'));
l_oWv.setValue('dtcanc',WtA(w_dtcanc,'D'));
l_oWv.setValue('spcanc',WtA(w_spcanc,'N'));
l_oWv.setValue('filecanc',WtA(w_filecanc,'C'));
l_oWv.setValue('idcanc',WtA(w_idcanc,'C'));
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
FillWv.n=["RAPPORTO","COINT","TIPOAG","IDBASE","CONNESINT","ADATA","ASPEDITO","AFILE","APROG","AOLDPROG","AOLDFILE","CSPEDITO","CPROG","COLDPROG","CFILE","COLDFILE","IDRIF","NOCODFISC","ADTPRE","CDTPRE","CDATA","IDESITO","PROGDLG","ADATARET","RSPEDITO","DATESITO","xcfestero","xragsoc","desctrap","dtcanc","spcanc","filecanc","idcanc"];
function SetModified() {
m_bUpdated=true;
}
