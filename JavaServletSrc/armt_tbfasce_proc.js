function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('PZFVIVIVXJ',function(){return WtH(w_CODICE,'C',10,0,'')},w_CODICE);
if(c=Ctrl('EYVGZOWRXB')) selectCombo(c,w_TIPO,'N')
SPBOUILib.SetInputValue('ABIQSFLWTR',function(){return WtH(w_DESCRI,'C',150,0,'')},w_DESCRI);
SPBOUILib.SetInputValue('TVIEWENHZP',function(){return WtH(w_DAIMP,'N',18,2,'999999999999999.99')},w_DAIMP);
SPBOUILib.SetInputValue('KQMZCLHBEJ',function(){return WtH(w_AIMP,'N',18,2,'999999999999999.99')},w_AIMP);
SPBOUILib.SetInputValue('VKFFPTBUJV',function(){return WtH(w_RISCHIO,'N',3,0,'999')},w_RISCHIO);
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
HideUI.lblids["AIMP"]=['QHAKSVZYOO'];
HideUI.lblids["CODICE"]=['NLKUPADSWZ'];
HideUI.lblids["DAIMP"]=['OOPCWRUFZN'];
HideUI.lblids["DESCRI"]=['RQZOLJOMQX'];
HideUI.lblids["RISCHIO"]=['VGRRUPTDXL'];
HideUI.lblids["TIPO"]=['XXKOYVYEIK'];
function PZFVIVIVXJ_Valid(e) {
SetActiveField(Ctrl('PZFVIVIVXJ'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('PZFVIVIVXJ') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('CODICE','C',w_CODICE,HtW(Ctrl('PZFVIVIVXJ').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODICE(HtW(Ctrl('PZFVIVIVXJ').value,'C'),null,e);
return l_bSetResult;
}
}
function PZFVIVIVXJ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('PZFVIVIVXJ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('PZFVIVIVXJ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('PZFVIVIVXJ'),e);
}
function EYVGZOWRXB_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('TIPO','N',w_TIPO,HtW(getComboValue(Ctrl('EYVGZOWRXB')),'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TIPO(HtW(getComboValue(Ctrl('EYVGZOWRXB')),'N'),null,e);
return l_bSetResult;
}
}
function EYVGZOWRXB_OnFocus(e) {
SetActiveField(Ctrl('EYVGZOWRXB'),true);
}
function EYVGZOWRXB_OnBlur(e) {
SetActiveField(Ctrl('EYVGZOWRXB'),false);
}
function ABIQSFLWTR_Valid(e) {
SetActiveField(Ctrl('ABIQSFLWTR'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DESCRI','C',w_DESCRI,HtW(Ctrl('ABIQSFLWTR').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DESCRI(HtW(Ctrl('ABIQSFLWTR').value,'C'),null,e);
return l_bSetResult;
}
}
function ABIQSFLWTR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ABIQSFLWTR'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('ABIQSFLWTR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ABIQSFLWTR'),e);
}
function TVIEWENHZP_Valid(e) {
SetActiveField(Ctrl('TVIEWENHZP'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DAIMP','N',w_DAIMP,HtW(Ctrl('TVIEWENHZP').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DAIMP(HtW(Ctrl('TVIEWENHZP').value,'N'),null,e);
return l_bSetResult;
}
}
function TVIEWENHZP_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('TVIEWENHZP'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('TVIEWENHZP',w_DAIMP,'N',18,2,'999999999999999.99');
SetActiveField(Ctrl('TVIEWENHZP'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('TVIEWENHZP'),e);
}
function TVIEWENHZP_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("999999999999999.99"));
}
function KQMZCLHBEJ_Valid(e) {
SetActiveField(Ctrl('KQMZCLHBEJ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('AIMP','N',w_AIMP,HtW(Ctrl('KQMZCLHBEJ').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_AIMP(HtW(Ctrl('KQMZCLHBEJ').value,'N'),null,e);
return l_bSetResult;
}
}
function KQMZCLHBEJ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('KQMZCLHBEJ'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('KQMZCLHBEJ',w_AIMP,'N',18,2,'999999999999999.99');
SetActiveField(Ctrl('KQMZCLHBEJ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('KQMZCLHBEJ'),e);
}
function KQMZCLHBEJ_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("999999999999999.99"));
}
function VKFFPTBUJV_Valid(e) {
SetActiveField(Ctrl('VKFFPTBUJV'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('RISCHIO','N',w_RISCHIO,HtW(Ctrl('VKFFPTBUJV').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_RISCHIO(HtW(Ctrl('VKFFPTBUJV').value,'N'),null,e);
return l_bSetResult;
}
}
function VKFFPTBUJV_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('VKFFPTBUJV'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('VKFFPTBUJV',w_RISCHIO,'N',3,0,'999');
SetActiveField(Ctrl('VKFFPTBUJV'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('VKFFPTBUJV'),e);
}
function VKFFPTBUJV_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("999"));
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function PZFVIVIVXJ_wrap_Valid(event) {
return PZFVIVIVXJ_Valid(event);
}
SPBOUILib.SetInputExit('PZFVIVIVXJ',PZFVIVIVXJ_wrap_Valid);
function PZFVIVIVXJ_wrap_OnFocus(event) {
return PZFVIVIVXJ_OnFocus(event);
}
SPBOUILib.SetInputEnter('PZFVIVIVXJ',PZFVIVIVXJ_wrap_OnFocus);
function PZFVIVIVXJ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('PZFVIVIVXJ',PZFVIVIVXJ_wrap_OnKeyDown);
function EYVGZOWRXB_wrap_Valid(event) {
return EYVGZOWRXB_Valid(event);
}
SPBOUILib.SetComboChange('EYVGZOWRXB',EYVGZOWRXB_wrap_Valid);
function EYVGZOWRXB_wrap_OnFocus(event) {
return EYVGZOWRXB_OnFocus(event);
}
SPBOUILib.SetInputEnter('EYVGZOWRXB',EYVGZOWRXB_wrap_OnFocus);
function EYVGZOWRXB_wrap_Blur(event) {
return EYVGZOWRXB_OnBlur(event);
}
SPBOUILib.SetInputExit('EYVGZOWRXB',EYVGZOWRXB_wrap_Blur);
function ABIQSFLWTR_wrap_Valid(event) {
return ABIQSFLWTR_Valid(event);
}
SPBOUILib.SetInputExit('ABIQSFLWTR',ABIQSFLWTR_wrap_Valid);
function ABIQSFLWTR_wrap_OnFocus(event) {
return ABIQSFLWTR_OnFocus(event);
}
SPBOUILib.SetInputEnter('ABIQSFLWTR',ABIQSFLWTR_wrap_OnFocus);
function ABIQSFLWTR_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('ABIQSFLWTR',ABIQSFLWTR_wrap_OnKeyDown);
function TVIEWENHZP_wrap_Valid(event) {
return TVIEWENHZP_Valid(event);
}
SPBOUILib.SetInputExit('TVIEWENHZP',TVIEWENHZP_wrap_Valid);
function TVIEWENHZP_wrap_OnFocus(event) {
return TVIEWENHZP_OnFocus(event);
}
SPBOUILib.SetInputEnter('TVIEWENHZP',TVIEWENHZP_wrap_OnFocus);
function TVIEWENHZP_wrap_OnKeyPress(event) {
return TVIEWENHZP_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('TVIEWENHZP',TVIEWENHZP_wrap_OnKeyPress);
function TVIEWENHZP_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('TVIEWENHZP',TVIEWENHZP_wrap_OnKeyDown);
function KQMZCLHBEJ_wrap_Valid(event) {
return KQMZCLHBEJ_Valid(event);
}
SPBOUILib.SetInputExit('KQMZCLHBEJ',KQMZCLHBEJ_wrap_Valid);
function KQMZCLHBEJ_wrap_OnFocus(event) {
return KQMZCLHBEJ_OnFocus(event);
}
SPBOUILib.SetInputEnter('KQMZCLHBEJ',KQMZCLHBEJ_wrap_OnFocus);
function KQMZCLHBEJ_wrap_OnKeyPress(event) {
return KQMZCLHBEJ_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('KQMZCLHBEJ',KQMZCLHBEJ_wrap_OnKeyPress);
function KQMZCLHBEJ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('KQMZCLHBEJ',KQMZCLHBEJ_wrap_OnKeyDown);
function VKFFPTBUJV_wrap_Valid(event) {
return VKFFPTBUJV_Valid(event);
}
SPBOUILib.SetInputExit('VKFFPTBUJV',VKFFPTBUJV_wrap_Valid);
function VKFFPTBUJV_wrap_OnFocus(event) {
return VKFFPTBUJV_OnFocus(event);
}
SPBOUILib.SetInputEnter('VKFFPTBUJV',VKFFPTBUJV_wrap_OnFocus);
function VKFFPTBUJV_wrap_OnKeyPress(event) {
return VKFFPTBUJV_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('VKFFPTBUJV',VKFFPTBUJV_wrap_OnKeyPress);
function VKFFPTBUJV_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('VKFFPTBUJV',VKFFPTBUJV_wrap_OnKeyDown);
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
FocusFirstComponent.edit={"page_1":["EYVGZOWRXB"]};
FocusFirstComponent.query={"page_1":["PZFVIVIVXJ"]};
FocusFirstComponent.otherwise={"page_1":["PZFVIVIVXJ"]};
function Help() {
windowOpenForeground('../doc/armt_tbfasce_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_CODICE=a[0];
w_TIPO=a[1];
w_DESCRI=a[2];
w_DAIMP=a[3];
w_AIMP=a[4];
w_RISCHIO=a[5];
w_IDBASE=a[6];
m_PrimaryKeys=['CODICE'];
}
function i_PrimaryKey() {
return 'tbfascepr'+'\\'+CPLib.ToCPStr(w_CODICE);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('armt_tbfasce',m_cSelectedPage);
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
_Obli('CODICE',0,'PZFVIVIVXJ',false,"112851763")
_Obli('TIPO',1,'EYVGZOWRXB',true,"10027039931")
_Obli('DESCRI',0,'ABIQSFLWTR',false,"285808099")
_Obli('DAIMP',1,'TVIEWENHZP',false,"11770930760")
_Obli('AIMP',1,'KQMZCLHBEJ',false,"11184425040")
_Obli('RISCHIO',1,'VKFFPTBUJV',false,"1310320066")
