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
function DisplayErrorMessage_ardt_delegaop() {
if ( ! (ChildToLoad(FrameRef('ardt_delegaop'))) && Ne(typeof(FrameRef('ardt_delegaop').DisplayErrorMessage),'undefined')) {
FrameRef('ardt_delegaop').DisplayErrorMessage();
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
l_bEnabled= ! (false) || IsDisabledByStateDriver('INVIATO');
SetDisabled('AIQQNOUGRA',l_bEnabled);
l_bEnabled= ! (false) || IsDisabledByStateDriver('DATAINVIO');
SetDisabled('OKHZSQAMSZ',l_bEnabled);
l_bEnabled= ! (false) || IsDisabledByStateDriver('DATAMODI');
SetDisabled('NMPRSQUWWU',l_bEnabled);
l_bEnabled= ! (false) || IsDisabledByStateDriver('ANNULLA');
SetDisabled('FPJQZIYEKX',l_bEnabled);
l_bEnabled= ! (false) || IsDisabledByStateDriver('DATAANNU');
SetDisabled('ICEJVXXFJJ',l_bEnabled);
l_bEnabled= ! (false) || IsDisabledByStateDriver('INVSALDO');
SetDisabled('ZHVHNJYLBS',l_bEnabled);
l_bEnabled= ! (false) || IsDisabledByStateDriver('DTSALDO');
SetDisabled('EIWTVZVLOO',l_bEnabled);
if (IsDisabledByStateDriver('DatiBase')) {
DisableInputsInContainer(Ctrl('YORQOIOBQN'),true);
}
if (IsDisabledByStateDriver('AltriDel')) {
DisableInputsInContainer(Ctrl('YBDSVYFUDJ'),true);
}
LibJavascript.forEachItem(m_FoundlingEditExpression,i_body_0)
function i_body_0(child){
child();
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
function Set_COLLEG(ctrlValue,kmode,e) {
if (Ne(w_COLLEG,ctrlValue)) {
var ctl = _GetCtl(e,'RVOXKWUSWH');
if (_tracker.goon(ctl,ctrlValue)) {
w_COLLEG=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RVOXKWUSWH',0);
if (l_bResult) {
l_bResult=Link_RVOXKWUSWH(kmode);
if ( ! (l_bResult)) {
w_COLLEG=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',16,0,''));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',16,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_INVIATO(ctrlValue,kmode,e) {
if (Ne(w_INVIATO,ctrlValue)) {
var ctl = _GetCtl(e,'AIQQNOUGRA');
if (_tracker.goon(ctl,ctrlValue)) {
w_INVIATO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('AIQQNOUGRA',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH(0,'N',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_ANNO(ctrlValue,kmode,e) {
if (Ne(w_ANNO,ctrlValue)) {
var ctl = _GetCtl(e,'SZFKAURTJA');
if (_tracker.goon(ctl,ctrlValue)) {
w_ANNO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SZFKAURTJA',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',4,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_CONNESOPER(ctrlValue,kmode,e) {
if (Ne(w_CONNESOPER,ctrlValue)) {
var ctl = _GetCtl(e,'PXVUKDVPLL');
if (_tracker.goon(ctl,ctrlValue)) {
w_CONNESOPER=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('PXVUKDVPLL',0);
if (l_bResult) {
l_bResult=Link_PXVUKDVPLL(kmode);
if ( ! (l_bResult)) {
w_CONNESOPER=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',16,0,''));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',16,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_DATAMODI(ctrlValue,kmode,e) {
if (Ne(w_DATAMODI,ctrlValue)) {
var ctl = _GetCtl(e,'NMPRSQUWWU');
if (_tracker.goon(ctl,ctrlValue)) {
w_DATAMODI=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NMPRSQUWWU',0);
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
function Set_SALDO(ctrlValue,kmode,e) {
if (Ne(w_SALDO,ctrlValue)) {
var ctl = _GetCtl(e,'ENOHXMETFI');
if (_tracker.goon(ctl,ctrlValue)) {
w_SALDO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ENOHXMETFI',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('ENOHXMETFI',function(){return WtH(w_SALDO,'N',17,0,'999,999,999,999')},w_SALDO);
return l_bResult;
} else {
ctl.value=WtH('','N',17,0,'999999999999');
_ResetTracker();
return true;
}
} else {
SPBOUILib.SetInputValue('ENOHXMETFI',function(){return WtH(w_SALDO,'N',17,0,'999,999,999,999')},w_SALDO);
}
return true;
}
function Set_QUANTITA(ctrlValue,kmode,e) {
if (Ne(w_QUANTITA,ctrlValue)) {
var ctl = _GetCtl(e,'APWPUKFDMF');
if (_tracker.goon(ctl,ctrlValue)) {
w_QUANTITA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('APWPUKFDMF',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','N',6,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_VALUTA(ctrlValue,kmode,e) {
if (Ne(w_VALUTA,ctrlValue)) {
var ctl = _GetCtl(e,'BDCVNEPJXV');
if (_tracker.goon(ctl,ctrlValue)) {
w_VALUTA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BDCVNEPJXV',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',3,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_UNIQUER(ctrlValue,kmode,e) {
if (Ne(w_UNIQUER,ctrlValue)) {
var ctl = _GetCtl(e,'KXSLYMBVDR');
if (_tracker.goon(ctl,ctrlValue)) {
w_UNIQUER=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('KXSLYMBVDR',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',50,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_OLDINTER(ctrlValue,kmode,e) {
if (Ne(w_OLDINTER,ctrlValue)) {
var ctl = _GetCtl(e,'IWGAASAAMD');
if (_tracker.goon(ctl,ctrlValue)) {
w_OLDINTER=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('IWGAASAAMD',0);
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
function Set_DATAANNU(ctrlValue,kmode,e) {
if (Ne(w_DATAANNU,ctrlValue)) {
var ctl = _GetCtl(e,'ICEJVXXFJJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_DATAANNU=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ICEJVXXFJJ',0);
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
function Set_DATAINVIO(ctrlValue,kmode,e) {
if (Ne(w_DATAINVIO,ctrlValue)) {
var ctl = _GetCtl(e,'OKHZSQAMSZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_DATAINVIO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('OKHZSQAMSZ',0);
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
function Set_NATURA(ctrlValue,kmode,e) {
if (Ne(w_NATURA,ctrlValue)) {
var ctl = _GetCtl(e,'DQASOJYMWJ');
if (_tracker.goon(ctl,ctrlValue)) {
w_NATURA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('DQASOJYMWJ',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',2,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_ANNULLA(ctrlValue,kmode,e) {
if (Ne(w_ANNULLA,ctrlValue)) {
var ctl = _GetCtl(e,'FPJQZIYEKX');
if (_tracker.goon(ctl,ctrlValue)) {
w_ANNULLA=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('FPJQZIYEKX',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH(0,'N',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_INVSALDO(ctrlValue,kmode,e) {
if (Ne(w_INVSALDO,ctrlValue)) {
var ctl = _GetCtl(e,'ZHVHNJYLBS');
if (_tracker.goon(ctl,ctrlValue)) {
w_INVSALDO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ZHVHNJYLBS',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH(0,'N',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_DATAOPE(ctrlValue,kmode,e) {
if (Ne(w_DATAOPE,ctrlValue)) {
var ctl = _GetCtl(e,'SQOAICWIPS');
if (_tracker.goon(ctl,ctrlValue)) {
w_DATAOPE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('SQOAICWIPS',0);
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
function Set_DTSALDO(ctrlValue,kmode,e) {
if (Ne(w_DTSALDO,ctrlValue)) {
var ctl = _GetCtl(e,'EIWTVZVLOO');
if (_tracker.goon(ctl,ctrlValue)) {
w_DTSALDO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('EIWTVZVLOO',0);
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
function Calculate() {
var l_bTmpRes;
var l_bResult = true;
m_bCalculating=true;
LibJavascript.forEachItem(m_FoundlingCopyWorkVar,i_body_1)
function i_body_1(child){
child();
}
// * --- Area Manuale = UI - Calculate
// * --- Fine Area Manuale
m_bCalculating=false;
}
function SaveDependsOn() {
}
function SaveLabelDependsOn() {
}
function Link_RVOXKWUSWH(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_COLLEG);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CONNES',w_COLLEG,16,0);
l_Appl.SetFields('CONNES,RAGSOC');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('personbo');
l_Appl.SetID('RVOXKWUSWH');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_COLLEG=l_Appl.GetStringValue('CONNES',16,0);
w_xRAGSOC=l_Appl.GetStringValue('RAGSOC',70,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_RVOXKWUSWH_Blank();
l_bResult=true;
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_RVOXKWUSWH';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_RVOXKWUSWH();
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
function Link_RVOXKWUSWH_Blank() {
w_xRAGSOC='';
}
function LOpt_RVOXKWUSWH() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('personbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CONNES','C'));
l_oWv.setValue('LinkedField',WtA('CONNES','C'));
l_oWv.setValue('UID',WtA('RVOXKWUSWH','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['RVOXKWUSWH'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('195812931'),'C'));
return l_oWv;
}
function Link_PXVUKDVPLL(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CONNESOPER);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CONNES',w_CONNESOPER,16,0);
l_Appl.SetFields('CONNES,RAGSOC');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('personbo');
l_Appl.SetID('PXVUKDVPLL');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CONNESOPER=l_Appl.GetStringValue('CONNES',16,0);
w_xRAGSOC2=l_Appl.GetStringValue('RAGSOC',70,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_PXVUKDVPLL_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_PXVUKDVPLL';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_PXVUKDVPLL();
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
function Link_PXVUKDVPLL_Blank() {
w_CONNESOPER='';
w_xRAGSOC2='';
}
function LOpt_PXVUKDVPLL() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('personbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CONNES','C'));
l_oWv.setValue('LinkedField',WtA('CONNES','C'));
l_oWv.setValue('UID',WtA('PXVUKDVPLL','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['PXVUKDVPLL'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('195812931'),'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'RVOXKWUSWH')) {
last_focused_comp=GetLastFocusedElementOfLink('RVOXKWUSWH');
function SetMethod_RVOXKWUSWH() {
Set_COLLEG(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_RVOXKWUSWH();
} else {
setTimeout(SetMethod_RVOXKWUSWH,1);
}
bResult=true;
}
if (Eq(varName,'PXVUKDVPLL')) {
last_focused_comp=GetLastFocusedElementOfLink('PXVUKDVPLL');
function SetMethod_PXVUKDVPLL() {
Set_CONNESOPER(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_PXVUKDVPLL();
} else {
setTimeout(SetMethod_PXVUKDVPLL,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'RVOXKWUSWH')) {
return [Ctrl('RVOXKWUSWH')];
}
if (Eq(varName,'PXVUKDVPLL')) {
return [Ctrl('PXVUKDVPLL')];
}
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
NotifyEvent('Before Save');
l_Checks();
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
parent.ZtVWeb.raiseEventToEvalParms('armt_ae_opextrbo_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('armt_ae_opextrbo_dataNotSent',{'action':formaction});
}
}
}
}
CheckChild.child=[{'prg':"ardt_delegaop",'BOScId':function(){ return FrameRef('ardt_delegaop')},'repeated':0}];
function Check() {
var l_bResult = true;
var l_bChildCheck = true;
ResetErrorVars();
m_nLastError=0;
if ( ! (_ChkObl('RVOXKWUSWH',1))) {
_SignErr('RVOXKWUSWH');
m_cLastWorkVarErrorMsg='10565397709';
l_bResult=false;
w_COLLEG=HtW('','C');
} else if ( ! (_ChkObl('SZFKAURTJA',1))) {
_SignErr('SZFKAURTJA');
m_cLastWorkVarErrorMsg='999531942';
l_bResult=false;
w_ANNO=HtW('','C');
} else if ( ! (_ChkObl('PXVUKDVPLL',1))) {
_SignErr('PXVUKDVPLL');
m_cLastWorkVarErrorMsg='1786626708';
l_bResult=false;
w_CONNESOPER=HtW('','C');
} else if ( ! (_ChkObl('ENOHXMETFI',1))) {
_SignErr('ENOHXMETFI');
m_cLastWorkVarErrorMsg='7713379';
l_bResult=false;
w_SALDO=HtW('','N');
} else if ( ! (_ChkObl('APWPUKFDMF',1))) {
_SignErr('APWPUKFDMF');
m_cLastWorkVarErrorMsg='11992988360';
l_bResult=false;
w_QUANTITA=HtW('','N');
} else if ( ! (_ChkObl('BDCVNEPJXV',1))) {
_SignErr('BDCVNEPJXV');
m_cLastWorkVarErrorMsg='1325098957';
l_bResult=false;
w_VALUTA=HtW('','C');
} else if ( ! (_ChkObl('KXSLYMBVDR',1))) {
_SignErr('KXSLYMBVDR');
m_cLastWorkVarErrorMsg='918159306';
l_bResult=false;
w_UNIQUER=HtW('','C');
} else if ( ! (_ChkObl('IWGAASAAMD',1))) {
_SignErr('IWGAASAAMD');
m_cLastWorkVarErrorMsg='11064762721';
l_bResult=false;
w_OLDINTER=HtW('','C');
} else if ((false) && ( ! (_ChkObl('AIQQNOUGRA',1)))) {
_SignErr('AIQQNOUGRA');
m_cLastWorkVarErrorMsg='INVIATO';
l_bResult=false;
w_INVIATO=0;
} else if ((false) && ( ! (_ChkObl('OKHZSQAMSZ',1)))) {
_SignErr('OKHZSQAMSZ');
m_cLastWorkVarErrorMsg='DATAINVIO';
l_bResult=false;
w_DATAINVIO=HtW('','D');
} else if ((false) && ( ! (_ChkObl('NMPRSQUWWU',1)))) {
_SignErr('NMPRSQUWWU');
m_cLastWorkVarErrorMsg='11268897251';
l_bResult=false;
w_DATAMODI=HtW('','D');
} else if ((false) && ( ! (_ChkObl('FPJQZIYEKX',1)))) {
_SignErr('FPJQZIYEKX');
m_cLastWorkVarErrorMsg='ANNULLA';
l_bResult=false;
w_ANNULLA=0;
} else if ((false) && ( ! (_ChkObl('ICEJVXXFJJ',1)))) {
_SignErr('ICEJVXXFJJ');
m_cLastWorkVarErrorMsg='DATAANNU';
l_bResult=false;
w_DATAANNU=HtW('','D');
} else if ((false) && ( ! (_ChkObl('ZHVHNJYLBS',1)))) {
_SignErr('ZHVHNJYLBS');
m_cLastWorkVarErrorMsg='INVSALDO';
l_bResult=false;
w_INVSALDO=0;
} else if ((false) && ( ! (_ChkObl('EIWTVZVLOO',1)))) {
_SignErr('EIWTVZVLOO');
m_cLastWorkVarErrorMsg='DTSALDO';
l_bResult=false;
w_DTSALDO=HtW('','D');
} else if ( ! (_ChkObl('SQOAICWIPS',1))) {
_SignErr('SQOAICWIPS');
m_cLastWorkVarErrorMsg='829201110';
l_bResult=false;
w_DATAOPE=HtW('','D');
} else if ( ! (_ChkObl('DQASOJYMWJ',1))) {
_SignErr('DQASOJYMWJ');
m_cLastWorkVarErrorMsg='12030926209';
l_bResult=false;
w_NATURA=HtW('','C');
}
if (l_bResult) {
l_bResult=CheckChild(0);
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('RVOXKWUSWH_ZOOM',lc)) {
return 0;
}
if (Eq('RVOXKWUSWH',lc)) {
return 0;
}
if (Eq('PXVUKDVPLL_ZOOM',lc)) {
return 1;
}
if (Eq('PXVUKDVPLL',lc)) {
return 1;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_RVOXKWUSWH();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,1)) {
l_oWv=LOpt_PXVUKDVPLL();
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
l_oWv.setValue('m_CheckVars',JSON.stringify(m_CheckVars));
l_oWv.setValue('COLLEG',WtA(w_COLLEG,'C'));
l_oWv.setValue('ANNO',WtA(w_ANNO,'C'));
l_oWv.setValue('CONNESOPER',WtA(w_CONNESOPER,'C'));
l_oWv.setValue('SALDO',WtA(w_SALDO,'N'));
l_oWv.setValue('QUANTITA',WtA(w_QUANTITA,'N'));
l_oWv.setValue('VALUTA',WtA(w_VALUTA,'C'));
l_oWv.setValue('UNIQUER',WtA(w_UNIQUER,'C'));
l_oWv.setValue('OLDINTER',WtA(w_OLDINTER,'C'));
l_oWv.setValue('INVIATO',WtA(w_INVIATO,'N'));
l_oWv.setValue('DATAINVIO',WtA(w_DATAINVIO,'D'));
l_oWv.setValue('DATAMODI',WtA(w_DATAMODI,'D'));
l_oWv.setValue('ANNULLA',WtA(w_ANNULLA,'N'));
l_oWv.setValue('DATAANNU',WtA(w_DATAANNU,'D'));
l_oWv.setValue('IDESITO',WtA(w_IDESITO,'C'));
l_oWv.setValue('INVSALDO',WtA(w_INVSALDO,'N'));
l_oWv.setValue('DTSALDO',WtA(w_DTSALDO,'D'));
l_oWv.setValue('DATAOPE',WtA(w_DATAOPE,'D'));
l_oWv.setValue('CFESTERO',WtA(w_CFESTERO,'C'));
l_oWv.setValue('NATURA',WtA(w_NATURA,'C'));
l_oWv.setValue('xRAGSOC',WtA(w_xRAGSOC,'C'));
l_oWv.setValue('xRAGSOC2',WtA(w_xRAGSOC2,'C'));
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
}
_FillChildren.n=['ardt_delegaop'];
FillWv.n=["COLLEG","ANNO","CONNESOPER","SALDO","QUANTITA","VALUTA","UNIQUER","OLDINTER","INVIATO","DATAINVIO","DATAMODI","ANNULLA","DATAANNU","IDESITO","INVSALDO","DTSALDO","DATAOPE","CFESTERO","NATURA","xRAGSOC","xRAGSOC2"];
function SetModified() {
m_bUpdated=true;
}
function SetChildVariables_ardt_delegaop() {
}
function CtxLoad_ardt_delegaop() {
if (ChildToLoad(FrameRef('ardt_delegaop'))) {
return [LoadContext(0,'EARPHZNBLQ'),'ardt_delegaop'];
}
}
