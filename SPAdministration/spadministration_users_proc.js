function FillCombosValues() {
FillCombo('XFCGDYJJAR','XFCGDYJJAR');
}
function SetControlsValue() {
var c;
var tmp_subtitle = ToHTag(AsControlValue(w_name));
if (Ne(e_subtitle,tmp_subtitle)) {
SetSubTitle(tmp_subtitle);
e_subtitle=tmp_subtitle;
}
SPBOUILib.SetInputValue('CIUGDDXJMR',function(){return WtH(w_code,'N',9,0,'999999999')},w_code);
SPBOUILib.SetInputValue('YOMCOSHNCV',function(){return WtH(w_fullname,'C',2048,0,'')},w_fullname);
SPBOUILib.SetInputValue('ZOLPGDGKUC',function(){return WtH(w_name,'C',50,0,'')},w_name);
if(c=Ctrl('RGNPWADGHN')) ChkboxCheckUncheck(c,true,w_accesstype_human)
if(c=Ctrl('RGNPWADGHN')) ChkboxValueAssign(c,true,false,'L',1,0,'')
if(c=Ctrl('GZOGXZQGVV')) ChkboxCheckUncheck(c,true,w_accesstype_service)
if(c=Ctrl('GZOGXZQGVV')) ChkboxValueAssign(c,true,false,'L',1,0,'')
if(c=Ctrl('GSXRFLFMJR')) ChkboxCheckUncheck(c,true,w_accesstype_machine)
if(c=Ctrl('GSXRFLFMJR')) ChkboxValueAssign(c,true,false,'L',1,0,'')
if(c=Ctrl('FTIRRMMSXK')) ChkboxCheckUncheck(c,1,w_modifyPassword)
if(c=Ctrl('FTIRRMMSXK')) ChkboxValueAssign(c,1,0,'N',1,0,'')
SPBOUILib.SetInputValue('GMYTSOEEXH',function(){return WtH(w_pwd1,'C',20,0,'')},w_pwd1);
SPBOUILib.SetInputValue('ZDDZZTSQYG',function(){return WtH(w_calcomplex,'N',3,0,'')},w_calcomplex);
var tmp_DRGTXCMDVI = ToHTag(AsControlValue('/'+UserAdmin.GetPasswordRatingMaxReachable()));
if (Ne(e_DRGTXCMDVI,tmp_DRGTXCMDVI)) {
SPBOUILib.SetLabelValue('DRGTXCMDVI','innerHTML',tmp_DRGTXCMDVI);
e_DRGTXCMDVI=tmp_DRGTXCMDVI;
}
SPBOUILib.SetInputValue('OTMRFENACR',function(){return WtH(w_pwdratecause,'M',10,0,'')},w_pwdratecause);
SPBOUILib.SetInputValue('KIBLXEYDCR',function(){return WtH(w_pwd2,'C',20,0,'')},w_pwd2);
SPBOUILib.SetInputValue('TBXREXYXIU',function(){return WtH(w_pwdcomplexity_group,'N',3,0,'')},w_pwdcomplexity_group);
SPBOUILib.SetInputValue('YDSHUIXYEH',function(){return WtH(w_pwdcomplexity,'N',3,0,'')},w_pwdcomplexity);
SPBOUILib.SetInputValue('EJKRLFXEIY',function(){return WtH(w_pwdcomplexity_reqired,'N',3,0,'')},w_pwdcomplexity_reqired);
var tmp_CZUCWOMCIB = ToHTag(AsControlValue('/'+UserAdmin.GetPasswordRatingMaxReachable()));
if (Ne(e_CZUCWOMCIB,tmp_CZUCWOMCIB)) {
SPBOUILib.SetLabelValue('CZUCWOMCIB','innerHTML',tmp_CZUCWOMCIB);
e_CZUCWOMCIB=tmp_CZUCWOMCIB;
}
if(c=Ctrl('RRBOVTXUAU')) ChkboxCheckUncheck(c,true,w_forcepwdchange)
if(c=Ctrl('RRBOVTXUAU')) ChkboxValueAssign(c,true,false,'L',1,0,'')
if(c=Ctrl('GNSADWOGKM')) ChkboxCheckUncheck(c,'D',w_enabled)
if(c=Ctrl('GNSADWOGKM')) ChkboxValueAssign(c,'D','E','C',1,0,'')
if(c=Ctrl('XFCGDYJJAR')) selectCombo(c,w_language,'C')
SPBOUILib.SetInputValue('IZJFQHGQUB',function(){return WtH(w_decimalseparator,'C',3,0,'')},w_decimalseparator);
SPBOUILib.SetInputValue('ACYLERWDKK',function(){return WtH(w_thousandseparator,'C',3,0,'')},w_thousandseparator);
SPBOUILib.SetInputValue('EVNGTHPGLR',function(){return WtH(w_datepattern,'C',12,0,'')},w_datepattern);
SPBOUILib.SetInputValue('BOLWRICGIA',function(){return WtH(w_datetimepattern,'C',25,0,'')},w_datetimepattern);
SPBOUILib.SetInputValue('AMIQVJBLLQ',function(){return WtH(w_pwddaysduration_group,'N',4,0,'')},w_pwddaysduration_group);
SPBOUILib.SetInputValue('NTAYXBDPVY',function(){return WtH(w_pwddaysduration,'N',4,0,'')},w_pwddaysduration);
SPBOUILib.SetInputValue('LDXRXBOORH',function(){return WtH(w_pwdciclicity_groups,'N',4,0,'')},w_pwdciclicity_groups);
SPBOUILib.SetInputValue('CLZCOSTIAC',function(){return WtH(w_pwdciclicity,'N',2,0,'')},w_pwdciclicity);
SPBOUILib.SetInputValue('LREHYNDNHI',function(){return WtH(w_pwdcaptchalevel_group,'N',3,0,'')},w_pwdcaptchalevel_group);
SPBOUILib.SetInputValue('WLRWPELGIS',function(){return WtH(w_captchalevel,'N',4,0,'')},w_captchalevel);
SPBOUILib.SetInputValue('DWGQEAJBOS',function(){return WtH(w_datestart,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_datestart);
SPBOUILib.SetInputValue('AFHAPKTVTZ',function(){return WtH(w_datestop,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_datestop);
SPBOUILib.SetInputValue('HZXQEZHOPX',function(){return WtH(w_failedlogins,'N',3,0,'')},w_failedlogins);
SPBOUILib.SetInputValue('ZRPODWVWKZ',function(){return WtH(w_lastfailedlogin,'T',14,0,TranslatePicture(GetDatePicture(true,'T'),'T'))},w_lastfailedlogin);
SPBOUILib.SetInputValue('QHBHJMVSND',function(){return WtH(w_lastsuccessfullogin,'T',14,0,TranslatePicture(GetDatePicture(true,'T'),'T'))},w_lastsuccessfullogin);
SPBOUILib.SetInputValue('HDTXQUZAEB',function(){return WtH(w_pwdcreate,'T',14,0,TranslatePicture(GetDatePicture(true,'T'),'T'))},w_pwdcreate);
SPBOUILib.SetInputValue('TDUBYHZOLX',function(){return WtH(w_pwddaysduration_applied,'N',4,0,'')},w_pwddaysduration_applied);
SPBOUILib.SetInputValue('YXDVNAKABC',function(){return WtH(w_pwdciclicity_applied,'N',4,0,'')},w_pwdciclicity_applied);
SPBOUILib.SetInputValue('WECEQGOQXC',function(){return WtH(w_pwdcaptchalevel_applied,'N',4,0,'')},w_pwdcaptchalevel_applied);
SPBOUILib.SetInputValue('BLGCNCYQRJ',function(){return WtH(w_printserver,'C',60,0,'')},w_printserver);
var tmp_DJBOUZEOSW = ToHTag(AsControlValue('#'+w_thousandseparator+'###'+w_decimalseparator+'00'));
if (Ne(e_DJBOUZEOSW,tmp_DJBOUZEOSW)) {
SPBOUILib.SetLabelValue('DJBOUZEOSW','innerHTML',tmp_DJBOUZEOSW);
e_DJBOUZEOSW=tmp_DJBOUZEOSW;
}
if(c=Ctrl('ZOICKBMQFQ')) ChkboxCheckUncheck(c,'T',w_usesiarlicense)
if(c=Ctrl('ZOICKBMQFQ')) ChkboxValueAssign(c,'T','F','C',1,0,'')
SPBOUILib.SetInputValue('MHGIWUEDLA',function(){return WtH(w_IAR_LICENSES,'N',6,0,'')},w_IAR_LICENSES);
SPBOUILib.SetInputValue('IQERCSAIWG',function(){return WtH(w_IAR_USED,'N',6,0,'')},w_IAR_USED);
SPBOUILib.SetInputValue('RGMQBWZEWR',function(){return WtH(w_IAR_AVAILABLE,'N',6,0,'')},w_IAR_AVAILABLE);
var tmp_EMQMMHAGNL = ToHTag(AsControlValue((w_IAR_LICENSE_VALID?'':FormatMsg('SPAS_LICENSE_TAMPERED_MSG'))));
if (Ne(e_EMQMMHAGNL,tmp_EMQMMHAGNL)) {
SPBOUILib.SetLabelValue('EMQMMHAGNL','innerHTML',tmp_EMQMMHAGNL);
e_EMQMMHAGNL=tmp_EMQMMHAGNL;
}
SPBOUILib.SetInputValue('XNDAWTQDZS',function(){return WtH(w_selected_group,'N',4,0,'')},w_selected_group);
if(c=Ctrl('DUYHIUNXPN')) c.value=WtH((Empty(w_otp)?FormatMsg('ADMIN_ACTIVATE_OTP'):FormatMsg('ADMIN_DEACTIVATE_OTP')),'C',0,0);
SPBOUILib.SetInputValue('UOJLIHOZBH',function(){return WtH(w_otp,'C',100,0,'')},w_otp);
SPBOUILib.SetInputValue('UYGLGETTUT',function(){return WtH(w_companies,'C',2000,0,'')},w_companies);
if(c=Ctrl('VRCQKXWFPX')) selectCombo(c,w_UFENABLEAZI,'C')
SetCollapsibleCaptions();
if (m_bExtended) {
SetExtensions();
}
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function SetCollapsibleCaptions() {
var c;
var l_cComment;
l_cComment=UserAdmin.GetPasswordVerdict(w_pwd1,1);
if (Ne(e_PLMVGNNZCG,l_cComment)) {
SetLayerCaption('PLMVGNNZCG',l_cComment);
e_PLMVGNNZCG=l_cComment;
}
}
function HideControlsUnderCondition() {
var h;
Z.Tabs.Get("tabs_1_configurazioni").Hide('BGMYNICMON',IsHiddenByStateDriver('box_BGMYNICMON'));
SetDisplay('KVIFRCSRUG_DIV',IsHiddenByStateDriver('box_access'));
SetDisplay('WUIVVJMUJT_DIV',Ne(EntityStatus(),'E') || IsHiddenByStateDriver('box_WUIVVJMUJT'));
SetDisplay(Ctrl('ZZKRWOJQTG'),w_pwd1_view);
SetDisplay(Ctrl('QEXYRQXFGY'),Eq(w_pwd1,'cambia la password'));
SetDisplay(Ctrl('ZDDZZTSQYG'),Eq(w_pwd1,'cambia la password') || IsHiddenByStateDriver('calcomplex'));
SetDisplay(Ctrl('KZXLYHJHAW'),Eq(w_pwd1,'cambia la password'));
SetDisplay(Ctrl('DRGTXCMDVI'),Eq(w_pwd1,'cambia la password'));
SetDisplay(Ctrl('GRPBSLBHXA'),Eq(w_pwd1,'cambia la password'));
SetDisplay(Ctrl('OTBBXDQDET'),w_pwd2_view);
SetDisplay(Ctrl('EJKRLFXEIY'),Eq(w_pwd1,'cambia la password') || IsHiddenByStateDriver('pwdcomplexity_reqired'));
SetDisplay(Ctrl('LCHPBEJNON'),Eq(w_pwd1,'cambia la password'));
SetDisplay(Ctrl('CZUCWOMCIB'),Eq(w_pwd1,'cambia la password'));
Z.Tabs.Get("tabs_1_configurazioni").Hide('ZVNKOIBZTJ',IsHiddenByStateDriver('pwd_layer'));
SetDisplay(Ctrl('OBAKOPSMDI'),Eq(w_UFENABLEAZI,'n') || IsHiddenByStateDriver('grdCompanies'));
Z.Tabs.Get("tabs_1_configurazioni").Hide('QZSVKXVUQD',IsHiddenByStateDriver('language_formatting'));
Z.Tabs.Get("tabs_1_configurazioni").Hide('AXCUQKTKCI', ! (spas_fhaslicense()) || IsHiddenByStateDriver('box_AXCUQKTKCI'));
SetDisplay(Ctrl('XNDAWTQDZS'),true || IsHiddenByStateDriver('selected_group'));
Z.Tabs.Get("tabs_1_configurazioni").Hide('FLMCUOBXBF',IsHiddenByStateDriver('gruppi_appartenenza'));
SetDisplay(Ctrl('UOJLIHOZBH'),true || IsHiddenByStateDriver('otp'));
SetDisplay(Ctrl('UYGLGETTUT'),true || IsHiddenByStateDriver('companies'));
SetDisplay('GWZDNNWFFM_DIV',Eq(w_UFENABLEAZI,'n') || IsHiddenByStateDriver('companies_hsect'));
SetDisplay(Ctrl('OSVFPWEFJH'), ! (w_pwd1_view));
SetDisplay(Ctrl('XEGRJMWYIW'), ! (w_pwd2_view));
LibJavascript.forEachItem(m_FoundlingHideExpression,i_body_2)
function i_body_2(child){
child();
}
HideUI();
}
HideUI.lblids["IAR_AVAILABLE"]=['FPMYPPWLBO'];
HideUI.lblids["IAR_LICENSES"]=['ZKJXQLSILH'];
HideUI.lblids["IAR_USED"]=['UKIVAGKLUF'];
HideUI.lblids["UFENABLEAZI"]=['DBASOAOUYJ'];
HideUI.lblids["calcomplex"]=['QEXYRQXFGY'];
HideUI.lblids["captchalevel"]=['SWHXFUZIRC'];
HideUI.lblids["code"]=['ZRXEDHLHRU'];
HideUI.lblids["datepattern"]=['VCIJYACAFD'];
HideUI.lblids["datestart"]=['TETMHKUMSX'];
HideUI.lblids["datestop"]=['LHHSNVPTSD'];
HideUI.lblids["datetimepattern"]=['GIRCEKWNMB'];
HideUI.lblids["decimalseparator"]=['DJBOUZEOSW','HUODVPIWHU','HOTCYSDBTM'];
HideUI.lblids["failedlogins"]=['ACXJLWUAKM'];
HideUI.lblids["fullname"]=['GONJPLYFCM'];
HideUI.lblids["language"]=['UKIHMTALYE'];
HideUI.lblids["lastfailedlogin"]=['NNXHXVLPCZ'];
HideUI.lblids["lastsuccessfullogin"]=['YIWMIRNCJP'];
HideUI.lblids["name"]=['LWKHSAVZHT'];
HideUI.lblids["printserver"]=['ETVOQUICKV','ZTPRGWPKKQ'];
HideUI.lblids["pwd1"]=['YYYRCYYISO'];
HideUI.lblids["pwd2"]=['NXPUKKLWAT'];
HideUI.lblids["pwdcaptchalevel_applied"]=['NTPASPDTXK'];
HideUI.lblids["pwdcaptchalevel_group"]=['ONZAKKFAAI'];
HideUI.lblids["pwdciclicity"]=['KRTEQHMKQD'];
HideUI.lblids["pwdciclicity_applied"]=['EKCSBIVEMO'];
HideUI.lblids["pwdciclicity_groups"]=['INOSWBMEWD'];
HideUI.lblids["pwdcomplexity"]=['XCVHSJEHUH'];
HideUI.lblids["pwdcomplexity_group"]=['WNFOFUHXXF'];
HideUI.lblids["pwdcomplexity_reqired"]=['GRPBSLBHXA'];
HideUI.lblids["pwdcreate"]=['UVGCSSTYHA'];
HideUI.lblids["pwddaysduration"]=['CNLYOZMXLI'];
HideUI.lblids["pwddaysduration_applied"]=['UFJBXUDKJY'];
HideUI.lblids["pwddaysduration_group"]=['OXCBAQDUEO'];
HideUI.lblids["thousandseparator"]=['ADDXUTCFVF'];
function ExpandCollapseBoxesUnderCondition() {
var cond;
cond=spas_fhaslicense() && w_usesiarlicense;
if (Ne(o_AXCUQKTKCI_expand,cond)) {
if (cond) {
Z.Tabs.Get("tabs_1_configurazioni").Expand('AXCUQKTKCI');
}
o_AXCUQKTKCI_expand=cond;
}
}
function CIUGDDXJMR_Valid(e) {
SetActiveField(Ctrl('CIUGDDXJMR'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('CIUGDDXJMR') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('code','N',w_code,HtW(Ctrl('CIUGDDXJMR').value,'N'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_code(HtW(Ctrl('CIUGDDXJMR').value,'N'),null,e);
return l_bSetResult;
}
}
function CIUGDDXJMR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('CIUGDDXJMR'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('CIUGDDXJMR',w_code,'N',9,0,'999999999');
SetActiveField(Ctrl('CIUGDDXJMR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('CIUGDDXJMR'),e);
}
function CIUGDDXJMR_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("999999999"));
}
function YOMCOSHNCV_Valid(e) {
SetActiveField(Ctrl('YOMCOSHNCV'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('fullname','C',w_fullname,HtW(Ctrl('YOMCOSHNCV').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_fullname(HtW(Ctrl('YOMCOSHNCV').value,'C'),null,e);
return l_bSetResult;
}
}
function YOMCOSHNCV_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('YOMCOSHNCV'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('YOMCOSHNCV'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('YOMCOSHNCV'),e);
}
function ZOLPGDGKUC_Valid(e) {
SetActiveField(Ctrl('ZOLPGDGKUC'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('name','C',w_name,HtW(Ctrl('ZOLPGDGKUC').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_name(HtW(Ctrl('ZOLPGDGKUC').value,'C'),null,e);
return l_bSetResult;
}
}
function ZOLPGDGKUC_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ZOLPGDGKUC'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('ZOLPGDGKUC'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ZOLPGDGKUC'),e);
}
function RGNPWADGHN_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('accesstype_human','L',w_accesstype_human,ChkboxValueAssign(Ctrl('RGNPWADGHN'),true,false,'L',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_accesstype_human(ChkboxValueAssign(Ctrl('RGNPWADGHN'),true,false,'L',1,0,''),null,e);
return l_bSetResult;
}
}
function RGNPWADGHN_OnFocus(e) {
SetActiveField(Ctrl('RGNPWADGHN'),true);
}
function RGNPWADGHN_OnBlur(e) {
SetActiveField(Ctrl('RGNPWADGHN'),false);
}
function GZOGXZQGVV_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('accesstype_service','L',w_accesstype_service,ChkboxValueAssign(Ctrl('GZOGXZQGVV'),true,false,'L',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_accesstype_service(ChkboxValueAssign(Ctrl('GZOGXZQGVV'),true,false,'L',1,0,''),null,e);
return l_bSetResult;
}
}
function GZOGXZQGVV_OnFocus(e) {
SetActiveField(Ctrl('GZOGXZQGVV'),true);
}
function GZOGXZQGVV_OnBlur(e) {
SetActiveField(Ctrl('GZOGXZQGVV'),false);
}
function GSXRFLFMJR_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('accesstype_machine','L',w_accesstype_machine,ChkboxValueAssign(Ctrl('GSXRFLFMJR'),true,false,'L',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_accesstype_machine(ChkboxValueAssign(Ctrl('GSXRFLFMJR'),true,false,'L',1,0,''),null,e);
return l_bSetResult;
}
}
function GSXRFLFMJR_OnFocus(e) {
SetActiveField(Ctrl('GSXRFLFMJR'),true);
}
function GSXRFLFMJR_OnBlur(e) {
SetActiveField(Ctrl('GSXRFLFMJR'),false);
}
function FTIRRMMSXK_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('modifyPassword','N',w_modifyPassword,ChkboxValueAssign(Ctrl('FTIRRMMSXK'),1,0,'N',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_modifyPassword(ChkboxValueAssign(Ctrl('FTIRRMMSXK'),1,0,'N',1,0,''),null,e);
return l_bSetResult;
}
}
function FTIRRMMSXK_OnFocus(e) {
SetActiveField(Ctrl('FTIRRMMSXK'),true);
}
function FTIRRMMSXK_OnBlur(e) {
SetActiveField(Ctrl('FTIRRMMSXK'),false);
}
function GMYTSOEEXH_Valid(e) {
SetActiveField(Ctrl('GMYTSOEEXH'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('pwd1','C',w_pwd1,HtW(Ctrl('GMYTSOEEXH').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_pwd1(HtW(Ctrl('GMYTSOEEXH').value,'C'),null,e);
return l_bSetResult;
}
}
function GMYTSOEEXH_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('GMYTSOEEXH'))) {
DisplayErrorMessage();
}
if (Ne(_tracker.ctrl,Ctrl('GMYTSOEEXH'))) {
SPBOUILib.WtH('GMYTSOEEXH',w_pwd1,'C',20,0,'');
}
SetActiveField(Ctrl('GMYTSOEEXH'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('GMYTSOEEXH'),e);
}
function GMYTSOEEXH_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict('*'));
}
function href_ZZKRWOJQTG() {
if (Eq(EntityStatus(),'N') || Eq(w_modifyPassword,1)) {
togglePwdView(1)
}
}
function KZXLYHJHAW_Click(el) {
ToggleLayerBox(arguments.length>0 && arguments[0].isConnected?arguments[0]:'KZXLYHJHAW',GetLayerID("pwdratecause_layer"),'10',false,'shadowBand_BEFORE_GWZDNNWFFM','',false)
}
function KIBLXEYDCR_Valid(e) {
SetActiveField(Ctrl('KIBLXEYDCR'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('pwd2','C',w_pwd2,HtW(Ctrl('KIBLXEYDCR').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_pwd2(HtW(Ctrl('KIBLXEYDCR').value,'C'),null,e);
return l_bSetResult;
}
}
function KIBLXEYDCR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('KIBLXEYDCR'))) {
DisplayErrorMessage();
}
if (Ne(_tracker.ctrl,Ctrl('KIBLXEYDCR'))) {
SPBOUILib.WtH('KIBLXEYDCR',w_pwd2,'C',20,0,'');
}
SetActiveField(Ctrl('KIBLXEYDCR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('KIBLXEYDCR'),e);
}
function KIBLXEYDCR_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict('*'));
}
function href_OTBBXDQDET() {
if (Eq(EntityStatus(),'N') || Eq(w_modifyPassword,1)) {
togglePwdView(2)
}
}
function TBXREXYXIU_Valid(e) {
SetActiveField(Ctrl('TBXREXYXIU'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('pwdcomplexity_group','N',w_pwdcomplexity_group,HtW(Ctrl('TBXREXYXIU').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_pwdcomplexity_group(HtW(Ctrl('TBXREXYXIU').value,'N'),null,e);
return l_bSetResult;
}
}
function TBXREXYXIU_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('TBXREXYXIU'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('TBXREXYXIU'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('TBXREXYXIU'),e);
}
function YDSHUIXYEH_Valid(e) {
SetActiveField(Ctrl('YDSHUIXYEH'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('pwdcomplexity','N',w_pwdcomplexity,HtW(Ctrl('YDSHUIXYEH').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_pwdcomplexity(HtW(Ctrl('YDSHUIXYEH').value,'N'),null,e);
return l_bSetResult;
}
}
function YDSHUIXYEH_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('YDSHUIXYEH'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('YDSHUIXYEH'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('YDSHUIXYEH'),e);
}
function LCHPBEJNON_Click(el) {
ToggleLayerBox(arguments.length>0 && arguments[0].isConnected?arguments[0]:'LCHPBEJNON',GetLayerID("complexityreq_layer"),'10',false,'shadowBand_BEFORE_GWZDNNWFFM','',false)
}
function RRBOVTXUAU_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('forcepwdchange','L',w_forcepwdchange,ChkboxValueAssign(Ctrl('RRBOVTXUAU'),true,false,'L',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_forcepwdchange(ChkboxValueAssign(Ctrl('RRBOVTXUAU'),true,false,'L',1,0,''),null,e);
return l_bSetResult;
}
}
function RRBOVTXUAU_OnFocus(e) {
SetActiveField(Ctrl('RRBOVTXUAU'),true);
}
function RRBOVTXUAU_OnBlur(e) {
SetActiveField(Ctrl('RRBOVTXUAU'),false);
}
function GNSADWOGKM_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('enabled','C',w_enabled,ChkboxValueAssign(Ctrl('GNSADWOGKM'),'D','E','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_enabled(ChkboxValueAssign(Ctrl('GNSADWOGKM'),'D','E','C',1,0,''),null,e);
return l_bSetResult;
}
}
function GNSADWOGKM_OnFocus(e) {
SetActiveField(Ctrl('GNSADWOGKM'),true);
}
function GNSADWOGKM_OnBlur(e) {
SetActiveField(Ctrl('GNSADWOGKM'),false);
}
function XFCGDYJJAR_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('language','C',w_language,HtW(getComboValue(Ctrl('XFCGDYJJAR')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_language(HtW(getComboValue(Ctrl('XFCGDYJJAR')),'C'),null,e);
return l_bSetResult;
}
}
function XFCGDYJJAR_OnFocus(e) {
SetActiveField(Ctrl('XFCGDYJJAR'),true);
}
function XFCGDYJJAR_OnBlur(e) {
SetActiveField(Ctrl('XFCGDYJJAR'),false);
}
function IZJFQHGQUB_Valid(e) {
SetActiveField(Ctrl('IZJFQHGQUB'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('decimalseparator','C',w_decimalseparator,HtW(Ctrl('IZJFQHGQUB').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_decimalseparator(HtW(Ctrl('IZJFQHGQUB').value,'C'),null,e);
return l_bSetResult;
}
}
function IZJFQHGQUB_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('IZJFQHGQUB'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('IZJFQHGQUB'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('IZJFQHGQUB'),e);
}
function ACYLERWDKK_Valid(e) {
SetActiveField(Ctrl('ACYLERWDKK'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('thousandseparator','C',w_thousandseparator,HtW(Ctrl('ACYLERWDKK').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_thousandseparator(HtW(Ctrl('ACYLERWDKK').value,'C'),null,e);
return l_bSetResult;
}
}
function ACYLERWDKK_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ACYLERWDKK'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('ACYLERWDKK'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ACYLERWDKK'),e);
}
function EVNGTHPGLR_Valid(e) {
SetActiveField(Ctrl('EVNGTHPGLR'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('datepattern','C',w_datepattern,HtW(Ctrl('EVNGTHPGLR').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_datepattern(HtW(Ctrl('EVNGTHPGLR').value,'C'),null,e);
return l_bSetResult;
}
}
function EVNGTHPGLR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('EVNGTHPGLR'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('EVNGTHPGLR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('EVNGTHPGLR'),e);
}
function BOLWRICGIA_Valid(e) {
SetActiveField(Ctrl('BOLWRICGIA'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('datetimepattern','C',w_datetimepattern,HtW(Ctrl('BOLWRICGIA').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_datetimepattern(HtW(Ctrl('BOLWRICGIA').value,'C'),null,e);
return l_bSetResult;
}
}
function BOLWRICGIA_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('BOLWRICGIA'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('BOLWRICGIA'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('BOLWRICGIA'),e);
}
function NTAYXBDPVY_Valid(e) {
SetActiveField(Ctrl('NTAYXBDPVY'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('pwddaysduration','N',w_pwddaysduration,HtW(Ctrl('NTAYXBDPVY').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_pwddaysduration(HtW(Ctrl('NTAYXBDPVY').value,'N'),null,e);
return l_bSetResult;
}
}
function NTAYXBDPVY_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('NTAYXBDPVY'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('NTAYXBDPVY'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('NTAYXBDPVY'),e);
}
function CLZCOSTIAC_Valid(e) {
SetActiveField(Ctrl('CLZCOSTIAC'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('pwdciclicity','N',w_pwdciclicity,HtW(Ctrl('CLZCOSTIAC').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_pwdciclicity(HtW(Ctrl('CLZCOSTIAC').value,'N'),null,e);
return l_bSetResult;
}
}
function CLZCOSTIAC_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('CLZCOSTIAC'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('CLZCOSTIAC'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('CLZCOSTIAC'),e);
}
function WLRWPELGIS_Valid(e) {
SetActiveField(Ctrl('WLRWPELGIS'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('captchalevel','N',w_captchalevel,HtW(Ctrl('WLRWPELGIS').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_captchalevel(HtW(Ctrl('WLRWPELGIS').value,'N'),null,e);
return l_bSetResult;
}
}
function WLRWPELGIS_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('WLRWPELGIS'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('WLRWPELGIS'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('WLRWPELGIS'),e);
}
function DWGQEAJBOS_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('DWGQEAJBOS'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('DWGQEAJBOS').value=ApplyPictureToDate(Ctrl('DWGQEAJBOS').value,TranslatePicture(datePattern),'DWGQEAJBOS');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('DWGQEAJBOS'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('DWGQEAJBOS');
}
}
}
SetActiveField(Ctrl('DWGQEAJBOS'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('datestart','D',w_datestart,HtW(Ctrl('DWGQEAJBOS').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_datestart(HtW(Ctrl('DWGQEAJBOS').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function DWGQEAJBOS_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('DWGQEAJBOS'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('DWGQEAJBOS',w_datestart,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('DWGQEAJBOS');
SetActiveField(Ctrl('DWGQEAJBOS'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('DWGQEAJBOS'),e);
}
function DWGQEAJBOS_ZOOM_Click() {
LaunchCalendar(Ctrl('DWGQEAJBOS'));
}
function AFHAPKTVTZ_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('AFHAPKTVTZ'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('AFHAPKTVTZ').value=ApplyPictureToDate(Ctrl('AFHAPKTVTZ').value,TranslatePicture(datePattern),'AFHAPKTVTZ');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('AFHAPKTVTZ'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('AFHAPKTVTZ');
}
}
}
SetActiveField(Ctrl('AFHAPKTVTZ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('datestop','D',w_datestop,HtW(Ctrl('AFHAPKTVTZ').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_datestop(HtW(Ctrl('AFHAPKTVTZ').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function AFHAPKTVTZ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('AFHAPKTVTZ'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('AFHAPKTVTZ',w_datestop,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('AFHAPKTVTZ');
SetActiveField(Ctrl('AFHAPKTVTZ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('AFHAPKTVTZ'),e);
}
function AFHAPKTVTZ_ZOOM_Click() {
LaunchCalendar(Ctrl('AFHAPKTVTZ'));
}
function PDERGYRPRJ_Click(el) {
ToggleLayerBox(arguments.length>0 && arguments[0].isConnected?arguments[0]:'PDERGYRPRJ',GetLayerID("durationreq_layer"),'01',false,'ZVNKOIBZTJ_DIV','ZVNKOIBZTJ_HEADER',false)
}
function PKHYFJSKUZ_Click(el) {
ToggleLayerBox(arguments.length>0 && arguments[0].isConnected?arguments[0]:'PKHYFJSKUZ',GetLayerID("ciclicityreq_layer"),'01',false,'ZVNKOIBZTJ_DIV','ZVNKOIBZTJ_HEADER',false)
}
function KXFZJKYRKC_Click(el) {
ToggleLayerBox(arguments.length>0 && arguments[0].isConnected?arguments[0]:'KXFZJKYRKC',GetLayerID("captchareq_layer"),'01',false,'ZVNKOIBZTJ_DIV','ZVNKOIBZTJ_HEADER',false)
}
function BLGCNCYQRJ_Valid(e) {
SetActiveField(Ctrl('BLGCNCYQRJ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('printserver','C',w_printserver,HtW(Ctrl('BLGCNCYQRJ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_printserver(HtW(Ctrl('BLGCNCYQRJ').value,'C'),null,e);
return l_bSetResult;
}
}
function BLGCNCYQRJ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('BLGCNCYQRJ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('BLGCNCYQRJ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('BLGCNCYQRJ'),e);
}
function ZOICKBMQFQ_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('usesiarlicense','C',w_usesiarlicense,ChkboxValueAssign(Ctrl('ZOICKBMQFQ'),'T','F','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_usesiarlicense(ChkboxValueAssign(Ctrl('ZOICKBMQFQ'),'T','F','C',1,0,''),null,e);
return l_bSetResult;
}
}
function ZOICKBMQFQ_OnFocus(e) {
SetActiveField(Ctrl('ZOICKBMQFQ'),true);
}
function ZOICKBMQFQ_OnBlur(e) {
SetActiveField(Ctrl('ZOICKBMQFQ'),false);
}
function XNDAWTQDZS_Valid(e) {
SetActiveField(Ctrl('XNDAWTQDZS'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('selected_group','N',w_selected_group,HtW(Ctrl('XNDAWTQDZS').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_selected_group(HtW(Ctrl('XNDAWTQDZS').value,'N'),null,e);
return l_bSetResult;
}
}
function XNDAWTQDZS_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('XNDAWTQDZS'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('XNDAWTQDZS'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('XNDAWTQDZS'),e);
}
function DUYHIUNXPN_Click() {
if (Ne(w_g_OTPisActive,'N')) {
_modifyandopen(ToResource('../jsp-system/spadministration_users_otp_portlet.jsp'+'?pCode='+URLenc(w_code)+'&m_cParameterSequence=pCode')+'&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null)
}
}
function UOJLIHOZBH_Valid(e) {
SetActiveField(Ctrl('UOJLIHOZBH'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('otp','C',w_otp,HtW(Ctrl('UOJLIHOZBH').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_otp(HtW(Ctrl('UOJLIHOZBH').value,'C'),null,e);
return l_bSetResult;
}
}
function UOJLIHOZBH_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('UOJLIHOZBH'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('UOJLIHOZBH'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('UOJLIHOZBH'),e);
}
function UYGLGETTUT_Valid(e) {
SetActiveField(Ctrl('UYGLGETTUT'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('companies','C',w_companies,HtW(Ctrl('UYGLGETTUT').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_companies(HtW(Ctrl('UYGLGETTUT').value,'C'),null,e);
return l_bSetResult;
}
}
function UYGLGETTUT_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('UYGLGETTUT'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('UYGLGETTUT'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('UYGLGETTUT'),e);
}
function VRCQKXWFPX_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('UFENABLEAZI','C',w_UFENABLEAZI,HtW(getComboValue(Ctrl('VRCQKXWFPX')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_UFENABLEAZI(HtW(getComboValue(Ctrl('VRCQKXWFPX')),'C'),null,e);
return l_bSetResult;
}
}
function VRCQKXWFPX_OnFocus(e) {
SetActiveField(Ctrl('VRCQKXWFPX'),true);
}
function VRCQKXWFPX_OnBlur(e) {
SetActiveField(Ctrl('VRCQKXWFPX'),false);
}
function href_OSVFPWEFJH() {
if (Eq(EntityStatus(),'N') || Eq(w_modifyPassword,1)) {
togglePwdView(1)
}
}
function href_XEGRJMWYIW() {
if (Eq(EntityStatus(),'N') || Eq(w_modifyPassword,1)) {
togglePwdView(2)
}
}
linkpc_url.u('QGNMFELDBT',function(){return 'spadministration_usersgroups?m_bInnerChild=true'+GetLinkPCKeys('spadministration_usersgroups')+'&m_bRowsChild='+EnableChild('spadministration_usersgroups')})
linkpc_url.u('VMCLEJEYGM',function(){return 'spadministration_ssomap_child?m_bInnerChild=true'+GetLinkPCKeys('spadministration_ssomap_child')+'&m_bRowsChild='+EnableChild('spadministration_ssomap_child')})
_ResetTracker();
function setEventHandlers() {
var c;
function ZZKRWOJQTG_wrap_OnClick(event) {
return href_ZZKRWOJQTG();
}
SPBOUILib.SetImageClick('ZZKRWOJQTG',ZZKRWOJQTG_wrap_OnClick);
function ZZKRWOJQTG_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetKeyDown('ZZKRWOJQTG',ZZKRWOJQTG_wrap_OnKeyDown);
function KZXLYHJHAW_wrap_OnClick(event) {
return KZXLYHJHAW_Click(event.srcElement);
}
SPBOUILib.SetButtonClick('KZXLYHJHAW',KZXLYHJHAW_wrap_OnClick);
function OTBBXDQDET_wrap_OnClick(event) {
return href_OTBBXDQDET();
}
SPBOUILib.SetImageClick('OTBBXDQDET',OTBBXDQDET_wrap_OnClick);
function OTBBXDQDET_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetKeyDown('OTBBXDQDET',OTBBXDQDET_wrap_OnKeyDown);
function LCHPBEJNON_wrap_OnClick(event) {
return LCHPBEJNON_Click(event.srcElement);
}
SPBOUILib.SetButtonClick('LCHPBEJNON',LCHPBEJNON_wrap_OnClick);
function PDERGYRPRJ_wrap_OnClick(event) {
return PDERGYRPRJ_Click(event.srcElement);
}
SPBOUILib.SetButtonClick('PDERGYRPRJ',PDERGYRPRJ_wrap_OnClick);
function PKHYFJSKUZ_wrap_OnClick(event) {
return PKHYFJSKUZ_Click(event.srcElement);
}
SPBOUILib.SetButtonClick('PKHYFJSKUZ',PKHYFJSKUZ_wrap_OnClick);
function KXFZJKYRKC_wrap_OnClick(event) {
return KXFZJKYRKC_Click(event.srcElement);
}
SPBOUILib.SetButtonClick('KXFZJKYRKC',KXFZJKYRKC_wrap_OnClick);
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
if (Ne(m_cFunction,'view')) {
function CIUGDDXJMR_wrap_Valid(event) {
return CIUGDDXJMR_Valid(event);
}
SPBOUILib.SetInputExit('CIUGDDXJMR',CIUGDDXJMR_wrap_Valid);
function CIUGDDXJMR_wrap_OnFocus(event) {
return CIUGDDXJMR_OnFocus(event);
}
SPBOUILib.SetInputEnter('CIUGDDXJMR',CIUGDDXJMR_wrap_OnFocus);
function CIUGDDXJMR_wrap_OnKeyPress(event) {
return CIUGDDXJMR_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('CIUGDDXJMR',CIUGDDXJMR_wrap_OnKeyPress);
function CIUGDDXJMR_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('CIUGDDXJMR',CIUGDDXJMR_wrap_OnKeyDown);
function YOMCOSHNCV_wrap_Valid(event) {
return YOMCOSHNCV_Valid(event);
}
SPBOUILib.SetInputExit('YOMCOSHNCV',YOMCOSHNCV_wrap_Valid);
function YOMCOSHNCV_wrap_OnFocus(event) {
return YOMCOSHNCV_OnFocus(event);
}
SPBOUILib.SetInputEnter('YOMCOSHNCV',YOMCOSHNCV_wrap_OnFocus);
function YOMCOSHNCV_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('YOMCOSHNCV',YOMCOSHNCV_wrap_OnKeyDown);
function ZOLPGDGKUC_wrap_Valid(event) {
return ZOLPGDGKUC_Valid(event);
}
SPBOUILib.SetInputExit('ZOLPGDGKUC',ZOLPGDGKUC_wrap_Valid);
function ZOLPGDGKUC_wrap_OnFocus(event) {
return ZOLPGDGKUC_OnFocus(event);
}
SPBOUILib.SetInputEnter('ZOLPGDGKUC',ZOLPGDGKUC_wrap_OnFocus);
function ZOLPGDGKUC_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('ZOLPGDGKUC',ZOLPGDGKUC_wrap_OnKeyDown);
function RGNPWADGHN_wrap_Valid(event) {
return RGNPWADGHN_Valid(event);
}
SPBOUILib.SetCheckboxClick('RGNPWADGHN',RGNPWADGHN_wrap_Valid);
function RGNPWADGHN_wrap_OnFocus(event) {
return RGNPWADGHN_OnFocus(event);
}
SPBOUILib.SetInputEnter('RGNPWADGHN',RGNPWADGHN_wrap_OnFocus);
function RGNPWADGHN_wrap_Blur(event) {
return RGNPWADGHN_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('RGNPWADGHN',RGNPWADGHN_wrap_Blur);
function GZOGXZQGVV_wrap_Valid(event) {
return GZOGXZQGVV_Valid(event);
}
SPBOUILib.SetCheckboxClick('GZOGXZQGVV',GZOGXZQGVV_wrap_Valid);
function GZOGXZQGVV_wrap_OnFocus(event) {
return GZOGXZQGVV_OnFocus(event);
}
SPBOUILib.SetInputEnter('GZOGXZQGVV',GZOGXZQGVV_wrap_OnFocus);
function GZOGXZQGVV_wrap_Blur(event) {
return GZOGXZQGVV_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('GZOGXZQGVV',GZOGXZQGVV_wrap_Blur);
function GSXRFLFMJR_wrap_Valid(event) {
return GSXRFLFMJR_Valid(event);
}
SPBOUILib.SetCheckboxClick('GSXRFLFMJR',GSXRFLFMJR_wrap_Valid);
function GSXRFLFMJR_wrap_OnFocus(event) {
return GSXRFLFMJR_OnFocus(event);
}
SPBOUILib.SetInputEnter('GSXRFLFMJR',GSXRFLFMJR_wrap_OnFocus);
function GSXRFLFMJR_wrap_Blur(event) {
return GSXRFLFMJR_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('GSXRFLFMJR',GSXRFLFMJR_wrap_Blur);
function FTIRRMMSXK_wrap_Valid(event) {
return FTIRRMMSXK_Valid(event);
}
SPBOUILib.SetCheckboxClick('FTIRRMMSXK',FTIRRMMSXK_wrap_Valid);
function FTIRRMMSXK_wrap_OnFocus(event) {
return FTIRRMMSXK_OnFocus(event);
}
SPBOUILib.SetInputEnter('FTIRRMMSXK',FTIRRMMSXK_wrap_OnFocus);
function FTIRRMMSXK_wrap_Blur(event) {
return FTIRRMMSXK_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('FTIRRMMSXK',FTIRRMMSXK_wrap_Blur);
function GMYTSOEEXH_wrap_Valid(event) {
return GMYTSOEEXH_Valid(event);
}
SPBOUILib.SetInputExit('GMYTSOEEXH',GMYTSOEEXH_wrap_Valid);
function GMYTSOEEXH_wrap_OnFocus(event) {
return GMYTSOEEXH_OnFocus(event);
}
SPBOUILib.SetInputEnter('GMYTSOEEXH',GMYTSOEEXH_wrap_OnFocus);
function GMYTSOEEXH_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('GMYTSOEEXH',GMYTSOEEXH_wrap_OnKeyDown);
function KZXLYHJHAW_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('KZXLYHJHAW',KZXLYHJHAW_wrap_OnKeyDown);
function KIBLXEYDCR_wrap_Valid(event) {
return KIBLXEYDCR_Valid(event);
}
SPBOUILib.SetInputExit('KIBLXEYDCR',KIBLXEYDCR_wrap_Valid);
function KIBLXEYDCR_wrap_OnFocus(event) {
return KIBLXEYDCR_OnFocus(event);
}
SPBOUILib.SetInputEnter('KIBLXEYDCR',KIBLXEYDCR_wrap_OnFocus);
function KIBLXEYDCR_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('KIBLXEYDCR',KIBLXEYDCR_wrap_OnKeyDown);
function TBXREXYXIU_wrap_Valid(event) {
return TBXREXYXIU_Valid(event);
}
SPBOUILib.SetInputExit('TBXREXYXIU',TBXREXYXIU_wrap_Valid);
function TBXREXYXIU_wrap_OnFocus(event) {
return TBXREXYXIU_OnFocus(event);
}
SPBOUILib.SetInputEnter('TBXREXYXIU',TBXREXYXIU_wrap_OnFocus);
function TBXREXYXIU_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('TBXREXYXIU',TBXREXYXIU_wrap_OnKeyPress);
function TBXREXYXIU_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('TBXREXYXIU',TBXREXYXIU_wrap_OnKeyDown);
function YDSHUIXYEH_wrap_Valid(event) {
return YDSHUIXYEH_Valid(event);
}
SPBOUILib.SetInputExit('YDSHUIXYEH',YDSHUIXYEH_wrap_Valid);
function YDSHUIXYEH_wrap_OnFocus(event) {
return YDSHUIXYEH_OnFocus(event);
}
SPBOUILib.SetInputEnter('YDSHUIXYEH',YDSHUIXYEH_wrap_OnFocus);
function YDSHUIXYEH_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('YDSHUIXYEH',YDSHUIXYEH_wrap_OnKeyPress);
function YDSHUIXYEH_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('YDSHUIXYEH',YDSHUIXYEH_wrap_OnKeyDown);
function LCHPBEJNON_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('LCHPBEJNON',LCHPBEJNON_wrap_OnKeyDown);
function RRBOVTXUAU_wrap_Valid(event) {
return RRBOVTXUAU_Valid(event);
}
SPBOUILib.SetCheckboxClick('RRBOVTXUAU',RRBOVTXUAU_wrap_Valid);
function RRBOVTXUAU_wrap_OnFocus(event) {
return RRBOVTXUAU_OnFocus(event);
}
SPBOUILib.SetInputEnter('RRBOVTXUAU',RRBOVTXUAU_wrap_OnFocus);
function RRBOVTXUAU_wrap_Blur(event) {
return RRBOVTXUAU_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('RRBOVTXUAU',RRBOVTXUAU_wrap_Blur);
function GNSADWOGKM_wrap_Valid(event) {
return GNSADWOGKM_Valid(event);
}
SPBOUILib.SetCheckboxClick('GNSADWOGKM',GNSADWOGKM_wrap_Valid);
function GNSADWOGKM_wrap_OnFocus(event) {
return GNSADWOGKM_OnFocus(event);
}
SPBOUILib.SetInputEnter('GNSADWOGKM',GNSADWOGKM_wrap_OnFocus);
function GNSADWOGKM_wrap_Blur(event) {
return GNSADWOGKM_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('GNSADWOGKM',GNSADWOGKM_wrap_Blur);
function XFCGDYJJAR_wrap_Valid(event) {
return XFCGDYJJAR_Valid(event);
}
SPBOUILib.SetComboChange('XFCGDYJJAR',XFCGDYJJAR_wrap_Valid);
function XFCGDYJJAR_wrap_OnFocus(event) {
return XFCGDYJJAR_OnFocus(event);
}
SPBOUILib.SetInputEnter('XFCGDYJJAR',XFCGDYJJAR_wrap_OnFocus);
function XFCGDYJJAR_wrap_Blur(event) {
return XFCGDYJJAR_OnBlur(event);
}
SPBOUILib.SetInputExit('XFCGDYJJAR',XFCGDYJJAR_wrap_Blur);
function IZJFQHGQUB_wrap_Valid(event) {
return IZJFQHGQUB_Valid(event);
}
SPBOUILib.SetInputExit('IZJFQHGQUB',IZJFQHGQUB_wrap_Valid);
function IZJFQHGQUB_wrap_OnFocus(event) {
return IZJFQHGQUB_OnFocus(event);
}
SPBOUILib.SetInputEnter('IZJFQHGQUB',IZJFQHGQUB_wrap_OnFocus);
function IZJFQHGQUB_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('IZJFQHGQUB',IZJFQHGQUB_wrap_OnKeyDown);
function ACYLERWDKK_wrap_Valid(event) {
return ACYLERWDKK_Valid(event);
}
SPBOUILib.SetInputExit('ACYLERWDKK',ACYLERWDKK_wrap_Valid);
function ACYLERWDKK_wrap_OnFocus(event) {
return ACYLERWDKK_OnFocus(event);
}
SPBOUILib.SetInputEnter('ACYLERWDKK',ACYLERWDKK_wrap_OnFocus);
function ACYLERWDKK_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('ACYLERWDKK',ACYLERWDKK_wrap_OnKeyDown);
function EVNGTHPGLR_wrap_Valid(event) {
return EVNGTHPGLR_Valid(event);
}
SPBOUILib.SetInputExit('EVNGTHPGLR',EVNGTHPGLR_wrap_Valid);
function EVNGTHPGLR_wrap_OnFocus(event) {
return EVNGTHPGLR_OnFocus(event);
}
SPBOUILib.SetInputEnter('EVNGTHPGLR',EVNGTHPGLR_wrap_OnFocus);
function EVNGTHPGLR_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('EVNGTHPGLR',EVNGTHPGLR_wrap_OnKeyDown);
function BOLWRICGIA_wrap_Valid(event) {
return BOLWRICGIA_Valid(event);
}
SPBOUILib.SetInputExit('BOLWRICGIA',BOLWRICGIA_wrap_Valid);
function BOLWRICGIA_wrap_OnFocus(event) {
return BOLWRICGIA_OnFocus(event);
}
SPBOUILib.SetInputEnter('BOLWRICGIA',BOLWRICGIA_wrap_OnFocus);
function BOLWRICGIA_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('BOLWRICGIA',BOLWRICGIA_wrap_OnKeyDown);
function NTAYXBDPVY_wrap_Valid(event) {
return NTAYXBDPVY_Valid(event);
}
SPBOUILib.SetInputExit('NTAYXBDPVY',NTAYXBDPVY_wrap_Valid);
function NTAYXBDPVY_wrap_OnFocus(event) {
return NTAYXBDPVY_OnFocus(event);
}
SPBOUILib.SetInputEnter('NTAYXBDPVY',NTAYXBDPVY_wrap_OnFocus);
function NTAYXBDPVY_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('NTAYXBDPVY',NTAYXBDPVY_wrap_OnKeyPress);
function NTAYXBDPVY_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('NTAYXBDPVY',NTAYXBDPVY_wrap_OnKeyDown);
function CLZCOSTIAC_wrap_Valid(event) {
return CLZCOSTIAC_Valid(event);
}
SPBOUILib.SetInputExit('CLZCOSTIAC',CLZCOSTIAC_wrap_Valid);
function CLZCOSTIAC_wrap_OnFocus(event) {
return CLZCOSTIAC_OnFocus(event);
}
SPBOUILib.SetInputEnter('CLZCOSTIAC',CLZCOSTIAC_wrap_OnFocus);
function CLZCOSTIAC_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('CLZCOSTIAC',CLZCOSTIAC_wrap_OnKeyPress);
function CLZCOSTIAC_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('CLZCOSTIAC',CLZCOSTIAC_wrap_OnKeyDown);
function WLRWPELGIS_wrap_Valid(event) {
return WLRWPELGIS_Valid(event);
}
SPBOUILib.SetInputExit('WLRWPELGIS',WLRWPELGIS_wrap_Valid);
function WLRWPELGIS_wrap_OnFocus(event) {
return WLRWPELGIS_OnFocus(event);
}
SPBOUILib.SetInputEnter('WLRWPELGIS',WLRWPELGIS_wrap_OnFocus);
function WLRWPELGIS_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('WLRWPELGIS',WLRWPELGIS_wrap_OnKeyPress);
function WLRWPELGIS_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('WLRWPELGIS',WLRWPELGIS_wrap_OnKeyDown);
function DWGQEAJBOS_wrap_Valid(event) {
return DWGQEAJBOS_Valid(event);
}
SPBOUILib.SetInputExit('DWGQEAJBOS',DWGQEAJBOS_wrap_Valid);
function DWGQEAJBOS_wrap_OnFocus(event) {
return DWGQEAJBOS_OnFocus(event);
}
SPBOUILib.SetInputEnter('DWGQEAJBOS',DWGQEAJBOS_wrap_OnFocus);
function DWGQEAJBOS_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('DWGQEAJBOS',DWGQEAJBOS_wrap_OnKeyPress);
function DWGQEAJBOS_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('DWGQEAJBOS',DWGQEAJBOS_wrap_OnKeyDown);
function DWGQEAJBOS_ZOOM_setHandlers() {
function DWGQEAJBOS_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?DWGQEAJBOS_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('DWGQEAJBOS_ZOOM',DWGQEAJBOS_ZOOM_wrap_OnClick);
function DWGQEAJBOS_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('DWGQEAJBOS_ZOOM',DWGQEAJBOS_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('DWGQEAJBOS',DWGQEAJBOS_ZOOM_setHandlers);
function AFHAPKTVTZ_wrap_Valid(event) {
return AFHAPKTVTZ_Valid(event);
}
SPBOUILib.SetInputExit('AFHAPKTVTZ',AFHAPKTVTZ_wrap_Valid);
function AFHAPKTVTZ_wrap_OnFocus(event) {
return AFHAPKTVTZ_OnFocus(event);
}
SPBOUILib.SetInputEnter('AFHAPKTVTZ',AFHAPKTVTZ_wrap_OnFocus);
function AFHAPKTVTZ_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('AFHAPKTVTZ',AFHAPKTVTZ_wrap_OnKeyPress);
function AFHAPKTVTZ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('AFHAPKTVTZ',AFHAPKTVTZ_wrap_OnKeyDown);
function AFHAPKTVTZ_ZOOM_setHandlers() {
function AFHAPKTVTZ_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?AFHAPKTVTZ_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('AFHAPKTVTZ_ZOOM',AFHAPKTVTZ_ZOOM_wrap_OnClick);
function AFHAPKTVTZ_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('AFHAPKTVTZ_ZOOM',AFHAPKTVTZ_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('AFHAPKTVTZ',AFHAPKTVTZ_ZOOM_setHandlers);
function PDERGYRPRJ_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('PDERGYRPRJ',PDERGYRPRJ_wrap_OnKeyDown);
function PKHYFJSKUZ_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('PKHYFJSKUZ',PKHYFJSKUZ_wrap_OnKeyDown);
function KXFZJKYRKC_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('KXFZJKYRKC',KXFZJKYRKC_wrap_OnKeyDown);
function BLGCNCYQRJ_wrap_Valid(event) {
return BLGCNCYQRJ_Valid(event);
}
SPBOUILib.SetInputExit('BLGCNCYQRJ',BLGCNCYQRJ_wrap_Valid);
function BLGCNCYQRJ_wrap_OnFocus(event) {
return BLGCNCYQRJ_OnFocus(event);
}
SPBOUILib.SetInputEnter('BLGCNCYQRJ',BLGCNCYQRJ_wrap_OnFocus);
function BLGCNCYQRJ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('BLGCNCYQRJ',BLGCNCYQRJ_wrap_OnKeyDown);
function ZOICKBMQFQ_wrap_Valid(event) {
return ZOICKBMQFQ_Valid(event);
}
SPBOUILib.SetCheckboxClick('ZOICKBMQFQ',ZOICKBMQFQ_wrap_Valid);
function ZOICKBMQFQ_wrap_OnFocus(event) {
return ZOICKBMQFQ_OnFocus(event);
}
SPBOUILib.SetInputEnter('ZOICKBMQFQ',ZOICKBMQFQ_wrap_OnFocus);
function ZOICKBMQFQ_wrap_Blur(event) {
return ZOICKBMQFQ_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('ZOICKBMQFQ',ZOICKBMQFQ_wrap_Blur);
function XNDAWTQDZS_wrap_Valid(event) {
return XNDAWTQDZS_Valid(event);
}
SPBOUILib.SetInputExit('XNDAWTQDZS',XNDAWTQDZS_wrap_Valid);
function XNDAWTQDZS_wrap_OnFocus(event) {
return XNDAWTQDZS_OnFocus(event);
}
SPBOUILib.SetInputEnter('XNDAWTQDZS',XNDAWTQDZS_wrap_OnFocus);
function XNDAWTQDZS_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('XNDAWTQDZS',XNDAWTQDZS_wrap_OnKeyPress);
function XNDAWTQDZS_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('XNDAWTQDZS',XNDAWTQDZS_wrap_OnKeyDown);
function DUYHIUNXPN_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?DUYHIUNXPN_Click():void(0));
}
SPBOUILib.SetButtonClick('DUYHIUNXPN',DUYHIUNXPN_wrap_OnClick);
function DUYHIUNXPN_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('DUYHIUNXPN',DUYHIUNXPN_wrap_OnKeyDown);
function UOJLIHOZBH_wrap_Valid(event) {
return UOJLIHOZBH_Valid(event);
}
SPBOUILib.SetInputExit('UOJLIHOZBH',UOJLIHOZBH_wrap_Valid);
function UOJLIHOZBH_wrap_OnFocus(event) {
return UOJLIHOZBH_OnFocus(event);
}
SPBOUILib.SetInputEnter('UOJLIHOZBH',UOJLIHOZBH_wrap_OnFocus);
function UOJLIHOZBH_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('UOJLIHOZBH',UOJLIHOZBH_wrap_OnKeyDown);
function UYGLGETTUT_wrap_Valid(event) {
return UYGLGETTUT_Valid(event);
}
SPBOUILib.SetInputExit('UYGLGETTUT',UYGLGETTUT_wrap_Valid);
function UYGLGETTUT_wrap_OnFocus(event) {
return UYGLGETTUT_OnFocus(event);
}
SPBOUILib.SetInputEnter('UYGLGETTUT',UYGLGETTUT_wrap_OnFocus);
function UYGLGETTUT_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('UYGLGETTUT',UYGLGETTUT_wrap_OnKeyDown);
function VRCQKXWFPX_wrap_Valid(event) {
return VRCQKXWFPX_Valid(event);
}
SPBOUILib.SetComboChange('VRCQKXWFPX',VRCQKXWFPX_wrap_Valid);
function VRCQKXWFPX_wrap_OnFocus(event) {
return VRCQKXWFPX_OnFocus(event);
}
SPBOUILib.SetInputEnter('VRCQKXWFPX',VRCQKXWFPX_wrap_OnFocus);
function VRCQKXWFPX_wrap_Blur(event) {
return VRCQKXWFPX_OnBlur(event);
}
SPBOUILib.SetInputExit('VRCQKXWFPX',VRCQKXWFPX_wrap_Blur);
if (m_bExtended) {
SetEventsAndStylesToExtendedFields();
}
}
if (Eq(m_cFunction,'query') && Ne(document.FrmToolbar,null)) {
document.FrmToolbar.pos.onkeypress=RecPositionInput;
document.FrmToolbar.pos.onblur=SelectRecord;
}
}
function NotifyEvent(p_cEvent) {
var old_c;
if (Ne(typeof(w_grdcompanies),'undefined')) {
w_grdcompanies.raiseEvent('spadministration_users_'+Strtran(p_cEvent,' ','_'));
}
}
function SetLastFocusedOnParent() {
// used only in child entities
}
function DoUpdate(p_bResult) {
if (Ne(m_cFunction,'query') && Ne(m_cFunction,'view')) {
Calculate();
SaveDependsOn();
SetControlsValue();
SetDynamicClasses();
SetDynamicTooltip();
EnableControlsUnderCondition();
SaveLabelDependsOn();
}
if ( ! (p_bResult)) {
DisplayErrorMessage();
}
m_nLastError=0;
m_cLastMsgError='';
}
FocusFirstComponent.edit={"page_1":["YOMCOSHNCV"]};
FocusFirstComponent.query={"page_1":["CIUGDDXJMR"]};
FocusFirstComponent.otherwise={"page_1":["CIUGDDXJMR"]};
FocusLayerFirstComponent.Layers['PBZCUWPENC_DIV']='TBXREXYXIU';
FocusLayerFirstComponent.Layers['QTXMMDECZO_DIV']='NTAYXBDPVY';
FocusLayerFirstComponent.Layers['YWYTSWWAZG_DIV']='CLZCOSTIAC';
FocusLayerFirstComponent.Layers['YIYKXFSQJK_DIV']='WLRWPELGIS';
function closeContextMenu_PLMVGNNZCG() {
}
function closeContextMenu_PBZCUWPENC() {
}
function closeContextMenu_QTXMMDECZO() {
}
function closeContextMenu_YWYTSWWAZG() {
}
function closeContextMenu_YIYKXFSQJK() {
}
function Help() {
windowOpenForeground('../doc/spadministration_users_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
}
function CalledBatchEnd() {
if ( ! (m_bCalculating)) {
DoUpdate(true);
}
}
function SetModified_spadministration_usersgroups() {
SetModified();
}
function SetModified_spadministration_ssomap_child() {
SetModified();
}
function LoadChildrenInPage(page,lazy) {
if (Eq(page,'page_1')) {
if (ChildToLoad('QGNMFELDBT')) {
LoadContext.lc(1,'QGNMFELDBT');
} else {
LibJavascript.RefreshChildGrid('QGNMFELDBT');
}
}
if (Eq(page,'page_1')) {
if (ChildToLoad('VMCLEJEYGM')) {
if (Eq(lazy,null) || LibJavascript.UserCanSee('VMCLEJEYGM')) {
LoadContext.lc(1,'VMCLEJEYGM');
}
} else {
LibJavascript.RefreshChildGrid('VMCLEJEYGM');
}
}
}
GetLayerID.Layers.push({"id":"BGMYNICMON","name":"box_BGMYNICMON"});
GetLayerID.Layers.push({"id":"KVIFRCSRUG","name":"box_access"});
GetLayerID.Layers.push({"id":"WUIVVJMUJT","name":"box_WUIVVJMUJT"});
GetLayerID.Layers.push({"id":"PLMVGNNZCG_DIV","name":"pwdratecause_layer"});
GetLayerID.Layers.push({"id":"PBZCUWPENC_DIV","name":"complexityreq_layer"});
GetLayerID.Layers.push({"id":"ZVNKOIBZTJ","name":"pwd_layer"});
GetLayerID.Layers.push({"id":"QTXMMDECZO_DIV","name":"durationreq_layer"});
GetLayerID.Layers.push({"id":"YWYTSWWAZG_DIV","name":"ciclicityreq_layer"});
GetLayerID.Layers.push({"id":"YIYKXFSQJK_DIV","name":"captchareq_layer"});
GetLayerID.Layers.push({"id":"QZSVKXVUQD","name":"language_formatting"});
GetLayerID.Layers.push({"id":"AXCUQKTKCI","name":"box_AXCUQKTKCI"});
GetLayerID.Layers.push({"id":"FLMCUOBXBF","name":"gruppi_appartenenza"});
GetLayerID.Layers.push({"id":"GWZDNNWFFM","name":"companies_hsect"});
function DeclareWVs() {
var a = arguments;
w_code=a[0];
w_fullname=a[1];
w_name=a[2];
w_accesstype_human=a[3];
w_accesstype_service=a[4];
w_accesstype_machine=a[5];
w_pwdcomplexity=a[6];
w_forcepwdchange=a[7];
w_enabled=a[8];
w_language=a[9];
w_decimalseparator=a[10];
w_thousandseparator=a[11];
w_datepattern=a[12];
w_datetimepattern=a[13];
w_pwddaysduration=a[14];
w_pwdciclicity=a[15];
w_captchalevel=a[16];
w_datestart=a[17];
w_datestop=a[18];
w_failedlogins=a[19];
w_lastfailedlogin=a[20];
w_lastsuccessfullogin=a[21];
w_pwdcreate=a[22];
w_printserver=a[23];
w_createdwhen=a[24];
w_usesiarlicense=a[25];
w_companies=a[26];
w_modifyPassword=a[27];
w_pwd1=a[28];
w_calcomplex=a[29];
w_pwdratecause=a[30];
w_pwd2=a[31];
w_pwdcomplexity_group=a[32];
w_pwdcomplexity_reqired=a[33];
w_language_name=a[34];
w_pwddaysduration_group=a[35];
w_pwdciclicity_groups=a[36];
w_pwdcaptchalevel_group=a[37];
w_pwddaysduration_applied=a[38];
w_pwdciclicity_applied=a[39];
w_pwdcaptchalevel_applied=a[40];
w_init_code=a[41];
w_pwd_modified=a[42];
w_IAR_LICENSE_VALID=a[43];
w_IAR_LICENSES=a[44];
w_IAR_USED=a[45];
w_IAR_AVAILABLE=a[46];
w_selected_group=a[47];
w_g_OTPisActive=a[48];
w_otp=a[49];
w_UFENABLEAZI=a[50];
w_pwd1_view=a[51];
w_pwd2_view=a[52];
m_ospadministration_historypwd=null;
m_ospadministration_usercompanies=null;
o_AXCUQKTKCI_expand=null;
m_cWv_spadministration_usersgroups=a[53];
m_cWv_spadministration_ssomap_child=a[54];
m_cWv_spadministration_historypwd=a[55];
m_cWv_spadministration_usercompanies=a[56];
if (Gt(a.length,57)) {
m_cErrorInChild='';
}
if (Gt(a.length,57)) {
o_code=w_code;
o_modifyPassword=w_modifyPassword;
o_pwd1=w_pwd1;
o_pwd2=w_pwd2;
o_pwddaysduration_group=w_pwddaysduration_group;
o_pwddaysduration=w_pwddaysduration;
o_pwdciclicity_groups=w_pwdciclicity_groups;
o_pwdciclicity=w_pwdciclicity;
o_pwdcaptchalevel_group=w_pwdcaptchalevel_group;
o_captchalevel=w_captchalevel;
o_selected_group=w_selected_group;
o_companies=w_companies;
o_UFENABLEAZI=w_UFENABLEAZI;
}
m_PrimaryKeys=['code'];
}
function i_PrimaryKey() {
return 'cpusers'+'\\'+CPLib.ToCPStr(w_code);
}
GetLinkPCKeys.set_o('spadministration_usersgroups',false);
GetLinkPCKeys.set_o('spadministration_ssomap_child',false);
GetLinkPCKeys.set_o('spadministration_historypwd',false);
GetLinkPCKeys.set_o('spadministration_usercompanies',false);
GetLinkPCKeys.o['spadministration_usersgroups']['usercode']=function(t){
if (Ne(m_cFunction,'new')) {
return t(w_code,'N');
}
}
GetLinkPCKeys.o['spadministration_ssomap_child']['userid']=function(t){
if (Ne(m_cFunction,'new')) {
return t(w_code,'N');
}
}
GetLinkPCKeys.o['spadministration_historypwd']['code']=function(t){
if (Ne(m_cFunction,'new')) {
return t(w_code,'N');
}
}
GetLinkPCKeys.o['spadministration_usercompanies']['usercode']=function(t){
if (Ne(m_cFunction,'new')) {
return t(w_code,'N');
}
}
resizeChildIframe.children['spadministration_usersgroups']=true;
function EnableChild(name) {
var l_bRes = false;
return l_bRes;
}
function CheckZone(me) {
return true;
}
LoadContext.f('QGNMFELDBT',function(){return FrameRef('spadministration_usersgroups')},1,'spadministration_usersgroups',1,1)
LoadContext.f('VMCLEJEYGM',function(){return FrameRef('spadministration_ssomap_child')},1,'spadministration_ssomap_child',0,1)
GetSelectedChildPage.child={'spadministration_usersgroups': function(){return FrameRef('spadministration_usersgroups')}, 'spadministration_ssomap_child': function(){return FrameRef('spadministration_ssomap_child')}}
function GetSelectedPage(p_d) {
p_d.setValue('spadministration_users',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
function LinkZoomExtendedMenu() {
}
_Obli('code',1,'CIUGDDXJMR',false,"960685589")
_Obli('fullname',0,'YOMCOSHNCV',false,"11595652979")
_Obli('name',0,'ZOLPGDGKUC',true,"1682105886")
_Obli('accesstype_human',4,'RGNPWADGHN',false,"122177958")
_Obli('accesstype_service',4,'GZOGXZQGVV',false,"11173517738")
_Obli('accesstype_machine',4,'GSXRFLFMJR',false,"10989948426")
_Obli('modifyPassword',1,'FTIRRMMSXK',false)
_Obli('pwd1',0,'GMYTSOEEXH',false,"11183930016")
_Obli('companies',0,'UYGLGETTUT',false,"11068993370")
_Obli('datestart',2,'DWGQEAJBOS',false,"20009153")
_Obli('pwd2',0,'KIBLXEYDCR',false,"983832109")
_Obli('pwdcomplexity_group',1,'TBXREXYXIU',false,"11873255554")
_Obli('pwdcomplexity',1,'YDSHUIXYEH',false,"11873255554")
_Obli('datestop',2,'AFHAPKTVTZ',false,"556515051")
_Obli('forcepwdchange',4,'RRBOVTXUAU',false,"65259300")
_Obli('enabled',0,'GNSADWOGKM',false,"10556996636")
_Obli('language',0,'XFCGDYJJAR',false,"1725844287")
_Obli('captchalevel',1,'WLRWPELGIS',false,"10075957577")
_Obli('decimalseparator',0,'IZJFQHGQUB',false)
_Obli('thousandseparator',0,'ACYLERWDKK',false)
_Obli('datepattern',0,'EVNGTHPGLR',false,"10992262541")
_Obli('datetimepattern',0,'BOLWRICGIA',false,"11086835527")
_Obli('usesiarlicense',0,'ZOICKBMQFQ',false,"11958389719")
_Obli('pwddaysduration',1,'NTAYXBDPVY',false,"1076819334")
_Obli('otp',0,'UOJLIHOZBH',false)
_Obli('pwdciclicity',1,'CLZCOSTIAC',false,"11641847591")
_Obli('UFENABLEAZI',0,'VRCQKXWFPX',false,"11586272425")
_Obli('printserver',0,'BLGCNCYQRJ',false,"753676303")
_Obli('selected_group',1,'XNDAWTQDZS',false)
