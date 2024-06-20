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
function DisplayErrorMessage_ardt_ae_saldianno_rap() {
if ( ! (ChildToLoad(FrameRef('ardt_ae_saldianno_rap'))) && Ne(typeof(FrameRef('ardt_ae_saldianno_rap').DisplayErrorMessage),'undefined')) {
FrameRef('ardt_ae_saldianno_rap').DisplayErrorMessage();
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
Z.Tabs.Get('tabs').SetDisable('page_1',Eq(w_ASPEDITO,1) || IsDisabledByStateDriver(Z.Tabs.Get('tabs').GetTabstripID('page_1')));
l_bEnabled= ! ( ! (Empty(w_RAPPORTO)) && Eq(w_ASPEDITO,1) && (Eq(m_cFunction,'view') || Eq(m_cFunction,'edit')));
SetDisabled('GCHWZOBGPB',l_bEnabled);
l_bEnabled= ! ( ! (Empty(w_RAPPORTO)) && Eq(w_ASPEDITO,1) && (Eq(m_cFunction,'view') || Eq(m_cFunction,'edit')));
SetDisabled('NALNSNTYAI',l_bEnabled);
l_bEnabled= ! (Eq(m_cFunction,'view'));
SetDisabled('RHOMZTFXOQ',l_bEnabled);
l_bEnabled= ! (Ne(1,1)) || IsDisabledByStateDriver('CPROG');
SetDisabled('RPTFBMPRFK',l_bEnabled);
l_bEnabled= ! (Ne(1,1)) || IsDisabledByStateDriver('CFILE');
SetDisabled('GEAGHOYNJV',l_bEnabled);
l_bEnabled= ! (Ne(1,1)) || IsDisabledByStateDriver('ADATA');
SetDisabled('KGVKWENSDZ',l_bEnabled);
l_bEnabled= ! (Ne(1,1)) || IsDisabledByStateDriver('CDATA');
SetDisabled('UJYQWLUHMX',l_bEnabled);
if (IsDisabledByStateDriver('box_XDYFKZMJHC')) {
DisableInputsInContainer(Ctrl('XDYFKZMJHC'),true);
}
if (IsDisabledByStateDriver('box_KLSWWEOHOR')) {
DisableInputsInContainer(Ctrl('KLSWWEOHOR'),true);
}
if (IsDisabledByStateDriver('box_BJDGPHQYFI')) {
DisableInputsInContainer(Ctrl('BJDGPHQYFI'),true);
}
if (IsDisabledByStateDriver('box_WNPHGDFVJX')) {
DisableInputsInContainer(Ctrl('WNPHGDFVJX'),true);
}
if (IsDisabledByStateDriver('box_RANZSHNOJF')) {
DisableInputsInContainer(Ctrl('RANZSHNOJF'),true);
}
if (IsDisabledByStateDriver('box_UBHZWYZYEF')) {
DisableInputsInContainer(Ctrl('UBHZWYZYEF'),true);
}
if (IsDisabledByStateDriver('box_TGJYPNQVEJ')) {
DisableInputsInContainer(Ctrl('TGJYPNQVEJ'),true);
}
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
SetErrorField('VKTPGVCBJR',false);
SetErrorField('SQFHVLZLRL',false);
SetErrorField('CCYVNDNRFK',false);
SetErrorField('GZYOVGKBQU',false);
SetErrorField('RPTFBMPRFK',false);
SetErrorField('GEAGHOYNJV',false);
SetErrorField('KGVKWENSDZ',false);
SetErrorField('UJYQWLUHMX',false);
SetErrorField('LJUMSXSYFZ',false);
SetErrorField('ZEWCJCWNSV',false);
SetErrorField('YYRSSVEWOX',false);
SetErrorField('FDSYVBCPAC',false);
}
function Set_RAPPORTO(ctrlValue,kmode,e) {
if (Ne(w_RAPPORTO,ctrlValue)) {
var ctl = _GetCtl(e,'UOVJKJLZBV');
if (_tracker.goon(ctl,ctrlValue)) {
w_RAPPORTO=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UOVJKJLZBV',0);
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
function Set_TIPOAG(ctrlValue,kmode,e) {
if (Ne(w_TIPOAG,ctrlValue)) {
var ctl = _GetCtl(e,'GGLQTNYWZF');
if (_tracker.goon(ctl,ctrlValue)) {
w_TIPOAG=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('GGLQTNYWZF',0);
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
function Set_COINT(ctrlValue,kmode,e) {
if (Ne(w_COINT,ctrlValue)) {
var ctl = _GetCtl(e,'BLOIDAPXRQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_COINT=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BLOIDAPXRQ',0);
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
function Set_CPROG(ctrlValue,kmode,e) {
if (Ne(w_CPROG,ctrlValue)) {
var ctl = _GetCtl(e,'RPTFBMPRFK');
if (_tracker.goon(ctl,ctrlValue)) {
w_CPROG=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RPTFBMPRFK',0);
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
function Set_CFILE(ctrlValue,kmode,e) {
if (Ne(w_CFILE,ctrlValue)) {
var ctl = _GetCtl(e,'GEAGHOYNJV');
if (_tracker.goon(ctl,ctrlValue)) {
w_CFILE=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('GEAGHOYNJV',0);
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
function Set_CONNESINT(ctrlValue,kmode,e) {
if (Ne(w_CONNESINT,ctrlValue)) {
var ctl = _GetCtl(e,'ZWBKZJLHCV');
if (_tracker.goon(ctl,ctrlValue)) {
w_CONNESINT=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ZWBKZJLHCV',0);
if (l_bResult) {
l_bResult=Link_ZWBKZJLHCV(kmode);
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
function Set_ASPEDITO(ctrlValue,kmode,e) {
if (Ne(w_ASPEDITO,ctrlValue)) {
var ctl = _GetCtl(e,'VKTPGVCBJR');
if (_tracker.goon(ctl,ctrlValue)) {
w_ASPEDITO=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VKTPGVCBJR',0);
DoUpdate(l_bResult);
if(c=Ctrl('VKTPGVCBJR')) ChkboxCheckUncheck(c,1,w_ASPEDITO)
if(c=Ctrl('VKTPGVCBJR')) ChkboxValueAssign(c,1,0,'N',1,0,'')
return l_bResult;
} else {
ctl.value=WtH(0,'N',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_ADATA(ctrlValue,kmode,e) {
if (Ne(w_ADATA,ctrlValue)) {
var ctl = _GetCtl(e,'ZYSXZRLIHG');
if (_tracker.goon(ctl,ctrlValue)) {
w_ADATA=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ZYSXZRLIHG',0);
l_bResult=l_bResult && _ChkObl('KGVKWENSDZ',0);
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
function Set_APROG(ctrlValue,kmode,e) {
if (Ne(w_APROG,ctrlValue)) {
var ctl = _GetCtl(e,'SQFHVLZLRL');
if (_tracker.goon(ctl,ctrlValue)) {
w_APROG=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SQFHVLZLRL',0);
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
function Set_CAB(ctrlValue,kmode,e) {
if (Ne(w_CAB,ctrlValue)) {
var ctl = _GetCtl(e,'CODMGYDXYT');
if (_tracker.goon(ctl,ctrlValue)) {
w_CAB=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CODMGYDXYT',0);
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
function Set_AFILE(ctrlValue,kmode,e) {
if (Ne(w_AFILE,ctrlValue)) {
var ctl = _GetCtl(e,'CCYVNDNRFK');
if (_tracker.goon(ctl,ctrlValue)) {
w_AFILE=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CCYVNDNRFK',0);
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
function Set_VALUTA(ctrlValue,kmode,e) {
if (Ne(w_VALUTA,ctrlValue)) {
var ctl = _GetCtl(e,'AKLWIUMNVR');
if (_tracker.goon(ctl,ctrlValue)) {
w_VALUTA=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('AKLWIUMNVR',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',3,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_COLDFILE(ctrlValue,kmode,e) {
if (Ne(w_COLDFILE,ctrlValue)) {
var ctl = _GetCtl(e,'YYRSSVEWOX');
if (_tracker.goon(ctl,ctrlValue)) {
w_COLDFILE=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NVIYVKNNOM',0);
l_bResult=l_bResult && _ChkObl('YYRSSVEWOX',0);
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
function Set_CSPEDITO(ctrlValue,kmode,e) {
if (Ne(w_CSPEDITO,ctrlValue)) {
var ctl = _GetCtl(e,'GZYOVGKBQU');
if (_tracker.goon(ctl,ctrlValue)) {
w_CSPEDITO=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('GZYOVGKBQU',0);
DoUpdate(l_bResult);
if(c=Ctrl('GZYOVGKBQU')) ChkboxCheckUncheck(c,1,w_CSPEDITO)
if(c=Ctrl('GZYOVGKBQU')) ChkboxValueAssign(c,1,0,'N',1,0,'')
return l_bResult;
} else {
ctl.value=WtH(0,'N',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_CDATA(ctrlValue,kmode,e) {
if (Ne(w_CDATA,ctrlValue)) {
var ctl = _GetCtl(e,'YQJXLYYDEK');
if (_tracker.goon(ctl,ctrlValue)) {
w_CDATA=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YQJXLYYDEK',0);
l_bResult=l_bResult && _ChkObl('UJYQWLUHMX',0);
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
var ctl = _GetCtl(e,'ZEWCJCWNSV');
if (_tracker.goon(ctl,ctrlValue)) {
w_RSPEDITO=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ZEWCJCWNSV',0);
DoUpdate(l_bResult);
if(c=Ctrl('ZEWCJCWNSV')) ChkboxCheckUncheck(c,1,w_RSPEDITO)
if(c=Ctrl('ZEWCJCWNSV')) ChkboxValueAssign(c,1,0,'N',1,0,'')
return l_bResult;
} else {
ctl.value=WtH(0,'N',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_COLDPROG(ctrlValue,kmode,e) {
if (Ne(w_COLDPROG,ctrlValue)) {
var ctl = _GetCtl(e,'FDSYVBCPAC');
if (_tracker.goon(ctl,ctrlValue)) {
w_COLDPROG=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RNQDSBHRRV',0);
l_bResult=l_bResult && _ChkObl('FDSYVBCPAC',0);
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
function Set_ADATARET(ctrlValue,kmode,e) {
if (Ne(w_ADATARET,ctrlValue)) {
var ctl = _GetCtl(e,'LJUMSXSYFZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_ADATARET=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CZKERSYIAL',0);
l_bResult=l_bResult && _ChkObl('LJUMSXSYFZ',0);
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
function Calculate() {
var l_bTmpRes;
var l_bResult = true;
m_bCalculating=true;
UpdateAutonumber('PROGAET');
w_IDBASE=LibreriaMit.UniqueId();
if ((Ne(o_IDBASE,w_IDBASE))) {
l_bTmpRes=Link_NQPTOOEBKN(null);
}
UpdateAutonumber('PROGAER');
if ( ! (ChildToLoad(FrameRef('ardt_ae_saldianno_rap'))) && Ne(typeof(FrameRef('ardt_ae_saldianno_rap').DoUpdate),'undefined')) {
CopyWorkVar(FrameRef('ardt_ae_saldianno_rap'),['TIPRAP'],['TIPOAG'],true)
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
o_TIPOAG=w_TIPOAG;
o_IDBASE=w_IDBASE;
}
function SaveLabelDependsOn() {
}
function Link_ZWBKZJLHCV(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CONNESINT);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CONNES',w_CONNESINT,16,0);
l_Appl.SetFields('CONNES,RAGSOC,CFESTERO');
l_Appl.SetTypes('C,C,N');
l_Appl.LinkTable('personbo');
l_Appl.SetID('ZWBKZJLHCV');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CONNESINT=l_Appl.GetStringValue('CONNES',16,0);
w_xragsoc=l_Appl.GetStringValue('RAGSOC',70,0);
w_CFESTERO=l_Appl.GetDoubleValue('CFESTERO',1,0);
l_Appl.GetLinkHash(GetRepeatedCheckVars());
} else {
Link_ZWBKZJLHCV_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_ZWBKZJLHCV';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_ZWBKZJLHCV();
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
function Link_ZWBKZJLHCV_Blank() {
w_CONNESINT='';
w_xragsoc='';
w_CFESTERO=0;
}
function LOpt_ZWBKZJLHCV() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('personbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CONNES','C'));
l_oWv.setValue('LinkedField',WtA('CONNES','C'));
l_oWv.setValue('UID',WtA('ZWBKZJLHCV','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['ZWBKZJLHCV'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('195812931'),'C'));
return l_oWv;
}
function Link_NQPTOOEBKN(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_IDBASE);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('IDBASE',w_IDBASE,10,0);
l_Appl.SetFields('IDBASE,IDFILE,IDPROG,SPEDITO,DATARIF');
l_Appl.SetTypes('C,C,C,N,D');
l_Appl.LinkTable('aecanc');
l_Appl.SetID('NQPTOOEBKN');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_IDBASE=l_Appl.GetStringValue('IDBASE',10,0);
w_filecanc=l_Appl.GetStringValue('IDFILE',15,0);
w_idcanc=l_Appl.GetStringValue('IDPROG',25,0);
w_spcanc=l_Appl.GetDoubleValue('SPEDITO',1,0);
w_dtcanc=l_Appl.GetDateValue('DATARIF',8,0);
w_dtcanc=DateFromApplet(w_dtcanc);
l_Appl.GetLinkHash(GetRepeatedCheckVars());
} else {
Link_NQPTOOEBKN_Blank();
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
function Link_NQPTOOEBKN_Blank() {
w_IDBASE='';
w_filecanc='';
w_idcanc='';
w_spcanc=0;
w_dtcanc=NullDate();
}
function LOpt_NQPTOOEBKN() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('aecanc','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('IDBASE','C'));
l_oWv.setValue('LinkedField',WtA('IDBASE','C'));
l_oWv.setValue('UID',WtA('NQPTOOEBKN','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['NQPTOOEBKN'][1],'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'ZWBKZJLHCV')) {
last_focused_comp=GetLastFocusedElementOfLink('ZWBKZJLHCV');
function SetMethod_ZWBKZJLHCV() {
Set_CONNESINT(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_ZWBKZJLHCV();
} else {
setTimeout(SetMethod_ZWBKZJLHCV,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'ZWBKZJLHCV')) {
return [Ctrl('ZWBKZJLHCV')];
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
parent.ZtVWeb.raiseEventToEvalParms('armd_anagrappo_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('armd_anagrappo_dataNotSent',{'action':formaction});
}
}
}
}
CheckChild.child=[{'prg':"ardt_ae_saldianno_rap",'BOScId':function(){return FrameRef('ardt_ae_saldianno_rap')},'repeated':0}];
function Check() {
var l_bResult = true;
var l_bChildCheck = true;
ResetErrorVars();
if ( ! (_ChkObl('UOVJKJLZBV',1))) {
_SignErr('UOVJKJLZBV');
m_cLastWorkVarErrorMsg='11116511596';
l_bResult=false;
w_RAPPORTO=HtW('','C');
} else if ( ! (_ChkObl('GGLQTNYWZF',1))) {
_SignErr('GGLQTNYWZF');
m_cLastWorkVarErrorMsg='1723736132';
l_bResult=false;
w_TIPOAG=HtW('','C');
} else if ( ! (_ChkObl('BLOIDAPXRQ',1))) {
_SignErr('BLOIDAPXRQ');
m_cLastWorkVarErrorMsg='1723736132';
l_bResult=false;
w_COINT=HtW('','C');
} else if ( ! (_ChkObl('CODMGYDXYT',1))) {
_SignErr('CODMGYDXYT');
m_cLastWorkVarErrorMsg='18003';
l_bResult=false;
w_CAB=HtW('','C');
} else if ( ! (_ChkObl('AKLWIUMNVR',1))) {
_SignErr('AKLWIUMNVR');
m_cLastWorkVarErrorMsg='109822566';
l_bResult=false;
w_VALUTA=HtW('','C');
}
if (l_bResult) {
l_bResult=CheckChild(0);
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('ZWBKZJLHCV_ZOOM',lc)) {
return 0;
}
if (Eq('ZWBKZJLHCV',lc)) {
return 0;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_ZWBKZJLHCV();
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
l_oWv.setValue('TIPOAG',WtA(w_TIPOAG,'C'));
l_oWv.setValue('COINT',WtA(w_COINT,'C'));
l_oWv.setValue('RIFANA',WtA(w_RIFANA,'C'));
l_oWv.setValue('UNIQUECODE',WtA(w_UNIQUECODE,'C'));
l_oWv.setValue('CAB',WtA(w_CAB,'C'));
l_oWv.setValue('VALUTA',WtA(w_VALUTA,'C'));
l_oWv.setValue('PROGAET',WtA(w_PROGAET,'N'));
l_oWv.setValue('op_PROGAET',WtA(op_PROGAET,'N'));
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
_FillChildren.n=['ardt_ae_saldianno_rap'];
FillWv.n=["RAPPORTO","TIPOAG","COINT","RIFANA","UNIQUECODE","CAB","VALUTA","PROGAET"];
function CheckRow(w) {
var l_bResult = true;
var l_bChildCheck = true;
ResetErrorVars();
if (Le(m_nCurrentRow,Rows())) {
if (( ! (_ChkObl('ZWBKZJLHCV',1))) && FullRow()) {
_SignErr('ZWBKZJLHCV');
m_cLastWorkVarErrorMsg='1095110115';
l_bResult=false;
w_CONNESINT=HtW('','C');
} else if (( ! (_ChkObl('VKTPGVCBJR',1))) && FullRow()) {
_SignErr('VKTPGVCBJR');
m_cLastWorkVarErrorMsg='348541329';
l_bResult=false;
w_ASPEDITO=0;
} else if (( ! (_ChkObl('ZYSXZRLIHG',1))) && FullRow()) {
_SignErr('ZYSXZRLIHG');
m_cLastWorkVarErrorMsg='10996202746';
l_bResult=false;
w_ADATA=HtW('','D');
} else if (( ! (_ChkObl('SQFHVLZLRL',1))) && FullRow()) {
_SignErr('SQFHVLZLRL');
m_cLastWorkVarErrorMsg='264260953';
l_bResult=false;
w_APROG=HtW('','C');
} else if (( ! (_ChkObl('CCYVNDNRFK',1))) && FullRow()) {
_SignErr('CCYVNDNRFK');
m_cLastWorkVarErrorMsg='11745066193';
l_bResult=false;
w_AFILE=HtW('','C');
} else if (( ! (_ChkObl('GZYOVGKBQU',1))) && FullRow()) {
_SignErr('GZYOVGKBQU');
m_cLastWorkVarErrorMsg='11149805813';
l_bResult=false;
w_CSPEDITO=0;
} else if (( ! (_ChkObl('YQJXLYYDEK',1))) && FullRow()) {
_SignErr('YQJXLYYDEK');
m_cLastWorkVarErrorMsg='1747631465';
l_bResult=false;
w_CDATA=HtW('','D');
} else if (((Ne(1,1)) && ( ! (_ChkObl('RPTFBMPRFK',1)))) && FullRow()) {
_SignErr('RPTFBMPRFK');
m_cLastWorkVarErrorMsg='803225745';
l_bResult=false;
w_CPROG=HtW('','C');
} else if (((Ne(1,1)) && ( ! (_ChkObl('GEAGHOYNJV',1)))) && FullRow()) {
_SignErr('GEAGHOYNJV');
m_cLastWorkVarErrorMsg='11116236915';
l_bResult=false;
w_CFILE=HtW('','C');
} else if (((Ne(1,1)) && ( ! (_ChkObl('KGVKWENSDZ',1)))) && FullRow()) {
_SignErr('KGVKWENSDZ');
m_cLastWorkVarErrorMsg='10996202746';
l_bResult=false;
w_ADATA=HtW('','D');
} else if (((Ne(1,1)) && ( ! (_ChkObl('UJYQWLUHMX',1)))) && FullRow()) {
_SignErr('UJYQWLUHMX');
m_cLastWorkVarErrorMsg='1747631465';
l_bResult=false;
w_CDATA=HtW('','D');
} else if (( ! (_ChkObl('LJUMSXSYFZ',1))) && FullRow()) {
_SignErr('LJUMSXSYFZ');
m_cLastWorkVarErrorMsg='1264402456';
l_bResult=false;
w_ADATARET=HtW('','D');
} else if (( ! (_ChkObl('ZEWCJCWNSV',1))) && FullRow()) {
_SignErr('ZEWCJCWNSV');
m_cLastWorkVarErrorMsg='1205724772';
l_bResult=false;
w_RSPEDITO=0;
} else if (( ! (_ChkObl('YYRSSVEWOX',1))) && FullRow()) {
_SignErr('YYRSSVEWOX');
m_cLastWorkVarErrorMsg='10991326470';
l_bResult=false;
w_COLDFILE=HtW('','C');
} else if (( ! (_ChkObl('FDSYVBCPAC',1))) && FullRow()) {
_SignErr('FDSYVBCPAC');
m_cLastWorkVarErrorMsg='11752966299';
l_bResult=false;
w_COLDPROG=HtW('','C');
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
var l_bChildCheck = true;
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
function SetChildVariables_ardt_ae_saldianno_rap() {
if ( ! (ChildToLoad(FrameRef('ardt_ae_saldianno_rap'))) && Ne(typeof(FrameRef('ardt_ae_saldianno_rap').DoUpdate),'undefined')) {
CopyWorkVar(FrameRef('ardt_ae_saldianno_rap'),['TIPRAP'],['TIPOAG'],false)
}
}
function CtxLoad_ardt_ae_saldianno_rap() {
if (ChildToLoad(FrameRef('ardt_ae_saldianno_rap'))) {
return [LoadContext(0,'KGHSUPPYWT'),'ardt_ae_saldianno_rap'];
}
}
SaveContext.child=[];
function BlankRow() {
w_CONNESINT='';
w_ASPEDITO=0;
w_ADATA=NullDate();
w_APROG='';
w_AOLDPROG='';
w_AFILE='';
w_AOLDFILE='';
w_ADATARET=NullDate();
w_CSPEDITO=0;
w_CDATA=NullDate();
w_CPROG='';
w_COLDPROG='';
w_CFILE='';
w_COLDFILE='';
w_CDATARET=NullDate();
w_CFESTERO=0;
w_IDRIF='';
w_NOCODFISC='';
w_IDBASE='';
w_xragsoc='';
w_ADATA=NullDate();
w_CDATA=NullDate();
w_IDESITO='';
w_ADATARET=NullDate();
w_RSPEDITO=0;
w_COLDFILE='';
w_COLDPROG='';
w_IDBASE='';
w_dtcanc=NullDate();
w_spcanc=0;
w_filecanc='';
w_idcanc='';
w_PROGAER=0;
w_DATESITO=NullDate();
if ( ! (EmptyString(w_CONNESINT))) {
Link_ZWBKZJLHCV(null);
}
w_NOCODFISC=(Eq(w_CFESTERO,1)?'S':'N');
w_IDBASE=LibreriaMit.UniqueId();
if ( ! (EmptyString(w_IDBASE))) {
Link_NQPTOOEBKN(null);
}
BlankRowChild();
if (m_bExtended) {
BlankRepeatedExtendedFields();
}
SaveDependsOn();
LoadContext(true);
}
function FullRow() {
return  ! (Empty(w_CONNESINT));
}
function GetRepeatedFields() {
var l_aRepeatedFields;
l_aRepeatedFields={};
l_aRepeatedFields.CONNESINT={"dec":0,"fixedpos":false,"id":"ZWBKZJLHCV","len":16,"name":"CONNESINT","title":"Codice Intestatario","type":"C"};
l_aRepeatedFields.ASPEDITO={"dec":0,"fixedpos":true,"id":"VKTPGVCBJR","len":1,"name":"ASPEDITO","title":"Apertura Spedita","type":"N"};
l_aRepeatedFields.ADATA={"dec":0,"fixedpos":false,"id":"ZYSXZRLIHG","len":8,"name":"ADATA","title":"Data Apertura","type":"D"};
l_aRepeatedFields.APROG={"dec":0,"fixedpos":true,"id":"SQFHVLZLRL","len":25,"name":"APROG","title":"Riferimento Spedizione Apertura","type":"C"};
l_aRepeatedFields.AOLDPROG={"dec":0,"fixedpos":true,"id":"OAIYRWXAMX","len":25,"name":"AOLDPROG","title":"Precedente progressivo spedizione","type":"C"};
l_aRepeatedFields.AFILE={"dec":0,"fixedpos":true,"id":"CCYVNDNRFK","len":15,"name":"AFILE","title":"Riferimento file spedizione","type":"C"};
l_aRepeatedFields.AOLDFILE={"dec":0,"fixedpos":true,"id":"IUSGHXIISC","len":15,"name":"AOLDFILE","title":"Riferimento file vecchia spedizione","type":"C"};
l_aRepeatedFields.ADATARET={"dec":0,"fixedpos":true,"id":"CZKERSYIAL","len":8,"name":"ADATARET","title":"Data rettifica apertura","type":"D"};
l_aRepeatedFields.CSPEDITO={"dec":0,"fixedpos":true,"id":"GZYOVGKBQU","len":1,"name":"CSPEDITO","title":"Data Spedizione Chiusura","type":"N"};
l_aRepeatedFields.CDATA={"dec":0,"fixedpos":false,"id":"YQJXLYYDEK","len":8,"name":"CDATA","title":"Data Chiusura Rapporto","type":"D"};
l_aRepeatedFields.CPROG={"dec":0,"fixedpos":true,"id":"RPTFBMPRFK","len":25,"name":"CPROG","title":"Riferimento spedizione chiusura","type":"C"};
l_aRepeatedFields.COLDPROG={"dec":0,"fixedpos":true,"id":"RNQDSBHRRV","len":25,"name":"COLDPROG","title":"Precedente riferimento chiusura","type":"C"};
l_aRepeatedFields.CFILE={"dec":0,"fixedpos":true,"id":"GEAGHOYNJV","len":15,"name":"CFILE","title":"File spedizione Chiusura","type":"C"};
l_aRepeatedFields.COLDFILE={"dec":0,"fixedpos":true,"id":"NVIYVKNNOM","len":15,"name":"COLDFILE","title":"Precedente file spedizione chiusura","type":"C"};
l_aRepeatedFields.CDATARET={"dec":0,"fixedpos":true,"id":"RPAPTABXZS","len":8,"name":"CDATARET","title":"Data rettifica chiusura","type":"D"};
l_aRepeatedFields.IDRIF={"dec":0,"fixedpos":true,"id":"NHPKDFXFCP","len":10,"name":"IDRIF","title":"","type":"C"};
l_aRepeatedFields.NOCODFISC={"dec":0,"fixedpos":true,"id":"WCNHESKIML","len":1,"name":"NOCODFISC","title":"No codice fiscale (Non assegnato agenzia entrate)","type":"C"};
l_aRepeatedFields.IDBASE={"dec":0,"fixedpos":true,"id":"VSUMQVCVVG","len":10,"name":"IDBASE","title":"IDBASE","type":"C"};
l_aRepeatedFields.IDESITO={"dec":0,"fixedpos":true,"id":"IANSHYURPV","len":8,"name":"IDESITO","title":"ID ESITO","type":"C"};
l_aRepeatedFields.RSPEDITO={"dec":0,"fixedpos":true,"id":"ZEWCJCWNSV","len":1,"name":"RSPEDITO","title":"Rettifica Inviata","type":"N"};
l_aRepeatedFields.PROGAER={"dec":0,"fixedpos":true,"id":"IRXSJJMVOG","len":15,"name":"PROGAER","title":"Progressivo Riga","type":"N"};
l_aRepeatedFields.DATESITO={"dec":0,"fixedpos":true,"id":"YJETHTLSAS","len":8,"name":"DATESITO","title":"Data Generazione Esito","type":"D"};
l_aRepeatedFields.CFESTERO={"dec":0,"fixedpos":true,"id":"UMTVUFKUXX","len":1,"name":"CFESTERO","title":"Codice Fiscale Estero","type":"N"};
l_aRepeatedFields.xragsoc={"dec":0,"fixedpos":false,"id":"VCSXGLJKMU","len":70,"name":"xragsoc","title":"Ragione Sociale","type":"C"};
l_aRepeatedFields.dtcanc={"dec":0,"fixedpos":true,"id":"CGGFGFHNLQ","len":8,"name":"dtcanc","title":"","type":"D"};
l_aRepeatedFields.spcanc={"dec":0,"fixedpos":true,"id":"PULJPVPYAY","len":1,"name":"spcanc","title":"","type":"N"};
l_aRepeatedFields.filecanc={"dec":0,"fixedpos":true,"id":"CPXILLMFYQ","len":15,"name":"filecanc","title":"","type":"C"};
l_aRepeatedFields.idcanc={"dec":0,"fixedpos":true,"id":"MQSDKNMJUI","len":25,"name":"idcanc","title":"","type":"C"};
return l_aRepeatedFields;
}
function SubtractTotals() {
}
function hasDepOnTotals() {
}
function DisableChainedLinks(disable) {
}
