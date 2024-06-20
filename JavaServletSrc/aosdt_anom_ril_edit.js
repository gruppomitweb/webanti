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
}
function EnableControlsUnderCondition_WhenReady(inherit) {
if (Eq(inherit,null)) {
inherit=true;
}
var l_bEnabled = true;
// * --- Area Manuale = UI - Enable Controls Init
// * --- Fine Area Manuale
if (window.Z && window.Z.Tabs) {
Z.Tabs.Get('tabs').CheckTabStrip();
}
l_bEnabled= ! (false) || Eq(m_cFunction,'edit') || IsDisabledByStateDriver('IDMOD');
SetDisabled('NBMHJRJGQX',l_bEnabled);
l_bEnabled= ! (false) || Eq(m_cFunction,'edit') || IsDisabledByStateDriver('ROWRIL');
SetDisabled('KHBDKLNADV',l_bEnabled);
LibJavascript.forEachItem(m_FoundlingEditExpression,i_body_0)
function i_body_0(child){
child();
}
DisableUI();
if (Ne('undefined',typeof(DisableChainedLinks))) {
DisableChainedLinks(Ne(0,m_oTrs.length));
}
if (inherit && IsWndAccessible(m_oFather) &&  ! (m_oFather.m_bCalculating)) {
m_oFather.EnableControlsUnderCondition();
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
if(c=Ctrl('AOKURBYNFX')) c.title=Strtran(AlertErrorMessage('11005667081',w_DESCRI_IND),'\\n',"\n");
if(c=Ctrl('PSHCVHVAPS')) c.title=Strtran(AlertErrorMessage('389397309',w_DESCRI_SUBIND),'\\n',"\n");
}
function SetDefaultFixedStyles() {
}
function Set_IDMOD(ctrlValue,kmode,e) {
if (Ne(w_IDMOD,ctrlValue)) {
var ctl = _GetCtl(e,'NBMHJRJGQX');
if (_tracker.goon(ctl,ctrlValue)) {
w_IDMOD=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NBMHJRJGQX',0);
if (l_bResult) {
if ( ! (Empty(w_IDIND))) {
Link_PWBPXBGJRH(kmode);
} else if ( ! (Empty(w_IDMOD))) {
Link_NBMHJRJGQX(kmode);
}
if ( ! (Empty(w_IDSUBIND))) {
Link_OSQTGJONIV(kmode);
} else if ( ! (Empty(w_IDMOD))) {
Link_NBMHJRJGQX(kmode);
}
}
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','C',10,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_ROWRIL(ctrlValue,kmode,e) {
if (Ne(w_ROWRIL,ctrlValue)) {
var ctl = _GetCtl(e,'KHBDKLNADV');
if (_tracker.goon(ctl,ctrlValue)) {
w_ROWRIL=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('KHBDKLNADV',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('KHBDKLNADV',function(){return WtH(w_ROWRIL,'N',4,0,'9999')},w_ROWRIL);
return l_bResult;
} else {
ctl.value=WtH('','N',4,0,'9999');
_ResetTracker();
return true;
}
}
return true;
}
function Set_IDSUBIND(ctrlValue,kmode,e) {
if (Ne(w_IDSUBIND,ctrlValue)) {
var ctl = _GetCtl(e,'OSQTGJONIV');
if (_tracker.goon(ctl,ctrlValue)) {
w_IDSUBIND=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('OSQTGJONIV',0);
if (l_bResult) {
l_bResult=Link_OSQTGJONIV(kmode);
if ( ! (l_bResult)) {
w_IDSUBIND=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',10,0,''));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',10,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_IDIND(ctrlValue,kmode,e) {
if (Ne(w_IDIND,ctrlValue)) {
var ctl = _GetCtl(e,'PWBPXBGJRH');
if (_tracker.goon(ctl,ctrlValue)) {
w_IDIND=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('PWBPXBGJRH',0);
if (l_bResult) {
l_bResult=Link_PWBPXBGJRH(kmode);
if ( ! (Empty(w_IDSUBIND))) {
Link_OSQTGJONIV(kmode);
}
if ( ! (l_bResult)) {
w_IDIND=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',10,0,''));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',10,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_NOTA(ctrlValue,kmode,e) {
if (Ne(w_NOTA,ctrlValue)) {
var ctl = _GetCtl(e,'GIWDXVTDUW');
if (_tracker.goon(ctl,ctrlValue)) {
w_NOTA=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('GIWDXVTDUW',0);
DoUpdate(l_bResult);
return l_bResult;
} else {
ctl.value=WtH('','M',10,0,'');
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
function Sugg_NBMHJRJGQX(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_Appl = LinkApplet();
var l_bEmp = Empty(HtW(Ctrl('NBMHJRJGQX').value,'C'));
l_Appl.SetFixedKeyName('IDMOD');
l_Appl.SetStringKey('IDMOD',w_IDMOD,10,0);
l_Appl.AppendFilterValue(false);
l_Appl.SetStringKey('IDIND',HtW(Ctrl('NBMHJRJGQX').value,'C'),10,0);
l_Appl.SetFields('IDIND,PROGIND,DESCRI');
l_Appl.SetTypes('C,C,M');
l_Appl.LinkTable('ind_def');
l_Appl.SetID('PWBPXBGJRH');
l_Appl.SetMode('suggest');
l_Appl.SetRows('10');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?3:kmode));
l_bResult=Ne(l_nRec,0);
var res = l_Appl.GetJSONData();
SuggesterLib.render_suggest(res,'NBMHJRJGQX','NBMHJRJGQX',false,'shadowBand_TOP_OF_PAGE_1','',0);
return l_bResult;
}
SuggesterLib.select_suggest.NBMHJRJGQX=["IDIND",["w_IDMOD", null, null, null],function(newval) { return HtW(newval,'C')}];
function Link_NBMHJRJGQX(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_IDMOD);
var l_Appl = LinkApplet();
l_Appl.SetFixedKeyName('IDMOD');
l_Appl.SetStringKey('IDMOD',w_IDMOD,10,0);
l_Appl.AppendFilterValue(false);
l_Appl.SetStringKey('IDIND','',10,0);
l_Appl.SetFields('IDIND,PROGIND,DESCRI');
l_Appl.SetTypes('C,C,M');
l_Appl.LinkTable('ind_def');
l_Appl.SetID('PWBPXBGJRH');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?3:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_IDIND=l_Appl.GetStringValue('IDIND',10,0);
w_PROGIND=l_Appl.GetStringValue('PROGIND',10,0);
w_DESCRI_IND=l_Appl.GetStringValue('DESCRI',10,0);
w_IDMOD=(Ne('',w_IDIND)?l_Appl.GetStringValue('IDMOD',10,0):w_IDMOD);
l_Appl.GetLinkHash(GetRepeatedCheckVars());
} else {
l_bResult=true;
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_PWBPXBGJRH';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_NBMHJRJGQX();
l_oWv.setValue('FieldFilter',l_cFieldFilter);
if ( ! (Empty(l_Appl.GetWhereAddedFixedFiltersUnencoded()))) {
if ( ! (Empty(l_cFixedFilter))) {
l_cFixedFilter=l_cFixedFilter+' and ';
}
l_cFixedFilter=l_cFixedFilter+l_Appl.GetWhereAddedFixedFiltersUnencoded();
}
l_oWv.setValue('FixedFilter',l_cFixedFilter);
l_oWv.setValue('FillEmptyKey','true');
var initEntityFields = '';
l_cLinkUrl='../servlet/SPVisualZoom'+'?m_cWv='+URLenc(l_oWv.asString());
layerOpenForeground(l_cLinkUrl,openername,'toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes');
m_nLastError=-2;
} else if (Eq(l_nRec,3)) {
w_IDMOD=(Ne('',w_IDIND)?l_Appl.GetStringValue('IDMOD',10,0):w_IDMOD);
} else {
if ( ! (l_bResult)) {
if (m_bAskFixedKeyConfirm &&  ! (WindowConfirm(Translate('MSG_VALUE_NOT_FOUND_CONFIRM')))) {
Link_NBMHJRJGQX_Blank();
}
}
}
return l_bResult;
}
function Link_NBMHJRJGQX_Blank() {
w_IDMOD='';
}
function LOpt_NBMHJRJGQX() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('ind_def','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('IDMOD,IDIND','C'));
l_oWv.setValue('LinkedField',WtA('IDIND','C'));
l_oWv.setValue('UID',WtA('NBMHJRJGQX','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['PWBPXBGJRH'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('10804079764'),'C'));
return l_oWv;
}
function Sugg_PWBPXBGJRH(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_Appl = LinkApplet();
var l_bEmp = Empty(HtW(Ctrl('PWBPXBGJRH').value,'C'));
l_Appl.SetStringKey('IDMOD',w_IDMOD,10,0);
l_Appl.AppendFilterValue(false);
l_Appl.SetStringKey('IDIND',HtW(Ctrl('PWBPXBGJRH').value,'C'),10,0);
l_Appl.SetFields('IDIND,PROGIND,DESCRI');
l_Appl.SetTypes('C,C,M');
l_Appl.LinkTable('ind_def');
l_Appl.SetID('PWBPXBGJRH');
l_Appl.SetMode('suggest');
l_Appl.SetRows('10');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?3:kmode));
l_bResult=Ne(l_nRec,0);
var res = l_Appl.GetJSONData();
SuggesterLib.render_suggest(res,'PWBPXBGJRH','PWBPXBGJRH',true,'GridTable_Band_DIV','GridTable_Band_HEADER',0);
return l_bResult;
}
SuggesterLib.select_suggest.PWBPXBGJRH=["IDIND",[null,null,null],function(newval) { return HtW(newval,'C')}];
function Link_PWBPXBGJRH(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_IDIND);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('IDMOD',w_IDMOD,10,0);
l_Appl.AppendFilterValue(false);
l_Appl.SetStringKey('IDIND',w_IDIND,10,0);
l_Appl.SetFields('IDIND,PROGIND,DESCRI');
l_Appl.SetTypes('C,C,M');
l_Appl.LinkTable('ind_def');
l_Appl.SetID('PWBPXBGJRH');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?3:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_IDIND=l_Appl.GetStringValue('IDIND',10,0);
w_PROGIND=l_Appl.GetStringValue('PROGIND',10,0);
w_DESCRI_IND=l_Appl.GetStringValue('DESCRI',10,0);
l_Appl.GetLinkHash(GetRepeatedCheckVars());
} else {
Link_PWBPXBGJRH_Blank();
l_bResult=true;
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_PWBPXBGJRH';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_PWBPXBGJRH();
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
function Link_PWBPXBGJRH_Blank() {
w_PROGIND='';
w_DESCRI_IND='';
}
function LOpt_PWBPXBGJRH() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('ind_def','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('IDMOD,IDIND','C'));
l_oWv.setValue('LinkedField',WtA('IDIND','C'));
l_oWv.setValue('UID',WtA('PWBPXBGJRH','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['PWBPXBGJRH'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('10804079764'),'C'));
return l_oWv;
}
function Sugg_OSQTGJONIV(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_Appl = LinkApplet();
var l_bEmp = Empty(HtW(Ctrl('OSQTGJONIV').value,'C'));
l_Appl.SetStringKey('IDMOD',w_IDMOD,10,0);
l_Appl.SetStringKey('IDIND',w_IDIND,10,0);
l_Appl.AppendFilterValue(false);
l_Appl.SetStringKey('IDSUBIND',HtW(Ctrl('OSQTGJONIV').value,'C'),10,0);
l_Appl.SetFields('IDSUBIND,PROGSUBIND,DESCRI');
l_Appl.SetTypes('C,C,M');
l_Appl.LinkTable('sub_ind_def');
l_Appl.SetID('OSQTGJONIV');
l_Appl.SetMode('suggest');
l_Appl.SetRows('10');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?3:kmode));
l_bResult=Ne(l_nRec,0);
var res = l_Appl.GetJSONData();
SuggesterLib.render_suggest(res,'OSQTGJONIV','OSQTGJONIV',true,'GridTable_Band_DIV','GridTable_Band_HEADER',0);
return l_bResult;
}
SuggesterLib.select_suggest.OSQTGJONIV=["IDSUBIND",[null,null,null],function(newval) { return HtW(newval,'C')}];
function Link_OSQTGJONIV(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_bEmp = Empty(w_IDSUBIND);
var l_Appl = LinkApplet();
l_Appl.SetStringKey('IDMOD',w_IDMOD,10,0);
l_Appl.SetStringKey('IDIND',w_IDIND,10,0);
l_Appl.AppendFilterValue(false);
l_Appl.SetStringKey('IDSUBIND',w_IDSUBIND,10,0);
l_Appl.SetFields('IDSUBIND,PROGSUBIND,DESCRI');
l_Appl.SetTypes('C,C,M');
l_Appl.LinkTable('sub_ind_def');
l_Appl.SetID('OSQTGJONIV');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?3:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_IDSUBIND=l_Appl.GetStringValue('IDSUBIND',10,0);
w_PROGSUBIND=l_Appl.GetStringValue('PROGSUBIND',10,0);
w_DESCRI_SUBIND=l_Appl.GetStringValue('DESCRI',10,0);
l_Appl.GetLinkHash(GetRepeatedCheckVars());
} else {
Link_OSQTGJONIV_Blank();
l_bResult=true;
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_OSQTGJONIV';
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_OSQTGJONIV();
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
function Link_OSQTGJONIV_Blank() {
w_PROGSUBIND='';
w_DESCRI_SUBIND='';
}
function LOpt_OSQTGJONIV() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('sub_ind_def','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('IDMOD,IDIND,IDSUBIND','C'));
l_oWv.setValue('LinkedField',WtA('IDSUBIND','C'));
l_oWv.setValue('UID',WtA('OSQTGJONIV','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['OSQTGJONIV'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('2007044001'),'C'));
return l_oWv;
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'PWBPXBGJRH')) {
last_focused_comp=GetLastFocusedElementOfLink('PWBPXBGJRH');
function SetMethod_PWBPXBGJRH() {
Set_IDIND(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_PWBPXBGJRH();
} else {
setTimeout(SetMethod_PWBPXBGJRH,1);
}
bResult=true;
}
if (Eq(varName,'OSQTGJONIV')) {
last_focused_comp=GetLastFocusedElementOfLink('OSQTGJONIV');
function SetMethod_OSQTGJONIV() {
Set_IDSUBIND(HtW(value,'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_OSQTGJONIV();
} else {
setTimeout(SetMethod_OSQTGJONIV,1);
}
bResult=true;
}
if (Eq(varName,'NBMHJRJGQX')) {
last_focused_comp=GetLastFocusedElementOfLink('NBMHJRJGQX');
function SetMethod_NBMHJRJGQX() {
w_IDIND=null;
w_IDMOD=HtW(value[0],'C');
Set_IDIND(HtW(value[1],'C'),0);
}
if (IsDeviceMobile()) {
SetMethod_NBMHJRJGQX();
} else {
setTimeout(SetMethod_NBMHJRJGQX,1);
}
m_bHeaderUpdated=true;
bResult=true;
}
return bResult;
}
function GetLastFocusedElementOfLink(varName) {
if (Eq(varName,'PWBPXBGJRH')) {
return [Ctrl('PWBPXBGJRH')];
}
if (Eq(varName,'OSQTGJONIV')) {
return [Ctrl('OSQTGJONIV')];
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
if (IsWndAccessible(m_oFather)) {
if (Eq(m_nChildStatus,2)) {
m_oFather.SendData(formaction,url,data);
} else if (Eq(m_nChildStatus,1)) {
if (Eq(formaction,'save')) {
if ( ! (SaveRow())) {
return;
}
if ( ! (Check())) {
DisplayErrorMessage();
return;
}
if ( ! (m_oFather.SaveContext_aosdt_anom_ril())) {
WindowAlert(Translate('MSG_CANNOT_UPDATE_CALLERVAR'));
return;
}
InnerChildSendData(bResult);
} else if (Eq(formaction,'moveto') && m_bUpdated) {
WindowConfirm(Translate('MSG_LEAVE_MOD'),InnerChildSendData);
} else {
InnerChildSendData(bResult);
}
function InnerChildSendData(bResult) {
if (bResult) {
if (Eq(m_cFunction,'view') || Eq(m_cFunction,'query') || Ne(m_nLastError,1)) {
m_oFather.focus();
WindowClose();
}
if (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')) {
ResetErrorVars();
}
}
}
}
} else {
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
parent.ZtVWeb.raiseEventToEvalParms('aosdt_anom_ril_beforeSubmit',{'action':formaction});
}
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
DisplayErrorMessage();
if (Ne(parent,window) && parent.ZtVWeb) {
parent.ZtVWeb.raiseEventToEvalParms('aosdt_anom_ril_dataNotSent',{'action':formaction});
}
}
}
}
}
CheckChild.child=[];
function Check() {
var l_bResult = true;
ResetErrorVars();
if ((false) && ( ! (_ChkObl('NBMHJRJGQX',1)))) {
_SignErr('NBMHJRJGQX');
m_cLastWorkVarErrorMsg='10024211400';
l_bResult=false;
w_IDMOD=HtW('','C');
} else if ((false) && ( ! (_ChkObl('KHBDKLNADV',1)))) {
_SignErr('KHBDKLNADV');
m_cLastWorkVarErrorMsg='10651989569';
l_bResult=false;
w_ROWRIL=HtW('','N');
}
if (l_bResult) {
l_bResult=CheckChild(0);
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
if (Eq('PWBPXBGJRH_ZOOM',lc)) {
return 0;
}
if (Eq('PWBPXBGJRH',lc)) {
return 0;
}
if (Eq('OSQTGJONIV_ZOOM',lc)) {
return 1;
}
if (Eq('OSQTGJONIV',lc)) {
return 1;
}
return -1;
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_PWBPXBGJRH();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
l_cFixedFilter=l_cFixedFilter+l_cAndOp+_flt_('IDMOD',w_IDMOD,'C',true);
if ( ! (Empty(l_cFixedFilter))) {
l_cAndOp=' and ';
}
l_cFixedFilter=l_cFixedFilter+l_cAndOp+_flt_('NOAPPLIC',false,null,true,'=');
if ( ! (Empty(l_cFixedFilter))) {
l_cAndOp=' and ';
}
l_oWv.setValue('FixedFilter',l_cFixedFilter);
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
if (Eq(index,1)) {
l_oWv=LOpt_OSQTGJONIV();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
l_cFixedFilter=l_cFixedFilter+l_cAndOp+_flt_('IDMOD',w_IDMOD,'C',true);
if ( ! (Empty(l_cFixedFilter))) {
l_cAndOp=' and ';
}
l_cFixedFilter=l_cFixedFilter+l_cAndOp+_flt_('IDIND',w_IDIND,'C',true);
if ( ! (Empty(l_cFixedFilter))) {
l_cAndOp=' and ';
}
l_cFixedFilter=l_cFixedFilter+l_cAndOp+_flt_('NOAPPLIC',false,null,true,'=');
if ( ! (Empty(l_cFixedFilter))) {
l_cAndOp=' and ';
}
l_oWv.setValue('FixedFilter',l_cFixedFilter);
var initEntityFields = '';
return "../servlet/SPVisualZoom"+'?m_cWv='+URLenc(l_oWv.asString());
}
}
function FillWv() {
var l_oWv = InitWvApplet();
l_oWv.setValue('m_CheckVars',JSON.stringify(m_CheckVars));
l_oWv.setValue('IDMOD',WtA(w_IDMOD,'C'));
l_oWv.setValue('ROWRIL',WtA(w_ROWRIL,'N'));
l_oWv.setValue('CONNES',WtA(w_CONNES,'C'));
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
FillWv.n=["IDMOD","ROWRIL","CONNES"];
function CheckRow(w) {
var l_bResult = true;
ResetErrorVars();
if (Le(m_nCurrentRow,Rows())) {
if (( ! (_ChkObl('PWBPXBGJRH',1))) && FullRow()) {
_SignErr('PWBPXBGJRH');
m_cLastWorkVarErrorMsg='1305674908';
l_bResult=false;
w_IDIND=HtW('','C');
} else if (( ! (_ChkObl('OSQTGJONIV',1))) && FullRow()) {
_SignErr('OSQTGJONIV');
m_cLastWorkVarErrorMsg='10783450750';
l_bResult=false;
w_IDSUBIND=HtW('','C');
} else if (( ! (_ChkObl('GIWDXVTDUW',1))) && FullRow()) {
_SignErr('GIWDXVTDUW');
m_cLastWorkVarErrorMsg='10027512133';
l_bResult=false;
w_NOTA=HtW('','M');
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
if (IsWndAccessible(m_oFather)) {
m_oFather.SetModified_aosdt_anom_ril();
}
}
SaveContext.child=[];
function BlankRow() {
w_IDIND='';
w_IDSUBIND='';
w_NOTA='';
w_PROGIND='';
w_DESCRI_IND='';
w_PROGSUBIND='';
w_DESCRI_SUBIND='';
if ( ! (EmptyString(w_IDIND))) {
Link_PWBPXBGJRH(null);
}
if ( ! (EmptyString(w_IDSUBIND))) {
Link_OSQTGJONIV(null);
}
BlankRowChild();
if (m_bExtended) {
BlankRepeatedExtendedFields();
}
SaveDependsOn();
LoadContext(true);
}
function FullRow() {
return  ! (Empty(w_IDIND));
}
function GetRepeatedFields() {
var l_aRepeatedFields;
l_aRepeatedFields={};
l_aRepeatedFields.IDIND={"dec":0,"fixedpos":false,"id":"PWBPXBGJRH","len":10,"name":"IDIND","title":"ID del indicatore","type":"C"};
l_aRepeatedFields.IDSUBIND={"dec":0,"fixedpos":false,"id":"OSQTGJONIV","len":10,"name":"IDSUBIND","title":"ID del subindicatore ","type":"C"};
l_aRepeatedFields.NOTA={"dec":0,"fixedpos":false,"id":"GIWDXVTDUW","len":10,"name":"NOTA","title":"Nota della rilevazione","type":"M"};
l_aRepeatedFields.PROGIND={"dec":0,"fixedpos":false,"id":"GOHQRSLEQN","len":10,"name":"PROGIND","title":"Progressivo indicatore","type":"C"};
l_aRepeatedFields.DESCRI_IND={"dec":0,"fixedpos":false,"id":"AOKURBYNFX","len":10,"name":"DESCRI_IND","title":"Descrizione del indicatore","type":"M"};
l_aRepeatedFields.PROGSUBIND={"dec":0,"fixedpos":false,"id":"NXPQVKMXKS","len":10,"name":"PROGSUBIND","title":"Progressivo subindicatore","type":"C"};
l_aRepeatedFields.DESCRI_SUBIND={"dec":0,"fixedpos":false,"id":"PSHCVHVAPS","len":10,"name":"DESCRI_SUBIND","title":"Descrizione del subindicatore","type":"M"};
return l_aRepeatedFields;
}
function SubtractTotals() {
}
function hasDepOnTotals() {
}
function DisableChainedLinks(disable) {
}
function EnableEntityWhenReady(enable) {
if (enable) {
var c;
if(c=Ctrl('NBMHJRJGQX')) SetDisabled(c,true);
if(c=Ctrl('KHBDKLNADV')) SetDisabled(c,true);
SetQueryRow(Ctrl('GridTable'),false);
} else {
SetEditRow(Ctrl('GridTable'),false);
var c;
if(c=Ctrl('NBMHJRJGQX')) SetDisabled(c,false);
if(c=Ctrl('KHBDKLNADV')) SetDisabled(c,false);
EnableControlsUnderCondition(false);
}
m_bChildDisabled=enable;
}
