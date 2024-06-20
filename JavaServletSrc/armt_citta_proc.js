function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('FFTGLGUVGJ',function(){return WtH(w_IDBASE,'C',10,0,'')},w_IDBASE);
SPBOUILib.SetInputValue('BLYSPBZZDM',function(){return WtH(w_CITTA,'C',60,0,'')},w_CITTA);
SPBOUILib.SetInputValue('SJMGCCLAYZ',function(){return WtH(w_CAB,'C',6,0,'')},w_CAB);
SPBOUILib.SetInputValue('TWBJLTWWLG',function(){return WtH(w_PROV,'C',2,0,'')},w_PROV);
SPBOUILib.SetInputValue('PQBULAVLOC',function(){return WtH(w_CAP,'C',9,0,'')},w_CAP);
SPBOUILib.SetInputValue('ILAKLAWXVC',function(){return WtH(w_PKTBSTATI,'C',3,0,'')},w_PKTBSTATI);
SPBOUILib.SetInputValue('ZRZJZIUNUE',function(){return WtH(w_SIGLA,'C',4,0,'')},w_SIGLA);
SPBOUILib.SetInputValue('GKAEUHPNIS',function(){return WtH(w_PREF,'C',4,0,'')},w_PREF);
var tmp_BLRJACJOWE = ToHTag(AsControlValue(w_dessta));
if (Ne(e_BLRJACJOWE,tmp_BLRJACJOWE)) {
SPBOUILib.SetLabelValue('BLRJACJOWE','innerHTML',tmp_BLRJACJOWE);
e_BLRJACJOWE=tmp_BLRJACJOWE;
}
SPBOUILib.SetInputValue('UUHPGKPAGJ',function(){return WtH(w_IDISTAT,'C',6,0,'')},w_IDISTAT);
SPBOUILib.SetInputValue('QEXCLHUJUO',function(){return WtH(w_IDREGIO,'C',2,0,'')},w_IDREGIO);
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
HideUI.lblids["CAB"]=['VNZMVJPSXF'];
HideUI.lblids["CAP"]=['ZPUHOUPLTF'];
HideUI.lblids["CITTA"]=['ZBBACCQFMH'];
HideUI.lblids["IDBASE"]=['BHQLYYDMST'];
HideUI.lblids["IDISTAT"]=['HEYKAUFPDS'];
HideUI.lblids["IDREGIO"]=['MAGVRWXTMW'];
HideUI.lblids["PKTBSTATI"]=['VSMBIRITGT'];
HideUI.lblids["PREF"]=['GTVMGBMRVK'];
HideUI.lblids["PROV"]=['MNOUZKEIUA'];
HideUI.lblids["SIGLA"]=['SBEVWFPABG'];
function FFTGLGUVGJ_Valid(e) {
SetActiveField(Ctrl('FFTGLGUVGJ'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('FFTGLGUVGJ') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('IDBASE','C',w_IDBASE,HtW(Ctrl('FFTGLGUVGJ').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IDBASE(HtW(Ctrl('FFTGLGUVGJ').value,'C'),null,e);
return l_bSetResult;
}
}
function FFTGLGUVGJ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('FFTGLGUVGJ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('FFTGLGUVGJ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('FFTGLGUVGJ'),e);
}
function BLYSPBZZDM_Valid(e) {
SetActiveField(Ctrl('BLYSPBZZDM'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CITTA','C',w_CITTA,HtW(Ctrl('BLYSPBZZDM').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CITTA(HtW(Ctrl('BLYSPBZZDM').value,'C'),null,e);
return l_bSetResult;
}
}
function BLYSPBZZDM_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('BLYSPBZZDM'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('BLYSPBZZDM'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('BLYSPBZZDM'),e);
}
function SJMGCCLAYZ_Valid(e) {
SetActiveField(Ctrl('SJMGCCLAYZ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CAB','C',w_CAB,HtW(Ctrl('SJMGCCLAYZ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CAB(HtW(Ctrl('SJMGCCLAYZ').value,'C'),null,e);
return l_bSetResult;
}
}
function SJMGCCLAYZ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('SJMGCCLAYZ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('SJMGCCLAYZ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('SJMGCCLAYZ'),e);
}
function TWBJLTWWLG_Valid(e) {
SetActiveField(Ctrl('TWBJLTWWLG'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('PROV','C',w_PROV,HtW(Ctrl('TWBJLTWWLG').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PROV(HtW(Ctrl('TWBJLTWWLG').value,'C'),null,e);
return l_bSetResult;
}
}
function TWBJLTWWLG_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('TWBJLTWWLG'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('TWBJLTWWLG'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('TWBJLTWWLG'),e);
}
function PQBULAVLOC_Valid(e) {
SetActiveField(Ctrl('PQBULAVLOC'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CAP','C',w_CAP,HtW(Ctrl('PQBULAVLOC').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CAP(HtW(Ctrl('PQBULAVLOC').value,'C'),null,e);
return l_bSetResult;
}
}
function PQBULAVLOC_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('PQBULAVLOC'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('PQBULAVLOC'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('PQBULAVLOC'),e);
}
function ILAKLAWXVC_Valid(e) {
SetActiveField(Ctrl('ILAKLAWXVC'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('PKTBSTATI','C',w_PKTBSTATI,HtW(Ctrl('ILAKLAWXVC').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PKTBSTATI(HtW(Ctrl('ILAKLAWXVC').value,'C'),null,e);
return l_bSetResult;
}
}
function ILAKLAWXVC_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ILAKLAWXVC'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('ILAKLAWXVC'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ILAKLAWXVC'),e);
}
function ILAKLAWXVC_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('ILAKLAWXVC')),'linkview_ILAKLAWXVC','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function ZRZJZIUNUE_Valid(e) {
SetActiveField(Ctrl('ZRZJZIUNUE'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('SIGLA','C',w_SIGLA,HtW(Ctrl('ZRZJZIUNUE').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_SIGLA(HtW(Ctrl('ZRZJZIUNUE').value,'C'),null,e);
return l_bSetResult;
}
}
function ZRZJZIUNUE_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ZRZJZIUNUE'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('ZRZJZIUNUE'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ZRZJZIUNUE'),e);
}
function GKAEUHPNIS_Valid(e) {
SetActiveField(Ctrl('GKAEUHPNIS'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('PREF','C',w_PREF,HtW(Ctrl('GKAEUHPNIS').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PREF(HtW(Ctrl('GKAEUHPNIS').value,'C'),null,e);
return l_bSetResult;
}
}
function GKAEUHPNIS_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('GKAEUHPNIS'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('GKAEUHPNIS'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('GKAEUHPNIS'),e);
}
function UUHPGKPAGJ_Valid(e) {
SetActiveField(Ctrl('UUHPGKPAGJ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('IDISTAT','C',w_IDISTAT,HtW(Ctrl('UUHPGKPAGJ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IDISTAT(HtW(Ctrl('UUHPGKPAGJ').value,'C'),null,e);
return l_bSetResult;
}
}
function UUHPGKPAGJ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('UUHPGKPAGJ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('UUHPGKPAGJ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('UUHPGKPAGJ'),e);
}
function QEXCLHUJUO_Valid(e) {
SetActiveField(Ctrl('QEXCLHUJUO'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('IDREGIO','C',w_IDREGIO,HtW(Ctrl('QEXCLHUJUO').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IDREGIO(HtW(Ctrl('QEXCLHUJUO').value,'C'),null,e);
return l_bSetResult;
}
}
function QEXCLHUJUO_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('QEXCLHUJUO'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('QEXCLHUJUO'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('QEXCLHUJUO'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function FFTGLGUVGJ_wrap_Valid(event) {
return FFTGLGUVGJ_Valid(event);
}
SPBOUILib.SetInputExit('FFTGLGUVGJ',FFTGLGUVGJ_wrap_Valid);
function FFTGLGUVGJ_wrap_OnFocus(event) {
return FFTGLGUVGJ_OnFocus(event);
}
SPBOUILib.SetInputEnter('FFTGLGUVGJ',FFTGLGUVGJ_wrap_OnFocus);
function FFTGLGUVGJ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('FFTGLGUVGJ',FFTGLGUVGJ_wrap_OnKeyDown);
function BLYSPBZZDM_wrap_Valid(event) {
return BLYSPBZZDM_Valid(event);
}
SPBOUILib.SetInputExit('BLYSPBZZDM',BLYSPBZZDM_wrap_Valid);
function BLYSPBZZDM_wrap_OnFocus(event) {
return BLYSPBZZDM_OnFocus(event);
}
SPBOUILib.SetInputEnter('BLYSPBZZDM',BLYSPBZZDM_wrap_OnFocus);
function BLYSPBZZDM_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('BLYSPBZZDM',BLYSPBZZDM_wrap_OnKeyDown);
function SJMGCCLAYZ_wrap_Valid(event) {
return SJMGCCLAYZ_Valid(event);
}
SPBOUILib.SetInputExit('SJMGCCLAYZ',SJMGCCLAYZ_wrap_Valid);
function SJMGCCLAYZ_wrap_OnFocus(event) {
return SJMGCCLAYZ_OnFocus(event);
}
SPBOUILib.SetInputEnter('SJMGCCLAYZ',SJMGCCLAYZ_wrap_OnFocus);
function SJMGCCLAYZ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('SJMGCCLAYZ',SJMGCCLAYZ_wrap_OnKeyDown);
function TWBJLTWWLG_wrap_Valid(event) {
return TWBJLTWWLG_Valid(event);
}
SPBOUILib.SetInputExit('TWBJLTWWLG',TWBJLTWWLG_wrap_Valid);
function TWBJLTWWLG_wrap_OnFocus(event) {
return TWBJLTWWLG_OnFocus(event);
}
SPBOUILib.SetInputEnter('TWBJLTWWLG',TWBJLTWWLG_wrap_OnFocus);
function TWBJLTWWLG_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('TWBJLTWWLG',TWBJLTWWLG_wrap_OnKeyDown);
function PQBULAVLOC_wrap_Valid(event) {
return PQBULAVLOC_Valid(event);
}
SPBOUILib.SetInputExit('PQBULAVLOC',PQBULAVLOC_wrap_Valid);
function PQBULAVLOC_wrap_OnFocus(event) {
return PQBULAVLOC_OnFocus(event);
}
SPBOUILib.SetInputEnter('PQBULAVLOC',PQBULAVLOC_wrap_OnFocus);
function PQBULAVLOC_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('PQBULAVLOC',PQBULAVLOC_wrap_OnKeyDown);
function ILAKLAWXVC_wrap_Valid(event) {
return ILAKLAWXVC_Valid(event);
}
SPBOUILib.SetInputExit('ILAKLAWXVC',ILAKLAWXVC_wrap_Valid);
function ILAKLAWXVC_wrap_OnFocus(event) {
return ILAKLAWXVC_OnFocus(event);
}
SPBOUILib.SetInputEnter('ILAKLAWXVC',ILAKLAWXVC_wrap_OnFocus);
function ILAKLAWXVC_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('ILAKLAWXVC',ILAKLAWXVC_wrap_OnKeyDown);
function ILAKLAWXVC_ZOOM_setHandlers() {
function ILAKLAWXVC_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?ILAKLAWXVC_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('ILAKLAWXVC_ZOOM',ILAKLAWXVC_ZOOM_wrap_OnClick);
function ILAKLAWXVC_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('ILAKLAWXVC_ZOOM',ILAKLAWXVC_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('ILAKLAWXVC',ILAKLAWXVC_ZOOM_setHandlers);
function ZRZJZIUNUE_wrap_Valid(event) {
return ZRZJZIUNUE_Valid(event);
}
SPBOUILib.SetInputExit('ZRZJZIUNUE',ZRZJZIUNUE_wrap_Valid);
function ZRZJZIUNUE_wrap_OnFocus(event) {
return ZRZJZIUNUE_OnFocus(event);
}
SPBOUILib.SetInputEnter('ZRZJZIUNUE',ZRZJZIUNUE_wrap_OnFocus);
function ZRZJZIUNUE_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('ZRZJZIUNUE',ZRZJZIUNUE_wrap_OnKeyDown);
function GKAEUHPNIS_wrap_Valid(event) {
return GKAEUHPNIS_Valid(event);
}
SPBOUILib.SetInputExit('GKAEUHPNIS',GKAEUHPNIS_wrap_Valid);
function GKAEUHPNIS_wrap_OnFocus(event) {
return GKAEUHPNIS_OnFocus(event);
}
SPBOUILib.SetInputEnter('GKAEUHPNIS',GKAEUHPNIS_wrap_OnFocus);
function GKAEUHPNIS_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('GKAEUHPNIS',GKAEUHPNIS_wrap_OnKeyDown);
function UUHPGKPAGJ_wrap_Valid(event) {
return UUHPGKPAGJ_Valid(event);
}
SPBOUILib.SetInputExit('UUHPGKPAGJ',UUHPGKPAGJ_wrap_Valid);
function UUHPGKPAGJ_wrap_OnFocus(event) {
return UUHPGKPAGJ_OnFocus(event);
}
SPBOUILib.SetInputEnter('UUHPGKPAGJ',UUHPGKPAGJ_wrap_OnFocus);
function UUHPGKPAGJ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('UUHPGKPAGJ',UUHPGKPAGJ_wrap_OnKeyDown);
function QEXCLHUJUO_wrap_Valid(event) {
return QEXCLHUJUO_Valid(event);
}
SPBOUILib.SetInputExit('QEXCLHUJUO',QEXCLHUJUO_wrap_Valid);
function QEXCLHUJUO_wrap_OnFocus(event) {
return QEXCLHUJUO_OnFocus(event);
}
SPBOUILib.SetInputEnter('QEXCLHUJUO',QEXCLHUJUO_wrap_OnFocus);
function QEXCLHUJUO_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('QEXCLHUJUO',QEXCLHUJUO_wrap_OnKeyDown);
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
FocusFirstComponent.edit={"page_1":["BLYSPBZZDM"]};
FocusFirstComponent.query={"page_1":["FFTGLGUVGJ"]};
FocusFirstComponent.otherwise={"page_1":["FFTGLGUVGJ"]};
function Help() {
windowOpenForeground('../doc/armt_citta_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_IDBASE=a[0];
op_IDBASE=a[1];
w_CITTA=a[2];
w_CAB=a[3];
w_PROV=a[4];
w_CAP=a[5];
w_PKTBSTATI=a[6];
w_SIGLA=a[7];
w_PREF=a[8];
w_IDISTAT=a[9];
w_IDREGIO=a[10];
w_dessta=a[11];
m_PrimaryKeys=['IDBASE'];
}
function i_PrimaryKey() {
return 'tbcitta'+'\\'+CPLib.ToCPStr(w_IDBASE);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('armt_citta',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
function LinkZoomExtendedMenu() {
ExtendedMenu({"configName":WtA('','C'),"entityName":WtA('armt_stati','C'),"fldValues":[{"expression":function() { return WtA(w_PKTBSTATI,'C'); },"field":"CODSTA","type":"C"},{"expression":function() { return WtA(w_dessta,'C'); },"field":"DESCRI","type":"C"},{"expression":function() { return WtA(w_SIGLA,'C'); },"field":"SIGLA","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbstati','C'),"uid":"ILAKLAWXVC"});
}
_Obli('IDBASE',0,'FFTGLGUVGJ',false,"112851763")
_Obli('CITTA',0,'BLYSPBZZDM',false,"2063759932")
_Obli('CAB',0,'SJMGCCLAYZ',false,"18003")
_Obli('PROV',0,'TWBJLTWWLG',false,"10095365423")
_Obli('CAP',0,'PQBULAVLOC',false,"21587")
_Obli('PKTBSTATI',0,'ILAKLAWXVC',false,"7776403")
_Obli('SIGLA',0,'ZRZJZIUNUE',false,"6827491")
_Obli('PREF',0,'GKAEUHPNIS',false,"11066636183")
_Obli('IDREGIO',0,'QEXCLHUJUO',false,"1817574818")
_Obli('IDISTAT',0,'UUHPGKPAGJ',false,"11228963386")
