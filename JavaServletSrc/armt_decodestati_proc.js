function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('AKMCHLZVNZ',function(){return WtH(w_account,'C',100,0,'')},w_account);
SPBOUILib.SetInputValue('UGNUAEBJAI',function(){return WtH(w_CODSTA,'C',3,0,'')},w_CODSTA);
SPBOUILib.SetInputValue('SCPMCNQYIB',function(){return WtH(w_DESCRI,'C',40,0,'')},w_DESCRI);
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
HideUI.lblids["CODSTA"]=['TFXFGSNQHX'];
HideUI.lblids["account"]=['QOZVIQBJEA'];
function AKMCHLZVNZ_Valid(e) {
SetActiveField(Ctrl('AKMCHLZVNZ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('account','C',w_account,HtW(Ctrl('AKMCHLZVNZ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_account(HtW(Ctrl('AKMCHLZVNZ').value,'C'),null,e);
return l_bSetResult;
}
}
function AKMCHLZVNZ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('AKMCHLZVNZ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('AKMCHLZVNZ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('AKMCHLZVNZ'),e);
}
function UGNUAEBJAI_Valid(e) {
SetActiveField(Ctrl('UGNUAEBJAI'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CODSTA','C',w_CODSTA,HtW(Ctrl('UGNUAEBJAI').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODSTA(HtW(Ctrl('UGNUAEBJAI').value,'C'),null,e);
return l_bSetResult;
}
}
function UGNUAEBJAI_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('UGNUAEBJAI'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('UGNUAEBJAI'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('UGNUAEBJAI'),e);
}
function UGNUAEBJAI_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('UGNUAEBJAI')),'linkview_UGNUAEBJAI','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function SCPMCNQYIB_Valid(e) {
SetActiveField(Ctrl('SCPMCNQYIB'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DESCRI','C',w_DESCRI,HtW(Ctrl('SCPMCNQYIB').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DESCRI(HtW(Ctrl('SCPMCNQYIB').value,'C'),null,e);
return l_bSetResult;
}
}
function SCPMCNQYIB_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('SCPMCNQYIB'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('SCPMCNQYIB'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('SCPMCNQYIB'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function AKMCHLZVNZ_wrap_Valid(event) {
return AKMCHLZVNZ_Valid(event);
}
SPBOUILib.SetInputExit('AKMCHLZVNZ',AKMCHLZVNZ_wrap_Valid);
function AKMCHLZVNZ_wrap_OnFocus(event) {
return AKMCHLZVNZ_OnFocus(event);
}
SPBOUILib.SetInputEnter('AKMCHLZVNZ',AKMCHLZVNZ_wrap_OnFocus);
function AKMCHLZVNZ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('AKMCHLZVNZ',AKMCHLZVNZ_wrap_OnKeyDown);
function UGNUAEBJAI_wrap_Valid(event) {
return UGNUAEBJAI_Valid(event);
}
SPBOUILib.SetInputExit('UGNUAEBJAI',UGNUAEBJAI_wrap_Valid);
function UGNUAEBJAI_wrap_OnFocus(event) {
return UGNUAEBJAI_OnFocus(event);
}
SPBOUILib.SetInputEnter('UGNUAEBJAI',UGNUAEBJAI_wrap_OnFocus);
function UGNUAEBJAI_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('UGNUAEBJAI',UGNUAEBJAI_wrap_OnKeyDown);
function UGNUAEBJAI_ZOOM_setHandlers() {
function UGNUAEBJAI_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?UGNUAEBJAI_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('UGNUAEBJAI_ZOOM',UGNUAEBJAI_ZOOM_wrap_OnClick);
function UGNUAEBJAI_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('UGNUAEBJAI_ZOOM',UGNUAEBJAI_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('UGNUAEBJAI',UGNUAEBJAI_ZOOM_setHandlers);
function SCPMCNQYIB_wrap_Valid(event) {
return SCPMCNQYIB_Valid(event);
}
SPBOUILib.SetInputExit('SCPMCNQYIB',SCPMCNQYIB_wrap_Valid);
function SCPMCNQYIB_wrap_OnFocus(event) {
return SCPMCNQYIB_OnFocus(event);
}
SPBOUILib.SetInputEnter('SCPMCNQYIB',SCPMCNQYIB_wrap_OnFocus);
function SCPMCNQYIB_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('SCPMCNQYIB',SCPMCNQYIB_wrap_OnKeyDown);
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
FocusFirstComponent.edit={"page_1":["AKMCHLZVNZ"]};
FocusFirstComponent.query={"page_1":["AKMCHLZVNZ"]};
FocusFirstComponent.otherwise={"page_1":["AKMCHLZVNZ"]};
function Help() {
windowOpenForeground('../doc/armt_decodestati_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_account=a[0];
w_CODSTA=a[1];
w_DESCRI=a[2];
w_SIGLA=a[3];
w_ISO=a[4];
w_ISO2=a[5];
w_IDTBLS=a[6];
w_IDBASE=a[7];
w_id=a[8];
m_PrimaryKeys=['id'];
}
function i_PrimaryKey() {
return 'DecodeStati'+'\\'+CPLib.ToCPStr(w_id);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('armt_decodestati',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
function LinkZoomExtendedMenu() {
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_CODSTA,'C'); },"field":"CODSTA","type":"C"},{"expression":function() { return WtA(w_DESCRI,'C'); },"field":"DESCRI","type":"C"},{"expression":function() { return WtA(w_SIGLA,'C'); },"field":"SIGLA","type":"C"},{"expression":function() { return WtA(w_ISO,'C'); },"field":"ISO","type":"C"},{"expression":function() { return WtA(w_ISO2,'C'); },"field":"ISO2","type":"C"},{"expression":function() { return WtA(w_IDTBLS,'C'); },"field":"IDTBLS","type":"C"},{"expression":function() { return WtA(w_IDBASE,'C'); },"field":"IDBASE","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbstati','C'),"uid":"UGNUAEBJAI"});
}
_Obli('account',0,'AKMCHLZVNZ',false,"101550487")
_Obli('CODSTA',0,'UGNUAEBJAI',false,"1991901148")
_Obli('DESCRI',0,'SCPMCNQYIB',false)
