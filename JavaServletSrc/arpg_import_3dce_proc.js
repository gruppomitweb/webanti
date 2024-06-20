function SetControlsValue() {
var c;
var c;
var tmp_FGMOCXNBFY = ToHTag(AsControlValue('<iframe width=\'655\' height=\'170\' id =\'elaborazione\' name=\'elaborazione\' frameborder=\'1\'  border=\'1\' align=\'TOP\' marginwidth=\'1\' marginheight=\'1\'></iframe>'));
if (Ne(e_FGMOCXNBFY,tmp_FGMOCXNBFY)) {
if(c=Ctrl('FGMOCXNBFY')) c.innerHTML=tmp_FGMOCXNBFY;
e_FGMOCXNBFY=tmp_FGMOCXNBFY;
}
if(c=Ctrl('GXYMDOZGOQ')) ChkboxCheckUncheck(c,'S',w_tbareegeog)
if(c=Ctrl('GXYMDOZGOQ')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('GYRPUQOAOP')) ChkboxCheckUncheck(c,'S',w_tbspecie)
if(c=Ctrl('GYRPUQOAOP')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('BPLIWTTKIK')) ChkboxCheckUncheck(c,'S',w_tbtiporisc)
if(c=Ctrl('BPLIWTTKIK')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('DJAYDIHKCT')) ChkboxCheckUncheck(c,'S',w_tbsvolgim)
if(c=Ctrl('DJAYDIHKCT')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('GQLSVVBZAE')) ChkboxCheckUncheck(c,'S',w_tbcondotta)
if(c=Ctrl('GQLSVVBZAE')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('KAUCYBWKCY')) ChkboxCheckUncheck(c,'S',w_tbimporto)
if(c=Ctrl('KAUCYBWKCY')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('QYIGQMSMGL')) ChkboxCheckUncheck(c,'S',w_tbdurata)
if(c=Ctrl('QYIGQMSMGL')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('NXHTINJEZP')) ChkboxCheckUncheck(c,'S',w_tbplauso)
if(c=Ctrl('NXHTINJEZP')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('WDDZKXXVRH')) ChkboxCheckUncheck(c,'S',w_tbtipatt)
if(c=Ctrl('WDDZKXXVRH')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay(Ctrl('FGMOCXNBFY'),true);
SetDisplay(Ctrl('ZNKSIEHSUY'),true);
HideUI();
}
function PIRPTHHLHK_Click() {
Lancio()
}
function GXYMDOZGOQ_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_tbareegeog(ChkboxValueAssign(Ctrl('GXYMDOZGOQ'),'S','N','C',1,0,''),null,e);
}
function GXYMDOZGOQ_OnFocus(e) {
SetActiveField(Ctrl('GXYMDOZGOQ'),true);
}
function GXYMDOZGOQ_OnBlur(e) {
SetActiveField(Ctrl('GXYMDOZGOQ'),false);
}
function GYRPUQOAOP_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_tbspecie(ChkboxValueAssign(Ctrl('GYRPUQOAOP'),'S','N','C',1,0,''),null,e);
}
function GYRPUQOAOP_OnFocus(e) {
SetActiveField(Ctrl('GYRPUQOAOP'),true);
}
function GYRPUQOAOP_OnBlur(e) {
SetActiveField(Ctrl('GYRPUQOAOP'),false);
}
function BPLIWTTKIK_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_tbtiporisc(ChkboxValueAssign(Ctrl('BPLIWTTKIK'),'S','N','C',1,0,''),null,e);
}
function BPLIWTTKIK_OnFocus(e) {
SetActiveField(Ctrl('BPLIWTTKIK'),true);
}
function BPLIWTTKIK_OnBlur(e) {
SetActiveField(Ctrl('BPLIWTTKIK'),false);
}
function DJAYDIHKCT_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_tbsvolgim(ChkboxValueAssign(Ctrl('DJAYDIHKCT'),'S','N','C',1,0,''),null,e);
}
function DJAYDIHKCT_OnFocus(e) {
SetActiveField(Ctrl('DJAYDIHKCT'),true);
}
function DJAYDIHKCT_OnBlur(e) {
SetActiveField(Ctrl('DJAYDIHKCT'),false);
}
function GQLSVVBZAE_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_tbcondotta(ChkboxValueAssign(Ctrl('GQLSVVBZAE'),'S','N','C',1,0,''),null,e);
}
function GQLSVVBZAE_OnFocus(e) {
SetActiveField(Ctrl('GQLSVVBZAE'),true);
}
function GQLSVVBZAE_OnBlur(e) {
SetActiveField(Ctrl('GQLSVVBZAE'),false);
}
function KAUCYBWKCY_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_tbimporto(ChkboxValueAssign(Ctrl('KAUCYBWKCY'),'S','N','C',1,0,''),null,e);
}
function KAUCYBWKCY_OnFocus(e) {
SetActiveField(Ctrl('KAUCYBWKCY'),true);
}
function KAUCYBWKCY_OnBlur(e) {
SetActiveField(Ctrl('KAUCYBWKCY'),false);
}
function QYIGQMSMGL_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_tbdurata(ChkboxValueAssign(Ctrl('QYIGQMSMGL'),'S','N','C',1,0,''),null,e);
}
function QYIGQMSMGL_OnFocus(e) {
SetActiveField(Ctrl('QYIGQMSMGL'),true);
}
function QYIGQMSMGL_OnBlur(e) {
SetActiveField(Ctrl('QYIGQMSMGL'),false);
}
function NXHTINJEZP_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_tbplauso(ChkboxValueAssign(Ctrl('NXHTINJEZP'),'S','N','C',1,0,''),null,e);
}
function NXHTINJEZP_OnFocus(e) {
SetActiveField(Ctrl('NXHTINJEZP'),true);
}
function NXHTINJEZP_OnBlur(e) {
SetActiveField(Ctrl('NXHTINJEZP'),false);
}
function WDDZKXXVRH_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_tbtipatt(ChkboxValueAssign(Ctrl('WDDZKXXVRH'),'S','N','C',1,0,''),null,e);
}
function WDDZKXXVRH_OnFocus(e) {
SetActiveField(Ctrl('WDDZKXXVRH'),true);
}
function WDDZKXXVRH_OnBlur(e) {
SetActiveField(Ctrl('WDDZKXXVRH'),false);
}
function ZNKSIEHSUY_Click() {
SetLocationHref(null,'arrt_import_3dce'+'?m_cAction=start&m_cMode=hyperlink','elaborazione')
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
if(c=Ctrl('GXYMDOZGOQ')) c.onclick=GXYMDOZGOQ_Valid;
if(c=Ctrl('GXYMDOZGOQ')) c.onfocus=GXYMDOZGOQ_OnFocus;
if(c=Ctrl('GXYMDOZGOQ')) c.onblur=GXYMDOZGOQ_OnBlur;
if(c=Ctrl('GYRPUQOAOP')) c.onclick=GYRPUQOAOP_Valid;
if(c=Ctrl('GYRPUQOAOP')) c.onfocus=GYRPUQOAOP_OnFocus;
if(c=Ctrl('GYRPUQOAOP')) c.onblur=GYRPUQOAOP_OnBlur;
if(c=Ctrl('BPLIWTTKIK')) c.onclick=BPLIWTTKIK_Valid;
if(c=Ctrl('BPLIWTTKIK')) c.onfocus=BPLIWTTKIK_OnFocus;
if(c=Ctrl('BPLIWTTKIK')) c.onblur=BPLIWTTKIK_OnBlur;
if(c=Ctrl('DJAYDIHKCT')) c.onclick=DJAYDIHKCT_Valid;
if(c=Ctrl('DJAYDIHKCT')) c.onfocus=DJAYDIHKCT_OnFocus;
if(c=Ctrl('DJAYDIHKCT')) c.onblur=DJAYDIHKCT_OnBlur;
if(c=Ctrl('GQLSVVBZAE')) c.onclick=GQLSVVBZAE_Valid;
if(c=Ctrl('GQLSVVBZAE')) c.onfocus=GQLSVVBZAE_OnFocus;
if(c=Ctrl('GQLSVVBZAE')) c.onblur=GQLSVVBZAE_OnBlur;
if(c=Ctrl('KAUCYBWKCY')) c.onclick=KAUCYBWKCY_Valid;
if(c=Ctrl('KAUCYBWKCY')) c.onfocus=KAUCYBWKCY_OnFocus;
if(c=Ctrl('KAUCYBWKCY')) c.onblur=KAUCYBWKCY_OnBlur;
if(c=Ctrl('QYIGQMSMGL')) c.onclick=QYIGQMSMGL_Valid;
if(c=Ctrl('QYIGQMSMGL')) c.onfocus=QYIGQMSMGL_OnFocus;
if(c=Ctrl('QYIGQMSMGL')) c.onblur=QYIGQMSMGL_OnBlur;
if(c=Ctrl('NXHTINJEZP')) c.onclick=NXHTINJEZP_Valid;
if(c=Ctrl('NXHTINJEZP')) c.onfocus=NXHTINJEZP_OnFocus;
if(c=Ctrl('NXHTINJEZP')) c.onblur=NXHTINJEZP_OnBlur;
if(c=Ctrl('WDDZKXXVRH')) c.onclick=WDDZKXXVRH_Valid;
if(c=Ctrl('WDDZKXXVRH')) c.onfocus=WDDZKXXVRH_OnFocus;
if(c=Ctrl('WDDZKXXVRH')) c.onblur=WDDZKXXVRH_OnBlur;
}
}
function NotifyEvent(p_cEvent) {
var old_c;
if (Ne(typeof(w_pMsg),'undefined')) {
w_pMsg.raiseEvent('arpg_import_3dce_'+Strtran(p_cEvent,' ','_'));
}
if (Ne(typeof(w_pLog),'undefined')) {
w_pLog.raiseEvent('arpg_import_3dce_'+Strtran(p_cEvent,' ','_'));
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
FocusFirstComponent.otherwise={"page_1":["PIRPTHHLHK"]};
function Help() {
windowOpenForeground('../doc/arpg_import_3dce_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_tbareegeog=a[0];
w_tbspecie=a[1];
w_tbtiporisc=a[2];
w_tbsvolgim=a[3];
w_tbcondotta=a[4];
w_tbimporto=a[5];
w_tbdurata=a[6];
w_tbplauso=a[7];
w_tbtipatt=a[8];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_import_3dce',m_cSelectedPage);
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
function Set_tbareegeog(ctrlValue,kmode,e) {
if (Ne(w_tbareegeog,ctrlValue)) {
var ctl = _GetCtl(e,'GXYMDOZGOQ');
if (_tracker.goon(ctl,ctrlValue)) {
w_tbareegeog=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('GXYMDOZGOQ',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_tbspecie(ctrlValue,kmode,e) {
if (Ne(w_tbspecie,ctrlValue)) {
var ctl = _GetCtl(e,'GYRPUQOAOP');
if (_tracker.goon(ctl,ctrlValue)) {
w_tbspecie=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('GYRPUQOAOP',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_tbtiporisc(ctrlValue,kmode,e) {
if (Ne(w_tbtiporisc,ctrlValue)) {
var ctl = _GetCtl(e,'BPLIWTTKIK');
if (_tracker.goon(ctl,ctrlValue)) {
w_tbtiporisc=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BPLIWTTKIK',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_tbsvolgim(ctrlValue,kmode,e) {
if (Ne(w_tbsvolgim,ctrlValue)) {
var ctl = _GetCtl(e,'DJAYDIHKCT');
if (_tracker.goon(ctl,ctrlValue)) {
w_tbsvolgim=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('DJAYDIHKCT',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_tbcondotta(ctrlValue,kmode,e) {
if (Ne(w_tbcondotta,ctrlValue)) {
var ctl = _GetCtl(e,'GQLSVVBZAE');
if (_tracker.goon(ctl,ctrlValue)) {
w_tbcondotta=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('GQLSVVBZAE',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_tbimporto(ctrlValue,kmode,e) {
if (Ne(w_tbimporto,ctrlValue)) {
var ctl = _GetCtl(e,'KAUCYBWKCY');
if (_tracker.goon(ctl,ctrlValue)) {
w_tbimporto=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('KAUCYBWKCY',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_tbdurata(ctrlValue,kmode,e) {
if (Ne(w_tbdurata,ctrlValue)) {
var ctl = _GetCtl(e,'QYIGQMSMGL');
if (_tracker.goon(ctl,ctrlValue)) {
w_tbdurata=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QYIGQMSMGL',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_tbplauso(ctrlValue,kmode,e) {
if (Ne(w_tbplauso,ctrlValue)) {
var ctl = _GetCtl(e,'NXHTINJEZP');
if (_tracker.goon(ctl,ctrlValue)) {
w_tbplauso=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('NXHTINJEZP',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_tbtipatt(ctrlValue,kmode,e) {
if (Ne(w_tbtipatt,ctrlValue)) {
var ctl = _GetCtl(e,'WDDZKXXVRH');
if (_tracker.goon(ctl,ctrlValue)) {
w_tbtipatt=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('WDDZKXXVRH',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
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
if ( ! (_ChkObl('GXYMDOZGOQ',1))) {
_SignErr('GXYMDOZGOQ');
m_cLastWorkVarErrorMsg='tbareegeog';
l_bResult=false;
w_tbareegeog='N';
} else if ( ! (_ChkObl('GYRPUQOAOP',1))) {
_SignErr('GYRPUQOAOP');
m_cLastWorkVarErrorMsg='tbspecie';
l_bResult=false;
w_tbspecie='N';
} else if ( ! (_ChkObl('BPLIWTTKIK',1))) {
_SignErr('BPLIWTTKIK');
m_cLastWorkVarErrorMsg='tbtiporisc';
l_bResult=false;
w_tbtiporisc='N';
} else if ( ! (_ChkObl('DJAYDIHKCT',1))) {
_SignErr('DJAYDIHKCT');
m_cLastWorkVarErrorMsg='tbsvolgim';
l_bResult=false;
w_tbsvolgim='N';
} else if ( ! (_ChkObl('GQLSVVBZAE',1))) {
_SignErr('GQLSVVBZAE');
m_cLastWorkVarErrorMsg='tbcondotta';
l_bResult=false;
w_tbcondotta='N';
} else if ( ! (_ChkObl('KAUCYBWKCY',1))) {
_SignErr('KAUCYBWKCY');
m_cLastWorkVarErrorMsg='tbimporto';
l_bResult=false;
w_tbimporto='N';
} else if ( ! (_ChkObl('QYIGQMSMGL',1))) {
_SignErr('QYIGQMSMGL');
m_cLastWorkVarErrorMsg='tbdurata';
l_bResult=false;
w_tbdurata='N';
} else if ( ! (_ChkObl('NXHTINJEZP',1))) {
_SignErr('NXHTINJEZP');
m_cLastWorkVarErrorMsg='tbplauso';
l_bResult=false;
w_tbplauso='N';
} else if ( ! (_ChkObl('WDDZKXXVRH',1))) {
_SignErr('WDDZKXXVRH');
m_cLastWorkVarErrorMsg='tbtipatt';
l_bResult=false;
w_tbtipatt='N';
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
l_oWv.setValue('tbareegeog',WtA(w_tbareegeog,'C'));
l_oWv.setValue('tbspecie',WtA(w_tbspecie,'C'));
l_oWv.setValue('tbtiporisc',WtA(w_tbtiporisc,'C'));
l_oWv.setValue('tbsvolgim',WtA(w_tbsvolgim,'C'));
l_oWv.setValue('tbcondotta',WtA(w_tbcondotta,'C'));
l_oWv.setValue('tbimporto',WtA(w_tbimporto,'C'));
l_oWv.setValue('tbdurata',WtA(w_tbdurata,'C'));
l_oWv.setValue('tbplauso',WtA(w_tbplauso,'C'));
l_oWv.setValue('tbtipatt',WtA(w_tbtipatt,'C'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["tbareegeog","tbspecie","tbtiporisc","tbsvolgim","tbcondotta","tbimporto","tbdurata","tbplauso","tbtipatt"];
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
if (start && Eq(At(',tbareegeog,',pseq),0)) {
w_tbareegeog='N';
}
if (start && Eq(At(',tbspecie,',pseq),0)) {
w_tbspecie='N';
}
if (start && Eq(At(',tbtiporisc,',pseq),0)) {
w_tbtiporisc='N';
}
if (start && Eq(At(',tbsvolgim,',pseq),0)) {
w_tbsvolgim='N';
}
if (start && Eq(At(',tbcondotta,',pseq),0)) {
w_tbcondotta='N';
}
if (start && Eq(At(',tbimporto,',pseq),0)) {
w_tbimporto='N';
}
if (start && Eq(At(',tbdurata,',pseq),0)) {
w_tbdurata='N';
}
if (start && Eq(At(',tbplauso,',pseq),0)) {
w_tbplauso='N';
}
if (start && Eq(At(',tbtipatt,',pseq),0)) {
w_tbtipatt='N';
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
_Obli('tbareegeog',0,'GXYMDOZGOQ',false)
_Obli('tbspecie',0,'GYRPUQOAOP',false)
_Obli('tbtiporisc',0,'BPLIWTTKIK',false)
_Obli('tbsvolgim',0,'DJAYDIHKCT',false)
_Obli('tbcondotta',0,'GQLSVVBZAE',false)
_Obli('tbimporto',0,'KAUCYBWKCY',false)
_Obli('tbdurata',0,'QYIGQMSMGL',false)
_Obli('tbplauso',0,'NXHTINJEZP',false)
_Obli('tbtipatt',0,'WDDZKXXVRH',false)
