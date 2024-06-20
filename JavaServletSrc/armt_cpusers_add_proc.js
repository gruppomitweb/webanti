function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('ZREZPELSUN',function(){return WtH(w_CODDIP,'C',6,0,'')},w_CODDIP);
var tmp_MIUSAXPCSV = ToHTag(AsControlValue(w_xDESCRIZ));
if (Ne(e_MIUSAXPCSV,tmp_MIUSAXPCSV)) {
SPBOUILib.SetLabelValue('MIUSAXPCSV','innerHTML',tmp_MIUSAXPCSV);
e_MIUSAXPCSV=tmp_MIUSAXPCSV;
}
SPBOUILib.SetInputValue('FNBYGXHNIM',function(){return WtH(w_NAME,'C',30,0,'')},w_NAME);
SPBOUILib.SetInputValue('FXNTRTAGEY',function(){return WtH(w_SURNAME,'C',35,0,'')},w_SURNAME);
SPBOUILib.SetInputValue('PAUJKEOANA',function(){return WtH(w_EMAIL,'C',50,0,'')},w_EMAIL);
SPBOUILib.SetInputValue('ZOWNCPBLEN',function(){return WtH(w_EMPLOYEE,'C',10,0,'')},w_EMPLOYEE);
if(c=Ctrl('APFQXJVZBE')) ChkboxCheckUncheck(c,'S',w_SUPERDIP)
if(c=Ctrl('APFQXJVZBE')) ChkboxValueAssign(c,'S','N','C',1,0,'')
SPBOUILib.SetInputValue('ELUCVKUSNX',function(){return WtH(w_DATECREATE,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATECREATE);
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
HideUI.lblids["CODDIP"]=['BGFYJGORLM'];
HideUI.lblids["DATECREATE"]=['VOXMXEKIUF'];
HideUI.lblids["EMAIL"]=['LMRGKWVTUE'];
HideUI.lblids["EMPLOYEE"]=['BIOERCWZCX'];
HideUI.lblids["NAME"]=['BFBTXOURMI'];
HideUI.lblids["SURNAME"]=['ANEEIMQZLW'];
function ZREZPELSUN_Valid(e) {
SetActiveField(Ctrl('ZREZPELSUN'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CODDIP','C',w_CODDIP,HtW(Ctrl('ZREZPELSUN').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODDIP(HtW(Ctrl('ZREZPELSUN').value,'C'),null,e);
return l_bSetResult;
}
}
function ZREZPELSUN_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ZREZPELSUN'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('ZREZPELSUN'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ZREZPELSUN'),e);
}
function ZREZPELSUN_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('ZREZPELSUN')),'linkview_ZREZPELSUN','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function FNBYGXHNIM_Valid(e) {
SetActiveField(Ctrl('FNBYGXHNIM'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('NAME','C',w_NAME,HtW(Ctrl('FNBYGXHNIM').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_NAME(HtW(Ctrl('FNBYGXHNIM').value,'C'),null,e);
return l_bSetResult;
}
}
function FNBYGXHNIM_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('FNBYGXHNIM'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('FNBYGXHNIM'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('FNBYGXHNIM'),e);
}
function FXNTRTAGEY_Valid(e) {
SetActiveField(Ctrl('FXNTRTAGEY'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('SURNAME','C',w_SURNAME,HtW(Ctrl('FXNTRTAGEY').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_SURNAME(HtW(Ctrl('FXNTRTAGEY').value,'C'),null,e);
return l_bSetResult;
}
}
function FXNTRTAGEY_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('FXNTRTAGEY'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('FXNTRTAGEY'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('FXNTRTAGEY'),e);
}
function PAUJKEOANA_Valid(e) {
SetActiveField(Ctrl('PAUJKEOANA'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('EMAIL','C',w_EMAIL,HtW(Ctrl('PAUJKEOANA').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_EMAIL(HtW(Ctrl('PAUJKEOANA').value,'C'),null,e);
return l_bSetResult;
}
}
function PAUJKEOANA_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('PAUJKEOANA'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('PAUJKEOANA'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('PAUJKEOANA'),e);
}
function ZOWNCPBLEN_Valid(e) {
SetActiveField(Ctrl('ZOWNCPBLEN'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('EMPLOYEE','C',w_EMPLOYEE,HtW(Ctrl('ZOWNCPBLEN').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_EMPLOYEE(HtW(Ctrl('ZOWNCPBLEN').value,'C'),null,e);
return l_bSetResult;
}
}
function ZOWNCPBLEN_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ZOWNCPBLEN'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('ZOWNCPBLEN'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ZOWNCPBLEN'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function ZREZPELSUN_wrap_Valid(event) {
return ZREZPELSUN_Valid(event);
}
SPBOUILib.SetInputExit('ZREZPELSUN',ZREZPELSUN_wrap_Valid);
function ZREZPELSUN_wrap_OnFocus(event) {
return ZREZPELSUN_OnFocus(event);
}
SPBOUILib.SetInputEnter('ZREZPELSUN',ZREZPELSUN_wrap_OnFocus);
function ZREZPELSUN_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('ZREZPELSUN',ZREZPELSUN_wrap_OnKeyDown);
function ZREZPELSUN_ZOOM_setHandlers() {
function ZREZPELSUN_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?ZREZPELSUN_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('ZREZPELSUN_ZOOM',ZREZPELSUN_ZOOM_wrap_OnClick);
function ZREZPELSUN_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('ZREZPELSUN_ZOOM',ZREZPELSUN_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('ZREZPELSUN',ZREZPELSUN_ZOOM_setHandlers);
function FNBYGXHNIM_wrap_Valid(event) {
return FNBYGXHNIM_Valid(event);
}
SPBOUILib.SetInputExit('FNBYGXHNIM',FNBYGXHNIM_wrap_Valid);
function FNBYGXHNIM_wrap_OnFocus(event) {
return FNBYGXHNIM_OnFocus(event);
}
SPBOUILib.SetInputEnter('FNBYGXHNIM',FNBYGXHNIM_wrap_OnFocus);
function FNBYGXHNIM_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('FNBYGXHNIM',FNBYGXHNIM_wrap_OnKeyDown);
function FXNTRTAGEY_wrap_Valid(event) {
return FXNTRTAGEY_Valid(event);
}
SPBOUILib.SetInputExit('FXNTRTAGEY',FXNTRTAGEY_wrap_Valid);
function FXNTRTAGEY_wrap_OnFocus(event) {
return FXNTRTAGEY_OnFocus(event);
}
SPBOUILib.SetInputEnter('FXNTRTAGEY',FXNTRTAGEY_wrap_OnFocus);
function FXNTRTAGEY_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('FXNTRTAGEY',FXNTRTAGEY_wrap_OnKeyDown);
function PAUJKEOANA_wrap_Valid(event) {
return PAUJKEOANA_Valid(event);
}
SPBOUILib.SetInputExit('PAUJKEOANA',PAUJKEOANA_wrap_Valid);
function PAUJKEOANA_wrap_OnFocus(event) {
return PAUJKEOANA_OnFocus(event);
}
SPBOUILib.SetInputEnter('PAUJKEOANA',PAUJKEOANA_wrap_OnFocus);
function PAUJKEOANA_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('PAUJKEOANA',PAUJKEOANA_wrap_OnKeyDown);
function ZOWNCPBLEN_wrap_Valid(event) {
return ZOWNCPBLEN_Valid(event);
}
SPBOUILib.SetInputExit('ZOWNCPBLEN',ZOWNCPBLEN_wrap_Valid);
function ZOWNCPBLEN_wrap_OnFocus(event) {
return ZOWNCPBLEN_OnFocus(event);
}
SPBOUILib.SetInputEnter('ZOWNCPBLEN',ZOWNCPBLEN_wrap_OnFocus);
function ZOWNCPBLEN_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('ZOWNCPBLEN',ZOWNCPBLEN_wrap_OnKeyDown);
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
m_oFather.i_last_focused_item='child_armt_cpusers_add';
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
}
m_nLastError=0;
m_cLastMsgError='';
}
FocusFirstComponent.edit={"page_1":["ZREZPELSUN"]};
FocusFirstComponent.query={"page_1":["ZREZPELSUN"]};
FocusFirstComponent.otherwise={"page_1":["ZREZPELSUN"]};
function Help() {
windowOpenForeground('../doc/armt_cpusers_add_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_CODE=a[0];
w_CODDIP=a[1];
w_NAME=a[2];
w_SURNAME=a[3];
w_EMAIL=a[4];
w_EMPLOYEE=a[5];
w_SUPERDIP=a[6];
w_DATECREATE=a[7];
w_xDESCRIZ=a[8];
m_PrimaryKeys=['CODE'];
}
function i_PrimaryKey() {
return 'cpusers_add'+'\\'+CPLib.ToCPStr(w_CODE);
}
function CheckZone(me) {
if (IsWndAccessible(window['m_oFather'])) {
return m_oFather.CheckZone('child_armt_cpusers_add');
}
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('armt_cpusers_add',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
function LinkZoomExtendedMenu() {
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_CODDIP,'C'); },"field":"CODDIP","type":"C"},{"expression":function() { return WtA(w_xDESCRIZ,'C'); },"field":"DESCRIZ","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('anadip','C'),"uid":"ZREZPELSUN"});
}
_Obli('SURNAME',0,'FXNTRTAGEY',false,"1816546867")
_Obli('CODDIP',0,'ZREZPELSUN',false,"10228423721")
_Obli('EMAIL',0,'PAUJKEOANA',false,"7534101")
_Obli('NAME',0,'FNBYGXHNIM',false,"443454")
_Obli('EMPLOYEE',0,'ZOWNCPBLEN',false,"11123647547")
