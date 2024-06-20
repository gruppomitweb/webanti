function SetControlsValue() {
var c;
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
if (Gt(m_nRows,0)) {
}
HideUI();
}
function href_YIKKTEQZGN(p_nRow) {
ChangeRow(p_nRow);
SetLocationHref(window.location,ToResource(LRTrim(w_gUrlApp)+'flussi/'+LRTrim(w_gAzienda)+'/'+LRTrim(c_nomefile)+''+'')+'')
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
}
var l_nOldRow = m_nCurrentRow;
m_nCurrentRow=0;
while (Lt(m_nCurrentRow,m_nRows)) {
m_nCurrentRow=m_nCurrentRow+1;
}
m_nCurrentRow=l_nOldRow;
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
windowOpenForeground('../doc/arpg_filesage_do_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_gAzienda=a[1];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_filesage_do',m_cSelectedPage);
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
if (Gt(m_nRows,0)) {
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
function SetSectionsHeight(id,m_nCurrentRow) {
}
function AdjustOnResize() {
var i = 0;
while (Lt(i,m_nRows)) {
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
l_oWv.setValue('gAzienda',WtA(w_gAzienda,'C'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["gUrlApp","gAzienda"];
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
  this.w_gUrlApp = arguments[0]
  this.w_gAzienda = arguments[1]
  this.m_nRowStatus = arguments[2]
}
function TrsQueryRow() {
  this.c_datafile = arguments[0]
  this.c_nomefile = arguments[1]
  this.c_descfile = arguments[2]
}
function TrsToWork() {
var row;
if (Lt(m_nCurrentRow,m_oTrsFW.length)) {
row=m_oTrsFW[m_nCurrentRow];
w_gUrlApp=row.w_gUrlApp;
w_gAzienda=row.w_gAzienda;
m_nRowStatus=row.m_nRowStatus;
}
if (Lt(m_nCurrentRow,m_oTrsQuery.length)) {
row=m_oTrsQuery[m_nCurrentRow];
c_datafile=row.c_datafile;
c_nomefile=row.c_nomefile;
c_descfile=row.c_descfile;
}
}
function WorkToTrs() {
var row;
if (Lt(m_nCurrentRow,m_oTrsFW.length)) {
row=m_oTrsFW[m_nCurrentRow];
row.w_gUrlApp=w_gUrlApp;
row.w_gAzienda=w_gAzienda;
row.m_nRowStatus=m_nRowStatus;
}
if (Lt(m_nCurrentRow,m_oTrsQuery.length)) {
row=m_oTrsQuery[m_nCurrentRow];
row.c_datafile=c_datafile;
row.c_nomefile=c_nomefile;
row.c_descfile=c_descfile;
}
}
function BlankQueryFields() {
c_datafile=NullDate();
c_nomefile='';
c_descfile='';
}
function FillHTMLRow() {
var l_nIdx = 0;
var l_oQuery;
var l_oFields;
var l_nEvenOdd = 0;
var l_nPrev = 0;
var l_nNext = 0;
var l_bEof;
l_bEof=Eq(m_nRows,0);
var l_nDeep;
l_nDeep=-1;
var l_nPos = 0;
var l_QVSIBRPDHD = false;
var l_old_QVSIBRPDHD = l_QVSIBRPDHD;
Body_BeginHtml(0,'',0,'A','');
BlankQueryFields();
while ( ! (l_bEof)) {
l_oQuery=m_oTrsQuery[l_nIdx];
l_oFields=m_oTrsFW[l_nIdx];
l_nDeep=0;
if (Lt(l_nIdx,m_nRows)) {
m_nCurrentRow=l_nIdx;
TrsToWork();
l_QVSIBRPDHD=true;
if (Eq(l_nIdx,0)) {
l_nDeep=1;
} else {
if (Ne(l_old_QVSIBRPDHD,l_QVSIBRPDHD)) {
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
GroupFooter_BeginHtml(document,1,'11977273387'+l_nIdx+'','A',true,false)
GroupFooter_EndHtml(document,1,'11977273387'+l_nIdx+'','A')
} else {
}
l_nIdx=l_nIdx+1;
m_nCurrentRow=l_nIdx;
TrsToWork();
l_old_QVSIBRPDHD = l_QVSIBRPDHD;
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
GroupHeader_BeginHtml(document,1,'11977273355'+l_nIdx+'','A',true,false)
document.writeln(
 "<div id='DIV_03954060"+l_nIdx+"' style='position:relative;height:17px'>" +
"")
document.writeln(
 "<span class=' SPLabel INOSMZORRW_DIV'>" +
 "<label class='INOSMZORRW'>" +
 ""+ToHTag(Translate("251106009"))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel ELQBHNCGJW_DIV'>" +
 "<label class='ELQBHNCGJW'>" +
 ""+ToHTag(Translate("11236572921"))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel ZCQXNQPNXN_DIV'>" +
 "<label class='ZCQXNQPNXN'>" +
 ""+ToHTag(Translate("285808099"))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "</div>" +
"")
GroupHeader_EndHtml(document,1,'11977273355'+l_nIdx+'','A')
} else {
document.writeln(
 "<input name='gUrlApp_"+l_nIdx+"' id='LNTUFAZHYS_"+l_nIdx+"' type='hidden' value="+ToHTMLValue(WtH(w_gUrlApp,"C",80,0,''))+" size='80'>" +
"")
document.writeln(
 "<input name='gAzienda_"+l_nIdx+"' id='JXGSKHKUSP_"+l_nIdx+"' type='hidden' value="+ToHTMLValue(WtH(w_gAzienda,"C",10,0,''))+" size='10'>" +
"")
}
Row_BeginHtml(document,l_nEvenOdd,'11977498475'+l_nIdx+'','A',true,-1)
document.writeln(
 "<div id='DIV_039E7AF8"+l_nIdx+"' style='position:relative;height:18px'>" +
"")
document.writeln(
 "<span class=' SPLabel DVGUUMBHGD_DIV'>" +
 "<label class='DVGUUMBHGD'>" +
 ""+ToHTag(WtH(c_datafile,'D',8,0,'DD-MM-YYYY'))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel YIKKTEQZGN_DIV'>" +
 "<label class='YIKKTEQZGN'>" +
 "<a href='javascript:href_YIKKTEQZGN("+l_nIdx+")'>" +
 ""+ToHTag(WtH(c_nomefile,'C',20,0,''))+"" +
 "</a>" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel TRDMKFAVPV_DIV'>" +
 "<label class='TRDMKFAVPV'>" +
 ""+ToHTag(WtH(c_descfile,'C',40,0,''))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "</div>" +
"")
Row_EndHtml(document,l_nEvenOdd,'11977498475'+l_nIdx+'','A')
Parms.Idx=l_nIdx;
Parms.Deep=l_nDeep;
Parms.EvenOdd=l_nEvenOdd;
}
Parms=new Object();
