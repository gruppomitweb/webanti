function FillCombosValues() {
FillCombo('QMLLHINIKD','QMLLHINIKD');
}
function FillInGridCombosValues(currentRow) {
var postfix = (Gt(currentRow,-1)?'_'+currentRow:'');
}
function SetControlsValue() {
var c;
if (Empty(m_cAltInterface) && (Eq(m_cFunction,'view') || Eq(m_cFunction,'query'))) {
if(c=Ctrl('QIKDMUYRQZ')) ChkboxCheckUncheck(c,1,w_PRIMO)
if(c=Ctrl('QIKDMUYRQZ')) ChkboxValueAssign(c,1,0,'N',1,0,'')
SPBOUILib.SetInputValue('ARBDBAASEB',function(){return WtH(w_DATAINI,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATAINI);
SPBOUILib.SetInputValue('XPJIVBDIXS',function(){return WtH(w_DATAFINE,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATAFINE);
if(c=Ctrl('QMLLHINIKD')) selectCombo(c,w_TIPOLEG,'C')
if(c=Ctrl('DTNUYRRYDZ')) selectCombo(c,w_RUOLO,'C')
SPBOUILib.SetInputValue('EZAKPDKVDE',function(){return WtH(w_xRAGSOC,'C',70,0,'')},w_xRAGSOC);
} else {
SPBOUILib.SetInputValue('NMXBOMFUCN',function(){return WtH(w_CODINTER,'C',16,0,'')},w_CODINTER);
if(c=Ctrl('QIKDMUYRQZ')) ChkboxCheckUncheck(c,1,w_PRIMO)
if(c=Ctrl('QIKDMUYRQZ')) ChkboxValueAssign(c,1,0,'N',1,0,'')
SPBOUILib.SetInputValue('ARBDBAASEB',function(){return WtH(w_DATAINI,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATAINI);
SPBOUILib.SetInputValue('XPJIVBDIXS',function(){return WtH(w_DATAFINE,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATAFINE);
if(c=Ctrl('QMLLHINIKD')) selectCombo(c,w_TIPOLEG,'C')
if(c=Ctrl('DTNUYRRYDZ')) selectCombo(c,w_RUOLO,'C')
SPBOUILib.SetInputValue('EZAKPDKVDE',function(){return WtH(w_xRAGSOC,'C',70,0,'')},w_xRAGSOC);
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
HideUI.lblids["CODINTER"]=['QPWBEAGBGF'];
HideUI.lblids["DATAFINE"]=['OHJFNNNEQD'];
HideUI.lblids["DATAINI"]=['XDSAZOVBQR'];
HideUI.lblids["RUOLO"]=['PNHRTSFPIS'];
HideUI.lblids["TIPOLEG"]=['LDGMOFMXKL'];
HideUI.lblids["xRAGSOC"]=['YJLOGXMJYL'];
function NMXBOMFUCN_Valid(e) {
SetActiveField(Ctrl('NMXBOMFUCN'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CODINTER','C',w_CODINTER,HtW(Ctrl('NMXBOMFUCN').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODINTER(HtW(Ctrl('NMXBOMFUCN').value,'C'),null,e);
return l_bSetResult;
}
}
function NMXBOMFUCN_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('NMXBOMFUCN'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('NMXBOMFUCN'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('NMXBOMFUCN'),e);
}
function NMXBOMFUCN_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('NMXBOMFUCN')),'linkview_NMXBOMFUCN','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function QIKDMUYRQZ_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('PRIMO','N',w_PRIMO,ChkboxValueAssign(Ctrl('QIKDMUYRQZ'),1,0,'N',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PRIMO(ChkboxValueAssign(Ctrl('QIKDMUYRQZ'),1,0,'N',1,0,''),null,e);
return l_bSetResult;
}
}
function QIKDMUYRQZ_OnFocus(e) {
SetActiveField(Ctrl('QIKDMUYRQZ'),true);
}
function QIKDMUYRQZ_OnBlur(e) {
SetActiveField(Ctrl('QIKDMUYRQZ'),false);
}
function ARBDBAASEB_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('ARBDBAASEB'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('ARBDBAASEB').value=ApplyPictureToDate(Ctrl('ARBDBAASEB').value,TranslatePicture(datePattern),'ARBDBAASEB');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('ARBDBAASEB'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('ARBDBAASEB');
}
}
}
SetActiveField(Ctrl('ARBDBAASEB'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATAINI','D',w_DATAINI,HtW(Ctrl('ARBDBAASEB').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATAINI(HtW(Ctrl('ARBDBAASEB').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function ARBDBAASEB_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ARBDBAASEB'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('ARBDBAASEB',w_DATAINI,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('ARBDBAASEB');
SetActiveField(Ctrl('ARBDBAASEB'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ARBDBAASEB'),e);
}
function ARBDBAASEB_ZOOM_Click() {
LaunchCalendar(Ctrl('ARBDBAASEB'));
}
function XPJIVBDIXS_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('XPJIVBDIXS'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('XPJIVBDIXS').value=ApplyPictureToDate(Ctrl('XPJIVBDIXS').value,TranslatePicture(datePattern),'XPJIVBDIXS');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('XPJIVBDIXS'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('XPJIVBDIXS');
}
}
}
SetActiveField(Ctrl('XPJIVBDIXS'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATAFINE','D',w_DATAFINE,HtW(Ctrl('XPJIVBDIXS').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATAFINE(HtW(Ctrl('XPJIVBDIXS').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function XPJIVBDIXS_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('XPJIVBDIXS'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('XPJIVBDIXS',w_DATAFINE,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('XPJIVBDIXS');
SetActiveField(Ctrl('XPJIVBDIXS'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('XPJIVBDIXS'),e);
}
function XPJIVBDIXS_ZOOM_Click() {
LaunchCalendar(Ctrl('XPJIVBDIXS'));
}
function QMLLHINIKD_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('TIPOLEG','C',w_TIPOLEG,HtW(getComboValue(Ctrl('QMLLHINIKD')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TIPOLEG(HtW(getComboValue(Ctrl('QMLLHINIKD')),'C'),null,e);
return l_bSetResult;
}
}
function QMLLHINIKD_OnFocus(e) {
SetActiveField(Ctrl('QMLLHINIKD'),true);
}
function QMLLHINIKD_OnBlur(e) {
SetActiveField(Ctrl('QMLLHINIKD'),false);
}
function DTNUYRRYDZ_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('RUOLO','C',w_RUOLO,HtW(getComboValue(Ctrl('DTNUYRRYDZ')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_RUOLO(HtW(getComboValue(Ctrl('DTNUYRRYDZ')),'C'),null,e);
return l_bSetResult;
}
}
function DTNUYRRYDZ_OnFocus(e) {
SetActiveField(Ctrl('DTNUYRRYDZ'),true);
}
function DTNUYRRYDZ_OnBlur(e) {
SetActiveField(Ctrl('DTNUYRRYDZ'),false);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function NMXBOMFUCN_wrap_Valid(event) {
return NMXBOMFUCN_Valid(event);
}
SPBOUILib.SetInputExit('NMXBOMFUCN',NMXBOMFUCN_wrap_Valid,SPBOUILib.Row.IN_GRID);
function NMXBOMFUCN_wrap_OnFocus(event) {
return NMXBOMFUCN_OnFocus(event);
}
SPBOUILib.SetInputEnter('NMXBOMFUCN',NMXBOMFUCN_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function NMXBOMFUCN_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('NMXBOMFUCN',NMXBOMFUCN_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function NMXBOMFUCN_ZOOM_setHandlers() {
function NMXBOMFUCN_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?NMXBOMFUCN_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('NMXBOMFUCN_ZOOM',NMXBOMFUCN_ZOOM_wrap_OnClick,SPBOUILib.Row.IN_GRID);
}
SPBOUILib.SetPicker('NMXBOMFUCN',NMXBOMFUCN_ZOOM_setHandlers);
function QIKDMUYRQZ_wrap_Valid(event) {
return QIKDMUYRQZ_Valid(event);
}
SPBOUILib.SetCheckboxClick('QIKDMUYRQZ',QIKDMUYRQZ_wrap_Valid);
function QIKDMUYRQZ_wrap_OnFocus(event) {
return QIKDMUYRQZ_OnFocus(event);
}
SPBOUILib.SetInputEnter('QIKDMUYRQZ',QIKDMUYRQZ_wrap_OnFocus);
function QIKDMUYRQZ_wrap_Blur(event) {
return QIKDMUYRQZ_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('QIKDMUYRQZ',QIKDMUYRQZ_wrap_Blur);
function ARBDBAASEB_wrap_Valid(event) {
return ARBDBAASEB_Valid(event);
}
SPBOUILib.SetInputExit('ARBDBAASEB',ARBDBAASEB_wrap_Valid);
function ARBDBAASEB_wrap_OnFocus(event) {
return ARBDBAASEB_OnFocus(event);
}
SPBOUILib.SetInputEnter('ARBDBAASEB',ARBDBAASEB_wrap_OnFocus);
function ARBDBAASEB_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('ARBDBAASEB',ARBDBAASEB_wrap_OnKeyPress);
function ARBDBAASEB_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('ARBDBAASEB',ARBDBAASEB_wrap_OnKeyDown);
function ARBDBAASEB_ZOOM_setHandlers() {
function ARBDBAASEB_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?ARBDBAASEB_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('ARBDBAASEB_ZOOM',ARBDBAASEB_ZOOM_wrap_OnClick);
}
SPBOUILib.SetPicker('ARBDBAASEB',ARBDBAASEB_ZOOM_setHandlers);
function XPJIVBDIXS_wrap_Valid(event) {
return XPJIVBDIXS_Valid(event);
}
SPBOUILib.SetInputExit('XPJIVBDIXS',XPJIVBDIXS_wrap_Valid);
function XPJIVBDIXS_wrap_OnFocus(event) {
return XPJIVBDIXS_OnFocus(event);
}
SPBOUILib.SetInputEnter('XPJIVBDIXS',XPJIVBDIXS_wrap_OnFocus);
function XPJIVBDIXS_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('XPJIVBDIXS',XPJIVBDIXS_wrap_OnKeyPress);
function XPJIVBDIXS_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('XPJIVBDIXS',XPJIVBDIXS_wrap_OnKeyDown);
function XPJIVBDIXS_ZOOM_setHandlers() {
function XPJIVBDIXS_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?XPJIVBDIXS_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('XPJIVBDIXS_ZOOM',XPJIVBDIXS_ZOOM_wrap_OnClick);
}
SPBOUILib.SetPicker('XPJIVBDIXS',XPJIVBDIXS_ZOOM_setHandlers);
function QMLLHINIKD_wrap_Valid(event) {
return QMLLHINIKD_Valid(event);
}
SPBOUILib.SetComboChange('QMLLHINIKD',QMLLHINIKD_wrap_Valid);
function QMLLHINIKD_wrap_OnFocus(event) {
return QMLLHINIKD_OnFocus(event);
}
SPBOUILib.SetInputEnter('QMLLHINIKD',QMLLHINIKD_wrap_OnFocus);
function QMLLHINIKD_wrap_Blur(event) {
return QMLLHINIKD_OnBlur(event);
}
SPBOUILib.SetInputExit('QMLLHINIKD',QMLLHINIKD_wrap_Blur);
function DTNUYRRYDZ_wrap_Valid(event) {
return DTNUYRRYDZ_Valid(event);
}
SPBOUILib.SetComboChange('DTNUYRRYDZ',DTNUYRRYDZ_wrap_Valid);
function DTNUYRRYDZ_wrap_OnFocus(event) {
return DTNUYRRYDZ_OnFocus(event);
}
SPBOUILib.SetInputEnter('DTNUYRRYDZ',DTNUYRRYDZ_wrap_OnFocus);
function DTNUYRRYDZ_wrap_Blur(event) {
return DTNUYRRYDZ_OnBlur(event);
}
SPBOUILib.SetInputExit('DTNUYRRYDZ',DTNUYRRYDZ_wrap_Blur);
if (m_bExtended) {
SetEventsAndStylesToExtendedFields();
}
}
if (Eq(m_nChildStatus,0)) {
if (Eq(m_cFunction,'query') && Ne(document.FrmToolbar,null)) {
document.FrmToolbar.pos.onkeypress=RecPositionInput;
document.FrmToolbar.pos.onblur=SelectRecord;
}
}
}
function NotifyEvent(p_cEvent) {
var old_c;
}
function SetLastFocusedOnParent() {
if (IsWndAccessible(window['m_oFather'])) {
m_oFather.i_last_focused_item='child_ardt_soggope';
m_oFather.last_focused_comp=null;
m_oFather.SetLastFocusedOnParent();
}
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
m_bStopChangeRow=true;
} else if (Ne('undefined',typeof(m_nLastError))) {
m_bStopChangeRow=Eq(m_nLastError,-2);
}
m_nLastError=0;
m_cLastMsgError='';
}
FocusFirstComponent.edit={};
FocusFirstComponent.query={};
FocusFirstComponent.otherwise={};
function Help() {
windowOpenForeground('../doc/ardt_soggope_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_COLLEG=a[0];
w_CODINTER=a[1];
w_IDBASE=a[2];
w_PRIMO=a[3];
w_DATAINI=a[4];
w_DATAFINE=a[5];
w_TIPOLEG=a[6];
w_RUOLO=a[7];
w_xRAGSOC=a[8];
m_PrimaryKeys=['IDBASE','CODINTER','COLLEG'];
}
function i_PrimaryKey() {
return 'soggope'+'\\'+CPLib.ToCPStr(w_COLLEG);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('ardt_soggope',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
function LinkZoomExtendedMenu() {
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_CODINTER,'C'); },"field":"CONNES","type":"C"},{"expression":function() { return WtA(w_xRAGSOC,'C'); },"field":"RAGSOC","type":"C"}],"itemRepeated":true,"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('personbo','C'),"uid":"NMXBOMFUCN"});
}
function FocusFirstDetailComponent() {
var candidatesToFocus = ["NMXBOMFUCN"];
SetControlFocus(candidatesToFocus);
}
IsRepeatedChild.child=[];
function GetFullRowMsgError() {
return 'MSG_FULLROW_NOT_SAT';
}
_Obli('DATAINI',2,'ARBDBAASEB',false,"45547614")
_Obli('CODINTER',0,'NMXBOMFUCN',false,"1968237748")
_Obli('DATAFINE',2,'XPJIVBDIXS',false,"1300662969")
_Obli('PRIMO',1,'QIKDMUYRQZ',false,"1289874503")
_Obli('TIPOLEG',0,'QMLLHINIKD',false,"10639118571")
_Obli('RUOLO',0,'DTNUYRRYDZ',false,"7747234")
