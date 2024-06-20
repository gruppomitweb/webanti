function FillCombosValues() {
FillCombo('REJVNADODM','REJVNADODM');
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('DDYZMQMXQA',function(){return WtH(w_code,'C',10,0,'')},w_code);
if(c=Ctrl('DMCIAQQTSV')) ChkboxCheckUncheck(c,'S',w_autologin)
if(c=Ctrl('DMCIAQQTSV')) ChkboxValueAssign(c,'S','N','C',1,0,'')
SPBOUILib.SetInputValue('YVFVLNIHTZ',function(){return WtH(w_idp_name,'C',50,0,'')},w_idp_name);
if(c=Ctrl('REJVNADODM')) selectCombo(c,w_protocol,'C')
SPBOUILib.SetInputValue('ALVFXOFWZD',function(){return WtH(w_client_id,'M',10,0,'')},w_client_id);
SPBOUILib.SetInputValue('QBZZBCTPGR',function(){return WtH(w_client_secret,'C',300,0,'')},w_client_secret);
SPBOUILib.SetInputValue('VKCMWSSTIV',function(){return WtH(w_redirect_uri,'M',10,0,'')},w_redirect_uri);
SPBOUILib.SetInputValue('TGJZUBGGYK',function(){return WtH(w_scope,'C',50,0,'')},w_scope);
SPBOUILib.SetInputValue('KMSNRRLAKF',function(){return WtH(w_auth_uri,'M',10,0,'')},w_auth_uri);
SPBOUILib.SetInputValue('MCHBYAADDU',function(){return WtH(w_token_uri,'M',10,0,'')},w_token_uri);
SPBOUILib.SetInputValue('QGIOZABHHB',function(){return WtH(w_jwks_uri,'M',10,0,'')},w_jwks_uri);
if(c=Ctrl('UPNIOVOHTB')) ChkboxCheckUncheck(c,'S',w_mutual_jwks)
if(c=Ctrl('UPNIOVOHTB')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if (m_bExtended) {
SetExtensions();
}
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
Z.Tabs.Get("tabs_1_protocol_details").Hide('UDDMFJXDQC',Ne(w_protocol,'oidc') || IsHiddenByStateDriver('oidc'));
LibJavascript.forEachItem(m_FoundlingHideExpression,i_body_2)
function i_body_2(child){
child();
}
HideUI();
}
HideUI.lblids["auth_uri"]=['MCTSITODKL'];
HideUI.lblids["client_id"]=['HRGBHAGZDV'];
HideUI.lblids["client_secret"]=['IOSDTNEZKK'];
HideUI.lblids["code"]=['ZLYEVNLKFG'];
HideUI.lblids["idp_name"]=['LYZSTPLMZY'];
HideUI.lblids["jwks_uri"]=['FRKNZVDVKW'];
HideUI.lblids["protocol"]=['VCKBVFPINK'];
HideUI.lblids["redirect_uri"]=['YUPUTVCMFN'];
HideUI.lblids["scope"]=['QWJNZLKAIO'];
HideUI.lblids["token_uri"]=['SHJLXQXDLB'];
function ExpandCollapseBoxesUnderCondition() {
var cond;
}
function DDYZMQMXQA_Valid(e) {
SetActiveField(Ctrl('DDYZMQMXQA'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('DDYZMQMXQA') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('code','C',w_code,HtW(Ctrl('DDYZMQMXQA').value,'C'),m_bQueryOnLatestKeyOnly);
}
}
}
function DDYZMQMXQA_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('DDYZMQMXQA'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('DDYZMQMXQA'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('DDYZMQMXQA'),e);
}
function DMCIAQQTSV_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('autologin','C',w_autologin,ChkboxValueAssign(Ctrl('DMCIAQQTSV'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_autologin(ChkboxValueAssign(Ctrl('DMCIAQQTSV'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function DMCIAQQTSV_OnFocus(e) {
SetActiveField(Ctrl('DMCIAQQTSV'),true);
}
function DMCIAQQTSV_OnBlur(e) {
SetActiveField(Ctrl('DMCIAQQTSV'),false);
}
function YVFVLNIHTZ_Valid(e) {
SetActiveField(Ctrl('YVFVLNIHTZ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('idp_name','C',w_idp_name,HtW(Ctrl('YVFVLNIHTZ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_idp_name(HtW(Ctrl('YVFVLNIHTZ').value,'C'),null,e);
return l_bSetResult;
}
}
function YVFVLNIHTZ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('YVFVLNIHTZ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('YVFVLNIHTZ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('YVFVLNIHTZ'),e);
}
function REJVNADODM_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('protocol','C',w_protocol,HtW(getComboValue(Ctrl('REJVNADODM')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_protocol(HtW(getComboValue(Ctrl('REJVNADODM')),'C'),null,e);
return l_bSetResult;
}
}
function REJVNADODM_OnFocus(e) {
SetActiveField(Ctrl('REJVNADODM'),true);
}
function REJVNADODM_OnBlur(e) {
SetActiveField(Ctrl('REJVNADODM'),false);
}
function ALVFXOFWZD_Valid(e) {
SetActiveField(Ctrl('ALVFXOFWZD'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('client_id','M',w_client_id,HtW(Ctrl('ALVFXOFWZD').value,'M'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_client_id(HtW(Ctrl('ALVFXOFWZD').value,'M'),null,e);
return l_bSetResult;
}
}
function ALVFXOFWZD_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ALVFXOFWZD'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('ALVFXOFWZD'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ALVFXOFWZD'),e);
}
function QBZZBCTPGR_Valid(e) {
SetActiveField(Ctrl('QBZZBCTPGR'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('client_secret','C',w_client_secret,HtW(Ctrl('QBZZBCTPGR').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_client_secret(HtW(Ctrl('QBZZBCTPGR').value,'C'),null,e);
return l_bSetResult;
}
}
function QBZZBCTPGR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('QBZZBCTPGR'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('QBZZBCTPGR',w_client_secret,'C',300,0,'');
SetActiveField(Ctrl('QBZZBCTPGR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('QBZZBCTPGR'),e);
}
function QBZZBCTPGR_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("*"));
}
function VKCMWSSTIV_Valid(e) {
SetActiveField(Ctrl('VKCMWSSTIV'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('redirect_uri','M',w_redirect_uri,HtW(Ctrl('VKCMWSSTIV').value,'M'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_redirect_uri(HtW(Ctrl('VKCMWSSTIV').value,'M'),null,e);
return l_bSetResult;
}
}
function VKCMWSSTIV_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('VKCMWSSTIV'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('VKCMWSSTIV'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('VKCMWSSTIV'),e);
}
function TGJZUBGGYK_Valid(e) {
SetActiveField(Ctrl('TGJZUBGGYK'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('scope','C',w_scope,HtW(Ctrl('TGJZUBGGYK').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_scope(HtW(Ctrl('TGJZUBGGYK').value,'C'),null,e);
return l_bSetResult;
}
}
function TGJZUBGGYK_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('TGJZUBGGYK'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('TGJZUBGGYK'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('TGJZUBGGYK'),e);
}
function KMSNRRLAKF_Valid(e) {
SetActiveField(Ctrl('KMSNRRLAKF'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('auth_uri','M',w_auth_uri,HtW(Ctrl('KMSNRRLAKF').value,'M'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_auth_uri(HtW(Ctrl('KMSNRRLAKF').value,'M'),null,e);
return l_bSetResult;
}
}
function KMSNRRLAKF_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('KMSNRRLAKF'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('KMSNRRLAKF'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('KMSNRRLAKF'),e);
}
function MCHBYAADDU_Valid(e) {
SetActiveField(Ctrl('MCHBYAADDU'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('token_uri','M',w_token_uri,HtW(Ctrl('MCHBYAADDU').value,'M'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_token_uri(HtW(Ctrl('MCHBYAADDU').value,'M'),null,e);
return l_bSetResult;
}
}
function MCHBYAADDU_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('MCHBYAADDU'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('MCHBYAADDU'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('MCHBYAADDU'),e);
}
function QGIOZABHHB_Valid(e) {
SetActiveField(Ctrl('QGIOZABHHB'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('jwks_uri','M',w_jwks_uri,HtW(Ctrl('QGIOZABHHB').value,'M'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_jwks_uri(HtW(Ctrl('QGIOZABHHB').value,'M'),null,e);
return l_bSetResult;
}
}
function QGIOZABHHB_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('QGIOZABHHB'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('QGIOZABHHB'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('QGIOZABHHB'),e);
}
function UPNIOVOHTB_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('mutual_jwks','C',w_mutual_jwks,ChkboxValueAssign(Ctrl('UPNIOVOHTB'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_mutual_jwks(ChkboxValueAssign(Ctrl('UPNIOVOHTB'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function UPNIOVOHTB_OnFocus(e) {
SetActiveField(Ctrl('UPNIOVOHTB'),true);
}
function UPNIOVOHTB_OnBlur(e) {
SetActiveField(Ctrl('UPNIOVOHTB'),false);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function DDYZMQMXQA_wrap_Valid(event) {
return DDYZMQMXQA_Valid(event);
}
SPBOUILib.SetInputExit('DDYZMQMXQA',DDYZMQMXQA_wrap_Valid);
function DDYZMQMXQA_wrap_OnFocus(event) {
return DDYZMQMXQA_OnFocus(event);
}
SPBOUILib.SetInputEnter('DDYZMQMXQA',DDYZMQMXQA_wrap_OnFocus);
function DDYZMQMXQA_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('DDYZMQMXQA',DDYZMQMXQA_wrap_OnKeyDown);
function DMCIAQQTSV_wrap_Valid(event) {
return DMCIAQQTSV_Valid(event);
}
SPBOUILib.SetCheckboxClick('DMCIAQQTSV',DMCIAQQTSV_wrap_Valid);
function DMCIAQQTSV_wrap_OnFocus(event) {
return DMCIAQQTSV_OnFocus(event);
}
SPBOUILib.SetInputEnter('DMCIAQQTSV',DMCIAQQTSV_wrap_OnFocus);
function DMCIAQQTSV_wrap_Blur(event) {
return DMCIAQQTSV_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('DMCIAQQTSV',DMCIAQQTSV_wrap_Blur);
function YVFVLNIHTZ_wrap_Valid(event) {
return YVFVLNIHTZ_Valid(event);
}
SPBOUILib.SetInputExit('YVFVLNIHTZ',YVFVLNIHTZ_wrap_Valid);
function YVFVLNIHTZ_wrap_OnFocus(event) {
return YVFVLNIHTZ_OnFocus(event);
}
SPBOUILib.SetInputEnter('YVFVLNIHTZ',YVFVLNIHTZ_wrap_OnFocus);
function YVFVLNIHTZ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('YVFVLNIHTZ',YVFVLNIHTZ_wrap_OnKeyDown);
function REJVNADODM_wrap_Valid(event) {
return REJVNADODM_Valid(event);
}
SPBOUILib.SetComboChange('REJVNADODM',REJVNADODM_wrap_Valid);
function REJVNADODM_wrap_OnFocus(event) {
return REJVNADODM_OnFocus(event);
}
SPBOUILib.SetInputEnter('REJVNADODM',REJVNADODM_wrap_OnFocus);
function REJVNADODM_wrap_Blur(event) {
return REJVNADODM_OnBlur(event);
}
SPBOUILib.SetInputExit('REJVNADODM',REJVNADODM_wrap_Blur);
function ALVFXOFWZD_wrap_Valid(event) {
return ALVFXOFWZD_Valid(event);
}
SPBOUILib.SetInputExit('ALVFXOFWZD',ALVFXOFWZD_wrap_Valid);
function ALVFXOFWZD_wrap_OnFocus(event) {
return ALVFXOFWZD_OnFocus(event);
}
SPBOUILib.SetInputEnter('ALVFXOFWZD',ALVFXOFWZD_wrap_OnFocus);
function QBZZBCTPGR_wrap_Valid(event) {
return QBZZBCTPGR_Valid(event);
}
SPBOUILib.SetInputExit('QBZZBCTPGR',QBZZBCTPGR_wrap_Valid);
function QBZZBCTPGR_wrap_OnFocus(event) {
return QBZZBCTPGR_OnFocus(event);
}
SPBOUILib.SetInputEnter('QBZZBCTPGR',QBZZBCTPGR_wrap_OnFocus);
function QBZZBCTPGR_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('QBZZBCTPGR',QBZZBCTPGR_wrap_OnKeyDown);
function VKCMWSSTIV_wrap_Valid(event) {
return VKCMWSSTIV_Valid(event);
}
SPBOUILib.SetInputExit('VKCMWSSTIV',VKCMWSSTIV_wrap_Valid);
function VKCMWSSTIV_wrap_OnFocus(event) {
return VKCMWSSTIV_OnFocus(event);
}
SPBOUILib.SetInputEnter('VKCMWSSTIV',VKCMWSSTIV_wrap_OnFocus);
function TGJZUBGGYK_wrap_Valid(event) {
return TGJZUBGGYK_Valid(event);
}
SPBOUILib.SetInputExit('TGJZUBGGYK',TGJZUBGGYK_wrap_Valid);
function TGJZUBGGYK_wrap_OnFocus(event) {
return TGJZUBGGYK_OnFocus(event);
}
SPBOUILib.SetInputEnter('TGJZUBGGYK',TGJZUBGGYK_wrap_OnFocus);
function TGJZUBGGYK_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('TGJZUBGGYK',TGJZUBGGYK_wrap_OnKeyDown);
function KMSNRRLAKF_wrap_Valid(event) {
return KMSNRRLAKF_Valid(event);
}
SPBOUILib.SetInputExit('KMSNRRLAKF',KMSNRRLAKF_wrap_Valid);
function KMSNRRLAKF_wrap_OnFocus(event) {
return KMSNRRLAKF_OnFocus(event);
}
SPBOUILib.SetInputEnter('KMSNRRLAKF',KMSNRRLAKF_wrap_OnFocus);
function MCHBYAADDU_wrap_Valid(event) {
return MCHBYAADDU_Valid(event);
}
SPBOUILib.SetInputExit('MCHBYAADDU',MCHBYAADDU_wrap_Valid);
function MCHBYAADDU_wrap_OnFocus(event) {
return MCHBYAADDU_OnFocus(event);
}
SPBOUILib.SetInputEnter('MCHBYAADDU',MCHBYAADDU_wrap_OnFocus);
function QGIOZABHHB_wrap_Valid(event) {
return QGIOZABHHB_Valid(event);
}
SPBOUILib.SetInputExit('QGIOZABHHB',QGIOZABHHB_wrap_Valid);
function QGIOZABHHB_wrap_OnFocus(event) {
return QGIOZABHHB_OnFocus(event);
}
SPBOUILib.SetInputEnter('QGIOZABHHB',QGIOZABHHB_wrap_OnFocus);
function UPNIOVOHTB_wrap_Valid(event) {
return UPNIOVOHTB_Valid(event);
}
SPBOUILib.SetCheckboxClick('UPNIOVOHTB',UPNIOVOHTB_wrap_Valid);
function UPNIOVOHTB_wrap_OnFocus(event) {
return UPNIOVOHTB_OnFocus(event);
}
SPBOUILib.SetInputEnter('UPNIOVOHTB',UPNIOVOHTB_wrap_OnFocus);
function UPNIOVOHTB_wrap_Blur(event) {
return UPNIOVOHTB_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('UPNIOVOHTB',UPNIOVOHTB_wrap_Blur);
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
FocusFirstComponent.edit={"page_1":["DMCIAQQTSV"]};
FocusFirstComponent.query={"page_1":["DDYZMQMXQA","DMCIAQQTSV"]};
FocusFirstComponent.otherwise={"page_1":["DMCIAQQTSV"]};
function Help() {
windowOpenForeground('../doc/spauthid_identity_provider_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
}
function CalledBatchEnd() {
if ( ! (m_bCalculating)) {
DoUpdate(true);
}
}
function LoadChildrenInPage(page,lazy) {
}
GetLayerID.Layers.push({"id":"UDDMFJXDQC","name":"oidc"});
function DeclareWVs() {
var a = arguments;
w_code=a[0];
op_code=a[1];
w_autologin=a[2];
w_idp_name=a[3];
w_protocol=a[4];
w_client_id=a[5];
w_client_secret=a[6];
w_redirect_uri=a[7];
w_scope=a[8];
w_auth_uri=a[9];
w_token_uri=a[10];
w_jwks_uri=a[11];
w_mutual_jwks=a[12];
m_PrimaryKeys=['code'];
}
function i_PrimaryKey() {
return 'spauthid_identity_provider'+'\\'+CPLib.ToCPStr(w_code);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('spauthid_identity_provider',m_cSelectedPage);
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
_Obli('client_secret',0,'QBZZBCTPGR',false,"128747939")
_Obli('autologin',0,'DMCIAQQTSV',false,"11775259103")
_Obli('idp_name',0,'YVFVLNIHTZ',false,"443454")
_Obli('protocol',0,'REJVNADODM',false,"900120012")
_Obli('client_id',0,'ALVFXOFWZD',false,"11212891065")
_Obli('auth_uri',0,'KMSNRRLAKF',false,"12012521349")
_Obli('redirect_uri',0,'VKCMWSSTIV',false,"11446125038")
_Obli('scope',0,'TGJZUBGGYK',false,"7107971")
_Obli('token_uri',0,'MCHBYAADDU',false,"2004140685")
_Obli('jwks_uri',0,'QGIOZABHHB',false,"10411589958")
_Obli('mutual_jwks',0,'UPNIOVOHTB',false,"1441552043")
