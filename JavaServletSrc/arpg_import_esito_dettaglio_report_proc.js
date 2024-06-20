function SetControlsValue() {
var c;
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
HideUI();
}
function href_NGHXLDVGCK(p_nRow) {
ChangeRow(p_nRow);
_modifyandopen(ToResource((Eq(LRTrim(c_ESITO),'File excel di esito')?LRTrim(w_gUrlApp)+'/output/'+LRTrim(c_NOMREP):LRTrim(w_gUrlApp)+'/stampe_off/'+LRTrim(c_NOMREP)+'.pdf')+''+'')+'?m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes,height=600,width=800',null)
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
}
}
function NotifyEvent(p_cEvent) {
var old_c;
}
function SetLastFocusedOnParent() {
// used only in child entities
}
function DoUpdate(p_bResult) {
Calculate();
SaveDependsOn();
SetControlsValue();
SetDynamicClasses();
SetDynamicTooltip();
EnableControlsUnderCondition();
SaveLabelDependsOn();
if ( ! (p_bResult)) {
DisplayErrorMessage();
}
m_nLastError=0;
m_cLastMsgError='';
}
FocusFirstComponent.otherwise={};
function Help() {
windowOpenForeground('../doc/arpg_import_esito_dettaglio_report_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
}
function CalledBatchEnd() {
if ( ! (m_bCalculating)) {
DoUpdate(true);
}
}
function LoadChildrenInPage(page,lazy) {
}
function DeclareWVs() {
var a = arguments;
w_gUrlApp=a[0];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_import_esito_dettaglio_report',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
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
var l_bEnabled = true;
// * --- Area Manuale = UI - Enable Controls Init
// * --- Fine Area Manuale
if (Ne(typeof(tabs),'undefined')) {
tabs.CheckTabStrip();
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
function SetSectionsHeight(id,m_nCurrentRow) {
if (Eq(id,'DIV_04107D68')) {
var delta0 = 0;
delta0=Max(GetStretchedHeight('CFDQJJOADT_'+m_nCurrentRow)-26,delta0);
if (Ne(delta0,0)) {
SetStretchedHeight('DIV_04107D68'+m_nCurrentRow,66+delta0);
SetStretchedHeight('DIV_04107D68_0_'+m_nCurrentRow,delta0+27);
}
}
if (Eq(id,'DIV_040FE858')) {
var delta0 = 0;
delta0=Max(GetStretchedHeight('NGHXLDVGCK_'+m_nCurrentRow)-27,delta0);
if (Ne(delta0,0)) {
SetStretchedHeight('DIV_040FE858'+m_nCurrentRow,32+delta0);
SetStretchedHeight('DIV_040FE858_0_'+m_nCurrentRow,delta0+27);
}
}
}
function AdjustOnResize() {
var i = 0;
while (Lt(i,m_nRows)) {
if (Ne(Ctrl('DIV_04107D68'+i),null)) {
SetSectionsHeight('DIV_04107D68',i);
}
if (Ne(Ctrl('DIV_040FE858'+i),null)) {
SetSectionsHeight('DIV_040FE858',i);
}
i=i+1;
}
}
function InitVariables() {
}
function Calculate() {
var l_bTmpRes;
var l_bResult = true;
m_bCalculating=true;
// * --- Area Manuale = UI - Calculate
// * --- Fine Area Manuale
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
if (Eq(formaction,'discard')) {
return;
}
if ((Ne(formaction,'next') && Ne(formaction,'previous') && Ne(formaction,'save')) || CheckRow()) {
SubmitForm(formaction,url,data);
} else {
DoUpdate(false);
}
}
function Check() {
var l_bResult = true;
ResetErrorVars();
m_nLastError=0;
// * --- Area Manuale = UI - Check Form
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
l_oWv.setValue('gUrlApp',WtA(w_gUrlApp,'C'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["gUrlApp"];
function SetModified(bRepeated) {
m_bUpdated=true;
if (bRepeated) {
if (Le(m_nCurrentRow,m_oTrsFW.length)) {
m_nRowStatus=1;
}
}
}
function initNoLocalVars(start,pseq) {
m_bCalculating=true;
m_bCalculating=false;
SaveDependsOn();
SetControlsValue();
EnableControlsUnderCondition();
SaveLabelDependsOn();
DoUpdate(true);
var l_oCaller;
if (IsWndAccessible(l_oCaller)) {
var xAccessErr; try{l_oCaller.Ctrl;}catch(e){xAccessErr=1;} //IE security access error
if ( ! (xAccessErr) && Ne(typeof(l_oCaller.Ctrl),'undefined') && Ne(l_oCaller.Ctrl('FSender'),null) && Ne(typeof(l_oCaller.Ctrl('FSender').m_cOldCPCCCHK),'undefined')) {
m_cCPCCCHK=l_oCaller.Ctrl('FSender').m_cOldCPCCCHK.value;
}
}
}
function CheckRow() {
var l_bResult = true;
ResetErrorVars();
if (Lt(m_nCurrentRow,m_nRows)) {
}
return l_bResult;
}
function TrsFWRow() {
  this.m_nRowStatus = arguments[0]
}
function TrsQueryRow() {
  this.c_ESITO = arguments[0]
  this.c_NOMREP = arguments[1]
}
function TrsToWork() {
var row;
if (Lt(m_nCurrentRow,m_oTrsQuery.length)) {
row=m_oTrsQuery[m_nCurrentRow];
c_ESITO=row.c_ESITO;
c_NOMREP=row.c_NOMREP;
}
}
function WorkToTrs() {
var row;
if (Lt(m_nCurrentRow,m_oTrsQuery.length)) {
row=m_oTrsQuery[m_nCurrentRow];
row.c_ESITO=c_ESITO;
row.c_NOMREP=c_NOMREP;
}
}
function BlankQueryFields() {
c_ESITO='';
c_NOMREP='';
}
function FillHTMLRow() {
var l_nIdx = 0;
var l_oQuery;
var l_nEvenOdd = 0;
var l_nPrev = 0;
var l_nNext = 0;
var l_bEof;
l_bEof=Eq(m_nRows,0);
var l_nDeep;
l_nDeep=-1;
var l_nPos = 0;
var l_SDNXOVWSXU = '';
var l_old_SDNXOVWSXU = l_SDNXOVWSXU;
Body_BeginHtml(0,'',0,'A','');
BlankQueryFields();
while ( ! (l_bEof)) {
l_oQuery=m_oTrsQuery[l_nIdx];
l_nDeep=0;
if (Lt(l_nIdx,m_nRows)) {
m_nCurrentRow=l_nIdx;
TrsToWork();
l_SDNXOVWSXU=c_ESITO;
if (Eq(l_nIdx,0)) {
l_nDeep=1;
} else {
if (Ne(l_old_SDNXOVWSXU,l_SDNXOVWSXU)) {
l_nDeep=2;
} else {
l_nDeep=3;
}
}
} else {
l_bEof=true;
l_nDeep=1;
}
l_nIdx=l_nIdx-1;
if (Ge(l_nIdx,0)) {
m_nCurrentRow=l_nIdx;
TrsToWork();
}
if (Ge(2,l_nDeep) && Ge(l_nIdx,0)) {
GroupFooter_BeginHtml(document,1,'1736981021'+l_nIdx+'','A',true,false)
GroupFooter_EndHtml(document,1,'1736981021'+l_nIdx+'','A')
} else {
}
l_nIdx=l_nIdx+1;
m_nCurrentRow=l_nIdx;
TrsToWork();
l_old_SDNXOVWSXU = l_SDNXOVWSXU;
if ( ! (l_bEof)) {
Parms.Idx=l_nIdx;
Parms.Deep=l_nDeep;
Parms.EvenOdd=l_nEvenOdd;
DrawLine(document);
l_nEvenOdd = l_nEvenOdd+1;
}
if ( ! (l_bEof)) {
l_nIdx=l_nIdx+1;
}
}
Body_EndHtml('A');
}
function DrawLine(document) {
l_nIdx=Parms.Idx;
l_nDeep=Parms.Deep;
l_nEvenOdd=Parms.EvenOdd;
if (Ge(2,l_nDeep)) {
GroupHeader_BeginHtml(document,1,'1736989213'+l_nIdx+'','A',true,false)
document.writeln(
 "<div id='DIV_04107D68"+l_nIdx+"' style='position:relative;height:66px'>" +
"")
document.writeln(
 "<div id='DIV_04107D68_0_"+l_nIdx+"' style='position:relative;height:27px'>" +
"")
document.writeln(
 "<table>" +
"")
document.writeln(
 "</table>" +
"")
document.writeln(
 "<span class=' SPLabel ETPJLEPQOL_DIV'>" +
 "<label class='ETPJLEPQOL'>" +
 ""+ToHTag(Translate("2074381767"))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel CFDQJJOADT_DIV'>" +
 "<label id='CFDQJJOADT_"+l_nIdx+"' class='CFDQJJOADT'>" +
 ""+ToHTag(WtH(c_ESITO,'C',200,0,''))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "</div>" +
"")
document.writeln(
 "<div id='DIV_04107D68_1_"+l_nIdx+"' style='position:relative;height:39px'>" +
"")
document.writeln(
 "<table>" +
"")
document.writeln(
 "</table>" +
"")
document.writeln(
 "<span class=' SPLabel OAHIHJSVGW_DIV'>" +
 "<label class='OAHIHJSVGW'>" +
 ""+ToHTag(Translate("1875861061"))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "</div>" +
"")
SetSectionsHeight('DIV_04107D68',l_nIdx);
document.writeln(
 "</div>" +
"")
GroupHeader_EndHtml(document,1,'1736989213'+l_nIdx+'','A')
} else {
}
Row_BeginHtml(document,l_nEvenOdd,'1679358493'+l_nIdx+'','A',true,-1)
document.writeln(
 "<div id='DIV_040FE858"+l_nIdx+"' style='position:relative;height:32px'>" +
"")
document.writeln(
 "<div id='DIV_040FE858_0_"+l_nIdx+"' style='position:relative;height:27px'>" +
"")
document.writeln(
 "<table>" +
"")
document.writeln(
 "</table>" +
"")
document.writeln(
 "<span class=' SPLabel NGHXLDVGCK_DIV'>" +
 "<label id='NGHXLDVGCK_"+l_nIdx+"' class='NGHXLDVGCK'>" +
 "<a href='javascript:href_NGHXLDVGCK("+l_nIdx+")'>" +
 ""+ToHTag(WtH(c_NOMREP,'C',236,0,''))+"" +
 "</a>" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "</div>" +
"")
document.writeln(
 "<div id='DIV_040FE858_1_"+l_nIdx+"' style='position:relative;height:5px'>" +
"")
document.writeln(
 "<table>" +
"")
document.writeln(
 "</table>" +
"")
document.writeln(
 "</div>" +
"")
SetSectionsHeight('DIV_040FE858',l_nIdx);
document.writeln(
 "</div>" +
"")
Row_EndHtml(document,l_nEvenOdd,'1679358493'+l_nIdx+'','A')
Parms.Idx=l_nIdx;
Parms.Deep=l_nDeep;
Parms.EvenOdd=l_nEvenOdd;
}
Parms=new Object();
