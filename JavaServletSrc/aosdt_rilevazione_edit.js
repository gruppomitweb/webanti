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
function DisplayErrorMessage_aosdt_anom_ril() {
if ( ! (ChildToLoad(FrameRef('aosdt_anom_ril'))) && Ne(typeof(FrameRef('aosdt_anom_ril').DisplayErrorMessage),'undefined')) {
FrameRef('aosdt_anom_ril').DisplayErrorMessage();
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
}
function EnableControlsUnderCondition_WhenReady() {
var l_bEnabled = true;
// * --- Area Manuale = UI - Enable Controls Init
// * --- Fine Area Manuale
if (window.Z && window.Z.Tabs) {
Z.Tabs.Get('tabs').CheckTabStrip();
}
if (IsDisabledByStateDriver('Dati Base Rilevazione')) {
Z.Tabs.Get("tabs_1_Rilevazione").SetDisable('VWBPGQDWQK',true);
}
if (IsDisabledByStateDriver('Indicatori della Rilevazione')) {
Z.Tabs.Get("tabs_1_Rilevazione").SetDisable('GEDEJOLMRB',true);
}
LibJavascript.forEachItem(m_FoundlingEditExpression,i_body_0)
function i_body_0(child){
child();
}
DisableUI();
if (Ne('undefined',typeof(DisableChainedLinks))) {
DisableChainedLinks(Ne(0,m_oTrs.length));
}
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
function SetDefaultFixedStyles() {
}
function Set_CONNES(ctrlValue,kmode,e) {
if (Ne(w_CONNES,ctrlValue)) {
var ctl = _GetCtl(e,'TRQBYTHAVX');
if (_tracker.goon(ctl,ctrlValue)) {
w_CONNES=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('TRQBYTHAVX',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',16,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_DTRIL(ctrlValue,kmode,e) {
if (Ne(w_DTRIL,ctrlValue)) {
var ctl = _GetCtl(e,'SOAYACQNFI');
if (_tracker.goon(ctl,ctrlValue)) {
w_DTRIL=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SOAYACQNFI',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH(NullDate(),'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
_ResetTracker();
return true;
}
}
return true;
}
function Set_PROVENIENZA(ctrlValue,kmode,e) {
if (Ne(w_PROVENIENZA,ctrlValue)) {
var ctl = _GetCtl(e,'AQPVNJGWDF');
if (_tracker.goon(ctl,ctrlValue)) {
w_PROVENIENZA=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('AQPVNJGWDF',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',100,0,'');
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
if ((Ne(o_IDMOD,w_IDMOD))) {
l_bTmpRes=Link_SZHUMIRICR(null);
}
if ( ! (ChildToLoad(FrameRef('aosdt_anom_ril'))) && Ne(typeof(FrameRef('aosdt_anom_ril').DoUpdate),'undefined')) {
CopyWorkVar(FrameRef('aosdt_anom_ril'),['IDMOD','ROWRIL'],['IDMOD','CPROWNUM'],true)
}
LibJavascript.forEachItem(m_FoundlingCopyWorkVar,i_body_1)
function i_body_1(child){
child();
}
// * --- Area Manuale = UI - Calculate
// * --- Fine Area Manuale
m_bCalculating=false;
}
function SaveDependsOn() {
o_IDMOD=w_IDMOD;
o_CPROWNUM=w_CPROWNUM;
}
function SaveLabelDependsOn() {
}
function Sugg_SZHUMIRICR(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_Appl = LinkApplet();
var l_bEmp = Empty(HtW(Ctrl('SZHUMIRICR').value,'C'));
l_Appl.SetStringKey('IDMOD',HtW(Ctrl('SZHUMIRICR').value,'C'),10,0);
l_Appl.SetFields('IDMOD,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('mod_ind_def');
l_Appl.SetLinkzoom('aosmt_mod_ind_def');
l_Appl.SetID('SZHUMIRICR');
l_Appl.SetMode('suggest');
l_Appl.SetRows('10');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
var res = l_Appl.GetJSONData();
SuggesterLib.render_suggest(res,'SZHUMIRICR','SZHUMIRICR',false,'band_1_0','',0);
return l_bResult;
}
SuggesterLib.select_suggest.SZHUMIRICR=["IDMOD",[null,null],function(newval) { return HtW(newval,'C')}];
function Link_SZHUMIRICR(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_IDMOD);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('IDMOD',w_IDMOD,10,0);
l_Appl.SetFields('IDMOD,DESCRI');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('mod_ind_def');
l_Appl.SetLinkzoom('aosmt_mod_ind_def');
l_Appl.SetID('SZHUMIRICR');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_IDMOD=l_Appl.GetStringValue('IDMOD',10,0);
w_DESCRI=l_Appl.GetStringValue('DESCRI',200,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_SZHUMIRICR_Blank();
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
function Link_SZHUMIRICR_Blank() {
w_IDMOD='';
w_DESCRI='';
}
function LOpt_SZHUMIRICR() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('mod_ind_def','C'));
l_oWv.setValue('Linkzoomprg',WtA('aosmt_mod_ind_def','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('IDMOD','C'));
l_oWv.setValue('LinkedField',WtA('IDMOD','C'));
l_oWv.setValue('UID',WtA('SZHUMIRICR','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['SZHUMIRICR'][1],'C'));
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
function l_Checks() {
bResult=bResult && Check() && CheckPwdOTP();
}
if (Eq(formaction,'moveto') && m_bUpdated) {
bResult=WindowConfirm(Translate('MSG_LEAVE_MOD'));
}
if (bResult) {
if (Eq(formaction,'moveto') || (Eq(m_cFunction,'edit') &&  ! (m_bUpdated))) {
formaction='discard';
}
if (Eq(formaction,'save')) {
NotifyEvent('Before Save Row');
bResult=bResult && SaveRow(true);
if (bResult) {
NotifyEvent('Before Save');
l_Checks();
}
}
if (bResult) {
Frm.m_cSelectedPage.value=GetSelectedPage(InitWvApplet()).asString();
SubmitForm.SetAction(formaction);
SubmitForm.SetPwdAndOTP();
Frm.m_cAltInterface.value=m_cAltInterface;
Frm.m_cLayerInterface.value=m_cLayerInterface;
FillWv();
Frm.m_cWv.value=WvApplet().asString(1);
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('aosdt_rilevazione_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('aosdt_rilevazione_dataNotSent',{'action':formaction});
}
}
}
}
CheckChild.child=[{'prg':"aosdt_anom_ril",'BOScId':function(){return FrameRef('aosdt_anom_ril')},'repeated':1}];
function Check() {
var l_bResult = true;
var l_bChildCheck = true;
ResetErrorVars();
if (l_bResult) {
l_bResult=CheckChild(0);
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('SOAYACQNFI_ZOOM',lc)) {
return 0;
}
return -1;
}
function link_url(index) {
var l_oWv;
}
function FillWv() {
var l_oWv = InitWvApplet();
l_oWv.setValue('m_CheckVars',JSON.stringify(m_CheckVars));
l_oWv.setValue('IDMOD',WtA(w_IDMOD,'C'));
l_oWv.setValue('DESCRI',WtA(w_DESCRI,'C'));
_FillChildren(l_oWv);
if (m_bExtended) {
ExtendWv(l_oWv);
}
if (Ne(m_cFunction,'view')) {
l_oWv.setValue('m_bUpdated',WtA(m_bUpdated,'L'));
l_oWv.setValue('m_cPrvsStt',WtA(m_cPrvsStt,'C'));
}
l_oWv.setValue('m_bLoaded',WtA(m_bLoaded,'L'));
l_oWv.setValue('m_cOldCPCCCHK',WtA(m_cOldCPCCCHK,'C'));
if (Ne(m_cFunction,'view')) {
l_oWv.setValue('m_bHeaderUpdated',WtA(m_bHeaderUpdated,'L'));
l_oWv.setValue('m_oTrs',TrsApplet().asString());
}
}
_FillChildren.n=[];
FillWv.n=["IDMOD","DESCRI"];
function CheckRow(w) {
var l_bResult = true;
var l_bChildCheck = true;
ResetErrorVars();
if (Le(m_nCurrentRow,Rows())) {
if (( ! (_ChkObl('TRQBYTHAVX',1))) && FullRow()) {
_SignErr('TRQBYTHAVX');
m_cLastWorkVarErrorMsg='1748986534';
l_bResult=false;
w_CONNES=HtW('','C');
} else if (( ! (_ChkObl('SOAYACQNFI',1))) && FullRow()) {
_SignErr('SOAYACQNFI');
m_cLastWorkVarErrorMsg='10173567207';
l_bResult=false;
w_DTRIL=HtW('','D');
} else if (( ! (_ChkObl('AQPVNJGWDF',1))) && FullRow()) {
_SignErr('AQPVNJGWDF');
m_cLastWorkVarErrorMsg='856336882';
l_bResult=false;
w_PROVENIENZA=HtW('','C');
}
}
if (FullRow()) {
if (l_bResult) {
l_bResult=CheckChild(1);
}
}
DisableChainedLinks(true);
// * --- Area Manuale = UI - Check Row
// * --- Fine Area Manuale
return l_bResult;
}
function CheckDeleteRow() {
var l_bResult = true;
var l_bChildCheck = true;
ResetErrorVars();
return l_bResult;
}
function SetModified(bRepeated) {
m_bUpdated=true;
if (bRepeated) {
if (Le(m_nCurrentRow,m_oTrs.length) && Eq(m_nRowStatus,0)) {
m_nRowStatus=1;
}
} else {
m_bHeaderUpdated=true;
}
}
function SetChildVariables_aosdt_anom_ril() {
if ( ! (ChildToLoad(FrameRef('aosdt_anom_ril'))) && Ne(typeof(FrameRef('aosdt_anom_ril').DoUpdate),'undefined')) {
CopyWorkVar(FrameRef('aosdt_anom_ril'),['IDMOD','ROWRIL'],['IDMOD','CPROWNUM'],false)
}
}
function CtxLoad_aosdt_anom_ril() {
if (ChildToLoad(FrameRef('aosdt_anom_ril'))) {
return [LoadContext(1,'IXXAERLMUY'),'aosdt_anom_ril'];
}
}
SaveContext.child=[{'prg':"aosdt_anom_ril",'BOScId':function(){return FrameRef('aosdt_anom_ril')}}];
function BlankRow() {
w_CONNES='';
w_DTRIL=NullDate();
w_PROVENIENZA='';
w_PROVENIENZA='INTERNA';
BlankRowChild();
if (m_bExtended) {
BlankRepeatedExtendedFields();
}
SaveDependsOn();
LoadContext(true);
}
function FullRow() {
return  ! (Empty(w_IDMOD)) ||  ! (Empty(w_CONNES)) ||  ! (Empty(w_DTRIL)) ||  ! (Empty(w_PROVENIENZA));
}
function GetRepeatedFields() {
var l_aRepeatedFields;
l_aRepeatedFields={};
l_aRepeatedFields.CONNES={"dec":0,"fixedpos":false,"id":"TRQBYTHAVX","len":16,"name":"CONNES","title":"Codice di collegamento del soggetto","type":"C"};
l_aRepeatedFields.DTRIL={"dec":0,"fixedpos":false,"id":"SOAYACQNFI","len":8,"name":"DTRIL","title":"Data rilevazione","type":"D"};
l_aRepeatedFields.PROVENIENZA={"dec":0,"fixedpos":false,"id":"AQPVNJGWDF","len":100,"name":"PROVENIENZA","title":"Provenienza del dato","type":"C"};
return l_aRepeatedFields;
}
function SubtractTotals() {
}
function hasDepOnTotals() {
}
function DisableChainedLinks(disable) {
}
