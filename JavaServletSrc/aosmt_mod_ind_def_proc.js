function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('NCOATMFFKT',function(){return WtH(w_IDMOD,'C',10,0,'')},w_IDMOD);
SPBOUILib.SetInputValue('HKGLDDMZGV',function(){return WtH(w_IDMODMIT,'C',10,0,'')},w_IDMODMIT);
SPBOUILib.SetInputValue('YZXQRACPYA',function(){return WtH(w_DESCRI,'C',200,0,'')},w_DESCRI);
SPBOUILib.SetInputValue('CGQOPHKKPM',function(){return WtH(w_DTFINVAL,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DTFINVAL);
if(c=Ctrl('ETQZOSKLPW')) ChkboxCheckUncheck(c,true,w_show_noapplic)
if(c=Ctrl('ETQZOSKLPW')) ChkboxValueAssign(c,true,false,'L',1,0,'')
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
HideUI.lblids["DESCRI"]=['HSNNXIWVML'];
HideUI.lblids["DTFINVAL"]=['QAIWHGTEMM'];
HideUI.lblids["IDMOD"]=['IDTKRMICCD'];
HideUI.lblids["IDMODMIT"]=['KETJDULPCM'];
function ExpandCollapseBoxesUnderCondition() {
var cond;
}
function NCOATMFFKT_Valid(e) {
SetActiveField(Ctrl('NCOATMFFKT'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('NCOATMFFKT') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('IDMOD','C',w_IDMOD,HtW(Ctrl('NCOATMFFKT').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IDMOD(HtW(Ctrl('NCOATMFFKT').value,'C'),null,e);
return l_bSetResult;
}
}
function NCOATMFFKT_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('NCOATMFFKT'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('NCOATMFFKT'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('NCOATMFFKT'),e);
}
function HKGLDDMZGV_Valid(e) {
SetActiveField(Ctrl('HKGLDDMZGV'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('IDMODMIT','C',w_IDMODMIT,HtW(Ctrl('HKGLDDMZGV').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IDMODMIT(HtW(Ctrl('HKGLDDMZGV').value,'C'),null,e);
return l_bSetResult;
}
}
function HKGLDDMZGV_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('HKGLDDMZGV'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('HKGLDDMZGV'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('HKGLDDMZGV'),e);
}
function HKGLDDMZGV_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('HKGLDDMZGV')),'linkview_HKGLDDMZGV','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function YZXQRACPYA_Valid(e) {
SetActiveField(Ctrl('YZXQRACPYA'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DESCRI','C',w_DESCRI,HtW(Ctrl('YZXQRACPYA').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DESCRI(HtW(Ctrl('YZXQRACPYA').value,'C'),null,e);
return l_bSetResult;
}
}
function YZXQRACPYA_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('YZXQRACPYA'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('YZXQRACPYA'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('YZXQRACPYA'),e);
}
function CGQOPHKKPM_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('CGQOPHKKPM'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('CGQOPHKKPM').value=ApplyPictureToDate(Ctrl('CGQOPHKKPM').value,TranslatePicture(datePattern),'CGQOPHKKPM');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('CGQOPHKKPM'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('CGQOPHKKPM');
}
}
}
SetActiveField(Ctrl('CGQOPHKKPM'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DTFINVAL','D',w_DTFINVAL,HtW(Ctrl('CGQOPHKKPM').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DTFINVAL(HtW(Ctrl('CGQOPHKKPM').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function CGQOPHKKPM_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('CGQOPHKKPM'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('CGQOPHKKPM',w_DTFINVAL,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('CGQOPHKKPM');
SetActiveField(Ctrl('CGQOPHKKPM'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('CGQOPHKKPM'),e);
}
function CGQOPHKKPM_ZOOM_Click() {
LaunchCalendar(Ctrl('CGQOPHKKPM'));
}
function ETQZOSKLPW_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('show_noapplic','L',w_show_noapplic,ChkboxValueAssign(Ctrl('ETQZOSKLPW'),true,false,'L',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_show_noapplic(ChkboxValueAssign(Ctrl('ETQZOSKLPW'),true,false,'L',1,0,''),null,e);
return l_bSetResult;
}
}
function ETQZOSKLPW_OnFocus(e) {
SetActiveField(Ctrl('ETQZOSKLPW'),true);
}
function ETQZOSKLPW_OnBlur(e) {
SetActiveField(Ctrl('ETQZOSKLPW'),false);
}
linkpc_url.u('SGBDWLUNZC',function(){return 'aosdt_ind_def?m_bInnerChild=true'+GetLinkPCKeys('aosdt_ind_def')+'&m_bRowsChild='+EnableChild('aosdt_ind_def')})
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function NCOATMFFKT_wrap_Valid(event) {
return NCOATMFFKT_Valid(event);
}
SPBOUILib.SetInputExit('NCOATMFFKT',NCOATMFFKT_wrap_Valid);
function NCOATMFFKT_wrap_OnFocus(event) {
return NCOATMFFKT_OnFocus(event);
}
SPBOUILib.SetInputEnter('NCOATMFFKT',NCOATMFFKT_wrap_OnFocus);
function NCOATMFFKT_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('NCOATMFFKT',NCOATMFFKT_wrap_OnKeyDown);
function HKGLDDMZGV_wrap_Valid(event) {
return HKGLDDMZGV_Valid(event);
}
SPBOUILib.SetInputExit('HKGLDDMZGV',HKGLDDMZGV_wrap_Valid);
function HKGLDDMZGV_wrap_OnFocus(event) {
return HKGLDDMZGV_OnFocus(event);
}
SPBOUILib.SetInputEnter('HKGLDDMZGV',HKGLDDMZGV_wrap_OnFocus);
function HKGLDDMZGV_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('HKGLDDMZGV',HKGLDDMZGV_wrap_OnKeyDown);
function HKGLDDMZGV_ZOOM_setHandlers() {
function HKGLDDMZGV_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?HKGLDDMZGV_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('HKGLDDMZGV_ZOOM',HKGLDDMZGV_ZOOM_wrap_OnClick);
function HKGLDDMZGV_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('HKGLDDMZGV_ZOOM',HKGLDDMZGV_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('HKGLDDMZGV',HKGLDDMZGV_ZOOM_setHandlers);
function YZXQRACPYA_wrap_Valid(event) {
return YZXQRACPYA_Valid(event);
}
SPBOUILib.SetInputExit('YZXQRACPYA',YZXQRACPYA_wrap_Valid);
function YZXQRACPYA_wrap_OnFocus(event) {
return YZXQRACPYA_OnFocus(event);
}
SPBOUILib.SetInputEnter('YZXQRACPYA',YZXQRACPYA_wrap_OnFocus);
function YZXQRACPYA_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('YZXQRACPYA',YZXQRACPYA_wrap_OnKeyDown);
function CGQOPHKKPM_wrap_Valid(event) {
return CGQOPHKKPM_Valid(event);
}
SPBOUILib.SetInputExit('CGQOPHKKPM',CGQOPHKKPM_wrap_Valid);
function CGQOPHKKPM_wrap_OnFocus(event) {
return CGQOPHKKPM_OnFocus(event);
}
SPBOUILib.SetInputEnter('CGQOPHKKPM',CGQOPHKKPM_wrap_OnFocus);
function CGQOPHKKPM_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('CGQOPHKKPM',CGQOPHKKPM_wrap_OnKeyPress);
function CGQOPHKKPM_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('CGQOPHKKPM',CGQOPHKKPM_wrap_OnKeyDown);
function CGQOPHKKPM_ZOOM_setHandlers() {
function CGQOPHKKPM_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?CGQOPHKKPM_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('CGQOPHKKPM_ZOOM',CGQOPHKKPM_ZOOM_wrap_OnClick);
function CGQOPHKKPM_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('CGQOPHKKPM_ZOOM',CGQOPHKKPM_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('CGQOPHKKPM',CGQOPHKKPM_ZOOM_setHandlers);
function ETQZOSKLPW_wrap_Valid(event) {
return ETQZOSKLPW_Valid(event);
}
SPBOUILib.SetCheckboxClick('ETQZOSKLPW',ETQZOSKLPW_wrap_Valid);
function ETQZOSKLPW_wrap_OnFocus(event) {
return ETQZOSKLPW_OnFocus(event);
}
SPBOUILib.SetInputEnter('ETQZOSKLPW',ETQZOSKLPW_wrap_OnFocus);
function ETQZOSKLPW_wrap_Blur(event) {
return ETQZOSKLPW_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('ETQZOSKLPW',ETQZOSKLPW_wrap_Blur);
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
FocusFirstComponent.edit={"page_1":["HKGLDDMZGV"]};
FocusFirstComponent.query={"page_1":["NCOATMFFKT"]};
FocusFirstComponent.otherwise={"page_1":["NCOATMFFKT"]};
function Help() {
windowOpenForeground('../doc/aosmt_mod_ind_def_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
}
function CalledBatchEnd() {
if ( ! (m_bCalculating)) {
DoUpdate(true);
}
}
function SetModified_aosdt_ind_def() {
SetModified();
}
function LoadChildrenInPage(page,lazy) {
if (Eq(page,'page_1')) {
if (ChildToLoad('SGBDWLUNZC')) {
LoadContext.lc(1,'SGBDWLUNZC');
} else {
LibJavascript.RefreshChildGrid('SGBDWLUNZC');
}
}
}
function DeclareWVs() {
var a = arguments;
w_IDMOD=a[0];
w_IDMODMIT=a[1];
w_DESCRI=a[2];
w_DTFINVAL=a[3];
w_show_noapplic=a[4];
w_pippo=a[5];
m_cWv_aosdt_ind_def=a[6];
if (Gt(a.length,7)) {
m_cErrorInChild='';
}
if (Gt(a.length,7)) {
o_show_noapplic=w_show_noapplic;
}
m_PrimaryKeys=['IDMOD'];
}
function i_PrimaryKey() {
return 'mod_ind_def'+'\\'+CPLib.ToCPStr(w_IDMOD);
}
GetLinkPCKeys.set_o('aosdt_ind_def',false);
GetLinkPCKeys.o['aosdt_ind_def']['IDMOD']=function(t){
if (Ne(m_cFunction,'new')) {
return t(w_IDMOD,'C');
}
}
resizeChildIframe.children['aosdt_ind_def']=true;
function EnableChild(name) {
var l_bRes = false;
return l_bRes;
}
function CheckZone(me) {
return true;
}
LoadContext.f('SGBDWLUNZC',function(){return FrameRef('aosdt_ind_def')},1,'aosdt_ind_def',1,1)
GetSelectedChildPage.child={'aosdt_ind_def': function(){return FrameRef('aosdt_ind_def')}}
function GetSelectedPage(p_d) {
p_d.setValue('aosmt_mod_ind_def',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
function LinkZoomExtendedMenu() {
ExtendedMenu({"configName":WtA('','C'),"entityName":WtA('aosmt_mod_ind_mit','C'),"fldValues":[{"expression":function() { return WtA(w_IDMODMIT,'C'); },"field":"IDMOD","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('mod_ind_mit','C'),"uid":"HKGLDDMZGV"});
}
_Obli('IDMOD',0,'NCOATMFFKT',false,"10024211400")
_Obli('IDMODMIT',0,'HKGLDDMZGV',false,"10292644895")
_Obli('DESCRI',0,'YZXQRACPYA',false,"285808099")
_Obli('DTFINVAL',2,'CGQOPHKKPM',false,"12121244978")
_Obli('show_noapplic',4,'ETQZOSKLPW',false,"10273053127")
