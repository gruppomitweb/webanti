function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('HYBRJINCEX',function(){return WtH(w_CACODICE,'C',5,0,'')},w_CACODICE);
SPBOUILib.SetInputValue('CHXZERJJZJ',function(){return WtH(w_CADESCRI,'C',90,0,'')},w_CADESCRI);
SPBOUILib.SetInputValue('VDOLZFWZIW',function(){return WtH(w_CACODANA,'C',4,0,'')},w_CACODANA);
SPBOUILib.SetInputValue('DMYIBOGLPB',function(){return WtH(w_CACODSIN,'C',2,0,'')},w_CACODSIN);
var tmp_AHUQNNIDWH = ToHTag(AsControlValue(w_xdescauana));
if (Ne(e_AHUQNNIDWH,tmp_AHUQNNIDWH)) {
SPBOUILib.SetLabelValue('AHUQNNIDWH','innerHTML',tmp_AHUQNNIDWH);
e_AHUQNNIDWH=tmp_AHUQNNIDWH;
}
var tmp_GMFLEXZWOL = ToHTag(AsControlValue(w_xdescausin));
if (Ne(e_GMFLEXZWOL,tmp_GMFLEXZWOL)) {
SPBOUILib.SetLabelValue('GMFLEXZWOL','innerHTML',tmp_GMFLEXZWOL);
e_GMFLEXZWOL=tmp_GMFLEXZWOL;
}
SPBOUILib.SetInputValue('CRBMFUASKW',function(){return WtH(w_CASEGNO,'C',1,0,'')},w_CASEGNO);
if(c=Ctrl('RIBSWSIRGO')) selectCombo(c,w_CATIPOPE,'C')
if(c=Ctrl('BISHTFICXQ')) ChkboxCheckUncheck(c,'S',w_CAFLGDIP)
if(c=Ctrl('BISHTFICXQ')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('CAZXFCMTRO')) selectCombo(c,w_CAFLGOPE,'C')
if(c=Ctrl('VDGKIUDVJY')) ChkboxCheckUncheck(c,'S',w_CAFLGAUI)
if(c=Ctrl('VDGKIUDVJY')) ChkboxValueAssign(c,'S','N','C',1,0,'')
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
HideUI.lblids["CACODANA"]=['CJBJWUDJBI'];
HideUI.lblids["CACODICE"]=['XWLSXGXTML'];
HideUI.lblids["CACODSIN"]=['UUBZOZXMGV'];
HideUI.lblids["CADESCRI"]=['OHBEGWUQWF'];
HideUI.lblids["CAFLGOPE"]=['QHHBDXIAQH'];
HideUI.lblids["CASEGNO"]=['WBHZCJAKUA'];
HideUI.lblids["CATIPOPE"]=['MKGBXLUVZR'];
function HYBRJINCEX_Valid(e) {
SetActiveField(Ctrl('HYBRJINCEX'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('HYBRJINCEX') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('CACODICE','C',w_CACODICE,HtW(Ctrl('HYBRJINCEX').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CACODICE(HtW(Ctrl('HYBRJINCEX').value,'C'),null,e);
return l_bSetResult;
}
}
function HYBRJINCEX_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('HYBRJINCEX'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('HYBRJINCEX'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('HYBRJINCEX'),e);
}
function HYBRJINCEX_ZOOM_Click() {
}
function CHXZERJJZJ_Valid(e) {
SetActiveField(Ctrl('CHXZERJJZJ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CADESCRI','C',w_CADESCRI,HtW(Ctrl('CHXZERJJZJ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CADESCRI(HtW(Ctrl('CHXZERJJZJ').value,'C'),null,e);
return l_bSetResult;
}
}
function CHXZERJJZJ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('CHXZERJJZJ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('CHXZERJJZJ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('CHXZERJJZJ'),e);
}
function CHXZERJJZJ_ZOOM_Click() {
}
function VDOLZFWZIW_Valid(e) {
SetActiveField(Ctrl('VDOLZFWZIW'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('VDOLZFWZIW') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('CACODANA','C',w_CACODANA,HtW(Ctrl('VDOLZFWZIW').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CACODANA(HtW(Ctrl('VDOLZFWZIW').value,'C'),null,e);
return l_bSetResult;
}
}
function VDOLZFWZIW_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('VDOLZFWZIW'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('VDOLZFWZIW'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('VDOLZFWZIW'),e);
}
function VDOLZFWZIW_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('VDOLZFWZIW')),'linkview_VDOLZFWZIW','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function DMYIBOGLPB_Valid(e) {
SetActiveField(Ctrl('DMYIBOGLPB'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CACODSIN','C',w_CACODSIN,HtW(Ctrl('DMYIBOGLPB').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CACODSIN(HtW(Ctrl('DMYIBOGLPB').value,'C'),null,e);
return l_bSetResult;
}
}
function DMYIBOGLPB_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('DMYIBOGLPB'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('DMYIBOGLPB'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('DMYIBOGLPB'),e);
}
function DMYIBOGLPB_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('DMYIBOGLPB')),'linkview_DMYIBOGLPB','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function CRBMFUASKW_Valid(e) {
SetActiveField(Ctrl('CRBMFUASKW'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CASEGNO','C',w_CASEGNO,HtW(Ctrl('CRBMFUASKW').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CASEGNO(HtW(Ctrl('CRBMFUASKW').value,'C'),null,e);
return l_bSetResult;
}
}
function CRBMFUASKW_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('CRBMFUASKW'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('CRBMFUASKW'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('CRBMFUASKW'),e);
}
function RIBSWSIRGO_Valid(e) {
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('RIBSWSIRGO') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('CATIPOPE','C',w_CATIPOPE,HtW(getComboValue(Ctrl('RIBSWSIRGO')),'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CATIPOPE(HtW(getComboValue(Ctrl('RIBSWSIRGO')),'C'),null,e);
return l_bSetResult;
}
}
function RIBSWSIRGO_OnFocus(e) {
SetActiveField(Ctrl('RIBSWSIRGO'),true);
}
function RIBSWSIRGO_OnBlur(e) {
SetActiveField(Ctrl('RIBSWSIRGO'),false);
}
function BISHTFICXQ_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('CAFLGDIP','C',w_CAFLGDIP,ChkboxValueAssign(Ctrl('BISHTFICXQ'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CAFLGDIP(ChkboxValueAssign(Ctrl('BISHTFICXQ'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function BISHTFICXQ_OnFocus(e) {
SetActiveField(Ctrl('BISHTFICXQ'),true);
}
function BISHTFICXQ_OnBlur(e) {
SetActiveField(Ctrl('BISHTFICXQ'),false);
}
function CAZXFCMTRO_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('CAFLGOPE','C',w_CAFLGOPE,HtW(getComboValue(Ctrl('CAZXFCMTRO')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CAFLGOPE(HtW(getComboValue(Ctrl('CAZXFCMTRO')),'C'),null,e);
return l_bSetResult;
}
}
function CAZXFCMTRO_OnFocus(e) {
SetActiveField(Ctrl('CAZXFCMTRO'),true);
}
function CAZXFCMTRO_OnBlur(e) {
SetActiveField(Ctrl('CAZXFCMTRO'),false);
}
function VDGKIUDVJY_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('CAFLGAUI','C',w_CAFLGAUI,ChkboxValueAssign(Ctrl('VDGKIUDVJY'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CAFLGAUI(ChkboxValueAssign(Ctrl('VDGKIUDVJY'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function VDGKIUDVJY_OnFocus(e) {
SetActiveField(Ctrl('VDGKIUDVJY'),true);
}
function VDGKIUDVJY_OnBlur(e) {
SetActiveField(Ctrl('VDGKIUDVJY'),false);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function HYBRJINCEX_wrap_Valid(event) {
return HYBRJINCEX_Valid(event);
}
SPBOUILib.SetInputExit('HYBRJINCEX',HYBRJINCEX_wrap_Valid);
function HYBRJINCEX_wrap_OnFocus(event) {
return HYBRJINCEX_OnFocus(event);
}
SPBOUILib.SetInputEnter('HYBRJINCEX',HYBRJINCEX_wrap_OnFocus);
function HYBRJINCEX_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('HYBRJINCEX',HYBRJINCEX_wrap_OnKeyDown);
function HYBRJINCEX_ZOOM_setHandlers() {
function HYBRJINCEX_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?HYBRJINCEX_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('HYBRJINCEX_ZOOM',HYBRJINCEX_ZOOM_wrap_OnClick);
function HYBRJINCEX_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('HYBRJINCEX_ZOOM',HYBRJINCEX_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('HYBRJINCEX',HYBRJINCEX_ZOOM_setHandlers);
function CHXZERJJZJ_wrap_Valid(event) {
return CHXZERJJZJ_Valid(event);
}
SPBOUILib.SetInputExit('CHXZERJJZJ',CHXZERJJZJ_wrap_Valid);
function CHXZERJJZJ_wrap_OnFocus(event) {
return CHXZERJJZJ_OnFocus(event);
}
SPBOUILib.SetInputEnter('CHXZERJJZJ',CHXZERJJZJ_wrap_OnFocus);
function CHXZERJJZJ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('CHXZERJJZJ',CHXZERJJZJ_wrap_OnKeyDown);
function CHXZERJJZJ_ZOOM_setHandlers() {
function CHXZERJJZJ_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?CHXZERJJZJ_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('CHXZERJJZJ_ZOOM',CHXZERJJZJ_ZOOM_wrap_OnClick);
function CHXZERJJZJ_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('CHXZERJJZJ_ZOOM',CHXZERJJZJ_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('CHXZERJJZJ',CHXZERJJZJ_ZOOM_setHandlers);
function VDOLZFWZIW_wrap_Valid(event) {
return VDOLZFWZIW_Valid(event);
}
SPBOUILib.SetInputExit('VDOLZFWZIW',VDOLZFWZIW_wrap_Valid);
function VDOLZFWZIW_wrap_OnFocus(event) {
return VDOLZFWZIW_OnFocus(event);
}
SPBOUILib.SetInputEnter('VDOLZFWZIW',VDOLZFWZIW_wrap_OnFocus);
function VDOLZFWZIW_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('VDOLZFWZIW',VDOLZFWZIW_wrap_OnKeyDown);
function VDOLZFWZIW_ZOOM_setHandlers() {
function VDOLZFWZIW_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?VDOLZFWZIW_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('VDOLZFWZIW_ZOOM',VDOLZFWZIW_ZOOM_wrap_OnClick);
function VDOLZFWZIW_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('VDOLZFWZIW_ZOOM',VDOLZFWZIW_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('VDOLZFWZIW',VDOLZFWZIW_ZOOM_setHandlers);
function DMYIBOGLPB_wrap_Valid(event) {
return DMYIBOGLPB_Valid(event);
}
SPBOUILib.SetInputExit('DMYIBOGLPB',DMYIBOGLPB_wrap_Valid);
function DMYIBOGLPB_wrap_OnFocus(event) {
return DMYIBOGLPB_OnFocus(event);
}
SPBOUILib.SetInputEnter('DMYIBOGLPB',DMYIBOGLPB_wrap_OnFocus);
function DMYIBOGLPB_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('DMYIBOGLPB',DMYIBOGLPB_wrap_OnKeyDown);
function DMYIBOGLPB_ZOOM_setHandlers() {
function DMYIBOGLPB_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?DMYIBOGLPB_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('DMYIBOGLPB_ZOOM',DMYIBOGLPB_ZOOM_wrap_OnClick);
function DMYIBOGLPB_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('DMYIBOGLPB_ZOOM',DMYIBOGLPB_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('DMYIBOGLPB',DMYIBOGLPB_ZOOM_setHandlers);
function CRBMFUASKW_wrap_Valid(event) {
return CRBMFUASKW_Valid(event);
}
SPBOUILib.SetInputExit('CRBMFUASKW',CRBMFUASKW_wrap_Valid);
function CRBMFUASKW_wrap_OnFocus(event) {
return CRBMFUASKW_OnFocus(event);
}
SPBOUILib.SetInputEnter('CRBMFUASKW',CRBMFUASKW_wrap_OnFocus);
function CRBMFUASKW_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('CRBMFUASKW',CRBMFUASKW_wrap_OnKeyDown);
function RIBSWSIRGO_wrap_Valid(event) {
return RIBSWSIRGO_Valid(event);
}
SPBOUILib.SetComboChange('RIBSWSIRGO',RIBSWSIRGO_wrap_Valid);
function RIBSWSIRGO_wrap_OnFocus(event) {
return RIBSWSIRGO_OnFocus(event);
}
SPBOUILib.SetInputEnter('RIBSWSIRGO',RIBSWSIRGO_wrap_OnFocus);
function RIBSWSIRGO_wrap_Blur(event) {
return RIBSWSIRGO_OnBlur(event);
}
SPBOUILib.SetInputExit('RIBSWSIRGO',RIBSWSIRGO_wrap_Blur);
function BISHTFICXQ_wrap_Valid(event) {
return BISHTFICXQ_Valid(event);
}
SPBOUILib.SetCheckboxClick('BISHTFICXQ',BISHTFICXQ_wrap_Valid);
function BISHTFICXQ_wrap_OnFocus(event) {
return BISHTFICXQ_OnFocus(event);
}
SPBOUILib.SetInputEnter('BISHTFICXQ',BISHTFICXQ_wrap_OnFocus);
function BISHTFICXQ_wrap_Blur(event) {
return BISHTFICXQ_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('BISHTFICXQ',BISHTFICXQ_wrap_Blur);
function CAZXFCMTRO_wrap_Valid(event) {
return CAZXFCMTRO_Valid(event);
}
SPBOUILib.SetComboChange('CAZXFCMTRO',CAZXFCMTRO_wrap_Valid);
function CAZXFCMTRO_wrap_OnFocus(event) {
return CAZXFCMTRO_OnFocus(event);
}
SPBOUILib.SetInputEnter('CAZXFCMTRO',CAZXFCMTRO_wrap_OnFocus);
function CAZXFCMTRO_wrap_Blur(event) {
return CAZXFCMTRO_OnBlur(event);
}
SPBOUILib.SetInputExit('CAZXFCMTRO',CAZXFCMTRO_wrap_Blur);
function VDGKIUDVJY_wrap_Valid(event) {
return VDGKIUDVJY_Valid(event);
}
SPBOUILib.SetCheckboxClick('VDGKIUDVJY',VDGKIUDVJY_wrap_Valid);
function VDGKIUDVJY_wrap_OnFocus(event) {
return VDGKIUDVJY_OnFocus(event);
}
SPBOUILib.SetInputEnter('VDGKIUDVJY',VDGKIUDVJY_wrap_OnFocus);
function VDGKIUDVJY_wrap_Blur(event) {
return VDGKIUDVJY_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('VDGKIUDVJY',VDGKIUDVJY_wrap_Blur);
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
FocusFirstComponent.edit={"page_1":["CHXZERJJZJ"]};
FocusFirstComponent.query={"page_1":["HYBRJINCEX"]};
FocusFirstComponent.otherwise={"page_1":["HYBRJINCEX"]};
function Help() {
windowOpenForeground('../doc/armt_cgo_causali_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_CACODICE=a[0];
w_CADESCRI=a[1];
w_CACODANA=a[2];
w_CACODSIN=a[3];
w_CASEGNO=a[4];
w_CATIPOPE=a[5];
w_CAFLGDIP=a[6];
w_CAFLGOPE=a[7];
w_CAFLGAUI=a[8];
w_xdescauana=a[9];
w_xdescausin=a[10];
m_PrimaryKeys=['CATIPOPE','CACODANA','CACODICE'];
}
function i_PrimaryKey() {
return 'cgo_causali'+'\\'+CPLib.ToCPStr(w_CACODICE)+'\\'+CPLib.ToCPStr(w_CACODANA)+'\\'+CPLib.ToCPStr(w_CATIPOPE);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('armt_cgo_causali',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
function LinkZoomExtendedMenu() {
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_CACODANA,'C'); },"field":"CODCAU","type":"C"},{"expression":function() { return WtA(w_xdescauana,'C'); },"field":"DESCRI","type":"C"},{"expression":function() { return WtA(w_CACODSIN,'C'); },"field":"CAUSINT","type":"C"},{"expression":function() { return WtA(w_CASEGNO,'C'); },"field":"SEGNO","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbcauana','C'),"uid":"VDOLZFWZIW"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_CACODSIN,'C'); },"field":"CODVOC","type":"C"},{"expression":function() { return WtA(w_xdescausin,'C'); },"field":"DESCRIZ","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbcausin','C'),"uid":"DMYIBOGLPB"});
}
_Obli('CACODICE',0,'HYBRJINCEX',false,"1568441828")
_Obli('CADESCRI',0,'CHXZERJJZJ',false,"285808099")
_Obli('CACODANA',0,'VDOLZFWZIW',false,"215537109")
_Obli('CACODSIN',0,'DMYIBOGLPB',false,"215310487")
_Obli('CAFLGOPE',0,'CAZXFCMTRO',false,"655285418")
_Obli('CAFLGAUI',0,'VDGKIUDVJY',false,"1814624740")
_Obli('CASEGNO',0,'CRBMFUASKW',false,"7753123")
_Obli('CATIPOPE',0,'RIBSWSIRGO',false,"829257574")
_Obli('CAFLGDIP',0,'BISHTFICXQ',false,"1821093580")
