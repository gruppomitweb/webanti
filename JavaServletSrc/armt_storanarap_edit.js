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
function DisplayErrorMessage_ardt_delegabo() {
if ( ! (ChildToLoad(FrameRef('ardt_delegabo'))) && Ne(typeof(FrameRef('ardt_delegabo').DisplayErrorMessage),'undefined')) {
FrameRef('ardt_delegabo').DisplayErrorMessage();
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
l_bEnabled= ! (false) || IsDisabledByStateDriver('LinkPC');
if ( ! (ChildToLoad(FrameRef('ardt_delegabo'))) && Ne(typeof(FrameRef('ardt_delegabo').EnableEntity),'undefined')) {
FrameRef('ardt_delegabo').EnableEntity(l_bEnabled);
}
if (IsDisabledByStateDriver('box_YORQOIOBQN')) {
DisableInputsInContainer(Ctrl('YORQOIOBQN'),true);
}
if (IsDisabledByStateDriver('box_YYHBZYTHNJ')) {
DisableInputsInContainer(Ctrl('YYHBZYTHNJ'),true);
}
if (IsDisabledByStateDriver('box_LZCEHELAXJ')) {
DisableInputsInContainer(Ctrl('LZCEHELAXJ'),true);
}
if (IsDisabledByStateDriver('box_EHSQLOIDHO')) {
DisableInputsInContainer(Ctrl('EHSQLOIDHO'),true);
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
SetObligatory(Ctrl('YSBAKLZECK'),Eq(w_gTelepass,'6') || IsObligatoryByStateDriver('SPLITCODE'));
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
function Set_RCOMP(ctrlValue,kmode,e) {
if (Ne(w_RCOMP,ctrlValue)) {
var ctl = _GetCtl(e,'ETALZDRBSO');
if (_tracker.goon(ctl,ctrlValue)) {
w_RCOMP=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ETALZDRBSO',0);
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
function Set_RAREA(ctrlValue,kmode,e) {
if (Ne(w_RAREA,ctrlValue)) {
var ctl = _GetCtl(e,'UDAYHICPVB');
if (_tracker.goon(ctl,ctrlValue)) {
w_RAREA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UDAYHICPVB',0);
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
function Set_NOPROT(ctrlValue,kmode,e) {
if (Ne(w_NOPROT,ctrlValue)) {
var ctl = _GetCtl(e,'AABRTCZWUY');
if (_tracker.goon(ctl,ctrlValue)) {
w_NOPROT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('AABRTCZWUY',0);
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
function Set_NATURA(ctrlValue,kmode,e) {
if (Ne(w_NATURA,ctrlValue)) {
var ctl = _GetCtl(e,'VSHUPFYWOC');
if (_tracker.goon(ctl,ctrlValue)) {
w_NATURA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VSHUPFYWOC',0);
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
function Set_SCOPO(ctrlValue,kmode,e) {
if (Ne(w_SCOPO,ctrlValue)) {
var ctl = _GetCtl(e,'VASVGQZJGP');
if (_tracker.goon(ctl,ctrlValue)) {
w_SCOPO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VASVGQZJGP',0);
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
function Set_AREAGEO(ctrlValue,kmode,e) {
if (Ne(w_AREAGEO,ctrlValue)) {
var ctl = _GetCtl(e,'QJSTZIPOQB');
if (_tracker.goon(ctl,ctrlValue)) {
w_AREAGEO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QJSTZIPOQB',0);
if (l_bResult) {
l_bResult=Link_QJSTZIPOQB(kmode);
if ( ! (l_bResult)) {
w_AREAGEO=HtW('','C');
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
function Set_MODSVOL(ctrlValue,kmode,e) {
if (Ne(w_MODSVOL,ctrlValue)) {
var ctl = _GetCtl(e,'SFFFOYOWNH');
if (_tracker.goon(ctl,ctrlValue)) {
w_MODSVOL=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SFFFOYOWNH',0);
if (l_bResult) {
l_bResult=Link_SFFFOYOWNH(kmode);
if ( ! (l_bResult)) {
w_MODSVOL=HtW('','C');
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
function Set_RAGIO(ctrlValue,kmode,e) {
if (Ne(w_RAGIO,ctrlValue)) {
var ctl = _GetCtl(e,'NOBMPHKVTX');
if (_tracker.goon(ctl,ctrlValue)) {
w_RAGIO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NOBMPHKVTX',0);
if (l_bResult) {
l_bResult=Link_NOBMPHKVTX(kmode);
if ( ! (l_bResult)) {
w_RAGIO=HtW('','C');
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
function Set_TIPO(ctrlValue,kmode,e) {
if (Ne(w_TIPO,ctrlValue)) {
var ctl = _GetCtl(e,'DJOWYRMDDC');
if (_tracker.goon(ctl,ctrlValue)) {
w_TIPO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('DJOWYRMDDC',0);
if (l_bResult) {
l_bResult=Link_DJOWYRMDDC(kmode);
if ( ! (l_bResult)) {
w_TIPO=HtW('','C');
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
function Set_RFREQ(ctrlValue,kmode,e) {
if (Ne(w_RFREQ,ctrlValue)) {
var ctl = _GetCtl(e,'MXYTQLATHC');
if (_tracker.goon(ctl,ctrlValue)) {
w_RFREQ=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MXYTQLATHC',0);
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
function Set_RIMP(ctrlValue,kmode,e) {
if (Ne(w_RIMP,ctrlValue)) {
var ctl = _GetCtl(e,'KBIUAXUDXA');
if (_tracker.goon(ctl,ctrlValue)) {
w_RIMP=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('KBIUAXUDXA',0);
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
function Set_MACODICE(ctrlValue,kmode,e) {
if (Ne(w_MACODICE,ctrlValue)) {
var ctl = _GetCtl(e,'SSYXHQXJLD');
if (_tracker.goon(ctl,ctrlValue)) {
w_MACODICE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SSYXHQXJLD',0);
if (l_bResult) {
l_bResult=Link_SSYXHQXJLD(kmode);
if ( ! (l_bResult)) {
w_MACODICE=HtW('','C');
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
function Set_AMMONT(ctrlValue,kmode,e) {
if (Ne(w_AMMONT,ctrlValue)) {
var ctl = _GetCtl(e,'SXTYCPHBIM');
if (_tracker.goon(ctl,ctrlValue)) {
w_AMMONT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SXTYCPHBIM',0);
if (l_bResult) {
l_bResult=Link_SXTYCPHBIM(kmode);
if ( ! (l_bResult)) {
w_AMMONT=HtW('','C');
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
function Set_RRAGIO(ctrlValue,kmode,e) {
if (Ne(w_RRAGIO,ctrlValue)) {
var ctl = _GetCtl(e,'QBTVZDKLCO');
if (_tracker.goon(ctl,ctrlValue)) {
w_RRAGIO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QBTVZDKLCO',0);
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
function Set_RTIPO(ctrlValue,kmode,e) {
if (Ne(w_RTIPO,ctrlValue)) {
var ctl = _GetCtl(e,'RUWEXWJASG');
if (_tracker.goon(ctl,ctrlValue)) {
w_RTIPO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RUWEXWJASG',0);
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
function Set_SPLITCODE(ctrlValue,kmode,e) {
if (Ne(w_SPLITCODE,ctrlValue)) {
var ctl = _GetCtl(e,'YSBAKLZECK');
if (_tracker.goon(ctl,ctrlValue)) {
w_SPLITCODE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YSBAKLZECK',0);
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
function Set_DURAT(ctrlValue,kmode,e) {
if (Ne(w_DURAT,ctrlValue)) {
var ctl = _GetCtl(e,'CKJQULDXKW');
if (_tracker.goon(ctl,ctrlValue)) {
w_DURAT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CKJQULDXKW',0);
if (l_bResult) {
l_bResult=Link_CKJQULDXKW(kmode);
if ( ! (l_bResult)) {
w_DURAT=HtW('','C');
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
function Calculate() {
var l_bTmpRes;
var l_bResult = true;
m_bCalculating=true;
if ((Ne(o_FLAGLIRE,w_FLAGLIRE))) {
Calculation_LMOPUUAIMR();
}
if ((Ne(o_FLAGLIRE,w_FLAGLIRE)) || (Ne(o_VALUTA,w_VALUTA))) {
l_bTmpRes=Link_RUMXLFCOKA(null);
}
UpdateAutonumber('PRGIMPRAP');
w_mess='Messaggio\\nSecondo\\nTerzo';
LibJavascript.forEachItem(m_FoundlingCopyWorkVar,i_body_1)
function i_body_1(child){
child();
}
// * --- Area Manuale = UI - Calculate
// * --- Fine Area Manuale
UpdateAutonumber('');
m_bCalculating=false;
}
function Calculation_LMOPUUAIMR() {
w_VALUTA=(Eq(w_FLAGLIRE,'L')?'018':(Eq(w_FLAGLIRE,'E')?'242':''));
}
function SaveDependsOn() {
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
function Link_QJSTZIPOQB(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_AREAGEO);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODICE',w_AREAGEO,5,0);
l_Appl.SetFields('CODICE,DESCRI,RISCHIO');
l_Appl.SetTypes('C,C,N');
l_Appl.LinkTable('tbareegeog');
l_Appl.SetID('QJSTZIPOQB');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_AREAGEO=l_Appl.GetStringValue('CODICE',5,0);
w_xdescareag=l_Appl.GetStringValue('DESCRI',50,0);
w_RAREA=l_Appl.GetDoubleValue('RISCHIO',3,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_QJSTZIPOQB_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_QJSTZIPOQB';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_QJSTZIPOQB();
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
function Link_QJSTZIPOQB_Blank() {
w_AREAGEO='';
w_xdescareag='';
w_RAREA=0;
}
function LOpt_QJSTZIPOQB() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbareegeog','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODICE','C'));
l_oWv.setValue('LinkedField',WtA('CODICE','C'));
l_oWv.setValue('UID',WtA('QJSTZIPOQB','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['QJSTZIPOQB'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('11053408024'),'C'));
return l_oWv;
}
function Link_SFFFOYOWNH(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_MODSVOL);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODICE',w_MODSVOL,5,0);
l_Appl.SetFields('CODICE,DESCRI,RISCHIO');
l_Appl.SetTypes('C,C,N');
l_Appl.LinkTable('tbsvolgim');
l_Appl.SetID('SFFFOYOWNH');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_MODSVOL=l_Appl.GetStringValue('CODICE',5,0);
w_xdescmodsvo=l_Appl.GetStringValue('DESCRI',200,0);
w_RCOMP=l_Appl.GetDoubleValue('RISCHIO',3,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_SFFFOYOWNH_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_SFFFOYOWNH';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_SFFFOYOWNH();
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
function Link_SFFFOYOWNH_Blank() {
w_MODSVOL='';
w_xdescmodsvo='';
w_RCOMP=0;
}
function LOpt_SFFFOYOWNH() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbsvolgim','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODICE','C'));
l_oWv.setValue('LinkedField',WtA('CODICE','C'));
l_oWv.setValue('UID',WtA('SFFFOYOWNH','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['SFFFOYOWNH'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('11158852142'),'C'));
return l_oWv;
}
function Link_NOBMPHKVTX(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_RAGIO);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODICE',w_RAGIO,5,0);
l_Appl.SetFields('CODICE,DESCRI,RISCHIO');
l_Appl.SetTypes('C,C,N');
l_Appl.LinkTable('tbplauso');
l_Appl.SetID('NOBMPHKVTX');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_RAGIO=l_Appl.GetStringValue('CODICE',5,0);
w_xdescplauso=l_Appl.GetStringValue('DESCRI',200,0);
w_RRAGIO=l_Appl.GetDoubleValue('RISCHIO',3,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_NOBMPHKVTX_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_NOBMPHKVTX';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_NOBMPHKVTX();
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
function Link_NOBMPHKVTX_Blank() {
w_RAGIO='';
w_xdescplauso='';
w_RRAGIO=0;
}
function LOpt_NOBMPHKVTX() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbplauso','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODICE','C'));
l_oWv.setValue('LinkedField',WtA('CODICE','C'));
l_oWv.setValue('UID',WtA('NOBMPHKVTX','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['NOBMPHKVTX'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('955814582'),'C'));
return l_oWv;
}
function Link_DJOWYRMDDC(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_TIPO);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODICE',w_TIPO,3,0);
l_Appl.SetFields('CODICE,DESCRI,RISCHIO');
l_Appl.SetTypes('C,C,N');
l_Appl.LinkTable('tbtiporisc');
l_Appl.SetID('DJOWYRMDDC');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_TIPO=l_Appl.GetStringValue('CODICE',3,0);
w_xdesctipor=l_Appl.GetStringValue('DESCRI',100,0);
w_RTIPO=l_Appl.GetDoubleValue('RISCHIO',3,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_DJOWYRMDDC_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_DJOWYRMDDC';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_DJOWYRMDDC();
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
function Link_DJOWYRMDDC_Blank() {
w_TIPO='';
w_xdesctipor='';
w_RTIPO=0;
}
function LOpt_DJOWYRMDDC() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbtiporisc','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODICE','C'));
l_oWv.setValue('LinkedField',WtA('CODICE','C'));
l_oWv.setValue('UID',WtA('DJOWYRMDDC','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['DJOWYRMDDC'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('10049460300'),'C'));
return l_oWv;
}
function Link_CKJQULDXKW(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_DURAT);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODICE',w_DURAT,5,0);
l_Appl.SetFields('CODICE,DESCRI,RISCHIO');
l_Appl.SetTypes('C,C,N');
l_Appl.LinkTable('tbdurata');
l_Appl.SetLinkzoom('ammt_tbdurata');
l_Appl.SetID('CKJQULDXKW');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_DURAT=l_Appl.GetStringValue('CODICE',5,0);
w_xdescfreq=l_Appl.GetStringValue('DESCRI',200,0);
w_RFREQ=l_Appl.GetDoubleValue('RISCHIO',3,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_CKJQULDXKW_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_CKJQULDXKW';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_CKJQULDXKW();
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
function Link_CKJQULDXKW_Blank() {
w_DURAT='';
w_xdescfreq='';
w_RFREQ=0;
}
function LOpt_CKJQULDXKW() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbdurata','C'));
l_oWv.setValue('Linkzoomprg',WtA('ammt_tbdurata','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODICE','C'));
l_oWv.setValue('LinkedField',WtA('CODICE','C'));
l_oWv.setValue('UID',WtA('CKJQULDXKW','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['CKJQULDXKW'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('492802848'),'C'));
return l_oWv;
}
function Link_SXTYCPHBIM(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_AMMONT);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODICE',w_AMMONT,5,0);
l_Appl.SetFields('CODICE,DESCRI,RISCHIO');
l_Appl.SetTypes('C,C,N');
l_Appl.LinkTable('tbimporto');
l_Appl.SetID('SXTYCPHBIM');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_AMMONT=l_Appl.GetStringValue('CODICE',5,0);
w_xdescammo=l_Appl.GetStringValue('DESCRI',200,0);
w_RIMP=l_Appl.GetDoubleValue('RISCHIO',3,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_SXTYCPHBIM_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_SXTYCPHBIM';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_SXTYCPHBIM();
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
function Link_SXTYCPHBIM_Blank() {
w_AMMONT='';
w_xdescammo='';
w_RIMP=0;
}
function LOpt_SXTYCPHBIM() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbimporto','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODICE','C'));
l_oWv.setValue('LinkedField',WtA('CODICE','C'));
l_oWv.setValue('UID',WtA('SXTYCPHBIM','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['SXTYCPHBIM'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('11857520945'),'C'));
return l_oWv;
}
function Link_SSYXHQXJLD(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_MACODICE);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('MACODICE',w_MACODICE,5,0);
l_Appl.SetFields('MACODICE,MADESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbmacage');
l_Appl.SetID('SSYXHQXJLD');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_MACODICE=l_Appl.GetStringValue('MACODICE',5,0);
w_xMADESCRI=l_Appl.GetStringValue('MADESCRI',60,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_SSYXHQXJLD_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_SSYXHQXJLD';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_SSYXHQXJLD();
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
function Link_SSYXHQXJLD_Blank() {
w_MACODICE='';
w_xMADESCRI='';
}
function LOpt_SSYXHQXJLD() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbmacage','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('MACODICE','C'));
l_oWv.setValue('LinkedField',WtA('MACODICE','C'));
l_oWv.setValue('UID',WtA('SSYXHQXJLD','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['SSYXHQXJLD'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('11283673182'),'C'));
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
if (Eq(varName,'QJSTZIPOQB')) {
last_focused_comp=GetLastFocusedElementOfLink('QJSTZIPOQB');
function SetMethod_QJSTZIPOQB() {
Set_AREAGEO(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_QJSTZIPOQB();
} else {
setTimeout(SetMethod_QJSTZIPOQB,1);
}
bResult=true;
}
if (Eq(varName,'SFFFOYOWNH')) {
last_focused_comp=GetLastFocusedElementOfLink('SFFFOYOWNH');
function SetMethod_SFFFOYOWNH() {
Set_MODSVOL(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_SFFFOYOWNH();
} else {
setTimeout(SetMethod_SFFFOYOWNH,1);
}
bResult=true;
}
if (Eq(varName,'NOBMPHKVTX')) {
last_focused_comp=GetLastFocusedElementOfLink('NOBMPHKVTX');
function SetMethod_NOBMPHKVTX() {
Set_RAGIO(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_NOBMPHKVTX();
} else {
setTimeout(SetMethod_NOBMPHKVTX,1);
}
bResult=true;
}
if (Eq(varName,'DJOWYRMDDC')) {
last_focused_comp=GetLastFocusedElementOfLink('DJOWYRMDDC');
function SetMethod_DJOWYRMDDC() {
Set_TIPO(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_DJOWYRMDDC();
} else {
setTimeout(SetMethod_DJOWYRMDDC,1);
}
bResult=true;
}
if (Eq(varName,'CKJQULDXKW')) {
last_focused_comp=GetLastFocusedElementOfLink('CKJQULDXKW');
function SetMethod_CKJQULDXKW() {
Set_DURAT(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_CKJQULDXKW();
} else {
setTimeout(SetMethod_CKJQULDXKW,1);
}
bResult=true;
}
if (Eq(varName,'SXTYCPHBIM')) {
last_focused_comp=GetLastFocusedElementOfLink('SXTYCPHBIM');
function SetMethod_SXTYCPHBIM() {
Set_AMMONT(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_SXTYCPHBIM();
} else {
setTimeout(SetMethod_SXTYCPHBIM,1);
}
bResult=true;
}
if (Eq(varName,'SSYXHQXJLD')) {
last_focused_comp=GetLastFocusedElementOfLink('SSYXHQXJLD');
function SetMethod_SSYXHQXJLD() {
Set_MACODICE(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_SSYXHQXJLD();
} else {
setTimeout(SetMethod_SSYXHQXJLD,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'RUMXLFCOKA')) {
return [Ctrl('RUMXLFCOKA')];
}
if (Eq(varName,'QJSTZIPOQB')) {
return [Ctrl('QJSTZIPOQB')];
}
if (Eq(varName,'SFFFOYOWNH')) {
return [Ctrl('SFFFOYOWNH')];
}
if (Eq(varName,'NOBMPHKVTX')) {
return [Ctrl('NOBMPHKVTX')];
}
if (Eq(varName,'DJOWYRMDDC')) {
return [Ctrl('DJOWYRMDDC')];
}
if (Eq(varName,'CKJQULDXKW')) {
return [Ctrl('CKJQULDXKW')];
}
if (Eq(varName,'SXTYCPHBIM')) {
return [Ctrl('SXTYCPHBIM')];
}
if (Eq(varName,'SSYXHQXJLD')) {
return [Ctrl('SSYXHQXJLD')];
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
bResult=false;
if ( ! (bResult)) {
m_cLastMsgError=AlertErrorMessage('MSG_CANNOT_SAVE');
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
parent.ZtVWeb.raiseEventToEvalParms('armt_storanarap_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('armt_storanarap_dataNotSent',{'action':formaction});
}
}
}
}
CheckChild.child=[{'prg':"ardt_delegabo",'BOScId':function(){ return FrameRef('ardt_delegabo')},'repeated':0}];
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
} else if ( ! (_ChkObl('AABRTCZWUY',1))) {
_SignErr('AABRTCZWUY');
m_cLastWorkVarErrorMsg='10194595222';
l_bResult=false;
w_NOPROT=0;
} else if ( ! (_ChkObl('VSHUPFYWOC',1))) {
_SignErr('VSHUPFYWOC');
m_cLastWorkVarErrorMsg='NATURA';
l_bResult=false;
w_NATURA=HtW('','C');
} else if ( ! (_ChkObl('VASVGQZJGP',1))) {
_SignErr('VASVGQZJGP');
m_cLastWorkVarErrorMsg='SCOPO';
l_bResult=false;
w_SCOPO=HtW('','C');
} else if ( ! (_ChkObl('QJSTZIPOQB',1))) {
_SignErr('QJSTZIPOQB');
m_cLastWorkVarErrorMsg='AREAGEO';
l_bResult=false;
w_AREAGEO=HtW('','C');
} else if ( ! (_ChkObl('SFFFOYOWNH',1))) {
_SignErr('SFFFOYOWNH');
m_cLastWorkVarErrorMsg='MODSVOL';
l_bResult=false;
w_MODSVOL=HtW('','C');
} else if ( ! (_ChkObl('NOBMPHKVTX',1))) {
_SignErr('NOBMPHKVTX');
m_cLastWorkVarErrorMsg='RAGIO';
l_bResult=false;
w_RAGIO=HtW('','C');
} else if ( ! (_ChkObl('DJOWYRMDDC',1))) {
_SignErr('DJOWYRMDDC');
m_cLastWorkVarErrorMsg='TIPO';
l_bResult=false;
w_TIPO=HtW('','C');
} else if ( ! (_ChkObl('MXYTQLATHC',1))) {
_SignErr('MXYTQLATHC');
m_cLastWorkVarErrorMsg='RFREQ';
l_bResult=false;
w_RFREQ=HtW('','N');
} else if ( ! (_ChkObl('KBIUAXUDXA',1))) {
_SignErr('KBIUAXUDXA');
m_cLastWorkVarErrorMsg='RIMP';
l_bResult=false;
w_RIMP=HtW('','N');
} else if ( ! (_ChkObl('UDAYHICPVB',1))) {
_SignErr('UDAYHICPVB');
m_cLastWorkVarErrorMsg='RAREA';
l_bResult=false;
w_RAREA=HtW('','N');
} else if ( ! (_ChkObl('ETALZDRBSO',1))) {
_SignErr('ETALZDRBSO');
m_cLastWorkVarErrorMsg='RCOMP';
l_bResult=false;
w_RCOMP=HtW('','N');
} else if ( ! (_ChkObl('QBTVZDKLCO',1))) {
_SignErr('QBTVZDKLCO');
m_cLastWorkVarErrorMsg='RRAGIO';
l_bResult=false;
w_RRAGIO=HtW('','N');
} else if ( ! (_ChkObl('RUWEXWJASG',1))) {
_SignErr('RUWEXWJASG');
m_cLastWorkVarErrorMsg='RTIPO';
l_bResult=false;
w_RTIPO=HtW('','N');
} else if ( ! (_ChkObl('CKJQULDXKW',1))) {
_SignErr('CKJQULDXKW');
m_cLastWorkVarErrorMsg='DURAT';
l_bResult=false;
w_DURAT=HtW('','C');
} else if ( ! (_ChkObl('SXTYCPHBIM',1))) {
_SignErr('SXTYCPHBIM');
m_cLastWorkVarErrorMsg='AMMONT';
l_bResult=false;
w_AMMONT=HtW('','C');
} else if ( ! (_ChkObl('YSBAKLZECK',1))) {
_SignErr('YSBAKLZECK');
m_cLastWorkVarErrorMsg='115410470';
l_bResult=false;
w_SPLITCODE=HtW('','C');
} else if ( ! (_ChkObl('SSYXHQXJLD',1))) {
_SignErr('SSYXHQXJLD');
m_cLastWorkVarErrorMsg='11283631966';
l_bResult=false;
w_MACODICE=HtW('','C');
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
if (Eq('QJSTZIPOQB_ZOOM',lc)) {
return 1;
}
if (Eq('QJSTZIPOQB',lc)) {
return 1;
}
if (Eq('SFFFOYOWNH_ZOOM',lc)) {
return 2;
}
if (Eq('SFFFOYOWNH',lc)) {
return 2;
}
if (Eq('NOBMPHKVTX_ZOOM',lc)) {
return 3;
}
if (Eq('NOBMPHKVTX',lc)) {
return 3;
}
if (Eq('DJOWYRMDDC_ZOOM',lc)) {
return 4;
}
if (Eq('DJOWYRMDDC',lc)) {
return 4;
}
if (Eq('CKJQULDXKW_ZOOM',lc)) {
return 5;
}
if (Eq('CKJQULDXKW',lc)) {
return 5;
}
if (Eq('SXTYCPHBIM_ZOOM',lc)) {
return 6;
}
if (Eq('SXTYCPHBIM',lc)) {
return 6;
}
if (Eq('SSYXHQXJLD_ZOOM',lc)) {
return 7;
}
if (Eq('SSYXHQXJLD',lc)) {
return 7;
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
if (Eq(index,1)) {
l_oWv=LOpt_QJSTZIPOQB();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,2)) {
l_oWv=LOpt_SFFFOYOWNH();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,3)) {
l_oWv=LOpt_NOBMPHKVTX();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,4)) {
l_oWv=LOpt_DJOWYRMDDC();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,5)) {
l_oWv=LOpt_CKJQULDXKW();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,6)) {
l_oWv=LOpt_SXTYCPHBIM();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,7)) {
l_oWv=LOpt_SSYXHQXJLD();
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
l_oWv.setValue('FLAGLIRE',WtA(w_FLAGLIRE,'C'));
l_oWv.setValue('VALUTA',WtA(w_VALUTA,'C'));
l_oWv.setValue('NOPROT',WtA(w_NOPROT,'N'));
l_oWv.setValue('NATURA',WtA(w_NATURA,'C'));
l_oWv.setValue('SCOPO',WtA(w_SCOPO,'C'));
l_oWv.setValue('AREAGEO',WtA(w_AREAGEO,'C'));
l_oWv.setValue('MODSVOL',WtA(w_MODSVOL,'C'));
l_oWv.setValue('RAGIO',WtA(w_RAGIO,'C'));
l_oWv.setValue('TIPO',WtA(w_TIPO,'C'));
l_oWv.setValue('RFREQ',WtA(w_RFREQ,'N'));
l_oWv.setValue('RIMP',WtA(w_RIMP,'N'));
l_oWv.setValue('RAREA',WtA(w_RAREA,'N'));
l_oWv.setValue('RCOMP',WtA(w_RCOMP,'N'));
l_oWv.setValue('RRAGIO',WtA(w_RRAGIO,'N'));
l_oWv.setValue('RTIPO',WtA(w_RTIPO,'N'));
l_oWv.setValue('PRGIMPRAP',WtA(w_PRGIMPRAP,'N'));
l_oWv.setValue('op_PRGIMPRAP',WtA(op_PRGIMPRAP,'N'));
l_oWv.setValue('DURAT',WtA(w_DURAT,'C'));
l_oWv.setValue('AMMONT',WtA(w_AMMONT,'C'));
l_oWv.setValue('SPLITCODE',WtA(w_SPLITCODE,'C'));
l_oWv.setValue('MACODICE',WtA(w_MACODICE,'C'));
l_oWv.setValue('CODDIP',WtA(w_CODDIP,'C'));
l_oWv.setValue('descval',WtA(w_descval,'C'));
l_oWv.setValue('daticoll',WtA(w_daticoll,'N'));
l_oWv.setValue('xdescmodsvo',WtA(w_xdescmodsvo,'C'));
l_oWv.setValue('xdescareag',WtA(w_xdescareag,'C'));
l_oWv.setValue('xdescplauso',WtA(w_xdescplauso,'C'));
l_oWv.setValue('xdesctipor',WtA(w_xdesctipor,'C'));
l_oWv.setValue('xdescfreq',WtA(w_xdescfreq,'C'));
l_oWv.setValue('xdescammo',WtA(w_xdescammo,'C'));
l_oWv.setValue('gTelepass',WtA(w_gTelepass,'C'));
l_oWv.setValue('xMADESCRI',WtA(w_xMADESCRI,'C'));
l_oWv.setValue('mess',WtA(w_mess,'M'));
l_oWv.setValue('gBrowser',WtA(w_gBrowser,'C'));
l_oWv.setValue('gCodDip',WtA(w_gCodDip,'C'));
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
_FillChildren.n=['ardt_delegabo'];
FillWv.n=["RAPPORTO","DESCRAP","TIPORAP","TIPOAG","FLAGLIRE","VALUTA","NOPROT","NATURA","SCOPO","AREAGEO","MODSVOL","RAGIO","TIPO","RFREQ","RIMP","RAREA","RCOMP","RRAGIO","RTIPO","PRGIMPRAP","DURAT","AMMONT","SPLITCODE","MACODICE","CODDIP","descval","daticoll","xdescmodsvo","xdescareag","xdescplauso","xdesctipor","xdescfreq","xdescammo","gTelepass","xMADESCRI","mess","gBrowser","gCodDip"];
function SetModified() {
m_bUpdated=true;
}
function SetChildVariables_ardt_delegabo() {
}
function CtxLoad_ardt_delegabo() {
if (ChildToLoad(FrameRef('ardt_delegabo'))) {
return [LoadContext(0,'OYYXUVDIWN'),'ardt_delegabo'];
}
}
