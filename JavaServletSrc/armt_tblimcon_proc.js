function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('WSIVJMMEOM',function(){return WtH(w_LCCODICE,'C',3,0,'')},w_LCCODICE);
SPBOUILib.SetInputValue('ZUPMLTQCEM',function(){return WtH(w_LCDATINI,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_LCDATINI);
SPBOUILib.SetInputValue('TASPEGJGHK',function(){return WtH(w_LCDATFIN,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_LCDATFIN);
SPBOUILib.SetInputValue('HVZVGYCRIY',function(){return WtH(w_LCIMPMAX,'N',12,2,'999999999.99')},w_LCIMPMAX);
SPBOUILib.SetInputValue('VQLPBZCNLD',function(){return WtH(w_LCVALPER,'C',140,0,'')},w_LCVALPER);
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
HideUI.lblids["LCCODICE"]=['WJKCALNFVG'];
HideUI.lblids["LCDATFIN"]=['XBCLFJCLHJ'];
HideUI.lblids["LCDATINI"]=['VYGJNUYIGP'];
HideUI.lblids["LCIMPMAX"]=['YNITUUVDHC'];
HideUI.lblids["LCVALPER"]=['DLIZSAXETD'];
function WSIVJMMEOM_Valid(e) {
SetActiveField(Ctrl('WSIVJMMEOM'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('WSIVJMMEOM') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('LCCODICE','C',w_LCCODICE,HtW(Ctrl('WSIVJMMEOM').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_LCCODICE(HtW(Ctrl('WSIVJMMEOM').value,'C'),null,e);
return l_bSetResult;
}
}
function WSIVJMMEOM_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('WSIVJMMEOM'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('WSIVJMMEOM'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('WSIVJMMEOM'),e);
}
function ZUPMLTQCEM_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('ZUPMLTQCEM'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('ZUPMLTQCEM').value=ApplyPictureToDate(Ctrl('ZUPMLTQCEM').value,TranslatePicture(datePattern),'ZUPMLTQCEM');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('ZUPMLTQCEM'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('ZUPMLTQCEM');
}
}
}
SetActiveField(Ctrl('ZUPMLTQCEM'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('LCDATINI','D',w_LCDATINI,HtW(Ctrl('ZUPMLTQCEM').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_LCDATINI(HtW(Ctrl('ZUPMLTQCEM').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function ZUPMLTQCEM_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ZUPMLTQCEM'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('ZUPMLTQCEM',w_LCDATINI,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('ZUPMLTQCEM');
SetActiveField(Ctrl('ZUPMLTQCEM'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ZUPMLTQCEM'),e);
}
function ZUPMLTQCEM_ZOOM_Click() {
LaunchCalendar(Ctrl('ZUPMLTQCEM'));
}
function TASPEGJGHK_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('TASPEGJGHK'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('TASPEGJGHK').value=ApplyPictureToDate(Ctrl('TASPEGJGHK').value,TranslatePicture(datePattern),'TASPEGJGHK');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('TASPEGJGHK'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('TASPEGJGHK');
}
}
}
SetActiveField(Ctrl('TASPEGJGHK'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('LCDATFIN','D',w_LCDATFIN,HtW(Ctrl('TASPEGJGHK').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_LCDATFIN(HtW(Ctrl('TASPEGJGHK').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function TASPEGJGHK_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('TASPEGJGHK'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('TASPEGJGHK',w_LCDATFIN,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('TASPEGJGHK');
SetActiveField(Ctrl('TASPEGJGHK'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('TASPEGJGHK'),e);
}
function TASPEGJGHK_ZOOM_Click() {
LaunchCalendar(Ctrl('TASPEGJGHK'));
}
function HVZVGYCRIY_Valid(e) {
SetActiveField(Ctrl('HVZVGYCRIY'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('LCIMPMAX','N',w_LCIMPMAX,HtW(Ctrl('HVZVGYCRIY').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_LCIMPMAX(HtW(Ctrl('HVZVGYCRIY').value,'N'),null,e);
return l_bSetResult;
}
}
function HVZVGYCRIY_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('HVZVGYCRIY'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('HVZVGYCRIY',w_LCIMPMAX,'N',12,2,'999999999.99');
SetActiveField(Ctrl('HVZVGYCRIY'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('HVZVGYCRIY'),e);
}
function HVZVGYCRIY_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("999999999.99"));
}
function VQLPBZCNLD_Valid(e) {
SetActiveField(Ctrl('VQLPBZCNLD'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('LCVALPER','C',w_LCVALPER,HtW(Ctrl('VQLPBZCNLD').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_LCVALPER(HtW(Ctrl('VQLPBZCNLD').value,'C'),null,e);
return l_bSetResult;
}
}
function VQLPBZCNLD_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('VQLPBZCNLD'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('VQLPBZCNLD'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('VQLPBZCNLD'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function WSIVJMMEOM_wrap_Valid(event) {
return WSIVJMMEOM_Valid(event);
}
SPBOUILib.SetInputExit('WSIVJMMEOM',WSIVJMMEOM_wrap_Valid);
function WSIVJMMEOM_wrap_OnFocus(event) {
return WSIVJMMEOM_OnFocus(event);
}
SPBOUILib.SetInputEnter('WSIVJMMEOM',WSIVJMMEOM_wrap_OnFocus);
function WSIVJMMEOM_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('WSIVJMMEOM',WSIVJMMEOM_wrap_OnKeyDown);
function ZUPMLTQCEM_wrap_Valid(event) {
return ZUPMLTQCEM_Valid(event);
}
SPBOUILib.SetInputExit('ZUPMLTQCEM',ZUPMLTQCEM_wrap_Valid);
function ZUPMLTQCEM_wrap_OnFocus(event) {
return ZUPMLTQCEM_OnFocus(event);
}
SPBOUILib.SetInputEnter('ZUPMLTQCEM',ZUPMLTQCEM_wrap_OnFocus);
function ZUPMLTQCEM_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('ZUPMLTQCEM',ZUPMLTQCEM_wrap_OnKeyPress);
function ZUPMLTQCEM_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('ZUPMLTQCEM',ZUPMLTQCEM_wrap_OnKeyDown);
function ZUPMLTQCEM_ZOOM_setHandlers() {
function ZUPMLTQCEM_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?ZUPMLTQCEM_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('ZUPMLTQCEM_ZOOM',ZUPMLTQCEM_ZOOM_wrap_OnClick);
function ZUPMLTQCEM_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('ZUPMLTQCEM_ZOOM',ZUPMLTQCEM_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('ZUPMLTQCEM',ZUPMLTQCEM_ZOOM_setHandlers);
function TASPEGJGHK_wrap_Valid(event) {
return TASPEGJGHK_Valid(event);
}
SPBOUILib.SetInputExit('TASPEGJGHK',TASPEGJGHK_wrap_Valid);
function TASPEGJGHK_wrap_OnFocus(event) {
return TASPEGJGHK_OnFocus(event);
}
SPBOUILib.SetInputEnter('TASPEGJGHK',TASPEGJGHK_wrap_OnFocus);
function TASPEGJGHK_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('TASPEGJGHK',TASPEGJGHK_wrap_OnKeyPress);
function TASPEGJGHK_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('TASPEGJGHK',TASPEGJGHK_wrap_OnKeyDown);
function TASPEGJGHK_ZOOM_setHandlers() {
function TASPEGJGHK_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?TASPEGJGHK_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('TASPEGJGHK_ZOOM',TASPEGJGHK_ZOOM_wrap_OnClick);
function TASPEGJGHK_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('TASPEGJGHK_ZOOM',TASPEGJGHK_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('TASPEGJGHK',TASPEGJGHK_ZOOM_setHandlers);
function HVZVGYCRIY_wrap_Valid(event) {
return HVZVGYCRIY_Valid(event);
}
SPBOUILib.SetInputExit('HVZVGYCRIY',HVZVGYCRIY_wrap_Valid);
function HVZVGYCRIY_wrap_OnFocus(event) {
return HVZVGYCRIY_OnFocus(event);
}
SPBOUILib.SetInputEnter('HVZVGYCRIY',HVZVGYCRIY_wrap_OnFocus);
function HVZVGYCRIY_wrap_OnKeyPress(event) {
return HVZVGYCRIY_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('HVZVGYCRIY',HVZVGYCRIY_wrap_OnKeyPress);
function HVZVGYCRIY_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('HVZVGYCRIY',HVZVGYCRIY_wrap_OnKeyDown);
function VQLPBZCNLD_wrap_Valid(event) {
return VQLPBZCNLD_Valid(event);
}
SPBOUILib.SetInputExit('VQLPBZCNLD',VQLPBZCNLD_wrap_Valid);
function VQLPBZCNLD_wrap_OnFocus(event) {
return VQLPBZCNLD_OnFocus(event);
}
SPBOUILib.SetInputEnter('VQLPBZCNLD',VQLPBZCNLD_wrap_OnFocus);
function VQLPBZCNLD_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('VQLPBZCNLD',VQLPBZCNLD_wrap_OnKeyDown);
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
FocusFirstComponent.edit={"page_1":["ZUPMLTQCEM"]};
FocusFirstComponent.query={"page_1":["WSIVJMMEOM"]};
FocusFirstComponent.otherwise={"page_1":["WSIVJMMEOM"]};
function Help() {
windowOpenForeground('../doc/armt_tblimcon_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_LCCODICE=a[0];
op_LCCODICE=a[1];
w_LCDATINI=a[2];
w_LCDATFIN=a[3];
w_LCIMPMAX=a[4];
w_LCVALPER=a[5];
m_PrimaryKeys=['LCCODICE'];
}
function i_PrimaryKey() {
return 'tblimcon'+'\\'+CPLib.ToCPStr(w_LCCODICE);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('armt_tblimcon',m_cSelectedPage);
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
_Obli('LCCODICE',0,'WSIVJMMEOM',false,"112851763")
_Obli('LCDATINI',2,'ZUPMLTQCEM',false,"190412301")
_Obli('LCDATFIN',2,'TASPEGJGHK',false,"59714856")
_Obli('LCIMPMAX',1,'HVZVGYCRIY',false,"11203583575")
_Obli('LCVALPER',0,'VQLPBZCNLD',false,"660277739")
