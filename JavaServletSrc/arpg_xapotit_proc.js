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
l_oWv.setValue('m_cAtExit',AsAppletValue('close&reload'));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('IDBASE,m_cAtExit'));
_modifyandopen('armt_xapotit'+'?m_cWv='+URLenc(l_oWv.asString())+'&m_cAction=edit&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null)
}
function href_AWKKPZGIBE(p_nRow) {
ChangeRow(p_nRow);
var l_oWv = InitWvApplet();
l_oWv.setValue('IDBASE',AsAppletValue(c_IDBASE));
l_oWv.setValue('m_cAtExit',AsAppletValue('close&reload'));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('IDBASE,m_cAtExit'));
_modifyandopen('armt_xapotit'+'?m_cWv='+URLenc(l_oWv.asString())+'&m_cAction=delete&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null)
}
function href_XZMBQDKCOI(p_nRow) {
ChangeRow(p_nRow);
var l_oWv = InitWvApplet();
l_oWv.setValue('IDBASE',AsAppletValue(c_IDBASE));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('IDBASE'));
_modifyandopen('armt_xapotit'+'?m_cWv='+URLenc(l_oWv.asString())+'&m_cAction=view&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null)
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
windowOpenForeground('../doc/arpg_xapotit_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_CODCLI=a[0];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_xapotit',m_cSelectedPage);
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
l_oWv.setValue('CODCLI',WtA(w_CODCLI,'C'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["CODCLI"];
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
if (Empty(w_CODCLI) && Ne(opener.w_CODCLI,null)) {
TransferBetweenWindows(opener,'w_CODCLI','w_CODCLI');
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
  this.c_NUMPROG = arguments[0]
  this.c_DATAOPE = arguments[1]
  this.c_DATAREG = arguments[2]
  this.c_TIPOOPRAP = arguments[3]
  this.c_DES1 = arguments[4]
  this.c_IDBASE = arguments[5]
  this.c_RAGSOC = arguments[6]
}
function TrsToWork() {
var row;
if (Lt(m_nCurrentRow,m_oTrsQuery.length)) {
row=m_oTrsQuery[m_nCurrentRow];
c_NUMPROG=row.c_NUMPROG;
c_DATAOPE=row.c_DATAOPE;
c_DATAREG=row.c_DATAREG;
c_TIPOOPRAP=row.c_TIPOOPRAP;
c_DES1=row.c_DES1;
c_IDBASE=row.c_IDBASE;
c_RAGSOC=row.c_RAGSOC;
}
}
function WorkToTrs() {
var row;
if (Lt(m_nCurrentRow,m_oTrsQuery.length)) {
row=m_oTrsQuery[m_nCurrentRow];
row.c_NUMPROG=c_NUMPROG;
row.c_DATAOPE=c_DATAOPE;
row.c_DATAREG=c_DATAREG;
row.c_TIPOOPRAP=c_TIPOOPRAP;
row.c_DES1=c_DES1;
row.c_IDBASE=c_IDBASE;
row.c_RAGSOC=c_RAGSOC;
}
}
function BlankQueryFields() {
c_NUMPROG='';
c_DATAOPE=NullDate();
c_DATAREG=NullDate();
c_TIPOOPRAP='';
c_DES1='';
c_IDBASE='';
c_RAGSOC='';
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
var l_KZPQBLBTTD = false;
var l_old_KZPQBLBTTD = l_KZPQBLBTTD;
Body_BeginHtml(0,'',0,'A','');
BlankQueryFields();
while ( ! (l_bEof)) {
l_oQuery=m_oTrsQuery[l_nIdx];
l_nDeep=0;
if (Lt(l_nIdx,m_nRows)) {
m_nCurrentRow=l_nIdx;
TrsToWork();
l_KZPQBLBTTD=true;
if (Eq(l_nIdx,0)) {
l_nDeep=1;
} else {
if (Ne(l_old_KZPQBLBTTD,l_KZPQBLBTTD)) {
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
GroupFooter_BeginHtml(document,1,'10592668624'+l_nIdx+'','A',true,false)
GroupFooter_EndHtml(document,1,'10592668624'+l_nIdx+'','A')
} else {
}
l_nIdx=l_nIdx+1;
m_nCurrentRow=l_nIdx;
TrsToWork();
l_old_KZPQBLBTTD = l_KZPQBLBTTD;
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
GroupHeader_BeginHtml(document,1,'10590571472'+l_nIdx+'','A',true,false)
document.writeln(
 "<div id='DIV_0BAA6AA0"+l_nIdx+"' style='position:relative;height:17px'>" +
"")
document.writeln(
 "<span class=' SPLabel UUKIAJLULH_DIV'>" +
 "<label class='UUKIAJLULH'>" +
 ""+ToHTag(Translate("36228043"))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel RGZCLGJAYL_DIV'>" +
 "<label class='RGZCLGJAYL'>" +
 ""+ToHTag(Translate("10988377690"))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel NLDPPLKMOK_DIV'>" +
 "<label class='NLDPPLKMOK'>" +
 ""+ToHTag(Translate("10632911230"))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel TFECDFTYBB_DIV'>" +
 "<label class='TFECDFTYBB'>" +
 ""+ToHTag(Translate("684190680"))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel HLXCWREVDJ_DIV'>" +
 "<label class='HLXCWREVDJ'>" +
 ""+ToHTag(Translate("10930911516"))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "</div>" +
"")
GroupHeader_EndHtml(document,1,'10590571472'+l_nIdx+'','A')
} else {
}
Row_BeginHtml(document,l_nEvenOdd,'1835833392'+l_nIdx+'','A',true,-1)
document.writeln(
 "<div id='DIV_0BB9B650"+l_nIdx+"' style='position:relative;height:18px'>" +
"")
document.writeln(
 "<a href='javascript:href_XZMBQDKCOI("+l_nIdx+")' id='XZMBQDKCOI_"+l_nIdx+"_HREF'>" +
 "<img id='XZMBQDKCOI_"+l_nIdx+"' class='XZMBQDKCOI' src="+"'"+ToResource('images/view.png')+"'"+" alt='' onload=SetSectionsHeight('DIV_0BB9B650',"+l_nIdx+")>" +
 "</a>" +
"")
document.writeln(
 "<a href='javascript:href_XZUXXWWVEZ("+l_nIdx+")' id='XZUXXWWVEZ_"+l_nIdx+"_HREF'>" +
 "<img id='XZUXXWWVEZ_"+l_nIdx+"' class='XZUXXWWVEZ' src="+"'"+ToResource('images/edit.gif')+"'"+" alt='' onload=SetSectionsHeight('DIV_0BB9B650',"+l_nIdx+")>" +
 "</a>" +
"")
document.writeln(
 "<a href='javascript:href_AWKKPZGIBE("+l_nIdx+")' id='AWKKPZGIBE_"+l_nIdx+"_HREF'>" +
 "<img id='AWKKPZGIBE_"+l_nIdx+"' class='AWKKPZGIBE' src="+"'"+ToResource('images/remove.gif')+"'"+" alt='' onload=SetSectionsHeight('DIV_0BB9B650',"+l_nIdx+")>" +
 "</a>" +
"")
document.writeln(
 "<span class=' SPLabel PWCTHSFJFH_DIV'>" +
 "<label class='PWCTHSFJFH'>" +
 ""+ToHTag(WtH(c_NUMPROG,'C',11,0,''))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel TPXCKMHEIY_DIV'>" +
 "<label class='TPXCKMHEIY'>" +
 ""+ToHTag(WtH(c_DATAOPE,'D',8,0,'DD-MM-YYYY'))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel ZNXEVWIYPS_DIV'>" +
 "<label class='ZNXEVWIYPS'>" +
 ""+ToHTag(WtH(c_DATAREG,'D',8,0,'DD-MM-YYYY'))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel WYAYSYQOCA_DIV'>" +
 "<label class='WYAYSYQOCA'>" +
 ""+ToHTag(WtH(c_DES1,'C',90,0,''))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel MFQSEAPBLE_DIV'>" +
 "<label class='MFQSEAPBLE'>" +
 ""+ToHTag(WtH(c_RAGSOC,'C',70,0,''))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "</div>" +
"")
Row_EndHtml(document,l_nEvenOdd,'1835833392'+l_nIdx+'','A')
Parms.Idx=l_nIdx;
Parms.Deep=l_nDeep;
Parms.EvenOdd=l_nEvenOdd;
}
Parms=new Object();
