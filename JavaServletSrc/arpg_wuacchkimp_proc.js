function SetControlsValue() {
var c;
var c;
if(c=Ctrl('ZFBIYQMSFL')) c.value = WtH(w_nomefile,'C',100,0,'')
if(c=Ctrl('WIRRRKLEWO')) selectRadio(c,w_tipodest,'C')
var tmp_FGMOCXNBFY = ToHTag(AsControlValue('<iframe width=\'655\' height=\'170\' id=\'elaborazione\'  name=\'elaborazione\' frameborder=\'1\'  border=\'1\' align=\'TOP\' marginwidth=\'1\' marginheight=\'1\'></iframe>'));
if (Ne(e_FGMOCXNBFY,tmp_FGMOCXNBFY)) {
if(c=Ctrl('FGMOCXNBFY')) c.innerHTML=tmp_FGMOCXNBFY;
e_FGMOCXNBFY=tmp_FGMOCXNBFY;
}
if(c=Ctrl('JAKNEJNBKZ')) ChkboxCheckUncheck(c,'S',w_opextc)
if(c=Ctrl('JAKNEJNBKZ')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('XFVQTXPEXL')) c.value = WtH(w_codmage,'C',5,0,'')
var tmp_KRFHEOVRDJ = ToHTag(AsControlValue(w_xMADESCRI));
if (Ne(e_KRFHEOVRDJ,tmp_KRFHEOVRDJ)) {
if(c=Ctrl('KRFHEOVRDJ')) c.innerHTML=tmp_KRFHEOVRDJ;
e_KRFHEOVRDJ=tmp_KRFHEOVRDJ;
}
if(c=Ctrl('RQAECCWOBF')) selectRadio(c,w_destfin,'C')
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay(Ctrl('FGMOCXNBFY'),true);
SetDisplay('JAKNEJNBKZ_DIV',Ne(w_gTelepass,'5'));
SetDisplay(Ctrl('XFVQTXPEXL'),Ne(w_gTelepass,'5') || IsHiddenByStateDriver('codmage'));
SetDisplay(Ctrl('XFVQTXPEXL_ZOOM'),Ne(w_gTelepass,'5'));
SetDisplay(Ctrl('YKEVRMKLNK'),Ne(w_gTelepass,'5'));
SetDisplay(Ctrl('KRFHEOVRDJ'),Ne(w_gTelepass,'5'));
SetDisplay('RQAECCWOBF_DIV',Ne(w_gTelepass,'5'));
HideUI();
}
HideUI.lblids["codmage"]=['YKEVRMKLNK'];
HideUI.lblids["destfin"]=['YKEVRMKLNK'];
HideUI.lblids["opextc"]=['KRFHEOVRDJ'];
HideUI.lblids["tipodest"]=['NJQSNRJAXM'];
function ZFBIYQMSFL_Valid(e) {
SetActiveField(Ctrl('ZFBIYQMSFL'),false);
e=(Ne(e,null)?e:window.event);
return Set_nomefile(HtW(Ctrl('ZFBIYQMSFL').value,'C'),null,e);
}
function ZFBIYQMSFL_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ZFBIYQMSFL'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('ZFBIYQMSFL'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ZFBIYQMSFL'),e);
}
function WIRRRKLEWO_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_tipodest(HtW(getRadioValue(Ctrl('WIRRRKLEWO')),'C'),null,e);
}
function href_XWPYHZIJDE() {
SetLocationHref(null,'arrt_wuaccchkimp'+'?m_cAction=start&m_cMode=hyperlink','elaborazione')
}
function JAKNEJNBKZ_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_opextc(ChkboxValueAssign(Ctrl('JAKNEJNBKZ'),'S','N','C',1,0,''),null,e);
}
function JAKNEJNBKZ_OnFocus(e) {
SetActiveField(Ctrl('JAKNEJNBKZ'),true);
}
function JAKNEJNBKZ_OnBlur(e) {
SetActiveField(Ctrl('JAKNEJNBKZ'),false);
}
function XFVQTXPEXL_Valid(e) {
SetActiveField(Ctrl('XFVQTXPEXL'),false);
e=(Ne(e,null)?e:window.event);
return Set_codmage(HtW(Ctrl('XFVQTXPEXL').value,'C'),null,e);
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
function RQAECCWOBF_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_destfin(HtW(getRadioValue(Ctrl('RQAECCWOBF')),'C'),null,e);
}
function DZUBEERBGN_Click() {
UploadDoc()
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
if(c=Ctrl('ZFBIYQMSFL')) c.onblur=ZFBIYQMSFL_Valid;
if(c=Ctrl('ZFBIYQMSFL')) c.onfocus=ZFBIYQMSFL_OnFocus;
c=Ctrl('WIRRRKLEWO');
if ( ! (Empty(c))) {
c[0].onclick=WIRRRKLEWO_Valid;
c[1].onclick=WIRRRKLEWO_Valid;
}
if(c=Ctrl('JAKNEJNBKZ')) c.onclick=JAKNEJNBKZ_Valid;
if(c=Ctrl('JAKNEJNBKZ')) c.onfocus=JAKNEJNBKZ_OnFocus;
if(c=Ctrl('JAKNEJNBKZ')) c.onblur=JAKNEJNBKZ_OnBlur;
if(c=Ctrl('XFVQTXPEXL')) c.onblur=XFVQTXPEXL_Valid;
if(c=Ctrl('XFVQTXPEXL')) c.onfocus=XFVQTXPEXL_OnFocus;
c=Ctrl('RQAECCWOBF');
if ( ! (Empty(c))) {
c[0].onclick=RQAECCWOBF_Valid;
c[1].onclick=RQAECCWOBF_Valid;
}
}
}
function NotifyEvent(p_cEvent) {
var old_c;
if (Ne(typeof(w_Messaggi),'undefined')) {
w_Messaggi.raiseEvent('arpg_wuacchkimp_'+Strtran(p_cEvent,' ','_'));
}
if (Ne(typeof(w_Log),'undefined')) {
w_Log.raiseEvent('arpg_wuacchkimp_'+Strtran(p_cEvent,' ','_'));
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
FocusFirstComponent.otherwise={"page_1":["WIRRRKLEWO"]};
function Help() {
windowOpenForeground('../doc/arpg_wuacchkimp_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_opextc=a[5];
w_codmage=a[6];
w_xMADESCRI=a[7];
w_destfin=a[8];
w_xMAFLGRAP=a[9];
w_xMAFLGBON=a[10];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_wuacchkimp',m_cSelectedPage);
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
l_bEnabled= ! (false) || IsDisabledByStateDriver('nomefile');
SetDisabled(Ctrl('ZFBIYQMSFL'),l_bEnabled);
l_bEnabled= ! (Eq(w_tipodest,'D')) || IsDisabledByStateDriver('opextc');
SetDisabled(Ctrl('JAKNEJNBKZ'),l_bEnabled);
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
function Set_nomefile(ctrlValue,kmode,e) {
if (Ne(w_nomefile,ctrlValue)) {
var ctl = _GetCtl(e,'ZFBIYQMSFL');
if (_tracker.goon(ctl,ctrlValue)) {
w_nomefile=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ZFBIYQMSFL',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',100,0,'');
_ResetTracker();
return true;
}
}
return true;
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
function Set_opextc(ctrlValue,kmode,e) {
if (Ne(w_opextc,ctrlValue)) {
var ctl = _GetCtl(e,'JAKNEJNBKZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_opextc=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('JAKNEJNBKZ',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_codmage(ctrlValue,kmode,e) {
if (Ne(w_codmage,ctrlValue)) {
var ctl = _GetCtl(e,'XFVQTXPEXL');
if (_tracker.goon(ctl,ctrlValue)) {
w_codmage=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XFVQTXPEXL',0);
if (l_bResult) {
l_bResult=Link_XFVQTXPEXL(kmode);
if ( ! (l_bResult)) {
w_codmage=HtW('','C');
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
// * --- Area Manuale = UI - Calculate
// * --- Fine Area Manuale
m_bCalculating=false;
}
function SaveDependsOn() {
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
l_Appl.SetFields('MACODICE,MADESCRI,MAFLGRAP,MAFLGOPE,MAFLGBON');
l_Appl.SetTypes('C,C,C,C,C');
l_Appl.LinkTable('tbmacage');
l_Appl.SetID('XFVQTXPEXL');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_codmage=l_Appl.GetStringValue('MACODICE',5,0);
w_xMADESCRI=l_Appl.GetStringValue('MADESCRI',60,0);
w_xMAFLGRAP=l_Appl.GetStringValue('MAFLGRAP',1,0);
w_destfin=l_Appl.GetStringValue('MAFLGOPE',1,0);
w_xMAFLGBON=l_Appl.GetStringValue('MAFLGBON',1,0);
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
w_codmage='';
w_xMADESCRI='';
w_xMAFLGRAP='';
w_destfin='';
w_xMAFLGBON='';
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
Set_codmage(HtW(value,'C'),0);
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
if ((false) && ( ! (_ChkObl('ZFBIYQMSFL',1)))) {
_SignErr('ZFBIYQMSFL');
m_cLastWorkVarErrorMsg='nomefile';
l_bResult=false;
w_nomefile=HtW('','C');
} else if ( ! (_ChkObl('WIRRRKLEWO',1))) {
_SignErr('WIRRRKLEWO');
m_cLastWorkVarErrorMsg='tipodest';
l_bResult=false;
w_tipodest=HtW('','C');
} else if ((Eq(w_tipodest,'D')) && ( ! (_ChkObl('JAKNEJNBKZ',1)))) {
_SignErr('JAKNEJNBKZ');
m_cLastWorkVarErrorMsg='opextc';
l_bResult=false;
w_opextc='N';
} else if ( ! (_ChkObl('XFVQTXPEXL',1))) {
_SignErr('XFVQTXPEXL');
m_cLastWorkVarErrorMsg='11148783093';
l_bResult=false;
w_codmage=HtW('','C');
} else if ( ! (_ChkObl('RQAECCWOBF',1))) {
_SignErr('RQAECCWOBF');
m_cLastWorkVarErrorMsg='destfin';
l_bResult=false;
w_destfin=HtW('','C');
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
l_oWv.setValue('nomefile',WtA(w_nomefile,'C'));
l_oWv.setValue('tipodest',WtA(w_tipodest,'C'));
l_oWv.setValue('impzip',WtA(w_impzip,'N'));
l_oWv.setValue('errchk',WtA(w_errchk,'N'));
l_oWv.setValue('gTelepass',WtA(w_gTelepass,'C'));
l_oWv.setValue('opextc',WtA(w_opextc,'C'));
l_oWv.setValue('codmage',WtA(w_codmage,'C'));
l_oWv.setValue('xMADESCRI',WtA(w_xMADESCRI,'C'));
l_oWv.setValue('destfin',WtA(w_destfin,'C'));
l_oWv.setValue('xMAFLGRAP',WtA(w_xMAFLGRAP,'C'));
l_oWv.setValue('xMAFLGBON',WtA(w_xMAFLGBON,'C'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["nomefile","tipodest","impzip","errchk","gTelepass","opextc","codmage","xMADESCRI","destfin","xMAFLGRAP","xMAFLGBON"];
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
TransferBetweenWindows(opener,'w_nomefile',null,'Set_nomefile');
}
}
}
m_bCalculating=true;
if (start && Eq(At(',tipodest,',pseq),0)) {
w_tipodest='P';
}
if (start && Eq(At(',impzip,',pseq),0)) {
w_impzip=0;
}
if (start && Eq(At(',errchk,',pseq),0)) {
w_errchk=0;
}
if (start && Eq(At(',opextc,',pseq),0)) {
w_opextc='N';
}
Link_XFVQTXPEXL(null);
if (start && Eq(At(',destfin,',pseq),0)) {
w_destfin='O';
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
_Obli('nomefile',0,'ZFBIYQMSFL',false)
_Obli('tipodest',0,'WIRRRKLEWO',false)
_Obli('opextc',0,'JAKNEJNBKZ',false)
_Obli('codmage',0,'XFVQTXPEXL',false,"11148783093")
_Obli('destfin',0,'RQAECCWOBF',false)
