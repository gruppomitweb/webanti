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
}
function Set_pecodice(ctrlValue,kmode,e) {
if (Ne(w_pecodice,ctrlValue)) {
var ctl = _GetCtl(e,'NIIFDUHRBQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_pecodice=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NIIFDUHRBQ',0);
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
function Set_pe__tipo(ctrlValue,kmode,e) {
if (Ne(w_pe__tipo,ctrlValue)) {
var ctl = _GetCtl(e,'FPUPHODRZY');
if (_tracker.goon(ctl,ctrlValue)) {
w_pe__tipo=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FPUPHODRZY',0);
DoUpdate(l_bResult);
if(c=Ctrl('FPUPHODRZY')) selectCombo(c,w_pe__tipo,'N')
return l_bResult;
} else {
ctl.value=WtH('','N',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_pecodute(ctrlValue,kmode,e) {
if (Ne(w_pecodute,ctrlValue)) {
var ctl = _GetCtl(e,'ROTQXTGDQV');
if (_tracker.goon(ctl,ctrlValue)) {
w_pecodute=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ROTQXTGDQV',0);
if (l_bResult) {
l_bResult=Link_ROTQXTGDQV(kmode);
if ( ! (l_bResult)) {
w_pecodute=HtW('','N');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'N',6,0,'999999'));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','N',6,0,'999999');
_ResetTracker();
return true;
}
}
return true;
}
function Set_pecodgrp(ctrlValue,kmode,e) {
if (Ne(w_pecodgrp,ctrlValue)) {
var ctl = _GetCtl(e,'XHHDJCAPOZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_pecodgrp=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XHHDJCAPOZ',0);
if (l_bResult) {
l_bResult=Link_XHHDJCAPOZ(kmode);
if ( ! (l_bResult)) {
w_pecodgrp=HtW('','N');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'N',6,0,'999999'));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','N',6,0,'999999');
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
function Link_ROTQXTGDQV(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_pecodute);
var l_Appl = LinkApplet();
l_Appl.SetDoubleKey('code',w_pecodute,6,0);
l_Appl.SetFields('code,name');
l_Appl.SetTypes('N,C');
l_Appl.LinkTable('cpusers');
l_Appl.SetLinkzoom('spadministration_users');
l_Appl.SetID('ROTQXTGDQV');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_pecodute=l_Appl.GetDoubleValue('code',6,0);
w_descrizione=l_Appl.GetStringValue('name',50,0);
l_Appl.GetLinkHash(GetRepeatedCheckVars());
} else {
Link_ROTQXTGDQV_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_ROTQXTGDQV';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_ROTQXTGDQV();
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
function Link_ROTQXTGDQV_Blank() {
w_pecodute=0;
w_descrizione='';
}
function LOpt_ROTQXTGDQV() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('cpusers','C'));
l_oWv.setValue('Linkzoomprg',WtA('spadministration_users','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('code','C'));
l_oWv.setValue('LinkedField',WtA('code','C'));
l_oWv.setValue('UID',WtA('ROTQXTGDQV','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['ROTQXTGDQV'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('2009792713'),'C'));
l_oWv.setValue('ConfigName',WtA('spadministration_zuser','C'));
return l_oWv;
}
function Link_XHHDJCAPOZ(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_pecodgrp);
var l_Appl = LinkApplet();
l_Appl.SetDoubleKey('code',w_pecodgrp,6,0);
l_Appl.SetFields('code,name');
l_Appl.SetTypes('N,C');
l_Appl.LinkTable('cpgroups');
l_Appl.SetID('XHHDJCAPOZ');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_pecodgrp=l_Appl.GetDoubleValue('code',6,0);
w_descriGruppo=l_Appl.GetStringValue('name',50,0);
l_Appl.GetLinkHash(GetRepeatedCheckVars());
} else {
Link_XHHDJCAPOZ_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_XHHDJCAPOZ';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_XHHDJCAPOZ();
l_oWv.setValue('FieldFilter',l_cFieldFilter);
if ( ! (Empty(l_Appl.GetWhereAddedFixedFiltersUnencoded()))) {
if ( ! (Empty(l_cFixedFilter))) {
l_cFixedFilter=l_cFixedFilter+' and ';
}
l_cFixedFilter=l_cFixedFilter+l_Appl.GetWhereAddedFixedFiltersUnencoded();
}
l_oWv.setValue('FixedFilter',l_cFixedFilter);
var initEntityFields = '';
l_cLinkUrl='../jsp-system/spadministration_groups_zoom_portlet.jsp?m_cWv='+URLenc(l_oWv.asString());
windowOpenForeground(l_cLinkUrl,openername,'toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes');
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
function Link_XHHDJCAPOZ_Blank() {
w_pecodgrp=0;
w_descriGruppo='';
}
function LOpt_XHHDJCAPOZ() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('cpgroups','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('code','C'));
l_oWv.setValue('LinkedField',WtA('code','C'));
l_oWv.setValue('UID',WtA('XHHDJCAPOZ','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['XHHDJCAPOZ'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('10266899854'),'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'ROTQXTGDQV')) {
last_focused_comp=GetLastFocusedElementOfLink('ROTQXTGDQV');
function SetMethod_ROTQXTGDQV() {
Set_pecodute(HtW(value,'N'),0);
}
if (IsDeviceMobile()) {
SetMethod_ROTQXTGDQV();
} else {
setTimeout(SetMethod_ROTQXTGDQV,1);
}
bResult=true;
}
if (Eq(varName,'XHHDJCAPOZ')) {
last_focused_comp=GetLastFocusedElementOfLink('XHHDJCAPOZ');
function SetMethod_XHHDJCAPOZ() {
Set_pecodgrp(HtW(value,'N'),0);
}
if (IsDeviceMobile()) {
SetMethod_XHHDJCAPOZ();
} else {
setTimeout(SetMethod_XHHDJCAPOZ,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'ROTQXTGDQV')) {
return [Ctrl('ROTQXTGDQV')];
}
if (Eq(varName,'XHHDJCAPOZ')) {
return [Ctrl('XHHDJCAPOZ')];
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
if ( ! (m_oFather.SaveContext_spadministration_mobapppermissions())) {
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
parent.ZtVWeb.raiseEventToEvalParms('spadministration_mobapppermissions_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('spadministration_mobapppermissions_dataNotSent',{'action':formaction});
}
}
}
}
}
CheckChild.child=[];
function Check() {
var l_bResult = true;
ResetErrorVars();
if ( ! (_ChkObl('NIIFDUHRBQ',1))) {
_SignErr('NIIFDUHRBQ');
m_cLastWorkVarErrorMsg='112851763';
l_bResult=false;
w_pecodice=HtW('','C');
}
if (l_bResult) {
l_bResult=CheckChild(0);
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('ROTQXTGDQV_ZOOM',lc)) {
return 0;
}
if (Eq('ROTQXTGDQV',lc)) {
return 0;
}
if (Eq('XHHDJCAPOZ_ZOOM',lc)) {
return 1;
}
if (Eq('XHHDJCAPOZ',lc)) {
return 1;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_ROTQXTGDQV();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,1)) {
l_oWv=LOpt_XHHDJCAPOZ();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return '../jsp-system/spadministration_groups_zoom_portlet.jsp?m_cWv='+URLenc(l_oWv.asString());
}
}
function FillWv() {
var l_oWv = InitWvApplet();
l_oWv.setValue('m_CheckVars',JSON.stringify(m_CheckVars));
l_oWv.setValue('pecodice',WtA(w_pecodice,'C'));
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
FillWv.n=["pecodice"];
function CheckRow(w) {
var l_bResult = true;
ResetErrorVars();
if (Le(m_nCurrentRow,Rows())) {
if (( ! (_ChkObl('FPUPHODRZY',1))) && FullRow()) {
_SignErr('FPUPHODRZY');
m_cLastWorkVarErrorMsg='1044287916';
l_bResult=false;
w_pe__tipo=HtW('','N');
} else if (( ! (_ChkObl('ROTQXTGDQV',1))) && FullRow()) {
_SignErr('ROTQXTGDQV');
m_cLastWorkVarErrorMsg='1999024119';
l_bResult=false;
w_pecodute=HtW('','N');
} else if (( ! (_ChkObl('XHHDJCAPOZ',1))) && FullRow()) {
_SignErr('XHHDJCAPOZ');
m_cLastWorkVarErrorMsg='11758432523';
l_bResult=false;
w_pecodgrp=HtW('','N');
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
m_oFather.SetModified_spadministration_mobapppermissions();
}
}
SaveContext.child=[];
function BlankRow() {
w_pe__tipo=0;
w_pecodute=0;
w_pecodgrp=0;
w_descrizione='';
w_descriGruppo='';
w_pe__tipo=0;
if ( ! (EmptyNumber(w_pecodute))) {
Link_ROTQXTGDQV(null);
}
if ( ! (EmptyNumber(w_pecodgrp))) {
Link_XHHDJCAPOZ(null);
}
BlankRowChild();
if (m_bExtended) {
BlankRepeatedExtendedFields();
}
SaveDependsOn();
LoadContext(true);
}
function FullRow() {
return  ! (Empty(w_pecodgrp)) ||  ! (Empty(w_pecodute));
}
function GetRepeatedFields() {
var l_aRepeatedFields;
l_aRepeatedFields={};
l_aRepeatedFields.pe__tipo={"type":"N","name":"pe__tipo","id":"FPUPHODRZY","fixedpos":false,"len":1,"dec":0,"title":"MOBAPPSTORE_TYPE"};
l_aRepeatedFields.pecodute={"type":"N","name":"pecodute","id":"ROTQXTGDQV","fixedpos":false,"len":6,"dec":0,"title":"Codice utente"};
l_aRepeatedFields.pecodgrp={"type":"N","name":"pecodgrp","id":"XHHDJCAPOZ","fixedpos":false,"len":6,"dec":0,"title":"Codice gruppo"};
l_aRepeatedFields.descrizione={"type":"C","name":"descrizione","id":"WWAXDSWHMO","fixedpos":false,"len":50,"dec":0,"title":"ADMIN_NAME"};
l_aRepeatedFields.descriGruppo={"type":"C","name":"descriGruppo","id":"NHPLJCHIJC","fixedpos":false,"len":50,"dec":0,"title":"ADMIN_NAME"};
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
if(c=Ctrl('NIIFDUHRBQ')) SetDisabled(c,true);
SetQueryRow(Ctrl('GridTable'),false);
} else {
SetEditRow(Ctrl('GridTable'),false);
var c;
if(c=Ctrl('NIIFDUHRBQ')) SetDisabled(c,false);
EnableControlsUnderCondition(false);
}
m_bChildDisabled=enable;
}
