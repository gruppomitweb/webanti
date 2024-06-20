function FillCombosValues() {
}
function FillInGridCombosValues(currentRow) {
var postfix = (Gt(currentRow,-1)?'_'+currentRow:'');
}
function SetControlsValue() {
var c;
if (Empty(m_cAltInterface) && (Eq(m_cFunction,'view') || Eq(m_cFunction,'query'))) {
} else {
SPBOUILib.SetInputValue('AGYYKHSHUA',function(){return WtH(w_CONPERS,'C',16,0,'')},w_CONPERS);
SPBOUILib.SetInputValue('YNEUNMBTFJ',function(){return WtH(w_DATAINI,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATAINI);
SPBOUILib.SetInputValue('LVELFPROYQ',function(){return WtH(w_DATAFINE,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATAFINE);
SPBOUILib.SetInputValue('IBLHHCTHVG',function(){return WtH(w_NOTEBREV,'M',10,0,'')},w_NOTEBREV);
SPBOUILib.SetInputValue('ILZIGHZMSS',function(){return WtH(w_xragsoc,'C',70,0,'')},w_xragsoc);
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
function AGYYKHSHUA_Valid(e) {
SetActiveField(Ctrl('AGYYKHSHUA'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CONPERS','C',w_CONPERS,HtW(Ctrl('AGYYKHSHUA').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CONPERS(HtW(Ctrl('AGYYKHSHUA').value,'C'),null,e);
return l_bSetResult;
}
}
function AGYYKHSHUA_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('AGYYKHSHUA'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('AGYYKHSHUA'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('AGYYKHSHUA'),e);
}
function AGYYKHSHUA_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('AGYYKHSHUA')),'linkview_AGYYKHSHUA','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function YNEUNMBTFJ_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('YNEUNMBTFJ'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('YNEUNMBTFJ').value=ApplyPictureToDate(Ctrl('YNEUNMBTFJ').value,TranslatePicture(datePattern),'YNEUNMBTFJ');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('YNEUNMBTFJ'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('YNEUNMBTFJ');
}
}
}
SetActiveField(Ctrl('YNEUNMBTFJ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATAINI','D',w_DATAINI,HtW(Ctrl('YNEUNMBTFJ').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATAINI(HtW(Ctrl('YNEUNMBTFJ').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function YNEUNMBTFJ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('YNEUNMBTFJ'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('YNEUNMBTFJ',w_DATAINI,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('YNEUNMBTFJ');
SetActiveField(Ctrl('YNEUNMBTFJ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('YNEUNMBTFJ'),e);
}
function LVELFPROYQ_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('LVELFPROYQ'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('LVELFPROYQ').value=ApplyPictureToDate(Ctrl('LVELFPROYQ').value,TranslatePicture(datePattern),'LVELFPROYQ');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('LVELFPROYQ'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('LVELFPROYQ');
}
}
}
SetActiveField(Ctrl('LVELFPROYQ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATAFINE','D',w_DATAFINE,HtW(Ctrl('LVELFPROYQ').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATAFINE(HtW(Ctrl('LVELFPROYQ').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function LVELFPROYQ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('LVELFPROYQ'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('LVELFPROYQ',w_DATAFINE,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('LVELFPROYQ');
SetActiveField(Ctrl('LVELFPROYQ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('LVELFPROYQ'),e);
}
function IBLHHCTHVG_Valid(e) {
SetActiveField(Ctrl('IBLHHCTHVG'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('NOTEBREV','M',w_NOTEBREV,HtW(Ctrl('IBLHHCTHVG').value,'M'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_NOTEBREV(HtW(Ctrl('IBLHHCTHVG').value,'M'),null,e);
return l_bSetResult;
}
}
function IBLHHCTHVG_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('IBLHHCTHVG'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('IBLHHCTHVG'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('IBLHHCTHVG'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function AGYYKHSHUA_wrap_Valid(event) {
return AGYYKHSHUA_Valid(event);
}
SPBOUILib.SetInputExit('AGYYKHSHUA',AGYYKHSHUA_wrap_Valid,SPBOUILib.Row.IN_GRID);
function AGYYKHSHUA_wrap_OnFocus(event) {
return AGYYKHSHUA_OnFocus(event);
}
SPBOUILib.SetInputEnter('AGYYKHSHUA',AGYYKHSHUA_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function AGYYKHSHUA_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('AGYYKHSHUA',AGYYKHSHUA_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function AGYYKHSHUA_ZOOM_setHandlers() {
function AGYYKHSHUA_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?AGYYKHSHUA_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('AGYYKHSHUA_ZOOM',AGYYKHSHUA_ZOOM_wrap_OnClick,SPBOUILib.Row.IN_GRID);
}
SPBOUILib.SetPicker('AGYYKHSHUA',AGYYKHSHUA_ZOOM_setHandlers);
function YNEUNMBTFJ_wrap_Valid(event) {
return YNEUNMBTFJ_Valid(event);
}
SPBOUILib.SetInputExit('YNEUNMBTFJ',YNEUNMBTFJ_wrap_Valid,SPBOUILib.Row.IN_GRID);
function YNEUNMBTFJ_wrap_OnFocus(event) {
return YNEUNMBTFJ_OnFocus(event);
}
SPBOUILib.SetInputEnter('YNEUNMBTFJ',YNEUNMBTFJ_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function YNEUNMBTFJ_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('YNEUNMBTFJ',YNEUNMBTFJ_wrap_OnKeyPress,SPBOUILib.Row.IN_GRID);
function YNEUNMBTFJ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('YNEUNMBTFJ',YNEUNMBTFJ_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function LVELFPROYQ_wrap_Valid(event) {
return LVELFPROYQ_Valid(event);
}
SPBOUILib.SetInputExit('LVELFPROYQ',LVELFPROYQ_wrap_Valid,SPBOUILib.Row.IN_GRID);
function LVELFPROYQ_wrap_OnFocus(event) {
return LVELFPROYQ_OnFocus(event);
}
SPBOUILib.SetInputEnter('LVELFPROYQ',LVELFPROYQ_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function LVELFPROYQ_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('LVELFPROYQ',LVELFPROYQ_wrap_OnKeyPress,SPBOUILib.Row.IN_GRID);
function LVELFPROYQ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('LVELFPROYQ',LVELFPROYQ_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function IBLHHCTHVG_wrap_Valid(event) {
return IBLHHCTHVG_Valid(event);
}
SPBOUILib.SetInputExit('IBLHHCTHVG',IBLHHCTHVG_wrap_Valid,SPBOUILib.Row.IN_GRID);
function IBLHHCTHVG_wrap_OnFocus(event) {
return IBLHHCTHVG_OnFocus(event);
}
SPBOUILib.SetInputEnter('IBLHHCTHVG',IBLHHCTHVG_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
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
m_oFather.i_last_focused_item='child_ardt_titopers';
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
windowOpenForeground('../doc/ardt_titopers_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_CONTITO=a[0];
w_CONPERS=a[1];
w_DATAINI=a[2];
w_DATAFINE=a[3];
w_NOTEBREV=a[4];
w_xragsoc=a[5];
m_PrimaryKeys=['CONTITO'];
}
function i_PrimaryKey() {
return 'titopers'+'\\'+CPLib.ToCPStr(w_CONTITO);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('ardt_titopers',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
function LinkZoomExtendedMenu() {
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_CONPERS,'C'); },"field":"CONNES","type":"C"},{"expression":function() { return WtA(w_xragsoc,'C'); },"field":"RAGSOC","type":"C"}],"itemRepeated":true,"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('personbo','C'),"uid":"AGYYKHSHUA"});
}
function FocusFirstDetailComponent() {
var candidatesToFocus = ["AGYYKHSHUA"];
SetControlFocus(candidatesToFocus);
}
IsRepeatedChild.child=[];
function GetFullRowMsgError() {
return 'MSG_FULLROW_NOT_SAT';
}
_Obli('DATAINI',2,'YNEUNMBTFJ',false,"45547614")
_Obli('CONPERS',0,'AGYYKHSHUA',false,"390214332")
_Obli('DATAFINE',2,'LVELFPROYQ',false,"1300662969")
_Obli('NOTEBREV',0,'IBLHHCTHVG',false,"10968437180")
