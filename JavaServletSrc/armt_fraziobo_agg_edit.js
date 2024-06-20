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
if (IsDisabledByStateDriver('sv')) {
DisableInputsInContainer(Ctrl('JANROHXZBL'),true);
}
if (IsDisabledByStateDriver('SOS')) {
DisableInputsInContainer(Ctrl('STHOKLKHLK'),true);
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
function Set_C_NOME(ctrlValue,kmode,e) {
if (Ne(w_C_NOME,ctrlValue)) {
var ctl = _GetCtl(e,'DXUKTRNNCS');
if (_tracker.goon(ctl,ctrlValue)) {
w_C_NOME=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('DXUKTRNNCS',0);
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
function Set_C_COGNOME(ctrlValue,kmode,e) {
if (Ne(w_C_COGNOME,ctrlValue)) {
var ctl = _GetCtl(e,'LUQZFCFSYI');
if (_tracker.goon(ctl,ctrlValue)) {
w_C_COGNOME=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('LUQZFCFSYI',0);
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
function Set_SV58726SA(ctrlValue,kmode,e) {
if (Ne(w_SV58726SA,ctrlValue)) {
var ctl = _GetCtl(e,'WUEMBLXMFM');
if (_tracker.goon(ctl,ctrlValue)) {
w_SV58726SA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('WUEMBLXMFM',0);
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
function Set_SV58726SCA(ctrlValue,kmode,e) {
if (Ne(w_SV58726SCA,ctrlValue)) {
var ctl = _GetCtl(e,'AKMFIOWCBF');
if (_tracker.goon(ctl,ctrlValue)) {
w_SV58726SCA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('AKMFIOWCBF',0);
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
function Set_SV58724(ctrlValue,kmode,e) {
if (Ne(w_SV58724,ctrlValue)) {
var ctl = _GetCtl(e,'BJYOWOAAQH');
if (_tracker.goon(ctl,ctrlValue)) {
w_SV58724=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BJYOWOAAQH',0);
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
function Set_SOSPAGAM(ctrlValue,kmode,e) {
if (Ne(w_SOSPAGAM,ctrlValue)) {
var ctl = _GetCtl(e,'CIGEGYZWMZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_SOSPAGAM=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CIGEGYZWMZ',0);
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
function Set_SV58726PISP(ctrlValue,kmode,e) {
if (Ne(w_SV58726PISP,ctrlValue)) {
var ctl = _GetCtl(e,'NODGYYBWWX');
if (_tracker.goon(ctl,ctrlValue)) {
w_SV58726PISP=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NODGYYBWWX',0);
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
function Set_FLAGFRAUD(ctrlValue,kmode,e) {
if (Ne(w_FLAGFRAUD,ctrlValue)) {
var ctl = _GetCtl(e,'QKZHBGTGRL');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLAGFRAUD=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QKZHBGTGRL',0);
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
function Calculate() {
var l_bTmpRes;
var l_bResult = true;
m_bCalculating=true;
if ((Ne(o_CATEG01,w_CATEG01)) || (Ne(o_CATEG02,w_CATEG02)) || (Ne(o_CATEG03,w_CATEG03)) || (Ne(o_CATEG04,w_CATEG04)) || (Ne(o_CATEG05,w_CATEG05))) {
w_CATEGORIA=fwfn_calc_categoria(w_CATEG01,w_CATEG02,w_CATEG03,w_CATEG04,w_CATEG05);
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
o_CATEG01=w_CATEG01;
o_CATEG02=w_CATEG02;
o_CATEG03=w_CATEG03;
o_CATEG04=w_CATEG04;
o_CATEG05=w_CATEG05;
}
function SaveLabelDependsOn() {
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
l_cFieldFilter=l_cFieldFilter+l_cAndOpForField+_flt_('C1CODTAB','O',null,true,'=');
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
l_cFieldFilter=l_cFieldFilter+l_cAndOpForField+_flt_('C2CODTAB','O',null,true,'=');
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
l_cFieldFilter=l_cFieldFilter+l_cAndOpForField+_flt_('C3CODTAB','O',null,true,'=');
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
l_cFieldFilter=l_cFieldFilter+l_cAndOpForField+_flt_('C4CODTAB','O',null,true,'=');
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
l_cFieldFilter=l_cFieldFilter+l_cAndOpForField+_flt_('C5CODTAB','O',null,true,'=');
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
if ( ! (m_oFather.SaveContext_armt_fraziobo_agg())) {
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
parent.ZtVWeb.raiseEventToEvalParms('armt_fraziobo_agg_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('armt_fraziobo_agg_dataNotSent',{'action':formaction});
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
if ( ! (_ChkObl('CANUTVNGFD',1))) {
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
} else if ( ! (_ChkObl('QKZHBGTGRL',1))) {
_SignErr('QKZHBGTGRL');
m_cLastWorkVarErrorMsg='588930876';
l_bResult=false;
w_FLAGFRAUD=0;
} else if ( ! (_ChkObl('BJYOWOAAQH',1))) {
_SignErr('BJYOWOAAQH');
m_cLastWorkVarErrorMsg='584607094';
l_bResult=false;
w_SV58724=HtW('','C');
} else if ( ! (_ChkObl('AKMFIOWCBF',1))) {
_SignErr('AKMFIOWCBF');
m_cLastWorkVarErrorMsg='10311059713';
l_bResult=false;
w_SV58726SCA='N';
} else if ( ! (_ChkObl('WUEMBLXMFM',1))) {
_SignErr('WUEMBLXMFM');
m_cLastWorkVarErrorMsg='759255200';
l_bResult=false;
w_SV58726SA=HtW('','C');
} else if ( ! (_ChkObl('NODGYYBWWX',1))) {
_SignErr('NODGYYBWWX');
m_cLastWorkVarErrorMsg='11263356912';
l_bResult=false;
w_SV58726PISP=HtW('','C');
} else if ( ! (_ChkObl('LUQZFCFSYI',1))) {
_SignErr('LUQZFCFSYI');
m_cLastWorkVarErrorMsg='10227543146';
l_bResult=false;
w_C_COGNOME=HtW('','C');
} else if ( ! (_ChkObl('DXUKTRNNCS',1))) {
_SignErr('DXUKTRNNCS');
m_cLastWorkVarErrorMsg='11757468987';
l_bResult=false;
w_C_NOME=HtW('','C');
} else if ( ! (_ChkObl('CIGEGYZWMZ',1))) {
_SignErr('CIGEGYZWMZ');
m_cLastWorkVarErrorMsg='1118764577';
l_bResult=false;
w_SOSPAGAM=HtW('','C');
}
if (l_bResult) {
l_bResult=CheckChild(0);
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('CANUTVNGFD_ZOOM',lc)) {
return 0;
}
if (Eq('CANUTVNGFD',lc)) {
return 0;
}
if (Eq('IXGRJLAKIQ_ZOOM',lc)) {
return 1;
}
if (Eq('IXGRJLAKIQ',lc)) {
return 1;
}
if (Eq('NKIXCWZJHO_ZOOM',lc)) {
return 2;
}
if (Eq('NKIXCWZJHO',lc)) {
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
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_CANUTVNGFD();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
l_cFieldFilter=l_cFieldFilter+l_cAndOpForField+_flt_('C1CODTAB','O',null,true,'=');
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
l_oWv.setValue('FieldFilter',l_cFieldFilter);
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,1)) {
l_oWv=LOpt_IXGRJLAKIQ();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
l_cFieldFilter=l_cFieldFilter+l_cAndOpForField+_flt_('C2CODTAB','O',null,true,'=');
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
l_oWv.setValue('FieldFilter',l_cFieldFilter);
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,2)) {
l_oWv=LOpt_NKIXCWZJHO();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
l_cFieldFilter=l_cFieldFilter+l_cAndOpForField+_flt_('C3CODTAB','O',null,true,'=');
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
l_oWv.setValue('FieldFilter',l_cFieldFilter);
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,3)) {
l_oWv=LOpt_JQLGHMLOKO();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
l_cFieldFilter=l_cFieldFilter+l_cAndOpForField+_flt_('C4CODTAB','O',null,true,'=');
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
l_oWv.setValue('FieldFilter',l_cFieldFilter);
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,4)) {
l_oWv=LOpt_QVBZSFMTVP();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
l_cFieldFilter=l_cFieldFilter+l_cAndOpForField+_flt_('C5CODTAB','O',null,true,'=');
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
l_oWv.setValue('IDBASE',WtA(w_IDBASE,'C'));
l_oWv.setValue('CATEG01',WtA(w_CATEG01,'C'));
l_oWv.setValue('CATEG02',WtA(w_CATEG02,'C'));
l_oWv.setValue('CATEG03',WtA(w_CATEG03,'C'));
l_oWv.setValue('CATEG04',WtA(w_CATEG04,'C'));
l_oWv.setValue('CATEG05',WtA(w_CATEG05,'C'));
l_oWv.setValue('CATEGORIA',WtA(w_CATEGORIA,'C'));
l_oWv.setValue('FLAGFRAUD',WtA(w_FLAGFRAUD,'N'));
l_oWv.setValue('SV58724',WtA(w_SV58724,'C'));
l_oWv.setValue('SV58726SCA',WtA(w_SV58726SCA,'C'));
l_oWv.setValue('SV58726SA',WtA(w_SV58726SA,'C'));
l_oWv.setValue('SV58726PISP',WtA(w_SV58726PISP,'C'));
l_oWv.setValue('C_COGNOME',WtA(w_C_COGNOME,'C'));
l_oWv.setValue('C_NOME',WtA(w_C_NOME,'C'));
l_oWv.setValue('SOSPAGAM',WtA(w_SOSPAGAM,'C'));
l_oWv.setValue('SEGNO',WtA(w_SEGNO,'C'));
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
FillWv.n=["IDBASE","CATEG01","CATEG02","CATEG03","CATEG04","CATEG05","CATEGORIA","FLAGFRAUD","SV58724","SV58726SCA","SV58726SA","SV58726PISP","C_COGNOME","C_NOME","SOSPAGAM","SEGNO","xC1DESCRI","xC2DESCRI","xC3DESCRI","xC4DESCRI","xC5DESCRI"];
function SetModified() {
m_bUpdated=true;
if (IsWndAccessible(m_oFather)) {
m_oFather.SetModified_armt_fraziobo_agg();
}
}
function EnableEntityWhenReady(enable) {
if (enable) {
var c;
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
if(c=Ctrl('QKZHBGTGRL')) SetDisabled(c,true);
if(c=Ctrl('BJYOWOAAQH')) SetDisabled(c,true);
if(c=Ctrl('AKMFIOWCBF')) SetDisabled(c,true);
if(c=Ctrl('WUEMBLXMFM')) SetDisabled(c,true);
if(c=Ctrl('NODGYYBWWX')) SetDisabled(c,true);
if(c=Ctrl('LUQZFCFSYI')) SetDisabled(c,true);
if(c=Ctrl('DXUKTRNNCS')) SetDisabled(c,true);
if(c=Ctrl('CIGEGYZWMZ')) SetDisabled(c,true);
} else {
var c;
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
if(c=Ctrl('QKZHBGTGRL')) SetDisabled(c,false);
if(c=Ctrl('BJYOWOAAQH')) SetDisabled(c,false);
if(c=Ctrl('AKMFIOWCBF')) SetDisabled(c,false);
if(c=Ctrl('WUEMBLXMFM')) SetDisabled(c,false);
if(c=Ctrl('NODGYYBWWX')) SetDisabled(c,false);
if(c=Ctrl('LUQZFCFSYI')) SetDisabled(c,false);
if(c=Ctrl('DXUKTRNNCS')) SetDisabled(c,false);
if(c=Ctrl('CIGEGYZWMZ')) SetDisabled(c,false);
EnableControlsUnderCondition(false);
}
m_bChildDisabled=enable;
}
