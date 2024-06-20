function FillCombosValues() {
FillCombo('JJGGLREGPJ','JJGGLREGPJ');
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('SWIXXXOOHL',function(){return WtH(w_IBCODICE,'N',10,0,'9999999999')},w_IBCODICE);
if(c=Ctrl('JJGGLREGPJ')) selectCombo(c,w_IBCODCAT,'C')
if(c=Ctrl('UJTOVLNUSR')) ChkboxCheckUncheck(c,'S',w_IBINFATT)
if(c=Ctrl('UJTOVLNUSR')) ChkboxValueAssign(c,'S','N','C',1,0,'')
SPBOUILib.SetInputValue('HBQLZAGMVV',function(){return WtH(w_IBTITOLO,'C',60,0,'')},w_IBTITOLO);
SPBOUILib.SetInputValue('DXXWPHEGDY',function(){return WtH(w_IBDESCRI,'M',10,0,'')},w_IBDESCRI);
SPBOUILib.SetInputValue('CUJWZRIREL',function(){return WtH(w_IBDATSCA,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_IBDATSCA);
SPBOUILib.SetInputValue('USYOMFBTEF',function(){return WtH(w_IBDATINS,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_IBDATINS);
if (m_bExtended) {
SetExtensions();
}
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay('IQTXUVONAM_DIV',IsHiddenByStateDriver('Documenti'));
LibJavascript.forEachItem(m_FoundlingHideExpression,i_body_2)
function i_body_2(child){
child();
}
HideUI();
}
HideUI.lblids["IBCODCAT"]=['FTLYOSKZFL'];
HideUI.lblids["IBCODICE"]=['WWBHZFBWSC'];
HideUI.lblids["IBDATINS"]=['XKQCAINFDP'];
HideUI.lblids["IBDATSCA"]=['WEUEZJBPPC'];
HideUI.lblids["IBDESCRI"]=['LTZLAALOWH'];
HideUI.lblids["IBTITOLO"]=['KQIJGSSJZM'];
function ExpandCollapseBoxesUnderCondition() {
var cond;
}
function SWIXXXOOHL_Valid(e) {
SetActiveField(Ctrl('SWIXXXOOHL'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('SWIXXXOOHL') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('IBCODICE','N',w_IBCODICE,HtW(Ctrl('SWIXXXOOHL').value,'N'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IBCODICE(HtW(Ctrl('SWIXXXOOHL').value,'N'),null,e);
return l_bSetResult;
}
}
function SWIXXXOOHL_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('SWIXXXOOHL'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('SWIXXXOOHL',w_IBCODICE,'N',10,0,'9999999999');
SetActiveField(Ctrl('SWIXXXOOHL'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('SWIXXXOOHL'),e);
}
function SWIXXXOOHL_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("9999999999"));
}
function JJGGLREGPJ_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('IBCODCAT','C',w_IBCODCAT,HtW(getComboValue(Ctrl('JJGGLREGPJ')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IBCODCAT(HtW(getComboValue(Ctrl('JJGGLREGPJ')),'C'),null,e);
return l_bSetResult;
}
}
function JJGGLREGPJ_OnFocus(e) {
SetActiveField(Ctrl('JJGGLREGPJ'),true);
}
function JJGGLREGPJ_OnBlur(e) {
SetActiveField(Ctrl('JJGGLREGPJ'),false);
}
function UJTOVLNUSR_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('IBINFATT','C',w_IBINFATT,ChkboxValueAssign(Ctrl('UJTOVLNUSR'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IBINFATT(ChkboxValueAssign(Ctrl('UJTOVLNUSR'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function UJTOVLNUSR_OnFocus(e) {
SetActiveField(Ctrl('UJTOVLNUSR'),true);
}
function UJTOVLNUSR_OnBlur(e) {
SetActiveField(Ctrl('UJTOVLNUSR'),false);
}
function HBQLZAGMVV_Valid(e) {
SetActiveField(Ctrl('HBQLZAGMVV'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('IBTITOLO','C',w_IBTITOLO,HtW(Ctrl('HBQLZAGMVV').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IBTITOLO(HtW(Ctrl('HBQLZAGMVV').value,'C'),null,e);
return l_bSetResult;
}
}
function HBQLZAGMVV_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('HBQLZAGMVV'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('HBQLZAGMVV'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('HBQLZAGMVV'),e);
}
function DXXWPHEGDY_Valid(e) {
SetActiveField(Ctrl('DXXWPHEGDY'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('IBDESCRI','M',w_IBDESCRI,HtW(Ctrl('DXXWPHEGDY').value,'M'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IBDESCRI(HtW(Ctrl('DXXWPHEGDY').value,'M'),null,e);
return l_bSetResult;
}
}
function DXXWPHEGDY_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('DXXWPHEGDY'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('DXXWPHEGDY'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('DXXWPHEGDY'),e);
}
function CUJWZRIREL_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('CUJWZRIREL'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('CUJWZRIREL').value=ApplyPictureToDate(Ctrl('CUJWZRIREL').value,TranslatePicture(datePattern),'CUJWZRIREL');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('CUJWZRIREL'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('CUJWZRIREL');
}
}
}
SetActiveField(Ctrl('CUJWZRIREL'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('IBDATSCA','D',w_IBDATSCA,HtW(Ctrl('CUJWZRIREL').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IBDATSCA(HtW(Ctrl('CUJWZRIREL').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function CUJWZRIREL_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('CUJWZRIREL'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('CUJWZRIREL',w_IBDATSCA,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('CUJWZRIREL');
SetActiveField(Ctrl('CUJWZRIREL'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('CUJWZRIREL'),e);
}
function CUJWZRIREL_ZOOM_Click() {
LaunchCalendar(Ctrl('CUJWZRIREL'));
}
linkpc_url.u('DLDDEEJTBX',function(){return 'ardt_cgo_infbacheca_doc?m_bInnerChild=true'+GetLinkPCKeys('ardt_cgo_infbacheca_doc')+'&m_bRowsChild='+EnableChild('ardt_cgo_infbacheca_doc')})
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function SWIXXXOOHL_wrap_Valid(event) {
return SWIXXXOOHL_Valid(event);
}
SPBOUILib.SetInputExit('SWIXXXOOHL',SWIXXXOOHL_wrap_Valid);
function SWIXXXOOHL_wrap_OnFocus(event) {
return SWIXXXOOHL_OnFocus(event);
}
SPBOUILib.SetInputEnter('SWIXXXOOHL',SWIXXXOOHL_wrap_OnFocus);
function SWIXXXOOHL_wrap_OnKeyPress(event) {
return SWIXXXOOHL_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('SWIXXXOOHL',SWIXXXOOHL_wrap_OnKeyPress);
function SWIXXXOOHL_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('SWIXXXOOHL',SWIXXXOOHL_wrap_OnKeyDown);
function JJGGLREGPJ_wrap_Valid(event) {
return JJGGLREGPJ_Valid(event);
}
SPBOUILib.SetComboChange('JJGGLREGPJ',JJGGLREGPJ_wrap_Valid);
function JJGGLREGPJ_wrap_OnFocus(event) {
return JJGGLREGPJ_OnFocus(event);
}
SPBOUILib.SetInputEnter('JJGGLREGPJ',JJGGLREGPJ_wrap_OnFocus);
function JJGGLREGPJ_wrap_Blur(event) {
return JJGGLREGPJ_OnBlur(event);
}
SPBOUILib.SetInputExit('JJGGLREGPJ',JJGGLREGPJ_wrap_Blur);
function UJTOVLNUSR_wrap_Valid(event) {
return UJTOVLNUSR_Valid(event);
}
SPBOUILib.SetCheckboxClick('UJTOVLNUSR',UJTOVLNUSR_wrap_Valid);
function UJTOVLNUSR_wrap_OnFocus(event) {
return UJTOVLNUSR_OnFocus(event);
}
SPBOUILib.SetInputEnter('UJTOVLNUSR',UJTOVLNUSR_wrap_OnFocus);
function UJTOVLNUSR_wrap_Blur(event) {
return UJTOVLNUSR_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('UJTOVLNUSR',UJTOVLNUSR_wrap_Blur);
function HBQLZAGMVV_wrap_Valid(event) {
return HBQLZAGMVV_Valid(event);
}
SPBOUILib.SetInputExit('HBQLZAGMVV',HBQLZAGMVV_wrap_Valid);
function HBQLZAGMVV_wrap_OnFocus(event) {
return HBQLZAGMVV_OnFocus(event);
}
SPBOUILib.SetInputEnter('HBQLZAGMVV',HBQLZAGMVV_wrap_OnFocus);
function HBQLZAGMVV_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('HBQLZAGMVV',HBQLZAGMVV_wrap_OnKeyDown);
function DXXWPHEGDY_wrap_Valid(event) {
return DXXWPHEGDY_Valid(event);
}
SPBOUILib.SetInputExit('DXXWPHEGDY',DXXWPHEGDY_wrap_Valid);
function DXXWPHEGDY_wrap_OnFocus(event) {
return DXXWPHEGDY_OnFocus(event);
}
SPBOUILib.SetInputEnter('DXXWPHEGDY',DXXWPHEGDY_wrap_OnFocus);
function CUJWZRIREL_wrap_Valid(event) {
return CUJWZRIREL_Valid(event);
}
SPBOUILib.SetInputExit('CUJWZRIREL',CUJWZRIREL_wrap_Valid);
function CUJWZRIREL_wrap_OnFocus(event) {
return CUJWZRIREL_OnFocus(event);
}
SPBOUILib.SetInputEnter('CUJWZRIREL',CUJWZRIREL_wrap_OnFocus);
function CUJWZRIREL_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('CUJWZRIREL',CUJWZRIREL_wrap_OnKeyPress);
function CUJWZRIREL_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('CUJWZRIREL',CUJWZRIREL_wrap_OnKeyDown);
function CUJWZRIREL_ZOOM_setHandlers() {
function CUJWZRIREL_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?CUJWZRIREL_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('CUJWZRIREL_ZOOM',CUJWZRIREL_ZOOM_wrap_OnClick);
function CUJWZRIREL_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('CUJWZRIREL_ZOOM',CUJWZRIREL_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('CUJWZRIREL',CUJWZRIREL_ZOOM_setHandlers);
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
FocusFirstComponent.edit={"page_1":["JJGGLREGPJ"]};
FocusFirstComponent.query={"page_1":["SWIXXXOOHL"]};
FocusFirstComponent.otherwise={"page_1":["SWIXXXOOHL"]};
function Help() {
windowOpenForeground('../doc/armt_cgo_infbacheca_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
}
function CalledBatchEnd() {
if ( ! (m_bCalculating)) {
DoUpdate(true);
}
}
function SetModified_ardt_cgo_infbacheca_doc() {
SetModified();
}
function LoadChildrenInPage(page,lazy) {
if (Eq(page,'page_1')) {
if (ChildToLoad('DLDDEEJTBX')) {
if (Eq(lazy,null) || LibJavascript.UserCanSee('DLDDEEJTBX')) {
LoadContext.lc(1,'DLDDEEJTBX');
}
} else {
LibJavascript.RefreshChildGrid('DLDDEEJTBX');
}
}
}
GetLayerID.Layers.push({"id":"IQTXUVONAM","name":"Documenti"});
function DeclareWVs() {
var a = arguments;
w_IBCODICE=a[0];
op_IBCODICE=a[1];
w_IBCODCAT=a[2];
w_IBINFATT=a[3];
w_IBTITOLO=a[4];
w_IBDESCRI=a[5];
w_IBDATSCA=a[6];
w_IBDATINS=a[7];
op_codazi=a[8];
m_cWv_ardt_cgo_infbacheca_doc=a[9];
if (Gt(a.length,10)) {
m_cErrorInChild='';
}
m_PrimaryKeys=['IBCODICE'];
}
function i_PrimaryKey() {
return 'cgo_infbacheca'+'\\'+CPLib.ToCPStr(w_IBCODICE);
}
GetLinkPCKeys.set_o('ardt_cgo_infbacheca_doc',false);
GetLinkPCKeys.o['ardt_cgo_infbacheca_doc']['IBDCODICE']=function(t){
if (Ne(m_cFunction,'new')) {
return t(w_IBCODICE,'N');
}
}
function EnableChild(name) {
var l_bRes = false;
return l_bRes;
}
function CheckZone(me) {
return true;
}
LoadContext.f('DLDDEEJTBX',function(){return FrameRef('ardt_cgo_infbacheca_doc')},1,'ardt_cgo_infbacheca_doc',1,1)
GetSelectedChildPage.child={'ardt_cgo_infbacheca_doc': function(){return FrameRef('ardt_cgo_infbacheca_doc')}}
function GetSelectedPage(p_d) {
p_d.setValue('armt_cgo_infbacheca',m_cSelectedPage);
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
_Obli('IBCODICE',1,'SWIXXXOOHL',false,"112851763")
_Obli('IBCODCAT',0,'JJGGLREGPJ',false,"157141684")
_Obli('IBINFATT',0,'UJTOVLNUSR',false,"11065317557")
_Obli('IBTITOLO',0,'HBQLZAGMVV',false,"123955940")
_Obli('IBDESCRI',0,'DXXWPHEGDY',false,"285808099")
_Obli('IBDATSCA',2,'CUJWZRIREL',false,"2025824008")
