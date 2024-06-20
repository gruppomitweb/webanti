function SetControlsValue() {
var c;
var c;
if(c=Ctrl('DPKVLWHCIG')) c.value = WtH(w_dadata,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('MTJDZQTEIR')) c.value = WtH(w_adata,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))
if(c=Ctrl('VOWNJDTEZJ')) c.value = WtH(w_cMTCN,'C',10,0,'')
if(c=Ctrl('MBUVOZITNA')) c.value = WtH(w_cCODFISC,'C',16,0,'')
if(c=Ctrl('FBVBGICYQT')) c.value = WtH(w_cDIP,'C',5,0,'')
var tmp_TQJNOWMVHW = ToHTag(AsControlValue(w_xdesdip));
if (Ne(e_TQJNOWMVHW,tmp_TQJNOWMVHW)) {
if(c=Ctrl('TQJNOWMVHW')) c.innerHTML=tmp_TQJNOWMVHW;
e_TQJNOWMVHW=tmp_TQJNOWMVHW;
}
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
HideUI();
}
HideUI.lblids["adata"]=['BGHAITOPMU'];
HideUI.lblids["cCODFISC"]=['MAKXXLLXNA'];
HideUI.lblids["cDIP"]=['HLQSHVFXVS'];
HideUI.lblids["cMTCN"]=['CXSMATIXZS'];
HideUI.lblids["dadata"]=['HPGJXQIVYG'];
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
return Set_dadata(HtW(Ctrl('DPKVLWHCIG').value,'D'),null,e) && dateisok;
}
function DPKVLWHCIG_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('DPKVLWHCIG'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('DPKVLWHCIG').value=WtH(w_dadata,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
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
return Set_adata(HtW(Ctrl('MTJDZQTEIR').value,'D'),null,e) && dateisok;
}
function MTJDZQTEIR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('MTJDZQTEIR'))) {
DisplayErrorMessage();
}
if (Ne(_tracker.ctrl,Ctrl('MTJDZQTEIR'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('MTJDZQTEIR').value=WtH(w_adata,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
}
m_oEnteredInDate=Ctrl('MTJDZQTEIR');
SetActiveField(Ctrl('MTJDZQTEIR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('MTJDZQTEIR'),e);
}
function href_XURLGQZZMU() {
_modifyandopen('arrt_estrai_fraz'+'?m_cAction=start&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes,height=500,width=700',null)
}
function href_PTXYMSWBZO() {
SetLocationHref(window.location,ToResource('jsp/start_page_logo_portlet.jsp'+'')+'')
}
function VOWNJDTEZJ_Valid(e) {
SetActiveField(Ctrl('VOWNJDTEZJ'),false);
e=(Ne(e,null)?e:window.event);
return Set_cMTCN(HtW(Ctrl('VOWNJDTEZJ').value,'C'),null,e);
}
function VOWNJDTEZJ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('VOWNJDTEZJ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('VOWNJDTEZJ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('VOWNJDTEZJ'),e);
}
function MBUVOZITNA_Valid(e) {
SetActiveField(Ctrl('MBUVOZITNA'),false);
e=(Ne(e,null)?e:window.event);
return Set_cCODFISC(HtW(Ctrl('MBUVOZITNA').value,'C'),null,e);
}
function MBUVOZITNA_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('MBUVOZITNA'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('MBUVOZITNA'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('MBUVOZITNA'),e);
}
function FBVBGICYQT_Valid(e) {
SetActiveField(Ctrl('FBVBGICYQT'),false);
e=(Ne(e,null)?e:window.event);
return Set_cDIP(HtW(Ctrl('FBVBGICYQT').value,'C'),null,e);
}
function FBVBGICYQT_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('FBVBGICYQT'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('FBVBGICYQT'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('FBVBGICYQT'),e);
}
function FBVBGICYQT_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('FBVBGICYQT')),'linkview_FBVBGICYQT','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
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
if(c=Ctrl('VOWNJDTEZJ')) c.onblur=VOWNJDTEZJ_Valid;
if(c=Ctrl('VOWNJDTEZJ')) c.onfocus=VOWNJDTEZJ_OnFocus;
if(c=Ctrl('MBUVOZITNA')) c.onblur=MBUVOZITNA_Valid;
if(c=Ctrl('MBUVOZITNA')) c.onfocus=MBUVOZITNA_OnFocus;
if(c=Ctrl('FBVBGICYQT')) c.onblur=FBVBGICYQT_Valid;
if(c=Ctrl('FBVBGICYQT')) c.onfocus=FBVBGICYQT_OnFocus;
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
FocusFirstComponent.otherwise={"page_1":["DPKVLWHCIG"]};
function Help() {
windowOpenForeground('../doc/arpg_estrai_fraz_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_adata=a[1];
w_cdadata=a[2];
w_c_adata=a[3];
w_cMTCN=a[4];
w_cCODFISC=a[5];
w_cDIP=a[6];
w_xdesdip=a[7];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_estrai_fraz',m_cSelectedPage);
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
function Set_dadata(ctrlValue,kmode,e) {
if (Ne(w_dadata,ctrlValue)) {
var ctl = _GetCtl(e,'DPKVLWHCIG');
if (_tracker.goon(ctl,ctrlValue)) {
w_dadata=ctrlValue;
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
function Set_adata(ctrlValue,kmode,e) {
if (Ne(w_adata,ctrlValue)) {
var ctl = _GetCtl(e,'MTJDZQTEIR');
if (_tracker.goon(ctl,ctrlValue)) {
w_adata=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MTJDZQTEIR',0);
if (l_bResult) {
l_bResult=Ge(w_adata,w_dadata);
if ( ! (l_bResult)) {
m_nLastError=2;
m_cLastWorkVarErrorMsg='adata';
m_cLastMsgError=AlertErrorMessage('10557974447');
}
if ( ! (l_bResult)) {
w_adata=HtW('','D');
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
function Set_cCODFISC(ctrlValue,kmode,e) {
if (Ne(w_cCODFISC,ctrlValue)) {
var ctl = _GetCtl(e,'MBUVOZITNA');
if (_tracker.goon(ctl,ctrlValue)) {
w_cCODFISC=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MBUVOZITNA',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',16,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_cDIP(ctrlValue,kmode,e) {
if (Ne(w_cDIP,ctrlValue)) {
var ctl = _GetCtl(e,'FBVBGICYQT');
if (_tracker.goon(ctl,ctrlValue)) {
w_cDIP=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FBVBGICYQT',0);
if (l_bResult) {
l_bResult=Link_FBVBGICYQT(kmode);
if ( ! (l_bResult)) {
w_cDIP=HtW('','C');
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
function Set_cMTCN(ctrlValue,kmode,e) {
if (Ne(w_cMTCN,ctrlValue)) {
var ctl = _GetCtl(e,'VOWNJDTEZJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_cMTCN=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('VOWNJDTEZJ',0);
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
w_cdadata=DateToChar(w_dadata);
w_c_adata=DateToChar(w_adata);
// * --- Area Manuale = UI - Calculate
// * --- Fine Area Manuale
m_bCalculating=false;
}
function SaveDependsOn() {
}
function SaveLabelDependsOn() {
}
function Link_FBVBGICYQT(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_cDIP);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODDIP',w_cDIP,5,0);
l_Appl.SetFields('CODDIP,DESCRIZ');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('anadip');
l_Appl.SetID('FBVBGICYQT');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_cDIP=l_Appl.GetStringValue('CODDIP',5,0);
w_xdesdip=l_Appl.GetStringValue('DESCRIZ',30,0);
} else {
Link_FBVBGICYQT_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_FBVBGICYQT';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_FBVBGICYQT();
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
function Link_FBVBGICYQT_Blank() {
w_cDIP='';
w_xdesdip='';
}
function LOpt_FBVBGICYQT() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('anadip','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODDIP','C'));
l_oWv.setValue('LinkedField',WtA('CODDIP','C'));
l_oWv.setValue('UID',WtA('FBVBGICYQT','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['FBVBGICYQT'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('1270140318'),'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'FBVBGICYQT')) {
last_focused_comp=GetLastFocusedElementOfLink('FBVBGICYQT');
function SetMethod_FBVBGICYQT() {
Set_cDIP(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_FBVBGICYQT();
} else {
setTimeout(SetMethod_FBVBGICYQT,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'FBVBGICYQT')) {
return [Ctrl('FBVBGICYQT')];
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
m_cLastWorkVarErrorMsg='dadata';
l_bResult=false;
w_dadata=HtW('','D');
} else if (( ! (_ChkObl('MTJDZQTEIR',1))) || ( ! (Ge(w_adata,w_dadata)))) {
_SignErr('MTJDZQTEIR','10557974447');
l_bResult=false;
w_adata=HtW('','D');
} else if ( ! (_ChkObl('VOWNJDTEZJ',1))) {
_SignErr('VOWNJDTEZJ');
m_cLastWorkVarErrorMsg='cMTCN';
l_bResult=false;
w_cMTCN=HtW('','C');
} else if ( ! (_ChkObl('MBUVOZITNA',1))) {
_SignErr('MBUVOZITNA');
m_cLastWorkVarErrorMsg='cCODFISC';
l_bResult=false;
w_cCODFISC=HtW('','C');
} else if ( ! (_ChkObl('FBVBGICYQT',1))) {
_SignErr('FBVBGICYQT');
m_cLastWorkVarErrorMsg='cDIP';
l_bResult=false;
w_cDIP=HtW('','C');
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('FBVBGICYQT_ZOOM',lc)) {
return 0;
}
if (Eq('FBVBGICYQT',lc)) {
return 0;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_FBVBGICYQT();
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
l_oWv.setValue('dadata',WtA(w_dadata,'D'));
l_oWv.setValue('adata',WtA(w_adata,'D'));
l_oWv.setValue('cdadata',WtA(w_cdadata,'C'));
l_oWv.setValue('c_adata',WtA(w_c_adata,'C'));
l_oWv.setValue('cMTCN',WtA(w_cMTCN,'C'));
l_oWv.setValue('cCODFISC',WtA(w_cCODFISC,'C'));
l_oWv.setValue('cDIP',WtA(w_cDIP,'C'));
l_oWv.setValue('xdesdip',WtA(w_xdesdip,'C'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["dadata","adata","cdadata","c_adata","cMTCN","cCODFISC","cDIP","xdesdip"];
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
if (Empty(w_dadata) && Ne(opener.w_dadata,null)) {
TransferBetweenWindows(opener,'w_dadata',null,'Set_dadata');
}
if (Empty(w_adata) && Ne(opener.w_adata,null)) {
TransferBetweenWindows(opener,'w_adata',null,'Set_adata');
}
if (Empty(w_cdadata) && Ne(opener.w_cdadata,null)) {
TransferBetweenWindows(opener,'w_cdadata','w_cdadata');
}
if (Empty(w_c_adata) && Ne(opener.w_c_adata,null)) {
TransferBetweenWindows(opener,'w_c_adata','w_c_adata');
}
}
}
m_bCalculating=true;
w_cdadata=DateToChar(w_dadata);
w_c_adata=DateToChar(w_adata);
Link_FBVBGICYQT(null);
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
_Obli('dadata',2,'DPKVLWHCIG',false)
_Obli('adata',2,'MTJDZQTEIR',false)
_Obli('cCODFISC',0,'MBUVOZITNA',false)
_Obli('cDIP',0,'FBVBGICYQT',false)
_Obli('cMTCN',0,'VOWNJDTEZJ',false)
