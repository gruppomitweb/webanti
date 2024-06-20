function SetControlsValue() {
var c;
var c;
if(c=Ctrl('ZMUINJOHPC')) c.value = WtH(w_WUCODMAGE,'C',5,0,'')
var tmp_EVCHASKFZJ = ToHTag(AsControlValue(w_xMADESCRI));
if (Ne(e_EVCHASKFZJ,tmp_EVCHASKFZJ)) {
if(c=Ctrl('EVCHASKFZJ')) c.innerHTML=tmp_EVCHASKFZJ;
e_EVCHASKFZJ=tmp_EVCHASKFZJ;
}
if(c=Ctrl('CAPXTPHATP')) c.value = WtH(w_codrap,'C',16,0,'')
var tmp_YPCWEWTNLH = ToHTag(AsControlValue(w_xDESCRAP));
if (Ne(e_YPCWEWTNLH,tmp_YPCWEWTNLH)) {
if(c=Ctrl('YPCWEWTNLH')) c.innerHTML=tmp_YPCWEWTNLH;
e_YPCWEWTNLH=tmp_YPCWEWTNLH;
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
HideUI.lblids["codrap"]=['DRORRLOSWI'];
function href_PTXYMSWBZO() {
SetLocationHref(window.location,ToResource('jsp/start_page_logo_portlet.jsp'+'')+'')
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
function href_VQTEFRCJTE() {
var l_oWv = InitWvApplet();
l_oWv.setValue('ReportName',AsAppletValue('arrp_wu_stp_rapporti'));
l_oWv.setValue('outputFormat',AsAppletValue('PDF'));
l_oWv.setValue('w_WUCODMAGE',AsAppletValue(w_WUCODMAGE));
l_oWv.setValue('w_xMADESCRI',AsAppletValue(w_xMADESCRI));
l_oWv.setValue('w_codrap',AsAppletValue(w_codrap));
l_oWv.setValue('w_descazi',AsAppletValue(w_gDescAzi));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('ReportName,outputFormat,w_WUCODMAGE,w_xMADESCRI,w_codrap,w_descazi'));
_modifyandopen('Report'+'?m_cWv='+URLenc(l_oWv.asString())+'&m_cAction=start&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes,height=500,width=700',null)
}
function href_TPEEIKJTDF() {
_modifyandopen('arrt_wu_stp_rapporti'+'?m_cAction=start&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes,height=500,width=700',null)
}
function CAPXTPHATP_Valid(e) {
SetActiveField(Ctrl('CAPXTPHATP'),false);
e=(Ne(e,null)?e:window.event);
return Set_codrap(HtW(Ctrl('CAPXTPHATP').value,'C'),null,e);
}
function CAPXTPHATP_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('CAPXTPHATP'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('CAPXTPHATP'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('CAPXTPHATP'),e);
}
function CAPXTPHATP_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('CAPXTPHATP')),'linkview_CAPXTPHATP','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
if(c=Ctrl('ZMUINJOHPC')) c.onblur=ZMUINJOHPC_Valid;
if(c=Ctrl('ZMUINJOHPC')) c.onfocus=ZMUINJOHPC_OnFocus;
if(c=Ctrl('CAPXTPHATP')) c.onblur=CAPXTPHATP_Valid;
if(c=Ctrl('CAPXTPHATP')) c.onfocus=CAPXTPHATP_OnFocus;
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
windowOpenForeground('../doc/arpg_wu_stp_rapporti_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_codrap=a[2];
w_xDESCRAP=a[3];
w_gDescAzi=a[4];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_wu_stp_rapporti',m_cSelectedPage);
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
function Set_codrap(ctrlValue,kmode,e) {
if (Ne(w_codrap,ctrlValue)) {
var ctl = _GetCtl(e,'CAPXTPHATP');
if (_tracker.goon(ctl,ctrlValue)) {
w_codrap=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CAPXTPHATP',0);
if (l_bResult) {
l_bResult=Link_CAPXTPHATP(kmode);
if ( ! (l_bResult)) {
w_codrap=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',16,0,''));
} else {
_ResetTracker();
}
return l_bResult;
} else {
ctl.value=WtH('','C',16,0,'');
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
function Link_CAPXTPHATP(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_codrap);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('RAPPORTO',w_codrap,16,0);
l_Appl.SetFields('RAPPORTO,DESCRAP');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('anarapbo');
l_Appl.SetLinkzoom('armt_anarap');
l_Appl.SetID('CAPXTPHATP');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_codrap=l_Appl.GetStringValue('RAPPORTO',16,0);
w_xDESCRAP=l_Appl.GetStringValue('DESCRAP',50,0);
} else {
Link_CAPXTPHATP_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_CAPXTPHATP';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
l_cFieldFilter=l_cFieldFilter+l_cAndOpForField+_flt_('MACODICE',w_WUCODMAGE,null,true,'=');
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_CAPXTPHATP();
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
function Link_CAPXTPHATP_Blank() {
w_codrap='';
w_xDESCRAP='';
}
function LOpt_CAPXTPHATP() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('anarapbo','C'));
l_oWv.setValue('Linkzoomprg',WtA('armt_anarap','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('RAPPORTO','C'));
l_oWv.setValue('LinkedField',WtA('RAPPORTO','C'));
l_oWv.setValue('UID',WtA('CAPXTPHATP','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['CAPXTPHATP'][1],'C'));
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
if (Eq(varName,'CAPXTPHATP')) {
last_focused_comp=GetLastFocusedElementOfLink('CAPXTPHATP');
function SetMethod_CAPXTPHATP() {
Set_codrap(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_CAPXTPHATP();
} else {
setTimeout(SetMethod_CAPXTPHATP,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'ZMUINJOHPC')) {
return [Ctrl('ZMUINJOHPC')];
}
if (Eq(varName,'CAPXTPHATP')) {
return [Ctrl('CAPXTPHATP')];
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
} else if ( ! (_ChkObl('CAPXTPHATP',1))) {
_SignErr('CAPXTPHATP');
m_cLastWorkVarErrorMsg='1805022818';
l_bResult=false;
w_codrap=HtW('','C');
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
if (Eq('CAPXTPHATP_ZOOM',lc)) {
return 1;
}
if (Eq('CAPXTPHATP',lc)) {
return 1;
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
if (Eq(index,1)) {
l_oWv=LOpt_CAPXTPHATP();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
l_cFieldFilter=l_cFieldFilter+l_cAndOpForField+_flt_('MACODICE',w_WUCODMAGE,null,true,'=');
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
l_oWv.setValue('FieldFilter',l_cFieldFilter);
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
}
function FillWv() {
var l_oWv = InitWvApplet();
l_oWv.setValue('WUCODMAGE',WtA(w_WUCODMAGE,'C'));
l_oWv.setValue('xMADESCRI',WtA(w_xMADESCRI,'C'));
l_oWv.setValue('codrap',WtA(w_codrap,'C'));
l_oWv.setValue('xDESCRAP',WtA(w_xDESCRAP,'C'));
l_oWv.setValue('gDescAzi',WtA(w_gDescAzi,'C'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["WUCODMAGE","xMADESCRI","codrap","xDESCRAP","gDescAzi"];
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
Link_CAPXTPHATP(null);
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
_Obli('WUCODMAGE',0,'ZMUINJOHPC',false,"11148783093")
_Obli('codrap',0,'CAPXTPHATP',false,"1805022818")
