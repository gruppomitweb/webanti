function SetControlsValue() {
var c;
var c;
if(c=Ctrl('FFEEVEUPBF')) selectCombo(c,w_ragione,'C')
if(c=Ctrl('JIYGZCDTPQ')) c.value = WtH(w_datarett,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('JUUJSFSION')) selectCombo(c,w_oldcoint,'C')
if(c=Ctrl('PYXAYWXXOA')) selectCombo(c,w_newcoint,'C')
if(c=Ctrl('NCMJUZUAHQ')) selectCombo(c,w_oldtipoag,'C')
if(c=Ctrl('OJUCHYRKTN')) selectCombo(c,w_newtipoag,'C')
if(c=Ctrl('RROSTBCQKE')) c.value = WtH(w_idesito,'C',8,0,'')
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay(Ctrl('MDWFLPZWFN'),Ne(w_ragione,'S') && Ne(w_ragione,'N'));
HideUI();
}
HideUI.lblids["datarett"]=['XQSJGZVMDV'];
HideUI.lblids["idesito"]=['EFJEEIKTHM'];
HideUI.lblids["newtipoag"]=['ISRGWEYPBE'];
HideUI.lblids["oldcoint"]=['XNJFDYSFME'];
HideUI.lblids["oldtipoag"]=['AXQHAOFAHG'];
function FFEEVEUPBF_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_ragione(HtW(getComboValue(Ctrl('FFEEVEUPBF')),'C'),null,e);
}
function FFEEVEUPBF_OnFocus(e) {
SetActiveField(Ctrl('FFEEVEUPBF'),true);
}
function FFEEVEUPBF_OnBlur(e) {
SetActiveField(Ctrl('FFEEVEUPBF'),false);
}
function JIYGZCDTPQ_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('JIYGZCDTPQ'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('JIYGZCDTPQ').value=ApplyPictureToDate(Ctrl('JIYGZCDTPQ').value,TranslatePicture(datePattern),'JIYGZCDTPQ');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('JIYGZCDTPQ'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('JIYGZCDTPQ');
}
}
}
SetActiveField(Ctrl('JIYGZCDTPQ'),false);
e=(Ne(e,null)?e:window.event);
return Set_datarett(HtW(Ctrl('JIYGZCDTPQ').value,'D'),null,e) && dateisok;
}
function JIYGZCDTPQ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('JIYGZCDTPQ'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('JIYGZCDTPQ').value=WtH(w_datarett,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('JIYGZCDTPQ');
SetActiveField(Ctrl('JIYGZCDTPQ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('JIYGZCDTPQ'),e);
}
function JIYGZCDTPQ_ZOOM_Click() {
LaunchCalendar(Ctrl('JIYGZCDTPQ'));
}
function href_YBBLCLWLHJ() {
window.close()
}
function href_MDWFLPZWFN() {
SetHypPar('m_cAction',AsAppletValue('start'));
SetHypPar('m_cMode',AsAppletValue('hyperlink'));
SetHypPar('m_cID',AsAppletValue(m_IDS['arrt_modopen2']));
SendData('start','arrt_modopen2'+'',HParApplet().asString());
}
function JUUJSFSION_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_oldcoint(HtW(getComboValue(Ctrl('JUUJSFSION')),'C'),null,e);
}
function JUUJSFSION_OnFocus(e) {
SetActiveField(Ctrl('JUUJSFSION'),true);
}
function JUUJSFSION_OnBlur(e) {
SetActiveField(Ctrl('JUUJSFSION'),false);
}
function PYXAYWXXOA_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_newcoint(HtW(getComboValue(Ctrl('PYXAYWXXOA')),'C'),null,e);
}
function PYXAYWXXOA_OnFocus(e) {
SetActiveField(Ctrl('PYXAYWXXOA'),true);
}
function PYXAYWXXOA_OnBlur(e) {
SetActiveField(Ctrl('PYXAYWXXOA'),false);
}
function NCMJUZUAHQ_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_oldtipoag(HtW(getComboValue(Ctrl('NCMJUZUAHQ')),'C'),null,e);
}
function NCMJUZUAHQ_OnFocus(e) {
SetActiveField(Ctrl('NCMJUZUAHQ'),true);
}
function NCMJUZUAHQ_OnBlur(e) {
SetActiveField(Ctrl('NCMJUZUAHQ'),false);
}
function OJUCHYRKTN_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_newtipoag(HtW(getComboValue(Ctrl('OJUCHYRKTN')),'C'),null,e);
}
function OJUCHYRKTN_OnFocus(e) {
SetActiveField(Ctrl('OJUCHYRKTN'),true);
}
function OJUCHYRKTN_OnBlur(e) {
SetActiveField(Ctrl('OJUCHYRKTN'),false);
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
if(c=Ctrl('FFEEVEUPBF')) c.onchange=FFEEVEUPBF_Valid;
if(c=Ctrl('FFEEVEUPBF')) c.onfocus=FFEEVEUPBF_OnFocus;
if(c=Ctrl('FFEEVEUPBF')) c.onblur=FFEEVEUPBF_OnBlur;
if(c=Ctrl('JIYGZCDTPQ')) c.onblur=JIYGZCDTPQ_Valid;
if(c=Ctrl('JIYGZCDTPQ')) c.onfocus=JIYGZCDTPQ_OnFocus;
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
if(c=Ctrl('JIYGZCDTPQ')) c.onkeypress=CheckDateChar;
}
if(c=Ctrl('JUUJSFSION')) c.onchange=JUUJSFSION_Valid;
if(c=Ctrl('JUUJSFSION')) c.onfocus=JUUJSFSION_OnFocus;
if(c=Ctrl('JUUJSFSION')) c.onblur=JUUJSFSION_OnBlur;
if(c=Ctrl('PYXAYWXXOA')) c.onchange=PYXAYWXXOA_Valid;
if(c=Ctrl('PYXAYWXXOA')) c.onfocus=PYXAYWXXOA_OnFocus;
if(c=Ctrl('PYXAYWXXOA')) c.onblur=PYXAYWXXOA_OnBlur;
if(c=Ctrl('NCMJUZUAHQ')) c.onchange=NCMJUZUAHQ_Valid;
if(c=Ctrl('NCMJUZUAHQ')) c.onfocus=NCMJUZUAHQ_OnFocus;
if(c=Ctrl('NCMJUZUAHQ')) c.onblur=NCMJUZUAHQ_OnBlur;
if(c=Ctrl('OJUCHYRKTN')) c.onchange=OJUCHYRKTN_Valid;
if(c=Ctrl('OJUCHYRKTN')) c.onfocus=OJUCHYRKTN_OnFocus;
if(c=Ctrl('OJUCHYRKTN')) c.onblur=OJUCHYRKTN_OnBlur;
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
FocusFirstComponent.otherwise={"page_1":["FFEEVEUPBF"]};
function Help() {
windowOpenForeground('../doc/arpg_modopen2_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_ragione=a[0];
w_datarett=a[1];
w_oldprog=a[2];
w_oldidbase=a[3];
w_oldrappo=a[4];
w_oldrnumrig=a[5];
w_oldfile=a[6];
w_oldcoint=a[7];
w_newcoint=a[8];
w_oldtipoag=a[9];
w_newtipoag=a[10];
w_idesito=a[11];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_modopen2',m_cSelectedPage);
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
l_bEnabled= ! (Ne(1,1)) || IsDisabledByStateDriver('oldcoint');
SetDisabled(Ctrl('JUUJSFSION'),l_bEnabled);
l_bEnabled= ! (Ne(1,1)) || IsDisabledByStateDriver('oldtipoag');
SetDisabled(Ctrl('NCMJUZUAHQ'),l_bEnabled);
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
function Set_ragione(ctrlValue,kmode,e) {
if (Ne(w_ragione,ctrlValue)) {
var ctl = _GetCtl(e,'FFEEVEUPBF');
if (_tracker.goon(ctl,ctrlValue)) {
w_ragione=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FFEEVEUPBF',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_datarett(ctrlValue,kmode,e) {
if (Ne(w_datarett,ctrlValue)) {
var ctl = _GetCtl(e,'JIYGZCDTPQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_datarett=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('JIYGZCDTPQ',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH(NullDate(),'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
_ResetTracker();
return true;
}
}
return true;
}
function Set_oldtipoag(ctrlValue,kmode,e) {
if (Ne(w_oldtipoag,ctrlValue)) {
var ctl = _GetCtl(e,'NCMJUZUAHQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_oldtipoag=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NCMJUZUAHQ',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',2,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_newtipoag(ctrlValue,kmode,e) {
if (Ne(w_newtipoag,ctrlValue)) {
var ctl = _GetCtl(e,'OJUCHYRKTN');
if (_tracker.goon(ctl,ctrlValue)) {
w_newtipoag=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('OJUCHYRKTN',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',2,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_oldcoint(ctrlValue,kmode,e) {
if (Ne(w_oldcoint,ctrlValue)) {
var ctl = _GetCtl(e,'JUUJSFSION');
if (_tracker.goon(ctl,ctrlValue)) {
w_oldcoint=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('JUUJSFSION',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_newcoint(ctrlValue,kmode,e) {
if (Ne(w_newcoint,ctrlValue)) {
var ctl = _GetCtl(e,'PYXAYWXXOA');
if (_tracker.goon(ctl,ctrlValue)) {
w_newcoint=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('PYXAYWXXOA',0);
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
if ( ! (_ChkObl('FFEEVEUPBF',1))) {
_SignErr('FFEEVEUPBF');
m_cLastWorkVarErrorMsg='ragione';
l_bResult=false;
w_ragione=HtW('','C');
} else if ( ! (_ChkObl('JIYGZCDTPQ',1))) {
_SignErr('JIYGZCDTPQ');
m_cLastWorkVarErrorMsg='datarett';
l_bResult=false;
w_datarett=HtW('','D');
} else if ((Ne(1,1)) && ( ! (_ChkObl('JUUJSFSION',1)))) {
_SignErr('JUUJSFSION');
m_cLastWorkVarErrorMsg='oldcoint';
l_bResult=false;
w_oldcoint=HtW('','C');
} else if ( ! (_ChkObl('PYXAYWXXOA',1))) {
_SignErr('PYXAYWXXOA');
m_cLastWorkVarErrorMsg='newcoint';
l_bResult=false;
w_newcoint=HtW('','C');
} else if ((Ne(1,1)) && ( ! (_ChkObl('NCMJUZUAHQ',1)))) {
_SignErr('NCMJUZUAHQ');
m_cLastWorkVarErrorMsg='oldtipoag';
l_bResult=false;
w_oldtipoag=HtW('','C');
} else if ( ! (_ChkObl('OJUCHYRKTN',1))) {
_SignErr('OJUCHYRKTN');
m_cLastWorkVarErrorMsg='newtipoag';
l_bResult=false;
w_newtipoag=HtW('','C');
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('JIYGZCDTPQ_ZOOM',lc)) {
return 0;
}
return -1;
}
function link_url(index) {
var l_oWv;
}
function FillWv() {
var l_oWv = InitWvApplet();
l_oWv.setValue('ragione',WtA(w_ragione,'C'));
l_oWv.setValue('datarett',WtA(w_datarett,'D'));
l_oWv.setValue('oldprog',WtA(w_oldprog,'C'));
l_oWv.setValue('oldidbase',WtA(w_oldidbase,'C'));
l_oWv.setValue('oldrappo',WtA(w_oldrappo,'C'));
l_oWv.setValue('oldrnumrig',WtA(w_oldrnumrig,'N'));
l_oWv.setValue('oldfile',WtA(w_oldfile,'C'));
l_oWv.setValue('oldcoint',WtA(w_oldcoint,'C'));
l_oWv.setValue('newcoint',WtA(w_newcoint,'C'));
l_oWv.setValue('oldtipoag',WtA(w_oldtipoag,'C'));
l_oWv.setValue('newtipoag',WtA(w_newtipoag,'C'));
l_oWv.setValue('idesito',WtA(w_idesito,'C'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["ragione","datarett","oldprog","oldidbase","oldrappo","oldrnumrig","oldfile","oldcoint","newcoint","oldtipoag","newtipoag","idesito"];
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
if (Eq(w_datarett,SystemDate()) && Ne(opener.w_datarett,null)) {
TransferBetweenWindows(opener,'w_datarett',null,'Set_datarett');
}
if (Empty(w_oldprog) && Ne(opener.w_oldprog,null)) {
TransferBetweenWindows(opener,'w_oldprog','w_oldprog');
}
if (Empty(w_oldidbase) && Ne(opener.w_oldidbase,null)) {
TransferBetweenWindows(opener,'w_oldidbase','w_oldidbase');
}
if (Empty(w_oldrappo) && Ne(opener.w_oldrappo,null)) {
TransferBetweenWindows(opener,'w_oldrappo','w_oldrappo');
}
if (Empty(w_oldrnumrig) && Ne(opener.w_oldrnumrig,null)) {
TransferBetweenWindows(opener,'w_oldrnumrig','w_oldrnumrig');
}
if (Empty(w_oldfile) && Ne(opener.w_oldfile,null)) {
TransferBetweenWindows(opener,'w_oldfile','w_oldfile');
}
if (Empty(w_oldcoint) && Ne(opener.w_oldcoint,null)) {
TransferBetweenWindows(opener,'w_oldcoint',null,'Set_oldcoint');
}
if (Eq(w_newcoint,w_oldcoint) && Ne(opener.w_newcoint,null)) {
TransferBetweenWindows(opener,'w_newcoint',null,'Set_newcoint');
}
if (Empty(w_oldtipoag) && Ne(opener.w_oldtipoag,null)) {
TransferBetweenWindows(opener,'w_oldtipoag',null,'Set_oldtipoag');
}
if (Empty(w_newtipoag) && Ne(opener.w_newtipoag,null)) {
TransferBetweenWindows(opener,'w_newtipoag',null,'Set_newtipoag');
}
}
}
m_bCalculating=true;
if (start && Eq(At(',datarett,',pseq),0)) {
w_datarett=SystemDate();
}
if (start && Eq(At(',newcoint,',pseq),0)) {
w_newcoint=w_oldcoint;
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
_Obli('ragione',0,'FFEEVEUPBF',false)
_Obli('datarett',2,'JIYGZCDTPQ',false)
_Obli('oldtipoag',0,'NCMJUZUAHQ',false)
_Obli('newtipoag',0,'OJUCHYRKTN',false)
_Obli('oldcoint',0,'JUUJSFSION',false)
_Obli('newcoint',0,'PYXAYWXXOA',false)
