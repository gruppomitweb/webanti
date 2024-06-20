function SetControlsValue() {
var c;
var c;
if(c=Ctrl('ZFBIYQMSFL')) c.value = WtH(w_nomefile,'C',100,0,'')
var tmp_GORGDGDNGD = ToHTag(AsControlValue('<iframe width=\'776\' height=\'300\' id =\'informazioni\' name=\'informazioni\' src=\'../servlet/arpg_list_imprich?nomefile='+w_nomefile+'\''+' frameborder=\'1\'  border=\'1\' align=\'TOP\' marginwidth=\'1\' marginheight=\'1\'></iframe>'));
if (Ne(e_GORGDGDNGD,tmp_GORGDGDNGD)) {
if(c=Ctrl('GORGDGDNGD')) c.innerHTML=tmp_GORGDGDNGD;
e_GORGDGDNGD=tmp_GORGDGDNGD;
}
var tmp_FGMOCXNBFY = ToHTag(AsControlValue('<iframe width=\'655\' height=\'170\' id=\'elaborazione\'  name=\'elaborazione\'  frameborder=\'1\'  border=\'1\' align=\'TOP\' marginwidth=\'1\' marginheight=\'1\'></iframe>'));
if (Ne(e_FGMOCXNBFY,tmp_FGMOCXNBFY)) {
if(c=Ctrl('FGMOCXNBFY')) c.innerHTML=tmp_FGMOCXNBFY;
e_FGMOCXNBFY=tmp_FGMOCXNBFY;
}
var tmp_SSRCOAMDBL = ToHTag(AsControlValue('<iframe width=\'776\' height=\'155\' id =\'messaggi\' src=\'arpg_msg_import\' frameborder=\'1\'  border=\'1\' align=\'TOP\' marginwidth=\'1\' marginheight=\'1\'></iframe>'));
if (Ne(e_SSRCOAMDBL,tmp_SSRCOAMDBL)) {
if(c=Ctrl('SSRCOAMDBL')) c.innerHTML=tmp_SSRCOAMDBL;
e_SSRCOAMDBL=tmp_SSRCOAMDBL;
}
if(c=Ctrl('BESVSXEZBJ')) c.value = WtH(w_msgproc,'M',10,0,'')
if(c=Ctrl('VNFRMCXRZW')) c.value = WtH(w_offset,'N',5,0,'')
if(c=Ctrl('BLSWRPJBJG')) ChkboxCheckUncheck(c,'S',w_f_denom)
if(c=Ctrl('BLSWRPJBJG')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('EQEVYTAUZT')) selectCombo(c,w_f_ricaui,'C')
if(c=Ctrl('VQLMVVYLUU')) c.value = WtH(w_prefrap,'C',5,0,'')
if(c=Ctrl('HKGEZJGNAE')) c.value = WtH(w_codval,'C',3,0,'')
var tmp_RMHDQIMWME = ToHTag(AsControlValue(w_xdesval));
if (Ne(e_RMHDQIMWME,tmp_RMHDQIMWME)) {
if(c=Ctrl('RMHDQIMWME')) c.innerHTML=tmp_RMHDQIMWME;
e_RMHDQIMWME=tmp_RMHDQIMWME;
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
HideUI.lblids["codval"]=['SSTUTBOCAN'];
HideUI.lblids["prefrap"]=['CDTQPZIPTH'];
function DZUBEERBGN_Click() {
if (Eq(w_impzip,0)) {
UploadDoc()
}
}
function PIRPTHHLHK_Click() {
SetLocationHref(null,'arrt_import_fileae_vg'+'?m_cAction=start&m_cMode=hyperlink','elaborazione')
}
function VNFRMCXRZW_Valid(e) {
SetActiveField(Ctrl('VNFRMCXRZW'),false);
e=(Ne(e,null)?e:window.event);
return Set_offset(HtW(Ctrl('VNFRMCXRZW').value,'N'),null,e);
}
function VNFRMCXRZW_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('VNFRMCXRZW'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('VNFRMCXRZW'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('VNFRMCXRZW'),e);
}
function BLSWRPJBJG_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_f_denom(ChkboxValueAssign(Ctrl('BLSWRPJBJG'),'S','N','C',1,0,''),null,e);
}
function BLSWRPJBJG_OnFocus(e) {
SetActiveField(Ctrl('BLSWRPJBJG'),true);
}
function BLSWRPJBJG_OnBlur(e) {
SetActiveField(Ctrl('BLSWRPJBJG'),false);
}
function EQEVYTAUZT_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_f_ricaui(HtW(getComboValue(Ctrl('EQEVYTAUZT')),'C'),null,e);
}
function EQEVYTAUZT_OnFocus(e) {
SetActiveField(Ctrl('EQEVYTAUZT'),true);
}
function EQEVYTAUZT_OnBlur(e) {
SetActiveField(Ctrl('EQEVYTAUZT'),false);
}
function VQLMVVYLUU_Valid(e) {
SetActiveField(Ctrl('VQLMVVYLUU'),false);
e=(Ne(e,null)?e:window.event);
return Set_prefrap(HtW(Ctrl('VQLMVVYLUU').value,'C'),null,e);
}
function VQLMVVYLUU_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('VQLMVVYLUU'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('VQLMVVYLUU'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('VQLMVVYLUU'),e);
}
function HKGEZJGNAE_Valid(e) {
SetActiveField(Ctrl('HKGEZJGNAE'),false);
e=(Ne(e,null)?e:window.event);
return Set_codval(HtW(Ctrl('HKGEZJGNAE').value,'C'),null,e);
}
function HKGEZJGNAE_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('HKGEZJGNAE'))) {
DisplayErrorMessage();
}
if ( ! (GetDisabled('HKGEZJGNAE'))) {
if (Eq(w_codval,'') && Eq(_tracker.ctrl,null)) {
Ctrl('HKGEZJGNAE').value=WtH('242','C',3,0,'');
} else {
}
}
SetActiveField(Ctrl('HKGEZJGNAE'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('HKGEZJGNAE'),e);
}
function HKGEZJGNAE_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('HKGEZJGNAE')),'linkview_HKGEZJGNAE','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function NCXAJLIDKA_Click() {
SetLocationHref(null,'arrt_import_fileae_xls'+'?m_cAction=start&m_cMode=hyperlink','elaborazione')
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
if(c=Ctrl('VNFRMCXRZW')) c.onblur=VNFRMCXRZW_Valid;
if(c=Ctrl('VNFRMCXRZW')) c.onfocus=VNFRMCXRZW_OnFocus;
if(c=Ctrl('VNFRMCXRZW')) c.onkeypress=CheckNum;
if(c=Ctrl('BLSWRPJBJG')) c.onclick=BLSWRPJBJG_Valid;
if(c=Ctrl('BLSWRPJBJG')) c.onfocus=BLSWRPJBJG_OnFocus;
if(c=Ctrl('BLSWRPJBJG')) c.onblur=BLSWRPJBJG_OnBlur;
if(c=Ctrl('EQEVYTAUZT')) c.onchange=EQEVYTAUZT_Valid;
if(c=Ctrl('EQEVYTAUZT')) c.onfocus=EQEVYTAUZT_OnFocus;
if(c=Ctrl('EQEVYTAUZT')) c.onblur=EQEVYTAUZT_OnBlur;
if(c=Ctrl('VQLMVVYLUU')) c.onblur=VQLMVVYLUU_Valid;
if(c=Ctrl('VQLMVVYLUU')) c.onfocus=VQLMVVYLUU_OnFocus;
if(c=Ctrl('HKGEZJGNAE')) c.onblur=HKGEZJGNAE_Valid;
if(c=Ctrl('HKGEZJGNAE')) c.onfocus=HKGEZJGNAE_OnFocus;
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
FocusFirstComponent.otherwise={"page_1":["DZUBEERBGN","PIRPTHHLHK"]};
function Help() {
windowOpenForeground('../doc/arpg_import_fileae_vg_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_msgproc=a[1];
w_errchk=a[2];
w_offset=a[3];
w_f_denom=a[4];
w_f_ricaui=a[5];
w_prefrap=a[6];
w_codval=a[7];
w_xdesval=a[8];
w_impzip=a[9];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_import_fileae_vg',m_cSelectedPage);
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
l_bEnabled= ! (Eq(w_f_ricaui,'A') || Eq(w_f_ricaui,'G')) || IsDisabledByStateDriver('codval');
SetDisabled(Ctrl('HKGEZJGNAE'),l_bEnabled);
SetDisabled(Ctrl('HKGEZJGNAE_ZOOM'),l_bEnabled);
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
function Set_f_denom(ctrlValue,kmode,e) {
if (Ne(w_f_denom,ctrlValue)) {
var ctl = _GetCtl(e,'BLSWRPJBJG');
if (_tracker.goon(ctl,ctrlValue)) {
w_f_denom=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BLSWRPJBJG',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_f_ricaui(ctrlValue,kmode,e) {
if (Ne(w_f_ricaui,ctrlValue)) {
var ctl = _GetCtl(e,'EQEVYTAUZT');
if (_tracker.goon(ctl,ctrlValue)) {
w_f_ricaui=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('EQEVYTAUZT',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_offset(ctrlValue,kmode,e) {
if (Ne(w_offset,ctrlValue)) {
var ctl = _GetCtl(e,'VNFRMCXRZW');
if (_tracker.goon(ctl,ctrlValue)) {
w_offset=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VNFRMCXRZW',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','N',5,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_prefrap(ctrlValue,kmode,e) {
if (Ne(w_prefrap,ctrlValue)) {
var ctl = _GetCtl(e,'VQLMVVYLUU');
if (_tracker.goon(ctl,ctrlValue)) {
w_prefrap=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VQLMVVYLUU',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',5,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_codval(ctrlValue,kmode,e) {
if (Ne(w_codval,ctrlValue)) {
var ctl = _GetCtl(e,'HKGEZJGNAE');
if (_tracker.goon(ctl,ctrlValue)) {
w_codval=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HKGEZJGNAE',0);
if (l_bResult) {
l_bResult=Link_HKGEZJGNAE(kmode);
if ( ! (l_bResult)) {
w_codval=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',3,0,''));
} else {
_ResetTracker();
}
return l_bResult;
} else {
ctl.value=WtH('','C',3,0,'');
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
w_msgproc=arfn_readgmsgproc();
// * --- Area Manuale = UI - Calculate
// * --- Fine Area Manuale
m_bCalculating=false;
}
function SaveDependsOn() {
}
function SaveLabelDependsOn() {
}
function Link_HKGEZJGNAE(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_codval);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODVAL',w_codval,3,0);
l_Appl.SetFields('CODVAL,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbvalute');
l_Appl.SetID('HKGEZJGNAE');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_codval=l_Appl.GetStringValue('CODVAL',3,0);
w_xdesval=l_Appl.GetStringValue('DESCRI',45,0);
} else {
Link_HKGEZJGNAE_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_HKGEZJGNAE';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_HKGEZJGNAE();
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
function Link_HKGEZJGNAE_Blank() {
w_codval='';
w_xdesval='';
}
function LOpt_HKGEZJGNAE() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbvalute','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODVAL','C'));
l_oWv.setValue('LinkedField',WtA('CODVAL','C'));
l_oWv.setValue('UID',WtA('HKGEZJGNAE','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['HKGEZJGNAE'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('114016870'),'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'HKGEZJGNAE')) {
last_focused_comp=GetLastFocusedElementOfLink('HKGEZJGNAE');
function SetMethod_HKGEZJGNAE() {
Set_codval(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_HKGEZJGNAE();
} else {
setTimeout(SetMethod_HKGEZJGNAE,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'HKGEZJGNAE')) {
return [Ctrl('HKGEZJGNAE')];
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
if ( ! (_ChkObl('VNFRMCXRZW',1))) {
_SignErr('VNFRMCXRZW');
m_cLastWorkVarErrorMsg='offset';
l_bResult=false;
w_offset=HtW('','N');
} else if ( ! (_ChkObl('BLSWRPJBJG',1))) {
_SignErr('BLSWRPJBJG');
m_cLastWorkVarErrorMsg='f_denom';
l_bResult=false;
w_f_denom='N';
} else if ( ! (_ChkObl('EQEVYTAUZT',1))) {
_SignErr('EQEVYTAUZT');
m_cLastWorkVarErrorMsg='f_ricaui';
l_bResult=false;
w_f_ricaui=HtW('','C');
} else if ( ! (_ChkObl('VQLMVVYLUU',1))) {
_SignErr('VQLMVVYLUU');
m_cLastWorkVarErrorMsg='prefrap';
l_bResult=false;
w_prefrap=HtW('','C');
} else if ((Eq(w_f_ricaui,'A') || Eq(w_f_ricaui,'G')) && ( ! (_ChkObl('HKGEZJGNAE',1)))) {
_SignErr('HKGEZJGNAE');
m_cLastWorkVarErrorMsg='codval';
l_bResult=false;
w_codval=HtW('','C');
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('HKGEZJGNAE_ZOOM',lc)) {
return 0;
}
if (Eq('HKGEZJGNAE',lc)) {
return 0;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_HKGEZJGNAE();
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
l_oWv.setValue('nomefile',WtA(w_nomefile,'C'));
l_oWv.setValue('msgproc',WtA(w_msgproc,'M'));
l_oWv.setValue('errchk',WtA(w_errchk,'N'));
l_oWv.setValue('offset',WtA(w_offset,'N'));
l_oWv.setValue('f_denom',WtA(w_f_denom,'C'));
l_oWv.setValue('f_ricaui',WtA(w_f_ricaui,'C'));
l_oWv.setValue('prefrap',WtA(w_prefrap,'C'));
l_oWv.setValue('codval',WtA(w_codval,'C'));
l_oWv.setValue('xdesval',WtA(w_xdesval,'C'));
l_oWv.setValue('impzip',WtA(w_impzip,'N'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["nomefile","msgproc","errchk","offset","f_denom","f_ricaui","prefrap","codval","xdesval","impzip"];
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
if (Empty(w_msgproc) && Ne(opener.w_msgproc,null)) {
TransferBetweenWindows(opener,'w_msgproc','w_msgproc');
}
}
}
m_bCalculating=true;
w_msgproc=arfn_readgmsgproc();
if (start && Eq(At(',errchk,',pseq),0)) {
w_errchk=1;
}
if (start && Eq(At(',offset,',pseq),0)) {
w_offset=1800;
}
if (start && Eq(At(',f_denom,',pseq),0)) {
w_f_denom='N';
}
Link_HKGEZJGNAE(null);
if (start && Eq(At(',impzip,',pseq),0)) {
w_impzip=0;
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
_Obli('f_denom',0,'BLSWRPJBJG',false)
_Obli('f_ricaui',0,'EQEVYTAUZT',false)
_Obli('offset',1,'VNFRMCXRZW',false)
_Obli('prefrap',0,'VQLMVVYLUU',false)
_Obli('codval',0,'HKGEZJGNAE',false)
