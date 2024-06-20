function FillCombosValues() {
}
function FillInGridCombosValues(currentRow) {
var postfix = (Gt(currentRow,-1)?'_'+currentRow:'');
}
function SetControlsValue() {
var c;
if (Empty(m_cAltInterface) && (Eq(m_cFunction,'view') || Eq(m_cFunction,'query'))) {
var tmp_ABVESLGBAT = ToHTag(AsControlValue(w_xdesval));
if (Ne(e_ABVESLGBAT,tmp_ABVESLGBAT)) {
SPBOUILib.SetLabelValue('ABVESLGBAT','innerHTML',tmp_ABVESLGBAT);
e_ABVESLGBAT=tmp_ABVESLGBAT;
}
SPBOUILib.SetInputValue('IADEZIJVRP',function(){return WtH(w_SALDO,'N',17,0,'99,999,999,999,999')},w_SALDO);
SPBOUILib.SetInputValue('TKLYFIYSLT',function(){return WtH(w_QUANTITA,'N',6,0,'')},w_QUANTITA);
SPBOUILib.SetInputValue('PECYSWBJIH',function(){return WtH(w_VALUTA,'C',3,0,'')},w_VALUTA);
} else {
SPBOUILib.SetInputValue('DNNIBYMZGH',function(){return WtH(w_ANNO,'C',4,0,'')},w_ANNO);
SPBOUILib.SetInputValue('KFGZTRHOBC',function(){return WtH(w_DATAOPE,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATAOPE);
if(c=Ctrl('HPLDXSAUUT')) ChkboxCheckUncheck(c,'3',w_COINT)
if(c=Ctrl('HPLDXSAUUT')) ChkboxValueAssign(c,'3','2','C',1,0,'')
SPBOUILib.SetInputValue('WOCPOWSYXW',function(){return WtH(w_NOTE,'C',50,0,'')},w_NOTE);
SPBOUILib.SetInputValue('IADEZIJVRP',function(){return WtH(w_SALDO,'N',17,0,'99,999,999,999,999')},w_SALDO);
SPBOUILib.SetInputValue('TKLYFIYSLT',function(){return WtH(w_QUANTITA,'N',6,0,'')},w_QUANTITA);
SPBOUILib.SetInputValue('PECYSWBJIH',function(){return WtH(w_VALUTA,'C',3,0,'')},w_VALUTA);
var tmp_ABVESLGBAT = ToHTag(AsControlValue(w_xdesval));
if (Ne(e_ABVESLGBAT,tmp_ABVESLGBAT)) {
SPBOUILib.SetLabelValue('ABVESLGBAT','innerHTML',tmp_ABVESLGBAT);
e_ABVESLGBAT=tmp_ABVESLGBAT;
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
SetDisplay(Ctrl('TVZMXKVZTF'),Ne(m_cFunction,'view') || Empty(w_ANNO));
SetDisplay(Ctrl('QTNDUAUYJS'),Ne(m_cFunction,'view'));
SetDisplay(Ctrl('HLMIOBXRCT'),Ne(m_cFunction,'view') || Empty(w_ANNO));
LibJavascript.forEachItem(m_FoundlingHideExpression,i_body_2)
function i_body_2(child){
child();
}
HideUI();
}
function href_TVZMXKVZTF() {
var l_oWv = InitWvApplet();
l_oWv.setValue('annorif',AsAppletValue(w_ANNO));
l_oWv.setValue('codval',AsAppletValue(w_VALUTA));
l_oWv.setValue('CONNES',AsAppletValue(w_COLLEG));
l_oWv.setValue('dataope',AsAppletValue(w_DATAOPE));
l_oWv.setValue('txtnote',AsAppletValue(w_NOTE));
l_oWv.setValue('impsaldo',AsAppletValue(w_SALDO));
l_oWv.setValue('nummov',AsAppletValue(w_QUANTITA));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('annorif,codval,CONNES,dataope,txtnote,impsaldo,nummov'));
if (false || WindowConfirm(Translate('10377214743'))) {
_modifyandopen('aprg_mod_opextrbo'+'?m_cWv='+URLenc(l_oWv.asString())+'&m_cAction=start&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes,height=250,width=750',false)
}
}
function href_QTNDUAUYJS() {
var l_oWv = InitWvApplet();
l_oWv.setValue('CONNES',AsAppletValue(w_COLLEG));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('CONNES'));
if (false || WindowConfirm(Translate('1905576876'))) {
_modifyandopen('aprg_new_opextrbo'+'?m_cWv='+URLenc(l_oWv.asString())+'&m_cAction=start&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes,height=250,width=750',false)
}
}
function href_HLMIOBXRCT() {
var l_oWv = InitWvApplet();
l_oWv.setValue('annorif',AsAppletValue(w_ANNO));
l_oWv.setValue('CONNES',AsAppletValue(w_COLLEG));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('annorif,CONNES'));
if (false || WindowConfirm(Translate('10981436095'))) {
_modifyandopen('arrt_del_opextrbo'+'?m_cWv='+URLenc(l_oWv.asString())+'&m_cAction=start&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes,height=250,width=750',null)
}
}
function DNNIBYMZGH_Valid(e) {
SetActiveField(Ctrl('DNNIBYMZGH'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('ANNO','C',w_ANNO,HtW(Ctrl('DNNIBYMZGH').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ANNO(HtW(Ctrl('DNNIBYMZGH').value,'C'),null,e);
return l_bSetResult;
}
}
function DNNIBYMZGH_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('DNNIBYMZGH'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('DNNIBYMZGH'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('DNNIBYMZGH'),e);
}
function KFGZTRHOBC_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('KFGZTRHOBC'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('KFGZTRHOBC').value=ApplyPictureToDate(Ctrl('KFGZTRHOBC').value,TranslatePicture(datePattern),'KFGZTRHOBC');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('KFGZTRHOBC'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('KFGZTRHOBC');
}
}
}
SetActiveField(Ctrl('KFGZTRHOBC'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATAOPE','D',w_DATAOPE,HtW(Ctrl('KFGZTRHOBC').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATAOPE(HtW(Ctrl('KFGZTRHOBC').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function KFGZTRHOBC_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('KFGZTRHOBC'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('KFGZTRHOBC',w_DATAOPE,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('KFGZTRHOBC');
SetActiveField(Ctrl('KFGZTRHOBC'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('KFGZTRHOBC'),e);
}
function HPLDXSAUUT_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('COINT','C',w_COINT,ChkboxValueAssign(Ctrl('HPLDXSAUUT'),'3','2','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_COINT(ChkboxValueAssign(Ctrl('HPLDXSAUUT'),'3','2','C',1,0,''),null,e);
return l_bSetResult;
}
}
function HPLDXSAUUT_OnFocus(e) {
SetActiveField(Ctrl('HPLDXSAUUT'),true);
}
function HPLDXSAUUT_OnBlur(e) {
SetActiveField(Ctrl('HPLDXSAUUT'),false);
}
function WOCPOWSYXW_Valid(e) {
SetActiveField(Ctrl('WOCPOWSYXW'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('NOTE','C',w_NOTE,HtW(Ctrl('WOCPOWSYXW').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_NOTE(HtW(Ctrl('WOCPOWSYXW').value,'C'),null,e);
return l_bSetResult;
}
}
function WOCPOWSYXW_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('WOCPOWSYXW'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('WOCPOWSYXW'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('WOCPOWSYXW'),e);
}
function IADEZIJVRP_Valid(e) {
SetActiveField(Ctrl('IADEZIJVRP'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('SALDO','N',w_SALDO,HtW(Ctrl('IADEZIJVRP').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_SALDO(HtW(Ctrl('IADEZIJVRP').value,'N'),null,e);
return l_bSetResult;
}
}
function IADEZIJVRP_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('IADEZIJVRP'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('IADEZIJVRP',w_SALDO,'N',17,0,'99999999999999999');
SetActiveField(Ctrl('IADEZIJVRP'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('IADEZIJVRP'),e);
}
function IADEZIJVRP_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("99999999999999999"));
}
function TKLYFIYSLT_Valid(e) {
SetActiveField(Ctrl('TKLYFIYSLT'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('QUANTITA','N',w_QUANTITA,HtW(Ctrl('TKLYFIYSLT').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_QUANTITA(HtW(Ctrl('TKLYFIYSLT').value,'N'),null,e);
return l_bSetResult;
}
}
function TKLYFIYSLT_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('TKLYFIYSLT'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('TKLYFIYSLT'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('TKLYFIYSLT'),e);
}
function PECYSWBJIH_Valid(e) {
SetActiveField(Ctrl('PECYSWBJIH'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('VALUTA','C',w_VALUTA,HtW(Ctrl('PECYSWBJIH').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_VALUTA(HtW(Ctrl('PECYSWBJIH').value,'C'),null,e);
return l_bSetResult;
}
}
function PECYSWBJIH_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('PECYSWBJIH'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('PECYSWBJIH'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('PECYSWBJIH'),e);
}
function PECYSWBJIH_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('PECYSWBJIH')),'linkview_PECYSWBJIH','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
_ResetTracker();
function setEventHandlers() {
var c;
function TVZMXKVZTF_wrap_OnClick(event) {
return href_TVZMXKVZTF();
}
SPBOUILib.SetImageClick('TVZMXKVZTF',TVZMXKVZTF_wrap_OnClick);
function TVZMXKVZTF_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetKeyDown('TVZMXKVZTF',TVZMXKVZTF_wrap_OnKeyDown);
function QTNDUAUYJS_wrap_OnClick(event) {
return href_QTNDUAUYJS();
}
SPBOUILib.SetImageClick('QTNDUAUYJS',QTNDUAUYJS_wrap_OnClick);
function QTNDUAUYJS_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetKeyDown('QTNDUAUYJS',QTNDUAUYJS_wrap_OnKeyDown);
function HLMIOBXRCT_wrap_OnClick(event) {
return href_HLMIOBXRCT();
}
SPBOUILib.SetImageClick('HLMIOBXRCT',HLMIOBXRCT_wrap_OnClick);
function HLMIOBXRCT_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetKeyDown('HLMIOBXRCT',HLMIOBXRCT_wrap_OnKeyDown);
if (Ne(m_cFunction,'view')) {
function DNNIBYMZGH_wrap_Valid(event) {
return DNNIBYMZGH_Valid(event);
}
SPBOUILib.SetInputExit('DNNIBYMZGH',DNNIBYMZGH_wrap_Valid,SPBOUILib.Row.IN_GRID);
function DNNIBYMZGH_wrap_OnFocus(event) {
return DNNIBYMZGH_OnFocus(event);
}
SPBOUILib.SetInputEnter('DNNIBYMZGH',DNNIBYMZGH_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function DNNIBYMZGH_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('DNNIBYMZGH',DNNIBYMZGH_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function KFGZTRHOBC_wrap_Valid(event) {
return KFGZTRHOBC_Valid(event);
}
SPBOUILib.SetInputExit('KFGZTRHOBC',KFGZTRHOBC_wrap_Valid,SPBOUILib.Row.IN_GRID);
function KFGZTRHOBC_wrap_OnFocus(event) {
return KFGZTRHOBC_OnFocus(event);
}
SPBOUILib.SetInputEnter('KFGZTRHOBC',KFGZTRHOBC_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function KFGZTRHOBC_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('KFGZTRHOBC',KFGZTRHOBC_wrap_OnKeyPress,SPBOUILib.Row.IN_GRID);
function KFGZTRHOBC_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('KFGZTRHOBC',KFGZTRHOBC_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function HPLDXSAUUT_wrap_Valid(event) {
return HPLDXSAUUT_Valid(event);
}
SPBOUILib.SetCheckboxClick('HPLDXSAUUT',HPLDXSAUUT_wrap_Valid,SPBOUILib.Row.IN_GRID);
function HPLDXSAUUT_wrap_OnFocus(event) {
return HPLDXSAUUT_OnFocus(event);
}
SPBOUILib.SetInputEnter('HPLDXSAUUT',HPLDXSAUUT_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function HPLDXSAUUT_wrap_Blur(event) {
return HPLDXSAUUT_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('HPLDXSAUUT',HPLDXSAUUT_wrap_Blur,SPBOUILib.Row.IN_GRID);
function WOCPOWSYXW_wrap_Valid(event) {
return WOCPOWSYXW_Valid(event);
}
SPBOUILib.SetInputExit('WOCPOWSYXW',WOCPOWSYXW_wrap_Valid,SPBOUILib.Row.IN_GRID);
function WOCPOWSYXW_wrap_OnFocus(event) {
return WOCPOWSYXW_OnFocus(event);
}
SPBOUILib.SetInputEnter('WOCPOWSYXW',WOCPOWSYXW_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function WOCPOWSYXW_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('WOCPOWSYXW',WOCPOWSYXW_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function IADEZIJVRP_wrap_Valid(event) {
return IADEZIJVRP_Valid(event);
}
SPBOUILib.SetInputExit('IADEZIJVRP',IADEZIJVRP_wrap_Valid);
function IADEZIJVRP_wrap_OnFocus(event) {
return IADEZIJVRP_OnFocus(event);
}
SPBOUILib.SetInputEnter('IADEZIJVRP',IADEZIJVRP_wrap_OnFocus);
function IADEZIJVRP_wrap_OnKeyPress(event) {
return IADEZIJVRP_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('IADEZIJVRP',IADEZIJVRP_wrap_OnKeyPress);
function IADEZIJVRP_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('IADEZIJVRP',IADEZIJVRP_wrap_OnKeyDown);
function TKLYFIYSLT_wrap_Valid(event) {
return TKLYFIYSLT_Valid(event);
}
SPBOUILib.SetInputExit('TKLYFIYSLT',TKLYFIYSLT_wrap_Valid);
function TKLYFIYSLT_wrap_OnFocus(event) {
return TKLYFIYSLT_OnFocus(event);
}
SPBOUILib.SetInputEnter('TKLYFIYSLT',TKLYFIYSLT_wrap_OnFocus);
function TKLYFIYSLT_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('TKLYFIYSLT',TKLYFIYSLT_wrap_OnKeyPress);
function TKLYFIYSLT_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('TKLYFIYSLT',TKLYFIYSLT_wrap_OnKeyDown);
function PECYSWBJIH_wrap_Valid(event) {
return PECYSWBJIH_Valid(event);
}
SPBOUILib.SetInputExit('PECYSWBJIH',PECYSWBJIH_wrap_Valid);
function PECYSWBJIH_wrap_OnFocus(event) {
return PECYSWBJIH_OnFocus(event);
}
SPBOUILib.SetInputEnter('PECYSWBJIH',PECYSWBJIH_wrap_OnFocus);
function PECYSWBJIH_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('PECYSWBJIH',PECYSWBJIH_wrap_OnKeyDown);
function PECYSWBJIH_ZOOM_setHandlers() {
function PECYSWBJIH_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?PECYSWBJIH_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('PECYSWBJIH_ZOOM',PECYSWBJIH_ZOOM_wrap_OnClick);
}
SPBOUILib.SetPicker('PECYSWBJIH',PECYSWBJIH_ZOOM_setHandlers);
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
m_oFather.i_last_focused_item='child_ardt_opextrbo';
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
windowOpenForeground('../doc/ardt_opextrbo_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_COLLEG=a[0];
w_ANNO=a[1];
w_IDBASE=a[2];
w_DATAOPE=a[3];
w_COINT=a[4];
w_NOTE=a[5];
w_SALDO=a[6];
w_QUANTITA=a[7];
w_VALUTA=a[8];
w_PROGOPEX=a[9];
w_xdesval=a[10];
w_gAzienda=a[11];
m_PrimaryKeys=['ANNO','COLLEG'];
}
function i_PrimaryKey() {
return 'opextrbo'+'\\'+CPLib.ToCPStr(w_COLLEG);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('ardt_opextrbo',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
function LinkZoomExtendedMenu() {
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_VALUTA,'C'); },"field":"CODVAL","type":"C"},{"expression":function() { return WtA(w_xdesval,'C'); },"field":"DESCRI","type":"C"}],"itemRepeated":true,"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbvalute','C'),"uid":"PECYSWBJIH"});
}
function FocusFirstDetailComponent() {
var candidatesToFocus = ["DNNIBYMZGH"];
SetControlFocus(candidatesToFocus);
}
IsRepeatedChild.child=[];
function GetFullRowMsgError() {
return 'MSG_FULLROW_NOT_SAT';
}
_Obli('COINT',0,'HPLDXSAUUT',false,"10521849619")
_Obli('NOTE',0,'WOCPOWSYXW',false,"445246")
_Obli('ANNO',0,'DNNIBYMZGH',false,"999531942")
_Obli('SALDO',1,'IADEZIJVRP',false)
_Obli('DATAOPE',2,'KFGZTRHOBC',false,"829201110")
_Obli('QUANTITA',1,'TKLYFIYSLT',false,"1878793056")
_Obli('VALUTA',0,'PECYSWBJIH',false)
