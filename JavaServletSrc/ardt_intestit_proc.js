function FillCombosValues() {
}
function FillInGridCombosValues(currentRow) {
var postfix = (Gt(currentRow,-1)?'_'+currentRow:'');
}
function SetControlsValue() {
var c;
if (Empty(m_cAltInterface) && (Eq(m_cFunction,'view') || Eq(m_cFunction,'query'))) {
var tmp_NAKGRMOUXS = ToHTag(AsControlValue(w_DOMICILIO));
if (Ne(e_NAKGRMOUXS,tmp_NAKGRMOUXS)) {
SPBOUILib.SetLabelValue('NAKGRMOUXS','innerHTML',tmp_NAKGRMOUXS);
e_NAKGRMOUXS=tmp_NAKGRMOUXS;
}
var tmp_HMPQLYVATL = ToHTag(AsControlValue(LRTrim(w_CAP)+' '+LRTrim(w_DESCCIT)+' ('+LRTrim(w_PROVINCIA)+')'));
if (Ne(e_HMPQLYVATL,tmp_HMPQLYVATL)) {
SPBOUILib.SetLabelValue('HMPQLYVATL','innerHTML',tmp_HMPQLYVATL);
e_HMPQLYVATL=tmp_HMPQLYVATL;
}
SPBOUILib.SetInputValue('QPLXZEEVEI',function(){return WtH(w_CODCLI,'C',16,0,'')},w_CODCLI);
SPBOUILib.SetInputValue('ORIJTEDVRI',function(){return WtH(w_NUMPROG2,'C',11,0,'')},w_NUMPROG2);
SPBOUILib.SetInputValue('LEZBMECOAR',function(){return WtH(w_NUMPROG1,'C',11,0,'')},w_NUMPROG1);
SPBOUILib.SetInputValue('QHHDRAEPOC',function(){return WtH(w_DESCINTER,'C',70,0,'')},w_DESCINTER);
} else {
var tmp_NAKGRMOUXS = ToHTag(AsControlValue(w_DOMICILIO));
if (Ne(e_NAKGRMOUXS,tmp_NAKGRMOUXS)) {
SPBOUILib.SetLabelValue('NAKGRMOUXS','innerHTML',tmp_NAKGRMOUXS);
e_NAKGRMOUXS=tmp_NAKGRMOUXS;
}
var tmp_HMPQLYVATL = ToHTag(AsControlValue(LRTrim(w_CAP)+' '+LRTrim(w_DESCCIT)+' ('+LRTrim(w_PROVINCIA)+')'));
if (Ne(e_HMPQLYVATL,tmp_HMPQLYVATL)) {
SPBOUILib.SetLabelValue('HMPQLYVATL','innerHTML',tmp_HMPQLYVATL);
e_HMPQLYVATL=tmp_HMPQLYVATL;
}
SPBOUILib.SetInputValue('QPLXZEEVEI',function(){return WtH(w_CODCLI,'C',16,0,'')},w_CODCLI);
SPBOUILib.SetInputValue('XTDHYWJPZL',function(){return WtH(w_CODINTER,'C',16,0,'')},w_CODINTER);
SPBOUILib.SetInputValue('HKZAUFLHMG',function(){return WtH(w_DATAINI,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATAINI);
SPBOUILib.SetInputValue('NATIUIQLJX',function(){return WtH(w_DATAFINE,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATAFINE);
SPBOUILib.SetInputValue('ZUSOGKEVZC',function(){return WtH(w_xragsoci,'C',40,0,'')},w_xragsoci);
SPBOUILib.SetInputValue('CHJPRCYMKT',function(){return WtH(w_PRGIMPTITE,'N',10,0,'')},w_PRGIMPTITE);
SPBOUILib.SetInputValue('ORIJTEDVRI',function(){return WtH(w_NUMPROG2,'C',11,0,'')},w_NUMPROG2);
SPBOUILib.SetInputValue('LEZBMECOAR',function(){return WtH(w_NUMPROG1,'C',11,0,'')},w_NUMPROG1);
SPBOUILib.SetInputValue('QHHDRAEPOC',function(){return WtH(w_DESCINTER,'C',70,0,'')},w_DESCINTER);
SPBOUILib.SetInputValue('QDIDYGGMQV',function(){return WtH(w_IDBASE,'C',10,0,'')},w_IDBASE);
var tmp_BKRVFLJLOS = ToResource((Eq(w_NUMPROG1,Utilities.Make(window).GetCallerString('NUMPROG')) || Eq(w_NUMPROG2,Utilities.Make(window).GetCallerString('NUMPROG'))?'../images/GIF/092.gif':'../images/GIF/092w.gif'));
if (Ne(e_BKRVFLJLOS,tmp_BKRVFLJLOS)) {
SPBOUILib.SetLabelValue('BKRVFLJLOS','src',tmp_BKRVFLJLOS);
setTimeout('scaleImage(\'BKRVFLJLOS\',17,17)',0);
e_BKRVFLJLOS=tmp_BKRVFLJLOS;
}
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
SetDisplay('VRCVINYRJO_DIV',IsHiddenByStateDriver('box_VRCVINYRJO'));
SetDisplay(Ctrl('QPLXZEEVEI'),Eq(1,1) || IsHiddenByStateDriver('CODCLI'));
SetDisplay('MINAAOAOZC_DIV',IsHiddenByStateDriver('box_MINAAOAOZC'));
if (Ne(m_cFunction,'view')) {
SetDisplay(Ctrl('CHJPRCYMKT'),true || IsHiddenByStateDriver('PRGIMPTITE'));
}
if (Ne(m_cFunction,'view')) {
SetDisplay(Ctrl('QDIDYGGMQV'),true || IsHiddenByStateDriver('IDBASE'));
}
LibJavascript.forEachItem(m_FoundlingHideExpression,i_body_2)
function i_body_2(child){
child();
}
HideUI();
}
function ExpandCollapseBoxesUnderCondition() {
var cond;
}
function QPLXZEEVEI_Valid(e) {
SetActiveField(Ctrl('QPLXZEEVEI'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('QPLXZEEVEI') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('CODCLI','C',w_CODCLI,HtW(Ctrl('QPLXZEEVEI').value,'C'),m_bQueryOnLatestKeyOnly);
}
}
}
function QPLXZEEVEI_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('QPLXZEEVEI'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('QPLXZEEVEI'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('QPLXZEEVEI'),e);
}
function XTDHYWJPZL_Valid(e) {
SetActiveField(Ctrl('XTDHYWJPZL'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CODINTER','C',w_CODINTER,HtW(Ctrl('XTDHYWJPZL').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODINTER(HtW(Ctrl('XTDHYWJPZL').value,'C'),null,e);
return l_bSetResult;
}
}
function XTDHYWJPZL_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('XTDHYWJPZL'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('XTDHYWJPZL'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('XTDHYWJPZL'),e);
}
function XTDHYWJPZL_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('XTDHYWJPZL')),'linkview_XTDHYWJPZL','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function HKZAUFLHMG_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('HKZAUFLHMG'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('HKZAUFLHMG').value=ApplyPictureToDate(Ctrl('HKZAUFLHMG').value,TranslatePicture(datePattern),'HKZAUFLHMG');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('HKZAUFLHMG'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('HKZAUFLHMG');
}
}
}
SetActiveField(Ctrl('HKZAUFLHMG'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATAINI','D',w_DATAINI,HtW(Ctrl('HKZAUFLHMG').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATAINI(HtW(Ctrl('HKZAUFLHMG').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function HKZAUFLHMG_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('HKZAUFLHMG'))) {
DisplayErrorMessage();
}
if ( ! (GetDisabled('HKZAUFLHMG'))) {
if (Eq(w_DATAINI,NullDate()) && Eq(_tracker.ctrl,null)) {
Ctrl('HKZAUFLHMG').value=WtH(Utilities.Make(window).GetCallerDate('DATAOPE'),'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
} else {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('HKZAUFLHMG',w_DATAINI,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
}
}
m_oEnteredInDate=Ctrl('HKZAUFLHMG');
SetActiveField(Ctrl('HKZAUFLHMG'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('HKZAUFLHMG'),e);
}
function NATIUIQLJX_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('NATIUIQLJX'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('NATIUIQLJX').value=ApplyPictureToDate(Ctrl('NATIUIQLJX').value,TranslatePicture(datePattern),'NATIUIQLJX');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('NATIUIQLJX'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('NATIUIQLJX');
}
}
}
SetActiveField(Ctrl('NATIUIQLJX'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATAFINE','D',w_DATAFINE,HtW(Ctrl('NATIUIQLJX').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATAFINE(HtW(Ctrl('NATIUIQLJX').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function NATIUIQLJX_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('NATIUIQLJX'))) {
DisplayErrorMessage();
}
if ( ! (GetDisabled('NATIUIQLJX'))) {
if (Eq(w_DATAFINE,NullDate()) && Eq(_tracker.ctrl,null)) {
Ctrl('NATIUIQLJX').value=WtH(Utilities.Make(window).GetCallerDate('DATAOPE'),'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
} else {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('NATIUIQLJX',w_DATAFINE,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
}
}
m_oEnteredInDate=Ctrl('NATIUIQLJX');
SetActiveField(Ctrl('NATIUIQLJX'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('NATIUIQLJX'),e);
}
function CHJPRCYMKT_Valid(e) {
SetActiveField(Ctrl('CHJPRCYMKT'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('PRGIMPTITE','N',w_PRGIMPTITE,HtW(Ctrl('CHJPRCYMKT').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PRGIMPTITE(HtW(Ctrl('CHJPRCYMKT').value,'N'),null,e);
return l_bSetResult;
}
}
function CHJPRCYMKT_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('CHJPRCYMKT'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('CHJPRCYMKT'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('CHJPRCYMKT'),e);
}
function QHHDRAEPOC_Valid(e) {
SetActiveField(Ctrl('QHHDRAEPOC'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DESCINTER','C',w_DESCINTER,HtW(Ctrl('QHHDRAEPOC').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DESCINTER(HtW(Ctrl('QHHDRAEPOC').value,'C'),null,e);
return l_bSetResult;
}
}
function QHHDRAEPOC_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('QHHDRAEPOC'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('QHHDRAEPOC'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('QHHDRAEPOC'),e);
}
function QDIDYGGMQV_Valid(e) {
SetActiveField(Ctrl('QDIDYGGMQV'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('IDBASE','C',w_IDBASE,HtW(Ctrl('QDIDYGGMQV').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IDBASE(HtW(Ctrl('QDIDYGGMQV').value,'C'),null,e);
return l_bSetResult;
}
}
function QDIDYGGMQV_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('QDIDYGGMQV'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('QDIDYGGMQV'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('QDIDYGGMQV'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function QPLXZEEVEI_wrap_Valid(event) {
return QPLXZEEVEI_Valid(event);
}
SPBOUILib.SetInputExit('QPLXZEEVEI',QPLXZEEVEI_wrap_Valid);
function QPLXZEEVEI_wrap_OnFocus(event) {
return QPLXZEEVEI_OnFocus(event);
}
SPBOUILib.SetInputEnter('QPLXZEEVEI',QPLXZEEVEI_wrap_OnFocus);
function QPLXZEEVEI_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('QPLXZEEVEI',QPLXZEEVEI_wrap_OnKeyDown);
function XTDHYWJPZL_wrap_Valid(event) {
return XTDHYWJPZL_Valid(event);
}
SPBOUILib.SetInputExit('XTDHYWJPZL',XTDHYWJPZL_wrap_Valid,SPBOUILib.Row.IN_GRID);
function XTDHYWJPZL_wrap_OnFocus(event) {
return XTDHYWJPZL_OnFocus(event);
}
SPBOUILib.SetInputEnter('XTDHYWJPZL',XTDHYWJPZL_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function XTDHYWJPZL_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('XTDHYWJPZL',XTDHYWJPZL_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function XTDHYWJPZL_ZOOM_setHandlers() {
function XTDHYWJPZL_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?XTDHYWJPZL_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('XTDHYWJPZL_ZOOM',XTDHYWJPZL_ZOOM_wrap_OnClick,SPBOUILib.Row.IN_GRID);
}
SPBOUILib.SetPicker('XTDHYWJPZL',XTDHYWJPZL_ZOOM_setHandlers);
function HKZAUFLHMG_wrap_Valid(event) {
return HKZAUFLHMG_Valid(event);
}
SPBOUILib.SetInputExit('HKZAUFLHMG',HKZAUFLHMG_wrap_Valid,SPBOUILib.Row.IN_GRID);
function HKZAUFLHMG_wrap_OnFocus(event) {
return HKZAUFLHMG_OnFocus(event);
}
SPBOUILib.SetInputEnter('HKZAUFLHMG',HKZAUFLHMG_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function HKZAUFLHMG_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('HKZAUFLHMG',HKZAUFLHMG_wrap_OnKeyPress,SPBOUILib.Row.IN_GRID);
function HKZAUFLHMG_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('HKZAUFLHMG',HKZAUFLHMG_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function NATIUIQLJX_wrap_Valid(event) {
return NATIUIQLJX_Valid(event);
}
SPBOUILib.SetInputExit('NATIUIQLJX',NATIUIQLJX_wrap_Valid,SPBOUILib.Row.IN_GRID);
function NATIUIQLJX_wrap_OnFocus(event) {
return NATIUIQLJX_OnFocus(event);
}
SPBOUILib.SetInputEnter('NATIUIQLJX',NATIUIQLJX_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function NATIUIQLJX_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('NATIUIQLJX',NATIUIQLJX_wrap_OnKeyPress,SPBOUILib.Row.IN_GRID);
function NATIUIQLJX_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('NATIUIQLJX',NATIUIQLJX_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function CHJPRCYMKT_wrap_Valid(event) {
return CHJPRCYMKT_Valid(event);
}
SPBOUILib.SetInputExit('CHJPRCYMKT',CHJPRCYMKT_wrap_Valid,SPBOUILib.Row.IN_GRID);
function CHJPRCYMKT_wrap_OnFocus(event) {
return CHJPRCYMKT_OnFocus(event);
}
SPBOUILib.SetInputEnter('CHJPRCYMKT',CHJPRCYMKT_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function CHJPRCYMKT_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('CHJPRCYMKT',CHJPRCYMKT_wrap_OnKeyPress,SPBOUILib.Row.IN_GRID);
function CHJPRCYMKT_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('CHJPRCYMKT',CHJPRCYMKT_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function QHHDRAEPOC_wrap_Valid(event) {
return QHHDRAEPOC_Valid(event);
}
SPBOUILib.SetInputExit('QHHDRAEPOC',QHHDRAEPOC_wrap_Valid);
function QHHDRAEPOC_wrap_OnFocus(event) {
return QHHDRAEPOC_OnFocus(event);
}
SPBOUILib.SetInputEnter('QHHDRAEPOC',QHHDRAEPOC_wrap_OnFocus);
function QHHDRAEPOC_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('QHHDRAEPOC',QHHDRAEPOC_wrap_OnKeyDown);
function QDIDYGGMQV_wrap_Valid(event) {
return QDIDYGGMQV_Valid(event);
}
SPBOUILib.SetInputExit('QDIDYGGMQV',QDIDYGGMQV_wrap_Valid,SPBOUILib.Row.IN_GRID);
function QDIDYGGMQV_wrap_OnFocus(event) {
return QDIDYGGMQV_OnFocus(event);
}
SPBOUILib.SetInputEnter('QDIDYGGMQV',QDIDYGGMQV_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function QDIDYGGMQV_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('QDIDYGGMQV',QDIDYGGMQV_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
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
if (Eq(p_cEvent,'Before Save Row')) {
if (Ne(typeof(Calculation_GVAXMWDMDH),'undefined')) {
old_c=m_bCalculating;
m_bCalculating=true;
Calculation_GVAXMWDMDH();
m_bCalculating=old_c;
if ( ! (old_c)) {
DoUpdate(true);
}
}
if (Ne(typeof(Calculation_HQRGXFMPSR),'undefined')) {
old_c=m_bCalculating;
m_bCalculating=true;
Calculation_HQRGXFMPSR();
m_bCalculating=old_c;
if ( ! (old_c)) {
DoUpdate(true);
}
}
} else if (Eq(p_cEvent,'Init Row')) {
if (Ne(typeof(Calculation_JPLJTSXCMQ),'undefined')) {
old_c=m_bCalculating;
m_bCalculating=true;
Calculation_JPLJTSXCMQ();
m_bCalculating=old_c;
if ( ! (old_c)) {
DoUpdate(true);
}
}
}
}
function SetLastFocusedOnParent() {
if (IsWndAccessible(window['m_oFather'])) {
m_oFather.i_last_focused_item='child_ardt_intestit';
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
windowOpenForeground('../doc/ardt_intestit_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
}
function CalledBatchEnd() {
if ( ! (m_bCalculating)) {
DoUpdate(true);
}
}
function LoadChildrenInPage(page,lazy) {
}
GetLayerID.Layers.push({"id":"VRCVINYRJO","name":"box_VRCVINYRJO"});
GetLayerID.Layers.push({"id":"MINAAOAOZC","name":"box_MINAAOAOZC"});
GetLayerID.CheckEditRow=true;
function DeclareWVs() {
var a = arguments;
w_CODINTER=a[0];
w_DATAINI=a[1];
w_DATAFINE=a[2];
w_TIPOPERS=a[3];
w_CODCLI=a[4];
w_PRGIMPTITE=a[5];
w_STATOREG=a[6];
w_IDEREG=a[7];
w_TIPORAP=a[8];
w_NUMPROG2=a[9];
w_NUMPROG1=a[10];
w_DESCINTER=a[11];
w_IDBASE=a[12];
w_NOAGE=a[13];
w_xragsoci=a[14];
w_tipreg=a[15];
w_tiporegr=a[16];
w_DOMICILIO=a[17];
w_DESCCIT=a[18];
w_PROVINCIA=a[19];
w_CAP=a[20];
w_gAzienda=a[21];
w_tipooprap=a[22];
if (Gt(a.length,23)) {
o_CODINTER=w_CODINTER;
o_DATAINI=w_DATAINI;
o_DATAFINE=w_DATAFINE;
}
m_PrimaryKeys=['CODCLI','CODINTER'];
}
function i_PrimaryKey() {
return 'intestit'+'\\'+CPLib.ToCPStr(w_CODCLI);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('ardt_intestit',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
function LinkZoomExtendedMenu() {
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_CODINTER,'C'); },"field":"CONNES","type":"C"},{"expression":function() { return WtA(w_xragsoci,'C'); },"field":"RAGSOC","type":"C"},{"expression":function() { return WtA(w_DOMICILIO,'C'); },"field":"DOMICILIO","type":"C"},{"expression":function() { return WtA(w_DESCCIT,'C'); },"field":"DESCCIT","type":"C"},{"expression":function() { return WtA(w_PROVINCIA,'C'); },"field":"PROVINCIA","type":"C"},{"expression":function() { return WtA(w_CAP,'C'); },"field":"CAP","type":"C"}],"itemRepeated":true,"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('personbo','C'),"uid":"XTDHYWJPZL"});
}
function FocusFirstDetailComponent() {
var candidatesToFocus = ["XTDHYWJPZL"];
SetControlFocus(candidatesToFocus);
}
IsRepeatedChild.child=[];
function GetFullRowMsgError() {
return 'MSG_FULLROW_NOT_SAT';
}
_Obli('DATAFINE',2,'NATIUIQLJX',false,"1300662969")
_Obli('PRGIMPTITE',1,'CHJPRCYMKT',false)
_Obli('DATAINI',2,'HKZAUFLHMG',false,"45547614")
_Obli('CODINTER',0,'XTDHYWJPZL',false,"942986941")
_Obli('DESCINTER',0,'QHHDRAEPOC',false)
_Obli('IDBASE',0,'QDIDYGGMQV',false,"113866921")
