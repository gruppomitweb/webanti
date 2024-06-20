function SetControlsValue() {
var c;
var c;
if(c=Ctrl('DVEINHNUIU')) selectRadio(c,w_criterio,'C')
if(c=Ctrl('OGOQGXTPFZ')) c.value = WtH(w_denomin,'C',60,0,'@!')
if(c=Ctrl('HYWEOCPLDV')) c.value = WtH(w_simili,'C',60,0,'@!')
if(c=Ctrl('MHPJNXSEVS')) ChkboxCheckUncheck(c,'S',w_flgnote)
if(c=Ctrl('MHPJNXSEVS')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('YUZVRERQCX')) ChkboxCheckUncheck(c,'S',w_flgnega)
if(c=Ctrl('YUZVRERQCX')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('RKIGHRRPIV')) ChkboxCheckUncheck(c,'S',w_flgafon)
if(c=Ctrl('RKIGHRRPIV')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
HideUI();
}
HideUI.lblids["denomin"]=['XAIXXQEWZV'];
HideUI.lblids["simili"]=['VWRAKBXWXU'];
function DVEINHNUIU_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_criterio(HtW(getRadioValue(Ctrl('DVEINHNUIU')),'C'),null,e);
}
function OGOQGXTPFZ_Valid(e) {
SetActiveField(Ctrl('OGOQGXTPFZ'),false);
e=(Ne(e,null)?e:window.event);
return Set_denomin(HtW(Ctrl('OGOQGXTPFZ').value,'C'),null,e);
}
function OGOQGXTPFZ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('OGOQGXTPFZ'))) {
DisplayErrorMessage();
}
Ctrl('OGOQGXTPFZ').value=WtH(w_denomin,'C',60,0,'@!');
SetActiveField(Ctrl('OGOQGXTPFZ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('OGOQGXTPFZ'),e);
}
function OGOQGXTPFZ_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("@!"));
}
function HYWEOCPLDV_Valid(e) {
SetActiveField(Ctrl('HYWEOCPLDV'),false);
e=(Ne(e,null)?e:window.event);
return Set_simili(HtW(Ctrl('HYWEOCPLDV').value,'C'),null,e);
}
function HYWEOCPLDV_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('HYWEOCPLDV'))) {
DisplayErrorMessage();
}
Ctrl('HYWEOCPLDV').value=WtH(w_simili,'C',60,0,'@!');
SetActiveField(Ctrl('HYWEOCPLDV'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('HYWEOCPLDV'),e);
}
function HYWEOCPLDV_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("@!"));
}
function MHPJNXSEVS_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_flgnote(ChkboxValueAssign(Ctrl('MHPJNXSEVS'),'S','N','C',1,0,''),null,e);
}
function MHPJNXSEVS_OnFocus(e) {
SetActiveField(Ctrl('MHPJNXSEVS'),true);
}
function MHPJNXSEVS_OnBlur(e) {
SetActiveField(Ctrl('MHPJNXSEVS'),false);
}
function YUZVRERQCX_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_flgnega(ChkboxValueAssign(Ctrl('YUZVRERQCX'),'S','N','C',1,0,''),null,e);
}
function YUZVRERQCX_OnFocus(e) {
SetActiveField(Ctrl('YUZVRERQCX'),true);
}
function YUZVRERQCX_OnBlur(e) {
SetActiveField(Ctrl('YUZVRERQCX'),false);
}
function href_QAHPPFTUDE() {
_modifyandopen('aosrt_ricerca_sogg_web'+'?m_cAction=start&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null)
}
function href_GIRPQCWOKQ() {
window.close()
}
function RKIGHRRPIV_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_flgafon(ChkboxValueAssign(Ctrl('RKIGHRRPIV'),'S','N','C',1,0,''),null,e);
}
function RKIGHRRPIV_OnFocus(e) {
SetActiveField(Ctrl('RKIGHRRPIV'),true);
}
function RKIGHRRPIV_OnBlur(e) {
SetActiveField(Ctrl('RKIGHRRPIV'),false);
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
c=Ctrl('DVEINHNUIU');
if ( ! (Empty(c))) {
c[0].onclick=DVEINHNUIU_Valid;
c[1].onclick=DVEINHNUIU_Valid;
}
if(c=Ctrl('OGOQGXTPFZ')) c.onblur=OGOQGXTPFZ_Valid;
if(c=Ctrl('OGOQGXTPFZ')) c.onfocus=OGOQGXTPFZ_OnFocus;
if(c=Ctrl('OGOQGXTPFZ')) c.onkeypress=CheckUpper;
if(c=Ctrl('HYWEOCPLDV')) c.onblur=HYWEOCPLDV_Valid;
if(c=Ctrl('HYWEOCPLDV')) c.onfocus=HYWEOCPLDV_OnFocus;
if(c=Ctrl('HYWEOCPLDV')) c.onkeypress=CheckUpper;
if(c=Ctrl('MHPJNXSEVS')) c.onclick=MHPJNXSEVS_Valid;
if(c=Ctrl('MHPJNXSEVS')) c.onfocus=MHPJNXSEVS_OnFocus;
if(c=Ctrl('MHPJNXSEVS')) c.onblur=MHPJNXSEVS_OnBlur;
if(c=Ctrl('YUZVRERQCX')) c.onclick=YUZVRERQCX_Valid;
if(c=Ctrl('YUZVRERQCX')) c.onfocus=YUZVRERQCX_OnFocus;
if(c=Ctrl('YUZVRERQCX')) c.onblur=YUZVRERQCX_OnBlur;
if(c=Ctrl('RKIGHRRPIV')) c.onclick=RKIGHRRPIV_Valid;
if(c=Ctrl('RKIGHRRPIV')) c.onfocus=RKIGHRRPIV_OnFocus;
if(c=Ctrl('RKIGHRRPIV')) c.onblur=RKIGHRRPIV_OnBlur;
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
FocusFirstComponent.otherwise={"page_1":["DVEINHNUIU"]};
function Help() {
windowOpenForeground('../doc/aos_stampa_ricerca_web_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_criterio=a[0];
w_denomin=a[1];
w_simili=a[2];
w_flgnote=a[3];
w_flgnega=a[4];
w_flgafon=a[5];
o_criterio=w_criterio[1];
w_criterio=w_criterio[0];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('aos_stampa_ricerca_web',m_cSelectedPage);
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
l_bEnabled= ! (Eq(w_criterio,'D')) || IsDisabledByStateDriver('denomin');
SetDisabled(Ctrl('OGOQGXTPFZ'),l_bEnabled);
l_bEnabled= ! (Eq(w_criterio,'R')) || IsDisabledByStateDriver('simili');
SetDisabled(Ctrl('HYWEOCPLDV'),l_bEnabled);
l_bEnabled= ! (Eq(w_criterio,'D') || Eq(w_criterio,'R')) || IsDisabledByStateDriver('flgafon');
SetDisabled(Ctrl('RKIGHRRPIV'),l_bEnabled);
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
function Set_criterio(ctrlValue,kmode,e) {
if (Ne(w_criterio,ctrlValue)) {
var ctl = _GetCtl(e,'DVEINHNUIU');
if (_tracker.goon(ctl,ctrlValue)) {
w_criterio=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('DVEINHNUIU',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_denomin(ctrlValue,kmode,e) {
if (Ne(w_denomin,ctrlValue)) {
var ctl = _GetCtl(e,'OGOQGXTPFZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_denomin=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('OGOQGXTPFZ',0);
DoUpdate(l_bResult);
if(c=Ctrl('OGOQGXTPFZ')) c.value = WtH(w_denomin,'C',60,0,'@!')
} else {
ctl.value=WtH('','C',60,0,'@!');
_ResetTracker();
return true;
}
}
return true;
}
function Set_simili(ctrlValue,kmode,e) {
if (Ne(w_simili,ctrlValue)) {
var ctl = _GetCtl(e,'HYWEOCPLDV');
if (_tracker.goon(ctl,ctrlValue)) {
w_simili=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HYWEOCPLDV',0);
DoUpdate(l_bResult);
if(c=Ctrl('HYWEOCPLDV')) c.value = WtH(w_simili,'C',60,0,'@!')
} else {
ctl.value=WtH('','C',60,0,'@!');
_ResetTracker();
return true;
}
}
return true;
}
function Set_flgnote(ctrlValue,kmode,e) {
if (Ne(w_flgnote,ctrlValue)) {
var ctl = _GetCtl(e,'MHPJNXSEVS');
if (_tracker.goon(ctl,ctrlValue)) {
w_flgnote=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MHPJNXSEVS',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_flgnega(ctrlValue,kmode,e) {
if (Ne(w_flgnega,ctrlValue)) {
var ctl = _GetCtl(e,'YUZVRERQCX');
if (_tracker.goon(ctl,ctrlValue)) {
w_flgnega=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YUZVRERQCX',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_flgafon(ctrlValue,kmode,e) {
if (Ne(w_flgafon,ctrlValue)) {
var ctl = _GetCtl(e,'RKIGHRRPIV');
if (_tracker.goon(ctl,ctrlValue)) {
w_flgafon=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RKIGHRRPIV',0);
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
if ((Ne(o_criterio,w_criterio))) {
Calculation_JATMNSJTIW();
}
// * --- Area Manuale = UI - Calculate
// * --- Fine Area Manuale
m_bCalculating=false;
}
function Calculation_JATMNSJTIW() {
w_denomin=(Eq(w_criterio,'D')?w_denomin:Space(60));
w_simili=(Eq(w_criterio,'R')?w_simili:Space(60));
}
function SaveDependsOn() {
o_criterio=w_criterio;
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
if ( ! (_ChkObl('DVEINHNUIU',1))) {
_SignErr('DVEINHNUIU');
m_cLastWorkVarErrorMsg='criterio';
l_bResult=false;
w_criterio=HtW('','C');
} else if ((Eq(w_criterio,'D')) && ( ! (_ChkObl('OGOQGXTPFZ',1)))) {
_SignErr('OGOQGXTPFZ');
m_cLastWorkVarErrorMsg='denomin';
l_bResult=false;
w_denomin=HtW('','C');
} else if ((Eq(w_criterio,'R')) && ( ! (_ChkObl('HYWEOCPLDV',1)))) {
_SignErr('HYWEOCPLDV');
m_cLastWorkVarErrorMsg='simili';
l_bResult=false;
w_simili=HtW('','C');
} else if ( ! (_ChkObl('MHPJNXSEVS',1))) {
_SignErr('MHPJNXSEVS');
m_cLastWorkVarErrorMsg='flgnote';
l_bResult=false;
w_flgnote='N';
} else if ( ! (_ChkObl('YUZVRERQCX',1))) {
_SignErr('YUZVRERQCX');
m_cLastWorkVarErrorMsg='flgnega';
l_bResult=false;
w_flgnega='N';
} else if ((Eq(w_criterio,'D') || Eq(w_criterio,'R')) && ( ! (_ChkObl('RKIGHRRPIV',1)))) {
_SignErr('RKIGHRRPIV');
m_cLastWorkVarErrorMsg='flgafon';
l_bResult=false;
w_flgafon='N';
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
l_oWv.setValue('criterio',WtA(w_criterio,'C'));
l_oWv.setValue('denomin',WtA(w_denomin,'C'));
l_oWv.setValue('simili',WtA(w_simili,'C'));
l_oWv.setValue('flgnote',WtA(w_flgnote,'C'));
l_oWv.setValue('flgnega',WtA(w_flgnega,'C'));
l_oWv.setValue('flgafon',WtA(w_flgafon,'C'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["criterio","denomin","simili","flgnote","flgnega","flgafon"];
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
if (Empty(w_denomin) && Ne(opener.w_denomin,null)) {
TransferBetweenWindows(opener,'w_denomin',null,'Set_denomin');
}
if (Empty(w_simili) && Ne(opener.w_simili,null)) {
TransferBetweenWindows(opener,'w_simili',null,'Set_simili');
}
}
}
m_bCalculating=true;
if (start && Eq(At(',criterio,',pseq),0)) {
w_criterio='D';
}
if (start && Eq(At(',flgnote,',pseq),0)) {
w_flgnote='S';
}
if (start && Eq(At(',flgnega,',pseq),0)) {
w_flgnega='S';
}
if (start && Eq(At(',flgafon,',pseq),0)) {
w_flgafon='N';
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
_Obli('criterio',0,'DVEINHNUIU',false)
_Obli('denomin',0,'OGOQGXTPFZ',false)
_Obli('simili',0,'HYWEOCPLDV',false)
_Obli('flgnote',0,'MHPJNXSEVS',false)
_Obli('flgnega',0,'YUZVRERQCX',false)
_Obli('flgafon',0,'RKIGHRRPIV',false)
