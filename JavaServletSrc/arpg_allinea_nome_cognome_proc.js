function SetControlsValue() {
var c;
var c;
if(c=Ctrl('URJECFSAOV')) c.value = WtH(w_Countot,'N',20,0,'')
if(c=Ctrl('MNRQYNMNLG')) c.value = WtH(w_Countok,'N',20,0,'')
if(c=Ctrl('FYWCYUCGWN')) selectRadio(c,w_ALLINEAMENTO,'C')
if(c=Ctrl('YVBXOWMFXO')) c.value = WtH(w_Countpr,'N',20,0,'')
if(c=Ctrl('VQPOQZIXZG')) c.value = WtH(w_Countpr2,'N',20,0,'')
if(c=Ctrl('OHORDWVXGQ')) c.value = WtH(w_Countko,'N',20,0,'')
if (Gt(m_nRows,0) && Lt(m_nCurrentRow,m_oTrsFW.length)) {
if (Ne(Ctrl('NCJGCIXOKV_'+m_nCurrentRow),null)) {
var tmp_NCJGCIXOKV = ToHTag(AsControlValue((Eq(arfn_verifica_cf_nome_cognome_numeric(c_CODFISC,w_NOME,w_COGNOME),1)?'CORRETTA':'ERRATA')));
if (Ne(e_NCJGCIXOKV,tmp_NCJGCIXOKV)) {
if(c=Ctrl('NCJGCIXOKV_'+m_nCurrentRow)) c.innerHTML=tmp_NCJGCIXOKV;
e_NCJGCIXOKV=tmp_NCJGCIXOKV;
}
}
if (Ne(Ctrl('MGZZLJDIWH_'+m_nCurrentRow),null)) {
if(c=Ctrl('MGZZLJDIWH_'+m_nCurrentRow)) c.value = WtH(w_RAGSOC,'C',70,0,'')
}
if (Ne(Ctrl('ULURFNZXUM_'+m_nCurrentRow),null)) {
if(c=Ctrl('ULURFNZXUM_'+m_nCurrentRow)) c.value = WtH(w_NOME,'C',25,0,'')
}
if (Ne(Ctrl('QUYFYKVQUY_'+m_nCurrentRow),null)) {
if(c=Ctrl('QUYFYKVQUY_'+m_nCurrentRow)) c.value = WtH(w_COGNOME,'C',26,0,'')
}
}
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
if (Gt(m_nRows,0)) {
SetDisplay(Ctrl('NYJJGKYDJR'),true);
}
HideUI();
}
function URJECFSAOV_Valid(e) {
SetActiveField(Ctrl('URJECFSAOV'),false);
e=(Ne(e,null)?e:window.event);
return Set_Countot(HtW(Ctrl('URJECFSAOV').value,'N'),null,e);
}
function URJECFSAOV_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('URJECFSAOV'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('URJECFSAOV'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('URJECFSAOV'),e);
}
function MNRQYNMNLG_Valid(e) {
SetActiveField(Ctrl('MNRQYNMNLG'),false);
e=(Ne(e,null)?e:window.event);
return Set_Countok(HtW(Ctrl('MNRQYNMNLG').value,'N'),null,e);
}
function MNRQYNMNLG_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('MNRQYNMNLG'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('MNRQYNMNLG'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('MNRQYNMNLG'),e);
}
function MGZZLJDIWH_Valid(e) {
SetActiveField(Ctrl('MGZZLJDIWH_'+m_nCurrentRow),false);
e=(Ne(e,null)?e:window.event);
return Set_RAGSOC(HtW(Ctrl('MGZZLJDIWH_'+m_nCurrentRow).value,'C'),null,e);
}
function MGZZLJDIWH_OnFocus(e) {
var org;
org=GetEventSrcElement(e);
ChangeRow(Val(Right(org.name,Len(org.name)-RAt('_',org.name))));
if (Ne(m_cFunction,'query') &&  ! (CheckZone('MGZZLJDIWH'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('MGZZLJDIWH_'+m_nCurrentRow),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('MGZZLJDIWH_'+m_nCurrentRow),e);
}
function FYWCYUCGWN_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_ALLINEAMENTO(HtW(getRadioValue(Ctrl('FYWCYUCGWN')),'C'),null,e);
}
function href_UVFNBSLUHT() {
SetHypPar('m_bQuery',AsAppletValue(true));
var action = (Eq(Left('arpg_allinea_nome_cognome'+''+'?',26),'arpg_allinea_nome_cognome?')?'query':'start');
SetHypPar('m_cAction',AsAppletValue(action));
SetHypPar('m_cMode',AsAppletValue('hyperlink'));
SendData(action,'arpg_allinea_nome_cognome'+'',HParApplet().asString());
}
function YVBXOWMFXO_Valid(e) {
SetActiveField(Ctrl('YVBXOWMFXO'),false);
e=(Ne(e,null)?e:window.event);
return Set_Countpr(HtW(Ctrl('YVBXOWMFXO').value,'N'),null,e);
}
function YVBXOWMFXO_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('YVBXOWMFXO'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('YVBXOWMFXO'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('YVBXOWMFXO'),e);
}
function VQPOQZIXZG_Valid(e) {
SetActiveField(Ctrl('VQPOQZIXZG'),false);
e=(Ne(e,null)?e:window.event);
return Set_Countpr2(HtW(Ctrl('VQPOQZIXZG').value,'N'),null,e);
}
function VQPOQZIXZG_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('VQPOQZIXZG'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('VQPOQZIXZG'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('VQPOQZIXZG'),e);
}
function OHORDWVXGQ_Valid(e) {
SetActiveField(Ctrl('OHORDWVXGQ'),false);
e=(Ne(e,null)?e:window.event);
return Set_Countko(HtW(Ctrl('OHORDWVXGQ').value,'N'),null,e);
}
function OHORDWVXGQ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('OHORDWVXGQ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('OHORDWVXGQ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('OHORDWVXGQ'),e);
}
function href_DJWOYPVMPM() {
Update()
}
function href_BAYMUXPNMC() {
_modifyandopen('arrt_save_nome_cognome_alliniati'+'?m_cAction=start&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes,height=200,width=200',null)
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
if(c=Ctrl('URJECFSAOV')) c.onblur=URJECFSAOV_Valid;
if(c=Ctrl('URJECFSAOV')) c.onfocus=URJECFSAOV_OnFocus;
if(c=Ctrl('URJECFSAOV')) c.onkeypress=CheckNum;
if(c=Ctrl('MNRQYNMNLG')) c.onblur=MNRQYNMNLG_Valid;
if(c=Ctrl('MNRQYNMNLG')) c.onfocus=MNRQYNMNLG_OnFocus;
if(c=Ctrl('MNRQYNMNLG')) c.onkeypress=CheckNum;
c=Ctrl('FYWCYUCGWN');
if ( ! (Empty(c))) {
c[0].onclick=FYWCYUCGWN_Valid;
c[1].onclick=FYWCYUCGWN_Valid;
c[2].onclick=FYWCYUCGWN_Valid;
c[3].onclick=FYWCYUCGWN_Valid;
c[4].onclick=FYWCYUCGWN_Valid;
}
if(c=Ctrl('YVBXOWMFXO')) c.onblur=YVBXOWMFXO_Valid;
if(c=Ctrl('YVBXOWMFXO')) c.onfocus=YVBXOWMFXO_OnFocus;
if(c=Ctrl('YVBXOWMFXO')) c.onkeypress=CheckNum;
if(c=Ctrl('VQPOQZIXZG')) c.onblur=VQPOQZIXZG_Valid;
if(c=Ctrl('VQPOQZIXZG')) c.onfocus=VQPOQZIXZG_OnFocus;
if(c=Ctrl('VQPOQZIXZG')) c.onkeypress=CheckNum;
if(c=Ctrl('OHORDWVXGQ')) c.onblur=OHORDWVXGQ_Valid;
if(c=Ctrl('OHORDWVXGQ')) c.onfocus=OHORDWVXGQ_OnFocus;
if(c=Ctrl('OHORDWVXGQ')) c.onkeypress=CheckNum;
}
var l_nOldRow = m_nCurrentRow;
m_nCurrentRow=0;
while (Lt(m_nCurrentRow,m_nRows)) {
if(c=Ctrl('MGZZLJDIWH_'+m_nCurrentRow)) c.onblur=MGZZLJDIWH_Valid;
if(c=Ctrl('MGZZLJDIWH_'+m_nCurrentRow)) c.onfocus=MGZZLJDIWH_OnFocus;
m_nCurrentRow=m_nCurrentRow+1;
}
m_nCurrentRow=l_nOldRow;
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
function DoFieldsUpdate(p_bResult) {
m_bFieldsUpdated=true;
DoUpdate(p_bResult);
}
FocusFirstComponent.otherwise={"page_1":["MGZZLJDIWH_'+m_nCurrentRow+'"]};
function Help() {
windowOpenForeground('../doc/arpg_allinea_nome_cognome_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_RAGSOC=a[0];
w_NOME=a[1];
w_COGNOME=a[2];
w_Countot=a[3];
w_Countok=a[4];
w_ALLINEAMENTO=a[5];
w_Countpr=a[6];
w_Countpr2=a[7];
w_Countko=a[8];
o_RAGSOC=w_RAGSOC[1];
w_RAGSOC=w_RAGSOC[0];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_allinea_nome_cognome',m_cSelectedPage);
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
l_bEnabled= ! (false) || IsDisabledByStateDriver('Countot');
SetDisabled(Ctrl('URJECFSAOV'),l_bEnabled);
l_bEnabled= ! (false) || IsDisabledByStateDriver('Countok');
SetDisabled(Ctrl('MNRQYNMNLG'),l_bEnabled);
l_bEnabled= ! (false) || IsDisabledByStateDriver('Countpr');
SetDisabled(Ctrl('YVBXOWMFXO'),l_bEnabled);
l_bEnabled= ! (false) || IsDisabledByStateDriver('Countpr2');
SetDisabled(Ctrl('VQPOQZIXZG'),l_bEnabled);
l_bEnabled= ! (false) || IsDisabledByStateDriver('Countko');
SetDisabled(Ctrl('OHORDWVXGQ'),l_bEnabled);
DisableUI();
if (Gt(m_nRows,0)) {
}
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
function Update() {
var l_bUpdate;
var l_nRow;
l_nRow=0;
l_bUpdate=true;
if (m_bFieldsUpdated) {
while (l_bUpdate && Lt(m_nCurrentRow,m_nRows)) {
ChangeRow(l_nRow);
l_bUpdate=l_bUpdate && Eq(m_nCurrentRow,l_nRow);
l_nRow=l_nRow+1;
}
}
if (l_bUpdate) {
FillFrmTrs('NOME','COGNOME','RAGSOC');
SubmitForm('save');
}
}
function Set_Countot(ctrlValue,kmode,e) {
if (Ne(w_Countot,ctrlValue)) {
var ctl = _GetCtl(e,'URJECFSAOV');
if (_tracker.goon(ctl,ctrlValue)) {
w_Countot=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('URJECFSAOV',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','N',20,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_Countok(ctrlValue,kmode,e) {
if (Ne(w_Countok,ctrlValue)) {
var ctl = _GetCtl(e,'MNRQYNMNLG');
if (_tracker.goon(ctl,ctrlValue)) {
w_Countok=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MNRQYNMNLG',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','N',20,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_RAGSOC(ctrlValue,kmode,e) {
if (Ne(w_RAGSOC,ctrlValue)) {
var ctl = _GetCtl(e,'MGZZLJDIWH_'+m_nCurrentRow+'');
if (_tracker.goon(ctl,ctrlValue)) {
w_RAGSOC=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MGZZLJDIWH',0);
if (l_bResult) {
l_bResult=Le(LibreriaMit.Occurs(w_RAGSOC,'?'),1);
if ( ! (l_bResult)) {
m_nLastError=2;
m_cLastWorkVarErrorMsg='RAGSOC';
m_cLastMsgError=AlertErrorMessage('1450989131');
}
if ( ! (l_bResult)) {
w_RAGSOC=HtW('','C');
}
}
DoFieldsUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',70,0,''));
} else {
_ResetTracker();
}
return l_bResult;
} else {
ctl.value=WtH('','C',70,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_ALLINEAMENTO(ctrlValue,kmode,e) {
if (Ne(w_ALLINEAMENTO,ctrlValue)) {
var ctl = _GetCtl(e,'FYWCYUCGWN');
if (_tracker.goon(ctl,ctrlValue)) {
w_ALLINEAMENTO=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FYWCYUCGWN',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',2,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_Countpr(ctrlValue,kmode,e) {
if (Ne(w_Countpr,ctrlValue)) {
var ctl = _GetCtl(e,'YVBXOWMFXO');
if (_tracker.goon(ctl,ctrlValue)) {
w_Countpr=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YVBXOWMFXO',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','N',20,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_Countpr2(ctrlValue,kmode,e) {
if (Ne(w_Countpr2,ctrlValue)) {
var ctl = _GetCtl(e,'VQPOQZIXZG');
if (_tracker.goon(ctl,ctrlValue)) {
w_Countpr2=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VQPOQZIXZG',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','N',20,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_Countko(ctrlValue,kmode,e) {
if (Ne(w_Countko,ctrlValue)) {
var ctl = _GetCtl(e,'OHORDWVXGQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_Countko=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('OHORDWVXGQ',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','N',20,0,'');
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
if ((Ne(o_RAGSOC,w_RAGSOC))) {
w_NOME=(Gt(LibreriaMit.Occurs(w_RAGSOC,'?'),0)?Left(w_RAGSOC,At('?',w_RAGSOC)-1):'');
}
if ((Ne(o_RAGSOC,w_RAGSOC))) {
w_COGNOME=(Gt(LibreriaMit.Occurs(w_RAGSOC,'?'),0)?Substr(w_RAGSOC,At('?',w_RAGSOC)+1):'');
}
// * --- Area Manuale = UI - Calculate
// * --- Fine Area Manuale
m_bCalculating=false;
}
function SaveDependsOn() {
o_RAGSOC=w_RAGSOC;
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
if ((false) && ( ! (_ChkObl('URJECFSAOV',1)))) {
_SignErr('URJECFSAOV');
m_cLastWorkVarErrorMsg='Countot';
l_bResult=false;
w_Countot=HtW('','N');
} else if ((false) && ( ! (_ChkObl('MNRQYNMNLG',1)))) {
_SignErr('MNRQYNMNLG');
m_cLastWorkVarErrorMsg='Countok';
l_bResult=false;
w_Countok=HtW('','N');
} else if (( ! (_ChkObl('MGZZLJDIWH',1))) || ( ! (Le(LibreriaMit.Occurs(w_RAGSOC,'?'),1)))) {
_SignErr('MGZZLJDIWH_'+m_nCurrentRow+'','1450989131');
l_bResult=false;
w_RAGSOC=HtW('','C');
} else if ( ! (_ChkObl('FYWCYUCGWN',1))) {
_SignErr('FYWCYUCGWN');
m_cLastWorkVarErrorMsg='ALLINEAMENTO';
l_bResult=false;
w_ALLINEAMENTO=HtW('','C');
} else if ((false) && ( ! (_ChkObl('YVBXOWMFXO',1)))) {
_SignErr('YVBXOWMFXO');
m_cLastWorkVarErrorMsg='Countpr';
l_bResult=false;
w_Countpr=HtW('','N');
} else if ((false) && ( ! (_ChkObl('VQPOQZIXZG',1)))) {
_SignErr('VQPOQZIXZG');
m_cLastWorkVarErrorMsg='Countpr2';
l_bResult=false;
w_Countpr2=HtW('','N');
} else if ((false) && ( ! (_ChkObl('OHORDWVXGQ',1)))) {
_SignErr('OHORDWVXGQ');
m_cLastWorkVarErrorMsg='Countko';
l_bResult=false;
w_Countko=HtW('','N');
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
l_oWv.setValue('RAGSOC',WtA(w_RAGSOC,'C'));
l_oWv.setValue('NOME',WtA(w_NOME,'C'));
l_oWv.setValue('COGNOME',WtA(w_COGNOME,'C'));
l_oWv.setValue('Countot',WtA(w_Countot,'N'));
l_oWv.setValue('Countok',WtA(w_Countok,'N'));
l_oWv.setValue('ALLINEAMENTO',WtA(w_ALLINEAMENTO,'C'));
l_oWv.setValue('Countpr',WtA(w_Countpr,'N'));
l_oWv.setValue('Countpr2',WtA(w_Countpr2,'N'));
l_oWv.setValue('Countko',WtA(w_Countko,'N'));
_FillChildren(l_oWv);
l_oWv.setValue('m_oTrs',TrsApplet().asString());
}
_FillChildren.n=[];
FillWv.n=["RAGSOC","NOME","COGNOME","Countot","Countok","ALLINEAMENTO","Countpr","Countpr2","Countko"];
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
if (Eq(w_ALLINEAMENTO,'') && Ne(opener.w_ALLINEAMENTO,null)) {
TransferBetweenWindows(opener,'w_ALLINEAMENTO',null,'Set_ALLINEAMENTO');
}
}
}
m_bCalculating=true;
if (start && Eq(At(',ALLINEAMENTO,',pseq),0)) {
w_ALLINEAMENTO='';
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
if (( ! (_ChkObl('MGZZLJDIWH',1))) || ( ! (Le(LibreriaMit.Occurs(w_RAGSOC,'?'),1)))) {
_SignErr('MGZZLJDIWH_'+m_nCurrentRow+'','1450989131');
l_bResult=false;
w_RAGSOC=HtW('','C');
}
}
return l_bResult;
}
function TrsFWRow() {
  this.w_RAGSOC = arguments[0]
  this.o_RAGSOC = arguments[1]
  this.t_RAGSOC = arguments[2]
  this.k_RAGSOC_IDBASE = arguments[3]
  this.w_NOME = arguments[4]
  this.t_NOME = arguments[5]
  this.k_NOME_IDBASE = arguments[6]
  this.w_COGNOME = arguments[7]
  this.t_COGNOME = arguments[8]
  this.k_COGNOME_IDBASE = arguments[9]
  this.m_nRowStatus = arguments[10]
}
function TrsQueryRow() {
  this.c_IDBASE = arguments[0]
  this.c_CONNES = arguments[1]
  this.c_RAGSOC = arguments[2]
  this.c_CODFISC = arguments[3]
  this.c_NOME = arguments[4]
  this.c_COGNOME = arguments[5]
  this.c_ALLINEAMENTO = arguments[6]
}
function TrsToWork() {
var row;
if (Lt(m_nCurrentRow,m_oTrsFW.length)) {
row=m_oTrsFW[m_nCurrentRow];
w_RAGSOC=row.w_RAGSOC;
o_RAGSOC=row.o_RAGSOC;
w_NOME=row.w_NOME;
w_COGNOME=row.w_COGNOME;
m_nRowStatus=row.m_nRowStatus;
}
if (Lt(m_nCurrentRow,m_oTrsQuery.length)) {
row=m_oTrsQuery[m_nCurrentRow];
c_IDBASE=row.c_IDBASE;
c_CONNES=row.c_CONNES;
c_RAGSOC=row.c_RAGSOC;
c_CODFISC=row.c_CODFISC;
c_NOME=row.c_NOME;
c_COGNOME=row.c_COGNOME;
c_ALLINEAMENTO=row.c_ALLINEAMENTO;
}
}
function WorkToTrs() {
var row;
if (Lt(m_nCurrentRow,m_oTrsFW.length)) {
row=m_oTrsFW[m_nCurrentRow];
row.w_RAGSOC=w_RAGSOC;
row.o_RAGSOC=o_RAGSOC;
row.w_NOME=w_NOME;
row.w_COGNOME=w_COGNOME;
row.m_nRowStatus=m_nRowStatus;
}
if (Lt(m_nCurrentRow,m_oTrsQuery.length)) {
row=m_oTrsQuery[m_nCurrentRow];
row.c_IDBASE=c_IDBASE;
row.c_CONNES=c_CONNES;
row.c_RAGSOC=c_RAGSOC;
row.c_CODFISC=c_CODFISC;
row.c_NOME=c_NOME;
row.c_COGNOME=c_COGNOME;
row.c_ALLINEAMENTO=c_ALLINEAMENTO;
}
}
function BlankQueryFields() {
c_IDBASE='';
c_CONNES='';
c_RAGSOC='';
c_CODFISC='';
c_NOME='';
c_COGNOME='';
c_ALLINEAMENTO='';
}
function FillHTMLRow() {
var l_nIdx = 0;
var l_oQuery;
var l_oFields;
var l_nEvenOdd = 0;
var l_nPrev = 0;
var l_nNext = 0;
var l_bEof;
l_bEof=Eq(m_nRows,0);
var l_nDeep;
l_nDeep=-1;
var l_nStartRow = Val(document.FSender.StartRow.value);
var l_nPos = 0;
var l_NYONWVNAYZ = false;
var l_old_NYONWVNAYZ = l_NYONWVNAYZ;
Body_BeginHtml(147,'',0,'A','');
BlankQueryFields();
while ( ! (l_bEof)) {
l_oQuery=m_oTrsQuery[l_nIdx];
l_oFields=m_oTrsFW[l_nIdx];
l_nDeep=0;
if (Lt(l_nIdx,m_nRows)) {
m_nCurrentRow=l_nIdx;
TrsToWork();
l_NYONWVNAYZ=true;
if (Eq(l_nIdx,0)) {
l_nDeep=1;
} else {
if (Ne(l_old_NYONWVNAYZ,l_NYONWVNAYZ)) {
l_nDeep=2;
} else {
l_nDeep=3;
}
}
} else {
l_bEof=true;
l_nDeep=1;
}
l_nIdx=l_nIdx-1;
if (Ge(l_nIdx,0)) {
m_nCurrentRow=l_nIdx;
TrsToWork();
}
if (Ge(2,l_nDeep) && Ge(l_nIdx,0)) {
GroupFooter_BeginHtml(document,1,'11086260876'+l_nIdx+'','A',true,false)
GroupFooter_EndHtml(document,1,'11086260876'+l_nIdx+'','A')
} else {
}
l_nIdx=l_nIdx+1;
m_nCurrentRow=l_nIdx;
TrsToWork();
l_old_NYONWVNAYZ = l_NYONWVNAYZ;
if ( ! (l_bEof)) {
Parms.Idx=l_nIdx;
Parms.Deep=l_nDeep;
Parms.EvenOdd=l_nEvenOdd;
DrawLine(document);
l_nEvenOdd = l_nEvenOdd+1;
}
if ( ! (l_bEof)) {
l_nIdx=l_nIdx+1;
}
}
Body_Buttons(Gt(l_nStartRow,1),m_bOtherRow,'A');
if (Gt(m_nRows,0) || Lt(l_nIdx,m_nRows)) {
Update_Button("NYJJGKYDJR",Translate("113933141"),"","","","CLASS=FormDefault STYLE='display:"+(true?'none':'inline')+"'","")
}
Body_EndHtml('A');
}
function DrawLine(document) {
l_nIdx=Parms.Idx;
l_nDeep=Parms.Deep;
l_nEvenOdd=Parms.EvenOdd;
if (Ge(2,l_nDeep)) {
GroupHeader_BeginHtml(document,1,'11086260364'+l_nIdx+'','A',true,false)
document.writeln(
 "<div id='DIV_0976C4E8"+l_nIdx+"' style='position:relative;height:17px'>" +
"")
document.writeln(
 "<span class=' SPLabel JSNSZPAZUQ_DIV'>" +
 "<label class='JSNSZPAZUQ'>" +
 ""+ToHTag(Translate("10662833243"))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel IZKHLDIVWR_DIV'>" +
 "<label class='IZKHLDIVWR'>" +
 ""+ToHTag(Translate("11921223220"))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel TACLTIAJKL_DIV'>" +
 "<label class='TACLTIAJKL'>" +
 ""+ToHTag(Translate("443454"))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel YHSYZEPDNR_DIV'>" +
 "<label class='YHSYZEPDNR'>" +
 ""+ToHTag(Translate("1816546867"))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel XHRBJAGOUF_DIV'>" +
 "<label class='XHRBJAGOUF'>" +
 ""+ToHTag(Translate("838020874"))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "</div>" +
"")
GroupHeader_EndHtml(document,1,'11086260364'+l_nIdx+'','A')
} else {
}
Row_BeginHtml(document,l_nEvenOdd,'11089862284'+l_nIdx+'','A',true,-1)
document.writeln(
 "<div id='DIV_0BB685D0"+l_nIdx+"' style='position:relative;height:29px'>" +
"")
document.writeln(
 "<input name='RAGSOC_"+l_nIdx+"' id='MGZZLJDIWH_"+l_nIdx+"' type='text' class='MGZZLJDIWH Field' value="+ToHTMLValue(WtH(w_RAGSOC,"C",70,0,''))+" curTabIndex='0' maxlength='70' size='70' fieldtype='C'>" +
"")
document.writeln(
 "<input name='NOME_"+l_nIdx+"' id='ULURFNZXUM_"+l_nIdx+"' type='text' class='ULURFNZXUM Field Disabled' value="+ToHTMLValue(WtH(w_NOME,"C",25,0,''))+" tabindex='-1' curTabIndex='0' readonly maxlength='25' size='25' fieldtype='C'>" +
"")
document.writeln(
 "<input name='COGNOME_"+l_nIdx+"' id='QUYFYKVQUY_"+l_nIdx+"' type='text' class='QUYFYKVQUY Field Disabled' value="+ToHTMLValue(WtH(w_COGNOME,"C",26,0,''))+" tabindex='-1' curTabIndex='0' readonly maxlength='26' size='26' fieldtype='C'>" +
"")
document.writeln(
 "<span class=' SPLabel AHZSTTZOJN_DIV'>" +
 "<label class='AHZSTTZOJN'>" +
 ""+ToHTag(WtH(c_CODFISC,'C',16,0,''))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel NCJGCIXOKV_DIV'>" +
 "<label id='NCJGCIXOKV_"+l_nIdx+"' class='NCJGCIXOKV'>" +
 ""+ToHTag((Eq(arfn_verifica_cf_nome_cognome_numeric(c_CODFISC,w_NOME,w_COGNOME),1)?'CORRETTA':'ERRATA'))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "</div>" +
"")
Row_EndHtml(document,l_nEvenOdd,'11089862284'+l_nIdx+'','A')
Parms.Idx=l_nIdx;
Parms.Deep=l_nDeep;
Parms.EvenOdd=l_nEvenOdd;
}
Parms=new Object();
_Obli('Countot',1,'URJECFSAOV',false)
_Obli('Countok',1,'MNRQYNMNLG',false)
_Obli('RAGSOC',0,'MGZZLJDIWH',false)
_Obli('ALLINEAMENTO',0,'FYWCYUCGWN',false)
_Obli('Countpr',1,'YVBXOWMFXO',false)
_Obli('Countpr2',1,'VQPOQZIXZG',false)
_Obli('Countko',1,'OHORDWVXGQ',false)
