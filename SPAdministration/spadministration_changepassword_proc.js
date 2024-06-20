function FillCombosValues() {
}
function SetControlsValue() {
var c;
var tmp_CJRLVMMWSK = ToHTag(AsControlValue((Eq(w_changeReason,'expire')?FormatMsg('ADMIN_PASSWORD_EXPIRED'):FormatMsg('ADMIN_NEW_PASSWORD'))));
if (Ne(e_CJRLVMMWSK,tmp_CJRLVMMWSK)) {
SPBOUILib.SetLabelValue('CJRLVMMWSK','innerHTML',tmp_CJRLVMMWSK);
e_CJRLVMMWSK=tmp_CJRLVMMWSK;
}
SPBOUILib.SetInputValue('QDPGURJWZK',function(){return WtH(w_old_password,'C',20,0,'')},w_old_password);
SPBOUILib.SetInputValue('JRQGKMZTEH',function(){return WtH(w_new_password,'C',20,0,'')},w_new_password);
SPBOUILib.SetInputValue('WLGONTBMKR',function(){return WtH(w_confirm_password,'C',20,0,'')},w_confirm_password);
var tmp_TJIVDOWYFZ = ToHTag(AsControlValue(w_errormessage));
if (Ne(e_TJIVDOWYFZ,tmp_TJIVDOWYFZ)) {
SPBOUILib.SetLabelValue('TJIVDOWYFZ','innerHTML',tmp_TJIVDOWYFZ);
e_TJIVDOWYFZ=tmp_TJIVDOWYFZ;
}
SPBOUILib.SetInputValue('OCVTPTBPNM',function(){return WtH(w_calcomplex,'N',3,0,'')},w_calcomplex);
SPBOUILib.SetInputValue('FGAIBUGBSI',function(){return WtH(w_pwdcomplexity,'N',3,0,'')},w_pwdcomplexity);
SPBOUILib.SetInputValue('MEKWOPJKAZ',function(){return WtH(w_pwddaysduration,'N',4,0,'')},w_pwddaysduration);
SPBOUILib.SetInputValue('BAYVBUTWST',function(){return WtH(w_pwdciclicity,'N',4,0,'')},w_pwdciclicity);
var tmp_JEWFKZZWJU = ToHTag(AsControlValue('/'+UserAdmin.GetPasswordRatingMaxReachable()));
if (Ne(e_JEWFKZZWJU,tmp_JEWFKZZWJU)) {
SPBOUILib.SetLabelValue('JEWFKZZWJU','innerHTML',tmp_JEWFKZZWJU);
e_JEWFKZZWJU=tmp_JEWFKZZWJU;
}
var tmp_VULSHKPYLK = ToHTag(AsControlValue('/'+UserAdmin.GetPasswordRatingMaxReachable()));
if (Ne(e_VULSHKPYLK,tmp_VULSHKPYLK)) {
SPBOUILib.SetLabelValue('VULSHKPYLK','innerHTML',tmp_VULSHKPYLK);
e_VULSHKPYLK=tmp_VULSHKPYLK;
}
SPBOUILib.SetInputValue('HSOEINWVPM',function(){return WtH(w_pwdcaptchalevel_applied,'N',4,0,'')},w_pwdcaptchalevel_applied);
SPBOUILib.SetInputValue('ESFOZDXNLZ',function(){return WtH(w_pwdratecause,'M',10,0,'')},w_pwdratecause);
var tmp_XVYWBPODNF = ToHTag(AsControlValue(FormatMsg('ADMIN_PWD_COMPLEXITY_RATE',(Le(w_calcomplex,15)?FormatMsg('ADMIN_PASSWORD_VERY_WEAK'):(Lt(w_calcomplex,25)?FormatMsg('ADMIN_PASSWORD_WEAK'):(Lt(w_calcomplex,35)?FormatMsg('ADMIN_PASSWORD_MEDIOCRE'):(Lt(w_calcomplex,45)?FormatMsg('ADMIN_PASSWORD_STRONG'):FormatMsg('ADMIN_PASSWORD_STRONGER'))))),LRTrim(Str(w_calcomplex)),LRTrim(Str(w_pwdcomplexity)))));
if (Ne(e_XVYWBPODNF,tmp_XVYWBPODNF)) {
SPBOUILib.SetLabelValue('XVYWBPODNF','childNodes[0].innerHTML',tmp_XVYWBPODNF);
e_XVYWBPODNF=tmp_XVYWBPODNF;
}
SetCollapsibleCaptions();
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function SetCollapsibleCaptions() {
var c;
var l_cComment;
l_cComment=FormatMsg('ADMIN_PASSWORD_VERDICT')+': '+UserAdmin.GetPasswordVerdict(w_new_password);
if (Ne(e_HITFFRVPXU,l_cComment)) {
SetLayerCaption('HITFFRVPXU',l_cComment);
e_HITFFRVPXU=l_cComment;
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay(Ctrl('CJRLVMMWSK'), ! (Empty(w_errormessage)) || Empty(w_changeReason));
SetDisplay(Ctrl('OCVTPTBPNM'),true || IsHiddenByStateDriver('calcomplex'));
SetDisplay(Ctrl('HJGOYAFDPY'),true);
SetDisplay(Ctrl('FGAIBUGBSI'),true || IsHiddenByStateDriver('pwdcomplexity'));
SetDisplay(Ctrl('YSVBRIXOZI'),true);
SetDisplay(Ctrl('MEKWOPJKAZ'),true || IsHiddenByStateDriver('pwddaysduration'));
SetDisplay(Ctrl('ALHQOJUXRU'),true);
SetDisplay(Ctrl('BAYVBUTWST'),true || IsHiddenByStateDriver('pwdciclicity'));
SetDisplay(Ctrl('TMVAYOSJOV'),true);
SetDisplay(Ctrl('JEWFKZZWJU'),true);
SetDisplay(Ctrl('VULSHKPYLK'),true);
SetDisplay(Ctrl('HSOEINWVPM'),true || IsHiddenByStateDriver('pwdcaptchalevel_applied'));
SetDisplay(Ctrl('SQDRAMDHVL'),true);
SetDisplay(Ctrl('AZTVNXSPBF'),Eq(w_calcomplex,0) || (Eq(w_old_password,w_new_password)) || IsHiddenByStateDriver('password_meter'));
SetDisplay(Ctrl('XVYWBPODNF'),Eq(w_calcomplex,0) || (Eq(w_old_password,w_new_password)));
SetDisplay(Ctrl('ZZKRWOJQTG'),w_pwd1_view);
SetDisplay(Ctrl('OTBBXDQDET'),w_pwd2_view);
SetDisplay(Ctrl('OSVFPWEFJH'), ! (w_pwd1_view));
SetDisplay(Ctrl('XEGRJMWYIW'), ! (w_pwd2_view));
SetDisplay(Ctrl('YEUZQGQZIT'),w_pwd3_view);
SetDisplay(Ctrl('SCKKFWHTWV'), ! (w_pwd3_view));
HideUI();
}
HideUI.lblids["calcomplex"]=['HJGOYAFDPY','YSVBRIXOZI','ALHQOJUXRU','TMVAYOSJOV'];
HideUI.lblids["confirm_password"]=['RIUCOGNUSI'];
HideUI.lblids["new_password"]=['INRIMFQZEF'];
HideUI.lblids["old_password"]=['QVTYQJROCD'];
HideUI.lblids["pwdcaptchalevel_applied"]=['HJGOYAFDPY','YSVBRIXOZI','ALHQOJUXRU','TMVAYOSJOV'];
HideUI.lblids["pwdciclicity"]=['HJGOYAFDPY','YSVBRIXOZI','ALHQOJUXRU','TMVAYOSJOV'];
HideUI.lblids["pwdcomplexity"]=['HJGOYAFDPY','YSVBRIXOZI','ALHQOJUXRU','TMVAYOSJOV'];
HideUI.lblids["pwddaysduration"]=['HJGOYAFDPY','YSVBRIXOZI','ALHQOJUXRU','TMVAYOSJOV'];
function QDPGURJWZK_Valid(e) {
SetActiveField(Ctrl('QDPGURJWZK'),false);
e=(Ne(e,null)?e:window.event);
return Set_old_password(HtW(Ctrl('QDPGURJWZK').value,'C'),null,e);
}
function QDPGURJWZK_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('QDPGURJWZK'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('QDPGURJWZK',w_old_password,'C',20,0,'');
SetActiveField(Ctrl('QDPGURJWZK'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('QDPGURJWZK'),e);
}
function QDPGURJWZK_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("*"));
}
function JRQGKMZTEH_Valid(e) {
SetActiveField(Ctrl('JRQGKMZTEH'),false);
e=(Ne(e,null)?e:window.event);
return Set_new_password(HtW(Ctrl('JRQGKMZTEH').value,'C'),null,e);
}
function JRQGKMZTEH_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('JRQGKMZTEH'))) {
DisplayErrorMessage();
}
if (Ne(_tracker.ctrl,Ctrl('JRQGKMZTEH'))) {
SPBOUILib.WtH('JRQGKMZTEH',w_new_password,'C',20,0,'');
}
SetActiveField(Ctrl('JRQGKMZTEH'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('JRQGKMZTEH'),e);
}
function JRQGKMZTEH_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("*"));
}
function WLGONTBMKR_Valid(e) {
SetActiveField(Ctrl('WLGONTBMKR'),false);
e=(Ne(e,null)?e:window.event);
return Set_confirm_password(HtW(Ctrl('WLGONTBMKR').value,'C'),null,e);
}
function WLGONTBMKR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('WLGONTBMKR'))) {
DisplayErrorMessage();
}
if (Ne(_tracker.ctrl,Ctrl('WLGONTBMKR'))) {
SPBOUILib.WtH('WLGONTBMKR',w_confirm_password,'C',20,0,'');
}
SetActiveField(Ctrl('WLGONTBMKR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('WLGONTBMKR'),e);
}
function WLGONTBMKR_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("*"));
}
function SQDRAMDHVL_Click(el) {
ToggleLayerBox(arguments.length>0 && arguments[0].isConnected?arguments[0]:'SQDRAMDHVL',GetLayerID("pwdratecause_layer"),'10',false,'','',false)
}
function href_XVYWBPODNF(el) {
ToggleLayerBox(arguments.length>0 && arguments[0].isConnected?arguments[0]:'XVYWBPODNF_DIV',GetLayerID("pwdratecause_layer"),'10',false,'','',false)
}
function onfocus_XVYWBPODNF() {
ShowLayerBox('XVYWBPODNF_DIV',GetLayerID('pwdratecause_layer'),'10',false,'','',false,'focus');
}
function href_ZZKRWOJQTG() {
togglePwdView(1)
}
function href_OTBBXDQDET() {
togglePwdView(2)
}
function href_OSVFPWEFJH() {
togglePwdView(1)
}
function href_XEGRJMWYIW() {
togglePwdView(2)
}
function href_YEUZQGQZIT() {
togglePwdView(3)
}
function href_SCKKFWHTWV() {
togglePwdView(3)
}
_ResetTracker();
function setEventHandlers() {
var c;
function SQDRAMDHVL_wrap_OnClick(event) {
return SQDRAMDHVL_Click(event.srcElement);
}
SPBOUILib.SetButtonClick('SQDRAMDHVL',SQDRAMDHVL_wrap_OnClick);
function XVYWBPODNF_wrap_OnClick(event) {
return href_XVYWBPODNF(event.srcElement);
}
SPBOUILib.SetLabelClick('XVYWBPODNF',XVYWBPODNF_wrap_OnClick);
function XVYWBPODNF_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetLabelKeyDown('XVYWBPODNF',XVYWBPODNF_wrap_OnKeyDown);
function ZZKRWOJQTG_wrap_OnClick(event) {
return href_ZZKRWOJQTG();
}
SPBOUILib.SetImageClick('ZZKRWOJQTG',ZZKRWOJQTG_wrap_OnClick);
function ZZKRWOJQTG_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetKeyDown('ZZKRWOJQTG',ZZKRWOJQTG_wrap_OnKeyDown);
function OTBBXDQDET_wrap_OnClick(event) {
return href_OTBBXDQDET();
}
SPBOUILib.SetImageClick('OTBBXDQDET',OTBBXDQDET_wrap_OnClick);
function OTBBXDQDET_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetKeyDown('OTBBXDQDET',OTBBXDQDET_wrap_OnKeyDown);
function OSVFPWEFJH_wrap_OnClick(event) {
return href_OSVFPWEFJH();
}
SPBOUILib.SetImageClick('OSVFPWEFJH',OSVFPWEFJH_wrap_OnClick);
function OSVFPWEFJH_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetKeyDown('OSVFPWEFJH',OSVFPWEFJH_wrap_OnKeyDown);
function XEGRJMWYIW_wrap_OnClick(event) {
return href_XEGRJMWYIW();
}
SPBOUILib.SetImageClick('XEGRJMWYIW',XEGRJMWYIW_wrap_OnClick);
function XEGRJMWYIW_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetKeyDown('XEGRJMWYIW',XEGRJMWYIW_wrap_OnKeyDown);
function YEUZQGQZIT_wrap_OnClick(event) {
return href_YEUZQGQZIT();
}
SPBOUILib.SetImageClick('YEUZQGQZIT',YEUZQGQZIT_wrap_OnClick);
function YEUZQGQZIT_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetKeyDown('YEUZQGQZIT',YEUZQGQZIT_wrap_OnKeyDown);
function SCKKFWHTWV_wrap_OnClick(event) {
return href_SCKKFWHTWV();
}
SPBOUILib.SetImageClick('SCKKFWHTWV',SCKKFWHTWV_wrap_OnClick);
function SCKKFWHTWV_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetKeyDown('SCKKFWHTWV',SCKKFWHTWV_wrap_OnKeyDown);
if (Ne(m_cFunction,'view')) {
function QDPGURJWZK_wrap_Valid(event) {
return QDPGURJWZK_Valid(event);
}
SPBOUILib.SetInputExit('QDPGURJWZK',QDPGURJWZK_wrap_Valid);
function QDPGURJWZK_wrap_OnFocus(event) {
return QDPGURJWZK_OnFocus(event);
}
SPBOUILib.SetInputEnter('QDPGURJWZK',QDPGURJWZK_wrap_OnFocus);
function QDPGURJWZK_wrap_OnKeyDown(event) {
return ManageKeys(event,false,false,true,false);
}
SPBOUILib.SetInputKeyDown('QDPGURJWZK',QDPGURJWZK_wrap_OnKeyDown);
function JRQGKMZTEH_wrap_Valid(event) {
return JRQGKMZTEH_Valid(event);
}
SPBOUILib.SetInputExit('JRQGKMZTEH',JRQGKMZTEH_wrap_Valid);
function JRQGKMZTEH_wrap_OnFocus(event) {
return JRQGKMZTEH_OnFocus(event);
}
SPBOUILib.SetInputEnter('JRQGKMZTEH',JRQGKMZTEH_wrap_OnFocus);
function JRQGKMZTEH_wrap_OnKeyDown(event) {
return ManageKeys(event,false,false,true,false);
}
SPBOUILib.SetInputKeyDown('JRQGKMZTEH',JRQGKMZTEH_wrap_OnKeyDown);
function WLGONTBMKR_wrap_Valid(event) {
return WLGONTBMKR_Valid(event);
}
SPBOUILib.SetInputExit('WLGONTBMKR',WLGONTBMKR_wrap_Valid);
function WLGONTBMKR_wrap_OnFocus(event) {
return WLGONTBMKR_OnFocus(event);
}
SPBOUILib.SetInputEnter('WLGONTBMKR',WLGONTBMKR_wrap_OnFocus);
function WLGONTBMKR_wrap_OnKeyDown(event) {
return ManageKeys(event,false,false,true,false);
}
SPBOUILib.SetInputKeyDown('WLGONTBMKR',WLGONTBMKR_wrap_OnKeyDown);
function SQDRAMDHVL_wrap_OnKeyDown(event) {
return ManageKeys(event,false,false,true);
}
SPBOUILib.SetButtonKeyDown('SQDRAMDHVL',SQDRAMDHVL_wrap_OnKeyDown);
function XVYWBPODNF_wrap_OnFocus(event) {
return onfocus_XVYWBPODNF;
}
SPBOUILib.NullFunction('XVYWBPODNF',XVYWBPODNF_wrap_OnFocus);
}
}
function NotifyEvent(p_cEvent) {
var old_c;
if (Ne(typeof(w_pwdMeter),'undefined')) {
w_pwdMeter.raiseEvent('spadministration_changepassword_'+Strtran(p_cEvent,' ','_'));
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
FocusFirstComponent.otherwise={"page_1":["QDPGURJWZK"]};
function closeContextMenu_HITFFRVPXU() {
}
function Help() {
windowOpenForeground('../doc/spadministration_changepassword_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
}
function CalledBatchEnd() {
if ( ! (m_bCalculating)) {
DoUpdate(true);
}
}
function LoadChildrenInPage(page,lazy) {
}
GetLayerID.Layers.push({"id":"HITFFRVPXU_DIV","name":"pwdratecause_layer"});
function DeclareWVs() {
var a = arguments;
w_old_password=a[0];
w_new_password=a[1];
w_confirm_password=a[2];
w_errormessage=a[3];
w_calcomplex=a[4];
w_pwdcomplexity=a[5];
w_pwddaysduration=a[6];
w_cachekey=a[7];
w_root_m_cURL_servlet=a[8];
w_pwdciclicity=a[9];
w_pwdcaptchalevel_applied=a[10];
w_pwdratecause=a[11];
w_changeReason=a[12];
w_m_cAtExit=a[13];
w_pwd1_view=a[14];
w_pwd2_view=a[15];
w_pwd3_view=a[16];
o_new_password=w_new_password[1];
w_new_password=w_new_password[0];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('spadministration_changepassword',m_cSelectedPage);
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
if (window.Z && window.Z.Tabs) {
Z.Tabs.Get('tabs').CheckTabStrip();
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
function Set_old_password(ctrlValue,kmode,e) {
if (Ne(w_old_password,ctrlValue)) {
var ctl = _GetCtl(e,'QDPGURJWZK');
if (_tracker.goon(ctl,ctrlValue)) {
w_old_password=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('QDPGURJWZK',0);
DoUpdate(l_bResult);
SPBOUILib.SetInputValue('QDPGURJWZK',function(){return WtH(w_old_password,'C',20,0,'')},w_old_password);
return l_bResult;
} else {
ctl.value=WtH('','C',20,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_new_password(ctrlValue,kmode,e) {
if (Ne(w_new_password,ctrlValue)) {
var ctl = _GetCtl(e,'JRQGKMZTEH');
if (_tracker.goon(ctl,ctrlValue)) {
w_new_password=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
var l_bWarn = true;
l_bResult=_ChkObl('JRQGKMZTEH',0);
if (l_bResult) {
if (l_bResult && ( ! (UserAdmin.CheckPasswordStrength(w_new_password,w_pwdcomplexity)) && Ne(m_nLastError,-2))) {
try {
_tracker.askwrn=true;
l_bWarn=WindowConfirm(AlertErrorMessage('1110746968'));
} finally {
_tracker.askwrn=false;
}
}
if ( ! (l_bResult) ||  ! (l_bWarn)) {
w_new_password=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult) ||  ! (l_bWarn)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',20,0,''));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',20,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_confirm_password(ctrlValue,kmode,e) {
if (Ne(w_confirm_password,ctrlValue)) {
var ctl = _GetCtl(e,'WLGONTBMKR');
if (_tracker.goon(ctl,ctrlValue)) {
w_confirm_password=ctrlValue;
SetModified();
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('WLGONTBMKR',0);
if (l_bResult) {
l_bResult=Eq(w_confirm_password,w_new_password);
if ( ! (l_bResult)) {
m_nLastError=2;
m_cLastWorkVarErrorMsg='983832109';
m_cLastMsgError=AlertErrorMessage('1848680752');
}
if ( ! (l_bResult)) {
w_confirm_password=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',20,0,''));
} else {
_ResetTracker();
}
return l_bResult;
return l_bResult;
} else {
ctl.value=WtH('','C',20,0,'');
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
w_calcomplex=UserAdmin.GetPasswordRating(w_new_password);
w_pwdratecause=UserAdmin.GetPasswordRatingExplaination(w_new_password);
if ((Ne(o_new_password,w_new_password))) {
w_pwdMeter.Calculate(UserAdmin.GetPasswordRating(w_new_password));
}
// * --- Area Manuale = UI - Calculate
// * --- Fine Area Manuale
m_bCalculating=false;
}
function Check_WKDURBIBSO(p_bForce) {
var l_bResult = true;
if (p_bForce) {
l_bResult=UserAdmin.CheckPasswordStrength(w_new_password,w_pwdcomplexity);
if ( ! (l_bResult)) {
m_cLastMsgError=AlertErrorMessage('1110746968');
} else {
l_bResult=Ne(w_new_password,w_old_password);
if ( ! (l_bResult)) {
m_cLastMsgError=AlertErrorMessage('2068121389');
} else {
l_bResult=Eq(w_new_password,w_confirm_password);
if ( ! (l_bResult)) {
m_cLastMsgError=AlertErrorMessage('1848680752');
}
}
}
}
return l_bResult;
}
function SaveDependsOn() {
o_new_password=w_new_password;
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
var l_oCaller = window[NameForCaller()];
var bHasOpener = IsWndAccessible(l_oCaller);
var l_cCPCCCHK;
var bSend = true;
if (Eq(formaction,'save')) {
bSend=Check();
if ( ! (bSend)) {
DisplayErrorMessage();
}
}
if (bSend && Ne(formaction,'discard')) {
if (bHasOpener) {
var xAccessErr; try{l_oCaller.Ctrl;}catch(e){xAccessErr=1;} //IE security access error
if ( ! (xAccessErr) && Ne(typeof(l_oCaller.Ctrl),'undefined') && l_oCaller.Ctrl('FSender') && Ne(l_oCaller.Ctrl('FSender').m_cOldCPCCCHK,null)) {
l_cCPCCCHK=l_oCaller.Ctrl('FSender').m_cOldCPCCCHK.value;
}
if (Eq(l_cCPCCCHK,null) || Eq(l_cCPCCCHK,m_cCPCCCHK)) {
if (Ne(l_oCaller.w_old_password,null)) {
l_oCaller.w_old_password=w_old_password;
}
if (Ne(l_oCaller.w_new_password,null)) {
l_oCaller.w_new_password=w_new_password;
}
if (Ne(l_oCaller.w_confirm_password,null)) {
l_oCaller.w_confirm_password=w_confirm_password;
}
if (Ne(l_oCaller.w_errormessage,null)) {
l_oCaller.w_errormessage=w_errormessage;
}
if (Ne(l_oCaller.w_cachekey,null)) {
l_oCaller.w_cachekey=w_cachekey;
}
if (Ne(l_oCaller.w_root_m_cURL_servlet,null)) {
l_oCaller.w_root_m_cURL_servlet=w_root_m_cURL_servlet;
}
if (Ne(l_oCaller.w_changeReason,null)) {
l_oCaller.w_changeReason=w_changeReason;
}
if (Ne(l_oCaller.w_m_cAtExit,null)) {
l_oCaller.w_m_cAtExit=w_m_cAtExit;
}
if (Ne(typeof(l_oCaller.DoUpdate),'undefined')) {
l_oCaller.DoUpdate(true);
}
} else if (Ne(l_cCPCCCHK,null) && Ne(l_cCPfrCCCHK,m_cCPCCCHK)) {
WindowAlert(Translate('MSG_CANNOT_UPDATE_CALLERVAR'));
}
}
}
if (bSend) {
if (Ne(formaction,'discard')) {
}
// * --- Area Manuale = BeforeSubmitForm
// * --- Fine Area Manuale
SubmitForm(formaction,url,data);
// * --- Area Manuale = AfterSubmitForm
// * --- Fine Area Manuale
}
}
function Check() {
var l_bResult = true;
ResetErrorVars();
m_nLastError=0;
if ( ! (_ChkObl('QDPGURJWZK',1))) {
_SignErr('QDPGURJWZK');
m_cLastWorkVarErrorMsg='10798899235';
l_bResult=false;
w_old_password=HtW('','C');
} else if ( ! (_ChkObl('JRQGKMZTEH',1))) {
_SignErr('JRQGKMZTEH','1110746968');
l_bResult=false;
w_new_password=HtW('','C');
} else if (( ! (_ChkObl('WLGONTBMKR',1))) || ( ! (Eq(w_confirm_password,w_new_password)))) {
_SignErr('WLGONTBMKR','1848680752');
l_bResult=false;
w_confirm_password=HtW('','C');
} else if ( ! (Check_WKDURBIBSO(true))) {
l_bResult = false;
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
l_oWv.setValue('old_password',WtA(w_old_password,'C'));
l_oWv.setValue('new_password',WtA(w_new_password,'C'));
l_oWv.setValue('confirm_password',WtA(w_confirm_password,'C'));
l_oWv.setValue('errormessage',WtA(w_errormessage,'M'));
l_oWv.setValue('calcomplex',WtA(w_calcomplex,'N'));
l_oWv.setValue('pwdcomplexity',WtA(w_pwdcomplexity,'N'));
l_oWv.setValue('pwddaysduration',WtA(w_pwddaysduration,'N'));
l_oWv.setValue('cachekey',WtA(w_cachekey,'C'));
l_oWv.setValue('root_m_cURL_servlet',WtA(w_root_m_cURL_servlet,'C'));
l_oWv.setValue('pwdciclicity',WtA(w_pwdciclicity,'N'));
l_oWv.setValue('pwdcaptchalevel_applied',WtA(w_pwdcaptchalevel_applied,'N'));
l_oWv.setValue('pwdratecause',WtA(w_pwdratecause,'M'));
l_oWv.setValue('changeReason',WtA(w_changeReason,'C'));
l_oWv.setValue('m_cAtExit',WtA(w_m_cAtExit,'C'));
l_oWv.setValue('pwd1_view',WtA(w_pwd1_view,'L'));
l_oWv.setValue('pwd2_view',WtA(w_pwd2_view,'L'));
l_oWv.setValue('pwd3_view',WtA(w_pwd3_view,'L'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["old_password","new_password","confirm_password","errormessage","calcomplex","pwdcomplexity","pwddaysduration","cachekey","root_m_cURL_servlet","pwdciclicity","pwdcaptchalevel_applied","pwdratecause","changeReason","m_cAtExit","pwd1_view","pwd2_view","pwd3_view"];
function SetModified() {
m_bUpdated=true;
}
function LinkZoomExtendedMenu() {
}
function initNoLocalVars(start,pseq) {
if (start) {
_CopyCallers(['old_password','new_password','confirm_password','errormessage','cachekey','root_m_cURL_servlet','changeReason','m_cAtExit'])
}
// * --- Area Manuale = UI - Blank Record Init
// * --- Fine Area Manuale
m_bCalculating=true;
w_calcomplex=UserAdmin.GetPasswordRating(w_new_password);
if (start && Eq(At(',pwdcomplexity,',pseq),0)) {
w_pwdcomplexity=spadministration_getpwdcomplexity(Utilities.Make(window).UserCode());
}
if (start && Eq(At(',pwddaysduration,',pseq),0)) {
w_pwddaysduration=spadministration_getpwdduration(Utilities.Make(window).UserCode());
}
if (start && Eq(At(',pwdciclicity,',pseq),0)) {
w_pwdciclicity=spadministration_getpwdciclicity(Utilities.Make(window).UserCode());
}
if (start && Eq(At(',pwdcaptchalevel_applied,',pseq),0)) {
w_pwdcaptchalevel_applied=spadministration_getcaptchalevel(Utilities.Make(window).UserCode());
}
w_pwdratecause=UserAdmin.GetPasswordRatingExplaination(w_new_password);
if (start && Eq(At(',pwd1_view,',pseq),0)) {
w_pwd1_view=false;
}
if (start && Eq(At(',pwd2_view,',pseq),0)) {
w_pwd2_view=false;
}
if (start && Eq(At(',pwd3_view,',pseq),0)) {
w_pwd3_view=false;
}
m_bCalculating=false;
SaveDependsOn();
SetControlsValue();
EnableControlsUnderCondition();
SaveLabelDependsOn();
// * --- Area Manuale = UI - Blank Record End
// * --- Fine Area Manuale
var l_oCaller;
if (IsWndAccessible(l_oCaller)) {
var xAccessErr; try{l_oCaller.Ctrl;}catch(e){xAccessErr=1;} //IE security access error
if ( ! (xAccessErr) && Ne(typeof(l_oCaller.Ctrl),'undefined') && Ne(l_oCaller.Ctrl('FSender'),null) && Ne(typeof(l_oCaller.Ctrl('FSender').m_cOldCPCCCHK),'undefined')) {
m_cCPCCCHK=l_oCaller.Ctrl('FSender').m_cOldCPCCCHK.value;
}
}
}
_Obli('old_password',0,'QDPGURJWZK',false,"10798899235")
_Obli('new_password',0,'JRQGKMZTEH',false,"10487537699")
_Obli('confirm_password',0,'WLGONTBMKR',false,"983832109")
