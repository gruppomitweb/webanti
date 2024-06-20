function SetControlsValue() {
var c;
var c;
if(c=Ctrl('LPTSLAVIAK')) selectRadio(c,w_iniz,'C')
if(c=Ctrl('IIJGGLODBJ')) selectRadio(c,w_tipostp,'C')
if(c=Ctrl('FSXHJAAZGG')) c.value = WtH(w_dadata,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('CLVVMIYSQG')) c.value = WtH(w_a_data,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
HideUI();
}
HideUI.lblids["a_data"]=['LFJQIXRRKM'];
function LPTSLAVIAK_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_iniz(HtW(getRadioValue(Ctrl('LPTSLAVIAK')),'C'),null,e);
}
function IIJGGLODBJ_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_tipostp(HtW(getRadioValue(Ctrl('IIJGGLODBJ')),'C'),null,e);
}
function FSXHJAAZGG_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('FSXHJAAZGG'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('FSXHJAAZGG').value=ApplyPictureToDate(Ctrl('FSXHJAAZGG').value,TranslatePicture(datePattern),'FSXHJAAZGG');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('FSXHJAAZGG'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('FSXHJAAZGG');
}
}
}
SetActiveField(Ctrl('FSXHJAAZGG'),false);
e=(Ne(e,null)?e:window.event);
return Set_dadata(HtW(Ctrl('FSXHJAAZGG').value,'D'),null,e) && dateisok;
}
function FSXHJAAZGG_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('FSXHJAAZGG'))) {
DisplayErrorMessage();
}
if (Ne(_tracker.ctrl,Ctrl('FSXHJAAZGG'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('FSXHJAAZGG').value=WtH(w_dadata,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
}
m_oEnteredInDate=Ctrl('FSXHJAAZGG');
SetActiveField(Ctrl('FSXHJAAZGG'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('FSXHJAAZGG'),e);
}
function FSXHJAAZGG_ZOOM_Click() {
LaunchCalendar(Ctrl('FSXHJAAZGG'));
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
function CLVVMIYSQG_ZOOM_Click() {
LaunchCalendar(Ctrl('CLVVMIYSQG'));
}
function href_AJXISNWTIP() {
var action = (Eq(Left('centrale'+''+'?',20),'arpg_aelistanomi_do?')?'query':'start');
SetHypPar('m_cAction',AsAppletValue(action));
SetHypPar('m_cMode',AsAppletValue('hyperlink'));
SendData(action,'centrale'+'',HParApplet().asString());
}
function href_TSMPFDCFJF() {
if (Eq(w_iniz,'I') || Eq(w_iniz,'S') || (Eq(w_iniz,'P') &&  ! (Empty(w_dadata)) &&  ! (Empty(w_a_data)))) {
_modifyandopen('arrt_aelistanomi_do'+'?m_cAction=start&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null)
}
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
c=Ctrl('LPTSLAVIAK');
if ( ! (Empty(c))) {
c[0].onclick=LPTSLAVIAK_Valid;
c[1].onclick=LPTSLAVIAK_Valid;
c[2].onclick=LPTSLAVIAK_Valid;
}
c=Ctrl('IIJGGLODBJ');
if ( ! (Empty(c))) {
c[0].onclick=IIJGGLODBJ_Valid;
c[1].onclick=IIJGGLODBJ_Valid;
}
if(c=Ctrl('FSXHJAAZGG')) c.onblur=FSXHJAAZGG_Valid;
if(c=Ctrl('FSXHJAAZGG')) c.onfocus=FSXHJAAZGG_OnFocus;
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
if(c=Ctrl('FSXHJAAZGG')) c.onkeypress=CheckDateChar;
}
if(c=Ctrl('CLVVMIYSQG')) c.onblur=CLVVMIYSQG_Valid;
if(c=Ctrl('CLVVMIYSQG')) c.onfocus=CLVVMIYSQG_OnFocus;
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
if(c=Ctrl('CLVVMIYSQG')) c.onkeypress=CheckDateChar;
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
FocusFirstComponent.otherwise={"page_1":["LPTSLAVIAK"]};
function Help() {
windowOpenForeground('../doc/arpg_aelistanomi_do_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_iniz=a[0];
w_tipostp=a[1];
w_dadata=a[2];
w_a_data=a[3];
w_datpris=a[4];
w_datseci=a[5];
w_datsecf=a[6];
w_datprif=a[7];
o_dadata=w_dadata[1];
w_dadata=w_dadata[0];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_aelistanomi_do',m_cSelectedPage);
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
l_bEnabled= ! (Eq(w_iniz,'P')) || IsDisabledByStateDriver('dadata');
SetDisabled(Ctrl('FSXHJAAZGG'),l_bEnabled);
SetDisabled(Ctrl('FSXHJAAZGG_ZOOM'),l_bEnabled);
l_bEnabled= ! (Eq(w_iniz,'P')) || IsDisabledByStateDriver('a_data');
SetDisabled(Ctrl('CLVVMIYSQG'),l_bEnabled);
SetDisabled(Ctrl('CLVVMIYSQG_ZOOM'),l_bEnabled);
l_bEnabled= ! (Eq(w_iniz,'I') || Eq(w_iniz,'S') || (Eq(w_iniz,'P') &&  ! (Empty(w_dadata)) &&  ! (Empty(w_a_data))));
SetDisabled(Ctrl('TSMPFDCFJF'),l_bEnabled);
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
function Set_iniz(ctrlValue,kmode,e) {
if (Ne(w_iniz,ctrlValue)) {
var ctl = _GetCtl(e,'LPTSLAVIAK');
if (_tracker.goon(ctl,ctrlValue)) {
w_iniz=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('LPTSLAVIAK',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_tipostp(ctrlValue,kmode,e) {
if (Ne(w_tipostp,ctrlValue)) {
var ctl = _GetCtl(e,'IIJGGLODBJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_tipostp=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('IIJGGLODBJ',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_dadata(ctrlValue,kmode,e) {
if (Ne(w_dadata,ctrlValue)) {
var ctl = _GetCtl(e,'FSXHJAAZGG');
if (_tracker.goon(ctl,ctrlValue)) {
w_dadata=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FSXHJAAZGG',0);
if (l_bResult) {
l_bResult=Gt(w_dadata,CharToDate('20070430'));
if ( ! (l_bResult)) {
m_nLastError=2;
m_cLastWorkVarErrorMsg='dadata';
m_cLastMsgError=AlertErrorMessage('1345161769');
}
if ( ! (l_bResult)) {
w_dadata=HtW('','D');
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
l_bResult=Ge(w_a_data,w_dadata);
if ( ! (l_bResult)) {
m_nLastError=2;
m_cLastWorkVarErrorMsg='a_data';
m_cLastMsgError=AlertErrorMessage('799342670');
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
function Calculate() {
var l_bTmpRes;
var l_bResult = true;
m_bCalculating=true;
if ((Ne(o_dadata,w_dadata))) {
w_a_data=arfn_finemese(w_dadata);
}
w_datpris=CharToDate('20071231');
w_datseci=CharToDate('20080101');
w_datsecf=CharToDate('20080630');
w_datprif=CharToDate('20050101');
// * --- Area Manuale = UI - Calculate
// * --- Fine Area Manuale
m_bCalculating=false;
}
function SaveDependsOn() {
o_dadata=w_dadata;
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
if ( ! (_ChkObl('LPTSLAVIAK',1))) {
_SignErr('LPTSLAVIAK');
m_cLastWorkVarErrorMsg='iniz';
l_bResult=false;
w_iniz=HtW('','C');
} else if ( ! (_ChkObl('IIJGGLODBJ',1))) {
_SignErr('IIJGGLODBJ');
m_cLastWorkVarErrorMsg='tipostp';
l_bResult=false;
w_tipostp=HtW('','C');
} else if ((Eq(w_iniz,'P')) && (( ! (_ChkObl('FSXHJAAZGG',1))) || ( ! (Gt(w_dadata,CharToDate('20070430')))))) {
_SignErr('FSXHJAAZGG','1345161769');
l_bResult=false;
w_dadata=HtW('','D');
} else if ((Eq(w_iniz,'P')) && (( ! (_ChkObl('CLVVMIYSQG',1))) || ( ! (Ge(w_a_data,w_dadata))))) {
_SignErr('CLVVMIYSQG','799342670');
l_bResult=false;
w_a_data=HtW('','D');
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('FSXHJAAZGG_ZOOM',lc)) {
return 0;
}
if (Eq('CLVVMIYSQG_ZOOM',lc)) {
return 0;
}
return -1;
}
function link_url(index) {
var l_oWv;
}
function FillWv() {
var l_oWv = InitWvApplet();
l_oWv.setValue('iniz',WtA(w_iniz,'C'));
l_oWv.setValue('tipostp',WtA(w_tipostp,'C'));
l_oWv.setValue('dadata',WtA(w_dadata,'D'));
l_oWv.setValue('a_data',WtA(w_a_data,'D'));
l_oWv.setValue('datpris',WtA(w_datpris,'D'));
l_oWv.setValue('datseci',WtA(w_datseci,'D'));
l_oWv.setValue('datsecf',WtA(w_datsecf,'D'));
l_oWv.setValue('datprif',WtA(w_datprif,'D'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["iniz","tipostp","dadata","a_data","datpris","datseci","datsecf","datprif"];
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
if (start && Eq(At(',iniz,',pseq),0)) {
w_iniz='I';
}
if (start && Eq(At(',tipostp,',pseq),0)) {
w_tipostp='D';
}
w_a_data=arfn_finemese(w_dadata);
w_datpris=CharToDate('20071231');
w_datseci=CharToDate('20080101');
w_datsecf=CharToDate('20080630');
w_datprif=CharToDate('20050101');
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
_Obli('iniz',0,'LPTSLAVIAK',false)
_Obli('tipostp',0,'IIJGGLODBJ',false)
_Obli('dadata',2,'FSXHJAAZGG',false)
_Obli('a_data',2,'CLVVMIYSQG',false)
