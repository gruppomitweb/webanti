function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('VULKXBOZMY',function(){return WtH(w_RAPPORTO,'C',25,0,'')},w_RAPPORTO);
SPBOUILib.SetInputValue('TVVYAPQCUU',function(){return WtH(w_DESCRAP,'C',50,0,'')},w_DESCRAP);
if(c=Ctrl('XONZUZFGJE')) selectCombo(c,w_TIPOMOV,'C')
SPBOUILib.SetInputValue('FIYLJWMFNJ',function(){return WtH(w_DATAOPE,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATAOPE);
SPBOUILib.SetInputValue('UZGJEPKANK',function(){return WtH(w_CODINTEST,'C',16,0,'')},w_CODINTEST);
SPBOUILib.SetInputValue('TVQKRQXOUS',function(){return WtH(w_TXTERR,'M',10,0,'')},w_TXTERR);
if(c=Ctrl('AYCRVWSEMG')) ChkboxCheckUncheck(c,'S',w_FLGFULL)
if(c=Ctrl('AYCRVWSEMG')) ChkboxValueAssign(c,'S','N','C',1,0,'')
SPBOUILib.SetInputValue('IKBJDXURXZ',function(){return WtH(w_PRGRAP,'C',15,0,'')},w_PRGRAP);
SPBOUILib.SetInputValue('YQXXQDWDUP',function(){return WtH(w_CASTATOM,'N',3,0,'')},w_CASTATOM);
SPBOUILib.SetInputValue('VLNPAMWOBU',function(){return WtH(w_CASTATOC,'N',3,0,'')},w_CASTATOC);
var tmp_UICYBOOODG = ToHTag(AsControlValue(w_xSCDESCRI));
if (Ne(e_UICYBOOODG,tmp_UICYBOOODG)) {
SPBOUILib.SetLabelValue('UICYBOOODG','innerHTML',tmp_UICYBOOODG);
e_UICYBOOODG=tmp_UICYBOOODG;
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
HideUI.lblids["CASTATOC"]=['FHBNLOQFMI'];
HideUI.lblids["CASTATOM"]=['WLVLXNFYHR'];
HideUI.lblids["CODINTEST"]=['IGWTGITSGJ'];
HideUI.lblids["DATAOPE"]=['RGRSWHYTSF'];
HideUI.lblids["DESCRAP"]=['IFVPMKBRSJ'];
HideUI.lblids["PRGRAP"]=['QXNOUCGXYB'];
HideUI.lblids["RAPPORTO"]=['UTJHKVEODD'];
HideUI.lblids["TIPOMOV"]=['CKZCJWYZYS'];
function VULKXBOZMY_Valid(e) {
SetActiveField(Ctrl('VULKXBOZMY'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('RAPPORTO','C',w_RAPPORTO,HtW(Ctrl('VULKXBOZMY').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_RAPPORTO(HtW(Ctrl('VULKXBOZMY').value,'C'),null,e);
return l_bSetResult;
}
}
function VULKXBOZMY_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('VULKXBOZMY'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('VULKXBOZMY'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('VULKXBOZMY'),e);
}
function VULKXBOZMY_ZOOM_Click() {
}
function TVVYAPQCUU_Valid(e) {
SetActiveField(Ctrl('TVVYAPQCUU'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DESCRAP','C',w_DESCRAP,HtW(Ctrl('TVVYAPQCUU').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DESCRAP(HtW(Ctrl('TVVYAPQCUU').value,'C'),null,e);
return l_bSetResult;
}
}
function TVVYAPQCUU_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('TVVYAPQCUU'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('TVVYAPQCUU'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('TVVYAPQCUU'),e);
}
function TVVYAPQCUU_ZOOM_Click() {
}
function XONZUZFGJE_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('TIPOMOV','C',w_TIPOMOV,HtW(getComboValue(Ctrl('XONZUZFGJE')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TIPOMOV(HtW(getComboValue(Ctrl('XONZUZFGJE')),'C'),null,e);
return l_bSetResult;
}
}
function XONZUZFGJE_OnFocus(e) {
SetActiveField(Ctrl('XONZUZFGJE'),true);
}
function XONZUZFGJE_OnBlur(e) {
SetActiveField(Ctrl('XONZUZFGJE'),false);
}
function FIYLJWMFNJ_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('FIYLJWMFNJ'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('FIYLJWMFNJ').value=ApplyPictureToDate(Ctrl('FIYLJWMFNJ').value,TranslatePicture(datePattern),'FIYLJWMFNJ');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('FIYLJWMFNJ'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('FIYLJWMFNJ');
}
}
}
SetActiveField(Ctrl('FIYLJWMFNJ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATAOPE','D',w_DATAOPE,HtW(Ctrl('FIYLJWMFNJ').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATAOPE(HtW(Ctrl('FIYLJWMFNJ').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function FIYLJWMFNJ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('FIYLJWMFNJ'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('FIYLJWMFNJ',w_DATAOPE,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('FIYLJWMFNJ');
SetActiveField(Ctrl('FIYLJWMFNJ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('FIYLJWMFNJ'),e);
}
function FIYLJWMFNJ_ZOOM_Click() {
LaunchCalendar(Ctrl('FIYLJWMFNJ'));
}
function UZGJEPKANK_Valid(e) {
SetActiveField(Ctrl('UZGJEPKANK'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CODINTEST','C',w_CODINTEST,HtW(Ctrl('UZGJEPKANK').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODINTEST(HtW(Ctrl('UZGJEPKANK').value,'C'),null,e);
return l_bSetResult;
}
}
function UZGJEPKANK_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('UZGJEPKANK'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('UZGJEPKANK'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('UZGJEPKANK'),e);
}
function UZGJEPKANK_ZOOM_Click() {
}
function TVQKRQXOUS_Valid(e) {
SetActiveField(Ctrl('TVQKRQXOUS'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TXTERR','M',w_TXTERR,HtW(Ctrl('TVQKRQXOUS').value,'M'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TXTERR(HtW(Ctrl('TVQKRQXOUS').value,'M'),null,e);
return l_bSetResult;
}
}
function TVQKRQXOUS_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('TVQKRQXOUS'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('TVQKRQXOUS'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('TVQKRQXOUS'),e);
}
function AYCRVWSEMG_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FLGFULL','C',w_FLGFULL,ChkboxValueAssign(Ctrl('AYCRVWSEMG'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FLGFULL(ChkboxValueAssign(Ctrl('AYCRVWSEMG'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function AYCRVWSEMG_OnFocus(e) {
SetActiveField(Ctrl('AYCRVWSEMG'),true);
}
function AYCRVWSEMG_OnBlur(e) {
SetActiveField(Ctrl('AYCRVWSEMG'),false);
}
function IKBJDXURXZ_Valid(e) {
SetActiveField(Ctrl('IKBJDXURXZ'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('IKBJDXURXZ') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('PRGRAP','C',w_PRGRAP,HtW(Ctrl('IKBJDXURXZ').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PRGRAP(HtW(Ctrl('IKBJDXURXZ').value,'C'),null,e);
return l_bSetResult;
}
}
function IKBJDXURXZ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('IKBJDXURXZ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('IKBJDXURXZ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('IKBJDXURXZ'),e);
}
function YQXXQDWDUP_Valid(e) {
SetActiveField(Ctrl('YQXXQDWDUP'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CASTATOM','N',w_CASTATOM,HtW(Ctrl('YQXXQDWDUP').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CASTATOM(HtW(Ctrl('YQXXQDWDUP').value,'N'),null,e);
return l_bSetResult;
}
}
function YQXXQDWDUP_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('YQXXQDWDUP'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('YQXXQDWDUP'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('YQXXQDWDUP'),e);
}
function YQXXQDWDUP_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('YQXXQDWDUP')),'linkview_YQXXQDWDUP','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function VLNPAMWOBU_Valid(e) {
SetActiveField(Ctrl('VLNPAMWOBU'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CASTATOC','N',w_CASTATOC,HtW(Ctrl('VLNPAMWOBU').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CASTATOC(HtW(Ctrl('VLNPAMWOBU').value,'N'),null,e);
return l_bSetResult;
}
}
function VLNPAMWOBU_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('VLNPAMWOBU'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('VLNPAMWOBU'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('VLNPAMWOBU'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function VULKXBOZMY_wrap_Valid(event) {
return VULKXBOZMY_Valid(event);
}
SPBOUILib.SetInputExit('VULKXBOZMY',VULKXBOZMY_wrap_Valid);
function VULKXBOZMY_wrap_OnFocus(event) {
return VULKXBOZMY_OnFocus(event);
}
SPBOUILib.SetInputEnter('VULKXBOZMY',VULKXBOZMY_wrap_OnFocus);
function VULKXBOZMY_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('VULKXBOZMY',VULKXBOZMY_wrap_OnKeyDown);
function VULKXBOZMY_ZOOM_setHandlers() {
function VULKXBOZMY_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?VULKXBOZMY_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('VULKXBOZMY_ZOOM',VULKXBOZMY_ZOOM_wrap_OnClick);
function VULKXBOZMY_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('VULKXBOZMY_ZOOM',VULKXBOZMY_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('VULKXBOZMY',VULKXBOZMY_ZOOM_setHandlers);
function TVVYAPQCUU_wrap_Valid(event) {
return TVVYAPQCUU_Valid(event);
}
SPBOUILib.SetInputExit('TVVYAPQCUU',TVVYAPQCUU_wrap_Valid);
function TVVYAPQCUU_wrap_OnFocus(event) {
return TVVYAPQCUU_OnFocus(event);
}
SPBOUILib.SetInputEnter('TVVYAPQCUU',TVVYAPQCUU_wrap_OnFocus);
function TVVYAPQCUU_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('TVVYAPQCUU',TVVYAPQCUU_wrap_OnKeyDown);
function TVVYAPQCUU_ZOOM_setHandlers() {
function TVVYAPQCUU_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?TVVYAPQCUU_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('TVVYAPQCUU_ZOOM',TVVYAPQCUU_ZOOM_wrap_OnClick);
function TVVYAPQCUU_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('TVVYAPQCUU_ZOOM',TVVYAPQCUU_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('TVVYAPQCUU',TVVYAPQCUU_ZOOM_setHandlers);
function XONZUZFGJE_wrap_Valid(event) {
return XONZUZFGJE_Valid(event);
}
SPBOUILib.SetComboChange('XONZUZFGJE',XONZUZFGJE_wrap_Valid);
function XONZUZFGJE_wrap_OnFocus(event) {
return XONZUZFGJE_OnFocus(event);
}
SPBOUILib.SetInputEnter('XONZUZFGJE',XONZUZFGJE_wrap_OnFocus);
function XONZUZFGJE_wrap_Blur(event) {
return XONZUZFGJE_OnBlur(event);
}
SPBOUILib.SetInputExit('XONZUZFGJE',XONZUZFGJE_wrap_Blur);
function FIYLJWMFNJ_wrap_Valid(event) {
return FIYLJWMFNJ_Valid(event);
}
SPBOUILib.SetInputExit('FIYLJWMFNJ',FIYLJWMFNJ_wrap_Valid);
function FIYLJWMFNJ_wrap_OnFocus(event) {
return FIYLJWMFNJ_OnFocus(event);
}
SPBOUILib.SetInputEnter('FIYLJWMFNJ',FIYLJWMFNJ_wrap_OnFocus);
function FIYLJWMFNJ_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('FIYLJWMFNJ',FIYLJWMFNJ_wrap_OnKeyPress);
function FIYLJWMFNJ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('FIYLJWMFNJ',FIYLJWMFNJ_wrap_OnKeyDown);
function FIYLJWMFNJ_ZOOM_setHandlers() {
function FIYLJWMFNJ_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?FIYLJWMFNJ_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('FIYLJWMFNJ_ZOOM',FIYLJWMFNJ_ZOOM_wrap_OnClick);
function FIYLJWMFNJ_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('FIYLJWMFNJ_ZOOM',FIYLJWMFNJ_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('FIYLJWMFNJ',FIYLJWMFNJ_ZOOM_setHandlers);
function UZGJEPKANK_wrap_Valid(event) {
return UZGJEPKANK_Valid(event);
}
SPBOUILib.SetInputExit('UZGJEPKANK',UZGJEPKANK_wrap_Valid);
function UZGJEPKANK_wrap_OnFocus(event) {
return UZGJEPKANK_OnFocus(event);
}
SPBOUILib.SetInputEnter('UZGJEPKANK',UZGJEPKANK_wrap_OnFocus);
function UZGJEPKANK_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('UZGJEPKANK',UZGJEPKANK_wrap_OnKeyDown);
function UZGJEPKANK_ZOOM_setHandlers() {
function UZGJEPKANK_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?UZGJEPKANK_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('UZGJEPKANK_ZOOM',UZGJEPKANK_ZOOM_wrap_OnClick);
function UZGJEPKANK_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('UZGJEPKANK_ZOOM',UZGJEPKANK_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('UZGJEPKANK',UZGJEPKANK_ZOOM_setHandlers);
function TVQKRQXOUS_wrap_Valid(event) {
return TVQKRQXOUS_Valid(event);
}
SPBOUILib.SetInputExit('TVQKRQXOUS',TVQKRQXOUS_wrap_Valid);
function TVQKRQXOUS_wrap_OnFocus(event) {
return TVQKRQXOUS_OnFocus(event);
}
SPBOUILib.SetInputEnter('TVQKRQXOUS',TVQKRQXOUS_wrap_OnFocus);
function AYCRVWSEMG_wrap_Valid(event) {
return AYCRVWSEMG_Valid(event);
}
SPBOUILib.SetCheckboxClick('AYCRVWSEMG',AYCRVWSEMG_wrap_Valid);
function AYCRVWSEMG_wrap_OnFocus(event) {
return AYCRVWSEMG_OnFocus(event);
}
SPBOUILib.SetInputEnter('AYCRVWSEMG',AYCRVWSEMG_wrap_OnFocus);
function AYCRVWSEMG_wrap_Blur(event) {
return AYCRVWSEMG_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('AYCRVWSEMG',AYCRVWSEMG_wrap_Blur);
function IKBJDXURXZ_wrap_Valid(event) {
return IKBJDXURXZ_Valid(event);
}
SPBOUILib.SetInputExit('IKBJDXURXZ',IKBJDXURXZ_wrap_Valid);
function IKBJDXURXZ_wrap_OnFocus(event) {
return IKBJDXURXZ_OnFocus(event);
}
SPBOUILib.SetInputEnter('IKBJDXURXZ',IKBJDXURXZ_wrap_OnFocus);
function IKBJDXURXZ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('IKBJDXURXZ',IKBJDXURXZ_wrap_OnKeyDown);
function YQXXQDWDUP_wrap_Valid(event) {
return YQXXQDWDUP_Valid(event);
}
SPBOUILib.SetInputExit('YQXXQDWDUP',YQXXQDWDUP_wrap_Valid);
function YQXXQDWDUP_wrap_OnFocus(event) {
return YQXXQDWDUP_OnFocus(event);
}
SPBOUILib.SetInputEnter('YQXXQDWDUP',YQXXQDWDUP_wrap_OnFocus);
function YQXXQDWDUP_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('YQXXQDWDUP',YQXXQDWDUP_wrap_OnKeyPress);
function YQXXQDWDUP_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('YQXXQDWDUP',YQXXQDWDUP_wrap_OnKeyDown);
function YQXXQDWDUP_ZOOM_setHandlers() {
function YQXXQDWDUP_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?YQXXQDWDUP_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('YQXXQDWDUP_ZOOM',YQXXQDWDUP_ZOOM_wrap_OnClick);
function YQXXQDWDUP_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('YQXXQDWDUP_ZOOM',YQXXQDWDUP_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('YQXXQDWDUP',YQXXQDWDUP_ZOOM_setHandlers);
function VLNPAMWOBU_wrap_Valid(event) {
return VLNPAMWOBU_Valid(event);
}
SPBOUILib.SetInputExit('VLNPAMWOBU',VLNPAMWOBU_wrap_Valid);
function VLNPAMWOBU_wrap_OnFocus(event) {
return VLNPAMWOBU_OnFocus(event);
}
SPBOUILib.SetInputEnter('VLNPAMWOBU',VLNPAMWOBU_wrap_OnFocus);
function VLNPAMWOBU_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('VLNPAMWOBU',VLNPAMWOBU_wrap_OnKeyPress);
function VLNPAMWOBU_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('VLNPAMWOBU',VLNPAMWOBU_wrap_OnKeyDown);
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
FocusFirstComponent.edit={"page_1":["VULKXBOZMY"]};
FocusFirstComponent.query={"page_1":["VULKXBOZMY"]};
FocusFirstComponent.otherwise={"page_1":["VULKXBOZMY"]};
function Help() {
windowOpenForeground('../doc/armt_cgo_rapporti_err_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_RAPPORTO=a[0];
w_DESCRAP=a[1];
w_TIPOMOV=a[2];
w_DATAOPE=a[3];
w_CODINTEST=a[4];
w_TXTERR=a[5];
w_FLGFULL=a[6];
w_PRGRAP=a[7];
w_CASTATOM=a[8];
w_CASTATOC=a[9];
w_xSCDESCRI=a[10];
m_PrimaryKeys=['PRGRAP'];
}
function i_PrimaryKey() {
return 'cgo_rapporti_err'+'\\'+CPLib.ToCPStr(w_PRGRAP);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('armt_cgo_rapporti_err',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
function LinkZoomExtendedMenu() {
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_CASTATOM,'N'); },"field":"SCCODICE","type":"N"},{"expression":function() { return WtA(w_xSCDESCRI,'C'); },"field":"SCDESCRI","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('cgo_statocard','C'),"uid":"YQXXQDWDUP"});
}
_Obli('RAPPORTO',0,'VULKXBOZMY',false,"11116511596")
_Obli('DESCRAP',0,'TVVYAPQCUU',false,"285808099")
_Obli('TIPOMOV',0,'XONZUZFGJE',false,"11787042165")
_Obli('DATAOPE',2,'FIYLJWMFNJ',false,"829201110")
_Obli('CODINTEST',0,'UZGJEPKANK',false,"11636076131")
_Obli('TXTERR',0,'TVQKRQXOUS',false,"118057317")
_Obli('FLGFULL',0,'AYCRVWSEMG',false,"1791194163")
_Obli('PRGRAP',0,'IKBJDXURXZ',false,"321938427")
_Obli('CASTATOM',1,'YQXXQDWDUP',false,"1467250113")
_Obli('CASTATOC',1,'VLNPAMWOBU',false,"973931140")
