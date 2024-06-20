function FillCombosValues() {
FillCombo('RBGNGVNHKX','RBGNGVNHKX');
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('QKQADIZQMK',function(){return WtH(w_PBCODICE,'N',10,0,'9999999999')},w_PBCODICE);
SPBOUILib.SetInputValue('PSYBDTLXBB',function(){return WtH(w_PBDESCRI,'C',60,0,'')},w_PBDESCRI);
SPBOUILib.SetInputValue('XLHKEFVDJB',function(){return WtH(w_PBNOTE,'M',10,0,'')},w_PBNOTE);
if(c=Ctrl('CLFPQIXXGN')) ChkboxCheckUncheck(c,'S',w_PBATTIVO)
if(c=Ctrl('CLFPQIXXGN')) ChkboxValueAssign(c,'S','N','C',1,0,'')
SPBOUILib.SetInputValue('OZYMSYFDTV',function(){return WtH(w_PBNOMPRC,'C',30,0,'')},w_PBNOMPRC);
var tmp_NSGDWUYWKE = ToHTag(AsControlValue('Procedura '+( ! (Empty(w_PBNOMPRC)) && Empty(w_PBLASTEND)?'in esecuzione':'terminata')));
if (Ne(e_NSGDWUYWKE,tmp_NSGDWUYWKE)) {
SPBOUILib.SetLabelValue('NSGDWUYWKE','innerHTML',tmp_NSGDWUYWKE);
e_NSGDWUYWKE=tmp_NSGDWUYWKE;
}
if(c=Ctrl('RBGNGVNHKX')) selectCombo(c,w_PBROUTINE,'C')
SPBOUILib.SetInputValue('YCLKFFWYHB',function(){return WtH(w_PBTIMEXP,'C',70,0,'')},w_PBTIMEXP);
if(c=Ctrl('MJZIHCRMOJ')) ChkboxCheckUncheck(c,true,w_PBFORZAESEC)
if(c=Ctrl('MJZIHCRMOJ')) ChkboxValueAssign(c,true,false,'L',1,0,'')
SPBOUILib.SetInputValue('KUVWADTGLC',function(){return WtH(w_PBLASTSTART,'T',14,0,TranslatePicture(GetDatePicture(true,'T'),'T'))},w_PBLASTSTART);
SPBOUILib.SetInputValue('CXUCPFUHPI',function(){return WtH(w_PBLASTEND,'T',14,0,TranslatePicture(GetDatePicture(true,'T'),'T'))},w_PBLASTEND);
if (m_bExtended) {
SetExtensions();
}
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay(Ctrl('NSGDWUYWKE'),Ne(EntityStatus(),'V'));
SetDisplay('OHEWQINDHE_DIV',IsHiddenByStateDriver('Esempi Espressione di tempo'));
LibJavascript.forEachItem(m_FoundlingHideExpression,i_body_2)
function i_body_2(child){
child();
}
HideUI();
}
HideUI.lblids["PBCODICE"]=['YJFWJNGCWS'];
HideUI.lblids["PBDESCRI"]=['NFDQSYZPHE'];
HideUI.lblids["PBLASTEND"]=['KETQVGLNSK'];
HideUI.lblids["PBLASTSTART"]=['QHOMJWJVOI'];
HideUI.lblids["PBNOMPRC"]=['LNVBPSDGHY'];
HideUI.lblids["PBNOTE"]=['VXCYLRZJRB'];
HideUI.lblids["PBROUTINE"]=['UXOCULULZU'];
HideUI.lblids["PBTIMEXP"]=['PVCOGKTDDH'];
function ExpandCollapseBoxesUnderCondition() {
var cond;
}
function QKQADIZQMK_Valid(e) {
SetActiveField(Ctrl('QKQADIZQMK'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('QKQADIZQMK') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('PBCODICE','N',w_PBCODICE,HtW(Ctrl('QKQADIZQMK').value,'N'),m_bQueryOnLatestKeyOnly);
}
}
}
function QKQADIZQMK_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('QKQADIZQMK'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('QKQADIZQMK',w_PBCODICE,'N',10,0,'9999999999');
SetActiveField(Ctrl('QKQADIZQMK'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('QKQADIZQMK'),e);
}
function QKQADIZQMK_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("9999999999"));
}
function PSYBDTLXBB_Valid(e) {
SetActiveField(Ctrl('PSYBDTLXBB'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('PBDESCRI','C',w_PBDESCRI,HtW(Ctrl('PSYBDTLXBB').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PBDESCRI(HtW(Ctrl('PSYBDTLXBB').value,'C'),null,e);
return l_bSetResult;
}
}
function PSYBDTLXBB_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('PSYBDTLXBB'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('PSYBDTLXBB'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('PSYBDTLXBB'),e);
}
function XLHKEFVDJB_Valid(e) {
SetActiveField(Ctrl('XLHKEFVDJB'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('PBNOTE','M',w_PBNOTE,HtW(Ctrl('XLHKEFVDJB').value,'M'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PBNOTE(HtW(Ctrl('XLHKEFVDJB').value,'M'),null,e);
return l_bSetResult;
}
}
function XLHKEFVDJB_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('XLHKEFVDJB'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('XLHKEFVDJB'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('XLHKEFVDJB'),e);
}
function CLFPQIXXGN_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('PBATTIVO','C',w_PBATTIVO,ChkboxValueAssign(Ctrl('CLFPQIXXGN'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PBATTIVO(ChkboxValueAssign(Ctrl('CLFPQIXXGN'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function CLFPQIXXGN_OnFocus(e) {
SetActiveField(Ctrl('CLFPQIXXGN'),true);
}
function CLFPQIXXGN_OnBlur(e) {
SetActiveField(Ctrl('CLFPQIXXGN'),false);
}
function RBGNGVNHKX_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('PBROUTINE','C',w_PBROUTINE,HtW(getComboValue(Ctrl('RBGNGVNHKX')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PBROUTINE(HtW(getComboValue(Ctrl('RBGNGVNHKX')),'C'),null,e);
return l_bSetResult;
}
}
function RBGNGVNHKX_OnFocus(e) {
SetActiveField(Ctrl('RBGNGVNHKX'),true);
}
function RBGNGVNHKX_OnBlur(e) {
SetActiveField(Ctrl('RBGNGVNHKX'),false);
}
function YCLKFFWYHB_Valid(e) {
SetActiveField(Ctrl('YCLKFFWYHB'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('PBTIMEXP','C',w_PBTIMEXP,HtW(Ctrl('YCLKFFWYHB').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PBTIMEXP(HtW(Ctrl('YCLKFFWYHB').value,'C'),null,e);
return l_bSetResult;
}
}
function YCLKFFWYHB_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('YCLKFFWYHB'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('YCLKFFWYHB'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('YCLKFFWYHB'),e);
}
function MJZIHCRMOJ_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('PBFORZAESEC','L',w_PBFORZAESEC,ChkboxValueAssign(Ctrl('MJZIHCRMOJ'),true,false,'L',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PBFORZAESEC(ChkboxValueAssign(Ctrl('MJZIHCRMOJ'),true,false,'L',1,0,''),null,e);
return l_bSetResult;
}
}
function MJZIHCRMOJ_OnFocus(e) {
SetActiveField(Ctrl('MJZIHCRMOJ'),true);
}
function MJZIHCRMOJ_OnBlur(e) {
SetActiveField(Ctrl('MJZIHCRMOJ'),false);
}
function href_PVCOGKTDDH(el) {
ToggleLayerBox(arguments.length>0 && arguments[0].isConnected?arguments[0]:'PVCOGKTDDH_DIV',GetLayerID("Esempi Espressione di tempo"),'00',false,'shadowBand_TOP_OF_PAGE_1','',false)
}
function onfocus_PVCOGKTDDH() {
ShowLayerBox('PVCOGKTDDH_DIV',GetLayerID('Esempi Espressione di tempo'),'00',false,'shadowBand_TOP_OF_PAGE_1','',false,'focus');
}
function KUVWADTGLC_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('KUVWADTGLC'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.datetimeLocal)) {
Ctrl('KUVWADTGLC').value=ApplyPictureToDateTime(Ctrl('KUVWADTGLC').value,TranslatePicture(dateTimePattern),'KUVWADTGLC');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.datetimeLocal) {
CheckDateValidity(Ctrl('KUVWADTGLC'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('KUVWADTGLC');
}
}
}
SetActiveField(Ctrl('KUVWADTGLC'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('PBLASTSTART','T',w_PBLASTSTART,HtW(Ctrl('KUVWADTGLC').value,'T'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PBLASTSTART(HtW(Ctrl('KUVWADTGLC').value,'T'),null,e) && dateisok;
return l_bSetResult;
}
}
function KUVWADTGLC_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('KUVWADTGLC'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.datetimeLocal)) {
SPBOUILib.WtH('KUVWADTGLC',w_PBLASTSTART,'T',14,0,TranslatePicture(GetDatePicture(false,'T'),'T'));
}
m_oEnteredInDate=Ctrl('KUVWADTGLC');
SetActiveField(Ctrl('KUVWADTGLC'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('KUVWADTGLC'),e);
}
function KUVWADTGLC_ZOOM_Click() {
LaunchCalendar(Ctrl('KUVWADTGLC'));
}
function CXUCPFUHPI_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('CXUCPFUHPI'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.datetimeLocal)) {
Ctrl('CXUCPFUHPI').value=ApplyPictureToDateTime(Ctrl('CXUCPFUHPI').value,TranslatePicture(dateTimePattern),'CXUCPFUHPI');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.datetimeLocal) {
CheckDateValidity(Ctrl('CXUCPFUHPI'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('CXUCPFUHPI');
}
}
}
SetActiveField(Ctrl('CXUCPFUHPI'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('PBLASTEND','T',w_PBLASTEND,HtW(Ctrl('CXUCPFUHPI').value,'T'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PBLASTEND(HtW(Ctrl('CXUCPFUHPI').value,'T'),null,e) && dateisok;
return l_bSetResult;
}
}
function CXUCPFUHPI_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('CXUCPFUHPI'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.datetimeLocal)) {
SPBOUILib.WtH('CXUCPFUHPI',w_PBLASTEND,'T',14,0,TranslatePicture(GetDatePicture(false,'T'),'T'));
}
m_oEnteredInDate=Ctrl('CXUCPFUHPI');
SetActiveField(Ctrl('CXUCPFUHPI'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('CXUCPFUHPI'),e);
}
function CXUCPFUHPI_ZOOM_Click() {
LaunchCalendar(Ctrl('CXUCPFUHPI'));
}
linkpc_url.u('ERKDOYUXFB',function(){return 'dt_tbprcbck_param?m_bInnerChild=true'+GetLinkPCKeys('dt_tbprcbck_param')+'&m_bRowsChild='+EnableChild('dt_tbprcbck_param')})
_ResetTracker();
function setEventHandlers() {
var c;
function PVCOGKTDDH_wrap_OnClick(event) {
return href_PVCOGKTDDH(event.srcElement);
}
SPBOUILib.SetLabelClick('PVCOGKTDDH',PVCOGKTDDH_wrap_OnClick);
function PVCOGKTDDH_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetLabelKeyDown('PVCOGKTDDH',PVCOGKTDDH_wrap_OnKeyDown);
if (Ne(m_cFunction,'view')) {
function QKQADIZQMK_wrap_Valid(event) {
return QKQADIZQMK_Valid(event);
}
SPBOUILib.SetInputExit('QKQADIZQMK',QKQADIZQMK_wrap_Valid);
function QKQADIZQMK_wrap_OnFocus(event) {
return QKQADIZQMK_OnFocus(event);
}
SPBOUILib.SetInputEnter('QKQADIZQMK',QKQADIZQMK_wrap_OnFocus);
function QKQADIZQMK_wrap_OnKeyPress(event) {
return QKQADIZQMK_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('QKQADIZQMK',QKQADIZQMK_wrap_OnKeyPress);
function QKQADIZQMK_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('QKQADIZQMK',QKQADIZQMK_wrap_OnKeyDown);
function PSYBDTLXBB_wrap_Valid(event) {
return PSYBDTLXBB_Valid(event);
}
SPBOUILib.SetInputExit('PSYBDTLXBB',PSYBDTLXBB_wrap_Valid);
function PSYBDTLXBB_wrap_OnFocus(event) {
return PSYBDTLXBB_OnFocus(event);
}
SPBOUILib.SetInputEnter('PSYBDTLXBB',PSYBDTLXBB_wrap_OnFocus);
function PSYBDTLXBB_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('PSYBDTLXBB',PSYBDTLXBB_wrap_OnKeyDown);
function XLHKEFVDJB_wrap_Valid(event) {
return XLHKEFVDJB_Valid(event);
}
SPBOUILib.SetInputExit('XLHKEFVDJB',XLHKEFVDJB_wrap_Valid);
function XLHKEFVDJB_wrap_OnFocus(event) {
return XLHKEFVDJB_OnFocus(event);
}
SPBOUILib.SetInputEnter('XLHKEFVDJB',XLHKEFVDJB_wrap_OnFocus);
function CLFPQIXXGN_wrap_Valid(event) {
return CLFPQIXXGN_Valid(event);
}
SPBOUILib.SetCheckboxClick('CLFPQIXXGN',CLFPQIXXGN_wrap_Valid);
function CLFPQIXXGN_wrap_OnFocus(event) {
return CLFPQIXXGN_OnFocus(event);
}
SPBOUILib.SetInputEnter('CLFPQIXXGN',CLFPQIXXGN_wrap_OnFocus);
function CLFPQIXXGN_wrap_Blur(event) {
return CLFPQIXXGN_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('CLFPQIXXGN',CLFPQIXXGN_wrap_Blur);
function RBGNGVNHKX_wrap_Valid(event) {
return RBGNGVNHKX_Valid(event);
}
SPBOUILib.SetComboChange('RBGNGVNHKX',RBGNGVNHKX_wrap_Valid);
function RBGNGVNHKX_wrap_OnFocus(event) {
return RBGNGVNHKX_OnFocus(event);
}
SPBOUILib.SetInputEnter('RBGNGVNHKX',RBGNGVNHKX_wrap_OnFocus);
function RBGNGVNHKX_wrap_Blur(event) {
return RBGNGVNHKX_OnBlur(event);
}
SPBOUILib.SetInputExit('RBGNGVNHKX',RBGNGVNHKX_wrap_Blur);
function YCLKFFWYHB_wrap_Valid(event) {
return YCLKFFWYHB_Valid(event);
}
SPBOUILib.SetInputExit('YCLKFFWYHB',YCLKFFWYHB_wrap_Valid);
function YCLKFFWYHB_wrap_OnFocus(event) {
return YCLKFFWYHB_OnFocus(event);
}
SPBOUILib.SetInputEnter('YCLKFFWYHB',YCLKFFWYHB_wrap_OnFocus);
function YCLKFFWYHB_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('YCLKFFWYHB',YCLKFFWYHB_wrap_OnKeyDown);
function MJZIHCRMOJ_wrap_Valid(event) {
return MJZIHCRMOJ_Valid(event);
}
SPBOUILib.SetCheckboxClick('MJZIHCRMOJ',MJZIHCRMOJ_wrap_Valid);
function MJZIHCRMOJ_wrap_OnFocus(event) {
return MJZIHCRMOJ_OnFocus(event);
}
SPBOUILib.SetInputEnter('MJZIHCRMOJ',MJZIHCRMOJ_wrap_OnFocus);
function MJZIHCRMOJ_wrap_Blur(event) {
return MJZIHCRMOJ_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('MJZIHCRMOJ',MJZIHCRMOJ_wrap_Blur);
function PVCOGKTDDH_wrap_OnFocus(event) {
return onfocus_PVCOGKTDDH;
}
SPBOUILib.NullFunction('PVCOGKTDDH',PVCOGKTDDH_wrap_OnFocus);
function KUVWADTGLC_wrap_Valid(event) {
return KUVWADTGLC_Valid(event);
}
SPBOUILib.SetInputExit('KUVWADTGLC',KUVWADTGLC_wrap_Valid);
function KUVWADTGLC_wrap_OnFocus(event) {
return KUVWADTGLC_OnFocus(event);
}
SPBOUILib.SetInputEnter('KUVWADTGLC',KUVWADTGLC_wrap_OnFocus);
function KUVWADTGLC_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('KUVWADTGLC',KUVWADTGLC_wrap_OnKeyPress);
function KUVWADTGLC_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('KUVWADTGLC',KUVWADTGLC_wrap_OnKeyDown);
function KUVWADTGLC_ZOOM_setHandlers() {
function KUVWADTGLC_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?KUVWADTGLC_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('KUVWADTGLC_ZOOM',KUVWADTGLC_ZOOM_wrap_OnClick);
function KUVWADTGLC_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('KUVWADTGLC_ZOOM',KUVWADTGLC_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('KUVWADTGLC',KUVWADTGLC_ZOOM_setHandlers);
function CXUCPFUHPI_wrap_Valid(event) {
return CXUCPFUHPI_Valid(event);
}
SPBOUILib.SetInputExit('CXUCPFUHPI',CXUCPFUHPI_wrap_Valid);
function CXUCPFUHPI_wrap_OnFocus(event) {
return CXUCPFUHPI_OnFocus(event);
}
SPBOUILib.SetInputEnter('CXUCPFUHPI',CXUCPFUHPI_wrap_OnFocus);
function CXUCPFUHPI_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('CXUCPFUHPI',CXUCPFUHPI_wrap_OnKeyPress);
function CXUCPFUHPI_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('CXUCPFUHPI',CXUCPFUHPI_wrap_OnKeyDown);
function CXUCPFUHPI_ZOOM_setHandlers() {
function CXUCPFUHPI_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?CXUCPFUHPI_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('CXUCPFUHPI_ZOOM',CXUCPFUHPI_ZOOM_wrap_OnClick);
function CXUCPFUHPI_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('CXUCPFUHPI_ZOOM',CXUCPFUHPI_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('CXUCPFUHPI',CXUCPFUHPI_ZOOM_setHandlers);
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
FocusFirstComponent.edit={"page_1":["PSYBDTLXBB"]};
FocusFirstComponent.query={"page_1":["QKQADIZQMK","PSYBDTLXBB"]};
FocusFirstComponent.otherwise={"page_1":["PSYBDTLXBB"]};
function Help() {
windowOpenForeground('../doc/armt_tbprcbck_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
}
function CalledBatchEnd() {
if ( ! (m_bCalculating)) {
DoUpdate(true);
}
}
function SetModified_dt_tbprcbck_param() {
SetModified();
}
function LoadChildrenInPage(page,lazy) {
if (Eq(page,'page_1')) {
if (ChildToLoad('ERKDOYUXFB')) {
LoadContext.lc(1,'ERKDOYUXFB');
} else {
LibJavascript.RefreshChildGrid('ERKDOYUXFB');
}
}
}
GetLayerID.Layers.push({"id":"OHEWQINDHE","name":"Esempi Espressione di tempo"});
function DeclareWVs() {
var a = arguments;
w_PBCODICE=a[0];
op_PBCODICE=a[1];
w_PBDESCRI=a[2];
w_PBNOTE=a[3];
w_PBATTIVO=a[4];
w_PBNOMPRC=a[5];
w_PBROUTINE=a[6];
w_PBTIMEXP=a[7];
w_PBFORZAESEC=a[8];
w_PBLASTSTART=a[9];
w_PBLASTEND=a[10];
op_codazi=a[11];
m_cWv_dt_tbprcbck_param=a[12];
if (Gt(a.length,13)) {
m_cErrorInChild='';
}
m_PrimaryKeys=['PBCODICE'];
}
function i_PrimaryKey() {
return 'tbprcbck'+'\\'+CPLib.ToCPStr(w_PBCODICE);
}
GetLinkPCKeys.set_o('dt_tbprcbck_param',false);
GetLinkPCKeys.o['dt_tbprcbck_param']['PPCODICE']=function(t){
if (Ne(m_cFunction,'new')) {
return t(w_PBCODICE,'N');
}
}
function EnableChild(name) {
var l_bRes = false;
return l_bRes;
}
function CheckZone(me) {
return true;
}
LoadContext.f('ERKDOYUXFB',function(){return FrameRef('dt_tbprcbck_param')},1,'dt_tbprcbck_param',1,1)
GetSelectedChildPage.child={'dt_tbprcbck_param': function(){return FrameRef('dt_tbprcbck_param')}}
function GetSelectedPage(p_d) {
p_d.setValue('armt_tbprcbck',m_cSelectedPage);
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
_Obli('PBLASTEND',3,'CXUCPFUHPI',false,"1456705060")
_Obli('PBDESCRI',0,'PSYBDTLXBB',false,"285808099")
_Obli('PBNOTE',0,'XLHKEFVDJB',false,"10595583898")
_Obli('PBATTIVO',0,'CLFPQIXXGN',false,"10509971720")
_Obli('PBTIMEXP',0,'YCLKFFWYHB',false,"1905945337")
_Obli('PBROUTINE',0,'RBGNGVNHKX',false,"10198365762")
_Obli('PBFORZAESEC',4,'MJZIHCRMOJ',false,"10581314837")
_Obli('PBLASTSTART',3,'KUVWADTGLC',false,"10735417238")
