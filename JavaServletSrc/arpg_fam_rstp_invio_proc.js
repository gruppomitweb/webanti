function SetControlsValue() {
var c;
var c;
var tmp_TYIWXFLLFY = ToHTag(AsControlValue('<iframe width=\'750\' height=\'400\' id=\'elaborazione\'  name=\'elaborazione\' frameborder=\'1\'  border=\'1\' align=\'TOP\' marginwidth=\'1\' marginheight=\'1\'></iframe>'));
if (Ne(e_TYIWXFLLFY,tmp_TYIWXFLLFY)) {
if(c=Ctrl('TYIWXFLLFY')) c.innerHTML=tmp_TYIWXFLLFY;
e_TYIWXFLLFY=tmp_TYIWXFLLFY;
}
if(c=Ctrl('OSIUJJNLKT')) ChkboxCheckUncheck(c,'S',w_flgdett)
if(c=Ctrl('OSIUJJNLKT')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('SCGTJGESFA')) c.value = WtH(w_stpinvio,'C',10,0,'')
if(c=Ctrl('QKUOXERDJK')) c.value = WtH(w_xtipinvio,'C',1,0,'')
if(c=Ctrl('OWYNJWKXZA')) c.value = WtH(w_xdatinvio,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('JISCOQMHYV')) c.value = WtH(w_xtpcinvio,'C',1,0,'')
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
HideUI();
}
HideUI.lblids["stpinvio"]=['YIXZTOKOBR'];
HideUI.lblids["xdatinvio"]=['JVVRQWIIHF'];
HideUI.lblids["xtipinvio"]=['WPSKYXARLO'];
HideUI.lblids["xtpcinvio"]=['WZBNOLRUGW'];
function href_XURLGQZZMU() {
SetLocationHref(null,'arrt_fam_rstp_invio'+'?m_cAction=start&m_cMode=hyperlink','elaborazione')
}
function href_PTXYMSWBZO() {
SetLocationHref(window.location,ToResource('jsp/start_page_logo_portlet.jsp'+'')+'')
}
function OSIUJJNLKT_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_flgdett(ChkboxValueAssign(Ctrl('OSIUJJNLKT'),'S','N','C',1,0,''),null,e);
}
function OSIUJJNLKT_OnFocus(e) {
SetActiveField(Ctrl('OSIUJJNLKT'),true);
}
function OSIUJJNLKT_OnBlur(e) {
SetActiveField(Ctrl('OSIUJJNLKT'),false);
}
function SCGTJGESFA_Valid(e) {
SetActiveField(Ctrl('SCGTJGESFA'),false);
e=(Ne(e,null)?e:window.event);
return Set_stpinvio(HtW(Ctrl('SCGTJGESFA').value,'C'),null,e);
}
function SCGTJGESFA_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('SCGTJGESFA'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('SCGTJGESFA'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('SCGTJGESFA'),e);
}
function SCGTJGESFA_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('SCGTJGESFA')),'linkview_SCGTJGESFA','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
if(c=Ctrl('OSIUJJNLKT')) c.onclick=OSIUJJNLKT_Valid;
if(c=Ctrl('OSIUJJNLKT')) c.onfocus=OSIUJJNLKT_OnFocus;
if(c=Ctrl('OSIUJJNLKT')) c.onblur=OSIUJJNLKT_OnBlur;
if(c=Ctrl('SCGTJGESFA')) c.onblur=SCGTJGESFA_Valid;
if(c=Ctrl('SCGTJGESFA')) c.onfocus=SCGTJGESFA_OnFocus;
}
}
function NotifyEvent(p_cEvent) {
var old_c;
if (Ne(typeof(w_Messaggi),'undefined')) {
w_Messaggi.raiseEvent('arpg_fam_rstp_invio_'+Strtran(p_cEvent,' ','_'));
}
if (Ne(typeof(w_Log),'undefined')) {
w_Log.raiseEvent('arpg_fam_rstp_invio_'+Strtran(p_cEvent,' ','_'));
}
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
FocusFirstComponent.otherwise={"page_1":["OSIUJJNLKT"]};
function Help() {
windowOpenForeground('../doc/arpg_fam_rstp_invio_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_flgdett=a[0];
w_stpinvio=a[1];
w_xtipinvio=a[2];
w_xdatinvio=a[3];
w_xtpcinvio=a[4];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_fam_rstp_invio',m_cSelectedPage);
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
function Set_flgdett(ctrlValue,kmode,e) {
if (Ne(w_flgdett,ctrlValue)) {
var ctl = _GetCtl(e,'OSIUJJNLKT');
if (_tracker.goon(ctl,ctrlValue)) {
w_flgdett=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('OSIUJJNLKT',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_stpinvio(ctrlValue,kmode,e) {
if (Ne(w_stpinvio,ctrlValue)) {
var ctl = _GetCtl(e,'SCGTJGESFA');
if (_tracker.goon(ctl,ctrlValue)) {
w_stpinvio=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SCGTJGESFA',0);
if (l_bResult) {
l_bResult=Link_SCGTJGESFA(kmode);
if ( ! (l_bResult)) {
w_stpinvio=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',10,0,''));
} else {
_ResetTracker();
}
return l_bResult;
} else {
ctl.value=WtH('','C',10,0,'');
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
function Link_SCGTJGESFA(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_stpinvio);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODINVIO',w_stpinvio,10,0);
l_Appl.SetFields('CODINVIO,TIPINVIO,TPCINVIO,DATINVIO');
l_Appl.SetTypes('C,C,C,D');
l_Appl.LinkTable('sid_invio');
l_Appl.SetID('SCGTJGESFA');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_stpinvio=l_Appl.GetStringValue('CODINVIO',10,0);
w_xtipinvio=l_Appl.GetStringValue('TIPINVIO',1,0);
w_xtpcinvio=l_Appl.GetStringValue('TPCINVIO',1,0);
w_xdatinvio=l_Appl.GetDateValue('DATINVIO',8,0);
w_xdatinvio=DateFromApplet(w_xdatinvio);
} else {
Link_SCGTJGESFA_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_SCGTJGESFA';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
l_cFieldFilter=l_cFieldFilter+l_cAndOpForField+_flt_('TPCINVIO','5',null,true,'<=');
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_SCGTJGESFA();
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
function Link_SCGTJGESFA_Blank() {
w_stpinvio='';
w_xtipinvio='';
w_xtpcinvio='';
w_xdatinvio=NullDate();
}
function LOpt_SCGTJGESFA() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('sid_invio','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODINVIO','C'));
l_oWv.setValue('LinkedField',WtA('CODINVIO','C'));
l_oWv.setValue('UID',WtA('SCGTJGESFA','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['SCGTJGESFA'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('10759313073'),'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'SCGTJGESFA')) {
last_focused_comp=GetLastFocusedElementOfLink('SCGTJGESFA');
function SetMethod_SCGTJGESFA() {
Set_stpinvio(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_SCGTJGESFA();
} else {
setTimeout(SetMethod_SCGTJGESFA,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'SCGTJGESFA')) {
return [Ctrl('SCGTJGESFA')];
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
if ( ! (_ChkObl('OSIUJJNLKT',1))) {
_SignErr('OSIUJJNLKT');
m_cLastWorkVarErrorMsg='flgdett';
l_bResult=false;
w_flgdett='N';
} else if ( ! (_ChkObl('SCGTJGESFA',1))) {
_SignErr('SCGTJGESFA');
m_cLastWorkVarErrorMsg='stpinvio';
l_bResult=false;
w_stpinvio=HtW('','C');
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('SCGTJGESFA_ZOOM',lc)) {
return 0;
}
if (Eq('SCGTJGESFA',lc)) {
return 0;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_SCGTJGESFA();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
l_cFieldFilter=l_cFieldFilter+l_cAndOpForField+_flt_('TPCINVIO','5',null,true,'<=');
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
l_oWv.setValue('flgdett',WtA(w_flgdett,'C'));
l_oWv.setValue('stpinvio',WtA(w_stpinvio,'C'));
l_oWv.setValue('xtipinvio',WtA(w_xtipinvio,'C'));
l_oWv.setValue('xdatinvio',WtA(w_xdatinvio,'D'));
l_oWv.setValue('xtpcinvio',WtA(w_xtpcinvio,'C'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["flgdett","stpinvio","xtipinvio","xdatinvio","xtpcinvio"];
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
if (start && Eq(At(',flgdett,',pseq),0)) {
w_flgdett='N';
}
Link_SCGTJGESFA(null);
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
_Obli('flgdett',0,'OSIUJJNLKT',false)
_Obli('stpinvio',0,'SCGTJGESFA',false)
