function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('EASNYTBCXF',function(){return WtH(w_code,'C',10,0,'')},w_code);
if(c=Ctrl('YMLUFDPGUE')) selectRadio(c,w_bPrinter,'L')
if(c=Ctrl('TWBOJVJHUV')) selectCombo(c,w_printer,'C')
SPBOUILib.SetInputValue('BGAXFHUKER',function(){return WtH(w_queue,'C',80,0,'')},w_queue);
SPBOUILib.SetInputValue('JICLLDYGVB',function(){return WtH(w_prndescription,'C',30,0,'')},w_prndescription);
if (m_bExtended) {
SetExtensions();
}
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay(Ctrl('BIYQHLLFYE'),true);
SetDisplay(Ctrl('DBMAKFDROI'),true);
SetDisplay(Ctrl('LEFWMHXGWF'),Eq(w_bPrinter,false));
SetDisplay('KEXVXSBZNH_DIV',Eq(w_bPrinter,false) || IsHiddenByStateDriver('box_KEXVXSBZNH'));
SetDisplay('BIGLLUNRZE_DIV',Eq(w_bPrinter,true) || IsHiddenByStateDriver('box_BIGLLUNRZE'));
LibJavascript.forEachItem(m_FoundlingHideExpression,i_body_2)
function i_body_2(child){
child();
}
HideUI();
}
HideUI.lblids["bPrinter"]=['BLONAXVSYB'];
HideUI.lblids["code"]=['KFPBUBZIKH'];
HideUI.lblids["printer"]=['JZMLVGUAUJ'];
HideUI.lblids["prnconnection"]=['BIYQHLLFYE'];
HideUI.lblids["prndescription"]=['BFOHURODML'];
HideUI.lblids["queue"]=['NHXYPYXJDH'];
function ExpandCollapseBoxesUnderCondition() {
var cond;
}
function EASNYTBCXF_Valid(e) {
SetActiveField(Ctrl('EASNYTBCXF'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('EASNYTBCXF') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('code','C',w_code,HtW(Ctrl('EASNYTBCXF').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_code(HtW(Ctrl('EASNYTBCXF').value,'C'),null,e);
return l_bSetResult;
}
}
function EASNYTBCXF_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('EASNYTBCXF'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('EASNYTBCXF'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('EASNYTBCXF'),e);
}
function href_DBMAKFDROI() {
userselectprintersettings()
}
function YMLUFDPGUE_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('bPrinter','L',w_bPrinter,HtW(getRadioValue(Ctrl('YMLUFDPGUE')),'L'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_bPrinter(HtW(getRadioValue(Ctrl('YMLUFDPGUE')),'L'),null,e);
return l_bSetResult;
}
}
function TWBOJVJHUV_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('printer','C',w_printer,HtW(getComboValue(Ctrl('TWBOJVJHUV')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_printer(HtW(getComboValue(Ctrl('TWBOJVJHUV')),'C'),null,e);
return l_bSetResult;
}
}
function TWBOJVJHUV_OnFocus(e) {
SetActiveField(Ctrl('TWBOJVJHUV'),true);
}
function TWBOJVJHUV_OnBlur(e) {
SetActiveField(Ctrl('TWBOJVJHUV'),false);
}
function BGAXFHUKER_Valid(e) {
SetActiveField(Ctrl('BGAXFHUKER'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('queue','C',w_queue,HtW(Ctrl('BGAXFHUKER').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_queue(HtW(Ctrl('BGAXFHUKER').value,'C'),null,e);
return l_bSetResult;
}
}
function BGAXFHUKER_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('BGAXFHUKER'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('BGAXFHUKER'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('BGAXFHUKER'),e);
}
function JICLLDYGVB_Valid(e) {
SetActiveField(Ctrl('JICLLDYGVB'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('prndescription','C',w_prndescription,HtW(Ctrl('JICLLDYGVB').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_prndescription(HtW(Ctrl('JICLLDYGVB').value,'C'),null,e);
return l_bSetResult;
}
}
function JICLLDYGVB_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('JICLLDYGVB'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('JICLLDYGVB'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('JICLLDYGVB'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
function DBMAKFDROI_wrap_OnClick(event) {
return href_DBMAKFDROI();
}
SPBOUILib.SetLabelClick('DBMAKFDROI',DBMAKFDROI_wrap_OnClick);
function DBMAKFDROI_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetLabelKeyDown('DBMAKFDROI',DBMAKFDROI_wrap_OnKeyDown);
if (Ne(m_cFunction,'view')) {
function EASNYTBCXF_wrap_Valid(event) {
return EASNYTBCXF_Valid(event);
}
SPBOUILib.SetInputExit('EASNYTBCXF',EASNYTBCXF_wrap_Valid);
function EASNYTBCXF_wrap_OnFocus(event) {
return EASNYTBCXF_OnFocus(event);
}
SPBOUILib.SetInputEnter('EASNYTBCXF',EASNYTBCXF_wrap_OnFocus);
function EASNYTBCXF_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('EASNYTBCXF',EASNYTBCXF_wrap_OnKeyDown);
function YMLUFDPGUE_wrap_Valid(event) {
return YMLUFDPGUE_Valid(event);
}
SPBOUILib.SetRadioClick('YMLUFDPGUE',YMLUFDPGUE_wrap_Valid);
function TWBOJVJHUV_wrap_Valid(event) {
return TWBOJVJHUV_Valid(event);
}
SPBOUILib.SetComboChange('TWBOJVJHUV',TWBOJVJHUV_wrap_Valid);
function TWBOJVJHUV_wrap_OnFocus(event) {
return TWBOJVJHUV_OnFocus(event);
}
SPBOUILib.SetInputEnter('TWBOJVJHUV',TWBOJVJHUV_wrap_OnFocus);
function TWBOJVJHUV_wrap_Blur(event) {
return TWBOJVJHUV_OnBlur(event);
}
SPBOUILib.SetInputExit('TWBOJVJHUV',TWBOJVJHUV_wrap_Blur);
function BGAXFHUKER_wrap_Valid(event) {
return BGAXFHUKER_Valid(event);
}
SPBOUILib.SetInputExit('BGAXFHUKER',BGAXFHUKER_wrap_Valid);
function BGAXFHUKER_wrap_OnFocus(event) {
return BGAXFHUKER_OnFocus(event);
}
SPBOUILib.SetInputEnter('BGAXFHUKER',BGAXFHUKER_wrap_OnFocus);
function BGAXFHUKER_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('BGAXFHUKER',BGAXFHUKER_wrap_OnKeyDown);
function JICLLDYGVB_wrap_Valid(event) {
return JICLLDYGVB_Valid(event);
}
SPBOUILib.SetInputExit('JICLLDYGVB',JICLLDYGVB_wrap_Valid);
function JICLLDYGVB_wrap_OnFocus(event) {
return JICLLDYGVB_OnFocus(event);
}
SPBOUILib.SetInputEnter('JICLLDYGVB',JICLLDYGVB_wrap_OnFocus);
function JICLLDYGVB_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('JICLLDYGVB',JICLLDYGVB_wrap_OnKeyDown);
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
if (Ne(typeof(w_spreportprinters),'undefined')) {
w_spreportprinters.raiseEvent('spadministration_printers_'+Strtran(p_cEvent,' ','_'));
}
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
FocusFirstComponent.edit={"page_1":["YMLUFDPGUE"]};
FocusFirstComponent.query={"page_1":["EASNYTBCXF"]};
FocusFirstComponent.otherwise={"page_1":["EASNYTBCXF"]};
function Help() {
windowOpenForeground('../doc/spadministration_printers_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
}
function CalledBatchEnd() {
if ( ! (m_bCalculating)) {
DoUpdate(true);
}
}
function LoadChildrenInPage(page,lazy) {
}
GetLayerID.Layers.push({"id":"KEXVXSBZNH","name":"box_KEXVXSBZNH"});
GetLayerID.Layers.push({"id":"BIGLLUNRZE","name":"box_BIGLLUNRZE"});
function DeclareWVs() {
var a = arguments;
w_code=a[0];
w_prnconnection=a[1];
w_prnconfiguration=a[2];
w_prndescription=a[3];
w_bPrinter=a[4];
w_printer=a[5];
w_queue=a[6];
m_PrimaryKeys=['code'];
}
function i_PrimaryKey() {
return 'cpprinters'+'\\'+CPLib.ToCPStr(w_code);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('spadministration_printers',m_cSelectedPage);
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
_Obli('code',0,'EASNYTBCXF',true,"960685589")
_Obli('bPrinter',4,'YMLUFDPGUE',false,"11511372462")
_Obli('printer',0,'TWBOJVJHUV',true,"10807759882",null,null,function() { return w_bPrinter })
_Obli('prndescription',0,'JICLLDYGVB',false,"1360773004")
_Obli('queue',0,'BGAXFHUKER',true,"11700314187",null,null,function() { return  ! (w_bPrinter) })
