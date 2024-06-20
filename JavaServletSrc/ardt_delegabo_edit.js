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
l_bEnabled= ! (Ne(At(Utilities.Make(window).GetCallerString('TIPOOPRAP'),'25|39|40'),0)) || IsDisabledByStateDriver('DATAINI');
SetDisabled('BJKHVZBXDR',l_bEnabled);
SetDisabled(Ctrl('BJKHVZBXDR_ZOOM'),l_bEnabled);
l_bEnabled= ! (Ne(At(Utilities.Make(window).GetCallerString('TIPOOPRAP'),'28|41|47'),0)) || IsDisabledByStateDriver('DATAFINE');
SetDisabled('JCFUNSQXBI',l_bEnabled);
SetDisabled(Ctrl('JCFUNSQXBI_ZOOM'),l_bEnabled);
if (IsDisabledByStateDriver('box_VRCVINYRJO')) {
DisableInputsInContainer(Ctrl('VRCVINYRJO'),true);
}
if (IsDisabledByStateDriver('box_MINAAOAOZC')) {
DisableInputsInContainer(Ctrl('MINAAOAOZC'),true);
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
SetObligatory(Ctrl('BJKHVZBXDR'),Ne(At(Utilities.Make(window).GetCallerString('TIPOOPRAP'),'25|39|40'),0) || IsObligatoryByStateDriver('DATAINI'));
SetObligatory(Ctrl('JCFUNSQXBI'),Ne(At(Utilities.Make(window).GetCallerString('TIPOOPRAP'),'28|41|47'),0) || IsObligatoryByStateDriver('DATAFINE'));
}
function SetDynamicClasses() {
var c;
}
function SetDynamicTooltip() {
var c;
}
function SetDefaultFixedStyles() {
SetErrorField('VEABFZIUKQ',false);
}
function Set_DATAFINE(ctrlValue,kmode,e) {
if (Ne(w_DATAFINE,ctrlValue)) {
var ctl = _GetCtl(e,'JCFUNSQXBI');
if (_tracker.goon(ctl,ctrlValue)) {
w_DATAFINE=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('JCFUNSQXBI',0);
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
function Set_NOAGE(ctrlValue,kmode,e) {
if (Ne(w_NOAGE,ctrlValue)) {
var ctl = _GetCtl(e,'VEABFZIUKQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_NOAGE=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VEABFZIUKQ',0);
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
function Set_CODINTER(ctrlValue,kmode,e) {
if (Ne(w_CODINTER,ctrlValue)) {
var ctl = _GetCtl(e,'CROCGCIGKF');
if (_tracker.goon(ctl,ctrlValue)) {
w_CODINTER=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
var l_bWarn = true;
l_bResult=_ChkObl('CROCGCIGKF',0);
if (l_bResult) {
l_bResult=Link_CROCGCIGKF(kmode);
if (l_bResult && ( ! (arfn_chkdatdoc(w_CODINTER,Utilities.Make(window).GetCallerDate('DATAREG'))) && Ne(m_nLastError,-2))) {
try {
_tracker.askwrn=true;
l_bWarn=WindowConfirm(AlertErrorMessage('11525797640'));
} finally {
_tracker.askwrn=false;
}
if ( ! (l_bWarn)) {
Link_CROCGCIGKF_Blank();
}
}
if ( ! (l_bResult) ||  ! (l_bWarn)) {
w_CODINTER=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult) ||  ! (l_bWarn)) {
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
function Set_DATAINI(ctrlValue,kmode,e) {
if (Ne(w_DATAINI,ctrlValue)) {
var ctl = _GetCtl(e,'BJKHVZBXDR');
if (_tracker.goon(ctl,ctrlValue)) {
w_DATAINI=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BJKHVZBXDR',0);
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
function Calculate() {
var l_bTmpRes;
var l_bResult = true;
m_bCalculating=true;
w_NUMPROG=Utilities.Make(window).GetCallerString('NUMPROG');
w_tiporegr=Utilities.Make(window).GetCallerNumber('tipregn');
w_NUMPROG1=( ! (Empty(Utilities.Make(window).GetCallerString('TIPOOPRAP'))) && Ne(At(Utilities.Make(window).GetCallerString('TIPOOPRAP'),'25|39|40'),0) && Empty(w_NUMPROG1) &&  ! (Empty(w_DATAINI))?Utilities.Make(window).GetCallerString('NUMPROG'):w_NUMPROG1);
w_NUMPROG2=( ! (Empty(Utilities.Make(window).GetCallerString('TIPOOPRAP'))) && Ne(At(Utilities.Make(window).GetCallerString('TIPOOPRAP'),'28|41|47'),0) && Empty(w_NUMPROG2) &&  ! (Empty(w_DATAFINE))?Utilities.Make(window).GetCallerString('NUMPROG'):w_NUMPROG2);
w_xRagSoc=( ! (Empty(LRTrim(w_xragsoci)))?w_xragsoci:( ! (Empty(w_CODINTER))?'Soggetto non presente in anagrafica':''));
if ((Ne(o_CODINTER,w_CODINTER))) {
Calculation_NETOJYZQRV();
}
if ((Ne(o_DATAFINE,w_DATAFINE)) || (Ne(o_CODINTER,w_CODINTER))) {
Calculation_HQRGXFMPSR();
}
if ((Ne(o_DATAINI,w_DATAINI)) || (Ne(o_CODINTER,w_CODINTER))) {
Calculation_GVAXMWDMDH();
}
LibJavascript.forEachItem(m_FoundlingCopyWorkVar,i_body_1)
function i_body_1(child){
child();
}
// * --- Area Manuale = UI - Calculate
// * --- Fine Area Manuale
m_bCalculating=false;
}
function Calculation_NETOJYZQRV() {
w_DATAINI=(Ne(At(Utilities.Make(window).GetCallerString('TIPOOPRAP'),'25|39|40'),0)?Utilities.Make(window).GetCallerDate('DATAOPE'):w_DATAINI);
w_DATAFINE=(Ne(At(Utilities.Make(window).GetCallerString('TIPOOPRAP'),'28|41|47'),0)?Utilities.Make(window).GetCallerDate('DATAOPE'):w_DATAFINE);
}
function Calculation_HQRGXFMPSR() {
w_NUMPROG2=( ! (Empty(Utilities.Make(window).GetCallerString('TIPOOPRAP'))) && Ne(At(Utilities.Make(window).GetCallerString('TIPOOPRAP'),'28|41|47'),0) && Empty(w_NUMPROG2) &&  ! (Empty(w_DATAFINE))?Utilities.Make(window).GetCallerString('NUMPROG'):(Empty(w_DATAFINE)?'':w_NUMPROG2));
}
function Calculation_GVAXMWDMDH() {
w_NUMPROG1=( ! (Empty(Utilities.Make(window).GetCallerString('TIPOOPRAP'))) && Ne(At(Utilities.Make(window).GetCallerString('TIPOOPRAP'),'25|39|40'),0) && Empty(w_NUMPROG1) &&  ! (Empty(w_DATAINI))?Utilities.Make(window).GetCallerString('NUMPROG'):(Empty(w_DATAINI)?'':w_NUMPROG1));
}
function SaveDependsOn() {
o_CODINTER=w_CODINTER;
o_DATAINI=w_DATAINI;
o_DATAFINE=w_DATAFINE;
}
function SaveLabelDependsOn() {
}
function Link_CROCGCIGKF(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CODINTER);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CONNES',w_CODINTER,16,0);
l_Appl.SetFields('CONNES,RAGSOC,DOMICILIO,DESCCIT,PROVINCIA,CAP');
l_Appl.SetTypes('C,C,C,C,C,C');
l_Appl.LinkTable('personbo');
l_Appl.SetID('CROCGCIGKF');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CODINTER=l_Appl.GetStringValue('CONNES',16,0);
w_DESCINTER=l_Appl.GetStringValue('RAGSOC',70,0);
w_DOMICILIO=l_Appl.GetStringValue('DOMICILIO',35,0);
w_DESCCIT=l_Appl.GetStringValue('DESCCIT',30,0);
w_PROVINCIA=l_Appl.GetStringValue('PROVINCIA',2,0);
w_CAP=l_Appl.GetStringValue('CAP',9,0);
w_xragsoci=l_Appl.GetStringValue('RAGSOC',70,0);
l_Appl.GetLinkHash(GetRepeatedCheckVars());
} else {
Link_CROCGCIGKF_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_CROCGCIGKF';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_CROCGCIGKF();
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
if (l_bResult &&  ! (Empty(w_CODINTER) && l_bEmp)) {
l_bResult=arfn_chksogg(w_CODINTER,'8');
if ( ! (l_bResult)) {
Link_CROCGCIGKF_Blank();
}
}
if ( ! (l_bResult)) {
m_nLastError=3;
m_cLastWorkVarErrorMsg='';
if (Lt(l_nRec,0)) {
m_cLastMsgError=Translate('MSG_CONNECT_SERVER');
} else {
m_cLastMsgError=AlertErrorMessage('11525797640');
}
}
}
return l_bResult;
}
function Link_CROCGCIGKF_Blank() {
w_CODINTER='';
w_DESCINTER='';
w_DOMICILIO='';
w_DESCCIT='';
w_PROVINCIA='';
w_CAP='';
w_xragsoci='';
}
function LOpt_CROCGCIGKF() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('personbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CONNES','C'));
l_oWv.setValue('LinkedField',WtA('CONNES','C'));
l_oWv.setValue('UID',WtA('CROCGCIGKF','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['CROCGCIGKF'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('11488180956'),'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'CROCGCIGKF')) {
last_focused_comp=GetLastFocusedElementOfLink('CROCGCIGKF');
function SetMethod_CROCGCIGKF() {
Set_CODINTER(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_CROCGCIGKF();
} else {
setTimeout(SetMethod_CROCGCIGKF,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'CROCGCIGKF')) {
return [Ctrl('CROCGCIGKF')];
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
if ( ! (m_oFather.SaveContext_ardt_delegabo())) {
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
parent.ZtVWeb.raiseEventToEvalParms('ardt_delegabo_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('ardt_delegabo_dataNotSent',{'action':formaction});
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
if (Eq('CROCGCIGKF_ZOOM',lc)) {
return 0;
}
if (Eq('CROCGCIGKF',lc)) {
return 0;
}
if (Eq('BJKHVZBXDR_ZOOM',lc)) {
return 1;
}
if (Eq('JCFUNSQXBI_ZOOM',lc)) {
return 1;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_CROCGCIGKF();
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
l_oWv.setValue('NUMPROG',WtA(w_NUMPROG,'C'));
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
FillWv.n=["RAPPORTO","NUMPROG"];
function CheckRow(w) {
var l_bResult = true;
ResetErrorVars();
if (Le(m_nCurrentRow,Rows())) {
if ((( ! (_ChkObl('CROCGCIGKF',1))) || ( ! (Empty(w_CODINTER)) &&  ! (arfn_chksogg(w_CODINTER,'8')))) && FullRow()) {
_SignErr('CROCGCIGKF','11525797640');
l_bResult=false;
w_CODINTER=HtW('','C');
} else if (((Ne(At(Utilities.Make(window).GetCallerString('TIPOOPRAP'),'25|39|40'),0)) && ( ! (_ChkObl('BJKHVZBXDR',1)))) && FullRow()) {
_SignErr('BJKHVZBXDR');
m_cLastWorkVarErrorMsg='45547614';
l_bResult=false;
w_DATAINI=HtW('','D');
} else if (((Ne(At(Utilities.Make(window).GetCallerString('TIPOOPRAP'),'28|41|47'),0)) && ( ! (_ChkObl('JCFUNSQXBI',1)))) && FullRow()) {
_SignErr('JCFUNSQXBI');
m_cLastWorkVarErrorMsg='1300662969';
l_bResult=false;
w_DATAFINE=HtW('','D');
} else if (( ! (_ChkObl('VEABFZIUKQ',1))) && FullRow()) {
_SignErr('VEABFZIUKQ');
m_cLastWorkVarErrorMsg='NOAGE';
l_bResult=false;
w_NOAGE='N';
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
m_oFather.SetModified_ardt_delegabo();
}
}
SaveContext.child=[];
function BlankRow() {
w_CODINTER='';
w_xragsoci='';
w_DESCINTER='';
w_DATAINI=NullDate();
w_TIPORAP='';
w_TIPOPERS='';
w_STATOREG='';
w_OPERAZMOD='';
w_DATARETT=NullDate();
w_IDEREG='';
w_COLLEGAMEN='';
w_DATAFINE=NullDate();
w_IDBASE='';
w_UCODE='';
w_tiporegr=0;
w_DOMICILIO='';
w_DESCCIT='';
w_PROVINCIA='';
w_CAP='';
w_NUMPROG1='';
w_NUMPROG2='';
w_xRagSoc='';
w_NOAGE='';
if ( ! (EmptyString(w_CODINTER))) {
Link_CROCGCIGKF(null);
}
w_STATOREG='0';
w_tiporegr=Utilities.Make(window).GetCallerNumber('tipregn');
w_NUMPROG1=( ! (Empty(Utilities.Make(window).GetCallerString('TIPOOPRAP'))) && Ne(At(Utilities.Make(window).GetCallerString('TIPOOPRAP'),'25|39|40'),0) && Empty(w_NUMPROG1) &&  ! (Empty(w_DATAINI))?Utilities.Make(window).GetCallerString('NUMPROG'):w_NUMPROG1);
w_NUMPROG2=( ! (Empty(Utilities.Make(window).GetCallerString('TIPOOPRAP'))) && Ne(At(Utilities.Make(window).GetCallerString('TIPOOPRAP'),'28|41|47'),0) && Empty(w_NUMPROG2) &&  ! (Empty(w_DATAFINE))?Utilities.Make(window).GetCallerString('NUMPROG'):w_NUMPROG2);
w_xRagSoc=( ! (Empty(LRTrim(w_xragsoci)))?w_xragsoci:( ! (Empty(w_CODINTER))?'Soggetto non presente in anagrafica':''));
w_NOAGE='N';
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
l_aRepeatedFields.CODINTER={"dec":0,"fixedpos":false,"id":"CROCGCIGKF","len":16,"name":"CODINTER","title":"","type":"C"};
l_aRepeatedFields.DESCINTER={"dec":0,"fixedpos":true,"id":"FMFJYQFDLE","len":70,"name":"DESCINTER","title":"","type":"C"};
l_aRepeatedFields.DATAINI={"dec":0,"fixedpos":false,"id":"BJKHVZBXDR","len":8,"name":"DATAINI","title":"Data Inizio","type":"D"};
l_aRepeatedFields.TIPORAP={"dec":0,"fixedpos":false,"id":"ELDZLJSOEH","len":1,"name":"TIPORAP","title":"Tipo Rapporto","type":"C"};
l_aRepeatedFields.TIPOPERS={"dec":0,"fixedpos":false,"id":"MNRSAHBCHQ","len":1,"name":"TIPOPERS","title":"Tipo Persona","type":"C"};
l_aRepeatedFields.STATOREG={"dec":0,"fixedpos":false,"id":"IAQJZGLOAD","len":1,"name":"STATOREG","title":"Stato Registrazione","type":"C"};
l_aRepeatedFields.OPERAZMOD={"dec":0,"fixedpos":false,"id":"DROURUHVGG","len":20,"name":"OPERAZMOD","title":"","type":"C"};
l_aRepeatedFields.DATARETT={"dec":0,"fixedpos":false,"id":"FATTRZDAAG","len":8,"name":"DATARETT","title":"Data Rettifica","type":"D"};
l_aRepeatedFields.IDEREG={"dec":0,"fixedpos":false,"id":"GLDZYZXXYY","len":20,"name":"IDEREG","title":"Identificativo Registrazione","type":"C"};
l_aRepeatedFields.COLLEGAMEN={"dec":0,"fixedpos":false,"id":"XWAEDZCMQI","len":20,"name":"COLLEGAMEN","title":"Collegamento","type":"C"};
l_aRepeatedFields.DATAFINE={"dec":0,"fixedpos":false,"id":"JCFUNSQXBI","len":8,"name":"DATAFINE","title":"Data Fine","type":"D"};
l_aRepeatedFields.IDBASE={"dec":0,"fixedpos":false,"id":"QCJOLDTFZW","len":10,"name":"IDBASE","title":"IDBASE","type":"C"};
l_aRepeatedFields.UCODE={"dec":0,"fixedpos":false,"id":"GHQWSBFMLC","len":7,"name":"UCODE","title":"","type":"C"};
l_aRepeatedFields.NUMPROG1={"dec":0,"fixedpos":true,"id":"XXEVJVFWWX","len":11,"name":"NUMPROG1","title":"N\u00B0 Progressivo","type":"C"};
l_aRepeatedFields.NUMPROG2={"dec":0,"fixedpos":true,"id":"QCGWEEVSON","len":11,"name":"NUMPROG2","title":"N\u00B0 Registrazione","type":"C"};
l_aRepeatedFields.NOAGE={"dec":0,"fixedpos":true,"id":"VEABFZIUKQ","len":1,"name":"NOAGE","title":"","type":"C"};
l_aRepeatedFields.xragsoci={"dec":0,"fixedpos":true,"id":"JBFZARQXMX","len":70,"name":"xragsoci","title":"Ragione Sociale","type":"C"};
l_aRepeatedFields.tiporegr={"dec":0,"fixedpos":true,"id":"HMUPOZLXKJ","len":1,"name":"tiporegr","title":"","type":"N"};
l_aRepeatedFields.DOMICILIO={"dec":0,"fixedpos":false,"id":"EUUXMNOQNT","len":35,"name":"DOMICILIO","title":"Indirizzo","type":"C"};
l_aRepeatedFields.DESCCIT={"dec":0,"fixedpos":false,"id":"GRZYQSLIKQ","len":30,"name":"DESCCIT","title":"Citt\u00E0","type":"C"};
l_aRepeatedFields.PROVINCIA={"dec":0,"fixedpos":false,"id":"ZEVXQFBLOE","len":2,"name":"PROVINCIA","title":"Provincia","type":"C"};
l_aRepeatedFields.CAP={"dec":0,"fixedpos":false,"id":"JKBQLYRRHI","len":9,"name":"CAP","title":"CAP","type":"C"};
l_aRepeatedFields.xRagSoc={"dec":0,"fixedpos":false,"id":"VICYEWBISV","len":70,"name":"xRagSoc","title":"","type":"C"};
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
if(c=Ctrl('VEABFZIUKQ')) SetDisabled(c,true);
SetQueryRow(Ctrl('GridTable'),false);
} else {
SetEditRow(Ctrl('GridTable'),false);
var c;
if(c=Ctrl('VEABFZIUKQ')) SetDisabled(c,false);
EnableControlsUnderCondition(false);
}
m_bChildDisabled=enable;
}
