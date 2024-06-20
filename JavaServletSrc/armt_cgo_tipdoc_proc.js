function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('UZYCBNGKAF',function(){return WtH(w_TIPDOC,'C',2,0,'')},w_TIPDOC);
SPBOUILib.SetInputValue('LQAMKFKRGQ',function(){return WtH(w_DESCRI,'C',30,0,'')},w_DESCRI);
SPBOUILib.SetInputValue('WYPHZRRMGV',function(){return WtH(w_AUIDOC,'C',2,0,'')},w_AUIDOC);
SPBOUILib.SetInputValue('RGQHLJWUDB',function(){return WtH(w_xDESAUI,'C',30,0,'')},w_xDESAUI);
SPBOUILib.SetInputValue('ZBLQZMCQSQ',function(){return WtH(w_DISANNIMIN,'N',2,0,'')},w_DISANNIMIN);
SPBOUILib.SetInputValue('SCVXMYQYIE',function(){return WtH(w_DISANNIMAX,'N',2,0,'')},w_DISANNIMAX);
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
HideUI.lblids["AUIDOC"]=['YWZSAHPUTQ'];
HideUI.lblids["DESCRI"]=['PHRWRIONIJ'];
HideUI.lblids["DISANNIMAX"]=['UYWOZMRGSO'];
HideUI.lblids["DISANNIMIN"]=['ABRRPNTPRU'];
HideUI.lblids["TIPDOC"]=['WHIORQWGET'];
HideUI.lblids["xDESAUI"]=['OWMOOHYQLG'];
function UZYCBNGKAF_Valid(e) {
SetActiveField(Ctrl('UZYCBNGKAF'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('UZYCBNGKAF') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('TIPDOC','C',w_TIPDOC,HtW(Ctrl('UZYCBNGKAF').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TIPDOC(HtW(Ctrl('UZYCBNGKAF').value,'C'),null,e);
return l_bSetResult;
}
}
function UZYCBNGKAF_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('UZYCBNGKAF'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('UZYCBNGKAF'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('UZYCBNGKAF'),e);
}
function LQAMKFKRGQ_Valid(e) {
SetActiveField(Ctrl('LQAMKFKRGQ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DESCRI','C',w_DESCRI,HtW(Ctrl('LQAMKFKRGQ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DESCRI(HtW(Ctrl('LQAMKFKRGQ').value,'C'),null,e);
return l_bSetResult;
}
}
function LQAMKFKRGQ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('LQAMKFKRGQ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('LQAMKFKRGQ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('LQAMKFKRGQ'),e);
}
function WYPHZRRMGV_Valid(e) {
SetActiveField(Ctrl('WYPHZRRMGV'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('AUIDOC','C',w_AUIDOC,HtW(Ctrl('WYPHZRRMGV').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_AUIDOC(HtW(Ctrl('WYPHZRRMGV').value,'C'),null,e);
return l_bSetResult;
}
}
function WYPHZRRMGV_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('WYPHZRRMGV'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('WYPHZRRMGV'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('WYPHZRRMGV'),e);
}
function WYPHZRRMGV_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('WYPHZRRMGV')),'linkview_WYPHZRRMGV','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function ZBLQZMCQSQ_Valid(e) {
SetActiveField(Ctrl('ZBLQZMCQSQ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DISANNIMIN','N',w_DISANNIMIN,HtW(Ctrl('ZBLQZMCQSQ').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DISANNIMIN(HtW(Ctrl('ZBLQZMCQSQ').value,'N'),null,e);
return l_bSetResult;
}
}
function ZBLQZMCQSQ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ZBLQZMCQSQ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('ZBLQZMCQSQ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ZBLQZMCQSQ'),e);
}
function SCVXMYQYIE_Valid(e) {
SetActiveField(Ctrl('SCVXMYQYIE'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DISANNIMAX','N',w_DISANNIMAX,HtW(Ctrl('SCVXMYQYIE').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DISANNIMAX(HtW(Ctrl('SCVXMYQYIE').value,'N'),null,e);
return l_bSetResult;
}
}
function SCVXMYQYIE_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('SCVXMYQYIE'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('SCVXMYQYIE'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('SCVXMYQYIE'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function UZYCBNGKAF_wrap_Valid(event) {
return UZYCBNGKAF_Valid(event);
}
SPBOUILib.SetInputExit('UZYCBNGKAF',UZYCBNGKAF_wrap_Valid);
function UZYCBNGKAF_wrap_OnFocus(event) {
return UZYCBNGKAF_OnFocus(event);
}
SPBOUILib.SetInputEnter('UZYCBNGKAF',UZYCBNGKAF_wrap_OnFocus);
function UZYCBNGKAF_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('UZYCBNGKAF',UZYCBNGKAF_wrap_OnKeyDown);
function LQAMKFKRGQ_wrap_Valid(event) {
return LQAMKFKRGQ_Valid(event);
}
SPBOUILib.SetInputExit('LQAMKFKRGQ',LQAMKFKRGQ_wrap_Valid);
function LQAMKFKRGQ_wrap_OnFocus(event) {
return LQAMKFKRGQ_OnFocus(event);
}
SPBOUILib.SetInputEnter('LQAMKFKRGQ',LQAMKFKRGQ_wrap_OnFocus);
function LQAMKFKRGQ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('LQAMKFKRGQ',LQAMKFKRGQ_wrap_OnKeyDown);
function WYPHZRRMGV_wrap_Valid(event) {
return WYPHZRRMGV_Valid(event);
}
SPBOUILib.SetInputExit('WYPHZRRMGV',WYPHZRRMGV_wrap_Valid);
function WYPHZRRMGV_wrap_OnFocus(event) {
return WYPHZRRMGV_OnFocus(event);
}
SPBOUILib.SetInputEnter('WYPHZRRMGV',WYPHZRRMGV_wrap_OnFocus);
function WYPHZRRMGV_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('WYPHZRRMGV',WYPHZRRMGV_wrap_OnKeyDown);
function WYPHZRRMGV_ZOOM_setHandlers() {
function WYPHZRRMGV_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?WYPHZRRMGV_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('WYPHZRRMGV_ZOOM',WYPHZRRMGV_ZOOM_wrap_OnClick);
function WYPHZRRMGV_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('WYPHZRRMGV_ZOOM',WYPHZRRMGV_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('WYPHZRRMGV',WYPHZRRMGV_ZOOM_setHandlers);
function ZBLQZMCQSQ_wrap_Valid(event) {
return ZBLQZMCQSQ_Valid(event);
}
SPBOUILib.SetInputExit('ZBLQZMCQSQ',ZBLQZMCQSQ_wrap_Valid);
function ZBLQZMCQSQ_wrap_OnFocus(event) {
return ZBLQZMCQSQ_OnFocus(event);
}
SPBOUILib.SetInputEnter('ZBLQZMCQSQ',ZBLQZMCQSQ_wrap_OnFocus);
function ZBLQZMCQSQ_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('ZBLQZMCQSQ',ZBLQZMCQSQ_wrap_OnKeyPress);
function ZBLQZMCQSQ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('ZBLQZMCQSQ',ZBLQZMCQSQ_wrap_OnKeyDown);
function SCVXMYQYIE_wrap_Valid(event) {
return SCVXMYQYIE_Valid(event);
}
SPBOUILib.SetInputExit('SCVXMYQYIE',SCVXMYQYIE_wrap_Valid);
function SCVXMYQYIE_wrap_OnFocus(event) {
return SCVXMYQYIE_OnFocus(event);
}
SPBOUILib.SetInputEnter('SCVXMYQYIE',SCVXMYQYIE_wrap_OnFocus);
function SCVXMYQYIE_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('SCVXMYQYIE',SCVXMYQYIE_wrap_OnKeyPress);
function SCVXMYQYIE_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('SCVXMYQYIE',SCVXMYQYIE_wrap_OnKeyDown);
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
FocusFirstComponent.edit={"page_1":["LQAMKFKRGQ"]};
FocusFirstComponent.query={"page_1":["UZYCBNGKAF"]};
FocusFirstComponent.otherwise={"page_1":["UZYCBNGKAF"]};
function Help() {
windowOpenForeground('../doc/armt_cgo_tipdoc_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_TIPDOC=a[0];
w_DESCRI=a[1];
w_AUIDOC=a[2];
w_DISANNIMIN=a[3];
w_DISANNIMAX=a[4];
w_xDESAUI=a[5];
m_PrimaryKeys=['TIPDOC'];
}
function i_PrimaryKey() {
return 'cgo_tipdoc'+'\\'+CPLib.ToCPStr(w_TIPDOC);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('armt_cgo_tipdoc',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
function LinkZoomExtendedMenu() {
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_AUIDOC,'C'); },"field":"TIPDOC","type":"C"},{"expression":function() { return WtA(w_xDESAUI,'C'); },"field":"DESCRI","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbtipdoc','C'),"uid":"WYPHZRRMGV"});
}
_Obli('TIPDOC',0,'UZYCBNGKAF',false,"112851763")
_Obli('DESCRI',0,'LQAMKFKRGQ',false,"285808099")
_Obli('AUIDOC',0,'WYPHZRRMGV',false,"918159384")
_Obli('DISANNIMIN',1,'ZBLQZMCQSQ',false,"10624727500")
_Obli('DISANNIMAX',1,'SCVXMYQYIE',false,"10613742028")
