function FillCombosValues() {
}
function FillInGridCombosValues(currentRow) {
var postfix = (Gt(currentRow,-1)?'_'+currentRow:'');
}
function SetControlsValue() {
var c;
if (Empty(m_cAltInterface) && (Eq(m_cFunction,'view') || Eq(m_cFunction,'query'))) {
SPBOUILib.SetInputValue('QOPKWXJPKL',function(){return WtH(w_CONNES,'C',16,0,'')},w_CONNES);
SPBOUILib.SetInputValue('INHXXZSCAR',function(){return WtH(w_DTRIL,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DTRIL);
SPBOUILib.SetInputValue('GOROYGEXRL',function(){return WtH(w_IDMOD,'C',10,0,'')},w_IDMOD);
SPBOUILib.SetInputValue('CRQBUMLMOU',function(){return WtH(w_DESMODEL,'C',200,0,'')},w_DESMODEL);
SPBOUILib.SetInputValue('ZRXVZSLZII',function(){return WtH(w_NOTA,'M',10,0,'')},w_NOTA);
} else {
SPBOUILib.SetInputValue('QOPKWXJPKL',function(){return WtH(w_CONNES,'C',16,0,'')},w_CONNES);
SPBOUILib.SetInputValue('INHXXZSCAR',function(){return WtH(w_DTRIL,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DTRIL);
SPBOUILib.SetInputValue('GOROYGEXRL',function(){return WtH(w_IDMOD,'C',10,0,'')},w_IDMOD);
SPBOUILib.SetInputValue('CRQBUMLMOU',function(){return WtH(w_DESMODEL,'C',200,0,'')},w_DESMODEL);
SPBOUILib.SetInputValue('YTRSZBFLPF',function(){return WtH(w_IDIND,'C',10,0,'')},w_IDIND);
SPBOUILib.SetInputValue('AIIXUOGHMQ',function(){return WtH(w_IDSUBIND,'C',10,0,'')},w_IDSUBIND);
SPBOUILib.SetInputValue('ZRXVZSLZII',function(){return WtH(w_NOTA,'M',10,0,'')},w_NOTA);
SPBOUILib.SetInputValue('GAQLFVLCMG',function(){return WtH(w_PROGIND,'C',10,0,'')},w_PROGIND);
SPBOUILib.SetInputValue('MRVGSJSKMR',function(){return WtH(w_DESCIND,'M',10,0,'')},w_DESCIND);
SPBOUILib.SetInputValue('IDTVCEOZJZ',function(){return WtH(w_PROGSUBIND,'C',10,0,'')},w_PROGSUBIND);
SPBOUILib.SetInputValue('TKUWOKAOHM',function(){return WtH(w_DESCSUB,'M',10,0,'')},w_DESCSUB);
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
HideUI.lblids["CONNES"]=['VVCNKCWPNA'];
HideUI.lblids["DTRIL"]=['TUNRJJUTGZ'];
HideUI.lblids["IDIND"]=['TLJVJOGKAK'];
HideUI.lblids["IDMOD"]=['NDLAECZVXA'];
HideUI.lblids["IDSUBIND"]=['JYMZKNEJIO'];
HideUI.lblids["NOTA"]=['IGINWTGEOG'];
function QOPKWXJPKL_Valid(e) {
SetActiveField(Ctrl('QOPKWXJPKL'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('QOPKWXJPKL') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('CONNES','C',w_CONNES,HtW(Ctrl('QOPKWXJPKL').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CONNES(HtW(Ctrl('QOPKWXJPKL').value,'C'),null,e);
return l_bSetResult;
}
}
function QOPKWXJPKL_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('QOPKWXJPKL'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('QOPKWXJPKL'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('QOPKWXJPKL'),e);
}
function INHXXZSCAR_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('INHXXZSCAR'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('INHXXZSCAR').value=ApplyPictureToDate(Ctrl('INHXXZSCAR').value,TranslatePicture(datePattern),'INHXXZSCAR');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('INHXXZSCAR'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('INHXXZSCAR');
}
}
}
SetActiveField(Ctrl('INHXXZSCAR'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('INHXXZSCAR') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('DTRIL','D',w_DTRIL,HtW(Ctrl('INHXXZSCAR').value,'D'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DTRIL(HtW(Ctrl('INHXXZSCAR').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function INHXXZSCAR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('INHXXZSCAR'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('INHXXZSCAR',w_DTRIL,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('INHXXZSCAR');
SetActiveField(Ctrl('INHXXZSCAR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('INHXXZSCAR'),e);
}
function INHXXZSCAR_ZOOM_Click() {
LaunchCalendar(Ctrl('INHXXZSCAR'));
}
function GOROYGEXRL_Valid(e) {
SetActiveField(Ctrl('GOROYGEXRL'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('GOROYGEXRL') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('IDMOD','C',w_IDMOD,HtW(Ctrl('GOROYGEXRL').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IDMOD(HtW(Ctrl('GOROYGEXRL').value,'C'),null,e);
return l_bSetResult;
}
}
function GOROYGEXRL_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('GOROYGEXRL'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('GOROYGEXRL'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('GOROYGEXRL'),e);
}
function GOROYGEXRL_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('GOROYGEXRL')),'linkview_GOROYGEXRL','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function YTRSZBFLPF_Valid(e) {
SetActiveField(Ctrl('YTRSZBFLPF'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('IDIND','C',w_IDIND,HtW(Ctrl('YTRSZBFLPF').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IDIND(HtW(Ctrl('YTRSZBFLPF').value,'C'),null,e);
return l_bSetResult;
}
}
function YTRSZBFLPF_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('YTRSZBFLPF'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('YTRSZBFLPF'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('YTRSZBFLPF'),e);
}
function YTRSZBFLPF_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('YTRSZBFLPF')),'linkview_YTRSZBFLPF','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function AIIXUOGHMQ_Valid(e) {
SetActiveField(Ctrl('AIIXUOGHMQ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('IDSUBIND','C',w_IDSUBIND,HtW(Ctrl('AIIXUOGHMQ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IDSUBIND(HtW(Ctrl('AIIXUOGHMQ').value,'C'),null,e);
return l_bSetResult;
}
}
function AIIXUOGHMQ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('AIIXUOGHMQ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('AIIXUOGHMQ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('AIIXUOGHMQ'),e);
}
function AIIXUOGHMQ_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('AIIXUOGHMQ')),'linkview_AIIXUOGHMQ','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function ZRXVZSLZII_Valid(e) {
SetActiveField(Ctrl('ZRXVZSLZII'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('NOTA','M',w_NOTA,HtW(Ctrl('ZRXVZSLZII').value,'M'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_NOTA(HtW(Ctrl('ZRXVZSLZII').value,'M'),null,e);
return l_bSetResult;
}
}
function ZRXVZSLZII_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ZRXVZSLZII'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('ZRXVZSLZII'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ZRXVZSLZII'),e);
}
function MRVGSJSKMR_Valid(e) {
SetActiveField(Ctrl('MRVGSJSKMR'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DESCIND','M',w_DESCIND,HtW(Ctrl('MRVGSJSKMR').value,'M'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DESCIND(HtW(Ctrl('MRVGSJSKMR').value,'M'),null,e);
return l_bSetResult;
}
}
function MRVGSJSKMR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('MRVGSJSKMR'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('MRVGSJSKMR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('MRVGSJSKMR'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function QOPKWXJPKL_wrap_Valid(event) {
return QOPKWXJPKL_Valid(event);
}
SPBOUILib.SetInputExit('QOPKWXJPKL',QOPKWXJPKL_wrap_Valid);
function QOPKWXJPKL_wrap_OnFocus(event) {
return QOPKWXJPKL_OnFocus(event);
}
SPBOUILib.SetInputEnter('QOPKWXJPKL',QOPKWXJPKL_wrap_OnFocus);
function QOPKWXJPKL_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('QOPKWXJPKL',QOPKWXJPKL_wrap_OnKeyDown);
function INHXXZSCAR_wrap_Valid(event) {
return INHXXZSCAR_Valid(event);
}
SPBOUILib.SetInputExit('INHXXZSCAR',INHXXZSCAR_wrap_Valid);
function INHXXZSCAR_wrap_OnFocus(event) {
return INHXXZSCAR_OnFocus(event);
}
SPBOUILib.SetInputEnter('INHXXZSCAR',INHXXZSCAR_wrap_OnFocus);
function INHXXZSCAR_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('INHXXZSCAR',INHXXZSCAR_wrap_OnKeyPress);
function INHXXZSCAR_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('INHXXZSCAR',INHXXZSCAR_wrap_OnKeyDown);
function INHXXZSCAR_ZOOM_setHandlers() {
function INHXXZSCAR_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?INHXXZSCAR_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('INHXXZSCAR_ZOOM',INHXXZSCAR_ZOOM_wrap_OnClick);
}
SPBOUILib.SetPicker('INHXXZSCAR',INHXXZSCAR_ZOOM_setHandlers);
function GOROYGEXRL_wrap_Valid(event) {
return GOROYGEXRL_Valid(event);
}
SPBOUILib.SetInputExit('GOROYGEXRL',GOROYGEXRL_wrap_Valid);
function GOROYGEXRL_wrap_OnFocus(event) {
return GOROYGEXRL_OnFocus(event);
}
SPBOUILib.SetInputEnter('GOROYGEXRL',GOROYGEXRL_wrap_OnFocus);
function GOROYGEXRL_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('GOROYGEXRL',GOROYGEXRL_wrap_OnKeyDown);
function GOROYGEXRL_ZOOM_setHandlers() {
function GOROYGEXRL_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?GOROYGEXRL_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('GOROYGEXRL_ZOOM',GOROYGEXRL_ZOOM_wrap_OnClick);
}
SPBOUILib.SetPicker('GOROYGEXRL',GOROYGEXRL_ZOOM_setHandlers);
function YTRSZBFLPF_wrap_Valid(event) {
return YTRSZBFLPF_Valid(event);
}
SPBOUILib.SetInputExit('YTRSZBFLPF',YTRSZBFLPF_wrap_Valid,SPBOUILib.Row.IN_GRID);
function YTRSZBFLPF_wrap_OnFocus(event) {
return YTRSZBFLPF_OnFocus(event);
}
SPBOUILib.SetInputEnter('YTRSZBFLPF',YTRSZBFLPF_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function YTRSZBFLPF_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('YTRSZBFLPF',YTRSZBFLPF_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function YTRSZBFLPF_ZOOM_setHandlers() {
function YTRSZBFLPF_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?YTRSZBFLPF_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('YTRSZBFLPF_ZOOM',YTRSZBFLPF_ZOOM_wrap_OnClick,SPBOUILib.Row.IN_GRID);
}
SPBOUILib.SetPicker('YTRSZBFLPF',YTRSZBFLPF_ZOOM_setHandlers);
function AIIXUOGHMQ_wrap_Valid(event) {
return AIIXUOGHMQ_Valid(event);
}
SPBOUILib.SetInputExit('AIIXUOGHMQ',AIIXUOGHMQ_wrap_Valid,SPBOUILib.Row.IN_GRID);
function AIIXUOGHMQ_wrap_OnFocus(event) {
return AIIXUOGHMQ_OnFocus(event);
}
SPBOUILib.SetInputEnter('AIIXUOGHMQ',AIIXUOGHMQ_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function AIIXUOGHMQ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('AIIXUOGHMQ',AIIXUOGHMQ_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function AIIXUOGHMQ_ZOOM_setHandlers() {
function AIIXUOGHMQ_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?AIIXUOGHMQ_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('AIIXUOGHMQ_ZOOM',AIIXUOGHMQ_ZOOM_wrap_OnClick,SPBOUILib.Row.IN_GRID);
}
SPBOUILib.SetPicker('AIIXUOGHMQ',AIIXUOGHMQ_ZOOM_setHandlers);
function ZRXVZSLZII_wrap_Valid(event) {
return ZRXVZSLZII_Valid(event);
}
SPBOUILib.SetInputExit('ZRXVZSLZII',ZRXVZSLZII_wrap_Valid);
function ZRXVZSLZII_wrap_OnFocus(event) {
return ZRXVZSLZII_OnFocus(event);
}
SPBOUILib.SetInputEnter('ZRXVZSLZII',ZRXVZSLZII_wrap_OnFocus);
function MRVGSJSKMR_wrap_Valid(event) {
return MRVGSJSKMR_Valid(event);
}
SPBOUILib.SetInputExit('MRVGSJSKMR',MRVGSJSKMR_wrap_Valid,SPBOUILib.Row.IN_GRID);
function MRVGSJSKMR_wrap_OnFocus(event) {
return MRVGSJSKMR_OnFocus(event);
}
SPBOUILib.SetInputEnter('MRVGSJSKMR',MRVGSJSKMR_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
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
m_bStopChangeRow=true;
} else if (Ne('undefined',typeof(m_nLastError))) {
m_bStopChangeRow=Eq(m_nLastError,-2);
}
m_nLastError=0;
m_cLastMsgError='';
}
FocusFirstComponent.edit={};
FocusFirstComponent.query={"page_1":["QOPKWXJPKL","INHXXZSCAR"]};
FocusFirstComponent.otherwise={"page_1":["INHXXZSCAR"]};
function Help() {
windowOpenForeground('../doc/aosdt_rilevazioni_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_CONNES=a[0];
w_DTRIL=a[1];
w_IDMOD=a[2];
w_IDIND=a[3];
w_IDSUBIND=a[4];
w_NOTA=a[5];
w_DESMODEL=a[6];
w_PROGIND=a[7];
w_DESCIND=a[8];
w_PROGSUBIND=a[9];
w_DESCSUB=a[10];
m_PrimaryKeys=['IDSUBIND','IDIND','IDMOD','DTRIL','CONNES'];
}
function i_PrimaryKey() {
return 'rilevazioni'+'\\'+CPLib.ToCPStr(w_CONNES)+'\\'+CPLib.ToCPStr(w_DTRIL)+'\\'+CPLib.ToCPStr(w_IDMOD);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('aosdt_rilevazioni',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
function LinkZoomExtendedMenu() {
ExtendedMenu({"configName":WtA('','C'),"entityName":WtA('aosmt_mod_ind_def','C'),"fldValues":[{"expression":function() { return WtA(w_IDMOD,'C'); },"field":"IDMOD","type":"C"},{"expression":function() { return WtA(w_DESMODEL,'C'); },"field":"DESCRI","type":"C"}],"itemRepeated":false,"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('mod_ind_def','C'),"uid":"GOROYGEXRL"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_IDIND,'C'); },"field":"IDIND","type":"C"},{"expression":function() { return WtA(w_PROGIND,'C'); },"field":"PROGIND","type":"C"},{"expression":function() { return WtA(w_DESCIND,'M'); },"field":"DESCRI","type":"M"}],"itemRepeated":true,"keyValues":[{"expression":function() { return WtA(w_IDMOD,'C'); },"field":"IDMOD","type":"C"}],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('ind_def','C'),"uid":"YTRSZBFLPF"});
ExtendedMenu({"configName":WtA('','C'),"entityName":WtA('aosdt_sub_ind_def','C'),"fldValues":[{"expression":function() { return WtA(w_IDSUBIND,'C'); },"field":"IDSUBIND","type":"C"},{"expression":function() { return WtA(w_PROGSUBIND,'C'); },"field":"PROGSUBIND","type":"C"},{"expression":function() { return WtA(w_DESCSUB,'M'); },"field":"DESCRI","type":"M"}],"itemRepeated":true,"keyValues":[{"expression":function() { return WtA(w_IDMOD,'C'); },"field":"IDMOD","type":"C"},{"expression":function() { return WtA(w_IDIND,'C'); },"field":"IDIND","type":"C"}],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('sub_ind_def','C'),"uid":"AIIXUOGHMQ"});
}
function FocusFirstDetailComponent() {
var candidatesToFocus = ["YTRSZBFLPF"];
SetControlFocus(candidatesToFocus);
}
IsRepeatedChild.child=[];
function GetFullRowMsgError() {
return 'MSG_FULLROW_NOT_SAT';
}
_Obli('CONNES',0,'QOPKWXJPKL',false,"10565397709")
_Obli('DTRIL',2,'INHXXZSCAR',false,"10173567207")
_Obli('IDMOD',0,'GOROYGEXRL',false,"10024211400")
_Obli('IDSUBIND',0,'AIIXUOGHMQ',false,"10783450750")
_Obli('IDIND',0,'YTRSZBFLPF',false,"1305674908")
_Obli('NOTA',0,'ZRXVZSLZII',false,"1654558139")
_Obli('DESCIND',0,'MRVGSJSKMR',false,"10298248210")
