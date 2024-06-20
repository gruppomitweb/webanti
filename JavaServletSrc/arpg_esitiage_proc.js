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
function href_TFUBIXPNHF(p_nRow) {
ChangeRow(p_nRow);
var l_oWv = InitWvApplet();
l_oWv.setValue('CONNES',AsAppletValue(c_connes));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('CONNES'));
_modifyandopen('arpg_edt_personbo'+'?m_cWv='+URLenc(l_oWv.asString())+'&m_cAction=start&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null)
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
windowOpenForeground('../doc/arpg_esitiage_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_esitiage',m_cSelectedPage);
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
}
function FillWv() {
var l_oWv = InitWvApplet();
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=[];
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
  this.c_trueident = arguments[0]
  this.c_rapporto = arguments[1]
  this.c_connes = arguments[2]
  this.c_ragsoc = arguments[3]
  this.c_aprog = arguments[4]
  this.c_afile = arguments[5]
  this.c_cprog = arguments[6]
  this.c_cfile = arguments[7]
}
function TrsToWork() {
var row;
if (Lt(m_nCurrentRow,m_oTrsQuery.length)) {
row=m_oTrsQuery[m_nCurrentRow];
c_trueident=row.c_trueident;
c_rapporto=row.c_rapporto;
c_connes=row.c_connes;
c_ragsoc=row.c_ragsoc;
c_aprog=row.c_aprog;
c_afile=row.c_afile;
c_cprog=row.c_cprog;
c_cfile=row.c_cfile;
}
}
function WorkToTrs() {
var row;
if (Lt(m_nCurrentRow,m_oTrsQuery.length)) {
row=m_oTrsQuery[m_nCurrentRow];
row.c_trueident=c_trueident;
row.c_rapporto=c_rapporto;
row.c_connes=c_connes;
row.c_ragsoc=c_ragsoc;
row.c_aprog=c_aprog;
row.c_afile=c_afile;
row.c_cprog=c_cprog;
row.c_cfile=c_cfile;
}
}
function BlankQueryFields() {
c_trueident='';
c_rapporto='';
c_connes='';
c_ragsoc='';
c_aprog='';
c_afile='';
c_cprog='';
c_cfile='';
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
var l_nStartRow = Val(document.FSender.StartRow.value);
var l_nPos = 0;
var l_TDTBTFWCIF = false;
var l_old_TDTBTFWCIF = l_TDTBTFWCIF;
Body_BeginHtml(0,'',0,'A','');
BlankQueryFields();
while ( ! (l_bEof)) {
l_oQuery=m_oTrsQuery[l_nIdx];
l_nDeep=0;
if (Lt(l_nIdx,m_nRows)) {
m_nCurrentRow=l_nIdx;
TrsToWork();
l_TDTBTFWCIF=true;
if (Eq(l_nIdx,0)) {
l_nDeep=1;
} else {
if (Ne(l_old_TDTBTFWCIF,l_TDTBTFWCIF)) {
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
GroupFooter_BeginHtml(document,1,'1175568310'+l_nIdx+'','A',true,false)
document.writeln(
 "<div id='DIV_0B93BB88"+l_nIdx+"' style='position:relative;height:1px'>" +
"")
document.writeln(
 "<div style='overflow:hidden'>" +
 "</div>" +
"")
document.writeln(
 "</div>" +
"")
GroupFooter_EndHtml(document,1,'1175568310'+l_nIdx+'','A')
} else {
}
l_nIdx=l_nIdx+1;
m_nCurrentRow=l_nIdx;
TrsToWork();
l_old_TDTBTFWCIF = l_TDTBTFWCIF;
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
Body_Buttons(Gt(l_nStartRow,1),m_bOtherRow,'A');
Body_EndHtml('A');
}
function DrawLine(document) {
l_nIdx=Parms.Idx;
l_nDeep=Parms.Deep;
l_nEvenOdd=Parms.EvenOdd;
if (Ge(2,l_nDeep)) {
GroupHeader_BeginHtml(document,1,'1209122742'+l_nIdx+'','A',true,false)
document.writeln(
 "<div id='DIV_09E7DBA0"+l_nIdx+"' style='position:relative;height:15px'>" +
"")
document.writeln(
 "<span class=' SPLabel OSEKBUDNSW_DIV'>" +
 "<label class='OSEKBUDNSW'>" +
 ""+ToHTag(Translate("1805022818"))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel OMHPRIFVLR_DIV'>" +
 "<label class='OMHPRIFVLR'>" +
 ""+ToHTag(Translate("1806425667"))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel OBRALSGENJ_DIV'>" +
 "<label class='OBRALSGENJ'>" +
 ""+ToHTag(Translate("11983148991"))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel ZGZBALQNCQ_DIV'>" +
 "<label class='ZGZBALQNCQ'>" +
 ""+ToHTag(Translate("11983201341"))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "</div>" +
"")
GroupHeader_EndHtml(document,1,'1209122742'+l_nIdx+'','A')
} else {
}
Row_BeginHtml(document,l_nEvenOdd,'1376894853'+l_nIdx+'','A',true,-1)
document.writeln(
 "<div id='DIV_0C0CB7F0"+l_nIdx+"' style='position:relative;height:16px'>" +
"")
document.writeln(
 "<span class=' SPLabel QGZRZDUDMX_DIV'>" +
 "<label class='QGZRZDUDMX'>" +
 ""+ToHTag(WtH(c_rapporto,'C',25,0,''))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel TFUBIXPNHF_DIV'>" +
 "<label class='TFUBIXPNHF'>" +
 "<a href='javascript:href_TFUBIXPNHF("+l_nIdx+")'>" +
 ""+ToHTag(WtH(c_connes,'C',16,0,''))+"" +
 "</a>" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel UZJTVJNCBT_DIV'>" +
 "<label class='UZJTVJNCBT'>" +
 ""+ToHTag(WtH(c_ragsoc,'C',30,0,''))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel KTBPOIRPUE_DIV'>" +
 "<label class='KTBPOIRPUE'>" +
 ""+ToHTag(WtH(c_afile,'C',15,0,''))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel YUKHANGXWU_DIV'>" +
 "<label class='YUKHANGXWU'>" +
 ""+ToHTag(WtH(c_aprog,'C',25,0,''))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel ONRHPJZKOT_DIV'>" +
 "<label class='ONRHPJZKOT'>" +
 ""+ToHTag(WtH(c_cfile,'C',15,0,''))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel DZVIFVWVRR_DIV'>" +
 "<label class='DZVIFVWVRR'>" +
 ""+ToHTag(WtH(c_cprog,'C',25,0,''))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "</div>" +
"")
Row_EndHtml(document,l_nEvenOdd,'1376894853'+l_nIdx+'','A')
Parms.Idx=l_nIdx;
Parms.Deep=l_nDeep;
Parms.EvenOdd=l_nEvenOdd;
}
Parms=new Object();
