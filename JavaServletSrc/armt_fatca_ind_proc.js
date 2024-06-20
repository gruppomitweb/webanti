function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('NSYKFFGVCJ',function(){return WtH(w_CONNES,'C',16,0,'')},w_CONNES);
SPBOUILib.SetInputValue('YZWHCBENDD',function(){return WtH(w_IDBASE,'C',10,0,'')},w_IDBASE);
SPBOUILib.SetInputValue('NMIXZFCBVE',function(){return WtH(w_COUNTRYCOD,'C',2,0,'')},w_COUNTRYCOD);
SPBOUILib.SetInputValue('KBVBICTKSZ',function(){return WtH(w_ADDRESSTYP,'C',7,0,'')},w_ADDRESSTYP);
SPBOUILib.SetInputValue('JNGCPOLBGY',function(){return WtH(w_STREET,'C',100,0,'')},w_STREET);
SPBOUILib.SetInputValue('WBPDQKOVOJ',function(){return WtH(w_BUILDINGID,'C',30,0,'')},w_BUILDINGID);
SPBOUILib.SetInputValue('UOIIIFCGSL',function(){return WtH(w_SUITEIDENT,'C',30,0,'')},w_SUITEIDENT);
SPBOUILib.SetInputValue('IIONPQRDRP',function(){return WtH(w_FLOORIDENT,'C',20,0,'')},w_FLOORIDENT);
SPBOUILib.SetInputValue('FVAYUICDDF',function(){return WtH(w_DISTRICTNA,'C',30,0,'')},w_DISTRICTNA);
SPBOUILib.SetInputValue('XKZMDIETYG',function(){return WtH(w_POB,'C',30,0,'')},w_POB);
SPBOUILib.SetInputValue('FBHQWXLZDC',function(){return WtH(w_POSTCODE,'C',20,0,'')},w_POSTCODE);
SPBOUILib.SetInputValue('IDSOGPRKYJ',function(){return WtH(w_CITY,'C',100,0,'')},w_CITY);
SPBOUILib.SetInputValue('DUDFYTNMSV',function(){return WtH(w_COUNTRYSUB,'C',30,0,'')},w_COUNTRYSUB);
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
HideUI.lblids["ADDRESSTYP"]=['RQMEUSGEWM'];
HideUI.lblids["BUILDINGID"]=['EUNAUTWRZV'];
HideUI.lblids["CITY"]=['ELCGMAAENZ'];
HideUI.lblids["CONNES"]=['WGSFLCCSAC'];
HideUI.lblids["COUNTRYCOD"]=['HPXONYPVSI'];
HideUI.lblids["DISTRICTNA"]=['GZHSAXEFQZ'];
HideUI.lblids["FLOORIDENT"]=['HYRBQJRPZH'];
HideUI.lblids["IDBASE"]=['DYHSGULRMW'];
HideUI.lblids["POSTCODE"]=['MWMPLUCQGE'];
HideUI.lblids["STREET"]=['MZULSFSPHL'];
HideUI.lblids["SUITEIDENT"]=['DPOTSDMFKS'];
function NSYKFFGVCJ_Valid(e) {
SetActiveField(Ctrl('NSYKFFGVCJ'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('NSYKFFGVCJ') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('CONNES','C',w_CONNES,HtW(Ctrl('NSYKFFGVCJ').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CONNES(HtW(Ctrl('NSYKFFGVCJ').value,'C'),null,e);
return l_bSetResult;
}
}
function NSYKFFGVCJ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('NSYKFFGVCJ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('NSYKFFGVCJ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('NSYKFFGVCJ'),e);
}
function YZWHCBENDD_Valid(e) {
SetActiveField(Ctrl('YZWHCBENDD'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('IDBASE','C',w_IDBASE,HtW(Ctrl('YZWHCBENDD').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IDBASE(HtW(Ctrl('YZWHCBENDD').value,'C'),null,e);
return l_bSetResult;
}
}
function YZWHCBENDD_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('YZWHCBENDD'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('YZWHCBENDD'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('YZWHCBENDD'),e);
}
function NMIXZFCBVE_Valid(e) {
SetActiveField(Ctrl('NMIXZFCBVE'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('COUNTRYCOD','C',w_COUNTRYCOD,HtW(Ctrl('NMIXZFCBVE').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_COUNTRYCOD(HtW(Ctrl('NMIXZFCBVE').value,'C'),null,e);
return l_bSetResult;
}
}
function NMIXZFCBVE_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('NMIXZFCBVE'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('NMIXZFCBVE'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('NMIXZFCBVE'),e);
}
function KBVBICTKSZ_Valid(e) {
SetActiveField(Ctrl('KBVBICTKSZ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('ADDRESSTYP','C',w_ADDRESSTYP,HtW(Ctrl('KBVBICTKSZ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ADDRESSTYP(HtW(Ctrl('KBVBICTKSZ').value,'C'),null,e);
return l_bSetResult;
}
}
function KBVBICTKSZ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('KBVBICTKSZ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('KBVBICTKSZ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('KBVBICTKSZ'),e);
}
function JNGCPOLBGY_Valid(e) {
SetActiveField(Ctrl('JNGCPOLBGY'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('STREET','C',w_STREET,HtW(Ctrl('JNGCPOLBGY').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_STREET(HtW(Ctrl('JNGCPOLBGY').value,'C'),null,e);
return l_bSetResult;
}
}
function JNGCPOLBGY_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('JNGCPOLBGY'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('JNGCPOLBGY'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('JNGCPOLBGY'),e);
}
function WBPDQKOVOJ_Valid(e) {
SetActiveField(Ctrl('WBPDQKOVOJ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('BUILDINGID','C',w_BUILDINGID,HtW(Ctrl('WBPDQKOVOJ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_BUILDINGID(HtW(Ctrl('WBPDQKOVOJ').value,'C'),null,e);
return l_bSetResult;
}
}
function WBPDQKOVOJ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('WBPDQKOVOJ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('WBPDQKOVOJ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('WBPDQKOVOJ'),e);
}
function UOIIIFCGSL_Valid(e) {
SetActiveField(Ctrl('UOIIIFCGSL'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('SUITEIDENT','C',w_SUITEIDENT,HtW(Ctrl('UOIIIFCGSL').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_SUITEIDENT(HtW(Ctrl('UOIIIFCGSL').value,'C'),null,e);
return l_bSetResult;
}
}
function UOIIIFCGSL_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('UOIIIFCGSL'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('UOIIIFCGSL'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('UOIIIFCGSL'),e);
}
function IIONPQRDRP_Valid(e) {
SetActiveField(Ctrl('IIONPQRDRP'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('FLOORIDENT','C',w_FLOORIDENT,HtW(Ctrl('IIONPQRDRP').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FLOORIDENT(HtW(Ctrl('IIONPQRDRP').value,'C'),null,e);
return l_bSetResult;
}
}
function IIONPQRDRP_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('IIONPQRDRP'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('IIONPQRDRP'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('IIONPQRDRP'),e);
}
function FVAYUICDDF_Valid(e) {
SetActiveField(Ctrl('FVAYUICDDF'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DISTRICTNA','C',w_DISTRICTNA,HtW(Ctrl('FVAYUICDDF').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DISTRICTNA(HtW(Ctrl('FVAYUICDDF').value,'C'),null,e);
return l_bSetResult;
}
}
function FVAYUICDDF_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('FVAYUICDDF'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('FVAYUICDDF'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('FVAYUICDDF'),e);
}
function XKZMDIETYG_Valid(e) {
SetActiveField(Ctrl('XKZMDIETYG'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('POB','C',w_POB,HtW(Ctrl('XKZMDIETYG').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_POB(HtW(Ctrl('XKZMDIETYG').value,'C'),null,e);
return l_bSetResult;
}
}
function XKZMDIETYG_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('XKZMDIETYG'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('XKZMDIETYG'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('XKZMDIETYG'),e);
}
function FBHQWXLZDC_Valid(e) {
SetActiveField(Ctrl('FBHQWXLZDC'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('POSTCODE','C',w_POSTCODE,HtW(Ctrl('FBHQWXLZDC').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_POSTCODE(HtW(Ctrl('FBHQWXLZDC').value,'C'),null,e);
return l_bSetResult;
}
}
function FBHQWXLZDC_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('FBHQWXLZDC'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('FBHQWXLZDC'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('FBHQWXLZDC'),e);
}
function IDSOGPRKYJ_Valid(e) {
SetActiveField(Ctrl('IDSOGPRKYJ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CITY','C',w_CITY,HtW(Ctrl('IDSOGPRKYJ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CITY(HtW(Ctrl('IDSOGPRKYJ').value,'C'),null,e);
return l_bSetResult;
}
}
function IDSOGPRKYJ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('IDSOGPRKYJ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('IDSOGPRKYJ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('IDSOGPRKYJ'),e);
}
function DUDFYTNMSV_Valid(e) {
SetActiveField(Ctrl('DUDFYTNMSV'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('COUNTRYSUB','C',w_COUNTRYSUB,HtW(Ctrl('DUDFYTNMSV').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_COUNTRYSUB(HtW(Ctrl('DUDFYTNMSV').value,'C'),null,e);
return l_bSetResult;
}
}
function DUDFYTNMSV_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('DUDFYTNMSV'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('DUDFYTNMSV'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('DUDFYTNMSV'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function NSYKFFGVCJ_wrap_Valid(event) {
return NSYKFFGVCJ_Valid(event);
}
SPBOUILib.SetInputExit('NSYKFFGVCJ',NSYKFFGVCJ_wrap_Valid);
function NSYKFFGVCJ_wrap_OnFocus(event) {
return NSYKFFGVCJ_OnFocus(event);
}
SPBOUILib.SetInputEnter('NSYKFFGVCJ',NSYKFFGVCJ_wrap_OnFocus);
function NSYKFFGVCJ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('NSYKFFGVCJ',NSYKFFGVCJ_wrap_OnKeyDown);
function YZWHCBENDD_wrap_Valid(event) {
return YZWHCBENDD_Valid(event);
}
SPBOUILib.SetInputExit('YZWHCBENDD',YZWHCBENDD_wrap_Valid);
function YZWHCBENDD_wrap_OnFocus(event) {
return YZWHCBENDD_OnFocus(event);
}
SPBOUILib.SetInputEnter('YZWHCBENDD',YZWHCBENDD_wrap_OnFocus);
function YZWHCBENDD_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('YZWHCBENDD',YZWHCBENDD_wrap_OnKeyDown);
function NMIXZFCBVE_wrap_Valid(event) {
return NMIXZFCBVE_Valid(event);
}
SPBOUILib.SetInputExit('NMIXZFCBVE',NMIXZFCBVE_wrap_Valid);
function NMIXZFCBVE_wrap_OnFocus(event) {
return NMIXZFCBVE_OnFocus(event);
}
SPBOUILib.SetInputEnter('NMIXZFCBVE',NMIXZFCBVE_wrap_OnFocus);
function NMIXZFCBVE_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('NMIXZFCBVE',NMIXZFCBVE_wrap_OnKeyDown);
function KBVBICTKSZ_wrap_Valid(event) {
return KBVBICTKSZ_Valid(event);
}
SPBOUILib.SetInputExit('KBVBICTKSZ',KBVBICTKSZ_wrap_Valid);
function KBVBICTKSZ_wrap_OnFocus(event) {
return KBVBICTKSZ_OnFocus(event);
}
SPBOUILib.SetInputEnter('KBVBICTKSZ',KBVBICTKSZ_wrap_OnFocus);
function KBVBICTKSZ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('KBVBICTKSZ',KBVBICTKSZ_wrap_OnKeyDown);
function JNGCPOLBGY_wrap_Valid(event) {
return JNGCPOLBGY_Valid(event);
}
SPBOUILib.SetInputExit('JNGCPOLBGY',JNGCPOLBGY_wrap_Valid);
function JNGCPOLBGY_wrap_OnFocus(event) {
return JNGCPOLBGY_OnFocus(event);
}
SPBOUILib.SetInputEnter('JNGCPOLBGY',JNGCPOLBGY_wrap_OnFocus);
function JNGCPOLBGY_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('JNGCPOLBGY',JNGCPOLBGY_wrap_OnKeyDown);
function WBPDQKOVOJ_wrap_Valid(event) {
return WBPDQKOVOJ_Valid(event);
}
SPBOUILib.SetInputExit('WBPDQKOVOJ',WBPDQKOVOJ_wrap_Valid);
function WBPDQKOVOJ_wrap_OnFocus(event) {
return WBPDQKOVOJ_OnFocus(event);
}
SPBOUILib.SetInputEnter('WBPDQKOVOJ',WBPDQKOVOJ_wrap_OnFocus);
function WBPDQKOVOJ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('WBPDQKOVOJ',WBPDQKOVOJ_wrap_OnKeyDown);
function UOIIIFCGSL_wrap_Valid(event) {
return UOIIIFCGSL_Valid(event);
}
SPBOUILib.SetInputExit('UOIIIFCGSL',UOIIIFCGSL_wrap_Valid);
function UOIIIFCGSL_wrap_OnFocus(event) {
return UOIIIFCGSL_OnFocus(event);
}
SPBOUILib.SetInputEnter('UOIIIFCGSL',UOIIIFCGSL_wrap_OnFocus);
function UOIIIFCGSL_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('UOIIIFCGSL',UOIIIFCGSL_wrap_OnKeyDown);
function IIONPQRDRP_wrap_Valid(event) {
return IIONPQRDRP_Valid(event);
}
SPBOUILib.SetInputExit('IIONPQRDRP',IIONPQRDRP_wrap_Valid);
function IIONPQRDRP_wrap_OnFocus(event) {
return IIONPQRDRP_OnFocus(event);
}
SPBOUILib.SetInputEnter('IIONPQRDRP',IIONPQRDRP_wrap_OnFocus);
function IIONPQRDRP_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('IIONPQRDRP',IIONPQRDRP_wrap_OnKeyDown);
function FVAYUICDDF_wrap_Valid(event) {
return FVAYUICDDF_Valid(event);
}
SPBOUILib.SetInputExit('FVAYUICDDF',FVAYUICDDF_wrap_Valid);
function FVAYUICDDF_wrap_OnFocus(event) {
return FVAYUICDDF_OnFocus(event);
}
SPBOUILib.SetInputEnter('FVAYUICDDF',FVAYUICDDF_wrap_OnFocus);
function FVAYUICDDF_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('FVAYUICDDF',FVAYUICDDF_wrap_OnKeyDown);
function XKZMDIETYG_wrap_Valid(event) {
return XKZMDIETYG_Valid(event);
}
SPBOUILib.SetInputExit('XKZMDIETYG',XKZMDIETYG_wrap_Valid);
function XKZMDIETYG_wrap_OnFocus(event) {
return XKZMDIETYG_OnFocus(event);
}
SPBOUILib.SetInputEnter('XKZMDIETYG',XKZMDIETYG_wrap_OnFocus);
function XKZMDIETYG_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('XKZMDIETYG',XKZMDIETYG_wrap_OnKeyDown);
function FBHQWXLZDC_wrap_Valid(event) {
return FBHQWXLZDC_Valid(event);
}
SPBOUILib.SetInputExit('FBHQWXLZDC',FBHQWXLZDC_wrap_Valid);
function FBHQWXLZDC_wrap_OnFocus(event) {
return FBHQWXLZDC_OnFocus(event);
}
SPBOUILib.SetInputEnter('FBHQWXLZDC',FBHQWXLZDC_wrap_OnFocus);
function FBHQWXLZDC_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('FBHQWXLZDC',FBHQWXLZDC_wrap_OnKeyDown);
function IDSOGPRKYJ_wrap_Valid(event) {
return IDSOGPRKYJ_Valid(event);
}
SPBOUILib.SetInputExit('IDSOGPRKYJ',IDSOGPRKYJ_wrap_Valid);
function IDSOGPRKYJ_wrap_OnFocus(event) {
return IDSOGPRKYJ_OnFocus(event);
}
SPBOUILib.SetInputEnter('IDSOGPRKYJ',IDSOGPRKYJ_wrap_OnFocus);
function IDSOGPRKYJ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('IDSOGPRKYJ',IDSOGPRKYJ_wrap_OnKeyDown);
function DUDFYTNMSV_wrap_Valid(event) {
return DUDFYTNMSV_Valid(event);
}
SPBOUILib.SetInputExit('DUDFYTNMSV',DUDFYTNMSV_wrap_Valid);
function DUDFYTNMSV_wrap_OnFocus(event) {
return DUDFYTNMSV_OnFocus(event);
}
SPBOUILib.SetInputEnter('DUDFYTNMSV',DUDFYTNMSV_wrap_OnFocus);
function DUDFYTNMSV_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('DUDFYTNMSV',DUDFYTNMSV_wrap_OnKeyDown);
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
m_oFather.i_last_focused_item='child_armt_fatca_ind';
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
}
m_nLastError=0;
m_cLastMsgError='';
}
FocusFirstComponent.edit={"page_1":["YZWHCBENDD"]};
FocusFirstComponent.query={"page_1":["NSYKFFGVCJ"]};
FocusFirstComponent.otherwise={"page_1":["NSYKFFGVCJ"]};
function Help() {
windowOpenForeground('../doc/armt_fatca_ind_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_CONNES=a[0];
w_IDBASE=a[1];
w_COUNTRYCOD=a[2];
w_ADDRESSTYP=a[3];
w_STREET=a[4];
w_BUILDINGID=a[5];
w_SUITEIDENT=a[6];
w_FLOORIDENT=a[7];
w_DISTRICTNA=a[8];
w_POB=a[9];
w_POSTCODE=a[10];
w_CITY=a[11];
w_COUNTRYSUB=a[12];
m_PrimaryKeys=['CONNES'];
}
function i_PrimaryKey() {
return 'fatca_ind'+'\\'+CPLib.ToCPStr(w_CONNES);
}
function CheckZone(me) {
if (IsWndAccessible(window['m_oFather'])) {
return m_oFather.CheckZone('child_armt_fatca_ind');
}
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('armt_fatca_ind',m_cSelectedPage);
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
_Obli('CONNES',0,'NSYKFFGVCJ',false,"10847988462")
_Obli('IDBASE',0,'YZWHCBENDD',false,"78075529")
_Obli('COUNTRYCOD',0,'NMIXZFCBVE',false,"11381248851")
_Obli('ADDRESSTYP',0,'KBVBICTKSZ',false,"11171687571")
_Obli('STREET',0,'JNGCPOLBGY',false,"554236824")
_Obli('BUILDINGID',0,'WBPDQKOVOJ',false,"10361606416")
_Obli('SUITEIDENT',0,'UOIIIFCGSL',false,"10133933798")
_Obli('FLOORIDENT',0,'IIONPQRDRP',false,"612350581")
_Obli('DISTRICTNA',0,'FVAYUICDDF',false,"12123334500")
_Obli('POB',0,'XKZMDIETYG',false)
_Obli('POSTCODE',0,'FBHQWXLZDC',false,"763135698")
_Obli('CITY',0,'IDSOGPRKYJ',false,"15186643")
_Obli('COUNTRYSUB',0,'DUDFYTNMSV',false)
