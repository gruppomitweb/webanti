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
SPBOUILib.SetInputValue('QPLXZEEVEI',function(){return WtH(w_RAPPORTO,'C',25,0,'')},w_RAPPORTO);
SPBOUILib.SetInputValue('SZEBCEZTJC',function(){return WtH(w_NUMPROG1,'C',11,0,'')},w_NUMPROG1);
SPBOUILib.SetInputValue('UEQWFDVELM',function(){return WtH(w_NUMPROG2,'C',11,0,'')},w_NUMPROG2);
if(c=Ctrl('YFNPTNWMJX')) ChkboxCheckUncheck(c,'S',w_NOAGE)
if(c=Ctrl('YFNPTNWMJX')) ChkboxValueAssign(c,'S','N','C',1,0,'')
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
SPBOUILib.SetInputValue('QPLXZEEVEI',function(){return WtH(w_RAPPORTO,'C',25,0,'')},w_RAPPORTO);
SPBOUILib.SetInputValue('CROCGCIGKF',function(){return WtH(w_CODINTER,'C',16,0,'')},w_CODINTER);
SPBOUILib.SetInputValue('BJKHVZBXDR',function(){return WtH(w_DATAINI,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATAINI);
SPBOUILib.SetInputValue('JCFUNSQXBI',function(){return WtH(w_DATAFINE,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATAFINE);
SPBOUILib.SetInputValue('SZEBCEZTJC',function(){return WtH(w_NUMPROG1,'C',11,0,'')},w_NUMPROG1);
SPBOUILib.SetInputValue('UEQWFDVELM',function(){return WtH(w_NUMPROG2,'C',11,0,'')},w_NUMPROG2);
SPBOUILib.SetInputValue('VICYEWBISV',function(){return WtH(w_xRagSoc,'C',70,0,'')},w_xRagSoc);
if(c=Ctrl('YFNPTNWMJX')) ChkboxCheckUncheck(c,'S',w_NOAGE)
if(c=Ctrl('YFNPTNWMJX')) ChkboxValueAssign(c,'S','N','C',1,0,'')
var tmp_BKRVFLJLOS = ToResource((Eq(w_NUMPROG1,Utilities.Make(window).GetCallerString('NUMPROG')) || Eq(w_NUMPROG2,Utilities.Make(window).GetCallerString('NUMPROG'))?'../images/GIF/092.gif':'../images/GIF/092w.gif'));
if (Ne(e_BKRVFLJLOS,tmp_BKRVFLJLOS)) {
SPBOUILib.SetLabelValue('BKRVFLJLOS','src',tmp_BKRVFLJLOS);
setTimeout('scaleImage(\'BKRVFLJLOS\',17,16)',0);
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
SetDisplay(Ctrl('QPLXZEEVEI'),Eq(1,1) || IsHiddenByStateDriver('RAPPORTO'));
SetDisplay('MINAAOAOZC_DIV',IsHiddenByStateDriver('box_MINAAOAOZC'));
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
DoQuery('RAPPORTO','C',w_RAPPORTO,HtW(Ctrl('QPLXZEEVEI').value,'C'),m_bQueryOnLatestKeyOnly);
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
function CROCGCIGKF_Valid(e) {
SetActiveField(Ctrl('CROCGCIGKF'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CODINTER','C',w_CODINTER,HtW(Ctrl('CROCGCIGKF').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODINTER(HtW(Ctrl('CROCGCIGKF').value,'C'),null,e);
return l_bSetResult;
}
}
function CROCGCIGKF_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('CROCGCIGKF'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('CROCGCIGKF'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('CROCGCIGKF'),e);
}
function CROCGCIGKF_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('CROCGCIGKF')),'linkview_CROCGCIGKF','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function BJKHVZBXDR_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('BJKHVZBXDR'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('BJKHVZBXDR').value=ApplyPictureToDate(Ctrl('BJKHVZBXDR').value,TranslatePicture(datePattern),'BJKHVZBXDR');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('BJKHVZBXDR'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('BJKHVZBXDR');
}
}
}
SetActiveField(Ctrl('BJKHVZBXDR'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATAINI','D',w_DATAINI,HtW(Ctrl('BJKHVZBXDR').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATAINI(HtW(Ctrl('BJKHVZBXDR').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function BJKHVZBXDR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('BJKHVZBXDR'))) {
DisplayErrorMessage();
}
if ( ! (GetDisabled('BJKHVZBXDR'))) {
if (Eq(w_DATAINI,NullDate()) && Eq(_tracker.ctrl,null)) {
Ctrl('BJKHVZBXDR').value=WtH(Utilities.Make(window).GetCallerDate('DATAOPE'),'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
} else {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('BJKHVZBXDR',w_DATAINI,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
}
}
m_oEnteredInDate=Ctrl('BJKHVZBXDR');
SetActiveField(Ctrl('BJKHVZBXDR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('BJKHVZBXDR'),e);
}
function JCFUNSQXBI_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('JCFUNSQXBI'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('JCFUNSQXBI').value=ApplyPictureToDate(Ctrl('JCFUNSQXBI').value,TranslatePicture(datePattern),'JCFUNSQXBI');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('JCFUNSQXBI'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('JCFUNSQXBI');
}
}
}
SetActiveField(Ctrl('JCFUNSQXBI'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATAFINE','D',w_DATAFINE,HtW(Ctrl('JCFUNSQXBI').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATAFINE(HtW(Ctrl('JCFUNSQXBI').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function JCFUNSQXBI_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('JCFUNSQXBI'))) {
DisplayErrorMessage();
}
if ( ! (GetDisabled('JCFUNSQXBI'))) {
if (Eq(w_DATAFINE,NullDate()) && Eq(_tracker.ctrl,null)) {
Ctrl('JCFUNSQXBI').value=WtH(Utilities.Make(window).GetCallerDate('DATAOPE'),'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
} else {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('JCFUNSQXBI',w_DATAFINE,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
}
}
m_oEnteredInDate=Ctrl('JCFUNSQXBI');
SetActiveField(Ctrl('JCFUNSQXBI'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('JCFUNSQXBI'),e);
}
function YFNPTNWMJX_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('NOAGE','C',w_NOAGE,ChkboxValueAssign(Ctrl('YFNPTNWMJX'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_NOAGE(ChkboxValueAssign(Ctrl('YFNPTNWMJX'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function YFNPTNWMJX_OnFocus(e) {
SetActiveField(Ctrl('YFNPTNWMJX'),true);
}
function YFNPTNWMJX_OnBlur(e) {
SetActiveField(Ctrl('YFNPTNWMJX'),false);
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
function CROCGCIGKF_wrap_Valid(event) {
return CROCGCIGKF_Valid(event);
}
SPBOUILib.SetInputExit('CROCGCIGKF',CROCGCIGKF_wrap_Valid,SPBOUILib.Row.IN_GRID);
function CROCGCIGKF_wrap_OnFocus(event) {
return CROCGCIGKF_OnFocus(event);
}
SPBOUILib.SetInputEnter('CROCGCIGKF',CROCGCIGKF_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function CROCGCIGKF_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('CROCGCIGKF',CROCGCIGKF_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function CROCGCIGKF_ZOOM_setHandlers() {
function CROCGCIGKF_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?CROCGCIGKF_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('CROCGCIGKF_ZOOM',CROCGCIGKF_ZOOM_wrap_OnClick,SPBOUILib.Row.IN_GRID);
}
SPBOUILib.SetPicker('CROCGCIGKF',CROCGCIGKF_ZOOM_setHandlers);
function BJKHVZBXDR_wrap_Valid(event) {
return BJKHVZBXDR_Valid(event);
}
SPBOUILib.SetInputExit('BJKHVZBXDR',BJKHVZBXDR_wrap_Valid,SPBOUILib.Row.IN_GRID);
function BJKHVZBXDR_wrap_OnFocus(event) {
return BJKHVZBXDR_OnFocus(event);
}
SPBOUILib.SetInputEnter('BJKHVZBXDR',BJKHVZBXDR_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function BJKHVZBXDR_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('BJKHVZBXDR',BJKHVZBXDR_wrap_OnKeyPress,SPBOUILib.Row.IN_GRID);
function BJKHVZBXDR_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('BJKHVZBXDR',BJKHVZBXDR_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function JCFUNSQXBI_wrap_Valid(event) {
return JCFUNSQXBI_Valid(event);
}
SPBOUILib.SetInputExit('JCFUNSQXBI',JCFUNSQXBI_wrap_Valid,SPBOUILib.Row.IN_GRID);
function JCFUNSQXBI_wrap_OnFocus(event) {
return JCFUNSQXBI_OnFocus(event);
}
SPBOUILib.SetInputEnter('JCFUNSQXBI',JCFUNSQXBI_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function JCFUNSQXBI_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('JCFUNSQXBI',JCFUNSQXBI_wrap_OnKeyPress,SPBOUILib.Row.IN_GRID);
function JCFUNSQXBI_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('JCFUNSQXBI',JCFUNSQXBI_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function YFNPTNWMJX_wrap_Valid(event) {
return YFNPTNWMJX_Valid(event);
}
SPBOUILib.SetCheckboxClick('YFNPTNWMJX',YFNPTNWMJX_wrap_Valid);
function YFNPTNWMJX_wrap_OnFocus(event) {
return YFNPTNWMJX_OnFocus(event);
}
SPBOUILib.SetInputEnter('YFNPTNWMJX',YFNPTNWMJX_wrap_OnFocus);
function YFNPTNWMJX_wrap_Blur(event) {
return YFNPTNWMJX_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('YFNPTNWMJX',YFNPTNWMJX_wrap_Blur);
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
if (Ne(typeof(Calculation_HQRGXFMPSR),'undefined')) {
old_c=m_bCalculating;
m_bCalculating=true;
Calculation_HQRGXFMPSR();
m_bCalculating=old_c;
if ( ! (old_c)) {
DoUpdate(true);
}
}
if (Ne(typeof(Calculation_GVAXMWDMDH),'undefined')) {
old_c=m_bCalculating;
m_bCalculating=true;
Calculation_GVAXMWDMDH();
m_bCalculating=old_c;
if ( ! (old_c)) {
DoUpdate(true);
}
}
}
}
function SetLastFocusedOnParent() {
if (IsWndAccessible(window['m_oFather'])) {
m_oFather.i_last_focused_item='child_ardt_pdelegabo';
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
windowOpenForeground('../doc/ardt_pdelegabo_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
}
function CalledBatchEnd() {
if ( ! (m_bCalculating)) {
DoUpdate(true);
}
}
function LoadChildrenInPage(page,lazy) {
}
GetLayerID.Layers.push({"id":"VRCVINYRJO","name":"box_VRCVINYRJO"});
GetLayerID.CheckEditRow=true;
function DeclareWVs() {
var a = arguments;
w_CODINTER=a[0];
w_DATAINI=a[1];
w_TIPORAP=a[2];
w_TIPOPERS=a[3];
w_STATOREG=a[4];
w_OPERAZMOD=a[5];
w_DATARETT=a[6];
w_IDEREG=a[7];
w_COLLEGAMEN=a[8];
w_DATAFINE=a[9];
w_IDBASE=a[10];
w_UCODE=a[11];
w_RAPPORTO=a[12];
w_NUMPROG1=a[13];
w_NUMPROG2=a[14];
w_NOAGE=a[15];
w_DESCINTER=a[16];
w_xragsocd=a[17];
w_tiporegr=a[18];
w_DOMICILIO=a[19];
w_DESCCIT=a[20];
w_PROVINCIA=a[21];
w_CAP=a[22];
w_xRagSoc=a[23];
if (Gt(a.length,24)) {
o_CODINTER=w_CODINTER;
o_DATAINI=w_DATAINI;
o_DATAFINE=w_DATAFINE;
}
m_PrimaryKeys=['RAPPORTO'];
}
function i_PrimaryKey() {
return 'xelegabo'+'\\'+CPLib.ToCPStr(w_RAPPORTO);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('ardt_pdelegabo',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
function LinkZoomExtendedMenu() {
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_CODINTER,'C'); },"field":"CONNES","type":"C"},{"expression":function() { return WtA(w_xragsocd,'C'); },"field":"RAGSOC","type":"C"},{"expression":function() { return WtA(w_DOMICILIO,'C'); },"field":"DOMICILIO","type":"C"},{"expression":function() { return WtA(w_DESCCIT,'C'); },"field":"DESCCIT","type":"C"},{"expression":function() { return WtA(w_PROVINCIA,'C'); },"field":"PROVINCIA","type":"C"},{"expression":function() { return WtA(w_CAP,'C'); },"field":"CAP","type":"C"}],"itemRepeated":true,"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('personbo','C'),"uid":"CROCGCIGKF"});
}
function FocusFirstDetailComponent() {
var candidatesToFocus = ["CROCGCIGKF"];
SetControlFocus(candidatesToFocus);
}
IsRepeatedChild.child=[];
function GetFullRowMsgError() {
return 'MSG_FULLROW_NOT_SAT';
}
_Obli('DATAFINE',2,'JCFUNSQXBI',true,"1300662969",null,null,function() { return Ne(At(Utilities.Make(window).GetCallerString('TIPOOPRAP'),'28|41|47'),0) })
_Obli('CODINTER',0,'CROCGCIGKF',false)
_Obli('DATAINI',2,'BJKHVZBXDR',true,"45547614",null,null,function() { return Ne(At(Utilities.Make(window).GetCallerString('TIPOOPRAP'),'25|39|40'),0) })
_Obli('NOAGE',0,'YFNPTNWMJX',false)
