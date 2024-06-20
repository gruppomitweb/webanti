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
function DisplayErrorMessage_ardt_ae_delegabo() {
if ( ! (ChildToLoad(FrameRef('ardt_ae_delegabo'))) && Ne(typeof(FrameRef('ardt_ae_delegabo').DisplayErrorMessage),'undefined')) {
FrameRef('ardt_ae_delegabo').DisplayErrorMessage();
}
}
function DisplayErrorMessage_ardt_saldioro() {
if ( ! (ChildToLoad(FrameRef('ardt_saldioro'))) && Ne(typeof(FrameRef('ardt_saldioro').DisplayErrorMessage),'undefined')) {
FrameRef('ardt_saldioro').DisplayErrorMessage();
}
}
function DisplayErrorMessage_ardt_jarantbo() {
if ( ! (ChildToLoad(FrameRef('ardt_jarantbo'))) && Ne(typeof(FrameRef('ardt_jarantbo').DisplayErrorMessage),'undefined')) {
FrameRef('ardt_jarantbo').DisplayErrorMessage();
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
if (IsDisabledByStateDriver('DatiBase')) {
DisableInputsInContainer(Ctrl('YORQOIOBQN'),true);
}
if (IsDisabledByStateDriver('DatiBase')) {
DisableInputsInContainer(Ctrl('GJZISGEBVV'),true);
}
if (IsDisabledByStateDriver('Rapporto')) {
DisableInputsInContainer(Ctrl('LZCEHELAXJ'),true);
}
if (IsDisabledByStateDriver('Deleghe')) {
DisableInputsInContainer(Ctrl('EHSQLOIDHO'),true);
}
if (IsDisabledByStateDriver('SaldiOro')) {
DisableInputsInContainer(Ctrl('KAVLKRYWMM'),true);
}
if (IsDisabledByStateDriver('Garantiti')) {
DisableInputsInContainer(Ctrl('LWDMGLAEON'),true);
}
if (IsDisabledByStateDriver('Saldi')) {
DisableInputsInContainer(Ctrl('MUCCIMEJEB'),true);
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
SetObligatory(Ctrl('QBUCLWUNFT'),Eq(w_TIPOAG,'96') || Eq(w_TIPOAG,'97') || IsObligatoryByStateDriver('ISOAGE'));
}
function SetDynamicClasses() {
var c;
}
function SetDynamicTooltip() {
var c;
if(c=Ctrl('ZFOHYLVPYN')) c.title=Strtran(AlertErrorMessage('1951322326',w_TIPORAP),'\\n',"\n");
if(c=Ctrl('BHAVHLFPAC')) c.title=Strtran(AlertErrorMessage('1682876716',w_TIPOAG),'\\n',"\n");
if(c=Ctrl('BCLYMGMBLK')) c.title=Strtran(AlertErrorMessage('191062270',w_FLAGLIRE),'\\n',"\n");
}
function Set_ISOAGE(ctrlValue,kmode,e) {
if (Ne(w_ISOAGE,ctrlValue)) {
var ctl = _GetCtl(e,'QBUCLWUNFT');
if (_tracker.goon(ctl,ctrlValue)) {
w_ISOAGE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QBUCLWUNFT',0);
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
function Set_FLAGLIRE(ctrlValue,kmode,e) {
if (Ne(w_FLAGLIRE,ctrlValue)) {
var ctl = _GetCtl(e,'BCLYMGMBLK');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLAGLIRE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BCLYMGMBLK',0);
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
function Set_DESCRAP(ctrlValue,kmode,e) {
if (Ne(w_DESCRAP,ctrlValue)) {
var ctl = _GetCtl(e,'AQAARAIPOR');
if (_tracker.goon(ctl,ctrlValue)) {
w_DESCRAP=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('AQAARAIPOR',0);
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
function Set_TIPORAP(ctrlValue,kmode,e) {
if (Ne(w_TIPORAP,ctrlValue)) {
var ctl = _GetCtl(e,'ZFOHYLVPYN');
if (_tracker.goon(ctl,ctrlValue)) {
w_TIPORAP=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ZFOHYLVPYN',0);
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
function Set_VALUTA(ctrlValue,kmode,e) {
if (Ne(w_VALUTA,ctrlValue)) {
var ctl = _GetCtl(e,'RUMXLFCOKA');
if (_tracker.goon(ctl,ctrlValue)) {
w_VALUTA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RUMXLFCOKA',0);
if (l_bResult) {
l_bResult=Link_RUMXLFCOKA(kmode);
if ( ! (l_bResult)) {
w_VALUTA=HtW('','C');
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
function Calculate() {
var l_bTmpRes;
var l_bResult = true;
m_bCalculating=true;
if ((Ne(o_FLAGLIRE,w_FLAGLIRE)) || (Ne(o_VALUTA,w_VALUTA))) {
l_bTmpRes=Link_RUMXLFCOKA(null);
}
UpdateAutonumber('PRGIMPRAP');
w_titolo=(Eq(w_gTipInter,'14')?'Relazione d\'Affari (AGE)':'Rapporti Continuativi (AGE)')+' - '+LRTrim(w_RAPPORTO)+'-'+LRTrim(w_DESCRAP);
if ((Ne(o_FLAGLIRE,w_FLAGLIRE))) {
Calculation_ONQBRXXLXG();
}
w_mess='Messaggio\\nSecondo\\nTerzo';
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
function Calculation_ONQBRXXLXG() {
w_VALUTA=(Eq(w_FLAGLIRE,'L')?'018':(Eq(w_FLAGLIRE,'E')?'242':''));
}
function SaveDependsOn() {
o_TIPOAG=w_TIPOAG;
o_FLAGLIRE=w_FLAGLIRE;
o_VALUTA=w_VALUTA;
}
function SaveLabelDependsOn() {
}
function Link_RUMXLFCOKA(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_VALUTA);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODVAL',w_VALUTA,3,0);
l_Appl.SetFields('CODVAL,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbvalute');
l_Appl.SetLinkzoom('armt_divise');
l_Appl.SetID('RUMXLFCOKA');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_VALUTA=l_Appl.GetStringValue('CODVAL',3,0);
w_descval=l_Appl.GetStringValue('DESCRI',30,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_RUMXLFCOKA_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_RUMXLFCOKA';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_RUMXLFCOKA();
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
function Link_RUMXLFCOKA_Blank() {
w_VALUTA='';
w_descval='';
}
function LOpt_RUMXLFCOKA() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbvalute','C'));
l_oWv.setValue('Linkzoomprg',WtA('armt_divise','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODVAL','C'));
l_oWv.setValue('LinkedField',WtA('CODVAL','C'));
l_oWv.setValue('UID',WtA('RUMXLFCOKA','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['RUMXLFCOKA'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('114016870'),'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'RUMXLFCOKA')) {
last_focused_comp=GetLastFocusedElementOfLink('RUMXLFCOKA');
function SetMethod_RUMXLFCOKA() {
Set_VALUTA(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_RUMXLFCOKA();
} else {
setTimeout(SetMethod_RUMXLFCOKA,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'RUMXLFCOKA')) {
return [Ctrl('RUMXLFCOKA')];
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
parent.ZtVWeb.raiseEventToEvalParms('armt_ae_anarap_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('armt_ae_anarap_dataNotSent',{'action':formaction});
}
}
}
}
CheckChild.child=[{'prg':"ardt_ae_delegabo",'BOScId':function(){ return FrameRef('ardt_ae_delegabo')},'repeated':0},{'prg':"ardt_saldioro",'BOScId':function(){ return FrameRef('ardt_saldioro')},'repeated':0},{'prg':"ardt_jarantbo",'BOScId':function(){ return FrameRef('ardt_jarantbo')},'repeated':0},{'prg':"ardt_ae_saldianno_rap",'BOScId':function(){ return FrameRef('ardt_ae_saldianno_rap')},'repeated':0}];
function Check() {
var l_bResult = true;
var l_bChildCheck = true;
ResetErrorVars();
m_nLastError=0;
if ( ! (_ChkObl('LXORWVRYJJ',1))) {
_SignErr('LXORWVRYJJ');
m_cLastWorkVarErrorMsg='11116511596';
l_bResult=false;
w_RAPPORTO=HtW('','C');
} else if ( ! (_ChkObl('AQAARAIPOR',1))) {
_SignErr('AQAARAIPOR');
m_cLastWorkVarErrorMsg='285808099';
l_bResult=false;
w_DESCRAP=HtW('','C');
} else if ( ! (_ChkObl('ZFOHYLVPYN',1))) {
_SignErr('ZFOHYLVPYN');
m_cLastWorkVarErrorMsg='1723736132';
l_bResult=false;
w_TIPORAP=HtW('','C');
} else if ( ! (_ChkObl('BHAVHLFPAC',1))) {
_SignErr('BHAVHLFPAC');
m_cLastWorkVarErrorMsg='TIPOAG';
l_bResult=false;
w_TIPOAG=HtW('','C');
} else if ( ! (_ChkObl('QBUCLWUNFT',1))) {
_SignErr('QBUCLWUNFT');
m_cLastWorkVarErrorMsg='1529904207';
l_bResult=false;
w_ISOAGE=HtW('','C');
} else if ( ! (_ChkObl('BCLYMGMBLK',1))) {
_SignErr('BCLYMGMBLK');
m_cLastWorkVarErrorMsg='109710548';
l_bResult=false;
w_FLAGLIRE=HtW('','C');
} else if ( ! (_ChkObl('RUMXLFCOKA',1))) {
_SignErr('RUMXLFCOKA');
m_cLastWorkVarErrorMsg='1730321404';
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
if (Eq('RUMXLFCOKA_ZOOM',lc)) {
return 0;
}
if (Eq('RUMXLFCOKA',lc)) {
return 0;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_RUMXLFCOKA();
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
l_oWv.setValue('TIPORAP',WtA(w_TIPORAP,'C'));
l_oWv.setValue('TIPOAG',WtA(w_TIPOAG,'C'));
l_oWv.setValue('ISOAGE',WtA(w_ISOAGE,'C'));
l_oWv.setValue('FLAGLIRE',WtA(w_FLAGLIRE,'C'));
l_oWv.setValue('VALUTA',WtA(w_VALUTA,'C'));
l_oWv.setValue('PRGIMPRAP',WtA(w_PRGIMPRAP,'N'));
l_oWv.setValue('op_PRGIMPRAP',WtA(op_PRGIMPRAP,'N'));
l_oWv.setValue('CODDIP',WtA(w_CODDIP,'C'));
l_oWv.setValue('NOPROT',WtA(w_NOPROT,'N'));
l_oWv.setValue('gTelepass',WtA(w_gTelepass,'C'));
l_oWv.setValue('gCodDip',WtA(w_gCodDip,'C'));
l_oWv.setValue('gBrowser',WtA(w_gBrowser,'C'));
l_oWv.setValue('gTipInter',WtA(w_gTipInter,'C'));
l_oWv.setValue('descval',WtA(w_descval,'C'));
l_oWv.setValue('daticoll',WtA(w_daticoll,'N'));
l_oWv.setValue('titolo',WtA(w_titolo,'C'));
l_oWv.setValue('mess',WtA(w_mess,'M'));
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
_FillChildren.n=['ardt_ae_delegabo','ardt_saldioro','ardt_jarantbo','ardt_ae_saldianno_rap'];
FillWv.n=["RAPPORTO","DESCRAP","TIPORAP","TIPOAG","ISOAGE","FLAGLIRE","VALUTA","PRGIMPRAP","CODDIP","NOPROT","gTelepass","gCodDip","gBrowser","gTipInter","descval","daticoll","titolo","mess"];
function SetModified() {
m_bUpdated=true;
}
function SetChildVariables_ardt_ae_delegabo() {
}
function CtxLoad_ardt_ae_delegabo() {
if (ChildToLoad(FrameRef('ardt_ae_delegabo'))) {
return [LoadContext(0,'OYYXUVDIWN'),'ardt_ae_delegabo'];
}
}
function SetChildVariables_ardt_saldioro() {
}
function CtxLoad_ardt_saldioro() {
if (ChildToLoad(FrameRef('ardt_saldioro'))) {
return [LoadContext(0,'XRVFDCHTKZ'),'ardt_saldioro'];
}
}
function SetChildVariables_ardt_jarantbo() {
}
function CtxLoad_ardt_jarantbo() {
if (ChildToLoad(FrameRef('ardt_jarantbo'))) {
return [LoadContext(0,'ZSYGOPYXSA'),'ardt_jarantbo'];
}
}
function SetChildVariables_ardt_ae_saldianno_rap() {
if ( ! (ChildToLoad(FrameRef('ardt_ae_saldianno_rap'))) && Ne(typeof(FrameRef('ardt_ae_saldianno_rap').DoUpdate),'undefined')) {
CopyWorkVar(FrameRef('ardt_ae_saldianno_rap'),['TIPRAP'],['TIPOAG'],false)
}
}
function CtxLoad_ardt_ae_saldianno_rap() {
if (ChildToLoad(FrameRef('ardt_ae_saldianno_rap'))) {
return [LoadContext(0,'XUXHMWVHFR'),'ardt_ae_saldianno_rap'];
}
}
