function SetControlsValue() {
var c;
var c;
if(c=Ctrl('DAXLJPCPWJ')) c.value = WtH(w_CodUte,'C',15,0,'')
if(c=Ctrl('YIAAHXDHOM')) c.value = WtH(w_PwdUte,'C',20,0,'')
var tmp_KGDPUHCUOZ = ToHTag(AsControlValue(w_desute));
if (Ne(e_KGDPUHCUOZ,tmp_KGDPUHCUOZ)) {
if(c=Ctrl('KGDPUHCUOZ')) c.innerHTML=tmp_KGDPUHCUOZ;
e_KGDPUHCUOZ=tmp_KGDPUHCUOZ;
}
var tmp_XFDIIVLYAG = ToHTag(AsControlValue(LRTrim(w_ErrLogin)));
if (Ne(e_XFDIIVLYAG,tmp_XFDIIVLYAG)) {
if(c=Ctrl('XFDIIVLYAG')) c.innerHTML=tmp_XFDIIVLYAG;
e_XFDIIVLYAG=tmp_XFDIIVLYAG;
}
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
HideUI();
}
HideUI.lblids["CodUte"]=['MSQYMICNRH'];
HideUI.lblids["PwdUte"]=['QEPBNYFKMR'];
function DAXLJPCPWJ_Valid(e) {
SetActiveField(Ctrl('DAXLJPCPWJ'),false);
e=(Ne(e,null)?e:window.event);
return Set_CodUte(HtW(Ctrl('DAXLJPCPWJ').value,'C'),null,e);
}
function DAXLJPCPWJ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('DAXLJPCPWJ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('DAXLJPCPWJ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('DAXLJPCPWJ'),e);
}
function YIAAHXDHOM_Valid(e) {
SetActiveField(Ctrl('YIAAHXDHOM'),false);
e=(Ne(e,null)?e:window.event);
return Set_PwdUte(HtW(Ctrl('YIAAHXDHOM').value,'C'),null,e);
}
function YIAAHXDHOM_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('YIAAHXDHOM'))) {
DisplayErrorMessage();
}
Ctrl('YIAAHXDHOM').value=WtH(w_PwdUte,'C',20,0,'');
SetActiveField(Ctrl('YIAAHXDHOM'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('YIAAHXDHOM'),e);
}
function YIAAHXDHOM_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("*"));
}
function href_CEFKAMPDFS() {
SetHypPar('m_cAction',AsAppletValue('start'));
SetHypPar('m_cMode',AsAppletValue('hyperlink'));
SetHypPar('w_CodUte',AsAppletValue(w_CodUte));
SetHypPar('w_PwdUte',AsAppletValue(w_PwdUte));
SetHypPar('w_ErrLogin',AsAppletValue(w_ErrLogin));
SetHypPar('m_cParameterSequence',AsAppletValue('w_CodUte,w_PwdUte,w_ErrLogin'));
SetHypPar('m_cID',AsAppletValue(m_IDS['arrt_login']));
SendData('start','arrt_login'+'',HParApplet().asString());
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
if(c=Ctrl('DAXLJPCPWJ')) c.onblur=DAXLJPCPWJ_Valid;
if(c=Ctrl('DAXLJPCPWJ')) c.onfocus=DAXLJPCPWJ_OnFocus;
if(c=Ctrl('YIAAHXDHOM')) c.onblur=YIAAHXDHOM_Valid;
if(c=Ctrl('YIAAHXDHOM')) c.onfocus=YIAAHXDHOM_OnFocus;
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
FocusFirstComponent.otherwise={"page_1":["DAXLJPCPWJ"]};
function Help() {
windowOpenForeground('../doc/arpg_login_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_CodUte=a[0];
w_PwdUte=a[1];
w_desute=a[2];
w_ErrLogin=a[3];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_login',m_cSelectedPage);
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
function Set_CodUte(ctrlValue,kmode,e) {
if (Ne(w_CodUte,ctrlValue)) {
var ctl = _GetCtl(e,'DAXLJPCPWJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_CodUte=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('DAXLJPCPWJ',0);
if (l_bResult) {
l_bResult=Link_DAXLJPCPWJ(kmode);
if ( ! (l_bResult)) {
w_CodUte=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',15,0,''));
} else {
_ResetTracker();
}
return l_bResult;
} else {
ctl.value=WtH('','C',15,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_PwdUte(ctrlValue,kmode,e) {
if (Ne(w_PwdUte,ctrlValue)) {
var ctl = _GetCtl(e,'YIAAHXDHOM');
if (_tracker.goon(ctl,ctrlValue)) {
w_PwdUte=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YIAAHXDHOM',0);
DoUpdate(l_bResult);
if(c=Ctrl('YIAAHXDHOM')) c.value = WtH(w_PwdUte,'C',20,0,'')
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
// * --- Area Manuale = UI - Calculate
// * --- Fine Area Manuale
m_bCalculating=false;
}
function SaveDependsOn() {
}
function SaveLabelDependsOn() {
}
function Link_DAXLJPCPWJ(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CodUte);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('utcodice',w_CodUte,15,0);
l_Appl.SetFields('utcodice,utnomine');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('utenti');
l_Appl.SetLinkzoom('armt_utenti');
l_Appl.SetID('DAXLJPCPWJ');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CodUte=l_Appl.GetStringValue('utcodice',15,0);
w_desute=l_Appl.GetStringValue('utnomine',30,0);
} else {
Link_DAXLJPCPWJ_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_DAXLJPCPWJ';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_DAXLJPCPWJ();
l_oWv.setValue('FieldFilter',l_cFieldFilter);
if ( ! (Empty(l_Appl.GetWhereAddedFixedFiltersUnencoded()))) {
if ( ! (Empty(l_cFixedFilter))) {
l_cFixedFilter=l_cFixedFilter+' and ';
}
l_cFixedFilter=l_cFixedFilter+l_Appl.GetWhereAddedFixedFiltersUnencoded();
}
l_oWv.setValue('FixedFilter',l_cFixedFilter);
var initEntityFields = '';
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
function Link_DAXLJPCPWJ_Blank() {
w_CodUte='';
w_desute='';
}
function LOpt_DAXLJPCPWJ() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('utenti','C'));
l_oWv.setValue('Linkzoomprg',WtA('armt_utenti','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('utcodice','C'));
l_oWv.setValue('LinkedField',WtA('utcodice','C'));
l_oWv.setValue('UID',WtA('DAXLJPCPWJ','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['DAXLJPCPWJ'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('2009792713'),'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'DAXLJPCPWJ')) {
last_focused_comp=GetLastFocusedElementOfLink('DAXLJPCPWJ');
function SetMethod_DAXLJPCPWJ() {
Set_CodUte(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_DAXLJPCPWJ();
} else {
setTimeout(SetMethod_DAXLJPCPWJ,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'DAXLJPCPWJ')) {
return [Ctrl('DAXLJPCPWJ')];
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
if ( ! (_ChkObl('DAXLJPCPWJ',1))) {
_SignErr('DAXLJPCPWJ');
m_cLastWorkVarErrorMsg='CodUte';
l_bResult=false;
w_CodUte=HtW('','C');
} else if ( ! (_ChkObl('YIAAHXDHOM',1))) {
_SignErr('YIAAHXDHOM');
m_cLastWorkVarErrorMsg='PwdUte';
l_bResult=false;
w_PwdUte=HtW('','C');
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
l_oWv.setValue('CodUte',WtA(w_CodUte,'C'));
l_oWv.setValue('PwdUte',WtA(w_PwdUte,'C'));
l_oWv.setValue('desute',WtA(w_desute,'C'));
l_oWv.setValue('ErrLogin',WtA(w_ErrLogin,'C'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["CodUte","PwdUte","desute","ErrLogin"];
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
if (Empty(w_CodUte) && Ne(opener.w_CodUte,null)) {
TransferBetweenWindows(opener,'w_CodUte',null,'Set_CodUte');
}
if (Empty(w_PwdUte) && Ne(opener.w_PwdUte,null)) {
TransferBetweenWindows(opener,'w_PwdUte',null,'Set_PwdUte');
}
if (Empty(w_desute) && Ne(opener.w_desute,null)) {
TransferBetweenWindows(opener,'w_desute','w_desute');
}
if (Empty(w_ErrLogin) && Ne(opener.w_ErrLogin,null)) {
TransferBetweenWindows(opener,'w_ErrLogin','w_ErrLogin');
}
}
}
m_bCalculating=true;
Link_DAXLJPCPWJ(null);
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
_Obli('CodUte',0,'DAXLJPCPWJ',true,null,'DAXLJPCPWJ')
_Obli('PwdUte',0,'YIAAHXDHOM',false)
