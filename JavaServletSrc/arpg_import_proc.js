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
if(c=Ctrl('SIDIVTTNJS')) c.value = WtH(w_annorif,'N',4,0,'')
if(c=Ctrl('CFNJOPFSQY')) ChkboxCheckUncheck(c,'S',w_chkaui)
if(c=Ctrl('CFNJOPFSQY')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('WWEZMGEFAG')) ChkboxCheckUncheck(c,'S',w_imperr)
if(c=Ctrl('WWEZMGEFAG')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('XLIPQLYHVI')) ChkboxCheckUncheck(c,'S',w_flgscad)
if(c=Ctrl('XLIPQLYHVI')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('QLXXCYGEDK')) ChkboxCheckUncheck(c,'S',w_flgaggfam)
if(c=Ctrl('QLXXCYGEDK')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay(Ctrl('FGMOCXNBFY'),true);
SetDisplay(Ctrl('RVRMUTKMAU'),Eq(w_gTelepass,'5'));
SetDisplay(Ctrl('GYZZZNIYKJ'),Ne(w_gTelepass,'3') && Ne(w_gTelepass,'1'));
SetDisplay('JAKNEJNBKZ_DIV',Ne(w_gTelepass,'5'));
SetDisplay(Ctrl('TIIMQHOLUY'),Ne(w_gTelepass,'5'));
SetDisplay(Ctrl('SIDIVTTNJS'),Ne(w_gFlgCMod,'S') || IsHiddenByStateDriver('annorif'));
SetDisplay(Ctrl('QETNOGRJRL'),Ne(w_gFlgCMod,'S'));
SetDisplay(Ctrl('GPCVFHRPCD'),Eq(w_chkaui,'N'));
SetDisplay(Ctrl('DMWAJLXSEC'),Eq(w_fscarti,0));
SetDisplay('XLIPQLYHVI_DIV',Ne(w_gTelepass,'5'));
HideUI();
}
HideUI.lblids["annorif"]=['QETNOGRJRL'];
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
function DZUBEERBGN_Click() {
_modifyandopen(ToResource('servlet/sp_huploadfile'+'?pDirectory='+URLenc('appo')+'&pAtExit='+URLenc('Return')+'&pVarReturn='+URLenc('nomefile')+'&m_cParameterSequence=pDirectory,pAtExit,pVarReturn')+'&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null)
}
function WIRRRKLEWO_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_tipodest(HtW(getRadioValue(Ctrl('WIRRRKLEWO')),'C'),null,e);
}
function href_RVRMUTKMAU() {
var l_oWv = InitWvApplet();
l_oWv.setValue('ReportName',AsAppletValue('arrp_stp_errimp'));
l_oWv.setValue('outputFormat',AsAppletValue('PDF'));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('ReportName,outputFormat'));
_modifyandopen('Report'+'?m_cWv='+URLenc(l_oWv.asString())+'&m_cAction=start&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null)
}
function href_XWPYHZIJDE() {
LanciaImport()
}
function href_GYZZZNIYKJ() {
SetLocationHref(null,'arrt_imp_dati_storico_exam'+'?m_cAction=start&m_cAtExit=close&m_cMode=hyperlink','elaborazione')
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
function href_TIIMQHOLUY() {
var l_oWv = InitWvApplet();
l_oWv.setValue('ReportName',AsAppletValue('arrp_stp_errimp_wu'));
l_oWv.setValue('outputFormat',AsAppletValue('PDF'));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('ReportName,outputFormat'));
_modifyandopen('Report'+'?m_cWv='+URLenc(l_oWv.asString())+'&m_cAction=start&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null)
}
function SIDIVTTNJS_Valid(e) {
SetActiveField(Ctrl('SIDIVTTNJS'),false);
e=(Ne(e,null)?e:window.event);
return Set_annorif(HtW(Ctrl('SIDIVTTNJS').value,'N'),null,e);
}
function SIDIVTTNJS_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('SIDIVTTNJS'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('SIDIVTTNJS'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('SIDIVTTNJS'),e);
}
function CFNJOPFSQY_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_chkaui(ChkboxValueAssign(Ctrl('CFNJOPFSQY'),'S','N','C',1,0,''),null,e);
}
function CFNJOPFSQY_OnFocus(e) {
SetActiveField(Ctrl('CFNJOPFSQY'),true);
}
function CFNJOPFSQY_OnBlur(e) {
SetActiveField(Ctrl('CFNJOPFSQY'),false);
}
function href_GPCVFHRPCD() {
var l_oWv = InitWvApplet();
l_oWv.setValue('ReportName',AsAppletValue('arrp_stp_errimp_pers'));
l_oWv.setValue('outputFormat',AsAppletValue('PDF'));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('ReportName,outputFormat'));
_modifyandopen('Report'+'?m_cWv='+URLenc(l_oWv.asString())+'&m_cAction=start&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null)
}
function WWEZMGEFAG_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_imperr(ChkboxValueAssign(Ctrl('WWEZMGEFAG'),'S','N','C',1,0,''),null,e);
}
function WWEZMGEFAG_OnFocus(e) {
SetActiveField(Ctrl('WWEZMGEFAG'),true);
}
function WWEZMGEFAG_OnBlur(e) {
SetActiveField(Ctrl('WWEZMGEFAG'),false);
}
function href_JSKZJOHJOM() {
SetLocationHref(window.location,ToResource('jsp/start_page_logo_portlet.jsp'+'')+'')
}
function href_DMWAJLXSEC() {
_modifyandopen(ToResource('jsp/list_filesid_portlet.jsp'+'')+'?m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes,height=640,width=800',null)
}
function XLIPQLYHVI_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_flgscad(ChkboxValueAssign(Ctrl('XLIPQLYHVI'),'S','N','C',1,0,''),null,e);
}
function XLIPQLYHVI_OnFocus(e) {
SetActiveField(Ctrl('XLIPQLYHVI'),true);
}
function XLIPQLYHVI_OnBlur(e) {
SetActiveField(Ctrl('XLIPQLYHVI'),false);
}
function QLXXCYGEDK_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_flgaggfam(ChkboxValueAssign(Ctrl('QLXXCYGEDK'),'S','N','C',1,0,''),null,e);
}
function QLXXCYGEDK_OnFocus(e) {
SetActiveField(Ctrl('QLXXCYGEDK'),true);
}
function QLXXCYGEDK_OnBlur(e) {
SetActiveField(Ctrl('QLXXCYGEDK'),false);
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
if(c=Ctrl('SIDIVTTNJS')) c.onblur=SIDIVTTNJS_Valid;
if(c=Ctrl('SIDIVTTNJS')) c.onfocus=SIDIVTTNJS_OnFocus;
if(c=Ctrl('SIDIVTTNJS')) c.onkeypress=CheckNum;
if(c=Ctrl('CFNJOPFSQY')) c.onclick=CFNJOPFSQY_Valid;
if(c=Ctrl('CFNJOPFSQY')) c.onfocus=CFNJOPFSQY_OnFocus;
if(c=Ctrl('CFNJOPFSQY')) c.onblur=CFNJOPFSQY_OnBlur;
if(c=Ctrl('WWEZMGEFAG')) c.onclick=WWEZMGEFAG_Valid;
if(c=Ctrl('WWEZMGEFAG')) c.onfocus=WWEZMGEFAG_OnFocus;
if(c=Ctrl('WWEZMGEFAG')) c.onblur=WWEZMGEFAG_OnBlur;
if(c=Ctrl('XLIPQLYHVI')) c.onclick=XLIPQLYHVI_Valid;
if(c=Ctrl('XLIPQLYHVI')) c.onfocus=XLIPQLYHVI_OnFocus;
if(c=Ctrl('XLIPQLYHVI')) c.onblur=XLIPQLYHVI_OnBlur;
if(c=Ctrl('QLXXCYGEDK')) c.onclick=QLXXCYGEDK_Valid;
if(c=Ctrl('QLXXCYGEDK')) c.onfocus=QLXXCYGEDK_OnFocus;
if(c=Ctrl('QLXXCYGEDK')) c.onblur=QLXXCYGEDK_OnBlur;
}
}
function NotifyEvent(p_cEvent) {
var old_c;
if (Ne(typeof(w_Messaggi),'undefined')) {
w_Messaggi.raiseEvent('arpg_import_'+Strtran(p_cEvent,' ','_'));
}
if (Ne(typeof(w_Log),'undefined')) {
w_Log.raiseEvent('arpg_import_'+Strtran(p_cEvent,' ','_'));
}
if (Ne(typeof(w_ListaFile),'undefined')) {
w_ListaFile.raiseEvent('arpg_import_'+Strtran(p_cEvent,' ','_'));
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
windowOpenForeground('../doc/arpg_import_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_opextc=a[6];
w_xMADESCRI=a[7];
w_xMAFLGRAP=a[8];
w_xMAFLGBON=a[9];
w_xMAFLGCKR=a[10];
w_xMAFLGASR=a[11];
w_annorif=a[12];
w_chkaui=a[13];
w_imperr=a[14];
w_gAzienda=a[15];
w_gPathApp=a[16];
w_fscarti=a[17];
w_xMADIPSTD=a[18];
w_flgscad=a[19];
w_flgaggfam=a[20];
o_nomefile=w_nomefile[1];
w_nomefile=w_nomefile[0];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_import',m_cSelectedPage);
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
function Set_imperr(ctrlValue,kmode,e) {
if (Ne(w_imperr,ctrlValue)) {
var ctl = _GetCtl(e,'WWEZMGEFAG');
if (_tracker.goon(ctl,ctrlValue)) {
w_imperr=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('WWEZMGEFAG',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_chkaui(ctrlValue,kmode,e) {
if (Ne(w_chkaui,ctrlValue)) {
var ctl = _GetCtl(e,'CFNJOPFSQY');
if (_tracker.goon(ctl,ctrlValue)) {
w_chkaui=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CFNJOPFSQY',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_flgaggfam(ctrlValue,kmode,e) {
if (Ne(w_flgaggfam,ctrlValue)) {
var ctl = _GetCtl(e,'QLXXCYGEDK');
if (_tracker.goon(ctl,ctrlValue)) {
w_flgaggfam=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QLXXCYGEDK',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_flgscad(ctrlValue,kmode,e) {
if (Ne(w_flgscad,ctrlValue)) {
var ctl = _GetCtl(e,'XLIPQLYHVI');
if (_tracker.goon(ctl,ctrlValue)) {
w_flgscad=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XLIPQLYHVI',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_annorif(ctrlValue,kmode,e) {
if (Ne(w_annorif,ctrlValue)) {
var ctl = _GetCtl(e,'SIDIVTTNJS');
if (_tracker.goon(ctl,ctrlValue)) {
w_annorif=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SIDIVTTNJS',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','N',4,0,'');
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
w_Messaggi.Calculate(w_nomefile);
if ((Ne(o_nomefile,w_nomefile))) {
Calculation_UGPCNPTDJO();
}
// * --- Area Manuale = UI - Calculate
// * --- Fine Area Manuale
m_bCalculating=false;
}
function Calculation_UGPCNPTDJO() {
arrt_import([["w_rfile",w_nomefile]])
}
function SaveDependsOn() {
o_nomefile=w_nomefile;
}
function SaveLabelDependsOn() {
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
} else if ( ! (_ChkObl('SIDIVTTNJS',1))) {
_SignErr('SIDIVTTNJS');
m_cLastWorkVarErrorMsg='863017169';
l_bResult=false;
w_annorif=HtW('','N');
} else if ( ! (_ChkObl('CFNJOPFSQY',1))) {
_SignErr('CFNJOPFSQY');
m_cLastWorkVarErrorMsg='chkaui';
l_bResult=false;
w_chkaui='N';
} else if ( ! (_ChkObl('WWEZMGEFAG',1))) {
_SignErr('WWEZMGEFAG');
m_cLastWorkVarErrorMsg='imperr';
l_bResult=false;
w_imperr='N';
} else if ( ! (_ChkObl('XLIPQLYHVI',1))) {
_SignErr('XLIPQLYHVI');
m_cLastWorkVarErrorMsg='flgscad';
l_bResult=false;
w_flgscad='N';
} else if ( ! (_ChkObl('QLXXCYGEDK',1))) {
_SignErr('QLXXCYGEDK');
m_cLastWorkVarErrorMsg='flgaggfam';
l_bResult=false;
w_flgaggfam='N';
}
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
l_oWv.setValue('opextc',WtA(w_opextc,'C'));
l_oWv.setValue('xMADESCRI',WtA(w_xMADESCRI,'C'));
l_oWv.setValue('xMAFLGRAP',WtA(w_xMAFLGRAP,'C'));
l_oWv.setValue('xMAFLGBON',WtA(w_xMAFLGBON,'C'));
l_oWv.setValue('xMAFLGCKR',WtA(w_xMAFLGCKR,'C'));
l_oWv.setValue('xMAFLGASR',WtA(w_xMAFLGASR,'C'));
l_oWv.setValue('annorif',WtA(w_annorif,'N'));
l_oWv.setValue('chkaui',WtA(w_chkaui,'C'));
l_oWv.setValue('imperr',WtA(w_imperr,'C'));
l_oWv.setValue('gAzienda',WtA(w_gAzienda,'C'));
l_oWv.setValue('gPathApp',WtA(w_gPathApp,'C'));
l_oWv.setValue('fscarti',WtA(w_fscarti,'N'));
l_oWv.setValue('xMADIPSTD',WtA(w_xMADIPSTD,'C'));
l_oWv.setValue('flgscad',WtA(w_flgscad,'C'));
l_oWv.setValue('flgaggfam',WtA(w_flgaggfam,'C'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["nomefile","tipodest","impzip","errchk","gTelepass","gFlgCMod","opextc","xMADESCRI","xMAFLGRAP","xMAFLGBON","xMAFLGCKR","xMAFLGASR","annorif","chkaui","imperr","gAzienda","gPathApp","fscarti","xMADIPSTD","flgscad","flgaggfam"];
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
if (Empty(w_fscarti) && Ne(opener.w_fscarti,null)) {
TransferBetweenWindows(opener,'w_fscarti','w_fscarti');
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
if (start && Eq(At(',chkaui,',pseq),0)) {
w_chkaui='N';
}
if (start && Eq(At(',imperr,',pseq),0)) {
w_imperr='N';
}
if (start && Eq(At(',flgscad,',pseq),0)) {
w_flgscad='S';
}
if (start && Eq(At(',flgaggfam,',pseq),0)) {
w_flgaggfam='N';
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
_Obli('imperr',0,'WWEZMGEFAG',false)
_Obli('chkaui',0,'CFNJOPFSQY',false)
_Obli('flgaggfam',0,'QLXXCYGEDK',false)
_Obli('flgscad',0,'XLIPQLYHVI',false)
_Obli('annorif',1,'SIDIVTTNJS',false,"863017169")
