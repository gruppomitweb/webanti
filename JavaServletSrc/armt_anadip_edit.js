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
function DisplayErrorMessage_ardt_dippreposti() {
if ( ! (ChildToLoad(FrameRef('ardt_dippreposti'))) && Ne(typeof(FrameRef('ardt_dippreposti').DisplayErrorMessage),'undefined')) {
FrameRef('ardt_dippreposti').DisplayErrorMessage();
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
DisableInputsInContainer(Ctrl('UBUBESGOCL'),true);
}
if (IsDisabledByStateDriver('DatiAdd')) {
Z.Tabs.Get("tabs_1_Dati").SetDisable('OQJXMMCZQK',true);
}
if (IsDisabledByStateDriver('Rischio')) {
Z.Tabs.Get("tabs_1_Dati").SetDisable('RFAIYHSGII',true);
}
if (IsDisabledByStateDriver('Dati SARA/SV')) {
Z.Tabs.Get("tabs_1_Dati").SetDisable('SJOTYLCKUC',true);
}
if (IsDisabledByStateDriver('Preposti')) {
Z.Tabs.Get("tabs_1_Dati").SetDisable('DKPWIMNYIB',true);
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
SetObligatory(Ctrl('MOQMJLJJNI'),Eq(w_gAgeCGO,'S') || IsObligatoryByStateDriver('CODAGE'));
SetObligatory(Ctrl('QDGOPSCQNI'),Eq(w_FLGCOMPL,1) || IsObligatoryByStateDriver('DATAFINE'));
}
function SetDynamicClasses() {
var c;
}
function SetDynamicTooltip() {
var c;
}
function Set_CODDIP(ctrlValue,kmode,e) {
if (Ne(w_CODDIP,ctrlValue)) {
var ctl = _GetCtl(e,'PBPAZFLKHV');
if (_tracker.goon(ctl,ctrlValue)) {
w_CODDIP=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('PBPAZFLKHV',0);
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
function Set_DESCRIZ(ctrlValue,kmode,e) {
if (Ne(w_DESCRIZ,ctrlValue)) {
var ctl = _GetCtl(e,'XCUHPGQTRL');
if (_tracker.goon(ctl,ctrlValue)) {
w_DESCRIZ=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XCUHPGQTRL',0);
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
function Set_DOMICILIO(ctrlValue,kmode,e) {
if (Ne(w_DOMICILIO,ctrlValue)) {
var ctl = _GetCtl(e,'JRSYWVEHIR');
if (_tracker.goon(ctl,ctrlValue)) {
w_DOMICILIO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('JRSYWVEHIR',0);
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
function Set_CAP(ctrlValue,kmode,e) {
if (Ne(w_CAP,ctrlValue)) {
var ctl = _GetCtl(e,'KQSLGVHSRE');
if (_tracker.goon(ctl,ctrlValue)) {
w_CAP=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('KQSLGVHSRE',0);
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
function Set_TIPOSV(ctrlValue,kmode,e) {
if (Ne(w_TIPOSV,ctrlValue)) {
var ctl = _GetCtl(e,'LYZAJWZGAM');
if (_tracker.goon(ctl,ctrlValue)) {
w_TIPOSV=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('LYZAJWZGAM',0);
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
function Set_DESCCIT(ctrlValue,kmode,e) {
if (Ne(w_DESCCIT,ctrlValue)) {
var ctl = _GetCtl(e,'AEZUFOYHTM');
if (_tracker.goon(ctl,ctrlValue)) {
w_DESCCIT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('AEZUFOYHTM',0);
if (l_bResult) {
l_bResult=Link_AEZUFOYHTM(kmode);
if ( ! (l_bResult)) {
w_DESCCIT=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',60,0,''));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',60,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_FLGNOAUA(ctrlValue,kmode,e) {
if (Ne(w_FLGNOAUA,ctrlValue)) {
var ctl = _GetCtl(e,'NPJMZHJDRZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLGNOAUA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NPJMZHJDRZ',0);
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
function Set_FLGWUPOS(ctrlValue,kmode,e) {
if (Ne(w_FLGWUPOS,ctrlValue)) {
var ctl = _GetCtl(e,'PNZMYOKETI');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLGWUPOS=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('PNZMYOKETI',0);
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
function Set_AGENTE(ctrlValue,kmode,e) {
if (Ne(w_AGENTE,ctrlValue)) {
var ctl = _GetCtl(e,'WRIYZYCTBR');
if (_tracker.goon(ctl,ctrlValue)) {
w_AGENTE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('WRIYZYCTBR',0);
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
function Set_FLGCOMPL(ctrlValue,kmode,e) {
if (Ne(w_FLGCOMPL,ctrlValue)) {
var ctl = _GetCtl(e,'DVNRBUBGST');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLGCOMPL=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('DVNRBUBGST',0);
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
function Set_MACROAGENTE(ctrlValue,kmode,e) {
if (Ne(w_MACROAGENTE,ctrlValue)) {
var ctl = _GetCtl(e,'BPQQBVFABO');
if (_tracker.goon(ctl,ctrlValue)) {
w_MACROAGENTE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BPQQBVFABO',0);
if (l_bResult) {
l_bResult=Link_BPQQBVFABO(kmode);
if ( ! (l_bResult)) {
w_MACROAGENTE=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',5,0,''));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',5,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_TERMINALID(ctrlValue,kmode,e) {
if (Ne(w_TERMINALID,ctrlValue)) {
var ctl = _GetCtl(e,'RTLSPZPWWO');
if (_tracker.goon(ctl,ctrlValue)) {
w_TERMINALID=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RTLSPZPWWO',0);
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
function Set_CATEG04(ctrlValue,kmode,e) {
if (Ne(w_CATEG04,ctrlValue)) {
var ctl = _GetCtl(e,'JQLGHMLOKO');
if (_tracker.goon(ctl,ctrlValue)) {
w_CATEG04=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('JQLGHMLOKO',0);
if (l_bResult) {
l_bResult=Link_JQLGHMLOKO(kmode);
if ( ! (l_bResult)) {
w_CATEG04=HtW('','C');
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
function Set_IDBASE(ctrlValue,kmode,e) {
if (Ne(w_IDBASE,ctrlValue)) {
var ctl = _GetCtl(e,'WTENUNIUCY');
if (_tracker.goon(ctl,ctrlValue)) {
w_IDBASE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('WTENUNIUCY',0);
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
function Set_TELEFONO(ctrlValue,kmode,e) {
if (Ne(w_TELEFONO,ctrlValue)) {
var ctl = _GetCtl(e,'CDMUQZYEAX');
if (_tracker.goon(ctl,ctrlValue)) {
w_TELEFONO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CDMUQZYEAX',0);
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
function Set_ABICABSARA(ctrlValue,kmode,e) {
if (Ne(w_ABICABSARA,ctrlValue)) {
var ctl = _GetCtl(e,'YTCIMOKXKS');
if (_tracker.goon(ctl,ctrlValue)) {
w_ABICABSARA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YTCIMOKXKS',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',12,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_AGACCODE(ctrlValue,kmode,e) {
if (Ne(w_AGACCODE,ctrlValue)) {
var ctl = _GetCtl(e,'NISBFWYVAN');
if (_tracker.goon(ctl,ctrlValue)) {
w_AGACCODE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NISBFWYVAN',0);
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
function Set_NAZAGENTE(ctrlValue,kmode,e) {
if (Ne(w_NAZAGENTE,ctrlValue)) {
var ctl = _GetCtl(e,'SGDAQGMTNU');
if (_tracker.goon(ctl,ctrlValue)) {
w_NAZAGENTE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SGDAQGMTNU',0);
if (l_bResult) {
l_bResult=Link_SGDAQGMTNU(kmode);
if ( ! (l_bResult)) {
w_NAZAGENTE=HtW('','C');
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
function Set_DATAFINE(ctrlValue,kmode,e) {
if (Ne(w_DATAFINE,ctrlValue)) {
var ctl = _GetCtl(e,'QDGOPSCQNI');
if (_tracker.goon(ctl,ctrlValue)) {
w_DATAFINE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QDGOPSCQNI',0);
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
function Set_SERRIMDEN(ctrlValue,kmode,e) {
if (Ne(w_SERRIMDEN,ctrlValue)) {
var ctl = _GetCtl(e,'VKYZPROJCI');
if (_tracker.goon(ctl,ctrlValue)) {
w_SERRIMDEN=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VKYZPROJCI',0);
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
function Set_NUMCIVICO(ctrlValue,kmode,e) {
if (Ne(w_NUMCIVICO,ctrlValue)) {
var ctl = _GetCtl(e,'PWMWPIWKXR');
if (_tracker.goon(ctl,ctrlValue)) {
w_NUMCIVICO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('PWMWPIWKXR',0);
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
function Set_TIPOAGENTE(ctrlValue,kmode,e) {
if (Ne(w_TIPOAGENTE,ctrlValue)) {
var ctl = _GetCtl(e,'ACDLDQVQXS');
if (_tracker.goon(ctl,ctrlValue)) {
w_TIPOAGENTE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ACDLDQVQXS',0);
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
function Set_PARTIVA(ctrlValue,kmode,e) {
if (Ne(w_PARTIVA,ctrlValue)) {
var ctl = _GetCtl(e,'RTWJYVXECF');
if (_tracker.goon(ctl,ctrlValue)) {
w_PARTIVA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RTWJYVXECF',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',11,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_AGEREGIO(ctrlValue,kmode,e) {
if (Ne(w_AGEREGIO,ctrlValue)) {
var ctl = _GetCtl(e,'KSBCZELDDB');
if (_tracker.goon(ctl,ctrlValue)) {
w_AGEREGIO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('KSBCZELDDB',0);
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
function Set_FLGATT(ctrlValue,kmode,e) {
if (Ne(w_FLGATT,ctrlValue)) {
var ctl = _GetCtl(e,'ECKDLHTTSN');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLGATT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ECKDLHTTSN',0);
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
function Set_CODLOC(ctrlValue,kmode,e) {
if (Ne(w_CODLOC,ctrlValue)) {
var ctl = _GetCtl(e,'DUZIXALHHS');
if (_tracker.goon(ctl,ctrlValue)) {
w_CODLOC=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('DUZIXALHHS',0);
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
function Set_CODAGE(ctrlValue,kmode,e) {
if (Ne(w_CODAGE,ctrlValue)) {
var ctl = _GetCtl(e,'MOQMJLJJNI');
if (_tracker.goon(ctl,ctrlValue)) {
w_CODAGE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MOQMJLJJNI',0);
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
function Set_CODFISC(ctrlValue,kmode,e) {
if (Ne(w_CODFISC,ctrlValue)) {
var ctl = _GetCtl(e,'ACTQHMCVYK');
if (_tracker.goon(ctl,ctrlValue)) {
w_CODFISC=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ACTQHMCVYK',0);
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
function Set_CONCESSIONE(ctrlValue,kmode,e) {
if (Ne(w_CONCESSIONE,ctrlValue)) {
var ctl = _GetCtl(e,'JJJFDTJFAK');
if (_tracker.goon(ctl,ctrlValue)) {
w_CONCESSIONE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('JJJFDTJFAK',0);
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
function Set_CODICEAAMS(ctrlValue,kmode,e) {
if (Ne(w_CODICEAAMS,ctrlValue)) {
var ctl = _GetCtl(e,'VYZSOTTSWB');
if (_tracker.goon(ctl,ctrlValue)) {
w_CODICEAAMS=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VYZSOTTSWB',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',12,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_CAB2(ctrlValue,kmode,e) {
if (Ne(w_CAB2,ctrlValue)) {
var ctl = _GetCtl(e,'IOZYXJKYDX');
if (_tracker.goon(ctl,ctrlValue)) {
w_CAB2=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('IOZYXJKYDX',0);
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
function Set_CATEG03(ctrlValue,kmode,e) {
if (Ne(w_CATEG03,ctrlValue)) {
var ctl = _GetCtl(e,'QRJNKZVHDW');
if (_tracker.goon(ctl,ctrlValue)) {
w_CATEG03=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QRJNKZVHDW',0);
if (l_bResult) {
l_bResult=Link_QRJNKZVHDW(kmode);
if ( ! (l_bResult)) {
w_CATEG03=HtW('','C');
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
function Set_CATEG02(ctrlValue,kmode,e) {
if (Ne(w_CATEG02,ctrlValue)) {
var ctl = _GetCtl(e,'TGQHYPERED');
if (_tracker.goon(ctl,ctrlValue)) {
w_CATEG02=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('TGQHYPERED',0);
if (l_bResult) {
l_bResult=Link_TGQHYPERED(kmode);
if ( ! (l_bResult)) {
w_CATEG02=HtW('','C');
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
function Set_CATEG05(ctrlValue,kmode,e) {
if (Ne(w_CATEG05,ctrlValue)) {
var ctl = _GetCtl(e,'QVBZSFMTVP');
if (_tracker.goon(ctl,ctrlValue)) {
w_CATEG05=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QVBZSFMTVP',0);
if (l_bResult) {
l_bResult=Link_QVBZSFMTVP(kmode);
if ( ! (l_bResult)) {
w_CATEG05=HtW('','C');
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
function Set_DATAINI(ctrlValue,kmode,e) {
if (Ne(w_DATAINI,ctrlValue)) {
var ctl = _GetCtl(e,'OSJJWSZMDE');
if (_tracker.goon(ctl,ctrlValue)) {
w_DATAINI=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('OSJJWSZMDE',0);
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
function Set_CATEG01(ctrlValue,kmode,e) {
if (Ne(w_CATEG01,ctrlValue)) {
var ctl = _GetCtl(e,'ICGUZGYXTD');
if (_tracker.goon(ctl,ctrlValue)) {
w_CATEG01=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ICGUZGYXTD',0);
if (l_bResult) {
l_bResult=Link_ICGUZGYXTD(kmode);
if ( ! (l_bResult)) {
w_CATEG01=HtW('','C');
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
function Calculate() {
var l_bTmpRes;
var l_bResult = true;
m_bCalculating=true;
if ((Ne(o_IDCITTA,w_IDCITTA))) {
l_bTmpRes=Link_CZGVBAYWKP(null);
}
w_tipocat='D';
w_CATEGORIA=LibreriaMit.SpacePad(w_CATEG01,2)+LibreriaMit.SpacePad(w_CATEG02,2)+LibreriaMit.SpacePad(w_CATEG03,2)+LibreriaMit.SpacePad(w_CATEG04,2)+LibreriaMit.SpacePad(w_CATEG05,2);
LibJavascript.forEachItem(m_FoundlingCopyWorkVar,i_body_1)
function i_body_1(child){
child();
}
// * --- Area Manuale = UI - Calculate
// * --- Fine Area Manuale
m_bCalculating=false;
}
function SaveDependsOn() {
o_IDCITTA=w_IDCITTA;
}
function SaveLabelDependsOn() {
}
function Link_CZGVBAYWKP(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_IDCITTA);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('IDBASE',w_IDCITTA,10,0);
l_Appl.SetFields('IDBASE,CITTA,CAB,PROV');
l_Appl.SetTypes('C,C,C,C');
l_Appl.LinkTable('tbcitta');
l_Appl.SetLinkzoom('armt_citta');
l_Appl.SetID('CZGVBAYWKP');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_IDCITTA=l_Appl.GetStringValue('IDBASE',10,0);
w_DESCCIT=l_Appl.GetStringValue('CITTA',60,0);
w_CAB=l_Appl.GetStringValue('CAB',6,0);
w_PROVINCIA=l_Appl.GetStringValue('PROV',2,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_CZGVBAYWKP_Blank();
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
function Link_CZGVBAYWKP_Blank() {
w_IDCITTA='';
w_DESCCIT='';
w_CAB='';
w_PROVINCIA='';
}
function LOpt_CZGVBAYWKP() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcitta','C'));
l_oWv.setValue('Linkzoomprg',WtA('armt_citta','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('IDBASE','C'));
l_oWv.setValue('LinkedField',WtA('IDBASE','C'));
l_oWv.setValue('UID',WtA('CZGVBAYWKP','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['CZGVBAYWKP'][1],'C'));
return l_oWv;
}
function Link_AEZUFOYHTM(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_DESCCIT);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CITTA',w_DESCCIT,60,0);
l_Appl.SetFields('CITTA,IDBASE,PROV,CAB,CAP');
l_Appl.SetTypes('C,C,C,C,C');
l_Appl.LinkTable('tbcitta');
l_Appl.SetID('AEZUFOYHTM');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_DESCCIT=l_Appl.GetStringValue('CITTA',60,0);
w_IDCITTA=l_Appl.GetStringValue('IDBASE',10,0);
w_PROVINCIA=l_Appl.GetStringValue('PROV',2,0);
w_CAB=l_Appl.GetStringValue('CAB',6,0);
w_CAP=l_Appl.GetStringValue('CAP',5,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_AEZUFOYHTM_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_AEZUFOYHTM';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_AEZUFOYHTM();
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
function Link_AEZUFOYHTM_Blank() {
w_DESCCIT='';
w_IDCITTA='';
w_PROVINCIA='';
w_CAB='';
w_CAP='';
}
function LOpt_AEZUFOYHTM() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcitta','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CITTA','C'));
l_oWv.setValue('LinkedField',WtA('CITTA','C'));
l_oWv.setValue('UID',WtA('AEZUFOYHTM','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['AEZUFOYHTM'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('15186643'),'C'));
return l_oWv;
}
function Link_BPQQBVFABO(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_MACROAGENTE);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('MACODICE',w_MACROAGENTE,5,0);
l_Appl.SetFields('MACODICE,MADESCRI,MACOGNOME,MANOME');
l_Appl.SetTypes('C,C,C,C');
l_Appl.LinkTable('tbmacage');
l_Appl.SetLinkzoom('armt_tbmacage');
l_Appl.SetID('BPQQBVFABO');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_MACROAGENTE=l_Appl.GetStringValue('MACODICE',5,0);
w_xMADESCRI=l_Appl.GetStringValue('MADESCRI',60,0);
w_xMACOGNOME=l_Appl.GetStringValue('MACOGNOME',50,0);
w_xMANOME=l_Appl.GetStringValue('MANOME',50,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_BPQQBVFABO_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_BPQQBVFABO';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_BPQQBVFABO();
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
function Link_BPQQBVFABO_Blank() {
w_MACROAGENTE='';
w_xMADESCRI='';
w_xMACOGNOME='';
w_xMANOME='';
}
function LOpt_BPQQBVFABO() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbmacage','C'));
l_oWv.setValue('Linkzoomprg',WtA('armt_tbmacage','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('MACODICE','C'));
l_oWv.setValue('LinkedField',WtA('MACODICE','C'));
l_oWv.setValue('UID',WtA('BPQQBVFABO','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['BPQQBVFABO'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('11148782069'),'C'));
return l_oWv;
}
function Link_SGDAQGMTNU(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_NAZAGENTE);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODSTA',w_NAZAGENTE,3,0);
l_Appl.SetFields('CODSTA,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbstati');
l_Appl.SetID('SGDAQGMTNU');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_NAZAGENTE=l_Appl.GetStringValue('CODSTA',3,0);
w_xDESCNAZ=l_Appl.GetStringValue('DESCRI',40,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_SGDAQGMTNU_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_SGDAQGMTNU';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_SGDAQGMTNU();
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
function Link_SGDAQGMTNU_Blank() {
w_NAZAGENTE='';
w_xDESCNAZ='';
}
function LOpt_SGDAQGMTNU() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstati','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODSTA','C'));
l_oWv.setValue('LinkedField',WtA('CODSTA','C'));
l_oWv.setValue('UID',WtA('SGDAQGMTNU','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['SGDAQGMTNU'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('7383187'),'C'));
return l_oWv;
}
function Link_JQLGHMLOKO(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CATEG04);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('C4CODTAB',w_tipocat,10,0);
l_Appl.SetStringKey('C4CODICE',w_CATEG04,2,0);
l_Appl.SetFields('C4CODICE,C4DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbcateg04');
l_Appl.SetLinkzoom('opemt_tbcateg04');
l_Appl.SetID('JQLGHMLOKO');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CATEG04=l_Appl.GetStringValue('C4CODICE',2,0);
w_xC4DESCRI=l_Appl.GetStringValue('C4DESCRI',80,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_JQLGHMLOKO_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_JQLGHMLOKO';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_JQLGHMLOKO();
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
function Link_JQLGHMLOKO_Blank() {
w_CATEG04='';
w_xC4DESCRI='';
}
function LOpt_JQLGHMLOKO() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcateg04','C'));
l_oWv.setValue('Linkzoomprg',WtA('opemt_tbcateg04','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('C4CODTAB,C4CODICE','C'));
l_oWv.setValue('LinkedField',WtA('C4CODICE','C'));
l_oWv.setValue('UID',WtA('JQLGHMLOKO','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['JQLGHMLOKO'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('157155508'),'C'));
return l_oWv;
}
function Link_QVBZSFMTVP(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CATEG05);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('C5CODTAB',w_tipocat,10,0);
l_Appl.SetStringKey('C5CODICE',w_CATEG05,2,0);
l_Appl.SetFields('C5CODICE,C5DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbcateg05');
l_Appl.SetLinkzoom('opemt_tbcateg05');
l_Appl.SetID('QVBZSFMTVP');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CATEG05=l_Appl.GetStringValue('C5CODICE',2,0);
w_xC5DESCRI=l_Appl.GetStringValue('C5DESCRI',80,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_QVBZSFMTVP_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_QVBZSFMTVP';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_QVBZSFMTVP();
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
function Link_QVBZSFMTVP_Blank() {
w_CATEG05='';
w_xC5DESCRI='';
}
function LOpt_QVBZSFMTVP() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcateg05','C'));
l_oWv.setValue('Linkzoomprg',WtA('opemt_tbcateg05','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('C5CODTAB,C5CODICE','C'));
l_oWv.setValue('LinkedField',WtA('C5CODICE','C'));
l_oWv.setValue('UID',WtA('QVBZSFMTVP','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['QVBZSFMTVP'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('157155764'),'C'));
return l_oWv;
}
function Link_ICGUZGYXTD(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CATEG01);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('C1CODTAB',w_tipocat,10,0);
l_Appl.SetStringKey('C1CODICE',w_CATEG01,2,0);
l_Appl.SetFields('C1CODICE,C1DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbcateg01');
l_Appl.SetID('ICGUZGYXTD');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CATEG01=l_Appl.GetStringValue('C1CODICE',2,0);
w_xC1DESCRI=l_Appl.GetStringValue('C1DESCRI',80,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_ICGUZGYXTD_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_ICGUZGYXTD';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_ICGUZGYXTD();
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
function Link_ICGUZGYXTD_Blank() {
w_CATEG01='';
w_xC1DESCRI='';
}
function LOpt_ICGUZGYXTD() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcateg01','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('C1CODTAB,C1CODICE','C'));
l_oWv.setValue('LinkedField',WtA('C1CODICE','C'));
l_oWv.setValue('UID',WtA('ICGUZGYXTD','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['ICGUZGYXTD'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('157154740'),'C'));
return l_oWv;
}
function Link_TGQHYPERED(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CATEG02);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('C2CODTAB',w_tipocat,10,0);
l_Appl.SetStringKey('C2CODICE',w_CATEG02,2,0);
l_Appl.SetFields('C2CODICE,C2DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbcateg02');
l_Appl.SetID('TGQHYPERED');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CATEG02=l_Appl.GetStringValue('C2CODICE',2,0);
w_xC2DESCRI=l_Appl.GetStringValue('C2DESCRI',80,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_TGQHYPERED_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_TGQHYPERED';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_TGQHYPERED();
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
function Link_TGQHYPERED_Blank() {
w_CATEG02='';
w_xC2DESCRI='';
}
function LOpt_TGQHYPERED() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcateg02','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('C2CODTAB,C2CODICE','C'));
l_oWv.setValue('LinkedField',WtA('C2CODICE','C'));
l_oWv.setValue('UID',WtA('TGQHYPERED','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['TGQHYPERED'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('157154996'),'C'));
return l_oWv;
}
function Link_QRJNKZVHDW(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CATEG03);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('C3CODTAB',w_tipocat,10,0);
l_Appl.SetStringKey('C3CODICE',w_CATEG03,2,0);
l_Appl.SetFields('C3CODICE,C3DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbcateg03');
l_Appl.SetID('QRJNKZVHDW');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CATEG03=l_Appl.GetStringValue('C3CODICE',2,0);
w_xC3DESCRI=l_Appl.GetStringValue('C3DESCRI',80,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_QRJNKZVHDW_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_QRJNKZVHDW';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_QRJNKZVHDW();
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
function Link_QRJNKZVHDW_Blank() {
w_CATEG03='';
w_xC3DESCRI='';
}
function LOpt_QRJNKZVHDW() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcateg03','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('C3CODTAB,C3CODICE','C'));
l_oWv.setValue('LinkedField',WtA('C3CODICE','C'));
l_oWv.setValue('UID',WtA('QRJNKZVHDW','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['QRJNKZVHDW'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('157155252'),'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'AEZUFOYHTM')) {
last_focused_comp=GetLastFocusedElementOfLink('AEZUFOYHTM');
function SetMethod_AEZUFOYHTM() {
Set_DESCCIT(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_AEZUFOYHTM();
} else {
setTimeout(SetMethod_AEZUFOYHTM,1);
}
bResult=true;
}
if (Eq(varName,'BPQQBVFABO')) {
last_focused_comp=GetLastFocusedElementOfLink('BPQQBVFABO');
function SetMethod_BPQQBVFABO() {
Set_MACROAGENTE(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_BPQQBVFABO();
} else {
setTimeout(SetMethod_BPQQBVFABO,1);
}
bResult=true;
}
if (Eq(varName,'SGDAQGMTNU')) {
last_focused_comp=GetLastFocusedElementOfLink('SGDAQGMTNU');
function SetMethod_SGDAQGMTNU() {
Set_NAZAGENTE(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_SGDAQGMTNU();
} else {
setTimeout(SetMethod_SGDAQGMTNU,1);
}
bResult=true;
}
if (Eq(varName,'JQLGHMLOKO')) {
last_focused_comp=GetLastFocusedElementOfLink('JQLGHMLOKO');
function SetMethod_JQLGHMLOKO() {
Set_CATEG04(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_JQLGHMLOKO();
} else {
setTimeout(SetMethod_JQLGHMLOKO,1);
}
bResult=true;
}
if (Eq(varName,'QVBZSFMTVP')) {
last_focused_comp=GetLastFocusedElementOfLink('QVBZSFMTVP');
function SetMethod_QVBZSFMTVP() {
Set_CATEG05(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_QVBZSFMTVP();
} else {
setTimeout(SetMethod_QVBZSFMTVP,1);
}
bResult=true;
}
if (Eq(varName,'ICGUZGYXTD')) {
last_focused_comp=GetLastFocusedElementOfLink('ICGUZGYXTD');
function SetMethod_ICGUZGYXTD() {
Set_CATEG01(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_ICGUZGYXTD();
} else {
setTimeout(SetMethod_ICGUZGYXTD,1);
}
bResult=true;
}
if (Eq(varName,'TGQHYPERED')) {
last_focused_comp=GetLastFocusedElementOfLink('TGQHYPERED');
function SetMethod_TGQHYPERED() {
Set_CATEG02(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_TGQHYPERED();
} else {
setTimeout(SetMethod_TGQHYPERED,1);
}
bResult=true;
}
if (Eq(varName,'QRJNKZVHDW')) {
last_focused_comp=GetLastFocusedElementOfLink('QRJNKZVHDW');
function SetMethod_QRJNKZVHDW() {
Set_CATEG03(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_QRJNKZVHDW();
} else {
setTimeout(SetMethod_QRJNKZVHDW,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'AEZUFOYHTM')) {
return [Ctrl('AEZUFOYHTM')];
}
if (Eq(varName,'BPQQBVFABO')) {
return [Ctrl('BPQQBVFABO')];
}
if (Eq(varName,'SGDAQGMTNU')) {
return [Ctrl('SGDAQGMTNU')];
}
if (Eq(varName,'JQLGHMLOKO')) {
return [Ctrl('JQLGHMLOKO')];
}
if (Eq(varName,'QVBZSFMTVP')) {
return [Ctrl('QVBZSFMTVP')];
}
if (Eq(varName,'ICGUZGYXTD')) {
return [Ctrl('ICGUZGYXTD')];
}
if (Eq(varName,'TGQHYPERED')) {
return [Ctrl('TGQHYPERED')];
}
if (Eq(varName,'QRJNKZVHDW')) {
return [Ctrl('QRJNKZVHDW')];
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
parent.ZtVWeb.raiseEventToEvalParms('armt_anadip_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('armt_anadip_dataNotSent',{'action':formaction});
}
}
}
}
CheckChild.child=[{'prg':"ardt_dippreposti",'BOScId':function(){ return FrameRef('ardt_dippreposti')},'repeated':0}];
function Check() {
var l_bResult = true;
var l_bChildCheck = true;
ResetErrorVars();
m_nLastError=0;
if ( ! (_ChkObl('PBPAZFLKHV',1))) {
_SignErr('PBPAZFLKHV');
m_cLastWorkVarErrorMsg='2071283709';
l_bResult=false;
w_CODDIP=HtW('','C');
} else if ( ! (_ChkObl('XCUHPGQTRL',1))) {
_SignErr('XCUHPGQTRL');
m_cLastWorkVarErrorMsg='285808099';
l_bResult=false;
w_DESCRIZ=HtW('','C');
} else if ( ! (_ChkObl('JRSYWVEHIR',1))) {
_SignErr('JRSYWVEHIR');
m_cLastWorkVarErrorMsg='554236824';
l_bResult=false;
w_DOMICILIO=HtW('','C');
} else if ( ! (_ChkObl('KQSLGVHSRE',1))) {
_SignErr('KQSLGVHSRE');
m_cLastWorkVarErrorMsg='21587';
l_bResult=false;
w_CAP=HtW('','C');
} else if ( ! (_ChkObl('AEZUFOYHTM',1))) {
_SignErr('AEZUFOYHTM');
m_cLastWorkVarErrorMsg='15186643';
l_bResult=false;
w_DESCCIT=HtW('','C');
} else if ( ! (_ChkObl('WRIYZYCTBR',1))) {
_SignErr('WRIYZYCTBR');
m_cLastWorkVarErrorMsg='113986481';
l_bResult=false;
w_AGENTE='N';
} else if ( ! (_ChkObl('BPQQBVFABO',1))) {
_SignErr('BPQQBVFABO');
m_cLastWorkVarErrorMsg='11725152890';
l_bResult=false;
w_MACROAGENTE=HtW('','C');
} else if ( ! (_ChkObl('RTLSPZPWWO',1))) {
_SignErr('RTLSPZPWWO');
m_cLastWorkVarErrorMsg='1240894674';
l_bResult=false;
w_TERMINALID=HtW('','C');
} else if ( ! (_ChkObl('WTENUNIUCY',1))) {
_SignErr('WTENUNIUCY');
m_cLastWorkVarErrorMsg='12014834236';
l_bResult=false;
w_IDBASE=HtW('','C');
} else if ( ! (_ChkObl('CDMUQZYEAX',1))) {
_SignErr('CDMUQZYEAX');
m_cLastWorkVarErrorMsg='1700577956';
l_bResult=false;
w_TELEFONO=HtW('','C');
} else if ( ! (_ChkObl('YTCIMOKXKS',1))) {
_SignErr('YTCIMOKXKS');
m_cLastWorkVarErrorMsg='10376012512';
l_bResult=false;
w_ABICABSARA=HtW('','C');
} else if ( ! (_ChkObl('NISBFWYVAN',1))) {
_SignErr('NISBFWYVAN');
m_cLastWorkVarErrorMsg='1276075358';
l_bResult=false;
w_AGACCODE=HtW('','C');
} else if ( ! (_ChkObl('SGDAQGMTNU',1))) {
_SignErr('SGDAQGMTNU');
m_cLastWorkVarErrorMsg='1946812107';
l_bResult=false;
w_NAZAGENTE=HtW('','C');
} else if ( ! (_ChkObl('KSBCZELDDB',1))) {
_SignErr('KSBCZELDDB');
m_cLastWorkVarErrorMsg='1817574818';
l_bResult=false;
w_AGEREGIO=HtW('','C');
} else if ( ! (_ChkObl('ECKDLHTTSN',1))) {
_SignErr('ECKDLHTTSN');
m_cLastWorkVarErrorMsg='245446773';
l_bResult=false;
w_FLGATT='N';
} else if ( ! (_ChkObl('DUZIXALHHS',1))) {
_SignErr('DUZIXALHHS');
m_cLastWorkVarErrorMsg='1093030153';
l_bResult=false;
w_CODLOC=HtW('','C');
} else if ( ! (_ChkObl('MOQMJLJJNI',1))) {
_SignErr('MOQMJLJJNI');
m_cLastWorkVarErrorMsg='923045322';
l_bResult=false;
w_CODAGE=HtW('','C');
} else if ( ! (_ChkObl('LYZAJWZGAM',1))) {
_SignErr('LYZAJWZGAM');
m_cLastWorkVarErrorMsg='229480117';
l_bResult=false;
w_TIPOSV=HtW('','C');
} else if ( ! (_ChkObl('NPJMZHJDRZ',1))) {
_SignErr('NPJMZHJDRZ');
m_cLastWorkVarErrorMsg='11553173743';
l_bResult=false;
w_FLGNOAUA='N';
} else if ( ! (_ChkObl('PNZMYOKETI',1))) {
_SignErr('PNZMYOKETI');
m_cLastWorkVarErrorMsg='1519836549';
l_bResult=false;
w_FLGWUPOS='N';
} else if ( ! (_ChkObl('JQLGHMLOKO',1))) {
_SignErr('JQLGHMLOKO');
m_cLastWorkVarErrorMsg='157154740';
l_bResult=false;
w_CATEG04=HtW('','C');
} else if ( ! (_ChkObl('QVBZSFMTVP',1))) {
_SignErr('QVBZSFMTVP');
m_cLastWorkVarErrorMsg='157154740';
l_bResult=false;
w_CATEG05=HtW('','C');
} else if ( ! (_ChkObl('ICGUZGYXTD',1))) {
_SignErr('ICGUZGYXTD');
m_cLastWorkVarErrorMsg='157154740';
l_bResult=false;
w_CATEG01=HtW('','C');
} else if ( ! (_ChkObl('TGQHYPERED',1))) {
_SignErr('TGQHYPERED');
m_cLastWorkVarErrorMsg='157154996';
l_bResult=false;
w_CATEG02=HtW('','C');
} else if ( ! (_ChkObl('QRJNKZVHDW',1))) {
_SignErr('QRJNKZVHDW');
m_cLastWorkVarErrorMsg='157155252';
l_bResult=false;
w_CATEG03=HtW('','C');
} else if ( ! (_ChkObl('IOZYXJKYDX',1))) {
_SignErr('IOZYXJKYDX');
m_cLastWorkVarErrorMsg='11537497388';
l_bResult=false;
w_CAB2=HtW('','C');
} else if ( ! (_ChkObl('VYZSOTTSWB',1))) {
_SignErr('VYZSOTTSWB');
m_cLastWorkVarErrorMsg='11189129404';
l_bResult=false;
w_CODICEAAMS=HtW('','C');
} else if ( ! (_ChkObl('JJJFDTJFAK',1))) {
_SignErr('JJJFDTJFAK');
m_cLastWorkVarErrorMsg='178000258';
l_bResult=false;
w_CONCESSIONE=HtW('','C');
} else if ( ! (_ChkObl('ACTQHMCVYK',1))) {
_SignErr('ACTQHMCVYK');
m_cLastWorkVarErrorMsg='11921223220';
l_bResult=false;
w_CODFISC=HtW('','C');
} else if ( ! (_ChkObl('RTWJYVXECF',1))) {
_SignErr('RTWJYVXECF');
m_cLastWorkVarErrorMsg='1756430089';
l_bResult=false;
w_PARTIVA=HtW('','C');
} else if ( ! (_ChkObl('ACDLDQVQXS',1))) {
_SignErr('ACDLDQVQXS');
m_cLastWorkVarErrorMsg='11153969262';
l_bResult=false;
w_TIPOAGENTE=HtW('','C');
} else if ( ! (_ChkObl('PWMWPIWKXR',1))) {
_SignErr('PWMWPIWKXR');
m_cLastWorkVarErrorMsg='1474192743';
l_bResult=false;
w_NUMCIVICO=HtW('','C');
} else if ( ! (_ChkObl('VKYZPROJCI',1))) {
_SignErr('VKYZPROJCI');
m_cLastWorkVarErrorMsg='12128215460';
l_bResult=false;
w_SERRIMDEN='N';
} else if ( ! (_ChkObl('OSJJWSZMDE',1))) {
_SignErr('OSJJWSZMDE');
m_cLastWorkVarErrorMsg='11223264513';
l_bResult=false;
w_DATAINI=HtW('','D');
} else if ( ! (_ChkObl('QDGOPSCQNI',1))) {
_SignErr('QDGOPSCQNI','1325233457');
l_bResult=false;
w_DATAFINE=HtW('','D');
} else if ( ! (_ChkObl('DVNRBUBGST',1))) {
_SignErr('DVNRBUBGST');
m_cLastWorkVarErrorMsg='986106899';
l_bResult=false;
w_FLGCOMPL=0;
}
if (l_bResult) {
l_bResult=CheckChild(0);
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('AEZUFOYHTM_ZOOM',lc)) {
return 0;
}
if (Eq('AEZUFOYHTM',lc)) {
return 0;
}
if (Eq('BPQQBVFABO_ZOOM',lc)) {
return 1;
}
if (Eq('BPQQBVFABO',lc)) {
return 1;
}
if (Eq('SGDAQGMTNU_ZOOM',lc)) {
return 2;
}
if (Eq('SGDAQGMTNU',lc)) {
return 2;
}
if (Eq('JQLGHMLOKO_ZOOM',lc)) {
return 3;
}
if (Eq('JQLGHMLOKO',lc)) {
return 3;
}
if (Eq('QVBZSFMTVP_ZOOM',lc)) {
return 4;
}
if (Eq('QVBZSFMTVP',lc)) {
return 4;
}
if (Eq('ICGUZGYXTD_ZOOM',lc)) {
return 5;
}
if (Eq('ICGUZGYXTD',lc)) {
return 5;
}
if (Eq('TGQHYPERED_ZOOM',lc)) {
return 6;
}
if (Eq('TGQHYPERED',lc)) {
return 6;
}
if (Eq('QRJNKZVHDW_ZOOM',lc)) {
return 7;
}
if (Eq('QRJNKZVHDW',lc)) {
return 7;
}
if (Eq('OSJJWSZMDE_ZOOM',lc)) {
return 8;
}
if (Eq('QDGOPSCQNI_ZOOM',lc)) {
return 8;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_AEZUFOYHTM();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,1)) {
l_oWv=LOpt_BPQQBVFABO();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,2)) {
l_oWv=LOpt_SGDAQGMTNU();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,3)) {
l_oWv=LOpt_JQLGHMLOKO();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
l_cFixedFilter=l_cFixedFilter+l_cAndOp+_flt_('C4CODTAB',w_tipocat,'C',true);
if ( ! (Empty(l_cFixedFilter))) {
l_cAndOp=' and ';
}
l_oWv.setValue('FixedFilter',l_cFixedFilter);
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,4)) {
l_oWv=LOpt_QVBZSFMTVP();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
l_cFixedFilter=l_cFixedFilter+l_cAndOp+_flt_('C5CODTAB',w_tipocat,'C',true);
if ( ! (Empty(l_cFixedFilter))) {
l_cAndOp=' and ';
}
l_oWv.setValue('FixedFilter',l_cFixedFilter);
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,5)) {
l_oWv=LOpt_ICGUZGYXTD();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
l_cFixedFilter=l_cFixedFilter+l_cAndOp+_flt_('C1CODTAB',w_tipocat,'C',true);
if ( ! (Empty(l_cFixedFilter))) {
l_cAndOp=' and ';
}
l_oWv.setValue('FixedFilter',l_cFixedFilter);
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,6)) {
l_oWv=LOpt_TGQHYPERED();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
l_cFixedFilter=l_cFixedFilter+l_cAndOp+_flt_('C2CODTAB',w_tipocat,'C',true);
if ( ! (Empty(l_cFixedFilter))) {
l_cAndOp=' and ';
}
l_oWv.setValue('FixedFilter',l_cFixedFilter);
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,7)) {
l_oWv=LOpt_QRJNKZVHDW();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
l_cFixedFilter=l_cFixedFilter+l_cAndOp+_flt_('C3CODTAB',w_tipocat,'C',true);
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
l_oWv.setValue('CODDIP',WtA(w_CODDIP,'C'));
l_oWv.setValue('DESCRIZ',WtA(w_DESCRIZ,'C'));
l_oWv.setValue('DOMICILIO',WtA(w_DOMICILIO,'C'));
l_oWv.setValue('CAP',WtA(w_CAP,'C'));
l_oWv.setValue('IDCITTA',WtA(w_IDCITTA,'C'));
l_oWv.setValue('DESCCIT',WtA(w_DESCCIT,'C'));
l_oWv.setValue('PROVINCIA',WtA(w_PROVINCIA,'C'));
l_oWv.setValue('CAB',WtA(w_CAB,'C'));
l_oWv.setValue('AGENTE',WtA(w_AGENTE,'C'));
l_oWv.setValue('MACROAGENTE',WtA(w_MACROAGENTE,'C'));
l_oWv.setValue('TERMINALID',WtA(w_TERMINALID,'C'));
l_oWv.setValue('IDBASE',WtA(w_IDBASE,'C'));
l_oWv.setValue('TELEFONO',WtA(w_TELEFONO,'C'));
l_oWv.setValue('ABICABSARA',WtA(w_ABICABSARA,'C'));
l_oWv.setValue('AGACCODE',WtA(w_AGACCODE,'C'));
l_oWv.setValue('NAZAGENTE',WtA(w_NAZAGENTE,'C'));
l_oWv.setValue('VALCOMPL',WtA(w_VALCOMPL,'C'));
l_oWv.setValue('ANOMOPER',WtA(w_ANOMOPER,'C'));
l_oWv.setValue('OPXSOSCLI',WtA(w_OPXSOSCLI,'N'));
l_oWv.setValue('OPXSOSAGE',WtA(w_OPXSOSAGE,'N'));
l_oWv.setValue('AGEREGIO',WtA(w_AGEREGIO,'C'));
l_oWv.setValue('FLGATT',WtA(w_FLGATT,'C'));
l_oWv.setValue('CODLOC',WtA(w_CODLOC,'C'));
l_oWv.setValue('CODAGE',WtA(w_CODAGE,'C'));
l_oWv.setValue('TIPOSV',WtA(w_TIPOSV,'C'));
l_oWv.setValue('FLGNOAUA',WtA(w_FLGNOAUA,'C'));
l_oWv.setValue('FLGWUPOS',WtA(w_FLGWUPOS,'C'));
l_oWv.setValue('CATEG04',WtA(w_CATEG04,'C'));
l_oWv.setValue('CATEG05',WtA(w_CATEG05,'C'));
l_oWv.setValue('CATEGORIA',WtA(w_CATEGORIA,'C'));
l_oWv.setValue('CATEG01',WtA(w_CATEG01,'C'));
l_oWv.setValue('CATEG02',WtA(w_CATEG02,'C'));
l_oWv.setValue('CATEG03',WtA(w_CATEG03,'C'));
l_oWv.setValue('CAB2',WtA(w_CAB2,'C'));
l_oWv.setValue('CODICEAAMS',WtA(w_CODICEAAMS,'C'));
l_oWv.setValue('CONCESSIONE',WtA(w_CONCESSIONE,'C'));
l_oWv.setValue('CODFISC',WtA(w_CODFISC,'C'));
l_oWv.setValue('PARTIVA',WtA(w_PARTIVA,'C'));
l_oWv.setValue('TIPOAGENTE',WtA(w_TIPOAGENTE,'C'));
l_oWv.setValue('NUMCIVICO',WtA(w_NUMCIVICO,'C'));
l_oWv.setValue('SERRIMDEN',WtA(w_SERRIMDEN,'C'));
l_oWv.setValue('DATAINI',WtA(w_DATAINI,'D'));
l_oWv.setValue('DATAFINE',WtA(w_DATAFINE,'D'));
l_oWv.setValue('FLGCOMPL',WtA(w_FLGCOMPL,'N'));
l_oWv.setValue('gFlgWU',WtA(w_gFlgWU,'C'));
l_oWv.setValue('xMADESCRI',WtA(w_xMADESCRI,'C'));
l_oWv.setValue('xDESCNAZ',WtA(w_xDESCNAZ,'C'));
l_oWv.setValue('gAgeCGO',WtA(w_gAgeCGO,'C'));
l_oWv.setValue('tipocat',WtA(w_tipocat,'C'));
l_oWv.setValue('xC1DESCRI',WtA(w_xC1DESCRI,'C'));
l_oWv.setValue('xC2DESCRI',WtA(w_xC2DESCRI,'C'));
l_oWv.setValue('xC3DESCRI',WtA(w_xC3DESCRI,'C'));
l_oWv.setValue('xC4DESCRI',WtA(w_xC4DESCRI,'C'));
l_oWv.setValue('xC5DESCRI',WtA(w_xC5DESCRI,'C'));
l_oWv.setValue('gTipInter',WtA(w_gTipInter,'C'));
l_oWv.setValue('xDESCAN',WtA(w_xDESCAN,'C'));
l_oWv.setValue('xMACOGNOME',WtA(w_xMACOGNOME,'C'));
l_oWv.setValue('xMANOME',WtA(w_xMANOME,'C'));
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
_FillChildren.n=['ardt_dippreposti'];
FillWv.n=["CODDIP","DESCRIZ","DOMICILIO","CAP","IDCITTA","DESCCIT","PROVINCIA","CAB","AGENTE","MACROAGENTE","TERMINALID","IDBASE","TELEFONO","ABICABSARA","AGACCODE","NAZAGENTE","VALCOMPL","ANOMOPER","OPXSOSCLI","OPXSOSAGE","AGEREGIO","FLGATT","CODLOC","CODAGE","TIPOSV","FLGNOAUA","FLGWUPOS","CATEG04","CATEG05","CATEGORIA","CATEG01","CATEG02","CATEG03","CAB2","CODICEAAMS","CONCESSIONE","CODFISC","PARTIVA","TIPOAGENTE","NUMCIVICO","SERRIMDEN","DATAINI","DATAFINE","FLGCOMPL","gFlgWU","xMADESCRI","xDESCNAZ","gAgeCGO","tipocat","xC1DESCRI","xC2DESCRI","xC3DESCRI","xC4DESCRI","xC5DESCRI","gTipInter","xDESCAN","xMACOGNOME","xMANOME"];
function SetModified() {
m_bUpdated=true;
}
function SetChildVariables_ardt_dippreposti() {
}
function CtxLoad_ardt_dippreposti() {
if (ChildToLoad(FrameRef('ardt_dippreposti'))) {
return [LoadContext(0,'ZBFNRFHLSE'),'ardt_dippreposti'];
}
}
