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
SetErrorField('QIKDMUYRQZ',false);
SetErrorField('ARBDBAASEB',false);
SetErrorField('XPJIVBDIXS',false);
SetErrorField('QMLLHINIKD',false);
SetErrorField('DTNUYRRYDZ',false);
}
function Set_DATAINI(ctrlValue,kmode,e) {
if (Ne(w_DATAINI,ctrlValue)) {
var ctl = _GetCtl(e,'ARBDBAASEB');
if (_tracker.goon(ctl,ctrlValue)) {
w_DATAINI=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ARBDBAASEB',0);
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
function Set_CODINTER(ctrlValue,kmode,e) {
if (Ne(w_CODINTER,ctrlValue)) {
var ctl = _GetCtl(e,'NMXBOMFUCN');
if (_tracker.goon(ctl,ctrlValue)) {
w_CODINTER=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NMXBOMFUCN',0);
if (l_bResult) {
l_bResult=Link_NMXBOMFUCN(kmode);
if ( ! (l_bResult)) {
w_CODINTER=HtW('','C');
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
function Set_DATAFINE(ctrlValue,kmode,e) {
if (Ne(w_DATAFINE,ctrlValue)) {
var ctl = _GetCtl(e,'XPJIVBDIXS');
if (_tracker.goon(ctl,ctrlValue)) {
w_DATAFINE=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XPJIVBDIXS',0);
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
function Set_PRIMO(ctrlValue,kmode,e) {
if (Ne(w_PRIMO,ctrlValue)) {
var ctl = _GetCtl(e,'QIKDMUYRQZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_PRIMO=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QIKDMUYRQZ',0);
DoUpdate(l_bResult);
if(c=Ctrl('QIKDMUYRQZ')) ChkboxCheckUncheck(c,1,w_PRIMO)
if(c=Ctrl('QIKDMUYRQZ')) ChkboxValueAssign(c,1,0,'N',1,0,'')
return l_bResult;
} else {
ctl.value=WtH(0,'N',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_TIPOLEG(ctrlValue,kmode,e) {
if (Ne(w_TIPOLEG,ctrlValue)) {
var ctl = _GetCtl(e,'QMLLHINIKD');
if (_tracker.goon(ctl,ctrlValue)) {
w_TIPOLEG=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QMLLHINIKD',0);
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
function Set_RUOLO(ctrlValue,kmode,e) {
if (Ne(w_RUOLO,ctrlValue)) {
var ctl = _GetCtl(e,'DTNUYRRYDZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_RUOLO=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('DTNUYRRYDZ',0);
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
m_bCalculating=false;
}
function SaveDependsOn() {
}
function SaveLabelDependsOn() {
}
function Link_NMXBOMFUCN(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CODINTER);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CONNES',w_CODINTER,16,0);
l_Appl.SetFields('CONNES,RAGSOC');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('personbo');
l_Appl.SetID('NMXBOMFUCN');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CODINTER=l_Appl.GetStringValue('CONNES',16,0);
w_xRAGSOC=l_Appl.GetStringValue('RAGSOC',70,0);
l_Appl.GetLinkHash(GetRepeatedCheckVars());
} else {
Link_NMXBOMFUCN_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_NMXBOMFUCN';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_NMXBOMFUCN();
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
function Link_NMXBOMFUCN_Blank() {
w_CODINTER='';
w_xRAGSOC='';
}
function LOpt_NMXBOMFUCN() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('personbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CONNES','C'));
l_oWv.setValue('LinkedField',WtA('CONNES','C'));
l_oWv.setValue('UID',WtA('NMXBOMFUCN','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['NMXBOMFUCN'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('195812931'),'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'NMXBOMFUCN')) {
last_focused_comp=GetLastFocusedElementOfLink('NMXBOMFUCN');
function SetMethod_NMXBOMFUCN() {
Set_CODINTER(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_NMXBOMFUCN();
} else {
setTimeout(SetMethod_NMXBOMFUCN,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'NMXBOMFUCN')) {
return [Ctrl('NMXBOMFUCN')];
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
if ( ! (m_oFather.SaveContext_ardt_soggope())) {
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
parent.ZtVWeb.raiseEventToEvalParms('ardt_soggope_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('ardt_soggope_dataNotSent',{'action':formaction});
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
if (Eq('NMXBOMFUCN_ZOOM',lc)) {
return 0;
}
if (Eq('NMXBOMFUCN',lc)) {
return 0;
}
if (Eq('ARBDBAASEB_ZOOM',lc)) {
return 1;
}
if (Eq('XPJIVBDIXS_ZOOM',lc)) {
return 1;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_NMXBOMFUCN();
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
FillWv.n=["COLLEG"];
function CheckRow(w) {
var l_bResult = true;
ResetErrorVars();
if (Le(m_nCurrentRow,Rows())) {
if (( ! (_ChkObl('NMXBOMFUCN',1))) && FullRow()) {
_SignErr('NMXBOMFUCN');
m_cLastWorkVarErrorMsg='1968237748';
l_bResult=false;
w_CODINTER=HtW('','C');
} else if (( ! (_ChkObl('QIKDMUYRQZ',1))) && FullRow()) {
_SignErr('QIKDMUYRQZ');
m_cLastWorkVarErrorMsg='1289874503';
l_bResult=false;
w_PRIMO=0;
} else if (( ! (_ChkObl('ARBDBAASEB',1))) && FullRow()) {
_SignErr('ARBDBAASEB');
m_cLastWorkVarErrorMsg='45547614';
l_bResult=false;
w_DATAINI=HtW('','D');
} else if (( ! (_ChkObl('XPJIVBDIXS',1))) && FullRow()) {
_SignErr('XPJIVBDIXS');
m_cLastWorkVarErrorMsg='1300662969';
l_bResult=false;
w_DATAFINE=HtW('','D');
} else if (( ! (_ChkObl('QMLLHINIKD',1))) && FullRow()) {
_SignErr('QMLLHINIKD');
m_cLastWorkVarErrorMsg='10639118571';
l_bResult=false;
w_TIPOLEG=HtW('','C');
} else if (( ! (_ChkObl('DTNUYRRYDZ',1))) && FullRow()) {
_SignErr('DTNUYRRYDZ');
m_cLastWorkVarErrorMsg='7747234';
l_bResult=false;
w_RUOLO=HtW('','C');
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
m_oFather.SetModified_ardt_soggope();
}
}
SaveContext.child=[];
function BlankRow() {
w_CODINTER='';
w_IDBASE='';
w_PRIMO=0;
w_DATAINI=NullDate();
w_DATAFINE=NullDate();
w_TIPOLEG='';
w_RUOLO='';
w_xRAGSOC='';
if ( ! (EmptyString(w_CODINTER))) {
Link_NMXBOMFUCN(null);
}
BlankRowChild();
if (m_bExtended) {
BlankRepeatedExtendedFields();
}
SaveDependsOn();
LoadContext(true);
}
function FullRow() {
return  ! (Empty(w_CODINTER));
}
function GetRepeatedFields() {
var l_aRepeatedFields;
l_aRepeatedFields={};
l_aRepeatedFields.CODINTER={"dec":0,"fixedpos":false,"id":"NMXBOMFUCN","len":16,"name":"CODINTER","title":"Codice Soggetto Collegato","type":"C"};
l_aRepeatedFields.IDBASE={"dec":0,"fixedpos":true,"id":"GVTYMSYKTP","len":10,"name":"IDBASE","title":"ID Riga","type":"C"};
l_aRepeatedFields.PRIMO={"dec":0,"fixedpos":true,"id":"QIKDMUYRQZ","len":1,"name":"PRIMO","title":"Primo Soggetto","type":"N"};
l_aRepeatedFields.DATAINI={"dec":0,"fixedpos":true,"id":"ARBDBAASEB","len":8,"name":"DATAINI","title":"Data Inizio","type":"D"};
l_aRepeatedFields.DATAFINE={"dec":0,"fixedpos":true,"id":"XPJIVBDIXS","len":8,"name":"DATAFINE","title":"Data Fine","type":"D"};
l_aRepeatedFields.TIPOLEG={"dec":0,"fixedpos":true,"id":"QMLLHINIKD","len":1,"name":"TIPOLEG","title":"Tipo Legame","type":"C"};
l_aRepeatedFields.RUOLO={"dec":0,"fixedpos":true,"id":"DTNUYRRYDZ","len":1,"name":"RUOLO","title":"Ruolo","type":"C"};
l_aRepeatedFields.xRAGSOC={"dec":0,"fixedpos":true,"id":"EZAKPDKVDE","len":70,"name":"xRAGSOC","title":"Ragione Sociale","type":"C"};
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
if(c=Ctrl('QIKDMUYRQZ')) SetDisabled(c,true);
if(c=Ctrl('ARBDBAASEB')) SetDisabled(c,true);
if(c=Ctrl('ARBDBAASEB_ZOOM')) SetDisabled(c,true);
if(c=Ctrl('XPJIVBDIXS')) SetDisabled(c,true);
if(c=Ctrl('XPJIVBDIXS_ZOOM')) SetDisabled(c,true);
if(c=Ctrl('QMLLHINIKD')) SetDisabled(c,true);
if(c=Ctrl('DTNUYRRYDZ')) SetDisabled(c,true);
SetQueryRow(Ctrl('GridTable'),false);
} else {
SetEditRow(Ctrl('GridTable'),false);
var c;
if(c=Ctrl('QIKDMUYRQZ')) SetDisabled(c,false);
if(c=Ctrl('ARBDBAASEB')) SetDisabled(c,false);
if(c=Ctrl('ARBDBAASEB_ZOOM')) SetDisabled(c,false);
if(c=Ctrl('XPJIVBDIXS')) SetDisabled(c,false);
if(c=Ctrl('XPJIVBDIXS_ZOOM')) SetDisabled(c,false);
if(c=Ctrl('QMLLHINIKD')) SetDisabled(c,false);
if(c=Ctrl('DTNUYRRYDZ')) SetDisabled(c,false);
EnableControlsUnderCondition(false);
}
m_bChildDisabled=enable;
}
