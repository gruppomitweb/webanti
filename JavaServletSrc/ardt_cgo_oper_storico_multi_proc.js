function FillCombosValues() {
}
function FillInGridCombosValues(currentRow) {
var postfix = (Gt(currentRow,-1)?'_'+currentRow:'');
FillCombo('ATYKZCFGTM','ATYKZCFGTM'+postfix,( ! (Empty(postfix))?WtA(w_TIPOGIOCO):null));
}
function SetControlsValue() {
var c;
if (Empty(m_cAltInterface) && (Eq(m_cFunction,'view') || Eq(m_cFunction,'query'))) {
SPBOUILib.SetInputValue('XNNJZLJUOA',function(){return WtH(w_CGOTIPOPE,'C',1,0,'')},w_CGOTIPOPE);
SPBOUILib.SetInputValue('RWWIDDSYYG',function(){return WtH(w_CPROWNUM,'N',4,0,'')},w_CPROWNUM);
SPBOUILib.SetInputValue('JMCVMUAWAP',function(){return WtH(w_NUMOPEDL,'C',15,0,'')},w_NUMOPEDL);
} else {
SPBOUILib.SetInputValue('XNNJZLJUOA',function(){return WtH(w_CGOTIPOPE,'C',1,0,'')},w_CGOTIPOPE);
SPBOUILib.SetInputValue('SVYXZEMNRB',function(){return WtH(w_DATOPE,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATOPE);
SPBOUILib.SetInputValue('LIJFNMVRXK',function(){return WtH(w_CAIDBIGLIETTO,'C',30,0,'!')},w_CAIDBIGLIETTO);
SPBOUILib.SetInputValue('OGHOMBFTXJ',function(){return WtH(w_TOTLIRE,'N',12,2,'999,999,999.99')},w_TOTLIRE);
if(c=Ctrl('FPCQRNSIUW')) ChkboxCheckUncheck(c,'S',w_FLGFULL)
if(c=Ctrl('FPCQRNSIUW')) ChkboxValueAssign(c,'S','N','C',1,0,'')
SPBOUILib.SetInputValue('RWWIDDSYYG',function(){return WtH(w_CPROWNUM,'N',4,0,'')},w_CPROWNUM);
SPBOUILib.SetInputValue('JMCVMUAWAP',function(){return WtH(w_NUMOPEDL,'C',15,0,'')},w_NUMOPEDL);
if(c=Ctrl('ATYKZCFGTM')) selectCombo(c,w_TIPOGIOCO,'C')
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
SetDisplay(Ctrl('XNNJZLJUOA'),true || IsHiddenByStateDriver('CGOTIPOPE'));
SetDisplay(Ctrl('RWWIDDSYYG'),true || IsHiddenByStateDriver('CPROWNUM'));
SetDisplay(Ctrl('JMCVMUAWAP'),true || IsHiddenByStateDriver('NUMOPEDL'));
LibJavascript.forEachItem(m_FoundlingHideExpression,i_body_2)
function i_body_2(child){
child();
}
HideUI();
}
HideUI.lblids["CAIDBIGLIETTO"]=['GAASOHZGZU','RQIGVOAJQW','FZYTZOJSLM'];
HideUI.lblids["TOTLIRE"]=['EZEZECLAKW'];
function SVYXZEMNRB_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('SVYXZEMNRB'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('SVYXZEMNRB').value=ApplyPictureToDate(Ctrl('SVYXZEMNRB').value,TranslatePicture(datePattern),'SVYXZEMNRB');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('SVYXZEMNRB'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('SVYXZEMNRB');
}
}
}
SetActiveField(Ctrl('SVYXZEMNRB'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATOPE','D',w_DATOPE,HtW(Ctrl('SVYXZEMNRB').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATOPE(HtW(Ctrl('SVYXZEMNRB').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function SVYXZEMNRB_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('SVYXZEMNRB'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('SVYXZEMNRB',w_DATOPE,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('SVYXZEMNRB');
SetActiveField(Ctrl('SVYXZEMNRB'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('SVYXZEMNRB'),e);
}
function SVYXZEMNRB_ZOOM_Click() {
LaunchCalendar(Ctrl('SVYXZEMNRB'));
}
function LIJFNMVRXK_Valid(e) {
SetActiveField(Ctrl('LIJFNMVRXK'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CAIDBIGLIETTO','C',w_CAIDBIGLIETTO,HtW(Ctrl('LIJFNMVRXK').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CAIDBIGLIETTO(HtW(Ctrl('LIJFNMVRXK').value,'C'),null,e);
return l_bSetResult;
}
}
function LIJFNMVRXK_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('LIJFNMVRXK'))) {
DisplayErrorMessage();
}
if (Ne(_tracker.ctrl,Ctrl('LIJFNMVRXK'))) {
SPBOUILib.WtH('LIJFNMVRXK',w_CAIDBIGLIETTO,'C',30,0,'!');
}
SetActiveField(Ctrl('LIJFNMVRXK'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('LIJFNMVRXK'),e);
}
function LIJFNMVRXK_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("!"));
}
function OGHOMBFTXJ_Valid(e) {
SetActiveField(Ctrl('OGHOMBFTXJ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TOTLIRE','N',w_TOTLIRE,HtW(Ctrl('OGHOMBFTXJ').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TOTLIRE(HtW(Ctrl('OGHOMBFTXJ').value,'N'),null,e);
return l_bSetResult;
}
}
function OGHOMBFTXJ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('OGHOMBFTXJ'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('OGHOMBFTXJ',w_TOTLIRE,'N',12,2,'999999999.99');
SetActiveField(Ctrl('OGHOMBFTXJ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('OGHOMBFTXJ'),e);
}
function OGHOMBFTXJ_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("999999999.99"));
}
function FPCQRNSIUW_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FLGFULL','C',w_FLGFULL,ChkboxValueAssign(Ctrl('FPCQRNSIUW'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FLGFULL(ChkboxValueAssign(Ctrl('FPCQRNSIUW'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function FPCQRNSIUW_OnFocus(e) {
SetActiveField(Ctrl('FPCQRNSIUW'),true);
}
function FPCQRNSIUW_OnBlur(e) {
SetActiveField(Ctrl('FPCQRNSIUW'),false);
}
function RWWIDDSYYG_Valid(e) {
SetActiveField(Ctrl('RWWIDDSYYG'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CPROWNUM','N',w_CPROWNUM,HtW(Ctrl('RWWIDDSYYG').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CPROWNUM(HtW(Ctrl('RWWIDDSYYG').value,'N'),null,e);
return l_bSetResult;
}
}
function RWWIDDSYYG_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('RWWIDDSYYG'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('RWWIDDSYYG'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('RWWIDDSYYG'),e);
}
function JMCVMUAWAP_Valid(e) {
SetActiveField(Ctrl('JMCVMUAWAP'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('NUMOPEDL','C',w_NUMOPEDL,HtW(Ctrl('JMCVMUAWAP').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_NUMOPEDL(HtW(Ctrl('JMCVMUAWAP').value,'C'),null,e);
return l_bSetResult;
}
}
function JMCVMUAWAP_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('JMCVMUAWAP'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('JMCVMUAWAP'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('JMCVMUAWAP'),e);
}
function ATYKZCFGTM_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('TIPOGIOCO','C',w_TIPOGIOCO,HtW(getComboValue(Ctrl('ATYKZCFGTM')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TIPOGIOCO(HtW(getComboValue(Ctrl('ATYKZCFGTM')),'C'),null,e);
return l_bSetResult;
}
}
function ATYKZCFGTM_OnFocus(e) {
SetActiveField(Ctrl('ATYKZCFGTM'),true);
}
function ATYKZCFGTM_OnBlur(e) {
SetActiveField(Ctrl('ATYKZCFGTM'),false);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function SVYXZEMNRB_wrap_Valid(event) {
return SVYXZEMNRB_Valid(event);
}
SPBOUILib.SetInputExit('SVYXZEMNRB',SVYXZEMNRB_wrap_Valid,SPBOUILib.Row.IN_GRID);
function SVYXZEMNRB_wrap_OnFocus(event) {
return SVYXZEMNRB_OnFocus(event);
}
SPBOUILib.SetInputEnter('SVYXZEMNRB',SVYXZEMNRB_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function SVYXZEMNRB_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('SVYXZEMNRB',SVYXZEMNRB_wrap_OnKeyPress,SPBOUILib.Row.IN_GRID);
function SVYXZEMNRB_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('SVYXZEMNRB',SVYXZEMNRB_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function SVYXZEMNRB_ZOOM_setHandlers() {
function SVYXZEMNRB_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?SVYXZEMNRB_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('SVYXZEMNRB_ZOOM',SVYXZEMNRB_ZOOM_wrap_OnClick,SPBOUILib.Row.IN_GRID);
}
SPBOUILib.SetPicker('SVYXZEMNRB',SVYXZEMNRB_ZOOM_setHandlers);
function LIJFNMVRXK_wrap_Valid(event) {
return LIJFNMVRXK_Valid(event);
}
SPBOUILib.SetInputExit('LIJFNMVRXK',LIJFNMVRXK_wrap_Valid,SPBOUILib.Row.IN_GRID);
function LIJFNMVRXK_wrap_OnFocus(event) {
return LIJFNMVRXK_OnFocus(event);
}
SPBOUILib.SetInputEnter('LIJFNMVRXK',LIJFNMVRXK_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function LIJFNMVRXK_wrap_OnKeyPress(event) {
return CheckUpper(event);
}
SPBOUILib.SetInputKeyPress('LIJFNMVRXK',LIJFNMVRXK_wrap_OnKeyPress,SPBOUILib.Row.IN_GRID);
function LIJFNMVRXK_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('LIJFNMVRXK',LIJFNMVRXK_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function OGHOMBFTXJ_wrap_Valid(event) {
return OGHOMBFTXJ_Valid(event);
}
SPBOUILib.SetInputExit('OGHOMBFTXJ',OGHOMBFTXJ_wrap_Valid,SPBOUILib.Row.IN_GRID);
function OGHOMBFTXJ_wrap_OnFocus(event) {
return OGHOMBFTXJ_OnFocus(event);
}
SPBOUILib.SetInputEnter('OGHOMBFTXJ',OGHOMBFTXJ_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function OGHOMBFTXJ_wrap_OnKeyPress(event) {
return OGHOMBFTXJ_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('OGHOMBFTXJ',OGHOMBFTXJ_wrap_OnKeyPress,SPBOUILib.Row.IN_GRID);
function OGHOMBFTXJ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('OGHOMBFTXJ',OGHOMBFTXJ_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function FPCQRNSIUW_wrap_Valid(event) {
return FPCQRNSIUW_Valid(event);
}
SPBOUILib.SetCheckboxClick('FPCQRNSIUW',FPCQRNSIUW_wrap_Valid,SPBOUILib.Row.IN_GRID);
function FPCQRNSIUW_wrap_OnFocus(event) {
return FPCQRNSIUW_OnFocus(event);
}
SPBOUILib.SetInputEnter('FPCQRNSIUW',FPCQRNSIUW_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function FPCQRNSIUW_wrap_Blur(event) {
return FPCQRNSIUW_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('FPCQRNSIUW',FPCQRNSIUW_wrap_Blur,SPBOUILib.Row.IN_GRID);
function RWWIDDSYYG_wrap_Valid(event) {
return RWWIDDSYYG_Valid(event);
}
SPBOUILib.SetInputExit('RWWIDDSYYG',RWWIDDSYYG_wrap_Valid);
function RWWIDDSYYG_wrap_OnFocus(event) {
return RWWIDDSYYG_OnFocus(event);
}
SPBOUILib.SetInputEnter('RWWIDDSYYG',RWWIDDSYYG_wrap_OnFocus);
function RWWIDDSYYG_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('RWWIDDSYYG',RWWIDDSYYG_wrap_OnKeyPress);
function RWWIDDSYYG_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('RWWIDDSYYG',RWWIDDSYYG_wrap_OnKeyDown);
function JMCVMUAWAP_wrap_Valid(event) {
return JMCVMUAWAP_Valid(event);
}
SPBOUILib.SetInputExit('JMCVMUAWAP',JMCVMUAWAP_wrap_Valid);
function JMCVMUAWAP_wrap_OnFocus(event) {
return JMCVMUAWAP_OnFocus(event);
}
SPBOUILib.SetInputEnter('JMCVMUAWAP',JMCVMUAWAP_wrap_OnFocus);
function JMCVMUAWAP_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('JMCVMUAWAP',JMCVMUAWAP_wrap_OnKeyDown);
function ATYKZCFGTM_wrap_Valid(event) {
return ATYKZCFGTM_Valid(event);
}
SPBOUILib.SetComboChange('ATYKZCFGTM',ATYKZCFGTM_wrap_Valid,SPBOUILib.Row.IN_GRID);
function ATYKZCFGTM_wrap_OnFocus(event) {
return ATYKZCFGTM_OnFocus(event);
}
SPBOUILib.SetInputEnter('ATYKZCFGTM',ATYKZCFGTM_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function ATYKZCFGTM_wrap_Blur(event) {
return ATYKZCFGTM_OnBlur(event);
}
SPBOUILib.SetInputExit('ATYKZCFGTM',ATYKZCFGTM_wrap_Blur,SPBOUILib.Row.IN_GRID);
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
m_oFather.i_last_focused_item='child_ardt_cgo_oper_storico_multi';
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
windowOpenForeground('../doc/ardt_cgo_oper_storico_multi_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_SNAINUMOPE=a[0];
w_DATOPE=a[1];
w_CAIDBIGLIETTO=a[2];
w_TOTLIRE=a[3];
w_FLGFULL=a[4];
w_CPROWNUM=a[5];
w_NUMOPEDL=a[6];
w_TIPOGIOCO=a[7];
w_TOTALE=a[8];
w_CGOTIPOPE=a[9];
w_tipogio=a[10];
w_impmin=a[11];
if (Gt(a.length,12)) {
o_TOTLIRE=w_TOTLIRE;
}
m_PrimaryKeys=['CPROWNUM','SNAINUMOPE'];
}
function i_PrimaryKey() {
return 'cgo_operazioni_storico_multi'+'\\'+CPLib.ToCPStr(w_SNAINUMOPE);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('ardt_cgo_oper_storico_multi',m_cSelectedPage);
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
var candidatesToFocus = ["SVYXZEMNRB"];
SetControlFocus(candidatesToFocus);
}
IsRepeatedChild.child=[];
function GetFullRowMsgError() {
return 'MSG_FULLROW_NOT_SAT';
}
_Obli('CAIDBIGLIETTO',0,'LIJFNMVRXK',false,"10524120562")
_Obli('TOTLIRE',1,'OGHOMBFTXJ',false,"1991862041")
_Obli('NUMOPEDL',0,'JMCVMUAWAP',false,"129387910")
_Obli('CPROWNUM',1,'RWWIDDSYYG',false,"1742621518")
_Obli('DATOPE',2,'SVYXZEMNRB',false,"829201110")
_Obli('TIPOGIOCO',0,'ATYKZCFGTM',false,"1603759671")
_Obli('FLGFULL',0,'FPCQRNSIUW',false,"11739699278")
