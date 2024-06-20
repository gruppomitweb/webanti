function SetControlsValue() {
var c;
var c;
if(c=Ctrl('PYGHSMNTBK')) c.value = WtH(w_annoope,'N',4,0,'')
var tmp_FGMOCXNBFY = ToHTag(AsControlValue('<iframe width=\'655\' height=\'170\' id=\'elaborazione\'  name=\'elaborazione\' frameborder=\'1\'  border=\'1\' align=\'TOP\' marginwidth=\'1\' marginheight=\'1\'></iframe>'));
if (Ne(e_FGMOCXNBFY,tmp_FGMOCXNBFY)) {
if(c=Ctrl('FGMOCXNBFY')) c.innerHTML=tmp_FGMOCXNBFY;
e_FGMOCXNBFY=tmp_FGMOCXNBFY;
}
if(c=Ctrl('TJVNAGXDHC')) c.value = WtH(w_CONNES,'C',16,0,'')
var tmp_ECTSKPAITW = ToHTag(AsControlValue(w_risultato));
if (Ne(e_ECTSKPAITW,tmp_ECTSKPAITW)) {
if(c=Ctrl('ECTSKPAITW')) c.innerHTML=tmp_ECTSKPAITW;
e_ECTSKPAITW=tmp_ECTSKPAITW;
}
if(c=Ctrl('UZRTJOSGKO')) c.value = WtH(w_imppagato,'N',15,0,'999,999,999,999,999')
if(c=Ctrl('JMXZJMDMQD')) c.value = WtH(w_impricevuto,'N',15,0,'999,999,999,999,999')
if(c=Ctrl('PQQLWYGYIO')) c.value = WtH(w_numope,'N',6,0,'999,999')
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay(Ctrl('FGMOCXNBFY'),true);
SetDisplay(Ctrl('TJVNAGXDHC'),true || IsHiddenByStateDriver('CONNES'));
HideUI();
}
HideUI.lblids["annoope"]=['BAATYILHGP','ECTSKPAITW'];
HideUI.lblids["imppagato"]=['YCJUXVPSFR'];
HideUI.lblids["impricevuto"]=['EOVQUSEKTN'];
HideUI.lblids["numope"]=['QWEMBZCGWM'];
function href_ZQEKBHAOQV() {
if (false || WindowConfirm(Translate('11271491468'))) {
window.close()
}
}
function PYGHSMNTBK_Valid(e) {
SetActiveField(Ctrl('PYGHSMNTBK'),false);
e=(Ne(e,null)?e:window.event);
return Set_annoope(HtW(Ctrl('PYGHSMNTBK').value,'N'),null,e);
}
function PYGHSMNTBK_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('PYGHSMNTBK'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('PYGHSMNTBK'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('PYGHSMNTBK'),e);
}
function href_GJGIOZNGOM() {
if (false || WindowConfirm(Translate('502986441'))) {
SetLocationHref(null,'arrt_saldi_oro'+'?m_cAction=start&m_cMode=hyperlink','elaborazione')
}
}
function TJVNAGXDHC_Valid(e) {
SetActiveField(Ctrl('TJVNAGXDHC'),false);
e=(Ne(e,null)?e:window.event);
return Set_CONNES(HtW(Ctrl('TJVNAGXDHC').value,'C'),null,e);
}
function TJVNAGXDHC_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('TJVNAGXDHC'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('TJVNAGXDHC'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('TJVNAGXDHC'),e);
}
function UZRTJOSGKO_Valid(e) {
SetActiveField(Ctrl('UZRTJOSGKO'),false);
e=(Ne(e,null)?e:window.event);
return Set_imppagato(HtW(Ctrl('UZRTJOSGKO').value,'N'),null,e);
}
function UZRTJOSGKO_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('UZRTJOSGKO'))) {
DisplayErrorMessage();
}
Ctrl('UZRTJOSGKO').value=WtH(w_imppagato,'N',15,0,'999999999999999');
SetActiveField(Ctrl('UZRTJOSGKO'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('UZRTJOSGKO'),e);
}
function UZRTJOSGKO_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("999999999999999"));
}
function JMXZJMDMQD_Valid(e) {
SetActiveField(Ctrl('JMXZJMDMQD'),false);
e=(Ne(e,null)?e:window.event);
return Set_impricevuto(HtW(Ctrl('JMXZJMDMQD').value,'N'),null,e);
}
function JMXZJMDMQD_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('JMXZJMDMQD'))) {
DisplayErrorMessage();
}
Ctrl('JMXZJMDMQD').value=WtH(w_impricevuto,'N',15,0,'999999999999999');
SetActiveField(Ctrl('JMXZJMDMQD'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('JMXZJMDMQD'),e);
}
function JMXZJMDMQD_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("999999999999999"));
}
function PQQLWYGYIO_Valid(e) {
SetActiveField(Ctrl('PQQLWYGYIO'),false);
e=(Ne(e,null)?e:window.event);
return Set_numope(HtW(Ctrl('PQQLWYGYIO').value,'N'),null,e);
}
function PQQLWYGYIO_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('PQQLWYGYIO'))) {
DisplayErrorMessage();
}
Ctrl('PQQLWYGYIO').value=WtH(w_numope,'N',6,0,'999999');
SetActiveField(Ctrl('PQQLWYGYIO'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('PQQLWYGYIO'),e);
}
function PQQLWYGYIO_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("999999"));
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
if(c=Ctrl('PYGHSMNTBK')) c.onblur=PYGHSMNTBK_Valid;
if(c=Ctrl('PYGHSMNTBK')) c.onfocus=PYGHSMNTBK_OnFocus;
if(c=Ctrl('PYGHSMNTBK')) c.onkeypress=CheckNum;
if(c=Ctrl('TJVNAGXDHC')) c.onblur=TJVNAGXDHC_Valid;
if(c=Ctrl('TJVNAGXDHC')) c.onfocus=TJVNAGXDHC_OnFocus;
if(c=Ctrl('UZRTJOSGKO')) c.onblur=UZRTJOSGKO_Valid;
if(c=Ctrl('UZRTJOSGKO')) c.onfocus=UZRTJOSGKO_OnFocus;
if(c=Ctrl('UZRTJOSGKO')) c.onkeypress=UZRTJOSGKO_CheckNumWithPict;
if(c=Ctrl('JMXZJMDMQD')) c.onblur=JMXZJMDMQD_Valid;
if(c=Ctrl('JMXZJMDMQD')) c.onfocus=JMXZJMDMQD_OnFocus;
if(c=Ctrl('JMXZJMDMQD')) c.onkeypress=JMXZJMDMQD_CheckNumWithPict;
if(c=Ctrl('PQQLWYGYIO')) c.onblur=PQQLWYGYIO_Valid;
if(c=Ctrl('PQQLWYGYIO')) c.onfocus=PQQLWYGYIO_OnFocus;
if(c=Ctrl('PQQLWYGYIO')) c.onkeypress=PQQLWYGYIO_CheckNumWithPict;
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
FocusFirstComponent.otherwise={"page_1":["PYGHSMNTBK"]};
function Help() {
windowOpenForeground('../doc/aprg_saldi_oro_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_annoope=a[0];
w_CONNES=a[1];
w_risultato=a[2];
w_imppagato=a[3];
w_impricevuto=a[4];
w_numope=a[5];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('aprg_saldi_oro',m_cSelectedPage);
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
function Set_annoope(ctrlValue,kmode,e) {
if (Ne(w_annoope,ctrlValue)) {
var ctl = _GetCtl(e,'PYGHSMNTBK');
if (_tracker.goon(ctl,ctrlValue)) {
w_annoope=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('PYGHSMNTBK',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','N',4,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_CONNES(ctrlValue,kmode,e) {
if (Ne(w_CONNES,ctrlValue)) {
var ctl = _GetCtl(e,'TJVNAGXDHC');
if (_tracker.goon(ctl,ctrlValue)) {
w_CONNES=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('TJVNAGXDHC',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',16,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_numope(ctrlValue,kmode,e) {
if (Ne(w_numope,ctrlValue)) {
var ctl = _GetCtl(e,'PQQLWYGYIO');
if (_tracker.goon(ctl,ctrlValue)) {
w_numope=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('PQQLWYGYIO',0);
DoUpdate(l_bResult);
if(c=Ctrl('PQQLWYGYIO')) c.value = WtH(w_numope,'N',6,0,'999,999')
} else {
ctl.value=WtH('','N',6,0,'999999');
_ResetTracker();
return true;
}
} else {
if(c=Ctrl('PQQLWYGYIO')) c.value = WtH(w_numope,'N',6,0,'999,999')
}
return true;
}
function Set_imppagato(ctrlValue,kmode,e) {
if (Ne(w_imppagato,ctrlValue)) {
var ctl = _GetCtl(e,'UZRTJOSGKO');
if (_tracker.goon(ctl,ctrlValue)) {
w_imppagato=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UZRTJOSGKO',0);
DoUpdate(l_bResult);
if(c=Ctrl('UZRTJOSGKO')) c.value = WtH(w_imppagato,'N',15,0,'999,999,999,999,999')
} else {
ctl.value=WtH('','N',15,0,'999999999999999');
_ResetTracker();
return true;
}
} else {
if(c=Ctrl('UZRTJOSGKO')) c.value = WtH(w_imppagato,'N',15,0,'999,999,999,999,999')
}
return true;
}
function Set_impricevuto(ctrlValue,kmode,e) {
if (Ne(w_impricevuto,ctrlValue)) {
var ctl = _GetCtl(e,'JMXZJMDMQD');
if (_tracker.goon(ctl,ctrlValue)) {
w_impricevuto=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('JMXZJMDMQD',0);
DoUpdate(l_bResult);
if(c=Ctrl('JMXZJMDMQD')) c.value = WtH(w_impricevuto,'N',15,0,'999,999,999,999,999')
} else {
ctl.value=WtH('','N',15,0,'999999999999999');
_ResetTracker();
return true;
}
} else {
if(c=Ctrl('JMXZJMDMQD')) c.value = WtH(w_impricevuto,'N',15,0,'999,999,999,999,999')
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
if ( ! (_ChkObl('PYGHSMNTBK',1))) {
_SignErr('PYGHSMNTBK');
m_cLastWorkVarErrorMsg='484641';
l_bResult=false;
w_annoope=HtW('','N');
} else if ( ! (_ChkObl('TJVNAGXDHC',1))) {
_SignErr('TJVNAGXDHC');
m_cLastWorkVarErrorMsg='CONNES';
l_bResult=false;
w_CONNES=HtW('','C');
} else if ( ! (_ChkObl('UZRTJOSGKO',1))) {
_SignErr('UZRTJOSGKO');
m_cLastWorkVarErrorMsg='1036547170';
l_bResult=false;
w_imppagato=HtW('','N');
} else if ( ! (_ChkObl('JMXZJMDMQD',1))) {
_SignErr('JMXZJMDMQD');
m_cLastWorkVarErrorMsg='1939886652';
l_bResult=false;
w_impricevuto=HtW('','N');
} else if ( ! (_ChkObl('PQQLWYGYIO',1))) {
_SignErr('PQQLWYGYIO');
m_cLastWorkVarErrorMsg='11904235142';
l_bResult=false;
w_numope=HtW('','N');
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
l_oWv.setValue('annoope',WtA(w_annoope,'N'));
l_oWv.setValue('CONNES',WtA(w_CONNES,'C'));
l_oWv.setValue('risultato',WtA(w_risultato,'C'));
l_oWv.setValue('imppagato',WtA(w_imppagato,'N'));
l_oWv.setValue('impricevuto',WtA(w_impricevuto,'N'));
l_oWv.setValue('numope',WtA(w_numope,'N'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["annoope","CONNES","risultato","imppagato","impricevuto","numope"];
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
if (Empty(w_annoope) && Ne(opener.w_annoope,null)) {
TransferBetweenWindows(opener,'w_annoope',null,'Set_annoope');
}
if (Empty(w_CONNES) && Ne(opener.w_CONNES,null)) {
TransferBetweenWindows(opener,'w_CONNES',null,'Set_CONNES');
}
if (Empty(w_risultato) && Ne(opener.w_risultato,null)) {
TransferBetweenWindows(opener,'w_risultato','w_risultato');
}
}
}
m_bCalculating=true;
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
_Obli('annoope',1,'PYGHSMNTBK',false,"484641")
_Obli('CONNES',0,'TJVNAGXDHC',false)
_Obli('numope',1,'PQQLWYGYIO',false,"11904235142")
_Obli('imppagato',1,'UZRTJOSGKO',false,"1036547170")
_Obli('impricevuto',1,'JMXZJMDMQD',false,"1939886652")
