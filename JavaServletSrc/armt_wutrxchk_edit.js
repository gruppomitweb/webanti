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
}
function SetDynamicClasses() {
var c;
}
function SetDynamicTooltip() {
var c;
}
function Set_TRXERROR17(ctrlValue,kmode,e) {
if (Ne(w_TRXERROR17,ctrlValue)) {
var ctl = _GetCtl(e,'HUIFQLIZHZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXERROR17=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HUIFQLIZHZ',0);
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
function Set_TRXDOMICI(ctrlValue,kmode,e) {
if (Ne(w_TRXDOMICI,ctrlValue)) {
var ctl = _GetCtl(e,'AQPBKHBXWC');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXDOMICI=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('AQPBKHBXWC',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',100,0,'');
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
ctl.value=WtH('','C',1,0,'');
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
function Set_TRXAUTRIL(ctrlValue,kmode,e) {
if (Ne(w_TRXAUTRIL,ctrlValue)) {
var ctl = _GetCtl(e,'OHDLYDFRFV');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXAUTRIL=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('OHDLYDFRFV',0);
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
function Set_TRXNAZRES(ctrlValue,kmode,e) {
if (Ne(w_TRXNAZRES,ctrlValue)) {
var ctl = _GetCtl(e,'UUXGHAXWLH');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXNAZRES=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UUXGHAXWLH',0);
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
function Set_TRXCITRES(ctrlValue,kmode,e) {
if (Ne(w_TRXCITRES,ctrlValue)) {
var ctl = _GetCtl(e,'XSZDOLIZKJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXCITRES=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XSZDOLIZKJ',0);
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
function Set_TRXTIPDOC(ctrlValue,kmode,e) {
if (Ne(w_TRXTIPDOC,ctrlValue)) {
var ctl = _GetCtl(e,'TTQTFXMWFO');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXTIPDOC=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('TTQTFXMWFO',0);
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
function Set_TRXDATOPE(ctrlValue,kmode,e) {
if (Ne(w_TRXDATOPE,ctrlValue)) {
var ctl = _GetCtl(e,'ZOASUUNSDC');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXDATOPE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ZOASUUNSDC',0);
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
function Set_TRXFLGCON(ctrlValue,kmode,e) {
if (Ne(w_TRXFLGCON,ctrlValue)) {
var ctl = _GetCtl(e,'TQMBDRYXLU');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXFLGCON=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('TQMBDRYXLU',0);
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
function Set_TRSSEGNO(ctrlValue,kmode,e) {
if (Ne(w_TRSSEGNO,ctrlValue)) {
var ctl = _GetCtl(e,'EPEPXVTDDF');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRSSEGNO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('EPEPXVTDDF',0);
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
function Set_TRXIMPORTO(ctrlValue,kmode,e) {
if (Ne(w_TRXIMPORTO,ctrlValue)) {
var ctl = _GetCtl(e,'FNVGSTOZTQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXIMPORTO=ValidNum(ctrlValue,'999999999999.99');
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FNVGSTOZTQ',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('FNVGSTOZTQ',function(){return WtH(w_TRXIMPORTO,'N',15,2,'999999999999.99')},w_TRXIMPORTO);
return l_bResult;
} else {
ctl.value=WtH('','N',15,2,'999999999999.99');
_ResetTracker();
return true;
}
}
return true;
}
function Set_TRXCONTAN(ctrlValue,kmode,e) {
if (Ne(w_TRXCONTAN,ctrlValue)) {
var ctl = _GetCtl(e,'EVKHOJDUVF');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXCONTAN=ValidNum(ctrlValue,'999999999999.99');
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('EVKHOJDUVF',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('EVKHOJDUVF',function(){return WtH(w_TRXCONTAN,'N',15,2,'999999999999.99')},w_TRXCONTAN);
return l_bResult;
} else {
ctl.value=WtH('','N',15,2,'999999999999.99');
_ResetTracker();
return true;
}
}
return true;
}
function Set_TRXUNIQUE(ctrlValue,kmode,e) {
if (Ne(w_TRXUNIQUE,ctrlValue)) {
var ctl = _GetCtl(e,'FCRFUHHVHU');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXUNIQUE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FCRFUHHVHU',0);
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
function Set_TRXCODDIP(ctrlValue,kmode,e) {
if (Ne(w_TRXCODDIP,ctrlValue)) {
var ctl = _GetCtl(e,'HZPBCLSNRS');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXCODDIP=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HZPBCLSNRS',0);
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
function Set_TRXCOGCON(ctrlValue,kmode,e) {
if (Ne(w_TRXCOGCON,ctrlValue)) {
var ctl = _GetCtl(e,'LGVQVJPZZP');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXCOGCON=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('LGVQVJPZZP',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',100,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_TRXNOMCON(ctrlValue,kmode,e) {
if (Ne(w_TRXNOMCON,ctrlValue)) {
var ctl = _GetCtl(e,'OKKVRBSRDN');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXNOMCON=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('OKKVRBSRDN',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',100,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_TRXDESTIN(ctrlValue,kmode,e) {
if (Ne(w_TRXDESTIN,ctrlValue)) {
var ctl = _GetCtl(e,'FDXEUOOSVN');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXDESTIN=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FDXEUOOSVN',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',100,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_TRXMTCN(ctrlValue,kmode,e) {
if (Ne(w_TRXMTCN,ctrlValue)) {
var ctl = _GetCtl(e,'YZULLMXBBH');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXMTCN=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YZULLMXBBH',0);
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
function Set_TRXDATNAS(ctrlValue,kmode,e) {
if (Ne(w_TRXDATNAS,ctrlValue)) {
var ctl = _GetCtl(e,'MMHGERKOXN');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXDATNAS=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MMHGERKOXN',0);
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
function Set_TRXSESSO(ctrlValue,kmode,e) {
if (Ne(w_TRXSESSO,ctrlValue)) {
var ctl = _GetCtl(e,'CQZWBPQLNL');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXSESSO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CQZWBPQLNL',0);
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
function Set_TRXCODCAS(ctrlValue,kmode,e) {
if (Ne(w_TRXCODCAS,ctrlValue)) {
var ctl = _GetCtl(e,'UTGSXNXPVT');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXCODCAS=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UTGSXNXPVT',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',4,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_TRXRECTYPE(ctrlValue,kmode,e) {
if (Ne(w_TRXRECTYPE,ctrlValue)) {
var ctl = _GetCtl(e,'FMRUIANURB');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXRECTYPE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FMRUIANURB',0);
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
function Set_TRXCODMAG(ctrlValue,kmode,e) {
if (Ne(w_TRXCODMAG,ctrlValue)) {
var ctl = _GetCtl(e,'UTFQIBBLAF');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXCODMAG=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UTFQIBBLAF',0);
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
function Set_TRXCODUNI(ctrlValue,kmode,e) {
if (Ne(w_TRXCODUNI,ctrlValue)) {
var ctl = _GetCtl(e,'NSNBJQWLKR');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXCODUNI=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NSNBJQWLKR',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',18,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_TRXERROR01(ctrlValue,kmode,e) {
if (Ne(w_TRXERROR01,ctrlValue)) {
var ctl = _GetCtl(e,'UCHSJHQNIV');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXERROR01=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UCHSJHQNIV',0);
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
function Set_TRXERROR02(ctrlValue,kmode,e) {
if (Ne(w_TRXERROR02,ctrlValue)) {
var ctl = _GetCtl(e,'GKZAXYVJEW');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXERROR02=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('GKZAXYVJEW',0);
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
function Set_TRXERROR03(ctrlValue,kmode,e) {
if (Ne(w_TRXERROR03,ctrlValue)) {
var ctl = _GetCtl(e,'SYKQVOROAS');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXERROR03=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SYKQVOROAS',0);
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
function Set_TRXERROR04(ctrlValue,kmode,e) {
if (Ne(w_TRXERROR04,ctrlValue)) {
var ctl = _GetCtl(e,'WXHVIATWKM');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXERROR04=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('WXHVIATWKM',0);
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
function Set_TRXERROR05(ctrlValue,kmode,e) {
if (Ne(w_TRXERROR05,ctrlValue)) {
var ctl = _GetCtl(e,'YCDTVJJIMR');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXERROR05=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YCDTVJJIMR',0);
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
function Set_TRXERROR06(ctrlValue,kmode,e) {
if (Ne(w_TRXERROR06,ctrlValue)) {
var ctl = _GetCtl(e,'BACNEOKNNG');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXERROR06=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BACNEOKNNG',0);
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
function Set_TRXERROR07(ctrlValue,kmode,e) {
if (Ne(w_TRXERROR07,ctrlValue)) {
var ctl = _GetCtl(e,'RVIBIVADUM');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXERROR07=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RVIBIVADUM',0);
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
function Set_TRXERROR08(ctrlValue,kmode,e) {
if (Ne(w_TRXERROR08,ctrlValue)) {
var ctl = _GetCtl(e,'XOBPJRQPBZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXERROR08=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XOBPJRQPBZ',0);
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
function Set_TRXERROR09(ctrlValue,kmode,e) {
if (Ne(w_TRXERROR09,ctrlValue)) {
var ctl = _GetCtl(e,'RFAJDLABHK');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXERROR09=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RFAJDLABHK',0);
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
function Set_TRXERROR10(ctrlValue,kmode,e) {
if (Ne(w_TRXERROR10,ctrlValue)) {
var ctl = _GetCtl(e,'LNJHQTAPKH');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXERROR10=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('LNJHQTAPKH',0);
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
function Set_TRXERROR11(ctrlValue,kmode,e) {
if (Ne(w_TRXERROR11,ctrlValue)) {
var ctl = _GetCtl(e,'BXBAWWFZDV');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXERROR11=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BXBAWWFZDV',0);
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
function Set_TRXERROR12(ctrlValue,kmode,e) {
if (Ne(w_TRXERROR12,ctrlValue)) {
var ctl = _GetCtl(e,'GLAQECICHA');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXERROR12=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('GLAQECICHA',0);
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
function Set_TRXERROR13(ctrlValue,kmode,e) {
if (Ne(w_TRXERROR13,ctrlValue)) {
var ctl = _GetCtl(e,'KLEBFCDCIF');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXERROR13=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('KLEBFCDCIF',0);
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
function Set_TRXERROR14(ctrlValue,kmode,e) {
if (Ne(w_TRXERROR14,ctrlValue)) {
var ctl = _GetCtl(e,'WXIZZGFGYV');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXERROR14=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('WXIZZGFGYV',0);
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
function Set_TRXERROR15(ctrlValue,kmode,e) {
if (Ne(w_TRXERROR15,ctrlValue)) {
var ctl = _GetCtl(e,'VDAZXJXDXY');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXERROR15=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VDAZXJXDXY',0);
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
function Set_TRXERROR16(ctrlValue,kmode,e) {
if (Ne(w_TRXERROR16,ctrlValue)) {
var ctl = _GetCtl(e,'JANNSGSWGM');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXERROR16=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('JANNSGSWGM',0);
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
function Set_TRXERROR41(ctrlValue,kmode,e) {
if (Ne(w_TRXERROR41,ctrlValue)) {
var ctl = _GetCtl(e,'DYIXHFFDPL');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXERROR41=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('DYIXHFFDPL',0);
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
function Set_TRXERROR18(ctrlValue,kmode,e) {
if (Ne(w_TRXERROR18,ctrlValue)) {
var ctl = _GetCtl(e,'YPMKIOATIZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXERROR18=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YPMKIOATIZ',0);
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
function Set_TRXERROR19(ctrlValue,kmode,e) {
if (Ne(w_TRXERROR19,ctrlValue)) {
var ctl = _GetCtl(e,'KGAEUMDODK');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXERROR19=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('KGAEUMDODK',0);
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
function Set_TRXERROR20(ctrlValue,kmode,e) {
if (Ne(w_TRXERROR20,ctrlValue)) {
var ctl = _GetCtl(e,'VGBNUNWCXY');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXERROR20=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VGBNUNWCXY',0);
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
function Set_TRXERROR21(ctrlValue,kmode,e) {
if (Ne(w_TRXERROR21,ctrlValue)) {
var ctl = _GetCtl(e,'DLAKPEHAYJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXERROR21=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('DLAKPEHAYJ',0);
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
function Set_TRXERROR22(ctrlValue,kmode,e) {
if (Ne(w_TRXERROR22,ctrlValue)) {
var ctl = _GetCtl(e,'JEDPFHJRZS');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXERROR22=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('JEDPFHJRZS',0);
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
function Set_TRXERROR23(ctrlValue,kmode,e) {
if (Ne(w_TRXERROR23,ctrlValue)) {
var ctl = _GetCtl(e,'BMIRKKOHKR');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXERROR23=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BMIRKKOHKR',0);
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
function Set_TRXERROR24(ctrlValue,kmode,e) {
if (Ne(w_TRXERROR24,ctrlValue)) {
var ctl = _GetCtl(e,'OHTYWCOOIK');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXERROR24=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('OHTYWCOOIK',0);
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
function Set_TRXERROR25(ctrlValue,kmode,e) {
if (Ne(w_TRXERROR25,ctrlValue)) {
var ctl = _GetCtl(e,'LAAPMSXDPL');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXERROR25=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('LAAPMSXDPL',0);
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
function Set_TRXERROR26(ctrlValue,kmode,e) {
if (Ne(w_TRXERROR26,ctrlValue)) {
var ctl = _GetCtl(e,'ASSPEANDMC');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXERROR26=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ASSPEANDMC',0);
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
function Set_TRXERROR27(ctrlValue,kmode,e) {
if (Ne(w_TRXERROR27,ctrlValue)) {
var ctl = _GetCtl(e,'FMOIMQZAPG');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXERROR27=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FMOIMQZAPG',0);
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
function Set_TRXERROR28(ctrlValue,kmode,e) {
if (Ne(w_TRXERROR28,ctrlValue)) {
var ctl = _GetCtl(e,'RKGHXZFQZL');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXERROR28=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RKGHXZFQZL',0);
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
function Set_TRXERROR29(ctrlValue,kmode,e) {
if (Ne(w_TRXERROR29,ctrlValue)) {
var ctl = _GetCtl(e,'HEPMULJALS');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXERROR29=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HEPMULJALS',0);
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
function Set_TRXERROR30(ctrlValue,kmode,e) {
if (Ne(w_TRXERROR30,ctrlValue)) {
var ctl = _GetCtl(e,'DYBWDBXZIJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXERROR30=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('DYBWDBXZIJ',0);
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
function Set_TRXERROR31(ctrlValue,kmode,e) {
if (Ne(w_TRXERROR31,ctrlValue)) {
var ctl = _GetCtl(e,'LISOLVFJNF');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXERROR31=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('LISOLVFJNF',0);
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
function Set_TRXERROR32(ctrlValue,kmode,e) {
if (Ne(w_TRXERROR32,ctrlValue)) {
var ctl = _GetCtl(e,'BHISKUARAJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXERROR32=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BHISKUARAJ',0);
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
function Set_TRXERROR33(ctrlValue,kmode,e) {
if (Ne(w_TRXERROR33,ctrlValue)) {
var ctl = _GetCtl(e,'MSSBSWBLKI');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXERROR33=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MSSBSWBLKI',0);
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
function Set_TRXERROR34(ctrlValue,kmode,e) {
if (Ne(w_TRXERROR34,ctrlValue)) {
var ctl = _GetCtl(e,'ATBSEHTJHH');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXERROR34=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ATBSEHTJHH',0);
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
function Set_TRXERROR35(ctrlValue,kmode,e) {
if (Ne(w_TRXERROR35,ctrlValue)) {
var ctl = _GetCtl(e,'CIFSRVZLSK');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXERROR35=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CIFSRVZLSK',0);
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
function Set_TRXERROR36(ctrlValue,kmode,e) {
if (Ne(w_TRXERROR36,ctrlValue)) {
var ctl = _GetCtl(e,'FCOYAJZYOF');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXERROR36=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FCOYAJZYOF',0);
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
function Set_TRXERROR37(ctrlValue,kmode,e) {
if (Ne(w_TRXERROR37,ctrlValue)) {
var ctl = _GetCtl(e,'ZNHTQWPUYJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXERROR37=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ZNHTQWPUYJ',0);
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
function Set_TRXERROR38(ctrlValue,kmode,e) {
if (Ne(w_TRXERROR38,ctrlValue)) {
var ctl = _GetCtl(e,'ULYZEYIIYY');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXERROR38=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ULYZEYIIYY',0);
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
function Set_TRXERROR39(ctrlValue,kmode,e) {
if (Ne(w_TRXERROR39,ctrlValue)) {
var ctl = _GetCtl(e,'ZRCBZVUWZE');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXERROR39=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ZRCBZVUWZE',0);
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
function Set_TRXERROR40(ctrlValue,kmode,e) {
if (Ne(w_TRXERROR40,ctrlValue)) {
var ctl = _GetCtl(e,'TCMPTOYHZU');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXERROR40=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('TCMPTOYHZU',0);
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
function Set_TRXERRAUA03(ctrlValue,kmode,e) {
if (Ne(w_TRXERRAUA03,ctrlValue)) {
var ctl = _GetCtl(e,'ZMIFMDQNYQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXERRAUA03=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ZMIFMDQNYQ',0);
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
function Set_TRXERROR42(ctrlValue,kmode,e) {
if (Ne(w_TRXERROR42,ctrlValue)) {
var ctl = _GetCtl(e,'OZIAVQGVQX');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXERROR42=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('OZIAVQGVQX',0);
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
function Set_TRXERROR43(ctrlValue,kmode,e) {
if (Ne(w_TRXERROR43,ctrlValue)) {
var ctl = _GetCtl(e,'QURNMKDXBF');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXERROR43=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QURNMKDXBF',0);
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
function Set_TRXERROR44(ctrlValue,kmode,e) {
if (Ne(w_TRXERROR44,ctrlValue)) {
var ctl = _GetCtl(e,'MNXGCWMDZI');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXERROR44=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MNXGCWMDZI',0);
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
function Set_TRXERROR45(ctrlValue,kmode,e) {
if (Ne(w_TRXERROR45,ctrlValue)) {
var ctl = _GetCtl(e,'YJUYZEFYVU');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXERROR45=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YJUYZEFYVU',0);
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
function Set_TRXERROR46(ctrlValue,kmode,e) {
if (Ne(w_TRXERROR46,ctrlValue)) {
var ctl = _GetCtl(e,'ASNHGNRDBH');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXERROR46=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ASNHGNRDBH',0);
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
function Set_TRXERROR47(ctrlValue,kmode,e) {
if (Ne(w_TRXERROR47,ctrlValue)) {
var ctl = _GetCtl(e,'CZSDXMRIYM');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXERROR47=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CZSDXMRIYM',0);
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
function Set_TRXERROR48(ctrlValue,kmode,e) {
if (Ne(w_TRXERROR48,ctrlValue)) {
var ctl = _GetCtl(e,'XVGSKNYKNU');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXERROR48=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XVGSKNYKNU',0);
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
function Set_TRXERROR49(ctrlValue,kmode,e) {
if (Ne(w_TRXERROR49,ctrlValue)) {
var ctl = _GetCtl(e,'BBGXFOFUHV');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXERROR49=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BBGXFOFUHV',0);
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
function Set_TRXERROR50(ctrlValue,kmode,e) {
if (Ne(w_TRXERROR50,ctrlValue)) {
var ctl = _GetCtl(e,'VKWSDIQTXK');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXERROR50=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VKWSDIQTXK',0);
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
function Set_TRXERRAUA01(ctrlValue,kmode,e) {
if (Ne(w_TRXERRAUA01,ctrlValue)) {
var ctl = _GetCtl(e,'CCGIZJLERV');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXERRAUA01=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CCGIZJLERV',0);
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
function Set_TRXERRAUA02(ctrlValue,kmode,e) {
if (Ne(w_TRXERRAUA02,ctrlValue)) {
var ctl = _GetCtl(e,'MTBGPENFET');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXERRAUA02=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MTBGPENFET',0);
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
function Set_TRXERRAUA09(ctrlValue,kmode,e) {
if (Ne(w_TRXERRAUA09,ctrlValue)) {
var ctl = _GetCtl(e,'KFCAVRRATM');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXERRAUA09=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('KFCAVRRATM',0);
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
function Set_TRXERRAUA04(ctrlValue,kmode,e) {
if (Ne(w_TRXERRAUA04,ctrlValue)) {
var ctl = _GetCtl(e,'ZUQTYJIIJM');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXERRAUA04=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ZUQTYJIIJM',0);
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
function Set_TRXERRAUA05(ctrlValue,kmode,e) {
if (Ne(w_TRXERRAUA05,ctrlValue)) {
var ctl = _GetCtl(e,'AOEPKWEXRJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXERRAUA05=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('AOEPKWEXRJ',0);
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
function Set_TRXERRAUA06(ctrlValue,kmode,e) {
if (Ne(w_TRXERRAUA06,ctrlValue)) {
var ctl = _GetCtl(e,'ZBTRCKIJIQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXERRAUA06=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ZBTRCKIJIQ',0);
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
function Set_TRXERRAUA07(ctrlValue,kmode,e) {
if (Ne(w_TRXERRAUA07,ctrlValue)) {
var ctl = _GetCtl(e,'QGWHOSGSAK');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXERRAUA07=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QGWHOSGSAK',0);
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
function Set_TRXERRAUA08(ctrlValue,kmode,e) {
if (Ne(w_TRXERRAUA08,ctrlValue)) {
var ctl = _GetCtl(e,'SFBVLLFNDJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXERRAUA08=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SFBVLLFNDJ',0);
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
function Set_TRXFLGAUA(ctrlValue,kmode,e) {
if (Ne(w_TRXFLGAUA,ctrlValue)) {
var ctl = _GetCtl(e,'VVULUOUJPH');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXFLGAUA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VVULUOUJPH',0);
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
function Set_TRXERRAUA10(ctrlValue,kmode,e) {
if (Ne(w_TRXERRAUA10,ctrlValue)) {
var ctl = _GetCtl(e,'HFAJKTAOKR');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXERRAUA10=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HFAJKTAOKR',0);
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
function Set_TRXFLGAUI(ctrlValue,kmode,e) {
if (Ne(w_TRXFLGAUI,ctrlValue)) {
var ctl = _GetCtl(e,'TZHYQAUMDE');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXFLGAUI=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('TZHYQAUMDE',0);
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
ctl.value=WtH('','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_TRXAUICHK(ctrlValue,kmode,e) {
if (Ne(w_TRXAUICHK,ctrlValue)) {
var ctl = _GetCtl(e,'CCAWGNNPOR');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXAUICHK=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CCAWGNNPOR',0);
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
function Set_TRXAUACHK(ctrlValue,kmode,e) {
if (Ne(w_TRXAUACHK,ctrlValue)) {
var ctl = _GetCtl(e,'RTICLPEDBN');
if (_tracker.goon(ctl,ctrlValue)) {
w_TRXAUACHK=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RTICLPEDBN',0);
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
function Calculate() {
var l_bTmpRes;
var l_bResult = true;
m_bCalculating=true;
LibJavascript.forEachItem(m_FoundlingCopyWorkVar,i_body_1)
function i_body_1(child){
child();
}
// * --- Area Manuale = UI - Calculate
// * --- Fine Area Manuale
UpdateAutonumber('');
m_bCalculating=false;
}
function SaveDependsOn() {
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
parent.ZtVWeb.raiseEventToEvalParms('armt_wutrxchk_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('armt_wutrxchk_dataNotSent',{'action':formaction});
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
} else if ( ! (_ChkObl('AQPBKHBXWC',1))) {
_SignErr('AQPBKHBXWC');
m_cLastWorkVarErrorMsg='49939619';
l_bResult=false;
w_TRXDOMICI=HtW('','C');
} else if ( ! (_ChkObl('GOZRBLFKLS',1))) {
_SignErr('GOZRBLFKLS');
m_cLastWorkVarErrorMsg='1563406272';
l_bResult=false;
w_TRXFLGCF=HtW('','C');
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
} else if ( ! (_ChkObl('OHDLYDFRFV',1))) {
_SignErr('OHDLYDFRFV');
m_cLastWorkVarErrorMsg='979125998';
l_bResult=false;
w_TRXAUTRIL=HtW('','C');
} else if ( ! (_ChkObl('UUXGHAXWLH',1))) {
_SignErr('UUXGHAXWLH');
m_cLastWorkVarErrorMsg='485943447';
l_bResult=false;
w_TRXNAZRES=HtW('','C');
} else if ( ! (_ChkObl('XSZDOLIZKJ',1))) {
_SignErr('XSZDOLIZKJ');
m_cLastWorkVarErrorMsg='580410781';
l_bResult=false;
w_TRXCITRES=HtW('','C');
} else if ( ! (_ChkObl('TTQTFXMWFO',1))) {
_SignErr('TTQTFXMWFO');
m_cLastWorkVarErrorMsg='11429032151';
l_bResult=false;
w_TRXTIPDOC=HtW('','C');
} else if ( ! (_ChkObl('ZOASUUNSDC',1))) {
_SignErr('ZOASUUNSDC');
m_cLastWorkVarErrorMsg='829201110';
l_bResult=false;
w_TRXDATOPE=HtW('','D');
} else if ( ! (_ChkObl('TQMBDRYXLU',1))) {
_SignErr('TQMBDRYXLU');
m_cLastWorkVarErrorMsg='1405586570';
l_bResult=false;
w_TRXFLGCON=HtW('','C');
} else if ( ! (_ChkObl('EPEPXVTDDF',1))) {
_SignErr('EPEPXVTDDF');
m_cLastWorkVarErrorMsg='1316049330';
l_bResult=false;
w_TRSSEGNO=HtW('','C');
} else if ( ! (_ChkObl('FNVGSTOZTQ',1))) {
_SignErr('FNVGSTOZTQ');
m_cLastWorkVarErrorMsg='1991862041';
l_bResult=false;
w_TRXIMPORTO=HtW('','N');
} else if ( ! (_ChkObl('EVKHOJDUVF',1))) {
_SignErr('EVKHOJDUVF');
m_cLastWorkVarErrorMsg='10884427469';
l_bResult=false;
w_TRXCONTAN=HtW('','N');
} else if ( ! (_ChkObl('FCRFUHHVHU',1))) {
_SignErr('FCRFUHHVHU');
m_cLastWorkVarErrorMsg='11228111751';
l_bResult=false;
w_TRXUNIQUE=HtW('','C');
} else if ( ! (_ChkObl('HZPBCLSNRS',1))) {
_SignErr('HZPBCLSNRS');
m_cLastWorkVarErrorMsg='1027280874';
l_bResult=false;
w_TRXCODDIP=HtW('','C');
} else if ( ! (_ChkObl('LGVQVJPZZP',1))) {
_SignErr('LGVQVJPZZP');
m_cLastWorkVarErrorMsg='10206540776';
l_bResult=false;
w_TRXCOGCON=HtW('','C');
} else if ( ! (_ChkObl('OKKVRBSRDN',1))) {
_SignErr('OKKVRBSRDN');
m_cLastWorkVarErrorMsg='517946066';
l_bResult=false;
w_TRXNOMCON=HtW('','C');
} else if ( ! (_ChkObl('FDXEUOOSVN',1))) {
_SignErr('FDXEUOOSVN');
m_cLastWorkVarErrorMsg='10302116186';
l_bResult=false;
w_TRXDESTIN=HtW('','C');
} else if ( ! (_ChkObl('YZULLMXBBH',1))) {
_SignErr('YZULLMXBBH');
m_cLastWorkVarErrorMsg='829110543';
l_bResult=false;
w_TRXMTCN=HtW('','C');
} else if ( ! (_ChkObl('MMHGERKOXN',1))) {
_SignErr('MMHGERKOXN');
m_cLastWorkVarErrorMsg='10703188046';
l_bResult=false;
w_TRXDATNAS=HtW('','D');
} else if ( ! (_ChkObl('CQZWBPQLNL',1))) {
_SignErr('CQZWBPQLNL');
m_cLastWorkVarErrorMsg='7776675';
l_bResult=false;
w_TRXSESSO=HtW('','C');
} else if ( ! (_ChkObl('UTGSXNXPVT',1))) {
_SignErr('UTGSXNXPVT');
m_cLastWorkVarErrorMsg='423990228';
l_bResult=false;
w_TRXCODCAS=HtW('','C');
} else if ( ! (_ChkObl('FMRUIANURB',1))) {
_SignErr('FMRUIANURB');
m_cLastWorkVarErrorMsg='11706569101';
l_bResult=false;
w_TRXRECTYPE=HtW('','C');
} else if ( ! (_ChkObl('UTFQIBBLAF',1))) {
_SignErr('UTFQIBBLAF');
m_cLastWorkVarErrorMsg='1114794632';
l_bResult=false;
w_TRXCODMAG=HtW('','C');
} else if ( ! (_ChkObl('NSNBJQWLKR',1))) {
_SignErr('NSNBJQWLKR');
m_cLastWorkVarErrorMsg='2115266609';
l_bResult=false;
w_TRXCODUNI=HtW('','C');
} else if ( ! (_ChkObl('UCHSJHQNIV',1))) {
_SignErr('UCHSJHQNIV');
m_cLastWorkVarErrorMsg='919169381';
l_bResult=false;
w_TRXERROR01=HtW('','C');
} else if ( ! (_ChkObl('GKZAXYVJEW',1))) {
_SignErr('GKZAXYVJEW');
m_cLastWorkVarErrorMsg='1187604837';
l_bResult=false;
w_TRXERROR02=HtW('','C');
} else if ( ! (_ChkObl('SYKQVOROAS',1))) {
_SignErr('SYKQVOROAS');
m_cLastWorkVarErrorMsg='1456040293';
l_bResult=false;
w_TRXERROR03=HtW('','C');
} else if ( ! (_ChkObl('WXHVIATWKM',1))) {
_SignErr('WXHVIATWKM');
m_cLastWorkVarErrorMsg='1724475749';
l_bResult=false;
w_TRXERROR04=HtW('','C');
} else if ( ! (_ChkObl('YCDTVJJIMR',1))) {
_SignErr('YCDTVJJIMR');
m_cLastWorkVarErrorMsg='1992911205';
l_bResult=false;
w_TRXERROR05=HtW('','C');
} else if ( ! (_ChkObl('BACNEOKNNG',1))) {
_SignErr('BACNEOKNNG');
m_cLastWorkVarErrorMsg='12033620635';
l_bResult=false;
w_TRXERROR06=HtW('','C');
} else if ( ! (_ChkObl('RVIBIVADUM',1))) {
_SignErr('RVIBIVADUM');
m_cLastWorkVarErrorMsg='11765185179';
l_bResult=false;
w_TRXERROR07=HtW('','C');
} else if ( ! (_ChkObl('XOBPJRQPBZ',1))) {
_SignErr('XOBPJRQPBZ');
m_cLastWorkVarErrorMsg='11496749723';
l_bResult=false;
w_TRXERROR08=HtW('','C');
} else if ( ! (_ChkObl('RFAJDLABHK',1))) {
_SignErr('RFAJDLABHK');
m_cLastWorkVarErrorMsg='11228314267';
l_bResult=false;
w_TRXERROR09=HtW('','C');
} else if ( ! (_ChkObl('LNJHQTAPKH',1))) {
_SignErr('LNJHQTAPKH');
m_cLastWorkVarErrorMsg='919169429';
l_bResult=false;
w_TRXERROR10=HtW('','C');
} else if ( ! (_ChkObl('BXBAWWFZDV',1))) {
_SignErr('BXBAWWFZDV');
m_cLastWorkVarErrorMsg='919169430';
l_bResult=false;
w_TRXERROR11=HtW('','C');
} else if ( ! (_ChkObl('GLAQECICHA',1))) {
_SignErr('GLAQECICHA');
m_cLastWorkVarErrorMsg='919169431';
l_bResult=false;
w_TRXERROR12=HtW('','C');
} else if ( ! (_ChkObl('KLEBFCDCIF',1))) {
_SignErr('KLEBFCDCIF');
m_cLastWorkVarErrorMsg='919169432';
l_bResult=false;
w_TRXERROR13=HtW('','C');
} else if ( ! (_ChkObl('WXIZZGFGYV',1))) {
_SignErr('WXIZZGFGYV');
m_cLastWorkVarErrorMsg='919169433';
l_bResult=false;
w_TRXERROR14=HtW('','C');
} else if ( ! (_ChkObl('VDAZXJXDXY',1))) {
_SignErr('VDAZXJXDXY');
m_cLastWorkVarErrorMsg='919169434';
l_bResult=false;
w_TRXERROR15=HtW('','C');
} else if ( ! (_ChkObl('JANNSGSWGM',1))) {
_SignErr('JANNSGSWGM');
m_cLastWorkVarErrorMsg='919169435';
l_bResult=false;
w_TRXERROR16=HtW('','C');
} else if ( ! (_ChkObl('HUIFQLIZHZ',1))) {
_SignErr('HUIFQLIZHZ');
m_cLastWorkVarErrorMsg='919169436';
l_bResult=false;
w_TRXERROR17=HtW('','C');
} else if ( ! (_ChkObl('YPMKIOATIZ',1))) {
_SignErr('YPMKIOATIZ');
m_cLastWorkVarErrorMsg='919169437';
l_bResult=false;
w_TRXERROR18=HtW('','C');
} else if ( ! (_ChkObl('KGAEUMDODK',1))) {
_SignErr('KGAEUMDODK');
m_cLastWorkVarErrorMsg='919169438';
l_bResult=false;
w_TRXERROR19=HtW('','C');
} else if ( ! (_ChkObl('VGBNUNWCXY',1))) {
_SignErr('VGBNUNWCXY');
m_cLastWorkVarErrorMsg='1187604885';
l_bResult=false;
w_TRXERROR20=HtW('','C');
} else if ( ! (_ChkObl('DLAKPEHAYJ',1))) {
_SignErr('DLAKPEHAYJ');
m_cLastWorkVarErrorMsg='1187604886';
l_bResult=false;
w_TRXERROR21=HtW('','C');
} else if ( ! (_ChkObl('JEDPFHJRZS',1))) {
_SignErr('JEDPFHJRZS');
m_cLastWorkVarErrorMsg='1187604887';
l_bResult=false;
w_TRXERROR22=HtW('','C');
} else if ( ! (_ChkObl('BMIRKKOHKR',1))) {
_SignErr('BMIRKKOHKR');
m_cLastWorkVarErrorMsg='1187604888';
l_bResult=false;
w_TRXERROR23=HtW('','C');
} else if ( ! (_ChkObl('OHTYWCOOIK',1))) {
_SignErr('OHTYWCOOIK');
m_cLastWorkVarErrorMsg='1187604889';
l_bResult=false;
w_TRXERROR24=HtW('','C');
} else if ( ! (_ChkObl('LAAPMSXDPL',1))) {
_SignErr('LAAPMSXDPL');
m_cLastWorkVarErrorMsg='1187604890';
l_bResult=false;
w_TRXERROR25=HtW('','C');
} else if ( ! (_ChkObl('ASSPEANDMC',1))) {
_SignErr('ASSPEANDMC');
m_cLastWorkVarErrorMsg='1187604891';
l_bResult=false;
w_TRXERROR26=HtW('','C');
} else if ( ! (_ChkObl('FMOIMQZAPG',1))) {
_SignErr('FMOIMQZAPG');
m_cLastWorkVarErrorMsg='11463195291';
l_bResult=false;
w_TRXERROR27=HtW('','C');
} else if ( ! (_ChkObl('RKGHXZFQZL',1))) {
_SignErr('RKGHXZFQZL');
m_cLastWorkVarErrorMsg='1187604893';
l_bResult=false;
w_TRXERROR28=HtW('','C');
} else if ( ! (_ChkObl('HEPMULJALS',1))) {
_SignErr('HEPMULJALS');
m_cLastWorkVarErrorMsg='1187604894';
l_bResult=false;
w_TRXERROR29=HtW('','C');
} else if ( ! (_ChkObl('DYBWDBXZIJ',1))) {
_SignErr('DYBWDBXZIJ');
m_cLastWorkVarErrorMsg='1456040341';
l_bResult=false;
w_TRXERROR30=HtW('','C');
} else if ( ! (_ChkObl('LISOLVFJNF',1))) {
_SignErr('LISOLVFJNF');
m_cLastWorkVarErrorMsg='1456040342';
l_bResult=false;
w_TRXERROR31=HtW('','C');
} else if ( ! (_ChkObl('BHISKUARAJ',1))) {
_SignErr('BHISKUARAJ');
m_cLastWorkVarErrorMsg='1456040343';
l_bResult=false;
w_TRXERROR32=HtW('','C');
} else if ( ! (_ChkObl('MSSBSWBLKI',1))) {
_SignErr('MSSBSWBLKI');
m_cLastWorkVarErrorMsg='1456040344';
l_bResult=false;
w_TRXERROR33=HtW('','C');
} else if ( ! (_ChkObl('ATBSEHTJHH',1))) {
_SignErr('ATBSEHTJHH');
m_cLastWorkVarErrorMsg='1456040345';
l_bResult=false;
w_TRXERROR34=HtW('','C');
} else if ( ! (_ChkObl('CIFSRVZLSK',1))) {
_SignErr('CIFSRVZLSK');
m_cLastWorkVarErrorMsg='1456040346';
l_bResult=false;
w_TRXERROR35=HtW('','C');
} else if ( ! (_ChkObl('FCOYAJZYOF',1))) {
_SignErr('FCOYAJZYOF');
m_cLastWorkVarErrorMsg='1456040347';
l_bResult=false;
w_TRXERROR36=HtW('','C');
} else if ( ! (_ChkObl('ZNHTQWPUYJ',1))) {
_SignErr('ZNHTQWPUYJ');
m_cLastWorkVarErrorMsg='1456040348';
l_bResult=false;
w_TRXERROR37=HtW('','C');
} else if ( ! (_ChkObl('ULYZEYIIYY',1))) {
_SignErr('ULYZEYIIYY');
m_cLastWorkVarErrorMsg='1456040349';
l_bResult=false;
w_TRXERROR38=HtW('','C');
} else if ( ! (_ChkObl('ZRCBZVUWZE',1))) {
_SignErr('ZRCBZVUWZE');
m_cLastWorkVarErrorMsg='1456040350';
l_bResult=false;
w_TRXERROR39=HtW('','C');
} else if ( ! (_ChkObl('TCMPTOYHZU',1))) {
_SignErr('TCMPTOYHZU');
m_cLastWorkVarErrorMsg='1724475797';
l_bResult=false;
w_TRXERROR40=HtW('','C');
} else if ( ! (_ChkObl('DYIXHFFDPL',1))) {
_SignErr('DYIXHFFDPL');
m_cLastWorkVarErrorMsg='1724475798';
l_bResult=false;
w_TRXERROR41=HtW('','C');
} else if ( ! (_ChkObl('OZIAVQGVQX',1))) {
_SignErr('OZIAVQGVQX');
m_cLastWorkVarErrorMsg='1724475799';
l_bResult=false;
w_TRXERROR42=HtW('','C');
} else if ( ! (_ChkObl('QURNMKDXBF',1))) {
_SignErr('QURNMKDXBF');
m_cLastWorkVarErrorMsg='1724475800';
l_bResult=false;
w_TRXERROR43=HtW('','C');
} else if ( ! (_ChkObl('MNXGCWMDZI',1))) {
_SignErr('MNXGCWMDZI');
m_cLastWorkVarErrorMsg='1724475801';
l_bResult=false;
w_TRXERROR44=HtW('','C');
} else if ( ! (_ChkObl('YJUYZEFYVU',1))) {
_SignErr('YJUYZEFYVU');
m_cLastWorkVarErrorMsg='1724475802';
l_bResult=false;
w_TRXERROR45=HtW('','C');
} else if ( ! (_ChkObl('ASNHGNRDBH',1))) {
_SignErr('ASNHGNRDBH');
m_cLastWorkVarErrorMsg='1724475803';
l_bResult=false;
w_TRXERROR46=HtW('','C');
} else if ( ! (_ChkObl('CZSDXMRIYM',1))) {
_SignErr('CZSDXMRIYM');
m_cLastWorkVarErrorMsg='1724475804';
l_bResult=false;
w_TRXERROR47=HtW('','C');
} else if ( ! (_ChkObl('XVGSKNYKNU',1))) {
_SignErr('XVGSKNYKNU');
m_cLastWorkVarErrorMsg='1724475805';
l_bResult=false;
w_TRXERROR48=HtW('','C');
} else if ( ! (_ChkObl('BBGXFOFUHV',1))) {
_SignErr('BBGXFOFUHV');
m_cLastWorkVarErrorMsg='1724475806';
l_bResult=false;
w_TRXERROR49=HtW('','C');
} else if ( ! (_ChkObl('VKWSDIQTXK',1))) {
_SignErr('VKWSDIQTXK');
m_cLastWorkVarErrorMsg='1992911253';
l_bResult=false;
w_TRXERROR50=HtW('','C');
} else if ( ! (_ChkObl('CCGIZJLERV',1))) {
_SignErr('CCGIZJLERV');
m_cLastWorkVarErrorMsg='919379402';
l_bResult=false;
w_TRXERRAUA01=HtW('','C');
} else if ( ! (_ChkObl('MTBGPENFET',1))) {
_SignErr('MTBGPENFET');
m_cLastWorkVarErrorMsg='919383498';
l_bResult=false;
w_TRXERRAUA02=HtW('','C');
} else if ( ! (_ChkObl('ZMIFMDQNYQ',1))) {
_SignErr('ZMIFMDQNYQ');
m_cLastWorkVarErrorMsg='919387594';
l_bResult=false;
w_TRXERRAUA03=HtW('','C');
} else if ( ! (_ChkObl('ZUQTYJIIJM',1))) {
_SignErr('ZUQTYJIIJM');
m_cLastWorkVarErrorMsg='919391690';
l_bResult=false;
w_TRXERRAUA04=HtW('','C');
} else if ( ! (_ChkObl('AOEPKWEXRJ',1))) {
_SignErr('AOEPKWEXRJ');
m_cLastWorkVarErrorMsg='919395786';
l_bResult=false;
w_TRXERRAUA05=HtW('','C');
} else if ( ! (_ChkObl('ZBTRCKIJIQ',1))) {
_SignErr('ZBTRCKIJIQ');
m_cLastWorkVarErrorMsg='919399882';
l_bResult=false;
w_TRXERRAUA06=HtW('','C');
} else if ( ! (_ChkObl('QGWHOSGSAK',1))) {
_SignErr('QGWHOSGSAK');
m_cLastWorkVarErrorMsg='919403978';
l_bResult=false;
w_TRXERRAUA07=HtW('','C');
} else if ( ! (_ChkObl('SFBVLLFNDJ',1))) {
_SignErr('SFBVLLFNDJ');
m_cLastWorkVarErrorMsg='919408074';
l_bResult=false;
w_TRXERRAUA08=HtW('','C');
} else if ( ! (_ChkObl('KFCAVRRATM',1))) {
_SignErr('KFCAVRRATM');
m_cLastWorkVarErrorMsg='919412170';
l_bResult=false;
w_TRXERRAUA09=HtW('','C');
} else if ( ! (_ChkObl('HFAJKTAOKR',1))) {
_SignErr('HFAJKTAOKR');
m_cLastWorkVarErrorMsg='922525130';
l_bResult=false;
w_TRXERRAUA10=HtW('','C');
} else if ( ! (_ChkObl('TZHYQAUMDE',1))) {
_SignErr('TZHYQAUMDE');
m_cLastWorkVarErrorMsg='887948673';
l_bResult=false;
w_TRXFLGAUI=HtW('','C');
} else if ( ! (_ChkObl('VVULUOUJPH',1))) {
_SignErr('VVULUOUJPH');
m_cLastWorkVarErrorMsg='753730945';
l_bResult=false;
w_TRXFLGAUA=HtW('','C');
} else if ( ! (_ChkObl('CMGWBYDKHQ',1))) {
_SignErr('CMGWBYDKHQ');
m_cLastWorkVarErrorMsg='1636021524';
l_bResult=false;
w_TRXFLGFOR=HtW('','C');
} else if ( ! (_ChkObl('CCAWGNNPOR',1))) {
_SignErr('CCAWGNNPOR');
m_cLastWorkVarErrorMsg='1008402043';
l_bResult=false;
w_TRXAUICHK=HtW('','C');
} else if ( ! (_ChkObl('RTICLPEDBN',1))) {
_SignErr('RTICLPEDBN');
m_cLastWorkVarErrorMsg='1008402035';
l_bResult=false;
w_TRXAUACHK=HtW('','C');
}
if (l_bResult) {
l_bResult=CheckChild(0);
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('EMCTEYNINS_ZOOM',lc)) {
return 0;
}
if (Eq('ETDFWVULIM_ZOOM',lc)) {
return 0;
}
if (Eq('ZOASUUNSDC_ZOOM',lc)) {
return 0;
}
if (Eq('MMHGERKOXN_ZOOM',lc)) {
return 0;
}
return -1;
}
function link_url(index) {
var l_oWv;
}
function FillWv() {
var l_oWv = InitWvApplet();
l_oWv.setValue('m_CheckVars',JSON.stringify(m_CheckVars));
l_oWv.setValue('TRXCODPRG',WtA(w_TRXCODPRG,'N'));
l_oWv.setValue('op_TRXCODPRG',WtA(op_TRXCODPRG,'N'));
l_oWv.setValue('TRXCOGNOM',WtA(w_TRXCOGNOM,'C'));
l_oWv.setValue('TRXNOME',WtA(w_TRXNOME,'C'));
l_oWv.setValue('TRXDOMICI',WtA(w_TRXDOMICI,'C'));
l_oWv.setValue('TRXFLGCF',WtA(w_TRXFLGCF,'C'));
l_oWv.setValue('TRXCODFIS',WtA(w_TRXCODFIS,'C'));
l_oWv.setValue('TRXLUONAS',WtA(w_TRXLUONAS,'C'));
l_oWv.setValue('TRXNUMDOC',WtA(w_TRXNUMDOC,'C'));
l_oWv.setValue('TRXDATSCA',WtA(w_TRXDATSCA,'D'));
l_oWv.setValue('TRXDATRIL',WtA(w_TRXDATRIL,'D'));
l_oWv.setValue('TRXAUTRIL',WtA(w_TRXAUTRIL,'C'));
l_oWv.setValue('TRXNAZRES',WtA(w_TRXNAZRES,'C'));
l_oWv.setValue('TRXCITRES',WtA(w_TRXCITRES,'C'));
l_oWv.setValue('TRXTIPDOC',WtA(w_TRXTIPDOC,'C'));
l_oWv.setValue('TRXDATOPE',WtA(w_TRXDATOPE,'D'));
l_oWv.setValue('TRXFLGCON',WtA(w_TRXFLGCON,'C'));
l_oWv.setValue('TRSSEGNO',WtA(w_TRSSEGNO,'C'));
l_oWv.setValue('TRXIMPORTO',WtA(w_TRXIMPORTO,'N'));
l_oWv.setValue('TRXCONTAN',WtA(w_TRXCONTAN,'N'));
l_oWv.setValue('TRXUNIQUE',WtA(w_TRXUNIQUE,'C'));
l_oWv.setValue('TRXCODDIP',WtA(w_TRXCODDIP,'C'));
l_oWv.setValue('TRXCOGCON',WtA(w_TRXCOGCON,'C'));
l_oWv.setValue('TRXNOMCON',WtA(w_TRXNOMCON,'C'));
l_oWv.setValue('TRXDESTIN',WtA(w_TRXDESTIN,'C'));
l_oWv.setValue('TRXMTCN',WtA(w_TRXMTCN,'C'));
l_oWv.setValue('TRXDATNAS',WtA(w_TRXDATNAS,'D'));
l_oWv.setValue('TRXSESSO',WtA(w_TRXSESSO,'C'));
l_oWv.setValue('TRXCODCAS',WtA(w_TRXCODCAS,'C'));
l_oWv.setValue('TRXRECTYPE',WtA(w_TRXRECTYPE,'C'));
l_oWv.setValue('TRXCODMAG',WtA(w_TRXCODMAG,'C'));
l_oWv.setValue('TRXCODUNI',WtA(w_TRXCODUNI,'C'));
l_oWv.setValue('TRXERROR01',WtA(w_TRXERROR01,'C'));
l_oWv.setValue('TRXERROR02',WtA(w_TRXERROR02,'C'));
l_oWv.setValue('TRXERROR03',WtA(w_TRXERROR03,'C'));
l_oWv.setValue('TRXERROR04',WtA(w_TRXERROR04,'C'));
l_oWv.setValue('TRXERROR05',WtA(w_TRXERROR05,'C'));
l_oWv.setValue('TRXERROR06',WtA(w_TRXERROR06,'C'));
l_oWv.setValue('TRXERROR07',WtA(w_TRXERROR07,'C'));
l_oWv.setValue('TRXERROR08',WtA(w_TRXERROR08,'C'));
l_oWv.setValue('TRXERROR09',WtA(w_TRXERROR09,'C'));
l_oWv.setValue('TRXERROR10',WtA(w_TRXERROR10,'C'));
l_oWv.setValue('TRXERROR11',WtA(w_TRXERROR11,'C'));
l_oWv.setValue('TRXERROR12',WtA(w_TRXERROR12,'C'));
l_oWv.setValue('TRXERROR13',WtA(w_TRXERROR13,'C'));
l_oWv.setValue('TRXERROR14',WtA(w_TRXERROR14,'C'));
l_oWv.setValue('TRXERROR15',WtA(w_TRXERROR15,'C'));
l_oWv.setValue('TRXERROR16',WtA(w_TRXERROR16,'C'));
l_oWv.setValue('TRXERROR17',WtA(w_TRXERROR17,'C'));
l_oWv.setValue('TRXERROR18',WtA(w_TRXERROR18,'C'));
l_oWv.setValue('TRXERROR19',WtA(w_TRXERROR19,'C'));
l_oWv.setValue('TRXERROR20',WtA(w_TRXERROR20,'C'));
l_oWv.setValue('TRXERROR21',WtA(w_TRXERROR21,'C'));
l_oWv.setValue('TRXERROR22',WtA(w_TRXERROR22,'C'));
l_oWv.setValue('TRXERROR23',WtA(w_TRXERROR23,'C'));
l_oWv.setValue('TRXERROR24',WtA(w_TRXERROR24,'C'));
l_oWv.setValue('TRXERROR25',WtA(w_TRXERROR25,'C'));
l_oWv.setValue('TRXERROR26',WtA(w_TRXERROR26,'C'));
l_oWv.setValue('TRXERROR27',WtA(w_TRXERROR27,'C'));
l_oWv.setValue('TRXERROR28',WtA(w_TRXERROR28,'C'));
l_oWv.setValue('TRXERROR29',WtA(w_TRXERROR29,'C'));
l_oWv.setValue('TRXERROR30',WtA(w_TRXERROR30,'C'));
l_oWv.setValue('TRXERROR31',WtA(w_TRXERROR31,'C'));
l_oWv.setValue('TRXERROR32',WtA(w_TRXERROR32,'C'));
l_oWv.setValue('TRXERROR33',WtA(w_TRXERROR33,'C'));
l_oWv.setValue('TRXERROR34',WtA(w_TRXERROR34,'C'));
l_oWv.setValue('TRXERROR35',WtA(w_TRXERROR35,'C'));
l_oWv.setValue('TRXERROR36',WtA(w_TRXERROR36,'C'));
l_oWv.setValue('TRXERROR37',WtA(w_TRXERROR37,'C'));
l_oWv.setValue('TRXERROR38',WtA(w_TRXERROR38,'C'));
l_oWv.setValue('TRXERROR39',WtA(w_TRXERROR39,'C'));
l_oWv.setValue('TRXERROR40',WtA(w_TRXERROR40,'C'));
l_oWv.setValue('TRXERROR41',WtA(w_TRXERROR41,'C'));
l_oWv.setValue('TRXERROR42',WtA(w_TRXERROR42,'C'));
l_oWv.setValue('TRXERROR43',WtA(w_TRXERROR43,'C'));
l_oWv.setValue('TRXERROR44',WtA(w_TRXERROR44,'C'));
l_oWv.setValue('TRXERROR45',WtA(w_TRXERROR45,'C'));
l_oWv.setValue('TRXERROR46',WtA(w_TRXERROR46,'C'));
l_oWv.setValue('TRXERROR47',WtA(w_TRXERROR47,'C'));
l_oWv.setValue('TRXERROR48',WtA(w_TRXERROR48,'C'));
l_oWv.setValue('TRXERROR49',WtA(w_TRXERROR49,'C'));
l_oWv.setValue('TRXERROR50',WtA(w_TRXERROR50,'C'));
l_oWv.setValue('TRXERRAUA01',WtA(w_TRXERRAUA01,'C'));
l_oWv.setValue('TRXERRAUA02',WtA(w_TRXERRAUA02,'C'));
l_oWv.setValue('TRXERRAUA03',WtA(w_TRXERRAUA03,'C'));
l_oWv.setValue('TRXERRAUA04',WtA(w_TRXERRAUA04,'C'));
l_oWv.setValue('TRXERRAUA05',WtA(w_TRXERRAUA05,'C'));
l_oWv.setValue('TRXERRAUA06',WtA(w_TRXERRAUA06,'C'));
l_oWv.setValue('TRXERRAUA07',WtA(w_TRXERRAUA07,'C'));
l_oWv.setValue('TRXERRAUA08',WtA(w_TRXERRAUA08,'C'));
l_oWv.setValue('TRXERRAUA09',WtA(w_TRXERRAUA09,'C'));
l_oWv.setValue('TRXERRAUA10',WtA(w_TRXERRAUA10,'C'));
l_oWv.setValue('TRXFLGAUI',WtA(w_TRXFLGAUI,'C'));
l_oWv.setValue('TRXFLGAUA',WtA(w_TRXFLGAUA,'C'));
l_oWv.setValue('TRXFLGFOR',WtA(w_TRXFLGFOR,'C'));
l_oWv.setValue('TRXAUICHK',WtA(w_TRXAUICHK,'C'));
l_oWv.setValue('TRXAUACHK',WtA(w_TRXAUACHK,'C'));
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
FillWv.n=["TRXCODPRG","TRXCOGNOM","TRXNOME","TRXDOMICI","TRXFLGCF","TRXCODFIS","TRXLUONAS","TRXNUMDOC","TRXDATSCA","TRXDATRIL","TRXAUTRIL","TRXNAZRES","TRXCITRES","TRXTIPDOC","TRXDATOPE","TRXFLGCON","TRSSEGNO","TRXIMPORTO","TRXCONTAN","TRXUNIQUE","TRXCODDIP","TRXCOGCON","TRXNOMCON","TRXDESTIN","TRXMTCN","TRXDATNAS","TRXSESSO","TRXCODCAS","TRXRECTYPE","TRXCODMAG","TRXCODUNI","TRXERROR01","TRXERROR02","TRXERROR03","TRXERROR04","TRXERROR05","TRXERROR06","TRXERROR07","TRXERROR08","TRXERROR09","TRXERROR10","TRXERROR11","TRXERROR12","TRXERROR13","TRXERROR14","TRXERROR15","TRXERROR16","TRXERROR17","TRXERROR18","TRXERROR19","TRXERROR20","TRXERROR21","TRXERROR22","TRXERROR23","TRXERROR24","TRXERROR25","TRXERROR26","TRXERROR27","TRXERROR28","TRXERROR29","TRXERROR30","TRXERROR31","TRXERROR32","TRXERROR33","TRXERROR34","TRXERROR35","TRXERROR36","TRXERROR37","TRXERROR38","TRXERROR39","TRXERROR40","TRXERROR41","TRXERROR42","TRXERROR43","TRXERROR44","TRXERROR45","TRXERROR46","TRXERROR47","TRXERROR48","TRXERROR49","TRXERROR50","TRXERRAUA01","TRXERRAUA02","TRXERRAUA03","TRXERRAUA04","TRXERRAUA05","TRXERRAUA06","TRXERRAUA07","TRXERRAUA08","TRXERRAUA09","TRXERRAUA10","TRXFLGAUI","TRXFLGAUA","TRXFLGFOR","TRXAUICHK","TRXAUACHK"];
function SetModified() {
m_bUpdated=true;
}
