function SetControlsValue() {
var c;
var c;
if(c=Ctrl('ZFBIYQMSFL')) c.value = WtH(w_nomefile,'C',100,0,'')
if(c=Ctrl('WIRRRKLEWO')) selectRadio(c,w_tipodest,'C')
var tmp_FGMOCXNBFY = ToHTag(AsControlValue('<iframe width=\'655\' height=\'170\' id=\'elaborazione\' name=\'elaborazione\' frameborder=\'1\'  border=\'1\' align=\'TOP\' marginwidth=\'1\' marginheight=\'1\'></iframe>'));
if (Ne(e_FGMOCXNBFY,tmp_FGMOCXNBFY)) {
if(c=Ctrl('FGMOCXNBFY')) c.innerHTML=tmp_FGMOCXNBFY;
e_FGMOCXNBFY=tmp_FGMOCXNBFY;
}
if(c=Ctrl('VMTTIZJBAT')) ChkboxCheckUncheck(c,'S',w_azzera)
if(c=Ctrl('VMTTIZJBAT')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('YCIQABGKVQ')) selectCombo(c,w_tipoimp,'C')
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay(Ctrl('FGMOCXNBFY'),true);
HideUI();
}
HideUI.lblids["tipodest"]=['NJQSNRJAXM'];
HideUI.lblids["tipoimp"]=['AZPRKDFFDL'];
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
function PIRPTHHLHK_Click() {
SetLocationHref(null,'arrt_imp_offline'+'?m_cAction=start&m_cMode=hyperlink','elaborazione')
}
function WIRRRKLEWO_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_tipodest(HtW(getRadioValue(Ctrl('WIRRRKLEWO')),'C'),null,e);
}
function VMTTIZJBAT_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_azzera(ChkboxValueAssign(Ctrl('VMTTIZJBAT'),'S','N','C',1,0,''),null,e);
}
function VMTTIZJBAT_OnFocus(e) {
SetActiveField(Ctrl('VMTTIZJBAT'),true);
}
function VMTTIZJBAT_OnBlur(e) {
SetActiveField(Ctrl('VMTTIZJBAT'),false);
}
function YCIQABGKVQ_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_tipoimp(HtW(getComboValue(Ctrl('YCIQABGKVQ')),'C'),null,e);
}
function YCIQABGKVQ_OnFocus(e) {
SetActiveField(Ctrl('YCIQABGKVQ'),true);
}
function YCIQABGKVQ_OnBlur(e) {
SetActiveField(Ctrl('YCIQABGKVQ'),false);
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
if(c=Ctrl('VMTTIZJBAT')) c.onclick=VMTTIZJBAT_Valid;
if(c=Ctrl('VMTTIZJBAT')) c.onfocus=VMTTIZJBAT_OnFocus;
if(c=Ctrl('VMTTIZJBAT')) c.onblur=VMTTIZJBAT_OnBlur;
if(c=Ctrl('YCIQABGKVQ')) c.onchange=YCIQABGKVQ_Valid;
if(c=Ctrl('YCIQABGKVQ')) c.onfocus=YCIQABGKVQ_OnFocus;
if(c=Ctrl('YCIQABGKVQ')) c.onblur=YCIQABGKVQ_OnBlur;
}
}
function NotifyEvent(p_cEvent) {
var old_c;
if (Ne(typeof(w_Messaggi),'undefined')) {
w_Messaggi.raiseEvent('arpg_imp_offline_bf_'+Strtran(p_cEvent,' ','_'));
}
if (Ne(typeof(w_Log),'undefined')) {
w_Log.raiseEvent('arpg_imp_offline_bf_'+Strtran(p_cEvent,' ','_'));
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
FocusFirstComponent.otherwise={"page_1":["ZFBIYQMSFL"]};
function Help() {
windowOpenForeground('../doc/arpg_imp_offline_bf_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_errchk=a[2];
w_azzera=a[3];
w_tipoimp=a[4];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_imp_offline_bf',m_cSelectedPage);
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
function Set_tipoimp(ctrlValue,kmode,e) {
if (Ne(w_tipoimp,ctrlValue)) {
var ctl = _GetCtl(e,'YCIQABGKVQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_tipoimp=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YCIQABGKVQ',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_azzera(ctrlValue,kmode,e) {
if (Ne(w_azzera,ctrlValue)) {
var ctl = _GetCtl(e,'VMTTIZJBAT');
if (_tracker.goon(ctl,ctrlValue)) {
w_azzera=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VMTTIZJBAT',0);
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
if ( ! (_ChkObl('ZFBIYQMSFL',1))) {
_SignErr('ZFBIYQMSFL');
m_cLastWorkVarErrorMsg='nomefile';
l_bResult=false;
w_nomefile=HtW('','C');
} else if ( ! (_ChkObl('WIRRRKLEWO',1))) {
_SignErr('WIRRRKLEWO');
m_cLastWorkVarErrorMsg='tipodest';
l_bResult=false;
w_tipodest=HtW('','C');
} else if ( ! (_ChkObl('VMTTIZJBAT',1))) {
_SignErr('VMTTIZJBAT');
m_cLastWorkVarErrorMsg='azzera';
l_bResult=false;
w_azzera='N';
} else if ( ! (_ChkObl('YCIQABGKVQ',1))) {
_SignErr('YCIQABGKVQ');
m_cLastWorkVarErrorMsg='tipoimp';
l_bResult=false;
w_tipoimp=HtW('','C');
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
l_oWv.setValue('errchk',WtA(w_errchk,'N'));
l_oWv.setValue('azzera',WtA(w_azzera,'C'));
l_oWv.setValue('tipoimp',WtA(w_tipoimp,'C'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["nomefile","tipodest","errchk","azzera","tipoimp"];
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
if (start && Eq(At(',errchk,',pseq),0)) {
w_errchk=1;
}
if (start && Eq(At(',azzera,',pseq),0)) {
w_azzera='N';
}
if (start && Eq(At(',tipoimp,',pseq),0)) {
w_tipoimp='S';
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
_Obli('tipoimp',0,'YCIQABGKVQ',false)
_Obli('azzera',0,'VMTTIZJBAT',false)
