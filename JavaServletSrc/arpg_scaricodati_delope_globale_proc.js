function SetControlsValue() {
var c;
var c;
if(c=Ctrl('FSXHJAAZGG')) c.value = WtH(w_dadata,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('CLVVMIYSQG')) c.value = WtH(w_a_data,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
var tmp_FGMOCXNBFY = ToHTag(AsControlValue('<iframe width=\'655\' height=\'170\' id=\'elaborazione\' name=\'elaborazione\' frameborder=\'1\'  border=\'1\' align=\'TOP\' marginwidth=\'1\' marginheight=\'1\'></iframe>'));
if (Ne(e_FGMOCXNBFY,tmp_FGMOCXNBFY)) {
if(c=Ctrl('FGMOCXNBFY')) c.innerHTML=tmp_FGMOCXNBFY;
e_FGMOCXNBFY=tmp_FGMOCXNBFY;
}
if(c=Ctrl('MPIOZQPPPI')) c.value = WtH(w_CFINVIO,'C',16,0,'')
if(c=Ctrl('YFPMFPWESC')) c.value = WtH(w_CAFINVIO,'C',5,0,'')
if(c=Ctrl('HMYRBXBREF')) selectCombo(c,w_FILEINVIO,'C')
if(c=Ctrl('CQATNPZMEC')) c.value = WtH(w_DATAINVIO,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('SJMOZNWBVK')) selectRadio(c,w_limite,'N')
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay(Ctrl('FGMOCXNBFY'),true);
HideUI();
}
HideUI.lblids["CAFINVIO"]=['LASRRWOCQH'];
HideUI.lblids["CFINVIO"]=['CTFPYTZIIH'];
HideUI.lblids["DATAINVIO"]=['FHSMWCMRII'];
HideUI.lblids["FILEINVIO"]=['HAINTPIJUS'];
HideUI.lblids["a_data"]=['LFJQIXRRKM'];
HideUI.lblids["dadata"]=['NOYEUIKFXN'];
function ZUXUDAETFH_Click() {
if ( ! (Empty(w_dadata)) &&  ! (Empty(w_a_data))) {
SetLocationHref(null,'arrt_sd_delope_globale'+'?m_cAction=start&m_cMode=hyperlink','elaborazione')
}
}
function CLVVMIYSQG_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('CLVVMIYSQG'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('CLVVMIYSQG').value=ApplyPictureToDate(Ctrl('CLVVMIYSQG').value,TranslatePicture(datePattern),'CLVVMIYSQG');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('CLVVMIYSQG'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('CLVVMIYSQG');
}
}
}
SetActiveField(Ctrl('CLVVMIYSQG'),false);
e=(Ne(e,null)?e:window.event);
return Set_a_data(HtW(Ctrl('CLVVMIYSQG').value,'D'),null,e) && dateisok;
}
function CLVVMIYSQG_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('CLVVMIYSQG'))) {
DisplayErrorMessage();
}
if (Ne(_tracker.ctrl,Ctrl('CLVVMIYSQG'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('CLVVMIYSQG').value=WtH(w_a_data,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
}
m_oEnteredInDate=Ctrl('CLVVMIYSQG');
SetActiveField(Ctrl('CLVVMIYSQG'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('CLVVMIYSQG'),e);
}
function MPIOZQPPPI_Valid(e) {
SetActiveField(Ctrl('MPIOZQPPPI'),false);
e=(Ne(e,null)?e:window.event);
return Set_CFINVIO(HtW(Ctrl('MPIOZQPPPI').value,'C'),null,e);
}
function MPIOZQPPPI_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('MPIOZQPPPI'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('MPIOZQPPPI'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('MPIOZQPPPI'),e);
}
function YFPMFPWESC_Valid(e) {
SetActiveField(Ctrl('YFPMFPWESC'),false);
e=(Ne(e,null)?e:window.event);
return Set_CAFINVIO(HtW(Ctrl('YFPMFPWESC').value,'C'),null,e);
}
function YFPMFPWESC_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('YFPMFPWESC'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('YFPMFPWESC'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('YFPMFPWESC'),e);
}
function HMYRBXBREF_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_FILEINVIO(HtW(getComboValue(Ctrl('HMYRBXBREF')),'C'),null,e);
}
function HMYRBXBREF_OnFocus(e) {
SetActiveField(Ctrl('HMYRBXBREF'),true);
}
function HMYRBXBREF_OnBlur(e) {
SetActiveField(Ctrl('HMYRBXBREF'),false);
}
function CQATNPZMEC_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('CQATNPZMEC'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('CQATNPZMEC').value=ApplyPictureToDate(Ctrl('CQATNPZMEC').value,TranslatePicture(datePattern),'CQATNPZMEC');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('CQATNPZMEC'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('CQATNPZMEC');
}
}
}
SetActiveField(Ctrl('CQATNPZMEC'),false);
e=(Ne(e,null)?e:window.event);
return Set_DATAINVIO(HtW(Ctrl('CQATNPZMEC').value,'D'),null,e) && dateisok;
}
function CQATNPZMEC_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('CQATNPZMEC'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('CQATNPZMEC').value=WtH(w_DATAINVIO,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('CQATNPZMEC');
SetActiveField(Ctrl('CQATNPZMEC'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('CQATNPZMEC'),e);
}
function href_JBNBDKBIAJ() {
_modifyandopen('arpg_filesage_do'+'?m_cAction=start&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes,height=600,width=800',null)
}
function SJMOZNWBVK_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_limite(HtW(getRadioValue(Ctrl('SJMOZNWBVK')),'N'),null,e);
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
if(c=Ctrl('CLVVMIYSQG')) c.onblur=CLVVMIYSQG_Valid;
if(c=Ctrl('CLVVMIYSQG')) c.onfocus=CLVVMIYSQG_OnFocus;
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
if(c=Ctrl('CLVVMIYSQG')) c.onkeypress=CheckDateChar;
}
if(c=Ctrl('MPIOZQPPPI')) c.onblur=MPIOZQPPPI_Valid;
if(c=Ctrl('MPIOZQPPPI')) c.onfocus=MPIOZQPPPI_OnFocus;
if(c=Ctrl('YFPMFPWESC')) c.onblur=YFPMFPWESC_Valid;
if(c=Ctrl('YFPMFPWESC')) c.onfocus=YFPMFPWESC_OnFocus;
if(c=Ctrl('HMYRBXBREF')) c.onchange=HMYRBXBREF_Valid;
if(c=Ctrl('HMYRBXBREF')) c.onfocus=HMYRBXBREF_OnFocus;
if(c=Ctrl('HMYRBXBREF')) c.onblur=HMYRBXBREF_OnBlur;
if(c=Ctrl('CQATNPZMEC')) c.onblur=CQATNPZMEC_Valid;
if(c=Ctrl('CQATNPZMEC')) c.onfocus=CQATNPZMEC_OnFocus;
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
if(c=Ctrl('CQATNPZMEC')) c.onkeypress=CheckDateChar;
}
c=Ctrl('SJMOZNWBVK');
if ( ! (Empty(c))) {
c[0].onclick=SJMOZNWBVK_Valid;
c[1].onclick=SJMOZNWBVK_Valid;
}
}
}
function NotifyEvent(p_cEvent) {
var old_c;
if (Ne(typeof(w_Messaggi),'undefined')) {
w_Messaggi.raiseEvent('arpg_scaricodati_delope_globale_'+Strtran(p_cEvent,' ','_'));
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
FocusFirstComponent.otherwise={"page_1":["ZUXUDAETFH","CLVVMIYSQG"]};
function Help() {
windowOpenForeground('../doc/arpg_scaricodati_delope_globale_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_dadata=a[0];
w_a_data=a[1];
w_gIntemediario=a[2];
w_CFINVIO=a[3];
w_CAFINVIO=a[4];
w_FILEINVIO=a[5];
w_DATAINVIO=a[6];
w_limite=a[7];
o_gIntemediario=w_gIntemediario[1];
w_gIntemediario=w_gIntemediario[0];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_scaricodati_delope_globale',m_cSelectedPage);
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
l_bEnabled= ! ( ! (Empty(w_dadata)) &&  ! (Empty(w_a_data)));
SetDisabled(Ctrl('ZUXUDAETFH'),l_bEnabled);
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
function Set_CFINVIO(ctrlValue,kmode,e) {
if (Ne(w_CFINVIO,ctrlValue)) {
var ctl = _GetCtl(e,'MPIOZQPPPI');
if (_tracker.goon(ctl,ctrlValue)) {
w_CFINVIO=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MPIOZQPPPI',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',16,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_a_data(ctrlValue,kmode,e) {
if (Ne(w_a_data,ctrlValue)) {
var ctl = _GetCtl(e,'CLVVMIYSQG');
if (_tracker.goon(ctl,ctrlValue)) {
w_a_data=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CLVVMIYSQG',0);
if (l_bResult) {
l_bResult=Gt(w_a_data,w_dadata);
if ( ! (l_bResult)) {
m_nLastError=2;
m_cLastWorkVarErrorMsg='a_data';
m_cLastMsgError=AlertErrorMessage('10119011931');
}
if ( ! (l_bResult)) {
w_a_data=HtW('','D');
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
function Set_CAFINVIO(ctrlValue,kmode,e) {
if (Ne(w_CAFINVIO,ctrlValue)) {
var ctl = _GetCtl(e,'YFPMFPWESC');
if (_tracker.goon(ctl,ctrlValue)) {
w_CAFINVIO=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('YFPMFPWESC',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',5,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_FILEINVIO(ctrlValue,kmode,e) {
if (Ne(w_FILEINVIO,ctrlValue)) {
var ctl = _GetCtl(e,'HMYRBXBREF');
if (_tracker.goon(ctl,ctrlValue)) {
w_FILEINVIO=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HMYRBXBREF',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_limite(ctrlValue,kmode,e) {
if (Ne(w_limite,ctrlValue)) {
var ctl = _GetCtl(e,'SJMOZNWBVK');
if (_tracker.goon(ctl,ctrlValue)) {
w_limite=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SJMOZNWBVK',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','N',7,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_DATAINVIO(ctrlValue,kmode,e) {
if (Ne(w_DATAINVIO,ctrlValue)) {
var ctl = _GetCtl(e,'CQATNPZMEC');
if (_tracker.goon(ctl,ctrlValue)) {
w_DATAINVIO=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CQATNPZMEC',0);
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
w_dadata=CharToDate('20050101');
if ((Ne(o_gIntemediario,w_gIntemediario))) {
l_bTmpRes=Link_AHMXEPADOR(null);
}
// * --- Area Manuale = UI - Calculate
// * --- Fine Area Manuale
m_bCalculating=false;
}
function SaveDependsOn() {
o_gIntemediario=w_gIntemediario;
}
function SaveLabelDependsOn() {
}
function Link_AHMXEPADOR(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_gIntemediario);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODINTER',w_gIntemediario,11,0);
l_Appl.SetFields('CODINTER,CFINVIO,CAFINVIO,FILEINVIO,DATAINVIO');
l_Appl.SetTypes('C,C,C,C,D');
l_Appl.LinkTable('intermbo');
l_Appl.SetLinkzoom('armt_intermbo');
l_Appl.SetID('AHMXEPADOR');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_gIntemediario=l_Appl.GetStringValue('CODINTER',11,0);
w_CFINVIO=l_Appl.GetStringValue('CFINVIO',16,0);
w_CAFINVIO=l_Appl.GetStringValue('CAFINVIO',5,0);
w_FILEINVIO=l_Appl.GetStringValue('FILEINVIO',1,0);
w_DATAINVIO=l_Appl.GetDateValue('DATAINVIO',8,0);
w_DATAINVIO=DateFromApplet(w_DATAINVIO);
} else {
Link_AHMXEPADOR_Blank();
}
if ( ! (l_bResult)) {
m_nLastError=3;
m_cLastWorkVarErrorMsg='';
if (Lt(l_nRec,0)) {
m_cLastMsgError=Translate('MSG_CONNECT_SERVER');
}
}
return l_bResult;
}
function Link_AHMXEPADOR_Blank() {
w_gIntemediario='';
w_CFINVIO='';
w_CAFINVIO='';
w_FILEINVIO='';
w_DATAINVIO=NullDate();
}
function LOpt_AHMXEPADOR() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('intermbo','C'));
l_oWv.setValue('Linkzoomprg',WtA('armt_intermbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODINTER','C'));
l_oWv.setValue('LinkedField',WtA('CODINTER','C'));
l_oWv.setValue('UID',WtA('AHMXEPADOR','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['AHMXEPADOR'][1],'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
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
if (( ! (_ChkObl('CLVVMIYSQG',1))) || ( ! (Gt(w_a_data,w_dadata)))) {
_SignErr('CLVVMIYSQG','10119011931');
l_bResult=false;
w_a_data=HtW('','D');
} else if ( ! (_ChkObl('MPIOZQPPPI',1))) {
_SignErr('MPIOZQPPPI');
m_cLastWorkVarErrorMsg='11949617228';
l_bResult=false;
w_CFINVIO=HtW('','C');
} else if ( ! (_ChkObl('YFPMFPWESC',1))) {
_SignErr('YFPMFPWESC');
m_cLastWorkVarErrorMsg='346962755';
l_bResult=false;
w_CAFINVIO=HtW('','C');
} else if ( ! (_ChkObl('HMYRBXBREF',1))) {
_SignErr('HMYRBXBREF');
m_cLastWorkVarErrorMsg='603506633';
l_bResult=false;
w_FILEINVIO=HtW('','C');
} else if ( ! (_ChkObl('CQATNPZMEC',1))) {
_SignErr('CQATNPZMEC');
m_cLastWorkVarErrorMsg='1710843353';
l_bResult=false;
w_DATAINVIO=HtW('','D');
} else if ( ! (_ChkObl('SJMOZNWBVK',1))) {
_SignErr('SJMOZNWBVK');
m_cLastWorkVarErrorMsg='limite';
l_bResult=false;
w_limite=HtW('','N');
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
l_oWv.setValue('dadata',WtA(w_dadata,'D'));
l_oWv.setValue('a_data',WtA(w_a_data,'D'));
l_oWv.setValue('gIntemediario',WtA(w_gIntemediario,'C'));
l_oWv.setValue('CFINVIO',WtA(w_CFINVIO,'C'));
l_oWv.setValue('CAFINVIO',WtA(w_CAFINVIO,'C'));
l_oWv.setValue('FILEINVIO',WtA(w_FILEINVIO,'C'));
l_oWv.setValue('DATAINVIO',WtA(w_DATAINVIO,'D'));
l_oWv.setValue('limite',WtA(w_limite,'N'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["dadata","a_data","gIntemediario","CFINVIO","CAFINVIO","FILEINVIO","DATAINVIO","limite"];
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
w_dadata=CharToDate('20050101');
Link_AHMXEPADOR(null);
if (start && Eq(At(',limite,',pseq),0)) {
w_limite=15000;
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
_Obli('CFINVIO',0,'MPIOZQPPPI',false,"11949617228")
_Obli('a_data',2,'CLVVMIYSQG',false)
_Obli('CAFINVIO',0,'YFPMFPWESC',false,"346962755")
_Obli('FILEINVIO',0,'HMYRBXBREF',false,"603506633")
_Obli('limite',1,'SJMOZNWBVK',false)
_Obli('DATAINVIO',2,'CQATNPZMEC',false,"1710843353")
