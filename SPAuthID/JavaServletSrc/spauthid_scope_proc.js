function FillCombosValues() {
FillCombo('IKGDURKQEO','IKGDURKQEO');
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('VAXPDZFXPZ',function(){return WtH(w_name,'C',50,0,'')},w_name);
SPBOUILib.SetInputValue('MQNCEFZYRU',function(){return WtH(w_description,'C',50,0,'')},w_description);
if(c=Ctrl('IKGDURKQEO')) selectCombo(c,w_protocol,'C')
if (m_bExtended) {
SetExtensions();
}
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
Z.Tabs.Get("tabs_1_maintab").Hide('KCLLZJFOCE',IsHiddenByStateDriver('Mapper associati allo Scope'));
LibJavascript.forEachItem(m_FoundlingHideExpression,i_body_2)
function i_body_2(child){
child();
}
HideUI();
}
HideUI.lblids["description"]=['OOTLNYJLOX'];
HideUI.lblids["name"]=['GUELEGNPEA'];
HideUI.lblids["protocol"]=['MQAVFDWRDC'];
function ExpandCollapseBoxesUnderCondition() {
var cond;
}
function VAXPDZFXPZ_Valid(e) {
SetActiveField(Ctrl('VAXPDZFXPZ'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('VAXPDZFXPZ') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('name','C',w_name,HtW(Ctrl('VAXPDZFXPZ').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_name(HtW(Ctrl('VAXPDZFXPZ').value,'C'),null,e);
return l_bSetResult;
}
}
function VAXPDZFXPZ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('VAXPDZFXPZ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('VAXPDZFXPZ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('VAXPDZFXPZ'),e);
}
function MQNCEFZYRU_Valid(e) {
SetActiveField(Ctrl('MQNCEFZYRU'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('description','C',w_description,HtW(Ctrl('MQNCEFZYRU').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_description(HtW(Ctrl('MQNCEFZYRU').value,'C'),null,e);
return l_bSetResult;
}
}
function MQNCEFZYRU_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('MQNCEFZYRU'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('MQNCEFZYRU'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('MQNCEFZYRU'),e);
}
function IKGDURKQEO_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('protocol','C',w_protocol,HtW(getComboValue(Ctrl('IKGDURKQEO')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_protocol(HtW(getComboValue(Ctrl('IKGDURKQEO')),'C'),null,e);
return l_bSetResult;
}
}
function IKGDURKQEO_OnFocus(e) {
SetActiveField(Ctrl('IKGDURKQEO'),true);
}
function IKGDURKQEO_OnBlur(e) {
SetActiveField(Ctrl('IKGDURKQEO'),false);
}
linkpc_url.u('FVVCLCQSMS',function(){return 'spauthid_scope_mapper?m_bInnerChild=true'+GetLinkPCKeys('spauthid_scope_mapper')+'&m_bRowsChild='+EnableChild('spauthid_scope_mapper')})
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function VAXPDZFXPZ_wrap_Valid(event) {
return VAXPDZFXPZ_Valid(event);
}
SPBOUILib.SetInputExit('VAXPDZFXPZ',VAXPDZFXPZ_wrap_Valid);
function VAXPDZFXPZ_wrap_OnFocus(event) {
return VAXPDZFXPZ_OnFocus(event);
}
SPBOUILib.SetInputEnter('VAXPDZFXPZ',VAXPDZFXPZ_wrap_OnFocus);
function VAXPDZFXPZ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('VAXPDZFXPZ',VAXPDZFXPZ_wrap_OnKeyDown);
function MQNCEFZYRU_wrap_Valid(event) {
return MQNCEFZYRU_Valid(event);
}
SPBOUILib.SetInputExit('MQNCEFZYRU',MQNCEFZYRU_wrap_Valid);
function MQNCEFZYRU_wrap_OnFocus(event) {
return MQNCEFZYRU_OnFocus(event);
}
SPBOUILib.SetInputEnter('MQNCEFZYRU',MQNCEFZYRU_wrap_OnFocus);
function MQNCEFZYRU_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('MQNCEFZYRU',MQNCEFZYRU_wrap_OnKeyDown);
function IKGDURKQEO_wrap_Valid(event) {
return IKGDURKQEO_Valid(event);
}
SPBOUILib.SetComboChange('IKGDURKQEO',IKGDURKQEO_wrap_Valid);
function IKGDURKQEO_wrap_OnFocus(event) {
return IKGDURKQEO_OnFocus(event);
}
SPBOUILib.SetInputEnter('IKGDURKQEO',IKGDURKQEO_wrap_OnFocus);
function IKGDURKQEO_wrap_Blur(event) {
return IKGDURKQEO_OnBlur(event);
}
SPBOUILib.SetInputExit('IKGDURKQEO',IKGDURKQEO_wrap_Blur);
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
FocusFirstComponent.edit={"page_1":["MQNCEFZYRU"]};
FocusFirstComponent.query={"page_1":["VAXPDZFXPZ"]};
FocusFirstComponent.otherwise={"page_1":["VAXPDZFXPZ"]};
function Help() {
windowOpenForeground('../doc/spauthid_scope_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
}
function CalledBatchEnd() {
if ( ! (m_bCalculating)) {
DoUpdate(true);
}
}
function SetModified_spauthid_scope_mapper() {
SetModified();
}
function LoadChildrenInPage(page,lazy) {
if (Eq(page,'page_1')) {
if (ChildToLoad('FVVCLCQSMS')) {
LoadContext.lc(1,'FVVCLCQSMS');
} else {
LibJavascript.RefreshChildGrid('FVVCLCQSMS');
}
}
}
GetLayerID.Layers.push({"id":"KCLLZJFOCE","name":"Mapper associati allo Scope"});
function DeclareWVs() {
var a = arguments;
w_name=a[0];
w_description=a[1];
w_protocol=a[2];
m_cWv_spauthid_scope_mapper=a[3];
if (Gt(a.length,4)) {
m_cErrorInChild='';
}
m_PrimaryKeys=['name'];
}
function i_PrimaryKey() {
return 'spauthid_scope'+'\\'+CPLib.ToCPStr(w_name);
}
GetLinkPCKeys.set_o('spauthid_scope_mapper',false);
GetLinkPCKeys.o['spauthid_scope_mapper']['scope_name']=function(t){
if (Ne(m_cFunction,'new')) {
return t(w_name,'C');
}
}
resizeChildIframe.children['spauthid_scope_mapper']=true;
function EnableChild(name) {
var l_bRes = false;
return l_bRes;
}
function CheckZone(me) {
return true;
}
LoadContext.f('FVVCLCQSMS',function(){return FrameRef('spauthid_scope_mapper')},1,'spauthid_scope_mapper',1,1)
GetSelectedChildPage.child={'spauthid_scope_mapper': function(){return FrameRef('spauthid_scope_mapper')}}
function GetSelectedPage(p_d) {
p_d.setValue('spauthid_scope',m_cSelectedPage);
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
_Obli('name',0,'VAXPDZFXPZ',false,"443454")
_Obli('description',0,'MQNCEFZYRU',false,"285808099")
_Obli('protocol',0,'IKGDURKQEO',false,"900120012")
