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
SetObligatory(Ctrl('GYMTADSNZN'),Eq(w_TRXFLGFOR,'S') || IsObligatoryByStateDriver('TRXFORCE'));
}
function SetDynamicClasses() {
var c;
}
function SetDynamicTooltip() {
var c;
}
function Set_xtnumdoc(ctrlValue,kmode,e) {
if (Ne(w_xtnumdoc,ctrlValue)) {
var ctl = _GetCtl(e,'FKGNMENYXR');
if (_tracker.goon(ctl,ctrlValue)) {
w_xtnumdoc=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FKGNMENYXR',0);
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
function Set_TRXCOGNOM(ctrlValue,kmode,e) {
if (Ne(w_TRXCOGNOM,ctrlValue)) {
var ctl = _GetCtl(e,'OAJHZGVXDW');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXCOGNOM=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('OAJHZGVXDW',0);
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
function Set_TRXNOME(ctrlValue,kmode,e) {
if (Ne(w_TRXNOME,ctrlValue)) {
var ctl = _GetCtl(e,'IJWHZPPSVS');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXNOME=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('IJWHZPPSVS',0);
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
function Set_TRXFLGCF(ctrlValue,kmode,e) {
if (Ne(w_TRXFLGCF,ctrlValue)) {
var ctl = _GetCtl(e,'GOZRBLFKLS');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXFLGCF=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('GOZRBLFKLS',0);
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
function Set_TRXCODFIS(ctrlValue,kmode,e) {
if (Ne(w_TRXCODFIS,ctrlValue)) {
var ctl = _GetCtl(e,'NIGZXFUTGU');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXCODFIS=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NIGZXFUTGU',0);
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
function Set_TRXLUONAS(ctrlValue,kmode,e) {
if (Ne(w_TRXLUONAS,ctrlValue)) {
var ctl = _GetCtl(e,'CAICHGXWXW');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXLUONAS=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CAICHGXWXW',0);
if (l_bResult) {
l_bResult=Link_CAICHGXWXW(kmode);
if ( ! (l_bResult)) {
w_TRXLUONAS=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',50,0,''));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',50,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_TRXNUMDOC(ctrlValue,kmode,e) {
if (Ne(w_TRXNUMDOC,ctrlValue)) {
var ctl = _GetCtl(e,'QWQZUBRCXK');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXNUMDOC=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QWQZUBRCXK',0);
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
function Set_TRXDATSCA(ctrlValue,kmode,e) {
if (Ne(w_TRXDATSCA,ctrlValue)) {
var ctl = _GetCtl(e,'EMCTEYNINS');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXDATSCA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('EMCTEYNINS',0);
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
function Set_TRXDATRIL(ctrlValue,kmode,e) {
if (Ne(w_TRXDATRIL,ctrlValue)) {
var ctl = _GetCtl(e,'ETDFWVULIM');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXDATRIL=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ETDFWVULIM',0);
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
function Set_TRXTIPDOC(ctrlValue,kmode,e) {
if (Ne(w_TRXTIPDOC,ctrlValue)) {
var ctl = _GetCtl(e,'TTQTFXMWFO');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXTIPDOC=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('TTQTFXMWFO',0);
if (l_bResult) {
l_bResult=Link_TTQTFXMWFO(kmode);
if ( ! (l_bResult)) {
w_TRXTIPDOC=HtW('','C');
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
function Set_TRXESITO(ctrlValue,kmode,e) {
if (Ne(w_TRXESITO,ctrlValue)) {
var ctl = _GetCtl(e,'XONXBNGAAH');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXESITO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XONXBNGAAH',0);
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
function Set_TRXDATNAS(ctrlValue,kmode,e) {
if (Ne(w_TRXDATNAS,ctrlValue)) {
var ctl = _GetCtl(e,'BYTTMKVPJF');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXDATNAS=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BYTTMKVPJF',0);
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
function Set_TRXFORCE(ctrlValue,kmode,e) {
if (Ne(w_TRXFORCE,ctrlValue)) {
var ctl = _GetCtl(e,'GYMTADSNZN');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXFORCE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('GYMTADSNZN',0);
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
function Set_TRXSESSO(ctrlValue,kmode,e) {
if (Ne(w_TRXSESSO,ctrlValue)) {
var ctl = _GetCtl(e,'ATGEKSLXET');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXSESSO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ATGEKSLXET',0);
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
function Set_TRXFLGFOR(ctrlValue,kmode,e) {
if (Ne(w_TRXFLGFOR,ctrlValue)) {
var ctl = _GetCtl(e,'CMGWBYDKHQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXFLGFOR=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CMGWBYDKHQ',0);
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
function Set_TRXFLGAUA(ctrlValue,kmode,e) {
if (Ne(w_TRXFLGAUA,ctrlValue)) {
var ctl = _GetCtl(e,'FMRBWPDSBR');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXFLGAUA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('TZHYQAUMDE',0);
l_bResult=l_bResult && _ChkObl('FMRBWPDSBR',0);
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
function Set_TRFLGINLAV(ctrlValue,kmode,e) {
if (Ne(w_TRFLGINLAV,ctrlValue)) {
var ctl = _GetCtl(e,'ZGTJLSVSXA');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRFLGINLAV=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ZGTJLSVSXA',0);
l_bResult=l_bResult && _ChkObl('RWTMBAJLQJ',0);
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
function Set_TRDFINLAV(ctrlValue,kmode,e) {
if (Ne(w_TRDFINLAV,ctrlValue)) {
var ctl = _GetCtl(e,'WCMXGFBEVX');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRDFINLAV=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('WCMXGFBEVX',0);
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
function Set_xtipdoc(ctrlValue,kmode,e) {
if (Ne(w_xtipdoc,ctrlValue)) {
var ctl = _GetCtl(e,'HUXCGVAMUP');
if (_tracker.goon(ctl,ctrlValue)) {
w_xtipdoc=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HUXCGVAMUP',0);
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
function Set_finalized(ctrlValue,kmode,e) {
if (Ne(w_finalized,ctrlValue)) {
var ctl = _GetCtl(e,'ZDYTXRRFLT');
if (_tracker.goon(ctl,ctrlValue)) {
w_finalized=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ZDYTXRRFLT',0);
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
function Set_xluonas(ctrlValue,kmode,e) {
if (Ne(w_xluonas,ctrlValue)) {
var ctl = _GetCtl(e,'BLTFRBAHBH');
if (_tracker.goon(ctl,ctrlValue)) {
w_xluonas=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BLTFRBAHBH',0);
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
function Set_TRXTFINLAV(ctrlValue,kmode,e) {
if (Ne(w_TRXTFINLAV,ctrlValue)) {
var ctl = _GetCtl(e,'EMFAOZJHRN');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXTFINLAV=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('EMFAOZJHRN',0);
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
function Set_FLGDATIOLD(ctrlValue,kmode,e) {
if (Ne(w_FLGDATIOLD,ctrlValue)) {
var ctl = _GetCtl(e,'PPLBWAIBLM');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLGDATIOLD=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('PPLBWAIBLM',0);
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
w_sesso=(Eq(w_TRXSESSO,'M')?'1':(Eq(w_TRXSESSO,'F')?'2':''));
if ((Ne(o_xtnumdoc,w_xtnumdoc))) {
Calculation_CCEVZSDPHQ();
}
if ((Ne(o_TRXCODDIP,w_TRXCODDIP))) {
l_bTmpRes=Link_HZPBCLSNRS(null);
}
if ((Ne(o_TRXCODMAG,w_TRXCODMAG))) {
l_bTmpRes=Link_UTFQIBBLAF(null);
}
if ((Ne(o_TRXNAZRES,w_TRXNAZRES))) {
l_bTmpRes=Link_UUXGHAXWLH(null);
}
if ((Ne(o_TRXCITRES,w_TRXCITRES))) {
l_bTmpRes=Link_XSZDOLIZKJ(null);
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
function Calculation_CCEVZSDPHQ() {
arrt_wutrxchk_upddata([])
}
function Check_QFZMCGCOBP(p_bForce) {
var l_bResult = true;
if (p_bForce) {
l_bResult= ! ( ! (Empty(w_xTRXPROVINCIA)) && Ne(w_xTRXPROVINCIA,'EE') && Empty(w_TRXCODFIS));
if ( ! (l_bResult)) {
m_cLastMsgError=AlertErrorMessage('1539897768');
}
}
return l_bResult;
}
function SaveDependsOn() {
o_xtnumdoc=w_xtnumdoc;
o_TRXCODDIP=w_TRXCODDIP;
o_TRXCODMAG=w_TRXCODMAG;
o_TRXNAZRES=w_TRXNAZRES;
o_TRXCITRES=w_TRXCITRES;
}
function SaveLabelDependsOn() {
}
function Sugg_CAICHGXWXW(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_Appl = LinkApplet();
var l_bEmp = Empty(HtW(Ctrl('CAICHGXWXW').value,'C'));
l_Appl.SetStringKey('DESCRI',HtW(Ctrl('CAICHGXWXW').value,'C'),50,0);
l_Appl.SetFields('DESCRI,PROVINCIA');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbluonas');
l_Appl.SetID('CAICHGXWXW');
l_Appl.SetMode('suggest');
l_Appl.SetRows('10');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
var res = l_Appl.GetJSONData();
SuggesterLib.render_suggest(res,'CAICHGXWXW','CAICHGXWXW',false,'','',0);
return l_bResult;
}
SuggesterLib.select_suggest.CAICHGXWXW=["TRXLUONAS",[null],function(newval) { return HtW(newval,'C')}];
function Link_CAICHGXWXW(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_TRXLUONAS);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('DESCRI',w_TRXLUONAS,50,0);
l_Appl.SetFields('DESCRI,PROVINCIA');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbluonas');
l_Appl.SetID('CAICHGXWXW');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_TRXLUONAS=l_Appl.GetStringValue('DESCRI',50,0);
w_xTRXPROVINCIA=l_Appl.GetStringValue('PROVINCIA',2,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_CAICHGXWXW_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_CAICHGXWXW';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_CAICHGXWXW();
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
function Link_CAICHGXWXW_Blank() {
w_TRXLUONAS='';
w_xTRXPROVINCIA='';
}
function LOpt_CAICHGXWXW() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbluonas','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('DESCRI','C'));
l_oWv.setValue('LinkedField',WtA('DESCRI','C'));
l_oWv.setValue('UID',WtA('CAICHGXWXW','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['CAICHGXWXW'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('380127078'),'C'));
return l_oWv;
}
function Link_TTQTFXMWFO(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_TRXTIPDOC);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('WUTDCODICE',w_TRXTIPDOC,2,0);
l_Appl.SetFields('WUTDCODICE,WUTDTIPDOC');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('wutipdoc');
l_Appl.SetID('TTQTFXMWFO');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_TRXTIPDOC=l_Appl.GetStringValue('WUTDCODICE',2,0);
w_doctype=l_Appl.GetStringValue('WUTDTIPDOC',2,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_TTQTFXMWFO_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_TTQTFXMWFO';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_TTQTFXMWFO();
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
function Link_TTQTFXMWFO_Blank() {
w_TRXTIPDOC='';
w_doctype='';
}
function LOpt_TTQTFXMWFO() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('wutipdoc','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('WUTDCODICE','C'));
l_oWv.setValue('LinkedField',WtA('WUTDCODICE','C'));
l_oWv.setValue('UID',WtA('TTQTFXMWFO','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['TTQTFXMWFO'][1],'C'));
return l_oWv;
}
function Link_HZPBCLSNRS(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_TRXCODDIP);
var l_Appl = LinkApplet();
l_Appl.AppendFilterValue(w_TRXCODMAG);
l_Appl.SetStringKey('AGACCODE',w_TRXCODDIP,10,0);
l_Appl.SetFields('AGACCODE,DESCRIZ');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('anadip');
l_Appl.SetID('HZPBCLSNRS');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_TRXCODDIP=l_Appl.GetStringValue('AGACCODE',10,0);
w_xDESCRIZ=l_Appl.GetStringValue('DESCRIZ',30,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_HZPBCLSNRS_Blank();
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
function Link_HZPBCLSNRS_Blank() {
w_TRXCODDIP='';
w_xDESCRIZ='';
}
function LOpt_HZPBCLSNRS() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('anadip','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('AGACCODE','C'));
l_oWv.setValue('LinkedField',WtA('AGACCODE','C'));
l_oWv.setValue('UID',WtA('HZPBCLSNRS','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['HZPBCLSNRS'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('1813072817'),'C'));
return l_oWv;
}
function Link_UTFQIBBLAF(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_TRXCODMAG);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('MANAIDWU',w_TRXCODMAG,5,0);
l_Appl.SetFields('MANAIDWU,MADESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbmacage');
l_Appl.SetID('UTFQIBBLAF');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_TRXCODMAG=l_Appl.GetStringValue('MANAIDWU',5,0);
w_xMADESCRI=l_Appl.GetStringValue('MADESCRI',60,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_UTFQIBBLAF_Blank();
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
function Link_UTFQIBBLAF_Blank() {
w_TRXCODMAG='';
w_xMADESCRI='';
}
function LOpt_UTFQIBBLAF() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbmacage','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('MANAIDWU','C'));
l_oWv.setValue('LinkedField',WtA('MANAIDWU','C'));
l_oWv.setValue('UID',WtA('UTFQIBBLAF','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['UTFQIBBLAF'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('11283615582'),'C'));
return l_oWv;
}
function Link_UUXGHAXWLH(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_TRXNAZRES);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('DESCRI',w_TRXNAZRES,50,0);
l_Appl.SetFields('DESCRI');
l_Appl.SetTypes('C');
l_Appl.LinkTable('tbstati');
l_Appl.SetLinkzoom('armt_stati');
l_Appl.SetID('UUXGHAXWLH');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_TRXNAZRES=l_Appl.GetStringValue('DESCRI',50,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_UUXGHAXWLH_Blank();
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
function Link_UUXGHAXWLH_Blank() {
w_TRXNAZRES='';
}
function LOpt_UUXGHAXWLH() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstati','C'));
l_oWv.setValue('Linkzoomprg',WtA('armt_stati','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('DESCRI','C'));
l_oWv.setValue('LinkedField',WtA('DESCRI','C'));
l_oWv.setValue('UID',WtA('UUXGHAXWLH','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['UUXGHAXWLH'][1],'C'));
return l_oWv;
}
function Link_XSZDOLIZKJ(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_TRXCITRES);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CITTA',w_TRXCITRES,50,0);
l_Appl.SetFields('CITTA');
l_Appl.SetTypes('C');
l_Appl.LinkTable('tbcitta');
l_Appl.SetID('XSZDOLIZKJ');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_TRXCITRES=l_Appl.GetStringValue('CITTA',50,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_XSZDOLIZKJ_Blank();
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
function Link_XSZDOLIZKJ_Blank() {
w_TRXCITRES='';
}
function LOpt_XSZDOLIZKJ() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcitta','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CITTA','C'));
l_oWv.setValue('LinkedField',WtA('CITTA','C'));
l_oWv.setValue('UID',WtA('XSZDOLIZKJ','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['XSZDOLIZKJ'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('15186643'),'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'CAICHGXWXW')) {
last_focused_comp=GetLastFocusedElementOfLink('CAICHGXWXW');
function SetMethod_CAICHGXWXW() {
Set_TRXLUONAS(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_CAICHGXWXW();
} else {
setTimeout(SetMethod_CAICHGXWXW,1);
}
bResult=true;
}
if (Eq(varName,'TTQTFXMWFO')) {
last_focused_comp=GetLastFocusedElementOfLink('TTQTFXMWFO');
function SetMethod_TTQTFXMWFO() {
Set_TRXTIPDOC(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_TTQTFXMWFO();
} else {
setTimeout(SetMethod_TTQTFXMWFO,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'CAICHGXWXW')) {
return [Ctrl('CAICHGXWXW')];
}
if (Eq(varName,'TTQTFXMWFO')) {
return [Ctrl('TTQTFXMWFO')];
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
parent.ZtVWeb.raiseEventToEvalParms('armt_wutrxchk_aua_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('armt_wutrxchk_aua_dataNotSent',{'action':formaction});
}
}
}
}
CheckChild.child=[];
function Check() {
var l_bResult = true;
ResetErrorVars();
m_nLastError=0;
if ( ! (_ChkObl('OAJHZGVXDW',1))) {
_SignErr('OAJHZGVXDW');
m_cLastWorkVarErrorMsg='1816546867';
l_bResult=false;
w_TRXCOGNOM=HtW('','C');
} else if ( ! (_ChkObl('IJWHZPPSVS',1))) {
_SignErr('IJWHZPPSVS');
m_cLastWorkVarErrorMsg='443454';
l_bResult=false;
w_TRXNOME=HtW('','C');
} else if ( ! (_ChkObl('GOZRBLFKLS',1))) {
_SignErr('GOZRBLFKLS');
m_cLastWorkVarErrorMsg='1563406272';
l_bResult=false;
w_TRXFLGCF='N';
} else if ( ! (_ChkObl('NIGZXFUTGU',1))) {
_SignErr('NIGZXFUTGU');
m_cLastWorkVarErrorMsg='10782899903';
l_bResult=false;
w_TRXCODFIS=HtW('','C');
} else if ( ! (_ChkObl('CAICHGXWXW',1))) {
_SignErr('CAICHGXWXW');
m_cLastWorkVarErrorMsg='12123333988';
l_bResult=false;
w_TRXLUONAS=HtW('','C');
} else if ( ! (_ChkObl('QWQZUBRCXK',1))) {
_SignErr('QWQZUBRCXK');
m_cLastWorkVarErrorMsg='10759885763';
l_bResult=false;
w_TRXNUMDOC=HtW('','C');
} else if ( ! (_ChkObl('EMCTEYNINS',1))) {
_SignErr('EMCTEYNINS');
m_cLastWorkVarErrorMsg='628384699';
l_bResult=false;
w_TRXDATSCA=HtW('','D');
} else if ( ! (_ChkObl('ETDFWVULIM',1))) {
_SignErr('ETDFWVULIM');
m_cLastWorkVarErrorMsg='10613332584';
l_bResult=false;
w_TRXDATRIL=HtW('','D');
} else if ( ! (_ChkObl('TTQTFXMWFO',1))) {
_SignErr('TTQTFXMWFO');
m_cLastWorkVarErrorMsg='11429032151';
l_bResult=false;
w_TRXTIPDOC=HtW('','C');
} else if ( ! (_ChkObl('BYTTMKVPJF',1))) {
_SignErr('BYTTMKVPJF');
m_cLastWorkVarErrorMsg='10703188046';
l_bResult=false;
w_TRXDATNAS=HtW('','D');
} else if ( ! (_ChkObl('ATGEKSLXET',1))) {
_SignErr('ATGEKSLXET');
m_cLastWorkVarErrorMsg='7776675';
l_bResult=false;
w_TRXSESSO=HtW('','C');
} else if ( ! (_ChkObl('CMGWBYDKHQ',1))) {
_SignErr('CMGWBYDKHQ');
m_cLastWorkVarErrorMsg='1636021524';
l_bResult=false;
w_TRXFLGFOR='N';
} else if ( ! (_ChkObl('GYMTADSNZN',1))) {
_SignErr('GYMTADSNZN');
m_cLastWorkVarErrorMsg='707662893';
l_bResult=false;
w_TRXFORCE=HtW('','C');
} else if ( ! (_ChkObl('PPLBWAIBLM',1))) {
_SignErr('PPLBWAIBLM');
m_cLastWorkVarErrorMsg='FLGDATIOLD';
l_bResult=false;
w_FLGDATIOLD='N';
} else if ( ! (_ChkObl('HUXCGVAMUP',1))) {
_SignErr('HUXCGVAMUP');
m_cLastWorkVarErrorMsg='xtipdoc';
l_bResult=false;
w_xtipdoc=HtW('','C');
} else if ( ! (_ChkObl('FKGNMENYXR',1))) {
_SignErr('FKGNMENYXR');
m_cLastWorkVarErrorMsg='xtnumdoc';
l_bResult=false;
w_xtnumdoc=HtW('','C');
} else if ( ! (_ChkObl('EMFAOZJHRN',1))) {
_SignErr('EMFAOZJHRN');
m_cLastWorkVarErrorMsg='10847907928';
l_bResult=false;
w_TRXTFINLAV=HtW('','T');
} else if ( ! (_ChkObl('WCMXGFBEVX',1))) {
_SignErr('WCMXGFBEVX');
m_cLastWorkVarErrorMsg='10681623869';
l_bResult=false;
w_TRDFINLAV=HtW('','D');
} else if ( ! (_ChkObl('ZGTJLSVSXA',1))) {
_SignErr('ZGTJLSVSXA');
m_cLastWorkVarErrorMsg='11651685846';
l_bResult=false;
w_TRFLGINLAV=HtW('','C');
} else if ( ! (_ChkObl('FMRBWPDSBR',1))) {
_SignErr('FMRBWPDSBR');
m_cLastWorkVarErrorMsg='753730945';
l_bResult=false;
w_TRXFLGAUA=HtW('','C');
} else if ( ! (_ChkObl('XONXBNGAAH',1))) {
_SignErr('XONXBNGAAH');
m_cLastWorkVarErrorMsg='125267528';
l_bResult=false;
w_TRXESITO=HtW('','C');
} else if ( ! (_ChkObl('ZDYTXRRFLT',1))) {
_SignErr('ZDYTXRRFLT');
m_cLastWorkVarErrorMsg='finalized';
l_bResult=false;
w_finalized=HtW('','C');
} else if ( ! (_ChkObl('BLTFRBAHBH',1))) {
_SignErr('BLTFRBAHBH');
m_cLastWorkVarErrorMsg='xluonas';
l_bResult=false;
w_xluonas=HtW('','C');
} else if ( ! (Check_QFZMCGCOBP(true))) {
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
if (Eq('CAICHGXWXW_ZOOM',lc)) {
return 0;
}
if (Eq('CAICHGXWXW',lc)) {
return 0;
}
if (Eq('EMCTEYNINS_ZOOM',lc)) {
return 1;
}
if (Eq('ETDFWVULIM_ZOOM',lc)) {
return 1;
}
if (Eq('BYTTMKVPJF_ZOOM',lc)) {
return 1;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_CAICHGXWXW();
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
l_oWv.setValue('TRXCODPRG',WtA(w_TRXCODPRG,'N'));
l_oWv.setValue('op_TRXCODPRG',WtA(op_TRXCODPRG,'N'));
l_oWv.setValue('TRXCOGNOM',WtA(w_TRXCOGNOM,'C'));
l_oWv.setValue('TRXNOME',WtA(w_TRXNOME,'C'));
l_oWv.setValue('TRXFLGCF',WtA(w_TRXFLGCF,'C'));
l_oWv.setValue('TRXCODFIS',WtA(w_TRXCODFIS,'C'));
l_oWv.setValue('TRXLUONAS',WtA(w_TRXLUONAS,'C'));
l_oWv.setValue('TRXNUMDOC',WtA(w_TRXNUMDOC,'C'));
l_oWv.setValue('TRXDATSCA',WtA(w_TRXDATSCA,'D'));
l_oWv.setValue('TRXDATRIL',WtA(w_TRXDATRIL,'D'));
l_oWv.setValue('TRXTIPDOC',WtA(w_TRXTIPDOC,'C'));
l_oWv.setValue('TRXMTCN',WtA(w_TRXMTCN,'C'));
l_oWv.setValue('TRXDATNAS',WtA(w_TRXDATNAS,'D'));
l_oWv.setValue('TRXDATOPE',WtA(w_TRXDATOPE,'D'));
l_oWv.setValue('TRXFLGCON',WtA(w_TRXFLGCON,'C'));
l_oWv.setValue('TRSSEGNO',WtA(w_TRSSEGNO,'C'));
l_oWv.setValue('TRXIMPORTO',WtA(w_TRXIMPORTO,'N'));
l_oWv.setValue('TRXCONTAN',WtA(w_TRXCONTAN,'N'));
l_oWv.setValue('TRXUNIQUE',WtA(w_TRXUNIQUE,'C'));
l_oWv.setValue('TRXCOGCON',WtA(w_TRXCOGCON,'C'));
l_oWv.setValue('TRXNOMCON',WtA(w_TRXNOMCON,'C'));
l_oWv.setValue('TRXDESTIN',WtA(w_TRXDESTIN,'C'));
l_oWv.setValue('TRXCODCAS',WtA(w_TRXCODCAS,'C'));
l_oWv.setValue('TRXRECTYPE',WtA(w_TRXRECTYPE,'C'));
l_oWv.setValue('TRXCODMAG',WtA(w_TRXCODMAG,'C'));
l_oWv.setValue('TRXCODUNI',WtA(w_TRXCODUNI,'C'));
l_oWv.setValue('TRXSESSO',WtA(w_TRXSESSO,'C'));
l_oWv.setValue('TRXNASSTATO',WtA(w_TRXNASSTATO,'C'));
l_oWv.setValue('TRXNASCOMUN',WtA(w_TRXNASCOMUN,'C'));
l_oWv.setValue('TRXFLGAUAQ1',WtA(w_TRXFLGAUAQ1,'C'));
l_oWv.setValue('TRXFLGAUAQ2',WtA(w_TRXFLGAUAQ2,'C'));
l_oWv.setValue('TRXFLGAUAQ3',WtA(w_TRXFLGAUAQ3,'C'));
l_oWv.setValue('TRXFLGAUAQ4',WtA(w_TRXFLGAUAQ4,'C'));
l_oWv.setValue('TRXFLGAUAQ5',WtA(w_TRXFLGAUAQ5,'C'));
l_oWv.setValue('TRXFLGAUA',WtA(w_TRXFLGAUA,'C'));
l_oWv.setValue('TRXFLGFOR',WtA(w_TRXFLGFOR,'C'));
l_oWv.setValue('TRXFORCE',WtA(w_TRXFORCE,'C'));
l_oWv.setValue('TRXDATRICERCA',WtA(w_TRXDATRICERCA,'D'));
l_oWv.setValue('TRXNAZRES',WtA(w_TRXNAZRES,'C'));
l_oWv.setValue('TRXCITRES',WtA(w_TRXCITRES,'C'));
l_oWv.setValue('TRXDOMICI',WtA(w_TRXDOMICI,'C'));
l_oWv.setValue('TRXTFINLAV',WtA(w_TRXTFINLAV,'T'));
l_oWv.setValue('TRDFINLAV',WtA(w_TRDFINLAV,'D'));
l_oWv.setValue('TRFLGINLAV',WtA(w_TRFLGINLAV,'C'));
l_oWv.setValue('TRXESITO',WtA(w_TRXESITO,'C'));
l_oWv.setValue('TRXAUTRIL',WtA(w_TRXAUTRIL,'C'));
l_oWv.setValue('TRXCODDIP',WtA(w_TRXCODDIP,'C'));
l_oWv.setValue('TRXUTENTE',WtA(w_TRXUTENTE,'N'));
l_oWv.setValue('TRXTINILAV',WtA(w_TRXTINILAV,'T'));
l_oWv.setValue('TRXDINILAV',WtA(w_TRXDINILAV,'D'));
l_oWv.setValue('xMADESCRI',WtA(w_xMADESCRI,'C'));
l_oWv.setValue('doctype',WtA(w_doctype,'C'));
l_oWv.setValue('sesso',WtA(w_sesso,'C'));
l_oWv.setValue('xTRXPROVINCIA',WtA(w_xTRXPROVINCIA,'C'));
l_oWv.setValue('FLGDATIOLD',WtA(w_FLGDATIOLD,'C'));
l_oWv.setValue('xtipdoc',WtA(w_xtipdoc,'C'));
l_oWv.setValue('xtnumdoc',WtA(w_xtnumdoc,'C'));
l_oWv.setValue('xDESCRIZ',WtA(w_xDESCRIZ,'C'));
l_oWv.setValue('finalized',WtA(w_finalized,'C'));
l_oWv.setValue('xluonas',WtA(w_xluonas,'C'));
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
FillWv.n=["TRXCODPRG","TRXCOGNOM","TRXNOME","TRXFLGCF","TRXCODFIS","TRXLUONAS","TRXNUMDOC","TRXDATSCA","TRXDATRIL","TRXTIPDOC","TRXMTCN","TRXDATNAS","TRXDATOPE","TRXFLGCON","TRSSEGNO","TRXIMPORTO","TRXCONTAN","TRXUNIQUE","TRXCOGCON","TRXNOMCON","TRXDESTIN","TRXCODCAS","TRXRECTYPE","TRXCODMAG","TRXCODUNI","TRXSESSO","TRXNASSTATO","TRXNASCOMUN","TRXFLGAUAQ1","TRXFLGAUAQ2","TRXFLGAUAQ3","TRXFLGAUAQ4","TRXFLGAUAQ5","TRXFLGAUA","TRXFLGFOR","TRXFORCE","TRXDATRICERCA","TRXNAZRES","TRXCITRES","TRXDOMICI","TRXTFINLAV","TRDFINLAV","TRFLGINLAV","TRXESITO","TRXAUTRIL","TRXCODDIP","TRXUTENTE","TRXTINILAV","TRXDINILAV","xMADESCRI","doctype","sesso","xTRXPROVINCIA","FLGDATIOLD","xtipdoc","xtnumdoc","xDESCRIZ","finalized","xluonas"];
function SetModified() {
m_bUpdated=true;
}
