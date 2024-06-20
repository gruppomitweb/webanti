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
l_bEnabled= ! (Eq(w_MEZPAGAM,'I') || Eq(w_MEZPAGAM,'E')) || IsDisabledByStateDriver('IBAN');
SetDisabled('UTUCDPQJKK',l_bEnabled);
if (IsDisabledByStateDriver('Dati')) {
DisableInputsInContainer(Ctrl('PIMVZFFAWF'),true);
}
if (IsDisabledByStateDriver('Errori')) {
DisableInputsInContainer(Ctrl('MKZZTQTPHW'),true);
}
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
SetObligatory(Ctrl('UTUCDPQJKK'),Eq(w_MEZPAGAM,'B') || IsObligatoryByStateDriver('IBAN'));
}
function SetDynamicClasses() {
var c;
}
function SetDynamicTooltip() {
var c;
}
function Set_SNAINUMOPE(ctrlValue,kmode,e) {
if (Ne(w_SNAINUMOPE,ctrlValue)) {
var ctl = _GetCtl(e,'GSWVKRDVIZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_SNAINUMOPE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('GSWVKRDVIZ',0);
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
function Set_ENV(ctrlValue,kmode,e) {
if (Ne(w_ENV,ctrlValue)) {
var ctl = _GetCtl(e,'XUFFKSTRWQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_ENV=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XUFFKSTRWQ',0);
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
function Set_CODDIPE(ctrlValue,kmode,e) {
if (Ne(w_CODDIPE,ctrlValue)) {
var ctl = _GetCtl(e,'YMJRPKIKSX');
if (_tracker.goon(ctl,ctrlValue)) {
w_CODDIPE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YMJRPKIKSX',0);
if (l_bResult) {
l_bResult=Link_YMJRPKIKSX(kmode);
if ( ! (l_bResult)) {
w_CODDIPE=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',6,0,''));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',6,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_RAPPORTO(ctrlValue,kmode,e) {
if (Ne(w_RAPPORTO,ctrlValue)) {
var ctl = _GetCtl(e,'DSKEQYLWDR');
if (_tracker.goon(ctl,ctrlValue)) {
w_RAPPORTO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('DSKEQYLWDR',0);
if (l_bResult) {
l_bResult=Link_DSKEQYLWDR(kmode);
if ( ! (l_bResult)) {
w_RAPPORTO=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',25,0,''));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',25,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_TOTLIRE(ctrlValue,kmode,e) {
if (Ne(w_TOTLIRE,ctrlValue)) {
var ctl = _GetCtl(e,'UQYWDDPGQG');
if (_tracker.goon(ctl,ctrlValue)) {
w_TOTLIRE=ValidNum(ctrlValue,'999999999999.99');
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UQYWDDPGQG',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('UQYWDDPGQG',function(){return WtH(w_TOTLIRE,'N',15,2,'999999999999.99')},w_TOTLIRE);
return l_bResult;
} else {
ctl.value=WtH('','N',15,2,'999999999999.99');
_ResetTracker();
return true;
}
}
return true;
}
function Set_CADATAORA(ctrlValue,kmode,e) {
if (Ne(w_CADATAORA,ctrlValue)) {
var ctl = _GetCtl(e,'NSVLOKQVAT');
if (_tracker.goon(ctl,ctrlValue)) {
w_CADATAORA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NSVLOKQVAT',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH(NullDateTime(),'T',14,0,TranslatePicture(GetDatePicture(false,'T'),'T'));
_ResetTracker();
return true;
}
}
return true;
}
function Set_CAIDBIGLIETTO(ctrlValue,kmode,e) {
if (Ne(w_CAIDBIGLIETTO,ctrlValue)) {
var ctl = _GetCtl(e,'YMUBWPUUZX');
if (_tracker.goon(ctl,ctrlValue)) {
w_CAIDBIGLIETTO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YMUBWPUUZX',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',28,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_CATIPCON(ctrlValue,kmode,e) {
if (Ne(w_CATIPCON,ctrlValue)) {
var ctl = _GetCtl(e,'BRJUUNWDMJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_CATIPCON=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BRJUUNWDMJ',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','N',5,0,'');
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
function Set_CATIPGIO(ctrlValue,kmode,e) {
if (Ne(w_CATIPGIO,ctrlValue)) {
var ctl = _GetCtl(e,'XQXYVWITMV');
if (_tracker.goon(ctl,ctrlValue)) {
w_CATIPGIO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XQXYVWITMV',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','N',5,0,'');
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
function Set_CAPV_COD(ctrlValue,kmode,e) {
if (Ne(w_CAPV_COD,ctrlValue)) {
var ctl = _GetCtl(e,'CTQAPOFAUI');
if (_tracker.goon(ctl,ctrlValue)) {
w_CAPV_COD=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CTQAPOFAUI',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','N',10,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_MEZPAGAM(ctrlValue,kmode,e) {
if (Ne(w_MEZPAGAM,ctrlValue)) {
var ctl = _GetCtl(e,'EOSKLIUGBC');
if (_tracker.goon(ctl,ctrlValue)) {
w_MEZPAGAM=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('EOSKLIUGBC',0);
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
function Set_IBAN(ctrlValue,kmode,e) {
if (Ne(w_IBAN,ctrlValue)) {
var ctl = _GetCtl(e,'UTUCDPQJKK');
if (_tracker.goon(ctl,ctrlValue)) {
w_IBAN=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UTUCDPQJKK',0);
if (l_bResult) {
l_bResult=arfn_chkiban(Upper(w_IBAN),w_MEZPAGAM);
if ( ! (l_bResult)) {
m_nLastError=2;
m_cLastWorkVarErrorMsg='737507602';
m_cLastMsgError=AlertErrorMessage('11525797640');
}
if ( ! (l_bResult)) {
w_IBAN=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',27,0,'@!'));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',27,0,'@!');
_ResetTracker();
return true;
}
}
return true;
}
function Set_CACODICE(ctrlValue,kmode,e) {
if (Ne(w_CACODICE,ctrlValue)) {
var ctl = _GetCtl(e,'WJQFIEBCQV');
if (_tracker.goon(ctl,ctrlValue)) {
w_CACODICE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('WJQFIEBCQV',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','N',5,0,'');
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
function Link_YMJRPKIKSX(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CODDIPE);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODDIP',w_CODDIPE,6,0);
l_Appl.SetFields('CODDIP,DESCRIZ');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('anadip');
l_Appl.SetID('YMJRPKIKSX');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CODDIPE=l_Appl.GetStringValue('CODDIP',6,0);
w_xdesdip=l_Appl.GetStringValue('DESCRIZ',30,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_YMJRPKIKSX_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_YMJRPKIKSX';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_YMJRPKIKSX();
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
function Link_YMJRPKIKSX_Blank() {
w_CODDIPE='';
w_xdesdip='';
}
function LOpt_YMJRPKIKSX() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('anadip','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODDIP','C'));
l_oWv.setValue('LinkedField',WtA('CODDIP','C'));
l_oWv.setValue('UID',WtA('YMJRPKIKSX','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['YMJRPKIKSX'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('1813072817'),'C'));
return l_oWv;
}
function Link_DSKEQYLWDR(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_RAPPORTO);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('RAPPORTO',w_RAPPORTO,25,0);
l_Appl.SetFields('RAPPORTO,DESCRAP');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('knarapbo');
l_Appl.SetID('DSKEQYLWDR');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_RAPPORTO=l_Appl.GetStringValue('RAPPORTO',25,0);
w_xdesrap=l_Appl.GetStringValue('DESCRAP',50,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_DSKEQYLWDR_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_DSKEQYLWDR';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_DSKEQYLWDR();
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
function Link_DSKEQYLWDR_Blank() {
w_RAPPORTO='';
w_xdesrap='';
}
function LOpt_DSKEQYLWDR() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('knarapbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('RAPPORTO','C'));
l_oWv.setValue('LinkedField',WtA('RAPPORTO','C'));
l_oWv.setValue('UID',WtA('DSKEQYLWDR','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['DSKEQYLWDR'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('10787309997'),'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'YMJRPKIKSX')) {
last_focused_comp=GetLastFocusedElementOfLink('YMJRPKIKSX');
function SetMethod_YMJRPKIKSX() {
Set_CODDIPE(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_YMJRPKIKSX();
} else {
setTimeout(SetMethod_YMJRPKIKSX,1);
}
bResult=true;
}
if (Eq(varName,'DSKEQYLWDR')) {
last_focused_comp=GetLastFocusedElementOfLink('DSKEQYLWDR');
function SetMethod_DSKEQYLWDR() {
Set_RAPPORTO(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_DSKEQYLWDR();
} else {
setTimeout(SetMethod_DSKEQYLWDR,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'YMJRPKIKSX')) {
return [Ctrl('YMJRPKIKSX')];
}
if (Eq(varName,'DSKEQYLWDR')) {
return [Ctrl('DSKEQYLWDR')];
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
parent.ZtVWeb.raiseEventToEvalParms('armt_cgo_telematico_err_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('armt_cgo_telematico_err_dataNotSent',{'action':formaction});
}
}
}
}
CheckChild.child=[];
function Check() {
var l_bResult = true;
ResetErrorVars();
m_nLastError=0;
if ( ! (_ChkObl('GSWVKRDVIZ',1))) {
_SignErr('GSWVKRDVIZ');
m_cLastWorkVarErrorMsg='11993248424';
l_bResult=false;
w_SNAINUMOPE=HtW('','C');
} else if ( ! (_ChkObl('XUFFKSTRWQ',1))) {
_SignErr('XUFFKSTRWQ');
m_cLastWorkVarErrorMsg='11281918484';
l_bResult=false;
w_ENV=HtW('','C');
} else if ( ! (_ChkObl('YMJRPKIKSX',1))) {
_SignErr('YMJRPKIKSX');
m_cLastWorkVarErrorMsg='2071283709';
l_bResult=false;
w_CODDIPE=HtW('','C');
} else if ( ! (_ChkObl('DSKEQYLWDR',1))) {
_SignErr('DSKEQYLWDR');
m_cLastWorkVarErrorMsg='10379997930';
l_bResult=false;
w_RAPPORTO=HtW('','C');
} else if ( ! (_ChkObl('UQYWDDPGQG',1))) {
_SignErr('UQYWDDPGQG');
m_cLastWorkVarErrorMsg='1825772649';
l_bResult=false;
w_TOTLIRE=HtW('','N');
} else if ( ! (_ChkObl('NSVLOKQVAT',1))) {
_SignErr('NSVLOKQVAT');
m_cLastWorkVarErrorMsg='1464986651';
l_bResult=false;
w_CADATAORA=HtW('','T');
} else if ( ! (_ChkObl('YMUBWPUUZX',1))) {
_SignErr('YMUBWPUUZX');
m_cLastWorkVarErrorMsg='10524120562';
l_bResult=false;
w_CAIDBIGLIETTO=HtW('','C');
} else if ( ! (_ChkObl('TVQKRQXOUS',1))) {
_SignErr('TVQKRQXOUS');
m_cLastWorkVarErrorMsg='118057317';
l_bResult=false;
w_TXTERR=HtW('','M');
} else if ( ! (_ChkObl('EOSKLIUGBC',1))) {
_SignErr('EOSKLIUGBC');
m_cLastWorkVarErrorMsg='10651434988';
l_bResult=false;
w_MEZPAGAM=HtW('','C');
} else if ((Eq(w_MEZPAGAM,'I') || Eq(w_MEZPAGAM,'E')) && (( ! (_ChkObl('UTUCDPQJKK',1))) || ( ! (arfn_chkiban(Upper(w_IBAN),w_MEZPAGAM))))) {
_SignErr('UTUCDPQJKK','11525797640');
l_bResult=false;
w_IBAN=HtW('','C');
} else if ( ! (_ChkObl('WJQFIEBCQV',1))) {
_SignErr('WJQFIEBCQV');
m_cLastWorkVarErrorMsg='1814604627';
l_bResult=false;
w_CACODICE=HtW('','N');
} else if ( ! (_ChkObl('AYCRVWSEMG',1))) {
_SignErr('AYCRVWSEMG');
m_cLastWorkVarErrorMsg='1791194163';
l_bResult=false;
w_FLGFULL='N';
} else if ( ! (_ChkObl('XQXYVWITMV',1))) {
_SignErr('XQXYVWITMV');
m_cLastWorkVarErrorMsg='1570205239';
l_bResult=false;
w_CATIPGIO=HtW('','N');
} else if ( ! (_ChkObl('BRJUUNWDMJ',1))) {
_SignErr('BRJUUNWDMJ');
m_cLastWorkVarErrorMsg='414716055';
l_bResult=false;
w_CATIPCON=HtW('','N');
} else if ( ! (_ChkObl('CTQAPOFAUI',1))) {
_SignErr('CTQAPOFAUI');
m_cLastWorkVarErrorMsg='76780720';
l_bResult=false;
w_CAPV_COD=HtW('','N');
}
if (l_bResult) {
l_bResult=CheckChild(0);
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('GSWVKRDVIZ_ZOOM',lc)) {
return 0;
}
if (Eq('YMJRPKIKSX_ZOOM',lc)) {
return 0;
}
if (Eq('YMJRPKIKSX',lc)) {
return 0;
}
if (Eq('DSKEQYLWDR_ZOOM',lc)) {
return 1;
}
if (Eq('DSKEQYLWDR',lc)) {
return 1;
}
if (Eq('UQYWDDPGQG_ZOOM',lc)) {
return 2;
}
if (Eq('NSVLOKQVAT_ZOOM',lc)) {
return 2;
}
if (Eq('YMUBWPUUZX_ZOOM',lc)) {
return 2;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_YMJRPKIKSX();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,1)) {
l_oWv=LOpt_DSKEQYLWDR();
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
l_oWv.setValue('SNAINUMOPE',WtA(w_SNAINUMOPE,'C'));
l_oWv.setValue('ENV',WtA(w_ENV,'C'));
l_oWv.setValue('CODDIPE',WtA(w_CODDIPE,'C'));
l_oWv.setValue('RAPPORTO',WtA(w_RAPPORTO,'C'));
l_oWv.setValue('TOTLIRE',WtA(w_TOTLIRE,'N'));
l_oWv.setValue('CADATAORA',WtA(w_CADATAORA,'T'));
l_oWv.setValue('CAIDBIGLIETTO',WtA(w_CAIDBIGLIETTO,'C'));
l_oWv.setValue('CSMF_COD',WtA(w_CSMF_COD,'N'));
l_oWv.setValue('NUM_CONC',WtA(w_NUM_CONC,'N'));
l_oWv.setValue('P_VEND',WtA(w_P_VEND,'N'));
l_oWv.setValue('IPCOLLEG',WtA(w_IPCOLLEG,'C'));
l_oWv.setValue('ORACOLLEG',WtA(w_ORACOLLEG,'T'));
l_oWv.setValue('DUCOLLEG',WtA(w_DUCOLLEG,'N'));
l_oWv.setValue('TXTERR',WtA(w_TXTERR,'M'));
l_oWv.setValue('MEZPAGAM',WtA(w_MEZPAGAM,'C'));
l_oWv.setValue('IBAN',WtA(w_IBAN,'C'));
l_oWv.setValue('CACODICE',WtA(w_CACODICE,'N'));
l_oWv.setValue('FLGFULL',WtA(w_FLGFULL,'C'));
l_oWv.setValue('CATIPGIO',WtA(w_CATIPGIO,'N'));
l_oWv.setValue('CATIPCON',WtA(w_CATIPCON,'N'));
l_oWv.setValue('CAPV_COD',WtA(w_CAPV_COD,'N'));
l_oWv.setValue('xdesdip',WtA(w_xdesdip,'C'));
l_oWv.setValue('xdesrap',WtA(w_xdesrap,'C'));
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
FillWv.n=["SNAINUMOPE","ENV","CODDIPE","RAPPORTO","TOTLIRE","CADATAORA","CAIDBIGLIETTO","CSMF_COD","NUM_CONC","P_VEND","IPCOLLEG","ORACOLLEG","DUCOLLEG","TXTERR","MEZPAGAM","IBAN","CACODICE","FLGFULL","CATIPGIO","CATIPCON","CAPV_COD","xdesdip","xdesrap"];
function SetModified() {
m_bUpdated=true;
}
