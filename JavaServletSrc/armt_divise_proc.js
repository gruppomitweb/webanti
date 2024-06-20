function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('TFYVTTXWGC',function(){return WtH(w_CODVAL,'C',3,0,'')},w_CODVAL);
SPBOUILib.SetInputValue('ZYHJVBTPJC',function(){return WtH(w_DESCRI,'C',30,0,'')},w_DESCRI);
SPBOUILib.SetInputValue('AMXBVBDMMZ',function(){return WtH(w_SIMBOLO,'C',3,0,'')},w_SIMBOLO);
SPBOUILib.SetInputValue('ITDBZZXLXR',function(){return WtH(w_ISO,'C',3,0,'')},w_ISO);
if (m_bExtended) {
SetExtensions();
}
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay('YORQOIOBQN_DIV',IsHiddenByStateDriver('box_YORQOIOBQN'));
LibJavascript.forEachItem(m_FoundlingHideExpression,i_body_2)
function i_body_2(child){
child();
}
HideUI();
}
HideUI.lblids["CODVAL"]=['NKBPCIWRSA'];
HideUI.lblids["DESCRI"]=['CVMPDCSPVK'];
HideUI.lblids["ISO"]=['OMDQBBWWNW'];
HideUI.lblids["SIMBOLO"]=['TKAOBJYNPE'];
function TFYVTTXWGC_Valid(e) {
SetActiveField(Ctrl('TFYVTTXWGC'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('TFYVTTXWGC') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('CODVAL','C',w_CODVAL,HtW(Ctrl('TFYVTTXWGC').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODVAL(HtW(Ctrl('TFYVTTXWGC').value,'C'),null,e);
return l_bSetResult;
}
}
function TFYVTTXWGC_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('TFYVTTXWGC'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('TFYVTTXWGC'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('TFYVTTXWGC'),e);
}
function ZYHJVBTPJC_Valid(e) {
SetActiveField(Ctrl('ZYHJVBTPJC'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DESCRI','C',w_DESCRI,HtW(Ctrl('ZYHJVBTPJC').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DESCRI(HtW(Ctrl('ZYHJVBTPJC').value,'C'),null,e);
return l_bSetResult;
}
}
function ZYHJVBTPJC_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ZYHJVBTPJC'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('ZYHJVBTPJC'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ZYHJVBTPJC'),e);
}
function AMXBVBDMMZ_Valid(e) {
SetActiveField(Ctrl('AMXBVBDMMZ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('SIMBOLO','C',w_SIMBOLO,HtW(Ctrl('AMXBVBDMMZ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_SIMBOLO(HtW(Ctrl('AMXBVBDMMZ').value,'C'),null,e);
return l_bSetResult;
}
}
function AMXBVBDMMZ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('AMXBVBDMMZ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('AMXBVBDMMZ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('AMXBVBDMMZ'),e);
}
function ITDBZZXLXR_Valid(e) {
SetActiveField(Ctrl('ITDBZZXLXR'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('ISO','C',w_ISO,HtW(Ctrl('ITDBZZXLXR').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ISO(HtW(Ctrl('ITDBZZXLXR').value,'C'),null,e);
return l_bSetResult;
}
}
function ITDBZZXLXR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ITDBZZXLXR'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('ITDBZZXLXR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ITDBZZXLXR'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function TFYVTTXWGC_wrap_Valid(event) {
return TFYVTTXWGC_Valid(event);
}
SPBOUILib.SetInputExit('TFYVTTXWGC',TFYVTTXWGC_wrap_Valid);
function TFYVTTXWGC_wrap_OnFocus(event) {
return TFYVTTXWGC_OnFocus(event);
}
SPBOUILib.SetInputEnter('TFYVTTXWGC',TFYVTTXWGC_wrap_OnFocus);
function TFYVTTXWGC_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('TFYVTTXWGC',TFYVTTXWGC_wrap_OnKeyDown);
function ZYHJVBTPJC_wrap_Valid(event) {
return ZYHJVBTPJC_Valid(event);
}
SPBOUILib.SetInputExit('ZYHJVBTPJC',ZYHJVBTPJC_wrap_Valid);
function ZYHJVBTPJC_wrap_OnFocus(event) {
return ZYHJVBTPJC_OnFocus(event);
}
SPBOUILib.SetInputEnter('ZYHJVBTPJC',ZYHJVBTPJC_wrap_OnFocus);
function ZYHJVBTPJC_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('ZYHJVBTPJC',ZYHJVBTPJC_wrap_OnKeyDown);
function AMXBVBDMMZ_wrap_Valid(event) {
return AMXBVBDMMZ_Valid(event);
}
SPBOUILib.SetInputExit('AMXBVBDMMZ',AMXBVBDMMZ_wrap_Valid);
function AMXBVBDMMZ_wrap_OnFocus(event) {
return AMXBVBDMMZ_OnFocus(event);
}
SPBOUILib.SetInputEnter('AMXBVBDMMZ',AMXBVBDMMZ_wrap_OnFocus);
function AMXBVBDMMZ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('AMXBVBDMMZ',AMXBVBDMMZ_wrap_OnKeyDown);
function ITDBZZXLXR_wrap_Valid(event) {
return ITDBZZXLXR_Valid(event);
}
SPBOUILib.SetInputExit('ITDBZZXLXR',ITDBZZXLXR_wrap_Valid);
function ITDBZZXLXR_wrap_OnFocus(event) {
return ITDBZZXLXR_OnFocus(event);
}
SPBOUILib.SetInputEnter('ITDBZZXLXR',ITDBZZXLXR_wrap_OnFocus);
function ITDBZZXLXR_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('ITDBZZXLXR',ITDBZZXLXR_wrap_OnKeyDown);
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
FocusFirstComponent.edit={"page_1":["ZYHJVBTPJC"]};
FocusFirstComponent.query={"page_1":["TFYVTTXWGC"]};
FocusFirstComponent.otherwise={"page_1":["TFYVTTXWGC"]};
function Help() {
windowOpenForeground('../doc/armt_divise_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_CODVAL=a[0];
w_DESCRI=a[1];
w_SIMBOLO=a[2];
w_ISO=a[3];
m_PrimaryKeys=['CODVAL'];
}
function i_PrimaryKey() {
return 'tbvalute'+'\\'+CPLib.ToCPStr(w_CODVAL);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('armt_divise',m_cSelectedPage);
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
_Obli('CODVAL',0,'TFYVTTXWGC',false,"112851763")
_Obli('DESCRI',0,'ZYHJVBTPJC',false,"285808099")
_Obli('SIMBOLO',0,'AMXBVBDMMZ',false,"1983222755")
_Obli('ISO',0,'ITDBZZXLXR',false)
