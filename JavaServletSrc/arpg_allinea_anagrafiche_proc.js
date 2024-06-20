function SetControlsValue() {
var c;
var c;
if(c=Ctrl('DSUXOLDBJT')) ChkboxCheckUncheck(c,1,w_ccab)
if(c=Ctrl('DSUXOLDBJT')) ChkboxValueAssign(c,1,0,'N',1,0,'')
if(c=Ctrl('OZFJCFFYYF')) ChkboxCheckUncheck(c,1,w_ccodfisc)
if(c=Ctrl('OZFJCFFYYF')) ChkboxValueAssign(c,1,0,'N',1,0,'')
if(c=Ctrl('HZRBYHTPUV')) selectRadio(c,w_rvalcampi,'C')
if(c=Ctrl('RDZTKZKDSZ')) ChkboxCheckUncheck(c,1,w_cutf8)
if(c=Ctrl('RDZTKZKDSZ')) ChkboxValueAssign(c,1,0,'N',1,0,'')
var tmp_FGMOCXNBFY = ToHTag(AsControlValue('<iframe width=\'655\' height=\'170\' id=\'elaborazione\'  name=\'elaborazione\' frameborder=\'1\'  border=\'1\' align=\'TOP\' marginwidth=\'1\' marginheight=\'1\'></iframe>'));
if (Ne(e_FGMOCXNBFY,tmp_FGMOCXNBFY)) {
if(c=Ctrl('FGMOCXNBFY')) c.innerHTML=tmp_FGMOCXNBFY;
e_FGMOCXNBFY=tmp_FGMOCXNBFY;
}
if(c=Ctrl('ZCKVCASZTU')) ChkboxCheckUncheck(c,1,w_cstandard)
if(c=Ctrl('ZCKVCASZTU')) ChkboxValueAssign(c,1,0,'N',10,0,'')
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay(Ctrl('FGMOCXNBFY'),true);
SetDisplay(Ctrl('BOZGWUYDAZ'),Eq(w_lfreport,0));
SetDisplay(Ctrl('ROZQLWLMOH'),Eq(w_bloccaedit,'S'));
SetDisplay(Ctrl('CHAGIFBHVU'),Eq(w_lfreport,0));
HideUI();
}
function DSUXOLDBJT_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_ccab(ChkboxValueAssign(Ctrl('DSUXOLDBJT'),1,0,'N',1,0,''),null,e);
}
function DSUXOLDBJT_OnFocus(e) {
SetActiveField(Ctrl('DSUXOLDBJT'),true);
}
function DSUXOLDBJT_OnBlur(e) {
SetActiveField(Ctrl('DSUXOLDBJT'),false);
}
function OZFJCFFYYF_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_ccodfisc(ChkboxValueAssign(Ctrl('OZFJCFFYYF'),1,0,'N',1,0,''),null,e);
}
function OZFJCFFYYF_OnFocus(e) {
SetActiveField(Ctrl('OZFJCFFYYF'),true);
}
function OZFJCFFYYF_OnBlur(e) {
SetActiveField(Ctrl('OZFJCFFYYF'),false);
}
function HZRBYHTPUV_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_rvalcampi(HtW(getRadioValue(Ctrl('HZRBYHTPUV')),'C'),null,e);
}
function RDZTKZKDSZ_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_cutf8(ChkboxValueAssign(Ctrl('RDZTKZKDSZ'),1,0,'N',1,0,''),null,e);
}
function RDZTKZKDSZ_OnFocus(e) {
SetActiveField(Ctrl('RDZTKZKDSZ'),true);
}
function RDZTKZKDSZ_OnBlur(e) {
SetActiveField(Ctrl('RDZTKZKDSZ'),false);
}
function ZCKVCASZTU_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_cstandard(ChkboxValueAssign(Ctrl('ZCKVCASZTU'),1,0,'N',10,0,''),null,e);
}
function ZCKVCASZTU_OnFocus(e) {
SetActiveField(Ctrl('ZCKVCASZTU'),true);
}
function ZCKVCASZTU_OnBlur(e) {
SetActiveField(Ctrl('ZCKVCASZTU'),false);
}
function href_ROZQLWLMOH() {
if (Eq(w_ccab,1) || Eq(w_ccodfisc,1) || Eq(w_cutf8,1)) {
Elabora()
}
}
function href_CHAGIFBHVU() {
_modifyandopen('arrt_allinea_anagrafiche_report'+'?m_cAction=start&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes,height=300,width=400',null)
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
if(c=Ctrl('DSUXOLDBJT')) c.onclick=DSUXOLDBJT_Valid;
if(c=Ctrl('DSUXOLDBJT')) c.onfocus=DSUXOLDBJT_OnFocus;
if(c=Ctrl('DSUXOLDBJT')) c.onblur=DSUXOLDBJT_OnBlur;
if(c=Ctrl('OZFJCFFYYF')) c.onclick=OZFJCFFYYF_Valid;
if(c=Ctrl('OZFJCFFYYF')) c.onfocus=OZFJCFFYYF_OnFocus;
if(c=Ctrl('OZFJCFFYYF')) c.onblur=OZFJCFFYYF_OnBlur;
c=Ctrl('HZRBYHTPUV');
if ( ! (Empty(c))) {
c[0].onclick=HZRBYHTPUV_Valid;
c[1].onclick=HZRBYHTPUV_Valid;
}
if(c=Ctrl('RDZTKZKDSZ')) c.onclick=RDZTKZKDSZ_Valid;
if(c=Ctrl('RDZTKZKDSZ')) c.onfocus=RDZTKZKDSZ_OnFocus;
if(c=Ctrl('RDZTKZKDSZ')) c.onblur=RDZTKZKDSZ_OnBlur;
if(c=Ctrl('ZCKVCASZTU')) c.onclick=ZCKVCASZTU_Valid;
if(c=Ctrl('ZCKVCASZTU')) c.onfocus=ZCKVCASZTU_OnFocus;
if(c=Ctrl('ZCKVCASZTU')) c.onblur=ZCKVCASZTU_OnBlur;
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
FocusFirstComponent.otherwise={"page_1":["DSUXOLDBJT","OZFJCFFYYF","HZRBYHTPUV","RDZTKZKDSZ","ZCKVCASZTU"]};
function Help() {
windowOpenForeground('../doc/arpg_allinea_anagrafiche_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_ccab=a[0];
w_ccodfisc=a[1];
w_rvalcampi=a[2];
w_cutf8=a[3];
w_cstandard=a[4];
w_lfreport=a[5];
w_bloccaedit=a[6];
o_cutf8=w_cutf8[1];
w_cutf8=w_cutf8[0];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_allinea_anagrafiche',m_cSelectedPage);
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
l_bEnabled= ! (Eq(w_bloccaedit,'N')) || IsDisabledByStateDriver('ccab');
SetDisabled(Ctrl('DSUXOLDBJT'),l_bEnabled);
l_bEnabled= ! (Eq(w_bloccaedit,'N')) || IsDisabledByStateDriver('ccodfisc');
SetDisabled(Ctrl('OZFJCFFYYF'),l_bEnabled);
l_bEnabled= ! ((Eq(w_ccab,1) || Eq(w_ccodfisc,1)) && Eq(w_bloccaedit,'N')) || IsDisabledByStateDriver('rvalcampi');
SetDisabled('HZRBYHTPUV_DIV',l_bEnabled);
l_bEnabled= ! (Eq(w_bloccaedit,'N')) || IsDisabledByStateDriver('cutf8');
SetDisabled(Ctrl('RDZTKZKDSZ'),l_bEnabled);
l_bEnabled= ! (Eq(w_cutf8,1) && Eq(w_bloccaedit,'N')) || IsDisabledByStateDriver('cstandard');
SetDisabled(Ctrl('ZCKVCASZTU'),l_bEnabled);
l_bEnabled= ! (Eq(w_ccab,1) || Eq(w_ccodfisc,1) || Eq(w_cutf8,1));
SetDisabled(Ctrl('ROZQLWLMOH'),l_bEnabled);
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
function Set_ccab(ctrlValue,kmode,e) {
if (Ne(w_ccab,ctrlValue)) {
var ctl = _GetCtl(e,'DSUXOLDBJT');
if (_tracker.goon(ctl,ctrlValue)) {
w_ccab=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('DSUXOLDBJT',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH(0,'N',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_ccodfisc(ctrlValue,kmode,e) {
if (Ne(w_ccodfisc,ctrlValue)) {
var ctl = _GetCtl(e,'OZFJCFFYYF');
if (_tracker.goon(ctl,ctrlValue)) {
w_ccodfisc=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('OZFJCFFYYF',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH(0,'N',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_rvalcampi(ctrlValue,kmode,e) {
if (Ne(w_rvalcampi,ctrlValue)) {
var ctl = _GetCtl(e,'HZRBYHTPUV');
if (_tracker.goon(ctl,ctrlValue)) {
w_rvalcampi=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HZRBYHTPUV',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_cutf8(ctrlValue,kmode,e) {
if (Ne(w_cutf8,ctrlValue)) {
var ctl = _GetCtl(e,'RDZTKZKDSZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_cutf8=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RDZTKZKDSZ',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH(0,'N',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_cstandard(ctrlValue,kmode,e) {
if (Ne(w_cstandard,ctrlValue)) {
var ctl = _GetCtl(e,'ZCKVCASZTU');
if (_tracker.goon(ctl,ctrlValue)) {
w_cstandard=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('ZCKVCASZTU',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH(0,'N',10,0,'');
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
if ((Ne(o_cutf8,w_cutf8))) {
Calculation_BDJZWKNUVT();
}
w_lfreport=arfn_greport();
// * --- Area Manuale = UI - Calculate
// * --- Fine Area Manuale
m_bCalculating=false;
}
function Calculation_BDJZWKNUVT() {
w_cstandard=(Eq(w_cutf8,0)?0:1);
}
function SaveDependsOn() {
o_cutf8=w_cutf8;
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
if ((Eq(w_bloccaedit,'N')) && ( ! (_ChkObl('DSUXOLDBJT',1)))) {
_SignErr('DSUXOLDBJT');
m_cLastWorkVarErrorMsg='ccab';
l_bResult=false;
w_ccab=0;
} else if ((Eq(w_bloccaedit,'N')) && ( ! (_ChkObl('OZFJCFFYYF',1)))) {
_SignErr('OZFJCFFYYF');
m_cLastWorkVarErrorMsg='ccodfisc';
l_bResult=false;
w_ccodfisc=0;
} else if (((Eq(w_ccab,1) || Eq(w_ccodfisc,1)) && Eq(w_bloccaedit,'N')) && ( ! (_ChkObl('HZRBYHTPUV',1)))) {
_SignErr('HZRBYHTPUV');
m_cLastWorkVarErrorMsg='rvalcampi';
l_bResult=false;
w_rvalcampi=HtW('','C');
} else if ((Eq(w_bloccaedit,'N')) && ( ! (_ChkObl('RDZTKZKDSZ',1)))) {
_SignErr('RDZTKZKDSZ');
m_cLastWorkVarErrorMsg='cutf8';
l_bResult=false;
w_cutf8=0;
} else if ((Eq(w_cutf8,1) && Eq(w_bloccaedit,'N')) && ( ! (_ChkObl('ZCKVCASZTU',1)))) {
_SignErr('ZCKVCASZTU');
m_cLastWorkVarErrorMsg='cstandard';
l_bResult=false;
w_cstandard=0;
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
l_oWv.setValue('ccab',WtA(w_ccab,'N'));
l_oWv.setValue('ccodfisc',WtA(w_ccodfisc,'N'));
l_oWv.setValue('rvalcampi',WtA(w_rvalcampi,'C'));
l_oWv.setValue('cutf8',WtA(w_cutf8,'N'));
l_oWv.setValue('cstandard',WtA(w_cstandard,'N'));
l_oWv.setValue('lfreport',WtA(w_lfreport,'N'));
l_oWv.setValue('bloccaedit',WtA(w_bloccaedit,'C'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["ccab","ccodfisc","rvalcampi","cutf8","cstandard","lfreport","bloccaedit"];
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
if (Eq(w_ccab,1) && Ne(opener.w_ccab,null)) {
TransferBetweenWindows(opener,'w_ccab',null,'Set_ccab');
}
if (Eq(w_ccodfisc,1) && Ne(opener.w_ccodfisc,null)) {
TransferBetweenWindows(opener,'w_ccodfisc',null,'Set_ccodfisc');
}
if (Eq(w_rvalcampi,'A') && Ne(opener.w_rvalcampi,null)) {
TransferBetweenWindows(opener,'w_rvalcampi',null,'Set_rvalcampi');
}
if (Eq(w_cutf8,1) && Ne(opener.w_cutf8,null)) {
TransferBetweenWindows(opener,'w_cutf8',null,'Set_cutf8');
}
if (Eq(w_cstandard,1) && Ne(opener.w_cstandard,null)) {
TransferBetweenWindows(opener,'w_cstandard',null,'Set_cstandard');
}
if (Empty(w_lfreport) && Ne(opener.w_lfreport,null)) {
TransferBetweenWindows(opener,'w_lfreport','w_lfreport');
}
}
}
m_bCalculating=true;
if (start && Eq(At(',ccab,',pseq),0)) {
w_ccab=1;
}
if (start && Eq(At(',ccodfisc,',pseq),0)) {
w_ccodfisc=1;
}
if (start && Eq(At(',rvalcampi,',pseq),0)) {
w_rvalcampi='A';
}
if (start && Eq(At(',cutf8,',pseq),0)) {
w_cutf8=1;
}
if (start && Eq(At(',cstandard,',pseq),0)) {
w_cstandard=1;
}
w_lfreport=arfn_greport();
if (start && Eq(At(',bloccaedit,',pseq),0)) {
w_bloccaedit='N';
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
_Obli('ccab',1,'DSUXOLDBJT',false)
_Obli('ccodfisc',1,'OZFJCFFYYF',false)
_Obli('rvalcampi',0,'HZRBYHTPUV',false)
_Obli('cutf8',1,'RDZTKZKDSZ',false)
_Obli('cstandard',1,'ZCKVCASZTU',false)
