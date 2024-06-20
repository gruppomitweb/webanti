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
l_bEnabled= ! (Empty(LRTrim(w_IDCITTANA))) || IsDisabledByStateDriver('NASCOMUN');
SetDisabled('NEUBQNUEOJ',l_bEnabled);
l_bEnabled= ! (false) || Eq(m_cFunction,'edit') || IsDisabledByStateDriver('PRGSOG');
SetDisabled('GIZUBOQEKL',l_bEnabled);
if (IsDisabledByStateDriver('Residenza')) {
DisableInputsInContainer(Ctrl('AQSQVBKXAL'),true);
}
if (IsDisabledByStateDriver('PF')) {
DisableInputsInContainer(Ctrl('EWPTTWSBMT'),true);
}
if (IsDisabledByStateDriver('PFDoc')) {
DisableInputsInContainer(Ctrl('BLAIVNGHMW'),true);
}
if (IsDisabledByStateDriver('Chiave')) {
DisableInputsInContainer(Ctrl('OQFTKYDCIW'),true);
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
}
function SetDynamicClasses() {
var c;
}
function SetDynamicTooltip() {
var c;
}
function Set_COGNOME(ctrlValue,kmode,e) {
if (Ne(w_COGNOME,ctrlValue)) {
var ctl = _GetCtl(e,'TWTTDWKCRG');
if (_tracker.goon(ctl,ctrlValue)) {
w_COGNOME=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('TWTTDWKCRG',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('TWTTDWKCRG',function(){return WtH(w_COGNOME,'C',26,0,'@!')},w_COGNOME);
return l_bResult;
} else {
ctl.value=WtH('','C',26,0,'@!');
_ResetTracker();
return true;
}
}
return true;
}
function Set_NOME(ctrlValue,kmode,e) {
if (Ne(w_NOME,ctrlValue)) {
var ctl = _GetCtl(e,'WWGIVGNUDW');
if (_tracker.goon(ctl,ctrlValue)) {
w_NOME=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('WWGIVGNUDW',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('WWGIVGNUDW',function(){return WtH(w_NOME,'C',25,0,'@!')},w_NOME);
return l_bResult;
} else {
ctl.value=WtH('','C',25,0,'@!');
_ResetTracker();
return true;
}
}
return true;
}
function Set_CFESTERO(ctrlValue,kmode,e) {
if (Ne(w_CFESTERO,ctrlValue)) {
var ctl = _GetCtl(e,'CZTHKEDVCO');
if (_tracker.goon(ctl,ctrlValue)) {
w_CFESTERO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CZTHKEDVCO',0);
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
function Set_PAESE(ctrlValue,kmode,e) {
if (Ne(w_PAESE,ctrlValue)) {
var ctl = _GetCtl(e,'YVIKEGPYPM');
if (_tracker.goon(ctl,ctrlValue)) {
w_PAESE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YVIKEGPYPM',0);
if (l_bResult) {
l_bResult=Link_YVIKEGPYPM(kmode);
if ( ! (l_bResult)) {
w_PAESE=HtW('','C');
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
function Set_DESCCIT(ctrlValue,kmode,e) {
if (Ne(w_DESCCIT,ctrlValue)) {
var ctl = _GetCtl(e,'ODAYKSRECA');
if (_tracker.goon(ctl,ctrlValue)) {
w_DESCCIT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ODAYKSRECA',0);
if (l_bResult) {
l_bResult=Link_ODAYKSRECA(kmode);
if ( ! (l_bResult)) {
w_DESCCIT=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',30,0,'@!'));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',30,0,'@!');
_ResetTracker();
return true;
}
}
return true;
}
function Set_PROVINCIA(ctrlValue,kmode,e) {
if (Ne(w_PROVINCIA,ctrlValue)) {
var ctl = _GetCtl(e,'NOTZPDMYIA');
if (_tracker.goon(ctl,ctrlValue)) {
w_PROVINCIA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NOTZPDMYIA',0);
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
function Set_CAP(ctrlValue,kmode,e) {
if (Ne(w_CAP,ctrlValue)) {
var ctl = _GetCtl(e,'RDAVOEETJG');
if (_tracker.goon(ctl,ctrlValue)) {
w_CAP=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RDAVOEETJG',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',9,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_DOMICILIO(ctrlValue,kmode,e) {
if (Ne(w_DOMICILIO,ctrlValue)) {
var ctl = _GetCtl(e,'VYLHWTRQNX');
if (_tracker.goon(ctl,ctrlValue)) {
w_DOMICILIO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VYLHWTRQNX',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',35,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_IDCITTANA(ctrlValue,kmode,e) {
if (Ne(w_IDCITTANA,ctrlValue)) {
var ctl = _GetCtl(e,'BYPEBFEOAJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_IDCITTANA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BYPEBFEOAJ',0);
if (l_bResult) {
l_bResult=Link_BYPEBFEOAJ(kmode);
if ( ! (l_bResult)) {
w_IDCITTANA=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',40,0,''));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',40,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_NASSTATO(ctrlValue,kmode,e) {
if (Ne(w_NASSTATO,ctrlValue)) {
var ctl = _GetCtl(e,'HODZKKOSYW');
if (_tracker.goon(ctl,ctrlValue)) {
w_NASSTATO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HODZKKOSYW',0);
if (l_bResult) {
l_bResult=Link_HODZKKOSYW(kmode);
if ( ! (l_bResult)) {
w_NASSTATO=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',30,0,'@!'));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',30,0,'@!');
_ResetTracker();
return true;
}
}
return true;
}
function Set_NASCOMUN(ctrlValue,kmode,e) {
if (Ne(w_NASCOMUN,ctrlValue)) {
var ctl = _GetCtl(e,'NEUBQNUEOJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_NASCOMUN=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NEUBQNUEOJ',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('NEUBQNUEOJ',function(){return WtH(w_NASCOMUN,'C',30,0,'@!')},w_NASCOMUN);
return l_bResult;
} else {
ctl.value=WtH('','C',30,0,'@!');
_ResetTracker();
return true;
}
}
return true;
}
function Set_NASPROV(ctrlValue,kmode,e) {
if (Ne(w_NASPROV,ctrlValue)) {
var ctl = _GetCtl(e,'KPSCOABZLB');
if (_tracker.goon(ctl,ctrlValue)) {
w_NASPROV=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('KPSCOABZLB',0);
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
function Set_SESSO(ctrlValue,kmode,e) {
if (Ne(w_SESSO,ctrlValue)) {
var ctl = _GetCtl(e,'QPALJZMFCL');
if (_tracker.goon(ctl,ctrlValue)) {
w_SESSO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QPALJZMFCL',0);
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
function Set_CONNES(ctrlValue,kmode,e) {
if (Ne(w_CONNES,ctrlValue)) {
var ctl = _GetCtl(e,'OJJHIUDPFY');
if (_tracker.goon(ctl,ctrlValue)) {
w_CONNES=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('OJJHIUDPFY',0);
if (l_bResult) {
l_bResult=arfn_chkcodfis(w_CONNES,w_PAESE,w_CFESTERO);
if ( ! (l_bResult)) {
m_nLastError=2;
m_cLastWorkVarErrorMsg='11921223220';
m_cLastMsgError=AlertErrorMessage('10034398626');
}
if ( ! (l_bResult)) {
w_CONNES=HtW('','C');
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
function Set_DATANASC(ctrlValue,kmode,e) {
if (Ne(w_DATANASC,ctrlValue)) {
var ctl = _GetCtl(e,'XMGRWGFSFV');
if (_tracker.goon(ctl,ctrlValue)) {
w_DATANASC=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XMGRWGFSFV',0);
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
function Set_TIPODOC(ctrlValue,kmode,e) {
if (Ne(w_TIPODOC,ctrlValue)) {
var ctl = _GetCtl(e,'MBGANUUHRA');
if (_tracker.goon(ctl,ctrlValue)) {
w_TIPODOC=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MBGANUUHRA',0);
if (l_bResult) {
l_bResult=Link_MBGANUUHRA(kmode);
if ( ! (l_bResult)) {
w_TIPODOC=HtW('','C');
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
function Set_NUMDOCUM(ctrlValue,kmode,e) {
if (Ne(w_NUMDOCUM,ctrlValue)) {
var ctl = _GetCtl(e,'HVEEMUJUUY');
if (_tracker.goon(ctl,ctrlValue)) {
w_NUMDOCUM=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HVEEMUJUUY',0);
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
function Set_DATARILASC(ctrlValue,kmode,e) {
if (Ne(w_DATARILASC,ctrlValue)) {
var ctl = _GetCtl(e,'XHWYGOPPUN');
if (_tracker.goon(ctl,ctrlValue)) {
w_DATARILASC=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XHWYGOPPUN',0);
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
function Set_DATAVALI(ctrlValue,kmode,e) {
if (Ne(w_DATAVALI,ctrlValue)) {
var ctl = _GetCtl(e,'BNWXBPSIDG');
if (_tracker.goon(ctl,ctrlValue)) {
w_DATAVALI=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BNWXBPSIDG',0);
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
function Set_AUTRILASC(ctrlValue,kmode,e) {
if (Ne(w_AUTRILASC,ctrlValue)) {
var ctl = _GetCtl(e,'HRNCPADUFU');
if (_tracker.goon(ctl,ctrlValue)) {
w_AUTRILASC=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HRNCPADUFU',0);
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
function Set_PRGSOG(ctrlValue,kmode,e) {
if (Ne(w_PRGSOG,ctrlValue)) {
var ctl = _GetCtl(e,'GIZUBOQEKL');
if (_tracker.goon(ctl,ctrlValue)) {
w_PRGSOG=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('GIZUBOQEKL',0);
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
function Set_PEP(ctrlValue,kmode,e) {
if (Ne(w_PEP,ctrlValue)) {
var ctl = _GetCtl(e,'XFKXBQYUIU');
if (_tracker.goon(ctl,ctrlValue)) {
w_PEP=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XFKXBQYUIU',0);
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
function Calculate() {
var l_bTmpRes;
var l_bResult = true;
m_bCalculating=true;
if ((Ne(o_DESCCIT,w_DESCCIT))) {
l_bTmpRes=Link_YVIKEGPYPM(null);
}
if ((Ne(o_IDCITTANA,w_IDCITTANA))) {
w_nascomunid=w_IDCITTANA;
l_bTmpRes=Link_ZRIWLTGERM(null);
}
if ((Ne(o_DATANASC,w_DATANASC))) {
Calculation_KCPGJNDBIS();
}
if ((Ne(o_COGNOME,w_COGNOME)) || (Ne(o_NOME,w_NOME))) {
Calculation_UEZIABOGNW();
}
if ((Ne(o_NASSTATO,w_NASSTATO))) {
Calculation_DWHWPBJTAT();
}
if ((Ne(o_PAESE,w_PAESE))) {
Calculation_ADEXWQNDVQ();
}
LibJavascript.forEachItem(m_FoundlingCopyWorkVar,i_body_1)
function i_body_1(child){
child();
}
// * --- Area Manuale = UI - Calculate
// * --- Fine Area Manuale
m_bCalculating=false;
}
function Calculation_KCPGJNDBIS() {
arrt_calccodfis([])
}
function Calculation_UEZIABOGNW() {
w_COGNOME=arfn_agechar(w_COGNOME,' ');
w_NOME=arfn_agechar(w_NOME,' ');
}
function Calculation_DWHWPBJTAT() {
w_NASPROV=( ! (Empty(w_NASPROV))?w_NASPROV:( ! (Empty(w_NASSTATO))?'EE':''));
}
function Calculation_ADEXWQNDVQ() {
w_PROVINCIA=( ! (Empty(w_PROVINCIA))?w_PROVINCIA:(Ne(w_PAESE,'086')?'EE':''));
}
function Check_QWFUZETKRF(p_bForce) {
var l_bResult = true;
if (p_bForce) {
l_bResult=arfn_chkcodfis(w_CONNES,w_PAESE,w_CFESTERO);
if ( ! (l_bResult)) {
m_cLastMsgError=AlertErrorMessage('10511004352');
} else {
l_bResult=arfn_cgo_calccodfis(Upper(LRTrim(w_COGNOME)),Upper(LRTrim(w_NOME)),w_DATANASC,Upper(LRTrim(w_NASCOMUN)),Upper(LRTrim(w_NASSTATO)),Upper(w_SESSO),Upper(LRTrim(w_NASPROV)),Upper(LRTrim(w_CONNES)),LRTrim(w_IDCITTANA));
if ( ! (l_bResult)) {
m_cLastMsgError=AlertErrorMessage('11083306812');
}
}
}
return l_bResult;
}
function SaveDependsOn() {
o_COGNOME=w_COGNOME;
o_NOME=w_NOME;
o_PAESE=w_PAESE;
o_DESCCIT=w_DESCCIT;
o_IDCITTANA=w_IDCITTANA;
o_NASSTATO=w_NASSTATO;
o_DATANASC=w_DATANASC;
}
function SaveLabelDependsOn() {
}
function Link_YVIKEGPYPM(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_PAESE);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODSTA',w_PAESE,3,0);
l_Appl.SetFields('CODSTA,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbstati');
l_Appl.SetID('YVIKEGPYPM');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_PAESE=l_Appl.GetStringValue('CODSTA',3,0);
w_dessta=l_Appl.GetStringValue('DESCRI',30,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_YVIKEGPYPM_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_YVIKEGPYPM';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_YVIKEGPYPM();
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
function Link_YVIKEGPYPM_Blank() {
w_PAESE='';
w_dessta='';
}
function LOpt_YVIKEGPYPM() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstati','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODSTA','C'));
l_oWv.setValue('LinkedField',WtA('CODSTA','C'));
l_oWv.setValue('UID',WtA('YVIKEGPYPM','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['YVIKEGPYPM'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('7383187'),'C'));
return l_oWv;
}
function Sugg_ODAYKSRECA(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_Appl = LinkApplet();
var l_bEmp = Empty(HtW(Ctrl('ODAYKSRECA').value,'C'));
l_Appl.SetStringKey('CITTA',HtW(Ctrl('ODAYKSRECA').value,'C'),30,0);
l_Appl.SetFields('CITTA,PROV,CAP,CAB');
l_Appl.SetTypes('C,C,C,C');
l_Appl.LinkTable('tbcitta');
l_Appl.SetID('ODAYKSRECA');
l_Appl.SetMode('suggest');
l_Appl.SetRows('10');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
var res = l_Appl.GetJSONData();
SuggesterLib.render_suggest(res,'ODAYKSRECA','ODAYKSRECA',false,'AQSQVBKXAL_DIV','AQSQVBKXAL_HEADER',0);
return l_bResult;
}
SuggesterLib.select_suggest.ODAYKSRECA=["DESCCIT",[null,null],function(newval) { return HtW(newval,'C')}];
function Link_ODAYKSRECA(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_DESCCIT);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CITTA',w_DESCCIT,30,0);
l_Appl.SetFields('CITTA,PROV,CAP,CAB');
l_Appl.SetTypes('C,C,C,C');
l_Appl.LinkTable('tbcitta');
l_Appl.SetID('ODAYKSRECA');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_DESCCIT=l_Appl.GetStringValue('CITTA',30,0);
w_PROVINCIA=l_Appl.GetStringValue('PROV',2,0);
w_CAP=l_Appl.GetStringValue('CAP',9,0);
w_CODCAB=l_Appl.GetStringValue('CAB',6,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_ODAYKSRECA_Blank();
l_bResult=true;
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_ODAYKSRECA';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_ODAYKSRECA();
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
function Link_ODAYKSRECA_Blank() {
w_PROVINCIA='';
w_CAP='';
w_CODCAB='';
}
function LOpt_ODAYKSRECA() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcitta','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CITTA','C'));
l_oWv.setValue('LinkedField',WtA('CITTA','C'));
l_oWv.setValue('UID',WtA('ODAYKSRECA','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['ODAYKSRECA'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('15186643'),'C'));
return l_oWv;
}
function Link_BYPEBFEOAJ(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_IDCITTANA);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('IDBASE',w_IDCITTANA,40,0);
l_Appl.SetFields('IDBASE');
l_Appl.SetTypes('C');
l_Appl.LinkTable('tbcittna');
l_Appl.SetID('BYPEBFEOAJ');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_IDCITTANA=l_Appl.GetStringValue('IDBASE',40,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_BYPEBFEOAJ_Blank();
l_bResult=true;
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_BYPEBFEOAJ';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_BYPEBFEOAJ();
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
function Link_BYPEBFEOAJ_Blank() {
}
function LOpt_BYPEBFEOAJ() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcittna','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('IDBASE','C'));
l_oWv.setValue('LinkedField',WtA('IDBASE','C'));
l_oWv.setValue('UID',WtA('BYPEBFEOAJ','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['BYPEBFEOAJ'][1],'C'));
return l_oWv;
}
function Link_ZRIWLTGERM(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_nascomunid);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('IDBASE',w_nascomunid,40,0);
l_Appl.SetFields('IDBASE,CITTA,PROV');
l_Appl.SetTypes('C,C,C');
l_Appl.LinkTable('tbcittna');
l_Appl.SetID('ZRIWLTGERM');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_nascomunid=l_Appl.GetStringValue('IDBASE',40,0);
w_NASCOMUN=l_Appl.GetStringValue('CITTA',30,0);
w_NASPROV=l_Appl.GetStringValue('PROV',2,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_ZRIWLTGERM_Blank();
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
function Link_ZRIWLTGERM_Blank() {
w_NASCOMUN='';
w_NASPROV='';
}
function LOpt_ZRIWLTGERM() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcittna','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('IDBASE','C'));
l_oWv.setValue('LinkedField',WtA('IDBASE','C'));
l_oWv.setValue('UID',WtA('ZRIWLTGERM','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['ZRIWLTGERM'][1],'C'));
return l_oWv;
}
function Sugg_HODZKKOSYW(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_Appl = LinkApplet();
var l_bEmp = Empty(HtW(Ctrl('HODZKKOSYW').value,'C'));
l_Appl.SetStringKey('DESCRI',HtW(Ctrl('HODZKKOSYW').value,'C'),30,0);
l_Appl.SetFields('DESCRI');
l_Appl.SetTypes('C');
l_Appl.LinkTable('tbstatna');
l_Appl.SetID('HODZKKOSYW');
l_Appl.SetMode('suggest');
l_Appl.SetRows('10');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
var res = l_Appl.GetJSONData();
SuggesterLib.render_suggest(res,'HODZKKOSYW','HODZKKOSYW',false,'EWPTTWSBMT_DIV','EWPTTWSBMT_HEADER',0);
return l_bResult;
}
SuggesterLib.select_suggest.HODZKKOSYW=["NASSTATO",[null],function(newval) { return HtW(newval,'C')}];
function Link_HODZKKOSYW(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_NASSTATO);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('DESCRI',w_NASSTATO,30,0);
l_Appl.SetFields('DESCRI');
l_Appl.SetTypes('C');
l_Appl.LinkTable('tbstatna');
l_Appl.SetID('HODZKKOSYW');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_NASSTATO=l_Appl.GetStringValue('DESCRI',30,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_HODZKKOSYW_Blank();
l_bResult=true;
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_HODZKKOSYW';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_HODZKKOSYW();
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
function Link_HODZKKOSYW_Blank() {
}
function LOpt_HODZKKOSYW() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstatna','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('DESCRI','C'));
l_oWv.setValue('LinkedField',WtA('DESCRI','C'));
l_oWv.setValue('UID',WtA('HODZKKOSYW','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['HODZKKOSYW'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('7383187'),'C'));
return l_oWv;
}
function Link_MBGANUUHRA(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_TIPODOC);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('TIPDOC',w_TIPODOC,2,0);
l_Appl.SetFields('TIPDOC,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbtipdoc');
l_Appl.SetID('MBGANUUHRA');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_TIPODOC=l_Appl.GetStringValue('TIPDOC',2,0);
w_DESCRI=l_Appl.GetStringValue('DESCRI',30,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_MBGANUUHRA_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_MBGANUUHRA';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_MBGANUUHRA();
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
function Link_MBGANUUHRA_Blank() {
w_TIPODOC='';
w_DESCRI='';
}
function LOpt_MBGANUUHRA() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbtipdoc','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('TIPDOC','C'));
l_oWv.setValue('LinkedField',WtA('TIPDOC','C'));
l_oWv.setValue('UID',WtA('MBGANUUHRA','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['MBGANUUHRA'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('11429032151'),'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'YVIKEGPYPM')) {
last_focused_comp=GetLastFocusedElementOfLink('YVIKEGPYPM');
function SetMethod_YVIKEGPYPM() {
Set_PAESE(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_YVIKEGPYPM();
} else {
setTimeout(SetMethod_YVIKEGPYPM,1);
}
bResult=true;
}
if (Eq(varName,'ODAYKSRECA')) {
last_focused_comp=GetLastFocusedElementOfLink('ODAYKSRECA');
function SetMethod_ODAYKSRECA() {
Set_DESCCIT(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_ODAYKSRECA();
} else {
setTimeout(SetMethod_ODAYKSRECA,1);
}
bResult=true;
}
if (Eq(varName,'BYPEBFEOAJ')) {
last_focused_comp=GetLastFocusedElementOfLink('BYPEBFEOAJ');
function SetMethod_BYPEBFEOAJ() {
Set_IDCITTANA(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_BYPEBFEOAJ();
} else {
setTimeout(SetMethod_BYPEBFEOAJ,1);
}
bResult=true;
}
if (Eq(varName,'HODZKKOSYW')) {
last_focused_comp=GetLastFocusedElementOfLink('HODZKKOSYW');
function SetMethod_HODZKKOSYW() {
Set_NASSTATO(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_HODZKKOSYW();
} else {
setTimeout(SetMethod_HODZKKOSYW,1);
}
bResult=true;
}
if (Eq(varName,'MBGANUUHRA')) {
last_focused_comp=GetLastFocusedElementOfLink('MBGANUUHRA');
function SetMethod_MBGANUUHRA() {
Set_TIPODOC(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_MBGANUUHRA();
} else {
setTimeout(SetMethod_MBGANUUHRA,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'YVIKEGPYPM')) {
return [Ctrl('YVIKEGPYPM')];
}
if (Eq(varName,'ODAYKSRECA')) {
return [Ctrl('ODAYKSRECA')];
}
if (Eq(varName,'BYPEBFEOAJ')) {
return [Ctrl('BYPEBFEOAJ')];
}
if (Eq(varName,'HODZKKOSYW')) {
return [Ctrl('HODZKKOSYW')];
}
if (Eq(varName,'MBGANUUHRA')) {
return [Ctrl('MBGANUUHRA')];
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
parent.ZtVWeb.raiseEventToEvalParms('armt_cgo_personbo_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('armt_cgo_personbo_dataNotSent',{'action':formaction});
}
}
}
}
CheckChild.child=[];
function Check() {
var l_bResult = true;
ResetErrorVars();
m_nLastError=0;
if ( ! (_ChkObl('TWTTDWKCRG',1))) {
_SignErr('TWTTDWKCRG');
m_cLastWorkVarErrorMsg='1816546867';
l_bResult=false;
w_COGNOME=HtW('','C');
} else if ( ! (_ChkObl('WWGIVGNUDW',1))) {
_SignErr('WWGIVGNUDW');
m_cLastWorkVarErrorMsg='443454';
l_bResult=false;
w_NOME=HtW('','C');
} else if ( ! (_ChkObl('CZTHKEDVCO',1))) {
_SignErr('CZTHKEDVCO');
m_cLastWorkVarErrorMsg='10034405761';
l_bResult=false;
w_CFESTERO=0;
} else if ( ! (_ChkObl('YVIKEGPYPM',1))) {
_SignErr('YVIKEGPYPM');
m_cLastWorkVarErrorMsg='7776403';
l_bResult=false;
w_PAESE=HtW('','C');
} else if ( ! (_ChkObl('ODAYKSRECA',1))) {
_SignErr('ODAYKSRECA');
m_cLastWorkVarErrorMsg='15186643';
l_bResult=false;
w_DESCCIT=HtW('','C');
} else if ( ! (_ChkObl('NOTZPDMYIA',1))) {
_SignErr('NOTZPDMYIA');
m_cLastWorkVarErrorMsg='10095365423';
l_bResult=false;
w_PROVINCIA=HtW('','C');
} else if ( ! (_ChkObl('RDAVOEETJG',1))) {
_SignErr('RDAVOEETJG');
m_cLastWorkVarErrorMsg='21587';
l_bResult=false;
w_CAP=HtW('','C');
} else if ( ! (_ChkObl('VYLHWTRQNX',1))) {
_SignErr('VYLHWTRQNX');
m_cLastWorkVarErrorMsg='554236824';
l_bResult=false;
w_DOMICILIO=HtW('','C');
} else if ( ! (_ChkObl('BYPEBFEOAJ',1))) {
_SignErr('BYPEBFEOAJ');
m_cLastWorkVarErrorMsg='378006153';
l_bResult=false;
w_IDCITTANA=HtW('','C');
} else if ((Empty(LRTrim(w_IDCITTANA))) && ( ! (_ChkObl('NEUBQNUEOJ',1)))) {
_SignErr('NEUBQNUEOJ');
m_cLastWorkVarErrorMsg='12123334500';
l_bResult=false;
w_NASCOMUN=HtW('','C');
} else if ( ! (_ChkObl('KPSCOABZLB',1))) {
_SignErr('KPSCOABZLB');
m_cLastWorkVarErrorMsg='11693745788';
l_bResult=false;
w_NASPROV=HtW('','C');
} else if ( ! (_ChkObl('QPALJZMFCL',1))) {
_SignErr('QPALJZMFCL');
m_cLastWorkVarErrorMsg='7776675';
l_bResult=false;
w_SESSO=HtW('','C');
} else if ( ! (_ChkObl('HODZKKOSYW',1))) {
_SignErr('HODZKKOSYW');
m_cLastWorkVarErrorMsg='12123284333';
l_bResult=false;
w_NASSTATO=HtW('','C');
} else if ( ! (_ChkObl('XMGRWGFSFV',1))) {
_SignErr('XMGRWGFSFV');
m_cLastWorkVarErrorMsg='11777527481';
l_bResult=false;
w_DATANASC=HtW('','D');
} else if ( ! (_ChkObl('MBGANUUHRA',1))) {
_SignErr('MBGANUUHRA');
m_cLastWorkVarErrorMsg='11429032151';
l_bResult=false;
w_TIPODOC=HtW('','C');
} else if ( ! (_ChkObl('HVEEMUJUUY',1))) {
_SignErr('HVEEMUJUUY');
m_cLastWorkVarErrorMsg='1734932797';
l_bResult=false;
w_NUMDOCUM=HtW('','C');
} else if ( ! (_ChkObl('XHWYGOPPUN',1))) {
_SignErr('XHWYGOPPUN');
m_cLastWorkVarErrorMsg='1690077224';
l_bResult=false;
w_DATARILASC=HtW('','D');
} else if ( ! (_ChkObl('BNWXBPSIDG',1))) {
_SignErr('BNWXBPSIDG');
m_cLastWorkVarErrorMsg='DATAVALI';
l_bResult=false;
w_DATAVALI=HtW('','D');
} else if ( ! (_ChkObl('HRNCPADUFU',1))) {
_SignErr('HRNCPADUFU');
m_cLastWorkVarErrorMsg='10032163180';
l_bResult=false;
w_AUTRILASC=HtW('','C');
} else if (( ! (_ChkObl('OJJHIUDPFY',1))) || ( ! (arfn_chkcodfis(w_CONNES,w_PAESE,w_CFESTERO)))) {
_SignErr('OJJHIUDPFY','10034398626');
l_bResult=false;
w_CONNES=HtW('','C');
} else if ( ! (_ChkObl('XFKXBQYUIU',1))) {
_SignErr('XFKXBQYUIU');
m_cLastWorkVarErrorMsg='1513560829';
l_bResult=false;
w_PEP='N';
} else if ( ! (_ChkObl('TVQKRQXOUS',1))) {
_SignErr('TVQKRQXOUS');
m_cLastWorkVarErrorMsg='118057317';
l_bResult=false;
w_TXTERR=HtW('','M');
} else if ((false) && ( ! (_ChkObl('GIZUBOQEKL',1)))) {
_SignErr('GIZUBOQEKL');
m_cLastWorkVarErrorMsg='321938427';
l_bResult=false;
w_PRGSOG=HtW('','C');
} else if ( ! (_ChkObl('AYCRVWSEMG',1))) {
_SignErr('AYCRVWSEMG');
m_cLastWorkVarErrorMsg='1791194163';
l_bResult=false;
w_FLGFULL='N';
} else if ( ! (Check_QWFUZETKRF(true))) {
l_bResult = false;
}
if (l_bResult) {
l_bResult=CheckChild(0);
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('YVIKEGPYPM_ZOOM',lc)) {
return 0;
}
if (Eq('YVIKEGPYPM',lc)) {
return 0;
}
if (Eq('ODAYKSRECA_ZOOM',lc)) {
return 1;
}
if (Eq('ODAYKSRECA',lc)) {
return 1;
}
if (Eq('BYPEBFEOAJ_ZOOM',lc)) {
return 2;
}
if (Eq('BYPEBFEOAJ',lc)) {
return 2;
}
if (Eq('HODZKKOSYW_ZOOM',lc)) {
return 3;
}
if (Eq('HODZKKOSYW',lc)) {
return 3;
}
if (Eq('XMGRWGFSFV_ZOOM',lc)) {
return 4;
}
if (Eq('XHWYGOPPUN_ZOOM',lc)) {
return 4;
}
if (Eq('BNWXBPSIDG_ZOOM',lc)) {
return 4;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_YVIKEGPYPM();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,1)) {
l_oWv=LOpt_ODAYKSRECA();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,2)) {
l_oWv=LOpt_BYPEBFEOAJ();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,3)) {
l_oWv=LOpt_HODZKKOSYW();
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
l_oWv.setValue('COGNOME',WtA(w_COGNOME,'C'));
l_oWv.setValue('NOME',WtA(w_NOME,'C'));
l_oWv.setValue('CFESTERO',WtA(w_CFESTERO,'N'));
l_oWv.setValue('PAESE',WtA(w_PAESE,'C'));
l_oWv.setValue('DESCCIT',WtA(w_DESCCIT,'C'));
l_oWv.setValue('PROVINCIA',WtA(w_PROVINCIA,'C'));
l_oWv.setValue('CAP',WtA(w_CAP,'C'));
l_oWv.setValue('DOMICILIO',WtA(w_DOMICILIO,'C'));
l_oWv.setValue('IDCITTANA',WtA(w_IDCITTANA,'C'));
l_oWv.setValue('NASCOMUN',WtA(w_NASCOMUN,'C'));
l_oWv.setValue('NASPROV',WtA(w_NASPROV,'C'));
l_oWv.setValue('SESSO',WtA(w_SESSO,'C'));
l_oWv.setValue('NASSTATO',WtA(w_NASSTATO,'C'));
l_oWv.setValue('DATANASC',WtA(w_DATANASC,'D'));
l_oWv.setValue('TIPODOC',WtA(w_TIPODOC,'C'));
l_oWv.setValue('NUMDOCUM',WtA(w_NUMDOCUM,'C'));
l_oWv.setValue('DATARILASC',WtA(w_DATARILASC,'D'));
l_oWv.setValue('DATAVALI',WtA(w_DATAVALI,'D'));
l_oWv.setValue('AUTRILASC',WtA(w_AUTRILASC,'C'));
l_oWv.setValue('CONNES',WtA(w_CONNES,'C'));
l_oWv.setValue('PEP',WtA(w_PEP,'C'));
l_oWv.setValue('TXTERR',WtA(w_TXTERR,'M'));
l_oWv.setValue('PRGSOG',WtA(w_PRGSOG,'C'));
l_oWv.setValue('FLGFULL',WtA(w_FLGFULL,'C'));
l_oWv.setValue('nascomunid',WtA(w_nascomunid,'C'));
l_oWv.setValue('dessta',WtA(w_dessta,'C'));
l_oWv.setValue('DESCRI',WtA(w_DESCRI,'C'));
l_oWv.setValue('CODCAB',WtA(w_CODCAB,'C'));
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
FillWv.n=["COGNOME","NOME","CFESTERO","PAESE","DESCCIT","PROVINCIA","CAP","DOMICILIO","IDCITTANA","NASCOMUN","NASPROV","SESSO","NASSTATO","DATANASC","TIPODOC","NUMDOCUM","DATARILASC","DATAVALI","AUTRILASC","CONNES","PEP","TXTERR","PRGSOG","FLGFULL","nascomunid","dessta","DESCRI","CODCAB"];
function SetModified() {
m_bUpdated=true;
}
