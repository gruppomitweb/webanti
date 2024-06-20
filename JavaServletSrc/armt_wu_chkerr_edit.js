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
if (IsDisabledByStateDriver('box_ZQTAJGZBZW')) {
DisableInputsInContainer(Ctrl('ZQTAJGZBZW'),true);
}
if (IsDisabledByStateDriver('OldOnes')) {
DisableInputsInContainer(Ctrl('RSDQEMGAOL'),true);
}
if (IsDisabledByStateDriver('NewOnes')) {
DisableInputsInContainer(Ctrl('JKOQQOCGZL'),true);
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
function Set_WUNBCITCLI(ctrlValue,kmode,e) {
if (Ne(w_WUNBCITCLI,ctrlValue)) {
var ctl = _GetCtl(e,'SQSTTNXNEF');
if (_tracker.goon(ctl,ctrlValue)) {
w_WUNBCITCLI=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SQSTTNXNEF',0);
if (l_bResult) {
l_bResult=Link_SQSTTNXNEF(kmode);
if ( ! (l_bResult)) {
w_WUNBCITCLI=HtW('','C');
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
function Set_WUNCODFIS(ctrlValue,kmode,e) {
if (Ne(w_WUNCODFIS,ctrlValue)) {
var ctl = _GetCtl(e,'UBNCXWNHSA');
if (_tracker.goon(ctl,ctrlValue)) {
w_WUNCODFIS=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UBNCXWNHSA',0);
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
function Set_WUTIPOPE(ctrlValue,kmode,e) {
if (Ne(w_WUTIPOPE,ctrlValue)) {
var ctl = _GetCtl(e,'LDWZRELAZY');
if (_tracker.goon(ctl,ctrlValue)) {
w_WUTIPOPE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('LDWZRELAZY',0);
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
function Set_WUNSDOCCLI(ctrlValue,kmode,e) {
if (Ne(w_WUNSDOCCLI,ctrlValue)) {
var ctl = _GetCtl(e,'YCVYLQBAVQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_WUNSDOCCLI=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YCVYLQBAVQ',0);
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
function Set_WUNTDOCCLI(ctrlValue,kmode,e) {
if (Ne(w_WUNTDOCCLI,ctrlValue)) {
var ctl = _GetCtl(e,'MCJVDAFNOQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_WUNTDOCCLI=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MCJVDAFNOQ',0);
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
function Set_WUNSEXCLI(ctrlValue,kmode,e) {
if (Ne(w_WUNSEXCLI,ctrlValue)) {
var ctl = _GetCtl(e,'TADITPUPOP');
if (_tracker.goon(ctl,ctrlValue)) {
w_WUNSEXCLI=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('TADITPUPOP',0);
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
function Set_WUNSTACLI(ctrlValue,kmode,e) {
if (Ne(w_WUNSTACLI,ctrlValue)) {
var ctl = _GetCtl(e,'WVLDFVKALY');
if (_tracker.goon(ctl,ctrlValue)) {
w_WUNSTACLI=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('WVLDFVKALY',0);
if (l_bResult) {
l_bResult=Link_WVLDFVKALY(kmode);
if ( ! (l_bResult)) {
w_WUNSTACLI=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',30,0,''));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',30,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_WUFLGFRC(ctrlValue,kmode,e) {
if (Ne(w_WUFLGFRC,ctrlValue)) {
var ctl = _GetCtl(e,'YYWDAHCCHA');
if (_tracker.goon(ctl,ctrlValue)) {
w_WUFLGFRC=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YYWDAHCCHA',0);
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
function Set_WUCODICE(ctrlValue,kmode,e) {
if (Ne(w_WUCODICE,ctrlValue)) {
var ctl = _GetCtl(e,'TYZCFXYXSP');
if (_tracker.goon(ctl,ctrlValue)) {
w_WUCODICE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('TYZCFXYXSP',0);
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
function Set_WUNDATOPE(ctrlValue,kmode,e) {
if (Ne(w_WUNDATOPE,ctrlValue)) {
var ctl = _GetCtl(e,'BQFSVTKPAE');
if (_tracker.goon(ctl,ctrlValue)) {
w_WUNDATOPE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BQFSVTKPAE',0);
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
function Set_WUNCAPCLI(ctrlValue,kmode,e) {
if (Ne(w_WUNCAPCLI,ctrlValue)) {
var ctl = _GetCtl(e,'DNFJVJRGTH');
if (_tracker.goon(ctl,ctrlValue)) {
w_WUNCAPCLI=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('DNFJVJRGTH',0);
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
function Set_WUNDATNAS(ctrlValue,kmode,e) {
if (Ne(w_WUNDATNAS,ctrlValue)) {
var ctl = _GetCtl(e,'DJOIOBUZTW');
if (_tracker.goon(ctl,ctrlValue)) {
w_WUNDATNAS=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('DJOIOBUZTW',0);
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
function Set_WUNRDOCCLI(ctrlValue,kmode,e) {
if (Ne(w_WUNRDOCCLI,ctrlValue)) {
var ctl = _GetCtl(e,'PKOBXVTTQB');
if (_tracker.goon(ctl,ctrlValue)) {
w_WUNRDOCCLI=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('PKOBXVTTQB',0);
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
function Set_WUNCITCLI(ctrlValue,kmode,e) {
if (Ne(w_WUNCITCLI,ctrlValue)) {
var ctl = _GetCtl(e,'AZSYSFMRUL');
if (_tracker.goon(ctl,ctrlValue)) {
w_WUNCITCLI=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('AZSYSFMRUL',0);
if (l_bResult) {
l_bResult=Link_AZSYSFMRUL(kmode);
if ( ! (l_bResult)) {
w_WUNCITCLI=HtW('','C');
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
function Set_WUNOTE(ctrlValue,kmode,e) {
if (Ne(w_WUNOTE,ctrlValue)) {
var ctl = _GetCtl(e,'AUBWLVTBES');
if (_tracker.goon(ctl,ctrlValue)) {
w_WUNOTE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('AUBWLVTBES',0);
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
function Set_WUNSTADES(ctrlValue,kmode,e) {
if (Ne(w_WUNSTADES,ctrlValue)) {
var ctl = _GetCtl(e,'DQRQHDIWWC');
if (_tracker.goon(ctl,ctrlValue)) {
w_WUNSTADES=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('DQRQHDIWWC',0);
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
function Set_WUNCODDIP(ctrlValue,kmode,e) {
if (Ne(w_WUNCODDIP,ctrlValue)) {
var ctl = _GetCtl(e,'RPXEDSQTUE');
if (_tracker.goon(ctl,ctrlValue)) {
w_WUNCODDIP=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RPXEDSQTUE',0);
if (l_bResult) {
l_bResult=Link_RPXEDSQTUE(kmode);
if ( ! (l_bResult)) {
w_WUNCODDIP=HtW('','C');
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
function Set_WUNBSTACLI(ctrlValue,kmode,e) {
if (Ne(w_WUNBSTACLI,ctrlValue)) {
var ctl = _GetCtl(e,'GPWUEBYSIT');
if (_tracker.goon(ctl,ctrlValue)) {
w_WUNBSTACLI=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('GPWUEBYSIT',0);
if (l_bResult) {
l_bResult=Link_GPWUEBYSIT(kmode);
if ( ! (l_bResult)) {
w_WUNBSTACLI=HtW('','C');
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
function Set_WUFLGALL(ctrlValue,kmode,e) {
if (Ne(w_WUFLGALL,ctrlValue)) {
var ctl = _GetCtl(e,'ZZOJSEEQWY');
if (_tracker.goon(ctl,ctrlValue)) {
w_WUFLGALL=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ZZOJSEEQWY',0);
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
if ((Ne(o_WUCODMAGE,w_WUCODMAGE))) {
l_bTmpRes=Link_FHWIGGJJLC(null);
}
if ((Ne(o_WUCODDIP,w_WUCODDIP))) {
l_bTmpRes=Link_HHRNUENTOX(null);
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
o_WUCODDIP=w_WUCODDIP;
o_WUCODMAGE=w_WUCODMAGE;
}
function SaveLabelDependsOn() {
}
function Link_RPXEDSQTUE(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_WUNCODDIP);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODDIP',w_WUNCODDIP,6,0);
l_Appl.SetFields('CODDIP');
l_Appl.SetTypes('C');
l_Appl.LinkTable('anadip');
l_Appl.SetID('RPXEDSQTUE');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_WUNCODDIP=l_Appl.GetStringValue('CODDIP',6,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_RPXEDSQTUE_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_RPXEDSQTUE';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_RPXEDSQTUE();
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
function Link_RPXEDSQTUE_Blank() {
w_WUNCODDIP='';
}
function LOpt_RPXEDSQTUE() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('anadip','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODDIP','C'));
l_oWv.setValue('LinkedField',WtA('CODDIP','C'));
l_oWv.setValue('UID',WtA('RPXEDSQTUE','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['RPXEDSQTUE'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('115887692'),'C'));
return l_oWv;
}
function Link_AZSYSFMRUL(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_WUNCITCLI);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CITTA',w_WUNCITCLI,40,0);
l_Appl.SetFields('CITTA,CAP');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbcitta');
l_Appl.SetLinkzoom('armt_citta');
l_Appl.SetID('AZSYSFMRUL');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_WUNCITCLI=l_Appl.GetStringValue('CITTA',40,0);
w_WUNCAPCLI=l_Appl.GetStringValue('CAP',5,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_AZSYSFMRUL_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_AZSYSFMRUL';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_AZSYSFMRUL();
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
function Link_AZSYSFMRUL_Blank() {
w_WUNCITCLI='';
w_WUNCAPCLI='';
}
function LOpt_AZSYSFMRUL() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcitta','C'));
l_oWv.setValue('Linkzoomprg',WtA('armt_citta','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CITTA','C'));
l_oWv.setValue('LinkedField',WtA('CITTA','C'));
l_oWv.setValue('UID',WtA('AZSYSFMRUL','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['AZSYSFMRUL'][1],'C'));
return l_oWv;
}
function Link_GPWUEBYSIT(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_WUNBSTACLI);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('DESCRI',w_WUNBSTACLI,40,0);
l_Appl.SetFields('DESCRI');
l_Appl.SetTypes('C');
l_Appl.LinkTable('tbstati');
l_Appl.SetID('GPWUEBYSIT');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_WUNBSTACLI=l_Appl.GetStringValue('DESCRI',40,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_GPWUEBYSIT_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_GPWUEBYSIT';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_GPWUEBYSIT();
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
function Link_GPWUEBYSIT_Blank() {
w_WUNBSTACLI='';
}
function LOpt_GPWUEBYSIT() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstati','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('DESCRI','C'));
l_oWv.setValue('LinkedField',WtA('DESCRI','C'));
l_oWv.setValue('UID',WtA('GPWUEBYSIT','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['GPWUEBYSIT'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('11580812047'),'C'));
return l_oWv;
}
function Link_SQSTTNXNEF(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_WUNBCITCLI);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CITTA',w_WUNBCITCLI,40,0);
l_Appl.SetFields('CITTA');
l_Appl.SetTypes('C');
l_Appl.LinkTable('tbcitta');
l_Appl.SetID('SQSTTNXNEF');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_WUNBCITCLI=l_Appl.GetStringValue('CITTA',40,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_SQSTTNXNEF_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_SQSTTNXNEF';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_SQSTTNXNEF();
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
function Link_SQSTTNXNEF_Blank() {
w_WUNBCITCLI='';
}
function LOpt_SQSTTNXNEF() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcitta','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CITTA','C'));
l_oWv.setValue('LinkedField',WtA('CITTA','C'));
l_oWv.setValue('UID',WtA('SQSTTNXNEF','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['SQSTTNXNEF'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('15186643'),'C'));
return l_oWv;
}
function Link_FHWIGGJJLC(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_WUCODMAGE);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('MACODICE',w_WUCODMAGE,5,0);
l_Appl.SetFields('MACODICE,MADESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbmacage');
l_Appl.SetLinkzoom('armt_tbmacage');
l_Appl.SetID('FHWIGGJJLC');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_WUCODMAGE=l_Appl.GetStringValue('MACODICE',5,0);
w_xMADESCRI=l_Appl.GetStringValue('MADESCRI',60,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_FHWIGGJJLC_Blank();
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
function Link_FHWIGGJJLC_Blank() {
w_WUCODMAGE='';
w_xMADESCRI='';
}
function LOpt_FHWIGGJJLC() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbmacage','C'));
l_oWv.setValue('Linkzoomprg',WtA('armt_tbmacage','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('MACODICE','C'));
l_oWv.setValue('LinkedField',WtA('MACODICE','C'));
l_oWv.setValue('UID',WtA('FHWIGGJJLC','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['FHWIGGJJLC'][1],'C'));
return l_oWv;
}
function Link_HHRNUENTOX(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_WUCODDIP);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODDIP',w_WUCODDIP,6,0);
l_Appl.SetFields('CODDIP,DESCCIT');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('anadip');
l_Appl.SetLinkzoom('armt_anadip');
l_Appl.SetID('HHRNUENTOX');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_WUCODDIP=l_Appl.GetStringValue('CODDIP',6,0);
w_xDESDIP=l_Appl.GetStringValue('DESCCIT',30,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_HHRNUENTOX_Blank();
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
function Link_HHRNUENTOX_Blank() {
w_WUCODDIP='';
w_xDESDIP='';
}
function LOpt_HHRNUENTOX() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('anadip','C'));
l_oWv.setValue('Linkzoomprg',WtA('armt_anadip','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODDIP','C'));
l_oWv.setValue('LinkedField',WtA('CODDIP','C'));
l_oWv.setValue('UID',WtA('HHRNUENTOX','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['HHRNUENTOX'][1],'C'));
return l_oWv;
}
function Link_WVLDFVKALY(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_WUNSTACLI);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('DESCRI',w_WUNSTACLI,30,0);
l_Appl.SetFields('DESCRI');
l_Appl.SetTypes('C');
l_Appl.LinkTable('tbstati');
l_Appl.SetID('WVLDFVKALY');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_WUNSTACLI=l_Appl.GetStringValue('DESCRI',30,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_WVLDFVKALY_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_WVLDFVKALY';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_WVLDFVKALY();
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
function Link_WVLDFVKALY_Blank() {
w_WUNSTACLI='';
}
function LOpt_WVLDFVKALY() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstati','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('DESCRI','C'));
l_oWv.setValue('LinkedField',WtA('DESCRI','C'));
l_oWv.setValue('UID',WtA('WVLDFVKALY','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['WVLDFVKALY'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('11580812047'),'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'RPXEDSQTUE')) {
last_focused_comp=GetLastFocusedElementOfLink('RPXEDSQTUE');
function SetMethod_RPXEDSQTUE() {
Set_WUNCODDIP(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_RPXEDSQTUE();
} else {
setTimeout(SetMethod_RPXEDSQTUE,1);
}
bResult=true;
}
if (Eq(varName,'AZSYSFMRUL')) {
last_focused_comp=GetLastFocusedElementOfLink('AZSYSFMRUL');
function SetMethod_AZSYSFMRUL() {
Set_WUNCITCLI(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_AZSYSFMRUL();
} else {
setTimeout(SetMethod_AZSYSFMRUL,1);
}
bResult=true;
}
if (Eq(varName,'GPWUEBYSIT')) {
last_focused_comp=GetLastFocusedElementOfLink('GPWUEBYSIT');
function SetMethod_GPWUEBYSIT() {
Set_WUNBSTACLI(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_GPWUEBYSIT();
} else {
setTimeout(SetMethod_GPWUEBYSIT,1);
}
bResult=true;
}
if (Eq(varName,'SQSTTNXNEF')) {
last_focused_comp=GetLastFocusedElementOfLink('SQSTTNXNEF');
function SetMethod_SQSTTNXNEF() {
Set_WUNBCITCLI(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_SQSTTNXNEF();
} else {
setTimeout(SetMethod_SQSTTNXNEF,1);
}
bResult=true;
}
if (Eq(varName,'WVLDFVKALY')) {
last_focused_comp=GetLastFocusedElementOfLink('WVLDFVKALY');
function SetMethod_WVLDFVKALY() {
Set_WUNSTACLI(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_WVLDFVKALY();
} else {
setTimeout(SetMethod_WVLDFVKALY,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'RPXEDSQTUE')) {
return [Ctrl('RPXEDSQTUE')];
}
if (Eq(varName,'AZSYSFMRUL')) {
return [Ctrl('AZSYSFMRUL')];
}
if (Eq(varName,'GPWUEBYSIT')) {
return [Ctrl('GPWUEBYSIT')];
}
if (Eq(varName,'SQSTTNXNEF')) {
return [Ctrl('SQSTTNXNEF')];
}
if (Eq(varName,'WVLDFVKALY')) {
return [Ctrl('WVLDFVKALY')];
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
parent.ZtVWeb.raiseEventToEvalParms('armt_wu_chkerr_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('armt_wu_chkerr_dataNotSent',{'action':formaction});
}
}
}
}
CheckChild.child=[];
function Check() {
var l_bResult = true;
ResetErrorVars();
m_nLastError=0;
if ( ! (_ChkObl('LDWZRELAZY',1))) {
_SignErr('LDWZRELAZY');
m_cLastWorkVarErrorMsg='785086868';
l_bResult=false;
w_WUTIPOPE=HtW('','C');
} else if ( ! (_ChkObl('TYZCFXYXSP',1))) {
_SignErr('TYZCFXYXSP');
m_cLastWorkVarErrorMsg='11446421191';
l_bResult=false;
w_WUCODICE=HtW('','N');
} else if ( ! (_ChkObl('BQFSVTKPAE',1))) {
_SignErr('BQFSVTKPAE');
m_cLastWorkVarErrorMsg='10543538388';
l_bResult=false;
w_WUNDATOPE=HtW('','D');
} else if ( ! (_ChkObl('DNFJVJRGTH',1))) {
_SignErr('DNFJVJRGTH');
m_cLastWorkVarErrorMsg='171367507';
l_bResult=false;
w_WUNCAPCLI=HtW('','C');
} else if ( ! (_ChkObl('DJOIOBUZTW',1))) {
_SignErr('DJOIOBUZTW');
m_cLastWorkVarErrorMsg='11660994966';
l_bResult=false;
w_WUNDATNAS=HtW('','D');
} else if ( ! (_ChkObl('PKOBXVTTQB',1))) {
_SignErr('PKOBXVTTQB');
m_cLastWorkVarErrorMsg='11455142958';
l_bResult=false;
w_WUNRDOCCLI=HtW('','D');
} else if ( ! (_ChkObl('YCVYLQBAVQ',1))) {
_SignErr('YCVYLQBAVQ');
m_cLastWorkVarErrorMsg='10879867155';
l_bResult=false;
w_WUNSDOCCLI=HtW('','D');
} else if ( ! (_ChkObl('MCJVDAFNOQ',1))) {
_SignErr('MCJVDAFNOQ');
m_cLastWorkVarErrorMsg='11429032151';
l_bResult=false;
w_WUNTDOCCLI=HtW('','C');
} else if ( ! (_ChkObl('DQRQHDIWWC',1))) {
_SignErr('DQRQHDIWWC');
m_cLastWorkVarErrorMsg='342798360';
l_bResult=false;
w_WUNSTADES=HtW('','C');
} else if ( ! (_ChkObl('RPXEDSQTUE',1))) {
_SignErr('RPXEDSQTUE');
m_cLastWorkVarErrorMsg='200428503';
l_bResult=false;
w_WUNCODDIP=HtW('','C');
} else if ( ! (_ChkObl('AZSYSFMRUL',1))) {
_SignErr('AZSYSFMRUL');
m_cLastWorkVarErrorMsg='106196876';
l_bResult=false;
w_WUNCITCLI=HtW('','C');
} else if ( ! (_ChkObl('GPWUEBYSIT',1))) {
_SignErr('GPWUEBYSIT');
m_cLastWorkVarErrorMsg='10019062122';
l_bResult=false;
w_WUNBSTACLI=HtW('','C');
} else if ( ! (_ChkObl('SQSTTNXNEF',1))) {
_SignErr('SQSTTNXNEF');
m_cLastWorkVarErrorMsg='1053791145';
l_bResult=false;
w_WUNBCITCLI=HtW('','C');
} else if ( ! (_ChkObl('ZZOJSEEQWY',1))) {
_SignErr('ZZOJSEEQWY');
m_cLastWorkVarErrorMsg='11966900553';
l_bResult=false;
w_WUFLGALL='N';
} else if ( ! (_ChkObl('UBNCXWNHSA',1))) {
_SignErr('UBNCXWNHSA');
m_cLastWorkVarErrorMsg='11921223220';
l_bResult=false;
w_WUNCODFIS=HtW('','C');
} else if ( ! (_ChkObl('AUBWLVTBES',1))) {
_SignErr('AUBWLVTBES');
m_cLastWorkVarErrorMsg='2009784983';
l_bResult=false;
w_WUNOTE=HtW('','M');
} else if ( ! (_ChkObl('YYWDAHCCHA',1))) {
_SignErr('YYWDAHCCHA');
m_cLastWorkVarErrorMsg='10298161835';
l_bResult=false;
w_WUFLGFRC='N';
} else if ( ! (_ChkObl('WVLDFVKALY',1))) {
_SignErr('WVLDFVKALY');
m_cLastWorkVarErrorMsg='11527703892';
l_bResult=false;
w_WUNSTACLI=HtW('','C');
} else if ( ! (_ChkObl('TADITPUPOP',1))) {
_SignErr('TADITPUPOP');
m_cLastWorkVarErrorMsg='1702672879';
l_bResult=false;
w_WUNSEXCLI=HtW('','C');
}
if (l_bResult) {
l_bResult=CheckChild(0);
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('RPXEDSQTUE_ZOOM',lc)) {
return 0;
}
if (Eq('RPXEDSQTUE',lc)) {
return 0;
}
if (Eq('AZSYSFMRUL_ZOOM',lc)) {
return 1;
}
if (Eq('AZSYSFMRUL',lc)) {
return 1;
}
if (Eq('GPWUEBYSIT_ZOOM',lc)) {
return 2;
}
if (Eq('GPWUEBYSIT',lc)) {
return 2;
}
if (Eq('SQSTTNXNEF_ZOOM',lc)) {
return 3;
}
if (Eq('SQSTTNXNEF',lc)) {
return 3;
}
if (Eq('WVLDFVKALY_ZOOM',lc)) {
return 4;
}
if (Eq('WVLDFVKALY',lc)) {
return 4;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_RPXEDSQTUE();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,1)) {
l_oWv=LOpt_AZSYSFMRUL();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,2)) {
l_oWv=LOpt_GPWUEBYSIT();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,3)) {
l_oWv=LOpt_SQSTTNXNEF();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,4)) {
l_oWv=LOpt_WVLDFVKALY();
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
l_oWv.setValue('WUNOMEFILE',WtA(w_WUNOMEFILE,'C'));
l_oWv.setValue('WURIFMTCN',WtA(w_WURIFMTCN,'C'));
l_oWv.setValue('WUTIPOPE',WtA(w_WUTIPOPE,'C'));
l_oWv.setValue('WUCODDIP',WtA(w_WUCODDIP,'C'));
l_oWv.setValue('WUDATOPE',WtA(w_WUDATOPE,'C'));
l_oWv.setValue('WUIMPORTO',WtA(w_WUIMPORTO,'N'));
l_oWv.setValue('WUSTADES',WtA(w_WUSTADES,'C'));
l_oWv.setValue('WUTIPERR',WtA(w_WUTIPERR,'C'));
l_oWv.setValue('WUCODICE',WtA(w_WUCODICE,'N'));
l_oWv.setValue('WUNDATOPE',WtA(w_WUNDATOPE,'D'));
l_oWv.setValue('WUNCAPCLI',WtA(w_WUNCAPCLI,'C'));
l_oWv.setValue('WUNDATNAS',WtA(w_WUNDATNAS,'D'));
l_oWv.setValue('WUNRDOCCLI',WtA(w_WUNRDOCCLI,'D'));
l_oWv.setValue('WUNSDOCCLI',WtA(w_WUNSDOCCLI,'D'));
l_oWv.setValue('WUNTDOCCLI',WtA(w_WUNTDOCCLI,'C'));
l_oWv.setValue('WUNSTADES',WtA(w_WUNSTADES,'C'));
l_oWv.setValue('WUNCODDIP',WtA(w_WUNCODDIP,'C'));
l_oWv.setValue('WUNCITCLI',WtA(w_WUNCITCLI,'C'));
l_oWv.setValue('WUNBSTACLI',WtA(w_WUNBSTACLI,'C'));
l_oWv.setValue('WUNBCITCLI',WtA(w_WUNBCITCLI,'C'));
l_oWv.setValue('WUNOMCLI',WtA(w_WUNOMCLI,'C'));
l_oWv.setValue('WUCOGCLI',WtA(w_WUCOGCLI,'C'));
l_oWv.setValue('WUCITCLI',WtA(w_WUCITCLI,'C'));
l_oWv.setValue('WUCAPCLI',WtA(w_WUCAPCLI,'C'));
l_oWv.setValue('WUINDCLI',WtA(w_WUINDCLI,'C'));
l_oWv.setValue('WUNOMCON',WtA(w_WUNOMCON,'C'));
l_oWv.setValue('WUCOGCON',WtA(w_WUCOGCON,'C'));
l_oWv.setValue('WUBCITCLI',WtA(w_WUBCITCLI,'C'));
l_oWv.setValue('WUBSTACLI',WtA(w_WUBSTACLI,'C'));
l_oWv.setValue('WUDATNAS',WtA(w_WUDATNAS,'C'));
l_oWv.setValue('WUCODFIS',WtA(w_WUCODFIS,'C'));
l_oWv.setValue('WUNDOCCLI',WtA(w_WUNDOCCLI,'C'));
l_oWv.setValue('WUADOCRIL',WtA(w_WUADOCRIL,'C'));
l_oWv.setValue('WURDOCCLI',WtA(w_WURDOCCLI,'C'));
l_oWv.setValue('WUSDOCCLI',WtA(w_WUSDOCCLI,'C'));
l_oWv.setValue('WUSEXCLI',WtA(w_WUSEXCLI,'C'));
l_oWv.setValue('WUTDOCCLI',WtA(w_WUTDOCCLI,'C'));
l_oWv.setValue('WUFLGALL',WtA(w_WUFLGALL,'C'));
l_oWv.setValue('WUNCODFIS',WtA(w_WUNCODFIS,'C'));
l_oWv.setValue('WUCODMAGE',WtA(w_WUCODMAGE,'C'));
l_oWv.setValue('WUNOTE',WtA(w_WUNOTE,'M'));
l_oWv.setValue('WUFLGFRC',WtA(w_WUFLGFRC,'C'));
l_oWv.setValue('WUORIGCF',WtA(w_WUORIGCF,'C'));
l_oWv.setValue('WUSTACLI',WtA(w_WUSTACLI,'C'));
l_oWv.setValue('WUNSTACLI',WtA(w_WUNSTACLI,'C'));
l_oWv.setValue('WUNSEXCLI',WtA(w_WUNSEXCLI,'C'));
l_oWv.setValue('xMADESCRI',WtA(w_xMADESCRI,'C'));
l_oWv.setValue('xDESDIP',WtA(w_xDESDIP,'C'));
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
FillWv.n=["WUNOMEFILE","WURIFMTCN","WUTIPOPE","WUCODDIP","WUDATOPE","WUIMPORTO","WUSTADES","WUTIPERR","WUCODICE","WUNDATOPE","WUNCAPCLI","WUNDATNAS","WUNRDOCCLI","WUNSDOCCLI","WUNTDOCCLI","WUNSTADES","WUNCODDIP","WUNCITCLI","WUNBSTACLI","WUNBCITCLI","WUNOMCLI","WUCOGCLI","WUCITCLI","WUCAPCLI","WUINDCLI","WUNOMCON","WUCOGCON","WUBCITCLI","WUBSTACLI","WUDATNAS","WUCODFIS","WUNDOCCLI","WUADOCRIL","WURDOCCLI","WUSDOCCLI","WUSEXCLI","WUTDOCCLI","WUFLGALL","WUNCODFIS","WUCODMAGE","WUNOTE","WUFLGFRC","WUORIGCF","WUSTACLI","WUNSTACLI","WUNSEXCLI","xMADESCRI","xDESDIP"];
function SetModified() {
m_bUpdated=true;
}
