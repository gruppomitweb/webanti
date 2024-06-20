function SetControlsValue() {
var c;
var c;
var tmp_FGMOCXNBFY = ToHTag(AsControlValue('<iframe width=\'655\' height=\'170\' id=\'elaborazione\'  name=\'elaborazione\' frameborder=\'1\'  border=\'1\' align=\'TOP\' marginwidth=\'1\' marginheight=\'1\'></iframe>'));
if (Ne(e_FGMOCXNBFY,tmp_FGMOCXNBFY)) {
if(c=Ctrl('FGMOCXNBFY')) c.innerHTML=tmp_FGMOCXNBFY;
e_FGMOCXNBFY=tmp_FGMOCXNBFY;
}
if(c=Ctrl('NPEVPSEORB')) c.value = WtH(w_datchi,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('ORBCRNKYOX')) c.value = WtH(w_datreg,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('CQYEDCNLUY')) selectRadio(c,w_tipoarch,'C')
if(c=Ctrl('DAJIERLNKW')) c.value = WtH(w_nomfile,'C',15,0,'')
if(c=Ctrl('CROSGIVRMX')) selectRadio(c,w_tipofile,'C')
if(c=Ctrl('VZOSCSSTIW')) selectCombo(c,w_causale,'C')
if(c=Ctrl('LEKFEUBYWF')) selectCombo(c,w_macage,'C')
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay(Ctrl('FGMOCXNBFY'),true);
SetDisplay(Ctrl('RCWAHCKHYD'),true);
SetDisplay(Ctrl('XIPHHKEWZQ'),true);
SetDisplay(Ctrl('SJACSRAHBH'),true);
HideUI();
}
HideUI.lblids["causale"]=['YFTBGFBVSH'];
HideUI.lblids["datchi"]=['QDZKSWCHXH'];
HideUI.lblids["datreg"]=['FUJZBGLYPK'];
HideUI.lblids["macage"]=['XGOXUVHQVM'];
HideUI.lblids["nomfile"]=['HCQMBFMOQG'];
function LBFGPHXQLX_Click() {
StartRap()
}
function NPEVPSEORB_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('NPEVPSEORB'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('NPEVPSEORB').value=ApplyPictureToDate(Ctrl('NPEVPSEORB').value,TranslatePicture(datePattern),'NPEVPSEORB');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('NPEVPSEORB'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('NPEVPSEORB');
}
}
}
SetActiveField(Ctrl('NPEVPSEORB'),false);
e=(Ne(e,null)?e:window.event);
return Set_datchi(HtW(Ctrl('NPEVPSEORB').value,'D'),null,e) && dateisok;
}
function NPEVPSEORB_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('NPEVPSEORB'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('NPEVPSEORB').value=WtH(w_datchi,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('NPEVPSEORB');
SetActiveField(Ctrl('NPEVPSEORB'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('NPEVPSEORB'),e);
}
function NPEVPSEORB_ZOOM_Click() {
LaunchCalendar(Ctrl('NPEVPSEORB'));
}
function ORBCRNKYOX_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('ORBCRNKYOX'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('ORBCRNKYOX').value=ApplyPictureToDate(Ctrl('ORBCRNKYOX').value,TranslatePicture(datePattern),'ORBCRNKYOX');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('ORBCRNKYOX'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('ORBCRNKYOX');
}
}
}
SetActiveField(Ctrl('ORBCRNKYOX'),false);
e=(Ne(e,null)?e:window.event);
return Set_datreg(HtW(Ctrl('ORBCRNKYOX').value,'D'),null,e) && dateisok;
}
function ORBCRNKYOX_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ORBCRNKYOX'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('ORBCRNKYOX').value=WtH(w_datreg,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('ORBCRNKYOX');
SetActiveField(Ctrl('ORBCRNKYOX'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ORBCRNKYOX'),e);
}
function ORBCRNKYOX_ZOOM_Click() {
LaunchCalendar(Ctrl('ORBCRNKYOX'));
}
function DPCMWWOCYM_Click() {
SetLocationHref(null,'arrt_moverap'+'?m_cAction=start&m_cMode=hyperlink','elaborazione')
}
function CQYEDCNLUY_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_tipoarch(HtW(getRadioValue(Ctrl('CQYEDCNLUY')),'C'),null,e);
}
function XIFZDMHWTB_Click() {
SetLocationHref(null,'arrt_sistema1'+'?m_cAction=start&m_cMode=hyperlink','elaborazione')
}
function XDDFQNPBDM_Click() {
SetLocationHref(null,'arrt_sisteman'+'?m_cAction=start&m_cMode=hyperlink','elaborazione')
}
function YZJFKQCFPE_Click() {
SetLocationHref(null,'arrt_sistemat'+'?m_cAction=start&m_cMode=hyperlink','elaborazione')
}
function DAJIERLNKW_Valid(e) {
SetActiveField(Ctrl('DAJIERLNKW'),false);
e=(Ne(e,null)?e:window.event);
return Set_nomfile(HtW(Ctrl('DAJIERLNKW').value,'C'),null,e);
}
function DAJIERLNKW_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('DAJIERLNKW'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('DAJIERLNKW'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('DAJIERLNKW'),e);
}
function CRLHHPAQKM_Click() {
SetLocationHref(null,'arrt_sisteman'+'?m_cAction=start&m_cMode=hyperlink','elaborazione')
}
function CROSGIVRMX_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_tipofile(HtW(getRadioValue(Ctrl('CROSGIVRMX')),'C'),null,e);
}
function BHNVCHPHZB_Click() {
StartDel()
}
function DBJGLKQEUV_Click() {
StartTit()
}
function VZOSCSSTIW_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_causale(HtW(getComboValue(Ctrl('VZOSCSSTIW')),'C'),null,e);
}
function VZOSCSSTIW_OnFocus(e) {
SetActiveField(Ctrl('VZOSCSSTIW'),true);
}
function VZOSCSSTIW_OnBlur(e) {
SetActiveField(Ctrl('VZOSCSSTIW'),false);
}
function LEKFEUBYWF_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_macage(HtW(getComboValue(Ctrl('LEKFEUBYWF')),'C'),null,e);
}
function LEKFEUBYWF_OnFocus(e) {
SetActiveField(Ctrl('LEKFEUBYWF'),true);
}
function LEKFEUBYWF_OnBlur(e) {
SetActiveField(Ctrl('LEKFEUBYWF'),false);
}
function RCWAHCKHYD_Click() {
var l_oWv = InitWvApplet();
l_oWv.setValue('pTipo',AsAppletValue('R'));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('pTipo'));
SetLocationHref(null,'arrt_chiusura'+'?m_cWv='+URLenc(l_oWv.asString())+'&m_cAction=start&m_cMode=hyperlink','elaborazione')
}
function XIPHHKEWZQ_Click() {
var l_oWv = InitWvApplet();
l_oWv.setValue('pTipo',AsAppletValue('D'));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('pTipo'));
SetLocationHref(null,'arrt_chiusura'+'?m_cWv='+URLenc(l_oWv.asString())+'&m_cAction=start&m_cMode=hyperlink','elaborazione')
}
function SJACSRAHBH_Click() {
var l_oWv = InitWvApplet();
l_oWv.setValue('pTipo',AsAppletValue('T'));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('pTipo'));
SetLocationHref(null,'arrt_chiusura'+'?m_cWv='+URLenc(l_oWv.asString())+'&m_cAction=start&m_cMode=hyperlink','elaborazione')
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
if(c=Ctrl('NPEVPSEORB')) c.onblur=NPEVPSEORB_Valid;
if(c=Ctrl('NPEVPSEORB')) c.onfocus=NPEVPSEORB_OnFocus;
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
if(c=Ctrl('NPEVPSEORB')) c.onkeypress=CheckDateChar;
}
if(c=Ctrl('ORBCRNKYOX')) c.onblur=ORBCRNKYOX_Valid;
if(c=Ctrl('ORBCRNKYOX')) c.onfocus=ORBCRNKYOX_OnFocus;
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
if(c=Ctrl('ORBCRNKYOX')) c.onkeypress=CheckDateChar;
}
c=Ctrl('CQYEDCNLUY');
if ( ! (Empty(c))) {
c[0].onclick=CQYEDCNLUY_Valid;
c[1].onclick=CQYEDCNLUY_Valid;
}
if(c=Ctrl('DAJIERLNKW')) c.onblur=DAJIERLNKW_Valid;
if(c=Ctrl('DAJIERLNKW')) c.onfocus=DAJIERLNKW_OnFocus;
c=Ctrl('CROSGIVRMX');
if ( ! (Empty(c))) {
c[0].onclick=CROSGIVRMX_Valid;
c[1].onclick=CROSGIVRMX_Valid;
}
if(c=Ctrl('VZOSCSSTIW')) c.onchange=VZOSCSSTIW_Valid;
if(c=Ctrl('VZOSCSSTIW')) c.onfocus=VZOSCSSTIW_OnFocus;
if(c=Ctrl('VZOSCSSTIW')) c.onblur=VZOSCSSTIW_OnBlur;
if(c=Ctrl('LEKFEUBYWF')) c.onchange=LEKFEUBYWF_Valid;
if(c=Ctrl('LEKFEUBYWF')) c.onfocus=LEKFEUBYWF_OnFocus;
if(c=Ctrl('LEKFEUBYWF')) c.onblur=LEKFEUBYWF_OnBlur;
}
}
function NotifyEvent(p_cEvent) {
var old_c;
if (Ne(typeof(w_pMsg),'undefined')) {
w_pMsg.raiseEvent('arpg_chiusura_'+Strtran(p_cEvent,' ','_'));
}
if (Ne(typeof(w_pLog),'undefined')) {
w_pLog.raiseEvent('arpg_chiusura_'+Strtran(p_cEvent,' ','_'));
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
FocusFirstComponent.otherwise={"page_1":["LBFGPHXQLX"]};
function Help() {
windowOpenForeground('../doc/arpg_chiusura_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_datchi=a[0];
w_datreg=a[1];
w_tipoarch=a[2];
w_nomfile=a[3];
w_tipofile=a[4];
w_causale=a[5];
w_macage=a[6];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_chiusura',m_cSelectedPage);
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
function Set_datchi(ctrlValue,kmode,e) {
if (Ne(w_datchi,ctrlValue)) {
var ctl = _GetCtl(e,'NPEVPSEORB');
if (_tracker.goon(ctl,ctrlValue)) {
w_datchi=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NPEVPSEORB',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH(NullDate(),'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
_ResetTracker();
return true;
}
}
return true;
}
function Set_datreg(ctrlValue,kmode,e) {
if (Ne(w_datreg,ctrlValue)) {
var ctl = _GetCtl(e,'ORBCRNKYOX');
if (_tracker.goon(ctl,ctrlValue)) {
w_datreg=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ORBCRNKYOX',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH(NullDate(),'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
_ResetTracker();
return true;
}
}
return true;
}
function Set_tipoarch(ctrlValue,kmode,e) {
if (Ne(w_tipoarch,ctrlValue)) {
var ctl = _GetCtl(e,'CQYEDCNLUY');
if (_tracker.goon(ctl,ctrlValue)) {
w_tipoarch=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CQYEDCNLUY',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_nomfile(ctrlValue,kmode,e) {
if (Ne(w_nomfile,ctrlValue)) {
var ctl = _GetCtl(e,'DAJIERLNKW');
if (_tracker.goon(ctl,ctrlValue)) {
w_nomfile=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('DAJIERLNKW',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',15,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_tipofile(ctrlValue,kmode,e) {
if (Ne(w_tipofile,ctrlValue)) {
var ctl = _GetCtl(e,'CROSGIVRMX');
if (_tracker.goon(ctl,ctrlValue)) {
w_tipofile=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CROSGIVRMX',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_causale(ctrlValue,kmode,e) {
if (Ne(w_causale,ctrlValue)) {
var ctl = _GetCtl(e,'VZOSCSSTIW');
if (_tracker.goon(ctl,ctrlValue)) {
w_causale=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VZOSCSSTIW',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',2,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_macage(ctrlValue,kmode,e) {
if (Ne(w_macage,ctrlValue)) {
var ctl = _GetCtl(e,'LEKFEUBYWF');
if (_tracker.goon(ctl,ctrlValue)) {
w_macage=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('LEKFEUBYWF',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',5,0,'');
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
if ( ! (_ChkObl('NPEVPSEORB',1))) {
_SignErr('NPEVPSEORB');
m_cLastWorkVarErrorMsg='datchi';
l_bResult=false;
w_datchi=HtW('','D');
} else if ( ! (_ChkObl('ORBCRNKYOX',1))) {
_SignErr('ORBCRNKYOX');
m_cLastWorkVarErrorMsg='datreg';
l_bResult=false;
w_datreg=HtW('','D');
} else if ( ! (_ChkObl('CQYEDCNLUY',1))) {
_SignErr('CQYEDCNLUY');
m_cLastWorkVarErrorMsg='tipoarch';
l_bResult=false;
w_tipoarch=HtW('','C');
} else if ( ! (_ChkObl('DAJIERLNKW',1))) {
_SignErr('DAJIERLNKW');
m_cLastWorkVarErrorMsg='797361315';
l_bResult=false;
w_nomfile=HtW('','C');
} else if ( ! (_ChkObl('CROSGIVRMX',1))) {
_SignErr('CROSGIVRMX');
m_cLastWorkVarErrorMsg='tipofile';
l_bResult=false;
w_tipofile=HtW('','C');
} else if ( ! (_ChkObl('VZOSCSSTIW',1))) {
_SignErr('VZOSCSSTIW');
m_cLastWorkVarErrorMsg='1814604627';
l_bResult=false;
w_causale=HtW('','C');
} else if ( ! (_ChkObl('LEKFEUBYWF',1))) {
_SignErr('LEKFEUBYWF');
m_cLastWorkVarErrorMsg='11148783093';
l_bResult=false;
w_macage=HtW('','C');
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('NPEVPSEORB_ZOOM',lc)) {
return 0;
}
if (Eq('ORBCRNKYOX_ZOOM',lc)) {
return 0;
}
return -1;
}
function link_url(index) {
var l_oWv;
}
function FillWv() {
var l_oWv = InitWvApplet();
l_oWv.setValue('datchi',WtA(w_datchi,'D'));
l_oWv.setValue('datreg',WtA(w_datreg,'D'));
l_oWv.setValue('tipoarch',WtA(w_tipoarch,'C'));
l_oWv.setValue('nomfile',WtA(w_nomfile,'C'));
l_oWv.setValue('tipofile',WtA(w_tipofile,'C'));
l_oWv.setValue('causale',WtA(w_causale,'C'));
l_oWv.setValue('macage',WtA(w_macage,'C'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["datchi","datreg","tipoarch","nomfile","tipofile","causale","macage"];
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
if (start && Eq(At(',tipoarch,',pseq),0)) {
w_tipoarch='A';
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
_Obli('datchi',2,'NPEVPSEORB',false)
_Obli('datreg',2,'ORBCRNKYOX',false)
_Obli('tipoarch',0,'CQYEDCNLUY',false)
_Obli('nomfile',0,'DAJIERLNKW',false,"797361315")
_Obli('tipofile',0,'CROSGIVRMX',false)
_Obli('causale',0,'VZOSCSSTIW',false,"1814604627")
_Obli('macage',0,'LEKFEUBYWF',false,"11148783093")
