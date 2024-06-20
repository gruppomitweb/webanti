function FillCombosValues() {
}
function FillInGridCombosValues(currentRow) {
var postfix = (Gt(currentRow,-1)?'_'+currentRow:'');
}
function SetControlsValue() {
var c;
if (Empty(m_cAltInterface) && (Eq(m_cFunction,'view') || Eq(m_cFunction,'query'))) {
} else {
SPBOUILib.SetInputValue('WLNNNRIURR',function(){return WtH(w_groupcode,'N',6,0,'999999')},w_groupcode);
SPBOUILib.SetInputValue('WLREBYBGNV',function(){return WtH(w_name,'C',50,0,'')},w_name);
SPBOUILib.SetInputValue('CSNTCOYGOR',function(){return WtH(w_datestart,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_datestart);
SPBOUILib.SetInputValue('PMFANIVCDZ',function(){return WtH(w_datestop,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_datestop);
SPBOUILib.SetInputValue('QXHDPMZCAB',function(){return WtH(w_companies,'C',2000,0,'')},w_companies);
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
HideUI.lblids["companies"]=['WOMZEETYKQ'];
HideUI.lblids["datestart"]=['UHRAVXAEXH'];
HideUI.lblids["datestop"]=['VQNQHWOYIR'];
HideUI.lblids["groupcode"]=['COTTYMIPCR'];
HideUI.lblids["name"]=['HTNMIHDFYJ'];
function ExpandCollapseBoxesUnderCondition() {
var cond;
}
function WLNNNRIURR_Valid(e) {
SetActiveField(Ctrl('WLNNNRIURR'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('groupcode','N',w_groupcode,HtW(Ctrl('WLNNNRIURR').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_groupcode(HtW(Ctrl('WLNNNRIURR').value,'N'),null,e);
return l_bSetResult;
}
}
function WLNNNRIURR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('WLNNNRIURR'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('WLNNNRIURR',w_groupcode,'N',6,0,'999999');
SetActiveField(Ctrl('WLNNNRIURR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('WLNNNRIURR'),e);
}
function WLNNNRIURR_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("999999"));
}
function WLNNNRIURR_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
windowOpenForeground(link_url(link_index('WLNNNRIURR')),'','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,null,null,'-d-g');
}
}
function CSNTCOYGOR_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('CSNTCOYGOR'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('CSNTCOYGOR').value=ApplyPictureToDate(Ctrl('CSNTCOYGOR').value,TranslatePicture(datePattern),'CSNTCOYGOR');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('CSNTCOYGOR'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('CSNTCOYGOR');
}
}
}
SetActiveField(Ctrl('CSNTCOYGOR'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('datestart','D',w_datestart,HtW(Ctrl('CSNTCOYGOR').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_datestart(HtW(Ctrl('CSNTCOYGOR').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function CSNTCOYGOR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('CSNTCOYGOR'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('CSNTCOYGOR',w_datestart,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('CSNTCOYGOR');
SetActiveField(Ctrl('CSNTCOYGOR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('CSNTCOYGOR'),e);
}
function CSNTCOYGOR_ZOOM_Click() {
LaunchCalendar(Ctrl('CSNTCOYGOR'));
}
function PMFANIVCDZ_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('PMFANIVCDZ'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('PMFANIVCDZ').value=ApplyPictureToDate(Ctrl('PMFANIVCDZ').value,TranslatePicture(datePattern),'PMFANIVCDZ');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('PMFANIVCDZ'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('PMFANIVCDZ');
}
}
}
SetActiveField(Ctrl('PMFANIVCDZ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('datestop','D',w_datestop,HtW(Ctrl('PMFANIVCDZ').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_datestop(HtW(Ctrl('PMFANIVCDZ').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function PMFANIVCDZ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('PMFANIVCDZ'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('PMFANIVCDZ',w_datestop,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('PMFANIVCDZ');
SetActiveField(Ctrl('PMFANIVCDZ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('PMFANIVCDZ'),e);
}
function PMFANIVCDZ_ZOOM_Click() {
LaunchCalendar(Ctrl('PMFANIVCDZ'));
}
function QXHDPMZCAB_Valid(e) {
SetActiveField(Ctrl('QXHDPMZCAB'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('companies','C',w_companies,HtW(Ctrl('QXHDPMZCAB').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_companies(HtW(Ctrl('QXHDPMZCAB').value,'C'),null,e);
return l_bSetResult;
}
}
function QXHDPMZCAB_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('QXHDPMZCAB'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('QXHDPMZCAB'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('QXHDPMZCAB'),e);
}
function QXHDPMZCAB_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
windowOpenForeground(link_url(link_index('QXHDPMZCAB')),'','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,null,null,'-d-g');
}
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function WLNNNRIURR_wrap_Valid(event) {
return WLNNNRIURR_Valid(event);
}
SPBOUILib.SetInputExit('WLNNNRIURR',WLNNNRIURR_wrap_Valid,SPBOUILib.Row.IN_GRID);
function WLNNNRIURR_wrap_OnFocus(event) {
return WLNNNRIURR_OnFocus(event);
}
SPBOUILib.SetInputEnter('WLNNNRIURR',WLNNNRIURR_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function WLNNNRIURR_wrap_OnKeyPress(event) {
return WLNNNRIURR_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('WLNNNRIURR',WLNNNRIURR_wrap_OnKeyPress,SPBOUILib.Row.IN_GRID);
function WLNNNRIURR_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('WLNNNRIURR',WLNNNRIURR_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function WLNNNRIURR_ZOOM_setHandlers() {
function WLNNNRIURR_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?WLNNNRIURR_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('WLNNNRIURR_ZOOM',WLNNNRIURR_ZOOM_wrap_OnClick,SPBOUILib.Row.IN_GRID);
}
SPBOUILib.SetPicker('WLNNNRIURR',WLNNNRIURR_ZOOM_setHandlers);
function CSNTCOYGOR_wrap_Valid(event) {
return CSNTCOYGOR_Valid(event);
}
SPBOUILib.SetInputExit('CSNTCOYGOR',CSNTCOYGOR_wrap_Valid,SPBOUILib.Row.IN_GRID);
function CSNTCOYGOR_wrap_OnFocus(event) {
return CSNTCOYGOR_OnFocus(event);
}
SPBOUILib.SetInputEnter('CSNTCOYGOR',CSNTCOYGOR_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function CSNTCOYGOR_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('CSNTCOYGOR',CSNTCOYGOR_wrap_OnKeyPress,SPBOUILib.Row.IN_GRID);
function CSNTCOYGOR_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('CSNTCOYGOR',CSNTCOYGOR_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function CSNTCOYGOR_ZOOM_setHandlers() {
function CSNTCOYGOR_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?CSNTCOYGOR_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('CSNTCOYGOR_ZOOM',CSNTCOYGOR_ZOOM_wrap_OnClick,SPBOUILib.Row.IN_GRID);
}
SPBOUILib.SetPicker('CSNTCOYGOR',CSNTCOYGOR_ZOOM_setHandlers);
function PMFANIVCDZ_wrap_Valid(event) {
return PMFANIVCDZ_Valid(event);
}
SPBOUILib.SetInputExit('PMFANIVCDZ',PMFANIVCDZ_wrap_Valid,SPBOUILib.Row.IN_GRID);
function PMFANIVCDZ_wrap_OnFocus(event) {
return PMFANIVCDZ_OnFocus(event);
}
SPBOUILib.SetInputEnter('PMFANIVCDZ',PMFANIVCDZ_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function PMFANIVCDZ_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('PMFANIVCDZ',PMFANIVCDZ_wrap_OnKeyPress,SPBOUILib.Row.IN_GRID);
function PMFANIVCDZ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('PMFANIVCDZ',PMFANIVCDZ_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function PMFANIVCDZ_ZOOM_setHandlers() {
function PMFANIVCDZ_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?PMFANIVCDZ_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('PMFANIVCDZ_ZOOM',PMFANIVCDZ_ZOOM_wrap_OnClick,SPBOUILib.Row.IN_GRID);
}
SPBOUILib.SetPicker('PMFANIVCDZ',PMFANIVCDZ_ZOOM_setHandlers);
function QXHDPMZCAB_wrap_Valid(event) {
return QXHDPMZCAB_Valid(event);
}
SPBOUILib.SetInputExit('QXHDPMZCAB',QXHDPMZCAB_wrap_Valid,SPBOUILib.Row.IN_GRID);
function QXHDPMZCAB_wrap_OnFocus(event) {
return QXHDPMZCAB_OnFocus(event);
}
SPBOUILib.SetInputEnter('QXHDPMZCAB',QXHDPMZCAB_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function QXHDPMZCAB_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('QXHDPMZCAB',QXHDPMZCAB_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function QXHDPMZCAB_ZOOM_setHandlers() {
function QXHDPMZCAB_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?QXHDPMZCAB_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('QXHDPMZCAB_ZOOM',QXHDPMZCAB_ZOOM_wrap_OnClick,SPBOUILib.Row.IN_GRID);
}
SPBOUILib.SetPicker('QXHDPMZCAB',QXHDPMZCAB_ZOOM_setHandlers);
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
if (Ne(typeof(Calculation_OMWEVXUHAL),'undefined')) {
old_c=m_bCalculating;
m_bCalculating=true;
Calculation_OMWEVXUHAL();
m_bCalculating=old_c;
if ( ! (old_c)) {
DoUpdate(true);
}
}
}
}
function SetLastFocusedOnParent() {
if (IsWndAccessible(window['m_oFather'])) {
m_oFather.i_last_focused_item='child_spadministration_usersgroups';
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
windowOpenForeground('../doc/spadministration_usersgroups_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_usercode=a[0];
w_groupcode=a[1];
w_datestart=a[2];
w_datestop=a[3];
w_companies=a[4];
w_name=a[5];
w_selected_group=a[6];
w_appoggio=a[7];
w_pwd_complexity=a[8];
if (Gt(a.length,9)) {
o_selected_group=w_selected_group;
o_groupcode=w_groupcode;
}
m_PrimaryKeys=['groupcode','usercode'];
}
function i_PrimaryKey() {
return 'cpusrgrp'+'\\'+CPLib.ToCPStr(w_usercode);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('spadministration_usersgroups',m_cSelectedPage);
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
var candidatesToFocus = ["WLNNNRIURR"];
SetControlFocus(candidatesToFocus);
}
IsRepeatedChild.child=[];
function GetFullRowMsgError() {
return 'MSG_FULLROW_NOT_SAT';
}
_Obli('groupcode',1,'WLNNNRIURR',false,"1433914651")
_Obli('datestop',2,'PMFANIVCDZ',false,"184661718")
_Obli('datestart',2,'CSNTCOYGOR',false,"313757110")
_Obli('companies',0,'QXHDPMZCAB',false,"11068993370")
