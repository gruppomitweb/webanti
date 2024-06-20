function SetControlsValue() {
var c;
var c;
if (Gt(m_nRows,0) && Lt(m_nCurrentRow,m_oTrsFW.length)) {
if (Ne(Ctrl('QRASWBZUOO_'+m_nCurrentRow),null)) {
var tmp_QRASWBZUOO = ToHTag(AsControlValue(w_xdescri));
if (Ne(e_QRASWBZUOO,tmp_QRASWBZUOO)) {
if(c=Ctrl('QRASWBZUOO_'+m_nCurrentRow)) c.innerHTML=tmp_QRASWBZUOO;
e_QRASWBZUOO=tmp_QRASWBZUOO;
}
}
if (Ne(Ctrl('ORJCJRTXVX_'+m_nCurrentRow),null)) {
if(c=Ctrl('ORJCJRTXVX_'+m_nCurrentRow)) c.value = WtH(w_SIGLA,'C',4,0,'')
}
}
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
if (Gt(m_nRows,0)) {
SetDisplay(Ctrl('RMSJCHUBAZ'),true);
}
HideUI();
}
function href_NACPPABTRW() {
SetLocationHref(window.location,ToResource('jsp/start_page_logo_portlet.jsp'+'')+'')
}
function href_MAYNQUHJSS() {
SetHypPar('m_cAction',AsAppletValue('start'));
SetHypPar('m_cMode',AsAppletValue('hyperlink'));
SetHypPar('m_cAtExit',AsAppletValue(close));
SetHypPar('m_cID',AsAppletValue(m_IDS['arrt_agg_deccitta']));
SendData('start','arrt_agg_deccitta'+'',HParApplet().asString());
}
function ORJCJRTXVX_Valid(e) {
SetActiveField(Ctrl('ORJCJRTXVX_'+m_nCurrentRow),false);
e=(Ne(e,null)?e:window.event);
return Set_SIGLA(HtW(Ctrl('ORJCJRTXVX_'+m_nCurrentRow).value,'C'),null,e);
}
function ORJCJRTXVX_OnFocus(e) {
var org;
org=GetEventSrcElement(e);
ChangeRow(Val(Right(org.name,Len(org.name)-RAt('_',org.name))));
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ORJCJRTXVX'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('ORJCJRTXVX_'+m_nCurrentRow),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ORJCJRTXVX_'+m_nCurrentRow),e);
}
function ORJCJRTXVX_ZOOM_Click(p_nRow) {
ChangeRow(p_nRow);
last_focused_comp=GetLastFocusedElementOfLink('ORJCJRTXVX');
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('ORJCJRTXVX')),'linkview_ORJCJRTXVX','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function href_SNAIRPLJWK() {
Update()
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
if(c=Ctrl('ORJCJRTXVX_'+m_nCurrentRow)) c.onblur=ORJCJRTXVX_Valid;
if(c=Ctrl('ORJCJRTXVX_'+m_nCurrentRow)) c.onfocus=ORJCJRTXVX_OnFocus;
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
function DoFieldsUpdate(p_bResult) {
m_bFieldsUpdated=true;
DoUpdate(p_bResult);
}
FocusFirstComponent.otherwise={"page_1":["ORJCJRTXVX_'+m_nCurrentRow+'"]};
function Help() {
windowOpenForeground('../doc/arpg_agg_deccitta_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_SIGLA=a[0];
w_IDTBLS=a[1];
w_xdescri=a[2];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_agg_deccitta',m_cSelectedPage);
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
function Update() {
var l_bUpdate;
var l_nRow;
l_nRow=0;
l_bUpdate=true;
if (m_bFieldsUpdated) {
while (l_bUpdate && Lt(m_nCurrentRow,m_nRows)) {
ChangeRow(l_nRow);
l_bUpdate=l_bUpdate && Eq(m_nCurrentRow,l_nRow);
l_nRow=l_nRow+1;
}
}
if (l_bUpdate) {
FillFrmTrs('SIGLA','IDTBLS');
SubmitForm('save');
}
}
function Set_SIGLA(ctrlValue,kmode,e) {
if (Ne(w_SIGLA,ctrlValue)) {
var ctl = _GetCtl(e,'ORJCJRTXVX_'+m_nCurrentRow+'');
if (_tracker.goon(ctl,ctrlValue)) {
w_SIGLA=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ORJCJRTXVX',0);
if (l_bResult) {
l_bResult=Link_ORJCJRTXVX(kmode);
if ( ! (l_bResult)) {
w_SIGLA=HtW('','C');
}
}
DoFieldsUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',4,0,''));
} else {
_ResetTracker();
}
return l_bResult;
} else {
ctl.value=WtH('','C',4,0,'');
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
w_IDTBLS=(Empty(w_SIGLA)?'N':'S');
// * --- Area Manuale = UI - Calculate
// * --- Fine Area Manuale
m_bCalculating=false;
}
function SaveDependsOn() {
}
function SaveLabelDependsOn() {
}
function Link_ORJCJRTXVX(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_SIGLA);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('SIGLA',w_SIGLA,4,0);
l_Appl.SetFields('SIGLA,CITTA');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbcitta');
l_Appl.SetID('ORJCJRTXVX');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_SIGLA=l_Appl.GetStringValue('SIGLA',4,0);
w_xdescri=l_Appl.GetStringValue('CITTA',40,0);
} else {
Link_ORJCJRTXVX_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_ORJCJRTXVX';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_ORJCJRTXVX();
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
function Link_ORJCJRTXVX_Blank() {
w_SIGLA='';
w_xdescri='';
}
function LOpt_ORJCJRTXVX() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbcitta','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('SIGLA','C'));
l_oWv.setValue('LinkedField',WtA('SIGLA','C'));
l_oWv.setValue('UID',WtA('ORJCJRTXVX','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['ORJCJRTXVX'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('15186643'),'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'ORJCJRTXVX')) {
last_focused_comp=GetLastFocusedElementOfLink('ORJCJRTXVX');
function SetMethod_ORJCJRTXVX() {
Set_SIGLA(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_ORJCJRTXVX();
} else {
setTimeout(SetMethod_ORJCJRTXVX,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'ORJCJRTXVX')) {
return [Ctrl('ORJCJRTXVX_'+m_nCurrentRow)];
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
if ( ! (_ChkObl('ORJCJRTXVX',1))) {
_SignErr('ORJCJRTXVX_'+m_nCurrentRow+'');
m_cLastWorkVarErrorMsg='6827491';
l_bResult=false;
w_SIGLA=HtW('','C');
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('ORJCJRTXVX_ZOOM',lc)) {
return 0;
}
if (Eq('ORJCJRTXVX',lc)) {
return 0;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_ORJCJRTXVX();
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
l_oWv.setValue('SIGLA',WtA(w_SIGLA,'C'));
l_oWv.setValue('IDTBLS',WtA(w_IDTBLS,'C'));
l_oWv.setValue('xdescri',WtA(w_xdescri,'C'));
_FillChildren(l_oWv);
l_oWv.setValue('m_oTrs',TrsApplet().asString());
}
_FillChildren.n=[];
FillWv.n=["SIGLA","IDTBLS","xdescri"];
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
  this.w_SIGLA = arguments[0]
  this.t_SIGLA = arguments[1]
  this.k_SIGLA_ID = arguments[2]
  this.w_xdescri = arguments[3]
  this.w_IDTBLS = arguments[4]
  this.t_IDTBLS = arguments[5]
  this.k_IDTBLS_ID = arguments[6]
  this.m_nRowStatus = arguments[7]
}
function TrsQueryRow() {
  this.c_ID = arguments[0]
  this.c_IDBASE = arguments[1]
  this.c_CITTAMIT = arguments[2]
  this.c_CAB = arguments[3]
  this.c_PROV = arguments[4]
  this.c_CAPMIT = arguments[5]
  this.c_PKTBSTATI = arguments[6]
  this.c_SIGLA = arguments[7]
  this.c_PREF = arguments[8]
  this.c_IDTBLS = arguments[9]
  this.c_CITTA = arguments[10]
  this.c_PR = arguments[11]
  this.c_CATASTALE = arguments[12]
  this.c_CAP = arguments[13]
  this.c_REGIONE = arguments[14]
}
function TrsToWork() {
var row;
if (Lt(m_nCurrentRow,m_oTrsFW.length)) {
row=m_oTrsFW[m_nCurrentRow];
w_SIGLA=row.w_SIGLA;
w_xdescri=row.w_xdescri;
w_IDTBLS=row.w_IDTBLS;
m_nRowStatus=row.m_nRowStatus;
}
if (Lt(m_nCurrentRow,m_oTrsQuery.length)) {
row=m_oTrsQuery[m_nCurrentRow];
c_ID=row.c_ID;
c_IDBASE=row.c_IDBASE;
c_CITTAMIT=row.c_CITTAMIT;
c_CAB=row.c_CAB;
c_PROV=row.c_PROV;
c_CAPMIT=row.c_CAPMIT;
c_PKTBSTATI=row.c_PKTBSTATI;
c_SIGLA=row.c_SIGLA;
c_PREF=row.c_PREF;
c_IDTBLS=row.c_IDTBLS;
c_CITTA=row.c_CITTA;
c_PR=row.c_PR;
c_CATASTALE=row.c_CATASTALE;
c_CAP=row.c_CAP;
c_REGIONE=row.c_REGIONE;
}
}
function WorkToTrs() {
var row;
if (Lt(m_nCurrentRow,m_oTrsFW.length)) {
row=m_oTrsFW[m_nCurrentRow];
row.w_SIGLA=w_SIGLA;
row.w_xdescri=w_xdescri;
row.w_IDTBLS=w_IDTBLS;
row.m_nRowStatus=m_nRowStatus;
}
if (Lt(m_nCurrentRow,m_oTrsQuery.length)) {
row=m_oTrsQuery[m_nCurrentRow];
row.c_ID=c_ID;
row.c_IDBASE=c_IDBASE;
row.c_CITTAMIT=c_CITTAMIT;
row.c_CAB=c_CAB;
row.c_PROV=c_PROV;
row.c_CAPMIT=c_CAPMIT;
row.c_PKTBSTATI=c_PKTBSTATI;
row.c_SIGLA=c_SIGLA;
row.c_PREF=c_PREF;
row.c_IDTBLS=c_IDTBLS;
row.c_CITTA=c_CITTA;
row.c_PR=c_PR;
row.c_CATASTALE=c_CATASTALE;
row.c_CAP=c_CAP;
row.c_REGIONE=c_REGIONE;
}
}
function BlankQueryFields() {
c_ID=0;
c_IDBASE='';
c_CITTAMIT='';
c_CAB='';
c_PROV='';
c_CAPMIT='';
c_PKTBSTATI='';
c_SIGLA='';
c_PREF='';
c_IDTBLS='';
c_CITTA='';
c_PR='';
c_CATASTALE='';
c_CAP='';
c_REGIONE='';
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
var l_nStartRow = Val(document.FSender.StartRow.value);
var l_nPos = 0;
var l_UZOWLYUBEB = false;
var l_old_UZOWLYUBEB = l_UZOWLYUBEB;
Body_BeginHtml(54,'',0,'A','');
BlankQueryFields();
while ( ! (l_bEof)) {
l_oQuery=m_oTrsQuery[l_nIdx];
l_oFields=m_oTrsFW[l_nIdx];
l_nDeep=0;
if (Lt(l_nIdx,m_nRows)) {
m_nCurrentRow=l_nIdx;
TrsToWork();
l_UZOWLYUBEB=true;
if (Eq(l_nIdx,0)) {
l_nDeep=1;
} else {
if (Ne(l_old_UZOWLYUBEB,l_UZOWLYUBEB)) {
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
GroupFooter_BeginHtml(document,1,'11733902479'+l_nIdx+'','A',true,false)
GroupFooter_EndHtml(document,1,'11733902479'+l_nIdx+'','A')
} else {
}
l_nIdx=l_nIdx+1;
m_nCurrentRow=l_nIdx;
TrsToWork();
l_old_UZOWLYUBEB = l_UZOWLYUBEB;
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
if (Gt(m_nRows,0) || Lt(l_nIdx,m_nRows)) {
Update_Button("RMSJCHUBAZ",Translate("113933141"),"","","","CLASS=FormDefault STYLE='display:"+(true?'none':'inline')+"'","")
}
Body_EndHtml('A');
}
function DrawLine(document) {
l_nIdx=Parms.Idx;
l_nDeep=Parms.Deep;
l_nEvenOdd=Parms.EvenOdd;
if (Ge(2,l_nDeep)) {
GroupHeader_BeginHtml(document,1,'11733901967'+l_nIdx+'','A',true,false)
document.writeln(
 "<div id='DIV_0BAA56A8"+l_nIdx+"' style='position:relative;height:19px'>" +
"")
document.writeln(
 "<span class=' SPLabel IQYYDDXNDA_DIV'>" +
 "<label class='IQYYDDXNDA'>" +
 ""+ToHTag(Translate("1161"))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel FGTFINFTHC_DIV'>" +
 "<label class='FGTFINFTHC'>" +
 ""+ToHTag(Translate("285808099"))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel MQDXWDEJHJ_DIV'>" +
 "<label class='MQDXWDEJHJ'>" +
 ""+ToHTag(Translate("27906055"))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "</div>" +
"")
GroupHeader_EndHtml(document,1,'11733901967'+l_nIdx+'','A')
} else {
}
Row_BeginHtml(document,l_nEvenOdd,'11737503887'+l_nIdx+'','A',true,-1)
document.writeln(
 "<div id='DIV_0B975350"+l_nIdx+"' style='position:relative;height:22px'>" +
"")
document.writeln(
 "<input name='SIGLA_"+l_nIdx+"' id='ORJCJRTXVX_"+l_nIdx+"' type='text' class='ORJCJRTXVX Field' value="+ToHTMLValue(WtH(w_SIGLA,"C",4,0,''))+" curTabIndex='0' maxlength='4' size='4' fieldtype='C'>" +
 "<button id='ORJCJRTXVX_ZOOM_"+l_nIdx+"' type='button' class='ORJCJRTXVX_ZOOM SPButton' style='background-image:url(../"+m_cThemePath+"/formPage/zoom_"+"enabled"+".gif)' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick=ORJCJRTXVX_ZOOM_Click("+l_nIdx+")>" +
 "</button>" +
"")
document.writeln(
 "<span class=' SPLabel MKFRZAVIJB_DIV'>" +
 "<label class='MKFRZAVIJB'>" +
 ""+ToHTag(WtH(c_ID,'N',10,0,''))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel AWWOYCZYAB_DIV'>" +
 "<label class='AWWOYCZYAB'>" +
 ""+ToHTag(WtH(c_CITTA,'C',80,0,''))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel QRASWBZUOO_DIV'>" +
 "<label id='QRASWBZUOO_"+l_nIdx+"' class='QRASWBZUOO'>" +
 ""+ToHTag(w_xdescri)+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "</div>" +
"")
Row_EndHtml(document,l_nEvenOdd,'11737503887'+l_nIdx+'','A')
Parms.Idx=l_nIdx;
Parms.Deep=l_nDeep;
Parms.EvenOdd=l_nEvenOdd;
}
Parms=new Object();
_Obli('SIGLA',0,'ORJCJRTXVX',false,"6827491")
