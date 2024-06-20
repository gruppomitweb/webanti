function SetControlsValue() {
var c;
var c;
if(c=Ctrl('DPKVLWHCIG')) c.value = WtH(w_DaRapporto,'C',25,0,'')
if(c=Ctrl('MTJDZQTEIR')) c.value = WtH(w_ARapporto,'C',25,0,'')
var tmp_TYIWXFLLFY = ToHTag(AsControlValue('<iframe width=\'750\' height=\'400\' id=\'elaborazione\'  name=\'elaborazione\' frameborder=\'1\'  border=\'1\' align=\'TOP\' marginwidth=\'1\' marginheight=\'1\'></iframe>'));
if (Ne(e_TYIWXFLLFY,tmp_TYIWXFLLFY)) {
if(c=Ctrl('TYIWXFLLFY')) c.innerHTML=tmp_TYIWXFLLFY;
e_TYIWXFLLFY=tmp_TYIWXFLLFY;
}
if(c=Ctrl('GULBMTAYNR')) ChkboxCheckUncheck(c,'S',w_flgatt)
if(c=Ctrl('GULBMTAYNR')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
HideUI();
}
HideUI.lblids["ARapporto"]=['BGHAITOPMU'];
HideUI.lblids["DaRapporto"]=['HPGJXQIVYG'];
function DPKVLWHCIG_Valid(e) {
SetActiveField(Ctrl('DPKVLWHCIG'),false);
e=(Ne(e,null)?e:window.event);
return Set_DaRapporto(HtW(Ctrl('DPKVLWHCIG').value,'C'),null,e);
}
function DPKVLWHCIG_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('DPKVLWHCIG'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('DPKVLWHCIG'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('DPKVLWHCIG'),e);
}
function DPKVLWHCIG_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('DPKVLWHCIG')),'linkview_DPKVLWHCIG','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function MTJDZQTEIR_Valid(e) {
SetActiveField(Ctrl('MTJDZQTEIR'),false);
e=(Ne(e,null)?e:window.event);
return Set_ARapporto(HtW(Ctrl('MTJDZQTEIR').value,'C'),null,e);
}
function MTJDZQTEIR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('MTJDZQTEIR'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('MTJDZQTEIR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('MTJDZQTEIR'),e);
}
function MTJDZQTEIR_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('MTJDZQTEIR')),'linkview_MTJDZQTEIR','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function href_XURLGQZZMU() {
SetLocationHref(null,'arrt_fam_stampa'+'?m_cAction=start&m_cMode=hyperlink','elaborazione')
}
function href_PTXYMSWBZO() {
SetLocationHref(window.location,ToResource('jsp/start_page_logo_portlet.jsp'+'')+'')
}
function GULBMTAYNR_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_flgatt(ChkboxValueAssign(Ctrl('GULBMTAYNR'),'S','N','C',1,0,''),null,e);
}
function GULBMTAYNR_OnFocus(e) {
SetActiveField(Ctrl('GULBMTAYNR'),true);
}
function GULBMTAYNR_OnBlur(e) {
SetActiveField(Ctrl('GULBMTAYNR'),false);
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
if(c=Ctrl('DPKVLWHCIG')) c.onblur=DPKVLWHCIG_Valid;
if(c=Ctrl('DPKVLWHCIG')) c.onfocus=DPKVLWHCIG_OnFocus;
if(c=Ctrl('MTJDZQTEIR')) c.onblur=MTJDZQTEIR_Valid;
if(c=Ctrl('MTJDZQTEIR')) c.onfocus=MTJDZQTEIR_OnFocus;
if(c=Ctrl('GULBMTAYNR')) c.onclick=GULBMTAYNR_Valid;
if(c=Ctrl('GULBMTAYNR')) c.onfocus=GULBMTAYNR_OnFocus;
if(c=Ctrl('GULBMTAYNR')) c.onblur=GULBMTAYNR_OnBlur;
}
}
function NotifyEvent(p_cEvent) {
var old_c;
if (Ne(typeof(w_Messaggi),'undefined')) {
w_Messaggi.raiseEvent('arpg_fam_stampa_'+Strtran(p_cEvent,' ','_'));
}
if (Ne(typeof(w_Log),'undefined')) {
w_Log.raiseEvent('arpg_fam_stampa_'+Strtran(p_cEvent,' ','_'));
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
FocusFirstComponent.otherwise={"page_1":["DPKVLWHCIG"]};
function Help() {
windowOpenForeground('../doc/arpg_fam_stampa_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_DaRapporto=a[0];
w_ARapporto=a[1];
w_flgatt=a[2];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_fam_stampa',m_cSelectedPage);
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
function Set_DaRapporto(ctrlValue,kmode,e) {
if (Ne(w_DaRapporto,ctrlValue)) {
var ctl = _GetCtl(e,'DPKVLWHCIG');
if (_tracker.goon(ctl,ctrlValue)) {
w_DaRapporto=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('DPKVLWHCIG',0);
if (l_bResult) {
l_bResult=Link_DPKVLWHCIG(kmode);
if ( ! (l_bResult)) {
w_DaRapporto=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',25,0,''));
} else {
_ResetTracker();
}
return l_bResult;
} else {
ctl.value=WtH('','C',25,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_ARapporto(ctrlValue,kmode,e) {
if (Ne(w_ARapporto,ctrlValue)) {
var ctl = _GetCtl(e,'MTJDZQTEIR');
if (_tracker.goon(ctl,ctrlValue)) {
w_ARapporto=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MTJDZQTEIR',0);
if (l_bResult) {
l_bResult=Link_MTJDZQTEIR(kmode);
if ( ! (l_bResult)) {
w_ARapporto=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',25,0,''));
} else {
_ResetTracker();
}
return l_bResult;
} else {
ctl.value=WtH('','C',25,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_flgatt(ctrlValue,kmode,e) {
if (Ne(w_flgatt,ctrlValue)) {
var ctl = _GetCtl(e,'GULBMTAYNR');
if (_tracker.goon(ctl,ctrlValue)) {
w_flgatt=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('GULBMTAYNR',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
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
function Link_DPKVLWHCIG(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_DaRapporto);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('RAPPORTO',w_DaRapporto,25,0);
l_Appl.SetFields('RAPPORTO');
l_Appl.SetTypes('C');
l_Appl.LinkTable('aetesta');
l_Appl.SetID('DPKVLWHCIG');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_DaRapporto=l_Appl.GetStringValue('RAPPORTO',25,0);
} else {
Link_DPKVLWHCIG_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_DPKVLWHCIG';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_DPKVLWHCIG();
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
function Link_DPKVLWHCIG_Blank() {
w_DaRapporto='';
}
function LOpt_DPKVLWHCIG() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('aetesta','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('RAPPORTO','C'));
l_oWv.setValue('LinkedField',WtA('RAPPORTO','C'));
l_oWv.setValue('UID',WtA('DPKVLWHCIG','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['DPKVLWHCIG'][1],'C'));
return l_oWv;
}
function Link_MTJDZQTEIR(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_ARapporto);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('RAPPORTO',w_ARapporto,25,0);
l_Appl.SetFields('RAPPORTO');
l_Appl.SetTypes('C');
l_Appl.LinkTable('aetesta');
l_Appl.SetID('MTJDZQTEIR');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_ARapporto=l_Appl.GetStringValue('RAPPORTO',25,0);
} else {
Link_MTJDZQTEIR_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_MTJDZQTEIR';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_MTJDZQTEIR();
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
function Link_MTJDZQTEIR_Blank() {
w_ARapporto='';
}
function LOpt_MTJDZQTEIR() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('aetesta','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('RAPPORTO','C'));
l_oWv.setValue('LinkedField',WtA('RAPPORTO','C'));
l_oWv.setValue('UID',WtA('MTJDZQTEIR','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['MTJDZQTEIR'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('11070726314'),'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'DPKVLWHCIG')) {
last_focused_comp=GetLastFocusedElementOfLink('DPKVLWHCIG');
function SetMethod_DPKVLWHCIG() {
Set_DaRapporto(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_DPKVLWHCIG();
} else {
setTimeout(SetMethod_DPKVLWHCIG,1);
}
bResult=true;
}
if (Eq(varName,'MTJDZQTEIR')) {
last_focused_comp=GetLastFocusedElementOfLink('MTJDZQTEIR');
function SetMethod_MTJDZQTEIR() {
Set_ARapporto(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_MTJDZQTEIR();
} else {
setTimeout(SetMethod_MTJDZQTEIR,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'DPKVLWHCIG')) {
return [Ctrl('DPKVLWHCIG')];
}
if (Eq(varName,'MTJDZQTEIR')) {
return [Ctrl('MTJDZQTEIR')];
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
if ( ! (_ChkObl('DPKVLWHCIG',1))) {
_SignErr('DPKVLWHCIG');
m_cLastWorkVarErrorMsg='DaRapporto';
l_bResult=false;
w_DaRapporto=HtW('','C');
} else if ( ! (_ChkObl('MTJDZQTEIR',1))) {
_SignErr('MTJDZQTEIR');
m_cLastWorkVarErrorMsg='ARapporto';
l_bResult=false;
w_ARapporto=HtW('','C');
} else if ( ! (_ChkObl('GULBMTAYNR',1))) {
_SignErr('GULBMTAYNR');
m_cLastWorkVarErrorMsg='flgatt';
l_bResult=false;
w_flgatt='N';
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('DPKVLWHCIG_ZOOM',lc)) {
return 0;
}
if (Eq('DPKVLWHCIG',lc)) {
return 0;
}
if (Eq('MTJDZQTEIR_ZOOM',lc)) {
return 1;
}
if (Eq('MTJDZQTEIR',lc)) {
return 1;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_DPKVLWHCIG();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,1)) {
l_oWv=LOpt_MTJDZQTEIR();
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
l_oWv.setValue('DaRapporto',WtA(w_DaRapporto,'C'));
l_oWv.setValue('ARapporto',WtA(w_ARapporto,'C'));
l_oWv.setValue('flgatt',WtA(w_flgatt,'C'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["DaRapporto","ARapporto","flgatt"];
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
if (Empty(w_DaRapporto) && Ne(opener.w_DaRapporto,null)) {
TransferBetweenWindows(opener,'w_DaRapporto',null,'Set_DaRapporto');
}
if (Empty(w_ARapporto) && Ne(opener.w_ARapporto,null)) {
TransferBetweenWindows(opener,'w_ARapporto',null,'Set_ARapporto');
}
}
}
m_bCalculating=true;
Link_DPKVLWHCIG(null);
Link_MTJDZQTEIR(null);
if (start && Eq(At(',flgatt,',pseq),0)) {
w_flgatt='N';
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
_Obli('DaRapporto',0,'DPKVLWHCIG',false)
_Obli('ARapporto',0,'MTJDZQTEIR',false)
_Obli('flgatt',0,'GULBMTAYNR',false)
