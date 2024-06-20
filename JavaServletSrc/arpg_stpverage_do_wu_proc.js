function SetControlsValue() {
var c;
var c;
if(c=Ctrl('DPKVLWHCIG')) c.value = WtH(w_DaDatOpe,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('MTJDZQTEIR')) c.value = WtH(w_ADatOpe,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('JYMIKLSHHF')) ChkboxCheckUncheck(c,'S',w_noninvio)
if(c=Ctrl('JYMIKLSHHF')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('VYVILVMHVV')) ChkboxCheckUncheck(c,'S',w_chkcfis)
if(c=Ctrl('VYVILVMHVV')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('XFVQTXPEXL')) c.value = WtH(w_codmage,'C',5,0,'')
var tmp_LXTFLROIJK = ToHTag(AsControlValue(w_xMADESCRI));
if (Ne(e_LXTFLROIJK,tmp_LXTFLROIJK)) {
if(c=Ctrl('LXTFLROIJK')) c.innerHTML=tmp_LXTFLROIJK;
e_LXTFLROIJK=tmp_LXTFLROIJK;
}
if(c=Ctrl('OMBFBOBBRT')) c.value = WtH(w_fisccod,'C',16,0,'@!')
if(c=Ctrl('NDAMLGOVAD')) selectCombo(c,w_statonas,'C')
if(c=Ctrl('CVSBJNRTYJ')) selectCombo(c,w_tipoerr,'C')
var tmp_FGMOCXNBFY = ToHTag(AsControlValue('<iframe width=\'655\' height=\'170\' id=\'elaborazione\'  name=\'elaborazione\' frameborder=\'1\'  border=\'1\' align=\'TOP\' marginwidth=\'1\' marginheight=\'1\'></iframe>'));
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
SetDisplay('XLVFHSOSYH_DIV',IsHiddenByStateDriver('FB'));
SetDisplay('CUDLEQEGMI_DIV',IsHiddenByStateDriver('FA'));
SetDisplay('OUWUVUCAPC_DIV',IsHiddenByStateDriver('Msg'));
SetDisplay(Ctrl('FGMOCXNBFY'),true);
HideUI();
}
HideUI.lblids["ADatOpe"]=['BGHAITOPMU'];
HideUI.lblids["DaDatOpe"]=['HPGJXQIVYG'];
HideUI.lblids["codmage"]=['EFKLJNCNTE'];
HideUI.lblids["fisccod"]=['QBKRLPIIYW'];
HideUI.lblids["statonas"]=['LYNFVXSMGJ'];
HideUI.lblids["tipoerr"]=['HCXYQMOIBV'];
function ExpandCollapseBoxesUnderCondition() {
var cond;
}
function DPKVLWHCIG_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('DPKVLWHCIG'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('DPKVLWHCIG').value=ApplyPictureToDate(Ctrl('DPKVLWHCIG').value,TranslatePicture(datePattern),'DPKVLWHCIG');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('DPKVLWHCIG'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('DPKVLWHCIG');
}
}
}
SetActiveField(Ctrl('DPKVLWHCIG'),false);
e=(Ne(e,null)?e:window.event);
return Set_DaDatOpe(HtW(Ctrl('DPKVLWHCIG').value,'D'),null,e) && dateisok;
}
function DPKVLWHCIG_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('DPKVLWHCIG'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('DPKVLWHCIG').value=WtH(w_DaDatOpe,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('DPKVLWHCIG');
SetActiveField(Ctrl('DPKVLWHCIG'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('DPKVLWHCIG'),e);
}
function MTJDZQTEIR_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('MTJDZQTEIR'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('MTJDZQTEIR').value=ApplyPictureToDate(Ctrl('MTJDZQTEIR').value,TranslatePicture(datePattern),'MTJDZQTEIR');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('MTJDZQTEIR'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('MTJDZQTEIR');
}
}
}
SetActiveField(Ctrl('MTJDZQTEIR'),false);
e=(Ne(e,null)?e:window.event);
return Set_ADatOpe(HtW(Ctrl('MTJDZQTEIR').value,'D'),null,e) && dateisok;
}
function MTJDZQTEIR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('MTJDZQTEIR'))) {
DisplayErrorMessage();
}
if (Ne(_tracker.ctrl,Ctrl('MTJDZQTEIR'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('MTJDZQTEIR').value=WtH(w_ADatOpe,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
}
m_oEnteredInDate=Ctrl('MTJDZQTEIR');
SetActiveField(Ctrl('MTJDZQTEIR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('MTJDZQTEIR'),e);
}
function href_XURLGQZZMU() {
var l_oWv = InitWvApplet();
l_oWv.setValue('pTipo',AsAppletValue('X'));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('pTipo'));
SetLocationHref(null,'arrt_stpverage_do_wu'+'?m_cWv='+URLenc(l_oWv.asString())+'&m_cAction=start&m_cMode=hyperlink','elaborazione')
}
function href_PTXYMSWBZO() {
SetLocationHref(window.location,ToResource('jsp/start_page_logo_portlet.jsp'+'')+'')
}
function JYMIKLSHHF_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_noninvio(ChkboxValueAssign(Ctrl('JYMIKLSHHF'),'S','N','C',1,0,''),null,e);
}
function JYMIKLSHHF_OnFocus(e) {
SetActiveField(Ctrl('JYMIKLSHHF'),true);
}
function JYMIKLSHHF_OnBlur(e) {
SetActiveField(Ctrl('JYMIKLSHHF'),false);
}
function VYVILVMHVV_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_chkcfis(ChkboxValueAssign(Ctrl('VYVILVMHVV'),'S','N','C',1,0,''),null,e);
}
function VYVILVMHVV_OnFocus(e) {
SetActiveField(Ctrl('VYVILVMHVV'),true);
}
function VYVILVMHVV_OnBlur(e) {
SetActiveField(Ctrl('VYVILVMHVV'),false);
}
function XFVQTXPEXL_Valid(e) {
SetActiveField(Ctrl('XFVQTXPEXL'),false);
e=(Ne(e,null)?e:window.event);
return Set_codmage(HtW(Ctrl('XFVQTXPEXL').value,'C'),null,e);
}
function XFVQTXPEXL_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('XFVQTXPEXL'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('XFVQTXPEXL'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('XFVQTXPEXL'),e);
}
function XFVQTXPEXL_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('XFVQTXPEXL')),'linkview_XFVQTXPEXL','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function OMBFBOBBRT_Valid(e) {
SetActiveField(Ctrl('OMBFBOBBRT'),false);
e=(Ne(e,null)?e:window.event);
return Set_fisccod(HtW(Ctrl('OMBFBOBBRT').value,'C'),null,e);
}
function OMBFBOBBRT_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('OMBFBOBBRT'))) {
DisplayErrorMessage();
}
Ctrl('OMBFBOBBRT').value=WtH(w_fisccod,'C',16,0,'@!');
SetActiveField(Ctrl('OMBFBOBBRT'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('OMBFBOBBRT'),e);
}
function OMBFBOBBRT_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("@!"));
}
function NDAMLGOVAD_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_statonas(HtW(getComboValue(Ctrl('NDAMLGOVAD')),'C'),null,e);
}
function NDAMLGOVAD_OnFocus(e) {
SetActiveField(Ctrl('NDAMLGOVAD'),true);
}
function NDAMLGOVAD_OnBlur(e) {
SetActiveField(Ctrl('NDAMLGOVAD'),false);
}
function CVSBJNRTYJ_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_tipoerr(HtW(getComboValue(Ctrl('CVSBJNRTYJ')),'C'),null,e);
}
function CVSBJNRTYJ_OnFocus(e) {
SetActiveField(Ctrl('CVSBJNRTYJ'),true);
}
function CVSBJNRTYJ_OnBlur(e) {
SetActiveField(Ctrl('CVSBJNRTYJ'),false);
}
function href_RXPIEFSABT() {
var l_oWv = InitWvApplet();
l_oWv.setValue('pTipo',AsAppletValue('U'));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('pTipo'));
SetLocationHref(null,'arrt_stpverage_do_wu'+'?m_cWv='+URLenc(l_oWv.asString())+'&m_cAction=start&m_cMode=hyperlink','elaborazione')
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
if(c=Ctrl('DPKVLWHCIG')) c.onblur=DPKVLWHCIG_Valid;
if(c=Ctrl('DPKVLWHCIG')) c.onfocus=DPKVLWHCIG_OnFocus;
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
if(c=Ctrl('DPKVLWHCIG')) c.onkeypress=CheckDateChar;
}
if(c=Ctrl('MTJDZQTEIR')) c.onblur=MTJDZQTEIR_Valid;
if(c=Ctrl('MTJDZQTEIR')) c.onfocus=MTJDZQTEIR_OnFocus;
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
if(c=Ctrl('MTJDZQTEIR')) c.onkeypress=CheckDateChar;
}
if(c=Ctrl('JYMIKLSHHF')) c.onclick=JYMIKLSHHF_Valid;
if(c=Ctrl('JYMIKLSHHF')) c.onfocus=JYMIKLSHHF_OnFocus;
if(c=Ctrl('JYMIKLSHHF')) c.onblur=JYMIKLSHHF_OnBlur;
if(c=Ctrl('VYVILVMHVV')) c.onclick=VYVILVMHVV_Valid;
if(c=Ctrl('VYVILVMHVV')) c.onfocus=VYVILVMHVV_OnFocus;
if(c=Ctrl('VYVILVMHVV')) c.onblur=VYVILVMHVV_OnBlur;
if(c=Ctrl('XFVQTXPEXL')) c.onblur=XFVQTXPEXL_Valid;
if(c=Ctrl('XFVQTXPEXL')) c.onfocus=XFVQTXPEXL_OnFocus;
if(c=Ctrl('OMBFBOBBRT')) c.onblur=OMBFBOBBRT_Valid;
if(c=Ctrl('OMBFBOBBRT')) c.onfocus=OMBFBOBBRT_OnFocus;
if(c=Ctrl('OMBFBOBBRT')) c.onkeypress=CheckUpper;
if(c=Ctrl('NDAMLGOVAD')) c.onchange=NDAMLGOVAD_Valid;
if(c=Ctrl('NDAMLGOVAD')) c.onfocus=NDAMLGOVAD_OnFocus;
if(c=Ctrl('NDAMLGOVAD')) c.onblur=NDAMLGOVAD_OnBlur;
if(c=Ctrl('CVSBJNRTYJ')) c.onchange=CVSBJNRTYJ_Valid;
if(c=Ctrl('CVSBJNRTYJ')) c.onfocus=CVSBJNRTYJ_OnFocus;
if(c=Ctrl('CVSBJNRTYJ')) c.onblur=CVSBJNRTYJ_OnBlur;
}
}
function NotifyEvent(p_cEvent) {
var old_c;
if (Ne(typeof(w_Messaggi),'undefined')) {
w_Messaggi.raiseEvent('arpg_stpverage_do_wu_'+Strtran(p_cEvent,' ','_'));
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
FocusFirstComponent.otherwise={"page_1":["DPKVLWHCIG"]};
function Help() {
windowOpenForeground('../doc/arpg_stpverage_do_wu_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
}
function CalledBatchEnd() {
if ( ! (m_bCalculating)) {
DoUpdate(true);
}
}
function LoadChildrenInPage(page,lazy) {
}
GetLayerID.Layers.push({"id":"XLVFHSOSYH","name":"FB"});
GetLayerID.Layers.push({"id":"CUDLEQEGMI","name":"FA"});
GetLayerID.Layers.push({"id":"OUWUVUCAPC","name":"Msg"});
function DeclareWVs() {
var a = arguments;
w_DaDatOpe=a[0];
w_ADatOpe=a[1];
w_cdadata=a[2];
w_c_adata=a[3];
w_noninvio=a[4];
w_chkcfis=a[5];
w_codmage=a[6];
w_xMADESCRI=a[7];
w_fisccod=a[8];
w_statonas=a[9];
w_tipoerr=a[10];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_stpverage_do_wu',m_cSelectedPage);
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
if (IsDisabledByStateDriver('FB')) {
DisableInputsInContainer(Ctrl('XLVFHSOSYH'),true);
}
if (IsDisabledByStateDriver('FA')) {
DisableInputsInContainer(Ctrl('CUDLEQEGMI'),true);
}
if (IsDisabledByStateDriver('Msg')) {
DisableInputsInContainer(Ctrl('OUWUVUCAPC'),true);
}
DisableUI();
HideControlsUnderCondition();
ObligatoryControlsUnderCondition();
ExpandCollapseBoxesUnderCondition();
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
function Set_DaDatOpe(ctrlValue,kmode,e) {
if (Ne(w_DaDatOpe,ctrlValue)) {
var ctl = _GetCtl(e,'DPKVLWHCIG');
if (_tracker.goon(ctl,ctrlValue)) {
w_DaDatOpe=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('DPKVLWHCIG',0);
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
var ctl = _GetCtl(e,'MTJDZQTEIR');
if (_tracker.goon(ctl,ctrlValue)) {
w_ADatOpe=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MTJDZQTEIR',0);
if (l_bResult) {
l_bResult=Ge(w_ADatOpe,w_DaDatOpe);
if ( ! (l_bResult)) {
m_nLastError=2;
m_cLastWorkVarErrorMsg='ADatOpe';
m_cLastMsgError=AlertErrorMessage('10557974447');
}
if ( ! (l_bResult)) {
w_ADatOpe=HtW('','D');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D')));
} else {
_ResetTracker();
}
return l_bResult;
} else {
ctl.value=WtH(NullDate(),'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
_ResetTracker();
return true;
}
}
return true;
}
function Set_chkcfis(ctrlValue,kmode,e) {
if (Ne(w_chkcfis,ctrlValue)) {
var ctl = _GetCtl(e,'VYVILVMHVV');
if (_tracker.goon(ctl,ctrlValue)) {
w_chkcfis=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VYVILVMHVV',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_codmage(ctrlValue,kmode,e) {
if (Ne(w_codmage,ctrlValue)) {
var ctl = _GetCtl(e,'XFVQTXPEXL');
if (_tracker.goon(ctl,ctrlValue)) {
w_codmage=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XFVQTXPEXL',0);
if (l_bResult) {
l_bResult=Link_XFVQTXPEXL(kmode);
if ( ! (l_bResult)) {
w_codmage=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',5,0,''));
} else {
_ResetTracker();
}
return l_bResult;
} else {
ctl.value=WtH('','C',5,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_noninvio(ctrlValue,kmode,e) {
if (Ne(w_noninvio,ctrlValue)) {
var ctl = _GetCtl(e,'JYMIKLSHHF');
if (_tracker.goon(ctl,ctrlValue)) {
w_noninvio=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('JYMIKLSHHF',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_tipoerr(ctrlValue,kmode,e) {
if (Ne(w_tipoerr,ctrlValue)) {
var ctl = _GetCtl(e,'CVSBJNRTYJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_tipoerr=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CVSBJNRTYJ',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_statonas(ctrlValue,kmode,e) {
if (Ne(w_statonas,ctrlValue)) {
var ctl = _GetCtl(e,'NDAMLGOVAD');
if (_tracker.goon(ctl,ctrlValue)) {
w_statonas=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NDAMLGOVAD',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',40,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_fisccod(ctrlValue,kmode,e) {
if (Ne(w_fisccod,ctrlValue)) {
var ctl = _GetCtl(e,'OMBFBOBBRT');
if (_tracker.goon(ctl,ctrlValue)) {
w_fisccod=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('OMBFBOBBRT',0);
DoUpdate(l_bResult);
if(c=Ctrl('OMBFBOBBRT')) c.value = WtH(w_fisccod,'C',16,0,'@!')
} else {
ctl.value=WtH('','C',16,0,'@!');
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
w_cdadata=DateToChar(w_DaDatOpe);
w_c_adata=DateToChar(w_ADatOpe);
// * --- Area Manuale = UI - Calculate
// * --- Fine Area Manuale
m_bCalculating=false;
}
function SaveDependsOn() {
}
function SaveLabelDependsOn() {
}
function Link_XFVQTXPEXL(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_codmage);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('MACODICE',w_codmage,5,0);
l_Appl.SetFields('MACODICE,MADESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('tbmacage');
l_Appl.SetID('XFVQTXPEXL');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_codmage=l_Appl.GetStringValue('MACODICE',5,0);
w_xMADESCRI=l_Appl.GetStringValue('MADESCRI',60,0);
} else {
Link_XFVQTXPEXL_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_XFVQTXPEXL';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_XFVQTXPEXL();
l_oWv.setValue('FieldFilter',l_cFieldFilter);
if ( ! (Empty(l_Appl.GetWhereAddedFixedFiltersUnencoded()))) {
if ( ! (Empty(l_cFixedFilter))) {
l_cFixedFilter=l_cFixedFilter+' and ';
}
l_cFixedFilter=l_cFixedFilter+l_Appl.GetWhereAddedFixedFiltersUnencoded();
}
l_oWv.setValue('FixedFilter',l_cFixedFilter);
var initEntityFields = '';
l_cLinkUrl='../servlet/SPVisualZoom'+'?m_cWv='+URLenc(l_oWv.asString());
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
function Link_XFVQTXPEXL_Blank() {
w_codmage='';
w_xMADESCRI='';
}
function LOpt_XFVQTXPEXL() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbmacage','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('MACODICE','C'));
l_oWv.setValue('LinkedField',WtA('MACODICE','C'));
l_oWv.setValue('UID',WtA('XFVQTXPEXL','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['XFVQTXPEXL'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('1546293487'),'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'XFVQTXPEXL')) {
last_focused_comp=GetLastFocusedElementOfLink('XFVQTXPEXL');
function SetMethod_XFVQTXPEXL() {
Set_codmage(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_XFVQTXPEXL();
} else {
setTimeout(SetMethod_XFVQTXPEXL,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'XFVQTXPEXL')) {
return [Ctrl('XFVQTXPEXL')];
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
if ( ! (_ChkObl('DPKVLWHCIG',1))) {
_SignErr('DPKVLWHCIG');
m_cLastWorkVarErrorMsg='DaDatOpe';
l_bResult=false;
w_DaDatOpe=HtW('','D');
} else if (( ! (_ChkObl('MTJDZQTEIR',1))) || ( ! (Ge(w_ADatOpe,w_DaDatOpe)))) {
_SignErr('MTJDZQTEIR','10557974447');
l_bResult=false;
w_ADatOpe=HtW('','D');
} else if ( ! (_ChkObl('JYMIKLSHHF',1))) {
_SignErr('JYMIKLSHHF');
m_cLastWorkVarErrorMsg='noninvio';
l_bResult=false;
w_noninvio='N';
} else if ( ! (_ChkObl('VYVILVMHVV',1))) {
_SignErr('VYVILVMHVV');
m_cLastWorkVarErrorMsg='chkcfis';
l_bResult=false;
w_chkcfis='N';
} else if ( ! (_ChkObl('XFVQTXPEXL',1))) {
_SignErr('XFVQTXPEXL');
m_cLastWorkVarErrorMsg='11148783093';
l_bResult=false;
w_codmage=HtW('','C');
} else if ( ! (_ChkObl('OMBFBOBBRT',1))) {
_SignErr('OMBFBOBBRT');
m_cLastWorkVarErrorMsg='fisccod';
l_bResult=false;
w_fisccod=HtW('','C');
} else if ( ! (_ChkObl('NDAMLGOVAD',1))) {
_SignErr('NDAMLGOVAD');
m_cLastWorkVarErrorMsg='12123943072';
l_bResult=false;
w_statonas=HtW('','C');
} else if ( ! (_ChkObl('CVSBJNRTYJ',1))) {
_SignErr('CVSBJNRTYJ');
m_cLastWorkVarErrorMsg='11770531981';
l_bResult=false;
w_tipoerr=HtW('','C');
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('XFVQTXPEXL_ZOOM',lc)) {
return 0;
}
if (Eq('XFVQTXPEXL',lc)) {
return 0;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_XFVQTXPEXL();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
}
function FillWv() {
var l_oWv = InitWvApplet();
l_oWv.setValue('DaDatOpe',WtA(w_DaDatOpe,'D'));
l_oWv.setValue('ADatOpe',WtA(w_ADatOpe,'D'));
l_oWv.setValue('cdadata',WtA(w_cdadata,'C'));
l_oWv.setValue('c_adata',WtA(w_c_adata,'C'));
l_oWv.setValue('noninvio',WtA(w_noninvio,'C'));
l_oWv.setValue('chkcfis',WtA(w_chkcfis,'C'));
l_oWv.setValue('codmage',WtA(w_codmage,'C'));
l_oWv.setValue('xMADESCRI',WtA(w_xMADESCRI,'C'));
l_oWv.setValue('fisccod',WtA(w_fisccod,'C'));
l_oWv.setValue('statonas',WtA(w_statonas,'C'));
l_oWv.setValue('tipoerr',WtA(w_tipoerr,'C'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["DaDatOpe","ADatOpe","cdadata","c_adata","noninvio","chkcfis","codmage","xMADESCRI","fisccod","statonas","tipoerr"];
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
if (Empty(w_DaDatOpe) && Ne(opener.w_DaDatOpe,null)) {
TransferBetweenWindows(opener,'w_DaDatOpe',null,'Set_DaDatOpe');
}
if (Empty(w_ADatOpe) && Ne(opener.w_ADatOpe,null)) {
TransferBetweenWindows(opener,'w_ADatOpe',null,'Set_ADatOpe');
}
if (Empty(w_cdadata) && Ne(opener.w_cdadata,null)) {
TransferBetweenWindows(opener,'w_cdadata','w_cdadata');
}
if (Empty(w_c_adata) && Ne(opener.w_c_adata,null)) {
TransferBetweenWindows(opener,'w_c_adata','w_c_adata');
}
if (Eq(w_noninvio,'N') && Ne(opener.w_noninvio,null)) {
TransferBetweenWindows(opener,'w_noninvio',null,'Set_noninvio');
}
if (Eq(w_chkcfis,'N') && Ne(opener.w_chkcfis,null)) {
TransferBetweenWindows(opener,'w_chkcfis',null,'Set_chkcfis');
}
}
}
m_bCalculating=true;
w_cdadata=DateToChar(w_DaDatOpe);
w_c_adata=DateToChar(w_ADatOpe);
if (start && Eq(At(',noninvio,',pseq),0)) {
w_noninvio='N';
}
if (start && Eq(At(',chkcfis,',pseq),0)) {
w_chkcfis='N';
}
Link_XFVQTXPEXL(null);
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
_Obli('DaDatOpe',2,'DPKVLWHCIG',false)
_Obli('ADatOpe',2,'MTJDZQTEIR',false)
_Obli('chkcfis',0,'VYVILVMHVV',false)
_Obli('codmage',0,'XFVQTXPEXL',false,"11148783093")
_Obli('noninvio',0,'JYMIKLSHHF',false)
_Obli('tipoerr',0,'CVSBJNRTYJ',false,"11770531981")
_Obli('statonas',0,'NDAMLGOVAD',false,"12123943072")
_Obli('fisccod',0,'OMBFBOBBRT',false)
