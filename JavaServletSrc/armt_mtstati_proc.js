function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('WXGOCNXMMY',function(){return WtH(w_CODSTA,'C',5,0,'')},w_CODSTA);
SPBOUILib.SetInputValue('QNVZYIVBZB',function(){return WtH(w_DESCRI,'C',40,0,'')},w_DESCRI);
SPBOUILib.SetInputValue('JRJGWESTVE',function(){return WtH(w_SIGLA,'C',3,0,'')},w_SIGLA);
var tmp_JKTDOFMWFL = ToHTag(AsControlValue(w_xDESCRI));
if (Ne(e_JKTDOFMWFL,tmp_JKTDOFMWFL)) {
SPBOUILib.SetLabelValue('JKTDOFMWFL','innerHTML',tmp_JKTDOFMWFL);
e_JKTDOFMWFL=tmp_JKTDOFMWFL;
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
SetDisplay('YORQOIOBQN_DIV',IsHiddenByStateDriver('box_YORQOIOBQN'));
LibJavascript.forEachItem(m_FoundlingHideExpression,i_body_2)
function i_body_2(child){
child();
}
HideUI();
}
HideUI.lblids["CODSTA"]=['OZNDYYDBLY'];
HideUI.lblids["DESCRI"]=['FQFUYMCBDC'];
HideUI.lblids["SIGLA"]=['SGGIOYRKTN'];
function WXGOCNXMMY_Valid(e) {
SetActiveField(Ctrl('WXGOCNXMMY'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('WXGOCNXMMY') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('CODSTA','C',w_CODSTA,HtW(Ctrl('WXGOCNXMMY').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODSTA(HtW(Ctrl('WXGOCNXMMY').value,'C'),null,e);
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
DoQuery('DESCRI','C',w_DESCRI,HtW(Ctrl('QNVZYIVBZB').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DESCRI(HtW(Ctrl('QNVZYIVBZB').value,'C'),null,e);
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
DoQuery('SIGLA','C',w_SIGLA,HtW(Ctrl('JRJGWESTVE').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_SIGLA(HtW(Ctrl('JRJGWESTVE').value,'C'),null,e);
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
windowOpenForeground('../doc/armt_mtstati_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_CODSTA=a[0];
op_CODSTA=a[1];
w_DESCRI=a[2];
w_SIGLA=a[3];
w_xDESCRI=a[4];
op_codazi=a[5];
m_PrimaryKeys=['CODSTA'];
}
function i_PrimaryKey() {
return 'mtstati'+'\\'+CPLib.ToCPStr(w_CODSTA);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('armt_mtstati',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
function LinkZoomExtendedMenu() {
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_SIGLA,'C'); },"field":"CODSTA","type":"C"},{"expression":function() { return WtA(w_xDESCRI,'C'); },"field":"DESCRI","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbstati','C'),"uid":"JRJGWESTVE"});
}
_Obli('CODSTA',0,'WXGOCNXMMY',false,"112851763")
_Obli('DESCRI',0,'QNVZYIVBZB',false,"285808099")
_Obli('SIGLA',0,'JRJGWESTVE',false,"6827491")
