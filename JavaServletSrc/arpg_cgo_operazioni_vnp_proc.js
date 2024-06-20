function SetControlsValue() {
var c;
var c;
if(c=Ctrl('HZHPBOOXGE')) c.value = WtH(w_agenzia,'C',6,0,'')
var tmp_MHBJRXVDJU = ToHTag(AsControlValue(w_xdesage));
if (Ne(e_MHBJRXVDJU,tmp_MHBJRXVDJU)) {
if(c=Ctrl('MHBJRXVDJU')) c.innerHTML=tmp_MHBJRXVDJU;
e_MHBJRXVDJU=tmp_MHBJRXVDJU;
}
if(c=Ctrl('YDGZPKWQQA')) c.value = WtH(w_xagenzia,'C',10,0,'')
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
HideUI();
}
HideUI.lblids["agenzia"]=['MKIGHUWRVZ'];
function href_NCBNLXUPJW(p_nRow) {
ChangeRow(p_nRow);
SetHypPar('m_cAction',AsAppletValue('start'));
SetHypPar('m_cMode',AsAppletValue('hyperlink'));
SetHypPar('pNumOpe',AsAppletValue(c_SNAINUMOPE));
SetHypPar('pFlgT',AsAppletValue('N'));
SetHypPar('m_cParameterSequence',AsAppletValue('pNumOpe,pFlgT'));
SetHypPar('m_cID',AsAppletValue(m_IDS['arrt_snai_oper_load']));
SendData('start','arrt_snai_oper_load'+'',HParApplet().asString());
}
function href_VIKJFKDXAW(p_nRow) {
ChangeRow(p_nRow);
SetHypPar('m_cAction',AsAppletValue('start'));
SetHypPar('m_cMode',AsAppletValue('hyperlink'));
SetHypPar('m_cAtExit',AsAppletValue(close));
SetHypPar('pNumOpe',AsAppletValue(c_SNAINUMOPE));
SetHypPar('pFlgT',AsAppletValue('N'));
SetHypPar('m_cParameterSequence',AsAppletValue('pNumOpe,pFlgT'));
SetHypPar('m_cID',AsAppletValue(m_IDS['arrt_snai_oper_load']));
SendData('start','arrt_snai_oper_load'+'',HParApplet().asString());
}
function href_RROILCAWGO() {
SetHypPar('m_bQuery',AsAppletValue(true));
var action = (Eq(Left('arpg_cgo_operazioni_vnp'+''+'?',24),'arpg_cgo_operazioni_vnp?')?'query':'start');
SetHypPar('m_cAction',AsAppletValue(action));
SetHypPar('m_cMode',AsAppletValue('hyperlink'));
SendData(action,'arpg_cgo_operazioni_vnp'+'',HParApplet().asString());
}
function href_IIJDTQKPBX() {
SetLocationHref(window.location,ToResource('jsp/start_page_logo_portlet.jsp'+'')+'')
}
function HZHPBOOXGE_Valid(e) {
SetActiveField(Ctrl('HZHPBOOXGE'),false);
e=(Ne(e,null)?e:window.event);
return Set_agenzia(HtW(Ctrl('HZHPBOOXGE').value,'C'),null,e);
}
function HZHPBOOXGE_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('HZHPBOOXGE'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('HZHPBOOXGE'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('HZHPBOOXGE'),e);
}
function HZHPBOOXGE_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('HZHPBOOXGE')),'linkview_HZHPBOOXGE','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function href_WQOTPOFGXX() {
var l_oWv = InitWvApplet();
l_oWv.setValue('pTipo',AsAppletValue('P'));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('pTipo'));
SetLocationHref(null,'arrt_cgo_operazioni_xls'+'?m_cWv='+URLenc(l_oWv.asString())+'&m_cAction=start&m_cAtExit=close&m_cMode=hyperlink','elabgen')
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
if(c=Ctrl('HZHPBOOXGE')) c.onblur=HZHPBOOXGE_Valid;
if(c=Ctrl('HZHPBOOXGE')) c.onfocus=HZHPBOOXGE_OnFocus;
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
FocusFirstComponent.otherwise={"page_1":["HZHPBOOXGE"]};
function Help() {
windowOpenForeground('../doc/arpg_cgo_operazioni_vnp_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_agenzia=a[0];
w_xagenzia=a[1];
w_xdesage=a[2];
w_coddip=a[3];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_cgo_operazioni_vnp',m_cSelectedPage);
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
function Set_agenzia(ctrlValue,kmode,e) {
if (Ne(w_agenzia,ctrlValue)) {
var ctl = _GetCtl(e,'HZHPBOOXGE');
if (_tracker.goon(ctl,ctrlValue)) {
w_agenzia=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HZHPBOOXGE',0);
if (l_bResult) {
l_bResult=Link_HZHPBOOXGE(kmode);
if ( ! (l_bResult)) {
w_agenzia=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',6,0,''));
} else {
_ResetTracker();
}
return l_bResult;
} else {
ctl.value=WtH('','C',6,0,'');
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
function Link_HZHPBOOXGE(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_agenzia);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODDIP',w_agenzia,6,0);
l_Appl.SetFields('CODDIP,DESCRIZ,IDBASE');
l_Appl.SetTypes('C,C,C');
l_Appl.LinkTable('anadip');
l_Appl.SetID('HZHPBOOXGE');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_agenzia=l_Appl.GetStringValue('CODDIP',6,0);
w_xdesage=l_Appl.GetStringValue('DESCRIZ',30,0);
w_xagenzia=l_Appl.GetStringValue('IDBASE',10,0);
} else {
Link_HZHPBOOXGE_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_HZHPBOOXGE';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_HZHPBOOXGE();
l_oWv.setValue('FieldFilter',l_cFieldFilter);
if ( ! (Empty(l_Appl.GetWhereAddedFixedFiltersUnencoded()))) {
if ( ! (Empty(l_cFixedFilter))) {
l_cFixedFilter=l_cFixedFilter+' and ';
}
l_cFixedFilter=l_cFixedFilter+l_Appl.GetWhereAddedFixedFiltersUnencoded();
}
l_oWv.setValue('FixedFilter',l_cFixedFilter);
var l_cFixedFilterURL = '';
l_oWv.setValue('FixedFilterURL',l_cFixedFilterURL+'m_cMode=hyperlink&m_cParameterSequence=');
var initEntityFields = '';
l_cLinkUrl='../servlet/SPVisualZoom'+'?m_cWv='+URLenc(l_oWv.asString());
layerOpenForeground(l_cLinkUrl,openername,'toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes');
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
function Link_HZHPBOOXGE_Blank() {
w_agenzia='';
w_xdesage='';
w_xagenzia='';
}
function LOpt_HZHPBOOXGE() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('anadip','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODDIP','C'));
l_oWv.setValue('LinkedField',WtA('CODDIP','C'));
l_oWv.setValue('UID',WtA('HZHPBOOXGE','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['HZHPBOOXGE'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('1813072817'),'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'HZHPBOOXGE')) {
last_focused_comp=GetLastFocusedElementOfLink('HZHPBOOXGE');
function SetMethod_HZHPBOOXGE() {
Set_agenzia(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_HZHPBOOXGE();
} else {
setTimeout(SetMethod_HZHPBOOXGE,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'HZHPBOOXGE')) {
return [Ctrl('HZHPBOOXGE')];
}
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
if ( ! (_ChkObl('HZHPBOOXGE',1))) {
_SignErr('HZHPBOOXGE');
m_cLastWorkVarErrorMsg='1745963953';
l_bResult=false;
w_agenzia=HtW('','C');
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('HZHPBOOXGE_ZOOM',lc)) {
return 0;
}
if (Eq('HZHPBOOXGE',lc)) {
return 0;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_HZHPBOOXGE();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cFixedFilterURL = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
}
function FillWv() {
var l_oWv = InitWvApplet();
l_oWv.setValue('agenzia',WtA(w_agenzia,'C'));
l_oWv.setValue('xagenzia',WtA(w_xagenzia,'C'));
l_oWv.setValue('xdesage',WtA(w_xdesage,'C'));
l_oWv.setValue('coddip',WtA(w_coddip,'C'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["agenzia","xagenzia","xdesage","coddip"];
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
if (Empty(w_agenzia) && Ne(opener.w_agenzia,null)) {
TransferBetweenWindows(opener,'w_agenzia',null,'Set_agenzia');
}
}
}
m_bCalculating=true;
Link_HZHPBOOXGE(null);
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
  this.c_CODDIPE = arguments[7]
  this.c_DESCRIZ = arguments[8]
  this.c_IDBASE = arguments[9]
  this.c_RAGSOC = arguments[10]
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
c_CODDIPE=row.c_CODDIPE;
c_DESCRIZ=row.c_DESCRIZ;
c_IDBASE=row.c_IDBASE;
c_RAGSOC=row.c_RAGSOC;
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
row.c_CODDIPE=c_CODDIPE;
row.c_DESCRIZ=c_DESCRIZ;
row.c_IDBASE=c_IDBASE;
row.c_RAGSOC=c_RAGSOC;
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
c_CODDIPE='';
c_DESCRIZ='';
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
var l_RMODFGAYVQ = false;
var l_old_RMODFGAYVQ = l_RMODFGAYVQ;
Body_BeginHtml(49,'',0,'A','');
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
GroupFooter_BeginHtml(document,1,'10713341355'+l_nIdx+'','A',true,false)
GroupFooter_EndHtml(document,1,'10713341355'+l_nIdx+'','A')
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
GroupHeader_BeginHtml(document,1,'10713341353'+l_nIdx+'','A',true,false)
document.writeln(
 "<div id='DIV_0B974B28"+l_nIdx+"' style='position:relative;height:17px'>" +
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
GroupHeader_EndHtml(document,1,'10713341353'+l_nIdx+'','A')
} else {
}
Row_BeginHtml(document,l_nEvenOdd,'10713355423'+l_nIdx+'','A',true,-1)
document.writeln(
 "<div id='DIV_0B9549C8"+l_nIdx+"' style='position:relative;height:19px'>" +
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
Row_EndHtml(document,l_nEvenOdd,'10713355423'+l_nIdx+'','A')
Parms.Idx=l_nIdx;
Parms.Deep=l_nDeep;
Parms.EvenOdd=l_nEvenOdd;
}
Parms=new Object();
_Obli('agenzia',0,'HZHPBOOXGE',false,"1745963953")
