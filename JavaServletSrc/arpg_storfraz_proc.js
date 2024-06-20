function SetControlsValue() {
var c;
var c;
if(c=Ctrl('QSGNEETWVH')) selectRadio(c,w_tipoope,'C')
if(c=Ctrl('HJLJFAMGNR')) c.value = WtH(w_DaDatOpe,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('XWZHWTENET')) c.value = WtH(w_ADatOpe,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
var tmp_FGMOCXNBFY = ToHTag(AsControlValue('<iframe width=\'655\' height=\'170\' id=\'elaborazione\' name=\'elaborazione\' frameborder=\'1\'  border=\'1\' align=\'TOP\' marginwidth=\'1\' marginheight=\'1\'></iframe>'));
if (Ne(e_FGMOCXNBFY,tmp_FGMOCXNBFY)) {
if(c=Ctrl('FGMOCXNBFY')) c.innerHTML=tmp_FGMOCXNBFY;
e_FGMOCXNBFY=tmp_FGMOCXNBFY;
}
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay(Ctrl('FGMOCXNBFY'),true);
HideUI();
}
HideUI.lblids["ADatOpe"]=['VGTGDVWOBC'];
HideUI.lblids["DaDatOpe"]=['LQTOQIQYKP'];
function QSGNEETWVH_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_tipoope(HtW(getRadioValue(Ctrl('QSGNEETWVH')),'C'),null,e);
}
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
return Set_DaDatOpe(HtW(Ctrl('HJLJFAMGNR').value,'D'),null,e) && dateisok;
}
function HJLJFAMGNR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('HJLJFAMGNR'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('HJLJFAMGNR').value=WtH(w_DaDatOpe,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('HJLJFAMGNR');
SetActiveField(Ctrl('HJLJFAMGNR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('HJLJFAMGNR'),e);
}
function HJLJFAMGNR_ZOOM_Click() {
LaunchCalendar(Ctrl('HJLJFAMGNR'));
}
function XWZHWTENET_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('XWZHWTENET'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('XWZHWTENET').value=ApplyPictureToDate(Ctrl('XWZHWTENET').value,TranslatePicture(datePattern),'XWZHWTENET');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('XWZHWTENET'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('XWZHWTENET');
}
}
}
SetActiveField(Ctrl('XWZHWTENET'),false);
e=(Ne(e,null)?e:window.event);
return Set_ADatOpe(HtW(Ctrl('XWZHWTENET').value,'D'),null,e) && dateisok;
}
function XWZHWTENET_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('XWZHWTENET'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('XWZHWTENET').value=WtH(w_ADatOpe,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('XWZHWTENET');
SetActiveField(Ctrl('XWZHWTENET'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('XWZHWTENET'),e);
}
function XWZHWTENET_ZOOM_Click() {
LaunchCalendar(Ctrl('XWZHWTENET'));
}
function href_MAYNQUHJSS() {
SetLocationHref(null,'arrt_storfraz'+'?m_cAction=start&m_cAtExit=close&m_cMode=hyperlink','elaborazione')
}
function href_NACPPABTRW() {
SetLocationHref(window.location,ToResource('jsp/start_page_logo_portlet.jsp'+'')+'')
}
function href_LCFKHGNSPV() {
_modifyandopen(ToResource(LRTrim(w_gUrlApp)+'/flussi/'+LRTrim(w_gAzienda)+'/campione.zip'+''+'')+'?m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null)
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
c=Ctrl('QSGNEETWVH');
if ( ! (Empty(c))) {
c[0].onclick=QSGNEETWVH_Valid;
c[1].onclick=QSGNEETWVH_Valid;
}
if(c=Ctrl('HJLJFAMGNR')) c.onblur=HJLJFAMGNR_Valid;
if(c=Ctrl('HJLJFAMGNR')) c.onfocus=HJLJFAMGNR_OnFocus;
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
if(c=Ctrl('HJLJFAMGNR')) c.onkeypress=CheckDateChar;
}
if(c=Ctrl('XWZHWTENET')) c.onblur=XWZHWTENET_Valid;
if(c=Ctrl('XWZHWTENET')) c.onfocus=XWZHWTENET_OnFocus;
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
if(c=Ctrl('XWZHWTENET')) c.onkeypress=CheckDateChar;
}
}
}
function NotifyEvent(p_cEvent) {
var old_c;
if (Ne(typeof(w_Messaggi),'undefined')) {
w_Messaggi.raiseEvent('arpg_storfraz_'+Strtran(p_cEvent,' ','_'));
}
if (Ne(typeof(w_Log),'undefined')) {
w_Log.raiseEvent('arpg_storfraz_'+Strtran(p_cEvent,' ','_'));
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
FocusFirstComponent.otherwise={"page_1":["QSGNEETWVH"]};
function Help() {
windowOpenForeground('../doc/arpg_storfraz_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_tipoope=a[0];
w_DaDatOpe=a[1];
w_ADatOpe=a[2];
w_gIntemediario=a[3];
w_gTipInter=a[4];
w_gUrlApp=a[5];
w_gAzienda=a[6];
w_gDatDel=a[7];
w_gDatTra=a[8];
o_tipoope=w_tipoope[1];
w_tipoope=w_tipoope[0];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_storfraz',m_cSelectedPage);
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
function Set_tipoope(ctrlValue,kmode,e) {
if (Ne(w_tipoope,ctrlValue)) {
var ctl = _GetCtl(e,'QSGNEETWVH');
if (_tracker.goon(ctl,ctrlValue)) {
w_tipoope=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QSGNEETWVH',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_DaDatOpe(ctrlValue,kmode,e) {
if (Ne(w_DaDatOpe,ctrlValue)) {
var ctl = _GetCtl(e,'HJLJFAMGNR');
if (_tracker.goon(ctl,ctrlValue)) {
w_DaDatOpe=ctrlValue;
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
function Set_ADatOpe(ctrlValue,kmode,e) {
if (Ne(w_ADatOpe,ctrlValue)) {
var ctl = _GetCtl(e,'XWZHWTENET');
if (_tracker.goon(ctl,ctrlValue)) {
w_ADatOpe=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XWZHWTENET',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH(NullDate(),'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
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
if ((Ne(o_tipoope,w_tipoope))) {
Calculation_FZZGQGHVJO();
}
// * --- Area Manuale = UI - Calculate
// * --- Fine Area Manuale
m_bCalculating=false;
}
function Calculation_FZZGQGHVJO() {
w_ADatOpe=(Eq(w_tipoope,'T')?w_gDatTra:w_gDatDel);
w_DaDatOpe=NullDate();
}
function SaveDependsOn() {
o_tipoope=w_tipoope;
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
if ( ! (_ChkObl('QSGNEETWVH',1))) {
_SignErr('QSGNEETWVH');
m_cLastWorkVarErrorMsg='tipoope';
l_bResult=false;
w_tipoope=HtW('','C');
} else if ( ! (_ChkObl('HJLJFAMGNR',1))) {
_SignErr('HJLJFAMGNR');
m_cLastWorkVarErrorMsg='DaDatOpe';
l_bResult=false;
w_DaDatOpe=HtW('','D');
} else if ( ! (_ChkObl('XWZHWTENET',1))) {
_SignErr('XWZHWTENET');
m_cLastWorkVarErrorMsg='ADatOpe';
l_bResult=false;
w_ADatOpe=HtW('','D');
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('HJLJFAMGNR_ZOOM',lc)) {
return 0;
}
if (Eq('XWZHWTENET_ZOOM',lc)) {
return 0;
}
return -1;
}
function link_url(index) {
var l_oWv;
}
function FillWv() {
var l_oWv = InitWvApplet();
l_oWv.setValue('tipoope',WtA(w_tipoope,'C'));
l_oWv.setValue('DaDatOpe',WtA(w_DaDatOpe,'D'));
l_oWv.setValue('ADatOpe',WtA(w_ADatOpe,'D'));
l_oWv.setValue('gIntemediario',WtA(w_gIntemediario,'C'));
l_oWv.setValue('gTipInter',WtA(w_gTipInter,'C'));
l_oWv.setValue('gUrlApp',WtA(w_gUrlApp,'C'));
l_oWv.setValue('gAzienda',WtA(w_gAzienda,'C'));
l_oWv.setValue('gDatDel',WtA(w_gDatDel,'D'));
l_oWv.setValue('gDatTra',WtA(w_gDatTra,'D'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["tipoope","DaDatOpe","ADatOpe","gIntemediario","gTipInter","gUrlApp","gAzienda","gDatDel","gDatTra"];
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
if (start && Eq(At(',tipoope,',pseq),0)) {
w_tipoope='T';
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
_Obli('tipoope',0,'QSGNEETWVH',false)
_Obli('DaDatOpe',2,'HJLJFAMGNR',false)
_Obli('ADatOpe',2,'XWZHWTENET',false)
