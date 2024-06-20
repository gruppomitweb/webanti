function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('TGRCYWSFQA',function(){return WtH(w_ANNO,'C',4,0,'')},w_ANNO);
if(c=Ctrl('BTKJJRZUIH')) selectCombo(c,w_SEMESTRE,'C')
if(c=Ctrl('CZSLGJMHXK')) ChkboxCheckUncheck(c,'S',w_FLGINVIATO)
if(c=Ctrl('CZSLGJMHXK')) ChkboxValueAssign(c,'S','N','C',1,0,'')
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
HideUI.lblids["ANNO"]=['RHRTCXBDSD'];
HideUI.lblids["SEMESTRE"]=['YYLKMNKCUQ'];
function ExpandCollapseBoxesUnderCondition() {
var cond;
}
function TGRCYWSFQA_Valid(e) {
SetActiveField(Ctrl('TGRCYWSFQA'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('TGRCYWSFQA') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('ANNO','C',w_ANNO,HtW(Ctrl('TGRCYWSFQA').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ANNO(HtW(Ctrl('TGRCYWSFQA').value,'C'),null,e);
return l_bSetResult;
}
}
function TGRCYWSFQA_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('TGRCYWSFQA'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('TGRCYWSFQA'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('TGRCYWSFQA'),e);
}
function BTKJJRZUIH_Valid(e) {
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('BTKJJRZUIH') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('SEMESTRE','C',w_SEMESTRE,HtW(getComboValue(Ctrl('BTKJJRZUIH')),'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_SEMESTRE(HtW(getComboValue(Ctrl('BTKJJRZUIH')),'C'),null,e);
return l_bSetResult;
}
}
function BTKJJRZUIH_OnFocus(e) {
SetActiveField(Ctrl('BTKJJRZUIH'),true);
}
function BTKJJRZUIH_OnBlur(e) {
SetActiveField(Ctrl('BTKJJRZUIH'),false);
}
linkpc_url.u('HAJWCHKQNX',function(){return 'ardt_dettaglioa7?m_bInnerChild=true'+GetLinkPCKeys('ardt_dettaglioa7')+'&m_bRowsChild='+EnableChild('ardt_dettaglioa7')})
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function TGRCYWSFQA_wrap_Valid(event) {
return TGRCYWSFQA_Valid(event);
}
SPBOUILib.SetInputExit('TGRCYWSFQA',TGRCYWSFQA_wrap_Valid);
function TGRCYWSFQA_wrap_OnFocus(event) {
return TGRCYWSFQA_OnFocus(event);
}
SPBOUILib.SetInputEnter('TGRCYWSFQA',TGRCYWSFQA_wrap_OnFocus);
function TGRCYWSFQA_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('TGRCYWSFQA',TGRCYWSFQA_wrap_OnKeyDown);
function BTKJJRZUIH_wrap_Valid(event) {
return BTKJJRZUIH_Valid(event);
}
SPBOUILib.SetComboChange('BTKJJRZUIH',BTKJJRZUIH_wrap_Valid);
function BTKJJRZUIH_wrap_OnFocus(event) {
return BTKJJRZUIH_OnFocus(event);
}
SPBOUILib.SetInputEnter('BTKJJRZUIH',BTKJJRZUIH_wrap_OnFocus);
function BTKJJRZUIH_wrap_Blur(event) {
return BTKJJRZUIH_OnBlur(event);
}
SPBOUILib.SetInputExit('BTKJJRZUIH',BTKJJRZUIH_wrap_Blur);
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
FocusFirstComponent.edit={};
FocusFirstComponent.query={"page_1":["TGRCYWSFQA"]};
FocusFirstComponent.otherwise={"page_1":["TGRCYWSFQA"]};
function Help() {
windowOpenForeground('../doc/armt_basea7_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
}
function CalledBatchEnd() {
if ( ! (m_bCalculating)) {
DoUpdate(true);
}
}
function SetModified_ardt_dettaglioa7() {
SetModified();
}
function LoadChildrenInPage(page,lazy) {
if (Eq(page,'page_1')) {
if (ChildToLoad('HAJWCHKQNX')) {
LoadContext.lc(1,'HAJWCHKQNX');
} else {
LibJavascript.RefreshChildGrid('HAJWCHKQNX');
}
}
}
function DeclareWVs() {
var a = arguments;
w_ANNO=a[0];
w_SEMESTRE=a[1];
w_FLGINVIATO=a[2];
m_cWv_ardt_dettaglioa7=a[3];
if (Gt(a.length,4)) {
m_cErrorInChild='';
}
m_PrimaryKeys=['SEMESTRE','ANNO'];
}
function i_PrimaryKey() {
return 'basea7'+'\\'+CPLib.ToCPStr(w_ANNO)+'\\'+CPLib.ToCPStr(w_SEMESTRE);
}
GetLinkPCKeys.set_o('ardt_dettaglioa7',false);
GetLinkPCKeys.o['ardt_dettaglioa7']['ANNO']=function(t){
if (Ne(m_cFunction,'new')) {
return t(w_ANNO,'C');
}
}
GetLinkPCKeys.o['ardt_dettaglioa7']['SEMESTRE']=function(t){
if (Ne(m_cFunction,'new')) {
return t(w_SEMESTRE,'C');
}
}
resizeChildIframe.children['ardt_dettaglioa7']=true;
function EnableChild(name) {
var l_bRes = false;
return l_bRes;
}
function CheckZone(me) {
return true;
}
LoadContext.f('HAJWCHKQNX',function(){return FrameRef('ardt_dettaglioa7')},1,'ardt_dettaglioa7',1,1)
GetSelectedChildPage.child={'ardt_dettaglioa7': function(){return FrameRef('ardt_dettaglioa7')}}
function GetSelectedPage(p_d) {
p_d.setValue('armt_basea7',m_cSelectedPage);
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
_Obli('ANNO',0,'TGRCYWSFQA',false,"484641")
_Obli('SEMESTRE',0,'BTKJJRZUIH',false,"10910572637")
