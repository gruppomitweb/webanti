function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('CZPCNBGKRB',function(){return WtH(w_SOTGRU,'C',3,0,'')},w_SOTGRU);
SPBOUILib.SetInputValue('UBJZZZQLKR',function(){return WtH(w_DESCRI,'C',200,0,'')},w_DESCRI);
SPBOUILib.SetInputValue('OYIXBRVDAC',function(){return WtH(w_TIPOSOT,'C',1,0,'')},w_TIPOSOT);
SPBOUILib.SetInputValue('MARYIAMBRP',function(){return WtH(w_DATAINI,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATAINI);
SPBOUILib.SetInputValue('RLONUMWZMW',function(){return WtH(w_DATAFINE,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATAFINE);
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
HideUI.lblids["DATAFINE"]=['FODYHQDDAS'];
HideUI.lblids["DATAINI"]=['IUSDJIRNXV'];
HideUI.lblids["DESCRI"]=['POJAHNCBGV'];
HideUI.lblids["SOTGRU"]=['ERERTGVMXB'];
HideUI.lblids["TIPOSOT"]=['AKZUZUXFKR'];
function CZPCNBGKRB_Valid(e) {
SetActiveField(Ctrl('CZPCNBGKRB'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('CZPCNBGKRB') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('SOTGRU','C',w_SOTGRU,HtW(Ctrl('CZPCNBGKRB').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_SOTGRU(HtW(Ctrl('CZPCNBGKRB').value,'C'),null,e);
return l_bSetResult;
}
}
function CZPCNBGKRB_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('CZPCNBGKRB'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('CZPCNBGKRB'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('CZPCNBGKRB'),e);
}
function UBJZZZQLKR_Valid(e) {
SetActiveField(Ctrl('UBJZZZQLKR'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DESCRI','C',w_DESCRI,HtW(Ctrl('UBJZZZQLKR').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DESCRI(HtW(Ctrl('UBJZZZQLKR').value,'C'),null,e);
return l_bSetResult;
}
}
function UBJZZZQLKR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('UBJZZZQLKR'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('UBJZZZQLKR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('UBJZZZQLKR'),e);
}
function OYIXBRVDAC_Valid(e) {
SetActiveField(Ctrl('OYIXBRVDAC'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TIPOSOT','C',w_TIPOSOT,HtW(Ctrl('OYIXBRVDAC').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TIPOSOT(HtW(Ctrl('OYIXBRVDAC').value,'C'),null,e);
return l_bSetResult;
}
}
function OYIXBRVDAC_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('OYIXBRVDAC'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('OYIXBRVDAC'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('OYIXBRVDAC'),e);
}
function MARYIAMBRP_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('MARYIAMBRP'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('MARYIAMBRP').value=ApplyPictureToDate(Ctrl('MARYIAMBRP').value,TranslatePicture(datePattern),'MARYIAMBRP');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('MARYIAMBRP'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('MARYIAMBRP');
}
}
}
SetActiveField(Ctrl('MARYIAMBRP'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATAINI','D',w_DATAINI,HtW(Ctrl('MARYIAMBRP').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATAINI(HtW(Ctrl('MARYIAMBRP').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function MARYIAMBRP_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('MARYIAMBRP'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('MARYIAMBRP',w_DATAINI,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('MARYIAMBRP');
SetActiveField(Ctrl('MARYIAMBRP'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('MARYIAMBRP'),e);
}
function RLONUMWZMW_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('RLONUMWZMW'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('RLONUMWZMW').value=ApplyPictureToDate(Ctrl('RLONUMWZMW').value,TranslatePicture(datePattern),'RLONUMWZMW');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('RLONUMWZMW'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('RLONUMWZMW');
}
}
}
SetActiveField(Ctrl('RLONUMWZMW'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATAFINE','D',w_DATAFINE,HtW(Ctrl('RLONUMWZMW').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATAFINE(HtW(Ctrl('RLONUMWZMW').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function RLONUMWZMW_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('RLONUMWZMW'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('RLONUMWZMW',w_DATAFINE,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('RLONUMWZMW');
SetActiveField(Ctrl('RLONUMWZMW'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('RLONUMWZMW'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function CZPCNBGKRB_wrap_Valid(event) {
return CZPCNBGKRB_Valid(event);
}
SPBOUILib.SetInputExit('CZPCNBGKRB',CZPCNBGKRB_wrap_Valid);
function CZPCNBGKRB_wrap_OnFocus(event) {
return CZPCNBGKRB_OnFocus(event);
}
SPBOUILib.SetInputEnter('CZPCNBGKRB',CZPCNBGKRB_wrap_OnFocus);
function CZPCNBGKRB_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('CZPCNBGKRB',CZPCNBGKRB_wrap_OnKeyDown);
function UBJZZZQLKR_wrap_Valid(event) {
return UBJZZZQLKR_Valid(event);
}
SPBOUILib.SetInputExit('UBJZZZQLKR',UBJZZZQLKR_wrap_Valid);
function UBJZZZQLKR_wrap_OnFocus(event) {
return UBJZZZQLKR_OnFocus(event);
}
SPBOUILib.SetInputEnter('UBJZZZQLKR',UBJZZZQLKR_wrap_OnFocus);
function UBJZZZQLKR_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('UBJZZZQLKR',UBJZZZQLKR_wrap_OnKeyDown);
function OYIXBRVDAC_wrap_Valid(event) {
return OYIXBRVDAC_Valid(event);
}
SPBOUILib.SetInputExit('OYIXBRVDAC',OYIXBRVDAC_wrap_Valid);
function OYIXBRVDAC_wrap_OnFocus(event) {
return OYIXBRVDAC_OnFocus(event);
}
SPBOUILib.SetInputEnter('OYIXBRVDAC',OYIXBRVDAC_wrap_OnFocus);
function OYIXBRVDAC_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('OYIXBRVDAC',OYIXBRVDAC_wrap_OnKeyDown);
function MARYIAMBRP_wrap_Valid(event) {
return MARYIAMBRP_Valid(event);
}
SPBOUILib.SetInputExit('MARYIAMBRP',MARYIAMBRP_wrap_Valid);
function MARYIAMBRP_wrap_OnFocus(event) {
return MARYIAMBRP_OnFocus(event);
}
SPBOUILib.SetInputEnter('MARYIAMBRP',MARYIAMBRP_wrap_OnFocus);
function MARYIAMBRP_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('MARYIAMBRP',MARYIAMBRP_wrap_OnKeyPress);
function MARYIAMBRP_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('MARYIAMBRP',MARYIAMBRP_wrap_OnKeyDown);
function RLONUMWZMW_wrap_Valid(event) {
return RLONUMWZMW_Valid(event);
}
SPBOUILib.SetInputExit('RLONUMWZMW',RLONUMWZMW_wrap_Valid);
function RLONUMWZMW_wrap_OnFocus(event) {
return RLONUMWZMW_OnFocus(event);
}
SPBOUILib.SetInputEnter('RLONUMWZMW',RLONUMWZMW_wrap_OnFocus);
function RLONUMWZMW_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('RLONUMWZMW',RLONUMWZMW_wrap_OnKeyPress);
function RLONUMWZMW_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('RLONUMWZMW',RLONUMWZMW_wrap_OnKeyDown);
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
FocusFirstComponent.edit={"page_1":["UBJZZZQLKR"]};
FocusFirstComponent.query={"page_1":["CZPCNBGKRB"]};
FocusFirstComponent.otherwise={"page_1":["CZPCNBGKRB"]};
function Help() {
windowOpenForeground('../doc/armt_sgruattec_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_SOTGRU=a[0];
w_DESCRI=a[1];
w_TIPOSOT=a[2];
w_DATAINI=a[3];
w_DATAFINE=a[4];
m_PrimaryKeys=['SOTGRU'];
}
function i_PrimaryKey() {
return 'tbstgru'+'\\'+CPLib.ToCPStr(w_SOTGRU);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('armt_sgruattec',m_cSelectedPage);
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
_Obli('SOTGRU',0,'CZPCNBGKRB',false,"112851763")
_Obli('DESCRI',0,'UBJZZZQLKR',false,"285808099")
_Obli('TIPOSOT',0,'OYIXBRVDAC',false,"485092")
_Obli('DATAINI',2,'MARYIAMBRP',false,"1863368778")
_Obli('DATAFINE',2,'RLONUMWZMW',false,"661550207")
