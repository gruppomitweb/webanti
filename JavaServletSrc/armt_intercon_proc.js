function FillCombosValues() {
FillCombo('HZZPORVTBI','HZZPORVTBI');
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('ANDQNEUQUI',function(){return WtH(w_CODINTER,'C',11,0,'')},w_CODINTER);
SPBOUILib.SetInputValue('WXKLPEPPUN',function(){return WtH(w_CODDIPE,'C',6,0,'')},w_CODDIPE);
SPBOUILib.SetInputValue('SIYQQKBTIK',function(){return WtH(w_RAGSOC,'C',70,0,'')},w_RAGSOC);
if(c=Ctrl('HZZPORVTBI')) selectCombo(c,w_TIPINTER,'C')
SPBOUILib.SetInputValue('LVOWHGDALM',function(){return WtH(w_PAESE,'C',3,0,'')},w_PAESE);
SPBOUILib.SetInputValue('XOKLSKJFHK',function(){return WtH(w_DESCCIT,'C',30,0,'')},w_DESCCIT);
SPBOUILib.SetInputValue('OIVKASXTIR',function(){return WtH(w_DOMICILIO,'C',35,0,'')},w_DOMICILIO);
SPBOUILib.SetInputValue('AXFWAKGSHQ',function(){return WtH(w_CODFISC,'C',16,0,'')},w_CODFISC);
SPBOUILib.SetInputValue('VOEEALQGUW',function(){return WtH(w_CODCAB,'C',6,0,'')},w_CODCAB);
SPBOUILib.SetInputValue('YISYHKQCXD',function(){return WtH(w_PROVINCIA,'C',2,0,'')},w_PROVINCIA);
SPBOUILib.SetInputValue('PWIUWUQDIG',function(){return WtH(w_CAP,'C',9,0,'')},w_CAP);
SPBOUILib.SetInputValue('CANNGIJPXY',function(){return WtH(w_PARTIVA,'C',14,0,'')},w_PARTIVA);
var tmp_MBBSFJYMNY = ToHTag(AsControlValue(w_xdescstat));
if (Ne(e_MBBSFJYMNY,tmp_MBBSFJYMNY)) {
SPBOUILib.SetLabelValue('MBBSFJYMNY','innerHTML',tmp_MBBSFJYMNY);
e_MBBSFJYMNY=tmp_MBBSFJYMNY;
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
SetDisplay('YORQOIOBQN_DIV',IsHiddenByStateDriver('box_YORQOIOBQN'));
LibJavascript.forEachItem(m_FoundlingHideExpression,i_body_2)
function i_body_2(child){
child();
}
HideUI();
}
HideUI.lblids["CAP"]=['YNWDCIJLLS'];
HideUI.lblids["CODCAB"]=['WWYHQLCAGG'];
HideUI.lblids["CODDIPE"]=['DBTKRCAIXF'];
HideUI.lblids["CODFISC"]=['JKOVVRJEML'];
HideUI.lblids["CODINTER"]=['ECPMSJUNTQ'];
HideUI.lblids["DESCCIT"]=['SRXCHXRLSY'];
HideUI.lblids["DOMICILIO"]=['FMEOZGJGSS'];
HideUI.lblids["PAESE"]=['WAKXLIJMNM'];
HideUI.lblids["PARTIVA"]=['IBIAJNESYR'];
HideUI.lblids["PROVINCIA"]=['IBCXYPHYZP'];
HideUI.lblids["RAGSOC"]=['MWTXZQPAPZ'];
HideUI.lblids["TIPINTER"]=['YUDFBDSXPJ'];
function ANDQNEUQUI_Valid(e) {
SetActiveField(Ctrl('ANDQNEUQUI'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('ANDQNEUQUI') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('CODINTER','C',w_CODINTER,HtW(Ctrl('ANDQNEUQUI').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODINTER(HtW(Ctrl('ANDQNEUQUI').value,'C'),null,e);
return l_bSetResult;
}
}
function ANDQNEUQUI_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ANDQNEUQUI'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('ANDQNEUQUI'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ANDQNEUQUI'),e);
}
function WXKLPEPPUN_Valid(e) {
SetActiveField(Ctrl('WXKLPEPPUN'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CODDIPE','C',w_CODDIPE,HtW(Ctrl('WXKLPEPPUN').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODDIPE(HtW(Ctrl('WXKLPEPPUN').value,'C'),null,e);
return l_bSetResult;
}
}
function WXKLPEPPUN_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('WXKLPEPPUN'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('WXKLPEPPUN'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('WXKLPEPPUN'),e);
}
function SIYQQKBTIK_Valid(e) {
SetActiveField(Ctrl('SIYQQKBTIK'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('RAGSOC','C',w_RAGSOC,HtW(Ctrl('SIYQQKBTIK').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_RAGSOC(HtW(Ctrl('SIYQQKBTIK').value,'C'),null,e);
return l_bSetResult;
}
}
function SIYQQKBTIK_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('SIYQQKBTIK'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('SIYQQKBTIK'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('SIYQQKBTIK'),e);
}
function HZZPORVTBI_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('TIPINTER','C',w_TIPINTER,HtW(getComboValue(Ctrl('HZZPORVTBI')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TIPINTER(HtW(getComboValue(Ctrl('HZZPORVTBI')),'C'),null,e);
return l_bSetResult;
}
}
function HZZPORVTBI_OnFocus(e) {
SetActiveField(Ctrl('HZZPORVTBI'),true);
}
function HZZPORVTBI_OnBlur(e) {
SetActiveField(Ctrl('HZZPORVTBI'),false);
}
function LVOWHGDALM_Valid(e) {
SetActiveField(Ctrl('LVOWHGDALM'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('PAESE','C',w_PAESE,HtW(Ctrl('LVOWHGDALM').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PAESE(HtW(Ctrl('LVOWHGDALM').value,'C'),null,e);
return l_bSetResult;
}
}
function LVOWHGDALM_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('LVOWHGDALM'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('LVOWHGDALM'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('LVOWHGDALM'),e);
}
function LVOWHGDALM_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('LVOWHGDALM')),'linkview_LVOWHGDALM','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function XOKLSKJFHK_Valid(e) {
SetActiveField(Ctrl('XOKLSKJFHK'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DESCCIT','C',w_DESCCIT,HtW(Ctrl('XOKLSKJFHK').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DESCCIT(HtW(Ctrl('XOKLSKJFHK').value,'C'),null,e);
return l_bSetResult;
}
}
function XOKLSKJFHK_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('XOKLSKJFHK'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('XOKLSKJFHK'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('XOKLSKJFHK'),e);
}
function XOKLSKJFHK_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('XOKLSKJFHK')),'linkview_XOKLSKJFHK','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function OIVKASXTIR_Valid(e) {
SetActiveField(Ctrl('OIVKASXTIR'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DOMICILIO','C',w_DOMICILIO,HtW(Ctrl('OIVKASXTIR').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DOMICILIO(HtW(Ctrl('OIVKASXTIR').value,'C'),null,e);
return l_bSetResult;
}
}
function OIVKASXTIR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('OIVKASXTIR'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('OIVKASXTIR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('OIVKASXTIR'),e);
}
function AXFWAKGSHQ_Valid(e) {
SetActiveField(Ctrl('AXFWAKGSHQ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CODFISC','C',w_CODFISC,HtW(Ctrl('AXFWAKGSHQ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODFISC(HtW(Ctrl('AXFWAKGSHQ').value,'C'),null,e);
return l_bSetResult;
}
}
function AXFWAKGSHQ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('AXFWAKGSHQ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('AXFWAKGSHQ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('AXFWAKGSHQ'),e);
}
function YISYHKQCXD_Valid(e) {
SetActiveField(Ctrl('YISYHKQCXD'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('PROVINCIA','C',w_PROVINCIA,HtW(Ctrl('YISYHKQCXD').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PROVINCIA(HtW(Ctrl('YISYHKQCXD').value,'C'),null,e);
return l_bSetResult;
}
}
function YISYHKQCXD_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('YISYHKQCXD'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('YISYHKQCXD'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('YISYHKQCXD'),e);
}
function PWIUWUQDIG_Valid(e) {
SetActiveField(Ctrl('PWIUWUQDIG'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CAP','C',w_CAP,HtW(Ctrl('PWIUWUQDIG').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CAP(HtW(Ctrl('PWIUWUQDIG').value,'C'),null,e);
return l_bSetResult;
}
}
function PWIUWUQDIG_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('PWIUWUQDIG'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('PWIUWUQDIG'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('PWIUWUQDIG'),e);
}
function CANNGIJPXY_Valid(e) {
SetActiveField(Ctrl('CANNGIJPXY'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('PARTIVA','C',w_PARTIVA,HtW(Ctrl('CANNGIJPXY').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PARTIVA(HtW(Ctrl('CANNGIJPXY').value,'C'),null,e);
return l_bSetResult;
}
}
function CANNGIJPXY_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('CANNGIJPXY'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('CANNGIJPXY'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('CANNGIJPXY'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function ANDQNEUQUI_wrap_Valid(event) {
return ANDQNEUQUI_Valid(event);
}
SPBOUILib.SetInputExit('ANDQNEUQUI',ANDQNEUQUI_wrap_Valid);
function ANDQNEUQUI_wrap_OnFocus(event) {
return ANDQNEUQUI_OnFocus(event);
}
SPBOUILib.SetInputEnter('ANDQNEUQUI',ANDQNEUQUI_wrap_OnFocus);
function ANDQNEUQUI_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('ANDQNEUQUI',ANDQNEUQUI_wrap_OnKeyDown);
function WXKLPEPPUN_wrap_Valid(event) {
return WXKLPEPPUN_Valid(event);
}
SPBOUILib.SetInputExit('WXKLPEPPUN',WXKLPEPPUN_wrap_Valid);
function WXKLPEPPUN_wrap_OnFocus(event) {
return WXKLPEPPUN_OnFocus(event);
}
SPBOUILib.SetInputEnter('WXKLPEPPUN',WXKLPEPPUN_wrap_OnFocus);
function WXKLPEPPUN_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('WXKLPEPPUN',WXKLPEPPUN_wrap_OnKeyDown);
function SIYQQKBTIK_wrap_Valid(event) {
return SIYQQKBTIK_Valid(event);
}
SPBOUILib.SetInputExit('SIYQQKBTIK',SIYQQKBTIK_wrap_Valid);
function SIYQQKBTIK_wrap_OnFocus(event) {
return SIYQQKBTIK_OnFocus(event);
}
SPBOUILib.SetInputEnter('SIYQQKBTIK',SIYQQKBTIK_wrap_OnFocus);
function SIYQQKBTIK_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('SIYQQKBTIK',SIYQQKBTIK_wrap_OnKeyDown);
function HZZPORVTBI_wrap_Valid(event) {
return HZZPORVTBI_Valid(event);
}
SPBOUILib.SetComboChange('HZZPORVTBI',HZZPORVTBI_wrap_Valid);
function HZZPORVTBI_wrap_OnFocus(event) {
return HZZPORVTBI_OnFocus(event);
}
SPBOUILib.SetInputEnter('HZZPORVTBI',HZZPORVTBI_wrap_OnFocus);
function HZZPORVTBI_wrap_Blur(event) {
return HZZPORVTBI_OnBlur(event);
}
SPBOUILib.SetInputExit('HZZPORVTBI',HZZPORVTBI_wrap_Blur);
function LVOWHGDALM_wrap_Valid(event) {
return LVOWHGDALM_Valid(event);
}
SPBOUILib.SetInputExit('LVOWHGDALM',LVOWHGDALM_wrap_Valid);
function LVOWHGDALM_wrap_OnFocus(event) {
return LVOWHGDALM_OnFocus(event);
}
SPBOUILib.SetInputEnter('LVOWHGDALM',LVOWHGDALM_wrap_OnFocus);
function LVOWHGDALM_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('LVOWHGDALM',LVOWHGDALM_wrap_OnKeyDown);
function LVOWHGDALM_ZOOM_setHandlers() {
function LVOWHGDALM_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?LVOWHGDALM_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('LVOWHGDALM_ZOOM',LVOWHGDALM_ZOOM_wrap_OnClick);
function LVOWHGDALM_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('LVOWHGDALM_ZOOM',LVOWHGDALM_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('LVOWHGDALM',LVOWHGDALM_ZOOM_setHandlers);
function XOKLSKJFHK_wrap_Valid(event) {
return XOKLSKJFHK_Valid(event);
}
SPBOUILib.SetInputExit('XOKLSKJFHK',XOKLSKJFHK_wrap_Valid);
function XOKLSKJFHK_wrap_OnFocus(event) {
return XOKLSKJFHK_OnFocus(event);
}
SPBOUILib.SetInputEnter('XOKLSKJFHK',XOKLSKJFHK_wrap_OnFocus);
function XOKLSKJFHK_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('XOKLSKJFHK',XOKLSKJFHK_wrap_OnKeyDown);
function XOKLSKJFHK_ZOOM_setHandlers() {
function XOKLSKJFHK_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?XOKLSKJFHK_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('XOKLSKJFHK_ZOOM',XOKLSKJFHK_ZOOM_wrap_OnClick);
function XOKLSKJFHK_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('XOKLSKJFHK_ZOOM',XOKLSKJFHK_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('XOKLSKJFHK',XOKLSKJFHK_ZOOM_setHandlers);
function OIVKASXTIR_wrap_Valid(event) {
return OIVKASXTIR_Valid(event);
}
SPBOUILib.SetInputExit('OIVKASXTIR',OIVKASXTIR_wrap_Valid);
function OIVKASXTIR_wrap_OnFocus(event) {
return OIVKASXTIR_OnFocus(event);
}
SPBOUILib.SetInputEnter('OIVKASXTIR',OIVKASXTIR_wrap_OnFocus);
function OIVKASXTIR_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('OIVKASXTIR',OIVKASXTIR_wrap_OnKeyDown);
function AXFWAKGSHQ_wrap_Valid(event) {
return AXFWAKGSHQ_Valid(event);
}
SPBOUILib.SetInputExit('AXFWAKGSHQ',AXFWAKGSHQ_wrap_Valid);
function AXFWAKGSHQ_wrap_OnFocus(event) {
return AXFWAKGSHQ_OnFocus(event);
}
SPBOUILib.SetInputEnter('AXFWAKGSHQ',AXFWAKGSHQ_wrap_OnFocus);
function AXFWAKGSHQ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('AXFWAKGSHQ',AXFWAKGSHQ_wrap_OnKeyDown);
function YISYHKQCXD_wrap_Valid(event) {
return YISYHKQCXD_Valid(event);
}
SPBOUILib.SetInputExit('YISYHKQCXD',YISYHKQCXD_wrap_Valid);
function YISYHKQCXD_wrap_OnFocus(event) {
return YISYHKQCXD_OnFocus(event);
}
SPBOUILib.SetInputEnter('YISYHKQCXD',YISYHKQCXD_wrap_OnFocus);
function YISYHKQCXD_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('YISYHKQCXD',YISYHKQCXD_wrap_OnKeyDown);
function PWIUWUQDIG_wrap_Valid(event) {
return PWIUWUQDIG_Valid(event);
}
SPBOUILib.SetInputExit('PWIUWUQDIG',PWIUWUQDIG_wrap_Valid);
function PWIUWUQDIG_wrap_OnFocus(event) {
return PWIUWUQDIG_OnFocus(event);
}
SPBOUILib.SetInputEnter('PWIUWUQDIG',PWIUWUQDIG_wrap_OnFocus);
function PWIUWUQDIG_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('PWIUWUQDIG',PWIUWUQDIG_wrap_OnKeyDown);
function CANNGIJPXY_wrap_Valid(event) {
return CANNGIJPXY_Valid(event);
}
SPBOUILib.SetInputExit('CANNGIJPXY',CANNGIJPXY_wrap_Valid);
function CANNGIJPXY_wrap_OnFocus(event) {
return CANNGIJPXY_OnFocus(event);
}
SPBOUILib.SetInputEnter('CANNGIJPXY',CANNGIJPXY_wrap_OnFocus);
function CANNGIJPXY_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('CANNGIJPXY',CANNGIJPXY_wrap_OnKeyDown);
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
FocusFirstComponent.edit={"page_1":["WXKLPEPPUN"]};
FocusFirstComponent.query={"page_1":["ANDQNEUQUI"]};
FocusFirstComponent.otherwise={"page_1":["ANDQNEUQUI"]};
function Help() {
windowOpenForeground('../doc/armt_intercon_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_CODINTER=a[0];
w_CODDIPE=a[1];
w_RAGSOC=a[2];
w_TIPINTER=a[3];
w_PAESE=a[4];
w_DESCCIT=a[5];
w_DOMICILIO=a[6];
w_CODFISC=a[7];
w_CODCAB=a[8];
w_PROVINCIA=a[9];
w_CAP=a[10];
w_PARTIVA=a[11];
w_IDCITTA=a[12];
w_xdescstat=a[13];
if (Gt(a.length,14)) {
o_IDCITTA=w_IDCITTA;
}
m_PrimaryKeys=['CODINTER'];
}
function i_PrimaryKey() {
return 'inter2bo'+'\\'+CPLib.ToCPStr(w_CODINTER);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('armt_intercon',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
function LinkZoomExtendedMenu() {
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_PAESE,'C'); },"field":"CODSTA","type":"C"},{"expression":function() { return WtA(w_xdescstat,'C'); },"field":"DESCRI","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbstati','C'),"uid":"LVOWHGDALM"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_DESCCIT,'C'); },"field":"CITTA","type":"C"},{"expression":function() { return WtA(w_CODCAB,'C'); },"field":"CAB","type":"C"},{"expression":function() { return WtA(w_PROVINCIA,'C'); },"field":"PROV","type":"C"},{"expression":function() { return WtA(w_CAP,'C'); },"field":"CAP","type":"C"},{"expression":function() { return WtA(w_PAESE,'C'); },"field":"PKTBSTATI","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbcitta','C'),"uid":"XOKLSKJFHK"});
}
_Obli('CODINTER',0,'ANDQNEUQUI',false,"649722675")
_Obli('CODDIPE',0,'WXKLPEPPUN',false,"2071283709")
_Obli('RAGSOC',0,'SIYQQKBTIK',false,"10662833243")
_Obli('TIPINTER',0,'HZZPORVTBI',false,"984756930")
_Obli('PAESE',0,'LVOWHGDALM',false,"7776403")
_Obli('DESCCIT',0,'XOKLSKJFHK',false,"15186643")
_Obli('DOMICILIO',0,'OIVKASXTIR',false,"554236824")
_Obli('CODFISC',0,'AXFWAKGSHQ',false,"11921223220")
_Obli('CAP',0,'PWIUWUQDIG',false,"30291")
_Obli('PROVINCIA',0,'YISYHKQCXD',false,"10095365423")
_Obli('PARTIVA',0,'CANNGIJPXY',false,"1756430089")
