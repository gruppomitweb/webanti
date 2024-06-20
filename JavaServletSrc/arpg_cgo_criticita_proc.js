function SetControlsValue() {
var c;
var c;
if(c=Ctrl('SINSZKENFU')) selectCombo(c,w_ctipo,'C')
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
HideUI();
}
HideUI.lblids["ctipo"]=['WDZSXSEYIO'];
function href_PTXYMSWBZO() {
SetLocationHref(window.location,ToResource('jsp/start_page_logo_portlet.jsp'+'')+'')
}
function href_FBLYVZOSYM() {
SetHypPar('m_cAction',AsAppletValue('start'));
SetHypPar('m_cMode',AsAppletValue('hyperlink'));
SetHypPar('m_cID',AsAppletValue(m_IDS['arrt_cgo_criticita_xls']));
SendData('start','arrt_cgo_criticita_xls'+'',HParApplet().asString());
}
function SINSZKENFU_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_ctipo(HtW(getComboValue(Ctrl('SINSZKENFU')),'C'),null,e);
}
function SINSZKENFU_OnFocus(e) {
SetActiveField(Ctrl('SINSZKENFU'),true);
}
function SINSZKENFU_OnBlur(e) {
SetActiveField(Ctrl('SINSZKENFU'),false);
}
function href_MELWIFMMZX() {
SetHypPar('m_cAction',AsAppletValue('start'));
SetHypPar('m_cMode',AsAppletValue('hyperlink'));
SetHypPar('m_cID',AsAppletValue(m_IDS['arrt_cgo_ctiticita']));
SendData('start','arrt_cgo_ctiticita'+'',HParApplet().asString());
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
if(c=Ctrl('SINSZKENFU')) c.onchange=SINSZKENFU_Valid;
if(c=Ctrl('SINSZKENFU')) c.onfocus=SINSZKENFU_OnFocus;
if(c=Ctrl('SINSZKENFU')) c.onblur=SINSZKENFU_OnBlur;
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
FocusFirstComponent.otherwise={"page_1":["SINSZKENFU"]};
function Help() {
windowOpenForeground('../doc/arpg_cgo_criticita_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_ctipo=a[0];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_cgo_criticita',m_cSelectedPage);
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
function Set_ctipo(ctrlValue,kmode,e) {
if (Ne(w_ctipo,ctrlValue)) {
var ctl = _GetCtl(e,'SINSZKENFU');
if (_tracker.goon(ctl,ctrlValue)) {
w_ctipo=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SINSZKENFU',0);
DoUpdate(l_bResult);
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
if ( ! (_ChkObl('SINSZKENFU',1))) {
_SignErr('SINSZKENFU');
m_cLastWorkVarErrorMsg='12025810828';
l_bResult=false;
w_ctipo=HtW('','C');
}
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
l_oWv.setValue('ctipo',WtA(w_ctipo,'C'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["ctipo"];
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
if (Eq(w_ctipo,' ') && Ne(opener.w_ctipo,null)) {
TransferBetweenWindows(opener,'w_ctipo',null,'Set_ctipo');
}
}
}
m_bCalculating=true;
if (start && Eq(At(',ctipo,',pseq),0)) {
w_ctipo=' ';
}
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
  this.c_CODDIP = arguments[0]
  this.c_DESCRIZ = arguments[1]
  this.c_DESCCIT = arguments[2]
  this.c_IDBASE = arguments[3]
  this.c_DATAOPE = arguments[4]
  this.c_FLGCRTC = arguments[5]
  this.c_NUMDAYS = arguments[6]
}
function TrsToWork() {
var row;
if (Lt(m_nCurrentRow,m_oTrsQuery.length)) {
row=m_oTrsQuery[m_nCurrentRow];
c_CODDIP=row.c_CODDIP;
c_DESCRIZ=row.c_DESCRIZ;
c_DESCCIT=row.c_DESCCIT;
c_IDBASE=row.c_IDBASE;
c_DATAOPE=row.c_DATAOPE;
c_FLGCRTC=row.c_FLGCRTC;
c_NUMDAYS=row.c_NUMDAYS;
}
}
function WorkToTrs() {
var row;
if (Lt(m_nCurrentRow,m_oTrsQuery.length)) {
row=m_oTrsQuery[m_nCurrentRow];
row.c_CODDIP=c_CODDIP;
row.c_DESCRIZ=c_DESCRIZ;
row.c_DESCCIT=c_DESCCIT;
row.c_IDBASE=c_IDBASE;
row.c_DATAOPE=c_DATAOPE;
row.c_FLGCRTC=c_FLGCRTC;
row.c_NUMDAYS=c_NUMDAYS;
}
}
function BlankQueryFields() {
c_CODDIP='';
c_DESCRIZ='';
c_DESCCIT='';
c_IDBASE='';
c_DATAOPE=NullDate();
c_FLGCRTC='';
c_NUMDAYS=0;
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
var l_DBMPSAJNIE = false;
var l_old_DBMPSAJNIE = l_DBMPSAJNIE;
Body_BeginHtml(45,'',0,'A','');
BlankQueryFields();
while ( ! (l_bEof)) {
l_oQuery=m_oTrsQuery[l_nIdx];
l_nDeep=0;
if (Lt(l_nIdx,m_nRows)) {
m_nCurrentRow=l_nIdx;
TrsToWork();
l_DBMPSAJNIE=true;
if (Eq(l_nIdx,0)) {
l_nDeep=1;
} else {
if (Ne(l_old_DBMPSAJNIE,l_DBMPSAJNIE)) {
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
GroupFooter_BeginHtml(document,1,'1528083860'+l_nIdx+'','A',true,false)
GroupFooter_EndHtml(document,1,'1528083860'+l_nIdx+'','A')
} else {
}
l_nIdx=l_nIdx+1;
m_nCurrentRow=l_nIdx;
TrsToWork();
l_old_DBMPSAJNIE = l_DBMPSAJNIE;
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
GroupHeader_BeginHtml(document,1,'1528092052'+l_nIdx+'','A',true,false)
document.writeln(
 "<div id='DIV_0B9A4A40"+l_nIdx+"' style='position:relative;height:16px'>" +
"")
document.writeln(
 "<span class=' SPLabel DIWJSXFYLW_DIV'>" +
 "<label class='DIWJSXFYLW'>" +
 ""+ToHTag(Translate("1745963953"))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel JUIALTQGYN_DIV'>" +
 "<label class='JUIALTQGYN'>" +
 ""+ToHTag(Translate("15186643"))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel TMWWFEJLFW_DIV'>" +
 "<label class='TMWWFEJLFW'>" +
 ""+ToHTag(Translate("1627951885"))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel FGSPNWXVTI_DIV'>" +
 "<label class='FGSPNWXVTI'>" +
 ""+ToHTag(Translate("117806551"))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "</div>" +
"")
GroupHeader_EndHtml(document,1,'1528092052'+l_nIdx+'','A')
} else {
}
Row_BeginHtml(document,l_nEvenOdd,'1470461332'+l_nIdx+'','A',true,-1)
document.writeln(
 "<div id='DIV_0B9A4EC0"+l_nIdx+"' style='position:relative;height:20px'>" +
"")
document.writeln(
 "<span class=' SPLabel IKAZSTAZPW_DIV'>" +
 "<label class='IKAZSTAZPW'>" +
 ""+ToHTag(WtH(c_IDBASE,'C',10,0,''))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel DLZLDHYANX_DIV'>" +
 "<label class='DLZLDHYANX'>" +
 ""+ToHTag(WtH(c_DESCRIZ,'C',30,0,''))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel KMXIORBZMD_DIV'>" +
 "<label class='KMXIORBZMD'>" +
 ""+ToHTag(WtH(c_DESCCIT,'C',30,0,''))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel GJELUXBWNJ_DIV'>" +
 "<label class='GJELUXBWNJ'>" +
 ""+ToHTag(WtH(c_DATAOPE,'D',8,0,'DD-MM-YYYY'))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel FGLKZVMBWR_DIV'>" +
 "<label class='FGLKZVMBWR'>" +
 ""+ToHTag(WtH(c_NUMDAYS,'N',4,0,'9999'))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<img id='NGQKTMHBWE_"+l_nIdx+"' class='NGQKTMHBWE' src="+"'"+ToResource((Eq(c_FLGCRTC,'R')?'images/stato2.gif':(Eq(c_FLGCRTC,'Y')?'images/stato3.gif':'')))+"'"+" alt='' onload=SetSectionsHeight('DIV_0B9A4EC0',"+l_nIdx+")>" +
"")
document.writeln(
 "</div>" +
"")
Row_EndHtml(document,l_nEvenOdd,'1470461332'+l_nIdx+'','A')
Parms.Idx=l_nIdx;
Parms.Deep=l_nDeep;
Parms.EvenOdd=l_nEvenOdd;
}
Parms=new Object();
_Obli('ctipo',0,'SINSZKENFU',false,"12025810828")
