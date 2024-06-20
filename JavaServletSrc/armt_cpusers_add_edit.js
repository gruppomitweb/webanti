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
function Set_SURNAME(ctrlValue,kmode,e) {
if (Ne(w_SURNAME,ctrlValue)) {
var ctl = _GetCtl(e,'FXNTRTAGEY');
if (_tracker.goon(ctl,ctrlValue)) {
w_SURNAME=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FXNTRTAGEY',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',35,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_CODDIP(ctrlValue,kmode,e) {
if (Ne(w_CODDIP,ctrlValue)) {
var ctl = _GetCtl(e,'ZREZPELSUN');
if (_tracker.goon(ctl,ctrlValue)) {
w_CODDIP=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ZREZPELSUN',0);
if (l_bResult) {
l_bResult=Link_ZREZPELSUN(kmode);
if ( ! (l_bResult)) {
w_CODDIP=HtW('','C');
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
function Set_EMAIL(ctrlValue,kmode,e) {
if (Ne(w_EMAIL,ctrlValue)) {
var ctl = _GetCtl(e,'PAUJKEOANA');
if (_tracker.goon(ctl,ctrlValue)) {
w_EMAIL=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('PAUJKEOANA',0);
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
function Set_NAME(ctrlValue,kmode,e) {
if (Ne(w_NAME,ctrlValue)) {
var ctl = _GetCtl(e,'FNBYGXHNIM');
if (_tracker.goon(ctl,ctrlValue)) {
w_NAME=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FNBYGXHNIM',0);
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
function Set_EMPLOYEE(ctrlValue,kmode,e) {
if (Ne(w_EMPLOYEE,ctrlValue)) {
var ctl = _GetCtl(e,'ZOWNCPBLEN');
if (_tracker.goon(ctl,ctrlValue)) {
w_EMPLOYEE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ZOWNCPBLEN',0);
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
function Link_ZREZPELSUN(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CODDIP);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODDIP',w_CODDIP,6,0);
l_Appl.SetFields('CODDIP,DESCRIZ');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('anadip');
l_Appl.SetID('ZREZPELSUN');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CODDIP=l_Appl.GetStringValue('CODDIP',6,0);
w_xDESCRIZ=l_Appl.GetStringValue('DESCRIZ',30,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_ZREZPELSUN_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_ZREZPELSUN';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_ZREZPELSUN();
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
function Link_ZREZPELSUN_Blank() {
w_CODDIP='';
w_xDESCRIZ='';
}
function LOpt_ZREZPELSUN() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('anadip','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODDIP','C'));
l_oWv.setValue('LinkedField',WtA('CODDIP','C'));
l_oWv.setValue('UID',WtA('ZREZPELSUN','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['ZREZPELSUN'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('116301484'),'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'ZREZPELSUN')) {
last_focused_comp=GetLastFocusedElementOfLink('ZREZPELSUN');
function SetMethod_ZREZPELSUN() {
Set_CODDIP(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_ZREZPELSUN();
} else {
setTimeout(SetMethod_ZREZPELSUN,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'ZREZPELSUN')) {
return [Ctrl('ZREZPELSUN')];
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
if ( ! (m_oFather.SaveContext_armt_cpusers_add())) {
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
parent.ZtVWeb.raiseEventToEvalParms('armt_cpusers_add_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('armt_cpusers_add_dataNotSent',{'action':formaction});
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
if ( ! (_ChkObl('ZREZPELSUN',1))) {
_SignErr('ZREZPELSUN');
m_cLastWorkVarErrorMsg='10228423721';
l_bResult=false;
w_CODDIP=HtW('','C');
} else if ( ! (_ChkObl('FNBYGXHNIM',1))) {
_SignErr('FNBYGXHNIM');
m_cLastWorkVarErrorMsg='443454';
l_bResult=false;
w_NAME=HtW('','C');
} else if ( ! (_ChkObl('FXNTRTAGEY',1))) {
_SignErr('FXNTRTAGEY');
m_cLastWorkVarErrorMsg='1816546867';
l_bResult=false;
w_SURNAME=HtW('','C');
} else if ( ! (_ChkObl('PAUJKEOANA',1))) {
_SignErr('PAUJKEOANA');
m_cLastWorkVarErrorMsg='7534101';
l_bResult=false;
w_EMAIL=HtW('','C');
} else if ( ! (_ChkObl('ZOWNCPBLEN',1))) {
_SignErr('ZOWNCPBLEN');
m_cLastWorkVarErrorMsg='11123647547';
l_bResult=false;
w_EMPLOYEE=HtW('','C');
}
if (l_bResult) {
l_bResult=CheckChild(0);
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('ZREZPELSUN_ZOOM',lc)) {
return 0;
}
if (Eq('ZREZPELSUN',lc)) {
return 0;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_ZREZPELSUN();
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
l_oWv.setValue('CODE',WtA(w_CODE,'N'));
l_oWv.setValue('CODDIP',WtA(w_CODDIP,'C'));
l_oWv.setValue('NAME',WtA(w_NAME,'C'));
l_oWv.setValue('SURNAME',WtA(w_SURNAME,'C'));
l_oWv.setValue('EMAIL',WtA(w_EMAIL,'C'));
l_oWv.setValue('EMPLOYEE',WtA(w_EMPLOYEE,'C'));
l_oWv.setValue('SUPERDIP',WtA(w_SUPERDIP,'C'));
l_oWv.setValue('DATECREATE',WtA(w_DATECREATE,'D'));
l_oWv.setValue('xDESCRIZ',WtA(w_xDESCRIZ,'C'));
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
FillWv.n=["CODE","CODDIP","NAME","SURNAME","EMAIL","EMPLOYEE","SUPERDIP","DATECREATE","xDESCRIZ"];
function SetModified() {
m_bUpdated=true;
if (IsWndAccessible(m_oFather)) {
m_oFather.SetModified_armt_cpusers_add();
}
}
function EnableEntityWhenReady(enable) {
if (enable) {
var c;
if(c=Ctrl('ZREZPELSUN')) SetDisabled(c,true);
if(c=Ctrl('ZREZPELSUN_ZOOM')) SetDisabled(c,true);
if(c=Ctrl('FNBYGXHNIM')) SetDisabled(c,true);
if(c=Ctrl('FXNTRTAGEY')) SetDisabled(c,true);
if(c=Ctrl('PAUJKEOANA')) SetDisabled(c,true);
if(c=Ctrl('ZOWNCPBLEN')) SetDisabled(c,true);
} else {
var c;
if(c=Ctrl('ZREZPELSUN')) SetDisabled(c,false);
if(c=Ctrl('ZREZPELSUN_ZOOM')) SetDisabled(c,false);
if(c=Ctrl('FNBYGXHNIM')) SetDisabled(c,false);
if(c=Ctrl('FXNTRTAGEY')) SetDisabled(c,false);
if(c=Ctrl('PAUJKEOANA')) SetDisabled(c,false);
if(c=Ctrl('ZOWNCPBLEN')) SetDisabled(c,false);
EnableControlsUnderCondition(false);
}
m_bChildDisabled=enable;
}
