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
l_bEnabled= ! (false) || Eq(m_cFunction,'edit') || IsDisabledByStateDriver('SNAINUMOPE');
SetDisabled('XFUOZLSACP',l_bEnabled);
l_bEnabled= ! (false) || IsDisabledByStateDriver('CGONOTCON');
SetDisabled('MVSSLZXHUW',l_bEnabled);
if (IsDisabledByStateDriver('Base')) {
DisableInputsInContainer(Ctrl('CCUOYXMBZC'),true);
}
if (IsDisabledByStateDriver('Operazione')) {
DisableInputsInContainer(Ctrl('YORQOIOBQN'),true);
}
if (IsDisabledByStateDriver('Soggetto')) {
DisableInputsInContainer(Ctrl('AQSQVBKXAL'),true);
}
if (IsDisabledByStateDriver('box_XWJLXLYKJC')) {
DisableInputsInContainer(Ctrl('XWJLXLYKJC'),true);
}
if (IsDisabledByStateDriver('box_NYSCBMMEEX')) {
DisableInputsInContainer(Ctrl('NYSCBMMEEX'),true);
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
function Set_tipop(ctrlValue,kmode,e) {
if (Ne(w_tipop,ctrlValue)) {
var ctl = _GetCtl(e,'OZGWRQKOZF');
if (_tracker.goon(ctl,ctrlValue)) {
w_tipop=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('OZGWRQKOZF',0);
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
function Set_DOC04(ctrlValue,kmode,e) {
if (Ne(w_DOC04,ctrlValue)) {
var ctl = _GetCtl(e,'SIRTAMVPQN');
if (_tracker.goon(ctl,ctrlValue)) {
w_DOC04=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SIRTAMVPQN',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',80,0,'');
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
l_bResult=_ChkObl('YLIKFVPZJA',0);
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
function Set_NUMOPEDL(ctrlValue,kmode,e) {
if (Ne(w_NUMOPEDL,ctrlValue)) {
var ctl = _GetCtl(e,'HILLZZMRNQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_NUMOPEDL=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HILLZZMRNQ',0);
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
function Set_DOC03(ctrlValue,kmode,e) {
if (Ne(w_DOC03,ctrlValue)) {
var ctl = _GetCtl(e,'PAADFVDPUD');
if (_tracker.goon(ctl,ctrlValue)) {
w_DOC03=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('PAADFVDPUD',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',80,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_verifica(ctrlValue,kmode,e) {
if (Ne(w_verifica,ctrlValue)) {
var ctl = _GetCtl(e,'PUBAAWPVMH');
if (_tracker.goon(ctl,ctrlValue)) {
w_verifica=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('PUBAAWPVMH',0);
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
function Set_FLGDOCALL(ctrlValue,kmode,e) {
if (Ne(w_FLGDOCALL,ctrlValue)) {
var ctl = _GetCtl(e,'ZUVVNOUSIQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLGDOCALL=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ZUVVNOUSIQ',0);
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
function Set_SNAINUMOPE(ctrlValue,kmode,e) {
if (Ne(w_SNAINUMOPE,ctrlValue)) {
var ctl = _GetCtl(e,'XFUOZLSACP');
if (_tracker.goon(ctl,ctrlValue)) {
w_SNAINUMOPE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XFUOZLSACP',0);
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
function Set_CGONOTCON(ctrlValue,kmode,e) {
if (Ne(w_CGONOTCON,ctrlValue)) {
var ctl = _GetCtl(e,'MVSSLZXHUW');
if (_tracker.goon(ctl,ctrlValue)) {
w_CGONOTCON=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MVSSLZXHUW',0);
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
function Calculate() {
var l_bTmpRes;
var l_bResult = true;
m_bCalculating=true;
if ((Ne(o_TIPOGIOCO,w_TIPOGIOCO))) {
l_bTmpRes=Link_QZTTRBWAQL(null);
}
w_TIPOPERS='P';
if ((Ne(o_NASCOMUN,w_NASCOMUN))) {
l_bTmpRes=Link_NEUBQNUEOJ(null);
}
if ((Ne(o_NASSTATO,w_NASSTATO))) {
l_bTmpRes=Link_HODZKKOSYW(null);
}
if ((Ne(o_PAESE,w_PAESE)) || (Ne(o_DESCCIT,w_DESCCIT))) {
l_bTmpRes=Link_ODAYKSRECA(null);
}
if ((Ne(o_ATTIV,w_ATTIV))) {
l_bTmpRes=Link_SAQTIHOALW(null);
}
w_SOTGRUP='600';
if ((Ne(o_SOTGRUP,w_SOTGRUP))) {
w_SETTSINT='600';
}
if ((Ne(o_TIPOOPRAP,w_TIPOOPRAP))) {
l_bTmpRes=Link_UJRFWINIVQ(null);
}
if ((Ne(o_CODANA,w_CODANA))) {
l_bTmpRes=Link_SQVJLYRFKQ(null);
}
if ((Ne(o_CODANA,w_CODANA)) || (Ne(o_CODVOC,w_CODVOC))) {
l_bTmpRes=Link_SRWWPHPCUB(null);
}
w_VALUTA='242';
w_CAMBIO=1;
w_CONNESCLI=w_CODFISC;
w_CONNESBEN=w_CODFISC;
l_bTmpRes=Link_ULVCBLFVEU(null);
if ((Ne(o_CONNESBEN,w_CONNESBEN)) || (Ne(o_C_CTA,w_C_CTA))) {
l_bTmpRes=Link_KUPRRTVLKH(null);
}
w_CODINTER=w_gIntemediario;
l_bTmpRes=Link_WJSVGWKSFC(null);
if ((Ne(o_CODDIPE,w_CODDIPE))) {
l_bTmpRes=Link_AVHTGZTOSZ(null);
}
if ((Ne(o_COLLEG,w_COLLEG))) {
l_bTmpRes=Link_MSGBKOOAOY(null);
}
if ((Ne(o_CODVOC,w_CODVOC))) {
l_bTmpRes=Link_LKEDJRUQJU(null);
}
if ((Ne(o_idcitta,w_idcitta))) {
l_bTmpRes=Link_XPSJTIMTNR(null);
}
if ((Ne(o_CACODICE,w_CACODICE))) {
l_bTmpRes=Link_WJQFIEBCQV(null);
}
if ((Ne(o_TIPODOC,w_TIPODOC))) {
l_bTmpRes=Link_MBGANUUHRA(null);
}
if ((Ne(o_RDCODAUT,w_RDCODAUT))) {
l_bTmpRes=Link_YDUQCBNYFV(null);
}
w_AUTRILASC=Upper(LRTrim(w_xARDESCRI)+' '+LRTrim(w_RDLOCAUT));
if ((Ne(o_PAESE2,w_PAESE2))) {
l_bTmpRes=Link_UOOQYQWWNG(null);
}
if ((Ne(o_PAESE,w_PAESE)) || (Ne(o_DESCCIT2,w_DESCCIT2))) {
l_bTmpRes=Link_BVEIQEJCLQ(null);
}
w_PrtDocAll.Calculate(w_IDDOCALL,w_TIPOGIOCO,w_TOTLIRE,w_TOTCONT,w_FLGDOCALL,w_DOC03,w_DOC04,w_CAIDBIGLIETTO);
LibJavascript.forEachItem(m_FoundlingCopyWorkVar,i_body_1)
function i_body_1(child){
child();
}
// * --- Area Manuale = UI - Calculate
// * --- Fine Area Manuale
m_bCalculating=false;
}
function SaveDependsOn() {
o_TIPOGIOCO=w_TIPOGIOCO;
o_NASCOMUN=w_NASCOMUN;
o_NASSTATO=w_NASSTATO;
o_PAESE=w_PAESE;
o_DESCCIT=w_DESCCIT;
o_ATTIV=w_ATTIV;
o_SOTGRUP=w_SOTGRUP;
o_DATAOPE=w_DATAOPE;
o_TIPOOPRAP=w_TIPOOPRAP;
o_CODANA=w_CODANA;
o_CODVOC=w_CODVOC;
o_CONNESBEN=w_CONNESBEN;
o_C_CTA=w_C_CTA;
o_CODDIPE=w_CODDIPE;
o_COLLEG=w_COLLEG;
o_idcitta=w_idcitta;
o_CACODICE=w_CACODICE;
o_TIPODOC=w_TIPODOC;
o_RDCODAUT=w_RDCODAUT;
o_RDLOCAUT=w_RDLOCAUT;
o_PAESE2=w_PAESE2;
o_DESCCIT2=w_DESCCIT2;
}
function SaveLabelDependsOn() {
}
function Link_QZTTRBWAQL(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_TIPOGIOCO);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODTPGIO',w_TIPOGIOCO,3,0);
l_Appl.SetFields('CODTPGIO,SOGTPGIO,DEFTPGIO,EDTTPGIO,EDTSPGIO,DEFSPGIO,FLGPLGIO');
l_Appl.SetTypes('C,N,C,C,C,C,C');
l_Appl.LinkTable('cgo_tbtipgio');
l_Appl.SetLinkzoom('armt_cgo_tbtipgio');
l_Appl.SetID('QZTTRBWAQL');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_TIPOGIOCO=l_Appl.GetStringValue('CODTPGIO',3,0);
w_xSOGTPGIO=l_Appl.GetDoubleValue('SOGTPGIO',12,2);
w_xDEFTPGIO=l_Appl.GetStringValue('DEFTPGIO',1,0);
w_xEDTTPGIO=l_Appl.GetStringValue('EDTTPGIO',1,0);
w_xEDTSPGIO=l_Appl.GetStringValue('EDTSPGIO',1,0);
w_xDEFSPGIO=l_Appl.GetStringValue('DEFSPGIO',1,0);
w_xFLGPLGIO=l_Appl.GetStringValue('FLGPLGIO',1,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_QZTTRBWAQL_Blank();
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
function Link_QZTTRBWAQL_Blank() {
w_TIPOGIOCO='';
w_xSOGTPGIO=0;
w_xDEFTPGIO='';
w_xEDTTPGIO='';
w_xEDTSPGIO='';
w_xDEFSPGIO='';
w_xFLGPLGIO='';
}
function LOpt_QZTTRBWAQL() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('cgo_tbtipgio','C'));
l_oWv.setValue('Linkzoomprg',WtA('armt_cgo_tbtipgio','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODTPGIO','C'));
l_oWv.setValue('LinkedField',WtA('CODTPGIO','C'));
l_oWv.setValue('UID',WtA('QZTTRBWAQL','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['QZTTRBWAQL'][1],'C'));
return l_oWv;
}
function Sugg_NEUBQNUEOJ(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_Appl = LinkApplet();
var l_bEmp = Empty(HtW(Ctrl('NEUBQNUEOJ').value,'C'));
l_Appl.SetStringKey('CITTA',HtW(Ctrl('NEUBQNUEOJ').value,'C'),30,0);
l_Appl.SetFields('CITTA,PROV');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbcitta');
l_Appl.SetID('NEUBQNUEOJ');
l_Appl.SetMode('suggest');
l_Appl.SetRows('15');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
var res = l_Appl.GetJSONData();
SuggesterLib.render_suggest(res,'NEUBQNUEOJ','NEUBQNUEOJ',false,'AQSQVBKXAL_DIV','AQSQVBKXAL_HEADER',0);
return l_bResult;
}
SuggesterLib.select_suggest.NEUBQNUEOJ=["NASCOMUN",[null],function(newval) { return HtW(newval,'C')}];
function Link_NEUBQNUEOJ(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_NASCOMUN);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CITTA',w_NASCOMUN,30,0);
l_Appl.SetFields('CITTA,PROV');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbcitta');
l_Appl.SetID('NEUBQNUEOJ');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_NASCOMUN=l_Appl.GetStringValue('CITTA',30,0);
w_TIPINTER=l_Appl.GetStringValue('PROV',2,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_NEUBQNUEOJ_Blank();
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
function Link_NEUBQNUEOJ_Blank() {
w_TIPINTER='';
}
function LOpt_NEUBQNUEOJ() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcitta','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CITTA','C'));
l_oWv.setValue('LinkedField',WtA('CITTA','C'));
l_oWv.setValue('UID',WtA('NEUBQNUEOJ','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['NEUBQNUEOJ'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('15186643'),'C'));
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
l_Appl.LinkTable('tbstati');
l_Appl.SetID('HODZKKOSYW');
l_Appl.SetMode('suggest');
l_Appl.SetRows('15');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
var res = l_Appl.GetJSONData();
SuggesterLib.render_suggest(res,'HODZKKOSYW','HODZKKOSYW',false,'AQSQVBKXAL_DIV','AQSQVBKXAL_HEADER',0);
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
l_Appl.LinkTable('tbstati');
l_Appl.SetID('HODZKKOSYW');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_NASSTATO=l_Appl.GetStringValue('DESCRI',30,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_HODZKKOSYW_Blank();
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
function Link_HODZKKOSYW_Blank() {
}
function LOpt_HODZKKOSYW() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstati','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('DESCRI','C'));
l_oWv.setValue('LinkedField',WtA('DESCRI','C'));
l_oWv.setValue('UID',WtA('HODZKKOSYW','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['HODZKKOSYW'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('7383187'),'C'));
return l_oWv;
}
function Sugg_YVIKEGPYPM(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_Appl = LinkApplet();
var l_bEmp = Empty(HtW(Ctrl('YVIKEGPYPM').value,'C'));
l_Appl.SetFixedKeyName('PKTBSTATI');
l_Appl.SetStringKey('PKTBSTATI',w_PAESE,3,0);
l_Appl.SetStringKey('CITTA',HtW(Ctrl('YVIKEGPYPM').value,'C'),40,0);
l_Appl.SetFields('CITTA,IDBASE');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbcitta');
l_Appl.SetID('ODAYKSRECA');
l_Appl.SetMode('suggest');
l_Appl.SetRows('15');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
var res = l_Appl.GetJSONData();
SuggesterLib.render_suggest(res,'YVIKEGPYPM','YVIKEGPYPM',false,'AQSQVBKXAL_DIV','AQSQVBKXAL_HEADER',0);
return l_bResult;
}
SuggesterLib.select_suggest.YVIKEGPYPM=["DESCCIT",["w_PAESE", null, null],function(newval) { return HtW(newval,'C')}];
function Link_YVIKEGPYPM(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_PAESE);
var l_Appl = LinkApplet();
l_Appl.SetFixedKeyName('PKTBSTATI');
l_Appl.SetStringKey('PKTBSTATI',w_PAESE,3,0);
l_Appl.SetStringKey('CITTA','',40,0);
l_Appl.SetFields('CITTA,IDBASE');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbcitta');
l_Appl.SetID('ODAYKSRECA');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_DESCCIT=l_Appl.GetStringValue('CITTA',40,0);
w_idcitta=l_Appl.GetStringValue('IDBASE',10,0);
w_PAESE=(Ne('',w_DESCCIT)?l_Appl.GetStringValue('PKTBSTATI',3,0):w_PAESE);
l_Appl.GetLinkHash(m_CheckVars);
} else {
l_bResult=true;
}
if ( ! (l_bResult)) {
if (m_bAskFixedKeyConfirm &&  ! (WindowConfirm(Translate('MSG_VALUE_NOT_FOUND_CONFIRM')))) {
Link_YVIKEGPYPM_Blank();
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
l_oWv.setValue('Table',WtA('tbcitta','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('PKTBSTATI,CITTA','C'));
l_oWv.setValue('LinkedField',WtA('CITTA','C'));
l_oWv.setValue('UID',WtA('YVIKEGPYPM','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['ODAYKSRECA'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('15186643'),'C'));
return l_oWv;
}
function Sugg_ODAYKSRECA(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_Appl = LinkApplet();
var l_bEmp = Empty(HtW(Ctrl('ODAYKSRECA').value,'C'));
l_Appl.SetStringKey('PKTBSTATI',w_PAESE,3,0);
l_Appl.SetStringKey('CITTA',HtW(Ctrl('ODAYKSRECA').value,'C'),40,0);
l_Appl.SetFields('CITTA,IDBASE');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbcitta');
l_Appl.SetID('ODAYKSRECA');
l_Appl.SetMode('suggest');
l_Appl.SetRows('15');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
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
l_Appl.SetStringKey('PKTBSTATI',w_PAESE,3,0);
l_Appl.SetStringKey('CITTA',w_DESCCIT,40,0);
l_Appl.SetFields('CITTA,IDBASE');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbcitta');
l_Appl.SetID('ODAYKSRECA');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_DESCCIT=l_Appl.GetStringValue('CITTA',40,0);
w_idcitta=l_Appl.GetStringValue('IDBASE',10,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_ODAYKSRECA_Blank();
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
function Link_ODAYKSRECA_Blank() {
w_idcitta='';
}
function LOpt_ODAYKSRECA() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcitta','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('PKTBSTATI,CITTA','C'));
l_oWv.setValue('LinkedField',WtA('CITTA','C'));
l_oWv.setValue('UID',WtA('ODAYKSRECA','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['ODAYKSRECA'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('15186643'),'C'));
return l_oWv;
}
function Link_SAQTIHOALW(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_ATTIV);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODICE',w_ATTIV,10,0);
l_Appl.SetFields('CODICE,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbtipatt');
l_Appl.SetID('SAQTIHOALW');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_ATTIV=l_Appl.GetStringValue('CODICE',10,0);
w_xdesctipatt=l_Appl.GetStringValue('DESCRI',250,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_SAQTIHOALW_Blank();
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
function Link_SAQTIHOALW_Blank() {
w_ATTIV='';
w_xdesctipatt='';
}
function LOpt_SAQTIHOALW() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbtipatt','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODICE','C'));
l_oWv.setValue('LinkedField',WtA('CODICE','C'));
l_oWv.setValue('UID',WtA('SAQTIHOALW','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['SAQTIHOALW'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('484567773'),'C'));
return l_oWv;
}
function Link_UJRFWINIVQ(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_TIPOOPRAP);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODICE',w_TIPOOPRAP,2,0);
l_Appl.SetFields('CODICE,DES1');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbtipreg');
l_Appl.SetID('UJRFWINIVQ');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_TIPOOPRAP=l_Appl.GetStringValue('CODICE',2,0);
w_xdes1=l_Appl.GetStringValue('DES1',90,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_UJRFWINIVQ_Blank();
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
function Link_UJRFWINIVQ_Blank() {
w_TIPOOPRAP='';
w_xdes1='';
}
function LOpt_UJRFWINIVQ() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbtipreg','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODICE','C'));
l_oWv.setValue('LinkedField',WtA('CODICE','C'));
l_oWv.setValue('UID',WtA('UJRFWINIVQ','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['UJRFWINIVQ'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('995100987'),'C'));
return l_oWv;
}
function Link_SQVJLYRFKQ(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CODANA);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODCAU',w_CODANA,4,0);
l_Appl.SetFields('CODCAU');
l_Appl.SetTypes('C');
l_Appl.LinkTable('tbcauana');
l_Appl.SetID('SQVJLYRFKQ');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CODANA=l_Appl.GetStringValue('CODCAU',4,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_SQVJLYRFKQ_Blank();
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
function Link_SQVJLYRFKQ_Blank() {
w_CODANA='';
}
function LOpt_SQVJLYRFKQ() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcauana','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODCAU','C'));
l_oWv.setValue('LinkedField',WtA('CODCAU','C'));
l_oWv.setValue('UID',WtA('SQVJLYRFKQ','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['SQVJLYRFKQ'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('282647084'),'C'));
return l_oWv;
}
function Link_SRWWPHPCUB(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CODVOC);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODCAU',w_CODANA,4,0);
l_Appl.SetStringKey('CAUSINT',w_CODVOC,2,0);
l_Appl.SetFields('CAUSINT,SEGNO,DESCRI');
l_Appl.SetTypes('C,C,C');
l_Appl.LinkTable('tbcauana');
l_Appl.SetID('SRWWPHPCUB');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CODVOC=l_Appl.GetStringValue('CAUSINT',2,0);
w_SEGNO=l_Appl.GetStringValue('SEGNO',1,0);
w_desccauana=l_Appl.GetStringValue('DESCRI',165,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_SRWWPHPCUB_Blank();
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
function Link_SRWWPHPCUB_Blank() {
w_CODVOC='';
w_SEGNO='';
w_desccauana='';
}
function LOpt_SRWWPHPCUB() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcauana','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODCAU,CAUSINT','C'));
l_oWv.setValue('LinkedField',WtA('CAUSINT','C'));
l_oWv.setValue('UID',WtA('SRWWPHPCUB','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['SRWWPHPCUB'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('282420974'),'C'));
return l_oWv;
}
function Link_ULVCBLFVEU(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CONNESBEN);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CONNES',w_CONNESBEN,16,0);
l_Appl.SetFields('CONNES,RAGSOC,DOMICILIO,DESCCIT,PROVINCIA,PAESE,CAP');
l_Appl.SetTypes('C,C,C,C,C,C,C');
l_Appl.LinkTable('personbo');
l_Appl.SetID('ULVCBLFVEU');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CONNESBEN=l_Appl.GetStringValue('CONNES',16,0);
w_C_RAG=l_Appl.GetStringValue('RAGSOC',70,0);
w_C_IND=l_Appl.GetStringValue('DOMICILIO',35,0);
w_C_CTA=l_Appl.GetStringValue('DESCCIT',30,0);
w_C_PRV=l_Appl.GetStringValue('PROVINCIA',2,0);
w_C_STA=l_Appl.GetStringValue('PAESE',3,0);
w_C_CAP=l_Appl.GetStringValue('CAP',5,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_ULVCBLFVEU_Blank();
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
function Link_ULVCBLFVEU_Blank() {
w_CONNESBEN='';
w_C_RAG='';
w_C_IND='';
w_C_CTA='';
w_C_PRV='';
w_C_STA='';
w_C_CAP='';
}
function LOpt_ULVCBLFVEU() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('personbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CONNES','C'));
l_oWv.setValue('LinkedField',WtA('CONNES','C'));
l_oWv.setValue('UID',WtA('ULVCBLFVEU','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['ULVCBLFVEU'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('1890893827'),'C'));
return l_oWv;
}
function Link_KUPRRTVLKH(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_C_CTA);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CITTA',w_C_CTA,30,0);
l_Appl.SetFields('CITTA,CAB,PROV,PKTBSTATI,CAP');
l_Appl.SetTypes('C,C,C,C,C');
l_Appl.LinkTable('tbcitta');
l_Appl.SetID('KUPRRTVLKH');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_C_CTA=l_Appl.GetStringValue('CITTA',30,0);
w_C_CAB=l_Appl.GetStringValue('CAB',6,0);
w_C_PRV=l_Appl.GetStringValue('PROV',2,0);
w_C_STA=l_Appl.GetStringValue('PKTBSTATI',3,0);
w_C_CAP=l_Appl.GetStringValue('CAP',5,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_KUPRRTVLKH_Blank();
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
function Link_KUPRRTVLKH_Blank() {
w_C_CAB='';
w_C_PRV='';
w_C_STA='';
w_C_CAP='';
}
function LOpt_KUPRRTVLKH() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcitta','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CITTA','C'));
l_oWv.setValue('LinkedField',WtA('CITTA','C'));
l_oWv.setValue('UID',WtA('KUPRRTVLKH','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['KUPRRTVLKH'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('15186643'),'C'));
return l_oWv;
}
function Link_WJSVGWKSFC(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CODINTER);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODINTER',w_CODINTER,11,0);
l_Appl.SetFields('CODINTER,DATANASC,CODCAB,PROVINCIA,DESCCIT');
l_Appl.SetTypes('C,D,C,C,C');
l_Appl.LinkTable('intermbo');
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
}
function LOpt_WJSVGWKSFC() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('intermbo','C'));
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
l_Appl.SetFields('CODDIP,DESCRIZ,DESCCIT,PROVINCIA,CAB,TELEFONO,CODLOC');
l_Appl.SetTypes('C,C,C,C,C,C,C');
l_Appl.LinkTable('anadip');
l_Appl.SetID('AVHTGZTOSZ');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CODDIPE=l_Appl.GetStringValue('CODDIP',6,0);
w_xDescDipe=l_Appl.GetStringValue('DESCRIZ',30,0);
w_CITDIP=l_Appl.GetStringValue('DESCCIT',30,0);
w_PROVDIP=l_Appl.GetStringValue('PROVINCIA',2,0);
w_CABDIP=l_Appl.GetStringValue('CAB',6,0);
w_TELDIP=l_Appl.GetStringValue('TELEFONO',15,0);
w_CODLOC=l_Appl.GetStringValue('CODLOC',25,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_AVHTGZTOSZ_Blank();
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
function Link_AVHTGZTOSZ_Blank() {
w_CODDIPE='';
w_xDescDipe='';
w_CITDIP='';
w_PROVDIP='';
w_CABDIP='';
w_TELDIP='';
w_CODLOC='';
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
function Link_MSGBKOOAOY(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_COLLEG);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('NUMPROG',w_COLLEG,11,0);
l_Appl.SetFields('NUMPROG');
l_Appl.SetTypes('C');
l_Appl.LinkTable('operazbo');
l_Appl.SetLinkzoom('armt_operazioni');
l_Appl.SetID('MSGBKOOAOY');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_COLLEG=l_Appl.GetStringValue('NUMPROG',11,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_MSGBKOOAOY_Blank();
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
function Link_MSGBKOOAOY_Blank() {
w_COLLEG='';
}
function LOpt_MSGBKOOAOY() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('operazbo','C'));
l_oWv.setValue('Linkzoomprg',WtA('armt_operazioni','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('NUMPROG','C'));
l_oWv.setValue('LinkedField',WtA('NUMPROG','C'));
l_oWv.setValue('UID',WtA('MSGBKOOAOY','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['MSGBKOOAOY'][1],'C'));
return l_oWv;
}
function Link_LKEDJRUQJU(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CODVOC);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODVOC',w_CODVOC,2,0);
l_Appl.SetFields('CODVOC,DESCRIZ');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbcausin');
l_Appl.SetID('LKEDJRUQJU');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CODVOC=l_Appl.GetStringValue('CODVOC',2,0);
w_xdesccausin=l_Appl.GetStringValue('DESCRIZ',165,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_LKEDJRUQJU_Blank();
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
function Link_LKEDJRUQJU_Blank() {
w_CODVOC='';
w_xdesccausin='';
}
function LOpt_LKEDJRUQJU() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcausin','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODVOC','C'));
l_oWv.setValue('LinkedField',WtA('CODVOC','C'));
l_oWv.setValue('UID',WtA('LKEDJRUQJU','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['LKEDJRUQJU'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('282420974'),'C'));
return l_oWv;
}
function Link_XPSJTIMTNR(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_idcitta);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('IDBASE',w_idcitta,10,0);
l_Appl.SetFields('IDBASE,CAB,PROV,CAP');
l_Appl.SetTypes('C,C,C,C');
l_Appl.LinkTable('tbcitta');
l_Appl.SetID('XPSJTIMTNR');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_idcitta=l_Appl.GetStringValue('IDBASE',10,0);
w_CODCAB=l_Appl.GetStringValue('CAB',6,0);
w_PROVINCIA=l_Appl.GetStringValue('PROV',2,0);
w_CAP=l_Appl.GetStringValue('CAP',9,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_XPSJTIMTNR_Blank();
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
function Link_XPSJTIMTNR_Blank() {
w_idcitta='';
w_CODCAB='';
w_PROVINCIA='';
w_CAP='';
}
function LOpt_XPSJTIMTNR() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcitta','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('IDBASE','C'));
l_oWv.setValue('LinkedField',WtA('IDBASE','C'));
l_oWv.setValue('UID',WtA('XPSJTIMTNR','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['XPSJTIMTNR'][1],'C'));
return l_oWv;
}
function Link_WJQFIEBCQV(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CACODICE);
var l_Appl = LinkApplet();
l_Appl.SetDoubleKey('CACODICE',w_CACODICE,5,0);
l_Appl.SetFields('CACODICE,CAFLGOPE');
l_Appl.SetTypes('N,C');
l_Appl.LinkTable('cgo_causali');
l_Appl.SetLinkzoom('armt_cgo_causali');
l_Appl.SetID('WJQFIEBCQV');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CACODICE=l_Appl.GetDoubleValue('CACODICE',5,0);
w_CAFLGOPE=l_Appl.GetStringValue('CAFLGOPE',1,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_WJQFIEBCQV_Blank();
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
function Link_WJQFIEBCQV_Blank() {
w_CACODICE=0;
w_CAFLGOPE='';
}
function LOpt_WJQFIEBCQV() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('cgo_causali','C'));
l_oWv.setValue('Linkzoomprg',WtA('armt_cgo_causali','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CACODICE','C'));
l_oWv.setValue('LinkedField',WtA('CACODICE','C'));
l_oWv.setValue('UID',WtA('WJQFIEBCQV','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['WJQFIEBCQV'][1],'C'));
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
l_Appl.LinkTable('cgo_tipdoc');
l_Appl.SetID('MBGANUUHRA');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_TIPODOC=l_Appl.GetStringValue('TIPDOC',2,0);
w_DESCRI=l_Appl.GetStringValue('DESCRI',30,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_MBGANUUHRA_Blank();
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
function Link_MBGANUUHRA_Blank() {
w_TIPODOC='';
w_DESCRI='';
}
function LOpt_MBGANUUHRA() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('cgo_tipdoc','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('TIPDOC','C'));
l_oWv.setValue('LinkedField',WtA('TIPDOC','C'));
l_oWv.setValue('UID',WtA('MBGANUUHRA','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['MBGANUUHRA'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('11429032151'),'C'));
return l_oWv;
}
function Link_YDUQCBNYFV(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_RDCODAUT);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('ARCODICE',w_RDCODAUT,2,0);
l_Appl.SetFields('ARCODICE,ARDESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('cgo_autorita');
l_Appl.SetLinkzoom('armt_cgo_autorita');
l_Appl.SetID('YDUQCBNYFV');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_RDCODAUT=l_Appl.GetStringValue('ARCODICE',2,0);
w_xARDESCRI=l_Appl.GetStringValue('ARDESCRI',15,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_YDUQCBNYFV_Blank();
}
if (l_bResult &&  ! (Empty(w_RDCODAUT) && l_bEmp)) {
l_bResult=arfn_chk_docaut(w_RDCODAUT,w_TIPODOC);
if ( ! (l_bResult)) {
Link_YDUQCBNYFV_Blank();
}
}
if ( ! (l_bResult)) {
m_nLastError=3;
m_cLastWorkVarErrorMsg='';
if (Lt(l_nRec,0)) {
m_cLastMsgError=Translate('MSG_CONNECT_SERVER');
} else {
m_cLastMsgError=AlertErrorMessage('1489090677');
}
}
return l_bResult;
}
function Link_YDUQCBNYFV_Blank() {
w_RDCODAUT='';
w_xARDESCRI='';
}
function LOpt_YDUQCBNYFV() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('cgo_autorita','C'));
l_oWv.setValue('Linkzoomprg',WtA('armt_cgo_autorita','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('ARCODICE','C'));
l_oWv.setValue('LinkedField',WtA('ARCODICE','C'));
l_oWv.setValue('UID',WtA('YDUQCBNYFV','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['YDUQCBNYFV'][1],'C'));
return l_oWv;
}
function Sugg_UOOQYQWWNG(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_Appl = LinkApplet();
var l_bEmp = Empty(HtW(Ctrl('UOOQYQWWNG').value,'C'));
l_Appl.SetStringKey('CODSTA',HtW(Ctrl('UOOQYQWWNG').value,'C'),3,0);
l_Appl.SetFields('CODSTA,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbstati');
l_Appl.SetID('UOOQYQWWNG');
l_Appl.SetMode('suggest');
l_Appl.SetRows('15');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
var res = l_Appl.GetJSONData();
SuggesterLib.render_suggest(res,'UOOQYQWWNG','UOOQYQWWNG',false,'AQSQVBKXAL_DIV','AQSQVBKXAL_HEADER',0);
return l_bResult;
}
SuggesterLib.select_suggest.UOOQYQWWNG=["PAESE2",[null,null],function(newval) { return HtW(newval,'C')}];
function Link_UOOQYQWWNG(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_PAESE2);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODSTA',w_PAESE2,3,0);
l_Appl.SetFields('CODSTA,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbstati');
l_Appl.SetID('UOOQYQWWNG');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_PAESE2=l_Appl.GetStringValue('CODSTA',3,0);
w_dessta2=l_Appl.GetStringValue('DESCRI',40,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_UOOQYQWWNG_Blank();
}
if (l_bResult &&  ! (Empty(w_PAESE2) && l_bEmp)) {
l_bResult=(Eq(w_CFESTERO,1) && Eq(w_PAESE2,'086')?false:(Eq(w_CFESTERO,0) && Ne(w_PAESE2,'086')?false:true));
if ( ! (l_bResult)) {
Link_UOOQYQWWNG_Blank();
}
}
if ( ! (l_bResult)) {
m_nLastError=3;
m_cLastWorkVarErrorMsg='';
if (Lt(l_nRec,0)) {
m_cLastMsgError=Translate('MSG_CONNECT_SERVER');
} else {
m_cLastMsgError=AlertErrorMessage('11529669945');
}
}
return l_bResult;
}
function Link_UOOQYQWWNG_Blank() {
w_PAESE2='';
w_dessta2='';
}
function LOpt_UOOQYQWWNG() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbstati','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODSTA','C'));
l_oWv.setValue('LinkedField',WtA('CODSTA','C'));
l_oWv.setValue('UID',WtA('UOOQYQWWNG','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['UOOQYQWWNG'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('7383187'),'C'));
return l_oWv;
}
function Sugg_BVEIQEJCLQ(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_Appl = LinkApplet();
var l_bEmp = Empty(HtW(Ctrl('BVEIQEJCLQ').value,'C'));
l_Appl.SetStringKey('PKTBSTATI',w_PAESE,3,0);
l_Appl.SetStringKey('CITTA',HtW(Ctrl('BVEIQEJCLQ').value,'C'),40,0);
l_Appl.SetFields('CITTA,IDBASE');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbcitta');
l_Appl.SetID('BVEIQEJCLQ');
l_Appl.SetMode('suggest');
l_Appl.SetRows('15');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
var res = l_Appl.GetJSONData();
SuggesterLib.render_suggest(res,'BVEIQEJCLQ','BVEIQEJCLQ',false,'AQSQVBKXAL_DIV','AQSQVBKXAL_HEADER',0);
return l_bResult;
}
SuggesterLib.select_suggest.BVEIQEJCLQ=["DESCCIT2",[null,null],function(newval) { return HtW(newval,'C')}];
function Link_BVEIQEJCLQ(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_DESCCIT2);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('PKTBSTATI',w_PAESE,3,0);
l_Appl.SetStringKey('CITTA',w_DESCCIT2,40,0);
l_Appl.SetFields('CITTA,IDBASE');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbcitta');
l_Appl.SetID('BVEIQEJCLQ');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_DESCCIT2=l_Appl.GetStringValue('CITTA',40,0);
w_idcitta=l_Appl.GetStringValue('IDBASE',10,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_BVEIQEJCLQ_Blank();
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
function Link_BVEIQEJCLQ_Blank() {
w_idcitta='';
}
function LOpt_BVEIQEJCLQ() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcitta','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('PKTBSTATI,CITTA','C'));
l_oWv.setValue('LinkedField',WtA('CITTA','C'));
l_oWv.setValue('UID',WtA('BVEIQEJCLQ','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['BVEIQEJCLQ'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('15186643'),'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
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
bResult=arfn_form_cf(w_CODFISC,w_COGNOME,w_NOME,w_DATANASC,w_NASCOMUN,w_NASSTATO,w_SESSO,w_CFESTERO,w_TIPINTER);
if ( ! (bResult)) {
m_cLastMsgError=AlertErrorMessage('1209108021');
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
parent.ZtVWeb.raiseEventToEvalParms('armt_snai_oper_v_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('armt_snai_oper_v_dataNotSent',{'action':formaction});
}
}
}
}
CheckChild.child=[];
function Check() {
var l_bResult = true;
ResetErrorVars();
m_nLastError=0;
if ((false) && ( ! (_ChkObl('XFUOZLSACP',1)))) {
_SignErr('XFUOZLSACP');
m_cLastWorkVarErrorMsg='11993248424';
l_bResult=false;
w_SNAINUMOPE=HtW('','C');
} else if ( ! (_ChkObl('YLIKFVPZJA',1))) {
_SignErr('YLIKFVPZJA');
m_cLastWorkVarErrorMsg='829201110';
l_bResult=false;
w_DATAOPE=HtW('','D');
} else if ( ! (_ChkObl('PUBAAWPVMH',1))) {
_SignErr('PUBAAWPVMH');
m_cLastWorkVarErrorMsg='verifica';
l_bResult=false;
w_verifica=HtW('','C');
} else if ( ! (_ChkObl('HILLZZMRNQ',1))) {
_SignErr('HILLZZMRNQ');
m_cLastWorkVarErrorMsg='11628234069';
l_bResult=false;
w_NUMOPEDL=HtW('','C');
} else if ( ! (_ChkObl('ZUVVNOUSIQ',1))) {
_SignErr('ZUVVNOUSIQ');
m_cLastWorkVarErrorMsg='674110294';
l_bResult=false;
w_FLGDOCALL=HtW('','C');
} else if ( ! (_ChkObl('PAADFVDPUD',1))) {
_SignErr('PAADFVDPUD');
m_cLastWorkVarErrorMsg='DOC03';
l_bResult=false;
w_DOC03=HtW('','C');
} else if ( ! (_ChkObl('SIRTAMVPQN',1))) {
_SignErr('SIRTAMVPQN');
m_cLastWorkVarErrorMsg='DOC04';
l_bResult=false;
w_DOC04=HtW('','C');
} else if ( ! (_ChkObl('OZGWRQKOZF',1))) {
_SignErr('OZGWRQKOZF');
m_cLastWorkVarErrorMsg='tipop';
l_bResult=false;
w_tipop=HtW('','C');
} else if ((false) && ( ! (_ChkObl('MVSSLZXHUW',1)))) {
_SignErr('MVSSLZXHUW');
m_cLastWorkVarErrorMsg='1405978050';
l_bResult=false;
w_CGONOTCON=HtW('','M');
}
if (l_bResult) {
l_bResult=CheckChild(0);
}
// * --- Area Manuale = UI - Check Form
// * --- armt_snai_oper_v
if (l_bResult) {
 w_FLGSAVE='N'
 if (confirm('Confermi i dati inseriti ?')) {
   w_FLGSAVE='S'
 }  
}
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
l_oWv.setValue('TIPOGIOCO',WtA(w_TIPOGIOCO,'C'));
l_oWv.setValue('TIPOPERS',WtA(w_TIPOPERS,'C'));
l_oWv.setValue('CGOFLGVNP',WtA(w_CGOFLGVNP,'C'));
l_oWv.setValue('TOTLIRE',WtA(w_TOTLIRE,'N'));
l_oWv.setValue('CGOFLGVLT',WtA(w_CGOFLGVLT,'C'));
l_oWv.setValue('MEZPAGAM',WtA(w_MEZPAGAM,'C'));
l_oWv.setValue('ASSEGNO',WtA(w_ASSEGNO,'C'));
l_oWv.setValue('IBAN',WtA(w_IBAN,'C'));
l_oWv.setValue('CC4CIFRE',WtA(w_CC4CIFRE,'C'));
l_oWv.setValue('CCDATSCA',WtA(w_CCDATSCA,'C'));
l_oWv.setValue('CFESTERO',WtA(w_CFESTERO,'N'));
l_oWv.setValue('CODFISC',WtA(w_CODFISC,'C'));
l_oWv.setValue('COGNOME',WtA(w_COGNOME,'C'));
l_oWv.setValue('NOME',WtA(w_NOME,'C'));
l_oWv.setValue('NASCOMUN',WtA(w_NASCOMUN,'C'));
l_oWv.setValue('TIPINTER',WtA(w_TIPINTER,'C'));
l_oWv.setValue('SESSO',WtA(w_SESSO,'C'));
l_oWv.setValue('NASSTATO',WtA(w_NASSTATO,'C'));
l_oWv.setValue('DATANASC',WtA(w_DATANASC,'D'));
l_oWv.setValue('PAESE',WtA(w_PAESE,'C'));
l_oWv.setValue('RAGSOC',WtA(w_RAGSOC,'C'));
l_oWv.setValue('DESCCIT',WtA(w_DESCCIT,'C'));
l_oWv.setValue('PROVINCIA',WtA(w_PROVINCIA,'C'));
l_oWv.setValue('CAP',WtA(w_CAP,'C'));
l_oWv.setValue('CODCAB',WtA(w_CODCAB,'C'));
l_oWv.setValue('DOMICILIO',WtA(w_DOMICILIO,'C'));
l_oWv.setValue('NUMTEL',WtA(w_NUMTEL,'C'));
l_oWv.setValue('ATTIV',WtA(w_ATTIV,'C'));
l_oWv.setValue('SOTGRUP',WtA(w_SOTGRUP,'C'));
l_oWv.setValue('RAMOGRUP',WtA(w_RAMOGRUP,'C'));
l_oWv.setValue('SETTSINT',WtA(w_SETTSINT,'C'));
l_oWv.setValue('PEP',WtA(w_PEP,'C'));
l_oWv.setValue('SNAINUMOPE',WtA(w_SNAINUMOPE,'C'));
l_oWv.setValue('DATAOPE',WtA(w_DATAOPE,'D'));
l_oWv.setValue('DATAREG',WtA(w_DATAREG,'D'));
l_oWv.setValue('FLAGCONT',WtA(w_FLAGCONT,'C'));
l_oWv.setValue('TIPOOPRAP',WtA(w_TIPOOPRAP,'C'));
l_oWv.setValue('CODANA',WtA(w_CODANA,'C'));
l_oWv.setValue('CODVOC',WtA(w_CODVOC,'C'));
l_oWv.setValue('VALUTA',WtA(w_VALUTA,'C'));
l_oWv.setValue('CAMBIO',WtA(w_CAMBIO,'N'));
l_oWv.setValue('CONNESCLI',WtA(w_CONNESCLI,'C'));
l_oWv.setValue('CONNESBEN',WtA(w_CONNESBEN,'C'));
l_oWv.setValue('C_RAG',WtA(w_C_RAG,'C'));
l_oWv.setValue('C_CTA',WtA(w_C_CTA,'C'));
l_oWv.setValue('C_PRV',WtA(w_C_PRV,'C'));
l_oWv.setValue('C_CAP',WtA(w_C_CAP,'C'));
l_oWv.setValue('C_CAB',WtA(w_C_CAB,'C'));
l_oWv.setValue('C_IND',WtA(w_C_IND,'C'));
l_oWv.setValue('C_STA',WtA(w_C_STA,'C'));
l_oWv.setValue('CODINTER',WtA(w_CODINTER,'C'));
l_oWv.setValue('CODDIPE',WtA(w_CODDIPE,'C'));
l_oWv.setValue('DESCCITDIP',WtA(w_DESCCITDIP,'C'));
l_oWv.setValue('SEGNO',WtA(w_SEGNO,'C'));
l_oWv.setValue('FLAGFRAZ',WtA(w_FLAGFRAZ,'C'));
l_oWv.setValue('COLLEG',WtA(w_COLLEG,'C'));
l_oWv.setValue('PROVINCIADIP',WtA(w_PROVINCIADIP,'C'));
l_oWv.setValue('CODCABDIP',WtA(w_CODCABDIP,'C'));
l_oWv.setValue('TOTCONT',WtA(w_TOTCONT,'N'));
l_oWv.setValue('CACODICE',WtA(w_CACODICE,'N'));
l_oWv.setValue('CAIDBIGLIETTO',WtA(w_CAIDBIGLIETTO,'C'));
l_oWv.setValue('CGOTIPOPE',WtA(w_CGOTIPOPE,'C'));
l_oWv.setValue('NUMOPEDL',WtA(w_NUMOPEDL,'C'));
l_oWv.setValue('CAFLGOPE',WtA(w_CAFLGOPE,'C'));
l_oWv.setValue('CGODATCON',WtA(w_CGODATCON,'D'));
l_oWv.setValue('CGOESICON',WtA(w_CGOESICON,'C'));
l_oWv.setValue('CGONOTCON',WtA(w_CGONOTCON,'M'));
l_oWv.setValue('IDDOCALL',WtA(w_IDDOCALL,'C'));
l_oWv.setValue('FLGDOCALL',WtA(w_FLGDOCALL,'C'));
l_oWv.setValue('VLTPLAT',WtA(w_VLTPLAT,'C'));
l_oWv.setValue('TIPODOC',WtA(w_TIPODOC,'C'));
l_oWv.setValue('NUMDOCUM',WtA(w_NUMDOCUM,'C'));
l_oWv.setValue('DATARILASC',WtA(w_DATARILASC,'D'));
l_oWv.setValue('DATAVALI',WtA(w_DATAVALI,'D'));
l_oWv.setValue('RDCODAUT',WtA(w_RDCODAUT,'C'));
l_oWv.setValue('RDLOCAUT',WtA(w_RDLOCAUT,'C'));
l_oWv.setValue('AUTRILASC',WtA(w_AUTRILASC,'C'));
l_oWv.setValue('PEPDESCRI',WtA(w_PEPDESCRI,'C'));
l_oWv.setValue('PAESE2',WtA(w_PAESE2,'C'));
l_oWv.setValue('DESCCIT2',WtA(w_DESCCIT2,'C'));
l_oWv.setValue('PROVINCIA2',WtA(w_PROVINCIA2,'C'));
l_oWv.setValue('CAP2',WtA(w_CAP2,'C'));
l_oWv.setValue('DOMICILIO2',WtA(w_DOMICILIO2,'C'));
l_oWv.setValue('FLGDOM',WtA(w_FLGDOM,'C'));
l_oWv.setValue('gIntemediario',WtA(w_gIntemediario,'C'));
l_oWv.setValue('xSOGTPGIO',WtA(w_xSOGTPGIO,'N'));
l_oWv.setValue('xDEFTPGIO',WtA(w_xDEFTPGIO,'C'));
l_oWv.setValue('xEDTTPGIO',WtA(w_xEDTTPGIO,'C'));
l_oWv.setValue('xEDTSPGIO',WtA(w_xEDTSPGIO,'C'));
l_oWv.setValue('xDEFSPGIO',WtA(w_xDEFSPGIO,'C'));
l_oWv.setValue('xARDESCRI',WtA(w_xARDESCRI,'C'));
l_oWv.setValue('dessta',WtA(w_dessta,'C'));
l_oWv.setValue('tipsot',WtA(w_tipsot,'C'));
l_oWv.setValue('STATOREG',WtA(w_STATOREG,'C'));
l_oWv.setValue('IDBASE',WtA(w_IDBASE,'C'));
l_oWv.setValue('NUMPROG',WtA(w_NUMPROG,'C'));
l_oWv.setValue('DESCRI',WtA(w_DESCRI,'C'));
l_oWv.setValue('gSeekAos',WtA(w_gSeekAos,'C'));
l_oWv.setValue('gDataVaria',WtA(w_gDataVaria,'D'));
l_oWv.setValue('gFlgDoc',WtA(w_gFlgDoc,'C'));
l_oWv.setValue('xDescDipe',WtA(w_xDescDipe,'C'));
l_oWv.setValue('datpaseuro',WtA(w_datpaseuro,'D'));
l_oWv.setValue('xdes1',WtA(w_xdes1,'C'));
l_oWv.setValue('desccauana',WtA(w_desccauana,'C'));
l_oWv.setValue('CITINT',WtA(w_CITINT,'C'));
l_oWv.setValue('CITDIP',WtA(w_CITDIP,'C'));
l_oWv.setValue('PROVDIP',WtA(w_PROVDIP,'C'));
l_oWv.setValue('CABDIP',WtA(w_CABDIP,'C'));
l_oWv.setValue('PROVINT',WtA(w_PROVINT,'C'));
l_oWv.setValue('CABINT',WtA(w_CABINT,'C'));
l_oWv.setValue('xdesccausin',WtA(w_xdesccausin,'C'));
l_oWv.setValue('gChkDate',WtA(w_gChkDate,'C'));
l_oWv.setValue('idcitta',WtA(w_idcitta,'C'));
l_oWv.setValue('xdesctipatt',WtA(w_xdesctipatt,'C'));
l_oWv.setValue('gVLT',WtA(w_gVLT,'N'));
l_oWv.setValue('gVNP',WtA(w_gVNP,'N'));
l_oWv.setValue('gCodDip',WtA(w_gCodDip,'C'));
l_oWv.setValue('verifica',WtA(w_verifica,'C'));
l_oWv.setValue('gStpDwn',WtA(w_gStpDwn,'C'));
l_oWv.setValue('MIDBIGLIETTO',WtA(w_MIDBIGLIETTO,'M'));
l_oWv.setValue('MIDBIGLIETTO1',WtA(w_MIDBIGLIETTO1,'M'));
l_oWv.setValue('MIDBIGLIETTO2',WtA(w_MIDBIGLIETTO2,'M'));
l_oWv.setValue('MIDBIGLIETTO3',WtA(w_MIDBIGLIETTO3,'M'));
l_oWv.setValue('MIDBIGLIETTO4',WtA(w_MIDBIGLIETTO4,'M'));
l_oWv.setValue('TELDIP',WtA(w_TELDIP,'C'));
l_oWv.setValue('CODLOC',WtA(w_CODLOC,'C'));
l_oWv.setValue('xFLGPLGIO',WtA(w_xFLGPLGIO,'C'));
l_oWv.setValue('xVPFLGATT',WtA(w_xVPFLGATT,'C'));
l_oWv.setValue('DOC03',WtA(w_DOC03,'C'));
l_oWv.setValue('DOC04',WtA(w_DOC04,'C'));
l_oWv.setValue('tipop',WtA(w_tipop,'C'));
l_oWv.setValue('FLGSAVE',WtA(w_FLGSAVE,'C'));
l_oWv.setValue('dessta2',WtA(w_dessta2,'C'));
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
FillWv.n=["TIPOGIOCO","TIPOPERS","CGOFLGVNP","TOTLIRE","CGOFLGVLT","MEZPAGAM","ASSEGNO","IBAN","CC4CIFRE","CCDATSCA","CFESTERO","CODFISC","COGNOME","NOME","NASCOMUN","TIPINTER","SESSO","NASSTATO","DATANASC","PAESE","RAGSOC","DESCCIT","PROVINCIA","CAP","CODCAB","DOMICILIO","NUMTEL","ATTIV","SOTGRUP","RAMOGRUP","SETTSINT","PEP","SNAINUMOPE","DATAOPE","DATAREG","FLAGCONT","TIPOOPRAP","CODANA","CODVOC","VALUTA","CAMBIO","CONNESCLI","CONNESBEN","C_RAG","C_CTA","C_PRV","C_CAP","C_CAB","C_IND","C_STA","CODINTER","CODDIPE","DESCCITDIP","SEGNO","FLAGFRAZ","COLLEG","PROVINCIADIP","CODCABDIP","TOTCONT","CACODICE","CAIDBIGLIETTO","CGOTIPOPE","NUMOPEDL","CAFLGOPE","CGODATCON","CGOESICON","CGONOTCON","IDDOCALL","FLGDOCALL","VLTPLAT","TIPODOC","NUMDOCUM","DATARILASC","DATAVALI","RDCODAUT","RDLOCAUT","AUTRILASC","PEPDESCRI","PAESE2","DESCCIT2","PROVINCIA2","CAP2","DOMICILIO2","FLGDOM","gIntemediario","xSOGTPGIO","xDEFTPGIO","xEDTTPGIO","xEDTSPGIO","xDEFSPGIO","xARDESCRI","dessta","tipsot","STATOREG","IDBASE","NUMPROG","DESCRI","gSeekAos","gDataVaria","gFlgDoc","xDescDipe","datpaseuro","xdes1","desccauana","CITINT","CITDIP","PROVDIP","CABDIP","PROVINT","CABINT","xdesccausin","gChkDate","idcitta","xdesctipatt","gVLT","gVNP","gCodDip","verifica","gStpDwn","MIDBIGLIETTO","MIDBIGLIETTO1","MIDBIGLIETTO2","MIDBIGLIETTO3","MIDBIGLIETTO4","TELDIP","CODLOC","xFLGPLGIO","xVPFLGATT","DOC03","DOC04","tipop","FLGSAVE","dessta2"];
function SetModified() {
m_bUpdated=true;
}
