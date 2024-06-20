function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('LEUKOZNIUN',function(){return WtH(w_CODSTA,'C',3,0,'')},w_CODSTA);
SPBOUILib.SetInputValue('FREJQSVVRY',function(){return WtH(w_DESCRI,'C',30,0,'')},w_DESCRI);
SPBOUILib.SetInputValue('HQOQQTARBM',function(){return WtH(w_SIGLA,'C',4,0,'')},w_SIGLA);
SPBOUILib.SetInputValue('GPSKHVYSHP',function(){return WtH(w_ISO,'C',3,0,'')},w_ISO);
SPBOUILib.SetInputValue('UXSTIMUVDG',function(){return WtH(w_ISO2,'C',2,0,'')},w_ISO2);
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
HideUI.lblids["CODSTA"]=['HOUHLXOLDR'];
HideUI.lblids["DESCRI"]=['ZAIQYKJBNV'];
HideUI.lblids["ISO"]=['IGZBNPEWZZ'];
HideUI.lblids["ISO2"]=['NQKCMHCAFD'];
HideUI.lblids["SIGLA"]=['IHQTODRAUU'];
function LEUKOZNIUN_Valid(e) {
SetActiveField(Ctrl('LEUKOZNIUN'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('LEUKOZNIUN') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('CODSTA','C',w_CODSTA,HtW(Ctrl('LEUKOZNIUN').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODSTA(HtW(Ctrl('LEUKOZNIUN').value,'C'),null,e);
return l_bSetResult;
}
}
function LEUKOZNIUN_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('LEUKOZNIUN'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('LEUKOZNIUN'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('LEUKOZNIUN'),e);
}
function FREJQSVVRY_Valid(e) {
SetActiveField(Ctrl('FREJQSVVRY'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DESCRI','C',w_DESCRI,HtW(Ctrl('FREJQSVVRY').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DESCRI(HtW(Ctrl('FREJQSVVRY').value,'C'),null,e);
return l_bSetResult;
}
}
function FREJQSVVRY_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('FREJQSVVRY'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('FREJQSVVRY'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('FREJQSVVRY'),e);
}
function HQOQQTARBM_Valid(e) {
SetActiveField(Ctrl('HQOQQTARBM'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('SIGLA','C',w_SIGLA,HtW(Ctrl('HQOQQTARBM').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_SIGLA(HtW(Ctrl('HQOQQTARBM').value,'C'),null,e);
return l_bSetResult;
}
}
function HQOQQTARBM_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('HQOQQTARBM'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('HQOQQTARBM'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('HQOQQTARBM'),e);
}
function GPSKHVYSHP_Valid(e) {
SetActiveField(Ctrl('GPSKHVYSHP'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('ISO','C',w_ISO,HtW(Ctrl('GPSKHVYSHP').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ISO(HtW(Ctrl('GPSKHVYSHP').value,'C'),null,e);
return l_bSetResult;
}
}
function GPSKHVYSHP_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('GPSKHVYSHP'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('GPSKHVYSHP'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('GPSKHVYSHP'),e);
}
function UXSTIMUVDG_Valid(e) {
SetActiveField(Ctrl('UXSTIMUVDG'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('ISO2','C',w_ISO2,HtW(Ctrl('UXSTIMUVDG').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ISO2(HtW(Ctrl('UXSTIMUVDG').value,'C'),null,e);
return l_bSetResult;
}
}
function UXSTIMUVDG_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('UXSTIMUVDG'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('UXSTIMUVDG'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('UXSTIMUVDG'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function LEUKOZNIUN_wrap_Valid(event) {
return LEUKOZNIUN_Valid(event);
}
SPBOUILib.SetInputExit('LEUKOZNIUN',LEUKOZNIUN_wrap_Valid);
function LEUKOZNIUN_wrap_OnFocus(event) {
return LEUKOZNIUN_OnFocus(event);
}
SPBOUILib.SetInputEnter('LEUKOZNIUN',LEUKOZNIUN_wrap_OnFocus);
function LEUKOZNIUN_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('LEUKOZNIUN',LEUKOZNIUN_wrap_OnKeyDown);
function FREJQSVVRY_wrap_Valid(event) {
return FREJQSVVRY_Valid(event);
}
SPBOUILib.SetInputExit('FREJQSVVRY',FREJQSVVRY_wrap_Valid);
function FREJQSVVRY_wrap_OnFocus(event) {
return FREJQSVVRY_OnFocus(event);
}
SPBOUILib.SetInputEnter('FREJQSVVRY',FREJQSVVRY_wrap_OnFocus);
function FREJQSVVRY_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('FREJQSVVRY',FREJQSVVRY_wrap_OnKeyDown);
function HQOQQTARBM_wrap_Valid(event) {
return HQOQQTARBM_Valid(event);
}
SPBOUILib.SetInputExit('HQOQQTARBM',HQOQQTARBM_wrap_Valid);
function HQOQQTARBM_wrap_OnFocus(event) {
return HQOQQTARBM_OnFocus(event);
}
SPBOUILib.SetInputEnter('HQOQQTARBM',HQOQQTARBM_wrap_OnFocus);
function HQOQQTARBM_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('HQOQQTARBM',HQOQQTARBM_wrap_OnKeyDown);
function GPSKHVYSHP_wrap_Valid(event) {
return GPSKHVYSHP_Valid(event);
}
SPBOUILib.SetInputExit('GPSKHVYSHP',GPSKHVYSHP_wrap_Valid);
function GPSKHVYSHP_wrap_OnFocus(event) {
return GPSKHVYSHP_OnFocus(event);
}
SPBOUILib.SetInputEnter('GPSKHVYSHP',GPSKHVYSHP_wrap_OnFocus);
function GPSKHVYSHP_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('GPSKHVYSHP',GPSKHVYSHP_wrap_OnKeyDown);
function UXSTIMUVDG_wrap_Valid(event) {
return UXSTIMUVDG_Valid(event);
}
SPBOUILib.SetInputExit('UXSTIMUVDG',UXSTIMUVDG_wrap_Valid);
function UXSTIMUVDG_wrap_OnFocus(event) {
return UXSTIMUVDG_OnFocus(event);
}
SPBOUILib.SetInputEnter('UXSTIMUVDG',UXSTIMUVDG_wrap_OnFocus);
function UXSTIMUVDG_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('UXSTIMUVDG',UXSTIMUVDG_wrap_OnKeyDown);
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
FocusFirstComponent.edit={"page_1":["FREJQSVVRY"]};
FocusFirstComponent.query={"page_1":["LEUKOZNIUN"]};
FocusFirstComponent.otherwise={"page_1":["LEUKOZNIUN"]};
function Help() {
windowOpenForeground('../doc/armt_stati_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_CODSTA=a[0];
w_DESCRI=a[1];
mlt_DESCRI=a[2];
ow_DESCRI=a[3];
w_SIGLA=a[4];
w_ISO=a[5];
w_ISO2=a[6];
l_bEditMlt=a[7];
m_PrimaryKeys=['CODSTA'];
}
function i_PrimaryKey() {
return 'tbstati'+'\\'+CPLib.ToCPStr(w_CODSTA);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('armt_stati',m_cSelectedPage);
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
_Obli('CODSTA',0,'LEUKOZNIUN',true,"112851763")
_Obli('DESCRI',0,'FREJQSVVRY',false,"285808099")
_Obli('SIGLA',0,'HQOQQTARBM',false,"6827491")
_Obli('ISO',0,'GPSKHVYSHP',false)
_Obli('ISO2',0,'UXSTIMUVDG',false)
