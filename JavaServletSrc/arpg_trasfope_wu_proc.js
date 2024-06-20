function SetControlsValue() {
var c;
var c;
if(c=Ctrl('DPKVLWHCIG')) c.value = WtH(w_DaDatOpe,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('MTJDZQTEIR')) c.value = WtH(w_ADatOpe,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
var tmp_FGMOCXNBFY = ToHTag(AsControlValue('<iframe width=\'655\' height=\'170\' id=\'elaborazione\' name=\'elaborazione\' frameborder=\'1\'  border=\'1\' align=\'TOP\' marginwidth=\'1\' marginheight=\'1\'></iframe>'));
if (Ne(e_FGMOCXNBFY,tmp_FGMOCXNBFY)) {
if(c=Ctrl('FGMOCXNBFY')) c.innerHTML=tmp_FGMOCXNBFY;
e_FGMOCXNBFY=tmp_FGMOCXNBFY;
}
var tmp_SSRCOAMDBL = ToHTag(AsControlValue('<iframe width=\'755\' height=\'150\' id =\'messaggi\' src=\'arpg_msg_import\' frameborder=\'1\'  border=\'1\' align=\'TOP\' marginwidth=\'1\' marginheight=\'1\'></iframe>'));
if (Ne(e_SSRCOAMDBL,tmp_SSRCOAMDBL)) {
if(c=Ctrl('SSRCOAMDBL')) c.innerHTML=tmp_SSRCOAMDBL;
e_SSRCOAMDBL=tmp_SSRCOAMDBL;
}
if(c=Ctrl('YYALJHFGYI')) c.value = WtH(w_DaDatReg,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('NGHKLZMUCL')) c.value = WtH(w_ADatReg,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if (Gt(m_nRows,0) && Lt(m_nCurrentRow,m_oTrsFW.length)) {
if (Ne(Ctrl('BBVZXDYMJX_'+m_nCurrentRow),null)) {
if(c=Ctrl('BBVZXDYMJX_'+m_nCurrentRow)) ChkboxCheckUncheck(c,'S',w_FLGSEL)
if(c=Ctrl('BBVZXDYMJX_'+m_nCurrentRow)) ChkboxValueAssign(c,'S','N','C',1,0,'')
}
}
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay(Ctrl('FGMOCXNBFY'),true);
if (Gt(m_nRows,0)) {
SetDisplay(Ctrl('ACJEOURJYI'),true);
}
HideUI();
}
HideUI.lblids["ADatOpe"]=['BGHAITOPMU'];
HideUI.lblids["ADatReg"]=['GEKFJYIFQW'];
HideUI.lblids["DaDatOpe"]=['HPGJXQIVYG'];
HideUI.lblids["DaDatReg"]=['UBGQMHONZK'];
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
function DPKVLWHCIG_ZOOM_Click() {
LaunchCalendar(Ctrl('DPKVLWHCIG'));
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
function MTJDZQTEIR_ZOOM_Click() {
LaunchCalendar(Ctrl('MTJDZQTEIR'));
}
function href_FLFHSXPWZI() {
SetLocationHref(null,'arrt_trasfope_wu'+'?m_cAction=start&m_cMode=hyperlink','elaborazione')
}
function href_VRHQBWKFPP() {
SetHypPar('m_cAction',AsAppletValue('start'));
SetHypPar('m_cMode',AsAppletValue('hyperlink'));
SetHypPar('m_cID',AsAppletValue(m_IDS['arrt_trasfope_sel']));
SendData('start','arrt_trasfope_sel'+'',HParApplet().asString());
}
function href_HDSXZTLKVK() {
Update()
}
function href_ZWTNEMXOFQ() {
SetHypPar('m_cAction',AsAppletValue('start'));
SetHypPar('m_cMode',AsAppletValue('hyperlink'));
SetHypPar('pTipo',AsAppletValue('D'));
SetHypPar('m_cParameterSequence',AsAppletValue('pTipo'));
SetHypPar('m_cID',AsAppletValue(m_IDS['arrt_seldes_trasfope']));
SendData('start','arrt_seldes_trasfope'+'',HParApplet().asString());
}
function href_FCATLNLMSB() {
SetHypPar('m_cAction',AsAppletValue('start'));
SetHypPar('m_cMode',AsAppletValue('hyperlink'));
SetHypPar('pTipo',AsAppletValue('S'));
SetHypPar('m_cParameterSequence',AsAppletValue('pTipo'));
SetHypPar('m_cID',AsAppletValue(m_IDS['arrt_seldes_trasfope']));
SendData('start','arrt_seldes_trasfope'+'',HParApplet().asString());
}
function BBVZXDYMJX_Valid(e) {
var org = GetEventSrcElement(e);
if ( ! (org.focused)) {
var c = org.checked;
org.focus();
org.checked=c;
}
e=(Ne(e,null)?e:window.event);
return Set_FLGSEL(ChkboxValueAssign(Ctrl('BBVZXDYMJX_'+m_nCurrentRow),'S','N','C',1,0,''),null,e);
}
function BBVZXDYMJX_OnFocus(e) {
var org;
org=GetEventSrcElement(e);
org.focused=true;
ChangeRow(Val(Right(org.name,Len(org.name)-RAt('_',org.name))));
}
function BBVZXDYMJX_OnBlur(e) {
SetActiveField(Ctrl('BBVZXDYMJX_'+m_nCurrentRow),false);
}
function BBVZXDYMJX_OnBlur(e) {
var org = GetEventSrcElement(e);
org.focused=false;
}
function BBVZXDYMJX_OnFocus(e) {
var org;
org=GetEventSrcElement(e);
org.focused=true;
ChangeRow(Val(Right(org.name,Len(org.name)-RAt('_',org.name))));
}
function href_PTXYMSWBZO() {
SetLocationHref(window.location,ToResource('jsp/start_page_logo_portlet.jsp'+'')+'')
}
function YYALJHFGYI_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('YYALJHFGYI'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('YYALJHFGYI').value=ApplyPictureToDate(Ctrl('YYALJHFGYI').value,TranslatePicture(datePattern),'YYALJHFGYI');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('YYALJHFGYI'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('YYALJHFGYI');
}
}
}
SetActiveField(Ctrl('YYALJHFGYI'),false);
e=(Ne(e,null)?e:window.event);
return Set_DaDatReg(HtW(Ctrl('YYALJHFGYI').value,'D'),null,e) && dateisok;
}
function YYALJHFGYI_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('YYALJHFGYI'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('YYALJHFGYI').value=WtH(w_DaDatReg,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('YYALJHFGYI');
SetActiveField(Ctrl('YYALJHFGYI'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('YYALJHFGYI'),e);
}
function YYALJHFGYI_ZOOM_Click() {
LaunchCalendar(Ctrl('YYALJHFGYI'));
}
function NGHKLZMUCL_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('NGHKLZMUCL'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('NGHKLZMUCL').value=ApplyPictureToDate(Ctrl('NGHKLZMUCL').value,TranslatePicture(datePattern),'NGHKLZMUCL');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('NGHKLZMUCL'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('NGHKLZMUCL');
}
}
}
SetActiveField(Ctrl('NGHKLZMUCL'),false);
e=(Ne(e,null)?e:window.event);
return Set_ADatReg(HtW(Ctrl('NGHKLZMUCL').value,'D'),null,e) && dateisok;
}
function NGHKLZMUCL_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('NGHKLZMUCL'))) {
DisplayErrorMessage();
}
if (Ne(_tracker.ctrl,Ctrl('NGHKLZMUCL'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('NGHKLZMUCL').value=WtH(w_ADatReg,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
}
m_oEnteredInDate=Ctrl('NGHKLZMUCL');
SetActiveField(Ctrl('NGHKLZMUCL'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('NGHKLZMUCL'),e);
}
function NGHKLZMUCL_ZOOM_Click() {
LaunchCalendar(Ctrl('NGHKLZMUCL'));
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
if(c=Ctrl('YYALJHFGYI')) c.onblur=YYALJHFGYI_Valid;
if(c=Ctrl('YYALJHFGYI')) c.onfocus=YYALJHFGYI_OnFocus;
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
if(c=Ctrl('YYALJHFGYI')) c.onkeypress=CheckDateChar;
}
if(c=Ctrl('NGHKLZMUCL')) c.onblur=NGHKLZMUCL_Valid;
if(c=Ctrl('NGHKLZMUCL')) c.onfocus=NGHKLZMUCL_OnFocus;
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
if(c=Ctrl('NGHKLZMUCL')) c.onkeypress=CheckDateChar;
}
}
var l_nOldRow = m_nCurrentRow;
m_nCurrentRow=0;
while (Lt(m_nCurrentRow,m_nRows)) {
if(c=Ctrl('BBVZXDYMJX_'+m_nCurrentRow)) c.onclick=BBVZXDYMJX_Valid;
if(c=Ctrl('BBVZXDYMJX_'+m_nCurrentRow)) c.onfocus=BBVZXDYMJX_OnFocus;
if(c=Ctrl('BBVZXDYMJX_'+m_nCurrentRow)) c.onblur=BBVZXDYMJX_OnBlur;
if(c=Ctrl('BBVZXDYMJX_'+m_nCurrentRow)) c.onfocus=BBVZXDYMJX_OnFocus;
if(c=Ctrl('BBVZXDYMJX_'+m_nCurrentRow)) c.onblur=BBVZXDYMJX_OnBlur;
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
FocusFirstComponent.otherwise={"page_1":["DPKVLWHCIG"]};
function Help() {
windowOpenForeground('../doc/arpg_trasfope_wu_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_FLGSEL=a[0];
w_DaDatOpe=a[1];
w_ADatOpe=a[2];
w_cdadata=a[3];
w_c_adata=a[4];
w_DaDatReg=a[5];
w_ADatReg=a[6];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_trasfope_wu',m_cSelectedPage);
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
FillFrmTrs('FLGSEL');
SubmitForm('save');
}
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
m_cLastMsgError=AlertErrorMessage('10357201410');
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
function Set_FLGSEL(ctrlValue,kmode,e) {
if (Ne(w_FLGSEL,ctrlValue)) {
var ctl = _GetCtl(e,'BBVZXDYMJX_'+m_nCurrentRow+'');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLGSEL=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BBVZXDYMJX',0);
DoFieldsUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_ADatReg(ctrlValue,kmode,e) {
if (Ne(w_ADatReg,ctrlValue)) {
var ctl = _GetCtl(e,'NGHKLZMUCL');
if (_tracker.goon(ctl,ctrlValue)) {
w_ADatReg=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NGHKLZMUCL',0);
if (l_bResult) {
l_bResult=Ge(w_ADatReg,w_DaDatReg);
if ( ! (l_bResult)) {
m_nLastError=2;
m_cLastWorkVarErrorMsg='ADatReg';
m_cLastMsgError=AlertErrorMessage('1908230533');
}
if ( ! (l_bResult)) {
w_ADatReg=HtW('','D');
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
function Set_DaDatReg(ctrlValue,kmode,e) {
if (Ne(w_DaDatReg,ctrlValue)) {
var ctl = _GetCtl(e,'YYALJHFGYI');
if (_tracker.goon(ctl,ctrlValue)) {
w_DaDatReg=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YYALJHFGYI',0);
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
_SignErr('MTJDZQTEIR','10357201410');
l_bResult=false;
w_ADatOpe=HtW('','D');
} else if ( ! (_ChkObl('BBVZXDYMJX',1))) {
_SignErr('BBVZXDYMJX_'+m_nCurrentRow+'');
m_cLastWorkVarErrorMsg='10709584481';
l_bResult=false;
w_FLGSEL='N';
} else if ( ! (_ChkObl('YYALJHFGYI',1))) {
_SignErr('YYALJHFGYI');
m_cLastWorkVarErrorMsg='DaDatReg';
l_bResult=false;
w_DaDatReg=HtW('','D');
} else if (( ! (_ChkObl('NGHKLZMUCL',1))) || ( ! (Ge(w_ADatReg,w_DaDatReg)))) {
_SignErr('NGHKLZMUCL','1908230533');
l_bResult=false;
w_ADatReg=HtW('','D');
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('DPKVLWHCIG_ZOOM',lc)) {
return 0;
}
if (Eq('MTJDZQTEIR_ZOOM',lc)) {
return 0;
}
if (Eq('YYALJHFGYI_ZOOM',lc)) {
return 0;
}
if (Eq('NGHKLZMUCL_ZOOM',lc)) {
return 0;
}
return -1;
}
function link_url(index) {
var l_oWv;
}
function FillWv() {
var l_oWv = InitWvApplet();
l_oWv.setValue('FLGSEL',WtA(w_FLGSEL,'C'));
l_oWv.setValue('DaDatOpe',WtA(w_DaDatOpe,'D'));
l_oWv.setValue('ADatOpe',WtA(w_ADatOpe,'D'));
l_oWv.setValue('cdadata',WtA(w_cdadata,'C'));
l_oWv.setValue('c_adata',WtA(w_c_adata,'C'));
l_oWv.setValue('DaDatReg',WtA(w_DaDatReg,'D'));
l_oWv.setValue('ADatReg',WtA(w_ADatReg,'D'));
_FillChildren(l_oWv);
l_oWv.setValue('m_oTrs',TrsApplet().asString());
}
_FillChildren.n=[];
FillWv.n=["FLGSEL","DaDatOpe","ADatOpe","cdadata","c_adata","DaDatReg","ADatReg"];
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
if (Empty(w_DaDatReg) && Ne(opener.w_DaDatReg,null)) {
TransferBetweenWindows(opener,'w_DaDatReg',null,'Set_DaDatReg');
}
if (Empty(w_ADatReg) && Ne(opener.w_ADatReg,null)) {
TransferBetweenWindows(opener,'w_ADatReg',null,'Set_ADatReg');
}
}
}
m_bCalculating=true;
w_cdadata=DateToChar(w_DaDatOpe);
w_c_adata=DateToChar(w_ADatOpe);
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
function TrsFWRow() {
  this.w_FLGSEL = arguments[0]
  this.t_FLGSEL = arguments[1]
  this.k_FLGSEL_NUMPROG = arguments[2]
  this.m_nRowStatus = arguments[3]
}
function TrsQueryRow() {
  this.c_NUMPROG = arguments[0]
  this.c_DATAOPE = arguments[1]
  this.c_RAPPORTO = arguments[2]
  this.c_CONNESCLI = arguments[3]
  this.c_TOTLIRE = arguments[4]
  this.c_TOTCONT = arguments[5]
  this.c_VALUTA = arguments[6]
  this.c_IDBASE = arguments[7]
}
function TrsToWork() {
var row;
if (Lt(m_nCurrentRow,m_oTrsFW.length)) {
row=m_oTrsFW[m_nCurrentRow];
w_FLGSEL=row.w_FLGSEL;
m_nRowStatus=row.m_nRowStatus;
}
if (Lt(m_nCurrentRow,m_oTrsQuery.length)) {
row=m_oTrsQuery[m_nCurrentRow];
c_NUMPROG=row.c_NUMPROG;
c_DATAOPE=row.c_DATAOPE;
c_RAPPORTO=row.c_RAPPORTO;
c_CONNESCLI=row.c_CONNESCLI;
c_TOTLIRE=row.c_TOTLIRE;
c_TOTCONT=row.c_TOTCONT;
c_VALUTA=row.c_VALUTA;
c_IDBASE=row.c_IDBASE;
}
}
function WorkToTrs() {
var row;
if (Lt(m_nCurrentRow,m_oTrsFW.length)) {
row=m_oTrsFW[m_nCurrentRow];
row.w_FLGSEL=w_FLGSEL;
row.m_nRowStatus=m_nRowStatus;
}
if (Lt(m_nCurrentRow,m_oTrsQuery.length)) {
row=m_oTrsQuery[m_nCurrentRow];
row.c_NUMPROG=c_NUMPROG;
row.c_DATAOPE=c_DATAOPE;
row.c_RAPPORTO=c_RAPPORTO;
row.c_CONNESCLI=c_CONNESCLI;
row.c_TOTLIRE=c_TOTLIRE;
row.c_TOTCONT=c_TOTCONT;
row.c_VALUTA=c_VALUTA;
row.c_IDBASE=c_IDBASE;
}
}
function BlankQueryFields() {
c_NUMPROG='';
c_DATAOPE=NullDate();
c_RAPPORTO='';
c_CONNESCLI='';
c_TOTLIRE=0;
c_TOTCONT=0;
c_VALUTA='';
c_IDBASE='';
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
var l_DBMPSAJNIE = false;
var l_old_DBMPSAJNIE = l_DBMPSAJNIE;
Body_BeginHtml(180,'',0,'A','');
BlankQueryFields();
while ( ! (l_bEof)) {
l_oQuery=m_oTrsQuery[l_nIdx];
l_oFields=m_oTrsFW[l_nIdx];
l_nDeep=0;
if (Lt(l_nIdx,m_nRows)) {
m_nCurrentRow=l_nIdx;
TrsToWork();
l_DBMPSAJNIE=true;
if (Eq(l_nIdx,0)) {
l_nDeep=1;
} else {
if (Ne(l_old_DBMPSAJNIE,l_DBMPSAJNIE)) {
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
GroupFooter_BeginHtml(document,1,'1459998995'+l_nIdx+'','A',true,false)
GroupFooter_EndHtml(document,1,'1459998995'+l_nIdx+'','A')
} else {
}
l_nIdx=l_nIdx+1;
m_nCurrentRow=l_nIdx;
TrsToWork();
l_old_DBMPSAJNIE = l_DBMPSAJNIE;
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
Update_Button("ACJEOURJYI",Translate("113933141"),"","","","CLASS=FormDefault STYLE='display:"+(true?'none':'inline')+"'","")
}
Body_EndHtml('A');
}
function DrawLine(document) {
l_nIdx=Parms.Idx;
l_nDeep=Parms.Deep;
l_nEvenOdd=Parms.EvenOdd;
if (Ge(2,l_nDeep)) {
GroupHeader_BeginHtml(document,1,'1459999027'+l_nIdx+'','A',true,false)
document.writeln(
 "<div id='DIV_0BBB7FA0"+l_nIdx+"' style='position:relative;height:16px'>" +
"")
document.writeln(
 "<span class=' SPLabel DIWJSXFYLW_DIV'>" +
 "<label class='DIWJSXFYLW'>" +
 ""+ToHTag(Translate("829201110"))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel WEUNTCEZTI_DIV'>" +
 "<label class='WEUNTCEZTI'>" +
 ""+ToHTag(Translate("11446421191"))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel JUIALTQGYN_DIV'>" +
 "<label class='JUIALTQGYN'>" +
 ""+ToHTag(Translate("1805022818"))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel BWDHQRZLTC_DIV'>" +
 "<label class='BWDHQRZLTC'>" +
 ""+ToHTag(Translate("1824000386"))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel KKONMMBUPW_DIV'>" +
 "<label class='KKONMMBUPW'>" +
 ""+ToHTag(Translate("1825772649"))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel NFMIERMJRB_DIV'>" +
 "<label class='NFMIERMJRB'>" +
 ""+ToHTag(Translate("10948496749"))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "</div>" +
"")
GroupHeader_EndHtml(document,1,'1459999027'+l_nIdx+'','A')
} else {
}
Row_BeginHtml(document,l_nEvenOdd,'1459773907'+l_nIdx+'','A',true,-1)
document.writeln(
 "<div id='DIV_0BAB6658"+l_nIdx+"' style='position:relative;height:22px'>" +
"")
document.writeln(
 "<span class='BBVZXDYMJX_DIV' id='BBVZXDYMJX_"+l_nIdx+"_DIV'>" +
 "<input name='FLGSEL_"+l_nIdx+"' id='BBVZXDYMJX_"+l_nIdx+"' type='checkbox' value="+ToHTMLValue(WtH(w_FLGSEL,"C",1,0,''))+" "+(Eq('S',w_FLGSEL)?'CHECKED':'')+">" +
 "<label id='BBVZXDYMJX_"+l_nIdx+"_LBL' for='BBVZXDYMJX_"+l_nIdx+"' class='SPLabel'>"+ToHTag(Translate("10638322983"))+"</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel INHUFYJSGO_DIV'>" +
 "<label class='INHUFYJSGO'>" +
 ""+ToHTag(WtH(c_DATAOPE,'D',8,0,'DD-MM-YYYY'))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel VCVHCSGAYA_DIV'>" +
 "<label class='VCVHCSGAYA'>" +
 ""+ToHTag(WtH(c_NUMPROG,'C',11,0,''))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel RNOKLAJWBF_DIV'>" +
 "<label class='RNOKLAJWBF'>" +
 ""+ToHTag(WtH(c_RAPPORTO,'C',25,0,''))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel FWVRGICMKB_DIV'>" +
 "<label class='FWVRGICMKB'>" +
 ""+ToHTag(WtH(c_CONNESCLI,'C',16,0,''))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel BCCPSVUVJE_DIV'>" +
 "<label class='BCCPSVUVJE'>" +
 ""+ToHTag(WtH(c_TOTLIRE,'N',15,2,'999,999,999.99'))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel KEFLALYAMR_DIV'>" +
 "<label class='KEFLALYAMR'>" +
 ""+ToHTag(WtH(c_TOTCONT,'N',15,2,'999,999,999.99'))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "</div>" +
"")
Row_EndHtml(document,l_nEvenOdd,'1459773907'+l_nIdx+'','A')
Parms.Idx=l_nIdx;
Parms.Deep=l_nDeep;
Parms.EvenOdd=l_nEvenOdd;
}
Parms=new Object();
_Obli('DaDatOpe',2,'DPKVLWHCIG',false)
_Obli('ADatOpe',2,'MTJDZQTEIR',false)
_Obli('FLGSEL',0,'BBVZXDYMJX',false,"10709584481")
_Obli('ADatReg',2,'NGHKLZMUCL',false)
_Obli('DaDatReg',2,'YYALJHFGYI',false)
