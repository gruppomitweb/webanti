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
l_bEnabled= ! (Eq(w_TIPOAG,'99')) || IsDisabledByStateDriver('DESCRI');
SetDisabled('OATVYCOEYD',l_bEnabled);
l_bEnabled= ! (Ne(At(w_TIPOAG,'|01|02|03|12|13'),0)) || IsDisabledByStateDriver('CAB');
SetDisabled('GSFLHJGDBR',l_bEnabled);
l_bEnabled= ! (false) || IsDisabledByStateDriver('INVIATO');
SetDisabled('BJQDZXBWJS',l_bEnabled);
l_bEnabled= ! (false) || IsDisabledByStateDriver('DATAINVIO');
SetDisabled('UOUKXZECJY',l_bEnabled);
l_bEnabled= ! (false) || IsDisabledByStateDriver('DATAMODI');
SetDisabled('VCDAQCGFUL',l_bEnabled);
l_bEnabled= ! (false) || IsDisabledByStateDriver('ANNULLA');
SetDisabled('QKEKMYOBIJ',l_bEnabled);
l_bEnabled= ! (false) || IsDisabledByStateDriver('DATAANNU');
SetDisabled('BYWOFLDARI',l_bEnabled);
l_bEnabled= ! (false) || IsDisabledByStateDriver('INVIATOC');
SetDisabled('QKGGINIHGW',l_bEnabled);
l_bEnabled= ! (false) || IsDisabledByStateDriver('DATAINVIOC');
SetDisabled('RJUFHFUDIX',l_bEnabled);
if (IsDisabledByStateDriver('box_YORQOIOBQN')) {
DisableInputsInContainer(Ctrl('YORQOIOBQN'),true);
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
function Set_DESCRI(ctrlValue,kmode,e) {
if (Ne(w_DESCRI,ctrlValue)) {
var ctl = _GetCtl(e,'OATVYCOEYD');
if (_tracker.goon(ctl,ctrlValue)) {
w_DESCRI=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('OATVYCOEYD',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',24,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_OLDINTER(ctrlValue,kmode,e) {
if (Ne(w_OLDINTER,ctrlValue)) {
var ctl = _GetCtl(e,'RAPQTBTNXT');
if (_tracker.goon(ctl,ctrlValue)) {
w_OLDINTER=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RAPQTBTNXT',0);
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
function Set_VALUTA(ctrlValue,kmode,e) {
if (Ne(w_VALUTA,ctrlValue)) {
var ctl = _GetCtl(e,'CNUZSPOEIV');
if (_tracker.goon(ctl,ctrlValue)) {
w_VALUTA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CNUZSPOEIV',0);
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
function Set_CAB(ctrlValue,kmode,e) {
if (Ne(w_CAB,ctrlValue)) {
var ctl = _GetCtl(e,'GSFLHJGDBR');
if (_tracker.goon(ctl,ctrlValue)) {
w_CAB=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('GSFLHJGDBR',0);
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
function Set_INVIATO(ctrlValue,kmode,e) {
if (Ne(w_INVIATO,ctrlValue)) {
var ctl = _GetCtl(e,'BJQDZXBWJS');
if (_tracker.goon(ctl,ctrlValue)) {
w_INVIATO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BJQDZXBWJS',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH(0,'N',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_DATAINVIO(ctrlValue,kmode,e) {
if (Ne(w_DATAINVIO,ctrlValue)) {
var ctl = _GetCtl(e,'UOUKXZECJY');
if (_tracker.goon(ctl,ctrlValue)) {
w_DATAINVIO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UOUKXZECJY',0);
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
function Set_DATAMODI(ctrlValue,kmode,e) {
if (Ne(w_DATAMODI,ctrlValue)) {
var ctl = _GetCtl(e,'VCDAQCGFUL');
if (_tracker.goon(ctl,ctrlValue)) {
w_DATAMODI=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VCDAQCGFUL',0);
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
function Set_ANNULLA(ctrlValue,kmode,e) {
if (Ne(w_ANNULLA,ctrlValue)) {
var ctl = _GetCtl(e,'QKEKMYOBIJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_ANNULLA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QKEKMYOBIJ',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH(0,'N',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_DATAANNU(ctrlValue,kmode,e) {
if (Ne(w_DATAANNU,ctrlValue)) {
var ctl = _GetCtl(e,'BYWOFLDARI');
if (_tracker.goon(ctl,ctrlValue)) {
w_DATAANNU=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BYWOFLDARI',0);
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
function Set_IDESITOFAM(ctrlValue,kmode,e) {
if (Ne(w_IDESITOFAM,ctrlValue)) {
var ctl = _GetCtl(e,'JLZSVQCYSK');
if (_tracker.goon(ctl,ctrlValue)) {
w_IDESITOFAM=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('JLZSVQCYSK',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',24,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_UNIQUECODE(ctrlValue,kmode,e) {
if (Ne(w_UNIQUECODE,ctrlValue)) {
var ctl = _GetCtl(e,'ASHSTCRNBL');
if (_tracker.goon(ctl,ctrlValue)) {
w_UNIQUECODE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ASHSTCRNBL',0);
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
function Set_INVIATOC(ctrlValue,kmode,e) {
if (Ne(w_INVIATOC,ctrlValue)) {
var ctl = _GetCtl(e,'QKGGINIHGW');
if (_tracker.goon(ctl,ctrlValue)) {
w_INVIATOC=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QKGGINIHGW',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH(0,'N',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_DATAINVIOC(ctrlValue,kmode,e) {
if (Ne(w_DATAINVIOC,ctrlValue)) {
var ctl = _GetCtl(e,'RJUFHFUDIX');
if (_tracker.goon(ctl,ctrlValue)) {
w_DATAINVIOC=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RJUFHFUDIX',0);
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
if ( ! (ChildToLoad(FrameRef('ardt_ae_saldianno_rap'))) && Ne(typeof(FrameRef('ardt_ae_saldianno_rap').DoUpdate),'undefined')) {
CopyWorkVar(FrameRef('ardt_ae_saldianno_rap'),['TIPRAP'],['TIPOAG'],true)
}
LibJavascript.forEachItem(m_FoundlingCopyWorkVar,i_body_1)
function i_body_1(child){
child();
}
// * --- Area Manuale = UI - Calculate
// * --- Fine Area Manuale
m_bCalculating=false;
}
function SaveDependsOn() {
o_TIPOAG=w_TIPOAG;
}
function SaveLabelDependsOn() {
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
parent.ZtVWeb.raiseEventToEvalParms('armt_ae_famiglie_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('armt_ae_famiglie_dataNotSent',{'action':formaction});
}
}
}
}
CheckChild.child=[{'prg':"ardt_ae_saldianno_rap",'BOScId':function(){ return FrameRef('ardt_ae_saldianno_rap')},'repeated':0}];
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
} else if ( ! (_ChkObl('BHAVHLFPAC',1))) {
_SignErr('BHAVHLFPAC');
m_cLastWorkVarErrorMsg='TIPOAG';
l_bResult=false;
w_TIPOAG=HtW('','C');
} else if ( ! (_ChkObl('JHOQNVHZXH',1))) {
_SignErr('JHOQNVHZXH');
m_cLastWorkVarErrorMsg='1723736132';
l_bResult=false;
w_COINT=HtW('','C');
} else if ((Eq(w_TIPOAG,'99')) && ( ! (_ChkObl('OATVYCOEYD',1)))) {
_SignErr('OATVYCOEYD');
m_cLastWorkVarErrorMsg='285808099';
l_bResult=false;
w_DESCRI=HtW('','C');
} else if ( ! (_ChkObl('RAPQTBTNXT',1))) {
_SignErr('RAPQTBTNXT');
m_cLastWorkVarErrorMsg='730578090';
l_bResult=false;
w_OLDINTER=HtW('','C');
} else if ( ! (_ChkObl('CNUZSPOEIV',1))) {
_SignErr('CNUZSPOEIV');
m_cLastWorkVarErrorMsg='109710548';
l_bResult=false;
w_VALUTA=HtW('','C');
} else if ((Ne(At(w_TIPOAG,'|01|02|03|12|13'),0)) && ( ! (_ChkObl('GSFLHJGDBR',1)))) {
_SignErr('GSFLHJGDBR');
m_cLastWorkVarErrorMsg='1455030164';
l_bResult=false;
w_CAB=HtW('','C');
} else if ((false) && ( ! (_ChkObl('BJQDZXBWJS',1)))) {
_SignErr('BJQDZXBWJS');
m_cLastWorkVarErrorMsg='INVIATO';
l_bResult=false;
w_INVIATO=0;
} else if ((false) && ( ! (_ChkObl('UOUKXZECJY',1)))) {
_SignErr('UOUKXZECJY');
m_cLastWorkVarErrorMsg='DATAINVIO';
l_bResult=false;
w_DATAINVIO=HtW('','D');
} else if ((false) && ( ! (_ChkObl('VCDAQCGFUL',1)))) {
_SignErr('VCDAQCGFUL');
m_cLastWorkVarErrorMsg='11268897251';
l_bResult=false;
w_DATAMODI=HtW('','D');
} else if ((false) && ( ! (_ChkObl('QKEKMYOBIJ',1)))) {
_SignErr('QKEKMYOBIJ');
m_cLastWorkVarErrorMsg='ANNULLA';
l_bResult=false;
w_ANNULLA=0;
} else if ((false) && ( ! (_ChkObl('BYWOFLDARI',1)))) {
_SignErr('BYWOFLDARI');
m_cLastWorkVarErrorMsg='DATAANNU';
l_bResult=false;
w_DATAANNU=HtW('','D');
} else if ( ! (_ChkObl('JLZSVQCYSK',1))) {
_SignErr('JLZSVQCYSK');
m_cLastWorkVarErrorMsg='10615814578';
l_bResult=false;
w_IDESITOFAM=HtW('','C');
} else if ( ! (_ChkObl('ASHSTCRNBL',1))) {
_SignErr('ASHSTCRNBL');
m_cLastWorkVarErrorMsg='UNIQUECODE';
l_bResult=false;
w_UNIQUECODE=HtW('','C');
} else if ((false) && ( ! (_ChkObl('QKGGINIHGW',1)))) {
_SignErr('QKGGINIHGW');
m_cLastWorkVarErrorMsg='INVIATOC';
l_bResult=false;
w_INVIATOC=0;
} else if ((false) && ( ! (_ChkObl('RJUFHFUDIX',1)))) {
_SignErr('RJUFHFUDIX');
m_cLastWorkVarErrorMsg='DATAINVIOC';
l_bResult=false;
w_DATAINVIOC=HtW('','D');
}
if (l_bResult) {
l_bResult=CheckChild(0);
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
return -1;
}
function link_url(index) {
var l_oWv;
}
function FillWv() {
var l_oWv = InitWvApplet();
l_oWv.setValue('m_CheckVars',JSON.stringify(m_CheckVars));
l_oWv.setValue('RAPPORTO',WtA(w_RAPPORTO,'C'));
l_oWv.setValue('TIPOAG',WtA(w_TIPOAG,'C'));
l_oWv.setValue('COINT',WtA(w_COINT,'C'));
l_oWv.setValue('DESCRI',WtA(w_DESCRI,'C'));
l_oWv.setValue('OLDINTER',WtA(w_OLDINTER,'C'));
l_oWv.setValue('VALUTA',WtA(w_VALUTA,'C'));
l_oWv.setValue('CAB',WtA(w_CAB,'C'));
l_oWv.setValue('INVIATO',WtA(w_INVIATO,'N'));
l_oWv.setValue('DATAINVIO',WtA(w_DATAINVIO,'D'));
l_oWv.setValue('DATAMODI',WtA(w_DATAMODI,'D'));
l_oWv.setValue('ANNULLA',WtA(w_ANNULLA,'N'));
l_oWv.setValue('DATAANNU',WtA(w_DATAANNU,'D'));
l_oWv.setValue('IDESITOFAM',WtA(w_IDESITOFAM,'C'));
l_oWv.setValue('UNIQUECODE',WtA(w_UNIQUECODE,'C'));
l_oWv.setValue('INVIATOC',WtA(w_INVIATOC,'N'));
l_oWv.setValue('DATAINVIOC',WtA(w_DATAINVIOC,'D'));
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
_FillChildren.n=['ardt_ae_saldianno_rap'];
FillWv.n=["RAPPORTO","TIPOAG","COINT","DESCRI","OLDINTER","VALUTA","CAB","INVIATO","DATAINVIO","DATAMODI","ANNULLA","DATAANNU","IDESITOFAM","UNIQUECODE","INVIATOC","DATAINVIOC"];
function SetModified() {
m_bUpdated=true;
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
