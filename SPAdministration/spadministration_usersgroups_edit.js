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
function SetDefaultFixedStyles() {
}
function Set_groupcode(ctrlValue,kmode,e) {
if (Ne(w_groupcode,ctrlValue)) {
var ctl = _GetCtl(e,'WLNNNRIURR');
if (_tracker.goon(ctl,ctrlValue)) {
w_groupcode=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('WLNNNRIURR',0);
if (l_bResult) {
l_bResult=Link_WLNNNRIURR(kmode);
if ( ! (l_bResult)) {
w_groupcode=HtW('','N');
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
function Set_datestop(ctrlValue,kmode,e) {
if (Ne(w_datestop,ctrlValue)) {
var ctl = _GetCtl(e,'PMFANIVCDZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_datestop=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('PMFANIVCDZ',0);
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
function Set_datestart(ctrlValue,kmode,e) {
if (Ne(w_datestart,ctrlValue)) {
var ctl = _GetCtl(e,'CSNTCOYGOR');
if (_tracker.goon(ctl,ctrlValue)) {
w_datestart=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CSNTCOYGOR',0);
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
function Set_companies(ctrlValue,kmode,e) {
if (Ne(w_companies,ctrlValue)) {
var ctl = _GetCtl(e,'QXHDPMZCAB');
if (_tracker.goon(ctl,ctrlValue)) {
w_companies=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QXHDPMZCAB',0);
if (l_bResult) {
l_bResult=Link_QXHDPMZCAB(kmode);
if ( ! (l_bResult)) {
w_companies=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',2000,0,''));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',2000,0,'');
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
if ((Ne(o_selected_group,w_selected_group))) {
l_bTmpRes=Link_WLNNNRIURR(null);
}
if ((Ne(o_groupcode,w_groupcode))) {
Calculation_MLBQPKPVSF();
}
LibJavascript.forEachItem(m_FoundlingCopyWorkVar,i_body_1)
function i_body_1(child){
child();
}
// * --- Area Manuale = UI - Calculate
// * --- Fine Area Manuale
m_bCalculating=false;
}
function Calculation_MLBQPKPVSF() {
w_appoggio=SetFatherPwdComplexity();
}
function Calculation_OMWEVXUHAL() {
if (Eq(EntityStatus(),'N') && Gt(w_selected_group,0)) {
w_groupcode=w_selected_group;
Link_WLNNNRIURR(null);
w_selected_group=0;
}
}
function SaveDependsOn() {
o_selected_group=w_selected_group;
o_groupcode=w_groupcode;
}
function SaveLabelDependsOn() {
}
function Link_WLNNNRIURR(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_groupcode);
var l_Appl = LinkApplet();
l_Appl.SetDoubleKey('code',w_groupcode,6,0);
l_Appl.SetFields('code,name,pwdcomplexity');
l_Appl.SetTypes('N,C,N');
l_Appl.LinkTable('cpgroups');
l_Appl.SetID('WLNNNRIURR');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_groupcode=l_Appl.GetDoubleValue('code',6,0);
w_name=l_Appl.GetStringValue('name',50,0);
w_pwd_complexity=l_Appl.GetDoubleValue('pwdcomplexity',3,0);
l_Appl.GetLinkHash(GetRepeatedCheckVars());
} else {
Link_WLNNNRIURR_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_WLNNNRIURR';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_WLNNNRIURR();
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
function Link_WLNNNRIURR_Blank() {
w_groupcode=0;
w_name='';
w_pwd_complexity=0;
}
function LOpt_WLNNNRIURR() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('cpgroups','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('code','C'));
l_oWv.setValue('LinkedField',WtA('code','C'));
l_oWv.setValue('UID',WtA('WLNNNRIURR','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['WLNNNRIURR'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('11749991675'),'C'));
return l_oWv;
}
function Link_QXHDPMZCAB(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_companies);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('codazi',w_companies,2000,0);
l_Appl.SetFields('codazi');
l_Appl.SetTypes('C');
l_Appl.LinkTable('cpazi');
l_Appl.SetLinkzoom('spadministration_companies');
l_Appl.SetID('QXHDPMZCAB');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_companies=l_Appl.GetStringValue('codazi',2000,0);
l_Appl.GetLinkHash(GetRepeatedCheckVars());
} else {
Link_QXHDPMZCAB_Blank();
l_bResult=true;
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_QXHDPMZCAB';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_QXHDPMZCAB();
l_oWv.setValue('FieldFilter',l_cFieldFilter);
if ( ! (Empty(l_Appl.GetWhereAddedFixedFiltersUnencoded()))) {
if ( ! (Empty(l_cFixedFilter))) {
l_cFixedFilter=l_cFixedFilter+' and ';
}
l_cFixedFilter=l_cFixedFilter+l_Appl.GetWhereAddedFixedFiltersUnencoded();
}
l_oWv.setValue('FixedFilter',l_cFixedFilter);
var initEntityFields = '';
l_cLinkUrl='../jsp-system/spadministration_users_companies_link_zoom_portlet.jsp?m_cWv='+URLenc(l_oWv.asString());
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
function Link_QXHDPMZCAB_Blank() {
}
function LOpt_QXHDPMZCAB() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('cpazi','C'));
l_oWv.setValue('Linkzoomprg',WtA('spadministration_companies','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('codazi','C'));
l_oWv.setValue('LinkedField',WtA('codazi','C'));
l_oWv.setValue('UID',WtA('QXHDPMZCAB','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['QXHDPMZCAB'][1],'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'WLNNNRIURR')) {
last_focused_comp=GetLastFocusedElementOfLink('WLNNNRIURR');
function SetMethod_WLNNNRIURR() {
Set_groupcode(HtW(value,'N'),0);
}
if (IsDeviceMobile()) {
SetMethod_WLNNNRIURR();
} else {
setTimeout(SetMethod_WLNNNRIURR,1);
}
bResult=true;
}
if (Eq(varName,'QXHDPMZCAB')) {
last_focused_comp=GetLastFocusedElementOfLink('QXHDPMZCAB');
function SetMethod_QXHDPMZCAB() {
Set_companies(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_QXHDPMZCAB();
} else {
setTimeout(SetMethod_QXHDPMZCAB,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'WLNNNRIURR')) {
return [Ctrl('WLNNNRIURR')];
}
if (Eq(varName,'QXHDPMZCAB')) {
return [Ctrl('QXHDPMZCAB')];
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
if ( ! (m_oFather.SaveContext_spadministration_usersgroups())) {
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
parent.ZtVWeb.raiseEventToEvalParms('spadministration_usersgroups_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('spadministration_usersgroups_dataNotSent',{'action':formaction});
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
if (Eq('WLNNNRIURR_ZOOM',lc)) {
return 0;
}
if (Eq('WLNNNRIURR',lc)) {
return 0;
}
if (Eq('CSNTCOYGOR_ZOOM',lc)) {
return 1;
}
if (Eq('PMFANIVCDZ_ZOOM',lc)) {
return 1;
}
if (Eq('QXHDPMZCAB_ZOOM',lc)) {
return 1;
}
if (Eq('QXHDPMZCAB',lc)) {
return 1;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_WLNNNRIURR();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return '../jsp-system/spadministration_groups_zoom_portlet.jsp?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,1)) {
l_oWv=LOpt_QXHDPMZCAB();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return '../jsp-system/spadministration_users_companies_link_zoom_portlet.jsp?m_cWv='+URLenc(l_oWv.asString());
}
}
function FillWv() {
var l_oWv = InitWvApplet();
l_oWv.setValue('m_CheckVars',JSON.stringify(m_CheckVars));
l_oWv.setValue('usercode',WtA(w_usercode,'N'));
l_oWv.setValue('selected_group',WtA(w_selected_group,'N'));
l_oWv.setValue('appoggio',WtA(w_appoggio,'L'));
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
FillWv.n=["usercode","selected_group","appoggio"];
function CheckRow(w) {
var l_bResult = true;
ResetErrorVars();
if (Le(m_nCurrentRow,Rows())) {
if (( ! (_ChkObl('WLNNNRIURR',1))) && FullRow()) {
_SignErr('WLNNNRIURR');
m_cLastWorkVarErrorMsg='1433914651';
l_bResult=false;
w_groupcode=HtW('','N');
} else if (( ! (_ChkObl('CSNTCOYGOR',1))) && FullRow()) {
_SignErr('CSNTCOYGOR');
m_cLastWorkVarErrorMsg='313757110';
l_bResult=false;
w_datestart=HtW('','D');
} else if (( ! (_ChkObl('PMFANIVCDZ',1))) && FullRow()) {
_SignErr('PMFANIVCDZ');
m_cLastWorkVarErrorMsg='184661718';
l_bResult=false;
w_datestop=HtW('','D');
} else if (( ! (_ChkObl('QXHDPMZCAB',1))) && FullRow()) {
_SignErr('QXHDPMZCAB');
m_cLastWorkVarErrorMsg='11068993370';
l_bResult=false;
w_companies=HtW('','C');
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
m_oFather.SetModified_spadministration_usersgroups();
}
}
SaveContext.child=[];
function BlankRow() {
w_groupcode=0;
w_name='';
w_datestart=NullDate();
w_datestop=NullDate();
w_companies='';
w_pwd_complexity=0;
if ( ! (EmptyNumber(w_groupcode))) {
Link_WLNNNRIURR(null);
}
if ( ! (EmptyString(w_companies))) {
Link_QXHDPMZCAB(null);
}
BlankRowChild();
if (m_bExtended) {
BlankRepeatedExtendedFields();
}
SaveDependsOn();
LoadContext(true);
}
function FullRow() {
return  ! (Empty(w_name));
}
function GetRepeatedFields() {
var l_aRepeatedFields;
l_aRepeatedFields={};
l_aRepeatedFields.groupcode={"type":"N","name":"groupcode","id":"WLNNNRIURR","fixedpos":false,"len":6,"dec":0,"title":"Group code"};
l_aRepeatedFields.datestart={"type":"D","name":"datestart","id":"CSNTCOYGOR","fixedpos":false,"len":8,"dec":0,"title":"Validity start"};
l_aRepeatedFields.datestop={"type":"D","name":"datestop","id":"PMFANIVCDZ","fixedpos":false,"len":8,"dec":0,"title":"Validity end"};
l_aRepeatedFields.companies={"type":"C","name":"companies","id":"QXHDPMZCAB","fixedpos":false,"len":2000,"dec":0,"title":"Companies"};
l_aRepeatedFields.name={"type":"C","name":"name","id":"WLREBYBGNV","fixedpos":false,"len":50,"dec":0,"title":"Name"};
l_aRepeatedFields.pwd_complexity={"type":"N","name":"pwd_complexity","id":"AWTVTSRBKO","fixedpos":true,"len":3,"dec":0,"title":""};
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
SetQueryRow(Ctrl('GridTable'),false);
} else {
SetEditRow(Ctrl('GridTable'),false);
var c;
EnableControlsUnderCondition(false);
}
m_bChildDisabled=enable;
}
