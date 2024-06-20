function SetControlsValue() {
var c;
var c;
if(c=Ctrl('ZMUINJOHPC')) c.value = WtH(w_WUCODMAGE,'C',5,0,'')
var tmp_EVCHASKFZJ = ToHTag(AsControlValue(w_xMADESCRI));
if (Ne(e_EVCHASKFZJ,tmp_EVCHASKFZJ)) {
if(c=Ctrl('EVCHASKFZJ')) c.innerHTML=tmp_EVCHASKFZJ;
e_EVCHASKFZJ=tmp_EVCHASKFZJ;
}
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay(Ctrl('VQTEFRCJTE'),Empty(LRTrim(w_WUCODMAGE)));
SetDisplay(Ctrl('TPEEIKJTDF'),Empty(LRTrim(w_WUCODMAGE)));
HideUI();
}
HideUI.lblids["WUCODMAGE"]=['BSHALXKEJY'];
function href_PTXYMSWBZO() {
SetLocationHref(window.location,ToResource('jsp/start_page_logo_portlet.jsp'+'')+'')
}
function href_NHGURTTOXI(p_nRow) {
ChangeRow(p_nRow);
var l_oWv = InitWvApplet();
l_oWv.setValue('WUCODICE',AsAppletValue(c_WUCODICE));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('WUCODICE'));
_modifyandopen('armt_wu_chkerr'+'?m_cWv='+URLenc(l_oWv.asString())+'&m_cAction=edit&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null)
}
function href_YEJAQVVIII(p_nRow) {
ChangeRow(p_nRow);
DelRow()
}
function ZMUINJOHPC_Valid(e) {
SetActiveField(Ctrl('ZMUINJOHPC'),false);
e=(Ne(e,null)?e:window.event);
return Set_WUCODMAGE(HtW(Ctrl('ZMUINJOHPC').value,'C'),null,e);
}
function ZMUINJOHPC_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ZMUINJOHPC'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('ZMUINJOHPC'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ZMUINJOHPC'),e);
}
function ZMUINJOHPC_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('ZMUINJOHPC')),'linkview_ZMUINJOHPC','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function href_XRMOQHPNOL() {
SetHypPar('m_bQuery',AsAppletValue(true));
var action = (Eq(Left('arpg_wu_chkimp'+''+'?',15),'arpg_wu_chkimp?')?'query':'start');
SetHypPar('m_cAction',AsAppletValue(action));
SetHypPar('m_cMode',AsAppletValue('hyperlink'));
SendData(action,'arpg_wu_chkimp'+'',HParApplet().asString());
}
function href_VQTEFRCJTE() {
var l_oWv = InitWvApplet();
l_oWv.setValue('ReportName',AsAppletValue('arrp_wu_chkimp'));
l_oWv.setValue('outputFormat',AsAppletValue('PDF'));
l_oWv.setValue('rotation',AsAppletValue('LANDSCAPE'));
l_oWv.setValue('w_WUCODMAGE',AsAppletValue(w_WUCODMAGE));
l_oWv.setValue('w_xMADESCRI',AsAppletValue(w_xMADESCRI));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('ReportName,outputFormat,rotation,w_WUCODMAGE,w_xMADESCRI'));
_modifyandopen('Report'+'?m_cWv='+URLenc(l_oWv.asString())+'&m_cAction=start&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes,height=500,width=700',null)
}
function href_TPEEIKJTDF() {
var l_oWv = InitWvApplet();
l_oWv.setValue('w_WUCODMAGE',AsAppletValue(w_WUCODMAGE));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('w_WUCODMAGE'));
_modifyandopen('arrt_wu_chkimp'+'?m_cWv='+URLenc(l_oWv.asString())+'&m_cAction=start&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes,height=500,width=700',null)
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
if(c=Ctrl('ZMUINJOHPC')) c.onblur=ZMUINJOHPC_Valid;
if(c=Ctrl('ZMUINJOHPC')) c.onfocus=ZMUINJOHPC_OnFocus;
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
FocusFirstComponent.otherwise={"page_1":["ZMUINJOHPC"]};
function Help() {
windowOpenForeground('../doc/arpg_wu_chkimp_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_WUCODMAGE=a[0];
w_xMADESCRI=a[1];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_wu_chkimp',m_cSelectedPage);
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
function Set_WUCODMAGE(ctrlValue,kmode,e) {
if (Ne(w_WUCODMAGE,ctrlValue)) {
var ctl = _GetCtl(e,'ZMUINJOHPC');
if (_tracker.goon(ctl,ctrlValue)) {
w_WUCODMAGE=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ZMUINJOHPC',0);
if (l_bResult) {
l_bResult=Link_ZMUINJOHPC(kmode);
if ( ! (l_bResult)) {
w_WUCODMAGE=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',5,0,''));
} else {
_ResetTracker();
}
return l_bResult;
} else {
ctl.value=WtH('','C',5,0,'');
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
function Link_ZMUINJOHPC(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_WUCODMAGE);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('MACODICE',w_WUCODMAGE,5,0);
l_Appl.SetFields('MACODICE,MADESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbmacage');
l_Appl.SetID('ZMUINJOHPC');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_WUCODMAGE=l_Appl.GetStringValue('MACODICE',5,0);
w_xMADESCRI=l_Appl.GetStringValue('MADESCRI',60,0);
} else {
Link_ZMUINJOHPC_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_ZMUINJOHPC';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_ZMUINJOHPC();
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
function Link_ZMUINJOHPC_Blank() {
w_WUCODMAGE='';
w_xMADESCRI='';
}
function LOpt_ZMUINJOHPC() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbmacage','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('MACODICE','C'));
l_oWv.setValue('LinkedField',WtA('MACODICE','C'));
l_oWv.setValue('UID',WtA('ZMUINJOHPC','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['ZMUINJOHPC'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('11283615582'),'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'ZMUINJOHPC')) {
last_focused_comp=GetLastFocusedElementOfLink('ZMUINJOHPC');
function SetMethod_ZMUINJOHPC() {
Set_WUCODMAGE(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_ZMUINJOHPC();
} else {
setTimeout(SetMethod_ZMUINJOHPC,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'ZMUINJOHPC')) {
return [Ctrl('ZMUINJOHPC')];
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
if ( ! (_ChkObl('ZMUINJOHPC',1))) {
_SignErr('ZMUINJOHPC');
m_cLastWorkVarErrorMsg='11148783093';
l_bResult=false;
w_WUCODMAGE=HtW('','C');
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('ZMUINJOHPC_ZOOM',lc)) {
return 0;
}
if (Eq('ZMUINJOHPC',lc)) {
return 0;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_ZMUINJOHPC();
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
l_oWv.setValue('WUCODMAGE',WtA(w_WUCODMAGE,'C'));
l_oWv.setValue('xMADESCRI',WtA(w_xMADESCRI,'C'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["WUCODMAGE","xMADESCRI"];
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
if (Empty(w_WUCODMAGE) && Ne(opener.w_WUCODMAGE,null)) {
TransferBetweenWindows(opener,'w_WUCODMAGE',null,'Set_WUCODMAGE');
}
}
}
m_bCalculating=true;
Link_ZMUINJOHPC(null);
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
  this.c_WUCODICE = arguments[0]
  this.c_WUNOMEFILE = arguments[1]
  this.c_WURIFMTCN = arguments[2]
  this.c_WUTIPOPE = arguments[3]
  this.c_WUDATOPE = arguments[4]
  this.c_WUNOMCLI = arguments[5]
  this.c_WUCOGCLI = arguments[6]
  this.c_WUCODMAGE = arguments[7]
  this.c_WUNOTE = arguments[8]
  this.c_WUCODDIP = arguments[9]
  this.c_WUIMPORTO = arguments[10]
  this.c_WUSTADES = arguments[11]
  this.c_WUCITCLI = arguments[12]
  this.c_WUCAPCLI = arguments[13]
  this.c_WUINDCLI = arguments[14]
  this.c_WUNOMCON = arguments[15]
  this.c_WUCOGCON = arguments[16]
  this.c_WUBCITCLI = arguments[17]
  this.c_WUBSTACLI = arguments[18]
  this.c_WUDATNAS = arguments[19]
  this.c_WUSEXCLI = arguments[20]
  this.c_WUCODFIS = arguments[21]
  this.c_WUTDOCCLI = arguments[22]
  this.c_WUNDOCCLI = arguments[23]
  this.c_WUADOCRIL = arguments[24]
  this.c_WURDOCCLI = arguments[25]
  this.c_WUSDOCCLI = arguments[26]
  this.c_WUPROVCLI = arguments[27]
}
function TrsToWork() {
var row;
if (Lt(m_nCurrentRow,m_oTrsQuery.length)) {
row=m_oTrsQuery[m_nCurrentRow];
c_WUCODICE=row.c_WUCODICE;
c_WUNOMEFILE=row.c_WUNOMEFILE;
c_WURIFMTCN=row.c_WURIFMTCN;
c_WUTIPOPE=row.c_WUTIPOPE;
c_WUDATOPE=row.c_WUDATOPE;
c_WUNOMCLI=row.c_WUNOMCLI;
c_WUCOGCLI=row.c_WUCOGCLI;
c_WUCODMAGE=row.c_WUCODMAGE;
c_WUNOTE=row.c_WUNOTE;
c_WUCODDIP=row.c_WUCODDIP;
c_WUIMPORTO=row.c_WUIMPORTO;
c_WUSTADES=row.c_WUSTADES;
c_WUCITCLI=row.c_WUCITCLI;
c_WUCAPCLI=row.c_WUCAPCLI;
c_WUINDCLI=row.c_WUINDCLI;
c_WUNOMCON=row.c_WUNOMCON;
c_WUCOGCON=row.c_WUCOGCON;
c_WUBCITCLI=row.c_WUBCITCLI;
c_WUBSTACLI=row.c_WUBSTACLI;
c_WUDATNAS=row.c_WUDATNAS;
c_WUSEXCLI=row.c_WUSEXCLI;
c_WUCODFIS=row.c_WUCODFIS;
c_WUTDOCCLI=row.c_WUTDOCCLI;
c_WUNDOCCLI=row.c_WUNDOCCLI;
c_WUADOCRIL=row.c_WUADOCRIL;
c_WURDOCCLI=row.c_WURDOCCLI;
c_WUSDOCCLI=row.c_WUSDOCCLI;
c_WUPROVCLI=row.c_WUPROVCLI;
}
}
function WorkToTrs() {
var row;
if (Lt(m_nCurrentRow,m_oTrsQuery.length)) {
row=m_oTrsQuery[m_nCurrentRow];
row.c_WUCODICE=c_WUCODICE;
row.c_WUNOMEFILE=c_WUNOMEFILE;
row.c_WURIFMTCN=c_WURIFMTCN;
row.c_WUTIPOPE=c_WUTIPOPE;
row.c_WUDATOPE=c_WUDATOPE;
row.c_WUNOMCLI=c_WUNOMCLI;
row.c_WUCOGCLI=c_WUCOGCLI;
row.c_WUCODMAGE=c_WUCODMAGE;
row.c_WUNOTE=c_WUNOTE;
row.c_WUCODDIP=c_WUCODDIP;
row.c_WUIMPORTO=c_WUIMPORTO;
row.c_WUSTADES=c_WUSTADES;
row.c_WUCITCLI=c_WUCITCLI;
row.c_WUCAPCLI=c_WUCAPCLI;
row.c_WUINDCLI=c_WUINDCLI;
row.c_WUNOMCON=c_WUNOMCON;
row.c_WUCOGCON=c_WUCOGCON;
row.c_WUBCITCLI=c_WUBCITCLI;
row.c_WUBSTACLI=c_WUBSTACLI;
row.c_WUDATNAS=c_WUDATNAS;
row.c_WUSEXCLI=c_WUSEXCLI;
row.c_WUCODFIS=c_WUCODFIS;
row.c_WUTDOCCLI=c_WUTDOCCLI;
row.c_WUNDOCCLI=c_WUNDOCCLI;
row.c_WUADOCRIL=c_WUADOCRIL;
row.c_WURDOCCLI=c_WURDOCCLI;
row.c_WUSDOCCLI=c_WUSDOCCLI;
row.c_WUPROVCLI=c_WUPROVCLI;
}
}
function BlankQueryFields() {
c_WUCODICE=0;
c_WUNOMEFILE='';
c_WURIFMTCN='';
c_WUTIPOPE='';
c_WUDATOPE='';
c_WUNOMCLI='';
c_WUCOGCLI='';
c_WUCODMAGE='';
c_WUNOTE='';
c_WUCODDIP='';
c_WUIMPORTO=0;
c_WUSTADES='';
c_WUCITCLI='';
c_WUCAPCLI='';
c_WUINDCLI='';
c_WUNOMCON='';
c_WUCOGCON='';
c_WUBCITCLI='';
c_WUBSTACLI='';
c_WUDATNAS='';
c_WUSEXCLI='';
c_WUCODFIS='';
c_WUTDOCCLI='';
c_WUNDOCCLI='';
c_WUADOCRIL='';
c_WURDOCCLI='';
c_WUSDOCCLI='';
c_WUPROVCLI='';
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
var l_GHETNWNJAU = false;
var l_old_GHETNWNJAU = l_GHETNWNJAU;
Body_BeginHtml(49,'',0,'A','');
BlankQueryFields();
while ( ! (l_bEof)) {
l_oQuery=m_oTrsQuery[l_nIdx];
l_nDeep=0;
if (Lt(l_nIdx,m_nRows)) {
m_nCurrentRow=l_nIdx;
TrsToWork();
l_GHETNWNJAU=true;
if (Eq(l_nIdx,0)) {
l_nDeep=1;
} else {
if (Ne(l_old_GHETNWNJAU,l_GHETNWNJAU)) {
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
GroupFooter_BeginHtml(document,1,'860482771'+l_nIdx+'','A',true,false)
GroupFooter_EndHtml(document,1,'860482771'+l_nIdx+'','A')
} else {
}
l_nIdx=l_nIdx+1;
m_nCurrentRow=l_nIdx;
TrsToWork();
l_old_GHETNWNJAU = l_GHETNWNJAU;
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
GroupHeader_BeginHtml(document,1,'1397353683'+l_nIdx+'','A',true,false)
document.writeln(
 "<div id='DIV_0BA600C0"+l_nIdx+"' style='position:relative;height:17px'>" +
"")
document.writeln(
 "<span class=' SPLabel DUPBLSHUFM_DIV'>" +
 "<label class='DUPBLSHUFM'>" +
 ""+ToHTag(Translate("763806883"))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel DSTGVNZIYI_DIV'>" +
 "<label class='DSTGVNZIYI'>" +
 ""+ToHTag(Translate("338061"))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel YTJSXPJGZB_DIV'>" +
 "<label class='YTJSXPJGZB'>" +
 ""+ToHTag(Translate("1823784963"))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel FIOQGROYEQ_DIV'>" +
 "<label class='FIOQGROYEQ'>" +
 ""+ToHTag(Translate("10988377690"))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel NUCIYNQYEN_DIV'>" +
 "<label class='NUCIYNQYEN'>" +
 ""+ToHTag(Translate("10988321226"))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel BIXBOIYTCO_DIV'>" +
 "<label class='BIXBOIYTCO'>" +
 ""+ToHTag(Translate("11148783093"))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "</div>" +
"")
GroupHeader_EndHtml(document,1,'1397353683'+l_nIdx+'','A')
} else {
}
Row_BeginHtml(document,l_nEvenOdd,'10213259932'+l_nIdx+'','A',true,-1)
document.writeln(
 "<div id='DIV_0BAA6620"+l_nIdx+"' style='position:relative;height:18px'>" +
"")
document.writeln(
 "<span class=' SPLabel DIEMSPCIAG_DIV'>" +
 "<label class='DIEMSPCIAG'>" +
 ""+ToHTag(WtH(c_WUNOMEFILE,'C',20,0,''))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel NHGURTTOXI_DIV'>" +
 "<label class='NHGURTTOXI'>" +
 "<a href='javascript:href_NHGURTTOXI("+l_nIdx+")'>" +
 ""+ToHTag(WtH(c_WURIFMTCN,'C',10,0,''))+"" +
 "</a>" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel QGQEMMVIOQ_DIV'>" +
 "<label class='QGQEMMVIOQ'>" +
 ""+ToHTag(WtH(Left(LRTrim(c_WUCOGCLI)+' '+LRTrim(c_WUNOMCLI),50),'C',50,0,''))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel AVTAKZJNQZ_DIV'>" +
 "<label class='AVTAKZJNQZ'>" +
 ""+ToHTag(WtH(c_WUDATOPE,'C',10,0,''))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel GEKWBPVDWX_DIV'>" +
 "<label class='GEKWBPVDWX'>" +
 ""+ToHTag(WtH((Eq(c_WUTIPOPE,'S')?'Send':'Payment'),'C',10,0,''))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel GDSJFXWOQX_DIV'>" +
 "<label class='GDSJFXWOQX'>" +
 ""+ToHTag(WtH(c_WUCODMAGE,'C',5,0,''))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<a href='javascript:href_YEJAQVVIII("+l_nIdx+")' id='YEJAQVVIII_"+l_nIdx+"_HREF'>" +
 "<img id='YEJAQVVIII_"+l_nIdx+"' class='YEJAQVVIII' src="+"'"+ToResource('images/grid_delete.gif')+"'"+" title="+ToHTMLValue(Translate("10034830446"))+" alt="+ToHTMLValue(Translate("10034830446"),"C",0,0)+" onload=SetSectionsHeight('DIV_0BAA6620',"+l_nIdx+")>" +
 "</a>" +
"")
document.writeln(
 "</div>" +
"")
Row_EndHtml(document,l_nEvenOdd,'10213259932'+l_nIdx+'','A')
Parms.Idx=l_nIdx;
Parms.Deep=l_nDeep;
Parms.EvenOdd=l_nEvenOdd;
}
Parms=new Object();
_Obli('WUCODMAGE',0,'ZMUINJOHPC',false,"11148783093")
