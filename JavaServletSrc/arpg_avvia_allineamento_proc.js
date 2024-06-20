function SetControlsValue() {
var c;
var c;
if(c=Ctrl('VTJSPEZJHG')) selectRadio(c,w_tipoallin,'C')
var tmp_FGMOCXNBFY = ToHTag(AsControlValue('<iframe width=\'655\' height=\'170\' id=\'elaborazione\'  name=\'elaborazione\' frameborder=\'1\'  border=\'1\' align=\'TOP\' marginwidth=\'1\' marginheight=\'1\'></iframe>'));
if (Ne(e_FGMOCXNBFY,tmp_FGMOCXNBFY)) {
if(c=Ctrl('FGMOCXNBFY')) c.innerHTML=tmp_FGMOCXNBFY;
e_FGMOCXNBFY=tmp_FGMOCXNBFY;
}
var tmp_DUNRRHVMQA = ToHTag(AsControlValue('<iframe width=\'655\' height=\'170\' id=\'elaborazione\'  name=\'elaborazione\' frameborder=\'1\'  border=\'1\' align=\'TOP\' marginwidth=\'1\' marginheight=\'1\'></iframe>'));
if (Ne(e_DUNRRHVMQA,tmp_DUNRRHVMQA)) {
if(c=Ctrl('DUNRRHVMQA')) c.innerHTML=tmp_DUNRRHVMQA;
e_DUNRRHVMQA=tmp_DUNRRHVMQA;
}
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay(Ctrl('IDJTJNNMJB'),Eq(w_tipoallin,'A'));
SetDisplay(Ctrl('DUNRRHVMQA'),true);
HideUI();
}
function VTJSPEZJHG_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_tipoallin(HtW(getRadioValue(Ctrl('VTJSPEZJHG')),'C'),null,e);
}
function AINWJHQDUA_Click() {
SetLocationHref(null,'arrt_start_aa'+'?m_cAction=start&m_cMode=hyperlink','elaborazione')
}
function IDJTJNNMJB_Click() {
if (Eq(w_showdata,1)) {
var action = (Eq(Left('arpg_allinea_nome_cognome'+''+'?',24),'arpg_avvia_allineamento?')?'query':'start');
SetHypPar('m_cAction',AsAppletValue(action));
SetHypPar('m_cMode',AsAppletValue('hyperlink'));
SetHypPar('Countok',AsAppletValue(w_Countok));
SetHypPar('Countpr',AsAppletValue(w_Countpr));
SetHypPar('Countpr2',AsAppletValue(w_Countpr2));
SetHypPar('Countko',AsAppletValue(w_Countko));
SetHypPar('Countot',AsAppletValue(w_Countot));
SetHypPar('m_cParameterSequence',AsAppletValue('Countok,Countpr,Countpr2,Countko,Countot'));
SendData(action,'arpg_allinea_nome_cognome'+'',HParApplet().asString());
}
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
c=Ctrl('VTJSPEZJHG');
if ( ! (Empty(c))) {
c[0].onclick=VTJSPEZJHG_Valid;
c[1].onclick=VTJSPEZJHG_Valid;
}
}
}
function NotifyEvent(p_cEvent) {
var old_c;
if (Ne(typeof(w_Messaggi),'undefined')) {
w_Messaggi.raiseEvent('arpg_avvia_allineamento_'+Strtran(p_cEvent,' ','_'));
}
if (Ne(typeof(w_Log),'undefined')) {
w_Log.raiseEvent('arpg_avvia_allineamento_'+Strtran(p_cEvent,' ','_'));
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
FocusFirstComponent.otherwise={"page_1":["VTJSPEZJHG","AINWJHQDUA"]};
function Help() {
windowOpenForeground('../doc/arpg_avvia_allineamento_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_tipoallin=a[0];
w_showdata=a[1];
w_Countok=a[2];
w_Countko=a[3];
w_Countpr=a[4];
w_Countpr2=a[5];
w_Countot=a[6];
w_bloccaedit=a[7];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_avvia_allineamento',m_cSelectedPage);
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
l_bEnabled= ! (Eq(w_bloccaedit,'N')) || IsDisabledByStateDriver('tipoallin');
SetDisabled('VTJSPEZJHG_DIV',l_bEnabled);
l_bEnabled= ! (Eq(w_showdata,1));
SetDisabled(Ctrl('IDJTJNNMJB'),l_bEnabled);
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
function Set_tipoallin(ctrlValue,kmode,e) {
if (Ne(w_tipoallin,ctrlValue)) {
var ctl = _GetCtl(e,'VTJSPEZJHG');
if (_tracker.goon(ctl,ctrlValue)) {
w_tipoallin=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VTJSPEZJHG',0);
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
if ((Eq(w_bloccaedit,'N')) && ( ! (_ChkObl('VTJSPEZJHG',1)))) {
_SignErr('VTJSPEZJHG');
m_cLastWorkVarErrorMsg='tipoallin';
l_bResult=false;
w_tipoallin=HtW('','C');
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
l_oWv.setValue('tipoallin',WtA(w_tipoallin,'C'));
l_oWv.setValue('showdata',WtA(w_showdata,'N'));
l_oWv.setValue('Countok',WtA(w_Countok,'N'));
l_oWv.setValue('Countko',WtA(w_Countko,'N'));
l_oWv.setValue('Countpr',WtA(w_Countpr,'N'));
l_oWv.setValue('Countpr2',WtA(w_Countpr2,'N'));
l_oWv.setValue('Countot',WtA(w_Countot,'N'));
l_oWv.setValue('bloccaedit',WtA(w_bloccaedit,'C'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["tipoallin","showdata","Countok","Countko","Countpr","Countpr2","Countot","bloccaedit"];
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
if (Eq(w_tipoallin,'A') && Ne(opener.w_tipoallin,null)) {
TransferBetweenWindows(opener,'w_tipoallin',null,'Set_tipoallin');
}
if (Eq(w_showdata,0) && Ne(opener.w_showdata,null)) {
TransferBetweenWindows(opener,'w_showdata','w_showdata');
}
if (Empty(w_Countok) && Ne(opener.w_Countok,null)) {
TransferBetweenWindows(opener,'w_Countok','w_Countok');
}
if (Empty(w_Countko) && Ne(opener.w_Countko,null)) {
TransferBetweenWindows(opener,'w_Countko','w_Countko');
}
if (Empty(w_Countpr) && Ne(opener.w_Countpr,null)) {
TransferBetweenWindows(opener,'w_Countpr','w_Countpr');
}
if (Empty(w_Countpr2) && Ne(opener.w_Countpr2,null)) {
TransferBetweenWindows(opener,'w_Countpr2','w_Countpr2');
}
if (Empty(w_Countot) && Ne(opener.w_Countot,null)) {
TransferBetweenWindows(opener,'w_Countot','w_Countot');
}
}
}
m_bCalculating=true;
if (start && Eq(At(',tipoallin,',pseq),0)) {
w_tipoallin='A';
}
if (start && Eq(At(',showdata,',pseq),0)) {
w_showdata=0;
}
if (start && Eq(At(',bloccaedit,',pseq),0)) {
w_bloccaedit='N';
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
_Obli('tipoallin',0,'VTJSPEZJHG',false)
