function SetControlsValue() {
var c;
var c;
if(c=Ctrl('DPKVLWHCIG')) c.value = WtH(w_DaDatOpe,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('MTJDZQTEIR')) c.value = WtH(w_ADatOpe,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('QHXVBCMDEB')) selectCombo(c,w_tipocr,'C')
if(c=Ctrl('KAGRBEILOC')) c.value = WtH(w_codcr,'C',11,0,'')
if(c=Ctrl('FAWXPLZBPU')) c.value = WtH(w_datinv,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('OVFXSLBYQY')) c.value = WtH(w_numinv,'N',10,0,'')
var tmp_TYIWXFLLFY = ToHTag(AsControlValue('<iframe width=\'750\' height=\'400\' id=\'elaborazione\'  name=\'elaborazione\' frameborder=\'1\'  border=\'1\' align=\'TOP\' marginwidth=\'1\' marginheight=\'1\'></iframe>'));
if (Ne(e_TYIWXFLLFY,tmp_TYIWXFLLFY)) {
if(c=Ctrl('TYIWXFLLFY')) c.innerHTML=tmp_TYIWXFLLFY;
e_TYIWXFLLFY=tmp_TYIWXFLLFY;
}
if(c=Ctrl('PEJKGIUJDF')) ChkboxCheckUncheck(c,'S',w_flgfrazionate)
if(c=Ctrl('PEJKGIUJDF')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay('PBGEOWBBUF_DIV',IsHiddenByStateDriver('DateOperazione'));
SetDisplay('MJZOLGWVXE_DIV',IsHiddenByStateDriver('DatiIntermediario'));
SetDisplay(Ctrl('SNWBSRFWZT'),Empty(w_DaDatOpe) || Empty(w_ADatOpe));
SetDisplay(Ctrl('RFQOXRTNQW'),Empty(w_DaDatOpe) || Empty(w_ADatOpe));
SetDisplay(Ctrl('TFFWCBBCLE'),Empty(w_DaDatOpe) || Empty(w_ADatOpe));
SetDisplay(Ctrl('EZFKZSHHTQ'),Empty(w_DaDatOpe) || Empty(w_ADatOpe));
SetDisplay('QEFBIKGKTK_DIV',IsHiddenByStateDriver('DatiInvio'));
SetDisplay('PEJKGIUJDF_DIV', ! (LibreriaMit.inter_art1(w_gTipInter)));
HideUI();
}
HideUI.lblids["ADatOpe"]=['BGHAITOPMU'];
HideUI.lblids["DaDatOpe"]=['HPGJXQIVYG'];
HideUI.lblids["codcr"]=['BBAELHURCV'];
HideUI.lblids["datinv"]=['LQWWHOWUQM'];
HideUI.lblids["numinv"]=['VTGQLQMLBU'];
HideUI.lblids["tipocr"]=['INZZSZTBRT'];
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
if (Ne(_tracker.ctrl,Ctrl('DPKVLWHCIG'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('DPKVLWHCIG').value=WtH(w_DaDatOpe,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
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
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('MTJDZQTEIR').value=WtH(w_ADatOpe,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('MTJDZQTEIR');
SetActiveField(Ctrl('MTJDZQTEIR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('MTJDZQTEIR'),e);
}
function QHXVBCMDEB_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_tipocr(HtW(getComboValue(Ctrl('QHXVBCMDEB')),'C'),null,e);
}
function QHXVBCMDEB_OnFocus(e) {
SetActiveField(Ctrl('QHXVBCMDEB'),true);
}
function QHXVBCMDEB_OnBlur(e) {
SetActiveField(Ctrl('QHXVBCMDEB'),false);
}
function KAGRBEILOC_Valid(e) {
SetActiveField(Ctrl('KAGRBEILOC'),false);
e=(Ne(e,null)?e:window.event);
return Set_codcr(HtW(Ctrl('KAGRBEILOC').value,'C'),null,e);
}
function KAGRBEILOC_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('KAGRBEILOC'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('KAGRBEILOC'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('KAGRBEILOC'),e);
}
function FAWXPLZBPU_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('FAWXPLZBPU'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('FAWXPLZBPU').value=ApplyPictureToDate(Ctrl('FAWXPLZBPU').value,TranslatePicture(datePattern),'FAWXPLZBPU');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('FAWXPLZBPU'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('FAWXPLZBPU');
}
}
}
SetActiveField(Ctrl('FAWXPLZBPU'),false);
e=(Ne(e,null)?e:window.event);
return Set_datinv(HtW(Ctrl('FAWXPLZBPU').value,'D'),null,e) && dateisok;
}
function FAWXPLZBPU_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('FAWXPLZBPU'))) {
DisplayErrorMessage();
}
if (Ne(_tracker.ctrl,Ctrl('FAWXPLZBPU'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('FAWXPLZBPU').value=WtH(w_datinv,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
}
m_oEnteredInDate=Ctrl('FAWXPLZBPU');
SetActiveField(Ctrl('FAWXPLZBPU'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('FAWXPLZBPU'),e);
}
function OVFXSLBYQY_Valid(e) {
SetActiveField(Ctrl('OVFXSLBYQY'),false);
e=(Ne(e,null)?e:window.event);
return Set_numinv(HtW(Ctrl('OVFXSLBYQY').value,'N'),null,e);
}
function OVFXSLBYQY_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('OVFXSLBYQY'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('OVFXSLBYQY'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('OVFXSLBYQY'),e);
}
function href_ZQEKBHAOQV() {
SetLocationHref(window.location,ToResource('jsp/start_page_logo_portlet.jsp'+'')+'')
}
function href_SNWBSRFWZT() {
var l_oWv = InitWvApplet();
l_oWv.setValue('pTipo',AsAppletValue('D'));
l_oWv.setValue('w_DaDatOpe',AsAppletValue(w_DaDatOpe));
l_oWv.setValue('w_ADatOpe',AsAppletValue(w_ADatOpe));
l_oWv.setValue('w_tipocr',AsAppletValue(w_tipocr));
l_oWv.setValue('w_codcr',AsAppletValue(w_codcr));
l_oWv.setValue('w_flgfrazionate',AsAppletValue(w_flgfrazionate));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('pTipo,w_DaDatOpe,w_ADatOpe,w_tipocr,w_codcr,w_flgfrazionate'));
SetLocationHref(null,'arrt_discouic_ver'+'?m_cWv='+URLenc(l_oWv.asString())+'&m_cAction=start&m_cMode=hyperlink','elaborazione')
}
function href_CZXYDCLLYZ() {
var l_oWv = InitWvApplet();
l_oWv.setValue('w_DaDatOpe',AsAppletValue(w_DaDatOpe));
l_oWv.setValue('w_ADatOpe',AsAppletValue(w_ADatOpe));
l_oWv.setValue('w_tipocr',AsAppletValue(w_tipocr));
l_oWv.setValue('w_codcr',AsAppletValue(w_codcr));
l_oWv.setValue('w_datinv',AsAppletValue(w_datinv));
l_oWv.setValue('w_numinv',AsAppletValue(w_numinv));
l_oWv.setValue('w_flgfrazionate',AsAppletValue(w_flgfrazionate));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('w_DaDatOpe,w_ADatOpe,w_tipocr,w_codcr,w_datinv,w_numinv,w_flgfrazionate'));
if ( ! (Empty(w_DaDatOpe)) &&  ! (Empty(w_ADatOpe)) &&  ! (Empty(w_datinv)) &&  ! (Empty(w_numinv))) {
SetLocationHref(null,'arrt_discouic_xbrl'+'?m_cWv='+URLenc(l_oWv.asString())+'&m_cAction=start&m_cAtExit=close&m_cMode=hyperlink','elaborazione')
}
}
function href_LCFKHGNSPV() {
_modifyandopen(ToResource('jsp/pg_fileuic_portlet.jsp'+'')+'?m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null)
}
function href_RFQOXRTNQW() {
var l_oWv = InitWvApplet();
l_oWv.setValue('pTipo',AsAppletValue('R'));
l_oWv.setValue('w_DaDatOpe',AsAppletValue(w_DaDatOpe));
l_oWv.setValue('w_ADatOpe',AsAppletValue(w_ADatOpe));
l_oWv.setValue('w_tipocr',AsAppletValue(w_tipocr));
l_oWv.setValue('w_codcr',AsAppletValue(w_codcr));
l_oWv.setValue('w_flgfrazionate',AsAppletValue(w_flgfrazionate));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('pTipo,w_DaDatOpe,w_ADatOpe,w_tipocr,w_codcr,w_flgfrazionate'));
SetLocationHref(null,'arrt_discouic_chk'+'?m_cWv='+URLenc(l_oWv.asString())+'&m_cAction=start&m_cMode=hyperlink','elaborazione')
}
function href_TFFWCBBCLE() {
var l_oWv = InitWvApplet();
l_oWv.setValue('pTipo',AsAppletValue('X'));
l_oWv.setValue('w_DaDatOpe',AsAppletValue(w_DaDatOpe));
l_oWv.setValue('w_ADatOpe',AsAppletValue(w_ADatOpe));
l_oWv.setValue('w_tipocr',AsAppletValue(w_tipocr));
l_oWv.setValue('w_codcr',AsAppletValue(w_codcr));
l_oWv.setValue('w_flgfrazionate',AsAppletValue(w_flgfrazionate));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('pTipo,w_DaDatOpe,w_ADatOpe,w_tipocr,w_codcr,w_flgfrazionate'));
SetLocationHref(null,'arrt_discouic_chk'+'?m_cWv='+URLenc(l_oWv.asString())+'&m_cAction=start&m_cMode=hyperlink','elaborazione')
}
function href_EZFKZSHHTQ() {
var l_oWv = InitWvApplet();
l_oWv.setValue('pTipo',AsAppletValue('A'));
l_oWv.setValue('w_DaDatOpe',AsAppletValue(w_DaDatOpe));
l_oWv.setValue('w_ADatOpe',AsAppletValue(w_ADatOpe));
l_oWv.setValue('w_tipocr',AsAppletValue(w_tipocr));
l_oWv.setValue('w_codcr',AsAppletValue(w_codcr));
l_oWv.setValue('w_flgfrazionate',AsAppletValue(w_flgfrazionate));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('pTipo,w_DaDatOpe,w_ADatOpe,w_tipocr,w_codcr,w_flgfrazionate'));
SetLocationHref(null,'arrt_discouic_ver'+'?m_cWv='+URLenc(l_oWv.asString())+'&m_cAction=start&m_cMode=hyperlink','elaborazione')
}
function PEJKGIUJDF_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_flgfrazionate(ChkboxValueAssign(Ctrl('PEJKGIUJDF'),'S','N','C',1,0,''),null,e);
}
function PEJKGIUJDF_OnFocus(e) {
SetActiveField(Ctrl('PEJKGIUJDF'),true);
}
function PEJKGIUJDF_OnBlur(e) {
SetActiveField(Ctrl('PEJKGIUJDF'),false);
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
if(c=Ctrl('QHXVBCMDEB')) c.onchange=QHXVBCMDEB_Valid;
if(c=Ctrl('QHXVBCMDEB')) c.onfocus=QHXVBCMDEB_OnFocus;
if(c=Ctrl('QHXVBCMDEB')) c.onblur=QHXVBCMDEB_OnBlur;
if(c=Ctrl('KAGRBEILOC')) c.onblur=KAGRBEILOC_Valid;
if(c=Ctrl('KAGRBEILOC')) c.onfocus=KAGRBEILOC_OnFocus;
if(c=Ctrl('FAWXPLZBPU')) c.onblur=FAWXPLZBPU_Valid;
if(c=Ctrl('FAWXPLZBPU')) c.onfocus=FAWXPLZBPU_OnFocus;
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
if(c=Ctrl('FAWXPLZBPU')) c.onkeypress=CheckDateChar;
}
if(c=Ctrl('OVFXSLBYQY')) c.onblur=OVFXSLBYQY_Valid;
if(c=Ctrl('OVFXSLBYQY')) c.onfocus=OVFXSLBYQY_OnFocus;
if(c=Ctrl('OVFXSLBYQY')) c.onkeypress=CheckNum;
if(c=Ctrl('PEJKGIUJDF')) c.onclick=PEJKGIUJDF_Valid;
if(c=Ctrl('PEJKGIUJDF')) c.onfocus=PEJKGIUJDF_OnFocus;
if(c=Ctrl('PEJKGIUJDF')) c.onblur=PEJKGIUJDF_OnBlur;
}
}
function NotifyEvent(p_cEvent) {
var old_c;
if (Ne(typeof(w_Messaggi),'undefined')) {
w_Messaggi.raiseEvent('arpg_discouic_xbrl_'+Strtran(p_cEvent,' ','_'));
}
if (Ne(typeof(w_Log),'undefined')) {
w_Log.raiseEvent('arpg_discouic_xbrl_'+Strtran(p_cEvent,' ','_'));
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
windowOpenForeground('../doc/arpg_discouic_xbrl_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
}
function CalledBatchEnd() {
if ( ! (m_bCalculating)) {
DoUpdate(true);
}
}
function LoadChildrenInPage(page,lazy) {
}
GetLayerID.Layers.push({"id":"PBGEOWBBUF","name":"DateOperazione"});
GetLayerID.Layers.push({"id":"MJZOLGWVXE","name":"DatiIntermediario"});
GetLayerID.Layers.push({"id":"QEFBIKGKTK","name":"DatiInvio"});
function DeclareWVs() {
var a = arguments;
w_gIntemediario=a[0];
w_gTipInter=a[1];
w_DaDatOpe=a[2];
w_ADatOpe=a[3];
w_tipocr=a[4];
w_codcr=a[5];
w_datinv=a[6];
w_numinv=a[7];
w_flgfrazionate=a[8];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_discouic_xbrl',m_cSelectedPage);
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
l_bEnabled= ! ( ! (Empty(w_DaDatOpe)) &&  ! (Empty(w_ADatOpe)) &&  ! (Empty(w_datinv)) &&  ! (Empty(w_numinv)));
SetDisabled(Ctrl('CZXYDCLLYZ'),l_bEnabled);
if (IsDisabledByStateDriver('DateOperazione')) {
DisableInputsInContainer(Ctrl('PBGEOWBBUF'),true);
}
if (IsDisabledByStateDriver('DatiIntermediario')) {
DisableInputsInContainer(Ctrl('MJZOLGWVXE'),true);
}
if (IsDisabledByStateDriver('DatiInvio')) {
DisableInputsInContainer(Ctrl('QEFBIKGKTK'),true);
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
function Set_tipocr(ctrlValue,kmode,e) {
if (Ne(w_tipocr,ctrlValue)) {
var ctl = _GetCtl(e,'QHXVBCMDEB');
if (_tracker.goon(ctl,ctrlValue)) {
w_tipocr=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QHXVBCMDEB',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',2,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_flgfrazionate(ctrlValue,kmode,e) {
if (Ne(w_flgfrazionate,ctrlValue)) {
var ctl = _GetCtl(e,'PEJKGIUJDF');
if (_tracker.goon(ctl,ctrlValue)) {
w_flgfrazionate=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('PEJKGIUJDF',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
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
DoUpdate(l_bResult);
} else {
ctl.value=WtH(NullDate(),'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
_ResetTracker();
return true;
}
}
return true;
}
function Set_codcr(ctrlValue,kmode,e) {
if (Ne(w_codcr,ctrlValue)) {
var ctl = _GetCtl(e,'KAGRBEILOC');
if (_tracker.goon(ctl,ctrlValue)) {
w_codcr=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('KAGRBEILOC',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',11,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_datinv(ctrlValue,kmode,e) {
if (Ne(w_datinv,ctrlValue)) {
var ctl = _GetCtl(e,'FAWXPLZBPU');
if (_tracker.goon(ctl,ctrlValue)) {
w_datinv=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FAWXPLZBPU',0);
if (l_bResult) {
l_bResult=Gt(w_datinv,w_ADatOpe);
if ( ! (l_bResult)) {
m_nLastError=2;
m_cLastWorkVarErrorMsg='datinv';
m_cLastMsgError=AlertErrorMessage('1581346268');
}
if ( ! (l_bResult)) {
w_datinv=HtW('','D');
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
function Set_numinv(ctrlValue,kmode,e) {
if (Ne(w_numinv,ctrlValue)) {
var ctl = _GetCtl(e,'OVFXSLBYQY');
if (_tracker.goon(ctl,ctrlValue)) {
w_numinv=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('OVFXSLBYQY',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','N',10,0,'');
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
if ( ! (_ChkObl('DPKVLWHCIG',1))) {
_SignErr('DPKVLWHCIG','718315030');
l_bResult=false;
w_DaDatOpe=HtW('','D');
} else if ( ! (_ChkObl('MTJDZQTEIR',1))) {
_SignErr('MTJDZQTEIR');
m_cLastWorkVarErrorMsg='ADatOpe';
l_bResult=false;
w_ADatOpe=HtW('','D');
} else if ( ! (_ChkObl('QHXVBCMDEB',1))) {
_SignErr('QHXVBCMDEB');
m_cLastWorkVarErrorMsg='tipocr';
l_bResult=false;
w_tipocr=HtW('','C');
} else if ( ! (_ChkObl('KAGRBEILOC',1))) {
_SignErr('KAGRBEILOC');
m_cLastWorkVarErrorMsg='codcr';
l_bResult=false;
w_codcr=HtW('','C');
} else if (( ! (_ChkObl('FAWXPLZBPU',1))) || ( ! (Gt(w_datinv,w_ADatOpe)))) {
_SignErr('FAWXPLZBPU','1581346268');
l_bResult=false;
w_datinv=HtW('','D');
} else if ( ! (_ChkObl('OVFXSLBYQY',1))) {
_SignErr('OVFXSLBYQY');
m_cLastWorkVarErrorMsg='numinv';
l_bResult=false;
w_numinv=HtW('','N');
} else if ( ! (_ChkObl('PEJKGIUJDF',1))) {
_SignErr('PEJKGIUJDF');
m_cLastWorkVarErrorMsg='flgfrazionate';
l_bResult=false;
w_flgfrazionate='N';
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
l_oWv.setValue('gIntemediario',WtA(w_gIntemediario,'C'));
l_oWv.setValue('gTipInter',WtA(w_gTipInter,'C'));
l_oWv.setValue('DaDatOpe',WtA(w_DaDatOpe,'D'));
l_oWv.setValue('ADatOpe',WtA(w_ADatOpe,'D'));
l_oWv.setValue('tipocr',WtA(w_tipocr,'C'));
l_oWv.setValue('codcr',WtA(w_codcr,'C'));
l_oWv.setValue('datinv',WtA(w_datinv,'D'));
l_oWv.setValue('numinv',WtA(w_numinv,'N'));
l_oWv.setValue('flgfrazionate',WtA(w_flgfrazionate,'C'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["gIntemediario","gTipInter","DaDatOpe","ADatOpe","tipocr","codcr","datinv","numinv","flgfrazionate"];
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
if (Eq(w_tipocr,w_gTipInter) && Ne(opener.w_tipocr,null)) {
TransferBetweenWindows(opener,'w_tipocr',null,'Set_tipocr');
}
if (Eq(w_codcr,w_gIntemediario) && Ne(opener.w_codcr,null)) {
TransferBetweenWindows(opener,'w_codcr',null,'Set_codcr');
}
if (Eq(w_datinv,SystemDate()) && Ne(opener.w_datinv,null)) {
TransferBetweenWindows(opener,'w_datinv',null,'Set_datinv');
}
}
}
m_bCalculating=true;
if (start && Eq(At(',tipocr,',pseq),0)) {
w_tipocr=w_gTipInter;
}
if (start && Eq(At(',codcr,',pseq),0)) {
w_codcr=w_gIntemediario;
}
if (start && Eq(At(',datinv,',pseq),0)) {
w_datinv=SystemDate();
}
if (start && Eq(At(',numinv,',pseq),0)) {
w_numinv=1;
}
if (start && Eq(At(',flgfrazionate,',pseq),0)) {
w_flgfrazionate='N';
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
_Obli('tipocr',0,'QHXVBCMDEB',false)
_Obli('flgfrazionate',0,'PEJKGIUJDF',false)
_Obli('DaDatOpe',2,'DPKVLWHCIG',false)
_Obli('ADatOpe',2,'MTJDZQTEIR',false)
_Obli('codcr',0,'KAGRBEILOC',false)
_Obli('datinv',2,'FAWXPLZBPU',false)
_Obli('numinv',1,'OVFXSLBYQY',false)
