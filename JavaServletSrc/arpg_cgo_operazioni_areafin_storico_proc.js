function SetControlsValue() {
var c;
var c;
if(c=Ctrl('VAUCRMZHWP')) c.value = WtH(w_DaData,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('OXXBPYCOCK')) c.value = WtH(w_A_Data,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
HideUI();
}
HideUI.lblids["A_Data"]=['CTLCSHLQSX'];
HideUI.lblids["DaData"]=['UVJLFCGXSJ'];
function href_NCBNLXUPJW(p_nRow) {
ChangeRow(p_nRow);
var l_oWv = InitWvApplet();
l_oWv.setValue('SNAINUMOPE',AsAppletValue(c_SNAINUMOPE));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('SNAINUMOPE'));
_modifyandopen('armt_snai_oper_storico'+'?m_cWv='+URLenc(l_oWv.asString())+'&m_cAction=view&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null)
}
function href_VIKJFKDXAW(p_nRow) {
ChangeRow(p_nRow);
var l_oWv = InitWvApplet();
l_oWv.setValue('SNAINUMOPE',AsAppletValue(c_SNAINUMOPE));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('SNAINUMOPE'));
_modifyandopen('armt_snai_oper_storico'+'?m_cWv='+URLenc(l_oWv.asString())+'&m_cAction=view&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null)
}
function href_RROILCAWGO() {
var l_oWv = InitWvApplet();
l_oWv.setValue('ReportName',AsAppletValue('arrp_cgo_operazioni_areafin_storico'));
l_oWv.setValue('outputFormat',AsAppletValue('PDF'));
l_oWv.setValue('rotation',AsAppletValue('LANDSCAPE'));
l_oWv.setValue('DaData',AsAppletValue(w_DaData));
l_oWv.setValue('A_Data',AsAppletValue(w_A_Data));
l_oWv.setValue('descazi',AsAppletValue(w_gDescAzi));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('ReportName,outputFormat,rotation,DaData,A_Data,descazi'));
_modifyandopen('Report'+'?m_cWv='+URLenc(l_oWv.asString())+'&m_cAction=start&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null)
}
function href_IIJDTQKPBX() {
SetLocationHref(window.location,ToResource('jsp/start_page_logo_portlet.jsp'+'')+'')
}
function VAUCRMZHWP_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('VAUCRMZHWP'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('VAUCRMZHWP').value=ApplyPictureToDate(Ctrl('VAUCRMZHWP').value,TranslatePicture(datePattern),'VAUCRMZHWP');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('VAUCRMZHWP'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('VAUCRMZHWP');
}
}
}
SetActiveField(Ctrl('VAUCRMZHWP'),false);
e=(Ne(e,null)?e:window.event);
return Set_DaData(HtW(Ctrl('VAUCRMZHWP').value,'D'),null,e) && dateisok;
}
function VAUCRMZHWP_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('VAUCRMZHWP'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('VAUCRMZHWP').value=WtH(w_DaData,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('VAUCRMZHWP');
SetActiveField(Ctrl('VAUCRMZHWP'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('VAUCRMZHWP'),e);
}
function VAUCRMZHWP_ZOOM_Click() {
LaunchCalendar(Ctrl('VAUCRMZHWP'));
}
function OXXBPYCOCK_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('OXXBPYCOCK'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('OXXBPYCOCK').value=ApplyPictureToDate(Ctrl('OXXBPYCOCK').value,TranslatePicture(datePattern),'OXXBPYCOCK');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('OXXBPYCOCK'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('OXXBPYCOCK');
}
}
}
SetActiveField(Ctrl('OXXBPYCOCK'),false);
e=(Ne(e,null)?e:window.event);
return Set_A_Data(HtW(Ctrl('OXXBPYCOCK').value,'D'),null,e) && dateisok;
}
function OXXBPYCOCK_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('OXXBPYCOCK'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('OXXBPYCOCK').value=WtH(w_A_Data,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('OXXBPYCOCK');
SetActiveField(Ctrl('OXXBPYCOCK'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('OXXBPYCOCK'),e);
}
function OXXBPYCOCK_ZOOM_Click() {
LaunchCalendar(Ctrl('OXXBPYCOCK'));
}
function href_QJJGHAYETE() {
SetHypPar('m_bQuery',AsAppletValue(true));
var action = (Eq(Left('arpg_cgo_operazioni_areafin_storico'+''+'?',36),'arpg_cgo_operazioni_areafin_storico?')?'query':'start');
SetHypPar('m_cAction',AsAppletValue(action));
SetHypPar('m_cMode',AsAppletValue('hyperlink'));
SendData(action,'arpg_cgo_operazioni_areafin_storico'+'',HParApplet().asString());
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
if(c=Ctrl('VAUCRMZHWP')) c.onblur=VAUCRMZHWP_Valid;
if(c=Ctrl('VAUCRMZHWP')) c.onfocus=VAUCRMZHWP_OnFocus;
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
if(c=Ctrl('VAUCRMZHWP')) c.onkeypress=CheckDateChar;
}
if(c=Ctrl('OXXBPYCOCK')) c.onblur=OXXBPYCOCK_Valid;
if(c=Ctrl('OXXBPYCOCK')) c.onfocus=OXXBPYCOCK_OnFocus;
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
if(c=Ctrl('OXXBPYCOCK')) c.onkeypress=CheckDateChar;
}
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
FocusFirstComponent.otherwise={"page_1":["VAUCRMZHWP"]};
function Help() {
windowOpenForeground('../doc/arpg_cgo_operazioni_areafin_storico_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_DaData=a[0];
w_A_Data=a[1];
w_gDescAzi=a[2];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_cgo_operazioni_areafin_storico',m_cSelectedPage);
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
function Set_DaData(ctrlValue,kmode,e) {
if (Ne(w_DaData,ctrlValue)) {
var ctl = _GetCtl(e,'VAUCRMZHWP');
if (_tracker.goon(ctl,ctrlValue)) {
w_DaData=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VAUCRMZHWP',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH(NullDate(),'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
_ResetTracker();
return true;
}
}
return true;
}
function Set_A_Data(ctrlValue,kmode,e) {
if (Ne(w_A_Data,ctrlValue)) {
var ctl = _GetCtl(e,'OXXBPYCOCK');
if (_tracker.goon(ctl,ctrlValue)) {
w_A_Data=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('OXXBPYCOCK',0);
DoUpdate(l_bResult);
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
if ( ! (_ChkObl('VAUCRMZHWP',1))) {
_SignErr('VAUCRMZHWP');
m_cLastWorkVarErrorMsg='10221529600';
l_bResult=false;
w_DaData=HtW('','D');
} else if ( ! (_ChkObl('OXXBPYCOCK',1))) {
_SignErr('OXXBPYCOCK');
m_cLastWorkVarErrorMsg='1328331631';
l_bResult=false;
w_A_Data=HtW('','D');
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('VAUCRMZHWP_ZOOM',lc)) {
return 0;
}
if (Eq('OXXBPYCOCK_ZOOM',lc)) {
return 0;
}
return -1;
}
function link_url(index) {
var l_oWv;
}
function FillWv() {
var l_oWv = InitWvApplet();
l_oWv.setValue('DaData',WtA(w_DaData,'D'));
l_oWv.setValue('A_Data',WtA(w_A_Data,'D'));
l_oWv.setValue('gDescAzi',WtA(w_gDescAzi,'C'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["DaData","A_Data","gDescAzi"];
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
if (Empty(w_DaData) && Ne(opener.w_DaData,null)) {
TransferBetweenWindows(opener,'w_DaData',null,'Set_DaData');
}
if (Empty(w_A_Data) && Ne(opener.w_A_Data,null)) {
TransferBetweenWindows(opener,'w_A_Data',null,'Set_A_Data');
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
  this.c_CACODICE = arguments[1]
  this.c_CADESCRI = arguments[2]
  this.c_SNAINUMOPE = arguments[3]
  this.c_TOTLIRE = arguments[4]
  this.c_SEGNO = arguments[5]
  this.c_CAIDBIGLIETTO = arguments[6]
  this.c_CGODATFINCOM = arguments[7]
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
c_CGODATFINCOM=row.c_CGODATFINCOM;
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
row.c_CGODATFINCOM=c_CGODATFINCOM;
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
c_CGODATFINCOM=NullDate();
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
Body_BeginHtml(42,'',0,'A','');
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
GroupFooter_BeginHtml(document,1,'11197745746'+l_nIdx+'','A',true,false)
GroupFooter_EndHtml(document,1,'11197745746'+l_nIdx+'','A')
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
GroupHeader_BeginHtml(document,1,'11197614674'+l_nIdx+'','A',true,false)
document.writeln(
 "<div id='DIV_0BAD59A8"+l_nIdx+"' style='position:relative;height:17px'>" +
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
 ""+ToHTag(Translate("1814604627"))+"" +
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
GroupHeader_EndHtml(document,1,'11197614674'+l_nIdx+'','A')
} else {
}
Row_BeginHtml(document,l_nEvenOdd,'12119706194'+l_nIdx+'','A',true,-1)
document.writeln(
 "<div id='DIV_0BB36F30"+l_nIdx+"' style='position:relative;height:19px'>" +
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
 ""+ToHTag(WtH(c_CAIDBIGLIETTO,'C',30,0,''))+"" +
 "</a>" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel UPLWYYLOLS_DIV'>" +
 "<label class='UPLWYYLOLS'>" +
 ""+ToHTag(WtH(c_CACODICE,'N',5,0,''))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel FVPBCGVIDQ_DIV'>" +
 "<label class='FVPBCGVIDQ'>" +
 ""+ToHTag(WtH(c_CADESCRI,'C',90,0,''))+"" +
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
 "</div>" +
"")
Row_EndHtml(document,l_nEvenOdd,'12119706194'+l_nIdx+'','A')
Parms.Idx=l_nIdx;
Parms.Deep=l_nDeep;
Parms.EvenOdd=l_nEvenOdd;
}
Parms=new Object();
_Obli('DaData',2,'VAUCRMZHWP',false,"10221529600")
_Obli('A_Data',2,'OXXBPYCOCK',false,"1328331631")
