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
SetErrorField('IADEZIJVRP',false);
SetErrorField('TKLYFIYSLT',false);
SetErrorField('PECYSWBJIH',false);
}
function Set_COINT(ctrlValue,kmode,e) {
if (Ne(w_COINT,ctrlValue)) {
var ctl = _GetCtl(e,'HPLDXSAUUT');
if (_tracker.goon(ctl,ctrlValue)) {
w_COINT=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HPLDXSAUUT',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('2','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_NOTE(ctrlValue,kmode,e) {
if (Ne(w_NOTE,ctrlValue)) {
var ctl = _GetCtl(e,'WOCPOWSYXW');
if (_tracker.goon(ctl,ctrlValue)) {
w_NOTE=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('WOCPOWSYXW',0);
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
function Set_ANNO(ctrlValue,kmode,e) {
if (Ne(w_ANNO,ctrlValue)) {
var ctl = _GetCtl(e,'DNNIBYMZGH');
if (_tracker.goon(ctl,ctrlValue)) {
w_ANNO=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('DNNIBYMZGH',0);
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
function Set_SALDO(ctrlValue,kmode,e) {
if (Ne(w_SALDO,ctrlValue)) {
var ctl = _GetCtl(e,'IADEZIJVRP');
if (_tracker.goon(ctl,ctrlValue)) {
w_SALDO=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('IADEZIJVRP',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('IADEZIJVRP',function(){return WtH(w_SALDO,'N',17,0,'99,999,999,999,999')},w_SALDO);
return l_bResult;
} else {
ctl.value=WtH('','N',17,0,'99999999999999999');
_ResetTracker();
return true;
}
} else {
SPBOUILib.SetInputValue('IADEZIJVRP',function(){return WtH(w_SALDO,'N',17,0,'99,999,999,999,999')},w_SALDO);
}
return true;
}
function Set_DATAOPE(ctrlValue,kmode,e) {
if (Ne(w_DATAOPE,ctrlValue)) {
var ctl = _GetCtl(e,'KFGZTRHOBC');
if (_tracker.goon(ctl,ctrlValue)) {
w_DATAOPE=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('KFGZTRHOBC',0);
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
function Set_QUANTITA(ctrlValue,kmode,e) {
if (Ne(w_QUANTITA,ctrlValue)) {
var ctl = _GetCtl(e,'TKLYFIYSLT');
if (_tracker.goon(ctl,ctrlValue)) {
w_QUANTITA=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('TKLYFIYSLT',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','N',6,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_VALUTA(ctrlValue,kmode,e) {
if (Ne(w_VALUTA,ctrlValue)) {
var ctl = _GetCtl(e,'PECYSWBJIH');
if (_tracker.goon(ctl,ctrlValue)) {
w_VALUTA=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('PECYSWBJIH',0);
if (l_bResult) {
l_bResult=Link_PECYSWBJIH(kmode);
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
m_bCalculating=false;
}
function SaveDependsOn() {
}
function SaveLabelDependsOn() {
}
function Link_PECYSWBJIH(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_VALUTA);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODVAL',w_VALUTA,3,0);
l_Appl.SetFields('CODVAL,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbvalute');
l_Appl.SetID('PECYSWBJIH');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_VALUTA=l_Appl.GetStringValue('CODVAL',3,0);
w_xdesval=l_Appl.GetStringValue('DESCRI',45,0);
l_Appl.GetLinkHash(GetRepeatedCheckVars());
} else {
Link_PECYSWBJIH_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_PECYSWBJIH';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_PECYSWBJIH();
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
function Link_PECYSWBJIH_Blank() {
w_VALUTA='';
w_xdesval='';
}
function LOpt_PECYSWBJIH() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbvalute','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODVAL','C'));
l_oWv.setValue('LinkedField',WtA('CODVAL','C'));
l_oWv.setValue('UID',WtA('PECYSWBJIH','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['PECYSWBJIH'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('114016870'),'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'PECYSWBJIH')) {
last_focused_comp=GetLastFocusedElementOfLink('PECYSWBJIH');
function SetMethod_PECYSWBJIH() {
Set_VALUTA(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_PECYSWBJIH();
} else {
setTimeout(SetMethod_PECYSWBJIH,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'PECYSWBJIH')) {
return [Ctrl('PECYSWBJIH')];
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
if ( ! (m_oFather.SaveContext_ardt_opextrbo())) {
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
parent.ZtVWeb.raiseEventToEvalParms('ardt_opextrbo_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('ardt_opextrbo_dataNotSent',{'action':formaction});
}
}
}
}
}
CheckChild.child=[];
function Check() {
var l_bResult = true;
ResetErrorVars();
if (l_bResult) {
l_bResult=CheckChild(0);
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('PECYSWBJIH_ZOOM',lc)) {
return 0;
}
if (Eq('PECYSWBJIH',lc)) {
return 0;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_PECYSWBJIH();
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
l_oWv.setValue('COLLEG',WtA(w_COLLEG,'C'));
l_oWv.setValue('gAzienda',WtA(w_gAzienda,'C'));
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
FillWv.n=["COLLEG","gAzienda"];
function CheckRow(w) {
var l_bResult = true;
ResetErrorVars();
if (Le(m_nCurrentRow,Rows())) {
if (( ! (_ChkObl('DNNIBYMZGH',1))) && FullRow()) {
_SignErr('DNNIBYMZGH');
m_cLastWorkVarErrorMsg='999531942';
l_bResult=false;
w_ANNO=HtW('','C');
} else if (( ! (_ChkObl('KFGZTRHOBC',1))) && FullRow()) {
_SignErr('KFGZTRHOBC');
m_cLastWorkVarErrorMsg='829201110';
l_bResult=false;
w_DATAOPE=HtW('','D');
} else if (( ! (_ChkObl('HPLDXSAUUT',1))) && FullRow()) {
_SignErr('HPLDXSAUUT');
m_cLastWorkVarErrorMsg='10521849619';
l_bResult=false;
w_COINT='2';
} else if (( ! (_ChkObl('WOCPOWSYXW',1))) && FullRow()) {
_SignErr('WOCPOWSYXW');
m_cLastWorkVarErrorMsg='445246';
l_bResult=false;
w_NOTE=HtW('','C');
} else if (( ! (_ChkObl('IADEZIJVRP',1))) && FullRow()) {
_SignErr('IADEZIJVRP');
m_cLastWorkVarErrorMsg='SALDO';
l_bResult=false;
w_SALDO=HtW('','N');
} else if (( ! (_ChkObl('TKLYFIYSLT',1))) && FullRow()) {
_SignErr('TKLYFIYSLT');
m_cLastWorkVarErrorMsg='1878793056';
l_bResult=false;
w_QUANTITA=HtW('','N');
} else if (( ! (_ChkObl('PECYSWBJIH',1))) && FullRow()) {
_SignErr('PECYSWBJIH');
m_cLastWorkVarErrorMsg='VALUTA';
l_bResult=false;
w_VALUTA=HtW('','C');
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
m_oFather.SetModified_ardt_opextrbo();
}
}
SaveContext.child=[];
function BlankRow() {
w_ANNO='';
w_IDBASE='';
w_DATAOPE=NullDate();
w_COINT='';
w_NOTE='';
w_SALDO=0;
w_QUANTITA=0;
w_VALUTA='';
w_xdesval='';
w_PROGOPEX=0;
w_COINT='2';
w_VALUTA='242';
if ( ! (EmptyString(w_VALUTA))) {
Link_PECYSWBJIH(null);
}
BlankRowChild();
if (m_bExtended) {
BlankRepeatedExtendedFields();
}
SaveDependsOn();
LoadContext(true);
}
function FullRow() {
return  ! (Empty(w_ANNO));
}
function GetRepeatedFields() {
var l_aRepeatedFields;
l_aRepeatedFields={};
l_aRepeatedFields.ANNO={"dec":0,"fixedpos":false,"id":"DNNIBYMZGH","len":4,"name":"ANNO","title":"Anno riferimento","type":"C"};
l_aRepeatedFields.IDBASE={"dec":0,"fixedpos":false,"id":"IYWNKCHHZW","len":10,"name":"IDBASE","title":"Chiave Riga","type":"C"};
l_aRepeatedFields.DATAOPE={"dec":0,"fixedpos":false,"id":"KFGZTRHOBC","len":8,"name":"DATAOPE","title":"Data Operazione","type":"D"};
l_aRepeatedFields.COINT={"dec":0,"fixedpos":false,"id":"HPLDXSAUUT","len":1,"name":"COINT","title":"Delega Conto Terzi","type":"C"};
l_aRepeatedFields.NOTE={"dec":0,"fixedpos":false,"id":"WOCPOWSYXW","len":50,"name":"NOTE","title":"Note","type":"C"};
l_aRepeatedFields.SALDO={"dec":0,"fixedpos":true,"id":"IADEZIJVRP","len":17,"name":"SALDO","title":"","type":"N"};
l_aRepeatedFields.QUANTITA={"dec":0,"fixedpos":true,"id":"TKLYFIYSLT","len":6,"name":"QUANTITA","title":"Numero di Operazioni","type":"N"};
l_aRepeatedFields.VALUTA={"dec":0,"fixedpos":true,"id":"PECYSWBJIH","len":3,"name":"VALUTA","title":"","type":"C"};
l_aRepeatedFields.PROGOPEX={"dec":0,"fixedpos":true,"id":"IBRMPBOOWD","len":10,"name":"PROGOPEX","title":"Progressivo Import","type":"N"};
l_aRepeatedFields.xdesval={"dec":0,"fixedpos":true,"id":"MMNOVNIZTJ","len":45,"name":"xdesval","title":"Descrizione","type":"C"};
return l_aRepeatedFields;
}
function SubtractTotals() {
}
function hasDepOnTotals() {
}
function DisableChainedLinks(disable) {
}
function EnableEntityWhenReady(enable) {
if (enable) {
var c;
if(c=Ctrl('IADEZIJVRP')) SetDisabled(c,true);
if(c=Ctrl('TKLYFIYSLT')) SetDisabled(c,true);
if(c=Ctrl('PECYSWBJIH')) SetDisabled(c,true);
if(c=Ctrl('PECYSWBJIH_ZOOM')) SetDisabled(c,true);
SetQueryRow(Ctrl('GridTable'),false);
} else {
SetEditRow(Ctrl('GridTable'),false);
var c;
if(c=Ctrl('IADEZIJVRP')) SetDisabled(c,false);
if(c=Ctrl('TKLYFIYSLT')) SetDisabled(c,false);
if(c=Ctrl('PECYSWBJIH')) SetDisabled(c,false);
if(c=Ctrl('PECYSWBJIH_ZOOM')) SetDisabled(c,false);
EnableControlsUnderCondition(false);
}
m_bChildDisabled=enable;
}
