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
function DisplayErrorMessage_ardt_informazioni() {
if ( ! (ChildToLoad(FrameRef('ardt_informazioni'))) && Ne(typeof(FrameRef('ardt_informazioni').DisplayErrorMessage),'undefined')) {
FrameRef('ardt_informazioni').DisplayErrorMessage();
}
}
function DisplayErrorMessage_ardt_delegabo() {
if ( ! (ChildToLoad(FrameRef('ardt_delegabo'))) && Ne(typeof(FrameRef('ardt_delegabo').DisplayErrorMessage),'undefined')) {
FrameRef('ardt_delegabo').DisplayErrorMessage();
}
}
function DisplayErrorMessage_ardt_soginfo() {
if ( ! (ChildToLoad(FrameRef('ardt_soginfo'))) && Ne(typeof(FrameRef('ardt_soginfo').DisplayErrorMessage),'undefined')) {
FrameRef('ardt_soginfo').DisplayErrorMessage();
}
}
function DisplayErrorMessage_ardt_fiduciabo() {
if ( ! (ChildToLoad(FrameRef('ardt_fiduciabo'))) && Ne(typeof(FrameRef('ardt_fiduciabo').DisplayErrorMessage),'undefined')) {
FrameRef('ardt_fiduciabo').DisplayErrorMessage();
}
}
function DisplayErrorMessage_ardt_terzistirap() {
if ( ! (ChildToLoad(FrameRef('ardt_terzistirap'))) && Ne(typeof(FrameRef('ardt_terzistirap').DisplayErrorMessage),'undefined')) {
FrameRef('ardt_terzistirap').DisplayErrorMessage();
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
l_bEnabled= ! (Eq(At(w_TIPOOPRAP,'|25|28|39|40|41|47'),0) &&  ! (Empty(w_TIPOOPRAP))) || IsDisabledByStateDriver('Informazioni');
if ( ! (ChildToLoad(FrameRef('ardt_informazioni'))) && Ne(typeof(FrameRef('ardt_informazioni').EnableEntity),'undefined')) {
FrameRef('ardt_informazioni').EnableEntity(l_bEnabled);
}
l_bEnabled= ! (Gt(At(w_TIPOOPRAP,'|25|28|39|40|41|47'),0) &&  ! (Empty(w_TIPOOPRAP))) || IsDisabledByStateDriver('Deleghe');
if ( ! (ChildToLoad(FrameRef('ardt_delegabo'))) && Ne(typeof(FrameRef('ardt_delegabo').EnableEntity),'undefined')) {
FrameRef('ardt_delegabo').EnableEntity(l_bEnabled);
}
l_bEnabled= ! ( ! (Utilities.Make(window).IsInGroup(3))) || IsDisabledByStateDriver('CODDIPE');
SetDisabled('AVHTGZTOSZ',l_bEnabled);
SetDisabled(Ctrl('AVHTGZTOSZ_ZOOM'),l_bEnabled);
l_bEnabled= ! (Ne(w_gChkDate,'U') && Ne(w_gChkDate,'B') && Eq(w_gFlgDTP,0)) || IsDisabledByStateDriver('DATAREG');
SetDisabled('OEIKQOZMYJ',l_bEnabled);
SetDisabled(Ctrl('OEIKQOZMYJ_ZOOM'),l_bEnabled);
l_bEnabled= ! (false) || IsDisabledByStateDriver('DATARETT');
SetDisabled('VYBZEWHKFF',l_bEnabled);
l_bEnabled= ! (false) || IsDisabledByStateDriver('STATOREG');
SetDisabled('OJXGBVSJHY',l_bEnabled);
if (IsDisabledByStateDriver('Intermediario')) {
DisableInputsInContainer(Ctrl('GSYOOIOWZF'),true);
}
if (IsDisabledByStateDriver('DATIBASE')) {
DisableInputsInContainer(Ctrl('YORQOIOBQN'),true);
}
if (IsDisabledByStateDriver('INTESTATARI')) {
Z.Tabs.Get("tabs_1_DETTAGLIO").SetDisable('HOHRVXKGPC',true);
}
if (IsDisabledByStateDriver('DELEGATI')) {
Z.Tabs.Get("tabs_1_DETTAGLIO").SetDisable('PUODKNEFWX',true);
}
if (IsDisabledByStateDriver('DATIRET')) {
DisableInputsInContainer(Ctrl('KURTXQHCYE'),true);
}
if (IsDisabledByStateDriver('ALTRISOGG')) {
Z.Tabs.Get("tabs_2_Altri").SetDisable('HDCVKCQUDV',true);
}
if (IsDisabledByStateDriver('TITOLARI')) {
Z.Tabs.Get("tabs_2_Altri").SetDisable('RTQYCVGOWV',true);
}
if (IsDisabledByStateDriver('Intermediario')) {
DisableInputsInContainer(Ctrl('YCTBVNLZSK'),true);
}
if (IsDisabledByStateDriver('FIDUCIANTI')) {
Z.Tabs.Get("tabs_2_Altri").SetDisable('LTJVEGZAIT',true);
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
if(c=Ctrl('SWRTSKXMDH')) c.title=Strtran(AlertErrorMessage('1148775685',w_TIPOOPRAP),'\\n',"\n");
if(c=Ctrl('MLPGOPNAKN')) c.title=Strtran(AlertErrorMessage('340709450',w_TIPOLEG),'\\n',"\n");
if(c=Ctrl('OJXGBVSJHY')) c.title=Strtran(AlertErrorMessage('1215050295',w_STATOREG),'\\n',"\n");
}
function Set_CODDIPE(ctrlValue,kmode,e) {
if (Ne(w_CODDIPE,ctrlValue)) {
var ctl = _GetCtl(e,'AVHTGZTOSZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_CODDIPE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('AVHTGZTOSZ',0);
if (l_bResult) {
l_bResult=Link_AVHTGZTOSZ(kmode);
if ( ! (l_bResult)) {
w_CODDIPE=HtW('','C');
}
}
l_bResult=l_bResult && _ChkObl('BRGHYFSDHY',0);
if (l_bResult) {
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
var ctl = _GetCtl(e,'UMFEJVRUFZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_RAPPORTO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UMFEJVRUFZ',0);
if (l_bResult) {
l_bResult=Link_UMFEJVRUFZ(kmode);
if ( ! (l_bResult)) {
w_RAPPORTO=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',25,0,'@!'));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',25,0,'@!');
_ResetTracker();
return true;
}
}
return true;
}
function Set_STATOREG(ctrlValue,kmode,e) {
if (Ne(w_STATOREG,ctrlValue)) {
var ctl = _GetCtl(e,'OJXGBVSJHY');
if (_tracker.goon(ctl,ctrlValue)) {
w_STATOREG=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('OJXGBVSJHY',0);
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
function Set_TIPOLEG(ctrlValue,kmode,e) {
if (Ne(w_TIPOLEG,ctrlValue)) {
var ctl = _GetCtl(e,'MLPGOPNAKN');
if (_tracker.goon(ctl,ctrlValue)) {
w_TIPOLEG=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MLPGOPNAKN',0);
if (l_bResult) {
l_bResult=Link_MLPGOPNAKN(kmode);
if ( ! (l_bResult)) {
w_TIPOLEG=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',1,0,''));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_CONNESOPER(ctrlValue,kmode,e) {
if (Ne(w_CONNESOPER,ctrlValue)) {
var ctl = _GetCtl(e,'SLTZSUMACW');
if (_tracker.goon(ctl,ctrlValue)) {
w_CONNESOPER=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
var l_bWarn = true;
l_bResult=_ChkObl('SLTZSUMACW',0);
if (l_bResult) {
l_bResult=Link_SLTZSUMACW(kmode);
if (l_bResult && ( ! (arfn_chkdatdoc(w_CONNESOPER,w_DATAREG)) && Ne(m_nLastError,-2))) {
try {
_tracker.askwrn=true;
l_bWarn=WindowConfirm(AlertErrorMessage('11525797640'));
} finally {
_tracker.askwrn=false;
}
if ( ! (l_bWarn)) {
Link_SLTZSUMACW_Blank();
}
}
if ( ! (l_bResult) ||  ! (l_bWarn)) {
w_CONNESOPER=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult) ||  ! (l_bWarn)) {
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
function Set_TIPOOPRAP(ctrlValue,kmode,e) {
if (Ne(w_TIPOOPRAP,ctrlValue)) {
var ctl = _GetCtl(e,'SWRTSKXMDH');
if (_tracker.goon(ctl,ctrlValue)) {
w_TIPOOPRAP=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SWRTSKXMDH',0);
if (l_bResult) {
l_bResult=Link_SWRTSKXMDH(kmode);
if ( ! (l_bResult)) {
w_TIPOOPRAP=HtW('','C');
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
function Set_DATAREG(ctrlValue,kmode,e) {
if (Ne(w_DATAREG,ctrlValue)) {
var ctl = _GetCtl(e,'OEIKQOZMYJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_DATAREG=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
var l_bWarn = true;
l_bResult=_ChkObl('OEIKQOZMYJ',0);
if (l_bResult) {
l_bResult=Ge(w_DATAREG,w_DATAOPE);
if ( ! (l_bResult)) {
m_nLastError=2;
m_cLastWorkVarErrorMsg='1028598955';
m_cLastMsgError=AlertErrorMessage('2021191611');
}
if (l_bResult && ( ! (Le(DateDiff(w_DATAOPE,w_DATAREG),30)) && Ne(m_nLastError,-2))) {
try {
_tracker.askwrn=true;
l_bWarn=WindowConfirm(AlertErrorMessage('10082410841'));
} finally {
_tracker.askwrn=false;
}
}
if ( ! (l_bResult) ||  ! (l_bWarn)) {
w_DATAREG=HtW('','D');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult) ||  ! (l_bWarn)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D')));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH(NullDate(),'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
_ResetTracker();
return true;
}
}
return true;
}
function Set_DATAOPE(ctrlValue,kmode,e) {
if (Ne(w_DATAOPE,ctrlValue)) {
var ctl = _GetCtl(e,'YLIKFVPZJA');
if (_tracker.goon(ctl,ctrlValue)) {
w_DATAOPE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
var l_bWarn = true;
l_bResult=_ChkObl('YLIKFVPZJA',0);
if (l_bResult) {
l_bResult=Ge(w_DATAREG,w_DATAOPE);
if ( ! (l_bResult)) {
m_nLastError=2;
m_cLastWorkVarErrorMsg='829201110';
m_cLastMsgError=AlertErrorMessage('2021191611');
}
if (l_bResult && ( ! (Le(DateDiff(w_DATAOPE,w_DATAREG),30)) && Ne(m_nLastError,-2))) {
try {
_tracker.askwrn=true;
l_bWarn=WindowConfirm(AlertErrorMessage('10082410841'));
} finally {
_tracker.askwrn=false;
}
}
if ( ! (l_bResult) ||  ! (l_bWarn)) {
w_DATAOPE=HtW('','D');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult) ||  ! (l_bWarn)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D')));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH(NullDate(),'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
_ResetTracker();
return true;
}
}
return true;
}
function Set_FLAGTIT(ctrlValue,kmode,e) {
if (Ne(w_FLAGTIT,ctrlValue)) {
var ctl = _GetCtl(e,'WKYJJJVZEF');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLAGTIT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('WKYJJJVZEF',0);
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
function Set_closeall(ctrlValue,kmode,e) {
if (Ne(w_closeall,ctrlValue)) {
var ctl = _GetCtl(e,'JGGDFBSZJB');
if (_tracker.goon(ctl,ctrlValue)) {
w_closeall=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('JGGDFBSZJB',0);
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
function Set_DATARETT(ctrlValue,kmode,e) {
if (Ne(w_DATARETT,ctrlValue)) {
var ctl = _GetCtl(e,'VYBZEWHKFF');
if (_tracker.goon(ctl,ctrlValue)) {
w_DATARETT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VYBZEWHKFF',0);
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
if ( ! (ChildToLoad(FrameRef('ardt_informazioni'))) && Ne(typeof(FrameRef('ardt_informazioni').DoUpdate),'undefined')) {
if (Ne(typeof(FrameRef('ardt_informazioni').m_oTrs),'undefined')) {
FrameRef('ardt_informazioni').EnableEntity(false);
}
CopyWorkVar(FrameRef('ardt_informazioni'),['TIPORAP'],['FLAGRAP'],true)
if (Ne(typeof(FrameRef('ardt_informazioni').m_oTrs),'undefined')) {
l_bEnabled= ! (Eq(At(w_TIPOOPRAP,'|25|28|39|40|41|47'),0) &&  ! (Empty(w_TIPOOPRAP))) || IsDisabledByStateDriver('Informazioni');
if ( ! (ChildToLoad(FrameRef('ardt_informazioni'))) && Ne(typeof(FrameRef('ardt_informazioni').EnableEntity),'undefined')) {
FrameRef('ardt_informazioni').EnableEntity(l_bEnabled);
}
}
}
if ( ! (ChildToLoad(FrameRef('ardt_delegabo'))) && Ne(typeof(FrameRef('ardt_delegabo').DoUpdate),'undefined')) {
if (Ne(typeof(FrameRef('ardt_delegabo').m_oTrs),'undefined')) {
FrameRef('ardt_delegabo').EnableEntity(false);
}
CopyWorkVar(FrameRef('ardt_delegabo'),['TIPORAP'],['FLAGRAP'],true)
if (Ne(typeof(FrameRef('ardt_delegabo').m_oTrs),'undefined')) {
l_bEnabled= ! (Gt(At(w_TIPOOPRAP,'|25|28|39|40|41|47'),0) &&  ! (Empty(w_TIPOOPRAP))) || IsDisabledByStateDriver('Deleghe');
if ( ! (ChildToLoad(FrameRef('ardt_delegabo'))) && Ne(typeof(FrameRef('ardt_delegabo').EnableEntity),'undefined')) {
FrameRef('ardt_delegabo').EnableEntity(l_bEnabled);
}
}
}
if ((Ne(o_TIPOOPRAP,w_TIPOOPRAP))) {
w_tipregn=Val(LRTrim(w_tipreg));
}
w_CDATOPE=DateToChar(w_DATAOPE);
w_CDATREG=DateToChar(w_DATAREG);
w_CODINTER=w_gIntemediario;
l_bTmpRes=Link_WJSVGWKSFC(null);
if ((Ne(o_CDATOPE,w_CDATOPE)) || (Ne(o_filtro,w_filtro))) {
RenderDynamicCombo('MLPGOPNAKN');
l_bTmpRes=Link_MLPGOPNAKN(null);
}
UpdateAutonumber('IDBASE');
w_OPRAP=Left(w_TIPOOPRAP,1);
UpdateAutonumber('NUMPROG');
UpdateAutonumber('PRGIMPINF');
if ((Ne(o_CODINTER,w_CODINTER)) || (Ne(o_CODDIPE,w_CODDIPE))) {
Calculation_WKUMXNRIRT();
}
if ((Ne(o_RAPPORTO,w_RAPPORTO))) {
w_inutile=0;
}
w_prova=LibreriaMit.URL_enc(w_RAPPORTO);
LibJavascript.forEachItem(m_FoundlingCopyWorkVar,i_body_1)
function i_body_1(child){
child();
}
// * --- Area Manuale = UI - Calculate
// * --- armt_informazioni
FrameRef('ardt_informazioni').Calculate()
FrameRef('ardt_informazioni').DoUpdate(true)
FrameRef('ardt_delegabo').Calculate()
FrameRef('ardt_delegabo').DoUpdate(true)
FrameRef('ardt_soginfo').Calculate()
FrameRef('ardt_soginfo').DoUpdate(true)
FrameRef('ardt_fiduciabo').Calculate()
FrameRef('ardt_fiduciabo').DoUpdate(true)
if ((Ne(o_RAPPORTO,w_RAPPORTO))) {
 CaricaSog();
}
// * --- Fine Area Manuale
UpdateAutonumber('');
m_bCalculating=false;
}
function Calculation_WKUMXNRIRT() {
w_DESCCIT=(Empty(w_CODDIPE)?w_CITINT:w_CITDIP);
w_PROVINCIA=(Empty(w_CODDIPE)?w_PROVINT:w_PROVDIP);
w_CODCAB=(Empty(w_CODDIPE)?w_CABINT:w_CABDIP);
}
function SaveDependsOn() {
o_filtro=w_filtro;
o_CDATOPE=w_CDATOPE;
o_CODINTER=w_CODINTER;
o_CODDIPE=w_CODDIPE;
o_RAPPORTO=w_RAPPORTO;
o_DATAOPE=w_DATAOPE;
o_TIPOOPRAP=w_TIPOOPRAP;
o_FLAGRAP=w_FLAGRAP;
}
function SaveLabelDependsOn() {
}
function Link_WJSVGWKSFC(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CODINTER);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODINTER',w_CODINTER,11,0);
l_Appl.SetFields('CODINTER,DATANASC,CODCAB,PROVINCIA,DESCCIT,TIPINTER');
l_Appl.SetTypes('C,D,C,C,C,C');
l_Appl.LinkTable('intermbo');
l_Appl.SetLinkzoom('armt_intermbo');
l_Appl.SetID('WJSVGWKSFC');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CODINTER=l_Appl.GetStringValue('CODINTER',11,0);
w_datpaseuro=l_Appl.GetDateValue('DATANASC',8,0);
w_datpaseuro=DateFromApplet(w_datpaseuro);
w_CABINT=l_Appl.GetStringValue('CODCAB',6,0);
w_PROVINT=l_Appl.GetStringValue('PROVINCIA',2,0);
w_CITINT=l_Appl.GetStringValue('DESCCIT',30,0);
w_TIPOINTER=l_Appl.GetStringValue('TIPINTER',2,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_WJSVGWKSFC_Blank();
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
function Link_WJSVGWKSFC_Blank() {
w_CODINTER='';
w_datpaseuro=NullDate();
w_CABINT='';
w_PROVINT='';
w_CITINT='';
w_TIPOINTER='';
}
function LOpt_WJSVGWKSFC() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('intermbo','C'));
l_oWv.setValue('Linkzoomprg',WtA('armt_intermbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODINTER','C'));
l_oWv.setValue('LinkedField',WtA('CODINTER','C'));
l_oWv.setValue('UID',WtA('WJSVGWKSFC','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['WJSVGWKSFC'][1],'C'));
return l_oWv;
}
function Link_AVHTGZTOSZ(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CODDIPE);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODDIP',w_CODDIPE,6,0);
l_Appl.SetFields('CODDIP,DESCRIZ,DESCCIT,PROVINCIA,CAB');
l_Appl.SetTypes('C,C,C,C,C');
l_Appl.LinkTable('anadip');
l_Appl.SetID('AVHTGZTOSZ');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CODDIPE=l_Appl.GetStringValue('CODDIP',6,0);
w_xDescDipe=l_Appl.GetStringValue('DESCRIZ',30,0);
w_CITDIP=l_Appl.GetStringValue('DESCCIT',30,0);
w_PROVDIP=l_Appl.GetStringValue('PROVINCIA',2,0);
w_CABDIP=l_Appl.GetStringValue('CAB',6,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_AVHTGZTOSZ_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_AVHTGZTOSZ';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_AVHTGZTOSZ();
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
function Link_AVHTGZTOSZ_Blank() {
w_CODDIPE='';
w_xDescDipe='';
w_CITDIP='';
w_PROVDIP='';
w_CABDIP='';
}
function LOpt_AVHTGZTOSZ() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('anadip','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODDIP','C'));
l_oWv.setValue('LinkedField',WtA('CODDIP','C'));
l_oWv.setValue('UID',WtA('AVHTGZTOSZ','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['AVHTGZTOSZ'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('1270140318'),'C'));
return l_oWv;
}
function Link_UMFEJVRUFZ(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_RAPPORTO);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('RAPPORTO',w_RAPPORTO,25,0);
l_Appl.SetFields('RAPPORTO,DESCRAP,FLAGLIRE,VALUTA,TIPORAP');
l_Appl.SetTypes('C,C,C,C,C');
l_Appl.LinkTable('anarapbo');
l_Appl.SetID('UMFEJVRUFZ');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_RAPPORTO=l_Appl.GetStringValue('RAPPORTO',25,0);
w_xdescrap=l_Appl.GetStringValue('DESCRAP',50,0);
w_FLAGLIRE=l_Appl.GetStringValue('FLAGLIRE',1,0);
w_VALUTA=l_Appl.GetStringValue('VALUTA',3,0);
w_FLAGRAP=l_Appl.GetStringValue('TIPORAP',1,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_UMFEJVRUFZ_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_UMFEJVRUFZ';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_UMFEJVRUFZ();
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
function Link_UMFEJVRUFZ_Blank() {
w_RAPPORTO='';
w_xdescrap='';
w_FLAGLIRE='';
w_VALUTA='';
w_FLAGRAP='';
}
function LOpt_UMFEJVRUFZ() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('anarapbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('RAPPORTO','C'));
l_oWv.setValue('LinkedField',WtA('RAPPORTO','C'));
l_oWv.setValue('UID',WtA('UMFEJVRUFZ','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['UMFEJVRUFZ'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('10701632044'),'C'));
return l_oWv;
}
function Link_SWRTSKXMDH(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_TIPOOPRAP);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODICE',w_TIPOOPRAP,2,0);
l_Appl.SetFields('CODICE,DES1,TIPREG');
l_Appl.SetTypes('C,C,C');
l_Appl.LinkTable('tbtipreg');
l_Appl.SetID('SWRTSKXMDH');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_TIPOOPRAP=l_Appl.GetStringValue('CODICE',2,0);
w_xDesReg=l_Appl.GetStringValue('DES1',90,0);
w_tipreg=l_Appl.GetStringValue('TIPREG',1,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_SWRTSKXMDH_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_SWRTSKXMDH';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_SWRTSKXMDH();
l_oWv.setValue('FieldFilter',l_cFieldFilter);
if ( ! (Empty(l_Appl.GetWhereAddedFixedFiltersUnencoded()))) {
if ( ! (Empty(l_cFixedFilter))) {
l_cFixedFilter=l_cFixedFilter+' and ';
}
l_cFixedFilter=l_cFixedFilter+l_Appl.GetWhereAddedFixedFiltersUnencoded();
}
l_oWv.setValue('FixedFilter',l_cFixedFilter);
var initEntityFields = '';
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
function Link_SWRTSKXMDH_Blank() {
w_TIPOOPRAP='';
w_xDesReg='';
w_tipreg='';
}
function LOpt_SWRTSKXMDH() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbtipreg','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODICE','C'));
l_oWv.setValue('LinkedField',WtA('CODICE','C'));
l_oWv.setValue('UID',WtA('SWRTSKXMDH','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['SWRTSKXMDH'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('995100987'),'C'));
return l_oWv;
}
function Link_SLTZSUMACW(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CONNESOPER);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CONNES',w_CONNESOPER,16,0);
l_Appl.SetFields('CONNES,RAGSOC');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('personbo');
l_Appl.SetID('SLTZSUMACW');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CONNESOPER=l_Appl.GetStringValue('CONNES',16,0);
w_xRagSoc=l_Appl.GetStringValue('RAGSOC',70,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_SLTZSUMACW_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_SLTZSUMACW';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_SLTZSUMACW();
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
if (l_bResult &&  ! (Empty(w_CONNESOPER) && l_bEmp)) {
l_bResult=arfn_chksogg(w_CONNESOPER,'8');
if ( ! (l_bResult)) {
Link_SLTZSUMACW_Blank();
}
}
if ( ! (l_bResult)) {
m_nLastError=3;
m_cLastWorkVarErrorMsg='';
if (Lt(l_nRec,0)) {
m_cLastMsgError=Translate('MSG_CONNECT_SERVER');
} else {
m_cLastMsgError=AlertErrorMessage('11525797640');
}
}
}
return l_bResult;
}
function Link_SLTZSUMACW_Blank() {
w_CONNESOPER='';
w_xRagSoc='';
}
function LOpt_SLTZSUMACW() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('personbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CONNES','C'));
l_oWv.setValue('LinkedField',WtA('CONNES','C'));
l_oWv.setValue('UID',WtA('SLTZSUMACW','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['SLTZSUMACW'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('10505367639'),'C'));
return l_oWv;
}
function Link_MLPGOPNAKN(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_TIPOLEG);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('TIPLEG',w_TIPOLEG,1,0);
l_Appl.SetFields('TIPLEG');
l_Appl.SetTypes('C');
l_Appl.LinkTable('tbtipleg');
l_Appl.SetLinkzoom('armt_tipileg');
l_Appl.SetID('MLPGOPNAKN');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_TIPOLEG=l_Appl.GetStringValue('TIPLEG',1,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_MLPGOPNAKN_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_MLPGOPNAKN';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_MLPGOPNAKN();
l_oWv.setValue('FieldFilter',l_cFieldFilter);
if ( ! (Empty(l_Appl.GetWhereAddedFixedFiltersUnencoded()))) {
if ( ! (Empty(l_cFixedFilter))) {
l_cFixedFilter=l_cFixedFilter+' and ';
}
l_cFixedFilter=l_cFixedFilter+l_Appl.GetWhereAddedFixedFiltersUnencoded();
}
l_oWv.setValue('FixedFilter',l_cFixedFilter);
var initEntityFields = '';
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
function Link_MLPGOPNAKN_Blank() {
w_TIPOLEG='';
}
function LOpt_MLPGOPNAKN() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbtipleg','C'));
l_oWv.setValue('Linkzoomprg',WtA('armt_tipileg','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('TIPLEG','C'));
l_oWv.setValue('LinkedField',WtA('TIPLEG','C'));
l_oWv.setValue('UID',WtA('MLPGOPNAKN','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['MLPGOPNAKN'][1],'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'AVHTGZTOSZ')) {
last_focused_comp=GetLastFocusedElementOfLink('AVHTGZTOSZ');
function SetMethod_AVHTGZTOSZ() {
Set_CODDIPE(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_AVHTGZTOSZ();
} else {
setTimeout(SetMethod_AVHTGZTOSZ,1);
}
bResult=true;
}
if (Eq(varName,'UMFEJVRUFZ')) {
last_focused_comp=GetLastFocusedElementOfLink('UMFEJVRUFZ');
function SetMethod_UMFEJVRUFZ() {
Set_RAPPORTO(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_UMFEJVRUFZ();
} else {
setTimeout(SetMethod_UMFEJVRUFZ,1);
}
bResult=true;
}
if (Eq(varName,'SWRTSKXMDH')) {
last_focused_comp=GetLastFocusedElementOfLink('SWRTSKXMDH');
function SetMethod_SWRTSKXMDH() {
Set_TIPOOPRAP(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_SWRTSKXMDH();
} else {
setTimeout(SetMethod_SWRTSKXMDH,1);
}
bResult=true;
}
if (Eq(varName,'SLTZSUMACW')) {
last_focused_comp=GetLastFocusedElementOfLink('SLTZSUMACW');
function SetMethod_SLTZSUMACW() {
Set_CONNESOPER(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_SLTZSUMACW();
} else {
setTimeout(SetMethod_SLTZSUMACW,1);
}
bResult=true;
}
if (Eq(varName,'MLPGOPNAKN')) {
last_focused_comp=GetLastFocusedElementOfLink('MLPGOPNAKN');
function SetMethod_MLPGOPNAKN() {
Set_TIPOLEG(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_MLPGOPNAKN();
} else {
setTimeout(SetMethod_MLPGOPNAKN,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'AVHTGZTOSZ')) {
return [Ctrl('AVHTGZTOSZ')];
}
if (Eq(varName,'UMFEJVRUFZ')) {
return [Ctrl('UMFEJVRUFZ')];
}
if (Eq(varName,'SWRTSKXMDH')) {
return [Ctrl('SWRTSKXMDH')];
}
if (Eq(varName,'SLTZSUMACW')) {
return [Ctrl('SLTZSUMACW')];
}
if (Eq(varName,'MLPGOPNAKN')) {
return [Ctrl('MLPGOPNAKN')];
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
if (bResult) {
bResult=arfn_chkdatreg(w_DATAOPE,w_DATAREG,w_gChkDate,EntityStatus());
if ( ! (bResult)) {
m_cLastMsgError=AlertErrorMessage('11058877460');
}
}
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
parent.ZtVWeb.raiseEventToEvalParms('armt_informazioni_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('armt_informazioni_dataNotSent',{'action':formaction});
}
}
}
}
CheckChild.child=[{'prg':"ardt_informazioni",'BOScId':function(){ return FrameRef('ardt_informazioni')},'repeated':0},{'prg':"ardt_delegabo",'BOScId':function(){ return FrameRef('ardt_delegabo')},'repeated':0},{'prg':"ardt_soginfo",'BOScId':function(){ return FrameRef('ardt_soginfo')},'repeated':0},{'prg':"ardt_fiduciabo",'BOScId':function(){ return FrameRef('ardt_fiduciabo')},'repeated':0},{'prg':"ardt_terzistirap",'BOScId':function(){ return FrameRef('ardt_terzistirap')},'repeated':0}];
function Check() {
var l_bResult = true;
var l_bChildCheck = true;
ResetErrorVars();
m_nLastError=0;
if (( ! (Utilities.Make(window).IsInGroup(3))) && ( ! (_ChkObl('AVHTGZTOSZ',1)))) {
_SignErr('AVHTGZTOSZ');
m_cLastWorkVarErrorMsg='2071283709';
l_bResult=false;
w_CODDIPE=HtW('','C');
} else if ( ! (_ChkObl('UMFEJVRUFZ',1))) {
_SignErr('UMFEJVRUFZ');
m_cLastWorkVarErrorMsg='RAPPORTO';
l_bResult=false;
w_RAPPORTO=HtW('','C');
} else if (( ! (_ChkObl('YLIKFVPZJA',1))) || ( ! (Ge(w_DATAREG,w_DATAOPE)))) {
_SignErr('YLIKFVPZJA','2021191611');
l_bResult=false;
w_DATAOPE=HtW('','D');
} else if ((Ne(w_gChkDate,'U') && Ne(w_gChkDate,'B') && Eq(w_gFlgDTP,0)) && (( ! (_ChkObl('OEIKQOZMYJ',1))) || ( ! (Ge(w_DATAREG,w_DATAOPE))))) {
_SignErr('OEIKQOZMYJ','2021191611');
l_bResult=false;
w_DATAREG=HtW('','D');
} else if ( ! (_ChkObl('SWRTSKXMDH',1))) {
_SignErr('SWRTSKXMDH');
m_cLastWorkVarErrorMsg='684190680';
l_bResult=false;
w_TIPOOPRAP=HtW('','C');
} else if (( ! (_ChkObl('SLTZSUMACW',1))) || ( ! (Empty(w_CONNESOPER)) &&  ! (arfn_chksogg(w_CONNESOPER,'8')))) {
_SignErr('SLTZSUMACW','11525797640');
l_bResult=false;
w_CONNESOPER=HtW('','C');
} else if ( ! (_ChkObl('MLPGOPNAKN',1))) {
_SignErr('MLPGOPNAKN');
m_cLastWorkVarErrorMsg='11205021885';
l_bResult=false;
w_TIPOLEG=HtW('','C');
} else if ((false) && ( ! (_ChkObl('VYBZEWHKFF',1)))) {
_SignErr('VYBZEWHKFF');
m_cLastWorkVarErrorMsg='11329559720';
l_bResult=false;
w_DATARETT=HtW('','D');
} else if ((false) && ( ! (_ChkObl('OJXGBVSJHY',1)))) {
_SignErr('OJXGBVSJHY');
m_cLastWorkVarErrorMsg='7776403';
l_bResult=false;
w_STATOREG=HtW('','C');
} else if ( ! (_ChkObl('JGGDFBSZJB',1))) {
_SignErr('JGGDFBSZJB');
m_cLastWorkVarErrorMsg='closeall';
l_bResult=false;
w_closeall=HtW('','C');
} else if ( ! (_ChkObl('WKYJJJVZEF',1))) {
_SignErr('WKYJJJVZEF');
m_cLastWorkVarErrorMsg='2063970052';
l_bResult=false;
w_FLAGTIT=0;
}
if (l_bResult) {
l_bResult=CheckChild(0);
}
// * --- Area Manuale = UI - Check Form
// * --- armt_informazioni
if (w_gChkDate == 'S') {
  if (Lt(w_DATAREG,w_dataoggi)) {
    alert('Data Registrazione inferiore alla Data di Sistema')
  }
}
if (DateDiff(w_DATAOPE,w_DATAREG) > 30) {
  alert('La differenza tra Data Operazione e Data Registrazione non deve superare i 30gg')
}

if(w_TIPOOPRAP=='26' && m_cFunction=='new') {
  if (confirm('Vuoi creare la chiusura dei delegati e degli eventuali titolari effettivi?')) {
    Set_closeall('S')
  }  
}  
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('AVHTGZTOSZ_ZOOM',lc)) {
return 0;
}
if (Eq('AVHTGZTOSZ',lc)) {
return 0;
}
if (Eq('UMFEJVRUFZ_ZOOM',lc)) {
return 1;
}
if (Eq('UMFEJVRUFZ',lc)) {
return 1;
}
if (Eq('YLIKFVPZJA_ZOOM',lc)) {
return 2;
}
if (Eq('OEIKQOZMYJ_ZOOM',lc)) {
return 2;
}
if (Eq('SLTZSUMACW_ZOOM',lc)) {
return 2;
}
if (Eq('SLTZSUMACW',lc)) {
return 2;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_AVHTGZTOSZ();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,1)) {
l_oWv=LOpt_UMFEJVRUFZ();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,2)) {
l_oWv=LOpt_SLTZSUMACW();
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
l_oWv.setValue('CDATOPE',WtA(w_CDATOPE,'C'));
l_oWv.setValue('CDATREG',WtA(w_CDATREG,'C'));
l_oWv.setValue('CODINTER',WtA(w_CODINTER,'C'));
l_oWv.setValue('CODDIPE',WtA(w_CODDIPE,'C'));
l_oWv.setValue('RAPPORTO',WtA(w_RAPPORTO,'C'));
l_oWv.setValue('DATAOPE',WtA(w_DATAOPE,'D'));
l_oWv.setValue('DATAREG',WtA(w_DATAREG,'D'));
l_oWv.setValue('TIPOOPRAP',WtA(w_TIPOOPRAP,'C'));
l_oWv.setValue('CONNESOPER',WtA(w_CONNESOPER,'C'));
l_oWv.setValue('TIPOLEG',WtA(w_TIPOLEG,'C'));
l_oWv.setValue('IDBASE',WtA(w_IDBASE,'C'));
l_oWv.setValue('op_IDBASE',WtA(op_IDBASE,'C'));
l_oWv.setValue('TIPOINTER',WtA(w_TIPOINTER,'C'));
l_oWv.setValue('TIPOINF',WtA(w_TIPOINF,'C'));
l_oWv.setValue('IDEREG',WtA(w_IDEREG,'C'));
l_oWv.setValue('FLAGRAP',WtA(w_FLAGRAP,'C'));
l_oWv.setValue('OPRAP',WtA(w_OPRAP,'C'));
l_oWv.setValue('OPERATORE',WtA(w_OPERATORE,'C'));
l_oWv.setValue('AUTOM',WtA(w_AUTOM,'C'));
l_oWv.setValue('DESCCIT',WtA(w_DESCCIT,'C'));
l_oWv.setValue('PROVINCIA',WtA(w_PROVINCIA,'C'));
l_oWv.setValue('CODCAB',WtA(w_CODCAB,'C'));
l_oWv.setValue('NUMPROG',WtA(w_NUMPROG,'C'));
l_oWv.setValue('op_NUMPROG',WtA(op_NUMPROG,'C'));
l_oWv.setValue('FLAGRAP2',WtA(w_FLAGRAP2,'C'));
l_oWv.setValue('FLAGLIRE',WtA(w_FLAGLIRE,'C'));
l_oWv.setValue('PRGIMPINF',WtA(w_PRGIMPINF,'N'));
l_oWv.setValue('op_PRGIMPINF',WtA(op_PRGIMPINF,'N'));
l_oWv.setValue('OPERAZMOD',WtA(w_OPERAZMOD,'C'));
l_oWv.setValue('IDBASE2',WtA(w_IDBASE2,'C'));
l_oWv.setValue('DATARETT',WtA(w_DATARETT,'D'));
l_oWv.setValue('STATOREG',WtA(w_STATOREG,'C'));
l_oWv.setValue('FLAGTIT',WtA(w_FLAGTIT,'N'));
l_oWv.setValue('gIntemediario',WtA(w_gIntemediario,'C'));
l_oWv.setValue('gSblocco',WtA(w_gSblocco,'C'));
l_oWv.setValue('gFlgDTP',WtA(w_gFlgDTP,'N'));
l_oWv.setValue('gChkDate',WtA(w_gChkDate,'C'));
l_oWv.setValue('gStatus',WtA(w_gStatus,'C'));
l_oWv.setValue('gDataVaria',WtA(w_gDataVaria,'D'));
l_oWv.setValue('gCodDip',WtA(w_gCodDip,'C'));
l_oWv.setValue('filtro',WtA(w_filtro,'C'));
l_oWv.setValue('dataoggi',WtA(w_dataoggi,'D'));
l_oWv.setValue('tipreg',WtA(w_tipreg,'C'));
l_oWv.setValue('tipregn',WtA(w_tipregn,'N'));
l_oWv.setValue('sEdit',WtA(w_sEdit,'N'));
l_oWv.setValue('xdescrap',WtA(w_xdescrap,'C'));
l_oWv.setValue('xDescDipe',WtA(w_xDescDipe,'C'));
l_oWv.setValue('datpaseuro',WtA(w_datpaseuro,'D'));
l_oWv.setValue('xDesReg',WtA(w_xDesReg,'C'));
l_oWv.setValue('xRagSoc',WtA(w_xRagSoc,'C'));
l_oWv.setValue('errmsg',WtA(w_errmsg,'C'));
l_oWv.setValue('Aggiorna',WtA(w_Aggiorna,'C'));
l_oWv.setValue('lancio',WtA(w_lancio,'N'));
l_oWv.setValue('VALUTA',WtA(w_VALUTA,'C'));
l_oWv.setValue('CITINT',WtA(w_CITINT,'C'));
l_oWv.setValue('CITDIP',WtA(w_CITDIP,'C'));
l_oWv.setValue('PROVDIP',WtA(w_PROVDIP,'C'));
l_oWv.setValue('CABDIP',WtA(w_CABDIP,'C'));
l_oWv.setValue('PROVINT',WtA(w_PROVINT,'C'));
l_oWv.setValue('CABINT',WtA(w_CABINT,'C'));
l_oWv.setValue('inutile',WtA(w_inutile,'N'));
l_oWv.setValue('prova',WtA(w_prova,'C'));
l_oWv.setValue('closeall',WtA(w_closeall,'C'));
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
_FillChildren.n=['ardt_informazioni','ardt_delegabo','ardt_soginfo','ardt_fiduciabo','ardt_terzistirap'];
FillWv.n=["CDATOPE","CDATREG","CODINTER","CODDIPE","RAPPORTO","DATAOPE","DATAREG","TIPOOPRAP","CONNESOPER","TIPOLEG","IDBASE","TIPOINTER","TIPOINF","IDEREG","FLAGRAP","OPRAP","OPERATORE","AUTOM","DESCCIT","PROVINCIA","CODCAB","NUMPROG","FLAGRAP2","FLAGLIRE","PRGIMPINF","OPERAZMOD","IDBASE2","DATARETT","STATOREG","FLAGTIT","gIntemediario","gSblocco","gFlgDTP","gChkDate","gStatus","gDataVaria","gCodDip","filtro","dataoggi","tipreg","tipregn","sEdit","xdescrap","xDescDipe","datpaseuro","xDesReg","xRagSoc","errmsg","Aggiorna","lancio","VALUTA","CITINT","CITDIP","PROVDIP","CABDIP","PROVINT","CABINT","inutile","prova","closeall"];
function SetModified() {
m_bUpdated=true;
}
function SetChildVariables_ardt_informazioni() {
if ( ! (ChildToLoad(FrameRef('ardt_informazioni'))) && Ne(typeof(FrameRef('ardt_informazioni').DoUpdate),'undefined')) {
if (Ne(typeof(FrameRef('ardt_informazioni').m_oTrs),'undefined')) {
FrameRef('ardt_informazioni').EnableEntity(false);
}
CopyWorkVar(FrameRef('ardt_informazioni'),['TIPORAP'],['FLAGRAP'],false)
if (Ne(typeof(FrameRef('ardt_informazioni').m_oTrs),'undefined')) {
l_bEnabled= ! (Eq(At(w_TIPOOPRAP,'|25|28|39|40|41|47'),0) &&  ! (Empty(w_TIPOOPRAP))) || IsDisabledByStateDriver('Informazioni');
if ( ! (ChildToLoad(FrameRef('ardt_informazioni'))) && Ne(typeof(FrameRef('ardt_informazioni').EnableEntity),'undefined')) {
FrameRef('ardt_informazioni').EnableEntity(l_bEnabled);
}
}
}
}
function CtxLoad_ardt_informazioni() {
if (ChildToLoad(FrameRef('ardt_informazioni'))) {
return [LoadContext(0,'ZFLICMSKTV'),'ardt_informazioni'];
}
}
function SetChildVariables_ardt_delegabo() {
if ( ! (ChildToLoad(FrameRef('ardt_delegabo'))) && Ne(typeof(FrameRef('ardt_delegabo').DoUpdate),'undefined')) {
if (Ne(typeof(FrameRef('ardt_delegabo').m_oTrs),'undefined')) {
FrameRef('ardt_delegabo').EnableEntity(false);
}
CopyWorkVar(FrameRef('ardt_delegabo'),['TIPORAP'],['FLAGRAP'],false)
if (Ne(typeof(FrameRef('ardt_delegabo').m_oTrs),'undefined')) {
l_bEnabled= ! (Gt(At(w_TIPOOPRAP,'|25|28|39|40|41|47'),0) &&  ! (Empty(w_TIPOOPRAP))) || IsDisabledByStateDriver('Deleghe');
if ( ! (ChildToLoad(FrameRef('ardt_delegabo'))) && Ne(typeof(FrameRef('ardt_delegabo').EnableEntity),'undefined')) {
FrameRef('ardt_delegabo').EnableEntity(l_bEnabled);
}
}
}
}
function CtxLoad_ardt_delegabo() {
if (ChildToLoad(FrameRef('ardt_delegabo'))) {
return [LoadContext(0,'RSWMQMMVEI'),'ardt_delegabo'];
}
}
function SetChildVariables_ardt_soginfo() {
}
function CtxLoad_ardt_soginfo() {
if (ChildToLoad(FrameRef('ardt_soginfo'))) {
return [LoadContext(0,'IXHEMDOSUG'),'ardt_soginfo'];
}
}
function SetChildVariables_ardt_fiduciabo() {
}
function CtxLoad_ardt_fiduciabo() {
if (ChildToLoad(FrameRef('ardt_fiduciabo'))) {
return [LoadContext(0,'BZLPIJZENB'),'ardt_fiduciabo'];
}
}
function SetChildVariables_ardt_terzistirap() {
}
function CtxLoad_ardt_terzistirap() {
if (ChildToLoad(FrameRef('ardt_terzistirap'))) {
return [LoadContext(0,'NOKYMTFBFL'),'ardt_terzistirap'];
}
}
