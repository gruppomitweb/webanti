function FillCombosValues() {
}
function FillInGridCombosValues(currentRow) {
var postfix = (Gt(currentRow,-1)?'_'+currentRow:'');
}
function SetControlsValue() {
var c;
if (Empty(m_cAltInterface) && (Eq(m_cFunction,'view') || Eq(m_cFunction,'query'))) {
} else {
SPBOUILib.SetInputValue('VTKPZXOJNA',function(){return WtH(w_ANNORIF,'N',4,0,'9999')},w_ANNORIF);
SPBOUILib.SetInputValue('BWTIUEDQGZ',function(){return WtH(w_MESERIF,'N',2,0,'99')},w_MESERIF);
SPBOUILib.SetInputValue('KVHOYDAEWK',function(){return WtH(w_ANOMAGE,'N',3,0,'999')},w_ANOMAGE);
SPBOUILib.SetInputValue('AOUYQGNXQU',function(){return WtH(w_SOSCLIENTI,'N',3,0,'')},w_SOSCLIENTI);
SPBOUILib.SetInputValue('NHORYNPKJE',function(){return WtH(w_SOSAGENZIA,'N',3,0,'')},w_SOSAGENZIA);
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
HideUI.lblids["ANNORIF"]=['MUYIYDLBMI'];
HideUI.lblids["ANOMAGE"]=['RBTRENZOWZ','DXQMLURKZO','ZHCRCTTAHK'];
HideUI.lblids["MESERIF"]=['CYORQPYJOI'];
function VTKPZXOJNA_Valid(e) {
SetActiveField(Ctrl('VTKPZXOJNA'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('ANNORIF','N',w_ANNORIF,HtW(Ctrl('VTKPZXOJNA').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ANNORIF(HtW(Ctrl('VTKPZXOJNA').value,'N'),null,e);
return l_bSetResult;
}
}
function VTKPZXOJNA_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('VTKPZXOJNA'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('VTKPZXOJNA',w_ANNORIF,'N',4,0,'9999');
SetActiveField(Ctrl('VTKPZXOJNA'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('VTKPZXOJNA'),e);
}
function VTKPZXOJNA_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("9999"));
}
function BWTIUEDQGZ_Valid(e) {
SetActiveField(Ctrl('BWTIUEDQGZ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('MESERIF','N',w_MESERIF,HtW(Ctrl('BWTIUEDQGZ').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_MESERIF(HtW(Ctrl('BWTIUEDQGZ').value,'N'),null,e);
return l_bSetResult;
}
}
function BWTIUEDQGZ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('BWTIUEDQGZ'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('BWTIUEDQGZ',w_MESERIF,'N',2,0,'99');
SetActiveField(Ctrl('BWTIUEDQGZ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('BWTIUEDQGZ'),e);
}
function BWTIUEDQGZ_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("99"));
}
function KVHOYDAEWK_Valid(e) {
SetActiveField(Ctrl('KVHOYDAEWK'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('ANOMAGE','N',w_ANOMAGE,HtW(Ctrl('KVHOYDAEWK').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ANOMAGE(HtW(Ctrl('KVHOYDAEWK').value,'N'),null,e);
return l_bSetResult;
}
}
function KVHOYDAEWK_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('KVHOYDAEWK'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('KVHOYDAEWK',w_ANOMAGE,'N',3,0,'999');
SetActiveField(Ctrl('KVHOYDAEWK'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('KVHOYDAEWK'),e);
}
function KVHOYDAEWK_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("999"));
}
function AOUYQGNXQU_Valid(e) {
SetActiveField(Ctrl('AOUYQGNXQU'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('SOSCLIENTI','N',w_SOSCLIENTI,HtW(Ctrl('AOUYQGNXQU').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_SOSCLIENTI(HtW(Ctrl('AOUYQGNXQU').value,'N'),null,e);
return l_bSetResult;
}
}
function AOUYQGNXQU_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('AOUYQGNXQU'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('AOUYQGNXQU'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('AOUYQGNXQU'),e);
}
function NHORYNPKJE_Valid(e) {
SetActiveField(Ctrl('NHORYNPKJE'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('SOSAGENZIA','N',w_SOSAGENZIA,HtW(Ctrl('NHORYNPKJE').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_SOSAGENZIA(HtW(Ctrl('NHORYNPKJE').value,'N'),null,e);
return l_bSetResult;
}
}
function NHORYNPKJE_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('NHORYNPKJE'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('NHORYNPKJE'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('NHORYNPKJE'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function VTKPZXOJNA_wrap_Valid(event) {
return VTKPZXOJNA_Valid(event);
}
SPBOUILib.SetInputExit('VTKPZXOJNA',VTKPZXOJNA_wrap_Valid,SPBOUILib.Row.IN_GRID);
function VTKPZXOJNA_wrap_OnFocus(event) {
return VTKPZXOJNA_OnFocus(event);
}
SPBOUILib.SetInputEnter('VTKPZXOJNA',VTKPZXOJNA_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function VTKPZXOJNA_wrap_OnKeyPress(event) {
return VTKPZXOJNA_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('VTKPZXOJNA',VTKPZXOJNA_wrap_OnKeyPress,SPBOUILib.Row.IN_GRID);
function VTKPZXOJNA_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('VTKPZXOJNA',VTKPZXOJNA_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function BWTIUEDQGZ_wrap_Valid(event) {
return BWTIUEDQGZ_Valid(event);
}
SPBOUILib.SetInputExit('BWTIUEDQGZ',BWTIUEDQGZ_wrap_Valid,SPBOUILib.Row.IN_GRID);
function BWTIUEDQGZ_wrap_OnFocus(event) {
return BWTIUEDQGZ_OnFocus(event);
}
SPBOUILib.SetInputEnter('BWTIUEDQGZ',BWTIUEDQGZ_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function BWTIUEDQGZ_wrap_OnKeyPress(event) {
return BWTIUEDQGZ_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('BWTIUEDQGZ',BWTIUEDQGZ_wrap_OnKeyPress,SPBOUILib.Row.IN_GRID);
function BWTIUEDQGZ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('BWTIUEDQGZ',BWTIUEDQGZ_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function KVHOYDAEWK_wrap_Valid(event) {
return KVHOYDAEWK_Valid(event);
}
SPBOUILib.SetInputExit('KVHOYDAEWK',KVHOYDAEWK_wrap_Valid,SPBOUILib.Row.IN_GRID);
function KVHOYDAEWK_wrap_OnFocus(event) {
return KVHOYDAEWK_OnFocus(event);
}
SPBOUILib.SetInputEnter('KVHOYDAEWK',KVHOYDAEWK_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function KVHOYDAEWK_wrap_OnKeyPress(event) {
return KVHOYDAEWK_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('KVHOYDAEWK',KVHOYDAEWK_wrap_OnKeyPress,SPBOUILib.Row.IN_GRID);
function KVHOYDAEWK_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('KVHOYDAEWK',KVHOYDAEWK_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function AOUYQGNXQU_wrap_Valid(event) {
return AOUYQGNXQU_Valid(event);
}
SPBOUILib.SetInputExit('AOUYQGNXQU',AOUYQGNXQU_wrap_Valid,SPBOUILib.Row.IN_GRID);
function AOUYQGNXQU_wrap_OnFocus(event) {
return AOUYQGNXQU_OnFocus(event);
}
SPBOUILib.SetInputEnter('AOUYQGNXQU',AOUYQGNXQU_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function AOUYQGNXQU_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('AOUYQGNXQU',AOUYQGNXQU_wrap_OnKeyPress,SPBOUILib.Row.IN_GRID);
function AOUYQGNXQU_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('AOUYQGNXQU',AOUYQGNXQU_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function NHORYNPKJE_wrap_Valid(event) {
return NHORYNPKJE_Valid(event);
}
SPBOUILib.SetInputExit('NHORYNPKJE',NHORYNPKJE_wrap_Valid,SPBOUILib.Row.IN_GRID);
function NHORYNPKJE_wrap_OnFocus(event) {
return NHORYNPKJE_OnFocus(event);
}
SPBOUILib.SetInputEnter('NHORYNPKJE',NHORYNPKJE_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function NHORYNPKJE_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('NHORYNPKJE',NHORYNPKJE_wrap_OnKeyPress,SPBOUILib.Row.IN_GRID);
function NHORYNPKJE_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('NHORYNPKJE',NHORYNPKJE_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
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
m_oFather.i_last_focused_item='child_ardt_anadip_agg';
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
windowOpenForeground('../doc/ardt_anadip_agg_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_CODDIPE=a[0];
w_ANNORIF=a[1];
w_MESERIF=a[2];
w_DATAINI=a[3];
w_DATAFINE=a[4];
w_ANOMAGE=a[5];
w_SOSCLIENTI=a[6];
w_SOSAGENZIA=a[7];
m_PrimaryKeys=['MESERIF','ANNORIF','CODDIPE'];
}
function i_PrimaryKey() {
return 'anadip_agg'+'\\'+CPLib.ToCPStr(w_CODDIPE);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('ardt_anadip_agg',m_cSelectedPage);
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
var candidatesToFocus = ["VTKPZXOJNA"];
SetControlFocus(candidatesToFocus);
}
IsRepeatedChild.child=[];
function GetFullRowMsgError() {
return 'MSG_FULLROW_NOT_SAT';
}
_Obli('SOSAGENZIA',1,'NHORYNPKJE',false,"11602603142")
_Obli('ANNORIF',1,'VTKPZXOJNA',false,"863017169")
_Obli('MESERIF',1,'BWTIUEDQGZ',false,"862977325")
_Obli('SOSCLIENTI',1,'AOUYQGNXQU',false,"11631654360")
_Obli('ANOMAGE',1,'KVHOYDAEWK',false,"1094517073")
