function FillCombosValues() {
}
function FillInGridCombosValues(currentRow) {
var postfix = (Gt(currentRow,-1)?'_'+currentRow:'');
}
function SetControlsValue() {
var c;
if (Empty(m_cAltInterface) && (Eq(m_cFunction,'view') || Eq(m_cFunction,'query'))) {
SPBOUILib.SetInputValue('XMMPEEVCWS',function(){return WtH(w_CODDIP,'C',6,0,'')},w_CODDIP);
} else {
SPBOUILib.SetInputValue('XMMPEEVCWS',function(){return WtH(w_CODDIP,'C',6,0,'')},w_CODDIP);
SPBOUILib.SetInputValue('QWGGDAWZKO',function(){return WtH(w_TIPOANALISI,'C',1,0,'')},w_TIPOANALISI);
SPBOUILib.SetInputValue('JUUWNCIHQE',function(){return WtH(w_DATAINI,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATAINI);
SPBOUILib.SetInputValue('BLDMLQOFYI',function(){return WtH(w_DATFIN,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATFIN);
SPBOUILib.SetInputValue('RNIHJWFMTF',function(){return WtH(w_RISGLOB,'C',1,0,'')},w_RISGLOB);
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
HideUI.lblids["CODDIP"]=['FCULACGICV'];
HideUI.lblids["DATAINI"]=['DHPQHUZGRB'];
HideUI.lblids["DATFIN"]=['CTRVUCDTPC'];
HideUI.lblids["RISGLOB"]=['IXQCNZJEGP'];
HideUI.lblids["TIPOANALISI"]=['KBUYKYRDAM'];
function XMMPEEVCWS_Valid(e) {
SetActiveField(Ctrl('XMMPEEVCWS'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('XMMPEEVCWS') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('CODDIP','C',w_CODDIP,HtW(Ctrl('XMMPEEVCWS').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODDIP(HtW(Ctrl('XMMPEEVCWS').value,'C'),null,e);
return l_bSetResult;
}
}
function XMMPEEVCWS_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('XMMPEEVCWS'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('XMMPEEVCWS'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('XMMPEEVCWS'),e);
}
function QWGGDAWZKO_Valid(e) {
SetActiveField(Ctrl('QWGGDAWZKO'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TIPOANALISI','C',w_TIPOANALISI,HtW(Ctrl('QWGGDAWZKO').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TIPOANALISI(HtW(Ctrl('QWGGDAWZKO').value,'C'),null,e);
return l_bSetResult;
}
}
function QWGGDAWZKO_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('QWGGDAWZKO'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('QWGGDAWZKO'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('QWGGDAWZKO'),e);
}
function JUUWNCIHQE_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('JUUWNCIHQE'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('JUUWNCIHQE').value=ApplyPictureToDate(Ctrl('JUUWNCIHQE').value,TranslatePicture(datePattern),'JUUWNCIHQE');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('JUUWNCIHQE'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('JUUWNCIHQE');
}
}
}
SetActiveField(Ctrl('JUUWNCIHQE'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATAINI','D',w_DATAINI,HtW(Ctrl('JUUWNCIHQE').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATAINI(HtW(Ctrl('JUUWNCIHQE').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function JUUWNCIHQE_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('JUUWNCIHQE'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('JUUWNCIHQE',w_DATAINI,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('JUUWNCIHQE');
SetActiveField(Ctrl('JUUWNCIHQE'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('JUUWNCIHQE'),e);
}
function JUUWNCIHQE_ZOOM_Click() {
LaunchCalendar(Ctrl('JUUWNCIHQE'));
}
function BLDMLQOFYI_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('BLDMLQOFYI'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('BLDMLQOFYI').value=ApplyPictureToDate(Ctrl('BLDMLQOFYI').value,TranslatePicture(datePattern),'BLDMLQOFYI');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('BLDMLQOFYI'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('BLDMLQOFYI');
}
}
}
SetActiveField(Ctrl('BLDMLQOFYI'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATFIN','D',w_DATFIN,HtW(Ctrl('BLDMLQOFYI').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATFIN(HtW(Ctrl('BLDMLQOFYI').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function BLDMLQOFYI_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('BLDMLQOFYI'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('BLDMLQOFYI',w_DATFIN,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('BLDMLQOFYI');
SetActiveField(Ctrl('BLDMLQOFYI'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('BLDMLQOFYI'),e);
}
function BLDMLQOFYI_ZOOM_Click() {
LaunchCalendar(Ctrl('BLDMLQOFYI'));
}
function RNIHJWFMTF_Valid(e) {
SetActiveField(Ctrl('RNIHJWFMTF'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('RISGLOB','C',w_RISGLOB,HtW(Ctrl('RNIHJWFMTF').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_RISGLOB(HtW(Ctrl('RNIHJWFMTF').value,'C'),null,e);
return l_bSetResult;
}
}
function RNIHJWFMTF_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('RNIHJWFMTF'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('RNIHJWFMTF'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('RNIHJWFMTF'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function XMMPEEVCWS_wrap_Valid(event) {
return XMMPEEVCWS_Valid(event);
}
SPBOUILib.SetInputExit('XMMPEEVCWS',XMMPEEVCWS_wrap_Valid);
function XMMPEEVCWS_wrap_OnFocus(event) {
return XMMPEEVCWS_OnFocus(event);
}
SPBOUILib.SetInputEnter('XMMPEEVCWS',XMMPEEVCWS_wrap_OnFocus);
function XMMPEEVCWS_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('XMMPEEVCWS',XMMPEEVCWS_wrap_OnKeyDown);
function QWGGDAWZKO_wrap_Valid(event) {
return QWGGDAWZKO_Valid(event);
}
SPBOUILib.SetInputExit('QWGGDAWZKO',QWGGDAWZKO_wrap_Valid,SPBOUILib.Row.IN_GRID);
function QWGGDAWZKO_wrap_OnFocus(event) {
return QWGGDAWZKO_OnFocus(event);
}
SPBOUILib.SetInputEnter('QWGGDAWZKO',QWGGDAWZKO_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function QWGGDAWZKO_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('QWGGDAWZKO',QWGGDAWZKO_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function JUUWNCIHQE_wrap_Valid(event) {
return JUUWNCIHQE_Valid(event);
}
SPBOUILib.SetInputExit('JUUWNCIHQE',JUUWNCIHQE_wrap_Valid,SPBOUILib.Row.IN_GRID);
function JUUWNCIHQE_wrap_OnFocus(event) {
return JUUWNCIHQE_OnFocus(event);
}
SPBOUILib.SetInputEnter('JUUWNCIHQE',JUUWNCIHQE_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function JUUWNCIHQE_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('JUUWNCIHQE',JUUWNCIHQE_wrap_OnKeyPress,SPBOUILib.Row.IN_GRID);
function JUUWNCIHQE_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('JUUWNCIHQE',JUUWNCIHQE_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function JUUWNCIHQE_ZOOM_setHandlers() {
function JUUWNCIHQE_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?JUUWNCIHQE_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('JUUWNCIHQE_ZOOM',JUUWNCIHQE_ZOOM_wrap_OnClick,SPBOUILib.Row.IN_GRID);
}
SPBOUILib.SetPicker('JUUWNCIHQE',JUUWNCIHQE_ZOOM_setHandlers);
function BLDMLQOFYI_wrap_Valid(event) {
return BLDMLQOFYI_Valid(event);
}
SPBOUILib.SetInputExit('BLDMLQOFYI',BLDMLQOFYI_wrap_Valid,SPBOUILib.Row.IN_GRID);
function BLDMLQOFYI_wrap_OnFocus(event) {
return BLDMLQOFYI_OnFocus(event);
}
SPBOUILib.SetInputEnter('BLDMLQOFYI',BLDMLQOFYI_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function BLDMLQOFYI_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('BLDMLQOFYI',BLDMLQOFYI_wrap_OnKeyPress,SPBOUILib.Row.IN_GRID);
function BLDMLQOFYI_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('BLDMLQOFYI',BLDMLQOFYI_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function BLDMLQOFYI_ZOOM_setHandlers() {
function BLDMLQOFYI_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?BLDMLQOFYI_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('BLDMLQOFYI_ZOOM',BLDMLQOFYI_ZOOM_wrap_OnClick,SPBOUILib.Row.IN_GRID);
}
SPBOUILib.SetPicker('BLDMLQOFYI',BLDMLQOFYI_ZOOM_setHandlers);
function RNIHJWFMTF_wrap_Valid(event) {
return RNIHJWFMTF_Valid(event);
}
SPBOUILib.SetInputExit('RNIHJWFMTF',RNIHJWFMTF_wrap_Valid,SPBOUILib.Row.IN_GRID);
function RNIHJWFMTF_wrap_OnFocus(event) {
return RNIHJWFMTF_OnFocus(event);
}
SPBOUILib.SetInputEnter('RNIHJWFMTF',RNIHJWFMTF_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function RNIHJWFMTF_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('RNIHJWFMTF',RNIHJWFMTF_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
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
m_oFather.i_last_focused_item='child_ardt_rischiodip';
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
FocusFirstComponent.query={"page_1":["XMMPEEVCWS"]};
FocusFirstComponent.otherwise={"page_1":["XMMPEEVCWS"]};
function Help() {
windowOpenForeground('../doc/ardt_rischiodip_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_CODDIP=a[0];
w_TIPOANALISI=a[1];
w_DATAINI=a[2];
w_DATFIN=a[3];
w_RISGLOB=a[4];
m_PrimaryKeys=['DATAINI','TIPOANALISI','CODDIP'];
}
function i_PrimaryKey() {
return 'rischiodip'+'\\'+CPLib.ToCPStr(w_CODDIP);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('ardt_rischiodip',m_cSelectedPage);
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
var candidatesToFocus = ["QWGGDAWZKO"];
SetControlFocus(candidatesToFocus);
}
IsRepeatedChild.child=[];
function GetFullRowMsgError() {
return 'MSG_FULLROW_NOT_SAT';
}
_Obli('CODDIP',0,'XMMPEEVCWS',false,"2071283709")
_Obli('TIPOANALISI',0,'QWGGDAWZKO',false,"1631071168")
_Obli('DATAINI',2,'JUUWNCIHQE',false,"718958839")
_Obli('DATFIN',2,'BLDMLQOFYI',false,"10307319262")
_Obli('RISGLOB',0,'RNIHJWFMTF',false,"1979623906")
