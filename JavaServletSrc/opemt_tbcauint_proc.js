function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('SGWBXGCVUI',function(){return WtH(w_CICODICE,'N',5,0,'99999')},w_CICODICE);
SPBOUILib.SetInputValue('XBRPBVBUVX',function(){return WtH(w_CICAUCOD,'C',4,0,'')},w_CICAUCOD);
SPBOUILib.SetInputValue('WEFPSBXRML',function(){return WtH(w_CIFINALIT,'C',50,0,'')},w_CIFINALIT);
SPBOUILib.SetInputValue('UEAGDUQRMM',function(){return WtH(w_CIRISCHIO,'N',3,0,'999')},w_CIRISCHIO);
var tmp_TVLAIKDPUU = ToHTag(AsControlValue(w_xdesccausale));
if (Ne(e_TVLAIKDPUU,tmp_TVLAIKDPUU)) {
SPBOUILib.SetLabelValue('TVLAIKDPUU','innerHTML',tmp_TVLAIKDPUU);
e_TVLAIKDPUU=tmp_TVLAIKDPUU;
}
if (m_bExtended) {
SetExtensions();
}
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
LibJavascript.forEachItem(m_FoundlingHideExpression,i_body_2)
function i_body_2(child){
child();
}
HideUI();
}
HideUI.lblids["CICAUCOD"]=['JMMFHTXXEC'];
HideUI.lblids["CICODICE"]=['VVREMQXBDU'];
HideUI.lblids["CIFINALIT"]=['LIFMFTSJTV'];
HideUI.lblids["CIRISCHIO"]=['RTGLYHCSWM'];
function SGWBXGCVUI_Valid(e) {
SetActiveField(Ctrl('SGWBXGCVUI'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('SGWBXGCVUI') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('CICODICE','N',w_CICODICE,HtW(Ctrl('SGWBXGCVUI').value,'N'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CICODICE(HtW(Ctrl('SGWBXGCVUI').value,'N'),null,e);
return l_bSetResult;
}
}
function SGWBXGCVUI_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('SGWBXGCVUI'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('SGWBXGCVUI',w_CICODICE,'N',5,0,'99999');
SetActiveField(Ctrl('SGWBXGCVUI'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('SGWBXGCVUI'),e);
}
function SGWBXGCVUI_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("99999"));
}
function XBRPBVBUVX_Valid(e) {
SetActiveField(Ctrl('XBRPBVBUVX'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CICAUCOD','C',w_CICAUCOD,HtW(Ctrl('XBRPBVBUVX').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CICAUCOD(HtW(Ctrl('XBRPBVBUVX').value,'C'),null,e);
return l_bSetResult;
}
}
function XBRPBVBUVX_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('XBRPBVBUVX'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('XBRPBVBUVX'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('XBRPBVBUVX'),e);
}
function XBRPBVBUVX_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('XBRPBVBUVX')),'linkview_XBRPBVBUVX','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function WEFPSBXRML_Valid(e) {
SetActiveField(Ctrl('WEFPSBXRML'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CIFINALIT','C',w_CIFINALIT,HtW(Ctrl('WEFPSBXRML').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CIFINALIT(HtW(Ctrl('WEFPSBXRML').value,'C'),null,e);
return l_bSetResult;
}
}
function WEFPSBXRML_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('WEFPSBXRML'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('WEFPSBXRML'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('WEFPSBXRML'),e);
}
function UEAGDUQRMM_Valid(e) {
SetActiveField(Ctrl('UEAGDUQRMM'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CIRISCHIO','N',w_CIRISCHIO,HtW(Ctrl('UEAGDUQRMM').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CIRISCHIO(HtW(Ctrl('UEAGDUQRMM').value,'N'),null,e);
return l_bSetResult;
}
}
function UEAGDUQRMM_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('UEAGDUQRMM'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('UEAGDUQRMM',w_CIRISCHIO,'N',3,0,'999');
SetActiveField(Ctrl('UEAGDUQRMM'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('UEAGDUQRMM'),e);
}
function UEAGDUQRMM_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("999"));
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function SGWBXGCVUI_wrap_Valid(event) {
return SGWBXGCVUI_Valid(event);
}
SPBOUILib.SetInputExit('SGWBXGCVUI',SGWBXGCVUI_wrap_Valid);
function SGWBXGCVUI_wrap_OnFocus(event) {
return SGWBXGCVUI_OnFocus(event);
}
SPBOUILib.SetInputEnter('SGWBXGCVUI',SGWBXGCVUI_wrap_OnFocus);
function SGWBXGCVUI_wrap_OnKeyPress(event) {
return SGWBXGCVUI_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('SGWBXGCVUI',SGWBXGCVUI_wrap_OnKeyPress);
function SGWBXGCVUI_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('SGWBXGCVUI',SGWBXGCVUI_wrap_OnKeyDown);
function XBRPBVBUVX_wrap_Valid(event) {
return XBRPBVBUVX_Valid(event);
}
SPBOUILib.SetInputExit('XBRPBVBUVX',XBRPBVBUVX_wrap_Valid);
function XBRPBVBUVX_wrap_OnFocus(event) {
return XBRPBVBUVX_OnFocus(event);
}
SPBOUILib.SetInputEnter('XBRPBVBUVX',XBRPBVBUVX_wrap_OnFocus);
function XBRPBVBUVX_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('XBRPBVBUVX',XBRPBVBUVX_wrap_OnKeyDown);
function XBRPBVBUVX_ZOOM_setHandlers() {
function XBRPBVBUVX_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?XBRPBVBUVX_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('XBRPBVBUVX_ZOOM',XBRPBVBUVX_ZOOM_wrap_OnClick);
function XBRPBVBUVX_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('XBRPBVBUVX_ZOOM',XBRPBVBUVX_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('XBRPBVBUVX',XBRPBVBUVX_ZOOM_setHandlers);
function WEFPSBXRML_wrap_Valid(event) {
return WEFPSBXRML_Valid(event);
}
SPBOUILib.SetInputExit('WEFPSBXRML',WEFPSBXRML_wrap_Valid);
function WEFPSBXRML_wrap_OnFocus(event) {
return WEFPSBXRML_OnFocus(event);
}
SPBOUILib.SetInputEnter('WEFPSBXRML',WEFPSBXRML_wrap_OnFocus);
function WEFPSBXRML_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('WEFPSBXRML',WEFPSBXRML_wrap_OnKeyDown);
function UEAGDUQRMM_wrap_Valid(event) {
return UEAGDUQRMM_Valid(event);
}
SPBOUILib.SetInputExit('UEAGDUQRMM',UEAGDUQRMM_wrap_Valid);
function UEAGDUQRMM_wrap_OnFocus(event) {
return UEAGDUQRMM_OnFocus(event);
}
SPBOUILib.SetInputEnter('UEAGDUQRMM',UEAGDUQRMM_wrap_OnFocus);
function UEAGDUQRMM_wrap_OnKeyPress(event) {
return UEAGDUQRMM_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('UEAGDUQRMM',UEAGDUQRMM_wrap_OnKeyPress);
function UEAGDUQRMM_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('UEAGDUQRMM',UEAGDUQRMM_wrap_OnKeyDown);
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
FocusFirstComponent.edit={"page_1":["XBRPBVBUVX"]};
FocusFirstComponent.query={"page_1":["SGWBXGCVUI"]};
FocusFirstComponent.otherwise={"page_1":["SGWBXGCVUI"]};
function Help() {
windowOpenForeground('../doc/opemt_tbcauint_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_CICODICE=a[0];
op_CICODICE=a[1];
w_CICAUCOD=a[2];
w_CIFINALIT=a[3];
w_CIRISCHIO=a[4];
w_gIntemediario=a[5];
w_TIPOOPER=a[6];
w_xdesccausale=a[7];
op_codazi=a[8];
if (Gt(a.length,9)) {
o_gIntemediario=w_gIntemediario;
o_CICAUCOD=w_CICAUCOD;
}
m_PrimaryKeys=['CICODICE'];
}
function i_PrimaryKey() {
return 'tbcauint'+'\\'+CPLib.ToCPStr(w_CICODICE);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('opemt_tbcauint',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
function LinkZoomExtendedMenu() {
ExtendedMenu({"configName":WtA('','C'),"entityName":WtA('opemd_tiplegbo','C'),"fldValues":[{"expression":function() { return WtA(w_CICAUCOD,'C'); },"field":"TIPOPERAZ","type":"C"}],"keyValues":[{"expression":function() { return WtA(w_TIPOOPER,'C'); },"field":"TIPLEG","type":"C"}],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tipilegbo','C'),"uid":"XBRPBVBUVX"});
}
_Obli('CICODICE',1,'SGWBXGCVUI',false,"112851763")
_Obli('CICAUCOD',0,'XBRPBVBUVX',false,"1814604627")
_Obli('CICAUCOD',0,'ADZLHSFLMZ',false,"1814604627")
_Obli('CIFINALIT',0,'WEFPSBXRML',false,"12106991307")
_Obli('CIRISCHIO',1,'UEAGDUQRMM',false,"1701044225")
