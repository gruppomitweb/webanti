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
if (IsDisabledByStateDriver('Categorie')) {
DisableInputsInContainer(Ctrl('RFAIYHSGII'),true);
}
if (IsDisabledByStateDriver('SocRev')) {
DisableInputsInContainer(Ctrl('YFAFHIMHLC'),true);
}
LibJavascript.forEachItem(m_FoundlingEditExpression,i_body_0)
function i_body_0(child){
child();
}
DisableUI();
if (inherit && IsWndAccessible(m_oFather) &&  ! (m_oFather.m_bCalculating)) {
m_oFather.EnableControlsUnderCondition();
}
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
function Set_CONALTO(ctrlValue,kmode,e) {
if (Ne(w_CONALTO,ctrlValue)) {
var ctl = _GetCtl(e,'XFXZVUBUON');
if (_tracker.goon(ctl,ctrlValue)) {
w_CONALTO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XFXZVUBUON',0);
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
function Set_EMAIL(ctrlValue,kmode,e) {
if (Ne(w_EMAIL,ctrlValue)) {
var ctl = _GetCtl(e,'DBFIZRPONS');
if (_tracker.goon(ctl,ctrlValue)) {
w_EMAIL=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('DBFIZRPONS',0);
l_bResult=l_bResult && _ChkObl('CJLHZBPFZE',0);
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
function Set_FLGEMAIL(ctrlValue,kmode,e) {
if (Ne(w_FLGEMAIL,ctrlValue)) {
var ctl = _GetCtl(e,'JYNIHKHNSF');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLGEMAIL=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('JYNIHKHNSF',0);
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
function Set_TELEFONO(ctrlValue,kmode,e) {
if (Ne(w_TELEFONO,ctrlValue)) {
var ctl = _GetCtl(e,'TZSFXOGJGG');
if (_tracker.goon(ctl,ctrlValue)) {
w_TELEFONO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('TZSFXOGJGG',0);
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
function Set_FLGVALIDO(ctrlValue,kmode,e) {
if (Ne(w_FLGVALIDO,ctrlValue)) {
var ctl = _GetCtl(e,'LMZAVCTIKT');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLGVALIDO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('LMZAVCTIKT',0);
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
function Set_FLGANAVAL(ctrlValue,kmode,e) {
if (Ne(w_FLGANAVAL,ctrlValue)) {
var ctl = _GetCtl(e,'HAONGEKSUB');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLGANAVAL=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HAONGEKSUB',0);
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
function Set_CLOCCUPA(ctrlValue,kmode,e) {
if (Ne(w_CLOCCUPA,ctrlValue)) {
var ctl = _GetCtl(e,'FYSLTMPLOV');
if (_tracker.goon(ctl,ctrlValue)) {
w_CLOCCUPA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FYSLTMPLOV',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','N',3,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_NAZIONE(ctrlValue,kmode,e) {
if (Ne(w_NAZIONE,ctrlValue)) {
var ctl = _GetCtl(e,'BGFCAXGJBL');
if (_tracker.goon(ctl,ctrlValue)) {
w_NAZIONE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BGFCAXGJBL',0);
if (l_bResult) {
l_bResult=Link_BGFCAXGJBL(kmode);
if ( ! (l_bResult)) {
w_NAZIONE=HtW('','C');
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
function Set_PEC(ctrlValue,kmode,e) {
if (Ne(w_PEC,ctrlValue)) {
var ctl = _GetCtl(e,'PYRPYRCHAE');
if (_tracker.goon(ctl,ctrlValue)) {
w_PEC=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('PYRPYRCHAE',0);
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
function Set_CLPRVDOM(ctrlValue,kmode,e) {
if (Ne(w_CLPRVDOM,ctrlValue)) {
var ctl = _GetCtl(e,'NIRLEZVFLW');
if (_tracker.goon(ctl,ctrlValue)) {
w_CLPRVDOM=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NIRLEZVFLW',0);
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
function Set_REGRES(ctrlValue,kmode,e) {
if (Ne(w_REGRES,ctrlValue)) {
var ctl = _GetCtl(e,'CBYSBUCJMV');
if (_tracker.goon(ctl,ctrlValue)) {
w_REGRES=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CBYSBUCJMV',0);
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
function Set_FLGBL(ctrlValue,kmode,e) {
if (Ne(w_FLGBL,ctrlValue)) {
var ctl = _GetCtl(e,'URHHMCUEEA');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLGBL=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('URHHMCUEEA',0);
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
function Set_CATEG01(ctrlValue,kmode,e) {
if (Ne(w_CATEG01,ctrlValue)) {
var ctl = _GetCtl(e,'CANUTVNGFD');
if (_tracker.goon(ctl,ctrlValue)) {
w_CATEG01=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CANUTVNGFD',0);
if (l_bResult) {
l_bResult=Link_CANUTVNGFD(kmode);
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
function Set_CATEG02(ctrlValue,kmode,e) {
if (Ne(w_CATEG02,ctrlValue)) {
var ctl = _GetCtl(e,'IXGRJLAKIQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_CATEG02=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('IXGRJLAKIQ',0);
if (l_bResult) {
l_bResult=Link_IXGRJLAKIQ(kmode);
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
function Set_CATEG03(ctrlValue,kmode,e) {
if (Ne(w_CATEG03,ctrlValue)) {
var ctl = _GetCtl(e,'NKIXCWZJHO');
if (_tracker.goon(ctl,ctrlValue)) {
w_CATEG03=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NKIXCWZJHO',0);
if (l_bResult) {
l_bResult=Link_NKIXCWZJHO(kmode);
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
function Set_FLGTRUST(ctrlValue,kmode,e) {
if (Ne(w_FLGTRUST,ctrlValue)) {
var ctl = _GetCtl(e,'AIXHBUOLOH');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLGTRUST=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('AIXHBUOLOH',0);
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
function Set_APPALTO(ctrlValue,kmode,e) {
if (Ne(w_APPALTO,ctrlValue)) {
var ctl = _GetCtl(e,'GYAJLZIGMO');
if (_tracker.goon(ctl,ctrlValue)) {
w_APPALTO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('GYAJLZIGMO',0);
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
function Set_FLGRISCHIO(ctrlValue,kmode,e) {
if (Ne(w_FLGRISCHIO,ctrlValue)) {
var ctl = _GetCtl(e,'RJATPPKQJX');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLGRISCHIO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RJATPPKQJX',0);
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
function Set_REFERENTE(ctrlValue,kmode,e) {
if (Ne(w_REFERENTE,ctrlValue)) {
var ctl = _GetCtl(e,'DRSQJFIQWH');
if (_tracker.goon(ctl,ctrlValue)) {
w_REFERENTE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('DRSQJFIQWH',0);
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
function Set_FLGFALSADIC(ctrlValue,kmode,e) {
if (Ne(w_FLGFALSADIC,ctrlValue)) {
var ctl = _GetCtl(e,'BFAZVGKRMM');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLGFALSADIC=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BFAZVGKRMM',0);
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
function Set_FLGPREGIUD(ctrlValue,kmode,e) {
if (Ne(w_FLGPREGIUD,ctrlValue)) {
var ctl = _GetCtl(e,'SEUBTYJEKC');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLGPREGIUD=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SEUBTYJEKC',0);
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
function Set_FLGEQUIFIN(ctrlValue,kmode,e) {
if (Ne(w_FLGEQUIFIN,ctrlValue)) {
var ctl = _GetCtl(e,'TYXOFHIXSZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLGEQUIFIN=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('TYXOFHIXSZ',0);
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
function Set_FLGRICINF(ctrlValue,kmode,e) {
if (Ne(w_FLGRICINF,ctrlValue)) {
var ctl = _GetCtl(e,'ONGFHKWFDC');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLGRICINF=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ONGFHKWFDC',0);
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
function Set_NUMCEL(ctrlValue,kmode,e) {
if (Ne(w_NUMCEL,ctrlValue)) {
var ctl = _GetCtl(e,'HHZVXHZWFT');
if (_tracker.goon(ctl,ctrlValue)) {
w_NUMCEL=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HHZVXHZWFT',0);
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
function Calculate() {
var l_bTmpRes;
var l_bResult = true;
m_bCalculating=true;
w_CATEGORIA=fwfn_calc_categoria(w_CATEG01,w_CATEG02,w_CATEG03,w_CATEG04,w_CATEG05);
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
function Link_BGFCAXGJBL(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_NAZIONE);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODSTA',w_NAZIONE,3,0);
l_Appl.SetFields('CODSTA,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbstati');
l_Appl.SetID('BGFCAXGJBL');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_NAZIONE=l_Appl.GetStringValue('CODSTA',3,0);
w_xDesNaz=l_Appl.GetStringValue('DESCRI',40,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_BGFCAXGJBL_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_BGFCAXGJBL';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_BGFCAXGJBL();
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
function Link_BGFCAXGJBL_Blank() {
w_NAZIONE='';
w_xDesNaz='';
}
function LOpt_BGFCAXGJBL() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstati','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODSTA','C'));
l_oWv.setValue('LinkedField',WtA('CODSTA','C'));
l_oWv.setValue('UID',WtA('BGFCAXGJBL','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['BGFCAXGJBL'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('7383187'),'C'));
return l_oWv;
}
function Link_CANUTVNGFD(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CATEG01);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('C1CODICE',w_CATEG01,2,0);
l_Appl.SetFields('C1CODICE,C1DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbcateg01');
l_Appl.SetLinkzoom('opemt_tbcateg01');
l_Appl.SetID('CANUTVNGFD');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CATEG01=l_Appl.GetStringValue('C1CODICE',2,0);
w_xC1DESCRI=l_Appl.GetStringValue('C1DESCRI',80,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_CANUTVNGFD_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_CANUTVNGFD';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
l_cFieldFilter=l_cFieldFilter+l_cAndOpForField+_flt_('C1CODTAB','P',null,true,'=');
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_CANUTVNGFD();
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
function Link_CANUTVNGFD_Blank() {
w_CATEG01='';
w_xC1DESCRI='';
}
function LOpt_CANUTVNGFD() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcateg01','C'));
l_oWv.setValue('Linkzoomprg',WtA('opemt_tbcateg01','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('C1CODICE','C'));
l_oWv.setValue('LinkedField',WtA('C1CODICE','C'));
l_oWv.setValue('UID',WtA('CANUTVNGFD','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['CANUTVNGFD'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('157154740'),'C'));
return l_oWv;
}
function Link_IXGRJLAKIQ(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CATEG02);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('C2CODICE',w_CATEG02,2,0);
l_Appl.SetFields('C2CODICE,C2DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbcateg02');
l_Appl.SetLinkzoom('opemt_tbcateg02');
l_Appl.SetID('IXGRJLAKIQ');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CATEG02=l_Appl.GetStringValue('C2CODICE',2,0);
w_xC2DESCRI=l_Appl.GetStringValue('C2DESCRI',80,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_IXGRJLAKIQ_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_IXGRJLAKIQ';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
l_cFieldFilter=l_cFieldFilter+l_cAndOpForField+_flt_('C2CODTAB','P',null,true,'=');
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_IXGRJLAKIQ();
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
function Link_IXGRJLAKIQ_Blank() {
w_CATEG02='';
w_xC2DESCRI='';
}
function LOpt_IXGRJLAKIQ() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcateg02','C'));
l_oWv.setValue('Linkzoomprg',WtA('opemt_tbcateg02','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('C2CODICE','C'));
l_oWv.setValue('LinkedField',WtA('C2CODICE','C'));
l_oWv.setValue('UID',WtA('IXGRJLAKIQ','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['IXGRJLAKIQ'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('157154996'),'C'));
return l_oWv;
}
function Link_NKIXCWZJHO(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CATEG03);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('C3CODICE',w_CATEG03,2,0);
l_Appl.SetFields('C3CODICE,C3DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbcateg03');
l_Appl.SetLinkzoom('opemt_tbcateg03');
l_Appl.SetID('NKIXCWZJHO');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CATEG03=l_Appl.GetStringValue('C3CODICE',2,0);
w_xC3DESCRI=l_Appl.GetStringValue('C3DESCRI',80,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_NKIXCWZJHO_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_NKIXCWZJHO';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
l_cFieldFilter=l_cFieldFilter+l_cAndOpForField+_flt_('C3CODTAB','P',null,true,'=');
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_NKIXCWZJHO();
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
function Link_NKIXCWZJHO_Blank() {
w_CATEG03='';
w_xC3DESCRI='';
}
function LOpt_NKIXCWZJHO() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcateg03','C'));
l_oWv.setValue('Linkzoomprg',WtA('opemt_tbcateg03','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('C3CODICE','C'));
l_oWv.setValue('LinkedField',WtA('C3CODICE','C'));
l_oWv.setValue('UID',WtA('NKIXCWZJHO','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['NKIXCWZJHO'][1],'C'));
return l_oWv;
}
function Link_JQLGHMLOKO(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CATEG04);
var l_Appl = LinkApplet();
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
l_cFieldFilter=l_cFieldFilter+l_cAndOpForField+_flt_('C4CODTAB','P',null,true,'=');
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
l_oWv.setValue('PKFields',WtA('C4CODICE','C'));
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
l_cFieldFilter=l_cFieldFilter+l_cAndOpForField+_flt_('C5CODTAB','P',null,true,'=');
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
l_oWv.setValue('PKFields',WtA('C5CODICE','C'));
l_oWv.setValue('LinkedField',WtA('C5CODICE','C'));
l_oWv.setValue('UID',WtA('QVBZSFMTVP','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['QVBZSFMTVP'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('157155764'),'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'BGFCAXGJBL')) {
last_focused_comp=GetLastFocusedElementOfLink('BGFCAXGJBL');
function SetMethod_BGFCAXGJBL() {
Set_NAZIONE(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_BGFCAXGJBL();
} else {
setTimeout(SetMethod_BGFCAXGJBL,1);
}
bResult=true;
}
if (Eq(varName,'CANUTVNGFD')) {
last_focused_comp=GetLastFocusedElementOfLink('CANUTVNGFD');
function SetMethod_CANUTVNGFD() {
Set_CATEG01(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_CANUTVNGFD();
} else {
setTimeout(SetMethod_CANUTVNGFD,1);
}
bResult=true;
}
if (Eq(varName,'IXGRJLAKIQ')) {
last_focused_comp=GetLastFocusedElementOfLink('IXGRJLAKIQ');
function SetMethod_IXGRJLAKIQ() {
Set_CATEG02(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_IXGRJLAKIQ();
} else {
setTimeout(SetMethod_IXGRJLAKIQ,1);
}
bResult=true;
}
if (Eq(varName,'NKIXCWZJHO')) {
last_focused_comp=GetLastFocusedElementOfLink('NKIXCWZJHO');
function SetMethod_NKIXCWZJHO() {
Set_CATEG03(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_NKIXCWZJHO();
} else {
setTimeout(SetMethod_NKIXCWZJHO,1);
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
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'BGFCAXGJBL')) {
return [Ctrl('BGFCAXGJBL')];
}
if (Eq(varName,'CANUTVNGFD')) {
return [Ctrl('CANUTVNGFD')];
}
if (Eq(varName,'IXGRJLAKIQ')) {
return [Ctrl('IXGRJLAKIQ')];
}
if (Eq(varName,'NKIXCWZJHO')) {
return [Ctrl('NKIXCWZJHO')];
}
if (Eq(varName,'JQLGHMLOKO')) {
return [Ctrl('JQLGHMLOKO')];
}
if (Eq(varName,'QVBZSFMTVP')) {
return [Ctrl('QVBZSFMTVP')];
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
if ( ! (Check())) {
DisplayErrorMessage();
return;
}
if ( ! (m_oFather.SaveContext_armt_wersonbo_agg())) {
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
parent.ZtVWeb.raiseEventToEvalParms('armt_wersonbo_agg_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('armt_wersonbo_agg_dataNotSent',{'action':formaction});
}
}
}
}
}
CheckChild.child=[];
function Check() {
var l_bResult = true;
ResetErrorVars();
m_nLastError=0;
if ( ! (_ChkObl('DBFIZRPONS',1))) {
_SignErr('DBFIZRPONS');
m_cLastWorkVarErrorMsg='5297685';
l_bResult=false;
w_EMAIL=HtW('','C');
} else if ( ! (_ChkObl('JYNIHKHNSF',1))) {
_SignErr('JYNIHKHNSF');
m_cLastWorkVarErrorMsg='1635179791';
l_bResult=false;
w_FLGEMAIL='N';
} else if ( ! (_ChkObl('TZSFXOGJGG',1))) {
_SignErr('TZSFXOGJGG');
m_cLastWorkVarErrorMsg='1700577956';
l_bResult=false;
w_TELEFONO=HtW('','C');
} else if ( ! (_ChkObl('LMZAVCTIKT',1))) {
_SignErr('LMZAVCTIKT');
m_cLastWorkVarErrorMsg='12078005779';
l_bResult=false;
w_FLGVALIDO='N';
} else if ( ! (_ChkObl('HAONGEKSUB',1))) {
_SignErr('HAONGEKSUB');
m_cLastWorkVarErrorMsg='10061745855';
l_bResult=false;
w_FLGANAVAL='N';
} else if ( ! (_ChkObl('FYSLTMPLOV',1))) {
_SignErr('FYSLTMPLOV');
m_cLastWorkVarErrorMsg='277358030';
l_bResult=false;
w_CLOCCUPA=HtW('','N');
} else if ( ! (_ChkObl('BGFCAXGJBL',1))) {
_SignErr('BGFCAXGJBL');
m_cLastWorkVarErrorMsg='676788231';
l_bResult=false;
w_NAZIONE=HtW('','C');
} else if ( ! (_ChkObl('NIRLEZVFLW',1))) {
_SignErr('NIRLEZVFLW');
m_cLastWorkVarErrorMsg='10195722547';
l_bResult=false;
w_CLPRVDOM=HtW('','C');
} else if ( ! (_ChkObl('CBYSBUCJMV',1))) {
_SignErr('CBYSBUCJMV');
m_cLastWorkVarErrorMsg='12129590363';
l_bResult=false;
w_REGRES=HtW('','C');
} else if ( ! (_ChkObl('URHHMCUEEA',1))) {
_SignErr('URHHMCUEEA');
m_cLastWorkVarErrorMsg='11640916362';
l_bResult=false;
w_FLGBL='N';
} else if ( ! (_ChkObl('CANUTVNGFD',1))) {
_SignErr('CANUTVNGFD');
m_cLastWorkVarErrorMsg='157154740';
l_bResult=false;
w_CATEG01=HtW('','C');
} else if ( ! (_ChkObl('IXGRJLAKIQ',1))) {
_SignErr('IXGRJLAKIQ');
m_cLastWorkVarErrorMsg='157154996';
l_bResult=false;
w_CATEG02=HtW('','C');
} else if ( ! (_ChkObl('NKIXCWZJHO',1))) {
_SignErr('NKIXCWZJHO');
m_cLastWorkVarErrorMsg='157155252';
l_bResult=false;
w_CATEG03=HtW('','C');
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
} else if ( ! (_ChkObl('SEUBTYJEKC',1))) {
_SignErr('SEUBTYJEKC');
m_cLastWorkVarErrorMsg='1744218234';
l_bResult=false;
w_FLGPREGIUD='N';
} else if ( ! (_ChkObl('AIXHBUOLOH',1))) {
_SignErr('AIXHBUOLOH');
m_cLastWorkVarErrorMsg='8105076';
l_bResult=false;
w_FLGTRUST='N';
} else if ( ! (_ChkObl('RJATPPKQJX',1))) {
_SignErr('RJATPPKQJX');
m_cLastWorkVarErrorMsg='10964299298';
l_bResult=false;
w_FLGRISCHIO='N';
} else if ( ! (_ChkObl('BFAZVGKRMM',1))) {
_SignErr('BFAZVGKRMM');
m_cLastWorkVarErrorMsg='116493960';
l_bResult=false;
w_FLGFALSADIC='N';
} else if ( ! (_ChkObl('TYXOFHIXSZ',1))) {
_SignErr('TYXOFHIXSZ');
m_cLastWorkVarErrorMsg='10659481672';
l_bResult=false;
w_FLGEQUIFIN='N';
} else if ( ! (_ChkObl('ONGFHKWFDC',1))) {
_SignErr('ONGFHKWFDC');
m_cLastWorkVarErrorMsg='695992708';
l_bResult=false;
w_FLGRICINF='N';
} else if ( ! (_ChkObl('HHZVXHZWFT',1))) {
_SignErr('HHZVXHZWFT');
m_cLastWorkVarErrorMsg='12009320712';
l_bResult=false;
w_NUMCEL=HtW('','C');
} else if ( ! (_ChkObl('CJLHZBPFZE',1))) {
_SignErr('CJLHZBPFZE');
m_cLastWorkVarErrorMsg='5297685';
l_bResult=false;
w_EMAIL=HtW('','M');
} else if ( ! (_ChkObl('PYRPYRCHAE',1))) {
_SignErr('PYRPYRCHAE');
m_cLastWorkVarErrorMsg='18336';
l_bResult=false;
w_PEC=HtW('','C');
} else if ( ! (_ChkObl('DRSQJFIQWH',1))) {
_SignErr('DRSQJFIQWH');
m_cLastWorkVarErrorMsg='11261912825';
l_bResult=false;
w_REFERENTE=HtW('','C');
} else if ( ! (_ChkObl('XFXZVUBUON',1))) {
_SignErr('XFXZVUBUON');
m_cLastWorkVarErrorMsg='10021363378';
l_bResult=false;
w_CONALTO=0;
} else if ( ! (_ChkObl('GYAJLZIGMO',1))) {
_SignErr('GYAJLZIGMO');
m_cLastWorkVarErrorMsg='10354796574';
l_bResult=false;
w_APPALTO=0;
}
if (l_bResult) {
l_bResult=CheckChild(0);
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('BGFCAXGJBL_ZOOM',lc)) {
return 0;
}
if (Eq('BGFCAXGJBL',lc)) {
return 0;
}
if (Eq('CANUTVNGFD_ZOOM',lc)) {
return 1;
}
if (Eq('CANUTVNGFD',lc)) {
return 1;
}
if (Eq('IXGRJLAKIQ_ZOOM',lc)) {
return 2;
}
if (Eq('IXGRJLAKIQ',lc)) {
return 2;
}
if (Eq('NKIXCWZJHO_ZOOM',lc)) {
return 3;
}
if (Eq('NKIXCWZJHO',lc)) {
return 3;
}
if (Eq('JQLGHMLOKO_ZOOM',lc)) {
return 4;
}
if (Eq('JQLGHMLOKO',lc)) {
return 4;
}
if (Eq('QVBZSFMTVP_ZOOM',lc)) {
return 5;
}
if (Eq('QVBZSFMTVP',lc)) {
return 5;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_BGFCAXGJBL();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,1)) {
l_oWv=LOpt_CANUTVNGFD();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
l_cFieldFilter=l_cFieldFilter+l_cAndOpForField+_flt_('C1CODTAB','P',null,true,'=');
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
l_oWv.setValue('FieldFilter',l_cFieldFilter);
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,2)) {
l_oWv=LOpt_IXGRJLAKIQ();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
l_cFieldFilter=l_cFieldFilter+l_cAndOpForField+_flt_('C2CODTAB','P',null,true,'=');
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
l_oWv.setValue('FieldFilter',l_cFieldFilter);
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,3)) {
l_oWv=LOpt_NKIXCWZJHO();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
l_cFieldFilter=l_cFieldFilter+l_cAndOpForField+_flt_('C3CODTAB','P',null,true,'=');
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
l_oWv.setValue('FieldFilter',l_cFieldFilter);
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,4)) {
l_oWv=LOpt_JQLGHMLOKO();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
l_cFieldFilter=l_cFieldFilter+l_cAndOpForField+_flt_('C4CODTAB','P',null,true,'=');
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
l_oWv.setValue('FieldFilter',l_cFieldFilter);
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,5)) {
l_oWv=LOpt_QVBZSFMTVP();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
l_cFieldFilter=l_cFieldFilter+l_cAndOpForField+_flt_('C5CODTAB','P',null,true,'=');
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
l_oWv.setValue('CONNES',WtA(w_CONNES,'C'));
l_oWv.setValue('EMAIL',WtA(w_EMAIL,'C'));
l_oWv.setValue('FLGEMAIL',WtA(w_FLGEMAIL,'C'));
l_oWv.setValue('TELEFONO',WtA(w_TELEFONO,'C'));
l_oWv.setValue('FLGVALIDO',WtA(w_FLGVALIDO,'C'));
l_oWv.setValue('FLGANAVAL',WtA(w_FLGANAVAL,'C'));
l_oWv.setValue('CLOCCUPA',WtA(w_CLOCCUPA,'N'));
l_oWv.setValue('NAZIONE',WtA(w_NAZIONE,'C'));
l_oWv.setValue('CLPRVDOM',WtA(w_CLPRVDOM,'C'));
l_oWv.setValue('REGRES',WtA(w_REGRES,'C'));
l_oWv.setValue('FLGBL',WtA(w_FLGBL,'C'));
l_oWv.setValue('CATEG01',WtA(w_CATEG01,'C'));
l_oWv.setValue('CATEG02',WtA(w_CATEG02,'C'));
l_oWv.setValue('CATEG03',WtA(w_CATEG03,'C'));
l_oWv.setValue('CATEG04',WtA(w_CATEG04,'C'));
l_oWv.setValue('CATEG05',WtA(w_CATEG05,'C'));
l_oWv.setValue('FLGPREGIUD',WtA(w_FLGPREGIUD,'C'));
l_oWv.setValue('FLGTRUST',WtA(w_FLGTRUST,'C'));
l_oWv.setValue('FLGRISCHIO',WtA(w_FLGRISCHIO,'C'));
l_oWv.setValue('FLGFALSADIC',WtA(w_FLGFALSADIC,'C'));
l_oWv.setValue('FLGEQUIFIN',WtA(w_FLGEQUIFIN,'C'));
l_oWv.setValue('FLGRICINF',WtA(w_FLGRICINF,'C'));
l_oWv.setValue('CATEGORIA',WtA(w_CATEGORIA,'C'));
l_oWv.setValue('NUMCEL',WtA(w_NUMCEL,'C'));
l_oWv.setValue('PEC',WtA(w_PEC,'C'));
l_oWv.setValue('REFERENTE',WtA(w_REFERENTE,'C'));
l_oWv.setValue('CONALTO',WtA(w_CONALTO,'N'));
l_oWv.setValue('APPALTO',WtA(w_APPALTO,'N'));
l_oWv.setValue('sanumpro',WtA(w_sanumpro,'C'));
l_oWv.setValue('gTipInter',WtA(w_gTipInter,'C'));
l_oWv.setValue('xDesNaz',WtA(w_xDesNaz,'C'));
l_oWv.setValue('xC1DESCRI',WtA(w_xC1DESCRI,'C'));
l_oWv.setValue('xC2DESCRI',WtA(w_xC2DESCRI,'C'));
l_oWv.setValue('xC3DESCRI',WtA(w_xC3DESCRI,'C'));
l_oWv.setValue('xC4DESCRI',WtA(w_xC4DESCRI,'C'));
l_oWv.setValue('xC5DESCRI',WtA(w_xC5DESCRI,'C'));
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
FillWv.n=["CONNES","EMAIL","FLGEMAIL","TELEFONO","FLGVALIDO","FLGANAVAL","CLOCCUPA","NAZIONE","CLPRVDOM","REGRES","FLGBL","CATEG01","CATEG02","CATEG03","CATEG04","CATEG05","FLGPREGIUD","FLGTRUST","FLGRISCHIO","FLGFALSADIC","FLGEQUIFIN","FLGRICINF","CATEGORIA","NUMCEL","PEC","REFERENTE","CONALTO","APPALTO","sanumpro","gTipInter","xDesNaz","xC1DESCRI","xC2DESCRI","xC3DESCRI","xC4DESCRI","xC5DESCRI"];
function SetModified() {
m_bUpdated=true;
if (IsWndAccessible(m_oFather)) {
m_oFather.SetModified_armt_wersonbo_agg();
}
}
function EnableEntityWhenReady(enable) {
if (enable) {
var c;
if(c=Ctrl('DBFIZRPONS')) SetDisabled(c,true);
if(c=Ctrl('JYNIHKHNSF')) SetDisabled(c,true);
if(c=Ctrl('TZSFXOGJGG')) SetDisabled(c,true);
if(c=Ctrl('LMZAVCTIKT')) SetDisabled(c,true);
if(c=Ctrl('HAONGEKSUB')) SetDisabled(c,true);
if(c=Ctrl('FYSLTMPLOV')) SetDisabled(c,true);
if(c=Ctrl('BGFCAXGJBL')) SetDisabled(c,true);
if(c=Ctrl('BGFCAXGJBL_ZOOM')) SetDisabled(c,true);
if(c=Ctrl('NIRLEZVFLW')) SetDisabled(c,true);
if(c=Ctrl('CBYSBUCJMV')) SetDisabled(c,true);
if(c=Ctrl('URHHMCUEEA')) SetDisabled(c,true);
if(c=Ctrl('CANUTVNGFD')) SetDisabled(c,true);
if(c=Ctrl('CANUTVNGFD_ZOOM')) SetDisabled(c,true);
if(c=Ctrl('IXGRJLAKIQ')) SetDisabled(c,true);
if(c=Ctrl('IXGRJLAKIQ_ZOOM')) SetDisabled(c,true);
if(c=Ctrl('NKIXCWZJHO')) SetDisabled(c,true);
if(c=Ctrl('NKIXCWZJHO_ZOOM')) SetDisabled(c,true);
if(c=Ctrl('JQLGHMLOKO')) SetDisabled(c,true);
if(c=Ctrl('JQLGHMLOKO_ZOOM')) SetDisabled(c,true);
if(c=Ctrl('QVBZSFMTVP')) SetDisabled(c,true);
if(c=Ctrl('QVBZSFMTVP_ZOOM')) SetDisabled(c,true);
if(c=Ctrl('SEUBTYJEKC')) SetDisabled(c,true);
if(c=Ctrl('AIXHBUOLOH')) SetDisabled(c,true);
if(c=Ctrl('RJATPPKQJX')) SetDisabled(c,true);
if(c=Ctrl('BFAZVGKRMM')) SetDisabled(c,true);
if(c=Ctrl('TYXOFHIXSZ')) SetDisabled(c,true);
if(c=Ctrl('ONGFHKWFDC')) SetDisabled(c,true);
if(c=Ctrl('HHZVXHZWFT')) SetDisabled(c,true);
if(c=Ctrl('CJLHZBPFZE')) SetDisabled(c,true);
if(c=Ctrl('PYRPYRCHAE')) SetDisabled(c,true);
if(c=Ctrl('DRSQJFIQWH')) SetDisabled(c,true);
if(c=Ctrl('XFXZVUBUON')) SetDisabled(c,true);
if(c=Ctrl('GYAJLZIGMO')) SetDisabled(c,true);
} else {
var c;
if(c=Ctrl('DBFIZRPONS')) SetDisabled(c,false);
if(c=Ctrl('JYNIHKHNSF')) SetDisabled(c,false);
if(c=Ctrl('TZSFXOGJGG')) SetDisabled(c,false);
if(c=Ctrl('LMZAVCTIKT')) SetDisabled(c,false);
if(c=Ctrl('HAONGEKSUB')) SetDisabled(c,false);
if(c=Ctrl('FYSLTMPLOV')) SetDisabled(c,false);
if(c=Ctrl('BGFCAXGJBL')) SetDisabled(c,false);
if(c=Ctrl('BGFCAXGJBL_ZOOM')) SetDisabled(c,false);
if(c=Ctrl('NIRLEZVFLW')) SetDisabled(c,false);
if(c=Ctrl('CBYSBUCJMV')) SetDisabled(c,false);
if(c=Ctrl('URHHMCUEEA')) SetDisabled(c,false);
if(c=Ctrl('CANUTVNGFD')) SetDisabled(c,false);
if(c=Ctrl('CANUTVNGFD_ZOOM')) SetDisabled(c,false);
if(c=Ctrl('IXGRJLAKIQ')) SetDisabled(c,false);
if(c=Ctrl('IXGRJLAKIQ_ZOOM')) SetDisabled(c,false);
if(c=Ctrl('NKIXCWZJHO')) SetDisabled(c,false);
if(c=Ctrl('NKIXCWZJHO_ZOOM')) SetDisabled(c,false);
if(c=Ctrl('JQLGHMLOKO')) SetDisabled(c,false);
if(c=Ctrl('JQLGHMLOKO_ZOOM')) SetDisabled(c,false);
if(c=Ctrl('QVBZSFMTVP')) SetDisabled(c,false);
if(c=Ctrl('QVBZSFMTVP_ZOOM')) SetDisabled(c,false);
if(c=Ctrl('SEUBTYJEKC')) SetDisabled(c,false);
if(c=Ctrl('AIXHBUOLOH')) SetDisabled(c,false);
if(c=Ctrl('RJATPPKQJX')) SetDisabled(c,false);
if(c=Ctrl('BFAZVGKRMM')) SetDisabled(c,false);
if(c=Ctrl('TYXOFHIXSZ')) SetDisabled(c,false);
if(c=Ctrl('ONGFHKWFDC')) SetDisabled(c,false);
if(c=Ctrl('HHZVXHZWFT')) SetDisabled(c,false);
if(c=Ctrl('CJLHZBPFZE')) SetDisabled(c,false);
if(c=Ctrl('PYRPYRCHAE')) SetDisabled(c,false);
if(c=Ctrl('DRSQJFIQWH')) SetDisabled(c,false);
if(c=Ctrl('XFXZVUBUON')) SetDisabled(c,false);
if(c=Ctrl('GYAJLZIGMO')) SetDisabled(c,false);
EnableControlsUnderCondition(false);
}
m_bChildDisabled=enable;
}
