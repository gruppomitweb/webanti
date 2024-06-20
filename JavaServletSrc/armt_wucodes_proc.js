function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('WXGOCNXMMY',function(){return WtH(w_WUCODSTA,'C',3,0,'')},w_WUCODSTA);
SPBOUILib.SetInputValue('QNVZYIVBZB',function(){return WtH(w_WUDESCRI,'C',70,0,'')},w_WUDESCRI);
SPBOUILib.SetInputValue('JRJGWESTVE',function(){return WtH(w_WUCODUIF,'C',3,0,'')},w_WUCODUIF);
var tmp_JKTDOFMWFL = ToHTag(AsControlValue(w_xDESCRI));
if (Ne(e_JKTDOFMWFL,tmp_JKTDOFMWFL)) {
SPBOUILib.SetLabelValue('JKTDOFMWFL','innerHTML',tmp_JKTDOFMWFL);
e_JKTDOFMWFL=tmp_JKTDOFMWFL;
}
SPBOUILib.SetInputValue('RYRRYSUJBK',function(){return WtH(w_WUCODISO,'C',5,0,'')},w_WUCODISO);
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
HideUI.lblids["WUCODISO"]=['WSCLTZNWPS'];
HideUI.lblids["WUCODSTA"]=['OZNDYYDBLY'];
HideUI.lblids["WUCODUIF"]=['SGGIOYRKTN'];
HideUI.lblids["WUDESCRI"]=['FQFUYMCBDC'];
function WXGOCNXMMY_Valid(e) {
SetActiveField(Ctrl('WXGOCNXMMY'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('WXGOCNXMMY') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('WUCODSTA','C',w_WUCODSTA,HtW(Ctrl('WXGOCNXMMY').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_WUCODSTA(HtW(Ctrl('WXGOCNXMMY').value,'C'),null,e);
return l_bSetResult;
}
}
function WXGOCNXMMY_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('WXGOCNXMMY'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('WXGOCNXMMY'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('WXGOCNXMMY'),e);
}
function QNVZYIVBZB_Valid(e) {
SetActiveField(Ctrl('QNVZYIVBZB'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('WUDESCRI','C',w_WUDESCRI,HtW(Ctrl('QNVZYIVBZB').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_WUDESCRI(HtW(Ctrl('QNVZYIVBZB').value,'C'),null,e);
return l_bSetResult;
}
}
function QNVZYIVBZB_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('QNVZYIVBZB'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('QNVZYIVBZB'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('QNVZYIVBZB'),e);
}
function JRJGWESTVE_Valid(e) {
SetActiveField(Ctrl('JRJGWESTVE'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('WUCODUIF','C',w_WUCODUIF,HtW(Ctrl('JRJGWESTVE').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_WUCODUIF(HtW(Ctrl('JRJGWESTVE').value,'C'),null,e);
return l_bSetResult;
}
}
function JRJGWESTVE_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('JRJGWESTVE'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('JRJGWESTVE'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('JRJGWESTVE'),e);
}
function JRJGWESTVE_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('JRJGWESTVE')),'linkview_JRJGWESTVE','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function RYRRYSUJBK_Valid(e) {
SetActiveField(Ctrl('RYRRYSUJBK'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('WUCODISO','C',w_WUCODISO,HtW(Ctrl('RYRRYSUJBK').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_WUCODISO(HtW(Ctrl('RYRRYSUJBK').value,'C'),null,e);
return l_bSetResult;
}
}
function RYRRYSUJBK_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('RYRRYSUJBK'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('RYRRYSUJBK'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('RYRRYSUJBK'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function WXGOCNXMMY_wrap_Valid(event) {
return WXGOCNXMMY_Valid(event);
}
SPBOUILib.SetInputExit('WXGOCNXMMY',WXGOCNXMMY_wrap_Valid);
function WXGOCNXMMY_wrap_OnFocus(event) {
return WXGOCNXMMY_OnFocus(event);
}
SPBOUILib.SetInputEnter('WXGOCNXMMY',WXGOCNXMMY_wrap_OnFocus);
function WXGOCNXMMY_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('WXGOCNXMMY',WXGOCNXMMY_wrap_OnKeyDown);
function QNVZYIVBZB_wrap_Valid(event) {
return QNVZYIVBZB_Valid(event);
}
SPBOUILib.SetInputExit('QNVZYIVBZB',QNVZYIVBZB_wrap_Valid);
function QNVZYIVBZB_wrap_OnFocus(event) {
return QNVZYIVBZB_OnFocus(event);
}
SPBOUILib.SetInputEnter('QNVZYIVBZB',QNVZYIVBZB_wrap_OnFocus);
function QNVZYIVBZB_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('QNVZYIVBZB',QNVZYIVBZB_wrap_OnKeyDown);
function JRJGWESTVE_wrap_Valid(event) {
return JRJGWESTVE_Valid(event);
}
SPBOUILib.SetInputExit('JRJGWESTVE',JRJGWESTVE_wrap_Valid);
function JRJGWESTVE_wrap_OnFocus(event) {
return JRJGWESTVE_OnFocus(event);
}
SPBOUILib.SetInputEnter('JRJGWESTVE',JRJGWESTVE_wrap_OnFocus);
function JRJGWESTVE_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('JRJGWESTVE',JRJGWESTVE_wrap_OnKeyDown);
function JRJGWESTVE_ZOOM_setHandlers() {
function JRJGWESTVE_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?JRJGWESTVE_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('JRJGWESTVE_ZOOM',JRJGWESTVE_ZOOM_wrap_OnClick);
function JRJGWESTVE_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('JRJGWESTVE_ZOOM',JRJGWESTVE_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('JRJGWESTVE',JRJGWESTVE_ZOOM_setHandlers);
function RYRRYSUJBK_wrap_Valid(event) {
return RYRRYSUJBK_Valid(event);
}
SPBOUILib.SetInputExit('RYRRYSUJBK',RYRRYSUJBK_wrap_Valid);
function RYRRYSUJBK_wrap_OnFocus(event) {
return RYRRYSUJBK_OnFocus(event);
}
SPBOUILib.SetInputEnter('RYRRYSUJBK',RYRRYSUJBK_wrap_OnFocus);
function RYRRYSUJBK_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('RYRRYSUJBK',RYRRYSUJBK_wrap_OnKeyDown);
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
FocusFirstComponent.edit={"page_1":["QNVZYIVBZB"]};
FocusFirstComponent.query={"page_1":["WXGOCNXMMY"]};
FocusFirstComponent.otherwise={"page_1":["WXGOCNXMMY"]};
function Help() {
windowOpenForeground('../doc/armt_wucodes_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_WUCODSTA=a[0];
w_WUDESCRI=a[1];
w_WUCODUIF=a[2];
w_WUCODISO=a[3];
w_xDESCRI=a[4];
m_PrimaryKeys=['WUCODSTA'];
}
function i_PrimaryKey() {
return 'wucodes'+'\\'+CPLib.ToCPStr(w_WUCODSTA);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('armt_wucodes',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
function LinkZoomExtendedMenu() {
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_WUCODUIF,'C'); },"field":"CODSTA","type":"C"},{"expression":function() { return WtA(w_xDESCRI,'C'); },"field":"DESCRI","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbstati','C'),"uid":"JRJGWESTVE"});
}
_Obli('WUCODSTA',0,'WXGOCNXMMY',false,"112851763")
_Obli('WUDESCRI',0,'QNVZYIVBZB',false,"285808099")
_Obli('WUCODUIF',0,'JRJGWESTVE',false,"2046929315")
_Obli('WUCODISO',0,'RYRRYSUJBK',false,"2046968547")
