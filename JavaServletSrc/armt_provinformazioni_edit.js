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
function DisplayErrorMessage_ardt_provinformazioni() {
if ( ! (ChildToLoad(FrameRef('ardt_provinformazioni'))) && Ne(typeof(FrameRef('ardt_provinformazioni').DisplayErrorMessage),'undefined')) {
FrameRef('ardt_provinformazioni').DisplayErrorMessage();
}
}
function DisplayErrorMessage_ardt_pdelegabo() {
if ( ! (ChildToLoad(FrameRef('ardt_pdelegabo'))) && Ne(typeof(FrameRef('ardt_pdelegabo').DisplayErrorMessage),'undefined')) {
FrameRef('ardt_pdelegabo').DisplayErrorMessage();
}
}
function DisplayErrorMessage_ardt_provsoginfo() {
if ( ! (ChildToLoad(FrameRef('ardt_provsoginfo'))) && Ne(typeof(FrameRef('ardt_provsoginfo').DisplayErrorMessage),'undefined')) {
FrameRef('ardt_provsoginfo').DisplayErrorMessage();
}
}
function DisplayErrorMessage_ardt_xiduciabo() {
if ( ! (ChildToLoad(FrameRef('ardt_xiduciabo'))) && Ne(typeof(FrameRef('ardt_xiduciabo').DisplayErrorMessage),'undefined')) {
FrameRef('ardt_xiduciabo').DisplayErrorMessage();
}
}
function DisplayErrorMessage_ardt_xerzistirap() {
if ( ! (ChildToLoad(FrameRef('ardt_xerzistirap'))) && Ne(typeof(FrameRef('ardt_xerzistirap').DisplayErrorMessage),'undefined')) {
FrameRef('ardt_xerzistirap').DisplayErrorMessage();
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
l_bEnabled= ! ( ! (Utilities.Make(window).IsInGroup(3))) || IsDisabledByStateDriver('CODDIPE');
SetDisabled('XSIPBNXGHK',l_bEnabled);
SetDisabled(Ctrl('XSIPBNXGHK_ZOOM'),l_bEnabled);
l_bEnabled= ! (Eq(At(w_TIPOOPRAP,'|25|28|39|40|41|47'),0) &&  ! (Empty(w_TIPOOPRAP))) || IsDisabledByStateDriver('Informazioni');
if ( ! (ChildToLoad(FrameRef('ardt_provinformazioni'))) && Ne(typeof(FrameRef('ardt_provinformazioni').EnableEntity),'undefined')) {
FrameRef('ardt_provinformazioni').EnableEntity(l_bEnabled);
}
l_bEnabled= ! (Gt(At(w_TIPOOPRAP,'|25|28|39|40|41|47'),0) &&  ! (Empty(w_TIPOOPRAP))) || IsDisabledByStateDriver('Deleghe');
if ( ! (ChildToLoad(FrameRef('ardt_pdelegabo'))) && Ne(typeof(FrameRef('ardt_pdelegabo').EnableEntity),'undefined')) {
FrameRef('ardt_pdelegabo').EnableEntity(l_bEnabled);
}
l_bEnabled= ! (Ne(w_gChkDate,'U') && Ne(w_gChkDate,'B') && Eq(w_gFlgDTP,0)) || IsDisabledByStateDriver('DATAREG');
SetDisabled('SNCWUQDNDY',l_bEnabled);
SetDisabled(Ctrl('SNCWUQDNDY_ZOOM'),l_bEnabled);
if (IsDisabledByStateDriver('Intermediario')) {
DisableInputsInContainer(Ctrl('KTBKPUIVLZ'),true);
}
if (IsDisabledByStateDriver('DATIBASE')) {
DisableInputsInContainer(Ctrl('MMRLCYYISA'),true);
}
if (IsDisabledByStateDriver('INTESTATARI')) {
Z.Tabs.Get("tabs_1_DETTAGLIO").SetDisable('WMBIUHHCFT',true);
}
if (IsDisabledByStateDriver('DELEGATI')) {
Z.Tabs.Get("tabs_1_DETTAGLIO").SetDisable('BJHZWDCHTX',true);
}
if (IsDisabledByStateDriver('ALTRISOGG')) {
Z.Tabs.Get("tabs_2_Altri").SetDisable('ZXKFTKZCJE',true);
}
if (IsDisabledByStateDriver('TITOLARI')) {
Z.Tabs.Get("tabs_2_Altri").SetDisable('EGKLPQESRU',true);
}
if (IsDisabledByStateDriver('FIDUCIANTI')) {
Z.Tabs.Get("tabs_2_Altri").SetDisable('LTJVEGZAIT',true);
}
if (IsDisabledByStateDriver('Intermediario')) {
DisableInputsInContainer(Ctrl('YCTBVNLZSK'),true);
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
if(c=Ctrl('INPSVTNSOS')) c.title=Strtran(AlertErrorMessage('1148775685',w_TIPOOPRAP),'\\n',"\n");
if(c=Ctrl('HSMPABEPMD')) c.title=Strtran(AlertErrorMessage('340709450',w_TIPOLEG),'\\n',"\n");
}
function Set_TIPOLEG(ctrlValue,kmode,e) {
if (Ne(w_TIPOLEG,ctrlValue)) {
var ctl = _GetCtl(e,'HSMPABEPMD');
if (_tracker.goon(ctl,ctrlValue)) {
w_TIPOLEG=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HSMPABEPMD',0);
if (l_bResult) {
l_bResult=Link_HSMPABEPMD(kmode);
if ( ! (l_bResult)) {
w_TIPOLEG=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',1,0,''));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_CONNESOPER(ctrlValue,kmode,e) {
if (Ne(w_CONNESOPER,ctrlValue)) {
var ctl = _GetCtl(e,'RYTLUFEGUP');
if (_tracker.goon(ctl,ctrlValue)) {
w_CONNESOPER=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
var l_bWarn = true;
l_bResult=_ChkObl('RYTLUFEGUP',0);
if (l_bResult) {
l_bResult=Link_RYTLUFEGUP(kmode);
if (l_bResult && ( ! (arfn_chkdatdoc(w_CONNESOPER,w_DATAREG)) && Ne(m_nLastError,-2))) {
try {
_tracker.askwrn=true;
l_bWarn=WindowConfirm(AlertErrorMessage('11525797640'));
} finally {
_tracker.askwrn=false;
}
if ( ! (l_bWarn)) {
Link_RYTLUFEGUP_Blank();
}
}
if ( ! (l_bResult) ||  ! (l_bWarn)) {
w_CONNESOPER=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult) ||  ! (l_bWarn)) {
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
function Set_TIPOOPRAP(ctrlValue,kmode,e) {
if (Ne(w_TIPOOPRAP,ctrlValue)) {
var ctl = _GetCtl(e,'INPSVTNSOS');
if (_tracker.goon(ctl,ctrlValue)) {
w_TIPOOPRAP=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('INPSVTNSOS',0);
if (l_bResult) {
l_bResult=Link_INPSVTNSOS(kmode);
if ( ! (l_bResult)) {
w_TIPOOPRAP=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',2,0,''));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',2,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_DATAREG(ctrlValue,kmode,e) {
if (Ne(w_DATAREG,ctrlValue)) {
var ctl = _GetCtl(e,'SNCWUQDNDY');
if (_tracker.goon(ctl,ctrlValue)) {
w_DATAREG=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
var l_bWarn = true;
l_bResult=_ChkObl('SNCWUQDNDY',0);
if (l_bResult) {
l_bResult=Ge(w_DATAREG,w_DATAOPE);
if ( ! (l_bResult)) {
m_nLastError=2;
m_cLastWorkVarErrorMsg='1028598955';
m_cLastMsgError=AlertErrorMessage('2021191611');
}
if (l_bResult && ( ! (Le(DateDiff(w_DATAOPE,w_DATAREG),30)) && Ne(m_nLastError,-2))) {
try {
_tracker.askwrn=true;
l_bWarn=WindowConfirm(AlertErrorMessage('10082410841'));
} finally {
_tracker.askwrn=false;
}
}
if ( ! (l_bResult) ||  ! (l_bWarn)) {
w_DATAREG=HtW('','D');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult) ||  ! (l_bWarn)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D')));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH(NullDate(),'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
_ResetTracker();
return true;
}
}
return true;
}
function Set_DATAOPE(ctrlValue,kmode,e) {
if (Ne(w_DATAOPE,ctrlValue)) {
var ctl = _GetCtl(e,'OHLAYQXDKA');
if (_tracker.goon(ctl,ctrlValue)) {
w_DATAOPE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
var l_bWarn = true;
l_bResult=_ChkObl('OHLAYQXDKA',0);
if (l_bResult) {
l_bResult=Ge(w_DATAREG,w_DATAOPE);
if ( ! (l_bResult)) {
m_nLastError=2;
m_cLastWorkVarErrorMsg='829201110';
m_cLastMsgError=AlertErrorMessage('2021191611');
}
if (l_bResult && ( ! (Le(DateDiff(w_DATAOPE,w_DATAREG),30)) && Ne(m_nLastError,-2))) {
try {
_tracker.askwrn=true;
l_bWarn=WindowConfirm(AlertErrorMessage('10082410841'));
} finally {
_tracker.askwrn=false;
}
}
if ( ! (l_bResult) ||  ! (l_bWarn)) {
w_DATAOPE=HtW('','D');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult) ||  ! (l_bWarn)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D')));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH(NullDate(),'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
_ResetTracker();
return true;
}
}
return true;
}
function Set_RAPPORTO(ctrlValue,kmode,e) {
if (Ne(w_RAPPORTO,ctrlValue)) {
var ctl = _GetCtl(e,'ROFCOTWPXY');
if (_tracker.goon(ctl,ctrlValue)) {
w_RAPPORTO=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ROFCOTWPXY',0);
if (l_bResult) {
l_bResult=Link_ROFCOTWPXY(kmode);
if ( ! (l_bResult)) {
w_RAPPORTO=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',25,0,'@!'));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',25,0,'@!');
_ResetTracker();
return true;
}
}
return true;
}
function Set_CODDIPE(ctrlValue,kmode,e) {
if (Ne(w_CODDIPE,ctrlValue)) {
var ctl = _GetCtl(e,'XSIPBNXGHK');
if (_tracker.goon(ctl,ctrlValue)) {
w_CODDIPE=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('XSIPBNXGHK',0);
if (l_bResult) {
l_bResult=Link_XSIPBNXGHK(kmode);
if ( ! (l_bResult)) {
w_CODDIPE=HtW('','C');
}
}
l_bResult=l_bResult && _ChkObl('BRGHYFSDHY',0);
if (l_bResult) {
if ( ! (l_bResult)) {
w_CODDIPE=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',6,0,''));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',6,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_FLAGTIT(ctrlValue,kmode,e) {
if (Ne(w_FLAGTIT,ctrlValue)) {
var ctl = _GetCtl(e,'WKYJJJVZEF');
if (_tracker.goon(ctl,ctrlValue)) {
w_FLAGTIT=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('WKYJJJVZEF',0);
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
function Calculate() {
var l_bTmpRes;
var l_bResult = true;
m_bCalculating=true;
w_CDATOPE=DateToChar(w_DATAOPE);
if ((Ne(o_TIPOOPRAP,w_TIPOOPRAP))) {
w_tipregn=Val(LRTrim(w_tipreg));
}
UpdateAutonumber('IDBASE');
w_TIPOINF='1';
UpdateAutonumber('PRGIMPINF');
w_dataoggi=SystemDate();
if ((Ne(o_CODINTER,w_CODINTER)) || (Ne(o_CODDIPE,w_CODDIPE))) {
Calculation_WKUMXNRIRT();
}
w_CDATREG=DateToChar(w_DATAREG);
w_filtro='O';
w_CODINTER=w_gIntemediario;
l_bTmpRes=Link_JVZQIVEGBJ(null);
if ( ! (ChildToLoad(FrameRef('ardt_provinformazioni'))) && Ne(typeof(FrameRef('ardt_provinformazioni').DoUpdate),'undefined')) {
if (Ne(typeof(FrameRef('ardt_provinformazioni').m_oTrs),'undefined')) {
FrameRef('ardt_provinformazioni').EnableEntity(false);
}
CopyWorkVar(FrameRef('ardt_provinformazioni'),['TIPORAP'],['FLAGRAP'],true)
if (Ne(typeof(FrameRef('ardt_provinformazioni').m_oTrs),'undefined')) {
l_bEnabled= ! (Eq(At(w_TIPOOPRAP,'|25|28|39|40|41|47'),0) &&  ! (Empty(w_TIPOOPRAP))) || IsDisabledByStateDriver('Informazioni');
if ( ! (ChildToLoad(FrameRef('ardt_provinformazioni'))) && Ne(typeof(FrameRef('ardt_provinformazioni').EnableEntity),'undefined')) {
FrameRef('ardt_provinformazioni').EnableEntity(l_bEnabled);
}
}
}
if ( ! (ChildToLoad(FrameRef('ardt_pdelegabo'))) && Ne(typeof(FrameRef('ardt_pdelegabo').DoUpdate),'undefined')) {
if (Ne(typeof(FrameRef('ardt_pdelegabo').m_oTrs),'undefined')) {
FrameRef('ardt_pdelegabo').EnableEntity(false);
}
CopyWorkVar(FrameRef('ardt_pdelegabo'),['TIPORAP'],['FLAGRAP'],true)
if (Ne(typeof(FrameRef('ardt_pdelegabo').m_oTrs),'undefined')) {
l_bEnabled= ! (Gt(At(w_TIPOOPRAP,'|25|28|39|40|41|47'),0) &&  ! (Empty(w_TIPOOPRAP))) || IsDisabledByStateDriver('Deleghe');
if ( ! (ChildToLoad(FrameRef('ardt_pdelegabo'))) && Ne(typeof(FrameRef('ardt_pdelegabo').EnableEntity),'undefined')) {
FrameRef('ardt_pdelegabo').EnableEntity(l_bEnabled);
}
}
}
if ((Ne(o_CDATOPE,w_CDATOPE)) || (Ne(o_filtro,w_filtro))) {
RenderDynamicCombo('HSMPABEPMD');
l_bTmpRes=Link_HSMPABEPMD(null);
}
UpdateAutonumber('NUMPROG');
LibJavascript.forEachItem(m_FoundlingCopyWorkVar,i_body_1)
function i_body_1(child){
child();
}
// * --- Area Manuale = UI - Calculate
// * --- armt_provinformazioni
FrameRef('ardt_provinformazioni').Calculate()
FrameRef('ardt_provinformazioni').DoUpdate(true)
FrameRef('ardt_pdelegabo').Calculate()
FrameRef('ardt_pdelegabo').DoUpdate(true)
FrameRef('ardt_provsoginfo').Calculate()
FrameRef('ardt_provsoginfo').DoUpdate(true)
FrameRef('ardt_xiduciabo').Calculate()
FrameRef('ardt_xiduciabo').DoUpdate(true)
FrameRef('ardt_xerzistirap').Calculate()
FrameRef('ardt_xerzistirap').DoUpdate(true)


// * --- Fine Area Manuale
UpdateAutonumber('');
m_bCalculating=false;
}
function Calculation_WKUMXNRIRT() {
w_DESCCIT=(Empty(w_CODDIPE)?w_CITINT:w_CITDIP);
w_PROVINCIA=(Empty(w_CODDIPE)?w_PROVINT:w_PROVDIP);
w_CODCAB=(Empty(w_CODDIPE)?w_CABINT:w_CABDIP);
}
function SaveDependsOn() {
o_CDATOPE=w_CDATOPE;
o_FLAGRAP=w_FLAGRAP;
o_filtro=w_filtro;
o_CODINTER=w_CODINTER;
o_CODDIPE=w_CODDIPE;
o_DATAOPE=w_DATAOPE;
o_TIPOOPRAP=w_TIPOOPRAP;
}
function SaveLabelDependsOn() {
}
function Link_JVZQIVEGBJ(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CODINTER);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODINTER',w_CODINTER,11,0);
l_Appl.SetFields('CODINTER,DATANASC,CODCAB,PROVINCIA,DESCCIT,TIPINTER');
l_Appl.SetTypes('C,D,C,C,C,C');
l_Appl.LinkTable('intermbo');
l_Appl.SetLinkzoom('armt_intermbo');
l_Appl.SetID('JVZQIVEGBJ');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?0:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CODINTER=l_Appl.GetStringValue('CODINTER',11,0);
w_datpaseuro=l_Appl.GetDateValue('DATANASC',8,0);
w_datpaseuro=DateFromApplet(w_datpaseuro);
w_CABINT=l_Appl.GetStringValue('CODCAB',6,0);
w_PROVINT=l_Appl.GetStringValue('PROVINCIA',2,0);
w_CITINT=l_Appl.GetStringValue('DESCCIT',30,0);
w_TIPOINTER=l_Appl.GetStringValue('TIPINTER',2,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_JVZQIVEGBJ_Blank();
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
function Link_JVZQIVEGBJ_Blank() {
w_CODINTER='';
w_datpaseuro=NullDate();
w_CABINT='';
w_PROVINT='';
w_CITINT='';
w_TIPOINTER='';
}
function LOpt_JVZQIVEGBJ() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('intermbo','C'));
l_oWv.setValue('Linkzoomprg',WtA('armt_intermbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODINTER','C'));
l_oWv.setValue('LinkedField',WtA('CODINTER','C'));
l_oWv.setValue('UID',WtA('JVZQIVEGBJ','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['JVZQIVEGBJ'][1],'C'));
return l_oWv;
}
function Link_XSIPBNXGHK(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CODDIPE);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODDIP',w_CODDIPE,6,0);
l_Appl.SetFields('CODDIP,DESCRIZ,DESCCIT,PROVINCIA,CAB');
l_Appl.SetTypes('C,C,C,C,C');
l_Appl.LinkTable('anadip');
l_Appl.SetID('XSIPBNXGHK');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CODDIPE=l_Appl.GetStringValue('CODDIP',6,0);
w_xDescDipe=l_Appl.GetStringValue('DESCRIZ',30,0);
w_CITDIP=l_Appl.GetStringValue('DESCCIT',30,0);
w_PROVDIP=l_Appl.GetStringValue('PROVINCIA',2,0);
w_CABDIP=l_Appl.GetStringValue('CAB',6,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_XSIPBNXGHK_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_XSIPBNXGHK';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_XSIPBNXGHK();
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
function Link_XSIPBNXGHK_Blank() {
w_CODDIPE='';
w_xDescDipe='';
w_CITDIP='';
w_PROVDIP='';
w_CABDIP='';
}
function LOpt_XSIPBNXGHK() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('anadip','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODDIP','C'));
l_oWv.setValue('LinkedField',WtA('CODDIP','C'));
l_oWv.setValue('UID',WtA('XSIPBNXGHK','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['XSIPBNXGHK'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('1270140318'),'C'));
return l_oWv;
}
function Link_ROFCOTWPXY(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_RAPPORTO);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('RAPPORTO',w_RAPPORTO,25,0);
l_Appl.SetFields('RAPPORTO,DESCRAP,TIPORAP');
l_Appl.SetTypes('C,C,C');
l_Appl.LinkTable('knarapbo');
l_Appl.SetID('ROFCOTWPXY');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_RAPPORTO=l_Appl.GetStringValue('RAPPORTO',25,0);
w_xdescrap=l_Appl.GetStringValue('DESCRAP',50,0);
w_FLAGRAP=l_Appl.GetStringValue('TIPORAP',1,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_ROFCOTWPXY_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_ROFCOTWPXY';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_ROFCOTWPXY();
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
function Link_ROFCOTWPXY_Blank() {
w_RAPPORTO='';
w_xdescrap='';
w_FLAGRAP='';
}
function LOpt_ROFCOTWPXY() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('knarapbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('RAPPORTO','C'));
l_oWv.setValue('LinkedField',WtA('RAPPORTO','C'));
l_oWv.setValue('UID',WtA('ROFCOTWPXY','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['ROFCOTWPXY'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('10701632044'),'C'));
return l_oWv;
}
function Link_INPSVTNSOS(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_TIPOOPRAP);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CODICE',w_TIPOOPRAP,2,0);
l_Appl.SetFields('CODICE,DES1,TIPREG');
l_Appl.SetTypes('C,C,C');
l_Appl.LinkTable('tbtipreg');
l_Appl.SetID('INPSVTNSOS');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_TIPOOPRAP=l_Appl.GetStringValue('CODICE',2,0);
w_xDesReg=l_Appl.GetStringValue('DES1',90,0);
w_tipreg=l_Appl.GetStringValue('TIPREG',1,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_INPSVTNSOS_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_INPSVTNSOS';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_INPSVTNSOS();
l_oWv.setValue('FieldFilter',l_cFieldFilter);
if ( ! (Empty(l_Appl.GetWhereAddedFixedFiltersUnencoded()))) {
if ( ! (Empty(l_cFixedFilter))) {
l_cFixedFilter=l_cFixedFilter+' and ';
}
l_cFixedFilter=l_cFixedFilter+l_Appl.GetWhereAddedFixedFiltersUnencoded();
}
l_oWv.setValue('FixedFilter',l_cFixedFilter);
var initEntityFields = '';
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
function Link_INPSVTNSOS_Blank() {
w_TIPOOPRAP='';
w_xDesReg='';
w_tipreg='';
}
function LOpt_INPSVTNSOS() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbtipreg','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODICE','C'));
l_oWv.setValue('LinkedField',WtA('CODICE','C'));
l_oWv.setValue('UID',WtA('INPSVTNSOS','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['INPSVTNSOS'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('995100987'),'C'));
return l_oWv;
}
function Link_RYTLUFEGUP(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_CONNESOPER);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('CONNES',w_CONNESOPER,16,0);
l_Appl.SetFields('CONNES,RAGSOC');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('personbo');
l_Appl.SetID('RYTLUFEGUP');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_CONNESOPER=l_Appl.GetStringValue('CONNES',16,0);
w_xRagSoc=l_Appl.GetStringValue('RAGSOC',70,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_RYTLUFEGUP_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_RYTLUFEGUP';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_RYTLUFEGUP();
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
if (l_bResult &&  ! (Empty(w_CONNESOPER) && l_bEmp)) {
l_bResult=arfn_chksogg(w_CONNESOPER,'8');
if ( ! (l_bResult)) {
Link_RYTLUFEGUP_Blank();
}
}
if ( ! (l_bResult)) {
m_nLastError=3;
m_cLastWorkVarErrorMsg='';
if (Lt(l_nRec,0)) {
m_cLastMsgError=Translate('MSG_CONNECT_SERVER');
} else {
m_cLastMsgError=AlertErrorMessage('11525797640');
}
}
}
return l_bResult;
}
function Link_RYTLUFEGUP_Blank() {
w_CONNESOPER='';
w_xRagSoc='';
}
function LOpt_RYTLUFEGUP() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('personbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CONNES','C'));
l_oWv.setValue('LinkedField',WtA('CONNES','C'));
l_oWv.setValue('UID',WtA('RYTLUFEGUP','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['RYTLUFEGUP'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('10505367639'),'C'));
return l_oWv;
}
function Link_HSMPABEPMD(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_TIPOLEG);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('TIPLEG',w_TIPOLEG,1,0);
l_Appl.SetFields('TIPLEG');
l_Appl.SetTypes('C');
l_Appl.LinkTable('tbtipleg');
l_Appl.SetLinkzoom('armt_tipileg');
l_Appl.SetID('HSMPABEPMD');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?1:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_TIPOLEG=l_Appl.GetStringValue('TIPLEG',1,0);
l_Appl.GetLinkHash(m_CheckVars);
} else {
Link_HSMPABEPMD_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_HSMPABEPMD';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_HSMPABEPMD();
l_oWv.setValue('FieldFilter',l_cFieldFilter);
if ( ! (Empty(l_Appl.GetWhereAddedFixedFiltersUnencoded()))) {
if ( ! (Empty(l_cFixedFilter))) {
l_cFixedFilter=l_cFixedFilter+' and ';
}
l_cFixedFilter=l_cFixedFilter+l_Appl.GetWhereAddedFixedFiltersUnencoded();
}
l_oWv.setValue('FixedFilter',l_cFixedFilter);
var initEntityFields = '';
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
function Link_HSMPABEPMD_Blank() {
w_TIPOLEG='';
}
function LOpt_HSMPABEPMD() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('tbtipleg','C'));
l_oWv.setValue('Linkzoomprg',WtA('armt_tipileg','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('TIPLEG','C'));
l_oWv.setValue('LinkedField',WtA('TIPLEG','C'));
l_oWv.setValue('UID',WtA('HSMPABEPMD','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['HSMPABEPMD'][1],'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'XSIPBNXGHK')) {
last_focused_comp=GetLastFocusedElementOfLink('XSIPBNXGHK');
function SetMethod_XSIPBNXGHK() {
Set_CODDIPE(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_XSIPBNXGHK();
} else {
setTimeout(SetMethod_XSIPBNXGHK,1);
}
bResult=true;
}
if (Eq(varName,'ROFCOTWPXY')) {
last_focused_comp=GetLastFocusedElementOfLink('ROFCOTWPXY');
function SetMethod_ROFCOTWPXY() {
Set_RAPPORTO(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_ROFCOTWPXY();
} else {
setTimeout(SetMethod_ROFCOTWPXY,1);
}
bResult=true;
}
if (Eq(varName,'INPSVTNSOS')) {
last_focused_comp=GetLastFocusedElementOfLink('INPSVTNSOS');
function SetMethod_INPSVTNSOS() {
Set_TIPOOPRAP(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_INPSVTNSOS();
} else {
setTimeout(SetMethod_INPSVTNSOS,1);
}
bResult=true;
}
if (Eq(varName,'RYTLUFEGUP')) {
last_focused_comp=GetLastFocusedElementOfLink('RYTLUFEGUP');
function SetMethod_RYTLUFEGUP() {
Set_CONNESOPER(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_RYTLUFEGUP();
} else {
setTimeout(SetMethod_RYTLUFEGUP,1);
}
bResult=true;
}
if (Eq(varName,'HSMPABEPMD')) {
last_focused_comp=GetLastFocusedElementOfLink('HSMPABEPMD');
function SetMethod_HSMPABEPMD() {
Set_TIPOLEG(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_HSMPABEPMD();
} else {
setTimeout(SetMethod_HSMPABEPMD,1);
}
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'XSIPBNXGHK')) {
return [Ctrl('XSIPBNXGHK')];
}
if (Eq(varName,'ROFCOTWPXY')) {
return [Ctrl('ROFCOTWPXY')];
}
if (Eq(varName,'INPSVTNSOS')) {
return [Ctrl('INPSVTNSOS')];
}
if (Eq(varName,'RYTLUFEGUP')) {
return [Ctrl('RYTLUFEGUP')];
}
if (Eq(varName,'HSMPABEPMD')) {
return [Ctrl('HSMPABEPMD')];
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
parent.ZtVWeb.raiseEventToEvalParms('armt_provinformazioni_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('armt_provinformazioni_dataNotSent',{'action':formaction});
}
}
}
}
CheckChild.child=[{'prg':"ardt_provinformazioni",'BOScId':function(){ return FrameRef('ardt_provinformazioni')},'repeated':0},{'prg':"ardt_pdelegabo",'BOScId':function(){ return FrameRef('ardt_pdelegabo')},'repeated':0},{'prg':"ardt_provsoginfo",'BOScId':function(){ return FrameRef('ardt_provsoginfo')},'repeated':0},{'prg':"ardt_xiduciabo",'BOScId':function(){ return FrameRef('ardt_xiduciabo')},'repeated':0},{'prg':"ardt_xerzistirap",'BOScId':function(){ return FrameRef('ardt_xerzistirap')},'repeated':0}];
function Check() {
var l_bResult = true;
var l_bChildCheck = true;
ResetErrorVars();
m_nLastError=0;
if (( ! (Utilities.Make(window).IsInGroup(3))) && ( ! (_ChkObl('XSIPBNXGHK',1)))) {
_SignErr('XSIPBNXGHK');
m_cLastWorkVarErrorMsg='2071283709';
l_bResult=false;
w_CODDIPE=HtW('','C');
} else if ( ! (_ChkObl('ROFCOTWPXY',1))) {
_SignErr('ROFCOTWPXY');
m_cLastWorkVarErrorMsg='RAPPORTO';
l_bResult=false;
w_RAPPORTO=HtW('','C');
} else if (( ! (_ChkObl('OHLAYQXDKA',1))) || ( ! (Ge(w_DATAREG,w_DATAOPE)))) {
_SignErr('OHLAYQXDKA','2021191611');
l_bResult=false;
w_DATAOPE=HtW('','D');
} else if ((Ne(w_gChkDate,'U') && Ne(w_gChkDate,'B') && Eq(w_gFlgDTP,0)) && (( ! (_ChkObl('SNCWUQDNDY',1))) || ( ! (Ge(w_DATAREG,w_DATAOPE))))) {
_SignErr('SNCWUQDNDY','2021191611');
l_bResult=false;
w_DATAREG=HtW('','D');
} else if ( ! (_ChkObl('INPSVTNSOS',1))) {
_SignErr('INPSVTNSOS');
m_cLastWorkVarErrorMsg='684190680';
l_bResult=false;
w_TIPOOPRAP=HtW('','C');
} else if (( ! (_ChkObl('RYTLUFEGUP',1))) || ( ! (Empty(w_CONNESOPER)) &&  ! (arfn_chksogg(w_CONNESOPER,'8')))) {
_SignErr('RYTLUFEGUP','11525797640');
l_bResult=false;
w_CONNESOPER=HtW('','C');
} else if ( ! (_ChkObl('HSMPABEPMD',1))) {
_SignErr('HSMPABEPMD');
m_cLastWorkVarErrorMsg='11205021885';
l_bResult=false;
w_TIPOLEG=HtW('','C');
} else if ( ! (_ChkObl('WKYJJJVZEF',1))) {
_SignErr('WKYJJJVZEF');
m_cLastWorkVarErrorMsg='2063970052';
l_bResult=false;
w_FLAGTIT=0;
}
if (l_bResult) {
l_bResult=CheckChild(0);
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('XSIPBNXGHK_ZOOM',lc)) {
return 0;
}
if (Eq('XSIPBNXGHK',lc)) {
return 0;
}
if (Eq('ROFCOTWPXY_ZOOM',lc)) {
return 1;
}
if (Eq('ROFCOTWPXY',lc)) {
return 1;
}
if (Eq('OHLAYQXDKA_ZOOM',lc)) {
return 2;
}
if (Eq('SNCWUQDNDY_ZOOM',lc)) {
return 2;
}
if (Eq('RYTLUFEGUP_ZOOM',lc)) {
return 2;
}
if (Eq('RYTLUFEGUP',lc)) {
return 2;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_XSIPBNXGHK();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,1)) {
l_oWv=LOpt_ROFCOTWPXY();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,2)) {
l_oWv=LOpt_RYTLUFEGUP();
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
l_oWv.setValue('CDATOPE',WtA(w_CDATOPE,'C'));
l_oWv.setValue('DATARETT',WtA(w_DATARETT,'D'));
l_oWv.setValue('IDBASE',WtA(w_IDBASE,'C'));
l_oWv.setValue('op_IDBASE',WtA(op_IDBASE,'C'));
l_oWv.setValue('TIPOINTER',WtA(w_TIPOINTER,'C'));
l_oWv.setValue('TIPOINF',WtA(w_TIPOINF,'C'));
l_oWv.setValue('IDEREG',WtA(w_IDEREG,'C'));
l_oWv.setValue('FLAGRAP',WtA(w_FLAGRAP,'C'));
l_oWv.setValue('OPRAP',WtA(w_OPRAP,'C'));
l_oWv.setValue('STATOREG',WtA(w_STATOREG,'C'));
l_oWv.setValue('OPERAZMOD',WtA(w_OPERAZMOD,'C'));
l_oWv.setValue('OPERATORE',WtA(w_OPERATORE,'C'));
l_oWv.setValue('AUTOM',WtA(w_AUTOM,'C'));
l_oWv.setValue('FLAGRAP2',WtA(w_FLAGRAP2,'C'));
l_oWv.setValue('PRGIMPINF',WtA(w_PRGIMPINF,'N'));
l_oWv.setValue('op_PRGIMPINF',WtA(op_PRGIMPINF,'N'));
l_oWv.setValue('CDATREG',WtA(w_CDATREG,'C'));
l_oWv.setValue('FLAGLIRE',WtA(w_FLAGLIRE,'C'));
l_oWv.setValue('VALUTA',WtA(w_VALUTA,'C'));
l_oWv.setValue('CODINTER',WtA(w_CODINTER,'C'));
l_oWv.setValue('CODDIPE',WtA(w_CODDIPE,'C'));
l_oWv.setValue('DESCCIT',WtA(w_DESCCIT,'C'));
l_oWv.setValue('PROVINCIA',WtA(w_PROVINCIA,'C'));
l_oWv.setValue('CODCAB',WtA(w_CODCAB,'C'));
l_oWv.setValue('RAPPORTO',WtA(w_RAPPORTO,'C'));
l_oWv.setValue('DATAOPE',WtA(w_DATAOPE,'D'));
l_oWv.setValue('DATAREG',WtA(w_DATAREG,'D'));
l_oWv.setValue('TIPOOPRAP',WtA(w_TIPOOPRAP,'C'));
l_oWv.setValue('CONNESOPER',WtA(w_CONNESOPER,'C'));
l_oWv.setValue('TIPOLEG',WtA(w_TIPOLEG,'C'));
l_oWv.setValue('NUMPROG',WtA(w_NUMPROG,'C'));
l_oWv.setValue('op_NUMPROG',WtA(op_NUMPROG,'C'));
l_oWv.setValue('FLAGTIT',WtA(w_FLAGTIT,'N'));
l_oWv.setValue('gChkDate',WtA(w_gChkDate,'C'));
l_oWv.setValue('gDataVaria',WtA(w_gDataVaria,'D'));
l_oWv.setValue('gFlgDTP',WtA(w_gFlgDTP,'N'));
l_oWv.setValue('gCodDip',WtA(w_gCodDip,'C'));
l_oWv.setValue('gIntemediario',WtA(w_gIntemediario,'C'));
l_oWv.setValue('gStatus',WtA(w_gStatus,'C'));
l_oWv.setValue('tipreg',WtA(w_tipreg,'C'));
l_oWv.setValue('tipregn',WtA(w_tipregn,'N'));
l_oWv.setValue('xdescrap',WtA(w_xdescrap,'C'));
l_oWv.setValue('xDescDipe',WtA(w_xDescDipe,'C'));
l_oWv.setValue('datpaseuro',WtA(w_datpaseuro,'D'));
l_oWv.setValue('xDesReg',WtA(w_xDesReg,'C'));
l_oWv.setValue('xRagSoc',WtA(w_xRagSoc,'C'));
l_oWv.setValue('sEdit',WtA(w_sEdit,'N'));
l_oWv.setValue('errmsg',WtA(w_errmsg,'C'));
l_oWv.setValue('test',WtA(w_test,'C'));
l_oWv.setValue('Aggiorna',WtA(w_Aggiorna,'C'));
l_oWv.setValue('lancio',WtA(w_lancio,'N'));
l_oWv.setValue('dataoggi',WtA(w_dataoggi,'D'));
l_oWv.setValue('CITINT',WtA(w_CITINT,'C'));
l_oWv.setValue('CITDIP',WtA(w_CITDIP,'C'));
l_oWv.setValue('PROVDIP',WtA(w_PROVDIP,'C'));
l_oWv.setValue('CABDIP',WtA(w_CABDIP,'C'));
l_oWv.setValue('PROVINT',WtA(w_PROVINT,'C'));
l_oWv.setValue('CABINT',WtA(w_CABINT,'C'));
l_oWv.setValue('filtro',WtA(w_filtro,'C'));
l_oWv.setValue('op_codazi',WtA(op_codazi,'C'));
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
_FillChildren.n=['ardt_provinformazioni','ardt_pdelegabo','ardt_provsoginfo','ardt_xiduciabo','ardt_xerzistirap'];
FillWv.n=["CDATOPE","DATARETT","IDBASE","TIPOINTER","TIPOINF","IDEREG","FLAGRAP","OPRAP","STATOREG","OPERAZMOD","OPERATORE","AUTOM","FLAGRAP2","PRGIMPINF","CDATREG","FLAGLIRE","VALUTA","CODINTER","CODDIPE","DESCCIT","PROVINCIA","CODCAB","RAPPORTO","DATAOPE","DATAREG","TIPOOPRAP","CONNESOPER","TIPOLEG","NUMPROG","FLAGTIT","gChkDate","gDataVaria","gFlgDTP","gCodDip","gIntemediario","gStatus","tipreg","tipregn","xdescrap","xDescDipe","datpaseuro","xDesReg","xRagSoc","sEdit","errmsg","test","Aggiorna","lancio","dataoggi","CITINT","CITDIP","PROVDIP","CABDIP","PROVINT","CABINT","filtro"];
function SetModified() {
m_bUpdated=true;
}
function SetChildVariables_ardt_provinformazioni() {
if ( ! (ChildToLoad(FrameRef('ardt_provinformazioni'))) && Ne(typeof(FrameRef('ardt_provinformazioni').DoUpdate),'undefined')) {
if (Ne(typeof(FrameRef('ardt_provinformazioni').m_oTrs),'undefined')) {
FrameRef('ardt_provinformazioni').EnableEntity(false);
}
CopyWorkVar(FrameRef('ardt_provinformazioni'),['TIPORAP'],['FLAGRAP'],false)
if (Ne(typeof(FrameRef('ardt_provinformazioni').m_oTrs),'undefined')) {
l_bEnabled= ! (Eq(At(w_TIPOOPRAP,'|25|28|39|40|41|47'),0) &&  ! (Empty(w_TIPOOPRAP))) || IsDisabledByStateDriver('Informazioni');
if ( ! (ChildToLoad(FrameRef('ardt_provinformazioni'))) && Ne(typeof(FrameRef('ardt_provinformazioni').EnableEntity),'undefined')) {
FrameRef('ardt_provinformazioni').EnableEntity(l_bEnabled);
}
}
}
}
function CtxLoad_ardt_provinformazioni() {
if (ChildToLoad(FrameRef('ardt_provinformazioni'))) {
return [LoadContext(0,'ZFLICMSKTV'),'ardt_provinformazioni'];
}
}
function SetChildVariables_ardt_pdelegabo() {
if ( ! (ChildToLoad(FrameRef('ardt_pdelegabo'))) && Ne(typeof(FrameRef('ardt_pdelegabo').DoUpdate),'undefined')) {
if (Ne(typeof(FrameRef('ardt_pdelegabo').m_oTrs),'undefined')) {
FrameRef('ardt_pdelegabo').EnableEntity(false);
}
CopyWorkVar(FrameRef('ardt_pdelegabo'),['TIPORAP'],['FLAGRAP'],false)
if (Ne(typeof(FrameRef('ardt_pdelegabo').m_oTrs),'undefined')) {
l_bEnabled= ! (Gt(At(w_TIPOOPRAP,'|25|28|39|40|41|47'),0) &&  ! (Empty(w_TIPOOPRAP))) || IsDisabledByStateDriver('Deleghe');
if ( ! (ChildToLoad(FrameRef('ardt_pdelegabo'))) && Ne(typeof(FrameRef('ardt_pdelegabo').EnableEntity),'undefined')) {
FrameRef('ardt_pdelegabo').EnableEntity(l_bEnabled);
}
}
}
}
function CtxLoad_ardt_pdelegabo() {
if (ChildToLoad(FrameRef('ardt_pdelegabo'))) {
return [LoadContext(0,'RSWMQMMVEI'),'ardt_pdelegabo'];
}
}
function SetChildVariables_ardt_provsoginfo() {
}
function CtxLoad_ardt_provsoginfo() {
if (ChildToLoad(FrameRef('ardt_provsoginfo'))) {
return [LoadContext(0,'DUGPTCZBRI'),'ardt_provsoginfo'];
}
}
function SetChildVariables_ardt_xiduciabo() {
}
function CtxLoad_ardt_xiduciabo() {
if (ChildToLoad(FrameRef('ardt_xiduciabo'))) {
return [LoadContext(0,'WYSOGTWVYA'),'ardt_xiduciabo'];
}
}
function SetChildVariables_ardt_xerzistirap() {
}
function CtxLoad_ardt_xerzistirap() {
if (ChildToLoad(FrameRef('ardt_xerzistirap'))) {
return [LoadContext(0,'NOKYMTFBFL'),'ardt_xerzistirap'];
}
}
