function SetControlsValue() {
var c;
var c;
if(c=Ctrl('PLTJZXBPAO')) c.value = WtH(w_old1pwd,'C',20,0,'')
if(c=Ctrl('CHNTMOVIWW')) c.value = WtH(w_newpwd,'C',20,0,'')
if(c=Ctrl('RRTPUKVMPF')) c.value = WtH(w_new1pwd,'C',20,0,'')
var tmp_KEBEXQKGJH = ToHTag(AsControlValue(w_msgchg));
if (Ne(e_KEBEXQKGJH,tmp_KEBEXQKGJH)) {
if(c=Ctrl('KEBEXQKGJH')) c.innerHTML=tmp_KEBEXQKGJH;
e_KEBEXQKGJH=tmp_KEBEXQKGJH;
}
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay(Ctrl('OMQMTTPVQV'),Empty(LRTrim(w_new1pwd)));
HideUI();
}
HideUI.lblids["new1pwd"]=['GHHAOKCTMG'];
HideUI.lblids["newpwd"]=['BRFGVBEDHZ'];
HideUI.lblids["old1pwd"]=['CUWOXETBPM'];
function PLTJZXBPAO_Valid(e) {
SetActiveField(Ctrl('PLTJZXBPAO'),false);
e=(Ne(e,null)?e:window.event);
return Set_old1pwd(HtW(Ctrl('PLTJZXBPAO').value,'C'),null,e);
}
function PLTJZXBPAO_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('PLTJZXBPAO'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('PLTJZXBPAO'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('PLTJZXBPAO'),e);
}
function CHNTMOVIWW_Valid(e) {
SetActiveField(Ctrl('CHNTMOVIWW'),false);
e=(Ne(e,null)?e:window.event);
return Set_newpwd(HtW(Ctrl('CHNTMOVIWW').value,'C'),null,e);
}
function CHNTMOVIWW_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('CHNTMOVIWW'))) {
DisplayErrorMessage();
}
if (Ne(_tracker.ctrl,Ctrl('CHNTMOVIWW'))) {
Ctrl('CHNTMOVIWW').value=WtH(w_newpwd,'C',20,0,'');
}
SetActiveField(Ctrl('CHNTMOVIWW'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('CHNTMOVIWW'),e);
}
function CHNTMOVIWW_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("*"));
}
function RRTPUKVMPF_Valid(e) {
SetActiveField(Ctrl('RRTPUKVMPF'),false);
e=(Ne(e,null)?e:window.event);
return Set_new1pwd(HtW(Ctrl('RRTPUKVMPF').value,'C'),null,e);
}
function RRTPUKVMPF_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('RRTPUKVMPF'))) {
DisplayErrorMessage();
}
if (Ne(_tracker.ctrl,Ctrl('RRTPUKVMPF'))) {
Ctrl('RRTPUKVMPF').value=WtH(w_new1pwd,'C',20,0,'');
}
SetActiveField(Ctrl('RRTPUKVMPF'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('RRTPUKVMPF'),e);
}
function RRTPUKVMPF_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("*"));
}
function href_WBBXZNSMTG() {
var action = (Eq(Left('centrale'+''+'?',12),'utpg_chgpwd?')?'query':'start');
SetHypPar('m_cAction',AsAppletValue(action));
SetHypPar('m_cMode',AsAppletValue('hyperlink'));
SendData(action,'centrale'+'',HParApplet().asString());
}
function href_OMQMTTPVQV() {
SalvaPwd()
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
if(c=Ctrl('PLTJZXBPAO')) c.onblur=PLTJZXBPAO_Valid;
if(c=Ctrl('PLTJZXBPAO')) c.onfocus=PLTJZXBPAO_OnFocus;
if(c=Ctrl('CHNTMOVIWW')) c.onblur=CHNTMOVIWW_Valid;
if(c=Ctrl('CHNTMOVIWW')) c.onfocus=CHNTMOVIWW_OnFocus;
if(c=Ctrl('RRTPUKVMPF')) c.onblur=RRTPUKVMPF_Valid;
if(c=Ctrl('RRTPUKVMPF')) c.onfocus=RRTPUKVMPF_OnFocus;
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
FocusFirstComponent.otherwise={"page_1":["PLTJZXBPAO"]};
function Help() {
windowOpenForeground('../doc/utpg_chgpwd_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_gUtente=a[0];
w_oldpwd=a[1];
w_old1pwd=a[2];
w_newpwd=a[3];
w_new1pwd=a[4];
w_gUserCode=a[5];
w_msgchg=a[6];
o_gUtente=w_gUtente[1];
w_gUtente=w_gUtente[0];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('utpg_chgpwd',m_cSelectedPage);
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
function Set_newpwd(ctrlValue,kmode,e) {
if (Ne(w_newpwd,ctrlValue)) {
var ctl = _GetCtl(e,'CHNTMOVIWW');
if (_tracker.goon(ctl,ctrlValue)) {
w_newpwd=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CHNTMOVIWW',0);
if (l_bResult) {
l_bResult=Ge(Len(LRTrim(w_newpwd)),8);
if ( ! (l_bResult)) {
m_nLastError=2;
m_cLastWorkVarErrorMsg='newpwd';
m_cLastMsgError=AlertErrorMessage('1363272992');
}
if ( ! (l_bResult)) {
w_newpwd=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',20,0,''));
} else {
_ResetTracker();
}
return l_bResult;
} else {
ctl.value=WtH('','C',20,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_old1pwd(ctrlValue,kmode,e) {
if (Ne(w_old1pwd,ctrlValue)) {
var ctl = _GetCtl(e,'PLTJZXBPAO');
if (_tracker.goon(ctl,ctrlValue)) {
w_old1pwd=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('PLTJZXBPAO',0);
if (l_bResult) {
l_bResult=Eq(w_old1pwd,w_oldpwd);
if ( ! (l_bResult)) {
m_nLastError=2;
m_cLastWorkVarErrorMsg='old1pwd';
m_cLastMsgError=AlertErrorMessage('1582670566');
}
if ( ! (l_bResult)) {
w_old1pwd=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',20,0,''));
} else {
_ResetTracker();
}
return l_bResult;
} else {
ctl.value=WtH('','C',20,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_new1pwd(ctrlValue,kmode,e) {
if (Ne(w_new1pwd,ctrlValue)) {
var ctl = _GetCtl(e,'RRTPUKVMPF');
if (_tracker.goon(ctl,ctrlValue)) {
w_new1pwd=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RRTPUKVMPF',0);
if (l_bResult) {
l_bResult=Eq(w_new1pwd,w_newpwd);
if ( ! (l_bResult)) {
m_nLastError=2;
m_cLastWorkVarErrorMsg='new1pwd';
m_cLastMsgError=AlertErrorMessage('11846827769');
}
if ( ! (l_bResult)) {
w_new1pwd=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',20,0,''));
} else {
_ResetTracker();
}
return l_bResult;
} else {
ctl.value=WtH('','C',20,0,'');
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
if ((Ne(o_gUtente,w_gUtente))) {
l_bTmpRes=Link_HICQPMARXD(null);
}
// * --- Area Manuale = UI - Calculate
// * --- Fine Area Manuale
m_bCalculating=false;
}
function SaveDependsOn() {
o_gUtente=w_gUtente;
}
function SaveLabelDependsOn() {
}
function Link_HICQPMARXD(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_gUtente);
var l_Appl = LinkApplet();
l_Appl.FillEmptyKey();
l_Appl.SetStringKey('utcodice',w_gUtente,10,0);
l_Appl.SetFields('utcodice,utpasswd');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('Utenti');
l_Appl.SetLinkzoom('fwmt_utenti');
l_Appl.SetID('HICQPMARXD');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_gUtente=l_Appl.GetStringValue('utcodice',10,0);
w_oldpwd=l_Appl.GetStringValue('utpasswd',10,0);
} else {
Link_HICQPMARXD_Blank();
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
function Link_HICQPMARXD_Blank() {
w_gUtente='';
w_oldpwd='';
}
function LOpt_HICQPMARXD() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('Utenti','C'));
l_oWv.setValue('Linkzoomprg',WtA('fwmt_utenti','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('utcodice','C'));
l_oWv.setValue('LinkedField',WtA('utcodice','C'));
l_oWv.setValue('UID',WtA('HICQPMARXD','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['HICQPMARXD'][1],'C'));
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
if (( ! (_ChkObl('PLTJZXBPAO',1))) || ( ! (Eq(w_old1pwd,w_oldpwd)))) {
_SignErr('PLTJZXBPAO','1582670566');
l_bResult=false;
w_old1pwd=HtW('','C');
} else if (( ! (_ChkObl('CHNTMOVIWW',1))) || ( ! (Ge(Len(LRTrim(w_newpwd)),8)))) {
_SignErr('CHNTMOVIWW','1363272992');
l_bResult=false;
w_newpwd=HtW('','C');
} else if (( ! (_ChkObl('RRTPUKVMPF',1))) || ( ! (Eq(w_new1pwd,w_newpwd)))) {
_SignErr('RRTPUKVMPF','11846827769');
l_bResult=false;
w_new1pwd=HtW('','C');
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
l_oWv.setValue('gUtente',WtA(w_gUtente,'C'));
l_oWv.setValue('oldpwd',WtA(w_oldpwd,'C'));
l_oWv.setValue('old1pwd',WtA(w_old1pwd,'C'));
l_oWv.setValue('newpwd',WtA(w_newpwd,'C'));
l_oWv.setValue('new1pwd',WtA(w_new1pwd,'C'));
l_oWv.setValue('gUserCode',WtA(w_gUserCode,'N'));
l_oWv.setValue('msgchg',WtA(w_msgchg,'C'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["gUtente","oldpwd","old1pwd","newpwd","new1pwd","gUserCode","msgchg"];
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
if (Empty(w_msgchg) && Ne(opener.w_msgchg,null)) {
TransferBetweenWindows(opener,'w_msgchg','w_msgchg');
}
}
}
m_bCalculating=true;
Link_HICQPMARXD(null);
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
_Obli('newpwd',0,'CHNTMOVIWW',false)
_Obli('old1pwd',0,'PLTJZXBPAO',false)
_Obli('new1pwd',0,'RRTPUKVMPF',false)
