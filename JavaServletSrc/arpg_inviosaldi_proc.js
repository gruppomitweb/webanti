function SetControlsValue() {
var c;
var c;
var tmp_FGMOCXNBFY = ToHTag(AsControlValue('<iframe width=\'655\' height=\'170\' id=\'elaborazione\' name=\'elaborazione\' frameborder=\'1\'  border=\'1\' align=\'TOP\' marginwidth=\'1\' marginheight=\'1\'></iframe>'));
if (Ne(e_FGMOCXNBFY,tmp_FGMOCXNBFY)) {
if(c=Ctrl('FGMOCXNBFY')) c.innerHTML=tmp_FGMOCXNBFY;
e_FGMOCXNBFY=tmp_FGMOCXNBFY;
}
if(c=Ctrl('ARPOSSWZCD')) c.value = WtH(w_anno,'N',4,0,'')
if(c=Ctrl('FSXHJAAZGG')) c.value = WtH(w_dadata,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('CLVVMIYSQG')) c.value = WtH(w_a_data,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('JBOHPWAKFC')) ChkboxCheckUncheck(c,'S',w_flgcod)
if(c=Ctrl('JBOHPWAKFC')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('UXGCXAEXNI')) ChkboxCheckUncheck(c,'S',w_flgstp)
if(c=Ctrl('UXGCXAEXNI')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('DNHZZAJOTQ')) ChkboxCheckUncheck(c,'S',w_flgnum)
if(c=Ctrl('DNHZZAJOTQ')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay(Ctrl('FGMOCXNBFY'),true);
HideUI();
}
HideUI.lblids["a_data"]=['LFJQIXRRKM'];
HideUI.lblids["anno"]=['YSEECXVRFO'];
function ARPOSSWZCD_Valid(e) {
SetActiveField(Ctrl('ARPOSSWZCD'),false);
e=(Ne(e,null)?e:window.event);
return Set_anno(HtW(Ctrl('ARPOSSWZCD').value,'N'),null,e);
}
function ARPOSSWZCD_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ARPOSSWZCD'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('ARPOSSWZCD'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ARPOSSWZCD'),e);
}
function href_GEDJGVMCKZ() {
SetLocationHref(null,'arrt_inviosaldi'+'?m_cAction=start&m_cMode=hyperlink','elaborazione')
}
function href_AJXISNWTIP() {
SetLocationHref(window.location,ToResource('jsp/start_page_logo_portlet.jsp'+'')+'')
}
function href_AZVXWCAMFB() {
var l_oWv = InitWvApplet();
l_oWv.setValue('rotation',AsAppletValue('LANDSCAPE'));
l_oWv.setValue('w_anno',AsAppletValue(w_anno));
l_oWv.setValue('w_DescAzi',AsAppletValue(w_gDescAzi));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('rotation,w_anno,w_DescAzi'));
_modifyandopen('Report?ReportName='+'arrp_inviosaldi_esito'+'&m_cWv='+URLenc(l_oWv.asString())+'&m_cMode=hyperlink','scrollbars=1,toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes,height=200,width=300',null)
}
function href_JABYWGOJIQ() {
var l_oWv = InitWvApplet();
l_oWv.setValue('rotation',AsAppletValue('LANDSCAPE'));
l_oWv.setValue('w_anno',AsAppletValue(w_anno));
l_oWv.setValue('w_DescAzi',AsAppletValue(w_gDescAzi));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('rotation,w_anno,w_DescAzi'));
_modifyandopen('Report?ReportName='+'arrp_inviosaldi_anomalie'+'&m_cWv='+URLenc(l_oWv.asString())+'&m_cMode=hyperlink','scrollbars=1,toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes,height=200,width=300',null)
}
function JBOHPWAKFC_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_flgcod(ChkboxValueAssign(Ctrl('JBOHPWAKFC'),'S','N','C',1,0,''),null,e);
}
function JBOHPWAKFC_OnFocus(e) {
SetActiveField(Ctrl('JBOHPWAKFC'),true);
}
function JBOHPWAKFC_OnBlur(e) {
SetActiveField(Ctrl('JBOHPWAKFC'),false);
}
function UXGCXAEXNI_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_flgstp(ChkboxValueAssign(Ctrl('UXGCXAEXNI'),'S','N','C',1,0,''),null,e);
}
function UXGCXAEXNI_OnFocus(e) {
SetActiveField(Ctrl('UXGCXAEXNI'),true);
}
function UXGCXAEXNI_OnBlur(e) {
SetActiveField(Ctrl('UXGCXAEXNI'),false);
}
function DNHZZAJOTQ_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_flgnum(ChkboxValueAssign(Ctrl('DNHZZAJOTQ'),'S','N','C',1,0,''),null,e);
}
function DNHZZAJOTQ_OnFocus(e) {
SetActiveField(Ctrl('DNHZZAJOTQ'),true);
}
function DNHZZAJOTQ_OnBlur(e) {
SetActiveField(Ctrl('DNHZZAJOTQ'),false);
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
if(c=Ctrl('ARPOSSWZCD')) c.onblur=ARPOSSWZCD_Valid;
if(c=Ctrl('ARPOSSWZCD')) c.onfocus=ARPOSSWZCD_OnFocus;
if(c=Ctrl('ARPOSSWZCD')) c.onkeypress=CheckNum;
if(c=Ctrl('JBOHPWAKFC')) c.onclick=JBOHPWAKFC_Valid;
if(c=Ctrl('JBOHPWAKFC')) c.onfocus=JBOHPWAKFC_OnFocus;
if(c=Ctrl('JBOHPWAKFC')) c.onblur=JBOHPWAKFC_OnBlur;
if(c=Ctrl('UXGCXAEXNI')) c.onclick=UXGCXAEXNI_Valid;
if(c=Ctrl('UXGCXAEXNI')) c.onfocus=UXGCXAEXNI_OnFocus;
if(c=Ctrl('UXGCXAEXNI')) c.onblur=UXGCXAEXNI_OnBlur;
if(c=Ctrl('DNHZZAJOTQ')) c.onclick=DNHZZAJOTQ_Valid;
if(c=Ctrl('DNHZZAJOTQ')) c.onfocus=DNHZZAJOTQ_OnFocus;
if(c=Ctrl('DNHZZAJOTQ')) c.onblur=DNHZZAJOTQ_OnBlur;
}
}
function NotifyEvent(p_cEvent) {
var old_c;
if (Ne(typeof(w_Messaggi),'undefined')) {
w_Messaggi.raiseEvent('arpg_inviosaldi_'+Strtran(p_cEvent,' ','_'));
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
FocusFirstComponent.otherwise={"page_1":["ARPOSSWZCD"]};
function Help() {
windowOpenForeground('../doc/arpg_inviosaldi_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_anno=a[0];
w_dadata=a[1];
w_a_data=a[2];
w_gDescAzi=a[3];
w_flgcod=a[4];
w_flgstp=a[5];
w_flgnum=a[6];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_inviosaldi',m_cSelectedPage);
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
function Set_anno(ctrlValue,kmode,e) {
if (Ne(w_anno,ctrlValue)) {
var ctl = _GetCtl(e,'ARPOSSWZCD');
if (_tracker.goon(ctl,ctrlValue)) {
w_anno=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ARPOSSWZCD',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','N',4,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_flgstp(ctrlValue,kmode,e) {
if (Ne(w_flgstp,ctrlValue)) {
var ctl = _GetCtl(e,'UXGCXAEXNI');
if (_tracker.goon(ctl,ctrlValue)) {
w_flgstp=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UXGCXAEXNI',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_flgnum(ctrlValue,kmode,e) {
if (Ne(w_flgnum,ctrlValue)) {
var ctl = _GetCtl(e,'DNHZZAJOTQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_flgnum=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('DNHZZAJOTQ',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_flgcod(ctrlValue,kmode,e) {
if (Ne(w_flgcod,ctrlValue)) {
var ctl = _GetCtl(e,'JBOHPWAKFC');
if (_tracker.goon(ctl,ctrlValue)) {
w_flgcod=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('JBOHPWAKFC',0);
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
w_dadata=(Eq(w_anno,0)?NullDate():CharToDate(Str(w_anno,4,0)+'0101'));
w_a_data=(Eq(w_anno,0)?NullDate():CharToDate(Str(w_anno,4,0)+'1231'));
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
if ( ! (_ChkObl('ARPOSSWZCD',1))) {
_SignErr('ARPOSSWZCD');
m_cLastWorkVarErrorMsg='863017169';
l_bResult=false;
w_anno=HtW('','N');
} else if ( ! (_ChkObl('JBOHPWAKFC',1))) {
_SignErr('JBOHPWAKFC');
m_cLastWorkVarErrorMsg='flgcod';
l_bResult=false;
w_flgcod='N';
} else if ( ! (_ChkObl('UXGCXAEXNI',1))) {
_SignErr('UXGCXAEXNI');
m_cLastWorkVarErrorMsg='flgstp';
l_bResult=false;
w_flgstp='N';
} else if ( ! (_ChkObl('DNHZZAJOTQ',1))) {
_SignErr('DNHZZAJOTQ');
m_cLastWorkVarErrorMsg='flgnum';
l_bResult=false;
w_flgnum='N';
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
l_oWv.setValue('anno',WtA(w_anno,'N'));
l_oWv.setValue('dadata',WtA(w_dadata,'D'));
l_oWv.setValue('a_data',WtA(w_a_data,'D'));
l_oWv.setValue('gDescAzi',WtA(w_gDescAzi,'C'));
l_oWv.setValue('flgcod',WtA(w_flgcod,'C'));
l_oWv.setValue('flgstp',WtA(w_flgstp,'C'));
l_oWv.setValue('flgnum',WtA(w_flgnum,'C'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["anno","dadata","a_data","gDescAzi","flgcod","flgstp","flgnum"];
function SetModified(bRepeated) {
m_bUpdated=true;
if (bRepeated) {
if (Le(m_nCurrentRow,m_oTrsFW.length)) {
m_nRowStatus=1;
}
}
}
function initNoLocalVars(start,pseq) {
m_bCalculating=true;
if (start && Eq(At(',anno,',pseq),0)) {
w_anno=Year(SystemDate())-1;
}
w_dadata=(Eq(w_anno,0)?NullDate():CharToDate(Str(w_anno,4,0)+'0101'));
w_a_data=(Eq(w_anno,0)?NullDate():CharToDate(Str(w_anno,4,0)+'1231'));
if (start && Eq(At(',flgcod,',pseq),0)) {
w_flgcod='N';
}
if (start && Eq(At(',flgstp,',pseq),0)) {
w_flgstp='N';
}
if (start && Eq(At(',flgnum,',pseq),0)) {
w_flgnum='N';
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
_Obli('anno',1,'ARPOSSWZCD',false,"863017169")
_Obli('flgstp',0,'UXGCXAEXNI',false)
_Obli('flgnum',0,'DNHZZAJOTQ',false)
_Obli('flgcod',0,'JBOHPWAKFC',false)
