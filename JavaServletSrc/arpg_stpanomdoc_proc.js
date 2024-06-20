function SetControlsValue() {
var c;
var c;
if(c=Ctrl('HJLJFAMGNR')) c.value = WtH(w_DaData,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('TPYPFPFGCZ')) ChkboxCheckUncheck(c,'S',w_tipdoc)
if(c=Ctrl('TPYPFPFGCZ')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('NAIKOMJGHQ')) ChkboxCheckUncheck(c,'S',w_numdoc)
if(c=Ctrl('NAIKOMJGHQ')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('SPCDQJZKCR')) ChkboxCheckUncheck(c,'S',w_datril)
if(c=Ctrl('SPCDQJZKCR')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('XJZTGNCSTU')) ChkboxCheckUncheck(c,'S',w_docsca)
if(c=Ctrl('XJZTGNCSTU')) ChkboxValueAssign(c,'S','N','C',10,0,'')
if(c=Ctrl('YVUBYQLEQE')) ChkboxCheckUncheck(c,'S',w_autril)
if(c=Ctrl('YVUBYQLEQE')) ChkboxValueAssign(c,'S','N','C',1,0,'')
var tmp_FGMOCXNBFY = ToHTag(AsControlValue('<iframe width=\'775\' height=\'290\' id=\'elaborazione\'  name=\'elaborazione\' frameborder=\'1\'  border=\'1\' align=\'TOP\' marginwidth=\'1\' marginheight=\'1\'></iframe>'));
if (Ne(e_FGMOCXNBFY,tmp_FGMOCXNBFY)) {
if(c=Ctrl('FGMOCXNBFY')) c.innerHTML=tmp_FGMOCXNBFY;
e_FGMOCXNBFY=tmp_FGMOCXNBFY;
}
if(c=Ctrl('XXKCFDJIUH')) selectCombo(c,w_ChkEst,'N')
if(c=Ctrl('CBLVNWXIBV')) ChkboxCheckUncheck(c,1,w_attive)
if(c=Ctrl('CBLVNWXIBV')) ChkboxValueAssign(c,1,0,'N',1,0,'')
if(c=Ctrl('YADLWQSLYE')) selectRadio(c,w_TABELLA,'C')
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
HideUI();
}
HideUI.lblids["DaData"]=['LQTOQIQYKP'];
function HJLJFAMGNR_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('HJLJFAMGNR'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('HJLJFAMGNR').value=ApplyPictureToDate(Ctrl('HJLJFAMGNR').value,TranslatePicture(datePattern),'HJLJFAMGNR');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('HJLJFAMGNR'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('HJLJFAMGNR');
}
}
}
SetActiveField(Ctrl('HJLJFAMGNR'),false);
e=(Ne(e,null)?e:window.event);
return Set_DaData(HtW(Ctrl('HJLJFAMGNR').value,'D'),null,e) && dateisok;
}
function HJLJFAMGNR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('HJLJFAMGNR'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('HJLJFAMGNR').value=WtH(w_DaData,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('HJLJFAMGNR');
SetActiveField(Ctrl('HJLJFAMGNR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('HJLJFAMGNR'),e);
}
function HJLJFAMGNR_ZOOM_Click() {
LaunchCalendar(Ctrl('HJLJFAMGNR'));
}
function href_NACPPABTRW() {
SetLocationHref(window.location,ToResource('jsp/start_page_logo_portlet.jsp'+'')+'')
}
function href_MAYNQUHJSS() {
var l_oWv = InitWvApplet();
l_oWv.setValue('tipdoc',AsAppletValue(w_tipdoc));
l_oWv.setValue('numdoc',AsAppletValue(w_numdoc));
l_oWv.setValue('datril',AsAppletValue(w_datril));
l_oWv.setValue('docsca',AsAppletValue(w_docsca));
l_oWv.setValue('autril',AsAppletValue(w_autril));
l_oWv.setValue('DaData',AsAppletValue(w_DaData));
l_oWv.setValue('OrderBy',AsAppletValue('RAGSOC'));
l_oWv.setValue('rotation',AsAppletValue('LANDSCAPE'));
l_oWv.setValue('desazi',AsAppletValue(w_gDescAzi));
l_oWv.setValue('showParameterMask',AsAppletValue(false));
l_oWv.setValue('ChkEst',AsAppletValue(w_ChkEst));
l_oWv.setValue('TABELLA',AsAppletValue(w_TABELLA));
l_oWv.setValue('in',AsAppletValue((Eq(w_attive,1)?'\'0\',\'1\'':'\'0\',\'1\',\'2\',\'3\'')));
l_oWv.setValue('attive',AsAppletValue(w_attive));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('tipdoc,numdoc,datril,docsca,autril,DaData,OrderBy,rotation,desazi,showParameterMask,ChkEst,TABELLA,in,attive'));
SetLocationHref(null,'Report?ReportName='+'arrp_stpanomdoc'+'&m_cWv='+URLenc(l_oWv.asString())+'&m_cAtExit=close&m_cMode=hyperlink','elaborazione')
}
function TPYPFPFGCZ_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_tipdoc(ChkboxValueAssign(Ctrl('TPYPFPFGCZ'),'S','N','C',1,0,''),null,e);
}
function TPYPFPFGCZ_OnFocus(e) {
SetActiveField(Ctrl('TPYPFPFGCZ'),true);
}
function TPYPFPFGCZ_OnBlur(e) {
SetActiveField(Ctrl('TPYPFPFGCZ'),false);
}
function NAIKOMJGHQ_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_numdoc(ChkboxValueAssign(Ctrl('NAIKOMJGHQ'),'S','N','C',1,0,''),null,e);
}
function NAIKOMJGHQ_OnFocus(e) {
SetActiveField(Ctrl('NAIKOMJGHQ'),true);
}
function NAIKOMJGHQ_OnBlur(e) {
SetActiveField(Ctrl('NAIKOMJGHQ'),false);
}
function SPCDQJZKCR_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_datril(ChkboxValueAssign(Ctrl('SPCDQJZKCR'),'S','N','C',1,0,''),null,e);
}
function SPCDQJZKCR_OnFocus(e) {
SetActiveField(Ctrl('SPCDQJZKCR'),true);
}
function SPCDQJZKCR_OnBlur(e) {
SetActiveField(Ctrl('SPCDQJZKCR'),false);
}
function XJZTGNCSTU_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_docsca(ChkboxValueAssign(Ctrl('XJZTGNCSTU'),'S','N','C',10,0,''),null,e);
}
function XJZTGNCSTU_OnFocus(e) {
SetActiveField(Ctrl('XJZTGNCSTU'),true);
}
function XJZTGNCSTU_OnBlur(e) {
SetActiveField(Ctrl('XJZTGNCSTU'),false);
}
function YVUBYQLEQE_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_autril(ChkboxValueAssign(Ctrl('YVUBYQLEQE'),'S','N','C',1,0,''),null,e);
}
function YVUBYQLEQE_OnFocus(e) {
SetActiveField(Ctrl('YVUBYQLEQE'),true);
}
function YVUBYQLEQE_OnBlur(e) {
SetActiveField(Ctrl('YVUBYQLEQE'),false);
}
function XXKCFDJIUH_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_ChkEst(HtW(getComboValue(Ctrl('XXKCFDJIUH')),'N'),null,e);
}
function XXKCFDJIUH_OnFocus(e) {
SetActiveField(Ctrl('XXKCFDJIUH'),true);
}
function XXKCFDJIUH_OnBlur(e) {
SetActiveField(Ctrl('XXKCFDJIUH'),false);
}
function CBLVNWXIBV_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_attive(ChkboxValueAssign(Ctrl('CBLVNWXIBV'),1,0,'N',1,0,''),null,e);
}
function CBLVNWXIBV_OnFocus(e) {
SetActiveField(Ctrl('CBLVNWXIBV'),true);
}
function CBLVNWXIBV_OnBlur(e) {
SetActiveField(Ctrl('CBLVNWXIBV'),false);
}
function YADLWQSLYE_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_TABELLA(HtW(getRadioValue(Ctrl('YADLWQSLYE')),'C'),null,e);
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
if(c=Ctrl('HJLJFAMGNR')) c.onblur=HJLJFAMGNR_Valid;
if(c=Ctrl('HJLJFAMGNR')) c.onfocus=HJLJFAMGNR_OnFocus;
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
if(c=Ctrl('HJLJFAMGNR')) c.onkeypress=CheckDateChar;
}
if(c=Ctrl('TPYPFPFGCZ')) c.onclick=TPYPFPFGCZ_Valid;
if(c=Ctrl('TPYPFPFGCZ')) c.onfocus=TPYPFPFGCZ_OnFocus;
if(c=Ctrl('TPYPFPFGCZ')) c.onblur=TPYPFPFGCZ_OnBlur;
if(c=Ctrl('NAIKOMJGHQ')) c.onclick=NAIKOMJGHQ_Valid;
if(c=Ctrl('NAIKOMJGHQ')) c.onfocus=NAIKOMJGHQ_OnFocus;
if(c=Ctrl('NAIKOMJGHQ')) c.onblur=NAIKOMJGHQ_OnBlur;
if(c=Ctrl('SPCDQJZKCR')) c.onclick=SPCDQJZKCR_Valid;
if(c=Ctrl('SPCDQJZKCR')) c.onfocus=SPCDQJZKCR_OnFocus;
if(c=Ctrl('SPCDQJZKCR')) c.onblur=SPCDQJZKCR_OnBlur;
if(c=Ctrl('XJZTGNCSTU')) c.onclick=XJZTGNCSTU_Valid;
if(c=Ctrl('XJZTGNCSTU')) c.onfocus=XJZTGNCSTU_OnFocus;
if(c=Ctrl('XJZTGNCSTU')) c.onblur=XJZTGNCSTU_OnBlur;
if(c=Ctrl('YVUBYQLEQE')) c.onclick=YVUBYQLEQE_Valid;
if(c=Ctrl('YVUBYQLEQE')) c.onfocus=YVUBYQLEQE_OnFocus;
if(c=Ctrl('YVUBYQLEQE')) c.onblur=YVUBYQLEQE_OnBlur;
if(c=Ctrl('XXKCFDJIUH')) c.onchange=XXKCFDJIUH_Valid;
if(c=Ctrl('XXKCFDJIUH')) c.onfocus=XXKCFDJIUH_OnFocus;
if(c=Ctrl('XXKCFDJIUH')) c.onblur=XXKCFDJIUH_OnBlur;
if(c=Ctrl('CBLVNWXIBV')) c.onclick=CBLVNWXIBV_Valid;
if(c=Ctrl('CBLVNWXIBV')) c.onfocus=CBLVNWXIBV_OnFocus;
if(c=Ctrl('CBLVNWXIBV')) c.onblur=CBLVNWXIBV_OnBlur;
c=Ctrl('YADLWQSLYE');
if ( ! (Empty(c))) {
c[0].onclick=YADLWQSLYE_Valid;
c[1].onclick=YADLWQSLYE_Valid;
c[2].onclick=YADLWQSLYE_Valid;
}
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
FocusFirstComponent.otherwise={"page_1":["HJLJFAMGNR"]};
function Help() {
windowOpenForeground('../doc/arpg_stpanomdoc_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_DaData=a[0];
w_tipdoc=a[1];
w_numdoc=a[2];
w_datril=a[3];
w_docsca=a[4];
w_autril=a[5];
w_gDescAzi=a[6];
w_ChkEst=a[7];
w_attive=a[8];
w_TABELLA=a[9];
o_ChkEst=w_ChkEst[1];
w_ChkEst=w_ChkEst[0];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_stpanomdoc',m_cSelectedPage);
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
l_bEnabled= ! (Eq(w_ChkEst,2)) || IsDisabledByStateDriver('attive');
SetDisabled(Ctrl('CBLVNWXIBV'),l_bEnabled);
l_bEnabled= ! (Eq(w_ChkEst,2)) || IsDisabledByStateDriver('TABELLA');
SetDisabled('YADLWQSLYE_DIV',l_bEnabled);
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
function Set_DaData(ctrlValue,kmode,e) {
if (Ne(w_DaData,ctrlValue)) {
var ctl = _GetCtl(e,'HJLJFAMGNR');
if (_tracker.goon(ctl,ctrlValue)) {
w_DaData=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HJLJFAMGNR',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH(NullDate(),'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
_ResetTracker();
return true;
}
}
return true;
}
function Set_tipdoc(ctrlValue,kmode,e) {
if (Ne(w_tipdoc,ctrlValue)) {
var ctl = _GetCtl(e,'TPYPFPFGCZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_tipdoc=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('TPYPFPFGCZ',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_numdoc(ctrlValue,kmode,e) {
if (Ne(w_numdoc,ctrlValue)) {
var ctl = _GetCtl(e,'NAIKOMJGHQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_numdoc=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NAIKOMJGHQ',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_datril(ctrlValue,kmode,e) {
if (Ne(w_datril,ctrlValue)) {
var ctl = _GetCtl(e,'SPCDQJZKCR');
if (_tracker.goon(ctl,ctrlValue)) {
w_datril=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SPCDQJZKCR',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_docsca(ctrlValue,kmode,e) {
if (Ne(w_docsca,ctrlValue)) {
var ctl = _GetCtl(e,'XJZTGNCSTU');
if (_tracker.goon(ctl,ctrlValue)) {
w_docsca=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XJZTGNCSTU',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',10,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_autril(ctrlValue,kmode,e) {
if (Ne(w_autril,ctrlValue)) {
var ctl = _GetCtl(e,'YVUBYQLEQE');
if (_tracker.goon(ctl,ctrlValue)) {
w_autril=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YVUBYQLEQE',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_ChkEst(ctrlValue,kmode,e) {
if (Ne(w_ChkEst,ctrlValue)) {
var ctl = _GetCtl(e,'XXKCFDJIUH');
if (_tracker.goon(ctl,ctrlValue)) {
w_ChkEst=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XXKCFDJIUH',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','N',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_attive(ctrlValue,kmode,e) {
if (Ne(w_attive,ctrlValue)) {
var ctl = _GetCtl(e,'CBLVNWXIBV');
if (_tracker.goon(ctl,ctrlValue)) {
w_attive=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CBLVNWXIBV',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH(0,'N',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_TABELLA(ctrlValue,kmode,e) {
if (Ne(w_TABELLA,ctrlValue)) {
var ctl = _GetCtl(e,'YADLWQSLYE');
if (_tracker.goon(ctl,ctrlValue)) {
w_TABELLA=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YADLWQSLYE',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',10,0,'');
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
if ((Ne(o_ChkEst,w_ChkEst))) {
Calculation_CYOMJYEGGK();
}
// * --- Area Manuale = UI - Calculate
// * --- Fine Area Manuale
m_bCalculating=false;
}
function Calculation_CYOMJYEGGK() {
w_attive=(Eq(w_ChkEst,1)?0:w_attive);
}
function SaveDependsOn() {
o_ChkEst=w_ChkEst;
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
if ( ! (_ChkObl('HJLJFAMGNR',1))) {
_SignErr('HJLJFAMGNR');
m_cLastWorkVarErrorMsg='DaData';
l_bResult=false;
w_DaData=HtW('','D');
} else if ( ! (_ChkObl('TPYPFPFGCZ',1))) {
_SignErr('TPYPFPFGCZ');
m_cLastWorkVarErrorMsg='tipdoc';
l_bResult=false;
w_tipdoc='N';
} else if ( ! (_ChkObl('NAIKOMJGHQ',1))) {
_SignErr('NAIKOMJGHQ');
m_cLastWorkVarErrorMsg='numdoc';
l_bResult=false;
w_numdoc='N';
} else if ( ! (_ChkObl('SPCDQJZKCR',1))) {
_SignErr('SPCDQJZKCR');
m_cLastWorkVarErrorMsg='datril';
l_bResult=false;
w_datril='N';
} else if ( ! (_ChkObl('XJZTGNCSTU',1))) {
_SignErr('XJZTGNCSTU');
m_cLastWorkVarErrorMsg='docsca';
l_bResult=false;
w_docsca='N';
} else if ( ! (_ChkObl('YVUBYQLEQE',1))) {
_SignErr('YVUBYQLEQE');
m_cLastWorkVarErrorMsg='autril';
l_bResult=false;
w_autril='N';
} else if ( ! (_ChkObl('XXKCFDJIUH',1))) {
_SignErr('XXKCFDJIUH');
m_cLastWorkVarErrorMsg='ChkEst';
l_bResult=false;
w_ChkEst=HtW('','N');
} else if ((Eq(w_ChkEst,2)) && ( ! (_ChkObl('CBLVNWXIBV',1)))) {
_SignErr('CBLVNWXIBV');
m_cLastWorkVarErrorMsg='attive';
l_bResult=false;
w_attive=0;
} else if ((Eq(w_ChkEst,2)) && ( ! (_ChkObl('YADLWQSLYE',1)))) {
_SignErr('YADLWQSLYE');
m_cLastWorkVarErrorMsg='TABELLA';
l_bResult=false;
w_TABELLA=HtW('','C');
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('HJLJFAMGNR_ZOOM',lc)) {
return 0;
}
return -1;
}
function link_url(index) {
var l_oWv;
}
function FillWv() {
var l_oWv = InitWvApplet();
l_oWv.setValue('DaData',WtA(w_DaData,'D'));
l_oWv.setValue('tipdoc',WtA(w_tipdoc,'C'));
l_oWv.setValue('numdoc',WtA(w_numdoc,'C'));
l_oWv.setValue('datril',WtA(w_datril,'C'));
l_oWv.setValue('docsca',WtA(w_docsca,'C'));
l_oWv.setValue('autril',WtA(w_autril,'C'));
l_oWv.setValue('gDescAzi',WtA(w_gDescAzi,'C'));
l_oWv.setValue('ChkEst',WtA(w_ChkEst,'N'));
l_oWv.setValue('attive',WtA(w_attive,'N'));
l_oWv.setValue('TABELLA',WtA(w_TABELLA,'C'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["DaData","tipdoc","numdoc","datril","docsca","autril","gDescAzi","ChkEst","attive","TABELLA"];
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
if (start && Eq(At(',DaData,',pseq),0)) {
w_DaData=SystemDate();
}
if (start && Eq(At(',tipdoc,',pseq),0)) {
w_tipdoc='S';
}
if (start && Eq(At(',numdoc,',pseq),0)) {
w_numdoc='S';
}
if (start && Eq(At(',datril,',pseq),0)) {
w_datril='S';
}
if (start && Eq(At(',docsca,',pseq),0)) {
w_docsca='S';
}
if (start && Eq(At(',autril,',pseq),0)) {
w_autril='S';
}
if (start && Eq(At(',ChkEst,',pseq),0)) {
w_ChkEst=1;
}
if (start && Eq(At(',TABELLA,',pseq),0)) {
w_TABELLA='intestbo';
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
_Obli('DaData',2,'HJLJFAMGNR',false)
_Obli('tipdoc',0,'TPYPFPFGCZ',false)
_Obli('numdoc',0,'NAIKOMJGHQ',false)
_Obli('datril',0,'SPCDQJZKCR',false)
_Obli('docsca',0,'XJZTGNCSTU',false)
_Obli('autril',0,'YVUBYQLEQE',false)
_Obli('ChkEst',1,'XXKCFDJIUH',false)
_Obli('attive',1,'CBLVNWXIBV',false)
_Obli('TABELLA',0,'YADLWQSLYE',false)
