function SetControlsValue() {
var c;
var c;
var tmp_FGMOCXNBFY = ToHTag(AsControlValue('<iframe width=\'655\' height=\'170\' id =\'elaborazione\' name=\'elaborazione\' frameborder=\'1\'  border=\'1\' align=\'TOP\' marginwidth=\'1\' marginheight=\'1\'></iframe>'));
if (Ne(e_FGMOCXNBFY,tmp_FGMOCXNBFY)) {
if(c=Ctrl('FGMOCXNBFY')) c.innerHTML=tmp_FGMOCXNBFY;
e_FGMOCXNBFY=tmp_FGMOCXNBFY;
}
if(c=Ctrl('WRTPNXYBLS')) c.value = WtH(w_datvar,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('GFPAURJCGW')) ChkboxCheckUncheck(c,'S',w_flgoper)
if(c=Ctrl('GFPAURJCGW')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('ZOXRKECWBC')) ChkboxCheckUncheck(c,'S',w_flg5455)
if(c=Ctrl('ZOXRKECWBC')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('JTSMGKQWHI')) ChkboxCheckUncheck(c,'S',w_flg3132)
if(c=Ctrl('JTSMGKQWHI')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay(Ctrl('FGMOCXNBFY'),true);
HideUI();
}
HideUI.lblids["datvar"]=['PTWSIDIWHJ'];
function href_WBBXZNSMTG() {
window.close()
}
function href_OMQMTTPVQV() {
var l_oWv = InitWvApplet();
l_oWv.setValue('w_oldcon',AsAppletValue(w_oldcon));
l_oWv.setValue('w_datvar',AsAppletValue(w_datvar));
l_oWv.setValue('w_flgoper',AsAppletValue(w_flgoper));
l_oWv.setValue('w_flg3132',AsAppletValue(w_flg3132));
l_oWv.setValue('w_flg5455',AsAppletValue(w_flg5455));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('w_oldcon,w_datvar,w_flgoper,w_flg3132,w_flg5455'));
if (false || WindowConfirm(Translate('10661510886'))) {
SetLocationHref(null,'arrt_chg_create'+'?m_cWv='+URLenc(l_oWv.asString())+'&m_cAction=start&m_cMode=hyperlink','elaborazione')
}
}
function GFPAURJCGW_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_flgoper(ChkboxValueAssign(Ctrl('GFPAURJCGW'),'S','N','C',1,0,''),null,e);
}
function GFPAURJCGW_OnFocus(e) {
SetActiveField(Ctrl('GFPAURJCGW'),true);
}
function GFPAURJCGW_OnBlur(e) {
SetActiveField(Ctrl('GFPAURJCGW'),false);
}
function ZOXRKECWBC_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_flg5455(ChkboxValueAssign(Ctrl('ZOXRKECWBC'),'S','N','C',1,0,''),null,e);
}
function ZOXRKECWBC_OnFocus(e) {
SetActiveField(Ctrl('ZOXRKECWBC'),true);
}
function ZOXRKECWBC_OnBlur(e) {
SetActiveField(Ctrl('ZOXRKECWBC'),false);
}
function JTSMGKQWHI_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_flg3132(ChkboxValueAssign(Ctrl('JTSMGKQWHI'),'S','N','C',1,0,''),null,e);
}
function JTSMGKQWHI_OnFocus(e) {
SetActiveField(Ctrl('JTSMGKQWHI'),true);
}
function JTSMGKQWHI_OnBlur(e) {
SetActiveField(Ctrl('JTSMGKQWHI'),false);
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
if(c=Ctrl('GFPAURJCGW')) c.onclick=GFPAURJCGW_Valid;
if(c=Ctrl('GFPAURJCGW')) c.onfocus=GFPAURJCGW_OnFocus;
if(c=Ctrl('GFPAURJCGW')) c.onblur=GFPAURJCGW_OnBlur;
if(c=Ctrl('ZOXRKECWBC')) c.onclick=ZOXRKECWBC_Valid;
if(c=Ctrl('ZOXRKECWBC')) c.onfocus=ZOXRKECWBC_OnFocus;
if(c=Ctrl('ZOXRKECWBC')) c.onblur=ZOXRKECWBC_OnBlur;
if(c=Ctrl('JTSMGKQWHI')) c.onclick=JTSMGKQWHI_Valid;
if(c=Ctrl('JTSMGKQWHI')) c.onfocus=JTSMGKQWHI_OnFocus;
if(c=Ctrl('JTSMGKQWHI')) c.onblur=JTSMGKQWHI_OnBlur;
}
}
function NotifyEvent(p_cEvent) {
var old_c;
if (Ne(typeof(w_Messaggi),'undefined')) {
w_Messaggi.raiseEvent('arpg_chg_create_'+Strtran(p_cEvent,' ','_'));
}
if (Ne(typeof(w_Log),'undefined')) {
w_Log.raiseEvent('arpg_chg_create_'+Strtran(p_cEvent,' ','_'));
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
FocusFirstComponent.otherwise={"page_1":["GFPAURJCGW"]};
function Help() {
windowOpenForeground('../doc/arpg_chg_create_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_oldcon=a[0];
w_datvar=a[1];
w_flgoper=a[2];
w_flg5455=a[3];
w_flg3132=a[4];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_chg_create',m_cSelectedPage);
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
function Set_flgoper(ctrlValue,kmode,e) {
if (Ne(w_flgoper,ctrlValue)) {
var ctl = _GetCtl(e,'GFPAURJCGW');
if (_tracker.goon(ctl,ctrlValue)) {
w_flgoper=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('GFPAURJCGW',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_flg3132(ctrlValue,kmode,e) {
if (Ne(w_flg3132,ctrlValue)) {
var ctl = _GetCtl(e,'JTSMGKQWHI');
if (_tracker.goon(ctl,ctrlValue)) {
w_flg3132=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('JTSMGKQWHI',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_flg5455(ctrlValue,kmode,e) {
if (Ne(w_flg5455,ctrlValue)) {
var ctl = _GetCtl(e,'ZOXRKECWBC');
if (_tracker.goon(ctl,ctrlValue)) {
w_flg5455=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ZOXRKECWBC',0);
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
w_datvar=SystemDate();
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
if ( ! (_ChkObl('GFPAURJCGW',1))) {
_SignErr('GFPAURJCGW');
m_cLastWorkVarErrorMsg='flgoper';
l_bResult=false;
w_flgoper='N';
} else if ( ! (_ChkObl('ZOXRKECWBC',1))) {
_SignErr('ZOXRKECWBC');
m_cLastWorkVarErrorMsg='flg5455';
l_bResult=false;
w_flg5455='N';
} else if ( ! (_ChkObl('JTSMGKQWHI',1))) {
_SignErr('JTSMGKQWHI');
m_cLastWorkVarErrorMsg='flg3132';
l_bResult=false;
w_flg3132='N';
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
l_oWv.setValue('oldcon',WtA(w_oldcon,'C'));
l_oWv.setValue('datvar',WtA(w_datvar,'D'));
l_oWv.setValue('flgoper',WtA(w_flgoper,'C'));
l_oWv.setValue('flg5455',WtA(w_flg5455,'C'));
l_oWv.setValue('flg3132',WtA(w_flg3132,'C'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["oldcon","datvar","flgoper","flg5455","flg3132"];
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
if (Empty(w_oldcon) && Ne(opener.w_oldcon,null)) {
TransferBetweenWindows(opener,'w_oldcon','w_oldcon');
}
}
}
m_bCalculating=true;
w_datvar=SystemDate();
if (start && Eq(At(',flgoper,',pseq),0)) {
w_flgoper='N';
}
if (start && Eq(At(',flg5455,',pseq),0)) {
w_flg5455='S';
}
if (start && Eq(At(',flg3132,',pseq),0)) {
w_flg3132='S';
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
_Obli('flgoper',0,'GFPAURJCGW',false)
_Obli('flg3132',0,'JTSMGKQWHI',false)
_Obli('flg5455',0,'ZOXRKECWBC',false)
