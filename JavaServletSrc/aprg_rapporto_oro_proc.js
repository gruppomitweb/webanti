function SetControlsValue() {
var c;
var c;
if(c=Ctrl('PYGHSMNTBK')) c.value = WtH(w_dataope,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
var tmp_FGMOCXNBFY = ToHTag(AsControlValue('<iframe width=\'655\' height=\'170\' id=\'elaborazione\'  name=\'elaborazione\' frameborder=\'1\'  border=\'1\' align=\'TOP\' marginwidth=\'1\' marginheight=\'1\'></iframe>'));
if (Ne(e_FGMOCXNBFY,tmp_FGMOCXNBFY)) {
if(c=Ctrl('FGMOCXNBFY')) c.innerHTML=tmp_FGMOCXNBFY;
e_FGMOCXNBFY=tmp_FGMOCXNBFY;
}
if(c=Ctrl('IHCYXKNNTS')) ChkboxCheckUncheck(c,'S',w_FLGCLOSE)
if(c=Ctrl('IHCYXKNNTS')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('TJVNAGXDHC')) c.value = WtH(w_CONNES,'C',16,0,'')
var tmp_ECTSKPAITW = ToHTag(AsControlValue(w_risultato));
if (Ne(e_ECTSKPAITW,tmp_ECTSKPAITW)) {
if(c=Ctrl('ECTSKPAITW')) c.innerHTML=tmp_ECTSKPAITW;
e_ECTSKPAITW=tmp_ECTSKPAITW;
}
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
HideUI.lblids["dataope"]=['BAATYILHGP','ECTSKPAITW'];
function href_ZQEKBHAOQV() {
if (false || WindowConfirm(Translate('11271491468'))) {
window.close()
}
}
function PYGHSMNTBK_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('PYGHSMNTBK'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('PYGHSMNTBK').value=ApplyPictureToDate(Ctrl('PYGHSMNTBK').value,TranslatePicture(datePattern),'PYGHSMNTBK');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('PYGHSMNTBK'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('PYGHSMNTBK');
}
}
}
SetActiveField(Ctrl('PYGHSMNTBK'),false);
e=(Ne(e,null)?e:window.event);
return Set_dataope(HtW(Ctrl('PYGHSMNTBK').value,'D'),null,e) && dateisok;
}
function PYGHSMNTBK_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('PYGHSMNTBK'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('PYGHSMNTBK').value=WtH(w_dataope,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('PYGHSMNTBK');
SetActiveField(Ctrl('PYGHSMNTBK'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('PYGHSMNTBK'),e);
}
function href_GJGIOZNGOM() {
if (false || WindowConfirm(Translate('99923805'))) {
SalvaDati()
}
}
function IHCYXKNNTS_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_FLGCLOSE(ChkboxValueAssign(Ctrl('IHCYXKNNTS'),'S','N','C',1,0,''),null,e);
}
function IHCYXKNNTS_OnFocus(e) {
SetActiveField(Ctrl('IHCYXKNNTS'),true);
}
function IHCYXKNNTS_OnBlur(e) {
SetActiveField(Ctrl('IHCYXKNNTS'),false);
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
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
if(c=Ctrl('PYGHSMNTBK')) c.onblur=PYGHSMNTBK_Valid;
if(c=Ctrl('PYGHSMNTBK')) c.onfocus=PYGHSMNTBK_OnFocus;
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
if(c=Ctrl('PYGHSMNTBK')) c.onkeypress=CheckDateChar;
}
if(c=Ctrl('IHCYXKNNTS')) c.onclick=IHCYXKNNTS_Valid;
if(c=Ctrl('IHCYXKNNTS')) c.onfocus=IHCYXKNNTS_OnFocus;
if(c=Ctrl('IHCYXKNNTS')) c.onblur=IHCYXKNNTS_OnBlur;
if(c=Ctrl('TJVNAGXDHC')) c.onblur=TJVNAGXDHC_Valid;
if(c=Ctrl('TJVNAGXDHC')) c.onfocus=TJVNAGXDHC_OnFocus;
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
windowOpenForeground('../doc/aprg_rapporto_oro_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_dataope=a[0];
w_FLGCLOSE=a[1];
w_CONNES=a[2];
w_risultato=a[3];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('aprg_rapporto_oro',m_cSelectedPage);
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
function Set_dataope(ctrlValue,kmode,e) {
if (Ne(w_dataope,ctrlValue)) {
var ctl = _GetCtl(e,'PYGHSMNTBK');
if (_tracker.goon(ctl,ctrlValue)) {
w_dataope=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('PYGHSMNTBK',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH(NullDate(),'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
_ResetTracker();
return true;
}
}
return true;
}
function Set_FLGCLOSE(ctrlValue,kmode,e) {
if (Ne(w_FLGCLOSE,ctrlValue)) {
var ctl = _GetCtl(e,'IHCYXKNNTS');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLGCLOSE=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('IHCYXKNNTS',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
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
m_cLastWorkVarErrorMsg='829201110';
l_bResult=false;
w_dataope=HtW('','D');
} else if ( ! (_ChkObl('IHCYXKNNTS',1))) {
_SignErr('IHCYXKNNTS');
m_cLastWorkVarErrorMsg='FLGCLOSE';
l_bResult=false;
w_FLGCLOSE='N';
} else if ( ! (_ChkObl('TJVNAGXDHC',1))) {
_SignErr('TJVNAGXDHC');
m_cLastWorkVarErrorMsg='CONNES';
l_bResult=false;
w_CONNES=HtW('','C');
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
l_oWv.setValue('dataope',WtA(w_dataope,'D'));
l_oWv.setValue('FLGCLOSE',WtA(w_FLGCLOSE,'C'));
l_oWv.setValue('CONNES',WtA(w_CONNES,'C'));
l_oWv.setValue('risultato',WtA(w_risultato,'C'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["dataope","FLGCLOSE","CONNES","risultato"];
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
if (Eq(w_dataope,SystemDate()) && Ne(opener.w_dataope,null)) {
TransferBetweenWindows(opener,'w_dataope',null,'Set_dataope');
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
if (start && Eq(At(',dataope,',pseq),0)) {
w_dataope=SystemDate();
}
if (start && Eq(At(',FLGCLOSE,',pseq),0)) {
w_FLGCLOSE='N';
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
_Obli('dataope',2,'PYGHSMNTBK',false,"829201110")
_Obli('FLGCLOSE',0,'IHCYXKNNTS',false)
_Obli('CONNES',0,'TJVNAGXDHC',false)
