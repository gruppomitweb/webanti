function FillCombosValues() {
}
function FillInGridCombosValues(currentRow) {
var postfix = (Gt(currentRow,-1)?'_'+currentRow:'');
}
function SetControlsValue() {
var c;
if (Empty(m_cAltInterface) && (Eq(m_cFunction,'view') || Eq(m_cFunction,'query'))) {
} else {
SPBOUILib.SetInputValue('RROLCDNEHG',function(){return WtH(w_COGNOME,'C',50,0,'@!')},w_COGNOME);
SPBOUILib.SetInputValue('XPBOJBZXXR',function(){return WtH(w_NOME,'C',50,0,'@!')},w_NOME);
SPBOUILib.SetInputValue('WNPIYLEQUW',function(){return WtH(w_CODFISC,'C',16,0,'@!')},w_CODFISC);
SPBOUILib.SetInputValue('VWIKEUUJDC',function(){return WtH(w_DATAINI,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATAINI);
SPBOUILib.SetInputValue('GLSGCNRPHF',function(){return WtH(w_DATAFINE,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATAFINE);
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
HideUI.lblids["CODFISC"]=['CJPQXKJITP'];
HideUI.lblids["COGNOME"]=['QEQKLOCAHK'];
HideUI.lblids["NOME"]=['WYKFBTIXPH'];
function RROLCDNEHG_Valid(e) {
SetActiveField(Ctrl('RROLCDNEHG'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('COGNOME','C',w_COGNOME,HtW(Ctrl('RROLCDNEHG').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_COGNOME(HtW(Ctrl('RROLCDNEHG').value,'C'),null,e);
return l_bSetResult;
}
}
function RROLCDNEHG_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('RROLCDNEHG'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('RROLCDNEHG',w_COGNOME,'C',50,0,'@!');
SetActiveField(Ctrl('RROLCDNEHG'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('RROLCDNEHG'),e);
}
function RROLCDNEHG_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("@!"));
}
function XPBOJBZXXR_Valid(e) {
SetActiveField(Ctrl('XPBOJBZXXR'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('NOME','C',w_NOME,HtW(Ctrl('XPBOJBZXXR').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_NOME(HtW(Ctrl('XPBOJBZXXR').value,'C'),null,e);
return l_bSetResult;
}
}
function XPBOJBZXXR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('XPBOJBZXXR'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('XPBOJBZXXR',w_NOME,'C',50,0,'@!');
SetActiveField(Ctrl('XPBOJBZXXR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('XPBOJBZXXR'),e);
}
function XPBOJBZXXR_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("@!"));
}
function WNPIYLEQUW_Valid(e) {
SetActiveField(Ctrl('WNPIYLEQUW'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CODFISC','C',w_CODFISC,HtW(Ctrl('WNPIYLEQUW').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODFISC(HtW(Ctrl('WNPIYLEQUW').value,'C'),null,e);
return l_bSetResult;
}
}
function WNPIYLEQUW_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('WNPIYLEQUW'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('WNPIYLEQUW',w_CODFISC,'C',16,0,'@!');
SetActiveField(Ctrl('WNPIYLEQUW'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('WNPIYLEQUW'),e);
}
function WNPIYLEQUW_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("@!"));
}
function VWIKEUUJDC_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('VWIKEUUJDC'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('VWIKEUUJDC').value=ApplyPictureToDate(Ctrl('VWIKEUUJDC').value,TranslatePicture(datePattern),'VWIKEUUJDC');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('VWIKEUUJDC'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('VWIKEUUJDC');
}
}
}
SetActiveField(Ctrl('VWIKEUUJDC'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATAINI','D',w_DATAINI,HtW(Ctrl('VWIKEUUJDC').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATAINI(HtW(Ctrl('VWIKEUUJDC').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function VWIKEUUJDC_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('VWIKEUUJDC'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('VWIKEUUJDC',w_DATAINI,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('VWIKEUUJDC');
SetActiveField(Ctrl('VWIKEUUJDC'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('VWIKEUUJDC'),e);
}
function VWIKEUUJDC_ZOOM_Click() {
LaunchCalendar(Ctrl('VWIKEUUJDC'));
}
function GLSGCNRPHF_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('GLSGCNRPHF'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('GLSGCNRPHF').value=ApplyPictureToDate(Ctrl('GLSGCNRPHF').value,TranslatePicture(datePattern),'GLSGCNRPHF');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('GLSGCNRPHF'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('GLSGCNRPHF');
}
}
}
SetActiveField(Ctrl('GLSGCNRPHF'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATAFINE','D',w_DATAFINE,HtW(Ctrl('GLSGCNRPHF').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATAFINE(HtW(Ctrl('GLSGCNRPHF').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function GLSGCNRPHF_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('GLSGCNRPHF'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('GLSGCNRPHF',w_DATAFINE,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('GLSGCNRPHF');
SetActiveField(Ctrl('GLSGCNRPHF'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('GLSGCNRPHF'),e);
}
function GLSGCNRPHF_ZOOM_Click() {
LaunchCalendar(Ctrl('GLSGCNRPHF'));
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function RROLCDNEHG_wrap_Valid(event) {
return RROLCDNEHG_Valid(event);
}
SPBOUILib.SetInputExit('RROLCDNEHG',RROLCDNEHG_wrap_Valid,SPBOUILib.Row.IN_GRID);
function RROLCDNEHG_wrap_OnFocus(event) {
return RROLCDNEHG_OnFocus(event);
}
SPBOUILib.SetInputEnter('RROLCDNEHG',RROLCDNEHG_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function RROLCDNEHG_wrap_OnKeyPress(event) {
return CheckUpper(event);
}
SPBOUILib.SetInputKeyPress('RROLCDNEHG',RROLCDNEHG_wrap_OnKeyPress,SPBOUILib.Row.IN_GRID);
function RROLCDNEHG_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('RROLCDNEHG',RROLCDNEHG_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function XPBOJBZXXR_wrap_Valid(event) {
return XPBOJBZXXR_Valid(event);
}
SPBOUILib.SetInputExit('XPBOJBZXXR',XPBOJBZXXR_wrap_Valid,SPBOUILib.Row.IN_GRID);
function XPBOJBZXXR_wrap_OnFocus(event) {
return XPBOJBZXXR_OnFocus(event);
}
SPBOUILib.SetInputEnter('XPBOJBZXXR',XPBOJBZXXR_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function XPBOJBZXXR_wrap_OnKeyPress(event) {
return CheckUpper(event);
}
SPBOUILib.SetInputKeyPress('XPBOJBZXXR',XPBOJBZXXR_wrap_OnKeyPress,SPBOUILib.Row.IN_GRID);
function XPBOJBZXXR_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('XPBOJBZXXR',XPBOJBZXXR_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function WNPIYLEQUW_wrap_Valid(event) {
return WNPIYLEQUW_Valid(event);
}
SPBOUILib.SetInputExit('WNPIYLEQUW',WNPIYLEQUW_wrap_Valid,SPBOUILib.Row.IN_GRID);
function WNPIYLEQUW_wrap_OnFocus(event) {
return WNPIYLEQUW_OnFocus(event);
}
SPBOUILib.SetInputEnter('WNPIYLEQUW',WNPIYLEQUW_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function WNPIYLEQUW_wrap_OnKeyPress(event) {
return CheckUpper(event);
}
SPBOUILib.SetInputKeyPress('WNPIYLEQUW',WNPIYLEQUW_wrap_OnKeyPress,SPBOUILib.Row.IN_GRID);
function WNPIYLEQUW_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('WNPIYLEQUW',WNPIYLEQUW_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function VWIKEUUJDC_wrap_Valid(event) {
return VWIKEUUJDC_Valid(event);
}
SPBOUILib.SetInputExit('VWIKEUUJDC',VWIKEUUJDC_wrap_Valid,SPBOUILib.Row.IN_GRID);
function VWIKEUUJDC_wrap_OnFocus(event) {
return VWIKEUUJDC_OnFocus(event);
}
SPBOUILib.SetInputEnter('VWIKEUUJDC',VWIKEUUJDC_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function VWIKEUUJDC_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('VWIKEUUJDC',VWIKEUUJDC_wrap_OnKeyPress,SPBOUILib.Row.IN_GRID);
function VWIKEUUJDC_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('VWIKEUUJDC',VWIKEUUJDC_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function VWIKEUUJDC_ZOOM_setHandlers() {
function VWIKEUUJDC_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?VWIKEUUJDC_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('VWIKEUUJDC_ZOOM',VWIKEUUJDC_ZOOM_wrap_OnClick,SPBOUILib.Row.IN_GRID);
}
SPBOUILib.SetPicker('VWIKEUUJDC',VWIKEUUJDC_ZOOM_setHandlers);
function GLSGCNRPHF_wrap_Valid(event) {
return GLSGCNRPHF_Valid(event);
}
SPBOUILib.SetInputExit('GLSGCNRPHF',GLSGCNRPHF_wrap_Valid,SPBOUILib.Row.IN_GRID);
function GLSGCNRPHF_wrap_OnFocus(event) {
return GLSGCNRPHF_OnFocus(event);
}
SPBOUILib.SetInputEnter('GLSGCNRPHF',GLSGCNRPHF_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function GLSGCNRPHF_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('GLSGCNRPHF',GLSGCNRPHF_wrap_OnKeyPress,SPBOUILib.Row.IN_GRID);
function GLSGCNRPHF_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('GLSGCNRPHF',GLSGCNRPHF_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function GLSGCNRPHF_ZOOM_setHandlers() {
function GLSGCNRPHF_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?GLSGCNRPHF_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('GLSGCNRPHF_ZOOM',GLSGCNRPHF_ZOOM_wrap_OnClick,SPBOUILib.Row.IN_GRID);
}
SPBOUILib.SetPicker('GLSGCNRPHF',GLSGCNRPHF_ZOOM_setHandlers);
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
if (Eq(p_cEvent,'Init Row')) {
if (Ne(typeof(Calculation_JPLJTSXCMQ),'undefined')) {
old_c=m_bCalculating;
m_bCalculating=true;
Calculation_JPLJTSXCMQ();
m_bCalculating=old_c;
if ( ! (old_c)) {
DoUpdate(true);
}
}
}
}
function SetLastFocusedOnParent() {
if (IsWndAccessible(window['m_oFather'])) {
m_oFather.i_last_focused_item='child_ardt_ageresleg';
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
windowOpenForeground('../doc/ardt_ageresleg_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_CODMAGE=a[0];
w_COGNOME=a[1];
w_NOME=a[2];
w_CODFISC=a[3];
w_IDBASE=a[4];
w_CPROWNUM=a[5];
w_DATAINI=a[6];
w_DATAFINE=a[7];
m_PrimaryKeys=['CPROWNUM','CODMAGE'];
}
function i_PrimaryKey() {
return 'ageresleg'+'\\'+CPLib.ToCPStr(w_CODMAGE);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('ardt_ageresleg',m_cSelectedPage);
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
function FocusFirstDetailComponent() {
var candidatesToFocus = ["RROLCDNEHG"];
SetControlFocus(candidatesToFocus);
}
IsRepeatedChild.child=[];
function GetFullRowMsgError() {
return 'MSG_FULLROW_NOT_SAT';
}
_Obli('CODFISC',0,'WNPIYLEQUW',false,"11921223220")
_Obli('COGNOME',0,'RROLCDNEHG',false,"1816546867")
_Obli('NOME',0,'XPBOJBZXXR',false,"443454")
_Obli('DATAINI',2,'VWIKEUUJDC',false,"45547614")
_Obli('DATAFINE',2,'GLSGCNRPHF',false,"1300662969")
