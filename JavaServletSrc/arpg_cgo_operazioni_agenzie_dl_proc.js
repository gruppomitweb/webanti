function SetControlsValue() {
var c;
var c;
var tmp_FGMOCXNBFY = ToHTag(AsControlValue('<iframe width=\'655\' height=\'170\' id=\'elaborazione\' name=\'elaborazione\' frameborder=\'1\'  border=\'1\' align=\'TOP\' marginwidth=\'1\' marginheight=\'1\'></iframe>'));
if (Ne(e_FGMOCXNBFY,tmp_FGMOCXNBFY)) {
if(c=Ctrl('FGMOCXNBFY')) c.innerHTML=tmp_FGMOCXNBFY;
e_FGMOCXNBFY=tmp_FGMOCXNBFY;
}
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay(Ctrl('FGMOCXNBFY'),true);
HideUI();
}
function href_NCBNLXUPJW(p_nRow) {
ChangeRow(p_nRow);
SetHypPar('m_cAction',AsAppletValue('start'));
SetHypPar('m_cMode',AsAppletValue('hyperlink'));
SetHypPar('pNumOpe',AsAppletValue(c_SNAINUMOPE));
SetHypPar('pFlgT',AsAppletValue('E'));
SetHypPar('m_cParameterSequence',AsAppletValue('pNumOpe,pFlgT'));
SetHypPar('m_cID',AsAppletValue(m_IDS['arrt_snai_oper_load_dl']));
SendData('start','arrt_snai_oper_load_dl'+'',HParApplet().asString());
}
function href_VIKJFKDXAW(p_nRow) {
ChangeRow(p_nRow);
SetHypPar('m_cAction',AsAppletValue('start'));
SetHypPar('m_cMode',AsAppletValue('hyperlink'));
SetHypPar('m_cAtExit',AsAppletValue(close));
SetHypPar('pNumOpe',AsAppletValue(c_SNAINUMOPE));
SetHypPar('pFlgT',AsAppletValue('E'));
SetHypPar('m_cParameterSequence',AsAppletValue('pNumOpe,pFlgT'));
SetHypPar('m_cID',AsAppletValue(m_IDS['arrt_snai_oper_load_dl']));
SendData('start','arrt_snai_oper_load_dl'+'',HParApplet().asString());
}
function href_IIJDTQKPBX() {
SetLocationHref(window.location,ToResource('jsp/start_page_logo_portlet.jsp'+'')+'')
}
function href_ARLTTUFNZM() {
SetHypPar('m_cAction',AsAppletValue('start'));
SetHypPar('m_cMode',AsAppletValue('hyperlink'));
SetHypPar('m_cAtExit',AsAppletValue(close));
SetHypPar('pNumOpe',AsAppletValue(''));
SetHypPar('pFlgT',AsAppletValue('N'));
SetHypPar('m_cParameterSequence',AsAppletValue('pNumOpe,pFlgT'));
SetHypPar('m_cID',AsAppletValue(m_IDS['arrt_snai_oper_load_dl']));
SendData('start','arrt_snai_oper_load_dl'+'',HParApplet().asString());
}
function href_LUNECZXPTF(p_nRow) {
ChangeRow(p_nRow);
DeleteReg()
}
function href_TUBRHCCDNQ(p_nRow) {
ChangeRow(p_nRow);
var l_oWv = InitWvApplet();
l_oWv.setValue('w_SNAINUMOPE',AsAppletValue(c_SNAINUMOPE));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('w_SNAINUMOPE'));
SetLocationHref(null,'arrt_cgo_moduli_new'+'?m_cWv='+URLenc(l_oWv.asString())+'&m_cAction=start&m_cAtExit=close&m_cMode=hyperlink','elaborazione')
}
function href_RDEDPSEXJI() {
SetHypPar('m_bQuery',AsAppletValue(true));
var action = (Eq(Left('arpg_cgo_operazioni_agenzie_dl'+''+'?',31),'arpg_cgo_operazioni_agenzie_dl?')?'query':'start');
SetHypPar('m_cAction',AsAppletValue(action));
SetHypPar('m_cMode',AsAppletValue('hyperlink'));
SetHypPar('m_cAtExit',AsAppletValue(close));
SendData(action,'arpg_cgo_operazioni_agenzie_dl'+'',HParApplet().asString());
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
windowOpenForeground('../doc/arpg_cgo_operazioni_agenzie_dl_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_dataoggi=a[0];
w_gCodDip=a[1];
w_gStpDwn=a[2];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_cgo_operazioni_agenzie_dl',m_cSelectedPage);
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
w_dataoggi=SystemDate();
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
l_oWv.setValue('dataoggi',WtA(w_dataoggi,'D'));
l_oWv.setValue('gCodDip',WtA(w_gCodDip,'C'));
l_oWv.setValue('gStpDwn',WtA(w_gStpDwn,'C'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["dataoggi","gCodDip","gStpDwn"];
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
w_dataoggi=SystemDate();
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
  this.c_CACODICE = arguments[1]
  this.c_CADESCRI = arguments[2]
  this.c_SNAINUMOPE = arguments[3]
  this.c_TOTLIRE = arguments[4]
  this.c_SEGNO = arguments[5]
  this.c_CAIDBIGLIETTO = arguments[6]
  this.c_COGNOME = arguments[7]
  this.c_NOME = arguments[8]
}
function TrsToWork() {
var row;
if (Lt(m_nCurrentRow,m_oTrsQuery.length)) {
row=m_oTrsQuery[m_nCurrentRow];
c_DATAOPE=row.c_DATAOPE;
c_CACODICE=row.c_CACODICE;
c_CADESCRI=row.c_CADESCRI;
c_SNAINUMOPE=row.c_SNAINUMOPE;
c_TOTLIRE=row.c_TOTLIRE;
c_SEGNO=row.c_SEGNO;
c_CAIDBIGLIETTO=row.c_CAIDBIGLIETTO;
c_COGNOME=row.c_COGNOME;
c_NOME=row.c_NOME;
}
}
function WorkToTrs() {
var row;
if (Lt(m_nCurrentRow,m_oTrsQuery.length)) {
row=m_oTrsQuery[m_nCurrentRow];
row.c_DATAOPE=c_DATAOPE;
row.c_CACODICE=c_CACODICE;
row.c_CADESCRI=c_CADESCRI;
row.c_SNAINUMOPE=c_SNAINUMOPE;
row.c_TOTLIRE=c_TOTLIRE;
row.c_SEGNO=c_SEGNO;
row.c_CAIDBIGLIETTO=c_CAIDBIGLIETTO;
row.c_COGNOME=c_COGNOME;
row.c_NOME=c_NOME;
}
}
function BlankQueryFields() {
c_DATAOPE=NullDate();
c_CACODICE=0;
c_CADESCRI='';
c_SNAINUMOPE='';
c_TOTLIRE=0;
c_SEGNO='';
c_CAIDBIGLIETTO='';
c_COGNOME='';
c_NOME='';
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
Body_BeginHtml(45,'',0,'A','');
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
GroupFooter_BeginHtml(document,1,'12145358184'+l_nIdx+'','A',true,false)
GroupFooter_EndHtml(document,1,'12145358184'+l_nIdx+'','A')
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
GroupHeader_BeginHtml(document,1,'11608487272'+l_nIdx+'','A',true,false)
document.writeln(
 "<div id='DIV_0B95E448"+l_nIdx+"' style='position:relative;height:17px'>" +
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
 ""+ToHTag(Translate("11046582334"))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel KJNNJAUWPS_DIV'>" +
 "<label class='KJNNJAUWPS'>" +
 ""+ToHTag(Translate("176491428"))+"" +
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
 "</div>" +
"")
GroupHeader_EndHtml(document,1,'11608487272'+l_nIdx+'','A')
} else {
}
Row_BeginHtml(document,l_nEvenOdd,'1075866409'+l_nIdx+'','A',true,-1)
document.writeln(
 "<div id='DIV_0B930C48"+l_nIdx+"' style='position:relative;height:19px'>" +
"")
document.writeln(
 "<span class=' SPLabel NCBNLXUPJW_DIV'>" +
 "<label class='NCBNLXUPJW'>" +
 "<a href='javascript:href_NCBNLXUPJW("+l_nIdx+")'>" +
 ""+ToHTag(WtH(c_DATAOPE,'D',8,0,'DD-MM-YYYY'))+"" +
 "</a>" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel VIKJFKDXAW_DIV'>" +
 "<label class='VIKJFKDXAW'>" +
 "<a href='javascript:href_VIKJFKDXAW("+l_nIdx+")'>" +
 ""+ToHTag(WtH(c_CAIDBIGLIETTO,'C',28,0,''))+"" +
 "</a>" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel FVPBCGVIDQ_DIV'>" +
 "<label class='FVPBCGVIDQ'>" +
 ""+ToHTag(WtH(LRTrim(c_COGNOME)+' '+LRTrim(c_NOME),'C',56,0,''))+"" +
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
 "<span class=' SPLabel PBTFEBIWWV_DIV'>" +
 "<label class='PBTFEBIWWV'>" +
 ""+ToHTag(WtH(c_SEGNO,'C',1,0,''))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<a href='javascript:href_TUBRHCCDNQ("+l_nIdx+")' id='TUBRHCCDNQ_"+l_nIdx+"_HREF'>" +
 "<img id='TUBRHCCDNQ_"+l_nIdx+"' class='TUBRHCCDNQ' src="+"'"+ToResource('images/printer_ico.gif')+"'"+" title="+ToHTMLValue(Translate("10734924728"))+" alt="+ToHTMLValue(Translate("10734924728"),"C",0,0)+" onload=SetSectionsHeight('DIV_0B930C48',"+l_nIdx+")>" +
 "</a>" +
"")
document.writeln(
 "<a href='javascript:href_LUNECZXPTF("+l_nIdx+")' id='LUNECZXPTF_"+l_nIdx+"_HREF'>" +
 "<img id='LUNECZXPTF_"+l_nIdx+"' class='LUNECZXPTF' src="+"'"+ToResource('images/grid_delete.gif')+"'"+" title="+ToHTMLValue(Translate("10687827381"))+" alt="+ToHTMLValue(Translate("10687827381"),"C",0,0)+" onload=SetSectionsHeight('DIV_0B930C48',"+l_nIdx+")>" +
 "</a>" +
"")
document.writeln(
 "</div>" +
"")
Row_EndHtml(document,l_nEvenOdd,'1075866409'+l_nIdx+'','A')
Parms.Idx=l_nIdx;
Parms.Deep=l_nDeep;
Parms.EvenOdd=l_nEvenOdd;
}
Parms=new Object();
