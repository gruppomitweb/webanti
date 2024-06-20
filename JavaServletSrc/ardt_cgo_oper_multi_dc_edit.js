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
l_bEnabled= ! (false) || IsDisabledByStateDriver('FLGFULL');
SetDisabled('FPCQRNSIUW',l_bEnabled);
LibJavascript.forEachItem(m_FoundlingEditExpression,i_body_0)
function i_body_0(child){
child();
}
DisableUI();
if (Ne('undefined',typeof(DisableChainedLinks))) {
DisableChainedLinks(Ne(0,m_oTrs.length));
}
if (inherit && IsWndAccessible(m_oFather) &&  ! (m_oFather.m_bCalculating)) {
m_oFather.EnableControlsUnderCondition();
}
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
function SetDefaultFixedStyles() {
SetErrorField('APQJQKDJEF',false);
SetErrorField('JMCVMUAWAP',false);
SetErrorField('TAACMKNVBE',false);
SetErrorField('SXKQSRVDBA',false);
}
function Set_FLGFULL(ctrlValue,kmode,e) {
if (Ne(w_FLGFULL,ctrlValue)) {
var ctl = _GetCtl(e,'FPCQRNSIUW');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLGFULL=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FPCQRNSIUW',0);
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
function Set_CPROWNUM(ctrlValue,kmode,e) {
if (Ne(w_CPROWNUM,ctrlValue)) {
var ctl = _GetCtl(e,'APQJQKDJEF');
if (_tracker.goon(ctl,ctrlValue)) {
w_CPROWNUM=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('APQJQKDJEF',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','N',4,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_TIPOGIOCO(ctrlValue,kmode,e) {
if (Ne(w_TIPOGIOCO,ctrlValue)) {
var ctl = _GetCtl(e,'BENOJFALBB');
if (_tracker.goon(ctl,ctrlValue)) {
w_TIPOGIOCO=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BENOJFALBB',0);
if (l_bResult) {
l_bResult=Link_BENOJFALBB(kmode);
if ( ! (l_bResult)) {
w_TIPOGIOCO=HtW('','C');
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
function Set_CAIDBIGLIETTO(ctrlValue,kmode,e) {
if (Ne(w_CAIDBIGLIETTO,ctrlValue)) {
var ctl = _GetCtl(e,'LIJFNMVRXK');
if (_tracker.goon(ctl,ctrlValue)) {
w_CAIDBIGLIETTO=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('LIJFNMVRXK',0);
if (l_bResult) {
l_bResult=(Eq(w_CGOTIPOPE,'V')?true:arfn_cgo_chkidb(w_CAIDBIGLIETTO));
if ( ! (l_bResult)) {
m_nLastError=2;
m_cLastWorkVarErrorMsg='10524120562';
m_cLastMsgError=AlertErrorMessage('11525797640');
}
if ( ! (l_bResult)) {
w_CAIDBIGLIETTO=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',30,0,'!'));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',30,0,'!');
_ResetTracker();
return true;
}
}
return true;
}
function Set_ROWNUMDL(ctrlValue,kmode,e) {
if (Ne(w_ROWNUMDL,ctrlValue)) {
var ctl = _GetCtl(e,'ZXEOWMRAEB');
if (_tracker.goon(ctl,ctrlValue)) {
w_ROWNUMDL=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ZXEOWMRAEB',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','N',4,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_snainumope_sel(ctrlValue,kmode,e) {
if (Ne(w_snainumope_sel,ctrlValue)) {
var ctl = _GetCtl(e,'TMCEXVILMD');
if (_tracker.goon(ctl,ctrlValue)) {
w_snainumope_sel=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('TMCEXVILMD',0);
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
function Set_DATOPE(ctrlValue,kmode,e) {
if (Ne(w_DATOPE,ctrlValue)) {
var ctl = _GetCtl(e,'SVYXZEMNRB');
if (_tracker.goon(ctl,ctrlValue)) {
w_DATOPE=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SVYXZEMNRB',0);
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
function Set_TOTLIRE(ctrlValue,kmode,e) {
if (Ne(w_TOTLIRE,ctrlValue)) {
var ctl = _GetCtl(e,'OGHOMBFTXJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_TOTALE=w_TOTALE-w_TOTLIRE;
w_TOTLIRE=ValidNum(ctrlValue,'999999999.99');
SetModified(true);
w_TOTALE=w_TOTALE+w_TOTLIRE;
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('OGHOMBFTXJ',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('OGHOMBFTXJ',function(){return WtH(w_TOTLIRE,'N',15,2,'999,999,999.99')},w_TOTLIRE);
return l_bResult;
} else {
ctl.value=WtH('','N',15,2,'999999999.99');
_ResetTracker();
return true;
}
} else {
SPBOUILib.SetInputValue('OGHOMBFTXJ',function(){return WtH(w_TOTLIRE,'N',15,2,'999,999,999.99')},w_TOTLIRE);
}
return true;
}
function Set_CGOTIPOPE(ctrlValue,kmode,e) {
if (Ne(w_CGOTIPOPE,ctrlValue)) {
var ctl = _GetCtl(e,'TAACMKNVBE');
if (_tracker.goon(ctl,ctrlValue)) {
w_CGOTIPOPE=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('TAACMKNVBE',0);
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
function Set_NUMOPEDL(ctrlValue,kmode,e) {
if (Ne(w_NUMOPEDL,ctrlValue)) {
var ctl = _GetCtl(e,'JMCVMUAWAP');
if (_tracker.goon(ctl,ctrlValue)) {
w_NUMOPEDL=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('JMCVMUAWAP',0);
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
function Set_messaggio(ctrlValue,kmode,e) {
if (Ne(w_messaggio,ctrlValue)) {
var ctl = _GetCtl(e,'SXKQSRVDBA');
if (_tracker.goon(ctl,ctrlValue)) {
w_messaggio=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SXKQSRVDBA',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',200,0,'');
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
m_bHeaderUpdated=true;
w_SEGNO_P=Utilities.Make(window).GetCallerString('SEGNO');
w_CGOTIPOPE_P=Utilities.Make(window).GetCallerString('CGOTIPOPE');
if ((Ne(o_TOTLIRE,w_TOTLIRE))) {
Calculation_INBQRQVGTC();
}
LibJavascript.forEachItem(m_FoundlingCopyWorkVar,i_body_1)
function i_body_1(child){
child();
}
// * --- Area Manuale = UI - Calculate
// * --- ardt_cgo_oper_multi_dc
parent.Set_TOTLIRE(w_TOTALE)
// * --- Fine Area Manuale
m_bCalculating=false;
}
function Calculation_INBQRQVGTC() {
w_FLGFULL=(Empty(w_NUMOPEDL)?(Le(w_TOTLIRE,w_impmin)?'S':'N'):w_FLGFULL);
}
function SaveDependsOn() {
o_TOTLIRE=w_TOTLIRE;
}
function SaveLabelDependsOn() {
}
function Link_BENOJFALBB(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_TIPOGIOCO);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODTPGIO',w_TIPOGIOCO,3,0);
l_Appl.SetFields('CODTPGIO,IMPMINGIO');
l_Appl.SetTypes('C,N');
l_Appl.LinkTable('cgo_tbtipgio');
l_Appl.SetLinkzoom('armt_cgo_tbtipgio');
l_Appl.SetID('BENOJFALBB');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_TIPOGIOCO=l_Appl.GetStringValue('CODTPGIO',3,0);
w_impmin=l_Appl.GetDoubleValue('IMPMINGIO',10,2);
l_Appl.GetLinkHash(GetRepeatedCheckVars());
} else {
Link_BENOJFALBB_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_BENOJFALBB';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_BENOJFALBB();
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
function Link_BENOJFALBB_Blank() {
w_TIPOGIOCO='';
w_impmin=0;
}
function LOpt_BENOJFALBB() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('cgo_tbtipgio','C'));
l_oWv.setValue('Linkzoomprg',WtA('armt_cgo_tbtipgio','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODTPGIO','C'));
l_oWv.setValue('LinkedField',WtA('CODTPGIO','C'));
l_oWv.setValue('UID',WtA('BENOJFALBB','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['BENOJFALBB'][1],'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'BENOJFALBB')) {
last_focused_comp=GetLastFocusedElementOfLink('BENOJFALBB');
function SetMethod_BENOJFALBB() {
Set_TIPOGIOCO(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_BENOJFALBB();
} else {
setTimeout(SetMethod_BENOJFALBB,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'BENOJFALBB')) {
return [Ctrl('BENOJFALBB')];
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
if ( ! (SaveRow())) {
return;
}
if ( ! (Check())) {
DisplayErrorMessage();
return;
}
if ( ! (m_oFather.SaveContext_ardt_cgo_oper_multi_dc())) {
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
NotifyEvent('Before Save Row');
bResult=bResult && SaveRow(true);
if (bResult) {
NotifyEvent('Before Save');
l_Checks();
}
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
parent.ZtVWeb.raiseEventToEvalParms('ardt_cgo_oper_multi_dc_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('ardt_cgo_oper_multi_dc_dataNotSent',{'action':formaction});
}
}
}
}
}
CheckChild.child=[];
function Check() {
var l_bResult = true;
ResetErrorVars();
if ( ! (_ChkObl('TMCEXVILMD',1))) {
_SignErr('TMCEXVILMD');
m_cLastWorkVarErrorMsg='snainumope_sel';
l_bResult=false;
w_snainumope_sel=HtW('','C');
}
if (l_bResult) {
l_bResult=CheckChild(0);
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
if (l_bResult &&  ! (Le(0,Rows()) && Le(Rows(),999))) {
l_bResult=false;
m_nLastError=2;
m_cLastMsgError=Translate('MSG_MINMAX_ROW','0','999');
}
return l_bResult;
}
function link_index(lc) {
if (Eq('SVYXZEMNRB_ZOOM',lc)) {
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
l_oWv.setValue('SNAINUMOPE',WtA(w_SNAINUMOPE,'C'));
l_oWv.setValue('dc',WtA(w_dc,'C'));
l_oWv.setValue('DATOPE_P',WtA(w_DATOPE_P,'D'));
l_oWv.setValue('SEGNO_P',WtA(w_SEGNO_P,'C'));
l_oWv.setValue('CGOTIPOPE_P',WtA(w_CGOTIPOPE_P,'C'));
l_oWv.setValue('TOTALE',WtA(w_TOTALE,'N'));
l_oWv.setValue('snainumope_sel',WtA(w_snainumope_sel,'C'));
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
if (Ne(m_cFunction,'view')) {
l_oWv.setValue('m_bHeaderUpdated',WtA(m_bHeaderUpdated,'L'));
l_oWv.setValue('m_oTrs',TrsApplet().asString());
}
}
_FillChildren.n=[];
FillWv.n=["SNAINUMOPE","dc","DATOPE_P","SEGNO_P","CGOTIPOPE_P","TOTALE","snainumope_sel"];
function CheckRow(w) {
var l_bResult = true;
ResetErrorVars();
if (Le(m_nCurrentRow,Rows())) {
if (( ! (_ChkObl('SVYXZEMNRB',1))) && FullRow()) {
_SignErr('SVYXZEMNRB');
m_cLastWorkVarErrorMsg='829201110';
l_bResult=false;
w_DATOPE=HtW('','D');
} else if (( ! (_ChkObl('BENOJFALBB',1))) && FullRow()) {
_SignErr('BENOJFALBB');
m_cLastWorkVarErrorMsg='1603759671';
l_bResult=false;
w_TIPOGIOCO=HtW('','C');
} else if ((( ! (_ChkObl('LIJFNMVRXK',1))) || ( ! ((Eq(w_CGOTIPOPE,'V')?true:arfn_cgo_chkidb(w_CAIDBIGLIETTO))))) && FullRow()) {
_SignErr('LIJFNMVRXK','11525797640');
l_bResult=false;
w_CAIDBIGLIETTO=HtW('','C');
} else if (( ! (_ChkObl('OGHOMBFTXJ',1))) && FullRow()) {
_SignErr('OGHOMBFTXJ');
m_cLastWorkVarErrorMsg='1991862041';
l_bResult=false;
w_TOTLIRE=HtW('','N');
} else if (((false) && ( ! (_ChkObl('FPCQRNSIUW',1)))) && FullRow()) {
_SignErr('FPCQRNSIUW');
m_cLastWorkVarErrorMsg='11739699278';
l_bResult=false;
w_FLGFULL='N';
} else if (( ! (_ChkObl('APQJQKDJEF',1))) && FullRow()) {
_SignErr('APQJQKDJEF');
m_cLastWorkVarErrorMsg='1742621518';
l_bResult=false;
w_CPROWNUM=HtW('','N');
} else if (( ! (_ChkObl('JMCVMUAWAP',1))) && FullRow()) {
_SignErr('JMCVMUAWAP');
m_cLastWorkVarErrorMsg='129387910';
l_bResult=false;
w_NUMOPEDL=HtW('','C');
} else if (( ! (_ChkObl('ZXEOWMRAEB',1))) && FullRow()) {
_SignErr('ZXEOWMRAEB');
m_cLastWorkVarErrorMsg='1924563585';
l_bResult=false;
w_ROWNUMDL=HtW('','N');
} else if (( ! (_ChkObl('TAACMKNVBE',1))) && FullRow()) {
_SignErr('TAACMKNVBE');
m_cLastWorkVarErrorMsg='1570205239';
l_bResult=false;
w_CGOTIPOPE=HtW('','C');
} else if (( ! (_ChkObl('SXKQSRVDBA',1))) && FullRow()) {
_SignErr('SXKQSRVDBA');
m_cLastWorkVarErrorMsg='662709014';
l_bResult=false;
w_messaggio=HtW('','C');
}
}
if (FullRow()) {
if (l_bResult) {
l_bResult=CheckChild(1);
}
}
DisableChainedLinks(true);
// * --- Area Manuale = UI - Check Row
// * --- Fine Area Manuale
return l_bResult;
}
function CheckDeleteRow() {
var l_bResult = true;
ResetErrorVars();
return l_bResult;
}
function SetModified(bRepeated) {
m_bUpdated=true;
if (bRepeated) {
if (Le(m_nCurrentRow,m_oTrs.length) && Eq(m_nRowStatus,0)) {
m_nRowStatus=1;
}
} else {
m_bHeaderUpdated=true;
}
if (IsWndAccessible(m_oFather)) {
m_oFather.SetModified_ardt_cgo_oper_multi_dc();
}
}
SaveContext.child=[];
function BlankRow() {
w_DATOPE=NullDate();
w_TIPOGIOCO='';
w_CAIDBIGLIETTO='';
w_TOTLIRE=0;
w_FLGFULL='';
w_NUMOPEDL='';
w_ROWNUMDL=0;
w_CACODICE=0;
w_CODLOB='';
w_CATIPGIO=0;
w_CATIPCON=0;
w_CGOTIPOPE='';
w_impmin=0;
w_messaggio='';
w_TIPOGIOCO='A';
if ( ! (EmptyString(w_TIPOGIOCO))) {
Link_BENOJFALBB(null);
}
w_FLGFULL='N';
BlankRowChild();
if (m_bExtended) {
BlankRepeatedExtendedFields();
}
SaveDependsOn();
LoadContext(true);
}
function FullRow() {
return  ! (Empty(w_DATOPE)) &&  ! (Empty(w_CAIDBIGLIETTO)) && Gt(w_TOTLIRE,0);
}
function GetRepeatedFields() {
var l_aRepeatedFields;
l_aRepeatedFields={};
l_aRepeatedFields.DATOPE={"dec":0,"fixedpos":false,"id":"SVYXZEMNRB","len":8,"name":"DATOPE","title":"Data Operazione","type":"D"};
l_aRepeatedFields.TIPOGIOCO={"dec":0,"fixedpos":false,"id":"BENOJFALBB","len":3,"name":"TIPOGIOCO","title":"Tipo gioco","type":"C"};
l_aRepeatedFields.CAIDBIGLIETTO={"dec":0,"fixedpos":false,"id":"LIJFNMVRXK","len":30,"name":"CAIDBIGLIETTO","title":"ID BIGLIETTO","type":"C"};
l_aRepeatedFields.TOTLIRE={"dec":2,"fixedpos":false,"id":"OGHOMBFTXJ","len":15,"name":"TOTLIRE","title":"Importo","type":"N"};
l_aRepeatedFields.FLGFULL={"dec":0,"fixedpos":false,"id":"FPCQRNSIUW","len":1,"name":"FLGFULL","title":"Operazione completa","type":"C"};
l_aRepeatedFields.NUMOPEDL={"dec":0,"fixedpos":true,"id":"JMCVMUAWAP","len":15,"name":"NUMOPEDL","title":"Operazione Associata","type":"C"};
l_aRepeatedFields.ROWNUMDL={"dec":0,"fixedpos":false,"id":"ZXEOWMRAEB","len":4,"name":"ROWNUMDL","title":"Numero Riga Selezionata","type":"N"};
l_aRepeatedFields.CACODICE={"dec":0,"fixedpos":true,"id":"QDNLZJHFIP","len":5,"name":"CACODICE","title":"Codice Causale","type":"N"};
l_aRepeatedFields.CODLOB={"dec":0,"fixedpos":true,"id":"IRGFRGZZQR","len":3,"name":"CODLOB","title":"Line of business","type":"C"};
l_aRepeatedFields.CATIPGIO={"dec":0,"fixedpos":true,"id":"DYOHPAVQQN","len":5,"name":"CATIPGIO","title":"Tipo Gioco","type":"N"};
l_aRepeatedFields.CATIPCON={"dec":0,"fixedpos":true,"id":"HHSJQRKVPD","len":5,"name":"CATIPCON","title":"Tipo Concessione","type":"N"};
l_aRepeatedFields.CGOTIPOPE={"dec":0,"fixedpos":true,"id":"TAACMKNVBE","len":1,"name":"CGOTIPOPE","title":"Tipo Gioco","type":"C"};
l_aRepeatedFields.impmin={"dec":2,"fixedpos":true,"id":"VTKXJCJWPZ","len":10,"name":"impmin","title":"Importo minimo autovalidazione multiple","type":"N"};
l_aRepeatedFields.messaggio={"dec":0,"fixedpos":true,"id":"SXKQSRVDBA","len":200,"name":"messaggio","title":"messaggio da visualizzare","type":"C"};
return l_aRepeatedFields;
}
function SubtractTotals() {
w_TOTALE=w_TOTALE-w_TOTLIRE;
}
function hasDepOnTotals() {
}
function DisableChainedLinks(disable) {
}
function EnableEntityWhenReady(enable) {
if (enable) {
var c;
if(c=Ctrl('TMCEXVILMD')) SetDisabled(c,true);
if(c=Ctrl('APQJQKDJEF')) SetDisabled(c,true);
if(c=Ctrl('JMCVMUAWAP')) SetDisabled(c,true);
if(c=Ctrl('TAACMKNVBE')) SetDisabled(c,true);
if(c=Ctrl('SXKQSRVDBA')) SetDisabled(c,true);
SetQueryRow(Ctrl('GridTable'),false);
} else {
SetEditRow(Ctrl('GridTable'),false);
var c;
if(c=Ctrl('TMCEXVILMD')) SetDisabled(c,false);
if(c=Ctrl('APQJQKDJEF')) SetDisabled(c,false);
if(c=Ctrl('JMCVMUAWAP')) SetDisabled(c,false);
if(c=Ctrl('TAACMKNVBE')) SetDisabled(c,false);
if(c=Ctrl('SXKQSRVDBA')) SetDisabled(c,false);
EnableControlsUnderCondition(false);
}
m_bChildDisabled=enable;
}
