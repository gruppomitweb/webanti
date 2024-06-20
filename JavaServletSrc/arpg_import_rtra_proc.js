function SetControlsValue() {
var c;
var c;
if(c=Ctrl('WIRRRKLEWO')) selectRadio(c,w_tipodest,'C')
if(c=Ctrl('XFVQTXPEXL')) c.value = WtH(w_idmage,'C',5,0,'')
if(c=Ctrl('ZFBIYQMSFL')) c.value = WtH(w_nomefile,'C',100,0,'')
var tmp_FGMOCXNBFY = ToHTag(AsControlValue('<iframe width=\'655\' height=\'170\' id=\'elaborazione\'  name=\'elaborazione\' frameborder=\'1\'  border=\'1\' align=\'TOP\' marginwidth=\'1\' marginheight=\'1\'></iframe>'));
if (Ne(e_FGMOCXNBFY,tmp_FGMOCXNBFY)) {
if(c=Ctrl('FGMOCXNBFY')) c.innerHTML=tmp_FGMOCXNBFY;
e_FGMOCXNBFY=tmp_FGMOCXNBFY;
}
if(c=Ctrl('RQAECCWOBF')) selectRadio(c,w_destfin,'C')
var tmp_KRFHEOVRDJ = ToHTag(AsControlValue(w_xMADESCRI));
if (Ne(e_KRFHEOVRDJ,tmp_KRFHEOVRDJ)) {
if(c=Ctrl('KRFHEOVRDJ')) c.innerHTML=tmp_KRFHEOVRDJ;
e_KRFHEOVRDJ=tmp_KRFHEOVRDJ;
}
if(c=Ctrl('GSBFOKJJZN')) ChkboxCheckUncheck(c,'S',w_delprec)
if(c=Ctrl('GSBFOKJJZN')) ChkboxValueAssign(c,'S','N','C',10,0,'')
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay(Ctrl('FGMOCXNBFY'),true);
HideUI();
}
HideUI.lblids["idmage"]=['YKEVRMKLNK'];
HideUI.lblids["tipodest"]=['NJQSNRJAXM'];
function DZUBEERBGN_Click() {
UploadDoc()
}
function WIRRRKLEWO_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_tipodest(HtW(getRadioValue(Ctrl('WIRRRKLEWO')),'C'),null,e);
}
function XFVQTXPEXL_Valid(e) {
SetActiveField(Ctrl('XFVQTXPEXL'),false);
e=(Ne(e,null)?e:window.event);
return Set_idmage(HtW(Ctrl('XFVQTXPEXL').value,'C'),null,e);
}
function XFVQTXPEXL_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('XFVQTXPEXL'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('XFVQTXPEXL'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('XFVQTXPEXL'),e);
}
function XFVQTXPEXL_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('XFVQTXPEXL')),'linkview_XFVQTXPEXL','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function href_XWPYHZIJDE() {
var l_oWv = InitWvApplet();
l_oWv.setValue('w_tipodest',AsAppletValue(w_tipodest));
l_oWv.setValue('w_impzip',AsAppletValue(w_impzip));
l_oWv.setValue('w_idmage',AsAppletValue(w_idmage));
l_oWv.setValue('w_destfin',AsAppletValue(w_destfin));
l_oWv.setValue('w_xMADIPSTD',AsAppletValue(w_xMADIPSTD));
l_oWv.setValue('w_xMAFLGASR',AsAppletValue(w_xMAFLGASR));
l_oWv.setValue('w_xMAFLGBON',AsAppletValue(w_xMAFLGBON));
l_oWv.setValue('w_xMAFLGCHKDAT',AsAppletValue(w_xMAFLGCHKDAT));
l_oWv.setValue('w_xMAFLGCKR',AsAppletValue(w_xMAFLGCKR));
l_oWv.setValue('w_xMAFLGRAP',AsAppletValue(w_xMAFLGRAP));
l_oWv.setValue('w_xMANAIDWU',AsAppletValue(w_xMANAIDWU));
l_oWv.setValue('w_delprec',AsAppletValue(w_delprec));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('w_tipodest,w_impzip,w_idmage,w_destfin,w_xMADIPSTD,w_xMAFLGASR,w_xMAFLGBON,w_xMAFLGCHKDAT,w_xMAFLGCKR,w_xMAFLGRAP,w_xMANAIDWU,w_delprec'));
if (false || WindowConfirm(Translate('292774027'))) {
SetLocationHref(null,'arrt_imp_dati_rtra'+'?m_cWv='+URLenc(l_oWv.asString())+'&m_cAction=start&m_cMode=hyperlink','elaborazione')
}
}
function RQAECCWOBF_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_destfin(HtW(getRadioValue(Ctrl('RQAECCWOBF')),'C'),null,e);
}
function href_JSKZJOHJOM() {
SetLocationHref(window.location,ToResource('jsp/start_page_logo_portlet.jsp'+'')+'')
}
function href_JBNBDKBIAJ() {
_modifyandopen(ToResource('jsp/list_filesid_portlet.jsp'+'')+'?m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes,height=600,width=800',null)
}
function GSBFOKJJZN_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_delprec(ChkboxValueAssign(Ctrl('GSBFOKJJZN'),'S','N','C',10,0,''),null,e);
}
function GSBFOKJJZN_OnFocus(e) {
SetActiveField(Ctrl('GSBFOKJJZN'),true);
}
function GSBFOKJJZN_OnBlur(e) {
SetActiveField(Ctrl('GSBFOKJJZN'),false);
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
c=Ctrl('WIRRRKLEWO');
if ( ! (Empty(c))) {
c[0].onclick=WIRRRKLEWO_Valid;
c[1].onclick=WIRRRKLEWO_Valid;
}
if(c=Ctrl('XFVQTXPEXL')) c.onblur=XFVQTXPEXL_Valid;
if(c=Ctrl('XFVQTXPEXL')) c.onfocus=XFVQTXPEXL_OnFocus;
c=Ctrl('RQAECCWOBF');
if ( ! (Empty(c))) {
c[0].onclick=RQAECCWOBF_Valid;
c[1].onclick=RQAECCWOBF_Valid;
}
if(c=Ctrl('GSBFOKJJZN')) c.onclick=GSBFOKJJZN_Valid;
if(c=Ctrl('GSBFOKJJZN')) c.onfocus=GSBFOKJJZN_OnFocus;
if(c=Ctrl('GSBFOKJJZN')) c.onblur=GSBFOKJJZN_OnBlur;
}
}
function NotifyEvent(p_cEvent) {
var old_c;
if (Ne(typeof(w_Messaggi),'undefined')) {
w_Messaggi.raiseEvent('arpg_import_rtra_'+Strtran(p_cEvent,' ','_'));
}
if (Ne(typeof(w_Log),'undefined')) {
w_Log.raiseEvent('arpg_import_rtra_'+Strtran(p_cEvent,' ','_'));
}
if (Ne(typeof(w_ListaFile),'undefined')) {
w_ListaFile.raiseEvent('arpg_import_rtra_'+Strtran(p_cEvent,' ','_'));
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
windowOpenForeground('../doc/arpg_import_rtra_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_tipodest=a[0];
w_idmage=a[1];
w_nomefile=a[2];
w_impzip=a[3];
w_errchk=a[4];
w_gFlgCMod=a[5];
w_xMADESCRI=a[6];
w_destfin=a[7];
w_xMAFLGRAP=a[8];
w_xMAFLGBON=a[9];
w_xMAFLGCKR=a[10];
w_xMAFLGASR=a[11];
w_gAzienda=a[12];
w_gPathApp=a[13];
w_fscarti=a[14];
w_xMADIPSTD=a[15];
w_xMANAIDWU=a[16];
w_xMAFLGCHKDAT=a[17];
w_delprec=a[18];
o_idmage=w_idmage[1];
w_idmage=w_idmage[0];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_import_rtra',m_cSelectedPage);
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
function Set_tipodest(ctrlValue,kmode,e) {
if (Ne(w_tipodest,ctrlValue)) {
var ctl = _GetCtl(e,'WIRRRKLEWO');
if (_tracker.goon(ctl,ctrlValue)) {
w_tipodest=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('WIRRRKLEWO',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_idmage(ctrlValue,kmode,e) {
if (Ne(w_idmage,ctrlValue)) {
var ctl = _GetCtl(e,'XFVQTXPEXL');
if (_tracker.goon(ctl,ctrlValue)) {
w_idmage=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XFVQTXPEXL',0);
if (l_bResult) {
l_bResult=Link_XFVQTXPEXL(kmode);
if ( ! (l_bResult)) {
w_idmage=HtW('','C');
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
function Set_delprec(ctrlValue,kmode,e) {
if (Ne(w_delprec,ctrlValue)) {
var ctl = _GetCtl(e,'GSBFOKJJZN');
if (_tracker.goon(ctl,ctrlValue)) {
w_delprec=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('GSBFOKJJZN',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',10,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_destfin(ctrlValue,kmode,e) {
if (Ne(w_destfin,ctrlValue)) {
var ctl = _GetCtl(e,'RQAECCWOBF');
if (_tracker.goon(ctl,ctrlValue)) {
w_destfin=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RQAECCWOBF',0);
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
if ((Ne(o_idmage,w_idmage))) {
Calculation_YTRRRNBWKF();
}
// * --- Area Manuale = UI - Calculate
// * --- Fine Area Manuale
m_bCalculating=false;
}
function Calculation_YTRRRNBWKF() {
w_destfin=(Empty(w_idmage)?'O':w_destfin);
}
function SaveDependsOn() {
o_idmage=w_idmage;
}
function SaveLabelDependsOn() {
}
function Link_XFVQTXPEXL(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_idmage);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('MACODICE',w_idmage,5,0);
l_Appl.SetFields('MACODICE,MADESCRI,MAFLGRAP,MAFLGOPE,MAFLGBON,MAFLGCKR,MAFLGASR,MADIPSTD,MANAIDWU,MAFLGCHKDAT');
l_Appl.SetTypes('C,C,C,C,C,C,C,C,C,C');
l_Appl.LinkTable('tbmacage');
l_Appl.SetID('XFVQTXPEXL');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_idmage=l_Appl.GetStringValue('MACODICE',5,0);
w_xMADESCRI=l_Appl.GetStringValue('MADESCRI',60,0);
w_xMAFLGRAP=l_Appl.GetStringValue('MAFLGRAP',1,0);
w_destfin=l_Appl.GetStringValue('MAFLGOPE',1,0);
w_xMAFLGBON=l_Appl.GetStringValue('MAFLGBON',1,0);
w_xMAFLGCKR=l_Appl.GetStringValue('MAFLGCKR',1,0);
w_xMAFLGASR=l_Appl.GetStringValue('MAFLGASR',1,0);
w_xMADIPSTD=l_Appl.GetStringValue('MADIPSTD',6,0);
w_xMANAIDWU=l_Appl.GetStringValue('MANAIDWU',5,0);
w_xMAFLGCHKDAT=l_Appl.GetStringValue('MAFLGCHKDAT',1,0);
} else {
Link_XFVQTXPEXL_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_XFVQTXPEXL';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_XFVQTXPEXL();
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
function Link_XFVQTXPEXL_Blank() {
w_idmage='';
w_xMADESCRI='';
w_xMAFLGRAP='';
w_destfin='';
w_xMAFLGBON='';
w_xMAFLGCKR='';
w_xMAFLGASR='';
w_xMADIPSTD='';
w_xMANAIDWU='';
w_xMAFLGCHKDAT='';
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
if (Eq(varName,'XFVQTXPEXL')) {
last_focused_comp=GetLastFocusedElementOfLink('XFVQTXPEXL');
function SetMethod_XFVQTXPEXL() {
Set_idmage(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_XFVQTXPEXL();
} else {
setTimeout(SetMethod_XFVQTXPEXL,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'XFVQTXPEXL')) {
return [Ctrl('XFVQTXPEXL')];
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
if ( ! (_ChkObl('WIRRRKLEWO',1))) {
_SignErr('WIRRRKLEWO');
m_cLastWorkVarErrorMsg='tipodest';
l_bResult=false;
w_tipodest=HtW('','C');
} else if ( ! (_ChkObl('XFVQTXPEXL',1))) {
_SignErr('XFVQTXPEXL');
m_cLastWorkVarErrorMsg='11148783093';
l_bResult=false;
w_idmage=HtW('','C');
} else if ( ! (_ChkObl('RQAECCWOBF',1))) {
_SignErr('RQAECCWOBF');
m_cLastWorkVarErrorMsg='destfin';
l_bResult=false;
w_destfin=HtW('','C');
} else if ( ! (_ChkObl('GSBFOKJJZN',1))) {
_SignErr('GSBFOKJJZN');
m_cLastWorkVarErrorMsg='delprec';
l_bResult=false;
w_delprec='N';
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('XFVQTXPEXL_ZOOM',lc)) {
return 0;
}
if (Eq('XFVQTXPEXL',lc)) {
return 0;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_XFVQTXPEXL();
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
l_oWv.setValue('tipodest',WtA(w_tipodest,'C'));
l_oWv.setValue('idmage',WtA(w_idmage,'C'));
l_oWv.setValue('nomefile',WtA(w_nomefile,'C'));
l_oWv.setValue('impzip',WtA(w_impzip,'N'));
l_oWv.setValue('errchk',WtA(w_errchk,'N'));
l_oWv.setValue('gFlgCMod',WtA(w_gFlgCMod,'C'));
l_oWv.setValue('xMADESCRI',WtA(w_xMADESCRI,'C'));
l_oWv.setValue('destfin',WtA(w_destfin,'C'));
l_oWv.setValue('xMAFLGRAP',WtA(w_xMAFLGRAP,'C'));
l_oWv.setValue('xMAFLGBON',WtA(w_xMAFLGBON,'C'));
l_oWv.setValue('xMAFLGCKR',WtA(w_xMAFLGCKR,'C'));
l_oWv.setValue('xMAFLGASR',WtA(w_xMAFLGASR,'C'));
l_oWv.setValue('gAzienda',WtA(w_gAzienda,'C'));
l_oWv.setValue('gPathApp',WtA(w_gPathApp,'C'));
l_oWv.setValue('fscarti',WtA(w_fscarti,'N'));
l_oWv.setValue('xMADIPSTD',WtA(w_xMADIPSTD,'C'));
l_oWv.setValue('xMANAIDWU',WtA(w_xMANAIDWU,'C'));
l_oWv.setValue('xMAFLGCHKDAT',WtA(w_xMAFLGCHKDAT,'C'));
l_oWv.setValue('delprec',WtA(w_delprec,'C'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["tipodest","idmage","nomefile","impzip","errchk","gFlgCMod","xMADESCRI","destfin","xMAFLGRAP","xMAFLGBON","xMAFLGCKR","xMAFLGASR","gAzienda","gPathApp","fscarti","xMADIPSTD","xMANAIDWU","xMAFLGCHKDAT","delprec"];
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
w_tipodest='P';
}
Link_XFVQTXPEXL(null);
if (start && Eq(At(',impzip,',pseq),0)) {
w_impzip=0;
}
if (start && Eq(At(',errchk,',pseq),0)) {
w_errchk=0;
}
if (start && Eq(At(',destfin,',pseq),0)) {
w_destfin='O';
}
if (start && Eq(At(',delprec,',pseq),0)) {
w_delprec='N';
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
_Obli('tipodest',0,'WIRRRKLEWO',false)
_Obli('idmage',0,'XFVQTXPEXL',false,"11148783093")
_Obli('delprec',0,'GSBFOKJJZN',false)
_Obli('destfin',0,'RQAECCWOBF',false)
