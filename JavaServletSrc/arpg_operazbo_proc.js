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
function href_XZUXXWWVEZ(p_nRow) {
ChangeRow(p_nRow);
var l_oWv = InitWvApplet();
l_oWv.setValue('IDBASE',AsAppletValue(c_IDBASE));
l_oWv.setValue('STATO',AsAppletValue(c_STATOREG));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('IDBASE,STATO'));
_modifyandopen('arpg_edt_operazbo'+'?m_cWv='+URLenc(l_oWv.asString())+'&m_cAction=start&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null)
}
function href_AWKKPZGIBE(p_nRow) {
ChangeRow(p_nRow);
var l_oWv = InitWvApplet();
l_oWv.setValue('IDBASE',AsAppletValue(c_IDBASE));
l_oWv.setValue('STATO',AsAppletValue(c_STATOREG));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('IDBASE,STATO'));
_modifyandopen('arpg_del_operazbo'+'?m_cWv='+URLenc(l_oWv.asString())+'&m_cAction=start&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null)
}
function href_XZMBQDKCOI(p_nRow) {
ChangeRow(p_nRow);
var l_oWv = InitWvApplet();
l_oWv.setValue('IDBASE',AsAppletValue(c_IDBASE));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('IDBASE'));
_modifyandopen('armt_operazioni'+'?m_cWv='+URLenc(l_oWv.asString())+'&m_cAction=view&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null)
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
windowOpenForeground('../doc/arpg_operazbo_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_rapporto=a[0];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_operazbo',m_cSelectedPage);
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
var l_oWv;
}
function FillWv() {
var l_oWv = InitWvApplet();
l_oWv.setValue('rapporto',WtA(w_rapporto,'C'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["rapporto"];
function SetModified(bRepeated) {
m_bUpdated=true;
if (bRepeated) {
if (Le(m_nCurrentRow,m_oTrsFW.length)) {
m_nRowStatus=1;
}
}
}
function initNoLocalVars(start,pseq) {
if (IsWndAccessible(opener)) {
if (start) {
if (Empty(w_rapporto) && Ne(opener.w_rapporto,null)) {
TransferBetweenWindows(opener,'w_rapporto','w_rapporto');
}
}
}
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
  this.c_DATAOPE = arguments[0]
  this.c_NUMPROG = arguments[1]
  this.c_TOTLIRE = arguments[2]
  this.c_TOTCONT = arguments[3]
  this.c_STATOREG = arguments[4]
  this.c_VALUTA = arguments[5]
  this.c_TIPO = arguments[6]
  this.c_IDBASE = arguments[7]
  this.c_STATO = arguments[8]
}
function TrsToWork() {
var row;
if (Lt(m_nCurrentRow,m_oTrsQuery.length)) {
row=m_oTrsQuery[m_nCurrentRow];
c_DATAOPE=row.c_DATAOPE;
c_NUMPROG=row.c_NUMPROG;
c_TOTLIRE=row.c_TOTLIRE;
c_TOTCONT=row.c_TOTCONT;
c_STATOREG=row.c_STATOREG;
c_VALUTA=row.c_VALUTA;
c_TIPO=row.c_TIPO;
c_IDBASE=row.c_IDBASE;
c_STATO=row.c_STATO;
}
}
function WorkToTrs() {
var row;
if (Lt(m_nCurrentRow,m_oTrsQuery.length)) {
row=m_oTrsQuery[m_nCurrentRow];
row.c_DATAOPE=c_DATAOPE;
row.c_NUMPROG=c_NUMPROG;
row.c_TOTLIRE=c_TOTLIRE;
row.c_TOTCONT=c_TOTCONT;
row.c_STATOREG=c_STATOREG;
row.c_VALUTA=c_VALUTA;
row.c_TIPO=c_TIPO;
row.c_IDBASE=c_IDBASE;
row.c_STATO=c_STATO;
}
}
function BlankQueryFields() {
c_DATAOPE=NullDate();
c_NUMPROG='';
c_TOTLIRE=0;
c_TOTCONT=0;
c_STATOREG='';
c_VALUTA='';
c_TIPO='';
c_IDBASE='';
c_STATO='';
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
var l_RMODFGAYVQ = false;
var l_old_RMODFGAYVQ = l_RMODFGAYVQ;
Body_BeginHtml(0,'',0,'A','');
BlankQueryFields();
while ( ! (l_bEof)) {
l_oQuery=m_oTrsQuery[l_nIdx];
l_nDeep=0;
if (Lt(l_nIdx,m_nRows)) {
m_nCurrentRow=l_nIdx;
TrsToWork();
l_RMODFGAYVQ=true;
if (Eq(l_nIdx,0)) {
l_nDeep=1;
} else {
if (Ne(l_old_RMODFGAYVQ,l_RMODFGAYVQ)) {
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
GroupFooter_BeginHtml(document,1,'62621748'+l_nIdx+'','A',true,false)
GroupFooter_EndHtml(document,1,'62621748'+l_nIdx+'','A')
} else {
}
l_nIdx=l_nIdx+1;
m_nCurrentRow=l_nIdx;
TrsToWork();
l_old_RMODFGAYVQ = l_RMODFGAYVQ;
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
GroupHeader_BeginHtml(document,1,'96176180'+l_nIdx+'','A',true,false)
document.writeln(
 "<div id='DIV_09821CF0"+l_nIdx+"' style='position:relative;height:17px'>" +
"")
document.writeln(
 "<span class=' SPLabel TMQVCJOIVG_DIV'>" +
 "<label class='TMQVCJOIVG'>" +
 ""+ToHTag(Translate("10988377690"))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel YIZUNOKTNJ_DIV'>" +
 "<label class='YIZUNOKTNJ'>" +
 ""+ToHTag(Translate("11446421191"))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel KJNNJAUWPS_DIV'>" +
 "<label class='KJNNJAUWPS'>" +
 ""+ToHTag(Translate("109822566"))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel GBJTZQVVJR_DIV'>" +
 "<label class='GBJTZQVVJR'>" +
 ""+ToHTag(Translate("1991862041"))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel UOYXXTLXBH_DIV'>" +
 "<label class='UOYXXTLXBH'>" +
 ""+ToHTag(Translate("10943726013"))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel CBJEVNODON_DIV'>" +
 "<label class='CBJEVNODON'>" +
 ""+ToHTag(Translate("7776403"))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "</div>" +
"")
GroupHeader_EndHtml(document,1,'96176180'+l_nIdx+'','A')
} else {
}
Row_BeginHtml(document,l_nEvenOdd,'263948291'+l_nIdx+'','A',true,-1)
document.writeln(
 "<div id='DIV_099945D0"+l_nIdx+"' style='position:relative;height:18px'>" +
"")
document.writeln(
 "<a href='javascript:href_XZMBQDKCOI("+l_nIdx+")' id='XZMBQDKCOI_"+l_nIdx+"_HREF'>" +
 "<img id='XZMBQDKCOI_"+l_nIdx+"' class='XZMBQDKCOI' src="+"'"+ToResource('images/view.png')+"'"+" alt='' onload=SetSectionsHeight('DIV_099945D0',"+l_nIdx+")>" +
 "</a>" +
"")
document.writeln(
 "<a href='javascript:href_XZUXXWWVEZ("+l_nIdx+")' id='XZUXXWWVEZ_"+l_nIdx+"_HREF'>" +
 "<img id='XZUXXWWVEZ_"+l_nIdx+"' class='XZUXXWWVEZ' style='"+( ! (Ne(c_STATOREG,'0') && Ne(c_STATOREG,'1'))?'':'display:none;visibility:hidden;')+"' src="+"'"+ToResource('images/edit.gif')+"'"+" alt='' onload=SetSectionsHeight('DIV_099945D0',"+l_nIdx+")>" +
 "</a>" +
"")
document.writeln(
 "<a href='javascript:href_AWKKPZGIBE("+l_nIdx+")' id='AWKKPZGIBE_"+l_nIdx+"_HREF'>" +
 "<img id='AWKKPZGIBE_"+l_nIdx+"' class='AWKKPZGIBE' style='"+( ! (Ne(c_STATOREG,'0') && Ne(c_STATOREG,'1'))?'':'display:none;visibility:hidden;')+"' src="+"'"+ToResource('images/remove.gif')+"'"+" alt='' onload=SetSectionsHeight('DIV_099945D0',"+l_nIdx+")>" +
 "</a>" +
"")
document.writeln(
 "<span class=' SPLabel NCBNLXUPJW_DIV'>" +
 "<label class='NCBNLXUPJW'>" +
 ""+ToHTag(WtH(c_DATAOPE,'D',8,0,'DD-MM-YYYY'))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel VIKJFKDXAW_DIV'>" +
 "<label class='VIKJFKDXAW'>" +
 ""+ToHTag(WtH(c_NUMPROG,'C',11,0,''))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel UPLWYYLOLS_DIV'>" +
 "<label class='UPLWYYLOLS'>" +
 ""+ToHTag(WtH(c_VALUTA,'C',3,0,''))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel LTUMTYITPB_DIV'>" +
 "<label class='LTUMTYITPB'>" +
 ""+ToHTag(WtH(c_TOTLIRE,'N',13,2,'9,999,999,999.99'))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel HLSUEMHNWS_DIV'>" +
 "<label class='HLSUEMHNWS'>" +
 ""+ToHTag(WtH(c_TOTCONT,'N',13,2,'9,999,999,999.99'))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel JVODECZXFG_DIV'>" +
 "<label class='JVODECZXFG'>" +
 ""+ToHTag(WtH(c_STATO,'C',20,0,''))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "</div>" +
"")
Row_EndHtml(document,l_nEvenOdd,'263948291'+l_nIdx+'','A')
Parms.Idx=l_nIdx;
Parms.Deep=l_nDeep;
Parms.EvenOdd=l_nEvenOdd;
}
Parms=new Object();
