function FillCombosValues() {
}
function SetControlsValue() {
var c;
var tmp_subtitle = ToHTag(AsControlValue('ID del modello: '+w_IDMOD+'Descrizione: '+w_DESCRI));
if (Ne(e_subtitle,tmp_subtitle)) {
SetSubTitle(tmp_subtitle);
e_subtitle=tmp_subtitle;
}
SPBOUILib.SetInputValue('TCWUZWNTZL',function(){return WtH(w_IDMOD,'C',10,0,'')},w_IDMOD);
SPBOUILib.SetInputValue('XOFACNRAZT',function(){return WtH(w_DESCRI,'C',200,0,'')},w_DESCRI);
SPBOUILib.SetInputValue('EBIILAMEXQ',function(){return WtH(w_DTFINVAL,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DTFINVAL);
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
HideUI.lblids["DESCRI"]=['KVHRTKBQDB'];
HideUI.lblids["DTFINVAL"]=['IIBQBZKTYC'];
HideUI.lblids["IDMOD"]=['GIKZFYHJBH'];
function ExpandCollapseBoxesUnderCondition() {
var cond;
}
function TCWUZWNTZL_Valid(e) {
SetActiveField(Ctrl('TCWUZWNTZL'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('TCWUZWNTZL') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('IDMOD','C',w_IDMOD,HtW(Ctrl('TCWUZWNTZL').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IDMOD(HtW(Ctrl('TCWUZWNTZL').value,'C'),null,e);
return l_bSetResult;
}
}
function TCWUZWNTZL_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('TCWUZWNTZL'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('TCWUZWNTZL'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('TCWUZWNTZL'),e);
}
function XOFACNRAZT_Valid(e) {
SetActiveField(Ctrl('XOFACNRAZT'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DESCRI','C',w_DESCRI,HtW(Ctrl('XOFACNRAZT').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DESCRI(HtW(Ctrl('XOFACNRAZT').value,'C'),null,e);
return l_bSetResult;
}
}
function XOFACNRAZT_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('XOFACNRAZT'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('XOFACNRAZT'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('XOFACNRAZT'),e);
}
function EBIILAMEXQ_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('EBIILAMEXQ'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('EBIILAMEXQ').value=ApplyPictureToDate(Ctrl('EBIILAMEXQ').value,TranslatePicture(datePattern),'EBIILAMEXQ');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('EBIILAMEXQ'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('EBIILAMEXQ');
}
}
}
SetActiveField(Ctrl('EBIILAMEXQ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DTFINVAL','D',w_DTFINVAL,HtW(Ctrl('EBIILAMEXQ').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DTFINVAL(HtW(Ctrl('EBIILAMEXQ').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function EBIILAMEXQ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('EBIILAMEXQ'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('EBIILAMEXQ',w_DTFINVAL,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('EBIILAMEXQ');
SetActiveField(Ctrl('EBIILAMEXQ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('EBIILAMEXQ'),e);
}
function EBIILAMEXQ_ZOOM_Click() {
LaunchCalendar(Ctrl('EBIILAMEXQ'));
}
linkpc_url.u('SWEGOMKTPV',function(){return 'aosdt_ind_mit?m_bInnerChild=true'+GetLinkPCKeys('aosdt_ind_mit')+'&m_bRowsChild='+EnableChild('aosdt_ind_mit')})
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function TCWUZWNTZL_wrap_Valid(event) {
return TCWUZWNTZL_Valid(event);
}
SPBOUILib.SetInputExit('TCWUZWNTZL',TCWUZWNTZL_wrap_Valid);
function TCWUZWNTZL_wrap_OnFocus(event) {
return TCWUZWNTZL_OnFocus(event);
}
SPBOUILib.SetInputEnter('TCWUZWNTZL',TCWUZWNTZL_wrap_OnFocus);
function TCWUZWNTZL_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('TCWUZWNTZL',TCWUZWNTZL_wrap_OnKeyDown);
function XOFACNRAZT_wrap_Valid(event) {
return XOFACNRAZT_Valid(event);
}
SPBOUILib.SetInputExit('XOFACNRAZT',XOFACNRAZT_wrap_Valid);
function XOFACNRAZT_wrap_OnFocus(event) {
return XOFACNRAZT_OnFocus(event);
}
SPBOUILib.SetInputEnter('XOFACNRAZT',XOFACNRAZT_wrap_OnFocus);
function XOFACNRAZT_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('XOFACNRAZT',XOFACNRAZT_wrap_OnKeyDown);
function EBIILAMEXQ_wrap_Valid(event) {
return EBIILAMEXQ_Valid(event);
}
SPBOUILib.SetInputExit('EBIILAMEXQ',EBIILAMEXQ_wrap_Valid);
function EBIILAMEXQ_wrap_OnFocus(event) {
return EBIILAMEXQ_OnFocus(event);
}
SPBOUILib.SetInputEnter('EBIILAMEXQ',EBIILAMEXQ_wrap_OnFocus);
function EBIILAMEXQ_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('EBIILAMEXQ',EBIILAMEXQ_wrap_OnKeyPress);
function EBIILAMEXQ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('EBIILAMEXQ',EBIILAMEXQ_wrap_OnKeyDown);
function EBIILAMEXQ_ZOOM_setHandlers() {
function EBIILAMEXQ_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?EBIILAMEXQ_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('EBIILAMEXQ_ZOOM',EBIILAMEXQ_ZOOM_wrap_OnClick);
function EBIILAMEXQ_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('EBIILAMEXQ_ZOOM',EBIILAMEXQ_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('EBIILAMEXQ',EBIILAMEXQ_ZOOM_setHandlers);
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
FocusFirstComponent.edit={"page_1":["XOFACNRAZT"]};
FocusFirstComponent.query={"page_1":["TCWUZWNTZL","XOFACNRAZT"]};
FocusFirstComponent.otherwise={"page_1":["TCWUZWNTZL","XOFACNRAZT"]};
function Help() {
windowOpenForeground('../doc/aosmt_mod_ind_mit_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
}
function CalledBatchEnd() {
if ( ! (m_bCalculating)) {
DoUpdate(true);
}
}
function SetModified_aosdt_ind_mit() {
SetModified();
}
function LoadChildrenInPage(page,lazy) {
if (Eq(page,'page_1')) {
if (ChildToLoad('SWEGOMKTPV')) {
LoadContext.lc(1,'SWEGOMKTPV');
} else {
LibJavascript.RefreshChildGrid('SWEGOMKTPV');
}
}
}
function DeclareWVs() {
var a = arguments;
w_IDMOD=a[0];
w_DESCRI=a[1];
w_DTFINVAL=a[2];
m_cWv_aosdt_ind_mit=a[3];
if (Gt(a.length,4)) {
m_cErrorInChild='';
}
m_PrimaryKeys=['IDMOD'];
}
function i_PrimaryKey() {
return 'mod_ind_mit'+'\\'+CPLib.ToCPStr(w_IDMOD);
}
GetLinkPCKeys.set_o('aosdt_ind_mit',false);
GetLinkPCKeys.o['aosdt_ind_mit']['IDMOD']=function(t){
if (Ne(m_cFunction,'new')) {
return t(w_IDMOD,'C');
}
}
resizeChildIframe.children['aosdt_ind_mit']=true;
function EnableChild(name) {
var l_bRes = false;
return l_bRes;
}
function CheckZone(me) {
return true;
}
LoadContext.f('SWEGOMKTPV',function(){return FrameRef('aosdt_ind_mit')},1,'aosdt_ind_mit',1,1)
GetSelectedChildPage.child={'aosdt_ind_mit': function(){return FrameRef('aosdt_ind_mit')}}
function GetSelectedPage(p_d) {
p_d.setValue('aosmt_mod_ind_mit',m_cSelectedPage);
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
_Obli('IDMOD',0,'TCWUZWNTZL',false,"10024211400")
_Obli('DESCRI',0,'XOFACNRAZT',false,"285808099")
_Obli('DTFINVAL',2,'EBIILAMEXQ',false,"12121244978")
