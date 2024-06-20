function SetControlsValue() {
var c;
var c;
if(c=Ctrl('ZFBIYQMSFL')) c.value = WtH(w_nomefile,'C',100,0,'')
var tmp_FGMOCXNBFY = ToHTag(AsControlValue('<iframe width=\'655\' height=\'170\' id=\'elaborazione\'  name=\'elaborazione\' frameborder=\'1\'  border=\'1\' align=\'TOP\' marginwidth=\'1\' marginheight=\'1\'></iframe>'));
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
function DZUBEERBGN_Click() {
if (Eq(w_impzip,0)) {
UploadDoc()
}
}
function href_XWPYHZIJDE() {
if (false || WindowConfirm(Translate('292774027'))) {
SetLocationHref(null,'arrt_impdel_ip'+'?m_cAction=start&m_cMode=hyperlink','elaborazione')
}
}
function href_JSKZJOHJOM() {
SetLocationHref(window.location,ToResource('jsp/start_page_logo_portlet.jsp'+'')+'')
}
function href_NBDWXOTRLG() {
var l_oWv = InitWvApplet();
l_oWv.setValue('DescAzi',AsAppletValue(w_gDescAzi));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('DescAzi'));
_modifyandopen('Report?ReportName='+'arrp_impdel_ip'+'&m_cWv='+URLenc(l_oWv.asString())+'&m_cAtExit=close&m_cMode=hyperlink','scrollbars=1,toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null)
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
if (Ne(typeof(w_Messaggi),'undefined')) {
w_Messaggi.raiseEvent('arpg_impdel_ip_'+Strtran(p_cEvent,' ','_'));
}
if (Ne(typeof(w_Log),'undefined')) {
w_Log.raiseEvent('arpg_impdel_ip_'+Strtran(p_cEvent,' ','_'));
}
if (Ne(typeof(w_ListaFile),'undefined')) {
w_ListaFile.raiseEvent('arpg_impdel_ip_'+Strtran(p_cEvent,' ','_'));
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
FocusFirstComponent.otherwise={"page_1":["DZUBEERBGN"]};
function Help() {
windowOpenForeground('../doc/arpg_impdel_ip_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_nomefile=a[0];
w_tipodest=a[1];
w_impzip=a[2];
w_errchk=a[3];
w_gTelepass=a[4];
w_gFlgCMod=a[5];
w_codmage=a[6];
w_xMADESCRI=a[7];
w_destfin=a[8];
w_xMAFLGRAP=a[9];
w_xMAFLGBON=a[10];
w_xMAFLGCKR=a[11];
w_xMAFLGASR=a[12];
w_annorif=a[13];
w_gAzienda=a[14];
w_gPathApp=a[15];
w_fscarti=a[16];
w_newrec=a[17];
w_opextc=a[18];
w_creamo=a[19];
w_imperr=a[20];
w_chkaui=a[21];
w_gMsgImp=a[22];
w_gMsgProc=a[23];
w_gDescAzi=a[24];
o_codmage=w_codmage[1];
w_codmage=w_codmage[0];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_impdel_ip',m_cSelectedPage);
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
l_bEnabled= ! (Eq(w_impzip,0));
SetDisabled(Ctrl('DZUBEERBGN'),l_bEnabled);
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
if ((Ne(o_codmage,w_codmage))) {
l_bTmpRes=Link_XFVQTXPEXL(null);
}
// * --- Area Manuale = UI - Calculate
// * --- Fine Area Manuale
m_bCalculating=false;
}
function SaveDependsOn() {
o_codmage=w_codmage;
}
function SaveLabelDependsOn() {
}
function Link_XFVQTXPEXL(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_codmage);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('MACODICE',w_codmage,5,0);
l_Appl.SetFields('MACODICE,MADESCRI,MAFLGRAP,MAFLGOPE,MAFLGBON,MAFLGCKR,MAFLGASR');
l_Appl.SetTypes('C,C,C,C,C,C,C');
l_Appl.LinkTable('tbmacage');
l_Appl.SetID('XFVQTXPEXL');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_codmage=l_Appl.GetStringValue('MACODICE',5,0);
w_xMADESCRI=l_Appl.GetStringValue('MADESCRI',60,0);
w_xMAFLGRAP=l_Appl.GetStringValue('MAFLGRAP',1,0);
w_destfin=l_Appl.GetStringValue('MAFLGOPE',1,0);
w_xMAFLGBON=l_Appl.GetStringValue('MAFLGBON',1,0);
w_xMAFLGCKR=l_Appl.GetStringValue('MAFLGCKR',1,0);
w_xMAFLGASR=l_Appl.GetStringValue('MAFLGASR',1,0);
} else {
Link_XFVQTXPEXL_Blank();
}
if ( ! (l_bResult)) {
m_nLastError=3;
m_cLastWorkVarErrorMsg='';
if (Lt(l_nRec,0)) {
m_cLastMsgError=Translate('MSG_CONNECT_SERVER');
}
}
return l_bResult;
}
function Link_XFVQTXPEXL_Blank() {
w_codmage='';
w_xMADESCRI='';
w_xMAFLGRAP='';
w_destfin='';
w_xMAFLGBON='';
w_xMAFLGCKR='';
w_xMAFLGASR='';
}
function LOpt_XFVQTXPEXL() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbmacage','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('MACODICE','C'));
l_oWv.setValue('LinkedField',WtA('MACODICE','C'));
l_oWv.setValue('UID',WtA('XFVQTXPEXL','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['XFVQTXPEXL'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('11148782069'),'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
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
l_oWv.setValue('nomefile',WtA(w_nomefile,'C'));
l_oWv.setValue('tipodest',WtA(w_tipodest,'C'));
l_oWv.setValue('impzip',WtA(w_impzip,'N'));
l_oWv.setValue('errchk',WtA(w_errchk,'N'));
l_oWv.setValue('gTelepass',WtA(w_gTelepass,'C'));
l_oWv.setValue('gFlgCMod',WtA(w_gFlgCMod,'C'));
l_oWv.setValue('codmage',WtA(w_codmage,'C'));
l_oWv.setValue('xMADESCRI',WtA(w_xMADESCRI,'C'));
l_oWv.setValue('destfin',WtA(w_destfin,'C'));
l_oWv.setValue('xMAFLGRAP',WtA(w_xMAFLGRAP,'C'));
l_oWv.setValue('xMAFLGBON',WtA(w_xMAFLGBON,'C'));
l_oWv.setValue('xMAFLGCKR',WtA(w_xMAFLGCKR,'C'));
l_oWv.setValue('xMAFLGASR',WtA(w_xMAFLGASR,'C'));
l_oWv.setValue('annorif',WtA(w_annorif,'N'));
l_oWv.setValue('gAzienda',WtA(w_gAzienda,'C'));
l_oWv.setValue('gPathApp',WtA(w_gPathApp,'C'));
l_oWv.setValue('fscarti',WtA(w_fscarti,'N'));
l_oWv.setValue('newrec',WtA(w_newrec,'C'));
l_oWv.setValue('opextc',WtA(w_opextc,'C'));
l_oWv.setValue('creamo',WtA(w_creamo,'C'));
l_oWv.setValue('imperr',WtA(w_imperr,'C'));
l_oWv.setValue('chkaui',WtA(w_chkaui,'C'));
l_oWv.setValue('gMsgImp',WtA(w_gMsgImp,'C'));
l_oWv.setValue('gMsgProc',WtA(w_gMsgProc,'C'));
l_oWv.setValue('gDescAzi',WtA(w_gDescAzi,'C'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["nomefile","tipodest","impzip","errchk","gTelepass","gFlgCMod","codmage","xMADESCRI","destfin","xMAFLGRAP","xMAFLGBON","xMAFLGCKR","xMAFLGASR","annorif","gAzienda","gPathApp","fscarti","newrec","opextc","creamo","imperr","chkaui","gMsgImp","gMsgProc","gDescAzi"];
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
if (Empty(w_nomefile) && Ne(opener.w_nomefile,null)) {
TransferBetweenWindows(opener,'w_nomefile','w_nomefile');
}
if (Empty(w_fscarti) && Ne(opener.w_fscarti,null)) {
TransferBetweenWindows(opener,'w_fscarti','w_fscarti');
}
}
}
m_bCalculating=true;
if (start && Eq(At(',tipodest,',pseq),0)) {
w_tipodest='D';
}
if (start && Eq(At(',impzip,',pseq),0)) {
w_impzip=0;
}
if (start && Eq(At(',errchk,',pseq),0)) {
w_errchk=0;
}
Link_XFVQTXPEXL(null);
if (start && Eq(At(',destfin,',pseq),0)) {
w_destfin='O';
}
if (start && Eq(At(',newrec,',pseq),0)) {
w_newrec='N';
}
if (start && Eq(At(',opextc,',pseq),0)) {
w_opextc='N';
}
if (start && Eq(At(',creamo,',pseq),0)) {
w_creamo='N';
}
if (start && Eq(At(',imperr,',pseq),0)) {
w_imperr='N';
}
if (start && Eq(At(',chkaui,',pseq),0)) {
w_chkaui='N';
}
if (start && Eq(At(',gMsgImp,',pseq),0)) {
w_gMsgImp='Messaggi Elaborazione';
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
