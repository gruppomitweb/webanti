function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('ZGQEJMVUST',function(){return WtH(w_ID,'N',10,0,'9999999999')},w_ID);
SPBOUILib.SetInputValue('ONHGQHDQFZ',function(){return WtH(w_IDBASE,'C',10,0,'')},w_IDBASE);
SPBOUILib.SetInputValue('BHNIQXSGYR',function(){return WtH(w_CITTAMIT,'C',60,0,'')},w_CITTAMIT);
SPBOUILib.SetInputValue('KXSOHXEOWU',function(){return WtH(w_CITTA,'C',80,0,'')},w_CITTA);
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
HideUI.lblids["CITTA"]=['DHBKXPEWZA'];
HideUI.lblids["CITTAMIT"]=['KNMZJNPQJP'];
HideUI.lblids["ID"]=['MYOUCLPSIG'];
HideUI.lblids["IDBASE"]=['UYEZUENIYX'];
function ZGQEJMVUST_Valid(e) {
SetActiveField(Ctrl('ZGQEJMVUST'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('ZGQEJMVUST') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('ID','N',w_ID,HtW(Ctrl('ZGQEJMVUST').value,'N'),m_bQueryOnLatestKeyOnly);
}
}
}
function ZGQEJMVUST_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ZGQEJMVUST'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('ZGQEJMVUST',w_ID,'N',10,0,'9999999999');
SetActiveField(Ctrl('ZGQEJMVUST'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ZGQEJMVUST'),e);
}
function ZGQEJMVUST_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("9999999999"));
}
function ONHGQHDQFZ_Valid(e) {
SetActiveField(Ctrl('ONHGQHDQFZ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('IDBASE','C',w_IDBASE,HtW(Ctrl('ONHGQHDQFZ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IDBASE(HtW(Ctrl('ONHGQHDQFZ').value,'C'),null,e);
return l_bSetResult;
}
}
function ONHGQHDQFZ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ONHGQHDQFZ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('ONHGQHDQFZ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ONHGQHDQFZ'),e);
}
function ONHGQHDQFZ_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('ONHGQHDQFZ')),'linkview_ONHGQHDQFZ','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function BHNIQXSGYR_Valid(e) {
SetActiveField(Ctrl('BHNIQXSGYR'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CITTAMIT','C',w_CITTAMIT,HtW(Ctrl('BHNIQXSGYR').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CITTAMIT(HtW(Ctrl('BHNIQXSGYR').value,'C'),null,e);
return l_bSetResult;
}
}
function BHNIQXSGYR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('BHNIQXSGYR'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('BHNIQXSGYR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('BHNIQXSGYR'),e);
}
function KXSOHXEOWU_Valid(e) {
SetActiveField(Ctrl('KXSOHXEOWU'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CITTA','C',w_CITTA,HtW(Ctrl('KXSOHXEOWU').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CITTA(HtW(Ctrl('KXSOHXEOWU').value,'C'),null,e);
return l_bSetResult;
}
}
function KXSOHXEOWU_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('KXSOHXEOWU'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('KXSOHXEOWU'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('KXSOHXEOWU'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function ZGQEJMVUST_wrap_Valid(event) {
return ZGQEJMVUST_Valid(event);
}
SPBOUILib.SetInputExit('ZGQEJMVUST',ZGQEJMVUST_wrap_Valid);
function ZGQEJMVUST_wrap_OnFocus(event) {
return ZGQEJMVUST_OnFocus(event);
}
SPBOUILib.SetInputEnter('ZGQEJMVUST',ZGQEJMVUST_wrap_OnFocus);
function ZGQEJMVUST_wrap_OnKeyPress(event) {
return ZGQEJMVUST_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('ZGQEJMVUST',ZGQEJMVUST_wrap_OnKeyPress);
function ZGQEJMVUST_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('ZGQEJMVUST',ZGQEJMVUST_wrap_OnKeyDown);
function ONHGQHDQFZ_wrap_Valid(event) {
return ONHGQHDQFZ_Valid(event);
}
SPBOUILib.SetInputExit('ONHGQHDQFZ',ONHGQHDQFZ_wrap_Valid);
function ONHGQHDQFZ_wrap_OnFocus(event) {
return ONHGQHDQFZ_OnFocus(event);
}
SPBOUILib.SetInputEnter('ONHGQHDQFZ',ONHGQHDQFZ_wrap_OnFocus);
function ONHGQHDQFZ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('ONHGQHDQFZ',ONHGQHDQFZ_wrap_OnKeyDown);
function ONHGQHDQFZ_ZOOM_setHandlers() {
function ONHGQHDQFZ_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?ONHGQHDQFZ_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('ONHGQHDQFZ_ZOOM',ONHGQHDQFZ_ZOOM_wrap_OnClick);
function ONHGQHDQFZ_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('ONHGQHDQFZ_ZOOM',ONHGQHDQFZ_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('ONHGQHDQFZ',ONHGQHDQFZ_ZOOM_setHandlers);
function BHNIQXSGYR_wrap_Valid(event) {
return BHNIQXSGYR_Valid(event);
}
SPBOUILib.SetInputExit('BHNIQXSGYR',BHNIQXSGYR_wrap_Valid);
function BHNIQXSGYR_wrap_OnFocus(event) {
return BHNIQXSGYR_OnFocus(event);
}
SPBOUILib.SetInputEnter('BHNIQXSGYR',BHNIQXSGYR_wrap_OnFocus);
function BHNIQXSGYR_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('BHNIQXSGYR',BHNIQXSGYR_wrap_OnKeyDown);
function KXSOHXEOWU_wrap_Valid(event) {
return KXSOHXEOWU_Valid(event);
}
SPBOUILib.SetInputExit('KXSOHXEOWU',KXSOHXEOWU_wrap_Valid);
function KXSOHXEOWU_wrap_OnFocus(event) {
return KXSOHXEOWU_OnFocus(event);
}
SPBOUILib.SetInputEnter('KXSOHXEOWU',KXSOHXEOWU_wrap_OnFocus);
function KXSOHXEOWU_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('KXSOHXEOWU',KXSOHXEOWU_wrap_OnKeyDown);
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
FocusFirstComponent.edit={"page_1":["ONHGQHDQFZ"]};
FocusFirstComponent.query={"page_1":["ZGQEJMVUST","ONHGQHDQFZ"]};
FocusFirstComponent.otherwise={"page_1":["ONHGQHDQFZ"]};
function Help() {
windowOpenForeground('../doc/armt_decodecomuni_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_ID=a[0];
w_IDBASE=a[1];
w_CITTAMIT=a[2];
w_CAB=a[3];
w_PROV=a[4];
w_CAPMIT=a[5];
w_PKTBSTATI=a[6];
w_SIGLA=a[7];
w_PREF=a[8];
w_IDTBLS=a[9];
w_CITTA=a[10];
w_PR=a[11];
w_CATASTALE=a[12];
w_CAP=a[13];
w_REGIONE=a[14];
m_PrimaryKeys=['ID'];
}
function i_PrimaryKey() {
return 'DecodeCitta'+'\\'+CPLib.ToCPStr(w_ID);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('armt_decodecomuni',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
function LinkZoomExtendedMenu() {
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_IDBASE,'C'); },"field":"IDBASE","type":"C"},{"expression":function() { return WtA(w_CITTAMIT,'C'); },"field":"CITTA","type":"C"},{"expression":function() { return WtA(w_CAB,'C'); },"field":"CAB","type":"C"},{"expression":function() { return WtA(w_PROV,'C'); },"field":"PROV","type":"C"},{"expression":function() { return WtA(w_CAPMIT,'C'); },"field":"CAP","type":"C"},{"expression":function() { return WtA(w_PKTBSTATI,'C'); },"field":"PKTBSTATI","type":"C"},{"expression":function() { return WtA(w_SIGLA,'C'); },"field":"SIGLA","type":"C"},{"expression":function() { return WtA(w_PREF,'C'); },"field":"PREF","type":"C"},{"expression":function() { return WtA(w_IDTBLS,'C'); },"field":"IDTBLS","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbcitta','C'),"uid":"ONHGQHDQFZ"});
}
_Obli('IDBASE',0,'ONHGQHDQFZ',false,"112851763")
_Obli('CITTAMIT',0,'BHNIQXSGYR',false,"2063759932")
_Obli('CITTA',0,'KXSOHXEOWU',false,"15186643")
